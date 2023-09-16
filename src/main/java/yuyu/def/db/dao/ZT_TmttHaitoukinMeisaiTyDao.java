package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_TmttHaitoukinMeisaiTy;
import yuyu.def.db.meta.QZT_TmttHaitoukinMeisaiTy;

/**
 * 積立配当金明細Ｆテーブル（中）(ZT_TmttHaitoukinMeisaiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_TmttHaitoukinMeisaiTyDao extends AbstractDao<ZT_TmttHaitoukinMeisaiTy> {

    public ZT_TmttHaitoukinMeisaiTyDao() {
        super(ZT_TmttHaitoukinMeisaiTy.class);
    }

    public ZT_TmttHaitoukinMeisaiTy getTmttHaitoukinMeisaiTy(Integer pZtysequenceno) {
        ZT_TmttHaitoukinMeisaiTy zT_TmttHaitoukinMeisaiTy =  new ZT_TmttHaitoukinMeisaiTy();
        zT_TmttHaitoukinMeisaiTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_TmttHaitoukinMeisaiTy);
    }

    public ExDBResults<ZT_TmttHaitoukinMeisaiTy> selectAllZT_TmttHaitoukinMeisaiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_TmttHaitoukinMeisaiTy qZT_TmttHaitoukinMeisaiTy =  new QZT_TmttHaitoukinMeisaiTy();
        jpql.append($SELECT);
        jpql.append(qZT_TmttHaitoukinMeisaiTy);
        jpql.append($FROM);
        jpql.append(qZT_TmttHaitoukinMeisaiTy.ZT_TmttHaitoukinMeisaiTy());
        jpql.append($ORDER_BY(qZT_TmttHaitoukinMeisaiTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_TmttHaitoukinMeisaiTy).getResults();
    }
}
