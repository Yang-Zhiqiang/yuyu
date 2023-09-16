package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.db.entity.BM_SisuuKihon;
import yuyu.def.db.mapping.GenBM_SisuuKihon;
import yuyu.def.db.meta.GenQBM_SisuuKihon;
import yuyu.def.db.meta.QBM_SisuuKihon;

/**
 * 指数基本マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_SisuuKihon}</td><td colspan="3">指数基本マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSisuukbn sisuukbn}</td><td>指数区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_Sisuukbn}</td></tr>
 *  <tr><td>sisuunm</td><td>指数名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_SisuuKihon
 * @see     GenBM_SisuuKihon
 * @see     QBM_SisuuKihon
 * @see     GenQBM_SisuuKihon
 */
public class PKBM_SisuuKihon extends AbstractExDBPrimaryKey<BM_SisuuKihon, PKBM_SisuuKihon> {

    private static final long serialVersionUID = 1L;

    public PKBM_SisuuKihon() {
    }

    public PKBM_SisuuKihon(C_Sisuukbn pSisuukbn) {
        sisuukbn = pSisuukbn;
    }

    @Transient
    @Override
    public Class<BM_SisuuKihon> getEntityClass() {
        return BM_SisuuKihon.class;
    }

    private C_Sisuukbn sisuukbn;

    @org.hibernate.annotations.Type(type="UserType_C_Sisuukbn")
    public C_Sisuukbn getSisuukbn() {
        return sisuukbn;
    }

    public void setSisuukbn(C_Sisuukbn pSisuukbn) {
        sisuukbn = pSisuukbn;
    }

}