package api;

public enum HttpParameter {

    API_ID ("app-id");

    String name;

    HttpParameter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
