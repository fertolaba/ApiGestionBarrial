CREATE TABLE imagenesSitios (
    idImagenSitio INT PRIMARY KEY IDENTITY(1, 1),
    idSitio INT NOT NULL,
    url VARCHAR(MAX),

    CONSTRAINT FK_imagenesSitios_sitios FOREIGN KEY (idSitio) REFERENCES sitios(idSitio)
);

