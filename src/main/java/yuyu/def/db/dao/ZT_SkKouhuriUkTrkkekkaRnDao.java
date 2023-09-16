package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SkKouhuriUkTrkkekkaRn;
import yuyu.def.db.meta.QZT_SkKouhuriUkTrkkekkaRn;

/**
 * 新契約口振受付登録結果テーブル（連）(ZT_SkKouhuriUkTrkkekkaRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SkKouhuriUkTrkkekkaRnDao extends AbstractDao<ZT_SkKouhuriUkTrkkekkaRn> {

    public ZT_SkKouhuriUkTrkkekkaRnDao() {
        super(ZT_SkKouhuriUkTrkkekkaRn.class);
    }

    public ZT_SkKouhuriUkTrkkekkaRn getSkKouhuriUkTrkkekkaRn(String pZrnsyukkncd, String pZrnkinyuukikancd8keta, String pZrnkinyuukkntratkiymd, String pZrnkinyuukkntratkitime, String pZrnkouhuriokyakusamano) {
        ZT_SkKouhuriUkTrkkekkaRn zT_SkKouhuriUkTrkkekkaRn =  new ZT_SkKouhuriUkTrkkekkaRn();
        zT_SkKouhuriUkTrkkekkaRn.setZrnsyukkncd(pZrnsyukkncd);
        zT_SkKouhuriUkTrkkekkaRn.setZrnkinyuukikancd8keta(pZrnkinyuukikancd8keta);
        zT_SkKouhuriUkTrkkekkaRn.setZrnkinyuukkntratkiymd(pZrnkinyuukkntratkiymd);
        zT_SkKouhuriUkTrkkekkaRn.setZrnkinyuukkntratkitime(pZrnkinyuukkntratkitime);
        zT_SkKouhuriUkTrkkekkaRn.setZrnkouhuriokyakusamano(pZrnkouhuriokyakusamano);
        return this.selectOne(zT_SkKouhuriUkTrkkekkaRn);
    }

    public ExDBResults<ZT_SkKouhuriUkTrkkekkaRn> selectAllZT_SkKouhuriUkTrkkekkaRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SkKouhuriUkTrkkekkaRn qZT_SkKouhuriUkTrkkekkaRn =  new QZT_SkKouhuriUkTrkkekkaRn();
        jpql.append($SELECT);
        jpql.append(qZT_SkKouhuriUkTrkkekkaRn);
        jpql.append($FROM);
        jpql.append(qZT_SkKouhuriUkTrkkekkaRn.ZT_SkKouhuriUkTrkkekkaRn());
        jpql.append($ORDER_BY(qZT_SkKouhuriUkTrkkekkaRn.zrnsyukkncd.asc(), qZT_SkKouhuriUkTrkkekkaRn.zrnkinyuukikancd8keta.asc(), qZT_SkKouhuriUkTrkkekkaRn.zrnkinyuukkntratkiymd.asc(), qZT_SkKouhuriUkTrkkekkaRn.zrnkinyuukkntratkitime.asc(), qZT_SkKouhuriUkTrkkekkaRn.zrnkouhuriokyakusamano.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SkKouhuriUkTrkkekkaRn).getResults();
    }
}
