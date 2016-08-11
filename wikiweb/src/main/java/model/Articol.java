package model;

/**
 * Created by andmatei on 8/11/2016.
 */
import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Articol")
public class Articol{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name = "titlu")
    private String titlu;

    @Column(name = "url")
    private String url;

    public void setId(int id) {this.id = id;}
    public void setTitlu(String titlu) {this.titlu = titlu;}
    public void setUrl(String url) {this.url = url;}

    public int getId(int id) {return this.id;}
    public String getTitlu(String titlu) {return this.titlu;}
    public String getUrl(String url) {return this.url;}

    @Override
    public String toString() {
        return "Articol{" +
                "id=" + id +
                ", titlu='" + titlu + '\'' +
                ", url=" + url +
                '}';
    }
}