package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_DenpyouKbn;
import yuyu.def.classification.C_HengakuSyuruiKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TkbtKanjyouUnitFundKbn;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.BT_HengakuEpsilonDenpyo;
import yuyu.def.db.mapping.GenBT_HengakuEpsilonDenpyo;
import yuyu.def.db.meta.GenQBT_HengakuEpsilonDenpyo;
import yuyu.def.db.meta.QBT_HengakuEpsilonDenpyo;

/**
 * 変額イプシロン伝票テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_HengakuEpsilonDenpyo}</td><td colspan="3">変額イプシロン伝票テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>hengakudenpyourecdkbn</td><td>変額伝票レコード区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HengakuDenpyourecdKbn C_HengakuDenpyourecdKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHengakusyuruikbn hengakusyuruikbn}</td><td>変額種類区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_HengakuSyuruiKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getUnitfundkbn unitfundkbn}</td><td>ユニットファンド区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_UnitFundKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTkbtkanjyouunitfundkbn tkbtkanjyouunitfundkbn}</td><td>特別勘定ユニットファンド区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_TkbtKanjyouUnitFundKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKacd kacd}</td><td>課コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDenymd denymd}</td><td>伝票日付</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDenpyoukbn denpyoukbn}</td><td>伝票区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_DenpyouKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTaisyakukbn taisyakukbn}</td><td>貸借区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_TaisyakuKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKamokucd kamokucd}</td><td>科目コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>fundsyoricd</td><td>ファンド処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>cfkbn</td><td>ＣＦ区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_CfKbn C_CfKbn}</td></tr>
 *  <tr><td>hasseiriyuukbn</td><td>発生理由区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HasseiRiyuuKbn C_HasseiRiyuuKbn}</td></tr>
 *  <tr><td>hasseikbn</td><td>発生区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HasseiKbn C_HasseiKbn}</td></tr>
 *  <tr><td>fundkingaku</td><td>ファンド金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BT_HengakuEpsilonDenpyo
 * @see     GenBT_HengakuEpsilonDenpyo
 * @see     QBT_HengakuEpsilonDenpyo
 * @see     GenQBT_HengakuEpsilonDenpyo
 */
public class PKBT_HengakuEpsilonDenpyo extends AbstractExDBPrimaryKey<BT_HengakuEpsilonDenpyo, PKBT_HengakuEpsilonDenpyo> {

    private static final long serialVersionUID = 1L;

    public PKBT_HengakuEpsilonDenpyo() {
    }

    public PKBT_HengakuEpsilonDenpyo(
        C_HengakuSyuruiKbn pHengakusyuruikbn,
        C_UnitFundKbn pUnitfundkbn,
        C_TkbtKanjyouUnitFundKbn pTkbtkanjyouunitfundkbn,
        String pKacd,
        BizDate pDenymd,
        C_DenpyouKbn pDenpyoukbn,
        C_TaisyakuKbn pTaisyakukbn,
        String pKamokucd,
        BizDate pSyoriYmd
    ) {
        hengakusyuruikbn = pHengakusyuruikbn;
        unitfundkbn = pUnitfundkbn;
        tkbtkanjyouunitfundkbn = pTkbtkanjyouunitfundkbn;
        kacd = pKacd;
        denymd = pDenymd;
        denpyoukbn = pDenpyoukbn;
        taisyakukbn = pTaisyakukbn;
        kamokucd = pKamokucd;
        syoriYmd = pSyoriYmd;
    }

    @Transient
    @Override
    public Class<BT_HengakuEpsilonDenpyo> getEntityClass() {
        return BT_HengakuEpsilonDenpyo.class;
    }

    private C_HengakuSyuruiKbn hengakusyuruikbn;

    @org.hibernate.annotations.Type(type="UserType_C_HengakuSyuruiKbn")
    public C_HengakuSyuruiKbn getHengakusyuruikbn() {
        return hengakusyuruikbn;
    }

    public void setHengakusyuruikbn(C_HengakuSyuruiKbn pHengakusyuruikbn) {
        hengakusyuruikbn = pHengakusyuruikbn;
    }
    private C_UnitFundKbn unitfundkbn;

    @org.hibernate.annotations.Type(type="UserType_C_UnitFundKbn")
    public C_UnitFundKbn getUnitfundkbn() {
        return unitfundkbn;
    }

    public void setUnitfundkbn(C_UnitFundKbn pUnitfundkbn) {
        unitfundkbn = pUnitfundkbn;
    }
    private C_TkbtKanjyouUnitFundKbn tkbtkanjyouunitfundkbn;

    @org.hibernate.annotations.Type(type="UserType_C_TkbtKanjyouUnitFundKbn")
    public C_TkbtKanjyouUnitFundKbn getTkbtkanjyouunitfundkbn() {
        return tkbtkanjyouunitfundkbn;
    }

    public void setTkbtkanjyouunitfundkbn(C_TkbtKanjyouUnitFundKbn pTkbtkanjyouunitfundkbn) {
        tkbtkanjyouunitfundkbn = pTkbtkanjyouunitfundkbn;
    }
    private String kacd;

    public String getKacd() {
        return kacd;
    }

    public void setKacd(String pKacd) {
        kacd = pKacd;
    }
    private BizDate denymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getDenymd() {
        return denymd;
    }

    public void setDenymd(BizDate pDenymd) {
        denymd = pDenymd;
    }
    private C_DenpyouKbn denpyoukbn;

    @org.hibernate.annotations.Type(type="UserType_C_DenpyouKbn")
    public C_DenpyouKbn getDenpyoukbn() {
        return denpyoukbn;
    }

    public void setDenpyoukbn(C_DenpyouKbn pDenpyoukbn) {
        denpyoukbn = pDenpyoukbn;
    }
    private C_TaisyakuKbn taisyakukbn;

    @org.hibernate.annotations.Type(type="UserType_C_TaisyakuKbn")
    public C_TaisyakuKbn getTaisyakukbn() {
        return taisyakukbn;
    }

    public void setTaisyakukbn(C_TaisyakuKbn pTaisyakukbn) {
        taisyakukbn = pTaisyakukbn;
    }
    private String kamokucd;

    public String getKamokucd() {
        return kamokucd;
    }

    public void setKamokucd(String pKamokucd) {
        kamokucd = pKamokucd;
    }
    private BizDate syoriYmd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

}