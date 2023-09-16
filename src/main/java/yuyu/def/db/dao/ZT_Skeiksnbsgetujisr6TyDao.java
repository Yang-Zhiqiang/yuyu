package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr6Ty;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr6Ty;

/**
 * 新契約決算ベース月次成立Ｆテーブル６（中）(ZT_Skeiksnbsgetujisr6TyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_Skeiksnbsgetujisr6TyDao extends AbstractDao<ZT_Skeiksnbsgetujisr6Ty> {

    public ZT_Skeiksnbsgetujisr6TyDao() {
        super(ZT_Skeiksnbsgetujisr6Ty.class);
    }

    public ZT_Skeiksnbsgetujisr6Ty getSkeiksnbsgetujisr6Ty(String pZtyktgysyono) {
        ZT_Skeiksnbsgetujisr6Ty zT_Skeiksnbsgetujisr6Ty =  new ZT_Skeiksnbsgetujisr6Ty();
        zT_Skeiksnbsgetujisr6Ty.setZtyktgysyono(pZtyktgysyono);
        return this.selectOne(zT_Skeiksnbsgetujisr6Ty);
    }

    public ExDBResults<ZT_Skeiksnbsgetujisr6Ty> selectAllZT_Skeiksnbsgetujisr6Ty() {
        StringBuilder jpql = new StringBuilder();
        QZT_Skeiksnbsgetujisr6Ty qZT_Skeiksnbsgetujisr6Ty =  new QZT_Skeiksnbsgetujisr6Ty();
        jpql.append($SELECT);
        jpql.append(qZT_Skeiksnbsgetujisr6Ty);
        jpql.append($FROM);
        jpql.append(qZT_Skeiksnbsgetujisr6Ty.ZT_Skeiksnbsgetujisr6Ty());
        jpql.append($ORDER_BY(qZT_Skeiksnbsgetujisr6Ty.ztyktgysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_Skeiksnbsgetujisr6Ty).getResults();
    }
}
