ALTER TABLE developer ADD COLUMN isInHomeOffice BOOLEAN;
UPDATE developer SET isInHomeOffice = 'f';
ALTER TABLE developer ALTER COLUMN isInHomeOffice SET NOT NULL;
ALTER TABLE developer ALTER COLUMN isInHomeOffice SET DEFAULT FALSE;

