/*
 * Copyright (c) 2010-2012 Engine Yard, Inc.
 * Copyright (c) 2007-2009 Sun Microsystems, Inc.
 * This source code is available under the MIT license.
 * See the file LICENSE.txt for details.
 */

package org.jruby.rack.logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jruby.rack.RackLogger;

public class CommonsLoggingLogger implements RackLogger {
    
    private Log logger;

    public CommonsLoggingLogger(String loggerName) {
        setLoggerName(loggerName);
    }

    public void setLoggerName(String loggerName) {
        logger = LogFactory.getLog(loggerName);
    }

    public void log(String message) {
        logger.info(message);
    }

    public void log(String message, Throwable ex) {
        logger.error(message,ex);
    }
    
    public void log(String level, String message) {
        if (ERROR.equals(level)) {
            logger.error(message);
        }
        else if (WARN.equals(level)) {
            logger.warn(message);
        }
        else if (INFO.equals(level)) {
            logger.info(message);
        }
        else if (DEBUG.equals(level)) {
            logger.debug(message);
        }
        else {
            logger.info(message);
        }
    }

    public void log(String level, String message, Throwable e) {
        if (ERROR.equals(level)) {
            logger.error(message, e);
        }
        else if (WARN.equals(level)) {
            logger.warn(message, e);
        }
        else if (INFO.equals(level)) {
            logger.info(message, e);
        }
        else if (DEBUG.equals(level)) {
            logger.debug(message, e);
        }
        else {
            logger.error(message, e);
        }
    }
    
}
