package yuyu.app.workflow.imagekanri.qrsealsakusei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.SWAK;
import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.web.message.MessageManager;
import jp.co.slcs.swak.web.ui.DataSource;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.MousikomiNoCheck;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.sinkeiyaku.skcommon.MousikomiNoUtil;
import yuyu.common.sinkeiyaku.skcommon.SkConvKbn;
import yuyu.common.sinkeiyaku.skcommon.SkPreSyoruiTorikomi;
import yuyu.common.workflow.workflowutility.GetScanTorikomiSyoruiMstResultBean;
import yuyu.common.workflow.workflowutility.TorikomiSyoruiMstBean;
import yuyu.common.workflow.workflowutility.WorkFlowResultConstants;
import yuyu.common.workflow.workflowutility.WorkFlowUtility;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.biz.sorter.SortBM_TorikomiSyoruiHukaInfo;
import yuyu.def.classification.C_AisyoumeiChannelKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_OutkeisikiKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyoruiTorikomiHouKbn;
import yuyu.def.classification.C_SyuturyokuKaisiGyouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_TorikomiSyoruiHukaInfo;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.HM_SkHokenSyuruiNo;
import yuyu.def.db.entity.HM_SkHokenSyuruiNoAisyou;
import yuyu.def.db.entity.HT_MosMikakuteiJyouhouKanri;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.workflow.bean.report.QRSealDataSourceBean;
import yuyu.def.workflow.bean.report.TorikomiHyousiDataSourceBean;
import yuyu.infr.file.FileControlManager;
import yuyu.infr.qrcode.CreateQRCode;
import yuyu.infr.qrcode.QRCodeCreateException;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.OutputReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * QRシール用紙作成 のビジネスロジックです。
 */
public class QRSealSakuseiBizLogic {

    @Inject
    private static Logger logger;

    @Inject
    private QRSealSakuseiUiBean uiBean;

    @Inject
    private MessageManager messageManager;

    @Inject
    BizDomManager bizDomManager;

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    BaseUserInfo baseUserInfo;

    @Inject
    private CreateReport createReport;

    @Inject
    private OutputReport outputReport;

    @Inject
    private CreateQRCode createQRCode;

    @Inject
    private AS_Kinou kinou;

    void init() {
        clear();
        BizPropertyInitializer.initialize(uiBean);

        uiBean.setDispsubsystemnm(QRSealSakuseiConstants.SUBSYSTEM_NM);
        uiBean.setDispjimutetuzukinm(QRSealSakuseiConstants.JIMUTETUZUKI_NM);

    }

    void clear() {
        uiBean.setDispsubsystemnm(null);
        uiBean.setDispjimutetuzukinm(null);
        uiBean.setDisphknsyuruinoqrseal(null);
        uiBean.setOutkeisikikbn(null);
        uiBean.setOutkensuu(null);
        uiBean.setSkeijimukbn(null);

        uiBean.setCreateTrikomiyouhyousiFlg(false);

        uiBean.clearDisphknsyuruinoqrsealOptionBeanList();
        uiBean.getInputContentsInfo2DataSource().setDatas(null);
        uiBean.getInputContentsInfo3DataSource().setDatas(null);
        uiBean.getInputContentsInfo4DataSource().setDatas(null);
    }

    void nyrykKoumokuSettei() {
        logger.info("QRシール用紙作成機能 入力項目設定処理を起動しました。");
        C_OutkeisikiKbn wkOutkeisiki = uiBean.getOutkeisikikbn();
        String wkJimutetuzuki = QRSealSakuseiConstants.JIMUTETUZUKI_CD;

        uiBean.clearDisphknsyuruinoqrsealOptionBeanList();
        if (wkOutkeisiki.equals(C_OutkeisikiKbn.KENSUU)) {
            List<HM_SkHokenSyuruiNo> skHokenSyuruiNoLst =
                sinkeiyakuDomManager.getSkHokenSyuruiNosBySysdate(BizDate.getSysDate());

            List<LabelValuePair> labelList = new ArrayList<LabelValuePair>();

            for (int i = 0; i < skHokenSyuruiNoLst.size(); i++) {
                labelList.add(new LabelValuePair(
                    skHokenSyuruiNoLst.get(i).getHknsyuruinmsyanaidisp(),
                    skHokenSyuruiNoLst.get(i).getHknsyuruino().getValue()));
            }

            UserDefsList syouhinlist = new UserDefsList();
            syouhinlist.addAll(
                ImmutableList.<LabelValuePair> builder()
                .add(
                    new LabelValuePair(
                        QRSealSakuseiConstants.BLANK,
                        QRSealSakuseiConstants.BLANK
                        )
                    )
                    .addAll(labelList.iterator())
                    .build()
                );
            uiBean.setDisphknsyuruinoqrsealOptionBeanList(syouhinlist);

        } else if (wkOutkeisiki.equals(C_OutkeisikiKbn.MOSNO)) {


            List<InputContentsInfo2DataSourceBean> input2List = new ArrayList<InputContentsInfo2DataSourceBean>();

            for (int i = 0; i < 10; i++) {
                InputContentsInfo2DataSourceBean input2Data = new InputContentsInfo2DataSourceBean();
                input2Data.setMosno1(QRSealSakuseiConstants.BLANK);
                input2Data.setMosno2(QRSealSakuseiConstants.BLANK);
                input2Data.setMosno3(QRSealSakuseiConstants.BLANK);
                input2Data.setLineNum(i);
                input2List.add(input2Data);
            }
            uiBean.setInputContentsInfo2(input2List);

        } else if (wkOutkeisiki.equals(C_OutkeisikiKbn.MOSNOSYORUI)) {


            List<TorikomiSyoruiMstBean> result = callTorikomiSyoruiMst(wkJimutetuzuki);

            List<InputContentsInfo3DataSourceBean> wkInput3List = new ArrayList<InputContentsInfo3DataSourceBean>();

            SortBM_TorikomiSyoruiHukaInfo sortBm_TorikomiSyouiHukaInfo = SWAKInjector
                .getInstance(SortBM_TorikomiSyoruiHukaInfo.class);
            List<BM_TorikomiSyoruiHukaInfo> torikomiSyoruiHukaInfo = bizDomManager
                .getTorikomiSyoruiHukaInfosBySubSystemIdSyoruitorikomihoukbn(
                    QRSealSakuseiConstants.SUBSYSTEM_ID,
                    C_SyoruiTorikomiHouKbn.SCAN_QR);
            List<BM_TorikomiSyoruiHukaInfo> sortedList = sortBm_TorikomiSyouiHukaInfo
                .OrderBM_TorikomiSyoruiHukaInfoBySortNoAsc(torikomiSyoruiHukaInfo);

            List<TorikomiSyoruiMstBean> sortedResult = new ArrayList<>();
            for (BM_TorikomiSyoruiHukaInfo tmpSotedList : sortedList) {
                for (TorikomiSyoruiMstBean tmpResult : result) {
                    if (tmpSotedList.getSyoruiCd().getValue().equals(tmpResult.getSyoruiCd())) {
                        sortedResult.add(tmpResult);
                    }
                }
            }

            for (int i = 0; i < sortedResult.size(); i++) {
                TorikomiSyoruiMstBean listData = sortedResult.get(i);
                UserDefsList syoruimList = new UserDefsList();
                InputContentsInfo3DataSourceBean input3Data = new InputContentsInfo3DataSourceBean();

                if (C_SyoruiCdKbn.SK_IKOUKAKSYO.getValue().equals(listData.getSyoruiCd())) {

                    List<String> torikomiSyoruiCdLst = new ArrayList<String>();
                    torikomiSyoruiCdLst.add(listData.getSyoruiCd());

                    input3Data.setTorikomiSyoruiCd(torikomiSyoruiCdLst);
                }

                syoruimList.add(new LabelValuePair(listData.getSyoruiNm(), listData.getSyoruiCd()));
                input3Data.setRykSyNm(listData.getSyoruiRyakuNm());
                input3Data.setTorikomiSyoruiCdOptionBeanList(syoruimList);
                input3Data.setMosno(QRSealSakuseiConstants.BLANK);
                input3Data.setSakujyoLink(QRSealSakuseiConstants.SAKUJYO_LINK);
                input3Data.setLineNum(i);
                input3Data.setGroupNum(0);
                wkInput3List.add(input3Data);

            }

            uiBean.setInputContentsInfo3(wkInput3List);
            uiBean.setSyrCdSelectData(sortedResult);
            uiBean.setSyrCdSelectNum(Integer.toString(sortedResult.size()));
        }

    }

    void nyrykListDelete() {
        logger.info("QRシール用紙作成機能 入力リスト削除処理を起動しました。");
        List<InputContentsInfo3DataSourceBean> result = uiBean.getInputContentsInfo3DataSource().getDatas();
        InputContentsInfo3DataSourceBean resultData = uiBean.getInputContentsInfo3DataSource().getSelectedBean();

        int wkNum = Integer.parseInt(uiBean.getSyrCdSelectNum());
        int wklineNum = resultData.getLineNum();
        int wkSize = result.size();

        for (int i = 1; i <= wkNum; i++) {
            result.remove(wklineNum);
        }

        if (wkSize != wklineNum) {
            for (int i = 0; i < result.size(); i++) {
                InputContentsInfo3DataSourceBean delData = result.get(i);
                delData.setLineNum(i);

                result.set(i, delData);
            }
        }

        uiBean.setInputContentsInfo3(result);
    }

    void nyrykListAdd() {
        logger.info("QRシール用紙作成機能 入力リスト追加処理を起動しました。");

        List<InputContentsInfo3DataSourceBean> result = uiBean.getInputContentsInfo3DataSource().getAllData();

        List<InputContentsInfo3DataSourceBean> addList = new ArrayList<InputContentsInfo3DataSourceBean>();

        int wkNum = Integer.parseInt(uiBean.getSyrCdSelectNum());
        int wkMaxIndex = result.size() - 1;
        List<TorikomiSyoruiMstBean> syoruiList = uiBean.getSyrCdSelectData();

        if (result.size() == 0) {
            for (int i = 0; i < wkNum; i++) {
                UserDefsList syoruimList = new UserDefsList();

                InputContentsInfo3DataSourceBean input3Data = new InputContentsInfo3DataSourceBean();
                TorikomiSyoruiMstBean syoruiData = syoruiList.get(i);

                if (C_SyoruiCdKbn.SK_IKOUKAKSYO.getValue().equals(syoruiData.getSyoruiCd())) {

                    List<String> torikomiSyoruiCdLst = new ArrayList<String>();
                    torikomiSyoruiCdLst.add(syoruiData.getSyoruiCd());

                    input3Data.setTorikomiSyoruiCd(torikomiSyoruiCdLst);
                }

                syoruimList.add(new LabelValuePair(syoruiData.getSyoruiNm(), syoruiData.getSyoruiCd()));
                input3Data.setRykSyNm(syoruiData.getSyoruiRyakuNm());
                input3Data.setTorikomiSyoruiCdOptionBeanList(syoruimList);
                input3Data.setMosno(QRSealSakuseiConstants.BLANK);
                input3Data.setSakujyoLink(QRSealSakuseiConstants.SAKUJYO_LINK);
                input3Data.setLineNum(i);
                input3Data.setGroupNum(0);
                addList.add(input3Data);
            }
        } else {
            for (int i = 0; i < wkNum; i++) {
                UserDefsList syoruimList = new UserDefsList();

                InputContentsInfo3DataSourceBean input3Data = new InputContentsInfo3DataSourceBean();
                TorikomiSyoruiMstBean syoruiData = syoruiList.get(i);

                if (C_SyoruiCdKbn.SK_IKOUKAKSYO.getValue().equals(syoruiData.getSyoruiCd())) {

                    List<String> torikomiSyoruiCdLst = new ArrayList<String>();
                    torikomiSyoruiCdLst.add(syoruiData.getSyoruiCd());

                    input3Data.setTorikomiSyoruiCd(torikomiSyoruiCdLst);
                }

                syoruimList.add(new LabelValuePair(syoruiData.getSyoruiNm(), syoruiData.getSyoruiCd()));
                input3Data.setRykSyNm(syoruiData.getSyoruiRyakuNm());
                input3Data.setTorikomiSyoruiCdOptionBeanList(syoruimList);
                input3Data.setMosno(QRSealSakuseiConstants.BLANK);
                input3Data.setSakujyoLink(QRSealSakuseiConstants.SAKUJYO_LINK);
                input3Data.setLineNum(result.get(wkMaxIndex).getLineNum() + (i + 1));
                input3Data.setGroupNum(result.get(wkMaxIndex).getGroupNum() + 1);
                addList.add(input3Data);

            }
        }
        result.addAll(addList);
        uiBean.setInputContentsInfo3(result);
    }

    void nyrykNaiyouSettei() {
        logger.info("QRシール用紙作成機能 入力内容設定処理を起動しました。");

        if (uiBean.getOutkeisikikbn().equals(C_OutkeisikiKbn.KENSUU)) {
            qrRequiredCheck(uiBean.getSkeijimukbn(), QRSealSakuseiConstants.DDID_INPUTCONTENTSINFO1_SKEIJIMUKBN);
            qrRequiredCheck(uiBean.getDisphknsyuruinoqrseal(),
                QRSealSakuseiConstants.DDID_INPUTCONTENTSINFO1_DISPHKNSYURUINOQRSEAL);
            qrRequiredCheck(uiBean.getOutkensuu(), QRSealSakuseiConstants.DDID_INPUTCONTENTSINFO1_OUTKENSUU);

            if (uiBean.getOutkensuu().equals(QRSealSakuseiConstants.OUTKENSUU_ZERO)) {
                throw new BizLogicException(MessageId.EAC0006, QRSealSakuseiConstants.DDID_INPUTCONTENTSINFO1_OUTKENSUU);
            }

            SkConvKbn skConvKbn = SWAKInjector.getInstance(SkConvKbn.class);
            C_AisyoumeiChannelKbn wkC_AisyoumeiChannelKbn = skConvKbn.getAisyoumeiChannelKbn(uiBean.getSkeijimukbn());

            List<HM_SkHokenSyuruiNoAisyou> skHokenSyuruiNoAisyouList =
                sinkeiyakuDomManager.getSkHokenSyuruiNoAisyousByHknsyuruinoAisyoumeichannelkbn
                (C_HknsyuruiNo.valueOf(uiBean.getDisphknsyuruinoqrseal()), wkC_AisyoumeiChannelKbn);

            if (skHokenSyuruiNoAisyouList.size() == 0) {
                throw new BizLogicException(MessageId.EDA1003,
                    new Item[]{QRSealSakuseiConstants.DDID_INPUTCONTENTSINFO1_SKEIJIMUKBN,
                    QRSealSakuseiConstants.DDID_INPUTCONTENTSINFO1_DISPHKNSYURUINOQRSEAL},
                    "販売チャネル", "保険種類" );
            }

        } else if (uiBean.getOutkeisikikbn().equals(C_OutkeisikiKbn.MOSNO)) {


            DataSource<InputContentsInfo2DataSourceBean> wkInput2List = uiBean.getInputContentsInfo2DataSource();

            List<InputContentsInfo2DataSourceBean> nyuuryokuListData =
                ImmutableList.copyOf(Iterables.filter(wkInput2List.getDatas(), new SyonoBlankFilter()));
            if (nyuuryokuListData.size() == 0) {
                throw new BizLogicException(MessageId.EAC0006, QRSealSakuseiConstants.DDID_INPUTCONTENTSINFO2_MOSNO1);
            }


            uiBean.setSkeijimuKbnMap(new HashMap<String, C_SkeijimuKbn>());
            uiBean.setHknsyuruiNoMap(new HashMap<String, C_HknsyuruiNo>());
            uiBean.setMosuketukekbnMap(new HashMap<String, C_MosUketukeKbn>());
            uiBean.setDairitencd1Map(new HashMap<String, String>());

            List<InputContentsInfo2DataSourceBean> input2AllList = wkInput2List.getDatas();

            for (int i = 0; i < input2AllList.size(); i++) {
                InputContentsInfo2DataSourceBean input2Data = input2AllList.get(i);
                chkMosNo(input2Data.getMosno1(),
                    new Item[] { QRSealSakuseiConstants.DDID_INPUTCONTENTSINFO2_MOSNO1 }, input2Data.getLineNum());
                chkMosNo(input2Data.getMosno2(),
                    new Item[] { QRSealSakuseiConstants.DDID_INPUTCONTENTSINFO2_MOSNO2 }, input2Data.getLineNum());
                chkMosNo(input2Data.getMosno3(),
                    new Item[] { QRSealSakuseiConstants.DDID_INPUTCONTENTSINFO2_MOSNO3 }, input2Data.getLineNum());

            }

        } else if (uiBean.getOutkeisikikbn().equals(C_OutkeisikiKbn.MOSNOSYORUI)) {


            DataSource<InputContentsInfo3DataSourceBean> input3List = uiBean.getInputContentsInfo3DataSource();

            List<InputContentsInfo3DataSourceBean> wkNyuuryokuListData = input3List.getDatas();

            String wkSyrCdNum = uiBean.getSyrCdSelectNum();
            wkNyuuryokuListData =
                new ArrayList<InputContentsInfo3DataSourceBean>(ImmutableList.copyOf(
                    Iterables.filter(wkNyuuryokuListData, new SyoruiBlankFilter())));
            if (wkNyuuryokuListData.size() == 0) {
                throw new BizLogicException(MessageId.EAC0006, QRSealSakuseiConstants.DDID_INPUTCONTENTSINFO3_MOSNO);
            }

            Boolean check1 = false;
            Boolean check2 = true;
            int syoNoline = 0;
            String wkMosNo = null;
            int wkGroupNum = -1;
            int counter = 0;
            List<InputContentsInfo4DataSourceBean> wkSyonoSetList = new ArrayList<InputContentsInfo4DataSourceBean>();


            uiBean.setSkeijimuKbnMap(new HashMap<String, C_SkeijimuKbn>());
            uiBean.setHknsyuruiNoMap(new HashMap<String, C_HknsyuruiNo>());
            uiBean.setMosuketukekbnMap(new HashMap<String, C_MosUketukeKbn>());
            uiBean.setDairitencd1Map(new HashMap<String, String>());

            for (int i = 0; i < input3List.getDatas().size(); i++) {
                InputContentsInfo3DataSourceBean input3Data = input3List.getDatas().get(i);
                InputContentsInfo4DataSourceBean input4Data = new InputContentsInfo4DataSourceBean();

                List<String> wkSyoruiCd = input3Data.getTorikomiSyoruiCd();
                if (wkGroupNum != input3Data.getGroupNum()) {
                    wkMosNo = input3Data.getMosno();
                    syoNoline = input3Data.getLineNum();
                }

                if (wkMosNo.isEmpty() && wkSyoruiCd != null) {
                    throw new BizLogicException(MessageId.EAC0006, syoNoline,
                        QRSealSakuseiConstants.DDID_INPUTCONTENTSINFO3_MOSNO);
                }

                if (!(wkMosNo.isEmpty()) && wkSyoruiCd != null) {
                    chkMosNo(wkMosNo, new Item[] { QRSealSakuseiConstants.DDID_INPUTCONTENTSINFO3_MOSNO },
                        input3Data.getLineNum());
                }

                if (!(wkMosNo.isEmpty()) && wkSyoruiCd == null) {
                    check1 = true;
                }

                if (!(wkMosNo.isEmpty()) && wkSyoruiCd != null) {
                    check2 = false;
                }

                wkGroupNum = input3Data.getGroupNum();

                input4Data.setMosno(wkMosNo);
                input4Data.setGroupNum(input3Data.getGroupNum());
                if (input3Data.getTorikomiSyoruiCd() != null) {
                    input4Data.setTorikomiSyoruiCd(input3Data.getTorikomiSyoruiCdOptionBeanList().get(0).getLabel());
                }
                input4Data.setLineNum(input3Data.getLineNum());
                input4Data.setRykSyNm(input3Data.getRykSyNm());
                wkSyonoSetList.add(input4Data);

                counter++;

                if ((counter == Integer.parseInt(wkSyrCdNum)) && check1 && check2) {
                    throw new BizLogicException(MessageId.EDF0014, syoNoline,
                        new Item[] { QRSealSakuseiConstants.DDID_INPUTCONTENTSINFO3_MOSNO },
                        QRSealSakuseiConstants.MSG_SYORUI);
                } else if ((counter == Integer.parseInt(wkSyrCdNum))) {
                    counter = 0;
                    check1 = false;
                    check2 = true;
                }
            }

            List<InputContentsInfo4DataSourceBean> input4List = ImmutableList.copyOf(
                Iterables.filter(wkSyonoSetList, new SyoruiNyuuryokuFilter()));


            List<String> cdNumHoji = new ArrayList<String>();
            int count = 0;
            int hojiNum = -1;
            int mapNum = 0;
            List<String> countNum = new ArrayList<String>();
            for (int i = 0; i < input4List.size(); i++) {
                InputContentsInfo4DataSourceBean input4Data = input4List.get(i);

                int groupNum = input4Data.getGroupNum();
                if (hojiNum != groupNum) {
                    hojiNum = groupNum;
                    cdNumHoji.add(input4Data.getMosno());
                }
            }
            Map<Integer, List<String>> syoruiMap = new HashMap<Integer, List<String>>();
            List<String> syoruiNmHoji = new ArrayList<String>();

            if (cdNumHoji.size() > 1) {
                for (int i = 0; i < input4List.size(); i++) {
                    InputContentsInfo4DataSourceBean input4Data = input4List.get(i);
                    int groupNum = input4Data.getGroupNum();

                    if (i == 0) {
                        hojiNum = input4Data.getGroupNum();
                    }

                    if (hojiNum == input4Data.getGroupNum()) {
                        syoruiNmHoji.add(input4Data.getRykSyNm());
                        count++;
                    } else {
                        syoruiMap.put(mapNum, syoruiNmHoji);
                        syoruiNmHoji = new ArrayList<String>();
                        Object obj = count;
                        countNum.add(obj.toString());
                        count = 0;
                        mapNum++;
                        i--;

                    }
                    if (hojiNum != groupNum) {
                        hojiNum = groupNum;
                    }

                    if (i == input4List.size() - 1) {
                        syoruiMap.put(mapNum, syoruiNmHoji);
                        Object obj = count;
                        countNum.add(obj.toString());
                    }
                }
            } else {
                for (int i = 0; i < input4List.size(); i++) {
                    InputContentsInfo4DataSourceBean input3Data = input4List.get(i);

                    syoruiNmHoji.add(input3Data.getRykSyNm());
                    count++;
                    if (i == input4List.size() - 1) {
                        syoruiMap.put(0, syoruiNmHoji);
                        Object obj = count;
                        countNum.add(obj.toString());
                    }
                }
            }

            uiBean.setNyuuryokuMosNo(cdNumHoji);
            uiBean.setNyuuryokuSyNm(syoruiMap);
            uiBean.setCountNum(countNum);
            uiBean.setInputContentsInfo4(input4List);

        }

        messageManager.addMessageId(MessageId.QBA0001);

    }

    @Transactional
    void createTorikomihyousiPre(){
        logger.info("QRシール用紙作成機能 取込用表紙作成前処理を起動しました。");

        uiBean.setCreateTrikomiyouhyousiFlg(true);

        qrPrintOut();

        messageManager.addMessageId(MessageId.IAC0009);
    }

    @Transactional
    void createQRsealPre() {
        logger.info("QRシール用紙作成機能 QRシール用紙作成前処理を起動しました。");

        qrPrintOut();

        messageManager.addMessageId(MessageId.IAC0009);
    }

    void qrPrintOut() {
        logger.info("QRシール用紙作成機能 帳票出力処理を起動しました。");
        String wkSubSystemId = uiBean.getDispsubsystemnm();
        String wkJimutetuzukicd = uiBean.getDispjimutetuzukinm();
        String wkJimutetuzuki = QRSealSakuseiConstants.JIMUTETUZUKI_CD;

        logger.debug("============================================");
        logger.debug("帳票作成処理を実行します。");
        logger.debug(wkSubSystemId);
        logger.debug(wkJimutetuzukicd);
        logger.debug("============================================");


        if (uiBean.getOutkeisikikbn().equals(C_OutkeisikiKbn.KENSUU)) {

            int wkOutKensuu = Integer.parseInt(uiBean.getOutkensuu());

            C_SkeijimuKbn skeiJimuKbnList[] = { C_SkeijimuKbn.BLNK, uiBean.getSkeijimukbn() };
            List<BM_TorikomiSyoruiHukaInfo> torikomiSyoruiHukaInfo = bizDomManager
                .getTorikomiSyoruiHukaInfosBySubSystemIdSyoruitorikomihoukbnQrsealumukbnSkeijimukbns(
                    QRSealSakuseiConstants.SUBSYSTEM_ID,
                    C_SyoruiTorikomiHouKbn.SCAN_QR,
                    C_UmuKbn.ARI,
                    skeiJimuKbnList);

            List<TorikomiSyoruiMstBean> syoruiNm = callTorikomiSyoruiMst(wkJimutetuzuki);

            List<TorikomiSyoruiMstBean> syoruiNameList = new ArrayList<>();

            for (TorikomiSyoruiMstBean tmpSyoruiMstBean : syoruiNm) {
                for (BM_TorikomiSyoruiHukaInfo tmptmptorikomiSyoruiHukaInfo : torikomiSyoruiHukaInfo) {
                    if (tmpSyoruiMstBean.getSyoruiCd().equals(tmptmptorikomiSyoruiHukaInfo.getSyoruiCd().getValue())) {
                        syoruiNameList.add(tmpSyoruiMstBean);
                        break;
                    }
                }
            }

            C_SyoruiCdKbn[] syoruiCd = null;
            if (torikomiSyoruiHukaInfo.size() % 14 != 0) {
                syoruiCd = new C_SyoruiCdKbn[torikomiSyoruiHukaInfo.size() + 14 - (torikomiSyoruiHukaInfo.size() % 14)];
            } else {
                syoruiCd = new C_SyoruiCdKbn[torikomiSyoruiHukaInfo.size()];
            }
            MousikomiNoUtil mousikomiNoUtil = SWAKInjector.getInstance(MousikomiNoUtil.class);
            SkPreSyoruiTorikomi skPreSyoruiTorikomi = SWAKInjector.getInstance(SkPreSyoruiTorikomi.class);
            List<QRSealDataSourceBean> inputList = new ArrayList<QRSealDataSourceBean>();

            if (!uiBean.isCreateTrikomiyouhyousiFlg()) {

                if (!C_SyuturyokuKaisiGyouKbn.ITIGYOUME.eq(uiBean.getSyuturyokukaisigyoukbn())) {

                    int outKensuu = (Integer.parseInt(uiBean.getSyuturyokukaisigyoukbn().getValue()) - 1) * 7;

                    for (int i = 0; i < outKensuu; i++) {

                        QRSealDataSourceBean inputData = SWAKInjector.getInstance(QRSealDataSourceBean.class);

                        inputData.setQrcodedata(null);
                        inputData.setSyoruinmryaku("");
                        inputData.setMosno("");
                        inputData.setWorkflowDocumentId("");

                        inputList.add(inputData);
                    }
                }
            }

            for (int i = 0; i < torikomiSyoruiHukaInfo.size(); i++) {
                syoruiCd[i] = torikomiSyoruiHukaInfo.get(i).getSyoruiCd();
            }

            if (torikomiSyoruiHukaInfo.size() % 14 != 0) {
                for (int i = 0; i < 14 - (torikomiSyoruiHukaInfo.size() % 14); i++) {
                    syoruiCd[i + torikomiSyoruiHukaInfo.size()] = C_SyoruiCdKbn.SK_SONOTAHUZOKU;
                }
            }

            for (int i = 0; i < wkOutKensuu; i++) {
                String mosNo = mousikomiNoUtil.getMosNo(uiBean.getSkeijimukbn(), C_MosUketukeKbn.MOSKIT,
                    baseUserInfo.getUserId());
                String[] qrCd = skPreSyoruiTorikomi.sinkykSyoruiTorikomi(mosNo, syoruiCd, uiBean.getSkeijimukbn(),
                    C_HknsyuruiNo.valueOf(uiBean.getDisphknsyuruinoqrseal()), C_MosUketukeKbn.MOSKIT, null);

                for (int j = 0; j < qrCd.length; j++) {

                    QRSealDataSourceBean inputData = SWAKInjector.getInstance(QRSealDataSourceBean.class);
                    String syoruiName = "";

                    byte[] qrBytes = makeQRCodeImg(qrCd[j]);

                    for (TorikomiSyoruiMstBean tmpSyoruiNameList : syoruiNameList) {
                        if (tmpSyoruiNameList.getSyoruiCd().equals(syoruiCd[j].getValue())) {
                            syoruiName = tmpSyoruiNameList.getSyoruiRyakuNm();
                            break;
                        }
                    }

                    inputData.setQrcodedata(qrBytes);
                    inputData.setSyoruinmryaku(syoruiName);
                    inputData.setMosno(mosNo);
                    inputData.setWorkflowDocumentId(qrCd[j]);

                    inputList.add(inputData);

                    String qrFileNm = "barcode_" + qrCd[j] + ".gif" ;
                    uiBean.setQrFileNmList(qrFileNm);

                }

            }

            printOut(createReport, inputList);

        } else if (uiBean.getOutkeisikikbn().equals(C_OutkeisikiKbn.MOSNO)) {


            DataSource<InputContentsInfo2DataSourceBean> input2List = uiBean.getInputContentsInfo2DataSource();

            List<InputContentsInfo2DataSourceBean> nyuuryokuListData =
                ImmutableList.copyOf(Iterables.filter(input2List.getDatas(), new SyonoBlankFilter()));

            List<TorikomiSyoruiMstBean> syoruiNm = callTorikomiSyoruiMst(wkJimutetuzuki);

            SkPreSyoruiTorikomi skPreSyoruiTorikomi = SWAKInjector.getInstance(SkPreSyoruiTorikomi.class);
            List<QRSealDataSourceBean> inputList = new ArrayList<QRSealDataSourceBean>();

            if (!uiBean.isCreateTrikomiyouhyousiFlg()) {

                if (!C_SyuturyokuKaisiGyouKbn.ITIGYOUME.eq(uiBean.getSyuturyokukaisigyoukbn())) {

                    int outKensuu = (Integer.parseInt(uiBean.getSyuturyokukaisigyoukbn().getValue()) - 1) * 7;

                    for (int i = 0; i < outKensuu; i++) {

                        QRSealDataSourceBean inputData = SWAKInjector.getInstance(QRSealDataSourceBean.class);

                        inputData.setQrcodedata(null);
                        inputData.setSyoruinmryaku("");
                        inputData.setMosno("");
                        inputData.setWorkflowDocumentId("");

                        inputList.add(inputData);
                    }
                }
            }

            List<String> syonoList = new ArrayList<String>();
            for (int i = 0; i < nyuuryokuListData.size(); i++) {
                InputContentsInfo2DataSourceBean input2Data = nyuuryokuListData.get(i);
                if (!Strings.isNullOrEmpty(input2Data.getMosno1())) {
                    syonoList.add(input2Data.getMosno1());
                }
                if (!Strings.isNullOrEmpty(input2Data.getMosno2())) {
                    syonoList.add(input2Data.getMosno2());
                }
                if (!Strings.isNullOrEmpty(input2Data.getMosno3())) {
                    syonoList.add(input2Data.getMosno3());
                }
            }

            for (int i = 0; i < syonoList.size(); i++) {

                C_SkeijimuKbn skeiJimuKbnList[] = { C_SkeijimuKbn.BLNK,
                    uiBean.getSkeijimuKbnMap().get(syonoList.get(i)) };
                List<BM_TorikomiSyoruiHukaInfo> torikomiSyoruiHukaInfo = bizDomManager
                    .getTorikomiSyoruiHukaInfosBySubSystemIdSyoruitorikomihoukbnQrsealumukbnSkeijimukbns(
                        QRSealSakuseiConstants.SUBSYSTEM_ID,
                        C_SyoruiTorikomiHouKbn.SCAN_QR,
                        C_UmuKbn.ARI,
                        skeiJimuKbnList);
                List<TorikomiSyoruiMstBean> syoruiNameList = new ArrayList<>();
                for (TorikomiSyoruiMstBean tmpSyoruiMstBean : syoruiNm) {
                    for (BM_TorikomiSyoruiHukaInfo tmptmptorikomiSyoruiHukaInfo : torikomiSyoruiHukaInfo) {
                        if (tmpSyoruiMstBean.getSyoruiCd()
                            .equals(tmptmptorikomiSyoruiHukaInfo.getSyoruiCd().getValue())) {
                            syoruiNameList.add(tmpSyoruiMstBean);
                            break;
                        }
                    }
                }

                C_SyoruiCdKbn[] syoruiCd = null;
                if (torikomiSyoruiHukaInfo.size() % 14 != 0) {
                    syoruiCd = new C_SyoruiCdKbn[torikomiSyoruiHukaInfo.size() + 14
                                                 - (torikomiSyoruiHukaInfo.size() % 14)];
                } else {
                    syoruiCd = new C_SyoruiCdKbn[torikomiSyoruiHukaInfo.size()];
                }

                for (int j = 0; j < torikomiSyoruiHukaInfo.size(); j++) {
                    syoruiCd[j] = torikomiSyoruiHukaInfo.get(j).getSyoruiCd();
                }

                if (torikomiSyoruiHukaInfo.size() % 14 != 0) {
                    for (int j = 0; j < 14 - (torikomiSyoruiHukaInfo.size() % 14); j++) {
                        syoruiCd[j + torikomiSyoruiHukaInfo.size()] = C_SyoruiCdKbn.SK_SONOTAHUZOKU;
                    }
                }

                String[] qrCd = skPreSyoruiTorikomi.sinkykSyoruiTorikomi(syonoList.get(i), syoruiCd,
                    uiBean.getSkeijimuKbnMap().get(syonoList.get(i)),
                    uiBean.getHknsyuruiNoMap().get(syonoList.get(i)),
                    uiBean.getMosuketukekbnMap().get(syonoList.get(i)),
                    uiBean.getDairitencd1Map().get(syonoList.get(i)));

                for (int j = 0; j < qrCd.length; j++) {

                    QRSealDataSourceBean inputData = SWAKInjector.getInstance(QRSealDataSourceBean.class);
                    String syoruiName = "";

                    byte[] qrBytes = makeQRCodeImg(qrCd[j]);

                    for (TorikomiSyoruiMstBean tmpSyoruiNameList : syoruiNameList) {
                        if (tmpSyoruiNameList.getSyoruiCd().equals(syoruiCd[j].getValue())) {
                            syoruiName = tmpSyoruiNameList.getSyoruiRyakuNm();
                            break;
                        }
                    }

                    inputData.setQrcodedata(qrBytes);
                    inputData.setSyoruinmryaku(syoruiName);
                    inputData.setMosno(syonoList.get(i));
                    inputData.setWorkflowDocumentId(qrCd[j]);

                    inputList.add(inputData);

                    String qrFileNm = "barcode_" + qrCd[j] + ".gif" ;
                    uiBean.setQrFileNmList(qrFileNm);

                }
            }
            printOut(createReport, inputList);

        } else if (uiBean.getOutkeisikikbn().equals(C_OutkeisikiKbn.MOSNOSYORUI)) {


            List<String> cdNumHoji = uiBean.getNyuuryokuMosNo();

            Map<Integer, List<String>> syoruiMap = uiBean.getNyuuryokuSyNm();

            List<TorikomiSyoruiMstBean> syrCdSelectData = uiBean.getSyrCdSelectData();

            SkPreSyoruiTorikomi skPreSyoruiTorikomi = SWAKInjector.getInstance(SkPreSyoruiTorikomi.class);

            List<QRSealDataSourceBean> inputList = new ArrayList<QRSealDataSourceBean>();

            if (!uiBean.isCreateTrikomiyouhyousiFlg()) {

                if (!C_SyuturyokuKaisiGyouKbn.ITIGYOUME.eq(uiBean.getSyuturyokukaisigyoukbn())) {

                    int outKensuu = (Integer.parseInt(uiBean.getSyuturyokukaisigyoukbn().getValue()) - 1) * 7;

                    for (int i = 0; i < outKensuu; i++) {

                        QRSealDataSourceBean inputData = SWAKInjector.getInstance(QRSealDataSourceBean.class);

                        inputData.setQrcodedata(null);
                        inputData.setSyoruinmryaku("");
                        inputData.setMosno("");
                        inputData.setWorkflowDocumentId("");

                        inputList.add(inputData);
                    }
                }
            }

            for (int i = 0; i < cdNumHoji.size(); i++) {

                List<String> ryakuSy = syoruiMap.get(i);

                C_SyoruiCdKbn[] syoruiCd = new C_SyoruiCdKbn[ryakuSy.size()];
                for (int x = 0; x < ryakuSy.size(); x++) {
                    for (TorikomiSyoruiMstBean tmpSyrCdSelectData : syrCdSelectData) {
                        if (tmpSyrCdSelectData.getSyoruiRyakuNm().equals(ryakuSy.get(x))) {
                            syoruiCd[x] = C_SyoruiCdKbn.valueOf(tmpSyrCdSelectData.getSyoruiCd());
                        }
                    }
                }

                String[] qrCd = skPreSyoruiTorikomi.sinkykSyoruiTorikomi(cdNumHoji.get(i), syoruiCd,
                    uiBean.getSkeijimuKbnMap().get(cdNumHoji.get(i)),
                    uiBean.getHknsyuruiNoMap().get(cdNumHoji.get(i)),
                    uiBean.getMosuketukekbnMap().get(cdNumHoji.get(i)),
                    uiBean.getDairitencd1Map().get(cdNumHoji.get(i)));

                for (int j = 0; j < qrCd.length; j++) {

                    QRSealDataSourceBean inputData = SWAKInjector.getInstance(QRSealDataSourceBean.class);

                    byte[] qrBytes = makeQRCodeImg(qrCd[j]);

                    inputData.setQrcodedata(qrBytes);
                    inputData.setSyoruinmryaku(ryakuSy.get(j));
                    inputData.setMosno(cdNumHoji.get(i));
                    inputData.setWorkflowDocumentId(qrCd[j]);

                    inputList.add(inputData);

                    String qrFileNm = "barcode_" + qrCd[j] + ".gif" ;
                    uiBean.setQrFileNmList(qrFileNm);

                }
            }
            printOut(createReport, inputList);

        }
    }

    public void resetInitUiBean() {
        uiBean.setSkeijimukbn(C_SkeijimuKbn.BLNK);
        uiBean.setDisphknsyuruinoqrseal(QRSealSakuseiConstants.BLANK);
        uiBean.setOutkensuu(QRSealSakuseiConstants.BLANK);

        uiBean.clearDisphknsyuruinoqrsealOptionBeanList();

        uiBean.getInputContentsInfo2DataSource().setDatas(null);
        uiBean.getInputContentsInfo3DataSource().setDatas(null);
        uiBean.getInputContentsInfo4DataSource().setDatas(null);

        if (uiBean.getSkeijimuKbnMap() != null) {
            uiBean.getSkeijimuKbnMap().clear();
        }
        if (uiBean.getHknsyuruiNoMap() != null) {
            uiBean.getHknsyuruiNoMap().clear();
        }
        if (uiBean.getMosuketukekbnMap() != null) {
            uiBean.getMosuketukekbnMap().clear();
        }
        if (uiBean.getDairitencd1Map() != null) {
            uiBean.getDairitencd1Map().clear();
        }

        if (uiBean.getSyrCdSelectData() != null) {
            uiBean.getSyrCdSelectData().clear();
        }
        if (uiBean.getNyuuryokuMosNo() != null) {
            uiBean.getNyuuryokuMosNo().clear();
        }
        if (uiBean.getNyuuryokuSyNm() != null) {
            uiBean.getNyuuryokuSyNm().clear();
        }
        if (uiBean.getCountNum() != null) {
            uiBean.getCountNum().clear();
        }
        uiBean.setSyrCdSelectNum(QRSealSakuseiConstants.BLANK);
    }


    private static void qrRequiredCheck(Object column, Item item) {
        if (column.toString().equals(QRSealSakuseiConstants.BLANK)) {
            throw new BizLogicException(MessageId.EAC0042, item);
        } else if (column.toString().equals(QRSealSakuseiConstants.KBN_BLANK)) {
            throw new BizLogicException(MessageId.EAC0042, item);
        }
    }

    private static List<TorikomiSyoruiMstBean> callTorikomiSyoruiMst(String pJimutetuzukiCd) {

        GetScanTorikomiSyoruiMstResultBean result = WorkFlowUtility.getScanTorikomiSyoruiMst(pJimutetuzukiCd);
        if (!(result.getSyorikekkaStatus().equals(WorkFlowResultConstants.RESULT_OK))) {

            logger.error("ワークフロー呼出Utility#取込書類マスタ取得");
            logger.error("エラーコード" + result.getSyousaiMessageCd());
            logger.error("エラーメッセージ" + result.getSyousaiMessage());
            throw new BizAppException(MessageId.EAS0037);
        }

        return result.getTorikomiSyoruiMstBeanList();
    }

    private void chkMosNo(String pMosNo, Item[] item, int lineNum) {

        if (pMosNo.isEmpty()) {
            return;
        }

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        if (!MousikomiNoCheck.ifExistMousikomiNo(pMosNo)) {
            throw new BizLogicException(MessageId.EDA1002, lineNum, item, pMosNo);
        }
        List<BT_GyoumuKouteiInfo> gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfosByMosno(pMosNo);

        if (gyoumuKouteiInfo != null && gyoumuKouteiInfo.size() > 0) {
            bzGetProcessSummaryInBean.setKouteiKanriId(gyoumuKouteiInfo.get(0).getKouteikanriid());
            List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBean = bzGetProcessSummary
                .exec(bzGetProcessSummaryInBean);

            if (bzGetProcessSummaryOutBean != null && bzGetProcessSummaryOutBean.size() > 0) {
                uiBean.getSkeijimuKbnMap().put(pMosNo, bzGetProcessSummaryOutBean.get(0).getSkeijimuKbn());
                uiBean.getHknsyuruiNoMap().put(pMosNo, bzGetProcessSummaryOutBean.get(0).getHknsyuruiNo());
                uiBean.getMosuketukekbnMap().put(pMosNo, bzGetProcessSummaryOutBean.get(0).getMosUketukeKbn());
                uiBean.getDairitencd1Map().put(pMosNo, bzGetProcessSummaryOutBean.get(0).getDairitencd1());
            }
        } else {
            HT_MosMikakuteiJyouhouKanri mosMikakuteiJyouhouKanri = sinkeiyakuDomManager
                .getMosMikakuteiJyouhouKanri(pMosNo);
            if (mosMikakuteiJyouhouKanri != null) {

                uiBean.getSkeijimuKbnMap().put(pMosNo, mosMikakuteiJyouhouKanri.getSkeijimukbn());
                uiBean.getHknsyuruiNoMap().put(pMosNo, mosMikakuteiJyouhouKanri.getHknsyuruino());
                uiBean.getMosuketukekbnMap().put(pMosNo, mosMikakuteiJyouhouKanri.getMosuketukekbn());
                uiBean.getDairitencd1Map().put(pMosNo, mosMikakuteiJyouhouKanri.getDairitencd1());

            } else {
                throw new BizLogicException(MessageId.EDA1002, lineNum, item, pMosNo);
            }

        }

    }

    private void printOut(CreateReport cr, List<QRSealDataSourceBean> pQRList) {

        logger.info("QRシール用紙作成機能 帳票出力処理を起動しました。");

        if(uiBean.isCreateTrikomiyouhyousiFlg()){
            logger.info("取込用表紙を作成します。");

            String wkJimutetuzukicd = uiBean.getDispjimutetuzukinm();
            String wkSubSystemNm = QRSealSakuseiConstants.SUBSYSTEM_NM;

            String wkUserName = baseUserInfo.getUserNm();

            List<ReportServicesBean> wkReportServicesBeanList = new ArrayList<ReportServicesBean>();


            for(QRSealDataSourceBean wk :pQRList){

                List<IReportDataSouceBean> wkReportDataSouceBeanList = new ArrayList<IReportDataSouceBean>();

                ReportServicesBean wkReportServicesBean = cr.createNewReportServiceBean(
                    kinou.getSubSystemId(),
                    kinou.getCategoryId(),
                    QRSealSakuseiConstants.KINOU_ID_TORIKOMIYOU,
                    C_SyoruiCdKbn.WF_HYOUSI);

                TorikomiHyousiDataSourceBean torikomiHyousiDataSourceBean = new TorikomiHyousiDataSourceBean();
                torikomiHyousiDataSourceBean.setSousasyanm(wkUserName);
                torikomiHyousiDataSourceBean.setSubSystemNm(wkSubSystemNm);
                torikomiHyousiDataSourceBean.setJimutetuzukinm(wkJimutetuzukicd);
                torikomiHyousiDataSourceBean.setMosno(wk.getMosno());
                torikomiHyousiDataSourceBean.setSyono(QRSealSakuseiConstants.BLANK);
                torikomiHyousiDataSourceBean.setNksysyno(QRSealSakuseiConstants.BLANK);
                torikomiHyousiDataSourceBean.setSyoruinm(wk.getSyoruinmryaku());
                torikomiHyousiDataSourceBean.setWorkflowDocumentId(wk.getWorkflowDocumentId());
                torikomiHyousiDataSourceBean.setRSakuseiYmd(BizDate.getSysDateTime());

                wkReportDataSouceBeanList.add(torikomiHyousiDataSourceBean);

                wkReportServicesBean.setQrCode(wk.getWorkflowDocumentId());

                wkReportServicesBean.addParamObjects(wkReportDataSouceBeanList);

                wkReportServicesBeanList.add(wkReportServicesBean);
            }

            String tyouhyouKey = cr.execNoCommit(wkReportServicesBeanList);

            logger.debug("取得した帳票結合キー");
            logger.debug(tyouhyouKey);

            uiBean.setReportKey(tyouhyouKey);


        }else{
            logger.info("QR用シール用紙を作成します。");

            ReportServicesBean rsBean = cr.createNewReportServiceBean(
                kinou.getSubSystemId(),
                kinou.getCategoryId(),
                QRSealSakuseiConstants.KINOU_ID,
                C_SyoruiCdKbn.WF_QRSEAL);

            rsBean.setKensakuKeys(new String[] { BizDate.getSysDateTime() });
            List<IReportDataSouceBean> rdsBeanList = new ArrayList<IReportDataSouceBean>();

            rdsBeanList.addAll(pQRList);

            rsBean.addParamObjects(rdsBeanList);

            String tyouhyouKey = cr.execNoCommit(rsBean);
            logger.debug("取得した帳票キー");
            logger.debug(tyouhyouKey);

            uiBean.setReportKey(tyouhyouKey);
        }

    }

    void printReport() {
        if (uiBean.isCreateTrikomiyouhyousiFlg()) {
            outputReport.outputPDFWithDelByJoinKey(uiBean.getReportKey());

        } else{
            outputReport.outputPDFWithDel(uiBean.getReportKey());
            delQRCodeImg();
        }

        uiBean.setCreateTrikomiyouhyousiFlg(false);
    }

    private void delQRCodeImg() {

        List<String> wkQrFileNmList = uiBean.getQrFileNmList();
        FileControlManager fileControlManager = SWAKInjector.getInstance(FileControlManager.class);
        String qrFileDirPath = SWAK.getApplicationRootPath() + QRSealSakuseiConstants.QR_FILE_DIR_PATH;

        if (wkQrFileNmList != null && wkQrFileNmList.size() != 0) {
            for (int i = 0; i < wkQrFileNmList.size(); i++) {

                try {
                    String qrFileFullPath = qrFileDirPath + wkQrFileNmList.get(i);
                    fileControlManager.remove(qrFileFullPath);

                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error("QRコード画像の削除に失敗しました");
                }
            }
        }
    }

    private byte[] makeQRCodeImg(String pQrCd) {

        Map<String, Object> optionsMap = new HashMap<String, Object>();

        logger.info("オプションマップの設定を開始");
        optionsMap.put("Contents", pQrCd);
        optionsMap.put("Width", "140");
        optionsMap.put("Height", "140");
        optionsMap.put("ErrorCorrectionLevel", "H");
        logger.info("オプションマップの設定を終了");

        byte[] qrBytes = null;
        try {
            qrBytes = createQRCode.getQRCodeImgBytes(optionsMap);
        } catch (QRCodeCreateException e) {
            e.printStackTrace();
            throw new BizAppException(e, MessageId.EAS0037);
        }

        return qrBytes;
    }
}
