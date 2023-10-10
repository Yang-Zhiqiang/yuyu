package yuyu.app.sinkeiyaku.skkettei.skimusatei;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_TknzkKbn;

/**
 * 医務査定 - ●条件付 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenJyoukentukiDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dispsyouhnnm;

    public String getDispsyouhnnm() {
        return dispsyouhnnm;
    }

    public void setDispsyouhnnm(String pDispsyouhnnm) {
        dispsyouhnnm = pDispsyouhnnm;
    }


    private Boolean tknzk;

    public Boolean getTknzk() {
        return tknzk == null ? Boolean.FALSE : tknzk;
    }

    public void setTknzk(Boolean pTknzk) {
        tknzk = pTknzk == null ? Boolean.FALSE : pTknzk;
    }


    private C_TknzkKbn disptknzkkbn;

    public C_TknzkKbn getDisptknzkkbn() {
        return disptknzkkbn;
    }

    public void setDisptknzkkbn(C_TknzkKbn pDisptknzkkbn) {
        disptknzkkbn = pDisptknzkkbn;
    }


    private BizCurrency dispseigens;

    public BizCurrency getDispseigens() {
        return dispseigens;
    }

    public void setDispseigens(BizCurrency pDispseigens) {
        dispseigens = pDispseigens;
    }

}
