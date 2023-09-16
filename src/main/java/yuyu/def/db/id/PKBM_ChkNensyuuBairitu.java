package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_NensyuuKbn;
import yuyu.def.db.entity.BM_ChkNensyuuBairitu;
import yuyu.def.db.mapping.GenBM_ChkNensyuuBairitu;
import yuyu.def.db.meta.GenQBM_ChkNensyuuBairitu;
import yuyu.def.db.meta.QBM_ChkNensyuuBairitu;

/**
 * 年収倍率チェックマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkNensyuuBairitu}</td><td colspan="3">年収倍率チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getNensyuukbn nensyuukbn}</td><td>年収区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_NensyuuKbn}</td></tr>
 *  <tr><td>gndntgk</td><td>限度日額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gnds</td><td>限度Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_ChkNensyuuBairitu
 * @see     GenBM_ChkNensyuuBairitu
 * @see     QBM_ChkNensyuuBairitu
 * @see     GenQBM_ChkNensyuuBairitu
 */
public class PKBM_ChkNensyuuBairitu extends AbstractExDBPrimaryKey<BM_ChkNensyuuBairitu, PKBM_ChkNensyuuBairitu> {

    private static final long serialVersionUID = 1L;

    public PKBM_ChkNensyuuBairitu() {
    }

    public PKBM_ChkNensyuuBairitu(C_NensyuuKbn pNensyuukbn) {
        nensyuukbn = pNensyuukbn;
    }

    @Transient
    @Override
    public Class<BM_ChkNensyuuBairitu> getEntityClass() {
        return BM_ChkNensyuuBairitu.class;
    }

    private C_NensyuuKbn nensyuukbn;

    @org.hibernate.annotations.Type(type="UserType_C_NensyuuKbn")
    public C_NensyuuKbn getNensyuukbn() {
        return nensyuukbn;
    }

    public void setNensyuukbn(C_NensyuuKbn pNensyuukbn) {
        nensyuukbn = pNensyuukbn;
    }

}