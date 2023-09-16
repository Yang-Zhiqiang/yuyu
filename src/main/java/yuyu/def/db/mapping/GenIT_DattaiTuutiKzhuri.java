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
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.IT_DattaiTuutiKzhuri;
import yuyu.def.db.id.PKIT_DattaiTuutiKzhuri;
import yuyu.def.db.meta.GenQIT_DattaiTuutiKzhuri;
import yuyu.def.db.meta.QIT_DattaiTuutiKzhuri;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 脱退通知（口座振替）テーブル テーブルのマッピング情報クラスで、 {@link IT_DattaiTuutiKzhuri} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_DattaiTuutiKzhuri}</td><td colspan="3">脱退通知（口座振替）テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_DattaiTuutiKzhuri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_DattaiTuutiKzhuri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">{@link PKIT_DattaiTuutiKzhuri ○}</td><td align="center">V</td><td>BizDate</td></tr>
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
 *  <tr><td>{@link #getOsirasemongon1 osirasemongon1}</td><td>お知らせ文言１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon2 osirasemongon2}</td><td>お知らせ文言２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon3 osirasemongon3}</td><td>お知らせ文言３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon4 osirasemongon4}</td><td>お知らせ文言４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon5 osirasemongon5}</td><td>お知らせ文言５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon6 osirasemongon6}</td><td>お知らせ文言６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon7 osirasemongon7}</td><td>お知らせ文言７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon8 osirasemongon8}</td><td>お知らせ文言８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon9 osirasemongon9}</td><td>お知らせ文言９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmkj hhknnmkj}</td><td>被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzinfo30keta1 kzinfo30keta1}</td><td>口座情報（３０桁）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzinfo30keta2 kzinfo30keta2}</td><td>口座情報（３０桁）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzinfo30keta3 kzinfo30keta3}</td><td>口座情報（３０桁）３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKouzamaskingmsg kouzamaskingmsg}</td><td>口座マスキングＭＳＧ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>{@link #getHassoukbn hassoukbn}</td><td>発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HassouKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_DattaiTuutiKzhuri
 * @see     PKIT_DattaiTuutiKzhuri
 * @see     QIT_DattaiTuutiKzhuri
 * @see     GenQIT_DattaiTuutiKzhuri
 */
@MappedSuperclass
@Table(name=GenIT_DattaiTuutiKzhuri.TABLE_NAME)
@IdClass(value=PKIT_DattaiTuutiKzhuri.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HassouKbn", typeClass=UserType_C_HassouKbn.class),
    @TypeDef(name="UserType_C_SyoruiCdKbn", typeClass=UserType_C_SyoruiCdKbn.class)
})
public abstract class GenIT_DattaiTuutiKzhuri extends AbstractExDBEntity<IT_DattaiTuutiKzhuri, PKIT_DattaiTuutiKzhuri> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_DattaiTuutiKzhuri";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
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
    public static final String OSIRASEMONGON1           = "osirasemongon1";
    public static final String OSIRASEMONGON2           = "osirasemongon2";
    public static final String OSIRASEMONGON3           = "osirasemongon3";
    public static final String OSIRASEMONGON4           = "osirasemongon4";
    public static final String OSIRASEMONGON5           = "osirasemongon5";
    public static final String OSIRASEMONGON6           = "osirasemongon6";
    public static final String OSIRASEMONGON7           = "osirasemongon7";
    public static final String OSIRASEMONGON8           = "osirasemongon8";
    public static final String OSIRASEMONGON9           = "osirasemongon9";
    public static final String HHKNNMKJ                 = "hhknnmkj";
    public static final String KZINFO30KETA1            = "kzinfo30keta1";
    public static final String KZINFO30KETA2            = "kzinfo30keta2";
    public static final String KZINFO30KETA3            = "kzinfo30keta3";
    public static final String KOUZAMASKINGMSG          = "kouzamaskingmsg";
    public static final String SYORUICD                 = "syoruiCd";
    public static final String HASSOUKBN                = "hassoukbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_DattaiTuutiKzhuri primaryKey;

    public GenIT_DattaiTuutiKzhuri() {
        primaryKey = new PKIT_DattaiTuutiKzhuri();
    }

    public GenIT_DattaiTuutiKzhuri(
        String pKbnkey,
        String pSyono,
        BizDate pTyouhyouymd
    ) {
        primaryKey = new PKIT_DattaiTuutiKzhuri(
            pKbnkey,
            pSyono,
            pTyouhyouymd
        );
    }

    @Transient
    @Override
    public PKIT_DattaiTuutiKzhuri getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_DattaiTuutiKzhuri> getMetaClass() {
        return QIT_DattaiTuutiKzhuri.class;
    }

    @Id
    @Column(name=GenIT_DattaiTuutiKzhuri.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_DattaiTuutiKzhuri.SYONO)
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
    @Type(type="BizDateType")
    @Column(name=GenIT_DattaiTuutiKzhuri.TYOUHYOUYMD)
    @ValidDate
    public BizDate getTyouhyouymd() {
        return getPrimaryKey().getTyouhyouymd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyouhyouymd(BizDate pTyouhyouymd) {
        getPrimaryKey().setTyouhyouymd(pTyouhyouymd);
    }

    private String shskyno;

    @Column(name=GenIT_DattaiTuutiKzhuri.SHSKYNO)
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

    @Column(name=GenIT_DattaiTuutiKzhuri.SHSADR1KJ)
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

    @Column(name=GenIT_DattaiTuutiKzhuri.SHSADR2KJ)
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

    @Column(name=GenIT_DattaiTuutiKzhuri.SHSADR3KJ)
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

    @Column(name=GenIT_DattaiTuutiKzhuri.SHSNMKJ)
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

    @Column(name=GenIT_DattaiTuutiKzhuri.TOIAWASESOSIKINMKJ)
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

    @Column(name=GenIT_DattaiTuutiKzhuri.TOIAWASEYNO)
    public String getToiawaseyno() {
        return toiawaseyno;
    }

    public void setToiawaseyno(String pToiawaseyno) {
        toiawaseyno = pToiawaseyno;
    }

    private String toiawaseadr1kj;

    @Column(name=GenIT_DattaiTuutiKzhuri.TOIAWASEADR1KJ)
    public String getToiawaseadr1kj() {
        return toiawaseadr1kj;
    }

    public void setToiawaseadr1kj(String pToiawaseadr1kj) {
        toiawaseadr1kj = pToiawaseadr1kj;
    }

    private String toiawaseadr2kj;

    @Column(name=GenIT_DattaiTuutiKzhuri.TOIAWASEADR2KJ)
    public String getToiawaseadr2kj() {
        return toiawaseadr2kj;
    }

    public void setToiawaseadr2kj(String pToiawaseadr2kj) {
        toiawaseadr2kj = pToiawaseadr2kj;
    }

    private String toiawaseadr3kj;

    @Column(name=GenIT_DattaiTuutiKzhuri.TOIAWASEADR3KJ)
    public String getToiawaseadr3kj() {
        return toiawaseadr3kj;
    }

    public void setToiawaseadr3kj(String pToiawaseadr3kj) {
        toiawaseadr3kj = pToiawaseadr3kj;
    }

    private String toiawasetelno;

    @Column(name=GenIT_DattaiTuutiKzhuri.TOIAWASETELNO)
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

    @Column(name=GenIT_DattaiTuutiKzhuri.TOIAWASETELUKTKKANOU1)
    public String getToiawaseteluktkkanou1() {
        return toiawaseteluktkkanou1;
    }

    public void setToiawaseteluktkkanou1(String pToiawaseteluktkkanou1) {
        toiawaseteluktkkanou1 = pToiawaseteluktkkanou1;
    }

    private String toiawaseteluktkkanou2;

    @Column(name=GenIT_DattaiTuutiKzhuri.TOIAWASETELUKTKKANOU2)
    public String getToiawaseteluktkkanou2() {
        return toiawaseteluktkkanou2;
    }

    public void setToiawaseteluktkkanou2(String pToiawaseteluktkkanou2) {
        toiawaseteluktkkanou2 = pToiawaseteluktkkanou2;
    }

    private String toiawasesosikinmkj2;

    @Column(name=GenIT_DattaiTuutiKzhuri.TOIAWASESOSIKINMKJ2)
    public String getToiawasesosikinmkj2() {
        return toiawasesosikinmkj2;
    }

    public void setToiawasesosikinmkj2(String pToiawasesosikinmkj2) {
        toiawasesosikinmkj2 = pToiawasesosikinmkj2;
    }

    private String toiawasetelno2;

    @Column(name=GenIT_DattaiTuutiKzhuri.TOIAWASETELNO2)
    public String getToiawasetelno2() {
        return toiawasetelno2;
    }

    public void setToiawasetelno2(String pToiawasetelno2) {
        toiawasetelno2 = pToiawasetelno2;
    }

    private String osirasemongon1;

    @Column(name=GenIT_DattaiTuutiKzhuri.OSIRASEMONGON1)
    public String getOsirasemongon1() {
        return osirasemongon1;
    }

    public void setOsirasemongon1(String pOsirasemongon1) {
        osirasemongon1 = pOsirasemongon1;
    }

    private String osirasemongon2;

    @Column(name=GenIT_DattaiTuutiKzhuri.OSIRASEMONGON2)
    public String getOsirasemongon2() {
        return osirasemongon2;
    }

    public void setOsirasemongon2(String pOsirasemongon2) {
        osirasemongon2 = pOsirasemongon2;
    }

    private String osirasemongon3;

    @Column(name=GenIT_DattaiTuutiKzhuri.OSIRASEMONGON3)
    public String getOsirasemongon3() {
        return osirasemongon3;
    }

    public void setOsirasemongon3(String pOsirasemongon3) {
        osirasemongon3 = pOsirasemongon3;
    }

    private String osirasemongon4;

    @Column(name=GenIT_DattaiTuutiKzhuri.OSIRASEMONGON4)
    public String getOsirasemongon4() {
        return osirasemongon4;
    }

    public void setOsirasemongon4(String pOsirasemongon4) {
        osirasemongon4 = pOsirasemongon4;
    }

    private String osirasemongon5;

    @Column(name=GenIT_DattaiTuutiKzhuri.OSIRASEMONGON5)
    public String getOsirasemongon5() {
        return osirasemongon5;
    }

    public void setOsirasemongon5(String pOsirasemongon5) {
        osirasemongon5 = pOsirasemongon5;
    }

    private String osirasemongon6;

    @Column(name=GenIT_DattaiTuutiKzhuri.OSIRASEMONGON6)
    public String getOsirasemongon6() {
        return osirasemongon6;
    }

    public void setOsirasemongon6(String pOsirasemongon6) {
        osirasemongon6 = pOsirasemongon6;
    }

    private String osirasemongon7;

    @Column(name=GenIT_DattaiTuutiKzhuri.OSIRASEMONGON7)
    public String getOsirasemongon7() {
        return osirasemongon7;
    }

    public void setOsirasemongon7(String pOsirasemongon7) {
        osirasemongon7 = pOsirasemongon7;
    }

    private String osirasemongon8;

    @Column(name=GenIT_DattaiTuutiKzhuri.OSIRASEMONGON8)
    public String getOsirasemongon8() {
        return osirasemongon8;
    }

    public void setOsirasemongon8(String pOsirasemongon8) {
        osirasemongon8 = pOsirasemongon8;
    }

    private String osirasemongon9;

    @Column(name=GenIT_DattaiTuutiKzhuri.OSIRASEMONGON9)
    public String getOsirasemongon9() {
        return osirasemongon9;
    }

    public void setOsirasemongon9(String pOsirasemongon9) {
        osirasemongon9 = pOsirasemongon9;
    }

    private String hhknnmkj;

    @Column(name=GenIT_DattaiTuutiKzhuri.HHKNNMKJ)
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

    private String kzinfo30keta1;

    @Column(name=GenIT_DattaiTuutiKzhuri.KZINFO30KETA1)
    public String getKzinfo30keta1() {
        return kzinfo30keta1;
    }

    public void setKzinfo30keta1(String pKzinfo30keta1) {
        kzinfo30keta1 = pKzinfo30keta1;
    }

    private String kzinfo30keta2;

    @Column(name=GenIT_DattaiTuutiKzhuri.KZINFO30KETA2)
    public String getKzinfo30keta2() {
        return kzinfo30keta2;
    }

    public void setKzinfo30keta2(String pKzinfo30keta2) {
        kzinfo30keta2 = pKzinfo30keta2;
    }

    private String kzinfo30keta3;

    @Column(name=GenIT_DattaiTuutiKzhuri.KZINFO30KETA3)
    public String getKzinfo30keta3() {
        return kzinfo30keta3;
    }

    public void setKzinfo30keta3(String pKzinfo30keta3) {
        kzinfo30keta3 = pKzinfo30keta3;
    }

    private String kouzamaskingmsg;

    @Column(name=GenIT_DattaiTuutiKzhuri.KOUZAMASKINGMSG)
    public String getKouzamaskingmsg() {
        return kouzamaskingmsg;
    }

    public void setKouzamaskingmsg(String pKouzamaskingmsg) {
        kouzamaskingmsg = pKouzamaskingmsg;
    }

    private C_SyoruiCdKbn syoruiCd;

    @Type(type="UserType_C_SyoruiCdKbn")
    @Column(name=GenIT_DattaiTuutiKzhuri.SYORUICD)
    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }

    private C_HassouKbn hassoukbn;

    @Type(type="UserType_C_HassouKbn")
    @Column(name=GenIT_DattaiTuutiKzhuri.HASSOUKBN)
    public C_HassouKbn getHassoukbn() {
        return hassoukbn;
    }

    public void setHassoukbn(C_HassouKbn pHassoukbn) {
        hassoukbn = pHassoukbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_DattaiTuutiKzhuri.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_DattaiTuutiKzhuri.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_DattaiTuutiKzhuri.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}