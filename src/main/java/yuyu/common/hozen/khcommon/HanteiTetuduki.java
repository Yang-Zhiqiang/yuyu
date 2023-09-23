package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_KykdrDouiYouhiKbn;
import yuyu.def.classification.C_KykdrknHtdjytKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.db.entity.IM_KhTtdkTyuuikahi;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 契約保全共通 手続注意判定
 */
public class HanteiTetuduki {

    private String messageID;
    private String messageParam;
    @Inject
    private static Logger logger;
    @Inject
    private HozenDomManager hozenDomManager;
    private final String KONMA = ", ";
    private static final String KAIGYOUCD = "<BR>";

    public HanteiTetuduki() {
        super();
    }

    public C_SyorikahiKbn exec(KhozenCommonParam khozenCommonParam, String syono) {

        logger.debug("▽ 手続注意判定 開始");

        messageID = "";
        messageParam = "";
        C_SyorikahiKbn syorikahiKbn = C_SyorikahiKbn.SYORIKANOU;

        IT_KhTtdkTyuui khTtdkTyuui = hozenDomManager.getKykKihon(syono).getKhTtdkTyuui();

        if (khTtdkTyuui != null) {
            List<String> syorihukaList = new ArrayList<>();
            List<String> tyuuitratkiKbnkList = new ArrayList<>();
            C_TtdktyuuiKbn kykDairiTtdktyuuiKbn = C_TtdktyuuiKbn.BLNK;

            if (C_KykdrknHtdjytKbn.SETTEI.eq(khTtdkTyuui.getKykdrknhatudoujyoutai())) {
                kykDairiTtdktyuuiKbn = C_TtdktyuuiKbn.KYKSYADAIRIKENHATUDOUZUMI;
            }
            else if (C_KykdrDouiYouhiKbn.YOU.eq(khTtdkTyuui.getKykdrdouiyouhi())) {
                kykDairiTtdktyuuiKbn = C_TtdktyuuiKbn.KYKSYADAIRININDOUIYOU;
            }

            if (!C_TtdktyuuiKbn.BLNK.eq(kykDairiTtdktyuuiKbn)) {
                IM_KhTtdkTyuuikahi khTtdkTyuuikahi = hozenDomManager.getKhTtdkTyuuikahi(
                    khozenCommonParam.getFunctionId(), kykDairiTtdktyuuiKbn);

                if (khTtdkTyuuikahi != null) {
                    if (C_SyorikahiKbn.SYORIHUKA.eq(khTtdkTyuuikahi.getSyorikahikbn())) {
                        syorihukaList.add(kykDairiTtdktyuuiKbn.getContent());
                    }
                    else if (C_SyorikahiKbn.TYUUITRATKIKA.eq(khTtdkTyuuikahi.getSyorikahikbn())) {
                        syorikahiKbn = C_SyorikahiKbn.TYUUITRATKIKA;
                    }
                    else if(C_SyorikahiKbn.SYORIKANOU.eq(khTtdkTyuuikahi.getSyorikahikbn())){
                        kykDairiTtdktyuuiKbn = C_TtdktyuuiKbn.BLNK;
                    }
                }
                else{
                    kykDairiTtdktyuuiKbn = C_TtdktyuuiKbn.BLNK;
                }
            }

            if (!C_TtdktyuuiKbn.BLNK.eq(khTtdkTyuui.getTtdktyuuikbn1())) {
                IM_KhTtdkTyuuikahi khTtdkTyuuikahi = hozenDomManager.getKhTtdkTyuuikahi(
                    khozenCommonParam.getFunctionId(),
                    khTtdkTyuui.getTtdktyuuikbn1());
                if (khTtdkTyuuikahi != null) {
                    if (C_SyorikahiKbn.SYORIHUKA.eq(khTtdkTyuuikahi.getSyorikahikbn())) {
                        syorihukaList.add(C_TtdktyuuiKbn.getContentByValue(khTtdkTyuui.getTtdktyuuikbn1().getValue()));
                    }
                    else if (C_SyorikahiKbn.TYUUITRATKIKA.eq(khTtdkTyuuikahi.getSyorikahikbn())) {
                        tyuuitratkiKbnkList.add(C_TtdktyuuiKbn.getContentByValue(khTtdkTyuui.getTtdktyuuikbn1()
                            .getValue()));
                    }
                }
            }

            if (!C_TtdktyuuiKbn.BLNK.eq(khTtdkTyuui.getTtdktyuuikbn2())) {
                IM_KhTtdkTyuuikahi khTtdkTyuuikahi = hozenDomManager.getKhTtdkTyuuikahi(
                    khozenCommonParam.getFunctionId(),
                    khTtdkTyuui.getTtdktyuuikbn2());
                if (khTtdkTyuuikahi != null) {
                    if (C_SyorikahiKbn.SYORIHUKA.eq(khTtdkTyuuikahi.getSyorikahikbn())) {
                        syorihukaList.add(C_TtdktyuuiKbn.getContentByValue(khTtdkTyuui.getTtdktyuuikbn2().getValue()));
                    }
                    else if (C_SyorikahiKbn.TYUUITRATKIKA.eq(khTtdkTyuuikahi.getSyorikahikbn())) {
                        tyuuitratkiKbnkList.add(C_TtdktyuuiKbn.getContentByValue(khTtdkTyuui.getTtdktyuuikbn2()
                            .getValue()));
                    }
                }
            }

            if ( !C_TtdktyuuiKbn.BLNK.eq(khTtdkTyuui.getTtdktyuuikbn3())) {
                IM_KhTtdkTyuuikahi khTtdkTyuuikahi = hozenDomManager.getKhTtdkTyuuikahi(
                    khozenCommonParam.getFunctionId(),
                    khTtdkTyuui.getTtdktyuuikbn3());
                if (khTtdkTyuuikahi != null) {
                    if (C_SyorikahiKbn.SYORIHUKA.eq(khTtdkTyuuikahi.getSyorikahikbn())) {
                        syorihukaList.add(C_TtdktyuuiKbn.getContentByValue(khTtdkTyuui.getTtdktyuuikbn3().getValue()));
                    }
                    else if (C_SyorikahiKbn.TYUUITRATKIKA.eq(khTtdkTyuuikahi.getSyorikahikbn())) {
                        tyuuitratkiKbnkList.add(C_TtdktyuuiKbn.getContentByValue(khTtdkTyuui.getTtdktyuuikbn3()
                            .getValue()));
                    }
                }
            }

            if (!C_TtdktyuuiKbn.BLNK.eq(khTtdkTyuui.getTtdktyuuikbn4())) {
                IM_KhTtdkTyuuikahi khTtdkTyuuikahi = hozenDomManager.getKhTtdkTyuuikahi(
                    khozenCommonParam.getFunctionId(),
                    khTtdkTyuui.getTtdktyuuikbn4());
                if (khTtdkTyuuikahi != null) {
                    if (C_SyorikahiKbn.SYORIHUKA.eq(khTtdkTyuuikahi.getSyorikahikbn())) {
                        syorihukaList.add(C_TtdktyuuiKbn.getContentByValue(khTtdkTyuui.getTtdktyuuikbn4().getValue()));
                    }
                    else if (C_SyorikahiKbn.TYUUITRATKIKA.eq(khTtdkTyuuikahi.getSyorikahikbn())) {
                        tyuuitratkiKbnkList.add(C_TtdktyuuiKbn.getContentByValue(khTtdkTyuui.getTtdktyuuikbn4()
                            .getValue()));
                    }
                }
            }

            if (!C_TtdktyuuiKbn.BLNK.eq(khTtdkTyuui.getTtdktyuuikbn5())) {
                IM_KhTtdkTyuuikahi khTtdkTyuuikahi = hozenDomManager.getKhTtdkTyuuikahi(
                    khozenCommonParam.getFunctionId(),
                    khTtdkTyuui.getTtdktyuuikbn5());
                if (khTtdkTyuuikahi != null) {
                    if (C_SyorikahiKbn.SYORIHUKA.eq(khTtdkTyuuikahi.getSyorikahikbn())) {
                        syorihukaList.add(C_TtdktyuuiKbn.getContentByValue(khTtdkTyuui.getTtdktyuuikbn5().getValue()));
                    }
                    else if (C_SyorikahiKbn.TYUUITRATKIKA.eq(khTtdkTyuuikahi.getSyorikahikbn())) {
                        tyuuitratkiKbnkList.add(C_TtdktyuuiKbn.getContentByValue(khTtdkTyuui.getTtdktyuuikbn5()
                            .getValue()));
                    }
                }
            }

            if (syorihukaList.size() != 0) {
                String messageSyorihukaParam = null;
                for (int i = 0; i <= syorihukaList.size() - 1; i++) {
                    if (i == 0) {
                        messageSyorihukaParam = syorihukaList.get(i);
                    }
                    else {
                        messageSyorihukaParam = messageSyorihukaParam + KONMA + syorihukaList.get(i);
                    }
                }

                syorikahiKbn = C_SyorikahiKbn.SYORIHUKA;
                messageID = MessageId.EIA1006;
                messageParam = messageSyorihukaParam;
            }
            else {
                if (tyuuitratkiKbnkList.size() != 0) {
                    syorikahiKbn = C_SyorikahiKbn.TYUUITRATKIKA;
                }
            }

            if (C_SyorikahiKbn.TYUUITRATKIKA.eq(syorikahiKbn)) {
                messageID = MessageId.WIA1001;
                messageParam = editTyuuitratkikaMsg(kykDairiTtdktyuuiKbn, tyuuitratkiKbnkList);
            }
        }

        logger.debug("△ 手続注意判定 終了");

        return syorikahiKbn;
    }

    public String getMessageID() {
        return messageID;
    }

    public String getMessageParam() {
        return messageParam;
    }

    private String editTyuuitratkikaMsg(C_TtdktyuuiKbn pKykDairiTtdktyuuiKbn, List<String> pTyuuitratkiKbnkList) {

        String ttdktyuuiMsg = "";

        if (pTyuuitratkiKbnkList.size() != 0) {

            String messageTyuuitratkikaParam = "";

            for (int n = 0; n < pTyuuitratkiKbnkList.size(); n++) {
                if (n == 0) {
                    messageTyuuitratkikaParam = pTyuuitratkiKbnkList.get(n);
                }
                else {
                    messageTyuuitratkikaParam = messageTyuuitratkikaParam + KONMA + pTyuuitratkiKbnkList.get(n);
                }
            }

            ttdktyuuiMsg = MessageUtil.getMessage(MessageId.WIA1021, messageTyuuitratkikaParam);
        }

        if (C_TtdktyuuiKbn.KYKSYADAIRIKENHATUDOUZUMI.eq(pKykDairiTtdktyuuiKbn)) {

            ttdktyuuiMsg = editTetudukiMsg(MessageId.WIA1022, ttdktyuuiMsg);
        }
        else if (C_TtdktyuuiKbn.KYKSYADAIRININDOUIYOU.eq(pKykDairiTtdktyuuiKbn)) {

            ttdktyuuiMsg = editTetudukiMsg(MessageId.WIA1023, ttdktyuuiMsg);
        }

        return ttdktyuuiMsg;
    }

    private String editTetudukiMsg(String msgId, String pTtdktyuuiMsg) {

        String newTtdktyuuiMsg = "";

        String msgInfo = MessageUtil.getMessage(msgId);

        if (!BizUtil.isBlank(pTtdktyuuiMsg)) {
            newTtdktyuuiMsg = pTtdktyuuiMsg + KAIGYOUCD + msgInfo;
        }
        else {
            newTtdktyuuiMsg = msgInfo;
        }

        return newTtdktyuuiMsg;
    }
}
