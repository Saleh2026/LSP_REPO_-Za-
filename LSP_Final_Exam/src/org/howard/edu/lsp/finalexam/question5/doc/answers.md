Heuristic 1: Encapsulation & Data Hiding
Name:
All Data should be within its class (Heuristic 2.1).

Explanation:
This heuristic improves maintainability by creating a "firewall" around a class's internal state. By making data members private and providing controlled access through methods, the internal representation of an object can change without breaking any code that uses that object.


Heuristic 2: The "God Class" Problem
Name:
Distribute system intelligence horizontally as uniformly as possible; that is, the top-level classes in a design should share the work (Heuristic 2.11).

Explanation:
Improves readability and reusability by preventing the creation of "God Classes"—massive classes that do everything while other classes simply hold data. Lecture illustrated this through the "Controller vs. Object" discussion. We looked at designs where a single "Manager" class contained all the logic for a university system, making it a maintenance nightmare.


Heuristic 3: Minimal Public Interfaces
Name:
Users of a class must be dependent on its public interface, but a class should not be dependent on its users (Heuristic 2.3).

Explanation:
Improves maintainability by ensuring that dependencies only flow in one direction. It allows a class to be used in many different contexts without that class needing to know who is calling it. In lecture, this was illustrated through the concept of "The Black Box."
