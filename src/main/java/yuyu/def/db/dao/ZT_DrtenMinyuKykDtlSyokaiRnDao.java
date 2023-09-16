package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_DrtenMinyuKykDtlSyokaiRn;
import yuyu.def.db.meta.QZT_DrtenMinyuKykDtlSyokaiRn;

/**
 * 代理店未入契約明細照会用Ｆテーブル（連）(ZT_DrtenMinyuKykDtlSyokaiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_DrtenMinyuKykDtlSyokaiRnDao extends AbstractDao<ZT_DrtenMinyuKykDtlSyokaiRn> {

    public ZT_DrtenMinyuKykDtlSyokaiRnDao() {
        super(ZT_DrtenMinyuKykDtlSyokaiRn.class);
    }

    public ZT_DrtenMinyuKykDtlSyokaiRn getDrtenMinyuKykDtlSyokaiRn(String pZrnsakuseiym, String pZrnbsydrtencd, String pZrntntusycd, String pZrnsyono) {
        ZT_DrtenMinyuKykDtlSyokaiRn zT_DrtenMinyuKykDtlSyokaiRn =  new ZT_DrtenMinyuKykDtlSyokaiRn();
        zT_DrtenMinyuKykDtlSyokaiRn.setZrnsakuseiym(pZrnsakuseiym);
        zT_DrtenMinyuKykDtlSyokaiRn.setZrnbsydrtencd(pZrnbsydrtencd);
        zT_DrtenMinyuKykDtlSyokaiRn.setZrntntusycd(pZrntntusycd);
        zT_DrtenMinyuKykDtlSyokaiRn.setZrnsyono(pZrnsyono);
        return this.selectOne(zT_DrtenMinyuKykDtlSyokaiRn);
    }

    public ExDBResults<ZT_DrtenMinyuKykDtlSyokaiRn> selectAllZT_DrtenMinyuKykDtlSyokaiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_DrtenMinyuKykDtlSyokaiRn qZT_DrtenMinyuKykDtlSyokaiRn =  new QZT_DrtenMinyuKykDtlSyokaiRn();
        jpql.append($SELECT);
        jpql.append(qZT_DrtenMinyuKykDtlSyokaiRn);
        jpql.append($FROM);
        jpql.append(qZT_DrtenMinyuKykDtlSyokaiRn.ZT_DrtenMinyuKykDtlSyokaiRn());
        jpql.append($ORDER_BY(qZT_DrtenMinyuKykDtlSyokaiRn.zrnsakuseiym.asc(), qZT_DrtenMinyuKykDtlSyokaiRn.zrnbsydrtencd.asc(), qZT_DrtenMinyuKykDtlSyokaiRn.zrntntusycd.asc(), qZT_DrtenMinyuKykDtlSyokaiRn.zrnsyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_DrtenMinyuKykDtlSyokaiRn).getResults();
    }
}
