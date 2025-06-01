## 📘 Attendance Management System (Java Swing)

### 🔐 Login → 📊 Dashboard → 📚 Attendance | 👩‍🏫 Teacher Profile | 🧑‍🎓 Student Marks → 🔓 Logout

---

### 🛠️ Overview

This Java Swing-based Attendance Management System is a beginner-friendly project that helps manage:

* Student attendance across multiple dates
* Teacher profile information
* Student internal and final marks with grades

It includes navigation between pages, editable records, and a basic login system.

---

### 🚀 Features

#### 🔐 Login

* Simple login form with predefined username and password (`JavaLab`, `123456`)
* On successful login, user is redirected to the **Dashboard**

---

#### 📊 Dashboard

* Acts as the central page to navigate:

  * 📌 **Attendance**
  * 📌 **Teacher Profile**
  * 📌 **Student Marks**
  * 🔚 **Logout**
* Each section has a **Back** button to return to the dashboard

---

#### 💾 Attendance

* Displays attendance for 50 students (with serial numbers and names)
* Attendance can be marked:

  * **X** = Present
  * **A** = Absent (displayed in red)
* Add new student via **Add Student** button
* Navigate through dates using **Next** and **Previous** buttons (dates update automatically from March 1st onwards)
* Add new week with **Add Day** button (one week per page)
* Attendance % updates live based on presence/absence
* **Back** button returns to dashboard

---

#### 👩‍🏫 Teacher Profile

* Displays teacher's:

  * Name
  * Qualification
  * Designation
  * Subject
  * Date of Birth
  * Date of Joining
* Details are editable using a **Save/Edit Toggle** button
* **Back** button returns to dashboard

---

#### 🧑‍🎓 Student Marks

* Predefined marks for 50 students
* Covers:

  * **1st Internal** (out of 50)
  * **2nd Internal** (out of 50)
  * **Final Exam** (out of 100)
* Grades are calculated and displayed beside each mark:

  * Internals: A, B, C, F
  * Finals: A+, A, B, C, D, E, **F (shown in red)**

---

#### 🔓 Logout

* Shows confirmation: **“Are you sure you want to logout?”**
* On clicking **Yes**, user is redirected back to the **Login** page

---

### 💻 Technologies Used

* **Java (Swing)**
* No database – all data is managed in memory
* Modular structure (Login, Dashboard, Attendance, Profile, Marks)

---

### 📁 Project Structure

```
├── LOGIN.java
├── DASHBOARD.java
├── ATTENDANCE.java
├── TEACHERPROFILE.java
├── STUDENTMARKS.java
├── img2.png (background image for dashboard)
```

---

### 🎯 How to Run

1. Clone the repository
2. Make sure `img2.png` is in the same folder as your `.java` files
3. Compile and run `LOGIN.java`

```bash
javac LOGIN.java
java LOGIN
```

---

### ✅ Ideal For

* Beginners learning Java Swing
* Mini projects for college
* Practice for UI design and navigation
