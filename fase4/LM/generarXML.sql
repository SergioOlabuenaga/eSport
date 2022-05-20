DECLARE 
  qryCtx DBMS_XMLGEN.ctxHandle; 
  result CLOB; 
BEGIN 
  qryCtx := DBMS_XMLGEN.newContext( 
              'SELECT * FROM jornada'); 
  DBMS_XMLGEN.setNullHandling (qryCtx, 1);	    
  DBMS_XMLGEN.setRowSetTag(qryCtx, 'Jornadas'); 
  DBMS_XMLGEN.setRowTag(qryCtx, 'Jornada'); 
  result := DBMS_XMLGEN.getXML(qryCtx); 
  INSERT INTO XMLS VALUES(result); 
  DBMS_XMLGEN.closeContext(qryCtx); 
END;

DECLARE 
  qryCtx DBMS_XMLGEN.ctxHandle; 
  result CLOB; 
BEGIN 
  qryCtx := DBMS_XMLGEN.newContext( 
              'SELECT * FROM jornada WHERE Fecha = (SELECT MAX(Fecha) from jornada)'); 
  DBMS_XMLGEN.setNullHandling (qryCtx, 1);	    
  DBMS_XMLGEN.setRowSetTag(qryCtx, 'Jornadas'); 
  DBMS_XMLGEN.setRowTag(qryCtx, 'UltimaJornada'); 
  result := DBMS_XMLGEN.getXML(qryCtx); 
  INSERT INTO XMLS VALUES(result); 
  DBMS_XMLGEN.closeContext(qryCtx); 
END;

DECLARE 
  qryCtx DBMS_XMLGEN.ctxHandle; 
  result CLOB; 
BEGIN 
  qryCtx := DBMS_XMLGEN.newContext( 
              'SELECT * FROM clasificacion'); 
  DBMS_XMLGEN.setNullHandling (qryCtx, 1);	    
  DBMS_XMLGEN.setRowSetTag(qryCtx, 'Clasificación'); 
  DBMS_XMLGEN.setRowTag(qryCtx, 'Equipo'); 
  result := DBMS_XMLGEN.getXML(qryCtx); 
  INSERT INTO XMLS VALUES(result); 
  DBMS_XMLGEN.closeContext(qryCtx); 
END;
