public class ContaBancaria {
    private int numero;
    private int senha;
    private String cliente;
    private double saldo;
    private double limiteEspecial;

    public ContaBancaria(int numero, int senha, String cliente, double saldo, double limiteEspecial) {
        this.numero = numero;
        this.senha = senha;
        this.cliente = cliente;
        this.saldo = saldo;
        this.limiteEspecial = limiteEspecial;
    }

    public int getNumero() {
        return numero;
    }

    public int getSenha() {
        return senha;
    }

    public String getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimiteEspecial() {
        return limiteEspecial;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setLimiteEspecial(double limiteEspecial) {
        this.limiteEspecial = limiteEspecial;
    }

    @Override
    public String toString() {
        return numero + " " + senha + " " + cliente + " " + saldo + " " + limiteEspecial;
    }

    public boolean verificarSenha(int senha) {
        return this.senha == senha;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public boolean sacar(double valor) {
        if (saldo + limiteEspecial >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }
}
