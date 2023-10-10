package yuyu.app.hozen.khozen.khtoujituonlinetorikesi;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.web.message.MessageManager;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.app.hozen.khozen.khtoujituonlinetorikesi.dba.KhToujituOnlineTorikesiDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bznayose.PALKykKousinTorikesi;
import yuyu.common.biz.kaikei.BzSikinIdouRirekiTblSakujyo;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HT_BAK_SmbcStyKanri;
import yuyu.def.db.entity.HT_SmbcStyKanri;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_BAK_AnsyuKihon;
import yuyu.def.db.entity.IT_BAK_KhDenpyoData;
import yuyu.def.db.entity.IT_BAK_KhDshrTuki;
import yuyu.def.db.entity.IT_BAK_KhFBSoukinData;
import yuyu.def.db.entity.IT_BAK_KhGaikaFBSoukinData;
import yuyu.def.db.entity.IT_BAK_KhHaitouKanri;
import yuyu.def.db.entity.IT_BAK_KhHenkouUktk;
import yuyu.def.db.entity.IT_BAK_KhTumitateDKanri;
import yuyu.def.db.entity.IT_BAK_KykKihon;
import yuyu.def.db.entity.IT_BAK_NyuukinKakusyouData;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.entity.IT_KhDshrTuki;
import yuyu.def.db.entity.IT_KhFBSoukinData;
import yuyu.def.db.entity.IT_KhGaikaFBSoukinData;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KhHenkouUktk;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_NyuukinKakusyouData;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.sorter.SortIT_KhTtdkRireki;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 契約保全当日オンライン取消 のビジネスロジックです。
 */
public class KhToujituOnlineTorikesiBizLogic {

    @Inject
    private KhToujituOnlineTorikesiUiBean uiBean;

    @Inject
    private AS_Kinou kinouTbl;

    @Inject
    private MessageManager messageManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private SortIT_KhTtdkRireki sortITKhTtdkRireki;

    @Inject
    private KhToujituOnlineTorikesiDao khToujituOnlineTorikesiDao;
    void init() {
        BizPropertyInitializer.initialize(uiBean);

        List<AS_Kinou> kinouLst = bizDomManager.getKinousByTjttrkskahiSubSystemIdKinouHukaInfoCategory(
            C_KahiKbn.KA, kinouTbl.getSubSystemId());

        UserDefsList udList = new UserDefsList();

        for (AS_Kinou kinou : kinouLst) {
            LabelValuePair pair = new LabelValuePair();
            pair.setLabel(kinou.getKinouNm());
            pair.setValue(kinou.getKinouId());
            udList.add(pair);
        }
        if (udList.isEmpty()) {
            udList.add(new LabelValuePair("", ""));
        }

        uiBean.setTrkskinouidOptionBeanList(udList);
    }

    void clear() {
    }

    void pushKakunin() {

        String syono = uiBean.getSyono();
        String trksKinouId = uiBean.getTrkskinouid();

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);
        if (kykKihon == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }
        uiBean.setKykKihon(kykKihon);

        List<IT_KhTtdkRireki> khTtdkRirekiLst =
            kykKihon.getKhTtdkRirekisBySyoriYmdGyoumuKousinKinou(BizDate.getSysDate(), trksKinouId);
        List<IT_KhTtdkRireki> sortKhTtdkRirekiLst = new ArrayList<IT_KhTtdkRireki>(khTtdkRirekiLst);
        sortKhTtdkRirekiLst = sortITKhTtdkRireki.OrderIT_KhTtdkRirekiByPkDesc(sortKhTtdkRirekiLst);

        if (sortKhTtdkRirekiLst.isEmpty()) {
            throw new BizLogicException(MessageId.EAC0046, "当日処理");
        }

        if (C_SyoriKbn.MKHGKTTTYENDTHNKTORIKESI.eq(sortKhTtdkRirekiLst.get(0).getSyorikbn())) {
            throw new BizLogicException(MessageId.EIF1094);
        }

        String henkouSikibetukey = sortKhTtdkRirekiLst.get(0).getHenkousikibetukey();

        String gyoumuKousinTime = sortKhTtdkRirekiLst.get(0).getGyoumuKousinTime();

        List<IT_KhTtdkRireki> khTtdkRirekiCountLst = hozenDomManager.getKykKihon(syono).getKhTtdkRirekisByHenkousikibetukey
            (henkouSikibetukey);

        if (khTtdkRirekiCountLst.size() > 0) {
            throw new BizLogicException(MessageId.EIA0042);
        }

        List<JT_SiRireki> siRirekiLst = siharaiDomManager.getSiRirekisBySyonoGyoumuKousinTime(syono, gyoumuKousinTime);

        if (siRirekiLst.size() > 0) {
            throw new BizLogicException(MessageId.EIF1024);
        }

        List<IT_KhHenkouUktk> khHenkouUktkLst = khToujituOnlineTorikesiDao.getKhHenkouUktksBySyonoGyoumuKousinTime(
            syono, gyoumuKousinTime);

        if (khHenkouUktkLst.size() > 0) {
            throw new BizLogicException(MessageId.EIF3057);
        }

        uiBean.setHenkousikibetukey(henkouSikibetukey);
        uiBean.setYoukyuuno(sortKhTtdkRirekiLst.get(0).getYoukyuuno());
        messageManager.addMessageId(MessageId.QBA0001);
    }

    @Transactional
    void doTorikesi() {

        String syono = uiBean.getSyono();
        String henkouSikibetukey = uiBean.getHenkousikibetukey();
        IT_KykKihon kykKihon = uiBean.getKykKihon();

        hozenDomManager.delete(kykKihon);

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syono);
        hozenDomManager.delete(ansyuKihon);

        List<IT_KhDenpyoData> khDenpyoDataLst = hozenDomManager.getKhDenpyoDatasBySyono(syono);
        hozenDomManager.delete(khDenpyoDataLst);

        List<IT_KhFBSoukinData> khFBSoukinDataLst = hozenDomManager.getKhFBSoukinDatasBySyono(syono);
        hozenDomManager.delete(khFBSoukinDataLst);

        List<IT_KhGaikaFBSoukinData> khGaikaFBSoukinDataLst = hozenDomManager.getKhGaikaFBSoukinDatasBySyono(syono);
        hozenDomManager.delete(khGaikaFBSoukinDataLst);

        List<HT_SmbcStyKanri> smbcStyKanriLst = sinkeiyakuDomManager.getSmbcStyKanrisBySyono(syono);
        sinkeiyakuDomManager.delete(smbcStyKanriLst);

        List<IT_KhHenkouUktk> khHenkouUktkLst = hozenDomManager.getKhHenkouUktksBySyono1(syono);
        hozenDomManager.delete(khHenkouUktkLst);

        List<IT_KhHaitouKanri> khHaitouKanriList = hozenDomManager.getKhHaitouKanriBySyono(syono);
        hozenDomManager.delete(khHaitouKanriList);

        List<IT_KhTumitateDKanri> khTumitateDKanriList = hozenDomManager.getKhTumitateDKanriBySyono(syono);
        hozenDomManager.delete(khTumitateDKanriList);

        List<IT_NyuukinKakusyouData> nyuukinKakusyouDataList = hozenDomManager.getNyuukinKakusyouDataBySyono(syono);
        hozenDomManager.delete(nyuukinKakusyouDataList);

        List<IT_KhDshrTuki> khDshrTukiList = hozenDomManager.getKhDshrTukiBySyono(syono);
        hozenDomManager.delete(khDshrTukiList);

        hozenDomManager.flush();
        sinkeiyakuDomManager.flush();

        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon(syono, henkouSikibetukey);

        if (bakKykKihon != null) {
            IT_KykKihon kykKihonRestore = (IT_KykKihon) bakKykKihon.createRestore();
            hozenDomManager.insert(kykKihonRestore);
            hozenDomManager.delete(bakKykKihon);
        }

        IT_BAK_AnsyuKihon bakAnsyuKihon = hozenDomManager.getBAKAnsyuKihon(syono, henkouSikibetukey);
        if (bakAnsyuKihon != null) {
            IT_AnsyuKihon ansyuKihonRestore = (IT_AnsyuKihon) bakAnsyuKihon.createRestore();
            hozenDomManager.insert(ansyuKihonRestore);
            hozenDomManager.delete(bakAnsyuKihon);
        }

        List<IT_BAK_KhDenpyoData> bakKhDenpyoDataLst =
            hozenDomManager.getBAKKhDenpyoDatasBySyonoTrkssikibetukey(syono, henkouSikibetukey);
        for (IT_BAK_KhDenpyoData bakKhDenpyoData : bakKhDenpyoDataLst) {
            IT_KhDenpyoData khDenpyoDataRestore = (IT_KhDenpyoData) bakKhDenpyoData.createRestore();
            hozenDomManager.insert(khDenpyoDataRestore);
            hozenDomManager.delete(bakKhDenpyoData);
        }

        List<IT_BAK_KhFBSoukinData> bakKhFBSoukinDataLst =
            hozenDomManager.getBAKKhFBSoukinDatasBySyonoTrkssikibetukey(syono, henkouSikibetukey);
        for (IT_BAK_KhFBSoukinData bakKhFBSoukinData : bakKhFBSoukinDataLst) {
            IT_KhFBSoukinData khFBSoukinDataRestore = (IT_KhFBSoukinData) bakKhFBSoukinData.createRestore();
            hozenDomManager.insert(khFBSoukinDataRestore);
            hozenDomManager.delete(bakKhFBSoukinData);
        }

        List<IT_BAK_KhGaikaFBSoukinData> bakKhGaikaFBSoukinDataLst =
            hozenDomManager.getBAKKhGaikaFBSoukinDatasBySyonoTrkssikibetukey(syono, henkouSikibetukey);
        for (IT_BAK_KhGaikaFBSoukinData bakKhGaikaFBSoukinData : bakKhGaikaFBSoukinDataLst) {
            IT_KhGaikaFBSoukinData KhGaikaFBSoukinDataRestore = (IT_KhGaikaFBSoukinData) bakKhGaikaFBSoukinData
                .createRestore();
            hozenDomManager.insert(KhGaikaFBSoukinDataRestore);
            hozenDomManager.delete(bakKhGaikaFBSoukinData);
        }

        List<HT_BAK_SmbcStyKanri> bakSmbcStyKanriLst =
            sinkeiyakuDomManager.getBAKSmbcStyKanrisBySyonoTrkssikibetukey(syono, henkouSikibetukey);
        for (HT_BAK_SmbcStyKanri bakSmbcStyKanri : bakSmbcStyKanriLst) {
            HT_SmbcStyKanri smbcStyKanriRestore = (HT_SmbcStyKanri) bakSmbcStyKanri.createRestore();
            sinkeiyakuDomManager.insert(smbcStyKanriRestore);
            sinkeiyakuDomManager.delete(bakSmbcStyKanri);
        }

        List<IT_BAK_KhHenkouUktk> bakKhHenkouUktkLst =
            hozenDomManager.getBAKKhHenkouUktksBySyonoTrkssikibetukey(syono, henkouSikibetukey);
        for (IT_BAK_KhHenkouUktk bakKhHenkouUktk : bakKhHenkouUktkLst) {
            IT_KhHenkouUktk khHenkouUktkRestore = (IT_KhHenkouUktk) bakKhHenkouUktk.createRestore();
            hozenDomManager.insert(khHenkouUktkRestore);
            hozenDomManager.delete(bakKhHenkouUktk);
        }

        List<IT_BAK_KhHaitouKanri> bakkhHaitouKanriList =
            hozenDomManager.getBAKKhHaitouKanriBySyonoTrkssikibetukey(syono, henkouSikibetukey);

        for (IT_BAK_KhHaitouKanri bakkhHaitouKanri : bakkhHaitouKanriList) {

            IT_KhHaitouKanri khHaitouKanriRestore = (IT_KhHaitouKanri) bakkhHaitouKanri.createRestore();

            hozenDomManager.insert(khHaitouKanriRestore);

            hozenDomManager.delete(bakkhHaitouKanri);
        }

        List<IT_BAK_KhTumitateDKanri> bakkhTumitateDKanriList =
            hozenDomManager.getBAKKhTumitateDKanriBySyonoTrkssikibetukey(syono, henkouSikibetukey);

        for (IT_BAK_KhTumitateDKanri bakkhTumitateDKanri : bakkhTumitateDKanriList) {

            IT_KhTumitateDKanri khTumitateDKanriRestore = (IT_KhTumitateDKanri) bakkhTumitateDKanri.createRestore();

            hozenDomManager.insert(khTumitateDKanriRestore);

            hozenDomManager.delete(bakkhTumitateDKanri);
        }

        List<IT_BAK_NyuukinKakusyouData> baknyuukinKakusyouDataList =
            hozenDomManager.getBAKNyuukinKakusyouDataBySyonoTrkssikibetukey(syono, henkouSikibetukey);

        for (IT_BAK_NyuukinKakusyouData baknyuukinKakusyouData : baknyuukinKakusyouDataList) {

            IT_NyuukinKakusyouData nyuukinKakusyouDataRestore =
                (IT_NyuukinKakusyouData) baknyuukinKakusyouData.createRestore();

            hozenDomManager.insert(nyuukinKakusyouDataRestore);

            hozenDomManager.delete(baknyuukinKakusyouData);
        }

        List<IT_BAK_KhDshrTuki> bakKhDshrTukiList =
            hozenDomManager.getBAKKhDshrTukiBySyonoTrkssikibetukey(syono, henkouSikibetukey);

        for (IT_BAK_KhDshrTuki bakKhDshrTuki : bakKhDshrTukiList) {

            IT_KhDshrTuki khDshrTukiRestore = (IT_KhDshrTuki) bakKhDshrTuki.createRestore();

            hozenDomManager.insert(khDshrTukiRestore);

            hozenDomManager.delete(bakKhDshrTuki);
        }

        if (!BizUtil.isBlank(uiBean.getYoukyuuno())) {
            PALKykKousinTorikesi palKykKousinTorikesi = SWAKInjector.getInstance(PALKykKousinTorikesi.class);
            palKykKousinTorikesi.exec(C_Huho2kyknoKbn.SYONO, syono, uiBean.getYoukyuuno());
        }

        BzSikinIdouRirekiTblSakujyo bzSikinIdouRirekiTblSakujyo = SWAKInjector.getInstance(BzSikinIdouRirekiTblSakujyo.class);
        bzSikinIdouRirekiTblSakujyo.trksKhData(syono, henkouSikibetukey);

        messageManager.addMessageId(MessageId.IAC0009);
    }

    void functionNameOnClickBL() {

        BizPropertyInitializer.initialize(uiBean);
    }
}