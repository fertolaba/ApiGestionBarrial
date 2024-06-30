CREATE OR ALTER PROCEDURE [dbo].[GetUserInfo]
    @documento VARCHAR(20),
    @password VARCHAR(40)
AS
-- GetUserInfo DNI123123, 123
BEGIN
    DECLARE @tipousuario VARCHAR(20) = 'N/A';

    -- Verificar si el usuario es un inspector
    IF EXISTS (SELECT 1 FROM personal WHERE documento = @documento)
        SET @tipousuario = 'inspector';
    ELSE
		-- Verificar si el usuario es un vecino
		IF EXISTS (SELECT 1 FROM vecinos WHERE documento = @documento)
			SET @tipousuario = 'vecino';
		ELSE
		BEGIN
			-- Si no se encuentra el usuario en ninguna tabla, devolver null
			SET @tipousuario = null;
		END

    IF @tipousuario IS NOT NULL
    BEGIN
        IF @tipousuario = 'vecino'
        BEGIN
            SELECT
                v.documento,
                --u.password, -- Se comenta para no mostrar la contraseña en el resultado
                v.nombre,
                v.apellido,
                @tipousuario AS tipousuario
            FROM
                vecinos v
					JOIN usuarios u ON v.documento = u.documento
            WHERE
                u.documento = @documento AND u.password = @password; -- La contraseña no se está utilizando para buscar al vecino
        END
        ELSE
        BEGIN
            SELECT
                p.documento,
                --u.password, -- Se comenta para no mostrar la contraseña en el resultado
                p.nombre,
                p.apellido,
                @tipousuario AS tipousuario,
                p.rubro
            FROM personal p
            WHERE
                p.documento = @documento AND p.password = @password;
        END
    END
END;


SELECT * FROM personal