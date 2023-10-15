package q4_MariaNascimento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MultiMatriz {

    public static void main(String[] args) {
        try {
        	
        	//Escreva o caminho do txt dos arquivos
            int[][] matrizA = lerMatriz(""); 
            int[][] matrizB = lerMatriz("");

            // Verifica se as matrizes podem ser multiplicadas
            if (matrizA[0].length != matrizB.length) {
                System.out.println("As matrizes não podem ser multiplicadas. O número de colunas da matriz A deve ser igual ao número de linhas da matriz B.");
                return;
            }

            // Realiza a multiplicação das matrizes
            int[][] resultado = multiplicarMatrizes(matrizA, matrizB);

            // Exibe o resultado da multiplicação
            exibirMatriz(resultado);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[][] lerMatriz(String arquivo) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(arquivo));

        // Lê as dimensões da matriz
        String[] dimensoes = reader.readLine().split(" ");
        int linhas = Integer.parseInt(dimensoes[0]);
        int colunas = Integer.parseInt(dimensoes[1]);

        int[][] matriz = new int[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            String[] valores = reader.readLine().split(" ");
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = Integer.parseInt(valores[j]);
            }
        }

        reader.close();
        return matriz;
    }

    public static int[][] multiplicarMatrizes(int[][] matrizA, int[][] matrizB) {
        int linhasA = matrizA.length;
        int colunasA = matrizA[0].length;
        int colunasB = matrizB[0].length;

        int[][] resultado = new int[linhasA][colunasB];

        for (int i = 0; i < linhasA; i++) {
            for (int j = 0; j < colunasB; j++) {
                for (int k = 0; k < colunasA; k++) {
                    resultado[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }

        return resultado;
    }

    public static void exibirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}

