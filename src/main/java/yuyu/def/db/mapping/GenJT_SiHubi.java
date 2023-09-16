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
import jp.co.slcs.swak.validation.constraints.AlphaDigitOrExceptionCode;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.NaturalNumber;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.JT_SiHubi;
import yuyu.def.db.id.PKJT_SiHubi;
import yuyu.def.db.meta.GenQJT_SiHubi;
import yuyu.def.db.meta.QJT_SiHubi;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 支払不備テーブル テーブルのマッピング情報クラスで、 {@link JT_SiHubi} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SiHubi}</td><td colspan="3">支払不備テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getHubisikibetukey hubisikibetukey}</td><td>不備識別キー</td><td align="center">{@link PKJT_SiHubi ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJimutetuzukinm jimutetuzukinm}</td><td>事務手続名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenrakusakinmkj renrakusakinmkj}</td><td>連絡先氏名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenrakuyno renrakuyno}</td><td>連絡先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenrakusakiadr1kj renrakusakiadr1kj}</td><td>連絡先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenrakusakiadr2kj renrakusakiadr2kj}</td><td>連絡先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenrakusakiadr3kj renrakusakiadr3kj}</td><td>連絡先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenrakusakitelno renrakusakitelno}</td><td>連絡先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenrakuarea renrakuarea}</td><td>連絡欄</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHassinsakifsthubihasinymd1 hassinsakifsthubihasinymd1}</td><td>発信先別初回不備発信日１</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHassinsakifsthubihasinymd2 hassinsakifsthubihasinymd2}</td><td>発信先別初回不備発信日２</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHasinsakibetuhubihasinymd3 hasinsakibetuhubihasinymd3}</td><td>発信先別初回不備発信日３</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHassinsakikaisuu1 hassinsakikaisuu1}</td><td>発信先別発信回数１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHassinsakikaisuu2 hassinsakikaisuu2}</td><td>発信先別発信回数２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHasinsakibetuhasinkaisuu3 hasinsakibetuhasinkaisuu3}</td><td>発信先別発信回数３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSisyacd sisyacd}</td><td>支社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSisyanm sisyanm}</td><td>支社名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasesosikinmkj toiawasesosikinmkj}</td><td>問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasetelno toiawasetelno}</td><td>問合せ先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SiHubi
 * @see     PKJT_SiHubi
 * @see     QJT_SiHubi
 * @see     GenQJT_SiHubi
 */
@MappedSuperclass
@Table(name=GenJT_SiHubi.TABLE_NAME)
@IdClass(value=PKJT_SiHubi.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class)
})
public abstract class GenJT_SiHubi extends AbstractExDBEntity<JT_SiHubi, PKJT_SiHubi> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_SiHubi";
    public static final String HUBISIKIBETUKEY          = "hubisikibetukey";
    public static final String SYONO                    = "syono";
    public static final String JIMUTETUZUKINM           = "jimutetuzukinm";
    public static final String RENRAKUSAKINMKJ          = "renrakusakinmkj";
    public static final String RENRAKUYNO               = "renrakuyno";
    public static final String RENRAKUSAKIADR1KJ        = "renrakusakiadr1kj";
    public static final String RENRAKUSAKIADR2KJ        = "renrakusakiadr2kj";
    public static final String RENRAKUSAKIADR3KJ        = "renrakusakiadr3kj";
    public static final String RENRAKUSAKITELNO         = "renrakusakitelno";
    public static final String RENRAKUAREA              = "renrakuarea";
    public static final String HASSINSAKIFSTHUBIHASINYMD1 = "hassinsakifsthubihasinymd1";
    public static final String HASSINSAKIFSTHUBIHASINYMD2 = "hassinsakifsthubihasinymd2";
    public static final String HASINSAKIBETUHUBIHASINYMD3 = "hasinsakibetuhubihasinymd3";
    public static final String HASSINSAKIKAISUU1        = "hassinsakikaisuu1";
    public static final String HASSINSAKIKAISUU2        = "hassinsakikaisuu2";
    public static final String HASINSAKIBETUHASINKAISUU3 = "hasinsakibetuhasinkaisuu3";
    public static final String SISYACD                  = "sisyacd";
    public static final String SISYANM                  = "sisyanm";
    public static final String TOIAWASESOSIKINMKJ       = "toiawasesosikinmkj";
    public static final String TOIAWASETELNO            = "toiawasetelno";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_SiHubi primaryKey;

    public GenJT_SiHubi() {
        primaryKey = new PKJT_SiHubi();
    }

    public GenJT_SiHubi(String pHubisikibetukey) {
        primaryKey = new PKJT_SiHubi(pHubisikibetukey);
    }

    @Transient
    @Override
    public PKJT_SiHubi getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_SiHubi> getMetaClass() {
        return QJT_SiHubi.class;
    }

    @Id
    @Column(name=GenJT_SiHubi.HUBISIKIBETUKEY)
    public String getHubisikibetukey() {
        return getPrimaryKey().getHubisikibetukey();
    }

    public void setHubisikibetukey(String pHubisikibetukey) {
        getPrimaryKey().setHubisikibetukey(pHubisikibetukey);
    }

    private String syono;

    @Column(name=GenJT_SiHubi.SYONO)
    @SyoukenNo
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private String jimutetuzukinm;

    @Column(name=GenJT_SiHubi.JIMUTETUZUKINM)
    @InvalidCharacter
    @MaxLength(max=20)
    @MultiByteStrings
    public String getJimutetuzukinm() {
        return jimutetuzukinm;
    }

    @DataConvert("toMultiByte")
    public void setJimutetuzukinm(String pJimutetuzukinm) {
        jimutetuzukinm = pJimutetuzukinm;
    }

    private String renrakusakinmkj;

    @Column(name=GenJT_SiHubi.RENRAKUSAKINMKJ)
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

    @Column(name=GenJT_SiHubi.RENRAKUYNO)
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

    @Column(name=GenJT_SiHubi.RENRAKUSAKIADR1KJ)
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

    @Column(name=GenJT_SiHubi.RENRAKUSAKIADR2KJ)
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

    @Column(name=GenJT_SiHubi.RENRAKUSAKIADR3KJ)
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

    @Column(name=GenJT_SiHubi.RENRAKUSAKITELNO)
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

    @Column(name=GenJT_SiHubi.RENRAKUAREA)
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

    private BizDate hassinsakifsthubihasinymd1;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiHubi.HASSINSAKIFSTHUBIHASINYMD1)
    public BizDate getHassinsakifsthubihasinymd1() {
        return hassinsakifsthubihasinymd1;
    }

    public void setHassinsakifsthubihasinymd1(BizDate pHassinsakifsthubihasinymd1) {
        hassinsakifsthubihasinymd1 = pHassinsakifsthubihasinymd1;
    }

    private BizDate hassinsakifsthubihasinymd2;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiHubi.HASSINSAKIFSTHUBIHASINYMD2)
    public BizDate getHassinsakifsthubihasinymd2() {
        return hassinsakifsthubihasinymd2;
    }

    public void setHassinsakifsthubihasinymd2(BizDate pHassinsakifsthubihasinymd2) {
        hassinsakifsthubihasinymd2 = pHassinsakifsthubihasinymd2;
    }

    private BizDate hasinsakibetuhubihasinymd3;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiHubi.HASINSAKIBETUHUBIHASINYMD3)
    @ValidDate
    public BizDate getHasinsakibetuhubihasinymd3() {
        return hasinsakibetuhubihasinymd3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHasinsakibetuhubihasinymd3(BizDate pHasinsakibetuhubihasinymd3) {
        hasinsakibetuhubihasinymd3 = pHasinsakibetuhubihasinymd3;
    }

    private Integer hassinsakikaisuu1;

    @Column(name=GenJT_SiHubi.HASSINSAKIKAISUU1)
    public Integer getHassinsakikaisuu1() {
        return hassinsakikaisuu1;
    }

    public void setHassinsakikaisuu1(Integer pHassinsakikaisuu1) {
        hassinsakikaisuu1 = pHassinsakikaisuu1;
    }

    private Integer hassinsakikaisuu2;

    @Column(name=GenJT_SiHubi.HASSINSAKIKAISUU2)
    public Integer getHassinsakikaisuu2() {
        return hassinsakikaisuu2;
    }

    public void setHassinsakikaisuu2(Integer pHassinsakikaisuu2) {
        hassinsakikaisuu2 = pHassinsakikaisuu2;
    }

    private Integer hasinsakibetuhasinkaisuu3;

    @Column(name=GenJT_SiHubi.HASINSAKIBETUHASINKAISUU3)
    @Range(min="0", max="99")
    @NaturalNumber
    public Integer getHasinsakibetuhasinkaisuu3() {
        return hasinsakibetuhasinkaisuu3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHasinsakibetuhasinkaisuu3(Integer pHasinsakibetuhasinkaisuu3) {
        hasinsakibetuhasinkaisuu3 = pHasinsakibetuhasinkaisuu3;
    }

    private String sisyacd;

    @Column(name=GenJT_SiHubi.SISYACD)
    @Length(length=3)
    @SingleByteStrings
    public String getSisyacd() {
        return sisyacd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSisyacd(String pSisyacd) {
        sisyacd = pSisyacd;
    }

    private String sisyanm;

    @Column(name=GenJT_SiHubi.SISYANM)
    @MaxLength(max=20)
    @MultiByteStrings
    @InvalidCharacter
    public String getSisyanm() {
        return sisyanm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setSisyanm(String pSisyanm) {
        sisyanm = pSisyanm;
    }

    private String toiawasesosikinmkj;

    @Column(name=GenJT_SiHubi.TOIAWASESOSIKINMKJ)
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

    private String toiawasetelno;

    @Column(name=GenJT_SiHubi.TOIAWASETELNO)
    @AlphaDigitOrExceptionCode(except=("-()"))
    @MaxLength(max=14)
    public String getToiawasetelno() {
        return toiawasetelno;
    }

    @DataConvert("toSingleByte")
    public void setToiawasetelno(String pToiawasetelno) {
        toiawasetelno = pToiawasetelno;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_SiHubi.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_SiHubi.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}