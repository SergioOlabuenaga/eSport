create or replace procedure Xml_Clasificacion(resultado out clob)
is
    datosxml xmltype;
begin
    select xmlelement("Clasificacion",
        (select xmlagg(xmlelement("Equipo",
            xmlattributes(e.id_equipo "cod"),
            xmlelement("nombre", e.nombre),
            xmlelement("puntos", c.puntos),
            (select xmlagg(xmlelement("jugador",
                xmlattributes(j.id_jugador "cod"),
                xmlelement("nombre", j.nombre),
                xmlelement("nickname", j.nickname),
                xmlelement("rol", j.rol)
            ))
            from jugador j
            where j.id_equipo = e.id_equipo)
        ))
        from equipo e, clasificacion c
        where c.id_equipo = e.id_equipo)
    ) into datosxml
    from dual;
    
    resultado := datosxml.getClobVal();
    dbms_output.put_line(to_char(resultado));
end;

create or replace procedure Xml_Jornadas(resultado out clob)
is
    datosxml xmltype;
begin
    select xmlelement("Calendario",
        (select xmlagg(xmlelement("Jornada",
            xmlattributes(j.id_jornada "Cod"),
            xmlelement("Fecha", j.fecha),
            (select xmlagg(xmlelement("Partido",
                xmlattributes(p.id_partido "Cod"),
                (select xmlagg(xmlelement("Equipo_Local",xmlattributes(e.nombre))) from equipo e where e.id_equipo = p.id_local),
                (select xmlagg(xmlelement("Equipo_Visitante",xmlattributes(e.nombre))) from equipo e where e.id_equipo = p.id_visitante),
                xmlelement("Puntos_Local", p.puntos_local),
                xmlelement("Puntos_Visitante", p.puntos_visitante)
            ))
            from partido p
            where p.id_jornada = j.id_jornada)
        ))
        from jornada j, partido p
        where j.id_jornada = p.id_jornada)
    ) into datosxml
    from dual;
    
    resultado := datosxml.getClobVal();
    dbms_output.put_line(to_char(resultado));
end;

create or replace procedure Xml_Ultima_Jornada(resultado out clob)
is
    datosxml xmltype;
begin
    select xmlelement("Calendario",
        (select xmlagg(xmlelement("Jornada",
            xmlattributes(j.id_jornada "Cod"),
            xmlelement("Fecha", j.fecha),
            (select xmlagg(xmlelement("Partido",
                xmlattributes(p.id_partido "Cod"),
                (select xmlagg(xmlelement("Equipo_Local",xmlattributes(e.nombre))) from equipo e where e.id_equipo = p.id_local),
                (select xmlagg(xmlelement("Equipo_Visitante",xmlattributes(e.nombre))) from equipo e where e.id_equipo = p.id_visitante),
                xmlelement("Puntos_Local", p.puntos_local),
                xmlelement("Puntos_Visitante", p.puntos_visitante)
            ))
            from partido p
            where p.id_jornada = j.id_jornada)
        ))
        from jornada j, partido p
        where j.id_jornada = p.id_jornada and j.fecha = (SELECT MAX(FECHA) FROM JORNADA))
    ) into datosxml
    from dual;
    
    resultado := datosxml.getClobVal();
    dbms_output.put_line(to_char(resultado));
end;