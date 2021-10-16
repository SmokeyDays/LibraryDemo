package top.smokeydays.librarydemo;

import top.smokeydays.librarydemo.datatype.AbstractBook;
import top.smokeydays.librarydemo.librarycore.BookGenerator;
import top.smokeydays.librarydemo.librarycore.LibraryConsole;
import top.smokeydays.librarydemo.usersystem.LoginSystem;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        LibraryConsole.init(3);
        LoginSystem.adminLogin("admin");
        LibraryConsole.adminAddBook(0, BookGenerator
                .generateBook("ComicBook", "aaa", "SmokeyDays", "My Manga", 998244353));
        LibraryConsole.adminAddBook(0, BookGenerator
                .generateBook("NovelBook", "bbb", "SmokeyDays", "My Manga", 19260817, "Alice&Bob"));
        LibraryConsole.adminAddBook(1, BookGenerator
                .generateBook("ComicBook", "ccc", "SmokeyDays", "My Manga", 998244853));
        LibraryConsole.adminAddBook(2, BookGenerator
                .generateBook("ProgramBook", "ddd", "SmokeyDays", "My Manga", 1000000007, "TestLang", "Smokey_Days"));
        LibraryConsole.adminAddBook(2, BookGenerator
                .generateBook("NovelBook", "eee", "SmokeyDays", "My Manga", 919260817, "Alice&Bob"));
        LoginSystem.adminLogout();
        LoginSystem.userRegister("A",  "apswd");
        LoginSystem.userLogin("A", "apswd");
        LibraryConsole.borrowAllBook(0);
        LibraryConsole.borrowByName("eee");
        LoginSystem.userLogout("A");
        LoginSystem.userRegister("B",  "bpswd");
        LoginSystem.userLogin("B", "bpswd");
        LibraryConsole.borrowAllBook(0);
        LibraryConsole.borrowByName("ddd");
        LoginSystem.userLogout("B");
        LoginSystem.adminLogin("admin");
        LibraryConsole.adminBan("B");
        List<AbstractBook> abstractBookList = LibraryConsole.getAllBookOnShelf();
        for(AbstractBook i: abstractBookList) {
            i.setAge(0.5);
            LibraryConsole.modifyById(i);
        }
        LoginSystem.adminLogout();
        System.out.println("Books in storage:");
        abstractBookList = LibraryConsole.getAllBook(-1);
        for(AbstractBook i: abstractBookList) {
            i.reveal();
        }
        for(int i=0; i < 3; ++i) {
            System.out.println("Books on " + (i + 1) + " :");
            abstractBookList = LibraryConsole.getAllBook(i);
            for(AbstractBook j: abstractBookList) {
                j.reveal();
            }
        }
        System.out.println("Books of A:");
        abstractBookList = LibraryConsole.getAllBookOfUser("A");
        for(AbstractBook i: abstractBookList) {
            i.reveal();
        }
        System.out.println("Books of B:");
        abstractBookList = LibraryConsole.getAllBookOfUser("B");
        for(AbstractBook i: abstractBookList) {
            i.reveal();
        }
    }
}
