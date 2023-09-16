package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SkFurikaeDenpyouTy;
import yuyu.def.db.meta.QZT_SkFurikaeDenpyouTy;

/**
 * 新契約振替伝票テーブル（中）(ZT_SkFurikaeDenpyouTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SkFurikaeDenpyouTyDao extends AbstractDao<ZT_SkFurikaeDenpyouTy> {

    public ZT_SkFurikaeDenpyouTyDao() {
        super(ZT_SkFurikaeDenpyouTy.class);
    }

    public ZT_SkFurikaeDenpyouTy getSkFurikaeDenpyouTy(String pZtytorihikinoc8, String pZtytorihikinoedano, String pZtytorihikiymdgengokbn, String pZtytorihikinen, String pZtytorihikituki, String pZtytorihikibi) {
        ZT_SkFurikaeDenpyouTy zT_SkFurikaeDenpyouTy =  new ZT_SkFurikaeDenpyouTy();
        zT_SkFurikaeDenpyouTy.setZtytorihikinoc8(pZtytorihikinoc8);
        zT_SkFurikaeDenpyouTy.setZtytorihikinoedano(pZtytorihikinoedano);
        zT_SkFurikaeDenpyouTy.setZtytorihikiymdgengokbn(pZtytorihikiymdgengokbn);
        zT_SkFurikaeDenpyouTy.setZtytorihikinen(pZtytorihikinen);
        zT_SkFurikaeDenpyouTy.setZtytorihikituki(pZtytorihikituki);
        zT_SkFurikaeDenpyouTy.setZtytorihikibi(pZtytorihikibi);
        return this.selectOne(zT_SkFurikaeDenpyouTy);
    }

    public ExDBResults<ZT_SkFurikaeDenpyouTy> selectAllZT_SkFurikaeDenpyouTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SkFurikaeDenpyouTy qZT_SkFurikaeDenpyouTy =  new QZT_SkFurikaeDenpyouTy();
        jpql.append($SELECT);
        jpql.append(qZT_SkFurikaeDenpyouTy);
        jpql.append($FROM);
        jpql.append(qZT_SkFurikaeDenpyouTy.ZT_SkFurikaeDenpyouTy());
        jpql.append($ORDER_BY(qZT_SkFurikaeDenpyouTy.ztytorihikinoc8.asc(), qZT_SkFurikaeDenpyouTy.ztytorihikinoedano.asc(), qZT_SkFurikaeDenpyouTy.ztytorihikiymdgengokbn.asc(), qZT_SkFurikaeDenpyouTy.ztytorihikinen.asc(), qZT_SkFurikaeDenpyouTy.ztytorihikituki.asc(), qZT_SkFurikaeDenpyouTy.ztytorihikibi.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SkFurikaeDenpyouTy).getResults();
    }
}
