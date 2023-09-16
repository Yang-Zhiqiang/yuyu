package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_FurikaeDenpyouTy;
import yuyu.def.db.meta.QZT_FurikaeDenpyouTy;

/**
 * 振替伝票テーブル（中）(ZT_FurikaeDenpyouTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_FurikaeDenpyouTyDao extends AbstractDao<ZT_FurikaeDenpyouTy> {

    public ZT_FurikaeDenpyouTyDao() {
        super(ZT_FurikaeDenpyouTy.class);
    }

    public ZT_FurikaeDenpyouTy getFurikaeDenpyouTy(String pZtytorihikinoc8, String pZtytorihikinoedano, String pZtytorihikiymdgengokbn, String pZtytorihikinen, String pZtytorihikituki, String pZtytorihikibi) {
        ZT_FurikaeDenpyouTy zT_FurikaeDenpyouTy =  new ZT_FurikaeDenpyouTy();
        zT_FurikaeDenpyouTy.setZtytorihikinoc8(pZtytorihikinoc8);
        zT_FurikaeDenpyouTy.setZtytorihikinoedano(pZtytorihikinoedano);
        zT_FurikaeDenpyouTy.setZtytorihikiymdgengokbn(pZtytorihikiymdgengokbn);
        zT_FurikaeDenpyouTy.setZtytorihikinen(pZtytorihikinen);
        zT_FurikaeDenpyouTy.setZtytorihikituki(pZtytorihikituki);
        zT_FurikaeDenpyouTy.setZtytorihikibi(pZtytorihikibi);
        return this.selectOne(zT_FurikaeDenpyouTy);
    }

    public ExDBResults<ZT_FurikaeDenpyouTy> selectAllZT_FurikaeDenpyouTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_FurikaeDenpyouTy qZT_FurikaeDenpyouTy =  new QZT_FurikaeDenpyouTy();
        jpql.append($SELECT);
        jpql.append(qZT_FurikaeDenpyouTy);
        jpql.append($FROM);
        jpql.append(qZT_FurikaeDenpyouTy.ZT_FurikaeDenpyouTy());
        jpql.append($ORDER_BY(qZT_FurikaeDenpyouTy.ztytorihikinoc8.asc(), qZT_FurikaeDenpyouTy.ztytorihikinoedano.asc(), qZT_FurikaeDenpyouTy.ztytorihikiymdgengokbn.asc(), qZT_FurikaeDenpyouTy.ztytorihikinen.asc(), qZT_FurikaeDenpyouTy.ztytorihikituki.asc(), qZT_FurikaeDenpyouTy.ztytorihikibi.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_FurikaeDenpyouTy).getResults();
    }
}
