package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_HrhnTtdkKanTy;
import yuyu.def.db.meta.QZT_HrhnTtdkKanTy;

/**
 * 手続完了（払方変更）テーブル（中）(ZT_HrhnTtdkKanTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_HrhnTtdkKanTyDao extends AbstractDao<ZT_HrhnTtdkKanTy> {

    public ZT_HrhnTtdkKanTyDao() {
        super(ZT_HrhnTtdkKanTy.class);
    }

    public ZT_HrhnTtdkKanTy getHrhnTtdkKanTy(String pZtytyouhyouymd, String pZtysyono, String pZtysikibetuno) {
        ZT_HrhnTtdkKanTy zT_HrhnTtdkKanTy =  new ZT_HrhnTtdkKanTy();
        zT_HrhnTtdkKanTy.setZtytyouhyouymd(pZtytyouhyouymd);
        zT_HrhnTtdkKanTy.setZtysyono(pZtysyono);
        zT_HrhnTtdkKanTy.setZtysikibetuno(pZtysikibetuno);
        return this.selectOne(zT_HrhnTtdkKanTy);
    }

    public ExDBResults<ZT_HrhnTtdkKanTy> selectAllZT_HrhnTtdkKanTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_HrhnTtdkKanTy qZT_HrhnTtdkKanTy =  new QZT_HrhnTtdkKanTy();
        jpql.append($SELECT);
        jpql.append(qZT_HrhnTtdkKanTy);
        jpql.append($FROM);
        jpql.append(qZT_HrhnTtdkKanTy.ZT_HrhnTtdkKanTy());
        jpql.append($ORDER_BY(qZT_HrhnTtdkKanTy.ztytyouhyouymd.asc(), qZT_HrhnTtdkKanTy.ztysyono.asc(), qZT_HrhnTtdkKanTy.ztysikibetuno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_HrhnTtdkKanTy).getResults();
    }
}
