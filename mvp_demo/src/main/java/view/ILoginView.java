package view;

/**
 * Created by yq on 2017/2/18.
 */

public interface ILoginView {
    public void onClearText();
    public void onLoginResult(Boolean result, int code);
    public void onSetProgressBarVisibility(int visibility);
}
