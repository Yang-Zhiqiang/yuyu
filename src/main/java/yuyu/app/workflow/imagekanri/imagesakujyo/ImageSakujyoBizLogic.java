package yuyu.app.workflow.imagekanri.imagesakujyo;

import static yuyu.app.workflow.imagekanri.imagesakujyo.GenImageSakujyoConstants.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.web.message.MessageManager;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;

import org.slf4j.Logger;

import yuyu.app.workflow.imagekanri.imagesakujyo.ImageSakujyoConstants.E_SubSystem;
import yuyu.app.workflow.imagekanri.torikomihyousisakusei.TorikomiHyousiSakuseiConstants;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.workflow.wfcommon.GetExecutableSubSystemsSelectInBean;
import yuyu.common.workflow.wfcommon.GetExecutableSubSystemsSelectOutBean;
import yuyu.common.workflow.wfcommon.WfUserSelectCommon;
import yuyu.common.workflow.workflowutility.DropImageResultBean;
import yuyu.common.workflow.workflowutility.GetImageInfoListResultBean;
import yuyu.common.workflow.workflowutility.GetImagePropsListResultBean;
import yuyu.common.workflow.workflowutility.GetScanTorikomiSyoruiMstResultBean;
import yuyu.common.workflow.workflowutility.ImagePropsBean;
import yuyu.common.workflow.workflowutility.TorikomiSyoruiMstBean;
import yuyu.common.workflow.workflowutility.WorkFlowResultConstants;
import yuyu.common.workflow.workflowutility.WorkFlowUtility;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_SyoruiTorikomiHouKbn;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.infr.report.PdfUtil;
import yuyu.infr.report.swakreport.ReportRuntimeException;

import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.lowagie.text.pdf.PdfReader;

/**
 * イメージ削除 のビジネスロジックです。
 */
public class ImageSakujyoBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    BaseDomManager baseDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    BaseUserInfo baseUserInfo;

    @Inject
    private ImageSakujyoUiBean uiBean;

    @Inject
    WorkflowDomManager workflowDomManager;

    void init() {
        clear();
        BizPropertyInitializer.initialize(uiBean);


        WfUserSelectCommon wfUserSelectCommon = SWAKInjector.getInstance(WfUserSelectCommon.class);
        GetExecutableSubSystemsSelectInBean getExecutableSubSystemsSelectInBean = SWAKInjector.getInstance(GetExecutableSubSystemsSelectInBean.class);

        getExecutableSubSystemsSelectInBean.setUserId(baseUserInfo.getUserId());
        getExecutableSubSystemsSelectInBean.setBlankUmu(true);
        GetExecutableSubSystemsSelectOutBean getExecutableSubSystemsSelectOutBean = wfUserSelectCommon.getExecutableSubSystemsSelectList(getExecutableSubSystemsSelectInBean);
        uiBean.setSubSystemIdOptionBeanList(getExecutableSubSystemsSelectOutBean.getUserDefsList());

        String[] pSubSystemId = getExecutableSubSystemsSelectOutBean.getSubSystemIdNameArray();
        if(pSubSystemId.length ==0) {
            return;
        }

        uiBean.setJimutetuzukicdOptionBeanList(
            insertBlank(
                Iterables.transform(
                    workflowDomManager.getJimutetuzukisBySubSystemIdsSyukouteijimutetuzukicd(pSubSystemId)
                    ,
                    new Function<DM_Jimutetuzuki, LabelValuePair>() {
                        @Override
                        public LabelValuePair apply(DM_Jimutetuzuki jimutetuzuki) {
                            return new LabelValuePair(
                                jimutetuzuki.getJimutetuzukinm(),
                                jimutetuzuki.getSubSystemId() + "." +
                                jimutetuzuki.getJimutetuzukicd()
                                );
                        }
                    }
                    )
                )
            );

        String wkJimutetuzuki = null;
        GetScanTorikomiSyoruiMstResultBean result = WorkFlowUtility.getScanTorikomiSyoruiMst(wkJimutetuzuki);

        if (!WorkFlowResultConstants.RESULT_OK.equals(result.getSyorikekkaStatus())) {
            throw new BizAppException(MessageId.EAS0037);
        }

        List<TorikomiSyoruiMstBean> syoruiList = result.getTorikomiSyoruiMstBeanList();

        List<LabelValuePair> t = new ArrayList<LabelValuePair>();
        for (Iterator<TorikomiSyoruiMstBean> i = syoruiList.iterator(); i.hasNext();) {
            TorikomiSyoruiMstBean listData =i.next();
            t.add(new LabelValuePair(listData.getSyoruiNm(),
                listData.getSubsystemId() + "." +
                    listData.getSyoruiCd()));
        }

        Iterator<LabelValuePair> itrList = t.iterator();

        UserDefsList list = new UserDefsList();
        list.addAll(
            ImmutableList.<LabelValuePair>builder()
            .add(
                new LabelValuePair(
                    TorikomiHyousiSakuseiConstants.BLANK,
                    TorikomiHyousiSakuseiConstants.BLANK
                    )
                )
                .addAll(itrList)
                .build()
            );

        uiBean.setTorikomiSyoruiCdOptionBeanList(list);
    }

    void clear() {
        uiBean.setSubSystemId(null);
        uiBean.setJimutetuzukicd(null);
        uiBean.setMosno(null);
        uiBean.setSyono(null);
        uiBean.setNksysyno(null);
        uiBean.setSyoruittykymdfrom(null);
        uiBean.setSyoruittykymdto(null);
        uiBean.setKouteikanristatus(null);
        uiBean.setTorikomiSyoruiCd(null);

        uiBean.clearSubSystemIdOptionBeanList();
        uiBean.clearJimutetuzukicdOptionBeanList();
        uiBean.clearTorikomiSyoruiCdOptionBeanList();

        uiBean.getAnkenListDataSource().setDatas(null);
    }

    void searchBtnOnClick() {


        final String subSystemId = uiBean.getSubSystemId();
        final String jimutetuzukiCd = uiBean.getJimutetuzukicd();
        final String wkMosno = uiBean.getMosno();
        final String wkSyono = uiBean.getSyono();
        final String wkNksysyno = uiBean.getNksysyno();
        final String wkTorikomiSyoruiCd = uiBean.getTorikomiSyoruiCd();
        final BizDate syoruittykymdfrom = uiBean.getSyoruittykymdfrom();
        final BizDate syoruittykymdto = uiBean.getSyoruittykymdto();
        final C_Kouteikanristatus kouteikanristatus = uiBean.getKouteikanristatus();

        uiBean.setAnkenList(null);

        if(syoruittykymdfrom != null && syoruittykymdto != null){
            if(syoruittykymdfrom.compareTo(syoruittykymdto) > 0){
                throw new BizLogicException(MessageId.EDF0003,
                    new Item[]{DDID_SEARCHINFO_SYORUITTYKYMDFROM,
                    DDID_SEARCHINFO_SYORUITTYKYMDTO},
                    "書類到着日" );
            }
        }

        SimpleDateFormat sdf_01 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String syoruittykymdfromString = null;
        String syoruittykymdtoString = null;

        if ( syoruittykymdfrom != null ) {
            Date dateSyoruittykymdfrom = syoruittykymdfrom.toDate();
            syoruittykymdfromString = sdf_01.format(dateSyoruittykymdfrom);
        }
        if ( syoruittykymdto != null ) {
            Date dateSyoruittykymdto = syoruittykymdto.toDate();
            syoruittykymdtoString = sdf_01.format(dateSyoruittykymdto).substring(0, 8).concat("235959999");
        }

        String syoriStatus = null;
        if(!"0".equals(kouteikanristatus.getValue())){
            syoriStatus = kouteikanristatus.getValue();
        }

        ArrayList<String> wkArrayjimutetuzukiCd = new ArrayList<String>();

        if (Strings.isNullOrEmpty(jimutetuzukiCd)) {
            UserDefsList wkjimuList = uiBean.getJimutetuzukicdOptionBeanList();

            for (int i=0 ; i < wkjimuList.size() ; i++) {
                if (!Strings.isNullOrEmpty(wkjimuList.get(i).getValue())) {
                    int index = wkjimuList.get(i).getValue().indexOf(".");
                    String subsys = wkjimuList.get(i).getValue().substring(0, index);
                    if (subSystemId.equals(subsys)) {
                        wkArrayjimutetuzukiCd.add(wkjimuList.get(i).getValue().substring(
                            wkjimuList.get(i).getValue().lastIndexOf(ImageSakujyoConstants.SPLITTER) + 1));

                    }
                }
            }
        } else {
            wkArrayjimutetuzukiCd.add(jimutetuzukiCd.substring(
                jimutetuzukiCd.lastIndexOf(ImageSakujyoConstants.SPLITTER) + 1));
        }

        String[] wkjimutetuzukiCd = wkArrayjimutetuzukiCd.toArray(new String[wkArrayjimutetuzukiCd.size()]);

        String torikomiSyoruiCd = null;
        if (!Strings.isNullOrEmpty(wkTorikomiSyoruiCd)) {
            torikomiSyoruiCd = wkTorikomiSyoruiCd.substring(
                wkTorikomiSyoruiCd.lastIndexOf(ImageSakujyoConstants.SPLITTER) + 1);
        }


        GetImagePropsListResultBean result01 = new GetImagePropsListResultBean();

        if (uiBean.getSubSystemId().equals(E_SubSystem.NENKINSIHARAI.getName())) {
            result01 = WorkFlowUtility.getImagePropsList(
                subSystemId,
                baseUserInfo.getUserId(),
                wkjimutetuzukiCd,
                null,
                null,
                wkNksysyno,
                torikomiSyoruiCd,
                syoruittykymdfromString,
                syoruittykymdtoString,
                syoriStatus);
        } else if (uiBean.getSubSystemId().equals(E_SubSystem.SINKEIYAKU.getName())) {
            result01 = WorkFlowUtility.getImagePropsList(
                subSystemId,
                baseUserInfo.getUserId(),
                wkjimutetuzukiCd,
                wkMosno,
                wkSyono,
                null,
                torikomiSyoruiCd,
                syoruittykymdfromString,
                syoruittykymdtoString,
                syoriStatus);
        } else {
            result01 = WorkFlowUtility.getImagePropsList(
                subSystemId,
                baseUserInfo.getUserId(),
                wkjimutetuzukiCd,
                null,
                wkSyono,
                null,
                torikomiSyoruiCd,
                syoruittykymdfromString,
                syoruittykymdtoString,
                syoriStatus);
        }

        if(!WorkFlowResultConstants.RESULT_OK.equals(result01.getSyorikekkaStatus())){
            if (WorkFlowResultConstants.RESULT_NODATA.equals(result01.getSyorikekkaStatus())) {
                messageManager.addMessageId(MessageId.IAC0021, ImageSakujyoConstants.MESSAGE_IMAGE);
                return;
            }
            else if(ImageSakujyoConstants.MESSAGE_ID.equals(result01.getSyousaiMessageCd())){
                messageManager.addMessageId(MessageId.IBF0024);
                return;
            }
            else{
                throw new BizAppException(MessageId.EAS0037);
            }
        }


        List<AnkenListDataSourceBean> pSyoruiList = new ArrayList<AnkenListDataSourceBean>();

        for (int j = 0 ; j < result01.getImagePropsBeanList().size(); j++) {
            AnkenListDataSourceBean wkAnkenListDataSourceBean = new AnkenListDataSourceBean();

            ImagePropsBean wkImagePropsBean = new ImagePropsBean();
            wkImagePropsBean = result01.getImagePropsBeanList().get(j);

            if (wkImagePropsBean.getSyoruiTorikomiHouKbn().equals(C_SyoruiTorikomiHouKbn.SCAN_QR.getValue())) {
                if (wkImagePropsBean.getJimutetuzukiNm().length() > 10) {
                    wkAnkenListDataSourceBean.setDispjimutetuzukinm(wkImagePropsBean.getJimutetuzukiNm().substring(0, 10));
                } else {
                    wkAnkenListDataSourceBean.setDispjimutetuzukinm(wkImagePropsBean.getJimutetuzukiNm());
                }

                if (uiBean.getSubSystemId().equals(E_SubSystem.NENKINSIHARAI.getName())) {
                    wkAnkenListDataSourceBean.setDispGyoumuKey(wkImagePropsBean.getNkSysyNo());
                } else if (uiBean.getSubSystemId().equals(E_SubSystem.SINKEIYAKU.getName())){
                    wkAnkenListDataSourceBean.setDispGyoumuKey(wkImagePropsBean.getMosNo());
                } else {
                    wkAnkenListDataSourceBean.setDispGyoumuKey(wkImagePropsBean.getSyoNo());
                }

                wkAnkenListDataSourceBean.setDispsyoruinm(wkImagePropsBean.getDispTorikomiSyoruiNm());
                wkAnkenListDataSourceBean.setDispkouteikanristatus(C_Kouteikanristatus.valueOf(wkImagePropsBean.getKouteiStatus()));
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                String resultDate = null;
                try {
                    resultDate = sdf2.format(sdf1.parse(wkImagePropsBean.getSyoruiTtykYmdTime()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                wkAnkenListDataSourceBean.setSyoruittykymdtime(resultDate);
                if (wkImagePropsBean.getKengenUmu().equals("1")) {
                    wkAnkenListDataSourceBean.setHyoujilink(ImageSakujyoConstants.HYOUJI_LINK);
                }
                if (wkImagePropsBean.getKengenUmu().equals("1")) {
                    wkAnkenListDataSourceBean.setSakujyoLink(ImageSakujyoConstants.SAKUJO_LINK);
                }
                wkAnkenListDataSourceBean.setImageId(wkImagePropsBean.getImageId());
                wkAnkenListDataSourceBean.setGyouNo(j);

                pSyoruiList.add(wkAnkenListDataSourceBean);
            }
        }

        if (pSyoruiList.size() == ImageSakujyoConstants.ZERO) {
            messageManager.addMessageId(MessageId.IAC0021, ImageSakujyoConstants.MESSAGE_IMAGE);
            return;
        }

        uiBean.setResultSubSystemId(subSystemId);
        uiBean.setResultSyono(wkSyono);
        uiBean.setResultNksysyno(wkNksysyno);
        uiBean.setResultMosno(wkMosno);

        uiBean.setAnkenList(pSyoruiList);

        if (subSystemId.equals(ImageSakujyoConstants.E_SubSystem.SINKEIYAKU.getName())) {
            uiBean.setGyoumukeylbl(ImageSakujyoConstants.LBL_GYOUMUKEY_SINKEIYAKU);
        }else if (subSystemId.equals(ImageSakujyoConstants.E_SubSystem.KEIYAKUHOZEN.getName())) {
            uiBean.setGyoumukeylbl(ImageSakujyoConstants.LBL_GYOUMUKEY_KEIYAKUHOZEN);
        }else if (subSystemId.equals(ImageSakujyoConstants.E_SubSystem.HOKENKYUHUSIHARAI.getName())) {
            uiBean.setGyoumukeylbl(ImageSakujyoConstants.LBL_GYOUMUKEY_HOKENKYUHUSIHARAI);
        }else {
            uiBean.setGyoumukeylbl(ImageSakujyoConstants.LBL_GYOUMUKEY_NENKINSIHARAI);
        }
    }


    void hyoujilinkOnClick() {

        int selectedIndex = uiBean.getSelectindex();
        String imageid = uiBean.getAnkenListDataSource().getAllData().get(selectedIndex).getImageId();
        String useid = baseUserInfo.getUserId();

        GetImageInfoListResultBean result = new GetImageInfoListResultBean();

        result = WorkFlowUtility.getImage(imageid, useid);

        if (!WorkFlowResultConstants.RESULT_OK.equals(result.getSyorikekkaStatus())) {
            if (WorkFlowResultConstants.RESULT_NODATA.equals(result.getSyorikekkaStatus())) {
                throw new BizLogicException(MessageId.EDF1013);
            }
            throw new BizAppException(MessageId.EAS0037);
        }

        byte[] pdfImage = result.getImageInfoBeanList().get(0).getPdfImage();

        HttpServletResponse response = SWAKInjector.getInstance(HttpServletResponse.class);

        ByteArrayOutputStream oBaos = new ByteArrayOutputStream();
        try{
            PdfReader pr = new PdfReader(pdfImage);
            PdfUtil.encrypt(pr , oBaos);
        }catch (Exception e1) {
            e1.printStackTrace();
            throw new ReportRuntimeException(e1, "EAS0017");
        }

        response.reset();
        response.setContentType("application/pdf");
        response.setContentLength(oBaos.toByteArray().length);

        response.setHeader("Content-Disposition", "inline; filename=\"" + "Syorui" + ".pdf\";");
        try {
            response.getOutputStream().write(oBaos.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
            throw new ReportRuntimeException(e, "EAS0007");
        }
    }


    void sakujyoLinkOnClick() {

        messageManager.addMessageId(MessageId.QAC0010);


        final AnkenListDataSourceBean selectedBean = uiBean.getAnkenListDataSource().getSelectedBean();

        uiBean.setSelectindex(selectedBean.getGyouNo());

        AnkenList2DataSourceBean wkAnkenList2DataSourceBean = new AnkenList2DataSourceBean();

        final String jimutetuzukinm = selectedBean.getDispjimutetuzukinm();
        final String gyoumuKey = selectedBean.getDispGyoumuKey();
        final String syoruinm = selectedBean.getDispsyoruinm();
        final C_Kouteikanristatus kouteikanri = selectedBean.getDispkouteikanristatus();
        final String syoruittykymdtime = selectedBean.getSyoruittykymdtime();
        final String hyoujilink = ImageSakujyoConstants.HYOUJI_LINK;
        final String imageid = selectedBean.getImageId();

        wkAnkenList2DataSourceBean.setDispjimutetuzukinm(jimutetuzukinm);
        wkAnkenList2DataSourceBean.setDispGyoumuKey(gyoumuKey);
        wkAnkenList2DataSourceBean.setDispsyoruinm(syoruinm);
        wkAnkenList2DataSourceBean.setDispkouteikanristatus(kouteikanri);
        wkAnkenList2DataSourceBean.setSyoruittykymdtime(syoruittykymdtime);
        wkAnkenList2DataSourceBean.setHyoujilink(hyoujilink);
        wkAnkenList2DataSourceBean.setImageId(imageid);

        List<AnkenList2DataSourceBean> pAnkenList2 = new ArrayList<AnkenList2DataSourceBean>();
        pAnkenList2.add(wkAnkenList2DataSourceBean);

        String wkSubSystemId = uiBean.getResultSubSystemId();
        uiBean.setSubSystemId(wkSubSystemId);

        uiBean.setKakuteiImageId(imageid);

        uiBean.setAnkenList2(pAnkenList2);

        uiBean.setSyono(uiBean.getResultSyono());
        uiBean.setNksysyno(uiBean.getResultNksysyno());
        uiBean.setMosno(uiBean.getResultMosno());

    }


    @Transactional
    void kakuteiBtnOnClick() {

        messageManager.addMessageId(MessageId.IAC0009);

        final String imageid = uiBean.getKakuteiImageId();
        final String userid = baseUserInfo.getUserId();

        List<AnkenList2DataSourceBean> ankenlist2 = uiBean.getAnkenList2DataSource().getAllData();
        ankenlist2.get(0).setHyoujilink("");
        uiBean.setAnkenList2(ankenlist2);


        DropImageResultBean result = new DropImageResultBean();

        result = WorkFlowUtility.dropImage(imageid, userid);

        if (!WorkFlowResultConstants.RESULT_OK.equals(result.getSyorikekkaStatus())) {
            if(result.getSyousaiMessageCd().equals("IWF3073")){
                throw new BizLogicException(MessageId.EDF1013);
            }
            throw new BizAppException(MessageId.EAS0037);
        }

    }


    private static UserDefsList insertBlank(Iterable<LabelValuePair> optionList) {
        UserDefsList list = new UserDefsList();
        list.addAll(
            ImmutableList.<LabelValuePair>builder()
            .add(
                new LabelValuePair(
                    ImageSakujyoConstants.BLANK,
                    ImageSakujyoConstants.BLANK
                    )
                )
                .addAll(optionList)
                .build()
            );
        return list;
    }
}
