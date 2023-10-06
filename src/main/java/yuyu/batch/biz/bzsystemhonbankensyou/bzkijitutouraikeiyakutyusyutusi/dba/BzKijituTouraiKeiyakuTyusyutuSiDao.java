package yuyu.batch.biz.bzsystemhonbankensyou.bzkijitutouraikeiyakutyusyutusi.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.meta.QBT_KijituTouraiHonbanKensyou;
import yuyu.def.db.meta.QJT_SiRireki;
import yuyu.def.db.meta.QJT_Sk;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

/**
 * 期日到来契約抽出（保険金）DAOクラス
 */
public class BzKijituTouraiKeiyakuTyusyutuSiDao {

    @Inject
    private ExDBEntityManager em;

    public void delKijituTouraiHonbanKensyouBySyoriYmdSubSystemId(BizDate pSyoriYmd, String pSubSystemId) {
        QBT_KijituTouraiHonbanKensyou qBT_KijituTouraiHonbanKensyou = new QBT_KijituTouraiHonbanKensyou(
            "qBT_KijituTouraiHonbanKensyou");

        String strSql = $DELETE_FROM(qBT_KijituTouraiHonbanKensyou) +
            $WHERE + qBT_KijituTouraiHonbanKensyou.syoriYmd.eq(pSyoriYmd) +
            $AND   + qBT_KijituTouraiHonbanKensyou.subSystemId.eq(pSubSystemId)
            ;

        em.createJPQL(strSql).bind(qBT_KijituTouraiHonbanKensyou).executeUpdate();
    }

    public ExDBResults<JT_Sk> getShrsyorisumikykBySyoriymdShrKekkaKbn(BizDate pSyoriYmd, C_ShrKekkaKbn... pShrKekkaKbn) {
        QJT_Sk qJT_Sk = new QJT_Sk("qJT_Sk");
        QJT_SiRireki qJT_SiRireki = new QJT_SiRireki("qJT_SiRireki");

        String querySql = $SELECT + qJT_Sk +
            $FROM (qJT_Sk, qJT_SiRireki) +
            $WHERE + qJT_Sk.skno.eq(qJT_SiRireki.skno) +
            $AND   + qJT_Sk.syono.eq(qJT_SiRireki.syono) +
            $AND   + qJT_Sk.seikyuurirekino.eq(qJT_SiRireki.seikyuurirekino) +
            $AND   + qJT_SiRireki.shrsyoriymd.eq(pSyoriYmd) +
            $AND   + qJT_SiRireki.shrkekkakbn.in(pShrKekkaKbn)
            ;

        return em.createJPQL(querySql).bind(qJT_Sk, qJT_SiRireki).getResults();
    }
}
