package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_FurikaeDenpyouHikaeTy;
import yuyu.def.db.meta.QZT_FurikaeDenpyouHikaeTy;

/**
 * 振替伝票（控）テーブル（中）(ZT_FurikaeDenpyouHikaeTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_FurikaeDenpyouHikaeTyDao extends AbstractDao<ZT_FurikaeDenpyouHikaeTy> {

    public ZT_FurikaeDenpyouHikaeTyDao() {
        super(ZT_FurikaeDenpyouHikaeTy.class);
    }

    public ZT_FurikaeDenpyouHikaeTy getFurikaeDenpyouHikaeTy(String pZtytorihikinoc8, String pZtytorihikinoedano, String pZtytorihikiymdgengokbn, String pZtytorihikinen, String pZtytorihikituki, String pZtytorihikibi) {
        ZT_FurikaeDenpyouHikaeTy zT_FurikaeDenpyouHikaeTy =  new ZT_FurikaeDenpyouHikaeTy();
        zT_FurikaeDenpyouHikaeTy.setZtytorihikinoc8(pZtytorihikinoc8);
        zT_FurikaeDenpyouHikaeTy.setZtytorihikinoedano(pZtytorihikinoedano);
        zT_FurikaeDenpyouHikaeTy.setZtytorihikiymdgengokbn(pZtytorihikiymdgengokbn);
        zT_FurikaeDenpyouHikaeTy.setZtytorihikinen(pZtytorihikinen);
        zT_FurikaeDenpyouHikaeTy.setZtytorihikituki(pZtytorihikituki);
        zT_FurikaeDenpyouHikaeTy.setZtytorihikibi(pZtytorihikibi);
        return this.selectOne(zT_FurikaeDenpyouHikaeTy);
    }

    public ExDBResults<ZT_FurikaeDenpyouHikaeTy> selectAllZT_FurikaeDenpyouHikaeTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_FurikaeDenpyouHikaeTy qZT_FurikaeDenpyouHikaeTy =  new QZT_FurikaeDenpyouHikaeTy();
        jpql.append($SELECT);
        jpql.append(qZT_FurikaeDenpyouHikaeTy);
        jpql.append($FROM);
        jpql.append(qZT_FurikaeDenpyouHikaeTy.ZT_FurikaeDenpyouHikaeTy());
        jpql.append($ORDER_BY(qZT_FurikaeDenpyouHikaeTy.ztytorihikinoc8.asc(), qZT_FurikaeDenpyouHikaeTy.ztytorihikinoedano.asc(), qZT_FurikaeDenpyouHikaeTy.ztytorihikiymdgengokbn.asc(), qZT_FurikaeDenpyouHikaeTy.ztytorihikinen.asc(), qZT_FurikaeDenpyouHikaeTy.ztytorihikituki.asc(), qZT_FurikaeDenpyouHikaeTy.ztytorihikibi.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_FurikaeDenpyouHikaeTy).getResults();
    }
}
