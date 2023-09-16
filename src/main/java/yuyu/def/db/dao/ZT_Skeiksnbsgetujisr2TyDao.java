package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr2Ty;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr2Ty;

/**
 * 新契約決算ベース月次成立Ｆテーブル２（中）(ZT_Skeiksnbsgetujisr2TyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_Skeiksnbsgetujisr2TyDao extends AbstractDao<ZT_Skeiksnbsgetujisr2Ty> {

    public ZT_Skeiksnbsgetujisr2TyDao() {
        super(ZT_Skeiksnbsgetujisr2Ty.class);
    }

    public ZT_Skeiksnbsgetujisr2Ty getSkeiksnbsgetujisr2Ty(String pZtyktgysyono) {
        ZT_Skeiksnbsgetujisr2Ty zT_Skeiksnbsgetujisr2Ty =  new ZT_Skeiksnbsgetujisr2Ty();
        zT_Skeiksnbsgetujisr2Ty.setZtyktgysyono(pZtyktgysyono);
        return this.selectOne(zT_Skeiksnbsgetujisr2Ty);
    }

    public ExDBResults<ZT_Skeiksnbsgetujisr2Ty> selectAllZT_Skeiksnbsgetujisr2Ty() {
        StringBuilder jpql = new StringBuilder();
        QZT_Skeiksnbsgetujisr2Ty qZT_Skeiksnbsgetujisr2Ty =  new QZT_Skeiksnbsgetujisr2Ty();
        jpql.append($SELECT);
        jpql.append(qZT_Skeiksnbsgetujisr2Ty);
        jpql.append($FROM);
        jpql.append(qZT_Skeiksnbsgetujisr2Ty.ZT_Skeiksnbsgetujisr2Ty());
        jpql.append($ORDER_BY(qZT_Skeiksnbsgetujisr2Ty.ztyktgysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_Skeiksnbsgetujisr2Ty).getResults();
    }
}
