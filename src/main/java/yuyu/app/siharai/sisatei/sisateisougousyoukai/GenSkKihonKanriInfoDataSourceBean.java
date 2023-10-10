package yuyu.app.siharai.sisatei.sisateisougousyoukai;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_HubiJyoukyouKbn;
import yuyu.def.classification.C_TyousaJyoukyouKbn;

/**
 * 査定総合照会 - ●同時請求情報 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenSkKihonKanriInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dispsyono;

    public String getDispsyono() {
        return dispsyono;
    }

    public void setDispsyono(String pDispsyono) {
        dispsyono = pDispsyono;
    }


    private BizDate dispsyoriymd;

    public BizDate getDispsyoriymd() {
        return dispsyoriymd;
    }

    public void setDispsyoriymd(BizDate pDispsyoriymd) {
        dispsyoriymd = pDispsyoriymd;
    }


    private String dispnextsyorinm;

    public String getDispnextsyorinm() {
        return dispnextsyorinm;
    }

    public void setDispnextsyorinm(String pDispnextsyorinm) {
        dispnextsyorinm = pDispnextsyorinm;
    }


    private C_HubiJyoukyouKbn disphubikbn;

    public C_HubiJyoukyouKbn getDisphubikbn() {
        return disphubikbn;
    }

    public void setDisphubikbn(C_HubiJyoukyouKbn pDisphubikbn) {
        disphubikbn = pDisphubikbn;
    }


    private C_TyousaJyoukyouKbn disptyousajkkbn;

    public C_TyousaJyoukyouKbn getDisptyousajkkbn() {
        return disptyousajkkbn;
    }

    public void setDisptyousajkkbn(C_TyousaJyoukyouKbn pDisptyousajkkbn) {
        disptyousajkkbn = pDisptyousajkkbn;
    }

}
