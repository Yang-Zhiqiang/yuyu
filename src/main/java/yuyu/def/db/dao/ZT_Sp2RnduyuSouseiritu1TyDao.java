package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu1Ty;
import yuyu.def.db.meta.QZT_Sp2RnduyuSouseiritu1Ty;

/**
 * ＳＰ２連動用総成立Fテーブル１（中）(ZT_Sp2RnduyuSouseiritu1TyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_Sp2RnduyuSouseiritu1TyDao extends AbstractDao<ZT_Sp2RnduyuSouseiritu1Ty> {

    public ZT_Sp2RnduyuSouseiritu1TyDao() {
        super(ZT_Sp2RnduyuSouseiritu1Ty.class);
    }

    public ZT_Sp2RnduyuSouseiritu1Ty getSp2RnduyuSouseiritu1Ty(String pZtyktgysyono) {
        ZT_Sp2RnduyuSouseiritu1Ty zT_Sp2RnduyuSouseiritu1Ty =  new ZT_Sp2RnduyuSouseiritu1Ty();
        zT_Sp2RnduyuSouseiritu1Ty.setZtyktgysyono(pZtyktgysyono);
        return this.selectOne(zT_Sp2RnduyuSouseiritu1Ty);
    }

    public ExDBResults<ZT_Sp2RnduyuSouseiritu1Ty> selectAllZT_Sp2RnduyuSouseiritu1Ty() {
        StringBuilder jpql = new StringBuilder();
        QZT_Sp2RnduyuSouseiritu1Ty qZT_Sp2RnduyuSouseiritu1Ty =  new QZT_Sp2RnduyuSouseiritu1Ty();
        jpql.append($SELECT);
        jpql.append(qZT_Sp2RnduyuSouseiritu1Ty);
        jpql.append($FROM);
        jpql.append(qZT_Sp2RnduyuSouseiritu1Ty.ZT_Sp2RnduyuSouseiritu1Ty());
        jpql.append($ORDER_BY(qZT_Sp2RnduyuSouseiritu1Ty.ztyktgysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_Sp2RnduyuSouseiritu1Ty).getResults();
    }
}
