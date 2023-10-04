package yuyu.batch.sinkeiyaku.skjyouhoukei.sksisyatoukeisks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.db.entity.HT_MostenkenRireki;
import yuyu.def.db.entity.HT_SkUriageData;
import yuyu.def.db.meta.QHT_MostenkenRireki;
import yuyu.def.db.meta.QHT_SkUriageData;

/**
 * 支社統計情報作成の機能DAO クラスです。<br />
 */
public class SkSisyaToukeiSksDao extends AbstractDao<HT_MostenkenRireki> {
    public SkSisyaToukeiSksDao() {
        super(HT_MostenkenRireki.class);
    }
    public HT_MostenkenRireki getMostenkenRirekiByMosnoKanryouMaxRenno(String pMosno) {

        QHT_MostenkenRireki mostenkenRireki = new QHT_MostenkenRireki();

        String subQuery = $SELECT + $MAX(mostenkenRireki.renno) +
            $FROM + mostenkenRireki.HT_MostenkenRireki() +
            $WHERE + mostenkenRireki.mosno.eq(pMosno) +
            $AND + mostenkenRireki.mostenkenkekkakbn.eq(C_SyorikekkaKbn.KANRYOU);

        String querySql = $SELECT + mostenkenRireki +
            $FROM + mostenkenRireki.HT_MostenkenRireki() +
            $WHERE + mostenkenRireki.mosno.eq(pMosno) +
            $AND + mostenkenRireki.renno + $EQ + $(subQuery);

        return em.createJPQL(querySql).bind(mostenkenRireki).getSingleResult();
    }

    public HT_SkUriageData getSkUriageDataInfo(String pCreditkessaiyouno) {

        QHT_SkUriageData qHT_SkUriageData = new QHT_SkUriageData("qHT_SkUriageData");

        String querySql = $SELECT + qHT_SkUriageData +
            $FROM(qHT_SkUriageData) +
            $WHERE + qHT_SkUriageData.creditkessaiyouno.eq(pCreditkessaiyouno);

        return em.createJPQL(querySql).bind(qHT_SkUriageData).getSingleResult();
    }
}
