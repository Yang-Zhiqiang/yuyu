package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr1Ty;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr1Ty;

/**
 * 新契約決算ベース月次成立Ｆテーブル１（中）(ZT_Skeiksnbsgetujisr1TyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_Skeiksnbsgetujisr1TyDao extends AbstractDao<ZT_Skeiksnbsgetujisr1Ty> {

    public ZT_Skeiksnbsgetujisr1TyDao() {
        super(ZT_Skeiksnbsgetujisr1Ty.class);
    }

    public ZT_Skeiksnbsgetujisr1Ty getSkeiksnbsgetujisr1Ty(String pZtyktgysyono) {
        ZT_Skeiksnbsgetujisr1Ty zT_Skeiksnbsgetujisr1Ty =  new ZT_Skeiksnbsgetujisr1Ty();
        zT_Skeiksnbsgetujisr1Ty.setZtyktgysyono(pZtyktgysyono);
        return this.selectOne(zT_Skeiksnbsgetujisr1Ty);
    }

    public ExDBResults<ZT_Skeiksnbsgetujisr1Ty> selectAllZT_Skeiksnbsgetujisr1Ty() {
        StringBuilder jpql = new StringBuilder();
        QZT_Skeiksnbsgetujisr1Ty qZT_Skeiksnbsgetujisr1Ty =  new QZT_Skeiksnbsgetujisr1Ty();
        jpql.append($SELECT);
        jpql.append(qZT_Skeiksnbsgetujisr1Ty);
        jpql.append($FROM);
        jpql.append(qZT_Skeiksnbsgetujisr1Ty.ZT_Skeiksnbsgetujisr1Ty());
        jpql.append($ORDER_BY(qZT_Skeiksnbsgetujisr1Ty.ztyktgysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_Skeiksnbsgetujisr1Ty).getResults();
    }
}
