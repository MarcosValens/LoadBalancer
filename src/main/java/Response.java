public class Response {
    private String url;
    private String responseURL;

    public Response(String url, String responseURL) {
        this.url = url;
        this.responseURL = responseURL;
    }

    public String getUrl() {
        return url;
    }

    public String getResponseURL() {
        return responseURL;
    }
}
