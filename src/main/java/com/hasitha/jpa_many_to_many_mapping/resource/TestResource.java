package com.hasitha.jpa_many_to_many_mapping.resource;

import com.hasitha.jpa_many_to_many_mapping.entity.Author;
import com.hasitha.jpa_many_to_many_mapping.entity.Book;
import com.hasitha.jpa_many_to_many_mapping.repository.AuthorRepository;
import com.hasitha.jpa_many_to_many_mapping.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TestResource {


    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;


    @GetMapping("/save")
    public String saveData(){
        Author a1= new Author();
        a1.setAuthorName("Hasitha");

        Author a2= new Author();
        a2.setAuthorName("Thamaranga");

        Author a3= new Author();
        a3.setAuthorName("Kasun");

        Book b1= new Book();
        b1.setBookName("My book 01");

        Book b2= new Book();
        b2.setBookName("My book 02");

        b1.getListOfAuthors().add(a1);
        b1.getListOfAuthors().add(a2);
        b1.getListOfAuthors().add(a3);

        b2.getListOfAuthors().add(a2);

        Book book1=bookRepository.save(b1);
        Book book2=bookRepository.save(b2);



        return "data saved successfully.";


    }

    @GetMapping("/retrieve")
    public String retrieveData(){
        Optional<Book> book=bookRepository.findById(Long.parseLong("1"));
        if(book.isPresent()){
            String result="";
            result=(book.get().getId() + " | "+book.get().getBookName())+"***************";
            for (Author author:book.get().getListOfAuthors()) {
                result=result+(author.getId() + " | "+author.getAuthorName()+ "###########");
            }
            return result;

        }else{
            return "No data found";

        }

    }
    /*
     * Since I have mapped bi-directionaly, when query for child entity I get parent
     * entity data also.
     * */
    @GetMapping("/retrieveAuthor")
    public String retrieveAuthorData(){
        Optional<Author> author=authorRepository.findById(Long.parseLong("2"));
        if(author.isPresent()){
            String result="";
            result=(author.get().getId() + " | "+author.get().getAuthorName())+ "**************";
            for (Book book:author.get().getListOfBooks()) {
                result=result+(book.getId() + " | "+book.getBookName())+ "#################";
            }
            return result;

        }else{
            return "No data found";

        }

    }

    @GetMapping("/update")
    public String updateData(){
        Optional<Book> book=bookRepository.findById(Long.parseLong("2"));
        if(book.isPresent()){
            Book b=book.get();

            Optional<Author> author=authorRepository.findById(Long.parseLong("3"));
            if(author.isPresent()){
                b.getListOfAuthors().add(author.get());
            }
            Book updatedStudent=bookRepository.save(b);
            return "Successfully updated.";
        }else{
            return "No data found for update";

        }

    }

    /*Here only Parent entity data will be deleted since I have only provided
    * CascadeType as PERSIST for Book entity */
    @GetMapping("/delete")
    public String deleteData(){
        Optional<Book> book=bookRepository.findById(Long.parseLong("2"));
        if(book.isPresent()){
            Book b= book.get();
            bookRepository.delete(b);
            return "Book deleted successfully";
        }else{
            return "No data found for  delete";

        }

    }

}
