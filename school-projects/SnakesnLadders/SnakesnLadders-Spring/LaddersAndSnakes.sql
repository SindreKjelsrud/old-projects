DROP TABLE IF EXISTS shortcut CASCADE;

CREATE TABLE shortcut
(
	from1 INTEGER PRIMARY KEY,
	to1 INTEGER,
	type1 BOOLEAN
	
);

INSERT INTO shortcut
	(from1, to1, type1)
VALUES
	(32, 6, false),
	(74, 22, false),
	(86, 51, false),
	(99, 39, false),
	(9, 31, true),
	(16, 45, true),
	(18, 64, true),
	(48, 66, true),
	(50, 93, true),
	(63, 81, true);
	
