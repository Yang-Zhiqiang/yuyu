package yuyu.app.sinkeiyaku.skkettei.skkankyousatei;

import java.io.Serializable;

import yuyu.def.classification.C_SntkInfoTaisyousyaKbn;
import yuyu.def.classification.C_SysCdKbn;

/**
 * 環境査定 - ●選択情報 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenSentakuJouhouDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_SntkInfoTaisyousyaKbn dispsntkinfotsysy;

    public C_SntkInfoTaisyousyaKbn getDispsntkinfotsysy() {
        return dispsntkinfotsysy;
    }

    public void setDispsntkinfotsysy(C_SntkInfoTaisyousyaKbn pDispsntkinfotsysy) {
        dispsntkinfotsysy = pDispsntkinfotsysy;
    }


    private String dispsntkinfono;

    public String getDispsntkinfono() {
        return dispsntkinfono;
    }

    public void setDispsntkinfono(String pDispsntkinfono) {
        dispsntkinfono = pDispsntkinfono;
    }


    private String dispsntkinfosyubetu;

    public String getDispsntkinfosyubetu() {
        return dispsntkinfosyubetu;
    }

    public void setDispsntkinfosyubetu(String pDispsntkinfosyubetu) {
        dispsntkinfosyubetu = pDispsntkinfosyubetu;
    }


    private C_SysCdKbn dispsntkinfosyskbn;

    public C_SysCdKbn getDispsntkinfosyskbn() {
        return dispsntkinfosyskbn;
    }

    public void setDispsntkinfosyskbn(C_SysCdKbn pDispsntkinfosyskbn) {
        dispsntkinfosyskbn = pDispsntkinfosyskbn;
    }

}
