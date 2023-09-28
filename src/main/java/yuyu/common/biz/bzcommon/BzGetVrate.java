package yuyu.common.biz.bzcommon;

import java.util.HashMap;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.suuri.srcommon.SrHokenSyuruiKigouSedaiConverter;
import yuyu.def.biz.detacher.BM_RateVDetacher;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_RateGetErrorKbn;
import yuyu.def.classification.C_VRateGetKbn;
import yuyu.def.db.entity.BM_RateV;

import com.google.common.base.Strings;

/**
 * 業務共通 業務共通 Ｖレート取得クラス
 */
public class BzGetVrate {

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private static Logger logger;

    @Inject
    private SrHokenSyuruiKigouSedaiConverter hokenSyuruiKigouSedaiConverter;

    private static final int KEIKANENSUU_MIN = 0;

    private static final int KEIKANENSUU_MAX = 99;

    public BzGetVrate() {
        super();
    }

    public BzGetVrateBean exec(
        String pSyouhnCd,
        String pRyouritusdNo,
        BizNumber pYoteiriritu,
        C_Hrkkaisuu pHrkkaisuu,
        C_Hhknsei pHhknsei,
        int pHhknnen,
        C_HknkknsmnKbn pHknkknsmnkbn,
        int pHknkkn,
        int pHrkkkn,
        C_VRateGetKbn pVRateGetKbn,
        int pKeikanensuu) {

        logger.debug("▽ Ｖレート取得 開始");

        BzGetVrateBean bzGetVrateBean = SWAKInjector.getInstance(BzGetVrateBean.class);

        String palSaimankiHyouji = "";

        String palHhknSei = "";

        String palHrkkaisuu = "";

        C_ErrorKbn errorKbn = chkKeikaNensu(
            pHknkknsmnkbn,
            pKeikanensuu,
            pHknkkn,
            pVRateGetKbn);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            bzGetVrateBean.setErrorKbn(C_ErrorKbn.ERROR);

            bzGetVrateBean.setRateGetErrorKbn(C_RateGetErrorKbn.INPUTERROR);

            logger.debug("△ Ｖレート取得 終了");

            return bzGetVrateBean;

        }

        if (C_HknkknsmnKbn.SAIMANKI.eq(pHknkknsmnkbn)) {

            palSaimankiHyouji = "1";
        }
        else if (C_HknkknsmnKbn.NENMANKI.eq(pHknkknsmnkbn)) {

            palSaimankiHyouji = "0";
        }

        if (C_Hhknsei.MALE.eq(pHhknsei)) {

            palHhknSei = "1";
        }
        else if (C_Hhknsei.FEMALE.eq(pHhknsei)) {

            palHhknSei = "2";
        }

        if (C_Hrkkaisuu.ITIJI.eq(pHrkkaisuu)) {

            palHrkkaisuu = "0";
        }

        BM_RateV bM_RateV = bizDomManager.getRateV(
            pSyouhnCd.substring(0, 2),
            hokenSyuruiKigouSedaiConverter.convert(pRyouritusdNo.substring(0, 1)),
            Strings.padStart(String.valueOf(pYoteiriritu.multiply(10000)), 5, '0').substring(2),
            "9",
            palHrkkaisuu,
            palHhknSei,
            Strings.padStart(String.valueOf(pHhknnen),3,'0'),
            palSaimankiHyouji,
            Strings.padStart(String.valueOf(pHknkkn),2,'0'),
            Strings.padStart(String.valueOf(pHrkkkn),2,'0'));

        if (bM_RateV == null) {

            bzGetVrateBean.setErrorKbn(C_ErrorKbn.ERROR);

            bzGetVrateBean.setRateGetErrorKbn(C_RateGetErrorKbn.TARGETERROR);

            logger.debug("△ Ｖレート取得 終了");
            return bzGetVrateBean;
        }

        bM_RateV = BM_RateVDetacher.detachRateVtouched(bM_RateV);

        HashMap<Integer, BizNumber> vrateAll = getVrateMap(bM_RateV);

        HashMap<Integer, BizNumber> vrate = new HashMap<>();

        if (C_VRateGetKbn.ALL.eq(pVRateGetKbn)) {
            vrate.putAll(vrateAll);
        }
        else if (C_VRateGetKbn.ONEYEAR.eq(pVRateGetKbn)) {

            vrate.put(0, vrateAll.get(pKeikanensuu));
        }
        else if (C_VRateGetKbn.TWOYEARS.eq(pVRateGetKbn)) {

            vrate.put(0, vrateAll.get(pKeikanensuu));

            vrate.put(1, vrateAll.get(pKeikanensuu + 1));
        }

        bzGetVrateBean.setVrate(vrate);

        bzGetVrateBean.setErrorKbn(C_ErrorKbn.OK);

        logger.debug("△ Ｖレート取得 終了");

        return bzGetVrateBean;
    }

    private C_ErrorKbn chkKeikaNensu(
        C_HknkknsmnKbn pHknkknsmnKbn,
        int pKeikanensuu,
        int pHknkkn,
        C_VRateGetKbn pVRateGetKbn) {

        if (pKeikanensuu < KEIKANENSUU_MIN  || KEIKANENSUU_MAX < pKeikanensuu) {
            return C_ErrorKbn.ERROR;
        }

        if (C_HknkknsmnKbn.NENMANKI.eq(pHknkknsmnKbn) && pHknkkn < pKeikanensuu) {
            return C_ErrorKbn.ERROR;
        }

        if (C_VRateGetKbn.TWOYEARS.eq(pVRateGetKbn) && pKeikanensuu == KEIKANENSUU_MAX) {
            return C_ErrorKbn.ERROR;
        }

        return C_ErrorKbn.OK;
    }

    private HashMap<Integer, BizNumber> getVrateMap(BM_RateV pBM_RateV) {

        HashMap<Integer, BizNumber> vrate = new HashMap<>();

        int i = 0;
        vrate.put(i++, getVrate(pBM_RateV.getVrate00()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate01()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate02()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate03()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate04()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate05()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate06()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate07()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate08()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate09()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate10()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate11()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate12()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate13()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate14()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate15()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate16()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate17()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate18()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate19()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate20()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate21()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate22()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate23()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate24()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate25()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate26()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate27()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate28()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate29()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate30()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate31()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate32()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate33()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate34()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate35()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate36()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate37()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate38()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate39()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate40()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate41()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate42()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate43()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate44()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate45()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate46()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate47()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate48()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate49()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate50()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate51()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate52()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate53()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate54()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate55()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate56()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate57()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate58()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate59()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate60()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate61()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate62()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate63()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate64()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate65()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate66()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate67()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate68()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate69()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate70()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate71()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate72()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate73()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate74()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate75()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate76()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate77()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate78()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate79()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate80()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate81()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate82()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate83()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate84()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate85()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate86()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate87()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate88()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate89()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate90()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate91()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate92()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate93()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate94()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate95()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate96()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate97()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate98()));
        vrate.put(i++, getVrate(pBM_RateV.getVrate99()));

        return vrate;
    }

    private BizNumber getVrate(BizNumber vrate) {
        return vrate == null ? BizNumber.ZERO : vrate;
    }

}