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
import jp.co.slcs.swak.db.hibernate.usertype.BooleanType;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.DT_WfSentakujyotaiHozon;
import yuyu.def.db.id.PKDT_WfSentakujyotaiHozon;
import yuyu.def.db.meta.GenQDT_WfSentakujyotaiHozon;
import yuyu.def.db.meta.QDT_WfSentakujyotaiHozon;
import yuyu.infr.validation.constraints.MousikomiNo;
import yuyu.infr.validation.constraints.NenkinSyousyoNo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ワークフロー選択状態保存テーブル テーブルのマッピング情報クラスで、 {@link DT_WfSentakujyotaiHozon} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link DT_WfSentakujyotaiHozon}</td><td colspan="3">ワークフロー選択状態保存テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getUserId userId}</td><td>ユーザーＩＤ</td><td align="center">{@link PKDT_WfSentakujyotaiHozon ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSubSystemId subSystemId}</td><td>サブシステムＩＤ</td><td align="center">{@link PKDT_WfSentakujyotaiHozon ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJimutetuzukicd jimutetuzukicd}</td><td>事務手続コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkeiJimuKbnHzn skeiJimuKbnHzn}</td><td>新契約事務区分＿保存用</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMosUketukeKbnHzn mosUketukeKbnHzn}</td><td>申込受付区分＿保存用</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruinohozon hokensyuruinohozon}</td><td>保険種類番号＿保存用</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDairitencd1 dairitencd1}</td><td>代理店コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDairitencd2 dairitencd2}</td><td>代理店コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtencd3 drtencd3}</td><td>代理店コード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtencd4 drtencd4}</td><td>代理店コード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtencd5 drtencd5}</td><td>代理店コード５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKoDairitenTaisyouKbn koDairitenTaisyouKbn}</td><td>子代理店対象区分</td><td align="center">&nbsp;</td><td align="center">B</td><td>Boolean</td></tr>
 *  <tr><td>{@link #getJimuyoucd jimuyoucd}</td><td>事務用コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJmycdMisetteiKbn jmycdMisetteiKbn}</td><td>事務用コード未設定区分</td><td align="center">&nbsp;</td><td align="center">B</td><td>Boolean</td></tr>
 *  <tr><td>{@link #getDjmskmKeiyakuKbn djmskmKeiyakuKbn}</td><td>同時申込契約区分</td><td align="center">&nbsp;</td><td align="center">B</td><td>Boolean</td></tr>
 *  <tr><td>{@link #getMosYmdFrom mosYmdFrom}</td><td>申込年月日（自）</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMosYmdTo mosYmdTo}</td><td>申込年月日（至）</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getJimustartYmdFrom jimustartYmdFrom}</td><td>事務開始年月日（自）</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getJimustartYmdTo jimustartYmdTo}</td><td>事務開始年月日（至）</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNksysyno nksysyno}</td><td>年金証書番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     DT_WfSentakujyotaiHozon
 * @see     PKDT_WfSentakujyotaiHozon
 * @see     QDT_WfSentakujyotaiHozon
 * @see     GenQDT_WfSentakujyotaiHozon
 */
@MappedSuperclass
@Table(name=GenDT_WfSentakujyotaiHozon.TABLE_NAME)
@IdClass(value=PKDT_WfSentakujyotaiHozon.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BooleanType", typeClass=BooleanType.class)
})
public abstract class GenDT_WfSentakujyotaiHozon extends AbstractExDBEntity<DT_WfSentakujyotaiHozon, PKDT_WfSentakujyotaiHozon> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "DT_WfSentakujyotaiHozon";
    public static final String USERID                   = "userId";
    public static final String SUBSYSTEMID              = "subSystemId";
    public static final String JIMUTETUZUKICD           = "jimutetuzukicd";
    public static final String SKEIJIMUKBNHZN           = "skeiJimuKbnHzn";
    public static final String MOSUKETUKEKBNHZN         = "mosUketukeKbnHzn";
    public static final String HOKENSYURUINOHOZON       = "hokensyuruinohozon";
    public static final String DAIRITENCD1              = "dairitencd1";
    public static final String DAIRITENCD2              = "dairitencd2";
    public static final String DRTENCD3                 = "drtencd3";
    public static final String DRTENCD4                 = "drtencd4";
    public static final String DRTENCD5                 = "drtencd5";
    public static final String KODAIRITENTAISYOUKBN     = "koDairitenTaisyouKbn";
    public static final String JIMUYOUCD                = "jimuyoucd";
    public static final String JMYCDMISETTEIKBN         = "jmycdMisetteiKbn";
    public static final String DJMSKMKEIYAKUKBN         = "djmskmKeiyakuKbn";
    public static final String MOSYMDFROM               = "mosYmdFrom";
    public static final String MOSYMDTO                 = "mosYmdTo";
    public static final String JIMUSTARTYMDFROM         = "jimustartYmdFrom";
    public static final String JIMUSTARTYMDTO           = "jimustartYmdTo";
    public static final String MOSNO                    = "mosno";
    public static final String SYONO                    = "syono";
    public static final String NKSYSYNO                 = "nksysyno";

    private final PKDT_WfSentakujyotaiHozon primaryKey;

    public GenDT_WfSentakujyotaiHozon() {
        primaryKey = new PKDT_WfSentakujyotaiHozon();
    }

    public GenDT_WfSentakujyotaiHozon(String pUserId, String pSubSystemId) {
        primaryKey = new PKDT_WfSentakujyotaiHozon(pUserId, pSubSystemId);
    }

    @Transient
    @Override
    public PKDT_WfSentakujyotaiHozon getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QDT_WfSentakujyotaiHozon> getMetaClass() {
        return QDT_WfSentakujyotaiHozon.class;
    }

    @Id
    @Column(name=GenDT_WfSentakujyotaiHozon.USERID)
    @MaxLength(max=30)
    @AlphaDigit
    public String getUserId() {
        return getPrimaryKey().getUserId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUserId(String pUserId) {
        getPrimaryKey().setUserId(pUserId);
    }

    @Id
    @Column(name=GenDT_WfSentakujyotaiHozon.SUBSYSTEMID)
    public String getSubSystemId() {
        return getPrimaryKey().getSubSystemId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSubSystemId(String pSubSystemId) {
        getPrimaryKey().setSubSystemId(pSubSystemId);
    }

    private String jimutetuzukicd;

    @Column(name=GenDT_WfSentakujyotaiHozon.JIMUTETUZUKICD)
    public String getJimutetuzukicd() {
        return jimutetuzukicd;
    }

    public void setJimutetuzukicd(String pJimutetuzukicd) {
        jimutetuzukicd = pJimutetuzukicd;
    }

    private String skeiJimuKbnHzn;

    @Column(name=GenDT_WfSentakujyotaiHozon.SKEIJIMUKBNHZN)
    public String getSkeiJimuKbnHzn() {
        return skeiJimuKbnHzn;
    }

    public void setSkeiJimuKbnHzn(String pSkeiJimuKbnHzn) {
        skeiJimuKbnHzn = pSkeiJimuKbnHzn;
    }

    private String mosUketukeKbnHzn;

    @Column(name=GenDT_WfSentakujyotaiHozon.MOSUKETUKEKBNHZN)
    public String getMosUketukeKbnHzn() {
        return mosUketukeKbnHzn;
    }

    public void setMosUketukeKbnHzn(String pMosUketukeKbnHzn) {
        mosUketukeKbnHzn = pMosUketukeKbnHzn;
    }

    private String hokensyuruinohozon;

    @Column(name=GenDT_WfSentakujyotaiHozon.HOKENSYURUINOHOZON)
    public String getHokensyuruinohozon() {
        return hokensyuruinohozon;
    }

    public void setHokensyuruinohozon(String pHokensyuruinohozon) {
        hokensyuruinohozon = pHokensyuruinohozon;
    }

    private String dairitencd1;

    @Column(name=GenDT_WfSentakujyotaiHozon.DAIRITENCD1)
    @MaxLength(max=7)
    @AlphaDigit
    public String getDairitencd1() {
        return dairitencd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitencd1(String pDairitencd1) {
        dairitencd1 = pDairitencd1;
    }

    private String dairitencd2;

    @Column(name=GenDT_WfSentakujyotaiHozon.DAIRITENCD2)
    @MaxLength(max=7)
    @AlphaDigit
    public String getDairitencd2() {
        return dairitencd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitencd2(String pDairitencd2) {
        dairitencd2 = pDairitencd2;
    }

    private String drtencd3;

    @Column(name=GenDT_WfSentakujyotaiHozon.DRTENCD3)
    @MaxLength(max=7)
    @AlphaDigit
    public String getDrtencd3() {
        return drtencd3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtencd3(String pDrtencd3) {
        drtencd3 = pDrtencd3;
    }

    private String drtencd4;

    @Column(name=GenDT_WfSentakujyotaiHozon.DRTENCD4)
    @MaxLength(max=7)
    @AlphaDigit
    public String getDrtencd4() {
        return drtencd4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtencd4(String pDrtencd4) {
        drtencd4 = pDrtencd4;
    }

    private String drtencd5;

    @Column(name=GenDT_WfSentakujyotaiHozon.DRTENCD5)
    @MaxLength(max=7)
    @AlphaDigit
    public String getDrtencd5() {
        return drtencd5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtencd5(String pDrtencd5) {
        drtencd5 = pDrtencd5;
    }

    private Boolean koDairitenTaisyouKbn;

    @Type(type="BooleanType")
    @Column(name=GenDT_WfSentakujyotaiHozon.KODAIRITENTAISYOUKBN)
    public Boolean getKoDairitenTaisyouKbn() {
        return koDairitenTaisyouKbn;
    }

    public void setKoDairitenTaisyouKbn(Boolean pKoDairitenTaisyouKbn) {
        koDairitenTaisyouKbn = pKoDairitenTaisyouKbn;
    }

    private String jimuyoucd;

    @Column(name=GenDT_WfSentakujyotaiHozon.JIMUYOUCD)
    @Length(length=3)
    @SingleByteStrings
    @AlphaDigit
    public String getJimuyoucd() {
        return jimuyoucd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setJimuyoucd(String pJimuyoucd) {
        jimuyoucd = pJimuyoucd;
    }

    private Boolean jmycdMisetteiKbn;

    @Type(type="BooleanType")
    @Column(name=GenDT_WfSentakujyotaiHozon.JMYCDMISETTEIKBN)
    public Boolean getJmycdMisetteiKbn() {
        return jmycdMisetteiKbn;
    }

    public void setJmycdMisetteiKbn(Boolean pJmycdMisetteiKbn) {
        jmycdMisetteiKbn = pJmycdMisetteiKbn;
    }

    private Boolean djmskmKeiyakuKbn;

    @Type(type="BooleanType")
    @Column(name=GenDT_WfSentakujyotaiHozon.DJMSKMKEIYAKUKBN)
    public Boolean getDjmskmKeiyakuKbn() {
        return djmskmKeiyakuKbn;
    }

    public void setDjmskmKeiyakuKbn(Boolean pDjmskmKeiyakuKbn) {
        djmskmKeiyakuKbn = pDjmskmKeiyakuKbn;
    }

    private BizDate mosYmdFrom;

    @Type(type="BizDateType")
    @Column(name=GenDT_WfSentakujyotaiHozon.MOSYMDFROM)
    @ValidDate
    public BizDate getMosYmdFrom() {
        return mosYmdFrom;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosYmdFrom(BizDate pMosYmdFrom) {
        mosYmdFrom = pMosYmdFrom;
    }

    private BizDate mosYmdTo;

    @Type(type="BizDateType")
    @Column(name=GenDT_WfSentakujyotaiHozon.MOSYMDTO)
    @ValidDate
    public BizDate getMosYmdTo() {
        return mosYmdTo;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosYmdTo(BizDate pMosYmdTo) {
        mosYmdTo = pMosYmdTo;
    }

    private BizDate jimustartYmdFrom;

    @Type(type="BizDateType")
    @Column(name=GenDT_WfSentakujyotaiHozon.JIMUSTARTYMDFROM)
    @ValidDate
    public BizDate getJimustartYmdFrom() {
        return jimustartYmdFrom;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setJimustartYmdFrom(BizDate pJimustartYmdFrom) {
        jimustartYmdFrom = pJimustartYmdFrom;
    }

    private BizDate jimustartYmdTo;

    @Type(type="BizDateType")
    @Column(name=GenDT_WfSentakujyotaiHozon.JIMUSTARTYMDTO)
    @ValidDate
    public BizDate getJimustartYmdTo() {
        return jimustartYmdTo;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setJimustartYmdTo(BizDate pJimustartYmdTo) {
        jimustartYmdTo = pJimustartYmdTo;
    }

    private String mosno;

    @Column(name=GenDT_WfSentakujyotaiHozon.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return mosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

    private String syono;

    @Column(name=GenDT_WfSentakujyotaiHozon.SYONO)
    @SyoukenNo
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private String nksysyno;

    @Column(name=GenDT_WfSentakujyotaiHozon.NKSYSYNO)
    @NenkinSyousyoNo
    public String getNksysyno() {
        return nksysyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNksysyno(String pNksysyno) {
        nksysyno = pNksysyno;
    }
}