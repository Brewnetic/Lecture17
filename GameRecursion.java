/**
 * 🎮 Lecture 17 - Gaming Recursion Examples (Fill in the Blank)
 * 
 * Real RPG mechanics using recursion!
 * Complete each method by finding:
 * 1. BASE CASE - When does the game mechanic stop?
 * 2. RECURSIVE CASE - How does it apply to the next item/enemy/level?
 * 3. RETURN VALUE - What result builds up?
 * 
 * Instructions: Replace all ??? with correct code
 */

public class GameRecursion {

    // ============================================================
    // EXERCISE 1: Distribute XP to Party (Sequential Recursion)
    // ============================================================
    /**
     * Distribute XP to party members recursively
     * Each party member gets their XP, then pass to next member
     * 
     * Example: distributeXP({player1, player2, player3}, 0, 100)
     *   → player1 gets 100 XP
     *   → distributeXP({...}, 1, 100)
     *   → player2 gets 100 XP
     *   → distributeXP({...}, 2, 100)
     *   → player3 gets 100 XP
     * Base case: When we reach the end of party
     * 
     * TODO: COMPLETE THIS
     */
    public static void distributeXP(String[] partyMembers, int index, int xpAmount) {
        // Base case: Stop when we've distributed to all members
        if (???) {
            return;
        }
        
        // Give XP to current party member
        System.out.println(partyMembers[index] + " gains " + xpAmount + " XP");
        
        // Recursive case: Move to next party member
        distributeXP(partyMembers, ???, xpAmount);
    }

    
    // ============================================================
    // EXERCISE 2: Cascade Damage Through Enemies (Tree Recursion)
    // ============================================================
    /**
     * Apply damage effect that cascades to other enemies
     * When you hit enemy, they may hit nearby enemies, who hit others...
     * 
     * Example: 
     *   - Hit Enemy1 with 20 damage
     *   - Enemy1 explodes → hits Enemy2 and Enemy3 with 10 damage each
     *   - Enemy2 explodes → hits Enemy4, etc.
     * 
     * Base case: When enemy is already dead (health ≤ 0)
     * Recursive case: Enemy explodes and hits connected enemies
     * 
     * TODO: COMPLETE THIS
     */
    public static int cascadeDamage(int currentHealth, int damageAmount) {
        // Base case: Stop if enemy is already dead
        if (???) {
            return 0;
        }
        
        // Apply damage to current enemy
        int newHealth = currentHealth - damageAmount;
        System.out.println("Enemy health: " + currentHealth + " → " + newHealth);
        
        // If this enemy dies, they cascade to 2 more enemies with half damage
        if (newHealth <= 0) {
            System.out.println("Enemy explodes! Triggering cascade...");
            int cascade1 = cascadeDamage(100, ???);  // Half damage to next enemy
            int cascade2 = cascadeDamage(100, ???);  // Half damage to another enemy
            return cascade1 + cascade2;
        }
        
        return ???;
    }

    
    // ============================================================
    // EXERCISE 3: Count Dungeon Depth (Linear Recursion)
    // ============================================================
    /**
     * Count how many levels deep in the dungeon
     * Each call represents going down one level
     * 
     * Example: dungeonDepth(5) with 5 floors
     *   Floor 5 → dungeonDepth(4)
     *   Floor 4 → dungeonDepth(3)
     *   Floor 3 → dungeonDepth(2)
     *   Floor 2 → dungeonDepth(1)
     *   Floor 1 → BASE CASE
     * Returns: 5 levels total
     * 
     * TODO: COMPLETE THIS
     */
    public static int countDungeonDepth(int floorsRemaining) {
        // Base case: Reached bottom floor (floor 0 doesn't exist)
        if (???) {
            return 0;
        }
        
        System.out.println("Exploring dungeon floor " + floorsRemaining);
        
        // Recursive case: Go down one floor, count it
        return 1 + countDungeonDepth(???);
    }

    
    // ============================================================
    // EXERCISE 4: Calculate Max Skill Damage (Tree with Comparison)
    // ============================================================
    /**
     * Find highest damage skill in your skill tree
     * Each skill has a damage value and connects to other skills
     * 
     * Skill tree structure:
     *   FireBall (50 damage) → connects to Fireball+ (100 damage)
     *   Fireball+ (100 damage) → connects to Inferno (200 damage)
     *   Inferno (200 damage) → NO CHILDREN (base case)
     * 
     * Result: Return 200 (highest damage in chain)
     * 
     * TODO: COMPLETE THIS
     */
    public static int maxSkillDamage(String skillName, int damage) {
        // Skill tree: skillName → child skill
        // Define your skill tree here:
        // "Fireball" → "FireballPlus" (damage 100)
        // "FireballPlus" → "Inferno" (damage 200)
        // "Inferno" → null (base case)
        
        System.out.println("Checking skill: " + skillName + " (damage: " + damage + ")");
        
        // Base case: No child skill (end of chain)
        if (skillName.equals("Inferno")) {
            return damage;
        }
        
        // Recursive case: Find max of this skill and child skills
        int nextDamage = ???;  // What's next in chain?
        
        if (skillName.equals("Fireball")) {
            nextDamage = maxSkillDamage("FireballPlus", ???);
        } else if (skillName.equals("FireballPlus")) {
            nextDamage = maxSkillDamage("Inferno", ???);
        }
        
        return Math.max(damage, nextDamage);
    }

    
    // ============================================================
    // EXERCISE 5: Calculate Total Inventory Value (Linear Sum)
    // ============================================================
    /**
     * Sum up the total gold value of all items in inventory
     * Recurse through items: item 0 + item 1 + item 2 + ...
     * 
     * Example: Inventory {Sword(50), Shield(30), Potion(10)}
     *   Total = 50 + 30 + 10 = 90 gold
     * 
     * TODO: COMPLETE THIS
     */
    public static int calculateInventoryValue(int[] itemValues, int index) {
        // Base case: Reached end of inventory
        if (???) {
            return 0;
        }
        
        int currentItemValue = itemValues[index];
        System.out.println("Item " + index + ": " + currentItemValue + " gold");
        
        // Recursive case: Current item + rest of inventory
        return ??? + calculateInventoryValue(itemValues, ???);
    }

    
    // ============================================================
    // EXERCISE 6: Spawn Enemy Waves (Tail Recursion)
    // ============================================================
    /**
     * Spawn enemies in waves
     * Wave 1: 2 enemies
     * Wave 2: 2 more enemies (total 4)
     * Wave 3: 2 more enemies (total 6)
     * etc.
     * 
     * Base case: Stop at final wave
     * Recursive case: Spawn this wave, then spawn next wave
     * 
     * TODO: COMPLETE THIS
     */
    public static void spawnWaves(int currentWave, int maxWaves) {
        // Base case: Spawned all waves
        if (???) {
            System.out.println("All waves spawned!");
            return;
        }
        
        // Spawn enemies for this wave
        int enemiesThisWave = 2;
        System.out.println("Wave " + currentWave + ": Spawning " + enemiesThisWave + " enemies");
        
        // Recursive case: Spawn next wave
        spawnWaves(???, maxWaves);
    }

    
    // ============================================================
    // EXERCISE 7: Build Combo Multiplier (Power Formula)
    // ============================================================
    /**
     * Each hit in a combo increases multiplier
     * Combo 1: 1.0x damage
     * Combo 2: 1.5x damage
     * Combo 3: 2.0x damage
     * Combo 4: 2.5x damage
     * etc.
     * 
     * Formula: 1.0 + (comboCount * 0.5)
     * But use recursion!
     * 
     * TODO: COMPLETE THIS
     */
    public static double buildComboMultiplier(int comboCount) {
        // Base case: First hit (combo 1) has 1.0x multiplier
        if (???) {
            return 1.0;
        }
        
        // Recursive case: Each additional hit adds 0.5x
        return buildComboMultiplier(???) + 0.5;
    }

    
    // ============================================================
    // EXERCISE 8: Check Loot Rarity Tier (BONUS - Tree Structure)
    // ============================================================
    /**
     * Items have rarity tiers:
     * Common → Rare → Epic → Legendary
     * 
     * Each tier is a "parent" of the previous
     * Check if item is in Legendary tier by recursing through parents
     * 
     * Base case: Reached "Legendary" (highest tier)
     * Recursive case: Check parent tier
     * 
     * TODO: COMPLETE THIS (BONUS)
     */
    public static boolean isLegendary(String itemTier) {
        System.out.println("Checking tier: " + itemTier);
        
        // Base case: Reached legendary tier
        if (???) {
            return true;
        }
        
        // Base case: Can't go higher, isn't legendary
        if (itemTier.equals("Common")) {
            return false;
        }
        
        // Recursive case: Check parent tier
        String parentTier = ???;  // What's the parent of "Rare"? What of "Epic"?
        
        if (itemTier.equals("Rare")) {
            parentTier = "Epic";
        } else if (itemTier.equals("Epic")) {
            parentTier = "Legendary";
        }
        
        return isLegendary(parentTier);
    }

    
    // ============================================================
    // MAIN - Test all methods
    // ============================================================
    
    public static void main(String[] args) {
        System.out.println("=== 🎮 GAMING RECURSION EXAMPLES ===\n");
        
        // Test Exercise 1: Distribute XP
        System.out.println("Exercise 1: Distribute XP to Party");
        String[] party = {"Warrior", "Mage", "Archer"};
        distributeXP(party, 0, 100);
        System.out.println();
        
        // Test Exercise 2: Cascade Damage
        System.out.println("Exercise 2: Cascade Damage");
        int finalHealth = cascadeDamage(20, 20);
        System.out.println("Cascade damage dealt!\n");
        
        // Test Exercise 3: Dungeon Depth
        System.out.println("Exercise 3: Dungeon Depth");
        int depth = countDungeonDepth(5);
        System.out.println("Total dungeon depth: " + depth + " floors\n");
        
        // Test Exercise 4: Max Skill Damage
        System.out.println("Exercise 4: Max Skill Damage");
        int maxDamage = maxSkillDamage("Fireball", 50);
        System.out.println("Max skill damage: " + maxDamage + "\n");
        
        // Test Exercise 5: Inventory Value
        System.out.println("Exercise 5: Calculate Inventory Value");
        int[] inventory = {50, 30, 10, 25};
        int totalValue = calculateInventoryValue(inventory, 0);
        System.out.println("Total inventory value: " + totalValue + " gold\n");
        
        // Test Exercise 6: Spawn Waves
        System.out.println("Exercise 6: Spawn Enemy Waves");
        spawnWaves(1, 3);
        System.out.println();
        
        // Test Exercise 7: Combo Multiplier
        System.out.println("Exercise 7: Combo Multiplier");
        System.out.println("Combo 1: " + buildComboMultiplier(1) + "x damage");
        System.out.println("Combo 3: " + buildComboMultiplier(3) + "x damage");
        System.out.println("Combo 5: " + buildComboMultiplier(5) + "x damage\n");
        
        // Test Exercise 8: Loot Rarity (BONUS)
        System.out.println("Exercise 8: Check Loot Rarity (BONUS)");
        System.out.println("Is Legendary: " + isLegendary("Legendary"));
        System.out.println("Is Common Legendary: " + isLegendary("Common"));
    }
}