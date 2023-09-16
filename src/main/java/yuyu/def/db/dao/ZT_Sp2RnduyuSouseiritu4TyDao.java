package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu4Ty;
import yuyu.def.db.meta.QZT_Sp2RnduyuSouseiritu4Ty;

/**
 * ＳＰ２連動用総成立Fテーブル４（中）(ZT_Sp2RnduyuSouseiritu4TyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_Sp2RnduyuSouseiritu4TyDao extends AbstractDao<ZT_Sp2RnduyuSouseiritu4Ty> {

    public ZT_Sp2RnduyuSouseiritu4TyDao() {
        super(ZT_Sp2RnduyuSouseiritu4Ty.class);
    }

    public ZT_Sp2RnduyuSouseiritu4Ty getSp2RnduyuSouseiritu4Ty(String pZtyktgysyono) {
        ZT_Sp2RnduyuSouseiritu4Ty zT_Sp2RnduyuSouseiritu4Ty =  new ZT_Sp2RnduyuSouseiritu4Ty();
        zT_Sp2RnduyuSouseiritu4Ty.setZtyktgysyono(pZtyktgysyono);
        return this.selectOne(zT_Sp2RnduyuSouseiritu4Ty);
    }

    public ExDBResults<ZT_Sp2RnduyuSouseiritu4Ty> selectAllZT_Sp2RnduyuSouseiritu4Ty() {
        StringBuilder jpql = new StringBuilder();
        QZT_Sp2RnduyuSouseiritu4Ty qZT_Sp2RnduyuSouseiritu4Ty =  new QZT_Sp2RnduyuSouseiritu4Ty();
        jpql.append($SELECT);
        jpql.append(qZT_Sp2RnduyuSouseiritu4Ty);
        jpql.append($FROM);
        jpql.append(qZT_Sp2RnduyuSouseiritu4Ty.ZT_Sp2RnduyuSouseiritu4Ty());
        jpql.append($ORDER_BY(qZT_Sp2RnduyuSouseiritu4Ty.ztyktgysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_Sp2RnduyuSouseiritu4Ty).getResults();
    }
}
