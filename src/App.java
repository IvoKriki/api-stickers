import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        
        // buscar dados do endpoint https://alura-filmes.herokuapp.com/conteudos
        String url = "https://alura-filmes.herokuapp.com/conteudos";
        URI adress = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(adress).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body =  response.body();
        //System.out.println(body);

        // filtar os dados que me interessa (titulo, poster e classificacao)
        JsonParcer parcer = new JsonParcer();
        List<Map<String, String>> filmList = parcer.parse(body);
        
        // exibir e manipular os dados
        for (Map<String,String> movie : filmList) {
            System.out.println(movie.get("title"));
            System.out.println(movie.get("rank"));
            System.out.println(movie.get("image"));
        }
    }
}
