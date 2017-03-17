import React,{Component} from 'react';
class Test extends Component{
    render(){
        var mystyle={
            fontSize:70,
            color:'#FF0000'        }
        return(
            <h1 style={mystyle}>Hello world</h1>
        );
    }
}
class Test1 extends Component{
    render(){

        return(
            <h1>Hello world</h1>
        );
    }
}
export default {Test,Test1}; 
