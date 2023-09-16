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
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.db.hibernate.usertype.BooleanType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_DenSyorisyousaiKbn;
import yuyu.def.classification.C_DenhnknhouKbn;
import yuyu.def.classification.C_DenshrhouKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_HuridensksKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.id.PKIT_KhDenpyoData;
import yuyu.def.db.meta.GenQIT_KhDenpyoData;
import yuyu.def.db.meta.QIT_KhDenpyoData;
import yuyu.def.db.type.UserType_C_DenSyorisyousaiKbn;
import yuyu.def.db.type.UserType_C_DenhnknhouKbn;
import yuyu.def.db.type.UserType_C_DenshrhouKbn;
import yuyu.def.db.type.UserType_C_DensysKbn;
import yuyu.def.db.type.UserType_C_HuridensksKbn;
import yuyu.def.db.type.UserType_C_Kanjyoukmkcd;
import yuyu.def.db.type.UserType_C_KawasetekiyoKbn;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_TaisyakuKbn;
import yuyu.def.db.type.UserType_C_TantouCdKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全伝票データテーブル テーブルのマッピング情報クラスで、 {@link IT_KhDenpyoData} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhDenpyoData}</td><td colspan="3">契約保全伝票データテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDenrenno denrenno}</td><td>伝票データ連番</td><td align="center">{@link PKIT_KhDenpyoData ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getEdano edano}</td><td>枝番号</td><td align="center">{@link PKIT_KhDenpyoData ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDensyskbn densyskbn}</td><td>伝票用システム区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DensysKbn}</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
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
 *  <tr><td>{@link #getHuridenskskbn huridenskskbn}</td><td>振替伝票作成区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HuridensksKbn}</td></tr>
 *  <tr><td>{@link #getDenhnknhoukbn denhnknhoukbn}</td><td>伝票用返金方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DenhnknhouKbn}</td></tr>
 *  <tr><td>{@link #getDenshrhoukbn denshrhoukbn}</td><td>伝票用支払方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DenshrhouKbn}</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyoricd syoricd}</td><td>処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyorisosikicd syorisosikicd}</td><td>処理組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeg1cd seg1cd}</td><td>セグメント１コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr><td>{@link #getSeg2cd seg2cd}</td><td>セグメント２コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr><td>{@link #getKakokawaserateshiteiflg kakokawaserateshiteiflg}</td><td>過去為替レート指定フラグ</td><td align="center">&nbsp;</td><td align="center">B</td><td>Boolean</td></tr>
 *  <tr><td>{@link #getKakokawaserateshiteiymd kakokawaserateshiteiymd}</td><td>過去為替レート指定年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getKeiyakutuukagk keiyakutuukagk}</td><td>契約通貨金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDengyoumucd dengyoumucd}</td><td>伝票用業務コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyusyouhncd syusyouhncd}</td><td>主契約商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKawasetekiyokbn kawasetekiyokbn}</td><td>為替適用区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KawasetekiyoKbn}</td></tr>
 *  <tr><td>{@link #getDenkarikanjyono denkarikanjyono}</td><td>伝票用仮勘定番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTaisyakutyouseiflg taisyakutyouseiflg}</td><td>貸借調整フラグ</td><td align="center">&nbsp;</td><td align="center">B</td><td>Boolean</td></tr>
 *  <tr><td>{@link #getDensyorisyousaikbn densyorisyousaikbn}</td><td>伝票用処理詳細区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DenSyorisyousaiKbn}</td></tr>
 * </table>
 * @see     IT_KhDenpyoData
 * @see     PKIT_KhDenpyoData
 * @see     QIT_KhDenpyoData
 * @see     GenQIT_KhDenpyoData
 */
@MappedSuperclass
@Table(name=GenIT_KhDenpyoData.TABLE_NAME)
@IdClass(value=PKIT_KhDenpyoData.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="BooleanType", typeClass=BooleanType.class),
    @TypeDef(name="UserType_C_DenSyorisyousaiKbn", typeClass=UserType_C_DenSyorisyousaiKbn.class),
    @TypeDef(name="UserType_C_DenhnknhouKbn", typeClass=UserType_C_DenhnknhouKbn.class),
    @TypeDef(name="UserType_C_DenshrhouKbn", typeClass=UserType_C_DenshrhouKbn.class),
    @TypeDef(name="UserType_C_DensysKbn", typeClass=UserType_C_DensysKbn.class),
    @TypeDef(name="UserType_C_HuridensksKbn", typeClass=UserType_C_HuridensksKbn.class),
    @TypeDef(name="UserType_C_Kanjyoukmkcd", typeClass=UserType_C_Kanjyoukmkcd.class),
    @TypeDef(name="UserType_C_KawasetekiyoKbn", typeClass=UserType_C_KawasetekiyoKbn.class),
    @TypeDef(name="UserType_C_Segcd", typeClass=UserType_C_Segcd.class),
    @TypeDef(name="UserType_C_TaisyakuKbn", typeClass=UserType_C_TaisyakuKbn.class),
    @TypeDef(name="UserType_C_TantouCdKbn", typeClass=UserType_C_TantouCdKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenIT_KhDenpyoData extends AbstractExDBEntity<IT_KhDenpyoData, PKIT_KhDenpyoData> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_KhDenpyoData";
    public static final String DENRENNO                 = "denrenno";
    public static final String EDANO                    = "edano";
    public static final String DENSYSKBN                = "densyskbn";
    public static final String SYONO                    = "syono";
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
    public static final String HURIDENSKSKBN            = "huridenskskbn";
    public static final String DENHNKNHOUKBN            = "denhnknhoukbn";
    public static final String DENSHRHOUKBN             = "denshrhoukbn";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String SYORICD                  = "syoricd";
    public static final String SYORISOSIKICD            = "syorisosikicd";
    public static final String SEG1CD                   = "seg1cd";
    public static final String SEG2CD                   = "seg2cd";
    public static final String KAKOKAWASERATESHITEIFLG  = "kakokawaserateshiteiflg";
    public static final String KAKOKAWASERATESHITEIYMD  = "kakokawaserateshiteiymd";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String KEIYAKUTUUKAGK           = "keiyakutuukagk";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String DENGYOUMUCD              = "dengyoumucd";
    public static final String SYUSYOUHNCD              = "syusyouhncd";
    public static final String SYOUHNSDNO               = "syouhnsdno";
    public static final String KAWASETEKIYOKBN          = "kawasetekiyokbn";
    public static final String DENKARIKANJYONO          = "denkarikanjyono";
    public static final String TAISYAKUTYOUSEIFLG       = "taisyakutyouseiflg";
    public static final String DENSYORISYOUSAIKBN       = "densyorisyousaikbn";

    private final PKIT_KhDenpyoData primaryKey;

    public GenIT_KhDenpyoData() {
        primaryKey = new PKIT_KhDenpyoData();
    }

    public GenIT_KhDenpyoData(String pDenrenno, Integer pEdano) {
        primaryKey = new PKIT_KhDenpyoData(pDenrenno, pEdano);
    }

    @Transient
    @Override
    public PKIT_KhDenpyoData getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_KhDenpyoData> getMetaClass() {
        return QIT_KhDenpyoData.class;
    }

    @Id
    @Column(name=GenIT_KhDenpyoData.DENRENNO)
    public String getDenrenno() {
        return getPrimaryKey().getDenrenno();
    }

    public void setDenrenno(String pDenrenno) {
        getPrimaryKey().setDenrenno(pDenrenno);
    }

    @Id
    @Column(name=GenIT_KhDenpyoData.EDANO)
    public Integer getEdano() {
        return getPrimaryKey().getEdano();
    }

    public void setEdano(Integer pEdano) {
        getPrimaryKey().setEdano(pEdano);
    }

    private C_DensysKbn densyskbn;

    @Type(type="UserType_C_DensysKbn")
    @Column(name=GenIT_KhDenpyoData.DENSYSKBN)
    public C_DensysKbn getDensyskbn() {
        return densyskbn;
    }

    public void setDensyskbn(C_DensysKbn pDensyskbn) {
        densyskbn = pDensyskbn;
    }

    private String syono;

    @Column(name=GenIT_KhDenpyoData.SYONO)
    @SyoukenNo
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private String huridenatesakicd;

    @Column(name=GenIT_KhDenpyoData.HURIDENATESAKICD)
    public String getHuridenatesakicd() {
        return huridenatesakicd;
    }

    public void setHuridenatesakicd(String pHuridenatesakicd) {
        huridenatesakicd = pHuridenatesakicd;
    }

    private C_TantouCdKbn tantocd;

    @Type(type="UserType_C_TantouCdKbn")
    @Column(name=GenIT_KhDenpyoData.TANTOCD)
    public C_TantouCdKbn getTantocd() {
        return tantocd;
    }

    public void setTantocd(C_TantouCdKbn pTantocd) {
        tantocd = pTantocd;
    }

    private BizDate denymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhDenpyoData.DENYMD)
    public BizDate getDenymd() {
        return denymd;
    }

    public void setDenymd(BizDate pDenymd) {
        denymd = pDenymd;
    }

    private C_TaisyakuKbn taisyakukbn;

    @Type(type="UserType_C_TaisyakuKbn")
    @Column(name=GenIT_KhDenpyoData.TAISYAKUKBN)
    public C_TaisyakuKbn getTaisyakukbn() {
        return taisyakukbn;
    }

    public void setTaisyakukbn(C_TaisyakuKbn pTaisyakukbn) {
        taisyakukbn = pTaisyakukbn;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenIT_KhDenpyoData.KANJYOUKMKCD)
    public C_Kanjyoukmkcd getKanjyoukmkcd() {
        return kanjyoukmkcd;
    }

    public void setKanjyoukmkcd(C_Kanjyoukmkcd pKanjyoukmkcd) {
        kanjyoukmkcd = pKanjyoukmkcd;
    }

    private String suitoubumoncd;

    @Column(name=GenIT_KhDenpyoData.SUITOUBUMONCD)
    public String getSuitoubumoncd() {
        return suitoubumoncd;
    }

    public void setSuitoubumoncd(String pSuitoubumoncd) {
        suitoubumoncd = pSuitoubumoncd;
    }

    private C_Tuukasyu tuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_KhDenpyoData.TUUKASYU)
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
    @Column(name=GenIT_KhDenpyoData.DENKAWASERATE)
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

    private C_HuridensksKbn huridenskskbn;

    @Type(type="UserType_C_HuridensksKbn")
    @Column(name=GenIT_KhDenpyoData.HURIDENSKSKBN)
    public C_HuridensksKbn getHuridenskskbn() {
        return huridenskskbn;
    }

    public void setHuridenskskbn(C_HuridensksKbn pHuridenskskbn) {
        huridenskskbn = pHuridenskskbn;
    }

    private C_DenhnknhouKbn denhnknhoukbn;

    @Type(type="UserType_C_DenhnknhouKbn")
    @Column(name=GenIT_KhDenpyoData.DENHNKNHOUKBN)
    public C_DenhnknhouKbn getDenhnknhoukbn() {
        return denhnknhoukbn;
    }

    public void setDenhnknhoukbn(C_DenhnknhouKbn pDenhnknhoukbn) {
        denhnknhoukbn = pDenhnknhoukbn;
    }

    private C_DenshrhouKbn denshrhoukbn;

    @Type(type="UserType_C_DenshrhouKbn")
    @Column(name=GenIT_KhDenpyoData.DENSHRHOUKBN)
    public C_DenshrhouKbn getDenshrhoukbn() {
        return denshrhoukbn;
    }

    public void setDenshrhoukbn(C_DenshrhouKbn pDenshrhoukbn) {
        denshrhoukbn = pDenshrhoukbn;
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhDenpyoData.SYORIYMD)
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

    @Column(name=GenIT_KhDenpyoData.SYORICD)
    public String getSyoricd() {
        return syoricd;
    }

    public void setSyoricd(String pSyoricd) {
        syoricd = pSyoricd;
    }

    private String syorisosikicd;

    @Column(name=GenIT_KhDenpyoData.SYORISOSIKICD)
    public String getSyorisosikicd() {
        return syorisosikicd;
    }

    public void setSyorisosikicd(String pSyorisosikicd) {
        syorisosikicd = pSyorisosikicd;
    }

    private C_Segcd seg1cd;

    @Type(type="UserType_C_Segcd")
    @Column(name=GenIT_KhDenpyoData.SEG1CD)
    public C_Segcd getSeg1cd() {
        return seg1cd;
    }

    public void setSeg1cd(C_Segcd pSeg1cd) {
        seg1cd = pSeg1cd;
    }

    private C_Segcd seg2cd;

    @Type(type="UserType_C_Segcd")
    @Column(name=GenIT_KhDenpyoData.SEG2CD)
    public C_Segcd getSeg2cd() {
        return seg2cd;
    }

    public void setSeg2cd(C_Segcd pSeg2cd) {
        seg2cd = pSeg2cd;
    }

    private Boolean kakokawaserateshiteiflg;

    @Type(type="BooleanType")
    @Column(name=GenIT_KhDenpyoData.KAKOKAWASERATESHITEIFLG)
    public Boolean getKakokawaserateshiteiflg() {
        return kakokawaserateshiteiflg;
    }

    public void setKakokawaserateshiteiflg(Boolean pKakokawaserateshiteiflg) {
        kakokawaserateshiteiflg = pKakokawaserateshiteiflg;
    }

    private BizDate kakokawaserateshiteiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhDenpyoData.KAKOKAWASERATESHITEIYMD)
    @ValidDate
    public BizDate getKakokawaserateshiteiymd() {
        return kakokawaserateshiteiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKakokawaserateshiteiymd(BizDate pKakokawaserateshiteiymd) {
        kakokawaserateshiteiymd = pKakokawaserateshiteiymd;
    }

    private C_Tuukasyu kyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_KhDenpyoData.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private BizCurrency keiyakutuukagk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKeiyakutuukagk() {
        return keiyakutuukagk;
    }

    public void setKeiyakutuukagk(BizCurrency pKeiyakutuukagk) {
        keiyakutuukagk = pKeiyakutuukagk;
        keiyakutuukagkValue = null;
        keiyakutuukagkType  = null;
    }

    transient private BigDecimal keiyakutuukagkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KEIYAKUTUUKAGK, nullable=true)
    protected BigDecimal getKeiyakutuukagkValue() {
        if (keiyakutuukagkValue == null && keiyakutuukagk != null) {
            if (keiyakutuukagk.isOptional()) return null;
            return keiyakutuukagk.absolute();
        }
        return keiyakutuukagkValue;
    }

    protected void setKeiyakutuukagkValue(BigDecimal value) {
        keiyakutuukagkValue = value;
        keiyakutuukagk = Optional.fromNullable(toCurrencyType(keiyakutuukagkType))
            .transform(bizCurrencyTransformer(getKeiyakutuukagkValue()))
            .orNull();
    }

    transient private String keiyakutuukagkType = null;

    @Column(name=KEIYAKUTUUKAGK + "$", nullable=true)
    protected String getKeiyakutuukagkType() {
        if (keiyakutuukagkType == null && keiyakutuukagk != null) return keiyakutuukagk.getType().toString();
        if (keiyakutuukagkType == null && getKeiyakutuukagkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'keiyakutuukagk$' should not be NULL."));
        }
        return keiyakutuukagkType;
    }

    protected void setKeiyakutuukagkType(String type) {
        keiyakutuukagkType = type;
        keiyakutuukagk = Optional.fromNullable(toCurrencyType(keiyakutuukagkType))
            .transform(bizCurrencyTransformer(getKeiyakutuukagkValue()))
            .orNull();
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_KhDenpyoData.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_KhDenpyoData.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private String dengyoumucd;

    @Column(name=GenIT_KhDenpyoData.DENGYOUMUCD)
    public String getDengyoumucd() {
        return dengyoumucd;
    }

    public void setDengyoumucd(String pDengyoumucd) {
        dengyoumucd = pDengyoumucd;
    }

    private String syusyouhncd;

    @Column(name=GenIT_KhDenpyoData.SYUSYOUHNCD)
    public String getSyusyouhncd() {
        return syusyouhncd;
    }

    public void setSyusyouhncd(String pSyusyouhncd) {
        syusyouhncd = pSyusyouhncd;
    }

    private Integer syouhnsdno;

    @Column(name=GenIT_KhDenpyoData.SYOUHNSDNO)
    public Integer getSyouhnsdno() {
        return syouhnsdno;
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        syouhnsdno = pSyouhnsdno;
    }

    private C_KawasetekiyoKbn kawasetekiyokbn;

    @Type(type="UserType_C_KawasetekiyoKbn")
    @Column(name=GenIT_KhDenpyoData.KAWASETEKIYOKBN)
    public C_KawasetekiyoKbn getKawasetekiyokbn() {
        return kawasetekiyokbn;
    }

    public void setKawasetekiyokbn(C_KawasetekiyoKbn pKawasetekiyokbn) {
        kawasetekiyokbn = pKawasetekiyokbn;
    }

    private String denkarikanjyono;

    @Column(name=GenIT_KhDenpyoData.DENKARIKANJYONO)
    @Length(length=5)
    @Digit
    public String getDenkarikanjyono() {
        return denkarikanjyono;
    }

    public void setDenkarikanjyono(String pDenkarikanjyono) {
        denkarikanjyono = pDenkarikanjyono;
    }

    private Boolean taisyakutyouseiflg;

    @Type(type="BooleanType")
    @Column(name=GenIT_KhDenpyoData.TAISYAKUTYOUSEIFLG)
    public Boolean getTaisyakutyouseiflg() {
        return taisyakutyouseiflg;
    }

    public void setTaisyakutyouseiflg(Boolean pTaisyakutyouseiflg) {
        taisyakutyouseiflg = pTaisyakutyouseiflg;
    }

    private C_DenSyorisyousaiKbn densyorisyousaikbn;

    @Type(type="UserType_C_DenSyorisyousaiKbn")
    @Column(name=GenIT_KhDenpyoData.DENSYORISYOUSAIKBN)
    public C_DenSyorisyousaiKbn getDensyorisyousaikbn() {
        return densyorisyousaikbn;
    }

    public void setDensyorisyousaikbn(C_DenSyorisyousaiKbn pDensyorisyousaikbn) {
        densyorisyousaikbn = pDensyorisyousaikbn;
    }
}