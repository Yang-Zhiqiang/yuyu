package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu3Rn;
import yuyu.def.db.meta.QZT_Sp2RnduyuSouseiritu3Rn;

/**
 * ＳＰ２連動用総成立Fテーブル３（連）(ZT_Sp2RnduyuSouseiritu3RnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_Sp2RnduyuSouseiritu3RnDao extends AbstractDao<ZT_Sp2RnduyuSouseiritu3Rn> {

    public ZT_Sp2RnduyuSouseiritu3RnDao() {
        super(ZT_Sp2RnduyuSouseiritu3Rn.class);
    }

    public ZT_Sp2RnduyuSouseiritu3Rn getSp2RnduyuSouseiritu3Rn(String pZrnktgysyono) {
        ZT_Sp2RnduyuSouseiritu3Rn zT_Sp2RnduyuSouseiritu3Rn =  new ZT_Sp2RnduyuSouseiritu3Rn();
        zT_Sp2RnduyuSouseiritu3Rn.setZrnktgysyono(pZrnktgysyono);
        return this.selectOne(zT_Sp2RnduyuSouseiritu3Rn);
    }

    public ExDBResults<ZT_Sp2RnduyuSouseiritu3Rn> selectAllZT_Sp2RnduyuSouseiritu3Rn() {
        StringBuilder jpql = new StringBuilder();
        QZT_Sp2RnduyuSouseiritu3Rn qZT_Sp2RnduyuSouseiritu3Rn =  new QZT_Sp2RnduyuSouseiritu3Rn();
        jpql.append($SELECT);
        jpql.append(qZT_Sp2RnduyuSouseiritu3Rn);
        jpql.append($FROM);
        jpql.append(qZT_Sp2RnduyuSouseiritu3Rn.ZT_Sp2RnduyuSouseiritu3Rn());
        jpql.append($ORDER_BY(qZT_Sp2RnduyuSouseiritu3Rn.zrnktgysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_Sp2RnduyuSouseiritu3Rn).getResults();
    }
}
