package presenter;

import android.os.Handler;
import android.os.Looper;

import model.IUser;
import model.UserModel;
import view.ILoginView;

/**
 * Created by yq on 2017/2/18.
 */

public class LoginPresenterCompl implements ILoginPresenter {
    private ILoginView iLoginView;
    IUser user;
    Handler handler;

    public LoginPresenterCompl(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        user = new UserModel("mvp","mvp");
        handler = new Handler(Looper.getMainLooper());
    }
    //imp view
    @Override
    public void clear() {
        iLoginView.onClearText();
    }
    @Override
    public void doLogin(String name, String passwd) {
        Boolean isLoginSuccess = true;
        final int code = user.checkUserValidity(name,passwd);
        if (code!=0) isLoginSuccess = false;
        final Boolean result = isLoginSuccess;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iLoginView.onLoginResult(result, code);
            }
        }, 3000);
    }
    @Override
    public void setProgressBarVisiblity(int visiblity){
        iLoginView.onSetProgressBarVisibility(visiblity);
    }
}
