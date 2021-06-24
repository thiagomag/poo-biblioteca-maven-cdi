package br.com.letscode.java.dominio;

public enum TipoLog {
    INFO("Info"), ERRO("Error"), DEBUG("Debug");

    private String label;

    private TipoLog(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
}
