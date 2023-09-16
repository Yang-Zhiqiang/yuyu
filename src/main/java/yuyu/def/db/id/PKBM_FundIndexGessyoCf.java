package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.BM_FundIndexGessyoCf;
import yuyu.def.db.mapping.GenBM_FundIndexGessyoCf;
import yuyu.def.db.meta.GenQBM_FundIndexGessyoCf;
import yuyu.def.db.meta.QBM_FundIndexGessyoCf;

/**
 * ファンドインデックス月初ＣＦマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_FundIndexGessyoCf}</td><td colspan="3">ファンドインデックス月初ＣＦマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getUnitfundkbn unitfundkbn}</td><td>ユニットファンド区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_UnitFundKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getFundhyoukaymd fundhyoukaymd}</td><td>ファンド評価年月日　　　　</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSegkey segkey}</td><td>ＳＥＧＫＥＹ　　　　　　　　</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gscfhkkkgahurikaegaku</td><td>月初ＣＦ保険関係ＧＡ振替額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gkgscfhkkkgahurikaegaku</td><td>（外貨）月初ＣＦ保険関係ＧＡ振替額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gscfhkkksahurikaegaku</td><td>月初ＣＦ保険関係ＳＡ振替額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gkgscfhkkksahurikaegaku</td><td>（外貨）月初ＣＦ保険関係ＳＡ振替額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_FundIndexGessyoCf
 * @see     GenBM_FundIndexGessyoCf
 * @see     QBM_FundIndexGessyoCf
 * @see     GenQBM_FundIndexGessyoCf
 */
public class PKBM_FundIndexGessyoCf extends AbstractExDBPrimaryKey<BM_FundIndexGessyoCf, PKBM_FundIndexGessyoCf> {

    private static final long serialVersionUID = 1L;

    public PKBM_FundIndexGessyoCf() {
    }

    public PKBM_FundIndexGessyoCf(
        C_UnitFundKbn pUnitfundkbn,
        BizDate pFundhyoukaymd,
        String pSegkey
    ) {
        unitfundkbn = pUnitfundkbn;
        fundhyoukaymd = pFundhyoukaymd;
        segkey = pSegkey;
    }

    @Transient
    @Override
    public Class<BM_FundIndexGessyoCf> getEntityClass() {
        return BM_FundIndexGessyoCf.class;
    }

    private C_UnitFundKbn unitfundkbn;

    @org.hibernate.annotations.Type(type="UserType_C_UnitFundKbn")
    public C_UnitFundKbn getUnitfundkbn() {
        return unitfundkbn;
    }

    public void setUnitfundkbn(C_UnitFundKbn pUnitfundkbn) {
        unitfundkbn = pUnitfundkbn;
    }
    private BizDate fundhyoukaymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getFundhyoukaymd() {
        return fundhyoukaymd;
    }

    public void setFundhyoukaymd(BizDate pFundhyoukaymd) {
        fundhyoukaymd = pFundhyoukaymd;
    }
    private String segkey;

    public String getSegkey() {
        return segkey;
    }

    public void setSegkey(String pSegkey) {
        segkey = pSegkey;
    }

}