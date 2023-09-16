package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KessanYokukiPRn;
import yuyu.def.db.meta.QZT_KessanYokukiPRn;

/**
 * 決算用翌期Ｐテーブル（連）(ZT_KessanYokukiPRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KessanYokukiPRnDao extends AbstractDao<ZT_KessanYokukiPRn> {

    public ZT_KessanYokukiPRnDao() {
        super(ZT_KessanYokukiPRn.class);
    }

    public ZT_KessanYokukiPRn getKessanYokukiPRn(String pZrnkeijyouym, String pZrnsyono) {
        ZT_KessanYokukiPRn zT_KessanYokukiPRn =  new ZT_KessanYokukiPRn();
        zT_KessanYokukiPRn.setZrnkeijyouym(pZrnkeijyouym);
        zT_KessanYokukiPRn.setZrnsyono(pZrnsyono);
        return this.selectOne(zT_KessanYokukiPRn);
    }

    public ExDBResults<ZT_KessanYokukiPRn> selectAllZT_KessanYokukiPRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_KessanYokukiPRn qZT_KessanYokukiPRn =  new QZT_KessanYokukiPRn();
        jpql.append($SELECT);
        jpql.append(qZT_KessanYokukiPRn);
        jpql.append($FROM);
        jpql.append(qZT_KessanYokukiPRn.ZT_KessanYokukiPRn());
        jpql.append($ORDER_BY(qZT_KessanYokukiPRn.zrnkeijyouym.asc(), qZT_KessanYokukiPRn.zrnsyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KessanYokukiPRn).getResults();
    }
}
