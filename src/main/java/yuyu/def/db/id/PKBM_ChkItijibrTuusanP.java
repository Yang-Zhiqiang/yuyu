package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BM_ChkItijibrTuusanP;
import yuyu.def.db.mapping.GenBM_ChkItijibrTuusanP;
import yuyu.def.db.meta.GenQBM_ChkItijibrTuusanP;
import yuyu.def.db.meta.QBM_ChkItijibrTuusanP;

/**
 * 一時払通算限度Ｐチェックマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkItijibrTuusanP}</td><td colspan="3">一時払通算限度Ｐチェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getHhknfromnen hhknfromnen}</td><td>被保険者年齢自</td><td align="center">○</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHhkntonen hhkntonen}</td><td>被保険者年齢至</td><td align="center">○</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>gnditijibaraip</td><td>限度一時払Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_ChkItijibrTuusanP
 * @see     GenBM_ChkItijibrTuusanP
 * @see     QBM_ChkItijibrTuusanP
 * @see     GenQBM_ChkItijibrTuusanP
 */
public class PKBM_ChkItijibrTuusanP extends AbstractExDBPrimaryKey<BM_ChkItijibrTuusanP, PKBM_ChkItijibrTuusanP> {

    private static final long serialVersionUID = 1L;

    public PKBM_ChkItijibrTuusanP() {
    }

    public PKBM_ChkItijibrTuusanP(BizNumber pHhknfromnen, BizNumber pHhkntonen) {
        hhknfromnen = pHhknfromnen;
        hhkntonen = pHhkntonen;
    }

    @Transient
    @Override
    public Class<BM_ChkItijibrTuusanP> getEntityClass() {
        return BM_ChkItijibrTuusanP.class;
    }

    private BizNumber hhknfromnen;

    @org.hibernate.annotations.Type(type="BizNumberType")
    public BizNumber getHhknfromnen() {
        return hhknfromnen;
    }

    public void setHhknfromnen(BizNumber pHhknfromnen) {
        hhknfromnen = pHhknfromnen;
    }
    private BizNumber hhkntonen;

    @org.hibernate.annotations.Type(type="BizNumberType")
    public BizNumber getHhkntonen() {
        return hhkntonen;
    }

    public void setHhkntonen(BizNumber pHhkntonen) {
        hhkntonen = pHhkntonen;
    }

}