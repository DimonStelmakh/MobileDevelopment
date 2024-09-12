fun main() {
    val H = 1.5
    val C = 76.4
    val S = 1.7
    val N = 0.8
    val O = 1.3
    val W = 5.0
    val A = 13.3

    val dryFactor = 1 - W / 100
    val C_dryMass = C / dryFactor
    val H_dryMass = H / dryFactor
    val S_dryMass = S / dryFactor
    val N_dryMass = N / dryFactor
    val O_dryMass = O / dryFactor
    val A_dryMass = A / dryFactor

    val combustibleFactor = 1 - A_dryMass / 100
    val C_combustibleMass = C_dryMass / combustibleFactor
    val H_combustibleMass = H_dryMass / combustibleFactor
    val S_combustibleMass = S_dryMass / combustibleFactor
    val N_combustibleMass = N_dryMass / combustibleFactor
    val O_combustibleMass = O_dryMass / combustibleFactor

    val lowerHeatingValue = 338 * C + 1442 * (H - O / 8) + 94 * S

    // Виведення результатів
    println("Склад сухої маси:")
    println("C: %.2f%%".format(C_dryMass))
    println("H: %.2f%%".format(H_dryMass))
    println("S: %.2f%%".format(S_dryMass))
    println("N: %.2f%%".format(N_dryMass))
    println("O: %.2f%%".format(O_dryMass))
    println("A: %.2f%%".format(A_dryMass))

    println("\nСклад горючої маси:")
    println("C: %.2f%%".format(C_combustibleMass))
    println("H: %.2f%%".format(H_combustibleMass))
    println("S: %.2f%%".format(S_combustibleMass))
    println("N: %.2f%%".format(N_combustibleMass))
    println("O: %.2f%%".format(O_combustibleMass))

    println("\nНижча теплота згоряння: %.2f кДж/кг".format(lowerHeatingValue))
}