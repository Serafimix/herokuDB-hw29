package hw29.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "buying_album")
@Data
@NoArgsConstructor
public class BuyingAlbum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @ToString.Exclude
    @Column(name = "list")
    private List<Album> albums = new ArrayList<>();

    public BuyingAlbum(List<Album> albums) {
        this.albums = albums;
    }
}
