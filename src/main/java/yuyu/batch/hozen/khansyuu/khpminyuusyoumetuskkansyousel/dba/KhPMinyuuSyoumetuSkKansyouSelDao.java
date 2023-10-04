package yuyu.batch.hozen.khansyuu.khpminyuusyoumetuskkansyousel.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.meta.QBM_SyouhnZokusei;
import yuyu.def.db.meta.QIT_HhknSya;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSya;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QIT_PMinyuuSyoumetuInfo;

/**
 * 契約保全 案内収納 Ｐ未入消滅請求勧奨抽出DAOクラス
 */
public class KhPMinyuuSyoumetuSkKansyouSelDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<PMinyuuSyoumetuSkKansyouInfosBean> getPMinyuuSyoumetuSkKansyouInfos(String pKakutyoujobcd,
        BizDateYM pSyoriYm) {

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        QBM_SyouhnZokusei qBM_SyouhnZokusei = new QBM_SyouhnZokusei("qBM_SyouhnZokusei");

        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");

        QIT_HhknSya qIT_HhknSya = new QIT_HhknSya("qIT_HhknSya");

        QIT_PMinyuuSyoumetuInfo qIT_PMinyuuSyoumetuInfo = new QIT_PMinyuuSyoumetuInfo("qIT_PMinyuuSyoumetuInfo");

        String strSql = $SELECT + $NEW(PMinyuuSyoumetuSkKansyouInfosBean.class,
            qIT_KykKihon,
            qIT_KykSyouhn,
            qBM_SyouhnZokusei,
            qIT_KykSya,
            qIT_HhknSya,
            qIT_PMinyuuSyoumetuInfo) +
            $FROM (qIT_KykKihon,
                qIT_KykSyouhn,
                qBM_SyouhnZokusei,
                qIT_KykSya,
                qIT_HhknSya,
                qIT_PMinyuuSyoumetuInfo)  +
                $WHERE + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_KykSya.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_HhknSya.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_PMinyuuSyoumetuInfo.syono) +
                $AND + qIT_KykSyouhn.syouhncd.eq(qBM_SyouhnZokusei.syouhncd) +
                $AND + qIT_KykSyouhn.syouhnsdno.eq(qBM_SyouhnZokusei.syouhnsdno) +
                $AND + qIT_PMinyuuSyoumetuInfo.syoriym.le(pSyoriYm) +
                $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.SYOUMETU) +
                $AND + qIT_KykSyouhn.syoumetujiyuu.eq(C_Syoumetujiyuu.PMNYSYMET_MSSN) +
                $ORDER_BY  (qIT_PMinyuuSyoumetuInfo.syoumetuymd.asc(),
                    qIT_KykKihon.syono.asc());

        ExDBResults<PMinyuuSyoumetuSkKansyouInfosBean> exDBResults = exDBEntityManager.createJPQL(strSql,
            PMinyuuSyoumetuSkKansyouInfosBean.class).bind(qIT_KykKihon, qIT_KykSyouhn, qBM_SyouhnZokusei,
                qIT_KykSya, qIT_HhknSya, qIT_PMinyuuSyoumetuInfo).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}