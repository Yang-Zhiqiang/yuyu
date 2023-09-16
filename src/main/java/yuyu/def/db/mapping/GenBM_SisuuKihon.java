package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.db.entity.BM_SisuuKihon;
import yuyu.def.db.id.PKBM_SisuuKihon;
import yuyu.def.db.meta.GenQBM_SisuuKihon;
import yuyu.def.db.meta.QBM_SisuuKihon;
import yuyu.def.db.type.UserType_C_Sisuukbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 指数基本マスタ テーブルのマッピング情報クラスで、 {@link BM_SisuuKihon} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_SisuuKihon}</td><td colspan="3">指数基本マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSisuukbn sisuukbn}</td><td>指数区分</td><td align="center">{@link PKBM_SisuuKihon ○}</td><td align="center">V</td><td>{@link C_Sisuukbn}</td></tr>
 *  <tr><td>{@link #getSisuunm sisuunm}</td><td>指数名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_SisuuKihon
 * @see     PKBM_SisuuKihon
 * @see     QBM_SisuuKihon
 * @see     GenQBM_SisuuKihon
 */
@MappedSuperclass
@Table(name=GenBM_SisuuKihon.TABLE_NAME)
@IdClass(value=PKBM_SisuuKihon.class)
@TypeDefs({
    @TypeDef(name="UserType_C_Sisuukbn", typeClass=UserType_C_Sisuukbn.class)
})
public abstract class GenBM_SisuuKihon extends AbstractExDBEntity<BM_SisuuKihon, PKBM_SisuuKihon> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_SisuuKihon";
    public static final String SISUUKBN                 = "sisuukbn";
    public static final String SISUUNM                  = "sisuunm";

    private final PKBM_SisuuKihon primaryKey;

    public GenBM_SisuuKihon() {
        primaryKey = new PKBM_SisuuKihon();
    }

    public GenBM_SisuuKihon(C_Sisuukbn pSisuukbn) {
        primaryKey = new PKBM_SisuuKihon(pSisuukbn);
    }

    @Transient
    @Override
    public PKBM_SisuuKihon getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_SisuuKihon> getMetaClass() {
        return QBM_SisuuKihon.class;
    }

    @Id
    @Type(type="UserType_C_Sisuukbn")
    @Column(name=GenBM_SisuuKihon.SISUUKBN)
    public C_Sisuukbn getSisuukbn() {
        return getPrimaryKey().getSisuukbn();
    }

    public void setSisuukbn(C_Sisuukbn pSisuukbn) {
        getPrimaryKey().setSisuukbn(pSisuukbn);
    }

    private String sisuunm;

    @Column(name=GenBM_SisuuKihon.SISUUNM)
    @MaxLength(max=50)
    @MultiByteStrings
    @InvalidCharacter
    public String getSisuunm() {
        return sisuunm;
    }

    @Trim("both")
    public void setSisuunm(String pSisuunm) {
        sisuunm = pSisuunm;
    }
}