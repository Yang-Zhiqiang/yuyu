package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_GkknHnkuSyrSynypTukiTy;
import yuyu.def.db.meta.QZT_GkknHnkuSyrSynypTukiTy;

/**
 * 月間変更処理収入Ｐ統計Fテーブル（中）(ZT_GkknHnkuSyrSynypTukiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_GkknHnkuSyrSynypTukiTyDao extends AbstractDao<ZT_GkknHnkuSyrSynypTukiTy> {

    public ZT_GkknHnkuSyrSynypTukiTyDao() {
        super(ZT_GkknHnkuSyrSynypTukiTy.class);
    }

    public ZT_GkknHnkuSyrSynypTukiTy getGkknHnkuSyrSynypTukiTy(Integer pZtysequenceno) {
        ZT_GkknHnkuSyrSynypTukiTy zT_GkknHnkuSyrSynypTukiTy =  new ZT_GkknHnkuSyrSynypTukiTy();
        zT_GkknHnkuSyrSynypTukiTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_GkknHnkuSyrSynypTukiTy);
    }

    public ExDBResults<ZT_GkknHnkuSyrSynypTukiTy> selectAllZT_GkknHnkuSyrSynypTukiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_GkknHnkuSyrSynypTukiTy qZT_GkknHnkuSyrSynypTukiTy =  new QZT_GkknHnkuSyrSynypTukiTy();
        jpql.append($SELECT);
        jpql.append(qZT_GkknHnkuSyrSynypTukiTy);
        jpql.append($FROM);
        jpql.append(qZT_GkknHnkuSyrSynypTukiTy.ZT_GkknHnkuSyrSynypTukiTy());
        jpql.append($ORDER_BY(qZT_GkknHnkuSyrSynypTukiTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_GkknHnkuSyrSynypTukiTy).getResults();
    }
}
