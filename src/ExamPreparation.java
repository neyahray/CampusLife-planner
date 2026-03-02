class ExamPreparation extends PlanItem{
    private String title;
    private Course course;
    private int estimatedHours, daysUntilDue;
    private boolean completed;

    ExamPreparation(String title, Course course, int estimatedHours, int daysUntilDue, boolean completed) {
        super(title, estimatedHours, daysUntilDue, completed);
        this.course = course;
    }

    @Override
    public String calculateUrgency() {
        if (isUrgent()) {
            return "URGENT! Now you have only " + getDaysUntilDue() + " days until your " + course.getName() + " EXAM!! Start to prepare right now, it will take about " + getEstimatedHours() + " hours";
        } else if (notUrgentAndNotCompleted()) {
            return getTitle() + " for " + course.getName() + " due in " + getDaysUntilDue() + " days, but I suggest you to start your preparing earlier ";
        } else {
            return "Great job! You have prepared for your " + course.getName() + " exam";
        }
    }

    public String toString() {
        return "Exam Preparation {title: " + getTitle() + ", course: " + course.getName() + ", estimated hours: " + getEstimatedHours() + ", days until due: " + getDaysUntilDue() + ", is completed: " + isDone();
    }
}

