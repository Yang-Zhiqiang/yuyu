package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_IdCardYakusyokuRn;
import yuyu.def.db.meta.QZT_IdCardYakusyokuRn;

/**
 * ＩＤカードＦ役職テーブル（連）(ZT_IdCardYakusyokuRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_IdCardYakusyokuRnDao extends AbstractDao<ZT_IdCardYakusyokuRn> {

    public ZT_IdCardYakusyokuRnDao() {
        super(ZT_IdCardYakusyokuRn.class);
    }

    public ZT_IdCardYakusyokuRn getIdCardYakusyokuRn(String pZrnidkbn, String pZrnidcd, String pZrnyakusyokuhatureiymd, String pZrnyakusyokuhatureino) {
        ZT_IdCardYakusyokuRn zT_IdCardYakusyokuRn =  new ZT_IdCardYakusyokuRn();
        zT_IdCardYakusyokuRn.setZrnidkbn(pZrnidkbn);
        zT_IdCardYakusyokuRn.setZrnidcd(pZrnidcd);
        zT_IdCardYakusyokuRn.setZrnyakusyokuhatureiymd(pZrnyakusyokuhatureiymd);
        zT_IdCardYakusyokuRn.setZrnyakusyokuhatureino(pZrnyakusyokuhatureino);
        return this.selectOne(zT_IdCardYakusyokuRn);
    }

    public ExDBResults<ZT_IdCardYakusyokuRn> selectAllZT_IdCardYakusyokuRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_IdCardYakusyokuRn qZT_IdCardYakusyokuRn =  new QZT_IdCardYakusyokuRn();
        jpql.append($SELECT);
        jpql.append(qZT_IdCardYakusyokuRn);
        jpql.append($FROM);
        jpql.append(qZT_IdCardYakusyokuRn.ZT_IdCardYakusyokuRn());
        jpql.append($ORDER_BY(qZT_IdCardYakusyokuRn.zrnidkbn.asc(), qZT_IdCardYakusyokuRn.zrnidcd.asc(), qZT_IdCardYakusyokuRn.zrnyakusyokuhatureiymd.asc(), qZT_IdCardYakusyokuRn.zrnyakusyokuhatureino.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_IdCardYakusyokuRn).getResults();
    }

    public Long getIdCardYakusyokuRnCount(){


        QZT_IdCardYakusyokuRn qZT_IdCardYakusyokuRn = new QZT_IdCardYakusyokuRn();

        String strSql = $SELECT + $COUNT(qZT_IdCardYakusyokuRn.zrnidkbn) +
            $FROM + qZT_IdCardYakusyokuRn.ZT_IdCardYakusyokuRn();

        return em.createJPQL(strSql).bind(qZT_IdCardYakusyokuRn).getSingleResult();
    }
}
