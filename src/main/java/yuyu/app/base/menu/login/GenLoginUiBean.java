package yuyu.app.base.menu.login;

import jp.co.slcs.swak.web.ui.AbstractUiBean;

/**
 * ログイン : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenLoginUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private String tanmatusettisosikicd;

    public String getTanmatusettisosikicd() {
        return tanmatusettisosikicd;
    }

    public void setTanmatusettisosikicd(String pTanmatusettisosikicd) {
        tanmatusettisosikicd = pTanmatusettisosikicd;
    }
}
