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
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.db.entity.BT_IdouNkMeigi;
import yuyu.def.db.id.PKBT_IdouNkMeigi;
import yuyu.def.db.meta.GenQBT_IdouNkMeigi;
import yuyu.def.db.meta.QBT_IdouNkMeigi;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.NenkinSyousyoNo;
import yuyu.infr.validation.constraints.Tel;

/**
 * 異動年金支払名義管理テーブル テーブルのマッピング情報クラスで、 {@link BT_IdouNkMeigi} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_IdouNkMeigi}</td><td colspan="3">異動年金支払名義管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getNksysyno nksysyno}</td><td>年金証書番号</td><td align="center">{@link PKBT_IdouNkMeigi ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">{@link PKBT_IdouNkMeigi ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHhknnmkn hhknnmkn}</td><td>被保険者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmkj hhknnmkj}</td><td>被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknseiymd hhknseiymd}</td><td>被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHhknsei hhknsei}</td><td>被保険者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hhknsei}</td></tr>
 *  <tr><td>{@link #getHhknyno hhknyno}</td><td>被保険者郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknadr1kj hhknadr1kj}</td><td>被保険者住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknadr2kj hhknadr2kj}</td><td>被保険者住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknadr3kj hhknadr3kj}</td><td>被保険者住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhkntelno hhkntelno}</td><td>被保険者電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknsykgycd hhknsykgycd}</td><td>被保険者職業コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinuktnmkana nenkinuktnmkana}</td><td>年金受取人名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinuktnmkanji nenkinuktnmkanji}</td><td>年金受取人名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinuktseiymd nenkinuktseiymd}</td><td>年金受取人生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTsinyno tsinyno}</td><td>通信先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr1kj tsinadr1kj}</td><td>通信先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr2kj tsinadr2kj}</td><td>通信先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr3kj tsinadr3kj}</td><td>通信先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsintelno tsintelno}</td><td>通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStdrsknmkn stdrsknmkn}</td><td>指定代理請求人名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStdrsknmkj stdrsknmkj}</td><td>指定代理請求人名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_IdouNkMeigi
 * @see     PKBT_IdouNkMeigi
 * @see     QBT_IdouNkMeigi
 * @see     GenQBT_IdouNkMeigi
 */
@MappedSuperclass
@Table(name=GenBT_IdouNkMeigi.TABLE_NAME)
@IdClass(value=PKBT_IdouNkMeigi.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_Hhknsei", typeClass=UserType_C_Hhknsei.class)
})
public abstract class GenBT_IdouNkMeigi extends AbstractExDBEntity<BT_IdouNkMeigi, PKBT_IdouNkMeigi> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_IdouNkMeigi";
    public static final String NKSYSYNO                 = "nksysyno";
    public static final String RENNO3KETA               = "renno3keta";
    public static final String HHKNNMKN                 = "hhknnmkn";
    public static final String HHKNNMKJ                 = "hhknnmkj";
    public static final String HHKNSEIYMD               = "hhknseiymd";
    public static final String HHKNSEI                  = "hhknsei";
    public static final String HHKNYNO                  = "hhknyno";
    public static final String HHKNADR1KJ               = "hhknadr1kj";
    public static final String HHKNADR2KJ               = "hhknadr2kj";
    public static final String HHKNADR3KJ               = "hhknadr3kj";
    public static final String HHKNTELNO                = "hhkntelno";
    public static final String HHKNSYKGYCD              = "hhknsykgycd";
    public static final String NENKINUKTNMKANA          = "nenkinuktnmkana";
    public static final String NENKINUKTNMKANJI         = "nenkinuktnmkanji";
    public static final String NENKINUKTSEIYMD          = "nenkinuktseiymd";
    public static final String TSINYNO                  = "tsinyno";
    public static final String TSINADR1KJ               = "tsinadr1kj";
    public static final String TSINADR2KJ               = "tsinadr2kj";
    public static final String TSINADR3KJ               = "tsinadr3kj";
    public static final String TSINTELNO                = "tsintelno";
    public static final String STDRSKNMKN               = "stdrsknmkn";
    public static final String STDRSKNMKJ               = "stdrsknmkj";

    private final PKBT_IdouNkMeigi primaryKey;

    public GenBT_IdouNkMeigi() {
        primaryKey = new PKBT_IdouNkMeigi();
    }

    public GenBT_IdouNkMeigi(String pNksysyno, Integer pRenno3keta) {
        primaryKey = new PKBT_IdouNkMeigi(pNksysyno, pRenno3keta);
    }

    @Transient
    @Override
    public PKBT_IdouNkMeigi getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_IdouNkMeigi> getMetaClass() {
        return QBT_IdouNkMeigi.class;
    }

    @Id
    @Column(name=GenBT_IdouNkMeigi.NKSYSYNO)
    @NenkinSyousyoNo
    public String getNksysyno() {
        return getPrimaryKey().getNksysyno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNksysyno(String pNksysyno) {
        getPrimaryKey().setNksysyno(pNksysyno);
    }

    @Id
    @Column(name=GenBT_IdouNkMeigi.RENNO3KETA)
    public Integer getRenno3keta() {
        return getPrimaryKey().getRenno3keta();
    }

    public void setRenno3keta(Integer pRenno3keta) {
        getPrimaryKey().setRenno3keta(pRenno3keta);
    }

    private String hhknnmkn;

    @Column(name=GenBT_IdouNkMeigi.HHKNNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getHhknnmkn() {
        return hhknnmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknnmkn(String pHhknnmkn) {
        hhknnmkn = pHhknnmkn;
    }

    private String hhknnmkj;

    @Column(name=GenBT_IdouNkMeigi.HHKNNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknnmkj() {
        return hhknnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknnmkj(String pHhknnmkj) {
        hhknnmkj = pHhknnmkj;
    }

    private BizDate hhknseiymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_IdouNkMeigi.HHKNSEIYMD)
    @ValidDate
    public BizDate getHhknseiymd() {
        return hhknseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknseiymd(BizDate pHhknseiymd) {
        hhknseiymd = pHhknseiymd;
    }

    private C_Hhknsei hhknsei;

    @Type(type="UserType_C_Hhknsei")
    @Column(name=GenBT_IdouNkMeigi.HHKNSEI)
    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    private String hhknyno;

    @Column(name=GenBT_IdouNkMeigi.HHKNYNO)
    @Length(length=7)
    @SingleByteStrings
    @Digit
    public String getHhknyno() {
        return hhknyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknyno(String pHhknyno) {
        hhknyno = pHhknyno;
    }

    private String hhknadr1kj;

    @Column(name=GenBT_IdouNkMeigi.HHKNADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknadr1kj() {
        return hhknadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknadr1kj(String pHhknadr1kj) {
        hhknadr1kj = pHhknadr1kj;
    }

    private String hhknadr2kj;

    @Column(name=GenBT_IdouNkMeigi.HHKNADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknadr2kj() {
        return hhknadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknadr2kj(String pHhknadr2kj) {
        hhknadr2kj = pHhknadr2kj;
    }

    private String hhknadr3kj;

    @Column(name=GenBT_IdouNkMeigi.HHKNADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknadr3kj() {
        return hhknadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknadr3kj(String pHhknadr3kj) {
        hhknadr3kj = pHhknadr3kj;
    }

    private String hhkntelno;

    @Column(name=GenBT_IdouNkMeigi.HHKNTELNO)
    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    public String getHhkntelno() {
        return hhkntelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhkntelno(String pHhkntelno) {
        hhkntelno = pHhkntelno;
    }

    private String hhknsykgycd;

    @Column(name=GenBT_IdouNkMeigi.HHKNSYKGYCD)
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

    private String nenkinuktnmkana;

    @Column(name=GenBT_IdouNkMeigi.NENKINUKTNMKANA)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getNenkinuktnmkana() {
        return nenkinuktnmkana;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNenkinuktnmkana(String pNenkinuktnmkana) {
        nenkinuktnmkana = pNenkinuktnmkana;
    }

    private String nenkinuktnmkanji;

    @Column(name=GenBT_IdouNkMeigi.NENKINUKTNMKANJI)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getNenkinuktnmkanji() {
        return nenkinuktnmkanji;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNenkinuktnmkanji(String pNenkinuktnmkanji) {
        nenkinuktnmkanji = pNenkinuktnmkanji;
    }

    private BizDate nenkinuktseiymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_IdouNkMeigi.NENKINUKTSEIYMD)
    @ValidDate
    public BizDate getNenkinuktseiymd() {
        return nenkinuktseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNenkinuktseiymd(BizDate pNenkinuktseiymd) {
        nenkinuktseiymd = pNenkinuktseiymd;
    }

    private String tsinyno;

    @Column(name=GenBT_IdouNkMeigi.TSINYNO)
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

    private String tsinadr1kj;

    @Column(name=GenBT_IdouNkMeigi.TSINADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr1kj() {
        return tsinadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr1kj(String pTsinadr1kj) {
        tsinadr1kj = pTsinadr1kj;
    }

    private String tsinadr2kj;

    @Column(name=GenBT_IdouNkMeigi.TSINADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr2kj() {
        return tsinadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr2kj(String pTsinadr2kj) {
        tsinadr2kj = pTsinadr2kj;
    }

    private String tsinadr3kj;

    @Column(name=GenBT_IdouNkMeigi.TSINADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr3kj() {
        return tsinadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr3kj(String pTsinadr3kj) {
        tsinadr3kj = pTsinadr3kj;
    }

    private String tsintelno;

    @Column(name=GenBT_IdouNkMeigi.TSINTELNO)
    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    public String getTsintelno() {
        return tsintelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTsintelno(String pTsintelno) {
        tsintelno = pTsintelno;
    }

    private String stdrsknmkn;

    @Column(name=GenBT_IdouNkMeigi.STDRSKNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getStdrsknmkn() {
        return stdrsknmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setStdrsknmkn(String pStdrsknmkn) {
        stdrsknmkn = pStdrsknmkn;
    }

    private String stdrsknmkj;

    @Column(name=GenBT_IdouNkMeigi.STDRSKNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getStdrsknmkj() {
        return stdrsknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setStdrsknmkj(String pStdrsknmkj) {
        stdrsknmkj = pStdrsknmkj;
    }
}