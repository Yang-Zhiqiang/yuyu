package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SkIpJissekiRn;
import yuyu.def.db.meta.QZT_SkIpJissekiRn;

/**
 * 新契約インプット実績Ｆテーブル（連）(ZT_SkIpJissekiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SkIpJissekiRnDao extends AbstractDao<ZT_SkIpJissekiRn> {

    public ZT_SkIpJissekiRnDao() {
        super(ZT_SkIpJissekiRn.class);
    }

    public ZT_SkIpJissekiRn getSkIpJissekiRn(Integer pZrnsequenceno) {
        ZT_SkIpJissekiRn zT_SkIpJissekiRn =  new ZT_SkIpJissekiRn();
        zT_SkIpJissekiRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_SkIpJissekiRn);
    }

    public ExDBResults<ZT_SkIpJissekiRn> selectAllZT_SkIpJissekiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SkIpJissekiRn qZT_SkIpJissekiRn =  new QZT_SkIpJissekiRn();
        jpql.append($SELECT);
        jpql.append(qZT_SkIpJissekiRn);
        jpql.append($FROM);
        jpql.append(qZT_SkIpJissekiRn.ZT_SkIpJissekiRn());
        jpql.append($ORDER_BY(qZT_SkIpJissekiRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SkIpJissekiRn).getResults();
    }
}
