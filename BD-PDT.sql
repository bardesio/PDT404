
------------------------------------------------------------------
--TABLA Usuario
-----------------------------------------------------------------


--usuario deberia tener una pk compuesta, con esto logramos que se puedan dar de alta para la misma cedula varios registros, pero con distinto tipo de usuario.											
--el id_usuario puede ser inecesario, o puede ser iteresante para referenciar nada mas.

CREATE TABLE  PDT.Usuario 
(
	ID_USUARIO NUMERIC (10) NOT NULL, --SI CONTROLAMOS POR LA CEDULA Y TIPO DE USUARIO PUEDE NO SER NECESARIO USAR ID.
	USUARIO VARCHAR (80) NOT NULL,
	PASS   VARCHAR (30) NOT NULL, 
	TIPOUSU VARCHAR (40) NOT NULL,  -- administrador , -- voluntario, --experto (Por definir)
	NOMBRE VARCHAR (40) NOT NULL,
	APELLIDO VARCHAR(40) NOT NULL,
	ESTADO VARCHAR(40), -- activo , dado baja etc
	TIPODOC VARCHAR(40), -- CI, Pasaporte Carta de ciudadania, Otros
	NUMERODOC NUMERIC(8) NOT NULL,
	DIRECCION  VARCHAR(40) NOT NULL,
	MAIL VARCHAR (100)

)
; 
-- 1 era opcion  si no creamos tabla auxiliar con tipo de usuario quedaria asi.
--2 da opcion si creamos tabla auxiliar de tipos de usuarios, y el dia de mañana queremos agregar un tipo de usuario no es necesario tocar codigo, basta con agregar un registro.


ALTER TABLE PDT.USUARIO
ADD CONSTRAINT PK_USUARIO PRIMARY KEY (ID_USUARIO, TIPOUSU); -- SI LO CONTROLAMOS ASI , NO PRECISA SEQ NI TABLA AUX.

--lA OTRA OPCION ES HACER ID CON SEQ PERO LA UNICA FORMA DE CONTROLAR QUE NO SE REPITA EL ID ES CREANDO UNA TABLA AUXILIAR.

------------------------------------------------------------------
--TABLA OBSERVACIONES
-----------------------------------------------------------------

CREATE TABLE PDT.OBSERVACIONES
(
	ID_OBSERVACION NUMERIC (10) NOT NULL,
	DESCRIPCION VARCHAR(50), NOT NULL,
	IMAGEN BLOB, 
	GEOLOCALIZACION NUMERIC(50) NOT NULL, --NI PUTA IDEA COMO FUNCIONA ESTO
	ESTADO VARCHAR (50) NOT NULL,
	FECHAHORA SYSDATE, -- INSERT INTO TABLA (id, fecha) VALUES (100, SYSDATE), eso registrará en la columna fecha el instante de tiempo en el que se efectúa el INSERT del registro.
	FENOMENO VARCHAR(50) NOT NULL, -- GRANIZO, INCENDIO ETC
	INFORMACION VARCHAR(50) NOT NULL -- LOCALIDAD, DEPARTAMENTO, ZONA (VER SI LO CONTROLAMOS DE JAVA CON ENUM O SE CREAN TABLAS AUXILIARES.)
)

ALTER TABLE PDT.OBSERVACIONES
ADD CONSTRAINT PK_IDOBSERVACION PRIMARY KEY (ID_OBSERVACION); --CLAVE PRIMARIA DE OBSERVACION.

ALTER TABLE PDT.OBSERVACIONES
ADD CONSTRAINT  FK_USUOBSERVACION FOREIGN KEY (ID_OBSERVACION) REFERENCES PDT.USUARIO	(NUMERODOC,TIPOUSU) ; -- REFERENCIA DE USUARIOS CON OBSERVACCIONES. CUALQUIERA DE LOS USUARIOS PUEDE LEVANTAR UNA OBSERVACION

	
	
	
	



