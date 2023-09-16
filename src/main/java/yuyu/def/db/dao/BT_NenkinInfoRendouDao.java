package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.def.classification.C_DatatorikomiKbn;
import yuyu.def.db.entity.BT_NenkinInfoRendou;
import yuyu.def.db.meta.QBT_NenkinInfoRendou;

/**
 * 年金情報連動テーブル(BT_NenkinInfoRendouDao) アクセス用の DAO クラスです。<br />
 */
public class BT_NenkinInfoRendouDao extends AbstractDao<BT_NenkinInfoRendou> {

    public BT_NenkinInfoRendouDao() {
        super(BT_NenkinInfoRendou.class);
    }

    public BT_NenkinInfoRendou getNenkinInfoRendou(BizDate pSyoriYmd,
        String pSyono,
        Integer pRenno){
        BT_NenkinInfoRendou bT_NenkinInfoRendou =  new BT_NenkinInfoRendou();
        bT_NenkinInfoRendou.setSyoriYmd(pSyoriYmd);
        bT_NenkinInfoRendou.setSyono(pSyono);
        bT_NenkinInfoRendou.setRenno(pRenno);
        return this.selectOne(bT_NenkinInfoRendou);
    }

    public ExDBUpdatableResults<BT_NenkinInfoRendou> getNenkinInfoRendousByKakutyoujobcdSyoriYmdDatatorikomikbn(
        BizDate pSyoriYmd) {


        QBT_NenkinInfoRendou qBT_NenkinInfoRendou = new QBT_NenkinInfoRendou("qBT_NenkinInfoRendou");


        String strSql = $SELECT + qBT_NenkinInfoRendou +
            $FROM + qBT_NenkinInfoRendou.BT_NenkinInfoRendou() +
            $WHERE + qBT_NenkinInfoRendou.syoriYmd.le(pSyoriYmd) +
            $AND + qBT_NenkinInfoRendou.datatorikomikbn.eq(C_DatatorikomiKbn.MITORIKOMI) +
            $ORDER_BY(qBT_NenkinInfoRendou.syono.asc());


        return em.createJPQL(strSql).bind(qBT_NenkinInfoRendou).getUpdatableResults();
    }
}
