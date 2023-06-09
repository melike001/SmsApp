package com.example.smsapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smsapp.Adapter.GrupSecAdapter;
import com.example.smsapp.Adapter.MesajSecHomeAdapter;
import com.example.smsapp.Modals.GrupSecModals;
import com.example.smsapp.Modals.MesajSecHomeModals;
import com.example.smsapp.R;
import com.example.smsapp.databinding.FragmentHomeBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.ktx.Firebase;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    ArrayList<GrupSecModals> grupSec;
    ArrayList<MesajSecHomeModals> homecategories;
    GrupSecAdapter grupSecAdapter;
    MesajSecHomeAdapter mesajSecHomeAdapter;
    RecyclerView grupSecRv;
    RecyclerView homecatRv;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root= inflater.inflate(R.layout.fragment_home, container, false);
        grupSecRv = root.findViewById(R.id.grup_sec);
        homecatRv = root.findViewById(R.id.mesaj_sec);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(RecyclerView.HORIZONTAL);
        llm.setReverseLayout(false);
        grupSecRv.setLayoutManager(llm);

        grupSec = new ArrayList<>();
        grupSecAdapter = new GrupSecAdapter(grupSec, getActivity());
        grupSecRv.setAdapter(grupSecAdapter);

        homecatRv.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));

        homecategories=new ArrayList<>();
        mesajSecHomeAdapter = new MesajSecHomeAdapter(homecategories, getActivity());
        homecatRv.setAdapter(mesajSecHomeAdapter);

        getCloudData();
        getOtherData();

        return root;
    }

    private void getCloudData() {
        db.collection("mesajgonder_grupsec")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isComplete()) {
                            for(QueryDocumentSnapshot doc:task.getResult()){
                                GrupSecModals gsm = doc.toObject(GrupSecModals.class);
                                grupSec.add(gsm);
                                grupSecAdapter.notifyDataSetChanged();
                            }
                        }
                    }
                });
    }

    private void getOtherData() {
        db.collection("mesajgonder_mesajsec")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isComplete()) {
                            for (QueryDocumentSnapshot doc:task.getResult()){
                                MesajSecHomeModals mshm = doc.toObject(MesajSecHomeModals.class);
                                homecategories.add(mshm);
                                mesajSecHomeAdapter.notifyDataSetChanged();
                            }
                        }
                    }
                });
    }
}
