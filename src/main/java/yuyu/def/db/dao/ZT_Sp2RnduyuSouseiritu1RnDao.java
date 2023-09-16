package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu1Rn;
import yuyu.def.db.meta.QZT_Sp2RnduyuSouseiritu1Rn;

/**
 * ＳＰ２連動用総成立Fテーブル１（連）(ZT_Sp2RnduyuSouseiritu1RnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_Sp2RnduyuSouseiritu1RnDao extends AbstractDao<ZT_Sp2RnduyuSouseiritu1Rn> {

    public ZT_Sp2RnduyuSouseiritu1RnDao() {
        super(ZT_Sp2RnduyuSouseiritu1Rn.class);
    }

    public ZT_Sp2RnduyuSouseiritu1Rn getSp2RnduyuSouseiritu1Rn(String pZrnktgysyono) {
        ZT_Sp2RnduyuSouseiritu1Rn zT_Sp2RnduyuSouseiritu1Rn =  new ZT_Sp2RnduyuSouseiritu1Rn();
        zT_Sp2RnduyuSouseiritu1Rn.setZrnktgysyono(pZrnktgysyono);
        return this.selectOne(zT_Sp2RnduyuSouseiritu1Rn);
    }

    public ExDBResults<ZT_Sp2RnduyuSouseiritu1Rn> selectAllZT_Sp2RnduyuSouseiritu1Rn() {
        StringBuilder jpql = new StringBuilder();
        QZT_Sp2RnduyuSouseiritu1Rn qZT_Sp2RnduyuSouseiritu1Rn =  new QZT_Sp2RnduyuSouseiritu1Rn();
        jpql.append($SELECT);
        jpql.append(qZT_Sp2RnduyuSouseiritu1Rn);
        jpql.append($FROM);
        jpql.append(qZT_Sp2RnduyuSouseiritu1Rn.ZT_Sp2RnduyuSouseiritu1Rn());
        jpql.append($ORDER_BY(qZT_Sp2RnduyuSouseiritu1Rn.zrnktgysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_Sp2RnduyuSouseiritu1Rn).getResults();
    }
}
