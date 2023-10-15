package q5_MariaNascimento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class JogoAdivinha {

    private JFrame frame;
    private JButton[] botoes;
    private JTextField tentativaField;
    private int numeroEscolhido;
    private int tentativas;

    public JogoAdivinha() {
        frame = new JFrame("Jogo de Adivinhação");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 4));

        tentativaField = new JTextField("Tentativa: 1");
        tentativaField.setEditable(false);
        frame.add(tentativaField);

        botoes = new JButton[20];
        for (int i = 0; i < 20; i++) {
            botoes[i] = new JButton(Integer.toString(i + 1));
            int numero = i + 1;
            botoes[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tentativaClicada(numero);
                }
            });
            frame.add(botoes[i]);
        }

        frame.pack();
        frame.setVisible(true);

        iniciarJogo();
    }

    private void iniciarJogo() {
        numeroEscolhido = new Random().nextInt(20) + 1;
        tentativas = 0;
    }

    private void tentativaClicada(int tentativa) {
        tentativas++;
        tentativaField.setText("Tentativa: " + tentativas);

        if (tentativa == numeroEscolhido) {
            JOptionPane.showMessageDialog(frame, "Parabéns! Você acertou o número " + numeroEscolhido);
            iniciarJogo();
        } else {
            if (tentativas < 5) {
                JOptionPane.showMessageDialog(frame, "Tente novamente. Você errou.");
            } else {
                JOptionPane.showMessageDialog(frame, "Suas 5 tentativas acabaram. O número era " + numeroEscolhido);
                iniciarJogo();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JogoAdivinha();
            }
        });
    }
}

