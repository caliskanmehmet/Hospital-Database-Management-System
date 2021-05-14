import React, {useEffect} from 'react';
import {makeStyles} from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';
import FormControl from '@material-ui/core/FormControl';
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';
import Select from '@material-ui/core/Select';
import axios from "axios";
import {Input, useTheme} from "@material-ui/core";

const useStyles = makeStyles((theme) => ({
    form: {
        display: 'flex',
        flexDirection: 'column',
        margin: 'auto',
        width: 'fit-content',
    },
    formControl: {
        margin: theme.spacing(1),
        minWidth: 1000,
        maxWidth: 1200,
    },
    chips: {
        display: 'flex',
        flexWrap: 'wrap',
    },
    chip: {
        margin: 2,
    },
    noLabel: {
        marginTop: theme.spacing(3),
    },
}));

function getStyles(name, testRequest, theme) {
    return {
        fontWeight:
            testRequest.indexOf(name) === -1
                ? theme.typography.fontWeightRegular
                : theme.typography.fontWeightMedium,
    };
}

const ITEM_HEIGHT = 48;
const ITEM_PADDING_TOP = 8;
const MenuProps = {
    PaperProps: {
        style: {
            maxHeight: ITEM_HEIGHT * 4.5 + ITEM_PADDING_TOP,
            width: 250,
        },
    },
};

export default function AddSymptomDialog(props) {
    const classes = useStyles();
    const theme = useTheme();
    const [open, setOpen] = React.useState(false);
    const [symptoms, setSymptoms] = React.useState([]);
    const [determinedSymptoms, setDeterminedSymptoms] = React.useState([]);

    useEffect(() => {
        let isMounted = true;

        axios.get(`http://localhost:8080/symptom/getAll`).then(response => {
            if (isMounted) {
                setSymptoms(response.data);
                console.log(response.data);
            }
        })

        return () => { isMounted = false };
    },[])

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const handleChange = (event) => {
        setDeterminedSymptoms(event.target.value);
        console.log(determinedSymptoms);
    };

    const handleRequestButton = () => {
        axios({
            method: 'post',
            url: `http://localhost:8080/appointment/addSymptom/${props.app_id}`,
            data: determinedSymptoms
        }).then(response => {
            console.log(response.data);
            //props.setSymptomSuccess(true);

        }).catch(response => {

        })
        props.setSymptomSuccess(true);

        setOpen(false);
    }

    return (
        <React.Fragment>
            <Button variant="outlined" color="primary" onClick={handleClickOpen} disabled={props.disabled}>
                Add Symptom
            </Button>
            <Dialog
                fullWidth={true}
                maxWidth={'lg'}
                open={open}
                onClose={handleClose}
                aria-labelledby="max-width-dialog-title"
            >
                <DialogTitle id="max-width-dialog-title">Add Symptom</DialogTitle>
                <DialogContent>
                    <DialogContentText>
                        You can add symptoms from this dialog.
                    </DialogContentText>
                    <form className={classes.form} noValidate>
                        <FormControl className={classes.formControl}>
                            <InputLabel id="demo-mutiple-name-label">Symptom</InputLabel>
                            <Select
                                labelId="demo-mutiple-name-label"
                                id="demo-mutiple-name"
                                multiple
                                value={determinedSymptoms}
                                onChange={handleChange}
                                input={<Input />}
                                MenuProps={MenuProps}
                                maxWidth
                            >
                                {symptoms.map((item) => (
                                    <MenuItem key={item.symptom_id} value={item.symptom_id} style={getStyles(item.symptom_id, determinedSymptoms, theme)}>
                                        {item.name}
                                    </MenuItem>
                                ))}
                            </Select>
                        </FormControl>
                    </form>
                </DialogContent>
                <DialogActions>
                    <Button onClick={handleClose} color="secondary">
                        Close
                    </Button>
                    <Button onClick={handleRequestButton} color="primary">
                        Add
                    </Button>
                </DialogActions>
            </Dialog>
        </React.Fragment>
    );
}