-- Procedimiento Partidos_Ganados, con este conseguimos la cantidad de partidos que ha ganado un equipo
CREATE OR REPLACE PROCEDURE Partidos_Ganados(
 nombre_equipo IN equipo.nombre%TYPE,
 p_puntos OUT clasificacion.puntos%TYPE) IS
BEGIN
SELECT c.puntos/3 INTO p_puntos
FROM CLASIFICACION c, EQUIPO e
WHERE c.id_equipo = e.id_equipo AND upper(e.nombre) = upper(nombre_equipo);
END Partidos_Ganados;

-- Procedimiento Info_Jugador, desde aqui sacamos informción sobre dicho jugador
CREATE OR REPLACE PROCEDURE Info_Jugador(
 nombre_jugador IN jugador.nombre%TYPE,
 p_rol OUT jugador.rol%TYPE,
 p_nickname OUT jugador.nickname%TYPE,
 p_equipo OUT equipo.nombre%TYPE
 ) IS
BEGIN
SELECT j.rol, j.nickname, e.nombre INTO p_rol,p_nickname,p_equipo
FROM JUGADOR j, EQUIPO e
WHERE upper(j.nombre) = upper(nombre_jugador) AND j.id_equipo = e.id_equipo;
END Info_Jugador;