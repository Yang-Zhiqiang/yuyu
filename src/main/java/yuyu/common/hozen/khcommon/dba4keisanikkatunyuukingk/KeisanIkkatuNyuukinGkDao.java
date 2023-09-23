package yuyu.common.hozen.khcommon.dba4keisanikkatunyuukingk;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.meta.QBM_SyouhnZokusei;

/**
 * 契約保全 契約保全共通 一括入金額計算Daoクラス
 */
public class KeisanIkkatuNyuukinGkDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public Long getSyouhnZokuseiCountByIkkatuUmu(String pSyouhncd,Integer pSyouhnsdno) {

        QBM_SyouhnZokusei qBM_SyouhnZokusei = new QBM_SyouhnZokusei("qBM_SyouhnZokusei");

        String strSql = $SELECT + $COUNT(qBM_SyouhnZokusei.ikkatubaraiumu) + $AS + "件数" +
            $FROM(qBM_SyouhnZokusei)+
            $WHERE + qBM_SyouhnZokusei.syouhncd.eq(pSyouhncd) +
            $AND + qBM_SyouhnZokusei.syouhnsdno.eq(pSyouhnsdno) +
            $AND + qBM_SyouhnZokusei.ikkatubaraiumu.eq(C_UmuKbn.ARI);

        return  exDBEntityManager.createJPQL(strSql).bind(qBM_SyouhnZokusei).getSingleResult();
    }
}
