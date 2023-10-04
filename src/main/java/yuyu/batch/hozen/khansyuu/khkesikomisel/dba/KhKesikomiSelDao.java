package yuyu.batch.hozen.khansyuu.khkesikomisel.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.db.entity.IT_KhKesikomiData;
import yuyu.def.db.meta.QIT_NyuukinKakusyouData;

/**
 * 契約保全 案内収納 消込データ抽出の機能DAO
 */
public class KhKesikomiSelDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<NyuukinKakusyouDataBean> getNyuukinKakusyouData(BizDate pSyoriYmd,
        C_Nykkeiro pNykkeiro, String pHeisoukbn) {

        QIT_NyuukinKakusyouData qIT_NyuukinKakusyouData = new QIT_NyuukinKakusyouData("qIT_NyuukinKakusyouData");

        String strSql = $SELECT + $NEW(NyuukinKakusyouDataBean.class,
            qIT_NyuukinKakusyouData.kbnkey,
            qIT_NyuukinKakusyouData.nyuukinkakusyouno,
            qIT_NyuukinKakusyouData.syono,
            qIT_NyuukinKakusyouData.nyuukinkakusyounrkymd,
            qIT_NyuukinKakusyouData.nyuuryokukbn,
            qIT_NyuukinKakusyouData.nykkeiro,
            qIT_NyuukinKakusyouData.nyknaiyoukbn,
            qIT_NyuukinKakusyouData.jyuutouym,
            qIT_NyuukinKakusyouData.rsgaku.getTypeFieldName(),
            qIT_NyuukinKakusyouData.rsgaku.getValueFieldName(),
            qIT_NyuukinKakusyouData.ryosyuymd,
            qIT_NyuukinKakusyouData.nykdenymd,
            qIT_NyuukinKakusyouData.nyuukinkakusyounrkno,
            qIT_NyuukinKakusyouData.suitono,
            qIT_NyuukinKakusyouData.suitoubumoncd,
            qIT_NyuukinKakusyouData.kzhurikaebankcd,
            qIT_NyuukinKakusyouData.tabakarikanjyono,
            qIT_NyuukinKakusyouData.hrkmyousinkkbn,
            qIT_NyuukinKakusyouData.suitososhikicd,
            qIT_NyuukinKakusyouData.syuudaikocd,
            qIT_NyuukinKakusyouData.credituriageseikyuukbn
            ) +
            $FROM(qIT_NyuukinKakusyouData) +
            $WHERE + qIT_NyuukinKakusyouData.nyksyoriymd.eq(pSyoriYmd);

        if (!BizUtil.isBlank(pHeisoukbn)){
            strSql = strSql + $AND + qIT_NyuukinKakusyouData.kbnkey.eq(pHeisoukbn);
        }

        if (pNykkeiro != null && !C_Nykkeiro.BLNK.eq(pNykkeiro)) {
            strSql = strSql + $AND + qIT_NyuukinKakusyouData.nykkeiro.eq(pNykkeiro);
        }

        ExDBResults<NyuukinKakusyouDataBean> exDBResults = exDBEntityManager
            .createJPQL(strSql, NyuukinKakusyouDataBean.class).bind(qIT_NyuukinKakusyouData).getResults();

        return exDBResults;
    }

    public void addInsertEntity(EntityInserter<IT_KhKesikomiData> pInserter,
        IT_KhKesikomiData pKhKesikomiData) {
        pInserter.add(pKhKesikomiData);
    }

}