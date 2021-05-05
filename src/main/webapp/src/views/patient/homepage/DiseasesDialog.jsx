import React, {useEffect} from 'react';
import Button from '@material-ui/core/Button';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';
import axios from "axios";
import Typography from "@material-ui/core/Typography";

export default function DiseasesDialog(props) {
    const [open, setOpen] = React.useState(false);
    const [diseases, setDiseases] = React.useState([]);

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false)
    };

    useEffect(() => {
        let isMounted = true;

        axios.get(`http://localhost:8080/diagnose/getByAppointment/${props.app_id}`).then(response => {
            if (isMounted) {
                setDiseases(response.data);
            }

        })

        return () => {isMounted = false};
    },[props.app_id])

    return (
        <>
            <Button
                variant="outlined"
                color="primary"
                disabled={props.disabled}
                onClick={handleClickOpen}
            >
                Diseases
            </Button>
            <Dialog
                open={open}
                onClose={handleClose}
                aria-labelledby="form-dialog-title"
                fullWidth={true}
                maxWidth={"md"}
            >
                <DialogTitle id="form-dialog-title">Diseases</DialogTitle>
                <DialogContent>
                    <DialogContentText>
                        You can see the diseases that your doctor diagnosed below.
                    </DialogContentText>
                    {diseases.map(disease => (<Typography key={disease.disease_id} variant="body1" gutterBottom>- {disease.name}</Typography>))}
                </DialogContent>
                <DialogActions>
                    <Button onClick={handleClose} color="primary">
                        Close
                    </Button>
                </DialogActions>
            </Dialog>
        </>
    );
}