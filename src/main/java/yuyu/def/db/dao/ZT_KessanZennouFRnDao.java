package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KessanZennouFRn;
import yuyu.def.db.meta.QZT_KessanZennouFRn;

/**
 * 決算用前納Ｆテーブル（連）(ZT_KessanZennouFRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KessanZennouFRnDao extends AbstractDao<ZT_KessanZennouFRn> {

    public ZT_KessanZennouFRnDao() {
        super(ZT_KessanZennouFRn.class);
    }

    public ZT_KessanZennouFRn getKessanZennouFRn(String pZrnsyono, String pZrnkbnkeiriyousegmentcd, String pZrnzennoutoukeilistkbn, String pZrnzennoukbn) {
        ZT_KessanZennouFRn zT_KessanZennouFRn =  new ZT_KessanZennouFRn();
        zT_KessanZennouFRn.setZrnsyono(pZrnsyono);
        zT_KessanZennouFRn.setZrnkbnkeiriyousegmentcd(pZrnkbnkeiriyousegmentcd);
        zT_KessanZennouFRn.setZrnzennoutoukeilistkbn(pZrnzennoutoukeilistkbn);
        zT_KessanZennouFRn.setZrnzennoukbn(pZrnzennoukbn);
        return this.selectOne(zT_KessanZennouFRn);
    }

    public ExDBResults<ZT_KessanZennouFRn> selectAllZT_KessanZennouFRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_KessanZennouFRn qZT_KessanZennouFRn =  new QZT_KessanZennouFRn();
        jpql.append($SELECT);
        jpql.append(qZT_KessanZennouFRn);
        jpql.append($FROM);
        jpql.append(qZT_KessanZennouFRn.ZT_KessanZennouFRn());
        jpql.append($ORDER_BY(qZT_KessanZennouFRn.zrnsyono.asc(), qZT_KessanZennouFRn.zrnkbnkeiriyousegmentcd.asc(), qZT_KessanZennouFRn.zrnzennoutoukeilistkbn.asc(), qZT_KessanZennouFRn.zrnzennoukbn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KessanZennouFRn).getResults();
    }
}
