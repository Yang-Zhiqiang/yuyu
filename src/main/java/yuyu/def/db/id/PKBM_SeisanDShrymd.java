package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BM_SeisanDShrymd;
import yuyu.def.db.mapping.GenBM_SeisanDShrymd;
import yuyu.def.db.meta.GenQBM_SeisanDShrymd;
import yuyu.def.db.meta.QBM_SeisanDShrymd;

/**
 * 精算Ｄ支払年月日管理マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_SeisanDShrymd}</td><td colspan="3">精算Ｄ支払年月日管理マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyorinendo syorinendo}</td><td>処理年度</td><td align="center">○</td><td align="center">V</td><td>BizDateY</td></tr>
 *  <tr><td>seisandshrymd</td><td>精算Ｄ支払年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     BM_SeisanDShrymd
 * @see     GenBM_SeisanDShrymd
 * @see     QBM_SeisanDShrymd
 * @see     GenQBM_SeisanDShrymd
 */
public class PKBM_SeisanDShrymd extends AbstractExDBPrimaryKey<BM_SeisanDShrymd, PKBM_SeisanDShrymd> {

    private static final long serialVersionUID = 1L;

    public PKBM_SeisanDShrymd() {
    }

    public PKBM_SeisanDShrymd(BizDateY pSyorinendo) {
        syorinendo = pSyorinendo;
    }

    @Transient
    @Override
    public Class<BM_SeisanDShrymd> getEntityClass() {
        return BM_SeisanDShrymd.class;
    }

    private BizDateY syorinendo;

    @org.hibernate.annotations.Type(type="BizDateYType")
    public BizDateY getSyorinendo() {
        return syorinendo;
    }

    public void setSyorinendo(BizDateY pSyorinendo) {
        syorinendo = pSyorinendo;
    }

}