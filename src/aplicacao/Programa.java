package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import entidades.EntradaLog;

public class Programa {

	public static void main(String[] args) {

		// Scanner sc= new Scanner (System.in);
		System.out.println("Informe o caminho completo do arquivo: ");
		// c:\temp\log.txt
		// String caminho=sc.nextLine();
		// \ antes da \ para a \ ser interpretada como caractere
		String caminho = "c:\\temp\\log.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

			// list aceita elementos repetidos, seria um estrutura de dados adequada ser
			// quiser
			// ver todos os logs
			List<EntradaLog> listaLogs = new ArrayList<EntradaLog>();
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(" ");
				String userName = fields[0];
				Date moment = Date.from(Instant.parse(fields[1]));
				listaLogs.add(new EntradaLog(userName, moment));
				line = br.readLine();
			}

			// ordeando lista por nome
			Collections.sort(listaLogs);

			System.out.println("\nImprimindo o log completo");
			int i = 1;
			for (EntradaLog nickname : listaLogs) {
				System.out.println(i + "." + nickname);
				i++;
			}

			System.out.println("Tamanho de registros de Log de Usu�rios: " + listaLogs.size());

		} catch (IOException error) {
			System.out.println("Error: " + error.getMessage());
		}

		try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

			Set<EntradaLog> setLog = new HashSet<EntradaLog>();
			String linha = br.readLine();

			while (linha != null) {
				// vetor do tipo String
				String[] campos = linha.split(" ");
				String nomeDeUsuario = campos[0];
				Date data = Date.from(Instant.parse(campos[1]));
				// set n�o vai aceitar adicionar log do mesmo usu�rio
				setLog.add(new EntradaLog(nomeDeUsuario, data));
				linha = br.readLine();
			}

			System.out.println("\nSet n�o aceita elementos repetidos. Ideal para arquivar apenas 1 log por usu�rio");
			System.out.println("Imprimindo o set (apenas 1 log por usu�rio)");
			int i=1;
			for (EntradaLog apelido : setLog) {
				System.out.println(i + "." + apelido);
				i++;
			}

			System.out.println("O n�mero de usu�rio diferentes do arquivo � " + setLog.size() + ".");
		}

		catch (IOException erro) {
			System.out.println("Erro: " + erro.getMessage());
		}

		// sc.close();

	}

}
