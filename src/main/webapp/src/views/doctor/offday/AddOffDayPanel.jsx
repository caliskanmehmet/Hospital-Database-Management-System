import React from 'react';
import {makeStyles} from '@material-ui/core/styles';
import FormControl from '@material-ui/core/FormControl';
import Button from '@material-ui/core/Button';
import axios from "axios";
import Container from "@material-ui/core/Container";
import {KeyboardDatePicker, MuiPickersUtilsProvider} from '@material-ui/pickers';
import Grid from '@material-ui/core/Grid';
import DateFnsUtils from '@date-io/date-fns';
import {FormGroup} from "@material-ui/core";
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

export default function AddOffDayPanel(props) {
    const classes = useStyles();
    const [offDay, handleOffDayChange] = React.useState(new Date(new Date().getTime() + (24 * 60 * 60 * 1000)));
    const history = useHistory();

    const handleAddButton = () => {
        axios({
            method: 'post',
            url: 'http://localhost:8080/offDay/add',
            data: {
                "doctor_id": JSON.parse(localStorage.getItem('user')).doctor_id,
                "off_date": offDay
            }
        }).then(response => {
            console.log(response.data);
            history.push("/doctor");
        })

    }

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
                            <MuiPickersUtilsProvider utils={DateFnsUtils}>

                                <KeyboardDatePicker
                                    margin="normal"
                                    disablepast="true"
                                    id="offDay"
                                    minDate={new Date(new Date().getTime() + (24 * 60 * 60 * 1000))}
                                    minDateMessage={"Off day should be later than today!"}
                                    value={offDay}
                                    onChange={handleOffDayChange}
                                    name="offDay"
                                    label="Off Day"
                                    format="dd/MM/yyyy"
                                    KeyboardButtonProps={{
                                        'aria-label': 'change date',
                                    }}
                                />

                            </MuiPickersUtilsProvider>
                        </FormControl>
                        <Button variant="contained" color="primary" onClick={handleAddButton}>
                            Add Off Day
                        </Button>
                    </FormGroup>
                </Grid>
            </Container>
        </div>
    );
}
