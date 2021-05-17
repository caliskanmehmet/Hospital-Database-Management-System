import React, {useEffect} from "react"
import Typography from "@material-ui/core/Typography";
import Paper from "@material-ui/core/Paper";
import Table from "@material-ui/core/Table";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import TableBody from "@material-ui/core/TableBody";
import {ButtonGroup, FormGroup, TextField} from "@material-ui/core";
import Button from "@material-ui/core/Button";
import TableContainer from "@material-ui/core/TableContainer";
import axios from "axios";
import {makeStyles, withStyles} from "@material-ui/core/styles";
import TableCell from "@material-ui/core/TableCell";
import {useHistory} from "react-router-dom";
import {KeyboardDatePicker, MuiPickersUtilsProvider} from "@material-ui/pickers";
import DateFnsUtils from "@date-io/date-fns";
import FormControl from "@material-ui/core/FormControl";
import Divider from "@material-ui/core/Divider";

const StyledTableCell = withStyles((theme) => ({
    head: {
        backgroundColor: theme.palette.common.white,
        fontWeight: "bold"
    },
    body: {
        fontSize: 14,
    },
}))(TableCell);

const StyledTableRow = withStyles((theme) => ({
    root: {
        '&:nth-of-type(odd)': {
            backgroundColor: theme.palette.action.hover,
        },
    },
}))(TableRow);

const useStyles = makeStyles({
    table: {
        minWidth: 700,
    },
});

export default function TestRequestsPanel(props) {
    const [testRequests, setTestRequests] = React.useState([]);
    const [startingDate, setStartingDate] = React.useState(new Date());
    const [endingDate, setEndingDate] = React.useState(new Date());
    const [testType, setTestType] = React.useState("");
    const classes = useStyles();
    const history = useHistory();

    // http://localhost:8080/testRequest/getByPatient/1000

    useEffect(() => {
        let userDetails = JSON.parse(localStorage.getItem('user'));
        axios.get(`http://localhost:8080/testRequest/getByPatient/${userDetails.patient_id}`).then(response => {
            console.log(response.data);
            setTestRequests(response.data);
        })
    },[])

    const handleRangeButton = () => {
        let userDetails = JSON.parse(localStorage.getItem('user'));
        axios({
            method: 'post',
            url: 'http://localhost:8080/testRequest/getByPatientWithRange',
            data: {
                "patient_id": userDetails.patient_id,
                "startingDate": startingDate,
                "endingDate": endingDate
            }
        }).then(response => {
            console.log(response.data);
            setTestRequests(response.data);
        })
    }

    const handleTestTypeChange = (event) => {
        setTestType(event.target.value);
    };

    const handleSearchButton = () => {
        let userDetails = JSON.parse(localStorage.getItem('user'));
        axios({
            method: 'get',
            url: 'http://localhost:8080/testRequest/getByPatientWithTestType',
            params: {
                "patient_id": userDetails.patient_id,
                "testType": testType
            }
        }).then(response => {
            console.log(response.data);
            setTestRequests(response.data);
        })
    }

    const handleAllSearchButton = () => {
        let userDetails = JSON.parse(localStorage.getItem('user'));
        axios({
            method: 'post',
            url: 'http://localhost:8080/testRequest/getByPatientWithAll',
            data: {
                "patient_id": userDetails.patient_id,
                "testType": testType,
                "startingDate": startingDate,
                "endingDate": endingDate
            }
        }).then(response => {
            console.log(response.data);
            setTestRequests(response.data);
        })
    }

    return(
        <div>
            <Typography variant="h5" gutterBottom>
                Test Results
            </Typography>
            <FormGroup row>
                <FormControl>
                    <MuiPickersUtilsProvider utils={DateFnsUtils}>
                        <KeyboardDatePicker
                            margin="normal"
                            id="startingDate"
                            value={startingDate}
                            onChange={setStartingDate}
                            name="startingDate"
                            label="Starting Date"
                            format="dd/MM/yyyy"
                            KeyboardButtonProps={{
                                'aria-label': 'change date',
                            }}
                        />
                    </MuiPickersUtilsProvider>
                </FormControl>
                <FormControl style={{marginLeft: "20px"}}>
                    <MuiPickersUtilsProvider utils={DateFnsUtils}>
                        <KeyboardDatePicker
                            margin="normal"
                            id="endingDate"
                            value={endingDate}
                            onChange={setEndingDate}
                            name="endingDate"
                            label="Ending Date"
                            format="dd/MM/yyyy"
                            KeyboardButtonProps={{
                                'aria-label': 'change date',
                            }}
                        />
                    </MuiPickersUtilsProvider>
                </FormControl>
                <FormControl style={{marginTop: "20px", marginLeft: "50px"}}>
                    <Button variant="outlined" color="primary" onClick={handleRangeButton}>
                        Get By Date
                    </Button>
                </FormControl>
            </FormGroup>
            <Divider />
            <FormGroup row>
                <FormControl>
                    <TextField style={{width: "300px"}} id="test-type" label="Test Type" value={testType} onChange={handleTestTypeChange} />
                </FormControl>
                <FormControl style={{marginTop: "20px", marginLeft: "230px"}}>
                    <Button style={{marginBottom: "20px"}} color="primary" variant="outlined" onClick={handleSearchButton}>
                        Search by Test Type
                    </Button>
                </FormControl>
            </FormGroup>
            <Divider />
            <FormControl style={{marginTop: "20px", marginLeft: "490px"}}>
                <Button style={{marginBottom: "20px"}} color="primary" variant="outlined" onClick={handleAllSearchButton}>
                    Search by Test Type and Date
                </Button>
            </FormControl>
            <TableContainer component={Paper}>
                <Table className={classes.table} aria-label="customized table">
                    <TableHead>
                        <TableRow>
                            <StyledTableCell>Status</StyledTableCell>
                            <StyledTableCell>Request Date Time</StyledTableCell>
                            <StyledTableCell>Test Name</StyledTableCell>
                            <StyledTableCell>Actions</StyledTableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {testRequests.map((row) => (
                            <StyledTableRow key={row.request_id}>
                                <StyledTableCell>{row.status === 'Assigned' ? 'Waiting' : row.status}</StyledTableCell>
                                <StyledTableCell>
                                    {new Date(Date.parse(row.request_date_time)).toLocaleString()}
                                </StyledTableCell>
                                <StyledTableCell>{row.name}</StyledTableCell>
                                <StyledTableCell>
                                    <ButtonGroup color="primary" variant="outlined">
                                        <Button onClick={() =>
                                            history.push(`/patient/test/${row.request_id}/${row.test_type_id}`)}
                                            disabled={row.status !== 'Finalized'}
                                        >
                                            Results
                                        </Button>
                                    </ButtonGroup>
                                </StyledTableCell>
                            </StyledTableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
        </div>
    )
}