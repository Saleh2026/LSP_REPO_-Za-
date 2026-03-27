Class: Order
Responsibilities: * Store customer name, email, and item details 
-Maintain the base price of the order 

Collaborators: None



Class: TaxCalculator
Responsibilities: * Apply the 7% tax rate to a given price 

-Return the total price including tax
 
Collaborators: None



Class: OrderRepository
Responsibilities: * Format order data for storage
 
-Handle the logic for writing order details to the "orders.txt" file 

Collaborators: Order


Class: NotificationService
Responsibilities: * Format confirmation messages for the customer 

-Handle the logic for sending or printing email confirmations

Collaborators: Order


Class: OrderProcessor
Responsibilities: * Coordinate the workflow between the other classes

-Trigger tax calculation, file saving, and notifications in the correct order 

Collaborators: Order, TaxCalculator, OrderRepository, NotificationService