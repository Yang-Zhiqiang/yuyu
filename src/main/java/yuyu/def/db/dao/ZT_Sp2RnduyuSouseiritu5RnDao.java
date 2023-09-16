package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu5Rn;
import yuyu.def.db.meta.QZT_Sp2RnduyuSouseiritu5Rn;

/**
 * ＳＰ２連動用総成立Fテーブル５（連）(ZT_Sp2RnduyuSouseiritu5RnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_Sp2RnduyuSouseiritu5RnDao extends AbstractDao<ZT_Sp2RnduyuSouseiritu5Rn> {

    public ZT_Sp2RnduyuSouseiritu5RnDao() {
        super(ZT_Sp2RnduyuSouseiritu5Rn.class);
    }

    public ZT_Sp2RnduyuSouseiritu5Rn getSp2RnduyuSouseiritu5Rn(String pZrnktgysyono) {
        ZT_Sp2RnduyuSouseiritu5Rn zT_Sp2RnduyuSouseiritu5Rn =  new ZT_Sp2RnduyuSouseiritu5Rn();
        zT_Sp2RnduyuSouseiritu5Rn.setZrnktgysyono(pZrnktgysyono);
        return this.selectOne(zT_Sp2RnduyuSouseiritu5Rn);
    }

    public ExDBResults<ZT_Sp2RnduyuSouseiritu5Rn> selectAllZT_Sp2RnduyuSouseiritu5Rn() {
        StringBuilder jpql = new StringBuilder();
        QZT_Sp2RnduyuSouseiritu5Rn qZT_Sp2RnduyuSouseiritu5Rn =  new QZT_Sp2RnduyuSouseiritu5Rn();
        jpql.append($SELECT);
        jpql.append(qZT_Sp2RnduyuSouseiritu5Rn);
        jpql.append($FROM);
        jpql.append(qZT_Sp2RnduyuSouseiritu5Rn.ZT_Sp2RnduyuSouseiritu5Rn());
        jpql.append($ORDER_BY(qZT_Sp2RnduyuSouseiritu5Rn.zrnktgysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_Sp2RnduyuSouseiritu5Rn).getResults();
    }
}
