package yuyu.infr.auth;

/**
 * ユーザー認証チェックを行う為のパラメータ格納クラスです。
 */
public class AuthCheckParam{

    private String userId = null;
    private String password = null;

    public AuthCheckParam(String pUserId, String pPassword){
        userId   = pUserId   == null ? "" : pUserId;
        password = pPassword == null ? "" : pPassword;
    }

    public String getUserId(){
        return userId;
    }

    public String getPassword(){
        return password;
    }
}
