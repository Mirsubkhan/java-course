import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtworkDatabase {

    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DB_USER = "SYS AS SYSDBA"; 
    private static final String DB_PASSWORD = "man8ix"; 

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
    	Class.forName("oracle.jdbc.OracleDriver");
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public static List<Artwork> getAllArtworks() throws SQLException, ClassNotFoundException {
        List<Artwork> artworks = new ArrayList<>();
        String query = "SELECT title, author, yearOfCreation, category, placeOfCreation, imageUrl FROM ArtworkMuseum";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                int yearOfCreation = resultSet.getInt("yearOfCreation");
                String category = resultSet.getString("category");
                String placeOfCreation = resultSet.getString("placeOfCreation");
                String imageUrl = resultSet.getString("imageUrl");

                Artwork artwork = new Artwork(title, author, yearOfCreation, category, placeOfCreation, imageUrl);
                artworks.add(artwork);
            }
        }
        return artworks;
    }

    public static List<Artwork> searchArtworks(String title, String author, Integer year, String category, String place) throws SQLException, ClassNotFoundException {
        List<Artwork> artworks = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT title, author, yearOfCreation, category, placeOfCreation, imageUrl FROM ArtworkMuseum WHERE 1=1");

        if (title != null && !title.isEmpty()) {
            query.append(" AND title LIKE ?");
        }
        if (author != null && !author.isEmpty()) {
            query.append(" AND author LIKE ?");
        }
        if (year != null) {
            query.append(" AND yearOfCreation = ?");
        }
        if (category != null && !category.isEmpty()) {
            query.append(" AND category LIKE ?");
        }
        if (place != null && !place.isEmpty()) {
            query.append(" AND placeOfCreation LIKE ?");
        }

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query.toString())) {

            int index = 1;

            if (title != null && !title.isEmpty()) {
                statement.setString(index++, "%" + title + "%");
            }
            if (author != null && !author.isEmpty()) {
                statement.setString(index++, "%" + author + "%");
            }
            if (year != null) {
                statement.setInt(index++, year);
            }
            if (category != null && !category.isEmpty()) {
                statement.setString(index++, "%" + category + "%");
            }
            if (place != null && !place.isEmpty()) {
                statement.setString(index++, "%" + place + "%");
            }

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String artTitle = resultSet.getString("title");
                    String artAuthor = resultSet.getString("author");
                    int artYear = resultSet.getInt("yearOfCreation");
                    String artCategory = resultSet.getString("category");
                    String artPlace = resultSet.getString("placeOfCreation");
                    String artImageUrl = resultSet.getString("imageUrl");

                    Artwork artwork = new Artwork(artTitle, artAuthor, artYear, artCategory, artPlace, artImageUrl);
                    artworks.add(artwork);
                }
            }
        }
        return artworks;
    }
}
