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
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_GinkouMdhnFollowCall;
import yuyu.def.db.id.PKIT_GinkouMdhnFollowCall;
import yuyu.def.db.meta.GenQIT_GinkouMdhnFollowCall;
import yuyu.def.db.meta.QIT_GinkouMdhnFollowCall;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;
import yuyu.infr.validation.constraints.Tel;

/**
 * 銀行窓販フォローコール対象テーブル テーブルのマッピング情報クラスで、 {@link IT_GinkouMdhnFollowCall} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_GinkouMdhnFollowCall}</td><td colspan="3">銀行窓販フォローコール対象テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_GinkouMdhnFollowCall ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKIT_GinkouMdhnFollowCall ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_GinkouMdhnFollowCall ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyksakuinmeino kyksakuinmeino}</td><td>契約者索引名番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykseiymd kykseiymd}</td><td>契約者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKyknmkj kyknmkj}</td><td>契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkn kyknmkn}</td><td>契約者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsintelno tsintelno}</td><td>通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getFollowcallsyorikbn followcallsyorikbn}</td><td>フォローコール処理区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinyno tsinyno}</td><td>通信先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr1kj tsinadr1kj}</td><td>通信先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr2kj tsinadr2kj}</td><td>通信先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr3kj tsinadr3kj}</td><td>通信先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBsyujdrtencd1 bsyujdrtencd1}</td><td>募集時代理店コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBsyujbosyuucd1 bsyujbosyuucd1}</td><td>募集時募集人コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBsyujdrtencd2 bsyujdrtencd2}</td><td>募集時代理店コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBsyujbosyuucd2 bsyujbosyuucd2}</td><td>募集時募集人コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBsyujdrtencd3 bsyujdrtencd3}</td><td>募集時代理店コード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBsyujbosyuucd3 bsyujbosyuucd3}</td><td>募集時募集人コード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBsyujdrtencd4 bsyujdrtencd4}</td><td>募集時代理店コード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBsyujbosyuucd4 bsyujbosyuucd4}</td><td>募集時募集人コード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBsyujdrtencd5 bsyujdrtencd5}</td><td>募集時代理店コード５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBsyujbosyuucd5 bsyujbosyuucd5}</td><td>募集時募集人コード５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSaisindrtencd saisindrtencd}</td><td>最新代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSaisinbosyuucd saisinbosyuucd}</td><td>最新募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnnm syouhnnm}</td><td>商品名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getJkipjytym jkipjytym}</td><td>次回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getAnnaigk annaigk}</td><td>案内金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHrkkeiro hrkkeiro}</td><td>払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkeiro}</td></tr>
 *  <tr><td>{@link #getFchrkkaisuu fchrkkaisuu}</td><td>フォローコール払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAnniskcd anniskcd}</td><td>案内先コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzmeiginmkn kzmeiginmkn}</td><td>口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmkj hhknnmkj}</td><td>被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmkn hhknnmkn}</td><td>被保険者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknsei hhknsei}</td><td>被保険者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hhknsei}</td></tr>
 *  <tr><td>{@link #getHhknseiymd hhknseiymd}</td><td>被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMinyuym minyuym}</td><td>未入年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getKyknmhnykkbn kyknmhnykkbn}</td><td>契約者名翻訳結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmhnykkbn hhknnmhnykkbn}</td><td>被保険者名翻訳結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_GinkouMdhnFollowCall
 * @see     PKIT_GinkouMdhnFollowCall
 * @see     QIT_GinkouMdhnFollowCall
 * @see     GenQIT_GinkouMdhnFollowCall
 */
@MappedSuperclass
@Table(name=GenIT_GinkouMdhnFollowCall.TABLE_NAME)
@IdClass(value=PKIT_GinkouMdhnFollowCall.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_Hhknsei", typeClass=UserType_C_Hhknsei.class),
    @TypeDef(name="UserType_C_Hrkkeiro", typeClass=UserType_C_Hrkkeiro.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class)
})
public abstract class GenIT_GinkouMdhnFollowCall extends AbstractExDBEntity<IT_GinkouMdhnFollowCall, PKIT_GinkouMdhnFollowCall> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_GinkouMdhnFollowCall";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String SYONO                    = "syono";
    public static final String KYKSAKUINMEINO           = "kyksakuinmeino";
    public static final String KYKSEIYMD                = "kykseiymd";
    public static final String KYKNMKJ                  = "kyknmkj";
    public static final String KYKNMKN                  = "kyknmkn";
    public static final String TSINTELNO                = "tsintelno";
    public static final String FOLLOWCALLSYORIKBN       = "followcallsyorikbn";
    public static final String TSINYNO                  = "tsinyno";
    public static final String TSINADR1KJ               = "tsinadr1kj";
    public static final String TSINADR2KJ               = "tsinadr2kj";
    public static final String TSINADR3KJ               = "tsinadr3kj";
    public static final String BSYUJDRTENCD1            = "bsyujdrtencd1";
    public static final String BSYUJBOSYUUCD1           = "bsyujbosyuucd1";
    public static final String BSYUJDRTENCD2            = "bsyujdrtencd2";
    public static final String BSYUJBOSYUUCD2           = "bsyujbosyuucd2";
    public static final String BSYUJDRTENCD3            = "bsyujdrtencd3";
    public static final String BSYUJBOSYUUCD3           = "bsyujbosyuucd3";
    public static final String BSYUJDRTENCD4            = "bsyujdrtencd4";
    public static final String BSYUJBOSYUUCD4           = "bsyujbosyuucd4";
    public static final String BSYUJDRTENCD5            = "bsyujdrtencd5";
    public static final String BSYUJBOSYUUCD5           = "bsyujbosyuucd5";
    public static final String SAISINDRTENCD            = "saisindrtencd";
    public static final String SAISINBOSYUUCD           = "saisinbosyuucd";
    public static final String SYOUHNNM                 = "syouhnnm";
    public static final String KYKYMD                   = "kykymd";
    public static final String JKIPJYTYM                = "jkipjytym";
    public static final String ANNAIGK                  = "annaigk";
    public static final String HRKKEIRO                 = "hrkkeiro";
    public static final String FCHRKKAISUU              = "fchrkkaisuu";
    public static final String ANNISKCD                 = "anniskcd";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO                  = "kouzano";
    public static final String KZMEIGINMKN              = "kzmeiginmkn";
    public static final String HHKNNMKJ                 = "hhknnmkj";
    public static final String HHKNNMKN                 = "hhknnmkn";
    public static final String HHKNSEI                  = "hhknsei";
    public static final String HHKNSEIYMD               = "hhknseiymd";
    public static final String MINYUYM                  = "minyuym";
    public static final String KYKNMHNYKKBN             = "kyknmhnykkbn";
    public static final String HHKNNMHNYKKBN            = "hhknnmhnykkbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_GinkouMdhnFollowCall primaryKey;

    public GenIT_GinkouMdhnFollowCall() {
        primaryKey = new PKIT_GinkouMdhnFollowCall();
    }

    public GenIT_GinkouMdhnFollowCall(
        String pKbnkey,
        BizDate pSyoriYmd,
        String pSyono
    ) {
        primaryKey = new PKIT_GinkouMdhnFollowCall(
            pKbnkey,
            pSyoriYmd,
            pSyono
        );
    }

    @Transient
    @Override
    public PKIT_GinkouMdhnFollowCall getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_GinkouMdhnFollowCall> getMetaClass() {
        return QIT_GinkouMdhnFollowCall.class;
    }

    @Id
    @Column(name=GenIT_GinkouMdhnFollowCall.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenIT_GinkouMdhnFollowCall.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return getPrimaryKey().getSyoriYmd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        getPrimaryKey().setSyoriYmd(pSyoriYmd);
    }

    @Id
    @Column(name=GenIT_GinkouMdhnFollowCall.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    private String kyksakuinmeino;

    @Column(name=GenIT_GinkouMdhnFollowCall.KYKSAKUINMEINO)
    public String getKyksakuinmeino() {
        return kyksakuinmeino;
    }

    public void setKyksakuinmeino(String pKyksakuinmeino) {
        kyksakuinmeino = pKyksakuinmeino;
    }

    private BizDate kykseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_GinkouMdhnFollowCall.KYKSEIYMD)
    @ValidDate
    public BizDate getKykseiymd() {
        return kykseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykseiymd(BizDate pKykseiymd) {
        kykseiymd = pKykseiymd;
    }

    private String kyknmkj;

    @Column(name=GenIT_GinkouMdhnFollowCall.KYKNMKJ)
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

    private String kyknmkn;

    @Column(name=GenIT_GinkouMdhnFollowCall.KYKNMKN)
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

    private String tsintelno;

    @Column(name=GenIT_GinkouMdhnFollowCall.TSINTELNO)
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

    private String followcallsyorikbn;

    @Column(name=GenIT_GinkouMdhnFollowCall.FOLLOWCALLSYORIKBN)
    public String getFollowcallsyorikbn() {
        return followcallsyorikbn;
    }

    public void setFollowcallsyorikbn(String pFollowcallsyorikbn) {
        followcallsyorikbn = pFollowcallsyorikbn;
    }

    private String tsinyno;

    @Column(name=GenIT_GinkouMdhnFollowCall.TSINYNO)
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

    @Column(name=GenIT_GinkouMdhnFollowCall.TSINADR1KJ)
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

    @Column(name=GenIT_GinkouMdhnFollowCall.TSINADR2KJ)
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

    @Column(name=GenIT_GinkouMdhnFollowCall.TSINADR3KJ)
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

    private String bsyujdrtencd1;

    @Column(name=GenIT_GinkouMdhnFollowCall.BSYUJDRTENCD1)
    public String getBsyujdrtencd1() {
        return bsyujdrtencd1;
    }

    public void setBsyujdrtencd1(String pBsyujdrtencd1) {
        bsyujdrtencd1 = pBsyujdrtencd1;
    }

    private String bsyujbosyuucd1;

    @Column(name=GenIT_GinkouMdhnFollowCall.BSYUJBOSYUUCD1)
    public String getBsyujbosyuucd1() {
        return bsyujbosyuucd1;
    }

    public void setBsyujbosyuucd1(String pBsyujbosyuucd1) {
        bsyujbosyuucd1 = pBsyujbosyuucd1;
    }

    private String bsyujdrtencd2;

    @Column(name=GenIT_GinkouMdhnFollowCall.BSYUJDRTENCD2)
    public String getBsyujdrtencd2() {
        return bsyujdrtencd2;
    }

    public void setBsyujdrtencd2(String pBsyujdrtencd2) {
        bsyujdrtencd2 = pBsyujdrtencd2;
    }

    private String bsyujbosyuucd2;

    @Column(name=GenIT_GinkouMdhnFollowCall.BSYUJBOSYUUCD2)
    public String getBsyujbosyuucd2() {
        return bsyujbosyuucd2;
    }

    public void setBsyujbosyuucd2(String pBsyujbosyuucd2) {
        bsyujbosyuucd2 = pBsyujbosyuucd2;
    }

    private String bsyujdrtencd3;

    @Column(name=GenIT_GinkouMdhnFollowCall.BSYUJDRTENCD3)
    public String getBsyujdrtencd3() {
        return bsyujdrtencd3;
    }

    public void setBsyujdrtencd3(String pBsyujdrtencd3) {
        bsyujdrtencd3 = pBsyujdrtencd3;
    }

    private String bsyujbosyuucd3;

    @Column(name=GenIT_GinkouMdhnFollowCall.BSYUJBOSYUUCD3)
    public String getBsyujbosyuucd3() {
        return bsyujbosyuucd3;
    }

    public void setBsyujbosyuucd3(String pBsyujbosyuucd3) {
        bsyujbosyuucd3 = pBsyujbosyuucd3;
    }

    private String bsyujdrtencd4;

    @Column(name=GenIT_GinkouMdhnFollowCall.BSYUJDRTENCD4)
    public String getBsyujdrtencd4() {
        return bsyujdrtencd4;
    }

    public void setBsyujdrtencd4(String pBsyujdrtencd4) {
        bsyujdrtencd4 = pBsyujdrtencd4;
    }

    private String bsyujbosyuucd4;

    @Column(name=GenIT_GinkouMdhnFollowCall.BSYUJBOSYUUCD4)
    public String getBsyujbosyuucd4() {
        return bsyujbosyuucd4;
    }

    public void setBsyujbosyuucd4(String pBsyujbosyuucd4) {
        bsyujbosyuucd4 = pBsyujbosyuucd4;
    }

    private String bsyujdrtencd5;

    @Column(name=GenIT_GinkouMdhnFollowCall.BSYUJDRTENCD5)
    public String getBsyujdrtencd5() {
        return bsyujdrtencd5;
    }

    public void setBsyujdrtencd5(String pBsyujdrtencd5) {
        bsyujdrtencd5 = pBsyujdrtencd5;
    }

    private String bsyujbosyuucd5;

    @Column(name=GenIT_GinkouMdhnFollowCall.BSYUJBOSYUUCD5)
    public String getBsyujbosyuucd5() {
        return bsyujbosyuucd5;
    }

    public void setBsyujbosyuucd5(String pBsyujbosyuucd5) {
        bsyujbosyuucd5 = pBsyujbosyuucd5;
    }

    private String saisindrtencd;

    @Column(name=GenIT_GinkouMdhnFollowCall.SAISINDRTENCD)
    public String getSaisindrtencd() {
        return saisindrtencd;
    }

    public void setSaisindrtencd(String pSaisindrtencd) {
        saisindrtencd = pSaisindrtencd;
    }

    private String saisinbosyuucd;

    @Column(name=GenIT_GinkouMdhnFollowCall.SAISINBOSYUUCD)
    public String getSaisinbosyuucd() {
        return saisinbosyuucd;
    }

    public void setSaisinbosyuucd(String pSaisinbosyuucd) {
        saisinbosyuucd = pSaisinbosyuucd;
    }

    private String syouhnnm;

    @Column(name=GenIT_GinkouMdhnFollowCall.SYOUHNNM)
    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    public String getSyouhnnm() {
        return syouhnnm;
    }

    @Trim("right")
    public void setSyouhnnm(String pSyouhnnm) {
        syouhnnm = pSyouhnnm;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_GinkouMdhnFollowCall.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private BizDateYM jkipjytym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_GinkouMdhnFollowCall.JKIPJYTYM)
    public BizDateYM getJkipjytym() {
        return jkipjytym;
    }

    @Trim("both")
    public void setJkipjytym(BizDateYM pJkipjytym) {
        jkipjytym = pJkipjytym;
    }

    private BizCurrency annaigk;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    public BizCurrency getAnnaigk() {
        return annaigk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setAnnaigk(BizCurrency pAnnaigk) {
        annaigk = pAnnaigk;
        annaigkValue = null;
        annaigkType  = null;
    }

    transient private BigDecimal annaigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ANNAIGK, nullable=true)
    protected BigDecimal getAnnaigkValue() {
        if (annaigkValue == null && annaigk != null) {
            if (annaigk.isOptional()) return null;
            return annaigk.absolute();
        }
        return annaigkValue;
    }

    protected void setAnnaigkValue(BigDecimal value) {
        annaigkValue = value;
        annaigk = Optional.fromNullable(toCurrencyType(annaigkType))
            .transform(bizCurrencyTransformer(getAnnaigkValue()))
            .orNull();
    }

    transient private String annaigkType = null;

    @Column(name=ANNAIGK + "$", nullable=true)
    protected String getAnnaigkType() {
        if (annaigkType == null && annaigk != null) return annaigk.getType().toString();
        if (annaigkType == null && getAnnaigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'annaigk$' should not be NULL."));
        }
        return annaigkType;
    }

    protected void setAnnaigkType(String type) {
        annaigkType = type;
        annaigk = Optional.fromNullable(toCurrencyType(annaigkType))
            .transform(bizCurrencyTransformer(getAnnaigkValue()))
            .orNull();
    }

    private C_Hrkkeiro hrkkeiro;

    @Type(type="UserType_C_Hrkkeiro")
    @Column(name=GenIT_GinkouMdhnFollowCall.HRKKEIRO)
    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }

    private String fchrkkaisuu;

    @Column(name=GenIT_GinkouMdhnFollowCall.FCHRKKAISUU)
    public String getFchrkkaisuu() {
        return fchrkkaisuu;
    }

    public void setFchrkkaisuu(String pFchrkkaisuu) {
        fchrkkaisuu = pFchrkkaisuu;
    }

    private String anniskcd;

    @Column(name=GenIT_GinkouMdhnFollowCall.ANNISKCD)
    public String getAnniskcd() {
        return anniskcd;
    }

    public void setAnniskcd(String pAnniskcd) {
        anniskcd = pAnniskcd;
    }

    private String bankcd;

    @Column(name=GenIT_GinkouMdhnFollowCall.BANKCD)
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

    @Column(name=GenIT_GinkouMdhnFollowCall.SITENCD)
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
    @Column(name=GenIT_GinkouMdhnFollowCall.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenIT_GinkouMdhnFollowCall.KOUZANO)
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

    @Column(name=GenIT_GinkouMdhnFollowCall.KZMEIGINMKN)
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

    private String hhknnmkj;

    @Column(name=GenIT_GinkouMdhnFollowCall.HHKNNMKJ)
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

    private String hhknnmkn;

    @Column(name=GenIT_GinkouMdhnFollowCall.HHKNNMKN)
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

    private C_Hhknsei hhknsei;

    @Type(type="UserType_C_Hhknsei")
    @Column(name=GenIT_GinkouMdhnFollowCall.HHKNSEI)
    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    private BizDate hhknseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_GinkouMdhnFollowCall.HHKNSEIYMD)
    @ValidDate
    public BizDate getHhknseiymd() {
        return hhknseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknseiymd(BizDate pHhknseiymd) {
        hhknseiymd = pHhknseiymd;
    }

    private BizDateYM minyuym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_GinkouMdhnFollowCall.MINYUYM)
    public BizDateYM getMinyuym() {
        return minyuym;
    }

    public void setMinyuym(BizDateYM pMinyuym) {
        minyuym = pMinyuym;
    }

    private String kyknmhnykkbn;

    @Column(name=GenIT_GinkouMdhnFollowCall.KYKNMHNYKKBN)
    public String getKyknmhnykkbn() {
        return kyknmhnykkbn;
    }

    public void setKyknmhnykkbn(String pKyknmhnykkbn) {
        kyknmhnykkbn = pKyknmhnykkbn;
    }

    private String hhknnmhnykkbn;

    @Column(name=GenIT_GinkouMdhnFollowCall.HHKNNMHNYKKBN)
    public String getHhknnmhnykkbn() {
        return hhknnmhnykkbn;
    }

    public void setHhknnmhnykkbn(String pHhknnmhnykkbn) {
        hhknnmhnykkbn = pHhknnmhnykkbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_GinkouMdhnFollowCall.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_GinkouMdhnFollowCall.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_GinkouMdhnFollowCall.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}