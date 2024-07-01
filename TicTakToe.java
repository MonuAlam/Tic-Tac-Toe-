import java.util.*;

class TicTakToe{
static char turn='X';
static int row,col,choice;
static boolean draw=false;
static char[][] board = {{'1','2','3'},{'4','5','6'},{'7','8','9'}};


public static void display(){
System.out.println("----------------");
System.out.println("|    |    |    |");
System.out.println("|"+board[0][0]+ "   | " + board[0][1] +"  | "+ board[0][2]+"  |");
System.out.println("|----|----|----|");
System.out.println("|    |    |    |");
System.out.println("|"+board[1][0]+ "   | " + board[1][1] +"  | "+ board[1][2]+"  |");
System.out.println("|----|----|----|");
System.out.println("|    |    |    |");
System.out.println("|"+board[2][0]+ "   | " + board[2][1] +"  | "+ board[2][2]+"  |");
System.out.println("|    |    |    |");
System.out.println("----------------");

}

public static void playerTurn(){
if(turn=='X'){
System.out.println("Player(1)-X turn :");
}
else{
System.out.println("Player(2)-O turn :");
}
choice =new java.util.Scanner(System.in).nextInt();
switch(choice){

case 1:row=0;col=0;break; //first cell
case 2: row=0;col=1;break; //2nd cell
case 3: row=0;col=2;break; 
case 4: row=1;col=0;break; 
case 5: row=1;col=1;break;
case 6: row=1;col=2;break; 
case 7: row=2;col=0;break; 
case 8: row=2;col=1;break; 
case 9: row=2;col=2;break; 
default:System.out.println("Invalid input.");
}
if(choice>=1&&choice<=9){
if(turn=='X' && board[row][col]!='X' && board[row][col]!='O'){
board[row][col]='X';
turn='O';
}
else if(turn=='O' && board[row][col]!='O' && board[row][col]!='X'){
board[row][col]='O';
turn='X';
}
else{
System.out.println("Cell is already marked....Try other moves :");
playerTurn();
}
}
}

static boolean gameStatus(){

for(int i=0;i<3;i++){
//check winner row and col wise
if( (board[i][0]==board[i][1] && board[i][0]==board[i][2])|| (board[0][i]==board[1][i] && board[0][i]==board[2][i]) ){    //for i=0 1st row(board[i][0]==board[i][1] && board[i][0]==board[i][2])||1st col (board[0][i]==board[1][i] && board[0][i]==board[2][i]) 
return false;
}
}
//check winner diagonal wise
if((board[0][0]==board[1][1]&&board[0][0]==board[2][2])||(board[0][2]==board[1][1] && board[0][2]==board[2][0])){
return false;
}
//check if all cell is not fill then continue the game
for(int i=0;i<3;i++){
for(int j=0;j<3;j++){
if(board[i][j]!='X' && board[i][j]!='O'){
return true;
}
}
}

draw=true;
return false;
}

public static void main(String... s){
	Scanner sc=new Scanner(System.in);
System.out.println("\n\n---------- Tic Tak Toe Game Start----------\n\n");
System.out.println("Player(1)-X  Player(2)-O \n\n");
System.out.println("Press 1 for play: \nPress 2 for Quit:\n");
int play=sc.nextInt();
while(gameStatus() && play==1){
display();
playerTurn();
gameStatus();
}
if(play==1){//isse nahi lagane par quit par bhi chal jayega
if(turn=='O'&& draw==false){//becoz X apna turn chal kar o ka turn kar de raha hai isiliye agr O ka ho & draw==false to x win
	display();
System.out.println("Congratulation! Player(1)-X  has Won the game ");
}
else if(turn=='X'&& draw==false){
		display();

System.out.println("Congratulation! Player(2)-O  has Won the game ");
}
else if(draw==true){
System.out.println("Game Draw!");
}
}
System.out.println("Made By Monu Alam");
}
}