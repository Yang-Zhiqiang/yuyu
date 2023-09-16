package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KhDrtenMinyuuKykMeisaiRn;
import yuyu.def.db.meta.QZT_KhDrtenMinyuuKykMeisaiRn;

/**
 * 代理店未入契約明細テーブル（連）(ZT_KhDrtenMinyuuKykMeisaiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KhDrtenMinyuuKykMeisaiRnDao extends AbstractDao<ZT_KhDrtenMinyuuKykMeisaiRn> {

    public ZT_KhDrtenMinyuuKykMeisaiRnDao() {
        super(ZT_KhDrtenMinyuuKykMeisaiRn.class);
    }

    public ZT_KhDrtenMinyuuKykMeisaiRn getKhDrtenMinyuuKykMeisaiRn(String pZrnsyoriymd, String pZrnbsydrtencd, String pZrnsyono) {
        ZT_KhDrtenMinyuuKykMeisaiRn zT_KhDrtenMinyuuKykMeisaiRn =  new ZT_KhDrtenMinyuuKykMeisaiRn();
        zT_KhDrtenMinyuuKykMeisaiRn.setZrnsyoriymd(pZrnsyoriymd);
        zT_KhDrtenMinyuuKykMeisaiRn.setZrnbsydrtencd(pZrnbsydrtencd);
        zT_KhDrtenMinyuuKykMeisaiRn.setZrnsyono(pZrnsyono);
        return this.selectOne(zT_KhDrtenMinyuuKykMeisaiRn);
    }

    public ExDBResults<ZT_KhDrtenMinyuuKykMeisaiRn> selectAllZT_KhDrtenMinyuuKykMeisaiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_KhDrtenMinyuuKykMeisaiRn qZT_KhDrtenMinyuuKykMeisaiRn =  new QZT_KhDrtenMinyuuKykMeisaiRn();
        jpql.append($SELECT);
        jpql.append(qZT_KhDrtenMinyuuKykMeisaiRn);
        jpql.append($FROM);
        jpql.append(qZT_KhDrtenMinyuuKykMeisaiRn.ZT_KhDrtenMinyuuKykMeisaiRn());
        jpql.append($ORDER_BY(qZT_KhDrtenMinyuuKykMeisaiRn.zrnsyoriymd.asc(), qZT_KhDrtenMinyuuKykMeisaiRn.zrnbsydrtencd.asc(), qZT_KhDrtenMinyuuKykMeisaiRn.zrnsyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KhDrtenMinyuuKykMeisaiRn).getResults();
    }
}
