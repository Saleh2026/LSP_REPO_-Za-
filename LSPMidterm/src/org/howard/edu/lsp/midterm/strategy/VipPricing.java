package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy for VIP customers with a 20% discount.
 */
public class VipPricing implements PricingStrategy {
    @Override
    public double computePrice(double price) {
        return price * 0.80;
    }
}
