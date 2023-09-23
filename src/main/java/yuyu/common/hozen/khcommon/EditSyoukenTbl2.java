package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_SyouhnTokujou;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 契約保全共通 保険証券TBL編集２
 */
public class EditSyoukenTbl2 {

    private static final int SINKEIYAKUHOKENSYOUKEN = 1;

    private static final int SAIHAKKOUHOKENSYOUKEN = 2;

    private static final int UKETORIHITOLSTMAXCNT = 10;

    private static final int SONOTANAIYOULSTMAXCNT = 20;

    private static final int HUTANHIYUSTMMSGCDUEMAXCNT = 4;

    private static final int WTYUUIJIKOUMSGCDMAXCNT = 7;

    private static final int SYOUHNHUTAIMSGCDLSTMAXCNT = 2;

    private static final int DAI1HKNKKNMAXCNT = 10;

    private static final int SIBOUDAI1HKNKKNMSGCDCNT = 2;

    private static final int MKHYOUYENSYSNIKOUMSGCDMAXCNT = 3;

    private static final double HUTANHIYUSTMYTIJIHIRITU = 1.0;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    private C_HassouKbn hassoukbn;

    private BizDate sysDate;

    public EditSyoukenTbl2() {
        super();
    }

    public C_HassouKbn getHassoukbn() {
        return hassoukbn;
    }


    public void editTBL(KhozenCommonParam pKCParm,
        IT_KykKihon pKykKihon,
        List<IT_KykSyouhn> pSyuKykSyouhnLst,
        IT_KykSonotaTkyk pKykSonotaTkyk,
        List<IT_KykSyouhn> pTkKykSyouhnLst,
        IT_SyouhnTokujou pSyhnTkjouSyu,
        IT_KykSya pKykSya,
        IT_HhknSya pHhknSya,
        IT_KykUkt pSibouHenkan,
        IT_KykUkt pSiteiDairi,
        List<IT_KykDairiten> pKykDairitenLst,
        IT_KhTtdkTyuui pKhTtdkTyuui,
        List<IT_KykUkt> pSibouhokenLst,
        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst,
        EditHokenSyoukenParam pEditHokenSyoukenParam,
        BizDate pSyoriYmd,
        C_SinsaihkKbn pSinsaihkKbn,
        C_TetudukisyuKbn pTetudukisyuKbn,
        C_HassouKbn pHassouKbn) {

        if (pSyuKykSyouhnLst == null || pSyuKykSyouhnLst.size() == 0) {
            return ;
        }


        C_Tkhukaumu yennykntkhkKbn = C_Tkhukaumu.BLNK;

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn sbuBnwariUmu = C_UmuKbn.ARI;

        C_KjkhukaKbn stdrNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn stdrsktirasidouhuukbn = C_UmuKbn.NONE;

        C_UmuKbn dsTirasiDouhuuKbn = C_UmuKbn.NONE;

        C_UmuKbn tnsHuyouPostUmuKbn = C_UmuKbn.NONE;

        C_KjkhukaKbn sbUktNmKjHukaKbn1st = C_KjkhukaKbn.BLNK;

        String uktnmkj1st = "";

        List<String> hyoujiranleftmsgcdLst = new ArrayList<>();

        List<String> hyoujiranrightmsgcdLst = new ArrayList<>();

        BizDate sknnkaisiymd = null;

        BizNumber hyoujiranyoteiriritu = null;

        String ptokuyakumsgcd = "";

        BizCurrency hokenryou = null;

        C_Tuukasyu ptuukasyu = C_Tuukasyu.BLNK;

        String ptuukasyuNm = "";

        String syukyktkykmsgkbn1 = "";

        String syukyktkykmsgkbn2 = "";

        String syukyktkykmsgkbn3 = "";

        C_Tuukasyu syukyktkykstuukatype1 = C_Tuukasyu.BLNK;

        C_Tuukasyu syukyktkykstuukatype2 = C_Tuukasyu.BLNK;

        C_Tuukasyu syukyktkykstuukatype3 = C_Tuukasyu.BLNK;

        BizCurrency syukyktkykhknkngk1 = null;

        BizCurrency syukyktkykhknkngk2 = null;

        BizCurrency syukyktkykhknkngk3 = null;

        BizDate syutkdai1hknkknymdto1 = null;

        BizDate syutkdai2hknkknymdto1 = null;

        BizDate syutkdai2hknkknymdto2 = null;

        String kykniyustmsgcd1 = "";

        String kykniyustmsgcd2 = "";

        String kykniyustmsgcd3 = "";

        String kykniyustmsgcd4  = "";

        C_Tuukasyu kykniyustitjbrptuuktype = C_Tuukasyu.BLNK;

        BizCurrency kykniyustitjbrp = null;

        String siboudai2hknkknmsgcd1 = "";

        String siboudai2hknkknmsgcd2 = "";

        String siboudai3hknkknmsgcd1 = "";

        String siboudai3hknkknmsgcd2 = "";

        String siboudai1hknkknhrsmsgcd = "";

        String siboudai1hknkknhrsmsgcd2 = "";

        String siboudai1hknkknsmrmsgcd = "";

        String siboudai1hknkknigimsgcd = "";

        String siboudai1hknkknigimsgcd2 = "";

        String siboudai2hknkknsmsgcd = "";

        String siboudai2hknkknsmsgcd2 = "";

        String siboumidasimsgcd2 = "";

        C_Tuukasyu sibouitjbrpyentuuktype = C_Tuukasyu.BLNK;

        BizCurrency sibouitjbrpyentuukgk = null;

        C_UmuKbn maruExistsFlg = C_UmuKbn.NONE;

        BizCurrency dai1syenyendakahuryo = null;

        BizCurrency dai1syenyenkijyunhuryo = null;

        BizCurrency dai1syenyenyasuhuryo = null;

        String dai1syenyendakaumuhuryo = C_UmuKbn.NONE.toString();

        String dai1syenyenkjnumuhuryo = C_UmuKbn.NONE.toString();

        String dai1syenyenyasuumuhuryo = C_UmuKbn.NONE.toString();

        C_Tuukasyu dai1stuuktypehuryo = C_Tuukasyu.BLNK;

        BizCurrency dai1shuryo = null;

        C_Tuukasyu dai1syentuuktypehuryo = C_Tuukasyu.BLNK;

        BizCurrency dai2s = null;

        C_Tuukasyu dai2syentuuktype = C_Tuukasyu.BLNK;

        BizCurrency dai2syenyendaka = null;

        BizCurrency dai2syenyenkijyun = null;

        BizCurrency dai2syenyenyasu = null;

        C_Tuukasyu dai2stuuktype = C_Tuukasyu.BLNK;

        BizCurrency dai3s = null;

        C_Tuukasyu dai3syentuuktype = C_Tuukasyu.BLNK;

        BizCurrency dai3syenyendaka = null;

        BizCurrency dai3syenyenkijyun = null;

        BizCurrency dai3syenyenyasu = null;

        C_Tuukasyu dai3stuuktype = C_Tuukasyu.BLNK;

        C_Tuukasyu siboudai1kjnkngktuuktype =  C_Tuukasyu.BLNK;

        BizCurrency siboudai1kjnkngk = null;

        C_Tuukasyu siboudai2kjnkngktuuktype =  C_Tuukasyu.BLNK;

        BizCurrency siboudai2kjnkngk = null;

        C_Tuukasyu siboudai3kjnkngktuuktype =  C_Tuukasyu.BLNK;

        BizCurrency siboudai3kjnkngk = null;

        BizNumber skwsrateyendaka = null;

        BizNumber skwsrateyenkijyun = null;

        BizNumber skwsrateyenyasu = null;

        C_Tuukasyu mkhyouyensysnikougktype = C_Tuukasyu.BLNK;

        BizNumber mkhyouyensysnikouwra = null;

        C_Tuukasyu sonotanyrankjnkngktuktype =  C_Tuukasyu.BLNK;

        BizCurrency sonotanyrankjnkngk = null;

        BizNumber sonotanyrankjnkngkrate = null;

        String sonotanyrankjnkngktuuka = "";

        BizNumber sonotanyranenkhrikmrate = null;

        BizNumber sonotanyranstigikwsrate = null;

        C_Tuukasyu sonotanyrannykntuktype =  C_Tuukasyu.BLNK;

        BizCurrency sonotanyrannykntuukap = null;

        String  sonotanyrannykntuukasyu = "";

        BizNumber sonotanyranytirrt = null;

        C_Tuukasyu sonotanyranpentuktype =  C_Tuukasyu.BLNK;

        BizCurrency sonotanyranpenknsngk = null;

        BizNumber sonotanyranmkhwariai = null;

        BizNumber kyksjkkktyouseiriritu = null;

        String  kaigomaehrtkykkyktuuka = "";

        String kaigomaehrtkykmsgcd1 = "";

        String kaigomaehrtkykmsgcd2 = "";

        C_UmuKbn kaigomaehruktgkumu = C_UmuKbn.NONE;

        C_Tuukasyu kaigomaehrjrugktype  =  C_Tuukasyu.BLNK;

        String kaigomaehrtkykmsgcdst1 = "";

        String kaigomaehrtkykstdmsgcd = "";

        int kaigomaehrsikuhhknnen = 0;

        String hutanhiyustmknsnhyuptn = "";

        String hutanhiyustmmsgcdst01 = "";

        String hutanhiyustmmsgcdst02 = "";

        String hutanhiyustmmsgcdst03 = "";

        String stdstmmsgcd = "";

        String fstpmsgcd = "";

        C_Tuukasyu fstphrkpkngkkeituuktype = C_Tuukasyu.BLNK;

        BizCurrency fstphrkpkngkkei = null;

        String fstponegaimsgcd = "";

        String dsmsgcd = "";

        String toiawasesakihanyoumsgcd = "";

        String annaihanyoumsgcd = "";

        String wmsgcd1 = "";

        String wmsgcd2 = "";

        String wmsgcd3 = "";

        String wmsgcd2_1 = "";

        String wmsgcd2_2 = "";

        String wmsgcd3_1 = "";

        String wmsgcdst = "";

        C_Tuukasyu witijibrptuktype = C_Tuukasyu.BLNK;

        BizCurrency witijibrp = null;

        C_Tuukasyu wyenhrkgktuktype = C_Tuukasyu.BLNK;

        BizCurrency wyenhrkgk = null;

        C_Tuukasyu wyenitijibrptuktype = C_Tuukasyu.BLNK;

        BizCurrency wyenitijibrp = null;

        String koujyosyoumeimsgcd1 = "";

        BizNumber hyoujiransjkkktusirrt = null;

        List<Integer> kaigomaehrsikuhhknnenLst = new ArrayList<>();

        List<BizNumber> kaigomaehrstikknLst = new ArrayList<>();

        List<BizCurrency> kaigomaehrjrugkLst = new ArrayList<>();

        List<String> hutanhiyustmmsgcdueLst = new ArrayList<>();

        List<String> wtyuuijikoumsgcdLst = new ArrayList<>();

        List<String> siboudai1hknkknmsgcdLst = new ArrayList<>();

        List<String> nenkinmsgcdLst = new ArrayList<>();

        List<String> siboukyhkmsgcdLst = new ArrayList<>();

        List<String> mkhyouyensysnikoumsgcdLst = new ArrayList<>();

        BizDate nkshrstartymd = null;

        BizNumber kykjisisuurendourate = null;

        BizNumber sonotanyrannenkinkkn = null;

        BizDate sonotanyranyensysnhkhnkymd = null;

        BizNumber tumitateriritu = null;

        BizNumber sonotanyrantmttknzkrtjygn = null;

        BizNumber sonotanyransetteibairitu = null;

        BizCurrency sonotanyranteiritutmttkngk = null;

        BizCurrency sonotanyransisuutmttkngk = null;

        String sonotanyransisuunm = "";

        C_HknKknKbn hknkknkbn = C_HknKknKbn.BLNK;

        BizDate dai1hknkknEndYmd = null;

        BizDate dai2hknkknEndYmd = null;

        //        sysDate = BizDate.getSysDate();
        //
        //        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(pSyuKykSyouhnLst.get(0).getSyouhncd(),
        //            pSyuKykSyouhnLst.get(0).getSyouhnsdno());
        //
        //        BM_TantouCd tantouCdEntity = bizDomManager.getTantouCd(C_TantouCdKbn.DAIRITENJIMUKANRI);
        //
        //        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
        //
        //
        //        String henkouSikibetuKey = pKCParm.getSikibetuKey(pKykKihon.getSyono());
        //
        //
        //        int sksyoukenskskbn ;
        //
        //        if (C_SinsaihkKbn.SIN.eq(pSinsaihkKbn) || (C_SinsaihkKbn.SAI.eq(pSinsaihkKbn) &&
        //            C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI.eq(pEditHokenSyoukenParam.getSyoukenSaihk()))) {
        //
        //            sksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        //
        //        }
        //        else {
        //
        //            sksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        //        }
        //
        //        BizDate syoHakkoubi = null;
        //
        //        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //
        //            SetSyokenhakkouymd setSyokenhakkouymd = SWAKInjector.getInstance(SetSyokenhakkouymd.class);
        //
        //            syoHakkoubi = setSyokenhakkouymd.exec(pSyoriYmd);
        //        }
        //        else {
        //
        //            syoHakkoubi = pSyoriYmd;
        //        }
        //
        //        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        //        if (sksyoukenskskbn == SAIHAKKOUHOKENSYOUKEN) {
        //
        //            IT_KykKihon kykKihon = new IT_KykKihon();
        //
        //            kykKihon = hozenDomManager.getKykKihon(pKykKihon.getSyono());
        //
        //            List<IT_KhTtdkRireki> ttdkRirekiList =
        //                kykKihon.getKhTtdkRirekisByGyoumuKousinKinou(
        //                    IKhozenCommonConstants.KINOUID_GENGAKU);
        //
        //            if (ttdkRirekiList != null && ttdkRirekiList.size() > 0) {
        //                gengakuExistsCheck = C_UmuKbn.ARI;
        //
        //            }
        //
        //        }
        //
        //        BizCurrency kijyungaku = null;
        //
        //        BizNumber fstpnyknymdrate = null;
        //
        //        if (C_UmuKbn.NONE.eq(gengakuExistsCheck)) {
        //            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                yennykntkhkKbn = C_Tkhukaumu.HUKA;
        //            } else {
        //                yennykntkhkKbn = C_Tkhukaumu.NONE;
        //            }
        //
        //            if (!C_Tuukasyu.JPY.eq(pSyuKykSyouhnLst.get(0).getKyktuukasyu())) {
        //
        //                KeisanKijyungk keisanKijyungk = SWAKInjector.getInstance(KeisanKijyungk.class);
        //
        //                C_ErrorKbn result = keisanKijyungk.exec(
        //                    pKykKihon.getFstpnyknymd()
        //                    ,pNyknJissekiRirekiLst.get(0).getRsgaku()
        //                    ,pKykKihon.getHrkp()
        //                    , pSyuKykSyouhnLst.get(0).getKyktuukasyu()
        //                    ,yennykntkhkKbn
        //                    );
        //
        //                if (C_ErrorKbn.ERROR.eq(result)) {
        //                    throw new CommonBizAppException("基準金額が取得できませんでした。");
        //                }
        //
        //                kijyungaku = keisanKijyungk.getKijyungk();
        //
        //                fstpnyknymdrate = keisanKijyungk.getYenkawaserate();
        //            }
        //
        //        } else {
        //            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {
        //                kijyungaku = pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk();
        //            }
        //
        //            else if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu())) {
        //                kijyungaku = pKykSonotaTkyk.getTargettkykkijyungk();
        //            }
        //
        //            GetKawaseRate getFstKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
        //
        //            getFstKawaseRate.exec(
        //                pKykKihon.getFstpnyknymd(),
        //                C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
        //                pSyuKykSyouhnLst.get(0).getKyktuukasyu(),
        //                C_Tuukasyu.JPY,
        //                C_KawasetekiyoKbn.TTM,
        //                C_KawasetsryKbn.NYUKINRATE,
        //                C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
        //                C_YouhiKbn.HUYOU);
        //
        //            fstpnyknymdrate = getFstKawaseRate.getKawaserate();
        //        }
        //
        //        int syouhnhanteiKbn = SyouhinUtil.hantei(pSyuKykSyouhnLst.get(0).getSyouhncd());
        //
        //        if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
        //
        //            syouhnhanteiKbn = SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR;
        //
        //        } else {
        //
        //            syouhnhanteiKbn = SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR;
        //        }
        //
        //        C_Tuukasyu kyktuukasyu = pSyuKykSyouhnLst.get(0).getKyktuukasyu();
        //
        //        String kyktuukasyuNm = pSyuKykSyouhnLst.get(0).getKyktuukasyu().getContent();
        //
        //        BizNumber yoteiriritu = pSyuKykSyouhnLst.get(0).getYoteiriritu();
        //
        //        BizDate yendthnkymd = pSyuKykSyouhnLst.get(0).getYendthnkymd();
        //
        //        kykjisisuurendourate = pSyuKykSyouhnLst.get(0).getKykjisisuurendourate();
        //
        //        C_Nenkinsyu nksyukbn = pSyuKykSyouhnLst.get(0).getNksyukbn();
        //
        //        int dai1hknkkn = syouhnZokusei.getDai1hknkkn();
        //
        //        int dai2hknkkn = syouhnZokusei.getMvatekikkn() - dai1hknkkn;
        //
        //        C_UmuKbn nkhknumu = syouhnZokusei.getNkhknumu();
        //
        //        C_UmuKbn syuusinhknumu = syouhnZokusei.getSyuusinhknumu();
        //
        //        C_UmuKbn sbkyuuhukinuktumu = syouhnZokusei.getSbkyuuhukinuktumu();
        //
        //        C_UmuKbn sbhkuktumu = syouhnZokusei.getSbhkuktumu();
        //
        //        C_MousideIkouKbn mousideikoukbn = syouhnZokusei.getMousideikoukbn();
        //
        //        IT_KykUkt nenkinUketorinin = null;
        //
        //        if (C_UmuKbn.ARI.eq(nkhknumu)) {
        //
        //            if (pKykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.NKUKT).size() > 0) {
        //
        //                nenkinUketorinin = pKykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.NKUKT).get(0);
        //            }
        //        }
        //
        //        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //
        //            if(pKykSonotaTkyk.getStdrsktkyhkumu().eq(C_UmuKbn.ARI)) {
        //
        //                stdrsktirasidouhuukbn = C_UmuKbn.ARI;
        //            }
        //        }
        //        else {
        //
        //            if(pEditHokenSyoukenParam.getStdrsktkyhnkKbn().eq(C_StdrsktkyhnkKbn.HUKA)) {
        //
        //                stdrsktirasidouhuukbn = C_UmuKbn.ARI;
        //            }
        //        }
        //
        //        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //            if (C_DirectServiceMosKbn.ENTRY.eq(pKykKihon.getDrctservicemoskbn())
        //                || C_DirectServiceMosKbn.CHECK.eq(pKykKihon.getDrctservicemoskbn())) {
        //                dsTirasiDouhuuKbn = C_UmuKbn.ARI;
        //            }
        //        }
        //
        //        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //            if (C_HonninkakuninSyoruiKbn.KOKUMINKENKOUHOKEN.eq(pKykKihon.getKykhonninkakninsyoruikbn())
        //                || C_HonninkakuninSyoruiKbn.KENKOUHOKEN.eq(pKykKihon.getKykhonninkakninsyoruikbn())
        //                || C_HonninkakuninSyoruiKbn.SENINHOKEN.eq(pKykKihon.getKykhonninkakninsyoruikbn())
        //                || C_HonninkakuninSyoruiKbn.KAIGOHOKEN.eq(pKykKihon.getKykhonninkakninsyoruikbn())
        //                || C_HonninkakuninSyoruiKbn.KOUKIKOUREISYAIRYOU.eq(pKykKihon.getKykhonninkakninsyoruikbn())
        //                || C_HonninkakuninSyoruiKbn.KENKOUHOKENHIYATOI.eq(pKykKihon.getKykhonninkakninsyoruikbn())
        //                || C_HonninkakuninSyoruiKbn.KOKKAKOUMUINKYOUSAI.eq(pKykKihon.getKykhonninkakninsyoruikbn())
        //                || C_HonninkakuninSyoruiKbn.TIHOUKOUMUINKYOUSAI.eq(pKykKihon.getKykhonninkakninsyoruikbn())
        //                || C_HonninkakuninSyoruiKbn.SIRITUGAKKOUKYOUINKYOUSAI.eq(pKykKihon.getKykhonninkakninsyoruikbn())
        //                || C_HonninkakuninSyoruiKbn.KOKUMINNENKIN.eq(pKykKihon.getKykhonninkakninsyoruikbn())
        //                || C_HonninkakuninSyoruiKbn.JIDOUHUYOUTEATE.eq(pKykKihon.getKykhonninkakninsyoruikbn())
        //                || C_HonninkakuninSyoruiKbn.TOKUBETUJIDOUHUYOUTEATE.eq(pKykKihon.getKykhonninkakninsyoruikbn())
        //                || C_HonninkakuninSyoruiKbn.BOSIKENKOU.eq(pKykKihon.getKykhonninkakninsyoruikbn())
        //                || C_HonninkakuninSyoruiKbn.SINTAISYOUGAISYA.eq(pKykKihon.getKykhonninkakninsyoruikbn())
        //                || C_HonninkakuninSyoruiKbn.SEISINSYOUGAISYA.eq(pKykKihon.getKykhonninkakninsyoruikbn())
        //                || C_HonninkakuninSyoruiKbn.RYOUIKU.eq(pKykKihon.getKykhonninkakninsyoruikbn())
        //                || C_HonninkakuninSyoruiKbn.SENSYOUBYOUSYA.eq(pKykKihon.getKykhonninkakninsyoruikbn())
        //                || C_HonninkakuninSyoruiKbn.GAIKOKUSEIHUKOKUSAIKIKAN.eq(pKykKihon.getKykhonninkakninsyoruikbn())    ) {
        //                tnsHuyouPostUmuKbn = C_UmuKbn.ARI;
        //            }
        //        }
        //
        //        HanteiHokenKikan hanteiHokenKikan = SWAKInjector.getInstance(HanteiHokenKikan.class);
        //
        //        HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);
        //
        //        hanteiHokenKikanBean.setKykYmd(pSyuKykSyouhnLst.get(0).getKykymd());
        //
        //        hanteiHokenKikanBean.setDai1HknKkn(syouhnZokusei.getDai1hknkkn());
        //
        //        hanteiHokenKikanBean.setMvaTekiyouKkn(syouhnZokusei.getMvatekikkn());
        //
        //        hanteiHokenKikanBean.setCalcKijyunYmd(pSyoriYmd);
        //
        //
        //        if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR && yendthnkymd == null) {
        //
        //            hknkknkbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);
        //
        //            dai1hknkknEndYmd = hanteiHokenKikan.getDai2HknkknStartYmd().getPreviousDay();
        //
        //            dai2hknkknEndYmd = hanteiHokenKikan.getDai3HknkknStartYmd().getPreviousDay();
        //        }
        //
        //        BM_SisuuKihon sisuuKihon = bizDomManager.getSisuuKihon(pSyuKykSyouhnLst.get(0).getSisuukbn());
        //
        //        String sisuunm = "";
        //
        //        if (sisuuKihon != null) {
        //
        //            sisuunm = sisuuKihon.getSisuunm();
        //        }
        //
        //        SisurendoTmttknInfoBean sisurendoTmttknInfoBean = hozenDomManager.getSisurendoTmttknInfoBean(pKykKihon.getSyono(),
        //            pEditHokenSyoukenParam.getCalckijyunYMD());
        //
        //        KeisanSisuuRendouNkKykTmttkn keisanSisuuRendouNkKykTmttkn = SWAKInjector.getInstance(KeisanSisuuRendouNkKykTmttkn.class);
        //        keisanSisuuRendouNkKykTmttkn.exec(kyktuukasyu, pSyuKykSyouhnLst.get(0).getHokenryou(), kykjisisuurendourate);
        //
        //        BizCurrency teirituTmttkngk = keisanSisuuRendouNkKykTmttkn.getTeiritutmttkngk();
        //
        //        BizCurrency sisuurendouTmttkngk = keisanSisuuRendouNkKykTmttkn.getSisuurendoutmttkngk();
        //
        //        hyoujiranleftmsgcdLst.add("02010");
        //
        //        if (C_MousideIkouKbn.YENSYUUSIN.eq(mousideikoukbn)) {
        //
        //            hyoujiranleftmsgcdLst.add("02021");
        //        }
        //
        //        if (C_MousideIkouKbn.YENNENKIN.eq(mousideikoukbn)) {
        //
        //            hyoujiranleftmsgcdLst.add("02025");
        //        }
        //
        //        if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
        //
        //            if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //
        //                if (kykjisisuurendourate.compareTo(BizNumber.ZERO) > 0) {
        //
        //                    hyoujiranleftmsgcdLst.add("02027");
        //                }
        //
        //                hyoujiranleftmsgcdLst.add("02029");
        //
        //                if (kykjisisuurendourate.compareTo(BizNumber.valueOf(100)) == 0) {
        //
        //                    hyoujiranrightmsgcdLst.add("02040");
        //                } else {
        //
        //                    hyoujiranrightmsgcdLst.add("02060");
        //                }
        //            }
        //
        //            if (sksyoukenskskbn == SAIHAKKOUHOKENSYOUKEN) {
        //
        //                if (yendthnkymd == null){
        //
        //                    if (kykjisisuurendourate.compareTo(BizNumber.ZERO) > 0) {
        //
        //                        hyoujiranleftmsgcdLst.add("02027");
        //                    }
        //
        //                    hyoujiranleftmsgcdLst.add("02029");
        //                    hyoujiranleftmsgcdLst.add("02031");
        //                    sknnkaisiymd = pSyuKykSyouhnLst.get(0).getSknnkaisiymd();
        //                    tumitateriritu = pSyuKykSyouhnLst.get(0).getTumitateriritu();
        //
        //                    if (kykjisisuurendourate.compareTo(BizNumber.valueOf(100)) == 0) {
        //
        //                        hyoujiranleftmsgcdLst.add("02070");
        //                    } else {
        //
        //                        hyoujiranleftmsgcdLst.add("02072");
        //                    }
        //
        //                    hyoujiranleftmsgcdLst.add("02062");
        //                    hyoujiransjkkktusirrt = pSyuKykSyouhnLst.get(0).getKyksjkkktyouseiriritu();
        //
        //                }
        //            }
        //        }
        //
        //        if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR) {
        //
        //            if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //                hyoujiranleftmsgcdLst.add("02023");
        //                hyoujiranrightmsgcdLst.add("02510");
        //            }
        //
        //            if (sksyoukenskskbn == SAIHAKKOUHOKENSYOUKEN) {
        //
        //                if (yendthnkymd == null){
        //                    hyoujiranleftmsgcdLst.add("02023");
        //                    hyoujiranleftmsgcdLst.add("02050");
        //                    hyoujiranleftmsgcdLst.add("02060");
        //                    hyoujiransjkkktusirrt = pSyuKykSyouhnLst.get(0).getKyksjkkktyouseiriritu();
        //                    hyoujiranyoteiriritu = yoteiriritu;
        //                }
        //            }
        //        }
        //
        //        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //            hyoujiranleftmsgcdLst.add("02490");
        //            hyoujiranrightmsgcdLst.add("02520");
        //            sknnkaisiymd = pSyuKykSyouhnLst.get(0).getSknnkaisiymd();
        //        }
        //
        //        List<String> uktnmkjLst = new ArrayList<>();
        //
        //        List<BizNumber> uktBnwariList = new ArrayList<>();
        //
        //        List<C_SyoukenUktMidasiKbn> syoukenuktmidasikbnLst = new ArrayList<>();
        //
        //        List<C_SyoukenUktKbn> uktKbnLst = new ArrayList<>();
        //
        //        if (nenkinUketorinin != null) {
        //
        //            syoukenuktmidasikbnLst.add(C_SyoukenUktMidasiKbn.NKUKT);
        //            uktBnwariList.add(BizNumber.ZERO);
        //            uktnmkjLst.add("");
        //
        //            if (C_UktKbn.KYK.eq(nenkinUketorinin.getUktkbn())) {
        //                uktKbnLst.add(C_SyoukenUktKbn.KYK);
        //            }
        //
        //            else  if (C_UktKbn.HHKN.eq(nenkinUketorinin.getUktkbn())) {
        //                uktKbnLst.add(C_SyoukenUktKbn.HHKN);
        //            }
        //        }
        //
        //        if (pSibouhokenLst != null && pSibouhokenLst.size() > 0) {
        //
        //            for (int i = 0; i < pSibouhokenLst.size(); i++) {
        //
        //                if (C_UktKbn.TOKUTEIMEIGI.eq(pSibouhokenLst.get(i).getUktkbn()) && C_KjkhukaKbn.KJKHUKA.eq(pSibouhokenLst.get(i).getUktnmkjkhukakbn())) {
        //
        //                    sbUktNmKjHukaKbn = C_KjkhukaKbn.KJKHUKA;
        //
        //                    break;
        //                }
        //            }
        //
        //            for (int i = 0;i < pSibouhokenLst.size(); i++) {
        //
        //                if (C_KjkhukaKbn.KJKHUKA.eq(sbUktNmKjHukaKbn)) {
        //
        //                    if (i == 0) {
        //
        //                        if (pKykKihon.getSbuktnin() > 1) {
        //
        //                            if (C_UmuKbn.ARI.eq(sbkyuuhukinuktumu)) {
        //                                syoukenuktmidasikbnLst.add(C_SyoukenUktMidasiKbn.SBKFKUKT);
        //                            } else {
        //                                syoukenuktmidasikbnLst.add(C_SyoukenUktMidasiKbn.SBHKKUKT);
        //                            }
        //
        //                            uktKbnLst.add(C_SyoukenUktKbn.HYOUJIRANNOTOORI);
        //
        //                            uktnmkjLst.add("");
        //                        }
        //                        else {
        //
        //                            if (C_UmuKbn.ARI.eq(sbkyuuhukinuktumu)) {
        //                                syoukenuktmidasikbnLst.add(C_SyoukenUktMidasiKbn.SBKFKUKT);
        //                            } else {
        //                                syoukenuktmidasikbnLst.add(C_SyoukenUktMidasiKbn.SBHKKUKT);
        //                            }
        //
        //                            uktnmkjLst.add("");
        //
        //                            if (C_UktKbn.HHKN.eq(pSibouhokenLst.get(i).getUktkbn())) {
        //
        //                                uktKbnLst.add(C_SyoukenUktKbn.HHKN);
        //                            }
        //                            if (C_UktKbn.KYK.eq(pSibouhokenLst.get(i).getUktkbn())) {
        //
        //                                uktKbnLst.add(C_SyoukenUktKbn.KYK);
        //                            }
        //
        //                            if (C_UktKbn.SOUZOKUNIN.eq(pSibouhokenLst.get(i).getUktkbn())) {
        //
        //                                uktKbnLst.add(C_SyoukenUktKbn.SOUZOKU);
        //                            }
        //
        //                            if (C_UktKbn.TOKUTEIMEIGI.eq(pSibouhokenLst.get(i).getUktkbn())) {
        //
        //                                uktKbnLst.add(C_SyoukenUktKbn.TOKUTEIMEIGI);
        //                            }
        //                        }
        //                    }
        //                }
        //                else {
        //
        //                    if (pKykKihon.getSbuktnin() > 1) {
        //
        //                        if (i == 0) {
        //
        //                            if (C_UmuKbn.ARI.eq(sbkyuuhukinuktumu)) {
        //                                syoukenuktmidasikbnLst.add(C_SyoukenUktMidasiKbn.SBKFKUKT);
        //                            } else {
        //                                syoukenuktmidasikbnLst.add(C_SyoukenUktMidasiKbn.SBHKKUKT);
        //                            }
        //                        }
        //                        else {
        //
        //                            syoukenuktmidasikbnLst.add(C_SyoukenUktMidasiKbn.NONE);
        //                        }
        //                        uktKbnLst.add(C_SyoukenUktKbn.TOKUTEIMEIGI);
        //
        //                        uktBnwariList.add(pSibouhokenLst.get(i).getUktbnwari());
        //                    }
        //                    else {
        //                        if (C_UmuKbn.ARI.eq(sbkyuuhukinuktumu)) {
        //                            syoukenuktmidasikbnLst.add(C_SyoukenUktMidasiKbn.SBKFKUKT);
        //                        } else {
        //                            syoukenuktmidasikbnLst.add(C_SyoukenUktMidasiKbn.SBHKKUKT);
        //                        }
        //
        //                        uktBnwariList.add(BizNumber.ZERO);
        //
        //                        if (C_UktKbn.HHKN.eq(pSibouhokenLst.get(i).getUktkbn())) {
        //
        //                            uktKbnLst.add(C_SyoukenUktKbn.HHKN);
        //                        }
        //                        if (C_UktKbn.KYK.eq(pSibouhokenLst.get(i).getUktkbn())) {
        //
        //                            uktKbnLst.add(C_SyoukenUktKbn.KYK);
        //                        }
        //
        //                        if (C_UktKbn.SOUZOKUNIN.eq(pSibouhokenLst.get(i).getUktkbn())) {
        //
        //                            uktKbnLst.add(C_SyoukenUktKbn.SOUZOKU);
        //                        }
        //
        //                        if (C_UktKbn.TOKUTEIMEIGI.eq(pSibouhokenLst.get(i).getUktkbn())) {
        //
        //                            uktKbnLst.add(C_SyoukenUktKbn.TOKUTEIMEIGI);
        //                        }
        //                    }
        //
        //                    if (C_UktKbn.TOKUTEIMEIGI.eq(pSibouhokenLst.get(i).getUktkbn())) {
        //
        //                        uktnmkjLst.add(pSibouhokenLst.get(i).getUktnmkj());
        //                    }
        //                    else {
        //
        //                        uktnmkjLst.add("");
        //                    }
        //
        //                }
        //                if (i == 0) {
        //
        //                    if (nenkinUketorinin != null) {
        //
        //                        uktnmkj1st = uktnmkjLst.get(i + 1);
        //                    }
        //                    else {
        //
        //                        uktnmkj1st = uktnmkjLst.get(i);
        //                    }
        //
        //                    sbUktNmKjHukaKbn1st = pSibouhokenLst.get(i).getUktnmkjkhukakbn();
        //                }
        //            }
        //        }
        //        else {
        //            if (pKykKihon.getSbuktnin() > 4) {
        //
        //                if (C_UmuKbn.ARI.eq(sbkyuuhukinuktumu)) {
        //                    syoukenuktmidasikbnLst.add(C_SyoukenUktMidasiKbn.SBKFKUKT);
        //                } else {
        //                    syoukenuktmidasikbnLst.add(C_SyoukenUktMidasiKbn.SBHKKUKT);
        //                }
        //
        //                uktKbnLst.add(C_SyoukenUktKbn.HYOUJIRANNOTOORI);
        //
        //                uktnmkjLst.add("");
        //
        //                uktBnwariList.add(BizNumber.ZERO);
        //            }
        //        }
        //
        //        if (pSiteiDairi != null) {
        //
        //            stdrNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        //
        //            syoukenuktmidasikbnLst.add(C_SyoukenUktMidasiKbn.STDR);
        //
        //            if (C_UktKbn.KYK.eq(pSiteiDairi.getUktkbn())) {
        //
        //                uktKbnLst.add(C_SyoukenUktKbn.TOKUTEIMEIGI);
        //
        //                if (!C_KjkhukaKbn.KJKHUKA.eq(pKykSya.getKyknmkjkhukakbn())) {
        //
        //                    uktnmkjLst.add(pKykSya.getKyknmkj());
        //                }
        //                else {
        //
        //                    uktnmkjLst.add("");
        //
        //                    stdrNmKjHukaKbn = pKykSya.getKyknmkjkhukakbn();
        //                }
        //            }
        //
        //            if (C_UktKbn.SBUK.eq(pSiteiDairi.getUktkbn())) {
        //
        //                uktKbnLst.add(C_SyoukenUktKbn.TOKUTEIMEIGI);
        //
        //                uktnmkjLst.add(uktnmkj1st);
        //
        //                stdrNmKjHukaKbn = sbUktNmKjHukaKbn1st;
        //            }
        //
        //            if (C_UktKbn.TOKUTEIMEIGI.eq(pSiteiDairi.getUktkbn())) {
        //
        //                uktKbnLst.add(C_SyoukenUktKbn.TOKUTEIMEIGI);
        //
        //                if (!C_KjkhukaKbn.KJKHUKA.eq(pSiteiDairi.getUktnmkjkhukakbn())) {
        //
        //                    uktnmkjLst.add(pSiteiDairi.getUktnmkj());
        //                }
        //                else {
        //
        //                    uktnmkjLst.add("");
        //
        //                    stdrNmKjHukaKbn = pSiteiDairi.getUktnmkjkhukakbn();
        //                }
        //            }
        //
        //            if(C_UktKbn.NASI.eq(pSiteiDairi.getUktkbn())) {
        //
        //                uktKbnLst.add(C_SyoukenUktKbn.NASI);
        //
        //                uktnmkjLst.add("");
        //            }
        //        }
        //
        //        int syoukenuktmidasikbnLstCnt = syoukenuktmidasikbnLst.size();
        //
        //        for (int i = 0; i < UKETORIHITOLSTMAXCNT - syoukenuktmidasikbnLstCnt; i++) {
        //
        //            syoukenuktmidasikbnLst.add(C_SyoukenUktMidasiKbn.BLNK);
        //
        //        }
        //
        //        int uktKbnLstCnt = uktKbnLst.size();
        //
        //        for (int i = 0; i < UKETORIHITOLSTMAXCNT - uktKbnLstCnt; i++) {
        //
        //            uktKbnLst.add(C_SyoukenUktKbn.BLNK);
        //        }
        //
        //        int uktnmkjLstCnt = uktnmkjLst.size();
        //
        //        for (int i = 0; i < UKETORIHITOLSTMAXCNT - uktnmkjLstCnt; i++) {
        //
        //            uktnmkjLst.add("");
        //        }
        //
        //        int uktBnwariListCnt = uktBnwariList.size();
        //
        //        for (int i = 0; i < UKETORIHITOLSTMAXCNT - uktBnwariListCnt; i++) {
        //
        //            uktBnwariList.add(BizNumber.ZERO);
        //        }
        //
        //
        //        String pmsgcd1 = null;
        //
        //        String pmsgcd2 = null;
        //
        //        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //
        //            if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR) {
        //
        //                pmsgcd1 = "05010";
        //            }
        //
        //            if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
        //
        //                pmsgcd1 = "05012";
        //            }
        //
        //            hokenryou = pSyuKykSyouhnLst.get(0).getHokenryou();
        //
        //            ptuukasyu = kyktuukasyu;
        //
        //            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //
        //                ptokuyakumsgcd = "05020";
        //            }
        //
        //            else if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getGaikanykntkhkumu())) {
        //
        //                ptokuyakumsgcd = "05030";
        //
        //                ptuukasyuNm = pNyknJissekiRirekiLst.get(0).getRstuukasyu().getContent();
        //            }
        //        }
        //        else {
        //
        //            if (yendthnkymd == null){
        //
        //                if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR) {
        //                    pmsgcd1 = "05010";
        //
        //                    hokenryou = pNyknJissekiRirekiLst.get(0).getHrkp();
        //
        //                    ptuukasyu = kyktuukasyu;
        //
        //                    if (C_UmuKbn.ARI.eq(gengakuExistsCheck)) {
        //                        pmsgcd2 = "05020";
        //                    }
        //
        //                    if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                        ptokuyakumsgcd = "05040";
        //                    }
        //
        //                    if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getGaikanykntkhkumu())) {
        //                        ptuukasyuNm = pNyknJissekiRirekiLst.get(0).getRstuukasyu().getContent();
        //                        ptokuyakumsgcd = "05050";
        //                    }
        //                }
        //
        //                if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
        //                    if (C_UmuKbn.ARI.eq(gengakuExistsCheck)) {
        //
        //                        pmsgcd1 = "05012";
        //
        //                        pmsgcd2 = "05022";
        //
        //                    } else {
        //                        pmsgcd1 = "05013";
        //                    }
        //
        //                    hokenryou = pNyknJissekiRirekiLst.get(0).getHrkp();
        //
        //                    ptuukasyu = kyktuukasyu;
        //
        //                    if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                        ptokuyakumsgcd = "05040";
        //                    }
        //
        //                    if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getGaikanykntkhkumu())) {
        //                        ptuukasyuNm = pNyknJissekiRirekiLst.get(0).getRstuukasyu().getContent();
        //                        ptokuyakumsgcd = "05051";
        //                    }
        //                }
        //
        //            } else {
        //                pmsgcd1 = "05011";
        //            }
        //        }
        //
        //        String syukyktkykhknkknmsgkbn1 = null;
        //
        //        String syukyktkykhknkknmsgkbn2 = null;
        //
        //        String syukyktkykhknkknmsgkbn3 = null;
        //
        //        String syukyktkyksmsgkbn1 = null;
        //
        //        String syukyktkyksmsgkbn2 = null;
        //
        //        String syukyktkyksmsgkbn3 = null;
        //
        //        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //
        //            if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR) {
        //                syukyktkykhknkknmsgkbn1 = "01";
        //
        //                syukyktkykhknkknmsgkbn2 = "02";
        //
        //                syukyktkykhknkknmsgkbn3 = "03";
        //
        //                syukyktkykmsgkbn1 = "01";
        //
        //                syukyktkykmsgkbn2 = "02";
        //
        //                syukyktkykmsgkbn3 = "03";
        //
        //                syukyktkykstuukatype3 = kyktuukasyu;
        //
        //                syukyktkykhknkngk3 = pSyuKykSyouhnLst.get(0).getKihons();
        //
        //                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {
        //
        //                    syukyktkyksmsgkbn1 = "03";
        //
        //                    syukyktkyksmsgkbn2 = "04";
        //
        //                    syukyktkyksmsgkbn3 = "05";
        //                }
        //                else {
        //
        //                    syukyktkyksmsgkbn1 = "01";
        //
        //                    syukyktkyksmsgkbn2 = "02";
        //
        //                    syukyktkyksmsgkbn3 = "05";
        //                }
        //            }
        //
        //            if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
        //
        //                syukyktkykmsgkbn1 = "04";
        //
        //                syukyktkyksmsgkbn1 = "06";
        //
        //                syukyktkykhknkknmsgkbn1 = "04";
        //
        //                syukyktkykstuukatype1 = kyktuukasyu;
        //
        //                syukyktkykhknkngk1 = pSyuKykSyouhnLst.get(0).getKihons();
        //            }
        //        }
        //        else {
        //
        //            if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR &&
        //                yendthnkymd == null) {
        //                if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn)) {
        //                    syukyktkykmsgkbn1 = "01";
        //
        //                    syukyktkykmsgkbn2 = "02";
        //
        //                    syukyktkykmsgkbn3 = "03";
        //
        //                    syukyktkykhknkknmsgkbn1 = "01";
        //
        //                    syukyktkykhknkknmsgkbn2 = "04";
        //
        //                    syukyktkykhknkknmsgkbn3 = "02";
        //
        //                    syukyktkykstuukatype3 = kyktuukasyu;
        //
        //                    syukyktkykhknkngk3 = pSyuKykSyouhnLst.get(0).getKihons();
        //
        //                    syutkdai1hknkknymdto1 = dai1hknkknEndYmd;
        //
        //                    syutkdai2hknkknymdto2 = dai2hknkknEndYmd;
        //
        //                }
        //                else if (C_HknKknKbn.DAI2HKNKKN.eq(hknkknkbn)) {
        //
        //                    syukyktkykmsgkbn1 = "04";
        //
        //                    syukyktkykmsgkbn2 = "03";
        //
        //                    syukyktkykhknkknmsgkbn1 = "04";
        //
        //                    syukyktkykhknkknmsgkbn2 = "02";
        //
        //                    syukyktkykstuukatype2 = kyktuukasyu;
        //
        //                    syukyktkykhknkngk2 = pSyuKykSyouhnLst.get(0).getKihons();
        //
        //                    syutkdai2hknkknymdto1 = dai2hknkknEndYmd;
        //
        //                } else {
        //                    syukyktkykmsgkbn1 = "05";
        //
        //                    syukyktkykhknkknmsgkbn1 = "03";
        //
        //                    syukyktkykstuukatype1 =  kyktuukasyu;
        //
        //                    syukyktkykhknkngk1 = pSyuKykSyouhnLst.get(0).getKihons();
        //                }
        //
        //                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {
        //
        //                    if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn)) {
        //
        //                        syukyktkyksmsgkbn1 = "05";
        //
        //                        syukyktkyksmsgkbn2 = "06";
        //
        //                        syukyktkyksmsgkbn3 = "03";
        //                    }
        //
        //                    else if (C_HknKknKbn.DAI2HKNKKN.eq(hknkknkbn)) {
        //                        syukyktkyksmsgkbn1 = "04";
        //
        //                        syukyktkyksmsgkbn2 = "03";
        //                    }
        //
        //                    else {
        //                        syukyktkyksmsgkbn1 = "03";
        //                    }
        //                }
        //                else {
        //
        //                    if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn)) {
        //                        syukyktkyksmsgkbn1 = "01";
        //
        //                        syukyktkyksmsgkbn2 = "02";
        //
        //                        syukyktkyksmsgkbn3 = "03";
        //
        //                    }
        //                    else if (C_HknKknKbn.DAI2HKNKKN.eq(hknkknkbn)) {
        //                        syukyktkyksmsgkbn1 = "04";
        //
        //                        syukyktkyksmsgkbn2 = "03";
        //
        //                    }
        //
        //                    else {
        //                        syukyktkyksmsgkbn1 = "03";
        //
        //                    }
        //                }
        //            }
        //
        //            if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR &&
        //                yendthnkymd != null) {
        //                syukyktkykmsgkbn1 = "05";
        //
        //                syukyktkyksmsgkbn1 = "07";
        //
        //                syukyktkykhknkknmsgkbn1 = "03";
        //
        //                syukyktkykstuukatype1 = kyktuukasyu;
        //
        //                syukyktkykhknkngk1 = pSyuKykSyouhnLst.get(0).getKihons();
        //            }
        //
        //            if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
        //                syukyktkykmsgkbn1 = "05";
        //
        //                syukyktkyksmsgkbn1 = "08";
        //
        //                syukyktkykhknkknmsgkbn1 = "05";
        //
        //                syukyktkykstuukatype1 = kyktuukasyu;
        //
        //                syukyktkykhknkngk1 = pSyuKykSyouhnLst.get(0).getKihons();
        //            }
        //        }
        //
        //        if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR &&
        //            yendthnkymd == null) {
        //
        //            if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //
        //                kykniyustmsgcd1 = "08010";
        //
        //                kykniyustmsgcd2 = "08020";
        //
        //                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {
        //
        //                    kykniyustmsgcd3 = "08030";
        //
        //                    kykniyustmsgcd4 = "08050";
        //
        //                    kykniyustitjbrptuuktype = C_Tuukasyu.JPY;
        //
        //                    kykniyustitjbrp = pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk();
        //
        //                }
        //                else {
        //
        //                    kykniyustmsgcd3 = "08040";
        //                }
        //            }
        //            if (sksyoukenskskbn == SAIHAKKOUHOKENSYOUKEN) {
        //
        //                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {
        //
        //                    if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn)) {
        //                        kykniyustitjbrptuuktype = C_Tuukasyu.JPY;
        //
        //                        kykniyustitjbrp = pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk();
        //
        //                        kykniyustmsgcd1 = "08010";
        //
        //                        kykniyustmsgcd2 = "08020";
        //
        //                        kykniyustmsgcd3 = "08050";
        //
        //                        kykniyustmsgcd4 = "08060";
        //
        //                    }
        //                    else if (C_HknKknKbn.DAI2HKNKKN.eq(hknkknkbn)) {
        //                        kykniyustmsgcd1 = "08040";
        //                    }
        //
        //                }
        //                else {
        //
        //                    if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn)) {
        //                        kykniyustmsgcd1 = "08010";
        //
        //                        kykniyustmsgcd2 = "08020";
        //
        //                        kykniyustmsgcd3 = "08030";
        //
        //                    }
        //                    else if (C_HknKknKbn.DAI2HKNKKN.eq(hknkknkbn)) {
        //                        kykniyustmsgcd1 = "08040";
        //                    }
        //                }
        //            }
        //        }
        //
        //        List<String> stNaiyouranMsgCdList = new ArrayList<>();
        //
        //        if (C_UmuKbn.ARI.eq(nkhknumu)) {
        //            stNaiyouranMsgCdList.add("09001");
        //            nkshrstartymd = pSyuKykSyouhnLst.get(0).getHknkknmanryouymd();
        //
        //            if (C_Nenkinsyu.KAKUTEINENKIN.eq(nksyukbn)) {
        //                stNaiyouranMsgCdList.add("09002");
        //                stNaiyouranMsgCdList.add("09006");
        //                sonotanyrannenkinkkn = BizNumber.valueOf(pSyuKykSyouhnLst.get(0).getNenkinkkn());
        //            }
        //
        //            if (C_Nenkinsyu.SGKHSYSYSNNENKIN.eq(nksyukbn)) {
        //                stNaiyouranMsgCdList.add("09003");
        //                stNaiyouranMsgCdList.add("09007");
        //            }
        //        }
        //
        //        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //
        //            stNaiyouranMsgCdList.add("09010");
        //
        //            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //
        //                stNaiyouranMsgCdList.add("09020");
        //            }
        //
        //            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getGaikanykntkhkumu())) {
        //
        //                stNaiyouranMsgCdList.add("09030");
        //            }
        //
        //            if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
        //
        //                if (kykjisisuurendourate.compareTo(BizNumber.valueOf(100)) == 0) {
        //                    stNaiyouranMsgCdList.add("09042");
        //                    sonotanyransisuutmttkngk = sisuurendouTmttkngk;
        //                }
        //                else if (kykjisisuurendourate.compareTo(BizNumber.ZERO) == 0) {
        //                    stNaiyouranMsgCdList.add("09043");
        //                    sonotanyranteiritutmttkngk = teirituTmttkngk;
        //
        //                } else {
        //                    stNaiyouranMsgCdList.add("09044");
        //                    sonotanyransisuutmttkngk = sisuurendouTmttkngk;
        //                    sonotanyranteiritutmttkngk = teirituTmttkngk;
        //                }
        //
        //                if (kykjisisuurendourate.compareTo(BizNumber.ZERO) > 0) {
        //                    stNaiyouranMsgCdList.add("09045");
        //                    stNaiyouranMsgCdList.add("09046");
        //                    sonotanyransisuunm = sisuunm;
        //                    sonotanyrantmttknzkrtjygn = pSyuKykSyouhnLst.get(0).getTmttknzoukaritujygn();
        //                    sonotanyransetteibairitu = pSyuKykSyouhnLst.get(0).getSetteibairitu();
        //                }
        //            }
        //
        //            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu()) ||
        //                (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu()) && C_TargetTkKbn.SYUUSIN.eq(pKykSonotaTkyk.getTargettkkbn()))) {
        //                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                    stNaiyouranMsgCdList.add("09032");
        //                } else {
        //                    stNaiyouranMsgCdList.add("09034");
        //                }
        //
        //            }
        //
        //            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {
        //                stNaiyouranMsgCdList.add("09038");
        //            }
        //
        //            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getJyudkaigomeharaitkhukaumu())) {
        //
        //                stNaiyouranMsgCdList.add("09040");
        //            }
        //
        //            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getStdrsktkyhkumu())) {
        //
        //                stNaiyouranMsgCdList.add("09050");
        //            }
        //            stNaiyouranMsgCdList.add("09060");
        //
        //            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu()) && C_TargetTkKbn.NENKIN.eq(pKykSonotaTkyk.getTargettkkbn())) {
        //
        //                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                    stNaiyouranMsgCdList.add("09035");
        //                } else {
        //                    stNaiyouranMsgCdList.add("09036");
        //                }
        //            }
        //            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu()) && C_TargetTkKbn.SYUUSIN.eq(pKykSonotaTkyk.getTargettkkbn())) {
        //                if (pKykSonotaTkyk.getTargettkmokuhyouti() > 0) {
        //                    stNaiyouranMsgCdList.add("09070");
        //                }
        //                else {
        //                    stNaiyouranMsgCdList.add("09080");
        //                }
        //            }
        //
        //            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu()) && C_TargetTkKbn.NENKIN.eq(pKykSonotaTkyk.getTargettkkbn())) {
        //
        //                if (pKykSonotaTkyk.getTargettkmokuhyouti() > 0) {
        //                    stNaiyouranMsgCdList.add("09083");
        //                }
        //                else {
        //                    stNaiyouranMsgCdList.add("09084");
        //                }
        //            }
        //
        //            if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR) {
        //                stNaiyouranMsgCdList.add("09090");
        //                stNaiyouranMsgCdList.add("09100");
        //
        //                sonotanyranytirrt = pSyuKykSyouhnLst.get(0).getYoteiriritu();
        //            }
        //
        //            if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
        //                stNaiyouranMsgCdList.add("09110");
        //                stNaiyouranMsgCdList.add("09102");
        //
        //                tumitateriritu = pSyuKykSyouhnLst.get(0).getTumitateriritu();
        //            }
        //
        //        } else {
        //
        //            if (yendthnkymd == null) {
        //                stNaiyouranMsgCdList.add("09010");
        //
        //                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu()) ) {
        //                    stNaiyouranMsgCdList.add("09020");
        //                }
        //
        //                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu()) && C_UmuKbn.ARI.eq(gengakuExistsCheck)) {
        //
        //                    if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR) {
        //                        stNaiyouranMsgCdList.add("09022");
        //                    }
        //
        //                    if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
        //                        stNaiyouranMsgCdList.add("09026");
        //                    }
        //                }
        //
        //                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                    stNaiyouranMsgCdList.add("09024");
        //                }
        //
        //                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getGaikanykntkhkumu())) {
        //                    stNaiyouranMsgCdList.add("09030");
        //                }
        //
        //                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getGaikanykntkhkumu()) && C_UmuKbn.ARI.eq(gengakuExistsCheck)) {
        //
        //                    if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR) {
        //                        stNaiyouranMsgCdList.add("09032");
        //                    }
        //
        //                    if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
        //                        stNaiyouranMsgCdList.add("09031");
        //                    }
        //                }
        //
        //                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getGaikanykntkhkumu())) {
        //                    stNaiyouranMsgCdList.add("09034");
        //                }
        //            }
        //
        //            if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
        //
        //                if (BizDateUtil.compareYmd(pSyuKykSyouhnLst.get(0).getKykymd(), pEditHokenSyoukenParam.getCalckijyunYMD())
        //                    == BizDateUtil.COMPARE_LESSER) {
        //
        //                    if (kykjisisuurendourate.compareTo(BizNumber.valueOf(100)) == 0) {
        //                        stNaiyouranMsgCdList.add("09042");
        //                        sonotanyransisuutmttkngk = sisurendoTmttknInfoBean.getSisuuRendouTmttknGK();
        //                    }
        //                    else if (kykjisisuurendourate.compareTo(BizNumber.ZERO) == 0) {
        //                        stNaiyouranMsgCdList.add("09043");
        //                        sonotanyranteiritutmttkngk = sisurendoTmttknInfoBean.getTeirituTmttknGK();
        //
        //                    } else {
        //                        stNaiyouranMsgCdList.add("09044");
        //                        sonotanyransisuutmttkngk = sisurendoTmttknInfoBean.getSisuuRendouTmttknGK();
        //                        sonotanyranteiritutmttkngk = sisurendoTmttknInfoBean.getTeirituTmttknGK();
        //                    }
        //                }
        //                else {
        //                    if (kykjisisuurendourate.compareTo(BizNumber.valueOf(100)) == 0) {
        //                        stNaiyouranMsgCdList.add("09042");
        //                        sonotanyransisuutmttkngk = sisuurendouTmttkngk;
        //                    }
        //                    else if (kykjisisuurendourate.compareTo(BizNumber.ZERO) == 0) {
        //                        stNaiyouranMsgCdList.add("09043");
        //                        sonotanyranteiritutmttkngk = teirituTmttkngk;
        //
        //                    } else {
        //                        stNaiyouranMsgCdList.add("09044");
        //                        sonotanyransisuutmttkngk = sisuurendouTmttkngk;
        //                        sonotanyranteiritutmttkngk = teirituTmttkngk;
        //                    }
        //                }
        //
        //                if (kykjisisuurendourate.compareTo(BizNumber.ZERO) > 0) {
        //                    stNaiyouranMsgCdList.add("09045");
        //                    stNaiyouranMsgCdList.add("09046");
        //                    sonotanyransisuunm = sisuunm;
        //                    sonotanyrantmttknzkrtjygn = pSyuKykSyouhnLst.get(0).getTmttknzoukaritujygn();
        //                    sonotanyransetteibairitu = pSyuKykSyouhnLst.get(0).getSetteibairitu();
        //                }
        //            }
        //
        //            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu()) ||
        //                (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu()) &&
        //                    C_TargetTkKbn.SYUUSIN.eq(pKykSonotaTkyk.getTargettkkbn()))) {
        //                if (C_UmuKbn.ARI.eq(gengakuExistsCheck)) {
        //                    if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                        stNaiyouranMsgCdList.add("09080");
        //                    } else {
        //                        stNaiyouranMsgCdList.add("09082");
        //                    }
        //                } else {
        //                    if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                        stNaiyouranMsgCdList.add("09084");
        //                    } else {
        //                        stNaiyouranMsgCdList.add("09086");
        //                    }
        //                }
        //            }
        //
        //            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {
        //                stNaiyouranMsgCdList.add("09038");
        //            }
        //
        //            if (yendthnkymd != null &&
        //                syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR) {
        //
        //                stNaiyouranMsgCdList.add("09047");
        //                sonotanyranyensysnhkhnkymd = pSyuKykSyouhnLst.get(0).getYendthnkymd();
        //            }
        //
        //            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getJyudkaigomeharaitkhukaumu())) {
        //
        //                stNaiyouranMsgCdList.add("09040");
        //            }
        //
        //            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getStdrsktkyhkumu())) {
        //
        //                stNaiyouranMsgCdList.add("09050");
        //            }
        //            stNaiyouranMsgCdList.add("09060");
        //
        //            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu()) && C_TargetTkKbn.NENKIN.eq(pKykSonotaTkyk.getTargettkkbn())) {
        //
        //                if (C_UmuKbn.ARI.eq(gengakuExistsCheck)) {
        //                    if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                        stNaiyouranMsgCdList.add("09035");
        //                    } else {
        //                        stNaiyouranMsgCdList.add("09036");
        //                    }
        //                } else {
        //                    if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                        stNaiyouranMsgCdList.add("09033");
        //                    } else {
        //                        stNaiyouranMsgCdList.add("09037");
        //                    }
        //                }
        //            }
        //
        //            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu()) && C_TargetTkKbn.SYUUSIN.eq(pKykSonotaTkyk.getTargettkkbn())) {
        //
        //                stNaiyouranMsgCdList.add("09070");
        //
        //                if (pKykSonotaTkyk.getTargettkmokuhyouti() > 0) {
        //                    stNaiyouranMsgCdList.add("09072");
        //                }
        //                else {
        //                    stNaiyouranMsgCdList.add("09074");
        //                }
        //            }
        //
        //            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu()) && C_TargetTkKbn.NENKIN.eq(pKykSonotaTkyk.getTargettkkbn())) {
        //
        //                if (pKykSonotaTkyk.getTargettkmokuhyouti() > 0) {
        //                    stNaiyouranMsgCdList.add("09083");
        //                }
        //                else {
        //                    stNaiyouranMsgCdList.add("09085");
        //                }
        //            }
        //        }
        //
        //        int stNaiyouranMsgCdListCnt = stNaiyouranMsgCdList.size();
        //
        //        for (int i = 0; i < SONOTANAIYOULSTMAXCNT - stNaiyouranMsgCdListCnt; i++  ) {
        //
        //            stNaiyouranMsgCdList.add("");
        //        }
        //
        //        List<String> drtenCdList = new ArrayList<>();
        //
        //        List<String> oyaDrtenCdList = new ArrayList<>();
        //
        //        List<String> drtenNmList = new ArrayList<>();
        //
        //        List<C_Channelcd> channelCdList = new ArrayList<>();
        //
        //        C_UmuKbn drtenNmLentyoukaUmu = C_UmuKbn.NONE;
        //
        //        if (pKykDairitenLst.size() > 0) {
        //
        //            for (int n = 0; n < pKykDairitenLst.size(); n++) {
        //
        //                drtenCdList.add(pKykDairitenLst.get(n).getDrtencd());
        //            }
        //
        //            BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);
        //
        //            for (int n = 0; n < drtenCdList.size(); n++) {
        //
        //                List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(drtenCdList.get(n));
        //
        //                if (bzGetAgInfoBeanList.get(1).getKanjiHoujinSyougou().length() > 20) {
        //
        //                    drtenNmList.add("");
        //
        //                    drtenNmLentyoukaUmu = C_UmuKbn.ARI;
        //                }
        //                else {
        //                    drtenNmList.add(bzGetAgInfoBeanList.get(1).getKanjiHoujinSyougou());
        //                }
        //                channelCdList.add(bzGetAgInfoBeanList.get(1).getChannelCd());
        //
        //                oyaDrtenCdList.add(bzGetAgInfoBeanList.get(1).getOyadrtenCd());
        //            }
        //
        //            if(oyaDrtenCdList.size() > 1 && oyaDrtenCdList.get(1) != null && oyaDrtenCdList.get(0).equals(oyaDrtenCdList.get(1))) {
        //
        //                drtenNmList.set(1, "");
        //            }
        //        }
        //
        //        int keikanensuu = 0;
        //
        //        int keikanensuuMax = 0;
        //
        //        int hhknnenOutou = 0;
        //
        //        BizDate calcKijyunMaeYmd = null;
        //
        //        SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);
        //
        //        BizDate calcKijyunYmd = setOutoubi.exec(
        //            C_TykzentykgoKbn.TYKGO
        //            , pSyuKykSyouhnLst.get(0).getKykymd()
        //            , C_Hrkkaisuu.NEN
        //            , pEditHokenSyoukenParam.getCalckijyunYMD()
        //            );
        //
        //        calcKijyunMaeYmd = calcKijyunYmd.getPreviousDay();
        //
        //        hhknnenOutou = pSyuKykSyouhnLst.get(0).getHhknnen() + BizDateUtil.calcDifference(calcKijyunYmd, pSyuKykSyouhnLst.get(0).getKykymd()).getYears();
        //
        //        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //            keikanensuu = 1;
        //            keikanensuuMax = dai1hknkkn;
        //
        //        } else {
        //            keikanensuu = BizDateUtil.calcDifference(calcKijyunYmd, pSyuKykSyouhnLst.get(0).getKykymd()).getYears();
        //            keikanensuuMax = dai1hknkkn - (keikanensuu - 1);
        //        }
        //
        //        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //
        //            if (C_UmuKbn.ARI.eq(sbhkuktumu)) {
        //                siboudai1hknkknhrsmsgcd = "12070";
        //
        //                siboudai2hknkknmsgcd1 = "12080";
        //
        //                siboudai2hknkknsmsgcd = "12110";
        //
        //                siboudai3hknkknmsgcd1 = "12120";
        //
        //                siboudai1hknkknigimsgcd = "12050";
        //
        //                if (C_UmuKbn.NONE.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {
        //                    if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                        siboudai1hknkknmsgcdLst.add("12030");
        //
        //                    } else {
        //                        siboudai1hknkknmsgcdLst.add("12040");
        //                    }
        //
        //                }
        //                else {
        //
        //                    siboudai2hknkknmsgcd2 = "12100";
        //
        //                    siboudai3hknkknmsgcd2 = "12140";
        //                }
        //                siboudai1hknkknmsgcdLst.add("12020");
        //            }
        //
        //        }
        //        else {
        //            if (C_UmuKbn.ARI.eq(sbhkuktumu)) {
        //
        //                if (yendthnkymd == null){
        //
        //                    if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn)) {
        //
        //                        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {
        //                            siboudai3hknkknmsgcd2 = "12130";
        //                        }
        //
        //                        siboudai1hknkknmsgcdLst.add("12020");
        //
        //                        siboudai1hknkknhrsmsgcd = "12070";
        //
        //                        siboudai1hknkknigimsgcd = "12050";
        //
        //                        if (hhknnenOutou <= 105) {
        //                            siboudai1hknkknhrsmsgcd2 = "12072";
        //
        //                            siboudai1hknkknigimsgcd2 = "12052";
        //
        //                        } else {
        //                            siboudai1hknkknhrsmsgcd2 = "12074";
        //
        //                            siboudai1hknkknigimsgcd2 = "12054";
        //                        }
        //
        //                    }
        //                    if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn) || C_HknKknKbn.DAI2HKNKKN.eq(hknkknkbn)) {
        //
        //                        siboudai2hknkknmsgcd1 = "12080";
        //
        //                        siboudai2hknkknsmsgcd = "12110";
        //
        //                        if (hhknnenOutou <= 105) {
        //                            siboudai2hknkknsmsgcd2 = "12112";
        //
        //                        } else {
        //                            siboudai2hknkknsmsgcd2 = "12114";
        //
        //                        }
        //                        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())
        //                            && C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn)) {
        //
        //                            siboudai2hknkknmsgcd2 = "12090";
        //                        }
        //                    }
        //
        //                    if (C_UmuKbn.NONE.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {
        //
        //                        if (C_UmuKbn.ARI.eq(gengakuExistsCheck)){
        //                            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                                siboumidasimsgcd2 = "12012";
        //                            }
        //                        }
        //                        else {
        //                            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                                siboumidasimsgcd2 = "12014";
        //                            }
        //                            else {
        //                                siboumidasimsgcd2 = "12016";
        //                            }
        //                        }
        //                    }
        //                    siboudai3hknkknmsgcd1 = "12120";
        //                }
        //                else {
        //                    siboumidasimsgcd2 = "12018";
        //
        //                    sibouitjbrpyentuuktype = C_Tuukasyu.JPY;
        //
        //                    sibouitjbrpyentuukgk = pSyuKykSyouhnLst.get(0).getKihons();
        //                }
        //            }
        //        }
        //
        //        int siboudai1hknkknmsgcdLstCnt = siboudai1hknkknmsgcdLst.size();
        //
        //        for (int i = 0; i < SIBOUDAI1HKNKKNMSGCDCNT - siboudai1hknkknmsgcdLstCnt; i++  ) {
        //
        //            siboudai1hknkknmsgcdLst.add("");
        //        }
        //
        //        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //            if (C_UmuKbn.NONE.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {
        //
        //                sibouitjbrpyentuuktype = C_Tuukasyu.JPY;
        //
        //                sibouitjbrpyentuukgk = kijyungaku;
        //            }
        //        } else {
        //            if (yendthnkymd == null){
        //                if (C_UmuKbn.NONE.eq(gengakuExistsCheck)) {
        //                    if (C_UmuKbn.NONE.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {
        //                        sibouitjbrpyentuuktype = C_Tuukasyu.JPY;
        //
        //                        sibouitjbrpyentuukgk = kijyungaku;
        //
        //                    }
        //                }
        //            }
        //        }
        //
        //        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
        //
        //        List<Integer> dai1skeikanensuuLst = new ArrayList<>();
        //
        //        List<BizDate> dai1sibousnenoutouymd = new ArrayList<>();
        //
        //        List<C_Tuukasyu> dai1stuuktypeLst = new ArrayList<>();
        //
        //        List<BizCurrency> dai1sLst = new ArrayList<>();
        //
        //        List<C_Tuukasyu> dai1syentuuktypeLst = new ArrayList<>();
        //
        //        List<BizCurrency> dai1syenyendakaLst = new ArrayList<>();
        //
        //        List<BizCurrency> dai1syenyenkijyunLst = new ArrayList<>();
        //
        //        List<BizCurrency> dai1syenyenyasuLst = new ArrayList<>();
        //
        //        List<C_UmuKbn> dai1syenyendakaumuLst = new ArrayList<>();
        //
        //        List<C_UmuKbn> dai1syenyenkijyunumuLst = new ArrayList<>();
        //
        //        List<C_UmuKbn> dai1syenyenyasuumuLst = new ArrayList<>();
        //
        //        List<String> syouhnhutaimsgcdLst = new ArrayList<>();
        //
        //        if (!C_Tuukasyu.JPY.eq(pSyuKykSyouhnLst.get(0).getKyktuukasyu())) {
        //
        //            getKawaseRate.exec(
        //                pSyoriYmd.addBusinessDays(-1),
        //                C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
        //                pSyuKykSyouhnLst.get(0).getKyktuukasyu(),
        //                C_Tuukasyu.JPY,
        //                C_KawasetekiyoKbn.TTM,
        //                C_KawasetsryKbn.SYUKKINRATE,
        //                C_EigyoubiHoseiKbn.BLNK,
        //                C_YouhiKbn.HUYOU);
        //
        //            BizNumber yenksykawaserate = getKawaseRate.getKawaserate();
        //
        //            BizNumber kawaserateHendouYenup  = YuyuHozenConfig.getInstance().getKawaserateHendouYenup();
        //
        //            BizNumber kawaserateHendouYendown = YuyuHozenConfig.getInstance().getKawaserateHendouYendown();
        //
        //            skwsrateyenkijyun = yenksykawaserate;
        //
        //            skwsrateyendaka = skwsrateyenkijyun.subtract(kawaserateHendouYenup);
        //
        //            skwsrateyenyasu = skwsrateyenkijyun.add(kawaserateHendouYendown);
        //
        //            if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn)) {
        //                for (int n = 0; n < keikanensuuMax; n++) {
        //
        //                    if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //                        dai1skeikanensuuLst.add(keikanensuu);
        //                        dai1sibousnenoutouymd.add(null);
        //
        //                    }
        //                    else {
        //                        dai1skeikanensuuLst.add(0);
        //                        dai1sibousnenoutouymd.add(calcKijyunYmd);
        //                    }
        //
        //                    CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);
        //
        //                    calcHkShrKngk.exec(pSyuKykSyouhnLst.get(0).getSyouhncd(),
        //                        pSyuKykSyouhnLst.get(0).getSyouhnsdno(),pSyuKykSyouhnLst.get(0).getRyouritusdno(),
        //                        pSyuKykSyouhnLst.get(0).getYoteiriritu(), pKykKihon.getHrkkaisuu(),
        //                        pSyuKykSyouhnLst.get(0).getHknkknsmnkbn(), pSyuKykSyouhnLst.get(0).getHknkkn(),
        //                        pSyuKykSyouhnLst.get(0).getHrkkkn(),pSyuKykSyouhnLst.get(0).getHhknnen(),
        //                        pSyuKykSyouhnLst.get(0).getHhknsei(), pSyuKykSyouhnLst.get(0).getKihons(),
        //                        pSyuKykSyouhnLst.get(0).getKykymd(),calcKijyunMaeYmd, pKykKihon.getSyono(),
        //                        pSyuKykSyouhnLst.get(0).getKyktuukasyu(),syouhnZokusei.getDai1hknkkn(),
        //                        syouhnZokusei.getMvatekikkn(), C_SiinKbn.SP, C_HokenkinsyuruiKbn.SBHOKENKIN,
        //                        pSyuKykSyouhnLst.get(0).getHokenryou(), pSyuKykSyouhnLst.get(0).getKyksjkkktyouseiriritu(),
        //                        pSyuKykSyouhnLst.get(0).getKyksjkkktyouseiriritu(), null, null, null, pSyuKykSyouhnLst.get(0).getTumitateriritu());
        //
        //                    CalcHkShrKngkBean calcHkShrKngkBean1 =  calcHkShrKngk.getCalcHkShrKngkBean();
        //
        //                    dai1stuuktypeLst.add(kyktuukasyu);
        //
        //                    dai1sLst.add(calcHkShrKngkBean1.getSibousGk());
        //
        //                    dai1syentuuktypeLst.add(C_Tuukasyu.JPY);
        //
        //                    BizCurrency dai1syenyendaka = keisanGaikakanzan.exec(
        //                        C_Tuukasyu.JPY,
        //                        calcHkShrKngkBean1.getSibousGk(),
        //                        skwsrateyendaka,
        //                        C_HasuusyoriKbn.AGE);
        //
        //                    BizCurrency dai1syenyenkijyun = keisanGaikakanzan.exec(
        //                        C_Tuukasyu.JPY,
        //                        calcHkShrKngkBean1.getSibousGk(),
        //                        skwsrateyenkijyun,
        //                        C_HasuusyoriKbn.AGE);
        //
        //                    BizCurrency dai1syenyenyasu = keisanGaikakanzan.exec(
        //                        C_Tuukasyu.JPY,
        //                        calcHkShrKngkBean1.getSibousGk(),
        //                        skwsrateyenyasu,
        //                        C_HasuusyoriKbn.AGE);
        //
        //                    if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {
        //
        //                        if (dai1syenyendaka.compareTo(pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk()) < 0 ) {
        //                            dai1syenyendakaLst.add(pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk());
        //                            dai1syenyendakaumuLst.add(C_UmuKbn.ARI);
        //                            maruExistsFlg = C_UmuKbn.ARI;
        //                        } else {
        //                            dai1syenyendakaLst.add(dai1syenyendaka);
        //                            dai1syenyendakaumuLst.add(C_UmuKbn.NONE);
        //                        }
        //
        //                        if (dai1syenyenkijyun.compareTo(pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk()) < 0 ) {
        //                            dai1syenyenkijyunLst.add(pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk());
        //                            dai1syenyenkijyunumuLst.add(C_UmuKbn.ARI);
        //                            maruExistsFlg = C_UmuKbn.ARI;
        //                        } else {
        //                            dai1syenyenkijyunLst.add(dai1syenyenkijyun);
        //                            dai1syenyenkijyunumuLst.add(C_UmuKbn.NONE);
        //                        }
        //
        //                        if (dai1syenyenyasu.compareTo(pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk()) < 0 ) {
        //                            dai1syenyenyasuLst.add(pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk());
        //                            dai1syenyenyasuumuLst.add(C_UmuKbn.ARI);
        //                            maruExistsFlg = C_UmuKbn.ARI;
        //                        } else {
        //                            dai1syenyenyasuLst.add(dai1syenyenyasu);
        //                            dai1syenyenyasuumuLst.add(C_UmuKbn.NONE);
        //                        }
        //                    } else {
        //                        dai1syenyendakaumuLst.add(C_UmuKbn.NONE);
        //                        dai1syenyenkijyunumuLst.add(C_UmuKbn.NONE);
        //                        dai1syenyenyasuumuLst.add(C_UmuKbn.NONE);
        //                        dai1syenyendakaLst.add(dai1syenyendaka);
        //                        dai1syenyenkijyunLst.add(dai1syenyenkijyun);
        //                        dai1syenyenyasuLst.add(dai1syenyenyasu);
        //                    }
        //
        //                    calcKijyunYmd = BizDate.valueOf(calcKijyunYmd.getYear() + 1,pSyuKykSyouhnLst.get(0).getKykymd().getBizDateMD()).getRekijyou();
        //
        //                    calcKijyunMaeYmd = calcKijyunYmd.getPreviousDay();
        //
        //                    keikanensuu = keikanensuu + 1;
        //                }
        //
        //                int dai1syenyenyasuumuLstCnt = dai1syenyenyasuumuLst.size();
        //                for (int i = 0; i < DAI1HKNKKNMAXCNT - dai1syenyenyasuumuLstCnt; i++  ) {
        //                    dai1syenyendakaumuLst.add(C_UmuKbn.NONE);
        //                    dai1syenyenkijyunumuLst.add(C_UmuKbn.NONE);
        //                    dai1syenyenyasuumuLst.add(C_UmuKbn.NONE);
        //                }
        //            }
        //
        //            if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn) || C_HknKknKbn.DAI2HKNKKN.eq(hknkknkbn)) {
        //
        //                dai2stuuktype = kyktuukasyu;
        //
        //                dai2s = pSyuKykSyouhnLst.get(0).getKihons();
        //
        //                dai2syentuuktype = C_Tuukasyu.JPY;
        //
        //                dai2syenyendaka = keisanGaikakanzan.exec(
        //                    C_Tuukasyu.JPY,
        //                    dai2s,
        //                    skwsrateyendaka,
        //                    C_HasuusyoriKbn.AGE);
        //
        //                dai2syenyenkijyun = keisanGaikakanzan.exec(
        //                    C_Tuukasyu.JPY,
        //                    dai2s,
        //                    skwsrateyenkijyun,
        //                    C_HasuusyoriKbn.AGE);
        //
        //                dai2syenyenyasu = keisanGaikakanzan.exec(
        //                    C_Tuukasyu.JPY,
        //                    dai2s,
        //                    skwsrateyenyasu,
        //                    C_HasuusyoriKbn.AGE);
        //            }
        //
        //            dai3stuuktype = kyktuukasyu;
        //
        //            dai3s = pSyuKykSyouhnLst.get(0).getKihons();
        //
        //            dai3syentuuktype = C_Tuukasyu.JPY;
        //
        //            dai3syenyendaka = keisanGaikakanzan.exec(
        //                C_Tuukasyu.JPY,
        //                dai3s,
        //                skwsrateyendaka,
        //                C_HasuusyoriKbn.AGE);
        //
        //            dai3syenyenkijyun = keisanGaikakanzan.exec(
        //                C_Tuukasyu.JPY,
        //                dai3s,
        //                skwsrateyenkijyun,
        //                C_HasuusyoriKbn.AGE);
        //
        //            dai3syenyenyasu = keisanGaikakanzan.exec(
        //                C_Tuukasyu.JPY,
        //                dai3s,
        //                skwsrateyenyasu,
        //                C_HasuusyoriKbn.AGE);
        //
        //            if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn)) {
        //
        //                dai1stuuktypehuryo = kyktuukasyu;
        //
        //                dai1shuryo = pSyuKykSyouhnLst.get(0).getKihons();
        //
        //                dai1syentuuktypehuryo = C_Tuukasyu.JPY;
        //
        //                BizCurrency kihonSyendaka = keisanGaikakanzan.exec(
        //                    C_Tuukasyu.JPY,
        //                    pSyuKykSyouhnLst.get(0).getKihons(),
        //                    skwsrateyendaka,
        //                    C_HasuusyoriKbn.AGE);
        //
        //                if (kihonSyendaka.compareTo(pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk()) < 0 ) {
        //                    dai1syenyendakahuryo = pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk();
        //                    dai1syenyendakaumuhuryo = C_UmuKbn.ARI.toString();
        //                    maruExistsFlg = C_UmuKbn.ARI;
        //                } else {
        //                    dai1syenyendakahuryo = kihonSyendaka;
        //                }
        //
        //                BizCurrency kihonSykijyun = keisanGaikakanzan.exec(
        //                    C_Tuukasyu.JPY,
        //                    pSyuKykSyouhnLst.get(0).getKihons(),
        //                    skwsrateyenkijyun,
        //                    C_HasuusyoriKbn.AGE);
        //
        //                if (kihonSykijyun.compareTo(pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk()) < 0 ) {
        //                    dai1syenyenkijyunhuryo = pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk();
        //                    dai1syenyenkjnumuhuryo = C_UmuKbn.ARI.toString();
        //                    maruExistsFlg = C_UmuKbn.ARI;
        //                } else {
        //                    dai1syenyenkijyunhuryo = kihonSykijyun;
        //                }
        //
        //                BizCurrency kihonSyyenyasu = keisanGaikakanzan.exec(
        //                    C_Tuukasyu.JPY,
        //                    pSyuKykSyouhnLst.get(0).getKihons(),
        //                    skwsrateyenyasu,
        //                    C_HasuusyoriKbn.AGE);
        //
        //                if (kihonSyyenyasu.compareTo(pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk()) < 0 ) {
        //                    dai1syenyenyasuhuryo = pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk();
        //                    dai1syenyenyasuumuhuryo = C_UmuKbn.ARI.toString();
        //                    maruExistsFlg = C_UmuKbn.ARI;
        //                } else {
        //                    dai1syenyenyasuhuryo = kihonSyyenyasu;
        //                }
        //            }
        //
        //            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {
        //                if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn)) {
        //
        //                    siboudai2kjnkngktuuktype = C_Tuukasyu.JPY;
        //                    siboudai2kjnkngk = pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk();
        //                    siboudai3kjnkngktuuktype = C_Tuukasyu.JPY;
        //                    siboudai3kjnkngk = pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk();
        //                }
        //            }
        //        }
        //
        //        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu()) && C_UmuKbn.ARI.eq(sbhkuktumu)) {
        //                if (C_UmuKbn.ARI.eq(maruExistsFlg)) {
        //                    siboudai1hknkknsmrmsgcd = "12072";
        //                } else {
        //                    siboudai1kjnkngktuuktype = C_Tuukasyu.JPY;
        //                    siboudai1kjnkngk = pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk();
        //                    siboudai1hknkknsmrmsgcd = "12074";
        //                }
        //            }
        //        } else {
        //            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu()) && C_UmuKbn.ARI.eq(sbhkuktumu)) {
        //                if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn) && yendthnkymd == null) {
        //                    if (C_UmuKbn.NONE.eq(maruExistsFlg)) {
        //                        siboudai1hknkknsmrmsgcd = "12078";
        //                        siboudai1kjnkngktuuktype = C_Tuukasyu.JPY;
        //                        siboudai1kjnkngk = pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk();
        //                    } else {
        //                        siboudai1hknkknsmrmsgcd = "12076";
        //                    }
        //                }
        //            }
        //        }
        //
        //        if (C_UmuKbn.ARI.eq(nkhknumu)) {
        //
        //            nenkinmsgcdLst.add("12201");
        //
        //            if (C_Nenkinsyu.KAKUTEINENKIN.eq(nksyukbn)) {
        //                nenkinmsgcdLst.add("12203");
        //            }
        //
        //            if (C_Nenkinsyu.SGKHSYSYSNNENKIN.eq(nksyukbn)) {
        //                nenkinmsgcdLst.add("12205");
        //            }
        //
        //            if (C_Tdk.HONNIN.eq(pKykSya.getKkkyktdk()) ||
        //                (nenkinUketorinin != null && C_UktKbn.HHKN.eq(nenkinUketorinin.getUktkbn()))) {
        //                nenkinmsgcdLst.add("12207");
        //            }
        //
        //            if (kykjisisuurendourate.compareTo(BizNumber.valueOf(100)) == 0) {
        //
        //                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu()) &&
        //                    C_TargetTkKbn.NENKIN.eq(pKykSonotaTkyk.getTargettkkbn()) &&
        //                    pKykSonotaTkyk.getTargettkmokuhyouti() > 0) {
        //
        //                    if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //
        //                        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                            nenkinmsgcdLst.add("12209");
        //                        }
        //                        else {
        //                            nenkinmsgcdLst.add("12211");
        //                        }
        //                    }
        //                    else {
        //                        if (C_UmuKbn.NONE.eq(gengakuExistsCheck)) {
        //                            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                                nenkinmsgcdLst.add("12209");
        //                            }
        //                            else {
        //                                nenkinmsgcdLst.add("12211");
        //                            }
        //                        }
        //                        else {
        //                            nenkinmsgcdLst.add("12210");
        //                        }
        //                    }
        //                }
        //
        //                if (C_UmuKbn.NONE.eq(pKykSonotaTkyk.getTargettkhkumu()) ||
        //                    (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu()) &&
        //                        C_TargetTkKbn.NENKIN.eq(pKykSonotaTkyk.getTargettkkbn()) &&
        //                        pKykSonotaTkyk.getTargettkmokuhyouti() == 0)) {
        //
        //                    if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //
        //                        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                            nenkinmsgcdLst.add("12217");
        //                        }
        //                        else {
        //                            nenkinmsgcdLst.add("12219");
        //                        }
        //                    }
        //                    else {
        //                        if (C_UmuKbn.NONE.eq(gengakuExistsCheck)) {
        //                            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                                nenkinmsgcdLst.add("12217");
        //                            }
        //                            else {
        //                                nenkinmsgcdLst.add("12219");
        //                            }
        //                        }
        //                    }
        //                }
        //
        //                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu()) &&
        //                    C_TargetTkKbn.NENKIN.eq(pKykSonotaTkyk.getTargettkkbn()) &&
        //                    pKykSonotaTkyk.getTargettkmokuhyouti() == 0) {
        //                    nenkinmsgcdLst.add("12220");
        //                }
        //            }
        //            else if (kykjisisuurendourate.compareTo(BizNumber.ZERO) == 0) {
        //                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu()) &&
        //                    C_TargetTkKbn.NENKIN.eq(pKykSonotaTkyk.getTargettkkbn()) &&
        //                    pKykSonotaTkyk.getTargettkmokuhyouti() > 0) {
        //
        //                    if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //                        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                            nenkinmsgcdLst.add("12213");
        //                        }
        //                        else {
        //                            nenkinmsgcdLst.add("12215");
        //                        }
        //                    }
        //                    else {
        //                        if (C_UmuKbn.NONE.eq(gengakuExistsCheck)) {
        //                            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                                nenkinmsgcdLst.add("12213");
        //                            }
        //                            else {
        //                                nenkinmsgcdLst.add("12215");
        //                            }
        //                        }
        //                        else {
        //                            nenkinmsgcdLst.add("12212");
        //                        }
        //                    }
        //                }
        //
        //                if (C_UmuKbn.NONE.eq(pKykSonotaTkyk.getTargettkhkumu()) ||
        //                    (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu()) &&
        //                        C_TargetTkKbn.NENKIN.eq(pKykSonotaTkyk.getTargettkkbn()) &&
        //                        pKykSonotaTkyk.getTargettkmokuhyouti() == 0)) {
        //
        //                    if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //                        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                            nenkinmsgcdLst.add("12221");
        //                        }
        //                        else {
        //                            nenkinmsgcdLst.add("12223");
        //                        }
        //                    }
        //                    else {
        //                        if (C_UmuKbn.NONE.eq(gengakuExistsCheck)) {
        //                            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                                nenkinmsgcdLst.add("12221");
        //                            }
        //                            else {
        //                                nenkinmsgcdLst.add("12223");
        //                            }
        //                        }
        //                    }
        //                }
        //
        //                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu()) &&
        //                    C_TargetTkKbn.NENKIN.eq(pKykSonotaTkyk.getTargettkkbn()) &&
        //                    pKykSonotaTkyk.getTargettkmokuhyouti() == 0) {
        //                    nenkinmsgcdLst.add("12220");
        //                }
        //
        //            }
        //            else {
        //
        //                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu()) &&
        //                    C_TargetTkKbn.NENKIN.eq(pKykSonotaTkyk.getTargettkkbn()) &&
        //                    pKykSonotaTkyk.getTargettkmokuhyouti() > 0) {
        //
        //                    if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //                        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                            nenkinmsgcdLst.add("12225");
        //                        }
        //                        else {
        //                            nenkinmsgcdLst.add("12227");
        //                        }
        //                    }
        //                    else {
        //                        if (C_UmuKbn.NONE.eq(gengakuExistsCheck)) {
        //                            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                                nenkinmsgcdLst.add("12225");
        //                            }
        //                            else {
        //                                nenkinmsgcdLst.add("12227");
        //                            }
        //                        }
        //                        else {
        //                            nenkinmsgcdLst.add("12214");
        //                        }
        //                    }
        //                }
        //
        //                if (C_UmuKbn.NONE.eq(pKykSonotaTkyk.getTargettkhkumu()) ||
        //                    ((C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu()) &&
        //                        C_TargetTkKbn.NENKIN.eq(pKykSonotaTkyk.getTargettkkbn()) &&
        //                        pKykSonotaTkyk.getTargettkmokuhyouti() == 0))) {
        //
        //                    if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //                        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                            nenkinmsgcdLst.add("12228");
        //                        }
        //                        else {
        //                            nenkinmsgcdLst.add("12229");
        //                        }
        //                    }
        //                    else {
        //                        if (C_UmuKbn.NONE.eq(gengakuExistsCheck)) {
        //                            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                                nenkinmsgcdLst.add("12228");
        //                            }
        //                            else {
        //                                nenkinmsgcdLst.add("12229");
        //                            }
        //                        }
        //                    }
        //                }
        //
        //                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu()) &&
        //                    C_TargetTkKbn.NENKIN.eq(pKykSonotaTkyk.getTargettkkbn()) &&
        //                    pKykSonotaTkyk.getTargettkmokuhyouti() == 0) {
        //                    nenkinmsgcdLst.add("12220");
        //                }
        //            }
        //        }
        //
        //        if (C_UmuKbn.ARI.eq(sbkyuuhukinuktumu) && C_UmuKbn.ARI.eq(nkhknumu)) {
        //
        //            siboukyhkmsgcdLst.add("12331");
        //
        //            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu()) &&
        //                C_TargetTkKbn.NENKIN.eq(pKykSonotaTkyk.getTargettkkbn()) &&
        //                pKykSonotaTkyk.getTargettkmokuhyouti() > 0) {
        //
        //                if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //                    if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                        siboukyhkmsgcdLst.add("12333");
        //                    }
        //                    else {
        //                        siboukyhkmsgcdLst.add("12335");
        //                    }
        //                }
        //                else {
        //                    if (C_UmuKbn.NONE.eq(gengakuExistsCheck)) {
        //                        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                            siboukyhkmsgcdLst.add("12333");
        //                        }
        //                        else {
        //                            siboukyhkmsgcdLst.add("12335");
        //                        }
        //                    }
        //                    else {
        //                        siboukyhkmsgcdLst.add("12332");
        //                    }
        //                }
        //            }
        //
        //            if (C_UmuKbn.NONE.eq(pKykSonotaTkyk.getTargettkhkumu()) ||
        //                ((C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu()) &&
        //                    C_TargetTkKbn.NENKIN.eq(pKykSonotaTkyk.getTargettkkbn()) &&
        //                    pKykSonotaTkyk.getTargettkmokuhyouti() == 0))) {
        //
        //                if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //                    if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                        siboukyhkmsgcdLst.add("12341");
        //                    }
        //                    else {
        //                        siboukyhkmsgcdLst.add("12343");
        //                    }
        //                }
        //                else {
        //                    if (C_UmuKbn.NONE.eq(gengakuExistsCheck)) {
        //                        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                            siboukyhkmsgcdLst.add("12341");
        //                        }
        //                        else {
        //                            siboukyhkmsgcdLst.add("12343");
        //                        }
        //                    }
        //                }
        //            }
        //            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu()) &&
        //                C_TargetTkKbn.NENKIN.eq(pKykSonotaTkyk.getTargettkkbn()) &&
        //                pKykSonotaTkyk.getTargettkmokuhyouti() == 0) {
        //                siboukyhkmsgcdLst.add("12345");
        //            }
        //
        //            if (C_Nenkinsyu.KAKUTEINENKIN.eq(nksyukbn)) {
        //
        //                if (C_Tdk.HONNIN.eq(pKykSya.getKkkyktdk()) ||
        //                    (nenkinUketorinin != null && C_UktKbn.HHKN.eq(nenkinUketorinin.getUktkbn()))) {
        //
        //                    siboukyhkmsgcdLst.add("12349");
        //                }
        //                else {
        //                    siboukyhkmsgcdLst.add("12351");
        //                }
        //            }
        //
        //            if (C_Nenkinsyu.SGKHSYSYSNNENKIN.eq(nksyukbn)) {
        //
        //                if (C_Tdk.HONNIN.eq(pKykSya.getKkkyktdk()) ||
        //                    (nenkinUketorinin != null && C_UktKbn.HHKN.eq(nenkinUketorinin.getUktkbn()))) {
        //
        //                    siboukyhkmsgcdLst.add("12353");
        //                }
        //                else {
        //                    siboukyhkmsgcdLst.add("12355");
        //                }
        //            }
        //        }
        //
        //        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //
        //            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu()) &&
        //                C_TargetTkKbn.SYUUSIN.eq(pKykSonotaTkyk.getTargettkkbn())) {
        //                if (pKykSonotaTkyk.getTargettkmokuhyouti() > 0) {
        //
        //                    mkhyouyensysnikoumsgcdLst.add("13010");
        //                    mkhyouyensysnikougktype = C_Tuukasyu.JPY;
        //                    mkhyouyensysnikouwra = BizNumber.valueOf(pKykSonotaTkyk.getTargettkmokuhyouti());
        //                }
        //                else {
        //                    mkhyouyensysnikoumsgcdLst.add("13020");
        //                }
        //            }
        //        }
        //        else {
        //            if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR &&
        //                (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu()) && C_TargetTkKbn.SYUUSIN.eq(pKykSonotaTkyk.getTargettkkbn()))) {
        //
        //                mkhyouyensysnikoumsgcdLst.add("13010");
        //                mkhyouyensysnikougktype = C_Tuukasyu.JPY;
        //
        //                if (hhknnenOutou <= 105) {
        //                    mkhyouyensysnikoumsgcdLst.add("13012");
        //                }
        //
        //                if (pKykSonotaTkyk.getTargettkmokuhyouti() > 0) {
        //                    mkhyouyensysnikoumsgcdLst.add("13020");
        //                    mkhyouyensysnikouwra = BizNumber.valueOf(pKykSonotaTkyk.getTargettkmokuhyouti());
        //                }
        //                else {
        //                    mkhyouyensysnikoumsgcdLst.add("13022");
        //                }
        //            }
        //        }
        //
        //        int mkhyouyensysnikoumsgcdCnt = mkhyouyensysnikoumsgcdLst.size();
        //
        //        for (int i = 0; i < MKHYOUYENSYSNIKOUMSGCDMAXCNT - mkhyouyensysnikoumsgcdCnt; i++  ) {
        //
        //            mkhyouyensysnikoumsgcdLst.add("");
        //        }
        //
        //        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getStdrsktkyhkumu())) {
        //
        //            if (C_UmuKbn.NONE.eq(nkhknumu)) {
        //                stdstmmsgcd = "13140";
        //            }
        //            else {
        //                if (C_Tdk.HONNIN.eq(pKykSya.getKkkyktdk())) {
        //
        //                    stdstmmsgcd = "13142";
        //                }
        //                else {
        //
        //                    if (nenkinUketorinin != null && C_UktKbn.HHKN.eq(nenkinUketorinin.getUktkbn())) {
        //
        //                        stdstmmsgcd = "13144";
        //                    }
        //                    else {
        //
        //                        stdstmmsgcd = "13145";
        //                    }
        //                }
        //            }
        //        }
        //
        //        if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR) {
        //
        //            if (yendthnkymd == null){
        //                hutanhiyustmmsgcdueLst.add("13070");
        //            }
        //            else {
        //                if(sksyoukenskskbn == SAIHAKKOUHOKENSYOUKEN) {
        //                    hutanhiyustmmsgcdueLst.add("13071");
        //                }
        //            }
        //
        //            if (C_UmuKbn.ARI.eq(syuusinhknumu) && yendthnkymd == null) {
        //
        //                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                    hutanhiyustmmsgcdst02 = "13122";
        //                }
        //                else if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getGaikanykntkhkumu())) {
        //                    hutanhiyustmmsgcdst02 = "13124";
        //                }
        //                else {
        //                    hutanhiyustmmsgcdst02 = "13120";
        //                }
        //            }
        //        }
        //
        //        if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
        //
        //            if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //
        //                if (kykjisisuurendourate.compareTo(BizNumber.ZERO) > 0) {
        //                    hutanhiyustmmsgcdueLst.add("13073");
        //                }
        //                else {
        //                    hutanhiyustmmsgcdueLst.add("13075");
        //                }
        //            }
        //            else {
        //                if (yendthnkymd == null){
        //
        //                    int hknkkn = pSyuKykSyouhnLst.get(0).getHknkkn();
        //
        //                    if (keikanensuu < hknkkn - 1) {
        //
        //                        if (kykjisisuurendourate.compareTo(BizNumber.ZERO) > 0) {
        //
        //                            hutanhiyustmmsgcdueLst.add("13072");
        //                        }
        //                        else {
        //
        //                            hutanhiyustmmsgcdueLst.add("13073");
        //                        }
        //                    }
        //                    else {
        //
        //                        if (kykjisisuurendourate.compareTo(BizNumber.ZERO) > 0) {
        //
        //                            if (hknkkn == 5) {
        //                                hutanhiyustmmsgcdueLst.add("13074");
        //                            }
        //
        //                            if (hknkkn == 10) {
        //                                hutanhiyustmmsgcdueLst.add("13075");
        //                            }
        //                        }
        //                        else {
        //
        //                            if (hknkkn == 5) {
        //                                hutanhiyustmmsgcdueLst.add("13076");
        //                            }
        //
        //                            if (hknkkn == 10) {
        //                                hutanhiyustmmsgcdueLst.add("13077");
        //                            }
        //                        }
        //                    }
        //                }
        //            }
        //
        //            if (C_UmuKbn.ARI.eq(nkhknumu)) {
        //
        //                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                    hutanhiyustmmsgcdst02 = "13128";
        //                }
        //                else if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getGaikanykntkhkumu())) {
        //                    hutanhiyustmmsgcdst02 = "13130";
        //                }
        //                else {
        //                    hutanhiyustmmsgcdst02 = "13126";
        //                }
        //            }
        //        }
        //
        //        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {
        //
        //            hutanhiyustmmsgcdueLst.add("13080");
        //
        //            hutanhiyustmmsgcdst01 = "13110";
        //
        //            if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR) {
        //                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //
        //                    hutanhiyustmknsnhyuptn = "05";
        //                }
        //                else if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getGaikanykntkhkumu())) {
        //
        //                    hutanhiyustmknsnhyuptn = "06";
        //                }
        //                else {
        //
        //                    hutanhiyustmknsnhyuptn = "04";
        //                }
        //            }
        //        }
        //        else if (yendthnkymd == null) {
        //
        //            hutanhiyustmmsgcdst01 = "13100";
        //
        //            if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR) {
        //                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //
        //                    hutanhiyustmknsnhyuptn = "02";
        //                }
        //                else if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getGaikanykntkhkumu())) {
        //
        //                    hutanhiyustmknsnhyuptn = "03";
        //                }
        //                else {
        //
        //                    hutanhiyustmknsnhyuptn = "01";
        //                }
        //            }
        //        }
        //
        //        if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
        //
        //            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //
        //                hutanhiyustmknsnhyuptn = "08";
        //            }
        //            else if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getGaikanykntkhkumu())) {
        //
        //                hutanhiyustmknsnhyuptn = "09";
        //            }
        //            else {
        //
        //                hutanhiyustmknsnhyuptn = "07";
        //            }
        //        }
        //
        //        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getJyudkaigomeharaitkhukaumu())) {
        //
        //            hutanhiyustmmsgcdueLst.add("13082");
        //        }
        //
        //        if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR) {
        //
        //            if (yendthnkymd == null){
        //
        //                hutanhiyustmmsgcdueLst.add("13090");
        //            }
        //        }
        //
        //        if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
        //
        //            hutanhiyustmmsgcdueLst.add("13091");
        //        }
        //
        //        int hutanhiyustmmsgcdueLsttCnt = hutanhiyustmmsgcdueLst.size();
        //
        //        for (int i = 0; i < HUTANHIYUSTMMSGCDUEMAXCNT - hutanhiyustmmsgcdueLsttCnt; i++  ) {
        //
        //            hutanhiyustmmsgcdueLst.add("");
        //        }
        //
        //
        //        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //
        //            fstpmsgcd = "13150";
        //
        //            fstphrkpkngkkeituuktype = pNyknJissekiRirekiLst.get(0).getRstuukasyu();
        //
        //            fstphrkpkngkkei = pNyknJissekiRirekiLst.get(0).getRsgaku();
        //
        //            fstponegaimsgcd = "13170";
        //
        //            if (C_DirectServiceMosKbn.ENTRY.eq(pKykKihon.getDrctservicemoskbn())
        //                || C_DirectServiceMosKbn.CHECK.eq(pKykKihon.getDrctservicemoskbn())) {
        //
        //                dsmsgcd = "13180";
        //
        //                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu())) {
        //                    if (C_TargetTkKbn.SYUUSIN.eq(pKykSonotaTkyk.getTargettkkbn())) {
        //                        syouhnhutaimsgcdLst.add("13190");
        //                    }
        //
        //                    if (C_TargetTkKbn.NENKIN.eq(pKykSonotaTkyk.getTargettkkbn())) {
        //                        syouhnhutaimsgcdLst.add("13192");
        //                    }
        //
        //                }  else {
        //                    if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {
        //                        syouhnhutaimsgcdLst.add("13200");
        //                    } else {
        //                        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                            syouhnhutaimsgcdLst.add("13210");
        //                        } else {
        //                            syouhnhutaimsgcdLst.add("13220");
        //                        }
        //                    }
        //                }
        //            }
        //
        //            toiawasesakihanyoumsgcd = "13240";
        //
        //            annaihanyoumsgcd = "13250";
        //
        //            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                koujyosyoumeimsgcd1 = "15040";
        //
        //            } else {
        //                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu()) ||
        //                    (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu()) && C_TargetTkKbn.SYUUSIN.eq(pKykSonotaTkyk.getTargettkkbn()))) {
        //                    koujyosyoumeimsgcd1 = "15042";
        //                }
        //
        //                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu()) && C_TargetTkKbn.NENKIN.eq(pKykSonotaTkyk.getTargettkkbn())) {
        //                    koujyosyoumeimsgcd1 = "15043";
        //                }
        //
        //
        //                if (C_UmuKbn.NONE.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu()) &&
        //                    C_UmuKbn.NONE.eq(pKykSonotaTkyk.getTargettkhkumu())) {
        //                    koujyosyoumeimsgcd1 = "15044";
        //                }
        //            }
        //        }
        //
        //        int syouhnhutaimsgcdLstLstCnt = syouhnhutaimsgcdLst.size();
        //
        //        for (int i = 0; i < SYOUHNHUTAIMSGCDLSTMAXCNT - syouhnhutaimsgcdLstLstCnt; i++  ) {
        //
        //            syouhnhutaimsgcdLst.add("");
        //        }
        //
        //        List<C_TokusyuSyoriNaiyouKbn> tokusyuSyoriNaiyouKbnList = new ArrayList<>();
        //
        //        if (C_HassouKbn.HONSYAKAISOU.eq(pHassouKbn)) {
        //
        //            tokusyuSyoriNaiyouKbnList.add(C_TokusyuSyoriNaiyouKbn.TTDKTYUUI_DNGNMEMOARI);
        //        }
        //
        //        int tokusyuSyoriNaiyouKbnListCnt = tokusyuSyoriNaiyouKbnList.size();
        //
        //        for (int i = 0; i < 17 - tokusyuSyoriNaiyouKbnListCnt; i++) {
        //
        //            tokusyuSyoriNaiyouKbnList.add(null);
        //        }
        //
        //        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //            getKawaseRate.exec(
        //                pNyknJissekiRirekiLst.get(0).getRyosyuymd(),
        //                C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
        //                pSyuKykSyouhnLst.get(0).getKyktuukasyu(),
        //                C_Tuukasyu.JPY,
        //                C_KawasetekiyoKbn.TTM,
        //                C_KawasetsryKbn.NYUKINRATE,
        //                C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
        //                C_YouhiKbn.HUYOU);
        //
        //            sonotanyranenkhrikmrate = getKawaseRate.getKawaserate();
        //        }
        //        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getGaikanykntkhkumu())) {
        //            C_Tuukasyu tuukasyu = C_Tuukasyu.BLNK;
        //
        //            if(C_Tuukasyu.USD.eq(pSyuKykSyouhnLst.get(0).getKyktuukasyu())) {
        //                tuukasyu = C_Tuukasyu.AUD;
        //            }
        //            else {
        //                tuukasyu = C_Tuukasyu.USD;
        //            }
        //            getKawaseRate.exec(
        //                pNyknJissekiRirekiLst.get(0).getRyosyuymd(),
        //                C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
        //                pSyuKykSyouhnLst.get(0).getKyktuukasyu(),
        //                tuukasyu,
        //                C_KawasetekiyoKbn.TTM,
        //                C_KawasetsryKbn.NYUKINRATE,
        //                C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
        //                C_YouhiKbn.HUYOU);
        //
        //            sonotanyranstigikwsrate = getKawaseRate.getKawaserate();
        //        }
        //
        //        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //            kyksjkkktyouseiriritu = pSyuKykSyouhnLst.get(0).getKyksjkkktyouseiriritu();
        //
        //            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu()) ||
        //                C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu())) {
        //                if (C_UmuKbn.NONE.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                    sonotanyrankjnkngktuktype = C_Tuukasyu.JPY;
        //                    sonotanyrankjnkngkrate = fstpnyknymdrate;
        //                    sonotanyrankjnkngktuuka = "円";
        //                    sonotanyrankjnkngk = kijyungaku;
        //                }
        //            }
        //
        //            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu()) || C_UmuKbn.ARI.eq(pKykSonotaTkyk.getGaikanykntkhkumu())) {
        //                sonotanyrannykntuktype =pNyknJissekiRirekiLst.get(0).getRstuukasyu();
        //                sonotanyrannykntuukap = pNyknJissekiRirekiLst.get(0).getRsgaku();
        //                sonotanyrannykntuukasyu = pNyknJissekiRirekiLst.get(0).getRstuukasyu().getContent();
        //
        //            }
        //            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu()) && pKykSonotaTkyk.getTargettkmokuhyouti() > 0) {
        //                sonotanyranpentuktype = C_Tuukasyu.JPY;
        //                sonotanyranmkhwariai = BizNumber.valueOf(pKykSonotaTkyk.getTargettkmokuhyouti());
        //                sonotanyranpenknsngk = kijyungaku;
        //            }
        //
        //        } else {
        //            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu()) ||
        //                C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu())) {
        //                if (C_UmuKbn.ARI.eq(gengakuExistsCheck)) {
        //                    sonotanyrankjnkngktuktype = C_Tuukasyu.JPY;
        //                    sonotanyrankjnkngk = kijyungaku;
        //
        //                } else {
        //                    if (C_UmuKbn.NONE.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                        sonotanyrankjnkngktuktype = C_Tuukasyu.JPY;
        //                        sonotanyrankjnkngk = kijyungaku;
        //                    }
        //                }
        //                if (C_UmuKbn.NONE.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                    sonotanyrankjnkngkrate = fstpnyknymdrate;
        //                    sonotanyrankjnkngktuuka = "円";
        //                }
        //            }
        //            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu()) ||
        //                C_UmuKbn.ARI.eq(pKykSonotaTkyk.getGaikanykntkhkumu())) {
        //                sonotanyrannykntuktype =pNyknJissekiRirekiLst.get(0).getRstuukasyu();
        //                sonotanyrannykntuukap = pNyknJissekiRirekiLst.get(0).getRsgaku();
        //                sonotanyrannykntuukasyu = pNyknJissekiRirekiLst.get(0).getRstuukasyu().getContent();
        //            }
        //            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu()) && pKykSonotaTkyk.getTargettkmokuhyouti() > 0) {
        //                sonotanyranpentuktype = C_Tuukasyu.JPY;
        //                sonotanyranmkhwariai = BizNumber.valueOf(pKykSonotaTkyk.getTargettkmokuhyouti());
        //                sonotanyranpenknsngk = kijyungaku;
        //            }
        //
        //        }
        //
        //
        //        int hhknnen = 0;
        //
        //        BizDate kgmaehrtkdai1hknkknmnryymd = null;
        //
        //        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //
        //            hhknnen = pSyuKykSyouhnLst.get(0).getHhknnen() + dai1hknkkn;
        //
        //            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getJyudkaigomeharaitkhukaumu())) {
        //                kaigomaehrtkykmsgcd1 = "13030";
        //                kaigomaehrtkykkyktuuka = kyktuukasyuNm;
        //                kaigomaehrjrugktype = kyktuukasyu;
        //                kaigomaehrtkykmsgcdst1 = "13050";
        //                if(pKykSonotaTkyk.getStdrsktkyhkumu().eq(C_UmuKbn.ARI)) {
        //                    kaigomaehrtkykstdmsgcd = "13060";
        //                }
        //            }
        //        } else {
        //            if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn)) {
        //
        //                hhknnen = pSyuKykSyouhnLst.get(0).getHhknnen() + dai1hknkkn;
        //            } else {
        //                hhknnen = pSyuKykSyouhnLst.get(0).getHhknnen()
        //                    + BizDateUtil.calcDifference(calcKijyunYmd, pSyuKykSyouhnLst.get(0).getKykymd()).getYears();
        //            }
        //
        //            if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR &&
        //                C_UmuKbn.ARI.eq(pKykSonotaTkyk.getJyudkaigomeharaitkhukaumu())) {
        //
        //                if (yendthnkymd == null) {
        //                    kaigomaehrtkykmsgcd1 = "13030";
        //                    kaigomaehrtkykkyktuuka = kyktuukasyuNm;
        //                    kaigomaehrtkykmsgcdst1 = "13050";
        //
        //                    if (hhknnen <= 105) {
        //                        kaigomaehrtkykmsgcd2 = "13032";
        //                        kaigomaehrjrugktype = kyktuukasyu;
        //                    } else {
        //                        kaigomaehrtkykmsgcd2 = "13034";
        //                    }
        //                }
        //                else {
        //                    IT_KykSyouhnHnkmae kykSyouhnHnkmae = hozenDomManager.getKykSyouhnHnkmaeBySyono(pKykKihon.getSyono());
        //
        //                    kgmaehrtkdai1hknkknmnryymd = BizDateUtil.getDateAfterPeriod
        //                        (pSyuKykSyouhnLst.get(0).getKykymd(), kykSyouhnHnkmae.getDai1hknkkn(), 0).getPreviousDay();
        //                    kaigomaehrtkykmsgcd1 = "13036";
        //                    kaigomaehrtkykkyktuuka = kyktuukasyuNm;
        //                    kaigomaehrtkykmsgcdst1 = "13052";
        //
        //                    if (hhknnen <= 105) {
        //                        kaigomaehrtkykmsgcd2 = "13038";
        //                        kaigomaehrjrugktype = kyktuukasyu;
        //                    }
        //                }
        //
        //                if(pKykSonotaTkyk.getStdrsktkyhkumu().eq(C_UmuKbn.ARI)) {
        //                    kaigomaehrtkykstdmsgcd = "13060";
        //                }
        //            }
        //        }
        //
        //        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getJyudkaigomeharaitkhukaumu())) {
        //            if (hhknnen <= 65) {
        //                kaigomaehrsikuhhknnen = 65;
        //            } else if (hhknnen <= 70){
        //                kaigomaehrsikuhhknnen = 70;
        //            } else if (hhknnen <= 75){
        //                kaigomaehrsikuhhknnen = 75;
        //            } else if (hhknnen <= 80){
        //                kaigomaehrsikuhhknnen = 80;
        //            } else if (hhknnen <= 85){
        //                kaigomaehrsikuhhknnen = 85;
        //            } else if (hhknnen <= 90){
        //                kaigomaehrsikuhhknnen = 90;
        //            } else if (hhknnen <= 95){
        //                kaigomaehrsikuhhknnen = 95;
        //            } else if (hhknnen <= 100){
        //                kaigomaehrsikuhhknnen = 100;
        //            } else if (hhknnen <= 105){
        //                kaigomaehrsikuhhknnen = 105;
        //            }
        //
        //            BizCurrency b = null;
        //            BizCurrency w = null;
        //
        //            if(C_Tuukasyu.USD.eq(kyktuukasyu)) {
        //                b = BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR);
        //                w = BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR);
        //            } else {
        //                b = BizCurrency.valueOf(10000, BizCurrencyTypes.AU_DOLLAR);
        //                w = BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR);
        //            }
        //
        //            for (; kaigomaehrsikuhhknnen <= 105; ) {
        //
        //                CalcJdkghkKngk calcJdkghkKngk = SWAKInjector.getInstance(CalcJdkghkKngk.class);
        //
        //                calcJdkghkKngk.exec(
        //                    C_JydkgmbHkKsnKbn.NENREISITEI
        //                    , b
        //                    , w
        //                    , yoteiriritu
        //                    , null
        //                    , null
        //                    , null
        //                    , kaigomaehrsikuhhknnen
        //                    , pHhknSya.getHhknsei()
        //                    );
        //
        //                CalcJdkghkKngkBean calcJdkghkKngkBean =  calcJdkghkKngk.getCalcJdkghkKngkBean();
        //
        //                kaigomaehrsikuhhknnenLst.add(kaigomaehrsikuhhknnen);
        //
        //                kaigomaehrstikknLst.add(calcJdkghkKngkBean.getWaribikiKikan());
        //
        //                kaigomaehrjrugkLst.add(calcJdkghkKngkBean.getJdkghkKnGk());
        //
        //                kaigomaehrsikuhhknnen = kaigomaehrsikuhhknnen + 5;
        //            }
        //
        //            if (hhknnen <= 105) {
        //                kaigomaehruktgkumu = C_UmuKbn.ARI;
        //            } else {
        //                kaigomaehruktgkumu = C_UmuKbn.NONE;
        //            }
        //        }
        //
        //
        //        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //
        //            if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR) {
        //                wtyuuijikoumsgcdLst.add("14020");
        //                witijibrptuktype = kyktuukasyu;
        //                witijibrp = hokenryou;
        //                wmsgcd1 = "14010";
        //
        //                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                    wtyuuijikoumsgcdLst.add("14030");
        //                    wyenhrkgktuktype = C_Tuukasyu.JPY;
        //                    wyenhrkgk = pNyknJissekiRirekiLst.get(0).getRsgaku();
        //                } else {
        //                    wtyuuijikoumsgcdLst.add("14040");
        //                    wyenitijibrptuktype = C_Tuukasyu.JPY;
        //                    wyenitijibrp  = kijyungaku;
        //                }
        //                wtyuuijikoumsgcdLst.add("14050");
        //
        //                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu()) && C_TargetTkKbn.SYUUSIN.eq(pKykSonotaTkyk.getTargettkkbn())) {
        //                    if (pKykSonotaTkyk.getTargettkmokuhyouti() > 0) {
        //                        wtyuuijikoumsgcdLst.add("14060");
        //                    }
        //                    else {
        //                        wtyuuijikoumsgcdLst.add("14070");
        //                    }
        //                }
        //            }
        //
        //            if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
        //
        //                witijibrptuktype = kyktuukasyu;
        //                witijibrp = hokenryou;
        //
        //                if (kykjisisuurendourate.compareTo(BizNumber.ZERO) > 0) {
        //
        //                    wmsgcd1 = "14013";
        //
        //                    wmsgcd2_1 = "14014";
        //
        //                    wmsgcd3_1 = "14015";
        //
        //                } else {
        //                    wmsgcd1 = "14016";
        //                }
        //
        //                if (kykjisisuurendourate.compareTo(BizNumber.valueOf(100)) == 0) {
        //
        //                    wtyuuijikoumsgcdLst.add("14028");
        //                }
        //                else if (kykjisisuurendourate.compareTo(BizNumber.ZERO) == 0) {
        //                    wtyuuijikoumsgcdLst.add("14021");
        //                }
        //                else {
        //                    wtyuuijikoumsgcdLst.add("14025");
        //                }
        //
        //                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                    wtyuuijikoumsgcdLst.add("14027");
        //                    wyenhrkgktuktype = C_Tuukasyu.JPY;
        //                    wyenhrkgk = pNyknJissekiRirekiLst.get(0).getRsgaku();
        //
        //                } else {
        //                    wtyuuijikoumsgcdLst.add("14029");
        //                    wyenitijibrptuktype = C_Tuukasyu.JPY;
        //                    wyenitijibrp  = kijyungaku;
        //                }
        //
        //                if (kykjisisuurendourate.compareTo(BizNumber.ZERO) > 0) {
        //                    wtyuuijikoumsgcdLst.add("14052");
        //                }
        //                else {
        //                    wtyuuijikoumsgcdLst.add("14055");
        //                }
        //
        //                if (C_UmuKbn.ARI.eq(nkhknumu)) {
        //
        //                    if (pSyuKykSyouhnLst.get(0).getHknkkn() == 5) {
        //
        //                        wtyuuijikoumsgcdLst.add("14053");
        //                    }
        //
        //                    if (pSyuKykSyouhnLst.get(0).getHknkkn() == 10) {
        //
        //                        wtyuuijikoumsgcdLst.add("14054");
        //                    }
        //                }
        //
        //                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu()) && C_TargetTkKbn.NENKIN.eq(pKykSonotaTkyk.getTargettkkbn())) {
        //
        //                    if (pKykSonotaTkyk.getTargettkmokuhyouti() > 0) {
        //                        wtyuuijikoumsgcdLst.add("14062");
        //                    }
        //                    else {
        //                        wtyuuijikoumsgcdLst.add("14072");
        //                    }
        //                }
        //            }
        //
        //        } else {
        //            if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR) {
        //
        //                if (yendthnkymd == null){
        //
        //                    if (hhknnenOutou <= 105) {
        //
        //                        if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn) || C_HknKknKbn.DAI2HKNKKN.eq(hknkknkbn)) {
        //                            wtyuuijikoumsgcdLst.add("14020");
        //                        } else {
        //                            wtyuuijikoumsgcdLst.add("14022");
        //                        }
        //
        //                        if (C_UmuKbn.NONE.eq(gengakuExistsCheck)) {
        //                            wtyuuijikoumsgcdLst.add("14030");
        //                            witijibrptuktype = kyktuukasyu;
        //                            witijibrp = hokenryou;
        //
        //                            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                                wtyuuijikoumsgcdLst.add("14032");
        //                                wyenhrkgktuktype = C_Tuukasyu.JPY;
        //                                wyenhrkgk = pNyknJissekiRirekiLst.get(0).getRsgaku();
        //
        //                            } else {
        //                                wyenitijibrptuktype = C_Tuukasyu.JPY;
        //                                wyenitijibrp  = kijyungaku;
        //                                wtyuuijikoumsgcdLst.add("14034");
        //                            }
        //                        }
        //
        //                        if (C_HknKknKbn.DAI1HKNKKN.eq(hknkknkbn) || C_HknKknKbn.DAI2HKNKKN.eq(hknkknkbn)) {
        //                            wtyuuijikoumsgcdLst.add("99003");
        //                            wmsgcd2 = "99002";
        //                        }
        //
        //                        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu()) && C_TargetTkKbn.SYUUSIN.eq(pKykSonotaTkyk.getTargettkkbn())) {
        //                            if (pKykSonotaTkyk.getTargettkmokuhyouti() > 0) {
        //                                wtyuuijikoumsgcdLst.add("14060");
        //                            }
        //                            else {
        //                                wtyuuijikoumsgcdLst.add("14062");
        //                            }
        //                        }
        //                        wmsgcd1 = "14010";
        //                    }
        //                }
        //                else {
        //                    wmsgcd1 = "14021";
        //                    wmsgcdst = "14080";
        //                }
        //            }
        //
        //            if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
        //
        //                if (kykjisisuurendourate.compareTo(BizNumber.ZERO) > 0) {
        //
        //                    if (pSyuKykSyouhnLst.get(0).getHknkkn() - keikanensuu > 2) {
        //                        wmsgcd1 = "14011";
        //
        //                        wmsgcd2_1 = "14017";
        //
        //                        wmsgcd3_1 = "14018";
        //
        //                        if (kykjisisuurendourate.compareTo(BizNumber.valueOf(100)) == 0) {
        //
        //                            wtyuuijikoumsgcdLst.add("14024");
        //                        }
        //                        else {
        //                            wtyuuijikoumsgcdLst.add("14041");
        //                        }
        //                    }
        //
        //                    if (pSyuKykSyouhnLst.get(0).getHknkkn() - keikanensuu == 1) {
        //                        wmsgcd2_1 = "14025";
        //
        //                        wmsgcd3_1 = "14027";
        //
        //                        if (kykjisisuurendourate.compareTo(BizNumber.valueOf(100)) == 0) {
        //
        //                            wtyuuijikoumsgcdLst.add("14026");
        //                        }
        //                        else {
        //                            wtyuuijikoumsgcdLst.add("14043");
        //                        }
        //                    }
        //                }
        //                else {
        //                    wmsgcd1 = "14019";
        //                    wtyuuijikoumsgcdLst.add("14028");
        //                }
        //
        //                if (C_UmuKbn.NONE.eq(gengakuExistsCheck)){
        //
        //                    if (kykjisisuurendourate.compareTo(BizNumber.ZERO) > 0) {
        //
        //                        witijibrptuktype = kyktuukasyu;
        //                        witijibrp = hokenryou;
        //
        //                        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                            wtyuuijikoumsgcdLst.add("14038");
        //                            wyenhrkgktuktype = C_Tuukasyu.JPY;
        //                            wyenhrkgk = pNyknJissekiRirekiLst.get(0).getRsgaku();
        //
        //                        } else {
        //                            wyenitijibrptuktype = C_Tuukasyu.JPY;
        //                            wyenitijibrp  = kijyungaku;
        //                            wtyuuijikoumsgcdLst.add("14040");
        //                        }
        //                    }
        //                    else {
        //
        //                        witijibrptuktype = kyktuukasyu;
        //                        witijibrp = hokenryou;
        //
        //                        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
        //                            wtyuuijikoumsgcdLst.add("14044");
        //                            wyenhrkgktuktype = C_Tuukasyu.JPY;
        //                            wyenhrkgk = pNyknJissekiRirekiLst.get(0).getRsgaku();
        //
        //                        } else {
        //                            wyenitijibrptuktype = C_Tuukasyu.JPY;
        //                            wyenitijibrp  = kijyungaku;
        //                            wtyuuijikoumsgcdLst.add("14046");
        //                        }
        //                    }
        //                }
        //
        //                if (kykjisisuurendourate.compareTo(BizNumber.ZERO) > 0) {
        //
        //                    if (pSyuKykSyouhnLst.get(0).getHknkkn() - keikanensuu > 2) {
        //
        //                        wtyuuijikoumsgcdLst.add("14051");
        //                    }
        //
        //                    if (pSyuKykSyouhnLst.get(0).getHknkkn() - keikanensuu == 1) {
        //
        //                        wtyuuijikoumsgcdLst.add("14052");
        //                    }
        //
        //                }
        //                else {
        //                    wtyuuijikoumsgcdLst.add("14056");
        //                }
        //
        //                if (C_UmuKbn.ARI.eq(nkhknumu)) {
        //
        //                    if (pSyuKykSyouhnLst.get(0).getHknkkn() == 5) {
        //
        //                        wtyuuijikoumsgcdLst.add("14053");
        //                    }
        //
        //                    if (pSyuKykSyouhnLst.get(0).getHknkkn() == 10) {
        //
        //                        wtyuuijikoumsgcdLst.add("14054");
        //                    }
        //                }
        //
        //                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu()) && C_TargetTkKbn.NENKIN.eq(pKykSonotaTkyk.getTargettkkbn())) {
        //
        //                    if (pKykSonotaTkyk.getTargettkmokuhyouti() > 0) {
        //                        wtyuuijikoumsgcdLst.add("14074");
        //                    }
        //                    else {
        //                        wtyuuijikoumsgcdLst.add("14076");
        //                    }
        //                }
        //            }
        //        }
        //
        //        int wtyuuijikoumsgcdLstCnt = wtyuuijikoumsgcdLst.size();
        //
        //        for (int i = 0; i < WTYUUIJIKOUMSGCDMAXCNT - wtyuuijikoumsgcdLstCnt; i++  ) {
        //
        //            wtyuuijikoumsgcdLst.add("");
        //        }
        //
        //        IT_HokenSyouken hokenSyouken = pKykKihon.createHokenSyouken();
        //
        //        hokenSyouken.setTyouhyouymd(sysDate);
        //
        //        hokenSyouken.setHenkousikibetukey(henkouSikibetuKey);
        //
        //        hokenSyouken.setSyohakkouymd(syoHakkoubi);
        //
        //        hokenSyouken.setSinsaihkkbn(pSinsaihkKbn);
        //
        //        if(sksyoukenskskbn == SAIHAKKOUHOKENSYOUKEN) {
        //
        //            hokenSyouken.setSyoukensaihkkbn(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        //        }
        //        else {
        //
        //            hokenSyouken.setSyoukensaihkkbn(pEditHokenSyoukenParam.getSyoukenSaihk());
        //        }
        //
        //        hokenSyouken.setStdrsktirasidouhuukbn(stdrsktirasidouhuukbn);
        //
        //        hokenSyouken.setDstirasidouhuukbn(dsTirasiDouhuuKbn);
        //
        //        hokenSyouken.setSyotnshuyoupostumukbn(tnsHuyouPostUmuKbn);
        //
        //        hokenSyouken.setInsizeishryouhikbn(pEditHokenSyoukenParam.getInsizeiShryouhi());
        //
        //        hokenSyouken.setHassoukbn(C_HassouKbn.HONSYAKAISOU);
        //
        //        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //
        //            hokenSyouken.setKoujyosyoumeiumukbn(C_UmuKbn.ARI);
        //        }
        //        else {
        //
        //            hokenSyouken.setKoujyosyoumeiumukbn(C_UmuKbn.NONE);
        //        }
        //
        //        if (sksyoukenskskbn == SAIHAKKOUHOKENSYOUKEN) {
        //
        //            hokenSyouken.setKanryoutuutiumukbn(C_UmuKbn.ARI);
        //        }
        //        else {
        //
        //            hokenSyouken.setKanryoutuutiumukbn(C_UmuKbn.NONE);
        //        }
        //
        //        hokenSyouken.setSuiihyouumukbn(C_UmuKbn.ARI);
        //
        //        if (hyoujiranleftmsgcdLst.size() > 0) {
        //            hokenSyouken.setHyoujiranhidarimsgcd1(hyoujiranleftmsgcdLst.get(0));
        //        }
        //
        //        if (hyoujiranleftmsgcdLst.size() > 1) {
        //            hokenSyouken.setHyoujiranhidarimsgcd2(hyoujiranleftmsgcdLst.get(1));
        //        }
        //
        //        if (hyoujiranleftmsgcdLst.size() > 2) {
        //            hokenSyouken.setHyoujiranhidarimsgcd3(hyoujiranleftmsgcdLst.get(2));
        //        }
        //
        //        if (hyoujiranleftmsgcdLst.size() > 3) {
        //            hokenSyouken.setHyoujiranhidarimsgcd4(hyoujiranleftmsgcdLst.get(3));
        //        }
        //
        //        if (hyoujiranleftmsgcdLst.size() > 4) {
        //            hokenSyouken.setHyoujiranhidarimsgcd5(hyoujiranleftmsgcdLst.get(4));
        //        }
        //
        //        if (hyoujiranleftmsgcdLst.size() > 5) {
        //            hokenSyouken.setHyoujiranhidarimsgcd6(hyoujiranleftmsgcdLst.get(5));
        //        }
        //
        //        if (hyoujiranleftmsgcdLst.size() > 6) {
        //            hokenSyouken.setHyoujiranhidarimsgcd7(hyoujiranleftmsgcdLst.get(6));
        //        }
        //
        //        hokenSyouken.setHyoujiranhidarimsgcd8("");
        //
        //        hokenSyouken.setHyoujiranhidarimsgcd9("");
        //
        //        hokenSyouken.setHyoujiranhidarimsgcd10("");
        //
        //        hokenSyouken.setHyoujiranhidarimsgcd11("");
        //
        //        hokenSyouken.setHyoujiranhidarimsgcd12("");
        //
        //        hokenSyouken.setHyoujiranhidarimsgcd13("");
        //
        //        hokenSyouken.setHyoujiranhidarimsgcd14("");
        //
        //        hokenSyouken.setHyoujiranhidarimsgcd15("");
        //
        //        hokenSyouken.setHyoujiranhidarimsgcd16("");
        //
        //        hokenSyouken.setHyoujiranhidarimsgcd17("");
        //
        //        hokenSyouken.setHyoujiranhidarimsgcd18("");
        //
        //        hokenSyouken.setHyoujiranhidarimsgcd19("");
        //
        //        hokenSyouken.setHyoujiranhidarimsgcd20("");
        //
        //        if (hyoujiranrightmsgcdLst.size() > 0) {
        //            hokenSyouken.setHyoujiranmigiimsgcd1(hyoujiranrightmsgcdLst.get(0));
        //        }
        //
        //        if (hyoujiranrightmsgcdLst.size() > 1) {
        //            hokenSyouken.setHyoujiranmigiimsgcd2(hyoujiranrightmsgcdLst.get(1));
        //        }
        //
        //        hokenSyouken.setHyoujiranmigiimsgcd3("");
        //
        //        hokenSyouken.setHyoujiranmigiimsgcd4("");
        //
        //        hokenSyouken.setHyoujiranmigiimsgcd5("");
        //
        //        hokenSyouken.setHyoujiranmigiimsgcd6("");
        //
        //        hokenSyouken.setHyoujiranmigiimsgcd7("");
        //
        //        hokenSyouken.setHyoujiranmigiimsgcd8("");
        //
        //        hokenSyouken.setHyoujiranmigiimsgcd9("");
        //
        //        hokenSyouken.setHyoujiranmigiimsgcd10("");
        //
        //        hokenSyouken.setHyoujiranmigiimsgcd11("");
        //
        //        hokenSyouken.setHyoujiranmigiimsgcd12("");
        //
        //        hokenSyouken.setHyoujiranmigiimsgcd13("");
        //
        //        hokenSyouken.setHyoujiranmigiimsgcd14("");
        //
        //        hokenSyouken.setHyoujiranmigiimsgcd15("");
        //
        //        hokenSyouken.setHyoujiranmigiimsgcd16("");
        //
        //        hokenSyouken.setHyoujiranmigiimsgcd17("");
        //
        //        hokenSyouken.setHyoujiranmigiimsgcd18("");
        //
        //        hokenSyouken.setHyoujiranmigiimsgcd19("");
        //
        //        hokenSyouken.setHyoujiranmigiimsgcd20("");
        //
        //        hokenSyouken.setHyoujiransknnkaisiymd(sknnkaisiymd);
        //
        //        hokenSyouken.setHyoujiranyoteiriritu(hyoujiranyoteiriritu);
        //
        //        hokenSyouken.setHyoujiransjkkktusirrt(hyoujiransjkkktusirrt);
        //
        //        hokenSyouken.setHknsyukigou(pSyuKykSyouhnLst.get(0).getSyouhncd().substring(0, 2));
        //
        //        hokenSyouken.setHanbainm("");
        //
        //        hokenSyouken.setAisyoumeikbn(pKykKihon.getAisyoumeikbn());
        //
        //        hokenSyouken.setSeisikihknnm(syouhnZokusei.getSyouhnnmsyouken());
        //
        //        if (sksyoukenskskbn == SAIHAKKOUHOKENSYOUKEN) {
        //
        //            hokenSyouken.setKouryokukaisiymd(pSyuKykSyouhnLst.get(0).getKouryokuhasseiymd());
        //        }
        //        else {
        //
        //            hokenSyouken.setKouryokukaisiymd(null);
        //        }
        //
        //        hokenSyouken.setKyknmkj(pKykSya.getKyknmkj());
        //
        //        hokenSyouken.setKyknmkjkhukakbn(pKykSya.getKyknmkjkhukakbn());
        //
        //        hokenSyouken.setHhknnmkj(pHhknSya.getHhknnmkj());
        //
        //        hokenSyouken.setHhknnmkjkhukakbn(pHhknSya.getHhknnmkjkhukakbn());
        //
        //        hokenSyouken.setHhknseiymd(pHhknSya.getHhknseiymd());
        //
        //        hokenSyouken.setHhknsei(pHhknSya.getHhknsei());
        //
        //        hokenSyouken.setHhknnen(pSyuKykSyouhnLst.get(0).getHhknnen());
        //
        //        hokenSyouken.setSyoukenuktmidasikbn1(syoukenuktmidasikbnLst.get(0));
        //
        //        hokenSyouken.setSyoukenuktmidasikbn2(syoukenuktmidasikbnLst.get(1));
        //
        //        hokenSyouken.setSyoukenuktmidasikbn3(syoukenuktmidasikbnLst.get(2));
        //
        //        hokenSyouken.setSyoukenuktmidasikbn4(syoukenuktmidasikbnLst.get(3));
        //
        //        hokenSyouken.setSyoukenuktmidasikbn5(syoukenuktmidasikbnLst.get(4));
        //
        //        hokenSyouken.setSyoukenuktmidasikbn6(syoukenuktmidasikbnLst.get(5));
        //
        //        hokenSyouken.setSyoukenuktmidasikbn7(syoukenuktmidasikbnLst.get(6));
        //
        //        hokenSyouken.setSyoukenuktmidasikbn8(syoukenuktmidasikbnLst.get(7));
        //
        //        hokenSyouken.setSyoukenuktmidasikbn9(syoukenuktmidasikbnLst.get(8));
        //
        //        hokenSyouken.setSyoukenuktmidasikbn10(syoukenuktmidasikbnLst.get(9));
        //
        //        hokenSyouken.setSyoukenuktkbn1(uktKbnLst.get(0));
        //
        //        hokenSyouken.setSyoukenuktkbn2(uktKbnLst.get(1));
        //
        //        hokenSyouken.setSyoukenuktkbn3(uktKbnLst.get(2));
        //
        //        hokenSyouken.setSyoukenuktkbn4(uktKbnLst.get(3));
        //
        //        hokenSyouken.setSyoukenuktkbn5(uktKbnLst.get(4));
        //
        //        hokenSyouken.setSyoukenuktkbn6(uktKbnLst.get(5));
        //
        //        hokenSyouken.setSyoukenuktkbn7(uktKbnLst.get(6));
        //
        //        hokenSyouken.setSyoukenuktkbn8(uktKbnLst.get(7));
        //
        //        hokenSyouken.setSyoukenuktkbn9(uktKbnLst.get(8));
        //
        //        hokenSyouken.setSyoukenuktkbn10(uktKbnLst.get(9));
        //
        //        hokenSyouken.setSyoukenuktnm1(uktnmkjLst.get(0));
        //
        //        hokenSyouken.setSyoukenuktnm2(uktnmkjLst.get(1));
        //
        //        hokenSyouken.setSyoukenuktnm3(uktnmkjLst.get(2));
        //
        //        hokenSyouken.setSyoukenuktnm4(uktnmkjLst.get(3));
        //
        //        hokenSyouken.setSyoukenuktnm5(uktnmkjLst.get(4));
        //
        //        hokenSyouken.setSyoukenuktnm6(uktnmkjLst.get(5));
        //
        //        hokenSyouken.setSyoukenuktnm7(uktnmkjLst.get(6));
        //
        //        hokenSyouken.setSyoukenuktnm8(uktnmkjLst.get(7));
        //
        //        hokenSyouken.setSyoukenuktnm9(uktnmkjLst.get(8));
        //
        //        hokenSyouken.setSyoukenuktnm10(uktnmkjLst.get(9));
        //
        //        hokenSyouken.setSyoukenuktbnwari1(uktBnwariList.get(0));
        //
        //        hokenSyouken.setSyoukenuktbnwari2(uktBnwariList.get(1));
        //
        //        hokenSyouken.setSyoukenuktbnwari3(uktBnwariList.get(2));
        //
        //        hokenSyouken.setSyoukenuktbnwari4(uktBnwariList.get(3));
        //
        //        hokenSyouken.setSyoukenuktbnwari5(uktBnwariList.get(4));
        //
        //        hokenSyouken.setSyoukenuktbnwari6(uktBnwariList.get(5));
        //
        //        hokenSyouken.setSyoukenuktbnwari7(uktBnwariList.get(6));
        //
        //        hokenSyouken.setSyoukenuktbnwari8(uktBnwariList.get(7));
        //
        //        hokenSyouken.setSyoukenuktbnwari9(uktBnwariList.get(8));
        //
        //        hokenSyouken.setSyoukenuktbnwari10(uktBnwariList.get(9));
        //
        //        hokenSyouken.setPmsgcd1(pmsgcd1);
        //
        //        hokenSyouken.setPmsgcd2(pmsgcd2);
        //
        //        hokenSyouken.setPmsgcd3("");
        //
        //        hokenSyouken.setPtuukatype(ptuukasyu);
        //
        //        hokenSyouken.setHokenryou(hokenryou);
        //
        //        hokenSyouken.setPtuuka(ptuukasyuNm);
        //
        //        hokenSyouken.setPtokuyakumsgcd(ptokuyakumsgcd);
        //
        //        hokenSyouken.setKykymd(pSyuKykSyouhnLst.get(0).getKykymd());
        //
        //        hokenSyouken.setPhrkkknmidasikbn("01");
        //
        //        hokenSyouken.setHrkkknmsgkbn("");
        //
        //        hokenSyouken.setHrkkaisuumsgkbn("");
        //
        //        hokenSyouken.setHrkkitukimsgkbn("");
        //
        //        hokenSyouken.setHrkhouhoumsgkbn("");
        //
        //        hokenSyouken.setSyukyktkykrenban1(1);
        //
        //        hokenSyouken.setSyukyktkykrenban2(0);
        //
        //        hokenSyouken.setSyukyktkykrenban3(0);
        //
        //        hokenSyouken.setSyukyktkykrenban4(0);
        //
        //        hokenSyouken.setSyukyktkykrenban5(0);
        //
        //        hokenSyouken.setSyukyktkykrenban6(0);
        //
        //        hokenSyouken.setSyukyktkykrenban7(0);
        //
        //        hokenSyouken.setSyukyktkykrenban8(0);
        //
        //        hokenSyouken.setSyukyktkykrenban9(0);
        //
        //        hokenSyouken.setSyukyktkykrenban10(0);
        //
        //        hokenSyouken.setSyukyktkykmsgkbn1(syukyktkykmsgkbn1);
        //
        //        hokenSyouken.setSyukyktkykmsgkbn2(syukyktkykmsgkbn2);
        //
        //        hokenSyouken.setSyukyktkykmsgkbn3(syukyktkykmsgkbn3);
        //
        //        hokenSyouken.setSyukyktkykmsgkbn4("");
        //
        //        hokenSyouken.setSyukyktkykmsgkbn5("");
        //
        //        hokenSyouken.setSyukyktkykmsgkbn6("");
        //
        //        hokenSyouken.setSyukyktkykmsgkbn7("");
        //
        //        hokenSyouken.setSyukyktkykmsgkbn8("");
        //
        //        hokenSyouken.setSyukyktkykmsgkbn9("");
        //
        //        hokenSyouken.setSyukyktkykmsgkbn10("");
        //
        //        hokenSyouken.setSyukyktkyksmsgkbn1(syukyktkyksmsgkbn1);
        //
        //        hokenSyouken.setSyukyktkyksmsgkbn2(syukyktkyksmsgkbn2);
        //
        //        hokenSyouken.setSyukyktkyksmsgkbn3(syukyktkyksmsgkbn3);
        //
        //        hokenSyouken.setSyukyktkyksmsgkbn4("");
        //
        //        hokenSyouken.setSyukyktkyksmsgkbn5("");
        //
        //        hokenSyouken.setSyukyktkyksmsgkbn6("");
        //
        //        hokenSyouken.setSyukyktkyksmsgkbn7("");
        //
        //        hokenSyouken.setSyukyktkyksmsgkbn8("");
        //
        //        hokenSyouken.setSyukyktkyksmsgkbn9("");
        //
        //        hokenSyouken.setSyukyktkyksmsgkbn10("");
        //
        //        hokenSyouken.setSyukyktkykhknkknmsgkbn1(syukyktkykhknkknmsgkbn1);
        //
        //        hokenSyouken.setSyukyktkykhknkknmsgkbn2(syukyktkykhknkknmsgkbn2);
        //
        //        hokenSyouken.setSyukyktkykhknkknmsgkbn3(syukyktkykhknkknmsgkbn3);
        //
        //        hokenSyouken.setSyukyktkykhknkknmsgkbn4("");
        //
        //        hokenSyouken.setSyukyktkykhknkknmsgkbn5("");
        //
        //        hokenSyouken.setSyukyktkykhknkknmsgkbn6("");
        //
        //        hokenSyouken.setSyukyktkykhknkknmsgkbn7("");
        //
        //        hokenSyouken.setSyukyktkykhknkknmsgkbn8("");
        //
        //        hokenSyouken.setSyukyktkykhknkknmsgkbn9("");
        //
        //        hokenSyouken.setSyukyktkykhknkknmsgkbn10("");
        //
        //        hokenSyouken.setSyukyktkykstuukatype1(syukyktkykstuukatype1);
        //
        //        hokenSyouken.setSyukyktkykstuukatype2(syukyktkykstuukatype2);
        //
        //        hokenSyouken.setSyukyktkykstuukatype3(syukyktkykstuukatype3);
        //
        //        hokenSyouken.setSyukyktkykstuukatype4(C_Tuukasyu.BLNK);
        //
        //        hokenSyouken.setSyukyktkykstuukatype5(C_Tuukasyu.BLNK);
        //
        //        hokenSyouken.setSyukyktkykstuukatype6(C_Tuukasyu.BLNK);
        //
        //        hokenSyouken.setSyukyktkykstuukatype7(C_Tuukasyu.BLNK);
        //
        //        hokenSyouken.setSyukyktkykstuukatype8(C_Tuukasyu.BLNK);
        //
        //        hokenSyouken.setSyukyktkykstuukatype9(C_Tuukasyu.BLNK);
        //
        //        hokenSyouken.setSyukyktkykstuukatype10(C_Tuukasyu.BLNK);
        //
        //        hokenSyouken.setSyukyktkykhknkngk1(syukyktkykhknkngk1);
        //
        //        hokenSyouken.setSyukyktkykhknkngk2(syukyktkykhknkngk2);
        //
        //        hokenSyouken.setSyukyktkykhknkngk3(syukyktkykhknkngk3);
        //
        //        hokenSyouken.setSyukyktkykhknkngk4(BizCurrency.valueOf(0));
        //
        //        hokenSyouken.setSyukyktkykhknkngk5(BizCurrency.valueOf(0));
        //
        //        hokenSyouken.setSyukyktkykhknkngk6(BizCurrency.valueOf(0));
        //
        //        hokenSyouken.setSyukyktkykhknkngk7(BizCurrency.valueOf(0));
        //
        //        hokenSyouken.setSyukyktkykhknkngk8(BizCurrency.valueOf(0));
        //
        //        hokenSyouken.setSyukyktkykhknkngk9(BizCurrency.valueOf(0));
        //
        //        hokenSyouken.setSyukyktkykhknkngk10(BizCurrency.valueOf(0));
        //
        //        hokenSyouken.setSyukyktkykdai1hknkkn1(dai1hknkkn);
        //
        //        hokenSyouken.setSyukyktkykdai1hknkkn2(0);
        //
        //        hokenSyouken.setSyukyktkykdai1hknkkn3(0);
        //
        //        hokenSyouken.setSyukyktkykdai1hknkkn4(0);
        //
        //        hokenSyouken.setSyukyktkykdai1hknkkn5(0);
        //
        //        hokenSyouken.setSyukyktkykdai1hknkkn6(0);
        //
        //        hokenSyouken.setSyukyktkykdai1hknkkn7(0);
        //
        //        hokenSyouken.setSyukyktkykdai1hknkkn8(0);
        //
        //        hokenSyouken.setSyukyktkykdai1hknkkn9(0);
        //
        //        hokenSyouken.setSyukyktkykdai1hknkkn10(0);
        //
        //        hokenSyouken.setSyukyktkykdai2hknkkn1(0);
        //
        //        hokenSyouken.setSyukyktkykdai2hknkkn2(dai2hknkkn);
        //
        //        hokenSyouken.setSyukyktkykdai2hknkkn3(0);
        //
        //        hokenSyouken.setSyukyktkykdai2hknkkn4(0);
        //
        //        hokenSyouken.setSyukyktkykdai2hknkkn5(0);
        //
        //        hokenSyouken.setSyukyktkykdai2hknkkn6(0);
        //
        //        hokenSyouken.setSyukyktkykdai2hknkkn7(0);
        //
        //        hokenSyouken.setSyukyktkykdai2hknkkn8(0);
        //
        //        hokenSyouken.setSyukyktkykdai2hknkkn9(0);
        //
        //        hokenSyouken.setSyukyktkykdai2hknkkn10(0);
        //
        //        hokenSyouken.setSyutkdai1hknkknymdto1(syutkdai1hknkknymdto1);
        //
        //        hokenSyouken.setSyutkdai1hknkknymdto2(null);
        //
        //        hokenSyouken.setSyutkdai1hknkknymdto3(null);
        //
        //        hokenSyouken.setSyutkdai1hknkknymdto4(null);
        //
        //        hokenSyouken.setSyutkdai1hknkknymdto5(null);
        //
        //        hokenSyouken.setSyutkdai1hknkknymdto6(null);
        //
        //        hokenSyouken.setSyutkdai1hknkknymdto7(null);
        //
        //        hokenSyouken.setSyutkdai1hknkknymdto8(null);
        //
        //        hokenSyouken.setSyutkdai1hknkknymdto9(null);
        //
        //        hokenSyouken.setSyutkdai1hknkknymdto10(null);
        //
        //        hokenSyouken.setSyutkdai2hknkknymdto1(syutkdai2hknkknymdto1);
        //
        //        hokenSyouken.setSyutkdai2hknkknymdto2(syutkdai2hknkknymdto2);
        //
        //        hokenSyouken.setSyutkdai2hknkknymdto3(null);
        //
        //        hokenSyouken.setSyutkdai2hknkknymdto4(null);
        //
        //        hokenSyouken.setSyutkdai2hknkknymdto5(null);
        //
        //        hokenSyouken.setSyutkdai2hknkknymdto6(null);
        //
        //        hokenSyouken.setSyutkdai2hknkknymdto7(null);
        //
        //        hokenSyouken.setSyutkdai2hknkknymdto8(null);
        //
        //        hokenSyouken.setSyutkdai2hknkknymdto9(null);
        //
        //        hokenSyouken.setSyutkdai2hknkknymdto10(null);
        //
        //        hokenSyouken.setKykniyustmsgcd1(kykniyustmsgcd1);
        //
        //        hokenSyouken.setKykniyustmsgcd2(kykniyustmsgcd2);
        //
        //        hokenSyouken.setKykniyustmsgcd3(kykniyustmsgcd3);
        //
        //        hokenSyouken.setKykniyustmsgcd4(kykniyustmsgcd4);
        //
        //        hokenSyouken.setKykniyustmsgcd5("");
        //
        //        hokenSyouken.setKykniyustmsgcd6("");
        //
        //        hokenSyouken.setKykniyustmsgcd7("");
        //
        //        hokenSyouken.setKykniyustmsgcd8("");
        //
        //        hokenSyouken.setKykniyustmsgcd9("");
        //
        //        hokenSyouken.setKykniyustmsgcd10("");
        //
        //        hokenSyouken.setKykniyustmsgcd11("");
        //
        //        hokenSyouken.setKykniyustmsgcd12("");
        //
        //        hokenSyouken.setKykniyustmsgcd13("");
        //
        //        hokenSyouken.setKykniyustmsgcd14("");
        //
        //        hokenSyouken.setKykniyustmsgcd15("");
        //
        //        hokenSyouken.setKykniyustitjbrptuuktype(kykniyustitjbrptuuktype);
        //
        //        hokenSyouken.setKykniyustitjbrp(kykniyustitjbrp);
        //
        //        hokenSyouken.setStnaiyouranmsgcd1(stNaiyouranMsgCdList.get(0));
        //
        //        hokenSyouken.setStnaiyouranmsgcd2(stNaiyouranMsgCdList.get(1));
        //
        //        hokenSyouken.setStnaiyouranmsgcd3(stNaiyouranMsgCdList.get(2));
        //
        //        hokenSyouken.setStnaiyouranmsgcd4(stNaiyouranMsgCdList.get(3));
        //
        //        hokenSyouken.setStnaiyouranmsgcd5(stNaiyouranMsgCdList.get(4));
        //
        //        hokenSyouken.setStnaiyouranmsgcd6(stNaiyouranMsgCdList.get(5));
        //
        //        hokenSyouken.setStnaiyouranmsgcd7(stNaiyouranMsgCdList.get(6));
        //
        //        hokenSyouken.setStnaiyouranmsgcd8(stNaiyouranMsgCdList.get(7));
        //
        //        hokenSyouken.setStnaiyouranmsgcd9(stNaiyouranMsgCdList.get(8));
        //
        //        hokenSyouken.setStnaiyouranmsgcd10(stNaiyouranMsgCdList.get(9));
        //
        //        hokenSyouken.setStnaiyouranmsgcd11(stNaiyouranMsgCdList.get(10));
        //
        //        hokenSyouken.setStnaiyouranmsgcd12(stNaiyouranMsgCdList.get(11));
        //
        //        hokenSyouken.setStnaiyouranmsgcd13(stNaiyouranMsgCdList.get(12));
        //
        //        hokenSyouken.setStnaiyouranmsgcd14(stNaiyouranMsgCdList.get(13));
        //
        //        hokenSyouken.setStnaiyouranmsgcd15(stNaiyouranMsgCdList.get(14));
        //
        //        hokenSyouken.setStnaiyouranmsgcd16(stNaiyouranMsgCdList.get(15));
        //
        //        hokenSyouken.setStnaiyouranmsgcd17(stNaiyouranMsgCdList.get(16));
        //
        //        hokenSyouken.setStnaiyouranmsgcd18(stNaiyouranMsgCdList.get(17));
        //
        //        hokenSyouken.setStnaiyouranmsgcd19(stNaiyouranMsgCdList.get(18));
        //
        //        hokenSyouken.setStnaiyouranmsgcd20(stNaiyouranMsgCdList.get(19));
        //
        //        hokenSyouken.setSonotanyransiteituuka(kyktuukasyuNm);
        //
        //        hokenSyouken.setSonotanyrannykntuktype(sonotanyrannykntuktype);
        //
        //        hokenSyouken.setSonotanyrannykntuukap(sonotanyrannykntuukap);
        //
        //        hokenSyouken.setSonotanyrannykntuukasyu(sonotanyrannykntuukasyu);
        //
        //        hokenSyouken.setSonotanyranenkhrikmrate(sonotanyranenkhrikmrate);
        //
        //        hokenSyouken.setSonotanyranstigikwsrate(sonotanyranstigikwsrate);
        //
        //        hokenSyouken.setSonotanyrankjnkngktuktype(sonotanyrankjnkngktuktype);
        //
        //        hokenSyouken.setSonotanyrankjnkngk(sonotanyrankjnkngk);
        //
        //        hokenSyouken.setSonotanyrankjnkngkrate(sonotanyrankjnkngkrate);
        //
        //        hokenSyouken.setSonotanyrankjnkngktuuka(sonotanyrankjnkngktuuka);
        //
        //        hokenSyouken.setSonotanyranpentuktype(sonotanyranpentuktype);
        //
        //        hokenSyouken.setSonotanyranpenknsngk(sonotanyranpenknsngk);
        //
        //        hokenSyouken.setSonotanyranmkhwariai(sonotanyranmkhwariai);
        //
        //        hokenSyouken.setSonotanyranytirrt(sonotanyranytirrt);
        //
        //        hokenSyouken.setSonotanyransjkkktusirrt(kyksjkkktyouseiriritu);
        //
        //        hokenSyouken.setStnaiyourangaimsgcd("09200");
        //
        //        hokenSyouken.setTsinyno(pKykSya.getTsinyno());
        //
        //        hokenSyouken.setTsinadr1kj(pKykSya.getTsinadr1kj());
        //
        //        hokenSyouken.setTsinadr2kj(pKykSya.getTsinadr2kj());
        //
        //        hokenSyouken.setTsinadr3kj(pKykSya.getTsinadr3kj());
        //
        //        hokenSyouken.setShsnmkj(pKykSya.getKyknmkj());
        //
        //        hokenSyouken.setTnknmissmsg("");
        //
        //        hokenSyouken.setErrormsgcd("");
        //
        //        hokenSyouken.setSisyacd(tantouCdEntity.getBusitucd());
        //
        //        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //
        //            hokenSyouken.setDuhutusnrntousaadrmsgcd("10010");
        //        }
        //        else {
        //
        //            hokenSyouken.setDuhutusnrntousaadrmsgcd("");
        //        }
        //
        //        hokenSyouken.setDuhutusnrnsyono(pKykKihon.getSyono());
        //
        //        if (channelCdList.size() > 0) {
        //
        //            hokenSyouken.setChannelcd(channelCdList.get(0));
        //        }
        //
        //        hokenSyouken.setDairitenmidasikbn("01");
        //
        //        if (drtenNmList.size() > 0) {
        //
        //            hokenSyouken.setDrtennm1kj(drtenNmList.get(0));
        //        }
        //
        //        if (drtenNmList.size() > 1) {
        //
        //            hokenSyouken.setDrtennm2kj(drtenNmList.get(1));
        //        }
        //
        //        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //
        //            hokenSyouken.setAisatumsgcd("10020");
        //        }
        //        else {
        //
        //            hokenSyouken.setAisatumsgcd("");
        //        }
        //
        //        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //
        //            hokenSyouken.setCcmsgcd("10030");
        //        }
        //        else {
        //
        //            hokenSyouken.setCcmsgcd("");
        //        }
        //
        //        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //
        //            hokenSyouken.setHskmsgcd("10040");
        //        }
        //        else {
        //
        //            hokenSyouken.setHskmsgcd("");
        //        }
        //
        //        hokenSyouken.setHosyounymsgcd("99001");
        //
        //        hokenSyouken.setHosyounyhihknsyameikanji(pHhknSya.getHhknnmkj());
        //
        //        if (C_UmuKbn.ARI.eq(sbhkuktumu)) {
        //            hokenSyouken.setSiboumidasimsgcd("12010");
        //        }
        //        else {
        //            hokenSyouken.setSiboumidasimsgcd("");
        //        }
        //
        //        hokenSyouken.setSiboumidasimsgcd2(siboumidasimsgcd2);
        //
        //        hokenSyouken.setSiboudai1hknkknmsgcd1(siboudai1hknkknmsgcdLst.get(0));
        //
        //        hokenSyouken.setSiboudai1hknkknmsgcd2(siboudai1hknkknmsgcdLst.get(1));
        //
        //        hokenSyouken.setSiboudai1hknkknigimsgcd(siboudai1hknkknigimsgcd);
        //
        //        hokenSyouken.setSiboudai1hknkknigimsgcd2(siboudai1hknkknigimsgcd2);
        //
        //        hokenSyouken.setSiboudai1hknkknhrsmsgcd(siboudai1hknkknhrsmsgcd);
        //
        //        hokenSyouken.setSiboudai1hknkknhrsmsgcd2(siboudai1hknkknhrsmsgcd2);
        //
        //        hokenSyouken.setSiboudai1hknkknsmrmsgcd(siboudai1hknkknsmrmsgcd);
        //
        //        hokenSyouken.setSiboudai2hknkknmsgcd1(siboudai2hknkknmsgcd1);
        //
        //        hokenSyouken.setSiboudai2hknkknmsgcd2(siboudai2hknkknmsgcd2);
        //
        //        hokenSyouken.setSiboudai2hknkknsmsgcd(siboudai2hknkknsmsgcd);
        //
        //        hokenSyouken.setSiboudai2hknkknsmsgcd2(siboudai2hknkknsmsgcd2);
        //
        //        hokenSyouken.setSiboudai3hknkknmsgcd1(siboudai3hknkknmsgcd1);
        //
        //        hokenSyouken.setSiboudai3hknkknmsgcd2(siboudai3hknkknmsgcd2);
        //
        //        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //
        //            hokenSyouken.setSiboudai1hknkkn(dai1hknkkn);
        //        }
        //        else {
        //
        //            hokenSyouken.setSiboudai1hknkkn(0);
        //        }
        //
        //        hokenSyouken.setSiboudai1hknkknymdto(dai1hknkknEndYmd);
        //
        //        hokenSyouken.setSibouitjbrpyentuuktype(sibouitjbrpyentuuktype);
        //
        //        hokenSyouken.setSibouitjbrpyentuukgk(sibouitjbrpyentuukgk);
        //
        //        hokenSyouken.setSiboudai1kjnkngktuuktype(siboudai1kjnkngktuuktype);
        //
        //        hokenSyouken.setSiboudai1kjnkngk(siboudai1kjnkngk);
        //
        //        if(sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //
        //            hokenSyouken.setSiboudai2hknkkn(dai2hknkkn);
        //        }
        //        else {
        //
        //            hokenSyouken.setSiboudai2hknkkn(0);
        //        }
        //
        //        hokenSyouken.setSiboudai2hknkknymdto(dai2hknkknEndYmd);
        //
        //        hokenSyouken.setSiboudai2kjnkngktuuktype(siboudai2kjnkngktuuktype);
        //
        //        hokenSyouken.setSiboudai2kjnkngk(siboudai2kjnkngk);
        //
        //        hokenSyouken.setSiboudai3kjnkngktuuktype(siboudai3kjnkngktuuktype);
        //
        //        hokenSyouken.setSiboudai3kjnkngk(siboudai3kjnkngk);
        //
        //        hokenSyouken.setDai1skwsrateyendaka(skwsrateyendaka);
        //
        //        hokenSyouken.setDai1skwsrateyenkijyun(skwsrateyenkijyun);
        //
        //        hokenSyouken.setDai1skwsrateyenyasu(skwsrateyenyasu);
        //
        //        if (dai1skeikanensuuLst.size() > 0) {
        //
        //            hokenSyouken.setDai1skeikanensuu01(dai1skeikanensuuLst.get(0));
        //        }
        //
        //        if (dai1skeikanensuuLst.size() > 1) {
        //
        //            hokenSyouken.setDai1skeikanensuu02(dai1skeikanensuuLst.get(1));
        //        }
        //
        //        if (dai1skeikanensuuLst.size() > 2) {
        //
        //            hokenSyouken.setDai1skeikanensuu03(dai1skeikanensuuLst.get(2));
        //        }
        //
        //        if (dai1skeikanensuuLst.size() > 3) {
        //
        //            hokenSyouken.setDai1skeikanensuu04(dai1skeikanensuuLst.get(3));
        //        }
        //
        //        if (dai1skeikanensuuLst.size() > 4) {
        //
        //            hokenSyouken.setDai1skeikanensuu05(dai1skeikanensuuLst.get(4));
        //        }
        //
        //        if (dai1skeikanensuuLst.size() > 5) {
        //
        //            hokenSyouken.setDai1skeikanensuu06(dai1skeikanensuuLst.get(5));
        //        }
        //
        //        if (dai1skeikanensuuLst.size() > 6) {
        //
        //            hokenSyouken.setDai1skeikanensuu07(dai1skeikanensuuLst.get(6));
        //        }
        //
        //        if (dai1skeikanensuuLst.size() > 7) {
        //
        //            hokenSyouken.setDai1skeikanensuu08(dai1skeikanensuuLst.get(7));
        //        }
        //
        //        if (dai1skeikanensuuLst.size() > 8) {
        //
        //            hokenSyouken.setDai1skeikanensuu09(dai1skeikanensuuLst.get(8));
        //        }
        //
        //        if (dai1skeikanensuuLst.size() > 9) {
        //
        //            hokenSyouken.setDai1skeikanensuu10(dai1skeikanensuuLst.get(9));
        //        }
        //
        //        if (dai1sibousnenoutouymd.size() > 0) {
        //
        //            hokenSyouken.setDai1sibousnenoutouymd01(dai1sibousnenoutouymd.get(0));
        //        }
        //
        //        if (dai1sibousnenoutouymd.size() > 1) {
        //
        //            hokenSyouken.setDai1sibousnenoutouymd02(dai1sibousnenoutouymd.get(1));
        //        }
        //
        //        if (dai1sibousnenoutouymd.size() > 2) {
        //
        //            hokenSyouken.setDai1sibousnenoutouymd03(dai1sibousnenoutouymd.get(2));
        //        }
        //
        //        if (dai1sibousnenoutouymd.size() > 3) {
        //
        //            hokenSyouken.setDai1sibousnenoutouymd04(dai1sibousnenoutouymd.get(3));
        //        }
        //
        //        if (dai1sibousnenoutouymd.size() > 4) {
        //
        //            hokenSyouken.setDai1sibousnenoutouymd05(dai1sibousnenoutouymd.get(4));
        //        }
        //
        //        if (dai1sibousnenoutouymd.size() > 5) {
        //
        //            hokenSyouken.setDai1sibousnenoutouymd06(dai1sibousnenoutouymd.get(5));
        //        }
        //
        //        if (dai1sibousnenoutouymd.size() > 6) {
        //
        //            hokenSyouken.setDai1sibousnenoutouymd07(dai1sibousnenoutouymd.get(6));
        //        }
        //
        //        if (dai1sibousnenoutouymd.size() > 7) {
        //
        //            hokenSyouken.setDai1sibousnenoutouymd08(dai1sibousnenoutouymd.get(7));
        //        }
        //
        //        if (dai1sibousnenoutouymd.size() > 8) {
        //
        //            hokenSyouken.setDai1sibousnenoutouymd09(dai1sibousnenoutouymd.get(8));
        //        }
        //
        //        if (dai1sibousnenoutouymd.size() > 9) {
        //
        //            hokenSyouken.setDai1sibousnenoutouymd10(dai1sibousnenoutouymd.get(9));
        //        }
        //
        //        if (dai1stuuktypeLst.size() > 0) {
        //
        //            hokenSyouken.setDai1stuuktype01(dai1stuuktypeLst.get(0));
        //        }
        //
        //        if (dai1stuuktypeLst.size() > 1) {
        //
        //            hokenSyouken.setDai1stuuktype02(dai1stuuktypeLst.get(1));
        //        }
        //
        //        if (dai1stuuktypeLst.size() > 2) {
        //
        //            hokenSyouken.setDai1stuuktype03(dai1stuuktypeLst.get(2));
        //        }
        //
        //        if (dai1stuuktypeLst.size() > 3) {
        //
        //            hokenSyouken.setDai1stuuktype04(dai1stuuktypeLst.get(3));
        //        }
        //
        //        if (dai1stuuktypeLst.size() > 4) {
        //
        //            hokenSyouken.setDai1stuuktype05(dai1stuuktypeLst.get(4));
        //        }
        //
        //        if (dai1stuuktypeLst.size() > 5) {
        //
        //            hokenSyouken.setDai1stuuktype06(dai1stuuktypeLst.get(5));
        //        }
        //
        //        if (dai1stuuktypeLst.size() > 6) {
        //
        //            hokenSyouken.setDai1stuuktype07(dai1stuuktypeLst.get(6));
        //        }
        //
        //        if (dai1stuuktypeLst.size() > 7) {
        //
        //            hokenSyouken.setDai1stuuktype08(dai1stuuktypeLst.get(7));
        //        }
        //
        //        if (dai1stuuktypeLst.size() > 8) {
        //
        //            hokenSyouken.setDai1stuuktype09(dai1stuuktypeLst.get(8));
        //        }
        //
        //        if (dai1stuuktypeLst.size() > 9) {
        //
        //            hokenSyouken.setDai1stuuktype10(dai1stuuktypeLst.get(9));
        //        }
        //
        //        if (dai1sLst.size() > 0) {
        //
        //            hokenSyouken.setDai1s01(dai1sLst.get(0));
        //        }
        //
        //        if (dai1sLst.size() > 1) {
        //
        //            hokenSyouken.setDai1s02(dai1sLst.get(1));
        //        }
        //
        //        if (dai1sLst.size() > 2) {
        //
        //            hokenSyouken.setDai1s03(dai1sLst.get(2));
        //        }
        //
        //        if (dai1sLst.size() > 3) {
        //
        //            hokenSyouken.setDai1s04(dai1sLst.get(3));
        //        }
        //
        //        if (dai1sLst.size() > 4) {
        //
        //            hokenSyouken.setDai1s05(dai1sLst.get(4));
        //        }
        //
        //        if (dai1sLst.size() > 5) {
        //
        //            hokenSyouken.setDai1s06(dai1sLst.get(5));
        //        }
        //
        //        if (dai1sLst.size() > 6) {
        //
        //            hokenSyouken.setDai1s07(dai1sLst.get(6));
        //        }
        //
        //        if (dai1sLst.size() > 7) {
        //
        //            hokenSyouken.setDai1s08(dai1sLst.get(7));
        //        }
        //
        //        if (dai1sLst.size() > 8) {
        //
        //            hokenSyouken.setDai1s09(dai1sLst.get(8));
        //        }
        //
        //        if (dai1sLst.size() > 9) {
        //
        //            hokenSyouken.setDai1s10(dai1sLst.get(9));
        //        }
        //
        //        if (dai1syenyendakaumuLst.size() > 0) {
        //            hokenSyouken.setDai1syenyendakaumu01(dai1syenyendakaumuLst.get(0).toString());
        //        }
        //
        //        if (dai1syenyendakaumuLst.size() > 1) {
        //            hokenSyouken.setDai1syenyendakaumu02(dai1syenyendakaumuLst.get(1).toString());
        //        }
        //
        //        if (dai1syenyendakaumuLst.size() > 2) {
        //            hokenSyouken.setDai1syenyendakaumu03(dai1syenyendakaumuLst.get(2).toString());
        //        }
        //
        //        if (dai1syenyendakaumuLst.size() > 3) {
        //            hokenSyouken.setDai1syenyendakaumu04(dai1syenyendakaumuLst.get(3).toString());
        //        }
        //
        //        if (dai1syenyendakaumuLst.size() > 4) {
        //            hokenSyouken.setDai1syenyendakaumu05(dai1syenyendakaumuLst.get(4).toString());
        //        }
        //
        //        if (dai1syenyendakaumuLst.size() > 5) {
        //            hokenSyouken.setDai1syenyendakaumu06(dai1syenyendakaumuLst.get(5).toString());
        //        }
        //
        //        if (dai1syenyendakaumuLst.size() > 6) {
        //            hokenSyouken.setDai1syenyendakaumu07(dai1syenyendakaumuLst.get(6).toString());
        //        }
        //
        //        if (dai1syenyendakaumuLst.size() > 7) {
        //            hokenSyouken.setDai1syenyendakaumu08(dai1syenyendakaumuLst.get(7).toString());
        //        }
        //
        //        if (dai1syenyendakaumuLst.size() > 8) {
        //            hokenSyouken.setDai1syenyendakaumu09(dai1syenyendakaumuLst.get(8).toString());
        //        }
        //
        //        if (dai1syenyendakaumuLst.size() > 9) {
        //            hokenSyouken.setDai1syenyendakaumu10(dai1syenyendakaumuLst.get(9).toString());
        //        }
        //
        //
        //        if (dai1syenyenkijyunumuLst.size() > 0) {
        //            hokenSyouken.setDai1syenyenkijyunumu01(dai1syenyenkijyunumuLst.get(0).toString());
        //        }
        //
        //        if (dai1syenyenkijyunumuLst.size() > 1) {
        //            hokenSyouken.setDai1syenyenkijyunumu02(dai1syenyenkijyunumuLst.get(1).toString());
        //        }
        //
        //        if (dai1syenyenkijyunumuLst.size() > 2) {
        //            hokenSyouken.setDai1syenyenkijyunumu03(dai1syenyenkijyunumuLst.get(2).toString());
        //        }
        //
        //        if (dai1syenyenkijyunumuLst.size() > 3) {
        //            hokenSyouken.setDai1syenyenkijyunumu04(dai1syenyenkijyunumuLst.get(3).toString());
        //        }
        //
        //        if (dai1syenyenkijyunumuLst.size() > 4) {
        //            hokenSyouken.setDai1syenyenkijyunumu05(dai1syenyenkijyunumuLst.get(4).toString());
        //        }
        //
        //        if (dai1syenyenkijyunumuLst.size() > 5) {
        //            hokenSyouken.setDai1syenyenkijyunumu06(dai1syenyenkijyunumuLst.get(5).toString());
        //        }
        //
        //        if (dai1syenyenkijyunumuLst.size() > 6) {
        //            hokenSyouken.setDai1syenyenkijyunumu07(dai1syenyenkijyunumuLst.get(6).toString());
        //        }
        //
        //        if (dai1syenyenkijyunumuLst.size() > 7) {
        //            hokenSyouken.setDai1syenyenkijyunumu08(dai1syenyenkijyunumuLst.get(7).toString());
        //        }
        //
        //        if (dai1syenyenkijyunumuLst.size() > 8) {
        //            hokenSyouken.setDai1syenyenkijyunumu09(dai1syenyenkijyunumuLst.get(8).toString());
        //        }
        //
        //        if (dai1syenyenkijyunumuLst.size() > 9) {
        //            hokenSyouken.setDai1syenyenkijyunumu10(dai1syenyenkijyunumuLst.get(9).toString());
        //        }
        //
        //        if (dai1syenyenyasuumuLst.size() > 0) {
        //            hokenSyouken.setDai1syenyenyasuumu01(dai1syenyenyasuumuLst.get(0).toString());
        //        }
        //
        //        if (dai1syenyenyasuumuLst.size() > 1) {
        //            hokenSyouken.setDai1syenyenyasuumu02(dai1syenyenyasuumuLst.get(1).toString());
        //        }
        //
        //        if (dai1syenyenyasuumuLst.size() > 2) {
        //            hokenSyouken.setDai1syenyenyasuumu03(dai1syenyenyasuumuLst.get(2).toString());
        //        }
        //
        //        if (dai1syenyenyasuumuLst.size() > 3) {
        //            hokenSyouken.setDai1syenyenyasuumu04(dai1syenyenyasuumuLst.get(3).toString());
        //        }
        //
        //        if (dai1syenyenyasuumuLst.size() > 4) {
        //            hokenSyouken.setDai1syenyenyasuumu05(dai1syenyenyasuumuLst.get(4).toString());
        //        }
        //
        //        if (dai1syenyenyasuumuLst.size() > 5) {
        //            hokenSyouken.setDai1syenyenyasuumu06(dai1syenyenyasuumuLst.get(5).toString());
        //        }
        //
        //        if (dai1syenyenyasuumuLst.size() > 6) {
        //            hokenSyouken.setDai1syenyenyasuumu07(dai1syenyenyasuumuLst.get(6).toString());
        //        }
        //
        //        if (dai1syenyenyasuumuLst.size() > 7) {
        //            hokenSyouken.setDai1syenyenyasuumu08(dai1syenyenyasuumuLst.get(7).toString());
        //        }
        //
        //        if (dai1syenyenyasuumuLst.size() > 8) {
        //            hokenSyouken.setDai1syenyenyasuumu09(dai1syenyenyasuumuLst.get(8).toString());
        //        }
        //
        //        if (dai1syenyenyasuumuLst.size() > 9) {
        //            hokenSyouken.setDai1syenyenyasuumu10(dai1syenyenyasuumuLst.get(9).toString());
        //        }
        //
        //        if (dai1syentuuktypeLst.size() > 0) {
        //
        //            hokenSyouken.setDai1syentuuktype01(dai1syentuuktypeLst.get(0));
        //        }
        //
        //        if (dai1syentuuktypeLst.size() > 1) {
        //
        //            hokenSyouken.setDai1syentuuktype02(dai1syentuuktypeLst.get(1));
        //        }
        //
        //        if (dai1syentuuktypeLst.size() > 2) {
        //
        //            hokenSyouken.setDai1syentuuktype03(dai1syentuuktypeLst.get(2));
        //        }
        //
        //        if (dai1syentuuktypeLst.size() > 3) {
        //
        //            hokenSyouken.setDai1syentuuktype04(dai1syentuuktypeLst.get(3));
        //        }
        //
        //        if (dai1syentuuktypeLst.size() > 4) {
        //
        //            hokenSyouken.setDai1syentuuktype05(dai1syentuuktypeLst.get(4));
        //        }
        //
        //        if (dai1syentuuktypeLst.size() > 5) {
        //
        //            hokenSyouken.setDai1syentuuktype06(dai1syentuuktypeLst.get(5));
        //        }
        //
        //        if (dai1syentuuktypeLst.size() > 6) {
        //
        //            hokenSyouken.setDai1syentuuktype07(dai1syentuuktypeLst.get(6));
        //        }
        //
        //        if (dai1syentuuktypeLst.size() > 7) {
        //
        //            hokenSyouken.setDai1syentuuktype08(dai1syentuuktypeLst.get(7));
        //        }
        //
        //        if (dai1syentuuktypeLst.size() > 8) {
        //
        //            hokenSyouken.setDai1syentuuktype09(dai1syentuuktypeLst.get(8));
        //        }
        //
        //        if (dai1syentuuktypeLst.size() > 9) {
        //
        //            hokenSyouken.setDai1syentuuktype10(dai1syentuuktypeLst.get(9));
        //        }
        //
        //        if (dai1syenyendakaLst.size() > 0) {
        //
        //            hokenSyouken.setDai1syenyendaka01(dai1syenyendakaLst.get(0));
        //        }
        //
        //        if (dai1syenyendakaLst.size() > 1) {
        //
        //            hokenSyouken.setDai1syenyendaka02(dai1syenyendakaLst.get(1));
        //        }
        //
        //        if (dai1syenyendakaLst.size() > 2) {
        //
        //            hokenSyouken.setDai1syenyendaka03(dai1syenyendakaLst.get(2));
        //        }
        //
        //        if (dai1syenyendakaLst.size() > 3) {
        //
        //            hokenSyouken.setDai1syenyendaka04(dai1syenyendakaLst.get(3));
        //        }
        //
        //        if (dai1syenyendakaLst.size() > 4) {
        //
        //            hokenSyouken.setDai1syenyendaka05(dai1syenyendakaLst.get(4));
        //        }
        //
        //        if (dai1syenyendakaLst.size() > 5) {
        //
        //            hokenSyouken.setDai1syenyendaka06(dai1syenyendakaLst.get(5));
        //        }
        //
        //        if (dai1syenyendakaLst.size() > 6) {
        //
        //            hokenSyouken.setDai1syenyendaka07(dai1syenyendakaLst.get(6));
        //        }
        //
        //        if (dai1syenyendakaLst.size() > 7) {
        //
        //            hokenSyouken.setDai1syenyendaka08(dai1syenyendakaLst.get(7));
        //        }
        //
        //        if (dai1syenyendakaLst.size() > 8) {
        //
        //            hokenSyouken.setDai1syenyendaka09(dai1syenyendakaLst.get(8));
        //        }
        //
        //        if (dai1syenyendakaLst.size() > 9) {
        //
        //            hokenSyouken.setDai1syenyendaka10(dai1syenyendakaLst.get(9));
        //        }
        //
        //        if (dai1syenyenkijyunLst.size() > 0) {
        //
        //            hokenSyouken.setDai1syenyenkijyun01(dai1syenyenkijyunLst.get(0));
        //        }
        //
        //        if (dai1syenyenkijyunLst.size() > 1) {
        //
        //            hokenSyouken.setDai1syenyenkijyun02(dai1syenyenkijyunLst.get(1));
        //        }
        //
        //        if (dai1syenyenkijyunLst.size() > 2) {
        //
        //            hokenSyouken.setDai1syenyenkijyun03(dai1syenyenkijyunLst.get(2));
        //        }
        //
        //        if (dai1syenyenkijyunLst.size() > 3) {
        //
        //            hokenSyouken.setDai1syenyenkijyun04(dai1syenyenkijyunLst.get(3));
        //        }
        //
        //        if (dai1syenyenkijyunLst.size() > 4) {
        //
        //            hokenSyouken.setDai1syenyenkijyun05(dai1syenyenkijyunLst.get(4));
        //        }
        //
        //        if (dai1syenyenkijyunLst.size() > 5) {
        //
        //            hokenSyouken.setDai1syenyenkijyun06(dai1syenyenkijyunLst.get(5));
        //        }
        //
        //        if (dai1syenyenkijyunLst.size() > 6) {
        //
        //            hokenSyouken.setDai1syenyenkijyun07(dai1syenyenkijyunLst.get(6));
        //        }
        //
        //        if (dai1syenyenkijyunLst.size() > 7) {
        //
        //            hokenSyouken.setDai1syenyenkijyun08(dai1syenyenkijyunLst.get(7));
        //        }
        //
        //        if (dai1syenyenkijyunLst.size() > 8) {
        //
        //            hokenSyouken.setDai1syenyenkijyun09(dai1syenyenkijyunLst.get(8));
        //        }
        //
        //        if (dai1syenyenkijyunLst.size() > 9) {
        //
        //            hokenSyouken.setDai1syenyenkijyun10(dai1syenyenkijyunLst.get(9));
        //        }
        //
        //        if (dai1syenyenyasuLst.size() > 0) {
        //
        //            hokenSyouken.setDai1syenyenyasu01(dai1syenyenyasuLst.get(0));
        //        }
        //
        //        if (dai1syenyenyasuLst.size() > 1) {
        //
        //            hokenSyouken.setDai1syenyenyasu02(dai1syenyenyasuLst.get(1));
        //        }
        //
        //        if (dai1syenyenyasuLst.size() > 2) {
        //
        //            hokenSyouken.setDai1syenyenyasu03(dai1syenyenyasuLst.get(2));
        //        }
        //
        //        if (dai1syenyenyasuLst.size() > 3) {
        //
        //            hokenSyouken.setDai1syenyenyasu04(dai1syenyenyasuLst.get(3));
        //        }
        //
        //        if (dai1syenyenyasuLst.size() > 4) {
        //
        //            hokenSyouken.setDai1syenyenyasu05(dai1syenyenyasuLst.get(4));
        //        }
        //
        //        if (dai1syenyenyasuLst.size() > 5) {
        //
        //            hokenSyouken.setDai1syenyenyasu06(dai1syenyenyasuLst.get(5));
        //        }
        //
        //        if (dai1syenyenyasuLst.size() > 6) {
        //
        //            hokenSyouken.setDai1syenyenyasu07(dai1syenyenyasuLst.get(6));
        //        }
        //
        //        if (dai1syenyenyasuLst.size() > 7) {
        //
        //            hokenSyouken.setDai1syenyenyasu08(dai1syenyenyasuLst.get(7));
        //        }
        //
        //        if (dai1syenyenyasuLst.size() > 8) {
        //
        //            hokenSyouken.setDai1syenyenyasu09(dai1syenyenyasuLst.get(8));
        //        }
        //
        //        if (dai1syenyenyasuLst.size() > 9) {
        //
        //            hokenSyouken.setDai1syenyenyasu10(dai1syenyenyasuLst.get(9));
        //        }
        //
        //        hokenSyouken.setDai1stuuktypehuryo(dai1stuuktypehuryo);
        //
        //        hokenSyouken.setDai1shuryo(dai1shuryo);
        //
        //        hokenSyouken.setDai1syenyendakaumuhuryo(dai1syenyendakaumuhuryo);
        //
        //        hokenSyouken.setDai1syenyenkjnumuhuryo(dai1syenyenkjnumuhuryo);
        //
        //        hokenSyouken.setDai1syenyenyasuumuhuryo(dai1syenyenyasuumuhuryo);
        //
        //        hokenSyouken.setDai1syentuuktypehuryo(dai1syentuuktypehuryo);
        //
        //        hokenSyouken.setDai1syenyendakahuryo(dai1syenyendakahuryo);
        //
        //        hokenSyouken.setDai1syenyenkijyunhuryo(dai1syenyenkijyunhuryo);
        //
        //        hokenSyouken.setDai1syenyenyasuhuryo(dai1syenyenyasuhuryo);
        //
        //        hokenSyouken.setInitsbjiyenkasaiteihsygk(pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk());
        //
        //        hokenSyouken.setDai2stuuktype(dai2stuuktype);
        //
        //        hokenSyouken.setDai2s(dai2s);
        //
        //        hokenSyouken.setDai2syentuuktype(dai2syentuuktype);
        //
        //        hokenSyouken.setDai2syenyendaka(dai2syenyendaka);
        //
        //        hokenSyouken.setDai2syenyenkijyun(dai2syenyenkijyun);
        //
        //        hokenSyouken.setDai2syenyenyasu(dai2syenyenyasu);
        //
        //        hokenSyouken.setDai3stuuktype(dai3stuuktype);
        //
        //        hokenSyouken.setDai3s(dai3s);
        //
        //        hokenSyouken.setDai3syentuuktype(dai3syentuuktype);
        //
        //        hokenSyouken.setDai3syenyendaka(dai3syenyendaka);
        //
        //        hokenSyouken.setDai3syenyenkijyun(dai3syenyenkijyun);
        //
        //        hokenSyouken.setDai3syenyenyasu(dai3syenyenyasu);
        //
        //        hokenSyouken.setSibouinjiptnkbn("");
        //
        //        if (nenkinmsgcdLst.size() > 0) {
        //            hokenSyouken.setNkmsgcd1(nenkinmsgcdLst.get(0));
        //        }
        //
        //        if (nenkinmsgcdLst.size() > 1) {
        //            hokenSyouken.setNkmsgcd2(nenkinmsgcdLst.get(1));
        //        }
        //
        //        if (nenkinmsgcdLst.size() > 2) {
        //            hokenSyouken.setNkmsgcd3(nenkinmsgcdLst.get(2));
        //        }
        //
        //        if (nenkinmsgcdLst.size() > 3) {
        //            hokenSyouken.setNkmsgcd4(nenkinmsgcdLst.get(3));
        //        }
        //
        //        if (nenkinmsgcdLst.size() > 4) {
        //            hokenSyouken.setNkmsgcd5(nenkinmsgcdLst.get(4));
        //        }
        //
        //        if (nenkinmsgcdLst.size() > 5) {
        //            hokenSyouken.setNkmsgcd6(nenkinmsgcdLst.get(5));
        //        }
        //
        //        if (nenkinmsgcdLst.size() > 6) {
        //            hokenSyouken.setNkmsgcd7(nenkinmsgcdLst.get(6));
        //        }
        //
        //        if (nenkinmsgcdLst.size() > 7) {
        //            hokenSyouken.setNkmsgcd8(nenkinmsgcdLst.get(7));
        //        }
        //
        //        if (nenkinmsgcdLst.size() > 8) {
        //            hokenSyouken.setNkmsgcd9(nenkinmsgcdLst.get(8));
        //        }
        //
        //        if (nenkinmsgcdLst.size() > 9) {
        //            hokenSyouken.setNkmsgcd10(nenkinmsgcdLst.get(9));
        //        }
        //
        //        if (siboukyhkmsgcdLst.size() > 0) {
        //            hokenSyouken.setSiboukyuuhukinmsgcd1(siboukyhkmsgcdLst.get(0));
        //        }
        //
        //        if (siboukyhkmsgcdLst.size() > 1) {
        //            hokenSyouken.setSiboukyuuhukinmsgcd2(siboukyhkmsgcdLst.get(1));
        //        }
        //
        //        if (siboukyhkmsgcdLst.size() > 2) {
        //            hokenSyouken.setSiboukyuuhukinmsgcd3(siboukyhkmsgcdLst.get(2));
        //        }
        //
        //        if (siboukyhkmsgcdLst.size() > 3) {
        //            hokenSyouken.setSiboukyuuhukinmsgcd4(siboukyhkmsgcdLst.get(3));
        //        }
        //
        //        if (siboukyhkmsgcdLst.size() > 4) {
        //            hokenSyouken.setSiboukyuuhukinmsgcd5(siboukyhkmsgcdLst.get(4));
        //        }
        //
        //        if (siboukyhkmsgcdLst.size() > 5) {
        //            hokenSyouken.setSiboukyuuhukinmsgcd6(siboukyhkmsgcdLst.get(5));
        //        }
        //
        //        if (siboukyhkmsgcdLst.size() > 6) {
        //            hokenSyouken.setSiboukyuuhukinmsgcd7(siboukyhkmsgcdLst.get(6));
        //        }
        //
        //        if (siboukyhkmsgcdLst.size() > 7) {
        //            hokenSyouken.setSiboukyuuhukinmsgcd8(siboukyhkmsgcdLst.get(7));
        //        }
        //
        //        if (siboukyhkmsgcdLst.size() > 8) {
        //            hokenSyouken.setSiboukyuuhukinmsgcd9(siboukyhkmsgcdLst.get(8));
        //        }
        //
        //        if (siboukyhkmsgcdLst.size() > 9) {
        //            hokenSyouken.setSiboukyuuhukinmsgcd10(siboukyhkmsgcdLst.get(9));
        //        }
        //
        //        if (nkshrstartymd != null) {
        //            hokenSyouken.setNkshrstartzenymd(String.valueOf(nkshrstartymd.getPreviousDay()));
        //        }
        //
        //        hokenSyouken.setMkhyouyennkhknhentktype(mkhyouyensysnikougktype.toString());
        //
        //        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu())) {
        //            if (pKykSonotaTkyk.getTargettkmokuhyouti() > 0) {
        //                hokenSyouken.setMkhyouyennkhknhentkmkhgk(pKykSonotaTkyk.getTargettkykkijyungk());
        //            }
        //        }
        //        else {
        //            hokenSyouken.setMkhyouyennkhknhentkmkhgk(BizCurrency.valueOf(0));
        //        }
        //
        //        hokenSyouken.setMkhyouyennkhknhentkmkhwari(mkhyouyensysnikouwra);
        //
        //        hokenSyouken.setTeiritutmtthbnwr(BizNumber.valueOf(100).subtract(kykjisisuurendourate));
        //
        //        hokenSyouken.setSisuutmtthbnwr(kykjisisuurendourate);
        //
        //        hokenSyouken.setHutanhiyustmytijihiritu(BizNumber.valueOf(HUTANHIYUSTMYTIJIHIRITU));
        //
        //        hokenSyouken.setMkhyouyensysnikoumsgcd(mkhyouyensysnikoumsgcdLst.get(0));
        //
        //        hokenSyouken.setMkhyouyensysnikoumsgcd2(mkhyouyensysnikoumsgcdLst.get(1));
        //
        //        hokenSyouken.setMkhyouyensysnikoumsgcd3(mkhyouyensysnikoumsgcdLst.get(2));
        //
        //        hokenSyouken.setMkhyouyensysnikougktype(mkhyouyensysnikougktype);
        //
        //        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu())) {
        //            if (pKykSonotaTkyk.getTargettkmokuhyouti() > 0) {
        //                hokenSyouken.setMkhyouyensysnikougk(pKykSonotaTkyk.getTargettkykkijyungk());
        //            }
        //        }
        //        else {
        //            hokenSyouken.setMkhyouyensysnikougk(BizCurrency.valueOf(0));
        //        }
        //
        //        hokenSyouken.setMkhyouyensysnikouwra(mkhyouyensysnikouwra);
        //
        //        hokenSyouken.setKaigomaehrtkykmsgcd1(kaigomaehrtkykmsgcd1);
        //
        //        hokenSyouken.setKaigomaehrtkykmsgcd2(kaigomaehrtkykmsgcd2);
        //
        //        hokenSyouken.setKaigomaehrtkykmsgcdst1(kaigomaehrtkykmsgcdst1);
        //
        //        hokenSyouken.setKaigomaehrtkykmsgcdst2("");
        //
        //        hokenSyouken.setKaigomaehruktgkumu(kaigomaehruktgkumu.toString());
        //
        //        hokenSyouken.setKaigomaehrtkykkyktuuka(kaigomaehrtkykkyktuuka);
        //
        //        hokenSyouken.setKaigomaehrtkykstdmsgcd(kaigomaehrtkykstdmsgcd);
        //
        //        hokenSyouken.setKaigomaehrjrugktype(kaigomaehrjrugktype);
        //
        //        if (kaigomaehrsikuhhknnenLst.size() > 0) {
        //            hokenSyouken.setKaigomaehrsikuhhknnen01(kaigomaehrsikuhhknnenLst.get(0));
        //        }
        //
        //        if (kaigomaehrsikuhhknnenLst.size() > 1) {
        //            hokenSyouken.setKaigomaehrsikuhhknnen02(kaigomaehrsikuhhknnenLst.get(1));
        //        }
        //
        //        if (kaigomaehrsikuhhknnenLst.size() > 2) {
        //            hokenSyouken.setKaigomaehrsikuhhknnen03(kaigomaehrsikuhhknnenLst.get(2));
        //        }
        //        if (kaigomaehrsikuhhknnenLst.size() > 3) {
        //            hokenSyouken.setKaigomaehrsikuhhknnen04(kaigomaehrsikuhhknnenLst.get(3));
        //        }
        //
        //        if (kaigomaehrsikuhhknnenLst.size() > 4) {
        //            hokenSyouken.setKaigomaehrsikuhhknnen05(kaigomaehrsikuhhknnenLst.get(4));
        //        }
        //
        //        if (kaigomaehrsikuhhknnenLst.size() > 5) {
        //            hokenSyouken.setKaigomaehrsikuhhknnen06(kaigomaehrsikuhhknnenLst.get(5));
        //        }
        //
        //        if (kaigomaehrsikuhhknnenLst.size() > 6) {
        //            hokenSyouken.setKaigomaehrsikuhhknnen07(kaigomaehrsikuhhknnenLst.get(6));
        //        }
        //
        //        if (kaigomaehrsikuhhknnenLst.size() > 7) {
        //            hokenSyouken.setKaigomaehrsikuhhknnen08(kaigomaehrsikuhhknnenLst.get(7));
        //
        //        }
        //
        //        if (kaigomaehrsikuhhknnenLst.size() > 8) {
        //            hokenSyouken.setKaigomaehrsikuhhknnen09(kaigomaehrsikuhhknnenLst.get(8));
        //
        //        }
        //
        //        if (kaigomaehrsikuhhknnenLst.size() > 9) {
        //            hokenSyouken.setKaigomaehrsikuhhknnen10(kaigomaehrsikuhhknnenLst.get(9));
        //        }
        //
        //        if (kaigomaehrstikknLst.size() > 0) {
        //            hokenSyouken.setKaigomaehrstikkn01(kaigomaehrstikknLst.get(0));
        //        }
        //
        //        if (kaigomaehrstikknLst.size() > 1) {
        //            hokenSyouken.setKaigomaehrstikkn02(kaigomaehrstikknLst.get(1));
        //        }
        //
        //        if (kaigomaehrstikknLst.size() > 2) {
        //            hokenSyouken.setKaigomaehrstikkn03(kaigomaehrstikknLst.get(2));
        //        }
        //
        //        if (kaigomaehrstikknLst.size() > 3) {
        //            hokenSyouken.setKaigomaehrstikkn04(kaigomaehrstikknLst.get(3));
        //        }
        //
        //        if (kaigomaehrstikknLst.size() > 4) {
        //            hokenSyouken.setKaigomaehrstikkn05(kaigomaehrstikknLst.get(4));
        //        }
        //
        //        if (kaigomaehrstikknLst.size() > 5) {
        //            hokenSyouken.setKaigomaehrstikkn06(kaigomaehrstikknLst.get(5));
        //        }
        //
        //        if (kaigomaehrstikknLst.size() > 6) {
        //            hokenSyouken.setKaigomaehrstikkn07(kaigomaehrstikknLst.get(6));
        //        }
        //
        //        if (kaigomaehrstikknLst.size() > 7) {
        //            hokenSyouken.setKaigomaehrstikkn08(kaigomaehrstikknLst.get(7));
        //        }
        //
        //        if (kaigomaehrstikknLst.size() > 8) {
        //            hokenSyouken.setKaigomaehrstikkn09(kaigomaehrstikknLst.get(8));
        //        }
        //
        //        if (kaigomaehrstikknLst.size() > 9) {
        //            hokenSyouken.setKaigomaehrstikkn10(kaigomaehrstikknLst.get(9));
        //        }
        //
        //
        //        if (kaigomaehrjrugkLst.size() > 0) {
        //            hokenSyouken.setKaigomaehrjrugk01(kaigomaehrjrugkLst.get(0));
        //        }
        //
        //        if (kaigomaehrjrugkLst.size() > 1) {
        //            hokenSyouken.setKaigomaehrjrugk02(kaigomaehrjrugkLst.get(1));
        //        }
        //
        //        if (kaigomaehrjrugkLst.size() > 2) {
        //            hokenSyouken.setKaigomaehrjrugk03(kaigomaehrjrugkLst.get(2));
        //        }
        //
        //        if (kaigomaehrjrugkLst.size() > 3) {
        //            hokenSyouken.setKaigomaehrjrugk04(kaigomaehrjrugkLst.get(3));
        //        }
        //
        //        if (kaigomaehrjrugkLst.size() > 4) {
        //            hokenSyouken.setKaigomaehrjrugk05(kaigomaehrjrugkLst.get(4));
        //        }
        //
        //        if (kaigomaehrjrugkLst.size() > 5) {
        //            hokenSyouken.setKaigomaehrjrugk06(kaigomaehrjrugkLst.get(5));
        //        }
        //
        //        if (kaigomaehrjrugkLst.size() > 6) {
        //            hokenSyouken.setKaigomaehrjrugk07(kaigomaehrjrugkLst.get(6));
        //        }
        //
        //        if (kaigomaehrjrugkLst.size() > 7) {
        //            hokenSyouken.setKaigomaehrjrugk08(kaigomaehrjrugkLst.get(7));
        //
        //        }
        //
        //        if (kaigomaehrjrugkLst.size() > 8) {
        //            hokenSyouken.setKaigomaehrjrugk09(kaigomaehrjrugkLst.get(8));
        //        }
        //
        //        if (kaigomaehrjrugkLst.size() > 9) {
        //            hokenSyouken.setKaigomaehrjrugk10(kaigomaehrjrugkLst.get(9));
        //        }
        //
        //        hokenSyouken.setHutanhiyustmmsgcdue01(hutanhiyustmmsgcdueLst.get(0));
        //
        //        hokenSyouken.setHutanhiyustmmsgcdue02(hutanhiyustmmsgcdueLst.get(1));
        //
        //        hokenSyouken.setHutanhiyustmmsgcdue03(hutanhiyustmmsgcdueLst.get(2));
        //
        //        hokenSyouken.setHutanhiyustmmsgcdue04(hutanhiyustmmsgcdueLst.get(3));
        //
        //        hokenSyouken.setHutanhiyustmknsnhyuptn(hutanhiyustmknsnhyuptn);
        //
        //        hokenSyouken.setHutanhiyustmmsgcdst01(hutanhiyustmmsgcdst01);
        //
        //        hokenSyouken.setHutanhiyustmmsgcdst02(hutanhiyustmmsgcdst02);
        //
        //        hokenSyouken.setHutanhiyustmmsgcdst03(hutanhiyustmmsgcdst03);
        //
        //        hokenSyouken.setStdstmmsgcd(stdstmmsgcd);
        //
        //        hokenSyouken.setFstpmsgcd(fstpmsgcd);
        //
        //        hokenSyouken.setFstphrkpkngkkeituuktype(fstphrkpkngkkeituuktype);
        //
        //        hokenSyouken.setFstphrkpkngkkei(fstphrkpkngkkei);
        //
        //        hokenSyouken.setFstponegaimsgcd(fstponegaimsgcd);
        //
        //        hokenSyouken.setDsmsgcd(dsmsgcd);
        //
        //        hokenSyouken.setSyouhnhutaimsgcd1(syouhnhutaimsgcdLst.get(0));
        //
        //        hokenSyouken.setSyouhnhutaimsgcd2(syouhnhutaimsgcdLst.get(1));
        //
        //
        //        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //
        //            hokenSyouken.setPyentuuktype(C_Tuukasyu.JPY);
        //        }
        //        else {
        //
        //            hokenSyouken.setPyentuuktype(C_Tuukasyu.BLNK);
        //        }
        //
        //        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
        //
        //            hokenSyouken.setPyen(kijyungaku);
        //        }
        //        else {
        //
        //            hokenSyouken.setPyen(BizCurrency.valueOf(0));
        //        }
        //
        //        hokenSyouken.setToiawasesakihanyoumsgcd(toiawasesakihanyoumsgcd);
        //
        //        hokenSyouken.setAnnaihanyoumsgcd(annaihanyoumsgcd);
        //
        //        hokenSyouken.setWmsgcd1(wmsgcd1);
        //
        //        hokenSyouken.setWmsgcd2(wmsgcd2);
        //
        //        hokenSyouken.setWmsgcd3(wmsgcd3);
        //
        //        hokenSyouken.setWmsgcd21(wmsgcd2_1);
        //
        //        hokenSyouken.setWmsgcd22(wmsgcd2_2);
        //
        //        hokenSyouken.setWmsgcd23("");
        //
        //        hokenSyouken.setWmsgcd31(wmsgcd3_1);
        //
        //        hokenSyouken.setWmsgcd32("");
        //
        //        hokenSyouken.setWmsgcd33("");
        //
        //        hokenSyouken.setWmsgcdst1(wmsgcdst);
        //
        //        if (wtyuuijikoumsgcdLst.size() > 0) {
        //            hokenSyouken.setWtyuuijikoumsgcd1(wtyuuijikoumsgcdLst.get(0));
        //        }
        //
        //        if (wtyuuijikoumsgcdLst.size() > 1) {
        //            hokenSyouken.setWtyuuijikoumsgcd2(wtyuuijikoumsgcdLst.get(1));
        //        }
        //
        //        if (wtyuuijikoumsgcdLst.size() > 2) {
        //            hokenSyouken.setWtyuuijikoumsgcd3(wtyuuijikoumsgcdLst.get(2));
        //        }
        //
        //        if (wtyuuijikoumsgcdLst.size() > 3) {
        //            hokenSyouken.setWtyuuijikoumsgcd4(wtyuuijikoumsgcdLst.get(3));
        //        }
        //
        //        if (wtyuuijikoumsgcdLst.size() > 4) {
        //            hokenSyouken.setWtyuuijikoumsgcd5(wtyuuijikoumsgcdLst.get(4));
        //        }
        //
        //        if (wtyuuijikoumsgcdLst.size() > 5) {
        //            hokenSyouken.setWtyuuijikoumsgcd6(wtyuuijikoumsgcdLst.get(5));
        //        }
        //
        //        if (wtyuuijikoumsgcdLst.size() > 6) {
        //            hokenSyouken.setWtyuuijikoumsgcd7(wtyuuijikoumsgcdLst.get(6));
        //        }
        //
        //        hokenSyouken.setWitijibrptuktype(witijibrptuktype);
        //
        //        hokenSyouken.setWitijibrp(witijibrp);
        //
        //        hokenSyouken.setWyenhrkgktuktype(wyenhrkgktuktype);
        //
        //        hokenSyouken.setWyenhrkgk(wyenhrkgk);
        //
        //        hokenSyouken.setWyenitijibrptuktype(wyenitijibrptuktype);
        //
        //        hokenSyouken.setWyenitijibrp(wyenitijibrp);
        //
        //        hokenSyouken.setKoujyosyoumeimsgcd1(koujyosyoumeimsgcd1);
        //
        //        hokenSyouken.setKoujyosyoumeihskmsgcd("");
        //
        //        hokenSyouken.setNenkoujyosyoumeihskmsgcd("");
        //
        //        if (tokusyuSyoriNaiyouKbnList.size() > 0) {
        //
        //            hokenSyouken.setTokusyusyorinaiyoukbn1(tokusyuSyoriNaiyouKbnList.get(0));
        //        }
        //
        //        if (tokusyuSyoriNaiyouKbnList.size() > 1) {
        //
        //            hokenSyouken.setTokusyusyorinaiyoukbn2(tokusyuSyoriNaiyouKbnList.get(1));
        //        }
        //
        //        if (tokusyuSyoriNaiyouKbnList.size() > 2) {
        //
        //            hokenSyouken.setTokusyusyorinaiyoukbn3(tokusyuSyoriNaiyouKbnList.get(2));
        //        }
        //
        //        if (tokusyuSyoriNaiyouKbnList.size() > 3) {
        //
        //            hokenSyouken.setTokusyusyorinaiyoukbn4(tokusyuSyoriNaiyouKbnList.get(3));
        //        }
        //
        //        if (tokusyuSyoriNaiyouKbnList.size() > 4) {
        //
        //            hokenSyouken.setTokusyusyorinaiyoukbn5(tokusyuSyoriNaiyouKbnList.get(4));
        //        }
        //
        //        if (tokusyuSyoriNaiyouKbnList.size() > 5) {
        //
        //            hokenSyouken.setTokusyusyorinaiyoukbn6(tokusyuSyoriNaiyouKbnList.get(5));
        //        }
        //
        //        if (tokusyuSyoriNaiyouKbnList.size() > 6) {
        //
        //            hokenSyouken.setTokusyusyorinaiyoukbn7(tokusyuSyoriNaiyouKbnList.get(6));
        //        }
        //
        //        if (tokusyuSyoriNaiyouKbnList.size() > 7) {
        //
        //            hokenSyouken.setTokusyusyorinaiyoukbn8(tokusyuSyoriNaiyouKbnList.get(7));
        //        }
        //
        //        if (tokusyuSyoriNaiyouKbnList.size() > 8) {
        //
        //            hokenSyouken.setTokusyusyorinaiyoukbn9(tokusyuSyoriNaiyouKbnList.get(8));
        //        }
        //
        //        if (tokusyuSyoriNaiyouKbnList.size() > 9) {
        //
        //            hokenSyouken.setTokusyusyorinaiyoukbn10(tokusyuSyoriNaiyouKbnList.get(9));
        //        }
        //
        //        if (tokusyuSyoriNaiyouKbnList.size() > 10) {
        //
        //            hokenSyouken.setTokusyusyorinaiyoukbn11(tokusyuSyoriNaiyouKbnList.get(10));
        //        }
        //
        //        if (tokusyuSyoriNaiyouKbnList.size() > 11) {
        //
        //            hokenSyouken.setTokusyusyorinaiyoukbn12(tokusyuSyoriNaiyouKbnList.get(11));
        //        }
        //
        //        if (tokusyuSyoriNaiyouKbnList.size() > 12) {
        //
        //            hokenSyouken.setTokusyusyorinaiyoukbn13(tokusyuSyoriNaiyouKbnList.get(12));
        //        }
        //
        //        if (tokusyuSyoriNaiyouKbnList.size() > 13) {
        //
        //            hokenSyouken.setTokusyusyorinaiyoukbn14(tokusyuSyoriNaiyouKbnList.get(13));
        //        }
        //
        //        if (tokusyuSyoriNaiyouKbnList.size() > 14) {
        //
        //            hokenSyouken.setTokusyusyorinaiyoukbn15(tokusyuSyoriNaiyouKbnList.get(14));
        //        }
        //
        //        if (tokusyuSyoriNaiyouKbnList.size() > 15) {
        //
        //            hokenSyouken.setTokusyusyorinaiyoukbn16(tokusyuSyoriNaiyouKbnList.get(15));
        //        }
        //
        //        if (tokusyuSyoriNaiyouKbnList.size() > 16) {
        //
        //            hokenSyouken.setTokusyusyorinaiyoukbn17(tokusyuSyoriNaiyouKbnList.get(16));
        //        }
        //
        //        hokenSyouken.setGyoumuKousinKinou(pKCParm.getFunctionId());
        //
        //        hokenSyouken.setGyoumuKousinsyaId(pKCParm.getUserID());
        //
        //        hokenSyouken.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
        //
        //        hokenSyouken.setKyknmkn(pKykSya.getKyknmkn());
        //
        //        hokenSyouken.setHhknnmkn(pHhknSya.getHhknnmkn());
        //
        //        hokenSyouken.setSonotanyrannkshrstartymd(nkshrstartymd);
        //
        //        hokenSyouken.setSonotanyrannenkinkkn(sonotanyrannenkinkkn);
        //
        //        hokenSyouken.setSonotanyranyensysnhkhnkymd(sonotanyranyensysnhkhnkymd);
        //
        //        hokenSyouken.setSonotanyrantumitateriritu(tumitateriritu);
        //
        //        hokenSyouken.setSonotanyrantmttknzkrtjygn(sonotanyrantmttknzkrtjygn);
        //
        //        hokenSyouken.setSonotanyransetteibairitu(sonotanyransetteibairitu);
        //
        //        hokenSyouken.setSonotanyrantmttkngktuktype(kyktuukasyu.toString());
        //
        //        hokenSyouken.setSonotanyranteiritutmttkngk(sonotanyranteiritutmttkngk);
        //
        //        hokenSyouken.setSonotanyransisuutmttkngk(sonotanyransisuutmttkngk);
        //
        //        hokenSyouken.setSonotanyransisuunm(sonotanyransisuunm);
        //
        //        hokenSyouken.setKgmaehrtkdai1hknkknmnryymd(kgmaehrtkdai1hknkknmnryymd);
        //
        //        hokenSyouken.setTantocd(pEditHokenSyoukenParam.getTantoucd());
        //
        //        BizPropertyInitializer.initialize(hokenSyouken);
        //
        //        hassoukbn = hokenSyouken.getHassoukbn();
        //
        //
        //        EditSuiihyouTbl2 editSuiihyouTbl = SWAKInjector.getInstance(EditSuiihyouTbl2.class);
        //
        //        editSuiihyouTbl.editTBL(pKCParm, pKykKihon, pSyuKykSyouhnLst, pTkKykSyouhnLst, pHhknSya, pSyoriYmd,
        //            pEditHokenSyoukenParam, pSinsaihkKbn, syouhnZokusei, pKykSonotaTkyk);
    }
}
