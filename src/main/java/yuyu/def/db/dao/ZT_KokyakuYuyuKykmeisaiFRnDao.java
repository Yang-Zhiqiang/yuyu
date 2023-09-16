package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KokyakuYuyuKykmeisaiFRn;
import yuyu.def.db.meta.QZT_KokyakuYuyuKykmeisaiFRn;

/**
 * 顧客用ゆうゆう契約明細Ｆテーブル（連）(ZT_KokyakuYuyuKykmeisaiFRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KokyakuYuyuKykmeisaiFRnDao extends AbstractDao<ZT_KokyakuYuyuKykmeisaiFRn> {

    public ZT_KokyakuYuyuKykmeisaiFRnDao() {
        super(ZT_KokyakuYuyuKykmeisaiFRn.class);
    }

    public ZT_KokyakuYuyuKykmeisaiFRn getKokyakuYuyuKykmeisaiFRn(Integer pZrnsequenceno) {
        ZT_KokyakuYuyuKykmeisaiFRn zT_KokyakuYuyuKykmeisaiFRn =  new ZT_KokyakuYuyuKykmeisaiFRn();
        zT_KokyakuYuyuKykmeisaiFRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_KokyakuYuyuKykmeisaiFRn);
    }

    public ExDBResults<ZT_KokyakuYuyuKykmeisaiFRn> selectAllZT_KokyakuYuyuKykmeisaiFRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_KokyakuYuyuKykmeisaiFRn qZT_KokyakuYuyuKykmeisaiFRn =  new QZT_KokyakuYuyuKykmeisaiFRn();
        jpql.append($SELECT);
        jpql.append(qZT_KokyakuYuyuKykmeisaiFRn);
        jpql.append($FROM);
        jpql.append(qZT_KokyakuYuyuKykmeisaiFRn.ZT_KokyakuYuyuKykmeisaiFRn());
        jpql.append($ORDER_BY(qZT_KokyakuYuyuKykmeisaiFRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KokyakuYuyuKykmeisaiFRn).getResults();
    }
}
