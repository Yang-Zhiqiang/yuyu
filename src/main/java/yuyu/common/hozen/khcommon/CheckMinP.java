package yuyu.common.hozen.khcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import com.google.common.collect.Lists;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.sinkeiyaku.skcommon.ConvNenSaiManki;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.db.entity.BM_ChkJhSaiteiP;
import yuyu.def.db.entity.BM_ChkSaiteiP;
import yuyu.def.db.entity.BM_SyouhnZokusei;

/**
 * 契約保全 契約保全共通 最低Ｐチェック
 */
public class CheckMinP {

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomManager;

    private final List<String> warningMsgIdLst = Lists.newArrayList();

    private final List<String> warningMsgLst = Lists.newArrayList();

    public CheckMinP() {
        super();
    }

    public boolean exec(
        String pSyouhnCd,
        int pSyouhnsdNo,
        int pHrkkkn,
        C_HrkkknsmnKbn pHrkkknsmnKbn,
        BizCurrency pHokenryou,
        BizCurrency pPharaikomisougaku,
        int pHhknnen,
        C_Hrkkaisuu pHrkkaisuu,
        BM_SyouhnZokusei pSyouhnZokusei,
        C_Channelcd pChannelcd) {

        logger.debug("▽ 最低Ｐチェック 開始");

        boolean warningUmuFlg = false;

        if (C_Hrkkaisuu.TUKI.eq(pHrkkaisuu)) {

            ConvNenSaiManki convNenSaiManki = SWAKInjector.getInstance(ConvNenSaiManki.class);

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

            C_ErrorKbn errorKbn = convNenSaiManki.convHrkkknNen(pHrkkkn, pHrkkknsmnKbn, pHhknnen);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                throw new CommonBizAppException("年歳満期変換処理が実行できませんでした。");
            }

            Integer hrkkknNen = convNenSaiManki.getHrkkknNen();

            SyouhinUtil syouhinUtil = SWAKInjector.getInstance(SyouhinUtil.class);

            String[] syoHinBetuKey1s = syouhinUtil.getSyouhinKeyToSaiteiPJhChk(pSyouhnCd);

            for (int n = 0; n < syoHinBetuKey1s.length; n++) {

                List<BM_ChkJhSaiteiP> chkJhSaiteiPList = bizDomManager.getChkJhSaiteiPsByPk(
                    pSyouhnCd, pChannelcd, pHrkkaisuu, hrkkknNen, pSyouhnsdNo,
                    henkanTuuka.henkanTuukaTypeToKbn(pPharaikomisougaku.getType()), syoHinBetuKey1s[n]);

                if (chkJhSaiteiPList.size() == 0) {

                    throw new CommonBizAppException("最低Ｐ事方書チェックマスタにデータが存在しません。");
                }
                if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ENKAPHARAIKOMISOUGAKU
                    .equals(syoHinBetuKey1s[n])) {

                    if (pPharaikomisougaku.compareTo(chkJhSaiteiPList.get(0).getSaiteip()) < 0) {

                        throw new BizLogicException(MessageId.EIC0021, pSyouhnZokusei.getSyouhnnm(),
                            ViewReport.editCommaTuuka(chkJhSaiteiPList.get(0).getSaiteip(), BizUtil.ZERO_FILL));
                    }
                }
            }

            syoHinBetuKey1s = syouhinUtil.getSyouhinKeyToSaiteiPChk(pSyouhnCd);

            for (int n = 0; n < syoHinBetuKey1s.length; n++) {

                if (!BizUtil.isBlank(syoHinBetuKey1s[n])) {

                    List<BM_ChkSaiteiP> chkSaiteiPList = bizDomManager.getChkSaiteiPsByPk(
                        pSyouhnCd, pChannelcd, pHrkkaisuu, hrkkknNen, pSyouhnsdNo,
                        henkanTuuka.henkanTuukaTypeToKbn(pHokenryou.getType()), syoHinBetuKey1s[n]);

                    if (chkSaiteiPList.size() == 0) {

                        throw new CommonBizAppException("最低Ｐチェックマスタにデータが存在しません。");
                    }

                    if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN_GETUBARAIKANSANP
                        .equals(syoHinBetuKey1s[n])) {

                        if (pHokenryou.compareTo(chkSaiteiPList.get(0).getSaiteip()) < 0) {

                            String errMsg = MessageUtil.getMessage(MessageId.WIC0026,"円貨払込額");

                            throw new BizLogicException(MessageId.EBC0001,errMsg);
                        }
                    }
                    else if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ENKAPHARAIKOMISOUGAKU
                        .equals(syoHinBetuKey1s[n])) {

                        if (pPharaikomisougaku.compareTo(chkSaiteiPList.get(0).getSaiteip()) < 0) {

                            String errMsg = MessageUtil.getMessage(MessageId.WIC0026,"円貨払込額の合計額");

                            throw new BizLogicException(MessageId.EBC0001,errMsg);
                        }
                    }
                }
            }
        }

        if (warningMsgIdLst.size() > 0) {

            warningUmuFlg = false;
        }
        else {

            warningUmuFlg = true;
        }

        logger.debug("△ 最低Ｐチェック 終了");

        return warningUmuFlg;
    }

    public List<String> getWarningMsgIdList() {
        return warningMsgIdLst;
    }

    public List<String> getWarningMsgList() {
        return warningMsgLst;
    }
}