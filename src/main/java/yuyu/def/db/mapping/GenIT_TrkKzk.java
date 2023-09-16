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
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.db.entity.IT_TrkKzk;
import yuyu.def.db.id.PKIT_TrkKzk;
import yuyu.def.db.meta.GenQIT_TrkKzk;
import yuyu.def.db.meta.QIT_TrkKzk;
import yuyu.def.db.type.UserType_C_KjkhukaKbn;
import yuyu.def.db.type.UserType_C_Seibetu;
import yuyu.def.db.type.UserType_C_Tdk;
import yuyu.def.db.type.UserType_C_TrkKzkKbn;
import yuyu.def.db.type.UserType_C_TsindousiteiKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;
import yuyu.infr.validation.constraints.Tel;

/**
 * 登録家族テーブル テーブルのマッピング情報クラスで、 {@link IT_TrkKzk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_TrkKzk}</td><td colspan="3">登録家族テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_TrkKzk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_TrkKzk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzkkbn trkkzkkbn}</td><td>登録家族区分</td><td align="center">{@link PKIT_TrkKzk ○}</td><td align="center">V</td><td>{@link C_TrkKzkKbn}</td></tr>
 *  <tr><td>{@link #getTrkkzksetteiymd trkkzksetteiymd}</td><td>登録家族設定年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTrkkzknmkn trkkzknmkn}</td><td>登録家族名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzknmkj trkkzknmkj}</td><td>登録家族名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzknmkjkhukakbn trkkzknmkjkhukakbn}</td><td>登録家族名漢字化不可区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KjkhukaKbn}</td></tr>
 *  <tr><td>{@link #getTrkkzkseiymd trkkzkseiymd}</td><td>登録家族生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTrkkzksei trkkzksei}</td><td>登録家族性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Seibetu}</td></tr>
 *  <tr><td>{@link #getTrkkzktdk trkkzktdk}</td><td>登録家族続柄</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tdk}</td></tr>
 *  <tr><td>{@link #getTrkkzkyno trkkzkyno}</td><td>登録家族郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzkadr1kj trkkzkadr1kj}</td><td>登録家族住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzkadr2kj trkkzkadr2kj}</td><td>登録家族住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzkadr3kj trkkzkadr3kj}</td><td>登録家族住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzktelno trkkzktelno}</td><td>登録家族電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzktsindousiteikbn trkkzktsindousiteikbn}</td><td>登録家族通信先同一指定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TsindousiteiKbn}</td></tr>
 * </table>
 * @see     IT_TrkKzk
 * @see     PKIT_TrkKzk
 * @see     QIT_TrkKzk
 * @see     GenQIT_TrkKzk
 */
@MappedSuperclass
@Table(name=GenIT_TrkKzk.TABLE_NAME)
@IdClass(value=PKIT_TrkKzk.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_KjkhukaKbn", typeClass=UserType_C_KjkhukaKbn.class),
    @TypeDef(name="UserType_C_Seibetu", typeClass=UserType_C_Seibetu.class),
    @TypeDef(name="UserType_C_Tdk", typeClass=UserType_C_Tdk.class),
    @TypeDef(name="UserType_C_TrkKzkKbn", typeClass=UserType_C_TrkKzkKbn.class),
    @TypeDef(name="UserType_C_TsindousiteiKbn", typeClass=UserType_C_TsindousiteiKbn.class)
})
public abstract class GenIT_TrkKzk extends AbstractExDBEntity<IT_TrkKzk, PKIT_TrkKzk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_TrkKzk";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TRKKZKKBN                = "trkkzkkbn";
    public static final String TRKKZKSETTEIYMD          = "trkkzksetteiymd";
    public static final String TRKKZKNMKN               = "trkkzknmkn";
    public static final String TRKKZKNMKJ               = "trkkzknmkj";
    public static final String TRKKZKNMKJKHUKAKBN       = "trkkzknmkjkhukakbn";
    public static final String TRKKZKSEIYMD             = "trkkzkseiymd";
    public static final String TRKKZKSEI                = "trkkzksei";
    public static final String TRKKZKTDK                = "trkkzktdk";
    public static final String TRKKZKYNO                = "trkkzkyno";
    public static final String TRKKZKADR1KJ             = "trkkzkadr1kj";
    public static final String TRKKZKADR2KJ             = "trkkzkadr2kj";
    public static final String TRKKZKADR3KJ             = "trkkzkadr3kj";
    public static final String TRKKZKTELNO              = "trkkzktelno";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String TRKKZKTSINDOUSITEIKBN    = "trkkzktsindousiteikbn";

    private final PKIT_TrkKzk primaryKey;

    public GenIT_TrkKzk() {
        primaryKey = new PKIT_TrkKzk();
    }

    public GenIT_TrkKzk(
        String pKbnkey,
        String pSyono,
        C_TrkKzkKbn pTrkkzkkbn
    ) {
        primaryKey = new PKIT_TrkKzk(
            pKbnkey,
            pSyono,
            pTrkkzkkbn
        );
    }

    @Transient
    @Override
    public PKIT_TrkKzk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_TrkKzk> getMetaClass() {
        return QIT_TrkKzk.class;
    }

    @Id
    @Column(name=GenIT_TrkKzk.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_TrkKzk.SYONO)
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
    @Type(type="UserType_C_TrkKzkKbn")
    @Column(name=GenIT_TrkKzk.TRKKZKKBN)
    public C_TrkKzkKbn getTrkkzkkbn() {
        return getPrimaryKey().getTrkkzkkbn();
    }

    public void setTrkkzkkbn(C_TrkKzkKbn pTrkkzkkbn) {
        getPrimaryKey().setTrkkzkkbn(pTrkkzkkbn);
    }

    private BizDate trkkzksetteiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_TrkKzk.TRKKZKSETTEIYMD)
    @ValidDate
    public BizDate getTrkkzksetteiymd() {
        return trkkzksetteiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTrkkzksetteiymd(BizDate pTrkkzksetteiymd) {
        trkkzksetteiymd = pTrkkzksetteiymd;
    }

    private String trkkzknmkn;

    @Column(name=GenIT_TrkKzk.TRKKZKNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getTrkkzknmkn() {
        return trkkzknmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTrkkzknmkn(String pTrkkzknmkn) {
        trkkzknmkn = pTrkkzknmkn;
    }

    private String trkkzknmkj;

    @Column(name=GenIT_TrkKzk.TRKKZKNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getTrkkzknmkj() {
        return trkkzknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTrkkzknmkj(String pTrkkzknmkj) {
        trkkzknmkj = pTrkkzknmkj;
    }

    private C_KjkhukaKbn trkkzknmkjkhukakbn;

    @Type(type="UserType_C_KjkhukaKbn")
    @Column(name=GenIT_TrkKzk.TRKKZKNMKJKHUKAKBN)
    public C_KjkhukaKbn getTrkkzknmkjkhukakbn() {
        return trkkzknmkjkhukakbn;
    }

    public void setTrkkzknmkjkhukakbn(C_KjkhukaKbn pTrkkzknmkjkhukakbn) {
        trkkzknmkjkhukakbn = pTrkkzknmkjkhukakbn;
    }

    private BizDate trkkzkseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_TrkKzk.TRKKZKSEIYMD)
    @ValidDate
    public BizDate getTrkkzkseiymd() {
        return trkkzkseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTrkkzkseiymd(BizDate pTrkkzkseiymd) {
        trkkzkseiymd = pTrkkzkseiymd;
    }

    private C_Seibetu trkkzksei;

    @Type(type="UserType_C_Seibetu")
    @Column(name=GenIT_TrkKzk.TRKKZKSEI)
    public C_Seibetu getTrkkzksei() {
        return trkkzksei;
    }

    public void setTrkkzksei(C_Seibetu pTrkkzksei) {
        trkkzksei = pTrkkzksei;
    }

    private C_Tdk trkkzktdk;

    @Type(type="UserType_C_Tdk")
    @Column(name=GenIT_TrkKzk.TRKKZKTDK)
    public C_Tdk getTrkkzktdk() {
        return trkkzktdk;
    }

    public void setTrkkzktdk(C_Tdk pTrkkzktdk) {
        trkkzktdk = pTrkkzktdk;
    }

    private String trkkzkyno;

    @Column(name=GenIT_TrkKzk.TRKKZKYNO)
    @Length(length=7)
    @SingleByteStrings
    @Digit
    public String getTrkkzkyno() {
        return trkkzkyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTrkkzkyno(String pTrkkzkyno) {
        trkkzkyno = pTrkkzkyno;
    }

    private String trkkzkadr1kj;

    @Column(name=GenIT_TrkKzk.TRKKZKADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTrkkzkadr1kj() {
        return trkkzkadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTrkkzkadr1kj(String pTrkkzkadr1kj) {
        trkkzkadr1kj = pTrkkzkadr1kj;
    }

    private String trkkzkadr2kj;

    @Column(name=GenIT_TrkKzk.TRKKZKADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTrkkzkadr2kj() {
        return trkkzkadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTrkkzkadr2kj(String pTrkkzkadr2kj) {
        trkkzkadr2kj = pTrkkzkadr2kj;
    }

    private String trkkzkadr3kj;

    @Column(name=GenIT_TrkKzk.TRKKZKADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTrkkzkadr3kj() {
        return trkkzkadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTrkkzkadr3kj(String pTrkkzkadr3kj) {
        trkkzkadr3kj = pTrkkzkadr3kj;
    }

    private String trkkzktelno;

    @Column(name=GenIT_TrkKzk.TRKKZKTELNO)
    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    public String getTrkkzktelno() {
        return trkkzktelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTrkkzktelno(String pTrkkzktelno) {
        trkkzktelno = pTrkkzktelno;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_TrkKzk.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_TrkKzk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_TrkKzk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private C_TsindousiteiKbn trkkzktsindousiteikbn;

    @Type(type="UserType_C_TsindousiteiKbn")
    @Column(name=GenIT_TrkKzk.TRKKZKTSINDOUSITEIKBN)
    public C_TsindousiteiKbn getTrkkzktsindousiteikbn() {
        return trkkzktsindousiteikbn;
    }

    public void setTrkkzktsindousiteikbn(C_TsindousiteiKbn pTrkkzktsindousiteikbn) {
        trkkzktsindousiteikbn = pTrkkzktsindousiteikbn;
    }
}