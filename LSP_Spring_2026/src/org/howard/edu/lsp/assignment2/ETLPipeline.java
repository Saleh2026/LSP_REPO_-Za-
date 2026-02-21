package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ETLPipeline {

	public static void main(String[] args) {

		String inputPath = "data/products.csv";
		String outputPath = "data/transformed_products.csv";

		File inputFile = new File(inputPath);

		// Case C: Missing input file
		if (!inputFile.exists()) {
			System.out.println("ERROR: Input file " + inputPath + " not found.");
			return;
		}

		int rowsRead = 0;
		int rowsTransformed = 0;
		int rowsSkipped = 0;

		try {
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));

			// Always write output header
			writer.write("ProductID,Name,Price,Category,PriceRange");
			writer.newLine();

			// Read and discard input header
			String line = reader.readLine();

			// Process remaining lines
			while ((line = reader.readLine()) != null) {
				rowsRead++;

				line = line.trim();

				// Skip blank lines
				if (line.isEmpty()) {
					rowsSkipped++;
					continue;
				}

				String[] fields = line.split(",");

				// Skip incorrect field counts
				if (fields.length != 4) {
					rowsSkipped++;
					continue;
				}

				// Trim fields
				for (int i = 0; i < fields.length; i++) {
					fields[i] = fields[i].trim();
				}

				int productId;
				double price;

				// Parse ProductID and Price
				try {
					productId = Integer.parseInt(fields[0]);
					price = Double.parseDouble(fields[2]);
				} catch (NumberFormatException e) {
					rowsSkipped++;
					continue;
				}

				String name = fields[1];
				String category = fields[3];
				String originalCategory = category;

				// 1) Uppercase name
				name = name.toUpperCase();

				// 2) Electronics discount
				if (originalCategory.equals("Electronics")) {
					price = price * 0.9;
				}

				// 3) Round price HALF-UP to two decimals
				BigDecimal bd = new BigDecimal(price);
				bd = bd.setScale(2, RoundingMode.HALF_UP);
				price = bd.doubleValue();

				// 4) Premium Electronics rule
				if (originalCategory.equals("Electronics") && price > 500.00) {
					category = "Premium Electronics";
				}

				// 5) PriceRange
				String priceRange;
				if (price <= 10.00) {
					priceRange = "Low";
				} else if (price <= 100.00) {
					priceRange = "Medium";
				} else if (price <= 500.00) {
					priceRange = "High";
				} else {
					priceRange = "Premium";
				}

				// Write transformed row
				writer.write(productId + "," + name + "," + String.format("%.2f", price) + "," + category + ","
						+ priceRange);
				writer.newLine();

				rowsTransformed++;
			}

			reader.close();
			writer.close();

		} catch (IOException e) {
			System.out.println("ERROR: File processing failed.");
			return;
		}

		// Run summary
		System.out.println("Rows read: " + rowsRead);
		System.out.println("Rows transformed: " + rowsTransformed);
		System.out.println("Rows skipped: " + rowsSkipped);
		System.out.println("Output written to: " + outputPath);
	}
}
