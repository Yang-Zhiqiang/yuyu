package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.BM_LincKaisyacd;
import yuyu.def.db.id.PKBM_LincKaisyacd;
import yuyu.def.db.meta.GenQBM_LincKaisyacd;
import yuyu.def.db.meta.QBM_LincKaisyacd;

/**
 * ＬＩＮＣ会社コードマスタ テーブルのマッピング情報クラスで、 {@link BM_LincKaisyacd} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_LincKaisyacd}</td><td colspan="3">ＬＩＮＣ会社コードマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getLinckaisyacdnum linckaisyacdnum}</td><td>ＬＩＮＣ会社コード（数字）</td><td align="center">{@link PKBM_LincKaisyacd ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getLinckaisyanm linckaisyanm}</td><td>ＬＩＮＣ会社名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_LincKaisyacd
 * @see     PKBM_LincKaisyacd
 * @see     QBM_LincKaisyacd
 * @see     GenQBM_LincKaisyacd
 */
@MappedSuperclass
@Table(name=GenBM_LincKaisyacd.TABLE_NAME)
@IdClass(value=PKBM_LincKaisyacd.class)
public abstract class GenBM_LincKaisyacd extends AbstractExDBEntity<BM_LincKaisyacd, PKBM_LincKaisyacd> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_LincKaisyacd";
    public static final String LINCKAISYACDNUM          = "linckaisyacdnum";
    public static final String LINCKAISYANM             = "linckaisyanm";

    private final PKBM_LincKaisyacd primaryKey;

    public GenBM_LincKaisyacd() {
        primaryKey = new PKBM_LincKaisyacd();
    }

    public GenBM_LincKaisyacd(String pLinckaisyacdnum) {
        primaryKey = new PKBM_LincKaisyacd(pLinckaisyacdnum);
    }

    @Transient
    @Override
    public PKBM_LincKaisyacd getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_LincKaisyacd> getMetaClass() {
        return QBM_LincKaisyacd.class;
    }

    @Id
    @Column(name=GenBM_LincKaisyacd.LINCKAISYACDNUM)
    public String getLinckaisyacdnum() {
        return getPrimaryKey().getLinckaisyacdnum();
    }

    public void setLinckaisyacdnum(String pLinckaisyacdnum) {
        getPrimaryKey().setLinckaisyacdnum(pLinckaisyacdnum);
    }

    private String linckaisyanm;

    @Column(name=GenBM_LincKaisyacd.LINCKAISYANM)
    public String getLinckaisyanm() {
        return linckaisyanm;
    }

    public void setLinckaisyanm(String pLinckaisyanm) {
        linckaisyanm = pLinckaisyanm;
    }
}