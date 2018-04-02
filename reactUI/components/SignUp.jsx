import React from "react";
import request from "../node_modules/superagent/superagent";


class SignUp extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            name:'',
            email:'',
            password:''
          };
        this.handleNameChange = this.handleNameChange.bind(this);
        this.handleEmailChange = this.handleEmailChange.bind(this);
        this.handlePasswordChange = this.handlePasswordChange.bind(this);
        this.signUp = this.signUp.bind(this);
    }

    signUp(){
        var postData = {};
        postData["userName"] = this.state.name;
        postData["email"] = this.state.email;
        postData["password"] = this.state.password;
        console.log(postData);
        request
        .post('/syt/public/v2/users')
        .set('Content-Type', 'application/json')
        .set('Access-Control-Allow-Origin', '*')
        .set('Access-Control-Allow-Methods', 'GET, POST, PATCH, PUT, DELETE, OPTIONS')
        .set('Access-Control-Allow-Headers', 'Origin, Content-Type, X-Auth-Token')
        .send(postData)
        .then(function (res) {
            console.log("res.header[location]" + res.header['location']);
            this.props.history.push(`/mypath`)
        })
        .catch(function (error) {
          console.log(error);
        });
    }

    handleNameChange(e){
        this.setState({name:e.target.value})
    }
    handleEmailChange(e){
        this.setState({email:e.target.value})
    }   
    handlePasswordChange(e){
        this.setState({password:e.target.value})
    }

    render() {
        return (
            <div>
            <form className="form-signin">
              <h2 className="form-signin-heading">Register here</h2>
              <label htmlFor="inputName" className="sr-only">Name</label>
              <input type="name" onChange={this.handleNameChange} id="inputName" className="form-control" placeholder="Name" required autoFocus />
              <label htmlFor="inputEmail" className="sr-only">Email address</label>
              <input type="email" onChange={this.handleEmailChange} id="inputEmail" className="form-control" placeholder="Email address"/>
              <label htmlFor="inputPassword" className="sr-only">Password</label>
              <input type="password" onChange={this.handlePasswordChange} id="inputPassword" className="form-control" placeholder="Password" required />
              <button className="btn btn-lg btn-primary btn-block" onClick={this.signUp} type="button">Sign up</button>
            </form>
          </div>
            );
        }
};

export default SignUp;