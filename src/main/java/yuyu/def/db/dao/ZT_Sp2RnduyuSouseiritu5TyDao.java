package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu5Ty;
import yuyu.def.db.meta.QZT_Sp2RnduyuSouseiritu5Ty;

/**
 * ＳＰ２連動用総成立Fテーブル５（中）(ZT_Sp2RnduyuSouseiritu5TyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_Sp2RnduyuSouseiritu5TyDao extends AbstractDao<ZT_Sp2RnduyuSouseiritu5Ty> {

    public ZT_Sp2RnduyuSouseiritu5TyDao() {
        super(ZT_Sp2RnduyuSouseiritu5Ty.class);
    }

    public ZT_Sp2RnduyuSouseiritu5Ty getSp2RnduyuSouseiritu5Ty(String pZtyktgysyono) {
        ZT_Sp2RnduyuSouseiritu5Ty zT_Sp2RnduyuSouseiritu5Ty =  new ZT_Sp2RnduyuSouseiritu5Ty();
        zT_Sp2RnduyuSouseiritu5Ty.setZtyktgysyono(pZtyktgysyono);
        return this.selectOne(zT_Sp2RnduyuSouseiritu5Ty);
    }

    public ExDBResults<ZT_Sp2RnduyuSouseiritu5Ty> selectAllZT_Sp2RnduyuSouseiritu5Ty() {
        StringBuilder jpql = new StringBuilder();
        QZT_Sp2RnduyuSouseiritu5Ty qZT_Sp2RnduyuSouseiritu5Ty =  new QZT_Sp2RnduyuSouseiritu5Ty();
        jpql.append($SELECT);
        jpql.append(qZT_Sp2RnduyuSouseiritu5Ty);
        jpql.append($FROM);
        jpql.append(qZT_Sp2RnduyuSouseiritu5Ty.ZT_Sp2RnduyuSouseiritu5Ty());
        jpql.append($ORDER_BY(qZT_Sp2RnduyuSouseiritu5Ty.ztyktgysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_Sp2RnduyuSouseiritu5Ty).getResults();
    }
}
