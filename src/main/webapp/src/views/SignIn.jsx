import React from 'react';
import Avatar from '@material-ui/core/Avatar';
import Button from '@material-ui/core/Button';
import CssBaseline from '@material-ui/core/CssBaseline';
import TextField from '@material-ui/core/TextField';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import LockOutlinedIcon from '@material-ui/icons/LockOutlined';
import Typography from '@material-ui/core/Typography';
import {makeStyles} from '@material-ui/core/styles';
import Container from '@material-ui/core/Container';
import axios from "axios";
import {Card, CardContent, FormControl, FormLabel, Radio, RadioGroup, Snackbar} from "@material-ui/core";
import {Redirect} from "react-router-dom";
import {Alert} from "@material-ui/lab";

const useStyles = makeStyles((theme) => ({
    paper: {
        marginTop: theme.spacing(8),
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
    },
    avatar: {
        margin: theme.spacing(1),
        backgroundColor: theme.palette.secondary.main,
    },
    form: {
        width: '100%', // Fix IE 11 issue.
        marginTop: theme.spacing(1),
    },
    submit: {
        margin: theme.spacing(3, 0, 2),
    },
}));

export default function SignIn(props) {
    const classes = useStyles();

    const [value, setValue] = React.useState('patient');
    const [textfieldLabel, settextfieldLabel] = React.useState('Patient SSN');
    const [inputList, setInputList] = React.useState({});
    const [snackbarOpen, setSnackbarOpen] = React.useState(false);

    const handleChange = (event) => {
        const targetValue = event.target.value;

        if (targetValue === "patient") {
            settextfieldLabel("Patient SSN");
        }
        else if (targetValue === "doctor") {
            settextfieldLabel("Doctor ID");
        }
        else if (targetValue === "laboratorian"){
            settextfieldLabel("Laboratorian ID");
        }

        setValue(targetValue);
    };

    const handleFormChange = (event) => {
        const newInputList = {...inputList};
        newInputList[event.target.name] = event.target.value;
        setInputList(newInputList);
    }

    const handleClose = (event, reason) => {
        if (reason === 'clickaway') {
            return;
        }

        setSnackbarOpen(false);
    };

    const loginRequest = () => {
        axios.get(`http://localhost:8080/auth/${value}`, {
            params: {
                id: inputList['id'],
                password: inputList['password']
            }
        }).then(response => {
            console.log(response.data);
            if (response.data.ssn) {
                localStorage.setItem("user", JSON.stringify(response.data));
                props.setLoginStatus("patient");
            }
            else if (response.data.doctor_id) {
                localStorage.setItem("user", JSON.stringify(response.data));
                props.setLoginStatus("doctor");
            }
            else if (response.data.laboratorian_id) {
                localStorage.setItem("user", JSON.stringify(response.data));
                props.setLoginStatus("laboratorian");
            }
            else {
                setSnackbarOpen(true);
            }
        }).catch(err => {
            setSnackbarOpen(true);
        })
    }

    return (
        props.loginStatus === "doctor" ? (<Redirect to='/doctor'  />) :
        props.loginStatus === "patient" ? (<Redirect to='/patient'  />) :
        props.loginStatus === "laboratorian" ? (<Redirect to='/laboratorian'  />) :
        <Container component="main" maxWidth="xs">
            <CssBaseline />
            <div className={classes.paper}>
                <Snackbar open={snackbarOpen} autoHideDuration={5000} onClose={handleClose}>
                    <Alert onClose={handleClose} severity="error" variant="filled">
                        Wrong credentials!
                    </Alert>
                </Snackbar>
                <Avatar className={classes.avatar}>
                    <LockOutlinedIcon />
                </Avatar>
                <Typography component="h1" variant="h5">
                    e-Bni Sina - Log In
                </Typography>
                <Card variant="outlined">
                    <CardContent>
                        <FormControl component="fieldset">
                            <FormLabel component="legend">User Type</FormLabel>
                            <RadioGroup row value={value} onChange={handleChange}>
                                <FormControlLabel value="patient" control={<Radio />} label="Patient" />
                                <FormControlLabel value="doctor" control={<Radio />} label="Doctor" />
                                <FormControlLabel value="laboratorian" control={<Radio />} label="Laboratorian" />
                            </RadioGroup>
                        </FormControl>
                    </CardContent>
                </Card>
                <form className={classes.form} noValidate>
                    <TextField
                        variant="outlined"
                        margin="normal"
                        required
                        fullWidth
                        onChange={handleFormChange}
                        id="id"
                        label={textfieldLabel}
                        name="id"
                        autoFocus
                    />
                    <TextField
                        variant="outlined"
                        margin="normal"
                        required
                        fullWidth
                        onChange={handleFormChange}
                        name="password"
                        label="Password"
                        type="password"
                        id="password"
                        autoComplete="current-password"
                    />
                    <Button
                        fullWidth
                        variant="contained"
                        color="primary"
                        className={classes.submit}
                        onClick={loginRequest}
                    >
                        Sign In
                    </Button>
                </form>
            </div>
        </Container>
    );
}
