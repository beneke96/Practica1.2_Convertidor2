package cip.ruben.convertidor2;

import java.text.DecimalFormat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText et_euros, et_dolares;
	private Button b_convertir, b_conversor,b_borrar;
	final DecimalFormat df = new DecimalFormat(".##");

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		et_euros = (EditText) findViewById(R.id.et_cantidad);
		et_dolares = (EditText) findViewById(R.id.et_dolares);

		b_convertir = (Button) findViewById(R.id.bt_convertir);

		b_convertir.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				if (et_euros.getText().toString().equalsIgnoreCase("")) {
					Toast.makeText(MainActivity.this, "No hay ningún dato",
							2000).show();
				} else {
					double resultado = ((Double.parseDouble(et_euros.getText()
							.toString()) * (1.22600)));
					et_dolares.setText(String.valueOf(df.format(resultado)));
				}
			}
		});

		b_conversor = (Button) findViewById(R.id.b_conversor);

		b_conversor.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!et_euros.getText().equals("")
						&& !et_dolares.getText().equals("")) {
					Intent intent = new Intent(MainActivity.this,
							MainActivity2.class);
					intent.putExtra("dolares", et_dolares.getText().toString());
					intent.putExtra("euros", et_euros.getText().toString());
					startActivity(intent);
				} else {
					Toast.makeText(MainActivity.this,
							"Debe indicar los datos requeridos", 3000).show();
				}
			}
		});

		b_borrar= (Button)findViewById(R.id.b_borrar);
		
		b_borrar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				et_dolares.setText("");
				et_euros.setText("");
			}
		});
	}
}