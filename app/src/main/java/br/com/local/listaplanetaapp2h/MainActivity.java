package br.com.local.listaplanetaapp2h;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Declarar a variável que irá receber a ListView do XML
    ListView listView;
    //Criar os arrays que serão inseridos na listView

    String nomeHero[] = {"Capitão America", "Iron Man", "Flash", "Hulk",
            "Batman", "Homem-Aranha", "Mulher Maravilha", "Pantera Negra", "Super Homem", "Thor", "Robbin"};

    int imgHero[] = {R.drawable.capitaoamerica, R.drawable.iroman,
            R.drawable.flash, R.drawable.hulk, R.drawable.batman,
            R.drawable.miranha, R.drawable.mulhermaravilha, R.drawable.panteranegra,
            R.drawable.superman, R.drawable.thor, R.drawable.robbin};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //a variavel listview está recebendo a listView XML
        listView = findViewById(R.id.listaPlanetas);

        //Criar o objeto/classe que irá inserir o modelo na listView

        CustomAdapter adapter = new CustomAdapter();

        //Carregar o baseAdapter na listView
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "Cliquei no item da lista de nome: " + nomeHero[position],
                        Toast.LENGTH_SHORT).show();
            }        });

        //Criando evento de click na listView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getApplicationContext(), VisualizaPlaneta_MainActivity.class);
                //Passando valores de uma janela para outra
                intent.putExtra("nomeHero", nomeHero[i]);
                intent.putExtra("imagemHero", imgHero[i]);

                startActivity(intent);

            }
        });


    }

    //inner class - Classe dentro de outra Classe
    public class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return imgHero.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        //Montar o modelo para ser inserido na lista de planetas - ListView
        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            TextView txtNomeHero;
            ImageView imagemHero;

            //instanciando o modelo com os componentes para inserir na Lista
            View carregaView = getLayoutInflater().inflate(R.layout.modelo_lista_planetas, null);

            txtNomeHero = carregaView.findViewById(R.id.txtListaPlaneta);
            imagemHero = carregaView.findViewById(R.id.imgListaPlaneta);

            //Carregando os valores nos componentes

            txtNomeHero.setText(nomeHero[position]);
            imagemHero.setImageResource(imgHero[position]);

            return carregaView;
        }
    }
}