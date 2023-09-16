package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_LincJyusinRn;
import yuyu.def.db.meta.QZT_LincJyusinRn;

/**
 * ＬＩＮＣ受信内容反映テーブル（連）(ZT_LincJyusinRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_LincJyusinRnDao extends AbstractDao<ZT_LincJyusinRn> {

    public ZT_LincJyusinRnDao() {
        super(ZT_LincJyusinRn.class);
    }

    public ZT_LincJyusinRn getLincJyusinRn(String pZrnsyoriymd, String pZrnrenno10) {
        ZT_LincJyusinRn zT_LincJyusinRn =  new ZT_LincJyusinRn();
        zT_LincJyusinRn.setZrnsyoriymd(pZrnsyoriymd);
        zT_LincJyusinRn.setZrnrenno10(pZrnrenno10);
        return this.selectOne(zT_LincJyusinRn);
    }

    public ExDBResults<ZT_LincJyusinRn> selectAllZT_LincJyusinRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_LincJyusinRn qZT_LincJyusinRn =  new QZT_LincJyusinRn();
        jpql.append($SELECT);
        jpql.append(qZT_LincJyusinRn);
        jpql.append($FROM);
        jpql.append(qZT_LincJyusinRn.ZT_LincJyusinRn());
        jpql.append($ORDER_BY(qZT_LincJyusinRn.zrnsyoriymd.asc(), qZT_LincJyusinRn.zrnrenno10.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_LincJyusinRn).getResults();
    }
}
