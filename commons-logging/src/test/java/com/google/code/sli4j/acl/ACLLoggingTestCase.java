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
package com.google.code.sli4j.acl;

import org.apache.commons.logging.Log;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.code.sli4j.testfw.AbstractLoggerInectionTestCase;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;

/**
 * 
 *
 * @author Simone Tripodi
 * @version $Id$
 */
public final class ACLLoggingTestCase extends AbstractLoggerInectionTestCase<Log> {

    private Log logger;

    @BeforeTest
    public void setUp() {
        super.setUp(new ACLLoggingModule(Matchers.only(TypeLiteral.get(this.getClass()))));
    }

    @Test
    public void injectAndVerify() {
        this.injectAndVerify(this.logger);
    }

}
