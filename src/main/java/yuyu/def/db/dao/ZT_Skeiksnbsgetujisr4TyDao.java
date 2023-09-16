package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr4Ty;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr4Ty;

/**
 * 新契約決算ベース月次成立Ｆテーブル４（中）(ZT_Skeiksnbsgetujisr4TyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_Skeiksnbsgetujisr4TyDao extends AbstractDao<ZT_Skeiksnbsgetujisr4Ty> {

    public ZT_Skeiksnbsgetujisr4TyDao() {
        super(ZT_Skeiksnbsgetujisr4Ty.class);
    }

    public ZT_Skeiksnbsgetujisr4Ty getSkeiksnbsgetujisr4Ty(String pZtyktgysyono) {
        ZT_Skeiksnbsgetujisr4Ty zT_Skeiksnbsgetujisr4Ty =  new ZT_Skeiksnbsgetujisr4Ty();
        zT_Skeiksnbsgetujisr4Ty.setZtyktgysyono(pZtyktgysyono);
        return this.selectOne(zT_Skeiksnbsgetujisr4Ty);
    }

    public ExDBResults<ZT_Skeiksnbsgetujisr4Ty> selectAllZT_Skeiksnbsgetujisr4Ty() {
        StringBuilder jpql = new StringBuilder();
        QZT_Skeiksnbsgetujisr4Ty qZT_Skeiksnbsgetujisr4Ty =  new QZT_Skeiksnbsgetujisr4Ty();
        jpql.append($SELECT);
        jpql.append(qZT_Skeiksnbsgetujisr4Ty);
        jpql.append($FROM);
        jpql.append(qZT_Skeiksnbsgetujisr4Ty.ZT_Skeiksnbsgetujisr4Ty());
        jpql.append($ORDER_BY(qZT_Skeiksnbsgetujisr4Ty.ztyktgysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_Skeiksnbsgetujisr4Ty).getResults();
    }
}
