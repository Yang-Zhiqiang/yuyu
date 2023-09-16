package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_UriageSousinTy;
import yuyu.def.db.meta.QZT_UriageSousinTy;

/**
 * 売上送信Ｆテーブル（中）(ZT_UriageSousinTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_UriageSousinTyDao extends AbstractDao<ZT_UriageSousinTy> {

    public ZT_UriageSousinTyDao() {
        super(ZT_UriageSousinTy.class);
    }

    public ZT_UriageSousinTy getUriageSousinTy(String pZtycreditkessaiyouno, String pZtysyono, String pZtyuriageseikyuuymd, Long pZtyrsgaku, String pZtyrecordno) {
        ZT_UriageSousinTy zT_UriageSousinTy =  new ZT_UriageSousinTy();
        zT_UriageSousinTy.setZtycreditkessaiyouno(pZtycreditkessaiyouno);
        zT_UriageSousinTy.setZtysyono(pZtysyono);
        zT_UriageSousinTy.setZtyuriageseikyuuymd(pZtyuriageseikyuuymd);
        zT_UriageSousinTy.setZtyrsgaku(pZtyrsgaku);
        zT_UriageSousinTy.setZtyrecordno(pZtyrecordno);
        return this.selectOne(zT_UriageSousinTy);
    }

    public ExDBResults<ZT_UriageSousinTy> selectAllZT_UriageSousinTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_UriageSousinTy qZT_UriageSousinTy =  new QZT_UriageSousinTy();
        jpql.append($SELECT);
        jpql.append(qZT_UriageSousinTy);
        jpql.append($FROM);
        jpql.append(qZT_UriageSousinTy.ZT_UriageSousinTy());
        jpql.append($ORDER_BY(qZT_UriageSousinTy.ztycreditkessaiyouno.asc(), qZT_UriageSousinTy.ztysyono.asc(), qZT_UriageSousinTy.ztyuriageseikyuuymd.asc(), qZT_UriageSousinTy.ztyrsgaku.asc(), qZT_UriageSousinTy.ztyrecordno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_UriageSousinTy).getResults();
    }
}
