/**
 * 🎮 Lecture 17 - Gaming Unit Tests with JUnit (Fill in the Blank)
 * 
 * Test game mechanics using JUnit!
 * Fix the GameCharacter class by writing correct test cases.
 * 
 * Required: JUnit 5 (Jupiter)
 * 
 * To run in VS Code:
 * - Install Extension Pack for Java
 * - Right-click test file → Run Tests
 * - Green ✓ = test passes, Red ✗ = test fails
 * 
 * Instructions: Replace all ??? with correct code
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameTesting {

    // ============================================================
    // EXERCISE 1: Test Player Health - Basic Damage
    // ============================================================
    
    /**
     * Test: Player takes damage
     * Start: 100 HP
     * Action: Take 20 damage
     * Expected: 80 HP
     * 
     * TODO: COMPLETE THIS
     */
    @Test
    void takeDamage_reducesHealth_givenValidDamageAmount() {
        GameCharacter player = new GameCharacter("Hero", 100);
        
        // Act: Player takes 20 damage
        player.takeDamage(20);
        
        // Assert: Should have 80 HP left
        assertEquals(???, player.getHealth());
    }
    
    
    /**
     * Test: Player heals
     * Start: 50 HP
     * Action: Heal 30 HP
     * Expected: 80 HP
     * 
     * TODO: COMPLETE THIS
     */
    @Test
    void heal_increasesHealth_givenValidHealAmount() {
        GameCharacter player = new GameCharacter("Hero", 100);
        player.takeDamage(50);  // Reduce to 50 HP
        
        // Act: Heal 30 HP
        player.heal(30);
        
        // Assert: Should have 80 HP
        assertEquals(???, player.getHealth());
    }


    // ============================================================
    // EXERCISE 2: Test Health Boundaries
    // ============================================================
    
    /**
     * Test: Player can't heal above max health
     * Start: 90 HP (max 100)
     * Action: Heal 20 HP
     * Expected: 100 HP (clamped to max, not 110!)
     * 
     * This is an EDGE CASE - critical for games!
     * Many games have bugs where healing can overflow
     * 
     * TODO: COMPLETE THIS
     */
    @Test
    void heal_clamps_toMaxHealth_givenHealOverflow() {
        GameCharacter player = new GameCharacter("Hero", 100);
        player.takeDamage(10);  // Reduce to 90 HP
        
        // Act: Try to heal 20 HP (would be 110)
        player.heal(20);
        
        // Assert: Should be clamped to 100, not 110!
        assertEquals(???, player.getHealth());
    }
    
    
    /**
     * Test: Player dies when health reaches 0
     * Start: 100 HP
     * Action: Take 100 damage
     * Expected: Dead (health = 0)
     * 
     * TODO: COMPLETE THIS
     */
    @Test
    void takeDamage_kills_whenDamageExceedsHealth() {
        GameCharacter player = new GameCharacter("Hero", 100);
        
        // Act: Take fatal damage
        player.takeDamage(100);
        
        // Assert: Should be dead
        assertEquals(???, player.getHealth());
    }
    
    
    /**
     * Test: Player stays dead (can't heal below 0 or have negative health)
     * Start: 100 HP
     * Action: Take 120 damage (overkill)
     * Expected: 0 HP (not -20!)
     * 
     * TODO: COMPLETE THIS
     */
    @Test
    void takeDamage_preventsNegativeHealth_givenExcessiveDamage() {
        GameCharacter player = new GameCharacter("Hero", 100);
        
        // Act: Take 120 damage (more than max health)
        player.takeDamage(120);
        
        // Assert: Should be 0, not -20!
        assertEquals(???, player.getHealth());
    }


    // ============================================================
    // EXERCISE 3: Test Mana System
    // ============================================================
    
    /**
     * Test: Spell casting drains mana
     * Start: 100 mana
     * Action: Cast spell (costs 30 mana)
     * Expected: 70 mana
     * 
     * TODO: COMPLETE THIS
     */
    @Test
    void castSpell_drainsMana_givenSufficientMana() {
        GameCharacter mage = new GameCharacter("Mage", 100);
        mage.setMana(100);
        
        // Act: Cast spell that costs 30 mana
        mage.castSpell(30);
        
        // Assert: Should have 70 mana
        assertEquals(???, mage.getMana());
    }
    
    
    /**
     * Test: Can't cast spell without enough mana
     * Start: 20 mana
     * Action: Try to cast spell (costs 30 mana)
     * Expected: Spell fails, mana unchanged
     * 
     * TODO: COMPLETE THIS
     */
    @Test
    void castSpell_fails_whenInsufficientMana() {
        GameCharacter mage = new GameCharacter("Mage", 100);
        mage.setMana(20);
        
        // Act: Try to cast spell that costs 30 mana
        boolean success = mage.castSpell(30);
        
        // Assert: Should fail and mana should stay at 20
        assertFalse(success);
        assertEquals(???, mage.getMana());
    }


    // ============================================================
    // EXERCISE 4: Test Inventory System
    // ============================================================
    
    /**
     * Test: Add item to inventory
     * Start: 0 items
     * Action: Add sword
     * Expected: 1 item, has sword
     * 
     * TODO: COMPLETE THIS
     */
    @Test
    void addItem_increasesInventory_givenItem() {
        GameCharacter player = new GameCharacter("Hero", 100);
        
        // Act: Add item
        player.addItem("Sword");
        
        // Assert: Should have 1 item now
        assertEquals(???, player.getInventorySize());
    }
    
    
    /**
     * Test: Can't exceed inventory limit
     * Start: Empty inventory (capacity: 5)
     * Action: Try to add 6 items
     * Expected: Last item rejected, inventory has 5
     * 
     * TODO: COMPLETE THIS
     */
    @Test
    void addItem_rejects_whenInventoryFull() {
        GameCharacter player = new GameCharacter("Hero", 100);
        
        // Act: Add 6 items to inventory with capacity 5
        player.addItem("Item1");
        player.addItem("Item2");
        player.addItem("Item3");
        player.addItem("Item4");
        player.addItem("Item5");
        boolean added = player.addItem("Item6");  // Should fail
        
        // Assert: Last item rejected, inventory is 5
        assertFalse(added);
        assertEquals(???, player.getInventorySize());
    }
    
    
    /**
     * Test: Remove item from inventory
     * Start: 3 items
     * Action: Remove 1 item
     * Expected: 2 items
     * 
     * TODO: COMPLETE THIS
     */
    @Test
    void removeItem_decreasesInventory_givenItem() {
        GameCharacter player = new GameCharacter("Hero", 100);
        player.addItem("Sword");
        player.addItem("Shield");
        player.addItem("Potion");
        
        // Act: Remove sword
        player.removeItem("Sword");
        
        // Assert: Should have 2 items now
        assertEquals(???, player.getInventorySize());
    }


    // ============================================================
    // EXERCISE 5: Test XP and Leveling
    // ============================================================
    
    /**
     * Test: Gain XP below threshold doesn't level up
     * Start: Level 1, 0 XP (threshold: 100 XP to level up)
     * Action: Gain 50 XP
     * Expected: Still level 1
     * 
     * TODO: COMPLETE THIS
     */
    @Test
    void gainXP_noLevelUp_givenInsufficientXP() {
        GameCharacter player = new GameCharacter("Hero", 100);
        
        // Act: Gain 50 XP (less than 100 needed)
        player.gainXP(50);
        
        // Assert: Should still be level 1
        assertEquals(???, player.getLevel());
    }
    
    
    /**
     * Test: Gain XP at threshold levels up
     * Start: Level 1, 0 XP
     * Action: Gain 100 XP (exactly threshold)
     * Expected: Level 2
     * 
     * TODO: COMPLETE THIS
     */
    @Test
    void gainXP_levelUp_givenSufficientXP() {
        GameCharacter player = new GameCharacter("Hero", 100);
        
        // Act: Gain 100 XP (exactly threshold)
        player.gainXP(100);
        
        // Assert: Should be level 2
        assertEquals(???, player.getLevel());
    }


    // ============================================================
    // EXERCISE 6: Test Damage Calculation (Critical Hits!)
    // ============================================================
    
    /**
     * Test: Normal attack does base damage
     * Base damage: 25
     * Action: Normal attack (no crit)
     * Expected: 25 damage
     * 
     * TODO: COMPLETE THIS
     */
    @Test
    void calculateDamage_returnsBasis_givenNormalHit() {
        GameCharacter player = new GameCharacter("Warrior", 100);
        
        // Act: Calculate normal damage
        int damage = player.calculateDamage(false);  // false = no crit
        
        // Assert: Should be base damage (25)
        assertEquals(???, damage);
    }
    
    
    /**
     * Test: Critical hit doubles damage
     * Base damage: 25
     * Action: Critical hit
     * Expected: 50 damage
     * 
     * TODO: COMPLETE THIS
     */
    @Test
    void calculateDamage_returnsCritical_givenCriticalHit() {
        GameCharacter player = new GameCharacter("Warrior", 100);
        
        // Act: Calculate damage with critical
        int damage = player.calculateDamage(true);  // true = crit
        
        // Assert: Should be base * 2 (50)
        assertEquals(???, damage);
    }
    
    
    /**
     * Test: Critical hit with max stat doesn't overflow
     * This is the ARIANE 5 BUG!
     * Base damage: 999 (max stat)
     * Critical: 999 * 2 = 1998 (shouldn't overflow)
     * 
     * TODO: COMPLETE THIS
     */
    @Test
    void calculateDamage_handles_maxStatCritical() {
        GameCharacter maxWarrior = new GameCharacter("MaxWarrior", 100);
        maxWarrior.setBaseDamage(999);  // Max stat
        
        // Act: Critical hit with max damage
        int damage = maxWarrior.calculateDamage(true);
        
        // Assert: Should be 1998, positive, and not overflow
        assertEquals(???, damage);
        assertTrue(damage > 0);  // Shouldn't be negative from overflow!
    }


    // ============================================================
    // EXERCISE 7: Test Buff/Debuff Stacking
    // ============================================================
    
    /**
     * Test: Apply single buff
     * Start: 1.0x multiplier
     * Action: Apply damage buff (+20% = 1.2x)
     * Expected: 1.2x multiplier
     * 
     * TODO: COMPLETE THIS
     */
    @Test
    void applyBuff_increases_damageMultiplier() {
        GameCharacter player = new GameCharacter("Hero", 100);
        
        // Act: Apply 1.2x damage buff
        player.applyBuff("damage", 1.2);
        
        // Assert: Should have 1.2x multiplier
        assertEquals(???, player.getDamageMultiplier());
    }
    
    
    /**
     * Test: Multiple buffs multiply together (1.2 * 1.5 = 1.8)
     * Start: 1.0x
     * Action: Apply 1.2x buff, then 1.5x buff
     * Expected: 1.8x multiplier
     * 
     * TODO: COMPLETE THIS
     */
    @Test
    void applyBuff_stacks_multiplying() {
        GameCharacter player = new GameCharacter("Hero", 100);
        
        // Act: Apply two buffs
        player.applyBuff("damage", 1.2);
        player.applyBuff("damage", 1.5);
        
        // Assert: Should multiply to 1.8x
        assertEquals(???, player.getDamageMultiplier(), 0.01);  // 0.01 = tolerance for floats
    }


    // ============================================================
    // EXERCISE 8: Test Game Over Conditions
    // ============================================================
    
    /**
     * Test: Player not dead while at full health
     * Start: 100 HP
     * Expected: isAlive() returns true
     * 
     * TODO: COMPLETE THIS
     */
    @Test
    void isAlive_returnsTrue_givenHealthAboveZero() {
        GameCharacter player = new GameCharacter("Hero", 100);
        
        // Assert: Should be alive
        assertTrue(???);  // What method should return true?
    }
    
    
    /**
     * Test: Player dead at 0 health
     * Start: 100 HP, take 100 damage
     * Expected: isAlive() returns false
     * 
     * TODO: COMPLETE THIS
     */
    @Test
    void isAlive_returnsFalse_givenHealthAtZero() {
        GameCharacter player = new GameCharacter("Hero", 100);
        player.takeDamage(100);
        
        // Assert: Should be dead
        assertFalse(???);  // What method should return false?
    }


    // ============================================================
    // EXERCISE 9: Test for Exception (Bonus)
    // ============================================================
    
    /**
     * Test: Level up with invalid XP throws exception
     * Action: Try to gain negative XP
     * Expected: Throws IllegalArgumentException
     * 
     * Syntax: assertThrows(ExceptionClass.class, () -> { code });
     * 
     * TODO: COMPLETE THIS (BONUS)
     */
    @Test
    void gainXP_throwsException_givenNegativeXP() {
        GameCharacter player = new GameCharacter("Hero", 100);
        
        // Assert: Should throw exception for negative XP
        assertThrows(???, () -> {
            player.gainXP(-50);  // Negative XP!
        });
    }


    // ============================================================
    // EXERCISE 10: Complex Test - Full Battle Scenario (BONUS)
    // ============================================================
    
    /**
     * Test: Complete battle scenario
     * 1. Player at full health (100)
     * 2. Take 30 damage (70 left)
     * 3. Cast heal spell (100 health)
     * 4. Add loot to inventory
     * 5. Gain XP to level up
     * 
     * All assertions must pass!
     * 
     * TODO: COMPLETE THIS (BONUS)
     */
    @Test
    void fullBattle_scenario_multipleActions() {
        GameCharacter player = new GameCharacter("Hero", 100);
        player.setMana(100);
        
        // Act 1: Take damage
        player.takeDamage(30);
        assertEquals(???, player.getHealth());  // Should be 70
        
        // Act 2: Cast heal spell
        player.castSpell(20);  // Spend 20 mana to heal 40 HP
        assertEquals(???, player.getHealth());  // Should be 100 (clamped)
        
        // Act 3: Add loot
        player.addItem("GoldenSword");
        assertEquals(???, player.getInventorySize());  // Should be 1
        
        // Act 4: Gain XP to level up
        player.gainXP(100);
        assertEquals(???, player.getLevel());  // Should be 2
    }

}


// ============================================================
// GAME CHARACTER CLASS (what we're testing)
// ============================================================

/**
 * Game Character - RPG hero class
 * Contains all game mechanics we test
 */
class GameCharacter {
    private String name;
    private int health;
    private int maxHealth;
    private int mana = 100;
    private int level = 1;
    private int xp = 0;
    private int baseDamage = 25;
    private double damageMultiplier = 1.0;
    private String[] inventory = new String[5];  // Max 5 items
    private int inventoryCount = 0;
    
    public GameCharacter(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }
    
    // Health methods
    public void takeDamage(int damage) {
        health = Math.max(0, health - damage);
    }
    
    public void heal(int amount) {
        health = Math.min(maxHealth, health + amount);
    }
    
    public int getHealth() { return health; }
    
    // Mana methods
    public void setMana(int amount) { this.mana = amount; }
    public int getMana() { return mana; }
    public boolean castSpell(int manaCost) {
        if (mana >= manaCost) {
            mana -= manaCost;
            return true;
        }
        return false;
    }
    
    // Level/XP methods
    public int getLevel() { return level; }
    public void gainXP(int amount) {
        if (amount < 0) throw new IllegalArgumentException("XP cannot be negative!");
        xp += amount;
        if (xp >= 100) {
            level++;
            xp -= 100;
        }
    }
    
    // Damage methods
    public int calculateDamage(boolean isCritical) {
        int damage = baseDamage;
        if (isCritical) {
            damage *= 2;
        }
        return (int)(damage * damageMultiplier);
    }
    
    public void setBaseDamage(int damage) { this.baseDamage = damage; }
    
    // Buff methods
    public void applyBuff(String buffType, double multiplier) {
        if ("damage".equals(buffType)) {
            damageMultiplier *= multiplier;
        }
    }
    
    public double getDamageMultiplier() { return damageMultiplier; }
    
    // Inventory methods
    public boolean addItem(String item) {
        if (inventoryCount >= inventory.length) return false;
        inventory[inventoryCount++] = item;
        return true;
    }
    
    public void removeItem(String item) {
        for (int i = 0; i < inventoryCount; i++) {
            if (inventory[i].equals(item)) {
                inventory[i] = inventory[inventoryCount - 1];
                inventoryCount--;
                break;
            }
        }
    }
    
    public int getInventorySize() { return inventoryCount; }
    
    // Status methods
    public boolean isAlive() { return health > 0; }
}
