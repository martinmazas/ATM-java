package martinmazas.java.ATM.viewmodel;

import martinmazas.java.ATM.model.IModel;
import martinmazas.java.ATM.view.IView;

public interface IViewModel {
    public void setView(IView view);
    public void setModel(IModel model);
}