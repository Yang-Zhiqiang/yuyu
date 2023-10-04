package yuyu.batch.hozen.khansyuu.khdattai.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.Transient;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_AnsyuRireki;
import yuyu.def.db.meta.QIT_TRDattai;

import com.google.common.collect.Collections2;

/**
 * 契約保全 案内収納 脱退処理Daoクラス
 */
public class KhDattaiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<DattaiBean> getDattaiBean(String pKakutyouJobCd) {

        QIT_TRDattai qIT_TRDattai = new QIT_TRDattai("qIT_TRDattai");

        String subQuery = $SELECT + $NEW(DattaiBean.class,
            qIT_TRDattai.syono,
            qIT_TRDattai.syoriYmd,
            qIT_TRDattai.dattaikeiro,
            qIT_TRDattai.bankcd,
            qIT_TRDattai.sitencd,
            qIT_TRDattai.yokinkbn,
            qIT_TRDattai.kouzano,
            qIT_TRDattai.hurihunokbn,
            qIT_TRDattai.hurikaeymd,
            qIT_TRDattai.creditdatakbn,
            qIT_TRDattai.creditcardno1,
            qIT_TRDattai.creditcardno2,
            qIT_TRDattai.creditcardno3,
            qIT_TRDattai.creditcardno4,
            qIT_TRDattai.creditbrerrorcd,
            qIT_TRDattai.dattaiym,
            qIT_TRDattai.kbnkey,
            qIT_TRDattai.nykkeiro,
            qIT_TRDattai.nyknaiyoukbn,
            qIT_TRDattai.jyutoukaisuuy,
            qIT_TRDattai.jyutoukaisuum,
            qIT_TRDattai.dattaitrrenno,
            qIT_TRDattai.creditkessaiyouno,
            qIT_TRDattai.cardbrandkbn,
            qIT_TRDattai.creditkaiinnosimo4keta) +
            $FROM (qIT_TRDattai) +
            $ORDER_BY(qIT_TRDattai.syono.asc());

        ExDBResults<DattaiBean> exDBResults = exDBEntityManager.createJPQL(subQuery, DattaiBean.class).bind(qIT_TRDattai).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }

    @Transient
    public List<IT_AnsyuRireki> getAnsyuRirekis(IT_AnsyuKihon pAnsyuKihon, C_NyknaiyouKbn pNyknaiyouKbn,
        BizDateYM pDattaiYm, C_Nykkeiro pNykkeiro, Integer pJyutoukaisuuy, Integer pJyutoukaisuum, BizDate pHurikaeymd) {

        List<IT_AnsyuRireki> ansyuRirekiList = pAnsyuKihon.getAnsyuRirekis();

        FilterAnsyuRirekiByNyknaiyouKbnItems filterAnsyuRirekiByNyknaiyouKbnItems =
            new FilterAnsyuRirekiByNyknaiyouKbnItems(pNyknaiyouKbn, pDattaiYm, pNykkeiro, pJyutoukaisuuy,
                pJyutoukaisuum, pHurikaeymd);

        ansyuRirekiList = new ArrayList<IT_AnsyuRireki>(Collections2.filter(ansyuRirekiList,
            filterAnsyuRirekiByNyknaiyouKbnItems));

        return ansyuRirekiList;
    }
}
