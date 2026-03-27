package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy for regular customers with no discount.
 */
public class RegularPricing implements PricingStrategy {
    @Override
    public double computePrice(double price) {
        return price;
    }
}
