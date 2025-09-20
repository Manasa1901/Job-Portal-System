# 🧑‍💼 Job Portal System

## 📌 Project Description
The **Job Portal System** is a Java-based application that connects **job seekers** and **employers**.  
It allows employers to post job opportunities and job seekers to apply for them.  
The project demonstrates the use of **Object-Oriented Programming (OOP)** concepts and can be extended with **database integration** for permanent storage.

---

## 🚩 Problem Statement
Finding suitable jobs and hiring qualified candidates is often a time-consuming and inefficient process.  
Job seekers struggle to access relevant opportunities and track applications, while employers face challenges in managing postings and filtering candidates.  
The proposed **Job Portal System** provides a simple, interactive platform to streamline the recruitment process for both parties.

---

## 🎯 Objectives
- Provide a centralized platform for employers and job seekers.  
- Implement job postings, job applications, and basic search features.  
- Apply OOP concepts such as **Encapsulation, Inheritance, Polymorphism, and Abstraction**.  
- Prepare a scalable system that can later integrate with **databases** and **web technologies**.  

---

## ✨ Features Implemented (Partial Prototype)
- Register a Job Seeker  
- Register an Employer  
- Post Jobs by Employers  
- Apply for Jobs by Job Seekers  
- View All Jobs Posted  
- Console-based menu-driven prototype  

---

## 🛠️ Tech Stack
- **Language**: Java  
- **IDE**: VS Code / IntelliJ / Eclipse (any Java IDE)  
- **Version Control**: Git + GitHub  
- **Database**: (Planned - MySQL with JDBC for final version)  

---

## 🧩 OOP Concepts Applied
- **Encapsulation** → Data members are private, accessed via getters/setters.  
- **Inheritance** → Common entities can be extended (future scope).  
- **Polymorphism** → Methods can be overridden for specialized behavior.  
- **Abstraction** → Core functionalities separated into classes.  

---

## 🚀 Future Enhancements
- Add **database support** (MySQL + JDBC) for storing users, jobs, and applications.  
- Implement **login system** for Job Seekers and Employers.  
- Add **job search by skills or location**.  
- Provide **GUI or web interface** instead of console.  

---

# 📊 Class Diagram

```plaintext
                        ┌───────────────────┐
                        │      User         │
                        │───────────────────│
                        │ - userId : int    │
                        │ - name : String   │
                        │ - email : String  │
                        │ - password : String│
                        │───────────────────│
                        │ + login()         │
                        │ + logout()        │
                        └─────────▲─────────┘
                                  │
     ┌────────────────────────────┼─────────────────────────────┐
     │                            │                             │
┌───────────────┐         ┌────────────────┐           ┌────────────────┐
│   JobSeeker    │         │    Employer    │           │     Admin      │
│─────────────── │         │────────────────│           │────────────────│
│ - resume : File│         │ - companyName  │           │ - role : String │
│ - skills : List│         │ - jobsPosted   │           │                │
│────────────────│         │────────────────│           │────────────────│
│ + applyJob()   │         │ + postJob()    │           │ + manageUsers() │
│ + uploadResume()│        │ + reviewApps() │           │ + manageJobs()  │
└────────────────┘         └────────────────┘           └────────────────┘

             ┌───────────────────────────────────┐
             │               Job                 │
             │───────────────────────────────────│
             │ - jobId : int                     │
             │ - title : String                  │
             │ - description : String            │
             │ - requirements : List<String>     │
             │ - employerId : int                │
             │───────────────────────────────────│
             │ + addJob()                        │
             │ + updateJob()                     │
             │ + deleteJob()                     │
             └───────────────────────────────────┘

             ┌───────────────────────────────────┐
             │          Application              │
             │───────────────────────────────────│
             │ - appId : int                     │
             │ - jobId : int                     │
             │ - seekerId : int                  │
             │ - status : String                 │
             │───────────────────────────────────│
             │ + submitApplication()             │
             │ + updateStatus()                  │
             └───────────────────────────────────┘

             ┌───────────────────────────────────┐
             │        AIResumeMatcher            │
             │───────────────────────────────────│
             │ - model : String                  │
             │───────────────────────────────────│
             │ + parseResume(resume)             │
             │ + matchSkills(resume, job)        │
             │ + rankCandidates(job)             │
             └───────────────────────────────────┘



