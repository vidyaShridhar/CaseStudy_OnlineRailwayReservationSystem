import React, { Component } from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import { Button } from "bootstrap";

const Contact = props => (
  <tr>
    <td> {props.contact.id} </td>
    <td> {props.contact.name} </td>
    <td> {props.contact.phoneNumber} </td>
  </tr>

);
class adminProfile extends Component {
  constructor(props) {
    super(props);
    this.state = { admincontacts: [] };
  }

  componentDidMount() {
    axios
      .get("http://localhost:9001/contacts/findAll")
      .then(response => {
        this.setState({ admincontacts: response.data });
      })
      .catch(function(error) {
        console.log(error);
      });
  }
  adminprofile() {
    return this.state.admincontacts.map(function(currentContact, i) {
      return <Contact contact={currentContact} key={i} />;
    });
  }



  render() {
    return (
      <div>
        <table className="table table-striped" style={{ marginTop: 20 }}>
          <thead>
            <tr>
              <th> ID </th>
              <th> Name </th>
              <th> Phone Number </th>
            </tr>
          </thead>
          <tbody>{this.adminprofile()}</tbody>
        </table>
      </div>
    );
  }
}

export default adminProfile;