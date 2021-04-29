import Grid from "@material-ui/core/Grid";
import {Paper} from "@material-ui/core";
import PatientDetails from "./PatientDetails";
import AppointmentList from "./AppointmentList";
import React from "react";
import {makeStyles} from "@material-ui/core/styles";

const useStyles = makeStyles((theme) => ({
    paper: {
        padding: theme.spacing(2),
        display: 'flex',
        overflow: 'auto',
        flexDirection: 'column',
    }
}));

export default function HomePage(props) {
    const classes = useStyles();

    return (
        <Grid container spacing={3}>
            <Grid item xs={12} md={8} lg={6}>
                <Paper className={classes.paper}>
                    <PatientDetails userDetails={props.userDetails} />
                </Paper>
            </Grid>
            <Grid item xs={12}>
                <AppointmentList userDetails = {props.userDetails} />
            </Grid>
        </Grid>
    );
}




