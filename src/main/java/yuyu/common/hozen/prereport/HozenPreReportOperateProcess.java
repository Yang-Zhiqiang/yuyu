package yuyu.common.hozen.prereport;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.configuration.CoreConfig;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.koutei.BzOutputProcessRecord;
import yuyu.common.biz.koutei.BzProcessCreate;
import yuyu.common.biz.koutei.BzProcessCreateInBean;
import yuyu.common.biz.koutei.BzProcessCreateOutBean;
import yuyu.common.biz.prereport.PreReportOperateProcess;
import yuyu.common.hozen.koutei.KhHituyousyoruiHantei;
import yuyu.common.hozen.koutei.KhHituyousyoruiHanteiInBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_KouteiSakuseiKekkaKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.db.entity.BM_TorikomiSyoruiHukaInfo;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettorikomisyoruimst.WSGetTorikomiSyoruiMstResponse.TorikomiSyoruiBean;

/**
 * 契約保全 帳票前処理 契約保全帳票作成前工程操作処理
 */
public class HozenPreReportOperateProcess extends PreReportOperateProcess {

    @Inject
    private HozenPreReportRenkeiBean hozenPreReportRenkeiBean;

    @Inject
    private BzProcessCreate bzProcessCreate;

    @Inject
    private KhHituyousyoruiHantei khHituyousyoruiHantei;

    @Inject
    private BzOutputProcessRecord bzOutputProcessRecord;

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    public HozenPreReportOperateProcess() {
        super();
    }

    @Override
    public String operateProcess(TorikomiSyoruiBean pTorikomiSyoruiMstBean,
        BM_TorikomiSyoruiHukaInfo pTorikomiSyoruiHukaInfoBean,
        ReportServicesBean rsBean) {

        String kouteiKanriId;

        if (!CoreConfig.getInstance().isBatchProduct()) {

            if (BizUtil.isBlank(hozenPreReportRenkeiBean.getSakuseizumiKouteikanriId())) {

                BzProcessCreateInBean bzProcessCreateInBean = new BzProcessCreateInBean();

                bzProcessCreateInBean.setSyoNo(hozenPreReportRenkeiBean.getSyoNo());
                bzProcessCreateInBean.setJimuTetuzukiCd(pTorikomiSyoruiMstBean.getFlowid());
                bzProcessCreateInBean.setOyaKouteiKanriId(
                    hozenPreReportRenkeiBean.getBzWorkflowInfo().getOyaKouteiKanriId());
                bzProcessCreateInBean.setOyaKouteiJimuTetuzukiCd(
                    hozenPreReportRenkeiBean.getBzWorkflowInfo().getOyaKouteiJimuTetuzukiCd());

                BzProcessCreateOutBean bzProcessCreateOutBean = bzProcessCreate.exec(bzProcessCreateInBean);

                if (BizUtil.isBlank(hozenPreReportRenkeiBean.getBzWorkflowInfo().getOyaKouteiKanriId()) ||
                    BizUtil.isBlank(hozenPreReportRenkeiBean.getBzWorkflowInfo().getOyaKouteiJimuTetuzukiCd())) {
                    if (C_KouteiSakuseiKekkaKbn.SUCCESS.eq(bzProcessCreateOutBean.getKouteiSakuseiKekkaKbn())) {
                    }
                    else if (C_KouteiSakuseiKekkaKbn.MISAKUSEI_KIZON_ARI.eq(bzProcessCreateOutBean
                        .getKouteiSakuseiKekkaKbn())) {
                        throw new BizAppException(MessageId.EBS0009, pTorikomiSyoruiMstBean.getFlowid(),
                            bzProcessCreateOutBean.getKouteiKanriId());
                    }
                    else {
                        throw new BizAppException(MessageId.EBS0008);
                    }
                }
                else {
                    if (C_KouteiSakuseiKekkaKbn.SUCCESS.eq(bzProcessCreateOutBean.getKouteiSakuseiKekkaKbn()) ||
                        C_KouteiSakuseiKekkaKbn.MISAKUSEI_KIZON_ARI.eq(bzProcessCreateOutBean
                            .getKouteiSakuseiKekkaKbn())) {
                    }
                    else {
                        throw new BizAppException(MessageId.EBS0008);
                    }
                }

                kouteiKanriId = bzProcessCreateOutBean.getKouteiKanriId();

                if (BizUtil.isBlank(hozenPreReportRenkeiBean.getBzWorkflowInfo().getOyaKouteiKanriId()) ||
                    BizUtil.isBlank(hozenPreReportRenkeiBean.getBzWorkflowInfo().getOyaKouteiJimuTetuzukiCd())) {
                    KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean =
                        hozenPreReportRenkeiBean.getKhHituyousyoruiHanteiInBean();

                    khHituyousyoruiHanteiInBean.setKouteikanriId(kouteiKanriId);
                    khHituyousyoruiHanteiInBean.setJimutetuzukiCd(pTorikomiSyoruiMstBean.getFlowid());

                    khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);
                }

                String taskNm = getTaskNm(pTorikomiSyoruiMstBean.getTorikomisyoruinm(), pTorikomiSyoruiMstBean.getFlowid());

                bzOutputProcessRecord.exec(kouteiKanriId,
                    pTorikomiSyoruiMstBean.getFlowid(),
                    hozenPreReportRenkeiBean.getSyoriComment(),
                    taskNm,
                    C_SyorikekkaKbn.KANRYOU);

                hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId(kouteiKanriId);
            }
            else {
                kouteiKanriId = hozenPreReportRenkeiBean.getSakuseizumiKouteikanriId();
            }
        }
        else {

            if (BizUtil.isBlank(hozenPreReportRenkeiBean.getSakuseizumiKouteikanriId())) {

                BzProcessCreateInBean bzProcessCreateInBean = new BzProcessCreateInBean();

                bzProcessCreateInBean.setSyoNo(hozenPreReportRenkeiBean.getSyoNo());
                bzProcessCreateInBean.setJimuTetuzukiCd(pTorikomiSyoruiMstBean.getFlowid());

                BzProcessCreateOutBean bzProcessCreateOutBean = bzProcessCreate.exec(bzProcessCreateInBean);

                if (C_KouteiSakuseiKekkaKbn.SUCCESS.eq(bzProcessCreateOutBean.getKouteiSakuseiKekkaKbn())) {
                }
                else if (C_KouteiSakuseiKekkaKbn.MISAKUSEI_KIZON_ARI.eq(bzProcessCreateOutBean
                    .getKouteiSakuseiKekkaKbn())) {
                    throw new BizAppException(MessageId.EBS0009, pTorikomiSyoruiMstBean.getFlowid(),
                        bzProcessCreateOutBean.getKouteiKanriId());
                }
                else {
                    throw new BizAppException(MessageId.EBS0008);
                }

                kouteiKanriId = bzProcessCreateOutBean.getKouteiKanriId();
                iwfCoreDomManager.flush();

                KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean =
                    hozenPreReportRenkeiBean.getKhHituyousyoruiHanteiInBean();

                khHituyousyoruiHanteiInBean.setKouteikanriId(kouteiKanriId);
                khHituyousyoruiHanteiInBean.setJimutetuzukiCd(pTorikomiSyoruiMstBean.getFlowid());

                khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

                String taskNm = getTaskNm(pTorikomiSyoruiMstBean.getTorikomisyoruinm(), pTorikomiSyoruiMstBean.getFlowid());

                bzOutputProcessRecord.exec(kouteiKanriId,
                    pTorikomiSyoruiMstBean.getFlowid(),
                    hozenPreReportRenkeiBean.getSyoriComment(),
                    taskNm,
                    C_SyorikekkaKbn.KANRYOU);

                hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId(kouteiKanriId);
            }
            else {
                kouteiKanriId = hozenPreReportRenkeiBean.getSakuseizumiKouteikanriId();
            }
        }

        return kouteiKanriId;
    }

    private String getTaskNm(String pSyoruiNm, String pJimuTetuzukiCd) {

        return pSyoruiNm + "作成";
    }
}
