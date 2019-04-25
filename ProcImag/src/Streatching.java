/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leonardo
 */

public class Streatching {
    private final Imagem img;
    private final int alt;
    private final int larg;
    public Streatching(Imagem in){
        img = in;
        alt = img.getAltura();
        larg = img.getLargura();        
    }
    
    public Imagem linear(float a, float b){
        Imagem out = new Imagem(alt, larg, Imagem.GRAY);
        int cor;
        
        for(int y=0; y < alt; y++){
            for(int x = 0; x <larg; x++){
                cor = img.getPixel(y, x, 0);
                out.setPixel(y, x, (int)(a*cor+b), (int)(a*cor+b), (int)(a*cor+b));
            }
        }
        return out;
    }
}
