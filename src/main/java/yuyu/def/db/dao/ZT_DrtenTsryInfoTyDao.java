package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_DrtenTsryInfoTy;
import yuyu.def.db.meta.QZT_DrtenTsryInfoTy;

/**
 * 代理店手数料情報Ｆテーブル（中）(ZT_DrtenTsryInfoTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_DrtenTsryInfoTyDao extends AbstractDao<ZT_DrtenTsryInfoTy> {

    public ZT_DrtenTsryInfoTyDao() {
        super(ZT_DrtenTsryInfoTy.class);
    }

    public ZT_DrtenTsryInfoTy getDrtenTsryInfoTy(String pZtydairitencd, String pZtybosyuunincd, String pZtysyono, String pZtykikaisyoriymd, Long pZtykykmfksnctrlkh, String pZtysikibetujyunjyo) {
        ZT_DrtenTsryInfoTy zT_DrtenTsryInfoTy =  new ZT_DrtenTsryInfoTy();
        zT_DrtenTsryInfoTy.setZtydairitencd(pZtydairitencd);
        zT_DrtenTsryInfoTy.setZtybosyuunincd(pZtybosyuunincd);
        zT_DrtenTsryInfoTy.setZtysyono(pZtysyono);
        zT_DrtenTsryInfoTy.setZtykikaisyoriymd(pZtykikaisyoriymd);
        zT_DrtenTsryInfoTy.setZtykykmfksnctrlkh(pZtykykmfksnctrlkh);
        zT_DrtenTsryInfoTy.setZtysikibetujyunjyo(pZtysikibetujyunjyo);
        return this.selectOne(zT_DrtenTsryInfoTy);
    }

    public ExDBResults<ZT_DrtenTsryInfoTy> selectAllZT_DrtenTsryInfoTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_DrtenTsryInfoTy qZT_DrtenTsryInfoTy =  new QZT_DrtenTsryInfoTy();
        jpql.append($SELECT);
        jpql.append(qZT_DrtenTsryInfoTy);
        jpql.append($FROM);
        jpql.append(qZT_DrtenTsryInfoTy.ZT_DrtenTsryInfoTy());
        jpql.append($ORDER_BY(qZT_DrtenTsryInfoTy.ztydairitencd.asc(), qZT_DrtenTsryInfoTy.ztybosyuunincd.asc(), qZT_DrtenTsryInfoTy.ztysyono.asc(), qZT_DrtenTsryInfoTy.ztykikaisyoriymd.asc(),qZT_DrtenTsryInfoTy.ztykykmfksnctrlkh.asc(),qZT_DrtenTsryInfoTy.ztysikibetujyunjyo.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_DrtenTsryInfoTy).getResults();
    }
}
