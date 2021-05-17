import React, {useEffect} from "react"
import axios from "axios";
import {DataGrid} from '@material-ui/data-grid';
import Button from "@material-ui/core/Button";
import Container from "@material-ui/core/Container";
import Typography from "@material-ui/core/Typography";
import {useHistory} from "react-router-dom";

export default function LaboratorianReport() {
    const [components, setComponents] = React.useState([]);
    const history = useHistory();

    const columns = [
        { field: 'parameter_name', headerName: 'Parameter Name', width: 200 },
        { field: 'min', headerName: 'Min Value', width: 130 },
        { field: 'max', headerName: 'Max Value', width: 130, type: 'number'}
    ];

    useEffect(() => {
        let userDetails = JSON.parse(localStorage.getItem('user'));
        axios.get(`http://localhost:8080/result/report`,
            { params:
                    {laboratorian_id: userDetails.laboratorian_id}
            }).then(response => {
            console.log(response.data);
            let count = 0;
            setComponents(response.data.map(v => ({...v, id: count++})));
        });
    },[])

    return (
        <Container maxWidth="lg">
        <Typography variant="h6" gutterBottom>
            Minimum and Maximum results determined by you
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
            onClick={() => history.push("/laboratorian")}
        >
            Go back to home page
        </Button>
    </Container>);
}