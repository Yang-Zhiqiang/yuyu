package yuyu.batch.hozen.khinterf.khoudrtenminyuukykdtlfsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.meta.QIT_DrtenMinyuKykNaiyou;

/**
 * 契約保全 インターフェイス ＯＵ代理店未入契約明細Ｆ作成Dao
 * DAO
 */
public class KhOuDrtenMinyuuKykDtlFSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<DrtenMinyuKykNaiyouBean> getMisyuupRendoBean(String pKakutyoujobcd,
        BizDateYM pSyoriYmd) {

        QIT_DrtenMinyuKykNaiyou qIT_DrtenMinyuKykNaiyou = new QIT_DrtenMinyuKykNaiyou("qIT_DrtenMinyuKykNaiyou");

        String strSql = $SELECT + $NEW(DrtenMinyuKykNaiyouBean.class,
            qIT_DrtenMinyuKykNaiyou.kbnkey,
            qIT_DrtenMinyuKykNaiyou.syono,
            qIT_DrtenMinyuKykNaiyou.keiyakuymd,
            qIT_DrtenMinyuKykNaiyou.bosyuuym,
            qIT_DrtenMinyuKykNaiyou.hrkkaisuu,
            qIT_DrtenMinyuKykNaiyou.hrkkeiro,
            qIT_DrtenMinyuKykNaiyou.mrarihyj,
            qIT_DrtenMinyuKykNaiyou.keizokutyuuihyj,
            qIT_DrtenMinyuKykNaiyou.syouhnnmkbn,
            qIT_DrtenMinyuKykNaiyou.jkipjytym,
            qIT_DrtenMinyuKykNaiyou.bosyuudairitenatkikeitaikbn,
            qIT_DrtenMinyuKykNaiyou.syuukeikbn,
            qIT_DrtenMinyuKykNaiyou.minyukaisuu,
            qIT_DrtenMinyuKykNaiyou.misyuup.getTypeFieldName(),
            qIT_DrtenMinyuKykNaiyou.misyuup.getValueFieldName(),
            qIT_DrtenMinyuKykNaiyou.hsys.getTypeFieldName(),
            qIT_DrtenMinyuKykNaiyou.hsys.getValueFieldName(),
            qIT_DrtenMinyuKykNaiyou.syuuseis.getTypeFieldName(),
            qIT_DrtenMinyuKykNaiyou.syuuseis.getValueFieldName(),
            qIT_DrtenMinyuKykNaiyou.hukkatutyuuikbn,
            qIT_DrtenMinyuKykNaiyou.fstttkekykhyj,
            qIT_DrtenMinyuKykNaiyou.ttkernzkkaisuu,
            qIT_DrtenMinyuKykNaiyou.syouhinbunruikbn,
            qIT_DrtenMinyuKykNaiyou.hknsyukigou,
            qIT_DrtenMinyuKykNaiyou.hurihunokbn,
            qIT_DrtenMinyuKykNaiyou.autocallkykhyj,
            qIT_DrtenMinyuKykNaiyou.dairitencd1,
            qIT_DrtenMinyuKykNaiyou.dairitencd2,
            qIT_DrtenMinyuKykNaiyou.ikkatubaraikbn,
            qIT_DrtenMinyuKykNaiyou.ikkatubaraikaisuu) +
            $FROM(qIT_DrtenMinyuKykNaiyou) +
            $WHERE + qIT_DrtenMinyuKykNaiyou.syoriym.eq(pSyoriYmd);
        ExDBResults<DrtenMinyuKykNaiyouBean> exDBResults = exDBEntityManager
            .createJPQL(strSql, DrtenMinyuKykNaiyouBean.class).bind(qIT_DrtenMinyuKykNaiyou).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}