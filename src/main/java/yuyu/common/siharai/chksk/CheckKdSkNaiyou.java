package yuyu.common.siharai.chksk;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.def.MessageId;
import yuyu.def.classification.C_SikinouModeIdKbn;
import yuyu.def.siharai.manager.SiharaiDomManager;

/**
 * 保険金給付金支払 請求内容チェック 請求内容チェックメイン（高度障害）
 */
public class CheckKdSkNaiyou {

    @Inject
    private static Logger logger;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    public CheckKdSkNaiyou() {
        super();
    }

    public CheckKdSkNaiyouKekkaBean exec(CheckKdSkNaiyouParam pCheckKdSkNaiyouParam, String pYobidasimotoKinouId,
        C_SikinouModeIdKbn pSikinouModeIdKbn) {

        logger.debug("▽ 請求内容チェックメイン（高度障害） 開始");

        if (pCheckKdSkNaiyouParam == null) {

            throw new BizAppException(MessageId.EJS1005, "pCheckKdSkNaiyouParam");
        }

        CheckKdSkNaiyouKekkaBean chkKdSbKekka = SWAKInjector.getInstance(CheckKdSkNaiyouKekkaBean.class);
        /*

        KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);
        KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);
        keiyakuPrm.setSyono(pCheckKdSkNaiyouParam.getSyono());
        keiyakuInfoSyutoku.getInfos(keiyakuPrm);
        List<JT_SiKykKihon> siKykKihonList = keiyakuInfoSyutoku.getKykKihons();
        JT_SiKykKihon siKykKihon = siKykKihonList.get(0);

        if (siKykKihon == null) {
            throw new BizAppException(MessageId.EBS0004, "JT_SiKykKihon", "syono", pCheckKdSkNaiyouParam.getSyono());
        }

        JM_Kyuuhu kyuuhuCheck = new JM_Kyuuhu();

        kyuuhuCheck.setKyuuhucd(null);
        kyuuhuCheck.setSeikyuusyubetu(null);
        kyuuhuCheck.setKyuuhuname(null);
        kyuuhuCheck.setKyuuhunamegamen(null);
        kyuuhuCheck.setKyuuhunamereport(null);
        kyuuhuCheck.setHyoujijyun(null);
        kyuuhuCheck.setGeninkbn(null);
        kyuuhuCheck.setSaigaisippeinyuinumukbn(null);
        kyuuhuCheck.setKyuuhukbn(null);
        kyuuhuCheck.setUktsyukbn(null);
        kyuuhuCheck.setSateirankcd(null);
        kyuuhuCheck.setNkseikyuucheck(C_UmuKbn.NONE);
        kyuuhuCheck.setHassoukbncheck(C_UmuKbn.NONE);
        kyuuhuCheck.setHonninkaknincheck(C_UmuKbn.NONE);
        kyuuhuCheck.setKijyunymdcheck(C_UmuKbn.NONE);
        kyuuhuCheck.setGeninkbncheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSyuhiyoucheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSyoumetucheck(C_UmuKbn.NONE);
        kyuuhuCheck.setDoujisksyoricheck(C_UmuKbn.NONE);
        kyuuhuCheck.setKhsyoricheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSknnkaisiymdcheck(C_UmuKbn.NONE);
        kyuuhuCheck.setHknkkncheck(C_UmuKbn.NONE);
        kyuuhuCheck.setPhrkyuuyokkncheck(C_UmuKbn.NONE);
        kyuuhuCheck.setFstphrkyuuyokkntyoukacheck(C_UmuKbn.NONE);
        kyuuhuCheck.setTokkoudosghtnpcheck(C_UmuKbn.NONE);
        kyuuhuCheck.setHokenkinshrskgnkkncheck(C_UmuKbn.NONE);
        kyuuhuCheck.setNkkiteicheck(C_UmuKbn.NONE);
        kyuuhuCheck.setTtdktyuuicheck(C_UmuKbn.NONE);
        kyuuhuCheck.setUktcheck(C_UmuKbn.NONE);
        kyuuhuCheck.setFirstpminyuucheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSinsatyuuicheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSateijisatumensekicheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSateisknnkaisiymdcheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSateigengkcheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSateimeigihnkcheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSateistknsetcheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSateihasantosancheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSateisasiosaecheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSateisousasyoukaicheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSateihusyousicheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSateikaigaisbcheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSateimrinfocheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSateihigaitoucheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSateihnsycheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSateiseikyuusyoruicheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSateikaigaicheck(C_UmuKbn.NONE);
        kyuuhuCheck.setHokenkngkhyoujikbn(null);
        kyuuhuCheck.setHokenkngkhyoujimsg1(null);
        kyuuhuCheck.setHokenkngkhyoujimsg2(null);

        for (JT_SiKykSyouhn siKykSyouhn : siKykKihon.getSiKykSyouhns()) {
            List<JM_SiSyouhnZokusei> siSyouhnZokuseiLst = siharaiDomManager
                .getSiSyouhnZokuseisBySyouhncdKyhgndkatakbnSyouhnsdno(siKykSyouhn.getSyouhncd(), siKykSyouhn
                    .getKyhgndkatakbn(), siKykSyouhn.getSyouhnsdno());

            if (siSyouhnZokuseiLst.size() == 0) {

                throw new BizAppException(MessageId.EBS0006, "JM_SiSyouhnZokusei",
                    "syouhncd", siKykSyouhn.getSyouhncd(),
                    "kyhgndkatakbn", siKykSyouhn.getKyhgndkatakbn().getValue(),
                    "syouhnsdno", String.valueOf(siKykSyouhn.getSyouhnsdno()));
            }

            for (JM_SiSyouhnZokusei siSyouhnZokusei : siSyouhnZokuseiLst) {
                JM_Kyuuhu kyuuhu = siharaiDomManager.getKyuuhu(siSyouhnZokusei.getKyuuhucd());

                if (C_SeikyuuSyubetu.KOUSG.eq(kyuuhu.getSeikyuusyubetu())) {

                    if (C_UmuKbn.ARI.eq(kyuuhu.getNkseikyuucheck())) {
                        kyuuhuCheck.setNkseikyuucheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getHassoukbncheck())) {
                        kyuuhuCheck.setHassoukbncheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getHonninkaknincheck())) {
                        kyuuhuCheck.setHonninkaknincheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getKijyunymdcheck())) {
                        kyuuhuCheck.setKijyunymdcheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getGeninkbncheck())) {
                        kyuuhuCheck.setGeninkbncheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getSyuhiyoucheck())) {
                        kyuuhuCheck.setSyuhiyoucheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getSyoumetucheck())) {
                        kyuuhuCheck.setSyoumetucheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getDoujisksyoricheck())) {
                        kyuuhuCheck.setDoujisksyoricheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getKhsyoricheck())) {
                        kyuuhuCheck.setKhsyoricheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getSknnkaisiymdcheck())) {
                        kyuuhuCheck.setSknnkaisiymdcheck(C_UmuKbn.ARI);
                    }

                    kyuuhuCheck.setHknkkncheck(C_UmuKbn.NONE);

                    if (C_UmuKbn.ARI.eq(kyuuhu.getPhrkyuuyokkncheck())) {
                        kyuuhuCheck.setPhrkyuuyokkncheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getFstphrkyuuyokkntyoukacheck())) {
                        kyuuhuCheck.setFstphrkyuuyokkntyoukacheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getTokkoudosghtnpcheck())) {
                        kyuuhuCheck.setTokkoudosghtnpcheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getHokenkinshrskgnkkncheck())) {
                        kyuuhuCheck.setHokenkinshrskgnkkncheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getNkkiteicheck())) {
                        kyuuhuCheck.setNkkiteicheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getTtdktyuuicheck())) {
                        kyuuhuCheck.setTtdktyuuicheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getUktcheck())) {
                        kyuuhuCheck.setUktcheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getFirstpminyuucheck())) {
                        kyuuhuCheck.setFirstpminyuucheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getSinsatyuuicheck())) {
                        kyuuhuCheck.setSinsatyuuicheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getSateijisatumensekicheck())) {
                        kyuuhuCheck.setSateijisatumensekicheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getSateisknnkaisiymdcheck())) {
                        kyuuhuCheck.setSateisknnkaisiymdcheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getSateigengkcheck())) {
                        kyuuhuCheck.setSateigengkcheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getSateimeigihnkcheck())) {
                        kyuuhuCheck.setSateimeigihnkcheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getSateistknsetcheck())) {
                        kyuuhuCheck.setSateistknsetcheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getSateihasantosancheck())) {
                        kyuuhuCheck.setSateihasantosancheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getSateisasiosaecheck())) {
                        kyuuhuCheck.setSateisasiosaecheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getSateisousasyoukaicheck())) {
                        kyuuhuCheck.setSateisousasyoukaicheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getSateihusyousicheck())) {
                        kyuuhuCheck.setSateihusyousicheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getSateikaigaisbcheck())) {
                        kyuuhuCheck.setSateikaigaisbcheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getSateimrinfocheck())) {
                        kyuuhuCheck.setSateimrinfocheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getSateihigaitoucheck())) {
                        kyuuhuCheck.setSateihigaitoucheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getSateihnsycheck())) {
                        kyuuhuCheck.setSateihnsycheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getSateiseikyuusyoruicheck())) {
                        kyuuhuCheck.setSateiseikyuusyoruicheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getSateikaigaicheck())) {
                        kyuuhuCheck.setSateikaigaicheck(C_UmuKbn.ARI);
                    }
                }
            }
        }

        JT_SiKykSyouhn siKykSyouhn = null;
        for (JT_SiKykSyouhn siKykSyouhnTemp : siKykKihon.getSiKykSyouhns()) {
            if (C_SyutkKbn.SYU.eq(siKykSyouhnTemp.getSyutkkbn())) {
                siKykSyouhn = siKykSyouhnTemp;
            }
        }

        List<JM_SiSyouhnZokusei> siSyouhnZokuseiSyuLst = siharaiDomManager
            .getSiSyouhnZokuseisBySyouhncdKyhgndkatakbnSyouhnsdno(siKykSyouhn.getSyouhncd(),
                siKykSyouhn.getKyhgndkatakbn(), siKykSyouhn.getSyouhnsdno());

        for (JM_SiSyouhnZokusei SiSyouhnZokuseiSyu : siSyouhnZokuseiSyuLst) {
            JM_Kyuuhu kyuuhu = siharaiDomManager.getKyuuhu(SiSyouhnZokuseiSyu.getKyuuhucd());
            if (C_SeikyuuSyubetu.KOUSG.eq(kyuuhu.getSeikyuusyubetu())) {
                if (C_UmuKbn.ARI.eq(kyuuhu.getHknkkncheck())) {
                    kyuuhuCheck.setHknkkncheck(C_UmuKbn.ARI);
                }
            }
        }

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        ChkSubSksyaInfo chkSubSksyaInfo = SWAKInjector.getInstance(ChkSubSksyaInfo.class);
        chkSubSksyaInfo.exec(
            pCheckKdSkNaiyouParam.getSeikyuusyakbn(),
            pCheckKdSkNaiyouParam.getSeikyuusyanmkn(),
            pCheckKdSkNaiyouParam.getSeikyuusyanmkj(),
            pCheckKdSkNaiyouParam.getSeikyuusyaseiymd(),
            pCheckKdSkNaiyouParam.getSeikyuusyasei(),
            pCheckKdSkNaiyouParam.getSkkihon().getSeikyuusyubetu(),
            siKykKihon, chkKekkaBeanLst);

        ChkSubSinkensyaInfo chkSubSinkensyaInfo = SWAKInjector.getInstance(ChkSubSinkensyaInfo.class);
        chkSubSinkensyaInfo.exec(
            pCheckKdSkNaiyouParam.getSkskknnmkn(),
            pCheckKdSkNaiyouParam.getSkskknnmkj(),
            pCheckKdSkNaiyouParam.getSkskknsyubetu(),
            chkKekkaBeanLst);

        ChkSubShskInfo chkSubShskInfo = SWAKInjector.getInstance(ChkSubShskInfo.class);
        chkSubShskInfo.exec(
            pCheckKdSkNaiyouParam.getSouhusakikbn(),
            pCheckKdSkNaiyouParam.getTsinyno(),
            pCheckKdSkNaiyouParam.getTsinadr1kj(),
            pCheckKdSkNaiyouParam.getTsinadr2kj(),
            pCheckKdSkNaiyouParam.getTsinadr3kj(),
            pCheckKdSkNaiyouParam.getTsintelno(),
            siKykKihon, chkKekkaBeanLst);

        ChkSubSksInfo chkSubSksInfo = SWAKInjector.getInstance(ChkSubSksInfo.class);
        C_Tuukasyu tuukasyu;

        if (C_Tuukasyu.JPY.eq(siKykSyouhn.getKyktuukasyu())) {
            tuukasyu = C_Tuukasyu.JPY;
        }
        else {
            if (C_Tkhukaumu.HUKA.eq(pCheckKdSkNaiyouParam.getYenshrtkhukaumukbn())) {
                tuukasyu = C_Tuukasyu.JPY;
            }
            else {
                tuukasyu = siKykSyouhn.getKyktuukasyu();
            }
        }

        String seikyuusyanmkn = "";
        if (C_SeikyuusyaKbn.UKTHONNIN.eq(pCheckKdSkNaiyouParam.getSeikyuusyakbn())) {
            for (JT_SiUkt siUkt : siKykKihon.getSiUkts()) {
                if (C_Hkuktsyu.KDSGHKUKT.eq(siUkt.getHkuktsyu())) {
                    seikyuusyanmkn = siUkt.getUktnmkn();
                }
            }
        }
        else if (C_SeikyuusyaKbn.STDR.eq(pCheckKdSkNaiyouParam.getSeikyuusyakbn())) {
            seikyuusyanmkn = siKykKihon.getSiteidruktnmkn();
        }
        else {
            seikyuusyanmkn = pCheckKdSkNaiyouParam.getSeikyuusyanmkn();
        }

        chkSubSksInfo.exec(
            pCheckKdSkNaiyouParam.getInputshrhousiteikbn(),
            pCheckKdSkNaiyouParam.getBankcd(),
            pCheckKdSkNaiyouParam.getSitencd(),
            pCheckKdSkNaiyouParam.getYokinkbn(),
            pCheckKdSkNaiyouParam.getKouzano(),
            pCheckKdSkNaiyouParam.getKzdoukbn(),
            pCheckKdSkNaiyouParam.getKzmeiginmkn(),
            tuukasyu, seikyuusyanmkn, chkKekkaBeanLst);

        //        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getNkseikyuucheck())) {
        //            ChkSubNenkinSk chkSubNenkinSk = SWAKInjector.getInstance(ChkSubNenkinSk.class);
        //            chkSubNenkinSk.exec(
        //                    pCheckKdSkNaiyouParam.getSyoruiukeymd(),
        //                    pCheckKdSkNaiyouParam.getSuketorihouhoukbn(),
        //                    pCheckKdSkNaiyouParam.getNstkhukaumukbn(),
        //                    pCheckKdSkNaiyouParam.getNksyukbn(),
        //                    pCheckKdSkNaiyouParam.getNknshry(),
        //                    pCheckKdSkNaiyouParam.getBnshrkaisuu(),
        //                    pCheckKdSkNaiyouParam.getNkkknjyutougk(),
        //                    pCheckKdSkNaiyouParam.getNkhaitoukinuketorihoukbn(),
        //                    pCheckKdSkNaiyouParam.getSyougaikoteiymd(),
        //                    pCheckKdSkNaiyouParam.getSkkihon().getSeikyuusyubetu(),
        //                    siKykKihon, chkKekkaBeanLst);
        //        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getHassoukbncheck())) {
            ChkSubhassoKbn chkSubhassoKbn = SWAKInjector.getInstance(ChkSubhassoKbn.class);
            chkSubhassoKbn.exec(
                C_Tkhukaumu.NONE,
                pCheckKdSkNaiyouParam.getShrdtlsyooutkbn(),
                pCheckKdSkNaiyouParam.getHassoukbn(),
                siKykKihon, chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getHonninkaknincheck())) {
            ChkSubSyuhiYou chkSubSyuhiYou = SWAKInjector.getInstance(ChkSubSyuhiYou.class);
            chkSubSyuhiYou.exec(
                pCheckKdSkNaiyouParam.getSkkihon(), chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getKijyunymdcheck())) {
            ChkSubKijyunYmd chkSubKijyunYmd = SWAKInjector.getInstance(ChkSubKijyunYmd.class);
            chkSubKijyunYmd.exec(
                pCheckKdSkNaiyouParam.getSyoruiukeymd(),
                pCheckKdSkNaiyouParam.getSyougaikoteiymd(),
                pCheckKdSkNaiyouParam.getHubikanryouymd(),
                siKykKihon, chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getSyoumetucheck())) {
            ChkSubSyoumetu chkSubSyoumetu = SWAKInjector.getInstance(ChkSubSyoumetu.class);
            chkSubSyoumetu.exec(
                siKykKihon, chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getDoujisksyoricheck())) {
            ChkSubDoujiSeikyuuSyori chkSubDoujiSeikyuuSyori = SWAKInjector.getInstance(ChkSubDoujiSeikyuuSyori.class);
            chkSubDoujiSeikyuuSyori.exec(
                pCheckKdSkNaiyouParam.getSkkihon(),
                siKykKihon, chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getKhsyoricheck())) {
            ChkSubKhSyorityuu chkSubKhSyorityuu = SWAKInjector.getInstance(ChkSubKhSyorityuu.class);
            chkSubKhSyorityuu.exec(
                siKykKihon, chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getSknnkaisiymdcheck())) {
            ChkSubSknnKaisiYmd chkSubSknnKaisiYmd = SWAKInjector.getInstance(ChkSubSknnKaisiYmd.class);
            for (JT_SiKykSyouhn siKykSyouhnTemp : siKykKihon.getSiKykSyouhns()) {
                chkSubSknnKaisiYmd.exec(
                    pCheckKdSkNaiyouParam.getSyougaikoteiymd(),
                    siKykKihon.getHksknnkaisiymd(),
                    siKykSyouhnTemp, chkKekkaBeanLst);
            }
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getHknkkncheck())) {
            ChkSubHknKkn chkSubHknKkn = SWAKInjector.getInstance(ChkSubHknKkn.class);
            chkSubHknKkn.exec(
                pCheckKdSkNaiyouParam.getSyougaikoteiymd(),
                siKykSyouhn, chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getTtdktyuuicheck())) {
            ChkSubTtdktyuui chkSubTtdktyuui = SWAKInjector.getInstance(ChkSubTtdktyuui.class);
            chkSubTtdktyuui.exec(
                siKykKihon, chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getSinsatyuuicheck())) {
            ChkSubSinsaTyuui chkSubSinsaTyuui = SWAKInjector.getInstance(ChkSubSinsaTyuui.class);
            chkSubSinsaTyuui.exec(
                pCheckKdSkNaiyouParam.getSyono(), chkKekkaBeanLst);
        }

        if (chkKekkaBeanLst.size() != 0) {
            SiSKNaiyouChkkekkaSettei siSKNaiyouChkkekkaSettei = SWAKInjector
                .getInstance(SiSKNaiyouChkkekkaSettei.class);
            siSKNaiyouChkkekkaSettei.exec(
                pCheckKdSkNaiyouParam.getSkkihon().getSeikyuusyubetu(),
                pYobidasimotoKinouId,
                pSikinouModeIdKbn,
                null, chkKdSbKekka,
                null, chkKekkaBeanLst);
        }

        chkKekkaBeanLst = new ArrayList<>();

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getSateisknnkaisiymdcheck())) {
            ChkSubSknnKaisiYmdSatei chkSubSknnKaisiYmdSatei = SWAKInjector.getInstance(ChkSubSknnKaisiYmdSatei.class);

            for (JT_SiKykSyouhn siKykSyouhnTemp : siKykKihon.getSiKykSyouhns()) {
                chkSubSknnKaisiYmdSatei.exec(
                    pCheckKdSkNaiyouParam.getSyougaikoteiymd(),
                    siKykSyouhnTemp, chkKekkaBeanLst);

                if (chkKekkaBeanLst.size() != 0) {
                    if (C_SKNaiyouChkKbn.SATEICHK_SKNNKAISIYMD.eq(
                        chkKekkaBeanLst.get(chkKekkaBeanLst.size() - 1)
                        .getSKNaiyouChkKbn())) {
                        break;
                    }
                }
            }
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getSateigengkcheck())) {
            ChkSubGengaku chkSubGengaku = SWAKInjector.getInstance(ChkSubGengaku.class);
            chkSubGengaku.exec(
                siKykKihon, chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getSateimeigihnkcheck())) {
            ChkSubMeigihenkou chkSubMeigihenkou = SWAKInjector.getInstance(ChkSubMeigihenkou.class);
            chkSubMeigihenkou.exec(
                pCheckKdSkNaiyouParam.getSyougaikoteiymd(),
                pCheckKdSkNaiyouParam.getSkkihon().getSeikyuusyubetu(),
                C_YouhiKbn.HUYOU,
                siKykKihon, chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getSateistknsetcheck())) {
            ChkSubStknset chkSubStknset = SWAKInjector.getInstance(ChkSubStknset.class);
            chkSubStknset.exec(
                siKykKihon, chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getSateihasantosancheck())) {
            ChkSubHasanTousan chkSubHasanTousan = SWAKInjector.getInstance(ChkSubHasanTousan.class);
            chkSubHasanTousan.exec(
                siKykKihon, chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getSateisasiosaecheck())) {
            ChkSubSasiosae chkSubSasiosae = SWAKInjector.getInstance(ChkSubSasiosae.class);
            chkSubSasiosae.exec(
                siKykKihon, chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getSateisousasyoukaicheck())) {
            ChkSubSousasyoukai chkSubSousasyoukai = SWAKInjector.getInstance(ChkSubSousasyoukai.class);
            chkSubSousasyoukai.exec(
                siKykKihon, chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getSateikaigaicheck())) {
            ChkSubKaigai chkSubKaigai = SWAKInjector.getInstance(ChkSubKaigai.class);
            chkSubKaigai.exec(
                pCheckKdSkNaiyouParam.getSateikakkaigaikbn(),
                chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getSateimrinfocheck())) {
            ChkSubMrInfo chkSubMrInfo = SWAKInjector.getInstance(ChkSubMrInfo.class);
            chkSubMrInfo.exec(
                siKykKihon, chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getSateihigaitoucheck())) {
            ChkSubHigaitou chkSubHigaitou = SWAKInjector.getInstance(ChkSubHigaitou.class);
            chkSubHigaitou.exec(
                pCheckKdSkNaiyouParam.getSkkihon(),
                chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getSateihnsycheck())) {
            ChkSubHansya chkSubHansya = SWAKInjector.getInstance(ChkSubHansya.class);
            chkSubHansya.exec(
                C_SeikyuuSyubetu.SB,
                pCheckKdSkNaiyouParam.getSeikyuusyakbn(),
                pCheckKdSkNaiyouParam.getSeikyuusyanmkn(),
                pCheckKdSkNaiyouParam.getSeikyuusyanmkj(),
                pCheckKdSkNaiyouParam.getSeikyuusyaseiymd(),
                pCheckKdSkNaiyouParam.getTsinyno(),
                chkKekkaBeanLst);
        }

        if (chkKekkaBeanLst.size() != 0) {
            SiSateiKmkChkkekkaSettei siSateiKmkChkkekkaSettei = SWAKInjector
                .getInstance(SiSateiKmkChkkekkaSettei.class);
            siSateiKmkChkkekkaSettei.exec(
                pCheckKdSkNaiyouParam.getSkkihon().getSeikyuusyubetu(),
                pYobidasimotoKinouId,
                pSikinouModeIdKbn,
                null,
                chkKdSbKekka,
                chkKekkaBeanLst);
        }

        if (chkKdSbKekka.getErrorMessageCollector().exists()) {
            chkKdSbKekka.setSkNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn.ERROR);
        }
        else {
            if (chkKdSbKekka.getWarningMessageList() != null
                && chkKdSbKekka.getWarningMessageList().size() != 0) {
                chkKdSbKekka.setSkNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn.WARNING);
            } else {
                chkKdSbKekka.setSkNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn.SEIJYOU);
            }
        }*/

        logger.debug("△ 請求内容チェックメイン（高度障害） 終了");

        return chkKdSbKekka;

    }
}
