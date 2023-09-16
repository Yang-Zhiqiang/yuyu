package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_DsGyoumuCdKbn;
import yuyu.def.classification.C_DsSyoriNaiyouKbn;
import yuyu.def.classification.C_SetudanKasyoKbn;
import yuyu.def.classification.C_SetudanRiyuuKbn;
import yuyu.def.classification.C_TtdkIsihyouziKbn;
import yuyu.def.classification.C_TtdkKekkaKbn;
import yuyu.def.db.entity.MT_SousaRirekiIvrInfo;
import yuyu.def.db.id.PKMT_SousaRirekiIvrInfo;
import yuyu.def.db.meta.GenQMT_SousaRirekiIvrInfo;
import yuyu.def.db.meta.QMT_SousaRirekiIvrInfo;
import yuyu.def.db.type.UserType_C_DsGyoumuCdKbn;
import yuyu.def.db.type.UserType_C_DsSyoriNaiyouKbn;
import yuyu.def.db.type.UserType_C_SetudanKasyoKbn;
import yuyu.def.db.type.UserType_C_SetudanRiyuuKbn;
import yuyu.def.db.type.UserType_C_TtdkIsihyouziKbn;
import yuyu.def.db.type.UserType_C_TtdkKekkaKbn;

/**
 * 操作履歴ＩＶＲ情報テーブル テーブルのマッピング情報クラスで、 {@link MT_SousaRirekiIvrInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_SousaRirekiIvrInfo}</td><td colspan="3">操作履歴ＩＶＲ情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getTtdksikibetuid ttdksikibetuid}</td><td>手続識別ＩＤ</td><td align="center">{@link PKMT_SousaRirekiIvrInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTyakusinymd tyakusinymd}</td><td>着信日時</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDsgyoumucd dsgyoumucd}</td><td>ＤＳ業務コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DsGyoumuCdKbn}</td></tr>
 *  <tr><td>{@link #getSyorinaiyoukbn syorinaiyoukbn}</td><td>処理内容区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DsSyoriNaiyouKbn}</td></tr>
 *  <tr><td>{@link #getCallid callid}</td><td>コールＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDssyorikekkakbn dssyorikekkakbn}</td><td>ＤＳ処理結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TtdkKekkaKbn}</td></tr>
 *  <tr><td>{@link #getSetudankasyokbn setudankasyokbn}</td><td>切断箇所区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SetudanKasyoKbn}</td></tr>
 *  <tr><td>{@link #getSetudanriyuukbn setudanriyuukbn}</td><td>切断理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SetudanRiyuuKbn}</td></tr>
 *  <tr><td>{@link #getTuuwatime tuuwatime}</td><td>通話時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTtdkisihyouzikbn ttdkisihyouzikbn}</td><td>手続意思表示区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TtdkIsihyouziKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_SousaRirekiIvrInfo
 * @see     PKMT_SousaRirekiIvrInfo
 * @see     QMT_SousaRirekiIvrInfo
 * @see     GenQMT_SousaRirekiIvrInfo
 */
@MappedSuperclass
@Table(name=GenMT_SousaRirekiIvrInfo.TABLE_NAME)
@IdClass(value=PKMT_SousaRirekiIvrInfo.class)
@TypeDefs({
    @TypeDef(name="UserType_C_DsGyoumuCdKbn", typeClass=UserType_C_DsGyoumuCdKbn.class),
    @TypeDef(name="UserType_C_DsSyoriNaiyouKbn", typeClass=UserType_C_DsSyoriNaiyouKbn.class),
    @TypeDef(name="UserType_C_SetudanKasyoKbn", typeClass=UserType_C_SetudanKasyoKbn.class),
    @TypeDef(name="UserType_C_SetudanRiyuuKbn", typeClass=UserType_C_SetudanRiyuuKbn.class),
    @TypeDef(name="UserType_C_TtdkIsihyouziKbn", typeClass=UserType_C_TtdkIsihyouziKbn.class),
    @TypeDef(name="UserType_C_TtdkKekkaKbn", typeClass=UserType_C_TtdkKekkaKbn.class)
})
public abstract class GenMT_SousaRirekiIvrInfo extends AbstractExDBEntity<MT_SousaRirekiIvrInfo, PKMT_SousaRirekiIvrInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "MT_SousaRirekiIvrInfo";
    public static final String TTDKSIKIBETUID           = "ttdksikibetuid";
    public static final String TYAKUSINYMD              = "tyakusinymd";
    public static final String DSGYOUMUCD               = "dsgyoumucd";
    public static final String SYORINAIYOUKBN           = "syorinaiyoukbn";
    public static final String CALLID                   = "callid";
    public static final String DSSYORIKEKKAKBN          = "dssyorikekkakbn";
    public static final String SETUDANKASYOKBN          = "setudankasyokbn";
    public static final String SETUDANRIYUUKBN          = "setudanriyuukbn";
    public static final String TUUWATIME                = "tuuwatime";
    public static final String TTDKISIHYOUZIKBN         = "ttdkisihyouzikbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKMT_SousaRirekiIvrInfo primaryKey;

    public GenMT_SousaRirekiIvrInfo() {
        primaryKey = new PKMT_SousaRirekiIvrInfo();
    }

    public GenMT_SousaRirekiIvrInfo(String pTtdksikibetuid) {
        primaryKey = new PKMT_SousaRirekiIvrInfo(pTtdksikibetuid);
    }

    @Transient
    @Override
    public PKMT_SousaRirekiIvrInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QMT_SousaRirekiIvrInfo> getMetaClass() {
        return QMT_SousaRirekiIvrInfo.class;
    }

    @Id
    @Column(name=GenMT_SousaRirekiIvrInfo.TTDKSIKIBETUID)
    public String getTtdksikibetuid() {
        return getPrimaryKey().getTtdksikibetuid();
    }

    public void setTtdksikibetuid(String pTtdksikibetuid) {
        getPrimaryKey().setTtdksikibetuid(pTtdksikibetuid);
    }

    private String tyakusinymd;

    @Column(name=GenMT_SousaRirekiIvrInfo.TYAKUSINYMD)
    public String getTyakusinymd() {
        return tyakusinymd;
    }

    public void setTyakusinymd(String pTyakusinymd) {
        tyakusinymd = pTyakusinymd;
    }

    private C_DsGyoumuCdKbn dsgyoumucd;

    @Type(type="UserType_C_DsGyoumuCdKbn")
    @Column(name=GenMT_SousaRirekiIvrInfo.DSGYOUMUCD)
    public C_DsGyoumuCdKbn getDsgyoumucd() {
        return dsgyoumucd;
    }

    public void setDsgyoumucd(C_DsGyoumuCdKbn pDsgyoumucd) {
        dsgyoumucd = pDsgyoumucd;
    }

    private C_DsSyoriNaiyouKbn syorinaiyoukbn;

    @Type(type="UserType_C_DsSyoriNaiyouKbn")
    @Column(name=GenMT_SousaRirekiIvrInfo.SYORINAIYOUKBN)
    public C_DsSyoriNaiyouKbn getSyorinaiyoukbn() {
        return syorinaiyoukbn;
    }

    public void setSyorinaiyoukbn(C_DsSyoriNaiyouKbn pSyorinaiyoukbn) {
        syorinaiyoukbn = pSyorinaiyoukbn;
    }

    private String callid;

    @Column(name=GenMT_SousaRirekiIvrInfo.CALLID)
    public String getCallid() {
        return callid;
    }

    public void setCallid(String pCallid) {
        callid = pCallid;
    }

    private C_TtdkKekkaKbn dssyorikekkakbn;

    @Type(type="UserType_C_TtdkKekkaKbn")
    @Column(name=GenMT_SousaRirekiIvrInfo.DSSYORIKEKKAKBN)
    public C_TtdkKekkaKbn getDssyorikekkakbn() {
        return dssyorikekkakbn;
    }

    public void setDssyorikekkakbn(C_TtdkKekkaKbn pDssyorikekkakbn) {
        dssyorikekkakbn = pDssyorikekkakbn;
    }

    private C_SetudanKasyoKbn setudankasyokbn;

    @Type(type="UserType_C_SetudanKasyoKbn")
    @Column(name=GenMT_SousaRirekiIvrInfo.SETUDANKASYOKBN)
    public C_SetudanKasyoKbn getSetudankasyokbn() {
        return setudankasyokbn;
    }

    public void setSetudankasyokbn(C_SetudanKasyoKbn pSetudankasyokbn) {
        setudankasyokbn = pSetudankasyokbn;
    }

    private C_SetudanRiyuuKbn setudanriyuukbn;

    @Type(type="UserType_C_SetudanRiyuuKbn")
    @Column(name=GenMT_SousaRirekiIvrInfo.SETUDANRIYUUKBN)
    public C_SetudanRiyuuKbn getSetudanriyuukbn() {
        return setudanriyuukbn;
    }

    public void setSetudanriyuukbn(C_SetudanRiyuuKbn pSetudanriyuukbn) {
        setudanriyuukbn = pSetudanriyuukbn;
    }

    private String tuuwatime;

    @Column(name=GenMT_SousaRirekiIvrInfo.TUUWATIME)
    public String getTuuwatime() {
        return tuuwatime;
    }

    public void setTuuwatime(String pTuuwatime) {
        tuuwatime = pTuuwatime;
    }

    private C_TtdkIsihyouziKbn ttdkisihyouzikbn;

    @Type(type="UserType_C_TtdkIsihyouziKbn")
    @Column(name=GenMT_SousaRirekiIvrInfo.TTDKISIHYOUZIKBN)
    public C_TtdkIsihyouziKbn getTtdkisihyouzikbn() {
        return ttdkisihyouzikbn;
    }

    public void setTtdkisihyouzikbn(C_TtdkIsihyouziKbn pTtdkisihyouzikbn) {
        ttdkisihyouzikbn = pTtdkisihyouzikbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenMT_SousaRirekiIvrInfo.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenMT_SousaRirekiIvrInfo.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenMT_SousaRirekiIvrInfo.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}