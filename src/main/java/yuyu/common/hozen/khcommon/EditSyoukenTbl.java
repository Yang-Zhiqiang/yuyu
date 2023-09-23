package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_DirectServiceMosKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HnskariyuuKbn;
import yuyu.def.classification.C_HonninkakuninSyoruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_KykdrknHtdjytKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_StdrsktkyhnkKbn;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyoukenUktKbn;
import yuyu.def.classification.C_SyoukenUktMidasiKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TokusyuSyoriNaiyouKbn;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TyokusouhtkekKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YakkanJyuryouKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_HokenSyouken;
import yuyu.def.db.entity.IT_HokenSyoukenHukaInfo;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_SyouhnTokujou;
import yuyu.def.db.entity.IT_TrkKzk;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.sorter.SortIT_KhTtdkRireki;

/**
 * 契約保全 契約保全共通 保険証券TBL編集
 */
public class EditSyoukenTbl {

    private static final int SINKEIYAKUHOKENSYOUKEN = 1;

    private static final int SAIHAKKOUHOKENSYOUKEN = 2;

    private static final int KYKJI = 1;

    private static final int SAISAKUSEIJI = 2;

    private static final int SBHKKUKT = 1;

    private static final int SBKFKUKT = 2;

    private static final int UKETORIHITOLSTMAXCNT = 10;

    private static final int KZKTOUROKUSERVICEMSGLSTMAXCNT = 8;

    private static final BizDate KIRIKAE_YMD = BizDate.valueOf("20200401");

    private static final BizDate KIRIKAEMAE_YMD = BizDate.valueOf("20200331");

    private static final BizDate KYOUTUUJOUKEN1_YMD = BizDate.valueOf("20201001");

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private SortIT_KhTtdkRireki sortITKhTtdkRireki;

    private C_HassouKbn hassoukbn;

    public EditSyoukenTbl() {
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

        C_KjkhukaKbn kykdrnNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn dsTirasiDouhuuKbn = C_UmuKbn.NONE;

        C_UmuKbn kzkTirasidouhuukbn1 = C_UmuKbn.NONE;

        C_UmuKbn kzkTirasidouhuukbn2 = C_UmuKbn.NONE;

        C_UmuKbn kykDairitirasidouhuukbn = C_UmuKbn.NONE;

        C_UmuKbn stdrsktirasidouhuukbn = C_UmuKbn.NONE;

        C_UmuKbn skhTirasidouhuukbn  = C_UmuKbn.NONE;

        String yakkanNewoldkbn = "0";

        String kykDairinm = "";

        String hhkndairinm = "";

        String trkKzknm1 = "";

        C_Seibetu trkKzksei1 = C_Seibetu.BLNK;

        BizDate trkKzkseiymd1 = null;

        String trkKzkyno1 = "";

        String trkKzkadr1kj1 = "";

        String trkKzkadr2kj1 = "";

        String trkKzkadr3kj1 = "";

        String trkKzktelno1 = "";

        String trkKzknm2 = "";

        C_Seibetu trkKzksei2 = C_Seibetu.BLNK;

        BizDate trkKzkseiymd2 = null;

        String trkKzkyno2 = "";

        String trkKzkadr1kj2 = "";

        String trkKzkadr2kj2 = "";

        String trkKzkadr3kj2 = "";

        String trkKzktelno2 = "";

        C_UmuKbn tnsHuyouPostUmuKbn = C_UmuKbn.NONE;

        C_Tuukasyu sonotanyrankjnkngktuktype =  C_Tuukasyu.BLNK;

        BizCurrency sonotanyrankjnkngk = null;

        BizNumber sonotanyrankjnkngkrate = null;

        String sonotanyrankjnkngktuuka = "";

        BizNumber sonotanyranenkhrikmrate = null;

        BizNumber sonotanyranstigikwsrate = null;

        C_Tuukasyu sonotanyrannykntuktype =  C_Tuukasyu.BLNK;

        BizCurrency sonotanyrannykntuukap = null;

        String  sonotanyrannykntuukasyu = "";

        C_Tuukasyu sonotanyranpentuktype =  C_Tuukasyu.BLNK;

        BizCurrency sonotanyranpenknsngk = null;

        BizNumber sonotanyranmkhwariai = null;

        BizNumber kyksjkkktyouseiriritu = null;

        String fstpmsgcd = "";

        String fstponegaimsgcd = "";

        String dsmsgcd = "";

        String toiawasesakihanyoumsgcd = "";

        String annaihanyoumsgcd = "";

        IT_KykUkt nenkinUketorinin = null;

        IT_KykUkt kyksyaDairinin = null;

        C_KjkhukaKbn sbUktNmKjHukaKbn1st = C_KjkhukaKbn.BLNK;

        String kkdairinmKj = "";

        String uktnmkn1st = "";

        String sagyoukbn = "1";

        List<SibouSBean> sibouSBeanList = new ArrayList<>();

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(pSyuKykSyouhnLst.get(0).getSyouhncd(),
            pSyuKykSyouhnLst.get(0).getSyouhnsdno());

        BM_TantouCd tantouCdEntity = bizDomManager.getTantouCd(C_TantouCdKbn.DAIRITENJIMUKANRI);

        BizDate mosYmd =  pKykKihon.getMosymd();

        BizDate yendthnkymd = pSyuKykSyouhnLst.get(0).getYendthnkymd();

        if (pKykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.NKUKT).size() > 0) {

            nenkinUketorinin = pKykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.NKUKT).get(0);
        }

        if (pKykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.KYKDRN).size() > 0) {

            kyksyaDairinin = pKykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.KYKDRN).get(0);
        }

        if (pKykSonotaTkyk.getKykdrtkykhukaumu().eq(C_UmuKbn.ARI)) {

            kykDairitirasidouhuukbn = C_UmuKbn.ARI;

            GetKhKykdrInfo getkhkykdrinfo = SWAKInjector.getInstance(GetKhKykdrInfo.class);

            GetKhKykdrInfoBean getKhKykdrInfoBean = getkhkykdrinfo.exec(pKykKihon);

            kykdrnNmKjHukaKbn = getKhKykdrInfoBean.getKkdairinmKjkhukaKbn();

            if (C_KjkhukaKbn.KJKHUKA.eq(kykdrnNmKjHukaKbn)) {

                kykDairinm = getKhKykdrInfoBean.getKkdairinmKn();
            }
            else {

                kykDairinm = getKhKykdrInfoBean.getKkdairinmKj();

                kkdairinmKj = getKhKykdrInfoBean.getKkdairinmKj();
            }
        }


        String henkouSikibetuKey = pKCParm.getSikibetuKey(pKykKihon.getSyono());


        int sksyoukenskskbn;

        int sinkykjyoutai = 0;

        if (C_SinsaihkKbn.SIN.eq(pSinsaihkKbn) || (C_SinsaihkKbn.SAI.eq(pSinsaihkKbn) &&
            C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI.eq(pEditHokenSyoukenParam.getSyoukenSaihk()))) {

            sksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;

            if (C_SinsaihkKbn.SIN.eq(pSinsaihkKbn)) {

                sinkykjyoutai = KYKJI;
            }
            else if (C_SinsaihkKbn.SAI.eq(pSinsaihkKbn) &&
                C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI.eq(pEditHokenSyoukenParam.getSyoukenSaihk())) {

                sinkykjyoutai = SAISAKUSEIJI;
            }
        }
        else {

            sksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        }

        int syoukenUktMidasiKbn;

        if (C_UmuKbn.ARI.eq(syouhnZokusei.getNkuktumu())) {

            syoukenUktMidasiKbn = SBKFKUKT;
        }
        else {

            syoukenUktMidasiKbn = SBHKKUKT;
        }

        BizDate syoHakkoubi = null;

        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            SetSyokenhakkouymd setSyokenhakkouymd = SWAKInjector.getInstance(SetSyokenhakkouymd.class);

            syoHakkoubi = setSyokenhakkouymd.exec(pSyoriYmd);
        }
        else {

            syoHakkoubi = pSyoriYmd;
        }

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.BLNK;

        if (sksyoukenskskbn == SAIHAKKOUHOKENSYOUKEN) {

            IT_KykKihon kykKihon = new IT_KykKihon();

            kykKihon = hozenDomManager.getKykKihon(pKykKihon.getSyono());

            List<IT_KhTtdkRireki> ttdkRirekiList =
                kykKihon.getKhTtdkRirekisByGyoumuKousinKinou(
                    IKhozenCommonConstants.KINOUID_GENGAKU);

            if (ttdkRirekiList != null && ttdkRirekiList.size() > 0) {

                gengakuExistsCheck = C_UmuKbn.ARI;
            }

            List<IT_KhTtdkRireki> ttdkRirekiYendthnkList =
                kykKihon.getKhTtdkRirekisByGyoumuKousinKinou(
                    IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK);

            if (ttdkRirekiYendthnkList != null && ttdkRirekiYendthnkList.size() > 0) {

                List<IT_KhTtdkRireki> sortKhTtdkRirekiLst = new ArrayList<IT_KhTtdkRireki>(ttdkRirekiYendthnkList);
                sortKhTtdkRirekiLst = sortITKhTtdkRireki.OrderIT_KhTtdkRirekiByPkDesc(sortKhTtdkRirekiLst);

                yendthnkSyoriKbn = sortKhTtdkRirekiLst.get(0).getSyorikbn();
            }
        }

        BizCurrency kijyungaku = null;

        BizNumber fstpnyknymdrate = null;

        if (C_UmuKbn.NONE.eq(gengakuExistsCheck)) {
            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
                yennykntkhkKbn = C_Tkhukaumu.HUKA;
            } else {
                yennykntkhkKbn = C_Tkhukaumu.NONE;
            }

            if (!C_Tuukasyu.JPY.eq(pSyuKykSyouhnLst.get(0).getKyktuukasyu())) {

                KeisanKijyungk keisanKijyungk = SWAKInjector.getInstance(KeisanKijyungk.class);

                C_ErrorKbn result = keisanKijyungk.exec(
                    pKykKihon.getFstpnyknymd()
                    ,pNyknJissekiRirekiLst.get(0).getRsgaku()
                    ,pKykKihon.getHrkp()
                    , pSyuKykSyouhnLst.get(0).getKyktuukasyu()
                    ,yennykntkhkKbn
                    );

                if (C_ErrorKbn.ERROR.eq(result)) {
                    throw new CommonBizAppException("基準金額が取得できませんでした。");
                }

                kijyungaku = keisanKijyungk.getKijyungk();

                fstpnyknymdrate = keisanKijyungk.getYenkawaserate();
            }

        } else {
            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {
                kijyungaku = pKykSonotaTkyk.getInitsbjiyenkasaiteihsygk();
            }

            else if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu())) {
                kijyungaku = pKykSonotaTkyk.getTargettkykkijyungk();
            }

            GetKawaseRate getFstKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

            getFstKawaseRate.exec(
                pKykKihon.getFstpnyknymd(),
                C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                pSyuKykSyouhnLst.get(0).getKyktuukasyu(),
                C_Tuukasyu.JPY,
                C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.NYUKINRATE,
                C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                C_YouhiKbn.HUYOU);

            fstpnyknymdrate = getFstKawaseRate.getKawaserate();
        }

        int syouhnhanteiKbn = SyouhinUtil.hantei(pSyuKykSyouhnLst.get(0).getSyouhncd());

        String kyktuukasyuNm = pSyuKykSyouhnLst.get(0).getKyktuukasyu().getContent();

        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            if (pKykSonotaTkyk.getStdrsktkyhkumu().eq(C_UmuKbn.ARI)) {

                stdrsktirasidouhuukbn = C_UmuKbn.ARI;
            }
        }
        else {

            if(C_StdrsktkyhnkKbn.HUKA.eq(pEditHokenSyoukenParam.getStdrsktkyhnkKbn()) ||
                C_StdrsktkyhnkKbn.HENKOU.eq(pEditHokenSyoukenParam.getStdrsktkyhnkKbn())) {

                stdrsktirasidouhuukbn = C_UmuKbn.ARI;
            }
        }

        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
            if (C_DirectServiceMosKbn.ENTRY.eq(pKykKihon.getDrctservicemoskbn())
                || C_DirectServiceMosKbn.CHECK.eq(pKykKihon.getDrctservicemoskbn())) {
                dsTirasiDouhuuKbn = C_UmuKbn.ARI;
            }
        }

        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
            if (C_HonninkakuninSyoruiKbn.KOKUMINKENKOUHOKEN.eq(pKykKihon.getKykhonninkakninsyoruikbn())
                || C_HonninkakuninSyoruiKbn.KENKOUHOKEN.eq(pKykKihon.getKykhonninkakninsyoruikbn())
                || C_HonninkakuninSyoruiKbn.SENINHOKEN.eq(pKykKihon.getKykhonninkakninsyoruikbn())
                || C_HonninkakuninSyoruiKbn.KAIGOHOKEN.eq(pKykKihon.getKykhonninkakninsyoruikbn())
                || C_HonninkakuninSyoruiKbn.KOUKIKOUREISYAIRYOU.eq(pKykKihon.getKykhonninkakninsyoruikbn())
                || C_HonninkakuninSyoruiKbn.KENKOUHOKENHIYATOI.eq(pKykKihon.getKykhonninkakninsyoruikbn())
                || C_HonninkakuninSyoruiKbn.KOKKAKOUMUINKYOUSAI.eq(pKykKihon.getKykhonninkakninsyoruikbn())
                || C_HonninkakuninSyoruiKbn.TIHOUKOUMUINKYOUSAI.eq(pKykKihon.getKykhonninkakninsyoruikbn())
                || C_HonninkakuninSyoruiKbn.SIRITUGAKKOUKYOUINKYOUSAI.eq(pKykKihon.getKykhonninkakninsyoruikbn())
                || C_HonninkakuninSyoruiKbn.KOKUMINNENKIN.eq(pKykKihon.getKykhonninkakninsyoruikbn())
                || C_HonninkakuninSyoruiKbn.JIDOUHUYOUTEATE.eq(pKykKihon.getKykhonninkakninsyoruikbn())
                || C_HonninkakuninSyoruiKbn.TOKUBETUJIDOUHUYOUTEATE.eq(pKykKihon.getKykhonninkakninsyoruikbn())
                || C_HonninkakuninSyoruiKbn.BOSIKENKOU.eq(pKykKihon.getKykhonninkakninsyoruikbn())
                || C_HonninkakuninSyoruiKbn.GAIKOKUSEIHUKOKUSAIKIKAN.eq(pKykKihon.getKykhonninkakninsyoruikbn())
                || C_HonninkakuninSyoruiKbn.KOJINKOUTEKISYOUMEIYUUSOU.eq(pKykKihon.getKykhonninkakninsyoruikbn())
                || C_HonninkakuninSyoruiKbn.KOKUMINKENKOUHOKEN.eq(pKykKihon.getSkskknhonninkakninsyoruikbn())
                || C_HonninkakuninSyoruiKbn.KENKOUHOKEN.eq(pKykKihon.getSkskknhonninkakninsyoruikbn())
                || C_HonninkakuninSyoruiKbn.SENINHOKEN.eq(pKykKihon.getSkskknhonninkakninsyoruikbn())
                || C_HonninkakuninSyoruiKbn.KAIGOHOKEN.eq(pKykKihon.getSkskknhonninkakninsyoruikbn())
                || C_HonninkakuninSyoruiKbn.KOUKIKOUREISYAIRYOU.eq(pKykKihon.getSkskknhonninkakninsyoruikbn())
                || C_HonninkakuninSyoruiKbn.KENKOUHOKENHIYATOI.eq(pKykKihon.getSkskknhonninkakninsyoruikbn())
                || C_HonninkakuninSyoruiKbn.KOKKAKOUMUINKYOUSAI.eq(pKykKihon.getSkskknhonninkakninsyoruikbn())
                || C_HonninkakuninSyoruiKbn.TIHOUKOUMUINKYOUSAI.eq(pKykKihon.getSkskknhonninkakninsyoruikbn())
                || C_HonninkakuninSyoruiKbn.SIRITUGAKKOUKYOUINKYOUSAI.eq(pKykKihon.getSkskknhonninkakninsyoruikbn())
                || C_HonninkakuninSyoruiKbn.KOKUMINNENKIN.eq(pKykKihon.getSkskknhonninkakninsyoruikbn())
                || C_HonninkakuninSyoruiKbn.JIDOUHUYOUTEATE.eq(pKykKihon.getSkskknhonninkakninsyoruikbn())
                || C_HonninkakuninSyoruiKbn.TOKUBETUJIDOUHUYOUTEATE.eq(pKykKihon.getSkskknhonninkakninsyoruikbn())
                || C_HonninkakuninSyoruiKbn.BOSIKENKOU.eq(pKykKihon.getSkskknhonninkakninsyoruikbn())
                || C_HonninkakuninSyoruiKbn.GAIKOKUSEIHUKOKUSAIKIKAN.eq(pKykKihon.getSkskknhonninkakninsyoruikbn())
                || C_HonninkakuninSyoruiKbn.KOJINKOUTEKISYOUMEIYUUSOU.eq(pKykKihon.getSkskknhonninkakninsyoruikbn())) {
                tnsHuyouPostUmuKbn = C_UmuKbn.ARI;
            }
        }

        if (pSibouhokenLst != null && pSibouhokenLst.size() > 0) {

            for (int i = 0; i < pSibouhokenLst.size(); i++) {

                if (C_UktKbn.TOKUTEIMEIGI.eq(pSibouhokenLst.get(i).getUktkbn()) && C_KjkhukaKbn.KJKHUKA.eq(pSibouhokenLst.get(i).getUktnmkjkhukakbn())) {

                    sbUktNmKjHukaKbn = C_KjkhukaKbn.KJKHUKA;

                    break;
                }
            }

            sbUktNmKjHukaKbn1st = pSibouhokenLst.get(0).getUktnmkjkhukakbn();
        }

        List<String> uktnmkjLst = new ArrayList<>();

        List<BizNumber> uktBnwariList = new ArrayList<>();

        List<C_SyoukenUktMidasiKbn> syoukenuktmidasikbnLst = new ArrayList<>();

        List<C_SyoukenUktKbn> uktKbnLst = new ArrayList<>();

        String uktnmkj1st = "";

        if (nenkinUketorinin != null) {

            syoukenuktmidasikbnLst.add(C_SyoukenUktMidasiKbn.NKUKT);
            uktBnwariList.add(BizNumber.ZERO);
            uktnmkjLst.add("");

            if (C_UktKbn.KYK.eq(nenkinUketorinin.getUktkbn())) {
                uktKbnLst.add(C_SyoukenUktKbn.KYK);
            }

            else if (C_UktKbn.HHKN.eq(nenkinUketorinin.getUktkbn())) {
                uktKbnLst.add(C_SyoukenUktKbn.HHKN);
            }
        }

        if (pSibouhokenLst != null && pSibouhokenLst.size() > 0) {

            for (int i = 0; i < pSibouhokenLst.size(); i++) {

                if (C_KjkhukaKbn.KJKHUKA.eq(sbUktNmKjHukaKbn)) {

                    if (i == 0) {

                        if (pKykKihon.getSbuktnin() > 1) {

                            if (syoukenUktMidasiKbn == SBKFKUKT) {

                                syoukenuktmidasikbnLst.add(C_SyoukenUktMidasiKbn.SBKFKUKT);
                            }
                            else {

                                syoukenuktmidasikbnLst.add(C_SyoukenUktMidasiKbn.SBHKKUKT);
                            }
                            uktKbnLst.add(C_SyoukenUktKbn.HYOUJIRANNOTOORI);

                            uktnmkjLst.add("");
                        }
                        else {

                            if (syoukenUktMidasiKbn == SBKFKUKT) {

                                syoukenuktmidasikbnLst.add(C_SyoukenUktMidasiKbn.SBKFKUKT);
                            }
                            else {

                                syoukenuktmidasikbnLst.add(C_SyoukenUktMidasiKbn.SBHKKUKT);
                            }

                            uktnmkjLst.add("");

                            if (C_UktKbn.HHKN.eq(pSibouhokenLst.get(i).getUktkbn())) {

                                uktKbnLst.add(C_SyoukenUktKbn.HHKN);
                            }
                            else if (C_UktKbn.KYK.eq(pSibouhokenLst.get(i).getUktkbn())) {

                                uktKbnLst.add(C_SyoukenUktKbn.KYK);
                            }

                            else if (C_UktKbn.SOUZOKUNIN.eq(pSibouhokenLst.get(i).getUktkbn())) {

                                uktKbnLst.add(C_SyoukenUktKbn.SOUZOKU);
                            }

                            else if (C_UktKbn.TOKUTEIMEIGI.eq(pSibouhokenLst.get(i).getUktkbn())) {

                                uktKbnLst.add(C_SyoukenUktKbn.TOKUTEIMEIGI);
                            }
                        }
                    }
                }
                else {

                    if (pKykKihon.getSbuktnin() > 1) {

                        if (i == 0) {

                            if (syoukenUktMidasiKbn == SBKFKUKT) {

                                syoukenuktmidasikbnLst.add(C_SyoukenUktMidasiKbn.SBKFKUKT);
                            }
                            else {

                                syoukenuktmidasikbnLst.add(C_SyoukenUktMidasiKbn.SBHKKUKT);
                            }
                        }
                        else {

                            syoukenuktmidasikbnLst.add(C_SyoukenUktMidasiKbn.NONE);
                        }
                        uktKbnLst.add(C_SyoukenUktKbn.TOKUTEIMEIGI);

                        uktBnwariList.add(pSibouhokenLst.get(i).getUktbnwari());
                    }
                    else {
                        if (syoukenUktMidasiKbn == SBKFKUKT) {

                            syoukenuktmidasikbnLst.add(C_SyoukenUktMidasiKbn.SBKFKUKT);
                        }
                        else {

                            syoukenuktmidasikbnLst.add(C_SyoukenUktMidasiKbn.SBHKKUKT);
                        }

                        uktBnwariList.add(BizNumber.ZERO);

                        if (C_UktKbn.HHKN.eq(pSibouhokenLst.get(i).getUktkbn())) {

                            uktKbnLst.add(C_SyoukenUktKbn.HHKN);
                        }
                        else if (C_UktKbn.KYK.eq(pSibouhokenLst.get(i).getUktkbn())) {

                            uktKbnLst.add(C_SyoukenUktKbn.KYK);
                        }

                        else if (C_UktKbn.SOUZOKUNIN.eq(pSibouhokenLst.get(i).getUktkbn())) {

                            uktKbnLst.add(C_SyoukenUktKbn.SOUZOKU);
                        }

                        else if (C_UktKbn.TOKUTEIMEIGI.eq(pSibouhokenLst.get(i).getUktkbn())) {

                            uktKbnLst.add(C_SyoukenUktKbn.TOKUTEIMEIGI);
                        }
                    }

                    if (C_UktKbn.TOKUTEIMEIGI.eq(pSibouhokenLst.get(i).getUktkbn())) {

                        uktnmkjLst.add(pSibouhokenLst.get(i).getUktnmkj());
                    }
                    else {

                        uktnmkjLst.add("");
                    }
                }
                if (i == 0) {

                    if (nenkinUketorinin != null) {

                        uktnmkj1st = uktnmkjLst.get(i + 1);
                        uktnmkn1st = pSibouhokenLst.get(i).getUktnmkn();
                    }
                    else {

                        uktnmkj1st = uktnmkjLst.get(i);
                        uktnmkn1st = pSibouhokenLst.get(i).getUktnmkn();
                    }
                }
            }
        }
        else {
            if (pKykKihon.getSbuktnin() > 4) {

                if (syoukenUktMidasiKbn == SBKFKUKT) {

                    syoukenuktmidasikbnLst.add(C_SyoukenUktMidasiKbn.SBKFKUKT);
                }
                else {

                    syoukenuktmidasikbnLst.add(C_SyoukenUktMidasiKbn.SBHKKUKT);
                }

                uktKbnLst.add(C_SyoukenUktKbn.HYOUJIRANNOTOORI);

                uktnmkjLst.add("");

                uktBnwariList.add(BizNumber.ZERO);
            }
        }

        if (kyksyaDairinin != null) {

            syoukenuktmidasikbnLst.add(C_SyoukenUktMidasiKbn.HKKYKSDR);

            uktKbnLst.add(C_SyoukenUktKbn.TOKUTEIMEIGI);

            uktnmkjLst.add(kkdairinmKj);
        }

        if (pSiteiDairi != null) {

            if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

                if (sinkykjyoutai == KYKJI) {

                    if (BizDateUtil.compareYmd(mosYmd, KIRIKAEMAE_YMD) == BizDateUtil.COMPARE_LESSER ||
                        BizDateUtil.compareYmd(mosYmd, KIRIKAEMAE_YMD) == BizDateUtil.COMPARE_EQUAL) {

                        syoukenuktmidasikbnLst.add(C_SyoukenUktMidasiKbn.STDR);
                    }
                    else {

                        syoukenuktmidasikbnLst.add(C_SyoukenUktMidasiKbn.HHKSDR);
                    }
                }
                else if (sinkykjyoutai == SAISAKUSEIJI) {

                    if (BizDateUtil.compareYmd(mosYmd, KIRIKAE_YMD) == BizDateUtil.COMPARE_EQUAL ||
                        BizDateUtil.compareYmd(mosYmd, KIRIKAE_YMD) == BizDateUtil.COMPARE_GREATER ||
                        BizDateUtil.compareYmd(pSyoriYmd, KIRIKAE_YMD) == BizDateUtil.COMPARE_EQUAL ||
                        BizDateUtil.compareYmd(pSyoriYmd, KIRIKAE_YMD) == BizDateUtil.COMPARE_GREATER) {

                        syoukenuktmidasikbnLst.add(C_SyoukenUktMidasiKbn.HHKSDR);
                    }
                    else {

                        syoukenuktmidasikbnLst.add(C_SyoukenUktMidasiKbn.STDR);
                    }
                }
            }
            else {

                if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
                    syouhnhanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

                    syoukenuktmidasikbnLst.add(C_SyoukenUktMidasiKbn.HHKSDR);
                }
                else {

                    syoukenuktmidasikbnLst.add(C_SyoukenUktMidasiKbn.HHKSDROLD);
                }
            }

            if (C_UktKbn.KYK.eq(pSiteiDairi.getUktkbn())) {

                uktKbnLst.add(C_SyoukenUktKbn.TOKUTEIMEIGI);

                if (!C_KjkhukaKbn.KJKHUKA.eq(pKykSya.getKyknmkjkhukakbn())) {

                    uktnmkjLst.add(pKykSya.getKyknmkj());

                    hhkndairinm = pKykSya.getKyknmkj();
                }
                else {

                    uktnmkjLst.add("");

                    hhkndairinm = pKykSya.getKyknmkn();
                }
            }
            else if (C_UktKbn.SBUK.eq(pSiteiDairi.getUktkbn())) {

                uktKbnLst.add(C_SyoukenUktKbn.TOKUTEIMEIGI);
                uktnmkjLst.add(uktnmkj1st);

                if (!C_KjkhukaKbn.KJKHUKA.eq(sbUktNmKjHukaKbn)) {

                    hhkndairinm = uktnmkj1st;
                }
                else {

                    hhkndairinm = uktnmkn1st;
                }
            }
            else if (C_UktKbn.TOUROKUKAZOKU1.eq(pSiteiDairi.getUktkbn()) ||
                C_UktKbn.TOUROKUKAZOKU2.eq(pSiteiDairi.getUktkbn())) {

                uktKbnLst.add(C_SyoukenUktKbn.TOKUTEIMEIGI);

                IT_TrkKzk trkKzk = null;

                if (C_UktKbn.TOUROKUKAZOKU1.eq(pSiteiDairi.getUktkbn())) {

                    trkKzk = pKykKihon.getTrkKzkByTrkKzkKbn(C_TrkKzkKbn.TRKKZK1);
                }
                else {

                    trkKzk = pKykKihon.getTrkKzkByTrkKzkKbn(C_TrkKzkKbn.TRKKZK2);
                }

                if (!C_KjkhukaKbn.KJKHUKA.eq(trkKzk.getTrkkzknmkjkhukakbn())) {

                    uktnmkjLst.add(trkKzk.getTrkkzknmkj());

                    hhkndairinm = trkKzk.getTrkkzknmkj();
                }
                else {

                    uktnmkjLst.add("");

                    hhkndairinm = trkKzk.getTrkkzknmkn();
                }
            }
            else if (C_UktKbn.TOKUTEIMEIGI.eq(pSiteiDairi.getUktkbn())) {

                uktKbnLst.add(C_SyoukenUktKbn.TOKUTEIMEIGI);

                if (!C_KjkhukaKbn.KJKHUKA.eq(pSiteiDairi.getUktnmkjkhukakbn())) {

                    uktnmkjLst.add(pSiteiDairi.getUktnmkj());

                    hhkndairinm = pSiteiDairi.getUktnmkj();
                }
                else {

                    uktnmkjLst.add("");
                    hhkndairinm = pSiteiDairi.getUktnmkn();
                }
            }
            else if (C_UktKbn.NASI.eq(pSiteiDairi.getUktkbn())) {

                uktKbnLst.add(C_SyoukenUktKbn.NASI);
                uktnmkjLst.add("");
            }
        }

        int syoukenuktmidasikbnLstCnt = syoukenuktmidasikbnLst.size();

        for (int i = 0; i < UKETORIHITOLSTMAXCNT - syoukenuktmidasikbnLstCnt; i++) {
            syoukenuktmidasikbnLst.add(C_SyoukenUktMidasiKbn.BLNK);
        }

        int uktKbnLstCnt = uktKbnLst.size();

        for (int i = 0; i < UKETORIHITOLSTMAXCNT - uktKbnLstCnt; i++) {
            uktKbnLst.add(C_SyoukenUktKbn.BLNK);
        }

        int uktnmkjLstCnt = uktnmkjLst.size();

        for (int i = 0; i < UKETORIHITOLSTMAXCNT - uktnmkjLstCnt; i++) {
            uktnmkjLst.add("");
        }

        int uktBnwariListCnt = uktBnwariList.size();

        for (int i = 0; i < UKETORIHITOLSTMAXCNT - uktBnwariListCnt; i++) {
            uktBnwariList.add(BizNumber.ZERO);
        }

        List<IT_TrkKzk> trkKzkList = pKykKihon.getTrkKzks();

        if(trkKzkList != null && trkKzkList.size() > 0){

            for (IT_TrkKzk trkKzk : trkKzkList) {

                if (C_TrkKzkKbn.TRKKZK1.eq(trkKzk.getTrkkzkkbn())) {

                    kzkTirasidouhuukbn1 = C_UmuKbn.ARI;

                    if (C_KjkhukaKbn.KJKHUKA.eq(trkKzk.getTrkkzknmkjkhukakbn())) {

                        trkKzknm1 = trkKzk.getTrkkzknmkn();
                    }
                    else {

                        trkKzknm1 = trkKzk.getTrkkzknmkj();
                    }
                    trkKzksei1 = trkKzk.getTrkkzksei();
                    trkKzkseiymd1 = trkKzk.getTrkkzkseiymd();
                    trkKzkyno1 = trkKzk.getTrkkzkyno();
                    trkKzkadr1kj1 = trkKzk.getTrkkzkadr1kj();
                    trkKzkadr2kj1 = trkKzk.getTrkkzkadr2kj();
                    trkKzkadr3kj1 = trkKzk.getTrkkzkadr3kj();
                    trkKzktelno1 = trkKzk.getTrkkzktelno();
                }
                if (C_TrkKzkKbn.TRKKZK2.eq(trkKzk.getTrkkzkkbn())) {

                    kzkTirasidouhuukbn2 = C_UmuKbn.ARI;

                    if (C_KjkhukaKbn.KJKHUKA.eq(trkKzk.getTrkkzknmkjkhukakbn())) {

                        trkKzknm2 = trkKzk.getTrkkzknmkn();
                    }
                    else {

                        trkKzknm2 = trkKzk.getTrkkzknmkj();
                    }

                    if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN &&
                        C_UmuKbn.NONE.eq(kzkTirasidouhuukbn1)) {

                        kzkTirasidouhuukbn2 = C_UmuKbn.NONE;
                        kzkTirasidouhuukbn1 = C_UmuKbn.ARI;

                        trkKzknm1 = trkKzknm2;
                        trkKzksei1 = trkKzk.getTrkkzksei();
                        trkKzkseiymd1 = trkKzk.getTrkkzkseiymd();
                        trkKzkyno1 = trkKzk.getTrkkzkyno();
                        trkKzkadr1kj1 = trkKzk.getTrkkzkadr1kj();
                        trkKzkadr2kj1 = trkKzk.getTrkkzkadr2kj();
                        trkKzkadr3kj1 = trkKzk.getTrkkzkadr3kj();
                        trkKzktelno1 = trkKzk.getTrkkzktelno();
                    }
                    else {

                        trkKzksei2 = trkKzk.getTrkkzksei();
                        trkKzkseiymd2 = trkKzk.getTrkkzkseiymd();
                        trkKzkyno2 = trkKzk.getTrkkzkyno();
                        trkKzkadr1kj2 = trkKzk.getTrkkzkadr1kj();
                        trkKzkadr2kj2 = trkKzk.getTrkkzkadr2kj();
                        trkKzkadr3kj2 = trkKzk.getTrkkzkadr3kj();
                        trkKzktelno2 = trkKzk.getTrkkzktelno();
                    }
                }
            }
        }

        if (pSiteiDairi != null) {

            stdrNmKjHukaKbn = C_KjkhukaKbn.BLNK;

            if (C_UktKbn.KYK.eq(pSiteiDairi.getUktkbn())) {

                stdrNmKjHukaKbn = pKykSya.getKyknmkjkhukakbn();
            }

            if (C_UktKbn.SBUK.eq(pSiteiDairi.getUktkbn())) {

                stdrNmKjHukaKbn = sbUktNmKjHukaKbn1st;
            }

            if (C_UktKbn.TOKUTEIMEIGI.eq(pSiteiDairi.getUktkbn())) {

                if (C_KjkhukaKbn.KJKHUKA.eq(pSiteiDairi.getUktnmkjkhukakbn())) {

                    stdrNmKjHukaKbn = pSiteiDairi.getUktnmkjkhukakbn();
                }
            }
        }

        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            BizDate syoyousinkyksyohakkouymd = pKykKihon.getSyoyousinkyksyohakkouymd();

            if (BizDateUtil.compareYmd(mosYmd, KIRIKAE_YMD) == BizDateUtil.COMPARE_GREATER ||
                BizDateUtil.compareYmd(mosYmd, KIRIKAE_YMD) == BizDateUtil.COMPARE_EQUAL) {

                yakkanNewoldkbn = "1";
            }
            else {

                if (BizDateUtil.compareYmd(syoyousinkyksyohakkouymd, KIRIKAE_YMD) == BizDateUtil.COMPARE_GREATER ||
                    BizDateUtil.compareYmd(syoyousinkyksyohakkouymd, KIRIKAE_YMD) == BizDateUtil.COMPARE_EQUAL) {

                    skhTirasidouhuukbn = C_UmuKbn.ARI;
                }

                yakkanNewoldkbn = "2";
            }
        }

        List<String> drtenCdList = new ArrayList<>();

        List<String> oyaDrtenCdList = new ArrayList<>();

        List<String> drtenNmList = new ArrayList<>();

        List<C_Channelcd> channelCdList = new ArrayList<>();

        C_UmuKbn drtenNmLentyoukaUmu = C_UmuKbn.NONE;

        if (pKykDairitenLst.size() > 0) {

            for (int n = 0; n < pKykDairitenLst.size(); n++) {

                drtenCdList.add(pKykDairitenLst.get(n).getDrtencd());
            }

            BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

            for (int n = 0; n < drtenCdList.size(); n++) {

                List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(drtenCdList.get(n));

                if (bzGetAgInfoBeanList.get(1).getKanjiHoujinSyougou().length() > 20) {

                    drtenNmList.add("");

                    drtenNmLentyoukaUmu = C_UmuKbn.ARI;
                }
                else {
                    drtenNmList.add(bzGetAgInfoBeanList.get(1).getKanjiHoujinSyougou());
                }
                channelCdList.add(bzGetAgInfoBeanList.get(1).getChannelCd());

                oyaDrtenCdList.add(bzGetAgInfoBeanList.get(1).getOyadrtenCd());
            }

            if(oyaDrtenCdList.size() > 1 && oyaDrtenCdList.get(1) != null && oyaDrtenCdList.get(0).equals(oyaDrtenCdList.get(1))) {

                drtenNmList.set(1, "");
            }
        }

        List<String> kzktourokuservicemsgLst = new ArrayList<>();

        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            if ((sinkykjyoutai == KYKJI &&
                (BizDateUtil.compareYmd(mosYmd, KIRIKAE_YMD) == BizDateUtil.COMPARE_EQUAL ||
                BizDateUtil.compareYmd(mosYmd, KIRIKAE_YMD) == BizDateUtil.COMPARE_GREATER)) ||
                (sinkykjyoutai == SAISAKUSEIJI &&
                ((BizDateUtil.compareYmd(mosYmd, KIRIKAE_YMD) == BizDateUtil.COMPARE_EQUAL ||
                BizDateUtil.compareYmd(mosYmd, KIRIKAE_YMD) == BizDateUtil.COMPARE_GREATER) ||
                (BizDateUtil.compareYmd(pSyoriYmd, KIRIKAE_YMD) == BizDateUtil.COMPARE_EQUAL ||
                BizDateUtil.compareYmd(pSyoriYmd, KIRIKAE_YMD) == BizDateUtil.COMPARE_GREATER)))) {

                if (C_UmuKbn.ARI.eq(kzkTirasidouhuukbn1) ||
                    C_UmuKbn.ARI.eq(kzkTirasidouhuukbn2)||
                    C_UmuKbn.ARI.eq(kykDairitirasidouhuukbn)) {

                    kzktourokuservicemsgLst.add("13310");

                    if (C_UmuKbn.ARI.eq(kzkTirasidouhuukbn1) ||
                        C_UmuKbn.ARI.eq(kzkTirasidouhuukbn2)) {

                        kzktourokuservicemsgLst.add("13311");

                        if (C_UmuKbn.ARI.eq(kzkTirasidouhuukbn1) &&
                            C_UmuKbn.ARI.eq(kzkTirasidouhuukbn2)) {

                            kzktourokuservicemsgLst.add("13320");
                            kzktourokuservicemsgLst.add("13330");

                            if (BizDateUtil.compareYmd(mosYmd, KYOUTUUJOUKEN1_YMD) == BizDateUtil.COMPARE_GREATER ||
                                BizDateUtil.compareYmd(mosYmd, KYOUTUUJOUKEN1_YMD) == BizDateUtil.COMPARE_EQUAL) {

                                if (C_TyokusouhtkekKbn.TYOKUSOUTSY.eq(pEditHokenSyoukenParam.getTrkkzk1thkk()) &&
                                    C_TyokusouhtkekKbn.TYOKUSOUTSYGAI.eq(pEditHokenSyoukenParam.getTrkkzk2thkk())) {

                                    kzktourokuservicemsgLst.add("13342");
                                }
                                else if (C_TyokusouhtkekKbn.TYOKUSOUTSYGAI.eq(pEditHokenSyoukenParam.getTrkkzk1thkk()) &&
                                    C_TyokusouhtkekKbn.TYOKUSOUTSY.eq(pEditHokenSyoukenParam.getTrkkzk2thkk())) {

                                    kzktourokuservicemsgLst.add("13343");
                                }
                                else if (C_TyokusouhtkekKbn.TYOKUSOUTSY.eq(pEditHokenSyoukenParam.getTrkkzk1thkk()) &&
                                    C_TyokusouhtkekKbn.TYOKUSOUTSY.eq(pEditHokenSyoukenParam.getTrkkzk2thkk())) {

                                    kzktourokuservicemsgLst.add("13344");
                                }
                                else {

                                    kzktourokuservicemsgLst.add("13340");
                                }
                            }
                            else {

                                kzktourokuservicemsgLst.add("13340");
                            }
                        }
                        else {

                            kzktourokuservicemsgLst.add("13320");

                            if (BizDateUtil.compareYmd(mosYmd, KYOUTUUJOUKEN1_YMD) == BizDateUtil.COMPARE_GREATER ||
                                BizDateUtil.compareYmd(mosYmd, KYOUTUUJOUKEN1_YMD) == BizDateUtil.COMPARE_EQUAL) {

                                if (C_TyokusouhtkekKbn.TYOKUSOUTSY.eq(pEditHokenSyoukenParam.getTrkkzk1thkk()) ||
                                    C_TyokusouhtkekKbn.TYOKUSOUTSY.eq(pEditHokenSyoukenParam.getTrkkzk2thkk())) {

                                    kzktourokuservicemsgLst.add("13342");
                                }
                                else {

                                    kzktourokuservicemsgLst.add("13340");
                                }
                            }
                            else {

                                kzktourokuservicemsgLst.add("13340");
                            }
                        }

                        if (C_UmuKbn.ARI.eq(kykDairitirasidouhuukbn)) {

                            kzktourokuservicemsgLst.add("13350");
                        }
                        else {

                            kzktourokuservicemsgLst.add("13351");
                        }
                    }
                    else {

                        kzktourokuservicemsgLst.add("13341");
                        kzktourokuservicemsgLst.add("13350");
                    }

                    if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getStdrsktkyhkumu())) {

                        if (C_UmuKbn.ARI.eq(syouhnZokusei.getNkuktumu())) {

                            if (C_Tdk.HONNIN.eq(pKykSya.getKkkyktdk())) {

                                kzktourokuservicemsgLst.add("13371");
                            }
                            else {

                                if (nenkinUketorinin != null && C_UktKbn.HHKN.eq(nenkinUketorinin.getUktkbn())) {

                                    kzktourokuservicemsgLst.add("13381");
                                }
                                else {

                                    kzktourokuservicemsgLst.add("13392");
                                }
                            }
                        }
                        else {

                            kzktourokuservicemsgLst.add("13360");
                        }
                    }
                    else {

                        if (C_UmuKbn.ARI.eq(syouhnZokusei.getNkuktumu())) {

                            if (C_Tdk.HONNIN.eq(pKykSya.getKkkyktdk()) ||
                                (nenkinUketorinin != null && C_UktKbn.HHKN.eq(nenkinUketorinin.getUktkbn()))) {

                                kzktourokuservicemsgLst.add("13400");
                            }
                        }
                        else {

                            kzktourokuservicemsgLst.add("13400");
                        }
                    }
                }
            }
        }
        else {

            if (C_UmuKbn.ARI.eq(kzkTirasidouhuukbn1) ||
                C_UmuKbn.ARI.eq(kzkTirasidouhuukbn2)||
                C_UmuKbn.ARI.eq(kykDairitirasidouhuukbn)) {

                kzktourokuservicemsgLst.add("13310");

                if (C_UmuKbn.ARI.eq(kzkTirasidouhuukbn1) ||
                    C_UmuKbn.ARI.eq(kzkTirasidouhuukbn2)) {

                    kzktourokuservicemsgLst.add("13311");

                    if (C_UmuKbn.ARI.eq(kzkTirasidouhuukbn1) &&
                        C_UmuKbn.ARI.eq(kzkTirasidouhuukbn2)) {

                        kzktourokuservicemsgLst.add("13320");
                        kzktourokuservicemsgLst.add("13330");
                        kzktourokuservicemsgLst.add("13340");
                    }
                    else if (C_UmuKbn.ARI.eq(kzkTirasidouhuukbn1) &&
                        C_UmuKbn.NONE.eq(kzkTirasidouhuukbn2)) {

                        kzktourokuservicemsgLst.add("13320");
                        kzktourokuservicemsgLst.add("13331");
                        kzktourokuservicemsgLst.add("13340");
                    }
                    else if (C_UmuKbn.NONE.eq(kzkTirasidouhuukbn1) &&
                        C_UmuKbn.ARI.eq(kzkTirasidouhuukbn2)) {

                        kzktourokuservicemsgLst.add("13321");
                        kzktourokuservicemsgLst.add("13330");
                        kzktourokuservicemsgLst.add("13340");
                    }

                    if (C_UmuKbn.ARI.eq(kykDairitirasidouhuukbn)) {

                        kzktourokuservicemsgLst.add("13350");
                    }
                    else {

                        kzktourokuservicemsgLst.add("13351");
                    }
                }
                else {

                    kzktourokuservicemsgLst.add("13341");
                    kzktourokuservicemsgLst.add("13350");
                }

                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getStdrsktkyhkumu())) {

                    if (pSiteiDairi != null && C_UktKbn.NASI.eq(pSiteiDairi.getUktkbn())) {

                        if (C_UmuKbn.ARI.eq(syouhnZokusei.getNkuktumu())) {

                            if (C_Tdk.HONNIN.eq(pKykSya.getKkkyktdk())) {

                                kzktourokuservicemsgLst.add("13373");
                            }
                            else {

                                if (nenkinUketorinin != null && C_UktKbn.HHKN.eq(nenkinUketorinin.getUktkbn())) {


                                    kzktourokuservicemsgLst.add("13383");
                                }
                                else {

                                    kzktourokuservicemsgLst.add("13393");
                                }
                            }
                        }
                        else {

                            if (yendthnkymd == null) {

                                if (syouhnhanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

                                    kzktourokuservicemsgLst.add("13365");
                                }
                                else {

                                    kzktourokuservicemsgLst.add("13361");
                                }
                            }
                            else {

                                kzktourokuservicemsgLst.add("13363");
                            }
                        }
                    }
                    else {

                        if (C_UmuKbn.ARI.eq(syouhnZokusei.getNkuktumu())) {

                            if (C_Tdk.HONNIN.eq(pKykSya.getKkkyktdk())) {

                                kzktourokuservicemsgLst.add("13372");
                            }
                            else {

                                if (nenkinUketorinin != null && C_UktKbn.HHKN.eq(nenkinUketorinin.getUktkbn())) {

                                    kzktourokuservicemsgLst.add("13382");
                                }
                                else {

                                    kzktourokuservicemsgLst.add("13392");
                                }
                            }
                        }
                        else {

                            if (yendthnkymd == null) {

                                if (syouhnhanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

                                    kzktourokuservicemsgLst.add("13364");
                                }
                                else {

                                    kzktourokuservicemsgLst.add("13360");
                                }
                            }
                            else {

                                kzktourokuservicemsgLst.add("13362");
                            }
                        }
                    }
                }
                else {

                    kzktourokuservicemsgLst.add("13400");
                }
            }
        }

        int kzktourokuservicemsgLstCnt = kzktourokuservicemsgLst.size();

        for (int i = 0; i < KZKTOUROKUSERVICEMSGLSTMAXCNT - kzktourokuservicemsgLstCnt; i++) {

            kzktourokuservicemsgLst.add("");
        }

        String stdstmmsgcd = "";

        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getStdrsktkyhkumu())) {

            if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN &&
                ((sinkykjyoutai == KYKJI &&
                (BizDateUtil.compareYmd(mosYmd, KIRIKAEMAE_YMD) == BizDateUtil.COMPARE_LESSER ||
                BizDateUtil.compareYmd(mosYmd, KIRIKAEMAE_YMD) == BizDateUtil.COMPARE_EQUAL)) ||
                (sinkykjyoutai == SAISAKUSEIJI &&
                (BizDateUtil.compareYmd(mosYmd, KIRIKAEMAE_YMD) == BizDateUtil.COMPARE_LESSER ||
                BizDateUtil.compareYmd(mosYmd, KIRIKAEMAE_YMD) == BizDateUtil.COMPARE_EQUAL) &&
                (BizDateUtil.compareYmd(pSyoriYmd, KIRIKAEMAE_YMD) == BizDateUtil.COMPARE_LESSER ||
                BizDateUtil.compareYmd(pSyoriYmd, KIRIKAEMAE_YMD) == BizDateUtil.COMPARE_EQUAL)))) {

                if (C_UmuKbn.ARI.eq(syouhnZokusei.getNkuktumu())) {

                    if (C_Tdk.HONNIN.eq(pKykSya.getKkkyktdk())) {

                        stdstmmsgcd = "13142";
                    }
                    else {

                        if (nenkinUketorinin != null && C_UktKbn.HHKN.eq(nenkinUketorinin.getUktkbn())) {

                            stdstmmsgcd = "13144";
                        }
                        else {

                            stdstmmsgcd = "13145";
                        }
                    }
                }
                else {

                    stdstmmsgcd = "13140";
                }
            }
            else {

                if (C_UmuKbn.NONE.eq(kzkTirasidouhuukbn1) &&
                    C_UmuKbn.NONE.eq(kzkTirasidouhuukbn2) &&
                    C_UmuKbn.NONE.eq(kykDairitirasidouhuukbn)) {

                    if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

                        if (C_UmuKbn.ARI.eq(syouhnZokusei.getNkuktumu())) {

                            if (C_Tdk.HONNIN.eq(pKykSya.getKkkyktdk())) {

                                stdstmmsgcd = "13147";
                            }
                            else {

                                if (nenkinUketorinin != null && C_UktKbn.HHKN.eq(nenkinUketorinin.getUktkbn())) {

                                    stdstmmsgcd = "13148";
                                }
                                else {

                                    stdstmmsgcd = "13149";
                                }
                            }
                        }
                        else {

                            stdstmmsgcd = "13146";
                        }
                    }
                    else {

                        if (C_UmuKbn.ARI.eq(syouhnZokusei.getNkuktumu())) {

                            if (C_Tdk.HONNIN.eq(pKykSya.getKkkyktdk())) {

                                stdstmmsgcd = "13150";
                            }
                            else {

                                if (nenkinUketorinin != null && C_UktKbn.HHKN.eq(nenkinUketorinin.getUktkbn())) {

                                    stdstmmsgcd = "13151";
                                }
                                else {

                                    stdstmmsgcd = "13149";
                                }
                            }
                        }
                        else {

                            if (yendthnkymd == null) {

                                if (syouhnhanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

                                    stdstmmsgcd = "13153";
                                }
                                else {

                                    stdstmmsgcd = "13146";
                                }
                            }
                            else {

                                if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {

                                    stdstmmsgcd = "13152";
                                }

                                if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR) {

                                    stdstmmsgcd = "13146";
                                }
                            }
                        }
                    }
                }
            }
        }

        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            fstpmsgcd = "13150";

            if (C_FstphrkkeiroKbn.CREDIT.eq(pKykKihon.getFstphrkkeirokbn())) {

                fstponegaimsgcd = "13171";
            }
            else {

                fstponegaimsgcd = "13170";
            }

            if (C_DirectServiceMosKbn.ENTRY.eq(pKykKihon.getDrctservicemoskbn())
                || C_DirectServiceMosKbn.CHECK.eq(pKykKihon.getDrctservicemoskbn())) {

                dsmsgcd = "13180";

            }

            toiawasesakihanyoumsgcd = "13240";

            annaihanyoumsgcd = "13250";

        }

        List<C_TokusyuSyoriNaiyouKbn> tokusyuSyoriNaiyouKbnList = new ArrayList<>();

        if (BizUtil.isBlank(pHhknSya.getHhknnmkj()) || C_KjkhukaKbn.KJKHUKA.eq(pHhknSya.getHhknnmkjkhukakbn())) {

            tokusyuSyoriNaiyouKbnList.add(C_TokusyuSyoriNaiyouKbn.HHKNKANJIMEINASI);
        }

        if (BizUtil.isBlank(pKykSya.getKyknmkj()) || C_KjkhukaKbn.KJKHUKA.eq(pKykSya.getKyknmkjkhukakbn())) {

            tokusyuSyoriNaiyouKbnList.add(C_TokusyuSyoriNaiyouKbn.KYKKANJIMEINASI);
        }

        if (C_KjkhukaKbn.KJKHUKA.eq(sbUktNmKjHukaKbn)) {

            if (pSibouhokenLst != null && pSibouhokenLst.size() > 1) {

                tokusyuSyoriNaiyouKbnList.add(C_TokusyuSyoriNaiyouKbn.SBUKKANJIMEINASI_FUKUSUU);
            }
            else {

                tokusyuSyoriNaiyouKbnList.add(C_TokusyuSyoriNaiyouKbn.SBUKKANJIMEINASI);
            }
        }

        if (pSiteiDairi != null) {

            if (C_KjkhukaKbn.KJKHUKA.eq(stdrNmKjHukaKbn)) {

                tokusyuSyoriNaiyouKbnList.add(C_TokusyuSyoriNaiyouKbn.STDRNINKANJIMEINASI);
            }
        }

        if (kyksyaDairinin != null) {

            if (C_KjkhukaKbn.KJKHUKA.eq(kykdrnNmKjHukaKbn)) {

                tokusyuSyoriNaiyouKbnList.add(C_TokusyuSyoriNaiyouKbn.KYKDRNINKANJIMEINASI);
            }
        }

        if (BizUtil.isBlank(pKykSya.getTsinadr1kj()) ||
            (trkKzkList != null && trkKzkList.size() > 0 && BizUtil.isBlank(trkKzkadr1kj1))) {

            tokusyuSyoriNaiyouKbnList.add(C_TokusyuSyoriNaiyouKbn.KANJIADRNASI);
        }

        if (pKykKihon.getSbuktnin() >= 5) {

            tokusyuSyoriNaiyouKbnList.add(C_TokusyuSyoriNaiyouKbn.SBUKFUKUSUU);
        }

        if (pSibouhokenLst != null && pSibouhokenLst.size() > 0) {

            for (int n = 0; n < pSibouhokenLst.size(); n++) {

                if (pSibouhokenLst.get(n).getUktbnwari().compareTo(BizNumber.valueOf(0)) == 0) {

                    sbuBnwariUmu = C_UmuKbn.NONE;

                    break;
                }
            }
        }

        if (pSibouhokenLst != null && pSibouhokenLst.size() > 1 && C_UmuKbn.NONE.eq(sbuBnwariUmu)) {

            tokusyuSyoriNaiyouKbnList.add(C_TokusyuSyoriNaiyouKbn.SBUKBNWARINASI);
        }

        if ((pKhTtdkTyuui != null && C_KktyuitaKbn.DNGNMEMOARI.eq(pKhTtdkTyuui.getKktyuitakbn())) ||
            C_HassouKbn.HONSYAKAISOU.eq(pHassouKbn)) {

            tokusyuSyoriNaiyouKbnList.add(C_TokusyuSyoriNaiyouKbn.TTDKTYUUI_DNGNMEMOARI);
        }

        if (C_StknsetKbn.ARI.eq(pKykKihon.getStknsetkbn())) {

            tokusyuSyoriNaiyouKbnList.add(C_TokusyuSyoriNaiyouKbn.STKNSETARI);
        }

        if (pKhTtdkTyuui != null) {

            if (C_TtdktyuuiKbn.ADRKAKUNINUKE.eq(pKhTtdkTyuui.getTtdktyuuikbn1()) ||
                C_TtdktyuuiKbn.ADRKAKUNINUKE.eq(pKhTtdkTyuui.getTtdktyuuikbn2()) ||
                C_TtdktyuuiKbn.ADRKAKUNINUKE.eq(pKhTtdkTyuui.getTtdktyuuikbn3()) ||
                C_TtdktyuuiKbn.ADRKAKUNINUKE.eq(pKhTtdkTyuui.getTtdktyuuikbn4()) ||
                C_TtdktyuuiKbn.ADRKAKUNINUKE.eq(pKhTtdkTyuui.getTtdktyuuikbn5())) {

                tokusyuSyoriNaiyouKbnList.add(C_TokusyuSyoriNaiyouKbn.TTDKTYUUI_ADRKAKUNINUKE);
            }

            if (C_TtdktyuuiKbn.ADRHUMEI.eq(pKhTtdkTyuui.getTtdktyuuikbn1()) ||
                C_TtdktyuuiKbn.ADRHUMEI.eq(pKhTtdkTyuui.getTtdktyuuikbn2()) ||
                C_TtdktyuuiKbn.ADRHUMEI.eq(pKhTtdkTyuui.getTtdktyuuikbn3()) ||
                C_TtdktyuuiKbn.ADRHUMEI.eq(pKhTtdkTyuui.getTtdktyuuikbn4()) ||
                C_TtdktyuuiKbn.ADRHUMEI.eq(pKhTtdkTyuui.getTtdktyuuikbn5())) {

                tokusyuSyoriNaiyouKbnList.add(C_TokusyuSyoriNaiyouKbn.TTDKTYUUI_ADRHUMEI);
            }

            if (C_KykdrknHtdjytKbn.SETTEI.eq(pKhTtdkTyuui.getKykdrknhatudoujyoutai())) {

                if (C_TtdktyuuiKbn.ADRHUMEIKAZOKU1.eq(pKhTtdkTyuui.getTtdktyuuikbn1()) ||
                    C_TtdktyuuiKbn.ADRHUMEIKAZOKU1.eq(pKhTtdkTyuui.getTtdktyuuikbn2()) ||
                    C_TtdktyuuiKbn.ADRHUMEIKAZOKU1.eq(pKhTtdkTyuui.getTtdktyuuikbn3()) ||
                    C_TtdktyuuiKbn.ADRHUMEIKAZOKU1.eq(pKhTtdkTyuui.getTtdktyuuikbn4()) ||
                    C_TtdktyuuiKbn.ADRHUMEIKAZOKU1.eq(pKhTtdkTyuui.getTtdktyuuikbn5()) ||
                    C_TtdktyuuiKbn.ADRHUMEIKAZOKU2.eq(pKhTtdkTyuui.getTtdktyuuikbn1()) ||
                    C_TtdktyuuiKbn.ADRHUMEIKAZOKU2.eq(pKhTtdkTyuui.getTtdktyuuikbn2()) ||
                    C_TtdktyuuiKbn.ADRHUMEIKAZOKU2.eq(pKhTtdkTyuui.getTtdktyuuikbn3()) ||
                    C_TtdktyuuiKbn.ADRHUMEIKAZOKU2.eq(pKhTtdkTyuui.getTtdktyuuikbn4()) ||
                    C_TtdktyuuiKbn.ADRHUMEIKAZOKU2.eq(pKhTtdkTyuui.getTtdktyuuikbn5())) {

                    tokusyuSyoriNaiyouKbnList.add(C_TokusyuSyoriNaiyouKbn.TTDKTYUUI_ADRHUMEI);
                }
            }
        }

        if (C_UmuKbn.ARI.eq(pEditHokenSyoukenParam.getKariukeUmu())) {

            tokusyuSyoriNaiyouKbnList.add(C_TokusyuSyoriNaiyouKbn.KARIUKEKEIJOARI);
        }

        if (C_UmuKbn.ARI.eq(pEditHokenSyoukenParam.getHukusuuUmu())) {

            tokusyuSyoriNaiyouKbnList.add(C_TokusyuSyoriNaiyouKbn.DOUJITUSYOUKENFUKUSUUARI);
        }

        if (C_UmuKbn.ARI.eq(drtenNmLentyoukaUmu) && sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            tokusyuSyoriNaiyouKbnList.add(C_TokusyuSyoriNaiyouKbn.DAIRITENMEIMOJISUUTYOUKA);
        }

        if (sksyoukenskskbn == SAIHAKKOUHOKENSYOUKEN) {

            if (C_HnskariyuuKbn.YENDTHNKHR_ARI.eq(pEditHokenSyoukenParam.getHnskariyuu1()) ||
                C_HnskariyuuKbn.YENDTHNKHR_ARI.eq(pEditHokenSyoukenParam.getHnskariyuu2())) {

                tokusyuSyoriNaiyouKbnList.add(C_TokusyuSyoriNaiyouKbn.YENDTHNKHRARI);
            }

            if (C_HnskariyuuKbn.JIMU_ARI.eq(pEditHokenSyoukenParam.getHnskariyuu1()) ||
                C_HnskariyuuKbn.JIMU_ARI.eq(pEditHokenSyoukenParam.getHnskariyuu2())) {

                tokusyuSyoriNaiyouKbnList.add(C_TokusyuSyoriNaiyouKbn.BETUTTDKUKTKARI);
            }
        }

        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            if (C_YakkanJyuryouKbn.WEB_SASSI.eq(pKykKihon.getYakkanjyuryouhoukbn())) {

                tokusyuSyoriNaiyouKbnList.add(C_TokusyuSyoriNaiyouKbn.YAKKANSASSIYUUSOU);
            }
        }

        int tokusyuSyoriNaiyouKbnListCnt = tokusyuSyoriNaiyouKbnList.size();

        if (tokusyuSyoriNaiyouKbnListCnt == 1) {

            if (C_TokusyuSyoriNaiyouKbn.YAKKANSASSIYUUSOU.eq(tokusyuSyoriNaiyouKbnList.get(0))) {

                sagyoukbn = "2";
            }
        }

        for (int i = 0; i < 17 - tokusyuSyoriNaiyouKbnListCnt; i++) {

            tokusyuSyoriNaiyouKbnList.add(null);
        }


        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
            getKawaseRate.exec(
                pNyknJissekiRirekiLst.get(0).getRyosyuymd(),
                C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                pSyuKykSyouhnLst.get(0).getKyktuukasyu(),
                C_Tuukasyu.JPY,
                C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.NYUKINRATE,
                C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                C_YouhiKbn.HUYOU);

            sonotanyranenkhrikmrate = getKawaseRate.getKawaserate();
        }
        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getGaikanykntkhkumu())) {
            C_Tuukasyu tuukasyu = C_Tuukasyu.BLNK;

            if(C_Tuukasyu.USD.eq(pSyuKykSyouhnLst.get(0).getKyktuukasyu())) {
                tuukasyu = C_Tuukasyu.AUD;
            }
            else {
                tuukasyu = C_Tuukasyu.USD;
            }
            getKawaseRate.exec(
                pNyknJissekiRirekiLst.get(0).getRyosyuymd(),
                C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                pSyuKykSyouhnLst.get(0).getKyktuukasyu(),
                tuukasyu,
                C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.NYUKINRATE,
                C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                C_YouhiKbn.HUYOU);

            sonotanyranstigikwsrate = getKawaseRate.getKawaserate();
        }

        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
            kyksjkkktyouseiriritu = pSyuKykSyouhnLst.get(0).getKyksjkkktyouseiriritu();

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu()) ||
                C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu())) {
                if (C_UmuKbn.NONE.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
                    sonotanyrankjnkngktuktype = C_Tuukasyu.JPY;
                    sonotanyrankjnkngkrate = fstpnyknymdrate;
                    sonotanyrankjnkngktuuka = "円";
                    sonotanyrankjnkngk = kijyungaku;
                }
            }

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu()) || C_UmuKbn.ARI.eq(pKykSonotaTkyk.getGaikanykntkhkumu())) {
                sonotanyrannykntuktype =pNyknJissekiRirekiLst.get(0).getRstuukasyu();
                sonotanyrannykntuukap = pNyknJissekiRirekiLst.get(0).getRsgaku();
                sonotanyrannykntuukasyu = pNyknJissekiRirekiLst.get(0).getRstuukasyu().getContent();

            }
            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu()) && pKykSonotaTkyk.getTargettkmokuhyouti() > 0) {
                sonotanyranpentuktype = C_Tuukasyu.JPY;
                sonotanyranmkhwariai = BizNumber.valueOf(pKykSonotaTkyk.getTargettkmokuhyouti());
                sonotanyranpenknsngk = kijyungaku;
            }
        } else {
            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getInitsbjiyensitihsytkhukaumu()) ||
                C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu())) {
                if (C_UmuKbn.ARI.eq(gengakuExistsCheck)) {
                    sonotanyrankjnkngktuktype = C_Tuukasyu.JPY;
                    sonotanyrankjnkngk = kijyungaku;

                } else {
                    if (C_UmuKbn.NONE.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
                        sonotanyrankjnkngktuktype = C_Tuukasyu.JPY;
                        sonotanyrankjnkngk = kijyungaku;
                    }
                }
                if (C_UmuKbn.NONE.eq(pKykSonotaTkyk.getYennykntkhkumu())) {
                    sonotanyrankjnkngkrate = fstpnyknymdrate;
                    sonotanyrankjnkngktuuka = "円";
                }
            }
            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu()) ||
                C_UmuKbn.ARI.eq(pKykSonotaTkyk.getGaikanykntkhkumu())) {
                sonotanyrannykntuktype =pNyknJissekiRirekiLst.get(0).getRstuukasyu();
                sonotanyrannykntuukap = pNyknJissekiRirekiLst.get(0).getRsgaku();
                sonotanyrannykntuukasyu = pNyknJissekiRirekiLst.get(0).getRstuukasyu().getContent();
            }
            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getTargettkhkumu()) && pKykSonotaTkyk.getTargettkmokuhyouti() > 0) {
                sonotanyranpentuktype = C_Tuukasyu.JPY;
                sonotanyranmkhwariai = BizNumber.valueOf(pKykSonotaTkyk.getTargettkmokuhyouti());
                sonotanyranpenknsngk = kijyungaku;
            }
        }

        IT_HokenSyouken hokenSyouken = pKykKihon.createHokenSyouken();

        hokenSyouken.setTyouhyouymd(pSyoriYmd);

        hokenSyouken.setHenkousikibetukey(henkouSikibetuKey);

        hokenSyouken.setSyohakkouymd(syoHakkoubi);

        hokenSyouken.setSinsaihkkbn(pSinsaihkKbn);

        if(sksyoukenskskbn == SAIHAKKOUHOKENSYOUKEN) {

            hokenSyouken.setSyoukensaihkkbn(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        }
        else {

            hokenSyouken.setSyoukensaihkkbn(pEditHokenSyoukenParam.getSyoukenSaihk());
        }

        hokenSyouken.setStdrsktirasidouhuukbn(stdrsktirasidouhuukbn);

        hokenSyouken.setDstirasidouhuukbn(dsTirasiDouhuuKbn);

        hokenSyouken.setYakkanjyuryouhoukbn(pKykKihon.getYakkanjyuryouhoukbn());

        hokenSyouken.setYakkanbunsyono(pKykKihon.getYakkanbunsyono());

        hokenSyouken.setInsizeishryouhikbn(pEditHokenSyoukenParam.getInsizeiShryouhi());

        if (tokusyuSyoriNaiyouKbnList.get(0) != null) {

            if (tokusyuSyoriNaiyouKbnListCnt == 1 &&
                C_TokusyuSyoriNaiyouKbn.YENDTHNKHRARI.eq(tokusyuSyoriNaiyouKbnList.get(0))) {

                hokenSyouken.setHassoukbn(C_HassouKbn.TYOKUSOU);

                tokusyuSyoriNaiyouKbnList.set(0, C_TokusyuSyoriNaiyouKbn.BLNK);
            }
            else {

                hokenSyouken.setHassoukbn(C_HassouKbn.HONSYAKAISOU);
            }
        }
        else {

            hokenSyouken.setHassoukbn(pHassouKbn);
        }

        if ((syouhnhanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN &&
            (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getZeiseitkkktkykhukaumu()) ||
                pSyuKykSyouhnLst.get(0).getKykymd().compareTo(BizDate.valueOf(pSyuKykSyouhnLst.get(0).getKykymd().getYear(), 8, 31)) <= 0)) ||
                (syouhnhanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN &&
                C_Hrkkaisuu.TUKI.eq(pKykKihon.getHrkkaisuu()) &&
                (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu()) ||
                    (!C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu()) &&
                        pSyuKykSyouhnLst.get(0).getKykymd().compareTo(BizDate.valueOf(pSyuKykSyouhnLst.get(0).getKykymd().getYear(), 8, 31)) <= 0)))) {

            hokenSyouken.setKoujyosyoumeiumukbn(C_UmuKbn.NONE);
        }
        else {

            hokenSyouken.setKoujyosyoumeiumukbn(C_UmuKbn.ARI);
            hokenSyouken.setNenkoujyosyoumeihskmsgcd("15049");
        }

        if (sksyoukenskskbn == SAIHAKKOUHOKENSYOUKEN) {

            hokenSyouken.setKanryoutuutiumukbn(C_UmuKbn.ARI);
        }
        else {

            hokenSyouken.setKanryoutuutiumukbn(C_UmuKbn.NONE);
        }

        hokenSyouken.setSuiihyouumukbn(C_UmuKbn.ARI);

        hokenSyouken.setHanbainm("");

        hokenSyouken.setAisyoumeikbn(pKykKihon.getAisyoumeikbn());

        hokenSyouken.setSeisikihknnm(syouhnZokusei.getSyouhnnmsyouken());

        if (sksyoukenskskbn == SAIHAKKOUHOKENSYOUKEN) {

            hokenSyouken.setKouryokukaisiymd(pSyuKykSyouhnLst.get(0).getKouryokuhasseiymd());
        }
        else {

            hokenSyouken.setKouryokukaisiymd(null);
        }

        hokenSyouken.setKyknmkj(pKykSya.getKyknmkj());

        hokenSyouken.setKyknmkjkhukakbn(pKykSya.getKyknmkjkhukakbn());

        hokenSyouken.setHhknnmkj(pHhknSya.getHhknnmkj());

        hokenSyouken.setHhknnmkjkhukakbn(pHhknSya.getHhknnmkjkhukakbn());

        hokenSyouken.setHhknseiymd(pHhknSya.getHhknseiymd());

        hokenSyouken.setHhknsei(pHhknSya.getHhknsei());

        hokenSyouken.setHhknnen(pSyuKykSyouhnLst.get(0).getHhknnen());

        hokenSyouken.setSyoukenuktmidasikbn1(syoukenuktmidasikbnLst.get(0));

        hokenSyouken.setSyoukenuktmidasikbn2(syoukenuktmidasikbnLst.get(1));

        hokenSyouken.setSyoukenuktmidasikbn3(syoukenuktmidasikbnLst.get(2));

        hokenSyouken.setSyoukenuktmidasikbn4(syoukenuktmidasikbnLst.get(3));

        hokenSyouken.setSyoukenuktmidasikbn5(syoukenuktmidasikbnLst.get(4));

        hokenSyouken.setSyoukenuktmidasikbn6(syoukenuktmidasikbnLst.get(5));

        hokenSyouken.setSyoukenuktmidasikbn7(syoukenuktmidasikbnLst.get(6));

        hokenSyouken.setSyoukenuktmidasikbn8(syoukenuktmidasikbnLst.get(7));

        hokenSyouken.setSyoukenuktmidasikbn9(syoukenuktmidasikbnLst.get(8));

        hokenSyouken.setSyoukenuktmidasikbn10(syoukenuktmidasikbnLst.get(9));

        hokenSyouken.setSyoukenuktkbn1(uktKbnLst.get(0));

        hokenSyouken.setSyoukenuktkbn2(uktKbnLst.get(1));

        hokenSyouken.setSyoukenuktkbn3(uktKbnLst.get(2));

        hokenSyouken.setSyoukenuktkbn4(uktKbnLst.get(3));

        hokenSyouken.setSyoukenuktkbn5(uktKbnLst.get(4));

        hokenSyouken.setSyoukenuktkbn6(uktKbnLst.get(5));

        hokenSyouken.setSyoukenuktkbn7(uktKbnLst.get(6));

        hokenSyouken.setSyoukenuktkbn8(uktKbnLst.get(7));

        hokenSyouken.setSyoukenuktkbn9(uktKbnLst.get(8));

        hokenSyouken.setSyoukenuktkbn10(uktKbnLst.get(9));

        hokenSyouken.setSyoukenuktnm1(uktnmkjLst.get(0));

        hokenSyouken.setSyoukenuktnm2(uktnmkjLst.get(1));

        hokenSyouken.setSyoukenuktnm3(uktnmkjLst.get(2));

        hokenSyouken.setSyoukenuktnm4(uktnmkjLst.get(3));

        hokenSyouken.setSyoukenuktnm5(uktnmkjLst.get(4));

        hokenSyouken.setSyoukenuktnm6(uktnmkjLst.get(5));

        hokenSyouken.setSyoukenuktnm7(uktnmkjLst.get(6));

        hokenSyouken.setSyoukenuktnm8(uktnmkjLst.get(7));

        hokenSyouken.setSyoukenuktnm9(uktnmkjLst.get(8));

        hokenSyouken.setSyoukenuktnm10(uktnmkjLst.get(9));

        hokenSyouken.setSyoukenuktbnwari1(uktBnwariList.get(0));

        hokenSyouken.setSyoukenuktbnwari2(uktBnwariList.get(1));

        hokenSyouken.setSyoukenuktbnwari3(uktBnwariList.get(2));

        hokenSyouken.setSyoukenuktbnwari4(uktBnwariList.get(3));

        hokenSyouken.setSyoukenuktbnwari5(uktBnwariList.get(4));

        hokenSyouken.setSyoukenuktbnwari6(uktBnwariList.get(5));

        hokenSyouken.setSyoukenuktbnwari7(uktBnwariList.get(6));

        hokenSyouken.setSyoukenuktbnwari8(uktBnwariList.get(7));

        hokenSyouken.setSyoukenuktbnwari9(uktBnwariList.get(8));

        hokenSyouken.setSyoukenuktbnwari10(uktBnwariList.get(9));

        hokenSyouken.setPmsgcd3("");

        hokenSyouken.setKykymd(pSyuKykSyouhnLst.get(0).getKykymd());

        hokenSyouken.setPhrkkknmidasikbn("01");

        hokenSyouken.setHrkkknmsgkbn("");

        hokenSyouken.setHrkkaisuumsgkbn("");

        hokenSyouken.setHrkkitukimsgkbn("");

        hokenSyouken.setSyukyktkykrenban1(1);

        hokenSyouken.setSyukyktkykrenban2(0);

        hokenSyouken.setSyukyktkykrenban3(0);

        hokenSyouken.setSyukyktkykrenban4(0);

        hokenSyouken.setSyukyktkykrenban5(0);

        hokenSyouken.setSyukyktkykrenban6(0);

        hokenSyouken.setSyukyktkykrenban7(0);

        hokenSyouken.setSyukyktkykrenban8(0);

        hokenSyouken.setSyukyktkykrenban9(0);

        hokenSyouken.setSyukyktkykrenban10(0);

        hokenSyouken.setSonotanyransiteituuka(kyktuukasyuNm);

        hokenSyouken.setSonotanyrannykntuktype(sonotanyrannykntuktype);

        hokenSyouken.setSonotanyrannykntuukap(sonotanyrannykntuukap);

        hokenSyouken.setSonotanyrannykntuukasyu(sonotanyrannykntuukasyu);

        hokenSyouken.setSonotanyranenkhrikmrate(sonotanyranenkhrikmrate);

        hokenSyouken.setSonotanyranstigikwsrate(sonotanyranstigikwsrate);

        hokenSyouken.setSonotanyrankjnkngktuktype(sonotanyrankjnkngktuktype);

        hokenSyouken.setSonotanyrankjnkngk(sonotanyrankjnkngk);

        hokenSyouken.setSonotanyrankjnkngkrate(sonotanyrankjnkngkrate);

        hokenSyouken.setSonotanyrankjnkngktuuka(sonotanyrankjnkngktuuka);

        hokenSyouken.setSonotanyranpentuktype(sonotanyranpentuktype);

        hokenSyouken.setSonotanyranpenknsngk(sonotanyranpenknsngk);

        hokenSyouken.setSonotanyranmkhwariai(sonotanyranmkhwariai);

        hokenSyouken.setSonotanyransjkkktusirrt(kyksjkkktyouseiriritu);

        hokenSyouken.setStnaiyourangaimsgcd("09200");

        hokenSyouken.setTsinyno(pKykSya.getTsinyno());

        hokenSyouken.setTsinadr1kj(pKykSya.getTsinadr1kj());

        hokenSyouken.setTsinadr2kj(pKykSya.getTsinadr2kj());

        hokenSyouken.setTsinadr3kj(pKykSya.getTsinadr3kj());

        hokenSyouken.setShsnmkj(pKykSya.getKyknmkj());

        hokenSyouken.setTnknmissmsg("");

        hokenSyouken.setErrormsgcd("");

        hokenSyouken.setSisyacd(tantouCdEntity.getBusitucd());

        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            hokenSyouken.setDuhutusnrntousaadrmsgcd("10010");
        }
        else {

            hokenSyouken.setDuhutusnrntousaadrmsgcd("");
        }

        hokenSyouken.setDuhutusnrnsyono(pKykKihon.getSyono());

        if (channelCdList.size() > 0) {

            hokenSyouken.setChannelcd(channelCdList.get(0));
        }

        hokenSyouken.setDairitenmidasikbn("01");

        if (drtenNmList.size() > 0) {

            hokenSyouken.setDrtennm1kj(drtenNmList.get(0));
        }

        if (drtenNmList.size() > 1) {

            hokenSyouken.setDrtennm2kj(drtenNmList.get(1));
        }

        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            if (C_YakkanJyuryouKbn.WEB_SASSI.eq(pKykKihon.getYakkanjyuryouhoukbn())) {

                hokenSyouken.setAisatumsgcd("10021");
            }
            else {

                hokenSyouken.setAisatumsgcd("10020");
            }
        }
        else {

            hokenSyouken.setAisatumsgcd("");
        }

        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            hokenSyouken.setCcmsgcd("10030");
        }
        else {

            hokenSyouken.setCcmsgcd("");
        }

        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            if (C_YakkanJyuryouKbn.WEB.eq(pKykKihon.getYakkanjyuryouhoukbn())) {

                hokenSyouken.setHskmsgcd("10041");
            }
            else if (C_YakkanJyuryouKbn.SASSI.eq(pKykKihon.getYakkanjyuryouhoukbn()) ||
                C_YakkanJyuryouKbn.WEB_SASSI.eq(pKykKihon.getYakkanjyuryouhoukbn())) {

                hokenSyouken.setHskmsgcd("10042");
            }
            else {

                hokenSyouken.setHskmsgcd("10040");
            }
        }
        else {

            hokenSyouken.setHskmsgcd("");
        }

        hokenSyouken.setHosyounymsgcd("11010");

        hokenSyouken.setHosyounyhihknsyameikanji(pHhknSya.getHhknnmkj());

        hokenSyouken.setStdstmmsgcd(stdstmmsgcd);

        hokenSyouken.setFstpmsgcd(fstpmsgcd);

        hokenSyouken.setFstponegaimsgcd(fstponegaimsgcd);

        hokenSyouken.setDsmsgcd(dsmsgcd);

        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            hokenSyouken.setPyentuuktype(C_Tuukasyu.JPY);
            hokenSyouken.setPyen(kijyungaku);
        }
        else {

            hokenSyouken.setPyentuuktype(C_Tuukasyu.BLNK);
            hokenSyouken.setPyen(BizCurrency.valueOf(0));
        }

        hokenSyouken.setToiawasesakihanyoumsgcd(toiawasesakihanyoumsgcd);

        hokenSyouken.setAnnaihanyoumsgcd(annaihanyoumsgcd);

        hokenSyouken.setKoujyosyoumeihskmsgcd("");

        if (tokusyuSyoriNaiyouKbnList.size() > 0) {

            hokenSyouken.setTokusyusyorinaiyoukbn1(tokusyuSyoriNaiyouKbnList.get(0));
        }

        if (tokusyuSyoriNaiyouKbnList.size() > 1) {

            hokenSyouken.setTokusyusyorinaiyoukbn2(tokusyuSyoriNaiyouKbnList.get(1));
        }

        if (tokusyuSyoriNaiyouKbnList.size() > 2) {

            hokenSyouken.setTokusyusyorinaiyoukbn3(tokusyuSyoriNaiyouKbnList.get(2));
        }

        if (tokusyuSyoriNaiyouKbnList.size() > 3) {

            hokenSyouken.setTokusyusyorinaiyoukbn4(tokusyuSyoriNaiyouKbnList.get(3));
        }

        if (tokusyuSyoriNaiyouKbnList.size() > 4) {

            hokenSyouken.setTokusyusyorinaiyoukbn5(tokusyuSyoriNaiyouKbnList.get(4));
        }

        if (tokusyuSyoriNaiyouKbnList.size() > 5) {

            hokenSyouken.setTokusyusyorinaiyoukbn6(tokusyuSyoriNaiyouKbnList.get(5));
        }

        if (tokusyuSyoriNaiyouKbnList.size() > 6) {

            hokenSyouken.setTokusyusyorinaiyoukbn7(tokusyuSyoriNaiyouKbnList.get(6));
        }

        if (tokusyuSyoriNaiyouKbnList.size() > 7) {

            hokenSyouken.setTokusyusyorinaiyoukbn8(tokusyuSyoriNaiyouKbnList.get(7));
        }

        if (tokusyuSyoriNaiyouKbnList.size() > 8) {

            hokenSyouken.setTokusyusyorinaiyoukbn9(tokusyuSyoriNaiyouKbnList.get(8));
        }

        if (tokusyuSyoriNaiyouKbnList.size() > 9) {

            hokenSyouken.setTokusyusyorinaiyoukbn10(tokusyuSyoriNaiyouKbnList.get(9));
        }

        if (tokusyuSyoriNaiyouKbnList.size() > 10) {

            hokenSyouken.setTokusyusyorinaiyoukbn11(tokusyuSyoriNaiyouKbnList.get(10));
        }

        if (tokusyuSyoriNaiyouKbnList.size() > 11) {

            hokenSyouken.setTokusyusyorinaiyoukbn12(tokusyuSyoriNaiyouKbnList.get(11));
        }

        if (tokusyuSyoriNaiyouKbnList.size() > 12) {

            hokenSyouken.setTokusyusyorinaiyoukbn13(tokusyuSyoriNaiyouKbnList.get(12));
        }

        if (tokusyuSyoriNaiyouKbnList.size() > 13) {

            hokenSyouken.setTokusyusyorinaiyoukbn14(tokusyuSyoriNaiyouKbnList.get(13));
        }

        if (tokusyuSyoriNaiyouKbnList.size() > 14) {

            hokenSyouken.setTokusyusyorinaiyoukbn15(tokusyuSyoriNaiyouKbnList.get(14));
        }

        if (tokusyuSyoriNaiyouKbnList.size() > 15) {

            hokenSyouken.setTokusyusyorinaiyoukbn16(tokusyuSyoriNaiyouKbnList.get(15));
        }

        if (tokusyuSyoriNaiyouKbnList.size() > 16) {

            hokenSyouken.setTokusyusyorinaiyoukbn17(tokusyuSyoriNaiyouKbnList.get(16));
        }

        hokenSyouken.setGyoumuKousinKinou(pKCParm.getFunctionId());

        hokenSyouken.setGyoumuKousinsyaId(pKCParm.getUserID());

        hokenSyouken.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        hokenSyouken.setKyknmkn(pKykSya.getKyknmkn());

        hokenSyouken.setHhknnmkn(pHhknSya.getHhknnmkn());

        hokenSyouken.setTantocd(pEditHokenSyoukenParam.getTantoucd());

        if (C_YakkanJyuryouKbn.WEB_SASSI.eq(pKykKihon.getYakkanjyuryouhoukbn())) {

            hokenSyouken.setSiorino(pKykKihon.getSiorino());
            String tnknmissmsg = "【" + ConvertUtil.toZenAll(pKykKihon.getSiorino(), 0, 0) + "】";
            hokenSyouken.setTnknmissmsg(tnknmissmsg);
        }

        if (!C_YakkanJyuryouKbn.BLNK.eq(pKykKihon.getYakkanjyuryouhoukbn())) {

            hokenSyouken.setSioriwebuktriannaimsgcd("13260");
        }

        hokenSyouken.setSagyoukbn(sagyoukbn);


        IT_HokenSyoukenHukaInfo pHokenSyoukenHukaInfo = hokenSyouken.createHokenSyoukenHukaInfo();

        pHokenSyoukenHukaInfo.setKzktirasidouhuukbn1(kzkTirasidouhuukbn1);

        pHokenSyoukenHukaInfo.setKzktirasidouhuukbn2(kzkTirasidouhuukbn2);

        pHokenSyoukenHukaInfo.setKykdairitirasidouhuukbn(kykDairitirasidouhuukbn);

        pHokenSyoukenHukaInfo.setSkhtirasidouhuukbn(skhTirasidouhuukbn);

        pHokenSyoukenHukaInfo.setYakkannewoldkbn(yakkanNewoldkbn);

        pHokenSyoukenHukaInfo.setKzktourokuservicemsg1(kzktourokuservicemsgLst.get(0));

        pHokenSyoukenHukaInfo.setKzktourokuservicemsg2(kzktourokuservicemsgLst.get(1));

        pHokenSyoukenHukaInfo.setKzktourokuservicemsg3(kzktourokuservicemsgLst.get(2));

        pHokenSyoukenHukaInfo.setKzktourokuservicemsg4(kzktourokuservicemsgLst.get(3));

        pHokenSyoukenHukaInfo.setKzktourokuservicemsg5(kzktourokuservicemsgLst.get(4));

        pHokenSyoukenHukaInfo.setKzktourokuservicemsg6(kzktourokuservicemsgLst.get(5));

        pHokenSyoukenHukaInfo.setKzktourokuservicemsg7(kzktourokuservicemsgLst.get(6));

        pHokenSyoukenHukaInfo.setKzktourokuservicemsg8(kzktourokuservicemsgLst.get(7));

        pHokenSyoukenHukaInfo.setTrkkzknmkj118(trkKzknm1);

        pHokenSyoukenHukaInfo.setTrkkzksei1(trkKzksei1);

        pHokenSyoukenHukaInfo.setTrkkzkseiymd1(trkKzkseiymd1);

        pHokenSyoukenHukaInfo.setTrkkzkyno1(trkKzkyno1);

        pHokenSyoukenHukaInfo.setTrkkzkadr1kj1(trkKzkadr1kj1);

        pHokenSyoukenHukaInfo.setTrkkzkadr2kj1(trkKzkadr2kj1);

        pHokenSyoukenHukaInfo.setTrkkzkadr3kj1(trkKzkadr3kj1);

        pHokenSyoukenHukaInfo.setTrkkzktelno1(trkKzktelno1);

        pHokenSyoukenHukaInfo.setTrkkzknmkj218(trkKzknm2);

        pHokenSyoukenHukaInfo.setTrkkzksei2(trkKzksei2);

        pHokenSyoukenHukaInfo.setTrkkzkseiymd2(trkKzkseiymd2);

        pHokenSyoukenHukaInfo.setTrkkzkyno2(trkKzkyno2);

        pHokenSyoukenHukaInfo.setTrkkzkadr1kj2(trkKzkadr1kj2);

        pHokenSyoukenHukaInfo.setTrkkzkadr2kj2(trkKzkadr2kj2);

        pHokenSyoukenHukaInfo.setTrkkzkadr3kj2(trkKzkadr3kj2);

        pHokenSyoukenHukaInfo.setTrkkzktelno2(trkKzktelno2);

        pHokenSyoukenHukaInfo.setKykdairinm18(kykDairinm);

        pHokenSyoukenHukaInfo.setHhkndairinm(hhkndairinm);

        pHokenSyoukenHukaInfo.setRendouritu(pSyuKykSyouhnLst.get(0).getRendouritu());

        if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {

            EditSyoukenTblNenkin editSyoukenTblNenkin = SWAKInjector.getInstance(EditSyoukenTblNenkin.class);

            editSyoukenTblNenkin.editTBL(hokenSyouken, pKykKihon,
                pEditHokenSyoukenParam, pNyknJissekiRirekiLst, pKykSya, pSyuKykSyouhnLst, pKykSonotaTkyk, pSibouhokenLst, pSiteiDairi, sksyoukenskskbn,
                sinkykjyoutai, gengakuExistsCheck, sbUktNmKjHukaKbn, yendthnkSyoriKbn);


            EditSuiihyouTblNenkin editSuiihyouTblNenkin = SWAKInjector.getInstance(EditSuiihyouTblNenkin.class);

            editSuiihyouTblNenkin.editTBL(pKCParm, pKykKihon, pSyuKykSyouhnLst, pTkKykSyouhnLst, pHhknSya, pSyoriYmd,
                pEditHokenSyoukenParam, pSinsaihkKbn, syouhnZokusei, pKykSonotaTkyk);
        }

        if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR) {

            EditSyoukenTblSyuusin editSyoukenTblSyuusin = SWAKInjector.getInstance(EditSyoukenTblSyuusin.class);

            editSyoukenTblSyuusin.editTBL(hokenSyouken, pKykKihon, pKykSya, pHhknSya, pSyuKykSyouhnLst,
                pNyknJissekiRirekiLst, pKykSonotaTkyk, pSiteiDairi, pSibouhokenLst, pEditHokenSyoukenParam, pSyoriYmd,
                sbUktNmKjHukaKbn, gengakuExistsCheck, sksyoukenskskbn, sinkykjyoutai, syouhnZokusei);


            EditSuiihyouTbl editSuiihyouTbl = SWAKInjector.getInstance(EditSuiihyouTbl.class);

            editSuiihyouTbl.editTBL(pKCParm, pKykKihon, pSyuKykSyouhnLst, pTkKykSyouhnLst, pHhknSya, pSyoriYmd,
                pEditHokenSyoukenParam, pSinsaihkKbn, syouhnZokusei, pKykSonotaTkyk);
        }

        if (syouhnhanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

            IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(pKykKihon.getSyono());

            IT_Zennou zennou = null;

            if (C_Kykjyoutai.ZENNOU.eq(pSyuKykSyouhnLst.get(0).getKykjyoutai())) {

                if (ansyuKihon == null) {

                    zennou = pKCParm.getBatchAnsyuKihon().getZennous().get(0);
                }
                else {

                    zennou = ansyuKihon.getZennous().get(ansyuKihon.getZennous().size() - 1);
                }
            }

            EditSyoukenTblNenkin2 editSyoukenTblNenkin2 = SWAKInjector.getInstance(EditSyoukenTblNenkin2.class);

            editSyoukenTblNenkin2.editTBL(hokenSyouken, pKykKihon,
                pEditHokenSyoukenParam, pNyknJissekiRirekiLst, pKykSya, pSyuKykSyouhnLst, pKykSonotaTkyk,pSibouhokenLst,pSiteiDairi,sksyoukenskskbn,
                sinkykjyoutai, gengakuExistsCheck,sbUktNmKjHukaKbn, zennou);


            EditSuiihyouTblNenkin2 editSuiihyouTblNenkin2 = SWAKInjector.getInstance(EditSuiihyouTblNenkin2.class);

            editSuiihyouTblNenkin2.editTBL(pKCParm, pKykKihon, pSyuKykSyouhnLst, pTkKykSyouhnLst, pHhknSya, pSyoriYmd,
                pEditHokenSyoukenParam, pSinsaihkKbn, syouhnZokusei, pKykSonotaTkyk, zennou);
        }

        if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {

            EditSyoukenTblSyuusin2 editSyoukenTblSyuusin2 = SWAKInjector.getInstance(EditSyoukenTblSyuusin2.class);

            editSyoukenTblSyuusin2.editTBL(hokenSyouken, pKykKihon, pKykSya, pHhknSya, pSyuKykSyouhnLst,
                pNyknJissekiRirekiLst, pKykSonotaTkyk, pSiteiDairi, pSibouhokenLst, pEditHokenSyoukenParam, pSyoriYmd,
                sbUktNmKjHukaKbn, gengakuExistsCheck, sksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);


            EditSuiihyouTblSyuusin2 editSuiihyouTblsyuusin2 = SWAKInjector.getInstance(EditSuiihyouTblSyuusin2.class);

            editSuiihyouTblsyuusin2.editTBL(pKCParm, pKykKihon, pSyuKykSyouhnLst, pTkKykSyouhnLst, pHhknSya, pSyoriYmd,
                pEditHokenSyoukenParam, pSinsaihkKbn, syouhnZokusei, pKykSonotaTkyk);
        }

        if (syouhnhanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

            EditSyoukenTblNenkin3 editSyoukenTblNenkin3 = SWAKInjector.getInstance(EditSyoukenTblNenkin3.class);

            editSyoukenTblNenkin3.editTBL(hokenSyouken, pKykKihon,
                pEditHokenSyoukenParam, pNyknJissekiRirekiLst, pKykSya, pSyuKykSyouhnLst, pKykSonotaTkyk, pSibouhokenLst, pSiteiDairi, sksyoukenskskbn,
                gengakuExistsCheck, sbUktNmKjHukaKbn, yendthnkSyoriKbn);


            EditSuiihyouTblNenkin3 editSuiihyouTblNenkin3 = SWAKInjector.getInstance(EditSuiihyouTblNenkin3.class);

            editSuiihyouTblNenkin3.editTBL(pKCParm, pKykKihon, pSyuKykSyouhnLst, pTkKykSyouhnLst, pHhknSya, pSyoriYmd,
                pEditHokenSyoukenParam, pSinsaihkKbn, syouhnZokusei, pKykSonotaTkyk);

            hokenSyouken.setSisuuupkaisuu(BizNumber.valueOf(editSuiihyouTblNenkin3.getSisuuUpCount1()));

            hokenSyouken.setSisuudownkaisuu(BizNumber.valueOf(editSuiihyouTblNenkin3.getSisuuDownCount1()));
        }

        if (syouhnhanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

            IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(pKykKihon.getSyono());

            IT_Zennou zennou = null;

            if (C_Kykjyoutai.ZENNOU.eq(pSyuKykSyouhnLst.get(0).getKykjyoutai())) {

                if (ansyuKihon == null) {

                    zennou = pKCParm.getBatchAnsyuKihon().getZennous().get(0);
                }
                else {

                    zennou = ansyuKihon.getZennous().get(ansyuKihon.getZennous().size() - 1);
                }
            }
            else {

                tnsHuyouPostUmuKbn = C_UmuKbn.NONE;
            }

            EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);

            editSyoukenTblSyuusin3.editTBL(hokenSyouken, pKykKihon, pKykSya, pHhknSya, pSyuKykSyouhnLst,
                pNyknJissekiRirekiLst, pKykSonotaTkyk, pSiteiDairi, pSibouhokenLst, pEditHokenSyoukenParam, pSyoriYmd,
                sbUktNmKjHukaKbn, gengakuExistsCheck, sksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn, zennou);

            EditSuiihyouTblSyuusin3 editSuiihyouTblsyuusin3 = SWAKInjector.getInstance(EditSuiihyouTblSyuusin3.class);

            editSuiihyouTblsyuusin3.editTBL(pKCParm, pKykKihon, pSyuKykSyouhnLst, pSyoriYmd,
                pEditHokenSyoukenParam, pSinsaihkKbn, zennou);

            sibouSBeanList = editSuiihyouTblsyuusin3.getSibouSBeanList();
        }

        hokenSyouken.setSyotnshuyoupostumukbn(tnsHuyouPostUmuKbn);

        if (BizDateUtil.compareYmd(pSyoriYmd, KIRIKAEMAE_YMD) == BizDateUtil.COMPARE_LESSER ||
            BizDateUtil.compareYmd(pSyoriYmd, KIRIKAEMAE_YMD) == BizDateUtil.COMPARE_EQUAL) {

            pHokenSyoukenHukaInfo.setKzktirasidouhuukbn1(C_UmuKbn.NONE);

            pHokenSyoukenHukaInfo.setKzktirasidouhuukbn2(C_UmuKbn.NONE);

            pHokenSyoukenHukaInfo.setKykdairitirasidouhuukbn(C_UmuKbn.NONE);
        }

        if (sksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN  &&
            (BizDateUtil.compareYmd(mosYmd, KYOUTUUJOUKEN1_YMD) == BizDateUtil.COMPARE_GREATER ||
            BizDateUtil.compareYmd(mosYmd, KYOUTUUJOUKEN1_YMD) == BizDateUtil.COMPARE_EQUAL)) {

            if (C_UmuKbn.ARI.eq(kzkTirasidouhuukbn1) &&
                C_TyokusouhtkekKbn.TYOKUSOUTSYGAI.eq(pEditHokenSyoukenParam.getTrkkzk1thkk())) {

                pHokenSyoukenHukaInfo.setKzktirasidouhuukbn1(C_UmuKbn.ARI);
            }
            else {

                pHokenSyoukenHukaInfo.setKzktirasidouhuukbn1(C_UmuKbn.NONE);
            }

            if (C_UmuKbn.ARI.eq(kzkTirasidouhuukbn2) &&
                C_TyokusouhtkekKbn.TYOKUSOUTSYGAI.eq(pEditHokenSyoukenParam.getTrkkzk2thkk())) {

                pHokenSyoukenHukaInfo.setKzktirasidouhuukbn2(C_UmuKbn.ARI);
            }
            else {

                pHokenSyoukenHukaInfo.setKzktirasidouhuukbn2(C_UmuKbn.NONE);
            }

            if (kyksyaDairinin != null && C_UmuKbn.ARI.eq(kykDairitirasidouhuukbn) &&
                C_UktKbn.TOUROKUKAZOKU1.eq(kyksyaDairinin.getUktkbn())) {

                pHokenSyoukenHukaInfo.setKykdairitirasidouhuukbn(pHokenSyoukenHukaInfo.getKzktirasidouhuukbn1());
            }

            if (kyksyaDairinin != null && C_UmuKbn.ARI.eq(kykDairitirasidouhuukbn) &&
                C_UktKbn.TOUROKUKAZOKU2.eq(kyksyaDairinin.getUktkbn())) {

                pHokenSyoukenHukaInfo.setKykdairitirasidouhuukbn(pHokenSyoukenHukaInfo.getKzktirasidouhuukbn2());
            }

            if (pSiteiDairi != null && C_UmuKbn.ARI.eq(stdrsktirasidouhuukbn) &&
                C_UktKbn.TOUROKUKAZOKU1.eq(pSiteiDairi.getUktkbn())) {

                hokenSyouken.setStdrsktirasidouhuukbn(pHokenSyoukenHukaInfo.getKzktirasidouhuukbn1());
            }

            if (pSiteiDairi != null && C_UmuKbn.ARI.eq(stdrsktirasidouhuukbn) &&
                C_UktKbn.TOUROKUKAZOKU2.eq(pSiteiDairi.getUktkbn())) {

                hokenSyouken.setStdrsktirasidouhuukbn(pHokenSyoukenHukaInfo.getKzktirasidouhuukbn2());
            }
        }

        List<BizCurrency> dai1sLst = new ArrayList<>();

        List<C_Tuukasyu> dai1stuuktypeLst = new ArrayList<>();

        List<C_Tuukasyu> dai1syentuuktypeLst = new ArrayList<>();

        List<BizCurrency> zennouZndkLst = new ArrayList<>();

        List<C_Tuukasyu> zennouZndktypeLst = new ArrayList<>();

        List<BizCurrency> sibouUktrgkLst = new ArrayList<>();

        List<C_Tuukasyu> sibouUktrgktypeLst = new ArrayList<>();

        List<BizCurrency> dai1syenyendakaLst = new ArrayList<>();

        List<BizCurrency> dai1syenyenkijyunLst = new ArrayList<>();

        List<BizCurrency> dai1syenyenyasuLst = new ArrayList<>();

        List<BizCurrency> sibouUktrgkYendakaLst = new ArrayList<>();

        List<BizCurrency> sibouUktrgkYenLst = new ArrayList<>();

        List<BizCurrency> sibouUktrgkYenyasuLst = new ArrayList<>();

        List<BizDate> dai1sibousnenoutouymd = new ArrayList<>();

        if (sibouSBeanList != null && sibouSBeanList.size() > 0) {

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

            for (int i = 0; i < sibouSBeanList.size(); i++) {

                dai1sibousnenoutouymd.add(sibouSBeanList.get(i).getCalcKijyunYmd());
                dai1sLst.add(sibouSBeanList.get(i).getSibouS());
                dai1stuuktypeLst.add(henkanTuuka.henkanTuukaTypeToKbn(sibouSBeanList.get(i).getSibouS().getType()));
                zennouZndkLst.add(sibouSBeanList.get(i).getZennouZndk());
                zennouZndktypeLst.add(henkanTuuka.henkanTuukaTypeToKbn(sibouSBeanList.get(i).getZennouZndk().getType()));
                sibouUktrgkLst.add(sibouSBeanList.get(i).getSibouUktrgk());
                sibouUktrgktypeLst.add(henkanTuuka.henkanTuukaTypeToKbn(sibouSBeanList.get(i).getSibouUktrgk().getType()));
                dai1syentuuktypeLst.add(C_Tuukasyu.JPY);
                dai1syenyendakaLst.add(sibouSBeanList.get(i).getSibouUktrgkYendaka());
                dai1syenyenkijyunLst.add(sibouSBeanList.get(i).getSibouUktrgkYen());
                dai1syenyenyasuLst.add(sibouSBeanList.get(i).getSibouUktrgkYenyasu());
                sibouUktrgkYendakaLst.add(sibouSBeanList.get(i).getSibouUktrgkYendaka());
                sibouUktrgkYenLst.add(sibouSBeanList.get(i).getSibouUktrgkYen());
                sibouUktrgkYenyasuLst.add(sibouSBeanList.get(i).getSibouUktrgkYenyasu());
            }
        }

        if (sibouSBeanList != null && sibouSBeanList.size() > 0) {

            if (dai1sibousnenoutouymd.size() > 0) {
                hokenSyouken.setDai1sibousnenoutouymd01(dai1sibousnenoutouymd.get(0));
            }

            if (dai1sibousnenoutouymd.size() > 1) {
                hokenSyouken.setDai1sibousnenoutouymd02(dai1sibousnenoutouymd.get(1));
            }

            if (dai1sibousnenoutouymd.size() > 2) {
                hokenSyouken.setDai1sibousnenoutouymd03(dai1sibousnenoutouymd.get(2));
            }

            if (dai1sibousnenoutouymd.size() > 3) {
                hokenSyouken.setDai1sibousnenoutouymd04(dai1sibousnenoutouymd.get(3));
            }

            if (dai1sibousnenoutouymd.size() > 4) {
                hokenSyouken.setDai1sibousnenoutouymd05(dai1sibousnenoutouymd.get(4));
            }

            if (dai1sLst.size() > 0) {
                hokenSyouken.setDai1s01(dai1sLst.get(0));
            }

            if (dai1sLst.size() > 1) {
                hokenSyouken.setDai1s02(dai1sLst.get(1));
            }

            if (dai1sLst.size() > 2) {
                hokenSyouken.setDai1s03(dai1sLst.get(2));
            }

            if (dai1sLst.size() > 3) {
                hokenSyouken.setDai1s04(dai1sLst.get(3));
            }

            if (dai1sLst.size() > 4) {
                hokenSyouken.setDai1s05(dai1sLst.get(4));
            }

            if (dai1stuuktypeLst.size() > 0) {
                hokenSyouken.setDai1stuuktype01(dai1stuuktypeLst.get(0));
            }

            if (dai1stuuktypeLst.size() > 1) {
                hokenSyouken.setDai1stuuktype02(dai1stuuktypeLst.get(1));
            }

            if (dai1stuuktypeLst.size() > 2) {
                hokenSyouken.setDai1stuuktype03(dai1stuuktypeLst.get(2));
            }

            if (dai1stuuktypeLst.size() > 3) {
                hokenSyouken.setDai1stuuktype04(dai1stuuktypeLst.get(3));
            }

            if (dai1stuuktypeLst.size() > 4) {
                hokenSyouken.setDai1stuuktype05(dai1stuuktypeLst.get(4));
            }

            if (dai1syentuuktypeLst.size() > 0) {
                hokenSyouken.setDai1syentuuktype01(dai1syentuuktypeLst.get(0));
            }

            if (dai1syentuuktypeLst.size() > 1) {
                hokenSyouken.setDai1syentuuktype02(dai1syentuuktypeLst.get(1));
            }

            if (dai1syentuuktypeLst.size() > 2) {
                hokenSyouken.setDai1syentuuktype03(dai1syentuuktypeLst.get(2));
            }

            if (dai1syentuuktypeLst.size() > 3) {
                hokenSyouken.setDai1syentuuktype04(dai1syentuuktypeLst.get(3));
            }

            if (dai1syentuuktypeLst.size() > 4) {
                hokenSyouken.setDai1syentuuktype05(dai1syentuuktypeLst.get(4));
            }

            if (dai1syenyendakaLst.size() > 0) {

                hokenSyouken.setDai1syenyendaka01(dai1syenyendakaLst.get(0));
            }

            if (dai1syenyendakaLst.size() > 1) {
                hokenSyouken.setDai1syenyendaka02(dai1syenyendakaLst.get(1));
            }

            if (dai1syenyendakaLst.size() > 2) {
                hokenSyouken.setDai1syenyendaka03(dai1syenyendakaLst.get(2));
            }

            if (dai1syenyendakaLst.size() > 3) {
                hokenSyouken.setDai1syenyendaka04(dai1syenyendakaLst.get(3));
            }

            if (dai1syenyendakaLst.size() > 4) {
                hokenSyouken.setDai1syenyendaka05(dai1syenyendakaLst.get(4));
            }

            if (dai1syenyenkijyunLst.size() > 0) {
                hokenSyouken.setDai1syenyenkijyun01(dai1syenyenkijyunLst.get(0));
            }

            if (dai1syenyenkijyunLst.size() > 1) {
                hokenSyouken.setDai1syenyenkijyun02(dai1syenyenkijyunLst.get(1));
            }

            if (dai1syenyenkijyunLst.size() > 2) {
                hokenSyouken.setDai1syenyenkijyun03(dai1syenyenkijyunLst.get(2));
            }

            if (dai1syenyenkijyunLst.size() > 3) {
                hokenSyouken.setDai1syenyenkijyun04(dai1syenyenkijyunLst.get(3));
            }

            if (dai1syenyenkijyunLst.size() > 4) {
                hokenSyouken.setDai1syenyenkijyun05(dai1syenyenkijyunLst.get(4));
            }

            if (dai1syenyenyasuLst.size() > 0) {
                hokenSyouken.setDai1syenyenyasu01(dai1syenyenyasuLst.get(0));
            }

            if (dai1syenyenyasuLst.size() > 1) {
                hokenSyouken.setDai1syenyenyasu02(dai1syenyenyasuLst.get(1));
            }

            if (dai1syenyenyasuLst.size() > 2) {
                hokenSyouken.setDai1syenyenyasu03(dai1syenyenyasuLst.get(2));
            }

            if (dai1syenyenyasuLst.size() > 3) {
                hokenSyouken.setDai1syenyenyasu04(dai1syenyenyasuLst.get(3));
            }

            if (dai1syenyenyasuLst.size() > 4) {
                hokenSyouken.setDai1syenyenyasu05(dai1syenyenyasuLst.get(4));
            }

            if (zennouZndkLst.size() > 0) {
                pHokenSyoukenHukaInfo.setDai1zennouzndk01(zennouZndkLst.get(0));
            }

            if (zennouZndkLst.size() > 1) {
                pHokenSyoukenHukaInfo.setDai1zennouzndk02(zennouZndkLst.get(1));
            }

            if (zennouZndkLst.size() > 2) {
                pHokenSyoukenHukaInfo.setDai1zennouzndk03(zennouZndkLst.get(2));
            }

            if (zennouZndkLst.size() > 3) {
                pHokenSyoukenHukaInfo.setDai1zennouzndk04(zennouZndkLst.get(3));
            }

            if (zennouZndkLst.size() > 4) {
                pHokenSyoukenHukaInfo.setDai1zennouzndk05(zennouZndkLst.get(4));
            }

            if (zennouZndktypeLst.size() > 0) {
                pHokenSyoukenHukaInfo.setDai1zennouzndktype01(zennouZndktypeLst.get(0));
            }

            if (zennouZndktypeLst.size() > 1) {
                pHokenSyoukenHukaInfo.setDai1zennouzndktype02(zennouZndktypeLst.get(1));
            }

            if (zennouZndktypeLst.size() > 2) {
                pHokenSyoukenHukaInfo.setDai1zennouzndktype03(zennouZndktypeLst.get(2));
            }

            if (zennouZndktypeLst.size() > 3) {
                pHokenSyoukenHukaInfo.setDai1zennouzndktype04(zennouZndktypeLst.get(3));
            }

            if (zennouZndktypeLst.size() > 4) {
                pHokenSyoukenHukaInfo.setDai1zennouzndktype05(zennouZndktypeLst.get(4));
            }

            if (sibouUktrgkLst.size() > 0) {
                pHokenSyoukenHukaInfo.setDai1sbjiuktgk01(sibouUktrgkLst.get(0));
            }

            if (sibouUktrgkLst.size() > 1) {
                pHokenSyoukenHukaInfo.setDai1sbjiuktgk02(sibouUktrgkLst.get(1));
            }

            if (sibouUktrgkLst.size() > 2) {
                pHokenSyoukenHukaInfo.setDai1sbjiuktgk03(sibouUktrgkLst.get(2));
            }

            if (sibouUktrgkLst.size() > 3) {
                pHokenSyoukenHukaInfo.setDai1sbjiuktgk04(sibouUktrgkLst.get(3));
            }

            if (sibouUktrgkLst.size() > 4) {
                pHokenSyoukenHukaInfo.setDai1sbjiuktgk05(sibouUktrgkLst.get(4));
            }

            if (sibouUktrgktypeLst.size() > 0) {
                pHokenSyoukenHukaInfo.setDai1sbjiuktgktype01(sibouUktrgktypeLst.get(0));
            }

            if (sibouUktrgktypeLst.size() > 1) {
                pHokenSyoukenHukaInfo.setDai1sbjiuktgktype02(sibouUktrgktypeLst.get(1));
            }

            if (sibouUktrgktypeLst.size() > 2) {
                pHokenSyoukenHukaInfo.setDai1sbjiuktgktype03(sibouUktrgktypeLst.get(2));
            }

            if (sibouUktrgktypeLst.size() > 3) {
                pHokenSyoukenHukaInfo.setDai1sbjiuktgktype04(sibouUktrgktypeLst.get(3));
            }

            if (sibouUktrgktypeLst.size() > 4) {
                pHokenSyoukenHukaInfo.setDai1sbjiuktgktype05(sibouUktrgktypeLst.get(4));
            }

            if (sibouUktrgkYendakaLst.size() > 0) {
                pHokenSyoukenHukaInfo.setDai1sbjiuktgkyendaka01(sibouUktrgkYendakaLst.get(0));
            }

            if (sibouUktrgkYendakaLst.size() > 1) {
                pHokenSyoukenHukaInfo.setDai1sbjiuktgkyendaka02(sibouUktrgkYendakaLst.get(1));
            }

            if (sibouUktrgkYendakaLst.size() > 2) {
                pHokenSyoukenHukaInfo.setDai1sbjiuktgkyendaka03(sibouUktrgkYendakaLst.get(2));
            }

            if (sibouUktrgkYendakaLst.size() > 3) {
                pHokenSyoukenHukaInfo.setDai1sbjiuktgkyendaka04(sibouUktrgkYendakaLst.get(3));
            }

            if (sibouUktrgkYendakaLst.size() > 4) {
                pHokenSyoukenHukaInfo.setDai1sbjiuktgkyendaka05(sibouUktrgkYendakaLst.get(4));
            }

            if (sibouUktrgkYenLst.size() > 0) {
                pHokenSyoukenHukaInfo.setDai1sbjiuktgkyenkijyun01(sibouUktrgkYenLst.get(0));
            }

            if (sibouUktrgkYenLst.size() > 1) {
                pHokenSyoukenHukaInfo.setDai1sbjiuktgkyenkijyun02(sibouUktrgkYenLst.get(1));
            }

            if (sibouUktrgkYenLst.size() > 2) {
                pHokenSyoukenHukaInfo.setDai1sbjiuktgkyenkijyun03(sibouUktrgkYenLst.get(2));
            }

            if (sibouUktrgkYenLst.size() > 3) {
                pHokenSyoukenHukaInfo.setDai1sbjiuktgkyenkijyun04(sibouUktrgkYenLst.get(3));
            }

            if (sibouUktrgkYenLst.size() > 4) {
                pHokenSyoukenHukaInfo.setDai1sbjiuktgkyenkijyun05(sibouUktrgkYenLst.get(4));
            }

            if (sibouUktrgkYenyasuLst.size() > 0) {
                pHokenSyoukenHukaInfo.setDai1sbjiuktgkyenyasu01(sibouUktrgkYenyasuLst.get(0));
            }

            if (sibouUktrgkYenyasuLst.size() > 1) {
                pHokenSyoukenHukaInfo.setDai1sbjiuktgkyenyasu02(sibouUktrgkYenyasuLst.get(1));
            }

            if (sibouUktrgkYenyasuLst.size() > 2) {
                pHokenSyoukenHukaInfo.setDai1sbjiuktgkyenyasu03(sibouUktrgkYenyasuLst.get(2));
            }

            if (sibouUktrgkYenyasuLst.size() > 3) {
                pHokenSyoukenHukaInfo.setDai1sbjiuktgkyenyasu04(sibouUktrgkYenyasuLst.get(3));
            }

            if (sibouUktrgkYenyasuLst.size() > 4) {
                pHokenSyoukenHukaInfo.setDai1sbjiuktgkyenyasu05(sibouUktrgkYenyasuLst.get(4));
            }

            pHokenSyoukenHukaInfo.setDai1sbjiuktgkyentype(C_Tuukasyu.JPY);
        }

        BizPropertyInitializer.initialize(hokenSyouken);
        BizPropertyInitializer.initialize(pHokenSyoukenHukaInfo);

        hassoukbn = hokenSyouken.getHassoukbn();
    }
}
