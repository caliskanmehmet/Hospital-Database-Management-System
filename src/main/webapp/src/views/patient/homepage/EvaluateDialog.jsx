import React from 'react';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';
import axios from "axios";
import EditIcon from '@material-ui/icons/Edit';
import {Box} from "@material-ui/core";
import Rating from '@material-ui/lab/Rating';
import Typography from "@material-ui/core/Typography";

export default function EvaluateDialog(props) {
    const [open, setOpen] = React.useState(false);
    const [comment, setComment] = React.useState("");
    const [rating, setRating] = React.useState(-1);

    const handleCommentChange = (event) => {
        setComment(event.target.value);
    }

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false)
    };

    const handleEvaluateButton = () => {
        axios({
            method: 'post',
            url: 'http://localhost:8080/evaluation/add',
            data: {
                "app_id": props.app_id,
                "comment": comment,
                "rating": rating
            }
        }).then(response => {
            console.log(response.data);
            props.setUpdate(props.update + 1); // Trigger render
            handleClose();
        })
    }

    return (
        <>
            <Button
                variant="outlined"
                color="inherit"
                disabled={!(props.app_status === "Finalized") || props.app_status === "Evaluated"}
                onClick={handleClickOpen}
                startIcon={<EditIcon />}
                >
                Evaluate
            </Button>
            <Dialog
                open={open}
                onClose={handleClose}
                aria-labelledby="form-dialog-title"
                fullWidth={true}
                maxWidth={"md"}
            >
                <DialogTitle id="form-dialog-title">Appointment Evaluation</DialogTitle>
                <DialogContent>
                    <DialogContentText>
                        You can evaluate the appointment by filling the fields below.
                    </DialogContentText>
                    <TextField
                        variant="outlined"
                        label="Comment"
                        multiline
                        rows={5}
                        value={comment}
                        onChange={handleCommentChange}
                        fullWidth
                    />
                    <Box component="fieldset" mt={3} borderColor="transparent">
                        <Typography component="legend">Rating</Typography>
                        <Rating
                            name="simple-controlled"
                            size="large"
                            defaultValue={2}
                            max={10}
                            value={rating}
                            onChange={(event, newValue) => {
                                setRating(newValue);
                            }}
                        />
                    </Box>
                </DialogContent>
                <DialogActions>
                    <Button onClick={handleClose} color="secondary">
                        Cancel
                    </Button>
                    <Button onClick={handleEvaluateButton}
                            color="primary"
                            disabled={!(comment.length > 0 && rating !== -1)}>
                        Evaluate
                    </Button>
                </DialogActions>
            </Dialog>
        </>
    );
}