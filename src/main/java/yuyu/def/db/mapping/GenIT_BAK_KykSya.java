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
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.Pattern;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HjndaiykKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Tdk;
import yuyu.def.db.entity.IT_BAK_KykSya;
import yuyu.def.db.id.PKIT_BAK_KykSya;
import yuyu.def.db.meta.GenQIT_BAK_KykSya;
import yuyu.def.db.meta.QIT_BAK_KykSya;
import yuyu.def.db.type.UserType_C_HjndaiykKbn;
import yuyu.def.db.type.UserType_C_KjkhukaKbn;
import yuyu.def.db.type.UserType_C_Kyksei;
import yuyu.def.db.type.UserType_C_Tdk;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;
import yuyu.infr.validation.constraints.Tel;

/**
 * 契約者バックアップテーブル テーブルのマッピング情報クラスで、 {@link IT_BAK_KykSya} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_KykSya}</td><td colspan="3">契約者バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_BAK_KykSya ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_BAK_KykSya ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKIT_BAK_KykSya ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKokno kokno}</td><td>顧客番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyksakuinmeino kyksakuinmeino}</td><td>契約者索引名番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkn kyknmkn}</td><td>契約者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkj kyknmkj}</td><td>契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkjkhukakbn kyknmkjkhukakbn}</td><td>契約者名漢字化不可区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KjkhukaKbn}</td></tr>
 *  <tr><td>{@link #getKykseiymd kykseiymd}</td><td>契約者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKyksei kyksei}</td><td>契約者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kyksei}</td></tr>
 *  <tr><td>{@link #getKkkyktdk kkkyktdk}</td><td>契約管理契約者続柄</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tdk}</td></tr>
 *  <tr><td>{@link #getTsinyno tsinyno}</td><td>通信先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr1kn tsinadr1kn}</td><td>通信先住所１（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr1kj tsinadr1kj}</td><td>通信先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr2kn tsinadr2kn}</td><td>通信先住所２（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr2kj tsinadr2kj}</td><td>通信先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr3kn tsinadr3kn}</td><td>通信先住所３（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr3kj tsinadr3kj}</td><td>通信先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsintelno tsintelno}</td><td>通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai2tsintelno dai2tsintelno}</td><td>第２通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinmailaddress tsinmailaddress}</td><td>通信先メールアドレス</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKinmusakinm kinmusakinm}</td><td>勤務先名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHjndaiykkbn hjndaiykkbn}</td><td>法人代表者役職区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HjndaiykKbn}</td></tr>
 *  <tr><td>{@link #getHjndaiyknm hjndaiyknm}</td><td>法人代表者役職名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHjndainmkn hjndainmkn}</td><td>法人代表者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHjndainmkj hjndainmkj}</td><td>法人代表者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_KykSya
 * @see     PKIT_BAK_KykSya
 * @see     QIT_BAK_KykSya
 * @see     GenQIT_BAK_KykSya
 */
@MappedSuperclass
@Table(name=GenIT_BAK_KykSya.TABLE_NAME)
@IdClass(value=PKIT_BAK_KykSya.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HjndaiykKbn", typeClass=UserType_C_HjndaiykKbn.class),
    @TypeDef(name="UserType_C_KjkhukaKbn", typeClass=UserType_C_KjkhukaKbn.class),
    @TypeDef(name="UserType_C_Kyksei", typeClass=UserType_C_Kyksei.class),
    @TypeDef(name="UserType_C_Tdk", typeClass=UserType_C_Tdk.class)
})
public abstract class GenIT_BAK_KykSya extends AbstractExDBEntity<IT_BAK_KykSya, PKIT_BAK_KykSya> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_BAK_KykSya";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String KOKNO                    = "kokno";
    public static final String KYKSAKUINMEINO           = "kyksakuinmeino";
    public static final String KYKNMKN                  = "kyknmkn";
    public static final String KYKNMKJ                  = "kyknmkj";
    public static final String KYKNMKJKHUKAKBN          = "kyknmkjkhukakbn";
    public static final String KYKSEIYMD                = "kykseiymd";
    public static final String KYKSEI                   = "kyksei";
    public static final String KKKYKTDK                 = "kkkyktdk";
    public static final String TSINYNO                  = "tsinyno";
    public static final String TSINADR1KN               = "tsinadr1kn";
    public static final String TSINADR1KJ               = "tsinadr1kj";
    public static final String TSINADR2KN               = "tsinadr2kn";
    public static final String TSINADR2KJ               = "tsinadr2kj";
    public static final String TSINADR3KN               = "tsinadr3kn";
    public static final String TSINADR3KJ               = "tsinadr3kj";
    public static final String TSINTELNO                = "tsintelno";
    public static final String DAI2TSINTELNO            = "dai2tsintelno";
    public static final String TSINMAILADDRESS          = "tsinmailaddress";
    public static final String KINMUSAKINM              = "kinmusakinm";
    public static final String HJNDAIYKKBN              = "hjndaiykkbn";
    public static final String HJNDAIYKNM               = "hjndaiyknm";
    public static final String HJNDAINMKN               = "hjndainmkn";
    public static final String HJNDAINMKJ               = "hjndainmkj";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_BAK_KykSya primaryKey;

    public GenIT_BAK_KykSya() {
        primaryKey = new PKIT_BAK_KykSya();
    }

    public GenIT_BAK_KykSya(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey
    ) {
        primaryKey = new PKIT_BAK_KykSya(
            pKbnkey,
            pSyono,
            pTrkssikibetukey
        );
    }

    @Transient
    @Override
    public PKIT_BAK_KykSya getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_BAK_KykSya> getMetaClass() {
        return QIT_BAK_KykSya.class;
    }

    @Id
    @Column(name=GenIT_BAK_KykSya.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_BAK_KykSya.SYONO)
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
    @Column(name=GenIT_BAK_KykSya.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    private String kokno;

    @Column(name=GenIT_BAK_KykSya.KOKNO)
    public String getKokno() {
        return kokno;
    }

    public void setKokno(String pKokno) {
        kokno = pKokno;
    }

    private String kyksakuinmeino;

    @Column(name=GenIT_BAK_KykSya.KYKSAKUINMEINO)
    public String getKyksakuinmeino() {
        return kyksakuinmeino;
    }

    public void setKyksakuinmeino(String pKyksakuinmeino) {
        kyksakuinmeino = pKyksakuinmeino;
    }

    private String kyknmkn;

    @Column(name=GenIT_BAK_KykSya.KYKNMKN)
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

    @Column(name=GenIT_BAK_KykSya.KYKNMKJ)
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

    private C_KjkhukaKbn kyknmkjkhukakbn;

    @Type(type="UserType_C_KjkhukaKbn")
    @Column(name=GenIT_BAK_KykSya.KYKNMKJKHUKAKBN)
    public C_KjkhukaKbn getKyknmkjkhukakbn() {
        return kyknmkjkhukakbn;
    }

    public void setKyknmkjkhukakbn(C_KjkhukaKbn pKyknmkjkhukakbn) {
        kyknmkjkhukakbn = pKyknmkjkhukakbn;
    }

    private BizDate kykseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KykSya.KYKSEIYMD)
    @ValidDate
    public BizDate getKykseiymd() {
        return kykseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykseiymd(BizDate pKykseiymd) {
        kykseiymd = pKykseiymd;
    }

    private C_Kyksei kyksei;

    @Type(type="UserType_C_Kyksei")
    @Column(name=GenIT_BAK_KykSya.KYKSEI)
    public C_Kyksei getKyksei() {
        return kyksei;
    }

    public void setKyksei(C_Kyksei pKyksei) {
        kyksei = pKyksei;
    }

    private C_Tdk kkkyktdk;

    @Type(type="UserType_C_Tdk")
    @Column(name=GenIT_BAK_KykSya.KKKYKTDK)
    public C_Tdk getKkkyktdk() {
        return kkkyktdk;
    }

    public void setKkkyktdk(C_Tdk pKkkyktdk) {
        kkkyktdk = pKkkyktdk;
    }

    private String tsinyno;

    @Column(name=GenIT_BAK_KykSya.TSINYNO)
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

    private String tsinadr1kn;

    @Column(name=GenIT_BAK_KykSya.TSINADR1KN)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr1kn() {
        return tsinadr1kn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr1kn(String pTsinadr1kn) {
        tsinadr1kn = pTsinadr1kn;
    }

    private String tsinadr1kj;

    @Column(name=GenIT_BAK_KykSya.TSINADR1KJ)
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

    private String tsinadr2kn;

    @Column(name=GenIT_BAK_KykSya.TSINADR2KN)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr2kn() {
        return tsinadr2kn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr2kn(String pTsinadr2kn) {
        tsinadr2kn = pTsinadr2kn;
    }

    private String tsinadr2kj;

    @Column(name=GenIT_BAK_KykSya.TSINADR2KJ)
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

    private String tsinadr3kn;

    @Column(name=GenIT_BAK_KykSya.TSINADR3KN)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr3kn() {
        return tsinadr3kn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr3kn(String pTsinadr3kn) {
        tsinadr3kn = pTsinadr3kn;
    }

    private String tsinadr3kj;

    @Column(name=GenIT_BAK_KykSya.TSINADR3KJ)
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

    @Column(name=GenIT_BAK_KykSya.TSINTELNO)
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

    private String dai2tsintelno;

    @Column(name=GenIT_BAK_KykSya.DAI2TSINTELNO)
    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    public String getDai2tsintelno() {
        return dai2tsintelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDai2tsintelno(String pDai2tsintelno) {
        dai2tsintelno = pDai2tsintelno;
    }

    private String tsinmailaddress;

    @Column(name=GenIT_BAK_KykSya.TSINMAILADDRESS)
    @MaxLength(max=40)
    @Pattern(message="{pattern.MailAddress.message}", regex="^[\\w!#$%&'*+/=?^_{}\\\\|~-][\\w!#$%&'*+/=?^_{}\\\\|~\\.-]{0,63}@([\\w][\\w-]*\\.)+[\\w][\\w-]*$")
    public String getTsinmailaddress() {
        return tsinmailaddress;
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setTsinmailaddress(String pTsinmailaddress) {
        tsinmailaddress = pTsinmailaddress;
    }

    private String kinmusakinm;

    @Column(name=GenIT_BAK_KykSya.KINMUSAKINM)
    @MaxLength(max=25)
    @MultiByteStrings
    @InvalidCharacter
    public String getKinmusakinm() {
        return kinmusakinm;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKinmusakinm(String pKinmusakinm) {
        kinmusakinm = pKinmusakinm;
    }

    private C_HjndaiykKbn hjndaiykkbn;

    @Type(type="UserType_C_HjndaiykKbn")
    @Column(name=GenIT_BAK_KykSya.HJNDAIYKKBN)
    public C_HjndaiykKbn getHjndaiykkbn() {
        return hjndaiykkbn;
    }

    public void setHjndaiykkbn(C_HjndaiykKbn pHjndaiykkbn) {
        hjndaiykkbn = pHjndaiykkbn;
    }

    private String hjndaiyknm;

    @Column(name=GenIT_BAK_KykSya.HJNDAIYKNM)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getHjndaiyknm() {
        return hjndaiyknm;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHjndaiyknm(String pHjndaiyknm) {
        hjndaiyknm = pHjndaiyknm;
    }

    private String hjndainmkn;

    @Column(name=GenIT_BAK_KykSya.HJNDAINMKN)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getHjndainmkn() {
        return hjndainmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHjndainmkn(String pHjndainmkn) {
        hjndainmkn = pHjndainmkn;
    }

    private String hjndainmkj;

    @Column(name=GenIT_BAK_KykSya.HJNDAINMKJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getHjndainmkj() {
        return hjndainmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHjndainmkj(String pHjndainmkj) {
        hjndainmkj = pHjndainmkj;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_BAK_KykSya.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_BAK_KykSya.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_BAK_KykSya.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}