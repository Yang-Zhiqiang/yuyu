package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.db.entity.BM_Sisuu;
import yuyu.def.db.mapping.GenBM_Sisuu;
import yuyu.def.db.meta.GenQBM_Sisuu;
import yuyu.def.db.meta.QBM_Sisuu;

/**
 * 指数マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_Sisuu}</td><td colspan="3">指数マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSisuukbn sisuukbn}</td><td>指数区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_Sisuukbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSisuukouhyouymd sisuukouhyouymd}</td><td>指数公表日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>sisuu</td><td>指数</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisuucalckijyunymd</td><td>指数計算基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     BM_Sisuu
 * @see     GenBM_Sisuu
 * @see     QBM_Sisuu
 * @see     GenQBM_Sisuu
 */
public class PKBM_Sisuu extends AbstractExDBPrimaryKey<BM_Sisuu, PKBM_Sisuu> {

    private static final long serialVersionUID = 1L;

    public PKBM_Sisuu() {
    }

    public PKBM_Sisuu(C_Sisuukbn pSisuukbn, BizDate pSisuukouhyouymd) {
        sisuukbn = pSisuukbn;
        sisuukouhyouymd = pSisuukouhyouymd;
    }

    @Transient
    @Override
    public Class<BM_Sisuu> getEntityClass() {
        return BM_Sisuu.class;
    }

    private C_Sisuukbn sisuukbn;

    @org.hibernate.annotations.Type(type="UserType_C_Sisuukbn")
    public C_Sisuukbn getSisuukbn() {
        return sisuukbn;
    }

    public void setSisuukbn(C_Sisuukbn pSisuukbn) {
        sisuukbn = pSisuukbn;
    }
    private BizDate sisuukouhyouymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSisuukouhyouymd() {
        return sisuukouhyouymd;
    }

    public void setSisuukouhyouymd(BizDate pSisuukouhyouymd) {
        sisuukouhyouymd = pSisuukouhyouymd;
    }

}