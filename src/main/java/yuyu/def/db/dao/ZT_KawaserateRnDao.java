package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KawaserateRn;
import yuyu.def.db.meta.QZT_KawaserateRn;

/**
 * 為替レートテーブル（連）(ZT_KawaserateRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KawaserateRnDao extends AbstractDao<ZT_KawaserateRn> {

    public ZT_KawaserateRnDao() {
        super(ZT_KawaserateRn.class);
    }

    public ZT_KawaserateRn getKawaserateRn(String pZrnkwsratekjymd, String pZrnkawaserendoukbn) {
        ZT_KawaserateRn zT_KawaserateRn =  new ZT_KawaserateRn();
        zT_KawaserateRn.setZrnkwsratekjymd(pZrnkwsratekjymd);
        zT_KawaserateRn.setZrnkawaserendoukbn(pZrnkawaserendoukbn);
        return this.selectOne(zT_KawaserateRn);
    }

    public ExDBResults<ZT_KawaserateRn> selectAllZT_KawaserateRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_KawaserateRn qZT_KawaserateRn =  new QZT_KawaserateRn();
        jpql.append($SELECT);
        jpql.append(qZT_KawaserateRn);
        jpql.append($FROM);
        jpql.append(qZT_KawaserateRn.ZT_KawaserateRn());
        jpql.append($ORDER_BY(qZT_KawaserateRn.zrnkwsratekjymd.asc(), qZT_KawaserateRn.zrnkawaserendoukbn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KawaserateRn).getResults();
    }
}
