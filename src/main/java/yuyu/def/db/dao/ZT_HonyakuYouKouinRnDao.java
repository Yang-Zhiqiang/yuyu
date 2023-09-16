package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_HonyakuYouKouinRn;
import yuyu.def.db.meta.QZT_HonyakuYouKouinRn;

/**
 * 翻訳用行員Ｆ用連動Ｆテーブル（連）(ZT_HonyakuYouKouinRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_HonyakuYouKouinRnDao extends AbstractDao<ZT_HonyakuYouKouinRn> {

    public ZT_HonyakuYouKouinRnDao() {
        super(ZT_HonyakuYouKouinRn.class);
    }

    public ZT_HonyakuYouKouinRn getHonyakuYouKouinRn(String pZrnkinyuukikancd, String pZrnkouincd) {
        ZT_HonyakuYouKouinRn zT_HonyakuYouKouinRn =  new ZT_HonyakuYouKouinRn();
        zT_HonyakuYouKouinRn.setZrnkinyuukikancd(pZrnkinyuukikancd);
        zT_HonyakuYouKouinRn.setZrnkouincd(pZrnkouincd);
        return this.selectOne(zT_HonyakuYouKouinRn);
    }

    public ExDBResults<ZT_HonyakuYouKouinRn> selectAllZT_HonyakuYouKouinRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_HonyakuYouKouinRn qZT_HonyakuYouKouinRn =  new QZT_HonyakuYouKouinRn();
        jpql.append($SELECT);
        jpql.append(qZT_HonyakuYouKouinRn);
        jpql.append($FROM);
        jpql.append(qZT_HonyakuYouKouinRn.ZT_HonyakuYouKouinRn());
        jpql.append($ORDER_BY(qZT_HonyakuYouKouinRn.zrnkinyuukikancd.asc(), qZT_HonyakuYouKouinRn.zrnkouincd.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_HonyakuYouKouinRn).getResults();
    }

    public Long getHonyakuYouKouinRnCount() {


        QZT_HonyakuYouKouinRn qZT_HonyakuYouKouinRn = new QZT_HonyakuYouKouinRn();


        String strSql = $SELECT + $COUNT(qZT_HonyakuYouKouinRn.zrnkinyuukikancd) +
            $FROM + qZT_HonyakuYouKouinRn.ZT_HonyakuYouKouinRn();


        return em.createJPQL(strSql).bind(qZT_HonyakuYouKouinRn).getSingleResult();
    }

    public ExDBResults<ZT_HonyakuYouKouinRn> getHonyakuYouKouinRnsByZrnkinyuukikancdKeta4(String pZrnkinyuukikancdKeta4) {


        QZT_HonyakuYouKouinRn qZT_HonyakuYouKouinRn = new QZT_HonyakuYouKouinRn();


        String strSql = $SELECT + qZT_HonyakuYouKouinRn +
            $FROM + qZT_HonyakuYouKouinRn.ZT_HonyakuYouKouinRn() +
            $WHERE + qZT_HonyakuYouKouinRn.zrnkinyuukikancd.substring(4, 1).eq(pZrnkinyuukikancdKeta4) +
            $ORDER_BY(qZT_HonyakuYouKouinRn.zrnkinyuukikancd.asc(),
                qZT_HonyakuYouKouinRn.zrnkouincd.asc());


        return em.createJPQL(strSql).bind(qZT_HonyakuYouKouinRn).getResults();
    }
}
