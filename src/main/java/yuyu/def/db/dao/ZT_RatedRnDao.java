package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_RatedRn;
import yuyu.def.db.meta.QZT_RatedRn;

/**
 * Dレートテーブル（連）(ZT_RatedRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_RatedRnDao extends AbstractDao<ZT_RatedRn> {

    public ZT_RatedRnDao() {
        super(ZT_RatedRn.class);
    }

    public ZT_RatedRn getRatedRn(String pZrnhknsyukigou, String pZrnhknsyuruikigousedaikbn, String pZrnyoteiriritu, String pZrnpmenkbn, String pZrnhrkkaisuukbn, String pZrnhhknsei, String pZrnkeiyakujihhknnen, String pZrnsaimnkkykhyj, String pZrnhknkkn, String pZrnphrkkikn, String pZrndnendo, String pZrnnaiteikakuteikbn) {
        ZT_RatedRn zT_RatedRn =  new ZT_RatedRn();
        zT_RatedRn.setZrnhknsyukigou(pZrnhknsyukigou);
        zT_RatedRn.setZrnhknsyuruikigousedaikbn(pZrnhknsyuruikigousedaikbn);
        zT_RatedRn.setZrnyoteiriritu(pZrnyoteiriritu);
        zT_RatedRn.setZrnpmenkbn(pZrnpmenkbn);
        zT_RatedRn.setZrnhrkkaisuukbn(pZrnhrkkaisuukbn);
        zT_RatedRn.setZrnhhknsei(pZrnhhknsei);
        zT_RatedRn.setZrnkeiyakujihhknnen(pZrnkeiyakujihhknnen);
        zT_RatedRn.setZrnsaimnkkykhyj(pZrnsaimnkkykhyj);
        zT_RatedRn.setZrnhknkkn(pZrnhknkkn);
        zT_RatedRn.setZrnphrkkikn(pZrnphrkkikn);
        zT_RatedRn.setZrndnendo(pZrndnendo);
        zT_RatedRn.setZrnnaiteikakuteikbn(pZrnnaiteikakuteikbn);
        return this.selectOne(zT_RatedRn);
    }

    public ExDBResults<ZT_RatedRn> selectAllZT_RatedRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_RatedRn qZT_RatedRn =  new QZT_RatedRn();
        jpql.append($SELECT);
        jpql.append(qZT_RatedRn);
        jpql.append($FROM);
        jpql.append(qZT_RatedRn.ZT_RatedRn());
        jpql.append($ORDER_BY(qZT_RatedRn.zrnhknsyukigou.asc(), qZT_RatedRn.zrnhknsyuruikigousedaikbn.asc(), qZT_RatedRn.zrnyoteiriritu.asc(), qZT_RatedRn.zrnpmenkbn.asc(), qZT_RatedRn.zrnhrkkaisuukbn.asc(), qZT_RatedRn.zrnhhknsei.asc(), qZT_RatedRn.zrnkeiyakujihhknnen.asc(), qZT_RatedRn.zrnsaimnkkykhyj.asc(), qZT_RatedRn.zrnhknkkn.asc(), qZT_RatedRn.zrnphrkkikn.asc(), qZT_RatedRn.zrndnendo.asc(), qZT_RatedRn.zrnnaiteikakuteikbn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_RatedRn).getResults();
    }
}
