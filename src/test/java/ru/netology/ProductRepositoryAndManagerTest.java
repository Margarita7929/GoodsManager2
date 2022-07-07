package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryAndManagerTest {


    Product product1 = new Product(1, "Wine", 1000);
    Product product2 = new Product(2, "Glasses", 2000);
    Product product3 = new Product(3, "Forks", 500);
    Product product4 = new Product(4, "Knifes", 600);

    @Test
    public void getAllProducts() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);

        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    Book book1 = new Book(5, "Jane Air",300, "Tolstoy");
    Book book2 = new Book(6, "Peace and War", 400, "Tolstoy");
    Book book3 = new Book(7, "Dandelion wine", 200, "Bradbury");
    Book book4 = new Book(8, "Jane Air", 350, "Bronte");

    @Test
    public void getAllBooks() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(book4);

        Product[] expected = {book1, book2, book3, book4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    Smartphone phone1 = new Smartphone(5, "Nokia", 20000, "Japan");
    Smartphone phone2 = new Smartphone(6, "Samsung", 30000, "Korea");
    Smartphone phone3 = new Smartphone(7, "Jane Air", 60000, "Vietnam");
    Smartphone phone4 = new Smartphone(8, "Motorola", 5000, "China");

    @Test
    public void getAllSmartphones() {
        ProductRepository repo = new ProductRepository();
        repo.save(phone1);
        repo.save(phone2);
        repo.save(phone3);
        repo.save(phone4);

        Product[] expected = {phone1, phone2, phone3, phone4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeOneProduct() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.removeById(product2.getId());

        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void removeOneBook() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book3);
        repo.save(book2);
        repo.removeById(book2.getId());

        Product[] expected = {book1, book3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void removeOneSmartphone() {
        ProductRepository repo = new ProductRepository();
        repo.save(phone1);
        repo.save(phone3);
        repo.save(phone2);
        repo.removeById(phone2.getId());

        Product[] expected = {phone1, phone3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);


    @Test
    public void searchOneBook() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] expected = {book2};
        Product[] actual = manager.searchBy("Peace and War");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchOneSmartphone() {
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
        manager.add(phone4);

        Product[] expected = {phone2};
        Product[] actual = manager.searchBy("Samsung");
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void searchOneProduct() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);

        Product[] expected = {product4};
        Product[] actual = manager.searchBy("Knifes");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchOneProductAmongDiffGoods() {
        manager.add(product1);
        manager.add(product2);
        manager.add(book4);
        manager.add(phone4);

        Product[] expected = {product2};
        Product[] actual = manager.searchBy("Glasses");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchIfThereAreNoSuchGoods() {
        manager.add(product1);
        manager.add(product2);
        manager.add(book1);
        manager.add(phone4);


        Product[] expected = {};
        Product[] actual = manager.searchBy("Sun");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchIfSeveralSuitableGoods() {
        manager.add(product1);
        manager.add(product2);
        manager.add(book1);
        manager.add(book4);
        manager.add(phone4);


        Product[] expected = {book1, book4};
        Product[] actual = manager.searchBy("Jane Air");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void searchIfSeveralSuitableDiffGoods() {
        manager.add(product1);
        manager.add(product2);
        manager.add(book1);
        manager.add(phone3);
        manager.add(phone4);


        Product[] expected = {book1, phone3};
        Product[] actual = manager.searchBy("Jane Air");
        Assertions.assertArrayEquals(expected, actual);
    }


}







