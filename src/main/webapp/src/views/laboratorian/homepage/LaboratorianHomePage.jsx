import Grid from "@material-ui/core/Grid";
import {Paper} from "@material-ui/core";
import React from "react";
import {makeStyles} from "@material-ui/core/styles";
import LaboratorianDetails from "./LaboratorianDetails";
import LaboratorianTestList from "./LaboratorianTestList";

const useStyles = makeStyles((theme) => ({
    paper: {
        padding: theme.spacing(2),
        display: 'flex',
        overflow: 'auto',
        flexDirection: 'column',
    }
}));

export default function LaboratorianHomePage(props) {
    const classes = useStyles();

    return (
        <div>
            <Grid container spacing={3}>
                <Grid item xs={12} md={8} lg={6}>
                    <Paper className={classes.paper}>
                        <LaboratorianDetails userDetails={props.userDetails} />
                    </Paper>
                </Grid>
                <Grid item xs={12}>
                    <LaboratorianTestList update={props.update} setUpdate={props.setUpdate} userDetails = {props.userDetails} setLaboSuccess = {props.setLaboSuccess} setlabofail={props.setlabofail} />
                </Grid>
            </Grid>
        </div>
    );
}