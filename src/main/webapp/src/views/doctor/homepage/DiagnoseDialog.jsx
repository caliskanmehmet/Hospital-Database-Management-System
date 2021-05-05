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

export default function DiagnoseDialog(props) {
    const classes = useStyles();
    const theme = useTheme();
    const [open, setOpen] = React.useState(false);
    const [diseases, setDiseases] = React.useState([]);
    const [determinedDiagnoses, setDeterminedDiagnoses] = React.useState([]);

    useEffect(() => {
        let isMounted = true;

        axios.get(`http://localhost:8080/disease/getAll`).then(response => {
            if (isMounted) {
                setDiseases(response.data);
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
        setDeterminedDiagnoses(event.target.value);
        console.log(determinedDiagnoses);
    };

    const handleRequestButton = () => {
        axios({
            method: 'post',
            url: `http://localhost:8080/diagnose/add/${props.app_id}`,
            data: determinedDiagnoses
        }).then(response => {
            console.log(response.data);
            props.setUpdate(props.update + 1); // trigger render
        })
        setOpen(false);
    }

    return (
        <React.Fragment>
            <Button variant="outlined" color="primary" onClick={handleClickOpen} disabled={props.disabled}>
                Diagnose
            </Button>
            <Dialog
                fullWidth={true}
                maxWidth={'lg'}
                open={open}
                onClose={handleClose}
                aria-labelledby="max-width-dialog-title"
            >
                <DialogTitle id="max-width-dialog-title">Diagnose</DialogTitle>
                <DialogContent>
                    <DialogContentText>
                        You can diagnose the patient from this dialog.
                    </DialogContentText>
                    <form className={classes.form} noValidate>
                        <FormControl className={classes.formControl}>
                            <InputLabel id="demo-mutiple-name-label">Disease</InputLabel>
                            <Select
                                labelId="demo-mutiple-name-label"
                                id="demo-mutiple-name"
                                multiple
                                value={determinedDiagnoses}
                                onChange={handleChange}
                                input={<Input />}
                                MenuProps={MenuProps}
                                maxWidth
                            >
                                {diseases.map((item) => (
                                    <MenuItem key={item.disease_id} value={item.disease_id} style={getStyles(item.disease_id, determinedDiagnoses, theme)}>
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