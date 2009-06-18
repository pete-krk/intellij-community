/*
 * Copyright 2000-2009 JetBrains s.r.o.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.jetbrains.plugins.groovy;

import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.testFramework.builders.JavaModuleFixtureBuilder;
import com.intellij.testFramework.fixtures.JavaCodeInsightFixtureTestCase;

/**
 * Created by IntelliJ IDEA.
 * User: Maxim.Medvedev
 * Date: Feb 27, 2009
 * Time: 5:06:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class GroovyCompletionTest extends JavaCodeInsightFixtureTestCase {
  @Override
  protected String getBasePath() {
    return "/svnPlugins/groovy/testdata/groovy/completion/";
  }

  @Override
  protected void tuneFixture(JavaModuleFixtureBuilder moduleBuilder) {
    moduleBuilder.setMockJdkLevel(JavaModuleFixtureBuilder.MockJdkLevel.jdk15);
  }


  public void testFinishMethodWithLParen() throws Throwable {
    myFixture.testCompletionVariants(getTestName(false) + ".groovy", "getBar", "getFoo");
    myFixture.type('(');
    myFixture.checkResultByFile(getTestName(false) + "_after.groovy");
  }

  public void testSmartCompletionAfterNewInDeclaration() throws Throwable {
    myFixture.configureByFile(getTestName(false) + ".groovy");
    myFixture.complete(CompletionType.SMART);
    assertOrderedEquals(myFixture.getLookupElementStrings(), "Bar", "Foo");
  }

  public void testSmartCompletionAfterNewInDeclarationWithInterface() throws Throwable {
    doSmartTest();
  }

  private void doSmartTest() throws Throwable {
    myFixture.configureByFile(getTestName(false) + ".groovy");
    myFixture.complete(CompletionType.SMART);
    myFixture.checkResultByFile(getTestName(false) + "_after.groovy", true);
  }

  public void testCaretAfterSmartCompletionAfterNewInDeclaration() throws Throwable {
    doSmartTest();
  }

  public void testSmartCompletionAfterNewInDeclarationWithAbstractClass() throws Throwable {
    doSmartTest();
  }

  public void testSmartCompletionAfterNewInDeclarationWithArray() throws Throwable {
    doSmartTest();
  }

  public void testSmartCompletionAfterNewInDeclarationWithIntArray() throws Throwable {
    doSmartTest();
  }

  public void testShortenNamesInSmartCompletionAfterNewInDeclaration() throws Throwable {
    doSmartTest();
  }

  public void testEachMethodForList() throws Throwable {
    doBasicTest();
  }

  private void doBasicTest() throws Throwable {
    myFixture.testCompletion(getTestName(false) + ".groovy", getTestName(false) + "_after.groovy");
  }

  public void testEachMethodForMapWithKeyValue() throws Throwable {
    doBasicTest();
  }

  public void testEachMethodForMapWithEntry() throws Throwable {
    doBasicTest();
  }

  public void testWithMethod() throws Throwable {
    doBasicTest();
  }

  public void testInjectMethodForCollection() throws Throwable {
    doBasicTest();
  }

  public void testInjectMethodForArray() throws Throwable {
    doBasicTest();
  }

  public void testInjectMethodForMap() throws Throwable {
    doBasicTest();
  }

  public void testClosureDefaultParameterInEachMethod() throws Throwable {
    doBasicTest();
  }

  public void testArrayLikeAccessForList() throws Throwable {
    doBasicTest();
  }

  public void testArrayLikeAccessForMap() throws Throwable {
    doBasicTest();
  }

  public void testEachMethodForRanges() throws Throwable {
    doBasicTest();
  }

  public void testEachMethodForEnumRanges() throws Throwable {
    doBasicTest();
  }

  public void doVariantableTest(String... variants) throws Throwable {
    myFixture.configureByFile(getTestName(false) + ".groovy");
    myFixture.complete(CompletionType.BASIC);
    assertOrderedEquals(myFixture.getLookupElementStrings(), variants);
  }

  public void testNamedParametersForApplication() throws Throwable {
    doVariantableTest("abx", "aby");
  }

  public void testNamedParametersForMethodCall() throws Throwable {
    doVariantableTest("abx", "aby");
  }

  public void testNamedParametersForNotMap() throws Throwable {    
    doBasicTest();
  }

  public void testNamedParametersForConstructorCall() throws Throwable {
    doVariantableTest("hahaha", "hohoho");
  }

  public void testInstanceofHelpsDetermineType() throws Throwable {
    doBasicTest();
  }

  public void testNotInstanceofDoesntHelpDetermineType() throws Throwable {
    myFixture.testCompletion(getTestName(false) + ".groovy", getTestName(false) + ".groovy");
  }

  public void testNotInstanceofDoesntHelpDetermineType2() throws Throwable {
    myFixture.testCompletion(getTestName(false) + ".groovy", getTestName(false) + ".groovy");
  }
}
