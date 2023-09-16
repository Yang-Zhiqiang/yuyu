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
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.NaturalNumber;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_NenkinJimuTesuuryouKbn;
import yuyu.def.classification.C_NenkinKbn;
import yuyu.def.classification.C_NenkinKigouSedaiKbn;
import yuyu.def.classification.C_NkSyoumetuCd;
import yuyu.def.classification.C_Sznjk;
import yuyu.def.classification.C_UkehiDouKbn;
import yuyu.def.db.entity.SV_AlmNnknHyu;
import yuyu.def.db.id.PKSV_AlmNnknHyu;
import yuyu.def.db.meta.GenQSV_AlmNnknHyu;
import yuyu.def.db.meta.QSV_AlmNnknHyu;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_NenkinJimuTesuuryouKbn;
import yuyu.def.db.type.UserType_C_NenkinKbn;
import yuyu.def.db.type.UserType_C_NenkinKigouSedaiKbn;
import yuyu.def.db.type.UserType_C_NkSyoumetuCd;
import yuyu.def.db.type.UserType_C_Sznjk;
import yuyu.def.db.type.UserType_C_UkehiDouKbn;
import yuyu.infr.validation.constraints.NenkinSyousyoNo;

/**
 * ＡＬＭ用年金保有明細ビュー テーブルのマッピング情報クラスで、 {@link SV_AlmNnknHyu} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link SV_AlmNnknHyu}</td><td colspan="3">ＡＬＭ用年金保有明細ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getRenno8keta renno8keta}</td><td>連番（８桁）</td><td align="center">{@link PKSV_AlmNnknHyu ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSznjk sznjk}</td><td>生存状況</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Sznjk}</td></tr>
 *  <tr><td>{@link #getSeisikakymd seisikakymd}</td><td>生死確認日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNkkknsetymd nkkknsetymd}</td><td>年金基金設定日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDairitencd1 dairitencd1}</td><td>代理店コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtenkanritodoufukencd drtenkanritodoufukencd}</td><td>代理店管理都道府県コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTeikihongk teikihongk}</td><td>定額年金基本年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTeinkkikingk teinkkikingk}</td><td>定額年金年金基金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTeinkspan teinkspan}</td><td>定額年金年金期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTeinksyu teinksyu}</td><td>定額年金年金種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigoyoteiriritukbn nenkinkaisigoyoteiriritukbn}</td><td>年金開始後予定利率区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkigousedaikbn nenkinkigousedaikbn}</td><td>年金記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NenkinKigouSedaiKbn}</td></tr>
 *  <tr><td>{@link #getNenkinkbn nenkinkbn}</td><td>年金区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NenkinKbn}</td></tr>
 *  <tr><td>{@link #getNkshrstartymd nkshrstartymd}</td><td>年金支払開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNkkknmanryouymd nkkknmanryouymd}</td><td>年金期間満了日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNenkinjimutesuuryoukbn nenkinjimutesuuryoukbn}</td><td>年金事務手数料区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NenkinJimuTesuuryouKbn}</td></tr>
 *  <tr><td>{@link #getNksyoumetucd nksyoumetucd}</td><td>年金消滅コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NkSyoumetuCd}</td></tr>
 *  <tr><td>{@link #getSyoumetuymd syoumetuymd}</td><td>消滅日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNksysyno nksysyno}</td><td>年金証書番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBosyuucd1 bosyuucd1}</td><td>募集人コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknsei hhknsei}</td><td>被保険者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hhknsei}</td></tr>
 *  <tr><td>{@link #getHhknseiymd hhknseiymd}</td><td>被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHhknnen hhknnen}</td><td>被保険者年齢</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getUkehidouitukbn ukehidouitukbn}</td><td>受被同一区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UkehiDouKbn}</td></tr>
 *  <tr><td>{@link #getNkuktsakuinnmno nkuktsakuinnmno}</td><td>年金受取人索引名番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     SV_AlmNnknHyu
 * @see     PKSV_AlmNnknHyu
 * @see     QSV_AlmNnknHyu
 * @see     GenQSV_AlmNnknHyu
 */
@MappedSuperclass
@Table(name=GenSV_AlmNnknHyu.TABLE_NAME)
@IdClass(value=PKSV_AlmNnknHyu.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_Hhknsei", typeClass=UserType_C_Hhknsei.class),
    @TypeDef(name="UserType_C_NenkinJimuTesuuryouKbn", typeClass=UserType_C_NenkinJimuTesuuryouKbn.class),
    @TypeDef(name="UserType_C_NenkinKbn", typeClass=UserType_C_NenkinKbn.class),
    @TypeDef(name="UserType_C_NenkinKigouSedaiKbn", typeClass=UserType_C_NenkinKigouSedaiKbn.class),
    @TypeDef(name="UserType_C_NkSyoumetuCd", typeClass=UserType_C_NkSyoumetuCd.class),
    @TypeDef(name="UserType_C_Sznjk", typeClass=UserType_C_Sznjk.class),
    @TypeDef(name="UserType_C_UkehiDouKbn", typeClass=UserType_C_UkehiDouKbn.class)
})
public abstract class GenSV_AlmNnknHyu extends AbstractExDBEntity<SV_AlmNnknHyu, PKSV_AlmNnknHyu> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "SV_AlmNnknHyu";
    public static final String RENNO8KETA               = "renno8keta";
    public static final String SZNJK                    = "sznjk";
    public static final String SEISIKAKYMD              = "seisikakymd";
    public static final String NKKKNSETYMD              = "nkkknsetymd";
    public static final String KYKYMD                   = "kykymd";
    public static final String DAIRITENCD1              = "dairitencd1";
    public static final String DRTENKANRITODOUFUKENCD   = "drtenkanritodoufukencd";
    public static final String TEIKIHONGK               = "teikihongk";
    public static final String TEINKKIKINGK             = "teinkkikingk";
    public static final String TEINKSPAN                = "teinkspan";
    public static final String TEINKSYU                 = "teinksyu";
    public static final String NENKINKAISIGOYOTEIRIRITUKBN = "nenkinkaisigoyoteiriritukbn";
    public static final String NENKINKIGOUSEDAIKBN      = "nenkinkigousedaikbn";
    public static final String NENKINKBN                = "nenkinkbn";
    public static final String NKSHRSTARTYMD            = "nkshrstartymd";
    public static final String NKKKNMANRYOUYMD          = "nkkknmanryouymd";
    public static final String NENKINJIMUTESUURYOUKBN   = "nenkinjimutesuuryoukbn";
    public static final String NKSYOUMETUCD             = "nksyoumetucd";
    public static final String SYOUMETUYMD              = "syoumetuymd";
    public static final String NKSYSYNO                 = "nksysyno";
    public static final String BOSYUUCD1                = "bosyuucd1";
    public static final String HHKNSEI                  = "hhknsei";
    public static final String HHKNSEIYMD               = "hhknseiymd";
    public static final String HHKNNEN                  = "hhknnen";
    public static final String UKEHIDOUITUKBN           = "ukehidouitukbn";
    public static final String NKUKTSAKUINNMNO          = "nkuktsakuinnmno";

    private final PKSV_AlmNnknHyu primaryKey;

    public GenSV_AlmNnknHyu() {
        primaryKey = new PKSV_AlmNnknHyu();
    }

    public GenSV_AlmNnknHyu(Integer pRenno8keta) {
        primaryKey = new PKSV_AlmNnknHyu(pRenno8keta);
    }

    @Transient
    @Override
    public PKSV_AlmNnknHyu getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QSV_AlmNnknHyu> getMetaClass() {
        return QSV_AlmNnknHyu.class;
    }

    @Id
    @Column(name=GenSV_AlmNnknHyu.RENNO8KETA)
    public Integer getRenno8keta() {
        return getPrimaryKey().getRenno8keta();
    }

    public void setRenno8keta(Integer pRenno8keta) {
        getPrimaryKey().setRenno8keta(pRenno8keta);
    }

    private C_Sznjk sznjk;

    @Type(type="UserType_C_Sznjk")
    @Column(name=GenSV_AlmNnknHyu.SZNJK)
    public C_Sznjk getSznjk() {
        return sznjk;
    }

    public void setSznjk(C_Sznjk pSznjk) {
        sznjk = pSznjk;
    }

    private BizDate seisikakymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_AlmNnknHyu.SEISIKAKYMD)
    @ValidDate
    public BizDate getSeisikakymd() {
        return seisikakymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSeisikakymd(BizDate pSeisikakymd) {
        seisikakymd = pSeisikakymd;
    }

    private BizDate nkkknsetymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_AlmNnknHyu.NKKKNSETYMD)
    @ValidDate
    public BizDate getNkkknsetymd() {
        return nkkknsetymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNkkknsetymd(BizDate pNkkknsetymd) {
        nkkknsetymd = pNkkknsetymd;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_AlmNnknHyu.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private String dairitencd1;

    @Column(name=GenSV_AlmNnknHyu.DAIRITENCD1)
    @MaxLength(max=7)
    @AlphaDigit
    public String getDairitencd1() {
        return dairitencd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitencd1(String pDairitencd1) {
        dairitencd1 = pDairitencd1;
    }

    private String drtenkanritodoufukencd;

    @Column(name=GenSV_AlmNnknHyu.DRTENKANRITODOUFUKENCD)
    public String getDrtenkanritodoufukencd() {
        return drtenkanritodoufukencd;
    }

    public void setDrtenkanritodoufukencd(String pDrtenkanritodoufukencd) {
        drtenkanritodoufukencd = pDrtenkanritodoufukencd;
    }

    private BizCurrency teikihongk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTeikihongk() {
        return teikihongk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTeikihongk(BizCurrency pTeikihongk) {
        teikihongk = pTeikihongk;
        teikihongkValue = null;
        teikihongkType  = null;
    }

    transient private BigDecimal teikihongkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TEIKIHONGK, nullable=true)
    protected BigDecimal getTeikihongkValue() {
        if (teikihongkValue == null && teikihongk != null) {
            if (teikihongk.isOptional()) return null;
            return teikihongk.absolute();
        }
        return teikihongkValue;
    }

    protected void setTeikihongkValue(BigDecimal value) {
        teikihongkValue = value;
        teikihongk = Optional.fromNullable(toCurrencyType(teikihongkType))
            .transform(bizCurrencyTransformer(getTeikihongkValue()))
            .orNull();
    }

    transient private String teikihongkType = null;

    @Column(name=TEIKIHONGK + "$", nullable=true)
    protected String getTeikihongkType() {
        if (teikihongkType == null && teikihongk != null) return teikihongk.getType().toString();
        if (teikihongkType == null && getTeikihongkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'teikihongk$' should not be NULL."));
        }
        return teikihongkType;
    }

    protected void setTeikihongkType(String type) {
        teikihongkType = type;
        teikihongk = Optional.fromNullable(toCurrencyType(teikihongkType))
            .transform(bizCurrencyTransformer(getTeikihongkValue()))
            .orNull();
    }

    private BizCurrency teinkkikingk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTeinkkikingk() {
        return teinkkikingk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTeinkkikingk(BizCurrency pTeinkkikingk) {
        teinkkikingk = pTeinkkikingk;
        teinkkikingkValue = null;
        teinkkikingkType  = null;
    }

    transient private BigDecimal teinkkikingkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TEINKKIKINGK, nullable=true)
    protected BigDecimal getTeinkkikingkValue() {
        if (teinkkikingkValue == null && teinkkikingk != null) {
            if (teinkkikingk.isOptional()) return null;
            return teinkkikingk.absolute();
        }
        return teinkkikingkValue;
    }

    protected void setTeinkkikingkValue(BigDecimal value) {
        teinkkikingkValue = value;
        teinkkikingk = Optional.fromNullable(toCurrencyType(teinkkikingkType))
            .transform(bizCurrencyTransformer(getTeinkkikingkValue()))
            .orNull();
    }

    transient private String teinkkikingkType = null;

    @Column(name=TEINKKIKINGK + "$", nullable=true)
    protected String getTeinkkikingkType() {
        if (teinkkikingkType == null && teinkkikingk != null) return teinkkikingk.getType().toString();
        if (teinkkikingkType == null && getTeinkkikingkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'teinkkikingk$' should not be NULL."));
        }
        return teinkkikingkType;
    }

    protected void setTeinkkikingkType(String type) {
        teinkkikingkType = type;
        teinkkikingk = Optional.fromNullable(toCurrencyType(teinkkikingkType))
            .transform(bizCurrencyTransformer(getTeinkkikingkValue()))
            .orNull();
    }

    private String teinkspan;

    @Column(name=GenSV_AlmNnknHyu.TEINKSPAN)
    public String getTeinkspan() {
        return teinkspan;
    }

    public void setTeinkspan(String pTeinkspan) {
        teinkspan = pTeinkspan;
    }

    private String teinksyu;

    @Column(name=GenSV_AlmNnknHyu.TEINKSYU)
    public String getTeinksyu() {
        return teinksyu;
    }

    public void setTeinksyu(String pTeinksyu) {
        teinksyu = pTeinksyu;
    }

    private String nenkinkaisigoyoteiriritukbn;

    @Column(name=GenSV_AlmNnknHyu.NENKINKAISIGOYOTEIRIRITUKBN)
    public String getNenkinkaisigoyoteiriritukbn() {
        return nenkinkaisigoyoteiriritukbn;
    }

    public void setNenkinkaisigoyoteiriritukbn(String pNenkinkaisigoyoteiriritukbn) {
        nenkinkaisigoyoteiriritukbn = pNenkinkaisigoyoteiriritukbn;
    }

    private C_NenkinKigouSedaiKbn nenkinkigousedaikbn;

    @Type(type="UserType_C_NenkinKigouSedaiKbn")
    @Column(name=GenSV_AlmNnknHyu.NENKINKIGOUSEDAIKBN)
    public C_NenkinKigouSedaiKbn getNenkinkigousedaikbn() {
        return nenkinkigousedaikbn;
    }

    public void setNenkinkigousedaikbn(C_NenkinKigouSedaiKbn pNenkinkigousedaikbn) {
        nenkinkigousedaikbn = pNenkinkigousedaikbn;
    }

    private C_NenkinKbn nenkinkbn;

    @Type(type="UserType_C_NenkinKbn")
    @Column(name=GenSV_AlmNnknHyu.NENKINKBN)
    public C_NenkinKbn getNenkinkbn() {
        return nenkinkbn;
    }

    public void setNenkinkbn(C_NenkinKbn pNenkinkbn) {
        nenkinkbn = pNenkinkbn;
    }

    private BizDate nkshrstartymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_AlmNnknHyu.NKSHRSTARTYMD)
    public BizDate getNkshrstartymd() {
        return nkshrstartymd;
    }

    @Trim("both")
    public void setNkshrstartymd(BizDate pNkshrstartymd) {
        nkshrstartymd = pNkshrstartymd;
    }

    private BizDate nkkknmanryouymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_AlmNnknHyu.NKKKNMANRYOUYMD)
    public BizDate getNkkknmanryouymd() {
        return nkkknmanryouymd;
    }

    public void setNkkknmanryouymd(BizDate pNkkknmanryouymd) {
        nkkknmanryouymd = pNkkknmanryouymd;
    }

    private C_NenkinJimuTesuuryouKbn nenkinjimutesuuryoukbn;

    @Type(type="UserType_C_NenkinJimuTesuuryouKbn")
    @Column(name=GenSV_AlmNnknHyu.NENKINJIMUTESUURYOUKBN)
    public C_NenkinJimuTesuuryouKbn getNenkinjimutesuuryoukbn() {
        return nenkinjimutesuuryoukbn;
    }

    public void setNenkinjimutesuuryoukbn(C_NenkinJimuTesuuryouKbn pNenkinjimutesuuryoukbn) {
        nenkinjimutesuuryoukbn = pNenkinjimutesuuryoukbn;
    }

    private C_NkSyoumetuCd nksyoumetucd;

    @Type(type="UserType_C_NkSyoumetuCd")
    @Column(name=GenSV_AlmNnknHyu.NKSYOUMETUCD)
    public C_NkSyoumetuCd getNksyoumetucd() {
        return nksyoumetucd;
    }

    public void setNksyoumetucd(C_NkSyoumetuCd pNksyoumetucd) {
        nksyoumetucd = pNksyoumetucd;
    }

    private BizDate syoumetuymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_AlmNnknHyu.SYOUMETUYMD)
    public BizDate getSyoumetuymd() {
        return syoumetuymd;
    }

    @Trim("both")
    public void setSyoumetuymd(BizDate pSyoumetuymd) {
        syoumetuymd = pSyoumetuymd;
    }

    private String nksysyno;

    @Column(name=GenSV_AlmNnknHyu.NKSYSYNO)
    @NenkinSyousyoNo
    public String getNksysyno() {
        return nksysyno;
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setNksysyno(String pNksysyno) {
        nksysyno = pNksysyno;
    }

    private String bosyuucd1;

    @Column(name=GenSV_AlmNnknHyu.BOSYUUCD1)
    @MaxLength(max=6)
    @AlphaDigit
    public String getBosyuucd1() {
        return bosyuucd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuucd1(String pBosyuucd1) {
        bosyuucd1 = pBosyuucd1;
    }

    private C_Hhknsei hhknsei;

    @Type(type="UserType_C_Hhknsei")
    @Column(name=GenSV_AlmNnknHyu.HHKNSEI)
    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    private BizDate hhknseiymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_AlmNnknHyu.HHKNSEIYMD)
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

    @Column(name=GenSV_AlmNnknHyu.HHKNNEN)
    @NaturalNumber
    public Integer getHhknnen() {
        return hhknnen;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknnen(Integer pHhknnen) {
        hhknnen = pHhknnen;
    }

    private C_UkehiDouKbn ukehidouitukbn;

    @Type(type="UserType_C_UkehiDouKbn")
    @Column(name=GenSV_AlmNnknHyu.UKEHIDOUITUKBN)
    public C_UkehiDouKbn getUkehidouitukbn() {
        return ukehidouitukbn;
    }

    public void setUkehidouitukbn(C_UkehiDouKbn pUkehidouitukbn) {
        ukehidouitukbn = pUkehidouitukbn;
    }

    private String nkuktsakuinnmno;

    @Column(name=GenSV_AlmNnknHyu.NKUKTSAKUINNMNO)
    @MaxLength(max=10)
    @SingleByteStrings
    public String getNkuktsakuinnmno() {
        return nkuktsakuinnmno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNkuktsakuinnmno(String pNkuktsakuinnmno) {
        nkuktsakuinnmno = pNkuktsakuinnmno;
    }
}
