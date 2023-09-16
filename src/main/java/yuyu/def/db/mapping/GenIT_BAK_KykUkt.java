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
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
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
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.entity.IT_BAK_KykUkt;
import yuyu.def.db.id.PKIT_BAK_KykUkt;
import yuyu.def.db.meta.GenQIT_BAK_KykUkt;
import yuyu.def.db.meta.QIT_BAK_KykUkt;
import yuyu.def.db.type.UserType_C_KjkhukaKbn;
import yuyu.def.db.type.UserType_C_Tdk;
import yuyu.def.db.type.UserType_C_UktKbn;
import yuyu.def.db.type.UserType_C_UktsyuKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約受取人バックアップテーブル テーブルのマッピング情報クラスで、 {@link IT_BAK_KykUkt} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_KykUkt}</td><td colspan="3">契約受取人バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_BAK_KykUkt ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_BAK_KykUkt ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKIT_BAK_KykUkt ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUktsyukbn uktsyukbn}</td><td>受取人種類区分</td><td align="center">{@link PKIT_BAK_KykUkt ○}</td><td align="center">V</td><td>{@link C_UktsyuKbn}</td></tr>
 *  <tr><td>{@link #getUktsyurenno uktsyurenno}</td><td>受取人種類別連番</td><td align="center">{@link PKIT_BAK_KykUkt ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKokno kokno}</td><td>顧客番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUktkbn uktkbn}</td><td>受取人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UktKbn}</td></tr>
 *  <tr><td>{@link #getUktnmkn uktnmkn}</td><td>受取人名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUktnmkj uktnmkj}</td><td>受取人名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUktnmkjkhukakbn uktnmkjkhukakbn}</td><td>受取人名漢字化不可区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KjkhukaKbn}</td></tr>
 *  <tr><td>{@link #getUktseiymd uktseiymd}</td><td>受取人生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getUkttdk ukttdk}</td><td>受取人続柄</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tdk}</td></tr>
 *  <tr><td>{@link #getUktbnwari uktbnwari}</td><td>受取人分割割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUktyno uktyno}</td><td>受取人郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUktadr1kj uktadr1kj}</td><td>受取人住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUktadr2kj uktadr2kj}</td><td>受取人住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUktadr3kj uktadr3kj}</td><td>受取人住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_KykUkt
 * @see     PKIT_BAK_KykUkt
 * @see     QIT_BAK_KykUkt
 * @see     GenQIT_BAK_KykUkt
 */
@MappedSuperclass
@Table(name=GenIT_BAK_KykUkt.TABLE_NAME)
@IdClass(value=PKIT_BAK_KykUkt.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_KjkhukaKbn", typeClass=UserType_C_KjkhukaKbn.class),
    @TypeDef(name="UserType_C_Tdk", typeClass=UserType_C_Tdk.class),
    @TypeDef(name="UserType_C_UktKbn", typeClass=UserType_C_UktKbn.class),
    @TypeDef(name="UserType_C_UktsyuKbn", typeClass=UserType_C_UktsyuKbn.class)
})
public abstract class GenIT_BAK_KykUkt extends AbstractExDBEntity<IT_BAK_KykUkt, PKIT_BAK_KykUkt> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_BAK_KykUkt";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String UKTSYUKBN                = "uktsyukbn";
    public static final String UKTSYURENNO              = "uktsyurenno";
    public static final String KOKNO                    = "kokno";
    public static final String UKTKBN                   = "uktkbn";
    public static final String UKTNMKN                  = "uktnmkn";
    public static final String UKTNMKJ                  = "uktnmkj";
    public static final String UKTNMKJKHUKAKBN          = "uktnmkjkhukakbn";
    public static final String UKTSEIYMD                = "uktseiymd";
    public static final String UKTTDK                   = "ukttdk";
    public static final String UKTBNWARI                = "uktbnwari";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String UKTYNO                   = "uktyno";
    public static final String UKTADR1KJ                = "uktadr1kj";
    public static final String UKTADR2KJ                = "uktadr2kj";
    public static final String UKTADR3KJ                = "uktadr3kj";

    private final PKIT_BAK_KykUkt primaryKey;

    public GenIT_BAK_KykUkt() {
        primaryKey = new PKIT_BAK_KykUkt();
    }

    public GenIT_BAK_KykUkt(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        C_UktsyuKbn pUktsyukbn,
        Integer pUktsyurenno
    ) {
        primaryKey = new PKIT_BAK_KykUkt(
            pKbnkey,
            pSyono,
            pTrkssikibetukey,
            pUktsyukbn,
            pUktsyurenno
        );
    }

    @Transient
    @Override
    public PKIT_BAK_KykUkt getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_BAK_KykUkt> getMetaClass() {
        return QIT_BAK_KykUkt.class;
    }

    @Id
    @Column(name=GenIT_BAK_KykUkt.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_BAK_KykUkt.SYONO)
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
    @Column(name=GenIT_BAK_KykUkt.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    @Id
    @Type(type="UserType_C_UktsyuKbn")
    @Column(name=GenIT_BAK_KykUkt.UKTSYUKBN)
    public C_UktsyuKbn getUktsyukbn() {
        return getPrimaryKey().getUktsyukbn();
    }

    public void setUktsyukbn(C_UktsyuKbn pUktsyukbn) {
        getPrimaryKey().setUktsyukbn(pUktsyukbn);
    }

    @Id
    @Column(name=GenIT_BAK_KykUkt.UKTSYURENNO)
    public Integer getUktsyurenno() {
        return getPrimaryKey().getUktsyurenno();
    }

    public void setUktsyurenno(Integer pUktsyurenno) {
        getPrimaryKey().setUktsyurenno(pUktsyurenno);
    }

    private String kokno;

    @Column(name=GenIT_BAK_KykUkt.KOKNO)
    public String getKokno() {
        return kokno;
    }

    public void setKokno(String pKokno) {
        kokno = pKokno;
    }

    private C_UktKbn uktkbn;

    @Type(type="UserType_C_UktKbn")
    @Column(name=GenIT_BAK_KykUkt.UKTKBN)
    public C_UktKbn getUktkbn() {
        return uktkbn;
    }

    public void setUktkbn(C_UktKbn pUktkbn) {
        uktkbn = pUktkbn;
    }

    private String uktnmkn;

    @Column(name=GenIT_BAK_KykUkt.UKTNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getUktnmkn() {
        return uktnmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setUktnmkn(String pUktnmkn) {
        uktnmkn = pUktnmkn;
    }

    private String uktnmkj;

    @Column(name=GenIT_BAK_KykUkt.UKTNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getUktnmkj() {
        return uktnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setUktnmkj(String pUktnmkj) {
        uktnmkj = pUktnmkj;
    }

    private C_KjkhukaKbn uktnmkjkhukakbn;

    @Type(type="UserType_C_KjkhukaKbn")
    @Column(name=GenIT_BAK_KykUkt.UKTNMKJKHUKAKBN)
    public C_KjkhukaKbn getUktnmkjkhukakbn() {
        return uktnmkjkhukakbn;
    }

    public void setUktnmkjkhukakbn(C_KjkhukaKbn pUktnmkjkhukakbn) {
        uktnmkjkhukakbn = pUktnmkjkhukakbn;
    }

    private BizDate uktseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KykUkt.UKTSEIYMD)
    @ValidDate
    public BizDate getUktseiymd() {
        return uktseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktseiymd(BizDate pUktseiymd) {
        uktseiymd = pUktseiymd;
    }

    private C_Tdk ukttdk;

    @Type(type="UserType_C_Tdk")
    @Column(name=GenIT_BAK_KykUkt.UKTTDK)
    public C_Tdk getUkttdk() {
        return ukttdk;
    }

    public void setUkttdk(C_Tdk pUkttdk) {
        ukttdk = pUkttdk;
    }

    private BizNumber uktbnwari;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_KykUkt.UKTBNWARI)
    public BizNumber getUktbnwari() {
        return uktbnwari;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktbnwari(BizNumber pUktbnwari) {
        uktbnwari = pUktbnwari;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_BAK_KykUkt.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_BAK_KykUkt.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_BAK_KykUkt.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private String uktyno;

    @Column(name=GenIT_BAK_KykUkt.UKTYNO)
    @Length(length=7)
    @SingleByteStrings
    @Digit
    public String getUktyno() {
        return uktyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktyno(String pUktyno) {
        uktyno = pUktyno;
    }

    private String uktadr1kj;

    @Column(name=GenIT_BAK_KykUkt.UKTADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getUktadr1kj() {
        return uktadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setUktadr1kj(String pUktadr1kj) {
        uktadr1kj = pUktadr1kj;
    }

    private String uktadr2kj;

    @Column(name=GenIT_BAK_KykUkt.UKTADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getUktadr2kj() {
        return uktadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setUktadr2kj(String pUktadr2kj) {
        uktadr2kj = pUktadr2kj;
    }

    private String uktadr3kj;

    @Column(name=GenIT_BAK_KykUkt.UKTADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getUktadr3kj() {
        return uktadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setUktadr3kj(String pUktadr3kj) {
        uktadr3kj = pUktadr3kj;
    }
}