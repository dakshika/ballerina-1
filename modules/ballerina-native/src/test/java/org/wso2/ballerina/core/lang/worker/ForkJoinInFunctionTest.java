/*
 * Copyright (c) 2017, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 * <p>
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.ballerina.core.lang.worker;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.ballerina.core.model.BallerinaFile;
import org.wso2.ballerina.core.model.values.BArray;
import org.wso2.ballerina.core.model.values.BMessage;
import org.wso2.ballerina.core.model.values.BValue;
import org.wso2.ballerina.nativeimpl.util.Functions;
import org.wso2.ballerina.nativeimpl.util.ParserUtils;


public class ForkJoinInFunctionTest {
    private BallerinaFile bFile;

    @BeforeClass
    public void setup() {
        bFile = ParserUtils.parseBalFile("samples/fork-join-in-function.bal");
    }


    @Test(description = "Test Fork Join All")
    public void testForkJoinAll() {
        BValue[] args = {new BMessage()};
        BValue[] returns = Functions.invoke(bFile, "testForkJoinAll", args);
        Assert.assertEquals(returns.length, 1);
        Assert.assertTrue(returns[0] instanceof BArray);
        Assert.assertEquals(((BArray) returns[0]).size(), 2);
        Assert.assertTrue(((BArray) returns[0]).get(0) instanceof BMessage);
        Assert.assertTrue(((BArray) returns[0]).get(1) instanceof BMessage);
    }

    @Test(description = "Test Fork Join Any")
    public void testForkJoinAny() {
        BValue[] args = {new BMessage()};
        BValue[] returns = Functions.invoke(bFile, "testForkJoinAny", args);
        Assert.assertEquals(returns.length, 1);
        Assert.assertTrue(returns[0] instanceof BArray);
        Assert.assertEquals(((BArray) returns[0]).size(), 1);
        Assert.assertTrue(((BArray) returns[0]).get(0) instanceof BMessage);

    }

    @Test(description = "Test Fork Join All of specific")
    public void testForkJoinAllOfSpecific() {
        BValue[] args = {new BMessage()};
        BValue[] returns = Functions.invoke(bFile, "testForkJoinAllOfSpecific", args);
        Assert.assertEquals(returns.length, 1);
        Assert.assertTrue(returns[0] instanceof BArray);
        Assert.assertEquals(((BArray) returns[0]).size(), 2);
        Assert.assertTrue(((BArray) returns[0]).get(0) instanceof BMessage);
        Assert.assertTrue(((BArray) returns[0]).get(1) instanceof BMessage);
    }

    @Test(description = "Test Fork Join Any of specific")
    public void testForkJoinAnyOfSpecific() {
        BValue[] args = {new BMessage()};
        BValue[] returns = Functions.invoke(bFile, "testForkJoinAnyOfSpecific", args);
        Assert.assertEquals(returns.length, 1);
        Assert.assertTrue(returns[0] instanceof BArray);
        Assert.assertEquals(((BArray) returns[0]).size(), 1);
        Assert.assertTrue(((BArray) returns[0]).get(0) instanceof BMessage);
    }
}