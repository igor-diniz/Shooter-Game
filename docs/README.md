## LDTS_T10_G1002 - FATE

### Game Description

This project consists in a 2D looter shooter game, where the inspirations are Destiny and Pokemon.
The game consists of one player and different monsters, which depend on different levels. The player has 3 types of weapons with their own characteristics, which are used to kill monsters and get to the next level. Monsters can also shoot the player, and depending on which one it is, it may have more health and deal more damage than others.

This project was developed by Eduardo da Silva (up202004999@fe.up.pt), Ian Gomes (up202000707@fe.up.pt) and Igor Diniz (up202000162@fe.up.pt) for LDTS 2021-22.

### Implemented Features

- **Connected Menus** - The user has the capability of browsing through the different menus including in game ones. (Ex: Main Menu, Instructions, Play, Pause).
- **Buttons** - Functional and interactive buttons.
- **Keyboard control** - The keyboard inputs are received through the respective events and interpreted according to the current game state.
- **Player control** - The player may move with the keyboard control (keys - a,w,s,d) and shoot his gun when the space-bar is pressed.
- **Collisions detection** - Collisions between different objects are verified. (Ex: Player, Bullet, Enemies, Obstacles).
- **Different levels** - 8 different levels with an increasing difficulty were implemented.
- **Different weapons** - 3 different types of weapons.
- **Different enemies** - 6 different types of monsters with distintic speed, health and damage.
- **Animations** - In this game, damage caused by the player or by the enemies is seen in animated forms.

### Planned Features

All the planned features were successfully implemented.

### Design

#### THE JUMP ACTION OF THE KANGAROOBOY SHOULD BEHAVE DIFFERENTLY DEPENDING ON ITS STATE

**Problem in Context**

There was a lot of scattered conditional logic when deciding how the KangarooBoy should behave when jumping, as the jumps should be different depending on the items that came to his possession during the game (an helix will alow him to fly, driking a potion will allow him to jump double the height, etc.). This is a violation of the **Single Responsability Principle**. We could concentrate all the conditional logic in the same method to circumscribe the issue to that one method but the **Single Responsability Principle** would still be violated.

**The Pattern**

We have applied the **State** pattern. This pattern allows you to represent different states with different subclasses. We can switch to a different state of the application by switching to another implementation (i.e., another subclass). This pattern allowed to address the identified problems because […].

**Implementation**

The following figure shows how the pattern’s roles were mapped to the application classes.

![img](https://www.fe.up.pt/~arestivo/page/img/examples/lpoo/state.svg)

These classes can be found in the following files:

- [Character](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/Character.java)
- [JumpAbilityState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/JumpAbilityState.java)
- [DoubleJumpState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/DoubleJumpState.java)
- [HelicopterState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/HelicopterState.java)
- [IncreasedGravityState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/IncreasedGravityState.java)

**Consequences**

The use of the State Pattern in the current design allows the following benefits:

- The several states that represent the character’s hability to jump become explicit in the code, instead of relying on a series of flags.
- We don’t need to have a long set of conditional if or switch statements associated with the various states; instead, polimorphism is used to activate the right behavior.
- There are now more classes and instances to manage, but still in a reasonable number.

