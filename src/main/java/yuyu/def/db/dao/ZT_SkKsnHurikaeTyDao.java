package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SkKsnHurikaeTy;
import yuyu.def.db.meta.QZT_SkKsnHurikaeTy;

/**
 * 新契約決算用振替伝票テーブル（中）(ZT_SkKsnHurikaeTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SkKsnHurikaeTyDao extends AbstractDao<ZT_SkKsnHurikaeTy> {

    public ZT_SkKsnHurikaeTyDao() {
        super(ZT_SkKsnHurikaeTy.class);
    }

    public ZT_SkKsnHurikaeTy getSkKsnHurikaeTy(String pZtytorihikinoc8, String pZtytorihikinoedano, String pZtytorihikiymdgengokbn, String pZtytorihikinen, String pZtytorihikituki, String pZtytorihikibi) {
        ZT_SkKsnHurikaeTy zT_SkKsnHurikaeTy =  new ZT_SkKsnHurikaeTy();
        zT_SkKsnHurikaeTy.setZtytorihikinoc8(pZtytorihikinoc8);
        zT_SkKsnHurikaeTy.setZtytorihikinoedano(pZtytorihikinoedano);
        zT_SkKsnHurikaeTy.setZtytorihikiymdgengokbn(pZtytorihikiymdgengokbn);
        zT_SkKsnHurikaeTy.setZtytorihikinen(pZtytorihikinen);
        zT_SkKsnHurikaeTy.setZtytorihikituki(pZtytorihikituki);
        zT_SkKsnHurikaeTy.setZtytorihikibi(pZtytorihikibi);
        return this.selectOne(zT_SkKsnHurikaeTy);
    }

    public ExDBResults<ZT_SkKsnHurikaeTy> selectAllZT_SkKsnHurikaeTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SkKsnHurikaeTy qZT_SkKsnHurikaeTy =  new QZT_SkKsnHurikaeTy();
        jpql.append($SELECT);
        jpql.append(qZT_SkKsnHurikaeTy);
        jpql.append($FROM);
        jpql.append(qZT_SkKsnHurikaeTy.ZT_SkKsnHurikaeTy());
        jpql.append($ORDER_BY(qZT_SkKsnHurikaeTy.ztytorihikinoc8.asc(), qZT_SkKsnHurikaeTy.ztytorihikinoedano.asc(), qZT_SkKsnHurikaeTy.ztytorihikiymdgengokbn.asc(), qZT_SkKsnHurikaeTy.ztytorihikinen.asc(), qZT_SkKsnHurikaeTy.ztytorihikituki.asc(), qZT_SkKsnHurikaeTy.ztytorihikibi.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SkKsnHurikaeTy).getResults();
    }
}
