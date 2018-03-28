import React from "react";

class SignIn extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <form className="form-signin">
                <h2 className="form-signin-heading"> Enter registered email and password below </h2>
                <label htmlFor="inputEmail" className="sr-only"> Email address
                </label>
                <input type="email" id="inputEmail" className="form-control" placeholder="Email address" required autoFocus />
                <label htmlFor="inputPassword" className="sr-only"> Password</label>
                <input type="password" id="inputPassword" className="form-control" placeholder="Password" required />
                <button className="btn btn-lg btn-primary btn-block" type="button"> Sign in
                </button>
            </form>
            );
        }
}

export default SignIn;