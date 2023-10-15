package q3_MariaNascimento;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AjusteBrilho {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o caminho da imagem de entrada: ");
        String caminhoImagemEntrada = scanner.nextLine();

        System.out.print("Digite o caminho para salvar a imagem ajustada: ");
        String caminhoImagemSaida = scanner.nextLine();

        System.out.print("Digite o fator de ajuste de brilho (-255 a 255): ");
        int fatorBrilho = scanner.nextInt();

        try {
            BufferedImage imagem = ImageIO.read(new File(caminhoImagemEntrada));
            ajustarBrilho(imagem, fatorBrilho);
            ImageIO.write(imagem, "jpg", new File(caminhoImagemSaida));
            System.out.println("Imagem ajustada e salva com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void ajustarBrilho(BufferedImage imagem, int fatorBrilho) {
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();

        for (int x = 0; x < largura; x++) {
            for (int y = 0; y < altura; y++) {
                int cor = imagem.getRGB(x, y);
                int r = (cor >> 16) & 0xFF;
                int g = (cor >> 8) & 0xFF;
                int b = cor & 0xFF;

                r = Math.min(255, Math.max(0, r + fatorBrilho));
                g = Math.min(255, Math.max(0, g + fatorBrilho));
                b = Math.min(255, Math.max(0, b + fatorBrilho));

                cor = (r << 16) | (g << 8) | b;
                imagem.setRGB(x, y, cor);
            }
        }
    }
}