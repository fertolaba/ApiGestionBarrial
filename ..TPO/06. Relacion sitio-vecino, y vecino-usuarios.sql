-- Relacionando sitios con vecinos
ALTER TABLE sitios
ADD documento VARCHAR(20) NULL;

ALTER TABLE sitios
ADD CONSTRAINT FK_sitio_vecinos_por_documento FOREIGN KEY (documento)
REFERENCES vecinos(documento);


-- Anadiendo un dato de prueba (requiere un sitio creado)
UPDATE sitios 
SET documento='DNI28000046'
WHERE idSitio=1

SELECT *
FROM vecinos v JOIN sitios s ON s.documento = s.documento
WHERE v.documento='DNI28000046'

SELECT *
FROM sitios

SELECT * FROM vecinos
