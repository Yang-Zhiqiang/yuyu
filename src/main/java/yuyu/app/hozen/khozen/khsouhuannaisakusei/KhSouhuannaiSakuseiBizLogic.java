package yuyu.app.hozen.khozen.khsouhuannaisakusei;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.hozen.khcommon.EditSouhuannaiParam;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.KhMessageGroupConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KhozenTyouhyouCtl;
import yuyu.def.MessageId;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.report.OutputReport;

/**
 * 送付案内作成 のビジネスロジックです。
 */
public class KhSouhuannaiSakuseiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhSouhuannaiSakuseiUiBean uiBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private MessageManager messageManager;

    @Inject
    private EditSouhuannaiParam editSouhuannaiParam;

    @Inject
    private KhozenTyouhyouCtl khozenTyouhyouCtl;

    @Inject
    private OutputReport outputReport;

    @Inject
    private HanteiTetuduki hanteiTetuduki;

    void init() {
    }

    void clear() {
    }

    void pushNyuryoku() {

        BizPropertyInitializer.initialize(uiBean);

        String syono = uiBean.getSyono();

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);

        if(kykKihon == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }

        C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(khozenCommonParam,syono);

        if(C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)){
            throw new BizLogicException(MessageId.EIA1006,hanteiTetuduki.getMessageParam());
        }
        else if(C_SyorikahiKbn.TYUUITRATKIKA.eq(syorikahiKbn)){
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                hanteiTetuduki.getMessageID(),
                hanteiTetuduki.getMessageParam());
        }

        IT_KykSya kykSya =  khozenCommonParam.getKeiyakusya(syono);

        uiBean.setShsnmkj(kykSya.getKyknmkj());
        uiBean .setShskyno(kykSya.getTsinyno());
        uiBean .setShsadr1kj(kykSya.getTsinadr1kj());
        uiBean .setShsadr2kj(kykSya.getTsinadr2kj());
        uiBean .setShsadr3kj(kykSya.getTsinadr3kj());
    }

    void pushConfirmBL() {
        messageManager.addMessageId(MessageId.QBA0001);
    }

    @Transactional
    void pushKakuteiBL() {

        editSouhuannaiParam.setShsnmkj(uiBean.getShsnmkj());
        editSouhuannaiParam.setShsyno(uiBean.getShskyno());
        editSouhuannaiParam.setShsadr1kj(uiBean.getShsadr1kj());
        editSouhuannaiParam.setShsadr2kj(uiBean.getShsadr2kj());
        editSouhuannaiParam.setShsadr3kj(uiBean.getShsadr3kj());
        editSouhuannaiParam.setHyshantyouhyounm(uiBean.getHanyoushannaityouhyounm());
        editSouhuannaiParam.setHyshaninjinaiyou(uiBean.getHanyoushannaiinjinaiyou());

        khozenTyouhyouCtl.setEditSouhuannaiParam(editSouhuannaiParam);

        C_SyoruiCdKbn[] syoruiCdKbns = new C_SyoruiCdKbn[1];
        syoruiCdKbns[0] = C_SyoruiCdKbn.KK_SOUHUANNAI;

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, uiBean.getSyono(), syoruiCdKbns, C_YouhiKbn.YOU);

        uiBean.setTyhykbn(khozenTyouhyouCtl.getTyouhyoumuKbn());

        uiBean.setTyhykey(khozenTyouhyouCtl.getTyouhyouKey());

        messageManager.addMessageId(MessageId.IAC0009);
    }

    void printOut(){

        String tyhykey = uiBean.getTyhykey();

        outputReport.outputPDFByJoinKey(tyhykey);
    }
}
