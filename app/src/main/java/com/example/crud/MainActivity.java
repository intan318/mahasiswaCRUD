package com.example.crud;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crud.Adapter.MahasiswaAdapter;
import com.example.crud.Model.DatanyaItem;
import com.example.crud.Presenter.MainPresenter;
import com.example.crud.View.MainView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.List;

import static retrofit2.converter.gson.GsonConverterFactory.create;

public class MainActivity extends AppCompatActivity implements MainView {

    List<DatanyaItem> dataMahasiswa;
    MainPresenter mainPresenter;
    RecyclerView recyclerView;
    MahasiswaAdapter adapter;
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        mainPresenter = new MainPresenter(this);
        mainPresenter.getAllMahasiswa();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogInflater();
            }
        });
    }

    private void dialogInflater() {
        final AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Tambah Mahasiswa")
                .setPositiveButton("Save", null)
                .setNegativeButton("Cancel", null)
                .create();

        LayoutInflater inflater = getLayoutInflater();
        View viewAdd = inflater.inflate(R.layout.activity_form_mahasiswa, null, false);
        final ViewHolder viewHolder = new ViewHolder(viewAdd);
        dialog.setView(viewAdd);
        dialog.setCancelable(false);
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                Button buttonPositive = ((AlertDialog) dialog).getButton(DialogInterface.BUTTON_POSITIVE);
                buttonPositive.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nim = viewHolder.nim.getText().toString();
                        String nama = viewHolder.nama.getText().toString();
                        String jurusan = viewHolder.jurusan.getText().toString();

                        if(TextUtils.isEmpty(nama)){
                            viewHolder.nama.setError("Name can't be empty");
                        } else if (TextUtils.isEmpty(nim)){
                            viewHolder.nim.setError("NIM can't be empty");
                        } else if (TextUtils.isEmpty(jurusan)){
                            viewHolder.jurusan.setError("Jurusan can't be empty");
                        } else {
                            //kalo ga kosong dia nambah data, method panggil dr presenter
                            mainPresenter.insertAllMahasiswa(nim, nama, jurusan, dialog);
                        }

                    }
                });
                Button buttonNegative = ((AlertDialog)dialog).getButton(DialogInterface.BUTTON_NEGATIVE);
                buttonNegative.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss(); //dialog ilang
                    }
                });
            }
        });
    }

    static class ViewHolder{
        EditText nama;
        EditText nim;
        EditText jurusan;

        //panggil cconstructor

        ViewHolder(View view){
            nama = view.findViewById(R.id.etNamaMhs);
            nim = view.findViewById(R.id.etNimMhs);
            jurusan = view.findViewById(R.id.etJurusanMhs);

        }
    }

    @Override
    public void getMahasiswa(List<DatanyaItem> mahasiswa) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MahasiswaAdapter(this, mahasiswa);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void error(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onAttachView() {
        mainPresenter.onAttach(this);
    }

    @Override
    public void onDetachView() {
        mainPresenter.onDetach(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        onAttachView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onDetachView();
    }
}
