package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu6Ty;
import yuyu.def.db.meta.QZT_Sp2RnduyuSouseiritu6Ty;

/**
 * ＳＰ２連動用総成立Fテーブル６（中）(ZT_Sp2RnduyuSouseiritu6TyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_Sp2RnduyuSouseiritu6TyDao extends AbstractDao<ZT_Sp2RnduyuSouseiritu6Ty> {

    public ZT_Sp2RnduyuSouseiritu6TyDao() {
        super(ZT_Sp2RnduyuSouseiritu6Ty.class);
    }

    public ZT_Sp2RnduyuSouseiritu6Ty getSp2RnduyuSouseiritu6Ty(String pZtyktgysyono) {
        ZT_Sp2RnduyuSouseiritu6Ty zT_Sp2RnduyuSouseiritu6Ty =  new ZT_Sp2RnduyuSouseiritu6Ty();
        zT_Sp2RnduyuSouseiritu6Ty.setZtyktgysyono(pZtyktgysyono);
        return this.selectOne(zT_Sp2RnduyuSouseiritu6Ty);
    }

    public ExDBResults<ZT_Sp2RnduyuSouseiritu6Ty> selectAllZT_Sp2RnduyuSouseiritu6Ty() {
        StringBuilder jpql = new StringBuilder();
        QZT_Sp2RnduyuSouseiritu6Ty qZT_Sp2RnduyuSouseiritu6Ty =  new QZT_Sp2RnduyuSouseiritu6Ty();
        jpql.append($SELECT);
        jpql.append(qZT_Sp2RnduyuSouseiritu6Ty);
        jpql.append($FROM);
        jpql.append(qZT_Sp2RnduyuSouseiritu6Ty.ZT_Sp2RnduyuSouseiritu6Ty());
        jpql.append($ORDER_BY(qZT_Sp2RnduyuSouseiritu6Ty.ztyktgysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_Sp2RnduyuSouseiritu6Ty).getResults();
    }
}
