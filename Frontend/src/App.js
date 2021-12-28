import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Route, Link, Switch } from "react-router-dom";

//importing the components
import Home from "./components/Home";
import TrainList from "./components/TrainList";
import TicketBooking from "./components/TicketBooking";
import SignUp from "./components/SignUp";
import Login from "./components/Login";
import PaymentMethod from "./components/PaymentMethod";
import PaytmPG from "./components/PaytmPG";
import SBIBankPG from "./components/SBIBankPG";
import ThankYouMessage from "./components/ThankYouMessage";
import adminSignIn from './components/adminSignIn';
import createTrain from './components/createTrain';
import deleteTrain from "./components/deleteTrain";
import adminProfile from "./components/adminProfile";
import updateTrain from "./components/updateTrain";
import railway from ".//railway.png";

//importing the images
// import navImage from "./resources/navnew3.jpg";
import trainicon from "./resources/trainicon.png";

function App() {
  return (
    <Router>
      <div>
    
            <img src={railway} width={230} height={90} style={{paddingLeft:30}}/>
  <Link to="/signUp">
          <button type="button" style={{borderRadius:10,backgroundColor: 'white',marginLeft:800}}>
                        Login/SignUp
                    </button>
                    </Link>
      </div>
      <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
        <div className="collapse navbar-collapse" style={{marginLeft:250}}>
          <ul className="navbar-nav mr-auto">
            <li className="navbar-item">
              <Link to="/" className="nav-link" style={{ color: "white" }}>
              <strong>Home</strong>
              </Link>
            </li>
          </ul>
        </div>
        <div className="collapse navbar-collapse">
          <ul className="navbar-nav mr-auto">
            <li className="navbar-item">
              <Link
                to="/trainlist"
                className="nav-link"
                style={{ color: "white" }}
              >
                <strong>Trains</strong>
              </Link>
            </li>
          </ul>
        </div>
      
      
     
        <div className="collapse navbar-collapse">
          <ul className="navbar-nav mr-auto">
            <li className="navbar-item">
              <Link
                to="/adminSignIn"
                className="nav-link"
                style={{ color: "white" }}
              >
                <strong>Admin</strong>
              </Link>
            </li>
          </ul>
        </div>
      </nav>

      {/* Switching between components */}
      <Switch>
        <Route path="/" exact component={Home} />
        <Route path="/trainlist" exact component={TrainList} />
        <Route path="/booking" exact component={TicketBooking} />
        <Route path="/signUp" exact component={SignUp} />
        <Route path="/login" exact component={Login} />
        <Route path="/payment" exact component={PaymentMethod} />
        <Route path="/submitPaymentDetail" exact component={PaytmPG} />
        <Route path="/thankyou" exact component={ThankYouMessage} />
        <Route path="/sbipg" exact component={SBIBankPG} /> 
        <Route path="/adminSignIn" exact component={adminSignIn} />
        <Route path="/addTrain" exact component={createTrain} />
        <Route path="/delTrain" exact component={deleteTrain} />
        <Route path="/adminProfile" exact component={adminProfile} />
        <Route path="/updateTrain" exact component={updateTrain} />
      </Switch>

      
      <div
        className="footer"
        style={{ backgroundColor: "white", width: 1260, height: 40,paddingTop:15 }}
      >
        <center>
          {" "}
          <div>
            <img src={trainicon} width="40" />{" "}
          </div>{" "}
          <div style={{ color: "white" }}></div>
        </center>
      </div>
    </Router>
  );
}

export default App;
