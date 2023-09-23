package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import yuyu.def.classification.C_KinouKbn;
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
import yuyu.def.db.entity.IT_BAK_KhSntkInfoTouroku;
import yuyu.def.db.entity.IT_BAK_KhTumitateDKanri;
import yuyu.def.db.entity.IT_BAK_KykKihon;
import yuyu.def.db.entity.IT_BAK_NyuukinKakusyouData;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.entity.IT_KhDshrTuki;
import yuyu.def.db.entity.IT_KhFBSoukinData;
import yuyu.def.db.entity.IT_KhGaikaFBSoukinData;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KhHenkouUktk;
import yuyu.def.db.entity.IT_KhSntkInfoTouroku;
import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_NyuukinKakusyouData;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 契約保全 契約保全共通 テーブルメンテナンスユーティリティ<br />
 * バックアップ対象となるルートエンティティ情報を取得し、バックアップ用エンティティを作成します。
 */
public class TableMaintenanceUtil {

    private IT_BAK_KykKihon bakKykKihon;

    private IT_BAK_AnsyuKihon bakAnsyuKihon;

    private List<IT_BAK_KhDenpyoData> bakKhDenpyoDataList;

    private List<IT_BAK_KhFBSoukinData> bakKhFBSoukinDataList;

    private List<IT_BAK_KhGaikaFBSoukinData> bakKhGaikaFBSoukinDataList;

    private List<IT_BAK_KhSntkInfoTouroku> bakKhSntkInfoTourokuList;

    private List<HT_BAK_SmbcStyKanri> bakSmbcStyKanriList;

    private List<IT_BAK_KhHenkouUktk> bakKhHenkouUktkList;

    private List<IT_BAK_KhHaitouKanri> bakKhHaitouKanriList;

    private List<IT_BAK_KhTumitateDKanri> bakKhTumitateDKanriList;

    private List<IT_BAK_NyuukinKakusyouData> bakNyuukinKakusyouDataList;

    private List<IT_BAK_KhDshrTuki> bakKhDshrTukiList;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    public void backUp(String pSyoNo,Integer pHenkouSkbtkeyRenNo) {
    }

    public void backUp(String pSyoNo,String pHenkouSkbtkeyRenNo) {

        bakKykKihon = null;
        bakAnsyuKihon = null;
        bakKhDenpyoDataList = new ArrayList<IT_BAK_KhDenpyoData>();
        bakKhFBSoukinDataList = new ArrayList<IT_BAK_KhFBSoukinData>();
        bakKhGaikaFBSoukinDataList = new ArrayList<IT_BAK_KhGaikaFBSoukinData>();
        bakKhSntkInfoTourokuList = new ArrayList<IT_BAK_KhSntkInfoTouroku>();
        bakSmbcStyKanriList = new ArrayList<HT_BAK_SmbcStyKanri>();
        bakKhHenkouUktkList = new ArrayList<IT_BAK_KhHenkouUktk>();
        bakKhHaitouKanriList = new ArrayList<IT_BAK_KhHaitouKanri>();
        bakKhTumitateDKanriList = new ArrayList<IT_BAK_KhTumitateDKanri>();
        bakNyuukinKakusyouDataList = new ArrayList<IT_BAK_NyuukinKakusyouData>();
        bakKhDshrTukiList = new ArrayList<IT_BAK_KhDshrTuki>();

        C_KinouKbn kinouKbn = kinou.getKinouKbn();

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyoNo);
        if (kykKihon != null) {
            bakKykKihon = (IT_BAK_KykKihon)kykKihon.createBackup(pHenkouSkbtkeyRenNo);
        }
        if (kinouKbn.eq(C_KinouKbn.ONLINE) && (bakKykKihon != null)){
            hozenDomManager.insert(bakKykKihon);
        }

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(pSyoNo);
        if (ansyuKihon != null) {
            bakAnsyuKihon = (IT_BAK_AnsyuKihon)ansyuKihon.createBackup(pHenkouSkbtkeyRenNo);
        }
        if (kinouKbn.eq(C_KinouKbn.ONLINE) && (bakAnsyuKihon != null)){
            hozenDomManager.insert(bakAnsyuKihon);
        }

        List<IT_KhDenpyoData> khDenpyoDataList = hozenDomManager.getKhDenpyoDatasBySyono(pSyoNo);
        for (IT_KhDenpyoData khDenpyoData:khDenpyoDataList) {
            bakKhDenpyoDataList.add((IT_BAK_KhDenpyoData)khDenpyoData.createBackup(pHenkouSkbtkeyRenNo));
        }
        if (kinouKbn.eq(C_KinouKbn.ONLINE) && (bakKhDenpyoDataList.size() != 0)){
            hozenDomManager.insert(bakKhDenpyoDataList);
        }

        List<IT_KhFBSoukinData> khFBSoukinDataList = hozenDomManager.getKhFBSoukinDatasBySyono(pSyoNo);
        for (IT_KhFBSoukinData khKhFBSoukinData:khFBSoukinDataList) {
            bakKhFBSoukinDataList.add((IT_BAK_KhFBSoukinData)khKhFBSoukinData.createBackup(pHenkouSkbtkeyRenNo));
        }
        if (kinouKbn.eq(C_KinouKbn.ONLINE) && (bakKhFBSoukinDataList.size() != 0)){
            hozenDomManager.insert(bakKhFBSoukinDataList);
        }

        List<IT_KhGaikaFBSoukinData> khGaikaFBSoukinDataList = hozenDomManager.getKhGaikaFBSoukinDatasBySyono(pSyoNo);
        for (IT_KhGaikaFBSoukinData khGaikaFBSoukinData:khGaikaFBSoukinDataList) {
            bakKhGaikaFBSoukinDataList.add((IT_BAK_KhGaikaFBSoukinData)khGaikaFBSoukinData.createBackup(pHenkouSkbtkeyRenNo));
        }
        if (kinouKbn.eq(C_KinouKbn.ONLINE) && (bakKhGaikaFBSoukinDataList.size() != 0)){
            hozenDomManager.insert(bakKhGaikaFBSoukinDataList);
        }

        List<IT_KhSntkInfoTouroku> khSntkInfoTourokuList = hozenDomManager.getKhSntkInfoTourokusBySyono(pSyoNo);
        for (IT_KhSntkInfoTouroku khSntkInfoTouroku:khSntkInfoTourokuList) {
            bakKhSntkInfoTourokuList.add((IT_BAK_KhSntkInfoTouroku)khSntkInfoTouroku.createBackup(pHenkouSkbtkeyRenNo));
        }
        if (kinouKbn.eq(C_KinouKbn.ONLINE) && (bakKhSntkInfoTourokuList.size() != 0)){
            hozenDomManager.insert(bakKhSntkInfoTourokuList);
        }

        List<HT_SmbcStyKanri> smbcStyKanriList = sinkeiyakuDomManager.getSmbcStyKanrisBySyono(pSyoNo);
        for (HT_SmbcStyKanri smbcStyKanri:smbcStyKanriList) {
            bakSmbcStyKanriList.add((HT_BAK_SmbcStyKanri)smbcStyKanri.createBackup(pHenkouSkbtkeyRenNo));
        }
        if (kinouKbn.eq(C_KinouKbn.ONLINE) && (bakSmbcStyKanriList.size() != 0)){
            hozenDomManager.insert(bakSmbcStyKanriList);
        }

        List<IT_KhHenkouUktk> khHenkouUktkList = hozenDomManager.getKhHenkouUktksBySyono1(pSyoNo);
        for (IT_KhHenkouUktk khHenkouUktk:khHenkouUktkList) {
            bakKhHenkouUktkList.add((IT_BAK_KhHenkouUktk)khHenkouUktk.createBackup(pHenkouSkbtkeyRenNo));
        }
        if (kinouKbn.eq(C_KinouKbn.ONLINE) && (bakKhHenkouUktkList.size() != 0)){
            hozenDomManager.insert(bakKhHenkouUktkList);
        }

        List<IT_KhHaitouKanri> khHaitouKanriList = hozenDomManager.getKhHaitouKanriBySyono(pSyoNo);
        for (IT_KhHaitouKanri khHaitouKanri:khHaitouKanriList) {
            bakKhHaitouKanriList.add((IT_BAK_KhHaitouKanri)khHaitouKanri.createBackup(pHenkouSkbtkeyRenNo));
        }
        if (kinouKbn.eq(C_KinouKbn.ONLINE) && (bakKhHaitouKanriList.size() != 0)){
            hozenDomManager.insert(bakKhHaitouKanriList);
        }

        List<IT_KhTumitateDKanri> khTumitateDKanriList = hozenDomManager.getKhTumitateDKanriBySyono(pSyoNo);
        for (IT_KhTumitateDKanri khTumitateDKanri:khTumitateDKanriList) {
            bakKhTumitateDKanriList.add((IT_BAK_KhTumitateDKanri)khTumitateDKanri.createBackup(pHenkouSkbtkeyRenNo));
        }
        if (kinouKbn.eq(C_KinouKbn.ONLINE) && (bakKhTumitateDKanriList.size() != 0)){
            hozenDomManager.insert(bakKhTumitateDKanriList);
        }

        List<IT_NyuukinKakusyouData> nyuukinKakusyouDataList = hozenDomManager.getNyuukinKakusyouDataBySyono(pSyoNo);
        for (IT_NyuukinKakusyouData nyuukinKakusyouData:nyuukinKakusyouDataList) {
            bakNyuukinKakusyouDataList.add((IT_BAK_NyuukinKakusyouData)nyuukinKakusyouData.createBackup(pHenkouSkbtkeyRenNo));
        }
        if (kinouKbn.eq(C_KinouKbn.ONLINE) && (bakNyuukinKakusyouDataList.size() != 0)){
            hozenDomManager.insert(bakNyuukinKakusyouDataList);
        }

        List<IT_KhDshrTuki> khDshrTukiList = hozenDomManager.getKhDshrTukiBySyono(pSyoNo);
        for (IT_KhDshrTuki khDshrTuki:khDshrTukiList) {
            bakKhDshrTukiList.add((IT_BAK_KhDshrTuki)khDshrTuki.createBackup(pHenkouSkbtkeyRenNo));
        }
        if (kinouKbn.eq(C_KinouKbn.ONLINE) && (bakKhDshrTukiList.size() != 0)){
            hozenDomManager.insert(bakKhDshrTukiList);
        }

    }

    public IT_BAK_KykKihon getBakKykKihon() {
        return bakKykKihon;
    }

    public IT_BAK_AnsyuKihon getBakAnsyuKihon() {
        return bakAnsyuKihon;
    }

    public List<IT_BAK_KhDenpyoData> getBakKhDenpyoDataList() {
        return bakKhDenpyoDataList;
    }

    public List<IT_BAK_KhGaikaFBSoukinData> getBakKhGaikaFBSoukinDataList() {
        return bakKhGaikaFBSoukinDataList;
    }

    public List<IT_BAK_KhSntkInfoTouroku> getBakKhSntkInfoTourokuList() {
        return bakKhSntkInfoTourokuList;
    }

    public List<IT_BAK_KhFBSoukinData> getBakKhFBSoukinDataList() {
        return bakKhFBSoukinDataList;
    }

    public List<HT_BAK_SmbcStyKanri> getBakSmbcStyKanriList() {
        return bakSmbcStyKanriList;
    }

    public List<IT_BAK_KhHenkouUktk> getBakKhHenkouUktkList() {
        return bakKhHenkouUktkList;
    }

    public List<IT_BAK_KhHaitouKanri> getBakKhHaitouKanriList() {
        return bakKhHaitouKanriList;
    }
    public List<IT_BAK_KhTumitateDKanri> getBakKhTumitateDKanriList() {
        return bakKhTumitateDKanriList;
    }
    public List<IT_BAK_NyuukinKakusyouData> getBakNyuukinKakusyouDataList() {
        return bakNyuukinKakusyouDataList;
    }
    public List<IT_BAK_KhDshrTuki> getBakKhDshrTukiList() {
        return bakKhDshrTukiList;
    }
}
