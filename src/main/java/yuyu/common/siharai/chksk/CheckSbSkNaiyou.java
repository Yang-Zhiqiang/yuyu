package yuyu.common.siharai.chksk;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiKekkaBean;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiMq;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiYokenBean;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuPrm;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Hkuktsyu;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_MQSyoukaiErrorKbn;
import yuyu.def.classification.C_MrsignalhanteigyoumuKbn;
import yuyu.def.classification.C_PalSyoukaiJissiumuKbn;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SKNaiyouChkkekkaKbn;
import yuyu.def.classification.C_SakuintsnSyoukaiKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.classification.C_SiharaiTuukaKbn;
import yuyu.def.classification.C_SikinouModeIdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.JM_Kyuuhu;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.db.entity.JT_SiUkt;
import yuyu.def.siharai.manager.SiharaiDomManager;

/**
 * 保険金給付金支払 請求内容チェック 請求内容チェックメイン（死亡）
 */
public class CheckSbSkNaiyou {

    @Inject
    private static Logger logger;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private BizDomManager bizDomManager;

    private BzSakuinTsnSyoukaiKekkaBean bzSakuinTsnSyoukaiKekkaBean;

    public CheckSbSkNaiyou() {
        super();
    }

    public CheckSbSkNaiyouKekkaBean exec(CheckSbSkNaiyouParam pCheckSbSkNaiyouParam, String pYobidasimotoKinouId,
        C_SikinouModeIdKbn pSikinouModeIdKbn) {

        logger.debug("▽ 請求内容チェックメイン（死亡） 開始");


        if (pCheckSbSkNaiyouParam == null) {

            throw new BizAppException(MessageId.EJS1005, "pCheckSbSkNaiyouParam");
        }

        CheckSbSkNaiyouKekkaBean chkSbKekka = SWAKInjector.getInstance(CheckSbSkNaiyouKekkaBean.class);


        KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);
        KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);
        keiyakuPrm.setSyono(pCheckSbSkNaiyouParam.getSyono());
        keiyakuInfoSyutoku.getInfos(keiyakuPrm);
        List<JT_SiKykKihon> siKykKihonList = keiyakuInfoSyutoku.getKykKihons();
        JT_SiKykKihon siKykKihon = siKykKihonList.get(0);

        if (siKykKihon == null) {
            throw new BizAppException(MessageId.EBS0004, "JT_SiKykKihon", "syono", pCheckSbSkNaiyouParam.getSyono());
        }


        JM_Kyuuhu kyuuhuCheck = new JM_Kyuuhu();

        kyuuhuCheck.setSeikyuusyainfocheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSinkensyainfocheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSouhusakiinfocheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSoukinsakiinfocheck(C_UmuKbn.NONE);
        kyuuhuCheck.setUketorihouhoucheck(C_UmuKbn.NONE);
        kyuuhuCheck.setNkseikyuucheck(C_UmuKbn.NONE);
        kyuuhuCheck.setHassoukbncheck(C_UmuKbn.NONE);
        kyuuhuCheck.setHonninkaknincheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSaigaigtkanouseicheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSaikeninfocheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSaisateicheck(C_UmuKbn.NONE);
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
        kyuuhuCheck.setSateisaikenkaiyakumcheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSateihasantosancheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSateisasiosaecheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSateisousasyoukaicheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSateihusyousicheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSateikaigaisbcheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSateikaigaicheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSateimrinfocheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSateihigaitoucheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSateihnsycheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSateiseikyuusyoruicheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSateisaigaigtkanouseicheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSateisaisateicheck(C_UmuKbn.NONE);
        kyuuhuCheck.setMrfkouzatratkicheck(C_UmuKbn.NONE);
        kyuuhuCheck.setKeiyakusyahnkcheck(C_UmuKbn.NONE);
        kyuuhuCheck.setDskaiyakusyoricheck(C_UmuKbn.NONE);
        kyuuhuCheck.setKykymdcheck(C_UmuKbn.NONE);
        kyuuhuCheck.setEndthnkymdcheck(C_UmuKbn.NONE);
        kyuuhuCheck.setHrmbrcheck(C_UmuKbn.NONE);
        kyuuhuCheck.setSateisgsbjisatumensekicheck(C_UmuKbn.NONE);
        kyuuhuCheck.setHaitoukincheck(C_UmuKbn.NONE);
        kyuuhuCheck.setTmttknjyoutaicheck(C_UmuKbn.NONE);

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

                if (C_SeikyuuSyubetu.SB.eq(kyuuhu.getSeikyuusyubetu())) {

                    if (C_UmuKbn.ARI.eq(kyuuhu.getUketorihouhoucheck())) {
                        kyuuhuCheck.setUketorihouhoucheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getNkseikyuucheck())) {
                        kyuuhuCheck.setNkseikyuucheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getHassoukbncheck())) {
                        kyuuhuCheck.setHassoukbncheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getHonninkaknincheck())) {
                        kyuuhuCheck.setHonninkaknincheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getSaigaigtkanouseicheck())) {
                        kyuuhuCheck.setSaigaigtkanouseicheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getSaikeninfocheck())) {
                        kyuuhuCheck.setSaikeninfocheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getSaisateicheck())) {
                        kyuuhuCheck.setSaisateicheck(C_UmuKbn.ARI);
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

                    if (C_UmuKbn.ARI.eq(kyuuhu.getSateisaikenkaiyakumcheck())) {
                        kyuuhuCheck.setSateisaikenkaiyakumcheck(C_UmuKbn.ARI);
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

                    if (C_UmuKbn.ARI.eq(kyuuhu.getSateikaigaicheck())) {
                        kyuuhuCheck.setSateikaigaicheck(C_UmuKbn.ARI);
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

                    if (C_UmuKbn.ARI.eq(kyuuhu.getSateisaigaigtkanouseicheck())) {
                        kyuuhuCheck.setSateisaigaigtkanouseicheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getSateisaisateicheck())) {
                        kyuuhuCheck.setSateisaisateicheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getMrfkouzatratkicheck())) {
                        kyuuhuCheck.setMrfkouzatratkicheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getKeiyakusyahnkcheck())) {
                        kyuuhuCheck.setKeiyakusyahnkcheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getDskaiyakusyoricheck())) {
                        kyuuhuCheck.setDskaiyakusyoricheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getKykymdcheck())) {
                        kyuuhuCheck.setKykymdcheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getEndthnkymdcheck())) {
                        kyuuhuCheck.setEndthnkymdcheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getHrmbrcheck())) {
                        kyuuhuCheck.setHrmbrcheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getSateisgsbjisatumensekicheck())) {
                        kyuuhuCheck.setSateisgsbjisatumensekicheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getHaitoukincheck())) {
                        kyuuhuCheck.setHaitoukincheck(C_UmuKbn.ARI);
                    }

                    if (C_UmuKbn.ARI.eq(kyuuhu.getTmttknjyoutaicheck())) {
                        kyuuhuCheck.setTmttknjyoutaicheck(C_UmuKbn.ARI);
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
        JM_SiSyouhnZokusei siSyouhnZokuseiSyu = siSyouhnZokuseiSyuLst.get(0);

        for (JM_SiSyouhnZokusei SiSyouhnZokuseiSyu : siSyouhnZokuseiSyuLst) {
            JM_Kyuuhu kyuuhu = siharaiDomManager.getKyuuhu(SiSyouhnZokuseiSyu.getKyuuhucd());
            if (C_SeikyuuSyubetu.SB.eq(kyuuhu.getSeikyuusyubetu())) {
                if (C_UmuKbn.ARI.eq(kyuuhu.getHknkkncheck())) {
                    kyuuhuCheck.setHknkkncheck(C_UmuKbn.ARI);
                }
            }
        }

        BM_SyouhnZokusei syouhnZokuseiSyu = bizDomManager.getSyouhnZokusei(siKykSyouhn.getSyouhncd(),siKykSyouhn.getSyouhnsdno());
        if (syouhnZokuseiSyu == null) {
            throw new BizAppException(MessageId.EBS0005, "BM_SyouhnZokusei", "syouhnCd", siKykSyouhn.getSyouhncd(), "syouhnsdNo", siKykSyouhn.getSyouhnsdno().toString());
        }

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        ChkSubSksyaInfo chkSubSksyaInfo = SWAKInjector.getInstance(ChkSubSksyaInfo.class);
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(pCheckSbSkNaiyouParam.getSeikyuusyakbn(),
            pCheckSbSkNaiyouParam.getSeikyuusyanmkn(), pCheckSbSkNaiyouParam.getSeikyuusyanmkj(),
            pCheckSbSkNaiyouParam.getSeikyuusyaseiymd(), pCheckSbSkNaiyouParam.getSeikyuusyasei(), C_SeikyuuSyubetu.SB,
            siKykKihon, chkKekkaBeanLst);

        bzSakuinTsnSyoukaiKekkaBean = null;
        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getSateihnsycheck())) {
            if (!C_SeikyuusyaKbn.UKTHONNIN.eq(pCheckSbSkNaiyouParam.getSeikyuusyakbn())
                && !C_SeikyuusyaKbn.KYKDAIRININ.eq(pCheckSbSkNaiyouParam.getSeikyuusyakbn())
                && !BizUtil.isBlank(pCheckSbSkNaiyouParam.getSeikyuusyanmkn()) && isCheckMeigininNmKana) {
                BzSakuinTsnSyoukaiMq bzSakuinTsnSyoukaiMq = SWAKInjector.getInstance(BzSakuinTsnSyoukaiMq.class);
                BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = SWAKInjector
                    .getInstance(BzSakuinTsnSyoukaiYokenBean.class);

                bzSakuinTsnSyoukaiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.BLNK);
                bzSakuinTsnSyoukaiYokenBean.setSkintsnsyoukaikbn(C_SakuintsnSyoukaiKbn.MEIGISYOUKAI);
                bzSakuinTsnSyoukaiYokenBean.setTaisyounmkn(pCheckSbSkNaiyouParam.getSeikyuusyanmkn());
                bzSakuinTsnSyoukaiYokenBean.setTaisyounmkj(pCheckSbSkNaiyouParam.getSeikyuusyanmkj());
                bzSakuinTsnSyoukaiYokenBean.setTaisyouseiymd(pCheckSbSkNaiyouParam.getSeikyuusyaseiymd());
                bzSakuinTsnSyoukaiYokenBean.setTaisyouyno(pCheckSbSkNaiyouParam.getTsinyno());
                bzSakuinTsnSyoukaiYokenBean.setSkininfosyoukaiyhkbn(C_YouhiKbn.HUYOU);
                bzSakuinTsnSyoukaiYokenBean.setMrsignalsyoukaiyhkbn(C_YouhiKbn.YOU);
                bzSakuinTsnSyoukaiYokenBean.setMrsignalhanteigyoumukbn(C_MrsignalhanteigyoumuKbn.OTHER);
                bzSakuinTsnSyoukaiYokenBean.setTsngksyoukaiyhkbn(C_YouhiKbn.HUYOU);
                bzSakuinTsnSyoukaiYokenBean.setKykdrtentsnsssyoukaiyhkbn(C_YouhiKbn.HUYOU);
                bzSakuinTsnSyoukaiYokenBean.setMossakuseikahisyoukaiyhkbn(C_YouhiKbn.HUYOU);
                bzSakuinTsnSyoukaiYokenBean.setHndketyhsyoukaiyhkbn(C_YouhiKbn.HUYOU);

                BzSakuinTsnSyoukaiKekkaBean wkBzSakuinTsnSyoukaiKekkaBean = bzSakuinTsnSyoukaiMq
                    .exec(bzSakuinTsnSyoukaiYokenBean);

                if (C_MQSyorikekkaKbn.ERROR.eq(wkBzSakuinTsnSyoukaiKekkaBean.getMqsyorikekkakbn())) {
                    chkSbKekka.getWarningMessageList().add(MessageId.WJA1057);
                    chkSbKekka.getWarningMessageList().add(MessageUtil.getMessage(MessageId.IJW1085));
                    chkSbKekka.getWarningMessageList().add("");
                    chkSbKekka.getWarningMessageList().add("");
                    chkSbKekka.getWarningMessageList().add("");
                    chkSbKekka.getWarningMessageList().add("");

                    chkSbKekka.setSateiKaisouYouhiKbn(C_YouhiKbn.YOU);
                }

                if (C_MQSyorikekkaKbn.SEIJYOU.eq(wkBzSakuinTsnSyoukaiKekkaBean.getMqsyorikekkakbn())
                    && C_PalSyoukaiJissiumuKbn.NONE.eq(wkBzSakuinTsnSyoukaiKekkaBean.getPalsyoukaijissiumukbn())) {
                    chkSbKekka.getWarningMessageList().add(MessageId.WJA1058);
                    chkSbKekka.getWarningMessageList().add(MessageUtil.getMessage(MessageId.IJW1085));
                    chkSbKekka.getWarningMessageList().add("");
                    chkSbKekka.getWarningMessageList().add("");
                    chkSbKekka.getWarningMessageList().add("");
                    chkSbKekka.getWarningMessageList().add("");

                    chkSbKekka.setSateiKaisouYouhiKbn(C_YouhiKbn.YOU);
                }

                if (C_MQSyoukaiErrorKbn.SYOUKAIERROR.eq(wkBzSakuinTsnSyoukaiKekkaBean.getSinsntkhnsysyoukaierrkbn())) {
                    chkSbKekka.getWarningMessageList().add(MessageId.WJA1059);
                    chkSbKekka.getWarningMessageList().add(MessageUtil.getMessage(MessageId.IJW1085));
                    chkSbKekka.getWarningMessageList().add("");
                    chkSbKekka.getWarningMessageList().add("");
                    chkSbKekka.getWarningMessageList().add("");
                    chkSbKekka.getWarningMessageList().add("");

                    chkSbKekka.setSateiKaisouYouhiKbn(C_YouhiKbn.YOU);
                }

                if (C_MQSyorikekkaKbn.SEIJYOU.eq(wkBzSakuinTsnSyoukaiKekkaBean.getMqsyorikekkakbn())
                    && C_PalSyoukaiJissiumuKbn.ARI.eq(wkBzSakuinTsnSyoukaiKekkaBean.getPalsyoukaijissiumukbn())
                    && C_MQSyoukaiErrorKbn.SYOUKAIOK.eq(wkBzSakuinTsnSyoukaiKekkaBean.getSinsntkhnsysyoukaierrkbn())) {
                    bzSakuinTsnSyoukaiKekkaBean = wkBzSakuinTsnSyoukaiKekkaBean;
                }
            }
        }


        ChkSubSinkensyaInfo chkSubSinkensyaInfo = SWAKInjector.getInstance(ChkSubSinkensyaInfo.class);
        chkSubSinkensyaInfo.exec(
            pCheckSbSkNaiyouParam.getSkskknnmkn(),
            pCheckSbSkNaiyouParam.getSkskknnmkj(),
            pCheckSbSkNaiyouParam.getSkskknsyubetu(),
            chkKekkaBeanLst);

        ChkSubShskInfo chkSubShskInfo = SWAKInjector.getInstance(ChkSubShskInfo.class);
        chkSubShskInfo.exec(
            pCheckSbSkNaiyouParam.getSouhusakikbn(),
            pCheckSbSkNaiyouParam.getTsinyno(),
            pCheckSbSkNaiyouParam.getTsinadr1kj(),
            pCheckSbSkNaiyouParam.getTsinadr2kj(),
            pCheckSbSkNaiyouParam.getTsinadr3kj(),
            pCheckSbSkNaiyouParam.getTsintelno(),
            siKykKihon, chkKekkaBeanLst);

        ChkSubSksInfo chkSubSksInfo = SWAKInjector.getInstance(ChkSubSksInfo.class);
        C_Tuukasyu tuukasyu;

        if (C_Tuukasyu.JPY.eq(siKykSyouhn.getKyktuukasyu())) {
            tuukasyu = C_Tuukasyu.JPY;
        }
        else {
            if (C_SiharaiTuukaKbn.YENSIHARAI.eq(pCheckSbSkNaiyouParam.getSiharaituukakbn())) {
                tuukasyu = C_Tuukasyu.JPY;
            }
            else {
                tuukasyu = siKykSyouhn.getKyktuukasyu();
            }
        }

        String seikyuusyanmkn = "";
        int count = 0;
        if (C_SeikyuusyaKbn.UKTHONNIN.eq(pCheckSbSkNaiyouParam.getSeikyuusyakbn())) {
            for (JT_SiUkt siUkt : siKykKihon.getSiUkts()) {
                if (C_Hkuktsyu.SBHKKUKT.eq(siUkt.getHkuktsyu()) || C_Hkuktsyu.SBKYFKUKT.eq(siUkt.getHkuktsyu())) {
                    count++;
                    if (count > 1) {
                        seikyuusyanmkn = "";
                        break;
                    }
                    seikyuusyanmkn = siUkt.getUktnmkn();
                }
            }
        }
        else {
            seikyuusyanmkn = pCheckSbSkNaiyouParam.getSeikyuusyanmkn();
        }

        chkSubSksInfo.exec(
            pCheckSbSkNaiyouParam.getInputshrhousiteikbn(),
            pCheckSbSkNaiyouParam.getBankcd(),
            pCheckSbSkNaiyouParam.getSitencd(),
            pCheckSbSkNaiyouParam.getYokinkbn(),
            pCheckSbSkNaiyouParam.getKouzano(),
            pCheckSbSkNaiyouParam.getKzdoukbn(),
            pCheckSbSkNaiyouParam.getKzmeiginmkn(),
            tuukasyu, seikyuusyanmkn, pCheckSbSkNaiyouParam.getSeikyuusyakbn(), chkKekkaBeanLst);

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getUketorihouhoucheck())) {
            ChkSubUketoriHouhou chkSubUketoriHouhou = SWAKInjector.getInstance(ChkSubUketoriHouhou.class);
            chkSubUketoriHouhou.exec(
                pCheckSbSkNaiyouParam.getSuketorihouhoukbn(),
                chkKekkaBeanLst);
        }

        //        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getNkseikyuucheck())) {
        //            ChkSubNenkinSk chkSubNenkinSk = SWAKInjector.getInstance(ChkSubNenkinSk.class);
        //                                chkSubNenkinSk.exec(
        //                                    pCheckSbSkNaiyouParam.getSyoruiukeymd(),
        //                                    pCheckSbSkNaiyouParam.getSuketorihouhoukbn(),
        //                                    pCheckSbSkNaiyouParam.getNstkhukaumukbn(),
        //                                    pCheckSbSkNaiyouParam.getNksyukbn(),
        //                                    pCheckSbSkNaiyouParam.getNknshry(),
        //                                    pCheckSbSkNaiyouParam.getBnshrkaisuu(),
        //                                    pCheckSbSkNaiyouParam.getNkkknjyutougk(),
        //                                    pCheckSbSkNaiyouParam.getNkhaitoukinuketorihoukbn(),
        //                                    pCheckSbSkNaiyouParam.getSibouymd(),
        //                                    pCheckSbSkNaiyouParam.getSkkihon().getSeikyuusyubetu(),
        //                                    siKykKihon, chkKekkaBeanLst);
        //        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getHassoukbncheck())) {
            ChkSubhassoKbn chkSubhassoKbn = SWAKInjector.getInstance(ChkSubhassoKbn.class);
            chkSubhassoKbn.exec(
                pCheckSbSkNaiyouParam.getSaisateikbn(),
                pCheckSbSkNaiyouParam.getSaikennmkj(),
                pCheckSbSkNaiyouParam.getSaikennyno(),
                pCheckSbSkNaiyouParam.getSaikenadr1kj(),
                C_Tkhukaumu.NONE,
                pCheckSbSkNaiyouParam.getShrdtlsyooutkbn(),
                pCheckSbSkNaiyouParam.getHassoukbn(),
                pCheckSbSkNaiyouParam.getInputshrhousiteikbn(),
                siKykKihon, chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getHonninkaknincheck())) {
            ChkSubHonninkakunin chkSubHonninkakunin = SWAKInjector.getInstance(ChkSubHonninkakunin.class);
            chkSubHonninkakunin.exec(
                pCheckSbSkNaiyouParam.getSihonninkakninkbn(),
                pCheckSbSkNaiyouParam.getSuketorihouhoukbn(),
                chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getSaigaigtkanouseicheck())) {
            ChkSubSaigaiGaitou chkSubSaigaiGaitou = SWAKInjector.getInstance(ChkSubSaigaiGaitou.class);
            chkSubSaigaiGaitou.exec(
                pCheckSbSkNaiyouParam.getSibouymd(),
                pCheckSbSkNaiyouParam.getByoumeitourokunolist(),
                pCheckSbSkNaiyouParam.getGeninkbn(),
                pCheckSbSkNaiyouParam.getSateikaksaigaikanouseikbn(),
                syouhnZokuseiSyu,
                siKykSyouhn,
                pCheckSbSkNaiyouParam.getSkkihon(),
                false,
                chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getSaikeninfocheck())) {
            ChkSubSaikenInfo chkSubSaikenInfo = SWAKInjector.getInstance(ChkSubSaikenInfo.class);
            chkSubSaikenInfo.exec(
                pCheckSbSkNaiyouParam.getSaikennmkj(),
                pCheckSbSkNaiyouParam.getSaikennyno(),
                pCheckSbSkNaiyouParam.getSaikenadr1kj(),
                pCheckSbSkNaiyouParam.getSaikenadr2kj(),
                pCheckSbSkNaiyouParam.getSaikenadr3kj(),
                siKykKihon, chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getSaisateicheck())) {
            ChkSubSaisatei chkSubSaisatei = SWAKInjector.getInstance(ChkSubSaisatei.class);
            chkSubSaisatei.exec(
                pCheckSbSkNaiyouParam.getSaisateikbn(),
                chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getKijyunymdcheck())) {
            ChkSubKijyunYmd chkSubKijyunYmd = SWAKInjector.getInstance(ChkSubKijyunYmd.class);
            chkSubKijyunYmd.exec(
                pCheckSbSkNaiyouParam.getSyoruiukeymd(),
                pCheckSbSkNaiyouParam.getSibouymd(),
                pCheckSbSkNaiyouParam.getHubikanryouymd(),
                pCheckSbSkNaiyouParam.getSkno(),
                pCheckSbSkNaiyouParam.getSyono(),
                siKykKihon, chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getGeninkbncheck())) {
            ChkSubGeninKbn chkSubGeninKbn = SWAKInjector.getInstance(ChkSubGeninKbn.class);
            chkSubGeninKbn.exec(
                pCheckSbSkNaiyouParam.getGeninkbn(),
                pCheckSbSkNaiyouParam.getByoumeitourokunolist(),
                chkKekkaBeanLst);
        }


        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getSyoumetucheck())) {
            ChkSubSyoumetu chkSubSyoumetu = SWAKInjector.getInstance(ChkSubSyoumetu.class);
            chkSubSyoumetu.exec(
                pCheckSbSkNaiyouParam.getSaisateikbn(),
                siKykKihon, chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getDoujisksyoricheck())
            && pCheckSbSkNaiyouParam.getSkkihon().getSkno() != null) {
            ChkSubDoujiSeikyuuSyori chkSubDoujiSeikyuuSyori = SWAKInjector.getInstance(ChkSubDoujiSeikyuuSyori.class);
            chkSubDoujiSeikyuuSyori.exec(
                pCheckSbSkNaiyouParam.getSkkihon(),
                siKykKihon, chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getKhsyoricheck())) {
            ChkSubKhSyorityuu chkSubKhSyorityuu = SWAKInjector.getInstance(ChkSubKhSyorityuu.class);
            chkSubKhSyorityuu.exec(
                siKykKihon, pYobidasimotoKinouId, chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getSknnkaisiymdcheck())) {
            ChkSubSknnKaisiYmd chkSubSknnKaisiYmd = SWAKInjector.getInstance(ChkSubSknnKaisiYmd.class);
            for (JT_SiKykSyouhn siKykSyouhnTemp : siKykKihon.getSiKykSyouhns()) {
                chkSubSknnKaisiYmd.exec(
                    pCheckSbSkNaiyouParam.getSibouymd(),
                    siKykKihon.getHksknnkaisiymd(),
                    siKykSyouhnTemp, chkKekkaBeanLst);
            }
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getHknkkncheck())) {
            ChkSubHknKkn chkSubHknKkn = SWAKInjector.getInstance(ChkSubHknKkn.class);
            chkSubHknKkn.exec(
                pCheckSbSkNaiyouParam.getSibouymd(),
                siKykSyouhn, chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getPhrkyuuyokkncheck())) {
            ChkSubPHrkmYuuyokkn chkSubPHrkmYuuyokkn = SWAKInjector.getInstance(ChkSubPHrkmYuuyokkn.class);
            chkSubPHrkmYuuyokkn.exec(
                pCheckSbSkNaiyouParam.getSibouymd(),
                pCheckSbSkNaiyouParam.getSyono(),
                chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getTtdktyuuicheck())) {
            ChkSubTtdktyuui chkSubTtdktyuui = SWAKInjector.getInstance(ChkSubTtdktyuui.class);
            chkSubTtdktyuui.exec(
                siKykKihon, chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getUktcheck())) {
            ChkSubUketorinin chkSubUketorinin = SWAKInjector.getInstance(ChkSubUketorinin.class);
            chkSubUketorinin.exec(
                pCheckSbSkNaiyouParam.getSeikyuusyakbn(),
                pCheckSbSkNaiyouParam.getSeikyuusyanmkn(),
                siKykKihon, chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getSinsatyuuicheck())) {
            ChkSubSinsaTyuui chkSubSinsaTyuui = SWAKInjector.getInstance(ChkSubSinsaTyuui.class);
            chkSubSinsaTyuui.exec(
                pCheckSbSkNaiyouParam.getSyono(), chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getMrfkouzatratkicheck())) {
            ChkSubMRFKouzaTratki ChkSubMRFKouzaTratki = SWAKInjector.getInstance(ChkSubMRFKouzaTratki.class);
            ChkSubMRFKouzaTratki.exec(
                siKykKihon.getOyadrtencd(), chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getKeiyakusyahnkcheck())) {
            ChkSubKeiyakusyaHnk ChkSubKeiyakusyaHnk = SWAKInjector.getInstance(ChkSubKeiyakusyaHnk.class);
            ChkSubKeiyakusyaHnk.exec(
                siKykKihon.getKykhnkkaisuu(), chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getDskaiyakusyoricheck())) {
            ChkSubDsKaiykSyori chkSubKeiyakusyaHnk = SWAKInjector.getInstance(ChkSubDsKaiykSyori.class);
            chkSubKeiyakusyaHnk.exec(pCheckSbSkNaiyouParam.getSyono(), chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getKykymdcheck())) {
            ChkSubKykYmd chkSubKykYmd = SWAKInjector.getInstance(ChkSubKykYmd.class);
            chkSubKykYmd.exec(pCheckSbSkNaiyouParam.getSibouymd(), siKykSyouhn.getKykymd(), chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getHaitoukincheck())) {
            ChkSubD chkSubD = SWAKInjector.getInstance(ChkSubD.class);
            chkSubD.exec(pCheckSbSkNaiyouParam.getSibouymd(), pCheckSbSkNaiyouParam.getSyono(), chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getTmttknjyoutaicheck())) {
            ChkSubTmttknJyoutai chkSubTmttknJyoutai = SWAKInjector.getInstance(ChkSubTmttknJyoutai.class);
            chkSubTmttknJyoutai.exec(pCheckSbSkNaiyouParam.getSibouymd(), pCheckSbSkNaiyouParam.getSyono(),
                siKykSyouhn.getKykymd(), siKykSyouhn.getTmttknitenymd(), chkKekkaBeanLst);
        }


        if (siKykSyouhn.getYendthnkymd() != null) {

            if (C_UmuKbn.ARI.eq(kyuuhuCheck.getEndthnkymdcheck())) {
                ChkSubEndtHenkouYmd chkSubEndtHenkouYmd = SWAKInjector.getInstance(ChkSubEndtHenkouYmd.class);
                chkSubEndtHenkouYmd.exec(pCheckSbSkNaiyouParam.getSibouymd(), siKykSyouhn.getYendthnkymd(),
                    chkKekkaBeanLst);
            }

            if (C_UmuKbn.ARI.eq(kyuuhuCheck.getHrmbrcheck())) {
                ChkSubHnrkinMbr chkSubHnrkinMbr = SWAKInjector.getInstance(ChkSubHnrkinMbr.class);
                chkSubHnrkinMbr.exec(siKykKihon, chkKekkaBeanLst);
            }
        }


        if (chkKekkaBeanLst.size() != 0) {
            SiSKNaiyouChkkekkaSettei siSKNaiyouChkkekkaSettei = SWAKInjector
                .getInstance(SiSKNaiyouChkkekkaSettei.class);
            siSKNaiyouChkkekkaSettei.exec(
                C_SeikyuuSyubetu.SB,
                pYobidasimotoKinouId,
                pSikinouModeIdKbn,
                chkSbKekka,
                null, null, null, chkKekkaBeanLst);
        }


        chkKekkaBeanLst = new ArrayList<>();

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getSateijisatumensekicheck())) {
            ChkSubJisatuMenseki chkSubJisatuMenseki = SWAKInjector.getInstance(ChkSubJisatuMenseki.class);

            for (JT_SiKykSyouhn siKykSyouhnTemp : siKykKihon.getSiKykSyouhns()) {
                chkSubJisatuMenseki.exec(
                    pCheckSbSkNaiyouParam.getSibouymd(),
                    pCheckSbSkNaiyouParam.getGeninkbn(),
                    siKykKihon.getHksknnkaisiymd(),
                    siKykSyouhnTemp, siSyouhnZokuseiSyu, chkKekkaBeanLst);

                if (chkKekkaBeanLst.size() != 0) {
                    if (C_SKNaiyouChkKbn.SATEICHK_JISATUMENSEKI
                        .eq(chkKekkaBeanLst.get(chkKekkaBeanLst.size() - 1)
                            .getSKNaiyouChkKbn())) {
                        break;
                    }
                }
            }
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getSateisknnkaisiymdcheck())) {
            ChkSubSknnKaisiYmdSatei chkSubSknnKaisiYmdSatei = SWAKInjector.getInstance(ChkSubSknnKaisiYmdSatei.class);

            for (JT_SiKykSyouhn siKykSyouhnTemp : siKykKihon.getSiKykSyouhns()) {
                chkSubSknnKaisiYmdSatei.exec(
                    pCheckSbSkNaiyouParam.getSibouymd(),
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

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getSateimeigihnkcheck())
            && pCheckSbSkNaiyouParam.getSkkihon().getSkno() != null) {
            ChkSubMeigihenkou chkSubMeigihenkou = SWAKInjector.getInstance(ChkSubMeigihenkou.class);
            chkSubMeigihenkou.exec(
                pCheckSbSkNaiyouParam.getSibouymd(),
                pCheckSbSkNaiyouParam.getSkkihon().getSeikyuusyubetu(),
                pCheckSbSkNaiyouParam.getSateikakmeigihnkkbn(),
                siKykKihon, chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getSateistknsetcheck())) {
            ChkSubStknset chkSubStknset = SWAKInjector.getInstance(ChkSubStknset.class);
            chkSubStknset.exec(
                siKykKihon, chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getSateisaikenkaiyakumcheck())) {
            ChkSubSaikenKaiykMouside chkSubSaikenKaiykMouside = SWAKInjector.getInstance(ChkSubSaikenKaiykMouside.class);
            chkSubSaikenKaiykMouside.exec(
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

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getSateihusyousicheck())) {
            ChkSubHusyounosi chkSubHusyounosi = SWAKInjector.getInstance(ChkSubHusyounosi.class);
            chkSubHusyounosi.exec(
                pCheckSbSkNaiyouParam.getByoumeitourokunolist(),
                pCheckSbSkNaiyouParam.getGeninkbn(),
                pCheckSbSkNaiyouParam.getSateikakhusyousikbn(),
                chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getSateikaigaisbcheck())) {
            ChkSubKaigaiSb chkSubKaigaiSb = SWAKInjector.getInstance(ChkSubKaigaiSb.class);
            chkSubKaigaiSb.exec(
                pCheckSbSkNaiyouParam.getSateikakkaigaisbkbn(),
                chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getSateihnsycheck())) {
            ChkSubHansya chkSubHansya = SWAKInjector.getInstance(ChkSubHansya.class);
            chkSubHansya.exec(
                C_SeikyuuSyubetu.SB,
                bzSakuinTsnSyoukaiKekkaBean,
                chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getSateiseikyuusyoruicheck())
            && pCheckSbSkNaiyouParam.getSkkihon().getSkno() != null) {
            ChkSubSkSyorui chkSubSkSyorui = SWAKInjector.getInstance(ChkSubSkSyorui.class);
            chkSubSkSyorui.exec(
                pCheckSbSkNaiyouParam.getSkkihon(),
                chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getSateisaigaigtkanouseicheck())) {
            ChkSubSaigaiGaitou chkSubSaigaiGaitou = SWAKInjector.getInstance(ChkSubSaigaiGaitou.class);
            chkSubSaigaiGaitou.exec(
                pCheckSbSkNaiyouParam.getSibouymd(),
                pCheckSbSkNaiyouParam.getByoumeitourokunolist(),
                pCheckSbSkNaiyouParam.getGeninkbn(),
                pCheckSbSkNaiyouParam.getSateikaksaigaikanouseikbn(),
                syouhnZokuseiSyu,
                siKykSyouhn,
                pCheckSbSkNaiyouParam.getSkkihon(),
                true,
                chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getSateisaisateicheck())) {
            ChkSubSaisateiSatei chkSubSaisateiSatei = SWAKInjector.getInstance(ChkSubSaisateiSatei.class);
            chkSubSaisateiSatei.exec(
                pCheckSbSkNaiyouParam.getSaisateikbn(),
                chkKekkaBeanLst);
        }

        if (C_UmuKbn.ARI.eq(kyuuhuCheck.getSateisgsbjisatumensekicheck())) {
            ChkSubSgSbJisatuMenseki chkSubSgSbJisatuMenseki = SWAKInjector.getInstance(ChkSubSgSbJisatuMenseki.class);
            chkSubSgSbJisatuMenseki.exec(
                pCheckSbSkNaiyouParam.getSibouymd(),
                siKykKihon.getHksknnkaisiymd(),
                siKykSyouhn,
                pCheckSbSkNaiyouParam.getGeninkbn(),
                pCheckSbSkNaiyouParam.getByoumeitourokunolist(),
                pCheckSbSkNaiyouParam.getSateikaksaigaikanouseikbn(),
                pCheckSbSkNaiyouParam.getSkkihon(),
                chkKekkaBeanLst);
        }


        if (chkKekkaBeanLst.size() != 0) {
            SiSateiKmkChkkekkaSettei siSateiKmkChkkekkaSettei = SWAKInjector
                .getInstance(SiSateiKmkChkkekkaSettei.class);
            siSateiKmkChkkekkaSettei.exec(
                C_SeikyuuSyubetu.SB,
                pYobidasimotoKinouId,
                pSikinouModeIdKbn,
                chkSbKekka,
                null,
                chkKekkaBeanLst);
        }


        if (chkSbKekka.getErrorMessageCollector().exists()) {
            chkSbKekka.setSkNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn.ERROR);
        }
        else {
            if (chkSbKekka.getWarningMessageList() != null
                && chkSbKekka.getWarningMessageList().size() != 0) {
                chkSbKekka.setSkNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn.WARNING);
            } else {
                chkSbKekka.setSkNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn.SEIJYOU);
            }
        }

        logger.debug("△ 請求内容チェックメイン（死亡） 終了");

        return chkSbKekka;

    }
}
