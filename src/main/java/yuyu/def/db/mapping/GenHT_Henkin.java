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
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HenkinriyuuKbn;
import yuyu.def.classification.C_HnknhouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.HT_Henkin;
import yuyu.def.db.id.PKHT_Henkin;
import yuyu.def.db.meta.GenQHT_Henkin;
import yuyu.def.db.meta.QHT_Henkin;
import yuyu.def.db.type.UserType_C_HenkinriyuuKbn;
import yuyu.def.db.type.UserType_C_HnknhouKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 返金テーブル テーブルのマッピング情報クラスで、 {@link HT_Henkin} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_Henkin}</td><td colspan="3">返金テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_Henkin ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKHT_Henkin ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHnkninputrenno hnkninputrenno}</td><td>返金入力連番</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHnknsyoriymd hnknsyoriymd}</td><td>返金処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHenkinsyoritime henkinsyoritime}</td><td>返金処理日時</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHnkngk hnkngk}</td><td>返金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHnkntuukasyu hnkntuukasyu}</td><td>返金通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getPkakinsyoriymd pkakinsyoriymd}</td><td>Ｐ過金処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHnknhoukbn hnknhoukbn}</td><td>返金方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HnknhouKbn}</td></tr>
 *  <tr><td>{@link #getHnknymd hnknymd}</td><td>返金日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHnknriyuukbn hnknriyuukbn}</td><td>返金理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HenkinriyuuKbn}</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzmeiginmkn kzmeiginmkn}</td><td>口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSrgohnknumu srgohnknumu}</td><td>成立後返金有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getDenrenno denrenno}</td><td>伝票データ連番</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getEdano edano}</td><td>枝番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getPkakindenrenno pkakindenrenno}</td><td>Ｐ過金伝票データ連番</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPkakindenedano pkakindenedano}</td><td>Ｐ過金伝票枝番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getFbsoukindatasikibetukey fbsoukindatasikibetukey}</td><td>ＦＢ送金データ識別キー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZenhnknrenno zenhnknrenno}</td><td>全額返金連番</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_Henkin
 * @see     PKHT_Henkin
 * @see     QHT_Henkin
 * @see     GenQHT_Henkin
 */
@MappedSuperclass
@Table(name=GenHT_Henkin.TABLE_NAME)
@IdClass(value=PKHT_Henkin.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HenkinriyuuKbn", typeClass=UserType_C_HenkinriyuuKbn.class),
    @TypeDef(name="UserType_C_HnknhouKbn", typeClass=UserType_C_HnknhouKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class)
})
public abstract class GenHT_Henkin extends AbstractExDBEntity<HT_Henkin, PKHT_Henkin> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_Henkin";
    public static final String MOSNO                    = "mosno";
    public static final String RENNO                    = "renno";
    public static final String HNKNINPUTRENNO           = "hnkninputrenno";
    public static final String HNKNSYORIYMD             = "hnknsyoriymd";
    public static final String HENKINSYORITIME          = "henkinsyoritime";
    public static final String HNKNGK                   = "hnkngk";
    public static final String HNKNTUUKASYU             = "hnkntuukasyu";
    public static final String PKAKINSYORIYMD           = "pkakinsyoriymd";
    public static final String HNKNHOUKBN               = "hnknhoukbn";
    public static final String HNKNYMD                  = "hnknymd";
    public static final String HNKNRIYUUKBN             = "hnknriyuukbn";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO                  = "kouzano";
    public static final String KZMEIGINMKN              = "kzmeiginmkn";
    public static final String SRGOHNKNUMU              = "srgohnknumu";
    public static final String DENRENNO                 = "denrenno";
    public static final String EDANO                    = "edano";
    public static final String PKAKINDENRENNO           = "pkakindenrenno";
    public static final String PKAKINDENEDANO           = "pkakindenedano";
    public static final String FBSOUKINDATASIKIBETUKEY  = "fbsoukindatasikibetukey";
    public static final String ZENHNKNRENNO             = "zenhnknrenno";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_Henkin primaryKey;

    public GenHT_Henkin() {
        primaryKey = new PKHT_Henkin();
    }

    public GenHT_Henkin(String pMosno, Integer pRenno) {
        primaryKey = new PKHT_Henkin(pMosno, pRenno);
    }

    @Transient
    @Override
    public PKHT_Henkin getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_Henkin> getMetaClass() {
        return QHT_Henkin.class;
    }

    @Id
    @Column(name=GenHT_Henkin.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return getPrimaryKey().getMosno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        getPrimaryKey().setMosno(pMosno);
    }

    @Id
    @Column(name=GenHT_Henkin.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private String hnkninputrenno;

    @Column(name=GenHT_Henkin.HNKNINPUTRENNO)
    public String getHnkninputrenno() {
        return hnkninputrenno;
    }

    public void setHnkninputrenno(String pHnkninputrenno) {
        hnkninputrenno = pHnkninputrenno;
    }

    private BizDate hnknsyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_Henkin.HNKNSYORIYMD)
    @ValidDate
    public BizDate getHnknsyoriymd() {
        return hnknsyoriymd;
    }

    @Trim("both")
    public void setHnknsyoriymd(BizDate pHnknsyoriymd) {
        hnknsyoriymd = pHnknsyoriymd;
    }

    private String henkinsyoritime;

    @Column(name=GenHT_Henkin.HENKINSYORITIME)
    public String getHenkinsyoritime() {
        return henkinsyoritime;
    }

    public void setHenkinsyoritime(String pHenkinsyoritime) {
        henkinsyoritime = pHenkinsyoritime;
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

    private C_Tuukasyu hnkntuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenHT_Henkin.HNKNTUUKASYU)
    public C_Tuukasyu getHnkntuukasyu() {
        return hnkntuukasyu;
    }

    public void setHnkntuukasyu(C_Tuukasyu pHnkntuukasyu) {
        hnkntuukasyu = pHnkntuukasyu;
    }

    private BizDate pkakinsyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_Henkin.PKAKINSYORIYMD)
    public BizDate getPkakinsyoriymd() {
        return pkakinsyoriymd;
    }

    public void setPkakinsyoriymd(BizDate pPkakinsyoriymd) {
        pkakinsyoriymd = pPkakinsyoriymd;
    }

    private C_HnknhouKbn hnknhoukbn;

    @Type(type="UserType_C_HnknhouKbn")
    @Column(name=GenHT_Henkin.HNKNHOUKBN)
    public C_HnknhouKbn getHnknhoukbn() {
        return hnknhoukbn;
    }

    public void setHnknhoukbn(C_HnknhouKbn pHnknhoukbn) {
        hnknhoukbn = pHnknhoukbn;
    }

    private BizDate hnknymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_Henkin.HNKNYMD)
    public BizDate getHnknymd() {
        return hnknymd;
    }

    public void setHnknymd(BizDate pHnknymd) {
        hnknymd = pHnknymd;
    }

    private C_HenkinriyuuKbn hnknriyuukbn;

    @Type(type="UserType_C_HenkinriyuuKbn")
    @Column(name=GenHT_Henkin.HNKNRIYUUKBN)
    public C_HenkinriyuuKbn getHnknriyuukbn() {
        return hnknriyuukbn;
    }

    public void setHnknriyuukbn(C_HenkinriyuuKbn pHnknriyuukbn) {
        hnknriyuukbn = pHnknriyuukbn;
    }

    private String bankcd;

    @Column(name=GenHT_Henkin.BANKCD)
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

    @Column(name=GenHT_Henkin.SITENCD)
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
    @Column(name=GenHT_Henkin.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenHT_Henkin.KOUZANO)
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

    @Column(name=GenHT_Henkin.KZMEIGINMKN)
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
    @Column(name=GenHT_Henkin.SRGOHNKNUMU)
    public C_UmuKbn getSrgohnknumu() {
        return srgohnknumu;
    }

    public void setSrgohnknumu(C_UmuKbn pSrgohnknumu) {
        srgohnknumu = pSrgohnknumu;
    }

    private String denrenno;

    @Column(name=GenHT_Henkin.DENRENNO)
    public String getDenrenno() {
        return denrenno;
    }

    public void setDenrenno(String pDenrenno) {
        denrenno = pDenrenno;
    }

    private Integer edano;

    @Column(name=GenHT_Henkin.EDANO)
    public Integer getEdano() {
        return edano;
    }

    public void setEdano(Integer pEdano) {
        edano = pEdano;
    }

    private String pkakindenrenno;

    @Column(name=GenHT_Henkin.PKAKINDENRENNO)
    public String getPkakindenrenno() {
        return pkakindenrenno;
    }

    public void setPkakindenrenno(String pPkakindenrenno) {
        pkakindenrenno = pPkakindenrenno;
    }

    private Integer pkakindenedano;

    @Column(name=GenHT_Henkin.PKAKINDENEDANO)
    public Integer getPkakindenedano() {
        return pkakindenedano;
    }

    public void setPkakindenedano(Integer pPkakindenedano) {
        pkakindenedano = pPkakindenedano;
    }

    private String fbsoukindatasikibetukey;

    @Column(name=GenHT_Henkin.FBSOUKINDATASIKIBETUKEY)
    public String getFbsoukindatasikibetukey() {
        return fbsoukindatasikibetukey;
    }

    public void setFbsoukindatasikibetukey(String pFbsoukindatasikibetukey) {
        fbsoukindatasikibetukey = pFbsoukindatasikibetukey;
    }

    private Integer zenhnknrenno;

    @Column(name=GenHT_Henkin.ZENHNKNRENNO)
    public Integer getZenhnknrenno() {
        return zenhnknrenno;
    }

    public void setZenhnknrenno(Integer pZenhnknrenno) {
        zenhnknrenno = pZenhnknrenno;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_Henkin.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_Henkin.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}