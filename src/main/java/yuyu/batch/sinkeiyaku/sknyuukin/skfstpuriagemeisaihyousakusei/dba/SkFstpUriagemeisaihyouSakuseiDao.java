package yuyu.batch.sinkeiyaku.sknyuukin.skfstpuriagemeisaihyousakusei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_CardBrandKbn;
import yuyu.def.classification.C_UriagekekkaKbn;
import yuyu.def.db.entity.HT_SkUriageData;
import yuyu.def.db.meta.QHT_SkUriageData;

/**
 * 新契約 入金 初回保険料売上請求明細票作成Daoクラス
 */
public class SkFstpUriagemeisaihyouSakuseiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<HT_SkUriageData> getSkUriageData(BizDate pCarddataSousinYmdFrom,
        BizDate pCarddataSousinYmdTo, C_UriagekekkaKbn pUriagekekkaKbn, List<C_CardBrandKbn> pCardbrandList) {

        QHT_SkUriageData qHT_SkUriageData = new QHT_SkUriageData("qHT_SkUriageData");

        String sql = $SELECT + qHT_SkUriageData +
            $FROM (qHT_SkUriageData) +
            $WHERE + qHT_SkUriageData.cardbrandkbn.in(pCardbrandList) +
            $AND   + qHT_SkUriageData.carddatasousinymd.ge(pCarddataSousinYmdFrom) +
            $AND   + qHT_SkUriageData.carddatasousinymd.le(pCarddataSousinYmdTo) +
            $AND   + qHT_SkUriageData.uriagekekkakbn.eq(pUriagekekkaKbn) +
            $ORDER_BY (qHT_SkUriageData.cardbrandkbn.asc(),
                qHT_SkUriageData.carddatasousinymd.asc(),
                qHT_SkUriageData.mosno.asc());

        ExDBResults<HT_SkUriageData> exDBResults = exDBEntityManager.createJPQL(sql, HT_SkUriageData.class)
            .bind(qHT_SkUriageData).getResults();

        return exDBResults;
    }
}
