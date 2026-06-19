package br.com.nexdom.model;

public class SolicitacaoAutorizacao {

    private Long id;
    private Integer procedimento;
    private Integer idade;
    private String sexo;
    private Boolean autorizado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Integer procedimento) {
        this.procedimento = procedimento;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Boolean getAutorizado() {
        return autorizado;
    }

    public void setAutorizado(Boolean autorizado) {
        this.autorizado = autorizado;
    }
}