package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzdairiten.BzGetTuukeiBunwari;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DiritenplannmKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HouteiTyotkseiSyouhnHyjKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_IdouKhBosyuudr;
import yuyu.def.db.entity.BT_IdouKhMeigi;
import yuyu.def.db.entity.BT_TjtIdouNyKh;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_TrkKzk;

/**
 * 契約保全 契約保全共通 ＰＡＬ契約内容作成
 */
public class PALKykNaiyouSakusei {

    @Inject
    private static Logger logger;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BizDomManager bizDomManager;

    private BT_TjtIdouNyKh tjtIdouNyKh;

    public PALKykNaiyouSakusei() {
        super();
    }

    public BT_TjtIdouNyKh getTjtIdouNyKh() {
        return tjtIdouNyKh;
    }


    public C_ErrorKbn exec(PALKykNaiyouSakuseiBean pPALKykNaiyouSakuseiBean) {

        logger.debug("▽ ＰＡＬ契約内容作成 開始");

        C_ErrorKbn errorKbn;
        IT_KykKihon kykKihon = pPALKykNaiyouSakuseiBean.getKykKihon();

        if (kykKihon == null) {
            errorKbn = C_ErrorKbn.ERROR;
            logger.debug("△ ＰＡＬ契約内容作成 終了");
            return errorKbn;
        }

        Integer renno3keta = bizDomManager.getTjtIdouNyKhMaxRenno3ketaBySyono(kykKihon.getSyono());

        if (renno3keta == null) {
            renno3keta = 1;
        }
        else {
            renno3keta = renno3keta + 1;
        }

        IT_KykSya kykSya = kykKihon.getKykSya();
        String kyknmkn = "";
        String kyknmkj = "";
        BizDate kykseiymd = null;
        Integer kykhhkndouhyouji = 1;

        if (!C_Tdk.HONNIN.eq(kykSya.getKkkyktdk())) {
            kyknmkn = kykSya.getKyknmkn();
            kykseiymd = kykSya.getKykseiymd();
            kykhhkndouhyouji = 0;

            if (!C_KjkhukaKbn.KJKHUKA.eq(kykSya.getKyknmkjkhukakbn())) {
                kyknmkj =  kykSya.getKyknmkj();
            }
        }

        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        String hhknnmkj = "";

        if (!C_KjkhukaKbn.KJKHUKA.eq(hhknSya.getHhknnmkjkhukakbn())) {
            hhknnmkj = hhknSya.getHhknnmkj();
        }

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();
        C_TtdktyuuiKbn ttdktyuuikbn1 = C_TtdktyuuiKbn.BLNK;
        C_TtdktyuuiKbn ttdktyuuikbn2 = C_TtdktyuuiKbn.BLNK;
        C_TtdktyuuiKbn ttdktyuuikbn3 = C_TtdktyuuiKbn.BLNK;
        C_TtdktyuuiKbn ttdktyuuikbn4 = C_TtdktyuuiKbn.BLNK;
        C_TtdktyuuiKbn ttdktyuuikbn5 = C_TtdktyuuiKbn.BLNK;

        if (khTtdkTyuui != null) {
            ttdktyuuikbn1 = khTtdkTyuui.getTtdktyuuikbn1();
            ttdktyuuikbn2 = khTtdkTyuui.getTtdktyuuikbn2();
            ttdktyuuikbn3 = khTtdkTyuui.getTtdktyuuikbn3();
            ttdktyuuikbn4 = khTtdkTyuui.getTtdktyuuikbn4();
            ttdktyuuikbn5 = khTtdkTyuui.getTtdktyuuikbn5();
        }

        List<String> sbuktnmknList = new ArrayList<String>();
        List<String> sbuktnmkjList = new ArrayList<String>();
        List<IT_KykUkt> sbuktKykUktList = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        for (int i = 0; i < 4; i++) {
            if (i < sbuktKykUktList.size() && C_UktKbn.TOKUTEIMEIGI.eq(sbuktKykUktList.get(i).getUktkbn())) {
                sbuktnmknList.add(sbuktKykUktList.get(i).getUktnmkn());

                if (!C_KjkhukaKbn.KJKHUKA.eq(sbuktKykUktList.get(i).getUktnmkjkhukakbn())) {
                    sbuktnmkjList.add(sbuktKykUktList.get(i).getUktnmkj());
                }
                else {
                    sbuktnmkjList.add("");
                }
            }
            else {
                sbuktnmknList.add("");
                sbuktnmkjList.add("");
            }
        }

        List<IT_KykUkt> stdrskKykUktList = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.STDRSK);
        String stdrsknmkn = "";
        String stdrsknmkj = "";

        if (stdrskKykUktList.size() > 0) {
            if (C_UktKbn.TOKUTEIMEIGI.eq(stdrskKykUktList.get(0).getUktkbn())) {
                stdrsknmkn = stdrskKykUktList.get(0).getUktnmkn();
                if (!C_KjkhukaKbn.KJKHUKA.eq(stdrskKykUktList.get(0).getUktnmkjkhukakbn())) {
                    stdrsknmkj = stdrskKykUktList.get(0).getUktnmkj();
                }
            }
        }

        List<IT_KykUkt> kykdrnKykUktList = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.KYKDRN);
        String kykdairinmkn = "";
        String kykdairinmkj = "";

        if (kykdrnKykUktList.size() > 0) {
            if (C_UktKbn.TOKUTEIMEIGI.eq(kykdrnKykUktList.get(0).getUktkbn())) {
                kykdairinmkn = kykdrnKykUktList.get(0).getUktnmkn();
                if (!C_KjkhukaKbn.KJKHUKA.eq(kykdrnKykUktList.get(0).getUktnmkjkhukakbn())) {
                    kykdairinmkj = kykdrnKykUktList.get(0).getUktnmkj();
                }
            }
        }

        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(kykSyouhn.getSyouhncd(), kykSyouhn.getSyouhnsdno());

        SetTyotikuseihokenhyouji setTyotikuseihokenhyouji = SWAKInjector.getInstance(SetTyotikuseihokenhyouji.class);
        HanteiTyotikuseihokenBean hanteiTyotikuseihokenBean = SWAKInjector.getInstance(HanteiTyotikuseihokenBean.class);
        hanteiTyotikuseihokenBean.setSyouhnCd(kykSyouhn.getSyouhncd());
        hanteiTyotikuseihokenBean.setSyouhnsdNo(kykSyouhn.getSyouhnsdno());
        hanteiTyotikuseihokenBean.setHrkkaisuu(kykKihon.getHrkkaisuu());
        hanteiTyotikuseihokenBean.setHrkkeiro(kykKihon.getHrkkeiro());

        setTyotikuseihokenhyouji.hanteiTyotikuseihoken(hanteiTyotikuseihokenBean);

        C_HouteiTyotkseiSyouhnHyjKbn houteityotikuseiarihyj = C_HouteiTyotkseiSyouhnHyjKbn.HIGAITOU;

        if (C_UmuKbn.ARI.eq(setTyotikuseihokenhyouji.getHouteityotkhknhyj())) {
            houteityotikuseiarihyj = C_HouteiTyotkseiSyouhnHyjKbn.GAITOU;
        }

        IT_NyknJissekiRireki nyknJissekiRireki = kykKihon.getNyknJissekiRirekis().get(0);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        GetKhTuusanyouKngk getKhTuusanyouKngk =  SWAKInjector.getInstance(GetKhTuusanyouKngk.class);
        GetKhTuusanyouKngkBean getKhTuusanyouKngkBean = getKhTuusanyouKngk.getAlltsnkngk(syouhnZokusei,
            kykSyouhn,
            nyknJissekiRireki,
            kykSonotaTkyk);

        List<IT_KykDairiten> kykDairitenList = kykKihon.getKykDairitens();
        BizNumber bunwari1 = BizNumber.ZERO;
        BizNumber bunwari2 = BizNumber.ZERO;
        String drtencd1 = "";
        String drtencd2 = "";
        String kanrisosikicd2 = "";

        if (kykDairitenList.size() > 1) {
            BzGetTuukeiBunwari bzGetTuukeiBunwari = SWAKInjector.getInstance(BzGetTuukeiBunwari.class);
            bzGetTuukeiBunwari.exec(kykDairitenList.get(0).getDrtencd(),
                kykDairitenList.get(0).getOyadrtencd(),
                kykDairitenList.get(0).getBunwari(),
                kykDairitenList.get(1).getDrtencd(),
                kykDairitenList.get(1).getOyadrtencd(),
                kykDairitenList.get(1).getBunwari(),
                kykKihon.getSeirituymd().getBizDateYM(),
                syouhnZokusei.getDrtsyouhinsikibetukbn(),
                kykKihon.getHrkkaisuu(),
                C_DiritenplannmKbn.BLNK);
            if (C_ErrorKbn.ERROR.eq(bzGetTuukeiBunwari.getErrorKbn())) {
                errorKbn = C_ErrorKbn.ERROR;
                logger.debug("△ ＰＡＬ契約内容作成 終了");
                return errorKbn;
            }
            bunwari1 = bzGetTuukeiBunwari.getBuntanWariai1();
            bunwari2 = bzGetTuukeiBunwari.getBuntanWariai2();
            drtencd1 = bzGetTuukeiBunwari.getDrtencd1();
            drtencd2 = bzGetTuukeiBunwari.getDrtencd2();
            kanrisosikicd2 = kykDairitenList.get(1).getDrtenkanrisosikicd();
        }
        else {
            drtencd1 = kykDairitenList.get(0).getDrtencd();
            bunwari1 = kykDairitenList.get(0).getBunwari();
        }

        String bankcd = "";
        String sitencd = "";
        C_YokinKbn yokinkbn = C_YokinKbn.BLNK;
        String kouzano = "";
        String kzmeiginmkn = "";
        C_KzkykdouKbn  kzkykdoukbn =  C_KzkykdouKbn.BLNK;

        if (C_Hrkkeiro.KOUHURI.eq(kykKihon.getHrkkeiro())) {
            IT_Kouza kouza = kykKihon.getKouza();
            bankcd = kouza.getBankcd();
            sitencd = kouza.getSitencd();
            yokinkbn = kouza.getYokinkbn();
            kouzano = kouza.getKouzano();
            kzmeiginmkn = kouza.getKzmeiginmkn();
            kzkykdoukbn = kouza.getKzkykdoukbn();
        }

        String kzktourokunmkn1 = "";
        String kzktourokunmkj1 = "";
        String kzktourokunmkn2 = "";
        String kzktourokunmkj2 = "";

        List<IT_TrkKzk> trkKzkList = kykKihon.getTrkKzks();
        for (int i = 0; i < trkKzkList.size(); i++) {
            if (C_TrkKzkKbn.TRKKZK1.eq(trkKzkList.get(i).getTrkkzkkbn())) {
                kzktourokunmkn1 = trkKzkList.get(i).getTrkkzknmkn();
                if (!C_KjkhukaKbn.KJKHUKA.eq(trkKzkList.get(i).getTrkkzknmkjkhukakbn())) {
                    kzktourokunmkj1 = trkKzkList.get(i).getTrkkzknmkj();
                }
            }
            else if (C_TrkKzkKbn.TRKKZK2.eq(trkKzkList.get(i).getTrkkzkkbn())) {
                kzktourokunmkn2 = trkKzkList.get(i).getTrkkzknmkn();
                if (!C_KjkhukaKbn.KJKHUKA.eq(trkKzkList.get(i).getTrkkzknmkjkhukakbn())) {
                    kzktourokunmkj2 = trkKzkList.get(i).getTrkkzknmkj();
                }
            }
        }

        tjtIdouNyKh = new BT_TjtIdouNyKh();

        tjtIdouNyKh.setSyono(kykKihon.getSyono());
        tjtIdouNyKh.setRenno3keta(renno3keta);
        tjtIdouNyKh.setRecordsakujyohyouji(0);
        tjtIdouNyKh.setSyouhncd(kykSyouhn.getSyouhncd());
        tjtIdouNyKh.setKykjyoutai(kykSyouhn.getKykjyoutai());
        tjtIdouNyKh.setKykymd(kykSyouhn.getKykymd());
        tjtIdouNyKh.setYuukousyoumetukbn(kykSyouhn.getYuukousyoumetukbn());
        tjtIdouNyKh.setSyoumetujiyuu(kykSyouhn.getSyoumetujiyuu());
        tjtIdouNyKh.setSyoumetuymd(kykSyouhn.getSyoumetuymd());
        tjtIdouNyKh.setKyktuukasyu(kykSyouhn.getKyktuukasyu());
        tjtIdouNyKh.setTsnyousibous(getKhTuusanyouKngkBean.getTsnyouSibous());
        tjtIdouNyKh.setTsnyouitijip(getKhTuusanyouKngkBean.getTsnyouItijip());
        tjtIdouNyKh.setTsnyounkgns(getKhTuusanyouKngkBean.getTsnyouNkgns());
        tjtIdouNyKh.setHrkkkn(kykSyouhn.getHrkkkn());
        tjtIdouNyKh.setSntkhoukbn(kykKihon.getSntkhoukbn());
        tjtIdouNyKh.setBosyuuym(kykKihon.getBosyuuym());
        tjtIdouNyKh.setKykhhkndouhyouji(kykhhkndouhyouji);
        tjtIdouNyKh.setTtdktyuuikbn1(ttdktyuuikbn1);
        tjtIdouNyKh.setTtdktyuuikbn2(ttdktyuuikbn2);
        tjtIdouNyKh.setTtdktyuuikbn3(ttdktyuuikbn3);
        tjtIdouNyKh.setTtdktyuuikbn4(ttdktyuuikbn4);
        tjtIdouNyKh.setTtdktyuuikbn5(ttdktyuuikbn5);
        tjtIdouNyKh.setSyouhnsdno(kykSyouhn.getSyouhnsdno());
        tjtIdouNyKh.setKaigomaehrtkykumukbn(kykSonotaTkyk.getJyudkaigomeharaitkhukaumu());
        tjtIdouNyKh.setPyennykntkykumukbn(kykSonotaTkyk.getYennykntkhkumu());
        tjtIdouNyKh.setTsnyennyknkgk(getKhTuusanyouKngkBean.getTsnyouYennyknkgk());
        tjtIdouNyKh.setSkjmosno(kykKihon.getSkjmosno());
        tjtIdouNyKh.setGyoumuKousinKinou(kinou.getKinouId());
        tjtIdouNyKh.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        tjtIdouNyKh.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
        tjtIdouNyKh.setSeiritujitrhkjikakkbn(kykKihon.getSeiritujitrhkjikakkbn());
        tjtIdouNyKh.setHouteityotkseisyouhnhyj(houteityotikuseiarihyj);
        tjtIdouNyKh.setTsntuukasyu(getKhTuusanyouKngkBean.getTsnyouTuukasyu());
        tjtIdouNyKh.setHrkkeiro(kykKihon.getHrkkeiro());
        BizPropertyInitializer.initialize(tjtIdouNyKh);

        BT_IdouKhMeigi idouKhMeigi = tjtIdouNyKh.createIdouKhMeigi();
        idouKhMeigi.setHhknnmkn(hhknSya.getHhknnmkn());
        idouKhMeigi.setHhknnmkj(hhknnmkj);
        idouKhMeigi.setHhknseiymd(hhknSya.getHhknseiymd());
        idouKhMeigi.setHhknsei(hhknSya.getHhknsei());
        idouKhMeigi.setHhknyno(hhknSya.getHhknyno());
        idouKhMeigi.setHhknsykgycd(kykKihon.getHhknsykgycd());
        idouKhMeigi.setKyknmkn(kyknmkn);
        idouKhMeigi.setKyknmkj(kyknmkj);
        idouKhMeigi.setKykseiymd(kykseiymd);
        idouKhMeigi.setTsinyno(kykSya.getTsinyno());
        idouKhMeigi.setTsinadr1kj(kykSya.getTsinadr1kj());
        idouKhMeigi.setTsinadr2kj(kykSya.getTsinadr2kj());
        idouKhMeigi.setTsinadr3kj(kykSya.getTsinadr3kj());
        idouKhMeigi.setTsintelno(kykSya.getTsintelno());
        idouKhMeigi.setSbuktnmkn1(sbuktnmknList.get(0));
        idouKhMeigi.setSbuktnmkj1(sbuktnmkjList.get(0));
        idouKhMeigi.setSbuktnmkn2(sbuktnmknList.get(1));
        idouKhMeigi.setSbuktnmkj2(sbuktnmkjList.get(1));
        idouKhMeigi.setSbuktnmkn3(sbuktnmknList.get(2));
        idouKhMeigi.setSbuktnmkj3(sbuktnmkjList.get(2));
        idouKhMeigi.setSbuktnmkn4(sbuktnmknList.get(3));
        idouKhMeigi.setSbuktnmkj4(sbuktnmkjList.get(3));
        idouKhMeigi.setStdrsknmkn(stdrsknmkn);
        idouKhMeigi.setStdrsknmkj(stdrsknmkj);
        idouKhMeigi.setKykdairinmkn(kykdairinmkn);
        idouKhMeigi.setKykdairinmkj(kykdairinmkj);
        idouKhMeigi.setBankcd(bankcd);
        idouKhMeigi.setSitencd(sitencd);
        idouKhMeigi.setYokinkbn(yokinkbn);
        idouKhMeigi.setKouzano(kouzano);
        idouKhMeigi.setKzmeiginmkn(kzmeiginmkn);
        idouKhMeigi.setKzkykdoukbn(kzkykdoukbn);
        idouKhMeigi.setKzktourokunmkn1(kzktourokunmkn1);
        idouKhMeigi.setKzktourokunmkj1(kzktourokunmkj1);
        idouKhMeigi.setKzktourokunmkn2(kzktourokunmkn2);
        idouKhMeigi.setKzktourokunmkj2(kzktourokunmkj2);
        BizPropertyInitializer.initialize(idouKhMeigi);

        BT_IdouKhBosyuudr idouKhBosyuudr = tjtIdouNyKh.createIdouKhBosyuudr();
        idouKhBosyuudr.setDairitencd1(drtencd1);
        idouKhBosyuudr.setBunwari1(bunwari1);
        idouKhBosyuudr.setDairitencd2(drtencd2);
        idouKhBosyuudr.setBunwari2(bunwari2);
        idouKhBosyuudr.setKanrisosikicd1(kykDairitenList.get(0).getDrtenkanrisosikicd());
        idouKhBosyuudr.setKanrisosikicd2(kanrisosikicd2);
        BizPropertyInitializer.initialize(idouKhBosyuudr);

        logger.debug("△ ＰＡＬ契約内容作成 終了");

        errorKbn = C_ErrorKbn.OK;
        return errorKbn;

    }
}
