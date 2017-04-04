package IfIRanAZoo;
import java.util.*;
import java.io.*;

/*
 * This program plays a guessing game in which the player thinks of an animal and the computer attempts to guess it
 * the computer "learns" more animals when playing, and thus gets better at guessing.
 * 
 * It will load any saved knowledge from a "zoo.dat" file, and at the end of running it will save to said file.
 * If the file does not yet exist on a player's device, the program will create a generic seed question and start from scratch
 * 
 * @author Jack Weathington
 * @version Nov. 12, 2016
 */



public class zoo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Think of an animal and I will try to guess it.");
		Scanner kb=new Scanner(System.in);
		boolean cont=true;
		QuestionNode first=load(); //calls load to get the root QuestionNode
		
		while (cont){
			
		askQuestion(first);	//an entire game is played by calling this recursive method
		save(first); //calls save with most up to date question tree
		System.out.println("Would you like to play again?");
		if (kb.nextLine().equals("no")){
			System.out.println("Bye");
			save(first); //calls save with the now updated root questionNode
			kb.close();
			cont=false; //will make the while loop and therefore program end
		}
		}
		
		
	}
	
	static void askQuestion(QuestionNode qN){
		Scanner kb=new Scanner(System.in);
		System.out.println(qN.question);
		Node response;
		boolean yes;
		
		//if-else block to determine get the yes or no child depending on answer
		if (kb.nextLine().equals("yes")){
			response=qN.yesChild;
			yes=true;
		}
		else{
			response=qN.noChild;
			yes=false;
		}
		
		if (response.getClass().equals(AnimalNode.class)){//checks to see if new node is an animalNode
			AnimalNode aResponse=(AnimalNode)response; //casts it into AnimalNode to be usable
			
			//checks to see if it guessed the right animal. if not, creates a new question
			System.out.println("Is it "+aResponse.animal+"?");
			if(kb.nextLine().equals("no")){ 
				System.out.println("Ok, you stumped me!");
				QuestionNode qNew= getNewQuestion(aResponse); //gets the new question node
				
				//assigns new question to proper branch of the tree
				if(yes){
					qN.yesChild=qNew;
				}else{
					qN.noChild=qNew;
				}
			}
		}else{ //if new node is a question, recursively calls itself and continues asking
			//kb.close();
			askQuestion((QuestionNode)response);
		}
	}
	
	static QuestionNode getNewQuestion(AnimalNode aN){ //creates and returns a new QuestionNode
		Scanner kb=new Scanner(System.in);
		System.out.println("What were you thinking of?");
		String animal=kb.nextLine();
		AnimalNode a=new AnimalNode(animal);
		System.out.println("What would be a question to distinguish "+aN.animal+" from "+animal+"?");
		String question=kb.nextLine();
		System.out.println("And the answer for "+animal+" would be?");
		if (kb.nextLine().equals("yes")){
			QuestionNode qN=new QuestionNode(question, a, aN);
			return qN;
		}
		else{
			QuestionNode qN=new QuestionNode(question, aN, a);
			return qN;
		}
	}
	
	public static void save(QuestionNode qn){ //used to save updated question trees
		    
		try {
			
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("zoo.dat")); //creates an object stream to zoo.dat
			oos.writeObject(qn); //saves qn(which has all new questions in it as subnodes) as a binary object to the disk, which means it can be simply read back as a QuestionNode object
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//System.out.println("In save's IO exception catch");
		}
	}
	
	public static QuestionNode load(){ //used to load question trees from the disk
		try{
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream("zoo.dat") ); //creates a stream to read from the zoo.dat file
			return (QuestionNode)ois.readObject(); //reads out and returns an entire data tree, since it reads out first the root questionNode which contains
												   // all the other nodes within it.
			
		}catch(IOException e){//this catch block will always be entered when the program is run on a device without an accessible zoo.dat
			//System.out.println("File was missing");
			return new QuestionNode("Is it bigger than a house?", new AnimalNode("an elephant"), new AnimalNode("a mouse"));//it will return the generic root question
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//System.out.println("Missing part of code related to the Nodes");
			return new QuestionNode("Is it bigger than a house?", new AnimalNode("an elephant"), new AnimalNode("a mouse"));
		}
	}

}
