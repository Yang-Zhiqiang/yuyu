package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_DairitenRn;
import yuyu.def.db.meta.QZT_DairitenRn;

/**
 * 代理店ＰＲＴ用連動Ｆテーブル（連）(ZT_DairitenRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_DairitenRnDao extends AbstractDao<ZT_DairitenRn> {

    public ZT_DairitenRnDao() {
        super(ZT_DairitenRn.class);
    }

    public ZT_DairitenRn getDairitenRn(String pZrndairitencd) {
        ZT_DairitenRn zT_DairitenRn =  new ZT_DairitenRn();
        zT_DairitenRn.setZrndairitencd(pZrndairitencd);
        return this.selectOne(zT_DairitenRn);
    }

    public ExDBResults<ZT_DairitenRn> selectAllZT_DairitenRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_DairitenRn qZT_DairitenRn =  new QZT_DairitenRn();
        jpql.append($SELECT);
        jpql.append(qZT_DairitenRn);
        jpql.append($FROM);
        jpql.append(qZT_DairitenRn.ZT_DairitenRn());
        jpql.append($ORDER_BY(qZT_DairitenRn.zrndairitencd.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_DairitenRn).getResults();
    }

    public Long getDairitenRnCount() {


        QZT_DairitenRn qZT_DairitenRn = new QZT_DairitenRn();


        String strSql = $SELECT + $COUNT(qZT_DairitenRn.zrndairitencd) +
            $FROM + qZT_DairitenRn.ZT_DairitenRn();


        return em.createJPQL(strSql).bind(qZT_DairitenRn).getSingleResult();
    }

}
