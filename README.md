
# 💼 Job-Portal-System

The **Job Portal System** is a Java-based application integrated with a MySQL database to simplify and automate the hiring process. It connects job seekers and employers through a centralized platform, enabling profile management, job posting, job applications, and status tracking. This system ensures transparency, efficiency, and better communication between applicants and recruiters.

---

## 📝 Problem Statement

Finding suitable jobs and hiring qualified candidates is often a time-consuming and inefficient process. Job seekers struggle to access relevant opportunities and track applications, while employers face challenges in managing job postings and filtering candidates. Manual methods lead to delays, miscommunication, and lack of transparency.

**Solution:**  
This system provides a centralized digital platform where job seekers can apply for jobs and employers can post openings, review applicants, and manage the recruitment process seamlessly using Java and MySQL.

---

## 🎯 Target Users
- 👨‍🎓 **Job Seekers** – who are looking for job opportunities and want to apply online.  
- 🏢 **Employers/Companies** – who want to post jobs and hire suitable candidates.  
- 🛡️ **Administrators** – who manage and monitor platform usage and data.  

---

# 🛠️ Tech Stack

- **Programming Language:** Java (OOP concepts)  
- **Database:** MySQL (via JDBC)  
- **Back-End:** Java
- **Front-End (Optional):** JavaFX / Web (HTML, CSS, JS)  

---

## 📌 Key Features
- 👤 **Job seeker registration and profile management**  
- 📄 **Resume upload and application submission**  
- 🔍 **Job search and filtering by skills, location, type**  
- 📝 **Employer job posting and management**  
- ✅ **Application status tracking (Applied, Shortlisted, Hired, Rejected)**  
- 💬 **Admin control for user/job monitoring**  

---
# 🎯 OOP Concepts Applied

**Encapsulation**  
All user details (JobSeeker, Employer, Admin) and job data are enclosed within dedicated classes.  
Internal data is hidden, exposing only necessary methods to interact with them.

**Abstraction**  
Abstract classes and interfaces define contracts for operations like job posting, job searching, and application submission.  
Users don’t need to know the underlying implementation details.

**Inheritance**  
Specialized classes like `JobSeeker`, `Employer`, and `Admin` extend a common `User` base class.  
Reduces redundancy and improves code reusability.

**Polymorphism**  
Methods such as `applyForJob()` or `postJob()` can behave differently depending on the object type.  
Supports both compile-time (method overloading) and run-time (method overriding) polymorphism.

**Modularity**  
The project is divided into modules:  
- **User Module** → Manages JobSeeker, Employer, and Admin profiles.  
- **Job Module** → Handles job postings and applications.  
- **Application Module** → Manages job applications and status tracking.  
- **Database Module** → Handles MySQL database operations via JDBC.  
- **UI Module (Optional)** → Handles JavaFX interactions.

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



