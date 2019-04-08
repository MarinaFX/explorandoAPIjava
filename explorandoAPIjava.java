import java.util.*;

public class CadastroUsuarios {
    private ArrayList<Pessoa> cadastro;
    private List<Pessoa> linkedList;
    private Set<Pessoa> setAux;

    public CadastroUsuarios() {
        Reader rd = new Reader();
        rd.fileReader();
        cadastro = rd.getList();
    }

    public void mostraLista() {  //iterar sobre cadastro
        for (Pessoa p : cadastro) {
            System.out.println(p.toString());
        }
        System.out.println("Array list size -> " + cadastro.size());
    }

    public void mostraListaLinked() {
        for (Pessoa p : linkedList) {
            System.out.println(p.toString());
        }
        System.out.println("Linked list size -> " + linkedList.size());
    }

    public void mostraHashSet(){
        for (Pessoa p : setAux){
            System.out.println(p);
        }
        System.out.println("HashSet size -> " + setAux.size());
    }

    public int removeUserPorIP(String numeros) {// Remover TODOS os usuários cujo endereço ip comece por um número indicado retornando à quantidade de removidos
        setAux = new HashSet<>(cadastro);
        int usersRemovidos = 0;

        if (numeros.length() == 1){
            for (Pessoa p : cadastro) {
                if ((p.getIP().charAt(0) == numeros.charAt(0))) {
                    setAux.remove(p);
                    usersRemovidos++;
                }
            }
        }

        if (numeros.length() == 2){
            for (Pessoa p : cadastro) {
                if ((p.getIP().charAt(0) == numeros.charAt(0)) &&
                        (p.getIP().charAt(1) == numeros.charAt(1))) {
                    setAux.remove(p);
                    usersRemovidos++;
                }
            }
        }

        if (numeros.length() == 3){
            for (Pessoa p : cadastro) {
                if ((p.getIP().charAt(0) == numeros.charAt(0)) &&
                        (p.getIP().charAt(1) == numeros.charAt(1)) &&
                        (p.getIP().charAt(2) == numeros.charAt(2))) {
                    setAux.remove(p);
                    usersRemovidos++;
                }
            }
        }

        return usersRemovidos;
    }

    public boolean cadastraPessoa(String name, String lastName) { //insere usuário após um usuário identificado por nome e sobrenome indicados
        linkedList = new LinkedList<>(cadastro);
        setAux = new HashSet<>(cadastro);
        Pessoa pessoaAux = getPessoaPorNome(name, lastName);

        if (setAux.contains(pessoaAux)) {
            int index = pessoaAux.getId();
            linkedList.add((index + 1), new Pessoa("Marina", "De Pazzi",
                    "Marina.Pazzi@dmc.com", "115.174.225.15", (index + 1), "Female"));
            return true;
        }

        return false;
    }

    private Pessoa getPessoaPorIP(String IP) {
        Pessoa p = null;
        for (Pessoa f : cadastro) {
            if (f.getIP().equals(IP))
                p = f;
        }

        return p;
    }

    private Pessoa getPessoaPorNome(String name, String lastName) {
        for (Pessoa p : cadastro) {
            if ((p.getFirstName().equals(name)) && (p.getLastName().equals(lastName))) {
                return p;
            }
        }
        return null;
    }


    public void ordenaUsersNome() { //porra, o nome ja diz asiudhaoisdal
        Collections.sort(cadastro, Pessoa::compareToName);
        //Collections.sort(linkedList, Pessoa::compareToName);
        //Collections.sort(linkedList, Pessoa::compareToName);
    }

    public void inverteOrdem() { //explorando Collections
        Collections.reverseOrder(Pessoa::compareToName);
    }

    public boolean embaralhaOrdem() { //explorando Collections
        return false;
    }

    public boolean copiaOrdem() { //explorando Collections
        return false;
    }

    public boolean preencheOrdem() { //explorando Collections
        return false;
    }
}