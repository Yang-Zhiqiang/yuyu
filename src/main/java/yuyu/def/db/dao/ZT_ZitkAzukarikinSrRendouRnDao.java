package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_ZitkAzukarikinSrRendouRn;
import yuyu.def.db.meta.QZT_ZitkAzukarikinSrRendouRn;

/**
 * 税適預り金数理連動Ｆテーブル（連）(ZT_ZitkAzukarikinSrRendouRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_ZitkAzukarikinSrRendouRnDao extends AbstractDao<ZT_ZitkAzukarikinSrRendouRn> {

    public ZT_ZitkAzukarikinSrRendouRnDao() {
        super(ZT_ZitkAzukarikinSrRendouRn.class);
    }

    public ZT_ZitkAzukarikinSrRendouRn getZitkAzukarikinSrRendouRn(Integer pZrnsequenceno) {
        ZT_ZitkAzukarikinSrRendouRn zT_ZitkAzukarikinSrRendouRn =  new ZT_ZitkAzukarikinSrRendouRn();
        zT_ZitkAzukarikinSrRendouRn.setZrnsequenceno(pZrnsequenceno);
        return this.selectOne(zT_ZitkAzukarikinSrRendouRn);
    }

    public ExDBResults<ZT_ZitkAzukarikinSrRendouRn> selectAllZT_ZitkAzukarikinSrRendouRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_ZitkAzukarikinSrRendouRn qZT_ZitkAzukarikinSrRendouRn =  new QZT_ZitkAzukarikinSrRendouRn();
        jpql.append($SELECT);
        jpql.append(qZT_ZitkAzukarikinSrRendouRn);
        jpql.append($FROM);
        jpql.append(qZT_ZitkAzukarikinSrRendouRn.ZT_ZitkAzukarikinSrRendouRn());
        jpql.append($ORDER_BY(qZT_ZitkAzukarikinSrRendouRn.zrnsequenceno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_ZitkAzukarikinSrRendouRn).getResults();
    }
}
