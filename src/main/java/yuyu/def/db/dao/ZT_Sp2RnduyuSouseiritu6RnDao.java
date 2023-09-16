package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu6Rn;
import yuyu.def.db.meta.QZT_Sp2RnduyuSouseiritu6Rn;

/**
 * ＳＰ２連動用総成立Fテーブル６（連）(ZT_Sp2RnduyuSouseiritu6RnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_Sp2RnduyuSouseiritu6RnDao extends AbstractDao<ZT_Sp2RnduyuSouseiritu6Rn> {

    public ZT_Sp2RnduyuSouseiritu6RnDao() {
        super(ZT_Sp2RnduyuSouseiritu6Rn.class);
    }

    public ZT_Sp2RnduyuSouseiritu6Rn getSp2RnduyuSouseiritu6Rn(String pZrnktgysyono) {
        ZT_Sp2RnduyuSouseiritu6Rn zT_Sp2RnduyuSouseiritu6Rn =  new ZT_Sp2RnduyuSouseiritu6Rn();
        zT_Sp2RnduyuSouseiritu6Rn.setZrnktgysyono(pZrnktgysyono);
        return this.selectOne(zT_Sp2RnduyuSouseiritu6Rn);
    }

    public ExDBResults<ZT_Sp2RnduyuSouseiritu6Rn> selectAllZT_Sp2RnduyuSouseiritu6Rn() {
        StringBuilder jpql = new StringBuilder();
        QZT_Sp2RnduyuSouseiritu6Rn qZT_Sp2RnduyuSouseiritu6Rn =  new QZT_Sp2RnduyuSouseiritu6Rn();
        jpql.append($SELECT);
        jpql.append(qZT_Sp2RnduyuSouseiritu6Rn);
        jpql.append($FROM);
        jpql.append(qZT_Sp2RnduyuSouseiritu6Rn.ZT_Sp2RnduyuSouseiritu6Rn());
        jpql.append($ORDER_BY(qZT_Sp2RnduyuSouseiritu6Rn.zrnktgysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_Sp2RnduyuSouseiritu6Rn).getResults();
    }
}
