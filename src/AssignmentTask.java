class AssignmentTask extends PlanItem {
    private Course course;

    AssignmentTask(String title, Course course, int estimatedHours, int daysUntilDue, boolean completed) {
        super(title, estimatedHours, daysUntilDue, completed);
        this.course = course;
    }

    @Override

    public String calculateUrgency() {
        if (isUrgent()) {
            return "URGENT! " + getDaysUntilDue() + " days left until the deadline! Hurry up, it will take only " + getEstimatedHours() + " hours";
        } else if (notUrgentAndNotCompleted()) {
            return getTitle() +" for " + course.getName() + " due in " + getDaysUntilDue() + " days";
        } else {
            return "Yaay you have done your assignment " + getTitle() + " for " + course.getName() + " great job!";
        }
    }

    public String toString() {
        return "Assignment Task {title: " + getTitle() + ", course: " + course.getName() + ", estimated hours: " + getEstimatedHours() + ", days until due: " + getDaysUntilDue() + ", is completed: " + isDone();
    }
}