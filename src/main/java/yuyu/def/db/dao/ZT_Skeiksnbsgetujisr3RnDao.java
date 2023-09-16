package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr3Rn;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr3Rn;

/**
 * 新契約決算ベース月次成立Ｆテーブル３（連）(ZT_Skeiksnbsgetujisr3RnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_Skeiksnbsgetujisr3RnDao extends AbstractDao<ZT_Skeiksnbsgetujisr3Rn> {

    public ZT_Skeiksnbsgetujisr3RnDao() {
        super(ZT_Skeiksnbsgetujisr3Rn.class);
    }

    public ZT_Skeiksnbsgetujisr3Rn getSkeiksnbsgetujisr3Rn(String pZrnktgysyono) {
        ZT_Skeiksnbsgetujisr3Rn zT_Skeiksnbsgetujisr3Rn =  new ZT_Skeiksnbsgetujisr3Rn();
        zT_Skeiksnbsgetujisr3Rn.setZrnktgysyono(pZrnktgysyono);
        return this.selectOne(zT_Skeiksnbsgetujisr3Rn);
    }

    public ExDBResults<ZT_Skeiksnbsgetujisr3Rn> selectAllZT_Skeiksnbsgetujisr3Rn() {
        StringBuilder jpql = new StringBuilder();
        QZT_Skeiksnbsgetujisr3Rn qZT_Skeiksnbsgetujisr3Rn =  new QZT_Skeiksnbsgetujisr3Rn();
        jpql.append($SELECT);
        jpql.append(qZT_Skeiksnbsgetujisr3Rn);
        jpql.append($FROM);
        jpql.append(qZT_Skeiksnbsgetujisr3Rn.ZT_Skeiksnbsgetujisr3Rn());
        jpql.append($ORDER_BY(qZT_Skeiksnbsgetujisr3Rn.zrnktgysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_Skeiksnbsgetujisr3Rn).getResults();
    }
}
