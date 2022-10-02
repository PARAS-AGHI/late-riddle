package Bean;

public class CoursesBean {

    private int courseId;
    private String courseName;
    private int courseFee;

    private int noOfSeats;
    private String batch;


    public CoursesBean(){

    }

    public CoursesBean(int courseId, String courseName, int courseFee, int noOfSeats,String batch) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseFee = courseFee;
        this.noOfSeats = noOfSeats;
        this.batch= batch;
    }

    public CoursesBean(String courseName, int courseFee, String batch, int noOfSeats) {
        this.courseName = courseName;
        this.courseFee = courseFee;

        this.noOfSeats = noOfSeats;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(int courseFee) {
        this.courseFee = courseFee;
    }



    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    @Override
    public String toString() {
        return "CoursesBean{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseFee=" + courseFee +
                ", noOfSeats=" + noOfSeats +
                ", batch='" + batch + '\'' +
                '}';
    }
}
