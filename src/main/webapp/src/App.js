import React from 'react';
import SignIn from './views/SignIn.jsx'
import {BrowserRouter as Router, Redirect, Route, useHistory} from "react-router-dom";
import DoctorPanel from "./views/doctor/DoctorPanel";
import PatientPanel from "./views/patient/PatientPanel";
import LaboratorianPanel from "./views/laboratorian/LaboratorianPanel";

export default function App() {
  const [type, setType] = React.useState("notLoggedIn");
  const history = useHistory();

  return (
      <Router history={history}>
        <div className="App">
          <Route path="/" exact component={() => <SignIn setLoginStatus={setType} loginStatus={type} />} />
          <Route path="/logout" exact component={() => {
              localStorage.removeItem("user");
              setType("notLoggedIn"); /*Causes error, fix it*/
              return(<Redirect to="/" />)} }/>
            <Route path="/patient" component={PatientPanel} />
            <Route path="/doctor" component={DoctorPanel} />
            <Route path="/laboratorian" component={LaboratorianPanel} />
        </div>
      </Router>
  );
}
