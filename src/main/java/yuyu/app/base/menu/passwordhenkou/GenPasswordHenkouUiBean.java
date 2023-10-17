package yuyu.app.base.menu.passwordhenkou;

import javax.inject.Inject;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import yuyu.def.db.entity.AM_User;

/**
 * パスワード変更 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenPasswordHenkouUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    @Inject
    private AM_User user;

    public AM_User getUser() {
        return user;
    }

    public void setUser(AM_User pUser) {
        user = pUser;
    }

    private String oldPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String pOldPassword) {
        oldPassword = pOldPassword;
    }

    @AlphaDigit
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String pPassword) {
        password = pPassword;
    }

    @AlphaDigit
    private String passwordKakunin;

    public String getPasswordKakunin() {
        return passwordKakunin;
    }

    public void setPasswordKakunin(String pPasswordKakunin) {
        passwordKakunin = pPasswordKakunin;
    }

    private String passwordKekka;

    public String getPasswordKekka() {
        return passwordKekka;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setPasswordKekka(String pPasswordKekka) {
        passwordKekka = pPasswordKekka;
    }
}
