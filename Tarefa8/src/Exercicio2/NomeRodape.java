package Exercicio2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NomeRodape extends JFrame {

    // Passo 3: Declaração dos componentes ativos (Sem botão agora!)
    private JTextField campoNome;
    private JTextField campoSobrenome;
    private JLabel rodape;

    // Passo 4: Implementação do construtor
    public NomeRodape() {
        // Configurações básicas da janela
        setTitle("App de Concatenação em Tempo Real");
        setSize(400, 150); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        setLayout(new BorderLayout());

        // Inicializando os componentes
        campoNome = new JTextField();
        campoSobrenome = new JTextField();
        rodape = new JLabel("Nome Completo: ");
        
        rodape.setHorizontalAlignment(SwingConstants.CENTER); 
        rodape.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 

        // Usando GridLayout (2 linhas, 2 colunas) para organizar os campos e seus rótulos
        JPanel painelTopo = new JPanel(new GridLayout(2, 2, 5, 5));
        painelTopo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margem
        
        painelTopo.add(new JLabel("Nome:"));
        painelTopo.add(campoNome);
        painelTopo.add(new JLabel("Sobrenome:"));
        painelTopo.add(campoSobrenome);

        // Adicionando os elementos na Janela Principal
        add(painelTopo, BorderLayout.NORTH); 
        add(rodape, BorderLayout.SOUTH);     

        // Passo 5: Criando O MESMO KeyAdapter para os dois campos
        KeyAdapter digitacaoAdapter = new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                // Toda vez que uma tecla for solta (em qualquer um dos campos),
                // ele pega o texto dos dois e atualiza o rodapé na hora.
                String nome = campoNome.getText();
                String sobrenome = campoSobrenome.getText();
                rodape.setText("Nome Completo: " + nome + " " + sobrenome);
            }
        };
        
        // Pendurando o ouvinte nos dois campos de texto
        campoNome.addKeyListener(digitacaoAdapter);
        campoSobrenome.addKeyListener(digitacaoAdapter);
    }

    // Passo 6: Início da aplicação GUI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                NomeRodape tela = new NomeRodape();
                tela.setVisible(true);
            }
        });
    }
}