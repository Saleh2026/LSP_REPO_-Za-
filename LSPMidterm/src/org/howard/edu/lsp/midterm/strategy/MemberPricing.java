package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy for members with a 10% discount.
 */
public class MemberPricing implements PricingStrategy {
    @Override
    public double computePrice(double price) {
        return price * 0.90;
    }
}
