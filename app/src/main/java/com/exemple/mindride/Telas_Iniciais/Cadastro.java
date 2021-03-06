package com.exemple.mindride.Telas_Iniciais;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import com.exemple.mindride.Banco_de_Dados.BD_Interno;
import com.exemple.mindride.Banco_de_Dados.BD_Interno_Dados;
import com.exemple.mindride.Banco_de_Dados.ConectaBD;
import com.exemple.mindride.Player.MySingleton;
import com.exemple.mindride.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Cadastro.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Cadastro#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Cadastro extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static MediaPlayer mediaPlayer = MySingleton.getInstance();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Cadastro() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Cadastro.
     */
    // TODO: Rename and change types and number of parameters
    public static Cadastro newInstance(String param1, String param2) {
        Cadastro fragment = new Cadastro();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public void onStart(){
        super.onStart();
        mediaPlayer.reset();
        mediaPlayer.stop();
    }


    // Criar a conex??o com o banco (busca as configura????es do arquivo JSON)
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    // Cria uma referencia para o ponto inicial do banco
    DatabaseReference reference  = database.getReference();

    //M??todo validador de email





    private static EditText email ,nome,senha;
    private static Spinner dia,mes,ano;
    private static CheckBox termos;
    private static RadioButton macho, femea;
    private static View comando;

    public EditText getEmail() {
        return email;
    }

    public EditText getNome() {
        return this.nome;
    }

    public EditText getSenha() {
        return this.senha;
    }

    public Spinner getDia() {
        return this.dia;
    }

    public Spinner getMes() {
        return this.mes;
    }

    public Spinner getAno() {
        return this.ano;
    }

    public RadioButton getMacho() {
        return this.macho;
    }
    public View getComando(){
        return this.comando;
    }

    public CheckBox getTermos() {
        return this.termos;
    }

    //Testa se a sintaxe do email ?? valida
    private boolean  val (EditText email){
        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
        Matcher m = p.matcher(email.getText());
        boolean matchFound = m.matches();
        if (!matchFound) {
            return false;
        }
        return true;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        comando = inflater.inflate(R.layout.cadastro, container, false);

        email = comando.findViewById(R.id.cEmail);
        senha = comando.findViewById(R.id.cSenha);
        nome = comando.findViewById(R.id.cNome);
        dia = comando.findViewById(R.id.cDia);
        mes = comando.findViewById(R.id.cMes);
        ano = comando.findViewById(R.id.cAno);
        termos = comando.findViewById(R.id.cTermos);
        macho = comando.findViewById(R.id.cMasc);
        femea = comando.findViewById(R.id.cFem);




        termos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                termos.setChecked(false);
                AlertDialog.Builder alertConfig = new AlertDialog.Builder(comando.getContext(),R.style.Theme_Design_NoActionBar);
                alertConfig.setTitle("Termos de Uso");
                alertConfig.setMessage("Um bolo fofinho cai muito bem em diferentes momentos do dia, seja para um caf?? da manh??, sobremesa ou lanche da tarde. Essa textura ?? macia e deliciosa e voc?? pode obter esse resultado independente do sabor que escolher para o seu quitute!\n" +
                        "\n" +
                        "CONTINUA AP??S O AN??NCIO\n" +
                        "\n" +
                        "\n" +
                        "Voc?? pode escolher sabores mais leves e neutros, sabores de frutas, chocolate, cenoura e at?? mesmo op????es sem gl??ten, lactose ou veganas! Assim, ?? poss??vel ter um leque imenso de op????es e n??o cair na rotina quando quiser comer um bolinho supergostoso.\n" +
                        "\n" +
                        "Para que voc?? conhe??a algumas op????es e possa testar casa, basta conferir a lista abaixo:\n" +
                        "\n" +
                        "\n" +
                        "Bolo fofinho simples\n" +
                        "FOTO: REPRODU????O / PANELATERAPIA\n" +
                        "1. Bolo fofinho de fub??: o bolo de fub?? ?? um cl??ssico para muita gente, mas voc?? conhece uma receita em que a massa fica extremamente fofa? Se voc?? n??o sabe como obter um resultado desses em um bolo de fub??, confira todas as dicas para uma textura incr??vel.\n" +
                        "\n" +
                        "2. Bolo fofinho simples: que tal conhecer uma receita de massa b??sica, que pode ser combinada com uma grande quantidade de coberturas e recheios ou at?? mesmo aromatizada com ingredientes simples, como ess??ncia de baunilha, raspas de lim??o e outros?\n" +
                        "\n" +
                        "3. Bolo fofinho de iogurte: quer preparar o bolo de iogurte mais fofo da vida? Ent??o, confira as dicas desta receita, que conta com uma massa de liquidificador, ideal para quem n??o quer perder muito tempo na cozinha, mas deseja um resultado delicioso.\n" +
                        "\n" +
                        "4. Bolo fofinho de creme de leite: nessa receita, voc?? aprende a fazer uma massa bem fofinha, mas que ao mesmo tempo ?? amanteigada. Para testar essa op????o em casa, voc?? vai precisar de ovos, manteiga, a????car, creme de leite, extrato de baunilha, leite, farinha de trigo e fermento em p??. A lista de ingredientes n??o ?? extensa e essa ?? uma ??tima op????o para ser servida com um caf?? quentinho.\n" +
                        "\n" +
                        "5. Bolo fofinho de nada: bolo de nada? Sim, esse ?? o sabor dessa receita, que pode ser aromatizada com os ingredientes que voc?? preferir, como chocolate, por exemplo. Por??m, o simples tamb??m ?? bem gostoso. Uma boa pedida ?? servir com uma fatia com manteiga, ela ir?? derreter na massa e o resultado vai deixar qualquer um com ??gua na boca.\n" +
                        "\n" +
                        "6. Bolo fofinho de baunilha: uma massa de baunilha combina muito bem com diversas situa????es, j?? que pode ser servida sem nada ou at?? mesmo incrementada para garantir um bolo mais sofisticado ou at?? mesmo com cara de festa. Essa ?? uma op????o que n??o conta com um preparo complicado, mas pode surpreender quem experimentar um peda??o.\n" +
                        "\n" +
                        "CONTINUA AP??S O AN??NCIO\n" +
                        "\n" +
                        "\n" +
                        "7. Bolo fofinho de vinagre: vinagre no bolo, ?? isso mesmo? Sim! Aqui, esse ingrediente entra em cena para deixar a massa bem fofinha. Ah, e na hora de comer o bolo, pode ficar tranquilo, pois ele n??o fica nem com cheiro e nem com sabor de vinagre. Esse item ?? usado apenas para dar uma textura mais gostosa ao bolo.\n" +
                        "\n" +
                        "8. Bolo simples sem fermento: sabia que ?? poss??vel fazer um bolo com massa fofinha sem utilizar fermento? Essa receita ?? a prova disso! O resultado ?? um sabor neutro, ent??o, voc?? pode increment??-la com os ingredientes de sua prefer??ncia.\n" +
                        "\n" +
                        "9. Bolo fofinho de rapadura: quer um bolo com gostinho especial, f??cil de ser feito e que fique com uma textura bem fofa? Ent??o, voc?? precisa conhecer todas as dicas desta op????o. O preparo n??o ?? nada complicado, mas voc?? pode se surpreender com o resultado final.\n" +
                        "\n" +
                        "10. Bolo fofinho de nata: para testar essa receita em casa voc?? vai precisar apenas de nata, a????car, ovos, farinha de trigo e fermento em p??. Mesmo com uma lista de ingredientes t??o curtinha, o sabor neutro ?? bem gostoso e a textura ?? bem macia.\n" +
                        "\n" +
                        "Bolo fofinho de chocolate").setPositiveButton(
                        "Aceitar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                termos.setChecked(true);
                            }
                        }).setNegativeButton("Recusar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        termos.setChecked(false);
                    }
                });
                AlertDialog alert = alertConfig.create();
                alert.show();

            }
        });


        comando.findViewById(R.id.cCadastrar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ConectaBD conecta = new ConectaBD();
                conecta.MetodoCadastrar();

                /* converte valores para serem inserida no
                 * banco de dados do SQLite */
                String genero;
                if(getMacho().isChecked()){
                    genero = "masculino";
                }else{ genero = "feminino";}

                int valorTermos;
                if(getTermos().isChecked()){
                    valorTermos = 1;
                }else {valorTermos = 0;}


                if(val(getEmail()) == true  && getEmail().getText().toString().length() >12 &&
                        getNome().getText().toString().length() > 8 && getSenha().getText().toString().length() > 7 && getTermos().isChecked()) {

                    /*Passa dados para classe BD_Inteno_Dados*/
                    BD_Interno_Dados db = new BD_Interno_Dados(email.getText().toString(), nome.getText().toString(), senha.getText().toString(),
                            Integer.parseInt(dia.getSelectedItem().toString()), mes.getSelectedItem().toString(), Integer.parseInt(ano.getSelectedItem().toString()), genero, valorTermos);
                    /*Cadastro no banco de dados interno */
                    BD_Interno cadastrar = new BD_Interno(comando.getContext());
                    cadastrar.cadastroUsuario(db);


                }

                /* Testa se o cadastro  pelo SQLite esta funcionando*/
                /*BD_Interno db = new BD_Interno(comando.getContext());
                BD_Interno_Dados dados = db.buscaCadastroSons("teste1@teste.com"); // busca por email do usuario cadastrado
                System.out.println("Busca " + dados.getEmailUsuario() + " " + dados.getSenhaUssuario() + " " + dados.getNomeUsuario()+" " + dados.getDia() + "/" + dados.getMes() + "/" + dados.getAno() + " " + dados.getGeneroUsuario() + " " + dados.getAceitaTermos());
                   */

            }
        });
        return comando;
    }



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
