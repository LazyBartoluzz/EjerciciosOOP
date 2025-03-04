import java.util.ArrayList

class Libro {

    var titulo:String;
    var autor:String;
    var ISBN : String;
    var precio : Int;
    var numeroPaginas : Int;

    val stockMaximo=20;
    var cantidadDisponible : Int = stockMaximo;

    constructor(titulo: String, autor: String, ISBN: String, precio : Int, numeroPaginas : Int){
        this.titulo = titulo
        this.autor = autor
        this.ISBN = ISBN
        this.precio = precio;
        this.numeroPaginas = numeroPaginas;
    }

    fun prestar() : Boolean{
        var bandDevolucion:Boolean;
        if ( (this.cantidadDisponible-1) >= 0 ) {
            println("No se olvide de devolver el libro");
            this.cantidadDisponible--;
            bandDevolucion = true;
        }else{
            println("El libro identificado titulado $titulo con ISBN $ISBN ya no tiene existencias");
            bandDevolucion =false;
        }
        return bandDevolucion;
    }

    fun devolver() {
        if ( (this.cantidadDisponible+1) <= this.stockMaximo ) {

            println("Gracias por devolverlo");
            this.cantidadDisponible++;
        }else{
            println("No se puede devolver un libro que no se ha prestado");
        }
    }

    override fun toString(): String {
        return "Libro(titulo='$titulo', autor='$autor', ISBN='$ISBN', precio=$precio, numeroPaginas=$numeroPaginas, cantidadDisponible=$cantidadDisponible)"
    }
}

fun main() {

    println("\t\t\tEJERCICIO DE LOS LIBROS");

    var opcionEscogida : String;

    val libro1 = Libro("Don Quijote","Quesada","67357647",120000, 1209);
    val libro2 = Libro("Pandemoniun","Lauren Oliver","7476465", 42000, 380);
    val libro3 = Libro("Tom Sawyer","X","4324234", 22000, 196);
    val libro4 = Libro("Crepusculo","Y","673577647", 42000, 400);

    val listadoDeLibros : MutableList<Libro> = mutableListOf( libro1,libro2,libro3,libro4 );
    var libroSeleccionado : Libro;

    libroSeleccionado=libro1;
    while ( true ) {

        println("""
        /*    
        Ingrese el ISBN del libro que quiera modificar o editar
        
        """.trimIndent());

        for ( libro in listadoDeLibros) {
            println("titulo=${libro.titulo}, ISBN=${libro.ISBN}");
        }
        println("""
        
            Si quiere ver toda la informacion de los libros ingrese \"y\"
            Para salir ingrese \"x\"
            
        """.trimIndent());

        opcionEscogida = readln();
        if( opcionEscogida != "x" && opcionEscogida != "y" ) {

            for ( libro in listadoDeLibros) {
                if ( libro.ISBN == opcionEscogida ){
                    libroSeleccionado = libro;
                    break;
                }
            }
            println("""
                /**            
                Seleccione lo que desee cambiar:
                
                1. titulo: ${ libroSeleccionado.titulo }
                2. autor: ${ libroSeleccionado.autor }
                3. ISBN:  ${ libroSeleccionado.ISBN }
                4. precio: ${ libroSeleccionado.precio }
                5. numeroPaginas: ${ libroSeleccionado.numeroPaginas }
    
            """.trimIndent());

            opcionEscogida = readln();
            print("Ingrese ")
            when (opcionEscogida) {

                "1" -> {
                    print("titulo=> ");
                    libroSeleccionado.titulo = readln()
                };
                "2" -> {
                    print("autor=> ");
                    libroSeleccionado.autor = readln()
                };
                "3" -> {
                    print("ISBN=> ");
                    libroSeleccionado.ISBN = readln()
                };
                "4" -> {
                    print("precio=> ");
                    libroSeleccionado.precio = readln().toInt()
                };
                else -> {
                    print("# páginas=> ");
                    libroSeleccionado.numeroPaginas = readln().toInt()
                };
            }
            println("""
                Cambios guardados!!!
                
            """.trimIndent());
            println(".:INFORMACIÓN DEL LIBRO:.");
            println( "$libroSeleccionado\n");
        }
        if(opcionEscogida == "x"){
            break;
        }
        if(opcionEscogida == "y"){
            for (libro in listadoDeLibros) {

                println(libro);
            }
        }
        println("_________________________________");
    }
}




