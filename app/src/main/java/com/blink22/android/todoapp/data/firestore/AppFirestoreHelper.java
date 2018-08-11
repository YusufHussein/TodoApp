package com.blink22.android.todoapp.data.firestore;

import android.util.Log;

import com.blink22.android.todoapp.data.firestore.model.Todo;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.subjects.ReplaySubject;
import io.reactivex.subjects.Subject;

public class AppFirestoreHelper implements FirestoreHelper {
    private static final String TAG = "AppFirestoreHelper";
    private static final String TODO_PATH = "todos";
    FirebaseFirestore mFirebaseFirestore;
    ListenerRegistration mListenerRegistration;
    CollectionReference mTodoRef;

    @Inject
    public AppFirestoreHelper(FirebaseFirestore firebaseFirestore) {
        mFirebaseFirestore = firebaseFirestore;
        mTodoRef = mFirebaseFirestore.collection(TODO_PATH);
    }

    @Override
    public Observable<List<Todo>> getAllTodos() {
        final Subject<List<Todo>> subject = ReplaySubject.<List<Todo>>create();
        mListenerRegistration = mTodoRef.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot queryDocumentSnapshots, FirebaseFirestoreException e) {
                if (queryDocumentSnapshots.size() != 0) {
                    subject.onNext(queryDocumentSnapshots.toObjects(Todo.class));
                } else if (e != null) {
                    Log.e(TAG, "SnapShot Error", e);
                }
            }
        });
        return subject;
    }
}
