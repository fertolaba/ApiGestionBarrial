USE [Municipio]
GO
/****** Object:  Table [dbo].[personal]    Script Date: 19/3/2024 17:59:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[personal](
	[legajo] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](150) NOT NULL,
	[apellido] [varchar](150) NOT NULL,
	[documento] [varchar](20) NOT NULL,
	[password] [varchar](40) NOT NULL,
	[sector] [varchar](200) NOT NULL,
	[categoria] [int] NULL,
	[fechaIngreso] [datetime] NULL,
 CONSTRAINT [pk_personal] PRIMARY KEY CLUSTERED 
(
	[legajo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[personal] ON 

INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (1, N'RAMIRO             ', N'RODRIGUEZ', N'DNI30012288', N'password', N'Areas Verdes', 3, CAST(N'2018-08-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (2, N'JAVIER              ', N'ESPINOZA', N'DNI30616697', N'password', N'
Escuelas', 2, CAST(N'2016-08-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (3, N'JOSE                 ', N'OLIVERA', N'DNI30667193', N'password', N'Museos', 7, CAST(N'2015-02-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (4, N'MARCELO                 ', N'DIAZ', N'DNI30669003', N'password', N'Bacheo y Demarcacion
', 8, CAST(N'2020-07-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (5, N'PABLO                 ', N'BLANCO', N'DNI30702760', N'password', N'Bacheo y Demarcacion', 6, CAST(N'2019-07-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (6, N'PABLO                   ', N'CRUZ', N'DNI30724804', N'password', N'Plazas y Parques', 4, CAST(N'2020-12-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (7, N'CRISTIAN              ', N'MEDINA', N'DNI30732736', N'password', N'Semaforos y Señalectica
', 6, CAST(N'2019-05-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (8, N'JORGE GUSTAVO           ', N'OLAS', N'DNI30745281', N'password', N'

Edificios Publicos y Oficinas
', 4, CAST(N'2019-11-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (9, N'ADRIAN                ', N'BEGUET', N'DNI30780521', N'password', N'


Seguridad', 7, CAST(N'2020-05-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (10, N'MAURICIO              ', N'ROMERO', N'DNI30800519', N'password', N'Semaforos y Señalectica
', 5, CAST(N'2017-10-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (11, N'PABLO                 ', N'BARRIL', N'DNI30816148', N'password', N'Escuelas
', 9, CAST(N'2018-11-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (12, N'SERGIO             ', N'BAIGORRIA', N'DNI30819573', N'password', N'Museos
', 6, CAST(N'2016-09-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (13, N'FACUNDO            ', N'GUTIERREZ', N'DNI30866787', N'password', N'


Seguridad', 1, CAST(N'2017-12-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (14, N'MATIAS                ', N'GARCIA', N'DNI30868883', N'password', N'Escuelas
', 9, CAST(N'2018-09-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (15, N'DANIEL               ', N'HERRERA', N'DNI30885642', N'password', N'Semaforos y Señalectica
', 9, CAST(N'2015-11-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (16, N'JESUS                   ', N'DIAZ', N'DNI30888538', N'password', N'Plazas y Parques
', 8, CAST(N'2017-03-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (17, N'GABRIEL              ', N'PETAGNA', N'DNI30912099', N'password', N'

Edificios Publicos y Oficinas
', 2, CAST(N'2019-04-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (18, N'MARTIN               ', N'PURCHEL', N'DNI30944156', N'password', N'Escuelas
', 7, CAST(N'2014-11-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (19, N'ALFREDO            ', N'RODRIGUEZ', N'DNI30952992', N'password', N'Semaforos y Señalectica
', 4, CAST(N'2021-06-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (20, N'ARTURO                 ', N'MUÑOZ', N'DNI30980277', N'password', N'Museos
', 2, CAST(N'2014-11-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (21, N'SEBASTIAN          ', N'FERNANDEZ', N'DNI31032143', N'password', N'Bacheo y Demarcacion
', 4, CAST(N'2015-02-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (22, N'LEONARDO            ', N'GONZALEZ', N'DNI31070616', N'password', N'Bacheo y Demarcacion
', 6, CAST(N'2015-05-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (23, N'MAXIMILIANO         ', N'ALBORNOZ', N'DNI31079668', N'password', N'Plazas y Parques
', 1, CAST(N'2021-10-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (24, N'MARIO                 ', N'CASTRO', N'DNI31079744', N'password', N'Bacheo y Demarcacion
', 9, CAST(N'2020-08-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (25, N'MARIANO              ', N'MOGARTE', N'DNI31156237', N'password', N'Escuelas
', 7, CAST(N'2019-04-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (26, N'RUBEN                ', N'IMASAKA', N'DNI31177539', N'password', N'Museos
', 5, CAST(N'2018-09-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (27, N'DIEGO                ', N'BARRIOS', N'DNI31189490', N'password', N'Semaforos y Señalectica
', 5, CAST(N'2015-07-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (28, N'JUAN                 ', N'CANALES', N'DNI31239205', N'password', N'Escuelas
', 1, CAST(N'2019-09-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (29, N'VICTOR                ', N'ZARATE', N'DNI31244038', N'password', N'Plazas y Parques
', 9, CAST(N'2021-09-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (30, N'LEANDRO              ', N'SANCHEZ', N'DNI31253023', N'password', N'Seguridad
', 5, CAST(N'2014-08-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (31, N'NICOLAS                ', N'GEREZ', N'DNI31262291', N'password', N'Areas Verdes
', 8, CAST(N'2014-06-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (32, N'MATIAS              ', N'DI BELLO', N'DNI31282335', N'password', N'Edificios Publicos y Oficinas
', 9, CAST(N'2014-07-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (33, N'NESTOR                ', N'SUELDO', N'DNI31283679', N'password', N'Escuelas
', 2, CAST(N'2018-11-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (34, N'PABLO                 ', N'GIGLIO', N'DNI31293173', N'password', N'Semaforos y Señalectica
', 7, CAST(N'2017-05-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (35, N'LUCAS                 ', N'VENERE', N'DNI31293846', N'password', N'Museos
', 8, CAST(N'2017-01-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (36, N'PABLO                ', N'MORETTI', N'DNI31297900', N'password', N'Seguridad
', 8, CAST(N'2021-03-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (37, N'MARIO              ', N'SANTILLAN', N'DNI31325403', N'password', N'Edificios Publicos y Oficinas
', 2, CAST(N'2019-10-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (38, N'FEDERICO             ', N'NAVARRO', N'DNI31362192', N'password', N'Plazas y Parques
', 1, CAST(N'2015-09-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (39, N'PABLO                 ', N'AGUADA', N'DNI31362419', N'password', N'Semaforos y Señalectica
', 3, CAST(N'2016-10-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (40, N'NESTOR                ', N'MAGUNA', N'DNI31374667', N'password', N'Escuelas
', 8, CAST(N'2015-05-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (41, N'RUBEN               ', N'ALBORNOZ', N'DNI31443543', N'password', N'Areas Verdes
', 5, CAST(N'2019-05-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (42, N'MATIAS               ', N'SALINAS', N'DNI31444272', N'password', N'Areas Verdes
', 7, CAST(N'2019-09-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (43, N'WALTER                 ', N'LOPEZ', N'DNI31470110', N'password', N'Escuelas
', 7, CAST(N'2015-11-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (44, N'CRISTIAN            ', N'CHAPARRO', N'DNI31531124', N'password', N'


Seguridad', 2, CAST(N'2015-06-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (45, N'DARIO                ', N'ROLANDO', N'DNI31617553', N'password', N'Escuelas
', 8, CAST(N'2015-10-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (46, N'ARIEL                 ', N'PICCHI', N'DNI31617728', N'password', N'


Seguridad', 3, CAST(N'2021-05-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (47, N'FEDERICO              ', N'FARFAN', N'DNI31650048', N'password', N'Escuelas
', 7, CAST(N'2014-09-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (48, N'CARLOS                ', N'SEGADE', N'DNI31658901', N'password', N'Edificios Publicos y Oficinas
', 8, CAST(N'2020-05-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (49, N'CRISTIAN             ', N'MOREIRA', N'DNI31681421', N'password', N'Semaforos y Señalectica
', 8, CAST(N'2019-08-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (50, N'JUAN               ', N'RODRIGUEZ', N'DNI31684432', N'password', N'


Seguridad', 4, CAST(N'2014-05-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (51, N'JORGE                 ', N'CALIVA', N'DNI31687570', N'password', N'Plazas y Parques
', 6, CAST(N'2017-01-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (52, N'SEBASTIAN           ', N'GONZALEZ', N'DNI31727399', N'password', N'Plazas y Parques
', 6, CAST(N'2022-01-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (53, N'JULIAN               ', N'PEREYRA', N'DNI31727824', N'password', N'


Seguridad', 3, CAST(N'2016-08-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (54, N'IVAN                    ', N'CANO', N'DNI31731313', N'password', N'Edificios Publicos y Oficinas
', 6, CAST(N'2018-07-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (55, N'MAURICIO              ', N'CARUSO', N'DNI31740027', N'password', N'Escuelas
', 1, CAST(N'2015-07-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (56, N'ESTEBAN               ', N'MEDINA', N'DNI31740346', N'password', N'Escuelas
', 2, CAST(N'2020-08-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (57, N'FEDERICO             ', N'POLANCO', N'DNI31750377', N'password', N'Edificios Publicos y Oficinas
', 7, CAST(N'2020-01-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (58, N'SEBASTIAN              ', N'GALAN', N'DNI31761910', N'password', N'Bacheo y Demarcacion
', 9, CAST(N'2020-04-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (59, N'CRISTIAN               ', N'GATTO', N'DNI31763069', N'password', N'Bacheo y Demarcacion
', 2, CAST(N'2021-12-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (60, N'LEANDRO                ', N'VAÑOS', N'DNI31764083', N'password', N'Bacheo y Demarcacion
', 8, CAST(N'2015-06-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (61, N'GABRIEL              ', N'BENITEZ', N'DNI31772732', N'password', N'Semaforos y Señalectica
', 5, CAST(N'2019-12-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (62, N'EMANUEL             ', N'OSTOISCH', N'DNI31774039', N'password', N'Semaforos y Señalectica
', 8, CAST(N'2017-09-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (63, N'PABLO            ', N'BARRIONUEVO', N'DNI31781455', N'password', N'Bacheo y Demarcacion
', 7, CAST(N'2015-07-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (64, N'DANIEL               ', N'PIZARRO', N'DNI31781643', N'password', N'Edificios Publicos y Oficinas
', 4, CAST(N'2019-11-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (65, N'DAMIAN             ', N'RODRIGUEZ', N'DNI31797782', N'password', N'Seguridad
', 6, CAST(N'2020-12-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (66, N'GABRIEL               ', N'TORRES', N'DNI31797902', N'password', N'Plazas y Parques
', 1, CAST(N'2017-10-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (67, N'WALTER              ', N'MARTINEZ', N'DNI31827019', N'password', N'Semaforos y Señalectica
', 7, CAST(N'2015-05-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (68, N'ANTONIO              ', N'CARDOZO', N'DNI31876635', N'password', N'

Edificios Publicos y Oficinas
', 3, CAST(N'2016-05-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (69, N'SEBASTIAN             ', N'OCAMPO', N'DNI31895478', N'password', N'Escuelas', 2, CAST(N'2019-05-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (70, N'MATIAS               ', N'PINCINI', N'DNI31899200', N'password', N'Edificios Publicos y Oficinas
', 4, CAST(N'2018-05-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (71, N'MIGUEL              ', N'NOVIELLI', N'DNI31899211', N'password', N'Semaforos y Señalectica
', 2, CAST(N'2018-08-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (72, N'ARIEL                 ', N'CARUSO', N'DNI31899301', N'password', N'Bacheo y Demarcacion
', 5, CAST(N'2015-07-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (73, N'CRISTIAN            ', N'GONZALEZ', N'DNI31916459', N'password', N'Bacheo y Demarcacion
', 3, CAST(N'2014-11-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (74, N'LUCAS               ', N'GENOVESE', N'DNI31953929', N'password', N'Areas Verdes
', 4, CAST(N'2017-09-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (75, N'MANUEL               ', N'FLEITAS', N'DNI31978771', N'password', N'Edificios Publicos y Oficinas
', 8, CAST(N'2014-03-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (76, N'ARIEL               ', N'FERREIRA', N'DNI32063815', N'password', N'Plazas y Parques
', 5, CAST(N'2014-02-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (77, N'LUIS MIGUEL           ', N'ROMERO', N'DNI32427681', N'password', N'Escuelas
', 4, CAST(N'2018-08-19T00:00:00.000' AS DateTime))
INSERT [dbo].[personal] ([legajo], [nombre], [apellido], [documento], [password], [sector], [categoria], [fechaIngreso]) VALUES (78, N'EDGAR                ', N'GARCETE', N'DNI92920447', N'password', N'Edificios Publicos y Oficinas
', 5, CAST(N'2020-05-19T00:00:00.000' AS DateTime))
SET IDENTITY_INSERT [dbo].[personal] OFF
GO
