package com.develogical;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueryProcessorTest {

  QueryProcessor queryProcessor = new QueryProcessor();

  @Test
  public void knowsWhoWroteRomeoAndJuliet() throws Exception {
    assertThat(queryProcessor.process("Who wrote Romeo And Juliet"), containsString("Shakespeare"));
  }

  @Test
  public void isNotCaseSensitive() throws Exception {
    assertThat(queryProcessor.process("who wrote romeo and juliet"), containsString("Shakespeare"));
  }

  @Test
  public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
    assertThat(queryProcessor.process("test"), is(""));
  }

  @Test
  public void largest() {
    Assert.assertEquals(queryProcessor.process("5f6da380:%20which%20of%20the%20following%20numbers%20is%20the%20largest:%20387,%2098"), "387");
  }

  @Test
  public void largest1() {
    Assert.assertEquals(queryProcessor.process("8611b2a0:%20which%20of%20the%20following%20numbers%20is%20the%20largest:%207,%20726"), "726");
  }
  @Test
  public void plus() {
    Assert.assertEquals(queryProcessor.process("362f1550:%20what%20is%208%20plus%203"), "11");
  }

  @Test
  public void plus1() {
    Assert.assertEquals(queryProcessor.process("c06b6750:%20what%20is%204%20plus%206"), "10");
  }

  @Test
  public void multiplied() {
    Assert.assertEquals(queryProcessor.process("f28e8630:%20what%20is%206%20multiplied%20by%209"), "54");
  }

  @Test
  public void primes() {
    Assert.assertEquals(queryProcessor.process("a4f7e3a0:%20which%20of%20the%20following%20numbers%20are%20primes:%20461,%205"), "461, 5");
  }
}
