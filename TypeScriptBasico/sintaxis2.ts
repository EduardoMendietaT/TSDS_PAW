/* 8. INTERFACES: ---------------------------------------------------------- */
// Es un contrato, una especie de molde.
// Solo existen en tiempo de compilación.
// Solo se usan para la verficacion de tipos.
// Es recomendeble trabajar con interfaces a menos que se nececite inicializar métodos.
// Pueden heredar de otras interfaces con la palabra reservada 'extends'.
// Las clases implementan de las interfaces con 'implements'.
interface Book {
    id: number
    title: string
    author: string
    coAuthor? : string //Propiedad opcional.
    greet?: (message: string) => void //Método opcional.
}

const book: Book = {
    id: 1,
    title: 'Título',
    author: 'Eduardo',
    greet: (message: string) => {
       console.log(message)
    }
}

const books: Book[] = []

/* 9. CLASES: ---------------------------------------------------------- */
// Existen en tiempo de compilación y tambien de ejecución.
// Se pueden extender con 'extends' y las propiedades del constructor con super().
class Employee{

    private id: number
    public name: string
    protected dept: string
    nick? : string //Por defecto es público.

    // Solo se puede tener un constructor.
    constructor(name: string) {
        this.showInfo()
    }

    showInfo = (): void => {
        console.log(`Nombre: ${this.name}`)
    }

    sayHi(): string {
        return 'Hola prro!'
    }
}

class Cliente {
    // Propiedades automaticas, crea e inicializa las variables globales.
    // readonly: no permite modificar la propiedad.
    constructor(private readonly id: string, private nombre: string, 
        private edad: number){
    }
}

const emp = new Employee('Pepito') 

/* 10. MÓDULOS: ---------------------------------------------------------- */
// Se puede exportar métodos, clases, propiedades, utilizando la palabra 'export'.
export const PI = 3.14
export const getMessage = () => 'Hola prro'
export class Person {}

// Podemos exportar varias propiedades a la ves:
let nombre = 'Pepito'
function setMessage2(message: string) {}
class Cuenta {}
export{nombre, setMessage2, Cuenta}

//Para importar
//import {variable, metodo, Clase} from 'ruta'
//import {variable as miVarible} from 'ruta'

//import * as myCode from 'ruta' 
// myCode.variable