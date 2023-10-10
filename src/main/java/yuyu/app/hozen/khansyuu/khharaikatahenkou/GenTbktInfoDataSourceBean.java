package yuyu.app.hozen.khansyuu.khharaikatahenkou;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_UnitFundKbn;

/**
 * 払方変更 - 　＜特別勘定情報＞ の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenTbktInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String vhsyudispfundunitkbnval;

    public String getVhsyudispfundunitkbnval() {
        return vhsyudispfundunitkbnval;
    }

    public void setVhsyudispfundunitkbnval(String pVhsyudispfundunitkbnval) {
        vhsyudispfundunitkbnval = pVhsyudispfundunitkbnval;
    }


    private C_UnitFundKbn vhsyudispfundunitkbn;

    public C_UnitFundKbn getVhsyudispfundunitkbn() {
        return vhsyudispfundunitkbn;
    }

    public void setVhsyudispfundunitkbn(C_UnitFundKbn pVhsyudispfundunitkbn) {
        vhsyudispfundunitkbn = pVhsyudispfundunitkbn;
    }


    private BizNumber vhsyudispunitsuu;

    public BizNumber getVhsyudispunitsuu() {
        return vhsyudispunitsuu;
    }

    public void setVhsyudispunitsuu(BizNumber pVhsyudispunitsuu) {
        vhsyudispunitsuu = pVhsyudispunitsuu;
    }


    private BizNumber vhsyudispfundindex;

    public BizNumber getVhsyudispfundindex() {
        return vhsyudispfundindex;
    }

    public void setVhsyudispfundindex(BizNumber pVhsyudispfundindex) {
        vhsyudispfundindex = pVhsyudispfundindex;
    }


    private BizCurrency vhsyudisptutakngk;

    public BizCurrency getVhsyudisptutakngk() {
        return vhsyudisptutakngk;
    }

    public void setVhsyudisptutakngk(BizCurrency pVhsyudisptutakngk) {
        vhsyudisptutakngk = pVhsyudisptutakngk;
    }


    private BizNumber vhsyudispwariai;

    public BizNumber getVhsyudispwariai() {
        return vhsyudispwariai;
    }

    public void setVhsyudispwariai(BizNumber pVhsyudispwariai) {
        vhsyudispwariai = pVhsyudispwariai;
    }

}
