import React, {useEffect} from 'react';
import {makeStyles} from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';
import {AppBar, Box, Tab, Tabs} from "@material-ui/core";
import Typography from "@material-ui/core/Typography";
import axios from "axios";
import {DataGrid} from "@material-ui/data-grid";
import useDidMountEffect from "../customhook/useDidMountEffect";

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
        appBar:  {
            flexGrow: 1,
            width: '100%',
            backgroundColor: theme.palette.background.paper,
        }
    };
});

function TabPanel(props) {
    const { children, value, index, ...other } = props;

    return (
        <div
            role="tabpanel"
            hidden={value !== index}
            id={`scrollable-auto-tabpanel-${index}`}
            aria-labelledby={`scrollable-auto-tab-${index}`}
            {...other}
        >
            {value === index && (
                <Box p={3}>
                    <Typography component={'span'}>{children}</Typography>
                </Box>
            )}
        </div>
    );
}

function a11yProps(index) {
    return {
        id: `scrollable-auto-tab-${index}`,
        'aria-controls': `scrollable-auto-tabpanel-${index}`,
    };
}

export default function TestResultsDialog(props) {
    const classes = useStyles();
    const [open, setOpen] = React.useState(false);
    const [value, setValue] = React.useState(0);
    const [testRequests, setTestRequests] = React.useState([]);
    const [components, setComponents] = React.useState([]);

    const columns = [
        { field: 'parameter_name', headerName: 'Parameter Name', width: 200 },
        { field: 'unit', headerName: 'Unit', width: 130 },
        { field: 'min_value', headerName: 'Min Value', width: 130, type: 'number', },
        { field: 'max_value', headerName: 'Max Value', width: 130, type: 'number', },
        { field: 'score', headerName: 'Score', type: 'number', width: 90, }
    ];

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const handleTabChange = (event, newValue) => {
        console.log(newValue);
        setValue(newValue);
    };

    useEffect(() => {
        let isMounted = true;

        axios.get(`http://localhost:8080/testRequest/getByAppointment/${props.app_id}`).then(response => {
            if (isMounted) {
                console.log(response.data);
                setTestRequests(response.data);
            }
        })

        return () => { isMounted = false };
    },[props.app_id])

    useDidMountEffect(() => {
        axios.get(`http://localhost:8080/result/getByTest/${testRequests[value].request_id}`).then(response => {
            let count = 0;
            setComponents(response.data.map(v => ({...v, id: count++ })));
        })
    },[value, testRequests])

    return (
        <React.Fragment>
            <Button variant="outlined" color="primary" onClick={handleClickOpen}>
                Check Test Results
            </Button>
            <Dialog
                fullWidth={true}
                maxWidth={'lg'}
                open={open}
                onClose={handleClose}
                aria-labelledby="max-width-dialog-title"
            >
                <DialogTitle id="max-width-dialog-title">Test Results</DialogTitle>
                <DialogContent>
                    <DialogContentText>
                        You can set the test results in this dialog.
                    </DialogContentText>
                    <AppBar position="static" color="default" className={classes.appBar}>
                        <Tabs
                            value={value}
                            onChange={handleTabChange}
                            indicatorColor="primary"
                            textColor="primary"
                            variant="scrollable"
                            scrollButtons="auto"
                            aria-label="scrollable auto tabs example"
                        >
                            {testRequests.map((request, index) =>
                                (<Tab key={index} label={request.name} {...a11yProps(index)} disabled={!(request.status === 'Finalized')} />))}
                        </Tabs>
                    </AppBar>
                    {testRequests.map((request, index) =>
                        (<TabPanel key={index} value={value} index={index}>
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
                        </TabPanel>))}
                </DialogContent>
                <DialogActions>
                    <Button onClick={handleClose} color="primary">
                        Close
                    </Button>
                </DialogActions>
            </Dialog>
        </React.Fragment>
    );

}