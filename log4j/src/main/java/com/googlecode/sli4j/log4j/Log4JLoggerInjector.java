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
package com.googlecode.sli4j.log4j;

import java.lang.reflect.Field;

import org.apache.log4j.Logger;

import com.googlecode.sli4j.core.AbstractLoggerInjector;

/**
 * {@code Apache Log4j} logger injector implementation.
 *
 * @author Simone Tripodi
 * @version $Id$
 */
public final class Log4JLoggerInjector extends AbstractLoggerInjector<Logger> {

    /**
     * Creates a new {@code Apache Log4j} Logger injector.
     *
     * @param field the logger field has to be injected.
     */
    public Log4JLoggerInjector(Field field) {
        super(field);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Logger createLogger(Class<?> klass) {
        return Logger.getLogger(klass);
    }

}
