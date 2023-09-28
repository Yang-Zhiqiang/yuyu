package yuyu.common.biz.koutei;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_WariateHukaInfoKanri;
import yuyu.def.db.entity.BT_WariateHukaInfo;

/**
 * 業務共通 工程 割当不可情報設定
 */
public class SetWariateHukaInfo {

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    @Nullable
    private AS_Kinou kinou;

    public SetWariateHukaInfo() {
        super();
    }

    public void exec(String pKouteiKanriId, String pSubSystemId, String pJimuTetuzukiCd, String pCurrentTaskId,
        String pNextTaskId) {

        List<BM_WariateHukaInfoKanri> wariateHukaInfoKanriLst = bizDomManager.
            getWariateHukaInfoKanrisBySubSystemIdJimutetuzukicdCurrenttskidNexttskid(
                pSubSystemId, pJimuTetuzukiCd, pCurrentTaskId, pNextTaskId);

        if (wariateHukaInfoKanriLst != null && wariateHukaInfoKanriLst.size() > 0) {
            for (BM_WariateHukaInfoKanri wariateHukaInfoKanri : wariateHukaInfoKanriLst) {

                if (!BizUtil.isBlank(wariateHukaInfoKanri.getWrthukatskid())) {

                    BT_WariateHukaInfo wariateHukaInfo = new BT_WariateHukaInfo();

                    wariateHukaInfo.setKouteikanriid(pKouteiKanriId);
                    wariateHukaInfo.setSubSystemId(pSubSystemId);
                    wariateHukaInfo.setJimutetuzukicd(pJimuTetuzukiCd);
                    wariateHukaInfo.setWrthukatskid(wariateHukaInfoKanri.getWrthukatskid());
                    wariateHukaInfo.setUserId(baseUserInfo.getUserId());
                    wariateHukaInfo.setWrthukakaijyotskid(pCurrentTaskId);
                    if (kinou == null) {
                        wariateHukaInfo.setGyoumuKousinKinou(YuyuBizConfig.getInstance().getProvideKinouId());
                    }
                    else {
                        wariateHukaInfo.setGyoumuKousinKinou(kinou.getKinouId());
                    }
                    wariateHukaInfo.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    wariateHukaInfo.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                    BizPropertyInitializer.initialize(wariateHukaInfo);

                    bizDomManager.insert(wariateHukaInfo);
                }
                if (!BizUtil.isBlank(wariateHukaInfoKanri.getWrthukakaijyotskid())) {

                    List<BT_WariateHukaInfo> wariateHukaInfoLst = bizDomManager.
                        getWariateHukaInfosByKouteikanriidSubSystemIdJimutetuzukicdWrthukakaijyotskid(
                            pKouteiKanriId, pSubSystemId, pJimuTetuzukiCd, wariateHukaInfoKanri.getWrthukakaijyotskid());

                    bizDomManager.delete(wariateHukaInfoLst);
                }
            }
        }
    }
}
