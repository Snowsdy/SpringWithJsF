package fr.audit.app.metier.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Audit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("class")
    @Transient
    final String clazz = this.getClass().getCanonicalName();

    @OneToOne
    private Agent agent;
    @OneToOne
    private Poste poste;
    @OneToMany
    public List<Auditeur> auditeurs;

    @Temporal(TemporalType.DATE)
    private Date date;

    @OneToOne
    public Modele modele;

    private String titre;

    @OneToMany
    private List<Valeurs> valeurs;

    public Audit() {
    }

    public Audit(Agent agent, Poste poste, List<Auditeur> auditeurs, Date date, Modele modele, String titre, List<Valeurs> valeurs) {
        this.agent = agent;
        this.poste = poste;
        this.auditeurs = auditeurs;
        this.date = date;
        this.modele = modele;
        this.titre = titre;
        this.valeurs = valeurs;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Auditeur> getAuditeurs() {
        return auditeurs;
    }

    public void setAuditeurs(List<Auditeur> auditeurs) {
        this.auditeurs = auditeurs;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public List<Valeurs> getValeurs() {
        return valeurs;
    }

    public void setValeurs(List<Valeurs> valeurs) {
        this.valeurs = valeurs;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.id);
        hash = 61 * hash + Objects.hashCode(this.agent);
        hash = 61 * hash + Objects.hashCode(this.poste);
        hash = 61 * hash + Objects.hashCode(this.auditeurs);
        hash = 61 * hash + Objects.hashCode(this.date);
        hash = 61 * hash + Objects.hashCode(this.modele);
        hash = 61 * hash + Objects.hashCode(this.titre);
        hash = 61 * hash + Objects.hashCode(this.valeurs);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Audit other = (Audit) obj;
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.agent, other.agent)) {
            return false;
        }
        if (!Objects.equals(this.poste, other.poste)) {
            return false;
        }
        if (!Objects.equals(this.auditeurs, other.auditeurs)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.modele, other.modele)) {
            return false;
        }
        return Objects.equals(this.valeurs, other.valeurs);
    }

    @Override
    public String toString() {
        return "Audit{" + "id=" + id + ", agent=" + agent + ", poste=" + poste + ", auditeurs=" + auditeurs + ", date=" + date + ", modele=" + modele + ", titre=" + titre + ", valeurs=" + valeurs + '}';
    }

}
