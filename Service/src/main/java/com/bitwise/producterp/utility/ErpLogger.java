package com.bitwise.producterp.utility;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.Loader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by chetanlo on 8/8/2016.
 */
public class ErpLogger {

    public static final String CLASSIC_FILE="logback.xml";
    public static final String BASE_PATH="config/";
    public static final ErpLogger erpLogger = new ErpLogger(ErpLogger.class);
    Logger logger;
    public ErpLogger(Class clazz){
        logger = LoggerFactory.getLogger(clazz);
    }

    public void info(String infoMsg){
        logger.info(infoMsg);
        writeLogsOnFileAndConsole();
    }
    public void debug(String debugMsg){
        logger.debug(debugMsg);
        writeLogsOnFileAndConsole();
    }
    public void warn(String warnMsg){
        logger.warn(warnMsg);
    }
    public void error(Exception e){
        logger.error(e.getMessage());
        writeLogsOnFileAndConsole();
    }

    private void writeLogsOnFileAndConsole() {
        try {
            ClassLoader loader = new URLClassLoader(new URL[]{new File(BASE_PATH).toURI().toURL()});
            LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
            URL url = Loader.getResource(CLASSIC_FILE, loader);
            if (url != null) {
                JoranConfigurator configurator = new JoranConfigurator();
                configurator.setContext(lc);
                lc.reset();
                configurator.doConfigure(url);
                lc.start();
            }
        } catch (JoranException je) {
            erpLogger.error(je);
            je.printStackTrace();
        }
        catch (MalformedURLException e) {
            erpLogger.error(e);
            e.printStackTrace();
        }
    }
}
