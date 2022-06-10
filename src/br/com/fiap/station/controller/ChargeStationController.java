package br.com.fiap.station.controller;

import br.com.fiap.station.controller.entrance.ChargeStationEntrance;
import br.com.fiap.station.model.ChargeStation;
import br.com.fiap.station.view.Window;

import java.util.List;

public class ChargeStationController {

	ChargeStationEntrance estacaoRecargaGateway;
	Window janela;
	
	public ChargeStationController(Window janela) {
		estacaoRecargaGateway = new ChargeStationEntrance();
		this.janela = janela;
	}

	public List<ChargeStation> listStations() {
		return estacaoRecargaGateway.listarEstacoes();
	}

	public void salvarEstacao(String nome, String rua, String bairro, String cidade, String estado, List<String> plugs, int avaliacao, Double preco) {
		ChargeStation chargeStation = new ChargeStation(nome, rua, bairro, cidade, estado, plugs, avaliacao, preco);
		estacaoRecargaGateway.inserir(chargeStation);
		janela.buscarLista().atualizar();
	}
	
	public void delecao(Long id) {
		ChargeStation chargeStation = new ChargeStation();
		chargeStation.setId(id);
		
		estacaoRecargaGateway.delecao(chargeStation);
		janela.buscarLista().atualizar();
	}



}
