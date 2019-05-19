/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import java.awt.image.BufferedImage;

/**
 *
 * @author Crimson
 */
public class Assets {
    
    private static final int width = 16, height = 16;
    private static final int width2 = 58, height2 = 58;
    
    public static BufferedImage dirt, grass, stone, wood, water, desert; //Terrain
    public static BufferedImage demon, tree, zombie, werewolf, snake, monster; //Entity
    public static BufferedImage mainmenu, heaven, hell; //Main menu
    public static BufferedImage door, grave; //Objects
    
    
    public static BufferedImage[] startbutton = new BufferedImage[2]; //Buttons
    public static BufferedImage[] player = new BufferedImage[15];
    public static BufferedImage[] playerup = new BufferedImage[3];
    public static BufferedImage[] playerdown = new BufferedImage[3];
    public static BufferedImage[] playerleft = new BufferedImage[3];
    public static BufferedImage[] playerright = new BufferedImage[3];
    public static BufferedImage[] playerfall = new BufferedImage[3];
    public static BufferedImage[] playerattack = new BufferedImage[3];
    
    
    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/terrain.png"));
        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/Character/Full.png"));
        SpriteSheet demonpic = new SpriteSheet(ImageLoader.loadImage("/textures/Demon.png"));
        SpriteSheet start1 = new SpriteSheet(ImageLoader.loadImage("/Buttons/Startnew.png"));
        SpriteSheet start2 = new SpriteSheet(ImageLoader.loadImage("/Buttons/Startnew2.png"));
        SpriteSheet attack = new SpriteSheet(ImageLoader.loadImage("/textures/Attack1.png"));
        SpriteSheet mainmenusprite = new SpriteSheet(ImageLoader.loadImage("/textures/Newmainmenu.png"));
        SpriteSheet gravesprite = new SpriteSheet(ImageLoader.loadImage("/textures/grave.png"));
        SpriteSheet doorsprite = new SpriteSheet(ImageLoader.loadImage("/textures/door.png"));
        SpriteSheet werewolfsprite = new SpriteSheet(ImageLoader.loadImage("/textures/Enemies/Werewolf.png"));
        SpriteSheet zombiesprite = new SpriteSheet(ImageLoader.loadImage("/textures/Enemies/Zombie.png"));
        SpriteSheet snakesprite = new SpriteSheet(ImageLoader.loadImage("/textures/Enemies/Snake.png"));
        SpriteSheet horrorsprite = new SpriteSheet(ImageLoader.loadImage("/textures/Enemies/Monster.png"));
        SpriteSheet hellsprite = new SpriteSheet(ImageLoader.loadImage("/textures/Hell.png"));
        SpriteSheet heavensprite = new SpriteSheet(ImageLoader.loadImage("/textures/Heaven.png"));
        
        
        
        //Menustate
        startbutton[0] = start1.crop(0, 0, 600, 300);
        startbutton[1] = start2.crop(0, 0, 600, 300);
        mainmenu =  mainmenusprite.crop(0, 0, 1200, 800);
        hell = hellsprite.crop(0, 0, 1200, 800);
        heaven = heavensprite.crop(0, 0, 1200, 800);
        //Player
        int x = 0;
        for (int i = 0; i < 15; i++) {
            player[i] = sheet2.crop(x, 0, width2, height2);
            x+=58;
        }
        player[14] = sheet2.crop(812, 0, width2, height2);
        
        playerup[0] = sheet2.crop(width2*6, 0, width2, height2);
        playerup[1] = sheet2.crop(width2*7, 0, width2, height2);
        playerup[2] = sheet2.crop(width2*8, 0, width2, height2);
        playerdown[0] = sheet2.crop(width2*0, 0, width2, height2);
        playerdown[1] = sheet2.crop(width2*1, 0, width2, height2);
        playerdown[2] = sheet2.crop(width2*2, 0, width2, height2);
        playerleft[0] = sheet2.crop(width2*9, 0, width2, height2);
        playerleft[1] = sheet2.crop(width2*10, 0, width2, height2);
        playerleft[2] = sheet2.crop(width2*11, 0, width2, height2);
        playerright[0] = sheet2.crop(width2*12, 0, width2, height2);
        playerright[1] = sheet2.crop(width2*13, 0, width2, height2);
        playerright[2] = sheet2.crop(width2*14, 0, width2, height2);
        
        //Player attack
        playerattack[0] = attack.crop(0, 0, 64, 64);
        playerattack[1] = attack.crop(64, 0, 64, 64);
        playerattack[2] = attack.crop(128, 0, 64, 64);
        
        //Entities and drops
        tree = sheet.crop(16*15, 0, width, height);
        demon = demonpic.crop(0, 0, 520, 780);
        door = doorsprite.crop(0, 0, 64, 64);
        grave = gravesprite.crop(0, 0, 64, 64);
        werewolf = werewolfsprite.crop(0, 0, 100, 126);
        snake = snakesprite.crop(0, 0, 100, 63);
        monster = horrorsprite.crop(0, 0, 500, 532);
        zombie = zombiesprite.crop(0, 0, 50, 97);
        //Terrain
        grass = sheet.crop(0, 0, width, height);
        dirt = sheet.crop(32, 0, width, height);
        stone = sheet.crop(0, 16, width, height);
        wood = sheet.crop(64, 0, width, height);
        water = sheet.crop(224, 192, width, height);
        desert = sheet.crop(0, 176, width, height);
    }
    
}
