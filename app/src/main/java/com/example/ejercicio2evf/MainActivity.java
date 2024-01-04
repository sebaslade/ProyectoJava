package com.example.ejercicio2evf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ejercicio2evf.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText nombre,posicion;
    TextView mostrar;
    Button ingresar,buscar,modificar,eliminar,insertar;
    ArrayList<String> empleado=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre=(EditText) findViewById(R.id.edtNombre);
        posicion=(EditText) findViewById(R.id.edtPosicion);
        mostrar=(TextView) findViewById(R.id.txvSalida);
        ingresar=(Button) findViewById(R.id.btnIngresar);
        buscar=(Button) findViewById(R.id.btnBuscar);
        modificar=(Button) findViewById(R.id.btnModificar);
        eliminar=(Button) findViewById(R.id.btnEliminar);
        insertar=(Button) findViewById(R.id.btnInsertar);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ed=nombre.getText().toString().trim();
                mostrar.setText("");
                empleado.add(ed);
                nombre.getText().clear();
                for(int i=0;i<empleado.size();i=i+1){
                    int posicion=i+1;
                    mostrar.append(posicion+". "+empleado.get(i).trim()+"\n");
                }
                Toast.makeText(MainActivity.this, "Nombre Almacenado", Toast.LENGTH_SHORT).show();
            }
        });
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ed = nombre.getText().toString().trim();
                boolean encontrado = false;
                int pos = -1;
                for (int i = 0; i < empleado.size(); i++) {
                    if (ed.equalsIgnoreCase(empleado.get(i).trim())) {
                        encontrado = true;
                        pos = i;
                        break;
                    }
                }
                if (encontrado) {
                    Toast.makeText(MainActivity.this, "Nombre Encontrado", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Nombre No Encontrado", Toast.LENGTH_SHORT).show();
                }
                final int finalPosicion=pos;
                modificar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String mod = nombre.getText().toString();
                        empleado.set(finalPosicion, mod);
                        mostrar.setText("");
                        for (int i = 0; i < empleado.size(); i++) {
                            mostrar.append((i + 1) + ". " + empleado.get(i) + "\n");
                        }
                        Toast.makeText(MainActivity.this, "Nombre Modificado", Toast.LENGTH_SHORT).show();
                    }
                });
                eliminar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String ed=nombre.getText().toString();
                        int pos=-1;
                        for(int i=0;i<empleado.size();i++){
                            if(ed.equals(empleado.get(i))){
                                pos=i;
                            }
                        }
                        empleado.remove(pos);
                        mostrar.setText("");
                        for(int i=0;i<empleado.size();i++){
                            int posicion=i+1;
                            mostrar.append(posicion+". "+empleado.get(i)+"\n");
                        }
                        Toast.makeText(MainActivity.this, "Nombre Eliminado", Toast.LENGTH_SHORT).show();
                    }
                });
                insertar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String ed = nombre.getText().toString();
                        int pos = Integer.parseInt(posicion.getText().toString());

                        if (pos >= 0 && pos <= empleado.size()) {
                            empleado.add(pos, ed);
                            mostrar.setText("");
                            for (int i = 0; i < empleado.size(); i++) {
                                int posicion = i + 1;
                                mostrar.append(posicion + ". " + empleado.get(i) + "\n");
                            }
                            posicion.getText().clear();
                            Toast.makeText(MainActivity.this, "Nombre Insertado", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Posición inválida", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}