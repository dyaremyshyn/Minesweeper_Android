package pt.isec.a21220683.minesweeper.Util;

import android.util.Log;

/**
 * Created by Dmytro Yaremyshyn on 5/11/2017.
 */

public class PrintGrid {

    public static void print( final int[][] grid , final int width , final int height ){
        for( int x = 0 ; x < width ; x++ ){
            String printedText = "| ";
            for( int y = 0 ; y < height ; y++ ){
                printedText += String.valueOf(grid[x][y]).replace("-1", "B") + " | ";
            }
            Log.e("",printedText);
        }
    }
}
