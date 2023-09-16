package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_TyhyrenrakusikibetuKbn;
import yuyu.def.db.entity.BM_Tyouhyourenrakusaki;
import yuyu.def.db.mapping.GenBM_Tyouhyourenrakusaki;
import yuyu.def.db.meta.GenQBM_Tyouhyourenrakusaki;
import yuyu.def.db.meta.QBM_Tyouhyourenrakusaki;

/**
 * 帳票連絡先マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_Tyouhyourenrakusaki}</td><td colspan="3">帳票連絡先マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getTyhyrenrakusikibetukbn tyhyrenrakusikibetukbn}</td><td>帳票連絡先識別区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_TyhyrenrakusikibetuKbn}</td></tr>
 *  <tr><td>cctelno</td><td>コールセンター電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ccimagepath</td><td>コールセンター画像パス</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sapodetelno</td><td>サポートデスク電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sapodeimagepath</td><td>サポートデスク画像パス</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sapodefaxno</td><td>サポートデスクＦＡＸ番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_Tyouhyourenrakusaki
 * @see     GenBM_Tyouhyourenrakusaki
 * @see     QBM_Tyouhyourenrakusaki
 * @see     GenQBM_Tyouhyourenrakusaki
 */
public class PKBM_Tyouhyourenrakusaki extends AbstractExDBPrimaryKey<BM_Tyouhyourenrakusaki, PKBM_Tyouhyourenrakusaki> {

    private static final long serialVersionUID = 1L;

    public PKBM_Tyouhyourenrakusaki() {
    }

    public PKBM_Tyouhyourenrakusaki(C_TyhyrenrakusikibetuKbn pTyhyrenrakusikibetukbn) {
        tyhyrenrakusikibetukbn = pTyhyrenrakusikibetukbn;
    }

    @Transient
    @Override
    public Class<BM_Tyouhyourenrakusaki> getEntityClass() {
        return BM_Tyouhyourenrakusaki.class;
    }

    private C_TyhyrenrakusikibetuKbn tyhyrenrakusikibetukbn;

    @org.hibernate.annotations.Type(type="UserType_C_TyhyrenrakusikibetuKbn")
    public C_TyhyrenrakusikibetuKbn getTyhyrenrakusikibetukbn() {
        return tyhyrenrakusikibetukbn;
    }

    public void setTyhyrenrakusikibetukbn(C_TyhyrenrakusikibetuKbn pTyhyrenrakusikibetukbn) {
        tyhyrenrakusikibetukbn = pTyhyrenrakusikibetukbn;
    }

}