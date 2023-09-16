package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KydGWKykInfoTy;
import yuyu.def.db.meta.QZT_KydGWKykInfoTy;

/**
 * 共同GW用契約情報Ｆテーブル（中）(ZT_KydGWKykInfoTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KydGWKykInfoTyDao extends AbstractDao<ZT_KydGWKykInfoTy> {

    public ZT_KydGWKykInfoTyDao() {
        super(ZT_KydGWKykInfoTy.class);
    }

    public ZT_KydGWKykInfoTy getKydGWKykInfoTy(String pZtysyono, String pZtysyoriymd, Long pZtykykmfksnctrlkh) {
        ZT_KydGWKykInfoTy zT_KydGWKykInfoTy =  new ZT_KydGWKykInfoTy();
        zT_KydGWKykInfoTy.setZtysyono(pZtysyono);
        zT_KydGWKykInfoTy.setZtysyoriymd(pZtysyoriymd);
        zT_KydGWKykInfoTy.setZtykykmfksnctrlkh(pZtykykmfksnctrlkh);
        return this.selectOne(zT_KydGWKykInfoTy);
    }

    public ExDBResults<ZT_KydGWKykInfoTy> selectAllZT_KydGWKykInfoTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_KydGWKykInfoTy qZT_KydGWKykInfoTy =  new QZT_KydGWKykInfoTy();
        jpql.append($SELECT);
        jpql.append(qZT_KydGWKykInfoTy);
        jpql.append($FROM);
        jpql.append(qZT_KydGWKykInfoTy.ZT_KydGWKykInfoTy());
        jpql.append($ORDER_BY(qZT_KydGWKykInfoTy.ztysyono.asc(), qZT_KydGWKykInfoTy.ztysyoriymd.asc(), qZT_KydGWKykInfoTy.ztykykmfksnctrlkh.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KydGWKykInfoTy).getResults();
    }
}
