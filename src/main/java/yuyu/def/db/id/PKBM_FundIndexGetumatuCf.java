package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.BM_FundIndexGetumatuCf;
import yuyu.def.db.mapping.GenBM_FundIndexGetumatuCf;
import yuyu.def.db.meta.GenQBM_FundIndexGetumatuCf;
import yuyu.def.db.meta.QBM_FundIndexGetumatuCf;

/**
 * ファンドインデックス月末ＣＦマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_FundIndexGetumatuCf}</td><td colspan="3">ファンドインデックス月末ＣＦマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getUnitfundkbn unitfundkbn}</td><td>ユニットファンド区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_UnitFundKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getFundhyoukaymd fundhyoukaymd}</td><td>ファンド評価年月日　　　　</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSegkey segkey}</td><td>ＳＥＧＫＥＹ　　　　　　　　</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gmcfhknknkigahurikaegaku</td><td>月末ＣＦ保険関係ＧＡ振替額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gkgmcfhknknkigahurikaegaku</td><td>（外貨）月末ＣＦ保険関係ＧＡ振替額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gmcfsakanrihigahurikaegaku</td><td>月末ＣＦＳＡ管理費ＧＡ振替額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gmsthscstgahurikaegaku</td><td>月末最低保障コストＧＡ振替額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gmroanfundgahurikaegaku</td><td>月末ローンファンドＧＡ振替額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gmcfhkkksahurikaegaku</td><td>月末ＣＦ保険関係ＳＡ振替額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gkgmcfhkkksahurikaegaku</td><td>（外貨）月末ＣＦ保険関係ＳＡ振替額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gmroanfundsahurikaegaku</td><td>月末ローンファンドＳＡ振替額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gmhokencvgoukeigaku</td><td>月末保険ＣＶ合計額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gkgmhokencvgoukeigaku</td><td>（外貨）月末保険ＣＶ合計額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gmsktsganrigoukeizandaka</td><td>月末初期投資元利合計残高</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gkgmsktsganrigoukeizandaka</td><td>（外貨）月末初期投資元利合計残高</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gmmihurikaesousatugaku</td><td>月末未振替相殺額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gkgmmihurikaesousatugaku</td><td>（外貨）月末未振替相殺額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_FundIndexGetumatuCf
 * @see     GenBM_FundIndexGetumatuCf
 * @see     QBM_FundIndexGetumatuCf
 * @see     GenQBM_FundIndexGetumatuCf
 */
public class PKBM_FundIndexGetumatuCf extends AbstractExDBPrimaryKey<BM_FundIndexGetumatuCf, PKBM_FundIndexGetumatuCf> {

    private static final long serialVersionUID = 1L;

    public PKBM_FundIndexGetumatuCf() {
    }

    public PKBM_FundIndexGetumatuCf(
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
    public Class<BM_FundIndexGetumatuCf> getEntityClass() {
        return BM_FundIndexGetumatuCf.class;
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