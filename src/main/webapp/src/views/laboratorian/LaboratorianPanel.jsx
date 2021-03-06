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
import ExitToAppIcon from '@material-ui/icons/ExitToApp';
import {Route, useHistory} from "react-router-dom";
import HomeIcon from '@material-ui/icons/Home';
import axios from "axios";
import LaboratorianHomePage from "./homepage/LaboratorianHomePage";
import TestDataGrid from "./homepage/TestDataGrid";
import {Alert} from "@material-ui/lab";
import {Snackbar} from "@material-ui/core";
import LaboratorianReport from "./LaboratorianReport";
import AssessmentIcon from '@material-ui/icons/Assessment';

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

export default function LaboratorianPanel() {
    const classes = useStyles();
    const theme = useTheme();
    const [open, setOpen] = React.useState(false);
    const [userDetails, setUserDetails] = React.useState({});
    const history = useHistory();
    const [count, setCount] = React.useState(0);
    const [isLaboSnackbarOpen, setLaboSnackbarOpen] = React.useState(false);
    const [isLaboFailSnackbarOpen, setLaboFailSnackbarOpen] = React.useState(false);

    const handleDrawerOpen = () => {
        setOpen(true);
    };

    const handleDrawerClose = () => {
        setOpen(false);
    };

    const handleLaboClose = (event, reason) => {
        if (reason === 'clickaway') {
            return;
        }

        setLaboSnackbarOpen(false);
    };

    const handleLaboFailClose = (event, reason) => {
        if (reason === 'clickaway') {
            return;
        }

        setLaboFailSnackbarOpen(false);
    };

    useEffect(() => {
        let userDetails = JSON.parse(localStorage.getItem('user'));
        console.log(userDetails);
        axios.get(`http://localhost:8080/laboratorian/get/${userDetails.laboratorian_id}`).then(response => {
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
                        e-Bni Sina - Laboratorian Panel
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
                    <ListItem button onClick={() => history.push("/laboratorian") } key = "homepage">
                        <ListItemIcon>
                            <HomeIcon/>
                        </ListItemIcon>
                        <ListItemText primary="Home Page"/>
                    </ListItem>
                    <ListItem button onClick={() => history.push("/laboratorian/report") } key = "report">
                        <ListItemIcon>
                            <AssessmentIcon/>
                        </ListItemIcon>
                        <ListItemText primary="Report"/>
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
            <Snackbar open={isLaboSnackbarOpen} autoHideDuration={5000} onClose={handleLaboClose}>
                <Alert onClose={handleLaboClose} severity="success" variant="filled">
                    Test processed successfully!
                </Alert>
            </Snackbar>
            <Snackbar open={isLaboFailSnackbarOpen} autoHideDuration={5000} onClose={handleLaboFailClose}>
                <Alert onClose={handleLaboFailClose} severity="error" variant="filled">
                    The process has failed!
                </Alert>
            </Snackbar>
            <main className={classes.content}>
                <div className={classes.toolbar} />
                <div className="App">
                    <Route path="/laboratorian" exact component= {() => <LaboratorianHomePage update={count} setUpdate={setCount} userDetails={userDetails} />}  />
                    <Route path="/laboratorian/report" exact component= {() => <LaboratorianReport userDetails={userDetails} />}  />
                    <Route path="/laboratorian/test/:requestId/:typeId" exact component= {() => <TestDataGrid setLaboSuccess={setLaboSnackbarOpen} setlabofail={setLaboFailSnackbarOpen}/>}  />
                </div>
            </main>
        </div>
    );
}