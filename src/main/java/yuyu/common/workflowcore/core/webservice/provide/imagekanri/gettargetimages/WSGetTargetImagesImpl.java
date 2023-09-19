package yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettargetimages;

import static yuyu.common.workflowcore.core.iwfinfr.util.enumerate.E_TokenVarKey.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.api.IWorkflowProcessDef;
import yuyu.common.workflowcore.api.api.IWorkflowToken;
import yuyu.common.workflowcore.api.api.impl.WorkflowContextFactory;
import yuyu.common.workflowcore.api.exception.WorkflowRuntimeException;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfBytesSerializer;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfDateUtils;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfImageEncryptor;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfPDFUtils;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettargetimages.WSGetTargetImagesResponse.ImageInfoBean;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_AngoukaHousikiKbn;
import yuyu.def.classification.C_KengenUmuKbn;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.classification.C_YesNoKbn;
import yuyu.def.db.entity.AT_UserRole;
import yuyu.def.db.entity.WM_TorikomiSyorui;
import yuyu.def.db.entity.WT_GyoumuKey;
import yuyu.def.db.entity.WT_KengenSyorui;
import yuyu.def.db.entity.WT_PDFHozon;
import yuyu.def.db.entity.WT_Page;
import yuyu.def.db.entity.WT_TorikomiKanri;
import yuyu.def.db.entity.WT_TorikomiRelation;
import yuyu.def.workflowcore.configration.IwfCoreConfig;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;
import yuyu.infr.report.EncryptKeyGenerator;

/**
 * 対象イメージ取得サービスメインクラス
 */
public class WSGetTargetImagesImpl implements WSGetTargetImages {

    private static final Logger LOGGER = LoggerFactory.getLogger(WSGetTargetImagesImpl.class);

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private IwfImageEncryptor encryptor;


    public WSGetTargetImagesImpl() {
        super();
    }

    public WSGetTargetImagesResponse validate(WSGetTargetImagesRequest request)
        throws Exception {
        LOGGER.debug("│バリデーションチェック処理・・・");

        WSGetTargetImagesResponse oResponse = new WSGetTargetImagesResponse();

        String sAccountId = request.getAccountid();
        String sSyoruitoutyakuYmdFrom = request.getSyoruitoutyakuymdfrom();
        String sSyoruitoutyakuYmdTo = request.getSyoruitoutyakuymdto();

        if (StringUtils.isEmpty(sAccountId)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "アカウントＩＤ");
        }

        if (StringUtils.isNotEmpty(sSyoruitoutyakuYmdFrom)) {
            if(!IwfDateUtils.checkDate(sSyoruitoutyakuYmdFrom)){
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF3010);
            }
        }

        if (StringUtils.isNotEmpty(sSyoruitoutyakuYmdTo)) {
            if(!IwfDateUtils.checkDate(sSyoruitoutyakuYmdTo)){
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF3014);
            }
        }
        return oResponse;
    }

    public String getServiceName() {

        return WSGetTargetImagesRequest.sSERVICE_NAME;
    }

    @Override
    @Transactional
    public WSGetTargetImagesResponse executeBizMain(
        WSGetTargetImagesRequest request) throws Exception {

        WSGetTargetImagesResponse oWSResponse = new WSGetTargetImagesResponse();

        String sAccountId = request.getAccountid();
        String sFlowId = request.getFlowid();
        String sTorikomiSyoruiCd = request.getTorikomisyoruicd();
        String sSyoruitoutyakuYmdFrom = request.getSyoruitoutyakuymdfrom();
        String sSyoruitoutyakuYmdTo = request.getSyoruitoutyakuymdto();
        String sSyzkDaibunruiId = request.getSyzkdaibunruiid();
        String sSyzkSyoubunruiId = request.getSyzksyoubunruiid();
        String sKouteiJyoutai = request.getKouteijyoutai();
        String sRequestid = request.getRequestid();

        LOGGER.debug("[ReqId="+ sRequestid + "]主処理を開始します。");

        IWorkflowContext oWfCon = WorkflowContextFactory.newInstance();

        ArrayList<ImageInfoBean> imageInfos = new ArrayList<ImageInfoBean>();
        ImageInfoBean imageInfoBean = new ImageInfoBean();

        try {
            oWfCon.open();

            List<WM_TorikomiSyorui> syoruiList = iwfCoreDomManager.getTorikomiSyoruis(sTorikomiSyoruiCd, sSyzkDaibunruiId, sSyzkSyoubunruiId, sFlowId, null);
            Iterator<WM_TorikomiSyorui> itrsyorui = syoruiList.iterator();
            WM_TorikomiSyorui syorui = null;

            if(itrsyorui.hasNext()){
                while(itrsyorui.hasNext()){
                    syorui = itrsyorui.next();

                    String sTorikomiSyoruiCd_syorui =syorui.getTorikomiSyoruiCd();
                    String sFlowId_syorui =syorui.getFlowId();

                    List<WT_TorikomiKanri> kanriList = iwfCoreDomManager.getTorikomiKanris(sTorikomiSyoruiCd_syorui);
                    Iterator<WT_TorikomiKanri> itrkanri = kanriList.iterator();
                    WT_TorikomiKanri kanri = null;

                    while(itrkanri.hasNext()){
                        kanri = itrkanri.next();

                        String sImageId_kanri = kanri.getIwfImageId();

                        LOGGER.debug("[ReqId="+ sRequestid + "]ページテーブルから取得します。");
                        LOGGER.debug("[ReqId="+ sRequestid + "]取得条件:");
                        LOGGER.debug("[ReqId="+ sRequestid + "]["+ WT_Page.IWFIMAGEID + "=" + sImageId_kanri + "]");
                        String sCndToutyakuYmdFrom = "00000000000000000";
                        String sCndToutyakuYmdTo = "99999999999999999";
                        if(StringUtils.isNotEmpty(sSyoruitoutyakuYmdFrom)){
                            sCndToutyakuYmdFrom = sSyoruitoutyakuYmdFrom;
                        }
                        LOGGER.debug("[ReqId="+ sRequestid + "]["+ WT_Page.SYORUITTYKYMDTIME + "_from=" + sCndToutyakuYmdFrom + "]");

                        if(StringUtils.isNotEmpty(sSyoruitoutyakuYmdTo)){
                            sCndToutyakuYmdTo = sSyoruitoutyakuYmdTo;
                        }
                        LOGGER.debug("[ReqId="+ sRequestid + "]["+ WT_Page.SYORUITTYKYMDTIME + "_to=" + sCndToutyakuYmdTo + "]");

                        List<WT_Page> pageList = iwfCoreDomManager.getPages(sImageId_kanri, sCndToutyakuYmdFrom, sCndToutyakuYmdTo);
                        Iterator<WT_Page> itrpage = pageList.iterator();
                        WT_Page page = null;

                        ArrayList<byte[]> oBytes = new ArrayList<byte[]>();
                        String sSyoruiToutyakuTime = "";

                        if(itrpage.hasNext()){
                            while(itrpage.hasNext()){
                                page = itrpage.next();

                                String sImageId = page.getIwfImageId();
                                String sPageId = page.getPageId();

                                if(StringUtils.isEmpty(sSyoruiToutyakuTime)){
                                    sSyoruiToutyakuTime = page.getSyoruittykymdtime();
                                }

                                LOGGER.debug("[ReqId="+ sRequestid + "]PDF保存テーブルから取得します。");
                                LOGGER.debug("[ReqId="+ sRequestid + "]取得条件:");
                                LOGGER.debug("[ReqId="+ sRequestid + "]["+ WT_Page.PAGEID + "=" + sPageId + "]");
                                WT_PDFHozon pdfHozon = iwfCoreDomManager.getPDFHozon(sImageId, sPageId);

                                byte[] pdf = pdfHozon.getPdfData();
                                if(C_YesNoKbn.YES.eq(syorui.getAngoukaKbn())){
                                    String encryptKey = "";
                                    if(C_AngoukaHousikiKbn.PACKAGE.eq(syorui.getAngoukaHousikiKbn())) {
                                        encryptKey = sImageId;
                                    }else{
                                        try{
                                            encryptKey = SWAKInjector.getInstance(EncryptKeyGenerator.class).gerenateKey();
                                        } catch(Exception e) {
                                            LOGGER.debug("EncryptKeyGeneratorの実装またはバインドがされていません。");
                                            throw e;
                                        }
                                    }
                                    encryptor.setKey(encryptKey);
                                    pdf = encryptor.decode(pdf);
                                }
                                if(C_YesNoKbn.YES.eq(syorui.getZipHozonKbn())){
                                    pdf = IwfBytesSerializer.unzip(pdf);
                                }

                                oBytes.add(pdf);
                            }
                        }

                        byte[] oPDFImage = null;
                        if(!oBytes.isEmpty()){
                            oPDFImage = IwfPDFUtils.concatPDF(oBytes);
                        }

                        List<WT_TorikomiRelation> torikomiRelations = iwfCoreDomManager.getTorikomiRelationsByImageId(sImageId_kanri);

                        for (WT_TorikomiRelation torikomiRelation : torikomiRelations) {
                            String sGyoumuKey_relation = torikomiRelation.getGyoumuKey();

                            LOGGER.debug("[ReqId=" + sRequestid + "]トークンＩＤ取得[sFlowId=" + sFlowId_syorui
                                + "][sGyoumuKey=" + sGyoumuKey_relation + "]");
                            String sTokenId = "";
                            WT_GyoumuKey wT_GyoumuKey = iwfCoreDomManager.getGyoumuKey(sFlowId_syorui, sGyoumuKey_relation);
                            if (null == wT_GyoumuKey) {
                                LOGGER.warn("該当の業務キーとフローIDの組み合わせは存在しません。[gyoumukey = " + sGyoumuKey_relation + " flowId = "
                                    + sFlowId_syorui + "]");
                            } else {
                                sTokenId = wT_GyoumuKey.getTokenId();
                            }

                            if (StringUtils.isEmpty(sTokenId)) {
                                IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF3011, "トークンＩＤ");
                                LOGGER.debug("[ReqId=" + sRequestid + "]指定されたフローＩＤ、業務キーに紐づくトークンが存在しません。");
                                return oWSResponse;
                            }

                            LOGGER.debug("[ReqId=" + sRequestid + "]プロセス定義取得[sFlowId=" + sFlowId_syorui + "]");
                            IWorkflowProcessDef oProcess;
                            try {
                                oProcess = oWfCon.getProcessDef(sFlowId_syorui);
                            } catch (WorkflowRuntimeException e) {
                                iwfCoreDomManager.clear();
                                if (oWfCon.isOpen()) {
                                    oWfCon.close();
                                }

                                IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF3012);

                                return oWSResponse;
                            }

                            LOGGER.debug("[ReqId=" + sRequestid + "]トークン取得[sTokenId=" + sTokenId + "]");
                            IWorkflowToken oToken;
                            try {
                                oToken = oProcess.getToken(sTokenId);

                            } catch (WorkflowRuntimeException e) {
                                iwfCoreDomManager.clear();
                                if (oWfCon.isOpen()) {
                                    oWfCon.close();
                                }

                                IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF0001, "対象イメージ取得");
                                LOGGER.debug("[ReqId=" + sRequestid + "]指定されたトークンＩＤに紐づくトークンが存在しません。");

                                return oWSResponse;
                            }

                            String sSyoriStatus = oToken.getStringVariable(SYORI_STATUS.key);

                            if (StringUtils.isNotEmpty(sKouteiJyoutai)) {
                                if (!sKouteiJyoutai.equals(sSyoriStatus)) {
                                    LOGGER.debug("[ReqId=" + sRequestid
                                        + "]指定された工程状態と処理ステータスが一致しないトークンは取得対象外。[sKouteiJyoutai=" + sKouteiJyoutai
                                        + "][sSyoriStatus=" + sSyoriStatus + "]");
                                    continue;
                                }
                            }

                            String sKengenumu = C_KengenUmuKbn.NONE.getValue();

                            LOGGER.debug("[ReqId=" + sRequestid + "]ユーザーロールテーブルから取得します。");
                            LOGGER.debug("[ReqId=" + sRequestid + "]取得条件:");
                            LOGGER.debug("[ReqId=" + sRequestid + "][" + AT_UserRole.USERID + "=" + sAccountId
                                + "]");
                            List<String> roles = new ArrayList<String>();
                            List<AT_UserRole> userRoles = baseDomManager.getUser(sAccountId).getUserRoles();

                            for (Iterator<AT_UserRole> iterator = userRoles.iterator(); iterator.hasNext();) {
                                roles.add(iterator.next().getRoleCd());
                            }

                            if (!roles.isEmpty()) {
                                LOGGER.debug("[ReqId=" + sRequestid + "]権限明細（書類）テーブルから取得します。");
                                LOGGER.debug("[ReqId=" + sRequestid + "]取得条件:");
                                LOGGER.debug("[ReqId=" + sRequestid + "][" + WT_KengenSyorui.ROLECD + "="
                                    + roles.toString() + "]");
                                LOGGER.debug("[ReqId=" + sRequestid + "][" + WT_KengenSyorui.TORIKOMISYORUICD + "="
                                    + sTorikomiSyoruiCd_syorui + "]");
                                List<WT_KengenSyorui> kengensyoruiList = iwfCoreDomManager.getKengenSyoruis(
                                    sTorikomiSyoruiCd_syorui, roles.toArray(new String[0]));

                                if (!kengensyoruiList.isEmpty()) {
                                    sKengenumu = C_KengenUmuKbn.ARI.getValue();
                                }
                            }

                            imageInfoBean = new ImageInfoBean();

                            imageInfoBean.setImageid(sImageId_kanri);
                            imageInfoBean.setGyoumukey(sGyoumuKey_relation);
                            imageInfoBean.setTorikomisyoruicd(sTorikomiSyoruiCd_syorui);
                            imageInfoBean.setSyoruitoutyakutime(sSyoruiToutyakuTime);
                            imageInfoBean.setKouteijyoutai(sSyoriStatus);
                            imageInfoBean.setKengenumu(sKengenumu);
                            imageInfoBean.setPdfimage(oPDFImage);

                            imageInfos.add(imageInfoBean);
                        }
                    }
                }
                Integer iLimitCount = getLimitCountConfig();

                if(imageInfos.size() > iLimitCount){
                    LOGGER.debug("[ReqId="+ sRequestid + "]イメージ取得最大件数を超えています。[取得件数=" + imageInfos.size() + "件][最大件数" + iLimitCount + "件]");
                    IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF3013, String.valueOf(iLimitCount));
                    return oWSResponse;
                }
                oWSResponse.setImageinfolist(imageInfos);

            } else {
                LOGGER.debug("[ReqId="+ sRequestid + "]取込書類マスタからデータが取得できませんでした。");
                IwfEditMessageUtil.setMsgResultNG_RecordNotFound(oWSResponse, WM_TorikomiSyorui.TABLE_NAME);
                return oWSResponse;
            }

            IwfEditMessageUtil.setMsgResultOK(oWSResponse, "対象イメージ取得");

            LOGGER.debug("[ReqId="+ sRequestid + "]コンテキストをクローズします。");

            oWfCon.close();

        } catch (Exception e) {
            LOGGER.debug("[ReqId="+ sRequestid + "]例外が発生しました。");
            e.printStackTrace();

            if(oWfCon.isOpen()){
                oWfCon.close();
            }

            IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF0001, "対象イメージ取得");
        } finally {
            if(oWfCon.isOpen()){
                oWfCon.close();
            }
        }
        return oWSResponse;
    }

    public WSGetTargetImagesResponse getStubResult(
        WSGetTargetImagesRequest request) throws Exception {

        return null;
    }

    public void executeBizTerminate(WSGetTargetImagesRequest request, WSGetTargetImagesResponse response) throws Exception {

        LOGGER.debug("│終了開始・・・");
    }

    public WSGetTargetImagesResponse getBootErrResponse() {
        WSGetTargetImagesResponse res = new WSGetTargetImagesResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }

    public Integer getLimitCountConfig(){
        return IwfCoreConfig.getInstance().getMaxImageKensu();
    }

}
