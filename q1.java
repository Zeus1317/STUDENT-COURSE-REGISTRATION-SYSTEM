import java.util.ArrayList;
import java.util.List;

// Student class represents a student with student ID and name
class Student {
    private int studentId;
    private String name;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }
}

// Course class represents a course with code, title, description, capacity, schedule, and list of students
class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private List<Student> students;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.students = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public List<Student> getStudents() {
        return students;
    }

    public boolean addStudent(Student student) {
        if (students.size() < capacity) {
            students.add(student);
            return true;
        }
        return false;
    }

    public boolean removeStudent(Student student) {
        return students.remove(student);
    }

    public void displayCourseInfo() {
        System.out.println("Course Code: " + code);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Capacity: " + capacity);
        System.out.println("Schedule: " + schedule);
        System.out.print("Registered Students: ");
        if (students.isEmpty()) {
            System.out.println("None");
        } else {
            for (Student student : students) {
                System.out.print(student.getName() + ", ");
            }
            System.out.println();
        }
    }
}

// CourseRegistrationSystem manages courses and students, providing methods to add courses,
// display all courses, register students for courses, and remove students from courses
class CourseRegistrationSystem {
    private List<Course> courses;

    public CourseRegistrationSystem() {
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void displayAllCourses() {
        for (Course course : courses) {
            course.displayCourseInfo();
        }
    }

    public boolean registerStudentForCourse(Student student, Course course) {
        if (course.addStudent(student)) {
            return true;
        } else {
            System.out.println("Course " + course.getCode() + " is full. Registration failed.");
            return false;
        }
    }

    public boolean removeStudentFromCourse(Student student, Course course) {
        if (course.removeStudent(student)) {
            System.out.println("Student " + student.getName() + " successfully removed from course " + course.getCode());
            return true;
        } else {
            System.out.println("Student " + student.getName() + " is not registered in course " + course.getCode());
            return false;
        }
    }

    public static void main(String[] args) {
        CourseRegistrationSystem registrationSystem = new CourseRegistrationSystem();

        // Adding courses
        Course course1 = new Course("CSE101", "Introduction to Computer Science", "Basic concepts of computer science", 50, "Mon/Wed/Fri 10:00 AM - 11:30 AM");
        Course course2 = new Course("MAT202", "Advanced Mathematics", "Advanced topics in mathematics", 40, "Tue/Thu 2:00 PM - 4:00 PM");

        registrationSystem.addCourse(course1);
        registrationSystem.addCourse(course2);

        // Adding students
        Student student1 = new Student(1, "Alice");
        Student student2 = new Student(2, "Bob");

        // Registering students for courses
        registrationSystem.registerStudentForCourse(student1, course1);
        registrationSystem.registerStudentForCourse(student2, course1);

        registrationSystem.registerStudentForCourse(student1, course2);

        // Displaying all courses
        registrationSystem.displayAllCourses();

        // Removing student from course
        registrationSystem.removeStudentFromCourse(student1, course1);

        // Displaying updated course information
        registrationSystem.displayAllCourses();
    }
}
