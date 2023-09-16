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
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.db.entity.BM_FBSoukinListKanri;
import yuyu.def.db.id.PKBM_FBSoukinListKanri;
import yuyu.def.db.meta.GenQBM_FBSoukinListKanri;
import yuyu.def.db.meta.QBM_FBSoukinListKanri;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.def.db.type.UserType_C_Tantositucd;

/**
 * ＦＢ送金リスト管理マスタ テーブルのマッピング情報クラスで、 {@link BM_FBSoukinListKanri} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_FBSoukinListKanri}</td><td colspan="3">ＦＢ送金リスト管理マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyoricd syoricd}</td><td>処理コード</td><td align="center">{@link PKBM_FBSoukinListKanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyorisosikicd syorisosikicd}</td><td>処理組織コード</td><td align="center">{@link PKBM_FBSoukinListKanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTantositucd tantositucd}</td><td>担当室コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tantositucd}</td></tr>
 *  <tr><td>{@link #getFbmeisaisyoruicd fbmeisaisyoruicd}</td><td>ＦＢ明細書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>{@link #getGkfbmeisaisyoruicd gkfbmeisaisyoruicd}</td><td>外貨ＦＢ明細書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>{@link #getFbgoukeisyoruicd fbgoukeisyoruicd}</td><td>ＦＢ合計書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>{@link #getGkfbgoukeisyoruicd gkfbgoukeisyoruicd}</td><td>外貨ＦＢ合計書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 * </table>
 * @see     BM_FBSoukinListKanri
 * @see     PKBM_FBSoukinListKanri
 * @see     QBM_FBSoukinListKanri
 * @see     GenQBM_FBSoukinListKanri
 */
@MappedSuperclass
@Table(name=GenBM_FBSoukinListKanri.TABLE_NAME)
@IdClass(value=PKBM_FBSoukinListKanri.class)
@TypeDefs({
    @TypeDef(name="UserType_C_SyoruiCdKbn", typeClass=UserType_C_SyoruiCdKbn.class),
    @TypeDef(name="UserType_C_Tantositucd", typeClass=UserType_C_Tantositucd.class)
})
public abstract class GenBM_FBSoukinListKanri extends AbstractExDBEntity<BM_FBSoukinListKanri, PKBM_FBSoukinListKanri> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_FBSoukinListKanri";
    public static final String SYORICD                  = "syoricd";
    public static final String SYORISOSIKICD            = "syorisosikicd";
    public static final String TANTOSITUCD              = "tantositucd";
    public static final String FBMEISAISYORUICD         = "fbmeisaisyoruicd";
    public static final String GKFBMEISAISYORUICD       = "gkfbmeisaisyoruicd";
    public static final String FBGOUKEISYORUICD         = "fbgoukeisyoruicd";
    public static final String GKFBGOUKEISYORUICD       = "gkfbgoukeisyoruicd";

    private final PKBM_FBSoukinListKanri primaryKey;

    public GenBM_FBSoukinListKanri() {
        primaryKey = new PKBM_FBSoukinListKanri();
    }

    public GenBM_FBSoukinListKanri(String pSyoricd, String pSyorisosikicd) {
        primaryKey = new PKBM_FBSoukinListKanri(pSyoricd, pSyorisosikicd);
    }

    @Transient
    @Override
    public PKBM_FBSoukinListKanri getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_FBSoukinListKanri> getMetaClass() {
        return QBM_FBSoukinListKanri.class;
    }

    @Id
    @Column(name=GenBM_FBSoukinListKanri.SYORICD)
    public String getSyoricd() {
        return getPrimaryKey().getSyoricd();
    }

    public void setSyoricd(String pSyoricd) {
        getPrimaryKey().setSyoricd(pSyoricd);
    }

    @Id
    @Column(name=GenBM_FBSoukinListKanri.SYORISOSIKICD)
    public String getSyorisosikicd() {
        return getPrimaryKey().getSyorisosikicd();
    }

    public void setSyorisosikicd(String pSyorisosikicd) {
        getPrimaryKey().setSyorisosikicd(pSyorisosikicd);
    }

    private C_Tantositucd tantositucd;

    @Type(type="UserType_C_Tantositucd")
    @Column(name=GenBM_FBSoukinListKanri.TANTOSITUCD)
    public C_Tantositucd getTantositucd() {
        return tantositucd;
    }

    public void setTantositucd(C_Tantositucd pTantositucd) {
        tantositucd = pTantositucd;
    }

    private C_SyoruiCdKbn fbmeisaisyoruicd;

    @Type(type="UserType_C_SyoruiCdKbn")
    @Column(name=GenBM_FBSoukinListKanri.FBMEISAISYORUICD)
    public C_SyoruiCdKbn getFbmeisaisyoruicd() {
        return fbmeisaisyoruicd;
    }

    public void setFbmeisaisyoruicd(C_SyoruiCdKbn pFbmeisaisyoruicd) {
        fbmeisaisyoruicd = pFbmeisaisyoruicd;
    }

    private C_SyoruiCdKbn gkfbmeisaisyoruicd;

    @Type(type="UserType_C_SyoruiCdKbn")
    @Column(name=GenBM_FBSoukinListKanri.GKFBMEISAISYORUICD)
    public C_SyoruiCdKbn getGkfbmeisaisyoruicd() {
        return gkfbmeisaisyoruicd;
    }

    public void setGkfbmeisaisyoruicd(C_SyoruiCdKbn pGkfbmeisaisyoruicd) {
        gkfbmeisaisyoruicd = pGkfbmeisaisyoruicd;
    }

    private C_SyoruiCdKbn fbgoukeisyoruicd;

    @Type(type="UserType_C_SyoruiCdKbn")
    @Column(name=GenBM_FBSoukinListKanri.FBGOUKEISYORUICD)
    public C_SyoruiCdKbn getFbgoukeisyoruicd() {
        return fbgoukeisyoruicd;
    }

    public void setFbgoukeisyoruicd(C_SyoruiCdKbn pFbgoukeisyoruicd) {
        fbgoukeisyoruicd = pFbgoukeisyoruicd;
    }

    private C_SyoruiCdKbn gkfbgoukeisyoruicd;

    @Type(type="UserType_C_SyoruiCdKbn")
    @Column(name=GenBM_FBSoukinListKanri.GKFBGOUKEISYORUICD)
    public C_SyoruiCdKbn getGkfbgoukeisyoruicd() {
        return gkfbgoukeisyoruicd;
    }

    public void setGkfbgoukeisyoruicd(C_SyoruiCdKbn pGkfbgoukeisyoruicd) {
        gkfbgoukeisyoruicd = pGkfbgoukeisyoruicd;
    }
}