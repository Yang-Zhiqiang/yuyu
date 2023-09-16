package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_Ratev2Rn;
import yuyu.def.db.meta.QZT_Ratev2Rn;

/**
 * Ｖレートテーブル２（連）(ZT_Ratev2RnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_Ratev2RnDao extends AbstractDao<ZT_Ratev2Rn> {

    public ZT_Ratev2RnDao() {
        super(ZT_Ratev2Rn.class);
    }

    public ZT_Ratev2Rn getRatev2Rn(String pZrnhknsyukigou, String pZrnhknsyuruikigousedaikbn, String pZrnyoteiriritu, String pZrnpmenkbn, String pZrnhrkkaisuukbn, String pZrnhhknsei, String pZrnkeiyakujihhknnen, String pZrnsaimnkkykhyj, String pZrnhknkkn, String pZrnphrkkikn, String pZrnannaifuyouriyuukbn, String pZrntuukasyukbn, String pZrndai1hknkkn) {
        ZT_Ratev2Rn zT_Ratev2Rn =  new ZT_Ratev2Rn();
        zT_Ratev2Rn.setZrnhknsyukigou(pZrnhknsyukigou);
        zT_Ratev2Rn.setZrnhknsyuruikigousedaikbn(pZrnhknsyuruikigousedaikbn);
        zT_Ratev2Rn.setZrnyoteiriritu(pZrnyoteiriritu);
        zT_Ratev2Rn.setZrnpmenkbn(pZrnpmenkbn);
        zT_Ratev2Rn.setZrnhrkkaisuukbn(pZrnhrkkaisuukbn);
        zT_Ratev2Rn.setZrnhhknsei(pZrnhhknsei);
        zT_Ratev2Rn.setZrnkeiyakujihhknnen(pZrnkeiyakujihhknnen);
        zT_Ratev2Rn.setZrnsaimnkkykhyj(pZrnsaimnkkykhyj);
        zT_Ratev2Rn.setZrnhknkkn(pZrnhknkkn);
        zT_Ratev2Rn.setZrnphrkkikn(pZrnphrkkikn);
        zT_Ratev2Rn.setZrnannaifuyouriyuukbn(pZrnannaifuyouriyuukbn);
        zT_Ratev2Rn.setZrntuukasyukbn(pZrntuukasyukbn);
        zT_Ratev2Rn.setZrndai1hknkkn(pZrndai1hknkkn);
        return this.selectOne(zT_Ratev2Rn);
    }

    public ExDBResults<ZT_Ratev2Rn> selectAllZT_Ratev2Rn() {
        StringBuilder jpql = new StringBuilder();
        QZT_Ratev2Rn qZT_Ratev2Rn =  new QZT_Ratev2Rn();
        jpql.append($SELECT);
        jpql.append(qZT_Ratev2Rn);
        jpql.append($FROM);
        jpql.append(qZT_Ratev2Rn.ZT_Ratev2Rn());
        jpql.append($ORDER_BY(qZT_Ratev2Rn.zrnhknsyukigou.asc(), qZT_Ratev2Rn.zrnhknsyuruikigousedaikbn.asc(), qZT_Ratev2Rn.zrnyoteiriritu.asc(), qZT_Ratev2Rn.zrnpmenkbn.asc(), qZT_Ratev2Rn.zrnhrkkaisuukbn.asc(), qZT_Ratev2Rn.zrnhhknsei.asc(), qZT_Ratev2Rn.zrnkeiyakujihhknnen.asc(), qZT_Ratev2Rn.zrnsaimnkkykhyj.asc(), qZT_Ratev2Rn.zrnhknkkn.asc(), qZT_Ratev2Rn.zrnphrkkikn.asc(), qZT_Ratev2Rn.zrnannaifuyouriyuukbn.asc(), qZT_Ratev2Rn.zrntuukasyukbn.asc(), qZT_Ratev2Rn.zrndai1hknkkn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_Ratev2Rn).getResults();
    }
}
