package model;

import javax.persistence.*;

/**
 * Created by azburatura on 8/11/2016.
 */
@Entity
@Table(name = "cuvant")
public class Cuvant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "denumire")
    private String word;

    @Column(name = "number_of_times")
    private int occurences;

    @ManyToOne
    @JoinColumn(name = "idTitlu")
    private Articol articol;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getOccurences() {
        return occurences;
    }

    public void setOccurences(int occurences) {
        this.occurences = occurences;
    }

    public Articol getArticol() {
        return articol;
    }

    public void setArticol(Articol articol) {
        this.articol = articol;
    }
}
