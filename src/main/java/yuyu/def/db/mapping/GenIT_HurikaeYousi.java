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
import jp.co.slcs.swak.validation.constraints.AlphaDigitOrExceptionCode;
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
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.IT_HurikaeYousi;
import yuyu.def.db.id.PKIT_HurikaeYousi;
import yuyu.def.db.meta.GenQIT_HurikaeYousi;
import yuyu.def.db.meta.QIT_HurikaeYousi;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_NyknaiyouKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 振替用紙テーブル テーブルのマッピング情報クラスで、 {@link IT_HurikaeYousi} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_HurikaeYousi}</td><td colspan="3">振替用紙テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_HurikaeYousi ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_HurikaeYousi ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">{@link PKIT_HurikaeYousi ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShskyno shskyno}</td><td>送付先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsadr1kj shsadr1kj}</td><td>送付先住所１（漢字）（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsadr2kj shsadr2kj}</td><td>送付先住所２（漢字）（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsadr3kj shsadr3kj}</td><td>送付先住所３（漢字）（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsnmkj shsnmkj}</td><td>送付先氏名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasesosikinmkj toiawasesosikinmkj}</td><td>問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseyno toiawaseyno}</td><td>問合せ先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseadr1kj toiawaseadr1kj}</td><td>問合せ先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseadr2kj toiawaseadr2kj}</td><td>問合せ先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseadr3kj toiawaseadr3kj}</td><td>問合せ先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasetelno toiawasetelno}</td><td>問合せ先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseteluktkkanou1 toiawaseteluktkkanou1}</td><td>問合せ先電話受付可能時間１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseteluktkkanou2 toiawaseteluktkkanou2}</td><td>問合せ先電話受付可能時間２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasesosikinmkj2 toiawasesosikinmkj2}</td><td>第２問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasetelno2 toiawasetelno2}</td><td>第２問合せ先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNyknaiyoukbn nyknaiyoukbn}</td><td>入金内容区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NyknaiyouKbn}</td></tr>
 *  <tr><td>{@link #getKyknmkj kyknmkj}</td><td>契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRhrkjyuutouym rhrkjyuutouym}</td><td>（帳票用）払込充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkkigen hrkkigen}</td><td>払込期限</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHrkiraikngk hrkiraikngk}</td><td>払込依頼金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHassoukbn hassoukbn}</td><td>発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HassouKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_HurikaeYousi
 * @see     PKIT_HurikaeYousi
 * @see     QIT_HurikaeYousi
 * @see     GenQIT_HurikaeYousi
 */
@MappedSuperclass
@Table(name=GenIT_HurikaeYousi.TABLE_NAME)
@IdClass(value=PKIT_HurikaeYousi.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HassouKbn", typeClass=UserType_C_HassouKbn.class),
    @TypeDef(name="UserType_C_NyknaiyouKbn", typeClass=UserType_C_NyknaiyouKbn.class),
    @TypeDef(name="UserType_C_SyoruiCdKbn", typeClass=UserType_C_SyoruiCdKbn.class)
})
public abstract class GenIT_HurikaeYousi extends AbstractExDBEntity<IT_HurikaeYousi, PKIT_HurikaeYousi> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_HurikaeYousi";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String SYORUICD                 = "syoruiCd";
    public static final String TYOUHYOUYMD              = "tyouhyouymd";
    public static final String SHSKYNO                  = "shskyno";
    public static final String SHSADR1KJ                = "shsadr1kj";
    public static final String SHSADR2KJ                = "shsadr2kj";
    public static final String SHSADR3KJ                = "shsadr3kj";
    public static final String SHSNMKJ                  = "shsnmkj";
    public static final String TOIAWASESOSIKINMKJ       = "toiawasesosikinmkj";
    public static final String TOIAWASEYNO              = "toiawaseyno";
    public static final String TOIAWASEADR1KJ           = "toiawaseadr1kj";
    public static final String TOIAWASEADR2KJ           = "toiawaseadr2kj";
    public static final String TOIAWASEADR3KJ           = "toiawaseadr3kj";
    public static final String TOIAWASETELNO            = "toiawasetelno";
    public static final String TOIAWASETELUKTKKANOU1    = "toiawaseteluktkkanou1";
    public static final String TOIAWASETELUKTKKANOU2    = "toiawaseteluktkkanou2";
    public static final String TOIAWASESOSIKINMKJ2      = "toiawasesosikinmkj2";
    public static final String TOIAWASETELNO2           = "toiawasetelno2";
    public static final String NYKNAIYOUKBN             = "nyknaiyoukbn";
    public static final String KYKNMKJ                  = "kyknmkj";
    public static final String RHRKJYUUTOUYM            = "rhrkjyuutouym";
    public static final String HRKKIGEN                 = "hrkkigen";
    public static final String HRKIRAIKNGK              = "hrkiraikngk";
    public static final String HASSOUKBN                = "hassoukbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_HurikaeYousi primaryKey;

    public GenIT_HurikaeYousi() {
        primaryKey = new PKIT_HurikaeYousi();
    }

    public GenIT_HurikaeYousi(
        String pKbnkey,
        String pSyono,
        String pHenkousikibetukey
    ) {
        primaryKey = new PKIT_HurikaeYousi(
            pKbnkey,
            pSyono,
            pHenkousikibetukey
        );
    }

    @Transient
    @Override
    public PKIT_HurikaeYousi getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_HurikaeYousi> getMetaClass() {
        return QIT_HurikaeYousi.class;
    }

    @Id
    @Column(name=GenIT_HurikaeYousi.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_HurikaeYousi.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    @Id
    @Column(name=GenIT_HurikaeYousi.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return getPrimaryKey().getHenkousikibetukey();
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        getPrimaryKey().setHenkousikibetukey(pHenkousikibetukey);
    }

    private C_SyoruiCdKbn syoruiCd;

    @Type(type="UserType_C_SyoruiCdKbn")
    @Column(name=GenIT_HurikaeYousi.SYORUICD)
    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }

    private BizDate tyouhyouymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_HurikaeYousi.TYOUHYOUYMD)
    @ValidDate
    public BizDate getTyouhyouymd() {
        return tyouhyouymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyouhyouymd(BizDate pTyouhyouymd) {
        tyouhyouymd = pTyouhyouymd;
    }

    private String shskyno;

    @Column(name=GenIT_HurikaeYousi.SHSKYNO)
    @Length(length=7)
    @Digit
    public String getShskyno() {
        return shskyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShskyno(String pShskyno) {
        shskyno = pShskyno;
    }

    private String shsadr1kj;

    @Column(name=GenIT_HurikaeYousi.SHSADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getShsadr1kj() {
        return shsadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsadr1kj(String pShsadr1kj) {
        shsadr1kj = pShsadr1kj;
    }

    private String shsadr2kj;

    @Column(name=GenIT_HurikaeYousi.SHSADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getShsadr2kj() {
        return shsadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsadr2kj(String pShsadr2kj) {
        shsadr2kj = pShsadr2kj;
    }

    private String shsadr3kj;

    @Column(name=GenIT_HurikaeYousi.SHSADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getShsadr3kj() {
        return shsadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsadr3kj(String pShsadr3kj) {
        shsadr3kj = pShsadr3kj;
    }

    private String shsnmkj;

    @Column(name=GenIT_HurikaeYousi.SHSNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getShsnmkj() {
        return shsnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsnmkj(String pShsnmkj) {
        shsnmkj = pShsnmkj;
    }

    private String toiawasesosikinmkj;

    @Column(name=GenIT_HurikaeYousi.TOIAWASESOSIKINMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getToiawasesosikinmkj() {
        return toiawasesosikinmkj;
    }

    @DataConvert("toMultiByte")
    public void setToiawasesosikinmkj(String pToiawasesosikinmkj) {
        toiawasesosikinmkj = pToiawasesosikinmkj;
    }

    private String toiawaseyno;

    @Column(name=GenIT_HurikaeYousi.TOIAWASEYNO)
    public String getToiawaseyno() {
        return toiawaseyno;
    }

    public void setToiawaseyno(String pToiawaseyno) {
        toiawaseyno = pToiawaseyno;
    }

    private String toiawaseadr1kj;

    @Column(name=GenIT_HurikaeYousi.TOIAWASEADR1KJ)
    public String getToiawaseadr1kj() {
        return toiawaseadr1kj;
    }

    public void setToiawaseadr1kj(String pToiawaseadr1kj) {
        toiawaseadr1kj = pToiawaseadr1kj;
    }

    private String toiawaseadr2kj;

    @Column(name=GenIT_HurikaeYousi.TOIAWASEADR2KJ)
    public String getToiawaseadr2kj() {
        return toiawaseadr2kj;
    }

    public void setToiawaseadr2kj(String pToiawaseadr2kj) {
        toiawaseadr2kj = pToiawaseadr2kj;
    }

    private String toiawaseadr3kj;

    @Column(name=GenIT_HurikaeYousi.TOIAWASEADR3KJ)
    public String getToiawaseadr3kj() {
        return toiawaseadr3kj;
    }

    public void setToiawaseadr3kj(String pToiawaseadr3kj) {
        toiawaseadr3kj = pToiawaseadr3kj;
    }

    private String toiawasetelno;

    @Column(name=GenIT_HurikaeYousi.TOIAWASETELNO)
    @AlphaDigitOrExceptionCode(except=("-()"))
    @MaxLength(max=14)
    public String getToiawasetelno() {
        return toiawasetelno;
    }

    @DataConvert("toSingleByte")
    public void setToiawasetelno(String pToiawasetelno) {
        toiawasetelno = pToiawasetelno;
    }

    private String toiawaseteluktkkanou1;

    @Column(name=GenIT_HurikaeYousi.TOIAWASETELUKTKKANOU1)
    public String getToiawaseteluktkkanou1() {
        return toiawaseteluktkkanou1;
    }

    public void setToiawaseteluktkkanou1(String pToiawaseteluktkkanou1) {
        toiawaseteluktkkanou1 = pToiawaseteluktkkanou1;
    }

    private String toiawaseteluktkkanou2;

    @Column(name=GenIT_HurikaeYousi.TOIAWASETELUKTKKANOU2)
    public String getToiawaseteluktkkanou2() {
        return toiawaseteluktkkanou2;
    }

    public void setToiawaseteluktkkanou2(String pToiawaseteluktkkanou2) {
        toiawaseteluktkkanou2 = pToiawaseteluktkkanou2;
    }

    private String toiawasesosikinmkj2;

    @Column(name=GenIT_HurikaeYousi.TOIAWASESOSIKINMKJ2)
    public String getToiawasesosikinmkj2() {
        return toiawasesosikinmkj2;
    }

    public void setToiawasesosikinmkj2(String pToiawasesosikinmkj2) {
        toiawasesosikinmkj2 = pToiawasesosikinmkj2;
    }

    private String toiawasetelno2;

    @Column(name=GenIT_HurikaeYousi.TOIAWASETELNO2)
    public String getToiawasetelno2() {
        return toiawasetelno2;
    }

    public void setToiawasetelno2(String pToiawasetelno2) {
        toiawasetelno2 = pToiawasetelno2;
    }

    private C_NyknaiyouKbn nyknaiyoukbn;

    @Type(type="UserType_C_NyknaiyouKbn")
    @Column(name=GenIT_HurikaeYousi.NYKNAIYOUKBN)
    public C_NyknaiyouKbn getNyknaiyoukbn() {
        return nyknaiyoukbn;
    }

    public void setNyknaiyoukbn(C_NyknaiyouKbn pNyknaiyoukbn) {
        nyknaiyoukbn = pNyknaiyoukbn;
    }

    private String kyknmkj;

    @Column(name=GenIT_HurikaeYousi.KYKNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getKyknmkj() {
        return kyknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkj(String pKyknmkj) {
        kyknmkj = pKyknmkj;
    }

    private String rhrkjyuutouym;

    @Column(name=GenIT_HurikaeYousi.RHRKJYUUTOUYM)
    public String getRhrkjyuutouym() {
        return rhrkjyuutouym;
    }

    public void setRhrkjyuutouym(String pRhrkjyuutouym) {
        rhrkjyuutouym = pRhrkjyuutouym;
    }

    private BizDate hrkkigen;

    @Type(type="BizDateType")
    @Column(name=GenIT_HurikaeYousi.HRKKIGEN)
    public BizDate getHrkkigen() {
        return hrkkigen;
    }

    @Trim("both")
    public void setHrkkigen(BizDate pHrkkigen) {
        hrkkigen = pHrkkigen;
    }

    private BizCurrency hrkiraikngk;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=9)
    @PositiveNumberBizCalcble
    public BizCurrency getHrkiraikngk() {
        return hrkiraikngk;
    }

    public void setHrkiraikngk(BizCurrency pHrkiraikngk) {
        hrkiraikngk = pHrkiraikngk;
        hrkiraikngkValue = null;
        hrkiraikngkType  = null;
    }

    transient private BigDecimal hrkiraikngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HRKIRAIKNGK, nullable=true)
    protected BigDecimal getHrkiraikngkValue() {
        if (hrkiraikngkValue == null && hrkiraikngk != null) {
            if (hrkiraikngk.isOptional()) return null;
            return hrkiraikngk.absolute();
        }
        return hrkiraikngkValue;
    }

    protected void setHrkiraikngkValue(BigDecimal value) {
        hrkiraikngkValue = value;
        hrkiraikngk = Optional.fromNullable(toCurrencyType(hrkiraikngkType))
            .transform(bizCurrencyTransformer(getHrkiraikngkValue()))
            .orNull();
    }

    transient private String hrkiraikngkType = null;

    @Column(name=HRKIRAIKNGK + "$", nullable=true)
    protected String getHrkiraikngkType() {
        if (hrkiraikngkType == null && hrkiraikngk != null) return hrkiraikngk.getType().toString();
        if (hrkiraikngkType == null && getHrkiraikngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hrkiraikngk$' should not be NULL."));
        }
        return hrkiraikngkType;
    }

    protected void setHrkiraikngkType(String type) {
        hrkiraikngkType = type;
        hrkiraikngk = Optional.fromNullable(toCurrencyType(hrkiraikngkType))
            .transform(bizCurrencyTransformer(getHrkiraikngkValue()))
            .orNull();
    }

    private C_HassouKbn hassoukbn;

    @Type(type="UserType_C_HassouKbn")
    @Column(name=GenIT_HurikaeYousi.HASSOUKBN)
    public C_HassouKbn getHassoukbn() {
        return hassoukbn;
    }

    public void setHassoukbn(C_HassouKbn pHassoukbn) {
        hassoukbn = pHassoukbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_HurikaeYousi.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_HurikaeYousi.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_HurikaeYousi.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}