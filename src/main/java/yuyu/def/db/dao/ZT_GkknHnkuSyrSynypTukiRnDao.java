package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_GkknHnkuSyrSynypTukiRn;
import yuyu.def.db.meta.QZT_GkknHnkuSyrSynypTukiRn;

/**
 * 月間変更処理収入Ｐ統計Fテーブル（連）(ZT_GkknHnkuSyrSynypTukiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_GkknHnkuSyrSynypTukiRnDao extends AbstractDao<ZT_GkknHnkuSyrSynypTukiRn> {

    public ZT_GkknHnkuSyrSynypTukiRnDao() {
        super(ZT_GkknHnkuSyrSynypTukiRn.class);
    }

    public ZT_GkknHnkuSyrSynypTukiRn getGkknHnkuSyrSynypTukiRn(Integer pZrnsequenceno) {
        ZT_GkknHnkuSyrSynypTukiRn zT_GkknHnkuSyrSynypTukiRn =  new ZT_GkknHnkuSyrSynypTukiRn();
        zT_GkknHnkuSyrSynypTukiRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_GkknHnkuSyrSynypTukiRn);
    }

    public ExDBResults<ZT_GkknHnkuSyrSynypTukiRn> selectAllZT_GkknHnkuSyrSynypTukiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_GkknHnkuSyrSynypTukiRn qZT_GkknHnkuSyrSynypTukiRn =  new QZT_GkknHnkuSyrSynypTukiRn();
        jpql.append($SELECT);
        jpql.append(qZT_GkknHnkuSyrSynypTukiRn);
        jpql.append($FROM);
        jpql.append(qZT_GkknHnkuSyrSynypTukiRn.ZT_GkknHnkuSyrSynypTukiRn());
        jpql.append($ORDER_BY(qZT_GkknHnkuSyrSynypTukiRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_GkknHnkuSyrSynypTukiRn).getResults();
    }
}
