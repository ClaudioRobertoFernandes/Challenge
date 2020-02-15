package produto;

public class Produto {
	 int Id;                
	   String Nome;                
	   String VeiculoAplicacao;    
	   float NetWeight;            
	   float GrossWeight;
	
	   public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getVeiculoAplicacao() {
		return VeiculoAplicacao;
	}
	public void setVeiculoAplicacao(String veiculoAplicacao) {
		VeiculoAplicacao = veiculoAplicacao;
	}
	public float getNetWeight() {
		return NetWeight;
	}
	public void setNetWeight(float netWeight) {
		NetWeight = netWeight;
	}
	public float getGrossWeight() {
		return GrossWeight;
	}
	public void setGrossWeight(float grossWeight) {
		GrossWeight = grossWeight;
	} 
	   
	   
}
