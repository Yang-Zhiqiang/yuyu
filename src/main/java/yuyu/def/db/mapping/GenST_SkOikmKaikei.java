package yuyu.def.db.mapping;

import com.google.common.base.Optional;
import java.math.BigDecimal;
import java.sql.SQLException;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_DensyoriKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_HenkinriyuuKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KessantyouseiKbn;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.ST_SkOikmKaikei;
import yuyu.def.db.id.PKST_SkOikmKaikei;
import yuyu.def.db.meta.GenQST_SkOikmKaikei;
import yuyu.def.db.meta.QST_SkOikmKaikei;
import yuyu.def.db.type.UserType_C_DensyoriKbn;
import yuyu.def.db.type.UserType_C_DensysKbn;
import yuyu.def.db.type.UserType_C_HenkinriyuuKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_Kanjyoukmkcd;
import yuyu.def.db.type.UserType_C_KessantyouseiKbn;
import yuyu.def.db.type.UserType_C_NaibuKeiyakuKbn;
import yuyu.def.db.type.UserType_C_Sdpd;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_TaisyakuKbn;
import yuyu.def.db.type.UserType_C_TantouCdKbn;
import yuyu.def.db.type.UserType_C_TekiyouKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 新契約追込会計取引データテーブル テーブルのマッピング情報クラスで、 {@link ST_SkOikmKaikei} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ST_SkOikmKaikei}</td><td colspan="3">新契約追込会計取引データテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDensyskbn densyskbn}</td><td>伝票用システム区分</td><td align="center">{@link PKST_SkOikmKaikei ○}</td><td align="center">V</td><td>{@link C_DensysKbn}</td></tr>
 *  <tr><td>{@link #getDenrenno denrenno}</td><td>伝票データ連番</td><td align="center">{@link PKST_SkOikmKaikei ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getEdano edano}</td><td>枝番号</td><td align="center">{@link PKST_SkOikmKaikei ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHuridenatesakicd huridenatesakicd}</td><td>振替伝票宛先部課コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTantocd tantocd}</td><td>担当コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TantouCdKbn}</td></tr>
 *  <tr><td>{@link #getDenymd denymd}</td><td>伝票日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTaisyakukbn taisyakukbn}</td><td>貸借区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TaisyakuKbn}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd kanjyoukmkcd}</td><td>勘定科目コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getSuitoubumoncd suitoubumoncd}</td><td>出納部門コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDengaikagk dengaikagk}</td><td>伝票金額（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDenkawaserate denkawaserate}</td><td>伝票用為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDenyenkagk denyenkagk}</td><td>伝票金額（円）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyoricd syoricd}</td><td>処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyorisosikicd syorisosikicd}</td><td>処理組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeg1cd seg1cd}</td><td>セグメント１コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr><td>{@link #getSeg2cd seg2cd}</td><td>セグメント２コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr><td>{@link #getKessantyouseikbn kessantyouseikbn}</td><td>決算調整区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KessantyouseiKbn}</td></tr>
 *  <tr><td>{@link #getNaibukeiyakukbn naibukeiyakukbn}</td><td>内部契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NaibuKeiyakuKbn}</td></tr>
 *  <tr><td>{@link #getTekiyoukbn tekiyoukbn}</td><td>摘要区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TekiyouKbn}</td></tr>
 *  <tr><td>{@link #getDensyorikbn densyorikbn}</td><td>伝票処理区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DensyoriKbn}</td></tr>
 *  <tr><td>{@link #getAatsukaishasuitososhikicd aatsukaishasuitososhikicd}</td><td>Ａ扱者出納組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHnknriyuukbn hnknriyuukbn}</td><td>返金理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HenkinriyuuKbn}</td></tr>
 *  <tr><td>{@link #getFstpryosyuymd fstpryosyuymd}</td><td>初回Ｐ領収日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getBosyuuym bosyuuym}</td><td>募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getMosymd mosymd}</td><td>申込日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSknnkaisiymd sknnkaisiymd}</td><td>責任開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyusyouhncd syusyouhncd}</td><td>主契約商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRyouritusdno ryouritusdno}</td><td>料率世代番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getHrkkeiro hrkkeiro}</td><td>払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkeiro}</td></tr>
 *  <tr><td>{@link #getSdpdkbn sdpdkbn}</td><td>Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Sdpd}</td></tr>
 *  <tr><td>{@link #getAatsukaishasoshikicd aatsukaishasoshikicd}</td><td>Ａ扱者組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAatkisyadaibosyuucd aatkisyadaibosyuucd}</td><td>Ａ扱者代表募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAatkisyabosyuucd aatkisyabosyuucd}</td><td>Ａ扱者募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ST_SkOikmKaikei
 * @see     PKST_SkOikmKaikei
 * @see     QST_SkOikmKaikei
 * @see     GenQST_SkOikmKaikei
 */
@MappedSuperclass
@Table(name=GenST_SkOikmKaikei.TABLE_NAME)
@IdClass(value=PKST_SkOikmKaikei.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_DensyoriKbn", typeClass=UserType_C_DensyoriKbn.class),
    @TypeDef(name="UserType_C_DensysKbn", typeClass=UserType_C_DensysKbn.class),
    @TypeDef(name="UserType_C_HenkinriyuuKbn", typeClass=UserType_C_HenkinriyuuKbn.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_Hrkkeiro", typeClass=UserType_C_Hrkkeiro.class),
    @TypeDef(name="UserType_C_Kanjyoukmkcd", typeClass=UserType_C_Kanjyoukmkcd.class),
    @TypeDef(name="UserType_C_KessantyouseiKbn", typeClass=UserType_C_KessantyouseiKbn.class),
    @TypeDef(name="UserType_C_NaibuKeiyakuKbn", typeClass=UserType_C_NaibuKeiyakuKbn.class),
    @TypeDef(name="UserType_C_Sdpd", typeClass=UserType_C_Sdpd.class),
    @TypeDef(name="UserType_C_Segcd", typeClass=UserType_C_Segcd.class),
    @TypeDef(name="UserType_C_TaisyakuKbn", typeClass=UserType_C_TaisyakuKbn.class),
    @TypeDef(name="UserType_C_TantouCdKbn", typeClass=UserType_C_TantouCdKbn.class),
    @TypeDef(name="UserType_C_TekiyouKbn", typeClass=UserType_C_TekiyouKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenST_SkOikmKaikei extends AbstractExDBEntity<ST_SkOikmKaikei, PKST_SkOikmKaikei> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ST_SkOikmKaikei";
    public static final String DENSYSKBN                = "densyskbn";
    public static final String DENRENNO                 = "denrenno";
    public static final String EDANO                    = "edano";
    public static final String MOSNO                    = "mosno";
    public static final String HURIDENATESAKICD         = "huridenatesakicd";
    public static final String TANTOCD                  = "tantocd";
    public static final String DENYMD                   = "denymd";
    public static final String TAISYAKUKBN              = "taisyakukbn";
    public static final String KANJYOUKMKCD             = "kanjyoukmkcd";
    public static final String SUITOUBUMONCD            = "suitoubumoncd";
    public static final String TUUKASYU                 = "tuukasyu";
    public static final String DENGAIKAGK               = "dengaikagk";
    public static final String DENKAWASERATE            = "denkawaserate";
    public static final String DENYENKAGK               = "denyenkagk";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String SYORICD                  = "syoricd";
    public static final String SYORISOSIKICD            = "syorisosikicd";
    public static final String SEG1CD                   = "seg1cd";
    public static final String SEG2CD                   = "seg2cd";
    public static final String KESSANTYOUSEIKBN         = "kessantyouseikbn";
    public static final String NAIBUKEIYAKUKBN          = "naibukeiyakukbn";
    public static final String TEKIYOUKBN               = "tekiyoukbn";
    public static final String DENSYORIKBN              = "densyorikbn";
    public static final String AATSUKAISHASUITOSOSHIKICD = "aatsukaishasuitososhikicd";
    public static final String HNKNRIYUUKBN             = "hnknriyuukbn";
    public static final String FSTPRYOSYUYMD            = "fstpryosyuymd";
    public static final String BOSYUUYM                 = "bosyuuym";
    public static final String MOSYMD                   = "mosymd";
    public static final String KYKYMD                   = "kykymd";
    public static final String SKNNKAISIYMD             = "sknnkaisiymd";
    public static final String SYUSYOUHNCD              = "syusyouhncd";
    public static final String RYOURITUSDNO             = "ryouritusdno";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String HRKKEIRO                 = "hrkkeiro";
    public static final String SDPDKBN                  = "sdpdkbn";
    public static final String AATSUKAISHASOSHIKICD     = "aatsukaishasoshikicd";
    public static final String AATKISYADAIBOSYUUCD      = "aatkisyadaibosyuucd";
    public static final String AATKISYABOSYUUCD         = "aatkisyabosyuucd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKST_SkOikmKaikei primaryKey;

    public GenST_SkOikmKaikei() {
        primaryKey = new PKST_SkOikmKaikei();
    }

    public GenST_SkOikmKaikei(
        C_DensysKbn pDensyskbn,
        String pDenrenno,
        Integer pEdano
    ) {
        primaryKey = new PKST_SkOikmKaikei(
            pDensyskbn,
            pDenrenno,
            pEdano
        );
    }

    @Transient
    @Override
    public PKST_SkOikmKaikei getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QST_SkOikmKaikei> getMetaClass() {
        return QST_SkOikmKaikei.class;
    }

    @Id
    @Type(type="UserType_C_DensysKbn")
    @Column(name=GenST_SkOikmKaikei.DENSYSKBN)
    public C_DensysKbn getDensyskbn() {
        return getPrimaryKey().getDensyskbn();
    }

    public void setDensyskbn(C_DensysKbn pDensyskbn) {
        getPrimaryKey().setDensyskbn(pDensyskbn);
    }

    @Id
    @Column(name=GenST_SkOikmKaikei.DENRENNO)
    public String getDenrenno() {
        return getPrimaryKey().getDenrenno();
    }

    public void setDenrenno(String pDenrenno) {
        getPrimaryKey().setDenrenno(pDenrenno);
    }

    @Id
    @Column(name=GenST_SkOikmKaikei.EDANO)
    public Integer getEdano() {
        return getPrimaryKey().getEdano();
    }

    public void setEdano(Integer pEdano) {
        getPrimaryKey().setEdano(pEdano);
    }

    private String mosno;

    @Column(name=GenST_SkOikmKaikei.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return mosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

    private String huridenatesakicd;

    @Column(name=GenST_SkOikmKaikei.HURIDENATESAKICD)
    public String getHuridenatesakicd() {
        return huridenatesakicd;
    }

    public void setHuridenatesakicd(String pHuridenatesakicd) {
        huridenatesakicd = pHuridenatesakicd;
    }

    private C_TantouCdKbn tantocd;

    @Type(type="UserType_C_TantouCdKbn")
    @Column(name=GenST_SkOikmKaikei.TANTOCD)
    public C_TantouCdKbn getTantocd() {
        return tantocd;
    }

    public void setTantocd(C_TantouCdKbn pTantocd) {
        tantocd = pTantocd;
    }

    private BizDate denymd;

    @Type(type="BizDateType")
    @Column(name=GenST_SkOikmKaikei.DENYMD)
    public BizDate getDenymd() {
        return denymd;
    }

    public void setDenymd(BizDate pDenymd) {
        denymd = pDenymd;
    }

    private C_TaisyakuKbn taisyakukbn;

    @Type(type="UserType_C_TaisyakuKbn")
    @Column(name=GenST_SkOikmKaikei.TAISYAKUKBN)
    public C_TaisyakuKbn getTaisyakukbn() {
        return taisyakukbn;
    }

    public void setTaisyakukbn(C_TaisyakuKbn pTaisyakukbn) {
        taisyakukbn = pTaisyakukbn;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenST_SkOikmKaikei.KANJYOUKMKCD)
    public C_Kanjyoukmkcd getKanjyoukmkcd() {
        return kanjyoukmkcd;
    }

    public void setKanjyoukmkcd(C_Kanjyoukmkcd pKanjyoukmkcd) {
        kanjyoukmkcd = pKanjyoukmkcd;
    }

    private String suitoubumoncd;

    @Column(name=GenST_SkOikmKaikei.SUITOUBUMONCD)
    public String getSuitoubumoncd() {
        return suitoubumoncd;
    }

    public void setSuitoubumoncd(String pSuitoubumoncd) {
        suitoubumoncd = pSuitoubumoncd;
    }

    private C_Tuukasyu tuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenST_SkOikmKaikei.TUUKASYU)
    public C_Tuukasyu getTuukasyu() {
        return tuukasyu;
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        tuukasyu = pTuukasyu;
    }

    private BizCurrency dengaikagk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDengaikagk() {
        return dengaikagk;
    }

    public void setDengaikagk(BizCurrency pDengaikagk) {
        dengaikagk = pDengaikagk;
        dengaikagkValue = null;
        dengaikagkType  = null;
    }

    transient private BigDecimal dengaikagkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=DENGAIKAGK, nullable=true)
    protected BigDecimal getDengaikagkValue() {
        if (dengaikagkValue == null && dengaikagk != null) {
            if (dengaikagk.isOptional()) return null;
            return dengaikagk.absolute();
        }
        return dengaikagkValue;
    }

    protected void setDengaikagkValue(BigDecimal value) {
        dengaikagkValue = value;
        dengaikagk = Optional.fromNullable(toCurrencyType(dengaikagkType))
            .transform(bizCurrencyTransformer(getDengaikagkValue()))
            .orNull();
    }

    transient private String dengaikagkType = null;

    @Column(name=DENGAIKAGK + "$", nullable=true)
    protected String getDengaikagkType() {
        if (dengaikagkType == null && dengaikagk != null) return dengaikagk.getType().toString();
        if (dengaikagkType == null && getDengaikagkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dengaikagk$' should not be NULL."));
        }
        return dengaikagkType;
    }

    protected void setDengaikagkType(String type) {
        dengaikagkType = type;
        dengaikagk = Optional.fromNullable(toCurrencyType(dengaikagkType))
            .transform(bizCurrencyTransformer(getDengaikagkValue()))
            .orNull();
    }

    private BizNumber denkawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenST_SkOikmKaikei.DENKAWASERATE)
    public BizNumber getDenkawaserate() {
        return denkawaserate;
    }

    public void setDenkawaserate(BizNumber pDenkawaserate) {
        denkawaserate = pDenkawaserate;
    }

    private BizCurrency denyenkagk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDenyenkagk() {
        return denyenkagk;
    }

    public void setDenyenkagk(BizCurrency pDenyenkagk) {
        denyenkagk = pDenyenkagk;
        denyenkagkValue = null;
        denyenkagkType  = null;
    }

    transient private BigDecimal denyenkagkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=DENYENKAGK, nullable=true)
    protected BigDecimal getDenyenkagkValue() {
        if (denyenkagkValue == null && denyenkagk != null) {
            if (denyenkagk.isOptional()) return null;
            return denyenkagk.absolute();
        }
        return denyenkagkValue;
    }

    protected void setDenyenkagkValue(BigDecimal value) {
        denyenkagkValue = value;
        denyenkagk = Optional.fromNullable(toCurrencyType(denyenkagkType))
            .transform(bizCurrencyTransformer(getDenyenkagkValue()))
            .orNull();
    }

    transient private String denyenkagkType = null;

    @Column(name=DENYENKAGK + "$", nullable=true)
    protected String getDenyenkagkType() {
        if (denyenkagkType == null && denyenkagk != null) return denyenkagk.getType().toString();
        if (denyenkagkType == null && getDenyenkagkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'denyenkagk$' should not be NULL."));
        }
        return denyenkagkType;
    }

    protected void setDenyenkagkType(String type) {
        denyenkagkType = type;
        denyenkagk = Optional.fromNullable(toCurrencyType(denyenkagkType))
            .transform(bizCurrencyTransformer(getDenyenkagkValue()))
            .orNull();
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenST_SkOikmKaikei.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    private String syoricd;

    @Column(name=GenST_SkOikmKaikei.SYORICD)
    public String getSyoricd() {
        return syoricd;
    }

    public void setSyoricd(String pSyoricd) {
        syoricd = pSyoricd;
    }

    private String syorisosikicd;

    @Column(name=GenST_SkOikmKaikei.SYORISOSIKICD)
    public String getSyorisosikicd() {
        return syorisosikicd;
    }

    public void setSyorisosikicd(String pSyorisosikicd) {
        syorisosikicd = pSyorisosikicd;
    }

    private C_Segcd seg1cd;

    @Type(type="UserType_C_Segcd")
    @Column(name=GenST_SkOikmKaikei.SEG1CD)
    public C_Segcd getSeg1cd() {
        return seg1cd;
    }

    public void setSeg1cd(C_Segcd pSeg1cd) {
        seg1cd = pSeg1cd;
    }

    private C_Segcd seg2cd;

    @Type(type="UserType_C_Segcd")
    @Column(name=GenST_SkOikmKaikei.SEG2CD)
    public C_Segcd getSeg2cd() {
        return seg2cd;
    }

    public void setSeg2cd(C_Segcd pSeg2cd) {
        seg2cd = pSeg2cd;
    }

    private C_KessantyouseiKbn kessantyouseikbn;

    @Type(type="UserType_C_KessantyouseiKbn")
    @Column(name=GenST_SkOikmKaikei.KESSANTYOUSEIKBN)
    public C_KessantyouseiKbn getKessantyouseikbn() {
        return kessantyouseikbn;
    }

    public void setKessantyouseikbn(C_KessantyouseiKbn pKessantyouseikbn) {
        kessantyouseikbn = pKessantyouseikbn;
    }

    private C_NaibuKeiyakuKbn naibukeiyakukbn;

    @Type(type="UserType_C_NaibuKeiyakuKbn")
    @Column(name=GenST_SkOikmKaikei.NAIBUKEIYAKUKBN)
    public C_NaibuKeiyakuKbn getNaibukeiyakukbn() {
        return naibukeiyakukbn;
    }

    public void setNaibukeiyakukbn(C_NaibuKeiyakuKbn pNaibukeiyakukbn) {
        naibukeiyakukbn = pNaibukeiyakukbn;
    }

    private C_TekiyouKbn tekiyoukbn;

    @Type(type="UserType_C_TekiyouKbn")
    @Column(name=GenST_SkOikmKaikei.TEKIYOUKBN)
    public C_TekiyouKbn getTekiyoukbn() {
        return tekiyoukbn;
    }

    public void setTekiyoukbn(C_TekiyouKbn pTekiyoukbn) {
        tekiyoukbn = pTekiyoukbn;
    }

    private C_DensyoriKbn densyorikbn;

    @Type(type="UserType_C_DensyoriKbn")
    @Column(name=GenST_SkOikmKaikei.DENSYORIKBN)
    public C_DensyoriKbn getDensyorikbn() {
        return densyorikbn;
    }

    public void setDensyorikbn(C_DensyoriKbn pDensyorikbn) {
        densyorikbn = pDensyorikbn;
    }

    private String aatsukaishasuitososhikicd;

    @Column(name=GenST_SkOikmKaikei.AATSUKAISHASUITOSOSHIKICD)
    public String getAatsukaishasuitososhikicd() {
        return aatsukaishasuitososhikicd;
    }

    public void setAatsukaishasuitososhikicd(String pAatsukaishasuitososhikicd) {
        aatsukaishasuitososhikicd = pAatsukaishasuitososhikicd;
    }

    private C_HenkinriyuuKbn hnknriyuukbn;

    @Type(type="UserType_C_HenkinriyuuKbn")
    @Column(name=GenST_SkOikmKaikei.HNKNRIYUUKBN)
    public C_HenkinriyuuKbn getHnknriyuukbn() {
        return hnknriyuukbn;
    }

    public void setHnknriyuukbn(C_HenkinriyuuKbn pHnknriyuukbn) {
        hnknriyuukbn = pHnknriyuukbn;
    }

    private BizDate fstpryosyuymd;

    @Type(type="BizDateType")
    @Column(name=GenST_SkOikmKaikei.FSTPRYOSYUYMD)
    public BizDate getFstpryosyuymd() {
        return fstpryosyuymd;
    }

    public void setFstpryosyuymd(BizDate pFstpryosyuymd) {
        fstpryosyuymd = pFstpryosyuymd;
    }

    private BizDateYM bosyuuym;

    @Type(type="BizDateYMType")
    @Column(name=GenST_SkOikmKaikei.BOSYUUYM)
    @ValidDateYm
    public BizDateYM getBosyuuym() {
        return bosyuuym;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuuym(BizDateYM pBosyuuym) {
        bosyuuym = pBosyuuym;
    }

    private BizDate mosymd;

    @Type(type="BizDateType")
    @Column(name=GenST_SkOikmKaikei.MOSYMD)
    @ValidDate
    public BizDate getMosymd() {
        return mosymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosymd(BizDate pMosymd) {
        mosymd = pMosymd;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenST_SkOikmKaikei.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private BizDate sknnkaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenST_SkOikmKaikei.SKNNKAISIYMD)
    public BizDate getSknnkaisiymd() {
        return sknnkaisiymd;
    }

    @Trim("both")
    public void setSknnkaisiymd(BizDate pSknnkaisiymd) {
        sknnkaisiymd = pSknnkaisiymd;
    }

    private String syusyouhncd;

    @Column(name=GenST_SkOikmKaikei.SYUSYOUHNCD)
    public String getSyusyouhncd() {
        return syusyouhncd;
    }

    public void setSyusyouhncd(String pSyusyouhncd) {
        syusyouhncd = pSyusyouhncd;
    }

    private String ryouritusdno;

    @Column(name=GenST_SkOikmKaikei.RYOURITUSDNO)
    public String getRyouritusdno() {
        return ryouritusdno;
    }

    public void setRyouritusdno(String pRyouritusdno) {
        ryouritusdno = pRyouritusdno;
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenST_SkOikmKaikei.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private C_Hrkkeiro hrkkeiro;

    @Type(type="UserType_C_Hrkkeiro")
    @Column(name=GenST_SkOikmKaikei.HRKKEIRO)
    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }

    private C_Sdpd sdpdkbn;

    @Type(type="UserType_C_Sdpd")
    @Column(name=GenST_SkOikmKaikei.SDPDKBN)
    public C_Sdpd getSdpdkbn() {
        return sdpdkbn;
    }

    public void setSdpdkbn(C_Sdpd pSdpdkbn) {
        sdpdkbn = pSdpdkbn;
    }

    private String aatsukaishasoshikicd;

    @Column(name=GenST_SkOikmKaikei.AATSUKAISHASOSHIKICD)
    public String getAatsukaishasoshikicd() {
        return aatsukaishasoshikicd;
    }

    public void setAatsukaishasoshikicd(String pAatsukaishasoshikicd) {
        aatsukaishasoshikicd = pAatsukaishasoshikicd;
    }

    private String aatkisyadaibosyuucd;

    @Column(name=GenST_SkOikmKaikei.AATKISYADAIBOSYUUCD)
    public String getAatkisyadaibosyuucd() {
        return aatkisyadaibosyuucd;
    }

    public void setAatkisyadaibosyuucd(String pAatkisyadaibosyuucd) {
        aatkisyadaibosyuucd = pAatkisyadaibosyuucd;
    }

    private String aatkisyabosyuucd;

    @Column(name=GenST_SkOikmKaikei.AATKISYABOSYUUCD)
    public String getAatkisyabosyuucd() {
        return aatkisyabosyuucd;
    }

    public void setAatkisyabosyuucd(String pAatkisyabosyuucd) {
        aatkisyabosyuucd = pAatkisyabosyuucd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenST_SkOikmKaikei.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenST_SkOikmKaikei.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}