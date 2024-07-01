-- Creando usuarios y a�adiendo uno
CREATE TABLE usuarios (
    documento VARCHAR(20) NOT NULL PRIMARY KEY,
    password VARCHAR(40) NOT NULL,
    CONSTRAINT FK_Usuarios_Vecinos_porDocumento FOREIGN KEY (documento) REFERENCES vecinos(documento)
);

--  10 registros en la tabla usuarios desde la tabla vecinos
INSERT INTO usuarios (documento, password, expiraContrasena)
SELECT TOP 10 documento, 'password', DATEADD(DAY, -1, GETDATE())
FROM vecinos;

-- Relacionando vecinos con usuarios
ALTER TABLE usuarios
ADD CONSTRAINT FK_usuarios_vecinos_por_documento FOREIGN KEY (documento)
REFERENCES vecinos(documento);

ALTER TABLE usuarios
ADD mail VARCHAR(50) NOT NULL DEFAULT 'gestionbarrial@yopmail.com';

ALTER TABLE usuarios
ADD expira_contrasena DATE NOT NULL DEFAULT (DATEADD(DAY, -1, GETDATE())); -- default 1 dia antes de la fecha actual

/*
	SELECT * FROM usuarios
*/
