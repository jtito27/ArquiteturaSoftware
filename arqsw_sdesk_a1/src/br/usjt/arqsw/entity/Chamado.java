package br.usjt.arqsw.entity;

import java.sql.Date;

public class Chamado {
	private int id_chamado;
	private String descricao;
	private String status;
	private Date dt_abertura;
	private Date dt_fechamento;
	private Fila id_fila;
	
	public int getId_chamado() {
		return id_chamado;
	}
	public void setId_chamado(int id_chamado) {
		this.id_chamado = id_chamado;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDt_abertura() {
		return dt_abertura;
	}
	public void setDt_abertura(Date dt_abertura) {
		this.dt_abertura = dt_abertura;
	}
	public Date getDt_fechamento() {
		return dt_fechamento;
	}
	public void setDt_fechamento(Date dt_fechamento) {
		this.dt_fechamento = dt_fechamento;
	}
	public Fila getId_fila() {
		return id_fila;
	}
	public void setId_fila(Fila id_fila) {
		this.id_fila = id_fila;
	}
	public String toString() {
		return "Chamado [id_chamado=" + id_chamado + ", descricao=" + descricao + ", status" + status + ", data_abertura" + dt_abertura 
				+ ", data_fechamento" + dt_fechamento + ", id_fila" + id_fila +  "]";
	}
	
}