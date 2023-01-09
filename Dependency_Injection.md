### Dependency Injection
* Saat kita membuat object, sudah pasti kita sering membuat object yang tergantung dengan object lain 
* Dependency Injection (DI) adalah teknik dimana kita bisa mengotomatisasi proses pembuatan object yang tergantung dengan object lain, atau kita sebut dependencies 
* Dependencies akan secara otomatis di-inject (dimasukkan) kedalam object yang membutuhkannya 
* Spring Framework sejak awal dibilang sebuah framework IoC yang memang cara kerjanya menggunakan Dependency Injection

Tanpa Dependency Injection
* Sebenarnya tanpa dependency injection pun kita tetap bisa membuat aplikasi
* Namun ketika relasi antar dependencies sangat kompleks, agak ribet untuk kita melakukannya jika harus manual
* oleh karena itu, penggunaan dependency injection framework seperti spiring sangat membantu sekali
* Kode : ClassFooBar

      @AllArgsConstructor
      @Data
      public class FooBar {

      private Foo foo;

      private Bar bar;

      }
      
 * Kode : Tanpa dependency injection
       
       var foo = new Foo(); 
       var bar = new Bar();

       var fooBar = new FooBar(foo, bar);
