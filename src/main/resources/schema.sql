-- Drop table if exists
DROP TABLE IF EXISTS song;

-- Create table
CREATE TABLE song (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    artist VARCHAR(255) NOT NULL,
    length FLOAT
);
