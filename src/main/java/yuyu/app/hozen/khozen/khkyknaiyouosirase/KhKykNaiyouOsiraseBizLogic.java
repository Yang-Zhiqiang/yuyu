package yuyu.app.hozen.khozen.khkyknaiyouosirase;

import static yuyu.app.hozen.khozen.khkyknaiyouosirase.KhKykNaiyouOsiraseConstants.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzHanteiSosikiUtil;
import yuyu.common.hozen.khcommon.KhAddKoumokuSetteiBean;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KykNaiyouOsiraseiSks;
import yuyu.def.MessageId;
import yuyu.infr.report.OutputReport;

/**
 * ご契約内容のお知らせ のビジネスロジックです。
 */
public class KhKykNaiyouOsiraseBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhKykNaiyouOsiraseUiBean uiBean;

    @Inject
    private MessageManager messageManager;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private OutputReport outputReport;

    @Inject
    private KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks;

    void init() {
        BizPropertyInitializer.initialize(uiBean);
    }

    void clear() {
    }

    @Transactional
    void pushReportSksBL() {

        String syono = uiBean.getSyono();

        KhAddKoumokuSetteiBean addKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);

        boolean hanteiKekka =
            BzHanteiSosikiUtil.isCallcenterKeySosikicd(khozenCommonParam.getTmSosikiCd());

        if (hanteiKekka) {
            addKoumokuSetteiBean.setSakuseiSyozoku(khozenCommonParam.getTmSosikiNm());
        }
        else {
            addKoumokuSetteiBean.setSakuseiSyozoku(khozenCommonParam.getTmSosikiNm());

            addKoumokuSetteiBean.setSakuseisya(khozenCommonParam.getUserNm());
        }

        kykNaiyouOsiraseiSks.exec(syono, YOBIDASIMOTOKBN_ONLINE, addKoumokuSetteiBean);

        uiBean.setTyouhyoukey(kykNaiyouOsiraseiSks.getTyouhyouKey());

        messageManager.addMessageId(MessageId.IAC0009);

        if (kykNaiyouOsiraseiSks.getKawaserateMinasiKbn() == KAWASERATE_MINASI) {
            messageManager.addMessageId(MessageId.WIA1003);
        }
    }

    void printOut() {
        outputReport.outputPDFWithDel(uiBean.getTyouhyoukey());
    }

}
