package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.def.classification.C_SKNaiyouChkKbn;

/**
 * 保険金給付金支払 請求内容チェック 契約者変更チェック
 */
public class ChkSubKeiyakusyaHnk {

    @Inject
    private static Logger logger;

    public ChkSubKeiyakusyaHnk() {
        super();
    }

    public void exec(Integer pKykHnkKaisuu, List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 契約者変更チェック 開始");

        if (pKykHnkKaisuu > 0) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.KEIYAKUSYAHNK_CHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }

        logger.debug("△ 契約者変更チェック 終了");
    }

}
