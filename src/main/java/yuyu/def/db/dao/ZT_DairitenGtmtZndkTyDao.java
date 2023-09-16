package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_DairitenGtmtZndkTy;
import yuyu.def.db.meta.QZT_DairitenGtmtZndkTy;

/**
 * 代理店月末残高情報Ｆテーブル（中）(ZT_DairitenGtmtZndkTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_DairitenGtmtZndkTyDao extends AbstractDao<ZT_DairitenGtmtZndkTy> {

    public ZT_DairitenGtmtZndkTyDao() {
        super(ZT_DairitenGtmtZndkTy.class);
    }

    public ZT_DairitenGtmtZndkTy getDairitenGtmtZndkTy(String pZtydatakijyunymd, String pZtysyono) {
        ZT_DairitenGtmtZndkTy zT_DairitenGtmtZndkTy =  new ZT_DairitenGtmtZndkTy();
        zT_DairitenGtmtZndkTy.setZtydatakijyunymd(pZtydatakijyunymd);
        zT_DairitenGtmtZndkTy.setZtysyono(pZtysyono);
        return this.selectOne(zT_DairitenGtmtZndkTy);
    }

    public ExDBResults<ZT_DairitenGtmtZndkTy> selectAllZT_DairitenGtmtZndkTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_DairitenGtmtZndkTy qZT_DairitenGtmtZndkTy =  new QZT_DairitenGtmtZndkTy();
        jpql.append($SELECT);
        jpql.append(qZT_DairitenGtmtZndkTy);
        jpql.append($FROM);
        jpql.append(qZT_DairitenGtmtZndkTy.ZT_DairitenGtmtZndkTy());
        jpql.append($ORDER_BY(qZT_DairitenGtmtZndkTy.ztydatakijyunymd.asc(), qZT_DairitenGtmtZndkTy.ztysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_DairitenGtmtZndkTy).getResults();
    }
}
