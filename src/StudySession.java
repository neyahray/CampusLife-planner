class StudySession {
    private Course course;
    int minutes;

    StudySession(Course course, int minutes) {
        this.course = course;
        this.minutes = minutes;
    }

    public Course getCourse() {
        return course;
    }
    public double getMinutes() {
        return minutes;
    }
    public String toString() {
        return "StudySession {course = '" + course.getName() + "', minutes = '" + minutes + "'}";
    }
}