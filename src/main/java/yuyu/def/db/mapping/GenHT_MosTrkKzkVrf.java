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
import yuyu.def.db.entity.HT_MosTrkKzkVrf;
import yuyu.def.db.id.PKHT_MosTrkKzkVrf;
import yuyu.def.db.meta.GenQHT_MosTrkKzkVrf;
import yuyu.def.db.meta.QHT_MosTrkKzkVrf;
import yuyu.def.db.type.UserType_C_KjkhukaKbn;
import yuyu.def.db.type.UserType_C_Seibetu;
import yuyu.def.db.type.UserType_C_Tdk;
import yuyu.def.db.type.UserType_C_TrkKzkKbn;
import yuyu.def.db.type.UserType_C_TsindousiteiKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;
import yuyu.infr.validation.constraints.Tel;

/**
 * 申込登録家族ベリファイテーブル テーブルのマッピング情報クラスで、 {@link HT_MosTrkKzkVrf} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_MosTrkKzkVrf}</td><td colspan="3">申込登録家族ベリファイテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_MosTrkKzkVrf ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzkkbn trkkzkkbn}</td><td>登録家族区分</td><td align="center">{@link PKHT_MosTrkKzkVrf ○}</td><td align="center">V</td><td>{@link C_TrkKzkKbn}</td></tr>
 *  <tr><td>{@link #getTrkkzknmkn trkkzknmkn}</td><td>登録家族名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzknmkj trkkzknmkj}</td><td>登録家族名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzknmkjkhukakbn trkkzknmkjkhukakbn}</td><td>登録家族名漢字化不可区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KjkhukaKbn}</td></tr>
 *  <tr><td>{@link #getTrkkzkseiymd trkkzkseiymd}</td><td>登録家族生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTrkkzksei trkkzksei}</td><td>登録家族性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Seibetu}</td></tr>
 *  <tr><td>{@link #getTrkkzktdk trkkzktdk}</td><td>登録家族続柄</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tdk}</td></tr>
 *  <tr><td>{@link #getTrkkzktsindousiteikbn trkkzktsindousiteikbn}</td><td>登録家族通信先同一指定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TsindousiteiKbn}</td></tr>
 *  <tr><td>{@link #getTrkkzkyno trkkzkyno}</td><td>登録家族郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzkadr1kj trkkzkadr1kj}</td><td>登録家族住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzkadr2kj trkkzkadr2kj}</td><td>登録家族住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzkadr3kj trkkzkadr3kj}</td><td>登録家族住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzktelno trkkzktelno}</td><td>登録家族電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_MosTrkKzkVrf
 * @see     PKHT_MosTrkKzkVrf
 * @see     QHT_MosTrkKzkVrf
 * @see     GenQHT_MosTrkKzkVrf
 */
@MappedSuperclass
@Table(name=GenHT_MosTrkKzkVrf.TABLE_NAME)
@IdClass(value=PKHT_MosTrkKzkVrf.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_KjkhukaKbn", typeClass=UserType_C_KjkhukaKbn.class),
    @TypeDef(name="UserType_C_Seibetu", typeClass=UserType_C_Seibetu.class),
    @TypeDef(name="UserType_C_Tdk", typeClass=UserType_C_Tdk.class),
    @TypeDef(name="UserType_C_TrkKzkKbn", typeClass=UserType_C_TrkKzkKbn.class),
    @TypeDef(name="UserType_C_TsindousiteiKbn", typeClass=UserType_C_TsindousiteiKbn.class)
})
public abstract class GenHT_MosTrkKzkVrf extends AbstractExDBEntity<HT_MosTrkKzkVrf, PKHT_MosTrkKzkVrf> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_MosTrkKzkVrf";
    public static final String MOSNO                    = "mosno";
    public static final String TRKKZKKBN                = "trkkzkkbn";
    public static final String TRKKZKNMKN               = "trkkzknmkn";
    public static final String TRKKZKNMKJ               = "trkkzknmkj";
    public static final String TRKKZKNMKJKHUKAKBN       = "trkkzknmkjkhukakbn";
    public static final String TRKKZKSEIYMD             = "trkkzkseiymd";
    public static final String TRKKZKSEI                = "trkkzksei";
    public static final String TRKKZKTDK                = "trkkzktdk";
    public static final String TRKKZKTSINDOUSITEIKBN    = "trkkzktsindousiteikbn";
    public static final String TRKKZKYNO                = "trkkzkyno";
    public static final String TRKKZKADR1KJ             = "trkkzkadr1kj";
    public static final String TRKKZKADR2KJ             = "trkkzkadr2kj";
    public static final String TRKKZKADR3KJ             = "trkkzkadr3kj";
    public static final String TRKKZKTELNO              = "trkkzktelno";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_MosTrkKzkVrf primaryKey;

    public GenHT_MosTrkKzkVrf() {
        primaryKey = new PKHT_MosTrkKzkVrf();
    }

    public GenHT_MosTrkKzkVrf(String pMosno, C_TrkKzkKbn pTrkkzkkbn) {
        primaryKey = new PKHT_MosTrkKzkVrf(pMosno, pTrkkzkkbn);
    }

    @Transient
    @Override
    public PKHT_MosTrkKzkVrf getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_MosTrkKzkVrf> getMetaClass() {
        return QHT_MosTrkKzkVrf.class;
    }

    @Id
    @Column(name=GenHT_MosTrkKzkVrf.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return getPrimaryKey().getMosno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        getPrimaryKey().setMosno(pMosno);
    }

    @Id
    @Type(type="UserType_C_TrkKzkKbn")
    @Column(name=GenHT_MosTrkKzkVrf.TRKKZKKBN)
    public C_TrkKzkKbn getTrkkzkkbn() {
        return getPrimaryKey().getTrkkzkkbn();
    }

    public void setTrkkzkkbn(C_TrkKzkKbn pTrkkzkkbn) {
        getPrimaryKey().setTrkkzkkbn(pTrkkzkkbn);
    }

    private String trkkzknmkn;

    @Column(name=GenHT_MosTrkKzkVrf.TRKKZKNMKN)
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

    @Column(name=GenHT_MosTrkKzkVrf.TRKKZKNMKJ)
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
    @Column(name=GenHT_MosTrkKzkVrf.TRKKZKNMKJKHUKAKBN)
    public C_KjkhukaKbn getTrkkzknmkjkhukakbn() {
        return trkkzknmkjkhukakbn;
    }

    public void setTrkkzknmkjkhukakbn(C_KjkhukaKbn pTrkkzknmkjkhukakbn) {
        trkkzknmkjkhukakbn = pTrkkzknmkjkhukakbn;
    }

    private BizDate trkkzkseiymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_MosTrkKzkVrf.TRKKZKSEIYMD)
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
    @Column(name=GenHT_MosTrkKzkVrf.TRKKZKSEI)
    public C_Seibetu getTrkkzksei() {
        return trkkzksei;
    }

    public void setTrkkzksei(C_Seibetu pTrkkzksei) {
        trkkzksei = pTrkkzksei;
    }

    private C_Tdk trkkzktdk;

    @Type(type="UserType_C_Tdk")
    @Column(name=GenHT_MosTrkKzkVrf.TRKKZKTDK)
    public C_Tdk getTrkkzktdk() {
        return trkkzktdk;
    }

    public void setTrkkzktdk(C_Tdk pTrkkzktdk) {
        trkkzktdk = pTrkkzktdk;
    }

    private C_TsindousiteiKbn trkkzktsindousiteikbn;

    @Type(type="UserType_C_TsindousiteiKbn")
    @Column(name=GenHT_MosTrkKzkVrf.TRKKZKTSINDOUSITEIKBN)
    public C_TsindousiteiKbn getTrkkzktsindousiteikbn() {
        return trkkzktsindousiteikbn;
    }

    public void setTrkkzktsindousiteikbn(C_TsindousiteiKbn pTrkkzktsindousiteikbn) {
        trkkzktsindousiteikbn = pTrkkzktsindousiteikbn;
    }

    private String trkkzkyno;

    @Column(name=GenHT_MosTrkKzkVrf.TRKKZKYNO)
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

    @Column(name=GenHT_MosTrkKzkVrf.TRKKZKADR1KJ)
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

    @Column(name=GenHT_MosTrkKzkVrf.TRKKZKADR2KJ)
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

    @Column(name=GenHT_MosTrkKzkVrf.TRKKZKADR3KJ)
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

    @Column(name=GenHT_MosTrkKzkVrf.TRKKZKTELNO)
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

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_MosTrkKzkVrf.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_MosTrkKzkVrf.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}