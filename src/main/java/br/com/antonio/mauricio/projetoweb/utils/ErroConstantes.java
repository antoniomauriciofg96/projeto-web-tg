package br.com.antonio.mauricio.projetoweb.utils;

/**
 * Classe com mensagens de erros genericas
 */
public class ErroConstantes {

    //Mensagens
    public static final String MSG_ERRO_TOKEN_INVALIDO = "Sessão ou Token inválido! Verifique os parametros de autenticação";
    public static final String MSG_ERRO_BUSCAR_DADOS_USUARIO = "Houve uma falha ao obter as informações do usuário";

    public static final String CODIGO_200_DESCRICAO = "Sucesso.";
    public static final String CODIGO_200_TIPO = "sucess";

    public static final String CODIGO_400_DESCRICAO = "Os parâmetros utilizados na requisição são inválidos.";
    public static final String CODIGO_400_TIPO = "bad_request";

    public static final String CODIGO_401_DESCRICAO = "Falha de autenticação.";
    public static final String CODIGO_401_TIPO = "unauthorized";

    public static final String CODIGO_403_DESCRICAO = "Não autorizado.";
    public static final String CODIGO_403_TIPO = "forbidden";

    public static final String CODIGO_500_DESCRICAO = "Ocorreu um erro interno.";
    public static final String CODIGO_500_TIPO = "internal_server_error";

    public static final String CODIGO_503_DESCRICAO = "Serviço temporariamente indisponível, tente novamente mais tarde.";
    public static final String CODIGO_503_TIPO = "service_temporarily_unavailable";

}
