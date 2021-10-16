package top.smokeydays.librarydemo.datatype;

public class NovelBook extends AbstractBook{
    private String hero;

    public NovelBook(String name, String author, String description, int pageCount, String hero) {
        super(name, author, description, pageCount);
        this.hero = hero;
    }

    public void reveal(){
        System.out.println(
                "名称: " + super.getName() + "\n" +
                "作者: " + super.getAuthor() + "\n" +
                "描述: " + super.getDescription() + "\n" +
                "总页数: " + super.getPageCount() + "\n" +
                "新旧程度: " + super.getAge() + "\n" +
                "主角: " + hero + "\n" +
                "类型: 小说\n"
        );
    }

    public String getType() {
        return "NovelBook";
    }

}
