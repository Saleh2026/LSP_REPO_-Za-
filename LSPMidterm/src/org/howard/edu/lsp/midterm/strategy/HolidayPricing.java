package org.howard.edu.lsp.midterm.strategy;

public class HolidayPricing implements PricingStrategy {
    @Override
    public double computePrice(double price) {
        return price * 0.85;
    }
}
