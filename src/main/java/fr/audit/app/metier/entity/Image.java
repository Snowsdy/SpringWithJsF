package fr.audit.app.metier.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Arrays;
import javax.persistence.*;


@Entity
public class Image implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @Transient
    @JsonProperty("class")
    final String clazz = this.getClass().getCanonicalName();

    @Lob
    private byte[] image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", clazz='" + clazz + '\'' +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
