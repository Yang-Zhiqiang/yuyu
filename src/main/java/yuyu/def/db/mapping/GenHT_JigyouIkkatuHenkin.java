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
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HnknhouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.HT_JigyouIkkatuHenkin;
import yuyu.def.db.id.PKHT_JigyouIkkatuHenkin;
import yuyu.def.db.meta.GenQHT_JigyouIkkatuHenkin;
import yuyu.def.db.meta.QHT_JigyouIkkatuHenkin;
import yuyu.def.db.type.UserType_C_HnknhouKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 事業一括返金テーブル テーブルのマッピング情報クラスで、 {@link HT_JigyouIkkatuHenkin} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_JigyouIkkatuHenkin}</td><td colspan="3">事業一括返金テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDaimosno daimosno}</td><td>代表申込番号</td><td align="center">{@link PKHT_JigyouIkkatuHenkin ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKHT_JigyouIkkatuHenkin ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHnkngk hnkngk}</td><td>返金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHnknhoukbn hnknhoukbn}</td><td>返金方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HnknhouKbn}</td></tr>
 *  <tr><td>{@link #getHnknymd hnknymd}</td><td>返金日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzmeiginmkn kzmeiginmkn}</td><td>口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSrgohnknumu srgohnknumu}</td><td>成立後返金有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_JigyouIkkatuHenkin
 * @see     PKHT_JigyouIkkatuHenkin
 * @see     QHT_JigyouIkkatuHenkin
 * @see     GenQHT_JigyouIkkatuHenkin
 */
@MappedSuperclass
@Table(name=GenHT_JigyouIkkatuHenkin.TABLE_NAME)
@IdClass(value=PKHT_JigyouIkkatuHenkin.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HnknhouKbn", typeClass=UserType_C_HnknhouKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class)
})
public abstract class GenHT_JigyouIkkatuHenkin extends AbstractExDBEntity<HT_JigyouIkkatuHenkin, PKHT_JigyouIkkatuHenkin> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_JigyouIkkatuHenkin";
    public static final String DAIMOSNO                 = "daimosno";
    public static final String RENNO                    = "renno";
    public static final String HNKNGK                   = "hnkngk";
    public static final String HNKNHOUKBN               = "hnknhoukbn";
    public static final String HNKNYMD                  = "hnknymd";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO                  = "kouzano";
    public static final String KZMEIGINMKN              = "kzmeiginmkn";
    public static final String SRGOHNKNUMU              = "srgohnknumu";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_JigyouIkkatuHenkin primaryKey;

    public GenHT_JigyouIkkatuHenkin() {
        primaryKey = new PKHT_JigyouIkkatuHenkin();
    }

    public GenHT_JigyouIkkatuHenkin(String pDaimosno, Integer pRenno) {
        primaryKey = new PKHT_JigyouIkkatuHenkin(pDaimosno, pRenno);
    }

    @Transient
    @Override
    public PKHT_JigyouIkkatuHenkin getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_JigyouIkkatuHenkin> getMetaClass() {
        return QHT_JigyouIkkatuHenkin.class;
    }

    @Id
    @Column(name=GenHT_JigyouIkkatuHenkin.DAIMOSNO)
    @MousikomiNo
    public String getDaimosno() {
        return getPrimaryKey().getDaimosno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDaimosno(String pDaimosno) {
        getPrimaryKey().setDaimosno(pDaimosno);
    }

    @Id
    @Column(name=GenHT_JigyouIkkatuHenkin.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private BizCurrency hnkngk;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    public BizCurrency getHnkngk() {
        return hnkngk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHnkngk(BizCurrency pHnkngk) {
        hnkngk = pHnkngk;
        hnkngkValue = null;
        hnkngkType  = null;
    }

    transient private BigDecimal hnkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HNKNGK, nullable=true)
    protected BigDecimal getHnkngkValue() {
        if (hnkngkValue == null && hnkngk != null) {
            if (hnkngk.isOptional()) return null;
            return hnkngk.absolute();
        }
        return hnkngkValue;
    }

    protected void setHnkngkValue(BigDecimal value) {
        hnkngkValue = value;
        hnkngk = Optional.fromNullable(toCurrencyType(hnkngkType))
            .transform(bizCurrencyTransformer(getHnkngkValue()))
            .orNull();
    }

    transient private String hnkngkType = null;

    @Column(name=HNKNGK + "$", nullable=true)
    protected String getHnkngkType() {
        if (hnkngkType == null && hnkngk != null) return hnkngk.getType().toString();
        if (hnkngkType == null && getHnkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hnkngk$' should not be NULL."));
        }
        return hnkngkType;
    }

    protected void setHnkngkType(String type) {
        hnkngkType = type;
        hnkngk = Optional.fromNullable(toCurrencyType(hnkngkType))
            .transform(bizCurrencyTransformer(getHnkngkValue()))
            .orNull();
    }

    private C_HnknhouKbn hnknhoukbn;

    @Type(type="UserType_C_HnknhouKbn")
    @Column(name=GenHT_JigyouIkkatuHenkin.HNKNHOUKBN)
    public C_HnknhouKbn getHnknhoukbn() {
        return hnknhoukbn;
    }

    public void setHnknhoukbn(C_HnknhouKbn pHnknhoukbn) {
        hnknhoukbn = pHnknhoukbn;
    }

    private BizDate hnknymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_JigyouIkkatuHenkin.HNKNYMD)
    public BizDate getHnknymd() {
        return hnknymd;
    }

    public void setHnknymd(BizDate pHnknymd) {
        hnknymd = pHnknymd;
    }

    private String bankcd;

    @Column(name=GenHT_JigyouIkkatuHenkin.BANKCD)
    @Length(length=4)
    @Digit
    public String getBankcd() {
        return bankcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBankcd(String pBankcd) {
        bankcd = pBankcd;
    }

    private String sitencd;

    @Column(name=GenHT_JigyouIkkatuHenkin.SITENCD)
    @Length(length=3)
    @Digit
    public String getSitencd() {
        return sitencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSitencd(String pSitencd) {
        sitencd = pSitencd;
    }

    private C_YokinKbn yokinkbn;

    @Type(type="UserType_C_YokinKbn")
    @Column(name=GenHT_JigyouIkkatuHenkin.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenHT_JigyouIkkatuHenkin.KOUZANO)
    @MaxLength(max=12)
    @HostInvalidCharacter
    public String getKouzano() {
        return kouzano;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKouzano(String pKouzano) {
        kouzano = pKouzano;
    }

    private String kzmeiginmkn;

    @Column(name=GenHT_JigyouIkkatuHenkin.KZMEIGINMKN)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getKzmeiginmkn() {
        return kzmeiginmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKzmeiginmkn(String pKzmeiginmkn) {
        kzmeiginmkn = pKzmeiginmkn;
    }

    private C_UmuKbn srgohnknumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_JigyouIkkatuHenkin.SRGOHNKNUMU)
    public C_UmuKbn getSrgohnknumu() {
        return srgohnknumu;
    }

    public void setSrgohnknumu(C_UmuKbn pSrgohnknumu) {
        srgohnknumu = pSrgohnknumu;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_JigyouIkkatuHenkin.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_JigyouIkkatuHenkin.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}