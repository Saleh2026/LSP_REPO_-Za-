package org.howard.edu.lsp.finalexam.question2;

public class CourseReport extends Report {
    private String courseName;
    private int enrollment;

    @Override
    protected void loadData() {
        this.courseName = "CSCI 363";
        this.enrollment = 45;
    }

    @Override
    protected void formatHeader() {
        System.out.println("=== HEADER ===\nCourse Report\n");
    }

    @Override
    protected void formatBody() {
        System.out.println("=== BODY ===\nCourse: " + courseName + "\nEnrollment: " + enrollment + "\n");
    }

    @Override
    protected void formatFooter() {
        System.out.println("=== FOOTER ===\nEnd of Course Report\n");
    }
}