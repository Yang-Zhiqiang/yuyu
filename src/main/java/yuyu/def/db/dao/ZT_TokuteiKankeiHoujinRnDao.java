package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_TokuteiKankeiHoujinRn;
import yuyu.def.db.meta.QZT_TokuteiKankeiHoujinRn;

/**
 * 特定関係法人マスタテーブル（連）(ZT_TokuteiKankeiHoujinRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_TokuteiKankeiHoujinRnDao extends AbstractDao<ZT_TokuteiKankeiHoujinRn> {

    public ZT_TokuteiKankeiHoujinRnDao() {
        super(ZT_TokuteiKankeiHoujinRn.class);
    }

    public ZT_TokuteiKankeiHoujinRn getTokuteiKankeiHoujinRn(String pZrnkinyuukikancd, String pZrnmeisaibangou) {
        ZT_TokuteiKankeiHoujinRn zT_TokuteiKankeiHoujinRn =  new ZT_TokuteiKankeiHoujinRn();
        zT_TokuteiKankeiHoujinRn.setZrnkinyuukikancd(pZrnkinyuukikancd);
        zT_TokuteiKankeiHoujinRn.setZrnmeisaibangou(pZrnmeisaibangou);
        return this.selectOne(zT_TokuteiKankeiHoujinRn);
    }

    public ExDBResults<ZT_TokuteiKankeiHoujinRn> selectAllZT_TokuteiKankeiHoujinRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_TokuteiKankeiHoujinRn qZT_TokuteiKankeiHoujinRn =  new QZT_TokuteiKankeiHoujinRn();
        jpql.append($SELECT);
        jpql.append(qZT_TokuteiKankeiHoujinRn);
        jpql.append($FROM);
        jpql.append(qZT_TokuteiKankeiHoujinRn.ZT_TokuteiKankeiHoujinRn());
        jpql.append($ORDER_BY(qZT_TokuteiKankeiHoujinRn.zrnkinyuukikancd.asc(), qZT_TokuteiKankeiHoujinRn.zrnmeisaibangou.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_TokuteiKankeiHoujinRn).getResults();
    }

    public Long getTokuteiKankeiHoujinRnCount() {


        QZT_TokuteiKankeiHoujinRn qZT_TokuteiKankeiHoujinRn = new QZT_TokuteiKankeiHoujinRn();


        String strSql = $SELECT + $COUNT(qZT_TokuteiKankeiHoujinRn.zrnkinyuukikancd) +
            $FROM + qZT_TokuteiKankeiHoujinRn.ZT_TokuteiKankeiHoujinRn();


        return em.createJPQL(strSql).bind(qZT_TokuteiKankeiHoujinRn).getSingleResult();
    }
}
