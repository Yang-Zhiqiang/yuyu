package yuyu.batch.suuri.srsuuritoukei.srrayvknsyuyu;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
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
 * 数理 数理統計 ＲＡＹＶ検証用情報作成ＤＢアクセスクラス
 */
public class SrRayVKnsyuyuBatchDbAccess {

    @Inject
    private SuuriDomManager suuriDomManager;

    @Inject
    private SrCommonKinouDao srCommonKinouDao;

    public ExDBResults<ST_HoyuuMeisaiTyukeiyouItzHzn> getHoyuuMeisaiTyukeiyouItzHznLst(
        BizDateYM pKijyunym, String pKakutyouJobcd, String[] pHknsyukgu) {

        return srCommonKinouDao.getHoyuuMeisaiTyukeiyouItzHzns(pKijyunym.toString(), pKakutyouJobcd, pHknsyukgu);
    }

    public List<SV_KiykSyuhnData> getKiykSyuhnLst(String pSyono, C_SyutkKbn pSyutkKbn) {

        List<SV_KiykSyuhnData> kiykSyuhnDataLst = suuriDomManager.getKiykSyuhnDatasBySyonoSyutkkbn(pSyono, pSyutkKbn);

        kiykSyuhnDataLst = SV_KiykSyuhnDataDetacher.detachKiykSyuhnDatatouched(kiykSyuhnDataLst);

        SortSV_KiykSyuhnData sortSVKiykSyuhnData = SWAKInjector.getInstance(SortSV_KiykSyuhnData.class);
        kiykSyuhnDataLst = sortSVKiykSyuhnData.OrderSV_KiykSyuhnDataByHenkousikibetukeyDesc(kiykSyuhnDataLst);

        return kiykSyuhnDataLst;
    }

    public List<IT_KhSisuurendoTmttkn> getKhSisuurendoTmttknLst(String pSyono, BizDate pTmttknkouryokukaisiymd) {

        List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknLst =
            srCommonKinouDao.getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymdAsc(pSyono, pTmttknkouryokukaisiymd);

        return khSisuurendoTmttknLst;
    }

}