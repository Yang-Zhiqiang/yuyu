package yuyu.batch.suuri.srsuuritoukei.srrrthndugthknvknsyuyu;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.suuri.srcommon.SrCommonKinouDao;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.ST_HoyuuMeisaiTyukeiyouItzHzn;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.suuri.detacher.SV_KiykSyuhnDataDetacher;
import yuyu.def.suuri.manager.SuuriDomManager;
import yuyu.def.suuri.sorter.SortSV_KiykSyuhnData;

/**
 * 利率変動型保険Ｖ検証用情報作成のＤＢアクセスクラス
 */
public class SrRrtHndugtHknVKnsyuyuDbaStatement {

    @Inject
    private SuuriDomManager suuriDomManager;

    @Inject
    private SrCommonKinouDao srCommonKinouDao;

    public ExDBResults<ST_HoyuuMeisaiTyukeiyouItzHzn> getHoyuuMeisaiTyukeiyouItzHzns(String pKijyunym,
        String pKakutyoujobcd, String[] pHknsyukigous) {

        ExDBResults<ST_HoyuuMeisaiTyukeiyouItzHzn> hoyuuMeisaiTyukeiyouItzHznLst = srCommonKinouDao
            .getHoyuuMeisaiTyukeiyouItzHzns(pKijyunym, pKakutyoujobcd, pHknsyukigous);

        return hoyuuMeisaiTyukeiyouItzHznLst;
    }

    public List<SV_KiykSyuhnData> getKiykSyuhnDatasBySyonoSyutkkbn(String pSyono, C_SyutkKbn pSyutkkbn) {

        List<SV_KiykSyuhnData> svKiykSyuhnDataList = suuriDomManager
            .getKiykSyuhnDatasBySyonoSyutkkbn(pSyono, pSyutkkbn);

        svKiykSyuhnDataList = SV_KiykSyuhnDataDetacher.detachKiykSyuhnDatatouched(svKiykSyuhnDataList);

        SortSV_KiykSyuhnData sortSVKiykSyuhnData = SWAKInjector.getInstance(SortSV_KiykSyuhnData.class);

        svKiykSyuhnDataList = sortSVKiykSyuhnData.OrderSV_KiykSyuhnDataByHenkousikibetukeyDesc(svKiykSyuhnDataList);

        return svKiykSyuhnDataList;
    }

    public IT_KykKihon getKykKihon(String pSyono) {

        IT_KykKihon kykKihon = srCommonKinouDao.getKykKihon(pSyono);

        return kykKihon;
    }

    public List<IT_HokenryouTmttkn> getHokenryouTmttkns(String pSyono, BizDateYM pKijyunym) {

        List<IT_HokenryouTmttkn> hokenryouTmttknLst = srCommonKinouDao.getHokenryouTmttkns(pSyono, pKijyunym);

        return hokenryouTmttknLst;
    }
}
