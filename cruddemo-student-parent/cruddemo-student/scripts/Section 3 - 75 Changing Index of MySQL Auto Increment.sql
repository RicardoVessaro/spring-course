
/*
 * Section 3: 75. Changing Index of MySQL Auto Increment
 */

# FAQ: How do I change the AUTO_INCREMENT values?

-- Set the index to start in 3000 
ALTER TABLE student AUTO_INCREMENT = 3000;

# FAQ: How do I RESET the AUTO_INCREMENT values to 1?

-- Remove all data from the database table
-- Reset AUTO_INCREMENT starting with 1

TRUNCATE student;
