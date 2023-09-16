package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_LastSyoriymdKanriKbn;
import yuyu.def.db.entity.BT_LastSyoriYMDKanri;
import yuyu.def.db.id.PKBT_LastSyoriYMDKanri;
import yuyu.def.db.meta.GenQBT_LastSyoriYMDKanri;
import yuyu.def.db.meta.QBT_LastSyoriYMDKanri;
import yuyu.def.db.type.UserType_C_LastSyoriymdKanriKbn;

/**
 * 最終処理日管理テーブル テーブルのマッピング情報クラスで、 {@link BT_LastSyoriYMDKanri} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_LastSyoriYMDKanri}</td><td colspan="3">最終処理日管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getLastsyoriymdkanrikbn lastsyoriymdkanrikbn}</td><td>最終処理日管理区分</td><td align="center">{@link PKBT_LastSyoriYMDKanri ○}</td><td align="center">V</td><td>{@link C_LastSyoriymdKanriKbn}</td></tr>
 *  <tr><td>{@link #getLastsyoriymd lastsyoriymd}</td><td>最終処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     BT_LastSyoriYMDKanri
 * @see     PKBT_LastSyoriYMDKanri
 * @see     QBT_LastSyoriYMDKanri
 * @see     GenQBT_LastSyoriYMDKanri
 */
@MappedSuperclass
@Table(name=GenBT_LastSyoriYMDKanri.TABLE_NAME)
@IdClass(value=PKBT_LastSyoriYMDKanri.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_LastSyoriymdKanriKbn", typeClass=UserType_C_LastSyoriymdKanriKbn.class)
})
public abstract class GenBT_LastSyoriYMDKanri extends AbstractExDBEntity<BT_LastSyoriYMDKanri, PKBT_LastSyoriYMDKanri> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_LastSyoriYMDKanri";
    public static final String LASTSYORIYMDKANRIKBN     = "lastsyoriymdkanrikbn";
    public static final String LASTSYORIYMD             = "lastsyoriymd";

    private final PKBT_LastSyoriYMDKanri primaryKey;

    public GenBT_LastSyoriYMDKanri() {
        primaryKey = new PKBT_LastSyoriYMDKanri();
    }

    public GenBT_LastSyoriYMDKanri(C_LastSyoriymdKanriKbn pLastsyoriymdkanrikbn) {
        primaryKey = new PKBT_LastSyoriYMDKanri(pLastsyoriymdkanrikbn);
    }

    @Transient
    @Override
    public PKBT_LastSyoriYMDKanri getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_LastSyoriYMDKanri> getMetaClass() {
        return QBT_LastSyoriYMDKanri.class;
    }

    @Id
    @Type(type="UserType_C_LastSyoriymdKanriKbn")
    @Column(name=GenBT_LastSyoriYMDKanri.LASTSYORIYMDKANRIKBN)
    public C_LastSyoriymdKanriKbn getLastsyoriymdkanrikbn() {
        return getPrimaryKey().getLastsyoriymdkanrikbn();
    }

    public void setLastsyoriymdkanrikbn(C_LastSyoriymdKanriKbn pLastsyoriymdkanrikbn) {
        getPrimaryKey().setLastsyoriymdkanrikbn(pLastsyoriymdkanrikbn);
    }

    private BizDate lastsyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_LastSyoriYMDKanri.LASTSYORIYMD)
    public BizDate getLastsyoriymd() {
        return lastsyoriymd;
    }

    @Trim("both")
    public void setLastsyoriymd(BizDate pLastsyoriymd) {
        lastsyoriymd = pLastsyoriymd;
    }
}
