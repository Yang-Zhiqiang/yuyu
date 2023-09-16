package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_OnlineGknyknmeisaiRn;
import yuyu.def.db.meta.QZT_OnlineGknyknmeisaiRn;

/**
 * オンライン外貨入出金明細テーブル（連）(ZT_OnlineGknyknmeisaiRn) アクセス用の DAO クラスです。<br />
 */
public class ZT_OnlineGknyknmeisaiRnDao extends AbstractDao<ZT_OnlineGknyknmeisaiRn> {

    public ZT_OnlineGknyknmeisaiRnDao() {
        super(ZT_OnlineGknyknmeisaiRn.class);
    }

    public ZT_OnlineGknyknmeisaiRn getOnlineGknyknmeisaiRn(String pZrnsakuseiymd, String pZrnrenrakuymd, String pZrnrenrakukaisuu, String pZrnbankcd, String pZrnshitencd, String pZrnyokinkbn, String pZrnkouzano, String pZrnzndktuukasyu, String pZrnsyorino1) {
        ZT_OnlineGknyknmeisaiRn zT_GknyknmeisaiRn =  new ZT_OnlineGknyknmeisaiRn();
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

    public ExDBResults<ZT_OnlineGknyknmeisaiRn> selectAllZT_OnlineGknyknmeisaiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_OnlineGknyknmeisaiRn qZT_OnlineGknyknmeisaiRn =  new QZT_OnlineGknyknmeisaiRn();
        jpql.append($SELECT);
        jpql.append(qZT_OnlineGknyknmeisaiRn);
        jpql.append($FROM);
        jpql.append(qZT_OnlineGknyknmeisaiRn.ZT_OnlineGknyknmeisaiRn());
        jpql.append($ORDER_BY(qZT_OnlineGknyknmeisaiRn.zrnsakuseiymd.asc(), qZT_OnlineGknyknmeisaiRn.zrnrenrakuymd.asc(), qZT_OnlineGknyknmeisaiRn.zrnrenrakukaisuu.asc(), qZT_OnlineGknyknmeisaiRn.zrnbankcd.asc(), qZT_OnlineGknyknmeisaiRn.zrnshitencd.asc(), qZT_OnlineGknyknmeisaiRn.zrnyokinkbn.asc(), qZT_OnlineGknyknmeisaiRn.zrnkouzano.asc(), qZT_OnlineGknyknmeisaiRn.zrnzndktuukasyu.asc(), qZT_OnlineGknyknmeisaiRn.zrnsyorino1.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_OnlineGknyknmeisaiRn).getResults();
    }
}
