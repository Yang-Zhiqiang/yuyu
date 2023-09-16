package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SbRituRendouRn;
import yuyu.def.db.meta.QZT_SbRituRendouRn;

/**
 * 死亡率用連動Ｆテーブル（連）(ZT_SbRituRendouRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SbRituRendouRnDao extends AbstractDao<ZT_SbRituRendouRn> {

    public ZT_SbRituRendouRnDao() {
        super(ZT_SbRituRendouRn.class);
    }

    public ZT_SbRituRendouRn getSbRituRendouRn(String pZrndatakanrino) {
        ZT_SbRituRendouRn zT_SbRituRendouRn =  new ZT_SbRituRendouRn();
        zT_SbRituRendouRn.setZrndatakanrino(pZrndatakanrino);
        return this.selectOne(zT_SbRituRendouRn);
    }

    public ExDBResults<ZT_SbRituRendouRn> selectAllZT_SbRituRendouRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SbRituRendouRn qZT_SbRituRendouRn =  new QZT_SbRituRendouRn();
        jpql.append($SELECT);
        jpql.append(qZT_SbRituRendouRn);
        jpql.append($FROM);
        jpql.append(qZT_SbRituRendouRn.ZT_SbRituRendouRn());
        jpql.append($ORDER_BY(qZT_SbRituRendouRn.zrndatakanrino.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SbRituRendouRn).getResults();
    }
}
