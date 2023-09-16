package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KessanZennouFTy;
import yuyu.def.db.meta.QZT_KessanZennouFTy;

/**
 * 決算用前納Ｆテーブル（中）(ZT_KessanZennouFTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KessanZennouFTyDao extends AbstractDao<ZT_KessanZennouFTy> {

    public ZT_KessanZennouFTyDao() {
        super(ZT_KessanZennouFTy.class);
    }

    public ZT_KessanZennouFTy getKessanZennouFTy(String pZtysyono, String pZtykbnkeiriyousegmentcd, String pZtyzennoutoukeilistkbn, String pZtyzennoukbn) {
        ZT_KessanZennouFTy zT_KessanZennouFTy =  new ZT_KessanZennouFTy();
        zT_KessanZennouFTy.setZtysyono(pZtysyono);
        zT_KessanZennouFTy.setZtykbnkeiriyousegmentcd(pZtykbnkeiriyousegmentcd);
        zT_KessanZennouFTy.setZtyzennoutoukeilistkbn(pZtyzennoutoukeilistkbn);
        zT_KessanZennouFTy.setZtyzennoukbn(pZtyzennoukbn);
        return this.selectOne(zT_KessanZennouFTy);
    }

    public ExDBResults<ZT_KessanZennouFTy> selectAllZT_KessanZennouFTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_KessanZennouFTy qZT_KessanZennouFTy =  new QZT_KessanZennouFTy();
        jpql.append($SELECT);
        jpql.append(qZT_KessanZennouFTy);
        jpql.append($FROM);
        jpql.append(qZT_KessanZennouFTy.ZT_KessanZennouFTy());
        jpql.append($ORDER_BY(qZT_KessanZennouFTy.ztysyono.asc(), qZT_KessanZennouFTy.ztykbnkeiriyousegmentcd.asc(), qZT_KessanZennouFTy.ztyzennoutoukeilistkbn.asc(), qZT_KessanZennouFTy.ztyzennoukbn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KessanZennouFTy).getResults();
    }
}
