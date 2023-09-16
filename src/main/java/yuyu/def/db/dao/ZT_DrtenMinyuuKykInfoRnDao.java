package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_DrtenMinyuuKykInfoRn;
import yuyu.def.db.meta.QZT_DrtenMinyuuKykInfoRn;

/**
 * 代理店未入契約情報Ｆテーブル（連）(ZT_DrtenMinyuuKykInfoRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_DrtenMinyuuKykInfoRnDao extends AbstractDao<ZT_DrtenMinyuuKykInfoRn> {

    public ZT_DrtenMinyuuKykInfoRnDao() {
        super(ZT_DrtenMinyuuKykInfoRn.class);
    }

    public ZT_DrtenMinyuuKykInfoRn getDrtenMinyuuKykInfoRn(String pZrnsyono) {
        ZT_DrtenMinyuuKykInfoRn zT_DrtenMinyuuKykInfoRn =  new ZT_DrtenMinyuuKykInfoRn();
        zT_DrtenMinyuuKykInfoRn.setZrnsyono(pZrnsyono);
        return this.selectOne(zT_DrtenMinyuuKykInfoRn);
    }

    public ExDBResults<ZT_DrtenMinyuuKykInfoRn> selectAllZT_DrtenMinyuuKykInfoRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_DrtenMinyuuKykInfoRn qZT_DrtenMinyuuKykInfoRn =  new QZT_DrtenMinyuuKykInfoRn();
        jpql.append($SELECT);
        jpql.append(qZT_DrtenMinyuuKykInfoRn);
        jpql.append($FROM);
        jpql.append(qZT_DrtenMinyuuKykInfoRn.ZT_DrtenMinyuuKykInfoRn());
        jpql.append($ORDER_BY(qZT_DrtenMinyuuKykInfoRn.zrnsyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_DrtenMinyuuKykInfoRn).getResults();
    }
}
