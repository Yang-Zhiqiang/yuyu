package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr5Ty;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr5Ty;

/**
 * 新契約決算ベース月次成立Ｆテーブル５（中）(ZT_Skeiksnbsgetujisr5TyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_Skeiksnbsgetujisr5TyDao extends AbstractDao<ZT_Skeiksnbsgetujisr5Ty> {

    public ZT_Skeiksnbsgetujisr5TyDao() {
        super(ZT_Skeiksnbsgetujisr5Ty.class);
    }

    public ZT_Skeiksnbsgetujisr5Ty getSkeiksnbsgetujisr5Ty(String pZtyktgysyono) {
        ZT_Skeiksnbsgetujisr5Ty zT_Skeiksnbsgetujisr5Ty =  new ZT_Skeiksnbsgetujisr5Ty();
        zT_Skeiksnbsgetujisr5Ty.setZtyktgysyono(pZtyktgysyono);
        return this.selectOne(zT_Skeiksnbsgetujisr5Ty);
    }

    public ExDBResults<ZT_Skeiksnbsgetujisr5Ty> selectAllZT_Skeiksnbsgetujisr5Ty() {
        StringBuilder jpql = new StringBuilder();
        QZT_Skeiksnbsgetujisr5Ty qZT_Skeiksnbsgetujisr5Ty =  new QZT_Skeiksnbsgetujisr5Ty();
        jpql.append($SELECT);
        jpql.append(qZT_Skeiksnbsgetujisr5Ty);
        jpql.append($FROM);
        jpql.append(qZT_Skeiksnbsgetujisr5Ty.ZT_Skeiksnbsgetujisr5Ty());
        jpql.append($ORDER_BY(qZT_Skeiksnbsgetujisr5Ty.ztyktgysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_Skeiksnbsgetujisr5Ty).getResults();
    }
}
