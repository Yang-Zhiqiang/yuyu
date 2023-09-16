package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_RatevRn;
import yuyu.def.db.meta.QZT_RatevRn;

/**
 * Ｖレートテーブル（連）(ZT_RatevRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_RatevRnDao extends AbstractDao<ZT_RatevRn> {

    public ZT_RatevRnDao() {
        super(ZT_RatevRn.class);
    }

    public ZT_RatevRn getRatevRn(String pZrnhknsyukigou, String pZrnhknsyuruikigousedaikbn, String pZrnyoteiriritu, String pZrnpmenkbn, String pZrnhrkkaisuukbn, String pZrnhhknsei, String pZrnkeiyakujihhknnen, String pZrnsaimnkkykhyj, String pZrnhknkkn, String pZrnphrkkikn) {
        ZT_RatevRn zT_RatevRn =  new ZT_RatevRn();
        zT_RatevRn.setZrnhknsyukigou(pZrnhknsyukigou);
        zT_RatevRn.setZrnhknsyuruikigousedaikbn(pZrnhknsyuruikigousedaikbn);
        zT_RatevRn.setZrnyoteiriritu(pZrnyoteiriritu);
        zT_RatevRn.setZrnpmenkbn(pZrnpmenkbn);
        zT_RatevRn.setZrnhrkkaisuukbn(pZrnhrkkaisuukbn);
        zT_RatevRn.setZrnhhknsei(pZrnhhknsei);
        zT_RatevRn.setZrnkeiyakujihhknnen(pZrnkeiyakujihhknnen);
        zT_RatevRn.setZrnsaimnkkykhyj(pZrnsaimnkkykhyj);
        zT_RatevRn.setZrnhknkkn(pZrnhknkkn);
        zT_RatevRn.setZrnphrkkikn(pZrnphrkkikn);
        return this.selectOne(zT_RatevRn);
    }

    public ExDBResults<ZT_RatevRn> selectAllZT_RatevRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_RatevRn qZT_RatevRn =  new QZT_RatevRn();
        jpql.append($SELECT);
        jpql.append(qZT_RatevRn);
        jpql.append($FROM);
        jpql.append(qZT_RatevRn.ZT_RatevRn());
        jpql.append($ORDER_BY(qZT_RatevRn.zrnhknsyukigou.asc(), qZT_RatevRn.zrnhknsyuruikigousedaikbn.asc(), qZT_RatevRn.zrnyoteiriritu.asc(), qZT_RatevRn.zrnpmenkbn.asc(), qZT_RatevRn.zrnhrkkaisuukbn.asc(), qZT_RatevRn.zrnhhknsei.asc(), qZT_RatevRn.zrnkeiyakujihhknnen.asc(), qZT_RatevRn.zrnsaimnkkykhyj.asc(), qZT_RatevRn.zrnhknkkn.asc(), qZT_RatevRn.zrnphrkkikn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_RatevRn).getResults();
    }
}
