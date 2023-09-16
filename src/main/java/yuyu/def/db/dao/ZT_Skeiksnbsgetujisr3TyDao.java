package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr3Ty;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr3Ty;

/**
 * 新契約決算ベース月次成立Ｆテーブル３（中）(ZT_Skeiksnbsgetujisr3TyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_Skeiksnbsgetujisr3TyDao extends AbstractDao<ZT_Skeiksnbsgetujisr3Ty> {

    public ZT_Skeiksnbsgetujisr3TyDao() {
        super(ZT_Skeiksnbsgetujisr3Ty.class);
    }

    public ZT_Skeiksnbsgetujisr3Ty getSkeiksnbsgetujisr3Ty(String pZtyktgysyono) {
        ZT_Skeiksnbsgetujisr3Ty zT_Skeiksnbsgetujisr3Ty =  new ZT_Skeiksnbsgetujisr3Ty();
        zT_Skeiksnbsgetujisr3Ty.setZtyktgysyono(pZtyktgysyono);
        return this.selectOne(zT_Skeiksnbsgetujisr3Ty);
    }

    public ExDBResults<ZT_Skeiksnbsgetujisr3Ty> selectAllZT_Skeiksnbsgetujisr3Ty() {
        StringBuilder jpql = new StringBuilder();
        QZT_Skeiksnbsgetujisr3Ty qZT_Skeiksnbsgetujisr3Ty =  new QZT_Skeiksnbsgetujisr3Ty();
        jpql.append($SELECT);
        jpql.append(qZT_Skeiksnbsgetujisr3Ty);
        jpql.append($FROM);
        jpql.append(qZT_Skeiksnbsgetujisr3Ty.ZT_Skeiksnbsgetujisr3Ty());
        jpql.append($ORDER_BY(qZT_Skeiksnbsgetujisr3Ty.ztyktgysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_Skeiksnbsgetujisr3Ty).getResults();
    }
}
