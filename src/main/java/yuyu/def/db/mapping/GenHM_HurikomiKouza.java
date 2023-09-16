package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HrkmirninEditPtnKbn;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.classification.C_TaisyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.HM_HurikomiKouza;
import yuyu.def.db.id.PKHM_HurikomiKouza;
import yuyu.def.db.meta.GenQHM_HurikomiKouza;
import yuyu.def.db.meta.QHM_HurikomiKouza;
import yuyu.def.db.type.UserType_C_HrkmirninEditPtnKbn;
import yuyu.def.db.type.UserType_C_NyktyhyoutKbn;
import yuyu.def.db.type.UserType_C_TaisyouKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;

/**
 * 振込口座マスタ テーブルのマッピング情報クラスで、 {@link HM_HurikomiKouza} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HM_HurikomiKouza}</td><td colspan="3">振込口座マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">{@link PKHM_HurikomiKouza ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">{@link PKHM_HurikomiKouza ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">{@link PKHM_HurikomiKouza ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">{@link PKHM_HurikomiKouza ○}</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getHrkmirnincd hrkmirnincd}</td><td>振込依頼人コード</td><td align="center">{@link PKHM_HurikomiKouza ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getOyadrtencd oyadrtencd}</td><td>親代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNyuukinoyadrtennm nyuukinoyadrtennm}</td><td>入金用親代理店名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOyadrtensyoritarget oyadrtensyoritarget}</td><td>親代理店処理対象</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TaisyouKbn}</td></tr>
 *  <tr><td>{@link #getJidonykntargethyouji jidonykntargethyouji}</td><td>自動入金対象表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TaisyouKbn}</td></tr>
 *  <tr><td>{@link #getHrkmirnineditptnkbn hrkmirnineditptnkbn}</td><td>振込依頼人編集パターン区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HrkmirninEditPtnKbn}</td></tr>
 *  <tr><td>{@link #getSiteituuka siteituuka}</td><td>指定通貨</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getHonkouzacd honkouzacd}</td><td>本口座コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNyktyhyoutkbn nyktyhyoutkbn}</td><td>入金帳票出力先区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NyktyhyoutKbn}</td></tr>
 * </table>
 * @see     HM_HurikomiKouza
 * @see     PKHM_HurikomiKouza
 * @see     QHM_HurikomiKouza
 * @see     GenQHM_HurikomiKouza
 */
@MappedSuperclass
@Table(name=GenHM_HurikomiKouza.TABLE_NAME)
@IdClass(value=PKHM_HurikomiKouza.class)
@TypeDefs({
    @TypeDef(name="UserType_C_HrkmirninEditPtnKbn", typeClass=UserType_C_HrkmirninEditPtnKbn.class),
    @TypeDef(name="UserType_C_NyktyhyoutKbn", typeClass=UserType_C_NyktyhyoutKbn.class),
    @TypeDef(name="UserType_C_TaisyouKbn", typeClass=UserType_C_TaisyouKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class)
})
public abstract class GenHM_HurikomiKouza extends AbstractExDBEntity<HM_HurikomiKouza, PKHM_HurikomiKouza> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HM_HurikomiKouza";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String KOUZANO                  = "kouzano";
    public static final String TUUKASYU                 = "tuukasyu";
    public static final String HRKMIRNINCD              = "hrkmirnincd";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String OYADRTENCD               = "oyadrtencd";
    public static final String NYUUKINOYADRTENNM        = "nyuukinoyadrtennm";
    public static final String OYADRTENSYORITARGET      = "oyadrtensyoritarget";
    public static final String JIDONYKNTARGETHYOUJI     = "jidonykntargethyouji";
    public static final String HRKMIRNINEDITPTNKBN      = "hrkmirnineditptnkbn";
    public static final String SITEITUUKA               = "siteituuka";
    public static final String HONKOUZACD               = "honkouzacd";
    public static final String NYKTYHYOUTKBN            = "nyktyhyoutkbn";

    private final PKHM_HurikomiKouza primaryKey;

    public GenHM_HurikomiKouza() {
        primaryKey = new PKHM_HurikomiKouza();
    }

    public GenHM_HurikomiKouza(
        String pBankcd,
        String pSitencd,
        String pKouzano,
        C_Tuukasyu pTuukasyu,
        String pHrkmirnincd
    ) {
        primaryKey = new PKHM_HurikomiKouza(
            pBankcd,
            pSitencd,
            pKouzano,
            pTuukasyu,
            pHrkmirnincd
        );
    }

    @Transient
    @Override
    public PKHM_HurikomiKouza getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHM_HurikomiKouza> getMetaClass() {
        return QHM_HurikomiKouza.class;
    }

    @Id
    @Column(name=GenHM_HurikomiKouza.BANKCD)
    @Length(length=4)
    @Digit
    public String getBankcd() {
        return getPrimaryKey().getBankcd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBankcd(String pBankcd) {
        getPrimaryKey().setBankcd(pBankcd);
    }

    @Id
    @Column(name=GenHM_HurikomiKouza.SITENCD)
    @Length(length=3)
    @Digit
    public String getSitencd() {
        return getPrimaryKey().getSitencd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSitencd(String pSitencd) {
        getPrimaryKey().setSitencd(pSitencd);
    }

    @Id
    @Column(name=GenHM_HurikomiKouza.KOUZANO)
    @MaxLength(max=12)
    @HostInvalidCharacter
    public String getKouzano() {
        return getPrimaryKey().getKouzano();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKouzano(String pKouzano) {
        getPrimaryKey().setKouzano(pKouzano);
    }

    @Id
    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenHM_HurikomiKouza.TUUKASYU)
    public C_Tuukasyu getTuukasyu() {
        return getPrimaryKey().getTuukasyu();
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        getPrimaryKey().setTuukasyu(pTuukasyu);
    }

    @Id
    @Column(name=GenHM_HurikomiKouza.HRKMIRNINCD)
    public String getHrkmirnincd() {
        return getPrimaryKey().getHrkmirnincd();
    }

    public void setHrkmirnincd(String pHrkmirnincd) {
        getPrimaryKey().setHrkmirnincd(pHrkmirnincd);
    }

    private C_YokinKbn yokinkbn;

    @Type(type="UserType_C_YokinKbn")
    @Column(name=GenHM_HurikomiKouza.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String oyadrtencd;

    @Column(name=GenHM_HurikomiKouza.OYADRTENCD)
    @SingleByteStrings
    @AlphaDigit
    public String getOyadrtencd() {
        return oyadrtencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOyadrtencd(String pOyadrtencd) {
        oyadrtencd = pOyadrtencd;
    }

    private String nyuukinoyadrtennm;

    @Column(name=GenHM_HurikomiKouza.NYUUKINOYADRTENNM)
    public String getNyuukinoyadrtennm() {
        return nyuukinoyadrtennm;
    }

    public void setNyuukinoyadrtennm(String pNyuukinoyadrtennm) {
        nyuukinoyadrtennm = pNyuukinoyadrtennm;
    }

    private C_TaisyouKbn oyadrtensyoritarget;

    @Type(type="UserType_C_TaisyouKbn")
    @Column(name=GenHM_HurikomiKouza.OYADRTENSYORITARGET)
    public C_TaisyouKbn getOyadrtensyoritarget() {
        return oyadrtensyoritarget;
    }

    public void setOyadrtensyoritarget(C_TaisyouKbn pOyadrtensyoritarget) {
        oyadrtensyoritarget = pOyadrtensyoritarget;
    }

    private C_TaisyouKbn jidonykntargethyouji;

    @Type(type="UserType_C_TaisyouKbn")
    @Column(name=GenHM_HurikomiKouza.JIDONYKNTARGETHYOUJI)
    public C_TaisyouKbn getJidonykntargethyouji() {
        return jidonykntargethyouji;
    }

    public void setJidonykntargethyouji(C_TaisyouKbn pJidonykntargethyouji) {
        jidonykntargethyouji = pJidonykntargethyouji;
    }

    private C_HrkmirninEditPtnKbn hrkmirnineditptnkbn;

    @Type(type="UserType_C_HrkmirninEditPtnKbn")
    @Column(name=GenHM_HurikomiKouza.HRKMIRNINEDITPTNKBN)
    public C_HrkmirninEditPtnKbn getHrkmirnineditptnkbn() {
        return hrkmirnineditptnkbn;
    }

    public void setHrkmirnineditptnkbn(C_HrkmirninEditPtnKbn pHrkmirnineditptnkbn) {
        hrkmirnineditptnkbn = pHrkmirnineditptnkbn;
    }

    private C_Tuukasyu siteituuka;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenHM_HurikomiKouza.SITEITUUKA)
    public C_Tuukasyu getSiteituuka() {
        return siteituuka;
    }

    public void setSiteituuka(C_Tuukasyu pSiteituuka) {
        siteituuka = pSiteituuka;
    }

    private String honkouzacd;

    @Column(name=GenHM_HurikomiKouza.HONKOUZACD)
    public String getHonkouzacd() {
        return honkouzacd;
    }

    public void setHonkouzacd(String pHonkouzacd) {
        honkouzacd = pHonkouzacd;
    }

    private C_NyktyhyoutKbn nyktyhyoutkbn;

    @Type(type="UserType_C_NyktyhyoutKbn")
    @Column(name=GenHM_HurikomiKouza.NYKTYHYOUTKBN)
    public C_NyktyhyoutKbn getNyktyhyoutkbn() {
        return nyktyhyoutkbn;
    }

    public void setNyktyhyoutkbn(C_NyktyhyoutKbn pNyktyhyoutkbn) {
        nyktyhyoutkbn = pNyktyhyoutkbn;
    }
}