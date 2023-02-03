# Welcome to WarSim 2023 Made by Nicolas Pham

### Setup Game:
- There will be 3 types of Warrior : Human, Elf, Orc

    - Human: 2 types for Knight, Priest (staminia = 30 points, Speed/Dexterity 60)
      - Knight:
        > Health: 800-880
        > Defend: 65
        > Damage: 60
        > Special Ability: Unbreakable: + 60 Defend, -8 staminia
      - Priest:
        > Health: 550-650
        > Defend: 45
        > Damage: 50
        > Special Ability: Heal: + 90 Health, -10 staminia

    - Elf: 2 types for Assasin, Sorcerer (staminia = 70 points, damage = 80)
      - Assasin:
        > Health: 400-500
        > Defend: 50
        > Speed / Dexterity: 80
        > Special Ability: Critial Strike: + 70 Damage, -8 staminia
      - Archer:
        > Health: 450-650
        > Defend: 40
        > Speed / Dexterity: 70
        > Special Ability: Fireball: + 60 Speed, -10 staminia

    - Orc: 2 types for Barbarian, Witcher (staminia = 10 points, Health = 900-1100)
      - Barbarian:
        > Defend: 85
        > Damage: 65
        > Speed / Dexterity: 20
        > Special Ability: Smash: + 60 Damage, -5 staminia
      - Witcher:
        > Defend: 30
        > Damage: 60 points
        > Speed / Dexterity: 40
        > Special Ability: Poison Gas: + 30 Damage, -10 staminia

  #### Weapon class:
  - Axe:
    > Damage: + 100
    > Speed: - 20
    > defend: + 20
  - Sword 
    > Damage: + 85
    > Speed: + 10
    > defend: + 5
  - Bow:
    > Damage: + 105
    > Speed: + 15
    > defend: - 20
  - Dagger:
    > Damage: + 70
    > Speed: + 40
    > defend: - 10
  - Riftmaker:
    > Damage: + 120
    > Speed: 0
    > defend: -20

  #### Armor class:
  - Leather:
    > Defend: + 40
    > Speed: + 40
  - Chain shirt
    > Defend: + 60
    > Speed: + 20
  - BreastPlate
    > Defend: + 80
    > Speed: + 0

### Logic Combat:
- 3 types of attack:
 > basic: regular damage, more luck from 0 - 100 -> less chance to miss
 > swing: + 20-50 additionalDamage, cost 3 points staminia, luck 0-60
 > special skill: never miss, cost more staminia
- when receive damage: receiver will gain 5 staminia each time
- "luck" affect on strike?:
   > luck < 40: miss
   > 40 < luck < 80 : attack has additional damage
   > luck > 80: special skill

   > speed Difference: if speedDiff > 0 -> return additional damage = random(speedDiff);


- Skill:
  > IF staminia > skill cost -> player can cast the skill. Depends on the skill, additional number will be added accordingly. And remove accordingly after using the skill so next turn all damage will be back to normal
  > For bot: if stamninia > skill cost, create a random Number, if that number > 50, then the bot will cast the skill
- Hit / Dodge:
  - What add into Chance of Hit?
    > a = random Number from 0-50
    > b = Striker speed - receiver speed
    > HitChance = a + b >= 50 then striker hit the target
    
    > c = HitChane - 50 : the additional % damage to the striker
- Total Damage:
  > totalDamage = damage - defend
  > Health -= total