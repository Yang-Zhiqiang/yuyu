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
import yuyu.def.db.entity.IW_KhHubiWk;
import yuyu.def.db.id.PKIW_KhHubiWk;
import yuyu.def.db.meta.GenQIW_KhHubiWk;
import yuyu.def.db.meta.QIW_KhHubiWk;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全不備ワークテーブル テーブルのマッピング情報クラスで、 {@link IW_KhHubiWk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IW_KhHubiWk}</td><td colspan="3">契約保全不備ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">{@link PKIW_KhHubiWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenrakusakinmkj renrakusakinmkj}</td><td>連絡先氏名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenrakuyno renrakuyno}</td><td>連絡先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenrakusakiadr1kj renrakusakiadr1kj}</td><td>連絡先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenrakusakiadr2kj renrakusakiadr2kj}</td><td>連絡先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenrakusakiadr3kj renrakusakiadr3kj}</td><td>連絡先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenrakusakitelno renrakusakitelno}</td><td>連絡先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenrakuarea renrakuarea}</td><td>連絡欄</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHubianswerkjt hubianswerkjt}</td><td>不備回答期日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IW_KhHubiWk
 * @see     PKIW_KhHubiWk
 * @see     QIW_KhHubiWk
 * @see     GenQIW_KhHubiWk
 */
@MappedSuperclass
@Table(name=GenIW_KhHubiWk.TABLE_NAME)
@IdClass(value=PKIW_KhHubiWk.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class)
})
public abstract class GenIW_KhHubiWk extends AbstractExDBEntity<IW_KhHubiWk, PKIW_KhHubiWk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IW_KhHubiWk";
    public static final String KOUTEIKANRIID            = "kouteikanriid";
    public static final String SYONO                    = "syono";
    public static final String RENRAKUSAKINMKJ          = "renrakusakinmkj";
    public static final String RENRAKUYNO               = "renrakuyno";
    public static final String RENRAKUSAKIADR1KJ        = "renrakusakiadr1kj";
    public static final String RENRAKUSAKIADR2KJ        = "renrakusakiadr2kj";
    public static final String RENRAKUSAKIADR3KJ        = "renrakusakiadr3kj";
    public static final String RENRAKUSAKITELNO         = "renrakusakitelno";
    public static final String RENRAKUAREA              = "renrakuarea";
    public static final String HUBIANSWERKJT            = "hubianswerkjt";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIW_KhHubiWk primaryKey;

    public GenIW_KhHubiWk() {
        primaryKey = new PKIW_KhHubiWk();
    }

    public GenIW_KhHubiWk(String pKouteikanriid) {
        primaryKey = new PKIW_KhHubiWk(pKouteikanriid);
    }

    @Transient
    @Override
    public PKIW_KhHubiWk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIW_KhHubiWk> getMetaClass() {
        return QIW_KhHubiWk.class;
    }

    @Id
    @Column(name=GenIW_KhHubiWk.KOUTEIKANRIID)
    public String getKouteikanriid() {
        return getPrimaryKey().getKouteikanriid();
    }

    public void setKouteikanriid(String pKouteikanriid) {
        getPrimaryKey().setKouteikanriid(pKouteikanriid);
    }

    private String syono;

    @Column(name=GenIW_KhHubiWk.SYONO)
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

    @Column(name=GenIW_KhHubiWk.RENRAKUSAKINMKJ)
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

    @Column(name=GenIW_KhHubiWk.RENRAKUYNO)
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

    @Column(name=GenIW_KhHubiWk.RENRAKUSAKIADR1KJ)
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

    @Column(name=GenIW_KhHubiWk.RENRAKUSAKIADR2KJ)
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

    @Column(name=GenIW_KhHubiWk.RENRAKUSAKIADR3KJ)
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

    @Column(name=GenIW_KhHubiWk.RENRAKUSAKITELNO)
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

    @Column(name=GenIW_KhHubiWk.RENRAKUAREA)
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
    @Column(name=GenIW_KhHubiWk.HUBIANSWERKJT)
    @ValidDate
    public BizDate getHubianswerkjt() {
        return hubianswerkjt;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHubianswerkjt(BizDate pHubianswerkjt) {
        hubianswerkjt = pHubianswerkjt;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIW_KhHubiWk.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIW_KhHubiWk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIW_KhHubiWk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}