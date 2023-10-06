package yuyu.app.sinkeiyaku.sksyoukai.skmossyoukai;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_GaitouKbn;
import yuyu.def.classification.C_KeihiKbn;
import yuyu.def.classification.C_SysCdKbn;

/**
 * 申込状況照会 - hhknSakuinInfo の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenHhknSakuinInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String disphhknsakuinsyono;

    public String getDisphhknsakuinsyono() {
        return disphhknsakuinsyono;
    }

    public void setDisphhknsakuinsyono(String pDisphhknsakuinsyono) {
        disphhknsakuinsyono = pDisphhknsakuinsyono;
    }


    private String disphhknsakuinmosno;

    public String getDisphhknsakuinmosno() {
        return disphhknsakuinmosno;
    }

    public void setDisphhknsakuinmosno(String pDisphhknsakuinmosno) {
        disphhknsakuinmosno = pDisphhknsakuinmosno;
    }


    private C_KeihiKbn disphhknsakuintaisyou;

    public C_KeihiKbn getDisphhknsakuintaisyou() {
        return disphhknsakuintaisyou;
    }

    public void setDisphhknsakuintaisyou(C_KeihiKbn pDisphhknsakuintaisyou) {
        disphhknsakuintaisyou = pDisphhknsakuintaisyou;
    }


    private BizDate disphhknsakuinkykymd;

    public BizDate getDisphhknsakuinkykymd() {
        return disphhknsakuinkykymd;
    }

    public void setDisphhknsakuinkykymd(BizDate pDisphhknsakuinkykymd) {
        disphhknsakuinkykymd = pDisphhknsakuinkykymd;
    }


    private BizDate disphhknsakuinsyoumetuymd;

    public BizDate getDisphhknsakuinsyoumetuymd() {
        return disphhknsakuinsyoumetuymd;
    }

    public void setDisphhknsakuinsyoumetuymd(BizDate pDisphhknsakuinsyoumetuymd) {
        disphhknsakuinsyoumetuymd = pDisphhknsakuinsyoumetuymd;
    }


    private C_GaitouKbn disphhknsakuinhuseiritu;

    public C_GaitouKbn getDisphhknsakuinhuseiritu() {
        return disphhknsakuinhuseiritu;
    }

    public void setDisphhknsakuinhuseiritu(C_GaitouKbn pDisphhknsakuinhuseiritu) {
        disphhknsakuinhuseiritu = pDisphhknsakuinhuseiritu;
    }


    private C_SysCdKbn disphhknsakuin;

    public C_SysCdKbn getDisphhknsakuin() {
        return disphhknsakuin;
    }

    public void setDisphhknsakuin(C_SysCdKbn pDisphhknsakuin) {
        disphhknsakuin = pDisphhknsakuin;
    }

}
