package yuyu.batch.biz.boss.bzkeizokuriturenrakuulfsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.meta.QIT_KykSyouhnHnkmae;

/**
 * 業務共通 BOSS 普保Ⅱ継続率連絡データＵＬＦ作成の機能DAOクラス
 */
public class BzKeizokurituRenrakuUlfSksDao {

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

}
