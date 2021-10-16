package top.smokeydays.librarydemo.datatype;

import java.util.LinkedList;
import java.util.List;

public class Bookshelf {

    private LinkedList<AbstractBook> bookList = new LinkedList<>();

    public void insertBook(AbstractBook newBook) {
        bookList.add(newBook);
    }

    public LinkedList<AbstractBook> borrowAllBook() {
        LinkedList<AbstractBook> ret = new LinkedList<>();
        for(AbstractBook i: bookList) {
            ret.add(i);
            i.reveal();
        }
        bookList.clear();
        return ret;
    }

    public AbstractBook getLastBook() {
        return bookList.getLast();
    }

    public List<AbstractBook> getAllBook() {
        return bookList;
    }

    public AbstractBook searchById(int id) {
        for(AbstractBook i: bookList) {
            if(i.getId() == id) {
                return i;
            }
        }
        System.out.println("No. " + id + " Book Not Found in The Bookshelf.");
        return null;
    }

    public AbstractBook borrowById(int id) {
        for(int i = bookList.size() - 1; i >= 0; --i) {
            if(bookList.get(i).getId() == id) {
                return bookList.remove(i);
            }
        }
        System.out.println("No. " + id + " Book Not Found in The Bookshelf.");
        return null;
    }

    public LinkedList<AbstractBook> searchByName(String bookName) {
        LinkedList<AbstractBook> ret = new LinkedList<>();
        for(AbstractBook i: bookList) {
            if (i.getName().indexOf(bookName) >= 0) {
                ret.add(i);
            }
        }
        return ret;
    }

    public AbstractBook borrowByName(String bookName) {
        for(int i = bookList.size() - 1; i >= 0; --i) {
            if(bookList.get(i).getName().indexOf(bookName) >= 0) {
                return bookList.remove(i);
            }
        }
        System.out.println("Error: target book not existed.");
        return null;
    }

    public void modifyById(AbstractBook abstractBook) {
        for(int i = bookList.size() - 1; i >= 0; --i) {
            if(bookList.get(i).getId() == abstractBook.getId()) {
                bookList.set(i, abstractBook);
            }
        }
    }

}
