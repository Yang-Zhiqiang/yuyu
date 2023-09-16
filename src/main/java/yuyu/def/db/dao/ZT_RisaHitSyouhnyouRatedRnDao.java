package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_RisaHitSyouhnyouRatedRn;
import yuyu.def.db.meta.QZT_RisaHitSyouhnyouRatedRn;

/**
 * 利差配当商品用Ｄレートテーブル（連）(ZT_RisaHitSyouhnyouRatedRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_RisaHitSyouhnyouRatedRnDao extends AbstractDao<ZT_RisaHitSyouhnyouRatedRn> {

    public ZT_RisaHitSyouhnyouRatedRnDao() {
        super(ZT_RisaHitSyouhnyouRatedRn.class);
    }

    public ZT_RisaHitSyouhnyouRatedRn getRisaHitSyouhnyouRatedRn(String pZrnhknsyukigou, String pZrnhknsyuruikigousedaikbn, String pZrnyoteiriritu, String pZrnpmenkbn, String pZrnhrkkaisuukbn, String pZrnhhknsei, String pZrnkeiyakujihhknnen, String pZrnsaimnkkykhyj, String pZrnhknkkn, String pZrnphrkkikn, String pZrndnendo, String pZrnnaiteikakuteikbn) {
        ZT_RisaHitSyouhnyouRatedRn zT_RisaHitSyouhnyouRatedRn =  new ZT_RisaHitSyouhnyouRatedRn();
        zT_RisaHitSyouhnyouRatedRn.setZrnhknsyukigou(pZrnhknsyukigou);
        zT_RisaHitSyouhnyouRatedRn.setZrnhknsyuruikigousedaikbn(pZrnhknsyuruikigousedaikbn);
        zT_RisaHitSyouhnyouRatedRn.setZrnyoteiriritu(pZrnyoteiriritu);
        zT_RisaHitSyouhnyouRatedRn.setZrnpmenkbn(pZrnpmenkbn);
        zT_RisaHitSyouhnyouRatedRn.setZrnhrkkaisuukbn(pZrnhrkkaisuukbn);
        zT_RisaHitSyouhnyouRatedRn.setZrnhhknsei(pZrnhhknsei);
        zT_RisaHitSyouhnyouRatedRn.setZrnkeiyakujihhknnen(pZrnkeiyakujihhknnen);
        zT_RisaHitSyouhnyouRatedRn.setZrnsaimnkkykhyj(pZrnsaimnkkykhyj);
        zT_RisaHitSyouhnyouRatedRn.setZrnhknkkn(pZrnhknkkn);
        zT_RisaHitSyouhnyouRatedRn.setZrnphrkkikn(pZrnphrkkikn);
        zT_RisaHitSyouhnyouRatedRn.setZrndnendo(pZrndnendo);
        zT_RisaHitSyouhnyouRatedRn.setZrnnaiteikakuteikbn(pZrnnaiteikakuteikbn);
        return this.selectOne(zT_RisaHitSyouhnyouRatedRn);
    }

    public ExDBResults<ZT_RisaHitSyouhnyouRatedRn> selectAllZT_RisaHitSyouhnyouRatedRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_RisaHitSyouhnyouRatedRn qZT_RisaHitSyouhnyouRatedRn =  new QZT_RisaHitSyouhnyouRatedRn();
        jpql.append($SELECT);
        jpql.append(qZT_RisaHitSyouhnyouRatedRn);
        jpql.append($FROM);
        jpql.append(qZT_RisaHitSyouhnyouRatedRn.ZT_RisaHitSyouhnyouRatedRn());
        jpql.append($ORDER_BY(qZT_RisaHitSyouhnyouRatedRn.zrnhknsyukigou.asc(), qZT_RisaHitSyouhnyouRatedRn.zrnhknsyuruikigousedaikbn.asc(), qZT_RisaHitSyouhnyouRatedRn.zrnyoteiriritu.asc(), qZT_RisaHitSyouhnyouRatedRn.zrnpmenkbn.asc(), qZT_RisaHitSyouhnyouRatedRn.zrnhrkkaisuukbn.asc(), qZT_RisaHitSyouhnyouRatedRn.zrnhhknsei.asc(), qZT_RisaHitSyouhnyouRatedRn.zrnkeiyakujihhknnen.asc(), qZT_RisaHitSyouhnyouRatedRn.zrnsaimnkkykhyj.asc(), qZT_RisaHitSyouhnyouRatedRn.zrnhknkkn.asc(), qZT_RisaHitSyouhnyouRatedRn.zrnphrkkikn.asc(), qZT_RisaHitSyouhnyouRatedRn.zrndnendo.asc(), qZT_RisaHitSyouhnyouRatedRn.zrnnaiteikakuteikbn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_RisaHitSyouhnyouRatedRn).getResults();
    }
}
