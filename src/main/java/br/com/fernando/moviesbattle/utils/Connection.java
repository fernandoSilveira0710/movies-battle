package br.com.fernando.moviesbattle.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connection {

    public static String conectionForWebService(String urlParaChamada) throws Exception {
        try {
            URL url = new URL(urlParaChamada);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != Const.CODIGO_SUCESSO)
                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
            return converteJsonEmString(resposta);

        } catch (Exception e) {
            throw new Exception("ERRO: " + e);
        }

    }

    public static String converteJsonEmString(BufferedReader buffereReader) throws IOException {
        String resposta, jsonEmString = "";
        while ((resposta = buffereReader.readLine()) != null) {
            jsonEmString += resposta;

        }
        return jsonEmString;
    }
}
