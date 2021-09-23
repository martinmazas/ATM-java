package martinmazas.java.ATM;

import martinmazas.java.ATM.model.DerbyDBModel;
import martinmazas.java.ATM.model.IModel;
import martinmazas.java.ATM.view.IView;
import martinmazas.java.ATM.view.View;
import martinmazas.java.ATM.viewmodel.IViewModel;
import martinmazas.java.ATM.viewmodel.ViewModel;

public class Application {
    public static void main(String args[]) {

        IModel model = new DerbyDBModel();
        IView view = new View();
        IViewModel vm = new ViewModel();

        //connecting components together
        view.setViewModel(vm);
        vm.setModel(model);
        vm.setView(view);
    }
}
