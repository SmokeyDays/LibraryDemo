package top.smokeydays.librarydemo.datatype;

public class ProgramBook extends AbstractBook {
    private String langType;
    private String blogLink;

    public ProgramBook(String name, String author, String description, int pageCount, String langType, String blogLink) {
        super(name, author, description, pageCount);
        this.langType = langType;
        this.blogLink = langType;
    }

    public void reveal(){
        System.out.println(
                "名称: " + super.getName() + "\n" +
                "作者: " + super.getAuthor() + "\n" +
                "描述: " + super.getDescription() + "\n" +
                "总页数: " + super.getPageCount() + "\n" +
                "新旧程度: " + super.getAge() + "\n" +
                "语言类型: " + langType + "\n" +
                "博客链接: " + blogLink + "\n" +
                "类型: 编程书\n"
        );
    }

    public String getType() {
        return "ProgramBook";
    }
}
