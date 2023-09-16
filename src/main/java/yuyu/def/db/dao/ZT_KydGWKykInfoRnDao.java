package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KydGWKykInfoRn;
import yuyu.def.db.meta.QZT_KydGWKykInfoRn;

/**
 * 共同GW用契約情報Ｆテーブル（連）(ZT_KydGWKykInfoRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KydGWKykInfoRnDao extends AbstractDao<ZT_KydGWKykInfoRn> {

    public ZT_KydGWKykInfoRnDao() {
        super(ZT_KydGWKykInfoRn.class);
    }

    public ZT_KydGWKykInfoRn getKydGWKykInfoRn(String pZrnsyono, String pZrnsyoriymd, Long pZrnkykmfksnctrlkh) {
        ZT_KydGWKykInfoRn zT_KydGWKykInfoRn =  new ZT_KydGWKykInfoRn();
        zT_KydGWKykInfoRn.setZrnsyono(pZrnsyono);
        zT_KydGWKykInfoRn.setZrnsyoriymd(pZrnsyoriymd);
        zT_KydGWKykInfoRn.setZrnkykmfksnctrlkh(pZrnkykmfksnctrlkh);
        return this.selectOne(zT_KydGWKykInfoRn);
    }

    public ExDBResults<ZT_KydGWKykInfoRn> selectAllZT_KydGWKykInfoRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_KydGWKykInfoRn qZT_KydGWKykInfoRn =  new QZT_KydGWKykInfoRn();
        jpql.append($SELECT);
        jpql.append(qZT_KydGWKykInfoRn);
        jpql.append($FROM);
        jpql.append(qZT_KydGWKykInfoRn.ZT_KydGWKykInfoRn());
        jpql.append($ORDER_BY(qZT_KydGWKykInfoRn.zrnsyono.asc(), qZT_KydGWKykInfoRn.zrnsyoriymd.asc(), qZT_KydGWKykInfoRn.zrnkykmfksnctrlkh.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KydGWKykInfoRn).getResults();
    }
}
