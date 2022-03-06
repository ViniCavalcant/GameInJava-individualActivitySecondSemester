/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetojava;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author vinicius.rodrigues@VALEMOBI.CORP
 */
public class desafioJava {
    // Funções para que o jogo possa ser realizado
    // Função Usuario
    static int ataqueDoUsuario(){
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Escolha o seu ataque: ");
        System.out.println("(1) - Ataque comum");
        System.out.println("(2) - Menu");
        System.out.println("(3) - Ataque especial");
        System.out.println("(4) - Finalizar jogo");
        System.out.println("_______________________________________\n");
        
        return leitor.nextInt();
    }
    
    // Função Computador
    static int ataqueDoComputador(){
        Random gerador = new Random();
        
        // irá retoranr um numero aleatório entre 1 e 3
        return gerador.nextInt(3)+1;
    }
    
    // Função que mostra a vida do usuario e computador
    static void mostraVida(int vidaUsuario, int vidaComputador, int contadorEspecial){
        System.out.println(
                "<+> Sua vida: " + vidaUsuario 
                + " (Voce possui " + contadorEspecial + " especiais)"
        );
        System.out.println("<+> Vida do adversário: " + vidaComputador);
        System.out.println("_______________________________________\n");
    }
    
    // Função realiza o jogo
    static int jogoIniciado(){
        int vidaUsuario = 100;
        int vidaComputador;
        int contadorEspecial = 5;
        int ataqueSelecinado;
        int contador = 1; 

        while (vidaUsuario > 0){
            vidaComputador = 14 + contador;
            
            System.out.println("_______________________________________\n");
            System.out.println("Você enfrentara o inimigo " + contador);
            System.out.println("_______________________________________\n\n");            
            while(vidaUsuario > 0 && vidaComputador > 0){
                mostraVida(vidaUsuario, vidaComputador, contadorEspecial);
                ataqueSelecinado = ataqueDoUsuario();
                switch(ataqueSelecinado){
                    case 1:
                        System.out.println("Você realizou um taque comum.");
                        vidaComputador -= 8;
                        break;
                    case 2:
                        if(vidaUsuario < 100){
                            vidaUsuario += 10;
                            System.out.println(
                                "\n(O jogo não tem pausas, "
                                + "você foi atacado enquanto estava no menu, "
                                + "tenha mais cuidado da próxima vez \n"
                                + "deu sorte que que seu adversario é mais atrapalhado que você,"
                                + " é teve tempo de se curar < +10 pontos de vida >)\n"); 
                        }   
                        break;
                    case 3:
                        System.out.println("Você realizou um ataque especial.");
                            vidaComputador -= 15;
                            contadorEspecial -= 1;
                            if(contadorEspecial < 1){
                                vidaComputador += 15;
                            }
                        break;    
                    case 4:
                        return 0;
                    default:
                        System.out.println("opção invalida.");
                        break;
                } if(vidaComputador > 0){
                    ataqueSelecinado = ataqueDoComputador();
                    switch(ataqueSelecinado){
                        case 1:
                            System.out.println("O computador realizou um ataque comum.");
                            vidaUsuario -= 10 + (int)(contador / 5);
                            break;
                        case 2:
                            System.out.println("O computador realizou um ataque especial.");
                            vidaUsuario -= 20 + (int)(contador / 10);
                            break;
                        case 3:
                            System.out.println("O computador se curou.");
                            vidaComputador += 7;
                            break;
                        default:
                        System.out.println("opção invalida.");
                        return vidaComputador;
                    }
                } else {
                    System.out.print("--------------------------------------\n");
                    System.out.println("Você derrotou seu oponente.");
                    System.out.println("--------------------------------------\n");
                }
            }
            if(vidaUsuario >= 0){
                vidaUsuario += 5;
                if(vidaUsuario > 100){
                    vidaUsuario = 100;
                } if(contador % 5 == 0) {
                    contadorEspecial++;
                    if(contadorEspecial > 5){
                        contadorEspecial = 5;
                    }
                }
            }            
        contador++;
        }
        return 0;

    }
    
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int continua = 1;
        while(continua == 1){
            jogoIniciado();
  
            System.out.println("Fim de jogo... Deseja jogar novamente? (1) - Sim | (2) - Não");
            continua = leitor.nextInt();
        }
    }
}
