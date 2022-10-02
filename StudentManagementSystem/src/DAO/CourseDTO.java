package DAO;

public class CourseDTO {

    //For customized data

    private int id;
    private String name;
    private String email;

    private String courseName;
    private int fee;

    public CourseDTO(){

    }

    public CourseDTO(int id, String name, String email, String courseName, int fee) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.courseName = courseName;
        this.fee = fee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", courseName='" + courseName + '\'' +
                ", fee=" + fee +
                '}';
    }
}
