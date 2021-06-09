package fr.audit.app.metier.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Modele implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String type;

    @Transient
    @JsonProperty("class")
    final String clazz = this.getClass().getCanonicalName();

    private int niveau;

    @OneToMany(orphanRemoval = true)
    private List<Section> sections;

    private boolean obsolete;

    public Modele() {
    }

    public Modele(String type, List<Section> sections, int niveau) {
        this.type = type;
        this.sections = sections;
        this.niveau = niveau;
        this.obsolete = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void addSections(Section section) {
        this.sections.add(section);

    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public boolean isObsolete() {
        return obsolete;
    }

    public void setObsolete(boolean obsolete) {
        this.obsolete = obsolete;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 37 * hash + Objects.hashCode(this.type);
        hash = 37 * hash + Objects.hashCode(this.sections);
        hash = 37 * hash + this.niveau;
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
        final Modele other = (Modele) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.niveau != other.niveau) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return Objects.equals(this.sections, other.sections);
    }

    @Override
    public String toString() {
        return "Modele{" + "id=" + id + ", type=" + type + ", niveau=" + niveau + ", sections=" + sections + '}';
    }

}
