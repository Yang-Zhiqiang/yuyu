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
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.SV_HoyuuMeisai;
import yuyu.def.db.id.PKSV_HoyuuMeisai;
import yuyu.def.db.meta.GenQSV_HoyuuMeisai;
import yuyu.def.db.meta.QSV_HoyuuMeisai;
import yuyu.def.db.type.UserType_C_HaitoukinuketorihouKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_Ketkekkacd;
import yuyu.def.db.type.UserType_C_Sdpd;
import yuyu.def.db.type.UserType_C_Tdk;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 保有明細情報ビュー テーブルのマッピング情報クラスで、 {@link SV_HoyuuMeisai} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link SV_HoyuuMeisai}</td><td colspan="3">保有明細情報ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKSV_HoyuuMeisai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSdpdkbn sdpdkbn}</td><td>Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Sdpd}</td></tr>
 *  <tr><td>{@link #getHrkp hrkp}</td><td>払込保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getBosyuuym bosyuuym}</td><td>募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getSkeikeijyouym skeikeijyouym}</td><td>新契約計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getHhknsykgycd hhknsykgycd}</td><td>被保険者職業コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtenkanritodoufukencd drtenkanritodoufukencd}</td><td>代理店管理都道府県コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCifcd cifcd}</td><td>ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getFstpnyknymd fstpnyknymd}</td><td>初回保険料入金日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getHrkkeiro hrkkeiro}</td><td>払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkeiro}</td></tr>
 *  <tr><td>{@link #getHaitoukinuketorihoukbn haitoukinuketorihoukbn}</td><td>配当金受取方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HaitoukinuketorihouKbn}</td></tr>
 *  <tr><td>{@link #getTikiktbrisyuruikbn tikiktbrisyuruikbn}</td><td>定期一括払種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TkiktbrisyuruiKbn}</td></tr>
 *  <tr><td>{@link #getDrtencd drtencd}</td><td>代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtenkanrisosikicd drtenkanrisosikicd}</td><td>代理店管理組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDaibosyuucd daibosyuucd}</td><td>代表募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtenbunumu drtenbunumu}</td><td>代理店分担有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKyksakuinmeino kyksakuinmeino}</td><td>契約者索引名番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKkkyktdk kkkyktdk}</td><td>契約管理契約者続柄</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tdk}</td></tr>
 *  <tr><td>{@link #getKykseiymd kykseiymd}</td><td>契約者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKetkekkacd ketkekkacd}</td><td>決定結果コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Ketkekkacd}</td></tr>
 *  <tr><td>{@link #getPalketsyacd palketsyacd}</td><td>ＰＡＬ決定者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStdrsktkyhkumu stdrsktkyhkumu}</td><td>被保険者代理特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getStdrsktkyhkymd stdrsktkyhkymd}</td><td>被保険者代理特約付加日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getYenshrtkhkumu yenshrtkhkumu}</td><td>円支払特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getInitsbjiyensitihsytkhukaumu initsbjiyensitihsytkhukaumu}</td><td>初期死亡時円換算最低保証特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getInitsbjiyenkasaiteihsygk initsbjiyenkasaiteihsygk}</td><td>初期死亡時円換算最低保証額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getJyudkaigomeharaitkhukaumu jyudkaigomeharaitkhukaumu}</td><td>重度介護前払特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTargettkhkumu targettkhkumu}</td><td>ターゲット特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTargettkykkykhenkoymd targettkykkykhenkoymd}</td><td>ターゲット特約契約変更日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTargettkmokuhyouti targettkmokuhyouti}</td><td>ターゲット特約目標値</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTargettkykkijyungk targettkykkijyungk}</td><td>ターゲット特約基準金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKykdrtkykhukaumu kykdrtkykhukaumu}</td><td>契約者代理特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKykdrtkykhukaymd kykdrtkykhukaymd}</td><td>契約者代理特約付加日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykdrtkykkaiyakuymd kykdrtkykkaiyakuymd}</td><td>契約者代理特約解約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTeikishrtkykhukaumu teikishrtkykhukaumu}</td><td>定期支払特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getYendthnkymd yendthnkymd}</td><td>円建変更日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getJkipjytym jkipjytym}</td><td>次回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getZennoukaisiymd zennoukaisiymd}</td><td>前納開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getZennoukikan zennoukikan}</td><td>前納期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     SV_HoyuuMeisai
 * @see     PKSV_HoyuuMeisai
 * @see     QSV_HoyuuMeisai
 * @see     GenQSV_HoyuuMeisai
 */
@MappedSuperclass
@Table(name=GenSV_HoyuuMeisai.TABLE_NAME)
@IdClass(value=PKSV_HoyuuMeisai.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_HaitoukinuketorihouKbn", typeClass=UserType_C_HaitoukinuketorihouKbn.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_Hrkkeiro", typeClass=UserType_C_Hrkkeiro.class),
    @TypeDef(name="UserType_C_Ketkekkacd", typeClass=UserType_C_Ketkekkacd.class),
    @TypeDef(name="UserType_C_Sdpd", typeClass=UserType_C_Sdpd.class),
    @TypeDef(name="UserType_C_Tdk", typeClass=UserType_C_Tdk.class),
    @TypeDef(name="UserType_C_TkiktbrisyuruiKbn", typeClass=UserType_C_TkiktbrisyuruiKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenSV_HoyuuMeisai extends AbstractExDBEntity<SV_HoyuuMeisai, PKSV_HoyuuMeisai> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "SV_HoyuuMeisai";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String SDPDKBN                  = "sdpdkbn";
    public static final String HRKP                     = "hrkp";
    public static final String BOSYUUYM                 = "bosyuuym";
    public static final String SKEIKEIJYOUYM            = "skeikeijyouym";
    public static final String HHKNSYKGYCD              = "hhknsykgycd";
    public static final String DRTENKANRITODOUFUKENCD   = "drtenkanritodoufukencd";
    public static final String CIFCD                    = "cifcd";
    public static final String FSTPNYKNYMD              = "fstpnyknymd";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String HRKKEIRO                 = "hrkkeiro";
    public static final String HAITOUKINUKETORIHOUKBN   = "haitoukinuketorihoukbn";
    public static final String TIKIKTBRISYURUIKBN       = "tikiktbrisyuruikbn";
    public static final String DRTENCD                  = "drtencd";
    public static final String DRTENKANRISOSIKICD       = "drtenkanrisosikicd";
    public static final String DAIBOSYUUCD              = "daibosyuucd";
    public static final String DRTENBUNUMU              = "drtenbunumu";
    public static final String KYKSAKUINMEINO           = "kyksakuinmeino";
    public static final String KKKYKTDK                 = "kkkyktdk";
    public static final String KYKSEIYMD                = "kykseiymd";
    public static final String KETKEKKACD               = "ketkekkacd";
    public static final String PALKETSYACD              = "palketsyacd";
    public static final String STDRSKTKYHKUMU           = "stdrsktkyhkumu";
    public static final String STDRSKTKYHKYMD           = "stdrsktkyhkymd";
    public static final String YENSHRTKHKUMU            = "yenshrtkhkumu";
    public static final String INITSBJIYENSITIHSYTKHUKAUMU = "initsbjiyensitihsytkhukaumu";
    public static final String INITSBJIYENKASAITEIHSYGK = "initsbjiyenkasaiteihsygk";
    public static final String JYUDKAIGOMEHARAITKHUKAUMU = "jyudkaigomeharaitkhukaumu";
    public static final String TARGETTKHKUMU            = "targettkhkumu";
    public static final String TARGETTKYKKYKHENKOYMD    = "targettkykkykhenkoymd";
    public static final String TARGETTKMOKUHYOUTI       = "targettkmokuhyouti";
    public static final String TARGETTKYKKIJYUNGK       = "targettkykkijyungk";
    public static final String KYKDRTKYKHUKAUMU         = "kykdrtkykhukaumu";
    public static final String KYKDRTKYKHUKAYMD         = "kykdrtkykhukaymd";
    public static final String KYKDRTKYKKAIYAKUYMD      = "kykdrtkykkaiyakuymd";
    public static final String TEIKISHRTKYKHUKAUMU      = "teikishrtkykhukaumu";
    public static final String YENDTHNKYMD              = "yendthnkymd";
    public static final String JKIPJYTYM                = "jkipjytym";
    public static final String ZENNOUKAISIYMD           = "zennoukaisiymd";
    public static final String ZENNOUKIKAN              = "zennoukikan";

    private final PKSV_HoyuuMeisai primaryKey;

    public GenSV_HoyuuMeisai() {
        primaryKey = new PKSV_HoyuuMeisai();
    }

    public GenSV_HoyuuMeisai(String pSyono) {
        primaryKey = new PKSV_HoyuuMeisai(pSyono);
    }

    @Transient
    @Override
    public PKSV_HoyuuMeisai getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QSV_HoyuuMeisai> getMetaClass() {
        return QSV_HoyuuMeisai.class;
    }

    private String kbnkey;

    @Column(name=GenSV_HoyuuMeisai.KBNKEY)
    public String getKbnkey() {
        return kbnkey;
    }

    public void setKbnkey(String pKbnkey) {
        kbnkey = pKbnkey;
    }

    @Id
    @Column(name=GenSV_HoyuuMeisai.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    private C_Sdpd sdpdkbn;

    @Type(type="UserType_C_Sdpd")
    @Column(name=GenSV_HoyuuMeisai.SDPDKBN)
    public C_Sdpd getSdpdkbn() {
        return sdpdkbn;
    }

    public void setSdpdkbn(C_Sdpd pSdpdkbn) {
        sdpdkbn = pSdpdkbn;
    }

    private BizCurrency hrkp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHrkp() {
        return hrkp;
    }

    public void setHrkp(BizCurrency pHrkp) {
        hrkp = pHrkp;
        hrkpValue = null;
        hrkpType  = null;
    }

    transient private BigDecimal hrkpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HRKP, nullable=true)
    protected BigDecimal getHrkpValue() {
        if (hrkpValue == null && hrkp != null) {
            if (hrkp.isOptional()) return null;
            return hrkp.absolute();
        }
        return hrkpValue;
    }

    protected void setHrkpValue(BigDecimal value) {
        hrkpValue = value;
        hrkp = Optional.fromNullable(toCurrencyType(hrkpType))
            .transform(bizCurrencyTransformer(getHrkpValue()))
            .orNull();
    }

    transient private String hrkpType = null;

    @Column(name=HRKP + "$", nullable=true)
    protected String getHrkpType() {
        if (hrkpType == null && hrkp != null) return hrkp.getType().toString();
        if (hrkpType == null && getHrkpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hrkp$' should not be NULL."));
        }
        return hrkpType;
    }

    protected void setHrkpType(String type) {
        hrkpType = type;
        hrkp = Optional.fromNullable(toCurrencyType(hrkpType))
            .transform(bizCurrencyTransformer(getHrkpValue()))
            .orNull();
    }

    private BizDateYM bosyuuym;

    @Type(type="BizDateYMType")
    @Column(name=GenSV_HoyuuMeisai.BOSYUUYM)
    @ValidDateYm
    public BizDateYM getBosyuuym() {
        return bosyuuym;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuuym(BizDateYM pBosyuuym) {
        bosyuuym = pBosyuuym;
    }

    private BizDateYM skeikeijyouym;

    @Type(type="BizDateYMType")
    @Column(name=GenSV_HoyuuMeisai.SKEIKEIJYOUYM)
    public BizDateYM getSkeikeijyouym() {
        return skeikeijyouym;
    }

    @Trim("both")
    public void setSkeikeijyouym(BizDateYM pSkeikeijyouym) {
        skeikeijyouym = pSkeikeijyouym;
    }

    private String hhknsykgycd;

    @Column(name=GenSV_HoyuuMeisai.HHKNSYKGYCD)
    @MaxLength(max=3)
    @AlphaDigit
    @HostInvalidCharacter
    public String getHhknsykgycd() {
        return hhknsykgycd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknsykgycd(String pHhknsykgycd) {
        hhknsykgycd = pHhknsykgycd;
    }

    private String drtenkanritodoufukencd;

    @Column(name=GenSV_HoyuuMeisai.DRTENKANRITODOUFUKENCD)
    public String getDrtenkanritodoufukencd() {
        return drtenkanritodoufukencd;
    }

    public void setDrtenkanritodoufukencd(String pDrtenkanritodoufukencd) {
        drtenkanritodoufukencd = pDrtenkanritodoufukencd;
    }

    private String cifcd;

    @Column(name=GenSV_HoyuuMeisai.CIFCD)
    @MaxLength(max=15)
    @AlphaDigit
    @HostInvalidCharacter
    public String getCifcd() {
        return cifcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCifcd(String pCifcd) {
        cifcd = pCifcd;
    }

    private BizDate fstpnyknymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_HoyuuMeisai.FSTPNYKNYMD)
    public BizDate getFstpnyknymd() {
        return fstpnyknymd;
    }

    public void setFstpnyknymd(BizDate pFstpnyknymd) {
        fstpnyknymd = pFstpnyknymd;
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenSV_HoyuuMeisai.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private C_Hrkkeiro hrkkeiro;

    @Type(type="UserType_C_Hrkkeiro")
    @Column(name=GenSV_HoyuuMeisai.HRKKEIRO)
    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }

    private C_HaitoukinuketorihouKbn haitoukinuketorihoukbn;

    @Type(type="UserType_C_HaitoukinuketorihouKbn")
    @Column(name=GenSV_HoyuuMeisai.HAITOUKINUKETORIHOUKBN)
    public C_HaitoukinuketorihouKbn getHaitoukinuketorihoukbn() {
        return haitoukinuketorihoukbn;
    }

    public void setHaitoukinuketorihoukbn(C_HaitoukinuketorihouKbn pHaitoukinuketorihoukbn) {
        haitoukinuketorihoukbn = pHaitoukinuketorihoukbn;
    }

    private C_TkiktbrisyuruiKbn tikiktbrisyuruikbn;

    @Type(type="UserType_C_TkiktbrisyuruiKbn")
    @Column(name=GenSV_HoyuuMeisai.TIKIKTBRISYURUIKBN)
    public C_TkiktbrisyuruiKbn getTikiktbrisyuruikbn() {
        return tikiktbrisyuruikbn;
    }

    public void setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn) {
        tikiktbrisyuruikbn = pTikiktbrisyuruikbn;
    }

    private String drtencd;

    @Column(name=GenSV_HoyuuMeisai.DRTENCD)
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

    private String drtenkanrisosikicd;

    @Column(name=GenSV_HoyuuMeisai.DRTENKANRISOSIKICD)
    @HostInvalidCharacter
    public String getDrtenkanrisosikicd() {
        return drtenkanrisosikicd;
    }

    public void setDrtenkanrisosikicd(String pDrtenkanrisosikicd) {
        drtenkanrisosikicd = pDrtenkanrisosikicd;
    }

    private String daibosyuucd;

    @Column(name=GenSV_HoyuuMeisai.DAIBOSYUUCD)
    @HostInvalidCharacter
    public String getDaibosyuucd() {
        return daibosyuucd;
    }

    public void setDaibosyuucd(String pDaibosyuucd) {
        daibosyuucd = pDaibosyuucd;
    }

    private C_UmuKbn drtenbunumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenSV_HoyuuMeisai.DRTENBUNUMU)
    public C_UmuKbn getDrtenbunumu() {
        return drtenbunumu;
    }

    public void setDrtenbunumu(C_UmuKbn pDrtenbunumu) {
        drtenbunumu = pDrtenbunumu;
    }

    private String kyksakuinmeino;

    @Column(name=GenSV_HoyuuMeisai.KYKSAKUINMEINO)
    public String getKyksakuinmeino() {
        return kyksakuinmeino;
    }

    public void setKyksakuinmeino(String pKyksakuinmeino) {
        kyksakuinmeino = pKyksakuinmeino;
    }

    private C_Tdk kkkyktdk;

    @Type(type="UserType_C_Tdk")
    @Column(name=GenSV_HoyuuMeisai.KKKYKTDK)
    public C_Tdk getKkkyktdk() {
        return kkkyktdk;
    }

    public void setKkkyktdk(C_Tdk pKkkyktdk) {
        kkkyktdk = pKkkyktdk;
    }

    private BizDate kykseiymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_HoyuuMeisai.KYKSEIYMD)
    @ValidDate
    public BizDate getKykseiymd() {
        return kykseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykseiymd(BizDate pKykseiymd) {
        kykseiymd = pKykseiymd;
    }

    private C_Ketkekkacd ketkekkacd;

    @Type(type="UserType_C_Ketkekkacd")
    @Column(name=GenSV_HoyuuMeisai.KETKEKKACD)
    public C_Ketkekkacd getKetkekkacd() {
        return ketkekkacd;
    }

    public void setKetkekkacd(C_Ketkekkacd pKetkekkacd) {
        ketkekkacd = pKetkekkacd;
    }

    private String palketsyacd;

    @Column(name=GenSV_HoyuuMeisai.PALKETSYACD)
    @Length(length=2)
    @SingleByteStrings
    @Digit
    @HostInvalidCharacter
    public String getPalketsyacd() {
        return palketsyacd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setPalketsyacd(String pPalketsyacd) {
        palketsyacd = pPalketsyacd;
    }

    private C_UmuKbn stdrsktkyhkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenSV_HoyuuMeisai.STDRSKTKYHKUMU)
    public C_UmuKbn getStdrsktkyhkumu() {
        return stdrsktkyhkumu;
    }

    public void setStdrsktkyhkumu(C_UmuKbn pStdrsktkyhkumu) {
        stdrsktkyhkumu = pStdrsktkyhkumu;
    }

    private BizDate stdrsktkyhkymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_HoyuuMeisai.STDRSKTKYHKYMD)
    public BizDate getStdrsktkyhkymd() {
        return stdrsktkyhkymd;
    }

    @Trim("both")
    public void setStdrsktkyhkymd(BizDate pStdrsktkyhkymd) {
        stdrsktkyhkymd = pStdrsktkyhkymd;
    }

    private C_UmuKbn yenshrtkhkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenSV_HoyuuMeisai.YENSHRTKHKUMU)
    public C_UmuKbn getYenshrtkhkumu() {
        return yenshrtkhkumu;
    }

    public void setYenshrtkhkumu(C_UmuKbn pYenshrtkhkumu) {
        yenshrtkhkumu = pYenshrtkhkumu;
    }

    private C_UmuKbn initsbjiyensitihsytkhukaumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenSV_HoyuuMeisai.INITSBJIYENSITIHSYTKHUKAUMU)
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

    private C_UmuKbn jyudkaigomeharaitkhukaumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenSV_HoyuuMeisai.JYUDKAIGOMEHARAITKHUKAUMU)
    public C_UmuKbn getJyudkaigomeharaitkhukaumu() {
        return jyudkaigomeharaitkhukaumu;
    }

    public void setJyudkaigomeharaitkhukaumu(C_UmuKbn pJyudkaigomeharaitkhukaumu) {
        jyudkaigomeharaitkhukaumu = pJyudkaigomeharaitkhukaumu;
    }

    private C_UmuKbn targettkhkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenSV_HoyuuMeisai.TARGETTKHKUMU)
    public C_UmuKbn getTargettkhkumu() {
        return targettkhkumu;
    }

    public void setTargettkhkumu(C_UmuKbn pTargettkhkumu) {
        targettkhkumu = pTargettkhkumu;
    }

    private BizDate targettkykkykhenkoymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_HoyuuMeisai.TARGETTKYKKYKHENKOYMD)
    @ValidDate
    public BizDate getTargettkykkykhenkoymd() {
        return targettkykkykhenkoymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTargettkykkykhenkoymd(BizDate pTargettkykkykhenkoymd) {
        targettkykkykhenkoymd = pTargettkykkykhenkoymd;
    }

    private Integer targettkmokuhyouti;

    @Column(name=GenSV_HoyuuMeisai.TARGETTKMOKUHYOUTI)
    public Integer getTargettkmokuhyouti() {
        return targettkmokuhyouti;
    }

    public void setTargettkmokuhyouti(Integer pTargettkmokuhyouti) {
        targettkmokuhyouti = pTargettkmokuhyouti;
    }

    private BizCurrency targettkykkijyungk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTargettkykkijyungk() {
        return targettkykkijyungk;
    }

    public void setTargettkykkijyungk(BizCurrency pTargettkykkijyungk) {
        targettkykkijyungk = pTargettkykkijyungk;
        targettkykkijyungkValue = null;
        targettkykkijyungkType  = null;
    }

    transient private BigDecimal targettkykkijyungkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TARGETTKYKKIJYUNGK, nullable=true)
    protected BigDecimal getTargettkykkijyungkValue() {
        if (targettkykkijyungkValue == null && targettkykkijyungk != null) {
            if (targettkykkijyungk.isOptional()) return null;
            return targettkykkijyungk.absolute();
        }
        return targettkykkijyungkValue;
    }

    protected void setTargettkykkijyungkValue(BigDecimal value) {
        targettkykkijyungkValue = value;
        targettkykkijyungk = Optional.fromNullable(toCurrencyType(targettkykkijyungkType))
            .transform(bizCurrencyTransformer(getTargettkykkijyungkValue()))
            .orNull();
    }

    transient private String targettkykkijyungkType = null;

    @Column(name=TARGETTKYKKIJYUNGK + "$", nullable=true)
    protected String getTargettkykkijyungkType() {
        if (targettkykkijyungkType == null && targettkykkijyungk != null) return targettkykkijyungk.getType().toString();
        if (targettkykkijyungkType == null && getTargettkykkijyungkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'targettkykkijyungk$' should not be NULL."));
        }
        return targettkykkijyungkType;
    }

    protected void setTargettkykkijyungkType(String type) {
        targettkykkijyungkType = type;
        targettkykkijyungk = Optional.fromNullable(toCurrencyType(targettkykkijyungkType))
            .transform(bizCurrencyTransformer(getTargettkykkijyungkValue()))
            .orNull();
    }

    private C_UmuKbn kykdrtkykhukaumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenSV_HoyuuMeisai.KYKDRTKYKHUKAUMU)
    public C_UmuKbn getKykdrtkykhukaumu() {
        return kykdrtkykhukaumu;
    }

    public void setKykdrtkykhukaumu(C_UmuKbn pKykdrtkykhukaumu) {
        kykdrtkykhukaumu = pKykdrtkykhukaumu;
    }

    private BizDate kykdrtkykhukaymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_HoyuuMeisai.KYKDRTKYKHUKAYMD)
    @ValidDate
    public BizDate getKykdrtkykhukaymd() {
        return kykdrtkykhukaymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykdrtkykhukaymd(BizDate pKykdrtkykhukaymd) {
        kykdrtkykhukaymd = pKykdrtkykhukaymd;
    }

    private BizDate kykdrtkykkaiyakuymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_HoyuuMeisai.KYKDRTKYKKAIYAKUYMD)
    @ValidDate
    public BizDate getKykdrtkykkaiyakuymd() {
        return kykdrtkykkaiyakuymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykdrtkykkaiyakuymd(BizDate pKykdrtkykkaiyakuymd) {
        kykdrtkykkaiyakuymd = pKykdrtkykkaiyakuymd;
    }

    private C_UmuKbn teikishrtkykhukaumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenSV_HoyuuMeisai.TEIKISHRTKYKHUKAUMU)
    public C_UmuKbn getTeikishrtkykhukaumu() {
        return teikishrtkykhukaumu;
    }

    public void setTeikishrtkykhukaumu(C_UmuKbn pTeikishrtkykhukaumu) {
        teikishrtkykhukaumu = pTeikishrtkykhukaumu;
    }

    private BizDate yendthnkymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_HoyuuMeisai.YENDTHNKYMD)
    public BizDate getYendthnkymd() {
        return yendthnkymd;
    }

    public void setYendthnkymd(BizDate pYendthnkymd) {
        yendthnkymd = pYendthnkymd;
    }

    private BizDateYM jkipjytym;

    @Type(type="BizDateYMType")
    @Column(name=GenSV_HoyuuMeisai.JKIPJYTYM)
    public BizDateYM getJkipjytym() {
        return jkipjytym;
    }

    @Trim("both")
    public void setJkipjytym(BizDateYM pJkipjytym) {
        jkipjytym = pJkipjytym;
    }

    private BizDate zennoukaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_HoyuuMeisai.ZENNOUKAISIYMD)
    public BizDate getZennoukaisiymd() {
        return zennoukaisiymd;
    }

    public void setZennoukaisiymd(BizDate pZennoukaisiymd) {
        zennoukaisiymd = pZennoukaisiymd;
    }

    private String zennoukikan;

    @Column(name=GenSV_HoyuuMeisai.ZENNOUKIKAN)
    public String getZennoukikan() {
        return zennoukikan;
    }

    public void setZennoukikan(String pZennoukikan) {
        zennoukikan = pZennoukikan;
    }
}