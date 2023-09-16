package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_HonsyaToukeiRn;
import yuyu.def.db.meta.QZT_HonsyaToukeiRn;

/**
 * 本社統計Ｆテーブル（連）(ZT_HonsyaToukeiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_HonsyaToukeiRnDao extends AbstractDao<ZT_HonsyaToukeiRn> {

    public ZT_HonsyaToukeiRnDao() {
        super(ZT_HonsyaToukeiRn.class);
    }

    public ZT_HonsyaToukeiRn getHonsyaToukeiRn(String pZrnkijyunym, String pZrnmosno) {
        ZT_HonsyaToukeiRn zT_HonsyaToukeiRn =  new ZT_HonsyaToukeiRn();
        zT_HonsyaToukeiRn.setZrnkijyunym(pZrnkijyunym);
        zT_HonsyaToukeiRn.setZrnmosno(pZrnmosno);
        return this.selectOne(zT_HonsyaToukeiRn);
    }

    public ExDBResults<ZT_HonsyaToukeiRn> selectAllZT_HonsyaToukeiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_HonsyaToukeiRn qZT_HonsyaToukeiRn =  new QZT_HonsyaToukeiRn();
        jpql.append($SELECT);
        jpql.append(qZT_HonsyaToukeiRn);
        jpql.append($FROM);
        jpql.append(qZT_HonsyaToukeiRn.ZT_HonsyaToukeiRn());
        jpql.append($ORDER_BY(qZT_HonsyaToukeiRn.zrnkijyunym.asc(), qZT_HonsyaToukeiRn.zrnmosno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_HonsyaToukeiRn).getResults();
    }
}
