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
                if((int)(a*cor+b)>255){
                    out.setPixel(y, x, 255, 255, 255);
                }
                else{
                    out.setPixel(y, x, (int)(a*cor+b), (int)(a*cor+b), (int)(a*cor+b));
                }                
            }
        }
        return out;
    }
    
    public Imagem quadradoRaiz(float a){
        Imagem out = new Imagem(alt, larg, Imagem.GRAY);
        int cor;
        
        for(int y=0; y < alt; y++){
            for(int x = 0; x < larg; x++){
                cor = img.getPixel(y, x, 0);
                if(((int)(a*Math.sqrt(cor))) > 255){
                    out.setPixel(y, x, 255, 255, 255);
                }
                else{
                    out.setPixel(y, x, (int)(a*Math.sqrt(cor)), (int)(a*Math.sqrt(cor)), (int)(a*Math.sqrt(cor)));
                }                
            }
        }        
        return out;
    }
    
    public Imagem quadrado(float a){
        Imagem out = new Imagem(alt, larg, Imagem.GRAY);
        int cor;
        
        for(int y=0; y < alt; y++){
            for(int x = 0; x < larg; x++){
                cor = img.getPixel(y, x, 0);                
                if(((int)(a*(Math.pow(cor, 2)))) > 255){
                    out.setPixel(y, x, 255, 255, 255);
                }
                else{
                    out.setPixel(y, x, (int)(a*(Math.pow(cor, 2))), (int)(a*(Math.pow(cor, 2))), (int)(a*(Math.pow(cor, 2))));
                }
            }
        }        
        return out;
    }
    
    public Imagem log(float a){
        Imagem out = new Imagem(alt, larg, Imagem.GRAY);
        int cor;
        
        for(int y=0; y < alt; y++){
            for(int x = 0; x < larg; x++){
                cor = img.getPixel(y, x, 0);
                out.setPixel(y, x, (int)(a*(Math.log(cor + 1))), (int)(a*(Math.log(cor + 1))), (int)(a*(Math.log(cor + 1))));
            }
        }        
        return out;
    }
    
    public Imagem negativa(float a, float b){
        Imagem out = new Imagem(alt, larg, Imagem.GRAY);
        int cor;
        
        for(int y=0; y < alt; y++){
            for(int x = 0; x <larg; x++){
                cor = img.getPixel(y, x, 0);
                out.setPixel(y, x, (int)(-(a*cor+b)), (int)(-(a*cor+b)), (int)(-(a*cor+b)));
            }
        }
        return out;
    }
}
