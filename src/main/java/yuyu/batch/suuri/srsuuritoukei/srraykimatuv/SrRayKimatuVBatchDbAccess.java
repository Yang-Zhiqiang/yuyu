package yuyu.batch.suuri.srsuuritoukei.srraykimatuv;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.suuri.srcommon.SrCommonKinouDao;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.ST_HoyuuMeisaiTyukeiyouItzHzn;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.suuri.detacher.SV_KiykSyuhnDataDetacher;
import yuyu.def.suuri.manager.SuuriDomManager;
import yuyu.def.suuri.sorter.SortSV_KiykSyuhnData;

/**
 * 数理統計 数理統計 ＲＡＹ期末Ｖ情報作成のＤＢアクセスクラス
 */
public class SrRayKimatuVBatchDbAccess {

    @Inject
    private SuuriDomManager suuriDomManager;

    @Inject
    private SrCommonKinouDao srCommonKinouDao;

    public ExDBResults<ST_HoyuuMeisaiTyukeiyouItzHzn> getHoyuuMeisaiTyukeiyouItzHzns(String pKijyunym,
        String pKakutyoujobcd, String[] pHonsyuruikigou) {

        ExDBResults<ST_HoyuuMeisaiTyukeiyouItzHzn> hoyuuMeisaiTyukeiyouItzHznLst =
            srCommonKinouDao.getHoyuuMeisaiTyukeiyouItzHzns(pKijyunym, pKakutyoujobcd, pHonsyuruikigou);

        return hoyuuMeisaiTyukeiyouItzHznLst;
    }

    public List<SV_KiykSyuhnData> getKiykSyuhnData(String pSyno, C_SyutkKbn pSyutkKbn) {

        List<SV_KiykSyuhnData> kiykSyuhnDataLst = suuriDomManager.getKiykSyuhnDatasBySyonoSyutkkbn(pSyno, pSyutkKbn);

        kiykSyuhnDataLst = SV_KiykSyuhnDataDetacher.detachKiykSyuhnDatatouched(kiykSyuhnDataLst);

        SortSV_KiykSyuhnData sortSVKiykSyuhnData = SWAKInjector.getInstance(SortSV_KiykSyuhnData.class);
        kiykSyuhnDataLst = sortSVKiykSyuhnData.OrderSV_KiykSyuhnDataByHenkousikibetukeyDesc(kiykSyuhnDataLst);

        return kiykSyuhnDataLst;
    }

    public List<IT_KhSisuurendoTmttkn> getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymdAsc(String pSyono,
        BizDate pKijyunymd) {

        List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknLst =
            srCommonKinouDao.getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymdAsc(pSyono, pKijyunymd);

        return khSisuurendoTmttknLst;
    }
}
