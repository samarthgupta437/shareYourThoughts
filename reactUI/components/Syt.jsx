import "../styles/glarimy.css";
import React from "react";
import Home from "./home.jsx";
import SignIn from "./SignIn.jsx";
import SignUp from "./SignUp.jsx";
import NewPost from "./NewPost.jsx";
import store from "../store/store.js";
import Counter from "./Counter.jsx";

import {BrowserRouter as Router, Route, Link} from 'react-router-dom';


class Syt extends React.Component {
    constructor(props) {
        super(props);
    store.subscribe( () => this.forceUpdate());
}
render() {
    return (
        <Router>
        <div>
            <h1>Syt Blog</h1>
            <Link to="/">Home</Link> | <Link to="/signin">Sign In</Link> | <Link to="/signup">Sign Up</Link> |<Link to="/newpost">Write Blog</Link>
            <hr/>
            <Route exact path="/" component={Home}/>
            <Route path="/signin" component={SignIn}/>
            <Route path="/signup" component={SignUp}/>
            <Route path='/newpost' component={NewPost}/>
        </div>
        </Router>
    );
}
};

export default Syt;