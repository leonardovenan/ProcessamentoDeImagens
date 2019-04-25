/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leonardo
 */
public class Dithering {
    private final Imagem img;
    private final int alt;
    private final int larg;
    public Dithering(Imagem in){
        img = in;
        alt = in.getAltura();
        larg = in.getLargura();
    }
    
    public Imagem limiarSimples(int limiar){
        Imagem out = new Imagem(alt, larg, Imagem.GRAY);
        int cor;
        
        for(int y=0; y < alt; y++){
            for(int x = 0; x <larg; x++){
                cor = img.getPixel(y, x, 0);
                if(cor<limiar){
                    out.setPixel(y, x, 0, 0, 0);
                }
                else{
                    out.setPixel(y, x, 255, 255, 255);
                }
            }
        }
        return out;
    }
    
    public Imagem limiarAleatorio(int limiar, int delta){ // 2*delta*x-delta = y
        Imagem out = new Imagem(alt, larg, Imagem.GRAY);
        int cor, valor = (int)(2*delta*Math.random()-delta);        
        for(int y=0; y < alt; y++){
            for(int x = 0; x <larg; x++){
                cor = img.getPixel(y, x, 0);
                if(cor + valor < limiar){
                    out.setPixel(y, x, 0, 0, 0);
                }
                else{
                    out.setPixel(y, x, 255, 255, 255);
                }
            }
        }
        return out;
    }
    
}
