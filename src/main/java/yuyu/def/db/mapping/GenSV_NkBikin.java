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
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.NaturalNumber;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Bnshrkaisuu;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_NenkinJimuTesuuryouKbn;
import yuyu.def.classification.C_NenkinKbn;
import yuyu.def.classification.C_NenkinKigouSedaiKbn;
import yuyu.def.classification.C_NkSyoumetuCd;
import yuyu.def.classification.C_Nkshrhsijiyuu;
import yuyu.def.classification.C_TyuuitratkiKbn;
import yuyu.def.db.entity.SV_NkBikin;
import yuyu.def.db.id.PKSV_NkBikin;
import yuyu.def.db.meta.GenQSV_NkBikin;
import yuyu.def.db.meta.QSV_NkBikin;
import yuyu.def.db.type.UserType_C_Bnshrkaisuu;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_NenkinJimuTesuuryouKbn;
import yuyu.def.db.type.UserType_C_NenkinKbn;
import yuyu.def.db.type.UserType_C_NenkinKigouSedaiKbn;
import yuyu.def.db.type.UserType_C_NkSyoumetuCd;
import yuyu.def.db.type.UserType_C_Nkshrhsijiyuu;
import yuyu.def.db.type.UserType_C_TyuuitratkiKbn;
import yuyu.infr.validation.constraints.NenkinSyousyoNo;

/**
 * 年金備金ビュー テーブルのマッピング情報クラスで、 {@link SV_NkBikin} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link SV_NkBikin}</td><td colspan="3">年金備金ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getRenno8keta renno8keta}</td><td>連番（８桁）</td><td align="center">{@link PKSV_NkBikin ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSeisikakymd seisikakymd}</td><td>生死確認日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNkkknsetymd nkkknsetymd}</td><td>年金基金設定日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNextnsymd nextnsymd}</td><td>次回年金支払日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoumetuymd syoumetuymd}</td><td>消滅日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDairitencd1 dairitencd1}</td><td>代理店コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTeikihongk teikihongk}</td><td>定額年金基本年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTeinkspan teinkspan}</td><td>定額年金年金期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTeinksyu teinksyu}</td><td>定額年金年金種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinjimutesuuryoukbn nenkinjimutesuuryoukbn}</td><td>年金事務手数料区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NenkinJimuTesuuryouKbn}</td></tr>
 *  <tr><td>{@link #getNenkinkaisigoyoteiriritukbn nenkinkaisigoyoteiriritukbn}</td><td>年金開始後予定利率区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkigousedaikbn nenkinkigousedaikbn}</td><td>年金記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NenkinKigouSedaiKbn}</td></tr>
 *  <tr><td>{@link #getNenkinkbn nenkinkbn}</td><td>年金区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NenkinKbn}</td></tr>
 *  <tr><td>{@link #getNkshrstartymd nkshrstartymd}</td><td>年金支払開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNkkknmanryouymd nkkknmanryouymd}</td><td>年金期間満了日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNkshrhsijiyuu nkshrhsijiyuu}</td><td>年金支払発生事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Nkshrhsijiyuu}</td></tr>
 *  <tr><td>{@link #getNksyoumetucd nksyoumetucd}</td><td>年金消滅コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NkSyoumetuCd}</td></tr>
 *  <tr><td>{@link #getNksysyno nksysyno}</td><td>年金証書番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBnshrkaisuu bnshrkaisuu}</td><td>分割支払回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Bnshrkaisuu}</td></tr>
 *  <tr><td>{@link #getTyuuitratkikbn tyuuitratkikbn}</td><td>注意取扱区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TyuuitratkiKbn}</td></tr>
 *  <tr><td>{@link #getHhknsei hhknsei}</td><td>被保険者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hhknsei}</td></tr>
 *  <tr><td>{@link #getHhknseiymd hhknseiymd}</td><td>被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHhknnen hhknnen}</td><td>被保険者年齢</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getShrymd shrymd}</td><td>支払日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTsinyno tsinyno}</td><td>通信先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     SV_NkBikin
 * @see     PKSV_NkBikin
 * @see     QSV_NkBikin
 * @see     GenQSV_NkBikin
 */
@MappedSuperclass
@Table(name=GenSV_NkBikin.TABLE_NAME)
@IdClass(value=PKSV_NkBikin.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_Bnshrkaisuu", typeClass=UserType_C_Bnshrkaisuu.class),
    @TypeDef(name="UserType_C_Hhknsei", typeClass=UserType_C_Hhknsei.class),
    @TypeDef(name="UserType_C_NenkinJimuTesuuryouKbn", typeClass=UserType_C_NenkinJimuTesuuryouKbn.class),
    @TypeDef(name="UserType_C_NenkinKbn", typeClass=UserType_C_NenkinKbn.class),
    @TypeDef(name="UserType_C_NenkinKigouSedaiKbn", typeClass=UserType_C_NenkinKigouSedaiKbn.class),
    @TypeDef(name="UserType_C_NkSyoumetuCd", typeClass=UserType_C_NkSyoumetuCd.class),
    @TypeDef(name="UserType_C_Nkshrhsijiyuu", typeClass=UserType_C_Nkshrhsijiyuu.class),
    @TypeDef(name="UserType_C_TyuuitratkiKbn", typeClass=UserType_C_TyuuitratkiKbn.class)
})
public abstract class GenSV_NkBikin extends AbstractExDBEntity<SV_NkBikin, PKSV_NkBikin> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "SV_NkBikin";
    public static final String RENNO8KETA               = "renno8keta";
    public static final String SEISIKAKYMD              = "seisikakymd";
    public static final String NKKKNSETYMD              = "nkkknsetymd";
    public static final String KYKYMD                   = "kykymd";
    public static final String NEXTNSYMD                = "nextnsymd";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYOUMETUYMD              = "syoumetuymd";
    public static final String DAIRITENCD1              = "dairitencd1";
    public static final String TEIKIHONGK               = "teikihongk";
    public static final String TEINKSPAN                = "teinkspan";
    public static final String TEINKSYU                 = "teinksyu";
    public static final String NENKINJIMUTESUURYOUKBN   = "nenkinjimutesuuryoukbn";
    public static final String NENKINKAISIGOYOTEIRIRITUKBN = "nenkinkaisigoyoteiriritukbn";
    public static final String NENKINKIGOUSEDAIKBN      = "nenkinkigousedaikbn";
    public static final String NENKINKBN                = "nenkinkbn";
    public static final String NKSHRSTARTYMD            = "nkshrstartymd";
    public static final String NKKKNMANRYOUYMD          = "nkkknmanryouymd";
    public static final String NKSHRHSIJIYUU            = "nkshrhsijiyuu";
    public static final String NKSYOUMETUCD             = "nksyoumetucd";
    public static final String NKSYSYNO                 = "nksysyno";
    public static final String BNSHRKAISUU              = "bnshrkaisuu";
    public static final String TYUUITRATKIKBN           = "tyuuitratkikbn";
    public static final String HHKNSEI                  = "hhknsei";
    public static final String HHKNSEIYMD               = "hhknseiymd";
    public static final String HHKNNEN                  = "hhknnen";
    public static final String SHRYMD                   = "shrymd";
    public static final String TSINYNO                  = "tsinyno";

    private final PKSV_NkBikin primaryKey;

    public GenSV_NkBikin() {
        primaryKey = new PKSV_NkBikin();
    }

    public GenSV_NkBikin(Integer pRenno8keta) {
        primaryKey = new PKSV_NkBikin(pRenno8keta);
    }

    @Transient
    @Override
    public PKSV_NkBikin getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QSV_NkBikin> getMetaClass() {
        return QSV_NkBikin.class;
    }

    @Id
    @Column(name=GenSV_NkBikin.RENNO8KETA)
    public Integer getRenno8keta() {
        return getPrimaryKey().getRenno8keta();
    }

    public void setRenno8keta(Integer pRenno8keta) {
        getPrimaryKey().setRenno8keta(pRenno8keta);
    }

    private BizDate seisikakymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_NkBikin.SEISIKAKYMD)
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
    @Column(name=GenSV_NkBikin.NKKKNSETYMD)
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
    @Column(name=GenSV_NkBikin.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private BizDate nextnsymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_NkBikin.NEXTNSYMD)
    @ValidDate
    public BizDate getNextnsymd() {
        return nextnsymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNextnsymd(BizDate pNextnsymd) {
        nextnsymd = pNextnsymd;
    }

    private String syouhncd;

    @Column(name=GenSV_NkBikin.SYOUHNCD)
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

    private BizDate syoumetuymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_NkBikin.SYOUMETUYMD)
    public BizDate getSyoumetuymd() {
        return syoumetuymd;
    }

    @Trim("both")
    public void setSyoumetuymd(BizDate pSyoumetuymd) {
        syoumetuymd = pSyoumetuymd;
    }

    private String dairitencd1;

    @Column(name=GenSV_NkBikin.DAIRITENCD1)
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

    private String teinkspan;

    @Column(name=GenSV_NkBikin.TEINKSPAN)
    public String getTeinkspan() {
        return teinkspan;
    }

    public void setTeinkspan(String pTeinkspan) {
        teinkspan = pTeinkspan;
    }

    private String teinksyu;

    @Column(name=GenSV_NkBikin.TEINKSYU)
    public String getTeinksyu() {
        return teinksyu;
    }

    public void setTeinksyu(String pTeinksyu) {
        teinksyu = pTeinksyu;
    }

    private C_NenkinJimuTesuuryouKbn nenkinjimutesuuryoukbn;

    @Type(type="UserType_C_NenkinJimuTesuuryouKbn")
    @Column(name=GenSV_NkBikin.NENKINJIMUTESUURYOUKBN)
    public C_NenkinJimuTesuuryouKbn getNenkinjimutesuuryoukbn() {
        return nenkinjimutesuuryoukbn;
    }

    public void setNenkinjimutesuuryoukbn(C_NenkinJimuTesuuryouKbn pNenkinjimutesuuryoukbn) {
        nenkinjimutesuuryoukbn = pNenkinjimutesuuryoukbn;
    }

    private String nenkinkaisigoyoteiriritukbn;

    @Column(name=GenSV_NkBikin.NENKINKAISIGOYOTEIRIRITUKBN)
    public String getNenkinkaisigoyoteiriritukbn() {
        return nenkinkaisigoyoteiriritukbn;
    }

    public void setNenkinkaisigoyoteiriritukbn(String pNenkinkaisigoyoteiriritukbn) {
        nenkinkaisigoyoteiriritukbn = pNenkinkaisigoyoteiriritukbn;
    }

    private C_NenkinKigouSedaiKbn nenkinkigousedaikbn;

    @Type(type="UserType_C_NenkinKigouSedaiKbn")
    @Column(name=GenSV_NkBikin.NENKINKIGOUSEDAIKBN)
    public C_NenkinKigouSedaiKbn getNenkinkigousedaikbn() {
        return nenkinkigousedaikbn;
    }

    public void setNenkinkigousedaikbn(C_NenkinKigouSedaiKbn pNenkinkigousedaikbn) {
        nenkinkigousedaikbn = pNenkinkigousedaikbn;
    }

    private C_NenkinKbn nenkinkbn;

    @Type(type="UserType_C_NenkinKbn")
    @Column(name=GenSV_NkBikin.NENKINKBN)
    public C_NenkinKbn getNenkinkbn() {
        return nenkinkbn;
    }

    public void setNenkinkbn(C_NenkinKbn pNenkinkbn) {
        nenkinkbn = pNenkinkbn;
    }

    private BizDate nkshrstartymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_NkBikin.NKSHRSTARTYMD)
    public BizDate getNkshrstartymd() {
        return nkshrstartymd;
    }

    @Trim("both")
    public void setNkshrstartymd(BizDate pNkshrstartymd) {
        nkshrstartymd = pNkshrstartymd;
    }

    private BizDate nkkknmanryouymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_NkBikin.NKKKNMANRYOUYMD)
    public BizDate getNkkknmanryouymd() {
        return nkkknmanryouymd;
    }

    public void setNkkknmanryouymd(BizDate pNkkknmanryouymd) {
        nkkknmanryouymd = pNkkknmanryouymd;
    }

    private C_Nkshrhsijiyuu nkshrhsijiyuu;

    @Type(type="UserType_C_Nkshrhsijiyuu")
    @Column(name=GenSV_NkBikin.NKSHRHSIJIYUU)
    public C_Nkshrhsijiyuu getNkshrhsijiyuu() {
        return nkshrhsijiyuu;
    }

    public void setNkshrhsijiyuu(C_Nkshrhsijiyuu pNkshrhsijiyuu) {
        nkshrhsijiyuu = pNkshrhsijiyuu;
    }

    private C_NkSyoumetuCd nksyoumetucd;

    @Type(type="UserType_C_NkSyoumetuCd")
    @Column(name=GenSV_NkBikin.NKSYOUMETUCD)
    public C_NkSyoumetuCd getNksyoumetucd() {
        return nksyoumetucd;
    }

    public void setNksyoumetucd(C_NkSyoumetuCd pNksyoumetucd) {
        nksyoumetucd = pNksyoumetucd;
    }

    private String nksysyno;

    @Column(name=GenSV_NkBikin.NKSYSYNO)
    @NenkinSyousyoNo
    public String getNksysyno() {
        return nksysyno;
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setNksysyno(String pNksysyno) {
        nksysyno = pNksysyno;
    }

    private C_Bnshrkaisuu bnshrkaisuu;

    @Type(type="UserType_C_Bnshrkaisuu")
    @Column(name=GenSV_NkBikin.BNSHRKAISUU)
    public C_Bnshrkaisuu getBnshrkaisuu() {
        return bnshrkaisuu;
    }

    public void setBnshrkaisuu(C_Bnshrkaisuu pBnshrkaisuu) {
        bnshrkaisuu = pBnshrkaisuu;
    }

    private C_TyuuitratkiKbn tyuuitratkikbn;

    @Type(type="UserType_C_TyuuitratkiKbn")
    @Column(name=GenSV_NkBikin.TYUUITRATKIKBN)
    public C_TyuuitratkiKbn getTyuuitratkikbn() {
        return tyuuitratkikbn;
    }

    public void setTyuuitratkikbn(C_TyuuitratkiKbn pTyuuitratkikbn) {
        tyuuitratkikbn = pTyuuitratkikbn;
    }

    private C_Hhknsei hhknsei;

    @Type(type="UserType_C_Hhknsei")
    @Column(name=GenSV_NkBikin.HHKNSEI)
    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    private BizDate hhknseiymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_NkBikin.HHKNSEIYMD)
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

    @Column(name=GenSV_NkBikin.HHKNNEN)
    @NaturalNumber
    public Integer getHhknnen() {
        return hhknnen;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknnen(Integer pHhknnen) {
        hhknnen = pHhknnen;
    }

    private BizDate shrymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_NkBikin.SHRYMD)
    @ValidDate
    public BizDate getShrymd() {
        return shrymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShrymd(BizDate pShrymd) {
        shrymd = pShrymd;
    }

    private String tsinyno;

    @Column(name=GenSV_NkBikin.TSINYNO)
    @Length(length=7)
    @SingleByteStrings
    @Digit
    public String getTsinyno() {
        return tsinyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTsinyno(String pTsinyno) {
        tsinyno = pTsinyno;
    }
}
