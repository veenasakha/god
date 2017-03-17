import React from 'react';
import ReactDOM from 'react-dom';
//import App from './App';
import './index.css';
import {BrowserRouter as Router,Route,Link} from 'react-router-dom';
import Home from './Home';
import Contact from  './Contact';
import About from'./About';

ReactDOM.render((
  <Router>
    <div>
      <ul>
        <li><Link to="/">Home</Link></li>
        <li><Link to="/about">About</Link></li>
        <li><Link to="/contact">contact</Link></li>
        </ul>
        <Route exact path="/" component={Home}/>
         <Route  path="/about/:id/:name" component={About}/>
          <Route path="/contact" component={Contact}/>
          </div>
          </Router>
    
 ), document.getElementById('root'));
