package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_TtdkKanAdHenkouTy;
import yuyu.def.db.meta.QZT_TtdkKanAdHenkouTy;

/**
 * 手続完了（住所変更）Ｆテーブル（中）(ZT_TtdkKanAdHenkouTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_TtdkKanAdHenkouTyDao extends AbstractDao<ZT_TtdkKanAdHenkouTy> {

    public ZT_TtdkKanAdHenkouTyDao() {
        super(ZT_TtdkKanAdHenkouTy.class);
    }

    public ZT_TtdkKanAdHenkouTy getTtdkKanAdHenkouTy(String pZtytyouhyouymd, String pZtysyono, String pZtysikibetuno) {
        ZT_TtdkKanAdHenkouTy zT_TtdkKanAdHenkouTy =  new ZT_TtdkKanAdHenkouTy();
        zT_TtdkKanAdHenkouTy.setZtytyouhyouymd(pZtytyouhyouymd);
        zT_TtdkKanAdHenkouTy.setZtysyono(pZtysyono);
        zT_TtdkKanAdHenkouTy.setZtysikibetuno(pZtysikibetuno);
        return this.selectOne(zT_TtdkKanAdHenkouTy);
    }

    public ExDBResults<ZT_TtdkKanAdHenkouTy> selectAllZT_TtdkKanAdHenkouTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_TtdkKanAdHenkouTy qZT_TtdkKanAdHenkouTy =  new QZT_TtdkKanAdHenkouTy();
        jpql.append($SELECT);
        jpql.append(qZT_TtdkKanAdHenkouTy);
        jpql.append($FROM);
        jpql.append(qZT_TtdkKanAdHenkouTy.ZT_TtdkKanAdHenkouTy());
        jpql.append($ORDER_BY(qZT_TtdkKanAdHenkouTy.ztytyouhyouymd.asc(), qZT_TtdkKanAdHenkouTy.ztysyono.asc(), qZT_TtdkKanAdHenkouTy.ztysikibetuno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_TtdkKanAdHenkouTy).getResults();
    }
}
