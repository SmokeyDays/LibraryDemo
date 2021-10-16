package top.smokeydays.librarydemo.librarycore;

import top.smokeydays.librarydemo.datatype.ComicBook;
import top.smokeydays.librarydemo.datatype.NovelBook;
import top.smokeydays.librarydemo.datatype.ProgramBook;

public class BookGenerator {
    public static ComicBook generateBook(String type, String name, String author, String description, int pageCount) {
        ComicBook ret = new ComicBook(name, author, description, pageCount);
        return ret;
    }
    public static NovelBook generateBook(String type, String name, String author, String description, int pageCount, String hero) {
        NovelBook ret = new NovelBook(name, author, description, pageCount, hero);
        return ret;
    }
    public static ProgramBook generateBook(String type, String name, String author, String description, int pageCount, String langType, String blogLink) {
        ProgramBook ret = new ProgramBook(name, author, description, pageCount, langType, blogLink);
        return ret;
    }
}
