package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_DairitenItakuSyouhnRn;
import yuyu.def.db.meta.QZT_DairitenItakuSyouhnRn;

/**
 * 代理店委託商品情報用連動Ｆテーブル（連）(ZT_DairitenItakuSyouhnRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_DairitenItakuSyouhnRnDao extends AbstractDao<ZT_DairitenItakuSyouhnRn> {

    public ZT_DairitenItakuSyouhnRnDao() {
        super(ZT_DairitenItakuSyouhnRn.class);
    }

    public ZT_DairitenItakuSyouhnRn getDairitenItakuSyouhnRn(String pZrndairitencd, String pZrndrtsyouhinsikibetukbnstr, String pZrndrthrkhouhoukbn, String pZrndrtplannmkbn, String pZrnitakuhknhnbkaisiymd) {
        ZT_DairitenItakuSyouhnRn zT_DairitenItakuSyouhnRn =  new ZT_DairitenItakuSyouhnRn();
        zT_DairitenItakuSyouhnRn.setZrndairitencd(pZrndairitencd);
        zT_DairitenItakuSyouhnRn.setZrndrtsyouhinsikibetukbnstr(pZrndrtsyouhinsikibetukbnstr);
        zT_DairitenItakuSyouhnRn.setZrndrthrkhouhoukbn(pZrndrthrkhouhoukbn);
        zT_DairitenItakuSyouhnRn.setZrndrtplannmkbn(pZrndrtplannmkbn);
        zT_DairitenItakuSyouhnRn.setZrnitakuhknhnbkaisiymd(pZrnitakuhknhnbkaisiymd);
        return this.selectOne(zT_DairitenItakuSyouhnRn);
    }

    public ExDBResults<ZT_DairitenItakuSyouhnRn> selectAllZT_DairitenItakuSyouhnRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_DairitenItakuSyouhnRn qZT_DairitenItakuSyouhnRn =  new QZT_DairitenItakuSyouhnRn();
        jpql.append($SELECT);
        jpql.append(qZT_DairitenItakuSyouhnRn);
        jpql.append($FROM);
        jpql.append(qZT_DairitenItakuSyouhnRn.ZT_DairitenItakuSyouhnRn());
        jpql.append($ORDER_BY(qZT_DairitenItakuSyouhnRn.zrndairitencd.asc(), qZT_DairitenItakuSyouhnRn.zrndrtsyouhinsikibetukbnstr.asc(), qZT_DairitenItakuSyouhnRn.zrndrthrkhouhoukbn.asc(), qZT_DairitenItakuSyouhnRn.zrndrtplannmkbn.asc(), qZT_DairitenItakuSyouhnRn.zrnitakuhknhnbkaisiymd.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_DairitenItakuSyouhnRn).getResults();
    }

    public Long getDairitenItakuSyouhnRnCount() {


        QZT_DairitenItakuSyouhnRn qZT_DairitenItakuSyouhnRn = new QZT_DairitenItakuSyouhnRn("qZT_DairitenItakuSyouhnRn");


        String strSql = $SELECT + $COUNT(qZT_DairitenItakuSyouhnRn.zrndairitencd) +
            $FROM (qZT_DairitenItakuSyouhnRn);


        return em.createJPQL(strSql).bind(qZT_DairitenItakuSyouhnRn).getSingleResult();
    }

}
