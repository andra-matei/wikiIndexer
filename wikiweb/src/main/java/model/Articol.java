package model;

/**
 * Created by andmatei on 8/11/2016.
 */

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Articol")
public class Articol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "titlu")
    private String titlu;

    @Column(name = "url")
    private String url;

    @OneToMany(mappedBy = "articol")
    private List<Cuvant> words;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Cuvant> getWords() {
        return words;
    }

    public void setWords(List<Cuvant> words) {
        this.words = words;
    }

    @Override
    public String toString() {
        return "Articol{" +
                "id=" + id +
                ", titlu='" + titlu + '\'' +
                ", url='" + url + '\'' +
                ", words=" + words +
                '}';
    }
}