package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_ZennouHoyuuIdouKykDtlTy;
import yuyu.def.db.meta.QZT_ZennouHoyuuIdouKykDtlTy;

/**
 * 前納保有異動契約明細Ｆテーブル（中）(ZT_ZennouHoyuuIdouKykDtlTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_ZennouHoyuuIdouKykDtlTyDao extends AbstractDao<ZT_ZennouHoyuuIdouKykDtlTy> {

    public ZT_ZennouHoyuuIdouKykDtlTyDao() {
        super(ZT_ZennouHoyuuIdouKykDtlTy.class);
    }

    public ZT_ZennouHoyuuIdouKykDtlTy getZennouHoyuuIdouKykDtlTy(String pZtydatakanrino, String pZtysyoricd, Integer pZtykykmfksnctr) {
        ZT_ZennouHoyuuIdouKykDtlTy zT_ZennouHoyuuIdouKykDtlTy =  new ZT_ZennouHoyuuIdouKykDtlTy();
        zT_ZennouHoyuuIdouKykDtlTy.setZtydatakanrino(pZtydatakanrino);
        zT_ZennouHoyuuIdouKykDtlTy.setZtysyoricd(pZtysyoricd);
        zT_ZennouHoyuuIdouKykDtlTy.setZtykykmfksnctr(pZtykykmfksnctr);
        return this.selectOne(zT_ZennouHoyuuIdouKykDtlTy);
    }

    public ExDBResults<ZT_ZennouHoyuuIdouKykDtlTy> selectAllZT_ZennouHoyuuIdouKykDtlTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_ZennouHoyuuIdouKykDtlTy qZT_ZennouHoyuuIdouKykDtlTy =  new QZT_ZennouHoyuuIdouKykDtlTy();
        jpql.append($SELECT);
        jpql.append(qZT_ZennouHoyuuIdouKykDtlTy);
        jpql.append($FROM);
        jpql.append(qZT_ZennouHoyuuIdouKykDtlTy.ZT_ZennouHoyuuIdouKykDtlTy());
        jpql.append($ORDER_BY(qZT_ZennouHoyuuIdouKykDtlTy.ztydatakanrino.asc(), qZT_ZennouHoyuuIdouKykDtlTy.ztysyoricd.asc(), qZT_ZennouHoyuuIdouKykDtlTy.ztykykmfksnctr.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_ZennouHoyuuIdouKykDtlTy).getResults();
    }
}
