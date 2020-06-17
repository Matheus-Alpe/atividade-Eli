import javax.swing.JOptionPane;

public class Executavel {

	public static void main(String[] args) {
		String[] candidatos = {"Nulo", "Osmar", "Priscila", "Marcelo", "Henrique",
				"Rafael", "Creusa", "Astrofônica", "Asdrúbal", "Jucrécia", "Maria"};
		int[] qtVotos = new int[candidatos.length];
		
		String tabelaCand = "0 - Voto anulo \n1 - Osmar     |  6 - Creusa\n2 - Priscila    |  7 - Astrofôncia"
				+ " \n3 - Marcelo   |  8 -  Asdrúbal \n4 - Henrique |  9 - Jucrécia \n5 - Rafael      |  10 - Maria\n -1 para Cancelar";
		
		int voto = Integer.parseInt(JOptionPane.showInputDialog("Vote em um Candidato:\n" + tabelaCand));
		
		int posMaisVotado = -1;
		int maisVotos = 0;
		if(voto <= candidatos.length) {
			while(voto != -1) {
					if(voto < candidatos.length) {
					qtVotos[voto] += 1;
					
					if(qtVotos[voto] >= maisVotos && voto != 0) {
						posMaisVotado = voto;
						maisVotos = qtVotos[voto];
					}
					
					System.out.println(candidatos[voto] + " tem "+ qtVotos[voto]);
					
					voto = Integer.parseInt(JOptionPane.showInputDialog("Vote em um Candidato:\n" + tabelaCand));
				}else {
					JOptionPane.showMessageDialog(null, "Não existe este candidato!");
					voto = Integer.parseInt(JOptionPane.showInputDialog("Vote em um Candidato:\n" + tabelaCand));
				}
			}
			
			String resultado = "";
			String empatados = "";
			int cont = 0;
			for(int i = 1; i < candidatos.length; i++) {
				resultado += candidatos[i] + " qt votos: "+ qtVotos[i] + "\n";
					
				if(qtVotos[i] == maisVotos) {
					cont++;
					empatados += candidatos[i] + " - ";
				}
			}
			
			
			if(cont == 1) {						
				empatados = "";
			}
			
			if(!empatados.equals("")) {
				int posCarac = empatados.lastIndexOf("-");
				empatados = empatados.substring(0, posCarac);
				JOptionPane.showMessageDialog(null, "Resultado dos votos:\n" + resultado);
				JOptionPane.showMessageDialog(null, "Esses candidadtos empataram:\n" + empatados);
			} else {
				JOptionPane.showMessageDialog(null, "Resultado dos votos:\n" + resultado);
				JOptionPane.showMessageDialog(null, "Mais votado:\n" + candidatos[posMaisVotado] + " com " + qtVotos[posMaisVotado] + " votos.");
			}
			
			
			
			
		}else {
			JOptionPane.showMessageDialog(null, "Não existe este candidato!");
		}
		
		
	}

}
