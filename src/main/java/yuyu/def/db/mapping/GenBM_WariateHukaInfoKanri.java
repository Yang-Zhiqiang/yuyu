package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.db.entity.BM_WariateHukaInfoKanri;
import yuyu.def.db.id.PKBM_WariateHukaInfoKanri;
import yuyu.def.db.meta.GenQBM_WariateHukaInfoKanri;
import yuyu.def.db.meta.QBM_WariateHukaInfoKanri;

/**
 * 割当不可情報管理マスタ テーブルのマッピング情報クラスで、 {@link BM_WariateHukaInfoKanri} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_WariateHukaInfoKanri}</td><td colspan="3">割当不可情報管理マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSubSystemId subSystemId}</td><td>サブシステムＩＤ</td><td align="center">{@link PKBM_WariateHukaInfoKanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJimutetuzukicd jimutetuzukicd}</td><td>事務手続コード</td><td align="center">{@link PKBM_WariateHukaInfoKanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCurrenttskid currenttskid}</td><td>現在タスクID</td><td align="center">{@link PKBM_WariateHukaInfoKanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKBM_WariateHukaInfoKanri ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getNexttskid nexttskid}</td><td>次回タスクID</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getWrthukatskid wrthukatskid}</td><td>割当不可タスクID</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getWrthukakaijyotskid wrthukakaijyotskid}</td><td>割当不可解除用タスクID</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_WariateHukaInfoKanri
 * @see     PKBM_WariateHukaInfoKanri
 * @see     QBM_WariateHukaInfoKanri
 * @see     GenQBM_WariateHukaInfoKanri
 */
@MappedSuperclass
@Table(name=GenBM_WariateHukaInfoKanri.TABLE_NAME)
@IdClass(value=PKBM_WariateHukaInfoKanri.class)
public abstract class GenBM_WariateHukaInfoKanri extends AbstractExDBEntity<BM_WariateHukaInfoKanri, PKBM_WariateHukaInfoKanri> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_WariateHukaInfoKanri";
    public static final String SUBSYSTEMID              = "subSystemId";
    public static final String JIMUTETUZUKICD           = "jimutetuzukicd";
    public static final String CURRENTTSKID             = "currenttskid";
    public static final String RENNO                    = "renno";
    public static final String NEXTTSKID                = "nexttskid";
    public static final String WRTHUKATSKID             = "wrthukatskid";
    public static final String WRTHUKAKAIJYOTSKID       = "wrthukakaijyotskid";

    private final PKBM_WariateHukaInfoKanri primaryKey;

    public GenBM_WariateHukaInfoKanri() {
        primaryKey = new PKBM_WariateHukaInfoKanri();
    }

    public GenBM_WariateHukaInfoKanri(
        String pSubSystemId,
        String pJimutetuzukicd,
        String pCurrenttskid,
        Integer pRenno
    ) {
        primaryKey = new PKBM_WariateHukaInfoKanri(
            pSubSystemId,
            pJimutetuzukicd,
            pCurrenttskid,
            pRenno
        );
    }

    @Transient
    @Override
    public PKBM_WariateHukaInfoKanri getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_WariateHukaInfoKanri> getMetaClass() {
        return QBM_WariateHukaInfoKanri.class;
    }

    @Id
    @Column(name=GenBM_WariateHukaInfoKanri.SUBSYSTEMID)
    public String getSubSystemId() {
        return getPrimaryKey().getSubSystemId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSubSystemId(String pSubSystemId) {
        getPrimaryKey().setSubSystemId(pSubSystemId);
    }

    @Id
    @Column(name=GenBM_WariateHukaInfoKanri.JIMUTETUZUKICD)
    public String getJimutetuzukicd() {
        return getPrimaryKey().getJimutetuzukicd();
    }

    public void setJimutetuzukicd(String pJimutetuzukicd) {
        getPrimaryKey().setJimutetuzukicd(pJimutetuzukicd);
    }

    @Id
    @Column(name=GenBM_WariateHukaInfoKanri.CURRENTTSKID)
    public String getCurrenttskid() {
        return getPrimaryKey().getCurrenttskid();
    }

    public void setCurrenttskid(String pCurrenttskid) {
        getPrimaryKey().setCurrenttskid(pCurrenttskid);
    }

    @Id
    @Column(name=GenBM_WariateHukaInfoKanri.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private String nexttskid;

    @Column(name=GenBM_WariateHukaInfoKanri.NEXTTSKID)
    public String getNexttskid() {
        return nexttskid;
    }

    public void setNexttskid(String pNexttskid) {
        nexttskid = pNexttskid;
    }

    private String wrthukatskid;

    @Column(name=GenBM_WariateHukaInfoKanri.WRTHUKATSKID)
    public String getWrthukatskid() {
        return wrthukatskid;
    }

    public void setWrthukatskid(String pWrthukatskid) {
        wrthukatskid = pWrthukatskid;
    }

    private String wrthukakaijyotskid;

    @Column(name=GenBM_WariateHukaInfoKanri.WRTHUKAKAIJYOTSKID)
    public String getWrthukakaijyotskid() {
        return wrthukakaijyotskid;
    }

    public void setWrthukakaijyotskid(String pWrthukakaijyotskid) {
        wrthukakaijyotskid = pWrthukakaijyotskid;
    }
}