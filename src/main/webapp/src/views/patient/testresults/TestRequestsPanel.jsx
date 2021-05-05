import React, {useEffect} from "react"
import Typography from "@material-ui/core/Typography";
import Paper from "@material-ui/core/Paper";
import Table from "@material-ui/core/Table";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import TableBody from "@material-ui/core/TableBody";
import {ButtonGroup} from "@material-ui/core";
import Button from "@material-ui/core/Button";
import TableContainer from "@material-ui/core/TableContainer";
import axios from "axios";
import {makeStyles, withStyles} from "@material-ui/core/styles";
import TableCell from "@material-ui/core/TableCell";
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

export default function TestRequestsPanel(props) {
    const [testRequests, setTestRequests] = React.useState([]);
    const classes = useStyles();
    const history = useHistory();

    // http://localhost:8080/testRequest/getByPatient/1000

    useEffect(() => {
        let userDetails = JSON.parse(localStorage.getItem('user'));
        axios.get(`http://localhost:8080/testRequest/getByPatient/${userDetails.patient_id}`).then(response => {
            console.log(response.data);
            setTestRequests(response.data);
        })
    },[])

    return(
        <div>
            <Typography variant="h5" gutterBottom>
                Test Results
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
                        {testRequests.map((row) => (
                            <StyledTableRow key={row.request_id}>
                                <StyledTableCell>{row.status === 'Assigned' ? 'Waiting' : row.status}</StyledTableCell>
                                <StyledTableCell>
                                    {new Date(Date.parse(row.request_date_time)).toLocaleString()}
                                </StyledTableCell>
                                <StyledTableCell>{row.name}</StyledTableCell>
                                <StyledTableCell>
                                    <ButtonGroup color="primary" variant="outlined">
                                        <Button onClick={() =>
                                            history.push(`/patient/test/${row.request_id}/${row.test_type_id}`)}
                                            disabled={row.status !== 'Finalized'}
                                        >
                                            Results
                                        </Button>
                                    </ButtonGroup>
                                </StyledTableCell>
                            </StyledTableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
        </div>
    )
}