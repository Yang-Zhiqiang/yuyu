package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_OnlineLincSousinTy;
import yuyu.def.db.meta.QZT_OnlineLincSousinTy;

/**
 * オンラインＬＩＮＣ送信ファイルテーブル（中）(ZT_OnlineLincSousinTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_OnlineLincSousinTyDao extends AbstractDao<ZT_OnlineLincSousinTy> {

    public ZT_OnlineLincSousinTyDao() {
        super(ZT_OnlineLincSousinTy.class);
    }

    public ZT_OnlineLincSousinTy getOnlineLincSousinTy(String pZtyrecordsyubetukbn, String pZtykykkanrino) {
        ZT_OnlineLincSousinTy zT_OnlineLincSousinTy =  new ZT_OnlineLincSousinTy();
        zT_OnlineLincSousinTy.setZtyrecordsyubetukbn(pZtyrecordsyubetukbn);
        zT_OnlineLincSousinTy.setZtykykkanrino(pZtykykkanrino);
        return this.selectOne(zT_OnlineLincSousinTy);
    }

    public ExDBResults<ZT_OnlineLincSousinTy> selectAllZT_OnlineLincSousinTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_OnlineLincSousinTy qZT_OnlineLincSousinTy =  new QZT_OnlineLincSousinTy();
        jpql.append($SELECT);
        jpql.append(qZT_OnlineLincSousinTy);
        jpql.append($FROM);
        jpql.append(qZT_OnlineLincSousinTy.ZT_OnlineLincSousinTy());
        jpql.append($ORDER_BY(qZT_OnlineLincSousinTy.ztyrecordsyubetukbn.asc(), qZT_OnlineLincSousinTy.ztykykkanrino.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_OnlineLincSousinTy).getResults();
    }
}
