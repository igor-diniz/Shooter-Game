## LDTS_T10_G1002 - FATE

### Game Description

This project consists in a 2D looter shooter game, where the inspirations are Destiny and Pokemon.
The game consists of one player and different monsters, which depend on different levels. The player has 3 types of weapons with their own characteristics, which are used to kill monsters and get to the next level. Monsters can also shoot the player, and depending on which one it is, it may have more health and deal more damage than others.

This project was developed by Eduardo da Silva (up202004999@fe.up.pt), Ian Gomes (up202000707@fe.up.pt) and Igor Diniz (up202000162@fe.up.pt) for LDTS 2021-22.

### Implemented Features

- **Buttons** - Functional and interactive buttons.
- **Keyboard control** - The keyboard inputs are received through the respective events and interpreted according to the current game state.
- **Player control** - The player may move with the keyboard control (keys - a,w,s,d) and shoot his gun when the space-bar is pressed.
- **Animations** - In this game, damage caused by the player or by the enemies is seen in animated forms.
- **Connected Menus** - The user has the capability of browsing through the different menus including in game ones. (Ex: Main Menu, Instructions, Play, Pause).
- **Collisions detection** - Collisions between different objects are verified. (Ex: Player, Bullet, Enemies, Obstacles).
- **Different levels** - 8 different levels with an increasing difficulty were implemented.
- **Different weapons** - 3 different types of weapons and 7 weapons (3 primaries, 2 specials and 2 heavies).
- **Different enemies** - 6 different types of monsters with distinct speed, health and damage.

### Planned Features
All planned features were implemented.

###  **Overview**

![](gifs/gamePreview.gif)
<p>
  <b><i>Gif 1. Overview of FATE game</i></b>
</p>
<br>
<br />

![](gifs/damageAnimation.gif)
<p>
  <b><i>Gif 2. Damage caused by the shoots</i></b>
</p>

<br>
<br />

###  **GUI Mockups**
### Menus
![](images/screenshots/mainMenu.png)
<p>
  <b><i>Fig 1. Main Menu </i></b>
</p>

<br>
<br />

![](images/screenshots/instructionsMenu.png)
<p>
  <b><i>Fig 2. Instructions Menu </i></b>
</p>

<br>
<br />

![](images/screenshots/inventoryMenu.png)
<p>
  <b><i>Fig 3. Inventory Menu </i></b>
</p>  


### Enemies

![](images/screenshots/dreg.png)
<p>
  <b><i>Fig 4. Dreg Enemy </i></b>
</p>  

<br>
<br />

![](images/screenshots/vandal.png)
<p>
  <b><i>Fig 5. Vandal Enemy </i></b>
</p>  

<br>
<br />

![](images/screenshots/captain.png)
<p>
  <b><i>Fig 6. Captain Enemy </i></b>
</p>  

<br>
<br />

### Design

### Creating new Enemies


**Problem in Context**

As new types of enemies were created, it was necessary to make big changes in the main code of the game, in order to change the behavior of the game according to the enemy that had been created. Thus, many conditionals were needed to effect this behavior change.

**The Pattern**

The factory method pattern was used to replace direct entity construction methods with calls to an enemy factory. This pattern allowed to solve the problem, since it was possible to create enemies without significantly changing the code, through the abstract method generateCharacter.

**Implementation**

The following figure shows how the pattern’s roles were mapped to the application classes.
<br></br>
![](images/UML/factoryMethodEnemies.png)
<br>
  <b><i>Fig 7. Factory Method implementation</i></b>
</br>  

These classes can be found in the following files:

- [Entity](../src/main/java/game/entities/Entity.java)
- [Enemy](../src/main/java/game/enemies/Enemy.java)
- [Captain](../src/main/java/game/enemies/Captain.java)
- [Dreg](../src/main/java/game/enemies/Dreg.java)
- [Vandal](../src/main/java/game/enemies/Vandal.java)

**Consequences**

The use of the Factory Method Pattern in the current design allows the following benefits:

- It's very easy to add new enemies to the game without having to make changes to the main code.
- Removes the need to recreate the same code every time a new enemy is created.




### Changing game state

**Problem in Context**

As the number of states of our game increased, the need to
organize this different states and how they change to it other increased as well.

**The Pattern**

To solve this problem we used the State Pattern which is a behavioral design pattern that lets an object alter its behavior when its internal state changes.

**Implementation**

The following figure shows how the pattern’s roles were mapped to the application classes.
<br></br>
![](images/UML/statePattern.png)
<br>
<b><i>Fig 7. Factory Method implementation</i></b>
</br>

These classes can be found in the following files:

- [Game](../src/main/java/game/Game.java)
- [State](../src/main/java/game/state/State.java)
- [GameOverState](../src/main/java/game/state/GameOverState.java)
- [InventoryState](../src/main/java/game/state/InventoryState.java)
- [InstructionState](../src/main/java/game/state/InstructionState.java)
- [MenuState](../src/main/java/game/state/MenuState.java)
- [PlayState](../src/main/java/game/state/PlayState.java)

**Consequences**

The use of the State Pattern in the current design allows the following benefits:
- The several states of the game become explicit in the code, instead of relying on a series of flags.
- Easy to add new states to the game during the development
- A well organized code acknowledging the Single Responsibility Principle.



### Known Code Smells and Refactoring suggestions
#### Code Smell 1
The `PlatformSegment` class is a **Data Class**, as it contains only fields, and no behavior. This is problematic because […].

A way to improve the code would be to move the `isPlatformSegmentSolid()` method to the `PlatformSegment` class, as this logic is purely concerned with the `PlatformSegment` class.

### Testing

#### Screenshots of coverage report

![](images/screenshots/CoverageReport/general.png)
<br>
  <b><i>Fig 8. General Code coverage screenshot</i></b>
</br>
<p></p>

![](images/screenshots/CoverageReport/game.png)
<br>
<b><i>Fig 9. Game Code coverage screenshot</i></b>
</br>
<p></p>

![](images/screenshots/CoverageReport/game.enemies.png)
<br>
<b><i>Fig 10. Game.enemies Code coverage screenshot</i></b>
</br>
<p></p>

![](images/screenshots/CoverageReport/game.enemies.strategy.png)
<br>
<b><i>Fig 11. Game.enemies.strategy Code coverage screenshot</i></b>
</br>
<p></p>

![](images/screenshots/CoverageReport/game.entities.png)
<br>
<b><i>Fig 12. Game.entities Code coverage screenshot</i></b>
</br>
<p></p>

![](images/screenshots/CoverageReport/game.gui.png)
<br>
<b><i>Fig 13. Game.gui Code coverage screenshot</i></b>
</br>
<p></p>

![](images/screenshots/CoverageReport/game.state.command.png)
<br>
<b><i>Fig 14. Game.state.command Code coverage screenshot</i></b>
</br>
<p></p>

![](images/screenshots/CoverageReport/game.state.png)
<br>
<b><i>Fig 15. Game.state Code coverage screenshot</i></b>
</br>
<p></p>


![](images/screenshots/CoverageReport/game.weapons.png)
<br>
<b><i>Fig 16. Game.weapons Code coverage screenshot</i></b>
</br>
<p></p>




### Link to mutation testing report
[Mutation tests](../docs/pitestReport/pitest/202201282235/index.html)

### Self-evaluation

The work was divided in a mutual way, and we all contributed with our best. It helped us to enrich our java and principle/pattern knowledge, as well as our team work.

- Eduardo da Silva: 33.3%
- Ian Gomes: 33.3%
- Igor Diniz: 33.3%
