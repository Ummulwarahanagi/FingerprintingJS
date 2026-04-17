Overview

This project implements a Guest User Fingerprinting System to track and identify users without requiring login.
It uses browser and device characteristics to generate a unique fingerprint ID, enabling tracking across sessions without relying on cookies.

Objectives
Identify anonymous users uniquely
Track user activity across sessions
Store event data for analysis
Reduce dependency on cookies

Technologies Used
Frontend: HTML, CSS, JavaScript
Fingerprinting Library: FingerprintJS
Backend: Spring Boot (Java)
Database: H2 Database

How It Works
User visits the website
Browser data (signals) are collected
A unique fingerprint ID is generated
Event data (click, page view) is sent to backend
Backend stores data in database
Data can be retrieved for analysis

Database Schema (Suggested)

Table: guest_events

Field	               Type	      Description
id	       ->         Long	 ->     Primary Key\n
fingerprint_id	->    String	->    Unique user identifier\n
event	          ->    String	  ->  Event type (click/page_view)
url	            ->    String	 ->   Page URL
timestamp	    ->      DateTime	->  Event time

Output
Unique fingerprint ID generated
Multiple events mapped to same user
Data stored and retrieved successfully


