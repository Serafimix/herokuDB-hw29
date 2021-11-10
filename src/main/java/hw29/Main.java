package hw29;

import hw29.dao.OrderDAO;
import hw29.entity.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Artist artist1 = new Artist("Gorillaz");
        Artist artist2 = new Artist("Eminem");
        Album album1 = new Album("Gorillaz Album", LocalDate.of(2000, 5, 30),
                MusicStyle.ROCK, "Fills good inc.", artist1, 500.0);
        Album album2 = new Album("Eminem Album", LocalDate.of(1999, 2, 20),
                MusicStyle.RAP, "Without me", artist2, 250.0);
        BuyingAlbum buyingAlbum1 = new BuyingAlbum(album1);
        BuyingAlbum buyingAlbum2 = new BuyingAlbum(album2);
        Customer customer1 = new Customer("Mr.", "Smith");
        Customer customer2 = new Customer("Ms.", "Smiths");
        Orders orders1 = new Orders(buyingAlbum1, customer1);
        Orders orders2 = new Orders(buyingAlbum2, customer2);

        OrderDAO orderDAO = new OrderDAO();
        orderDAO.save(orders1);
        orderDAO.loadById(1);
    }


}
