package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_RisaHitSyouhnyouRated2Rn;
import yuyu.def.db.meta.QZT_RisaHitSyouhnyouRated2Rn;

/**
 * 利差配当商品用Ｄレートテーブル２（連）(ZT_RisaHitSyouhnyouRated2RnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_RisaHitSyouhnyouRated2RnDao extends AbstractDao<ZT_RisaHitSyouhnyouRated2Rn> {

    public ZT_RisaHitSyouhnyouRated2RnDao() {
        super(ZT_RisaHitSyouhnyouRated2Rn.class);
    }

    public ZT_RisaHitSyouhnyouRated2Rn getRisaHitSyouhnyouRated2Rn(String pZrnhknsyukigou, String pZrnhknsyuruikigousedaikbn, String pZrnyoteiriritu, String pZrnpmenkbn, String pZrnhrkkaisuukbn, String pZrnhhknsei, String pZrnkeiyakujihhknnen, String pZrnsaimnkkykhyj, String pZrnhknkkn, String pZrnphrkkikn, String pZrnannaifuyouriyuukbn, String pZrntuukasyukbn, String pZrndai1hknkkn, String pZrndnendo, String pZrnnaiteikakuteikbn) {
        ZT_RisaHitSyouhnyouRated2Rn zT_RisaHitSyouhnyouRated2Rn =  new ZT_RisaHitSyouhnyouRated2Rn();
        zT_RisaHitSyouhnyouRated2Rn.setZrnhknsyukigou(pZrnhknsyukigou);
        zT_RisaHitSyouhnyouRated2Rn.setZrnhknsyuruikigousedaikbn(pZrnhknsyuruikigousedaikbn);
        zT_RisaHitSyouhnyouRated2Rn.setZrnyoteiriritu(pZrnyoteiriritu);
        zT_RisaHitSyouhnyouRated2Rn.setZrnpmenkbn(pZrnpmenkbn);
        zT_RisaHitSyouhnyouRated2Rn.setZrnhrkkaisuukbn(pZrnhrkkaisuukbn);
        zT_RisaHitSyouhnyouRated2Rn.setZrnhhknsei(pZrnhhknsei);
        zT_RisaHitSyouhnyouRated2Rn.setZrnkeiyakujihhknnen(pZrnkeiyakujihhknnen);
        zT_RisaHitSyouhnyouRated2Rn.setZrnsaimnkkykhyj(pZrnsaimnkkykhyj);
        zT_RisaHitSyouhnyouRated2Rn.setZrnhknkkn(pZrnhknkkn);
        zT_RisaHitSyouhnyouRated2Rn.setZrnphrkkikn(pZrnphrkkikn);
        zT_RisaHitSyouhnyouRated2Rn.setZrnannaifuyouriyuukbn(pZrnannaifuyouriyuukbn);
        zT_RisaHitSyouhnyouRated2Rn.setZrntuukasyukbn(pZrntuukasyukbn);
        zT_RisaHitSyouhnyouRated2Rn.setZrndai1hknkkn(pZrndai1hknkkn);
        zT_RisaHitSyouhnyouRated2Rn.setZrndnendo(pZrndnendo);
        zT_RisaHitSyouhnyouRated2Rn.setZrnnaiteikakuteikbn(pZrnnaiteikakuteikbn);
        return this.selectOne(zT_RisaHitSyouhnyouRated2Rn);
    }

    public ExDBResults<ZT_RisaHitSyouhnyouRated2Rn> selectAllZT_RisaHitSyouhnyouRated2Rn() {
        StringBuilder jpql = new StringBuilder();
        QZT_RisaHitSyouhnyouRated2Rn qZT_RisaHitSyouhnyouRated2Rn =  new QZT_RisaHitSyouhnyouRated2Rn();
        jpql.append($SELECT);
        jpql.append(qZT_RisaHitSyouhnyouRated2Rn);
        jpql.append($FROM);
        jpql.append(qZT_RisaHitSyouhnyouRated2Rn.ZT_RisaHitSyouhnyouRated2Rn());
        jpql.append($ORDER_BY(qZT_RisaHitSyouhnyouRated2Rn.zrnhknsyukigou.asc(), qZT_RisaHitSyouhnyouRated2Rn.zrnhknsyuruikigousedaikbn.asc(), qZT_RisaHitSyouhnyouRated2Rn.zrnyoteiriritu.asc(), qZT_RisaHitSyouhnyouRated2Rn.zrnpmenkbn.asc(), qZT_RisaHitSyouhnyouRated2Rn.zrnhrkkaisuukbn.asc(), qZT_RisaHitSyouhnyouRated2Rn.zrnhhknsei.asc(), qZT_RisaHitSyouhnyouRated2Rn.zrnkeiyakujihhknnen.asc(), qZT_RisaHitSyouhnyouRated2Rn.zrnsaimnkkykhyj.asc(), qZT_RisaHitSyouhnyouRated2Rn.zrnhknkkn.asc(), qZT_RisaHitSyouhnyouRated2Rn.zrnphrkkikn.asc(), qZT_RisaHitSyouhnyouRated2Rn.zrnannaifuyouriyuukbn.asc(), qZT_RisaHitSyouhnyouRated2Rn.zrntuukasyukbn.asc(), qZT_RisaHitSyouhnyouRated2Rn.zrndai1hknkkn.asc(), qZT_RisaHitSyouhnyouRated2Rn.zrndnendo.asc(), qZT_RisaHitSyouhnyouRated2Rn.zrnnaiteikakuteikbn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_RisaHitSyouhnyouRated2Rn).getResults();
    }
}
