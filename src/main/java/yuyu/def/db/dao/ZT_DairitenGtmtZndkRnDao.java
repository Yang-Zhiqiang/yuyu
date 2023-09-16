package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_DairitenGtmtZndkRn;
import yuyu.def.db.meta.QZT_DairitenGtmtZndkRn;

/**
 * 代理店月末残高情報Ｆテーブル（連）(ZT_DairitenGtmtZndkRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_DairitenGtmtZndkRnDao extends AbstractDao<ZT_DairitenGtmtZndkRn> {

    public ZT_DairitenGtmtZndkRnDao() {
        super(ZT_DairitenGtmtZndkRn.class);
    }

    public ZT_DairitenGtmtZndkRn getDairitenGtmtZndkRn(String pZrndatakijyunymd, String pZrnsyono) {
        ZT_DairitenGtmtZndkRn zT_DairitenGtmtZndkRn =  new ZT_DairitenGtmtZndkRn();
        zT_DairitenGtmtZndkRn.setZrndatakijyunymd(pZrndatakijyunymd);
        zT_DairitenGtmtZndkRn.setZrnsyono(pZrnsyono);
        return this.selectOne(zT_DairitenGtmtZndkRn);
    }

    public ExDBResults<ZT_DairitenGtmtZndkRn> selectAllZT_DairitenGtmtZndkRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_DairitenGtmtZndkRn qZT_DairitenGtmtZndkRn =  new QZT_DairitenGtmtZndkRn();
        jpql.append($SELECT);
        jpql.append(qZT_DairitenGtmtZndkRn);
        jpql.append($FROM);
        jpql.append(qZT_DairitenGtmtZndkRn.ZT_DairitenGtmtZndkRn());
        jpql.append($ORDER_BY(qZT_DairitenGtmtZndkRn.zrndatakijyunymd.asc(), qZT_DairitenGtmtZndkRn.zrnsyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_DairitenGtmtZndkRn).getResults();
    }
}
