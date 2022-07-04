package com.codigoMorse.codigoMorse.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/traduzMorse")
public class TraduzMorse {

    @GetMapping("/{frase}")
    public ResponseEntity<String> traduzMorse(@PathVariable String frase) {
        String[] palavras = frase.split("   ");
        ArrayList<String> simbolos = new ArrayList<String>();

        for (int i = 0; i < palavras.length; i++) {
            String[] codigos = palavras[i].split(" ");

            for (String simbolo : codigos) {
                simbolos.add(simbolo);
            }

            simbolos.add(" ");
        }

        ArrayList<String> vCodigos = new ArrayList<String>(Arrays.asList(".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",
                ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----", "..--..", "-.-.--", ".-.-.-", "--..--"));

        String[] vSimbolos = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "?", "!", ".", ","};

        String resposta = "";

        for (int i = 0; i < simbolos.size(); i++) {
            String simbolo = simbolos.get(i);

            if (simbolo != " ") {
                int index = vCodigos.indexOf(simbolo);
                resposta += vSimbolos[index];
            } else {
                resposta += " ";
            }
        }


        return new ResponseEntity<String >(resposta, HttpStatus.OK);
    }
}
