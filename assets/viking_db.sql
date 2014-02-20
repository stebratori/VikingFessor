BEGIN TRANSACTION;
CREATE TABLE android_metadata (locale TEXT);
INSERT INTO android_metadata VALUES('en_US');
CREATE TABLE player (_id  PRIMARY KEY, name TEXT, coins NUMERIC, gold NUMERIC, silver NUMERIC, bronze NUMERIC);
COMMIT;
