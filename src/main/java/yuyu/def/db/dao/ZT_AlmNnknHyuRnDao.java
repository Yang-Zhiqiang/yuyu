package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_AlmNnknHyuRn;
import yuyu.def.db.meta.QZT_AlmNnknHyuRn;

/**
 * ＡＬＭ用年金保有明細テーブル（連）(ZT_AlmNnknHyuRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_AlmNnknHyuRnDao extends AbstractDao<ZT_AlmNnknHyuRn> {

    public ZT_AlmNnknHyuRnDao() {
        super(ZT_AlmNnknHyuRn.class);
    }

    public ZT_AlmNnknHyuRn getAlmNnknHyuRn(String pZrnnksyousyono) {
        ZT_AlmNnknHyuRn zT_AlmNnknHyuRn =  new ZT_AlmNnknHyuRn();
        zT_AlmNnknHyuRn.setZrnnksyousyono(pZrnnksyousyono);
        return this.selectOne(zT_AlmNnknHyuRn);
    }

    public ExDBResults<ZT_AlmNnknHyuRn> selectAllZT_AlmNnknHyuRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_AlmNnknHyuRn qZT_AlmNnknHyuRn =  new QZT_AlmNnknHyuRn();
        jpql.append($SELECT);
        jpql.append(qZT_AlmNnknHyuRn);
        jpql.append($FROM);
        jpql.append(qZT_AlmNnknHyuRn.ZT_AlmNnknHyuRn());
        jpql.append($ORDER_BY(qZT_AlmNnknHyuRn.zrnnksyousyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_AlmNnknHyuRn).getResults();
    }
}
