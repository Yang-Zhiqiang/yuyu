package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SyainMeiboRn;
import yuyu.def.db.meta.QZT_SyainMeiboRn;

/**
 * 社員名簿Ｆテーブル（連）(ZT_SyainMeiboRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SyainMeiboRnDao extends AbstractDao<ZT_SyainMeiboRn> {

    public ZT_SyainMeiboRnDao() {
        super(ZT_SyainMeiboRn.class);
    }

    public ZT_SyainMeiboRn getSyainMeiboRn(String pZrnsyono) {
        ZT_SyainMeiboRn zT_SyainMeiboRn =  new ZT_SyainMeiboRn();
        zT_SyainMeiboRn.setZrnsyono(pZrnsyono);
        return this.selectOne(zT_SyainMeiboRn);
    }

    public ExDBResults<ZT_SyainMeiboRn> selectAllZT_SyainMeiboRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SyainMeiboRn qZT_SyainMeiboRn =  new QZT_SyainMeiboRn();
        jpql.append($SELECT);
        jpql.append(qZT_SyainMeiboRn);
        jpql.append($FROM);
        jpql.append(qZT_SyainMeiboRn.ZT_SyainMeiboRn());
        jpql.append($ORDER_BY(qZT_SyainMeiboRn.zrnsyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SyainMeiboRn).getResults();
    }
}
