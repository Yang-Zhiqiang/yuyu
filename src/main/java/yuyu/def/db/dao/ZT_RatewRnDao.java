package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_RatewRn;
import yuyu.def.db.meta.QZT_RatewRn;

/**
 * Ｗレートテーブル（連）(ZT_RatewRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_RatewRnDao extends AbstractDao<ZT_RatewRn> {

    public ZT_RatewRnDao() {
        super(ZT_RatewRn.class);
    }

    public ZT_RatewRn getRatewRn(String pZrnhknsyukigou, String pZrnhknsyuruikigousedaikbn, String pZrnyoteiriritu, String pZrnpmenkbn, String pZrnhrkkaisuukbn, String pZrnhhknsei, String pZrnkeiyakujihhknnen, String pZrnsaimnkkykhyj, String pZrnhknkkn, String pZrnphrkkikn, String pZrnannaifuyouriyuukbn, String pZrntuukasyukbn, String pZrndai1hknkkn) {
        ZT_RatewRn zT_RatewRn =  new ZT_RatewRn();
        zT_RatewRn.setZrnhknsyukigou(pZrnhknsyukigou);
        zT_RatewRn.setZrnhknsyuruikigousedaikbn(pZrnhknsyuruikigousedaikbn);
        zT_RatewRn.setZrnyoteiriritu(pZrnyoteiriritu);
        zT_RatewRn.setZrnpmenkbn(pZrnpmenkbn);
        zT_RatewRn.setZrnhrkkaisuukbn(pZrnhrkkaisuukbn);
        zT_RatewRn.setZrnhhknsei(pZrnhhknsei);
        zT_RatewRn.setZrnkeiyakujihhknnen(pZrnkeiyakujihhknnen);
        zT_RatewRn.setZrnsaimnkkykhyj(pZrnsaimnkkykhyj);
        zT_RatewRn.setZrnhknkkn(pZrnhknkkn);
        zT_RatewRn.setZrnphrkkikn(pZrnphrkkikn);
        zT_RatewRn.setZrnannaifuyouriyuukbn(pZrnannaifuyouriyuukbn);
        zT_RatewRn.setZrntuukasyukbn(pZrntuukasyukbn);
        zT_RatewRn.setZrndai1hknkkn(pZrndai1hknkkn);
        return this.selectOne(zT_RatewRn);
    }

    public ExDBResults<ZT_RatewRn> selectAllZT_RatewRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_RatewRn qZT_RatewRn =  new QZT_RatewRn();
        jpql.append($SELECT);
        jpql.append(qZT_RatewRn);
        jpql.append($FROM);
        jpql.append(qZT_RatewRn.ZT_RatewRn());
        jpql.append($ORDER_BY(qZT_RatewRn.zrnhknsyukigou.asc(), qZT_RatewRn.zrnhknsyuruikigousedaikbn.asc(), qZT_RatewRn.zrnyoteiriritu.asc(), qZT_RatewRn.zrnpmenkbn.asc(), qZT_RatewRn.zrnhrkkaisuukbn.asc(), qZT_RatewRn.zrnhhknsei.asc(), qZT_RatewRn.zrnkeiyakujihhknnen.asc(), qZT_RatewRn.zrnsaimnkkykhyj.asc(), qZT_RatewRn.zrnhknkkn.asc(), qZT_RatewRn.zrnphrkkikn.asc(), qZT_RatewRn.zrnannaifuyouriyuukbn.asc(), qZT_RatewRn.zrntuukasyukbn.asc(), qZT_RatewRn.zrndai1hknkkn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_RatewRn).getResults();
    }
}
