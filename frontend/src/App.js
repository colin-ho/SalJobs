import logo from './logo.svg';
import './App.css';

/*
This is the initial entrypoint to the frontend. The screens folder contains
the separate files for the separate screens. 
*/

function App() {

    //example api call
    const getListings = async()=>{
        const response = await fetch("http://localhost:8080/listings")
        console.log(response)
    }

    return (
        <div className="App">
            <header className="App-header">
                <img src={logo} className="App-logo" alt="logo" />
                <p>
                    Edit <code>src/App.js</code> and save to reload.
                </p>
                <a
                    className="App-link"
                    href="https://reactjs.org"
                    target="_blank"
                    rel="noopener noreferrer"
                >
                    Learn React
                </a>
            </header>
        </div>
    );
}

export default App;
