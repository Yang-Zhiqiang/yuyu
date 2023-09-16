package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.db.entity.HT_KmTsRireki;
import yuyu.def.db.id.PKHT_KmTsRireki;
import yuyu.def.db.meta.GenQHT_KmTsRireki;
import yuyu.def.db.meta.QHT_KmTsRireki;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 項目訂正履歴テーブル テーブルのマッピング情報クラスで、 {@link HT_KmTsRireki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_KmTsRireki}</td><td colspan="3">項目訂正履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_KmTsRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoriTime syoriTime}</td><td>処理時間</td><td align="center">{@link PKHT_KmTsRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">{@link PKHT_KmTsRireki ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKinouModeId kinouModeId}</td><td>機能モードＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTskmnm tskmnm}</td><td>訂正項目名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsmaenaiyou tsmaenaiyou}</td><td>訂正前内容</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsgonaiyou tsgonaiyou}</td><td>訂正後内容</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTantid tantid}</td><td>担当者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_KmTsRireki
 * @see     PKHT_KmTsRireki
 * @see     QHT_KmTsRireki
 * @see     GenQHT_KmTsRireki
 */
@MappedSuperclass
@Table(name=GenHT_KmTsRireki.TABLE_NAME)
@IdClass(value=PKHT_KmTsRireki.class)
public abstract class GenHT_KmTsRireki extends AbstractExDBEntity<HT_KmTsRireki, PKHT_KmTsRireki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_KmTsRireki";
    public static final String MOSNO                    = "mosno";
    public static final String SYORITIME                = "syoriTime";
    public static final String RENNO3KETA               = "renno3keta";
    public static final String KINOUID                  = "kinouId";
    public static final String KINOUMODEID              = "kinouModeId";
    public static final String TSKMNM                   = "tskmnm";
    public static final String TSMAENAIYOU              = "tsmaenaiyou";
    public static final String TSGONAIYOU               = "tsgonaiyou";
    public static final String TANTID                   = "tantid";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_KmTsRireki primaryKey;

    public GenHT_KmTsRireki() {
        primaryKey = new PKHT_KmTsRireki();
    }

    public GenHT_KmTsRireki(
        String pMosno,
        String pSyoriTime,
        Integer pRenno3keta
    ) {
        primaryKey = new PKHT_KmTsRireki(
            pMosno,
            pSyoriTime,
            pRenno3keta
        );
    }

    @Transient
    @Override
    public PKHT_KmTsRireki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_KmTsRireki> getMetaClass() {
        return QHT_KmTsRireki.class;
    }

    @Id
    @Column(name=GenHT_KmTsRireki.MOSNO)
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
    @Column(name=GenHT_KmTsRireki.SYORITIME)
    public String getSyoriTime() {
        return getPrimaryKey().getSyoriTime();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriTime(String pSyoriTime) {
        getPrimaryKey().setSyoriTime(pSyoriTime);
    }

    @Id
    @Column(name=GenHT_KmTsRireki.RENNO3KETA)
    public Integer getRenno3keta() {
        return getPrimaryKey().getRenno3keta();
    }

    public void setRenno3keta(Integer pRenno3keta) {
        getPrimaryKey().setRenno3keta(pRenno3keta);
    }

    private String kinouId;

    @Column(name=GenHT_KmTsRireki.KINOUID)
    public String getKinouId() {
        return kinouId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKinouId(String pKinouId) {
        kinouId = pKinouId;
    }

    private String kinouModeId;

    @Column(name=GenHT_KmTsRireki.KINOUMODEID)
    public String getKinouModeId() {
        return kinouModeId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKinouModeId(String pKinouModeId) {
        kinouModeId = pKinouModeId;
    }

    private String tskmnm;

    @Column(name=GenHT_KmTsRireki.TSKMNM)
    public String getTskmnm() {
        return tskmnm;
    }

    public void setTskmnm(String pTskmnm) {
        tskmnm = pTskmnm;
    }

    private String tsmaenaiyou;

    @Column(name=GenHT_KmTsRireki.TSMAENAIYOU)
    public String getTsmaenaiyou() {
        return tsmaenaiyou;
    }

    public void setTsmaenaiyou(String pTsmaenaiyou) {
        tsmaenaiyou = pTsmaenaiyou;
    }

    private String tsgonaiyou;

    @Column(name=GenHT_KmTsRireki.TSGONAIYOU)
    public String getTsgonaiyou() {
        return tsgonaiyou;
    }

    public void setTsgonaiyou(String pTsgonaiyou) {
        tsgonaiyou = pTsgonaiyou;
    }

    private String tantid;

    @Column(name=GenHT_KmTsRireki.TANTID)
    public String getTantid() {
        return tantid;
    }

    public void setTantid(String pTantid) {
        tantid = pTantid;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_KmTsRireki.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_KmTsRireki.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}