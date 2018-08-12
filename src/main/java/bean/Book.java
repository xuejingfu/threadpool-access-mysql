package bean;

/**
 * Created by xuejingfu
 * 2018/8/12.14:42
 */
public class Book {

    private long id;
    private String bookName;
    private String userName;

    public Book() {
    }

    public Book(String bookName, String userName) {
        this.bookName = bookName;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
