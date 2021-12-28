import React, { Component } from "react";
import train from "../../src/resources/train1.jpg";



export default class Home extends Component {
  render() {
    return (
      
       <div  style={{ 
        backgroundImage: `url(${train})`,
        backgroundPosition: 'center',
        backgroundSize: 'cover',
        backgroundRepeat: 'no-repeat',
        width: '100vw',
        height: '65vh'
      }}>
          <h1 style={{color:'white',textAlign:'center',paddingTop:150}}>Welcome To Online Railway Reservation System</h1>


      </div> 

 
      
    );
  }
}
