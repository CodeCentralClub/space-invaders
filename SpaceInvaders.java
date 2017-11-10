//Nason Lewis, Carlos Rivera <----- This guy is the reason the code is so bad.
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.applet.Applet;
import java.awt.image.*;
import java.util.*;
import java.net.*;
public class SpaceInvaders extends Panel  //change gameStart to your file name
{
		Image image;

	Graphics graphics;

	public void update(Graphics g)
	{


		if (image==null)
		{

			image=createImage(this.getWidth(),this.getHeight());

			graphics = image.getGraphics();

		}

		graphics.setColor(getBackground());

		graphics.fillRect(0,0,getWidth(),this.getHeight());
		paint(graphics);
	 g.drawImage(image,0,0,this);
	}
	public static void main(String[] args)
	{
  		Frame f = new Frame();
  		f.addWindowListener(new java.awt.event.WindowAdapter() {
       		public void windowClosing(java.awt.event.WindowEvent e) {
       		System.exit(0);
       		};
     	});
  		SpaceInvaders window = new SpaceInvaders();  //change gameStart to your file name (two times on this line)
  		window.setSize(1000,650);
		f.add(window);
		f.pack();
		window.init();
		f.setSize(1265,950);/*size of frame*/
		f.show();
	}
	//declare variables here

	player u=new player();
	shoot b=new shoot();
	alien a=new alien();


	public void init()  //runs once at the beginning of the program
	{

	}
	public void paint(Graphics g)//makes pretty pictures
	{





		u.background(g);
		a.draw(g);
		a.death(b);
		u.death(a,g);
		a.move(g);
		a.shoot(g);
		a.wall();
		u.wall();
		b.draw(g);
		u.move(b);
		u.draw(g);
		delay(20);
		repaint();
	}
	//write additional methods here





	public static void delay(int n)	{long startDelay = System.currentTimeMillis();long endDelay = 0;while (endDelay - startDelay < n)endDelay = System.currentTimeMillis();	}
	//required for user input
	public boolean mouseMove(Event e, int x, int y){return InputHandler.mouseUpdate(x,y);}
	public boolean mouseDrag(Event e, int x, int y){return InputHandler.mouseUpdate(x,y);}
	public boolean mouseDown(Event e, int x, int y){return InputHandler.mouseChange(e,true );}
	public boolean mouseUp  (Event e, int x, int y){return InputHandler.mouseChange(e,false);}
	public boolean keyDown(Event e, int key){return InputHandler.keyChange(e,key,true);}
	public boolean keyUp  (Event e, int key){return InputHandler.keyChange(e,key,false);}

}

 class InputHandler	//class to handle input
{
	public InputHandler(){	}
	//ids for keys
	public static final int id_UP		= 1004;
	public static final int id_DOWN		= 1005;
	public static final int id_LEFT		= 1006;
	public static final int id_RIGHT	= 1007;
	public static final int id_SPACE	= 32;
	public static final int id_X		= 120;
	public static final int id_W		= 119;
	public static final int id_A		= 97;
	public static final int id_S		= 115;
	public static final int id_D		= 100;
	public static final int id_I		= 105;
	public static final int id_K		= 107;
	public static final int id_J		= 106;
	public static final int id_L		= 108;
	public static final int id_P		= 112;
	public static final int id_ESC		= 27;

	//boolean values determine if key is pressed
	public static boolean UP	= false;
	public static boolean DOWN	= false;
	public static boolean LEFT	= false;
	public static boolean RIGHT	= false;
	public static boolean SPACE = false;
	public static boolean X = false;
	public static boolean W		= false;
	public static boolean A		= false;
	public static boolean S		= false;
	public static boolean D		= false;
	public static boolean I		= false;
	public static boolean J		= false;
	public static boolean K		= false;
	public static boolean L		= false;
	public static boolean P		= false;
	public static boolean ESC		= false;

	//mouse info
	public static boolean MOUSE_LEFT	= false;
	public static boolean MOUSE_RIGHT	= false;
	public static int MOUSE_X	= 0;
	public static int MOUSE_Y	= 0;

	public static boolean keyChange(Event e, int key, boolean newKeyState)
	{		//changes key state variables to correct values
		switch(key)
		{
		case InputHandler.id_UP:	//Up
			InputHandler.UP = newKeyState;
			break;
		case InputHandler.id_DOWN:	//Down
			InputHandler.DOWN = newKeyState;
			break;
		case InputHandler.id_LEFT:	//Left
			InputHandler.LEFT = newKeyState;
			break;
		case InputHandler.id_RIGHT:	//Right
			InputHandler.RIGHT = newKeyState;
			break;
		case InputHandler.id_SPACE://space
			InputHandler.SPACE=newKeyState;
			break;
		case InputHandler.id_X://space
			InputHandler.X=newKeyState;
			break;
		case InputHandler.id_W:	//Up
			InputHandler.W = newKeyState;
			break;
		case InputHandler.id_S:	//Down
			InputHandler.S = newKeyState;
			break;
		case InputHandler.id_A:	//Left
			InputHandler.A = newKeyState;
			break;
		case InputHandler.id_D:	//Right
			InputHandler.D = newKeyState;
			break;
		case InputHandler.id_I:	//Up
			InputHandler.I = newKeyState;
			break;
		case InputHandler.id_J:	//Down
			InputHandler.J = newKeyState;
			break;
		case InputHandler.id_K:	//Left
			InputHandler.K = newKeyState;
			break;
		case InputHandler.id_L:	//Right
			InputHandler.L = newKeyState;
			break;
		case InputHandler.id_P:
			InputHandler.P = newKeyState;
			break;
		case InputHandler.id_ESC:
			InputHandler.ESC = newKeyState;
			break;
		default:
			System.out.print(key);	//print any unbound key presses- may spam console - used for key mapping
			if(newKeyState){	}
			else{	}
			break;
		}
		return true;
	}
	public static boolean mouseUpdate(int x, int y)	//handles mouse movement of mouse
	{
		InputHandler.MOUSE_X = x;
		InputHandler.MOUSE_Y = y;
		return true;
	}

	public static boolean mouseChange(Event e, boolean newKeyState)	//handles mouse clicks
	{
		if(e.metaDown())
			InputHandler.MOUSE_RIGHT	= newKeyState;
		else
			InputHandler.MOUSE_LEFT		= newKeyState;
		return true;
	}
}
class player
{	int x=550;
	int x2=900;
	int x3=800;
	int x4=700;
 	int y=850;
 	int y2=50;
 	int y3=50;
 	int y4=50;
 	int e=0;

	public void death(alien a,Graphics g)
	{

		if(a.ya>=y-200&&a.ya<=y-169&&a.xa>=x-400&&a.xa<=x+100)
		{
			x+=10000;
			x2=550;
			y2=850;
			e=1;

		if(e==1)
		{
		if(a.ya>=y-200&&a.ya<=y-169&&a.xa>=x-400&&a.xa<=x+100)
		{
			x2+=10000;
			x3-=800;
			y3-=200;
			x3+=550;
			y3+=850;
			e=2;
		}
		}
		if(e==2)
		{
			if(a.ya>=y-200&&a.ya<=y-169&&a.xa>=x-400&&a.xa<=x+100)
		{
			x3+=10000;
			x4-=800;
			y4-=200;
			x4+=550;
			y4+=850;
			e=3;
		}
		}
		if(e==3)
		{
			if(a.ya>=y-200&&a.ya<=y-169&&a.xa>=x-400&&a.xa<=x+100)
		{
			x4+=10000;
			e=4;
			g.setFont(new Font("Courier",Font.PLAIN,800));
			g.drawString("GAME OVER",100,500);
		}
		}
		}
	}
	public void background(Graphics g)
	{
	Color Black=new Color(0,0,0);
	g.setColor(Black);
	g.fillRect(0,0,1300,1000);
	}
	public void draw(Graphics g)
	{
	Color Green=new Color(0,255,0);
	g.setColor(Green);
	g.fillRect(x,y,70,30);
	g.fillRect(x+33,y-20,6,37);

	Color Blue=new Color(0,0,255);
	g.setColor(Blue);
	g.fillRect(x2,y2,70,30);
	g.fillRect(x2+33,y2-20,6,37);

	Color Red=new Color(255,0,0);
	g.setColor(Red);
	g.fillRect(x3,y3,70,30);
	g.fillRect(x3+33,y3-20,6,37);

	Color White=new Color(255,255,255);
	g.setColor(White);
	g.fillRect(x4,y4,70,30);
	g.fillRect(x4+33,y4-20,6,37);
	}
	public void move(shoot b)
	{
	if(e==0)
	{
	if(InputHandler.RIGHT)
	{
		x+=15;

	}
	if(InputHandler.LEFT)
	{
		x-=15;
	}
	if(InputHandler.D)
	{
		x+=15;
	}
	if(InputHandler.A)
	{
		x-=15;
	}
	}
	if(e==1)
	{
	if(InputHandler.RIGHT)
	{
		x2+=15;

	}
	if(InputHandler.LEFT)
	{
		x2-=15;
	}
	if(InputHandler.D)
	{
		x2+=15;
	}
	if(InputHandler.A)
	{
		x2-=15;
	}
	}
	if(e==2)
	{
	if(InputHandler.RIGHT)
	{
		x3+=15;

	}
	if(InputHandler.LEFT)
	{
		x3-=15;
	}
	if(InputHandler.D)
	{
		x3+=15;
	}
	if(InputHandler.A)
	{
		x3-=15;
	}
	}
	if(e==3)
	{
	if(InputHandler.RIGHT)
	{
		x4+=15;

	}
	if(InputHandler.LEFT)
	{
		x4-=15;
	}
	if(InputHandler.D)
	{
		x4+=15;
	}
	if(InputHandler.A)
	{
		x4-=15;
	}
	}


		if(e==0)
		{
		if(InputHandler.SPACE)
		{
			b.x=x+35;
			b.y=y-6;
		}
		}
		if(e==1)
		{
		if(InputHandler.SPACE)
		{
			b.x=x2+35;
			b.y=y2-6;
		}
		}
		if(e==2)
		{
		if(InputHandler.SPACE)
		{
			b.x=x3+35;
			b.y=y3-6;
		}
		}
		if(e==3)
		{
		if(InputHandler.SPACE)
		{
			b.x=x4+35;
			b.y=y4-6;
		}
		}

	}
	public void wall()
	{
		if(e==0)
		{
		if(x<=0)
		{
			x+=40;
		}
		if(x>=1175)
		{
			x-=40;
		}
		}
		if(e==1)
		{
		if(x2<=0)
		{
			x2+=40;
		}
		if(x2>=1175)
		{
			x2-=40;
		}
		}
		if(e==2)
		{
		if(x3<=0)
		{
			x3+=40;
		}
		if(x3>=1175)
		{
			x3-=40;
		}
		}
		if(e==3)
		{
		if(x4<=0)
		{
			x4+=40;
		}
		if(x4>=1175)
		{
			x4-=40;
		}
		}
	}
}
class alien
{
	int x=350;int x2=350;int x3=350;int x4=350;int x5=350;int x6=350;int x7=350;int x8=350;int x9=350;int x10=350;int x11=350;int x12=350;int x13=350;int x14=350;int x15=350;int x16=350;int x17=350;int x18=350;int x19=350;int x20=350;int x21=350;int x22=350;int x23=350;int x24=350;int x25=350;int x26=350;int x27=350;int x28=350;int x29=350;int x30=350;int x31=350;int x32=350;int x33=350;int x34=350;int x35=350;int x36=350;int x37=350;int x38=350;int x39=350;int x40=350;int x41=350;int x42=350;int x43=350;int x44=350;int x45=350;int x46=350;int x47=350;int x48=350;int x49=350;int x50=350;int x51=350;int x52=350;int x53=350;int x54=350;int x55=350;int xa;
 	int y=200;int y2=200;int y3=200;int y4=200;int y5=200;int y6=200;int y7=200;int y8=200;int y9=200;int y10=200;int y11=200;int y12=200;int y13=200;int y14=200;int y15=200;int y16=200;int y17=200;int y18=200;int y19=200;int y20=200;int y21=200;int y22=200;int y23=200;int y24=200;int y25=200;int y26=200;int y27=200;int y28=200;int y29=200;int y30=200;int y31=200;int y32=200;int y33=200;int y34=200;int y35=200;int y36=200;int y37=200;int y38=200;int y39=200;int y40=200;int y41=200;int y42=200;int y43=200;int y44=200;int y45=200;int y46=200;int y47=200;int y48=200;int y49=200;int y50=200;int y51=200;int y52=200;int y53=200;int y54=200;int y55=200;int ya;
 	int con;
 	int eee=5;
 	int ai;
 	int ai2;
 	int shot;
    int b;
    int c;
	public void move(Graphics g)
	{
		if(eee>0)

		{

 	con=(int)Math.random()*5+1;

			if (con==1)
			{
				y-=1;y2-=1;y3-=1;y4-=1;y5-=1;y6-=1;y7-=1;y8-=1;y9-=1;y10-=1;y11-=1;y12-=1;y13-=1;y14-=1;y15-=1;y16-=1;y17-=1;y18-=1;y19-=1;y20-=1;y21-=1;y22-=1;y23-=1;y24-=1;y25-=1;y26-=1;y27-=1;y28-=1;y29-=1;y30-=1;y31-=1;y32-=1;y33-=1;y34-=1;y35-=1;y36-=1;y37-=1;y38-=1;y39-=1;y40-=1;y41-=1;y42-=1;y43-=1;y44-=1;y45-=1;y46-=1;y47-=1;y48-=1;y49-=1;y50-=1;y51-=1;y52-=1;y53-=1;y54-=1;y55-=1;
			}
			if (con==2)
			{
				y+=1;y2+=1;y3+=1;y4+=1;y5+=1;y6+=1;y7+=1;y8+=1;y9+=1;y10+=1;y11+=1;y12+=1;y13+=1;y14+=1;y15+=1;y16+=1;y17+=1;y18+=1;y19+=1;y20+=1;y21+=1;y22+=1;y23+=1;y24+=1;y25+=1;y26+=1;y27+=1;y28+=1;y29+=1;y30+=1;y31+=1;y32+=1;y33+=1;y34+=1;y35+=1;y36+=1;y37+=1;y38+=1;y39+=1;y40+=1;y41+=1;y42+=1;y43+=1;y44+=1;y45+=1;y46+=1;y47+=1;y48+=1;y49+=1;y50+=1;y51+=1;y52+=1;y53+=1;y54+=1;y55+=1;
			}
			if (con==3)
			{
				x+=1;x2+=1;x3+=1;x4+=1;x5+=1;x6+=1;x7+=1;x8+=1;x9+=1;x10+=1;x11+=1;x12+=1;x13+=1;x14+=1;x15+=1;x16+=1;x17+=1;x18+=1;x19+=1;x20+=1;x21+=1;x22+=1;x23+=1;x24+=1;x25+=1;x26+=1;x27+=1;x28+=1;x29+=1;x30+=1;x31+=1;x32+=1;x33+=1;x34+=1;x35+=1;x36+=1;x37+=1;x38+=1;x39+=1;x40+=1;x41+=1;x42+=1;x43+=1;x44+=1;x45+=1;x46+=1;x47+=1;x48+=1;x49+=1;x50+=1;x51+=1;x52+=1;x53+=1;x54+=1;x55+=1;
			}
			if (con==4)
			{
				x-=1;x2-=1;x3-=1;x4-=1;x5-=1;x6-=1;x7-=1;x8-=1;x9-=1;x10-=1;x11-=1;x12-=1;x13-=1;x14-=1;x15-=1;x16-=1;x17-=1;x18-=1;x19-=1;x20-=1;x21-=1;x22-=1;x23-=1;x24-=1;x25-=1;x26-=1;x27-=1;x28-=1;x29-=1;x30-=1;x31-=1;x32-=1;x33-=1;x34-=1;x35-=1;x36-=1;x37-=1;x38-=1;x39-=1;x40-=1;x41-=1;x42-=1;x43-=1;x44-=1;x45-=1;x46-=1;x47-=1;x48-=1;x49-=1;x50-=1;x51-=1;x52-=1;x53-=1;x54-=1;x55-=1;

			}
			if (con==5)
			{
				ai2=(int)(Math.random()*555);

				if(ai2==1)
				{
					shot=1;
				}
				if(ai2==2)
				{
					shot=2;
				}
				if(ai2==3)
				{
					shot=3;
				}
				if(ai2==4)
				{
					shot=4;
				}
				if(ai2==5)
				{
					shot=5;
				}
				if(ai2==6)
				{
					shot=6;
				}
				if(ai2==7)
				{
					shot=7;
				}
				if(ai2==8)
				{
					shot=8;
				}
				if(ai2==9)
				{
					shot=9;
				}
				if(ai2==10)
				{
					shot=10;
				}
				if(ai2==11)
				{
					shot=11;
				}
				if(ai2==12)
				{
					shot=12;
				}
				if(ai2==13)
				{
					shot=13;
				}
				if(ai2==14)
				{
				shot=14;
				}
				if(ai2==15)
				{shot=15;
				}
				if(ai2==16)
				{
shot=16;
				}
				if(ai2==17)
				{
shot=17;
				}
				if(ai2==18)
				{
shot=18;
				}
				if(ai2==19)
				{
shot=19;
				}
				if(ai2==20)
				{
shot=20;
				}
				if(ai2==21)
				{
shot=21;
				}
				if(ai2==22)
				{
shot=22;
				}
				if(ai2==23)
				{
shot=23;
				}
				if(ai2==24)
				{
shot=24;
				}
				if(ai2==25)
				{
shot=25;
				}
				if(ai2==26)
				{
shot=26;
				}
				if(ai2==27)
				{
shot=27;
				}
				if(ai2==28)
				{
shot=28;
				}
				if(ai2==29)
				{
shot=29;
				}
				if(ai2==30)
				{
shot=30;
				}
				if(ai2==31)
				{
shot=31;
				}
				if(ai2==32)
				{
shot=32;
				}
				if(ai2==33)
				{
shot=33;
				}
				if(ai2==34)
				{
				shot=34;
				}
				if(ai2==35)
				{
				shot=35;
				}
				if(ai2==36)
				{
				shot=36;
				}
				if(ai2==37)
				{
				shot=37;
				}
				if(ai2==38)
				{
				shot=38;
				}
				if(ai2==39)
				{
				shot=39;
				}
				if(ai2==40)
				{
				shot=40;
				}
				if(ai2==41)
				{
				shot=41;
				}
				if(ai2==42)
				{
				shot=42;
				}
				if(ai2==43)
				{
				shot=43;
				}
				if(ai2==44)
				{
				shot=44;
				}
				if(ai2==45)
				{
				shot=45;
				}
				if(ai2==46)
				{
				shot=46;
				}
				if(ai2==47)
				{
				shot=47;
				}
				if(ai2==48)
				{
				shot=48;
				}
				if(ai2==49)
				{
				shot=49;
				}
				if(ai2==50)
				{
				shot=50;
				}
				if(ai2==51)
				{
				shot=51;
				}
				if(ai2==52)
				{
				shot=52;
				}
				if(ai2==53)
				{
				shot=53;
				}
				if(ai2==54)
				{
				shot=54;
				}
				if(ai2==55)
				{
				shot=55;
				}

			}

	}
	}
	public void shoot(Graphics g)
	{


		if(shot==1)
		{
			b=x+15;
			c=y;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==2)
		{
			b=x2+15;
			c=y2;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==3)
		{
			b=x3+15;
			c=y3;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==4)
		{
			b=x4+15;
			c=y4;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==5)
		{
			b=x5+15;
			c=y5;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==6)
		{
			b=x6+15;
			c=y6;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==7)
		{
			b=x7+15;
			c=y7;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==8)
		{
			b=x8+15;
			c=y8;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==9)
		{
			b=x9+15;
			c=y9;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==10)
		{
			b=x10+15;
			c=y10;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==11)
		{
			b=x11+15;
			c=y11;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==12)
		{
			b=x12+15;
			c=y12;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==13)
		{
			b=x13+15;
			c=y13;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==14)
		{
		b=x14+15;
			c=y14;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==15)
		{
			b=x15+15;
			c=y15;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==16)
		{
			b=x16+15;
			c=y16;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==17)
		{
			b=x17+15;
			c=y17;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==18)
		{
			b=x18+15;
			c=y18;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==19)
		{
			b=x19+15;
			c=y19;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==20)
		{
			b=x20+15;
			c=y20;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==21)
		{
			b=x21+15;
			c=y21;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==22)
		{
			b=x22+15;
			c=y22;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==23)
		{
			b=x23+15;
			c=y23;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==24)
		{
			b=x24+15;
			c=y24;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==25)
		{
			b=x25+15;
			c=y25;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==26)
		{
			b=x26+15;
			c=y26;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==27)
		{
			b=x27+15;
			c=y27;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==28)
		{
			b=x28+15;
			c=y28;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==29)
		{
			b=x29+15;
			c=y29;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==30)
		{
			b=x+15;
			c=y;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==31)
		{
			b=x+15;
			c=y;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==32)
		{
			b=x+15;
			c=y;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==33)
		{
			b=x+15;
			c=y;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==34)
		{
			b=x+15;
			c=y;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==35)
		{
			b=x+15;
			c=y;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==36)
		{
			b=x+15;
			c=y;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==37)
		{
			b=x+15;
			c=y;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==38)
		{
			b=x+15;
			c=y;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==39)
		{
			b=x+15;
			c=y;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==40)
		{
			b=x+15;
			c=y;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==41)
		{
			b=x+15;
			c=y;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==42)
		{
			b=x+15;
			c=y;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==43)
		{
			b=x+15;
			c=y;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==44)
		{b=x+15;
			c=y;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==45)
		{
			b=x+15;
			c=y;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==46)
		{
			b=x+15;
			c=y;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==47)
		{
			b=x+15;
			c=y;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==48)
		{
		b=x+15;
			c=y;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==49)
		{
			b=x+15;
			c=y;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==50)
		{
		b=x+15;
			c=y;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==51)
		{
			b=x+15;
			c=y;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==52)
		{
			b=x+15;
			c=y;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==53)
		{
			b=x+15;
			c=y;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==54)
		{
			b=x+15;
			c=y;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}
		if(shot==55)
		{
			b=x+15;
			c=y;
			ya+=5;
			g.fillRect(xa+b,ya+c,3,10);
		}

	}
	public void draw(Graphics g)
	{
	Color White=new Color(255,255,255);
	g.setColor(White);
	g.fillRect(x,y,31,30);
	g.fillRect(x2+40,y,31,30);
	g.fillRect(x3+80,y,31,30);
	g.fillRect(x4+120,y,31,30);
	g.fillRect(x5+160,y,31,30);
	g.fillRect(x6+200,y,31,30);
	g.fillRect(x7+240,y,31,30);
	g.fillRect(x8+280,y,31,30);
	g.fillRect(x9+320,y,31,30);
	g.fillRect(x10+360,y,31,30);
	g.fillRect(x11+400,y,31,30);
	g.fillRect(x12,y+40,31,30);
	g.fillRect(x13+40,y+40,31,30);
	g.fillRect(x14+80,y+40,31,30);
	g.fillRect(x15+120,y+40,31,30);
	g.fillRect(x16+160,y+40,31,30);
	g.fillRect(x17+200,y+40,31,30);
	g.fillRect(x18+240,y+40,31,30);
	g.fillRect(x19+280,y+40,31,30);
	g.fillRect(x20+320,y+40,31,30);
	g.fillRect(x21+360,y+40,31,30);
	g.fillRect(x22+400,y+40,31,30);
	g.fillRect(x23,y+80,31,30);
	g.fillRect(x24+40,y+80,31,30);
	g.fillRect(x25+80,y+80,31,30);
	g.fillRect(x26+120,y+80,31,30);
	g.fillRect(x27+160,y+80,31,30);
	g.fillRect(x28+200,y+80,31,30);
	g.fillRect(x29+240,y+80,31,30);
	g.fillRect(x30+280,y+80,31,30);
	g.fillRect(x31+320,y+80,31,30);
	g.fillRect(x32+360,y+80,31,30);
	g.fillRect(x33+400,y+80,31,30);
	g.fillRect(x34,y+120,31,30);
	g.fillRect(x35+40,y+120,31,30);
	g.fillRect(x36+80,y+120,31,30);
	g.fillRect(x37+120,y+120,31,30);
	g.fillRect(x38+160,y+120,31,30);
	g.fillRect(x39+200,y+120,31,30);
	g.fillRect(x40+240,y+120,31,30);
	g.fillRect(x41+280,y+120,31,30);
	g.fillRect(x42+320,y+120,31,30);
	g.fillRect(x43+360,y+120,31,30);
	g.fillRect(x44+400,y+120,31,30);
	g.fillRect(x45,y+160,31,30);
	g.fillRect(x46+40,y+160,31,30);
	g.fillRect(x47+80,y+160,31,30);
	g.fillRect(x48+120,y+160,31,30);
	g.fillRect(x49+160,y+160,31,30);
	g.fillRect(x50+200,y+160,31,30);
	g.fillRect(x51+240,y+160,31,30);
	g.fillRect(x52+280,y+160,31,30);
	g.fillRect(x53+320,y+160,31,30);
	g.fillRect(x54+360,y+160,31,30);
	g.fillRect(x55+400,y+160,31,30);

	}
	public void death(shoot b)
	{
		if(InputHandler.X)
		{
			x=350;x2=350;x3=350;x4=350;x5=350;x6=350;x7=350;x8=350;x9=350;x10=350;x11=350;x12=350;x13=350;x14=350;x15=350;x16=350;x17=350;x18=350;x19=350;x20=350;x21=350;x22=350;x23=350;x24=350;x25=350;x26=350;x27=350;x28=350;x29=350;x30=350;x31=350;x32=350;x33=350;x34=350;x35=350;x36=350;x37=350;x38=350;x39=350;x30=350;x31=350;x32=350;x33=350;x34=350;x35=350;x36=350;x37=350;x38=350;x39=350;x40=350;x41=350;x42=350;x43=350;x44=350;x45=350;x46=350;x47=350;x48=350;x49=350;x50=350;x51=350;x52=350;x53=350;x54=350;x55=350;
		}
		if(b.x>=x&&b.x<=x+31&&b.y>=y&&b.y<=y+30)
		{
			x+=100000;
			b.x+=100000;
		}
		if(b.x>=x2+40&&b.x<=x2+71&&b.y>=y2&&b.y<=y2+30)
		{
			x2+=100000;
			b.x+=100000;
		}
		if(b.x>=x3+80&&b.x<=x3+111&&b.y>=y3&&b.y<=y3+30)
		{
			x3+=100000;
			b.x+=100000;
		}
		if(b.x>=x4+120&&b.x<=x4+151&&b.y>=y4&&b.y<=y4+30)
		{
			x4+=100000;
			b.x+=100000;
		}
		if(b.x>=x5+160&&b.x<=x5+191&&b.y>=y5&&b.y<=y5+30)
		{
			x5+=100000;
			b.x+=100000;
		}
		if(b.x>=x6+200&&b.x<=x6+231&&b.y>=y6&&b.y<=y6+30)
		{
			x6+=100000;
			b.x+=100000;
		}
		if(b.x>=x7+240&&b.x<=x7+271&&b.y>=y7&&b.y<=y7+30)
		{
			x7+=100000;
			b.x+=100000;
		}
		if(b.x>=x8+280&&b.x<=x8+311&&b.y>=y8&&b.y<=y8+30)
		{
			x8+=100000;
			b.x+=100000;
		}
		if(b.x>=x9+320&&b.x<=x9+351&&b.y>=y9&&b.y<=y9+30)
		{
			x9+=100000;
			b.x+=100000;
		}
		if(b.x>=x10+360&&b.x<=x10+491&&b.y>=y10&&b.y<=y10+30)
		{
			x10+=100000;
			b.x+=100000;
		}
		if(b.x>=x11+400&&b.x<=x11+431&&b.y>=y11&&b.y<=y11+30)
		{
			x11+=100000;
			b.x+=100000;
		}
		if(b.x>=x12&&b.x<=x12+31&&b.y>=y12+40&&b.y<=y12+70)
		{
			x12+=100000;
			b.x+=100000;
		}
		if(b.x>=x13+40&&b.x<=x13+71&&b.y>=y13+40&&b.y<=y13+70)
		{
			x13+=100000;
			b.x+=100000;
		}
		if(b.x>=x14+80&&b.x<=x14+111&&b.y>=y14+40&&b.y<=y14+70)
		{
			x14+=100000;
			b.x+=100000;
		}
		if(b.x>=x15+120&&b.x<=x15+151&&b.y>=y15+40&&b.y<=y15+70)
		{
			x15+=100000;
			b.x+=100000;
		}
		if(b.x>=x16+160&&b.x<=x16+191&&b.y>=y16+40&&b.y<=y16+70)
		{
			x16+=100000;
			b.x+=100000;
		}
		if(b.x>=x17+200&&b.x<=x17+231&&b.y>=y17+40&&b.y<=y17+70)
		{
			x17+=100000;
			b.x+=100000;
		}
		if(b.x>=x18+240&&b.x<=x18+251&&b.y>=y18+40&&b.y<=y18+70)
		{
			x18+=100000;
			b.x+=100000;
		}
		if(b.x>=x19+280&&b.x<=x19+311&&b.y>=y19+40&&b.y<=y19+70)
		{
			x19+=100000;
			b.x+=100000;
		}
		if(b.x>=x20+320&&b.x<=x20+351&&b.y>=y20+40&&b.y<=y20+70)
		{
			x20+=100000;
			b.x+=100000;
		}
		if(b.x>=x21+360&&b.x<=x21+391&&b.y>=y21+40&&b.y<=y21+70)
		{
			x21+=100000;
			b.x+=100000;
		}
		if(b.x>=x22+400&&b.x<=x22+431&&b.y>=y22+40&&b.y<=y22+70)
		{
			x22+=100000;
			b.x+=100000;
		}
		if(b.x>=x23&&b.x<=x23+31&&b.y>=y23+80&&b.y<=y23+110)
		{
			x23+=100000;
			b.x+=100000;
		}
		if(b.x>=x24+40&&b.x<=x24+71&&b.y>=y24+80&&b.y<=y24+110)
		{
			x24+=100000;
			b.x+=100000;
		}
		if(b.x>=x25+80&&b.x<=x25+111&&b.y>=y25+80&&b.y<=y25+110)
		{
			x25+=100000;
			b.x+=100000;
		}
		if(b.x>=x26+120&&b.x<=x26+151&&b.y>=y26+80&&b.y<=y26+110)
		{
			x26+=100000;
			b.x+=100000;
		}
		if(b.x>=x27+160&&b.x<=x27+191&&b.y>=y27+80&&b.y<=y27+110)
		{
			x27+=100000;
			b.x+=100000;
		}
		if(b.x>=x28+200&&b.x<=x28+231&&b.y>=y28+80&&b.y<=y28+110)
		{
			x28+=100000;
			b.x+=100000;
		}
		if(b.x>=x29+240&&b.x<=x29+271&&b.y>=y29+80&&b.y<=y29+110)
		{
			x29+=100000;
			b.x+=100000;
		}
		if(b.x>=x30+280&&b.x<=x30+321&&b.y>=y30+80&&b.y<=y30+110)
		{
			x30+=100000;
			b.x+=100000;
		}
		if(b.x>=x31+320&&b.x<=x31+351&&b.y>=y31+80&&b.y<=y31+110)
		{
			x31+=100000;
			b.x+=100000;
		}
		if(b.x>=x32+360&&b.x<=x32+391&&b.y>=y32+80&&b.y<=y32+110)
		{
			x32+=100000;
			b.x+=100000;
		}
		if(b.x>=x33+400&&b.x<=x33+431&&b.y>=y33+80&&b.y<=y33+110)
		{
			x33+=100000;
			b.x+=100000;
		}
		if(b.x>=x34&&b.x<=x34+31&&b.y>=y34+110&&b.y<=y34+150)
		{
			x34+=100000;
			b.x+=100000;
		}
		if(b.x>=x35+40&&b.x<=x35+71&&b.y>=y35+110&&b.y<=y35+150)
		{
			x35+=100000;
			b.x+=100000;
		}
		if(b.x>=x36+80&&b.x<=x36+111&&b.y>=y36+110&&b.y<=y36+150)
		{
			x36+=100000;
			b.x+=100000;
		}
		if(b.x>=x37+120&&b.x<=x37+151&&b.y>=y37+110&&b.y<=y37+150)
		{
			x37+=100000;
			b.x+=100000;
		}
		if(b.x>=x38+160&&b.x<=x38+191&&b.y>=y38+110&&b.y<=y38+150)
		{
			x38+=100000;
			b.x+=100000;
		}
		if(b.x>=x39+200&&b.x<=x39+231&&b.y>=y39+110&&b.y<=y39+150)
		{
			x39+=100000;
			b.x+=100000;
		}
		if(b.x>=x40+240&&b.x<=x40+271&&b.y>=y40+110&&b.y<=y40+150)
		{
			x40+=100000;
			b.x+=100000;
		}
		if(b.x>=x41+280&&b.x<=x41+321&&b.y>=y41+110&&b.y<=y41+150)
		{
			x41+=100000;
			b.x+=100000;
		}
		if(b.x>=x42+320&&b.x<=x42+351&&b.y>=y42+110&&b.y<=y42+150)
		{
			x42+=100000;
			b.x+=100000;
		}
		if(b.x>=x43+360&&b.x<=x43+391&&b.y>=y43+110&&b.y<=y43+150)
		{
			x43+=100000;
			b.x+=100000;
		}
		if(b.x>=x44+400&&b.x<=x44+431&&b.y>=y44+110&&b.y<=y44+150)
		{
			x44+=100000;
			b.x+=100000;
		}
		if(b.x>=x45&&b.x<=x45+31&&b.y>=y45+150&&b.y<=y45+190)
		{
			x45+=100000;
			b.x+=100000;
		}
		if(b.x>=x46+40&&b.x<=x46+71&&b.y>=y46+150&&b.y<=y46+190)
		{
			x46+=100000;
			b.x+=100000;
		}
		if(b.x>=x47+80&&b.x<=x47+111&&b.y>=y47+150&&b.y<=y47+190)
		{
			x47+=100000;
			b.x+=100000;
		}
		if(b.x>=x48+120&&b.x<=x48+151&&b.y>=y48+150&&b.y<=y48+190)
		{
			x48+=100000;
			b.x+=100000;
		}
		if(b.x>=x49+160&&b.x<=x49+191&&b.y>=y49+150&&b.y<=y49+190)
		{
			x49+=100000;
			b.x+=100000;
		}
		if(b.x>=x50+200&&b.x<=x50+231&&b.y>=y50+150&&b.y<=y50+190)
		{
			x50+=100000;
			b.x+=100000;
		}
		if(b.x>=x51+240&&b.x<=x51+271&&b.y>=y51+150&&b.y<=y51+190)
		{
			x51+=100000;
			b.x+=100000;
		}
		if(b.x>=x52+280&&b.x<=x53+311&&b.y>=y52+150&&b.y<=y52+190)
		{
			x52+=100000;
			b.x+=100000;
		}
		if(b.x>=x53+320&&b.x<=x53+351&&b.y>=y53+150&&b.y<=y53+190)
		{
			x53+=100000;
			b.x+=100000;
		}
		if(b.x>=x54+360&&b.x<=x54+391&&b.y>=y54+150&&b.y<=y54+190)
		{
			x54+=100000;
			b.x+=100000;
		}
		if(b.x>=x55+400&&b.x<=x55+431&&b.y>=y55+150&&b.y<=y55+190)
		{
			x55+=100000;
			b.x+=100000;
		}
	}
	public void wall()
	{
		if(x<=0)
		{
		x+=1;
		}
		if(x>=978)
		{
		x-=1;
		}
		if(y>=500)
		{
		y-=1;
		}
		if(y<=0)
		{
		y+=1;
		}
	}
}
class barriers
{
int x=200;
int y=700;
	public void draw(Graphics g)
	{
		Color Green=new Color(0,255,0);
		g.setColor(Green);
		g.fillRect(x,y,30,70);
		g.fillRect(x,y,70,30);
		g.fillRect(x+70,y,30,70);

		g.fillRect(x+300,y,30,70);
		g.fillRect(x+300,y,70,30);
		g.fillRect(x+370,y,30,70);

		g.fillRect(x+600,y,30,70);
		g.fillRect(x+600,y,70,30);
		g.fillRect(x+670,y,30,70);
	}
}
class shoot
{int x=100000;
 int y=100000;
	public void draw(Graphics g)
	{
		Color White=new Color(255,255,255);
		g.setColor(White);
		g.fillOval(x,y-=25,3,10);
	}
}
	}

//write additional classes here
