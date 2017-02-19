package model;

import android.text.TextUtils;

/**
 * Created by yq on 2017/2/18.
 */

public class UserModel implements IUser {

    public UserModel(String mvp, String mvp1) {

    }

    @Override
    public int checkUserValidity(String name, String passwd) {
        if (TextUtils.isEmpty(name)||TextUtils.isEmpty(passwd))return -1;
        return 0;
    }
}
