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
import Typography from "@material-ui/core/Typography";
import RequestTestDialog from "./RequestTestDialog";
import TestResultsDialog from "./TestResultsDialog";
import AddSymptomDialog from "./AddSymptomDialog";
import DiagnoseDialog from "./DiagnoseDialog";

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

export default function DoctorAppointmentList(props) {
    const classes = useStyles();
    const [appointments, setAppointments] = useState([]);

    useEffect(() => {
        let userDetails = JSON.parse(localStorage.getItem('user'));
        axios.get(`http://localhost:8080/appointment/getByDoctor/${userDetails.doctor_id}`).then(response => {
            console.log(response.data);
            setAppointments(response.data);
        })
    },[])

    return (
        <>
            <Typography component="h2" variant="h6" color="primary" gutterBottom>
                Current Appointments
            </Typography>
            <TableContainer component={Paper}>
                <Table className={classes.table} aria-label="customized table">
                    <TableHead>
                        <TableRow>
                            <StyledTableCell>Appointment Date</StyledTableCell>
                            <StyledTableCell>Appointment Status</StyledTableCell>
                            <StyledTableCell>Patient Name</StyledTableCell>
                            <StyledTableCell>Clinic</StyledTableCell>
                            <StyledTableCell>Actions</StyledTableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {appointments.map((row) => (
                            <StyledTableRow key={row.app_id}>
                                <StyledTableCell >
                                    {new Date(Date.parse(row.app_date)).toLocaleString().substring(0, 10)}
                                </StyledTableCell>
                                <StyledTableCell>{row.app_status}</StyledTableCell>
                                <StyledTableCell>
                                    {row.first_name + " " + row.middle_name + " " + row.last_name}
                                </StyledTableCell>
                                <StyledTableCell>{row.name}</StyledTableCell>
                                <StyledTableCell>
                                    <ButtonGroup color="primary" variant="outlined">
                                        <RequestTestDialog
                                            app_id={row.app_id}
                                            disabled={row.app_status === "Finalized" || row.app_status === "Evaluated"}
                                            update={props.update}
                                            setUpdate={props.setUpdate}
                                        />
                                        <TestResultsDialog app_id={row.app_id}/>
                                        <AddSymptomDialog app_id={row.app_id} disabled={row.app_status === "Finalized" || row.app_status === "Evaluated"}/>
                                        <DiagnoseDialog app_id={row.app_id} disabled={row.app_status === "Finalized" || row.app_status === "Evaluated"} />
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

// Pending --> Test requested --> Test finished --> Finalized --> Evaluated
// Pending --> Finalized --> Evaluated