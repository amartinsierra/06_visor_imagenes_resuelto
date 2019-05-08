package graficos.curso.ejercicios.a06_visor_imagenes_resuelto;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ImagenActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_imagen);
		cargarImagen();
	}
	private void cargarImagen(){
		Intent intent=this.getIntent();
		//recupera la ruta del archivo
		String ruta=intent.getStringExtra("ruta");
		ImageView ivImagen=(ImageView)this.findViewById(R.id.ivFoto);
		//carga la imagen a partir de
		// la ruta del fichero de imagen
		ivImagen.setImageDrawable(Drawable.createFromPath(ruta));
	}

	public void salir(View v){
		this.finish();
	}
	
}
