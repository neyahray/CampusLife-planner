class ClubEvent extends PlanItem {
    private String title;
    private int estimatedHours, daysUntilDue;
    private boolean completed;

    ClubEvent(String title, int estimatedHours, int daysUntilDue, boolean completed) {
        super(title, estimatedHours, daysUntilDue, completed);
    }

    @Override
    public String calculateUrgency() {
        if (isUrgent()) {
            return "URGENT! " + getDaysUntilDue() + " days left until the spring event! Hurry up, you have to " + getTitle();
        } else if (notUrgentAndNotCompleted()) {
            return getTitle() + " in " + getDaysUntilDue() + " days";
        } else {
            return "You are ready for " + getTitle() + "!";
        }
    }

    public String toString() {
        return "Club Event {title: " + getTitle() + ", estimated hours: " + getEstimatedHours() + ", days until due: " + getDaysUntilDue() + ", is completed: " + isDone();
    }
}

