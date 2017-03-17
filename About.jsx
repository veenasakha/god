import React,{Component} from 'react';

class About extends Component{
    constructor(props){
        super(props);
        console.log(this.props.match.params);
    }
    render(){
    return(
        <h1>{this.props.match.params.name}</h1>
    );
}
}
export default About;