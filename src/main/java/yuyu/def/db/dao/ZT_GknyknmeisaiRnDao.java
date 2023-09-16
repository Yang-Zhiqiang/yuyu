package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_GknyknmeisaiRn;
import yuyu.def.db.meta.QZT_GknyknmeisaiRn;

/**
 * 外貨入出金明細テーブル（連）(ZT_GknyknmeisaiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_GknyknmeisaiRnDao extends AbstractDao<ZT_GknyknmeisaiRn> {

    public ZT_GknyknmeisaiRnDao() {
        super(ZT_GknyknmeisaiRn.class);
    }

    public ZT_GknyknmeisaiRn getGknyknmeisaiRn(String pZrnsakuseiymd, String pZrnrenrakuymd, String pZrnrenrakukaisuu, String pZrnbankcd, String pZrnshitencd, String pZrnyokinkbn, String pZrnkouzano, String pZrnzndktuukasyu, String pZrnsyorino1) {
        ZT_GknyknmeisaiRn zT_GknyknmeisaiRn =  new ZT_GknyknmeisaiRn();
        zT_GknyknmeisaiRn.setZrnsakuseiymd(pZrnsakuseiymd);
        zT_GknyknmeisaiRn.setZrnrenrakuymd(pZrnrenrakuymd);
        zT_GknyknmeisaiRn.setZrnrenrakukaisuu(pZrnrenrakukaisuu);
        zT_GknyknmeisaiRn.setZrnbankcd(pZrnbankcd);
        zT_GknyknmeisaiRn.setZrnshitencd(pZrnshitencd);
        zT_GknyknmeisaiRn.setZrnyokinkbn(pZrnyokinkbn);
        zT_GknyknmeisaiRn.setZrnkouzano(pZrnkouzano);
        zT_GknyknmeisaiRn.setZrnzndktuukasyu(pZrnzndktuukasyu);
        zT_GknyknmeisaiRn.setZrnsyorino1(pZrnsyorino1);
        return this.selectOne(zT_GknyknmeisaiRn);
    }

    public ExDBResults<ZT_GknyknmeisaiRn> selectAllZT_GknyknmeisaiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_GknyknmeisaiRn qZT_GknyknmeisaiRn =  new QZT_GknyknmeisaiRn();
        jpql.append($SELECT);
        jpql.append(qZT_GknyknmeisaiRn);
        jpql.append($FROM);
        jpql.append(qZT_GknyknmeisaiRn.ZT_GknyknmeisaiRn());
        jpql.append($ORDER_BY(qZT_GknyknmeisaiRn.zrnsakuseiymd.asc(), qZT_GknyknmeisaiRn.zrnrenrakuymd.asc(), qZT_GknyknmeisaiRn.zrnrenrakukaisuu.asc(), qZT_GknyknmeisaiRn.zrnbankcd.asc(), qZT_GknyknmeisaiRn.zrnshitencd.asc(), qZT_GknyknmeisaiRn.zrnyokinkbn.asc(), qZT_GknyknmeisaiRn.zrnkouzano.asc(), qZT_GknyknmeisaiRn.zrnzndktuukasyu.asc(), qZT_GknyknmeisaiRn.zrnsyorino1.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_GknyknmeisaiRn).getResults();
    }
}
