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

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import com.google.inject.MembersInjector;
import com.google.inject.TypeLiteral;
import com.google.inject.internal.MoreTypes;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;

/**
 * 
 *
 * @author Simone Tripodi
 * @version $Id$
 */
public abstract class AbstractLoggerListener<L> implements TypeListener {

    /**
     * 
     */
    private final Class<?> loggerClass;

    /**
     * 
     */
    private final Constructor<? extends MembersInjector<L>> logInjectorConstructor;

    /**
     * 
     *
     * @param logInjectorClass
     */
    public <LI extends AbstractLoggerInjector<L>> AbstractLoggerListener(Class<LI> logInjectorClass) {
        this.loggerClass = MoreTypes.getRawType(TypeLiteral.get(this.getClass()).getType());
        try {
            this.logInjectorConstructor = logInjectorClass.getConstructor(Field.class);
        } catch (SecurityException e) {
            throw new RuntimeException("Impossible to access to '"
                    + logInjectorClass.getName()
                    + "("
                    + Field.class.getName()
                    + ")' public constructor due to security violation", e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Class '"
                    + logInjectorClass.getName()
                    + "' doesn't have a public construcor with <"
                    + Field.class.getName()
                    + "> parameter type", e);
        }
    }

    /**
     * {@inheritDoc}
     */
    public final <I> void hear(TypeLiteral<I> type, TypeEncounter<I> encounter) {
        this.hear(type.getRawType(), encounter);
    }

    /**
     * 
     *
     * @param <I>
     * @param klass
     * @param encounter
     */
    @SuppressWarnings("unchecked")
    private <I> void hear(Class<?> klass, TypeEncounter<I> encounter) {
        if (Object.class == klass) {
            return;
        }

        for (Field field : klass.getDeclaredFields()) {
            if (this.loggerClass == field.getType()
                    && field.isAnnotationPresent(LoggerInject.class)) {
                try {
                    encounter.register((MembersInjector<? super I>) this.logInjectorConstructor.newInstance(field));
                } catch (Exception e) {
                    throw new RuntimeException("", e);
                }
            }
        }

        this.hear(klass.getSuperclass(), encounter);
    }

}
