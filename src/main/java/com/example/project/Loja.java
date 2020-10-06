package com.example.project;

public class Loja {
	private static final String ENDLN = System.lineSeparator();

    private String nomeLoja;
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String municipio;
    private String estado;
    private String cep;
    private String telefone;
    private String observacao;
    private String cnpj;
    private String inscricaoEstadual;

    public Loja(String nomeLoja, String logradouro, int numero, String complemento, String bairro, String municipio,
            String estado, String cep, String telefone, String observacao, String cnpj, String inscricaoEstadual) {
        this.nomeLoja = nomeLoja;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.municipio = municipio;
        this.estado = estado;
        this.cep = cep;
        this.telefone = telefone;
        this.observacao = observacao;
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getNomeLoja() {
        return this.nomeLoja;
    }

    public String getLogradouro() {
        return this.logradouro;
    }

    public int getNumero() {
        return this.numero;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public String getBairro() {
        return this.bairro;
    }

    public String getMunicipio() {
        return this.municipio;
    }

    public String getEstado() {
        return this.estado;
    }

    public String getCep() {
        return this.cep;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public String getInscricaoEstadual() {
        return this.inscricaoEstadual;
    }

    public String dadosLojaObjeto(Loja loja) {
		// Implemente aqui
		verificaLoja(loja);

		String numeroStr = (loja.getNumero() > 0) ? loja.getNumero() + "" : "s/n";

		String ln2 = loja.getLogradouro() + ", " + numeroStr;
		ln2 += isEmpty(loja.getComplemento()) ? "" : " " + loja.getComplemento();
		ln2 += ENDLN;

		String ln3 = "";
		ln3 += isEmpty( loja.getBairro() ) ? "" : loja.getBairro() + " - ";
		ln3 += loja.getMunicipio() + " - " + loja.getEstado() + ENDLN;

		String ln4 = "";
		ln4 += isEmpty( loja.getCep()) ? "" : "CEP:" + loja.getCep();
		

		if (!isEmpty( loja.getTelefone() )){
			ln4 += isEmpty(ln4) ? "" : " ";
			ln4 += "Tel " + loja.getTelefone();
		}
		ln4 += isEmpty(ln4) ? "" : ENDLN;

		String ln5 = "";
		ln5 += isEmpty( loja.getObservacao() ) ? "" : loja.getObservacao();
		ln5 += ENDLN;


		String output = loja.getNomeLoja() + ENDLN;
		output += ln2;
		output += ln3;
		output += ln4;
		output += ln5;
		output += "CNPJ: " + loja.getCnpj() + ENDLN;
		output += "IE: " + loja.getInscricaoEstadual() + ENDLN;

		return output;
	}

	private static boolean isEmpty(String str){
		if (str == null) return true;
		int spaceCount = str.length() - str.replace(".", "").length();
		return (spaceCount == str.length());
	}

	private static void verificaLoja(Loja loja) {
		if (isEmpty(loja.getMunicipio())){
			throw new RuntimeException("O campo município do endereço é obrigatório");
		}

		if (isEmpty(loja.getCnpj())) {
			throw new RuntimeException("O campo CNPJ da loja é obrigatório");
		}

		if (isEmpty(loja.getInscricaoEstadual())) {
			throw new RuntimeException("O campo inscrição estadual da loja é obrigatório");
		}

		if (isEmpty(loja.getNomeLoja())) {
			throw new RuntimeException("O campo nome da loja é obrigatório");
		}

		if (isEmpty(loja.getLogradouro())) {
			throw new RuntimeException("O campo logradouro do endereço é obrigatório");
		}

		if (isEmpty( loja.getEstado() )) {
			throw new RuntimeException("O campo estado do endereço é obrigatório");
		}
	}

}