package nascimento.garcia.email;

import static android.app.ProgressDialog.show;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Conecta o id "btnEnviar" ao botao da interface para obte-lo
        Button btnEnviar= findViewById(R.id.btnEnviar);
        //define a acao de clique no botao
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            //O OnClick é chamado quando clica no botao
            public void onClick(View v) {
                //obtem os dados digitados pelo usuario
                //obtem o campo EditText de id etEmail através do metodo findViewById
                EditText etEmail= findViewById(R.id.etEmail);
                String email = etEmail.getText().toString();
                //obtem o campo EditText de id etAssunto através do metodo findViewById
                EditText etAssunto= findViewById(R.id.etAssunto);
                String assunto = etAssunto.getText().toString();
                //obtem o campo EditText de id etTexto através do metodo findViewById
                EditText etTexto= findViewById(R.id.etTexto);
                String texto = etTexto.getText().toString();
               //cria o intent (intencao)
                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setData(Uri.parse("mailto:"));
              //preenche o Intent com os dados que queremos enviar para a app externa que vai enviar o e-mail
                String [] emails = new String[] {email};
                i.putExtra(Intent.EXTRA_EMAIL,emails);
                i.putExtra(Intent.EXTRA_SUBJECT,assunto);
                i.putExtra(Intent.EXTRA_TEXT,texto);

                //tenta executar/iniciar o Intent

                try{
                    startActivity(Intent.createChooser(i,"Escolha o APP"));
                }
                //exibe erro caso não exista app
                catch (ActivityNotFoundException e){
                    Toast.makeText(MainActivity.this,"Não há nenhum app que possa realizar essa operação",Toast.LENGTH_LONG).show();

                }



            }
        });
    }
}