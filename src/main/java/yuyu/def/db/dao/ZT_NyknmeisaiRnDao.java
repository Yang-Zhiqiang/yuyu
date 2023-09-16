package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_NyknmeisaiRn;
import yuyu.def.db.meta.QZT_NyknmeisaiRn;

/**
 * 入出金明細テーブル（連）(ZT_NyknmeisaiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_NyknmeisaiRnDao extends AbstractDao<ZT_NyknmeisaiRn> {

    public ZT_NyknmeisaiRnDao() {
        super(ZT_NyknmeisaiRn.class);
    }

    public ZT_NyknmeisaiRn getNyknmeisaiRn(String pZrnsakuseiymd6keta, String pZrnbankcd, String pZrnshitencd, String pZrnyokinkbn, String pZrnkouzano, String pZrnsyoukaino, String pZrnrenno8) {
        ZT_NyknmeisaiRn zT_NyknmeisaiRn =  new ZT_NyknmeisaiRn();
        zT_NyknmeisaiRn.setZrnsakuseiymd6keta(pZrnsakuseiymd6keta);
        zT_NyknmeisaiRn.setZrnbankcd(pZrnbankcd);
        zT_NyknmeisaiRn.setZrnshitencd(pZrnshitencd);
        zT_NyknmeisaiRn.setZrnyokinkbn(pZrnyokinkbn);
        zT_NyknmeisaiRn.setZrnkouzano(pZrnkouzano);
        zT_NyknmeisaiRn.setZrnsyoukaino(pZrnsyoukaino);
        zT_NyknmeisaiRn.setZrnsyoukaino(pZrnrenno8);
        return this.selectOne(zT_NyknmeisaiRn);
    }

    public ExDBResults<ZT_NyknmeisaiRn> selectAllZT_NyknmeisaiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_NyknmeisaiRn qZT_NyknmeisaiRn =  new QZT_NyknmeisaiRn();
        jpql.append($SELECT);
        jpql.append(qZT_NyknmeisaiRn);
        jpql.append($FROM);
        jpql.append(qZT_NyknmeisaiRn.ZT_NyknmeisaiRn());
        jpql.append($ORDER_BY(qZT_NyknmeisaiRn.zrnsakuseiymd6keta.asc(), qZT_NyknmeisaiRn.zrnbankcd.asc(), qZT_NyknmeisaiRn.zrnshitencd.asc(), qZT_NyknmeisaiRn.zrnyokinkbn.asc(), qZT_NyknmeisaiRn.zrnkouzano.asc(), qZT_NyknmeisaiRn.zrnsyoukaino.asc(), qZT_NyknmeisaiRn.zrnrenno8.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_NyknmeisaiRn).getResults();
    }
}
