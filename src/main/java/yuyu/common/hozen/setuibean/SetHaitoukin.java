package yuyu.common.hozen.setuibean;

import javax.inject.Inject;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.hozen.haitou.DBAccessDCommon;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.def.db.entity.IT_KykKihon;

/**
 * 契約保全 UiBean設定 配当金情報設定
 */
public class SetHaitoukin {

    @Inject
    private DBAccessDCommon dBAccessDCommon;
    public boolean exec(KhozenCommonParam pKhCParm, SetHaitoukinExecUiBeanParam pUiBean) {
        String syoNo = pUiBean.getSyono();

        IT_KykKihon kykKihon = pKhCParm.getKeiyakuKihon(syoNo);

        dBAccessDCommon.getSaisinSeisikiHaitouKanriSyu(syoNo);
        IT_KhHaitouKanri khHaitouKanri = dBAccessDCommon.getKhHaitouKanri();

        dBAccessDCommon.getSaisinTumitateDKanri(syoNo);
        IT_KhTumitateDKanri khTumitateDKanri = dBAccessDCommon.getKhTumitateDKanri();

        pUiBean.setVhthaitoukinuketorihoukbn(kykKihon.getHaitoukinuketorihoukbn());

        if (khHaitouKanri != null) {
            pUiBean.setVhthaitounendo(khHaitouKanri.getHaitounendo());
            pUiBean.setVhttounendod(khHaitouKanri.getTounendod());
            pUiBean.setVhtnaiteikakuteikbn(khHaitouKanri.getNaiteikakuteikbn());
        }

        if (khTumitateDKanri != null) {

            if (khHaitouKanri != null) {
                pUiBean.setVhttumitatenendo(khHaitouKanri.getHaitounendo());
            }
            pUiBean.setVhttumitated(khTumitateDKanri.getTumitated());
            pUiBean.setVhttumitatedtumitateymd(khTumitateDKanri.getTumitatedtumitateymd());
            pUiBean.setVhttumitatedshrkrkymd(khTumitateDKanri.getTumitatedshrkrkymd());
        }
        return true;
    }

    public void init (SetHaitoukinExecUiBeanParam pUiBean) {
        pUiBean.setVhthaitoukinuketorihoukbn(C_HaitoukinuketorihouKbn.BLNK);
        pUiBean.setVhthaitounendo(null);
        pUiBean.setVhttounendod(BizCurrency.optional());
        pUiBean.setVhtnaiteikakuteikbn(C_NaiteiKakuteiKbn.BLNK);
        pUiBean.setVhttumitatenendo(null);
        pUiBean.setVhttumitated(BizCurrency.optional());
        pUiBean.setVhttumitatedtumitateymd(null);
        pUiBean.setVhttumitatedshrkrkymd(null);
    }
}
