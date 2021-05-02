import React, {useEffect} from "react"
import Typography from "@material-ui/core/Typography";
import axios from "axios";
import {useParams} from "react-router-dom";
import {DataGrid} from '@material-ui/data-grid';
import Button from "@material-ui/core/Button";
import {makeStyles} from "@material-ui/core/styles";
import Container from "@material-ui/core/Container";

const useStyles = makeStyles((theme) => ({
    button: {
        float: 'right'
    },
}));

export default function TestDataGrid(props) {
    const classes = useStyles();
    const [components, setComponents] = React.useState([]);
    let { requestId, typeId } = useParams();

    const columns = [
        { field: 'parameter_name', headerName: 'Parameter Name', width: 200 },
        { field: 'unit', headerName: 'Unit', width: 130 },
        { field: 'min_value', headerName: 'Min Value', width: 130, type: 'number', },
        { field: 'max_value', headerName: 'Max Value', width: 130, type: 'number', },
        {
            field: 'score',
            headerName: 'Score',
            type: 'number',
            width: 90,
            editable: true
        },
    ];

    const handleEditCellChangeCommitted = React.useCallback(
        ({ id, field, props }) => {
            if (field === 'score') {
                const data = props; // Fix eslint value is missing in prop-types for JS files
                const score = data.value;
                const updatedRows = components.map((row) => {
                    if (row.id === id) {
                        return { ...row, score };
                    }
                    return row;
                });
                setComponents(updatedRows);
            }
        },
        [components],
    );

    useEffect(() => {
        let count = 0;
        axios.get(`http://localhost:8080/testComponent/get/${typeId}`).then(response => {
            setComponents(response.data.map(v => ({...v, score: 0.0, id: count++ })));
        })
        // eslint-disable-next-line
    },[])

    return(
        <Container maxWidth="lg">
            <Typography variant="h6" gutterBottom>
                Component Data Grid
            </Typography>
            <div style={{ height: 400, width: '100%' }}>
                <DataGrid
                    rows={components}
                    columns={columns}
                    onEditCellChangeCommitted={handleEditCellChangeCommitted}
                />
            </div>
            <Button
                color="primary"
                variant="contained"
                onClick={() => console.log(components)}
                className={classes.button}
            >
                Submit
            </Button>
        </Container>
    )
}