package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_DairitenBuntanInfoRn;
import yuyu.def.db.meta.QZT_DairitenBuntanInfoRn;

/**
 * 代理店手数料分担情報Ｆテーブル（連）(ZT_DairitenBuntanInfoRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_DairitenBuntanInfoRnDao extends AbstractDao<ZT_DairitenBuntanInfoRn> {

    public ZT_DairitenBuntanInfoRnDao() {
        super(ZT_DairitenBuntanInfoRn.class);
    }

    public ZT_DairitenBuntanInfoRn getDairitenBuntanInfoRn(String pZrndairitencd, String pZrndairitensyouhincd, String pZrntesuuryoubuntandrtencd, String pZrntesuuryoubuntanstartym) {
        ZT_DairitenBuntanInfoRn zT_DairitenBuntanInfoRn =  new ZT_DairitenBuntanInfoRn();
        zT_DairitenBuntanInfoRn.setZrndairitencd(pZrndairitencd);
        zT_DairitenBuntanInfoRn.setZrndairitensyouhincd(pZrndairitensyouhincd);
        zT_DairitenBuntanInfoRn.setZrntesuuryoubuntandrtencd(pZrntesuuryoubuntandrtencd);
        zT_DairitenBuntanInfoRn.setZrntesuuryoubuntanstartym(pZrntesuuryoubuntanstartym);
        return this.selectOne(zT_DairitenBuntanInfoRn);
    }

    public ExDBResults<ZT_DairitenBuntanInfoRn> selectAllZT_DairitenBuntanInfoRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_DairitenBuntanInfoRn qZT_DairitenBuntanInfoRn =  new QZT_DairitenBuntanInfoRn();
        jpql.append($SELECT);
        jpql.append(qZT_DairitenBuntanInfoRn);
        jpql.append($FROM);
        jpql.append(qZT_DairitenBuntanInfoRn.ZT_DairitenBuntanInfoRn());
        jpql.append($ORDER_BY(qZT_DairitenBuntanInfoRn.zrndairitencd.asc(), qZT_DairitenBuntanInfoRn.zrndairitensyouhincd.asc(), qZT_DairitenBuntanInfoRn.zrntesuuryoubuntandrtencd.asc(), qZT_DairitenBuntanInfoRn.zrntesuuryoubuntanstartym.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_DairitenBuntanInfoRn).getResults();
    }

    public Long getDairitenBuntanInfoRnCount(){


        QZT_DairitenBuntanInfoRn qZT_DairitenBuntanInfoRn =  new QZT_DairitenBuntanInfoRn();

        String strSql = $SELECT + $COUNT(qZT_DairitenBuntanInfoRn.zrndairitencd) +
            $FROM + qZT_DairitenBuntanInfoRn.ZT_DairitenBuntanInfoRn();

        return em.createJPQL(strSql).bind(qZT_DairitenBuntanInfoRn).getSingleResult();
    }
}
