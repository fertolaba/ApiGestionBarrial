-- Creando usuarios y a�adiendo uno
CREATE TABLE usuarios (
    documento VARCHAR(20) NOT NULL PRIMARY KEY,
    password VARCHAR(40) NOT NULL,
    CONSTRAINT FK_Usuarios_Vecinos_porDocumento FOREIGN KEY (documento) REFERENCES vecinos(documento)
);

INSERT INTO usuarios (documento, Password)
VALUES ('DNI28000046', '123')


-- Relacionando vecinos con usuarios
ALTER TABLE usuarios
ADD CONSTRAINT FK_usuarios_vecinos_por_documento FOREIGN KEY (documento)
REFERENCES vecinos(documento);

ALTER TABLE usuarios
ADD mail VARCHAR(50) NOT NULL DEFAULT 'gestionbarrial@yopmail.com';

-- ...
SELECT top(5)* FROM personal