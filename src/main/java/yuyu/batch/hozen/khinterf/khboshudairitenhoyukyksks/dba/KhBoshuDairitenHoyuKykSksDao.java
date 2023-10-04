package yuyu.batch.hozen.khinterf.khboshudairitenhoyukyksks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KykSyouhnRireki;
import yuyu.def.db.meta.QIT_KykSyouhnRireki;

/**
 * 契約保全 インターフェイス  募集代理店保有契約Ｆ作成DAOクラス
 */
public class KhBoshuDairitenHoyuKykSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<IT_KykSyouhnRireki> getKykSyouhnRirekisBySyonoSyutkKbn(String pSyono, C_SyutkKbn pSyutkbn) {

        QIT_KykSyouhnRireki qIT_KykSyouhnRireki = new QIT_KykSyouhnRireki("qIT_KykSyouhnRireki");

        String strSql = $SELECT + qIT_KykSyouhnRireki +
            $FROM(qIT_KykSyouhnRireki) +
            $WHERE + qIT_KykSyouhnRireki.syono.eq(pSyono) +
            $AND + qIT_KykSyouhnRireki.syutkkbn.eq(pSyutkbn) +
            $ORDER_BY(qIT_KykSyouhnRireki.henkousikibetukey.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KykSyouhnRireki).getResultList();
    }

}
