package hw29.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "buying_album")
@Data
@NoArgsConstructor
public class BuyingAlbum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "album_id")
    private Album album;

    public BuyingAlbum(Album album) {
        this.album = album;
    }
}
