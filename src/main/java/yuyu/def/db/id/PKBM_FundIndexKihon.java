package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.BM_FundIndexKihon;
import yuyu.def.db.mapping.GenBM_FundIndexKihon;
import yuyu.def.db.meta.GenQBM_FundIndexKihon;
import yuyu.def.db.meta.QBM_FundIndexKihon;

/**
 * ファンドインデックス基本マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_FundIndexKihon}</td><td colspan="3">ファンドインデックス基本マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getUnitfundkbn unitfundkbn}</td><td>ユニットファンド区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_UnitFundKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getFundhyoukaymd fundhyoukaymd}</td><td>ファンド評価年月日　　　　</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>fundkaisetuymd</td><td>ファンド開設年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>fundindex</td><td>ファンドインデックス</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>fundindexkeisankbn</td><td>ファンドインデックス計算区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>unyoustartjisisankagaku</td><td>運用開始時資産価額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>unyouendjisisankagaku</td><td>運用終了時資産価額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>cfkasangosisankagaku</td><td>ＣＦ加算後資産価額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>unyoustartjicfgaku</td><td>運用開始時ＣＦ額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>unyoujisonekigaku</td><td>運用時損益額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>unyougocfgaku</td><td>運用後ＣＦ額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>saiteihosyounichigaku</td><td>最低保障コスト日額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>saiteihosyougekkangaku</td><td>最低保障コスト月間累積額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gkunyoustartjisisankagaku</td><td>（外貨）運用開始時ＣＦ額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gkunyouendjisisankagaku</td><td>（外貨）運用終了時資産価額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gkcfkasangosisankagaku</td><td>（外貨）ＣＦ加算後資産価額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gkunyoustartjicfgaku</td><td>（外貨）運用開始時ＣＦ額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gkunyoujisonekigaku</td><td>（外貨）運用時損益額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gkunyougocfgaku</td><td>（外貨）運用後ＣＦ額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>starttousiganrigoukei</td><td>開始初期投資元利合計残高</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gkstarttousiganrigoukei</td><td>（外貨）開始初期投資元利合計残高</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>saisinsyokitousisegymd</td><td>最新初期投資ＳＥＧ評価年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>unyougocfmikakuteihyouji</td><td>運用後ＣＦ未確定表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_FundIndexKihon
 * @see     GenBM_FundIndexKihon
 * @see     QBM_FundIndexKihon
 * @see     GenQBM_FundIndexKihon
 */
public class PKBM_FundIndexKihon extends AbstractExDBPrimaryKey<BM_FundIndexKihon, PKBM_FundIndexKihon> {

    private static final long serialVersionUID = 1L;

    public PKBM_FundIndexKihon() {
    }

    public PKBM_FundIndexKihon(C_UnitFundKbn pUnitfundkbn, BizDate pFundhyoukaymd) {
        unitfundkbn = pUnitfundkbn;
        fundhyoukaymd = pFundhyoukaymd;
    }

    @Transient
    @Override
    public Class<BM_FundIndexKihon> getEntityClass() {
        return BM_FundIndexKihon.class;
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

}