# Tutorial-Spring-Dasar
## Agenda atau urutan materi

* Pengenalan Spring
* Inversion Of Control
* Application Context
* Depedency Injection
* Bean
* Life Cycle
* Event Listener
* Dan lain-lain

### Pengenalan Spring Framework
* Spring Framework adalah framework paling populer di Java
* Saking Populernya,Spring Framework sampai mengalahkan popularitas Java Enterprise sendiri
* Spiring Framework dibuat sekitar tahun 2003 oleh Rod johnson, yang dibuat sebagai alternative java enterprise
* Spring Framework Semakin Populer karena sangat ringan dan mudah digunakan dibandingkan Java Enterprise
* https://spiring.io/

### Pengenalan Spring Boot
* Spring Boot merupakan framework untuk mempermudah pembuatan aplikasi Spring Framework
* Dahulu untuk menggunakan Spring Framework, untuk pemula tidaklah mudah, karena terlalu banyak yang harus dilakukan sebelum bisa membuat aplikasi
* Spring Boot menjadikan kompleksitas tersebut ditangani secara otomatis oleh Spring Boot, sehingga kita bisa membuat aplikasi 
* Spring Framework secara cepat tanpa harus melakukan pengaturan apapun
* Spring Boot sekarang sudah menjadi salah satu framework wajib ketika kita ingin membuat aplikasi Spring Framework

### Kenapa Menggunakan Spring?
* Tidak bisa dipungkiri, saat ini Spring adalah satu-satunya framework paling populer di Java
* Belum ada yang bisa menandingi popularitasnya di Java
* Saking populernya, bahkan banyak perusahaan pindah ke JVM karena ingin menggunakan Spring-nya, bukan Java
* Dengan banyaknya bahasa yang bisa berjalan di atas JVM, seperti Kotlin, Groovy dan Scala, maka secara programmer punya banyak pilihan bahasa pemrograman ketika menggunakan Spring 
* Spring juga sudah banyak sekali diadopsi di banyak perusahaan, baik itu skala besar atau kecil
 
### Ekosistem Pendukung
* Spring memiliki ekosistem pendukung yang sangat besar
* Spring sendiri tidaklah digunakan untuk menggantikan framework yang sudah ada, melainkan menjahit framework-framework yang sudah ada, menjadi framework yang saling terintegrasi
* Spring bisa digunakan terintegrasi dengan baik dengan Bean Validation, Java Persistence API, Servlet, dan lain-lain
* Selain itu juga Spring bisa diintegrasikan dengan teknologi yang tidak standar bawaan Java, seperti MongoDB, Consul, Vault, Cassandra, dan lain-lain

### Inversion of Control
* Inversion of Control (IoC) merupakan prinsip dalam pembuatan perangkat lunak, dimana kita melakukan pemindahan kontrol untuk objek atau program ke sebuah container di framework
* Tidak seperti biasanya ketika kita membuat aplikasi, dimana kita selalu melakukannya secara manual, dalam IoC, kita menyerahkan banyak pekerjakan ke container IoC 
* Container IoC memiliki kontrol untuk melakukan eksekusi program kita, memanajemen object pada program kita dan melakukan abstraction terhadap program kita
* Saat menggunakan framework IoC, kita biasanya akan mengikuti cara kerja framework tersebut
Spring Inversion of Control
* Spring bisa dibilang adalah framework IoC, dimana kita akan menyerahkan banyak sekali pekerjaan dalam program kita ke Spring
* * Kode program kita akan mengikuti cara kerja Spring

Application Context
* ApplicationContext adalah sebuah interface representasi container IoC di Spring
* ApplicationContext adalah inti dari Spring Framework
* ApplicationContext banyak sekali class implementasinya, secara garis besar dibagi menjadi 2 jenis implementasi, XML dan Annotation
* Pada versi Spring 3, XML masih menjadi pilihan utama, namun sekarang sudah banyak orang beralih dari XML ke Annotation, bahkan Spring Boot pun merekomendasikan menggunakan Annotation untuk membuat aplikasi Spring
* [https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/]ApplicationContext.html 
 
Configuration
* Untuk membuat ApplicationContext menggunakan Annotation, pertama kita bisa perlu membuat Configuration class
* Configuration Class adalah sebuah class yang terdapat annotation @Configuration pada class tersebut
  
      @Configuration
       public class HelloWorldConfiguration {
    
       }

Membuat Application Context
* Selanjutnya, setelah membuat Class Configuration, kita bisa menggunakan class AnnotationConfigApplicationContext untuk membuat Application Context
* [https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/AnnotationConfigApplicationContext.html] 
* Kode : Membuat Application Context
         
      ApplicatioContext context =
         new AnnotationConfigurationApplicationContext(HelloWorldConfiguration.class);
         
      Assertions.assertNotNull(context);
 
### Singleton
* Singleton adalah salah satu Design Patterns untuk pembuatan objek, dimana sebuah object hanya dibuat satu kali saja
* Dan ketika kita membutuhkan object tersebut, kita hanya akan menggunakan object yang sama * [https://refactoring.guru/design-patterns/singleto] 
Membuat Singleton di Java
* Ada banyak cara membuat singleton object di Java
* Cara yang paling sering digunakan adalah membuat class yang berisikan static method untuk membuat object dirinya sendiri
* Selanjutnya constructor nya dibuat private, agar tidak bisa diakses dari luar
* Sehingga user terpaksa menggunakan method static tersebut ketika ingin membuat object nya
* Kode : Singleton Class
        
        public class Database {
    
        private static Database database;
    
          public static Database getInstance(){
          if (database == null){
            database = new Database();
        }
        return database;
        }
    
        private Database(){
        //can not instantiate database class
       }
    
      }

### Bean
* Saat sebuah object kita masukkan kedalam Spring Container IoC, maka kita sebut object tersebut adalah Bean
* Secara default, bean merupakan singleton, artinya jika kita mengakses bean yang sama, maka dia akan mengembalikan object yang sama. Kita juga bisa mengubahnya jika tidak ingin singleton, nanti akan kita bahas di materi tersendiri

###Membuat Bean
* Untuk membuat bean, kita bisa membuat sebuah method di dalam class Configuration
* Selanjutnya nama method tersebut akan menjadi nama bean nya, dan return object nya menjadi object bean nya
* Method tersebut perlu kita tambahkan annotation @Bean, untuk menandakan bahwa itu adalah bean
* Secara otomatis Spring akan mengeksekusi method tersebut, dan return value nya akan dijadikan object bean secara otomatis, dan disimpan di container IoC
* Kode : Membuat Bean
       
      @Configuration
      public class BeanConfiguration {
    
      @Bean
      public Foo foo(){
       Fooo foo = new Fooo();
       return foo;
      }
 
### Mengakses Bean
* Setelah kita membuat bean, secara otomatis semua object akan di-manage oleh Application Context
* Untuk mengakses bean, kita bisa menggunakan method getBean milik Application Context
* Kode : Mengakses Bean

      Foo foo1 = applcationContext.getBean(Foo.class);
      Foo foo2 = applcationContext.getBean(Foo.class);
      
      Assertions.assertions(foo1, foo2);
 
--> getBean(Foo.class) : akan mengembalikan object yang sama, methodenya akan dieksekusi diawal

### Duplicate Bean
* Di Spring, kita bisa mendaftarkan beberapa bean dengan tipe yang sama 
* Namun perlu diperhatikan, jika kita membuat bean dengan tipe data yang sama, maka kita harus menggunakan nama bean yang berbeda
* Selain itu, saat kita mengakses bean nya, kita wajib menyebutkan nama bean nya, karena jika tidak, Spring akan bingung harus mengakses bean yang mana
* Kode Duplikat Bean :
       
         @Bean
      public Foo foo1(){
        Foo foo = new Foo();
        return foo ;
      }
    
      @Bean
      public Foo foo2(){
         Foo foo = new Foo();
        return foo();
       }
      }

 ### Primary Bean
* Jika terjadi duplicate bean, selain kita sebutkan nama bean nya ketika ingin mengakses bean nya, kita juga bisa pilih salah satu bean menjadi primary 
* Dengan memilih salah satunya menjadi primary, secara otomatis jika kita mengakses bean tanpa menyebutkan nama bean nya, secara otomatis primary nya yang akan dipilih 
* Untuk memilih primary bean, kita bisa tambahkan annotaiton @Primary
* kode Primary bean :
 
      @Primary
      @Bean
      public Foo foo1(){
        Foo foo= new Foo();
        return foo;
      }
    
      @Bean
      public Foo foo2(){
        Foo foo= new Foo();
        return foo;
       }
      }
      
 * Kode mengakses primary bean :
    
       Foo foo = applicationContext.getBean(Foo.class); 
       Foo foo1 = applicationContext.getBean(name: "foo1", Foo.class); 
       Foo foo2 = applicationContext.getBean(name: "foo2", Foo.class);
 
       Assertions.assertSame(foo, foo1); 
       Assertions.assertNotSame(foo1, foo2);
      
  ### Mengubah Nama Bean
* Secara default, nama bean diambil dari nama method 
* Namun kadang-kadang kita tidak ingin menggunakan nama method untuk nama bean 
* Saat project kita sudah besar, kadang bisa jadi nama method sama, walaupun isi bean nya berbeda, dan di Spring, nama bean itu unik, tidak boleh sama 
* Jika kita ingin mengubah nama bean, kita bisa menggunakan method value() milik annotation @Bean


### Referensi : Link Video Youtube
(TUTORIAL SPRING BOOT DASAR)
[https://www.youtube.com/watch?v=VM3rwdMBORY]
