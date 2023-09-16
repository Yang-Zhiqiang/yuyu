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
import yuyu.def.classification.C_SikinidoukouzaKbn;
import yuyu.def.classification.C_SikinidoulistKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SikinIdouListCsvFLayout;
import yuyu.def.db.id.PKBM_SikinIdouListCsvFLayout;
import yuyu.def.db.meta.GenQBM_SikinIdouListCsvFLayout;
import yuyu.def.db.meta.QBM_SikinIdouListCsvFLayout;
import yuyu.def.db.type.UserType_C_SikinidoukouzaKbn;
import yuyu.def.db.type.UserType_C_SikinidoulistKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 資金移動リストＣＳＶファイルレイアウトマスタ テーブルのマッピング情報クラスで、 {@link BM_SikinIdouListCsvFLayout} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_SikinIdouListCsvFLayout}</td><td colspan="3">資金移動リストＣＳＶファイルレイアウトマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getHyoujijyun hyoujijyun}</td><td>表示順</td><td align="center">{@link PKBM_SikinIdouListCsvFLayout ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSikinidoulistkbn sikinidoulistkbn}</td><td>資金移動リスト区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SikinidoulistKbn}</td></tr>
 *  <tr><td>{@link #getSyukkinkouzatuukasyu syukkinkouzatuukasyu}</td><td>出金口座通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSyukkinkouzano syukkinkouzano}</td><td>出金口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukkinkouzakbn syukkinkouzakbn}</td><td>出金口座区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SikinidoukouzaKbn}</td></tr>
 *  <tr><td>{@link #getNyuukinkouzatuukasyu nyuukinkouzatuukasyu}</td><td>入金口座通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getNyuukinkouzano nyuukinkouzano}</td><td>入金口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNyuukinkouzakbn nyuukinkouzakbn}</td><td>入金口座区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SikinidoukouzaKbn}</td></tr>
 * </table>
 * @see     BM_SikinIdouListCsvFLayout
 * @see     PKBM_SikinIdouListCsvFLayout
 * @see     QBM_SikinIdouListCsvFLayout
 * @see     GenQBM_SikinIdouListCsvFLayout
 */
@MappedSuperclass
@Table(name=GenBM_SikinIdouListCsvFLayout.TABLE_NAME)
@IdClass(value=PKBM_SikinIdouListCsvFLayout.class)
@TypeDefs({
    @TypeDef(name="UserType_C_SikinidoukouzaKbn", typeClass=UserType_C_SikinidoukouzaKbn.class),
    @TypeDef(name="UserType_C_SikinidoulistKbn", typeClass=UserType_C_SikinidoulistKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenBM_SikinIdouListCsvFLayout extends AbstractExDBEntity<BM_SikinIdouListCsvFLayout, PKBM_SikinIdouListCsvFLayout> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_SikinIdouListCsvFLayout";
    public static final String HYOUJIJYUN               = "hyoujijyun";
    public static final String SIKINIDOULISTKBN         = "sikinidoulistkbn";
    public static final String SYUKKINKOUZATUUKASYU     = "syukkinkouzatuukasyu";
    public static final String SYUKKINKOUZANO           = "syukkinkouzano";
    public static final String SYUKKINKOUZAKBN          = "syukkinkouzakbn";
    public static final String NYUUKINKOUZATUUKASYU     = "nyuukinkouzatuukasyu";
    public static final String NYUUKINKOUZANO           = "nyuukinkouzano";
    public static final String NYUUKINKOUZAKBN          = "nyuukinkouzakbn";

    private final PKBM_SikinIdouListCsvFLayout primaryKey;

    public GenBM_SikinIdouListCsvFLayout() {
        primaryKey = new PKBM_SikinIdouListCsvFLayout();
    }

    public GenBM_SikinIdouListCsvFLayout(Integer pHyoujijyun) {
        primaryKey = new PKBM_SikinIdouListCsvFLayout(pHyoujijyun);
    }

    @Transient
    @Override
    public PKBM_SikinIdouListCsvFLayout getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_SikinIdouListCsvFLayout> getMetaClass() {
        return QBM_SikinIdouListCsvFLayout.class;
    }

    @Id
    @Column(name=GenBM_SikinIdouListCsvFLayout.HYOUJIJYUN)
    public Integer getHyoujijyun() {
        return getPrimaryKey().getHyoujijyun();
    }

    public void setHyoujijyun(Integer pHyoujijyun) {
        getPrimaryKey().setHyoujijyun(pHyoujijyun);
    }

    private C_SikinidoulistKbn sikinidoulistkbn;

    @Type(type="UserType_C_SikinidoulistKbn")
    @Column(name=GenBM_SikinIdouListCsvFLayout.SIKINIDOULISTKBN)
    public C_SikinidoulistKbn getSikinidoulistkbn() {
        return sikinidoulistkbn;
    }

    public void setSikinidoulistkbn(C_SikinidoulistKbn pSikinidoulistkbn) {
        sikinidoulistkbn = pSikinidoulistkbn;
    }

    private C_Tuukasyu syukkinkouzatuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBM_SikinIdouListCsvFLayout.SYUKKINKOUZATUUKASYU)
    public C_Tuukasyu getSyukkinkouzatuukasyu() {
        return syukkinkouzatuukasyu;
    }

    public void setSyukkinkouzatuukasyu(C_Tuukasyu pSyukkinkouzatuukasyu) {
        syukkinkouzatuukasyu = pSyukkinkouzatuukasyu;
    }

    private String syukkinkouzano;

    @Column(name=GenBM_SikinIdouListCsvFLayout.SYUKKINKOUZANO)
    public String getSyukkinkouzano() {
        return syukkinkouzano;
    }

    public void setSyukkinkouzano(String pSyukkinkouzano) {
        syukkinkouzano = pSyukkinkouzano;
    }

    private C_SikinidoukouzaKbn syukkinkouzakbn;

    @Type(type="UserType_C_SikinidoukouzaKbn")
    @Column(name=GenBM_SikinIdouListCsvFLayout.SYUKKINKOUZAKBN)
    public C_SikinidoukouzaKbn getSyukkinkouzakbn() {
        return syukkinkouzakbn;
    }

    public void setSyukkinkouzakbn(C_SikinidoukouzaKbn pSyukkinkouzakbn) {
        syukkinkouzakbn = pSyukkinkouzakbn;
    }

    private C_Tuukasyu nyuukinkouzatuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBM_SikinIdouListCsvFLayout.NYUUKINKOUZATUUKASYU)
    public C_Tuukasyu getNyuukinkouzatuukasyu() {
        return nyuukinkouzatuukasyu;
    }

    public void setNyuukinkouzatuukasyu(C_Tuukasyu pNyuukinkouzatuukasyu) {
        nyuukinkouzatuukasyu = pNyuukinkouzatuukasyu;
    }

    private String nyuukinkouzano;

    @Column(name=GenBM_SikinIdouListCsvFLayout.NYUUKINKOUZANO)
    public String getNyuukinkouzano() {
        return nyuukinkouzano;
    }

    public void setNyuukinkouzano(String pNyuukinkouzano) {
        nyuukinkouzano = pNyuukinkouzano;
    }

    private C_SikinidoukouzaKbn nyuukinkouzakbn;

    @Type(type="UserType_C_SikinidoukouzaKbn")
    @Column(name=GenBM_SikinIdouListCsvFLayout.NYUUKINKOUZAKBN)
    public C_SikinidoukouzaKbn getNyuukinkouzakbn() {
        return nyuukinkouzakbn;
    }

    public void setNyuukinkouzakbn(C_SikinidoukouzaKbn pNyuukinkouzakbn) {
        nyuukinkouzakbn = pNyuukinkouzakbn;
    }
}