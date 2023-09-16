package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_DairitenSyougouRn;
import yuyu.def.db.meta.QZT_DairitenSyougouRn;

/**
 * 代理店法人商号連動ＵＬＦテーブル（連）(ZT_DairitenSyougouRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_DairitenSyougouRnDao extends AbstractDao<ZT_DairitenSyougouRn> {

    public ZT_DairitenSyougouRnDao() {
        super(ZT_DairitenSyougouRn.class);
    }

    public ZT_DairitenSyougouRn getDairitenSyougouRn(String pZrndairitencd) {
        ZT_DairitenSyougouRn zT_DairitenSyougouRn =  new ZT_DairitenSyougouRn();
        zT_DairitenSyougouRn.setZrndairitencd(pZrndairitencd);
        return this.selectOne(zT_DairitenSyougouRn);
    }

    public ExDBResults<ZT_DairitenSyougouRn> selectAllZT_DairitenSyougouRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_DairitenSyougouRn qZT_DairitenSyougouRn =  new QZT_DairitenSyougouRn();
        jpql.append($SELECT);
        jpql.append(qZT_DairitenSyougouRn);
        jpql.append($FROM);
        jpql.append(qZT_DairitenSyougouRn.ZT_DairitenSyougouRn());
        jpql.append($ORDER_BY(qZT_DairitenSyougouRn.zrndairitencd.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_DairitenSyougouRn).getResults();
    }

    public Long getDairitenSyougouRnCount(){


        QZT_DairitenSyougouRn qZT_DairitenSyougouRn = new QZT_DairitenSyougouRn();


        String strSql = $SELECT + $COUNT(qZT_DairitenSyougouRn.zrndairitencd) +
            $FROM + qZT_DairitenSyougouRn.ZT_DairitenSyougouRn();


        return em.createJPQL(strSql).bind(qZT_DairitenSyougouRn).getSingleResult();
    }
}
