package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_ZitkAzukarikinSrRendouTy;
import yuyu.def.db.meta.QZT_ZitkAzukarikinSrRendouTy;

/**
 * 税適預り金数理連動Ｆテーブル（中）(ZT_ZitkAzukarikinSrRendouTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_ZitkAzukarikinSrRendouTyDao extends AbstractDao<ZT_ZitkAzukarikinSrRendouTy> {

    public ZT_ZitkAzukarikinSrRendouTyDao() {
        super(ZT_ZitkAzukarikinSrRendouTy.class);
    }

    public ZT_ZitkAzukarikinSrRendouTy getZitkAzukarikinSrRendouTy(Integer pZtysequenceno) {
        ZT_ZitkAzukarikinSrRendouTy zT_ZitkAzukarikinSrRendouTy =  new ZT_ZitkAzukarikinSrRendouTy();
        zT_ZitkAzukarikinSrRendouTy.setZtysequenceno(pZtysequenceno);
        return this.selectOne(zT_ZitkAzukarikinSrRendouTy);
    }

    public ExDBResults<ZT_ZitkAzukarikinSrRendouTy> selectAllZT_ZitkAzukarikinSrRendouTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_ZitkAzukarikinSrRendouTy qZT_ZitkAzukarikinSrRendouTy =  new QZT_ZitkAzukarikinSrRendouTy();
        jpql.append($SELECT);
        jpql.append(qZT_ZitkAzukarikinSrRendouTy);
        jpql.append($FROM);
        jpql.append(qZT_ZitkAzukarikinSrRendouTy.ZT_ZitkAzukarikinSrRendouTy());
        jpql.append($ORDER_BY(qZT_ZitkAzukarikinSrRendouTy.ztysequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_ZitkAzukarikinSrRendouTy).getResults();
    }
}
