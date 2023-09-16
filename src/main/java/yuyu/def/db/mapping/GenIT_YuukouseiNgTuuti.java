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
import yuyu.def.db.entity.IT_YuukouseiNgTuuti;
import yuyu.def.db.id.PKIT_YuukouseiNgTuuti;
import yuyu.def.db.meta.GenQIT_YuukouseiNgTuuti;
import yuyu.def.db.meta.QIT_YuukouseiNgTuuti;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 有効性確認ＮＧ通知テーブル テーブルのマッピング情報クラスで、 {@link IT_YuukouseiNgTuuti} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_YuukouseiNgTuuti}</td><td colspan="3">有効性確認ＮＧ通知テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_YuukouseiNgTuuti ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_YuukouseiNgTuuti ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">{@link PKIT_YuukouseiNgTuuti ○}</td><td align="center">V</td><td>BizDate</td></tr>
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
 *  <tr><td>{@link #getOsirasemongon46keta1 osirasemongon46keta1}</td><td>お知らせ文言（４６桁）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon46keta2 osirasemongon46keta2}</td><td>お知らせ文言（４６桁）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon46keta3 osirasemongon46keta3}</td><td>お知らせ文言（４６桁）３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon46keta4 osirasemongon46keta4}</td><td>お知らせ文言（４６桁）４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon46keta5 osirasemongon46keta5}</td><td>お知らせ文言（４６桁）５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon46keta6 osirasemongon46keta6}</td><td>お知らせ文言（４６桁）６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon46keta7 osirasemongon46keta7}</td><td>お知らせ文言（４６桁）７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon46keta8 osirasemongon46keta8}</td><td>お知らせ文言（４６桁）８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon46keta9 osirasemongon46keta9}</td><td>お知らせ文言（４６桁）９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon46keta10 osirasemongon46keta10}</td><td>お知らせ文言（４６桁）１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkj kyknmkj}</td><td>契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokenryou hokenryou}</td><td>保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getCreditcardinfo1 creditcardinfo1}</td><td>クレジットカード情報１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardinfo2 creditcardinfo2}</td><td>クレジットカード情報２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardinfo3 creditcardinfo3}</td><td>クレジットカード情報３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardmaskingmsg creditcardmaskingmsg}</td><td>クレジットカードマスキングＭＳＧ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGoiraijikoutoumongon1 goiraijikoutoumongon1}</td><td>ご依頼事項等文言１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGoiraijikoutoumongon2 goiraijikoutoumongon2}</td><td>ご依頼事項等文言２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGoiraijikoutoumongon3 goiraijikoutoumongon3}</td><td>ご依頼事項等文言３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPhrkmongon1 phrkmongon1}</td><td>保険料のお払込み文言１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPhrkmongon2 phrkmongon2}</td><td>保険料のお払込み文言２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPhrkmongon3 phrkmongon3}</td><td>保険料のお払込み文言３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPhrkmongon4 phrkmongon4}</td><td>保険料のお払込み文言４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPhrkmongon5 phrkmongon5}</td><td>保険料のお払込み文言５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPhrkmongon6 phrkmongon6}</td><td>保険料のお払込み文言６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPhrkmongon7 phrkmongon7}</td><td>保険料のお払込み文言７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPhrkmongon8 phrkmongon8}</td><td>保険料のお払込み文言８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPhrkmongon9 phrkmongon9}</td><td>保険料のお払込み文言９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>{@link #getHassoukbn hassoukbn}</td><td>発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HassouKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_YuukouseiNgTuuti
 * @see     PKIT_YuukouseiNgTuuti
 * @see     QIT_YuukouseiNgTuuti
 * @see     GenQIT_YuukouseiNgTuuti
 */
@MappedSuperclass
@Table(name=GenIT_YuukouseiNgTuuti.TABLE_NAME)
@IdClass(value=PKIT_YuukouseiNgTuuti.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HassouKbn", typeClass=UserType_C_HassouKbn.class),
    @TypeDef(name="UserType_C_SyoruiCdKbn", typeClass=UserType_C_SyoruiCdKbn.class)
})
public abstract class GenIT_YuukouseiNgTuuti extends AbstractExDBEntity<IT_YuukouseiNgTuuti, PKIT_YuukouseiNgTuuti> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_YuukouseiNgTuuti";
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
    public static final String OSIRASEMONGON46KETA1     = "osirasemongon46keta1";
    public static final String OSIRASEMONGON46KETA2     = "osirasemongon46keta2";
    public static final String OSIRASEMONGON46KETA3     = "osirasemongon46keta3";
    public static final String OSIRASEMONGON46KETA4     = "osirasemongon46keta4";
    public static final String OSIRASEMONGON46KETA5     = "osirasemongon46keta5";
    public static final String OSIRASEMONGON46KETA6     = "osirasemongon46keta6";
    public static final String OSIRASEMONGON46KETA7     = "osirasemongon46keta7";
    public static final String OSIRASEMONGON46KETA8     = "osirasemongon46keta8";
    public static final String OSIRASEMONGON46KETA9     = "osirasemongon46keta9";
    public static final String OSIRASEMONGON46KETA10    = "osirasemongon46keta10";
    public static final String KYKNMKJ                  = "kyknmkj";
    public static final String HOKENRYOU                = "hokenryou";
    public static final String CREDITCARDINFO1          = "creditcardinfo1";
    public static final String CREDITCARDINFO2          = "creditcardinfo2";
    public static final String CREDITCARDINFO3          = "creditcardinfo3";
    public static final String CREDITCARDMASKINGMSG     = "creditcardmaskingmsg";
    public static final String GOIRAIJIKOUTOUMONGON1    = "goiraijikoutoumongon1";
    public static final String GOIRAIJIKOUTOUMONGON2    = "goiraijikoutoumongon2";
    public static final String GOIRAIJIKOUTOUMONGON3    = "goiraijikoutoumongon3";
    public static final String PHRKMONGON1              = "phrkmongon1";
    public static final String PHRKMONGON2              = "phrkmongon2";
    public static final String PHRKMONGON3              = "phrkmongon3";
    public static final String PHRKMONGON4              = "phrkmongon4";
    public static final String PHRKMONGON5              = "phrkmongon5";
    public static final String PHRKMONGON6              = "phrkmongon6";
    public static final String PHRKMONGON7              = "phrkmongon7";
    public static final String PHRKMONGON8              = "phrkmongon8";
    public static final String PHRKMONGON9              = "phrkmongon9";
    public static final String SYORUICD                 = "syoruiCd";
    public static final String HASSOUKBN                = "hassoukbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_YuukouseiNgTuuti primaryKey;

    public GenIT_YuukouseiNgTuuti() {
        primaryKey = new PKIT_YuukouseiNgTuuti();
    }

    public GenIT_YuukouseiNgTuuti(
        String pKbnkey,
        String pSyono,
        BizDate pTyouhyouymd
    ) {
        primaryKey = new PKIT_YuukouseiNgTuuti(
            pKbnkey,
            pSyono,
            pTyouhyouymd
        );
    }

    @Transient
    @Override
    public PKIT_YuukouseiNgTuuti getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_YuukouseiNgTuuti> getMetaClass() {
        return QIT_YuukouseiNgTuuti.class;
    }

    @Id
    @Column(name=GenIT_YuukouseiNgTuuti.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_YuukouseiNgTuuti.SYONO)
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
    @Column(name=GenIT_YuukouseiNgTuuti.TYOUHYOUYMD)
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

    @Column(name=GenIT_YuukouseiNgTuuti.SHSKYNO)
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

    @Column(name=GenIT_YuukouseiNgTuuti.SHSADR1KJ)
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

    @Column(name=GenIT_YuukouseiNgTuuti.SHSADR2KJ)
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

    @Column(name=GenIT_YuukouseiNgTuuti.SHSADR3KJ)
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

    @Column(name=GenIT_YuukouseiNgTuuti.SHSNMKJ)
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

    @Column(name=GenIT_YuukouseiNgTuuti.TOIAWASESOSIKINMKJ)
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

    @Column(name=GenIT_YuukouseiNgTuuti.TOIAWASEYNO)
    public String getToiawaseyno() {
        return toiawaseyno;
    }

    public void setToiawaseyno(String pToiawaseyno) {
        toiawaseyno = pToiawaseyno;
    }

    private String toiawaseadr1kj;

    @Column(name=GenIT_YuukouseiNgTuuti.TOIAWASEADR1KJ)
    public String getToiawaseadr1kj() {
        return toiawaseadr1kj;
    }

    public void setToiawaseadr1kj(String pToiawaseadr1kj) {
        toiawaseadr1kj = pToiawaseadr1kj;
    }

    private String toiawaseadr2kj;

    @Column(name=GenIT_YuukouseiNgTuuti.TOIAWASEADR2KJ)
    public String getToiawaseadr2kj() {
        return toiawaseadr2kj;
    }

    public void setToiawaseadr2kj(String pToiawaseadr2kj) {
        toiawaseadr2kj = pToiawaseadr2kj;
    }

    private String toiawaseadr3kj;

    @Column(name=GenIT_YuukouseiNgTuuti.TOIAWASEADR3KJ)
    public String getToiawaseadr3kj() {
        return toiawaseadr3kj;
    }

    public void setToiawaseadr3kj(String pToiawaseadr3kj) {
        toiawaseadr3kj = pToiawaseadr3kj;
    }

    private String toiawasetelno;

    @Column(name=GenIT_YuukouseiNgTuuti.TOIAWASETELNO)
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

    @Column(name=GenIT_YuukouseiNgTuuti.TOIAWASETELUKTKKANOU1)
    public String getToiawaseteluktkkanou1() {
        return toiawaseteluktkkanou1;
    }

    public void setToiawaseteluktkkanou1(String pToiawaseteluktkkanou1) {
        toiawaseteluktkkanou1 = pToiawaseteluktkkanou1;
    }

    private String toiawaseteluktkkanou2;

    @Column(name=GenIT_YuukouseiNgTuuti.TOIAWASETELUKTKKANOU2)
    public String getToiawaseteluktkkanou2() {
        return toiawaseteluktkkanou2;
    }

    public void setToiawaseteluktkkanou2(String pToiawaseteluktkkanou2) {
        toiawaseteluktkkanou2 = pToiawaseteluktkkanou2;
    }

    private String toiawasesosikinmkj2;

    @Column(name=GenIT_YuukouseiNgTuuti.TOIAWASESOSIKINMKJ2)
    public String getToiawasesosikinmkj2() {
        return toiawasesosikinmkj2;
    }

    public void setToiawasesosikinmkj2(String pToiawasesosikinmkj2) {
        toiawasesosikinmkj2 = pToiawasesosikinmkj2;
    }

    private String toiawasetelno2;

    @Column(name=GenIT_YuukouseiNgTuuti.TOIAWASETELNO2)
    public String getToiawasetelno2() {
        return toiawasetelno2;
    }

    public void setToiawasetelno2(String pToiawasetelno2) {
        toiawasetelno2 = pToiawasetelno2;
    }

    private String osirasemongon46keta1;

    @Column(name=GenIT_YuukouseiNgTuuti.OSIRASEMONGON46KETA1)
    public String getOsirasemongon46keta1() {
        return osirasemongon46keta1;
    }

    public void setOsirasemongon46keta1(String pOsirasemongon46keta1) {
        osirasemongon46keta1 = pOsirasemongon46keta1;
    }

    private String osirasemongon46keta2;

    @Column(name=GenIT_YuukouseiNgTuuti.OSIRASEMONGON46KETA2)
    public String getOsirasemongon46keta2() {
        return osirasemongon46keta2;
    }

    public void setOsirasemongon46keta2(String pOsirasemongon46keta2) {
        osirasemongon46keta2 = pOsirasemongon46keta2;
    }

    private String osirasemongon46keta3;

    @Column(name=GenIT_YuukouseiNgTuuti.OSIRASEMONGON46KETA3)
    public String getOsirasemongon46keta3() {
        return osirasemongon46keta3;
    }

    public void setOsirasemongon46keta3(String pOsirasemongon46keta3) {
        osirasemongon46keta3 = pOsirasemongon46keta3;
    }

    private String osirasemongon46keta4;

    @Column(name=GenIT_YuukouseiNgTuuti.OSIRASEMONGON46KETA4)
    public String getOsirasemongon46keta4() {
        return osirasemongon46keta4;
    }

    public void setOsirasemongon46keta4(String pOsirasemongon46keta4) {
        osirasemongon46keta4 = pOsirasemongon46keta4;
    }

    private String osirasemongon46keta5;

    @Column(name=GenIT_YuukouseiNgTuuti.OSIRASEMONGON46KETA5)
    public String getOsirasemongon46keta5() {
        return osirasemongon46keta5;
    }

    public void setOsirasemongon46keta5(String pOsirasemongon46keta5) {
        osirasemongon46keta5 = pOsirasemongon46keta5;
    }

    private String osirasemongon46keta6;

    @Column(name=GenIT_YuukouseiNgTuuti.OSIRASEMONGON46KETA6)
    public String getOsirasemongon46keta6() {
        return osirasemongon46keta6;
    }

    public void setOsirasemongon46keta6(String pOsirasemongon46keta6) {
        osirasemongon46keta6 = pOsirasemongon46keta6;
    }

    private String osirasemongon46keta7;

    @Column(name=GenIT_YuukouseiNgTuuti.OSIRASEMONGON46KETA7)
    public String getOsirasemongon46keta7() {
        return osirasemongon46keta7;
    }

    public void setOsirasemongon46keta7(String pOsirasemongon46keta7) {
        osirasemongon46keta7 = pOsirasemongon46keta7;
    }

    private String osirasemongon46keta8;

    @Column(name=GenIT_YuukouseiNgTuuti.OSIRASEMONGON46KETA8)
    public String getOsirasemongon46keta8() {
        return osirasemongon46keta8;
    }

    public void setOsirasemongon46keta8(String pOsirasemongon46keta8) {
        osirasemongon46keta8 = pOsirasemongon46keta8;
    }

    private String osirasemongon46keta9;

    @Column(name=GenIT_YuukouseiNgTuuti.OSIRASEMONGON46KETA9)
    public String getOsirasemongon46keta9() {
        return osirasemongon46keta9;
    }

    public void setOsirasemongon46keta9(String pOsirasemongon46keta9) {
        osirasemongon46keta9 = pOsirasemongon46keta9;
    }

    private String osirasemongon46keta10;

    @Column(name=GenIT_YuukouseiNgTuuti.OSIRASEMONGON46KETA10)
    public String getOsirasemongon46keta10() {
        return osirasemongon46keta10;
    }

    public void setOsirasemongon46keta10(String pOsirasemongon46keta10) {
        osirasemongon46keta10 = pOsirasemongon46keta10;
    }

    private String kyknmkj;

    @Column(name=GenIT_YuukouseiNgTuuti.KYKNMKJ)
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

    private BizCurrency hokenryou;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHokenryou() {
        return hokenryou;
    }

    public void setHokenryou(BizCurrency pHokenryou) {
        hokenryou = pHokenryou;
        hokenryouValue = null;
        hokenryouType  = null;
    }

    transient private BigDecimal hokenryouValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HOKENRYOU, nullable=true)
    protected BigDecimal getHokenryouValue() {
        if (hokenryouValue == null && hokenryou != null) {
            if (hokenryou.isOptional()) return null;
            return hokenryou.absolute();
        }
        return hokenryouValue;
    }

    protected void setHokenryouValue(BigDecimal value) {
        hokenryouValue = value;
        hokenryou = Optional.fromNullable(toCurrencyType(hokenryouType))
            .transform(bizCurrencyTransformer(getHokenryouValue()))
            .orNull();
    }

    transient private String hokenryouType = null;

    @Column(name=HOKENRYOU + "$", nullable=true)
    protected String getHokenryouType() {
        if (hokenryouType == null && hokenryou != null) return hokenryou.getType().toString();
        if (hokenryouType == null && getHokenryouValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hokenryou$' should not be NULL."));
        }
        return hokenryouType;
    }

    protected void setHokenryouType(String type) {
        hokenryouType = type;
        hokenryou = Optional.fromNullable(toCurrencyType(hokenryouType))
            .transform(bizCurrencyTransformer(getHokenryouValue()))
            .orNull();
    }

    private String creditcardinfo1;

    @Column(name=GenIT_YuukouseiNgTuuti.CREDITCARDINFO1)
    public String getCreditcardinfo1() {
        return creditcardinfo1;
    }

    public void setCreditcardinfo1(String pCreditcardinfo1) {
        creditcardinfo1 = pCreditcardinfo1;
    }

    private String creditcardinfo2;

    @Column(name=GenIT_YuukouseiNgTuuti.CREDITCARDINFO2)
    public String getCreditcardinfo2() {
        return creditcardinfo2;
    }

    public void setCreditcardinfo2(String pCreditcardinfo2) {
        creditcardinfo2 = pCreditcardinfo2;
    }

    private String creditcardinfo3;

    @Column(name=GenIT_YuukouseiNgTuuti.CREDITCARDINFO3)
    public String getCreditcardinfo3() {
        return creditcardinfo3;
    }

    public void setCreditcardinfo3(String pCreditcardinfo3) {
        creditcardinfo3 = pCreditcardinfo3;
    }

    private String creditcardmaskingmsg;

    @Column(name=GenIT_YuukouseiNgTuuti.CREDITCARDMASKINGMSG)
    public String getCreditcardmaskingmsg() {
        return creditcardmaskingmsg;
    }

    public void setCreditcardmaskingmsg(String pCreditcardmaskingmsg) {
        creditcardmaskingmsg = pCreditcardmaskingmsg;
    }

    private String goiraijikoutoumongon1;

    @Column(name=GenIT_YuukouseiNgTuuti.GOIRAIJIKOUTOUMONGON1)
    public String getGoiraijikoutoumongon1() {
        return goiraijikoutoumongon1;
    }

    public void setGoiraijikoutoumongon1(String pGoiraijikoutoumongon1) {
        goiraijikoutoumongon1 = pGoiraijikoutoumongon1;
    }

    private String goiraijikoutoumongon2;

    @Column(name=GenIT_YuukouseiNgTuuti.GOIRAIJIKOUTOUMONGON2)
    public String getGoiraijikoutoumongon2() {
        return goiraijikoutoumongon2;
    }

    public void setGoiraijikoutoumongon2(String pGoiraijikoutoumongon2) {
        goiraijikoutoumongon2 = pGoiraijikoutoumongon2;
    }

    private String goiraijikoutoumongon3;

    @Column(name=GenIT_YuukouseiNgTuuti.GOIRAIJIKOUTOUMONGON3)
    public String getGoiraijikoutoumongon3() {
        return goiraijikoutoumongon3;
    }

    public void setGoiraijikoutoumongon3(String pGoiraijikoutoumongon3) {
        goiraijikoutoumongon3 = pGoiraijikoutoumongon3;
    }

    private String phrkmongon1;

    @Column(name=GenIT_YuukouseiNgTuuti.PHRKMONGON1)
    public String getPhrkmongon1() {
        return phrkmongon1;
    }

    public void setPhrkmongon1(String pPhrkmongon1) {
        phrkmongon1 = pPhrkmongon1;
    }

    private String phrkmongon2;

    @Column(name=GenIT_YuukouseiNgTuuti.PHRKMONGON2)
    public String getPhrkmongon2() {
        return phrkmongon2;
    }

    public void setPhrkmongon2(String pPhrkmongon2) {
        phrkmongon2 = pPhrkmongon2;
    }

    private String phrkmongon3;

    @Column(name=GenIT_YuukouseiNgTuuti.PHRKMONGON3)
    public String getPhrkmongon3() {
        return phrkmongon3;
    }

    public void setPhrkmongon3(String pPhrkmongon3) {
        phrkmongon3 = pPhrkmongon3;
    }

    private String phrkmongon4;

    @Column(name=GenIT_YuukouseiNgTuuti.PHRKMONGON4)
    public String getPhrkmongon4() {
        return phrkmongon4;
    }

    public void setPhrkmongon4(String pPhrkmongon4) {
        phrkmongon4 = pPhrkmongon4;
    }

    private String phrkmongon5;

    @Column(name=GenIT_YuukouseiNgTuuti.PHRKMONGON5)
    public String getPhrkmongon5() {
        return phrkmongon5;
    }

    public void setPhrkmongon5(String pPhrkmongon5) {
        phrkmongon5 = pPhrkmongon5;
    }

    private String phrkmongon6;

    @Column(name=GenIT_YuukouseiNgTuuti.PHRKMONGON6)
    public String getPhrkmongon6() {
        return phrkmongon6;
    }

    public void setPhrkmongon6(String pPhrkmongon6) {
        phrkmongon6 = pPhrkmongon6;
    }

    private String phrkmongon7;

    @Column(name=GenIT_YuukouseiNgTuuti.PHRKMONGON7)
    public String getPhrkmongon7() {
        return phrkmongon7;
    }

    public void setPhrkmongon7(String pPhrkmongon7) {
        phrkmongon7 = pPhrkmongon7;
    }

    private String phrkmongon8;

    @Column(name=GenIT_YuukouseiNgTuuti.PHRKMONGON8)
    public String getPhrkmongon8() {
        return phrkmongon8;
    }

    public void setPhrkmongon8(String pPhrkmongon8) {
        phrkmongon8 = pPhrkmongon8;
    }

    private String phrkmongon9;

    @Column(name=GenIT_YuukouseiNgTuuti.PHRKMONGON9)
    public String getPhrkmongon9() {
        return phrkmongon9;
    }

    public void setPhrkmongon9(String pPhrkmongon9) {
        phrkmongon9 = pPhrkmongon9;
    }

    private C_SyoruiCdKbn syoruiCd;

    @Type(type="UserType_C_SyoruiCdKbn")
    @Column(name=GenIT_YuukouseiNgTuuti.SYORUICD)
    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }

    private C_HassouKbn hassoukbn;

    @Type(type="UserType_C_HassouKbn")
    @Column(name=GenIT_YuukouseiNgTuuti.HASSOUKBN)
    public C_HassouKbn getHassoukbn() {
        return hassoukbn;
    }

    public void setHassoukbn(C_HassouKbn pHassoukbn) {
        hassoukbn = pHassoukbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_YuukouseiNgTuuti.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_YuukouseiNgTuuti.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_YuukouseiNgTuuti.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}