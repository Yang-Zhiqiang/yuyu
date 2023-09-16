package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AM_HonyakutsgSosikiCd;
import yuyu.def.db.meta.QAM_HonyakutsgSosikiCd;

/**
 * 翻訳対象外組織コードマスタ(AM_HonyakutsgSosikiCdDao) アクセス用の DAO クラスです。<br />
 */
public class AM_HonyakutsgSosikiCdDao extends AbstractDao<AM_HonyakutsgSosikiCd> {

    public AM_HonyakutsgSosikiCdDao() {
        super(AM_HonyakutsgSosikiCd.class);
    }

    public AM_HonyakutsgSosikiCd getHonyakutsgSosikiCd(String pSosikicd) {
        AM_HonyakutsgSosikiCd aM_HonyakutsgSosikiCd =  new AM_HonyakutsgSosikiCd();
        aM_HonyakutsgSosikiCd.setSosikicd(pSosikicd);
        return this.selectOne(aM_HonyakutsgSosikiCd);
    }

    public Long getHonyakutsgSosikiCdCount() {


        QAM_HonyakutsgSosikiCd qAM_HonyakutsgSosikiCd = new QAM_HonyakutsgSosikiCd();


        String strSql = $SELECT + $COUNT(qAM_HonyakutsgSosikiCd.sosikicd) +
            $FROM + qAM_HonyakutsgSosikiCd.AM_HonyakutsgSosikiCd();


        return em.createJPQL(strSql).bind(qAM_HonyakutsgSosikiCd).getSingleResult();
    }
}
