package br.com.letscode.java.services;

import br.com.letscode.java.dominio.Logger;
import br.com.letscode.java.dominio.TipoLog;

import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import java.time.LocalDateTime;

@Singleton
public class LoggerService {

    @Produces
    public Logger getLogger() {
        return new Logger(LocalDateTime.now(), TipoLog.DEBUG);
    }

}
