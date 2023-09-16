package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SiharaiTyousyoRn;
import yuyu.def.db.meta.QZT_SiharaiTyousyoRn;

/**
 * 支払調書テーブル（連）(ZT_SiharaiTyousyoRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SiharaiTyousyoRnDao extends AbstractDao<ZT_SiharaiTyousyoRn> {

    public ZT_SiharaiTyousyoRnDao() {
        super(ZT_SiharaiTyousyoRn.class);
    }

    public ZT_SiharaiTyousyoRn getSiharaiTyousyoRn(Integer pZrnsequenceno) {
        ZT_SiharaiTyousyoRn zT_SiharaiTyousyoRn =  new ZT_SiharaiTyousyoRn();
        zT_SiharaiTyousyoRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_SiharaiTyousyoRn);
    }

    public ExDBResults<ZT_SiharaiTyousyoRn> selectAllZT_SiharaiTyousyoRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SiharaiTyousyoRn qZT_SiharaiTyousyoRn =  new QZT_SiharaiTyousyoRn();
        jpql.append($SELECT);
        jpql.append(qZT_SiharaiTyousyoRn);
        jpql.append($FROM);
        jpql.append(qZT_SiharaiTyousyoRn.ZT_SiharaiTyousyoRn());
        jpql.append($ORDER_BY(qZT_SiharaiTyousyoRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SiharaiTyousyoRn).getResults();
    }
}
