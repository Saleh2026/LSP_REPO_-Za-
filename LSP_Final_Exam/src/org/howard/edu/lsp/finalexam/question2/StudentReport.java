package org.howard.edu.lsp.finalexam.question2;

public class StudentReport extends Report {
    private String studentName;
    private double gpa;

    @Override
    protected void loadData() {
        this.studentName = "John Doe";
        this.gpa = 3.8;
    }

    @Override
    protected void formatHeader() {
        System.out.println("=== HEADER ===\nStudent Report\n");
    }

    @Override
    protected void formatBody() {
        System.out.println("=== BODY ===\nStudent Name: " + studentName + "\nGPA: " + gpa + "\n");
    }

    @Override
    protected void formatFooter() {
        System.out.println("=== FOOTER ===\nEnd of Student Report\n");
    }
}