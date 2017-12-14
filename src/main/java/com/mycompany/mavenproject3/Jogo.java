package com.mycompany.mavenproject3;

public class Jogo {
    
    String [][] tabela = new String [10][10];
    int naviosRestantes = 0;
    boolean começou = false;
    
    public void iniciarTabela(){
        for(int i=0; i<this.tabela.length; i++){
            for(int x=0; x<this.tabela.length; x++){
                this.tabela[i][x] = "~";
            }
        }
    }
    
    public String mostrarTabelaOriginal(){
        String string = "";
        for(int i=0; i<this.tabela.length; i++){
            for(int x=0; x<this.tabela.length; x++){
                string += this.tabela[i][x]+"      ";
            }
            string+="<br>";
        }
        return string;
    }
    
    public String mostrarTabelaParaJogador() {
        String string = "";
        for(int i=0; i<this.tabela.length; i++){
            for(int x=0; x<this.tabela.length; x++){
                if(this.tabela[i][x].equals("v")){
                    string += "~"+"      ";
                }else{
                    string += this.tabela[i][x]+"      ";
                }
            }
            string+="<br>";
        }
        return string;
    }
    
    public String tentarInserirNavios(String x, String y) {
        if(começou == true){
            return this.mostrarTabelaParaJogador()+"<br> O jogo ja foi iniciado. Jogador 2, atire em uma posicao.";
        }
        try{
            int pX = Integer.parseInt(x)-1;
            int pY = Integer.parseInt(y)-1;
            
            if(pX<this.tabela.length && pY<this.tabela.length && pX>=0 && pY>=0){
                if(tabela[pX][pY].equals("v")){
                    return this.mostrarTabelaOriginal()+"<br> Ja existe um barco nessa posicao! Escolha uma outra posicao.";
                }else{
                    this.inserirNavios(pX, pY);
                    if(this.naviosRestantes >= 10){
                        começou = true;
                        return this.mostrarTabelaParaJogador()+"<br> Jogador 2, digite uma posicao.";
                    }
                    return this.mostrarTabelaOriginal()+"<br> Navio inserido!";
                }
            }
            return this.mostrarTabelaOriginal()+"<br> Posicao invalida! Escolha uma posicao existente.";
        }catch(Exception e){return this.mostrarTabelaOriginal()+"<br> Posicao invalida! Escolha uma posicao existente.";}
    }
    
    public void inserirNavios(int x, int y){
        this.naviosRestantes += 1;
        this.tabela[x][y] = "v";
    }
    
    public String tentarAcertarNavios(String x, String y) {
        if(começou == false){
            return this.mostrarTabelaOriginal()+"<br> O jogo ainda nao comecou! Jogador 1, insira os navios.";
        }
        if(this.naviosRestantes < 1){
            return this.mostrarTabelaParaJogador();
        }
        try{
            int pX = Integer.parseInt(x)-1;
            int pY = Integer.parseInt(y)-1;
            
            if(pX<this.tabela.length && pY<this.tabela.length && pX>=0 && pY>=0){
                if(this.tabela[pX][pY].equals("*") || this.tabela[pX][pY].equals("X")){
                    return this.mostrarTabelaParaJogador()+"<br> Essa posicao ja foi jogada! Digite outra posicao.";
                }else{
                    String mensagem = this.atirar(pX, pY);
                    return this.mostrarTabelaParaJogador()+"<br> "+mensagem;
                }
            }
            return this.mostrarTabelaParaJogador()+"<br> Posicao invalida! Escolha uma posicao existente.";
        }catch(Exception e){return this.mostrarTabelaParaJogador()+"<br> Posicao invalida! Escolha uma posicao existente.";}
    }
    
    public String atirar(int x, int y) {
        if(this.tabela[x][y].equals("v")){
            this.naviosRestantes -= 1;
            this.tabela[x][y] = "X";
            return "Voce acertou um navio.";
        }else{
            this.tabela[x][y] = "*";
            return "Voce errou! Tente novamente.";
        }
    }
    
    public String verificarVitoria() {
        if(this.começou == false){
            return this.mostrarTabelaOriginal()+"<br> O jogo ainda nao comecou! Jogador 1, insira os navios.";
        }
        if(this.naviosRestantes < 1){
            return this.mostrarTabelaParaJogador()+"<br> Voce acertou todos os navios! GAME OVER.";
        }else{
            return this.mostrarTabelaParaJogador()+"<br> Navios restantes: "+this.naviosRestantes;
        }
    }
}
