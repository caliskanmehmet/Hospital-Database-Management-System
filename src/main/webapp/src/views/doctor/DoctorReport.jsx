import React, {useEffect} from "react"
import axios from "axios";
import {DataGrid} from '@material-ui/data-grid';
import Button from "@material-ui/core/Button";
import Container from "@material-ui/core/Container";
import Typography from "@material-ui/core/Typography";
import {useHistory} from "react-router-dom";

export default function DoctorReport() {
    const [components, setComponents] = React.useState([]);
    const history = useHistory();

    const columns = [
        { field: 'first_name', headerName: 'First Name', width: 130 },
        { field: 'middle_name', headerName: 'Middle Name', width: 150 },
        { field: 'last_name', headerName: 'Last Name', width: 130},
        { field: 'min', headerName: 'Minimum Rating', width: 200, type: 'number'},
        { field: 'max', headerName: 'Maximum Rating', width: 200, type: 'number'},
        { field: 'average', headerName: 'Average Rating', width: 200, type: 'number'},
    ];

    useEffect(() => {
        axios.get(`http://localhost:8080/evaluation/report`).then(response => {
            console.log(response.data);
            let count = 0;
            setComponents(response.data.map(v => ({...v, id: count++})));
        });
    },[])

    return (
        <Container maxWidth="lg">
            <Typography variant="h6" gutterBottom>
                Evaluation Reports of All Doctors
            </Typography>
            <div style={{ height: 400, width: '100%' }}>
                <DataGrid
                    rows={components}
                    columns={columns}
                />
            </div>
            <Button
                color="primary"
                variant="contained"
                onClick={() => history.push("/doctor")}
            >
                Go back to home page
            </Button>
        </Container>);
}