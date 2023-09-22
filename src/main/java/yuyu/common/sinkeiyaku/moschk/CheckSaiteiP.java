package yuyu.common.sinkeiyaku.moschk;

import java.math.RoundingMode;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.sinkeiyaku.skcommon.ConvNenSaiManki;
import yuyu.common.sinkeiyaku.skcommon.EditHeijyunbaraiP;
import yuyu.common.sinkeiyaku.skcommon.HubiMsgEdit;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_SaiteiptknKbn;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_Tksytratkikjn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_ChkJhSaiteiP;
import yuyu.def.db.entity.BM_ChkSaiteiP;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Tokunin;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;

/**
 * 新契約 申込内容チェック 最低Pチェック
 */
public class CheckSaiteiP {

    private BizCurrency pTani = null;

    private boolean chkhubigaitouflg = false;

    @Inject
    private static Logger log;

    @Inject
    private SetHubiMsg setHubiMsg;

    @Inject
    private BizDomManager bizDomManager;

    public CheckSaiteiP() {
        super();
    }

    public void exec(MosnaiCheckParam pMp, HT_MosSyouhn pMosSyouhn, BM_SyouhnZokusei pSyouhnZokusei, BizCurrency pHntiP, C_Tuukasyu pTuukasyu) {

        if (log.isDebugEnabled()) {
            log.debug("▽ 最低Pチェック 開始");
        }

        HT_SyoriCTL syoriCTL = pMp.getDataSyoriControl();

        C_SysKbn sysKbn = pMp.getSysKbn();

        chkhubigaitouflg = false;

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        BizCurrency saiteiP = getSaiteiP(pMp, syoriCTL, mosKihon, pMosSyouhn, pSyouhnZokusei);

        C_SaiteiptknKbn saiteiPTknKbn = C_SaiteiptknKbn.NONE;

        HT_Tokunin tokunin = syoriCTL.getTokunin();

        if (tokunin != null) {
            saiteiPTknKbn = tokunin.getSaiteiptknkbn();
        }

        if (pHntiP.compareTo(saiteiP) < 0) {

            String msg = null;

            C_TknKbn tknKbn = C_TknKbn.NONE;

            if (C_SysKbn.ESHIEN.eq(sysKbn)) {

                String msgChange = "";
                HubiMsgEdit hubiMsgEdit = SWAKInjector.getInstance(HubiMsgEdit.class);

                msgChange = hubiMsgEdit.editSeihoWebMsg_Hokenryou(pMp, mosKihon, pSyouhnZokusei);

                setHubiMsg.exec("", MessageUtil.getMessage(MessageId.EGA1021, msgChange,
                    setHubiMsg.editHubiMsgKingakuPKans(saiteiP, pTani, pTuukasyu, false, pMp, mosKihon, pSyouhnZokusei)),
                    C_SekmossakuseiErroutKbn.GAMEN, pMp);
            }
            else {
                if(C_SaiteiptknKbn.NONE.eq(saiteiPTknKbn)){
                    tknKbn = C_TknKbn.KANOU;
                }
                else {
                    tknKbn = C_TknKbn.NONE;
                }

                msg = MessageId.EHC1046
                    + " "
                    + MessageUtil.getMessage(MessageId.EHC1046,
                        ViewReport.editCommaTuukaNoSpace(saiteiP,
                            BizUtil.ZERO_FILL));
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, msg, pMp, tknKbn, C_MsgKbn.ERROR);

                pMp.setSaiteiPChkErrUmu(C_UmuKbn.ARI);
            }

            chkhubigaitouflg = true;
        }

        if (log.isDebugEnabled()) {
            log.debug("△ 最低Pチェック 終了");
        }
    }

    public BizCurrency getSaiteiP(MosnaiCheckParam pMp, HT_SyoriCTL pSyoriCTL, HT_MosKihon pMosKihon,
        HT_MosSyouhn pMosSyouhn, BM_SyouhnZokusei pSyouhnZokusei) {

        C_SaiteiptknKbn saiteiPTknKbn = C_SaiteiptknKbn.NONE;

        HT_Tokunin tokunin = pSyoriCTL.getTokunin();

        if (tokunin != null) {
            saiteiPTknKbn = tokunin.getSaiteiptknkbn();
        }

        C_SysKbn sysKbn = pMp.getSysKbn();
        C_Tksytratkikjn tksyTratkiKjn = pMp.getTksyTratkiKjn();
        C_Channelcd kiteiCheckChannelCd = pMp.getKiteiCheckChannelCd();
        String syouhnCd = pMosSyouhn.getSyouhncd();
        Integer syohinSedaiNo = pMosSyouhn.getSyouhnsdno();
        C_Hrkkaisuu hrkKaisuu = pMosKihon.getHrkkaisuu();
        C_Tuukasyu hrkTuukasyu = pMosKihon.getHrktuukasyu();
        String mosNo = pMosKihon.getMosno();
        Integer hrkkkn = pMosSyouhn.getHrkkkn();
        C_HrkkknsmnKbn hrkkknsmnkbn = pMosSyouhn.getHrkkknsmnkbn();
        Integer hhknnen = pMosKihon.getHhknnen();
        SyouhinUtil syouhinUtil = SWAKInjector.getInstance(SyouhinUtil.class);
        EditHeijyunbaraiP editHeijyunbaraiP = SWAKInjector.getInstance(EditHeijyunbaraiP.class);
        CheckTuusan checkTuusan = SWAKInjector.getInstance(CheckTuusan.class);
        ConvNenSaiManki convNenSaiManki = SWAKInjector.getInstance(ConvNenSaiManki.class);
        Integer  hrkkknNen = Integer.valueOf(0);

        if(C_Channelcd.SMBC.eq(kiteiCheckChannelCd)){

            int syouhnTeibn = SyouhinUtil.hantei(syouhnCd);

            if(SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 == syouhnTeibn){

                String oyadrtencd = "";

                if(C_SysKbn.ESHIEN.eq(sysKbn)) {

                    oyadrtencd = pMp.getSekmossakuseiOyaAgCd();
                }
                else{
                    HT_MosDairiten mosDairiten = pSyoriCTL.getMosDairitenByRenno(1);

                    if(mosDairiten != null){

                        oyadrtencd = mosDairiten.getOyadrtencd();
                    }
                    else{
                        oyadrtencd = "";
                    }
                }
                if(YuyuSinkeiyakuConfig.getInstance().getSmbcsintakubank().equals(oyadrtencd) ||
                    YuyuSinkeiyakuConfig.getInstance().getSmbcnikkousyouken().equals(oyadrtencd)){

                    kiteiCheckChannelCd = C_Channelcd.TIGIN;
                }
            }
        }

        C_ErrorKbn convHrkkknNenResult = convNenSaiManki.convHrkkknNen(hrkkkn, hrkkknsmnkbn, hhknnen);

        if (C_ErrorKbn.OK.eq(convHrkkknNenResult)) {
            hrkkknNen = convNenSaiManki.getHrkkknNen();
        }

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(hrkTuukasyu);
        BizCurrency saiteiP = BizCurrency.valueOf(0, currencyType);

        if ((C_SysKbn.ESHIEN.eq(sysKbn) && (!C_Tksytratkikjn.SAITEIP_KJNKANWA.eq(tksyTratkiKjn))) ||
            (C_SysKbn.SKEI.eq(sysKbn) && C_SaiteiptknKbn.NONE.eq(saiteiPTknKbn))) {

            String[] syoHinBetuKey1s = syouhinUtil.getSyouhinKeyToSaiteiPChk(syouhnCd);

            for (int i = 0 ; i < syoHinBetuKey1s.length; i++) {

                List<BM_ChkSaiteiP> chkSaiteiPLst = bizDomManager.getChkSaiteiPsByPk(
                    syouhnCd,
                    kiteiCheckChannelCd,
                    hrkKaisuu,
                    hrkkknNen,
                    syohinSedaiNo,
                    hrkTuukasyu,
                    syoHinBetuKey1s[i]);

                if (chkSaiteiPLst == null || chkSaiteiPLst.size() == 0) {
                    throw new CommonBizAppException("申込番号 = "+ mosNo);
                }

                BizCurrency kariSaiteiP = BizCurrency.valueOf(0, currencyType);

                if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ENKAPHARAIKOMISOUGAKU.equals(
                    syoHinBetuKey1s[i])) {
                    C_ErrorKbn errorKbn = editHeijyunbaraiP.editSouharaiPToHeijyunbaraiP(
                        chkSaiteiPLst.get(0).getSaiteip(),
                        hrkKaisuu,
                        hrkkkn,
                        hrkkknsmnkbn,
                        hhknnen,
                        C_HasuusyoriKbn.AGE);

                    if (C_ErrorKbn.OK.eq(errorKbn)){
                        kariSaiteiP = editHeijyunbaraiP.getHeijyunbaraiP();
                    }
                }
                else{
                    kariSaiteiP = chkSaiteiPLst.get(0).getSaiteip();
                }

                if (saiteiP.compareTo(kariSaiteiP) < 0) {
                    saiteiP = kariSaiteiP;
                }
            }

        }

        if ((C_SysKbn.ESHIEN.eq(sysKbn) && C_Tksytratkikjn.SAITEIP_KJNKANWA.eq(tksyTratkiKjn)) ||
            (C_SysKbn.SKEI.eq(sysKbn) && C_SaiteiptknKbn.ARI.eq(saiteiPTknKbn))) {

            String[] syoHinBetuKey1s = syouhinUtil.getSyouhinKeyToSaiteiPJhChk(syouhnCd);

            for (int i = 0 ; i < syoHinBetuKey1s.length; i++){

                List<BM_ChkJhSaiteiP> chkJhSaiteiPLst = bizDomManager.getChkJhSaiteiPsByPk(
                    syouhnCd,
                    kiteiCheckChannelCd,
                    hrkKaisuu,
                    hrkkknNen,
                    syohinSedaiNo,
                    hrkTuukasyu,
                    syoHinBetuKey1s[i]);

                if (chkJhSaiteiPLst == null || chkJhSaiteiPLst.size() == 0) {
                    throw new CommonBizAppException("申込番号 = " + mosNo);
                }

                BizCurrency kariSaiteiP = BizCurrency.valueOf(0, currencyType);

                if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ENKAPHARAIKOMISOUGAKU.equals(
                    syoHinBetuKey1s[i])) {
                    C_ErrorKbn errorKbn = editHeijyunbaraiP.editSouharaiPToHeijyunbaraiP(
                        chkJhSaiteiPLst.get(0).getSaiteip(),
                        hrkKaisuu,
                        hrkkkn,
                        hrkkknsmnkbn,
                        hhknnen,
                        C_HasuusyoriKbn.AGE);

                    if (C_ErrorKbn.OK.eq(errorKbn)) {
                        kariSaiteiP = editHeijyunbaraiP.getHeijyunbaraiP();
                    }
                }
                else{
                    kariSaiteiP = chkJhSaiteiPLst.get(0).getSaiteip();
                }

                if (saiteiP.compareTo(kariSaiteiP) < 0) {
                    saiteiP = kariSaiteiP;
                }
            }

        }
        C_Channelcd channelCd = pMp.getKiteiCheckChannelCd();

        pTani = checkTuusan.getPTani(pSyoriCTL, pMosKihon, pMosSyouhn,channelCd, pSyouhnZokusei.getPtratkituukasiteikbn());

        saiteiP = pTani.multiply(saiteiP.divideBizCurrency(pTani, 0 ,RoundingMode.UP));

        return saiteiP;

    }


    public boolean getChkhubigaitouflg() {
        return chkhubigaitouflg;
    }
}