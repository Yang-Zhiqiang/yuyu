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
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.db.entity.JV_SmbcSibouInfoRendou;
import yuyu.def.db.id.PKJV_SmbcSibouInfoRendou;
import yuyu.def.db.meta.GenQJV_SmbcSibouInfoRendou;
import yuyu.def.db.meta.QJV_SmbcSibouInfoRendou;
import yuyu.def.db.type.UserType_C_SeikyuuSyubetu;
import yuyu.def.db.type.UserType_C_SeikyuusyaKbn;
import yuyu.def.db.type.UserType_C_ShrKekkaKbn;
import yuyu.def.db.type.UserType_C_UktKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;
import yuyu.infr.validation.constraints.Tel;

/**
 * ＳＭＢＣ死亡情報連動ビュー テーブルのマッピング情報クラスで、 {@link JV_SmbcSibouInfoRendou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JV_SmbcSibouInfoRendou}</td><td colspan="3">ＳＭＢＣ死亡情報連動ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJV_SmbcSibouInfoRendou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">{@link PKJV_SmbcSibouInfoRendou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSeikyuusyubetu seikyuusyubetu}</td><td>請求種別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SeikyuuSyubetu}</td></tr>
 *  <tr><td>{@link #getSibouymd sibouymd}</td><td>死亡日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSbuktnin sbuktnin}</td><td>死亡受取人人数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getUktkbn uktkbn}</td><td>受取人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UktKbn}</td></tr>
 *  <tr><td>{@link #getUktnmkn uktnmkn}</td><td>受取人名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUktnmkj uktnmkj}</td><td>受取人名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkn kyknmkn}</td><td>契約者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkj kyknmkj}</td><td>契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuusyakbn seikyuusyakbn}</td><td>請求者区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SeikyuusyaKbn}</td></tr>
 *  <tr><td>{@link #getSeikyuusyanmkn seikyuusyanmkn}</td><td>請求者（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuusyanmkj seikyuusyanmkj}</td><td>請求者（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuusyaseiymd seikyuusyaseiymd}</td><td>請求者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTsinadr1kj tsinadr1kj}</td><td>通信先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr2kj tsinadr2kj}</td><td>通信先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr3kj tsinadr3kj}</td><td>通信先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsintelno tsintelno}</td><td>通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoruiukeymd syoruiukeymd}</td><td>書類受付日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHubikanryouymd hubikanryouymd}</td><td>不備完了日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShrsyoriymd shrsyoriymd}</td><td>支払処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShrkekkakbn shrkekkakbn}</td><td>支払結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ShrKekkaKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JV_SmbcSibouInfoRendou
 * @see     PKJV_SmbcSibouInfoRendou
 * @see     QJV_SmbcSibouInfoRendou
 * @see     GenQJV_SmbcSibouInfoRendou
 */
@MappedSuperclass
@Table(name=GenJV_SmbcSibouInfoRendou.TABLE_NAME)
@IdClass(value=PKJV_SmbcSibouInfoRendou.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_SeikyuuSyubetu", typeClass=UserType_C_SeikyuuSyubetu.class),
    @TypeDef(name="UserType_C_SeikyuusyaKbn", typeClass=UserType_C_SeikyuusyaKbn.class),
    @TypeDef(name="UserType_C_ShrKekkaKbn", typeClass=UserType_C_ShrKekkaKbn.class),
    @TypeDef(name="UserType_C_UktKbn", typeClass=UserType_C_UktKbn.class)
})
public abstract class GenJV_SmbcSibouInfoRendou extends AbstractExDBEntity<JV_SmbcSibouInfoRendou, PKJV_SmbcSibouInfoRendou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JV_SmbcSibouInfoRendou";
    public static final String SYONO                    = "syono";
    public static final String SKNO                     = "skno";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String SEIKYUUSYUBETU           = "seikyuusyubetu";
    public static final String SIBOUYMD                 = "sibouymd";
    public static final String SBUKTNIN                 = "sbuktnin";
    public static final String UKTKBN                   = "uktkbn";
    public static final String UKTNMKN                  = "uktnmkn";
    public static final String UKTNMKJ                  = "uktnmkj";
    public static final String KYKNMKN                  = "kyknmkn";
    public static final String KYKNMKJ                  = "kyknmkj";
    public static final String SEIKYUUSYAKBN            = "seikyuusyakbn";
    public static final String SEIKYUUSYANMKN           = "seikyuusyanmkn";
    public static final String SEIKYUUSYANMKJ           = "seikyuusyanmkj";
    public static final String SEIKYUUSYASEIYMD         = "seikyuusyaseiymd";
    public static final String TSINADR1KJ               = "tsinadr1kj";
    public static final String TSINADR2KJ               = "tsinadr2kj";
    public static final String TSINADR3KJ               = "tsinadr3kj";
    public static final String TSINTELNO                = "tsintelno";
    public static final String SYORUIUKEYMD             = "syoruiukeymd";
    public static final String HUBIKANRYOUYMD           = "hubikanryouymd";
    public static final String SHRSYORIYMD              = "shrsyoriymd";
    public static final String SHRKEKKAKBN              = "shrkekkakbn";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJV_SmbcSibouInfoRendou primaryKey;

    public GenJV_SmbcSibouInfoRendou() {
        primaryKey = new PKJV_SmbcSibouInfoRendou();
    }

    public GenJV_SmbcSibouInfoRendou(String pSyono, String pSkno) {
        primaryKey = new PKJV_SmbcSibouInfoRendou(pSyono, pSkno);
    }

    @Transient
    @Override
    public PKJV_SmbcSibouInfoRendou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJV_SmbcSibouInfoRendou> getMetaClass() {
        return QJV_SmbcSibouInfoRendou.class;
    }

    @Id
    @Column(name=GenJV_SmbcSibouInfoRendou.SYONO)
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
    @Column(name=GenJV_SmbcSibouInfoRendou.SKNO)
    public String getSkno() {
        return getPrimaryKey().getSkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        getPrimaryKey().setSkno(pSkno);
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenJV_SmbcSibouInfoRendou.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    private C_SeikyuuSyubetu seikyuusyubetu;

    @Type(type="UserType_C_SeikyuuSyubetu")
    @Column(name=GenJV_SmbcSibouInfoRendou.SEIKYUUSYUBETU)
    public C_SeikyuuSyubetu getSeikyuusyubetu() {
        return seikyuusyubetu;
    }

    public void setSeikyuusyubetu(C_SeikyuuSyubetu pSeikyuusyubetu) {
        seikyuusyubetu = pSeikyuusyubetu;
    }

    private BizDate sibouymd;

    @Type(type="BizDateType")
    @Column(name=GenJV_SmbcSibouInfoRendou.SIBOUYMD)
    @ValidDate
    public BizDate getSibouymd() {
        return sibouymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSibouymd(BizDate pSibouymd) {
        sibouymd = pSibouymd;
    }

    private Integer sbuktnin;

    @Column(name=GenJV_SmbcSibouInfoRendou.SBUKTNIN)
    @Range(min="0", max="99")
    public Integer getSbuktnin() {
        return sbuktnin;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSbuktnin(Integer pSbuktnin) {
        sbuktnin = pSbuktnin;
    }

    private C_UktKbn uktkbn;

    @Type(type="UserType_C_UktKbn")
    @Column(name=GenJV_SmbcSibouInfoRendou.UKTKBN)
    public C_UktKbn getUktkbn() {
        return uktkbn;
    }

    public void setUktkbn(C_UktKbn pUktkbn) {
        uktkbn = pUktkbn;
    }

    private String uktnmkn;

    @Column(name=GenJV_SmbcSibouInfoRendou.UKTNMKN)
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

    @Column(name=GenJV_SmbcSibouInfoRendou.UKTNMKJ)
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

    private String kyknmkn;

    @Column(name=GenJV_SmbcSibouInfoRendou.KYKNMKN)
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

    @Column(name=GenJV_SmbcSibouInfoRendou.KYKNMKJ)
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

    private C_SeikyuusyaKbn seikyuusyakbn;

    @Type(type="UserType_C_SeikyuusyaKbn")
    @Column(name=GenJV_SmbcSibouInfoRendou.SEIKYUUSYAKBN)
    public C_SeikyuusyaKbn getSeikyuusyakbn() {
        return seikyuusyakbn;
    }

    public void setSeikyuusyakbn(C_SeikyuusyaKbn pSeikyuusyakbn) {
        seikyuusyakbn = pSeikyuusyakbn;
    }

    private String seikyuusyanmkn;

    @Column(name=GenJV_SmbcSibouInfoRendou.SEIKYUUSYANMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getSeikyuusyanmkn() {
        return seikyuusyanmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSeikyuusyanmkn(String pSeikyuusyanmkn) {
        seikyuusyanmkn = pSeikyuusyanmkn;
    }

    private String seikyuusyanmkj;

    @Column(name=GenJV_SmbcSibouInfoRendou.SEIKYUUSYANMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getSeikyuusyanmkj() {
        return seikyuusyanmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSeikyuusyanmkj(String pSeikyuusyanmkj) {
        seikyuusyanmkj = pSeikyuusyanmkj;
    }

    private BizDate seikyuusyaseiymd;

    @Type(type="BizDateType")
    @Column(name=GenJV_SmbcSibouInfoRendou.SEIKYUUSYASEIYMD)
    @ValidDate
    public BizDate getSeikyuusyaseiymd() {
        return seikyuusyaseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSeikyuusyaseiymd(BizDate pSeikyuusyaseiymd) {
        seikyuusyaseiymd = pSeikyuusyaseiymd;
    }

    private String tsinadr1kj;

    @Column(name=GenJV_SmbcSibouInfoRendou.TSINADR1KJ)
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

    @Column(name=GenJV_SmbcSibouInfoRendou.TSINADR2KJ)
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

    @Column(name=GenJV_SmbcSibouInfoRendou.TSINADR3KJ)
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

    @Column(name=GenJV_SmbcSibouInfoRendou.TSINTELNO)
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

    private BizDate syoruiukeymd;

    @Type(type="BizDateType")
    @Column(name=GenJV_SmbcSibouInfoRendou.SYORUIUKEYMD)
    @ValidDate
    public BizDate getSyoruiukeymd() {
        return syoruiukeymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoruiukeymd(BizDate pSyoruiukeymd) {
        syoruiukeymd = pSyoruiukeymd;
    }

    private BizDate hubikanryouymd;

    @Type(type="BizDateType")
    @Column(name=GenJV_SmbcSibouInfoRendou.HUBIKANRYOUYMD)
    @ValidDate
    public BizDate getHubikanryouymd() {
        return hubikanryouymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHubikanryouymd(BizDate pHubikanryouymd) {
        hubikanryouymd = pHubikanryouymd;
    }

    private BizDate shrsyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenJV_SmbcSibouInfoRendou.SHRSYORIYMD)
    @ValidDate
    public BizDate getShrsyoriymd() {
        return shrsyoriymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShrsyoriymd(BizDate pShrsyoriymd) {
        shrsyoriymd = pShrsyoriymd;
    }

    private C_ShrKekkaKbn shrkekkakbn;

    @Type(type="UserType_C_ShrKekkaKbn")
    @Column(name=GenJV_SmbcSibouInfoRendou.SHRKEKKAKBN)
    public C_ShrKekkaKbn getShrkekkakbn() {
        return shrkekkakbn;
    }

    public void setShrkekkakbn(C_ShrKekkaKbn pShrkekkakbn) {
        shrkekkakbn = pShrkekkakbn;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJV_SmbcSibouInfoRendou.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}