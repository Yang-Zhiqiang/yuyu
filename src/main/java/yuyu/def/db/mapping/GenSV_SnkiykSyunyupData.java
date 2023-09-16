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
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.NaturalNumber;
import jp.co.slcs.swak.validation.constraints.Pattern;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.SV_SnkiykSyunyupData;
import yuyu.def.db.id.PKSV_SnkiykSyunyupData;
import yuyu.def.db.meta.GenQSV_SnkiykSyunyupData;
import yuyu.def.db.meta.QSV_SnkiykSyunyupData;
import yuyu.def.db.type.UserType_C_HaitouKbn;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_HknkknsmnKbn;
import yuyu.def.db.type.UserType_C_Sdpd;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_SeirituKbn;
import yuyu.def.db.type.UserType_C_SyutkKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 新契約収入P統計情報ビュー テーブルのマッピング情報クラスで、 {@link SV_SnkiykSyunyupData} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link SV_SnkiykSyunyupData}</td><td colspan="3">新契約収入P統計情報ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getRenno8keta renno8keta}</td><td>連番（８桁）</td><td align="center">{@link PKSV_SnkiykSyunyupData ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeiritukbn seiritukbn}</td><td>成立区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SeirituKbn}</td></tr>
 *  <tr><td>{@link #getSrsyoriymd srsyoriymd}</td><td>成立処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSeisekiym seisekiym}</td><td>成績計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getSkeikeijyouym skeikeijyouym}</td><td>新契約計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getSdpdkbn sdpdkbn}</td><td>Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Sdpd}</td></tr>
 *  <tr><td>{@link #getHaitoukbn haitoukbn}</td><td>配当区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HaitouKbn}</td></tr>
 *  <tr><td>{@link #getHyouteip hyouteip}</td><td>表定Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getFstphrkgk fstphrkgk}</td><td>初回Ｐ払込必要額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHhknseiymd hhknseiymd}</td><td>被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHhknnen hhknnen}</td><td>被保険者年齢</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHhknsei hhknsei}</td><td>被保険者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hhknsei}</td></tr>
 *  <tr><td>{@link #getKykseiymd kykseiymd}</td><td>契約者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKyknen kyknen}</td><td>契約者年齢</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRyouritusdno ryouritusdno}</td><td>料率世代番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyutkkbn syutkkbn}</td><td>主契約特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyutkKbn}</td></tr>
 *  <tr><td>{@link #getSeitoukihons seitoukihons}</td><td>正当基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyutkp syutkp}</td><td>主契約・特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHknkkn hknkkn}</td><td>保険期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHknkknsmnkbn hknkknsmnkbn}</td><td>保険期間歳満期区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HknkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDrtencd drtencd}</td><td>代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDaibosyuucd daibosyuucd}</td><td>代表募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtenkanrisosikicd drtenkanrisosikicd}</td><td>代理店管理組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHengakuumu hengakuumu}</td><td>変額保険有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSeg1cd seg1cd}</td><td>セグメント１コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 * </table>
 * @see     SV_SnkiykSyunyupData
 * @see     PKSV_SnkiykSyunyupData
 * @see     QSV_SnkiykSyunyupData
 * @see     GenQSV_SnkiykSyunyupData
 */
@MappedSuperclass
@Table(name=GenSV_SnkiykSyunyupData.TABLE_NAME)
@IdClass(value=PKSV_SnkiykSyunyupData.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_HaitouKbn", typeClass=UserType_C_HaitouKbn.class),
    @TypeDef(name="UserType_C_Hhknsei", typeClass=UserType_C_Hhknsei.class),
    @TypeDef(name="UserType_C_HknkknsmnKbn", typeClass=UserType_C_HknkknsmnKbn.class),
    @TypeDef(name="UserType_C_Sdpd", typeClass=UserType_C_Sdpd.class),
    @TypeDef(name="UserType_C_Segcd", typeClass=UserType_C_Segcd.class),
    @TypeDef(name="UserType_C_SeirituKbn", typeClass=UserType_C_SeirituKbn.class),
    @TypeDef(name="UserType_C_SyutkKbn", typeClass=UserType_C_SyutkKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenSV_SnkiykSyunyupData extends AbstractExDBEntity<SV_SnkiykSyunyupData, PKSV_SnkiykSyunyupData> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "SV_SnkiykSyunyupData";
    public static final String RENNO8KETA               = "renno8keta";
    public static final String MOSNO                    = "mosno";
    public static final String SYONO                    = "syono";
    public static final String SEIRITUKBN               = "seiritukbn";
    public static final String SRSYORIYMD               = "srsyoriymd";
    public static final String KYKYMD                   = "kykymd";
    public static final String SEISEKIYM                = "seisekiym";
    public static final String SKEIKEIJYOUYM            = "skeikeijyouym";
    public static final String SDPDKBN                  = "sdpdkbn";
    public static final String HAITOUKBN                = "haitoukbn";
    public static final String HYOUTEIP                 = "hyouteip";
    public static final String FSTPHRKGK                = "fstphrkgk";
    public static final String HHKNSEIYMD               = "hhknseiymd";
    public static final String HHKNNEN                  = "hhknnen";
    public static final String HHKNSEI                  = "hhknsei";
    public static final String KYKSEIYMD                = "kykseiymd";
    public static final String KYKNEN                   = "kyknen";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String RYOURITUSDNO             = "ryouritusdno";
    public static final String SYUTKKBN                 = "syutkkbn";
    public static final String SEITOUKIHONS             = "seitoukihons";
    public static final String SYUTKP                   = "syutkp";
    public static final String HKNKKN                   = "hknkkn";
    public static final String HKNKKNSMNKBN             = "hknkknsmnkbn";
    public static final String RENNO                    = "renno";
    public static final String DRTENCD                  = "drtencd";
    public static final String DAIBOSYUUCD              = "daibosyuucd";
    public static final String DRTENKANRISOSIKICD       = "drtenkanrisosikicd";
    public static final String HENGAKUUMU               = "hengakuumu";
    public static final String SEG1CD                   = "seg1cd";

    private final PKSV_SnkiykSyunyupData primaryKey;

    public GenSV_SnkiykSyunyupData() {
        primaryKey = new PKSV_SnkiykSyunyupData();
    }

    public GenSV_SnkiykSyunyupData(Integer pRenno8keta) {
        primaryKey = new PKSV_SnkiykSyunyupData(pRenno8keta);
    }

    @Transient
    @Override
    public PKSV_SnkiykSyunyupData getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QSV_SnkiykSyunyupData> getMetaClass() {
        return QSV_SnkiykSyunyupData.class;
    }

    @Id
    @Column(name=GenSV_SnkiykSyunyupData.RENNO8KETA)
    public Integer getRenno8keta() {
        return getPrimaryKey().getRenno8keta();
    }

    public void setRenno8keta(Integer pRenno8keta) {
        getPrimaryKey().setRenno8keta(pRenno8keta);
    }

    private String mosno;

    @Column(name=GenSV_SnkiykSyunyupData.MOSNO)
    @Pattern(message="{pattern.MousikomiNo.message}", regex="^[a-zA-Z0-9]{1,11}$")
    public String getMosno() {
        return mosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

    private String syono;

    @Column(name=GenSV_SnkiykSyunyupData.SYONO)
    @Pattern(message="{pattern.SyoukenNo.message}", regex="^[a-zA-Z0-9]{1,11}$")
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private C_SeirituKbn seiritukbn;

    @Type(type="UserType_C_SeirituKbn")
    @Column(name=GenSV_SnkiykSyunyupData.SEIRITUKBN)
    public C_SeirituKbn getSeiritukbn() {
        return seiritukbn;
    }

    public void setSeiritukbn(C_SeirituKbn pSeiritukbn) {
        seiritukbn = pSeiritukbn;
    }

    private BizDate srsyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_SnkiykSyunyupData.SRSYORIYMD)
    public BizDate getSrsyoriymd() {
        return srsyoriymd;
    }

    public void setSrsyoriymd(BizDate pSrsyoriymd) {
        srsyoriymd = pSrsyoriymd;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_SnkiykSyunyupData.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private BizDateYM seisekiym;

    @Type(type="BizDateYMType")
    @Column(name=GenSV_SnkiykSyunyupData.SEISEKIYM)
    public BizDateYM getSeisekiym() {
        return seisekiym;
    }

    @Trim("both")
    public void setSeisekiym(BizDateYM pSeisekiym) {
        seisekiym = pSeisekiym;
    }

    private BizDateYM skeikeijyouym;

    @Type(type="BizDateYMType")
    @Column(name=GenSV_SnkiykSyunyupData.SKEIKEIJYOUYM)
    public BizDateYM getSkeikeijyouym() {
        return skeikeijyouym;
    }

    @Trim("both")
    public void setSkeikeijyouym(BizDateYM pSkeikeijyouym) {
        skeikeijyouym = pSkeikeijyouym;
    }

    private C_Sdpd sdpdkbn;

    @Type(type="UserType_C_Sdpd")
    @Column(name=GenSV_SnkiykSyunyupData.SDPDKBN)
    public C_Sdpd getSdpdkbn() {
        return sdpdkbn;
    }

    public void setSdpdkbn(C_Sdpd pSdpdkbn) {
        sdpdkbn = pSdpdkbn;
    }

    private C_HaitouKbn haitoukbn;

    @Type(type="UserType_C_HaitouKbn")
    @Column(name=GenSV_SnkiykSyunyupData.HAITOUKBN)
    public C_HaitouKbn getHaitoukbn() {
        return haitoukbn;
    }

    public void setHaitoukbn(C_HaitouKbn pHaitoukbn) {
        haitoukbn = pHaitoukbn;
    }

    private BizCurrency hyouteip;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHyouteip() {
        return hyouteip;
    }

    public void setHyouteip(BizCurrency pHyouteip) {
        hyouteip = pHyouteip;
        hyouteipValue = null;
        hyouteipType  = null;
    }

    transient private BigDecimal hyouteipValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HYOUTEIP, nullable=true)
    protected BigDecimal getHyouteipValue() {
        if (hyouteipValue == null && hyouteip != null) {
            if (hyouteip.isOptional()) return null;
            return hyouteip.absolute();
        }
        return hyouteipValue;
    }

    protected void setHyouteipValue(BigDecimal value) {
        hyouteipValue = value;
        hyouteip = Optional.fromNullable(toCurrencyType(hyouteipType))
            .transform(bizCurrencyTransformer(getHyouteipValue()))
            .orNull();
    }

    transient private String hyouteipType = null;

    @Column(name=HYOUTEIP + "$", nullable=true)
    protected String getHyouteipType() {
        if (hyouteipType == null && hyouteip != null) return hyouteip.getType().toString();
        if (hyouteipType == null && getHyouteipValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hyouteip$' should not be NULL."));
        }
        return hyouteipType;
    }

    protected void setHyouteipType(String type) {
        hyouteipType = type;
        hyouteip = Optional.fromNullable(toCurrencyType(hyouteipType))
            .transform(bizCurrencyTransformer(getHyouteipValue()))
            .orNull();
    }

    private BizCurrency fstphrkgk;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    public BizCurrency getFstphrkgk() {
        return fstphrkgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setFstphrkgk(BizCurrency pFstphrkgk) {
        fstphrkgk = pFstphrkgk;
        fstphrkgkValue = null;
        fstphrkgkType  = null;
    }

    transient private BigDecimal fstphrkgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=FSTPHRKGK, nullable=true)
    protected BigDecimal getFstphrkgkValue() {
        if (fstphrkgkValue == null && fstphrkgk != null) {
            if (fstphrkgk.isOptional()) return null;
            return fstphrkgk.absolute();
        }
        return fstphrkgkValue;
    }

    protected void setFstphrkgkValue(BigDecimal value) {
        fstphrkgkValue = value;
        fstphrkgk = Optional.fromNullable(toCurrencyType(fstphrkgkType))
            .transform(bizCurrencyTransformer(getFstphrkgkValue()))
            .orNull();
    }

    transient private String fstphrkgkType = null;

    @Column(name=FSTPHRKGK + "$", nullable=true)
    protected String getFstphrkgkType() {
        if (fstphrkgkType == null && fstphrkgk != null) return fstphrkgk.getType().toString();
        if (fstphrkgkType == null && getFstphrkgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'fstphrkgk$' should not be NULL."));
        }
        return fstphrkgkType;
    }

    protected void setFstphrkgkType(String type) {
        fstphrkgkType = type;
        fstphrkgk = Optional.fromNullable(toCurrencyType(fstphrkgkType))
            .transform(bizCurrencyTransformer(getFstphrkgkValue()))
            .orNull();
    }

    private BizDate hhknseiymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_SnkiykSyunyupData.HHKNSEIYMD)
    @ValidDate
    public BizDate getHhknseiymd() {
        return hhknseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknseiymd(BizDate pHhknseiymd) {
        hhknseiymd = pHhknseiymd;
    }

    private Integer hhknnen;

    @Column(name=GenSV_SnkiykSyunyupData.HHKNNEN)
    @NaturalNumber
    public Integer getHhknnen() {
        return hhknnen;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknnen(Integer pHhknnen) {
        hhknnen = pHhknnen;
    }

    private C_Hhknsei hhknsei;

    @Type(type="UserType_C_Hhknsei")
    @Column(name=GenSV_SnkiykSyunyupData.HHKNSEI)
    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    private BizDate kykseiymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_SnkiykSyunyupData.KYKSEIYMD)
    @ValidDate
    public BizDate getKykseiymd() {
        return kykseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykseiymd(BizDate pKykseiymd) {
        kykseiymd = pKykseiymd;
    }

    private Integer kyknen;

    @Column(name=GenSV_SnkiykSyunyupData.KYKNEN)
    public Integer getKyknen() {
        return kyknen;
    }

    public void setKyknen(Integer pKyknen) {
        kyknen = pKyknen;
    }

    private String syouhncd;

    @Column(name=GenSV_SnkiykSyunyupData.SYOUHNCD)
    @MaxLength(max=4)
    @SingleByteStrings
    public String getSyouhncd() {
        return syouhncd;
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }

    private String ryouritusdno;

    @Column(name=GenSV_SnkiykSyunyupData.RYOURITUSDNO)
    public String getRyouritusdno() {
        return ryouritusdno;
    }

    public void setRyouritusdno(String pRyouritusdno) {
        ryouritusdno = pRyouritusdno;
    }

    private C_SyutkKbn syutkkbn;

    @Type(type="UserType_C_SyutkKbn")
    @Column(name=GenSV_SnkiykSyunyupData.SYUTKKBN)
    public C_SyutkKbn getSyutkkbn() {
        return syutkkbn;
    }

    public void setSyutkkbn(C_SyutkKbn pSyutkkbn) {
        syutkkbn = pSyutkkbn;
    }

    private BizCurrency seitoukihons;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSeitoukihons() {
        return seitoukihons;
    }

    public void setSeitoukihons(BizCurrency pSeitoukihons) {
        seitoukihons = pSeitoukihons;
        seitoukihonsValue = null;
        seitoukihonsType  = null;
    }

    transient private BigDecimal seitoukihonsValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SEITOUKIHONS, nullable=true)
    protected BigDecimal getSeitoukihonsValue() {
        if (seitoukihonsValue == null && seitoukihons != null) {
            if (seitoukihons.isOptional()) return null;
            return seitoukihons.absolute();
        }
        return seitoukihonsValue;
    }

    protected void setSeitoukihonsValue(BigDecimal value) {
        seitoukihonsValue = value;
        seitoukihons = Optional.fromNullable(toCurrencyType(seitoukihonsType))
            .transform(bizCurrencyTransformer(getSeitoukihonsValue()))
            .orNull();
    }

    transient private String seitoukihonsType = null;

    @Column(name=SEITOUKIHONS + "$", nullable=true)
    protected String getSeitoukihonsType() {
        if (seitoukihonsType == null && seitoukihons != null) return seitoukihons.getType().toString();
        if (seitoukihonsType == null && getSeitoukihonsValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'seitoukihons$' should not be NULL."));
        }
        return seitoukihonsType;
    }

    protected void setSeitoukihonsType(String type) {
        seitoukihonsType = type;
        seitoukihons = Optional.fromNullable(toCurrencyType(seitoukihonsType))
            .transform(bizCurrencyTransformer(getSeitoukihonsValue()))
            .orNull();
    }

    private BizCurrency syutkp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSyutkp() {
        return syutkp;
    }

    public void setSyutkp(BizCurrency pSyutkp) {
        syutkp = pSyutkp;
        syutkpValue = null;
        syutkpType  = null;
    }

    transient private BigDecimal syutkpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SYUTKP, nullable=true)
    protected BigDecimal getSyutkpValue() {
        if (syutkpValue == null && syutkp != null) {
            if (syutkp.isOptional()) return null;
            return syutkp.absolute();
        }
        return syutkpValue;
    }

    protected void setSyutkpValue(BigDecimal value) {
        syutkpValue = value;
        syutkp = Optional.fromNullable(toCurrencyType(syutkpType))
            .transform(bizCurrencyTransformer(getSyutkpValue()))
            .orNull();
    }

    transient private String syutkpType = null;

    @Column(name=SYUTKP + "$", nullable=true)
    protected String getSyutkpType() {
        if (syutkpType == null && syutkp != null) return syutkp.getType().toString();
        if (syutkpType == null && getSyutkpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'syutkp$' should not be NULL."));
        }
        return syutkpType;
    }

    protected void setSyutkpType(String type) {
        syutkpType = type;
        syutkp = Optional.fromNullable(toCurrencyType(syutkpType))
            .transform(bizCurrencyTransformer(getSyutkpValue()))
            .orNull();
    }

    private Integer hknkkn;

    @Column(name=GenSV_SnkiykSyunyupData.HKNKKN)
    @Range(min="0", max="99")
    public Integer getHknkkn() {
        return hknkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHknkkn(Integer pHknkkn) {
        hknkkn = pHknkkn;
    }

    private C_HknkknsmnKbn hknkknsmnkbn;

    @Type(type="UserType_C_HknkknsmnKbn")
    @Column(name=GenSV_SnkiykSyunyupData.HKNKKNSMNKBN)
    public C_HknkknsmnKbn getHknkknsmnkbn() {
        return hknkknsmnkbn;
    }

    public void setHknkknsmnkbn(C_HknkknsmnKbn pHknkknsmnkbn) {
        hknkknsmnkbn = pHknkknsmnkbn;
    }

    private Integer renno;

    @Column(name=GenSV_SnkiykSyunyupData.RENNO)
    public Integer getRenno() {
        return renno;
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

    private String drtencd;

    @Column(name=GenSV_SnkiykSyunyupData.DRTENCD)
    @MaxLength(max=7)
    @AlphaDigit
    public String getDrtencd() {
        return drtencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtencd(String pDrtencd) {
        drtencd = pDrtencd;
    }

    private String daibosyuucd;

    @Column(name=GenSV_SnkiykSyunyupData.DAIBOSYUUCD)
    public String getDaibosyuucd() {
        return daibosyuucd;
    }

    public void setDaibosyuucd(String pDaibosyuucd) {
        daibosyuucd = pDaibosyuucd;
    }

    private String drtenkanrisosikicd;

    @Column(name=GenSV_SnkiykSyunyupData.DRTENKANRISOSIKICD)
    public String getDrtenkanrisosikicd() {
        return drtenkanrisosikicd;
    }

    public void setDrtenkanrisosikicd(String pDrtenkanrisosikicd) {
        drtenkanrisosikicd = pDrtenkanrisosikicd;
    }

    private C_UmuKbn hengakuumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenSV_SnkiykSyunyupData.HENGAKUUMU)
    public C_UmuKbn getHengakuumu() {
        return hengakuumu;
    }

    public void setHengakuumu(C_UmuKbn pHengakuumu) {
        hengakuumu = pHengakuumu;
    }

    private C_Segcd seg1cd;

    @Type(type="UserType_C_Segcd")
    @Column(name=GenSV_SnkiykSyunyupData.SEG1CD)
    public C_Segcd getSeg1cd() {
        return seg1cd;
    }

    public void setSeg1cd(C_Segcd pSeg1cd) {
        seg1cd = pSeg1cd;
    }
}
