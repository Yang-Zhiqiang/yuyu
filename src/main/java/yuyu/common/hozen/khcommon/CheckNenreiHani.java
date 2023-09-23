package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;

/**
 * 契約保全 契約保全共通 取扱年齢範囲チェック
 */
public class CheckNenreiHani {

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomManager;

    private final List<String> warningMsgIdLst = new ArrayList<>();
    private final List<String> warningMsgLst = new ArrayList<>();

    public CheckNenreiHani() {
        super();
    }

    public boolean exec(String pSyouhnCd, int pSyouhnsdNo, C_KataKbn pKataKbn, int pHknKkn,
        C_HknkknsmnKbn pHknkknSmnKbn, int pHrkKkn, C_HrkkknsmnKbn pHrkkknSmnKbn, BizNumber pYoteiRiritu,
        int pDai1hknkkn, BM_SyouhnZokusei pSyouhnZokusei, C_Hhknsei pHanteiyouHhknsei, int pHanteiyouHhknnen,
        C_Channelcd pChannelCd) {

        logger.debug("▽ 取扱年齢範囲チェック 開始");

        long jihousyoKensuu = bizDomManager.getChkJhNenreiHani2CountByPkHhknsei(pChannelCd, pSyouhnCd,
            pSyouhnsdNo, Integer.valueOf(pHanteiyouHhknsei.getValue()), pKataKbn, pHknKkn, pHknkknSmnKbn, pHrkKkn,
            pHrkkknSmnKbn, BizNumber.valueOf(pHanteiyouHhknnen), pYoteiRiritu, pDai1hknkkn);

        if(jihousyoKensuu == 0){
            throw new BizLogicException(MessageId.EIC0011, pSyouhnZokusei.getSyouhnnm());
        }

        int hantei = SyouhinUtil.hantei(pSyouhnCd);

        if (hantei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

            jihousyoKensuu = bizDomManager.getChkJhNenreiHani2CountByPkHhknsei(pChannelCd, pSyouhnCd,
                pSyouhnsdNo, Integer.valueOf(pHanteiyouHhknsei.getValue()), pKataKbn, pHknKkn, pHknkknSmnKbn, pHknKkn
                - pHanteiyouHhknnen, C_HrkkknsmnKbn.NENMANKI, BizNumber.valueOf(pHanteiyouHhknnen), pYoteiRiritu, pDai1hknkkn);

            if (jihousyoKensuu == 0) {
                throw new BizLogicException(MessageId.EIC0011, pSyouhnZokusei.getSyouhnnm());
            }
        }

        long kensuu = bizDomManager.getChkNenreiHani2CountByPkHhknsei(pChannelCd, pSyouhnCd, pSyouhnsdNo,
            Integer.valueOf(pHanteiyouHhknsei.getValue()), pKataKbn, pHknKkn, pHknkknSmnKbn, pHrkKkn, pHrkkknSmnKbn,
            BizNumber.valueOf(pHanteiyouHhknnen), pYoteiRiritu, pDai1hknkkn);

        if(kensuu == 0){

            warningMsgIdLst.add(MessageId.WIC1001);

            warningMsgLst.add(MessageUtil.getMessage(MessageId.WIC1001, pSyouhnZokusei.getSyouhnnm()));
        }

        boolean warningFlg;

        if (warningMsgIdLst.size() > 0) {
            warningFlg = false;
        }
        else {
            warningFlg = true;
        }

        logger.debug("△ 取扱年齢範囲チェック 終了");

        return warningFlg;
    }

    public List<String> getWarningMsgIdList() {
        return warningMsgIdLst;
    }

    public List<String> getWarningMsgList() {
        return warningMsgLst;
    }
}
