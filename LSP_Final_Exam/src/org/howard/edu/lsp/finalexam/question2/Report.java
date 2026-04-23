package org.howard.edu.lsp.finalexam.question2;

/**
 * Abstract class defining the Template Method for report generation.
 */
public abstract class Report {
    // Template Method
    public final void generateReport() {
        loadData();
        formatHeader();
        formatBody();
        formatFooter();
    }

    protected abstract void loadData();
    protected abstract void formatHeader();
    protected abstract void formatBody();
    protected abstract void formatFooter();
}