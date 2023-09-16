package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KwsrendouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_KawaseRate;
import yuyu.def.db.mapping.GenBM_KawaseRate;
import yuyu.def.db.meta.GenQBM_KawaseRate;
import yuyu.def.db.meta.QBM_KawaseRate;

/**
 * 為替レートマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_KawaseRate}</td><td colspan="3">為替レートマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKwsratekjymd kwsratekjymd}</td><td>為替レート基準日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKwsrendoukbn kwsrendoukbn}</td><td>為替レート連動区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_KwsrendouKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getMototuuka mototuuka}</td><td>元通貨</td><td align="center">○</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKanzantuuka kanzantuuka}</td><td>換算通貨</td><td align="center">○</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKawasetekiyokbn kawasetekiyokbn}</td><td>為替適用区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_KawasetekiyoKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKawasetsrykbn kawasetsrykbn}</td><td>為替手数料区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_KawasetsryKbn}</td></tr>
 *  <tr><td>kawaserate</td><td>為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_KawaseRate
 * @see     GenBM_KawaseRate
 * @see     QBM_KawaseRate
 * @see     GenQBM_KawaseRate
 */
public class PKBM_KawaseRate extends AbstractExDBPrimaryKey<BM_KawaseRate, PKBM_KawaseRate> {

    private static final long serialVersionUID = 1L;

    public PKBM_KawaseRate() {
    }

    public PKBM_KawaseRate(
        BizDate pKwsratekjymd,
        C_KwsrendouKbn pKwsrendoukbn,
        C_Tuukasyu pMototuuka,
        C_Tuukasyu pKanzantuuka,
        C_KawasetekiyoKbn pKawasetekiyokbn,
        C_KawasetsryKbn pKawasetsrykbn
    ) {
        kwsratekjymd = pKwsratekjymd;
        kwsrendoukbn = pKwsrendoukbn;
        mototuuka = pMototuuka;
        kanzantuuka = pKanzantuuka;
        kawasetekiyokbn = pKawasetekiyokbn;
        kawasetsrykbn = pKawasetsrykbn;
    }

    @Transient
    @Override
    public Class<BM_KawaseRate> getEntityClass() {
        return BM_KawaseRate.class;
    }

    private BizDate kwsratekjymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getKwsratekjymd() {
        return kwsratekjymd;
    }

    public void setKwsratekjymd(BizDate pKwsratekjymd) {
        kwsratekjymd = pKwsratekjymd;
    }
    private C_KwsrendouKbn kwsrendoukbn;

    @org.hibernate.annotations.Type(type="UserType_C_KwsrendouKbn")
    public C_KwsrendouKbn getKwsrendoukbn() {
        return kwsrendoukbn;
    }

    public void setKwsrendoukbn(C_KwsrendouKbn pKwsrendoukbn) {
        kwsrendoukbn = pKwsrendoukbn;
    }
    private C_Tuukasyu mototuuka;

    @org.hibernate.annotations.Type(type="UserType_C_Tuukasyu")
    public C_Tuukasyu getMototuuka() {
        return mototuuka;
    }

    public void setMototuuka(C_Tuukasyu pMototuuka) {
        mototuuka = pMototuuka;
    }
    private C_Tuukasyu kanzantuuka;

    @org.hibernate.annotations.Type(type="UserType_C_Tuukasyu")
    public C_Tuukasyu getKanzantuuka() {
        return kanzantuuka;
    }

    public void setKanzantuuka(C_Tuukasyu pKanzantuuka) {
        kanzantuuka = pKanzantuuka;
    }
    private C_KawasetekiyoKbn kawasetekiyokbn;

    @org.hibernate.annotations.Type(type="UserType_C_KawasetekiyoKbn")
    public C_KawasetekiyoKbn getKawasetekiyokbn() {
        return kawasetekiyokbn;
    }

    public void setKawasetekiyokbn(C_KawasetekiyoKbn pKawasetekiyokbn) {
        kawasetekiyokbn = pKawasetekiyokbn;
    }
    private C_KawasetsryKbn kawasetsrykbn;

    @org.hibernate.annotations.Type(type="UserType_C_KawasetsryKbn")
    public C_KawasetsryKbn getKawasetsrykbn() {
        return kawasetsrykbn;
    }

    public void setKawasetsrykbn(C_KawasetsryKbn pKawasetsrykbn) {
        kawasetsrykbn = pKawasetsrykbn;
    }

}