package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr2Rn;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr2Rn;

/**
 * 新契約決算ベース月次成立Ｆテーブル２（連）(ZT_Skeiksnbsgetujisr2RnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_Skeiksnbsgetujisr2RnDao extends AbstractDao<ZT_Skeiksnbsgetujisr2Rn> {

    public ZT_Skeiksnbsgetujisr2RnDao() {
        super(ZT_Skeiksnbsgetujisr2Rn.class);
    }

    public ZT_Skeiksnbsgetujisr2Rn getSkeiksnbsgetujisr2Rn(String pZrnktgysyono) {
        ZT_Skeiksnbsgetujisr2Rn zT_Skeiksnbsgetujisr2Rn =  new ZT_Skeiksnbsgetujisr2Rn();
        zT_Skeiksnbsgetujisr2Rn.setZrnktgysyono(pZrnktgysyono);
        return this.selectOne(zT_Skeiksnbsgetujisr2Rn);
    }

    public ExDBResults<ZT_Skeiksnbsgetujisr2Rn> selectAllZT_Skeiksnbsgetujisr2Rn() {
        StringBuilder jpql = new StringBuilder();
        QZT_Skeiksnbsgetujisr2Rn qZT_Skeiksnbsgetujisr2Rn =  new QZT_Skeiksnbsgetujisr2Rn();
        jpql.append($SELECT);
        jpql.append(qZT_Skeiksnbsgetujisr2Rn);
        jpql.append($FROM);
        jpql.append(qZT_Skeiksnbsgetujisr2Rn.ZT_Skeiksnbsgetujisr2Rn());
        jpql.append($ORDER_BY(qZT_Skeiksnbsgetujisr2Rn.zrnktgysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_Skeiksnbsgetujisr2Rn).getResults();
    }
}
