package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SntkInfoHaneiKekkaTr;
import yuyu.def.db.meta.QZT_SntkInfoHaneiKekkaTr;

/**
 * 普保Ⅱ選択情報反映結果テーブル（取）(ZT_SntkInfoHaneiKekkaTrDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SntkInfoHaneiKekkaTrDao extends AbstractDao<ZT_SntkInfoHaneiKekkaTr> {

    public ZT_SntkInfoHaneiKekkaTrDao() {
        super(ZT_SntkInfoHaneiKekkaTr.class);
    }

    public ZT_SntkInfoHaneiKekkaTr getSntkInfoHaneiKekkaTr(String pZtrsntkinfono, Integer pZtrrenno, String pZtrsntkinfotourokusyskbn) {
        ZT_SntkInfoHaneiKekkaTr zT_SntkInfoHaneiKekkaTr =  new ZT_SntkInfoHaneiKekkaTr();
        zT_SntkInfoHaneiKekkaTr.setZtrsntkinfono(pZtrsntkinfono);
        zT_SntkInfoHaneiKekkaTr.setZtrrenno(pZtrrenno);
        zT_SntkInfoHaneiKekkaTr.setZtrsntkinfotourokusyskbn(pZtrsntkinfotourokusyskbn);
        return this.selectOne(zT_SntkInfoHaneiKekkaTr);
    }

    public ExDBResults<ZT_SntkInfoHaneiKekkaTr> selectAllZT_SntkInfoHaneiKekkaTr() {
        StringBuilder jpql = new StringBuilder();
        QZT_SntkInfoHaneiKekkaTr qZT_SntkInfoHaneiKekkaTr =  new QZT_SntkInfoHaneiKekkaTr();
        jpql.append($SELECT);
        jpql.append(qZT_SntkInfoHaneiKekkaTr);
        jpql.append($FROM);
        jpql.append(qZT_SntkInfoHaneiKekkaTr.ZT_SntkInfoHaneiKekkaTr());
        jpql.append($ORDER_BY(qZT_SntkInfoHaneiKekkaTr.ztrsntkinfono.asc(), qZT_SntkInfoHaneiKekkaTr.ztrrenno.asc(), qZT_SntkInfoHaneiKekkaTr.ztrsntkinfotourokusyskbn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SntkInfoHaneiKekkaTr).getResults();
    }
}
