public class Student<T> implements Comparable<Student<T>> {

    private String studentID;
    private String name;
    private T department;
    private String address;

    public Student(String studentID, String name, T department, String address) {
        this.studentID = studentID;
        this.name = name;
        this.department = department;
        this.address = address;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public T getDepartment() {
        return department;
    }

    public String getAddress() {
        return address;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(T department) {
        this.department = department;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", name='" + name + '\'' +
                ", department=" + department +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student<T> other) {
        return this.name.compareTo(other.getName());
    }
}