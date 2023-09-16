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
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SousaRirekiJkKbn;
import yuyu.def.classification.C_TtdkKekkaKbn;
import yuyu.def.classification.C_TtdkKinouKbn;
import yuyu.def.db.entity.MT_SousaRireki;
import yuyu.def.db.id.PKMT_SousaRireki;
import yuyu.def.db.meta.GenQMT_SousaRireki;
import yuyu.def.db.meta.QMT_SousaRireki;
import yuyu.def.db.type.UserType_C_SousaRirekiJkKbn;
import yuyu.def.db.type.UserType_C_TtdkKekkaKbn;
import yuyu.def.db.type.UserType_C_TtdkKinouKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 操作履歴テーブル テーブルのマッピング情報クラスで、 {@link MT_SousaRireki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_SousaRireki}</td><td colspan="3">操作履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getTtdksikibetuid ttdksikibetuid}</td><td>手続識別ＩＤ</td><td align="center">{@link PKMT_SousaRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTtdkstartymd ttdkstartymd}</td><td>手続開始日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTtdkstarttime ttdkstarttime}</td><td>手続開始時刻</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTtdkendymd ttdkendymd}</td><td>手続終了日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTtdkendtime ttdkendtime}</td><td>手続終了時刻</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTtdkkinoukbn ttdkkinoukbn}</td><td>手続機能区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TtdkKinouKbn}</td></tr>
 *  <tr><td>{@link #getSousarirekijkkbn sousarirekijkkbn}</td><td>操作履歴状況区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SousaRirekiJkKbn}</td></tr>
 *  <tr><td>{@link #getSousarirekikekkakbn sousarirekikekkakbn}</td><td>操作履歴結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TtdkKekkaKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_SousaRireki
 * @see     PKMT_SousaRireki
 * @see     QMT_SousaRireki
 * @see     GenQMT_SousaRireki
 */
@MappedSuperclass
@Table(name=GenMT_SousaRireki.TABLE_NAME)
@IdClass(value=PKMT_SousaRireki.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_SousaRirekiJkKbn", typeClass=UserType_C_SousaRirekiJkKbn.class),
    @TypeDef(name="UserType_C_TtdkKekkaKbn", typeClass=UserType_C_TtdkKekkaKbn.class),
    @TypeDef(name="UserType_C_TtdkKinouKbn", typeClass=UserType_C_TtdkKinouKbn.class)
})
public abstract class GenMT_SousaRireki extends AbstractExDBEntity<MT_SousaRireki, PKMT_SousaRireki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "MT_SousaRireki";
    public static final String TTDKSIKIBETUID           = "ttdksikibetuid";
    public static final String SYONO                    = "syono";
    public static final String DSKOKNO                  = "dskokno";
    public static final String TTDKSTARTYMD             = "ttdkstartymd";
    public static final String TTDKSTARTTIME            = "ttdkstarttime";
    public static final String TTDKENDYMD               = "ttdkendymd";
    public static final String TTDKENDTIME              = "ttdkendtime";
    public static final String TTDKKINOUKBN             = "ttdkkinoukbn";
    public static final String SOUSARIREKIJKKBN         = "sousarirekijkkbn";
    public static final String SOUSARIREKIKEKKAKBN      = "sousarirekikekkakbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKMT_SousaRireki primaryKey;

    public GenMT_SousaRireki() {
        primaryKey = new PKMT_SousaRireki();
    }

    public GenMT_SousaRireki(String pTtdksikibetuid) {
        primaryKey = new PKMT_SousaRireki(pTtdksikibetuid);
    }

    @Transient
    @Override
    public PKMT_SousaRireki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QMT_SousaRireki> getMetaClass() {
        return QMT_SousaRireki.class;
    }

    @Id
    @Column(name=GenMT_SousaRireki.TTDKSIKIBETUID)
    public String getTtdksikibetuid() {
        return getPrimaryKey().getTtdksikibetuid();
    }

    public void setTtdksikibetuid(String pTtdksikibetuid) {
        getPrimaryKey().setTtdksikibetuid(pTtdksikibetuid);
    }

    private String syono;

    @Column(name=GenMT_SousaRireki.SYONO)
    @SyoukenNo
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private String dskokno;

    @Column(name=GenMT_SousaRireki.DSKOKNO)
    public String getDskokno() {
        return dskokno;
    }

    public void setDskokno(String pDskokno) {
        dskokno = pDskokno;
    }

    private BizDate ttdkstartymd;

    @Type(type="BizDateType")
    @Column(name=GenMT_SousaRireki.TTDKSTARTYMD)
    public BizDate getTtdkstartymd() {
        return ttdkstartymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTtdkstartymd(BizDate pTtdkstartymd) {
        ttdkstartymd = pTtdkstartymd;
    }

    private String ttdkstarttime;

    @Column(name=GenMT_SousaRireki.TTDKSTARTTIME)
    public String getTtdkstarttime() {
        return ttdkstarttime;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTtdkstarttime(String pTtdkstarttime) {
        ttdkstarttime = pTtdkstarttime;
    }

    private BizDate ttdkendymd;

    @Type(type="BizDateType")
    @Column(name=GenMT_SousaRireki.TTDKENDYMD)
    public BizDate getTtdkendymd() {
        return ttdkendymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTtdkendymd(BizDate pTtdkendymd) {
        ttdkendymd = pTtdkendymd;
    }

    private String ttdkendtime;

    @Column(name=GenMT_SousaRireki.TTDKENDTIME)
    public String getTtdkendtime() {
        return ttdkendtime;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTtdkendtime(String pTtdkendtime) {
        ttdkendtime = pTtdkendtime;
    }

    private C_TtdkKinouKbn ttdkkinoukbn;

    @Type(type="UserType_C_TtdkKinouKbn")
    @Column(name=GenMT_SousaRireki.TTDKKINOUKBN)
    public C_TtdkKinouKbn getTtdkkinoukbn() {
        return ttdkkinoukbn;
    }

    public void setTtdkkinoukbn(C_TtdkKinouKbn pTtdkkinoukbn) {
        ttdkkinoukbn = pTtdkkinoukbn;
    }

    private C_SousaRirekiJkKbn sousarirekijkkbn;

    @Type(type="UserType_C_SousaRirekiJkKbn")
    @Column(name=GenMT_SousaRireki.SOUSARIREKIJKKBN)
    public C_SousaRirekiJkKbn getSousarirekijkkbn() {
        return sousarirekijkkbn;
    }

    public void setSousarirekijkkbn(C_SousaRirekiJkKbn pSousarirekijkkbn) {
        sousarirekijkkbn = pSousarirekijkkbn;
    }

    private C_TtdkKekkaKbn sousarirekikekkakbn;

    @Type(type="UserType_C_TtdkKekkaKbn")
    @Column(name=GenMT_SousaRireki.SOUSARIREKIKEKKAKBN)
    public C_TtdkKekkaKbn getSousarirekikekkakbn() {
        return sousarirekikekkakbn;
    }

    public void setSousarirekikekkakbn(C_TtdkKekkaKbn pSousarirekikekkakbn) {
        sousarirekikekkakbn = pSousarirekikekkakbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenMT_SousaRireki.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenMT_SousaRireki.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenMT_SousaRireki.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}