package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_RatepRn;
import yuyu.def.db.meta.QZT_RatepRn;

/**
 * Ｐレートテーブル（連）(ZT_RatepRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_RatepRnDao extends AbstractDao<ZT_RatepRn> {

    public ZT_RatepRnDao() {
        super(ZT_RatepRn.class);
    }

    public ZT_RatepRn getRatepRn(String pZrnhknsyukigou, String pZrnhknsyuruikigousedaikbn, String pZrnyoteiriritu, String pZrnpmenkbn, String pZrnhrkkaisuukbn, String pZrnhhknsei, String pZrnkeiyakujihhknnen, String pZrnsaimnkkykhyj, String pZrnhknkkn, String pZrnphrkkikn) {
        ZT_RatepRn zT_RatepRn =  new ZT_RatepRn();
        zT_RatepRn.setZrnhknsyukigou(pZrnhknsyukigou);
        zT_RatepRn.setZrnhknsyuruikigousedaikbn(pZrnhknsyuruikigousedaikbn);
        zT_RatepRn.setZrnyoteiriritu(pZrnyoteiriritu);
        zT_RatepRn.setZrnpmenkbn(pZrnpmenkbn);
        zT_RatepRn.setZrnhrkkaisuukbn(pZrnhrkkaisuukbn);
        zT_RatepRn.setZrnhhknsei(pZrnhhknsei);
        zT_RatepRn.setZrnkeiyakujihhknnen(pZrnkeiyakujihhknnen);
        zT_RatepRn.setZrnsaimnkkykhyj(pZrnsaimnkkykhyj);
        zT_RatepRn.setZrnhknkkn(pZrnhknkkn);
        zT_RatepRn.setZrnphrkkikn(pZrnphrkkikn);
        return this.selectOne(zT_RatepRn);
    }

    public ExDBResults<ZT_RatepRn> selectAllZT_RatepRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_RatepRn qZT_RatepRn =  new QZT_RatepRn();
        jpql.append($SELECT);
        jpql.append(qZT_RatepRn);
        jpql.append($FROM);
        jpql.append(qZT_RatepRn.ZT_RatepRn());
        jpql.append($ORDER_BY(qZT_RatepRn.zrnhknsyukigou.asc(), qZT_RatepRn.zrnhknsyuruikigousedaikbn.asc(), qZT_RatepRn.zrnyoteiriritu.asc(), qZT_RatepRn.zrnpmenkbn.asc(), qZT_RatepRn.zrnhrkkaisuukbn.asc(), qZT_RatepRn.zrnhhknsei.asc(), qZT_RatepRn.zrnkeiyakujihhknnen.asc(), qZT_RatepRn.zrnsaimnkkykhyj.asc(), qZT_RatepRn.zrnhknkkn.asc(), qZT_RatepRn.zrnphrkkikn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_RatepRn).getResults();
    }
}
