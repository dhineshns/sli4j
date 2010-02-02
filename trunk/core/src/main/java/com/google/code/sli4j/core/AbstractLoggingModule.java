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
package com.google.code.sli4j.core;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matcher;

/**
 * 
 *
 * @author Simone Tripodi
 * @version $Id$
 */
public class AbstractLoggingModule extends AbstractModule {

    private final Matcher<? super TypeLiteral<?>> matcher;

    private final AbstractLoggerListener<?> loggerListener;

    public <LL extends AbstractLoggerListener<?>> AbstractLoggingModule(Matcher<? super TypeLiteral<?>> matcher, LL loggerListener) {
        this.matcher = matcher;
        this.loggerListener = loggerListener;
    }

    @Override
    protected final void configure() {
        this.bindListener(this.matcher, this.loggerListener);
    }

}
