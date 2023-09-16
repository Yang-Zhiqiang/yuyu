package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.HM_SiinBunrui;
import yuyu.def.db.id.PKHM_SiinBunrui;
import yuyu.def.db.meta.GenQHM_SiinBunrui;
import yuyu.def.db.meta.QHM_SiinBunrui;

/**
 * 死因分類マスタ テーブルのマッピング情報クラスで、 {@link HM_SiinBunrui} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HM_SiinBunrui}</td><td colspan="3">死因分類マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSiincd siincd}</td><td>死因コード</td><td align="center">{@link PKHM_SiinBunrui ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiintyuubunnruicd siintyuubunnruicd}</td><td>死因中分類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTyuusiincd tyuusiincd}</td><td>中死因コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDaisiincd daisiincd}</td><td>大死因コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HM_SiinBunrui
 * @see     PKHM_SiinBunrui
 * @see     QHM_SiinBunrui
 * @see     GenQHM_SiinBunrui
 */
@MappedSuperclass
@Table(name=GenHM_SiinBunrui.TABLE_NAME)
@IdClass(value=PKHM_SiinBunrui.class)
public abstract class GenHM_SiinBunrui extends AbstractExDBEntity<HM_SiinBunrui, PKHM_SiinBunrui> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HM_SiinBunrui";
    public static final String SIINCD                   = "siincd";
    public static final String SIINTYUUBUNNRUICD        = "siintyuubunnruicd";
    public static final String TYUUSIINCD               = "tyuusiincd";
    public static final String DAISIINCD                = "daisiincd";

    private final PKHM_SiinBunrui primaryKey;

    public GenHM_SiinBunrui() {
        primaryKey = new PKHM_SiinBunrui();
    }

    public GenHM_SiinBunrui(String pSiincd) {
        primaryKey = new PKHM_SiinBunrui(pSiincd);
    }

    @Transient
    @Override
    public PKHM_SiinBunrui getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHM_SiinBunrui> getMetaClass() {
        return QHM_SiinBunrui.class;
    }

    @Id
    @Column(name=GenHM_SiinBunrui.SIINCD)
    public String getSiincd() {
        return getPrimaryKey().getSiincd();
    }

    public void setSiincd(String pSiincd) {
        getPrimaryKey().setSiincd(pSiincd);
    }

    private String siintyuubunnruicd;

    @Column(name=GenHM_SiinBunrui.SIINTYUUBUNNRUICD)
    public String getSiintyuubunnruicd() {
        return siintyuubunnruicd;
    }

    public void setSiintyuubunnruicd(String pSiintyuubunnruicd) {
        siintyuubunnruicd = pSiintyuubunnruicd;
    }

    private String tyuusiincd;

    @Column(name=GenHM_SiinBunrui.TYUUSIINCD)
    public String getTyuusiincd() {
        return tyuusiincd;
    }

    public void setTyuusiincd(String pTyuusiincd) {
        tyuusiincd = pTyuusiincd;
    }

    private String daisiincd;

    @Column(name=GenHM_SiinBunrui.DAISIINCD)
    public String getDaisiincd() {
        return daisiincd;
    }

    public void setDaisiincd(String pDaisiincd) {
        daisiincd = pDaisiincd;
    }
}
