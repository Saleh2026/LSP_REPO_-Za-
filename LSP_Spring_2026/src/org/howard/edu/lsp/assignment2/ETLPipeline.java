package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

/**
 * Assignment 2: Basic ETL Pipeline
 * This class reads product data, transforms it, and saves the output.
 */
public class ETLPipeline {

    public static void main(String[] args) {
        // Define relative paths for input and output
        String inputFilePath = "data/products.csv";
        String outputFilePath = "data/transformed_products.csv";

        // Ensure the data directory exists
        File dataDir = new File("data");
        if (!dataDir.exists()) {
            dataDir.mkdir();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            boolean isHeader = true;

            while ((line = reader.readLine()) != null) {
                // Handle the Header Row
                if (isHeader) {
                    writer.write(line); // Write the original header to the new file
                    writer.newLine();
                    isHeader = false;
                    continue;
                }

                // Split the row by comma (Extract)
                String[] columns = line.split(",");
                if (columns.length < 4) continue; // Skip malformed rows

                String productId = columns[0];
                String name = columns[1];
                double price = Double.parseDouble(columns[2]);
                String category = columns[3];

                // --- Transformation Logic ---
                
                // 1. Convert Name to Uppercase [cite: 21]
                name = name.toUpperCase();

                // 2. Apply 10% Discount to Electronics [cite: 21]
                if (category.equalsIgnoreCase("Electronics")) {
                    price = price * 0.90;
                }

                // 3. Conditional Category Adjustment [cite: 21]
                // Example: If price is > 500 after discount, mark as Premium
                if (price > 500) {
                    category = "Premium " + category;
                }

                // --- Load (Write to File) ---
                
                // Format price to 2 decimal places 
                String formattedPrice = String.format("%.2f", price);
                
                String transformedLine = String.join(",", productId, name, formattedPrice, category);
                writer.write(transformedLine);
                writer.newLine();
            }

            System.out.println("ETL Process Completed. Output saved to: " + outputFilePath);

        } catch (IOException e) {
            System.err.println("Error processing the CSV file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing price value: " + e.getMessage());
        }
    }
}