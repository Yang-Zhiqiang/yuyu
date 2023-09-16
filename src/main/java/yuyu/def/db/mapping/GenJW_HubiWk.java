package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigitOrExceptionCode;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import yuyu.def.db.entity.JW_HubiWk;
import yuyu.def.db.id.PKJW_HubiWk;
import yuyu.def.db.meta.GenQJW_HubiWk;
import yuyu.def.db.meta.QJW_HubiWk;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 支払不備ワークテーブル テーブルのマッピング情報クラスで、 {@link JW_HubiWk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JW_HubiWk}</td><td colspan="3">支払不備ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">{@link PKJW_HubiWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenrakusakinmkj renrakusakinmkj}</td><td>連絡先氏名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenrakuyno renrakuyno}</td><td>連絡先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenrakusakiadr1kj renrakusakiadr1kj}</td><td>連絡先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenrakusakiadr2kj renrakusakiadr2kj}</td><td>連絡先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenrakusakiadr3kj renrakusakiadr3kj}</td><td>連絡先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenrakusakitelno renrakusakitelno}</td><td>連絡先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenrakuarea renrakuarea}</td><td>連絡欄</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSisyacd sisyacd}</td><td>支社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSisyanm sisyanm}</td><td>支社名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasesosikinmkj toiawasesosikinmkj}</td><td>問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasetelno toiawasetelno}</td><td>問合せ先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JW_HubiWk
 * @see     PKJW_HubiWk
 * @see     QJW_HubiWk
 * @see     GenQJW_HubiWk
 */
@MappedSuperclass
@Table(name=GenJW_HubiWk.TABLE_NAME)
@IdClass(value=PKJW_HubiWk.class)
public abstract class GenJW_HubiWk extends AbstractExDBEntity<JW_HubiWk, PKJW_HubiWk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JW_HubiWk";
    public static final String KOUTEIKANRIID            = "kouteikanriid";
    public static final String SYONO                    = "syono";
    public static final String RENRAKUSAKINMKJ          = "renrakusakinmkj";
    public static final String RENRAKUYNO               = "renrakuyno";
    public static final String RENRAKUSAKIADR1KJ        = "renrakusakiadr1kj";
    public static final String RENRAKUSAKIADR2KJ        = "renrakusakiadr2kj";
    public static final String RENRAKUSAKIADR3KJ        = "renrakusakiadr3kj";
    public static final String RENRAKUSAKITELNO         = "renrakusakitelno";
    public static final String RENRAKUAREA              = "renrakuarea";
    public static final String SISYACD                  = "sisyacd";
    public static final String SISYANM                  = "sisyanm";
    public static final String TOIAWASESOSIKINMKJ       = "toiawasesosikinmkj";
    public static final String TOIAWASETELNO            = "toiawasetelno";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJW_HubiWk primaryKey;

    public GenJW_HubiWk() {
        primaryKey = new PKJW_HubiWk();
    }

    public GenJW_HubiWk(String pKouteikanriid) {
        primaryKey = new PKJW_HubiWk(pKouteikanriid);
    }

    @Transient
    @Override
    public PKJW_HubiWk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJW_HubiWk> getMetaClass() {
        return QJW_HubiWk.class;
    }

    @Id
    @Column(name=GenJW_HubiWk.KOUTEIKANRIID)
    public String getKouteikanriid() {
        return getPrimaryKey().getKouteikanriid();
    }

    public void setKouteikanriid(String pKouteikanriid) {
        getPrimaryKey().setKouteikanriid(pKouteikanriid);
    }

    private String syono;

    @Column(name=GenJW_HubiWk.SYONO)
    @SyoukenNo
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private String renrakusakinmkj;

    @Column(name=GenJW_HubiWk.RENRAKUSAKINMKJ)
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

    @Column(name=GenJW_HubiWk.RENRAKUYNO)
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

    @Column(name=GenJW_HubiWk.RENRAKUSAKIADR1KJ)
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

    @Column(name=GenJW_HubiWk.RENRAKUSAKIADR2KJ)
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

    @Column(name=GenJW_HubiWk.RENRAKUSAKIADR3KJ)
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

    @Column(name=GenJW_HubiWk.RENRAKUSAKITELNO)
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

    @Column(name=GenJW_HubiWk.RENRAKUAREA)
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

    private String sisyacd;

    @Column(name=GenJW_HubiWk.SISYACD)
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

    @Column(name=GenJW_HubiWk.SISYANM)
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

    @Column(name=GenJW_HubiWk.TOIAWASESOSIKINMKJ)
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

    @Column(name=GenJW_HubiWk.TOIAWASETELNO)
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

    @Column(name=GenJW_HubiWk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJW_HubiWk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}