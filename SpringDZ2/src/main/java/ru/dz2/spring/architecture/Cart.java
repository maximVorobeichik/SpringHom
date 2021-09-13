package ru.dz2.spring.architecture;

import javax.annotation.PreDestroy;
import java.util.*;

public class Cart {
    private ProductRepository productRepository;

    private final   List<Product> cartRepo = new ArrayList<Product>();


    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
      //   this.cartRepo = new ArrayList<Product>();
    }

    public void cartAdd(int id){
        cartRepo.add(productRepository.productGetId(id));
    }
    public void deleteId(int id) {
        ListIterator iterator=cartRepo.listIterator();
        while (iterator.hasNext()){
           Product product =(Product)iterator.next();
           if(product.getId()==id){
               iterator.remove();
           }
        }


    }
    public void printCart(){
        System.out.println(cartRepo);
    }


    public void UseCart(){
    boolean flagExitMenu=true;
        Scanner console = new Scanner(System.in);
        Scanner console2 = new Scanner(System.in);


    while (flagExitMenu){
        System.out.println("1-добавить продукт в ProductRepository\n 2-поиск продукта ProductRepository " +
                "\n 3-вывод всей корзины ProductRepository\n 4-удаление ProductRepository \n 5-добавить из productRepo в cart \n" +
                "6- удалить из cartRepo по id\n 7-принт всего из карт \n 8-выход и закрытие корзины");
        int input = console.nextInt();

        switch(input){
            case 1:
                System.out.println("ВВедите id");
                int id = console.nextInt();

                System.out.println("ВВедите name");
                String name = console2.nextLine();

                System.out.println("ВВедите cost");
                int cost = console.nextInt();
                productRepository.productAdd(new Product(id,name,cost));
                break;
            case 2:
                int id4 = console.nextInt();
               System.out.println(productRepository.productGetId(id4));
            case 3:
                productRepository.getAll();
                break;
            case 4:
                productRepository.deleteAll();
                break;
            case 5:
                System.out.println("ВВедите id");
                int id2 = console.nextInt();
                cartAdd(id2);
                break;
            case 6:
                System.out.println("ВВедите id");
                int id3 = console.nextInt();
                deleteId(id3);
                break;
            case 7:
                printCart();
                break;

            case 8: flagExitMenu=false;
                break;

        }



    }
    }


}
