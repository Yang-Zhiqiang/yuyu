package yuyu.batch.suuri.srsuuritoukei.srkaiyakuhenreikin;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.db.entity.SV_KiykHnriknSutugk;
import yuyu.def.db.meta.QSV_KiykHnriknSutugk;

/**
 * 解約返戻金相当額情報作成DAOクラスです。
 */
public class SrKaiyakuHenreikinDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public ExDBResults<SV_KiykHnriknSutugk> getKiykHnriknSutugks(String pKbnkey) {

        QSV_KiykHnriknSutugk qSV_KiykHnriknSutugk = new QSV_KiykHnriknSutugk();

        String where = "";
        if (!BizUtil.isBlank(pKbnkey)) {
            where = $WHERE + qSV_KiykHnriknSutugk.kbnkey.eq(pKbnkey);
        }

        String strSql = $SELECT + qSV_KiykHnriknSutugk +
            $FROM  + qSV_KiykHnriknSutugk.SV_KiykHnriknSutugk() +
            where
            ;

        return exDBEntityManager.createJPQL(strSql).bind(qSV_KiykHnriknSutugk).getResults();
    }
}
