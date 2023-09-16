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
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.db.id.PKBM_TantouCd;
import yuyu.def.db.meta.GenQBM_TantouCd;
import yuyu.def.db.meta.QBM_TantouCd;
import yuyu.def.db.type.UserType_C_TantouCdKbn;

/**
 * 担当コードマスタ テーブルのマッピング情報クラスで、 {@link BM_TantouCd} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_TantouCd}</td><td colspan="3">担当コードマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getTantocd tantocd}</td><td>担当コード</td><td align="center">{@link PKBM_TantouCd ○}</td><td align="center">V</td><td>{@link C_TantouCdKbn}</td></tr>
 *  <tr><td>{@link #getBusitucd busitucd}</td><td>部・室コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTantounm tantounm}</td><td>担当名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBusitunm busitunm}</td><td>部・室名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_TantouCd
 * @see     PKBM_TantouCd
 * @see     QBM_TantouCd
 * @see     GenQBM_TantouCd
 */
@MappedSuperclass
@Table(name=GenBM_TantouCd.TABLE_NAME)
@IdClass(value=PKBM_TantouCd.class)
@TypeDefs({
    @TypeDef(name="UserType_C_TantouCdKbn", typeClass=UserType_C_TantouCdKbn.class)
})
public abstract class GenBM_TantouCd extends AbstractExDBEntity<BM_TantouCd, PKBM_TantouCd> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_TantouCd";
    public static final String TANTOCD                  = "tantocd";
    public static final String BUSITUCD                 = "busitucd";
    public static final String TANTOUNM                 = "tantounm";
    public static final String BUSITUNM                 = "busitunm";

    private final PKBM_TantouCd primaryKey;

    public GenBM_TantouCd() {
        primaryKey = new PKBM_TantouCd();
    }

    public GenBM_TantouCd(C_TantouCdKbn pTantocd) {
        primaryKey = new PKBM_TantouCd(pTantocd);
    }

    @Transient
    @Override
    public PKBM_TantouCd getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_TantouCd> getMetaClass() {
        return QBM_TantouCd.class;
    }

    @Id
    @Type(type="UserType_C_TantouCdKbn")
    @Column(name=GenBM_TantouCd.TANTOCD)
    public C_TantouCdKbn getTantocd() {
        return getPrimaryKey().getTantocd();
    }

    public void setTantocd(C_TantouCdKbn pTantocd) {
        getPrimaryKey().setTantocd(pTantocd);
    }

    private String busitucd;

    @Column(name=GenBM_TantouCd.BUSITUCD)
    public String getBusitucd() {
        return busitucd;
    }

    public void setBusitucd(String pBusitucd) {
        busitucd = pBusitucd;
    }

    private String tantounm;

    @Column(name=GenBM_TantouCd.TANTOUNM)
    public String getTantounm() {
        return tantounm;
    }

    public void setTantounm(String pTantounm) {
        tantounm = pTantounm;
    }

    private String busitunm;

    @Column(name=GenBM_TantouCd.BUSITUNM)
    public String getBusitunm() {
        return busitunm;
    }

    public void setBusitunm(String pBusitunm) {
        busitunm = pBusitunm;
    }
}
