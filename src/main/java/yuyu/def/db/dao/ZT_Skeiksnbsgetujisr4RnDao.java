package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr4Rn;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr4Rn;

/**
 * 新契約決算ベース月次成立Ｆテーブル４（連）(ZT_Skeiksnbsgetujisr4RnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_Skeiksnbsgetujisr4RnDao extends AbstractDao<ZT_Skeiksnbsgetujisr4Rn> {

    public ZT_Skeiksnbsgetujisr4RnDao() {
        super(ZT_Skeiksnbsgetujisr4Rn.class);
    }

    public ZT_Skeiksnbsgetujisr4Rn getSkeiksnbsgetujisr4Rn(String pZrnktgysyono) {
        ZT_Skeiksnbsgetujisr4Rn zT_Skeiksnbsgetujisr4Rn =  new ZT_Skeiksnbsgetujisr4Rn();
        zT_Skeiksnbsgetujisr4Rn.setZrnktgysyono(pZrnktgysyono);
        return this.selectOne(zT_Skeiksnbsgetujisr4Rn);
    }

    public ExDBResults<ZT_Skeiksnbsgetujisr4Rn> selectAllZT_Skeiksnbsgetujisr4Rn() {
        StringBuilder jpql = new StringBuilder();
        QZT_Skeiksnbsgetujisr4Rn qZT_Skeiksnbsgetujisr4Rn =  new QZT_Skeiksnbsgetujisr4Rn();
        jpql.append($SELECT);
        jpql.append(qZT_Skeiksnbsgetujisr4Rn);
        jpql.append($FROM);
        jpql.append(qZT_Skeiksnbsgetujisr4Rn.ZT_Skeiksnbsgetujisr4Rn());
        jpql.append($ORDER_BY(qZT_Skeiksnbsgetujisr4Rn.zrnktgysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_Skeiksnbsgetujisr4Rn).getResults();
    }
}
