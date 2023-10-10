package yuyu.app.hozen.khozen.khcifcdikkatuhenkoutouroku;

import static yuyu.app.hozen.khozen.khcifcdikkatuhenkoutouroku.GenKhCifcdIkkatuHenkouTourokuConstants.*;
import static yuyu.app.hozen.khozen.khcifcdikkatuhenkoutouroku.KhCifcdIkkatuHenkouTourokuConstants.*;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.bizinfr.exception.ErrorMessageCollector;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.FileEntityManager;
import jp.co.slcs.swak.file.FileEntityManagerFactory;
import jp.co.slcs.swak.file.FileType;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.hozen.khozen.khcifcdikkatuhenkoutouroku.KhCifcdIkkatuHenkouTourokuConstants.E_SyoriKubun;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.hozen.khcommon.KhMessageGroupConstants;
import yuyu.common.sinkeiyaku.skcommon.GetDairitenKobetuJyouhou;
import yuyu.common.sinkeiyaku.skcommon.GetDairitenKobetuJyouhouBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IW_CifcdIktHnkWk;
import yuyu.def.hozen.file.excel.KhCifcdIkkatuHenkouTourokuLayoutFile;
import yuyu.def.hozen.manager.HozenDomManager;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * ＣＩＦコード一括変更登録 のビジネスロジックです。
 */
public class KhCifcdIkkatuHenkouTourokuBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhCifcdIkkatuHenkouTourokuUiBean uiBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private ErrorMessageCollector errorMessageCollector;

    void init() {
        clear();
    }

    void clear() {

    }

    void pushTourokuBL() {

        BizPropertyInitializer.initialize(uiBean);

        if (BizUtil.isBlank(uiBean.getUploadfile().getFileName())) {

            throw new BizLogicException(MessageId.EAC0042, DDID_UPLOADFILEINFO_UPLOADFILE);
        }

        if (uiBean.getUploadfile().getFileSize() <= 0) {
            throw new BizLogicException(MessageId.EAC0001, DDID_UPLOADFILEINFO_UPLOADFILE);
        }

        FileEntityManager fileEntityManager =
            FileEntityManagerFactory.getDefaultFactory().createFileEntityManager(FileType.XLSX);

        List<KhCifcdIkkatuHenkouTourokuLayoutFile> cifcdHenkouDataLst = Lists.newArrayList();

        try {
            cifcdHenkouDataLst = fileEntityManager.read(
                KhCifcdIkkatuHenkouTourokuLayoutFile.class, uiBean.getUploadfile().getInputStream());
        } catch (Exception e) {
            throw new BizLogicException(MessageId.EBA1057);
        }

        if (cifcdHenkouDataLst.size() == 0) {
            throw new BizLogicException(MessageId.EBA0048);
        }

        if (cifcdHenkouDataLst.size() >= 1000) {
            throw new BizLogicException(MessageId.EBA1058, FILE_SEIGEN_KENSUU);
        }

        List<CifCodeHenkouInfoDataSourceBean> cifCodeHenkouInfoDataSourceBeanLst = Lists.newArrayList();

        int renNo = 0;

        for (KhCifcdIkkatuHenkouTourokuLayoutFile cifcdIkkatuHenkouTourokuData : cifcdHenkouDataLst) {

            renNo = renNo + 1;

            CifCodeHenkouInfoDataSourceBean cifCodeHenkouInfoDataSourceBean = SWAKInjector.getInstance(CifCodeHenkouInfoDataSourceBean.class);
            cifCodeHenkouInfoDataSourceBean.setDisprenno3keta(renNo);
            cifCodeHenkouInfoDataSourceBean.setSyono(cifcdIkkatuHenkouTourokuData.getIfeSyono());
            cifCodeHenkouInfoDataSourceBean.setCifcd(cifcdIkkatuHenkouTourokuData.getIfecifcd());

            cifCodeHenkouInfoDataSourceBeanLst.add(cifCodeHenkouInfoDataSourceBean);
        }

        uiBean.setCifCodeHenkouInfo(cifCodeHenkouInfoDataSourceBeanLst);
        uiBean.setSyoriKuben(E_SyoriKubun.TOUROKU);
    }

    void pushSakujyoBL() {

        List<IW_CifcdIktHnkWk> cifcdIktHnkWkLst = hozenDomManager.getAllCifcdIktHnkWk();

        if (cifcdIktHnkWkLst.size() == 0) {

            throw new BizLogicException(MessageId.EBA0048);
        }

        uiBean.setSyoriKuben(E_SyoriKubun.SAKUJYO);

        uiBean.setCifcdIktHnkWkLst(cifcdIktHnkWkLst);

        messageManager.addMessageId(MessageId.QAC0010);

        messageManager.addConversationMessageId(MessageId.IIF1024, String.valueOf(cifcdIktHnkWkLst.size()));
    }

    void pushKakuninBL() {

        int insertCnt = 0;

        int updatetCnt = 0;

        String syono = "";

        List<IW_CifcdIktHnkWk> cifcdIktHnkWkLst = Lists.newArrayList();

        List<String> syonoLst = Lists.newArrayList();

        Map<String, List<Integer>> syonoRennoMap = Maps.newHashMap();

        for (CifCodeHenkouInfoDataSourceBean cifCodeHenkouInfoDataSourceBean : uiBean.getCifCodeHenkouInfoDataSource().getAllData()) {

            syono = cifCodeHenkouInfoDataSourceBean.getSyono();

            List<Integer> rennoLst = syonoRennoMap.get(syono);

            if (rennoLst == null) {

                rennoLst = Lists.newArrayList();

                syonoRennoMap.put(syono, rennoLst);
            }

            rennoLst.add(cifCodeHenkouInfoDataSourceBean.getDisprenno3keta() - 1);

            IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);

            if (kykKihon == null) {

                errorMessageCollector.addMessage(MessageId.EIF1126, cifCodeHenkouInfoDataSourceBean.getDisprenno3keta() - 1, new Item[]{DDID_CIFCODEHENKOUINFO_SYONO}, syono);

                continue;
            }

            List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

            if (kykDairitenLst.size() > 0) {

                BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

                List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(
                    kykDairitenLst.get(0).getDrtencd());

                if (bzGetAgInfoBeanList.size() > 0) {
                    BzGetAgInfoBean bzGetAgInfoBean = bzGetAgInfoBeanList.get(3);

                    String oyadrtenCd = bzGetAgInfoBean.getDrtenCd();

                    GetDairitenKobetuJyouhou getDairitenKobetuJyouhou = SWAKInjector.getInstance(GetDairitenKobetuJyouhou.class);

                    GetDairitenKobetuJyouhouBean getDairitenKobetuJyouhouBean =
                        getDairitenKobetuJyouhou.exec(oyadrtenCd, kykKihon.getMosuketukekbn());

                    if (C_ErrorKbn.OK.eq(getDairitenKobetuJyouhouBean.getErrorKbn())) {

                        if (C_YouhiKbn.YOU.eq(getDairitenKobetuJyouhouBean.getCifCdCheckYouhi())) {

                            if (C_YouhiblnkKbn.YOU.eq(getDairitenKobetuJyouhouBean.getCifCdMaezeroumeYouhi())) {

                                cifCodeHenkouInfoDataSourceBean.setCifcd(Strings.padStart(cifCodeHenkouInfoDataSourceBean.getCifcd(),
                                    getDairitenKobetuJyouhouBean.getCifCdSiteiKetasuu(), '0'));
                            }

                            if (getDairitenKobetuJyouhouBean.getCifCdSiteiKetasuu() != cifCodeHenkouInfoDataSourceBean.getCifcd().length()) {

                                errorMessageCollector.addMessage(MessageId.EBA1059, cifCodeHenkouInfoDataSourceBean.getDisprenno3keta() - 1, new Item[]{DDID_CIFCODEHENKOUINFO_CIFCD});

                                continue;
                            }
                        }
                    }
                }
            }

            IW_CifcdIktHnkWk cifcdIktHnkWk = hozenDomManager.getCifcdIktHnkWk(syono);

            if (cifcdIktHnkWk == null) {

                insertCnt = insertCnt + 1;
            }

            else {
                updatetCnt = updatetCnt + 1;

                cifcdIktHnkWkLst.add(cifcdIktHnkWk);

                syonoLst.add(syono);
            }
        }

        for (Map.Entry<String, List<Integer>> entry : syonoRennoMap.entrySet()) {

            List<Integer> rennoLst = entry.getValue();

            if (rennoLst.size() > 1) {

                for (int iCnt = 0; iCnt < rennoLst.size(); iCnt++) {

                    errorMessageCollector.addMessage(MessageId.EIF1127, rennoLst.get(iCnt), new Item[]{DDID_CIFCODEHENKOUINFO_SYONO}, entry.getKey());
                }
            }
        }

        if (errorMessageCollector.exists()) {

            throw new BizLogicException(errorMessageCollector);
        }


        uiBean.setCifcdIktHnkWkLst(cifcdIktHnkWkLst);

        uiBean.setSyonoLst(syonoLst);

        messageManager.addMessageId(MessageId.QAC0008);

        messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.IIF1023, String.valueOf(insertCnt + updatetCnt),
            String.valueOf(insertCnt), String.valueOf(updatetCnt));
    }

    @Transactional
    void pushKakuteiBL() {

        if (E_SyoriKubun.TOUROKU.equals(uiBean.getSyoriKuben())) {

            String sysDateTime = BizDate.getSysDateTimeMilli();

            List<IW_CifcdIktHnkWk> cifcdIktHnkWkInsertDataLst = Lists.newArrayList();

            List<IW_CifcdIktHnkWk> cifcdIktHnkWkUpdateDataLst = Lists.newArrayList();

            int index = 0;

            String syono = "";

            for (CifCodeHenkouInfoDataSourceBean cifCodeHenkouInfoDataSourceBean : uiBean.getCifCodeHenkouInfoDataSource().getAllData()) {

                syono = cifCodeHenkouInfoDataSourceBean.getSyono();

                if (!uiBean.getSyonoLst().contains(syono)) {

                    IW_CifcdIktHnkWk cifcdIktHnkWk = new IW_CifcdIktHnkWk(syono);

                    cifcdIktHnkWk.setCifcd(cifCodeHenkouInfoDataSourceBean.getCifcd());

                    cifcdIktHnkWk.setGyoumuKousinKinou(kinou.getKinouId());

                    cifcdIktHnkWk.setGyoumuKousinsyaId(baseUserInfo.getUserId());

                    cifcdIktHnkWk.setGyoumuKousinTime(sysDateTime);

                    BizPropertyInitializer.initialize(cifcdIktHnkWk);

                    cifcdIktHnkWkInsertDataLst.add(cifcdIktHnkWk);
                }
                else {
                    IW_CifcdIktHnkWk cifcdIktHnkWk = uiBean.getCifcdIktHnkWkLst().get(index);

                    cifcdIktHnkWk.setCifcd(cifCodeHenkouInfoDataSourceBean.getCifcd());

                    cifcdIktHnkWk.setGyoumuKousinKinou(kinou.getKinouId());

                    cifcdIktHnkWk.setGyoumuKousinsyaId(baseUserInfo.getUserId());

                    cifcdIktHnkWk.setGyoumuKousinTime(sysDateTime);

                    cifcdIktHnkWkUpdateDataLst.add(cifcdIktHnkWk);

                    index = index + 1;
                }
            }

            hozenDomManager.insert(cifcdIktHnkWkInsertDataLst);
            hozenDomManager.update(cifcdIktHnkWkUpdateDataLst);
        }

        else if(E_SyoriKubun.SAKUJYO.equals(uiBean.getSyoriKuben())){

            hozenDomManager.delete(uiBean.getCifcdIktHnkWkLst());
        }

        messageManager.addMessageId(MessageId.IAC0009);
    }

    void pushModoruByConfirmBL() {

        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING1);
    }
}
