package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.BM_FundIndexCfGaku;
import yuyu.def.db.mapping.GenBM_FundIndexCfGaku;
import yuyu.def.db.meta.GenQBM_FundIndexCfGaku;
import yuyu.def.db.meta.QBM_FundIndexCfGaku;

/**
 * ファンドインデックスＣＦ額マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_FundIndexCfGaku}</td><td colspan="3">ファンドインデックスＣＦ額マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getUnitfundkbn unitfundkbn}</td><td>ユニットファンド区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_UnitFundKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getFundhyoukaymd fundhyoukaymd}</td><td>ファンド評価年月日　　　　</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSegkey segkey}</td><td>ＳＥＧＫＥＹ　　　　　　　　</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>cfgaku</td><td>ＣＦ額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gkcfgaku</td><td>（外貨）ＣＦ額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_FundIndexCfGaku
 * @see     GenBM_FundIndexCfGaku
 * @see     QBM_FundIndexCfGaku
 * @see     GenQBM_FundIndexCfGaku
 */
public class PKBM_FundIndexCfGaku extends AbstractExDBPrimaryKey<BM_FundIndexCfGaku, PKBM_FundIndexCfGaku> {

    private static final long serialVersionUID = 1L;

    public PKBM_FundIndexCfGaku() {
    }

    public PKBM_FundIndexCfGaku(
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
    public Class<BM_FundIndexCfGaku> getEntityClass() {
        return BM_FundIndexCfGaku.class;
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