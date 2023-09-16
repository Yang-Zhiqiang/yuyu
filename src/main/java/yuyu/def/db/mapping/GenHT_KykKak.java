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
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KykkakkekKbn;
import yuyu.def.classification.C_Kykkaksyrui;
import yuyu.def.db.entity.HT_KykKak;
import yuyu.def.db.id.PKHT_KykKak;
import yuyu.def.db.meta.GenQHT_KykKak;
import yuyu.def.db.meta.QHT_KykKak;
import yuyu.def.db.type.UserType_C_KykkakkekKbn;
import yuyu.def.db.type.UserType_C_Kykkaksyrui;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 契約確認テーブル テーブルのマッピング情報クラスで、 {@link HT_KykKak} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_KykKak}</td><td colspan="3">契約確認テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_KykKak ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKHT_KykKak ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKykkaksyrui kykkaksyrui}</td><td>契約確認種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kykkaksyrui}</td></tr>
 *  <tr><td>{@link #getKykkaktantcd kykkaktantcd}</td><td>契約確認担当者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykkakkaisyacd kykkakkaisyacd}</td><td>契約確認会社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykkakiraiymd kykkakiraiymd}</td><td>契約確認依頼日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykkakkanytymd kykkakkanytymd}</td><td>契約確認完了予定日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykkakkekkbn kykkakkekkbn}</td><td>契約確認結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KykkakkekKbn}</td></tr>
 *  <tr><td>{@link #getKykkakkanymd kykkakkanymd}</td><td>契約確認完了日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykkakcomment kykkakcomment}</td><td>契約確認コメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_KykKak
 * @see     PKHT_KykKak
 * @see     QHT_KykKak
 * @see     GenQHT_KykKak
 */
@MappedSuperclass
@Table(name=GenHT_KykKak.TABLE_NAME)
@IdClass(value=PKHT_KykKak.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_KykkakkekKbn", typeClass=UserType_C_KykkakkekKbn.class),
    @TypeDef(name="UserType_C_Kykkaksyrui", typeClass=UserType_C_Kykkaksyrui.class)
})
public abstract class GenHT_KykKak extends AbstractExDBEntity<HT_KykKak, PKHT_KykKak> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_KykKak";
    public static final String MOSNO                    = "mosno";
    public static final String RENNO                    = "renno";
    public static final String KYKKAKSYRUI              = "kykkaksyrui";
    public static final String KYKKAKTANTCD             = "kykkaktantcd";
    public static final String KYKKAKKAISYACD           = "kykkakkaisyacd";
    public static final String KYKKAKIRAIYMD            = "kykkakiraiymd";
    public static final String KYKKAKKANYTYMD           = "kykkakkanytymd";
    public static final String KYKKAKKEKKBN             = "kykkakkekkbn";
    public static final String KYKKAKKANYMD             = "kykkakkanymd";
    public static final String KYKKAKCOMMENT            = "kykkakcomment";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_KykKak primaryKey;

    public GenHT_KykKak() {
        primaryKey = new PKHT_KykKak();
    }

    public GenHT_KykKak(String pMosno, Integer pRenno) {
        primaryKey = new PKHT_KykKak(pMosno, pRenno);
    }

    @Transient
    @Override
    public PKHT_KykKak getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_KykKak> getMetaClass() {
        return QHT_KykKak.class;
    }

    @Id
    @Column(name=GenHT_KykKak.MOSNO)
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
    @Column(name=GenHT_KykKak.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private C_Kykkaksyrui kykkaksyrui;

    @Type(type="UserType_C_Kykkaksyrui")
    @Column(name=GenHT_KykKak.KYKKAKSYRUI)
    public C_Kykkaksyrui getKykkaksyrui() {
        return kykkaksyrui;
    }

    public void setKykkaksyrui(C_Kykkaksyrui pKykkaksyrui) {
        kykkaksyrui = pKykkaksyrui;
    }

    private String kykkaktantcd;

    @Column(name=GenHT_KykKak.KYKKAKTANTCD)
    @MaxLength(max=12)
    @AlphaDigit
    public String getKykkaktantcd() {
        return kykkaktantcd;
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setKykkaktantcd(String pKykkaktantcd) {
        kykkaktantcd = pKykkaktantcd;
    }

    private String kykkakkaisyacd;

    @Column(name=GenHT_KykKak.KYKKAKKAISYACD)
    @MaxLength(max=12)
    @AlphaDigit
    public String getKykkakkaisyacd() {
        return kykkakkaisyacd;
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setKykkakkaisyacd(String pKykkakkaisyacd) {
        kykkakkaisyacd = pKykkakkaisyacd;
    }

    private BizDate kykkakiraiymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_KykKak.KYKKAKIRAIYMD)
    @ValidDate
    public BizDate getKykkakiraiymd() {
        return kykkakiraiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykkakiraiymd(BizDate pKykkakiraiymd) {
        kykkakiraiymd = pKykkakiraiymd;
    }

    private BizDate kykkakkanytymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_KykKak.KYKKAKKANYTYMD)
    @ValidDate
    public BizDate getKykkakkanytymd() {
        return kykkakkanytymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykkakkanytymd(BizDate pKykkakkanytymd) {
        kykkakkanytymd = pKykkakkanytymd;
    }

    private C_KykkakkekKbn kykkakkekkbn;

    @Type(type="UserType_C_KykkakkekKbn")
    @Column(name=GenHT_KykKak.KYKKAKKEKKBN)
    public C_KykkakkekKbn getKykkakkekkbn() {
        return kykkakkekkbn;
    }

    public void setKykkakkekkbn(C_KykkakkekKbn pKykkakkekkbn) {
        kykkakkekkbn = pKykkakkekkbn;
    }

    private BizDate kykkakkanymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_KykKak.KYKKAKKANYMD)
    @ValidDate
    public BizDate getKykkakkanymd() {
        return kykkakkanymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykkakkanymd(BizDate pKykkakkanymd) {
        kykkakkanymd = pKykkakkanymd;
    }

    private String kykkakcomment;

    @Column(name=GenHT_KykKak.KYKKAKCOMMENT)
    @ValidTextArea(length=50, rows=3)
    @MultiByteStringsReturnable
    @InvalidCharacter
    public String getKykkakcomment() {
        return kykkakcomment;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKykkakcomment(String pKykkakcomment) {
        kykkakcomment = pKykkakcomment;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_KykKak.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_KykKak.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}