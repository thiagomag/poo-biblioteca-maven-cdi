package br.com.letscode.java.dominio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private LocalDateTime localDateTime;
    private TipoLog tipoLog;

    public Logger(LocalDateTime time, TipoLog tipoLog) {
        this.localDateTime = time;
        this.tipoLog = tipoLog;

    }

    public String getTempoFormatado() {
        return String.format("%s - %s ", this.tipoLog.getLabel(), this.localDateTime.format(DateTimeFormatter.ISO_DATE_TIME));
    }

}
