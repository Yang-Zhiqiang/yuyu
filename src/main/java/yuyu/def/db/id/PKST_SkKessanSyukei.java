package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.db.entity.ST_SkKessanSyukei;
import yuyu.def.db.mapping.GenST_SkKessanSyukei;
import yuyu.def.db.meta.GenQST_SkKessanSyukei;
import yuyu.def.db.meta.QST_SkKessanSyukei;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 新契約決算用集計元データテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ST_SkKessanSyukei}</td><td colspan="3">新契約決算用集計元データテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDenymd denymd}</td><td>伝票日付</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKanjyoukmkcd kanjyoukmkcd}</td><td>勘定科目コード</td><td align="center">○</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTaisyakukbn taisyakukbn}</td><td>貸借区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_TaisyakuKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getNaibukeiyakukbn naibukeiyakukbn}</td><td>内部契約区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_NaibuKeiyakuKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTekiyoukbn tekiyoukbn}</td><td>摘要区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_TekiyouKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSeg1cd seg1cd}</td><td>セグメント１コード</td><td align="center">○</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr><td>keirisyskbn</td><td>経理システム区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KeirisysKbn C_KeirisysKbn}</td></tr>
 *  <tr><td>huridenatesakicd</td><td>振替伝票宛先部課コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tantocd</td><td>担当コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TantouCdKbn C_TantouCdKbn}</td></tr>
 *  <tr><td>denkanjokamokucd</td><td>伝票用勘定科目コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tekiyoucd</td><td>摘要コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>suitoubumoncd</td><td>出納部門コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>denyenkagk</td><td>伝票金額（円）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>huridenpagekbn</td><td>振替伝票ページ区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HuridenpageKbn C_HuridenpageKbn}</td></tr>
 *  <tr><td>syoriYmd</td><td>処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ST_SkKessanSyukei
 * @see     GenST_SkKessanSyukei
 * @see     QST_SkKessanSyukei
 * @see     GenQST_SkKessanSyukei
 */
public class PKST_SkKessanSyukei extends AbstractExDBPrimaryKey<ST_SkKessanSyukei, PKST_SkKessanSyukei> {

    private static final long serialVersionUID = 1L;

    public PKST_SkKessanSyukei() {
    }

    public PKST_SkKessanSyukei(
        String pMosno,
        BizDate pDenymd,
        C_Kanjyoukmkcd pKanjyoukmkcd,
        C_TaisyakuKbn pTaisyakukbn,
        C_NaibuKeiyakuKbn pNaibukeiyakukbn,
        C_TekiyouKbn pTekiyoukbn,
        C_Segcd pSeg1cd
    ) {
        mosno = pMosno;
        denymd = pDenymd;
        kanjyoukmkcd = pKanjyoukmkcd;
        taisyakukbn = pTaisyakukbn;
        naibukeiyakukbn = pNaibukeiyakukbn;
        tekiyoukbn = pTekiyoukbn;
        seg1cd = pSeg1cd;
    }

    @Transient
    @Override
    public Class<ST_SkKessanSyukei> getEntityClass() {
        return ST_SkKessanSyukei.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }
    private BizDate denymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getDenymd() {
        return denymd;
    }

    public void setDenymd(BizDate pDenymd) {
        denymd = pDenymd;
    }
    private C_Kanjyoukmkcd kanjyoukmkcd;

    @org.hibernate.annotations.Type(type="UserType_C_Kanjyoukmkcd")
    public C_Kanjyoukmkcd getKanjyoukmkcd() {
        return kanjyoukmkcd;
    }

    public void setKanjyoukmkcd(C_Kanjyoukmkcd pKanjyoukmkcd) {
        kanjyoukmkcd = pKanjyoukmkcd;
    }
    private C_TaisyakuKbn taisyakukbn;

    @org.hibernate.annotations.Type(type="UserType_C_TaisyakuKbn")
    public C_TaisyakuKbn getTaisyakukbn() {
        return taisyakukbn;
    }

    public void setTaisyakukbn(C_TaisyakuKbn pTaisyakukbn) {
        taisyakukbn = pTaisyakukbn;
    }
    private C_NaibuKeiyakuKbn naibukeiyakukbn;

    @org.hibernate.annotations.Type(type="UserType_C_NaibuKeiyakuKbn")
    public C_NaibuKeiyakuKbn getNaibukeiyakukbn() {
        return naibukeiyakukbn;
    }

    public void setNaibukeiyakukbn(C_NaibuKeiyakuKbn pNaibukeiyakukbn) {
        naibukeiyakukbn = pNaibukeiyakukbn;
    }
    private C_TekiyouKbn tekiyoukbn;

    @org.hibernate.annotations.Type(type="UserType_C_TekiyouKbn")
    public C_TekiyouKbn getTekiyoukbn() {
        return tekiyoukbn;
    }

    public void setTekiyoukbn(C_TekiyouKbn pTekiyoukbn) {
        tekiyoukbn = pTekiyoukbn;
    }
    private C_Segcd seg1cd;

    @org.hibernate.annotations.Type(type="UserType_C_Segcd")
    public C_Segcd getSeg1cd() {
        return seg1cd;
    }

    public void setSeg1cd(C_Segcd pSeg1cd) {
        seg1cd = pSeg1cd;
    }

}