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
import yuyu.def.classification.C_TyhyrenrakusikibetuKbn;
import yuyu.def.db.entity.BM_Tyouhyourenrakusaki;
import yuyu.def.db.id.PKBM_Tyouhyourenrakusaki;
import yuyu.def.db.meta.GenQBM_Tyouhyourenrakusaki;
import yuyu.def.db.meta.QBM_Tyouhyourenrakusaki;
import yuyu.def.db.type.UserType_C_TyhyrenrakusikibetuKbn;

/**
 * 帳票連絡先マスタ テーブルのマッピング情報クラスで、 {@link BM_Tyouhyourenrakusaki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_Tyouhyourenrakusaki}</td><td colspan="3">帳票連絡先マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getTyhyrenrakusikibetukbn tyhyrenrakusikibetukbn}</td><td>帳票連絡先識別区分</td><td align="center">{@link PKBM_Tyouhyourenrakusaki ○}</td><td align="center">V</td><td>{@link C_TyhyrenrakusikibetuKbn}</td></tr>
 *  <tr><td>{@link #getCctelno cctelno}</td><td>コールセンター電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCcimagepath ccimagepath}</td><td>コールセンター画像パス</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSapodetelno sapodetelno}</td><td>サポートデスク電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSapodeimagepath sapodeimagepath}</td><td>サポートデスク画像パス</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSapodefaxno sapodefaxno}</td><td>サポートデスクＦＡＸ番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_Tyouhyourenrakusaki
 * @see     PKBM_Tyouhyourenrakusaki
 * @see     QBM_Tyouhyourenrakusaki
 * @see     GenQBM_Tyouhyourenrakusaki
 */
@MappedSuperclass
@Table(name=GenBM_Tyouhyourenrakusaki.TABLE_NAME)
@IdClass(value=PKBM_Tyouhyourenrakusaki.class)
@TypeDefs({
    @TypeDef(name="UserType_C_TyhyrenrakusikibetuKbn", typeClass=UserType_C_TyhyrenrakusikibetuKbn.class)
})
public abstract class GenBM_Tyouhyourenrakusaki extends AbstractExDBEntity<BM_Tyouhyourenrakusaki, PKBM_Tyouhyourenrakusaki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_Tyouhyourenrakusaki";
    public static final String TYHYRENRAKUSIKIBETUKBN   = "tyhyrenrakusikibetukbn";
    public static final String CCTELNO                  = "cctelno";
    public static final String CCIMAGEPATH              = "ccimagepath";
    public static final String SAPODETELNO              = "sapodetelno";
    public static final String SAPODEIMAGEPATH          = "sapodeimagepath";
    public static final String SAPODEFAXNO              = "sapodefaxno";

    private final PKBM_Tyouhyourenrakusaki primaryKey;

    public GenBM_Tyouhyourenrakusaki() {
        primaryKey = new PKBM_Tyouhyourenrakusaki();
    }

    public GenBM_Tyouhyourenrakusaki(C_TyhyrenrakusikibetuKbn pTyhyrenrakusikibetukbn) {
        primaryKey = new PKBM_Tyouhyourenrakusaki(pTyhyrenrakusikibetukbn);
    }

    @Transient
    @Override
    public PKBM_Tyouhyourenrakusaki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_Tyouhyourenrakusaki> getMetaClass() {
        return QBM_Tyouhyourenrakusaki.class;
    }

    @Id
    @Type(type="UserType_C_TyhyrenrakusikibetuKbn")
    @Column(name=GenBM_Tyouhyourenrakusaki.TYHYRENRAKUSIKIBETUKBN)
    public C_TyhyrenrakusikibetuKbn getTyhyrenrakusikibetukbn() {
        return getPrimaryKey().getTyhyrenrakusikibetukbn();
    }

    public void setTyhyrenrakusikibetukbn(C_TyhyrenrakusikibetuKbn pTyhyrenrakusikibetukbn) {
        getPrimaryKey().setTyhyrenrakusikibetukbn(pTyhyrenrakusikibetukbn);
    }

    private String cctelno;

    @Column(name=GenBM_Tyouhyourenrakusaki.CCTELNO)
    public String getCctelno() {
        return cctelno;
    }

    public void setCctelno(String pCctelno) {
        cctelno = pCctelno;
    }

    private String ccimagepath;

    @Column(name=GenBM_Tyouhyourenrakusaki.CCIMAGEPATH)
    public String getCcimagepath() {
        return ccimagepath;
    }

    public void setCcimagepath(String pCcimagepath) {
        ccimagepath = pCcimagepath;
    }

    private String sapodetelno;

    @Column(name=GenBM_Tyouhyourenrakusaki.SAPODETELNO)
    public String getSapodetelno() {
        return sapodetelno;
    }

    public void setSapodetelno(String pSapodetelno) {
        sapodetelno = pSapodetelno;
    }

    private String sapodeimagepath;

    @Column(name=GenBM_Tyouhyourenrakusaki.SAPODEIMAGEPATH)
    public String getSapodeimagepath() {
        return sapodeimagepath;
    }

    public void setSapodeimagepath(String pSapodeimagepath) {
        sapodeimagepath = pSapodeimagepath;
    }

    private String sapodefaxno;

    @Column(name=GenBM_Tyouhyourenrakusaki.SAPODEFAXNO)
    public String getSapodefaxno() {
        return sapodefaxno;
    }

    public void setSapodefaxno(String pSapodefaxno) {
        sapodefaxno = pSapodefaxno;
    }
}
