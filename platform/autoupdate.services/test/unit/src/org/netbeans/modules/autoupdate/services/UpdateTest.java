/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.netbeans.modules.autoupdate.services;

import org.netbeans.api.autoupdate.UpdateUnit;
import org.netbeans.junit.RandomlyFails;

/**
 *
 * @author Radek Matous
 */
@RandomlyFails // NB-Core-Build #1634
public class UpdateTest extends OperationsTestImpl {
    
    public UpdateTest(String testName) {
        super(testName);
    }
    
    protected String moduleCodeNameBaseForTest() {
        return "org.yourorghere.engine";
    }
    
    public void testSelf() throws Exception {
        UpdateUnit toUpdate = UpdateManagerImpl.getInstance().getUpdateUnit(moduleCodeNameBaseForTest());
        assertNotNull(toUpdate);
        installModule(toUpdate, toUpdate.getAvailableUpdates ().get (1));
        updateModule(toUpdate);
    }
    
}

