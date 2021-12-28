import React, { Component, useContext, useState, Fragment } from "react";
import { Link} from "react-router-dom";
import { Formik, Form, Field } from "formik";
import { useHistory, useLocation } from "react-router-dom";
import * as Yup from "yup";
import _get from "lodash.get";
import style from "../../src/style.module.css/signIn.style.css";



const LoginSchema = Yup.object().shape({
  password: Yup.string().required("Password is required!"),
  username: Yup.string().required("username is required!")
});

const Login = () => { 
    const [username, setUsername] = useState('');
    const [password,setPassword] = useState('')
    const history = useHistory();
    const location = useLocation();
    const fromUrl = _get(location, "state.from.pathname");
    const signInSuccess = (userData) => {
        if (fromUrl) {
          history.push(fromUrl);
        } else {
          history.push("/addTrain");
        }
      };
      
        const login = (userData) => {
            fetch("http://localhost:9005/auth", {
              "method": "POST",
              "headers": {
                "content-type": "application/json",
                "accept": "application/json",
                "Access-Control-Allow-Origin": "*"
              },
              "body": JSON.stringify({
                username: userData.username,
                password: userData.password
              })
            })
            .then(response => response.json())
            .then(response => {
              if(response.error){
               alert('your userId and password is not correct');
              }else {
                const userData = {
                  token:response,
                  name:username
              } 
               signInSuccess(userData)
               console.log(response)
              }
            })
            .catch(err => {
              console.log(err);
            });
        }
        return (
            <Formik
            initialValues={{
              username: "",
              password: ""
            }}
            validationSchema={LoginSchema}
            onSubmit={async (values, { resetForm }) => {
              try {
                const userData = { ...values };
                resetForm();
                login(userData);
              } catch (err) {
                console.error(err);
              }
            }}
          >
            {() => (
                <Form>
              <div className="outer" style={{display:'block',textAlign:'center',padding:70}} >
          <div className="inner">
                  <h3>Admin Sign In</h3>
                  <Field
              name="username"
              type="text"
              placeholder="Enter username"
              style={{margin:20}}
            
            /><br/>
            <Field
              name="password"
              type="password"
              placeholder="Password"
              style={{margin:20}}
              
            /><br/>
            <button className="auth-button block" onClick={() => {}} style={{marginTop:20}}>
              Sign In
            </button>
      
            <p>Don't have a account?<Link to="/signUp"> Register Here</Link></p>
            </div>
            </div>
          </Form>
          )}
          </Formik>
        );
          
      
    }
    export default Login;