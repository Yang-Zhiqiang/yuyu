package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_DrtenIpToukeiTy;
import yuyu.def.db.meta.QZT_DrtenIpToukeiTy;

/**
 * 代理店用ＩＰ統計用Ｆテーブル（中）(ZT_DrtenIpToukeiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_DrtenIpToukeiTyDao extends AbstractDao<ZT_DrtenIpToukeiTy> {

    public ZT_DrtenIpToukeiTyDao() {
        super(ZT_DrtenIpToukeiTy.class);
    }

    public ZT_DrtenIpToukeiTy getDrtenIpToukeiTy(String pZtyeigyouhonbusisyacd, String pZtysosikicd, String pZtyatukaikojincd, String pZtymosym, String pZtymosno) {
        ZT_DrtenIpToukeiTy zT_DrtenIpToukeiTy =  new ZT_DrtenIpToukeiTy();
        zT_DrtenIpToukeiTy.setZtyeigyouhonbusisyacd(pZtyeigyouhonbusisyacd);
        zT_DrtenIpToukeiTy.setZtysosikicd(pZtysosikicd);
        zT_DrtenIpToukeiTy.setZtyatukaikojincd(pZtyatukaikojincd);
        zT_DrtenIpToukeiTy.setZtymosym(pZtymosym);
        zT_DrtenIpToukeiTy.setZtymosno(pZtymosno);
        return this.selectOne(zT_DrtenIpToukeiTy);
    }

    public ExDBResults<ZT_DrtenIpToukeiTy> selectAllZT_DrtenIpToukeiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_DrtenIpToukeiTy qZT_DrtenIpToukeiTy =  new QZT_DrtenIpToukeiTy();
        jpql.append($SELECT);
        jpql.append(qZT_DrtenIpToukeiTy);
        jpql.append($FROM);
        jpql.append(qZT_DrtenIpToukeiTy.ZT_DrtenIpToukeiTy());
        jpql.append($ORDER_BY(qZT_DrtenIpToukeiTy.ztyeigyouhonbusisyacd.asc(), qZT_DrtenIpToukeiTy.ztysosikicd.asc(), qZT_DrtenIpToukeiTy.ztyatukaikojincd.asc(), qZT_DrtenIpToukeiTy.ztymosym.asc(), qZT_DrtenIpToukeiTy.ztymosno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_DrtenIpToukeiTy).getResults();
    }
}
