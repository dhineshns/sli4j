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

import org.apache.log4j.Logger;

import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matcher;
import com.googlecode.sli4j.core.AbstractLoggingModule;

/**
 * {@code Apache Log4j} logger module implementation.
 *
 * @author Simone Tripodi
 * @version $Id$
 */
public final class Log4jLoggingModule extends AbstractLoggingModule<Logger> {

    /**
     * Creates a new {@code Apache Log4j} injection module.
     *
     * @param matcher types matcher for whom the Logger injection has to be
     *        performed.
     */
    public Log4jLoggingModule(Matcher<? super TypeLiteral<?>> matcher) {
        super(matcher, Log4JLoggerInjector.class);
    }

}
