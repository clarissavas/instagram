package tecnologias.ordinario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class archivoMultimedia {
    public static void main(String[] args) {
        // Ejemplo de respuesta JSON de la API de Instagram
        String jsonResponse = "{\n" +
                "    \"username\": \"usuario_instagram\",\n" +
                "    \"followers\": 1000,\n" +
                "    \"posts\": [\n" +
                "        {\n" +
                "            \"id\": 1,\n" +
                "            \"image_url\": \"https://instagram.com/image1.jpg\",\n" +
                "            \"caption\": \"Descripción de la imagen 1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 2,\n" +
                "            \"image_url\": \"https://instagram.com/image2.jpg\",\n" +
                "            \"caption\": \"Descripción de la imagen 2\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        try {
            // Analizar la respuesta JSON
            JSONObject json = new JSONObject(jsonResponse);
            String username = json.getString("username");
            int followers = json.getInt("followers");
            JSONArray postsArray = json.getJSONArray("posts");

            // Imprimir los datos
            System.out.println("Usuario: " + username);
            System.out.println("Seguidores: " + followers);
            System.out.println("Publicaciones:");

            // Recorrer las publicaciones
            for (int i = 0; i < postsArray.length(); i++) {
                JSONObject post = postsArray.getJSONObject(i);
                int id = post.getInt("id");
                String imageUrl = post.getString("image_url");
                String caption = post.getString("caption");

                System.out.println("ID: " + id);
                System.out.println("URL de la imagen: " + imageUrl);
                System.out.println("Descripción: " + caption);
                System.out.println();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

}
