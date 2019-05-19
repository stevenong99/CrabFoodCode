/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import java.awt.image.BufferedImage;
import Graphics.Assets;

/**
 *
 * @author wid180035
 */
public class RockTile extends Tile{

    public RockTile(int id) {
        super(Assets.stone, id);
    }
    
    @Override
    public boolean isSolid(){
        return true;
    }
    
}
