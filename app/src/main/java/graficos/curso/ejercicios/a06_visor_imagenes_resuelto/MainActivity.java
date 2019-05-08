package graficos.curso.ejercicios.a06_visor_imagenes_resuelto;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;

import android.support.v7.app.AppCompatActivity;

import android.view.View;

import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView lvImagenes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargarImagenes();
    }
    private void cargarImagenes(){
        lvImagenes=(ListView)this.findViewById(R.id.lvImagenes);
        //acceder al proveedor Media para recuperar
        //las imágenes
        ContentResolver content=this.getContentResolver();
        Cursor c=content.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
        //indica el nombre de la columna del proveedor
        //que contiene la ruta de los archivos
        String [] nombres={MediaStore.Images.Media.DATA};
        int [] ids={android.R.id.text1};
        SimpleCursorAdapter adp=new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1,
                c,
                nombres,
                ids,
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER );

        lvImagenes.setAdapter(adp);
        lvImagenes.setOnItemClickListener(escuchadorLista);
    }

    AdapterView.OnItemClickListener escuchadorLista=new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {

            //se recupera la ruta seleccionada y se manda
            //a la siguiente actividad
            String ruta=((TextView)view).getText().toString();
            Intent intent=new Intent(MainActivity.this,ImagenActivity.class);
            intent.putExtra("ruta", ruta);
            MainActivity.this.startActivity(intent);
        }
    };


}
