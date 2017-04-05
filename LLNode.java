
public class LLNode {
	private String info;
	private LLNode link;
	
	LLNode(String info){
		this.info=info;
		link=null;
	}
	
	LLNode getLink(){
		return link;
	}
	
	void setLink(LLNode node){
		this.link=node;
	}
	
	String getInfo(){
		return info;
	}
}
