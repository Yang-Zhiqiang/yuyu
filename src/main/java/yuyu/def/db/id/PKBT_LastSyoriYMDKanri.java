package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_LastSyoriymdKanriKbn;
import yuyu.def.db.entity.BT_LastSyoriYMDKanri;
import yuyu.def.db.mapping.GenBT_LastSyoriYMDKanri;
import yuyu.def.db.meta.GenQBT_LastSyoriYMDKanri;
import yuyu.def.db.meta.QBT_LastSyoriYMDKanri;

/**
 * 最終処理日管理テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_LastSyoriYMDKanri}</td><td colspan="3">最終処理日管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getLastsyoriymdkanrikbn lastsyoriymdkanrikbn}</td><td>最終処理日管理区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_LastSyoriymdKanriKbn}</td></tr>
 *  <tr><td>lastsyoriymd</td><td>最終処理日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     BT_LastSyoriYMDKanri
 * @see     GenBT_LastSyoriYMDKanri
 * @see     QBT_LastSyoriYMDKanri
 * @see     GenQBT_LastSyoriYMDKanri
 */
public class PKBT_LastSyoriYMDKanri extends AbstractExDBPrimaryKey<BT_LastSyoriYMDKanri, PKBT_LastSyoriYMDKanri> {

    private static final long serialVersionUID = 1L;

    public PKBT_LastSyoriYMDKanri() {
    }

    public PKBT_LastSyoriYMDKanri(C_LastSyoriymdKanriKbn pLastsyoriymdkanrikbn) {
        lastsyoriymdkanrikbn = pLastsyoriymdkanrikbn;
    }

    @Transient
    @Override
    public Class<BT_LastSyoriYMDKanri> getEntityClass() {
        return BT_LastSyoriYMDKanri.class;
    }

    private C_LastSyoriymdKanriKbn lastsyoriymdkanrikbn;

    @org.hibernate.annotations.Type(type="UserType_C_LastSyoriymdKanriKbn")
    public C_LastSyoriymdKanriKbn getLastsyoriymdkanrikbn() {
        return lastsyoriymdkanrikbn;
    }

    public void setLastsyoriymdkanrikbn(C_LastSyoriymdKanriKbn pLastsyoriymdkanrikbn) {
        lastsyoriymdkanrikbn = pLastsyoriymdkanrikbn;
    }

}