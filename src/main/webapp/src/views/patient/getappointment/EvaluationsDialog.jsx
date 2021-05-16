import React, {useEffect} from 'react';
import {withStyles} from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';
import Dialog from '@material-ui/core/Dialog';
import MuiDialogTitle from '@material-ui/core/DialogTitle';
import MuiDialogContent from '@material-ui/core/DialogContent';
import MuiDialogActions from '@material-ui/core/DialogActions';
import IconButton from '@material-ui/core/IconButton';
import CloseIcon from '@material-ui/icons/Close';
import Typography from '@material-ui/core/Typography';
import Divider from "@material-ui/core/Divider";
import axios from "axios";
import Rating from "@material-ui/lab/Rating";
import {Box} from "@material-ui/core";

const styles = (theme) => ({
    root: {
        margin: 0,
        padding: theme.spacing(2),
    },
    closeButton: {
        position: 'absolute',
        right: theme.spacing(1),
        top: theme.spacing(1),
        color: theme.palette.grey[500],
    },
});

const DialogTitle = withStyles(styles)((props) => {
    const { children, classes, onClose, ...other } = props;
    return (
        <MuiDialogTitle disableTypography className={classes.root} {...other}>
            <Typography variant="h6">{children}</Typography>
            {onClose ? (
                <IconButton aria-label="close" className={classes.closeButton} onClick={onClose}>
                    <CloseIcon />
                </IconButton>
            ) : null}
        </MuiDialogTitle>
    );
});

const DialogContent = withStyles((theme) => ({
    root: {
        padding: theme.spacing(2),
    },
}))(MuiDialogContent);

const DialogActions = withStyles((theme) => ({
    root: {
        margin: 0,
        padding: theme.spacing(1),
    },
}))(MuiDialogActions);

export default function EvaluationsDialog(props) {
    const [open, setOpen] = React.useState(false);
    const [evaluations, setEvaluations] = React.useState([]);

    const handleClickOpen = () => {
        setOpen(true);
    };
    const handleClose = () => {
        setOpen(false);
    };

    useEffect(() => {
        axios.get(`http://localhost:8080/evaluation/get/${props.doctorId}`).then(response => {
            console.log(response.data);
            setEvaluations(response.data);
        })
    }, [props.doctorId]);

    return (
        <div>
            <Button
                variant="outlined"
                color="inherit"
                onClick={handleClickOpen}
                disabled={evaluations.length === 0}
            >
                Show Evaluations
            </Button>
            <Dialog onClose={handleClose} aria-labelledby="customized-dialog-title" open={open}>
                <DialogTitle id="customized-dialog-title" onClose={handleClose}>
                    Evaluations
                </DialogTitle>
                <DialogContent dividers>
                    {evaluations.map( evaluation => {
                        return(
                            <div key={evaluation.app_id}>
                                <Box component="fieldset" mt={1} borderColor="transparent">
                                    <Typography component="legend"><b>Rating:</b></Typography>
                                    <Rating
                                        name="simple-controlled"
                                        size="large"
                                        disabled={true}
                                        max={10}
                                        value={evaluation.rating}
                                    />
                                </Box>
                                <Box component="fieldset" borderColor="transparent">
                                    <Typography component="legend"><b>Comment:</b> {evaluation.comment}</Typography>
                                </Box>
                                <Divider light />
                            </div>
                        )
                    })}

                </DialogContent>
                <DialogActions>
                    <Button autoFocus onClick={handleClose} color="primary">
                        Kapat
                    </Button>
                </DialogActions>
            </Dialog>
        </div>
    );
}
