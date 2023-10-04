package yuyu.batch.hozen.khansyuu.khgentumiskmikomirituulfsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSyouhn;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

/**
 * 案内収納  限積用失効見込率算出用ＵＬＦ作成
 */
public class KhGentumiSkMikomirituULFSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<GentumiSkMikomirituULFBean> getGentumiSkMikomirituULFBeans() {

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        String strSql = $SELECT + $NEW(GentumiSkMikomirituULFBean.class,
            qIT_KykKihon.syono,
            qIT_KykSyouhn.syoumetujiyuu,
            qIT_KykSyouhn.syoumetuymd) +
            $FROM(qIT_KykKihon, qIT_KykSyouhn) +
            $WHERE + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
            $AND + qIT_KykSyouhn.kykjyoutai.ne(C_Kykjyoutai.ITIJIBARAI) +
            $AND + qIT_KykSyouhn.syoumetujiyuu.ne(C_Syoumetujiyuu.BLNK) +
            $AND + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono);

        return exDBEntityManager.createJPQL(strSql, GentumiSkMikomirituULFBean.class).bind(qIT_KykKihon, qIT_KykSyouhn).getResults();
    }
}
