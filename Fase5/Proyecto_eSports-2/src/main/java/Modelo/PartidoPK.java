package Modelo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PartidoPK implements Serializable {
    @Column(name = "ID_PARTIDO")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPartido;
    @Column(name = "ID_LOCAL")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short idLocal;
    @Column(name = "ID_VISITANTE")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short idVisitante;

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public short getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(short idLocal) {
        this.idLocal = idLocal;
    }

    public short getIdVisitante() {
        return idVisitante;
    }

    public void setIdVisitante(short idVisitante) {
        this.idVisitante = idVisitante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartidoPK partidoPK = (PartidoPK) o;
        return idPartido == partidoPK.idPartido && idLocal == partidoPK.idLocal && idVisitante == partidoPK.idVisitante;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPartido, idLocal, idVisitante);
    }
}
