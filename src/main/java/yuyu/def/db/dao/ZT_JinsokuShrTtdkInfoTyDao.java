package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_JinsokuShrTtdkInfoTy;
import yuyu.def.db.meta.QZT_JinsokuShrTtdkInfoTy;

/**
 * 迅速支払手続情報テーブル（中）(ZT_JinsokuShrTtdkInfoTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_JinsokuShrTtdkInfoTyDao extends AbstractDao<ZT_JinsokuShrTtdkInfoTy> {

    public ZT_JinsokuShrTtdkInfoTyDao() {
        super(ZT_JinsokuShrTtdkInfoTy.class);
    }

    public ZT_JinsokuShrTtdkInfoTy getJinsokuShrTtdkInfoTy(String pZtysyorisosikicd, String pZtysyoricd, String pZtyhknknshrsntkno, String pZtysyoruiukeymd, String pZtysyoriymd, String pZtydenymd, String pZtysyono) {
        ZT_JinsokuShrTtdkInfoTy zT_JinsokuShrTtdkInfoTy =  new ZT_JinsokuShrTtdkInfoTy();
        zT_JinsokuShrTtdkInfoTy.setZtysyorisosikicd(pZtysyorisosikicd);
        zT_JinsokuShrTtdkInfoTy.setZtysyoricd(pZtysyoricd);
        zT_JinsokuShrTtdkInfoTy.setZtyhknknshrsntkno(pZtyhknknshrsntkno);
        zT_JinsokuShrTtdkInfoTy.setZtysyoruiukeymd(pZtysyoruiukeymd);
        zT_JinsokuShrTtdkInfoTy.setZtysyoriymd(pZtysyoriymd);
        zT_JinsokuShrTtdkInfoTy.setZtydenymd(pZtydenymd);
        zT_JinsokuShrTtdkInfoTy.setZtysyono(pZtysyono);
        return this.selectOne(zT_JinsokuShrTtdkInfoTy);
    }

    public ExDBResults<ZT_JinsokuShrTtdkInfoTy> selectAllZT_JinsokuShrTtdkInfoTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_JinsokuShrTtdkInfoTy qZT_JinsokuShrTtdkInfoTy =  new QZT_JinsokuShrTtdkInfoTy();
        jpql.append($SELECT);
        jpql.append(qZT_JinsokuShrTtdkInfoTy);
        jpql.append($FROM);
        jpql.append(qZT_JinsokuShrTtdkInfoTy.ZT_JinsokuShrTtdkInfoTy());
        jpql.append($ORDER_BY(qZT_JinsokuShrTtdkInfoTy.ztysyorisosikicd.asc(), qZT_JinsokuShrTtdkInfoTy.ztysyoricd.asc(), qZT_JinsokuShrTtdkInfoTy.ztyhknknshrsntkno.asc(), qZT_JinsokuShrTtdkInfoTy.ztysyoruiukeymd.asc(), qZT_JinsokuShrTtdkInfoTy.ztysyoriymd.asc(), qZT_JinsokuShrTtdkInfoTy.ztydenymd.asc(), qZT_JinsokuShrTtdkInfoTy.ztysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_JinsokuShrTtdkInfoTy).getResults();
    }
}
