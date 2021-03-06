import React, {useEffect} from 'react';
import clsx from 'clsx';
import {makeStyles, useTheme} from '@material-ui/core/styles';
import Drawer from '@material-ui/core/Drawer';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import List from '@material-ui/core/List';
import CssBaseline from '@material-ui/core/CssBaseline';
import Typography from '@material-ui/core/Typography';
import Divider from '@material-ui/core/Divider';
import IconButton from '@material-ui/core/IconButton';
import MenuIcon from '@material-ui/icons/Menu';
import ChevronLeftIcon from '@material-ui/icons/ChevronLeft';
import ChevronRightIcon from '@material-ui/icons/ChevronRight';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import TableChartIcon from '@material-ui/icons/TableChart';
import ExitToAppIcon from '@material-ui/icons/ExitToApp';
import EventIcon from '@material-ui/icons/Event';
import axios from "axios";
import {Route, useHistory} from "react-router-dom";
import HomePage from "./homepage/HomePage";
import TestRequestsPanel from "./testresults/TestRequestsPanel";
import GetAppointmentPanel from "./getappointment/GetAppointmentPanel";
import HomeIcon from '@material-ui/icons/Home';
import GeneralTestViewGrid from "./testresults/GeneralTestViewGrid";
import ComponentViewGrid from "./testresults/ComponentViewGrid";
import {Snackbar} from "@material-ui/core";
import {Alert} from "@material-ui/lab";

const drawerWidth = 240;

const useStyles = makeStyles((theme) => ({
    root: {
        display: 'flex',
    },
    appBar: {
        zIndex: theme.zIndex.drawer + 1,
        transition: theme.transitions.create(['width', 'margin'], {
            easing: theme.transitions.easing.sharp,
            duration: theme.transitions.duration.leavingScreen,
        }),
    },
    appBarShift: {
        marginLeft: drawerWidth,
        width: `calc(100% - ${drawerWidth}px)`,
        transition: theme.transitions.create(['width', 'margin'], {
            easing: theme.transitions.easing.sharp,
            duration: theme.transitions.duration.enteringScreen,
        }),
    },
    menuButton: {
        marginRight: 36,
    },
    hide: {
        display: 'none',
    },
    drawer: {
        width: drawerWidth,
        flexShrink: 0,
        whiteSpace: 'nowrap',
    },
    drawerOpen: {
        width: drawerWidth,
        transition: theme.transitions.create('width', {
            easing: theme.transitions.easing.sharp,
            duration: theme.transitions.duration.enteringScreen,
        }),
    },
    drawerClose: {
        transition: theme.transitions.create('width', {
            easing: theme.transitions.easing.sharp,
            duration: theme.transitions.duration.leavingScreen,
        }),
        overflowX: 'hidden',
        width: theme.spacing(7) + 1,
        [theme.breakpoints.up('sm')]: {
            width: theme.spacing(9) + 1,
        },
    },
    toolbar: {
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'flex-end',
        padding: theme.spacing(0, 1),
        // necessary for content to be below app bar
        ...theme.mixins.toolbar,
    },
    content: {
        flexGrow: 1,
        padding: theme.spacing(3),
    },
    paper: {
        padding: theme.spacing(2),
        display: 'flex',
        overflow: 'auto',
        flexDirection: 'column',
    },
}));

export default function PatientPanel() {
    const classes = useStyles();
    const theme = useTheme();
    const [open, setOpen] = React.useState(false);
    const [userDetails, setUserDetails] = React.useState({});
    const history = useHistory();
    const [count, setCount] = React.useState(0);
    const [isAppSnackbarOpen, setAppSnackbarOpen] = React.useState(false);
    const [isEvaluateSnackbarOpen, setEvaluateSnackbarOpen] = React.useState(false);

    const handleDrawerOpen = () => {
        setOpen(true);
    };

    const handleDrawerClose = () => {
        setOpen(false);
    };

    const handleAppClose = (event, reason) => {
        if (reason === 'clickaway') {
            return;
        }

        setAppSnackbarOpen(false);
    };

    const handleEvaluateClose = (event, reason) => {
        if (reason === 'clickaway') {
            return;
        }

        setEvaluateSnackbarOpen(false);
    };

    useEffect(() => {
        let userDetails = JSON.parse(localStorage.getItem('user'));
        axios.get(`http://localhost:8080/patient/get/${userDetails.ssn}`).then(response => {
            setUserDetails(response.data);
        })
    },[])

    return (
        <div className={classes.root}>
            <CssBaseline />
            <AppBar
                position="fixed"
                className={clsx(classes.appBar, {
                    [classes.appBarShift]: open,
                })}
            >
                <Toolbar>
                    <IconButton
                        color="inherit"
                        aria-label="open drawer"
                        onClick={handleDrawerOpen}
                        edge="start"
                        className={clsx(classes.menuButton, {
                            [classes.hide]: open,
                        })}
                    >
                        <MenuIcon />
                    </IconButton>
                    <Typography variant="h6" noWrap>
                        e-Bni Sina - Patient Panel
                    </Typography>
                </Toolbar>
            </AppBar>
            <Drawer
                variant="permanent"
                className={clsx(classes.drawer, {
                    [classes.drawerOpen]: open,
                    [classes.drawerClose]: !open,
                })}
                classes={{
                    paper: clsx({
                        [classes.drawerOpen]: open,
                        [classes.drawerClose]: !open,
                    }),
                }}
            >
                <div className={classes.toolbar}>
                    <IconButton onClick={handleDrawerClose}>
                        {theme.direction === 'rtl' ? <ChevronRightIcon /> : <ChevronLeftIcon />}
                    </IconButton>
                </div>
                <Divider />
                <List>
                    <ListItem button onClick={() => history.push("/patient") } key = "homepage">
                        <ListItemIcon>
                            <HomeIcon/>
                        </ListItemIcon>
                        <ListItemText primary="Home Page"/>
                    </ListItem>
                    <ListItem button onClick={() => history.push("/patient/tests") } key = "tests">
                        <ListItemIcon>
                            <TableChartIcon/>
                        </ListItemIcon>
                        <ListItemText primary="Tests"/>
                    </ListItem>
                    <ListItem button onClick={() => history.push("/patient/getAppointment") } key = "appointments">
                        <ListItemIcon>
                            <EventIcon/>
                        </ListItemIcon>
                        <ListItemText primary="Get Appointment"/>
                    </ListItem>
                </List>
                <Divider />
                <List>
                    <ListItem button onClick={() => history.push("/logout") } key= "logout">
                        <ListItemIcon>
                            <ExitToAppIcon />
                        </ListItemIcon>
                        <ListItemText primary= "Log Out" />
                    </ListItem>
                </List>
            </Drawer>
            <Snackbar open={isAppSnackbarOpen} autoHideDuration={5000} onClose={handleAppClose}>
                <Alert onClose={handleAppClose} severity="success" variant="filled">
                    Appointment is successfully taken!
                </Alert>
            </Snackbar>
            <Snackbar open={isEvaluateSnackbarOpen} autoHideDuration={5000} onClose={handleEvaluateClose}>
                <Alert onClose={handleEvaluateClose} severity="success" variant="filled">
                    Appointment is successfully evaluated!
                </Alert>
            </Snackbar>
            <main className={classes.content}>
                <div className={classes.toolbar} />
                    <div className="App">
                        <Route path="/patient" exact component={() => <HomePage
                            update={count}
                            setUpdate={setCount}
                            userDetails={userDetails}
                            setEvaluationSuccess={setEvaluateSnackbarOpen}
                        />} />
                        <Route path="/patient/tests" exact component={TestRequestsPanel} />
                        <Route path="/patient/test/:requestId/:typeId" exact component= {GeneralTestViewGrid}  />
                        <Route path="/patient/test/component/:typeId/:parameterName" exact component= {ComponentViewGrid}  />
                        <Route path="/patient/getAppointment" exact component={() =>
                            <GetAppointmentPanel
                                setAppSuccess={setAppSnackbarOpen}
                                userDetails={userDetails}
                            />} />
                    </div>
            </main>
        </div>
    );
}