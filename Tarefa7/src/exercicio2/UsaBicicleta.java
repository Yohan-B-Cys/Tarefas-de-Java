package exercicio2;

public class UsaBicicleta {
    public static void main(String[] args) {
        
        Bicicleta minhaBike = null;
        
        // Agora a própria criação da bicicleta está protegida contra valores absurdos!
        try {
            minhaBike = new Bicicleta(60, 15, 3);
        } catch (Exception e) {
            System.out.println("Erro crítico ao fabricar a bicicleta: " + e.getMessage());
            return; // Encerra o programa se a bicicleta nascer quebrada
        }
        
        System.out.println("========= ESTADO INICIAL =========");
        minhaBike.printStates();
        System.out.println("==================================\n");

        // --- TESTE 1: Mudar Cadência ---
        try {
            System.out.println("[TESTE 1] Tentando mudar cadência para -5...");
            minhaBike.mudarCadencia(-5); 
        } catch (RPMInvalidoException e) {
            System.out.println("-> Catch Ativado: " + e.getMessage());
        }

        // --- TESTE 2: Mudar Marcha ---
        try {
            System.out.println("\n[TESTE 2] Tentando mudar marcha para 28...");
            minhaBike.mudarMarcha(28);
        } catch (MarchaInvalidaException e) {
            System.out.println("-> Catch Ativado: " + e.getMessage());
        }

        // --- TESTE 3: Aumentar Velocidade ---
        try {
            System.out.println("\n[TESTE 3] Tentando aumentar velocidade em 120...");
            minhaBike.aumentarVelocidade(120);
        } catch (VelocidadeInvalidaException e) {
            System.out.println("-> Catch Ativado: " + e.getMessage());
        }
        
        // --- TESTE 4: Frear Negativo ---
        try {
            System.out.println("\n[TESTE 4] Tentando frear com força maior que a velocidade atual...");
            // A velocidade inicial é 15, vamos tentar reduzir 50
            minhaBike.aplicarFreios(50);
        } catch (VelocidadeInvalidaException e) {
            System.out.println("-> Catch Ativado: " + e.getMessage());
        }

        System.out.println("\n========= ESTADO FINAL =========");
        minhaBike.printStates();
        System.out.println("=================================");
    }
}