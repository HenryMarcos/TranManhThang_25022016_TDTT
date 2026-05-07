public class Transcript {
    private Student student;
    private Course course;
    private Grade grade;

    public Transcript(Student student, Course course, Grade grade) {
        this.student = student;
        this.course = course;
        this.grade = grade;
    }

    public void printTranscript() {
        System.out.println("Sinh viên: " + student.getName() + " (" + student.getId() + ")");
        System.out.println("Môn học: " + course.getName() + " (" + course.getId() + ") - " + course.getCredits() + " tín chỉ");
        System.out.println("Điểm GK: " + grade.getMidtermScore() + " | Điểm CK: " + grade.getFinalScore()
                         + " | Điểm BT: " + grade.getAssignmentScore());
        System.out.printf("Điểm tổng kết: %.1f - Học lực: %s%n",
                          grade.calculateFinalGrade(), grade.getAcademicStatus());
    }
}
