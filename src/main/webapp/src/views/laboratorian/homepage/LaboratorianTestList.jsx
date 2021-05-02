import React, {useEffect, useState} from 'react';
import {makeStyles, withStyles} from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import axios from "axios";
import {ButtonGroup} from "@material-ui/core";
import Button from "@material-ui/core/Button";
import Typography from "@material-ui/core/Typography";
import {useHistory} from "react-router-dom";

const StyledTableCell = withStyles((theme) => ({
    head: {
        backgroundColor: theme.palette.common.white,
        fontWeight: "bold"
    },
    body: {
        fontSize: 14,
    },
}))(TableCell);

const StyledTableRow = withStyles((theme) => ({
    root: {
        '&:nth-of-type(odd)': {
            backgroundColor: theme.palette.action.hover,
        },
    },
}))(TableRow);

const useStyles = makeStyles({
    table: {
        minWidth: 700,
    },
});

export default function LaboratorianTestList(props) {
    const classes = useStyles();
    const [tests, setTests] = useState([]);
    const history = useHistory();

    useEffect(() => {
        let userDetails = JSON.parse(localStorage.getItem('user'));
        axios.get(`http://localhost:8080/testRequest/getByLaboratorian/${userDetails.laboratorian_id}`).then(response => {
            console.log(response.data);
            setTests(response.data);
        })
    },[])

    return (
        <>
            <Typography component="h2" variant="h6" color="primary" gutterBottom>
                Assigned Tests
            </Typography>
            <TableContainer component={Paper}>
                <Table className={classes.table} aria-label="customized table">
                    <TableHead>
                        <TableRow>
                            <StyledTableCell>Status</StyledTableCell>
                            <StyledTableCell>Request Date Time</StyledTableCell>
                            <StyledTableCell>Test Name</StyledTableCell>
                            <StyledTableCell>Actions</StyledTableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {tests.map((row) => (
                            <StyledTableRow key={row.request_id}>
                                <StyledTableCell>{row.status}</StyledTableCell>
                                <StyledTableCell >
                                    {new Date(Date.parse(row.request_date_time)).toLocaleString()}
                                </StyledTableCell>
                                <StyledTableCell>{row.name}</StyledTableCell>
                                <StyledTableCell>
                                    <ButtonGroup color="primary" variant="outlined">
                                        <Button onClick={() =>
                                            history.push(`/laboratorian/test/${row.request_id}/${row.test_type_id}`) }>
                                            Process
                                        </Button>
                                    </ButtonGroup>
                                </StyledTableCell>
                            </StyledTableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
        </>

    );
}