package com.mycompany.mavenproject3;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("bs")
public class BS_Rest {
    
    static Jogo jogo;
    
    @GET
    @Path("criarJogo")
    public String criarJogo(){
        jogo = new Jogo();
        jogo.iniciarTabela();
        return jogo.mostrarTabelaOriginal()+"<br> Jogador 1, digite a posicao dos navios.";
    }
    
    @GET
    @Path("inserirNavios")
    public String inserirNavios(@QueryParam("x") String x, @QueryParam("y") String y){
        String mensagem = jogo.tentarInserirNavios(x, y);
        return mensagem;
    }
    
    @GET
    @Path("jogar")
    public String jogar(@QueryParam("x") String x, @QueryParam("y") String y){
        String mensagem = jogo.tentarAcertarNavios(x, y);
        return mensagem;
    }
    
    @GET
    @Path("verificarVitoria")
    public String verificarVitoria(){
        String mensagem = jogo.verificarVitoria();
        return mensagem;
    }
    
}
//http://localhost:8084/mavenproject3/rest/bs/criarJogo
//http://localhost:8084/mavenproject3/rest/bs/inserirNavios?x=1&y=2
//http://localhost:8084/mavenproject3/rest/bs/jogar?x=1&y=1
//http://localhost:8084/mavenproject3/rest/bs/verificarVitoria