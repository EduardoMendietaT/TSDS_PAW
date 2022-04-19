/* 11. GENERICOS: ---------------------------------------------------------- */
// Código reutilizable que funciona con multiples tipos.
// Pueden se funciones, interfaces o clases.
interface Person {
    id: number
    name: string
}

interface Product {
    id: number
    name: string
    price: number
}

class People {
    private items: Person[] = []

    addItems(newItem: Person): void {
        this.items.push(newItem)
    }

    getItems(): void {
        console.log(`List of items`, JSON.stringify(this.items))
    }

    getNames(): string[] {
        return this.items.map((item) => item.name)
    }

    getItemById(id: number): Person | undefined {
        return this.items.find((item) => item.id === id)
    }
}

const personCollection = new People()
const newData = {
    id: 1,
    name: 'Eduardo'
}
const newData2 = {
    id: 2,
    name: 'Chetin'
}
personCollection.addItems(newData)
personCollection.addItems(newData2)
personCollection.getItems()

/*Trabajando con union de tipos ***********************************/
type dataType = Person | Product

class DataCollection {
    private items: dataType[] = []

    addItems(newItem: dataType): void {
        this.items.push(newItem)
    }

    getItems(): void {
        console.log(`List of items`, JSON.stringify(this.items))
    }

    getNames(): string[] {
        return this.items.map((item) => item.name)
    }

    getItemById(id: number): dataType | undefined {
        return this.items.find((item: dataType) => item.id === id)
    }
}

/*Trabajando con genericos ***********************************/
interface Employee extends Person{
    role: string
}

class GenericDataCollection < T extends {id: number, name: string} >  {
    /*Podemos recibir diferentes tipos: ejm --> <T, V, W> */
    /*Para resolver problema de puede extender con union: ejem --> < T extends (Product | Employee )>  */
    /*Para resolver problema(Solucion optima) se puede extender propiedades: ejem --> < T extends {id: number, name: string} >  */
    private items: T[] = []

    addItems(newItem: T): void {
        this.items.push(newItem)
    }

    getItems(): void {
        console.log(`List of items`, JSON.stringify(this.items))
    }

    getNames(): string[] {
        return this.items.map((item) => item.name)
    }

    getItemById(id: number): T | undefined {
        return this.items.find((item: T) => item.id === id)
    }
}
const productCollection = new GenericDataCollection<Product>()

interface Data<T> {
    addItem(newItem: T) : void
}

class GenericData <T> implements Data<T> {
    // Me obliga a implementar el método de la interface.
    addItem(newItem: T) : void {
        //code
    }
}