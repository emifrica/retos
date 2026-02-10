package com.entrevistas.ejercicios.otros;

public class LinkedListAddTwoNumbers {

    // Clase nodo
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0); // nodo auxiliar
        ListNode actual = temp;         // puntero actual
        int acarreo = 0;

        while (l1 != null || l2 != null) {
            int a = (l1 != null) ? l1.val : 0;
            int b = (l2 != null) ? l2.val : 0;

            int sum = a + b + acarreo;
            acarreo = sum / 10;     // obtiene el acarreo
            sum = sum % 10;       // dígito actual

            actual.next = new ListNode(sum);
            actual = actual.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // si aún hay acarreo final
        if (acarreo > 0) {
            actual.next = new ListNode(acarreo);
        }

        return temp.next; // se omite el nodo auxiliar
    }

    public static void main(String[] args) {
        ListNode lista1 = new ListNode(2);
        lista1.next = new ListNode(4);
        lista1.next.next = new ListNode(3);

        ListNode lista2 = new ListNode(5);
        lista2.next = new ListNode(6);
        lista2.next.next = new ListNode(4);

        ListNode resultado  = addTwoNumbers(lista1, lista2);
        while (resultado != null){
            System.out.print(resultado.val + "->");
            resultado = resultado.next;
        }
        System.out.println("null");


    }
}
