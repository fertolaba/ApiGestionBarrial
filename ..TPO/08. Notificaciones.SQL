CREATE TABLE notificaciones (
    idnotificacion INT PRIMARY KEY IDENTITY(1,1),
    documento VARCHAR(20), 
    fecha DATE,
    mensaje VARCHAR(200), 
    idDenuncias INT NULL, 
    idReclamo INT NULL,

	CONSTRAINT FK_notificaciones_vecinoDocumento FOREIGN KEY (documento) REFERENCES vecinos(documento),
	CONSTRAINT FK_notificaciones_denunciasIdDenuncias FOREIGN KEY (idDenuncias) REFERENCES denuncias(idDenuncias),
    CONSTRAINT FK_notificaciones_reclamosIdReclamo FOREIGN KEY (idReclamo) REFERENCES reclamos(idReclamo)
);

