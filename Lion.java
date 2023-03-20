/**
 * @author Brandon
 *
 */
/**  Lion class
*    inherits from abstract Racer class
*/

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Lion extends Racer
{
	private int speed;
	private Random rand;

   /** Default Constructor: calls Racer default constructor
   */
   public Lion( )
   {
     super( );
     setRandAndSpeed();
   }

   /** Constructor
   *    @param rID  racer Id, passed to Racer constructor
   *    @param rX    x position, passed to Racer constructor
   *    @param rY    y position, passed to Racer constructor
   */
   public Lion( String rID, int rX, int rY )
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
	   //Allow Lion to get distracted during movement
     int move =  rand.nextInt( 5 )  - rand.nextInt(4);
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
     
     	g.setColor( new Color( 128, 64, 0 ) ); // Orange

     //body
     g.fillOval( startX - 30, startY, 25, 15 );
     
     //flatten bottom
      g.clearRect( startX - 30, startY + 11, 35, 4 );
      
    //mane
      g.setColor( new Color( 120, 60, 0 ) );
      g.fillOval( startX-10, startY, 12, 18);
      
      
    //head
      g.fillOval( startX - 10, startY + 5,  15, 10 );

     //feet
     g.setColor( new Color( 128, 64, 0 ) );  // Orange
     g.fillOval( startX - 27, startY + 10,  5, 5 );
     g.fillOval( startX - 13, startY + 10, 5, 5 );
     
     //tail
     g.setColor( new Color( 128, 64, 0 ) );//Orange
     g.fillRect(startX-30, startY,  3, 10);

   }
   
   private void setRandAndSpeed( ) {
      // percentage of time (between 90 - 99%) that this Lion moves each turn
      rand = new Random( );
      speed = rand.nextInt( 10 ) + 90;
   }
   public void morph(Graphics g) {
	 //Implemets morph for Lion if it wins
	   setY(getY()- 35);
	   
   }
}
