import React from "react";
import "../styles/glarimy.css";
import Home from "./home.jsx";
import SignIn from "./SignIn.jsx";
import store from "../store/store.js";
import Counter from "./Counter.jsx";
import request from "../node_modules/superagent/superagent";
import {BrowserRouter as Router, Route, Link} from 'react-router-dom';

class NewPost extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            title: "<Input title here>",
            content: "<Write your blog here>"
        };
        store.subscribe( () => this.forceUpdate());
        this.savepost = this.savepost.bind(this);
        this.updatetitle = this.updatetitle.bind(this);
        this.updatecontent = this.updatecontent.bind(this);

    }

    updatetitle(e) {
        this.setState({
            title: e.target.value
        });
     }

     updatecontent(e) {
        this.setState({
            content: e.target.value
        });
     }

    savepost(e) {
        var postData = {};
        postData["title"] = this.state.title;
        postData["content"] = this.state.content;
        console.log(postData);
        request
        .post('/syt/public/v2/users/abc123/posts')
        .set('Content-Type', 'application/json')
        .set('Access-Control-Allow-Origin', '*')
        .set('Access-Control-Allow-Methods', 'GET, POST, PATCH, PUT, DELETE, OPTIONS')
        .set('Access-Control-Allow-Headers', 'Origin, Content-Type, X-Auth-Token')
        .send(postData)
        .end(function(err, res){
        console.log(res.text);
});  

    }

    render() {
        return (
            <div>
            <label for="name">Blog Title</label> 
	        <input name="name" type="text" size="100" defaultValue={this.state.title} onChange={this.updatetitle}/> <br /> 
            <label for="name">Blog Content</label> <br />
	        <textarea cols="200" rows="50" onChange={this.updatecontent}>{this.state.content}</textarea><br /> 
            <button type="submit" value="Save" onClick={this.savepost}>Save</button>
            </div>
            );
        }
    };
    
    export default NewPost;

