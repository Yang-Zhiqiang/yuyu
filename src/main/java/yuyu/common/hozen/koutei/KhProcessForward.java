package yuyu.common.hozen.koutei;

import javax.inject.Inject;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.koutei.BzProcessForward;
import yuyu.common.biz.koutei.BzProcessForwardInBean;
import yuyu.def.classification.C_SyorikekkaKbn;

/**
 * 契約保全 工程 契約保全工程遷移
 */
public class KhProcessForward {

    @Inject
    private BaseUserInfo userInfo;

    @Inject
    private BzProcessForward bzProcessForward;

    public KhProcessForward() {
        super();
    }

    public void exec(String pKouteiKanriId, String pJimuTetuzukiCd, String pKouteiLockKey,
        String pSyoriComment, KhRuleBean pKhRuleBean) {

        C_SyorikekkaKbn syorikekkaKbn = null;
        String saiwariateUserId;

        if (C_SyorikekkaKbn.HORYUU.eq(pKhRuleBean.getSyoriKekkaKbn())) {

            syorikekkaKbn = pKhRuleBean.getSyoriKekkaKbn();
            saiwariateUserId = userInfo.getUserId();
        }
        else if (C_SyorikekkaKbn.TENSOU.eq(pKhRuleBean.getSyoriKekkaKbn())) {

            syorikekkaKbn = pKhRuleBean.getSyoriKekkaKbn();
            saiwariateUserId = pKhRuleBean.getSaiwariateUserId();
        }
        else {

            syorikekkaKbn = pKhRuleBean.getSyoriKekkaKbn();
            saiwariateUserId = "";
        }

        KhIwfApiRuleBean khIwfApiRuleBean = new KhIwfApiRuleBean();

        khIwfApiRuleBean.setSyoriKekkaKbnNaiyou(pKhRuleBean.getSyoriKekkaKbn().getContent());
        khIwfApiRuleBean.setSasimodosisakiKbnNaiyou(pKhRuleBean.getSasimodosisakiKbn().getContent());
        khIwfApiRuleBean.setKyuukouzaAnnaiKbnNaiyou(pKhRuleBean.getKyuukouzaAnnaiKbn().getContent());
        khIwfApiRuleBean.setAuthorijkKbnNaiyou(pKhRuleBean.getAuthorijkKbn().getContent());

        BzProcessForwardInBean bzProcessForwardInBean = new BzProcessForwardInBean();

        bzProcessForwardInBean.setKouteiKanriId(pKouteiKanriId);
        bzProcessForwardInBean.setJimuTetuzukiCd(pJimuTetuzukiCd);
        bzProcessForwardInBean.setKouteiLockKey(pKouteiLockKey);
        bzProcessForwardInBean.setSyoriComment(pSyoriComment);
        bzProcessForwardInBean.setIwfApiRuleBean(khIwfApiRuleBean);
        bzProcessForwardInBean.setSyorikekkaKbn(syorikekkaKbn);
        bzProcessForwardInBean.setSaiwariateUserId(saiwariateUserId);

        bzProcessForward.exec(bzProcessForwardInBean);
    }
}
