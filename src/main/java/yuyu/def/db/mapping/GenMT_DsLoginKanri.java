package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_BaitaiKbn;
import yuyu.def.db.entity.MT_DsLoginKanri;
import yuyu.def.db.id.PKMT_DsLoginKanri;
import yuyu.def.db.meta.GenQMT_DsLoginKanri;
import yuyu.def.db.meta.QMT_DsLoginKanri;
import yuyu.def.db.type.UserType_C_BaitaiKbn;

/**
 * ＤＳログイン管理テーブル テーブルのマッピング情報クラスで、 {@link MT_DsLoginKanri} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_DsLoginKanri}</td><td colspan="3">ＤＳログイン管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">{@link PKMT_DsLoginKanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyokailoginymd syokailoginymd}</td><td>初回ログイン年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyokailogintime syokailogintime}</td><td>初回ログイン時刻</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyokailoginbaitaikbn syokailoginbaitaikbn}</td><td>初回ログイン媒体区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BaitaiKbn}</td></tr>
 *  <tr><td>{@link #getSaisinloginymd saisinloginymd}</td><td>最新ログイン年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSaisinlogintime saisinlogintime}</td><td>最新ログイン時刻</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSaisinloginbaitaikbn saisinloginbaitaikbn}</td><td>最新ログイン媒体区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BaitaiKbn}</td></tr>
 *  <tr><td>{@link #getDshnnkakcderrorkaisuu dshnnkakcderrorkaisuu}</td><td>ＤＳ本人確認コードエラー回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDskokyakunmerrorkaisuu dskokyakunmerrorkaisuu}</td><td>ＤＳ顧客名エラー回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDskokyakuseiymderrorkaisuu dskokyakuseiymderrorkaisuu}</td><td>ＤＳ顧客生年月日エラー回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDskokyakutelnoerrorkaisuu dskokyakutelnoerrorkaisuu}</td><td>ＤＳ顧客電話番号エラー回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_DsLoginKanri
 * @see     PKMT_DsLoginKanri
 * @see     QMT_DsLoginKanri
 * @see     GenQMT_DsLoginKanri
 */
@MappedSuperclass
@Table(name=GenMT_DsLoginKanri.TABLE_NAME)
@IdClass(value=PKMT_DsLoginKanri.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_BaitaiKbn", typeClass=UserType_C_BaitaiKbn.class)
})
public abstract class GenMT_DsLoginKanri extends AbstractExDBEntity<MT_DsLoginKanri, PKMT_DsLoginKanri> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "MT_DsLoginKanri";
    public static final String DSKOKNO                  = "dskokno";
    public static final String SYOKAILOGINYMD           = "syokailoginymd";
    public static final String SYOKAILOGINTIME          = "syokailogintime";
    public static final String SYOKAILOGINBAITAIKBN     = "syokailoginbaitaikbn";
    public static final String SAISINLOGINYMD           = "saisinloginymd";
    public static final String SAISINLOGINTIME          = "saisinlogintime";
    public static final String SAISINLOGINBAITAIKBN     = "saisinloginbaitaikbn";
    public static final String DSHNNKAKCDERRORKAISUU    = "dshnnkakcderrorkaisuu";
    public static final String DSKOKYAKUNMERRORKAISUU   = "dskokyakunmerrorkaisuu";
    public static final String DSKOKYAKUSEIYMDERRORKAISUU = "dskokyakuseiymderrorkaisuu";
    public static final String DSKOKYAKUTELNOERRORKAISUU = "dskokyakutelnoerrorkaisuu";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";

    private final PKMT_DsLoginKanri primaryKey;

    public GenMT_DsLoginKanri() {
        primaryKey = new PKMT_DsLoginKanri();
    }

    public GenMT_DsLoginKanri(String pDskokno) {
        primaryKey = new PKMT_DsLoginKanri(pDskokno);
    }

    @Transient
    @Override
    public PKMT_DsLoginKanri getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QMT_DsLoginKanri> getMetaClass() {
        return QMT_DsLoginKanri.class;
    }

    @Id
    @Column(name=GenMT_DsLoginKanri.DSKOKNO)
    public String getDskokno() {
        return getPrimaryKey().getDskokno();
    }

    public void setDskokno(String pDskokno) {
        getPrimaryKey().setDskokno(pDskokno);
    }

    private BizDate syokailoginymd;

    @Type(type="BizDateType")
    @Column(name=GenMT_DsLoginKanri.SYOKAILOGINYMD)
    public BizDate getSyokailoginymd() {
        return syokailoginymd;
    }

    public void setSyokailoginymd(BizDate pSyokailoginymd) {
        syokailoginymd = pSyokailoginymd;
    }

    private String syokailogintime;

    @Column(name=GenMT_DsLoginKanri.SYOKAILOGINTIME)
    public String getSyokailogintime() {
        return syokailogintime;
    }

    public void setSyokailogintime(String pSyokailogintime) {
        syokailogintime = pSyokailogintime;
    }

    private C_BaitaiKbn syokailoginbaitaikbn;

    @Type(type="UserType_C_BaitaiKbn")
    @Column(name=GenMT_DsLoginKanri.SYOKAILOGINBAITAIKBN)
    public C_BaitaiKbn getSyokailoginbaitaikbn() {
        return syokailoginbaitaikbn;
    }

    public void setSyokailoginbaitaikbn(C_BaitaiKbn pSyokailoginbaitaikbn) {
        syokailoginbaitaikbn = pSyokailoginbaitaikbn;
    }

    private BizDate saisinloginymd;

    @Type(type="BizDateType")
    @Column(name=GenMT_DsLoginKanri.SAISINLOGINYMD)
    public BizDate getSaisinloginymd() {
        return saisinloginymd;
    }

    public void setSaisinloginymd(BizDate pSaisinloginymd) {
        saisinloginymd = pSaisinloginymd;
    }

    private String saisinlogintime;

    @Column(name=GenMT_DsLoginKanri.SAISINLOGINTIME)
    public String getSaisinlogintime() {
        return saisinlogintime;
    }

    public void setSaisinlogintime(String pSaisinlogintime) {
        saisinlogintime = pSaisinlogintime;
    }

    private C_BaitaiKbn saisinloginbaitaikbn;

    @Type(type="UserType_C_BaitaiKbn")
    @Column(name=GenMT_DsLoginKanri.SAISINLOGINBAITAIKBN)
    public C_BaitaiKbn getSaisinloginbaitaikbn() {
        return saisinloginbaitaikbn;
    }

    public void setSaisinloginbaitaikbn(C_BaitaiKbn pSaisinloginbaitaikbn) {
        saisinloginbaitaikbn = pSaisinloginbaitaikbn;
    }

    private Integer dshnnkakcderrorkaisuu;

    @Column(name=GenMT_DsLoginKanri.DSHNNKAKCDERRORKAISUU)
    public Integer getDshnnkakcderrorkaisuu() {
        return dshnnkakcderrorkaisuu;
    }

    public void setDshnnkakcderrorkaisuu(Integer pDshnnkakcderrorkaisuu) {
        dshnnkakcderrorkaisuu = pDshnnkakcderrorkaisuu;
    }

    private Integer dskokyakunmerrorkaisuu;

    @Column(name=GenMT_DsLoginKanri.DSKOKYAKUNMERRORKAISUU)
    public Integer getDskokyakunmerrorkaisuu() {
        return dskokyakunmerrorkaisuu;
    }

    public void setDskokyakunmerrorkaisuu(Integer pDskokyakunmerrorkaisuu) {
        dskokyakunmerrorkaisuu = pDskokyakunmerrorkaisuu;
    }

    private Integer dskokyakuseiymderrorkaisuu;

    @Column(name=GenMT_DsLoginKanri.DSKOKYAKUSEIYMDERRORKAISUU)
    public Integer getDskokyakuseiymderrorkaisuu() {
        return dskokyakuseiymderrorkaisuu;
    }

    public void setDskokyakuseiymderrorkaisuu(Integer pDskokyakuseiymderrorkaisuu) {
        dskokyakuseiymderrorkaisuu = pDskokyakuseiymderrorkaisuu;
    }

    private Integer dskokyakutelnoerrorkaisuu;

    @Column(name=GenMT_DsLoginKanri.DSKOKYAKUTELNOERRORKAISUU)
    public Integer getDskokyakutelnoerrorkaisuu() {
        return dskokyakutelnoerrorkaisuu;
    }

    public void setDskokyakutelnoerrorkaisuu(Integer pDskokyakutelnoerrorkaisuu) {
        dskokyakutelnoerrorkaisuu = pDskokyakutelnoerrorkaisuu;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenMT_DsLoginKanri.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinTime;

    @Column(name=GenMT_DsLoginKanri.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenMT_DsLoginKanri.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }
}
