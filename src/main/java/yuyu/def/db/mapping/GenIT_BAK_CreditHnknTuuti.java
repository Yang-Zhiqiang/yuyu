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
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.AlphaDigitOrExceptionCode;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_ShrriyuuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_BAK_CreditHnknTuuti;
import yuyu.def.db.id.PKIT_BAK_CreditHnknTuuti;
import yuyu.def.db.meta.GenQIT_BAK_CreditHnknTuuti;
import yuyu.def.db.meta.QIT_BAK_CreditHnknTuuti;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_KrkriyuuKbn;
import yuyu.def.db.type.UserType_C_ShrriyuuKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * クレカ返金通知バックアップテーブル テーブルのマッピング情報クラスで、 {@link IT_BAK_CreditHnknTuuti} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_CreditHnknTuuti}</td><td colspan="3">クレカ返金通知バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_BAK_CreditHnknTuuti ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_BAK_CreditHnknTuuti ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKIT_BAK_CreditHnknTuuti ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDenrenno denrenno}</td><td>伝票データ連番</td><td align="center">{@link PKIT_BAK_CreditHnknTuuti ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getEdano edano}</td><td>枝番号</td><td align="center">{@link PKIT_BAK_CreditHnknTuuti ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHassoukbn hassoukbn}</td><td>発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HassouKbn}</td></tr>
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
 *  <tr><td>{@link #getShrriyuukbn shrriyuukbn}</td><td>支払理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ShrriyuuKbn}</td></tr>
 *  <tr><td>{@link #getUriageseikyuuymd uriageseikyuuymd}</td><td>売上請求日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHnkngk hnkngk}</td><td>返金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKrkriyuukbn krkriyuukbn}</td><td>仮受理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KrkriyuuKbn}</td></tr>
 *  <tr><td>{@link #getUriageymd uriageymd}</td><td>売上日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getUriagegk uriagegk}</td><td>売上金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getJyuutouym jyuutouym}</td><td>充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getJyutoukaisuuy jyutoukaisuuy}</td><td>充当回数（年）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getJyutoukaisuum jyutoukaisuum}</td><td>充当回数（月）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHnkntaisyouinjiflg hnkntaisyouinjiflg}</td><td>返金対象印字フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_CreditHnknTuuti
 * @see     PKIT_BAK_CreditHnknTuuti
 * @see     QIT_BAK_CreditHnknTuuti
 * @see     GenQIT_BAK_CreditHnknTuuti
 */
@MappedSuperclass
@Table(name=GenIT_BAK_CreditHnknTuuti.TABLE_NAME)
@IdClass(value=PKIT_BAK_CreditHnknTuuti.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_HassouKbn", typeClass=UserType_C_HassouKbn.class),
    @TypeDef(name="UserType_C_KrkriyuuKbn", typeClass=UserType_C_KrkriyuuKbn.class),
    @TypeDef(name="UserType_C_ShrriyuuKbn", typeClass=UserType_C_ShrriyuuKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenIT_BAK_CreditHnknTuuti extends AbstractExDBEntity<IT_BAK_CreditHnknTuuti, PKIT_BAK_CreditHnknTuuti> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_BAK_CreditHnknTuuti";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String DENRENNO                 = "denrenno";
    public static final String EDANO                    = "edano";
    public static final String TYOUHYOUYMD              = "tyouhyouymd";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String HASSOUKBN                = "hassoukbn";
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
    public static final String SHRRIYUUKBN              = "shrriyuukbn";
    public static final String URIAGESEIKYUUYMD         = "uriageseikyuuymd";
    public static final String HNKNGK                   = "hnkngk";
    public static final String KRKRIYUUKBN              = "krkriyuukbn";
    public static final String URIAGEYMD                = "uriageymd";
    public static final String URIAGEGK                 = "uriagegk";
    public static final String JYUUTOUYM                = "jyuutouym";
    public static final String JYUTOUKAISUUY            = "jyutoukaisuuy";
    public static final String JYUTOUKAISUUM            = "jyutoukaisuum";
    public static final String HNKNTAISYOUINJIFLG       = "hnkntaisyouinjiflg";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_BAK_CreditHnknTuuti primaryKey;

    public GenIT_BAK_CreditHnknTuuti() {
        primaryKey = new PKIT_BAK_CreditHnknTuuti();
    }

    public GenIT_BAK_CreditHnknTuuti(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        String pDenrenno,
        Integer pEdano
    ) {
        primaryKey = new PKIT_BAK_CreditHnknTuuti(
            pKbnkey,
            pSyono,
            pTrkssikibetukey,
            pDenrenno,
            pEdano
        );
    }

    @Transient
    @Override
    public PKIT_BAK_CreditHnknTuuti getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_BAK_CreditHnknTuuti> getMetaClass() {
        return QIT_BAK_CreditHnknTuuti.class;
    }

    @Id
    @Column(name=GenIT_BAK_CreditHnknTuuti.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_BAK_CreditHnknTuuti.SYONO)
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
    @Column(name=GenIT_BAK_CreditHnknTuuti.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    @Id
    @Column(name=GenIT_BAK_CreditHnknTuuti.DENRENNO)
    public String getDenrenno() {
        return getPrimaryKey().getDenrenno();
    }

    public void setDenrenno(String pDenrenno) {
        getPrimaryKey().setDenrenno(pDenrenno);
    }

    @Id
    @Column(name=GenIT_BAK_CreditHnknTuuti.EDANO)
    public Integer getEdano() {
        return getPrimaryKey().getEdano();
    }

    public void setEdano(Integer pEdano) {
        getPrimaryKey().setEdano(pEdano);
    }

    private BizDate tyouhyouymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_CreditHnknTuuti.TYOUHYOUYMD)
    @ValidDate
    public BizDate getTyouhyouymd() {
        return tyouhyouymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyouhyouymd(BizDate pTyouhyouymd) {
        tyouhyouymd = pTyouhyouymd;
    }

    private String henkousikibetukey;

    @Column(name=GenIT_BAK_CreditHnknTuuti.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }

    private C_HassouKbn hassoukbn;

    @Type(type="UserType_C_HassouKbn")
    @Column(name=GenIT_BAK_CreditHnknTuuti.HASSOUKBN)
    public C_HassouKbn getHassoukbn() {
        return hassoukbn;
    }

    public void setHassoukbn(C_HassouKbn pHassoukbn) {
        hassoukbn = pHassoukbn;
    }

    private String shskyno;

    @Column(name=GenIT_BAK_CreditHnknTuuti.SHSKYNO)
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

    @Column(name=GenIT_BAK_CreditHnknTuuti.SHSADR1KJ)
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

    @Column(name=GenIT_BAK_CreditHnknTuuti.SHSADR2KJ)
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

    @Column(name=GenIT_BAK_CreditHnknTuuti.SHSADR3KJ)
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

    @Column(name=GenIT_BAK_CreditHnknTuuti.SHSNMKJ)
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

    @Column(name=GenIT_BAK_CreditHnknTuuti.TOIAWASESOSIKINMKJ)
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

    @Column(name=GenIT_BAK_CreditHnknTuuti.TOIAWASEYNO)
    public String getToiawaseyno() {
        return toiawaseyno;
    }

    public void setToiawaseyno(String pToiawaseyno) {
        toiawaseyno = pToiawaseyno;
    }

    private String toiawaseadr1kj;

    @Column(name=GenIT_BAK_CreditHnknTuuti.TOIAWASEADR1KJ)
    public String getToiawaseadr1kj() {
        return toiawaseadr1kj;
    }

    public void setToiawaseadr1kj(String pToiawaseadr1kj) {
        toiawaseadr1kj = pToiawaseadr1kj;
    }

    private String toiawaseadr2kj;

    @Column(name=GenIT_BAK_CreditHnknTuuti.TOIAWASEADR2KJ)
    public String getToiawaseadr2kj() {
        return toiawaseadr2kj;
    }

    public void setToiawaseadr2kj(String pToiawaseadr2kj) {
        toiawaseadr2kj = pToiawaseadr2kj;
    }

    private String toiawaseadr3kj;

    @Column(name=GenIT_BAK_CreditHnknTuuti.TOIAWASEADR3KJ)
    public String getToiawaseadr3kj() {
        return toiawaseadr3kj;
    }

    public void setToiawaseadr3kj(String pToiawaseadr3kj) {
        toiawaseadr3kj = pToiawaseadr3kj;
    }

    private String toiawasetelno;

    @Column(name=GenIT_BAK_CreditHnknTuuti.TOIAWASETELNO)
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

    @Column(name=GenIT_BAK_CreditHnknTuuti.TOIAWASETELUKTKKANOU1)
    public String getToiawaseteluktkkanou1() {
        return toiawaseteluktkkanou1;
    }

    public void setToiawaseteluktkkanou1(String pToiawaseteluktkkanou1) {
        toiawaseteluktkkanou1 = pToiawaseteluktkkanou1;
    }

    private String toiawaseteluktkkanou2;

    @Column(name=GenIT_BAK_CreditHnknTuuti.TOIAWASETELUKTKKANOU2)
    public String getToiawaseteluktkkanou2() {
        return toiawaseteluktkkanou2;
    }

    public void setToiawaseteluktkkanou2(String pToiawaseteluktkkanou2) {
        toiawaseteluktkkanou2 = pToiawaseteluktkkanou2;
    }

    private String toiawasesosikinmkj2;

    @Column(name=GenIT_BAK_CreditHnknTuuti.TOIAWASESOSIKINMKJ2)
    public String getToiawasesosikinmkj2() {
        return toiawasesosikinmkj2;
    }

    public void setToiawasesosikinmkj2(String pToiawasesosikinmkj2) {
        toiawasesosikinmkj2 = pToiawasesosikinmkj2;
    }

    private String toiawasetelno2;

    @Column(name=GenIT_BAK_CreditHnknTuuti.TOIAWASETELNO2)
    public String getToiawasetelno2() {
        return toiawasetelno2;
    }

    public void setToiawasetelno2(String pToiawasetelno2) {
        toiawasetelno2 = pToiawasetelno2;
    }

    private C_ShrriyuuKbn shrriyuukbn;

    @Type(type="UserType_C_ShrriyuuKbn")
    @Column(name=GenIT_BAK_CreditHnknTuuti.SHRRIYUUKBN)
    public C_ShrriyuuKbn getShrriyuukbn() {
        return shrriyuukbn;
    }

    public void setShrriyuukbn(C_ShrriyuuKbn pShrriyuukbn) {
        shrriyuukbn = pShrriyuukbn;
    }

    private BizDate uriageseikyuuymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_CreditHnknTuuti.URIAGESEIKYUUYMD)
    public BizDate getUriageseikyuuymd() {
        return uriageseikyuuymd;
    }

    public void setUriageseikyuuymd(BizDate pUriageseikyuuymd) {
        uriageseikyuuymd = pUriageseikyuuymd;
    }

    private BizCurrency hnkngk;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    public BizCurrency getHnkngk() {
        return hnkngk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHnkngk(BizCurrency pHnkngk) {
        hnkngk = pHnkngk;
        hnkngkValue = null;
        hnkngkType  = null;
    }

    transient private BigDecimal hnkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HNKNGK, nullable=true)
    protected BigDecimal getHnkngkValue() {
        if (hnkngkValue == null && hnkngk != null) {
            if (hnkngk.isOptional()) return null;
            return hnkngk.absolute();
        }
        return hnkngkValue;
    }

    protected void setHnkngkValue(BigDecimal value) {
        hnkngkValue = value;
        hnkngk = Optional.fromNullable(toCurrencyType(hnkngkType))
            .transform(bizCurrencyTransformer(getHnkngkValue()))
            .orNull();
    }

    transient private String hnkngkType = null;

    @Column(name=HNKNGK + "$", nullable=true)
    protected String getHnkngkType() {
        if (hnkngkType == null && hnkngk != null) return hnkngk.getType().toString();
        if (hnkngkType == null && getHnkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hnkngk$' should not be NULL."));
        }
        return hnkngkType;
    }

    protected void setHnkngkType(String type) {
        hnkngkType = type;
        hnkngk = Optional.fromNullable(toCurrencyType(hnkngkType))
            .transform(bizCurrencyTransformer(getHnkngkValue()))
            .orNull();
    }

    private C_KrkriyuuKbn krkriyuukbn;

    @Type(type="UserType_C_KrkriyuuKbn")
    @Column(name=GenIT_BAK_CreditHnknTuuti.KRKRIYUUKBN)
    public C_KrkriyuuKbn getKrkriyuukbn() {
        return krkriyuukbn;
    }

    public void setKrkriyuukbn(C_KrkriyuuKbn pKrkriyuukbn) {
        krkriyuukbn = pKrkriyuukbn;
    }

    private BizDate uriageymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_CreditHnknTuuti.URIAGEYMD)
    public BizDate getUriageymd() {
        return uriageymd;
    }

    public void setUriageymd(BizDate pUriageymd) {
        uriageymd = pUriageymd;
    }

    private BizCurrency uriagegk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getUriagegk() {
        return uriagegk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUriagegk(BizCurrency pUriagegk) {
        uriagegk = pUriagegk;
        uriagegkValue = null;
        uriagegkType  = null;
    }

    transient private BigDecimal uriagegkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=URIAGEGK, nullable=true)
    protected BigDecimal getUriagegkValue() {
        if (uriagegkValue == null && uriagegk != null) {
            if (uriagegk.isOptional()) return null;
            return uriagegk.absolute();
        }
        return uriagegkValue;
    }

    protected void setUriagegkValue(BigDecimal value) {
        uriagegkValue = value;
        uriagegk = Optional.fromNullable(toCurrencyType(uriagegkType))
            .transform(bizCurrencyTransformer(getUriagegkValue()))
            .orNull();
    }

    transient private String uriagegkType = null;

    @Column(name=URIAGEGK + "$", nullable=true)
    protected String getUriagegkType() {
        if (uriagegkType == null && uriagegk != null) return uriagegk.getType().toString();
        if (uriagegkType == null && getUriagegkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'uriagegk$' should not be NULL."));
        }
        return uriagegkType;
    }

    protected void setUriagegkType(String type) {
        uriagegkType = type;
        uriagegk = Optional.fromNullable(toCurrencyType(uriagegkType))
            .transform(bizCurrencyTransformer(getUriagegkValue()))
            .orNull();
    }

    private BizDateYM jyuutouym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_BAK_CreditHnknTuuti.JYUUTOUYM)
    @ValidDateYm
    public BizDateYM getJyuutouym() {
        return jyuutouym;
    }

    @Trim("both")
    public void setJyuutouym(BizDateYM pJyuutouym) {
        jyuutouym = pJyuutouym;
    }

    private Integer jyutoukaisuuy;

    @Column(name=GenIT_BAK_CreditHnknTuuti.JYUTOUKAISUUY)
    @Range(min="0", max="99")
    public Integer getJyutoukaisuuy() {
        return jyutoukaisuuy;
    }

    @Trim("both")
    public void setJyutoukaisuuy(Integer pJyutoukaisuuy) {
        jyutoukaisuuy = pJyutoukaisuuy;
    }

    private Integer jyutoukaisuum;

    @Column(name=GenIT_BAK_CreditHnknTuuti.JYUTOUKAISUUM)
    @Range(min="0", max="12")
    public Integer getJyutoukaisuum() {
        return jyutoukaisuum;
    }

    @Trim("both")
    public void setJyutoukaisuum(Integer pJyutoukaisuum) {
        jyutoukaisuum = pJyutoukaisuum;
    }

    private C_UmuKbn hnkntaisyouinjiflg;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_BAK_CreditHnknTuuti.HNKNTAISYOUINJIFLG)
    public C_UmuKbn getHnkntaisyouinjiflg() {
        return hnkntaisyouinjiflg;
    }

    public void setHnkntaisyouinjiflg(C_UmuKbn pHnkntaisyouinjiflg) {
        hnkntaisyouinjiflg = pHnkntaisyouinjiflg;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_BAK_CreditHnknTuuti.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_BAK_CreditHnknTuuti.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_BAK_CreditHnknTuuti.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}