package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.BM_FundIndexSyokitousi;
import yuyu.def.db.mapping.GenBM_FundIndexSyokitousi;
import yuyu.def.db.meta.GenQBM_FundIndexSyokitousi;
import yuyu.def.db.meta.QBM_FundIndexSyokitousi;

/**
 * ファンドインデックス初期投資マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_FundIndexSyokitousi}</td><td colspan="3">ファンドインデックス初期投資マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getUnitfundkbn unitfundkbn}</td><td>ユニットファンド区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_UnitFundKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getFundhyoukaymd fundhyoukaymd}</td><td>ファンド評価年月日　　　　</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSegkey segkey}</td><td>ＳＥＧＫＥＹ　　　　　　　　</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syokisegsakuseijiyuu</td><td>初期投資ＳＥＧ作成事由</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syokitousisetteigaku</td><td>初期投資設定額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>syokigoukeihensaigaku</td><td>初期投資合計返済額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>syokirisokuhensaigaku</td><td>初期投資利息返済額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>syokigankinhensaigaku</td><td>初期投資元金返済額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>syokitousirisoku</td><td>初期投資利息</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>syokigankinkuriiregaku</td><td>初期投資元金繰入金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gksyokitousisetteigaku</td><td>（外貨）初期投資設定額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gksyokigoukeihensaigaku</td><td>（外貨）初期投資合計返済額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gksyokirisokuhensaigaku</td><td>（外貨）初期投資利息返済額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gksyokigankinhensaigaku</td><td>（外貨）初期投資元金返済額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gksyokitousirisoku</td><td>（外貨）初期投資利息</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gksyokigankinkuriiregaku</td><td>（外貨）初期投資元金繰入金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>syokitousigankinkrirkbn</td><td>初期投資元金繰入区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>zenkaistsegsakuseiymd</td><td>前回初期投資ＳＥＧ作成年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     BM_FundIndexSyokitousi
 * @see     GenBM_FundIndexSyokitousi
 * @see     QBM_FundIndexSyokitousi
 * @see     GenQBM_FundIndexSyokitousi
 */
public class PKBM_FundIndexSyokitousi extends AbstractExDBPrimaryKey<BM_FundIndexSyokitousi, PKBM_FundIndexSyokitousi> {

    private static final long serialVersionUID = 1L;

    public PKBM_FundIndexSyokitousi() {
    }

    public PKBM_FundIndexSyokitousi(
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
    public Class<BM_FundIndexSyokitousi> getEntityClass() {
        return BM_FundIndexSyokitousi.class;
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