package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_TuutirirekiMeisaiFTy;
import yuyu.def.db.meta.QZT_TuutirirekiMeisaiFTy;

/**
 * 通知履歴明細ファイルテーブル（中）(ZT_TuutirirekiMeisaiFTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_TuutirirekiMeisaiFTyDao extends AbstractDao<ZT_TuutirirekiMeisaiFTy> {

    public ZT_TuutirirekiMeisaiFTyDao() {
        super(ZT_TuutirirekiMeisaiFTy.class);
    }

    public ZT_TuutirirekiMeisaiFTy getTuutirirekiMeisaiFTy(String pZtytuutirirekino, String pZtytuutisakuseiymd, String pZtytuutisakuseino) {
        ZT_TuutirirekiMeisaiFTy zT_TuutirirekiMeisaiFTy =  new ZT_TuutirirekiMeisaiFTy();
        zT_TuutirirekiMeisaiFTy.setZtytuutirirekino(pZtytuutirirekino);
        zT_TuutirirekiMeisaiFTy.setZtytuutisakuseiymd(pZtytuutisakuseiymd);
        zT_TuutirirekiMeisaiFTy.setZtytuutisakuseino(pZtytuutisakuseino);
        return this.selectOne(zT_TuutirirekiMeisaiFTy);
    }

    public ExDBResults<ZT_TuutirirekiMeisaiFTy> selectAllZT_TuutirirekiMeisaiFTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_TuutirirekiMeisaiFTy qZT_TuutirirekiMeisaiFTy =  new QZT_TuutirirekiMeisaiFTy();
        jpql.append($SELECT);
        jpql.append(qZT_TuutirirekiMeisaiFTy);
        jpql.append($FROM);
        jpql.append(qZT_TuutirirekiMeisaiFTy.ZT_TuutirirekiMeisaiFTy());
        jpql.append($ORDER_BY(qZT_TuutirirekiMeisaiFTy.ztytuutirirekino.asc(), qZT_TuutirirekiMeisaiFTy.ztytuutisakuseiymd.asc(), qZT_TuutirirekiMeisaiFTy.ztytuutisakuseino.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_TuutirirekiMeisaiFTy).getResults();
    }
}
