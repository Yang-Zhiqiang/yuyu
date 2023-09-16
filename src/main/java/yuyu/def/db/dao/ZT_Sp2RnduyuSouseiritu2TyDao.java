package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu2Ty;
import yuyu.def.db.meta.QZT_Sp2RnduyuSouseiritu2Ty;

/**
 * ＳＰ２連動用総成立Fテーブル２（中）(ZT_Sp2RnduyuSouseiritu2TyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_Sp2RnduyuSouseiritu2TyDao extends AbstractDao<ZT_Sp2RnduyuSouseiritu2Ty> {

    public ZT_Sp2RnduyuSouseiritu2TyDao() {
        super(ZT_Sp2RnduyuSouseiritu2Ty.class);
    }

    public ZT_Sp2RnduyuSouseiritu2Ty getSp2RnduyuSouseiritu2Ty(String pZtyktgysyono) {
        ZT_Sp2RnduyuSouseiritu2Ty zT_Sp2RnduyuSouseiritu2Ty =  new ZT_Sp2RnduyuSouseiritu2Ty();
        zT_Sp2RnduyuSouseiritu2Ty.setZtyktgysyono(pZtyktgysyono);
        return this.selectOne(zT_Sp2RnduyuSouseiritu2Ty);
    }

    public ExDBResults<ZT_Sp2RnduyuSouseiritu2Ty> selectAllZT_Sp2RnduyuSouseiritu2Ty() {
        StringBuilder jpql = new StringBuilder();
        QZT_Sp2RnduyuSouseiritu2Ty qZT_Sp2RnduyuSouseiritu2Ty =  new QZT_Sp2RnduyuSouseiritu2Ty();
        jpql.append($SELECT);
        jpql.append(qZT_Sp2RnduyuSouseiritu2Ty);
        jpql.append($FROM);
        jpql.append(qZT_Sp2RnduyuSouseiritu2Ty.ZT_Sp2RnduyuSouseiritu2Ty());
        jpql.append($ORDER_BY(qZT_Sp2RnduyuSouseiritu2Ty.ztyktgysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_Sp2RnduyuSouseiritu2Ty).getResults();
    }
}
