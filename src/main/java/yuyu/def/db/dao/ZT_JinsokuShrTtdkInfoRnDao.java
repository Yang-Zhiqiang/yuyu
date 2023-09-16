package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_JinsokuShrTtdkInfoRn;
import yuyu.def.db.meta.QZT_JinsokuShrTtdkInfoRn;

/**
 * 迅速支払手続情報テーブル（連）(ZT_JinsokuShrTtdkInfoRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_JinsokuShrTtdkInfoRnDao extends AbstractDao<ZT_JinsokuShrTtdkInfoRn> {

    public ZT_JinsokuShrTtdkInfoRnDao() {
        super(ZT_JinsokuShrTtdkInfoRn.class);
    }

    public ZT_JinsokuShrTtdkInfoRn getJinsokuShrTtdkInfoRn(String pZrnsyorisosikicd, String pZrnsyoricd, String pZrnhknknshrsntkno, String pZrnsyoruiukeymd, String pZrnsyoriymd, String pZrndenymd, String pZrnsyono) {
        ZT_JinsokuShrTtdkInfoRn zT_JinsokuShrTtdkInfoRn =  new ZT_JinsokuShrTtdkInfoRn();
        zT_JinsokuShrTtdkInfoRn.setZrnsyorisosikicd(pZrnsyorisosikicd);
        zT_JinsokuShrTtdkInfoRn.setZrnsyoricd(pZrnsyoricd);
        zT_JinsokuShrTtdkInfoRn.setZrnhknknshrsntkno(pZrnhknknshrsntkno);
        zT_JinsokuShrTtdkInfoRn.setZrnsyoruiukeymd(pZrnsyoruiukeymd);
        zT_JinsokuShrTtdkInfoRn.setZrnsyoriymd(pZrnsyoriymd);
        zT_JinsokuShrTtdkInfoRn.setZrndenymd(pZrndenymd);
        zT_JinsokuShrTtdkInfoRn.setZrnsyono(pZrnsyono);
        return this.selectOne(zT_JinsokuShrTtdkInfoRn);
    }

    public ExDBResults<ZT_JinsokuShrTtdkInfoRn> selectAllZT_JinsokuShrTtdkInfoRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_JinsokuShrTtdkInfoRn qZT_JinsokuShrTtdkInfoRn =  new QZT_JinsokuShrTtdkInfoRn();
        jpql.append($SELECT);
        jpql.append(qZT_JinsokuShrTtdkInfoRn);
        jpql.append($FROM);
        jpql.append(qZT_JinsokuShrTtdkInfoRn.ZT_JinsokuShrTtdkInfoRn());
        jpql.append($ORDER_BY(qZT_JinsokuShrTtdkInfoRn.zrnsyorisosikicd.asc(), qZT_JinsokuShrTtdkInfoRn.zrnsyoricd.asc(), qZT_JinsokuShrTtdkInfoRn.zrnhknknshrsntkno.asc(), qZT_JinsokuShrTtdkInfoRn.zrnsyoruiukeymd.asc(), qZT_JinsokuShrTtdkInfoRn.zrnsyoriymd.asc(), qZT_JinsokuShrTtdkInfoRn.zrndenymd.asc(), qZT_JinsokuShrTtdkInfoRn.zrnsyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_JinsokuShrTtdkInfoRn).getResults();
    }
}
