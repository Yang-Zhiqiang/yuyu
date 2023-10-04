package yuyu.batch.hozen.khinterf.khkeiyakuinfotorikomi;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateSpan;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.ObjectUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetAdrData;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyouriritu;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyourirituBean;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzdairiten.BzGetTuukeiBunwari;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.kaikei.BzDenpyouDataSks;
import yuyu.common.biz.kaikei.BzSinkeiyakuDenpyouDataTourokuBean;
import yuyu.common.hozen.khcommon.CommonSiwake;
import yuyu.common.hozen.khcommon.CommonSiwakeInBean;
import yuyu.common.hozen.khcommon.CommonSiwakeOutBean;
import yuyu.common.hozen.khcommon.EditDairitenTesuuryouTbl;
import yuyu.common.hozen.khcommon.EditHokenKykIdouRirekiTbl;
import yuyu.common.hozen.khcommon.EditHokenKykIdouRirekiTblBean;
import yuyu.common.hozen.khcommon.EditHokenSyoukenParam;
import yuyu.common.hozen.khcommon.EditKhMisslstParam;
import yuyu.common.hozen.khcommon.EditKoujyoSyoumeiParam;
import yuyu.common.hozen.khcommon.EditKoujyoSyoumeiTbl;
import yuyu.common.hozen.khcommon.EditKoujyonaiyouTbl;
import yuyu.common.hozen.khcommon.EditSkYouTtdkKanryouTbl;
import yuyu.common.hozen.khcommon.EditSyoukenTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.GetKhTuusanyouKngk;
import yuyu.common.hozen.khcommon.GetKhTuusanyouKngkBean;
import yuyu.common.hozen.khcommon.HanteiLinc;
import yuyu.common.hozen.khcommon.HanteiLincBean;
import yuyu.common.hozen.khcommon.HanteiTyotikuseihokenBean;
import yuyu.common.hozen.khcommon.KeisanKijyungk;
import yuyu.common.hozen.khcommon.KeisanKoujyogaku;
import yuyu.common.hozen.khcommon.KeisanSisuuRendouNkKykTmttkn;
import yuyu.common.hozen.khcommon.KhTyokusouHantei;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KhozenTyouhyouCtl;
import yuyu.common.hozen.khcommon.KykSyouhnCommonParam;
import yuyu.common.hozen.khcommon.SetCreditUriageSeikyuubi;
import yuyu.common.hozen.khcommon.SetDenSimebi;
import yuyu.common.hozen.khcommon.SetKjsmyouZennouInfo;
import yuyu.common.hozen.khcommon.SetManryoubi;
import yuyu.common.hozen.khcommon.SetSyokenhakkouymd;
import yuyu.common.hozen.khcommon.SetTyotikuseihokenhyouji;
import yuyu.common.hozen.khcommon.TaisyouGkBean;
import yuyu.common.hozen.khcommon.TrkkzkTyokusouhtBean;
import yuyu.common.hozen.khcommon.TyokusouTaisyouBean;
import yuyu.common.hozen.khcommon.ZennouKoujyogakuKeisanParam;
import yuyu.common.hozen.renkei.KhConvUtil;
import yuyu.common.sinkeiyaku.skcommon.SkToujituIdounaiyouEdit;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.*;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_IdouKhBosyuudr;
import yuyu.def.db.entity.BT_IdouKhMeigi;
import yuyu.def.db.entity.BT_TjtIdouNyKh;
import yuyu.def.db.entity.BT_TjtIdouNySk;
import yuyu.def.db.entity.HT_CreditCardJyouhou;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.entity.HT_Kokutisyo;
import yuyu.def.db.entity.HT_KouzaJyouhou;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_MosTrkKzk;
import yuyu.def.db.entity.HT_NayoseKekka;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.db.entity.HT_SkLincTourokuInfo;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Tokujyou;
import yuyu.def.db.entity.HT_UketoriKouzaJyouhou;
import yuyu.def.db.entity.HT_Uketorinin;
import yuyu.def.db.entity.IT_AeoiInfo;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_CreditCardInfo;
import yuyu.def.db.entity.IT_FatcaInfo;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_HokenSyouken;
import yuyu.def.db.entity.IT_ItekiToukeiInfo;
import yuyu.def.db.entity.IT_KhLincKihon;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KoujyoSymKanri;
import yuyu.def.db.entity.IT_KoujyoSymNaiyou;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_SyouhnTokujou;
import yuyu.def.db.entity.IT_TrkKzk;
import yuyu.def.db.entity.IT_UketoriKouza;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.result.bean.NyuukinInfoByMosnoZenhnknkbnSrgonyknumuBean;
import yuyu.def.sinkeiyaku.sorter.SortHT_MosSyouhn;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 契約情報取込
 */
public class KhKeiyakuInfoTorikomiBatch implements Batch {

    private BizDate syoriYmd;

    private String kinouId;

    private String kosId;

    private String sysTime;

    private String sikibetuKey;

    private BizDate syuHaraiManYmd;

    private BizDate rsYmd;

    private HashMap<String, ArrayList<IT_NyknJissekiRireki>> nyknJissekiRirekiMap;

    private IT_KykKihon kykKihon;

    private IT_AnsyuKihon ansyuKihon;

    private HT_MosKihon mosKihon;

    private KhozenCommonParam khozenCommonParam;

    private List<HT_MosSyouhn> mosSyouhnLst;

    private List<HT_Uketorinin> uketorininLst;

    private  List<HT_MosDairiten>  mosDairitenLst;

    HT_CreditCardJyouhou creditCardJyouhou;

    private List<HT_MosTrkKzk> mosTrkKzkLst;

    private List<HT_UketoriKouzaJyouhou> uketoriKouzaJyouhouLst;

    private String todouhukencd;

    private BT_TjtIdouNyKh tjtIdouNyKh;

    private BizDate denSimebi;

    private String busitucdKettei;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam batchParam;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    private ArrayList<EditKhMisslstParam> editKhMisslstParamLst;

    private int seqNo;

    private NyuukinInfoByMosnoZenhnknkbnSrgonyknumuBean nyuukinInfoByMosnoZenhnknkbnSrgonyknumuBean;

    private BizDate ryosyuymdMax;

    private BizDate ryosyuymdMin;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        syoriYmd = batchParam.getSyoriYmd();
        String tysyttaisyouTableId = "HT_SyoriCTL";
        String rikabarifeirudaKbnId = "Sk001";

        int dataNo = 0;
        try ( ExDBUpdatableResults<HT_SyoriCTL>
        rs =sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdSrsyoriymd(batchParam.getIbKakutyoujobcd(),
            syoriYmd);MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();){

            sysTime = BizDate.getSysDateTimeMilli();

            editKhMisslstParamLst = new ArrayList<>();

            nyknJissekiRirekiMap = new HashMap<>();

            ArrayList<String> errSyonoList = new ArrayList<>();

            SetDenSimebi setDenSimebi = SWAKInjector.getInstance(SetDenSimebi.class);
            denSimebi = setDenSimebi.exec(syoriYmd.addBusinessDays(1));
            busitucdKettei = bizDomManager.getTantouCd(C_TantouCdKbn.KETTEI).getBusitucd() + "0000";

            for (HT_SyoriCTL syoriCTL : rs) {
                if (null != syoriCTL.getMosKihon()) {
                    dataNo++;

                    seqNo = 0;

                    khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
                    kinouId = khozenCommonParam.getFunctionId();

                    kosId = khozenCommonParam.getUserID();

                    String syoNo;
                    C_Hrkkeiro hrkKeiro = C_Hrkkeiro.BLNK;

                    EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);
                    editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
                    editTtdkRirekiTblParam.setSyoriYmd(syoriYmd);
                    editTtdkRirekiTblParam.setSysTime(sysTime);

                    HT_MosKihon mosKihon1 = syoriCTL.getMosKihon();
                    mosKihon = new HT_MosKihon();
                    mosKihon = ObjectUtil.deepCopy(mosKihon1);
                    if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {

                        mosKihon.setKyknmkn(mosKihon.getHhknnmkn());
                        mosKihon.setKyknmkj(mosKihon.getHhknnmkj());
                        mosKihon.setKyknmkjkhukakbn(mosKihon.getHhknnmkjkhukakbn());
                        mosKihon.setKykseiymd(mosKihon.getHhknseiymd());

                        C_Hhknsei hhknsei = mosKihon.getHhknsei();
                        if (C_Hhknsei.BLNK.eq(hhknsei)) {
                            mosKihon.setKyksei(C_Kyksei.BLNK);
                        }
                        else if (C_Hhknsei.FEMALE.eq(hhknsei)) {
                            mosKihon.setKyksei(C_Kyksei.FEMALE);
                        }
                        else if (C_Hhknsei.MALE.eq(hhknsei)) {
                            mosKihon.setKyksei(C_Kyksei.MALE);
                        }
                        mosKihon.setKyktdk(C_Tdk.HONNIN);
                    }
                    if (C_TsindousiteiKbn.ARI.eq(mosKihon.getTsindousiteikbn())) {

                        mosKihon.setHhknyno(mosKihon.getTsinyno());
                    }

                    syoNo = syoriCTL.getSyono();

                    bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(batchParam.getIbKakutyoujobcd());
                    bzRecoveryDatasikibetuBean.setIbTableid(tysyttaisyouTableId);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(rikabarifeirudaKbnId);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(mosKihon.getMosno());

                    if (!chkKeiyaku(dataNo, syoNo)) {

                        errSyonoList.add(syoNo);

                        continue;
                    }
                    syuHaraiManYmd = null;
                    rsYmd = null;

                    nyuukinInfoByMosnoZenhnknkbnSrgonyknumuBean =
                        sinkeiyakuDomManager.getNyuukinInfoByMosnoZenhnknkbnSrgonyknumu(syoriCTL.getMosno());
                    ryosyuymdMax = nyuukinInfoByMosnoZenhnknkbnSrgonyknumuBean.getRyosyuymdMax();
                    ryosyuymdMin = nyuukinInfoByMosnoZenhnknkbnSrgonyknumuBean.getRyosyuymdMin();

                    HT_KouzaJyouhou kouzaJyouhou = getKouzainfo(mosKihon,syoriCTL);

                    getCreditCardInfo(mosKihon,syoriCTL);

                    kykKihon = new IT_KykKihon(syoNo);

                    ansyuKihon = new IT_AnsyuKihon(syoNo);

                    khozenCommonParam.setBatchKeiyakuKihon(kykKihon);

                    khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

                    IT_KhTtdkRireki khTtdkRireki =kykKihon.createKhTtdkRireki();

                    khozenCommonParam.setSikibetuKey(null);

                    khTtdkRireki.setHenkousikibetukey(khozenCommonParam.getSikibetuKey(syoNo));

                    getKeiyakuInfo(syoriCTL);

                    editKeiyakusya(mosKihon,syoriCTL);

                    editHihokensya(mosKihon,syoriCTL);

                    C_ErrorKbn errorKbn = editSyouhin(syoriCTL, dataNo, multipleEntityInserter);

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                        continue;
                    }

                    hrkKeiro = mosKihon.getHrkkeiro();
                    if (C_Hrkkeiro.KOUHURI.eq(hrkKeiro)) {

                        editKouza(mosKihon, kouzaJyouhou);
                    }
                    else if (C_Hrkkeiro.CREDIT.eq(hrkKeiro)){

                        editCreditcard();
                    }

                    editUketorinin(syoriCTL);

                    editTrkKzk();

                    editTtdktyuui(syoriCTL);

                    editKykDairiten(syoriCTL);

                    C_SknnkaisikitkhukaKbn sknnkaisikitkhukaKbn = mosKihon.getSknnkaisikitkhukakbn();
                    if (!C_SknnkaisikitkhukaKbn.HUKA.eq(sknnkaisikitkhukaKbn)) {
                        errorKbn = editNyuukinJisseki(mosKihon, syoriCTL, multipleEntityInserter, dataNo);

                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                            continue;
                        }
                    }

                    editAnsyuuKihon(mosKihon,syoriCTL);

                    editKykKihon(syoriCTL, dataNo);

                    if (!C_FatcakakkekkaKbn.BLNK.eq(syoriCTL.getFatcakakkekkakbn())){
                        insFatcaInfo(mosKihon,syoriCTL);
                    }

                    if (!C_AeoiKekkaKbn.BLNK.eq(syoriCTL.getAeoikekkakbn())) {
                        insAeoiInfo(mosKihon, syoriCTL);
                    }

                    Integer renno3Saidai =bizDomManager.getTjtIdouNyKhMaxRenno3ketaBySyono(syoNo);

                    if (renno3Saidai == null){
                        renno3Saidai = 1;
                    }
                    else{
                        renno3Saidai = renno3Saidai +1;
                    }

                    tjtIdouNyKh = new BT_TjtIdouNyKh(syoNo,renno3Saidai);


                    if (C_SyutkKbn.SYU.eq( mosSyouhnLst.get(0).getSyutkkbn())){
                        errorKbn = editTjtIdouNyKh(dataNo, syoNo);

                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                            continue;
                        }
                    }

                    editIdouKhMeigi(kouzaJyouhou);

                    errorKbn = editIdouKhBosyuudr(syoriCTL, dataNo);

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                        continue;
                    }

                    editItekiToukeiInfo(syoriCTL, multipleEntityInserter);

                    HT_SkLincTourokuInfo skLincTourokuInfo = syoriCTL.getSkLincTourokuInfo();
                    if (skLincTourokuInfo != null && skLincTourokuInfo.getKanyuusyano() != 0) {

                        editKhLincKihon(syoriCTL, multipleEntityInserter);
                    }

                    editTtdkRirekiTblParam.setSyoNo(syoNo);
                    editTtdkRirekiTblParam.setSmbcKanriId(mosKihon.getUktkid());

                    EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);
                    editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);

                    EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);

                    editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
                    editHokenKykIdouRirekiTblBean.setSyoNo(syoNo);
                    editHokenKykIdouRirekiTblBean.setSyoriYmd(syoriYmd);
                    editHokenKykIdouRirekiTblBean.setSysDateTime(sysTime);

                    EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
                    editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

                    BizDate nyknYmd = null;
                    int nyknkaisuuTuki = 0;

                    ArrayList<EditKoujyoSyoumeiParam> koujyoSyoumeiParamLst;
                    String syoumeiNendo;

                    ArrayList<IT_NyknJissekiRireki> nyknJissekiRirekiLst = nyknJissekiRirekiMap.get(syoNo);
                    nyknJissekiRirekiMap.clear();
                    if (nyknJissekiRirekiLst != null && nyknJissekiRirekiLst.size() > 0) {
                        nyknYmd = nyknJissekiRirekiLst.get(0).getRyosyuymd();

                        if(mosKihon.getSkjpjyuutoukaisuu() == 1){

                            if (C_Hrkkaisuu.NEN.eq(mosKihon.getHrkkaisuu())) {

                                nyknkaisuuTuki = 12;
                            }
                            else {

                                nyknkaisuuTuki = nyknJissekiRirekiLst.get(0).getJyutoukaisuum();
                            }
                        }
                        else
                        {
                            nyknkaisuuTuki = mosKihon.getSkjpjyuutoukaisuu();
                        }
                    }

                    EditDairitenTesuuryouTbl editDairitenTesuuryouTbl =
                        SWAKInjector.getInstance(EditDairitenTesuuryouTbl.class);
                    editDairitenTesuuryouTbl.setBatchSyoriYmd(syoriYmd);

                    editDairitenTesuuryouTbl.exec(khozenCommonParam,
                        syoNo,
                        C_TsrysyoriKbn.SINKEIYAKUSEIRITU,
                        mosKihon.getKykymd().getBizDateYM(),
                        0,
                        nyknkaisuuTuki,
                        BizCurrency.valueOf(0),
                        BizCurrency.valueOf(0),
                        nyknYmd,
                        null);

                    if (skLincTourokuInfo != null && skLincTourokuInfo.getKanyuusyano() != 0) {

                        HanteiLincBean hanteiLincBean = SWAKInjector.getInstance(HanteiLincBean.class);
                        hanteiLincBean.setSyoriYmd(syoriYmd);
                        hanteiLincBean.setKykKihon(kykKihon);
                        hanteiLincBean.setKanyuusyaNo(skLincTourokuInfo.getKanyuusyano());

                        HanteiLinc hanteiLinc = SWAKInjector.getInstance(HanteiLinc.class);

                        errorKbn = hanteiLinc.exec(hanteiLincBean, khozenCommonParam);

                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                            setMisslistParam(
                                dataNo,
                                "ＬＩＮＣ該当判定が実行できませんでした。",
                                C_Dbhanei.NONE,
                                syoNo);

                            continue;
                        }
                    }

                    if (!C_SknnkaisikitkhukaKbn.HUKA.eq(mosKihon.getSknnkaisikitkhukakbn())) {

                        if (nyknJissekiRirekiLst.size() > 0) {

                            BizDate nyknJskRyosyuYmd = null;

                            EditKoujyonaiyouTbl editKoujyonaiyouTbl = SWAKInjector.getInstance(EditKoujyonaiyouTbl.class);

                            List<KykSyouhnCommonParam> kykSyouhnCommonParamLst = new ArrayList<>();
                            kykSyouhnCommonParamLst.addAll(kykKihon.getKykSyouhns());

                            for (IT_NyknJissekiRireki nyknJissekiRireki : nyknJissekiRirekiLst) {

                                if (C_Hrkkaisuu.ITIJI.eq(mosKihon.getHrkkaisuu())) {
                                    nyknJskRyosyuYmd = nyknJissekiRireki.getRyosyuymd();
                                }
                                else {
                                    nyknJskRyosyuYmd = mosKihon.getKykymd();
                                }

                                editKoujyonaiyouTbl.setIkkatuNyknUmu(nyknJissekiRireki.getIktnyuukinnumu());
                                editKoujyonaiyouTbl.setNyknJskStartYm(nyknJissekiRireki.getJyutoustartym());
                                editKoujyonaiyouTbl.setNyknJskEndYm(nyknJissekiRireki.getJyutouendym());
                                editKoujyonaiyouTbl.setNyknJskRenno(nyknJissekiRireki.getRenno());
                                editKoujyonaiyouTbl.setNyknJskRyosyuYmd(nyknJskRyosyuYmd);
                                editKoujyonaiyouTbl.setNyknJskJytKaisuuY(nyknJissekiRireki.getJyutoukaisuuy());
                                editKoujyonaiyouTbl.setNyknJskJytKaisuuM(nyknJissekiRireki.getJyutoukaisuum());
                                editKoujyonaiyouTbl.setNyknJskRysKwsrate(nyknJissekiRireki.getRyosyukwsrate());
                                editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamLst);

                                if (C_UmuKbn.ARI.eq(mosKihon.getZennoumousideumu())) {

                                    ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam =
                                        SWAKInjector.getInstance(ZennouKoujyogakuKeisanParam.class);

                                    zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(
                                        ansyuKihon.getZennouMsisnsBySyono().get(0).getKjsmyouzennoukaisiymd());
                                    zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm(
                                        ansyuKihon.getZennouMsisnsBySyono().get(0).getKjsmyouzennoukikanm());
                                    zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(
                                        ansyuKihon.getZennouMsisnsBySyono().get(0).getKjsmyouzennounyuukinkgk());
                                    zennouKoujyogakuKeisanParam.setHrkp(mosKihon.getHeijyunp());
                                    zennouKoujyogakuKeisanParam.setHrkkaisuu(mosKihon.getHrkkaisuu());
                                    zennouKoujyogakuKeisanParam.setZennoukaisiymd(
                                        ansyuKihon.getZennouMsisnsBySyono().get(0).getZennoukaisiymd());
                                    zennouKoujyogakuKeisanParam.setZennourenno(
                                        ansyuKihon.getZennouMsisnsBySyono().get(0).getRenno());
                                    zennouKoujyogakuKeisanParam.setKjsmyouyenknsnkawaserate(ansyuKihon
                                        .getZennouMsisnsBySyono().get(0).getKjsmyouyenkansankwsrate());
                                    editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);
                                }

                                editKoujyonaiyouTbl.exec(khozenCommonParam,
                                    syoNo,
                                    C_KjsymnytblhensyuusyoriKbn.NYUUKINHANEI,
                                    syoriYmd);
                            }
                        }
                    }
                    IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
                    C_YennykntksyuruiKbn yennyknTkSyuruiKbn = kykSonotaTkyk.getYennyknsyuruikbn();

                    EditKoujyoSyoumeiParam koujyoSyoumeiParam = SWAKInjector.getInstance(EditKoujyoSyoumeiParam.class);
                    if (!C_Tkhukaumu.HUKA.eq(mosKihon.getKjnnkpzeitekitkhukakbn())
                        && ((C_Hrkkaisuu.TUKI.eq(mosKihon.getHrkkaisuu())
                            && mosKihon.getKykymd().getMonth() >= 9
                            && !C_YennykntksyuruiKbn.PYENHRKM_GKHENDOU.eq(yennyknTkSyuruiKbn))
                            || C_Hrkkaisuu.HALFY.eq(mosKihon.getHrkkaisuu())
                            || C_Hrkkaisuu.NEN.eq(mosKihon.getHrkkaisuu())
                            || C_Hrkkaisuu.ITIJI.eq(mosKihon.getHrkkaisuu()))) {

                        syoumeiNendo = mosKihon.getKykymd().getBizDateY().toString();
                        KeisanKoujyogaku keisanKoujyogaku = SWAKInjector.getInstance(KeisanKoujyogaku.class);
                        keisanKoujyogaku.setKhozenCommonParam(khozenCommonParam);
                        keisanKoujyogaku.exec(syoNo,
                            syoumeiNendo );


                        koujyoSyoumeiParam = keisanKoujyogaku.getParam();
                        koujyoSyoumeiParam.setSinkiSakusei(C_SinsakuseiKbn.SIN);
                        koujyoSyoumeiParam.setKoujyoNendo(syoumeiNendo);
                        koujyoSyoumeiParam.setKoujyoSyuKbn(C_KoujyosyoumeisyuKbn.IPPAN);
                        koujyoSyoumeiParam.setKoujyoSakuseiSyoriKbn(C_KoujyosyoumeisakuseisyoriKbn.HOKENSYOUKEN);
                        koujyoSyoumeiParam.setSyoumeiYmd(kykKihon.getSyoyousinkyksyohakkouymd());

                        koujyoSyoumeiParamLst = new ArrayList<>();
                        koujyoSyoumeiParamLst.add(koujyoSyoumeiParam);

                        insKoujyoSymKnr(syoNo, koujyoSyoumeiParam, keisanKoujyogaku.getEndSyoumeiEndYm());


                        ansyuKihon.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.SUMI);
                        ansyuKihon.setGyoumuKousinKinou(kinouId);
                        ansyuKihon.setGyoumuKousinsyaId(kosId);
                        ansyuKihon.setGyoumuKousinTime(sysTime);

                        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst =
                            kykKihon.getKoujyoSymNaiyousByKoujyosyoumeinndKjsmhakkouzumiflg(
                                syoumeiNendo, C_Kjsmhakkouzumiflg.BLNK);
                        for (IT_KoujyoSymNaiyou koujyoSymNaiyou : koujyoSymNaiyouLst) {
                            koujyoSymNaiyou.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.SUMI);
                            koujyoSymNaiyou.setGyoumuKousinKinou(kinouId);
                            koujyoSymNaiyou.setGyoumuKousinsyaId(kosId);
                            koujyoSymNaiyou.setGyoumuKousinTime(sysTime);
                        }

                    }
                    editTable(koujyoSyoumeiParam);

                    multipleEntityInserter.add(kykKihon);
                    multipleEntityInserter.add(ansyuKihon);
                    multipleEntityInserter.add(tjtIdouNyKh);

                    editSyoriCTL(syoriCTL);
                    multipleEntityInserter.add(syoriCTL);

                    SkToujituIdounaiyouEdit skToujituIdounaiyouEdit =
                        SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);
                    BT_TjtIdouNySk tjtIdouNySk = skToujituIdounaiyouEdit.skIdounaiyouFileEdit(syoriCTL);
                    multipleEntityInserter.add(tjtIdouNySk);
                }

            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            if (dataNo == 0) {
                batchLogger.info(MessageUtil.getMessage(MessageId.IBF0003));
                return;
            }


        }

        if (editKhMisslstParamLst.size() == 0) {
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0019, String.valueOf(dataNo)));
        }
        else{

            KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);

            khozenTyouhyouCtl.setEditKkMisslstParam(editKhMisslstParamLst);
            khozenTyouhyouCtl.setSyoriYmd(syoriYmd);

            khozenTyouhyouCtl.createTyouhyouTBL(
                khozenCommonParam,
                new C_SyoruiCdKbn[] { C_SyoruiCdKbn.KK_KYKINFOTORIKOMI_MISSLIST },
                C_YouhiKbn.HUYOU
                );

            for (EditKhMisslstParam miss :editKhMisslstParamLst) {
                batchLogger.info(
                    "データ番号：" + String.valueOf(miss.getDataNo())
                    + "  SEQ-NO：" + String.valueOf(miss.getSeqNo())
                    + "  ミスリストメッセージ：" + miss.getMisslistMsg()
                    + "  DB反映区分：" + miss.getDBhaneikbn().toString()
                    + "  証券番号：" + miss.getSyoNo()
                    );
            }

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0018, String.valueOf(dataNo)));
        }

    }


    private boolean chkKeiyaku(int pDataNo, String pSyoNo) {

        if (hozenDomManager.getKykKihon(pSyoNo) == null) {
            return true;
        }

        setMisslistParam(pDataNo,
            MessageUtil.getMessage(MessageId.EIF0018),
            C_Dbhanei.NONE,
            pSyoNo);
        return false;
    }

    private void editKeiyakusya(HT_MosKihon pMosKihon,HT_SyoriCTL pSyoriCTL) {

        IT_KykSya kykSya = kykKihon.createKykSya();
        HT_NayoseKekka nayoseKekka =
            pSyoriCTL.getNayoseKekkaBySntkinfotaisyousyakbnEdano(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA,1);
        String kykSakuinnmno ;
        if (null != nayoseKekka){
            kykSakuinnmno = nayoseKekka.getSakuinnmno();
        }
        else{
            kykSakuinnmno = "";
        }

        kykSya.setKokno("");
        kykSya.setKyksakuinmeino(kykSakuinnmno);
        kykSya.setKyknmkn(pMosKihon.getKyknmkn());
        kykSya.setKyknmkj(pMosKihon.getKyknmkj());
        kykSya.setKyknmkjkhukakbn(pMosKihon.getKyknmkjkhukakbn());
        kykSya.setKykseiymd(pMosKihon.getKykseiymd());
        kykSya.setKyksei(pMosKihon.getKyksei());
        kykSya.setKkkyktdk(pMosKihon.getKyktdk());
        kykSya.setTsinyno(pMosKihon.getTsinyno());
        kykSya.setTsinadr1kn(pMosKihon.getTsinadr1kn());
        kykSya.setTsinadr1kj(pMosKihon.getTsinadr1kj());
        kykSya.setTsinadr2kn(pMosKihon.getTsinadr2kn());
        kykSya.setTsinadr2kj(pMosKihon.getTsinadr2kj());
        kykSya.setTsinadr3kn(pMosKihon.getTsinadr3kn());
        kykSya.setTsinadr3kj(pMosKihon.getTsinadr3kj());
        kykSya.setTsintelno(pMosKihon.getTsintelno());
        kykSya.setDai2tsintelno(pMosKihon.getDai2tsintelno());
        kykSya.setTsinmailaddress("");
        kykSya.setHjndaiykkbn(pMosKihon.getHjndaiykkbn());
        kykSya.setHjndaiyknm("");
        kykSya.setHjndainmkn(pMosKihon.getHjndainmkn());
        kykSya.setHjndainmkj(pMosKihon.getHjndainmkj());
        kykSya.setGyoumuKousinKinou(kinouId);
        kykSya.setGyoumuKousinsyaId(kosId);
        kykSya.setGyoumuKousinTime(sysTime);
        BizPropertyInitializer.initialize(kykSya);
    }
    private void editHihokensya(HT_MosKihon pMosKihon,HT_SyoriCTL pSyoriCTL) {
        HT_NayoseKekka nayoseKekka =
            pSyoriCTL.getNayoseKekkaBySntkinfotaisyousyakbnEdano(C_SntkInfoTaisyousyaKbn.HIHOKENSYA,1);
        String hhknSakuinnmno ;
        if (null != nayoseKekka){
            hhknSakuinnmno = nayoseKekka.getSakuinnmno();
        }
        else{
            hhknSakuinnmno = "";
        }
        IT_HhknSya hhknSya = kykKihon.createHhknSya();
        hhknSya.setKokno("");
        hhknSya.setHhknsakuinmeino(hhknSakuinnmno);
        hhknSya.setHhknnmkn(pMosKihon.getHhknnmkn());
        hhknSya.setHhknnmkj(pMosKihon.getHhknnmkj());
        hhknSya.setHhknnmkjkhukakbn(pMosKihon.getHhknnmkjkhukakbn());
        hhknSya.setHhknseiymd(pMosKihon.getHhknseiymd());
        hhknSya.setHhknsei(pMosKihon.getHhknsei());
        hhknSya.setHhknyno(pMosKihon.getHhknyno());
        hhknSya.setGyoumuKousinKinou(kinouId);
        hhknSya.setGyoumuKousinsyaId(kosId);
        hhknSya.setGyoumuKousinTime(sysTime);
        BizPropertyInitializer.initialize(hhknSya);
    }

    private C_ErrorKbn editSyouhin(HT_SyoriCTL pSyoriCTL, int pDataNo,
        MultipleEntityInserter pMultipleEntityInserter) {

        List<HT_MosSyouhn> wkMosSyouhnLst = pSyoriCTL.getMosSyouhns();
        wkMosSyouhnLst = new SortHT_MosSyouhn().OrderHT_MosSyouhnBySyutkkbnAsc(wkMosSyouhnLst);

        int mosSyouhnLstCnt = wkMosSyouhnLst.size();

        if (mosSyouhnLstCnt == 0 || !C_SyutkKbn.SYU.eq(wkMosSyouhnLst.get(0).getSyutkkbn())) {
            throw new CommonBizAppException("申込商品TBLにデータが存在しません。");
        }

        HT_Tokujyou tokujyou = pSyoriCTL.getTokujyou();

        C_Kykjyoutai kykjyoutai;
        if (C_Hrkkaisuu.ITIJI.eq(mosKihon.getHrkkaisuu())) {
            kykjyoutai = C_Kykjyoutai.ITIJIBARAI;
        }
        else if(C_UmuKbn.ARI.eq(mosKihon.getZennoumousideumu())) {

            kykjyoutai = C_Kykjyoutai.ZENNOU;
        }
        else if (C_IkkatubaraiKbn.TEIKIIKKATU.eq(mosKihon.getIkkatubaraikbn())) {

            kykjyoutai = C_Kykjyoutai.IKKATUNK;
        }
        else {

            kykjyoutai = C_Kykjyoutai.HRKMTYUU;
        }

        C_UmuKbn kykYmdSiteiUmu;
        if (mosKihon.getSkykymd() == null) {
            kykYmdSiteiUmu = C_UmuKbn.NONE;
        }
        else {
            kykYmdSiteiUmu = C_UmuKbn.ARI;
        }

        String syouhnCd;
        int syouhnsdNo;

        BizDate kykYmd = null;
        int hhknNen;
        int hrkKkn;
        C_HrkkknsmnKbn hrkkknsmnKbn;
        int hknKkn;
        C_HknkknsmnKbn hknkknsmnKbn;

        BizDate hrkManryouYmd = null;
        BizDate hknKknManryouYmd = null;

        C_UmuKbn tkjyrmtekiUmu;
        C_UmuKbn tkjyskgntekiUmu;
        C_UmuKbn htnpbuitekiUmu;
        C_UmuKbn tokkoudosghtnptekiUmu;
        boolean tokujyouUmuFlag = false;

        C_Tkjyhyouten tkjyhyouten;
        BizCurrency tkjyP;
        C_Tkjyskgnkkn tkjyskgnkkn;
        C_TokkoudosghtnpKbn tokkoudsghtnpkbn;
        String htnpbuiCd1 = "";
        String htnpbuiCd2 = "";
        String htnpbuiCd3 = "";
        String htnpbuiCd4 = "";
        C_Htnpkkn htnpKkn1 = C_Htnpkkn.BLNK;
        C_Htnpkkn htnpKkn2 = C_Htnpkkn.BLNK;
        C_Htnpkkn htnpKkn3 = C_Htnpkkn.BLNK;
        C_Htnpkkn htnpKkn4 = C_Htnpkkn.BLNK;

        BM_SyouhnZokusei syouhnZokusei;
        IT_KykSyouhn kykSyouhn;
        IT_SyouhnTokujou syouhnTokujou;

        int i = 0;

        C_Nenkinsyu nenkinsyu = C_Nenkinsyu.getInitialData(C_Nenkinsyu.class);
        int nenkinkkn= 0;
        BizDate stdrsktkyhkymd =null;
        BizDate yenshrkykkykhenkoymd =null;
        BizDate targettkykhkymd = null;
        BizDate nkshrtkykhenkoymd = null;
        int syohinHanteiKbn = 0;

        do {
            syouhnCd = wkMosSyouhnLst.get(i).getSyouhncd();
            syouhnsdNo = wkMosSyouhnLst.get(i).getSyouhnsdno();

            syouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd, syouhnsdNo);

            if (syouhnZokusei == null) {
                throw new CommonBizAppException("商品属性MSTにデータが存在しません。");
            }

            kykYmd = mosKihon.getKykymd();
            hhknNen = mosKihon.getHhknnen();
            hrkKkn = wkMosSyouhnLst.get(i).getHrkkkn();
            hrkkknsmnKbn = wkMosSyouhnLst.get(i).getHrkkknsmnkbn();
            hknKkn = wkMosSyouhnLst.get(i).getHknkkn();
            hknkknsmnKbn = wkMosSyouhnLst.get(i).getHknkknsmnkbn();

            SetManryoubi setManryoubi = SWAKInjector.getInstance(SetManryoubi.class);
            hrkManryouYmd = setManryoubi.exec(kykYmd, hhknNen, hrkKkn, C_KknsmnKbn.valueOf(hrkkknsmnKbn.getValue()));

            hknKknManryouYmd = setManryoubi.exec(kykYmd, hhknNen, hknKkn, C_KknsmnKbn.valueOf(hknkknsmnKbn.getValue()));

            BizDate gansknnkaisiYmd = null;
            int gansknnkaisikeikaNisuu = syouhnZokusei.getGansknnkaisikeikanisuu();
            C_UmuKbn gansknnkaisiymdUmu = syouhnZokusei.getGansknnkaisiymdumu();

            if (C_UmuKbn.ARI.eq(gansknnkaisiymdUmu)) {
                BizDate sekininKaisiYmd = mosKihon.getSknnkaisiymd();
                BizDateSpan kikan = new BizDateSpan(0, 0, gansknnkaisikeikaNisuu);
                gansknnkaisiYmd = sekininKaisiYmd.add(kikan);
            }

            if (C_SyutkKbn.SYU.eq(wkMosSyouhnLst.get(i).getSyutkkbn())) {
                syuHaraiManYmd = hrkManryouYmd;
            }

            KhConvUtil khConvUtil = SWAKInjector.getInstance(KhConvUtil.class);

            nenkinsyu = khConvUtil.convNksyukbn(wkMosSyouhnLst.get(i).getSknenkinsyu());

            nenkinkkn= khConvUtil.convNenkinkkn(wkMosSyouhnLst.get(i).getSknenkinsyu());

            sikibetuKey = khozenCommonParam.getSikibetuKey(kykKihon.getSyono());

            syohinHanteiKbn = SyouhinUtil.hantei(wkMosSyouhnLst.get(i).getSyouhncd());

            BizDate kijyunYmd;

            BizNumber sjkkkTyouseiyouRiritu;

            if(C_UmuKbn.NONE.eq(syouhnZokusei.getMvatekiumu())){

                sjkkkTyouseiyouRiritu = BizNumber.ZERO;
            }
            else{

                if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == syohinHanteiKbn ||
                    SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == syohinHanteiKbn) {
                    kijyunYmd = mosKihon.getSknnkaisiymd();
                }
                else {
                    kijyunYmd = mosKihon.getKykymd();
                }

                GetSjkkktyouseiyourirituBean getSjkkktyouseiyourirituBean = SWAKInjector.getInstance(GetSjkkktyouseiyourirituBean.class);
                GetSjkkktyouseiyouriritu getSjkkktyouseiyouriritu = SWAKInjector.getInstance(GetSjkkktyouseiyouriritu.class);

                getSjkkktyouseiyourirituBean.setSyouhncd(wkMosSyouhnLst.get(i).getSyouhncd());
                getSjkkktyouseiyourirituBean.setKijyunymd(kijyunYmd);
                getSjkkktyouseiyourirituBean.setHknkkn(wkMosSyouhnLst.get(i).getHknkkn());
                getSjkkktyouseiyourirituBean.setHknkknsmnkbn(wkMosSyouhnLst.get(i).getHknkknsmnkbn());
                getSjkkktyouseiyourirituBean.setHhknnen(mosKihon.getHhknnen());

                C_ErrorKbn errorKbn = getSjkkktyouseiyouriritu.exec(getSjkkktyouseiyourirituBean);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                    setMisslistParam(
                        pDataNo,
                        "市場価格調整用利率取得が実行できませんでした。",
                        C_Dbhanei.NONE,
                        pSyoriCTL.getSyono());

                    return C_ErrorKbn.ERROR;

                }

                sjkkkTyouseiyouRiritu = getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu();
            }

            BizNumber yoteiriritu = BizNumber.ZERO;
            if(SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == syohinHanteiKbn){
            }
            else{
                yoteiriritu = wkMosSyouhnLst.get(i).getYoteiriritu();
            }

            BizNumber yoteirrthendohosyurrt = syouhnZokusei.getYoteirirituminhosyouritu();

            BizNumber kykjisisuurendourate = BizNumber.ZERO;
            if(!C_TumitatekinHaibunWariKbn.BLNK.eq(mosKihon.getSisuuhaibunwarikbn())) {
                kykjisisuurendourate = BizNumber.valueOf(Integer.valueOf(mosKihon.getSisuuhaibunwarikbn().getValue()));
            }

            C_TmttknhaibunjyoutaiKbn tmttknHaibunJyoutai;

            if (C_TumitatekinHaibunWariKbn.BLNK.eq(mosKihon.getTeirituhaibunwarikbn()) &&
                C_TumitatekinHaibunWariKbn.BLNK.eq(mosKihon.getSisuuhaibunwarikbn())) {

                tmttknHaibunJyoutai = C_TmttknhaibunjyoutaiKbn.BLNK;
            }
            else if(C_TumitatekinHaibunWariKbn.WARIAI100.eq(mosKihon.getTeirituhaibunwarikbn())) {

                tmttknHaibunJyoutai = C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY;
            }
            else if(C_TumitatekinHaibunWariKbn.WARIAI100.eq(mosKihon.getSisuuhaibunwarikbn())) {

                tmttknHaibunJyoutai = C_TmttknhaibunjyoutaiKbn.SISUU_ONLY;
            }
            else {
                tmttknHaibunJyoutai = C_TmttknhaibunjyoutaiKbn.SISUUTEIRITU;
            }

            C_UmuKbn gsbunrikzKakuninUmu;
            C_UmuKbn gsbunriTaisyou;

            if (C_UmuKbn.ARI.eq(syouhnZokusei.getGstsumu()) &&
                (C_Hrkkaisuu.ITIJI.eq(mosKihon.getHrkkaisuu())
                    || C_BlnktkumuKbn.ARI.eq(mosKihon.getZenkizennouumu()))) {

                gsbunrikzKakuninUmu = C_UmuKbn.ARI;
                gsbunriTaisyou = C_UmuKbn.ARI;
            }
            else {

                gsbunrikzKakuninUmu = C_UmuKbn.NONE;
                gsbunriTaisyou = C_UmuKbn.NONE;
            }

            BizCurrency hokenryou = BizCurrency.valueOf(0);

            if (C_Hrkkaisuu.ITIJI.eq(mosKihon.getHrkkaisuu())) {

                hokenryou = wkMosSyouhnLst.get(i).getSyutkp();

            }
            else {

                hokenryou = wkMosSyouhnLst.get(i).getHrktuukasyutkp();
            }

            BizNumber teikishrritu = BizNumber.ZERO;
            if (C_Tkhukaumu.HUKA.eq(mosKihon.getTeikisiharaitkykhkkbn())) {
                teikishrritu = wkMosSyouhnLst.get(i).getTumitateriritu();
            }

            BizCurrency pharaikomiSougaku = BizCurrency.valueOf(0, hokenryou.getType());

            if(SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == syohinHanteiKbn){

                pharaikomiSougaku = mosKihon.getPharaikomisougaku();
            }

            kykSyouhn = kykKihon.createKykSyouhn();

            kykSyouhn.setSyutkkbn(wkMosSyouhnLst.get(i).getSyutkkbn());
            kykSyouhn.setSyouhncd(wkMosSyouhnLst.get(i).getSyouhncd());
            kykSyouhn.setSyouhnsdno(wkMosSyouhnLst.get(i).getSyouhnsdno());
            kykSyouhn.setKyksyouhnrenno(1);
            kykSyouhn.setHenkousikibetukey(sikibetuKey);
            kykSyouhn.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
            kykSyouhn.setKykjyoutai(kykjyoutai);
            kykSyouhn.setSyoumetujiyuu(C_Syoumetujiyuu.BLNK);
            kykSyouhn.setSyoumetuymd(null);
            kykSyouhn.setKouryokuhasseiymd(kykYmd);
            kykSyouhn.setKykymd(kykYmd);
            kykSyouhn.setKykymdsiteiumukbn(kykYmdSiteiUmu);
            kykSyouhn.setSknnkaisiymd(mosKihon.getSknnkaisiymd());
            kykSyouhn.setGansknnkaisiymd(gansknnkaisiYmd);
            kykSyouhn.setHksknnkaisiymd(null);
            kykSyouhn.setHkgansknnkaisiymd(null);
            kykSyouhn.setHknkknsmnkbn(hknkknsmnKbn);
            kykSyouhn.setHknkkn(hknKkn);
            kykSyouhn.setHrkkknsmnkbn(hrkkknsmnKbn);
            kykSyouhn.setHrkkkn(hrkKkn);
            kykSyouhn.setKyknen(0);
            kykSyouhn.setHhknnen(hhknNen);
            kykSyouhn.setHhknseiymd(mosKihon.getHhknseiymd());
            kykSyouhn.setHhknsei(mosKihon.getHhknsei());
            kykSyouhn.setHaraimanymd(hrkManryouYmd);
            kykSyouhn.setHknkknmanryouymd(hknKknManryouYmd);
            kykSyouhn.setKatakbn(wkMosSyouhnLst.get(i).getKatakbn());
            kykSyouhn.setKyhgndkatakbn(wkMosSyouhnLst.get(i).getKyhkatakbn());
            kykSyouhn.setSyukyhkinkatakbn(wkMosSyouhnLst.get(i).getSyukyhkinkatakbn());
            kykSyouhn.setKhnkyhkgbairitukbn(wkMosSyouhnLst.get(i).getKhnkyhkgbairitukbn());
            kykSyouhn.setRokudaildkbn(wkMosSyouhnLst.get(i).getRokudaildkbn());
            kykSyouhn.setPmnjtkkbn(mosKihon.getPmnjtkkbn());
            kykSyouhn.setKihons(wkMosSyouhnLst.get(i).getSeitoukihons());
            kykSyouhn.setHokenryou(hokenryou);
            kykSyouhn.setKyktuukasyu(mosKihon.getKyktuukasyu());
            kykSyouhn.setRyouritusdno(wkMosSyouhnLst.get(i).getRyouritusdno());
            kykSyouhn.setYoteiriritu(yoteiriritu);
            kykSyouhn.setYoteirrthendohosyurrt(yoteirrthendohosyurrt);
            kykSyouhn.setYtirrthndmnskaisuu(0);
            kykSyouhn.setKyksjkkktyouseiriritu(sjkkkTyouseiyouRiritu);
            kykSyouhn.setNksyukbn(nenkinsyu);
            kykSyouhn.setNenkinkkn(nenkinkkn);
            kykSyouhn.setNkgnshosyouritu(0);
            kykSyouhn.setNkgnshosyougk(BizCurrency.valueOf(0));
            kykSyouhn.setGyoumuKousinKinou(kinouId);
            kykSyouhn.setGyoumuKousinsyaId(kosId);
            kykSyouhn.setGyoumuKousinTime(sysTime);
            kykSyouhn.setGengakugoyenitijibrpstgk(BizCurrency.valueOf(0));
            kykSyouhn.setYendthnkymd(null);
            kykSyouhn.setSetteibairitu(wkMosSyouhnLst.get(i).getSetteibairitu());
            kykSyouhn.setKykjisisuurendourate(kykjisisuurendourate);
            kykSyouhn.setTmttknzoukaritujygn(wkMosSyouhnLst.get(i).getTmttknzoukaritujygn());
            kykSyouhn.setTumitateriritu(wkMosSyouhnLst.get(i).getTumitateriritu());
            kykSyouhn.setTmttknhaibunjyoutai(tmttknHaibunJyoutai);
            kykSyouhn.setSisuukbn(mosKihon.getSisuukbn());
            kykSyouhn.setGsbunrikzkakuninumu(gsbunrikzKakuninUmu);
            kykSyouhn.setGsbunritaisyou(gsbunriTaisyou);
            kykSyouhn.setSyouhnZokusei(syouhnZokusei);
            kykSyouhn.setPharaikomisougaku(pharaikomiSougaku);
            kykSyouhn.setLoadinghnkgtumitateriritu(wkMosSyouhnLst.get(i).getLoadinghnkgtumitateriritu());
            kykSyouhn.setRendouritu(wkMosSyouhnLst.get(i).getRendouritu());
            kykSyouhn.setTeikishrritu(teikishrritu);
            kykSyouhn.setDai1hknkkn(wkMosSyouhnLst.get(i).getDai1hknkkn());
            BizPropertyInitializer.initialize(kykSyouhn);

            if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == syohinHanteiKbn ||
                SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == syohinHanteiKbn) {

                C_ErrorKbn errorKbn1 = editKhSisuurendoTmttkn(pSyoriCTL , pMultipleEntityInserter , pDataNo, wkMosSyouhnLst.get(i));

                if (C_ErrorKbn.ERROR.eq(errorKbn1)) {

                    return C_ErrorKbn.ERROR;
                }
            }

            if (tokujyou == null) {
                i++;
                continue;
            }

            tkjyrmtekiUmu = syouhnZokusei.getTkjyrmtekiumu();

            if (C_UmuKbn.ARI.eq(tkjyrmtekiUmu)) {
                tkjyhyouten = tokujyou.getTkjyhyouten();
                tkjyP = wkMosSyouhnLst.get(i).getTkjyp();

                if (!C_Tkjyhyouten.BLNK.eq(tkjyhyouten)
                    || !tkjyP.equals(BizCurrency.valueOf(0, tkjyP.getType()))) {
                    tokujyouUmuFlag = true;
                }
            }

            tkjyskgntekiUmu = syouhnZokusei.getTkjyskgntekiumu();

            if (C_UmuKbn.ARI.eq(tkjyskgntekiUmu)) {
                tkjyskgnkkn = tokujyou.getTkjyskgnkkn();

                if (!C_Tkjyskgnkkn.BLNK.eq(tkjyskgnkkn)) {
                    tokujyouUmuFlag = true;
                }
            }

            htnpbuitekiUmu = syouhnZokusei.getHtnpbuitekiumu();

            if (C_UmuKbn.ARI.eq(htnpbuitekiUmu)) {
                htnpbuiCd1 = tokujyou.getHtnpbuicd1();
                htnpbuiCd2 = tokujyou.getHtnpbuicd2();
                htnpbuiCd3 = tokujyou.getHtnpbuicd3();
                htnpbuiCd4 = tokujyou.getHtnpbuicd4();
                htnpKkn1 = tokujyou.getHtnpkkn1();
                htnpKkn2 = tokujyou.getHtnpkkn2();
                htnpKkn3 = tokujyou.getHtnpkkn3();
                htnpKkn4 = tokujyou.getHtnpkkn4();

                if (!htnpbuiCd1.equals("") || !C_Htnpkkn.BLNK.eq(htnpKkn1)
                    || !htnpbuiCd2.equals("") || !C_Htnpkkn.BLNK.eq(htnpKkn2)
                    || !htnpbuiCd3.equals("") || !C_Htnpkkn.BLNK.eq(htnpKkn3)
                    || !htnpbuiCd4.equals("") || !C_Htnpkkn.BLNK.eq(htnpKkn4)) {
                    tokujyouUmuFlag = true;
                }
            }

            tokkoudosghtnptekiUmu = syouhnZokusei.getTokkoudosghtnptekiumu();

            if (C_UmuKbn.ARI.eq(tokkoudosghtnptekiUmu)) {
                tokkoudsghtnpkbn = tokujyou.getTokkoudosghtnpkbn();

                if (!C_TokkoudosghtnpKbn.BLNK.eq(tokkoudsghtnpkbn)) {
                    tokujyouUmuFlag = true;
                }
            }

            if (!tokujyouUmuFlag) {
                i++;
                continue;
            }

            syouhnTokujou = kykKihon.createSyouhnTokujou();

            syouhnTokujou.setSyutkkbn(wkMosSyouhnLst.get(i).getSyutkkbn());
            syouhnTokujou.setSyouhncd(wkMosSyouhnLst.get(i).getSyouhncd());
            syouhnTokujou.setSyouhnsdno(wkMosSyouhnLst.get(i).getSyouhnsdno());
            syouhnTokujou.setKyksyouhnrenno(1);
            syouhnTokujou.setHenkousikibetukey(sikibetuKey);

            if (C_UmuKbn.ARI.eq(tkjyrmtekiUmu)) {
                syouhnTokujou.setTkjyhyouten(tokujyou.getTkjyhyouten());
            }
            else {
                syouhnTokujou.setTkjyhyouten(C_Tkjyhyouten.BLNK);
            }
            syouhnTokujou.setTkjyp(wkMosSyouhnLst.get(i).getTkjyp());

            if (C_UmuKbn.ARI.eq(tkjyskgntekiUmu)) {
                syouhnTokujou.setTkjyskgnkkn(tokujyou.getTkjyskgnkkn());
            }
            else {
                syouhnTokujou.setTkjyskgnkkn(C_Tkjyskgnkkn.BLNK);
            }

            if (C_UmuKbn.ARI.eq(htnpbuitekiUmu)) {
                syouhnTokujou.setHtnpbuicd1(htnpbuiCd1);
                syouhnTokujou.setHtnpkkn1(htnpKkn1);
                syouhnTokujou.setHtnpbuicd2(htnpbuiCd2);
                syouhnTokujou.setHtnpkkn2(htnpKkn2);
                syouhnTokujou.setHtnpbuicd3(htnpbuiCd3);
                syouhnTokujou.setHtnpkkn3(htnpKkn3);
                syouhnTokujou.setHtnpbuicd4(htnpbuiCd4);
                syouhnTokujou.setHtnpkkn4(htnpKkn4);
            }
            else {
                syouhnTokujou.setHtnpbuicd1("");
                syouhnTokujou.setHtnpkkn1(C_Htnpkkn.BLNK);
                syouhnTokujou.setHtnpbuicd2("");
                syouhnTokujou.setHtnpkkn2(C_Htnpkkn.BLNK);
                syouhnTokujou.setHtnpbuicd3("");
                syouhnTokujou.setHtnpkkn3(C_Htnpkkn.BLNK);
                syouhnTokujou.setHtnpbuicd4("");
                syouhnTokujou.setHtnpkkn4(C_Htnpkkn.BLNK);
            }

            if (C_UmuKbn.ARI.eq(tokkoudosghtnptekiUmu)) {
                syouhnTokujou.setTokkoudosghtnpkbn(tokujyou.getTokkoudosghtnpkbn());
            }
            else {
                syouhnTokujou.setTokkoudosghtnpkbn(C_TokkoudosghtnpKbn.BLNK);
            }
            syouhnTokujou.setGyoumuKousinKinou(kinouId);
            syouhnTokujou.setGyoumuKousinsyaId(kosId);
            syouhnTokujou.setGyoumuKousinTime(sysTime);
            BizPropertyInitializer.initialize(syouhnTokujou);

            i++;
        } while (i < mosSyouhnLstCnt);

        C_UmuKbn stdrsktkyhkumu = C_UmuKbn.NONE;
        C_UmuKbn yennykntkhkumu = C_UmuKbn.NONE;
        C_UmuKbn gaikanykntkhkumu = C_UmuKbn.NONE;
        C_UmuKbn yenshrtkhkumu = C_UmuKbn.NONE;
        C_UmuKbn stdrsktkyhkkbn = C_UmuKbn.NONE;
        C_UmuKbn nkyentkhukaumu = C_UmuKbn.NONE;

        if (C_Tkhukaumu.HUKA.eq(mosKihon.getStdrsktkyhkkbn())) {
            stdrsktkyhkumu = C_UmuKbn.ARI;
            stdrsktkyhkymd =  mosKihon.getKykymd();
        }

        if (C_Tkhukaumu.HUKA.eq(mosKihon.getYennykntkhkkbn())){
            yennykntkhkumu = C_UmuKbn.ARI;
        }

        if (C_Tkhukaumu.HUKA.eq(mosKihon.getGaikanykntkhkkbn())){
            gaikanykntkhkumu = C_UmuKbn.ARI;
        }

        if (C_Tkhukaumu.HUKA.eq(mosKihon.getYenshrtkhkkbn())){
            yenshrtkhkumu = C_UmuKbn.ARI;
            yenshrkykkykhenkoymd = mosKihon.getKykymd();
        }

        if (C_Tkhukaumu.HUKA.eq(mosKihon.getTargettkhkkbn())){
            stdrsktkyhkkbn = C_UmuKbn.ARI;
            targettkykhkymd=  mosKihon.getKykymd();
        }

        if (C_Tkhukaumu.HUKA.eq(mosKihon.getNstkhkkbn())){
            nkyentkhukaumu = C_UmuKbn.ARI;
            nkshrtkykhenkoymd =  mosKihon.getKykymd();
        }

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.createKykSonotaTkyk();

        if (C_Livhukaumu.ARI.eq(mosKihon.getLivhukaumu())) {
            kykSonotaTkyk.setLivingneedshukaumu(C_UmuKbn.ARI);
        }
        else {
            kykSonotaTkyk.setLivingneedshukaumu(C_UmuKbn.NONE);
        }

        kykSonotaTkyk.setStdrsktkyhkumu(stdrsktkyhkumu);
        kykSonotaTkyk.setStdrsktkyhkymd(stdrsktkyhkymd);
        kykSonotaTkyk.setYennykntkhkumu(yennykntkhkumu);
        kykSonotaTkyk.setGaikanykntkhkumu(gaikanykntkhkumu);
        kykSonotaTkyk.setYenshrtkhkumu(yenshrtkhkumu);
        kykSonotaTkyk.setYenshrkykkykhenkoymd(yenshrkykkykhenkoymd);
        kykSonotaTkyk.setNkgkkateitkumu(C_UmuKbn.NONE);
        kykSonotaTkyk.setNksgkhosyuwari(BizNumber.ZERO);
        kykSonotaTkyk.setSkjbrnktsumu(C_UmuKbn.NONE);
        kykSonotaTkyk.setNenkingaku8waritkumu(C_UmuKbn.NONE);
        kykSonotaTkyk.setNenkingaku9waritkumu(C_UmuKbn.NONE);
        kykSonotaTkyk.setNkyentkhukaumu(C_UmuKbn.NONE);
        kykSonotaTkyk.setKwsttkhukaumu(C_UmuKbn.NONE);
        kykSonotaTkyk.setKwstargetrate(0);
        kykSonotaTkyk.setTargettkhkumu(stdrsktkyhkkbn);
        kykSonotaTkyk.setTargettkykkykhenkoymd(null);
        kykSonotaTkyk.setTargettkykhkymd(targettkykhkymd);
        kykSonotaTkyk.setTargettkkbn(mosKihon.getTargettkkbn());
        kykSonotaTkyk.setYsknkshtkumu(C_UmuKbn.NONE);
        kykSonotaTkyk.setNstkhkumu(nkyentkhukaumu);
        kykSonotaTkyk.setNkshrtkykhenkoymd(nkshrtkykhenkoymd);
        kykSonotaTkyk.setNkshrtkyknksyukbn(mosKihon.getNstksbnsyu());
        kykSonotaTkyk.setNkshrtkyknksyukkn(mosKihon.getNstksbnkkn());
        kykSonotaTkyk.setPmnjtkkbn(C_PmnjtkKbn.NONE);
        kykSonotaTkyk.setPmnjtkkykymd(null);
        kykSonotaTkyk.setPmnjtksknnkaisiymd(null);
        kykSonotaTkyk.setPmnjtkgansknnkaisiymd(null);
        kykSonotaTkyk.setPmhktsknnkaisiymd(null);
        kykSonotaTkyk.setPmnjhktgansknnkaisiymd(null);
        kykSonotaTkyk.setPmnjtkhtnpbuicd1("");
        kykSonotaTkyk.setPmnjtkhtnpkkn1(C_Htnpkkn.BLNK);
        kykSonotaTkyk.setPmnjtkhtnpbuicd2("");
        kykSonotaTkyk.setPmnjtkhtnpkkn2(C_Htnpkkn.BLNK);
        kykSonotaTkyk.setPmnjtkhtnpbuicd3("");
        kykSonotaTkyk.setPmnjtkhtnpkkn3(C_Htnpkkn.BLNK);
        kykSonotaTkyk.setPmnjtkhtnpbuicd4("");
        kykSonotaTkyk.setPmnjtkhtnpkkn4(C_Htnpkkn.BLNK);
        kykSonotaTkyk.setPmnjtokkoudosghtnpkbn(C_TokkoudosghtnpKbn.BLNK);

        if (C_SknnkaisikitkhukaKbn.HUKA.eq(mosKihon.getSknnkaisikitkhukakbn())) {
            kykSonotaTkyk.setSknnkaisikitkkbn(C_SknnkaisikitkKbn.SKNNKAISIKITK);
        }
        else {
            kykSonotaTkyk.setSknnkaisikitkkbn(C_SknnkaisikitkKbn.NONE);
        }

        if (C_Tkhukaumu.HUKA.eq(mosKihon.getSyksbyensitihsyutkhkkbn())) {
            kykSonotaTkyk.setInitsbjiyensitihsytkhukaumu(C_UmuKbn.ARI);
        }
        else {
            kykSonotaTkyk.setInitsbjiyensitihsytkhukaumu(C_UmuKbn.NONE);
        }

        if (C_Tkhukaumu.HUKA.eq(mosKihon.getJyudkaigomehrtkhkkbn())) {
            kykSonotaTkyk.setJyudkaigomeharaitkhukaumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setJyudkaigomeharaitkhukaymd(mosKihon.getKykymd());
        }
        else {
            kykSonotaTkyk.setJyudkaigomeharaitkhukaumu(C_UmuKbn.NONE);
        }

        BizCurrency kijyunkingk = BizCurrency.valueOf(0);

        if (C_Tkhukaumu.HUKA.eq(mosKihon.getSyksbyensitihsyutkhkkbn())
            || C_Tkhukaumu.HUKA.eq(mosKihon.getTargettkhkkbn())) {
            KeisanKijyungk keisanKijyungk = SWAKInjector.getInstance(KeisanKijyungk.class);

            C_ErrorKbn errorKbn = keisanKijyungk.exec(ryosyuymdMin,
                mosKihon.getFstphrkgk(),
                mosKihon.getHyouteip(),
                mosKihon.getKyktuukasyu(),
                mosKihon.getYennykntkhkkbn());

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                setMisslistParam(
                    pDataNo,
                    MessageUtil.getMessage(MessageId.EIC1005, C_KawasetsryKbn.NYUKINRATE.getContent()),
                    C_Dbhanei.NONE,
                    pSyoriCTL.getSyono());

                return C_ErrorKbn.ERROR;
            }

            kijyunkingk = keisanKijyungk.getKijyungk();
        }

        if (C_TargetTkMokuhyoutiKbn.NOTARGET.eq(mosKihon.getTargettkmkhtkbn())) {
            kykSonotaTkyk.setTargettkmokuhyouti(0);
        }
        else {
            kykSonotaTkyk.setTargettkmokuhyouti(Integer.valueOf(mosKihon.getTargettkmkhtkbn().getValue()));
        }

        if (C_Tkhukaumu.HUKA.eq(mosKihon.getTargettkhkkbn())) {
            kykSonotaTkyk.setTargettkykkijyungk(kijyunkingk);
        }
        else {
            kykSonotaTkyk.setTargettkykkijyungk(BizCurrency.valueOf(0));
        }

        if (C_Tkhukaumu.HUKA.eq(mosKihon.getSyksbyensitihsyutkhkkbn())) {
            kykSonotaTkyk.setInitsbjiyenkasaiteihsygk(kijyunkingk);
        }
        else {
            kykSonotaTkyk.setInitsbjiyenkasaiteihsygk(BizCurrency.valueOf(0));
        }

        kykSonotaTkyk.setGyoumuKousinKinou(kinouId);
        kykSonotaTkyk.setGyoumuKousinsyaId(kosId);
        kykSonotaTkyk.setGyoumuKousinTime(sysTime);

        if (C_Tkhukaumu.HUKA.eq(mosKihon.getKjnnkpzeitekitkhukakbn())) {

            kykSonotaTkyk.setZeiseitkkktkykhukaumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setZeiseitkkktkykhukaymd(mosKihon.getKykymd());
        }
        else {

            kykSonotaTkyk.setZeiseitkkktkykhukaumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setZeiseitkkktkykhukaymd(null);

        }

        if (C_Tkhukaumu.HUKA.eq(mosKihon.getYennykntkhkkbn())) {

            if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == syohinHanteiKbn) {

                kykSonotaTkyk.setYennyknsyuruikbn(C_YennykntksyuruiKbn.PYENHRKM_GKSITEI);
            }
            else if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == syohinHanteiKbn) {

                kykSonotaTkyk.setYennyknsyuruikbn(C_YennykntksyuruiKbn.PYENHRKM_GKHENDOU);
            }
            else {

                kykSonotaTkyk.setYennyknsyuruikbn(C_YennykntksyuruiKbn.PYENHRKM);
            }
        }
        else {

            kykSonotaTkyk.setYennyknsyuruikbn(C_YennykntksyuruiKbn.BLNK);
        }

        if (C_Tkhukaumu.HUKA.eq(mosKihon.getKykdrtkykhukakbn())) {
            kykSonotaTkyk.setKykdrtkykhukaumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setKykdrtkykhukaymd(mosKihon.getKykymd());
        }
        else {
            kykSonotaTkyk.setKykdrtkykhukaumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setKykdrtkykhukaymd(null);
        }

        kykSonotaTkyk.setKykdrtkykkaiyakuymd(null);

        if (C_Tkhukaumu.HUKA.eq(mosKihon.getTeikisiharaitkykhkkbn())) {
            C_KouzasyuruiKbn teikisKouzasyuruikbn = C_KouzasyuruiKbn.BLNK;
            for (HT_UketoriKouzaJyouhou uketoriKouzaJyouhou : uketoriKouzaJyouhouLst) {
                if (C_UketorikouzasyubetuKbn.TEIKIUKETORIKIN.eq(uketoriKouzaJyouhou.getUktkzsyubetukbn())) {
                    teikisKouzasyuruikbn = uketoriKouzaJyouhou.getKzsyuruikbn();
                    break;
                }
            }
            if (C_KouzasyuruiKbn.YENKOUZA.eq(teikisKouzasyuruikbn)) {
                kykSonotaTkyk.setTeikishrkinshrtuukasyu(C_Tuukasyu.JPY);
            }
            else if (C_KouzasyuruiKbn.GAIKAKOUZA.eq(teikisKouzasyuruikbn)) {
                kykSonotaTkyk.setTeikishrkinshrtuukasyu(mosKihon.getKyktuukasyu());
            }
            else {
                kykSonotaTkyk.setTeikishrkinshrtuukasyu(C_Tuukasyu.BLNK);
            }

            kykSonotaTkyk.setTeikishrtkykhukaumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setTeikishrkinshrmd(mosKihon.getKykymd().getBizDateMD());

        }
        else {
            kykSonotaTkyk.setTeikishrtkykhukaumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setTeikishrkinshrtuukasyu(C_Tuukasyu.BLNK);
            kykSonotaTkyk.setTeikishrkinshrmd(null);
        }

        return C_ErrorKbn.OK;
    }

    private void editKouza(HT_MosKihon pMosKihon, HT_KouzaJyouhou pKouzaJyouhou) {

        IT_Kouza kouza = kykKihon.createKouza();
        kouza.setBankcd(pKouzaJyouhou.getBankcd());
        kouza.setSitencd(pKouzaJyouhou.getSitencd());
        kouza.setYokinkbn(pKouzaJyouhou.getYokinkbn());
        kouza.setKouzano(pKouzaJyouhou.getKouzano());
        kouza.setSinkeizkkbn(pKouzaJyouhou.getSinkeizkkbn());
        kouza.setKzkykdoukbn(pKouzaJyouhou.getKzkykdoukbn());

        if (C_KzkykdouKbn.DOUITU.eq(pKouzaJyouhou.getKzkykdoukbn())){

            if ( C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {

                kouza.setKzmeiginmkn(mosKihon.getHhknnmkn());
            }
            else if(C_KykKbn.KEIHI_BETU.eq(mosKihon.getKykkbn())){

                kouza.setKzmeiginmkn(mosKihon.getKyknmkn());
            }
        }
        else if(C_KzkykdouKbn.SITEI.eq(pKouzaJyouhou.getKzkykdoukbn())){

            kouza.setKzmeiginmkn(pKouzaJyouhou.getKzmeiginmkn());
        }

        kouza.setSyuudaikocd(pKouzaJyouhou.getSyuudaikocd());
        kouza.setGyoumuKousinKinou(kinouId);
        kouza.setGyoumuKousinsyaId(kosId);
        kouza.setGyoumuKousinTime(sysTime);

        BizPropertyInitializer.initialize(kouza);
    }

    private void editCreditcard() {

        SetCreditUriageSeikyuubi setCreditUriageSeikyuubi = SWAKInjector.getInstance(SetCreditUriageSeikyuubi.class);
        setCreditUriageSeikyuubi.exec(syoriYmd);

        IT_CreditCardInfo creditCard = kykKihon.createCreditCardInfo();
        creditCard.setCreditkessaiyouno(creditCardJyouhou.getCreditkessaiyouno());
        creditCard.setCredityuukoukakym(setCreditUriageSeikyuubi.getJikaiUrskbi().getBizDateYM());
        creditCard.setCredityuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_OK);
        creditCard.setGyoumuKousinKinou(kinouId);
        creditCard.setGyoumuKousinsyaId(kosId);
        creditCard.setGyoumuKousinTime(sysTime);

        BizPropertyInitializer.initialize(creditCard);
    }

    private void editUketorinin(HT_SyoriCTL pSyoriCTL) {

        C_UktsyuKbn uktsyuKbn;
        IT_KykUkt kykUkt;
        C_UktKbn uktKbn;

        List<HT_Uketorinin> uketorininLst2 = pSyoriCTL.getUketorinins();
        for (HT_Uketorinin uketorinin : uketorininLst2) {

            uktsyuKbn = uketorinin.getUktsyukbn();
            uktKbn =  uketorinin.getUktkbn();

            kykUkt = kykKihon.createKykUkt();
            kykUkt.setUktsyukbn(uktsyuKbn);
            kykUkt.setUktsyurenno(uketorinin.getUktsyurenno());
            kykUkt.setKokno("");

            if (C_UktsyuKbn.SBUKT.eq(uktsyuKbn)) {
                if (C_UktKbn.KYK.eq(uktKbn)) {
                    if (mosKihon.getSbuktnin() == 1 ){
                        kykUkt.setUktkbn(C_UktKbn.KYK);
                        kykUkt.setUktnmkn("");
                        kykUkt.setUktnmkj("");
                        kykUkt.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
                        kykUkt.setUktseiymd(null);
                        kykUkt.setUkttdk(C_Tdk.BLNK);
                    }
                    else if (mosKihon.getSbuktnin() >= 2){
                        if (uketorinin.getUktsyurenno() == 1){
                            kykUkt.setUktkbn(C_UktKbn.TOKUTEIMEIGI);
                            kykUkt.setUktnmkn(mosKihon.getKyknmkn());
                            kykUkt.setUktnmkj(mosKihon.getKyknmkj());
                            kykUkt.setUktnmkjkhukakbn(mosKihon.getKyknmkjkhukakbn());
                            kykUkt.setUktseiymd(mosKihon.getKykseiymd());
                            kykUkt.setUkttdk(C_Tdk.BLNK);
                        }
                        else if(uketorinin.getUktsyurenno() != 1){
                            kykUkt.setUktkbn(C_UktKbn.TOKUTEIMEIGI);
                            kykUkt.setUktnmkn(mosKihon.getKyknmkn());
                            kykUkt.setUktnmkj(mosKihon.getKyknmkj());
                            kykUkt.setUktnmkjkhukakbn(mosKihon.getKyknmkjkhukakbn());
                            kykUkt.setUktseiymd(mosKihon.getKykseiymd());
                            kykUkt.setUkttdk(C_Tdk.BLNK);
                        }
                    }
                }
                else if (C_UktKbn.TOKUTEIMEIGI.eq(uktKbn)) {
                    kykUkt.setUktkbn(C_UktKbn.TOKUTEIMEIGI);
                    kykUkt.setUktnmkn(uketorinin.getUktnmkn());
                    kykUkt.setUktnmkj(uketorinin.getUktnmkj());
                    kykUkt.setUktnmkjkhukakbn(uketorinin.getUktnmkjkhukakbn());
                    kykUkt.setUktseiymd(uketorinin.getUktseiymd());
                    kykUkt.setUkttdk(C_Tdk.BLNK);
                }
                else {
                    kykKihon.getKykUkts().remove(kykUkt);
                    continue;
                }
            }
            else if (C_UktsyuKbn.STDRSK.eq(uktsyuKbn)) {
                if (C_UktKbn.NASI.eq(uktKbn)) {
                    kykUkt.setUktkbn(C_UktKbn.NASI);
                    kykUkt.setUktnmkn("");
                    kykUkt.setUktnmkj("");
                    kykUkt.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
                    kykUkt.setUktseiymd(null);
                    kykUkt.setUkttdk(C_Tdk.BLNK);
                }
                else if (C_UktKbn.SBUK.eq(uktKbn)) {
                    HT_Uketorinin sibouUketorinin = pSyoriCTL.getUketorininByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 1);

                    if (mosKihon.getSbuktnin() == 1 ) {
                        if (C_UktKbn.KYK.eq(sibouUketorinin.getUktkbn())) {
                            kykUkt.setUktkbn(C_UktKbn.KYK);
                            kykUkt.setUktnmkn("");
                            kykUkt.setUktnmkj("");
                            kykUkt.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
                            kykUkt.setUktseiymd(null);
                            kykUkt.setUkttdk(C_Tdk.BLNK);
                        }
                        else if (C_UktKbn.TOKUTEIMEIGI.eq(sibouUketorinin.getUktkbn())) {
                            kykUkt.setUktkbn(C_UktKbn.SBUK);
                            kykUkt.setUktnmkn("");
                            kykUkt.setUktnmkj("");
                            kykUkt.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
                            kykUkt.setUktseiymd(null);
                            kykUkt.setUkttdk(C_Tdk.BLNK);
                        }
                    }
                    else if (mosKihon.getSbuktnin() >= 2 ) {
                        if (C_UktKbn.KYK.eq(sibouUketorinin.getUktkbn())) {
                            kykUkt.setUktkbn(C_UktKbn.KYK);
                            kykUkt.setUktnmkn("");
                            kykUkt.setUktnmkj("");
                            kykUkt.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
                            kykUkt.setUktseiymd(null);
                            kykUkt.setUkttdk(C_Tdk.BLNK);
                        }
                        else if (C_UktKbn.TOKUTEIMEIGI.eq(sibouUketorinin.getUktkbn())) {
                            kykUkt.setUktkbn(C_UktKbn.TOKUTEIMEIGI);
                            kykUkt.setUktnmkn(sibouUketorinin.getUktnmkn());
                            kykUkt.setUktnmkj(sibouUketorinin.getUktnmkj());
                            kykUkt.setUktnmkjkhukakbn(sibouUketorinin.getUktnmkjkhukakbn());
                            kykUkt.setUktseiymd(sibouUketorinin.getUktseiymd());
                            kykUkt.setUkttdk(C_Tdk.BLNK);
                        }
                    }
                }
                else if (C_UktKbn.KYK.eq(uktKbn)) {
                    kykUkt.setUktkbn(C_UktKbn.KYK);
                    kykUkt.setUktnmkn("");
                    kykUkt.setUktnmkj("");
                    kykUkt.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
                    kykUkt.setUktseiymd(null);
                    kykUkt.setUkttdk(C_Tdk.BLNK);
                }
                else if (C_UktKbn.TOKUTEIMEIGI.eq(uktKbn)) {
                    kykUkt.setUktkbn(C_UktKbn.TOKUTEIMEIGI);
                    kykUkt.setUktnmkn(uketorinin.getUktnmkn());
                    kykUkt.setUktnmkj(uketorinin.getUktnmkj());
                    kykUkt.setUktnmkjkhukakbn(uketorinin.getUktnmkjkhukakbn());
                    kykUkt.setUktseiymd(uketorinin.getUktseiymd());
                    kykUkt.setUkttdk(C_Tdk.BLNK);
                }
                else if (C_UktKbn.TOUROKUKAZOKU1.eq(uktKbn)) {
                    kykUkt.setUktkbn(C_UktKbn.TOUROKUKAZOKU1);
                    kykUkt.setUktnmkn("");
                    kykUkt.setUktnmkj("");
                    kykUkt.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
                    kykUkt.setUktseiymd(null);
                    kykUkt.setUkttdk(C_Tdk.BLNK);
                }
                else if (C_UktKbn.TOUROKUKAZOKU2.eq(uktKbn)) {
                    kykUkt.setUktkbn(C_UktKbn.TOUROKUKAZOKU2);
                    kykUkt.setUktnmkn("");
                    kykUkt.setUktnmkj("");
                    kykUkt.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
                    kykUkt.setUktseiymd(null);
                    kykUkt.setUkttdk(C_Tdk.BLNK);
                }
                else {
                    kykKihon.getKykUkts().remove(kykUkt);
                    continue;
                }
            }
            else if (C_UktsyuKbn.NKUKT.eq(uktsyuKbn)) {
                if (C_UktKbn.KYK.eq(uktKbn)) {
                    kykUkt.setUktkbn(C_UktKbn.KYK);
                    kykUkt.setUktnmkn("");
                    kykUkt.setUktnmkj("");
                    kykUkt.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
                    kykUkt.setUktseiymd(null);
                    kykUkt.setUkttdk(C_Tdk.BLNK);
                }
                else if (C_UktKbn.HHKN.eq(uktKbn)) {
                    kykUkt.setUktkbn(C_UktKbn.HHKN);
                    kykUkt.setUktnmkn("");
                    kykUkt.setUktnmkj("");
                    kykUkt.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
                    kykUkt.setUktseiymd(null);
                    kykUkt.setUkttdk(C_Tdk.BLNK);
                }
                else {
                    kykKihon.getKykUkts().remove(kykUkt);
                    continue;
                }
            }
            else if (C_UktsyuKbn.KYKDRN.eq(uktsyuKbn)) {
                if (C_UktKbn.TOKUTEIMEIGI.eq(uktKbn)) {
                    kykUkt.setUktkbn(C_UktKbn.TOKUTEIMEIGI);
                    kykUkt.setUktnmkn(uketorinin.getUktnmkn());
                    kykUkt.setUktnmkj(uketorinin.getUktnmkj());
                    kykUkt.setUktnmkjkhukakbn(uketorinin.getUktnmkjkhukakbn());
                    kykUkt.setUktseiymd(uketorinin.getUktseiymd());
                    kykUkt.setUkttdk(C_Tdk.BLNK);
                }
                else if (C_UktKbn.TOUROKUKAZOKU1.eq(uktKbn)) {
                    kykUkt.setUktkbn(C_UktKbn.TOUROKUKAZOKU1);
                    kykUkt.setUktnmkn("");
                    kykUkt.setUktnmkj("");
                    kykUkt.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
                    kykUkt.setUktseiymd(null);
                    kykUkt.setUkttdk(C_Tdk.BLNK);
                }
                else if (C_UktKbn.TOUROKUKAZOKU2.eq(uktKbn)) {
                    kykUkt.setUktkbn(C_UktKbn.TOUROKUKAZOKU2);
                    kykUkt.setUktnmkn("");
                    kykUkt.setUktnmkj("");
                    kykUkt.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
                    kykUkt.setUktseiymd(null);
                    kykUkt.setUkttdk(C_Tdk.BLNK);
                }
                else {
                    kykKihon.getKykUkts().remove(kykUkt);
                    continue;
                }
            }
            else if (C_UktsyuKbn.TKSHKUKT.eq(uktsyuKbn)) {
                for (HT_UketoriKouzaJyouhou uketoriKouzaJyouhou : uketoriKouzaJyouhouLst) {
                    if (C_UketorikouzasyubetuKbn.TEIKIUKETORIKIN.eq(uketoriKouzaJyouhou.getUktkzsyubetukbn())) {
                        editUketoriKouza(uketoriKouzaJyouhou, uketorinin, kykUkt);
                        break;
                    }
                }

                if (C_UktKbn.KYK.eq(uktKbn)) {
                    kykUkt.setUktkbn(C_UktKbn.KYK);
                    kykUkt.setUktnmkn("");
                    kykUkt.setUktnmkj("");
                    kykUkt.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
                    kykUkt.setUktseiymd(null);
                    kykUkt.setUkttdk(C_Tdk.BLNK);
                }
                else {
                    kykKihon.getKykUkts().remove(kykUkt);
                    continue;
                }
            }
            else {
                kykKihon.getKykUkts().remove(kykUkt);
                continue;
            }

            kykUkt.setUktbnwari(uketorinin.getUktbnwari());
            kykUkt.setGyoumuKousinKinou(kinouId);
            kykUkt.setGyoumuKousinsyaId(kosId);
            kykUkt.setGyoumuKousinTime(sysTime);

            if (C_UktsyuKbn.KYKDRN.eq(uktsyuKbn)) {
                if (C_UktKbn.TOKUTEIMEIGI.eq(uktKbn)) {
                    if (C_TsindousiteiKbn.ARI.eq(uketorinin.getUkttsindousiteikbn())) {
                        kykUkt.setUktyno(mosKihon.getTsinyno());
                        kykUkt.setUktadr1kj(mosKihon.getTsinadr1kj());
                        kykUkt.setUktadr2kj(mosKihon.getTsinadr2kj());
                        kykUkt.setUktadr3kj(mosKihon.getTsinadr3kj());
                    }
                    else {
                        kykUkt.setUktyno(uketorinin.getUktyno());
                        kykUkt.setUktadr1kj(uketorinin.getUktadr1kj());
                        kykUkt.setUktadr2kj(uketorinin.getUktadr2kj());
                        kykUkt.setUktadr3kj(uketorinin.getUktadr3kj());
                    }
                }
                else {
                    kykUkt.setUktyno("");
                    kykUkt.setUktadr1kj("");
                    kykUkt.setUktadr2kj("");
                    kykUkt.setUktadr3kj("");
                }
            }
            else {
                kykUkt.setUktyno("");
                kykUkt.setUktadr1kj("");
                kykUkt.setUktadr2kj("");
                kykUkt.setUktadr3kj("");
            }
        }
    }

    private void editTrkKzk() {

        IT_TrkKzk trkKzk;

        for (HT_MosTrkKzk mosTrkKzk : mosTrkKzkLst) {

            trkKzk = kykKihon.createTrkKzk();

            trkKzk.setTrkkzkkbn(mosTrkKzk.getTrkkzkkbn());
            trkKzk.setTrkkzksetteiymd(mosKihon.getKykymd());
            trkKzk.setTrkkzknmkn(mosTrkKzk.getTrkkzknmkn());
            trkKzk.setTrkkzknmkj(mosTrkKzk.getTrkkzknmkj());
            trkKzk.setTrkkzknmkjkhukakbn(mosTrkKzk.getTrkkzknmkjkhukakbn());
            trkKzk.setTrkkzkseiymd(mosTrkKzk.getTrkkzkseiymd());
            trkKzk.setTrkkzksei(mosTrkKzk.getTrkkzksei());

            if (C_Tdk.OIMEI.eq(mosTrkKzk.getTrkkzktdk())) {

                trkKzk.setTrkkzktdk(C_Tdk.SINTOU3);
            }
            else if (C_Tdk.GIRIKO.eq(mosTrkKzk.getTrkkzktdk())) {

                trkKzk.setTrkkzktdk(C_Tdk.KO);
            }
            else {

                trkKzk.setTrkkzktdk(mosTrkKzk.getTrkkzktdk());
            }

            if (C_TsindousiteiKbn.ARI.eq(mosTrkKzk.getTrkkzktsindousiteikbn())) {
                trkKzk.setTrkkzkyno(mosKihon.getTsinyno());
                trkKzk.setTrkkzkadr1kj(mosKihon.getTsinadr1kj());
                trkKzk.setTrkkzkadr2kj(mosKihon.getTsinadr2kj());
                trkKzk.setTrkkzkadr3kj(mosKihon.getTsinadr3kj());
            }
            else {
                trkKzk.setTrkkzkyno(mosTrkKzk.getTrkkzkyno());
                trkKzk.setTrkkzkadr1kj(mosTrkKzk.getTrkkzkadr1kj());
                trkKzk.setTrkkzkadr2kj(mosTrkKzk.getTrkkzkadr2kj());
                trkKzk.setTrkkzkadr3kj(mosTrkKzk.getTrkkzkadr3kj());
            }

            trkKzk.setTrkkzktelno(mosTrkKzk.getTrkkzktelno());
            trkKzk.setGyoumuKousinKinou(kinouId);
            trkKzk.setGyoumuKousinsyaId(kosId);
            trkKzk.setGyoumuKousinTime(sysTime);

            if (C_TsindousiteiKbn.ARI.eq(mosTrkKzk.getTrkkzktsindousiteikbn()) ||
                (mosKihon.getTsinyno().equals(mosTrkKzk.getTrkkzkyno()) &&
                    mosKihon.getTsinadr1kj().equals(mosTrkKzk.getTrkkzkadr1kj()) &&
                    mosKihon.getTsinadr2kj().equals(mosTrkKzk.getTrkkzkadr2kj()) &&
                    mosKihon.getTsinadr3kj().equals(mosTrkKzk.getTrkkzkadr3kj()))) {

                trkKzk.setTrkkzktsindousiteikbn(C_TsindousiteiKbn.ARI);
            }
            else {

                trkKzk.setTrkkzktsindousiteikbn(C_TsindousiteiKbn.BLNK);
            }

            BizPropertyInitializer.initialize(trkKzk);
        }
    }

    private void editTtdktyuui(HT_SyoriCTL pSyoriCTL) {

        IT_KhTtdkTyuui ttdktyuui = kykKihon.createKhTtdkTyuui();

        ttdktyuui.setTtdktyuuisetymd(null);
        ttdktyuui.setTtdktyuuisetnm("");
        ttdktyuui.setKktyuitakbn(C_KktyuitaKbn.BLNK);
        ttdktyuui.setTtdktyuuinaiyou1("");
        ttdktyuui.setTtdktyuuinaiyou2("");
        ttdktyuui.setTtdktyuuinaiyou3("");
        ttdktyuui.setTtdktyuuikbn1(C_TtdktyuuiKbn.BLNK);
        ttdktyuui.setTtdktyuuikbn2(C_TtdktyuuiKbn.BLNK);
        ttdktyuui.setTtdktyuuikbn3(C_TtdktyuuiKbn.BLNK);
        ttdktyuui.setTtdktyuuikbn4(C_TtdktyuuiKbn.BLNK);
        ttdktyuui.setTtdktyuuikbn5(C_TtdktyuuiKbn.BLNK);
        ttdktyuui.setTtdktyuuikbnhsknaiyou1("");
        ttdktyuui.setTtdktyuuikbnhsknaiyou2("");
        ttdktyuui.setTtdktyuuikbnhsknaiyou3("");
        ttdktyuui.setTtdktyuuikbnhsknaiyou4("");
        ttdktyuui.setTtdktyuuikbnhsknaiyou5("");
        ttdktyuui.setTtdktyuuikbnsetymd1(null);
        ttdktyuui.setTtdktyuuikbnsetymd2(null);
        ttdktyuui.setTtdktyuuikbnsetymd3(null);
        ttdktyuui.setTtdktyuuikbnsetymd4(null);
        ttdktyuui.setTtdktyuuikbnsetymd5(null);
        ttdktyuui.setSetsosikicd1("");
        ttdktyuui.setSetsosikicd2("");
        ttdktyuui.setSetsosikicd3("");
        ttdktyuui.setSetsosikicd4("");
        ttdktyuui.setSetsosikicd5("");
        ttdktyuui.setGyoumuKousinKinou(kinouId);
        ttdktyuui.setGyoumuKousinsyaId(kosId);
        ttdktyuui.setGyoumuKousinTime(sysTime);
        ttdktyuui.setKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.BLNK);
        ttdktyuui.setKykdrdouiyouhi(C_KykdrDouiYouhiKbn.BLNK);

        BizPropertyInitializer.initialize(ttdktyuui);
    }

    private void editKykDairiten(HT_SyoriCTL pSyoriCTL) {

        List<HT_MosDairiten> wkMosSyouhnLst = pSyoriCTL.getMosDairitens();
        if (wkMosSyouhnLst.size() == 0) {
            throw new CommonBizAppException("申込代理店テーブルにデータが存在しません。");
        }

        IT_KykDairiten kykDairiten;
        for (HT_MosDairiten mosDairiten : wkMosSyouhnLst) {

            kykDairiten = kykKihon.createKykDairiten();
            kykDairiten.setDrtenrenno(mosDairiten.getRenno());
            kykDairiten.setDrtencd(mosDairiten.getTratkiagcd());
            kykDairiten.setDrtenkanrisosikicd(mosDairiten.getDrtenkanrisosikicd());
            kykDairiten.setGyousekikeijyousakisosikicd(mosDairiten.getGyousekikeijyousakisosikicd());
            kykDairiten.setOyadrtencd(mosDairiten.getOyadrtencd());
            kykDairiten.setBosyuucd(mosDairiten.getBosyuucd());
            kykDairiten.setDaibosyuucd(mosDairiten.getDaibosyuucd());

            BizNumber bunwari = mosDairiten.getBunwari();
            if (BizNumber.valueOf(100).equals(bunwari)) {
                kykDairiten.setDrtenbunumu(C_UmuKbn.NONE);
            }
            else {
                kykDairiten.setDrtenbunumu(C_UmuKbn.ARI);
            }

            kykDairiten.setKanjidrtflg(C_Kanjidrtflg.HIKANJI);
            kykDairiten.setBunwari(mosDairiten.getBunwari());
            kykDairiten.setIkanymd(null);
            kykDairiten.setBsyujoyadrtencd(mosDairiten.getBsyujoyadrtencd());
            kykDairiten.setBsyujdrtencd(mosDairiten.getTratkiagcd());
            kykDairiten.setGyoumuKousinKinou(kinouId);
            kykDairiten.setGyoumuKousinsyaId(kosId);
            kykDairiten.setGyoumuKousinTime(sysTime);
            BizPropertyInitializer.initialize(kykDairiten);
        }
    }

    private C_ErrorKbn editNyuukinJisseki(
        HT_MosKihon pMosKihon,
        HT_SyoriCTL pSyoriCTL,
        MultipleEntityInserter pMultipleEntityInserter,
        int pDataNo) {

        ArrayList<IT_NyknJissekiRireki> nyknJissekiRirekiLst = new ArrayList<>();

        C_Hrkkaisuu hrkkaisuu = pMosKihon.getHrkkaisuu();

        int jyuutouKaisuu = pMosKihon.getSkjpjyuutoukaisuu();
        BizDate kykYmd = pMosKihon.getKykymd();
        BizDateYM kykYm = kykYmd.getBizDateYM();

        BizCurrency yenkansannyknkingk = BizCurrency.valueOf(0);
        BizDate yenkansantkykwsrateymd = null;
        BizNumber yenkansantkykwsrate = BizNumber.valueOf(0);
        BizCurrency yenkansannyknkingkZennou = BizCurrency.valueOf(0);
        BizDate yenkansantkykwsrateymdZennou = null;
        BizNumber yenkansantkykwsrateZennou = BizNumber.valueOf(0);
        BizCurrency zennounyuukinkgkrstk = BizCurrency.valueOf(0);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        C_YennykntksyuruiKbn yennyknTkSyuruiKbn = kykSonotaTkyk.getYennyknsyuruikbn();

        C_UmuKbn zennouMousideUmu = pMosKihon.getZennoumousideumu();

        int syohinHanteiKbn = SyouhinUtil.hantei(mosSyouhnLst.get(0).getSyouhncd());

        if (C_UmuKbn.ARI.eq(zennouMousideUmu)) {

            if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN  == syohinHanteiKbn) {

                zennounyuukinkgkrstk = pMosKihon.getZennoup();
            }
            else if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == syohinHanteiKbn) {

                zennounyuukinkgkrstk = pMosKihon.getHrktuukafstphrkgk().subtract(pMosKihon.getHrktuukaheijyunp());
            }
        }

        List<HT_MosSyouhn> wkMosSyouhnLst = pSyoriCTL.getMosSyouhns();
        BizDate denYmd = syoriYmd;
        rsYmd =   nyuukinInfoByMosnoZenhnknkbnSrgonyknumuBean.getRyosyuymdMin();

        TaisyouGkBean taisyouGkBean  =SWAKInjector.getInstance(TaisyouGkBean.class);

        TaisyouGkBean taisyouGkKariBean  =SWAKInjector.getInstance(TaisyouGkBean.class);
        TaisyouGkBean taisyouGkSyndskaipBean  =SWAKInjector.getInstance(TaisyouGkBean.class);
        TaisyouGkBean taisyouGkTkbriBean  =SWAKInjector.getInstance(TaisyouGkBean.class);
        TaisyouGkBean taisyouGkTkktbrsyuBean  =SWAKInjector.getInstance(TaisyouGkBean.class);
        TaisyouGkBean taisyouGkJindokoupBean  =SWAKInjector.getInstance(TaisyouGkBean.class);
        List<TaisyouGkBean> taisyouGkBeanLst =  new ArrayList<>();
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        String syouhncd = wkMosSyouhnLst.get(0).getSyouhncd();
        Integer syouhnsdno = wkMosSyouhnLst.get(0).getSyouhnsdno();

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(syouhncd, syouhnsdno);

        if(syouhnZokusei == null ){

            throw new CommonBizAppException("商品属性MSTにデータが存在しません。");
        }

        if(C_Hrkkaisuu.ITIJI.eq(hrkkaisuu)){

            taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP_SYOP);
            taisyouGkBean.setTaisyouGk(pMosKihon.getFstphrkgk());
            taisyouGkBean.setKeiyakutuukaGk(pMosKihon.getHyouteip());

            taisyouGkBeanLst.add(taisyouGkBean);
        }

        if(!C_Hrkkaisuu.ITIJI.eq(hrkkaisuu)){

            CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pMosKihon.getKyktuukasyu());

            if(C_UmuKbn.ARI.eq(pMosKihon.getIkkatuyoupumukbn())
                && pMosKihon.getSkjpjyuutoukaisuu() != 1){

                taisyouGkKariBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP);

                if (C_YennykntksyuruiKbn.PYENHRKM_GKHENDOU.eq(yennyknTkSyuruiKbn)) {

                    taisyouGkKariBean.setTaisyouGk(pMosKihon.getHrktuukafstphrkgk().add(
                        pMosKihon.getIkkatuyoupgkkeizokup()));
                }
                else {

                    taisyouGkKariBean.setTaisyouGk(pMosKihon.getFstphrkgk().multiply(pMosKihon.getSkjpjyuutoukaisuu()));
                }

                taisyouGkKariBean.setKeiyakutuukaGk(BizCurrency.valueOf(0,currencyType));

                taisyouGkBeanLst.add(taisyouGkKariBean);

                taisyouGkTkbriBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP_SYONENDO2KAIMEIKOU);

                if (C_YennykntksyuruiKbn.PYENHRKM_GKHENDOU.eq(yennyknTkSyuruiKbn)) {

                    taisyouGkTkbriBean.setTaisyouGk(pMosKihon.getIkkatuyoupgkkeizokup());
                }
                else {
                    taisyouGkTkbriBean.setTaisyouGk(
                        pMosKihon.getHeijyunp().multiply(pMosKihon.getSkjpjyuutoukaisuu() - 1));
                }

                taisyouGkTkbriBean.setKeiyakutuukaGk(BizCurrency.valueOf(0,currencyType));
                taisyouGkBeanLst.add(taisyouGkTkbriBean);
            }
            else {
                taisyouGkKariBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP);
                taisyouGkKariBean.setTaisyouGk(pMosKihon.getHrktuukafstphrkgk());
                taisyouGkKariBean.setKeiyakutuukaGk(BizCurrency.valueOf(0,currencyType));

                taisyouGkBeanLst.add(taisyouGkKariBean);

            }

            taisyouGkSyndskaipBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP_SYOP);
            taisyouGkSyndskaipBean.setTaisyouGk(pMosKihon.getHrktuukaheijyunp());
            taisyouGkSyndskaipBean.setKeiyakutuukaGk(BizCurrency.valueOf(0,currencyType));
            taisyouGkBeanLst.add(taisyouGkSyndskaipBean);

            if (C_IkkatubaraiKbn.TEIKIIKKATU.eq(mosKihon.getIkkatubaraikbn())) {

                taisyouGkTkktbrsyuBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP_SYONENDO2KAIMEIKOU);
                taisyouGkTkktbrsyuBean.setTaisyouGk(
                    pMosKihon.getIkkatup().subtract(pMosKihon.getHeijyunp()));
                taisyouGkTkktbrsyuBean.setKeiyakutuukaGk(BizCurrency.valueOf(0,currencyType));
                taisyouGkBeanLst.add(taisyouGkTkktbrsyuBean);
            }

            if (C_UmuKbn.ARI.eq(zennouMousideUmu)) {

                taisyouGkJindokoupBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP_JINENDO);
                taisyouGkJindokoupBean.setTaisyouGk(zennounyuukinkgkrstk);
                taisyouGkJindokoupBean.setKeiyakutuukaGk(BizCurrency.valueOf(0,currencyType));

                taisyouGkBeanLst.add(taisyouGkJindokoupBean);
            }
        }

        CommonSiwakeInBean commonSiwakeInBean =SWAKInjector.getInstance(CommonSiwakeInBean.class);

        denYmd = syoriYmd.addBusinessDays(1);

        commonSiwakeInBean.setKinouId(kinouId);
        commonSiwakeInBean.setDenYmd(denYmd);
        commonSiwakeInBean.setTuukasyu(pMosKihon.getHrktuukasyu());
        commonSiwakeInBean.setSyoriYmd(syoriYmd);
        commonSiwakeInBean.setKykYmd(pMosKihon.getKykymd());
        commonSiwakeInBean.setSyouhnCd(syouhncd);
        commonSiwakeInBean.setSyouhnsdNo(syouhnsdno);
        commonSiwakeInBean.setKyktuukaSyu(pMosKihon.getKyktuukasyu());
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwake commonSiwake =SWAKInjector.getInstance(CommonSiwake.class);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        String syorisosikicd = commonSiwakeOutBean.getHuridenatesakiCd() +"0000";

        C_KessantyouseiKbn kessantyouseiKbn = null;
        if (commonSiwakeOutBean.getDenyMd().getMonth() == 1 ||
            commonSiwakeOutBean.getDenyMd().getMonth() == 4 ||
            commonSiwakeOutBean.getDenyMd().getMonth() == 7 ||
            commonSiwakeOutBean.getDenyMd().getMonth() == 10 ) {
            BizDate kessanYmd = commonSiwakeOutBean.getDenyMd().getPreviousMonth().getBizDateYM().getLastDay();

            if (BizDateUtil.compareYmd(syoriYmd, denSimebi) != BizDateUtil.COMPARE_GREATER  &&
                BizDateUtil.compareYmd(ryosyuymdMax, kessanYmd) != BizDateUtil.COMPARE_GREATER  &&
                BizDateUtil.compareYmd(pMosKihon.getSknnkaisiymd(), kessanYmd) != BizDateUtil.COMPARE_GREATER) {
                kessantyouseiKbn = C_KessantyouseiKbn.OIKOMITAISYOU;
            }
            else {
                kessantyouseiKbn = C_KessantyouseiKbn.BLNK;
            }
        }
        else {
            kessantyouseiKbn = C_KessantyouseiKbn.BLNK;
        }

        BzSinkeiyakuDenpyouDataTourokuBean bzskDenpyouDataTourokuBean =
            SWAKInjector.getInstance(BzSinkeiyakuDenpyouDataTourokuBean.class);
        BzDenpyouDataSks bzDenpyouDataSks  =  SWAKInjector.getInstance(BzDenpyouDataSks.class);

        bzskDenpyouDataTourokuBean.setIbMosno(pSyoriCTL.getMosno());
        bzskDenpyouDataTourokuBean.setIbSyono(pSyoriCTL.getSyono());
        bzskDenpyouDataTourokuBean.setIbHuridenatesakicd(commonSiwakeOutBean.getHuridenatesakiCd());
        bzskDenpyouDataTourokuBean.setIbTantocd(commonSiwakeOutBean.getTantoCd());
        bzskDenpyouDataTourokuBean.setIbDenymd(commonSiwakeOutBean.getDenyMd());
        bzskDenpyouDataTourokuBean.setIbTuukasyu(commonSiwakeOutBean.getTuukasyu());
        bzskDenpyouDataTourokuBean.setIbSyoriymd(commonSiwakeOutBean.getSyoriYmd());
        bzskDenpyouDataTourokuBean.setIbSyoricd(commonSiwakeOutBean.getSyoriCd());
        bzskDenpyouDataTourokuBean.setIbSyorisosikicd(syorisosikicd);
        bzskDenpyouDataTourokuBean.setIbKessantyouseikbn(kessantyouseiKbn);
        bzskDenpyouDataTourokuBean.setIbNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        bzskDenpyouDataTourokuBean.setIbTekiyoukbn(C_TekiyouKbn.BLNK);
        bzskDenpyouDataTourokuBean.setIbDensyorikbn(C_DensyoriKbn.SEIRITU);
        bzskDenpyouDataTourokuBean.setIbAatsukaishasuitososhikicd(YuyuSinkeiyakuConfig.getInstance().getDairitenkyksosikicd());
        bzskDenpyouDataTourokuBean.setIbKykymd(pMosKihon.getKykymd());
        bzskDenpyouDataTourokuBean.setIbBosyuuym(pMosKihon.getBosyuuym());
        bzskDenpyouDataTourokuBean.setIbAatsukaishasoshikicd(mosDairitenLst.get(0).getDrtenkanrisosikicd());
        bzskDenpyouDataTourokuBean.setIbAatkisyadaibosyuucd(mosDairitenLst.get(0).getDaibosyuucd());
        bzskDenpyouDataTourokuBean.setIbSyusyouhncd(syouhncd);
        bzskDenpyouDataTourokuBean.setIbSdpdkbn(pMosKihon.getSdpdkbn());
        bzskDenpyouDataTourokuBean.setIbHrkkaisuu(pMosKihon.getHrkkaisuu());
        bzskDenpyouDataTourokuBean.setIbHrkkeiro(pMosKihon.getHrkkeiro());
        bzskDenpyouDataTourokuBean.setIbSknnkaisiymd(pMosKihon.getSknnkaisiymd());
        bzskDenpyouDataTourokuBean.setIbMosymd(pMosKihon.getMosymd());
        bzskDenpyouDataTourokuBean.setIbHnknriyuukbn(C_HenkinriyuuKbn.BLNK);
        bzskDenpyouDataTourokuBean.setIbFstpryosyuymd(pSyoriCTL.getRyosyuymd());
        bzskDenpyouDataTourokuBean.setIbAatkisyabosyuucd(mosDairitenLst.get(0).getBosyuucd());
        bzskDenpyouDataTourokuBean.setIbRyouritusdno(wkMosSyouhnLst.get(0).getRyouritusdno());
        bzskDenpyouDataTourokuBean.setIbGyoumuKousinsyaId(kosId);
        bzskDenpyouDataTourokuBean.setIbKakokawaserateshiteiflg(true);
        bzskDenpyouDataTourokuBean.setIbKakokawaserateshiteiymd(ryosyuymdMin);
        bzskDenpyouDataTourokuBean.setIbKyktuukasyu(pMosKihon.getKyktuukasyu());
        bzskDenpyouDataTourokuBean.setIbSyouhnsdno(wkMosSyouhnLst.get(0).getSyouhnsdno());
        bzskDenpyouDataTourokuBean.setBzSiwakeMeisaiBeanList(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst());

        List<HT_SkDenpyoData>  skDenpyoDataLst  = bzDenpyouDataSks.execSk(bzskDenpyouDataTourokuBean);

        BizCurrency rsgaku = BizCurrency.valueOf(0);
        if (C_UmuKbn.ARI.eq(zennouMousideUmu)) {

            if (C_IkkatubaraiKbn.TEIKIIKKATU.eq(pMosKihon.getIkkatubaraikbn())) {

                rsgaku = pMosKihon.getIkkatup();
            }
            else {
                rsgaku = pMosKihon.getHrktuukaheijyunp();
            }
        }
        else {
            rsgaku = pMosKihon.getHrktuukafstphrkgk();
        }

        BizDate ryosyuKwsratekjYmd = null;
        BizNumber ryosyukwsrate = BizNumber.ZERO;

        if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN != syohinHanteiKbn) {

            ryosyuKwsratekjYmd = pSyoriCTL.getNyknkwsratekijyunymd();
            ryosyukwsrate = pSyoriCTL.getNyknkwsrate();
        }

        if (!C_Tuukasyu.JPY.eq(pMosKihon.getHrktuukasyu())){
            GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

            C_ErrorKbn errorKbn = getKawaseRate.exec(ryosyuymdMin,
                C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                pMosKihon.getHrktuukasyu(),
                C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.JISSEIRATE,
                C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                C_YouhiKbn.HUYOU);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                setMisslistParam(
                    pDataNo,
                    MessageUtil.getMessage(MessageId.EIC1005, C_KawasetsryKbn.JISSEIRATE.getContent()),
                    C_Dbhanei.NONE,
                    pSyoriCTL.getSyono());

                return C_ErrorKbn.ERROR;
            }

            yenkansantkykwsrate = getKawaseRate.getKawaserate();
            yenkansantkykwsrateymd = ryosyuymdMin;

            BizCurrency yenkansantkyKingaku;

            if (C_UmuKbn.ARI.eq(zennouMousideUmu)) {

                yenkansantkyKingaku = pMosKihon.getHeijyunp();
            }
            else {

                yenkansantkyKingaku = pMosKihon.getFstphrkgk();
            }

            yenkansannyknkingk = keisanGaikakanzan.exec(C_Tuukasyu.JPY, yenkansantkyKingaku,
                yenkansantkykwsrate, C_HasuusyoriKbn.SUTE) ;

            if (C_UmuKbn.ARI.eq(zennouMousideUmu)) {

                yenkansannyknkingkZennou = keisanGaikakanzan.exec(C_Tuukasyu.JPY, pMosKihon.getZennoup(),
                    yenkansantkykwsrate, C_HasuusyoriKbn.SUTE) ;
                yenkansantkykwsrateZennou = yenkansantkykwsrate;
                yenkansantkykwsrateymdZennou = yenkansantkykwsrateymd;
            }
        }
        else {
            if (C_UmuKbn.ARI.eq(zennouMousideUmu)) {

                yenkansannyknkingkZennou = zennounyuukinkgkrstk;
                yenkansantkykwsrateZennou = ryosyukwsrate;
                yenkansantkykwsrateymdZennou = ryosyuKwsratekjYmd;
            }
        }

        BizCurrency hrkp = BizCurrency.valueOf(0);

        if(C_Hrkkaisuu.ITIJI.eq(hrkkaisuu)){

            hrkp = pMosKihon.getHyouteip();

        }
        else {

            hrkp = pMosKihon.getHeijyunp();

        }

        BizCurrency iktwaribikikgk = BizCurrency.valueOf(0);
        C_UmuKbn  iktnyuukinnumu  = null;

        if(C_IkkatubaraiKbn.TEIKIIKKATU.eq(pMosKihon.getIkkatubaraikbn())){

            iktwaribikikgk = pMosKihon.getHeijyunp().multiply(
                Integer.valueOf(pMosKihon.getIkkatubaraikaisuu().getValue())).subtract(pMosKihon.getIkkatup());

            iktnyuukinnumu = C_UmuKbn.ARI;
        }
        else {

            iktnyuukinnumu = C_UmuKbn.NONE;
        }

        int jyutoukaisuuy = 0;

        if (C_Hrkkaisuu.NEN.eq(pMosKihon.getHrkkaisuu())) {

            jyutoukaisuuy = 1;
        }

        int jyutoukaisuum = 0;

        if (C_Hrkkaisuu.TUKI.eq(pMosKihon.getHrkkaisuu())) {

            if (C_IkkatubaraiKbn.TEIKIIKKATU.eq(pMosKihon.getIkkatubaraikbn())) {

                jyutoukaisuum = Integer.valueOf(pMosKihon.getIkkatubaraikaisuu().getValue());
            }
            else if (C_IkkatubaraiKbn.BLNK.eq(pMosKihon.getIkkatubaraikbn())) {

                jyutoukaisuum = Integer.valueOf(pMosKihon.getHrkkaisuu().getValue());
            }
        }
        else if (C_Hrkkaisuu.HALFY.eq(pMosKihon.getHrkkaisuu())) {

            jyutoukaisuum = Integer.valueOf(pMosKihon.getHrkkaisuu().getValue());
        }

        C_TkiktbrisyuruiKbn tkiktbrisyuruiKbn = null;

        if (C_UmuKbn.ARI.eq(syouhnZokusei.getTeikiikkatubaraiumu())) {

            if (C_IkkatubaraiKbn.TEIKIIKKATU.eq(pMosKihon.getIkkatubaraikbn())) {

                if(pMosKihon.getIkkatubaraikaisuu().eq(C_IkkatubaraiKaisuuKbn.IKKATU12)){

                    tkiktbrisyuruiKbn = C_TkiktbrisyuruiKbn.TEIKI_12MONTHS;
                }
                else if(pMosKihon.getIkkatubaraikaisuu().eq(C_IkkatubaraiKaisuuKbn.IKKATU6)){

                    tkiktbrisyuruiKbn = C_TkiktbrisyuruiKbn.TEIKI_6MONTHS;
                }
            }
            else {

                tkiktbrisyuruiKbn = C_TkiktbrisyuruiKbn.NONE;
            }
        }
        else {

            tkiktbrisyuruiKbn = C_TkiktbrisyuruiKbn.BLNK;
        }

        String creditkessaiyouno = "";
        if (C_FstphrkkeiroKbn.CREDIT.eq(pMosKihon.getFstphrkkeirokbn())) {
            creditkessaiyouno = creditCardJyouhou.getCreditkessaiyouno();
        }

        editItZennou(skDenpyoDataLst.get(0).getDenrenno(), skDenpyoDataLst.get(0).getDenymd(), zennounyuukinkgkrstk,
            ryosyuKwsratekjYmd, ryosyukwsrate, yenkansannyknkingkZennou, yenkansantkykwsrateymdZennou,
            yenkansantkykwsrateZennou);

        IT_NyknJissekiRireki nyknJissekiRireki;

        for (int iCnt = 1; iCnt <= jyuutouKaisuu; iCnt++) {

            BizDateYM jyuutouStartYm1;
            C_NyknaiyouKbn nyknaiyouKbn;
            BizDateYM jyutouSyryYm = null;
            int ikkatuyoupKaisuu =0;

            if (iCnt == 1) {

                jyuutouStartYm1 = kykYm;
                nyknaiyouKbn = C_NyknaiyouKbn.SYOKAIP;
            }
            else {
                jyuutouStartYm1 = nyknJissekiRirekiLst.get(iCnt - 2).getJyutouendym().addMonths(1).getRekijyou();
                nyknaiyouKbn = C_NyknaiyouKbn.KEIZOKUP;
            }

            if (C_Hrkkaisuu.ITIJI.eq(hrkkaisuu)) {

                jyutouSyryYm = BizDateYM.valueOf("999999");
            }
            else if (C_Hrkkaisuu.TUKI.eq(hrkkaisuu)) {

                if (C_IkkatubaraiKbn.TEIKIIKKATU.eq(pMosKihon.getIkkatubaraikbn())) {

                    jyutouSyryYm = jyuutouStartYm1.addMonths(
                        Integer.valueOf(pMosKihon.getIkkatubaraikaisuu().getValue()) - 1).getRekijyou();
                }
                else if (C_IkkatubaraiKbn.BLNK.eq(pMosKihon.getIkkatubaraikbn())) {

                    jyutouSyryYm = jyuutouStartYm1;
                }
            }
            else if(C_Hrkkaisuu.NEN.eq(hrkkaisuu)||C_Hrkkaisuu.HALFY.eq(hrkkaisuu)) {

                jyutouSyryYm = jyuutouStartYm1.addMonths(
                    Integer.valueOf(pMosKihon.getHrkkaisuu().getValue()) - 1).getRekijyou();
            }

            if(jyuutouKaisuu != 1){
                ikkatuyoupKaisuu = pMosKihon.getIkkatuyoupkaisuu();

            }

            nyknJissekiRireki = kykKihon.createNyknJissekiRireki();
            nyknJissekiRireki.setJyutoustartym(jyuutouStartYm1);
            nyknJissekiRireki.setRenno(1);
            nyknJissekiRireki.setJyutouendym(jyutouSyryYm);

            if (C_YennykntksyuruiKbn.PYENHRKM_GKHENDOU.eq(yennyknTkSyuruiKbn) && iCnt > 1) {

                nyknJissekiRireki.setRsgaku(pMosKihon.getIkkatuyoupgkkeizokup().divide((jyuutouKaisuu - 1), 0, RoundingMode.DOWN));
                nyknJissekiRireki.setRyosyukwsratekjymd(pMosKihon.getKeizokuptkykwsratekjymd());
                nyknJissekiRireki.setRyosyukwsrate(pMosKihon.getKeizokuptkykwsrate());
                nyknJissekiRireki.setRyosyuymd(pSyoriCTL.getSrsyoriymd());
            }
            else {

                nyknJissekiRireki.setRsgaku(rsgaku);
                nyknJissekiRireki.setRyosyukwsratekjymd(ryosyuKwsratekjYmd);
                nyknJissekiRireki.setRyosyukwsrate(ryosyukwsrate);
                nyknJissekiRireki.setRyosyuymd(rsYmd);
            }

            nyknJissekiRireki.setRstuukasyu(pMosKihon.getHrktuukasyu());
            nyknJissekiRireki.setHrkp(hrkp);
            nyknJissekiRireki.setIktwaribikikgk(iktwaribikikgk);
            nyknJissekiRireki.setNyksyoriymd(nyuukinInfoByMosnoZenhnknkbnSrgonyknumuBean.getNyksyoriymd());
            nyknJissekiRireki.setNykdenno(skDenpyoDataLst.get(0).getDenrenno());
            nyknJissekiRireki.setNykdenymd(skDenpyoDataLst.get(0).getDenymd());
            nyknJissekiRireki.setNykkeiro(C_Nykkeiro.SKEI);
            nyknJissekiRireki.setHrkkaisuu(hrkkaisuu);
            nyknJissekiRireki.setJyutoukaisuuy(jyutoukaisuuy);
            nyknJissekiRireki.setJyutoukaisuum(jyutoukaisuum);
            nyknJissekiRireki.setNyknaiyoukbn(nyknaiyouKbn);
            nyknJissekiRireki.setIktnyuukinnumu(iktnyuukinnumu);
            nyknJissekiRireki.setNyktrksflg(C_Nyktrksflg.BLNK);
            nyknJissekiRireki.setNyktrksymd(null);
            nyknJissekiRireki.setNyktrksdenno("");
            nyknJissekiRireki.setNyktrksdenymd(null);
            nyknJissekiRireki.setYenkansannyknkingk(yenkansannyknkingk);
            nyknJissekiRireki.setYenkansantkykwsrateymd(yenkansantkykwsrateymd);
            nyknJissekiRireki.setYenkansantkykwsrate(yenkansantkykwsrate);
            nyknJissekiRireki.setHenkousikibetukey(sikibetuKey);
            nyknJissekiRireki.setGyoumuKousinKinou(kinouId);
            nyknJissekiRireki.setGyoumuKousinsyaId(kosId);
            nyknJissekiRireki.setGyoumuKousinTime(sysTime);
            nyknJissekiRireki.setIkkatuyoupkaisuu(ikkatuyoupKaisuu);
            nyknJissekiRireki.setTikiktbrisyuruikbn(tkiktbrisyuruiKbn);
            nyknJissekiRireki.setCreditkessaiyouno(creditkessaiyouno);

            BizPropertyInitializer.initialize(nyknJissekiRireki);

            nyknJissekiRirekiLst.add(nyknJissekiRireki);
        }

        for (HT_SkDenpyoData skDenpyoData : skDenpyoDataLst) {
            pMultipleEntityInserter.add(skDenpyoData);
        }

        nyknJissekiRirekiMap.put(pSyoriCTL.getSyono(), nyknJissekiRirekiLst);


        return C_ErrorKbn.OK;
    }

    private void editAnsyuuKihon(HT_MosKihon pMosKihon,HT_SyoriCTL pSyoriCTL) {

        if (C_Hrkkaisuu.ITIJI.eq(pMosKihon.getHrkkaisuu())) {

            if (syuHaraiManYmd == null ){
                ansyuKihon.setJkipjytym(null);
            }else{
                ansyuKihon.setJkipjytym(syuHaraiManYmd.getBizDateYM());
            }
        }
        else if (C_Hrkkaisuu.TUKI.eq(pMosKihon.getHrkkaisuu())) {

            if(C_IkkatubaraiKbn.TEIKIIKKATU.eq(pMosKihon.getIkkatubaraikbn())) {

                ansyuKihon.setJkipjytym(
                    pMosKihon.getKykymd().getBizDateYM().addMonths(
                        Integer.valueOf(pMosKihon.getIkkatubaraikaisuu().getValue())));
            }
            else if(C_IkkatubaraiKbn.BLNK.eq(pMosKihon.getIkkatubaraikbn())) {

                ansyuKihon.setJkipjytym(
                    pMosKihon.getKykymd().getBizDateYM().addMonths(pMosKihon.getSkjpjyuutoukaisuu()));

            }
        }
        else if (C_Hrkkaisuu.NEN.eq(pMosKihon.getHrkkaisuu())
            || C_Hrkkaisuu.HALFY.eq(pMosKihon.getHrkkaisuu())) {

            ansyuKihon.setJkipjytym(
                pMosKihon.getKykymd().getBizDateYM().addMonths(
                    Integer.valueOf(pMosKihon.getHrkkaisuu().getValue())));
        }

        ansyuKihon.setTkiktannaitukisuu(C_Tkiktannaitukisuu.BLNK);
        ansyuKihon.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.BLNK);
        ansyuKihon.setSyuharaimanymd(syuHaraiManYmd);
        ansyuKihon.setGyoumuKousinKinou(kinouId);
        ansyuKihon.setGyoumuKousinsyaId(kosId);
        ansyuKihon.setGyoumuKousinTime(sysTime);
        BizPropertyInitializer.initialize(ansyuKihon);
    }

    private void editKykKihon(HT_SyoriCTL pSyoriCTL, int pDataNo) {

        C_KijiKbn kijiKbn;

        if (C_UmuKbn.ARI.eq(pSyoriCTL.getHjynrkumu())) {
            kijiKbn = C_KijiKbn.BLNK;
        } else {
            HT_Kokutisyo kokutisyo = pSyoriCTL.getKokutisyo();

            if (kokutisyo == null) {
                kijiKbn = C_KijiKbn.BLNK;
            } else {
                kijiKbn = kokutisyo.getKijikbn();
            }
        }

        SetSyokenhakkouymd setSyokenhakkouymd =SWAKInjector.getInstance(SetSyokenhakkouymd.class);

        BizDate syoyousinkyksyohakkouymd =  setSyokenhakkouymd.exec(syoriYmd);

        C_StknsetKbn stknsetKbn = null;
        List<HT_MosSyouhn> mosSyouhnList = new SortHT_MosSyouhn().OrderHT_MosSyouhnBySyutkkbnAsc(pSyoriCTL.getMosSyouhns());

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(mosSyouhnList.get(0).getSyouhncd(),
            mosSyouhnList.get(0).getSyouhnsdno());

        if (C_UmuKbn.ARI.eq(syouhnZokusei.getStknumu())) {
            stknsetKbn = C_StknsetKbn.NONE;
        }
        else {
            stknsetKbn = C_StknsetKbn.BLNK;
        }

        BizCurrency hrkp = BizCurrency.optional();

        if(C_Hrkkaisuu.ITIJI.eq(mosKihon.getHrkkaisuu())){

            hrkp = mosKihon.getHyouteip();

        }
        else {

            hrkp = mosKihon.getHeijyunp();

        }

        C_TkiktbrisyuruiKbn tkiktbrisyuruiKbn = null;

        if (C_UmuKbn.ARI.eq(syouhnZokusei.getTeikiikkatubaraiumu())) {

            if (C_IkkatubaraiKbn.TEIKIIKKATU.eq(mosKihon.getIkkatubaraikbn())) {

                if (mosKihon.getIkkatubaraikaisuu().eq(C_IkkatubaraiKaisuuKbn.IKKATU12)) {

                    tkiktbrisyuruiKbn = C_TkiktbrisyuruiKbn.TEIKI_12MONTHS;
                }
                else if(Integer.valueOf(mosKihon.getIkkatubaraikaisuu().getValue()) == 6){

                    tkiktbrisyuruiKbn = C_TkiktbrisyuruiKbn.TEIKI_6MONTHS;
                }
            }
            else {

                tkiktbrisyuruiKbn = C_TkiktbrisyuruiKbn.NONE;
            }
        }
        else {

            tkiktbrisyuruiKbn = C_TkiktbrisyuruiKbn.BLNK;
        }

        kykKihon.setAitesyono("");
        kykKihon.setHaitoukbn(mosKihon.getHaitoukbn());
        kykKihon.setHrkkaisuu(mosKihon.getHrkkaisuu());
        kykKihon.setHrkkeiro(mosKihon.getHrkkeiro());
        kykKihon.setSdpdkbn(mosKihon.getSdpdkbn());
        kykKihon.setDntryouritukbn(mosKihon.getDntryouritukbn());
        kykKihon.setDntcd(mosKihon.getDntcd());
        kykKihon.setSntkhoukbn(mosKihon.getSntkhoukbn());
        kykKihon.setSinsakbn(C_SinsaKbn.BLNK);
        kykKihon.setMosymd(mosKihon.getMosymd());
        kykKihon.setKktymd(pSyoriCTL.getKktymd());
        kykKihon.setFstpnyknymd(rsYmd);
        kykKihon.setMosukeymd(mosKihon.getMosukeymd());
        kykKihon.setMosjimosuktymd(mosKihon.getMosjimosuktymd());
        kykKihon.setSeirituymd(pSyoriCTL.getSrsyoriymd());
        kykKihon.setItiprsymd(mosKihon.getItiprsymd());
        kykKihon.setHrkp(hrkp);
        kykKihon.setBosyuuym(mosKihon.getBosyuuym());
        kykKihon.setSeisekiym(mosKihon.getSeisekiym());
        kykKihon.setSkeikeijyouym(mosKihon.getSkeikeijyouym());
        kykKihon.setAisyoumeikbn(mosKihon.getAisyoumeikbn());
        kykKihon.setYakkanjyuryouhoukbn(mosKihon.getYakkanjyuryouhoukbn());
        kykKihon.setYakkanbunsyono(mosKihon.getYakkanbunsyono());
        kykKihon.setSiorino(mosKihon.getSiorino());
        kykKihon.setYnkhrkmgkannituutikbn(mosKihon.getYnkhrkmgkannituutikbn());

        String saihoCd = mosKihon.getSaihocd();

        if (BizUtil.isBlank(saihoCd)) {
            kykKihon.setSyusaiumu(C_UmuKbn.NONE);
        }
        else {
            kykKihon.setSyusaiumu(C_UmuKbn.ARI);
        }

        kykKihon.setStknsetkbn(stknsetKbn);
        kykKihon.setKykksykjyumu(C_UmuKbn.NONE);
        kykKihon.setKykksumu(C_UmuKbn.NONE);
        kykKihon.setAplkahikbn(mosKihon.getAplkahikbn());
        kykKihon.setAplumu(C_UmuKbn.NONE);
        kykKihon.setFstphrkkeirokbn(mosKihon.getFstphrkkeirokbn());
        kykKihon.setHaitounendo(null);
        kykKihon.setHaitoukinuketorihoukbn(mosKihon.getHaitoukinuketorihoukbn());
        kykKihon.setTratkityuiumu(C_UmuKbn.NONE);
        kykKihon.setTratkityuiuny("");
        kykKihon.setSbuktnin(mosKihon.getSbuktnin());
        kykKihon.setGansindankakuteiymd(null);
        kykKihon.setMosuketukekbn(pSyoriCTL.getMosuketukekbn());
        kykKihon.setKijikbn(kijiKbn);
        kykKihon.setHhknsykgycd(mosKihon.getHhknsykgycd());
        kykKihon.setHhknnensyuukbn(mosKihon.getHhknnensyuukbn());
        kykKihon.setDrtenkanritodoufukencd(todouhukencd);
        if (mosDairitenLst != null && mosDairitenLst.size() !=0){
            kykKihon.setCifcd(mosDairitenLst.get(0).getCifcd());
        }
        kykKihon.setSmbckanriid(mosKihon.getUktkid());
        kykKihon.setTsryhshrkykumukbn(mosKihon.getTsryhshrkykumukbn());
        kykKihon.setKykhonninkakninsyoruikbn(mosKihon.getKykhonninkakninsyoruikbn());
        kykKihon.setSkskknhonninkakninsyoruikbn(mosKihon.getSkskknhonninkakninsyoruikbn());
        kykKihon.setBoskykjyoutai(mosKihon.getBoskykjyoutai());
        kykKihon.setDrctservicemoskbn(mosKihon.getDrctservicemoskbn());
        kykKihon.setSksyoukenskskbn(C_SkSyoukenSksKbn.SINKISAKUSEI);
        kykKihon.setSinkyksyokensakuseiymd(syoriYmd);
        kykKihon.setSyoyousinkyksyohakkouymd(syoyousinkyksyohakkouymd);
        kykKihon.setSkjmosno(mosKihon.getMosno());
        kykKihon.setNkuikosumikbn(C_NkIkouzumiKbn.BLNK);
        kykKihon.setSyhenkouymd(syoriYmd);
        kykKihon.setLastsyosaihkymd(null);
        kykKihon.setLastkykmeighnkymd(null);
        kykKihon.setLastsbukthenymd(null);
        kykKihon.setLastmeihenymd(null);
        kykKihon.setLastjyuuhenymd(null);
        kykKihon.setGyoumuKousinKinou(kinouId);
        kykKihon.setGyoumuKousinsyaId(kosId);
        kykKihon.setGyoumuKousinTime(sysTime);
        kykKihon.setSeiritujitrhkjikakkbn(mosKihon.getTrhkjikakkbn());
        kykKihon.setTikiktbrisyuruikbn(tkiktbrisyuruiKbn);
        BizPropertyInitializer.initialize(kykKihon);
    }

    private HT_KouzaJyouhou getKouzainfo(HT_MosKihon pMosKihon, HT_SyoriCTL pSyoriCTL) {

        String mosno = pSyoriCTL.getMosno();
        C_Hrkkeiro hrkkeiro = pMosKihon.getHrkkeiro();
        C_FstphrkkeiroKbn fstphrkkeiroKbn = pMosKihon.getFstphrkkeirokbn();

        HT_KouzaJyouhou kouzaJyouhou = null;

        if (C_Hrkkeiro.KOUHURI.eq(hrkkeiro) || C_FstphrkkeiroKbn.KOUHURI.eq(fstphrkkeiroKbn)) {
            kouzaJyouhou = sinkeiyakuDomManager.getSyoriCTL(mosno).getKouzaJyouhou();

            if (kouzaJyouhou == null) {
                throw new CommonBizAppException("口座情報TBLにデータが存在しません。");
            }
        }

        return kouzaJyouhou;
    }

    private void getCreditCardInfo(HT_MosKihon pMosKihon, HT_SyoriCTL pSyoriCTL) {

        String mosno = pSyoriCTL.getMosno();
        C_Hrkkeiro hrkkeiro = pMosKihon.getHrkkeiro();
        C_FstphrkkeiroKbn fstphrkkeiroKbn = pMosKihon.getFstphrkkeirokbn();

        if (C_Hrkkeiro.CREDIT.eq(hrkkeiro) || C_FstphrkkeiroKbn.CREDIT.eq(fstphrkkeiroKbn)) {
            creditCardJyouhou = sinkeiyakuDomManager.getSyoriCTL(mosno).getCreditCardJyouhou();

            if (creditCardJyouhou == null) {
                throw new CommonBizAppException("クレジットカード情報TBLにデータが存在しません。");
            }
        }
    }

    private void insKoujyoSymKnr(String pSyono,
        EditKoujyoSyoumeiParam pEditKoujyoSyoumeiParam, BizDateYM pLastSyoumeiEndYm) {


        IT_KoujyoSymKanri koujyoSymKanri = kykKihon.createKoujyoSymKanri();

        koujyoSymKanri.setNendo(pEditKoujyoSyoumeiParam.getKoujyoNendo());
        koujyoSymKanri.setLastsyoumeiendym(pLastSyoumeiEndYm);
        koujyoSymKanri.setGyoumuKousinKinou(kinouId);
        koujyoSymKanri.setGyoumuKousinsyaId(kosId);
        koujyoSymKanri.setGyoumuKousinTime(sysTime);

        BizPropertyInitializer.initialize(koujyoSymKanri);
    }


    private void insFatcaInfo(HT_MosKihon pMosKihon, HT_SyoriCTL pSyoriCTL) {

        IT_FatcaInfo fatcaInfo = kykKihon.createFatcaInfo();

        String seionnmkn = BizUtil.editKana(pMosKihon.getKyknmkn());

        fatcaInfo.setRenno(1);

        fatcaInfo.setFatcasnsikbn(pMosKihon.getFatcasnsikbn());

        fatcaInfo.setBikkjnssinfokbn(pMosKihon.getBikkjnssinfokbn());

        C_FatcakekKbn fatcakekKbn = C_FatcakekKbn.BLNK;

        if (C_FatcakakkekkaKbn.FATCA_HOUKOKUTAISYOU.eq(pSyoriCTL.getFatcakakkekkakbn())) {
            fatcakekKbn = C_FatcakekKbn.TOKUTEIAMERICAN;
        }
        else if (C_FatcakakkekkaKbn.FATCA_TEIKITYOSAYOU.eq(pSyoriCTL.getFatcakakkekkakbn())) {
            fatcakekKbn = C_FatcakekKbn.TAISYOUGAIYOU;
        }
        else if (C_FatcakakkekkaKbn.FATCA_TEIKITYOSAHUYOU.eq(pSyoriCTL.getFatcakakkekkakbn())) {
            fatcakekKbn = C_FatcakekKbn.TAISYOUGAIHUYOU;
        }

        fatcaInfo.setSyoriYmd(pMosKihon.getMosymd());

        fatcaInfo.setSyorisosikicd(busitucdKettei);

        fatcaInfo.setFatcakekkbn(fatcakekKbn);

        fatcaInfo.setFatcahankeiikbn(C_FatcahankeiiKbn.SINKEIYAKU);

        fatcaInfo.setBikknzsyno(pMosKihon.getBikknzsyno());

        fatcaInfo.setSyomeiymd(pMosKihon.getSyomeiymd());

        fatcaInfo.setKokno("");

        fatcaInfo.setFatcatgkbn(C_FatcatgKbn.KYK);

        fatcaInfo.setSeionnmkn(seionnmkn);

        fatcaInfo.setNmkn(pMosKihon.getKyknmkn());

        fatcaInfo.setNmkj(pMosKihon.getKyknmkj());

        fatcaInfo.setSeiymd(pMosKihon.getKykseiymd());

        fatcaInfo.setSeibetu(C_Seibetu.valueOf(pMosKihon.getKyksei().getValue()));

        fatcaInfo.setKouryokuendymd(null);

        fatcaInfo.setTrkymd(syoriYmd);

        fatcaInfo.setGyoumuKousinKinou(kinouId);

        fatcaInfo.setGyoumuKousinsyaId(kosId);

        fatcaInfo.setGyoumuKousinTime(sysTime);

        BizPropertyInitializer.initialize(fatcaInfo);
    }

    private void insAeoiInfo(HT_MosKihon pMosKihon, HT_SyoriCTL pSyoriCTL) {
        IT_AeoiInfo aeoiInfo = kykKihon.createAeoiInfo();

        aeoiInfo.setRenno(1);
        aeoiInfo.setAeoisyoriymd(pMosKihon.getMosymd());
        aeoiInfo.setAeoisyorikbn(C_AeoiSyoriKbn.SINKEIYAKU);
        aeoiInfo.setAeoikouryokusttymd(pMosKihon.getMosymd());
        aeoiInfo.setAeoisyorisosikicd(busitucdKettei);
        aeoiInfo.setAeoitaisyousyakbn(C_AeoiTaisyousyaKbn.KYKSYA);
        aeoiInfo.setAeoikekkakbn(pSyoriCTL.getAeoikekkakbn());
        aeoiInfo.setAeoihoujinsyuruikbn(C_AeoiHoujinSyuruiKbn.BLNK);
        aeoiInfo.setAeoikouryokuendymd(null);
        aeoiInfo.setGyoumuKousinKinou(kinouId);
        aeoiInfo.setGyoumuKousinsyaId(kosId);
        aeoiInfo.setGyoumuKousinTime(sysTime);
        BizPropertyInitializer.initialize(aeoiInfo);
    }

    private void getKeiyakuInfo(HT_SyoriCTL pSyoriCTL){
        mosSyouhnLst= pSyoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        uketorininLst=pSyoriCTL.getUketorinins();
        mosDairitenLst =pSyoriCTL.getMosDairitens();
        mosTrkKzkLst = pSyoriCTL.getMosTrkKzks();
        uketoriKouzaJyouhouLst = pSyoriCTL.getUketoriKouzaJyouhous();
        BzGetAgInfo bzGetAgInfo =SWAKInjector.getInstance(BzGetAgInfo.class);

        if (mosDairitenLst != null && mosDairitenLst.size() != 0){
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = bzGetAgInfo.exec(mosDairitenLst.get(0).getTratkiagcd());

            String sosikiCd;

            if (BizUtil.isBlank(mosDairitenLst.get(0).getGyousekikeijyousakisosikicd())) {

                sosikiCd = bzGetAgInfoBeanLst.get(0).getDrtKanrisosikiCd1();
            }
            else {
                sosikiCd = mosDairitenLst.get(0).getGyousekikeijyousakisosikicd();
            }
            sosikiCd = sosikiCd.substring(0, 3) + "0000";

            BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

            BzGetAdrData bzGetAdrData = SWAKInjector.getInstance(BzGetAdrData.class);

            BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(sosikiCd);

            String sosikikihontikucd = bzGetSosikiDataBean.getSosikikihontikucd();

            if (!BizUtil.isBlank(sosikikihontikucd)) {

                bzGetAdrData.execTodouhukenCdByPostalcd(sosikikihontikucd.substring(0, 7));

                todouhukencd = bzGetAdrData.getTodouhukenCd().getValue();
            }
            else {
                todouhukencd = "0";
            }
        }

    }

    private C_ErrorKbn editTjtIdouNyKh(int pDataNo, String pSyoNo) {
        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.HRKMTYUU;
        Integer kykhhkndouhyouji = 0;
        C_UmuKbn kaigomaehrtkykumukbn = C_UmuKbn.NONE;
        C_UmuKbn pyennykntkykumukbn = C_UmuKbn.NONE;
        C_HouteiTyotkseiSyouhnHyjKbn houteiTyotkseiSyouhnHyj;
        C_UmuKbn houteiTyotkseiSyouhnHyjUmukbn;
        BM_SyouhnZokusei syouhnZokusei;

        syouhnZokusei = bizDomManager.getSyouhnZokusei(
            mosSyouhnLst.get(0).getSyouhncd(),
            mosSyouhnLst.get(0).getSyouhnsdno());
        IT_KykSyouhn kykSyouhn= kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);
        IT_NyknJissekiRireki nyknJissekiRireki = kykKihon.getNyknJissekiRirekis().get(0);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        GetKhTuusanyouKngk khTuusanyouKngk = SWAKInjector.getInstance(GetKhTuusanyouKngk.class);

        GetKhTuusanyouKngkBean khTuusanyouKngkBean = khTuusanyouKngk.getAlltsnkngk(
            syouhnZokusei,
            kykSyouhn,
            nyknJissekiRireki,
            kykSonotaTkyk);

        HanteiTyotikuseihokenBean hanteiTyotikuseihokenBean = SWAKInjector.getInstance(HanteiTyotikuseihokenBean.class);

        hanteiTyotikuseihokenBean.setSyouhnCd(kykSyouhn.getSyouhncd());
        hanteiTyotikuseihokenBean.setSyouhnsdNo(kykSyouhn.getSyouhnsdno());
        hanteiTyotikuseihokenBean.setHrkkaisuu(kykKihon.getHrkkaisuu());
        hanteiTyotikuseihokenBean.setHrkkeiro(kykKihon.getHrkkeiro());

        SetTyotikuseihokenhyouji setTyotikuseihokenhyouji = SWAKInjector.getInstance(SetTyotikuseihokenhyouji.class);

        C_ErrorKbn errorKbn = setTyotikuseihokenhyouji.hanteiTyotikuseihoken(hanteiTyotikuseihokenBean);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            setMisslistParam(
                pDataNo,
                "貯蓄性保険表示設定が実行できませんでした。",
                C_Dbhanei.NONE,
                pSyoNo);

            return C_ErrorKbn.ERROR;
        }

        houteiTyotkseiSyouhnHyjUmukbn = setTyotikuseihokenhyouji.getHouteityotkhknhyj();

        if (C_Hrkkaisuu.ITIJI.eq(mosKihon.getHrkkaisuu())){
            kykjyoutai = C_Kykjyoutai.ITIJIBARAI;
        }
        else if(C_UmuKbn.ARI.eq(mosKihon.getZennoumousideumu())) {

            kykjyoutai = C_Kykjyoutai.ZENNOU;
        }
        else if (C_IkkatubaraiKbn.TEIKIIKKATU.eq(mosKihon.getIkkatubaraikbn())) {

            kykjyoutai = C_Kykjyoutai.IKKATUNK;
        }
        else {

            kykjyoutai = C_Kykjyoutai.HRKMTYUU;
        }

        if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())){
            kykhhkndouhyouji = 1;
        }
        if (C_Tkhukaumu.HUKA.eq(mosKihon.getJyudkaigomehrtkhkkbn())) {
            kaigomaehrtkykumukbn = C_UmuKbn.ARI;
        }
        if (C_Tkhukaumu.HUKA.eq(mosKihon.getYennykntkhkkbn())) {
            pyennykntkykumukbn = C_UmuKbn.ARI;
        }

        if (C_UmuKbn.ARI.eq(houteiTyotkseiSyouhnHyjUmukbn)) {

            houteiTyotkseiSyouhnHyj = C_HouteiTyotkseiSyouhnHyjKbn.GAITOU;
        }
        else {
            houteiTyotkseiSyouhnHyj = C_HouteiTyotkseiSyouhnHyjKbn.HIGAITOU;
        }

        tjtIdouNyKh.setRecordsakujyohyouji(0);
        tjtIdouNyKh.setYoukyuuno("");
        tjtIdouNyKh.setSyouhncd(mosSyouhnLst.get(0).getSyouhncd());
        tjtIdouNyKh.setKykjyoutai(kykjyoutai);
        tjtIdouNyKh.setKykymd(mosKihon.getKykymd());
        tjtIdouNyKh.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        tjtIdouNyKh.setSyoumetujiyuu(C_Syoumetujiyuu.BLNK);
        tjtIdouNyKh.setSyoumetuymd(null);
        tjtIdouNyKh.setKyktuukasyu(mosKihon.getKyktuukasyu());
        tjtIdouNyKh.setTsnyousibous(khTuusanyouKngkBean.getTsnyouSibous());
        tjtIdouNyKh.setTsnyouitijip(khTuusanyouKngkBean.getTsnyouItijip());
        tjtIdouNyKh.setTsnyounkgns(khTuusanyouKngkBean.getTsnyouNkgns());
        tjtIdouNyKh.setHrkkkn(mosSyouhnLst.get(0).getHrkkkn());
        tjtIdouNyKh.setSntkhoukbn(mosKihon.getSntkhoukbn());
        tjtIdouNyKh.setBosyuuym(mosKihon.getBosyuuym());
        tjtIdouNyKh.setKykhhkndouhyouji(kykhhkndouhyouji);
        tjtIdouNyKh.setTtdktyuuikbn1(C_TtdktyuuiKbn.BLNK);
        tjtIdouNyKh.setTtdktyuuikbn2(C_TtdktyuuiKbn.BLNK);
        tjtIdouNyKh.setTtdktyuuikbn3(C_TtdktyuuiKbn.BLNK);
        tjtIdouNyKh.setTtdktyuuikbn4(C_TtdktyuuiKbn.BLNK);
        tjtIdouNyKh.setTtdktyuuikbn5(C_TtdktyuuiKbn.BLNK);
        tjtIdouNyKh.setSyouhnsdno(mosSyouhnLst.get(0).getSyouhnsdno());
        tjtIdouNyKh.setKaigomaehrtkykumukbn(kaigomaehrtkykumukbn);
        tjtIdouNyKh.setPyennykntkykumukbn(pyennykntkykumukbn);
        tjtIdouNyKh.setTsnyennyknkgk(khTuusanyouKngkBean.getTsnyouYennyknkgk());
        tjtIdouNyKh.setSkjmosno(mosKihon.getMosno());
        tjtIdouNyKh.setGyoumuKousinKinou(kinouId);
        tjtIdouNyKh.setGyoumuKousinsyaId(kosId);
        tjtIdouNyKh.setGyoumuKousinTime(sysTime);
        tjtIdouNyKh.setSeiritujitrhkjikakkbn(mosKihon.getTrhkjikakkbn());
        tjtIdouNyKh.setHouteityotkseisyouhnhyj(houteiTyotkseiSyouhnHyj);
        tjtIdouNyKh.setTsntuukasyu(khTuusanyouKngkBean.getTsnyouTuukasyu());
        tjtIdouNyKh.setHrkkeiro(mosKihon.getHrkkeiro());

        BizPropertyInitializer.initialize(tjtIdouNyKh);

        return C_ErrorKbn.OK;
    }

    private void editIdouKhMeigi(HT_KouzaJyouhou pKouzaJyouhou) {
        String sbuktnmkn1 = "";
        String sbuktnmkj1 = "";
        String sbuktnmkn2 = "";
        String sbuktnmkj2 = "";
        String sbuktnmkn3 = "";
        String sbuktnmkj3 = "";
        String sbuktnmkn4 = "";
        String sbuktnmkj4 = "";
        String stdrsknmkn = "";
        String stdrsknmkj = "";
        String hhknnmkj = "";
        String hhknyno = "";
        String kyknmkn = "";
        String kyknmkj = "";
        BizDate kykseiymd = null;
        String kykdairinmkn = "";
        String kykdairinmkj = "";
        String kzktourokunmkn1 = "";
        String kzktourokunmkj1 = "";
        String kzktourokunmkn2 = "";
        String kzktourokunmkj2 = "";

        for (HT_Uketorinin uketorinin : uketorininLst) {
            if (C_UktsyuKbn.SBUKT.eq(uketorinin.getUktsyukbn()) && C_UktKbn.TOKUTEIMEIGI.eq(uketorinin.getUktkbn())){
                if (uketorinin.getUktsyurenno()==1){
                    sbuktnmkn1 = uketorinin.getUktnmkn();

                    if (C_KjkhukaKbn.KJKHUKA.eq(uketorinin.getUktnmkjkhukakbn())) {
                        sbuktnmkj1 = "";
                    }
                    else {
                        sbuktnmkj1 = uketorinin.getUktnmkj();
                    }
                }
                else if (uketorinin.getUktsyurenno()==2){
                    sbuktnmkn2 = uketorinin.getUktnmkn();

                    if (C_KjkhukaKbn.KJKHUKA.eq(uketorinin.getUktnmkjkhukakbn())) {
                        sbuktnmkj2 = "";
                    }
                    else {
                        sbuktnmkj2 = uketorinin.getUktnmkj();
                    }
                }
                else if (uketorinin.getUktsyurenno()==3){
                    sbuktnmkn3 = uketorinin.getUktnmkn();

                    if (C_KjkhukaKbn.KJKHUKA.eq(uketorinin.getUktnmkjkhukakbn())) {
                        sbuktnmkj3 = "";
                    }
                    else {
                        sbuktnmkj3 = uketorinin.getUktnmkj();
                    }
                }
                else if (uketorinin.getUktsyurenno()==4){
                    sbuktnmkn4 = uketorinin.getUktnmkn();

                    if (C_KjkhukaKbn.KJKHUKA.eq(uketorinin.getUktnmkjkhukakbn())) {
                        sbuktnmkj4 = "";
                    }
                    else {
                        sbuktnmkj4 = uketorinin.getUktnmkj();
                    }
                }
            }
            else  if (C_UktsyuKbn.STDRSK.eq(uketorinin.getUktsyukbn())){
                if (C_UktKbn.TOKUTEIMEIGI.eq(uketorinin.getUktkbn())){
                    stdrsknmkn = uketorinin.getUktnmkn();

                    if (C_KjkhukaKbn.KJKHUKA.eq(uketorinin.getUktnmkjkhukakbn())) {
                        stdrsknmkj = "";
                    }
                    else {
                        stdrsknmkj = uketorinin.getUktnmkj();
                    }

                }
            }
            else if (C_UktsyuKbn.KYKDRN.eq(uketorinin.getUktsyukbn())) {
                if (C_UktKbn.TOKUTEIMEIGI.eq(uketorinin.getUktkbn())){
                    kykdairinmkn = uketorinin.getUktnmkn();

                    if (C_KjkhukaKbn.KJKHUKA.eq(uketorinin.getUktnmkjkhukakbn())) {
                        kykdairinmkj = "";
                    }
                    else {
                        kykdairinmkj = uketorinin.getUktnmkj();
                    }
                }
            }
        }

        for(HT_MosTrkKzk mosTrkKzk : mosTrkKzkLst) {
            if (C_TrkKzkKbn.TRKKZK1.eq(mosTrkKzk.getTrkkzkkbn())) {
                kzktourokunmkn1 = mosTrkKzk.getTrkkzknmkn();

                if (C_KjkhukaKbn.KJKHUKA.eq(mosTrkKzk.getTrkkzknmkjkhukakbn())) {
                    kzktourokunmkj1 = "";
                }
                else {
                    kzktourokunmkj1 = mosTrkKzk.getTrkkzknmkj();
                }
            }

            else if (C_TrkKzkKbn.TRKKZK2.eq(mosTrkKzk.getTrkkzkkbn())) {
                kzktourokunmkn2 = mosTrkKzk.getTrkkzknmkn();

                if (C_KjkhukaKbn.KJKHUKA.eq(mosTrkKzk.getTrkkzknmkjkhukakbn())) {
                    kzktourokunmkj2 = "";
                }
                else {
                    kzktourokunmkj2 = mosTrkKzk.getTrkkzknmkj();
                }
            }
        }

        if (C_TsindousiteiKbn.BLNK.eq(mosKihon.getTsindousiteikbn())){
            hhknyno = mosKihon.getHhknyno();
        }
        else
        {
            hhknyno = mosKihon.getTsinyno();
        }

        if (C_KjkhukaKbn.KJKHUKA.eq(mosKihon.getHhknnmkjkhukakbn())) {
            hhknnmkj = "";
        }
        else {
            hhknnmkj = mosKihon.getHhknnmkj();
        }

        if (!C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {
            kyknmkn = mosKihon.getKyknmkn();

            if (C_KjkhukaKbn.KJKHUKA.eq(mosKihon.getKyknmkjkhukakbn())) {
                kyknmkj = "";
            }
            else {
                kyknmkj = mosKihon.getKyknmkj();
            }
            kykseiymd = mosKihon.getKykseiymd();
        }

        BT_IdouKhMeigi idouKhMeigi =tjtIdouNyKh.createIdouKhMeigi();

        idouKhMeigi.setHhknnmkn(mosKihon.getHhknnmkn());
        idouKhMeigi.setHhknnmkj(hhknnmkj);
        idouKhMeigi.setHhknseiymd(mosKihon.getHhknseiymd());
        idouKhMeigi.setHhknsei(mosKihon.getHhknsei());
        idouKhMeigi.setHhknyno(hhknyno);
        idouKhMeigi.setHhknadr1kj("");
        idouKhMeigi.setHhknadr2kj("");
        idouKhMeigi.setHhknadr3kj("");
        idouKhMeigi.setHhkntelno("");
        idouKhMeigi.setHhknsykgycd(mosKihon.getHhknsykgycd());
        idouKhMeigi.setKyknmkn(kyknmkn);
        idouKhMeigi.setKyknmkj(kyknmkj);
        idouKhMeigi.setKykseiymd(kykseiymd);
        idouKhMeigi.setNenkinuktnmkana("");
        idouKhMeigi.setNenkinuktnmkanji("");
        idouKhMeigi.setNenkinuktseiymd(null);
        idouKhMeigi.setTsinyno(mosKihon.getTsinyno());
        idouKhMeigi.setTsinadr1kj(mosKihon.getTsinadr1kj());
        idouKhMeigi.setTsinadr2kj(mosKihon.getTsinadr2kj());
        idouKhMeigi.setTsinadr3kj(mosKihon.getTsinadr3kj());
        idouKhMeigi.setTsintelno(mosKihon.getTsintelno());
        idouKhMeigi.setSbuktnmkn1(sbuktnmkn1);
        idouKhMeigi.setSbuktnmkj1(sbuktnmkj1);
        idouKhMeigi.setSbuktnmkn2(sbuktnmkn2);
        idouKhMeigi.setSbuktnmkj2(sbuktnmkj2);
        idouKhMeigi.setSbuktnmkn3(sbuktnmkn3);
        idouKhMeigi.setSbuktnmkj3(sbuktnmkj3);
        idouKhMeigi.setSbuktnmkn4(sbuktnmkn4);
        idouKhMeigi.setSbuktnmkj4(sbuktnmkj4);
        idouKhMeigi.setStdrsknmkn(stdrsknmkn);
        idouKhMeigi.setStdrsknmkj(stdrsknmkj);

        if(C_Hrkkeiro.KOUHURI.eq(mosKihon.getHrkkeiro()) &&
            C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())){

            idouKhMeigi.setBankcd(pKouzaJyouhou.getBankcd());
            idouKhMeigi.setSitencd(pKouzaJyouhou.getSitencd());
            idouKhMeigi.setYokinkbn(pKouzaJyouhou.getYokinkbn());
            idouKhMeigi.setKouzano(pKouzaJyouhou.getKouzano());
            idouKhMeigi.setKzkykdoukbn(pKouzaJyouhou.getKzkykdoukbn());

            if (C_KzkykdouKbn.DOUITU.eq(pKouzaJyouhou.getKzkykdoukbn())){

                if ( C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {

                    idouKhMeigi.setKzmeiginmkn(mosKihon.getHhknnmkn());
                }
                else if(C_KykKbn.KEIHI_BETU.eq(mosKihon.getKykkbn())){

                    idouKhMeigi.setKzmeiginmkn(mosKihon.getKyknmkn());
                }
            }
            else if(C_KzkykdouKbn.SITEI.eq(pKouzaJyouhou.getKzkykdoukbn())){

                idouKhMeigi.setKzmeiginmkn(pKouzaJyouhou.getKzmeiginmkn());
            }
        }

        idouKhMeigi.setKykdairinmkn(kykdairinmkn);
        idouKhMeigi.setKykdairinmkj(kykdairinmkj);
        idouKhMeigi.setKzktourokunmkn1(kzktourokunmkn1);
        idouKhMeigi.setKzktourokunmkj1(kzktourokunmkj1);
        idouKhMeigi.setKzktourokunmkn2(kzktourokunmkn2);
        idouKhMeigi.setKzktourokunmkj2(kzktourokunmkj2);

        BizPropertyInitializer.initialize(idouKhMeigi);
    }

    private C_ErrorKbn editIdouKhBosyuudr(HT_SyoriCTL pSyoriCTL, int pDataNo) {
        String  dairitencd1 = "";
        BizNumber bunwari1 = BizNumber.valueOf(0);
        String  dairitencd2 = "";
        BizNumber bunwari2 =BizNumber.valueOf(0);
        String kanrisosikicd2 = "";

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(mosSyouhnLst.get(0).getSyouhncd(),
            mosSyouhnLst.get(0).getSyouhnsdno());

        BizNumber bunwari = mosDairitenLst.get(0).getBunwari();
        if (BizNumber.valueOf(100).equals(bunwari)) {
            dairitencd1 = mosDairitenLst.get(0).getTratkiagcd();
            bunwari1 = mosDairitenLst.get(0).getBunwari();

        } else {
            BzGetTuukeiBunwari bzGetTuukeiBunwari = SWAKInjector.getInstance(BzGetTuukeiBunwari.class);
            bzGetTuukeiBunwari.exec(mosDairitenLst.get(0).getTratkiagcd(),
                mosDairitenLst.get(0).getOyadrtencd(),
                mosDairitenLst.get(0).getBunwari(),
                mosDairitenLst.get(1).getTratkiagcd(),
                mosDairitenLst.get(1).getOyadrtencd(),
                mosDairitenLst.get(1).getBunwari(),
                pSyoriCTL.getSrsyoriymd().getBizDateYM(),
                syouhnZokusei.getDrtsyouhinsikibetukbn(),
                mosKihon.getHrkkaisuu(),
                C_DiritenplannmKbn.BLNK);

            if (C_ErrorKbn.ERROR.eq(bzGetTuukeiBunwari.getErrorKbn())) {
                setMisslistParam(
                    pDataNo,
                    "通計用代理店分担割合取得が実行できませんでした。",
                    C_Dbhanei.NONE,
                    pSyoriCTL.getSyono());

                return C_ErrorKbn.ERROR;
            }

            dairitencd1 = bzGetTuukeiBunwari.getDrtencd1();
            bunwari1 = bzGetTuukeiBunwari.getBuntanWariai1();
            dairitencd2 = bzGetTuukeiBunwari.getDrtencd2();
            bunwari2 = bzGetTuukeiBunwari.getBuntanWariai2();
            kanrisosikicd2 = mosDairitenLst.get(1).getDrtenkanrisosikicd();
        }

        BT_IdouKhBosyuudr idouKhBosyuudr = tjtIdouNyKh.createIdouKhBosyuudr();
        idouKhBosyuudr.setDairitencd1(dairitencd1);
        idouKhBosyuudr.setBunwari1(bunwari1);
        idouKhBosyuudr.setDairitencd2(dairitencd2);
        idouKhBosyuudr.setBunwari2(bunwari2);
        idouKhBosyuudr.setKanrisosikicd1(mosDairitenLst.get(0).getDrtenkanrisosikicd());
        idouKhBosyuudr.setKanrisosikicd2(kanrisosikicd2);

        BizPropertyInitializer.initialize(idouKhBosyuudr);

        return C_ErrorKbn.OK;

    }

    private void editItekiToukeiInfo(HT_SyoriCTL pSyoriCTL, MultipleEntityInserter pMultipleEntityInserter) {

        HT_DakuhiKettei dakuhiKettei = sinkeiyakuDomManager.getDakuhiKetteiByMosnoDakuhiktbunruikbnMaxDakuhiktrenno(
            pSyoriCTL.getMosno(), C_DakuhiktbunruiKbn.DAKUHIKETTEI);

        IT_ItekiToukeiInfo itekiToukeiInfo = new IT_ItekiToukeiInfo();

        itekiToukeiInfo.setSyono(pSyoriCTL.getSyono());
        itekiToukeiInfo.setKetkekkacd(dakuhiKettei.getKetkekkacd());
        itekiToukeiInfo.setPalketsyacd(dakuhiKettei.getPalketsyacd());

        BizPropertyInitializer.initialize(itekiToukeiInfo);

        pMultipleEntityInserter.add(itekiToukeiInfo);
    }

    private void editKhLincKihon(HT_SyoriCTL pSyoriCTL, MultipleEntityInserter pMultipleEntityInserter){

        HT_SkLincTourokuInfo skLincTourokuInfo = pSyoriCTL.getSkLincTourokuInfo();

        IT_KhLincKihon khLincKihon = kykKihon.createKhLincKihon();

        khLincKihon.setKykymd(mosKihon.getKykymd());
        khLincKihon.setLinckanyuusyano(skLincTourokuInfo.getKanyuusyano());
        khLincKihon.setGyoumuKousinKinou(kinouId);
        khLincKihon.setGyoumuKousinsyaId(kosId);
        khLincKihon.setGyoumuKousinTime(sysTime);

        BizPropertyInitializer.initialize(khLincKihon);
    }

    private void editTable(EditKoujyoSyoumeiParam pEditKoujyoSyoumeiParam) {

        List<IT_KykSyouhn>  sykSyouhnSLst = null;
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        List<IT_KykSyouhn> sykSyouhnTLst = null;
        IT_SyouhnTokujou syouhnTokujou = null;
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = null;
        IT_KykUkt kykUktSbo = null;
        IT_KykUkt kykUktSti = null;
        List<IT_KykDairiten>  kykDairitenLst = null;
        List<IT_KykUkt> kykUktSbouktrhtLst = null;
        IT_KykUkt kykUktNenkinuktrht = null;
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = null;
        IT_KykUkt kykUktKyksya = null;

        sykSyouhnSLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        sykSyouhnTLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        syouhnTokujou =  kykKihon.getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
            C_SyutkKbn.SYU,sykSyouhnSLst.get(0).getSyouhncd(),
            sykSyouhnSLst.get(0).getSyouhnsdno(),sykSyouhnSLst.get(0).getKyksyouhnrenno());

        kykSya =  kykKihon.getKykSya();

        hhknSya = kykKihon.getHhknSya();

        if (kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBHENKANUKT).size() > 0){
            kykUktSbo=kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBHENKANUKT).get(0);
        }

        if (kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.STDRSK).size() > 0){
            kykUktSti = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.STDRSK).get(0);
        }

        kykUktSbouktrhtLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        kykDairitenLst = kykKihon.getKykDairitens();

        if (kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.NKUKT).size() > 0){
            kykUktNenkinuktrht = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.NKUKT).get(0);
        }

        nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        if (kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.KYKDRN).size() > 0){
            kykUktKyksya = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.KYKDRN).get(0);
        }

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);

        editHokenSyoukenParam.setCalckijyunYMD(mosKihon.getKykymd());
        editHokenSyoukenParam.setTrkkzk1thkk(C_TyokusouhtkekKbn.BLNK);
        editHokenSyoukenParam.setTrkkzk2thkk(C_TyokusouhtkekKbn.BLNK);

        C_HassouKbn hassouKbn = C_HassouKbn.BLNK;

        if (C_UmuKbn.ARI.eq(mosKihon.getSyosisyatodokeumukbn())) {
            hassouKbn = C_HassouKbn.HONSYAKAISOU;
        }else {
            hassouKbn = C_HassouKbn.TYOKUSOU;
        }

        KhTyokusouHantei khTyokusouHantei = SWAKInjector.getInstance(KhTyokusouHantei.class);
        C_TuutisakuseitaisyouKbn tuutisakuseitaisyouKbn = C_TuutisakuseitaisyouKbn.BLNK;
        List<TyokusouTaisyouBean> tyokusouTaisyouBeanList = new ArrayList<>();

        if (BizDateUtil.compareYmd(mosKihon.getMosymd(), BizDate.valueOf("20201001")) == BizDateUtil.COMPARE_GREATER ||
            BizDateUtil.compareYmd(mosKihon.getMosymd(), BizDate.valueOf("20201001")) == BizDateUtil.COMPARE_EQUAL) {

            List<IT_TrkKzk> trkKzkList = kykKihon.getTrkKzks();

            for (IT_TrkKzk trkKzk : trkKzkList) {

                TrkkzkTyokusouhtBean trkkzkTyokusouhtBean = SWAKInjector.getInstance(TrkkzkTyokusouhtBean.class);
                trkkzkTyokusouhtBean.setKijyunymd(mosKihon.getKykymd());
                trkkzkTyokusouhtBean.setKykseiymd(kykSya.getKykseiymd());
                trkkzkTyokusouhtBean.setTrkkzktsindousiteikbn(trkKzk.getTrkkzktsindousiteikbn());

                C_TyokusouhtkekKbn tyokusouhtkekKbn = khTyokusouHantei.execTrkkzkTyokusouHantei(trkkzkTyokusouhtBean);

                if (C_TyokusouhtkekKbn.TYOKUSOUTSY.eq(tyokusouhtkekKbn)) {

                    if (C_TrkKzkKbn.TRKKZK1.eq(trkKzk.getTrkkzkkbn())) {

                        tuutisakuseitaisyouKbn = C_TuutisakuseitaisyouKbn.TRKKZK1;
                        editHokenSyoukenParam.setTrkkzk1thkk(C_TyokusouhtkekKbn.TYOKUSOUTSY);

                    }

                    if (C_TrkKzkKbn.TRKKZK2.eq(trkKzk.getTrkkzkkbn())) {

                        tuutisakuseitaisyouKbn = C_TuutisakuseitaisyouKbn.TRKKZK2;
                        editHokenSyoukenParam.setTrkkzk2thkk(C_TyokusouhtkekKbn.TYOKUSOUTSY);
                    }

                    TyokusouTaisyouBean tyokusouTaisyouBean = SWAKInjector.getInstance(TyokusouTaisyouBean.class);
                    tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(tuutisakuseitaisyouKbn);
                    tyokusouTaisyouBean.setNmkj(trkKzk.getTrkkzknmkj());
                    tyokusouTaisyouBean.setSeiYmd(trkKzk.getTrkkzkseiymd());
                    tyokusouTaisyouBean.setYno(trkKzk.getTrkkzkyno());
                    tyokusouTaisyouBean.setAdr1kj(trkKzk.getTrkkzkadr1kj());
                    tyokusouTaisyouBean.setAdr2kj(trkKzk.getTrkkzkadr2kj());
                    tyokusouTaisyouBean.setAdr3kj(trkKzk.getTrkkzkadr3kj());
                    tyokusouTaisyouBean.setTelno(trkKzk.getTrkkzktelno());

                    tyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

                }

                else {

                    if (C_TrkKzkKbn.TRKKZK1.eq(trkKzk.getTrkkzkkbn())) {

                        editHokenSyoukenParam.setTrkkzk1thkk(C_TyokusouhtkekKbn.TYOKUSOUTSYGAI);
                    }

                    if (C_TrkKzkKbn.TRKKZK2.eq(trkKzk.getTrkkzkkbn())) {

                        editHokenSyoukenParam.setTrkkzk2thkk(C_TyokusouhtkekKbn.TYOKUSOUTSYGAI);
                    }
                }
            }
        }

        EditSyoukenTbl editSyoukenTbl = SWAKInjector.getInstance(EditSyoukenTbl.class);
        editSyoukenTbl.editTBL(
            khozenCommonParam,
            kykKihon,
            sykSyouhnSLst,
            kykSonotaTkyk,
            sykSyouhnTLst,
            syouhnTokujou,
            kykSya,
            hhknSya,
            kykUktSbo,
            kykUktSti,
            kykDairitenLst,
            null,
            kykUktSbouktrhtLst,
            nyknJissekiRirekiLst,
            editHokenSyoukenParam,
            syoriYmd,
            C_SinsaihkKbn.SIN,
            C_TetudukisyuKbn.BLNK,
            hassouKbn);

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(syoriYmd);
        hassouKbn = hokenSyouken.getHassoukbn();

        if (!C_Tkhukaumu.HUKA.eq(mosKihon.getKjnnkpzeitekitkhukakbn())
            && ((C_Hrkkaisuu.TUKI.eq(mosKihon.getHrkkaisuu())
                && mosKihon.getKykymd().getMonth() >= 9
                && !C_YennykntksyuruiKbn.PYENHRKM_GKHENDOU.eq(kykSonotaTkyk.getYennyknsyuruikbn()))
                || C_Hrkkaisuu.HALFY.eq(mosKihon.getHrkkaisuu())
                || C_Hrkkaisuu.NEN.eq(mosKihon.getHrkkaisuu())
                || C_Hrkkaisuu.ITIJI.eq(mosKihon.getHrkkaisuu()))) {

            EditKoujyoSyoumeiTbl editKoujyoSyoumeiTbl = SWAKInjector.getInstance(EditKoujyoSyoumeiTbl.class);
            editKoujyoSyoumeiTbl.editTBL(khozenCommonParam,
                kykKihon,
                sykSyouhnSLst,
                kykSya,
                kykUktSbouktrhtLst,
                kykUktNenkinuktrht,
                kykDairitenLst,
                null,
                pEditKoujyoSyoumeiParam,
                hassouKbn,
                syoriYmd,
                1);
        }

        if (tyokusouTaisyouBeanList.size() > 0) {

            if ("2".equals(hokenSyouken.getSagyoukbn())) {

                hassouKbn = C_HassouKbn.TYOKUSOU;
            }

            EditSkYouTtdkKanryouTbl editSkYouTtdkKanryouTbl = SWAKInjector.getInstance(EditSkYouTtdkKanryouTbl.class);
            editSkYouTtdkKanryouTbl.exec(khozenCommonParam,
                kykKihon,
                sykSyouhnSLst,
                kykSya,
                kykSonotaTkyk,
                kykUktKyksya,
                kykUktSti,
                syoriYmd,
                hassouKbn,
                tyokusouTaisyouBeanList);
        }
    }

    private void editSyoriCTL(HT_SyoriCTL pSyoriCTL) {

        pSyoriCTL.setMfrenflg(C_Mfrenflg.SUMI );
        pSyoriCTL.setMfrenymd(syoriYmd);
    }

    private void setMisslistParam(int pDataNo, String pMsg, C_Dbhanei pDBHaneiKbn, String pSyono) {

        seqNo++;
        EditKhMisslstParam editKhMisslstParam = SWAKInjector.getInstance(EditKhMisslstParam.class);
        editKhMisslstParam.setDataNo(pDataNo);
        editKhMisslstParam.setSeqNo(seqNo);
        editKhMisslstParam.setMisslistMsg(pMsg);
        editKhMisslstParam.setDBhaneikbn(pDBHaneiKbn);
        editKhMisslstParam.setSyoNo(pSyono);

        editKhMisslstParamLst.add(editKhMisslstParam);
    }

    private C_ErrorKbn editKhSisuurendoTmttkn(HT_SyoriCTL pSyoriCTL,
        MultipleEntityInserter pMultipleEntityInserter, int pDataNo, HT_MosSyouhn pMosSyouhn) {

        BizCurrency teiritutmttkngk;
        BizCurrency sisuurendoutmttkngk;
        KeisanSisuuRendouNkKykTmttkn keisanSisuuRendouNkKykTmttkn =
            SWAKInjector.getInstance(KeisanSisuuRendouNkKykTmttkn.class);

        BizNumber kykjisisuurendourate = BizNumber.ZERO;

        if (!C_TumitatekinHaibunWariKbn.BLNK.eq(mosKihon.getSisuuhaibunwarikbn())) {
            kykjisisuurendourate = BizNumber.valueOf(Integer.valueOf(mosKihon.getSisuuhaibunwarikbn().getValue()));
        }

        C_ErrorKbn errorKbn = keisanSisuuRendouNkKykTmttkn.exec(
            mosKihon.getKyktuukasyu(),
            pMosSyouhn.getSyutkp(),
            kykjisisuurendourate
            );

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            setMisslistParam(
                pDataNo,
                "指数連動年金契約時積立金計算が実行できませんでした。",
                C_Dbhanei.NONE,
                pSyoriCTL.getSyono());

            return C_ErrorKbn.ERROR;

        }
        teiritutmttkngk = keisanSisuuRendouNkKykTmttkn.getTeiritutmttkngk();
        sisuurendoutmttkngk = keisanSisuuRendouNkKykTmttkn.getSisuurendoutmttkngk();
        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = new IT_KhSisuurendoTmttkn(
            pSyoriCTL.getSyono(), mosKihon.getKykymd().getBizDateYM(), 1);

        khSisuurendoTmttkn.setTmttknkouryokukaisiymd(mosKihon.getKykymd());
        khSisuurendoTmttkn.setTeiritutmttkngk(teiritutmttkngk);
        khSisuurendoTmttkn.setSisuurendoutmttkngk(sisuurendoutmttkngk);
        khSisuurendoTmttkn.setSisuuupritu(BizNumber.ZERO);
        khSisuurendoTmttkn.setTmttknzoukaritu(BizNumber.ZERO);
        khSisuurendoTmttkn.setTmttknhaneitmmshanteiymd(null);
        khSisuurendoTmttkn.setTmttknhaneisisuu(BizNumber.ZERO);
        khSisuurendoTmttkn.setGyoumuKousinKinou(kinouId);
        khSisuurendoTmttkn.setGyoumuKousinsyaId(kosId);
        khSisuurendoTmttkn.setGyoumuKousinTime(sysTime);

        BizPropertyInitializer.initialize(khSisuurendoTmttkn);

        pMultipleEntityInserter.add(khSisuurendoTmttkn);

        return C_ErrorKbn.OK;
    }

    private void editItZennou(String pDenrenno, BizDate pDenymd, BizCurrency pZennounyuukinkgkrstk,
        BizDate pRyosyuKwsratekjYmd, BizNumber pRyosyukwsrate, BizCurrency pYenkansannyknkingkZennou,
        BizDate pYenkansantkykwsrateymdZennou, BizNumber pYenkansantkykwsrateZennou) {

        if(C_UmuKbn.ARI.eq(mosKihon.getZennoumousideumu())) {

            IT_Zennou zennou =ansyuKihon.createZennou();

            zennou.setZennoukaisiymd(mosKihon.getKykymd().addYears(1).getRekijyou());
            zennou.setRenno(1);
            zennou.setZennounyuukinsyoriymd(nyuukinInfoByMosnoZenhnknkbnSrgonyknumuBean.getNyksyoriymd());
            zennou.setZennounyuukindenno(pDenrenno);
            zennou.setZennounyuukindenymd(pDenymd);
            zennou.setRyosyuymd(mosKihon.getKykymd());
            zennou.setZennoukikan(String.valueOf(mosKihon.getZnnkai()));
            zennou.setZennounyuukinkgk(mosKihon.getZennoup());
            zennou.setZennoujihrkp(mosKihon.getZennoujyuutoup());
            zennou.setZennounyuukinkgkrstk(pZennounyuukinkgkrstk);
            zennou.setRstuukasyu(mosKihon.getHrktuukasyu());
            zennou.setRyosyukwsratekjymd(pRyosyuKwsratekjYmd);
            zennou.setRyosyukwsrate(pRyosyukwsrate);
            zennou.setZennouseisankbn(C_ZennouSeisanKbn.MISEISAN);
            zennou.setYenkansannyknkingk(pYenkansannyknkingkZennou);
            zennou.setYenkansantkykwsrateymd(pYenkansantkykwsrateymdZennou);
            zennou.setYenkansantkykwsrate(pYenkansantkykwsrateZennou);
            zennou.setAnnaisaikaiym(mosKihon.getKykymd().getBizDateYM().addYears(1).addYears(mosKihon.getZnnkai()));
            zennou.setGyoumuKousinKinou(kinouId);
            zennou.setGyoumuKousinsyaId(kosId);
            zennou.setGyoumuKousinTime(sysTime);
            zennou.setTyakkinymd(nyuukinInfoByMosnoZenhnknkbnSrgonyknumuBean.getTyakkinymdMin());

            SetKjsmyouZennouInfo setKjsmyouZennouInfo = SWAKInjector.getInstance(SetKjsmyouZennouInfo.class);

            setKjsmyouZennouInfo.setYenkaknsnKijyunymd(pYenkansantkykwsrateymdZennou);
            setKjsmyouZennouInfo.setYenknsnKawaseRate(pYenkansantkykwsrateZennou);

            C_ErrorKbn errorKbn = setKjsmyouZennouInfo.exec(
                mosKihon.getKykymd(),
                String.valueOf(mosKihon.getZnnkai()+1) ,
                mosKihon.getMoszennoupsyokaiari(),
                mosKihon.getHrkkaisuu(),
                mosKihon.getHeijyunp(),
                C_UmuKbn.ARI);

            if(C_ErrorKbn.OK.eq(errorKbn)){

                zennou.setKjsmyouzennoukaisiymd(setKjsmyouZennouInfo.getKjsmyouzennoukaisiymd());
                zennou.setKjsmyouzennoukikanm(setKjsmyouZennouInfo.getKjsmyouzennoukikanm());
                zennou.setKjsmyouzennounyuukinkgk(setKjsmyouZennouInfo.getKjsmyouzennounyuukinkgk());
                zennou.setKjsmyouyenkansanrateymd(setKjsmyouZennouInfo.getKjsmyouenknsnkijyunymd());
                zennou.setKjsmyouyenkansankwsrate(setKjsmyouZennouInfo.getKjsmyouenknsnrate());
            }

            BizPropertyInitializer.initialize(zennou);
        }
    }

    private void editUketoriKouza(HT_UketoriKouzaJyouhou pUketoriKouzaJyouhou, HT_Uketorinin pUketorinin,
        IT_KykUkt pKykUkt) {

        IT_UketoriKouza uketoriKouza = pKykUkt.createUketoriKouza();
        uketoriKouza.setUktsyukbn(C_UktsyuKbn.TKSHKUKT);
        uketoriKouza.setUktsyurenno(pUketorinin.getUktsyurenno());
        uketoriKouza.setKzsyuruikbn(pUketoriKouzaJyouhou.getKzsyuruikbn());
        uketoriKouza.setBankcd(pUketoriKouzaJyouhou.getBankcd());
        uketoriKouza.setSitencd(pUketoriKouzaJyouhou.getSitencd());
        uketoriKouza.setYokinkbn(pUketoriKouzaJyouhou.getYokinkbn());
        uketoriKouza.setKouzano(pUketoriKouzaJyouhou.getKouzano());

        if (C_KzkykdouKbn.DOUITU.eq(pUketoriKouzaJyouhou.getKzkykdoukbn())) {
            if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {
                uketoriKouza.setKzmeiginmkn(mosKihon.getHhknnmkn());
            }
            else if (C_KykKbn.KEIHI_BETU.eq(mosKihon.getKykkbn())) {
                uketoriKouza.setKzmeiginmkn(mosKihon.getKyknmkn());
            }
        }
        else if (C_KzkykdouKbn.SITEI.eq(pUketoriKouzaJyouhou.getKzkykdoukbn())) {
            uketoriKouza.setKzmeiginmkn(pUketoriKouzaJyouhou.getKzmeiginmkn());
        }

        uketoriKouza.setGyoumuKousinKinou(kinouId);
        uketoriKouza.setGyoumuKousinsyaId(kosId);
        uketoriKouza.setGyoumuKousinTime(sysTime);

        BizPropertyInitializer.initialize(uketoriKouza);
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }
}
