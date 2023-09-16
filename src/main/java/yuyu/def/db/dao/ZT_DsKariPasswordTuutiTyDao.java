package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_DsKariPasswordTuutiTy;
import yuyu.def.db.meta.QZT_DsKariPasswordTuutiTy;

/**
 * 仮パスワード通知テーブル（中）(ZT_DsKariPasswordTuutiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_DsKariPasswordTuutiTyDao extends AbstractDao<ZT_DsKariPasswordTuutiTy> {

    public ZT_DsKariPasswordTuutiTyDao() {
        super(ZT_DsKariPasswordTuutiTy.class);
    }

    public ZT_DsKariPasswordTuutiTy getDsKariPasswordTuutiTy(String pZtykrpasswordtuutikey) {
        ZT_DsKariPasswordTuutiTy zT_DsKariPasswordTuutiTy =  new ZT_DsKariPasswordTuutiTy();
        zT_DsKariPasswordTuutiTy.setZtykrpasswordtuutikey(pZtykrpasswordtuutikey);
        return this.selectOne(zT_DsKariPasswordTuutiTy);
    }

    public ExDBResults<ZT_DsKariPasswordTuutiTy> selectAllZT_DsKariPasswordTuutiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_DsKariPasswordTuutiTy qZT_DsKariPasswordTuutiTy =  new QZT_DsKariPasswordTuutiTy();
        jpql.append($SELECT);
        jpql.append(qZT_DsKariPasswordTuutiTy);
        jpql.append($FROM);
        jpql.append(qZT_DsKariPasswordTuutiTy.ZT_DsKariPasswordTuutiTy());
        jpql.append($ORDER_BY(qZT_DsKariPasswordTuutiTy.ztykrpasswordtuutikey.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_DsKariPasswordTuutiTy).getResults();
    }
}
