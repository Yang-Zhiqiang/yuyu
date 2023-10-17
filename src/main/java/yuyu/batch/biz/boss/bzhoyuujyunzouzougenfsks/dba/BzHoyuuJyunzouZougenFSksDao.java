package yuyu.batch.biz.boss.bzhoyuujyunzouzougenfsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.entity.IT_KhHenkouRireki;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.meta.QIT_KhHenkouRireki;
import yuyu.def.db.meta.QIT_KykSyouhnHnkmae;

/**
 * 業務共通 ＢＯＳＳ 普保Ⅱ保有純増増減Ｆ作成の機能DAOクラス
 */
public class BzHoyuuJyunzouZougenFSksDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public IT_KykSyouhnHnkmae getKykSyouhnHnkmaeBySyono(String pSyono) {

        QIT_KykSyouhnHnkmae qIT_KykSyouhnHnkmae = new QIT_KykSyouhnHnkmae("qIT_KykSyouhnHnkmae");

        String strSql = $SELECT + qIT_KykSyouhnHnkmae +
            $FROM(qIT_KykSyouhnHnkmae) +
            $WHERE + qIT_KykSyouhnHnkmae.syono.eq(pSyono) +
            $ORDER_BY(qIT_KykSyouhnHnkmae.renno.desc());

        return exDBEntityManager.createJPQL(
            strSql).setFirstResult(0).setMaxResults(1).bind(qIT_KykSyouhnHnkmae).getSingleResult();
    }


    public List<IT_KhHenkouRireki> getKhHenkouRirekisBySyonoHenkousikibetukeyGyoumuKousinKinouTableidHenkoukoumokuid(String pSyono,
        String pHenkousikibetukey, String pGyoumuKousinKinou, String pTableid, String pHenkoukoumokuid) {

        QIT_KhHenkouRireki qIT_KhHenkouRireki = new QIT_KhHenkouRireki("qIT_KhHenkouRireki");

        String strSql = $SELECT + qIT_KhHenkouRireki +
            $FROM(qIT_KhHenkouRireki) +
            $WHERE + qIT_KhHenkouRireki.syono.eq(pSyono) +
            $AND + qIT_KhHenkouRireki.henkousikibetukey.eq(pHenkousikibetukey) +
            $AND + qIT_KhHenkouRireki.gyoumuKousinKinou.eq(pGyoumuKousinKinou) +
            $AND + qIT_KhHenkouRireki.tableid.eq(pTableid) +
            $AND + qIT_KhHenkouRireki.henkoukoumokuid.eq(pHenkoukoumokuid) +
            $ORDER_BY(qIT_KhHenkouRireki.gyoumuKousinTime.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhHenkouRireki).getResultList();

    }
}
