package martinmazas.java.ATM.viewmodel;

import martinmazas.java.ATM.model.IModel;
import martinmazas.java.ATM.model.User;
import martinmazas.java.ATM.view.IView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ViewModel implements IViewModel{
    private IModel model;
    private IView view;
    private final ExecutorService pool;

    public ViewModel() {
        pool = Executors.newFixedThreadPool(10);
    }

    @Override
    public void setView(IView view) {
        this.view = view;
    }

    @Override
    public void setModel(IModel model) {
        this.model = model;
    }

    @Override
    public void addUser(String id, String name, String pin) {
        pool.submit(new Runnable() {
            @Override
            public void run() {
                User user = new User(id, name, pin);
                System.out.println(user);
                // Need to send the new user
//                model.addUser();
            }
        });
    }
}
