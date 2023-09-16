package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SinninTouhyouRn;
import yuyu.def.db.meta.QZT_SinninTouhyouRn;

/**
 * 信任投票データテーブル（連）(ZT_SinninTouhyouRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SinninTouhyouRnDao extends AbstractDao<ZT_SinninTouhyouRn> {

    public ZT_SinninTouhyouRnDao() {
        super(ZT_SinninTouhyouRn.class);
    }

    public ZT_SinninTouhyouRn getSinninTouhyouRn(String pZrnsyono) {
        ZT_SinninTouhyouRn zT_SinninTouhyouRn =  new ZT_SinninTouhyouRn();
        zT_SinninTouhyouRn.setZrnsyono(pZrnsyono);
        return this.selectOne(zT_SinninTouhyouRn);
    }

    public ExDBResults<ZT_SinninTouhyouRn> selectAllZT_SinninTouhyouRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SinninTouhyouRn qZT_SinninTouhyouRn =  new QZT_SinninTouhyouRn();
        jpql.append($SELECT);
        jpql.append(qZT_SinninTouhyouRn);
        jpql.append($FROM);
        jpql.append(qZT_SinninTouhyouRn.ZT_SinninTouhyouRn());
        jpql.append($ORDER_BY(qZT_SinninTouhyouRn.zrnsyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SinninTouhyouRn).getResults();
    }
}
