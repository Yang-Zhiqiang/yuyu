package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BM_ChkItijibrTuusanS;
import yuyu.def.db.mapping.GenBM_ChkItijibrTuusanS;
import yuyu.def.db.meta.GenQBM_ChkItijibrTuusanS;
import yuyu.def.db.meta.QBM_ChkItijibrTuusanS;

/**
 * 一時払通算限度Ｓチェックマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkItijibrTuusanS}</td><td colspan="3">一時払通算限度Ｓチェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getHhknfromnen hhknfromnen}</td><td>被保険者年齢自</td><td align="center">○</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHhkntonen hhkntonen}</td><td>被保険者年齢至</td><td align="center">○</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>gnds</td><td>限度Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_ChkItijibrTuusanS
 * @see     GenBM_ChkItijibrTuusanS
 * @see     QBM_ChkItijibrTuusanS
 * @see     GenQBM_ChkItijibrTuusanS
 */
public class PKBM_ChkItijibrTuusanS extends AbstractExDBPrimaryKey<BM_ChkItijibrTuusanS, PKBM_ChkItijibrTuusanS> {

    private static final long serialVersionUID = 1L;

    public PKBM_ChkItijibrTuusanS() {
    }

    public PKBM_ChkItijibrTuusanS(BizNumber pHhknfromnen, BizNumber pHhkntonen) {
        hhknfromnen = pHhknfromnen;
        hhkntonen = pHhkntonen;
    }

    @Transient
    @Override
    public Class<BM_ChkItijibrTuusanS> getEntityClass() {
        return BM_ChkItijibrTuusanS.class;
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