package hw29;

import hw29.dao.OrderDAO;
import hw29.entity.*;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Artist artist1 = new Artist("Gorillaz");
        Artist artist2 = new Artist("Eminem");
        Artist artist3 = new Artist("Baskov");
        Artist artist4 = new Artist("BitBand");
        Artist artist5 = new Artist("Mozart");
        Artist artist6 = new Artist("Prodigy");
        Album album1 = new Album("Gorillaz Album", LocalDate.of(2000, 5, 30),
                MusicStyle.ROCK, "Fills good inc.", artist1, 500.0);
        Album album2 = new Album("Eminem Album", LocalDate.of(1999, 2, 20),
                MusicStyle.RAP, "Without me", artist2, 250.0);
        Album album3 = new Album("Baskov Album", LocalDate.of(2005, 3, 10),
                MusicStyle.POP, "Zolota'a chasha", artist3, 100.0);
        Album album4 = new Album("BitBand Album", LocalDate.of(2015, 4, 15),
                MusicStyle.K_POP, "Ching Chong", artist4, 300.0);
        Album album5 = new Album("Mozart Collection", LocalDate.of(1785, 5, 25),
                MusicStyle.CLASSIC, "Allegro ", artist5, 1000.0);
        Album album6 = new Album("Prodigy tracks", LocalDate.of(2001, 6, 5),
                MusicStyle.CLUB, "Fire", artist2, 50);
        BuyingAlbum buyingAlbum1 = new BuyingAlbum(List.of(album1, album2, album3));
        BuyingAlbum buyingAlbum2 = new BuyingAlbum(List.of(album4, album5, album6));
        Customer customer1 = new Customer("Mr.", "Smith");
        Customer customer2 = new Customer("Ms.", "Smiths");

        Orders orders1 = new Orders(buyingAlbum1, customer1);
        Orders orders2 = new Orders(buyingAlbum2, customer2);

        OrderDAO orderDAO = new OrderDAO();
        orderDAO.save(orders1);
        orderDAO.save(orders2);
        orderDAO.loadById(1);
        orderDAO.loadById(2);
    }


}
