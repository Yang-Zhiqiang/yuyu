package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.entity.HT_Uketorinin;
import yuyu.def.db.id.PKHT_Uketorinin;
import yuyu.def.db.meta.GenQHT_Uketorinin;
import yuyu.def.db.meta.QHT_Uketorinin;
import yuyu.def.db.type.UserType_C_KjkhukaKbn;
import yuyu.def.db.type.UserType_C_Tdk;
import yuyu.def.db.type.UserType_C_TsindousiteiKbn;
import yuyu.def.db.type.UserType_C_UktKbn;
import yuyu.def.db.type.UserType_C_UktsyuKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 受取人テーブル テーブルのマッピング情報クラスで、 {@link HT_Uketorinin} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_Uketorinin}</td><td colspan="3">受取人テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_Uketorinin ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUktsyukbn uktsyukbn}</td><td>受取人種類区分</td><td align="center">{@link PKHT_Uketorinin ○}</td><td align="center">V</td><td>{@link C_UktsyuKbn}</td></tr>
 *  <tr><td>{@link #getUktsyurenno uktsyurenno}</td><td>受取人種類別連番</td><td align="center">{@link PKHT_Uketorinin ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getUktkbn uktkbn}</td><td>受取人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UktKbn}</td></tr>
 *  <tr><td>{@link #getUktnmkn uktnmkn}</td><td>受取人名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUktnmkj uktnmkj}</td><td>受取人名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUktnmkjkhukakbn uktnmkjkhukakbn}</td><td>受取人名漢字化不可区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KjkhukaKbn}</td></tr>
 *  <tr><td>{@link #getUkttdk ukttdk}</td><td>受取人続柄</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tdk}</td></tr>
 *  <tr><td>{@link #getUktbnwari uktbnwari}</td><td>受取人分割割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getUktseiymd uktseiymd}</td><td>受取人生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getUkttsindousiteikbn ukttsindousiteikbn}</td><td>受取人通信先同一指定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TsindousiteiKbn}</td></tr>
 *  <tr><td>{@link #getUktyno uktyno}</td><td>受取人郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUktadr1kj uktadr1kj}</td><td>受取人住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUktadr2kj uktadr2kj}</td><td>受取人住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUktadr3kj uktadr3kj}</td><td>受取人住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_Uketorinin
 * @see     PKHT_Uketorinin
 * @see     QHT_Uketorinin
 * @see     GenQHT_Uketorinin
 */
@MappedSuperclass
@Table(name=GenHT_Uketorinin.TABLE_NAME)
@IdClass(value=PKHT_Uketorinin.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_KjkhukaKbn", typeClass=UserType_C_KjkhukaKbn.class),
    @TypeDef(name="UserType_C_Tdk", typeClass=UserType_C_Tdk.class),
    @TypeDef(name="UserType_C_TsindousiteiKbn", typeClass=UserType_C_TsindousiteiKbn.class),
    @TypeDef(name="UserType_C_UktKbn", typeClass=UserType_C_UktKbn.class),
    @TypeDef(name="UserType_C_UktsyuKbn", typeClass=UserType_C_UktsyuKbn.class)
})
public abstract class GenHT_Uketorinin extends AbstractExDBEntity<HT_Uketorinin, PKHT_Uketorinin> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_Uketorinin";
    public static final String MOSNO                    = "mosno";
    public static final String UKTSYUKBN                = "uktsyukbn";
    public static final String UKTSYURENNO              = "uktsyurenno";
    public static final String UKTKBN                   = "uktkbn";
    public static final String UKTNMKN                  = "uktnmkn";
    public static final String UKTNMKJ                  = "uktnmkj";
    public static final String UKTNMKJKHUKAKBN          = "uktnmkjkhukakbn";
    public static final String UKTTDK                   = "ukttdk";
    public static final String UKTBNWARI                = "uktbnwari";
    public static final String UKTSEIYMD                = "uktseiymd";
    public static final String UKTTSINDOUSITEIKBN       = "ukttsindousiteikbn";
    public static final String UKTYNO                   = "uktyno";
    public static final String UKTADR1KJ                = "uktadr1kj";
    public static final String UKTADR2KJ                = "uktadr2kj";
    public static final String UKTADR3KJ                = "uktadr3kj";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_Uketorinin primaryKey;

    public GenHT_Uketorinin() {
        primaryKey = new PKHT_Uketorinin();
    }

    public GenHT_Uketorinin(
        String pMosno,
        C_UktsyuKbn pUktsyukbn,
        Integer pUktsyurenno
    ) {
        primaryKey = new PKHT_Uketorinin(
            pMosno,
            pUktsyukbn,
            pUktsyurenno
        );
    }

    @Transient
    @Override
    public PKHT_Uketorinin getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_Uketorinin> getMetaClass() {
        return QHT_Uketorinin.class;
    }

    @Id
    @Column(name=GenHT_Uketorinin.MOSNO)
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
    @Type(type="UserType_C_UktsyuKbn")
    @Column(name=GenHT_Uketorinin.UKTSYUKBN)
    public C_UktsyuKbn getUktsyukbn() {
        return getPrimaryKey().getUktsyukbn();
    }

    public void setUktsyukbn(C_UktsyuKbn pUktsyukbn) {
        getPrimaryKey().setUktsyukbn(pUktsyukbn);
    }

    @Id
    @Column(name=GenHT_Uketorinin.UKTSYURENNO)
    public Integer getUktsyurenno() {
        return getPrimaryKey().getUktsyurenno();
    }

    public void setUktsyurenno(Integer pUktsyurenno) {
        getPrimaryKey().setUktsyurenno(pUktsyurenno);
    }

    private C_UktKbn uktkbn;

    @Type(type="UserType_C_UktKbn")
    @Column(name=GenHT_Uketorinin.UKTKBN)
    public C_UktKbn getUktkbn() {
        return uktkbn;
    }

    public void setUktkbn(C_UktKbn pUktkbn) {
        uktkbn = pUktkbn;
    }

    private String uktnmkn;

    @Column(name=GenHT_Uketorinin.UKTNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getUktnmkn() {
        return uktnmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setUktnmkn(String pUktnmkn) {
        uktnmkn = pUktnmkn;
    }

    private String uktnmkj;

    @Column(name=GenHT_Uketorinin.UKTNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getUktnmkj() {
        return uktnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setUktnmkj(String pUktnmkj) {
        uktnmkj = pUktnmkj;
    }

    private C_KjkhukaKbn uktnmkjkhukakbn;

    @Type(type="UserType_C_KjkhukaKbn")
    @Column(name=GenHT_Uketorinin.UKTNMKJKHUKAKBN)
    public C_KjkhukaKbn getUktnmkjkhukakbn() {
        return uktnmkjkhukakbn;
    }

    public void setUktnmkjkhukakbn(C_KjkhukaKbn pUktnmkjkhukakbn) {
        uktnmkjkhukakbn = pUktnmkjkhukakbn;
    }

    private C_Tdk ukttdk;

    @Type(type="UserType_C_Tdk")
    @Column(name=GenHT_Uketorinin.UKTTDK)
    public C_Tdk getUkttdk() {
        return ukttdk;
    }

    public void setUkttdk(C_Tdk pUkttdk) {
        ukttdk = pUkttdk;
    }

    private BizNumber uktbnwari;

    @Type(type="BizNumberType")
    @Column(name=GenHT_Uketorinin.UKTBNWARI)
    public BizNumber getUktbnwari() {
        return uktbnwari;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktbnwari(BizNumber pUktbnwari) {
        uktbnwari = pUktbnwari;
    }

    private BizDate uktseiymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_Uketorinin.UKTSEIYMD)
    @ValidDate
    public BizDate getUktseiymd() {
        return uktseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktseiymd(BizDate pUktseiymd) {
        uktseiymd = pUktseiymd;
    }

    private C_TsindousiteiKbn ukttsindousiteikbn;

    @Type(type="UserType_C_TsindousiteiKbn")
    @Column(name=GenHT_Uketorinin.UKTTSINDOUSITEIKBN)
    public C_TsindousiteiKbn getUkttsindousiteikbn() {
        return ukttsindousiteikbn;
    }

    public void setUkttsindousiteikbn(C_TsindousiteiKbn pUkttsindousiteikbn) {
        ukttsindousiteikbn = pUkttsindousiteikbn;
    }

    private String uktyno;

    @Column(name=GenHT_Uketorinin.UKTYNO)
    @Length(length=7)
    @SingleByteStrings
    @Digit
    public String getUktyno() {
        return uktyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktyno(String pUktyno) {
        uktyno = pUktyno;
    }

    private String uktadr1kj;

    @Column(name=GenHT_Uketorinin.UKTADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getUktadr1kj() {
        return uktadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setUktadr1kj(String pUktadr1kj) {
        uktadr1kj = pUktadr1kj;
    }

    private String uktadr2kj;

    @Column(name=GenHT_Uketorinin.UKTADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getUktadr2kj() {
        return uktadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setUktadr2kj(String pUktadr2kj) {
        uktadr2kj = pUktadr2kj;
    }

    private String uktadr3kj;

    @Column(name=GenHT_Uketorinin.UKTADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getUktadr3kj() {
        return uktadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setUktadr3kj(String pUktadr3kj) {
        uktadr3kj = pUktadr3kj;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_Uketorinin.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_Uketorinin.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}