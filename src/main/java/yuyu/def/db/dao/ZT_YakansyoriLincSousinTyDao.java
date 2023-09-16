package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_YakansyoriLincSousinTy;
import yuyu.def.db.meta.QZT_YakansyoriLincSousinTy;

/**
 * 夜間処理ＬＩＮＣ送信ファイルテーブル（中）(ZT_YakansyoriLincSousinTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_YakansyoriLincSousinTyDao extends AbstractDao<ZT_YakansyoriLincSousinTy> {

    public ZT_YakansyoriLincSousinTyDao() {
        super(ZT_YakansyoriLincSousinTy.class);
    }

    public ZT_YakansyoriLincSousinTy getYakansyoriLincSousinTy(String pZtyrecordsyubetukbn, String pZtykykkanrino) {
        ZT_YakansyoriLincSousinTy zT_YakansyoriLincSousinTy =  new ZT_YakansyoriLincSousinTy();
        zT_YakansyoriLincSousinTy.setZtyrecordsyubetukbn(pZtyrecordsyubetukbn);
        zT_YakansyoriLincSousinTy.setZtykykkanrino(pZtykykkanrino);
        return this.selectOne(zT_YakansyoriLincSousinTy);
    }

    public ExDBResults<ZT_YakansyoriLincSousinTy> selectAllZT_YakansyoriLincSousinTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_YakansyoriLincSousinTy qZT_YakansyoriLincSousinTy =  new QZT_YakansyoriLincSousinTy();
        jpql.append($SELECT);
        jpql.append(qZT_YakansyoriLincSousinTy);
        jpql.append($FROM);
        jpql.append(qZT_YakansyoriLincSousinTy.ZT_YakansyoriLincSousinTy());
        jpql.append($ORDER_BY(qZT_YakansyoriLincSousinTy.ztyrecordsyubetukbn.asc(), qZT_YakansyoriLincSousinTy.ztykykkanrino.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_YakansyoriLincSousinTy).getResults();
    }
}
