package yuyu.batch.hozen.khkessan.khbikintyusyutu.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.entity.IT_KykSyouhnRireki;
import yuyu.def.db.meta.QIT_KykSyouhnRireki;

public class KhBikinTyusyutuDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public IT_KykSyouhnRireki getKykSyouhnRirekiBySyonoHenkousikibetukey(String pSyono, String pHenkousikibetukey) {

        QIT_KykSyouhnRireki qIT_KykSyouhnRireki = new QIT_KykSyouhnRireki("qIT_KykSyouhnRireki");

        String strSql = $SELECT + qIT_KykSyouhnRireki +
            $FROM(qIT_KykSyouhnRireki) +
            $WHERE + qIT_KykSyouhnRireki.syono.eq(pSyono) +
            $AND + qIT_KykSyouhnRireki.henkousikibetukey.eq(pHenkousikibetukey);

        IT_KykSyouhnRireki kykSyouhnRireki =
            exDBEntityManager.createJPQL(strSql).bind(qIT_KykSyouhnRireki).getSingleResult();

        return kykSyouhnRireki;
    }

}
