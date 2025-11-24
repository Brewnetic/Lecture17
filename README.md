# 🎮 Lecture 17: Recursion & Testing in Gaming
## RPG Mechanics Edition
---
## 📄 Files
- `GameRecursion.java` - Gaming recursion examples (fill in the blank)
- `GameTesting.java` - Gaming unit tests with JUnit (fill in the blank)

---

## 🎮 Gaming Scenarios

### **Recursion Examples**
1. **Party XP Distribution** - Distribute XP to party recursively
2. **Damage Cascade** - Apply status effects that trigger more effects
3. **Dungeon Depth Counter** - Count levels of nested dungeons
4. **Skill Tree Navigation** - Find max skill damage through prerequisites
5. **Inventory Sorting** - Calculate total item value recursively
6. **Enemy Wave Spawning** - Spawn enemies in waves
7. **Combo Counter** - Build multiplier chains
8. **Loot Rarity Tree** - Check rarity through inheritance chain

### **Testing Examples (JUnit)**
1. **Player Health Management** - Test damage/healing edge cases
2. **Mana System** - Test spell casting, mana overflow
3. **Inventory Limits** - Test item stacking and capacity
4. **XP to Level Conversion** - Test level thresholds
5. **Damage Calculation** - Test crit chance, bonuses
6. **Game Over Conditions** - Test death detection
7. **Buff/Debuff Stacking** - Test stat multipliers
8. **Gold Currency** - Test transaction edge cases

---

## 📚 Learning Goals

### Recursion in Gaming
- ✅ Identify base cases (reached max dungeon level, no more combos, etc.)
- ✅ Build recursive logic (next wave, next skill, etc.)
- ✅ Trace through game recursion on paper
- ✅ Understand stack behavior in game systems
- ✅ Avoid infinite loops in game mechanics
- ✅ Implement realistic game algorithms

### Testing Game Mechanics
- ✅ Test player damage calculations
- ✅ Test inventory edge cases
- ✅ Test game-over conditions
- ✅ Test stat overflow/underflow
- ✅ Test buff stacking
- ✅ Test resource management
- ✅ Catch game-breaking bugs before release

---

## 🔑 Key Concepts

### Recursion Patterns in Games
| Pattern | Gaming Example | Base Case |
|---------|---|---|
| **Linear Recursion** | Walk down dungeon floors | Reached bottom level |
| **Tree Recursion** | Damage cascades on enemies | No more enemies affected |
| **Tail Recursion** | Spawn enemy waves | Wave count reached |
| **Mutual Recursion** | Team members call allies | No allies left to call |

### Game Testing Concepts
| Test Type | Gaming Example | What We Check |
|-----------|---|---|
| **Equality** | Damage = 25 | Exact damage values |
| **Boolean** | Is player dead? | True/false states |
| **Null Check** | Is inventory full? | Item doesn't exist |
| **Exception** | Cast spell with no mana | Exception thrown |
| **Edge Case** | Max health +1 damage | Overflow handling |

---

## 💡 Real Gaming Examples

### Recursion: Dungeon Traversal
```
Navigate dungeon with recursion:
- Base case: Reached bottom level (boss room)
- Recursive case: Move to next level, call recursively
- Perfect for: Procedurally generated dungeons
```

### Testing: Health System
```
Test cases:
- Player has 100 HP
- Takes 50 damage → 50 HP
- Takes 60 damage → Game Over (caught by test!)
- Heal with overflow → Clamped to max
```

### Real Bug Story: Integer Overflow in Damage
Many games have had bugs where:
- Damage calculated as: `damage = baseAtk * critMultiplier`
- With max attack (999) × 999 crit multiplier = overflow!
- Test catches: `testDamage_handlesMaxValues_givenCriticalHit()`
- Player gets one-shot instead of challenging combat

---

## 🎮 When to Use Recursion in Games (Some Use Cases)

| Scenario | Use Recursion? | Gaming Example |
|----------|---|---|
| Nested game menus | ✓ YES | Menu → Submenu → Item |
| Dungeon levels | ✓ YES | Level 1 → Level 2 → Boss |
| Skill prerequisites | ✓ YES | Skill requires another skill |
| Equipment rarity tiers | ✓ YES | Epic contains Rare contains Common |
| Simple loops | ✗ NO | Spawn 10 enemies (use for loop!) |
| Time-critical updates | ✗ NO | Game physics tick (use iteration!) |
| Deep nesting (20+) | ✗ NO | Stack overflow risk |

---

## 📊 Test Coverage for Games

Essential game tests:
```
✓ Health: 0 to MAX_VALUE
✓ Mana: 0 to MAX_VALUE
✓ Damage: Negative to MAX_VALUE
✓ Inventory: 0 items to max capacity
✓ Buffs: None to multiple stacking
✓ Level: 1 to 99
✓ XP: Overflow, underflow, exact thresholds
✓ Status Effects: None, single, multiple
✓ Equipment: Unequipped, equipped, broken
✓ Conditions: Alive, dead, stunned, frozen
```

---

## ❌ Common Game Programming Bugs (Caught by Tests!)

| Bug | Test That Catches It | Example |
|---|---|---|
| Health > MAX_HEALTH | `testHeal_clamps_toMaxHealth()` | Heal overflow |
| Damage causes INT overflow | `testDamage_handles_maxDamage()` | 999 * 999 |
| Negative inventory | `testInventory_prevents_negativCount()` | Remove more than owned |
| Infinite combo | `testCombo_stops_atMaxChain()` | Base case missing |
| Mana becomes negative | `testMana_preventsNegative()` | Cast without checking |
| Level skip | `testLevelProgression_sequential()` | XP math wrong |
| Buff stacking crash | `testBuffs_multiple_stacking()` | Array index out of bounds |

---

## 📋 Gaming Test Naming Convention

```
✅ GOOD:
testPlayerHealth_dies_whenHealthReachesZero()
testDamage_causesOverflow_givenMaxAttackAndCrit()
testInventory_rejectsItem_whenAtCapacity()
testCombo_multiplier_increases_withChainLength()
testBuff_stacking_caps_atMaximum()

❌ BAD:
test1()
testHealth()
testDamage()
```

When `testDamage_causesOverflow_givenMaxAttackAndCrit() FAILS`, you know exactly what's wrong!

---

## 🔧 Setup for Gaming Examples

### RecursionExample Covers:
- Party member XP distribution
- Cascading damage effects
- Dungeon depth calculation
- Skill tree traversal
- Combo chain building
- Bonus: Loot rarity chains

### TestingExample Covers:
- Player damage/healing
- Health boundaries
- Inventory limits
- Mana management
- Buff stacking
- Game-over detection
- Bonus: Critical hit overflow

---