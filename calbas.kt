fun main(args: Array<String>) {

    var nome: String = "Luiz"
    var idade: Int = 22
    var salario: Double = 2400.50
    var meses: Int = 7
    var produtos: Int = 12

    var salAnual= salario*meses
    var salAnualliquido= salAnual-400

    println()

    println("Olá $nome, seu salário será: $salAnualliquido! Esperamos que consiga economizar e comprar seu carro dos sonhos (mesmo que demora 30 anos =D)")

    println()
    println()

    println("Dados registrados:")
    println("Nome: $nome")
    println("Idade: $idade")
    println("Salario: $salario")
    println("Meses trabalhados: $meses")
    println("Produtos vendidos: $produtos")
    println("Salario anual: $salAnual")
    println("Salario anual liquidos: $salAnualliquido")



}
