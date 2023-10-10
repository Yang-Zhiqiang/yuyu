package yuyu.app.hozen.khozen.khseinengappiseiteisei;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
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
import yuyu.common.hozen.khcommon.CheckKouzaChkSoukinsakiKouzaUiBeanParam;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiExecUiBeanParam;
import yuyu.common.hozen.khcommon.KhozenCommonParamGetHituyouSyoruiUiBeanParam;
import yuyu.common.hozen.khview.viewbetukyk.ViewBetukykUiBeanParam;
import yuyu.common.hozen.khview.viewdattai.ViewDattaiUiBeanParam;
import yuyu.common.hozen.khview.viewharaikomiinfo.ViewHaraikomiInfoUiBeanParam;
import yuyu.common.hozen.khview.viewhihokensya.ViewHihokensyaUiBeanParam;
import yuyu.common.hozen.khview.viewhituyousyorui.ViewHituyouSyoruiUiBeanParam;
import yuyu.common.hozen.khview.viewhosyou.ViewHosyouUiBeanParam;
import yuyu.common.hozen.khview.viewkariukekin.ViewKariukekinUiBeanParam;
import yuyu.common.hozen.khview.viewkeiyakusya.ViewKeiyakusyaUiBeanParam;
import yuyu.common.hozen.khview.viewkihon.ViewKihonUiBeanParam;
import yuyu.common.hozen.khview.viewkouzainfo.ViewKouzaInfoUiBeanParam;
import yuyu.common.hozen.khview.viewkyksyadairi.ViewKyksyadairiUiBeanParam;
import yuyu.common.hozen.khview.viewsonotatk.ViewSonotaTkUiBeanParam;
import yuyu.common.hozen.khview.viewtetudukityuui.ViewTetudukityuuiUiBeanParam;
import yuyu.common.hozen.khview.viewtokusin.ViewTokusinUiBeanParam;
import yuyu.common.hozen.khview.viewtrkkazoku.ViewTrkKazokuUiBeanParam;
import yuyu.common.hozen.khview.viewtuusinsaki.ViewTuusinsakiUiBeanParam;
import yuyu.common.hozen.setuibean.KariukekinInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.KikeiyakuInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.NenkinsiharaiInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.PalNenkinsiharaiInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.PalkikeiyakuInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.PalsueokiInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.SetBetukykExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetDattaiExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetHaraikomiInfoExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetHihokensyaExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetHituyouSyoruiExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetHosyouExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetKariukekinExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetKeiyakusyaExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetKhKbnPatternUtilUiBeanParam;
import yuyu.common.hozen.setuibean.SetKihonExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetKouzaInfoExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetKyksyadairiExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetSonotaTkExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetTetudukityuuiExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetTokusinExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuuiExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetTrkKazokuExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetTuusinsakiExecUiBeanParam;
import yuyu.common.hozen.setuibean.TbktInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.TtdktyuuikbnInfoDataSourceBeanCommonParam;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_HyoujiptnKbn;
import yuyu.def.classification.C_KhkinouModeIdKbn;
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.classification.C_KiharaiPseisanNaiyouKbn;
import yuyu.def.classification.C_KihonssyuruiKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_KyktrksKbn;
import yuyu.def.classification.C_NknengkhnkKbn;
import yuyu.def.classification.C_NrhnkKbn;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SoukinsakiKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_TsryrituhendouhanteiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;

import com.google.common.collect.Lists;

/**
 * 被保険者生年月日・性訂正 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class KhSeinengappiSeiTeiseiUiBean extends GenKhSeinengappiSeiTeiseiUiBean implements ViewKihonUiBeanParam,
ViewSyoruiInfoItiranUiBeanParam, ViewTetudukityuuiUiBeanParam, ViewKeiyakusyaUiBeanParam,
ViewTuusinsakiUiBeanParam, ViewHihokensyaUiBeanParam, ViewSonotaTkUiBeanParam, ViewHaraikomiInfoUiBeanParam,
ViewHituyouSyoruiUiBeanParam, ViewKouzaInfoUiBeanParam,
ViewKouteiInfoUiBeanParam, ViewProgressHistoryUiBeanParam, ViewBetukykUiBeanParam,
ViewHosyouUiBeanParam, CheckYuukouJyoutaiExecUiBeanParam,
SetKouteiInfoExecUiBeanParam, SetProgressHistoryExecUiBeanParam, SetBetukykExecUiBeanParam,
SetTetudukityuuiExecUiBeanParam, SetKeiyakusyaExecUiBeanParam, SetTuusinsakiExecUiBeanParam,
SetKihonExecUiBeanParam,
SetSonotaTkExecUiBeanParam, SetHituyouSyoruiExecUiBeanParam, SetHaraikomiInfoExecUiBeanParam,
SetSyoruiInfoItiranExecUiBeanParam,
SetHosyouExecUiBeanParam, SetHihokensyaExecUiBeanParam, CheckKouzaChkSoukinsakiKouzaUiBeanParam,
SetKouzaInfoExecUiBeanParam, SetToriatukaiTyuuiExecUiBeanParam, KhozenCommonParamGetHituyouSyoruiUiBeanParam,
SetKhKbnPatternUtilUiBeanParam, ViewTrkKazokuUiBeanParam, SetTrkKazokuExecUiBeanParam,
ViewKyksyadairiUiBeanParam, SetKyksyadairiExecUiBeanParam, SetTokusinExecUiBeanParam, ViewTokusinUiBeanParam,
SetKariukekinExecUiBeanParam, ViewKariukekinUiBeanParam, SetDattaiExecUiBeanParam, ViewDattaiUiBeanParam {

    private static final long serialVersionUID = 1L;

    @Inject
    private IT_KykKihon kykKihon;

    @Inject
    private BzWorkflowInfo bzWorkflowInfo;

    private String kouteikanriid;

    private C_Sdpd sdpdKbn;

    private String myPageUserId;

    private String myPageLoginId;

    private C_UmuKbn tyouhyoumukbn;

    private String tyouhyoukey;

    private C_NrhnkKbn nrhnkKbn;

    private C_UmuKbn sbhnkumu;

    private C_UmuKbn hhknseiymdHenkouUmu;

    private BizCurrency syuhenkank;

    private BizDate shrymd;

    private BizNumber tumitateriritu;

    private BizCurrency ksntuityouk;

    private BizCurrency ksnhenkank;

    private C_NknengkhnkKbn nknengkhnkKbn;

    private BizCurrency newsyunkgns;

    private Integer syukeikatukisuu;

    private String syorikngnkbn;

    private C_SyorikahiKbn syorikahikbn;

    private C_TsryrituhendouhanteiKbn tsryrituhendouhanteiKbn;

    private String drtencd1;

    private String drtencd2;

    private C_Syuudaikocd hrkinfosyuudaikocd;

    private C_UmuKbn nextkosumu;

    private BizCurrency kihrkp;

    private String hrkinfocreditmeiginmkn;

    private String hrkinfocardkaisyacd;

    private String hhknyno;

    private String hhknadr1kj;

    private String hhknadr2kj;

    private String hhknadr3kj;

    private String hhknadr4kj;

    private String hhkntelno;

    private C_UmuKbn mosuktymdhkumu;

    private BizDate ttdktyuuisetymd;

    private C_KyktrksKbn kyktrkskbn;

    private C_UmuKbn syugannyukyhumu;

    private C_KhnkyhkgbairituKbn syukhnkyhkgbairitukbn;

    private C_UmuKbn syusndkyhkinshrskgnumu;

    private C_UmuKbn syutsnshrgndhjumu;

    private C_UmuKbn syunextkosumu;

    private C_UmuKbn newsyunextkosumu;

    private C_UmuKbn newnextkosumu;

    private String syusyouhncd;

    private Integer syusyouhnsdno;

    private Integer syukyksyouhnrenno;

    private BizDate syuharaimanymd;

    private BizDate syuhknkknmanryouymd;

    private C_UmuKbn syukostratkiumu;

    private C_PmnjtkKbn syupmnjtkkbn;

    private String syuRyourituSdNo;

    private BizNumber syuYoteiRiritu;

    private Integer syuHhknNen;

    private C_Hhknsei syuHhknSei;

    private C_HknkknsmnKbn syuHknKknSmnKbn;

    private Integer syuHknKkn;

    private Integer syuHrkKkn;

    private BizCurrency syuHokenKngk;

    private BizCurrency syuHokenRyou;

    private C_UmuKbn syuHengakuUmu;

    private C_UmuKbn syuTeikiSiharaikinUmu;

    private C_Tuukasyu kykTuukaSyu;

    private C_Tuukasyu rsTuukaSyu;

    private BizDate ryosyuKwsRateKjYMD;

    private BizNumber ryosyuKwsRate;

    private BizDate yenkansanTkyKwsRateYMD;

    private BizNumber yenkansanTkyKwsRate;

    private BizCurrency yenShrgkGoukei;

    private BizDate mosYMD;

    private BizDate kykYmd;

    private C_Hrkkaisuu hrkKaisuu;

    private C_ShrhousiteiKbn shrHouSiteiKbn;

    private C_UmuKbn gsbunritaisyou;

    private C_HyoujiptnKbn kinouHyoujiptnKbn;

    private String[] imageids;

    private List<String> warningMessageIdList;

    private List<String> warningMessageList;

    private C_KhkinouModeIdKbn khkinouModeIdKbn;

    private String syoriKekkaKbnPtnId;

    private C_SyorikekkaKbn zenkaiSyoriKekkaKbn;

    private BizCurrency hrkp;

    private C_UmuKbn targetTkhkUmu;

    private Integer syohinHanteiKbn;

    private C_KihonssyuruiKbn kihonsSyuruiKbn;

    private C_Tuukasyu kyktuukasyu;

    private BizDate fstPnyknYmd;

    private C_HrkkknsmnKbn syuHrkkknSmnKbn;

    private C_Kykjyoutai kykJyoutai;

    private BizCurrency syukykKjnkngk;

    private BizNumber yoteirirituMinHosyouritu;

    private BizDateYM jkiPjytYm;

    private C_UmuKbn ptumitatekinSaikeisanUmu;

    private BizDate tykgoKykOutouYmd;

    private BizDate calcKijyunYmd;

    private BizCurrency seibetuHenkoumaePtmttkngk;

    private BizCurrency sbtHenkoumaeKihrkmPstgk;

    private BizCurrency tyouseimaePtmttkngk;

    private Integer henhrkkkn;

    private BizCurrency shrgkgoukeiKyktuuka;

    private C_UmuKbn tuikahrkkinumu;

    private C_UmuKbn henkankinumu;

    private C_UmuKbn tuikahrkkinnyknumu;

    private List<Integer> tuikahrkkinKrknoList;

    private BizCurrency tuikahrkkinGoukeinykngk;

    private Integer tuikahrkkinInfoDispPattern;

    private C_UmuKbn kajyouukeireumu;

    private BizCurrency kajyouukeirekngk;

    private BizDate tuikahrkkinRyosyuymd;

    private BizDate zeimukwsratekjnymd;

    private BizNumber zeimukwsrate;

    private C_Tuukasyu zeimukyktuukasyu;

    private String denrenno;

    private C_KiharaiPseisanNaiyouKbn kihrkpssnaiyoukbn;

    private BizCurrency kihrkpYenkansanhenkankin;

    private BizCurrency kihrkpYenkansantuityoukin;

    private BizCurrency kihrkpTuityouk;

    private BizDate kihrkpZeimukwsratekjnymd;

    private BizNumber kihrkpZeimukwsrate;

    private BizCurrency shrtuukashrgkgoukei;

    private BizCurrency shrtuukasyushrgkkei;

    private BizCurrency yenshrgkgoukei;

    private BizCurrency yensyushrgkkei;

    private BizDate shrkwsratekjnymd;

    private BizNumber shrkwsrate;

    private C_Hrkkeiro hrkkeiro;

    private Integer dai1hknkkn;

    private BizDate seirituymd;

    private C_SyutkKbn syutkkbn;

    public KhSeinengappiSeiTeiseiUiBean() {
    }

    public IT_KykKihon getKykKihon() {
        return kykKihon;
    }

    public void setKykKihon(IT_KykKihon pKykKihon) {
        this.kykKihon = pKykKihon;
    }

    @Override
    public BzWorkflowInfo getBzWorkflowInfo() {
        return bzWorkflowInfo;
    }

    public void setBzWorkflowInfo(BzWorkflowInfo pBzWorkflowInfo) {
        this.bzWorkflowInfo = pBzWorkflowInfo;
    }

    public String getKouteikanriid() {
        return kouteikanriid;
    }


    public void setKouteikanriid(String pKouteikanriid) {
        kouteikanriid = pKouteikanriid;
    }


    public C_Sdpd getSdpdKbn() {
        return sdpdKbn;
    }


    public void setSdpdKbn(C_Sdpd pSdpdKbn) {
        this.sdpdKbn = pSdpdKbn;
    }

    public String getMyPageUserId() {
        return myPageUserId;
    }

    public void setMyPageUserId(String pMyPageUserId) {
        myPageUserId = pMyPageUserId;
    }

    public String getMyPageLoginId() {
        return myPageLoginId;
    }

    public void setMyPageLoginId(String pMyPageLoginId) {
        myPageLoginId = pMyPageLoginId;
    }

    public String getTyouhyoukey() {
        return tyouhyoukey;
    }

    public void setTyouhyoukey(String pTyouhyoukey) {
        tyouhyoukey = pTyouhyoukey;
    }

    public C_UmuKbn getTyouhyoumukbn() {
        return tyouhyoumukbn;
    }

    public void setTyouhyoumukbn(C_UmuKbn pTyouhyoumukbn) {
        this.tyouhyoumukbn = pTyouhyoumukbn;
    }

    public C_NrhnkKbn getNrhnkKbn() {
        return nrhnkKbn;
    }

    public void setNrhnkKbn(C_NrhnkKbn pNrhnkKbn) {
        this.nrhnkKbn = pNrhnkKbn;
    }

    public C_UmuKbn getSbhnkumu() {
        return sbhnkumu;
    }

    public void setSbhnkumu(C_UmuKbn pSbhnkumu) {
        this.sbhnkumu = pSbhnkumu;
    }

    public C_UmuKbn getHhknseiymdHenkouUmu() {
        return hhknseiymdHenkouUmu;
    }

    public void setHhknseiymdHenkouUmu(C_UmuKbn pHhknseiymdHenkouUmu) {
        hhknseiymdHenkouUmu = pHhknseiymdHenkouUmu;
    }

    public BizCurrency getSyuhenkank() {
        return syuhenkank;
    }

    public void setSyuhenkank(BizCurrency pSyuhenkank) {
        this.syuhenkank = pSyuhenkank;
    }

    @Override
    public BizDate getShrymd() {
        return shrymd;
    }

    @Override
    public void setShrymd(BizDate pShrymd) {
        this.shrymd = pShrymd;
    }

    public BizNumber getTumitateriritu() {
        return tumitateriritu;
    }

    public void setTumitateriritu(BizNumber pTumitateriritu) {
        this.tumitateriritu = pTumitateriritu;
    }

    public BizCurrency getKsntuityouk() {
        return ksntuityouk;
    }

    public void setKsntuityouk(BizCurrency pKsntuityouk) {
        this.ksntuityouk = pKsntuityouk;
    }

    public BizCurrency getKsnhenkank() {
        return ksnhenkank;
    }

    public void setKsnhenkank(BizCurrency pKsnhenkank) {
        this.ksnhenkank = pKsnhenkank;
    }

    public C_NknengkhnkKbn getNknengkhnkKbn() {
        return nknengkhnkKbn;
    }

    public void setNknengkhnkKbn(C_NknengkhnkKbn pNknengkhnkKbn) {
        this.nknengkhnkKbn = pNknengkhnkKbn;
    }

    public BizCurrency getNewsyunkgns() {
        return newsyunkgns;
    }

    public void setNewsyunkgns(BizCurrency pNewsyunkgns) {
        this.newsyunkgns = pNewsyunkgns;
    }

    public Integer getSyukeikatukisuu() {
        return syukeikatukisuu;
    }

    public void setSyukeikatukisuu(Integer pSyukeikatukisuu) {
        this.syukeikatukisuu = pSyukeikatukisuu;
    }

    public String getSyorikngnkbn() {
        return syorikngnkbn;
    }

    public void setSyorikngnkbn(String pSyorikngnkbn) {
        this.syorikngnkbn = pSyorikngnkbn;
    }

    public C_SyorikahiKbn getSyorikahikbn() {
        return syorikahikbn;
    }

    public void setSyorikahikbn(C_SyorikahiKbn pSyorikahikbn) {
        syorikahikbn = pSyorikahikbn;
    }

    public C_TsryrituhendouhanteiKbn getTsryrituhendouhanteiKbn() {
        return tsryrituhendouhanteiKbn;
    }

    public void setTsryrituhendouhanteiKbn(C_TsryrituhendouhanteiKbn pTsryrituhendouhanteiKbn) {
        this.tsryrituhendouhanteiKbn = pTsryrituhendouhanteiKbn;
    }

    public String getDrtencd1() {
        return drtencd1;
    }

    public void setDrtencd1(String pDrtencd1) {
        this.drtencd1 = pDrtencd1;
    }

    public String getDrtencd2() {
        return drtencd2;
    }

    public void setDrtencd2(String pDrtencd2) {
        this.drtencd2 = pDrtencd2;
    }

    public C_UmuKbn getSyugannyukyhumu() {
        return syugannyukyhumu;
    }

    public void setSyugannyukyhumu(C_UmuKbn pSyugannyukyhumu) {
        syugannyukyhumu = pSyugannyukyhumu;
    }

    public C_KhnkyhkgbairituKbn getSyukhnkyhkgbairitukbn() {
        return syukhnkyhkgbairitukbn;
    }

    public void setSyukhnkyhkgbairitukbn(C_KhnkyhkgbairituKbn pSyukhnkyhkgbairitukbn) {
        syukhnkyhkgbairitukbn = pSyukhnkyhkgbairitukbn;
    }

    public C_UmuKbn getSyusndkyhkinshrskgnumu() {
        return syusndkyhkinshrskgnumu;
    }

    public void setSyusndkyhkinshrskgnumu(C_UmuKbn pSyusndkyhkinshrskgnumu) {
        syusndkyhkinshrskgnumu = pSyusndkyhkinshrskgnumu;
    }

    public C_UmuKbn getSyutsnshrgndhjumu() {
        return syutsnshrgndhjumu;
    }

    public void setSyutsnshrgndhjumu(C_UmuKbn pSyutsnshrgndhjumu) {
        syutsnshrgndhjumu = pSyutsnshrgndhjumu;
    }

    public C_UmuKbn getSyunextkosumu() {
        return syunextkosumu;
    }

    public void setSyunextkosumu(C_UmuKbn pSyunextkosumu) {
        syunextkosumu = pSyunextkosumu;
    }

    public C_UmuKbn getNewsyunextkosumu() {
        return newsyunextkosumu;
    }

    public void setNewsyunextkosumu(C_UmuKbn pNewsyunextkosumu) {
        this.newsyunextkosumu = pNewsyunextkosumu;
    }

    public C_UmuKbn getNewnextkosumu() {
        return newnextkosumu;
    }

    public void setNewnextkosumu(C_UmuKbn pNewnextkosumu) {
        newnextkosumu = pNewnextkosumu;
    }

    public String getSyusyouhncd() {
        return syusyouhncd;
    }


    public void setSyusyouhncd(String pSyusyouhncd) {
        syusyouhncd = pSyusyouhncd;
    }

    public Integer getSyusyouhnsdno() {
        return syusyouhnsdno;
    }

    public void setSyusyouhnsdno(Integer pSyusyouhnsdno) {
        syusyouhnsdno = pSyusyouhnsdno;
    }

    public Integer getSyukyksyouhnrenno() {
        return syukyksyouhnrenno;
    }

    public void setSyukyksyouhnrenno(Integer pSyukyksyouhnrenno) {
        syukyksyouhnrenno = pSyukyksyouhnrenno;
    }

    public BizDate getSyuharaimanymd() {
        return syuharaimanymd;
    }

    public void setSyuharaimanymd(BizDate pSyuharaimanymd) {
        syuharaimanymd = pSyuharaimanymd;
    }

    public BizDate getSyuhknkknmanryouymd() {
        return syuhknkknmanryouymd;
    }

    public void setSyuhknkknmanryouymd(BizDate pSyuhknkknmanryouymd) {
        syuhknkknmanryouymd = pSyuhknkknmanryouymd;
    }

    public C_UmuKbn getSyukostratkiumu() {
        return syukostratkiumu;
    }

    public void setSyukostratkiumu(C_UmuKbn pSyukostratkiumu) {
        syukostratkiumu = pSyukostratkiumu;
    }

    public C_PmnjtkKbn getSyupmnjtkkbn() {
        return syupmnjtkkbn;
    }

    public void setSyupmnjtkkbn(C_PmnjtkKbn pSyupmnjtkkbn) {
        syupmnjtkkbn = pSyupmnjtkkbn;
    }

    public String getSyuRyourituSdNo() {
        return syuRyourituSdNo;
    }

    public void setSyuRyourituSdNo(String pSyuRyourituSdNo) {
        syuRyourituSdNo = pSyuRyourituSdNo;
    }

    public BizNumber getSyuYoteiRiritu() {
        return syuYoteiRiritu;
    }

    public void setSyuYoteiRiritu(BizNumber pSyuYoteiRiritu) {
        syuYoteiRiritu = pSyuYoteiRiritu;
    }

    public Integer getSyuHhknNen() {
        return syuHhknNen;
    }

    public void setSyuHhknNen(Integer pSyuHhknNen) {
        syuHhknNen = pSyuHhknNen;
    }

    public C_Hhknsei getSyuHhknSei() {
        return syuHhknSei;
    }

    public void setSyuHhknSei(C_Hhknsei pSyuHhknSei) {
        syuHhknSei = pSyuHhknSei;
    }

    public C_HknkknsmnKbn getSyuHknKknSmnKbn() {
        return syuHknKknSmnKbn;
    }

    public void setSyuHknKknSmnKbn(C_HknkknsmnKbn pSyuHknKknSmnKbn) {
        syuHknKknSmnKbn = pSyuHknKknSmnKbn;
    }

    public Integer getSyuHknKkn() {
        return syuHknKkn;
    }

    public void setSyuHknKkn(Integer pSyuHknKkn) {
        syuHknKkn = pSyuHknKkn;
    }

    public Integer getSyuHrkKkn() {
        return syuHrkKkn;
    }

    public void setSyuHrkKkn(Integer pSyuHrkKkn) {
        syuHrkKkn = pSyuHrkKkn;
    }

    public BizCurrency getSyuHokenKngk() {
        return syuHokenKngk;
    }

    public void setSyuHokenKngk(BizCurrency pSyuHokenKngk) {
        syuHokenKngk = pSyuHokenKngk;
    }

    public BizCurrency getSyuHokenRyou() {
        return syuHokenRyou;
    }

    public void setSyuHokenRyou(BizCurrency pSyuHokenRyou) {
        syuHokenRyou = pSyuHokenRyou;
    }

    public C_UmuKbn getSyuHengakuUmu() {
        return syuHengakuUmu;
    }

    public void setSyuHengakuUmu(C_UmuKbn pSyuHengakuUmu) {
        syuHengakuUmu = pSyuHengakuUmu;
    }

    public C_UmuKbn getSyuTeikiSiharaikinUmu() {
        return syuTeikiSiharaikinUmu;
    }

    public void setSyuTeikiSiharaikinUmu(C_UmuKbn pSyuTeikiSiharaikinUmu) {
        syuTeikiSiharaikinUmu = pSyuTeikiSiharaikinUmu;
    }

    public C_Tuukasyu getKykTuukaSyu() {
        return kykTuukaSyu;
    }

    public void setKykTuukaSyu(C_Tuukasyu pKykTuukaSyu) {
        kykTuukaSyu = pKykTuukaSyu;
    }

    public C_Tuukasyu getRsTuukaSyu() {
        return rsTuukaSyu;
    }

    public void setRsTuukaSyu(C_Tuukasyu pRsTuukaSyu) {
        rsTuukaSyu = pRsTuukaSyu;
    }

    public BizDate getRyosyuKwsRateKjYMD() {
        return ryosyuKwsRateKjYMD;
    }

    public void setRyosyuKwsRateKjYMD(BizDate pRyosyuKwsRateKjYMD) {
        ryosyuKwsRateKjYMD = pRyosyuKwsRateKjYMD;
    }

    public BizNumber getRyosyuKwsRate() {
        return ryosyuKwsRate;
    }

    public void setRyosyuKwsRate(BizNumber pRyosyuKwsRate) {
        ryosyuKwsRate = pRyosyuKwsRate;
    }

    public BizDate getYenkansanTkyKwsRateYMD() {
        return yenkansanTkyKwsRateYMD;
    }

    public void setYenkansanTkyKwsRateYMD(BizDate pYenkansanTkyKwsRateYMD) {
        yenkansanTkyKwsRateYMD = pYenkansanTkyKwsRateYMD;
    }

    public BizNumber getYenkansanTkyKwsRate() {
        return yenkansanTkyKwsRate;
    }

    public void setYenkansanTkyKwsRate(BizNumber pYenkansanTkyKwsRate) {
        yenkansanTkyKwsRate = pYenkansanTkyKwsRate;
    }

    public BizCurrency getYenShrgkGoukei() {
        return yenShrgkGoukei;
    }

    public void setYenShrgkGoukei(BizCurrency pYenShrgkGoukei) {
        yenShrgkGoukei = pYenShrgkGoukei;
    }

    public BizDate getMosYMD() {
        return mosYMD;
    }

    public void setMosYMD(BizDate pMosYMD) {
        mosYMD = pMosYMD;
    }

    public BizDate getKykYmd() {
        return kykYmd;
    }

    public void setKykYmd(BizDate pKykYmd) {
        kykYmd = pKykYmd;
    }

    public C_Hrkkaisuu getHrkKaisuu() {
        return hrkKaisuu;
    }

    public void setHrkKaisuu(C_Hrkkaisuu pHrkKaisuu) {
        hrkKaisuu = pHrkKaisuu;
    }

    public C_ShrhousiteiKbn getShrHouSiteiKbn() {
        return shrHouSiteiKbn;
    }

    public void setShrHouSiteiKbn(C_ShrhousiteiKbn pShrHouSiteiKbn) {
        shrHouSiteiKbn = pShrHouSiteiKbn;
    }

    public C_Syuudaikocd getHrkinfosyuudaikocd() {
        return hrkinfosyuudaikocd;
    }

    @Override
    public C_UmuKbn getNextkosumu() {
        return nextkosumu;
    }

    @Override
    public void setNextkosumu(C_UmuKbn pNextkosumu) {
        nextkosumu = pNextkosumu;
    }

    public BizCurrency getKihrkp() {
        return kihrkp;
    }

    public void setKihrkp(BizCurrency pKihrkp) {
        kihrkp = pKihrkp;

    }

    public void setHrkinfosyuudaikocd(C_Syuudaikocd pHrkinfosyuudaikocd) {
        hrkinfosyuudaikocd = pHrkinfosyuudaikocd;
    }

    public String getHrkinfocreditmeiginmkn() {
        return hrkinfocreditmeiginmkn;
    }

    public void setHrkinfocreditmeiginmkn(String pHrkinfocreditmeiginmkn) {
        hrkinfocreditmeiginmkn = pHrkinfocreditmeiginmkn;

    }

    public String getHrkinfocardkaisyacd() {
        return hrkinfocardkaisyacd;
    }

    public void setHrkinfocardkaisyacd(String pHrkinfocardkaisyacd) {
        hrkinfocardkaisyacd = pHrkinfocardkaisyacd;

    }

    public String getHhknyno() {
        return hhknyno;
    }

    public void setHhknyno(String pHhknyno) {
        hhknyno = pHhknyno;
    }

    public String getHhknadr1kj() {
        return hhknadr1kj;
    }

    public void setHhknadr1kj(String pHhknadr1kj) {
        hhknadr1kj = pHhknadr1kj;
    }

    public String getHhknadr2kj() {
        return hhknadr2kj;
    }

    public void setHhknadr2kj(String pHhknadr2kj) {
        hhknadr2kj = pHhknadr2kj;
    }

    public String getHhknadr3kj() {
        return hhknadr3kj;
    }

    public void setHhknadr3kj(String pHhknadr3kj) {
        hhknadr3kj = pHhknadr3kj;
    }

    public String getHhknadr4kj() {
        return hhknadr4kj;
    }

    public void setHhknadr4kj(String pHhknadr4kj) {
        hhknadr4kj = pHhknadr4kj;
    }

    public String getHhkntelno() {
        return hhkntelno;
    }

    public void setHhkntelno(String pHhkntelno) {
        hhkntelno = pHhkntelno;
    }

    public C_KyktrksKbn getKyktrkskbn() {
        return kyktrkskbn;
    }

    public void setKyktrkskbn(C_KyktrksKbn pKyktrkskbn) {
        kyktrkskbn = pKyktrkskbn;

    }

    public C_UmuKbn getGsbunritaisyou() {
        return gsbunritaisyou;
    }

    public void setGsbunritaisyou(C_UmuKbn pGsbunritaisyou) {
        gsbunritaisyou = pGsbunritaisyou;
    }

    public C_HyoujiptnKbn getKinouHyoujiptnKbn() {
        return kinouHyoujiptnKbn;
    }

    public void setKinouHyoujiptnKbn(C_HyoujiptnKbn pKinouHyoujiptnKbn) {
        kinouHyoujiptnKbn = pKinouHyoujiptnKbn;
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

    @Override
    public KikeiyakuInfoDataSourceBeanCommonParam createKikeiyakuInfoDataSourceBean() {
        return new KikeiyakuInfoDataSourceBean();
    }

    @Override
    public void convertKikeiyakuInfoForCommonParam(List<KikeiyakuInfoDataSourceBeanCommonParam> pKikeiyakuInfo) {
        List<KikeiyakuInfoDataSourceBean> kikeiyakuInfo = Lists.newArrayList();
        for (KikeiyakuInfoDataSourceBeanCommonParam beanParam : pKikeiyakuInfo) {
            kikeiyakuInfo.add((KikeiyakuInfoDataSourceBean) beanParam);
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
            nenkinsiharaiInfo.add((NenkinsiharaiInfoDataSourceBean) beanParam);
        }
        super.setNenkinsiharaiInfo(nenkinsiharaiInfo);
    }

    @Override
    public PalkikeiyakuInfoDataSourceBeanCommonParam createPalkikeiyakuInfoDataSourceBean() {
        return new PalkikeiyakuInfoDataSourceBean();
    }

    @Override
    public void convertPalkikeiyakuInfoForCommonParam(List<PalkikeiyakuInfoDataSourceBeanCommonParam> pPalkikeiyakuInfo) {
        List<PalkikeiyakuInfoDataSourceBean> palkikeiyakuInfo = Lists.newArrayList();
        for (PalkikeiyakuInfoDataSourceBeanCommonParam beanParam : pPalkikeiyakuInfo) {
            palkikeiyakuInfo.add((PalkikeiyakuInfoDataSourceBean) beanParam);
        }
        super.setPalkikeiyakuInfo(palkikeiyakuInfo);
    }

    @Override
    public PalNenkinsiharaiInfoDataSourceBeanCommonParam createPalNenkinsiharaiInfoDataSourceBean() {
        return new PalnenkinsiharaiInfoDataSourceBean();
    }

    @Override
    public void convertPalNenkinsiharaiInfoForCommonParam(
        List<PalNenkinsiharaiInfoDataSourceBeanCommonParam> pPalNenkinsiharaiInfo) {
        List<PalnenkinsiharaiInfoDataSourceBean> palnenkinsiharaiInfo = Lists.newArrayList();
        for (PalNenkinsiharaiInfoDataSourceBeanCommonParam beanParam : pPalNenkinsiharaiInfo) {
            palnenkinsiharaiInfo.add((PalnenkinsiharaiInfoDataSourceBean) beanParam);
        }
        super.setPalnenkinsiharaiInfo(palnenkinsiharaiInfo);
    }

    @Override
    public PalsueokiInfoDataSourceBeanCommonParam createPalsueokiInfoDataSourceBean() {
        return new PalsueokiInfoDataSourceBean();
    }

    @Override
    public void convertPalsueokiInfoForCommonParam(List<PalsueokiInfoDataSourceBeanCommonParam> pPalsueokiInfo) {
        List<PalsueokiInfoDataSourceBean> palnenkinsiharaiInfo = Lists.newArrayList();
        for (PalsueokiInfoDataSourceBeanCommonParam beanParam : pPalsueokiInfo) {
            palnenkinsiharaiInfo.add((PalsueokiInfoDataSourceBean) beanParam);
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
            syoruiInfoList.add((SyoruiInfoListDataSourceBean) beanPram);
        }

        super.setSyoruiInfoList(syoruiInfoList);
    }

    @Override
    public TtdktyuuikbnInfoDataSourceBeanCommonParam createTtdktyuuikbnInfoDataSourceBean() {
        return new TtdktyuuikbnInfoDataSourceBean();
    }

    @Override
    public void convertTtdktyuuikbnInfoForCommonParam(List<TtdktyuuikbnInfoDataSourceBeanCommonParam> pTtdktyuuikbnInfo) {
        List<TtdktyuuikbnInfoDataSourceBean> ttdktyuuikbnInfo = Lists.newArrayList();
        for (TtdktyuuikbnInfoDataSourceBeanCommonParam beanParam : pTtdktyuuikbnInfo) {
            ttdktyuuikbnInfo.add((TtdktyuuikbnInfoDataSourceBean) beanParam);
        }
        super.setTtdktyuuikbnInfo(ttdktyuuikbnInfo);
    }

    @Override
    public ProgressHistoryDataSourceBeanCommonParam createProgressHistoryDataSourceBean() {
        return new ProgresshistoryinfoDataSourceBean();
    }

    @Override
    public void convertProgressHistoryForCommonParam(
        List<ProgressHistoryDataSourceBeanCommonParam> pProgresshistoryinfo) {
        List<ProgresshistoryinfoDataSourceBean> progresshistoryinfo = Lists.newArrayList();

        for (ProgressHistoryDataSourceBeanCommonParam beanPram : pProgresshistoryinfo) {
            progresshistoryinfo.add((ProgresshistoryinfoDataSourceBean) beanPram);
        }

        super.setProgresshistoryinfo(progresshistoryinfo);
    }

    @Override
    public void convertTbktInfoForCommonParam(List<TbktInfoDataSourceBeanCommonParam> pTbktInfo) {
        List<TbktInfoDataSourceBean> tbktInfo = Lists.newArrayList();

        for (TbktInfoDataSourceBeanCommonParam beanPram : pTbktInfo) {
            tbktInfo.add((TbktInfoDataSourceBean) beanPram);
        }

        super.setTbktInfo(tbktInfo);
    }

    @Override
    public TbktInfoDataSourceBeanCommonParam createTbktInfoDataSourceBean() {
        return new TbktInfoDataSourceBean();
    }

    @Override
    public String[] getImageids() {
        return imageids;
    }

    @Override
    public void setImageids(String[] pImageids) {
        imageids = pImageids;
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

    public String getSyoriKekkaKbnPtnId() {
        return syoriKekkaKbnPtnId;
    }

    public void setSyoriKekkaKbnPtnId(String pSyoriKekkaKbnPtnId) {
        syoriKekkaKbnPtnId = pSyoriKekkaKbnPtnId;
    }

    public C_SyorikekkaKbn getZenkaiSyoriKekkaKbn() {
        return zenkaiSyoriKekkaKbn;
    }

    public void setZenkaiSyoriKekkaKbn(C_SyorikekkaKbn pZenkaiSyoriKekkaKbn) {
        zenkaiSyoriKekkaKbn = pZenkaiSyoriKekkaKbn;
    }

    public BizCurrency getHrkp() {
        return hrkp;
    }

    public void setHrkp(BizCurrency pHrkp) {
        hrkp = pHrkp;
    }

    public C_UmuKbn getTargetTkhkUmu() {
        return targetTkhkUmu;
    }

    public void setTargetTkhkUmu(C_UmuKbn pTargetTkhkUmu) {
        targetTkhkUmu = pTargetTkhkUmu;
    }

    public Integer getSyohinHanteiKbn() {
        return syohinHanteiKbn;
    }

    public void setSyohinHanteiKbn(Integer pSyohinHanteiKbn) {
        syohinHanteiKbn = pSyohinHanteiKbn;
    }

    public C_KihonssyuruiKbn getKihonsSyuruiKbn() {
        return kihonsSyuruiKbn;
    }

    public void setKihonsSyuruiKbn(C_KihonssyuruiKbn pKihonsSyuruiKbn) {
        kihonsSyuruiKbn = pKihonsSyuruiKbn;
    }

    @Override
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    @Override
    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private C_UmuKbn vhsyudisptknkhknumu1;

    @Override
    public C_UmuKbn getVhsyudisptknkhknumu1() {
        return vhsyudisptknkhknumu1;
    }

    @Override
    public void setVhsyudisptknkhknumu1(C_UmuKbn pVhsyudisptknkhknumu1) {
        vhsyudisptknkhknumu1 = pVhsyudisptknkhknumu1;
    }

    private C_UmuKbn vhsyudisptknkhknumu2;

    @Override
    public C_UmuKbn getVhsyudisptknkhknumu2() {
        return vhsyudisptknkhknumu2;
    }

    @Override
    public void setVhsyudisptknkhknumu2(C_UmuKbn pVhsyudisptknkhknumu2) {
        vhsyudisptknkhknumu2 = pVhsyudisptknkhknumu2;
    }

    private C_UmuKbn vhsyudisptknkhknumu3;

    @Override
    public C_UmuKbn getVhsyudisptknkhknumu3() {
        return vhsyudisptknkhknumu3;
    }

    @Override
    public void setVhsyudisptknkhknumu3(C_UmuKbn pVhsyudisptknkhknumu3) {
        vhsyudisptknkhknumu3 = pVhsyudisptknkhknumu3;
    }

    private C_UmuKbn vhsyudisptknkhknumu4;

    @Override
    public C_UmuKbn getVhsyudisptknkhknumu4() {
        return vhsyudisptknkhknumu4;
    }

    @Override
    public void setVhsyudisptknkhknumu4(C_UmuKbn pVhsyudisptknkhknumu4) {
        vhsyudisptknkhknumu4 = pVhsyudisptknkhknumu4;
    }

    private C_UmuKbn vhsyudisptknkhknumu5;

    @Override
    public C_UmuKbn getVhsyudisptknkhknumu5() {
        return vhsyudisptknkhknumu5;
    }

    @Override
    public void setVhsyudisptknkhknumu5(C_UmuKbn pVhsyudisptknkhknumu5) {
        vhsyudisptknkhknumu5 = pVhsyudisptknkhknumu5;
    }

    private C_UmuKbn vhsyudisptknkhknumu6;

    @Override
    public C_UmuKbn getVhsyudisptknkhknumu6() {
        return vhsyudisptknkhknumu6;
    }

    @Override
    public void setVhsyudisptknkhknumu6(C_UmuKbn pVhsyudisptknkhknumu6) {
        vhsyudisptknkhknumu6 = pVhsyudisptknkhknumu6;
    }

    private C_UmuKbn vhsyudisptknkhknumu7;

    @Override
    public C_UmuKbn getVhsyudisptknkhknumu7() {
        return vhsyudisptknkhknumu7;
    }

    @Override
    public void setVhsyudisptknkhknumu7(C_UmuKbn pVhsyudisptknkhknumu7) {
        vhsyudisptknkhknumu7 = pVhsyudisptknkhknumu7;
    }

    private C_UmuKbn vhsyudisptknkhknumu8;

    @Override
    public C_UmuKbn getVhsyudisptknkhknumu8() {
        return vhsyudisptknkhknumu8;
    }

    @Override
    public void setVhsyudisptknkhknumu8(C_UmuKbn pVhsyudisptknkhknumu8) {
        vhsyudisptknkhknumu8 = pVhsyudisptknkhknumu8;
    }

    private C_UmuKbn vhsyudisptknkhknumu9;

    @Override
    public C_UmuKbn getVhsyudisptknkhknumu9() {
        return vhsyudisptknkhknumu9;
    }

    @Override
    public void setVhsyudisptknkhknumu9(C_UmuKbn pVhsyudisptknkhknumu9) {
        vhsyudisptknkhknumu9 = pVhsyudisptknkhknumu9;
    }

    private C_UmuKbn vhsyudisptknkhknumu10;

    @Override
    public C_UmuKbn getVhsyudisptknkhknumu10() {
        return vhsyudisptknkhknumu10;
    }

    @Override
    public void setVhsyudisptknkhknumu10(C_UmuKbn pVhsyudisptknkhknumu10) {
        vhsyudisptknkhknumu10 = pVhsyudisptknkhknumu10;
    }

    private C_UmuKbn vhsyudisptknextkosumu1;

    @Override
    public C_UmuKbn getVhsyudisptknextkosumu1() {
        return vhsyudisptknextkosumu1;
    }

    @Override
    public void setVhsyudisptknextkosumu1(C_UmuKbn pVhsyudisptknextkosumu1) {
        vhsyudisptknextkosumu1 = pVhsyudisptknextkosumu1;
    }

    private C_UmuKbn vhsyudisptknextkosumu2;

    @Override
    public C_UmuKbn getVhsyudisptknextkosumu2() {
        return vhsyudisptknextkosumu2;
    }

    @Override
    public void setVhsyudisptknextkosumu2(C_UmuKbn pVhsyudisptknextkosumu2) {
        vhsyudisptknextkosumu2 = pVhsyudisptknextkosumu2;
    }

    private C_UmuKbn vhsyudisptknextkosumu3;

    @Override
    public C_UmuKbn getVhsyudisptknextkosumu3() {
        return vhsyudisptknextkosumu3;
    }

    @Override
    public void setVhsyudisptknextkosumu3(C_UmuKbn pVhsyudisptknextkosumu3) {
        vhsyudisptknextkosumu3 = pVhsyudisptknextkosumu3;
    }

    private C_UmuKbn vhsyudisptknextkosumu4;

    @Override
    public C_UmuKbn getVhsyudisptknextkosumu4() {
        return vhsyudisptknextkosumu4;
    }

    @Override
    public void setVhsyudisptknextkosumu4(C_UmuKbn pVhsyudisptknextkosumu4) {
        vhsyudisptknextkosumu4 = pVhsyudisptknextkosumu4;
    }

    private C_UmuKbn vhsyudisptknextkosumu5;

    @Override
    public C_UmuKbn getVhsyudisptknextkosumu5() {
        return vhsyudisptknextkosumu5;
    }

    @Override
    public void setVhsyudisptknextkosumu5(C_UmuKbn pVhsyudisptknextkosumu5) {
        vhsyudisptknextkosumu5 = pVhsyudisptknextkosumu5;
    }

    private C_UmuKbn vhsyudisptknextkosumu6;

    @Override
    public C_UmuKbn getVhsyudisptknextkosumu6() {
        return vhsyudisptknextkosumu6;
    }

    @Override
    public void setVhsyudisptknextkosumu6(C_UmuKbn pVhsyudisptknextkosumu6) {
        vhsyudisptknextkosumu6 = pVhsyudisptknextkosumu6;
    }

    private C_UmuKbn vhsyudisptknextkosumu7;

    @Override
    public C_UmuKbn getVhsyudisptknextkosumu7() {
        return vhsyudisptknextkosumu7;
    }

    @Override
    public void setVhsyudisptknextkosumu7(C_UmuKbn pVhsyudisptknextkosumu7) {
        vhsyudisptknextkosumu7 = pVhsyudisptknextkosumu7;
    }

    private C_UmuKbn vhsyudisptknextkosumu8;

    @Override
    public C_UmuKbn getVhsyudisptknextkosumu8() {
        return vhsyudisptknextkosumu8;
    }

    @Override
    public void setVhsyudisptknextkosumu8(C_UmuKbn pVhsyudisptknextkosumu8) {
        vhsyudisptknextkosumu8 = pVhsyudisptknextkosumu8;
    }

    private C_UmuKbn vhsyudisptknextkosumu9;

    @Override
    public C_UmuKbn getVhsyudisptknextkosumu9() {
        return vhsyudisptknextkosumu9;
    }

    @Override
    public void setVhsyudisptknextkosumu9(C_UmuKbn pVhsyudisptknextkosumu9) {
        vhsyudisptknextkosumu9 = pVhsyudisptknextkosumu9;
    }

    private C_UmuKbn vhsyudisptknextkosumu10;

    @Override
    public C_UmuKbn getVhsyudisptknextkosumu10() {
        return vhsyudisptknextkosumu10;
    }

    @Override
    public void setVhsyudisptknextkosumu10(C_UmuKbn pVhsyudisptknextkosumu10) {
        vhsyudisptknextkosumu10 = pVhsyudisptknextkosumu10;
    }

    private C_KhnkyhkgbairituKbn vhsyudisptkkgbairitukbn1;

    @Override
    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn1() {
        return vhsyudisptkkgbairitukbn1;
    }

    @Override
    public void setVhsyudisptkkgbairitukbn1(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn1) {
        vhsyudisptkkgbairitukbn1 = pVhsyudisptkkgbairitukbn1;
    }

    private C_KhnkyhkgbairituKbn vhsyudisptkkgbairitukbn2;

    @Override
    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn2() {
        return vhsyudisptkkgbairitukbn2;
    }

    @Override
    public void setVhsyudisptkkgbairitukbn2(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn2) {
        vhsyudisptkkgbairitukbn2 = pVhsyudisptkkgbairitukbn2;
    }

    private C_KhnkyhkgbairituKbn vhsyudisptkkgbairitukbn3;

    @Override
    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn3() {
        return vhsyudisptkkgbairitukbn3;
    }

    @Override
    public void setVhsyudisptkkgbairitukbn3(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn3) {
        vhsyudisptkkgbairitukbn3 = pVhsyudisptkkgbairitukbn3;
    }

    private C_KhnkyhkgbairituKbn vhsyudisptkkgbairitukbn4;

    @Override
    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn4() {
        return vhsyudisptkkgbairitukbn4;
    }

    @Override
    public void setVhsyudisptkkgbairitukbn4(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn4) {
        vhsyudisptkkgbairitukbn4 = pVhsyudisptkkgbairitukbn4;
    }

    private C_KhnkyhkgbairituKbn vhsyudisptkkgbairitukbn5;

    @Override
    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn5() {
        return vhsyudisptkkgbairitukbn5;
    }

    @Override
    public void setVhsyudisptkkgbairitukbn5(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn5) {
        vhsyudisptkkgbairitukbn5 = pVhsyudisptkkgbairitukbn5;
    }

    private C_KhnkyhkgbairituKbn vhsyudisptkkgbairitukbn6;

    @Override
    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn6() {
        return vhsyudisptkkgbairitukbn6;
    }

    @Override
    public void setVhsyudisptkkgbairitukbn6(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn6) {
        vhsyudisptkkgbairitukbn6 = pVhsyudisptkkgbairitukbn6;
    }

    private C_KhnkyhkgbairituKbn vhsyudisptkkgbairitukbn7;

    @Override
    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn7() {
        return vhsyudisptkkgbairitukbn7;
    }

    @Override
    public void setVhsyudisptkkgbairitukbn7(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn7) {
        vhsyudisptkkgbairitukbn7 = pVhsyudisptkkgbairitukbn7;
    }

    private C_KhnkyhkgbairituKbn vhsyudisptkkgbairitukbn8;

    @Override
    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn8() {
        return vhsyudisptkkgbairitukbn8;
    }

    @Override
    public void setVhsyudisptkkgbairitukbn8(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn8) {
        vhsyudisptkkgbairitukbn8 = pVhsyudisptkkgbairitukbn8;
    }

    private C_KhnkyhkgbairituKbn vhsyudisptkkgbairitukbn9;

    @Override
    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn9() {
        return vhsyudisptkkgbairitukbn9;
    }

    @Override
    public void setVhsyudisptkkgbairitukbn9(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn9) {
        vhsyudisptkkgbairitukbn9 = pVhsyudisptkkgbairitukbn9;
    }

    private C_KhnkyhkgbairituKbn vhsyudisptkkgbairitukbn10;

    @Override
    public C_KhnkyhkgbairituKbn getVhsyudisptkkgbairitukbn10() {
        return vhsyudisptkkgbairitukbn10;
    }

    @Override
    public void setVhsyudisptkkgbairitukbn10(C_KhnkyhkgbairituKbn pVhsyudisptkkgbairitukbn10) {
        vhsyudisptkkgbairitukbn10 = pVhsyudisptkkgbairitukbn10;
    }

    private C_UmuKbn vhsyudisptksndkyhkinshrskgnumu1;

    @Override
    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu1() {
        return vhsyudisptksndkyhkinshrskgnumu1;
    }

    @Override
    public void setVhsyudisptksndkyhkinshrskgnumu1(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu1) {
        vhsyudisptksndkyhkinshrskgnumu1 = pVhsyudisptksndkyhkinshrskgnumu1;
    }

    private C_UmuKbn vhsyudisptksndkyhkinshrskgnumu2;

    @Override
    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu2() {
        return vhsyudisptksndkyhkinshrskgnumu2;
    }

    @Override
    public void setVhsyudisptksndkyhkinshrskgnumu2(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu2) {
        vhsyudisptksndkyhkinshrskgnumu2 = pVhsyudisptksndkyhkinshrskgnumu2;
    }

    private C_UmuKbn vhsyudisptksndkyhkinshrskgnumu3;

    @Override
    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu3() {
        return vhsyudisptksndkyhkinshrskgnumu3;
    }

    @Override
    public void setVhsyudisptksndkyhkinshrskgnumu3(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu3) {
        vhsyudisptksndkyhkinshrskgnumu3 = pVhsyudisptksndkyhkinshrskgnumu3;
    }

    private C_UmuKbn vhsyudisptksndkyhkinshrskgnumu4;

    @Override
    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu4() {
        return vhsyudisptksndkyhkinshrskgnumu4;
    }

    @Override
    public void setVhsyudisptksndkyhkinshrskgnumu4(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu4) {
        vhsyudisptksndkyhkinshrskgnumu4 = pVhsyudisptksndkyhkinshrskgnumu4;
    }

    private C_UmuKbn vhsyudisptksndkyhkinshrskgnumu5;

    @Override
    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu5() {
        return vhsyudisptksndkyhkinshrskgnumu5;
    }

    @Override
    public void setVhsyudisptksndkyhkinshrskgnumu5(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu5) {
        vhsyudisptksndkyhkinshrskgnumu5 = pVhsyudisptksndkyhkinshrskgnumu5;
    }

    private C_UmuKbn vhsyudisptksndkyhkinshrskgnumu6;

    @Override
    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu6() {
        return vhsyudisptksndkyhkinshrskgnumu6;
    }

    @Override
    public void setVhsyudisptksndkyhkinshrskgnumu6(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu6) {
        vhsyudisptksndkyhkinshrskgnumu6 = pVhsyudisptksndkyhkinshrskgnumu6;
    }

    private C_UmuKbn vhsyudisptksndkyhkinshrskgnumu7;

    @Override
    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu7() {
        return vhsyudisptksndkyhkinshrskgnumu7;
    }

    @Override
    public void setVhsyudisptksndkyhkinshrskgnumu7(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu7) {
        vhsyudisptksndkyhkinshrskgnumu7 = pVhsyudisptksndkyhkinshrskgnumu7;
    }

    private C_UmuKbn vhsyudisptksndkyhkinshrskgnumu8;

    @Override
    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu8() {
        return vhsyudisptksndkyhkinshrskgnumu8;
    }

    @Override
    public void setVhsyudisptksndkyhkinshrskgnumu8(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu8) {
        vhsyudisptksndkyhkinshrskgnumu8 = pVhsyudisptksndkyhkinshrskgnumu8;
    }

    private C_UmuKbn vhsyudisptksndkyhkinshrskgnumu9;

    @Override
    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu9() {
        return vhsyudisptksndkyhkinshrskgnumu9;
    }

    @Override
    public void setVhsyudisptksndkyhkinshrskgnumu9(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu9) {
        vhsyudisptksndkyhkinshrskgnumu9 = pVhsyudisptksndkyhkinshrskgnumu9;
    }

    private C_UmuKbn vhsyudisptksndkyhkinshrskgnumu10;

    @Override
    public C_UmuKbn getVhsyudisptksndkyhkinshrskgnumu10() {
        return vhsyudisptksndkyhkinshrskgnumu10;
    }

    @Override
    public void setVhsyudisptksndkyhkinshrskgnumu10(C_UmuKbn pVhsyudisptksndkyhkinshrskgnumu10) {
        vhsyudisptksndkyhkinshrskgnumu10 = pVhsyudisptksndkyhkinshrskgnumu10;
    }

    private C_KhnkyhkgbairituKbn vhsyusyukhnkyhkgbairitukbn;

    @Override
    public C_KhnkyhkgbairituKbn getVhsyusyukhnkyhkgbairitukbn() {
        return vhsyusyukhnkyhkgbairitukbn;
    }

    @Override
    public void setVhsyusyukhnkyhkgbairitukbn(C_KhnkyhkgbairituKbn pVhsyusyukhnkyhkgbairitukbn) {
        vhsyusyukhnkyhkgbairitukbn = pVhsyusyukhnkyhkgbairitukbn;
    }

    private C_UmuKbn vhsyudisptktsnshrgndhjumu1;

    @Override
    public C_UmuKbn getVhsyudisptktsnshrgndhjumu1() {
        return vhsyudisptktsnshrgndhjumu1;
    }

    @Override
    public void setVhsyudisptktsnshrgndhjumu1(C_UmuKbn pVhsyudisptktsnshrgndhjumu1) {
        vhsyudisptktsnshrgndhjumu1 = pVhsyudisptktsnshrgndhjumu1;
    }

    private C_UmuKbn vhsyudisptktsnshrgndhjumu2;

    @Override
    public C_UmuKbn getVhsyudisptktsnshrgndhjumu2() {
        return vhsyudisptktsnshrgndhjumu2;
    }

    @Override
    public void setVhsyudisptktsnshrgndhjumu2(C_UmuKbn pVhsyudisptktsnshrgndhjumu2) {
        vhsyudisptktsnshrgndhjumu2 = pVhsyudisptktsnshrgndhjumu2;
    }

    private C_UmuKbn vhsyudisptktsnshrgndhjumu3;

    @Override
    public C_UmuKbn getVhsyudisptktsnshrgndhjumu3() {
        return vhsyudisptktsnshrgndhjumu3;
    }

    @Override
    public void setVhsyudisptktsnshrgndhjumu3(C_UmuKbn pVhsyudisptktsnshrgndhjumu3) {
        vhsyudisptktsnshrgndhjumu3 = pVhsyudisptktsnshrgndhjumu3;
    }

    private C_UmuKbn vhsyudisptktsnshrgndhjumu4;

    @Override
    public C_UmuKbn getVhsyudisptktsnshrgndhjumu4() {
        return vhsyudisptktsnshrgndhjumu4;
    }

    @Override
    public void setVhsyudisptktsnshrgndhjumu4(C_UmuKbn pVhsyudisptktsnshrgndhjumu4) {
        vhsyudisptktsnshrgndhjumu4 = pVhsyudisptktsnshrgndhjumu4;
    }

    private C_UmuKbn vhsyudisptktsnshrgndhjumu5;

    @Override
    public C_UmuKbn getVhsyudisptktsnshrgndhjumu5() {
        return vhsyudisptktsnshrgndhjumu5;
    }

    @Override
    public void setVhsyudisptktsnshrgndhjumu5(C_UmuKbn pVhsyudisptktsnshrgndhjumu5) {
        vhsyudisptktsnshrgndhjumu5 = pVhsyudisptktsnshrgndhjumu5;
    }

    private C_UmuKbn vhsyudisptktsnshrgndhjumu6;

    @Override
    public C_UmuKbn getVhsyudisptktsnshrgndhjumu6() {
        return vhsyudisptktsnshrgndhjumu6;
    }

    @Override
    public void setVhsyudisptktsnshrgndhjumu6(C_UmuKbn pVhsyudisptktsnshrgndhjumu6) {
        vhsyudisptktsnshrgndhjumu6 = pVhsyudisptktsnshrgndhjumu6;
    }

    private C_UmuKbn vhsyudisptktsnshrgndhjumu7;

    @Override
    public C_UmuKbn getVhsyudisptktsnshrgndhjumu7() {
        return vhsyudisptktsnshrgndhjumu7;
    }

    @Override
    public void setVhsyudisptktsnshrgndhjumu7(C_UmuKbn pVhsyudisptktsnshrgndhjumu7) {
        vhsyudisptktsnshrgndhjumu7 = pVhsyudisptktsnshrgndhjumu7;
    }

    private C_UmuKbn vhsyudisptktsnshrgndhjumu8;

    @Override
    public C_UmuKbn getVhsyudisptktsnshrgndhjumu8() {
        return vhsyudisptktsnshrgndhjumu8;
    }

    @Override
    public void setVhsyudisptktsnshrgndhjumu8(C_UmuKbn pVhsyudisptktsnshrgndhjumu8) {
        vhsyudisptktsnshrgndhjumu8 = pVhsyudisptktsnshrgndhjumu8;
    }

    private C_UmuKbn vhsyudisptktsnshrgndhjumu9;

    @Override
    public C_UmuKbn getVhsyudisptktsnshrgndhjumu9() {
        return vhsyudisptktsnshrgndhjumu9;
    }

    @Override
    public void setVhsyudisptktsnshrgndhjumu9(C_UmuKbn pVhsyudisptktsnshrgndhjumu9) {
        vhsyudisptktsnshrgndhjumu9 = pVhsyudisptktsnshrgndhjumu9;
    }

    private C_UmuKbn vhsyudisptktsnshrgndhjumu10;

    @Override
    public C_UmuKbn getVhsyudisptktsnshrgndhjumu10() {
        return vhsyudisptktsnshrgndhjumu10;
    }

    @Override
    public void setVhsyudisptktsnshrgndhjumu10(C_UmuKbn pVhsyudisptktsnshrgndhjumu10) {
        vhsyudisptktsnshrgndhjumu10 = pVhsyudisptktsnshrgndhjumu10;
    }

    private C_UmuKbn vhsyunstkhukaumukbn;

    @Override
    public C_UmuKbn getVhsyunstkhukaumukbn() {
        return vhsyunstkhukaumukbn;
    }

    @Override
    public void setVhsyunstkhukaumukbn(C_UmuKbn pVhsyunstkhukaumukbn) {
        vhsyunstkhukaumukbn = pVhsyunstkhukaumukbn;
    }

    private C_UmuKbn vhsyuddisptkgannyukyhumu1;

    @Override
    public C_UmuKbn getVhsyudisptkgannyukyhumu1() {
        return vhsyuddisptkgannyukyhumu1;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu1(C_UmuKbn pVhsyudisptkgannyukyhumu1) {
        vhsyuddisptkgannyukyhumu1 = pVhsyudisptkgannyukyhumu1;
    }

    private C_UmuKbn vhsyudisptkgannyukyhumu2;

    @Override
    public C_UmuKbn getVhsyudisptkgannyukyhumu2() {
        return vhsyudisptkgannyukyhumu2;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu2(C_UmuKbn pVhsyudisptkgannyukyhumu2) {
        vhsyudisptkgannyukyhumu2 = pVhsyudisptkgannyukyhumu2;
    }

    private C_UmuKbn vhsyudisptkgannyukyhumu3;

    @Override
    public C_UmuKbn getVhsyudisptkgannyukyhumu3() {
        return vhsyudisptkgannyukyhumu3;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu3(C_UmuKbn pVhsyudisptkgannyukyhumu3) {
        vhsyudisptkgannyukyhumu3 = pVhsyudisptkgannyukyhumu3;
    }

    private C_UmuKbn vhsyuddisptkgannyukyhumu4;

    @Override
    public C_UmuKbn getVhsyudisptkgannyukyhumu4() {
        return vhsyuddisptkgannyukyhumu4;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu4(C_UmuKbn pVhsyudisptkgannyukyhumu4) {
        vhsyuddisptkgannyukyhumu4 = pVhsyudisptkgannyukyhumu4;
    }

    private C_UmuKbn vhsyuddisptkgannyukyhumu5;

    @Override
    public C_UmuKbn getVhsyudisptkgannyukyhumu5() {
        return vhsyuddisptkgannyukyhumu5;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu5(C_UmuKbn pVhsyudisptkgannyukyhumu5) {
        vhsyuddisptkgannyukyhumu5 = pVhsyudisptkgannyukyhumu5;
    }

    private C_UmuKbn vhsyudisptkgannyukyhumu6;

    @Override
    public C_UmuKbn getVhsyudisptkgannyukyhumu6() {
        return vhsyudisptkgannyukyhumu6;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu6(C_UmuKbn pVhsyudisptkgannyukyhumu6) {
        vhsyudisptkgannyukyhumu6 = pVhsyudisptkgannyukyhumu6;
    }

    private C_UmuKbn vhsyuddisptkgannyukyhumu7;

    @Override
    public C_UmuKbn getVhsyudisptkgannyukyhumu7() {
        return vhsyuddisptkgannyukyhumu7;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu7(C_UmuKbn pVhsyudisptkgannyukyhumu7) {
        vhsyuddisptkgannyukyhumu7 = pVhsyudisptkgannyukyhumu7;
    }

    private C_UmuKbn vhsyuddisptkgannyukyhumu8;

    @Override
    public C_UmuKbn getVhsyudisptkgannyukyhumu8() {
        return vhsyuddisptkgannyukyhumu8;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu8(C_UmuKbn pVhsyudisptkgannyukyhumu8) {
        vhsyuddisptkgannyukyhumu8 = pVhsyudisptkgannyukyhumu8;
    }

    private C_UmuKbn vhsyuddisptkgannyukyhumu9;

    @Override
    public C_UmuKbn getVhsyudisptkgannyukyhumu9() {
        return vhsyuddisptkgannyukyhumu9;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu9(C_UmuKbn pVhsyudisptkgannyukyhumu9) {
        vhsyuddisptkgannyukyhumu9 = pVhsyudisptkgannyukyhumu9;
    }

    private C_UmuKbn vhsyuddisptkgannyukyhumu10;

    @Override
    public C_UmuKbn getVhsyudisptkgannyukyhumu10() {
        return vhsyuddisptkgannyukyhumu10;
    }

    @Override
    public void setVhsyudisptkgannyukyhumu10(C_UmuKbn pVhsyudisptkgannyukyhumu10) {
        vhsyuddisptkgannyukyhumu10 = pVhsyudisptkgannyukyhumu10;
    }

    private C_UmuKbn vhsyuddisptkhghkumu1;

    @Override
    public C_UmuKbn getVhsyudisptkhghkumu1() {
        return vhsyuddisptkhghkumu1;
    }

    @Override
    public void setVhsyudisptkhghkumu1(C_UmuKbn pVhsyudisptkhghkumu1) {
        vhsyuddisptkhghkumu1 = pVhsyudisptkhghkumu1;
    }

    private C_UmuKbn vhsyudisptkhghkumu2;

    @Override
    public C_UmuKbn getVhsyudisptkhghkumu2() {
        return vhsyudisptkhghkumu2;
    }

    @Override
    public void setVhsyudisptkhghkumu2(C_UmuKbn pVhsyudisptkhghkumu2) {
        vhsyudisptkhghkumu2 = pVhsyudisptkhghkumu2;
    }

    private C_UmuKbn vhsyudisptkhghkumu3;

    @Override
    public C_UmuKbn getVhsyudisptkhghkumu3() {
        return vhsyudisptkhghkumu3;
    }

    @Override
    public void setVhsyudisptkhghkumu3(C_UmuKbn pVhsyudisptkhghkumu3) {
        vhsyudisptkhghkumu3 = pVhsyudisptkhghkumu3;
    }

    private C_UmuKbn vhsyuddisptkhghkumu4;

    @Override
    public C_UmuKbn getVhsyudisptkhghkumu4() {
        return vhsyuddisptkhghkumu4;
    }

    @Override
    public void setVhsyudisptkhghkumu4(C_UmuKbn pVhsyudisptkhghkumu4) {
        vhsyuddisptkhghkumu4 = pVhsyudisptkhghkumu4;
    }

    private C_UmuKbn vhsyuddisptkhghkumu5;

    @Override
    public C_UmuKbn getVhsyudisptkhghkumu5() {
        return vhsyuddisptkhghkumu5;
    }

    @Override
    public void setVhsyudisptkhghkumu5(C_UmuKbn pVhsyudisptkhghkumu5) {
        vhsyuddisptkhghkumu5 = pVhsyudisptkhghkumu5;
    }

    private C_UmuKbn vhsyudisptkhghkumu6;

    @Override
    public C_UmuKbn getVhsyudisptkhghkumu6() {
        return vhsyudisptkhghkumu6;
    }

    @Override
    public void setVhsyudisptkhghkumu6(C_UmuKbn pVhsyudisptkhghkumu6) {
        vhsyudisptkhghkumu6 = pVhsyudisptkhghkumu6;
    }

    private C_UmuKbn vhsyudisptkhghkumu7;

    @Override
    public C_UmuKbn getVhsyudisptkhghkumu7() {
        return vhsyudisptkhghkumu7;
    }

    @Override
    public void setVhsyudisptkhghkumu7(C_UmuKbn pVhsyudisptkhghkumu7) {
        vhsyudisptkhghkumu7 = pVhsyudisptkhghkumu7;
    }

    private C_UmuKbn vhsyuddisptkhghkumu8;

    @Override
    public C_UmuKbn getVhsyudisptkhghkumu8() {
        return vhsyuddisptkhghkumu8;
    }

    @Override
    public void setVhsyudisptkhghkumu8(C_UmuKbn pVhsyudisptkhghkumu8) {
        vhsyuddisptkhghkumu8 = pVhsyudisptkhghkumu8;
    }

    private C_UmuKbn vhsyudisptkhghkumu9;

    @Override
    public C_UmuKbn getVhsyudisptkhghkumu9() {
        return vhsyudisptkhghkumu9;
    }

    @Override
    public void setVhsyudisptkhghkumu9(C_UmuKbn pVhsyudisptkhghkumu9) {
        vhsyudisptkhghkumu9 = pVhsyudisptkhghkumu9;
    }

    private C_UmuKbn vhsyuddisptkhghkumu10;

    @Override
    public C_UmuKbn getVhsyudisptkhghkumu10() {
        return vhsyuddisptkhghkumu10;
    }

    @Override
    public void setVhsyudisptkhghkumu10(C_UmuKbn pVhsyudisptkhghkumu10) {
        vhsyuddisptkhghkumu10 = pVhsyudisptkhghkumu10;
    }

    private String vhsyudisptksyouhncd1;

    @Override
    public String getVhsyudisptksyouhncd1() {
        return vhsyudisptksyouhncd1;
    }

    @Override
    public void setVhsyudisptksyouhncd1(String pVhsyudisptksyouhncd1) {
        vhsyudisptksyouhncd1 = pVhsyudisptksyouhncd1;
    }

    private String vhsyudisptksyouhncd2;

    @Override
    public String getVhsyudisptksyouhncd2() {
        return vhsyudisptksyouhncd2;
    }

    @Override
    public void setVhsyudisptksyouhncd2(String pVhsyudisptksyouhncd2) {
        vhsyudisptksyouhncd2 = pVhsyudisptksyouhncd2;
    }

    private String vhsyudisptksyouhncd3;

    @Override
    public String getVhsyudisptksyouhncd3() {
        return vhsyudisptksyouhncd3;
    }

    @Override
    public void setVhsyudisptksyouhncd3(String pVhsyudisptksyouhncd3) {
        vhsyudisptksyouhncd3 = pVhsyudisptksyouhncd3;
    }

    private String vhsyudisptksyouhncd4;

    @Override
    public String getVhsyudisptksyouhncd4() {
        return vhsyudisptksyouhncd4;
    }

    @Override
    public void setVhsyudisptksyouhncd4(String pVhsyudisptksyouhncd4) {
        vhsyudisptksyouhncd4 = pVhsyudisptksyouhncd4;
    }

    private String vhsyudisptksyouhncd5;

    @Override
    public String getVhsyudisptksyouhncd5() {
        return vhsyudisptksyouhncd5;
    }

    @Override
    public void setVhsyudisptksyouhncd5(String pVhsyudisptksyouhncd5) {
        vhsyudisptksyouhncd5 = pVhsyudisptksyouhncd5;
    }

    private String vhsyudisptksyouhncd6;

    @Override
    public String getVhsyudisptksyouhncd6() {
        return vhsyudisptksyouhncd6;
    }

    @Override
    public void setVhsyudisptksyouhncd6(String pVhsyudisptksyouhncd6) {
        vhsyudisptksyouhncd6 = pVhsyudisptksyouhncd6;
    }

    private String vhsyudisptksyouhncd7;

    @Override
    public String getVhsyudisptksyouhncd7() {
        return vhsyudisptksyouhncd7;
    }

    @Override
    public void setVhsyudisptksyouhncd7(String pVhsyudisptksyouhncd7) {
        vhsyudisptksyouhncd7 = pVhsyudisptksyouhncd7;
    }

    private String vhsyudisptksyouhncd8;

    @Override
    public String getVhsyudisptksyouhncd8() {
        return vhsyudisptksyouhncd8;
    }

    @Override
    public void setVhsyudisptksyouhncd8(String pVhsyudisptksyouhncd8) {
        vhsyudisptksyouhncd8 = pVhsyudisptksyouhncd8;
    }

    private String vhsyudisptksyouhncd9;

    @Override
    public String getVhsyudisptksyouhncd9() {
        return vhsyudisptksyouhncd9;
    }

    @Override
    public void setVhsyudisptksyouhncd9(String pVhsyudisptksyouhncd9) {
        vhsyudisptksyouhncd9 = pVhsyudisptksyouhncd9;
    }

    private String vhsyudisptksyouhncd10;

    @Override
    public String getVhsyudisptksyouhncd10() {
        return vhsyudisptksyouhncd10;
    }

    @Override
    public void setVhsyudisptksyouhncd10(String pVhsyudisptksyouhncd10) {
        vhsyudisptksyouhncd10 = pVhsyudisptksyouhncd10;
    }

    private C_UmuKbn vhsyusyuhghkumu;

    @Override
    public C_UmuKbn getVhsyusyuhghkumu() {
        return vhsyusyuhghkumu;
    }

    @Override
    public void setVhsyusyuhghkumu(C_UmuKbn pVhsyusyuhghkumu) {
        vhsyusyuhghkumu = pVhsyusyuhghkumu;
    }

    private C_UmuKbn vhsyusyunextkosumu;

    @Override
    public C_UmuKbn getVhsyusyunextkosumu() {
        return vhsyusyunextkosumu;
    }

    @Override
    public void setVhsyusyunextkosumu(C_UmuKbn pVhsyusyunextkosumu) {
        vhsyusyunextkosumu = pVhsyusyunextkosumu;
    }

    private C_UmuKbn vhsyusyugannyukyhumu;

    @Override
    public C_UmuKbn getVhsyusyugannyukyhumu() {
        return vhsyusyugannyukyhumu;
    }

    @Override
    public void setVhsyusyugannyukyhumu(C_UmuKbn pVhsyusyugannyukyhumu) {
        vhsyusyugannyukyhumu = pVhsyusyugannyukyhumu;
    }

    private C_UmuKbn vhsyusyutsnshrgndhjumu;

    @Override
    public C_UmuKbn getVhsyusyutsnshrgndhjumu() {
        return vhsyusyutsnshrgndhjumu;
    }

    @Override
    public void setVhsyusyutsnshrgndhjumu(C_UmuKbn pVhsyusyutsnshrgndhjumu) {
        vhsyusyutsnshrgndhjumu = pVhsyusyutsnshrgndhjumu;
    }

    private C_UmuKbn vhsyusyunkhknumu;

    @Override
    public C_UmuKbn getVhsyusyunkhknumu() {
        return vhsyusyunkhknumu;
    }

    @Override
    public void setVhsyusyunkhknumu(C_UmuKbn pVhsyusyunkhknumu) {
        vhsyusyunkhknumu = pVhsyusyunkhknumu;
    }

    private C_UmuKbn vhsyusyusndkyhkinshrskgnumu;

    @Override
    public C_UmuKbn getVhsyusyusndkyhkinshrskgnumu() {
        return vhsyusyusndkyhkinshrskgnumu;
    }

    @Override
    public void setVhsyusyusndkyhkinshrskgnumu(C_UmuKbn pVhsyusyusndkyhkinshrskgnumu) {
        vhsyusyusndkyhkinshrskgnumu = pVhsyusyusndkyhkinshrskgnumu;
    }

    private C_UmuKbn vhsyudai1hknkknsbsyokuseiumu;

    @Override
    public C_UmuKbn getVhsyudai1hknkknsbsyokuseiumu() {
        return vhsyudai1hknkknsbsyokuseiumu;
    }

    @Override
    public void setVhsyudai1hknkknsbsyokuseiumu(C_UmuKbn pVhsyudai1hknkknsbsyokuseiumu) {
        vhsyudai1hknkknsbsyokuseiumu = pVhsyudai1hknkknsbsyokuseiumu;
    }

    private C_HknKknKbn vhsyuhknKknKbn;

    @Override
    public C_HknKknKbn getVhsyuhknKknKbn() {
        return vhsyuhknKknKbn;
    }

    @Override
    public void setVhsyuhknKknKbn(C_HknKknKbn pVhsyuhknKknKbn) {
        vhsyuhknKknKbn = pVhsyuhknKknKbn;
    }

    private C_UmuKbn vhsyusgsbhsyumu;

    @Override
    public C_UmuKbn getVhsyusgsbhsyumu() {
        return vhsyusgsbhsyumu;
    }

    @Override
    public void setVhsyusgsbhsyumu(C_UmuKbn pVhsyusgsbhsyumu) {
        vhsyusgsbhsyumu = pVhsyusgsbhsyumu;
    }

    private int vhsyusyohinhanteikbn;

    @Override
    public int getVhsyusyohinhanteikbn() {
        return vhsyusyohinhanteikbn;
    }

    @Override
    public void setVhsyusyohinhanteikbn(int pVhsyusyohinhanteikbn) {
        vhsyusyohinhanteikbn = pVhsyusyohinhanteikbn;
    }

    private C_UmuKbn vhsyumvatekiumu;

    @Override
    public C_UmuKbn getVhsyumvatekiumu() {
        return vhsyumvatekiumu;
    }

    @Override
    public void setVhsyumvatekiumu(C_UmuKbn pVhsyumvatekiumu) {
        vhsyumvatekiumu = pVhsyumvatekiumu;
    }

    private C_UmuKbn vhsyusbhkuktumu;

    @Override
    public C_UmuKbn getVhsyusbhkuktumu() {
        return vhsyusbhkuktumu;
    }

    @Override
    public void setVhsyusbhkuktumu(C_UmuKbn pVhsyusbhkuktumu) {
        vhsyusbhkuktumu = pVhsyusbhkuktumu;
    }

    private C_UmuKbn vhsyusbkyuuhukinuktumu;

    @Override
    public C_UmuKbn getVhsyusbkyuuhukinuktumu() {
        return vhsyusbkyuuhukinuktumu;
    }

    @Override
    public void setVhsyusbkyuuhukinuktumu(C_UmuKbn pVhsyusbkyuuhukinuktumu) {
        vhsyusbkyuuhukinuktumu = pVhsyusbkyuuhukinuktumu;
    }

    private C_Tuukasyu shrTuukasyu;

    @Override
    public C_Tuukasyu getShrtuukasyu() {
        return shrTuukasyu;
    }

    @Override
    public void setShrtuukasyu(C_Tuukasyu pShrtuukasyu) {
        shrTuukasyu = pShrtuukasyu;
    }

    private String syono;

    @Override
    public String getSyono() {
        return syono;
    }

    @Override
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private String Kyknmkn;

    @Override
    public String getKyknmkn() {
        return Kyknmkn;
    }

    @Override
    public void setKyknmkn(String pKyknmkn) {
        Kyknmkn = pKyknmkn;
    }

    private String patternSyorikekkakbn;

    public String getPatternSyorikekkakbn() {
        return patternSyorikekkakbn;
    }

    @Override
    public void setPatternSyorikekkakbn(String pPatternSyorikekkakbn) {
        patternSyorikekkakbn = pPatternSyorikekkakbn;
    }

    private C_Tuukasyu vhrkiyentkykwsratetuukasyu;

    @Override
    public C_Tuukasyu getVhrkiyentkykwsratetuukasyu() {
        return vhrkiyentkykwsratetuukasyu;
    }

    @Override
    public void setVhrkiyentkykwsratetuukasyu(C_Tuukasyu pVhrkiyentkykwsratetuukasyu) {
        vhrkiyentkykwsratetuukasyu = pVhrkiyentkykwsratetuukasyu;
    }

    private BizCurrency vhrkiitijibrp;

    @Override
    public BizCurrency getVhrkiitijibrp() {
        return vhrkiitijibrp;
    }

    @Override
    public void setVhrkiitijibrp(BizCurrency pVhrkiitijibrp) {
        vhrkiitijibrp = pVhrkiitijibrp;

    }

    private C_UmuKbn yennykntkhkumu;

    @Override
    public C_UmuKbn getYennykntkhkumu() {
        return yennykntkhkumu;
    }

    @Override
    public void setYennykntkhkumu(C_UmuKbn pYennykntkhkumu) {
        yennykntkhkumu = pYennykntkhkumu;

    }

    private C_SoukinsakiKbn soukinsakiKbn;

    @Override
    public C_SoukinsakiKbn getSoukinsakikbn(){
        return soukinsakiKbn;
    }

    @Override
    public void setSoukinsakikbn(C_SoukinsakiKbn pSoukinsakiKbn){
        soukinsakiKbn = pSoukinsakiKbn;
    }

    public BizDate getFstPnyknYmd() {
        return fstPnyknYmd;
    }

    public void setFstPnyknYmd(BizDate pFstPnyknYmd) {
        fstPnyknYmd = pFstPnyknYmd;
    }

    public C_HrkkknsmnKbn getSyuHrkkknSmnKbn() {
        return syuHrkkknSmnKbn;
    }

    public void setSyuHrkkknSmnKbn(C_HrkkknsmnKbn pSyuHrkkknSmnKbn) {
        syuHrkkknSmnKbn = pSyuHrkkknSmnKbn;
    }

    public C_Kykjyoutai getKykJyoutai() {
        return kykJyoutai;
    }

    public void setKykJyoutai(C_Kykjyoutai pKykJyoutai) {
        kykJyoutai = pKykJyoutai;
    }

    public BizCurrency getSyukykKjnkngk() {
        return syukykKjnkngk;
    }

    public void setSyukykKjnkngk(BizCurrency pSyukykKjnkngk) {
        syukykKjnkngk = pSyukykKjnkngk;
    }

    public BizNumber getYoteirirituMinHosyouritu() {
        return yoteirirituMinHosyouritu;
    }

    public void setYoteirirituMinHosyouritu(BizNumber pYoteirirituMinHosyouritu) {
        yoteirirituMinHosyouritu = pYoteirirituMinHosyouritu;
    }

    public BizDateYM getJkiPjytYm() {
        return jkiPjytYm;
    }

    public void setJkiPjytYm(BizDateYM pJkiPjytYm) {
        jkiPjytYm = pJkiPjytYm;
    }

    public C_UmuKbn getPtumitatekinSaikeisanUmu() {
        return ptumitatekinSaikeisanUmu;
    }

    public void setPtumitatekinSaikeisanUmu(C_UmuKbn pPtumitatekinSaikeisanUmu) {
        ptumitatekinSaikeisanUmu = pPtumitatekinSaikeisanUmu;
    }

    public BizDate getTykgoKykOutouYmd() {
        return tykgoKykOutouYmd;
    }

    public void setTykgoKykOutouYmd(BizDate pTykgoKykOutouYmd) {
        tykgoKykOutouYmd = pTykgoKykOutouYmd;
    }

    public BizDate getCalcKijyunYmd() {
        return calcKijyunYmd;
    }

    public void setCalcKijyunYmd(BizDate pCalcKijyunYmd) {
        calcKijyunYmd = pCalcKijyunYmd;
    }

    public BizCurrency getSeibetuHenkoumaePtmttkngk() {
        return seibetuHenkoumaePtmttkngk;
    }

    public void setSeibetuHenkoumaePtmttkngk(BizCurrency pSeibetuHenkoumaePtmttkngk) {
        seibetuHenkoumaePtmttkngk = pSeibetuHenkoumaePtmttkngk;
    }

    public BizCurrency getSbtHenkoumaeKihrkmPstgk() {
        return sbtHenkoumaeKihrkmPstgk;
    }

    public void setSbtHenkoumaeKihrkmPstgk(BizCurrency pSbtHenkoumaeKihrkmPstgk) {
        sbtHenkoumaeKihrkmPstgk = pSbtHenkoumaeKihrkmPstgk;
    }

    public BizCurrency getTyouseimaePtmttkngk() {
        return tyouseimaePtmttkngk;
    }

    public void setTyouseimaePtmttkngk(BizCurrency pTyouseimaePtmttkngk) {
        tyouseimaePtmttkngk = pTyouseimaePtmttkngk;
    }

    @Override
    public KariukekinInfoDataSourceBeanCommonParam createKariukekinInfoDataSourceBean() {
        return new KariukekinInfoDataSourceBean();
    }

    @Override
    public void convertKariukekinInfoForCommonParam(List<KariukekinInfoDataSourceBeanCommonParam> pKariukekinInfo) {
        List<KariukekinInfoDataSourceBean> kariukekinInfo = Lists.newArrayList();
        for (KariukekinInfoDataSourceBeanCommonParam dataSourceBeanCommonParam :pKariukekinInfo) {
            kariukekinInfo.add((KariukekinInfoDataSourceBean)dataSourceBeanCommonParam);
        }
        super.setKariukekinInfo(kariukekinInfo);
    }

    public Integer getHenhrkkkn() {
        return henhrkkkn;
    }

    public void setHenhrkkkn(Integer pHenhrkkkn) {
        henhrkkkn = pHenhrkkkn;
    }

    public BizCurrency getShrgkgoukeiKyktuuka() {
        return shrgkgoukeiKyktuuka;
    }

    public void setShrgkgoukeiKyktuuka(BizCurrency pShrgkgoukeiKyktuuka) {
        shrgkgoukeiKyktuuka = pShrgkgoukeiKyktuuka;
    }

    public C_UmuKbn getTuikahrkkinumu() {
        return tuikahrkkinumu;
    }

    public void setTuikahrkkinumu(C_UmuKbn pTuikahrkkinumu) {
        tuikahrkkinumu = pTuikahrkkinumu;
    }

    public C_UmuKbn getHenkankinumu() {
        return henkankinumu;
    }

    public void setHenkankinumu(C_UmuKbn pHenkankinumu) {
        henkankinumu = pHenkankinumu;
    }

    public C_UmuKbn getTuikahrkkinnyknumu() {
        return tuikahrkkinnyknumu;
    }

    public void setTuikahrkkinnyknumu(C_UmuKbn pTuikahrkkinnyknumu) {
        tuikahrkkinnyknumu = pTuikahrkkinnyknumu;
    }

    public List<Integer> getTuikahrkkinKrknoList() {
        return tuikahrkkinKrknoList;
    }

    public void setTuikahrkkinKrknoList(List<Integer> pTuikahrkkinKrknoList) {
        tuikahrkkinKrknoList = pTuikahrkkinKrknoList;
    }

    public BizCurrency getTuikahrkkinGoukeinykngk() {
        return tuikahrkkinGoukeinykngk;
    }

    public void setTuikahrkkinGoukeinykngk(BizCurrency pTuikahrkkinGoukeinykngk) {
        tuikahrkkinGoukeinykngk = pTuikahrkkinGoukeinykngk;
    }

    public Integer getTuikahrkkinInfoDispPattern() {
        return tuikahrkkinInfoDispPattern;
    }

    public void setTuikahrkkinInfoDispPattern(Integer pTuikahrkkinInfoDispPattern) {
        tuikahrkkinInfoDispPattern = pTuikahrkkinInfoDispPattern;
    }

    public C_UmuKbn getKajyouukeireumu() {
        return kajyouukeireumu;
    }

    public void setKajyouukeireumu(C_UmuKbn pKajyouukeireumu) {
        kajyouukeireumu = pKajyouukeireumu;
    }

    public BizCurrency getKajyouukeirekngk() {
        return kajyouukeirekngk;
    }

    public void setKajyouukeirekngk(BizCurrency pKajyouukeirekngk) {
        kajyouukeirekngk = pKajyouukeirekngk;
    }

    public BizDate getTuikahrkkinRyosyuymd() {
        return tuikahrkkinRyosyuymd;
    }

    public void setTuikahrkkinRyosyuymd(BizDate pTuikahrkkinRyosyuymd) {
        tuikahrkkinRyosyuymd = pTuikahrkkinRyosyuymd;
    }

    public BizDate getZeimukwsratekjnymd() {
        return zeimukwsratekjnymd;
    }

    public void setZeimukwsratekjnymd(BizDate pZeimukwsratekjnymd) {
        zeimukwsratekjnymd = pZeimukwsratekjnymd;
    }

    public BizNumber getZeimukwsrate() {
        return zeimukwsrate;
    }

    public void setZeimukwsrate(BizNumber pZeimukwsrate) {
        zeimukwsrate = pZeimukwsrate;
    }

    public C_Tuukasyu getZeimukyktuukasyu() {
        return zeimukyktuukasyu;
    }

    public void setZeimukyktuukasyu(C_Tuukasyu pZeimukyktuukasyu) {
        zeimukyktuukasyu = pZeimukyktuukasyu;
    }

    public String getDenrenno() {
        return denrenno;
    }

    public void setDenrenno(String pDenrenno) {
        denrenno = pDenrenno;
    }

    public C_KiharaiPseisanNaiyouKbn getKihrkpssnaiyoukbn() {
        return kihrkpssnaiyoukbn;
    }

    public void setKihrkpssnaiyoukbn(C_KiharaiPseisanNaiyouKbn pKihrkpssnaiyoukbn) {
        kihrkpssnaiyoukbn = pKihrkpssnaiyoukbn;
    }

    public BizCurrency getKihrkpYenkansanhenkankin() {
        return kihrkpYenkansanhenkankin;
    }

    public void setKihrkpYenkansanhenkankin(BizCurrency pKihrkpYenkansanhenkankin) {
        kihrkpYenkansanhenkankin = pKihrkpYenkansanhenkankin;
    }

    public BizCurrency getKihrkpYenkansantuityoukin() {
        return kihrkpYenkansantuityoukin;
    }

    public void setKihrkpYenkansantuityoukin(BizCurrency pKihrkpYenkansantuityoukin) {
        kihrkpYenkansantuityoukin = pKihrkpYenkansantuityoukin;
    }

    public BizCurrency getKihrkpTuityouk() {
        return kihrkpTuityouk;
    }

    public void setKihrkpTuityouk(BizCurrency pKihrkpTuityouk) {
        kihrkpTuityouk = pKihrkpTuityouk;
    }

    public BizDate getKihrkpZeimukwsratekjnymd() {
        return kihrkpZeimukwsratekjnymd;
    }

    public void setKihrkpZeimukwsratekjnymd(BizDate pKihrkpZeimukwsratekjnymd) {
        kihrkpZeimukwsratekjnymd = pKihrkpZeimukwsratekjnymd;
    }

    public BizNumber getKihrkpZeimukwsrate() {
        return kihrkpZeimukwsrate;
    }

    public void setKihrkpZeimukwsrate(BizNumber pKihrkpZeimukwsrate) {
        kihrkpZeimukwsrate = pKihrkpZeimukwsrate;
    }

    public BizCurrency getShrtuukashrgkgoukei() {
        return shrtuukashrgkgoukei;
    }

    public void setShrtuukashrgkgoukei(BizCurrency pShrtuukashrgkgoukei) {
        shrtuukashrgkgoukei = pShrtuukashrgkgoukei;
    }

    public BizCurrency getShrtuukasyushrgkkei() {
        return shrtuukasyushrgkkei;
    }

    public void setShrtuukasyushrgkkei(BizCurrency pShrtuukasyushrgkkei) {
        shrtuukasyushrgkkei = pShrtuukasyushrgkkei;
    }

    public BizCurrency getYenshrgkgoukei() {
        return yenshrgkgoukei;
    }

    public void setYenshrgkgoukei(BizCurrency pYenshrgkgoukei) {
        yenshrgkgoukei = pYenshrgkgoukei;
    }

    public BizCurrency getYensyushrgkkei() {
        return yensyushrgkkei;
    }

    public void setYensyushrgkkei(BizCurrency pYensyushrgkkei) {
        yensyushrgkkei = pYensyushrgkkei;
    }

    public BizDate getShrkwsratekjnymd() {
        return shrkwsratekjnymd;
    }

    public void setShrkwsratekjnymd(BizDate pShrkwsratekjnymd) {
        shrkwsratekjnymd = pShrkwsratekjnymd;
    }

    public BizNumber getShrkwsrate() {
        return shrkwsrate;
    }

    public void setShrkwsrate(BizNumber pShrkwsrate) {
        shrkwsrate = pShrkwsrate;
    }

    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }

    public Integer getDai1hknkkn() {
        return dai1hknkkn;
    }

    public void setDai1hknkkn(Integer pDai1hknkkn) {
        dai1hknkkn = pDai1hknkkn;
    }

    public BizDate getSeirituymd() {
        return seirituymd;
    }

    public void setSeirituymd(BizDate pSeirituymd) {
        seirituymd = pSeirituymd;
    }

    public C_SyutkKbn getSyutkkbn() {
        return syutkkbn;
    }

    public void setSyutkkbn(C_SyutkKbn pSyutkkbn) {
        syutkkbn = pSyutkkbn;
    }

}
