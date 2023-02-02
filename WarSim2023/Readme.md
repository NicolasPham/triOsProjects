# Welcome to WarSim 2023 Made by Nicolas Pham

### Setup Game:
- There will be 3 types of Warrior : Human, Elf, Orc

    - Human: 2 types for Knight, Priest (staminia = 30 points, Speed/Dexterity 80)
      - Knight:
        > Health: 800-880
        > Defend: 130
        > Damage: 120
        > Special Ability: Unbreakable: + 60 Defend, -8 staminia
      - Priest:
        > Health: 550-650
        > Defend: 90
        > Damage: 100
        > Special Ability: Heal: + 90 Health, -10 staminia

    - Elf: 2 types for Assasin, Sorcerer (staminia = 70 points, damage = 160)
      - Assasin:
        > Health: 400-500
        > Defend: 100
        > Speed / Dexterity: 100
        > Special Ability: Critial Strike: + 45 Damage, -8 staminia
      - Archer:
        > Health: 450-650
        > Defend: 80
        > Speed / Dexterity: 120
        > Special Ability: Fireball: + 90 Speed, -10 staminia

    - Orc: 2 types for Barbarian, Witcher (staminia = 10 points, Health = 900-1100)
      - Barbarian:
        > Defend: 170
        > Damage: 130
        > Speed / Dexterity: 20
        > Special Ability: Smash: + 20 Damage, -5 staminia
      - Witcher:
        > Defend: 60
        > Damage: 120 points
        > Speed / Dexterity: 60
        > Special Ability: Poison Gas: - 90 defend, -5 staminia

  #### Weapon class:
  - Axe:
    > Damage: + 70
    > Speed: - 20
    > defend: + 20
  - Sword 
    > Damage: + 40
    > Speed: + 20
    > defend: + 40
  - Bow:
    > Damage: + 90
    > Speed: + 30
    > defend: - 10
  - Dagger:
    > Damage: + 25
    > Speed: + 50
    > defend: - 10
  - Riftmaker:
    > Damage: + 90
    > Speed: - 20
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