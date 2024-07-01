class TicTakToeBlank1{
	static char [][]board={{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
	static int row,col,choice;
	static char turn='X';
	static boolean draw=false;
	
	public static void display(){	
		System.out.println("----------------------");
		System.out.println("|  "+board[0][0]+"   |   "+board[0][1]+"  |  "+board[0][2]+"   |");
		System.out.println("|------|------|------|");
		System.out.println("|  "+board[1][0]+"   |   "+board[1][1]+"  |  "+board[1][2]+"   |");
		System.out.println("|------|------|------|");
		System.out.println("|  "+board[2][0]+"   |   "+board[2][1]+"  |  "+board[2][2]+"   |");
		System.out.println("----------------------");	
	}
	
	public static void playerTurn(){
		
		if(turn=='X'){
			System.out.println("Player(X)-1 turn Choose moves(1-9):");
		}
		else{
			System.out.println("Player(O)-2 turn Choose moves(1-9):");
		}
		choice=new java.util.Scanner(System.in).nextInt();
		switch(choice){
			case 1:row=0;col=0;break;
			case 2:row=0;col=1;break;
			case 3:row=0;col=2;break;
			case 4:row=1;col=0;break;
			case 5:row=1;col=1;break;
			case 6:row=1;col=2;break;
			case 7:row=2;col=0;break;
			case 8:row=2;col=1;break;
			case 9:row=2;col=2;break;
			default:System.out.println("Invalid Moves!");				
		}
		if((choice>=1 && choice<=9)){			
			//set marks on the cell
			if(turn=='X' && board[row][col]!='X' && board[row][col]!='O' ){
				board[row][col]='X';
				turn='O';
				}else if (turn=='O' && board[row][col]!='O' && board[row][col]!='X' ){
				board[row][col]='O';
				turn='X';
				}else{
				System.out.println("Cell is Marked .....Choose other move!");
				playerTurn();
			}
		}
	}
	
	static boolean checkWinner(){
		//check for row and col wise winner	
		for(int i=0;i<3;i++){
			if((board[i][0]!=' ' && board[i][0]==board[i][1]&&board[i][0]==board[i][2])||(board[0][i]!=' '&&board[0][i]==board[1][i]&&board[0][i]==board[2][i])){
				return false;
			}
		}
		//check winner diagonaly
		if((board[0][0]!=' '&&board[0][0]==board[1][1]&&board[0][0]==board[2][2])||(board[0][2]!=' ' && board[0][2]==board[1][1]&&board[0][2]==board[2][0])){
			return false;
		}
		//agr koi bhi cell khali hai to chalega ..agr sare cell fill ho gaye to nahi chalega and true return karega and fhir while loop chalega
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
		System.out.println("\n\n----------Tic Tak Toe Game Start---------\n\n");
		System.out.println("Enter 1 for Play:\nEnter 2 for Quit:");
		int play=new java.util.Scanner(System.in).nextInt();
		
		if(play==1){
			while(checkWinner()){
				display();
				playerTurn();	
			}
			if(turn=='X'&& draw==false){
				display();
				System.out.println("Congratulation! Player(2)-O  has Won Game:");
				}else if(turn=='O'&& draw==false){
				display();
				System.out.println("Congratulation! Player(1)-X  has Won Game:");
				}else{
				display();
				System.out.println("Game Draw!");
			}
		}
		System.out.println("Game Over!!");
		System.out.println("Made by Monu");
	}
}