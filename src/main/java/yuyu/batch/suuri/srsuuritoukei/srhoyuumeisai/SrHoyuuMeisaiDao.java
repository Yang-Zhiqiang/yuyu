package yuyu.batch.suuri.srsuuritoukei.srhoyuumeisai;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.db.entity.SV_HoyuuMeisai;
import yuyu.def.db.meta.QSV_HoyuuMeisai;

/**
 * 保有明細情報作成DAOクラスです。
 */
public class SrHoyuuMeisaiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public ExDBResults<SV_HoyuuMeisai> getHoyuuMeisais(String pKbnkey) {

        QSV_HoyuuMeisai qSV_HoyuuMeisai = new QSV_HoyuuMeisai();

        String where = "";
        if (!BizUtil.isBlank(pKbnkey)) {
            where = $WHERE + qSV_HoyuuMeisai.kbnkey.eq(pKbnkey);
        }

        String strSql = $SELECT + qSV_HoyuuMeisai +
            $FROM + qSV_HoyuuMeisai.SV_HoyuuMeisai() +
            where
            ;

        return exDBEntityManager.createJPQL(strSql).bind(qSV_HoyuuMeisai).getResults();
    }
}
