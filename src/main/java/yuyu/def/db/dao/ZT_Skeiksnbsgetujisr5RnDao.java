package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr5Rn;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr5Rn;

/**
 * 新契約決算ベース月次成立Ｆテーブル５（連）(ZT_Skeiksnbsgetujisr5RnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_Skeiksnbsgetujisr5RnDao extends AbstractDao<ZT_Skeiksnbsgetujisr5Rn> {

    public ZT_Skeiksnbsgetujisr5RnDao() {
        super(ZT_Skeiksnbsgetujisr5Rn.class);
    }

    public ZT_Skeiksnbsgetujisr5Rn getSkeiksnbsgetujisr5Rn(String pZrnktgysyono) {
        ZT_Skeiksnbsgetujisr5Rn zT_Skeiksnbsgetujisr5Rn =  new ZT_Skeiksnbsgetujisr5Rn();
        zT_Skeiksnbsgetujisr5Rn.setZrnktgysyono(pZrnktgysyono);
        return this.selectOne(zT_Skeiksnbsgetujisr5Rn);
    }

    public ExDBResults<ZT_Skeiksnbsgetujisr5Rn> selectAllZT_Skeiksnbsgetujisr5Rn() {
        StringBuilder jpql = new StringBuilder();
        QZT_Skeiksnbsgetujisr5Rn qZT_Skeiksnbsgetujisr5Rn =  new QZT_Skeiksnbsgetujisr5Rn();
        jpql.append($SELECT);
        jpql.append(qZT_Skeiksnbsgetujisr5Rn);
        jpql.append($FROM);
        jpql.append(qZT_Skeiksnbsgetujisr5Rn.ZT_Skeiksnbsgetujisr5Rn());
        jpql.append($ORDER_BY(qZT_Skeiksnbsgetujisr5Rn.zrnktgysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_Skeiksnbsgetujisr5Rn).getResults();
    }
}
