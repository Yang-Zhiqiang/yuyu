package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SkFurikaeDenpyouHikaeTy;
import yuyu.def.db.meta.QZT_SkFurikaeDenpyouHikaeTy;

/**
 * 新契約振替伝票（控）テーブル（中）(ZT_SkFurikaeDenpyouHikaeTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SkFurikaeDenpyouHikaeTyDao extends AbstractDao<ZT_SkFurikaeDenpyouHikaeTy> {

    public ZT_SkFurikaeDenpyouHikaeTyDao() {
        super(ZT_SkFurikaeDenpyouHikaeTy.class);
    }

    public ZT_SkFurikaeDenpyouHikaeTy getSkFurikaeDenpyouHikaeTy(String pZtytorihikinoc8, String pZtytorihikinoedano, String pZtytorihikiymdgengokbn, String pZtytorihikinen, String pZtytorihikituki, String pZtytorihikibi) {
        ZT_SkFurikaeDenpyouHikaeTy zT_SkFurikaeDenpyouHikaeTy =  new ZT_SkFurikaeDenpyouHikaeTy();
        zT_SkFurikaeDenpyouHikaeTy.setZtytorihikinoc8(pZtytorihikinoc8);
        zT_SkFurikaeDenpyouHikaeTy.setZtytorihikinoedano(pZtytorihikinoedano);
        zT_SkFurikaeDenpyouHikaeTy.setZtytorihikiymdgengokbn(pZtytorihikiymdgengokbn);
        zT_SkFurikaeDenpyouHikaeTy.setZtytorihikinen(pZtytorihikinen);
        zT_SkFurikaeDenpyouHikaeTy.setZtytorihikituki(pZtytorihikituki);
        zT_SkFurikaeDenpyouHikaeTy.setZtytorihikibi(pZtytorihikibi);
        return this.selectOne(zT_SkFurikaeDenpyouHikaeTy);
    }

    public ExDBResults<ZT_SkFurikaeDenpyouHikaeTy> selectAllZT_SkFurikaeDenpyouHikaeTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SkFurikaeDenpyouHikaeTy qZT_SkFurikaeDenpyouHikaeTy =  new QZT_SkFurikaeDenpyouHikaeTy();
        jpql.append($SELECT);
        jpql.append(qZT_SkFurikaeDenpyouHikaeTy);
        jpql.append($FROM);
        jpql.append(qZT_SkFurikaeDenpyouHikaeTy.ZT_SkFurikaeDenpyouHikaeTy());
        jpql.append($ORDER_BY(qZT_SkFurikaeDenpyouHikaeTy.ztytorihikinoc8.asc(), qZT_SkFurikaeDenpyouHikaeTy.ztytorihikinoedano.asc(), qZT_SkFurikaeDenpyouHikaeTy.ztytorihikiymdgengokbn.asc(), qZT_SkFurikaeDenpyouHikaeTy.ztytorihikinen.asc(), qZT_SkFurikaeDenpyouHikaeTy.ztytorihikituki.asc(), qZT_SkFurikaeDenpyouHikaeTy.ztytorihikibi.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SkFurikaeDenpyouHikaeTy).getResults();
    }
}
