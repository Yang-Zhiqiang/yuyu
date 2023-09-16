package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr1Rn;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr1Rn;

/**
 * 新契約決算ベース月次成立Ｆテーブル１（連）(ZT_Skeiksnbsgetujisr1RnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_Skeiksnbsgetujisr1RnDao extends AbstractDao<ZT_Skeiksnbsgetujisr1Rn> {

    public ZT_Skeiksnbsgetujisr1RnDao() {
        super(ZT_Skeiksnbsgetujisr1Rn.class);
    }

    public ZT_Skeiksnbsgetujisr1Rn getSkeiksnbsgetujisr1Rn(String pZrnktgysyono) {
        ZT_Skeiksnbsgetujisr1Rn zT_Skeiksnbsgetujisr1Rn =  new ZT_Skeiksnbsgetujisr1Rn();
        zT_Skeiksnbsgetujisr1Rn.setZrnktgysyono(pZrnktgysyono);
        return this.selectOne(zT_Skeiksnbsgetujisr1Rn);
    }

    public ExDBResults<ZT_Skeiksnbsgetujisr1Rn> selectAllZT_Skeiksnbsgetujisr1Rn() {
        StringBuilder jpql = new StringBuilder();
        QZT_Skeiksnbsgetujisr1Rn qZT_Skeiksnbsgetujisr1Rn =  new QZT_Skeiksnbsgetujisr1Rn();
        jpql.append($SELECT);
        jpql.append(qZT_Skeiksnbsgetujisr1Rn);
        jpql.append($FROM);
        jpql.append(qZT_Skeiksnbsgetujisr1Rn.ZT_Skeiksnbsgetujisr1Rn());
        jpql.append($ORDER_BY(qZT_Skeiksnbsgetujisr1Rn.zrnktgysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_Skeiksnbsgetujisr1Rn).getResults();
    }
}
