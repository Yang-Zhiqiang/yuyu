package yuyu.common.sinkeiyaku.moschk;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BzGetImageProps;
import yuyu.common.biz.bzcommon.BzGetImagePropsBean;
import yuyu.common.biz.bzcommon.BzGetImagePropsInBean;
import yuyu.common.biz.bzcommon.BzGetImagePropsOutBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.HanteiTyotikuseihokenBean;
import yuyu.common.hozen.khcommon.SetManryoubi;
import yuyu.common.hozen.khcommon.SetTyotikuseihokenhyouji;
import yuyu.common.sinkeiyaku.skcommon.GetKiteiCheckYenkansangk;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_AeoisnsiKbn;
import yuyu.def.classification.C_BikkjnssinfoKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FatcasnsiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_ImusateikaniyhKbn;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_KijiKbn;
import yuyu.def.classification.C_KknsmnKbn;
import yuyu.def.classification.C_Knkysatei1jiyhKbn;
import yuyu.def.classification.C_Knkysatei2jiyhKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_KykkakkekKbn;
import yuyu.def.classification.C_KzhuritourokuhouKbn;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_LinckknnjkKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_MosUktkErrKbn;
import yuyu.def.classification.C_MostenkenyhKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_NensyuuKbn;
import yuyu.def.classification.C_PplessrendoucreditkousouKbn;
import yuyu.def.classification.C_PplessrendoukouhurikousouKbn;
import yuyu.def.classification.C_PtratkituukasiteiKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SpKeisanKahiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Taihntmdr;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.HT_HenteiRireki;
import yuyu.def.db.entity.HT_ImusateiRireki;
import yuyu.def.db.entity.HT_KmTsRireki;
import yuyu.def.db.entity.HT_Kokutisyo;
import yuyu.def.db.entity.HT_KouzaJyouhou;
import yuyu.def.db.entity.HT_KykKak;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_MosTrkKzk;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Uketorinin;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.sorter.SortHT_ImusateiRireki;
import yuyu.def.sinkeiyaku.sorter.SortHT_KykKak;

/**
 * 新契約 申込内容チェック ハンド査定・決定判定
 */
public class HandSateiKetteiHantei {

    private static final BizCurrency HANTIEKIJYUNS = BizCurrency.valueOf(20000000, BizCurrencyTypes.YEN);

    private static final BizCurrency HANTIETSNSBS1 = BizCurrency.valueOf(30000000, BizCurrencyTypes.YEN);

    private static final BizCurrency HANTIETSNSBS2 = BizCurrency.valueOf(50000000, BizCurrencyTypes.YEN);

    private static final String SYOKUGYOUCDBUNNRUIFUNOU = "990";

    private static final String SYOKUGYOUCDSAIKANOMUSYOKUARUHOITO = "930";

    private static final String SYOKUGYOUCDGAKUSEISHUFUKODOMO = "910";

    private static final BizCurrency TSNKETSIBOUSHONKEN_HANTIEKIJYUN =
        BizCurrency.valueOf(5000000, BizCurrencyTypes.YEN);

    private C_MostenkenyhKbn  mosTenken1jiyhKbn = C_MostenkenyhKbn.HUYOU;

    private C_MostenkenyhKbn mosTenken2jiyhKbn = C_MostenkenyhKbn.HUYOU;

    private C_Knkysatei1jiyhKbn  knkySatei1jiyhKbn = C_Knkysatei1jiyhKbn.HUYOU;

    private C_Knkysatei2jiyhKbn  knkySatei2jiyhKbn = C_Knkysatei2jiyhKbn.HUYOU;

    private C_ImusateikaniyhKbn  imuSateikaniyhKbn = C_ImusateikaniyhKbn.HUYOU;

    private List<String> mosTenkenMsgIdList = new ArrayList<>();

    private List<String> knkySateiSijiMsgIdList = new ArrayList<>();

    private List<String> imuSateiSijiMsgIdList = new ArrayList<>();

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private SortHT_KykKak sortHT_KykKak;

    @Inject
    private SetTyotikuseihokenhyouji setTyotikuseihokenhyouji;

    @Inject
    private HanteiTyotikuseihokenBean hanteiTyotikuseihokenBean;

    @Inject
    private SetManryoubi setManryoubi;

    @Inject
    private SetHubiMsg setHubiMsg;

    public HandSateiKetteiHantei() {
        super();
    }

    public C_MostenkenyhKbn getMostenken1yhKbn() {
        return this.mosTenken1jiyhKbn;
    }

    public void setMostenken1yhKbn(C_MostenkenyhKbn pMosTenken1jiyhKbn) {
        this.mosTenken1jiyhKbn = pMosTenken1jiyhKbn;
    }

    public C_MostenkenyhKbn getMostenken2yhKbn() {
        return this.mosTenken2jiyhKbn;
    }

    public void setMostenken2yhKbn(C_MostenkenyhKbn pMosTenken2jiyhKbn) {
        this.mosTenken2jiyhKbn = pMosTenken2jiyhKbn;
    }

    public C_Knkysatei1jiyhKbn getKnkysatei1jiyhKbn() {
        return this.knkySatei1jiyhKbn;
    }

    public void setKnkysatei1jiyhKbn(C_Knkysatei1jiyhKbn pKnkySatei1jiyhKbn) {
        this.knkySatei1jiyhKbn = pKnkySatei1jiyhKbn;
    }

    public C_Knkysatei2jiyhKbn getKnkySatei2jiYhKbn() {
        return this.knkySatei2jiyhKbn;
    }

    public void setKnkySatei2jiYhKbn(C_Knkysatei2jiyhKbn pKnkySatei2jiyhKbn) {
        this.knkySatei2jiyhKbn = pKnkySatei2jiyhKbn;
    }

    public C_ImusateikaniyhKbn getImuSateiKaniYhKbn() {
        return this.imuSateikaniyhKbn;
    }

    public void setImuSateiKaniYhKbn(C_ImusateikaniyhKbn pImuSateikaniyhKbn) {
        this.imuSateikaniyhKbn = pImuSateikaniyhKbn;
    }

    public List<String> getMosTenkenSijiMsgIdList() {
        return this.mosTenkenMsgIdList;
    }

    public void setMosTenkenSijiMsgIdList(List<String> pMosTenkenMsgIdList) {
        this.mosTenkenMsgIdList = pMosTenkenMsgIdList;
    }

    public List<String> getKnkySateiSijiMsgIdList() {
        return this.knkySateiSijiMsgIdList;
    }

    public void setKnkySateiSijiMsgIdList(List<String> pKnkySateiSijiMsgIdList) {
        this.knkySateiSijiMsgIdList = pKnkySateiSijiMsgIdList;
    }

    public List<String> getImuSateiSijiMsgIdList() {
        return this.imuSateiSijiMsgIdList;
    }

    public void setImuSateiSijiMsgIdList(List<String> pImuSateiSijiMsgIdList) {
        this.imuSateiSijiMsgIdList = pImuSateiSijiMsgIdList;
    }

    public void exec(MosnaiCheckParam pMP) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ ハンド査定・決定判定 開始");
        }

        HT_MosKihon mosKihon = pMP.getDataSyoriControl().getMosKihon();
        List<HT_MosSyouhn> mosSyouhnLst = pMP.getDataSyoriControl().getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        String mosNo = pMP.getDataSyoriControl().getMosno();
        if (mosSyouhnLst.size() != 1) {
            throw new CommonBizAppException("主契約申込商品件数異常 申込番号："+ mosNo);
        }
        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = pMP.getGyoumuKouteiInfo();
        HT_SyoriCTL syoriCtl = pMP.getDataSyoriControl();
        List<HT_HenteiRireki> henteiRirekiLst = syoriCtl.getHenteiRirekis();
        List<HT_KmTsRireki> kmTsRirekiLst = syoriCtl.getKmTsRirekis();
        String hhknSykgyCd = mosKihon.getHhknsykgycd();
        C_Tdk  kykTdk = mosKihon.getKyktdk();
        C_UktKbn uktKbn = C_UktKbn.BLNK;
        C_Tdk uktTdk = C_Tdk.BLNK;
        C_UmuKbn kktNrkUmu = syoriCtl.getKktnrkumu();
        C_MosUketukeKbn mosuketukeKbn = syoriCtl.getMosuketukekbn();
        C_UmuKbn kjmeigiHkhunouumuKbn = mosKihon.getKjmeigihkhunouumukbn();
        int sbUktnin = mosKihon.getSbuktnin();
        C_YouhiKbn youhiKbn = syoriCtl.getTktkhjnkakuninyouhikbn();
        C_MosUktkErrKbn mosUktkErrKbn = syoriCtl.getMosuktkerrkbn();
        C_FatcasnsiKbn fatcasnsiKbn = mosKihon.getFatcasnsikbn();
        C_AeoisnsiKbn aeoisnsiKbn = mosKihon.getAeoisnsikbn();
        C_BikkjnssinfoKbn bikkjnSsinfoKbn = mosKihon.getBikkjnssinfokbn();
        int hhkNnen = mosKihon.getHhknnen();
        int kykNen = mosKihon.getKyknen();
        C_KykKbn kykKbn = mosKihon.getKykkbn();
        C_Taihntmdr taihntKekka = C_Taihntmdr.CHK_NONE;
        C_NensyuuKbn nensyuuKbn = mosKihon.getHhknnensyuukbn();
        C_SntkhouKbn sntkhouKbn = mosKihon.getSntkhoukbn();
        C_Tuukasyu tuukaSyu = mosKihon.getKyktuukasyu();
        BizDate mosYmd = mosKihon.getMosymd();
        C_Hrkkaisuu hrkkaisuu = mosKihon.getHrkkaisuu();
        List<HT_KykKak> kykkakList = sortHT_KykKak.OrderHT_KykKakByPkDesc(syoriCtl.getKykKaks());
        boolean hhknSinsntkhnsyKaihiFlg = false;
        boolean kykSinsntkhnsyKaihiFlg = false;
        boolean uktSinsntkhnsyKaihiFlg = false;
        boolean kykDairiSinsntkhnsyKaihiFlg = false;
        boolean hhknDairiSinsntkhnsyKaihiFlg = false;
        C_PplessrendoukouhurikousouKbn pplessrendoukouhurikousouKbn = mosKihon.getPplsrendoukouhurikousoukbn();
        C_PplessrendoucreditkousouKbn pplessrendoucreditkousouKbn = mosKihon.getPplessrendoucreditkousoukbn();
        C_Hrkkeiro hrkkeiro = mosKihon.getHrkkeiro();
        C_UmuKbn heijyunbaraiumu = syouhnZokusei.getHeijyunbaraiumu();
        C_UmuKbn syuusinhknumu = syouhnZokusei.getSyuusinhknumu();
        C_UmuKbn nkhknumu = syouhnZokusei.getNkhknumu();
        GetKiteiCheckYenkansangk getKiteiCheckYenkansangk =
            SWAKInjector.getInstance(GetKiteiCheckYenkansangk.class);
        BizCurrency seitoukihons = mosSyouhn.getSeitoukihons();
        HT_KouzaJyouhou kouzaJyouhou = syoriCtl.getKouzaJyouhou();
        C_KzhuritourokuhouKbn kzhuritourokuhouKbn = C_KzhuritourokuhouKbn.BLNK;
        C_UmuKbn daihituUmukbn = mosKihon.getDaihituumukbn();
        setTyotikuseihokenhyouji = SWAKInjector.getInstance(SetTyotikuseihokenhyouji.class);
        hanteiTyotikuseihokenBean = SWAKInjector.getInstance(HanteiTyotikuseihokenBean.class);
        setManryoubi = SWAKInjector.getInstance(SetManryoubi.class);
        boolean houteityotkseiFlag = false;
        boolean hCvObjectFlag = false;
        C_LincjkKbn lincjkkbn = syoriCtl.getLincjkkbn();
        C_LinckknnjkKbn linckknnjkkbn = syoriCtl.getLinckknnjkkbn();
        C_ErrorKbn tyotkhknhyjResultKbn = C_ErrorKbn.OK;
        C_UmuKbn houteityotkhknhyj = C_UmuKbn.NONE;
        C_UmuKbn tyotkhknhyj = C_UmuKbn.NONE;

        if (C_UmuKbn.ARI.eq(pMP.getHhknGaikokupepsumukbn()) ||
            C_UmuKbn.ARI.eq(pMP.getKykGaikokupepsumukbn())  ||
            C_UmuKbn.ARI.eq(pMP.getUktGaikokupepsumukbn())  ||
            C_UmuKbn.ARI.eq(pMP.getKykDairiGaikokupepsumukbn()) ||
            C_UmuKbn.ARI.eq(pMP.getHhknDairiGaikokupepsumukbn())) {

            if (C_UmuKbn.ARI.eq(syoriCtl.getKthhbkbn()) &&
                C_SpKeisanKahiKbn.SPKEISANHUKA.eq(pMP.getKthjiSpKeisanKahiKbn())) {

                tyotkhknhyjResultKbn =  C_ErrorKbn.ERROR;
            }

            else{

                boolean tuujyouTratkiFlag = true;
                BizNumber yoteiriritu = BizNumber.ZERO;
                BizCurrency hokenryou = mosSyouhn.getHrktuukasyutkp();

                if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(syouhnZokusei.getPtratkituukasiteikbn()) &&
                    (!C_Hrkkaisuu.BLNK.eq(mosKihon.getHrkkaisuu())) &&
                    (!C_Hrkkaisuu.ITIJI.eq(mosKihon.getHrkkaisuu()))) {

                    tuujyouTratkiFlag = false;
                }

                if (tuujyouTratkiFlag == true) {

                    yoteiriritu = mosSyouhn.getYoteiriritu();

                    hokenryou = mosSyouhn.getSyutkp();
                }

                BizDate haraimanymd = setManryoubi.exec(mosKihon.getKykymd(), mosKihon.getHhknnen(), mosSyouhn.getHrkkkn(),
                    C_KknsmnKbn.valueOf(mosSyouhn.getHrkkknsmnkbn().toString()));

                hanteiTyotikuseihokenBean.setSyouhnCd(mosSyouhn.getSyouhncd());
                hanteiTyotikuseihokenBean.setSyouhnsdNo(mosSyouhn.getSyouhnsdno());
                hanteiTyotikuseihokenBean.setRyouritusdNo(mosSyouhn.getRyouritusdno());
                hanteiTyotikuseihokenBean.setYoteiriritu(yoteiriritu);
                hanteiTyotikuseihokenBean.setHrkkaisuu(mosKihon.getHrkkaisuu());
                hanteiTyotikuseihokenBean.setHknkknsmnkbn(mosSyouhn.getHknkknsmnkbn());
                hanteiTyotikuseihokenBean.setHrkkknsmnkbn(mosSyouhn.getHrkkknsmnkbn());
                hanteiTyotikuseihokenBean.setHrkkkn(mosSyouhn.getHrkkkn());
                hanteiTyotikuseihokenBean.setHknkkn(mosSyouhn.getHknkkn());
                hanteiTyotikuseihokenBean.setHhknnen(mosKihon.getHhknnen());
                hanteiTyotikuseihokenBean.setHhknsei(mosKihon.getHhknsei());
                hanteiTyotikuseihokenBean.setKihons(mosSyouhn.getSeitoukihons());
                hanteiTyotikuseihokenBean.setHokenryou(hokenryou);
                hanteiTyotikuseihokenBean.setKykymd(mosKihon.getKykymd());
                hanteiTyotikuseihokenBean.setKyktuukaSyu(mosKihon.getKyktuukasyu());
                hanteiTyotikuseihokenBean.setMosymd(mosKihon.getMosymd());
                hanteiTyotikuseihokenBean.setYoteirrthendohosyurrt(syouhnZokusei.getYoteirirituminhosyouritu());
                hanteiTyotikuseihokenBean.setHrkkeiro(mosKihon.getHrkkeiro());
                hanteiTyotikuseihokenBean.setHaraimanymd(haraimanymd);
                hanteiTyotikuseihokenBean.setTyotikuseihokenhyoujihanteiflag(true);
                hanteiTyotikuseihokenBean.setDai1hknkkn(mosSyouhn.getDai1hknkkn());

                tyotkhknhyjResultKbn = setTyotikuseihokenhyouji.hanteiTyotikuseihoken(hanteiTyotikuseihokenBean);
                houteityotkhknhyj = setTyotikuseihokenhyouji.getHouteityotkhknhyj();
                tyotkhknhyj = setTyotikuseihokenhyouji.getTyotkhknhyj();
            }

        }


        if (C_UmuKbn.ARI.eq(pMP.getHhknTratkityuiUmuKbnMr()) || C_UmuKbn.ARI.eq(pMP.getHhknSntkinfohnsyUmuKbnMr()) ||
            C_UmuKbn.ARI.eq(pMP.getHhknTratkityuiUmuKbnSignal()) || C_UmuKbn.ARI.eq(pMP.getHhknInfohnsyUmuKbnSignal())){

            hhknSinsntkhnsyKaihiFlg = true;
        }

        if (C_KykKbn.KEIHI_BETU.eq(kykKbn) &&
            (C_UmuKbn.ARI.eq(pMP.getKykTratkityuiUmuKbnMr()) || C_UmuKbn.ARI.eq(pMP.getKykSntkinfohnsyUmuKbnMr()) ||
                C_UmuKbn.ARI.eq(pMP.getKykTratkityuiUmuKbnSignal()) || C_UmuKbn.ARI.eq(pMP.getKykInfohnsyUmuKbnSignal()))) {

            kykSinsntkhnsyKaihiFlg = true;
        }

        if (C_UmuKbn.ARI.eq(pMP.getUktTratkityuiUmuKbnMr()) || C_UmuKbn.ARI.eq(pMP.getUktSntkinfohnsyUmuKbnMr()) ||
            C_UmuKbn.ARI.eq(pMP.getUktTratkityuiUmuKbnSignal()) || C_UmuKbn.ARI.eq(pMP.getUktInfohnsyUmuKbnSignal())) {

            uktSinsntkhnsyKaihiFlg = true;
        }

        if (C_UmuKbn.ARI.eq(pMP.getKykDairiTratkityuiUmuKbnMr()) || C_UmuKbn.ARI.eq(pMP.getKykDairiSntkinfohnsyUmuKbnMr()) ||
            C_UmuKbn.ARI.eq(pMP.getKykDairiTratkityuiUmuKbnSignal()) || C_UmuKbn.ARI.eq(pMP.getKykDairiInfohnsyUmuKbnSignal())) {

            kykDairiSinsntkhnsyKaihiFlg = true;
        }

        if (C_UmuKbn.ARI.eq(pMP.getHhknDairiTratkityuiUmuKbnMr()) || C_UmuKbn.ARI.eq(pMP.getHhknDairiSntkinfohnsyUmuKbnMr()) ||
            C_UmuKbn.ARI.eq(pMP.getHhknDairiTratkityuiUmuKbnSignal()) || C_UmuKbn.ARI.eq(pMP.getHhknDairiInfohnsyUmuKbnSignal())) {

            hhknDairiSinsntkhnsyKaihiFlg = true;
        }


        if (C_ErrorKbn.OK.eq(tyotkhknhyjResultKbn)) {

            if (C_UmuKbn.ARI.eq(houteityotkhknhyj)) {

                houteityotkseiFlag = true;
            }

            else if (C_UmuKbn.ARI.eq(tyotkhknhyj) ) {

                hCvObjectFlag = true;
            }

        }

        else {

            hCvObjectFlag = true;

            setHubiMsg.exec(C_KetsrhkosKbn.WARNING,
                "WHC1025" + " " + MessageUtil.getMessage(MessageId.WHC1025),
                pMP,
                C_TknKbn.NONE,
                C_MsgKbn.WARNING);
        }


        BzGetImageProps bzGetImageProps = SWAKInjector.getInstance(BzGetImageProps.class);
        BzGetImagePropsInBean bzGetImagePropsInBean = SWAKInjector.getInstance(BzGetImagePropsInBean.class);
        List<String> torikomiSyoruiCdLst = new ArrayList<String>();

        bzGetImagePropsInBean.setJimuTetuzukiCd(gyoumuKouteiInfo.getJimutetuzukicd());
        bzGetImagePropsInBean.setKouteiKanriId(gyoumuKouteiInfo.getKouteikanriid());

        BzGetImagePropsOutBean bzGetImagePropsOutBean = bzGetImageProps.exec(bzGetImagePropsInBean);

        if (bzGetImagePropsOutBean.getKekkaStatus().equals("0")) {
            List<BzGetImagePropsBean> bzGetImagePropsBeanLst = bzGetImagePropsOutBean.getBzGetImagePropsBeanLst();

            for (BzGetImagePropsBean bzGetImagePropsBean: bzGetImagePropsBeanLst) {
                torikomiSyoruiCdLst.add(bzGetImagePropsBean.getSyoruiCd().getValue());
            }
        }

        List<String> daisansyauktKnrnSyoruiLst = YuyuSinkeiyakuConfig.getInstance().getDaisansyauktKnrnSyoruiList();
        boolean daisansyauktKnrnSyoruiFlg = false;

        for (String daisansyauktKnrnSyorui: daisansyauktKnrnSyoruiLst) {
            if (torikomiSyoruiCdLst.contains(daisansyauktKnrnSyorui)) {
                daisansyauktKnrnSyoruiFlg = true;
                break;
            }
        }


        if (!C_MosUketukeKbn.PAPERLESS.eq(mosuketukeKbn)) {
            mosTenkenMsgIdList.add(MessageId.IHC1001);
            mosTenken1jiyhKbn = C_MostenkenyhKbn.YOU;
            mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;

            if (C_UmuKbn.ARI.eq(kjmeigiHkhunouumuKbn)) {
                mosTenkenMsgIdList.add(MessageId.IHC1002);
                mosTenken1jiyhKbn = C_MostenkenyhKbn.YOU;
                mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
            }

            if (torikomiSyoruiCdLst.contains(C_SyoruiCdKbn.SK_DAIHITUHOUKOKUSYO.getValue())) {
                mosTenkenMsgIdList.add(MessageId.IHC1079);
                mosTenken1jiyhKbn = C_MostenkenyhKbn.YOU;
                mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
            }
        }
        else if (C_MosUketukeKbn.PAPERLESS.eq(mosuketukeKbn)) {
            if (C_MosUktkErrKbn.PPLESSUKTKERROR.eq(mosUktkErrKbn)) {
                mosTenkenMsgIdList.add(MessageId.IHC1010);
                mosTenken1jiyhKbn = C_MostenkenyhKbn.YOU;
                mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
            }

            if (henteiRirekiLst.size() != 0 || kmTsRirekiLst.size() != 0) {
                mosTenkenMsgIdList.add(MessageId.IHC1051);
                mosTenken1jiyhKbn = C_MostenkenyhKbn.YOU;
                mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
            }

            if (C_UmuKbn.ARI.eq(pMP.getHhknTratkityuiUmuKbnMr()) || C_UmuKbn.ARI.eq(pMP.getHhknSntkinfohnsyUmuKbnMr())) {
                mosTenkenMsgIdList.add(MessageId.IHC1003);
                mosTenken1jiyhKbn = C_MostenkenyhKbn.YOU;
                mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
            }
            if (C_KykKbn.KEIHI_BETU.eq(kykKbn) &&
                (C_UmuKbn.ARI.eq(pMP.getKykTratkityuiUmuKbnMr()) || C_UmuKbn.ARI.eq(pMP.getKykSntkinfohnsyUmuKbnMr()))) {
                mosTenkenMsgIdList.add(MessageId.IHC1004);
                mosTenken1jiyhKbn = C_MostenkenyhKbn.YOU;
                mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
            }
            if (C_UmuKbn.ARI.eq(pMP.getUktTratkityuiUmuKbnMr()) || C_UmuKbn.ARI.eq(pMP.getUktSntkinfohnsyUmuKbnMr())) {
                mosTenkenMsgIdList.add(MessageId.IHC1005);
                mosTenken1jiyhKbn = C_MostenkenyhKbn.YOU;
                mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
            }
            if (C_UmuKbn.ARI.eq(pMP.getKykDairiTratkityuiUmuKbnMr()) || C_UmuKbn.ARI.eq(pMP.getKykDairiSntkinfohnsyUmuKbnMr())) {
                mosTenkenMsgIdList.add(MessageId.IHC1060);
                mosTenken1jiyhKbn = C_MostenkenyhKbn.YOU;
                mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
            }
            if (C_UmuKbn.ARI.eq(pMP.getHhknDairiTratkityuiUmuKbnMr()) || C_UmuKbn.ARI.eq(pMP.getHhknDairiSntkinfohnsyUmuKbnMr())) {
                mosTenkenMsgIdList.add(MessageId.IHC1059);
                mosTenken1jiyhKbn = C_MostenkenyhKbn.YOU;
                mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
            }

            if (C_UmuKbn.ARI.eq(pMP.getHhknSinsntkhnsyumukbn()) && !hhknSinsntkhnsyKaihiFlg) {
                mosTenkenMsgIdList.add(MessageId.IHC1042);
                mosTenken1jiyhKbn = C_MostenkenyhKbn.YOU;
                mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
            }
            if (C_KykKbn.KEIHI_BETU.eq(kykKbn) && C_UmuKbn.ARI.eq(pMP.getKykSinsntkhnsyumukbn()) && !kykSinsntkhnsyKaihiFlg) {
                mosTenkenMsgIdList.add(MessageId.IHC1043);
                mosTenken1jiyhKbn = C_MostenkenyhKbn.YOU;
                mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
            }
            if (C_UmuKbn.ARI.eq(pMP.getUktSinsntkhnsyumukbn()) && !uktSinsntkhnsyKaihiFlg) {
                mosTenkenMsgIdList.add(MessageId.IHC1044);
                mosTenken1jiyhKbn = C_MostenkenyhKbn.YOU;
                mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
            }
            if (C_UmuKbn.ARI.eq(pMP.getKykDairiSinsntkhnsyUmuKbn()) && !kykDairiSinsntkhnsyKaihiFlg) {
                mosTenkenMsgIdList.add(MessageId.IHC1068);
                mosTenken1jiyhKbn = C_MostenkenyhKbn.YOU;
                mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
            }
            if (C_UmuKbn.ARI.eq(pMP.getHhknDairiSinsntkhnsyUmuKbn()) && !hhknDairiSinsntkhnsyKaihiFlg) {
                mosTenkenMsgIdList.add(MessageId.IHC1067);
                mosTenken1jiyhKbn = C_MostenkenyhKbn.YOU;
                mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
            }

            if ((houteityotkseiFlag || hCvObjectFlag) &&
                C_UmuKbn.ARI.eq(pMP.getHhknGaikokupepsumukbn())) {
                mosTenkenMsgIdList.add(MessageId.IHC1056);
                mosTenken1jiyhKbn = C_MostenkenyhKbn.YOU;
                mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
            }
            if (C_KykKbn.KEIHI_BETU.eq(kykKbn) &&
                (houteityotkseiFlag || hCvObjectFlag) &&
                C_UmuKbn.ARI.eq(pMP.getKykGaikokupepsumukbn())) {
                mosTenkenMsgIdList.add(MessageId.IHC1057);
                mosTenken1jiyhKbn = C_MostenkenyhKbn.YOU;
                mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
            }
            if ((houteityotkseiFlag || hCvObjectFlag) &&
                C_UmuKbn.ARI.eq(pMP.getUktGaikokupepsumukbn())) {
                mosTenkenMsgIdList.add(MessageId.IHC1058);
                mosTenken1jiyhKbn = C_MostenkenyhKbn.YOU;
                mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
            }
            if ((houteityotkseiFlag || hCvObjectFlag) &&
                C_UmuKbn.ARI.eq(pMP.getKykDairiGaikokupepsumukbn())) {
                mosTenkenMsgIdList.add(MessageId.IHC1076);
                mosTenken1jiyhKbn = C_MostenkenyhKbn.YOU;
                mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
            }
            if ((houteityotkseiFlag || hCvObjectFlag) &&
                C_UmuKbn.ARI.eq(pMP.getHhknDairiGaikokupepsumukbn())) {
                mosTenkenMsgIdList.add(MessageId.IHC1075);
                mosTenken1jiyhKbn = C_MostenkenyhKbn.YOU;
                mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
            }

            if (sbUktnin >= 5) {
                mosTenkenMsgIdList.add(MessageId.IHC1006);
                mosTenken1jiyhKbn = C_MostenkenyhKbn.YOU;
                mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
            }

            if (C_Hrkkeiro.KOUHURI.eq(hrkkeiro)) {
                if (kouzaJyouhou != null) {
                    kzhuritourokuhouKbn = kouzaJyouhou.getKzhuritourokuhoukbn();
                }
                if (C_KzhuritourokuhouKbn.SYOMEN.eq(kzhuritourokuhouKbn) ||
                    (C_KzhuritourokuhouKbn.BLNK.eq(kzhuritourokuhouKbn) &&
                        !C_PplessrendoukouhurikousouKbn.NONE.eq(pplessrendoukouhurikousouKbn))) {
                    mosTenkenMsgIdList.add(MessageId.IHC1052);
                    mosTenken1jiyhKbn = C_MostenkenyhKbn.YOU;
                    mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
                }
            }

            if (!C_PplessrendoucreditkousouKbn.NONE.eq(pplessrendoucreditkousouKbn) &&
                C_Hrkkeiro.CREDIT.eq(hrkkeiro)) {
                mosTenkenMsgIdList.add(MessageId.IHC1052);
                mosTenken1jiyhKbn = C_MostenkenyhKbn.YOU;
                mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
            }

            if (C_KykKbn.KEIHI_DOUITU.eq(kykKbn) && hhkNnen < 20) {
                mosTenkenMsgIdList.add(MessageId.IHC1050);
                mosTenken1jiyhKbn = C_MostenkenyhKbn.YOU;
                mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;

            }

            if (C_KykKbn.KEIHI_BETU.eq(kykKbn) && (hhkNnen < 20 || kykNen < 20)) {
                mosTenkenMsgIdList.add(MessageId.IHC1050);
                mosTenken1jiyhKbn = C_MostenkenyhKbn.YOU;
                mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
            }

            if (C_KykKbn.KEIHI_BETU.eq(kykKbn)) {

                if (C_UmuKbn.ARI.eq(heijyunbaraiumu) && C_UmuKbn.ARI.eq(syuusinhknumu)) {
                    if (C_Tdk.MAGO.eq(kykTdk) || C_Tdk.KYDSM.eq(kykTdk) || C_Tdk.SONOTA.eq(kykTdk)) {
                        mosTenkenMsgIdList.add(MessageId.IHC1007);
                        mosTenken1jiyhKbn = C_MostenkenyhKbn.YOU;
                        mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
                    }
                }
                else {
                    if (C_Tdk.SONOTA.eq(kykTdk)) {
                        mosTenkenMsgIdList.add(MessageId.IHC1007);
                        mosTenken1jiyhKbn = C_MostenkenyhKbn.YOU;
                        mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
                    }
                }
            }

            if (C_UmuKbn.ARI.eq(kjmeigiHkhunouumuKbn)) {
                mosTenkenMsgIdList.add(MessageId.IHC1002);
                mosTenken1jiyhKbn = C_MostenkenyhKbn.YOU;
                mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
            }

            boolean skijunnHanteiKekka = SyouhinUtil.isHandSkijyunTaisyouHantei(syouhnZokusei.getSyouhncd());
            if (skijunnHanteiKekka) {
                if (SYOKUGYOUCDBUNNRUIFUNOU.equals(hhknSykgyCd)) {
                    SetHutuuSibouS setHutuuSibouS = SWAKInjector.getInstance(SetHutuuSibouS.class);
                    BizCurrency futuuSibouS = setHutuuSibouS.exec(pMP);

                    if (!C_Tuukasyu.JPY.eq(tuukaSyu)) {
                        futuuSibouS = getKiteiCheckYenkansangk.exec(mosYmd, futuuSibouS, tuukaSyu);
                    }
                    if (futuuSibouS != null && futuuSibouS.compareTo(HANTIEKIJYUNS) >= 0) {
                        mosTenkenMsgIdList.add(MessageId.IHC1008);
                        mosTenken1jiyhKbn = C_MostenkenyhKbn.YOU;
                        mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
                    }
                }
            }

            if (C_YouhiKbn.YOU.eq(youhiKbn)) {
                mosTenkenMsgIdList.add(MessageId.IHC1009);
                mosTenken1jiyhKbn = C_MostenkenyhKbn.YOU;
                mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
            }

            if (C_UmuKbn.ARI.eq(mosKihon.getHnnkakninhskjikouumukbn())
                || C_UmuKbn.ARI.eq(mosKihon.getHnnkakninhsktkjikouumukbn())) {
                mosTenkenMsgIdList.add(MessageId.IHC1036);
                mosTenken1jiyhKbn = C_MostenkenyhKbn.YOU;
                mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
            }
            if (C_UmuKbn.ARI.eq(mosKihon.getSkskakninhsktkjikouumukbn())) {
                mosTenkenMsgIdList.add(MessageId.IHC1037);
                mosTenken1jiyhKbn = C_MostenkenyhKbn.YOU;
                mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
            }

            if (C_UmuKbn.ARI.eq(mosKihon.getIkokakninsyotokkijkumu())) {
                mosTenkenMsgIdList.add(MessageId.IHC1041);
                mosTenken1jiyhKbn = C_MostenkenyhKbn.YOU;
                mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
            }

            if (C_UmuKbn.ARI.eq(mosKihon.getTrtkhoukokusyotokkijkumu())) {
                mosTenkenMsgIdList.add(MessageId.IHC1013);
                mosTenken1jiyhKbn = C_MostenkenyhKbn.YOU;
                mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
            }

            if (C_UmuKbn.ARI.eq(daihituUmukbn)) {
                mosTenkenMsgIdList.add(MessageId.IHC1079);
                mosTenken1jiyhKbn = C_MostenkenyhKbn.YOU;
                mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
            }
        }


        if (daisansyauktKnrnSyoruiFlg) {
            mosTenkenMsgIdList.add(MessageId.IHC1011);
            mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
        }
        else {
            List<HT_Uketorinin> sbUketorininLst = syoriCtl.getUketorininsByUktsyukbn(C_UktsyuKbn.SBUKT);

            for (HT_Uketorinin uketorinin : sbUketorininLst) {
                uktTdk = uketorinin.getUkttdk();
                uktKbn = uketorinin.getUktkbn();

                if (C_Tdk.SONOTA.eq(uktTdk) ||
                    (C_UktKbn.KYK.eq(uktKbn) && C_Tdk.SONOTA.eq(kykTdk))) {

                    mosTenkenMsgIdList.add(MessageId.IHC1011);
                    mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
                    break;
                }
            }
        }

        List<HT_Uketorinin> kyksyaDairininLst = syoriCtl.getUketorininsByUktsyukbn(C_UktsyuKbn.KYKDRN);

        for (HT_Uketorinin uketorinin : kyksyaDairininLst) {

            uktTdk = uketorinin.getUkttdk();
            uktKbn = uketorinin.getUktkbn();

            if (C_UktKbn.TOUROKUKAZOKU1.eq(uktKbn) || C_UktKbn.TOUROKUKAZOKU2.eq(uktKbn)) {

                List<HT_MosTrkKzk> mosTrkKzkLst = syoriCtl.getMosTrkKzks();

                for (HT_MosTrkKzk mosTrkKzk : mosTrkKzkLst) {

                    C_Tdk trkkzkTdk = mosTrkKzk.getTrkkzktdk();
                    C_TrkKzkKbn trkkzkKbn = mosTrkKzk.getTrkkzkkbn();

                    if ((C_UktKbn.TOUROKUKAZOKU1.eq(uktKbn) && C_TrkKzkKbn.TRKKZK1.eq(trkkzkKbn)) ||
                        (C_UktKbn.TOUROKUKAZOKU2.eq(uktKbn) && C_TrkKzkKbn.TRKKZK2.eq(trkkzkKbn))) {

                        if (C_Tdk.SONOTA.eq(trkkzkTdk)) {
                            mosTenkenMsgIdList.add(MessageId.IHC1077);
                            mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
                        }

                        break;
                    }
                }
            }
        }

        List<HT_Uketorinin> hhknSyaDairininLst = syoriCtl.getUketorininsByUktsyukbn(C_UktsyuKbn.STDRSK);

        for (HT_Uketorinin uketorinin : hhknSyaDairininLst) {
            uktTdk = uketorinin.getUkttdk();
            uktKbn = uketorinin.getUktkbn();

            if (C_Tdk.SONOTA.eq(uktTdk)) {

                mosTenkenMsgIdList.add(MessageId.IHC1078);
                mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
                break;
            }
            else if (C_UktKbn.KYK.eq(uktKbn) && C_Tdk.SONOTA.eq(kykTdk)) {

                mosTenkenMsgIdList.add(MessageId.IHC1078);
                mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
                break;
            }

            else if (C_UktKbn.TOUROKUKAZOKU1.eq(uktKbn) || C_UktKbn.TOUROKUKAZOKU2.eq(uktKbn)) {

                List<HT_MosTrkKzk> mosTrkKzkLst = syoriCtl.getMosTrkKzks();

                for (HT_MosTrkKzk mosTrkKzk : mosTrkKzkLst) {

                    C_Tdk trkkzkTdk = mosTrkKzk.getTrkkzktdk();
                    C_TrkKzkKbn trkkzkKbn = mosTrkKzk.getTrkkzkkbn();

                    if ((C_UktKbn.TOUROKUKAZOKU1.eq(uktKbn) && C_TrkKzkKbn.TRKKZK1.eq(trkkzkKbn)) ||
                        (C_UktKbn.TOUROKUKAZOKU2.eq(uktKbn) && C_TrkKzkKbn.TRKKZK2.eq(trkkzkKbn))) {

                        if (C_Tdk.SONOTA.eq(trkkzkTdk)) {
                            mosTenkenMsgIdList.add(MessageId.IHC1078);
                            mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
                        }

                        break;
                    }
                }
            }
        }

        if (torikomiSyoruiCdLst.contains(C_SyoruiCdKbn.SK_FATCAKAKUNINSYO.getValue()) ||
            C_FatcasnsiKbn.GAITOU.eq(fatcasnsiKbn) ||
            C_BikkjnssinfoKbn.ARI.eq(bikkjnSsinfoKbn)) {

            mosTenkenMsgIdList.add(MessageId.IHC1012);
            mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
        }

        if (C_UmuKbn.ARI.eq(syouhnZokusei.getAeoitaisyouumu()) &&
            (C_AeoisnsiKbn.GAITOU.eq(aeoisnsiKbn) ||
                torikomiSyoruiCdLst.contains(C_SyoruiCdKbn.SK_AEOISINKITODOKEDESYO.getValue()))) {
            mosTenkenMsgIdList.add(MessageId.IHC1038);
            mosTenken2jiyhKbn = C_MostenkenyhKbn.YOU;
        }


        if (C_UmuKbn.ARI.eq(pMP.getHhknTratkityuiUmuKbnSignal()) || C_UmuKbn.ARI.eq(pMP.getHhknInfohnsyUmuKbnSignal())) {
            knkySateiSijiMsgIdList.add(MessageId.IHC1014);
            knkySatei1jiyhKbn = C_Knkysatei1jiyhKbn.YOU;
        }
        if (C_KykKbn.KEIHI_BETU.eq(kykKbn) &&
            (C_UmuKbn.ARI.eq(pMP.getKykTratkityuiUmuKbnSignal()) || C_UmuKbn.ARI.eq(pMP.getKykInfohnsyUmuKbnSignal()))) {
            knkySateiSijiMsgIdList.add(MessageId.IHC1015);
            knkySatei1jiyhKbn = C_Knkysatei1jiyhKbn.YOU;
        }
        if (C_UmuKbn.ARI.eq(pMP.getUktTratkityuiUmuKbnSignal()) || C_UmuKbn.ARI.eq(pMP.getUktInfohnsyUmuKbnSignal())) {
            knkySateiSijiMsgIdList.add(MessageId.IHC1016);
            knkySatei1jiyhKbn = C_Knkysatei1jiyhKbn.YOU;
        }
        if (C_UmuKbn.ARI.eq(pMP.getKykDairiTratkityuiUmuKbnSignal()) || C_UmuKbn.ARI.eq(pMP.getKykDairiInfohnsyUmuKbnSignal())) {
            knkySateiSijiMsgIdList.add(MessageId.IHC1062);
            knkySatei1jiyhKbn = C_Knkysatei1jiyhKbn.YOU;
        }
        if (C_UmuKbn.ARI.eq(pMP.getHhknDairiTratkityuiUmuKbnSignal()) || C_UmuKbn.ARI.eq(pMP.getHhknDairiInfohnsyUmuKbnSignal())) {
            knkySateiSijiMsgIdList.add(MessageId.IHC1061);
            knkySatei1jiyhKbn = C_Knkysatei1jiyhKbn.YOU;
        }


        if (C_UmuKbn.ARI.eq(pMP.getHhknTratkityuiUmuKbnMr()) || C_UmuKbn.ARI.eq(pMP.getHhknSntkinfohnsyUmuKbnMr())) {
            knkySateiSijiMsgIdList.add(MessageId.IHC1017);
            knkySatei2jiyhKbn = C_Knkysatei2jiyhKbn.YOU_A;
        }
        if (C_KykKbn.KEIHI_BETU.eq(kykKbn) &&
            (C_UmuKbn.ARI.eq(pMP.getKykTratkityuiUmuKbnMr()) || C_UmuKbn.ARI.eq(pMP.getKykSntkinfohnsyUmuKbnMr()))) {
            knkySateiSijiMsgIdList.add(MessageId.IHC1018);
            knkySatei2jiyhKbn = C_Knkysatei2jiyhKbn.YOU_A;
        }
        if (C_UmuKbn.ARI.eq(pMP.getUktTratkityuiUmuKbnMr()) || C_UmuKbn.ARI.eq(pMP.getUktSntkinfohnsyUmuKbnMr())) {
            knkySateiSijiMsgIdList.add(MessageId.IHC1019);
            knkySatei2jiyhKbn = C_Knkysatei2jiyhKbn.YOU_A;
        }
        if (C_UmuKbn.ARI.eq(pMP.getKykDairiTratkityuiUmuKbnMr()) || C_UmuKbn.ARI.eq(pMP.getKykDairiSntkinfohnsyUmuKbnMr())) {
            knkySateiSijiMsgIdList.add(MessageId.IHC1064);
            knkySatei2jiyhKbn = C_Knkysatei2jiyhKbn.YOU_A;
        }
        if (C_UmuKbn.ARI.eq(pMP.getHhknDairiTratkityuiUmuKbnMr()) || C_UmuKbn.ARI.eq(pMP.getHhknDairiSntkinfohnsyUmuKbnMr())) {
            knkySateiSijiMsgIdList.add(MessageId.IHC1063);
            knkySatei2jiyhKbn = C_Knkysatei2jiyhKbn.YOU_A;
        }
        if (C_UmuKbn.ARI.eq(pMP.getHhknSinsntkhnsyumukbn()) && !hhknSinsntkhnsyKaihiFlg) {
            knkySateiSijiMsgIdList.add(MessageId.IHC1045);
            knkySatei2jiyhKbn = C_Knkysatei2jiyhKbn.YOU_A;
        }
        if (C_KykKbn.KEIHI_BETU.eq(kykKbn) && C_UmuKbn.ARI.eq(pMP.getKykSinsntkhnsyumukbn()) && !kykSinsntkhnsyKaihiFlg) {
            knkySateiSijiMsgIdList.add(MessageId.IHC1046);
            knkySatei2jiyhKbn = C_Knkysatei2jiyhKbn.YOU_A;
        }
        if (C_UmuKbn.ARI.eq(pMP.getUktSinsntkhnsyumukbn()) && !uktSinsntkhnsyKaihiFlg) {
            knkySateiSijiMsgIdList.add(MessageId.IHC1047);
            knkySatei2jiyhKbn = C_Knkysatei2jiyhKbn.YOU_A;
        }
        if (C_UmuKbn.ARI.eq(pMP.getKykDairiSinsntkhnsyUmuKbn()) && !kykDairiSinsntkhnsyKaihiFlg) {
            knkySateiSijiMsgIdList.add(MessageId.IHC1070);
            knkySatei2jiyhKbn = C_Knkysatei2jiyhKbn.YOU_A;
        }
        if (C_UmuKbn.ARI.eq(pMP.getHhknDairiSinsntkhnsyUmuKbn()) && !hhknDairiSinsntkhnsyKaihiFlg) {
            knkySateiSijiMsgIdList.add(MessageId.IHC1069);
            knkySatei2jiyhKbn = C_Knkysatei2jiyhKbn.YOU_A;
        }

        if (C_UmuKbn.ARI.eq(pMP.getUktNayosehumeiUmuKbn())) {
            knkySateiSijiMsgIdList.add(MessageId.IHC1048);
            knkySatei2jiyhKbn = C_Knkysatei2jiyhKbn.YOU_A;
        }
        if (C_UmuKbn.ARI.eq(pMP.getKykDairiNayosehumeiUmuKbn())) {
            knkySateiSijiMsgIdList.add(MessageId.IHC1072);
            knkySatei2jiyhKbn = C_Knkysatei2jiyhKbn.YOU_A;
        }
        if (C_UmuKbn.ARI.eq(pMP.getHhknDairiNayosehumeiUmuKbn())) {
            knkySateiSijiMsgIdList.add(MessageId.IHC1071);
            knkySatei2jiyhKbn = C_Knkysatei2jiyhKbn.YOU_A;
        }

        if (C_YouhiblnkKbn.YOU.eq(pMP.getDoujiMosKnkHndktYhKbn())) {
            knkySateiSijiMsgIdList.add(MessageId.IHC1020);
            knkySatei2jiyhKbn = C_Knkysatei2jiyhKbn.YOU_A;
        }

        if (C_UmuKbn.NONE.eq(nkhknumu)) {
            if (!C_SntkhouKbn.NONE.eq(sntkhouKbn) && !C_NensyuuKbn.BLNK.eq(nensyuuKbn)) {
                if (pMP.getNensyuTuusanSOverHanteiKekka()) {
                    knkySateiSijiMsgIdList.add(MessageId.IHC1021);
                    knkySatei2jiyhKbn = C_Knkysatei2jiyhKbn.YOU_A;
                }
            }
        }

        BizCurrency tuusannGaku = pMP.getTsnketsibous();

        BizCurrency tsnketsiboushonken = BizCurrency.valueOf(0);
        if (!C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu())) {
            tsnketsiboushonken = getKiteiCheckYenkansangk.exec(mosYmd, seitoukihons, tuukaSyu);
        }
        else {
            tsnketsiboushonken = seitoukihons;
        }

        if (C_UmuKbn.NONE.eq(nkhknumu) && !C_Hrkkaisuu.ITIJI.eq(hrkkaisuu) &&
            !C_SntkhouKbn.NONE.eq(sntkhouKbn) && tsnketsiboushonken.compareTo(TSNKETSIBOUSHONKEN_HANTIEKIJYUN) > 0) {
            if (SYOKUGYOUCDSAIKANOMUSYOKUARUHOITO.equals(hhknSykgyCd)) {
                if (tuusannGaku.compareTo(HANTIETSNSBS1) > 0) {
                    knkySateiSijiMsgIdList.add(MessageId.IHC1022);
                    knkySatei2jiyhKbn = C_Knkysatei2jiyhKbn.YOU_A;
                }
            }
            else if (SYOKUGYOUCDGAKUSEISHUFUKODOMO.equals(hhknSykgyCd)) {
                if (tuusannGaku.compareTo(HANTIETSNSBS2) > 0) {
                    knkySateiSijiMsgIdList.add(MessageId.IHC1022);
                    knkySatei2jiyhKbn = C_Knkysatei2jiyhKbn.YOU_A;
                }
            }
        }

        if (C_YouhiblnkKbn.YOU.eq(pMP.getHhknTtdkTyuuiKnkHndktYhKbn())) {
            knkySateiSijiMsgIdList.add(MessageId.IHC1023);
            knkySatei2jiyhKbn = C_Knkysatei2jiyhKbn.YOU_A;
        }
        if (C_KykKbn.KEIHI_BETU.eq(kykKbn) && C_YouhiblnkKbn.YOU.eq(pMP.getKykTtdkTyuuiKnkHndktYhKbn())) {
            knkySateiSijiMsgIdList.add(MessageId.IHC1024);
            knkySatei2jiyhKbn = C_Knkysatei2jiyhKbn.YOU_A;
        }
        if (C_YouhiblnkKbn.YOU.eq(pMP.getUktTtdkTyuuiKnkHndktYhKbn())) {
            knkySateiSijiMsgIdList.add(MessageId.IHC1025);
            knkySatei2jiyhKbn = C_Knkysatei2jiyhKbn.YOU_A;
        }
        if (C_YouhiblnkKbn.YOU.eq(pMP.getKykDairiTtdkTyuuiKnkHndktYhKbn())) {
            knkySateiSijiMsgIdList.add(MessageId.IHC1066);
            knkySatei2jiyhKbn = C_Knkysatei2jiyhKbn.YOU_A;
        }
        if (C_YouhiblnkKbn.YOU.eq(pMP.getHhknDairiTtdkTyuuiKnkHndktYhKbn())) {
            knkySateiSijiMsgIdList.add(MessageId.IHC1065);
            knkySatei2jiyhKbn = C_Knkysatei2jiyhKbn.YOU_A;
        }

        if ((houteityotkseiFlag || hCvObjectFlag) &&
            C_UmuKbn.ARI.eq(pMP.getHhknGaikokupepsumukbn())) {
            knkySateiSijiMsgIdList.add(MessageId.IHC1053);
            knkySatei2jiyhKbn = C_Knkysatei2jiyhKbn.YOU_A;
        }
        if (C_KykKbn.KEIHI_BETU.eq(kykKbn) &&
            (houteityotkseiFlag || hCvObjectFlag) &&
            C_UmuKbn.ARI.eq(pMP.getKykGaikokupepsumukbn())) {
            knkySateiSijiMsgIdList.add(MessageId.IHC1054);
            knkySatei2jiyhKbn = C_Knkysatei2jiyhKbn.YOU_A;
        }
        if ((houteityotkseiFlag || hCvObjectFlag) &&
            C_UmuKbn.ARI.eq(pMP.getUktGaikokupepsumukbn())) {
            knkySateiSijiMsgIdList.add(MessageId.IHC1055);
            knkySatei2jiyhKbn = C_Knkysatei2jiyhKbn.YOU_A;
        }
        if ((houteityotkseiFlag || hCvObjectFlag) &&
            C_UmuKbn.ARI.eq(pMP.getKykDairiGaikokupepsumukbn())) {
            knkySateiSijiMsgIdList.add(MessageId.IHC1074);
            knkySatei2jiyhKbn = C_Knkysatei2jiyhKbn.YOU_A;
        }
        if ((houteityotkseiFlag || hCvObjectFlag) &&
            C_UmuKbn.ARI.eq(pMP.getHhknDairiGaikokupepsumukbn())) {
            knkySateiSijiMsgIdList.add(MessageId.IHC1073);
            knkySatei2jiyhKbn = C_Knkysatei2jiyhKbn.YOU_A;
        }

        if (C_KykKbn.KEIHI_BETU.eq(kykKbn) && C_Tdk.SONOTA.eq(kykTdk)) {

            knkySateiSijiMsgIdList.add(MessageId.IHC1026);
            knkySatei2jiyhKbn = C_Knkysatei2jiyhKbn.YOU_A;
        }

        if (C_UmuKbn.NONE.eq(nkhknumu) && !C_Hrkkaisuu.ITIJI.eq(hrkkaisuu)) {
            if (daisansyauktKnrnSyoruiFlg) {

                knkySateiSijiMsgIdList.add(MessageId.IHC1049);
                knkySatei2jiyhKbn = C_Knkysatei2jiyhKbn.YOU_A;
            } else {
                List<HT_Uketorinin> sbUketorininLst = syoriCtl.getUketorininsByUktsyukbn(C_UktsyuKbn.SBUKT);

                for (HT_Uketorinin uketorinin : sbUketorininLst) {
                    uktTdk = uketorinin.getUkttdk();
                    uktKbn = uketorinin.getUktkbn();

                    if (C_Tdk.SONOTA.eq(uktTdk) ||
                        (C_UktKbn.KYK.eq(uktKbn) && C_Tdk.SONOTA.eq(kykTdk))) {

                        knkySateiSijiMsgIdList.add(MessageId.IHC1049);
                        knkySatei2jiyhKbn = C_Knkysatei2jiyhKbn.YOU_A;
                        break;
                    }
                }
            }
        }

        if (kykkakList.size() > 0) {
            if (C_KykkakkekKbn.HOUKOKUJIKOU_ARI.eq(kykkakList.get(0).getKykkakkekkbn())) {

                knkySateiSijiMsgIdList.add(MessageId.WHC0008);
                knkySatei2jiyhKbn = C_Knkysatei2jiyhKbn.YOU_A;
            }
        }

        if (C_LincjkKbn.KAITOARI_TASYAARI.eq(lincjkkbn) && C_LinckknnjkKbn.KAKUNINMATI.eq(linckknnjkkbn)) {

            knkySateiSijiMsgIdList.add(MessageId.WHC0028);
            knkySatei2jiyhKbn = C_Knkysatei2jiyhKbn.YOU_A;
        }



        if (C_SntkhouKbn.KKT.eq(sntkhouKbn) && C_UmuKbn.ARI.eq(kktNrkUmu)) {
            HT_Kokutisyo kokutisyo = syoriCtl.getKokutisyo();
            C_KijiKbn kijiKbn = kokutisyo.getKijikbn();
            int sintyou = kokutisyo.getSintyou();
            int taijyuu = kokutisyo.getTaijyuu();

            if (C_KijiKbn.ARI.eq(kijiKbn)) {
                imuSateiSijiMsgIdList.add(MessageId.IHC1028);
                imuSateikaniyhKbn = C_ImusateikaniyhKbn.YOU_KANI_UW;
            }

            taihntKekka = HanteiTaikaku.hantei(sintyou, taijyuu);
            if (C_Taihntmdr.KAJYUU.eq(taihntKekka)) {
                imuSateiSijiMsgIdList.add(MessageId.IHC1029);
                imuSateikaniyhKbn = C_ImusateikaniyhKbn.YOU_KANI_UW;
            }
            if (C_Taihntmdr.KAKEI.eq(taihntKekka)) {
                imuSateiSijiMsgIdList.add(MessageId.IHC1030);
                imuSateikaniyhKbn = C_ImusateikaniyhKbn.YOU_KANI_UW;
            }

            if (C_YouhiblnkKbn.YOU.eq(pMP.getDoujiMosItekiHndktYhKbn())) {
                imuSateiSijiMsgIdList.add(MessageId.IHC1031);
                imuSateikaniyhKbn = C_ImusateikaniyhKbn.YOU_KANI_UW;
            }
            if (C_YouhiblnkKbn.YOU.eq(pMP.getHhknItekisntkhndktYhKbn())) {
                imuSateiSijiMsgIdList.add(MessageId.IHC1032);
                imuSateikaniyhKbn = C_ImusateikaniyhKbn.YOU_KANI_UW;
            }
            if (C_YouhiblnkKbn.YOU.eq(pMP.getHhknKyhkinUktkAriItkHndktYhKbn())) {
                imuSateiSijiMsgIdList.add(MessageId.IHC1033);
                imuSateikaniyhKbn = C_ImusateikaniyhKbn.YOU_KANI_UW;
            }

            List<HT_ImusateiRireki> imusateiRirekiLst =
                syoriCtl.getImusateiRirekisByImusateikekkakbn(C_SyorikekkaKbn.KANRYOU);

            if (imusateiRirekiLst != null && imusateiRirekiLst.size() > 0) {
                SortHT_ImusateiRireki sortHTImusateiRireki = SWAKInjector.getInstance(SortHT_ImusateiRireki.class);
                imusateiRirekiLst = sortHTImusateiRireki.OrderHT_ImusateiRirekiByPkDesc(imusateiRirekiLst);

                C_Ketkekkacd ketkekkaCd = imusateiRirekiLst.get(0).getKetkekkacd();
                if (C_Ketkekkacd.GENKAITAI_SYOUDAKU.eq(ketkekkaCd)) {
                    imuSateiSijiMsgIdList.add(MessageId.IHC1034);
                    imuSateikaniyhKbn = C_ImusateikaniyhKbn.YOU_KANI_UW;
                }
            }

        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ ハンド査定・決定判定 終了");
        }
    }
}
