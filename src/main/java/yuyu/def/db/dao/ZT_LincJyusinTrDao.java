package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_LincJyusinTr;
import yuyu.def.db.meta.QZT_LincJyusinTr;

/**
 * ＬＩＮＣ受信内容反映テーブル（取）(ZT_LincJyusinTrDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_LincJyusinTrDao extends AbstractDao<ZT_LincJyusinTr> {

    public ZT_LincJyusinTrDao() {
        super(ZT_LincJyusinTr.class);
    }

    public ZT_LincJyusinTr getLincJyusinTr(String pZtrsyoriymd, String pZtrrenno10) {
        ZT_LincJyusinTr zT_LincJyusinTr =  new ZT_LincJyusinTr();
        zT_LincJyusinTr.setZtrsyoriymd(pZtrsyoriymd);
        zT_LincJyusinTr.setZtrrenno10(pZtrrenno10);
        return this.selectOne(zT_LincJyusinTr);
    }

    public ExDBResults<ZT_LincJyusinTr> selectAllZT_LincJyusinTr() {
        StringBuilder jpql = new StringBuilder();
        QZT_LincJyusinTr qZT_LincJyusinTr =  new QZT_LincJyusinTr();
        jpql.append($SELECT);
        jpql.append(qZT_LincJyusinTr);
        jpql.append($FROM);
        jpql.append(qZT_LincJyusinTr.ZT_LincJyusinTr());
        jpql.append($ORDER_BY(qZT_LincJyusinTr.ztrsyoriymd.asc(), qZT_LincJyusinTr.ztrrenno10.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_LincJyusinTr).getResults();
    }
}
