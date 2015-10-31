/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Shannon Murphy
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({PlayerTest.class, TableTest.class, DeckTest.class, DealerTest.class, HandTest.class, CardTest.class})
public class BackEndTestSuite { 
    
}
