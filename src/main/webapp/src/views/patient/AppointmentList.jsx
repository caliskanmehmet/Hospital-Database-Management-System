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

export default function AppointmentList(props) {
    const classes = useStyles();
    const [appointments, setAppointments] = useState([]);

    useEffect(() => {
        let userDetails = JSON.parse(localStorage.getItem('user'));
        axios.get(`http://localhost:8080/appointment/getByPatient/${userDetails.patient_id}`).
        then(response => {
            console.log(response.data);
            setAppointments(response.data);
        })
    },[])

    return (
        <TableContainer component={Paper}>
            <Table className={classes.table} aria-label="customized table">
                <TableHead>
                    <TableRow>
                        <StyledTableCell>Appointment Date and Time</StyledTableCell>
                        <StyledTableCell>Appointment Status</StyledTableCell>
                        <StyledTableCell>Doctor Name</StyledTableCell>
                        <StyledTableCell>Clinic</StyledTableCell>
                        <StyledTableCell>Detailed Information</StyledTableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {appointments.map((row) => (
                        <StyledTableRow key={row.app_id}>
                            <StyledTableCell >
                                {row.app_date + " " + row.app_time}
                            </StyledTableCell>
                            <StyledTableCell>{row.app_status}</StyledTableCell>
                            <StyledTableCell>
                                {row.first_name + " " + row.middle_name + " " + row.last_name}
                            </StyledTableCell>
                            <StyledTableCell>{row.name}</StyledTableCell>
                            <StyledTableCell>
                                <ButtonGroup color="primary" variant="outlined">
                                    <Button disabled={row.app_status === "Pending"}>
                                        Symptoms
                                    </Button>
                                    <Button disabled={row.app_status === "Pending"}>
                                        Diseases
                                    </Button>
                                </ButtonGroup>
                            </StyledTableCell>
                        </StyledTableRow>
                    ))}
                </TableBody>
            </Table>
        </TableContainer>
    );
}