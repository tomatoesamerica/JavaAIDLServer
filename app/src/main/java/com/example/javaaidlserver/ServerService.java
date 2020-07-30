package com.example.javaaidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ServerService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    private final Data.Stub mBinder = new Data.Stub() {
        @Override
        public int Sum(int a, int b) throws RemoteException {
            return a + b;
        }

        @Override
        public List<String> getData() throws RemoteException {
            return getListData();
        }

        @Override
        public List<Person> getPerson() throws RemoteException {
            return getListPerson();
        }
    };

    public List<String> getListData() {
        List<String> strings = new ArrayList<>();
        strings.add("apple");
        strings.add("orange");
        strings.add("lemon");
        return strings;
    }

    public List<Person> getListPerson() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("orange", 11));
        list.add(new Person("apple", 20));
        list.add(new Person("lemon", 14));
        return list;
    }
}
