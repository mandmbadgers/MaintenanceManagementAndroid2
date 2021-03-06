package com.torchacademy.maintenancemanagement.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.torchacademy.maintenancemanagement.R;
import com.torchacademy.maintenancemanagement.adapters.ClientRequestAdapter;
import com.torchacademy.maintenancemanagement.models.ClientRequest;

/**
 * Created by ahmad.masri on 6/22/2016.
 */
public class FragmentUserRequestsPending extends Fragment {

    private RecyclerView recyclerview_pending;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_request_pending, container, false);

        recyclerview_pending = (RecyclerView) view.findViewById(R.id.recyclerview_pending);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

        recyclerview_pending.setLayoutManager(linearLayoutManager);

        recyclerview_pending.setAdapter(new ClientRequestAdapter(getContext(), ClientRequest.dummyListPending()));



        return view;

    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
