package gr.aueb.cf.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "firstname", length = 255, nullable = true, unique = false)
    private String firstname;

//    @Column(name = "firstname", length = 255, nullable = true, unique = false)
    private String lastname;

    @Getter(AccessLevel.PROTECTED)
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
    private Set<Course> courses = new HashSet<>();

//    public Teacher() {
//
//    }

    public Teacher(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }

//    protected Set<Course> getCourses() {
//        return courses;
//    }

    public Set<Course> getAllCourses() {
        return Collections.unmodifiableSet(courses);
    }

//    public void setCourses(Set<Course> courses) {
//        this.courses = courses;
//    }

    public void addCourse(Course course) {
        if (courses == null) courses = new HashSet<>();
        this.courses.add(course);
        course.setTeacher(this);
    }

    public void removeCourse(Course course) {
        courses.remove(course);     // TBD override course equals
        course.setTeacher(null);
    }


    @Override
    public String toString() {
        return String.format("%d %s %s", id, firstname, lastname);
    }
}
