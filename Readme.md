# CorpChat

This is the simple app, that allow to videocall to another user.

## Used technology
- SpringBoot(REST API and Authentication via REST)
- Hibernate(ORM)
- PeerJS(Signaling server)
- Angular5(Web Client)


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.
CorpChat consist of three projects:
- https://github.com/pawel12574/VideoCorpChatServer   Server side(Spring). 
- https://github.com/pawel12574/VideoCorpChatClient   Clinet(Angular)
- https://github.com/pawel12574/PeerJS                Signaling server(Node)

Clone first(contains builded second Angualar project) and last project PeerJS.<br>
Install xampp, run mysql server and create empty database 'videochat'. Default there is no password, so you must set your password to mysql or change application.properties file in this part of project.<br>
Run PeerJS server(see readme of PeerJS project)<br>
Run Spring Application.
To properly run CorpChat you must run all servers over HTTPS, because camera can work only on https or localhost.


## Screen verison that run on localhost
<br>
<a href="https://ibb.co/cn7XU7"><img src="https://preview.ibb.co/c2YT2S/screenchat.png" alt="screenchat" border="0"></a>

## Class diagram of model
<br>
<a href="https://ibb.co/c6Efgn"><img src="https://preview.ibb.co/jZkWnS/Class_diagram.png" alt="Class_diagram" border="0"></a>

## Architecture
<br>
<a href="https://ibb.co/eJL31n"><img src="https://preview.ibb.co/fTni1n/ChatREST.png" alt="ChatREST" border="0"></a>
