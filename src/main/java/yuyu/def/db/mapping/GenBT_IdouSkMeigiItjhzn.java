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
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.BT_IdouSkMeigiItjhzn;
import yuyu.def.db.id.PKBT_IdouSkMeigiItjhzn;
import yuyu.def.db.meta.GenQBT_IdouSkMeigiItjhzn;
import yuyu.def.db.meta.QBT_IdouSkMeigiItjhzn;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_KzkykdouKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;
import yuyu.infr.validation.constraints.Tel;

/**
 * 異動新契約名義管理一時保存テーブル テーブルのマッピング情報クラスで、 {@link BT_IdouSkMeigiItjhzn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_IdouSkMeigiItjhzn}</td><td colspan="3">異動新契約名義管理一時保存テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKBT_IdouSkMeigiItjhzn ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">{@link PKBT_IdouSkMeigiItjhzn ○}</td><td align="center">N</td><td>Integer</td></tr>
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
 *  <tr><td>{@link #getKyknmkn kyknmkn}</td><td>契約者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkj kyknmkj}</td><td>契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykseiymd kykseiymd}</td><td>契約者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNenkinuktnmkana nenkinuktnmkana}</td><td>年金受取人名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinuktnmkanji nenkinuktnmkanji}</td><td>年金受取人名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinuktseiymd nenkinuktseiymd}</td><td>年金受取人生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTsinyno tsinyno}</td><td>通信先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr1kj tsinadr1kj}</td><td>通信先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr2kj tsinadr2kj}</td><td>通信先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr3kj tsinadr3kj}</td><td>通信先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsintelno tsintelno}</td><td>通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSbuktnmkn1 sbuktnmkn1}</td><td>死亡受取人名（カナ）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSbuktnmkj1 sbuktnmkj1}</td><td>死亡受取人名（漢字）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSbuktnmkn2 sbuktnmkn2}</td><td>死亡受取人名（カナ）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSbuktnmkj2 sbuktnmkj2}</td><td>死亡受取人名（漢字）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSbuktnmkn3 sbuktnmkn3}</td><td>死亡受取人名（カナ）３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSbuktnmkj3 sbuktnmkj3}</td><td>死亡受取人名（漢字）３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSbuktnmkn4 sbuktnmkn4}</td><td>死亡受取人名（カナ）４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSbuktnmkj4 sbuktnmkj4}</td><td>死亡受取人名（漢字）４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStdrsknmkn stdrsknmkn}</td><td>指定代理請求人名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStdrsknmkj stdrsknmkj}</td><td>指定代理請求人名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykdairinmkn kykdairinmkn}</td><td>契約者代理人名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykdairinmkj kykdairinmkj}</td><td>契約者代理人名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzmeiginmkn kzmeiginmkn}</td><td>口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzkykdoukbn kzkykdoukbn}</td><td>口座名義契約者同一人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KzkykdouKbn}</td></tr>
 *  <tr><td>{@link #getKzktourokunmkn1 kzktourokunmkn1}</td><td>家族登録名（カナ）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzktourokunmkj1 kzktourokunmkj1}</td><td>家族登録名（漢字）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzktourokunmkn2 kzktourokunmkn2}</td><td>家族登録名（カナ）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzktourokunmkj2 kzktourokunmkj2}</td><td>家族登録名（漢字）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_IdouSkMeigiItjhzn
 * @see     PKBT_IdouSkMeigiItjhzn
 * @see     QBT_IdouSkMeigiItjhzn
 * @see     GenQBT_IdouSkMeigiItjhzn
 */
@MappedSuperclass
@Table(name=GenBT_IdouSkMeigiItjhzn.TABLE_NAME)
@IdClass(value=PKBT_IdouSkMeigiItjhzn.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_Hhknsei", typeClass=UserType_C_Hhknsei.class),
    @TypeDef(name="UserType_C_KzkykdouKbn", typeClass=UserType_C_KzkykdouKbn.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class)
})
public abstract class GenBT_IdouSkMeigiItjhzn extends AbstractExDBEntity<BT_IdouSkMeigiItjhzn, PKBT_IdouSkMeigiItjhzn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_IdouSkMeigiItjhzn";
    public static final String MOSNO                    = "mosno";
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
    public static final String KYKNMKN                  = "kyknmkn";
    public static final String KYKNMKJ                  = "kyknmkj";
    public static final String KYKSEIYMD                = "kykseiymd";
    public static final String NENKINUKTNMKANA          = "nenkinuktnmkana";
    public static final String NENKINUKTNMKANJI         = "nenkinuktnmkanji";
    public static final String NENKINUKTSEIYMD          = "nenkinuktseiymd";
    public static final String TSINYNO                  = "tsinyno";
    public static final String TSINADR1KJ               = "tsinadr1kj";
    public static final String TSINADR2KJ               = "tsinadr2kj";
    public static final String TSINADR3KJ               = "tsinadr3kj";
    public static final String TSINTELNO                = "tsintelno";
    public static final String SBUKTNMKN1               = "sbuktnmkn1";
    public static final String SBUKTNMKJ1               = "sbuktnmkj1";
    public static final String SBUKTNMKN2               = "sbuktnmkn2";
    public static final String SBUKTNMKJ2               = "sbuktnmkj2";
    public static final String SBUKTNMKN3               = "sbuktnmkn3";
    public static final String SBUKTNMKJ3               = "sbuktnmkj3";
    public static final String SBUKTNMKN4               = "sbuktnmkn4";
    public static final String SBUKTNMKJ4               = "sbuktnmkj4";
    public static final String STDRSKNMKN               = "stdrsknmkn";
    public static final String STDRSKNMKJ               = "stdrsknmkj";
    public static final String KYKDAIRINMKN             = "kykdairinmkn";
    public static final String KYKDAIRINMKJ             = "kykdairinmkj";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO                  = "kouzano";
    public static final String KZMEIGINMKN              = "kzmeiginmkn";
    public static final String KZKYKDOUKBN              = "kzkykdoukbn";
    public static final String KZKTOUROKUNMKN1          = "kzktourokunmkn1";
    public static final String KZKTOUROKUNMKJ1          = "kzktourokunmkj1";
    public static final String KZKTOUROKUNMKN2          = "kzktourokunmkn2";
    public static final String KZKTOUROKUNMKJ2          = "kzktourokunmkj2";

    private final PKBT_IdouSkMeigiItjhzn primaryKey;

    public GenBT_IdouSkMeigiItjhzn() {
        primaryKey = new PKBT_IdouSkMeigiItjhzn();
    }

    public GenBT_IdouSkMeigiItjhzn(String pMosno, Integer pRenno3keta) {
        primaryKey = new PKBT_IdouSkMeigiItjhzn(pMosno, pRenno3keta);
    }

    @Transient
    @Override
    public PKBT_IdouSkMeigiItjhzn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_IdouSkMeigiItjhzn> getMetaClass() {
        return QBT_IdouSkMeigiItjhzn.class;
    }

    @Id
    @Column(name=GenBT_IdouSkMeigiItjhzn.MOSNO)
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
    @Column(name=GenBT_IdouSkMeigiItjhzn.RENNO3KETA)
    public Integer getRenno3keta() {
        return getPrimaryKey().getRenno3keta();
    }

    public void setRenno3keta(Integer pRenno3keta) {
        getPrimaryKey().setRenno3keta(pRenno3keta);
    }

    private String hhknnmkn;

    @Column(name=GenBT_IdouSkMeigiItjhzn.HHKNNMKN)
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

    @Column(name=GenBT_IdouSkMeigiItjhzn.HHKNNMKJ)
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
    @Column(name=GenBT_IdouSkMeigiItjhzn.HHKNSEIYMD)
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
    @Column(name=GenBT_IdouSkMeigiItjhzn.HHKNSEI)
    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    private String hhknyno;

    @Column(name=GenBT_IdouSkMeigiItjhzn.HHKNYNO)
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

    @Column(name=GenBT_IdouSkMeigiItjhzn.HHKNADR1KJ)
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

    @Column(name=GenBT_IdouSkMeigiItjhzn.HHKNADR2KJ)
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

    @Column(name=GenBT_IdouSkMeigiItjhzn.HHKNADR3KJ)
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

    @Column(name=GenBT_IdouSkMeigiItjhzn.HHKNTELNO)
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

    @Column(name=GenBT_IdouSkMeigiItjhzn.HHKNSYKGYCD)
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

    private String kyknmkn;

    @Column(name=GenBT_IdouSkMeigiItjhzn.KYKNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getKyknmkn() {
        return kyknmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkn(String pKyknmkn) {
        kyknmkn = pKyknmkn;
    }

    private String kyknmkj;

    @Column(name=GenBT_IdouSkMeigiItjhzn.KYKNMKJ)
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

    private BizDate kykseiymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_IdouSkMeigiItjhzn.KYKSEIYMD)
    @ValidDate
    public BizDate getKykseiymd() {
        return kykseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykseiymd(BizDate pKykseiymd) {
        kykseiymd = pKykseiymd;
    }

    private String nenkinuktnmkana;

    @Column(name=GenBT_IdouSkMeigiItjhzn.NENKINUKTNMKANA)
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

    @Column(name=GenBT_IdouSkMeigiItjhzn.NENKINUKTNMKANJI)
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
    @Column(name=GenBT_IdouSkMeigiItjhzn.NENKINUKTSEIYMD)
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

    @Column(name=GenBT_IdouSkMeigiItjhzn.TSINYNO)
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

    @Column(name=GenBT_IdouSkMeigiItjhzn.TSINADR1KJ)
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

    @Column(name=GenBT_IdouSkMeigiItjhzn.TSINADR2KJ)
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

    @Column(name=GenBT_IdouSkMeigiItjhzn.TSINADR3KJ)
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

    @Column(name=GenBT_IdouSkMeigiItjhzn.TSINTELNO)
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

    private String sbuktnmkn1;

    @Column(name=GenBT_IdouSkMeigiItjhzn.SBUKTNMKN1)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getSbuktnmkn1() {
        return sbuktnmkn1;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSbuktnmkn1(String pSbuktnmkn1) {
        sbuktnmkn1 = pSbuktnmkn1;
    }

    private String sbuktnmkj1;

    @Column(name=GenBT_IdouSkMeigiItjhzn.SBUKTNMKJ1)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getSbuktnmkj1() {
        return sbuktnmkj1;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSbuktnmkj1(String pSbuktnmkj1) {
        sbuktnmkj1 = pSbuktnmkj1;
    }

    private String sbuktnmkn2;

    @Column(name=GenBT_IdouSkMeigiItjhzn.SBUKTNMKN2)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getSbuktnmkn2() {
        return sbuktnmkn2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSbuktnmkn2(String pSbuktnmkn2) {
        sbuktnmkn2 = pSbuktnmkn2;
    }

    private String sbuktnmkj2;

    @Column(name=GenBT_IdouSkMeigiItjhzn.SBUKTNMKJ2)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getSbuktnmkj2() {
        return sbuktnmkj2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSbuktnmkj2(String pSbuktnmkj2) {
        sbuktnmkj2 = pSbuktnmkj2;
    }

    private String sbuktnmkn3;

    @Column(name=GenBT_IdouSkMeigiItjhzn.SBUKTNMKN3)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getSbuktnmkn3() {
        return sbuktnmkn3;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSbuktnmkn3(String pSbuktnmkn3) {
        sbuktnmkn3 = pSbuktnmkn3;
    }

    private String sbuktnmkj3;

    @Column(name=GenBT_IdouSkMeigiItjhzn.SBUKTNMKJ3)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getSbuktnmkj3() {
        return sbuktnmkj3;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSbuktnmkj3(String pSbuktnmkj3) {
        sbuktnmkj3 = pSbuktnmkj3;
    }

    private String sbuktnmkn4;

    @Column(name=GenBT_IdouSkMeigiItjhzn.SBUKTNMKN4)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getSbuktnmkn4() {
        return sbuktnmkn4;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSbuktnmkn4(String pSbuktnmkn4) {
        sbuktnmkn4 = pSbuktnmkn4;
    }

    private String sbuktnmkj4;

    @Column(name=GenBT_IdouSkMeigiItjhzn.SBUKTNMKJ4)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getSbuktnmkj4() {
        return sbuktnmkj4;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSbuktnmkj4(String pSbuktnmkj4) {
        sbuktnmkj4 = pSbuktnmkj4;
    }

    private String stdrsknmkn;

    @Column(name=GenBT_IdouSkMeigiItjhzn.STDRSKNMKN)
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

    @Column(name=GenBT_IdouSkMeigiItjhzn.STDRSKNMKJ)
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

    private String kykdairinmkn;

    @Column(name=GenBT_IdouSkMeigiItjhzn.KYKDAIRINMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getKykdairinmkn() {
        return kykdairinmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKykdairinmkn(String pKykdairinmkn) {
        kykdairinmkn = pKykdairinmkn;
    }

    private String kykdairinmkj;

    @Column(name=GenBT_IdouSkMeigiItjhzn.KYKDAIRINMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getKykdairinmkj() {
        return kykdairinmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKykdairinmkj(String pKykdairinmkj) {
        kykdairinmkj = pKykdairinmkj;
    }

    private String bankcd;

    @Column(name=GenBT_IdouSkMeigiItjhzn.BANKCD)
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

    @Column(name=GenBT_IdouSkMeigiItjhzn.SITENCD)
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
    @Column(name=GenBT_IdouSkMeigiItjhzn.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenBT_IdouSkMeigiItjhzn.KOUZANO)
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

    @Column(name=GenBT_IdouSkMeigiItjhzn.KZMEIGINMKN)
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

    private C_KzkykdouKbn kzkykdoukbn;

    @Type(type="UserType_C_KzkykdouKbn")
    @Column(name=GenBT_IdouSkMeigiItjhzn.KZKYKDOUKBN)
    public C_KzkykdouKbn getKzkykdoukbn() {
        return kzkykdoukbn;
    }

    public void setKzkykdoukbn(C_KzkykdouKbn pKzkykdoukbn) {
        kzkykdoukbn = pKzkykdoukbn;
    }

    private String kzktourokunmkn1;

    @Column(name=GenBT_IdouSkMeigiItjhzn.KZKTOUROKUNMKN1)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getKzktourokunmkn1() {
        return kzktourokunmkn1;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKzktourokunmkn1(String pKzktourokunmkn1) {
        kzktourokunmkn1 = pKzktourokunmkn1;
    }

    private String kzktourokunmkj1;

    @Column(name=GenBT_IdouSkMeigiItjhzn.KZKTOUROKUNMKJ1)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getKzktourokunmkj1() {
        return kzktourokunmkj1;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKzktourokunmkj1(String pKzktourokunmkj1) {
        kzktourokunmkj1 = pKzktourokunmkj1;
    }

    private String kzktourokunmkn2;

    @Column(name=GenBT_IdouSkMeigiItjhzn.KZKTOUROKUNMKN2)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getKzktourokunmkn2() {
        return kzktourokunmkn2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKzktourokunmkn2(String pKzktourokunmkn2) {
        kzktourokunmkn2 = pKzktourokunmkn2;
    }

    private String kzktourokunmkj2;

    @Column(name=GenBT_IdouSkMeigiItjhzn.KZKTOUROKUNMKJ2)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getKzktourokunmkj2() {
        return kzktourokunmkj2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKzktourokunmkj2(String pKzktourokunmkj2) {
        kzktourokunmkj2 = pKzktourokunmkj2;
    }
}