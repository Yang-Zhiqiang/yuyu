package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.sinkeiyaku.skcommon.ConvNenSaiManki;
import yuyu.common.sinkeiyaku.skcommon.EditNenkinKoumokuUtil;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;

/**
 * 契約保全 契約保全共通 税制適格特約付加条件チェック
 */
public class CheckZeiseiTkkkTkykHukaJyouken {

    public static final int NENKINUKETORININ_HONNIN_HUBIERROR = 1;

    public static final int NENKINUKETORININ_DAISANSYA_HUBIERROR = 2;

    public static final int HOKENHARAIKOMIKIKAN_HUBIERROR  = 3;

    public static final int NENKINSIHARAIKIKAN_HUBIERROR = 4;

    public static final int NENKINKAISINENREI_HUBIERROR = 5;

    private boolean htZeiseiTkkkTkykHukaJk = true;

    private List<Integer> errorCodeList;

    @Inject
    private static Logger logger;

    public CheckZeiseiTkkkTkykHukaJyouken() {
        super();
    }

    public boolean getHtZeiseiTkkkTkykHukaJk() {
        return htZeiseiTkkkTkykHukaJk;
    }

    public List<Integer> getErrorCodeList() {
        return errorCodeList;
    }

    public C_ErrorKbn checkZeiseiTkkkTkykHukaJk(C_Tdk pKykTdk, C_UktKbn pNenkinuktKbn, int pHhknNen, C_HrkkknsmnKbn pHrkkknSmnKbn,
        int pHrkkkn, C_HknkknsmnKbn pHknkknSmnkbn, int pHknkkn, C_Nenkinsyu pNksyuKbn, int pNenkinKkn) {

        logger.debug("▽ 税制適格特約付加条件チェック 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.ERROR;
        ConvNenSaiManki convNenSaiManki = SWAKInjector.getInstance(ConvNenSaiManki.class);
        int hrkkknNen = 0;
        htZeiseiTkkkTkykHukaJk = true;

        errorCodeList = new ArrayList<>();

        errorKbn = convNenSaiManki.convHrkkknNen(pHrkkkn, pHrkkknSmnKbn, pHhknNen);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            logger.debug("△ 税制適格特約付加条件チェック 終了");

            return errorKbn;
        }
        hrkkknNen = convNenSaiManki.getHrkkknNen();

        EditNenkinKoumokuUtil editNenkinKoumokuUtil = SWAKInjector.getInstance(EditNenkinKoumokuUtil.class);
        int nenkinSiharaiKaisiNenrei = 0;

        errorKbn = editNenkinKoumokuUtil.editNenkinSiharaiKaisiNenrei(pHknkkn, pHknkknSmnkbn, pHhknNen);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            logger.debug("△ 税制適格特約付加条件チェック 終了");

            return errorKbn;
        }
        nenkinSiharaiKaisiNenrei = editNenkinKoumokuUtil.getNenkinSiharaiKaisiNenrei();

        if ((C_Tdk.HONNIN.eq(pKykTdk) && (C_UktKbn.KYK.eq(pNenkinuktKbn) || C_UktKbn.HHKN.eq(pNenkinuktKbn))) ||
            (C_Tdk.HGU.eq(pKykTdk) && C_UktKbn.HHKN.eq(pNenkinuktKbn))) {
        }else {
            htZeiseiTkkkTkykHukaJk = false;
            if(C_Tdk.HONNIN.eq(pKykTdk)){
                errorCodeList.add(NENKINUKETORININ_HONNIN_HUBIERROR );
            }else{
                errorCodeList.add(NENKINUKETORININ_DAISANSYA_HUBIERROR);
            }
        }
        if (hrkkknNen >= 10) {
        }else{

            htZeiseiTkkkTkykHukaJk = false;

            errorCodeList.add(HOKENHARAIKOMIKIKAN_HUBIERROR);
        }

        if (C_Nenkinsyu.SGKHSYSYSNNENKIN.eq(pNksyuKbn) || (!C_Nenkinsyu.SGKHSYSYSNNENKIN.eq(pNksyuKbn) &&
            nenkinSiharaiKaisiNenrei >= 60 && pNenkinKkn >= 10)) {

        }else{
            htZeiseiTkkkTkykHukaJk = false;

            if(pNenkinKkn < 10){
                errorCodeList.add(NENKINSIHARAIKIKAN_HUBIERROR );
            }
            if(nenkinSiharaiKaisiNenrei < 60){
                errorCodeList.add(NENKINKAISINENREI_HUBIERROR);
            }
        }

        logger.debug("△ 税制適格特約付加条件チェック 終了");

        errorKbn = C_ErrorKbn.OK;

        return errorKbn;
    }

    public C_ErrorKbn checkZeiseiTkkkTkykHukaJkBySyono(KhozenCommonParam pKhozenCommonParam, String pSyono) {

        logger.debug("▽ 税制適格特約付加条件チェック（証券番号指定） 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.ERROR;
        htZeiseiTkkkTkykHukaJk = false;

        IT_KykSya kykSya = pKhozenCommonParam.getKeiyakusya(pSyono);

        IT_KykUkt kykUkt = pKhozenCommonParam.getNenkinUketorinin(pSyono);

        List<IT_KykSyouhn> kykSyouhnList = pKhozenCommonParam.getKeiyakuSyouhin(pSyono, C_SyutkKbn.SYU);

        if (kykUkt == null || kykSyouhnList == null) {

            logger.debug("△ 税制適格特約付加条件チェック（証券番号指定） 終了");

            return errorKbn;
        }

        IT_KykSyouhn kykSyouhn = kykSyouhnList.get(0);

        errorKbn = checkZeiseiTkkkTkykHukaJk(
            kykSya.getKkkyktdk(),
            kykUkt.getUktkbn(),
            kykSyouhn.getHhknnen(),
            kykSyouhn.getHrkkknsmnkbn(),
            kykSyouhn.getHrkkkn(),
            kykSyouhn.getHknkknsmnkbn(),
            kykSyouhn.getHknkkn(),
            kykSyouhn.getNksyukbn(),
            kykSyouhn.getNenkinkkn());

        logger.debug("△ 税制適格特約付加条件チェック（証券番号指定） 終了");

        return errorKbn;
    }
}
