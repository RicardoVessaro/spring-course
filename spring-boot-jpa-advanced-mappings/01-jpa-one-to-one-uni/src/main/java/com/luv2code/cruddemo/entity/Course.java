package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="course")
public class Course {

    // define our fields

    // define constructors

    // define getters and setters

    // define toString

    // annotate fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    /*
        Mapping the relationship
        @JoinColumn: Use the "course_id" column of the table "review" (Entity Review) to map
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Review> reviews;

    /*
        Mapping a Many-To-Many relationship
        @JoinTable: Refers the join table in the database in 'name'.
            Define join columns telling the columns from this side of the relationship using 'joinColumns',
                in the Course class the column reffering to the course table is 'course_id' (this side).
            'inverseJoinColumns' reffer to columns from the other side of the relationship (inverse), the otherside in
                the Course class is student table defined by 'student_id' column
     */
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
        name = "course_student",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    List<Student> students;

    public Course() {
    }

    public Course(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    // add a convenience method

    public void addReview(Review theReview) {

        if(reviews == null) {
            reviews = new ArrayList<>();
        }

        reviews.add(theReview);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    // add a convenience method
    public void addStudent(Student theStudent) {

        if(students == null) {
            students = new ArrayList<>();
        }

        students.add(theStudent);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
