import java.util.ArrayList;

class Book{
    private String title;
    private String author;

    Book(String title, String author){
        this.title=title;
        this.author=author;
    }

    public void displayBookDetails(){
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

class Library{
    private String name;
    private ArrayList<Book>books;

    Library(String name){
        this.name=name;
        this.books=new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void displayBooks(){
        System.out.println("Library: " + name);
        if (books.isEmpty()) {
            System.out.println("No books in this library.");
        } else {
            for (Book book : books) {
                book.displayBookDetails();
            }
        }
    }

}
public class LibraryAndBooks {
    public static void main(String[] args) {
        // Creating books
        Book book1 = new Book("The Alchemist", "Paulo Coelho");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book book3 = new Book("1984", "George Orwell");

        // Creating libraries
        Library library1 = new Library("City Library");
        Library library2 = new Library("University Library");

        // Adding books to libraries
        library1.addBook(book1);
        library1.addBook(book2);

        library2.addBook(book2);
        library2.addBook(book3);

        // Display books in each library
        library1.displayBooks();
        System.out.println();
        library2.displayBooks();
    }


}
