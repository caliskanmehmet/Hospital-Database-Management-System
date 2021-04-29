import React from "react"
import Typography from "@material-ui/core/Typography";

export default function PatientDetails(props) {

    return(
        <div>
            <Typography variant="h6" gutterBottom>
                Welcome, {props.userDetails.first_name + " " + props.userDetails.middle_name + " " + props.userDetails.last_name}!
            </Typography>
            <Typography variant="subtitle2" gutterBottom>
                Blood Type: {props.userDetails.blood_type}
            </Typography>
            <Typography variant="subtitle2" gutterBottom>
                Weight: {props.userDetails.weight + " kg"}
            </Typography>
            <Typography variant="subtitle2" gutterBottom>
                Height: {props.userDetails.height + " cm"}
            </Typography>
            <Typography variant="subtitle2" gutterBottom>
                SSN: {props.userDetails.ssn}
            </Typography>
        </div>
    )
}