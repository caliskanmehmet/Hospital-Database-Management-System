import React, {useEffect} from "react"
import Typography from "@material-ui/core/Typography";
import axios from "axios";
import {useHistory, useParams} from "react-router-dom";
import {DataGrid} from '@material-ui/data-grid';
import Button from "@material-ui/core/Button";
import {makeStyles} from "@material-ui/core/styles";
import Container from "@material-ui/core/Container";

const useStyles = makeStyles((theme) => {

    return {
        root: {
            '& .super-app-theme--Problem': {
                backgroundColor: '#fa9d9d',
            },
            '& .super-app-theme--Ok': {
                backgroundColor: '#ffffff',
            },
        },
    };
});

export default function ComponentViewGrid(props) {
    const [components, setComponents] = React.useState([]);
    let { parameterName, typeId } = useParams();
    const history = useHistory();
    const classes = useStyles();

    const columns = [
        {
            field: 'request_date_time',
            headerName: 'Request Date',
            width: 200,
            valueFormatter: (params) => new Date(Date.parse(params.getValue('request_date_time'))).toLocaleString().substring(0, 10)
        },
        { field: 'parameter_name', headerName: 'Parameter Name', width: 200 },
        { field: 'unit', headerName: 'Unit', width: 130 },
        { field: 'min_value', headerName: 'Min Value', width: 130, type: 'number', },
        { field: 'max_value', headerName: 'Max Value', width: 130, type: 'number', },
        { field: 'score', headerName: 'Score', type: 'number', width: 90,},
    ];

    useEffect(() => {
        let userDetails = JSON.parse(localStorage.getItem('user')); // userDetails.patientId
        axios.get(`http://localhost:8080/result/getByParameter`,
            { params:
                    { test_type_id: typeId, parameter_name: parameterName, patient_id: userDetails.patient_id }
                  }).then(response => {
            console.log(response.data);
            let count = 0;
            setComponents(response.data.map(v => ({...v, id: count++})));
        });

        // eslint-disable-next-line
    },[])

    return(
        <Container maxWidth="lg">
            <Typography variant="h6" gutterBottom>
                Component Data Grid
            </Typography>
            <div style={{ height: 400, width: '100%' }} className={classes.root}>
                <DataGrid
                    rows={components}
                    columns={columns}
                    getRowClassName={(params) => {
                        if (params.getValue('score') > params.getValue('max_value')  ||
                            params.getValue('score') < params.getValue('min_value'))
                            return `super-app-theme--Problem`;
                    }}
                />
            </div>
            <Button
                color="primary"
                variant="contained"
                onClick={() => history.push("/patient/tests")}
            >
                Go back to tests
            </Button>
        </Container>
    )
}