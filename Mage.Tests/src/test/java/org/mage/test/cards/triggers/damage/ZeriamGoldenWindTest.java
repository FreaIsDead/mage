package org.mage.test.cards.triggers.damage;

import mage.constants.PhaseStep;
import mage.constants.Zone;
import org.junit.Test;
import org.mage.test.serverside.base.CardTestPlayerBase;

public class ZeriamGoldenWindTest extends CardTestPlayerBase {
    @Test
    public void testCombatDamage() {
        setLife(playerA,20);
        setLife(playerB,20);

        addCard(Zone.BATTLEFIELD, playerA, "Zeriam, Golden Wind", 1); // 3/4
        addCard(Zone.BATTLEFIELD, playerB, "Zeriam, Golden Wind", 1);

        attack(1, playerA, "Zeriam, Golden Wind");
        attack(3, playerA, "Zeriam, Golden Wind");
        attack(3, playerA, "Griffin Token"); // 2/2

        setStopAt(3, PhaseStep.END_TURN);
        execute();

        assertLife(playerB, 20-3-3-2);
        assertPermanentCount(playerA, "Griffin Token",3);
    }
}
