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
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.IT_KhHubi;
import yuyu.def.db.id.PKIT_KhHubi;
import yuyu.def.db.meta.GenQIT_KhHubi;
import yuyu.def.db.meta.QIT_KhHubi;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全不備テーブル テーブルのマッピング情報クラスで、 {@link IT_KhHubi} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhHubi}</td><td colspan="3">契約保全不備テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getHubisikibetukey hubisikibetukey}</td><td>不備識別キー</td><td align="center">{@link PKIT_KhHubi ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJimuttdknm jimuttdknm}</td><td>契約管理事務手続名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenrakusakinmkj renrakusakinmkj}</td><td>連絡先氏名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenrakuyno renrakuyno}</td><td>連絡先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenrakusakiadr1kj renrakusakiadr1kj}</td><td>連絡先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenrakusakiadr2kj renrakusakiadr2kj}</td><td>連絡先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenrakusakiadr3kj renrakusakiadr3kj}</td><td>連絡先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenrakusakitelno renrakusakitelno}</td><td>連絡先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenrakuarea renrakuarea}</td><td>連絡欄</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHubianswerkjt hubianswerkjt}</td><td>不備回答期日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSksreadymd sksreadymd}</td><td>請求書読込日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHassinsakifsthubihasinymd1 hassinsakifsthubihasinymd1}</td><td>発信先別初回不備発信日１</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHassinsakifsthubihasinymd2 hassinsakifsthubihasinymd2}</td><td>発信先別初回不備発信日２</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHassinsakikaisuu1 hassinsakikaisuu1}</td><td>発信先別発信回数１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHassinsakikaisuu2 hassinsakikaisuu2}</td><td>発信先別発信回数２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KhHubi
 * @see     PKIT_KhHubi
 * @see     QIT_KhHubi
 * @see     GenQIT_KhHubi
 */
@MappedSuperclass
@Table(name=GenIT_KhHubi.TABLE_NAME)
@IdClass(value=PKIT_KhHubi.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class)
})
public abstract class GenIT_KhHubi extends AbstractExDBEntity<IT_KhHubi, PKIT_KhHubi> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_KhHubi";
    public static final String HUBISIKIBETUKEY          = "hubisikibetukey";
    public static final String SYONO                    = "syono";
    public static final String JIMUTTDKNM               = "jimuttdknm";
    public static final String RENRAKUSAKINMKJ          = "renrakusakinmkj";
    public static final String RENRAKUYNO               = "renrakuyno";
    public static final String RENRAKUSAKIADR1KJ        = "renrakusakiadr1kj";
    public static final String RENRAKUSAKIADR2KJ        = "renrakusakiadr2kj";
    public static final String RENRAKUSAKIADR3KJ        = "renrakusakiadr3kj";
    public static final String RENRAKUSAKITELNO         = "renrakusakitelno";
    public static final String RENRAKUAREA              = "renrakuarea";
    public static final String HUBIANSWERKJT            = "hubianswerkjt";
    public static final String SKSREADYMD               = "sksreadymd";
    public static final String HASSINSAKIFSTHUBIHASINYMD1 = "hassinsakifsthubihasinymd1";
    public static final String HASSINSAKIFSTHUBIHASINYMD2 = "hassinsakifsthubihasinymd2";
    public static final String HASSINSAKIKAISUU1        = "hassinsakikaisuu1";
    public static final String HASSINSAKIKAISUU2        = "hassinsakikaisuu2";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_KhHubi primaryKey;

    public GenIT_KhHubi() {
        primaryKey = new PKIT_KhHubi();
    }

    public GenIT_KhHubi(String pHubisikibetukey) {
        primaryKey = new PKIT_KhHubi(pHubisikibetukey);
    }

    @Transient
    @Override
    public PKIT_KhHubi getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_KhHubi> getMetaClass() {
        return QIT_KhHubi.class;
    }

    @Id
    @Column(name=GenIT_KhHubi.HUBISIKIBETUKEY)
    public String getHubisikibetukey() {
        return getPrimaryKey().getHubisikibetukey();
    }

    public void setHubisikibetukey(String pHubisikibetukey) {
        getPrimaryKey().setHubisikibetukey(pHubisikibetukey);
    }

    private String syono;

    @Column(name=GenIT_KhHubi.SYONO)
    @SyoukenNo
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private String jimuttdknm;

    @Column(name=GenIT_KhHubi.JIMUTTDKNM)
    public String getJimuttdknm() {
        return jimuttdknm;
    }

    public void setJimuttdknm(String pJimuttdknm) {
        jimuttdknm = pJimuttdknm;
    }

    private String renrakusakinmkj;

    @Column(name=GenIT_KhHubi.RENRAKUSAKINMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getRenrakusakinmkj() {
        return renrakusakinmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setRenrakusakinmkj(String pRenrakusakinmkj) {
        renrakusakinmkj = pRenrakusakinmkj;
    }

    private String renrakuyno;

    @Column(name=GenIT_KhHubi.RENRAKUYNO)
    @Length(length=7)
    @SingleByteStrings
    @Digit
    public String getRenrakuyno() {
        return renrakuyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRenrakuyno(String pRenrakuyno) {
        renrakuyno = pRenrakuyno;
    }

    private String renrakusakiadr1kj;

    @Column(name=GenIT_KhHubi.RENRAKUSAKIADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getRenrakusakiadr1kj() {
        return renrakusakiadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setRenrakusakiadr1kj(String pRenrakusakiadr1kj) {
        renrakusakiadr1kj = pRenrakusakiadr1kj;
    }

    private String renrakusakiadr2kj;

    @Column(name=GenIT_KhHubi.RENRAKUSAKIADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getRenrakusakiadr2kj() {
        return renrakusakiadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setRenrakusakiadr2kj(String pRenrakusakiadr2kj) {
        renrakusakiadr2kj = pRenrakusakiadr2kj;
    }

    private String renrakusakiadr3kj;

    @Column(name=GenIT_KhHubi.RENRAKUSAKIADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getRenrakusakiadr3kj() {
        return renrakusakiadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setRenrakusakiadr3kj(String pRenrakusakiadr3kj) {
        renrakusakiadr3kj = pRenrakusakiadr3kj;
    }

    private String renrakusakitelno;

    @Column(name=GenIT_KhHubi.RENRAKUSAKITELNO)
    @MaxLength(max=14)
    @SingleByteStrings
    public String getRenrakusakitelno() {
        return renrakusakitelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRenrakusakitelno(String pRenrakusakitelno) {
        renrakusakitelno = pRenrakusakitelno;
    }

    private String renrakuarea;

    @Column(name=GenIT_KhHubi.RENRAKUAREA)
    @ValidTextArea(length=40, rows=10)
    @MultiByteStringsReturnable
    @InvalidCharacter
    public String getRenrakuarea() {
        return renrakuarea;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setRenrakuarea(String pRenrakuarea) {
        renrakuarea = pRenrakuarea;
    }

    private BizDate hubianswerkjt;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhHubi.HUBIANSWERKJT)
    @ValidDate
    public BizDate getHubianswerkjt() {
        return hubianswerkjt;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHubianswerkjt(BizDate pHubianswerkjt) {
        hubianswerkjt = pHubianswerkjt;
    }

    private BizDate sksreadymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhHubi.SKSREADYMD)
    public BizDate getSksreadymd() {
        return sksreadymd;
    }

    public void setSksreadymd(BizDate pSksreadymd) {
        sksreadymd = pSksreadymd;
    }

    private BizDate hassinsakifsthubihasinymd1;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhHubi.HASSINSAKIFSTHUBIHASINYMD1)
    public BizDate getHassinsakifsthubihasinymd1() {
        return hassinsakifsthubihasinymd1;
    }

    public void setHassinsakifsthubihasinymd1(BizDate pHassinsakifsthubihasinymd1) {
        hassinsakifsthubihasinymd1 = pHassinsakifsthubihasinymd1;
    }

    private BizDate hassinsakifsthubihasinymd2;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhHubi.HASSINSAKIFSTHUBIHASINYMD2)
    public BizDate getHassinsakifsthubihasinymd2() {
        return hassinsakifsthubihasinymd2;
    }

    public void setHassinsakifsthubihasinymd2(BizDate pHassinsakifsthubihasinymd2) {
        hassinsakifsthubihasinymd2 = pHassinsakifsthubihasinymd2;
    }

    private Integer hassinsakikaisuu1;

    @Column(name=GenIT_KhHubi.HASSINSAKIKAISUU1)
    public Integer getHassinsakikaisuu1() {
        return hassinsakikaisuu1;
    }

    public void setHassinsakikaisuu1(Integer pHassinsakikaisuu1) {
        hassinsakikaisuu1 = pHassinsakikaisuu1;
    }

    private Integer hassinsakikaisuu2;

    @Column(name=GenIT_KhHubi.HASSINSAKIKAISUU2)
    public Integer getHassinsakikaisuu2() {
        return hassinsakikaisuu2;
    }

    public void setHassinsakikaisuu2(Integer pHassinsakikaisuu2) {
        hassinsakikaisuu2 = pHassinsakikaisuu2;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_KhHubi.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_KhHubi.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}