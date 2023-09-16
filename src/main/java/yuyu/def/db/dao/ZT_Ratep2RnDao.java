package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_Ratep2Rn;
import yuyu.def.db.meta.QZT_Ratep2Rn;

/**
 * Ｐレートテーブル２（連）(ZT_Ratep2RnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_Ratep2RnDao extends AbstractDao<ZT_Ratep2Rn> {

    public ZT_Ratep2RnDao() {
        super(ZT_Ratep2Rn.class);
    }

    public ZT_Ratep2Rn getRatep2Rn(String pZrnhknsyukigou, String pZrnhknsyuruikigousedaikbn, String pZrnyoteiriritu, String pZrnpmenkbn, String pZrnhrkkaisuukbn, String pZrnhhknsei, String pZrnkeiyakujihhknnen, String pZrnsaimnkkykhyj, String pZrnhknkkn, String pZrnphrkkikn, String pZrnannaifuyouriyuukbn, String pZrntuukasyukbn, String pZrndai1hknkkn, String pZrnryouritukbn) {
        ZT_Ratep2Rn zT_Ratep2Rn =  new ZT_Ratep2Rn();
        zT_Ratep2Rn.setZrnhknsyukigou(pZrnhknsyukigou);
        zT_Ratep2Rn.setZrnhknsyuruikigousedaikbn(pZrnhknsyuruikigousedaikbn);
        zT_Ratep2Rn.setZrnyoteiriritu(pZrnyoteiriritu);
        zT_Ratep2Rn.setZrnpmenkbn(pZrnpmenkbn);
        zT_Ratep2Rn.setZrnhrkkaisuukbn(pZrnhrkkaisuukbn);
        zT_Ratep2Rn.setZrnhhknsei(pZrnhhknsei);
        zT_Ratep2Rn.setZrnkeiyakujihhknnen(pZrnkeiyakujihhknnen);
        zT_Ratep2Rn.setZrnsaimnkkykhyj(pZrnsaimnkkykhyj);
        zT_Ratep2Rn.setZrnhknkkn(pZrnhknkkn);
        zT_Ratep2Rn.setZrnphrkkikn(pZrnphrkkikn);
        zT_Ratep2Rn.setZrnannaifuyouriyuukbn(pZrnannaifuyouriyuukbn);
        zT_Ratep2Rn.setZrntuukasyukbn(pZrntuukasyukbn);
        zT_Ratep2Rn.setZrndai1hknkkn(pZrndai1hknkkn);
        zT_Ratep2Rn.setZrnryouritukbn(pZrnryouritukbn);
        return this.selectOne(zT_Ratep2Rn);
    }

    public ExDBResults<ZT_Ratep2Rn> selectAllZT_Ratep2Rn() {
        StringBuilder jpql = new StringBuilder();
        QZT_Ratep2Rn qZT_Ratep2Rn =  new QZT_Ratep2Rn();
        jpql.append($SELECT);
        jpql.append(qZT_Ratep2Rn);
        jpql.append($FROM);
        jpql.append(qZT_Ratep2Rn.ZT_Ratep2Rn());
        jpql.append($ORDER_BY(qZT_Ratep2Rn.zrnhknsyukigou.asc(), qZT_Ratep2Rn.zrnhknsyuruikigousedaikbn.asc(), qZT_Ratep2Rn.zrnyoteiriritu.asc(), qZT_Ratep2Rn.zrnpmenkbn.asc(), qZT_Ratep2Rn.zrnhrkkaisuukbn.asc(), qZT_Ratep2Rn.zrnhhknsei.asc(), qZT_Ratep2Rn.zrnkeiyakujihhknnen.asc(), qZT_Ratep2Rn.zrnsaimnkkykhyj.asc(), qZT_Ratep2Rn.zrnhknkkn.asc(), qZT_Ratep2Rn.zrnphrkkikn.asc(), qZT_Ratep2Rn.zrnannaifuyouriyuukbn.asc(), qZT_Ratep2Rn.zrntuukasyukbn.asc(), qZT_Ratep2Rn.zrndai1hknkkn.asc(), qZT_Ratep2Rn.zrnryouritukbn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_Ratep2Rn).getResults();
    }
}
