package IfIRanAZoo;

public class QuestionNode extends Node{

		String question;
		Node yesChild;
		Node noChild;
		
		QuestionNode(String q, Node y, Node n){
			question=q;
			yesChild=y;
			noChild=n;
		}
	}

