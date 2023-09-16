package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SkKsnHurikaeHikaeTy;
import yuyu.def.db.meta.QZT_SkKsnHurikaeHikaeTy;

/**
 * 新契約決算用振替伝票（控）テーブル（中）(ZT_SkKsnHurikaeHikaeTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SkKsnHurikaeHikaeTyDao extends AbstractDao<ZT_SkKsnHurikaeHikaeTy> {

    public ZT_SkKsnHurikaeHikaeTyDao() {
        super(ZT_SkKsnHurikaeHikaeTy.class);
    }

    public ZT_SkKsnHurikaeHikaeTy getSkKsnHurikaeHikaeTy(String pZtytorihikinoc8, String pZtytorihikinoedano, String pZtytorihikiymdgengokbn, String pZtytorihikinen, String pZtytorihikituki, String pZtytorihikibi) {
        ZT_SkKsnHurikaeHikaeTy zT_SkKsnHurikaeHikaeTy =  new ZT_SkKsnHurikaeHikaeTy();
        zT_SkKsnHurikaeHikaeTy.setZtytorihikinoc8(pZtytorihikinoc8);
        zT_SkKsnHurikaeHikaeTy.setZtytorihikinoedano(pZtytorihikinoedano);
        zT_SkKsnHurikaeHikaeTy.setZtytorihikiymdgengokbn(pZtytorihikiymdgengokbn);
        zT_SkKsnHurikaeHikaeTy.setZtytorihikinen(pZtytorihikinen);
        zT_SkKsnHurikaeHikaeTy.setZtytorihikituki(pZtytorihikituki);
        zT_SkKsnHurikaeHikaeTy.setZtytorihikibi(pZtytorihikibi);
        return this.selectOne(zT_SkKsnHurikaeHikaeTy);
    }

    public ExDBResults<ZT_SkKsnHurikaeHikaeTy> selectAllZT_SkKsnHurikaeHikaeTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SkKsnHurikaeHikaeTy qZT_SkKsnHurikaeHikaeTy =  new QZT_SkKsnHurikaeHikaeTy();
        jpql.append($SELECT);
        jpql.append(qZT_SkKsnHurikaeHikaeTy);
        jpql.append($FROM);
        jpql.append(qZT_SkKsnHurikaeHikaeTy.ZT_SkKsnHurikaeHikaeTy());
        jpql.append($ORDER_BY(qZT_SkKsnHurikaeHikaeTy.ztytorihikinoc8.asc(), qZT_SkKsnHurikaeHikaeTy.ztytorihikinoedano.asc(), qZT_SkKsnHurikaeHikaeTy.ztytorihikiymdgengokbn.asc(), qZT_SkKsnHurikaeHikaeTy.ztytorihikinen.asc(), qZT_SkKsnHurikaeHikaeTy.ztytorihikituki.asc(), qZT_SkKsnHurikaeHikaeTy.ztytorihikibi.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SkKsnHurikaeHikaeTy).getResults();
    }
}
