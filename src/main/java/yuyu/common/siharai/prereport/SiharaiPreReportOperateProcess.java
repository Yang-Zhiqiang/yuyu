package yuyu.common.siharai.prereport;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.koutei.BzOutputProcessRecord;
import yuyu.common.biz.koutei.BzProcessCreate;
import yuyu.common.biz.koutei.BzProcessCreateInBean;
import yuyu.common.biz.koutei.BzProcessCreateOutBean;
import yuyu.common.biz.prereport.PreReportOperateProcess;
import yuyu.common.siharai.koutei.SiHituyousyoruiHantei;
import yuyu.common.siharai.koutei.SiHituyousyoruiHanteiInBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_KouteiSakuseiKekkaKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.db.entity.BM_TorikomiSyoruiHukaInfo;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettorikomisyoruimst.WSGetTorikomiSyoruiMstResponse.TorikomiSyoruiBean;

/**
 * 保険金給付金支払 帳票前処理 保険金給付金支払帳票作成前工程操作処理
 */
public class SiharaiPreReportOperateProcess extends PreReportOperateProcess {

    @Inject
    private SiharaiPreReportRenkeiBean siharaiPreReportRenkeiBean;

    @Inject
    private BzProcessCreate bzProcessCreate;

    @Inject
    private SiHituyousyoruiHantei siHituyousyoruiHantei;

    @Inject
    private BzOutputProcessRecord bzOutputProcessRecord;

    public SiharaiPreReportOperateProcess() {
        super();
    }

    @Override
    public String operateProcess(TorikomiSyoruiBean pTorikomiSyoruiMstBean,
            BM_TorikomiSyoruiHukaInfo pTorikomiSyoruiHukaInfoBean,
            ReportServicesBean pRsBean) {

        String kouteiKanriId = siharaiPreReportRenkeiBean.getSakuseizumiKouteikanriIdMp().get(pRsBean.getKensakuKeys()[0]);

        if (BizUtil.isBlank(kouteiKanriId)) {

            BzProcessCreateInBean bzProcessCreateInBean = new BzProcessCreateInBean();

            bzProcessCreateInBean.setSyoNo(pRsBean.getKensakuKeys()[0]);
            bzProcessCreateInBean.setSkNo(siharaiPreReportRenkeiBean.getSkNo());
            bzProcessCreateInBean.setJimuTetuzukiCd(pTorikomiSyoruiMstBean.getFlowid());
            bzProcessCreateInBean.setOyaKouteiKanriId(
                    siharaiPreReportRenkeiBean.getBzWorkflowInfo().getOyaKouteiKanriId());
            bzProcessCreateInBean.setOyaKouteiJimuTetuzukiCd(
                    siharaiPreReportRenkeiBean.getBzWorkflowInfo().getOyaKouteiJimuTetuzukiCd());

            BzProcessCreateOutBean bzProcessCreateOutBean = bzProcessCreate.exec(bzProcessCreateInBean);

            if (BizUtil.isBlank(siharaiPreReportRenkeiBean.getBzWorkflowInfo().getOyaKouteiKanriId()) ||
                    BizUtil.isBlank(siharaiPreReportRenkeiBean.getBzWorkflowInfo().getOyaKouteiJimuTetuzukiCd())) {
                if (C_KouteiSakuseiKekkaKbn.SUCCESS.eq(bzProcessCreateOutBean.getKouteiSakuseiKekkaKbn())) {
                }
                else if (C_KouteiSakuseiKekkaKbn.MISAKUSEI_KIZON_ARI.eq(bzProcessCreateOutBean.getKouteiSakuseiKekkaKbn())) {
                    throw new BizAppException(MessageId.EBS0009, pTorikomiSyoruiMstBean.getFlowid(),
                            bzProcessCreateOutBean.getKouteiKanriId());
                }
                else {
                    throw new BizAppException(MessageId.EBS0008);
                }
            }
            else {
                if (C_KouteiSakuseiKekkaKbn.SUCCESS.eq(bzProcessCreateOutBean.getKouteiSakuseiKekkaKbn()) ||
                        C_KouteiSakuseiKekkaKbn.MISAKUSEI_KIZON_ARI.eq(bzProcessCreateOutBean.getKouteiSakuseiKekkaKbn())) {
                }
                else {
                    throw new BizAppException(MessageId.EBS0008);
                }
            }

            kouteiKanriId = bzProcessCreateOutBean.getKouteiKanriId();

            if (BizUtil.isBlank(siharaiPreReportRenkeiBean.getBzWorkflowInfo().getOyaKouteiKanriId()) ||
                    BizUtil.isBlank(siharaiPreReportRenkeiBean.getBzWorkflowInfo().getOyaKouteiJimuTetuzukiCd())) {
                SiHituyousyoruiHanteiInBean siHituyousyoruiHanteiInBean = siharaiPreReportRenkeiBean.
                        getSiHituyousyoruiHanteiInBeanMp().get(pRsBean.getKensakuKeys()[0]);

                siHituyousyoruiHanteiInBean.setKouteiKanriId(kouteiKanriId);

                siHituyousyoruiHantei.exec(siHituyousyoruiHanteiInBean);
            }

            bzOutputProcessRecord.exec(kouteiKanriId,
                    pTorikomiSyoruiMstBean.getFlowid(),
                    siharaiPreReportRenkeiBean.getSyoriComment(),
                    siharaiPreReportRenkeiBean.getTaskNm(),
                    C_SyorikekkaKbn.KANRYOU);

            siharaiPreReportRenkeiBean.getSakuseizumiKouteikanriIdMp().put(pRsBean.getKensakuKeys()[0], kouteiKanriId);
        }

        return kouteiKanriId;
    }
}