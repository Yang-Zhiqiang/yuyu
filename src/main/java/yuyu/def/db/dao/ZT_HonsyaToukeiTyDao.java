package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_HonsyaToukeiTy;
import yuyu.def.db.meta.QZT_HonsyaToukeiTy;

/**
 * 本社統計Ｆテーブル（中）(ZT_HonsyaToukeiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_HonsyaToukeiTyDao extends AbstractDao<ZT_HonsyaToukeiTy> {

    public ZT_HonsyaToukeiTyDao() {
        super(ZT_HonsyaToukeiTy.class);
    }

    public ZT_HonsyaToukeiTy getHonsyaToukeiTy(String pZtykijyunym, String pZtymosno) {
        ZT_HonsyaToukeiTy zT_HonsyaToukeiTy =  new ZT_HonsyaToukeiTy();
        zT_HonsyaToukeiTy.setZtykijyunym(pZtykijyunym);
        zT_HonsyaToukeiTy.setZtymosno(pZtymosno);
        return this.selectOne(zT_HonsyaToukeiTy);
    }

    public ExDBResults<ZT_HonsyaToukeiTy> selectAllZT_HonsyaToukeiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_HonsyaToukeiTy qZT_HonsyaToukeiTy =  new QZT_HonsyaToukeiTy();
        jpql.append($SELECT);
        jpql.append(qZT_HonsyaToukeiTy);
        jpql.append($FROM);
        jpql.append(qZT_HonsyaToukeiTy.ZT_HonsyaToukeiTy());
        jpql.append($ORDER_BY(qZT_HonsyaToukeiTy.ztykijyunym.asc(), qZT_HonsyaToukeiTy.ztymosno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_HonsyaToukeiTy).getResults();
    }
}
