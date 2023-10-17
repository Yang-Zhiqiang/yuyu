package yuyu.app.sinkeiyaku.sksyoukai.skmossyoukai;

import java.io.Serializable;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_GaitouKbn;
import yuyu.def.classification.C_KeihiKbn;
import yuyu.def.classification.C_SysCdKbn;

/**
 * 申込状況照会 - kykSakuinInfo の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenKykSakuinInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dispkyksakuinsyono;

    public String getDispkyksakuinsyono() {
        return dispkyksakuinsyono;
    }

    public void setDispkyksakuinsyono(String pDispkyksakuinsyono) {
        dispkyksakuinsyono = pDispkyksakuinsyono;
    }


    private String dispkyksakuinmosno;

    public String getDispkyksakuinmosno() {
        return dispkyksakuinmosno;
    }

    public void setDispkyksakuinmosno(String pDispkyksakuinmosno) {
        dispkyksakuinmosno = pDispkyksakuinmosno;
    }


    private C_KeihiKbn dispkyksakuintaisyou;

    public C_KeihiKbn getDispkyksakuintaisyou() {
        return dispkyksakuintaisyou;
    }

    public void setDispkyksakuintaisyou(C_KeihiKbn pDispkyksakuintaisyou) {
        dispkyksakuintaisyou = pDispkyksakuintaisyou;
    }


    private BizDate dispkyksakuinkykymd;

    public BizDate getDispkyksakuinkykymd() {
        return dispkyksakuinkykymd;
    }

    public void setDispkyksakuinkykymd(BizDate pDispkyksakuinkykymd) {
        dispkyksakuinkykymd = pDispkyksakuinkykymd;
    }


    private BizDate dispkyksakuinsyoumetuymd;

    public BizDate getDispkyksakuinsyoumetuymd() {
        return dispkyksakuinsyoumetuymd;
    }

    public void setDispkyksakuinsyoumetuymd(BizDate pDispkyksakuinsyoumetuymd) {
        dispkyksakuinsyoumetuymd = pDispkyksakuinsyoumetuymd;
    }


    private C_GaitouKbn dispkyksakuinhuseiritu;

    public C_GaitouKbn getDispkyksakuinhuseiritu() {
        return dispkyksakuinhuseiritu;
    }

    public void setDispkyksakuinhuseiritu(C_GaitouKbn pDispkyksakuinhuseiritu) {
        dispkyksakuinhuseiritu = pDispkyksakuinhuseiritu;
    }


    private C_SysCdKbn dispkyksakuin;

    public C_SysCdKbn getDispkyksakuin() {
        return dispkyksakuin;
    }

    public void setDispkyksakuin(C_SysCdKbn pDispkyksakuin) {
        dispkyksakuin = pDispkyksakuin;
    }

}
