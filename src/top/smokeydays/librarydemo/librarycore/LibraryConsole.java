package top.smokeydays.librarydemo.librarycore;

import top.smokeydays.librarydemo.datatype.AbstractBook;
import top.smokeydays.librarydemo.datatype.Bookshelf;

import java.util.*;

public class LibraryConsole {
    private static List<Bookshelf> shelfList = new LinkedList<>();
    private static Bookshelf storage = new Bookshelf();
    private static Map<String, Bookshelf> userShelfList = new HashMap<>();
    private static Map<String, Boolean> isBanned = new HashMap<>();
    private static String nowUser = null;
    private static boolean isAdmin = false;

    private static Bookshelf getBookshelf(int shelfId) {
        return shelfId>=0 ? shelfList.get(shelfId) : storage;
    }

    public static void init(int number) {
        System.out.println("Library Initialized " + number + " Bookshelves.");
        for(int i=1; i<=number; ++i){
            Bookshelf newBookshelf = new Bookshelf();
            shelfList.add(newBookshelf);
        }
    }


    public static void userInit(String userName) {
        Bookshelf newBookshelf = new Bookshelf();
        userShelfList.put(userName, newBookshelf);
        isBanned.put(userName, false);
    }

    public static void userLogin(String userName) {
        System.out.println("User" + userName + " Login Successfully.");
        nowUser = userName;
    }

    public static void adminLogin() {
        isAdmin = true;
    }

    public static void adminLogout() {
        isAdmin = false;
    }

    public static void userLogout(String userName) {
        System.out.println("Logout Successfully.");
        userName = null;
    }

    public static void adminAddBook(int shelfId, AbstractBook newBook) {
        if(!isAdmin){
            System.out.println("Permission Not Enough.");
            return;
        }
        getBookshelf(shelfId).insertBook(newBook);
    }

    public static void adminBan(String userName) {
        if(!isAdmin){
            System.out.println("Permission Not Enough.");
            return;
        }
        //此处强迫归还书籍。
        isBanned.put(userName, true);
        LinkedList<AbstractBook> bookshelfLinkedList = userShelfList.get(userName).borrowAllBook();
        System.out.println(bookshelfLinkedList.size() + " Books Forced Returned.");
        for(AbstractBook i: bookshelfLinkedList) {
            storage.insertBook(i);
        }
    }

    public static void adminChangeBook(int shelfId, int bookId) {
        if(!isAdmin){
            System.out.println("Permission Not Enough.");
            return;
        }
        getBookshelf(shelfId).insertBook(borrowById(bookId));
    }

    public static void queryBook(int shelfId, String keyword) {
        List<AbstractBook> nowList = getBookshelf(shelfId).searchByName(keyword);
        if(nowList.size() <= 0) {
            System.out.println("Targeted book not found.");
            return;
        }
        System.out.println("Books in bookshelf " + shelfId + " :");
        for(AbstractBook i: nowList) {
            i.reveal();
        }
    }

    public static AbstractBook borrowByName(int shelfId, String keyword) {
        AbstractBook abstractBook = getBookshelf(shelfId).borrowByName(keyword);
        if(abstractBook == null) {
            System.out.println("Bookshelf No." + shelfId + " Borrow by Name failed.");
            return null;
        } else {
            System.out.println("Books Borrowed:");
            abstractBook.reveal();
            userShelfList.get(nowUser).insertBook(abstractBook);
            return abstractBook;
        }
    }

    public static AbstractBook borrowByName(String keyword) {
        //用户只能按名字借书，故而不能访问库存。
        AbstractBook abstractBook = null, res = null;
        for(int i = shelfList.size() - 1; i >= 0; --i) {
            res = borrowByName(i, keyword);
            if (res != null) {
                abstractBook = res;
            }
        }
        return abstractBook;
    }

    public static AbstractBook borrowById(int shelfId, int id) {
        AbstractBook abstractBook = getBookshelf(shelfId).borrowById(id);
        if(abstractBook == null) {
            System.out.println("Bookshelf No." + shelfId + " Borrow by Id failed.");
            return null;
        } else {
            abstractBook.reveal();
            return abstractBook;
        }
    }

    public static AbstractBook borrowById(int id) {
        // -1 表示包括库存
        AbstractBook abstractBook = null, res = null;
        for(int i = shelfList.size() - 1; i >= -1; --i) {
            res = borrowById(i, id);
            if (res != null) {
                abstractBook = res;
            }
        }
        return abstractBook;
    }

    public static AbstractBook searchById(int shelfId, int id) {
        AbstractBook abstractBook = getBookshelf(shelfId).searchById(id);
        if(abstractBook == null) {
            System.out.println("Bookshelf No." + shelfId + " Search failed.");
            return null;
        } else {
            abstractBook.reveal();
            return abstractBook;
        }
    }

    public static AbstractBook searchById(int id) {
        // -1 表示包括库存
        AbstractBook abstractBook = null, res = null;
        for(int i = shelfList.size() - 1; i >= -1; --i) {
            res = searchById(i, id);
            if (res != null) {
                abstractBook = res;
            }
        }
        return abstractBook;
    }

    public static void borrowAllBook(int shelfId) {
        // 用户借走所有书，故不考虑库存。
        LinkedList<AbstractBook> nowList = shelfList.get(shelfId).borrowAllBook();
        System.out.println("Borrowed " + nowList.size() + " books.");
        for(AbstractBook i: nowList) {
            i.reveal();
            userShelfList.get(nowUser).insertBook(i);
        }
    }

    public static void returnById(int id) {
        storage.insertBook(userShelfList.get(nowUser).borrowById(id));
        System.out.println("Returned By Id Successfully");
    }

    public static void returnByName(String keyword) {
        storage.insertBook(userShelfList.get(nowUser).borrowByName(keyword));
        System.out.println("Returned By Name Successfully");
    }

    public static List<AbstractBook> getAllBook(int shelfId) {
        return getBookshelf(shelfId).getAllBook();
    }

    public static List<AbstractBook> getAllBookOnShelf() {
        List<AbstractBook> ret = new LinkedList<>();
        for(int i = shelfList.size() - 1; i >= 0; --i) {
            ret.addAll(shelfList.get(i).getAllBook());
        }
        return ret;
    }

    public static List<AbstractBook> getAllBookOfUser(String userName) {
        return userShelfList.get(userName).getAllBook();
    }

    public static void modifyById(int shelfId, AbstractBook newBook) {
        getBookshelf(shelfId).modifyById(newBook);
    }

    public static void modifyById(AbstractBook newBook) {
        for(int i = shelfList.size() - 1; i >= -1; --i) {
            modifyById(i, newBook);
        }
    }

}
