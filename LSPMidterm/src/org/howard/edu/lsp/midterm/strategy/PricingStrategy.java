package org.howard.edu.lsp.midterm.strategy;

/**
 * Interface for different pricing strategies.
 * @author Saleh Z. AbdurRahman
 */
public interface PricingStrategy {
    /**
     * Calculates the price based on the strategy implementation.
     * @param price The original price
     * @return The calculated final price
     */
    double computePrice(double price);
}