/**
 *
 * @author Leonardo Venancio
 */

public class Morfologia {
    //EROSAO BINARIA
    //FEITO EM SALA DE AULA
    public Imagem erosao(int ee[][], Imagem in){
        Imagem img = in;
        int alt = in.getAltura();
        int larg = in.getLargura();
        Imagem out = new Imagem(alt, larg, Imagem.GRAY);        
        int raio = (ee.length - 1)/2;
        int cor;
        
        boolean ok;
      
        for (int y = raio; y < (alt - raio); y++){
            for (int x = raio; x < (larg - raio); x++){                
                ok = true;
                for(int ey = -raio; ey <= raio; ey++){
                    for (int ex = -raio; ex <= raio; ex++){                    
                        if(ee[raio + ey][raio + ex] == 255 ){
                             cor = img.getPixel(y + ey, x + ex, 0);
                             if (cor != 255){
                                 ok = false;
                                 ey = raio + 1;
                                 ex = raio + 1;                                 
                             }
                        }  
                    }
                }                
                if (ok == true){
                    out.setPixel(y, x, 255, 255, 255);
                } else{
                    out.setPixel(y, x, 0, 0, 0);
                }
            }
        }        
        return out;
    }
    
    //EROSAO MONOCROMATICA
    public Imagem monoErosao(int ee[][], Imagem in){
        Imagem img = in;
        int alt = in.getAltura();
        int larg = in.getLargura();
        Imagem out = new Imagem(alt,larg, Imagem.GRAY);
        int raio = (ee.length-1)/2;
        int cor;
        
        int param;
        int aux;   

        for (int y = raio; y < (alt - raio); y++){
            for (int x = raio; x < (larg - raio); x++){
                aux = 255;
                for(int ey = - raio; ey <= raio; ey++){
                    for (int ex = -raio; ex <= raio; ex++){                        
                        cor = img.getPixel(y + ey, x + ex, 0);
                        param = cor - (ee[raio + ey][raio + ex]);
                        if (param < aux){
                            aux = param;
                        }                        
                    }
                }                
                if (aux > 255){
                    out.setPixel(y, x, 255, 255, 255);                 
                }else if(aux < 0){
                    out.setPixel(y, x, 0, 0,0 );
                }else {
                    out.setPixel(y, x, aux, aux, aux);
                }    
            }        
        }
        return out;
    }
    
    //DILATACAO BINARIA
    public Imagem dilatacao(int ee[][], Imagem in){
        Imagem img = in;
        int alt = in.getAltura();
        int larg = in.getLargura();
        Imagem out = new Imagem(alt, larg, Imagem.GRAY);        
        int raio = (ee.length - 1)/2;        
        int cor;
        
        boolean ok;
        
        for (int y = raio; y < (alt - raio); y++){
            for (int x = raio; x < (larg - raio); x++){
                ok = true;
                for(int ey = -raio; ey <= raio; ey++){
                    for (int ex = -raio; ex <= raio; ex++){                     
                        if(ee[raio + ey][raio + ex] == 255 ){
                             cor = img.getPixel(y + ey, x + ex, 0);
                             if (cor == 255){
                                 ok = false;
                                 ey = raio + 1;
                                 ex = raio + 1;                                 
                             }
                        }  
                    }
                }                
                if (ok == false){
                    out.setPixel(y, x, 255, 255, 255);
                } else{
                    out.setPixel(y, x, 0, 0, 0);
                }
            }
        }        
        return out;
    }
    
    //DILATACAO MONOCROMATICA
    public Imagem monoDil(int ee[][], Imagem in){
        Imagem img = in;
        int alt = in.getAltura();
        int larg = in.getLargura();
        Imagem out = new Imagem(alt,larg, Imagem.GRAY);
        int raio = (ee.length-1)/2;
        int cor;
        
        int param;
        int aux;

        for (int y = raio; y < (alt - raio); y++){
            for (int x = raio; x < (larg - raio); x++){
                aux = 0;
                for(int ey = - raio; ey <= raio; ey++){
                    for (int ex = -raio; ex <= raio; ex++){                        
                        cor = img.getPixel(y + ey, x + ex, 0);
                        param = cor - (ee[raio + ey][raio + ex]);
                        if (param > aux){
                            aux = param;
                        }                        
                    }
                }                
                if (aux > 255){
                    out.setPixel(y, x, 255, 255, 255);                 
                }else if(aux < 0){
                    out.setPixel(y, x, 0, 0,0 );
                }else {
                    out.setPixel(y, x, aux, aux, aux);
                }    
            }        
        }
        return out;
    }
    
    
    //ABERTURA BINARIA
    public Imagem abertura(int ee[][], Imagem in){
        Imagem img = in;
        int alt = in.getAltura();
        int larg = in.getLargura();
        Imagem out = new Imagem(alt, larg, Imagem.GRAY);
        Imagem aux = new Imagem(alt, larg, Imagem.GRAY);
        
        aux = erosao(ee, img);          
        out = dilatacao(ee, aux);  
          
        return out;        
    }
    
    //ABERTURA MONOCROMATICA
    public Imagem monoAbertura(int ee[][], Imagem in){    
        Imagem img = in;
        int alt = in.getAltura();
        int larg = in.getLargura();
        Imagem out = new Imagem(alt,larg, Imagem.GRAY);
        Imagem aux = new Imagem(alt,larg, Imagem.GRAY);

        aux = monoErosao(ee, img);
        out = monoDil(ee,aux);

        return out;
    }
    
    //FECHAMENTO BINARIA
    public Imagem fechamento(int ee[][], Imagem in){
        Imagem img = in;
        int alt = in.getAltura();
        int larg = in.getLargura();
        Imagem out = new Imagem(alt, larg, Imagem.GRAY);
        Imagem aux = new Imagem(alt, larg, Imagem.GRAY);
        
        aux = dilatacao(ee, img);          
        out = erosao(ee, aux);  
          
        return out;        
    }
    
    //FECHAMENTO MONOCROMATICA
    public Imagem monoFechamento(int ee[][], Imagem in){    
        Imagem img = in;
        int alt = in.getAltura();
        int larg = in.getLargura();
        Imagem out = new Imagem(alt,larg, Imagem.GRAY);
        Imagem aux = new Imagem(alt,larg, Imagem.GRAY);

        aux = monoDil(ee, img);
        out = monoErosao(ee,aux);

        return out;
    }
    
    //BORDA INTERNA
    public Imagem bordInterna(int ee[][], Imagem in){
        Imagem img = in;
        int alt = in.getAltura();
        int larg = in.getLargura();
        Imagem out = new Imagem(alt,larg, Imagem.GRAY);
        Imagem aux = new Imagem(alt,larg, Imagem.GRAY);
        Processador processador = new Processador();
        
        aux = erosao(ee, img);        
        out = processador.subt(img, aux);
        
        return out;       
    }
    
    
    //BORDA EXTERNA
    public Imagem bordExterna(int ee[][], Imagem in){
        Imagem img = in;
        int alt = in.getAltura();
        int larg = in.getLargura();
        Imagem out = new Imagem(alt,larg, Imagem.GRAY);
        Imagem aux = new Imagem(alt,larg, Imagem.GRAY);
        Processador processador = new Processador();
        
        aux = dilatacao(ee, img);
        out = processador.subt(aux, img);
        
        return out;       
    }
    
    //BORDA EXTERNA
    public Imagem acertoErro(int ee[][], int ff[][], Imagem in){
        Imagem img = in;
        int alt = in.getAltura();
        int larg = in.getLargura();
        Imagem out = new Imagem(alt,larg, Imagem.GRAY);
        Imagem aux = new Imagem(alt,larg, Imagem.GRAY);
        Imagem aux2 = new Imagem(alt, larg, Imagem.GRAY);
        Imagem aux3 = new Imagem(alt, larg, Imagem.GRAY);
        Processador processador = new Processador();
        
        aux = erosao(ee, img);
        aux2 = processador.not(in);
        aux3 = erosao(ff, aux2);        
        out = processador.operadorSub(aux, aux3);
        
        return out;       
    }
    
    public Imagem smoothing(int[][] ee, Imagem in){
        Imagem img = in;
        int alt = in.getAltura();
        int larg = in.getLargura();
        Imagem out = new Imagem(alt, larg, Imagem.GRAY);
        Imagem aux = new Imagem(alt, larg, Imagem.GRAY);
        Processador processador = new Processador();
        
        aux = monoAbertura(ee, img);
        out = monoFechamento(ee, aux);
        
        return out;
    }
    
    public Imagem gradiente(int[][] ee, Imagem in){
        Imagem img = in;
        int alt = in.getAltura();
        int larg = in.getLargura();
        Imagem out = new Imagem(alt, larg, Imagem.GRAY);
        Imagem aux = new Imagem(alt, larg, Imagem.GRAY);
        Processador processador = new Processador();
        
        aux = monoDil(ee, img);
        
        Imagem aux2 = new Imagem(alt, larg, Imagem.GRAY);
        aux2 = monoErosao(ee, img);
        out = processador.subt(aux, aux2);
        
        return out;
    }
}
