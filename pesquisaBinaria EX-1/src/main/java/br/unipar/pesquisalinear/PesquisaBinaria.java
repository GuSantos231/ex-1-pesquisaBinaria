/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.unipar.pesquisalinear;

import javax.swing.JOptionPane;

/**
 *
 * @author gusan
 */
public class PesquisaBinaria {

          // Função para ordenar a lista usando o algoritmo Bubble Sort
    public static void metodoBolha(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    // troca arr[j] e arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    
    // Função para realizar uma pesquisa binária
    public static int pesquisaBinaria(int[] vet, int key) {
        int esquerda = 0;
        int direita = vet.length - 1;
        
        while (esquerda <= direita) {
            int meio = (direita - esquerda) / 2;
            
            if (vet[meio] == key) {
                return meio; // Retorna a posição do elemento se encontrado
            }
            
            if (vet[meio] < key) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }
        
        return -1; // Retorna -1 se o elemento não for encontrado
    }

    public static void main(String[] args) {
        // Pedindo ao usuário para inserir os números e armazenando em um array
        int n = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de números:"));
        int[] num = new int[n];
        JOptionPane.showMessageDialog(null, "Digite os números:");

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o número " + (i + 1) + ":"));
        }

        // Chamando a função bubbleSort para ordenar a lista de números
        metodoBolha(num);

        // Pedindo ao usuário para inserir o número a ser pesquisado
        int searchKey = Integer.parseInt(JOptionPane.showInputDialog("Digite o número a ser pesquisado:"));

        // Realizando a pesquisa binária
        int posicao = pesquisaBinaria(num, searchKey);

        // Exibindo o resultado da pesquisa
        if (posicao != -1) {
            JOptionPane.showMessageDialog(null, "O número " + searchKey + " foi encontrado na posição " + (posicao + 1) + " da lista ordenada.");
        } else {
            JOptionPane.showMessageDialog(null, "O número " + searchKey + " não foi encontrado na lista ordenada.");
        }

    }
}
