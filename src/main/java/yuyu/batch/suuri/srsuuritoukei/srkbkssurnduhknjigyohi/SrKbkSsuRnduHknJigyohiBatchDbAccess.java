package yuyu.batch.suuri.srsuuritoukei.srkbkssurnduhknjigyohi;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.suuri.srcommon.SrCommonKinouDao;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.ST_HoyuuMeisaiTyukeiyouItzHzn;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.suuri.detacher.SV_KiykSyuhnDataDetacher;
import yuyu.def.suuri.manager.SuuriDomManager;
import yuyu.def.suuri.sorter.SortSV_KiykSyuhnData;

/**
 * 数理 数理統計 株価指数連動保険事業費情報作成のＤＢアクセスクラス
 */
public class SrKbkSsuRnduHknJigyohiBatchDbAccess {

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private SuuriDomManager suuriDomManager;

    @Inject
    private SrCommonKinouDao srCommonKinouDao;

    public ExDBResults<ST_HoyuuMeisaiTyukeiyouItzHzn> getHoyuuMeisaiTyukeiyouItzHzns(String pKijyunym,
        String pKakutyoujobcd, String[] pHknsyuruikigou) {

        ExDBResults<ST_HoyuuMeisaiTyukeiyouItzHzn> hoyuuMeisaiTyukeiyouItzHznLst = srCommonKinouDao
            .getHoyuuMeisaiTyukeiyouItzHzns(pKijyunym, pKakutyoujobcd, pHknsyuruikigou);

        return hoyuuMeisaiTyukeiyouItzHznLst;
    }

    public IT_KykKihon getKykKihon(String pSyono) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        return kykKihon;
    }

    public List<SV_KiykSyuhnData> getKiykSyuhnDatas(String pSyono, C_SyutkKbn pSyutkKbn) {

        List<SV_KiykSyuhnData> kiykSyuhnDataLst =
            suuriDomManager.getKiykSyuhnDatasBySyonoSyutkkbn(pSyono, pSyutkKbn);

        kiykSyuhnDataLst = SV_KiykSyuhnDataDetacher.detachKiykSyuhnDatatouched(kiykSyuhnDataLst);

        SortSV_KiykSyuhnData sortSVKiykSyuhnData = SWAKInjector.getInstance(SortSV_KiykSyuhnData.class);

        return sortSVKiykSyuhnData.OrderSV_KiykSyuhnDataByHenkousikibetukeyDesc(kiykSyuhnDataLst);
    }

    public List<IT_KhSisuurendoTmttkn> getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymdAsc(String pSyono,
        BizDate pKijyunymd) {

        return srCommonKinouDao.getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymdAsc(pSyono, pKijyunymd);
    }
}
