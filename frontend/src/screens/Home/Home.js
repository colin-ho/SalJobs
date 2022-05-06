import axios from 'axios';
import React, { useState, useEffect, useContext } from 'react';
import { Form, Button, Modal, } from "react-bootstrap";
import { Accordion } from "react-bootstrap";
import { useNavigate } from 'react-router-dom';
import { UserContext } from '../../App';
import Header from '../../components/Header';

export default function Home() {
    const { user } = useContext(UserContext)
    const [listings, setListings] = useState([])
    const [title, setTitle] = useState("")
    const [description, setDescription] = useState("")
    const [company, setCompany] = useState("")
    const [location, setLocation] = useState("")
    const [message, setMessage] = useState("")
    const [show, setShow] = useState(false);
    const navigate = useNavigate();

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    let isLoggedin = true

    useEffect(() => {
        getListings()
    }, []);

    //example api call
    const getListings = async () => {
        const response = await axios.get("http://localhost:8080/listings/getAll")
        setListings(response.data)
    }

    const createListing = async (e) => {
        e.preventDefault()
        const response = await axios.post("http://localhost:8080/listings/create",
            {
                title: title,
                description: description,
                company: company,
                location: location,
                recruiterId: user.id,
                recruiterName:user.name,
            })
        console.log(response)
        window.location.reload(false);
    }

    const apply = async (recruiterId,recruiterName) => {
        const response1 = await axios.post("http://localhost:8080/chats/create",
            {
                applicantId: user.id,
                recruiterId: recruiterId,
                applicantName:user.name,
                recruiterName:recruiterName,
                initialMessage:message
            }
        )
        console.log(response1)
        navigate("/inbox")
    }

    return (
        <div>
            <Header />
            <div className="AppBody">
                <>
                    <Form.Text id="companySearch">
                        Company Name:
                    </Form.Text>
                </>
                <input type="text" placeholder='Search' style={{ width: '700px', marginBottom: '30px' }} /><Button variant="primary">Search</Button>{' '}
                {user && <Button variant="primary" onClick={handleShow}>Create listing</Button>}
                <Modal show={show} onHide={handleClose}>
                    <Modal.Header closeButton>
                        <Modal.Title>Modal heading</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                        <form onSubmit={(e) => createListing(e)}>
                            <input placeholder='title'
                                value={title}
                                onChange={(e) => setTitle(e.target.value)}
                            ></input>
                            <input placeholder='company'
                                value={company}
                                onChange={(e) => setCompany(e.target.value)}
                            ></input>
                            <input placeholder='location'
                                value={location}
                                onChange={(e) => setLocation(e.target.value)}
                            ></input>
                            <textarea placeholder='description'
                                value={description}
                                onChange={(e) => setDescription(e.target.value)}
                            ></textarea>
                            <button type="submit">submit</button>
                        </form>
                    </Modal.Body>
                    <Modal.Footer>
                        <Button variant="secondary" onClick={handleClose}>
                            Close
                        </Button>
                        <Button variant="primary" onClick={handleClose}>
                            Save Changes
                        </Button>
                    </Modal.Footer>
                </Modal>
                <Accordion>
                    {listings && listings.map((listing) => {
                        return (
                            <Accordion.Item key={listing.id} eventKey={listing.id} style={{ width: '1000px', left: '17%', }}>
                                <Accordion.Header>{listing.title}</Accordion.Header>
                                <Accordion.Body>
                                    Description:
                                    {listing.description}
                                    <br />
                                    Company:
                                    {listing.company}
                                    <br />
                                    {isLoggedin && <div>
                                        <textarea placeholder='message' value={message} onChange={(e) => setMessage(e.target.value)}></textarea>
                                        <Button variant="outline-primary" onClick={()=>apply(listing.recruiterId,listing.recruiterName)}>Apply</Button>{' '}
                                    </div>}
                                </Accordion.Body>
                            </Accordion.Item>
                        )
                    })}
                </Accordion>
            </div>
        </div>
    );
}