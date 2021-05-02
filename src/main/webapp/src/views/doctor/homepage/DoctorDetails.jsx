import React from "react"
import Typography from "@material-ui/core/Typography";

export default function DoctorDetails(props) {

    return(
        <div>
            <Typography variant="h6" gutterBottom>
                Welcome, {props.userDetails.first_name + " " + props.userDetails.middle_name + " " + props.userDetails.last_name}!
            </Typography>
            <Typography variant="subtitle2" gutterBottom>
                Specialization: {props.userDetails.specialization}
            </Typography>
        </div>
    )
}