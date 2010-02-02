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

import java.lang.reflect.Field;

import com.google.inject.MembersInjector;

/**
 * 
 *
 * @author Simone Tripodi
 * @version $Id$
 */
public abstract class AbstractLoggerInjector<L> implements MembersInjector<L> {

    /**
     * The logger field has to be injected.
     */
    private final Field field;

    /**
     * 
     *
     * @param field the logger field has to be injected.
     */
    public AbstractLoggerInjector(Field field) {
        this.field = field;
    }

    /**
     * {@inheritDoc}
     */
    public final void injectMembers(Object target) {
        boolean wasAccessible = this.field.isAccessible();
        this.field.setAccessible(true);
        try {
            this.field.set(target, this.createLogger(this.field.getType()));
        } catch (Exception e) {
            throw new RuntimeException("Impossible to set logger to field '"
                    + field
                    + "', see nested exceptions", e);
        } finally {
            this.field.setAccessible(wasAccessible);
        }
    }

    /**
     * 
     *
     * @return
     */
    protected abstract L createLogger(Class<?> klass);

}
