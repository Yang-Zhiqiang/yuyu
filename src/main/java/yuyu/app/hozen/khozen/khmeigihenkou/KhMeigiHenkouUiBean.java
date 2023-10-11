package yuyu.app.hozen.khozen.khmeigihenkou;

import java.util.List;

import javax.inject.Inject;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.biz.koutei.ProgressHistoryDataSourceBeanCommonParam;
import yuyu.common.biz.koutei.SetKouteiInfoExecUiBeanParam;
import yuyu.common.biz.koutei.SetProgressHistoryExecUiBeanParam;
import yuyu.common.biz.koutei.viewkouteiinfo.ViewKouteiInfoUiBeanParam;
import yuyu.common.biz.koutei.viewprogresshistory.ViewProgressHistoryUiBeanParam;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiranExecUiBeanParam;
import yuyu.common.biz.syoruiitiran.SyoruiInfoItiranDataSourceBeanCommonParam;
import yuyu.common.biz.syoruiitiran.viewsyoruiinfoitiran.ViewSyoruiInfoItiranUiBeanParam;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiExecUiBeanParam;
import yuyu.common.hozen.khcommon.KhozenCommonParamGetHituyouSyoruiUiBeanParam;
import yuyu.common.hozen.khcommon.KhozenCommonParamKhMeigiHenkouUiBeanParam;
import yuyu.common.hozen.khview.viewbetukyk.ViewBetukykUiBeanParam;
import yuyu.common.hozen.khview.viewharaikomiinfo.ViewHaraikomiInfoUiBeanParam;
import yuyu.common.hozen.khview.viewhituyousyorui.ViewHituyouSyoruiUiBeanParam;
import yuyu.common.hozen.khview.viewkihon.ViewKihonUiBeanParam;
import yuyu.common.hozen.khview.viewkyksyadairi.ViewKyksyadairiUiBeanParam;
import yuyu.common.hozen.khview.viewtetudukityuui.ViewTetudukityuuiUiBeanParam;
import yuyu.common.hozen.khview.viewtrkkazoku.ViewTrkKazokuUiBeanParam;
import yuyu.common.hozen.khview.viewtuusinsaki.ViewTuusinsakiUiBeanParam;
import yuyu.common.hozen.setuibean.KikeiyakuInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.NenkinsiharaiInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.PalNenkinsiharaiInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.PalkikeiyakuInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.PalsueokiInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.SetBetukykExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetHaraikomiInfoExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetHihokensyaExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetHituyouSyoruiExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetKeiyakusyaExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetKeizokuNkuktExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetKhKbnPatternUtilUiBeanParam;
import yuyu.common.hozen.setuibean.SetKihonExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetKyksyadairiExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetNkuktExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetSbHenkanuktExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetSbHkuktExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetSiteiseikyuuExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetTetudukityuuiExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuuiExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetTrkKazokuExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetTuusinsakiExecUiBeanParam;
import yuyu.common.hozen.setuibean.TtdktyuuikbnInfoDataSourceBeanCommonParam;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KhkinouModeIdKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KykdrknHtdjytKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.infr.kinoumode.KinouMode;

import com.google.common.collect.Lists;

/**
 * 名義変更／契約者等生年月日訂正 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class KhMeigiHenkouUiBean extends GenKhMeigiHenkouUiBean implements CheckYuukouJyoutaiExecUiBeanParam,
SetToriatukaiTyuuiExecUiBeanParam,SetKihonExecUiBeanParam,SetTetudukityuuiExecUiBeanParam,
SetKeiyakusyaExecUiBeanParam,SetHihokensyaExecUiBeanParam,SetTuusinsakiExecUiBeanParam,SetNkuktExecUiBeanParam,
SetSbHenkanuktExecUiBeanParam,SetSbHkuktExecUiBeanParam,SetHaraikomiInfoExecUiBeanParam,SetSyoruiInfoItiranExecUiBeanParam,
KhozenCommonParamGetHituyouSyoruiUiBeanParam,SetKeizokuNkuktExecUiBeanParam,
SetSiteiseikyuuExecUiBeanParam,SetHituyouSyoruiExecUiBeanParam,SetKouteiInfoExecUiBeanParam,
SetProgressHistoryExecUiBeanParam, SetBetukykExecUiBeanParam,ViewSyoruiInfoItiranUiBeanParam,ViewKihonUiBeanParam,
ViewTetudukityuuiUiBeanParam,ViewTuusinsakiUiBeanParam,ViewHaraikomiInfoUiBeanParam, ViewKouteiInfoUiBeanParam,
ViewProgressHistoryUiBeanParam, ViewBetukykUiBeanParam, ViewHituyouSyoruiUiBeanParam, SetKhKbnPatternUtilUiBeanParam ,
KhozenCommonParamKhMeigiHenkouUiBeanParam, SetTrkKazokuExecUiBeanParam, ViewTrkKazokuUiBeanParam,
SetKyksyadairiExecUiBeanParam, ViewKyksyadairiUiBeanParam {

    private static final long serialVersionUID = 1L;

    @Inject
    private KinouMode kinouMode;

    @Inject
    private IT_KykKihon kykKihon;

    @Inject
    private BzWorkflowInfo bzWorkflowInfo;

    private String kouteikanriid;

    private String jimutetuzukicd;

    private C_UmuKbn stdrsktkyhkumu;

    private C_UmuKbn nkhknumu;

    private C_UmuKbn hjnkykumukbn;

    private C_UmuKbn vshktsbhkuktumu;

    private C_UmuKbn vshktsbkyuuhukinuktumu;

    private C_UmuKbn kykhenkouumu;

    private C_UmuKbn hhkhenkouumu;

    private C_UmuKbn nkukthenkouumu;

    private C_UmuKbn kznkukthenkouumu;

    private C_UmuKbn sbhkknukthenkouumu;

    private C_UmuKbn sbukthenkouumu;

    private C_UmuKbn stdrskhenkouumu;

    private C_UmuKbn tyouhyoumukbn;

    private String tyouhyoukey;

    private BizDate kykseiymd;

    private String patternNewkyksei;

    private String patternNewkkkyktdk;

    private List<String> gmwarningIdLst;

    private List<String> gmwarningLst;

    private String[] imageids;


    private C_UmuKbn  sbhenkanuktdispumu;

    private C_UmuKbn mosuktymdhkumu;

    private BizDate ttdktyuuisetymd;

    private Integer vshktsbuktsyurenno1;

    private Integer vshktsbuktsyurenno2;

    private Integer vshktsbuktsyurenno3;

    private Integer vshktsbuktsyurenno4;

    private C_SyorikekkaKbn zenkaisyorikekkakbn;

    private String kouteilockKey;

    private C_UmuKbn kyktdkhnkumu;

    private List<String> warningMessageIdList;

    private List<String> warningMessageList;

    private C_KhkinouModeIdKbn khkinouModeIdKbn;

    private String patternSyorikekkakbn;

    private C_UmuKbn nextkosumu;

    private C_UktKbn vshktdispsbuktkbn2;

    private C_UktKbn vshktdispsbuktkbn3;

    private C_UktKbn vshktdispsbuktkbn4;

    private C_UmuKbn daisennintdkumukbn;

    private C_UmuKbn dskykmeihenkouumu;

    private int aeoitaisyousyacnt;

    private Integer aeoirenno;

    private C_UmuKbn sbukt1inpumu;

    private C_UmuKbn sbukt2inpumu;

    private C_UmuKbn sbukt3inpumu;

    private C_UmuKbn sbukt4inpumu;

    private C_UmuKbn yennykntkhkumu;

    private C_Tuukasyu kyktuukasyu;

    private BizDate yendthnkymd;

    private C_UmuKbn zeiseitkkktkykhukaumu;

    private boolean rstCheckYuuyokkngai;

    private C_UmuKbn kykdrtkykhukaumu;

    private C_KykdrknHtdjytKbn kykdrknhatudoujyoutai;

    private C_UmuKbn teikishrtkykhukaumu;

    private C_TsindousiteiKbn trkkzktsindousiteikbn1;

    private C_TsindousiteiKbn trkkzktsindousiteikbn2;

    public boolean isInputMode(){
        return kinouMode.getKinouMode().equals(C_KhkinouModeIdKbn.INPUT.getValue());
    }

    public KinouMode getKinouMode() {
        return kinouMode;
    }

    public void setKinouMode(KinouMode pKinouMode) {
        kinouMode = pKinouMode;
    }

    public IT_KykKihon getKykKihon() {
        return kykKihon;
    }

    public void setKykKihon(IT_KykKihon pKykKihon) {
        kykKihon = pKykKihon;
    }

    @Override
    public BzWorkflowInfo getBzWorkflowInfo() {
        return bzWorkflowInfo;
    }

    public void setBzWorkflowInfo(BzWorkflowInfo pBzWorkflowInfo) {
        this.bzWorkflowInfo = pBzWorkflowInfo;
    }

    public KhMeigiHenkouUiBean() {
    }

    public String getKouteikanriid() {
        return kouteikanriid;
    }

    public void setKouteikanriid(String pKouteikanriid) {
        kouteikanriid = pKouteikanriid;
    }

    public String getJimutetuzukicd() {
        return jimutetuzukicd;
    }

    public void setJimutetuzukicd(String pJimutetuzukicd) {
        jimutetuzukicd = pJimutetuzukicd;
    }

    public C_UmuKbn getStdrsktkyhkumu() {
        return stdrsktkyhkumu;
    }

    public void setStdrsktkyhkumu(C_UmuKbn pStdrsktkyhkumu) {
        stdrsktkyhkumu = pStdrsktkyhkumu;
    }

    public C_UmuKbn getNkhknumu() {
        return nkhknumu;
    }

    public void setNkhknumu(C_UmuKbn pNkhknumu) {
        nkhknumu = pNkhknumu;
    }

    public C_UmuKbn getHjnkykumukbn() {
        return hjnkykumukbn;
    }

    public void setHjnkykumukbn(C_UmuKbn pHjnkykumukbn) {
        hjnkykumukbn = pHjnkykumukbn;
    }

    public C_UmuKbn getVshktsbhkuktumu() {
        return vshktsbhkuktumu;
    }

    @Override
    public void setVshktsbhkuktumu(C_UmuKbn pVshktsbhkuktumu) {
        vshktsbhkuktumu = pVshktsbhkuktumu;
    }

    public C_UmuKbn getVshktsbkyuuhukinuktumu() {
        return vshktsbkyuuhukinuktumu;
    }

    @Override
    public void setVshktsbkyuuhukinuktumu(C_UmuKbn pVshktsbkyuuhukinuktumu) {
        vshktsbkyuuhukinuktumu = pVshktsbkyuuhukinuktumu;
    }

    public C_UmuKbn getKykhenkouumu() {
        return kykhenkouumu;
    }

    public void setKykhenkouumu(C_UmuKbn pKykhenkouumu) {
        kykhenkouumu = pKykhenkouumu;
    }

    public C_UmuKbn getHhkhenkouumu() {
        return hhkhenkouumu;
    }

    public void setHhkhenkouumu(C_UmuKbn pHhkhenkouumu) {
        hhkhenkouumu = pHhkhenkouumu;
    }

    public C_UmuKbn getNkukthenkouumu() {
        return nkukthenkouumu;
    }

    public void setNkukthenkouumu(C_UmuKbn pNkukthenkouumu) {
        nkukthenkouumu = pNkukthenkouumu;
    }

    public C_UmuKbn getKznkukthenkouumu() {
        return kznkukthenkouumu;
    }

    public void setKznkukthenkouumu(C_UmuKbn pKznkukthenkouumu) {
        kznkukthenkouumu = pKznkukthenkouumu;
    }

    public C_UmuKbn getSbhkknukthenkouumu() {
        return sbhkknukthenkouumu;
    }

    public void setSbhkknukthenkouumu(C_UmuKbn pSbhkknukthenkouumu) {
        sbhkknukthenkouumu = pSbhkknukthenkouumu;
    }

    public C_UmuKbn getSbukthenkouumu() {
        return sbukthenkouumu;
    }

    public void setSbukthenkouumu(C_UmuKbn pSbukthenkouumu) {
        sbukthenkouumu = pSbukthenkouumu;
    }

    public C_UmuKbn getStdrskhenkouumu() {
        return stdrskhenkouumu;
    }

    public void setStdrskhenkouumu(C_UmuKbn pStdrskhenkouumu) {
        stdrskhenkouumu = pStdrskhenkouumu;
    }

    public C_UmuKbn getTyouhyoumukbn() {
        return tyouhyoumukbn;
    }

    public void setTyouhyoumukbn(C_UmuKbn pTyouhyoumukbn) {
        tyouhyoumukbn = pTyouhyoumukbn;
    }

    public String getTyouhyoukey() {
        return tyouhyoukey;
    }

    public void setTyouhyoukey(String pTyouhyoukey) {
        tyouhyoukey = pTyouhyoukey;
    }

    public BizDate getKykseiymd() {
        return kykseiymd;
    }

    public void setKykseiymd(BizDate pKykseiymd) {
        kykseiymd = pKykseiymd;
    }

    public String getPatternNewkyksei() {
        return patternNewkyksei;
    }

    public void setPatternNewkyksei(String pPatternNewkyksei) {
        patternNewkyksei = pPatternNewkyksei;
    }

    public String getPatternNewkkkyktdk() {
        return patternNewkkkyktdk;
    }

    public void setPatternNewkkkyktdk(String pPatternNewkkkyktdk) {
        patternNewkkkyktdk = pPatternNewkkkyktdk;
    }
    public List<String> getGmwarningIdLst() {
        return gmwarningIdLst;
    }

    public void setGmwarningIdLst(List<String> pGmwarningIdLst) {
        gmwarningIdLst = pGmwarningIdLst;
    }

    public List<String> getGmwarningLst() {
        return gmwarningLst;
    }

    public void setGmwarningLst(List<String> pGmwarningLst) {
        gmwarningLst = pGmwarningLst;
    }

    @Override
    public String[] getImageids() {
        return imageids;
    }

    @Override
    public void setImageids(String[] pImageids) {
        imageids = pImageids;
    }

    public C_UmuKbn  getSbhenkanuktdispumu() {
        return sbhenkanuktdispumu;
    }

    public void setSbhenkanuktdispumu(C_UmuKbn pSbhenkanuktdispumu) {
        sbhenkanuktdispumu = pSbhenkanuktdispumu;
    }


    public C_UmuKbn getMosuktymdhkumu() {
        return mosuktymdhkumu;
    }

    public void setMosuktymdhkumu(C_UmuKbn pMosuktymdhkumu) {
        mosuktymdhkumu = pMosuktymdhkumu;
    }



    public BizDate getTtdktyuuisetymd() {
        return ttdktyuuisetymd;
    }

    public void setTtdktyuuisetymd(BizDate pTtdktyuuisetymd) {
        ttdktyuuisetymd = pTtdktyuuisetymd;
    }

    public Integer getVshktsbuktsyurenno1() {
        return vshktsbuktsyurenno1;
    }

    @Override
    public void setVshktsbuktsyurenno1(Integer pVshktsbuktsyurenno1) {
        vshktsbuktsyurenno1 = pVshktsbuktsyurenno1;
    }

    public Integer getVshktsbuktsyurenno2() {
        return vshktsbuktsyurenno2;
    }

    @Override
    public void setVshktsbuktsyurenno2(Integer pVshktsbuktsyurenno2) {
        vshktsbuktsyurenno2 = pVshktsbuktsyurenno2;
    }

    public Integer getVshktsbuktsyurenno3() {
        return vshktsbuktsyurenno3;
    }

    @Override
    public void setVshktsbuktsyurenno3(Integer pVshktsbuktsyurenno3) {
        vshktsbuktsyurenno3 = pVshktsbuktsyurenno3;
    }

    public Integer getVshktsbuktsyurenno4() {
        return vshktsbuktsyurenno4;
    }

    @Override
    public void setVshktsbuktsyurenno4(Integer pVshktsbuktsyurenno4) {
        vshktsbuktsyurenno4 = pVshktsbuktsyurenno4;
    }

    public C_SyorikekkaKbn getZenkaisyorikekkakbn() {
        return zenkaisyorikekkakbn;
    }

    public void setZenkaisyorikekkakbn(C_SyorikekkaKbn pZenkaisyorikekkakbn) {
        zenkaisyorikekkakbn = pZenkaisyorikekkakbn;
    }

    public String getKouteilockKey() {
        return kouteilockKey;
    }

    public void setKouteilockKey(String pKouteilockKey) {
        kouteilockKey = pKouteilockKey;
    }

    public C_UmuKbn getKyktdkhnkumu() {
        return kyktdkhnkumu;
    }

    public void setKyktdkhnkumu(C_UmuKbn pKyktdkhnkumu) {
        kyktdkhnkumu = pKyktdkhnkumu;
    }

    public List<String> getWarningMessageIdList() {
        return warningMessageIdList;
    }

    @Override
    public void setWarningMessageIdList(List<String> pWarningMessageIdList) {
        warningMessageIdList = pWarningMessageIdList;
    }

    public List<String> getWarningMessageList() {
        return warningMessageList;
    }

    @Override
    public void setWarningMessageList(List<String> pWarningMessageList) {
        warningMessageList = pWarningMessageList;
    }

    @Override
    public C_KhkinouModeIdKbn getKhkinouModeIdKbn() {
        return khkinouModeIdKbn;
    }

    public void setKhkinouModeIdKbn(C_KhkinouModeIdKbn pKhkinouModeIdKbn) {
        khkinouModeIdKbn = pKhkinouModeIdKbn;
    }

    public String getPatternSyorikekkakbn() {
        return patternSyorikekkakbn;
    }

    @Override
    public void setPatternSyorikekkakbn(String pPatternSyorikekkakbn) {
        patternSyorikekkakbn = pPatternSyorikekkakbn;
    }





    @Override
    public void setNewkyknmkjkhuka(Boolean b){
        super.setNewkyknmkjkhuka(b);
        C_KjkhukaKbn kbn;
        if(b){
            kbn = C_KjkhukaKbn.KJKHUKA;
        }
        else{
            kbn = C_KjkhukaKbn.BLNK;
        }
        super.setNewkyknmkjkhukakbn(kbn);
    }

    @Override
    public void setNewhhknnmkjkhuka(Boolean b){
        super.setNewhhknnmkjkhuka(b);
        C_KjkhukaKbn kbn;
        if(b){
            kbn = C_KjkhukaKbn.KJKHUKA;
        }
        else{
            kbn = C_KjkhukaKbn.BLNK;
        }
        super.setNewhhknnmkjkhukakbn(kbn);
    }

    @Override
    public void setSbuktnmkjkhuka1(Boolean pSbuktnmkjkhuka1) {

        super.setSbuktnmkjkhuka1(pSbuktnmkjkhuka1);

        C_KjkhukaKbn cKjkhukaKbn = null;

        if (pSbuktnmkjkhuka1 == true) {

            cKjkhukaKbn = C_KjkhukaKbn.KJKHUKA;
        }
        else {

            cKjkhukaKbn = C_KjkhukaKbn.BLNK;
        }

        super.setSbuktnmkjhukakbn1(cKjkhukaKbn);
    }

    @Override
    public void setSbuktnmkjkhuka2(Boolean pSbuktnmkjkhuka2) {

        super.setSbuktnmkjkhuka2(pSbuktnmkjkhuka2);

        C_KjkhukaKbn cKjkhukaKbn = null;

        if (pSbuktnmkjkhuka2 == true) {

            cKjkhukaKbn = C_KjkhukaKbn.KJKHUKA;
        }
        else {

            cKjkhukaKbn = C_KjkhukaKbn.BLNK;
        }

        super.setSbuktnmkjhukakbn2(cKjkhukaKbn);
    }

    @Override
    public void setSbuktnmkjkhuka3(Boolean pSbuktnmkjkhuka3) {

        super.setSbuktnmkjkhuka3(pSbuktnmkjkhuka3);

        C_KjkhukaKbn cKjkhukaKbn = null;

        if (pSbuktnmkjkhuka3 == true) {

            cKjkhukaKbn = C_KjkhukaKbn.KJKHUKA;
        }
        else {

            cKjkhukaKbn = C_KjkhukaKbn.BLNK;
        }

        super.setSbuktnmkjhukakbn3(cKjkhukaKbn);
    }

    @Override
    public void setSbuktnmkjkhuka4(Boolean pSbuktnmkjkhuka4) {

        super.setSbuktnmkjkhuka4(pSbuktnmkjkhuka4);

        C_KjkhukaKbn cKjkhukaKbn = null;

        if (pSbuktnmkjkhuka4 == true) {

            cKjkhukaKbn = C_KjkhukaKbn.KJKHUKA;
        }
        else {

            cKjkhukaKbn = C_KjkhukaKbn.BLNK;
        }

        super.setSbuktnmkjhukakbn4(cKjkhukaKbn);
    }

    @Override
    public void setNewstdrsknmkjhuka(Boolean pNewstdrsknmkjhuka) {

        super.setNewstdrsknmkjhuka(pNewstdrsknmkjhuka);

        C_KjkhukaKbn cKjkhukaKbn = null;

        if (pNewstdrsknmkjhuka == true) {

            cKjkhukaKbn = C_KjkhukaKbn.KJKHUKA;
        }
        else {

            cKjkhukaKbn = C_KjkhukaKbn.BLNK;
        }

        super.setNewstdrsknmkjhukakbn(cKjkhukaKbn);
    }

    @Override
    public ProgressHistoryDataSourceBeanCommonParam createProgressHistoryDataSourceBean() {
        return new ProgresshistoryinfoDataSourceBean();
    }

    @Override
    public void convertProgressHistoryForCommonParam(
        List<ProgressHistoryDataSourceBeanCommonParam> progressHistoryDataSourceBeanCommonParam) {
        List<ProgresshistoryinfoDataSourceBean> progresshistoryinfoLst = Lists.newArrayList();

        for (ProgressHistoryDataSourceBeanCommonParam beanParam : progressHistoryDataSourceBeanCommonParam) {
            progresshistoryinfoLst.add((ProgresshistoryinfoDataSourceBean)beanParam);
        }

        super.setProgresshistoryinfo(progresshistoryinfoLst);
    }

    @Override
    public TtdktyuuikbnInfoDataSourceBeanCommonParam createTtdktyuuikbnInfoDataSourceBean() {
        return new TtdktyuuikbnInfoDataSourceBean();
    }

    @Override
    public void convertTtdktyuuikbnInfoForCommonParam(List<TtdktyuuikbnInfoDataSourceBeanCommonParam> pTtdktyuuikbnInfo) {
        List<TtdktyuuikbnInfoDataSourceBean> ttdktyuuikbnInfo = Lists.newArrayList();
        for (TtdktyuuikbnInfoDataSourceBeanCommonParam beanPram : pTtdktyuuikbnInfo) {
            ttdktyuuikbnInfo.add((TtdktyuuikbnInfoDataSourceBean)beanPram);
        }
        super.setTtdktyuuikbnInfo(ttdktyuuikbnInfo);
    }

    @Override
    public KikeiyakuInfoDataSourceBeanCommonParam createKikeiyakuInfoDataSourceBean() {
        return new KikeiyakuInfoDataSourceBean();
    }

    @Override
    public void convertKikeiyakuInfoForCommonParam(List<KikeiyakuInfoDataSourceBeanCommonParam> pKikeiyakuInfo) {
        List<KikeiyakuInfoDataSourceBean> kikeiyakuInfo = Lists.newArrayList();
        for (KikeiyakuInfoDataSourceBeanCommonParam beanParam : pKikeiyakuInfo) {
            kikeiyakuInfo.add((KikeiyakuInfoDataSourceBean)beanParam);
        }
        super.setKikeiyakuInfo(kikeiyakuInfo);
    }

    @Override
    public NenkinsiharaiInfoDataSourceBeanCommonParam createNenkinsiharaiInfoDataSourceBean() {
        return new NenkinsiharaiInfoDataSourceBean();
    }

    @Override
    public void convertNenkinsiharaiInfoForCommonParam(
        List<NenkinsiharaiInfoDataSourceBeanCommonParam> pNenkinsiharaiInfo) {
        List<NenkinsiharaiInfoDataSourceBean> nenkinsiharaiInfo = Lists.newArrayList();
        for (NenkinsiharaiInfoDataSourceBeanCommonParam beanParam : pNenkinsiharaiInfo) {
            nenkinsiharaiInfo.add((NenkinsiharaiInfoDataSourceBean)beanParam);
        }
        super.setNenkinsiharaiInfo(nenkinsiharaiInfo);
    }

    @Override
    public PalkikeiyakuInfoDataSourceBeanCommonParam createPalkikeiyakuInfoDataSourceBean() {
        return new PalkikeiyakuInfoDataSourceBean();
    }

    @Override
    public void convertPalkikeiyakuInfoForCommonParam(
        List<PalkikeiyakuInfoDataSourceBeanCommonParam> pPalkikeiyakuInfo) {
        List<PalkikeiyakuInfoDataSourceBean> palkikeiyakuInfo = Lists.newArrayList();
        for (PalkikeiyakuInfoDataSourceBeanCommonParam beanParam : pPalkikeiyakuInfo) {
            palkikeiyakuInfo.add((PalkikeiyakuInfoDataSourceBean)beanParam);
        }
        super.setPalkikeiyakuInfo(palkikeiyakuInfo);
    }

    @Override
    public PalNenkinsiharaiInfoDataSourceBeanCommonParam createPalNenkinsiharaiInfoDataSourceBean() {
        return new PalnenkinsiharaiInfoDataSourceBean();
    }

    @Override
    public void convertPalNenkinsiharaiInfoForCommonParam(List<PalNenkinsiharaiInfoDataSourceBeanCommonParam> pPalNenkinsiharaiInfo) {
        List<PalnenkinsiharaiInfoDataSourceBean> palnenkinsiharaiInfo = Lists.newArrayList();
        for (PalNenkinsiharaiInfoDataSourceBeanCommonParam beanParam : pPalNenkinsiharaiInfo) {
            palnenkinsiharaiInfo.add((PalnenkinsiharaiInfoDataSourceBean)beanParam);
        }
        super.setPalnenkinsiharaiInfo(palnenkinsiharaiInfo);
    }

    @Override
    public PalsueokiInfoDataSourceBeanCommonParam createPalsueokiInfoDataSourceBean() {
        return new PalsueokiInfoDataSourceBean();
    }

    @Override
    public void convertPalsueokiInfoForCommonParam(List<PalsueokiInfoDataSourceBeanCommonParam>  pPalsueokiInfo) {
        List<PalsueokiInfoDataSourceBean> palnenkinsiharaiInfo = Lists.newArrayList();
        for (PalsueokiInfoDataSourceBeanCommonParam beanParam : pPalsueokiInfo) {
            palnenkinsiharaiInfo.add((PalsueokiInfoDataSourceBean)beanParam);
        }
        super.setPalsueokiInfo(palnenkinsiharaiInfo);
    }

    @Override
    public SyoruiInfoItiranDataSourceBeanCommonParam createSyoruiInfoItiranDataSourceBean() {
        return new SyoruiInfoListDataSourceBean();
    }

    @Override
    public void convertSyoruiInfoItiranForCommonParam(List<SyoruiInfoItiranDataSourceBeanCommonParam> pSyoruiInfoItiran) {
        List<SyoruiInfoListDataSourceBean> syoruiInfoList = Lists.newArrayList();

        for (SyoruiInfoItiranDataSourceBeanCommonParam beanPram : pSyoruiInfoItiran) {
            syoruiInfoList.add((SyoruiInfoListDataSourceBean)beanPram);
        }

        super.setSyoruiInfoList(syoruiInfoList);
    }

    @Override
    public String getSyono() {

        return getVkihnsyono();
    }

    @Override
    public void setSyono(String pSyono) {

        setVkihnsyono(pSyono);
    }

    @Override
    public C_UmuKbn getNextkosumu() {
        return nextkosumu;
    }

    @Override
    public void setNextkosumu(C_UmuKbn pNextkosumu) {
        nextkosumu = pNextkosumu;
    }

    public C_UktKbn getVshktdispsbuktkbn2() {
        return vshktdispsbuktkbn2;
    }

    @Override
    public void setVshktdispsbuktkbn2(C_UktKbn pVshktdispsbuktkbn2) {

        vshktdispsbuktkbn2 = pVshktdispsbuktkbn2;
    }

    public C_UktKbn getVshktdispsbuktkbn3() {
        return vshktdispsbuktkbn3;
    }

    @Override
    public void setVshktdispsbuktkbn3(C_UktKbn pVshktdispsbuktkbn3) {

        vshktdispsbuktkbn3 = pVshktdispsbuktkbn3;
    }

    public C_UktKbn getVshktdispsbuktkbn4() {
        return vshktdispsbuktkbn4;
    }

    @Override
    public void setVshktdispsbuktkbn4(C_UktKbn pVshktdispsbuktkbn4) {

        vshktdispsbuktkbn4 = pVshktdispsbuktkbn4;
    }

    @Override
    public C_Hrkkaisuu getHrkkaisuu() {
        return getVhrkihrkkaisuu();
    }

    @Override
    public C_UmuKbn getDaisennintdkumukbn() {
        return daisennintdkumukbn;
    }

    public void setDaisennintdkumukbn(C_UmuKbn pDaisennintdkumukbn) {
        daisennintdkumukbn = pDaisennintdkumukbn;
    }

    public C_UmuKbn getDskykmeihenkouumu() {
        return dskykmeihenkouumu;
    }

    public void setDskykmeihenkouumu(C_UmuKbn pDskykmeihenkouumu) {
        dskykmeihenkouumu = pDskykmeihenkouumu;
    }

    public int getAeoitaisyousyacnt() {
        return aeoitaisyousyacnt;
    }

    public void setAeoitaisyousyacnt(int pAeoitaisyousyacnt) {
        aeoitaisyousyacnt = pAeoitaisyousyacnt;
    }

    public Integer getAeoirenno() {
        return aeoirenno;
    }

    public void setAeoirenno(Integer pAeoirenno) {
        aeoirenno = pAeoirenno;
    }

    public C_UmuKbn getSbukt1inpumu() {
        return sbukt1inpumu;
    }

    public void setSbukt1inpumu(C_UmuKbn pSbukt1inpumu) {
        sbukt1inpumu = pSbukt1inpumu;
    }

    public C_UmuKbn getSbukt2inpumu() {
        return sbukt2inpumu;
    }

    public void setSbukt2inpumu(C_UmuKbn pSbukt2inpumu) {
        sbukt2inpumu = pSbukt2inpumu;
    }

    public C_UmuKbn getSbukt3inpumu() {
        return sbukt3inpumu;
    }

    public void setSbukt3inpumu(C_UmuKbn pSbukt3inpumu) {
        sbukt3inpumu = pSbukt3inpumu;
    }

    public C_UmuKbn getSbukt4inpumu() {
        return sbukt4inpumu;
    }

    public void setSbukt4inpumu(C_UmuKbn pSbukt4inpumu) {
        sbukt4inpumu = pSbukt4inpumu;
    }

    @Override
    public C_UmuKbn getYennykntkhkumu() {
        return yennykntkhkumu;
    }

    @Override
    public void setYennykntkhkumu(C_UmuKbn pYennykntkhkumu) {
        yennykntkhkumu = pYennykntkhkumu;

    }

    @Override
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    @Override
    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    public BizDate getYendthnkymd() {
        return yendthnkymd;
    }

    public void setYendthnkymd(BizDate pYendthnkymd) {
        yendthnkymd = pYendthnkymd;
    }

    public C_UmuKbn getZeiseitkkktkykhukaumu() {
        return zeiseitkkktkykhukaumu;
    }

    public void setZeiseitkkktkykhukaumu(C_UmuKbn pZeiseitkkktkykhukaumu) {
        zeiseitkkktkykhukaumu = pZeiseitkkktkykhukaumu;
    }

    public boolean getRstCheckYuuyokkngai() {
        return rstCheckYuuyokkngai;
    }

    public void setRstCheckYuuyokkngai(boolean pRstCheckYuuyokkngai) {
        this.rstCheckYuuyokkngai = pRstCheckYuuyokkngai;
    }

    public C_UmuKbn getKykdrtkykhukaumu() {
        return kykdrtkykhukaumu;
    }

    public void setKykdrtkykhukaumu(C_UmuKbn pKykdrtkykhukaumu) {
        kykdrtkykhukaumu = pKykdrtkykhukaumu;
    }

    public C_KykdrknHtdjytKbn getKykdrknhatudoujyoutai() {
        return kykdrknhatudoujyoutai;
    }

    public void setKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn pKykdrknhatudoujyoutai) {
        kykdrknhatudoujyoutai = pKykdrknhatudoujyoutai;
    }

    public C_UmuKbn getTeikishrtkykhukaumu() {
        return teikishrtkykhukaumu;
    }

    public void setTeikishrtkykhukaumu(C_UmuKbn pTeikishrtkykhukaumu) {
        this.teikishrtkykhukaumu = pTeikishrtkykhukaumu;
    }

    public C_TsindousiteiKbn getTrkkzktsindousiteikbn1() {
        return trkkzktsindousiteikbn1;
    }

    public void setTrkkzktsindousiteikbn1(C_TsindousiteiKbn pTrkkzktsindousiteikbn1) {
        trkkzktsindousiteikbn1 = pTrkkzktsindousiteikbn1;
    }

    public C_TsindousiteiKbn getTrkkzktsindousiteikbn2() {
        return trkkzktsindousiteikbn2;
    }

    public void setTrkkzktsindousiteikbn2(C_TsindousiteiKbn pTrkkzktsindousiteikbn2) {
        trkkzktsindousiteikbn2 = pTrkkzktsindousiteikbn2;
    }
}