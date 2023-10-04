package yuyu.batch.hozen.khozen.khsisuurendotmttknhanei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.meta.QIT_KhSisuurendoTmttkn;
import yuyu.def.db.meta.QIT_KykSonotaTkyk;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QMT_KhHenkouUktkYyk;

/**
 * 契約保全 契約保全 指数連動積増型年金積立金反映DAO
 */
public class KhSisuurendoTmttknHaneiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhKykSyouhnBean> getKhKykSyouhnBeans(String[] pSyouhncds, C_SyutkKbn pSyutkkbn, C_YuukousyoumetuKbn pYuukousyoumetukbn,
        C_Kykjyoutai pKykjyoutai, String pKakutyoujobcd) {

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        String strSql = $SELECT + $NEW(KhKykSyouhnBean.class,
            qIT_KykSyouhn) +
            $FROM(qIT_KykSyouhn) +
            $WHERE + qIT_KykSyouhn.syouhncd.in(pSyouhncds) +
            $AND + qIT_KykSyouhn.syutkkbn.eq(pSyutkkbn) +
            $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(pYuukousyoumetukbn) +
            $AND + qIT_KykSyouhn.kykjyoutai.eq(pKykjyoutai) +
            $ORDER_BY(qIT_KykSyouhn.syono.asc());

        ExDBResults<KhKykSyouhnBean> exDBResults = exDBEntityManager.createJPQL(strSql, KhKykSyouhnBean.class).bind(qIT_KykSyouhn).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public IT_KhSisuurendoTmttkn getSisurendoTmttknInfo(String pSyono) {

        QIT_KhSisuurendoTmttkn qIT_KhSisuurendoTmttkn = new QIT_KhSisuurendoTmttkn("qIT_KhSisuurendoTmttkn");

        String strSql = $SELECT + qIT_KhSisuurendoTmttkn +
            $FROM(qIT_KhSisuurendoTmttkn) +
            $WHERE + qIT_KhSisuurendoTmttkn.syono.eq(pSyono) +
            $ORDER_BY(qIT_KhSisuurendoTmttkn.tmttknkouryokukaisiymd.desc(),
                qIT_KhSisuurendoTmttkn.renno.desc());

        return exDBEntityManager.createJPQL(strSql).setFirstResult(0).setMaxResults(1).bind(qIT_KhSisuurendoTmttkn)
            .getSingleResult();
    }

    public List<String> getKykHozenHenkoUktYyk(C_UktkSyoriKbn pUktksyorikbn, C_UktkJyoutaiKbn pUktkjyoutaikbn) {

        QMT_KhHenkouUktkYyk qMT_KhHenkouUktkYyk = new QMT_KhHenkouUktkYyk("qMT_KhHenkouUktkYyk");

        String strSql = $SELECT + qMT_KhHenkouUktkYyk.syono +
            $FROM(qMT_KhHenkouUktkYyk) +
            $WHERE + qMT_KhHenkouUktkYyk.uktksyorikbn.eq(pUktksyorikbn) +
            $AND + qMT_KhHenkouUktkYyk.uktkjyoutaikbn.eq(pUktkjyoutaikbn) +
            $ORDER_BY(qMT_KhHenkouUktkYyk.syono.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qMT_KhHenkouUktkYyk).getResultList();
    }

    public IT_KykSonotaTkyk getKykSonotaTkyk(String pSyono) {

        QIT_KykSonotaTkyk qIT_KykSonotaTkyk = new QIT_KykSonotaTkyk("qIT_KykSonotaTkyk");

        String strSql = $SELECT + qIT_KykSonotaTkyk +
            $FROM(qIT_KykSonotaTkyk) +
            $WHERE + qIT_KykSonotaTkyk.syono.eq(pSyono);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KykSonotaTkyk).getSingleResult();
    }
}
