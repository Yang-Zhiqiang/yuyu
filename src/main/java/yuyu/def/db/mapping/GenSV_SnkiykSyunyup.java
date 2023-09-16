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
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.NaturalNumber;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_TumitatekinHaibunWariKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.SV_SnkiykSyunyup;
import yuyu.def.db.id.PKSV_SnkiykSyunyup;
import yuyu.def.db.meta.GenQSV_SnkiykSyunyup;
import yuyu.def.db.meta.QSV_SnkiykSyunyup;
import yuyu.def.db.type.UserType_C_HaitouKbn;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_KykKbn;
import yuyu.def.db.type.UserType_C_Sdpd;
import yuyu.def.db.type.UserType_C_SeirituKbn;
import yuyu.def.db.type.UserType_C_Sisuukbn;
import yuyu.def.db.type.UserType_C_TumitatekinHaibunWariKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 新契約収入Ｐ統計情報ビュー テーブルのマッピング情報クラスで、 {@link SV_SnkiykSyunyup} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link SV_SnkiykSyunyup}</td><td colspan="3">新契約収入Ｐ統計情報ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKSV_SnkiykSyunyup ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeiritukbn seiritukbn}</td><td>成立区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SeirituKbn}</td></tr>
 *  <tr><td>{@link #getSrsyoriymd srsyoriymd}</td><td>成立処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSeisekiym seisekiym}</td><td>成績計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getSkeikeijyouym skeikeijyouym}</td><td>新契約計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getKykkbn kykkbn}</td><td>契約者区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KykKbn}</td></tr>
 *  <tr><td>{@link #getSdpdkbn sdpdkbn}</td><td>Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Sdpd}</td></tr>
 *  <tr><td>{@link #getHaitoukbn haitoukbn}</td><td>配当区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HaitouKbn}</td></tr>
 *  <tr><td>{@link #getHyouteip hyouteip}</td><td>表定Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getHrktuukasyu hrktuukasyu}</td><td>払込通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getFstphrkgk fstphrkgk}</td><td>初回Ｐ払込必要額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHhknseiymd hhknseiymd}</td><td>被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHhknnen hhknnen}</td><td>被保険者年齢</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHhknsei hhknsei}</td><td>被保険者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hhknsei}</td></tr>
 *  <tr><td>{@link #getKykseiymd kykseiymd}</td><td>契約者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKyknen kyknen}</td><td>契約者年齢</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getHrkkeiro hrkkeiro}</td><td>払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkeiro}</td></tr>
 *  <tr><td>{@link #getHeijyunp heijyunp}</td><td>平準払Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZennoumousideumu zennoumousideumu}</td><td>前納申出有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getZennoujyuutoup zennoujyuutoup}</td><td>前納年払充当Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTratkiagcd tratkiagcd}</td><td>取扱代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDaibosyuucd daibosyuucd}</td><td>代表募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtenkanrisosikicd drtenkanrisosikicd}</td><td>代理店管理組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getInitsbjiyensitihsytkhukaumu initsbjiyensitihsytkhukaumu}</td><td>初期死亡時円換算最低保証特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getInitsbjiyenkasaiteihsygk initsbjiyenkasaiteihsygk}</td><td>初期死亡時円換算最低保証額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTeikishrtkykhukaumu teikishrtkykhukaumu}</td><td>定期支払特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSisuuhaibunwarikbn sisuuhaibunwarikbn}</td><td>指数部分配分割合区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TumitatekinHaibunWariKbn}</td></tr>
 *  <tr><td>{@link #getSisuukbn sisuukbn}</td><td>指数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Sisuukbn}</td></tr>
 *  <tr><td>{@link #getZennoukikan zennoukikan}</td><td>前納期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     SV_SnkiykSyunyup
 * @see     PKSV_SnkiykSyunyup
 * @see     QSV_SnkiykSyunyup
 * @see     GenQSV_SnkiykSyunyup
 */
@MappedSuperclass
@Table(name=GenSV_SnkiykSyunyup.TABLE_NAME)
@IdClass(value=PKSV_SnkiykSyunyup.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_HaitouKbn", typeClass=UserType_C_HaitouKbn.class),
    @TypeDef(name="UserType_C_Hhknsei", typeClass=UserType_C_Hhknsei.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_Hrkkeiro", typeClass=UserType_C_Hrkkeiro.class),
    @TypeDef(name="UserType_C_KykKbn", typeClass=UserType_C_KykKbn.class),
    @TypeDef(name="UserType_C_Sdpd", typeClass=UserType_C_Sdpd.class),
    @TypeDef(name="UserType_C_SeirituKbn", typeClass=UserType_C_SeirituKbn.class),
    @TypeDef(name="UserType_C_Sisuukbn", typeClass=UserType_C_Sisuukbn.class),
    @TypeDef(name="UserType_C_TumitatekinHaibunWariKbn", typeClass=UserType_C_TumitatekinHaibunWariKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenSV_SnkiykSyunyup extends AbstractExDBEntity<SV_SnkiykSyunyup, PKSV_SnkiykSyunyup> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "SV_SnkiykSyunyup";
    public static final String MOSNO                    = "mosno";
    public static final String SYONO                    = "syono";
    public static final String SEIRITUKBN               = "seiritukbn";
    public static final String SRSYORIYMD               = "srsyoriymd";
    public static final String KYKYMD                   = "kykymd";
    public static final String SEISEKIYM                = "seisekiym";
    public static final String SKEIKEIJYOUYM            = "skeikeijyouym";
    public static final String KYKKBN                   = "kykkbn";
    public static final String SDPDKBN                  = "sdpdkbn";
    public static final String HAITOUKBN                = "haitoukbn";
    public static final String HYOUTEIP                 = "hyouteip";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String HRKTUUKASYU              = "hrktuukasyu";
    public static final String FSTPHRKGK                = "fstphrkgk";
    public static final String HHKNSEIYMD               = "hhknseiymd";
    public static final String HHKNNEN                  = "hhknnen";
    public static final String HHKNSEI                  = "hhknsei";
    public static final String KYKSEIYMD                = "kykseiymd";
    public static final String KYKNEN                   = "kyknen";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String HRKKEIRO                 = "hrkkeiro";
    public static final String HEIJYUNP                 = "heijyunp";
    public static final String ZENNOUMOUSIDEUMU         = "zennoumousideumu";
    public static final String ZENNOUJYUUTOUP           = "zennoujyuutoup";
    public static final String TRATKIAGCD               = "tratkiagcd";
    public static final String DAIBOSYUUCD              = "daibosyuucd";
    public static final String DRTENKANRISOSIKICD       = "drtenkanrisosikicd";
    public static final String INITSBJIYENSITIHSYTKHUKAUMU = "initsbjiyensitihsytkhukaumu";
    public static final String INITSBJIYENKASAITEIHSYGK = "initsbjiyenkasaiteihsygk";
    public static final String TEIKISHRTKYKHUKAUMU      = "teikishrtkykhukaumu";
    public static final String SISUUHAIBUNWARIKBN       = "sisuuhaibunwarikbn";
    public static final String SISUUKBN                 = "sisuukbn";
    public static final String ZENNOUKIKAN              = "zennoukikan";

    private final PKSV_SnkiykSyunyup primaryKey;

    public GenSV_SnkiykSyunyup() {
        primaryKey = new PKSV_SnkiykSyunyup();
    }

    public GenSV_SnkiykSyunyup(String pMosno) {
        primaryKey = new PKSV_SnkiykSyunyup(pMosno);
    }

    @Transient
    @Override
    public PKSV_SnkiykSyunyup getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QSV_SnkiykSyunyup> getMetaClass() {
        return QSV_SnkiykSyunyup.class;
    }

    @Id
    @Column(name=GenSV_SnkiykSyunyup.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return getPrimaryKey().getMosno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        getPrimaryKey().setMosno(pMosno);
    }

    private String syono;

    @Column(name=GenSV_SnkiykSyunyup.SYONO)
    @SyoukenNo
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
    @Column(name=GenSV_SnkiykSyunyup.SEIRITUKBN)
    public C_SeirituKbn getSeiritukbn() {
        return seiritukbn;
    }

    public void setSeiritukbn(C_SeirituKbn pSeiritukbn) {
        seiritukbn = pSeiritukbn;
    }

    private BizDate srsyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_SnkiykSyunyup.SRSYORIYMD)
    public BizDate getSrsyoriymd() {
        return srsyoriymd;
    }

    public void setSrsyoriymd(BizDate pSrsyoriymd) {
        srsyoriymd = pSrsyoriymd;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_SnkiykSyunyup.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private BizDateYM seisekiym;

    @Type(type="BizDateYMType")
    @Column(name=GenSV_SnkiykSyunyup.SEISEKIYM)
    public BizDateYM getSeisekiym() {
        return seisekiym;
    }

    @Trim("both")
    public void setSeisekiym(BizDateYM pSeisekiym) {
        seisekiym = pSeisekiym;
    }

    private BizDateYM skeikeijyouym;

    @Type(type="BizDateYMType")
    @Column(name=GenSV_SnkiykSyunyup.SKEIKEIJYOUYM)
    public BizDateYM getSkeikeijyouym() {
        return skeikeijyouym;
    }

    @Trim("both")
    public void setSkeikeijyouym(BizDateYM pSkeikeijyouym) {
        skeikeijyouym = pSkeikeijyouym;
    }

    private C_KykKbn kykkbn;

    @Type(type="UserType_C_KykKbn")
    @Column(name=GenSV_SnkiykSyunyup.KYKKBN)
    public C_KykKbn getKykkbn() {
        return kykkbn;
    }

    public void setKykkbn(C_KykKbn pKykkbn) {
        kykkbn = pKykkbn;
    }

    private C_Sdpd sdpdkbn;

    @Type(type="UserType_C_Sdpd")
    @Column(name=GenSV_SnkiykSyunyup.SDPDKBN)
    public C_Sdpd getSdpdkbn() {
        return sdpdkbn;
    }

    public void setSdpdkbn(C_Sdpd pSdpdkbn) {
        sdpdkbn = pSdpdkbn;
    }

    private C_HaitouKbn haitoukbn;

    @Type(type="UserType_C_HaitouKbn")
    @Column(name=GenSV_SnkiykSyunyup.HAITOUKBN)
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

    private C_Tuukasyu kyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenSV_SnkiykSyunyup.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private C_Tuukasyu hrktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenSV_SnkiykSyunyup.HRKTUUKASYU)
    public C_Tuukasyu getHrktuukasyu() {
        return hrktuukasyu;
    }

    public void setHrktuukasyu(C_Tuukasyu pHrktuukasyu) {
        hrktuukasyu = pHrktuukasyu;
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
    @Column(name=GenSV_SnkiykSyunyup.HHKNSEIYMD)
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

    @Column(name=GenSV_SnkiykSyunyup.HHKNNEN)
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
    @Column(name=GenSV_SnkiykSyunyup.HHKNSEI)
    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    private BizDate kykseiymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_SnkiykSyunyup.KYKSEIYMD)
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

    @Column(name=GenSV_SnkiykSyunyup.KYKNEN)
    public Integer getKyknen() {
        return kyknen;
    }

    public void setKyknen(Integer pKyknen) {
        kyknen = pKyknen;
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenSV_SnkiykSyunyup.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private C_Hrkkeiro hrkkeiro;

    @Type(type="UserType_C_Hrkkeiro")
    @Column(name=GenSV_SnkiykSyunyup.HRKKEIRO)
    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }

    private BizCurrency heijyunp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHeijyunp() {
        return heijyunp;
    }

    public void setHeijyunp(BizCurrency pHeijyunp) {
        heijyunp = pHeijyunp;
        heijyunpValue = null;
        heijyunpType  = null;
    }

    transient private BigDecimal heijyunpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HEIJYUNP, nullable=true)
    protected BigDecimal getHeijyunpValue() {
        if (heijyunpValue == null && heijyunp != null) {
            if (heijyunp.isOptional()) return null;
            return heijyunp.absolute();
        }
        return heijyunpValue;
    }

    protected void setHeijyunpValue(BigDecimal value) {
        heijyunpValue = value;
        heijyunp = Optional.fromNullable(toCurrencyType(heijyunpType))
            .transform(bizCurrencyTransformer(getHeijyunpValue()))
            .orNull();
    }

    transient private String heijyunpType = null;

    @Column(name=HEIJYUNP + "$", nullable=true)
    protected String getHeijyunpType() {
        if (heijyunpType == null && heijyunp != null) return heijyunp.getType().toString();
        if (heijyunpType == null && getHeijyunpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'heijyunp$' should not be NULL."));
        }
        return heijyunpType;
    }

    protected void setHeijyunpType(String type) {
        heijyunpType = type;
        heijyunp = Optional.fromNullable(toCurrencyType(heijyunpType))
            .transform(bizCurrencyTransformer(getHeijyunpValue()))
            .orNull();
    }

    private C_UmuKbn zennoumousideumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenSV_SnkiykSyunyup.ZENNOUMOUSIDEUMU)
    public C_UmuKbn getZennoumousideumu() {
        return zennoumousideumu;
    }

    public void setZennoumousideumu(C_UmuKbn pZennoumousideumu) {
        zennoumousideumu = pZennoumousideumu;
    }

    private BizCurrency zennoujyuutoup;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZennoujyuutoup() {
        return zennoujyuutoup;
    }

    public void setZennoujyuutoup(BizCurrency pZennoujyuutoup) {
        zennoujyuutoup = pZennoujyuutoup;
        zennoujyuutoupValue = null;
        zennoujyuutoupType  = null;
    }

    transient private BigDecimal zennoujyuutoupValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZENNOUJYUUTOUP, nullable=true)
    protected BigDecimal getZennoujyuutoupValue() {
        if (zennoujyuutoupValue == null && zennoujyuutoup != null) {
            if (zennoujyuutoup.isOptional()) return null;
            return zennoujyuutoup.absolute();
        }
        return zennoujyuutoupValue;
    }

    protected void setZennoujyuutoupValue(BigDecimal value) {
        zennoujyuutoupValue = value;
        zennoujyuutoup = Optional.fromNullable(toCurrencyType(zennoujyuutoupType))
            .transform(bizCurrencyTransformer(getZennoujyuutoupValue()))
            .orNull();
    }

    transient private String zennoujyuutoupType = null;

    @Column(name=ZENNOUJYUUTOUP + "$", nullable=true)
    protected String getZennoujyuutoupType() {
        if (zennoujyuutoupType == null && zennoujyuutoup != null) return zennoujyuutoup.getType().toString();
        if (zennoujyuutoupType == null && getZennoujyuutoupValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'zennoujyuutoup$' should not be NULL."));
        }
        return zennoujyuutoupType;
    }

    protected void setZennoujyuutoupType(String type) {
        zennoujyuutoupType = type;
        zennoujyuutoup = Optional.fromNullable(toCurrencyType(zennoujyuutoupType))
            .transform(bizCurrencyTransformer(getZennoujyuutoupValue()))
            .orNull();
    }

    private String tratkiagcd;

    @Column(name=GenSV_SnkiykSyunyup.TRATKIAGCD)
    public String getTratkiagcd() {
        return tratkiagcd;
    }

    public void setTratkiagcd(String pTratkiagcd) {
        tratkiagcd = pTratkiagcd;
    }

    private String daibosyuucd;

    @Column(name=GenSV_SnkiykSyunyup.DAIBOSYUUCD)
    @HostInvalidCharacter
    public String getDaibosyuucd() {
        return daibosyuucd;
    }

    public void setDaibosyuucd(String pDaibosyuucd) {
        daibosyuucd = pDaibosyuucd;
    }

    private String drtenkanrisosikicd;

    @Column(name=GenSV_SnkiykSyunyup.DRTENKANRISOSIKICD)
    @HostInvalidCharacter
    public String getDrtenkanrisosikicd() {
        return drtenkanrisosikicd;
    }

    public void setDrtenkanrisosikicd(String pDrtenkanrisosikicd) {
        drtenkanrisosikicd = pDrtenkanrisosikicd;
    }

    private C_UmuKbn initsbjiyensitihsytkhukaumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenSV_SnkiykSyunyup.INITSBJIYENSITIHSYTKHUKAUMU)
    public C_UmuKbn getInitsbjiyensitihsytkhukaumu() {
        return initsbjiyensitihsytkhukaumu;
    }

    public void setInitsbjiyensitihsytkhukaumu(C_UmuKbn pInitsbjiyensitihsytkhukaumu) {
        initsbjiyensitihsytkhukaumu = pInitsbjiyensitihsytkhukaumu;
    }

    private BizCurrency initsbjiyenkasaiteihsygk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getInitsbjiyenkasaiteihsygk() {
        return initsbjiyenkasaiteihsygk;
    }

    public void setInitsbjiyenkasaiteihsygk(BizCurrency pInitsbjiyenkasaiteihsygk) {
        initsbjiyenkasaiteihsygk = pInitsbjiyenkasaiteihsygk;
        initsbjiyenkasaiteihsygkValue = null;
        initsbjiyenkasaiteihsygkType  = null;
    }

    transient private BigDecimal initsbjiyenkasaiteihsygkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=INITSBJIYENKASAITEIHSYGK, nullable=true)
    protected BigDecimal getInitsbjiyenkasaiteihsygkValue() {
        if (initsbjiyenkasaiteihsygkValue == null && initsbjiyenkasaiteihsygk != null) {
            if (initsbjiyenkasaiteihsygk.isOptional()) return null;
            return initsbjiyenkasaiteihsygk.absolute();
        }
        return initsbjiyenkasaiteihsygkValue;
    }

    protected void setInitsbjiyenkasaiteihsygkValue(BigDecimal value) {
        initsbjiyenkasaiteihsygkValue = value;
        initsbjiyenkasaiteihsygk = Optional.fromNullable(toCurrencyType(initsbjiyenkasaiteihsygkType))
            .transform(bizCurrencyTransformer(getInitsbjiyenkasaiteihsygkValue()))
            .orNull();
    }

    transient private String initsbjiyenkasaiteihsygkType = null;

    @Column(name=INITSBJIYENKASAITEIHSYGK + "$", nullable=true)
    protected String getInitsbjiyenkasaiteihsygkType() {
        if (initsbjiyenkasaiteihsygkType == null && initsbjiyenkasaiteihsygk != null) return initsbjiyenkasaiteihsygk.getType().toString();
        if (initsbjiyenkasaiteihsygkType == null && getInitsbjiyenkasaiteihsygkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'initsbjiyenkasaiteihsygk$' should not be NULL."));
        }
        return initsbjiyenkasaiteihsygkType;
    }

    protected void setInitsbjiyenkasaiteihsygkType(String type) {
        initsbjiyenkasaiteihsygkType = type;
        initsbjiyenkasaiteihsygk = Optional.fromNullable(toCurrencyType(initsbjiyenkasaiteihsygkType))
            .transform(bizCurrencyTransformer(getInitsbjiyenkasaiteihsygkValue()))
            .orNull();
    }

    private C_UmuKbn teikishrtkykhukaumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenSV_SnkiykSyunyup.TEIKISHRTKYKHUKAUMU)
    public C_UmuKbn getTeikishrtkykhukaumu() {
        return teikishrtkykhukaumu;
    }

    public void setTeikishrtkykhukaumu(C_UmuKbn pTeikishrtkykhukaumu) {
        teikishrtkykhukaumu = pTeikishrtkykhukaumu;
    }

    private C_TumitatekinHaibunWariKbn sisuuhaibunwarikbn;

    @Type(type="UserType_C_TumitatekinHaibunWariKbn")
    @Column(name=GenSV_SnkiykSyunyup.SISUUHAIBUNWARIKBN)
    public C_TumitatekinHaibunWariKbn getSisuuhaibunwarikbn() {
        return sisuuhaibunwarikbn;
    }

    public void setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn pSisuuhaibunwarikbn) {
        sisuuhaibunwarikbn = pSisuuhaibunwarikbn;
    }

    private C_Sisuukbn sisuukbn;

    @Type(type="UserType_C_Sisuukbn")
    @Column(name=GenSV_SnkiykSyunyup.SISUUKBN)
    public C_Sisuukbn getSisuukbn() {
        return sisuukbn;
    }

    public void setSisuukbn(C_Sisuukbn pSisuukbn) {
        sisuukbn = pSisuukbn;
    }

    private String zennoukikan;

    @Column(name=GenSV_SnkiykSyunyup.ZENNOUKIKAN)
    public String getZennoukikan() {
        return zennoukikan;
    }

    public void setZennoukikan(String pZennoukikan) {
        zennoukikan = pZennoukikan;
    }
}