import React, {useEffect} from 'react';
import {makeStyles, withStyles} from '@material-ui/core/styles';
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';
import FormControl from '@material-ui/core/FormControl';
import Select from '@material-ui/core/Select';
import Button from '@material-ui/core/Button';
import axios from "axios";
import Container from "@material-ui/core/Container";
import {KeyboardDatePicker, MuiPickersUtilsProvider} from '@material-ui/pickers';
import Grid from '@material-ui/core/Grid';
import DateFnsUtils from '@date-io/date-fns';
import {FormGroup} from "@material-ui/core";
import Typography from "@material-ui/core/Typography";
import TableContainer from "@material-ui/core/TableContainer";
import Paper from "@material-ui/core/Paper";
import Table from "@material-ui/core/Table";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import {useHistory} from "react-router-dom";

const useStyles = makeStyles((theme) => ({
    button: {
        display: 'block',
        marginTop: theme.spacing(2),
    },
    formControl: {
        margin: theme.spacing(1),
        maxWidth: 500,
    },
    table: {
        minWidth: 700,
    },
}));

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

export default function GetAppointmentPanel(props) {
    const classes = useStyles();
    const [selectedClinicId, selectClinic] = React.useState('');
    const [clinics, setClinics] = React.useState([]);
    const [open, setOpen] = React.useState(false);
    const [appDate, handleAppDateChange] = React.useState(new Date());
    const [availableDoctors, setAvailableDoctors] = React.useState([]);
    const history = useHistory();

    useEffect(() => {
        axios.get(`http://localhost:8080/clinic/getAll`).then(response => {
            console.log(response.data);
            setClinics(response.data);
        })
    }, []);

    const handleSearchButton = () => {
        axios({
            method: 'post',
            url: 'http://localhost:8080/doctor/getFreeDoctors',
            data: {
                "clinic_id": selectedClinicId,
                "date": appDate
            }
        }).then(response => {
            console.log(response.data);
            // TODO: give alert if there is no doctor available
            setAvailableDoctors(response.data);
        })

    }

    const handleAppointmentButton = (event) => {
        const doctorId = event.currentTarget.value;

        axios({
            method: 'post',
            url: 'http://localhost:8080/appointment/add',
            data: {
                "app_date": appDate,
                "patient_id": props.userDetails.patient_id,
                "doctor_id": doctorId
            }
        }).then(response => {
            console.log(response.data);
            history.push("/patient");
        })
    }

    const handleChange = (event) => {
        selectClinic(event.target.value);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const handleOpen = () => {
        setOpen(true);
    };

    return (
        <div>
            <Container maxWidth="lg">
                <Grid
                    container
                    spacing={0}
                    direction="column"
                    alignItems="center"
                    justify="center"
                    style={{ minHeight: '20vh' }}
                >
                    <FormGroup>
                        <FormControl className={classes.formControl}>
                            <InputLabel>Clinic</InputLabel>
                            <Select
                                open={open}
                                onClose={handleClose}
                                onOpen={handleOpen}
                                value={selectedClinicId}
                                onChange={handleChange}
                            >
                                {clinics.map(clinic => <MenuItem key={clinic.clinic_id} value={clinic.clinic_id}>{clinic.name}</MenuItem>)}
                            </Select>
                        </FormControl>
                        <FormControl className={classes.formControl}>
                            <MuiPickersUtilsProvider utils={DateFnsUtils}>

                                <KeyboardDatePicker
                                    margin="normal"
                                    disablepast="true"
                                    id="startingDate"
                                    minDate={new Date()}
                                    minDateMessage={"Appointment date should be later than today!"}
                                    value={appDate}
                                    onChange={handleAppDateChange}
                                    name="startingDate"
                                    label="Appointment Date"
                                    format="dd/MM/yyyy"
                                    KeyboardButtonProps={{
                                        'aria-label': 'change date',
                                    }}
                                />

                            </MuiPickersUtilsProvider>
                        </FormControl>
                        <Button variant="outlined" color="primary" onClick={handleSearchButton}>
                            Search for available doctors
                        </Button>
                    </FormGroup>
                </Grid>
                {availableDoctors.length === 0 ? null :
                    <React.Fragment>
                        <Typography component="h2" variant="h6" color="primary" gutterBottom>
                            Available Doctors
                        </Typography>
                        <TableContainer component={Paper}>
                            <Table className={classes.table} aria-label="customized table">
                                <TableHead>
                                    <TableRow>
                                        <StyledTableCell>Doctor Name</StyledTableCell>
                                        <StyledTableCell>Appointment Date</StyledTableCell>
                                        <StyledTableCell>Rating</StyledTableCell>
                                        <StyledTableCell>Actions</StyledTableCell>
                                    </TableRow>
                                </TableHead>
                                <TableBody>
                                    {availableDoctors.map((row) => (
                                        <StyledTableRow key={row.doctor_id}>
                                            <StyledTableCell>{row.first_name + " " + row.middle_name + " " + row.last_name}</StyledTableCell>
                                            <StyledTableCell >
                                                {appDate.toLocaleString().substring(0, 10)}
                                            </StyledTableCell>
                                            <StyledTableCell >
                                                {row.rating ? `${Math.round(row.rating * 10) / 10} / 10` : 'Unavailable'}
                                            </StyledTableCell>
                                            <StyledTableCell>
                                                <Button
                                                    variant="contained"
                                                    color="primary"
                                                    onClick={handleAppointmentButton}
                                                    key={row.doctor_id}
                                                    value={row.doctor_id}
                                                >
                                                    Get Appointment
                                                </Button>
                                            </StyledTableCell>
                                        </StyledTableRow>
                                    ))}
                                </TableBody>
                            </Table>
                        </TableContainer>
                    </React.Fragment>
                }
            </Container>
        </div>
    );
}

/*
        useEffect(() => {
        axios.get(`http://localhost:8080/clinic/getAll`).
        then(response => {
            console.log(response.data);
            setClinics(response.data);
        })
    }, []);

     <div>
            <React.Fragment>
                <CssBaseline />
                <Container maxWidth="lg">

                </Container>
            </React.Fragment>
        </div>
 */