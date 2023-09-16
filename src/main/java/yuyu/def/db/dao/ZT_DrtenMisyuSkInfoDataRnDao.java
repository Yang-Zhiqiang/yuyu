package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_DrtenMisyuSkInfoDataRn;
import yuyu.def.db.meta.QZT_DrtenMisyuSkInfoDataRn;

/**
 * 代理店未収・失効情報連動データＦテーブル（連）(ZT_DrtenMisyuSkInfoDataRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_DrtenMisyuSkInfoDataRnDao extends AbstractDao<ZT_DrtenMisyuSkInfoDataRn> {

    public ZT_DrtenMisyuSkInfoDataRnDao() {
        super(ZT_DrtenMisyuSkInfoDataRn.class);
    }

    public ZT_DrtenMisyuSkInfoDataRn getDrtenMisyuSkInfoDataRn(String pZrnsyono, String pZrnbsydrtencd, String pZrnhanteiymd) {
        ZT_DrtenMisyuSkInfoDataRn zT_DrtenMisyuSkInfoDataRn =  new ZT_DrtenMisyuSkInfoDataRn();
        zT_DrtenMisyuSkInfoDataRn.setZrnsyono(pZrnsyono);
        zT_DrtenMisyuSkInfoDataRn.setZrnbsydrtencd(pZrnbsydrtencd);
        zT_DrtenMisyuSkInfoDataRn.setZrnhanteiymd(pZrnhanteiymd);
        return this.selectOne(zT_DrtenMisyuSkInfoDataRn);
    }

    public ExDBResults<ZT_DrtenMisyuSkInfoDataRn> selectAllZT_DrtenMisyuSkInfoDataRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_DrtenMisyuSkInfoDataRn qZT_DrtenMisyuSkInfoDataRn =  new QZT_DrtenMisyuSkInfoDataRn();
        jpql.append($SELECT);
        jpql.append(qZT_DrtenMisyuSkInfoDataRn);
        jpql.append($FROM);
        jpql.append(qZT_DrtenMisyuSkInfoDataRn.ZT_DrtenMisyuSkInfoDataRn());
        jpql.append($ORDER_BY(qZT_DrtenMisyuSkInfoDataRn.zrnsyono.asc(), qZT_DrtenMisyuSkInfoDataRn.zrnbsydrtencd.asc(), qZT_DrtenMisyuSkInfoDataRn.zrnhanteiymd.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_DrtenMisyuSkInfoDataRn).getResults();
    }
}
