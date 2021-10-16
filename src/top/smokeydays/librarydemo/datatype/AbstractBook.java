package top.smokeydays.librarydemo.datatype;

public abstract class AbstractBook {

    private static int idCnt = 0;
    private int id;
    private String name;
    private String author;
    private String description;
    private int pageCount;
    private double age;

    public AbstractBook() {
        age = 1.0;
    }

    public AbstractBook(String name, String author, String description, int pageCount) {
        this.id = ++idCnt;
        this.name = name;
        this.author = author;
        this.description = description;
        this.pageCount = pageCount;
        age = 1.0;
    }

    public abstract void reveal();
    public abstract String getType();

    public boolean abstractEqual(AbstractBook newAbstractBook){
        boolean bo = false;
        bo |= newAbstractBook.getName() == this.name;
        bo |= newAbstractBook.getAuthor() == this.author;
        bo |= newAbstractBook.getDescription() == this.description;
        bo |= newAbstractBook.getPageCount() == this.pageCount;
        return bo;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public double getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
