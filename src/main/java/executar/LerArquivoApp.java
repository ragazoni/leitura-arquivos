package executar;

import model.DadosMercado;
import model.Operacoes;
import model.Produto;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class LerArquivoApp {
	public static void main(String[] args) throws IOException {

		//tempo de execução programa
		Long inicio = System.currentTimeMillis();

		List<Produto> produtoList = new ArrayList<>();
		List<DadosMercado> mercadoList = new ArrayList<>();

		File fileDadosMercado = new File("DadosMercado.csv");
		File fileOperacoes = new File("Operacoes.csv");

		String[] linhaOperacao = new String[14];
		String[] linhaDadosMercado = new String[3];
		String[] datas = new String[3];

		try(BufferedReader operacoes = new BufferedReader(new FileReader(fileOperacoes))) {
				 operacoes.readLine();

			String d;
			while ((d = operacoes.readLine()) != null) {

				linhaOperacao = d.split(";");
				d = null;

				//dias corridos operacoes
				datas = linhaOperacao[1].split("/");
				LocalDate dataIni = LocalDate.of(Integer.parseInt(datas[2]), Integer.parseInt(datas[1]), Integer.parseInt(datas[0]));
				datas = linhaOperacao[2].split("/");
				LocalDate dataFim = LocalDate.of(Integer.parseInt(datas[2]), Integer.parseInt(datas[1]), Integer.parseInt(datas[0]));
				Long diasCorridosOperacoes = ChronoUnit.DAYS.between(dataIni, dataFim);

				//pegando preco
				int idPrecoOperacoes = Integer.parseInt(linhaOperacao[13]);

				//pegando quantidade
				Double quantidade = Double.parseDouble(linhaOperacao[12].replace(",", "."));

				//pegando nome produto
				String nome = linhaOperacao[9];

				Produto produto = new Produto(nome);
				Operacoes operacao = new Operacoes(idPrecoOperacoes, diasCorridosOperacoes, quantidade);

				if (produtoList.isEmpty()) {
					produtoList.add(produto);
					produto.cadastroOperacoes(operacao);
				} else if (!produtoList.contains(produto)) {
					produtoList.add(produto);
					produto.cadastroOperacoes(operacao);
					for (Produto p : produtoList) {
						if (p.equals(produto)) {
							p.cadastroOperacoes(operacao);
						}
					}
				}
			}


		} catch (IOException e) {
			e.printStackTrace();
		}

		//pegar dias corridos e preco

		try(BufferedReader dadosMercado = new BufferedReader(new FileReader(fileDadosMercado))) {
			dadosMercado.readLine();

			String d;
			while ((d = dadosMercado.readLine()) != null){

				linhaDadosMercado = d.split(";");
				d = null;

				//pegar idpreco
				Long idpreco = Long.parseLong(linhaDadosMercado[0]);

				//pegar dias corridos
				Long diasCorridos  = Long.parseLong(linhaDadosMercado[1]);

				//pegar preco
				Double preco = Double.parseDouble(linhaDadosMercado[2].replace("," , "."));

				DadosMercado dadosM = new DadosMercado(idpreco,diasCorridos,preco);

				mercadoList.add(dadosM);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		for(Produto p : produtoList){
			for(Operacoes op : p.getOperacoesList()) {
				for(DadosMercado d : mercadoList) {
					if(op.getDiasCorridos() == d.getDiasCorridos() && (op.getIdPreco() == d.getIdPreco())) {
						p.resultado(op.getQuantidade(), d.getPreco());
						break;
					}
				}
			}
		}

		try(FileWriter escreve = new FileWriter("resultado.txt")) {
			escreve.append("Subproduto");
			escreve.append(";");
			escreve.append("Resultado");
			escreve.append("\n");
			for(Produto p : produtoList) {
				escreve.append(p.getNome());
				escreve.append(";");
				escreve.append(String.valueOf(p.getResultado()));
				escreve.append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		Long fim = System.currentTimeMillis();
		System.out.println("Tempo de execução " + (fim - inicio) + " ms");

	}



}
