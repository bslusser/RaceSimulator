/**
 * @author Brandon
 *
 */
/**  Ball class
*    inherits from abstract Racer class
*/

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Dice extends Racer
{
	private int speed;
	private Random rand;

   /** Default Constructor: calls Racer default constructor
   */
   public Dice( )
   {
     super( );
     setRandAndSpeed();
   }

   /** Constructor
   *    @param rID  racer Id, passed to Racer constructor
   *    @param rX    x position, passed to Racer constructor
   *    @param rY    y position, passed to Racer constructor
   */
   public Dice( String rID, int rX, int rY )
   {
     super( rID, rX, rY );
     setRandAndSpeed();
   }

   /** move:  calculates the new x position for the racer
   *   Tortoise move characteristics: "slow & steady wins the race"
   *      increment x by 1 most of the time
   */
   public void move( )
   {
	   //Dice can bounce backwards during movement
     int move =  rand.nextInt( 3 )  - rand.nextInt(2);
     if ( move < speed )
       setX( getX( ) + move );
   }

   /** draw: draws the Tortoise at current (x, y) coordinate
   *       @param g   Graphics context
   */
   public void draw( Graphics g )
   {
     int startX = getX( );
     int startY = getY( );
     
     	g.setColor( new Color( 0, 0, 0 ) ); // black

     g.fillRect(startX -24, startY,  25, 25);

     //head
     g.setColor( new Color( 255, 255, 255 ) );//White
     g.fillOval( startX -13, startY,  10, 10 );
     g.fillOval( startX -23, startY +13,  10, 10 );

   
   }
   
   private void setRandAndSpeed( ) {
      // percentage of time (between 90 - 99%) that this Dice moves each turn
      rand = new Random( );
      speed = rand.nextInt( 10 ) + 90;
   }
   public void morph(Graphics g) {
	 //Implemets morph for Dice if it wins
	   setY(getY()- 35);
	   
   }
}
