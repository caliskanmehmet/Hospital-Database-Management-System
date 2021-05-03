import React, {useEffect} from "react"
import Typography from "@material-ui/core/Typography";
import axios from "axios";
import {useHistory, useParams} from "react-router-dom";
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
    const history = useHistory();

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
        let fetchedComponents = [];
        let results = [];

        axios.get(`http://localhost:8080/testComponent/get/${typeId}`).then(response => {
            fetchedComponents = response.data.map(v => ({...v, score: 0.0, id: count++ }));

            axios.get(`http://localhost:8080/result/getByTest/${requestId}`).then(response => {
                results = response.data;

                results.forEach((element, index) => {
                    fetchedComponents.every((element2, index2) => {
                        if (element.parameter_name === element2.parameter_name) {
                            element2.score = element.score;
                            return false;
                        }
                        else {
                            return true;
                        }
                    })
                })

                setComponents(fetchedComponents);
            });


        });

        // setComponents(response.data.map(v => ({...v, score: 0.0, id: count++ })));
        // eslint-disable-next-line
    },[])

    const handleSubmitButton = () => {
        const results = components.filter(component => component.score !== 0)
                                  .map(component => ({score: component.score, test_type_id: component.test_type_id,
                                                    parameter_name: component.parameter_name, request_id: requestId}));

        console.log(results);

        axios({
            method: 'post',
            url: 'http://localhost:8080/result/add',
            data: results
        }).then(response => {
            history.push('/laboratorian');
        })

    }

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
                onClick={handleSubmitButton}
                className={classes.button}
            >
                Submit
            </Button>
        </Container>
    )
}