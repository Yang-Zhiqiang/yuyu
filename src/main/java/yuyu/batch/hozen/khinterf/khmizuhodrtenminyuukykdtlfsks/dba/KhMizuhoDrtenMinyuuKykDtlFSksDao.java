package yuyu.batch.hozen.khinterf.khmizuhodrtenminyuukykdtlfsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.meta.QIT_SeihowebMizuhoMinyuuDtl;

/**
 * 契約保全 インターフェイス みずほ代理店未入契約明細Ｆ作成機能DAOクラス
 */
public class KhMizuhoDrtenMinyuuKykDtlFSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<MizuhoMinyuuDtlBean> getMizuhoMinyuuDtlBeans(String pKakutyouJobCd, BizDateYM pSyoriYmd) {

        QIT_SeihowebMizuhoMinyuuDtl qIT_SeihowebMizuhoMinyuuDtl = new QIT_SeihowebMizuhoMinyuuDtl(
            "qIT_SeihowebMizuhoMinyuuDtl");

        String subQuery = $SELECT + $NEW(MizuhoMinyuuDtlBean.class,
            qIT_SeihowebMizuhoMinyuuDtl.kbnkey,
            qIT_SeihowebMizuhoMinyuuDtl.syono,
            qIT_SeihowebMizuhoMinyuuDtl.keiyakuymd,
            qIT_SeihowebMizuhoMinyuuDtl.bankcd,
            qIT_SeihowebMizuhoMinyuuDtl.sitencd,
            qIT_SeihowebMizuhoMinyuuDtl.kouzano,
            qIT_SeihowebMizuhoMinyuuDtl.kzmeiginmkn,
            qIT_SeihowebMizuhoMinyuuDtl.hrkkaisuu,
            qIT_SeihowebMizuhoMinyuuDtl.drtencd,
            qIT_SeihowebMizuhoMinyuuDtl.kyknm35keta,
            qIT_SeihowebMizuhoMinyuuDtl.hhknnmkj,
            qIT_SeihowebMizuhoMinyuuDtl.kykjyutikbn,
            qIT_SeihowebMizuhoMinyuuDtl.tsinkihontikucd,
            qIT_SeihowebMizuhoMinyuuDtl.kanjitsinkaiadr,
            qIT_SeihowebMizuhoMinyuuDtl.tsintelno,
            qIT_SeihowebMizuhoMinyuuDtl.dai2tsintelno,
            qIT_SeihowebMizuhoMinyuuDtl.yokinkbn,
            qIT_SeihowebMizuhoMinyuuDtl.hrkp.getTypeFieldName(),
            qIT_SeihowebMizuhoMinyuuDtl.hrkp.getValueFieldName(),
            qIT_SeihowebMizuhoMinyuuDtl.jkiannaikg.getTypeFieldName(),
            qIT_SeihowebMizuhoMinyuuDtl.jkiannaikg.getValueFieldName(),
            qIT_SeihowebMizuhoMinyuuDtl.yykknmnryymd,
            qIT_SeihowebMizuhoMinyuuDtl.skymd,
            qIT_SeihowebMizuhoMinyuuDtl.jhurikstkkahikbn,
            qIT_SeihowebMizuhoMinyuuDtl.hukkatumoskahikbn,
            qIT_SeihowebMizuhoMinyuuDtl.ttdkkigenymd,
            qIT_SeihowebMizuhoMinyuuDtl.hukkatukanoukknmnryymd,
            qIT_SeihowebMizuhoMinyuuDtl.keikamon3keta,
            qIT_SeihowebMizuhoMinyuuDtl.misyuuhasseiym,
            qIT_SeihowebMizuhoMinyuuDtl.misyuujiyuu,
            qIT_SeihowebMizuhoMinyuuDtl.minyusyoriymd,
            qIT_SeihowebMizuhoMinyuuDtl.nexthurikaeymd,
            qIT_SeihowebMizuhoMinyuuDtl.ikkatubaraikbn,
            qIT_SeihowebMizuhoMinyuuDtl.ikkatubaraikaisuu) +
            $FROM(qIT_SeihowebMizuhoMinyuuDtl) +
            $WHERE + qIT_SeihowebMizuhoMinyuuDtl.syoriym.eq(pSyoriYmd);

        ExDBResults<MizuhoMinyuuDtlBean> exDBResults = exDBEntityManager
            .createJPQL(subQuery, MizuhoMinyuuDtlBean.class).bind(qIT_SeihowebMizuhoMinyuuDtl).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }
}
