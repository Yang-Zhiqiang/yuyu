package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu3Ty;
import yuyu.def.db.meta.QZT_Sp2RnduyuSouseiritu3Ty;

/**
 * ＳＰ２連動用総成立Fテーブル３（中）(ZT_Sp2RnduyuSouseiritu3TyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_Sp2RnduyuSouseiritu3TyDao extends AbstractDao<ZT_Sp2RnduyuSouseiritu3Ty> {

    public ZT_Sp2RnduyuSouseiritu3TyDao() {
        super(ZT_Sp2RnduyuSouseiritu3Ty.class);
    }

    public ZT_Sp2RnduyuSouseiritu3Ty getSp2RnduyuSouseiritu3Ty(String pZtyktgysyono) {
        ZT_Sp2RnduyuSouseiritu3Ty zT_Sp2RnduyuSouseiritu3Ty =  new ZT_Sp2RnduyuSouseiritu3Ty();
        zT_Sp2RnduyuSouseiritu3Ty.setZtyktgysyono(pZtyktgysyono);
        return this.selectOne(zT_Sp2RnduyuSouseiritu3Ty);
    }

    public ExDBResults<ZT_Sp2RnduyuSouseiritu3Ty> selectAllZT_Sp2RnduyuSouseiritu3Ty() {
        StringBuilder jpql = new StringBuilder();
        QZT_Sp2RnduyuSouseiritu3Ty qZT_Sp2RnduyuSouseiritu3Ty =  new QZT_Sp2RnduyuSouseiritu3Ty();
        jpql.append($SELECT);
        jpql.append(qZT_Sp2RnduyuSouseiritu3Ty);
        jpql.append($FROM);
        jpql.append(qZT_Sp2RnduyuSouseiritu3Ty.ZT_Sp2RnduyuSouseiritu3Ty());
        jpql.append($ORDER_BY(qZT_Sp2RnduyuSouseiritu3Ty.ztyktgysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_Sp2RnduyuSouseiritu3Ty).getResults();
    }
}
