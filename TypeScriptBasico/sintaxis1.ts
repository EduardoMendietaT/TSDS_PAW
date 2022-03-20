/* 1.HOLA MUNDO: ----------------------------------------------- */
console.log('Hola mundo desde Typescript!')

/* 2. TIPOS DE DATOS: ----------------------------------------------- */
// Typescript tiene inferencia de tipos, asigna el tipo de dato en base al valor inical de la variable.
let cadena: string = 'Cadena'
let decimal: number = 3.5
let entero: number = 3
let booleano: boolean = true

let lista: number[] = [1,2,3]
let lista2: Array<number> = [4,5,6]
let lista3: any[] = [1,true,'Perro']//Lo ideal es trabajar con este tipo solo cuando no se sepa el tipo de dato.

let tupla: [string, number, boolean] = ['Juanito', 18, true]
let tupla2: [number, string][] = [[1, 'Jose'], [2, 'Pepito'], [3, 'Juaquinacho']]

/* 3. UNION TYPES: ----------------------------------------------- */
// Podemos declarar que una variable pueda ser de 2 o más tipos.
let variable: string | number | null 
variable = 'Perro'
variable = 2
variable = null

/* 4.ENUMS: ----------------------------------------------- */
// Permiten definir un conjunto de constantes con nombre.
// Pueden ser numericos o de cadenas de texto.
enum Roles{
    User = 'USER',
    Admin = 'ADMIN',
    Superadmin = 'SUPER_ADMIN'
}
console.log(`ENUMS: ${Roles.User}, ${Roles.Admin}, ${Roles.Superadmin}.`)

/* 5.OBJECTS: ----------------------------------------------- */
const usuario = {
    nombre: 'Juanito',
    edad: 35,
    activo: true
}
console.log(`Usuario: nombre -> ${usuario.nombre}, edad -> ${usuario.edad}, ¿Está activo? -> ${usuario.activo}.`)

/* 6.TYPE ASSERTION: ----------------------------------------------- */
// Casting de tipos.
let channel: any = 'Code'

let channelStr = <string>channel //Forma 1.
let channelStr2 = channel as string //Forma 2.
const htmlTag = document.getElementById('main') as HTMLCanvasElement //Forma 3
const htmlTag2 = <HTMLCanvasElement>document.getElementById('main') //Forma 4

/* 7.FUNCIONES ----------------------------------------------- */
function greet(name: string){
    console.log(`Hola ${name}.`)
}
greet('Eduardo')

function getNumber(){
    return Math.floor(Math.random() * 100)
}
console.log(getNumber())

function getNumber2(): number {
    return Math.floor(Math.random() * 100)
}

function printPosition(position: {lat:number, long: number}): void {
    console.log(`Latitude & position are: LAT: ${position.lat}, LONG: ${position.long}.`)
}

const arrowFunction = () => 'Hola mundo!'

const arrowFunction2 = (num1: number, num2: number) => {
    let resultado = num1 + num2
    return resultado
}