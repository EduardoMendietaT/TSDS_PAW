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