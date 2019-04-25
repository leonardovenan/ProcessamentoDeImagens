public class Main {
    public static void main(String args[]){
        //testaStretching();
        testaDithering();
        
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
        imgA.mostrar();
//        streatching.linear(0.1f, 10).mostrar();
//        streatching.linear(0.2f, 10).mostrar();
//        streatching.linear(0.30f, 10).mostrar();
        streatching.linear(0.8f, 10).mostrar();
    }
    
    public static void testaDithering(){
        Imagem imgA = new Imagem("C:\\Users\\Leonardo\\Desktop\\ProcImag\\ProcImag\\mario.jpg");
        Dithering dit = new Dithering(imgA);
        //dit.limiarSimples(50).mostrar();
        //dit.limiarSimples(150).mostrar();
        //dit.limiarAleatorio(50, 10).mostrar();
        //dit.limiarAleatorio(50, 40).mostrar();
        dit.limiarAleatorio(100, 25).mostrar();
    }
}
