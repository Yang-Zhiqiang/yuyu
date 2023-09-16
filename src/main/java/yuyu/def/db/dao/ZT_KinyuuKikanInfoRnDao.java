package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KinyuuKikanInfoRn;
import yuyu.def.db.meta.QZT_KinyuuKikanInfoRn;

/**
 * 金融機関情報連動ファイルテーブル（連）(ZT_KinyuuKikanInfoRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KinyuuKikanInfoRnDao extends AbstractDao<ZT_KinyuuKikanInfoRn> {

    public ZT_KinyuuKikanInfoRnDao() {
        super(ZT_KinyuuKikanInfoRn.class);
    }

    public ZT_KinyuuKikanInfoRn getKinyuuKikanInfoRn(String pZrnkinyuukikancd, String pZrnsitencd) {
        ZT_KinyuuKikanInfoRn zT_KinyuuKikanInfoRn =  new ZT_KinyuuKikanInfoRn();
        zT_KinyuuKikanInfoRn.setZrnkinyuukikancd(pZrnkinyuukikancd);
        zT_KinyuuKikanInfoRn.setZrnsitencd(pZrnsitencd);
        return this.selectOne(zT_KinyuuKikanInfoRn);
    }

    public ExDBResults<ZT_KinyuuKikanInfoRn> selectAllZT_KinyuuKikanInfoRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_KinyuuKikanInfoRn qZT_KinyuuKikanInfoRn =  new QZT_KinyuuKikanInfoRn();
        jpql.append($SELECT);
        jpql.append(qZT_KinyuuKikanInfoRn);
        jpql.append($FROM);
        jpql.append(qZT_KinyuuKikanInfoRn.ZT_KinyuuKikanInfoRn());
        jpql.append($ORDER_BY(qZT_KinyuuKikanInfoRn.zrnkinyuukikancd.asc(), qZT_KinyuuKikanInfoRn.zrnsitencd.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KinyuuKikanInfoRn).getResults();
    }

    public ExDBResults<ZT_KinyuuKikanInfoRn> getKinyuuKikanInfoRnsByZrnsitencdNe4Space() {


        QZT_KinyuuKikanInfoRn qZT_KinyuuKikanInfoRn =  new QZT_KinyuuKikanInfoRn();


        String  strSql = $SELECT + qZT_KinyuuKikanInfoRn +
            $FROM + qZT_KinyuuKikanInfoRn.ZT_KinyuuKikanInfoRn() +
            $WHERE + qZT_KinyuuKikanInfoRn.zrnsitencd.ne("    ") +
            $ORDER_BY(qZT_KinyuuKikanInfoRn.zrnkinyuukikancd.asc() + "," +
                qZT_KinyuuKikanInfoRn.zrnsitencd.asc());


        return em.createJPQL(strSql).bind(qZT_KinyuuKikanInfoRn).getResults();
    }

    public Long getKinyuuKikanInfoRnCountByZrnsitencdNe4Space(){
        QZT_KinyuuKikanInfoRn qZT_KinyuuKikanInfoRn = new QZT_KinyuuKikanInfoRn();
        String strSql = $SELECT + $COUNT(qZT_KinyuuKikanInfoRn.zrnkinyuukikancd) +
            $FROM + qZT_KinyuuKikanInfoRn.ZT_KinyuuKikanInfoRn()+
            $WHERE + qZT_KinyuuKikanInfoRn.zrnsitencd.ne("    ");

        return em.createJPQL(strSql).bind(qZT_KinyuuKikanInfoRn).getSingleResult();
    }


    public ExDBResults<ZT_KinyuuKikanInfoRn> getKinyuuKikanInfoRnsByZrnkinyuukikancdKeta4Zrnsitencd(
        String pZrnkinyuukikancdKeta4) {


        QZT_KinyuuKikanInfoRn qZT_KinyuuKikanInfoRn =  new QZT_KinyuuKikanInfoRn();


        String  strSql = $SELECT + qZT_KinyuuKikanInfoRn +
            $FROM + qZT_KinyuuKikanInfoRn.ZT_KinyuuKikanInfoRn() +
            $WHERE + qZT_KinyuuKikanInfoRn.zrnkinyuukikancd.substring(4, 1).eq(pZrnkinyuukikancdKeta4) +
            $AND + qZT_KinyuuKikanInfoRn.zrnsitencd.ne("    ") +
            $ORDER_BY(qZT_KinyuuKikanInfoRn.zrnkinyuukikancd.asc() + "," +
                qZT_KinyuuKikanInfoRn.zrnsitencd.asc());


        return em.createJPQL(strSql).bind(qZT_KinyuuKikanInfoRn).getResults();
    }

    public Long getKinyuuKikanInfoRnCountByZrnsitencdE4Space(){
        QZT_KinyuuKikanInfoRn qZT_KinyuuKikanInfoRn = new QZT_KinyuuKikanInfoRn();
        String strSql = $SELECT + $COUNT(qZT_KinyuuKikanInfoRn.zrnkinyuukikancd) +
            $FROM + qZT_KinyuuKikanInfoRn.ZT_KinyuuKikanInfoRn()+
            $WHERE + qZT_KinyuuKikanInfoRn.zrnsitencd.eq("    ");

        return em.createJPQL(strSql).bind(qZT_KinyuuKikanInfoRn).getSingleResult();
    }

    public ExDBResults<ZT_KinyuuKikanInfoRn> getKinyuuKikanInfoRnsByZrnsitencdE4Space() {


        QZT_KinyuuKikanInfoRn qZT_KinyuuKikanInfoRn =  new QZT_KinyuuKikanInfoRn();


        String  strSql = $SELECT + qZT_KinyuuKikanInfoRn +
            $FROM + qZT_KinyuuKikanInfoRn.ZT_KinyuuKikanInfoRn() +
            $WHERE + qZT_KinyuuKikanInfoRn.zrnsitencd.eq("    ") +
            $ORDER_BY(qZT_KinyuuKikanInfoRn.zrnkinyuukikancd.asc());


        return em.createJPQL(strSql).bind(qZT_KinyuuKikanInfoRn).getResults();
    }

}
