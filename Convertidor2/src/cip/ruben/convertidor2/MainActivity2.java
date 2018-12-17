package cip.ruben.convertidor2;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends Activity {

	private EditText et_euros, et_dolares;
	private Button b_conversor, b_convertir,b_borrar;
	final DecimalFormat df = new DecimalFormat(".##");
	private Bundle bundle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);

		et_euros = (EditText) findViewById(R.id.et_cantidad);
		et_dolares = (EditText) findViewById(R.id.et_dolares);

		bundle = getIntent().getExtras();
		String euros = bundle.getString("euros");
		String dolares = bundle.getString("dolares");

		et_euros.setText(dolares);
		et_dolares.setText(euros);

		b_convertir = (Button) findViewById(R.id.bt_convertir);

		b_convertir.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				if (et_euros.getText().toString().equalsIgnoreCase("")) {
					Toast.makeText(MainActivity2.this, "No hay ningún dato",
							2000).show();
				} else {
					double resultado = ((Double.parseDouble(et_euros.getText()
							.toString()) / (1.22600)));
					et_dolares.setText(String.valueOf(df.format(resultado)));
				}
			}
		});

		b_conversor = (Button) findViewById(R.id.b_conversor);

		b_conversor.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
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
