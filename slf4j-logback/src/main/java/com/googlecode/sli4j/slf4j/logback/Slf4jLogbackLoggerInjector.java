/*
 *    Copyright 2010 The sli4j Team
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.googlecode.sli4j.slf4j.logback;

import java.lang.reflect.Field;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.impl.StaticLoggerBinder;

import com.googlecode.sli4j.core.AbstractLoggerInjector;

/**
 * {@code SLF4J - Logback} logger injector implementation.
 *
 * @author Simone Tripodi
 * @version $Id$
 */
public final class Slf4jLogbackLoggerInjector extends AbstractLoggerInjector<Logger> {

    /**
     * The {@code SLF4J - Logback} logger factory.
     */
    private static final ILoggerFactory LOGBACK_LOG_FACTORY = StaticLoggerBinder.getSingleton().getLoggerFactory();

    /**
     * Creates a new {@code SLF4J - Logback} Logger injector.
     *
     * @param field the logger field has to be injected.
     */
    public Slf4jLogbackLoggerInjector(Field field) {
        super(field);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Logger createLogger(Class<?> klass) {
        return LOGBACK_LOG_FACTORY.getLogger(klass.getName());
    }

}
