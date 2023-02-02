# What have I done in this project?

- Rename, remake all warriors, armors, weapon
- Add special ability to each class of warrior


# Knowledge applied:
- Use array to create armor, weapon for a cleaner code
- Create a setup file in utils for creating warrior, armor, weapon instead of putting in Battle.java. Just simply call the function in the battle when setting up the game
- use printf for formatting printing options with arguments for easier when change the number later. For that reason, I have to remove abstract in Armor and Weapon class
- Combine for loop and printf to shorten the print function in Printer.java


# Points Count:
- Easy:
    > 1 point: add another child to the warrior
    > 1 point: add validation for all inputs

- Medium:
    > 3 points: add magic attack (special skill depends on each Warrior type)

- Hard:
    > 5 points: Create a polymorphic special ability based on the warrior class (use staminia to cast skill)
    > 7 points: Subtype children from the warrior (Human has Knight and Priest, Elf has Assasin and Archer, Orc has Barbarian and Witcher)