package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_RrtHndugtHknVKnsyuyuRn;
import yuyu.def.db.meta.QZT_RrtHndugtHknVKnsyuyuRn;

/**
 * 利率変動型保険Ｖ検証用Ｆテーブル（連）(ZT_RrtHndugtHknVKnsyuyuRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_RrtHndugtHknVKnsyuyuRnDao extends AbstractDao<ZT_RrtHndugtHknVKnsyuyuRn> {

    public ZT_RrtHndugtHknVKnsyuyuRnDao() {
        super(ZT_RrtHndugtHknVKnsyuyuRn.class);
    }

    public ZT_RrtHndugtHknVKnsyuyuRn getRrtHndugtHknVKnsyuyuRn(Integer pZrnsequenceno) {
        ZT_RrtHndugtHknVKnsyuyuRn zT_RrtHndugtHknVKnsyuyuRn =  new ZT_RrtHndugtHknVKnsyuyuRn();
        zT_RrtHndugtHknVKnsyuyuRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_RrtHndugtHknVKnsyuyuRn);
    }

    public ExDBResults<ZT_RrtHndugtHknVKnsyuyuRn> selectAllZT_RrtHndugtHknVKnsyuyuRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_RrtHndugtHknVKnsyuyuRn qZT_RrtHndugtHknVKnsyuyuRn =  new QZT_RrtHndugtHknVKnsyuyuRn();
        jpql.append($SELECT);
        jpql.append(qZT_RrtHndugtHknVKnsyuyuRn);
        jpql.append($FROM);
        jpql.append(qZT_RrtHndugtHknVKnsyuyuRn.ZT_RrtHndugtHknVKnsyuyuRn());
        jpql.append($ORDER_BY(qZT_RrtHndugtHknVKnsyuyuRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_RrtHndugtHknVKnsyuyuRn).getResults();
    }
}
