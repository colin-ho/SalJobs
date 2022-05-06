import axios from 'axios'
import React, { useContext, useEffect, useState } from 'react'
import { Col, ListGroup, Row, Tab } from 'react-bootstrap'
import { UserContext } from '../../App'
import Header from '../../components/Header'

export function Inbox() {

    const { user } = useContext(UserContext)
    const [chats, setChats] = useState([])

    useEffect(() => {
        getChats()
    }, []);

    //example api call
    const getChats = async () => {
        const response = await axios.get(`http://localhost:8080/chats/getChats/${user.id}`)
        setChats(response.data)
        console.log(response.data)
    }
    return (
        <>
            <Header />
            <Tab.Container id="list-group-tabs-example" defaultActiveKey="#link1">
                <Row>
                    <Col sm={4}>
                        <ListGroup>

                            {chats.map((chat) => {
                                return (
                                    <ListGroup.Item key={chat.id} action href={"#"+chat.id}>
                                        {chat.recruiterName + " and " + chat.applicantName}
                                    </ListGroup.Item>
                                )
                            })}
                        </ListGroup>
                    </Col>
                    <Col sm={8}>
                        <Tab.Content>
                            {chats.map((chat) => {
                                return (
                                    <Tab.Pane key={chat.id} eventKey={"#"+chat.id}>
                                        {chat.initialMessage}
                                    </Tab.Pane>
                                )
                            })}
                        </Tab.Content>
                    </Col>
                </Row>
            </Tab.Container>
        </>
    )
}


