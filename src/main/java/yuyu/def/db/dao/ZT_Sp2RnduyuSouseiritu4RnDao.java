package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu4Rn;
import yuyu.def.db.meta.QZT_Sp2RnduyuSouseiritu4Rn;

/**
 * ＳＰ２連動用総成立Fテーブル４（連）(ZT_Sp2RnduyuSouseiritu4RnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_Sp2RnduyuSouseiritu4RnDao extends AbstractDao<ZT_Sp2RnduyuSouseiritu4Rn> {

    public ZT_Sp2RnduyuSouseiritu4RnDao() {
        super(ZT_Sp2RnduyuSouseiritu4Rn.class);
    }

    public ZT_Sp2RnduyuSouseiritu4Rn getSp2RnduyuSouseiritu4Rn(String pZrnktgysyono) {
        ZT_Sp2RnduyuSouseiritu4Rn zT_Sp2RnduyuSouseiritu4Rn =  new ZT_Sp2RnduyuSouseiritu4Rn();
        zT_Sp2RnduyuSouseiritu4Rn.setZrnktgysyono(pZrnktgysyono);
        return this.selectOne(zT_Sp2RnduyuSouseiritu4Rn);
    }

    public ExDBResults<ZT_Sp2RnduyuSouseiritu4Rn> selectAllZT_Sp2RnduyuSouseiritu4Rn() {
        StringBuilder jpql = new StringBuilder();
        QZT_Sp2RnduyuSouseiritu4Rn qZT_Sp2RnduyuSouseiritu4Rn =  new QZT_Sp2RnduyuSouseiritu4Rn();
        jpql.append($SELECT);
        jpql.append(qZT_Sp2RnduyuSouseiritu4Rn);
        jpql.append($FROM);
        jpql.append(qZT_Sp2RnduyuSouseiritu4Rn.ZT_Sp2RnduyuSouseiritu4Rn());
        jpql.append($ORDER_BY(qZT_Sp2RnduyuSouseiritu4Rn.zrnktgysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_Sp2RnduyuSouseiritu4Rn).getResults();
    }
}
