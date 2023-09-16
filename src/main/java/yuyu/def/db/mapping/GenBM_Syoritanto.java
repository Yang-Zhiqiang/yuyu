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
import yuyu.def.db.entity.BM_Syoritanto;
import yuyu.def.db.id.PKBM_Syoritanto;
import yuyu.def.db.meta.GenQBM_Syoritanto;
import yuyu.def.db.meta.QBM_Syoritanto;
import yuyu.def.db.type.UserType_C_TantouCdKbn;

/**
 * 処理担当マスタ テーブルのマッピング情報クラスで、 {@link BM_Syoritanto} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_Syoritanto}</td><td colspan="3">処理担当マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyoricd syoricd}</td><td>処理コード</td><td align="center">{@link PKBM_Syoritanto ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTantocd tantocd}</td><td>担当コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TantouCdKbn}</td></tr>
 * </table>
 * @see     BM_Syoritanto
 * @see     PKBM_Syoritanto
 * @see     QBM_Syoritanto
 * @see     GenQBM_Syoritanto
 */
@MappedSuperclass
@Table(name=GenBM_Syoritanto.TABLE_NAME)
@IdClass(value=PKBM_Syoritanto.class)
@TypeDefs({
    @TypeDef(name="UserType_C_TantouCdKbn", typeClass=UserType_C_TantouCdKbn.class)
})
public abstract class GenBM_Syoritanto extends AbstractExDBEntity<BM_Syoritanto, PKBM_Syoritanto> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_Syoritanto";
    public static final String SYORICD                  = "syoricd";
    public static final String TANTOCD                  = "tantocd";

    private final PKBM_Syoritanto primaryKey;

    public GenBM_Syoritanto() {
        primaryKey = new PKBM_Syoritanto();
    }

    public GenBM_Syoritanto(String pSyoricd) {
        primaryKey = new PKBM_Syoritanto(pSyoricd);
    }

    @Transient
    @Override
    public PKBM_Syoritanto getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_Syoritanto> getMetaClass() {
        return QBM_Syoritanto.class;
    }

    @Id
    @Column(name=GenBM_Syoritanto.SYORICD)
    public String getSyoricd() {
        return getPrimaryKey().getSyoricd();
    }

    public void setSyoricd(String pSyoricd) {
        getPrimaryKey().setSyoricd(pSyoricd);
    }

    private C_TantouCdKbn tantocd;

    @Type(type="UserType_C_TantouCdKbn")
    @Column(name=GenBM_Syoritanto.TANTOCD)
    public C_TantouCdKbn getTantocd() {
        return tantocd;
    }

    public void setTantocd(C_TantouCdKbn pTantocd) {
        tantocd = pTantocd;
    }
}
