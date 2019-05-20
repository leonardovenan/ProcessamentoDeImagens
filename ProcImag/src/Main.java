public class Main {
    public static void main(String args[]){
        //testaStretching();
        //testaDithering();
        testaMorfologia();

    }  
    
    public static void primeiraProva(){
        Imagem imgA = new Imagem("C:\\Users\\Leonardo\\Desktop\\ProcImag\\ProcImag\\A.png");
        Imagem imgB = new Imagem("C:\\Users\\Leonardo\\Desktop\\ProcImag\\ProcImag\\B.png");
        Imagem imgC = new Imagem("C:\\Users\\Leonardo\\Desktop\\ProcImag\\ProcImag\\mario.jpg");
        Imagem imgD = new Imagem("C:\\Users\\Leonardo\\Desktop\\ProcImag\\ProcImag\\OLHO.PNG");
        //imgA.mostrar("Imagem A");
        //imgB.mostrar("Imagem B");
        //imgC.mostrar("Mario");
        //imgD.mostrar("Olho");
        //Processador.soma(imgA, imgB).mostrar("Soma");
        //Processador.subt(imgA, imgB).mostrar("Subtração");
        //Processador.not(imgB).mostrar("Not");
        //Processador.operadorAnd(imgA, imgB).mostrar("And");
        //Processador.operadorOr(imgA, imgB).mostrar("Or");
        //Processador.operadorXor(imgA, imgB).mostrar("Xor");
        //Processador.operadorSub(imgA, imgB).mostrar("Sub");
        //Processador.quantizacao(imgC, 5).mostrar("Quantização");
        //Processador.equalizar(imgD).mostrar("Equalização");
        //int[][] filtro1 = {{1,1,1},{1,1,1},{1,1,1}};
        //int[][] filtro2 = {{1,3,2},{1,3,2},{1,3,2}};
        //Processador.filtroDaMedia(imgC, filtro1).mostrar("filtro da média");
        //Processador.filtroPassaAlta(imgC, filtro2).mostrar("filtro passa alta");
    }
    
    public static void testaStretching(){
        Imagem imgA = new Imagem("C:\\Users\\Leonardo\\Desktop\\ProcImag\\ProcImag\\mario.jpg");
        Streatching streatching = new Streatching(imgA);
        imgA.mostrar("Original");
        streatching.linear(0.1f, 10).mostrar();
        streatching.linear(0.2f, 10).mostrar();
        streatching.linear(0.30f, 10).mostrar();
        streatching.linear(0.8f, 10).mostrar("Linear");
        streatching.quadradoRaiz(30).mostrar("quadradoRaiz");
        streatching.quadrado(0.3f).mostrar("quadrado");
        streatching.log(30).mostrar("log");
        streatching.negativa(0.8f, 20).mostrar("negativo");
    }
    
    public static void testaDithering(){
        Imagem imgA = new Imagem("C:\\Users\\Leonardo\\Desktop\\ProcImag\\ProcImag\\mario.jpg");
        Dithering dit = new Dithering(imgA);
        imgA.mostrar("Original");
        //dit.limiarSimples(50).mostrar();
        //dit.limiarSimples(150).mostrar();
        //dit.limiarAleatorio(50, 10).mostrar();
        //dit.limiarAleatorio(50, 40).mostrar();
        dit.limiarAleatorio(50, 20).mostrar();
    }
    
    public static void testaMorfologia(){
        Imagem imgA = new Imagem("C:\\Users\\Leonardo\\Desktop\\ProcImag\\ProcImag\\B.PNG");
        Imagem imgB = new Imagem("C:\\Users\\Leonardo\\Desktop\\ProcImag\\ProcImag\\mario.jpg");
        Imagem imgC = new Imagem("C:\\Users\\Leonardo\\Desktop\\ProcImag\\ProcImag\\lenna.jpg");
        Morfologia morfo = new Morfologia();
        
        int[][] ee = {{0,255,0},{255,255,255},{0,255,0}};
        int[][] ff = {{255,0,255},{0,0,0},{255,0,255}};
        int[][] mono = {{1,1,1},{1,2,1},{1,1,1}};
        //morfo.erosao(ee, imgA).mostrar("erosao");
        //morfo.dilatacao(ee, imgA).mostrar("dilatação");
        //morfo.abertura(ee, imgA).mostrar("abertura");
        //morfo.fechamento(ee, imgA).mostrar("fechamento");
        //morfo.bordInterna(ee, imgA).mostrar("borda Interna");
        //morfo.bordExterna(ee, imgA).mostrar("borda Extrena");
        //morfo.acertoErro(ee, ff, imgA).mostrar("Acerto w Erro");    
        //imgA.mostrar("original");
        //morfo.monoErosao(mono, imgB).mostrar("Erosao mono");
       // morfo.monoDil(mono, imgB).mostrar("Dilatação mono");
       //morfo.monoAbertura(mono, imgC).mostrar("Abertura Monocromática");
       //morfo.monoFechamento(mono, imgC).mostrar("Fechamento Monocromático");
       morfo.smoothing(mono, imgB).mostrar("Smoothing");
       morfo.gradiente(mono, imgB).mostrar("Gradiente");
        
        //int[][] x = {{1,1,1},{1,2,1},{1,1,1}};
        
        //morfo.monoErosao(x, imgB).mostrar("Erosao Monocromatica ");
    }
}
