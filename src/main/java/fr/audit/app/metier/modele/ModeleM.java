package fr.audit.app.metier.modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import metier.entity.Champ;
import metier.entity.Modele;
import metier.entity.Section;
import metier.model.SectionM;
/**
 *
 * @author bob
 */
public class ModeleM {
    private long id;
    private String type;
    private int niveau;
    private List<SectionM> sections;

    public ModeleM() {
        List<SectionM> s;
        s = new ArrayList<>();
        this.sections = s;
    }

    public ModeleM(long id, String type, int niveau, List<SectionM> sections) {
        this.id = id;
        this.type = type;
        this.niveau = niveau;
        this.sections = sections;
    }

    public ModeleM(Modele m) {
        this.id = m.getId();
        this.niveau = m.getNiveau();
        this.type = m.getType();
        List<SectionM> s = new ArrayList();
        for(Section sec: m.getSections()){
            SectionM sect = new SectionM();
            sect.setId(sec.getId());
            sect.setImage(sec.getImage());
            sect.setNom(sec.getNom());
            List<ChampM> c = new ArrayList();
            for(Champ ch: sec.getChamps()){
                ChampM champ = new ChampM();
                champ.setId(ch.getId());
                champ.setNom(ch.getNom());
                c.add(champ);
            }
            sect.setChamps(c);
            s.add(sect);
        }
        this.sections = s;//To change body of generated methods, choose Tools | Templates.
    }

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getNiveau() {
        return niveau;
    }

    public List<SectionM> getSections() {
        return sections;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public void setSections(List<SectionM> sections) {
        this.sections = sections;
    }

    public void addSections(SectionM s){
        this.sections.add(s);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 67 * hash + Objects.hashCode(this.type);
        hash = 67 * hash + this.niveau;
        hash = 67 * hash + Objects.hashCode(this.sections);
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
        final ModeleM other = (ModeleM) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.niveau != other.niveau) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.sections, other.sections)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ModeleM{" + "id=" + id + ", type=" + type + ", niveau=" + niveau + ", sections=" + sections + '}';
    }







}
