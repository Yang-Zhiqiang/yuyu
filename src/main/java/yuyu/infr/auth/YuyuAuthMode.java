package yuyu.infr.auth;

import java.io.Serializable;

import com.google.inject.servlet.SessionScoped;

/**
 * ゆうゆう生保認証モード管理クラスです。<br />
 * このクラスのライフサイクルはセッションスコープです。<br />
 * 当クラスのデフォルト認証モードは「ユーザーモード」です。<br />
 * 明示的な認証モード設定を行わなかった場合、その認証は「ユーザーモード」として扱われます。
 */
@SessionScoped
public class YuyuAuthMode implements Serializable  {

    private static final long serialVersionUID = 20130930L;

    public enum E_AuthMode{
        USER,
        CONSUMER;
    }

    private E_AuthMode authMode = E_AuthMode.USER;

    public void setAuthMode(E_AuthMode pMode){
        authMode=pMode;
    }

    public E_AuthMode getAuthMode(){
        return authMode;
    }
}
