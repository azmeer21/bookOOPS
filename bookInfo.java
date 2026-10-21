import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.File;

class bookInfo{
    public static void main(String[] args) {
        book data = new book();

        data.title = "Functional Programming in Scala";
        data.author = "Paul Chiusano & Runar Bjarnason";
        data.publisher = "Manning Publications";
        data.year = 2014;
        data.price = 59.99;
        data.bookUrl = "https://nbviewer.org/github/azmeer21/Functional-Programming-in-Scala/blob/main/Functional%20Programming%20in%20Scala.pdf"; 

        System.out.println("Title: " + data.title);
        System.out.println("Author: " + data.author);
        System.out.println("Publisher: " + data.publisher);
        System.out.println("Year: " + data.year);
        System.out.println("Price: $" + data.price);

        File file = new File("Functional Programming in Scala.pdf");
        String path = (file.getAbsolutePath());
        System.out.println(path);

        try {
    if (Desktop.isDesktopSupported()) {
        Desktop desktop = Desktop.getDesktop();

        if (data.bookUrl != null && !data.bookUrl.isEmpty() && desktop.isSupported(Desktop.Action.BROWSE)) {
            desktop.browse(new URI(data.bookUrl));
        } else {
            File fileOpen = new File(path);
            if (fileOpen.exists() && desktop.isSupported(Desktop.Action.OPEN)) {
                desktop.open(fileOpen);
            } else {
                System.out.println("Error: The PDF file does not exist or OPEN action is not supported.");
            }
        }
    } else {
        System.out.println("Desktop actions are not supported on this operating system.");
    }
} catch (IOException | URISyntaxException | UnsupportedOperationException | IllegalArgumentException e) {
    System.out.println("An error occurred: " + e.getMessage());
}
    }
}
