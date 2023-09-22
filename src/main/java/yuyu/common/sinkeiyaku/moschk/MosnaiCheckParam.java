package yuyu.common.sinkeiyaku.moschk;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.Tuusan;
import yuyu.def.classification.C_BosyuusysctrlKbn;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_ChkkekkaKbn;
import yuyu.def.classification.C_HandketsijiKbn;
import yuyu.def.classification.C_IkkatuyouptknKbn;
import yuyu.def.classification.C_KetsijisyoyhKbn;
import yuyu.def.classification.C_KetteiyouhiKbn;
import yuyu.def.classification.C_KktatkichkkekkaKbn;
import yuyu.def.classification.C_KouzokujkKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_KykkakiraisyoyhKbn;
import yuyu.def.classification.C_Kykkaksyrui;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_RiyousysKbn;
import yuyu.def.classification.C_SakuintsnKbn;
import yuyu.def.classification.C_SateikanKbn;
import yuyu.def.classification.C_SeihowebsousasyaKbn;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_SekmossakuseiKbn;
import yuyu.def.classification.C_SinkihnkKbn;
import yuyu.def.classification.C_SpKeisanKahiKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_Tksytratkikjn;
import yuyu.def.classification.C_TsnchkptnKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YoteikykymdKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 *  新契約 申込内容チェック 申込内容チェック用パラメータ
 */
public class MosnaiCheckParam {

    private String                categoryID                      = "";
    private String                kinouID                         = "";
    private C_KetteiyouhiKbn      ketteiYouhiKbn                  = C_KetteiyouhiKbn.HUYOU;
    private C_SateikanKbn         sateiKanryouKbn                 = C_SateikanKbn.BLNK;
    private C_SinkihnkKbn         sinkiHnkKbn                     = C_SinkihnkKbn.BLNK;
    private C_KykKbn              kykKbn_HnkMae                   = C_KykKbn.BLNK;
    private C_UmuKbn              hhknTeisei                      = C_UmuKbn.NONE;
    private C_UmuKbn              kykTeisei                       = C_UmuKbn.NONE;
    private C_HandketsijiKbn      ketteiSijiKbn                   = C_HandketsijiKbn.HUYOU;
    private C_Kykkaksyrui         kykKakuninSyurui                = C_Kykkaksyrui.BLNK;
    private C_YoteikykymdKbn      yoteiKykymdKbn                  = C_YoteikykymdKbn.SITEI;
    private C_SysKbn              sysKbn                          = C_SysKbn.SKEI;
    private BizDate               sysDate                         = null;
    private C_RiyousysKbn         eshienRiyoumotoSysKbn           = null;
    private String                kosID                           = "";
    private String                kosTime                         = "";
    private C_KetsijisyoyhKbn     ketteiSijisyoYouhiKbn           = C_KetsijisyoyhKbn.HUYOU;
    private C_KykkakiraisyoyhKbn  kykKakuninIraisyoYouhiKbn       = C_KykkakiraisyoyhKbn.HUYOU;
    private C_KouzokujkKbn        kouzokuSyoriJikkouKbn           = C_KouzokujkKbn.JIKKOU;
    private C_ChkkekkaKbn         chkKekkaKbn                     = C_ChkkekkaKbn.SEIJYOU;
    private C_KktatkichkkekkaKbn  kokutiChkKekkaKbn               = C_KktatkichkkekkaKbn.NONE;
    private C_UmuKbn              kokutiChkHuyoUmu                = C_UmuKbn.NONE;
    private C_SakuintsnKbn        sakuinTsnKbn                    = C_SakuintsnKbn.SEIJYOU;
    private List<String>          listKetteiSijiMsgId             = new ArrayList<>();
    private List<String>          listKetteiSijiMsg               = new ArrayList<>();
    private List<String>          listKykKakuninMsg               = new ArrayList<>();
    private List<String>          listKekkaGmnMsg                 = new ArrayList<>();
    private HT_SyoriCTL           syoriControl                    = null;
    private String                setAiteMosNo                    = "";
    private String                setAiteSyuSyouhnCd              = "";
    private String                tratkiAgCd                      = "";
    private C_TsnchkptnKbn        tsnCheckPtnKbn                  = C_TsnchkptnKbn.HUYOU;
    private C_BosyuusysctrlKbn    bosyuuSysCtrlKbn                = C_BosyuusysctrlKbn.BLNK;
    private C_Tksytratkikjn       tksyTratkiKjn                   = null;
    private C_UmuKbn              kaiyakuDoujiSekUmu              = C_UmuKbn.NONE;
    private C_UmuKbn              freeinsuranceUmu                = C_UmuKbn.NONE;
    private C_UmuKbn              creditCardInfoTblChkErrUmu      = C_UmuKbn.NONE;
    private C_UmuKbn              saiteiPChkErrUmu                = C_UmuKbn.NONE;
    private C_MosUketukeKbn       mosUketukeKbn                   = C_MosUketukeKbn.BLNK;
    private C_UmuKbn              hhknTratkityuiUmuKbnMr          = C_UmuKbn.NONE;
    private C_UmuKbn              kykTratkityuiUmuKbnMr           = C_UmuKbn.NONE;
    private C_UmuKbn              uktTratkityuiUmuKbnMr           = C_UmuKbn.NONE;
    private C_UmuKbn              kykDairiTratkityuiUmuKbnMr      = C_UmuKbn.NONE;
    private C_UmuKbn              hhknDairiTratkityuiUmuKbnMr     = C_UmuKbn.NONE;
    private C_UmuKbn              hhknSntkinfohnsyUmuKbnMr        = C_UmuKbn.NONE;
    private C_UmuKbn              kykSntkinfohnsyUmuKbnMr         = C_UmuKbn.NONE;
    private C_UmuKbn              uktSntkinfohnsyUmuKbnMr         = C_UmuKbn.NONE;
    private C_UmuKbn              kykDairiSntkinfohnsyUmuKbnMr    = C_UmuKbn.NONE;
    private C_UmuKbn              hhknDairiSntkinfohnsyUmuKbnMr   = C_UmuKbn.NONE;
    private C_UmuKbn              hhknTratkityuiUmuKbnSignal      = C_UmuKbn.NONE;
    private C_UmuKbn              kykTratkityuiUmuKbnSignal       = C_UmuKbn.NONE;
    private C_UmuKbn              uktTratkityuiUmuKbnSignal       = C_UmuKbn.NONE;
    private C_UmuKbn              kykDairiTratkityuiUmuKbnSignal  = C_UmuKbn.NONE;
    private C_UmuKbn              hhknDairiTratkityuiUmuKbnSignal = C_UmuKbn.NONE;
    private C_UmuKbn              hhknInfohnsyUmuKbnSignal        = C_UmuKbn.NONE;
    private C_UmuKbn              kykInfohnsyUmuKbnSignal         = C_UmuKbn.NONE;
    private C_UmuKbn              uktInfohnsyUmuKbnSignal         = C_UmuKbn.NONE;
    private C_UmuKbn              kykDairiInfohnsyUmuKbnSignal    = C_UmuKbn.NONE;
    private C_UmuKbn              hhknDairiInfohnsyUmuKbnSignal   = C_UmuKbn.NONE;
    private C_UmuKbn              hhknGaikokupepsumukbn           = C_UmuKbn.NONE;
    private C_UmuKbn              kykGaikokupepsumukbn            = C_UmuKbn.NONE;
    private C_UmuKbn              uktGaikokupepsumukbn            = C_UmuKbn.NONE;
    private C_UmuKbn              kykDairiGaikokupepsumukbn       = C_UmuKbn.NONE;
    private C_UmuKbn              hhknDairiGaikokupepsumukbn      = C_UmuKbn.NONE;
    private C_UmuKbn              hhknSinsntkhnsyUmuKbn           = C_UmuKbn.NONE;
    private C_UmuKbn              kykSinsntkhnsyUmuKbn            = C_UmuKbn.NONE;
    private C_UmuKbn              uktSinsntkhnsyUmuKbn            = C_UmuKbn.NONE;
    private C_UmuKbn              kykDairiSinsntkhnsyUmuKbn       = C_UmuKbn.NONE;
    private C_UmuKbn              hhknDairiSinsntkhnsyUmuKbn      = C_UmuKbn.NONE;
    private C_YouhiblnkKbn        hhknItekisntkhndktYhKbn         = C_YouhiblnkKbn.HUYOU;
    private C_YouhiblnkKbn        hhknTtdkTyuuiKnkHndktYhKbn      = C_YouhiblnkKbn.HUYOU;
    private C_YouhiblnkKbn        kykTtdkTyuuiKnkHndktYhKbn       = C_YouhiblnkKbn.HUYOU;
    private C_YouhiblnkKbn        uktTtdkTyuuiKnkHndktYhKbn       = C_YouhiblnkKbn.HUYOU;
    private C_YouhiblnkKbn        kykDairiTtdkTyuuiKnkHndktYhKbn  = C_YouhiblnkKbn.HUYOU;
    private C_YouhiblnkKbn        hhknDairiTtdkTyuuiKnkHndktYhKbn = C_YouhiblnkKbn.HUYOU;
    private C_YouhiblnkKbn        hhknKyhkinUktkAriItkHndktYhKbn  = C_YouhiblnkKbn.HUYOU;
    private C_YouhiblnkKbn        doujiMosItekiHndktYhKbn         = C_YouhiblnkKbn.HUYOU;
    private C_YouhiblnkKbn        doujiMosKnkHndktYhKbn           = C_YouhiblnkKbn.HUYOU;
    private C_UmuKbn              uktNayosehumeiUmuKbn            = C_UmuKbn.NONE;
    private C_UmuKbn              kykDairiNayosehumeiUmuKbn       = C_UmuKbn.NONE;
    private C_UmuKbn              hhknDairiNayosehumeiUmuKbn      = C_UmuKbn.NONE;
    private List<String>          listKkiykDoujiMosSyonoPal       = new ArrayList<>();
    private List<String>          listSkDoujiMosMosnoPal          = new ArrayList<>();
    private BizDate               fstnyknTyakkinYmd               = null;
    private BizNumber             nyuukinKawaseRate               = null;
    private BT_GyoumuKouteiInfo   gyoumuKouteiInfo                = null;
    private List<HT_HubiMsg>      listHubiMsg                     = new ArrayList<>();
    private HT_MosnoKanri         mosnoKanri                      = null;
    private BizNumber             nyuuryokuKawaseRate             = null;
    private boolean               nensyuTuusanSOverHanteiKekka    = false;
    private BizCurrency           tsnketsibous                    = BizCurrency.valueOf(0);
    private C_SpKeisanKahiKbn     kthjiSpKeisanKahiKbn            = C_SpKeisanKahiKbn.MISETTEI;
    private BM_SyouhnZokusei      syuSyouhnZokusei                = null;
    private List<BM_SyouhnZokusei> listTkSyouhnZokusei            = new ArrayList<>();
    private C_Channelcd kiteiCheckChannelCd                       = C_Channelcd.BLNK;
    private C_IkkatuyouptknKbn beforeCheckIkkatuyouptknKbn        = C_IkkatuyouptknKbn.NONE;
    private Integer beforeCheckIkkatuyoupkaisuu                   = 0;
    private List<HT_SkDenpyoData> listSkDenpyoData                = new ArrayList<>();
    private C_UmuKbn              hhknNayosejissiUmuKbnSeijyou    = C_UmuKbn.NONE;
    private C_UmuKbn              checkspJissiUmuKbnSeijyou       = C_UmuKbn.NONE;
    private C_UmuKbn              nayoseKaihiUmuKbn               = C_UmuKbn.NONE;
    private BizNumber             pRate                           = null;
    private BizNumber             pdateSRate                      = null;
    private BizNumber             hrbtJyousu                      = null;
    private C_UmuKbn              tkrtkKinyuuknUmuKbn             = C_UmuKbn.NONE;
    private C_UmuKbn              kydsskKinyuuknUmuKbn            = C_UmuKbn.NONE;
    private C_SekmossakuseiKbn    sekmossakuseiKbn                = C_SekmossakuseiKbn.NONE;
    private C_SekmossakuseiErroutKbn  sekmossakuseiErroutKbn      = C_SekmossakuseiErroutKbn.NONE;
    private String                sekmossakuseiErrmsg1            = "";
    private String                sekmossakuseiErrmsg2            = "";
    private C_SeihowebsousasyaKbn sekmossakuseiSousasyaKbn        = C_SeihowebsousasyaKbn.DIRTNBSYNN;
    private String                sekmossakuseiOyaAgCd            = "";
    private C_UmuKbn sekmossakuseiNayoseHumeiKbn                  = C_UmuKbn.NONE;
    private C_UmuKbn sekmossakuseiHrksknnyrykUmuKbn               = C_UmuKbn.NONE;
    private Tuusan                tuusan                          = null;

    @Inject
    private static Logger logger;

    public MosnaiCheckParam() {
        super();
    }

    public String getCategoryID() {

        return this.categoryID;
    }

    public void setCategoryID(String pCategoryID) {

        this.categoryID = pCategoryID;
    }

    public String getKinouID() {

        return this.kinouID;
    }

    public void setKinouID(String pKinouID) {

        this.kinouID = pKinouID;
    }

    public C_KetteiyouhiKbn getKetteiYouhiKbn() {

        return this.ketteiYouhiKbn;
    }

    public void setKetteiYouhiKbn(C_KetteiyouhiKbn pKetteiYouhiKbn) {

        this.ketteiYouhiKbn = pKetteiYouhiKbn;
    }

    public C_SateikanKbn getSateiKanryouKbn() {

        return this.sateiKanryouKbn;
    }

    public void setSateiKanryouKbn(C_SateikanKbn pSateiKanryouKbn) {

        this.sateiKanryouKbn = pSateiKanryouKbn;
    }

    public C_SinkihnkKbn getSinkiHnkKbn() {

        return this.sinkiHnkKbn;
    }

    public void setSinkiHnkKbn(C_SinkihnkKbn pSinkiHnkKbn) {

        this.sinkiHnkKbn = pSinkiHnkKbn;
    }

    public C_KykKbn getKykKbn_HnkMae() {

        return this.kykKbn_HnkMae;
    }

    public void setKykKbn_HnkMae(C_KykKbn pKykKbn_HnkMae) {

        this.kykKbn_HnkMae = pKykKbn_HnkMae;
    }

    public C_UmuKbn getHhknTeisei() {

        return this.hhknTeisei;
    }

    public void setHhknTeisei(C_UmuKbn pHhknTeisei) {

        this.hhknTeisei = pHhknTeisei;
    }

    public C_UmuKbn getKykTeisei() {

        return this.kykTeisei;
    }

    public void setKykTeisei(C_UmuKbn pKykTeisei) {

        this.kykTeisei = pKykTeisei;
    }

    public C_HandketsijiKbn getKetteiSijiKbn() {

        return this.ketteiSijiKbn;
    }

    public void setKetteiSijiKbn(C_HandketsijiKbn pKetteiSijiKbn) {

        this.ketteiSijiKbn = pKetteiSijiKbn;
    }

    public C_Kykkaksyrui getKykKakuninSyurui() {

        return this.kykKakuninSyurui;
    }

    public void setKykKakuninSyurui(C_Kykkaksyrui pKykKakuninSyurui) {

        this.kykKakuninSyurui = pKykKakuninSyurui;
    }

    public C_YoteikykymdKbn getYoteiKykymdKbn() {

        return this.yoteiKykymdKbn;
    }

    public void setYoteiKykymdKbn(C_YoteikykymdKbn pYoteiKykymdKbn) {

        this.yoteiKykymdKbn = pYoteiKykymdKbn;
    }

    public C_SysKbn getSysKbn() {

        return this.sysKbn;
    }

    public void setSysKbn(C_SysKbn pSysKbn) {

        this.sysKbn = pSysKbn;
    }

    public BizDate getSysDate() {

        return this.sysDate;
    }

    public void setSysDate(BizDate pSysDate) {

        this.sysDate = pSysDate;
    }

    public C_RiyousysKbn getEshienRiyoumotoSysKbn() {

        return this.eshienRiyoumotoSysKbn;
    }

    public void setEshienRiyoumotoSysKbn(C_RiyousysKbn pEshienRiyoumotoSysKbn) {

        this.eshienRiyoumotoSysKbn = pEshienRiyoumotoSysKbn;
    }

    public String getKosID() {

        return this.kosID;
    }

    public void setKosID(String pKosID) {

        this.kosID = pKosID;
    }

    public String getKosTime() {

        return this.kosTime;
    }

    public void setKosTime(String pKosTime) {

        this.kosTime = pKosTime;
    }

    public C_KetsijisyoyhKbn getKetteiSijisyoYouhiKbn() {

        return this.ketteiSijisyoYouhiKbn;
    }

    public void setKetteiSijisyoYouhiKbn(C_KetsijisyoyhKbn pKbn) {

        this.ketteiSijisyoYouhiKbn = pKbn;
    }

    public C_KykkakiraisyoyhKbn getKykKakuninIraisyoYouhiKbn() {

        return this.kykKakuninIraisyoYouhiKbn;
    }

    public void setKykKakuninIraisyoYouhiKbn(C_KykkakiraisyoyhKbn pKbn) {

        this.kykKakuninIraisyoYouhiKbn = pKbn;
    }

    public C_KouzokujkKbn getKouzokuSyoriJikkouKbn() {

        return this.kouzokuSyoriJikkouKbn;
    }

    public void setKouzokuSyoriJikkouKbn(C_KouzokujkKbn pKbn) {

        this.kouzokuSyoriJikkouKbn = pKbn;
    }

    public C_ChkkekkaKbn getChkKekkaKbn() {

        return this.chkKekkaKbn;
    }

    public void setChkKekkaKbn(C_ChkkekkaKbn pChkKekkaKbn) {

        this.chkKekkaKbn = pChkKekkaKbn;
    }

    public C_KktatkichkkekkaKbn getKokutiChkKekkaKbn() {

        return this.kokutiChkKekkaKbn;
    }

    public void setKokutiChkKekkaKbn(C_KktatkichkkekkaKbn pKokutiChkKekkaKbn) {

        this.kokutiChkKekkaKbn = pKokutiChkKekkaKbn;
    }

    public C_UmuKbn getKokutiChkHuyoUmu() {

        return this.kokutiChkHuyoUmu;
    }

    public void setKokutiChkHuyoUmu(C_UmuKbn pKokutiChkHuyoUmu) {

        this.kokutiChkHuyoUmu = pKokutiChkHuyoUmu;
    }

    public C_SakuintsnKbn getSakuinTsnKbn() {

        return this.sakuinTsnKbn;
    }

    public void setSakuinTsnKbn(C_SakuintsnKbn pSakuinTsnKbn) {

        this.sakuinTsnKbn = pSakuinTsnKbn;
    }

    public List<String> getListKetteiSijiMsgId() {

        return this.listKetteiSijiMsgId;
    }

    public void setListKetteiSijiMsgId(List<String> pmsg) {

        this.listKetteiSijiMsgId = pmsg;
    }

    public List<String> getListKetteiSijiMsg() {

        return this.listKetteiSijiMsg;
    }

    public void setListKetteiSijiMsg(List<String> pmsg) {

        this.listKetteiSijiMsg = pmsg;
    }

    public List<String> getListKykKakuninMsg() {

        return this.listKykKakuninMsg;
    }

    public void setListKykKakuninMsg(List<String> pmsg) {

        this.listKykKakuninMsg = pmsg;
    }

    public List<String> getListKekkaGmnMsg() {

        return this.listKekkaGmnMsg;
    }

    public void setListKekkaGmnMsg(List<String> pmsg) {

        this.listKekkaGmnMsg = pmsg;
    }

    public HT_SyoriCTL getDataSyoriControl() {

        return this.syoriControl;
    }

    public void setDataSyoriControl(HT_SyoriCTL pSyoriControl) {

        this.syoriControl = pSyoriControl;
    }

    public String getSetAiteMosNo() {

        return this.setAiteMosNo;
    }

    public void setSetAiteMosNo(String pSetAiteMosNo) {

        this.setAiteMosNo = pSetAiteMosNo;
    }

    public String getSetAiteSyuSyouhnCd() {

        return this.setAiteSyuSyouhnCd;
    }

    public void setSetAiteSyuSyouhnCd(String pSetAiteSyuSyouhnCd) {

        this.setAiteSyuSyouhnCd = pSetAiteSyuSyouhnCd;
    }

    public String getTratkiAgCd() {

        return this.tratkiAgCd;
    }

    public void setTratkiAgCd(String pTratkiAgCd) {

        this.tratkiAgCd = pTratkiAgCd;
    }

    public C_TsnchkptnKbn getTsnCheckPtnKbn() {

        return this.tsnCheckPtnKbn;
    }

    public void setTsnCheckPtnKbn(C_TsnchkptnKbn pTsnCheckPtnKbn) {

        this.tsnCheckPtnKbn = pTsnCheckPtnKbn;
    }

    public C_BosyuusysctrlKbn getBosyuuSysCtrlKbn() {

        return this.bosyuuSysCtrlKbn;
    }

    public void setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn pBosyuuSysCtrlKbn) {

        this.bosyuuSysCtrlKbn = pBosyuuSysCtrlKbn;
    }

    public C_Tksytratkikjn getTksyTratkiKjn() {

        return this.tksyTratkiKjn;
    }

    public void setTksyTratkiKjn(C_Tksytratkikjn pTksyTratkiKjn) {

        this.tksyTratkiKjn = pTksyTratkiKjn;
    }

    public C_UmuKbn getKaiyakuDoujiSekUmu() {

        return this.kaiyakuDoujiSekUmu;
    }

    public void setKaiyakuDoujiSekUmu(C_UmuKbn pKaiyakuDoujiSekUmu) {

        this.kaiyakuDoujiSekUmu = pKaiyakuDoujiSekUmu;
    }

    public C_UmuKbn getFreeinsuranceUmu() {

        return this.freeinsuranceUmu;
    }

    public void setFreeinsuranceUmu(C_UmuKbn pFreeinsuranceUmu) {

        this.freeinsuranceUmu = pFreeinsuranceUmu;
    }

    public C_UmuKbn getCreditCardInfoTblChkErrUmu() {

        return this.creditCardInfoTblChkErrUmu;
    }

    public void setCreditCardInfoTblChkErrUmu(C_UmuKbn pCreditCardInfoTblChkErrUmu) {

        this.creditCardInfoTblChkErrUmu = pCreditCardInfoTblChkErrUmu;
    }

    public C_UmuKbn getSaiteiPChkErrUmu() {

        return this.saiteiPChkErrUmu;
    }

    public void setSaiteiPChkErrUmu(C_UmuKbn pSaiteiPChkErrUmu) {

        this.saiteiPChkErrUmu = pSaiteiPChkErrUmu;
    }

    public C_MosUketukeKbn getMosUketukeKbn() {

        return this.mosUketukeKbn;
    }

    public void setMosUketukeKbn(C_MosUketukeKbn pMosUketukeKbn) {

        this.mosUketukeKbn = pMosUketukeKbn;
    }

    public C_UmuKbn getHhknTratkityuiUmuKbnMr() {

        return this.hhknTratkityuiUmuKbnMr;
    }

    public void setHhknTratkityuiUmuKbnMr(C_UmuKbn pHhknTratkityuiUmuKbnMr) {

        this.hhknTratkityuiUmuKbnMr = pHhknTratkityuiUmuKbnMr;
    }

    public C_UmuKbn getKykTratkityuiUmuKbnMr() {

        return this.kykTratkityuiUmuKbnMr;
    }

    public void setKykTratkityuiUmuKbnMr(C_UmuKbn pKykTratkityuiUmuKbnMr) {

        this.kykTratkityuiUmuKbnMr = pKykTratkityuiUmuKbnMr;
    }

    public C_UmuKbn getUktTratkityuiUmuKbnMr() {

        return this.uktTratkityuiUmuKbnMr;
    }

    public void setUktTratkityuiUmuKbnMr(C_UmuKbn pUktTratkityuiUmuKbnMr) {

        this.uktTratkityuiUmuKbnMr = pUktTratkityuiUmuKbnMr;
    }

    public C_UmuKbn getHhknSntkinfohnsyUmuKbnMr() {

        return this.hhknSntkinfohnsyUmuKbnMr;
    }

    public void setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn pHhknSntkinfohnsyUmuKbnMr) {

        this.hhknSntkinfohnsyUmuKbnMr = pHhknSntkinfohnsyUmuKbnMr;
    }

    public C_UmuKbn getKykSntkinfohnsyUmuKbnMr() {

        return this.kykSntkinfohnsyUmuKbnMr;
    }

    public void setKykSntkinfohnsyUmuKbnMr(C_UmuKbn pKykSntkinfohnsyUmuKbnMr) {

        this.kykSntkinfohnsyUmuKbnMr = pKykSntkinfohnsyUmuKbnMr;
    }

    public C_UmuKbn getUktSntkinfohnsyUmuKbnMr() {

        return this.uktSntkinfohnsyUmuKbnMr;
    }

    public void setUktSntkinfohnsyUmuKbnMr(C_UmuKbn pUktSntkinfohnsyUmuKbnMr) {

        this.uktSntkinfohnsyUmuKbnMr = pUktSntkinfohnsyUmuKbnMr;
    }

    public C_UmuKbn getHhknTratkityuiUmuKbnSignal() {

        return this.hhknTratkityuiUmuKbnSignal;
    }

    public void setHhknTratkityuiUmuKbnSignal(C_UmuKbn pHhknTratkityuiUmuKbnSignal) {

        this.hhknTratkityuiUmuKbnSignal = pHhknTratkityuiUmuKbnSignal;
    }

    public C_UmuKbn getKykTratkityuiUmuKbnSignal() {

        return this.kykTratkityuiUmuKbnSignal;
    }

    public void setKykTratkityuiUmuKbnSignal(C_UmuKbn pKykTratkityuiUmuKbnSignal) {

        this.kykTratkityuiUmuKbnSignal = pKykTratkityuiUmuKbnSignal;
    }

    public C_UmuKbn getUktTratkityuiUmuKbnSignal() {

        return this.uktTratkityuiUmuKbnSignal;
    }

    public void setUktTratkityuiUmuKbnSignal(C_UmuKbn pUktTratkityuiUmuKbnSignal) {

        this.uktTratkityuiUmuKbnSignal = pUktTratkityuiUmuKbnSignal;
    }

    public C_UmuKbn getHhknInfohnsyUmuKbnSignal() {

        return this.hhknInfohnsyUmuKbnSignal;
    }

    public void setHhknInfohnsyUmuKbnSignal(C_UmuKbn pHhknInfohnsyUmuKbnSignal) {

        this.hhknInfohnsyUmuKbnSignal = pHhknInfohnsyUmuKbnSignal;
    }

    public C_UmuKbn getKykInfohnsyUmuKbnSignal() {

        return this.kykInfohnsyUmuKbnSignal;
    }

    public void setKykInfohnsyUmuKbnSignal(C_UmuKbn pKykInfohnsyUmuKbnSignal) {

        this.kykInfohnsyUmuKbnSignal = pKykInfohnsyUmuKbnSignal;
    }

    public C_UmuKbn getUktInfohnsyUmuKbnSignal() {

        return this.uktInfohnsyUmuKbnSignal;
    }

    public void setUktInfohnsyUmuKbnSignal(C_UmuKbn pUktInfohnsyUmuKbnSignal) {

        this.uktInfohnsyUmuKbnSignal = pUktInfohnsyUmuKbnSignal;
    }

    public C_UmuKbn getHhknGaikokupepsumukbn() {
        return this.hhknGaikokupepsumukbn;
    }

    public void setHhknGaikokupepsumukbn(C_UmuKbn pHhknGaikokupepsumukbn) {
        this.hhknGaikokupepsumukbn = pHhknGaikokupepsumukbn;
    }

    public C_UmuKbn getKykGaikokupepsumukbn() {
        return this.kykGaikokupepsumukbn;
    }

    public void setKykGaikokupepsumukbn(C_UmuKbn pKykGaikokupepsumukbn) {
        this.kykGaikokupepsumukbn = pKykGaikokupepsumukbn;
    }

    public C_UmuKbn getUktGaikokupepsumukbn() {
        return this.uktGaikokupepsumukbn;
    }

    public void setUktGaikokupepsumukbn(C_UmuKbn pUktGaikokupepsumukbn) {
        this.uktGaikokupepsumukbn = pUktGaikokupepsumukbn;
    }

    public C_UmuKbn getHhknSinsntkhnsyumukbn() {

        return this.hhknSinsntkhnsyUmuKbn;
    }

    public void setHhknSinsntkhnsyumukbn(C_UmuKbn pHhknSinsntkhnsyumukbn) {

        this.hhknSinsntkhnsyUmuKbn = pHhknSinsntkhnsyumukbn;
    }

    public C_UmuKbn getKykSinsntkhnsyumukbn() {

        return this.kykSinsntkhnsyUmuKbn;
    }

    public void setKykSinsntkhnsyumukbn(C_UmuKbn pKykSinsntkhnsyumukbn) {

        this.kykSinsntkhnsyUmuKbn = pKykSinsntkhnsyumukbn;
    }

    public C_UmuKbn getUktSinsntkhnsyumukbn() {

        return this.uktSinsntkhnsyUmuKbn;
    }

    public void setUktSinsntkhnsyumukbn(C_UmuKbn pUktSinsntkhnsyumukbn) {

        this.uktSinsntkhnsyUmuKbn = pUktSinsntkhnsyumukbn;
    }

    public C_YouhiblnkKbn getHhknItekisntkhndktYhKbn() {
        return this.hhknItekisntkhndktYhKbn;
    }

    public void setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn pHhknItekisntkhndktYhKbn) {
        this.hhknItekisntkhndktYhKbn = pHhknItekisntkhndktYhKbn;
    }

    public C_YouhiblnkKbn getHhknTtdkTyuuiKnkHndktYhKbn() {
        return this.hhknTtdkTyuuiKnkHndktYhKbn;
    }

    public void setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn pHhknTtdkTyuuiKnkHndktYhKbn) {
        this.hhknTtdkTyuuiKnkHndktYhKbn = pHhknTtdkTyuuiKnkHndktYhKbn;
    }

    public C_YouhiblnkKbn getKykTtdkTyuuiKnkHndktYhKbn() {
        return this.kykTtdkTyuuiKnkHndktYhKbn;
    }

    public void setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn pKykTtdkTyuuiKnkHndktYhKbn) {
        this.kykTtdkTyuuiKnkHndktYhKbn = pKykTtdkTyuuiKnkHndktYhKbn;
    }

    public C_YouhiblnkKbn getUktTtdkTyuuiKnkHndktYhKbn() {
        return this.uktTtdkTyuuiKnkHndktYhKbn;
    }

    public void setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn pUktTtdkTyuuiKnkHndktYhKbn) {
        this.uktTtdkTyuuiKnkHndktYhKbn = pUktTtdkTyuuiKnkHndktYhKbn;
    }

    public C_YouhiblnkKbn getHhknKyhkinUktkAriItkHndktYhKbn() {
        return this.hhknKyhkinUktkAriItkHndktYhKbn;
    }

    public void setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn pHhknKyhkinUktkAriItkHndktYhKbn) {
        this.hhknKyhkinUktkAriItkHndktYhKbn = pHhknKyhkinUktkAriItkHndktYhKbn;
    }

    public C_YouhiblnkKbn getDoujiMosItekiHndktYhKbn() {
        return this.doujiMosItekiHndktYhKbn;
    }

    public void setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn pDoujiMosItekiHndktYhKbn) {
        this.doujiMosItekiHndktYhKbn = pDoujiMosItekiHndktYhKbn;
    }

    public C_YouhiblnkKbn getDoujiMosKnkHndktYhKbn() {
        return this.doujiMosKnkHndktYhKbn;
    }

    public void setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn pDoujiMosKnkHndktYhKbn) {
        this.doujiMosKnkHndktYhKbn = pDoujiMosKnkHndktYhKbn;
    }

    public C_UmuKbn getUktNayosehumeiUmuKbn() {

        return this.uktNayosehumeiUmuKbn;
    }

    public void setUktNayosehumeiuUmuKbn(C_UmuKbn pUktNayosehumeiUmuKbn) {

        this.uktNayosehumeiUmuKbn = pUktNayosehumeiUmuKbn;
    }

    public List<String> getListKkiykDoujiMosSyonoPal() {
        return this.listKkiykDoujiMosSyonoPal;
    }

    public void setListKkiykDoujiMosSyonoPal(List<String> pListKkiykDoujiMosSyonoPal) {
        this.listKkiykDoujiMosSyonoPal = pListKkiykDoujiMosSyonoPal;
    }

    public List<String> getListSkDoujiMosMosnoPal() {
        return this.listSkDoujiMosMosnoPal;
    }

    public void setListSkDoujiMosMosnoPal(List<String> pListSkDoujiMosMosnoPal) {
        this.listSkDoujiMosMosnoPal = pListSkDoujiMosMosnoPal;
    }

    public BizDate getFstnyknTyakkinYmd() {
        return this.fstnyknTyakkinYmd;
    }

    public void setFstnyknTyakkinYmd(BizDate pFstnyknTyakkinYmd) {
        this.fstnyknTyakkinYmd = pFstnyknTyakkinYmd;
    }

    public BizNumber getNyuukinKawaseRate() {
        return this.nyuukinKawaseRate;
    }

    public void setNyuukinKawaseRate(BizNumber pNyuukinKawaseRate) {
        this.nyuukinKawaseRate = pNyuukinKawaseRate;
    }

    public BT_GyoumuKouteiInfo getGyoumuKouteiInfo() {
        return gyoumuKouteiInfo;
    }

    public void setGyoumuKouteiInfo(BT_GyoumuKouteiInfo  pGyoumuKouteiInfo) {
        this.gyoumuKouteiInfo = pGyoumuKouteiInfo;
    }

    public List<HT_HubiMsg> getListHubiMsg() {
        return listHubiMsg;
    }

    public void setListHubiMsg(List<HT_HubiMsg> pListHubiMsg) {
        this.listHubiMsg = pListHubiMsg;
    }

    public HT_MosnoKanri getMosnoKanri() {
        return mosnoKanri;
    }

    public void setMosnoKanri(HT_MosnoKanri pMosnoKanri) {
        this.mosnoKanri = pMosnoKanri;
    }

    public BizNumber getNyuuryokuKawaseRate() {
        return nyuuryokuKawaseRate;
    }

    public void setNyuuryokuKawaseRate(BizNumber pNyuuryokuKawaseRate) {
        this.nyuuryokuKawaseRate = pNyuuryokuKawaseRate;
    }

    public boolean getNensyuTuusanSOverHanteiKekka() {
        return nensyuTuusanSOverHanteiKekka;
    }

    public void setNensyuTuusanSOverHanteiKekka(boolean pNensyuTuusanSOverHanteiKekka) {
        this.nensyuTuusanSOverHanteiKekka = pNensyuTuusanSOverHanteiKekka;
    }

    public BizCurrency getTsnketsibous() {
        return tsnketsibous;
    }

    public void setTsnketsibous(BizCurrency pTsnketsibous) {
        this.tsnketsibous = pTsnketsibous;
    }

    public C_SpKeisanKahiKbn getKthjiSpKeisanKahiKbn() {
        return kthjiSpKeisanKahiKbn;
    }

    public void setKthjiSpKeisanKahiKbn(C_SpKeisanKahiKbn pKthjiSpKeisanKahiKbn) {
        this.kthjiSpKeisanKahiKbn = pKthjiSpKeisanKahiKbn;
    }

    public BM_SyouhnZokusei getSyuSyouhnZokusei(){

        return syuSyouhnZokusei;
    }

    public void setSyuSyouhnZokusei(BM_SyouhnZokusei pSyuSyouhnZokusei) {

        this.syuSyouhnZokusei = pSyuSyouhnZokusei;
    }

    public List<BM_SyouhnZokusei> getListTkSyouhnZokusei() {
        return listTkSyouhnZokusei;
    }

    public void setListTkSyouhnZokusei(List<BM_SyouhnZokusei> pListTkSyouhnZokusei) {
        this.listTkSyouhnZokusei = pListTkSyouhnZokusei;
    }

    public C_Channelcd getKiteiCheckChannelCd() {
        return kiteiCheckChannelCd;
    }

    public void setKiteiCheckChannelCd(C_Channelcd pKiteiCheckChannelCd) {
        this.kiteiCheckChannelCd = pKiteiCheckChannelCd;
    }

    public C_IkkatuyouptknKbn getBeforeCheckIkkatuyouptknKbn() {
        return beforeCheckIkkatuyouptknKbn;
    }

    public void setBeforeCheckIkkatuyouptknKbn(C_IkkatuyouptknKbn pBeforeCheckIkkatuyouptknKbn) {
        this.beforeCheckIkkatuyouptknKbn = pBeforeCheckIkkatuyouptknKbn;
    }

    public Integer getBeforeCheckIkkatuyoupkaisuu() {
        return beforeCheckIkkatuyoupkaisuu;
    }

    public void setBeforeCheckIkkatuyoupkaisuu(Integer pBeforeCheckIkkatuyoupkaisuu) {
        this.beforeCheckIkkatuyoupkaisuu = pBeforeCheckIkkatuyoupkaisuu;
    }

    public C_SekmossakuseiKbn getSekmossakuseiKbn() {
        return sekmossakuseiKbn;
    }

    public void setSekmossakuseiKbn(C_SekmossakuseiKbn pSekmossakuseiKbn) {
        this.sekmossakuseiKbn = pSekmossakuseiKbn;
    }

    public C_SekmossakuseiErroutKbn getSekmossakuseiErroutKbn() {
        return sekmossakuseiErroutKbn;
    }

    public void setSekmossakuseiErroutKbn(C_SekmossakuseiErroutKbn pSekmossakuseiErroutKbn) {
        this.sekmossakuseiErroutKbn = pSekmossakuseiErroutKbn;
    }

    public String getSekmossakuseiErrmsg1() {
        return sekmossakuseiErrmsg1;
    }

    public void setSekmossakuseiErrmsg1(String pSekmossakuseiErrmsg1) {
        this.sekmossakuseiErrmsg1 = pSekmossakuseiErrmsg1;
    }

    public String getSekmossakuseiErrmsg2() {
        return sekmossakuseiErrmsg2;
    }

    public void setSekmossakuseiErrmsg2(String pSekmossakuseiErrmsg2) {
        this.sekmossakuseiErrmsg2 = pSekmossakuseiErrmsg2;
    }


    public C_SeihowebsousasyaKbn getSekmossakuseiSousasyaKbn() {
        return sekmossakuseiSousasyaKbn;
    }

    public void setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn sekmossakuseiSousasyaKbn) {
        this.sekmossakuseiSousasyaKbn = sekmossakuseiSousasyaKbn;
    }

    public String getSekmossakuseiOyaAgCd() {
        return sekmossakuseiOyaAgCd;
    }

    public void setSekmossakuseiOyaAgCd(String pSekmossakuseiOyaAgCd) {
        this.sekmossakuseiOyaAgCd = pSekmossakuseiOyaAgCd;
    }

    public C_UmuKbn getSekmossakuseiNayoseHumeiKbn() {
        return sekmossakuseiNayoseHumeiKbn;
    }

    public void setSekmossakuseiNayoseHumeiKbn(C_UmuKbn pSekmossakuseiNayoseHumeiKbn) {
        this.sekmossakuseiNayoseHumeiKbn = pSekmossakuseiNayoseHumeiKbn;
    }

    public C_UmuKbn getSekmossakuseiHrksknnyrykUmuKbn() {
        return sekmossakuseiHrksknnyrykUmuKbn;
    }

    public void setSekmossakuseiHrksknnyrykUmuKbn(C_UmuKbn pSekmossakuseiHrksknnyrykUmuKbn) {
        this.sekmossakuseiHrksknnyrykUmuKbn = pSekmossakuseiHrksknnyrykUmuKbn;
    }

    public List<HT_SkDenpyoData> getListSkDenpyoData() {
        return listSkDenpyoData;
    }

    public void setListSkDenpyoData(List<HT_SkDenpyoData> pListSkDenpyoData) {
        this.listSkDenpyoData = pListSkDenpyoData;
    }

    public C_UmuKbn getHhknNayosejissiUmuKbnSeijyou() {
        return hhknNayosejissiUmuKbnSeijyou;
    }

    public void setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn pHhknNayosejissiUmuKbnSeijyou) {
        this.hhknNayosejissiUmuKbnSeijyou = pHhknNayosejissiUmuKbnSeijyou;
    }

    public C_UmuKbn getCheckspJissiUmuKbnSeijyou() {
        return checkspJissiUmuKbnSeijyou;
    }

    public void setCheckspJissiUmuKbnSeijyou(C_UmuKbn pCheckspJissiUmuKbnSeijyou) {
        this.checkspJissiUmuKbnSeijyou = pCheckspJissiUmuKbnSeijyou;
    }

    public C_UmuKbn getNayoseKaihiUmuKbn() {
        return nayoseKaihiUmuKbn;
    }

    public void setNayoseKaihiUmuKbn(C_UmuKbn pNayoseKaihiUmuKbn) {
        this.nayoseKaihiUmuKbn = pNayoseKaihiUmuKbn;
    }

    public BizNumber getPRate() {
        return pRate;
    }

    public void setPRate(BizNumber pPRate) {
        this.pRate = pPRate;
    }

    public BizNumber getPdateSRate() {
        return pdateSRate;
    }

    public void setPdateSRate(BizNumber pPdateSRate) {
        this.pdateSRate = pPdateSRate;
    }

    public BizNumber getHrbtJyousu() {
        return hrbtJyousu;
    }

    public void setHrbtJyousu(BizNumber pHrbtJyousu) {
        this.hrbtJyousu = pHrbtJyousu;
    }

    public C_UmuKbn getTkrtkKinyuuknUmuKbn() {
        return tkrtkKinyuuknUmuKbn;
    }

    public void setTkrtkKinyuuknUmuKbn(C_UmuKbn pTkrtkKinyuuknUmuKbn) {
        this.tkrtkKinyuuknUmuKbn = pTkrtkKinyuuknUmuKbn;
    }

    public C_UmuKbn getKydsskKinyuuknUmuKbn() {
        return kydsskKinyuuknUmuKbn;
    }

    public void setKydsskKinyuuknUmuKbn(C_UmuKbn pKydsskKinyuuknUmuKbn) {
        this.kydsskKinyuuknUmuKbn = pKydsskKinyuuknUmuKbn;
    }

    public C_UmuKbn getKykDairiTratkityuiUmuKbnMr() {
        return this.kykDairiTratkityuiUmuKbnMr;
    }

    public void setKykDairiTratkityuiUmuKbnMr(C_UmuKbn pKykDairiTratkityuiUmuKbnMr) {
        this.kykDairiTratkityuiUmuKbnMr = pKykDairiTratkityuiUmuKbnMr;
    }

    public C_UmuKbn getHhknDairiTratkityuiUmuKbnMr() {
        return this.hhknDairiTratkityuiUmuKbnMr;
    }

    public void setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn pHhknDairiTratkityuiUmuKbnMr) {
        this.hhknDairiTratkityuiUmuKbnMr = pHhknDairiTratkityuiUmuKbnMr;
    }

    public C_UmuKbn getKykDairiSntkinfohnsyUmuKbnMr() {
        return this.kykDairiSntkinfohnsyUmuKbnMr;
    }

    public void setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn pKykDairiSntkinfohnsyUmuKbnMr) {
        this.kykDairiSntkinfohnsyUmuKbnMr = pKykDairiSntkinfohnsyUmuKbnMr;
    }

    public C_UmuKbn getHhknDairiSntkinfohnsyUmuKbnMr() {
        return this.hhknDairiSntkinfohnsyUmuKbnMr;
    }

    public void setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn pHhknDairiSntkinfohnsyUmuKbnMr) {
        this.hhknDairiSntkinfohnsyUmuKbnMr = pHhknDairiSntkinfohnsyUmuKbnMr;
    }

    public C_UmuKbn getKykDairiTratkityuiUmuKbnSignal() {
        return this.kykDairiTratkityuiUmuKbnSignal;
    }

    public void setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn pKykDairiTratkityuiUmuKbnSignal) {
        this.kykDairiTratkityuiUmuKbnSignal = pKykDairiTratkityuiUmuKbnSignal;
    }

    public C_UmuKbn getHhknDairiTratkityuiUmuKbnSignal() {
        return this.hhknDairiTratkityuiUmuKbnSignal;
    }

    public void setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn pHhknDairiTratkityuiUmuKbnSignal) {
        this.hhknDairiTratkityuiUmuKbnSignal = pHhknDairiTratkityuiUmuKbnSignal;
    }

    public C_UmuKbn getKykDairiInfohnsyUmuKbnSignal() {
        return this.kykDairiInfohnsyUmuKbnSignal;
    }

    public void setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn pKykDairiInfohnsyUmuKbnSignal) {
        this.kykDairiInfohnsyUmuKbnSignal = pKykDairiInfohnsyUmuKbnSignal;
    }

    public C_UmuKbn getHhknDairiInfohnsyUmuKbnSignal() {
        return this.hhknDairiInfohnsyUmuKbnSignal;
    }

    public void setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn pHhknDairiInfohnsyUmuKbnSignal) {
        this.hhknDairiInfohnsyUmuKbnSignal = pHhknDairiInfohnsyUmuKbnSignal;
    }

    public C_UmuKbn getKykDairiGaikokupepsumukbn() {
        return this.kykDairiGaikokupepsumukbn;
    }

    public void setKykDairiGaikokupepsumukbn(C_UmuKbn pKykDairiGaikokupepsumukbn) {
        this.kykDairiGaikokupepsumukbn = pKykDairiGaikokupepsumukbn;
    }

    public C_UmuKbn getHhknDairiGaikokupepsumukbn() {
        return this.hhknDairiGaikokupepsumukbn;
    }

    public void setHhknDairiGaikokupepsumukbn(C_UmuKbn pHhknDairiGaikokupepsumukbn) {
        this.hhknDairiGaikokupepsumukbn = pHhknDairiGaikokupepsumukbn;
    }

    public C_UmuKbn getKykDairiSinsntkhnsyUmuKbn() {
        return this.kykDairiSinsntkhnsyUmuKbn;
    }

    public void setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn pKykDairiSinsntkhnsyUmuKbn) {
        this.kykDairiSinsntkhnsyUmuKbn = pKykDairiSinsntkhnsyUmuKbn;
    }

    public C_UmuKbn getHhknDairiSinsntkhnsyUmuKbn() {
        return this.hhknDairiSinsntkhnsyUmuKbn;
    }

    public void setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn pHhknDairiSinsntkhnsyUmuKbn) {
        this.hhknDairiSinsntkhnsyUmuKbn = pHhknDairiSinsntkhnsyUmuKbn;
    }

    public C_YouhiblnkKbn getKykDairiTtdkTyuuiKnkHndktYhKbn() {
        return this.kykDairiTtdkTyuuiKnkHndktYhKbn;
    }

    public void setKykDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn pKykDairiTtdkTyuuiKnkHndktYhKbn) {
        this.kykDairiTtdkTyuuiKnkHndktYhKbn = pKykDairiTtdkTyuuiKnkHndktYhKbn;
    }

    public C_YouhiblnkKbn getHhknDairiTtdkTyuuiKnkHndktYhKbn() {
        return this.hhknDairiTtdkTyuuiKnkHndktYhKbn;
    }

    public void setHhknDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn pHhknDairiTtdkTyuuiKnkHndktYhKbn) {
        this.hhknDairiTtdkTyuuiKnkHndktYhKbn = pHhknDairiTtdkTyuuiKnkHndktYhKbn;
    }

    public C_UmuKbn getKykDairiNayosehumeiUmuKbn() {
        return this.kykDairiNayosehumeiUmuKbn;
    }

    public void setKykDairiNayosehumeiUmuKbn(C_UmuKbn pKykDairiNayosehumeiUmuKbn) {
        this.kykDairiNayosehumeiUmuKbn = pKykDairiNayosehumeiUmuKbn;
    }

    public C_UmuKbn getHhknDairiNayosehumeiUmuKbn() {
        return this.hhknDairiNayosehumeiUmuKbn;
    }

    public void setHhknDairiNayosehumeiUmuKbn(C_UmuKbn pHhknDairiNayosehumeiUmuKbn) {
        this.hhknDairiNayosehumeiUmuKbn = pHhknDairiNayosehumeiUmuKbn;
    }

    public Tuusan getTuusan() {
        return this.tuusan;
    }

    public void setTuusan(Tuusan pTuusan) {
        this.tuusan = pTuusan;
    }

    public BM_SyouhnZokusei getSyouhnZokusei(String pSyouhnCd, Integer pSyouhnSdNo) {

        if (this.syuSyouhnZokusei != null && this.syuSyouhnZokusei.getSyouhncd().equals(pSyouhnCd)
            && this.syuSyouhnZokusei.getSyouhnsdno().equals(pSyouhnSdNo)) {

            return this.syuSyouhnZokusei;
        }
        for (int n = 0; n < this.listTkSyouhnZokusei.size(); n++) {
            if (this.listTkSyouhnZokusei.get(n).getSyouhncd().equals(pSyouhnCd)
                && this.listTkSyouhnZokusei.get(n).getSyouhnsdno().equals(pSyouhnSdNo)) {

                return this.listTkSyouhnZokusei.get(n);
            }
        }
        return null;
    }

    public void debug(String pAddMsg) {

        if (logger.isDebugEnabled()) {

            logger.debug(" ▽ 申込内容チェックパラメータ 保持値 " + pAddMsg);
            logger.debug(" カテゴリＩＤ                                   = [" + this.categoryID + "]");
            logger.debug(" 機能ＩＤ                                       = [" + this.kinouID + "]");
            logger.debug(" 決定要否区分                                   = [" + this.ketteiYouhiKbn + "]");
            logger.debug(" 査定完了区分                                   = [" + this.sateiKanryouKbn + "]");
            logger.debug(" 新規変更区分                                   = [" + this.sinkiHnkKbn + "]");
            logger.debug(" 契約者区分（変更前）                           = [" + this.kykKbn_HnkMae + "]");
            logger.debug(" 被保険者訂正有無                               = [" + this.hhknTeisei + "]");
            logger.debug(" 契約者訂正有無                                 = [" + this.kykTeisei + "]");
            logger.debug(" ハンド決定指示区分                             = [" + this.ketteiSijiKbn + "]");
            logger.debug(" 契約確認種類                                   = [" + this.kykKakuninSyurui + "]");
            logger.debug(" 予定契約日区分                                 = [" + this.yoteiKykymdKbn + "]");
            logger.debug(" システム区分                                   = [" + this.sysKbn + "]");
            logger.debug(" システム処理日                                 = [" + this.sysDate + "]");
            logger.debug(" 営業支援用利用元システム区分                   = [" + this.eshienRiyoumotoSysKbn + "]");
            logger.debug(" 更新者ＩＤ                                     = [" + this.kosID + "]");
            logger.debug(" 更新時間                                       = [" + this.kosTime + "]");
            logger.debug(" 決定指示書要否区分                             = [" + this.ketteiSijisyoYouhiKbn + "]");
            logger.debug(" 契約確認依頼書要否区分                         = [" + this.kykKakuninIraisyoYouhiKbn + "]");
            logger.debug(" 後続処理実行区分                               = [" + this.kouzokuSyoriJikkouKbn + "]");
            logger.debug(" チェック結果区分                               = [" + this.chkKekkaKbn + "]");
            logger.debug(" 告知扱チェック結果区分                         = [" + this.kokutiChkKekkaKbn + "]");
            logger.debug(" 告知扱チェック不要有無                         = [" + this.kokutiChkHuyoUmu + "]");
            logger.debug(" 索引通算区分                                   = [" + this.sakuinTsnKbn + "]");
            logger.debug(" セット相手申込番号                             = [" + this.setAiteMosNo + "]");
            logger.debug(" セット相手主契約商品コード                     = [" + this.setAiteSyuSyouhnCd + "]");
            logger.debug(" 取扱代理店コード                               = [" + this.tratkiAgCd + "]");
            logger.debug(" 通算チェックパターン区分                       = [" + this.tsnCheckPtnKbn + "]");
            logger.debug(" 募集システム制御区分                           = [" + this.bosyuuSysCtrlKbn + "]");
            logger.debug(" 特殊取扱基準区分                               = [" + this.tksyTratkiKjn + "]");
            logger.debug(" 解約同時申込設計有無                           = [" + this.kaiyakuDoujiSekUmu + "]");
            logger.debug(" フリーインシュアランス該当有無                 = [" + this.freeinsuranceUmu + "]");
            logger.debug(" クレジットカード情報TBLチェックエラー有無      = [" + this.creditCardInfoTblChkErrUmu + "]");
            logger.debug(" 最低保険料チェックエラー有無                   = [" + this.saiteiPChkErrUmu + "]");
            logger.debug(" 申込受付区分                                   = [" + this.mosUketukeKbn + "]");
            logger.debug(" 被保険者取扱注意情報有無区分（MR）             = [" + this.hhknTratkityuiUmuKbnMr + "]");
            logger.debug(" 契約者取扱注意情報有無区分（MR）               = [" + this.kykTratkityuiUmuKbnMr + "]");
            logger.debug(" 受取人取扱注意情報有無区分（MR）               = [" + this.uktTratkityuiUmuKbnMr + "]");
            logger.debug(" 契約者代理人取扱注意情報有無区分（MR）         = [" + this.kykDairiTratkityuiUmuKbnMr + "]");
            logger.debug(" 被保険者代理人取扱注意情報有無区分（MR）       = [" + this.hhknDairiTratkityuiUmuKbnMr + "]");
            logger.debug(" 被保険者選択情報反社有無区分（MR）             = [" + this.hhknSntkinfohnsyUmuKbnMr + "]");
            logger.debug(" 契約者選択情報反社有無区分（MR）               = [" + this.kykSntkinfohnsyUmuKbnMr + "]");
            logger.debug(" 受取人選択情報反社有無区分（MR）               = [" + this.uktSntkinfohnsyUmuKbnMr + "]");
            logger.debug(" 契約者代理人選択情報反社有無区分（MR）         = [" + this.kykDairiSntkinfohnsyUmuKbnMr + "]");
            logger.debug(" 被保険者代理人選択情報反社有無区分（MR）       = [" + this.hhknDairiSntkinfohnsyUmuKbnMr + "]");
            logger.debug(" 被保険者取扱注意情報有無区分（シグナル）       = [" + this.hhknTratkityuiUmuKbnSignal + "]");
            logger.debug(" 契約者取扱注意情報有無区分（シグナル）         = [" + this.kykTratkityuiUmuKbnSignal + "]");
            logger.debug(" 受取人取扱注意情報有無区分（シグナル）         = [" + this.uktTratkityuiUmuKbnSignal + "]");
            logger.debug(" 契約者代理人取扱注意情報有無区分（シグナル）   = [" + this.kykDairiTratkityuiUmuKbnSignal + "]");
            logger.debug(" 被保険者代理人取扱注意情報有無区分（シグナル） = [" + this.hhknDairiTratkityuiUmuKbnSignal + "]");
            logger.debug(" 被保険者情報反社有無区分（シグナル）           = [" + this.hhknInfohnsyUmuKbnSignal + "]");
            logger.debug(" 契約者情報反社有無区分（シグナル）             = [" + this.kykInfohnsyUmuKbnSignal + "]");
            logger.debug(" 受取人情報反社有無区分（シグナル）             = [" + this.uktInfohnsyUmuKbnSignal + "]");
            logger.debug(" 契約者代理人情報反社有無区分（シグナル）       = [" + this.kykDairiInfohnsyUmuKbnSignal + "]");
            logger.debug(" 被保険者代理人情報反社有無区分（シグナル）     = [" + this.hhknDairiInfohnsyUmuKbnSignal + "]");
            logger.debug(" 被保険者外国ＰＥＰｓ有無区分                   = [" + this.hhknGaikokupepsumukbn + "]");
            logger.debug(" 契約者外国ＰＥＰｓ有無区分                     = [" + this.kykGaikokupepsumukbn + "]");
            logger.debug(" 受取人外国ＰＥＰｓ有無区分                     = [" + this.uktGaikokupepsumukbn + "]");
            logger.debug(" 契約者代理人外国ＰＥＰｓ有無区分               = [" + this.kykDairiGaikokupepsumukbn + "]");
            logger.debug(" 被保険者代理人外国ＰＥＰｓ有無区分             = [" + this.hhknDairiGaikokupepsumukbn + "]");
            logger.debug(" 被保険者新選択情報反社有無区分                 = [" + this.hhknSinsntkhnsyUmuKbn + "]");
            logger.debug(" 契約者新選択情報反社有無区分                   = [" + this.kykSinsntkhnsyUmuKbn + "]");
            logger.debug(" 受取人新選択情報反社有無区分                   = [" + this.uktSinsntkhnsyUmuKbn + "]");
            logger.debug(" 契約者代理人新選択情報反社有無区分             = [" + this.kykDairiSinsntkhnsyUmuKbn + "]");
            logger.debug(" 被保険者代理人新選択情報反社有無区分           = [" + this.hhknDairiSinsntkhnsyUmuKbn + "]");
            logger.debug(" 被保険者医的選択情報ハンド決定要否区分         = [" + this.hhknItekisntkhndktYhKbn + "]");
            logger.debug(" 被保険者手続注意環境ハンド決定要否区分         = [" + this.hhknTtdkTyuuiKnkHndktYhKbn + "]");
            logger.debug(" 契約者手続注意環境ハンド決定要否区分           = [" + this.kykTtdkTyuuiKnkHndktYhKbn + "]");
            logger.debug(" 受取人手続注意環境ハンド決定要否区分           = [" + this.uktTtdkTyuuiKnkHndktYhKbn + "]");
            logger.debug(" 契約者代理人手続注意環境ハンド決定要否区分     = [" + this.kykDairiTtdkTyuuiKnkHndktYhKbn + "]");
            logger.debug(" 被保険者代理人手続注意環境ハンド決定要否区分   = [" + this.hhknDairiTtdkTyuuiKnkHndktYhKbn + "]");
            logger.debug(" 被保険者給付金受付有医的ハンド決定要否区分     = [" + this.hhknKyhkinUktkAriItkHndktYhKbn + "]");
            logger.debug(" 同時申込医的ハンド決定要否区分                 = [" + this.doujiMosItekiHndktYhKbn + "]");
            logger.debug(" 同時申込環境ハンド決定要否区分                 = [" + this.doujiMosKnkHndktYhKbn + "]");
            logger.debug(" 受取人名寄せ不明有無区分                       = [" + this.uktNayosehumeiUmuKbn + "]");
            logger.debug(" 契約者代理人名寄せ不明有無区分                 = [" + this.kykDairiNayosehumeiUmuKbn + "]");
            logger.debug(" 被保険者代理人名寄せ不明有無区分               = [" + this.hhknDairiNayosehumeiUmuKbn + "]");
            logger.debug(" 初回入金着金日                                 = [" + this.fstnyknTyakkinYmd + "]");
            logger.debug(" 入金用為替レート                               = [" + this.nyuukinKawaseRate + "]");
            logger.debug(" 被保険者名寄せ実施済有無区分（正常終了）       = [" + this.hhknNayosejissiUmuKbnSeijyou + "]");
            logger.debug(" SPチェック実施済有無区分（正常終了）           = [" + this.checkspJissiUmuKbnSeijyou + "]");
            logger.debug(" 名寄せ回避有無区分                             = [" + this.nayoseKaihiUmuKbn + "]");
            logger.debug(" Ｐレート                                       = [" + this.pRate + "]");
            logger.debug(" Ｐ建Ｓレート                                   = [" + this.pdateSRate + "]");
            logger.debug(" 払別乗数                                       = [" + this.hrbtJyousu + "]");
            logger.debug(" 特例地域金融機関有無区分                       = [" + this.tkrtkKinyuuknUmuKbn + "]");
            logger.debug(" 協同組織金融機関有無区分                       = [" + this.kydsskKinyuuknUmuKbn + "]");


            if (this.listKetteiSijiMsgId.size() > 0) {
                logger.debug(" ▽ 決定指示ＭＳＧＩＤ");
                for (int count=0; count<this.listKetteiSijiMsgId.size(); count++) {
                    logger.debug(" ｜   " + this.listKetteiSijiMsgId.get(count));
                }
                logger.debug(" △");
            }
            else {
                logger.debug(" 決定指示ＭＳＧＩＤ           = [なし]");
            }

            if (this.listKetteiSijiMsg.size() > 0) {
                logger.debug(" ▽ 決定指示ＭＳＧ");
                for (int count=0; count < this.listKetteiSijiMsg.size(); count++) {
                    logger.debug(" ｜   " + this.listKetteiSijiMsg.get(count));
                }
                logger.debug(" △");
            }
            else {
                logger.debug(" 決定指示ＭＳＧ             = [なし]");
            }

            if (this.listKykKakuninMsg.size() > 0) {
                logger.debug(" ▽ 契約確認ＭＳＧ");
                for (int count=0; count < this.listKykKakuninMsg.size(); count++) {
                    logger.debug(" ｜   " + this.listKykKakuninMsg.get(count));
                }
                logger.debug(" △");
            }
            else {
                logger.debug(" 契約確認ＭＳＧ             = [なし]");
            }

            if (this.listKekkaGmnMsg.size() > 0) {
                logger.debug(" ▽ 結果画面ＭＳＧ");
                for (int count=0; count < this.listKekkaGmnMsg.size(); count++) {
                    logger.debug(" ｜   " + this.listKekkaGmnMsg.get(count));
                }
                logger.debug(" △");
            }
            else {
                logger.debug(" 結果画面ＭＳＧ             = [なし]");
            }

            if (this.listKkiykDoujiMosSyonoPal.size() > 0) {
                logger.debug(" ▽ 既契約同時申込証券番号リスト（PAL）");
                for (int iCount=0; iCount < this.listKkiykDoujiMosSyonoPal.size(); iCount++) {
                    logger.debug(" ｜   " + this.listKkiykDoujiMosSyonoPal.get(iCount));
                }
                logger.debug(" △");
            }
            else {
                logger.debug(" 既契約同時申込証券番号リスト（PAL）= [なし]");
            }

            if (this.listSkDoujiMosMosnoPal.size() > 0) {
                logger.debug(" ▽ 新契約同時申込申込番号リスト（PAL）");
                for (int iCount=0; iCount < this.listSkDoujiMosMosnoPal.size(); iCount++) {
                    logger.debug(" ｜   " + this.listSkDoujiMosMosnoPal.get(iCount));
                }
                logger.debug(" △");
            }
            else {
                logger.debug(" 新契約同時申込申込番号リスト（PAL）= [なし]");
            }

            if (this.syoriControl != null) {

                logger.debug(" ▽ 処理コントロール");
                logger.debug(" ｜   " + this.syoriControl.toString());
                logger.debug(" △");
            }
            else {
                logger.debug(" 処理コントロール           = [null]");
            }

            if (this.gyoumuKouteiInfo != null) {

                logger.debug(" ▽ 業務用工程情報");
                logger.debug(" ｜   " + this.gyoumuKouteiInfo.toString());
                logger.debug(" △");
            }
            else {
                logger.debug(" 業務用工程情報           = [null]");
            }

            if (this.listHubiMsg.size() > 0) {
                logger.debug(" ▽ 不備メッセージテーブルエンティティリスト");

                for (int iCount = 0; iCount < this.listHubiMsg.size(); iCount++) {
                    logger.debug(" ｜   " + this.listHubiMsg.get(iCount).toString());
                }

                logger.debug(" △");
            }
            else {
                logger.debug(" 不備メッセージテーブルエンティティリスト= [なし]");
            }

            if (this.mosnoKanri != null) {
                logger.debug(" ▽ 申込番号管理テーブル");
                logger.debug(" ｜   " + this.mosnoKanri.toString());
                logger.debug(" △");
            }
            else {
                logger.debug(" 申込番号管理テーブル           = [null]");
            }

            logger.debug(" 入力為替レート                             = [" + this.nyuuryokuKawaseRate + "]");
            logger.debug(" 年収通算Ｓオーバー契約判定結果             = [" + this.nensyuTuusanSOverHanteiKekka + "]");
            logger.debug(" 通算決定総死亡S                            = [" + this.tsnketsibous + "]");
            logger.debug(" 決定保留時ＳＰ計算可否区分                 = [" + this.kthjiSpKeisanKahiKbn + "]");

            if (this.syuSyouhnZokusei != null) {

                logger.debug(" ▽ 主契約商品属性マスタ");
                logger.debug(" ｜   " + this.syuSyouhnZokusei.toString());
                logger.debug(" △");
            }
            else {
                logger.debug(" 主契約商品属性マスタ           = [null]");
            }
            if (this.listTkSyouhnZokusei.size() > 0) {
                logger.debug(" ▽ 特約商品属性マスタリスト");
                for (int iCount=0; iCount < this.listTkSyouhnZokusei.size(); iCount++) {
                    logger.debug(" ｜   " + this.listTkSyouhnZokusei.get(iCount).toString());
                }
                logger.debug(" △");
            }
            else {
                logger.debug(" 特約商品属性マスタリスト= [なし]");
            }

            logger.debug(" 規定チェック用チャネルコード               = [" + this.kiteiCheckChannelCd + "]");
            logger.debug(" （チェック前）一括要Ｐ特認区分             = [" + this.beforeCheckIkkatuyouptknKbn + "]");
            logger.debug(" （チェック前）一括要Ｐ回数                 = [" + this.beforeCheckIkkatuyoupkaisuu + "]");

            if (this.listSkDenpyoData.size() > 0) {
                logger.debug(" ▽ 新契約伝票データテーブルエンティティリスト");
                for (int iCount=0; iCount < this.listSkDenpyoData.size(); iCount++) {
                    logger.debug(" ｜   " + this.listSkDenpyoData.get(iCount).toString());
                }
                logger.debug(" △");
            }
            else {
                logger.debug(" 新契約伝票データテーブルエンティティリスト= [なし]");
            }

            logger.debug(" 設計書申込書作成区分                       = [" + this.sekmossakuseiKbn + "]");
            logger.debug(" 設計書申込書作成エラー出力区分             = [" + this.sekmossakuseiErroutKbn + "]");
            logger.debug(" 設計書申込書作成エラーメッセージ１         = [" + this.sekmossakuseiErrmsg1 + "]");
            logger.debug(" 設計書申込書作成エラーメッセージ２         = [" + this.sekmossakuseiErrmsg2 + "]");
            logger.debug(" 設計書申込書作成操作者区分                 = [" + this.sekmossakuseiSousasyaKbn + "]");
            logger.debug(" 設計書申込書作成親代理店コード             = [" + this.sekmossakuseiOyaAgCd + "]");
            logger.debug(" 設計書申込書作成名寄せ不明区分             = [" + this.sekmossakuseiNayoseHumeiKbn + "]");
            logger.debug(" 設計書申込書作成払込資金入力有無区分       = [" + this.sekmossakuseiHrksknnyrykUmuKbn + "]");
            logger.debug(" △");
        }
    }
}