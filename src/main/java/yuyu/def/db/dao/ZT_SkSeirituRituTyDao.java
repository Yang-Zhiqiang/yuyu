package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SkSeirituRituTy;
import yuyu.def.db.meta.QZT_SkSeirituRituTy;

/**
 * 新契約成立率Ｆテーブル（中）(ZT_SkSeirituRituTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SkSeirituRituTyDao extends AbstractDao<ZT_SkSeirituRituTy> {

    public ZT_SkSeirituRituTyDao() {
        super(ZT_SkSeirituRituTy.class);
    }

    public ZT_SkSeirituRituTy getSkSeirituRituTy(String pZtyeigyouhonbusisyacd, String pZtysosikicd, String pZtyatukaikojincd, String pZtymosno) {
        ZT_SkSeirituRituTy zT_SkSeirituRituTy =  new ZT_SkSeirituRituTy();
        zT_SkSeirituRituTy.setZtyeigyouhonbusisyacd(pZtyeigyouhonbusisyacd);
        zT_SkSeirituRituTy.setZtysosikicd(pZtysosikicd);
        zT_SkSeirituRituTy.setZtyatukaikojincd(pZtyatukaikojincd);
        zT_SkSeirituRituTy.setZtymosno(pZtymosno);
        return this.selectOne(zT_SkSeirituRituTy);
    }

    public ExDBResults<ZT_SkSeirituRituTy> selectAllZT_SkSeirituRituTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SkSeirituRituTy qZT_SkSeirituRituTy =  new QZT_SkSeirituRituTy();
        jpql.append($SELECT);
        jpql.append(qZT_SkSeirituRituTy);
        jpql.append($FROM);
        jpql.append(qZT_SkSeirituRituTy.ZT_SkSeirituRituTy());
        jpql.append($ORDER_BY(qZT_SkSeirituRituTy.ztyeigyouhonbusisyacd.asc(), qZT_SkSeirituRituTy.ztysosikicd.asc(), qZT_SkSeirituRituTy.ztyatukaikojincd.asc(), qZT_SkSeirituRituTy.ztymosno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SkSeirituRituTy).getResults();
    }
}
