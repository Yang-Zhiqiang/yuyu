package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_TjtIdouNaiyouRn;
import yuyu.def.db.meta.QZT_TjtIdouNaiyouRn;

/**
 * 当日異動内容テーブル（連）(ZT_TjtIdouNaiyouRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_TjtIdouNaiyouRnDao extends AbstractDao<ZT_TjtIdouNaiyouRn> {

    public ZT_TjtIdouNaiyouRnDao() {
        super(ZT_TjtIdouNaiyouRn.class);
    }

    public ZT_TjtIdouNaiyouRn getTjtIdouNaiyouRn(String pZrnhuho2kyknokbn, String pZrnhuho2kykno) {
        ZT_TjtIdouNaiyouRn zT_TjtIdouNaiyouRn =  new ZT_TjtIdouNaiyouRn();
        zT_TjtIdouNaiyouRn.setZrnhuho2kyknokbn(pZrnhuho2kyknokbn);
        zT_TjtIdouNaiyouRn.setZrnhuho2kykno(pZrnhuho2kykno);
        return this.selectOne(zT_TjtIdouNaiyouRn);
    }

    public ExDBResults<ZT_TjtIdouNaiyouRn> selectAllZT_TjtIdouNaiyouRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_TjtIdouNaiyouRn qZT_TjtIdouNaiyouRn =  new QZT_TjtIdouNaiyouRn();
        jpql.append($SELECT);
        jpql.append(qZT_TjtIdouNaiyouRn);
        jpql.append($FROM);
        jpql.append(qZT_TjtIdouNaiyouRn.ZT_TjtIdouNaiyouRn());
        jpql.append($ORDER_BY(qZT_TjtIdouNaiyouRn.zrnhuho2kyknokbn.asc(), qZT_TjtIdouNaiyouRn.zrnhuho2kykno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_TjtIdouNaiyouRn).getResults();
    }
}
