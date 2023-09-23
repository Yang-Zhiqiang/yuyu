package yuyu.common.hozen.khcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.biz.bzdairiten.BzGetTuukeiBunwari;
import yuyu.common.biz.bznayose.BzKykNaiyouHaneiKekkaBean;
import yuyu.common.biz.bznayose.BzKykNaiyouHaneiMq;
import yuyu.common.biz.bznayose.BzKykNaiyouHaneiYokenBean;
import yuyu.common.biz.bznayose.BzTrksIraiKekkaBean;
import yuyu.common.biz.bznayose.BzTrksIraiMq;
import yuyu.common.biz.bznayose.BzTrksIraiYokenBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DiritenplannmKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HouteiTyotkseiSyouhnHyjKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_JdTrksPalTrksZanKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KyknaiyouhaneiErrKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_NayoseJissiKekkaKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TorikesiKekkaKbn;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
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
 * 契約保全 契約保全共通 ＰＡＬ契約内容更新処理クラス
 */
public class PALKykNaiyouKousin {

    private static final String PALKYKNAIYOU_UPDATESYORI = "ＰＡＬ契約内容更新処理";

    private static final String PALKYKNAIYOU_UPDATE = "ＰＡＬ契約内容更新";

    private C_NayoseJissiKekkaKbn hhknnysjissikekkakbn;

    private String hhknsakuinmeino;

    private C_NayoseJissiKekkaKbn kyknysjissikekkakbn;

    private String kyksakuinmeino;

    private String youkyuuno;

    @Inject
    private static Logger logger;

    @Inject
    private BaseDomManager domManager;

    @Inject
    private BizDomManager bizDomManager;

    public PALKykNaiyouKousin() {
        super();
    }

    public void exec(IT_KykKihon pItKykKihon) {

        logger.debug("▽ ＰＡＬ契約内容更新処理 開始");

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean =
            SWAKInjector.getInstance(BzKykNaiyouHaneiYokenBean.class);

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
        String kykdairinmkn = "";
        String kykdairinmkj = "";
        String  kzktourokunmkn1 = "";
        String kzktourokunmkj1 = "";
        String  kzktourokunmkn2 = "";
        String kzktourokunmkj2 = "";
        String kyknmkn = "";
        String kyknmkj = "";
        BizDate kykseiymd = null;
        String drtencd1 = "";
        BizNumber bunwari1 = BizNumber.ZERO;
        String drtencd2 = "";
        BizNumber bunwari2 =  BizNumber.ZERO;

        List<IT_KykSyouhn> itKykSyouhnList = pItKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSya itKykSya = pItKykKihon.getKykSya();
        IT_HhknSya itHhknSya = pItKykKihon.getHhknSya();
        IT_KhTtdkTyuui itKhTtdkTyuui = pItKykKihon.getKhTtdkTyuui();

        if(!C_Tdk.HONNIN.eq(itKykSya.getKkkyktdk())){

            kyknmkn = itKykSya.getKyknmkn();

            if (C_KjkhukaKbn.KJKHUKA.eq(itKykSya.getKyknmkjkhukakbn())) {
                kyknmkj = "";
            }
            else {
                kyknmkj = itKykSya.getKyknmkj();
            }

            kykseiymd = itKykSya.getKykseiymd();

        }

        List<IT_KykUkt> sbuktList = pItKykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        if(0 < pItKykKihon.getSbuktnin() && pItKykKihon.getSbuktnin() <= 4){
            if (C_UktKbn.TOKUTEIMEIGI.eq(sbuktList.get(0).getUktkbn())) {
                sbuktnmkn1 = sbuktList.get(0).getUktnmkn();
                if (C_KjkhukaKbn.KJKHUKA.eq(sbuktList.get(0).getUktnmkjkhukakbn())) {
                    sbuktnmkj1 = "";
                }
                else {
                    sbuktnmkj1 = sbuktList.get(0).getUktnmkj();
                }
            }
            int count = 0;
            for (IT_KykUkt itKykUkt : sbuktList) {
                if (count == 1) {
                    sbuktnmkn2 = itKykUkt.getUktnmkn();
                    if (C_KjkhukaKbn.KJKHUKA.eq(itKykUkt.getUktnmkjkhukakbn())) {
                        sbuktnmkj2 = "";
                    }
                    else {
                        sbuktnmkj2 = itKykUkt.getUktnmkj();
                    }
                } else if (count == 2) {
                    sbuktnmkn3 = itKykUkt.getUktnmkn();
                    if (C_KjkhukaKbn.KJKHUKA.eq(itKykUkt.getUktnmkjkhukakbn())) {
                        sbuktnmkj3 = "";
                    }
                    else {
                        sbuktnmkj3 = itKykUkt.getUktnmkj();
                    }
                } else if (count == 3) {
                    sbuktnmkn4 = itKykUkt.getUktnmkn();
                    if (C_KjkhukaKbn.KJKHUKA.eq(itKykUkt.getUktnmkjkhukakbn())) {
                        sbuktnmkj4 = "";
                    }
                    else {
                        sbuktnmkj4 = itKykUkt.getUktnmkj();
                    }
                } else if (3 < count) {
                    break;
                }
                count++;
            }
        }
        List<IT_KykUkt> stdrskList = pItKykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.STDRSK);

        if (0 != stdrskList.size()) {
            if (C_UktKbn.TOKUTEIMEIGI.eq(stdrskList.get(0).getUktkbn())) {
                stdrsknmkn = stdrskList.get(0).getUktnmkn();
                if (C_KjkhukaKbn.KJKHUKA.eq(stdrskList.get(0).getUktnmkjkhukakbn())) {
                    stdrsknmkj = "";
                }
                else {
                    stdrsknmkj = stdrskList.get(0).getUktnmkj();
                }
            }
        }

        List<IT_KykUkt> kykdairinm = pItKykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.KYKDRN);

        if (0 != kykdairinm.size()) {
            if (C_UktKbn.TOKUTEIMEIGI.eq(kykdairinm.get(0).getUktkbn())) {
                kykdairinmkn = kykdairinm.get(0).getUktnmkn();
                if (!C_KjkhukaKbn.KJKHUKA.eq(kykdairinm.get(0).getUktnmkjkhukakbn())) {
                    kykdairinmkj = kykdairinm.get(0).getUktnmkj();
                }
            }
        }

        List<IT_TrkKzk> trkkzk = pItKykKihon.getTrkKzks();
        for (IT_TrkKzk trkKzk : trkkzk) {
            if (C_TrkKzkKbn.TRKKZK1.eq(trkKzk.getTrkkzkkbn())) {
                kzktourokunmkn1 = trkKzk.getTrkkzknmkn();
                if (!C_KjkhukaKbn.KJKHUKA.eq(trkKzk.getTrkkzknmkjkhukakbn())) {
                    kzktourokunmkj1 = trkKzk.getTrkkzknmkj();
                }
            }

            if (C_TrkKzkKbn.TRKKZK2.eq(trkKzk.getTrkkzkkbn())) {
                kzktourokunmkn2 = trkKzk.getTrkkzknmkn();
                if (!C_KjkhukaKbn.KJKHUKA.eq(trkKzk.getTrkkzknmkjkhukakbn())) {
                    kzktourokunmkj2 = trkKzk.getTrkkzknmkj();
                }
            }
        }

        List<IT_KykDairiten> itKykDairitenList = pItKykKihon.getKykDairitens();

        IT_KykSonotaTkyk itKykSonotaTkyk = pItKykKihon.getKykSonotaTkyk();

        List<IT_NyknJissekiRireki> itNyknJissekiRirekiList = pItKykKihon.getNyknJissekiRirekis();

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(itKykSyouhnList.get(0).getSyouhncd(),
            itKykSyouhnList.get(0).getSyouhnsdno());

        if (itKykDairitenList.size() > 1) {
            BzGetTuukeiBunwari bzGetTuukeiBunwari = SWAKInjector.getInstance(BzGetTuukeiBunwari.class);

            bzGetTuukeiBunwari.exec(itKykDairitenList.get(0).getDrtencd(),
                itKykDairitenList.get(0).getOyadrtencd(),
                itKykDairitenList.get(0).getBunwari(),
                itKykDairitenList.get(1).getDrtencd(),
                itKykDairitenList.get(1).getOyadrtencd(),
                itKykDairitenList.get(1).getBunwari(),
                pItKykKihon.getSeirituymd().getBizDateYM(),
                syouhnZokusei.getDrtsyouhinsikibetukbn(),
                pItKykKihon.getHrkkaisuu(),
                C_DiritenplannmKbn.BLNK);

            if (C_ErrorKbn.ERROR.eq(bzGetTuukeiBunwari.getErrorKbn())){
                throw new CommonBizAppException("通計用代理店分担割合取得が実行できませんでした。");
            }

            drtencd1 = bzGetTuukeiBunwari.getDrtencd1();
            bunwari1 = bzGetTuukeiBunwari.getBuntanWariai1();
            drtencd2 = bzGetTuukeiBunwari.getDrtencd2();
            bunwari2 = bzGetTuukeiBunwari.getBuntanWariai2();
        }
        else {
            drtencd1 = itKykDairitenList.get(0).getDrtencd();
            bunwari1 = itKykDairitenList.get(0).getBunwari();
            drtencd2 = "";
            bunwari2 = BizNumber.ZERO;
        }

        IT_Kouza kouza = pItKykKihon.getKouza();

        GetKhTuusanyouKngk getKhTuusanyouKngk = SWAKInjector.getInstance(GetKhTuusanyouKngk.class);

        GetKhTuusanyouKngkBean getKhTuusanyouKngkBean = getKhTuusanyouKngk.getAlltsnkngk(
            syouhnZokusei,
            itKykSyouhnList.get(0),
            itNyknJissekiRirekiList.get(0),
            itKykSonotaTkyk);

        SetTyotikuseihokenhyouji setTyotikuseihokenhyouji = SWAKInjector.getInstance(SetTyotikuseihokenhyouji.class);
        HanteiTyotikuseihokenBean hanteiTyotikuseihokenBean = SWAKInjector.getInstance(HanteiTyotikuseihokenBean.class);
        hanteiTyotikuseihokenBean.setSyouhnCd(itKykSyouhnList.get(0).getSyouhncd());
        hanteiTyotikuseihokenBean.setSyouhnsdNo(itKykSyouhnList.get(0).getSyouhnsdno());
        hanteiTyotikuseihokenBean.setHrkkaisuu(pItKykKihon.getHrkkaisuu());
        hanteiTyotikuseihokenBean.setHrkkeiro(pItKykKihon.getHrkkeiro());

        setTyotikuseihokenhyouji.hanteiTyotikuseihoken(hanteiTyotikuseihokenBean);

        C_HouteiTyotkseiSyouhnHyjKbn houteityotikuseiarihyj = C_HouteiTyotkseiSyouhnHyjKbn.HIGAITOU;

        if (C_UmuKbn.ARI.eq(setTyotikuseihokenhyouji.getHouteityotkhknhyj())) {

            houteityotikuseiarihyj = C_HouteiTyotkseiSyouhnHyjKbn.GAITOU;
        }

        bzKykNaiyouHaneiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        bzKykNaiyouHaneiYokenBean.setHuho2kykno(pItKykKihon.getSyono());
        bzKykNaiyouHaneiYokenBean.setMqyouhikbn(C_YouhiKbn.YOU);
        bzKykNaiyouHaneiYokenBean.setRecordsakujyohyouji(0);
        bzKykNaiyouHaneiYokenBean.setKhsyouhncd(itKykSyouhnList.get(0).getSyouhncd());
        bzKykNaiyouHaneiYokenBean.setKhkykjyoutai(itKykSyouhnList.get(0).getKykjyoutai());
        bzKykNaiyouHaneiYokenBean.setKhkykymd(itKykSyouhnList.get(0).getKykymd());
        bzKykNaiyouHaneiYokenBean.setKhyuukousyoumetukbn(itKykSyouhnList.get(0).getYuukousyoumetukbn());
        bzKykNaiyouHaneiYokenBean.setKhsyoumetujiyuu(itKykSyouhnList.get(0).getSyoumetujiyuu());
        bzKykNaiyouHaneiYokenBean.setKhsyoumetuymd(itKykSyouhnList.get(0).getSyoumetuymd());
        bzKykNaiyouHaneiYokenBean.setKhkyktuukasyu(itKykSyouhnList.get(0).getKyktuukasyu());
        bzKykNaiyouHaneiYokenBean.setKhtsntuukasyu(getKhTuusanyouKngkBean.getTsnyouTuukasyu());
        bzKykNaiyouHaneiYokenBean.setKhtsnsibous(getKhTuusanyouKngkBean.getTsnyouSibous());
        bzKykNaiyouHaneiYokenBean.setKhtsnitijip(getKhTuusanyouKngkBean.getTsnyouItijip());
        bzKykNaiyouHaneiYokenBean.setKhtsnnkgns(getKhTuusanyouKngkBean.getTsnyouNkgns());
        bzKykNaiyouHaneiYokenBean.setKhhrkkkn(itKykSyouhnList.get(0).getHrkkkn());
        bzKykNaiyouHaneiYokenBean.setKhsntkhoukbn(pItKykKihon.getSntkhoukbn());
        bzKykNaiyouHaneiYokenBean.setKhbosyuuym(pItKykKihon.getBosyuuym());

        if (C_Tdk.HONNIN.eq(itKykSya.getKkkyktdk())) {
            bzKykNaiyouHaneiYokenBean.setKhkykhhkndouhyouji(1);
        }
        else {
            bzKykNaiyouHaneiYokenBean.setKhkykhhkndouhyouji(0);
        }

        if (itKhTtdkTyuui != null) {
            bzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn1(itKhTtdkTyuui.getTtdktyuuikbn1());
            bzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn2(itKhTtdkTyuui.getTtdktyuuikbn2());
            bzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn3(itKhTtdkTyuui.getTtdktyuuikbn3());
            bzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn4(itKhTtdkTyuui.getTtdktyuuikbn4());
            bzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn5(itKhTtdkTyuui.getTtdktyuuikbn5());
        }
        else {
            bzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn1(C_TtdktyuuiKbn.BLNK);
            bzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn2(C_TtdktyuuiKbn.BLNK);
            bzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn3(C_TtdktyuuiKbn.BLNK);
            bzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn4(C_TtdktyuuiKbn.BLNK);
            bzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn5(C_TtdktyuuiKbn.BLNK);
        }
        bzKykNaiyouHaneiYokenBean.setKhsyouhnsdno(itKykSyouhnList.get(0).getSyouhnsdno());
        bzKykNaiyouHaneiYokenBean.setKhkaigomaehrtkykumukbn(itKykSonotaTkyk.getJyudkaigomeharaitkhukaumu());
        bzKykNaiyouHaneiYokenBean.setKhpyennykntkykumukbn(itKykSonotaTkyk.getYennykntkhkumu());
        bzKykNaiyouHaneiYokenBean.setKhtsnyennyknkgk(getKhTuusanyouKngkBean.getTsnyouYennyknkgk());
        bzKykNaiyouHaneiYokenBean.setKhskjmosno(pItKykKihon.getSkjmosno());
        bzKykNaiyouHaneiYokenBean.setHouteityotkseihyj(houteityotikuseiarihyj);
        bzKykNaiyouHaneiYokenBean.setSeiritujitrhkjikakkbn(pItKykKihon.getSeiritujitrhkjikakkbn());
        bzKykNaiyouHaneiYokenBean.setKhhrkkeiro(pItKykKihon.getHrkkeiro());
        bzKykNaiyouHaneiYokenBean.setHhknnmkn(itHhknSya.getHhknnmkn());
        if (C_KjkhukaKbn.KJKHUKA.eq(itHhknSya.getHhknnmkjkhukakbn())) {
            bzKykNaiyouHaneiYokenBean.setHhknnmkj("");
        }
        else {
            bzKykNaiyouHaneiYokenBean.setHhknnmkj(itHhknSya.getHhknnmkj());
        }
        bzKykNaiyouHaneiYokenBean.setHhknseiymd(itHhknSya.getHhknseiymd());
        bzKykNaiyouHaneiYokenBean.setHhknsei(itHhknSya.getHhknsei());
        bzKykNaiyouHaneiYokenBean.setHhknyno(itHhknSya.getHhknyno());
        bzKykNaiyouHaneiYokenBean.setHhknadr1kj("");
        bzKykNaiyouHaneiYokenBean.setHhknadr2kj("");
        bzKykNaiyouHaneiYokenBean.setHhknadr3kj("");
        bzKykNaiyouHaneiYokenBean.setHhkntelno("");
        bzKykNaiyouHaneiYokenBean.setHhknsykgycd(pItKykKihon.getHhknsykgycd());
        bzKykNaiyouHaneiYokenBean.setKyknmkn(kyknmkn);
        bzKykNaiyouHaneiYokenBean.setKyknmkj(kyknmkj);
        bzKykNaiyouHaneiYokenBean.setKykseiymd(kykseiymd);
        bzKykNaiyouHaneiYokenBean.setNenkinuktnmkana("");
        bzKykNaiyouHaneiYokenBean.setNenkinuktnmkanji("");
        bzKykNaiyouHaneiYokenBean.setNenkinuktseiymd(null);
        bzKykNaiyouHaneiYokenBean.setTsinyno(itKykSya.getTsinyno());
        bzKykNaiyouHaneiYokenBean.setTsinadr1kj(itKykSya.getTsinadr1kj());
        bzKykNaiyouHaneiYokenBean.setTsinadr2kj(itKykSya.getTsinadr2kj());
        bzKykNaiyouHaneiYokenBean.setTsinadr3kj(itKykSya.getTsinadr3kj());
        bzKykNaiyouHaneiYokenBean.setTsintelno(itKykSya.getTsintelno());
        bzKykNaiyouHaneiYokenBean.setSbuktnmkn1(sbuktnmkn1);
        bzKykNaiyouHaneiYokenBean.setSbuktnmkj1(sbuktnmkj1);
        bzKykNaiyouHaneiYokenBean.setSbuktnmkn2(sbuktnmkn2);
        bzKykNaiyouHaneiYokenBean.setSbuktnmkj2(sbuktnmkj2);
        bzKykNaiyouHaneiYokenBean.setSbuktnmkn3(sbuktnmkn3);
        bzKykNaiyouHaneiYokenBean.setSbuktnmkj3(sbuktnmkj3);
        bzKykNaiyouHaneiYokenBean.setSbuktnmkn4(sbuktnmkn4);
        bzKykNaiyouHaneiYokenBean.setSbuktnmkj4(sbuktnmkj4);
        bzKykNaiyouHaneiYokenBean.setStdrsknmkn(stdrsknmkn);
        bzKykNaiyouHaneiYokenBean.setStdrsknmkj(stdrsknmkj);
        bzKykNaiyouHaneiYokenBean.setKykdairinmkn(kykdairinmkn);
        bzKykNaiyouHaneiYokenBean.setKykdairinmkj(kykdairinmkj);
        bzKykNaiyouHaneiYokenBean.setKzktourokunmkn1(kzktourokunmkn1);
        bzKykNaiyouHaneiYokenBean.setKzktourokunmkj1(kzktourokunmkj1);
        bzKykNaiyouHaneiYokenBean.setKzktourokunmkn2(kzktourokunmkn2);
        bzKykNaiyouHaneiYokenBean.setKzktourokunmkj2(kzktourokunmkj2);
        bzKykNaiyouHaneiYokenBean.setDairitencd1(drtencd1);
        bzKykNaiyouHaneiYokenBean.setBunwari1(bunwari1);
        bzKykNaiyouHaneiYokenBean.setKanrisosikicd1(itKykDairitenList.get(0).getDrtenkanrisosikicd());
        bzKykNaiyouHaneiYokenBean.setDairitencd2(drtencd2);
        bzKykNaiyouHaneiYokenBean.setBunwari2(bunwari2);

        if (itKykDairitenList.size() > 1) {
            bzKykNaiyouHaneiYokenBean.setKanrisosikicd2(itKykDairitenList.get(1).getDrtenkanrisosikicd());
        }
        else {
            bzKykNaiyouHaneiYokenBean.setKanrisosikicd2("");
        }

        if (C_Hrkkeiro.KOUHURI.eq(pItKykKihon.getHrkkeiro())) {
            bzKykNaiyouHaneiYokenBean.setBankcd(kouza.getBankcd());
            bzKykNaiyouHaneiYokenBean.setSitencd(kouza.getSitencd());
            bzKykNaiyouHaneiYokenBean.setYokinkbn(kouza.getYokinkbn());
            bzKykNaiyouHaneiYokenBean.setKouzano(kouza.getKouzano());
            bzKykNaiyouHaneiYokenBean.setKzmeiginmkn(kouza.getKzmeiginmkn());
            bzKykNaiyouHaneiYokenBean.setKzkykdoukbn(kouza.getKzkykdoukbn());
        }

        logger.debug("｜ ▽ 契約内容反映与件Beanの設定");
        logger.debug("｜ ｜ 普保Ⅱ契約番号区分＝　　　　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getHuho2kyknokbn());
        logger.debug("｜ ｜ 普保Ⅱ契約番号＝　　　　　　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getHuho2kykno());
        logger.debug("｜ ｜ ＭＱ要否区分＝　　　　　　　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getMqyouhikbn());
        logger.debug("｜ ｜ レコード削除表示＝　　　　　　　　　　　　" +
            bzKykNaiyouHaneiYokenBean.getRecordsakujyohyouji());
        logger.debug("｜ ｜ （契約保全）商品コード＝　　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getKhsyouhncd());
        logger.debug("｜ ｜ （契約保全）契約状態＝　　　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getKhkykjyoutai());
        logger.debug("｜ ｜ （契約保全）契約日＝　　　　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getKhkykymd());
        logger.debug("｜ ｜ （契約保全）有効消滅区分＝　　　　　　　　" +
            bzKykNaiyouHaneiYokenBean.getKhyuukousyoumetukbn());
        logger.debug("｜ ｜ （契約保全）消滅事由＝　　　　　　　　　　" +
            bzKykNaiyouHaneiYokenBean.getKhsyoumetujiyuu());
        logger.debug("｜ ｜ （契約保全）消滅日＝　　　　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getKhsyoumetuymd());
        logger.debug("｜ ｜ （契約保全）契約通貨種類＝　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getKhkyktuukasyu());
        logger.debug("｜ ｜ （契約保全）通算用通貨種類＝　　　　　　　" + bzKykNaiyouHaneiYokenBean.getKhtsntuukasyu());
        logger.debug("｜ ｜ （契約保全）通算用死亡Ｓ＝　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getKhtsnsibous());
        logger.debug("｜ ｜ （契約保全）通算用一時払Ｐ＝　　　　　　　" + bzKykNaiyouHaneiYokenBean.getKhtsnitijip());
        logger.debug("｜ ｜ （契約保全）通算用年金原資＝　　　　　　　" + bzKykNaiyouHaneiYokenBean.getKhtsnnkgns());
        logger.debug("｜ ｜ （契約保全）払込期間＝　　　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getKhhrkkkn());
        logger.debug("｜ ｜ （契約保全）選択方法区分＝　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getKhsntkhoukbn());
        logger.debug("｜ ｜ （契約保全）募集年月＝　　　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getKhbosyuuym());
        logger.debug("｜ ｜ （契約保全）契約者被保険者同一表示＝　　　" +
            bzKykNaiyouHaneiYokenBean.getKhkykhhkndouhyouji());
        logger.debug("｜ ｜ （契約保全）手続注意区分１＝　　　　　　　" +
            bzKykNaiyouHaneiYokenBean.getKhttdktyuuikbn1());
        logger.debug("｜ ｜ （契約保全）手続注意区分２＝　　　　　　　" +
            bzKykNaiyouHaneiYokenBean.getKhttdktyuuikbn2());
        logger.debug("｜ ｜ （契約保全）手続注意区分３＝　　　　　　　" +
            bzKykNaiyouHaneiYokenBean.getKhttdktyuuikbn3());
        logger.debug("｜ ｜ （契約保全）手続注意区分４＝　　　　　　　" +
            bzKykNaiyouHaneiYokenBean.getKhttdktyuuikbn4());
        logger.debug("｜ ｜ （契約保全）手続注意区分５＝　　　　　　　" +
            bzKykNaiyouHaneiYokenBean.getKhttdktyuuikbn5());
        logger.debug("｜ ｜ （契約保全）商品世代番号＝　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getKhsyouhnsdno());
        logger.debug("｜ ｜ （契約保全）介護前払特約有無区分＝　　　　" +
            bzKykNaiyouHaneiYokenBean.getKhkaigomaehrtkykumukbn());
        logger.debug("｜ ｜ （契約保全）保険料円入金特約有無区分＝　　" +
            bzKykNaiyouHaneiYokenBean.getKhpyennykntkykumukbn());
        logger.debug("｜ ｜ （契約保全）通算用円入金額＝　　　　　　　" + bzKykNaiyouHaneiYokenBean.getKhtsnyennyknkgk());
        logger.debug("｜ ｜ （契約保全）新契約時申込番号＝　　　　　　" + bzKykNaiyouHaneiYokenBean.getKhskjmosno());
        logger.debug("｜ ｜ （契約保全）法定貯蓄性有表示＝　　　　　　" + bzKykNaiyouHaneiYokenBean.getHouteityotkseihyj());
        logger.debug("｜ ｜ （契約保全）成立時取引時確認区分＝　　　　" + bzKykNaiyouHaneiYokenBean.getSeiritujitrhkjikakkbn());
        logger.debug("｜ ｜ （契約保全）払込経路＝　　　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getKhhrkkeiro());
        logger.debug("｜ ｜ ▽ 被保険者情報");
        logger.debug("｜ ｜ ｜ 被保険者名（カナ）＝　　　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getHhknnmkn());
        logger.debug("｜ ｜ ｜ 被保険者名（漢字）＝　　　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getHhknnmkj());
        logger.debug("｜ ｜ ｜ 被保険者生年月日＝　　　　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getHhknseiymd());
        logger.debug("｜ ｜ ｜ 被保険者性別＝　　　　　　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getHhknsei());
        logger.debug("｜ ｜ ｜ 被保険者郵便番号＝　　　　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getHhknyno());
        logger.debug("｜ ｜ ｜ 被保険者住所１（漢字）＝　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getHhknadr1kj());
        logger.debug("｜ ｜ ｜ 被保険者住所２（漢字）＝　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getHhknadr2kj());
        logger.debug("｜ ｜ ｜ 被保険者住所３（漢字）＝　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getHhknadr3kj());
        logger.debug("｜ ｜ ｜ 被保険者電話番号＝　　　　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getHhkntelno());
        logger.debug("｜ ｜ ｜ 被保険者職業コード＝　　　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getHhknsykgycd());
        logger.debug("｜ ｜ △ ");
        logger.debug("｜ ｜ ▽ 契約者情報");
        logger.debug("｜ ｜ ｜ 契約者名（カナ）＝　　　　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getKyknmkn());
        logger.debug("｜ ｜ ｜ 契約者名（漢字）＝　　　　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getKyknmkj());
        logger.debug("｜ ｜ ｜ 契約者生年月日＝　　　　　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getKykseiymd());
        logger.debug("｜ ｜ △ ");
        logger.debug("｜ ｜ ▽ 年金受取人情報");
        logger.debug("｜ ｜ ｜ 年金受取人名（カナ）＝　　　　　　　　　" +
            bzKykNaiyouHaneiYokenBean.getNenkinuktnmkana());
        logger.debug("｜ ｜ ｜ 年金受取人名（漢字）＝　　　　　　　　　" +
            bzKykNaiyouHaneiYokenBean.getNenkinuktnmkanji());
        logger.debug("｜ ｜ ｜ 年金受取人生年月日＝　　　　　　　　　　" +
            bzKykNaiyouHaneiYokenBean.getNenkinuktseiymd());
        logger.debug("｜ ｜ △ ");
        logger.debug("｜ ｜ ▽ 通信先情報");
        logger.debug("｜ ｜ ｜ 通信先郵便番号＝　　　　　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getTsinyno());
        logger.debug("｜ ｜ ｜ 通信先住所１（漢字）＝　　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getTsinadr1kj());
        logger.debug("｜ ｜ ｜ 通信先住所２（漢字）＝　　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getTsinadr2kj());
        logger.debug("｜ ｜ ｜ 通信先住所３（漢字）＝　　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getTsinadr3kj());
        logger.debug("｜ ｜ ｜ 通信先電話番号＝　　　　　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getTsintelno());
        logger.debug("｜ ｜ △ ");
        logger.debug("｜ ｜ ▽ 死亡受取人情報");
        logger.debug("｜ ｜ ｜ 死亡受取人名（カナ）１＝　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getSbuktnmkn1());
        logger.debug("｜ ｜ ｜ 死亡受取人名（漢字）１＝　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getSbuktnmkj1());
        logger.debug("｜ ｜ ｜ 死亡受取人名（カナ）２＝　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getSbuktnmkn2());
        logger.debug("｜ ｜ ｜ 死亡受取人名（漢字）２＝　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getSbuktnmkj2());
        logger.debug("｜ ｜ ｜ 死亡受取人名（カナ）３＝　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getSbuktnmkn3());
        logger.debug("｜ ｜ ｜ 死亡受取人名（漢字）３＝　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getSbuktnmkj3());
        logger.debug("｜ ｜ ｜ 死亡受取人名（カナ）４＝　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getSbuktnmkn4());
        logger.debug("｜ ｜ ｜ 死亡受取人名（漢字）４＝　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getSbuktnmkj4());
        logger.debug("｜ ｜ △ ");
        logger.debug("｜ ｜ ▽ 被保険者代理人情報");
        logger.debug("｜ ｜ ｜ 指定代理請求人名（カナ）＝　　　　　　　" + bzKykNaiyouHaneiYokenBean.getStdrsknmkn());
        logger.debug("｜ ｜ ｜ 指定代理請求人名（漢字）＝　　　　　　　" + bzKykNaiyouHaneiYokenBean.getStdrsknmkj());
        logger.debug("｜ ｜ △ ");
        logger.debug("｜ ｜ ▽ 契約者代理人情報");
        logger.debug("｜ ｜ ｜ 契約者代理人名（カナ）＝　　　　　　　" + bzKykNaiyouHaneiYokenBean.getKykdairinmkn());
        logger.debug("｜ ｜ ｜ 契約者代理人名（漢字）＝　　　　　　　" + bzKykNaiyouHaneiYokenBean.getKykdairinmkj());
        logger.debug("｜ ｜ △ ");
        logger.debug("｜ ｜ ▽ 登録家族情報");
        logger.debug("｜ ｜ ｜ 家族登録名（カナ）１＝　　　　　　　" + bzKykNaiyouHaneiYokenBean.getKzktourokunmkn1());
        logger.debug("｜ ｜ ｜ 家族登録名（漢字）１＝　　　　　　　" + bzKykNaiyouHaneiYokenBean.getKzktourokunmkj1());
        logger.debug("｜ ｜ ｜ 家族登録名（カナ）２＝　　　　　　　" + bzKykNaiyouHaneiYokenBean.getKzktourokunmkn2());
        logger.debug("｜ ｜ ｜ 家族登録名（漢字）２＝　　　　　　　" + bzKykNaiyouHaneiYokenBean.getKzktourokunmkj2());
        logger.debug("｜ ｜ △ ");
        logger.debug("｜ ｜ 代理店コード１＝　　　　　　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getDairitencd1());
        logger.debug("｜ ｜ 分担割合１＝　　　　　　　　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getBunwari1());
        logger.debug("｜ ｜ 代理店コード２＝　　　　　　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getDairitencd2());
        logger.debug("｜ ｜ 分担割合２＝　　　　　　　　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getBunwari2());
        logger.debug("｜ ｜ 管理組織コード１＝　　　　　　　　　　　　" +
            bzKykNaiyouHaneiYokenBean.getKanrisosikicd1());
        logger.debug("｜ ｜ 管理組織コード２＝　　　　　　　　　　　　" +
            bzKykNaiyouHaneiYokenBean.getKanrisosikicd2());
        logger.debug("｜ ｜ ▽ 口座情報");
        logger.debug("｜ ｜ ｜ 銀行コード＝　　　　　　　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getBankcd());
        logger.debug("｜ ｜ ｜ 支店コード＝　　　　　　　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getSitencd());
        logger.debug("｜ ｜ ｜ 預金種目区分＝　　　　　　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getYokinkbn());
        logger.debug("｜ ｜ ｜ 口座番号＝　　　　　　　　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getKouzano());
        logger.debug("｜ ｜ ｜ 口座名義人氏名（カナ）＝　　　　　　　　" + bzKykNaiyouHaneiYokenBean.getKzmeiginmkn());
        logger.debug("｜ ｜ ｜ 口座名義契約者同一人区分＝　　　　　　　" + bzKykNaiyouHaneiYokenBean.getKzkykdoukbn());
        logger.debug("｜ ｜ △ ");
        logger.debug("｜ △ ");

        BzKykNaiyouHaneiMq bzKykNaiyouHaneiMq = SWAKInjector.getInstance(BzKykNaiyouHaneiMq.class);

        BzKykNaiyouHaneiKekkaBean bzKykNaiyouHaneiKekkaBean = bzKykNaiyouHaneiMq.exec(bzKykNaiyouHaneiYokenBean);

        if (C_MQSyorikekkaKbn.ERROR.eq(bzKykNaiyouHaneiKekkaBean.getMqsyorikekkakbn())) {
            throw new BizLogicException(MessageId.EIA1011, PALKYKNAIYOU_UPDATESYORI);
        }

        if (C_KyknaiyouhaneiErrKbn.SYORIERROR.eq(bzKykNaiyouHaneiKekkaBean.getKyknaiyouhaneierrkbn())) {
            throw new BizLogicException(MessageId.EBA1020);
        }
        else if (C_KyknaiyouhaneiErrKbn.HUMEI_JIDOUTRKSYOU.eq(bzKykNaiyouHaneiKekkaBean.getKyknaiyouhaneierrkbn())) {

            BzTrksIraiYokenBean trksIraiYokenBean = SWAKInjector.getInstance(BzTrksIraiYokenBean.class);

            trksIraiYokenBean.setYoukyuuno(bzKykNaiyouHaneiKekkaBean.getYoukyuuno());

            trksIraiYokenBean.setHuho2kyknokbn(bzKykNaiyouHaneiYokenBean.getHuho2kyknokbn());

            trksIraiYokenBean.setHuho2kykno(bzKykNaiyouHaneiYokenBean.getHuho2kykno());

            trksIraiYokenBean.setKyknaiyouhaneierrkbn(bzKykNaiyouHaneiKekkaBean.getKyknaiyouhaneierrkbn());

            BzTrksIraiMq trksIraiMq = SWAKInjector.getInstance(BzTrksIraiMq.class);

            BzTrksIraiKekkaBean trksIraiKekkaBean = trksIraiMq.exec(trksIraiYokenBean);

            if (C_MQSyorikekkaKbn.ERROR.eq(trksIraiKekkaBean.getMqsyorikekkakbn()) ||
                (C_MQSyorikekkaKbn.SEIJYOU.eq(trksIraiKekkaBean.getMqsyorikekkakbn()) &&
                    !C_TorikesiKekkaKbn.TORIKESIOK.eq(trksIraiKekkaBean.getTrkskekkakbn()))) {

                if (C_JdTrksPalTrksZanKbn.NONE.eq(trksIraiKekkaBean.getJdtrkspaltrkszankbn())) {

                    throw new BizLogicException(MessageId.EIA1012, PALKYKNAIYOU_UPDATE);
                }

                else if (C_JdTrksPalTrksZanKbn.ARI.eq(trksIraiKekkaBean.getJdtrkspaltrkszankbn())) {

                    throw new BizLogicException(MessageId.EBA1021);
                }
                else {

                    throw new BizLogicException(MessageId.EBA1022);
                }
            }
        }
        else {

            domManager.insert(bzKykNaiyouHaneiKekkaBean.getTjtidounykh());
        }

        if (C_Tdk.HONNIN.eq(itKykSya.getKkkyktdk())) {
            bzKykNaiyouHaneiKekkaBean.setKyknysjissikekkakbn(bzKykNaiyouHaneiKekkaBean.getHhknnysjissikekkakbn());
            bzKykNaiyouHaneiKekkaBean.setKyksakuinmeino(bzKykNaiyouHaneiKekkaBean.getHhknsakuinmeino());
        }
        hhknnysjissikekkakbn = bzKykNaiyouHaneiKekkaBean.getHhknnysjissikekkakbn();
        hhknsakuinmeino = bzKykNaiyouHaneiKekkaBean.getHhknsakuinmeino();
        kyknysjissikekkakbn = bzKykNaiyouHaneiKekkaBean.getKyknysjissikekkakbn();
        kyksakuinmeino = bzKykNaiyouHaneiKekkaBean.getKyksakuinmeino();
        youkyuuno = bzKykNaiyouHaneiKekkaBean.getYoukyuuno();

        logger.debug("｜ ▽ 戻り値");
        logger.debug("｜ ｜ 被保険者名寄せ結果区分＝　　" + hhknnysjissikekkakbn);
        logger.debug("｜ ｜ 被保険者索引名番号＝　　　　" + hhknsakuinmeino);
        logger.debug("｜ ｜ 契約者名寄せ結果区分＝　　　" + kyknysjissikekkakbn);
        logger.debug("｜ ｜ 契約者索引名番号＝　　　　　" + kyksakuinmeino);
        logger.debug("｜ ｜ 要求通番＝　　　　　　　　　" + youkyuuno);
        logger.debug("｜ △ ");
        logger.debug("△ ＰＡＬ契約内容更新処理 終了");
    }

    public C_NayoseJissiKekkaKbn getHhknSyaNayoseJissiKekkaKbn() {
        return this.hhknnysjissikekkakbn;
    }

    public String getHhknSakuinmeino() {
        return this.hhknsakuinmeino;
    }

    public C_NayoseJissiKekkaKbn getKykSyaNayoseJissiKekkaKbn() {
        return this.kyknysjissikekkakbn;
    }

    public String getKykSakuinmeino() {
        return this.kyksakuinmeino;
    }

    public String getYoukyuuno() {
        return this.youkyuuno;
    }

}
