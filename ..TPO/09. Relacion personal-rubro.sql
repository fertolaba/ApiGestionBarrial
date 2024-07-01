CREATE TABLE legajoRubro (
    idLegajoRubro int PRIMARY KEY IDENTITY(1,1),
    legajo int,
    idRubro int,
    FOREIGN KEY (legajo) REFERENCES personal(legajo),
    FOREIGN KEY (idRubro) REFERENCES rubros(idRubro)
);

-- creando rubro random prueba
INSERT INTO rubros (descripcion)
VALUES ('Supermercados');

-- dandole un rubro al primer personal, como prueba
DECLARE @legajo int;

SELECT TOP 1 @legajo = legajo
FROM personal;

INSERT INTO legajoRubro (legajo, idRubro)
VALUES (@legajo, 2); -- verificar  que el idRubro sea el creado


-- viendo si quedo
SELECT *
FROM legajoRubro lr
	JOIN rubros r ON lr.idRubro = r.idRubro
	JOIN personal p ON p.legajo = lr.legajo 	