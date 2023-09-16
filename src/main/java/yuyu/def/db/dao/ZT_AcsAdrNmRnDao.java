package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_AcsAdrNmRn;
import yuyu.def.db.meta.QZT_AcsAdrNmRn;

/**
 * ＡＣＳ住所名ＤＢ用Ｆテーブル（連）(ZT_AcsAdrNmRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_AcsAdrNmRnDao extends AbstractDao<ZT_AcsAdrNmRn> {

    public ZT_AcsAdrNmRnDao() {
        super(ZT_AcsAdrNmRn.class);
    }

    public ZT_AcsAdrNmRn getAcsAdrNmRn(String pZrnkihontikucd) {
        ZT_AcsAdrNmRn zT_AcsAdrNmRn =  new ZT_AcsAdrNmRn();
        zT_AcsAdrNmRn.setZrnkihontikucd(pZrnkihontikucd);
        return this.selectOne(zT_AcsAdrNmRn);
    }

    public ExDBResults<ZT_AcsAdrNmRn> selectAllZT_AcsAdrNmRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_AcsAdrNmRn qZT_AcsAdrNmRn =  new QZT_AcsAdrNmRn();
        jpql.append($SELECT);
        jpql.append(qZT_AcsAdrNmRn);
        jpql.append($FROM);
        jpql.append(qZT_AcsAdrNmRn.ZT_AcsAdrNmRn());
        jpql.append($ORDER_BY(qZT_AcsAdrNmRn.zrnkihontikucd.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_AcsAdrNmRn).getResults();
    }

    public Long getAcsAdrNmRnCount() {


        QZT_AcsAdrNmRn qZT_AcsAdrNmRn = new QZT_AcsAdrNmRn();


        String strSql = $SELECT + $COUNT(qZT_AcsAdrNmRn.zrnkihontikucd) +
            $FROM + qZT_AcsAdrNmRn.ZT_AcsAdrNmRn();


        return em.createJPQL(strSql).bind(qZT_AcsAdrNmRn).getSingleResult();
    }

    public ExDBResults<ZT_AcsAdrNmRn> getAcsAdrNmRnsByZrnkihontikucdKeta7(String pZrnkihontikucdKeta7) {


        QZT_AcsAdrNmRn qZT_AcsAdrNmRn = new QZT_AcsAdrNmRn();


        String strSql = $SELECT + qZT_AcsAdrNmRn +
            $FROM + qZT_AcsAdrNmRn.ZT_AcsAdrNmRn() +
            $WHERE + qZT_AcsAdrNmRn.zrnkihontikucd.substring(7, 1).eq(pZrnkihontikucdKeta7) +
            $ORDER_BY(qZT_AcsAdrNmRn.zrnkihontikucd.asc());


        return em.createJPQL(strSql).bind(qZT_AcsAdrNmRn).getResults();
    }
}
