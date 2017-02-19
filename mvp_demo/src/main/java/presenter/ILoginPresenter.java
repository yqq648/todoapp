package presenter;

/**
 * Created by yq on 2017/2/18.
 */

public interface ILoginPresenter {
    void setProgressBarVisiblity(int visiblity);

    void clear();

    void doLogin(String username, String password);
}
