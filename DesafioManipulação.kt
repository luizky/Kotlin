import java.text.DecimalFormat

fun main(args: Array<String>) {


    var nomeProduto: String = "Teclado"
    var precoUnitario: Int = 350
    var quantidadeCompra: Int = 7
    var imposto: Double = 25.0
    var margemLucroDesejada: Double = 75.0

    val df = DecimalFormat("#,###.00")

    println()

    var valorTotalSemImposto = precoUnitario * quantidadeCompra
    var valorTocalComImposto = valorTotalSemImposto + (valorTotalSemImposto * (imposto / 100))

    val precoSugeridoLucro = precoUnitario + (precoUnitario * (margemLucroDesejada / 100))

    println("Produto: $nomeProduto")
    println("Preço unitário $precoUnitario")
    println("Quantidade de Compra: $quantidadeCompra")
    println("Impostos: $imposto %")
    println("Lucro desejado: $margemLucroDesejada %")
    println("O valor do produdo sem imposto será de: $valorTotalSemImposto e o valor com impostos será de: $valorTocalComImposto")
    println("Preço final: ${df.format(precoSugeridoLucro)}")




}
