package hw29.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "album")
@Data
@NoArgsConstructor
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDate releaseDate;
    @Enumerated(EnumType.STRING)
    private MusicStyle musicStyle;
    private double price;
    private String single;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "artist_id")
    private Artist artist;

    public Album(String name, LocalDate releaseDate, MusicStyle musicStyle, String single, Artist artist, double price) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.musicStyle = musicStyle;
        this.single = single;
        this.artist = artist;
        this.price = price;
    }
}
