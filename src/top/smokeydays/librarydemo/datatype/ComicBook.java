package top.smokeydays.librarydemo.datatype;

public class ComicBook extends AbstractBook {
    public ComicBook(String name, String author, String description, int pageCount) {
        super(name, author, description, pageCount);
    }
    public void reveal(){
        System.out.println(
            "名称: " + super.getName() + "\n" +
            "作者: " + super.getAuthor() + "\n" +
            "描述: " + super.getDescription() + "\n" +
            "总页数: " + super.getPageCount() + "\n" +
            "新旧程度: " + super.getAge() + "\n" +
            "类型: 漫画\n"
        );
    }

    public boolean equals(ComicBook newComicBook) {
        return super.abstractEqual(newComicBook);
    }

    public String getType() {
        return "ComicBook";
    }
}
