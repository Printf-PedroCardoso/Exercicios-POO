package Main.Aula06.Ex04;

public class Main {
    public static void main(String[] args) {

        Veiculo[] meusVeiculos = new Veiculo[3];

        // Instanciamos os objetos concretos
        meusVeiculos[0] = new Carro();
        meusVeiculos[1] = new Moto();
        meusVeiculos[2] = new Bicicleta();

        for (Veiculo v : meusVeiculos)
        {
            v.mover();
        }

    }
}
