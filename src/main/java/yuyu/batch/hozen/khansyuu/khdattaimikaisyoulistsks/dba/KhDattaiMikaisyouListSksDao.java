package yuyu.batch.hozen.khansyuu.khdattaimikaisyoulistsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.meta.QIT_DattaiUktk;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSyouhn;

/**
 * 契約保全 案内収納 脱退未解消リスト作成DAOクラス
 */
public class KhDattaiMikaisyouListSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhDattaiMikaishoBean> getDattaiMikaishoBeans(String pKakutyoujobcd,
        BizDate pDattaiMikaisyouListYmd) {
        QIT_DattaiUktk qIT_DattaiUktk = new QIT_DattaiUktk("qIT_DattaiUktk");
        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        String strSql = $SELECT + $NEW(KhDattaiMikaishoBean.class,
            qIT_DattaiUktk.kbnkey,
            qIT_DattaiUktk.syono,
            qIT_DattaiUktk.syoriYmd,
            qIT_DattaiUktk.syorisosikicd,
            qIT_DattaiUktk.dattaikeiro,
            qIT_DattaiUktk.dattairiyuukbn,
            qIT_DattaiUktk.comment124keta,
            qIT_DattaiUktk.gyoumuKousinsyaId) +
            $FROM (qIT_DattaiUktk, qIT_KykKihon, qIT_KykSyouhn) +
            $WHERE + (qIT_KykKihon.syono.eq(qIT_DattaiUktk.syono) +
                $AND + qIT_KykSyouhn.syono.eq(qIT_KykKihon.syono) +
                $AND + "(" +qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) + ")" +
                $AND + qIT_DattaiUktk.syoriYmd.le(pDattaiMikaisyouListYmd)) +
                $ORDER_BY  (qIT_DattaiUktk.syorisosikicd.asc(),
                    qIT_DattaiUktk.syoriYmd.asc(),
                    qIT_DattaiUktk.syono.asc());

        ExDBResults<KhDattaiMikaishoBean> exDBResults = exDBEntityManager.createJPQL(
            strSql, KhDattaiMikaishoBean.class).bind(qIT_DattaiUktk, qIT_KykKihon, qIT_KykSyouhn).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}
