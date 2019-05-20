
import java.awt.Color;

/**
 *
 * @author Leonardo
 */

//Operadores aritmétidcos

public class Processador {
    
    public static Imagem soma(Imagem imagem1, Imagem imagem2){
        int altura = imagem1.getAltura();
        int largura = imagem1.getLargura();
        Imagem newImagem = new Imagem(altura, largura, Imagem.GRAY);
        
        int soma;
        
        for(int x = 0; x < largura; x++){
            for(int y = 0; y < altura; y++){
                soma = imagem1.getPixel(y, x, 0) + imagem2.getPixel(y, x, 0);
                
                if(soma > 255){
                    newImagem.setPixel(y, x, 255, 255, 255);
                }
                else{
                    newImagem.setPixel(y, x, soma, soma, soma);
                }
            }
        }
        
        return newImagem;
    }
    
    public Imagem subt(Imagem imagem1, Imagem imagem2){
        int altura = imagem1.getAltura();
        int largura = imagem1.getLargura();
        Imagem newImagem = new Imagem(altura, largura, Imagem.GRAY);
        
        int sub;
        
        for(int x = 0; x < largura; x++){
            for(int y = 0; y < altura; y++){
                sub = imagem1.getPixel(y, x, 0) - imagem2.getPixel(y, x, 0);
                
                if(sub < 0){
                    newImagem.setPixel(y, x, 0, 0, 0);
                }
                else{
                    newImagem.setPixel(y, x, sub, sub, sub);
                }
            }
        }
        
        return newImagem;
    }
    
//    public static Imagem mediaImagem(Imagens[]){
//        
//    }
    
    
    //operadores binários
    
    
    public Imagem not(Imagem imagem){
        int altura = imagem.getAltura();
        int largura = imagem.getLargura();
        Imagem newImagem = new Imagem(altura, largura, Imagem.GRAY);
        
        int resultado;
        
        for(int x = 0; x < largura; x++){
            for(int y = 0; y < altura; y++){
                if(imagem.getPixel(y, x, 0) < 128){
                    newImagem.setPixel(y, x, 255, 255, 255);
                }
                else
                    newImagem.setPixel(y, x, 0, 0, 0);
            }
        }
        
        return newImagem;
    }
    
    public static Imagem operadorAnd(Imagem imagem1, Imagem imagem2){
        int altura = imagem1.getAltura();
        int largura = imagem1.getLargura();
        Imagem newImagem = new Imagem(altura, largura, Imagem.GRAY);
        
        int resultado;
        
        for(int x = 0; x < largura; x++){
            for(int y = 0; y < altura; y++){
                if(imagem1.getPixel(y, x, 0) > 128 && imagem2.getPixel(y, x, 0) > 128){
                    newImagem.setPixel(y, x, 255, 255, 255);
                }
                else{
                    newImagem.setPixel(y, x, 0, 0, 0);
                }
            }        
        }
        return newImagem;
    }
    
    public static Imagem operadorOr(Imagem imagem1, Imagem imagem2){
        int altura = imagem1.getAltura();
        int largura = imagem1.getLargura();
        Imagem newImagem = new Imagem(altura, largura, Imagem.GRAY);
        
        int resultado;
        
        for(int x = 0; x < largura; x++){
            for(int y = 0; y < altura; y++){
                if(imagem1.getPixel(y, x, 0) > 128 || imagem2.getPixel(y, x, 0) > 128){
                    newImagem.setPixel(y, x, 255, 255, 255);
                }
                else{
                    newImagem.setPixel(y, x, 0, 0, 0);
                }
            }        
        }
        return newImagem;
    }
    
    public Imagem operadorXor(Imagem imagem1, Imagem imagem2){
        Imagem xor = (operadorOr(operadorAnd(imagem1,not(imagem2)),operadorAnd(not(imagem1),imagem2)));
        
        return xor;
    }
    
    public Imagem operadorSub(Imagem imagem1, Imagem imagem2){
        Imagem sub = (operadorAnd(imagem1, not(imagem2)));
        
        return sub;
    }
    
    
    // Quantização
    
    public static Imagem quantizacao(Imagem imagem, int i){
        int altura = imagem.getAltura();
        int largura = imagem.getLargura();
        
        Imagem newImagem = new Imagem(altura, largura, Imagem.GRAY);
        
        int resultado;
        
        for(int x = 0; x < largura; x++){
            for(int y = 0; y < altura; y++){
                resultado = (int)((((float)imagem.getPixel(y, x, 0)*(i-1))/255)+0.5);
                resultado = ((int)((float)resultado*255)/(i-1));
                
                newImagem.setPixel(y, x, resultado, resultado, resultado);
                
            }
        }
        return newImagem;
    }
    
    // operação de equalização de histograma feito em aula
    
      public static Imagem equalizar(Imagem img) {
        int alt = img.getAltura();
        int larg = img.getLargura();
        int hist[] = new int[256];
        int v;
        int t[] = new int[256];
        Imagem c = new Imagem(alt, larg, Imagem.RGB);

        //CÁLCULO DO HISTOGRAMA
        for (int y = 0; y < alt; y++) {
            for (int x = 0; x < larg; x++) {
                v = img.getPixel(y, x, 0);
                hist[v]++;
            }
        }

        //CÁLCULO DO HISTOGRAMA ACUMULADO
        for (int p = 1; p < 256; p++) {
            hist[p] = hist[p - 1] + hist[p];
        }

        float g1mn = 256.0f / (float) (alt * larg);

        for (int p = 0; p < 256; p++) {
            t[p] = (int) (g1mn * hist[p]);
        }

        for (int y = 0; y < alt; y++) {
            for (int x = 0; x < larg; x++) {
                v = img.getPixel(y, x, 0);
                c.setPixel(y, x, t[v], t[v], t[v]);
            }
        }

        return c;

    }

    //Filtro feito passa baixa 
      
    public Imagem filtroDaMedia(Imagem img, int[][] peso) {
        int alt = img.getAltura();
        int larg = img.getLargura();
        int raio = (peso.length - 1) / 2, somaWP, somaW = 0;
        Imagem c = new Imagem(alt, larg, Imagem.RGB);
        
        for (int i = 0; i < peso.length; i++) {
            for (int j = 0; j < peso[0].length; j++) {
                somaW += peso[i][j]; 
            }
        }
        //PERCORRER A IMAGEM (retirando a borda)
        for (int y = raio; y < alt-raio; y++) {
            for (int x = raio; x < larg-raio; x++) {
                somaWP = 0;
                //PERCORRER A JANELA
                for (int i = -raio; i <= raio; i++) {
                    for (int j = -raio; j <= raio; j++) {
                        somaWP += img.getPixel(y+i, x+j, 0)*peso[raio+i][raio+j];
                    }
                }
                c.setPixel(y, x, somaWP/somaW, somaWP/somaW, somaWP/somaW);
            }
        }        
        return c;
    }
    
    //filtro passa alta
    
    public static Imagem filtroPassaAlta(Imagem img, int[][] peso) {
        int alt = img.getAltura();
        int larg = img.getLargura();
        int raio = (peso.length - 1) / 2, somaWP;
        Imagem c = new Imagem(alt, larg, Imagem.RGB);
        
        //PERCORRER A IMAGEM (retirando a borda)
        for (int y = raio; y < alt-raio; y++) {
            for (int x = raio; x < larg-raio; x++) {
                somaWP = 0;
                //PERCORRER A JANELA
                for (int i = -raio; i <= raio; i++) {
                    for (int j = -raio; j <= raio; j++) {
                        somaWP += img.getPixel(y+i, x+j, 0)*peso[raio+i][raio+j];
                    }
                }
                c.setPixel(y, x, somaWP/(peso.length*peso[0].length), somaWP/(peso.length*peso[0].length), somaWP/(peso.length*peso[0].length));
            }
        }        
        return c;
    }

}
