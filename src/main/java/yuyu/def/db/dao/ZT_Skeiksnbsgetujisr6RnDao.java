package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr6Rn;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr6Rn;

/**
 * 新契約決算ベース月次成立Ｆテーブル６（連）(ZT_Skeiksnbsgetujisr6RnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_Skeiksnbsgetujisr6RnDao extends AbstractDao<ZT_Skeiksnbsgetujisr6Rn> {

    public ZT_Skeiksnbsgetujisr6RnDao() {
        super(ZT_Skeiksnbsgetujisr6Rn.class);
    }

    public ZT_Skeiksnbsgetujisr6Rn getSkeiksnbsgetujisr6Rn(String pZrnktgysyono) {
        ZT_Skeiksnbsgetujisr6Rn zT_Skeiksnbsgetujisr6Rn =  new ZT_Skeiksnbsgetujisr6Rn();
        zT_Skeiksnbsgetujisr6Rn.setZrnktgysyono(pZrnktgysyono);
        return this.selectOne(zT_Skeiksnbsgetujisr6Rn);
    }

    public ExDBResults<ZT_Skeiksnbsgetujisr6Rn> selectAllZT_Skeiksnbsgetujisr6Rn() {
        StringBuilder jpql = new StringBuilder();
        QZT_Skeiksnbsgetujisr6Rn qZT_Skeiksnbsgetujisr6Rn =  new QZT_Skeiksnbsgetujisr6Rn();
        jpql.append($SELECT);
        jpql.append(qZT_Skeiksnbsgetujisr6Rn);
        jpql.append($FROM);
        jpql.append(qZT_Skeiksnbsgetujisr6Rn.ZT_Skeiksnbsgetujisr6Rn());
        jpql.append($ORDER_BY(qZT_Skeiksnbsgetujisr6Rn.zrnktgysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_Skeiksnbsgetujisr6Rn).getResults();
    }
}
