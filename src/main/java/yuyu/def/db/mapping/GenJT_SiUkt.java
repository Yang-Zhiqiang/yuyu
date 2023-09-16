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
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Hkuktsyu;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.db.entity.JT_SiUkt;
import yuyu.def.db.id.PKJT_SiUkt;
import yuyu.def.db.meta.GenQJT_SiUkt;
import yuyu.def.db.meta.QJT_SiUkt;
import yuyu.def.db.type.UserType_C_Hkuktsyu;
import yuyu.def.db.type.UserType_C_Tdk;
import yuyu.def.db.type.UserType_C_UktKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 支払受取人テーブル テーブルのマッピング情報クラスで、 {@link JT_SiUkt} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SiUkt}</td><td colspan="3">支払受取人テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_SiUkt ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHkuktsyu hkuktsyu}</td><td>給付金受取人種類区分</td><td align="center">{@link PKJT_SiUkt ○}</td><td align="center">V</td><td>{@link C_Hkuktsyu}</td></tr>
 *  <tr><td>{@link #getUktsyurenno uktsyurenno}</td><td>受取人種類別連番</td><td align="center">{@link PKJT_SiUkt ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getUktnmkn uktnmkn}</td><td>受取人名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUktnmkj uktnmkj}</td><td>受取人名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUktseiymd uktseiymd}</td><td>受取人生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getUkttdk ukttdk}</td><td>受取人続柄</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tdk}</td></tr>
 *  <tr><td>{@link #getUktkbn uktkbn}</td><td>受取人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UktKbn}</td></tr>
 *  <tr><td>{@link #getUktbnwari uktbnwari}</td><td>受取人分割割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKossyoricd kossyoricd}</td><td>更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyorisscd kossyorisscd}</td><td>更新処理詳細コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SiUkt
 * @see     PKJT_SiUkt
 * @see     QJT_SiUkt
 * @see     GenQJT_SiUkt
 */
@MappedSuperclass
@Table(name=GenJT_SiUkt.TABLE_NAME)
@IdClass(value=PKJT_SiUkt.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_Hkuktsyu", typeClass=UserType_C_Hkuktsyu.class),
    @TypeDef(name="UserType_C_Tdk", typeClass=UserType_C_Tdk.class),
    @TypeDef(name="UserType_C_UktKbn", typeClass=UserType_C_UktKbn.class)
})
public abstract class GenJT_SiUkt extends AbstractExDBEntity<JT_SiUkt, PKJT_SiUkt> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_SiUkt";
    public static final String SYONO                    = "syono";
    public static final String HKUKTSYU                 = "hkuktsyu";
    public static final String UKTSYURENNO              = "uktsyurenno";
    public static final String UKTNMKN                  = "uktnmkn";
    public static final String UKTNMKJ                  = "uktnmkj";
    public static final String UKTSEIYMD                = "uktseiymd";
    public static final String UKTTDK                   = "ukttdk";
    public static final String UKTKBN                   = "uktkbn";
    public static final String UKTBNWARI                = "uktbnwari";
    public static final String KOSSYORICD               = "kossyoricd";
    public static final String KOSSYORISSCD             = "kossyorisscd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_SiUkt primaryKey;

    public GenJT_SiUkt() {
        primaryKey = new PKJT_SiUkt();
    }

    public GenJT_SiUkt(
        String pSyono,
        C_Hkuktsyu pHkuktsyu,
        Integer pUktsyurenno
    ) {
        primaryKey = new PKJT_SiUkt(
            pSyono,
            pHkuktsyu,
            pUktsyurenno
        );
    }

    @Transient
    @Override
    public PKJT_SiUkt getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_SiUkt> getMetaClass() {
        return QJT_SiUkt.class;
    }

    @Id
    @Column(name=GenJT_SiUkt.SYONO)
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
    @Type(type="UserType_C_Hkuktsyu")
    @Column(name=GenJT_SiUkt.HKUKTSYU)
    public C_Hkuktsyu getHkuktsyu() {
        return getPrimaryKey().getHkuktsyu();
    }

    public void setHkuktsyu(C_Hkuktsyu pHkuktsyu) {
        getPrimaryKey().setHkuktsyu(pHkuktsyu);
    }

    @Id
    @Column(name=GenJT_SiUkt.UKTSYURENNO)
    public Integer getUktsyurenno() {
        return getPrimaryKey().getUktsyurenno();
    }

    public void setUktsyurenno(Integer pUktsyurenno) {
        getPrimaryKey().setUktsyurenno(pUktsyurenno);
    }

    private String uktnmkn;

    @Column(name=GenJT_SiUkt.UKTNMKN)
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

    @Column(name=GenJT_SiUkt.UKTNMKJ)
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

    private BizDate uktseiymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiUkt.UKTSEIYMD)
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
    @Column(name=GenJT_SiUkt.UKTTDK)
    public C_Tdk getUkttdk() {
        return ukttdk;
    }

    public void setUkttdk(C_Tdk pUkttdk) {
        ukttdk = pUkttdk;
    }

    private C_UktKbn uktkbn;

    @Type(type="UserType_C_UktKbn")
    @Column(name=GenJT_SiUkt.UKTKBN)
    public C_UktKbn getUktkbn() {
        return uktkbn;
    }

    public void setUktkbn(C_UktKbn pUktkbn) {
        uktkbn = pUktkbn;
    }

    private BizNumber uktbnwari;

    @Type(type="BizNumberType")
    @Column(name=GenJT_SiUkt.UKTBNWARI)
    public BizNumber getUktbnwari() {
        return uktbnwari;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktbnwari(BizNumber pUktbnwari) {
        uktbnwari = pUktbnwari;
    }

    private String kossyoricd;

    @Column(name=GenJT_SiUkt.KOSSYORICD)
    public String getKossyoricd() {
        return kossyoricd;
    }

    public void setKossyoricd(String pKossyoricd) {
        kossyoricd = pKossyoricd;
    }

    private String kossyorisscd;

    @Column(name=GenJT_SiUkt.KOSSYORISSCD)
    public String getKossyorisscd() {
        return kossyorisscd;
    }

    public void setKossyorisscd(String pKossyorisscd) {
        kossyorisscd = pKossyorisscd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_SiUkt.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_SiUkt.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}