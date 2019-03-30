package pacote;

public final class Principal {
	
	private static Principal principal;
	private Documento doc;
	
	private Principal() {
		this.doc = new Documento();
		new MeuFrame(this.doc);
	}
	
	
	public static Principal getPrincipal() {
		if(Principal.principal == null)
			Principal.principal = new Principal();
		return Principal.principal;
	}
	
	public Documento getDocumentoAtivo(){
		if(this.doc == null)
			this.doc = new Documento();
		return doc;
	}
	
	public static void main(String[] args) {
			Principal.getPrincipal();
	}

}
