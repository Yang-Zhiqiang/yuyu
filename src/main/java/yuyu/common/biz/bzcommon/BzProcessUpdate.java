package yuyu.common.biz.bzcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.koutei.BzIwfUtilConstants;
import yuyu.common.biz.koutei.GetSyoriKokouteiInfo;
import yuyu.common.biz.koutei.GetSyoriKokouteiInfoOutBean;
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.io.koutei.ProcessUpdateInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessUpdateOutBean;
import yuyu.common.workflowcore.core.webservice.common.WSExtParam;
import yuyu.def.MessageId;
import yuyu.def.classification.C_UmuKbn;

/**
 * 業務共通 工程 業務共通工程情報更新クラス
 */
public class BzProcessUpdate {

    @Inject
    private static Logger logger;

    @Inject
    private IwfKouteiClient iwfKouteiClient;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private GetSyoriKokouteiInfo getSyoriKokouteiInfo;

    public void exec(BzProcessUpdateInputBean pBzProcessUpdateInputBean) {

        logger.debug("▽ 業務共通工程情報更新 開始");

        if (pBzProcessUpdateInputBean == null) {
            throw new BizAppException(MessageId.EBF0010, "業務共通工程情報更新入力Bean");
        }

        ProcessUpdateInBean processUpdateInBean = SWAKInjector.getInstance(ProcessUpdateInBean.class);

        WSExtParam extParam = new WSExtParam();

        processUpdateInBean.setGyoumukey(pBzProcessUpdateInputBean.getKouteiKanriId());

        processUpdateInBean.setFlowid(pBzProcessUpdateInputBean.getJimuTetuzukiCd());

        processUpdateInBean.setAccountid(baseUserInfo.getUser().getUserId());

        processUpdateInBean.setLockkey(pBzProcessUpdateInputBean.getKouteiLockKey());

        if (pBzProcessUpdateInputBean.getTuikaParamInputBean().getSkeijimukbn() != null) {
            extParam.setValues(pBzProcessUpdateInputBean.getTuikaParamInputBean().getSkeijimukbn().getValue());
            processUpdateInBean.setExtParam1(extParam);
        }

        extParam = new WSExtParam();
        if (pBzProcessUpdateInputBean.getTuikaParamInputBean().getMosuketukekbn() != null) {
            extParam.setValues(pBzProcessUpdateInputBean.getTuikaParamInputBean().getMosuketukekbn().getValue());
            processUpdateInBean.setExtParam2(extParam);
        }

        extParam = new WSExtParam();
        if (pBzProcessUpdateInputBean.getTuikaParamInputBean().getHknsyuruiNo() != null) {
            extParam.setValues(pBzProcessUpdateInputBean.getTuikaParamInputBean().getHknsyuruiNo().getValue());
            processUpdateInBean.setExtParam3(extParam);
        }

        extParam = new WSExtParam();
        if ("".equals(pBzProcessUpdateInputBean.getTuikaParamInputBean().getDairitencd1())) {
            extParam.setValues((String[]) null);
            processUpdateInBean.setExtParam4(extParam);
        }
        else if (!BizUtil.isBlank(pBzProcessUpdateInputBean.getTuikaParamInputBean().getDairitencd1())) {
            extParam.setValues(pBzProcessUpdateInputBean.getTuikaParamInputBean().getDairitencd1());
            processUpdateInBean.setExtParam4(extParam);
        }

        extParam = new WSExtParam();
        if ("".equals(pBzProcessUpdateInputBean.getTuikaParamInputBean().getDairitencd2())) {
            extParam.setValues((String[]) null);
            processUpdateInBean.setExtParam5(extParam);

        }
        else if (!BizUtil.isBlank(pBzProcessUpdateInputBean.getTuikaParamInputBean().getDairitencd2())) {
            extParam.setValues(pBzProcessUpdateInputBean.getTuikaParamInputBean().getDairitencd2());
            processUpdateInBean.setExtParam5(extParam);
        }

        extParam = new WSExtParam();
        if ("".equals(pBzProcessUpdateInputBean.getTuikaParamInputBean().getJimuyoucd())) {
            extParam.setValues((String[]) null);
            processUpdateInBean.setExtParam7(extParam);
        }
        else if (!BizUtil.isBlank(pBzProcessUpdateInputBean.getTuikaParamInputBean().getJimuyoucd())) {
            extParam.setValues(pBzProcessUpdateInputBean.getTuikaParamInputBean().getJimuyoucd());
            processUpdateInBean.setExtParam7(extParam);
        }

        extParam = new WSExtParam();
        if ("".equals(pBzProcessUpdateInputBean.getTuikaParamInputBean().getJimuyoucd())) {
            extParam.setValues("1");
            processUpdateInBean.setExtParam8(extParam);
        }
        else if (!BizUtil.isBlank(pBzProcessUpdateInputBean.getTuikaParamInputBean().getJimuyoucd())) {
            extParam.setValues("0");
            processUpdateInBean.setExtParam8(extParam);
        }

        extParam = new WSExtParam();
        if (pBzProcessUpdateInputBean.getTuikaParamInputBean().getDoujimosumu() != null) {
            extParam.setValues(pBzProcessUpdateInputBean.getTuikaParamInputBean().getDoujimosumu().getValue());
            processUpdateInBean.setExtParam9(extParam);
        }

        extParam = new WSExtParam();
        if (pBzProcessUpdateInputBean.getTuikaParamInputBean().getMosymd() != null) {
            if ("00000000".equals(String.valueOf(pBzProcessUpdateInputBean.getTuikaParamInputBean().getMosymd()))) {
                extParam.setValues((String[]) null);
            }
            else {
                extParam.setValues(String.valueOf(pBzProcessUpdateInputBean.getTuikaParamInputBean().getMosymd()));
            }
            processUpdateInBean.setExtParam10(extParam);
        }

        extParam = new WSExtParam();
        if ("".equals(pBzProcessUpdateInputBean.getTuikaParamInputBean().getJimustartymd())) {
            extParam.setValues((String[]) null);
            processUpdateInBean.setExtParam11(extParam);
        }
        else if (!BizUtil.isBlank(pBzProcessUpdateInputBean.getTuikaParamInputBean().getJimustartymd())) {
            extParam.setValues(pBzProcessUpdateInputBean.getTuikaParamInputBean().getJimustartymd());
            processUpdateInBean.setExtParam11(extParam);
        }

        extParam = new WSExtParam();
        if ("".equals(pBzProcessUpdateInputBean.getTuikaParamInputBean().getSyono())) {
            extParam.setValues((String[]) null);
            processUpdateInBean.setExtParam12(extParam);
        }
        else if (!BizUtil.isBlank(pBzProcessUpdateInputBean.getTuikaParamInputBean().getSyono())) {
            extParam.setValues(pBzProcessUpdateInputBean.getTuikaParamInputBean().getSyono());
            processUpdateInBean.setExtParam12(extParam);
        }

        extParam = new WSExtParam();
        if ("".equals(pBzProcessUpdateInputBean.getTuikaParamInputBean().getNksysyno())) {
            extParam.setValues((String[]) null);
            processUpdateInBean.setExtParam13(extParam);
        }
        else if (!BizUtil.isBlank(pBzProcessUpdateInputBean.getTuikaParamInputBean().getNksysyno())) {
            extParam.setValues(pBzProcessUpdateInputBean.getTuikaParamInputBean().getNksysyno());
            processUpdateInBean.setExtParam13(extParam);
        }

        extParam = new WSExtParam();
        if ("".equals(pBzProcessUpdateInputBean.getTuikaParamInputBean().getMosno())) {
            extParam.setValues((String[]) null);
            processUpdateInBean.setExtParam14(extParam);
        }
        else if (!BizUtil.isBlank(pBzProcessUpdateInputBean.getTuikaParamInputBean().getMosno())) {
            extParam.setValues(pBzProcessUpdateInputBean.getTuikaParamInputBean().getMosno());
            processUpdateInBean.setExtParam14(extParam);
        }

        extParam = new WSExtParam();
        if (pBzProcessUpdateInputBean.getTuikaParamInputBean().getKetteiKbn() != null) {
            extParam.setValues(pBzProcessUpdateInputBean.getTuikaParamInputBean().getKetteiKbn().getValue());
            processUpdateInBean.setExtParam15(extParam);
        }

        extParam = new WSExtParam();
        if (pBzProcessUpdateInputBean.getTuikaParamInputBean().getSeirituKbn() != null) {
            extParam.setValues(pBzProcessUpdateInputBean.getTuikaParamInputBean().getSeirituKbn().getValue());
            processUpdateInBean.setExtParam16(extParam);
        }

        extParam = new WSExtParam();
        if (pBzProcessUpdateInputBean.getTuikaParamInputBean().getLincjkKbn() != null) {
            extParam.setValues(pBzProcessUpdateInputBean.getTuikaParamInputBean().getLincjkKbn().getValue());
            processUpdateInBean.setExtParam17(extParam);
        }

        ProcessUpdateOutBean processUpdateOutBean = iwfKouteiClient.execProcessUpdate(processUpdateInBean);

        String kekkaStatus = processUpdateOutBean.getKekkastatus();

        String syousaiMsgCd = processUpdateOutBean.getSyousaimsgcd();

        if (!BzIwfUtilConstants.API_RESULTCD_OK.equals(kekkaStatus)) {
            throw new BizAppException(MessageId.EBS0007, "業務共通工程情報更新", "工程情報更新", syousaiMsgCd);
        }

        if (pBzProcessUpdateInputBean.getKokouteiUpdumu() != null &&
            pBzProcessUpdateInputBean.getKokouteiUpdumu().eq(C_UmuKbn.ARI)) {

            List<GetSyoriKokouteiInfoOutBean> getSyoriKokouteiInfoOutBeanLst =
                getSyoriKokouteiInfo.exec(pBzProcessUpdateInputBean.getKouteiKanriId(), pBzProcessUpdateInputBean.getJimuTetuzukiCd());

            if (getSyoriKokouteiInfoOutBeanLst != null && getSyoriKokouteiInfoOutBeanLst.size() != 0) {
                for (GetSyoriKokouteiInfoOutBean getSyoriKokouteiInfoOutBean : getSyoriKokouteiInfoOutBeanLst) {

                    processUpdateInBean.setGyoumukey(getSyoriKokouteiInfoOutBean.getSyoriKokouteikanriId());
                    processUpdateInBean.setFlowid(getSyoriKokouteiInfoOutBean.getSyoriKokouteiJimutetuzukiCd());

                    processUpdateOutBean = iwfKouteiClient.execProcessUpdate(processUpdateInBean);

                    kekkaStatus = processUpdateOutBean.getKekkastatus();

                    syousaiMsgCd = processUpdateOutBean.getSyousaimsgcd();

                    if (!BzIwfUtilConstants.API_RESULTCD_OK.equals(kekkaStatus)) {
                        throw new BizAppException(MessageId.EBS0007, "業務共通工程情報更新", "工程情報更新", syousaiMsgCd);
                    }

                }
            }
        }

        logger.debug("△ 業務共通工程情報更新 終了");
    }
}
