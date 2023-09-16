package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu2Rn;
import yuyu.def.db.meta.QZT_Sp2RnduyuSouseiritu2Rn;

/**
 * ＳＰ２連動用総成立Fテーブル２（連）(ZT_Sp2RnduyuSouseiritu2RnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_Sp2RnduyuSouseiritu2RnDao extends AbstractDao<ZT_Sp2RnduyuSouseiritu2Rn> {

    public ZT_Sp2RnduyuSouseiritu2RnDao() {
        super(ZT_Sp2RnduyuSouseiritu2Rn.class);
    }

    public ZT_Sp2RnduyuSouseiritu2Rn getSp2RnduyuSouseiritu2Rn(String pZrnktgysyono) {
        ZT_Sp2RnduyuSouseiritu2Rn zT_Sp2RnduyuSouseiritu2Rn =  new ZT_Sp2RnduyuSouseiritu2Rn();
        zT_Sp2RnduyuSouseiritu2Rn.setZrnktgysyono(pZrnktgysyono);
        return this.selectOne(zT_Sp2RnduyuSouseiritu2Rn);
    }

    public ExDBResults<ZT_Sp2RnduyuSouseiritu2Rn> selectAllZT_Sp2RnduyuSouseiritu2Rn() {
        StringBuilder jpql = new StringBuilder();
        QZT_Sp2RnduyuSouseiritu2Rn qZT_Sp2RnduyuSouseiritu2Rn =  new QZT_Sp2RnduyuSouseiritu2Rn();
        jpql.append($SELECT);
        jpql.append(qZT_Sp2RnduyuSouseiritu2Rn);
        jpql.append($FROM);
        jpql.append(qZT_Sp2RnduyuSouseiritu2Rn.ZT_Sp2RnduyuSouseiritu2Rn());
        jpql.append($ORDER_BY(qZT_Sp2RnduyuSouseiritu2Rn.zrnktgysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_Sp2RnduyuSouseiritu2Rn).getResults();
    }
}
