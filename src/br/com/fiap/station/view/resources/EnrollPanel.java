package br.com.fiap.station.view.resources;

import br.com.fiap.station.controller.ChargeStationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Objects;

public class EnrollPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel img = new JLabel(new ImageIcon(""));
	private DefaultLabel nome = new DefaultLabel("Station Name:");
	private FieldText nomeTxt = new FieldText();
	private DefaultLabel rua = new DefaultLabel("Street:");
	private FieldText ruaTxt = new FieldText();
	private DefaultLabel bairro = new DefaultLabel("District:");
	private FieldText bairroTxt = new FieldText();
	private DefaultLabel cidade = new DefaultLabel("City:");
	private FieldText cidadeTxt = new FieldText();
	private DefaultLabel preco = new DefaultLabel("Price:");
	private FieldText precoTxt = new FieldText();
	private DefaultLabel estado = new DefaultLabel("State:");
	private JComboBox<String> estadoCBX = new JComboBox<>(new String[]{ "CE",	"PE",	"MG",	"MT"});
	private DefaultLabel plug = new DefaultLabel("Plug:");
	private DefaultLabel avaliacao = new DefaultLabel("Classification:");
	private JButton salvar = new JButton();
	private JButton cancelar = new JButton();
	private ChargeStationController estacaoRecargaControlador;
	
	public EnrollPanel(ChargeStationController estacaoRecargaControlador) {
		setLayout(null);

		this.estacaoRecargaControlador = estacaoRecargaControlador;
	}
	
	public void init() {

		img.setBounds(40, 35, 280, 250);
		redimensionarImagem(img);
		this.add(img);

		nome.setBounds(
				img.getX() + img.getWidth() + 50, 28, 200, 15);
		this.add(nome);
		nomeTxt.setBounds(
				nome.getX(),
				nome.getY()+ nome.getHeight() +10,250,29);
		this.add(nomeTxt);

		rua.setBounds(
				nomeTxt.getX(),
				nomeTxt.getY()+ nomeTxt.getHeight() +20, 100, 15);
		this.add(rua);
		ruaTxt.setBounds(
				rua.getX(),
				rua.getY()+ rua.getHeight() +10, 250, 29);
		this.add(ruaTxt);

		bairro.setBounds(
				ruaTxt.getX(),
				ruaTxt.getY()+ ruaTxt.getHeight() + 15, 100, 15);
		this.add(bairro);
		bairroTxt.setBounds(
				bairro.getX(),
				bairro.getY()+ bairro.getHeight() + 10, 250, 29);
		this.add(bairroTxt);

		cidade.setBounds(
				bairroTxt.getX(),
				bairroTxt.getY()+ bairroTxt.getHeight() + 15, 100, 15);
		this.add(cidade);
		cidadeTxt.setBounds(
				cidade.getX(),
				cidade.getY()+ cidade.getHeight() + 10, 250, 29);
		this.add(cidadeTxt);

		preco.setBounds(
				cidadeTxt.getX(),
				cidadeTxt.getY() + cidadeTxt.getHeight() + 10, 100, 15);
		this.add(preco);
		precoTxt.setBounds(
				preco.getX(),
				preco.getY()+ preco.getHeight() + 10, 250, 29);
		this.add(precoTxt);

		estado.setBounds(
				precoTxt.getX(),
				precoTxt.getY() + precoTxt.getHeight() + 15, 100, 15);
		this.add(estado);
		estadoCBX.setBounds(
				estado.getX(),
				estado.getY()+ estado.getHeight() +10, 250, 29);

		estadoCBX.setFont(new Font("Arial", Font.PLAIN, 16));
		this.add(estadoCBX);

		//salvar
		salvar.setBounds(
				estadoCBX.getX(),
				estadoCBX.getY()+ estadoCBX.getHeight()+20, 100,38);
		salvar.setFont(new Font("Arial", Font.PLAIN, 14));
		salvar.setText("Save");
		this.add(salvar);

		//cancelar
		cancelar.setBounds(
				salvar.getX()+ salvar.getWidth()+15,
				salvar.getY(), 140, 38);
		cancelar.setFont(new Font("Arial", Font.PLAIN, 14));
		cancelar.setText("Cancel");
		this.add(cancelar);

		plug.setBounds(
				nomeTxt.getX() + nomeTxt.getWidth() + 50,
				nome.getY(),150, 15);
		this.add(plug);
		
        JRadioButton radio1 = new JRadioButton();
        radio1.setText("Tesla");
        radio1.setBounds(
        		plug.getX(),
        		plug.getY() + plug.getHeight() + 15, 150, 15);
        radio1.setFont(new Font("Arial", Font.PLAIN, 15));

        JRadioButton radio2 = new JRadioButton();
        radio2.setText("CCS");
        radio2.setBounds(
        		radio1.getX(),
        		radio1.getY() + radio1.getHeight() + 10, 150, 15);
        radio2.setFont(new Font("Arial", Font.PLAIN, 15));

        JRadioButton radio3 = new JRadioButton();
        radio3.setText("Tipo 1");
        radio3.setBounds(
        		radio2.getX(),
        		radio2.getY() + radio2.getHeight() + 10, 150, 15);
        radio3.setFont(new Font("Arial", Font.PLAIN, 15));

		JRadioButton radio4 = new JRadioButton();
		radio4.setText("Tipo 2");
		radio4.setBounds(
				radio3.getX(),
				radio3.getY() + radio3.getHeight() + 10, 150, 15);
		radio4.setFont(new Font("Arial", Font.PLAIN, 15));

        this.add(radio1);
        this.add(radio2);
        this.add(radio3);
		this.add(radio4);

        avaliacao.setBounds(
        		radio4.getX(),
        		radio4.getY() + radio4.getHeight() + 20, 150, 15);
        this.add(avaliacao);
        
        StarRater avaliacaoFld = new StarRater(5);
        avaliacaoFld.setBounds(
        		avaliacao.getX(),
        		avaliacao.getY() + avaliacao.getHeight() + 15, 150, 15);
        this.add(avaliacaoFld);

		salvar.addActionListener((ActionEvent e)->{
			boolean invalido = nomeTxt.getText().equalsIgnoreCase("");
			invalido = invalido || ruaTxt.getText().equalsIgnoreCase("");
			invalido = invalido || bairroTxt.getText().equalsIgnoreCase("");
			invalido = invalido || cidadeTxt.getText().equalsIgnoreCase("");
			invalido = invalido || ((String) estadoCBX.getSelectedItem()).equalsIgnoreCase("");
			invalido = invalido || !( radio1.isSelected()
					|| radio2.isSelected()
					|| radio3.isSelected()
					|| radio4.isSelected());
			invalido = invalido || avaliacaoFld.getSelection() == 0;
			invalido = invalido || precoTxt.getText().equalsIgnoreCase("");

			ArrayList<String> plugsCarregadores = new ArrayList<>();

			String radio1Selecionado =  radio1.isSelected() ? radio1.getText() : null;
			if(Objects.nonNull(radio1Selecionado)){
				plugsCarregadores.add(radio1Selecionado);
			}

			String radio2Selecionado =  radio2.isSelected() ? radio2.getText() : null;
			if(Objects.nonNull(radio2Selecionado)){
				plugsCarregadores.add(radio2Selecionado);
			}

			String radio3Selecionado =  radio3.isSelected() ? radio3.getText() : null;
			if(Objects.nonNull(radio3Selecionado)){
				plugsCarregadores.add(radio3Selecionado);
			}

			String radio4Selecionado =  radio4.isSelected() ? radio4.getText() : null;
			if(Objects.nonNull(radio4Selecionado)){
				plugsCarregadores.add(radio4Selecionado);
			}

			estacaoRecargaControlador.salvarEstacao(
					nomeTxt.getText(),
					ruaTxt.getText().trim(),
					bairroTxt.getText().trim(),
					cidadeTxt.getText().trim(),
					(String) estadoCBX.getSelectedItem(),
					plugsCarregadores,
					avaliacaoFld.getSelection(),
					Double.valueOf(precoTxt.getText())
					);	
		});
		cancelar.addActionListener((ActionEvent e)->{
			nomeTxt.setText("");
			ruaTxt.setText("");
			bairroTxt.setText("");
			estadoCBX.setSelectedIndex(0);
			avaliacaoFld.setSelection(0);
 		});

		setVisible(true);
	}

	public void redimensionarImagem(JLabel imagem) {
		imagem.setBounds(imagem.getX(), imagem.getY(), imagem.getWidth(), imagem.getHeight());
		ImageIcon imageIcon = (ImageIcon) imagem.getIcon();
        Image image = imageIcon.getImage();
        Image imagemRedimensionada = image.getScaledInstance(imagem.getWidth(), imagem.getHeight(),Image.SCALE_SMOOTH);
        imagem.setIcon( new ImageIcon(imagemRedimensionada) );
	}
}
