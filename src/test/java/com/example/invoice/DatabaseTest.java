package com.example.invoice;

import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Classname com.example.invoice.DatabaseTest
 * @Description TODO
 * @Date 2022/3/17 14:28
 * @Author by fuxf
 */
@SpringBootTest
public class DatabaseTest {

   /* @Autowired
    private StringEncryptor encryptor;

    @Test
    public void getPass() {
        String url = encryptor.encrypt("jdbc:mysql://121.40.146.68:3306/invoice?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true");
        String name = encryptor.encrypt("root");
        String password = encryptor.encrypt("xiaofu1517");
        System.out.println("database url: " + url);
        System.out.println("database name: " + name);
        System.out.println("database password: " + password);

    }*/

   /* @Test
    public void function(){
        Function<Integer ,Integer> function= (x)->x+10;
        final Integer add = add(1, function);
        System.out.println(add);

    }

    public Integer add(Integer x, Function<Integer,Integer> function){
        return function.apply(x);
    }*/

   /* @Test
    public void consumer(){
        Consumer<String> consumer = x-> System.out.println(x);
        get("aa",consumer);
    }
    public void get(String f, Consumer<String> consumer){
         consumer.accept(f);
    }*/


    /*  @Test
      public void predicate(){
          Predicate<Integer> predicate = x->x == 10;
          final boolean predicate1 = predicate(10, predicate);
          System.out.println(predicate1);
      }

      public boolean predicate(Integer temp,Predicate<Integer> predicate){
         return predicate.test(temp);
      }*/
   /* @Test
    public void supplier() {
        Supplier<Integer> supplier=()-> ThreadLocalRandom.current().nextInt();
        final Integer supplier1 = supplier(supplier);
        System.out.println(supplier1);
    }

    public Integer supplier(Supplier<Integer> supplier) {
        return supplier.get();
    }*/
}
