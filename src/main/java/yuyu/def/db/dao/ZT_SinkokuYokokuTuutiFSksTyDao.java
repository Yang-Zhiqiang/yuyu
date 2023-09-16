package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SinkokuYokokuTuutiFSksTy;
import yuyu.def.db.meta.QZT_SinkokuYokokuTuutiFSksTy;

/**
 * 申告予告通知Ｆテーブル（中）(ZT_SinkokuYokokuTuutiFSksTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SinkokuYokokuTuutiFSksTyDao extends AbstractDao<ZT_SinkokuYokokuTuutiFSksTy> {

    public ZT_SinkokuYokokuTuutiFSksTyDao() {
        super(ZT_SinkokuYokokuTuutiFSksTy.class);
    }

    public ZT_SinkokuYokokuTuutiFSksTy getSinkokuYokokuTuutiFSksTy(String pZtytyouhyouymd, String pZtysyono, String pZtysinkokunenkj) {
        ZT_SinkokuYokokuTuutiFSksTy zT_SinkokuYokokuTuutiFSksTy =  new ZT_SinkokuYokokuTuutiFSksTy();
        zT_SinkokuYokokuTuutiFSksTy.setZtytyouhyouymd(pZtytyouhyouymd);
        zT_SinkokuYokokuTuutiFSksTy.setZtysyono(pZtysyono);
        zT_SinkokuYokokuTuutiFSksTy.setZtysinkokunenkj(pZtysinkokunenkj);
        return this.selectOne(zT_SinkokuYokokuTuutiFSksTy);
    }

    public ExDBResults<ZT_SinkokuYokokuTuutiFSksTy> selectAllZT_SinkokuYokokuTuutiFSksTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SinkokuYokokuTuutiFSksTy qZT_SinkokuYokokuTuutiFSksTy =  new QZT_SinkokuYokokuTuutiFSksTy();
        jpql.append($SELECT);
        jpql.append(qZT_SinkokuYokokuTuutiFSksTy);
        jpql.append($FROM);
        jpql.append(qZT_SinkokuYokokuTuutiFSksTy.ZT_SinkokuYokokuTuutiFSksTy());
        jpql.append($ORDER_BY(qZT_SinkokuYokokuTuutiFSksTy.ztytyouhyouymd.asc(), qZT_SinkokuYokokuTuutiFSksTy.ztysyono.asc(), qZT_SinkokuYokokuTuutiFSksTy.ztysinkokunenkj.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SinkokuYokokuTuutiFSksTy).getResults();
    }
}
