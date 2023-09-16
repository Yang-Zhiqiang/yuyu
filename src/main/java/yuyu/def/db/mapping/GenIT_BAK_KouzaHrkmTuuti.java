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
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
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
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.IT_BAK_KouzaHrkmTuuti;
import yuyu.def.db.id.PKIT_BAK_KouzaHrkmTuuti;
import yuyu.def.db.meta.GenQIT_BAK_KouzaHrkmTuuti;
import yuyu.def.db.meta.QIT_BAK_KouzaHrkmTuuti;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 口座振込通知バックアップテーブル テーブルのマッピング情報クラスで、 {@link IT_BAK_KouzaHrkmTuuti} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_KouzaHrkmTuuti}</td><td colspan="3">口座振込通知バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_BAK_KouzaHrkmTuuti ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_BAK_KouzaHrkmTuuti ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKrkno krkno}</td><td>仮受番号</td><td align="center">{@link PKIT_BAK_KouzaHrkmTuuti ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKIT_BAK_KouzaHrkmTuuti ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
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
 *  <tr><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>{@link #getHassoukbn hassoukbn}</td><td>発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HassouKbn}</td></tr>
 *  <tr><td>{@link #getHurikomiymd hurikomiymd}</td><td>振込日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShrgk shrgk}</td><td>支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShririyuu1 shririyuu1}</td><td>支払理由１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShririyuu2 shririyuu2}</td><td>支払理由２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShririyuu3 shririyuu3}</td><td>支払理由３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiteikouza1 siteikouza1}</td><td>指定口座１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiteikouza2 siteikouza2}</td><td>指定口座２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiteikouza3 siteikouza3}</td><td>指定口座３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiteikouza4 siteikouza4}</td><td>指定口座４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiteikouza5 siteikouza5}</td><td>指定口座５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_KouzaHrkmTuuti
 * @see     PKIT_BAK_KouzaHrkmTuuti
 * @see     QIT_BAK_KouzaHrkmTuuti
 * @see     GenQIT_BAK_KouzaHrkmTuuti
 */
@MappedSuperclass
@Table(name=GenIT_BAK_KouzaHrkmTuuti.TABLE_NAME)
@IdClass(value=PKIT_BAK_KouzaHrkmTuuti.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HassouKbn", typeClass=UserType_C_HassouKbn.class),
    @TypeDef(name="UserType_C_SyoruiCdKbn", typeClass=UserType_C_SyoruiCdKbn.class)
})
public abstract class GenIT_BAK_KouzaHrkmTuuti extends AbstractExDBEntity<IT_BAK_KouzaHrkmTuuti, PKIT_BAK_KouzaHrkmTuuti> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_BAK_KouzaHrkmTuuti";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String KRKNO                    = "krkno";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String TYOUHYOUYMD              = "tyouhyouymd";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
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
    public static final String SYORUICD                 = "syoruiCd";
    public static final String HASSOUKBN                = "hassoukbn";
    public static final String HURIKOMIYMD              = "hurikomiymd";
    public static final String SHRGK                    = "shrgk";
    public static final String SHRIRIYUU1               = "shririyuu1";
    public static final String SHRIRIYUU2               = "shririyuu2";
    public static final String SHRIRIYUU3               = "shririyuu3";
    public static final String SITEIKOUZA1              = "siteikouza1";
    public static final String SITEIKOUZA2              = "siteikouza2";
    public static final String SITEIKOUZA3              = "siteikouza3";
    public static final String SITEIKOUZA4              = "siteikouza4";
    public static final String SITEIKOUZA5              = "siteikouza5";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_BAK_KouzaHrkmTuuti primaryKey;

    public GenIT_BAK_KouzaHrkmTuuti() {
        primaryKey = new PKIT_BAK_KouzaHrkmTuuti();
    }

    public GenIT_BAK_KouzaHrkmTuuti(
        String pKbnkey,
        String pSyono,
        Integer pKrkno,
        String pTrkssikibetukey
    ) {
        primaryKey = new PKIT_BAK_KouzaHrkmTuuti(
            pKbnkey,
            pSyono,
            pKrkno,
            pTrkssikibetukey
        );
    }

    @Transient
    @Override
    public PKIT_BAK_KouzaHrkmTuuti getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_BAK_KouzaHrkmTuuti> getMetaClass() {
        return QIT_BAK_KouzaHrkmTuuti.class;
    }

    @Id
    @Column(name=GenIT_BAK_KouzaHrkmTuuti.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_BAK_KouzaHrkmTuuti.SYONO)
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
    @Column(name=GenIT_BAK_KouzaHrkmTuuti.KRKNO)
    @Range(min="0", max="99999")
    public Integer getKrkno() {
        return getPrimaryKey().getKrkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKrkno(Integer pKrkno) {
        getPrimaryKey().setKrkno(pKrkno);
    }

    @Id
    @Column(name=GenIT_BAK_KouzaHrkmTuuti.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    private BizDate tyouhyouymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KouzaHrkmTuuti.TYOUHYOUYMD)
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

    @Column(name=GenIT_BAK_KouzaHrkmTuuti.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }

    private String shskyno;

    @Column(name=GenIT_BAK_KouzaHrkmTuuti.SHSKYNO)
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

    @Column(name=GenIT_BAK_KouzaHrkmTuuti.SHSADR1KJ)
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

    @Column(name=GenIT_BAK_KouzaHrkmTuuti.SHSADR2KJ)
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

    @Column(name=GenIT_BAK_KouzaHrkmTuuti.SHSADR3KJ)
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

    @Column(name=GenIT_BAK_KouzaHrkmTuuti.SHSNMKJ)
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

    @Column(name=GenIT_BAK_KouzaHrkmTuuti.TOIAWASESOSIKINMKJ)
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

    @Column(name=GenIT_BAK_KouzaHrkmTuuti.TOIAWASEYNO)
    public String getToiawaseyno() {
        return toiawaseyno;
    }

    public void setToiawaseyno(String pToiawaseyno) {
        toiawaseyno = pToiawaseyno;
    }

    private String toiawaseadr1kj;

    @Column(name=GenIT_BAK_KouzaHrkmTuuti.TOIAWASEADR1KJ)
    public String getToiawaseadr1kj() {
        return toiawaseadr1kj;
    }

    public void setToiawaseadr1kj(String pToiawaseadr1kj) {
        toiawaseadr1kj = pToiawaseadr1kj;
    }

    private String toiawaseadr2kj;

    @Column(name=GenIT_BAK_KouzaHrkmTuuti.TOIAWASEADR2KJ)
    public String getToiawaseadr2kj() {
        return toiawaseadr2kj;
    }

    public void setToiawaseadr2kj(String pToiawaseadr2kj) {
        toiawaseadr2kj = pToiawaseadr2kj;
    }

    private String toiawaseadr3kj;

    @Column(name=GenIT_BAK_KouzaHrkmTuuti.TOIAWASEADR3KJ)
    public String getToiawaseadr3kj() {
        return toiawaseadr3kj;
    }

    public void setToiawaseadr3kj(String pToiawaseadr3kj) {
        toiawaseadr3kj = pToiawaseadr3kj;
    }

    private String toiawasetelno;

    @Column(name=GenIT_BAK_KouzaHrkmTuuti.TOIAWASETELNO)
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

    @Column(name=GenIT_BAK_KouzaHrkmTuuti.TOIAWASETELUKTKKANOU1)
    public String getToiawaseteluktkkanou1() {
        return toiawaseteluktkkanou1;
    }

    public void setToiawaseteluktkkanou1(String pToiawaseteluktkkanou1) {
        toiawaseteluktkkanou1 = pToiawaseteluktkkanou1;
    }

    private String toiawaseteluktkkanou2;

    @Column(name=GenIT_BAK_KouzaHrkmTuuti.TOIAWASETELUKTKKANOU2)
    public String getToiawaseteluktkkanou2() {
        return toiawaseteluktkkanou2;
    }

    public void setToiawaseteluktkkanou2(String pToiawaseteluktkkanou2) {
        toiawaseteluktkkanou2 = pToiawaseteluktkkanou2;
    }

    private String toiawasesosikinmkj2;

    @Column(name=GenIT_BAK_KouzaHrkmTuuti.TOIAWASESOSIKINMKJ2)
    public String getToiawasesosikinmkj2() {
        return toiawasesosikinmkj2;
    }

    public void setToiawasesosikinmkj2(String pToiawasesosikinmkj2) {
        toiawasesosikinmkj2 = pToiawasesosikinmkj2;
    }

    private String toiawasetelno2;

    @Column(name=GenIT_BAK_KouzaHrkmTuuti.TOIAWASETELNO2)
    public String getToiawasetelno2() {
        return toiawasetelno2;
    }

    public void setToiawasetelno2(String pToiawasetelno2) {
        toiawasetelno2 = pToiawasetelno2;
    }

    private C_SyoruiCdKbn syoruiCd;

    @Type(type="UserType_C_SyoruiCdKbn")
    @Column(name=GenIT_BAK_KouzaHrkmTuuti.SYORUICD)
    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }

    private C_HassouKbn hassoukbn;

    @Type(type="UserType_C_HassouKbn")
    @Column(name=GenIT_BAK_KouzaHrkmTuuti.HASSOUKBN)
    public C_HassouKbn getHassoukbn() {
        return hassoukbn;
    }

    public void setHassoukbn(C_HassouKbn pHassoukbn) {
        hassoukbn = pHassoukbn;
    }

    private BizDate hurikomiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KouzaHrkmTuuti.HURIKOMIYMD)
    public BizDate getHurikomiymd() {
        return hurikomiymd;
    }

    public void setHurikomiymd(BizDate pHurikomiymd) {
        hurikomiymd = pHurikomiymd;
    }

    private BizCurrency shrgk;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    public BizCurrency getShrgk() {
        return shrgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShrgk(BizCurrency pShrgk) {
        shrgk = pShrgk;
        shrgkValue = null;
        shrgkType  = null;
    }

    transient private BigDecimal shrgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SHRGK, nullable=true)
    protected BigDecimal getShrgkValue() {
        if (shrgkValue == null && shrgk != null) {
            if (shrgk.isOptional()) return null;
            return shrgk.absolute();
        }
        return shrgkValue;
    }

    protected void setShrgkValue(BigDecimal value) {
        shrgkValue = value;
        shrgk = Optional.fromNullable(toCurrencyType(shrgkType))
            .transform(bizCurrencyTransformer(getShrgkValue()))
            .orNull();
    }

    transient private String shrgkType = null;

    @Column(name=SHRGK + "$", nullable=true)
    protected String getShrgkType() {
        if (shrgkType == null && shrgk != null) return shrgk.getType().toString();
        if (shrgkType == null && getShrgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'shrgk$' should not be NULL."));
        }
        return shrgkType;
    }

    protected void setShrgkType(String type) {
        shrgkType = type;
        shrgk = Optional.fromNullable(toCurrencyType(shrgkType))
            .transform(bizCurrencyTransformer(getShrgkValue()))
            .orNull();
    }

    private String shririyuu1;

    @Column(name=GenIT_BAK_KouzaHrkmTuuti.SHRIRIYUU1)
    public String getShririyuu1() {
        return shririyuu1;
    }

    public void setShririyuu1(String pShririyuu1) {
        shririyuu1 = pShririyuu1;
    }

    private String shririyuu2;

    @Column(name=GenIT_BAK_KouzaHrkmTuuti.SHRIRIYUU2)
    public String getShririyuu2() {
        return shririyuu2;
    }

    public void setShririyuu2(String pShririyuu2) {
        shririyuu2 = pShririyuu2;
    }

    private String shririyuu3;

    @Column(name=GenIT_BAK_KouzaHrkmTuuti.SHRIRIYUU3)
    public String getShririyuu3() {
        return shririyuu3;
    }

    public void setShririyuu3(String pShririyuu3) {
        shririyuu3 = pShririyuu3;
    }

    private String siteikouza1;

    @Column(name=GenIT_BAK_KouzaHrkmTuuti.SITEIKOUZA1)
    public String getSiteikouza1() {
        return siteikouza1;
    }

    public void setSiteikouza1(String pSiteikouza1) {
        siteikouza1 = pSiteikouza1;
    }

    private String siteikouza2;

    @Column(name=GenIT_BAK_KouzaHrkmTuuti.SITEIKOUZA2)
    public String getSiteikouza2() {
        return siteikouza2;
    }

    public void setSiteikouza2(String pSiteikouza2) {
        siteikouza2 = pSiteikouza2;
    }

    private String siteikouza3;

    @Column(name=GenIT_BAK_KouzaHrkmTuuti.SITEIKOUZA3)
    public String getSiteikouza3() {
        return siteikouza3;
    }

    public void setSiteikouza3(String pSiteikouza3) {
        siteikouza3 = pSiteikouza3;
    }

    private String siteikouza4;

    @Column(name=GenIT_BAK_KouzaHrkmTuuti.SITEIKOUZA4)
    public String getSiteikouza4() {
        return siteikouza4;
    }

    public void setSiteikouza4(String pSiteikouza4) {
        siteikouza4 = pSiteikouza4;
    }

    private String siteikouza5;

    @Column(name=GenIT_BAK_KouzaHrkmTuuti.SITEIKOUZA5)
    public String getSiteikouza5() {
        return siteikouza5;
    }

    public void setSiteikouza5(String pSiteikouza5) {
        siteikouza5 = pSiteikouza5;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_BAK_KouzaHrkmTuuti.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_BAK_KouzaHrkmTuuti.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_BAK_KouzaHrkmTuuti.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}