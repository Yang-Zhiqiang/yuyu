package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SisuuRendouRn;
import yuyu.def.db.meta.QZT_SisuuRendouRn;

/**
 * 指数連動Ｆテーブル（連）(ZT_SisuuRendouRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SisuuRendouRnDao extends AbstractDao<ZT_SisuuRendouRn> {

    public ZT_SisuuRendouRnDao() {
        super(ZT_SisuuRendouRn.class);
    }

    public ZT_SisuuRendouRn getSisuuRendouRn(String pZrntorikomiyousisuukbn, String pZrnsisuukouhyouymd) {
        ZT_SisuuRendouRn zT_SisuuRendouRn =  new ZT_SisuuRendouRn();
        zT_SisuuRendouRn.setZrntorikomiyousisuukbn(pZrntorikomiyousisuukbn);
        zT_SisuuRendouRn.setZrnsisuukouhyouymd(pZrnsisuukouhyouymd);
        return this.selectOne(zT_SisuuRendouRn);
    }

    public ExDBResults<ZT_SisuuRendouRn> selectAllZT_SisuuRendouRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SisuuRendouRn qZT_SisuuRendouRn =  new QZT_SisuuRendouRn();
        jpql.append($SELECT);
        jpql.append(qZT_SisuuRendouRn);
        jpql.append($FROM);
        jpql.append(qZT_SisuuRendouRn.ZT_SisuuRendouRn());
        jpql.append($ORDER_BY(qZT_SisuuRendouRn.zrntorikomiyousisuukbn.asc(), qZT_SisuuRendouRn.zrnsisuukouhyouymd.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SisuuRendouRn).getResults();
    }
}
