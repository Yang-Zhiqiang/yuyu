package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AM_Sosiki;
import yuyu.def.db.meta.QAM_IdCard;
import yuyu.def.db.meta.QAM_Sosiki;
import yuyu.def.db.meta.QAT_UserIdKanren;

/**
 * 組織マスタ(AM_SosikiDao) アクセス用の DAO クラスです。<br />
 */
public class AM_SosikiDao extends AbstractDao<AM_Sosiki> {

    public AM_SosikiDao() {
        super(AM_Sosiki.class);
    }

    public AM_Sosiki getSosiki(String pSosikicd){
        AM_Sosiki aM_Sosiki =  new AM_Sosiki();
        aM_Sosiki.setSosikicd(pSosikicd);
        return this.selectOne(aM_Sosiki);
    }

    public List<AM_Sosiki> getSosikisByUserId(String pUserId) {


        QAT_UserIdKanren qAT_UserIdKanren = new QAT_UserIdKanren();
        QAM_IdCard qAM_IdCard = new QAM_IdCard();
        QAM_Sosiki qAM_Sosiki = new QAM_Sosiki();


        String strSubSql1 = $SELECT + qAT_UserIdKanren.idkbn +
            $FROM + qAT_UserIdKanren.AT_UserIdKanren() +
            $WHERE + qAT_UserIdKanren.userId.eq(pUserId) +
            $AND + qAT_UserIdKanren.idkbn.eq(qAM_IdCard.idkbn) +
            $AND + qAT_UserIdKanren.idcd.eq(qAM_IdCard.idcd);


        String strSubSql2 = $SELECT + qAM_IdCard.idkbn +
            $FROM + qAM_IdCard.AM_IdCard() +
            $WHERE + qAM_IdCard.syozokusosikicd.eq(qAM_Sosiki.sosikicd) +
            $AND + $EXISTS(strSubSql1);


        String strMainSql = $SELECT + qAM_Sosiki +
            $FROM + qAM_Sosiki.AM_Sosiki() +
            $WHERE + $EXISTS(strSubSql2);


        return em.createJPQL(strMainSql).bind(qAT_UserIdKanren, qAM_IdCard, qAM_Sosiki).getResultList();
    }
}
