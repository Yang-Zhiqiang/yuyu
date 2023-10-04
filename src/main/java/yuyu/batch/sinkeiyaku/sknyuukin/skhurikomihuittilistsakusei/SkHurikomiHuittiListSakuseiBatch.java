package yuyu.batch.sinkeiyaku.sknyuukin.skhurikomihuittilistsakusei;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.sinkeiyaku.sknyuukin.skhurikomihuittilistsakusei.dba.SkHurikomiHuittiListSakuseiDao;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.sinkeiyaku.skcommon.SetNyknRnrkhyouYmd;
import yuyu.def.MessageId;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HrkmnykndatarenmotoKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.classification.C_NyuukinHuittiriyuuKbn;
import yuyu.def.classification.C_NyuukinjyoutaiKbn;
import yuyu.def.classification.C_PtratkituukasiteiKbn;
import yuyu.def.classification.C_SosikimasterUmuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TaisyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_GaikaHrkmNyknData;
import yuyu.def.db.entity.HT_HrkmNyknData;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HW_NyuukinJyouhouHuittiWk;
import yuyu.def.sinkeiyaku.bean.report.SkNyuukinjyouhouhuittikakuninBean;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 新契約 入金 振込入金不一致リスト作成
 */
public class SkHurikomiHuittiListSakuseiBatch implements Batch {

    private static final String MEISAITORIKOMIBI_MAE  = "（明細取込日　";

    private static final String MEISAITORIKOMIBI_ATO  = "）";

    private long syoriKensuu = 0;

    private BizDate syoriYmd = null;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private CreateReport createReport;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private SkHurikomiHuittiListSakuseiDao skHurikomiHuittiListSakuseiDao;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }


    @Execute
    @Transactional
    public void execute() {

        syoriYmd = bzBatchParam.getSyoriYmd();
        syoriKensuu = 0;

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, "処理年月日", String.valueOf(syoriYmd)));

        String dairitenKykSosikicd = YuyuSinkeiyakuConfig.getInstance().getDairitenkyksosikicd();
        String jigyouhiCd = YuyuSinkeiyakuConfig.getInstance().getJigyouhicd();

        String kanjiSosikinm = "";
        BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(dairitenKykSosikicd, null);

        if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {

            kanjiSosikinm = ViewReport.editOntyuu(bzGetSosikiDataBean.getKanjisosikinm20());
        }

        C_NyktyhyoutKbn[] nyktyhyOutLst = {C_NyktyhyoutKbn.NONE, C_NyktyhyoutKbn.GAIKADATE};


        try(ExDBResults<HW_NyuukinJyouhouHuittiWk> nyuukinJyouhouHuittiWkList =
            skHurikomiHuittiListSakuseiDao.getNyuukinJyouhouHuittiWksBySyoriYmdNyktyhyoutlst(syoriYmd, nyktyhyOutLst)){

            Iterator<HW_NyuukinJyouhouHuittiWk> iterator = nyuukinJyouhouHuittiWkList.iterator();

            if (iterator.hasNext()) {

                createSkNyuukinjyouhouhuittikakuninBeanSyori(iterator, kanjiSosikinm, jigyouhiCd, C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO);
            }

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), "入金情報不一致確認書"));
        }

        C_NyktyhyoutKbn[] nyktyhyOutLstYen = {C_NyktyhyoutKbn.YENDATE};
        syoriKensuu = 0;

        try(ExDBResults<HW_NyuukinJyouhouHuittiWk> nyuukinJyouhouHuittiWkListYen =
            skHurikomiHuittiListSakuseiDao.getNyuukinJyouhouHuittiWksBySyoriYmdNyktyhyoutlst(syoriYmd, nyktyhyOutLstYen)){

            Iterator<HW_NyuukinJyouhouHuittiWk> iteratorYen = nyuukinJyouhouHuittiWkListYen.iterator();

            if (iteratorYen.hasNext()) {

                createSkNyuukinjyouhouhuittikakuninBeanSyori(iteratorYen, kanjiSosikinm, jigyouhiCd, C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO_YENDT);
            }

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), "入金情報不一致確認書（円建）"));
        }
    }

    private void createSkNyuukinjyouhouhuittikakuninBeanSyori(Iterator<HW_NyuukinJyouhouHuittiWk> pIterator,
        String pKanjiSosikinm, String pJigyouhiCd, C_SyoruiCdKbn pSyoruiCdKbn) {

        String tyouhyouYmd = DateFormatUtil.dateKANJI(syoriYmd);
        Integer pageNo = 0;
        String nykMosno = null;
        HT_SyoriCTL syoriCTL = null;
        HT_MosKihon mosKihon = null;
        HT_MosSyouhn mosSyouhn = null;
        HT_MosDairiten mosDairiten = null;
        String oyaDrtenCd = "";
        String oyaDrtenNm = "";
        String drtenNm = "";
        BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);
        List<BzGetAgInfoBean> bzGetAgInfoBeanList = null;
        String kyknmkn = "";
        String mosYmdSeireki = "";
        String knjyYmdSeireki = "";
        SkNyuukinjyouhouhuittikakuninBean skNyknjyhHuittiKakuninBean = null;
        String mosOyadrtencd = "";
        BizDate knjyYmd = null;
        String tratkiAgCd = "";
        String mosno = "";
        String nyuukinjyoutaiKbn = "";
        BizCurrency mosfstpkei = BizCurrency.valueOf(0);
        C_HrkmnykndatarenmotoKbn hrkmnykndatarenmotoKbn = null;
        HT_HrkmNyknData hrkmnyknData =null;
        HT_GaikaHrkmNyknData gaikahrkmnyknData = null;
        C_Tuukasyu siteituuka = C_Tuukasyu.BLNK;
        SetNyknRnrkhyouYmd setNyknRnrkhyouYmd =  SWAKInjector.getInstance(SetNyknRnrkhyouYmd.class);
        String nyknRnrkhyouYmdSeireki =  "";
        String meisaitrkmymd =  "";
        String aisyoumei = "";
        String seikeijiZenkiZennou = "";
        String phaneiMosno = "";
        String phaneiKyknmkn = "";
        String phaneiOyadytenCd = "";
        String phaneiOyadytennm = "";
        BM_SyouhnZokusei syouhnZokusei = null;
        BizNumber koujiKawaseRate = BizNumber.valueOf(0);
        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

        while (pIterator.hasNext()) {

            HW_NyuukinJyouhouHuittiWk nyuukinJyouhouHuittiWk = pIterator.next();

            nykMosno = nyuukinJyouhouHuittiWk.getNykmosno();
            oyaDrtenNm = "";
            drtenNm = "";
            kyknmkn = "";
            mosYmdSeireki = "";
            knjyYmdSeireki = "";
            skNyknjyhHuittiKakuninBean = SWAKInjector.getInstance(SkNyuukinjyouhouhuittikakuninBean.class);
            mosOyadrtencd = "";
            tratkiAgCd = "";
            oyaDrtenCd = nyuukinJyouhouHuittiWk.getOyadrtencd();
            knjyYmd = nyuukinJyouhouHuittiWk.getKnjyymd();
            mosno = "";
            nyuukinjyoutaiKbn = "";
            mosfstpkei = BizCurrency.valueOf(0);
            siteituuka = C_Tuukasyu.BLNK;
            nyknRnrkhyouYmdSeireki =  "";
            meisaitrkmymd =  "";
            aisyoumei = "";
            seikeijiZenkiZennou = "";
            phaneiMosno = "";
            phaneiKyknmkn = "";
            phaneiOyadytenCd = "";
            phaneiOyadytennm = "";

            syoriCTL = sinkeiyakuDomManager.getSyoriCTL(nykMosno);

            if (syoriCTL != null) {

                nyuukinjyoutaiKbn = C_NyuukinjyoutaiKbn.getContentByValue(C_NyuukinjyoutaiKbn.PATTERN_NYUUKINJYOUHOUHUITTI,
                    syoriCTL.getNyuukinjoutaikbn().getValue());

                mosKihon = syoriCTL.getMosKihon();
                if (mosKihon != null) {

                    List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

                    if (mosSyouhnLst != null && mosSyouhnLst.size() != 0) {

                        mosSyouhn = mosSyouhnLst.get(0);

                        syouhnZokusei = mosSyouhn.getSyouhnZokusei();

                        mosno = mosKihon.getMosno();

                        if (C_PtratkituukasiteiKbn.SITEITUUKA.eq(syouhnZokusei.getPtratkituukasiteikbn()) &&
                            !C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu()) &&
                            C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {

                            if (syoriCTL.getRyosyuymd() != null) {

                                koujiKawaseRate = syoriCTL.getNyknkwsrate();
                            }
                            else {

                                C_ErrorKbn errorKbn = getKawaseRate.execFstPNyuukin(
                                    nyuukinJyouhouHuittiWk.getKnjyymd(),
                                    mosKihon.getKyktuukasyu(),
                                    C_Tuukasyu.JPY,
                                    C_YouhiKbn.HUYOU,
                                    mosKihon.getHrkkaisuu(),
                                    C_SysKbn.SKEI,
                                    mosKihon.getZennoumousideumu(),
                                    mosKihon.getIkkatubaraikbn());

                                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                                    String errMessage = MessageUtil.getMessage(MessageId.ESA1004,
                                        nyuukinJyouhouHuittiWk.getKnjyymd().toString(),
                                        mosKihon.getKyktuukasyu().getValue(),
                                        C_Tuukasyu.JPY.getValue(),
                                        C_YouhiKbn.HUYOU.getValue(),
                                        mosKihon.getHrkkaisuu().getValue(),
                                        C_SysKbn.SKEI.getValue(),
                                        mosKihon.getZennoumousideumu().getValue(),
                                        mosKihon.getIkkatubaraikbn().getValue()
                                        );

                                    batchLogger.error(errMessage);

                                    throw new BizAppException(MessageId.EHA1045);
                                }

                                koujiKawaseRate = getKawaseRate.getKawaserate();
                            }

                            if (C_UmuKbn.ARI.eq(mosKihon.getZennoumousideumu())) {

                                mosfstpkei = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                                    mosKihon.getMosheijyunp(),
                                    koujiKawaseRate,
                                    C_HasuusyoriKbn.SUTE);

                                mosfstpkei = mosfstpkei.add(keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                                    mosKihon.getMosfstpkei().subtract(mosKihon.getMosheijyunp()),
                                    koujiKawaseRate,
                                    C_HasuusyoriKbn.SUTE));

                            }
                            else {

                                mosfstpkei = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                                    mosKihon.getMosfstpkei(),
                                    koujiKawaseRate,
                                    C_HasuusyoriKbn.SUTE);
                            }
                        }
                        else {

                            mosfstpkei = mosKihon.getMosfstpkei();
                        }
                    }

                    aisyoumei = mosKihon.getAisyoumeikbn().getContent();

                    if (C_NyuukinHuittiriyuuKbn.MOSNO.eq(nyuukinJyouhouHuittiWk.getNyuukinhuittiriyuukbn())
                        || C_NyuukinHuittiriyuuKbn.MOSNOHUKUSUU.eq(nyuukinJyouhouHuittiWk
                            .getNyuukinhuittiriyuukbn())) {

                        seikeijiZenkiZennou = "不明";
                    }
                    else if (C_NyuukinHuittiriyuuKbn.DOUITUMOSNO.eq(nyuukinJyouhouHuittiWk
                        .getNyuukinhuittiriyuukbn())
                        || C_NyuukinHuittiriyuuKbn.OYADRTENCDERROR.eq(nyuukinJyouhouHuittiWk
                            .getNyuukinhuittiriyuukbn())) {

                        seikeijiZenkiZennou = "";
                    }
                    else {

                        seikeijiZenkiZennou = mosKihon.getZenkizennouumu().getContent();
                    }
                    mosDairiten = syoriCTL.getMosDairitenByRenno(1);
                    if (mosDairiten != null) {

                        mosOyadrtencd = mosDairiten.getOyadrtencd();

                        tratkiAgCd = mosDairiten.getTratkiagcd();
                    }

                    bzGetAgInfoBeanList = bzGetAgInfo.exec(mosOyadrtencd);

                    for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanList) {

                        if (bzGetAgInfoBean != null &&
                            C_DiritenjyouhouKbn.SHITEIOYA.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {

                            oyaDrtenNm = bzGetAgInfoBean.getKanjiDairitenNm();

                            break;
                        }
                    }

                    bzGetAgInfoBeanList = bzGetAgInfo.exec(tratkiAgCd);

                    for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanList) {

                        if (bzGetAgInfoBean != null &&
                            C_DiritenjyouhouKbn.SHITEIKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {

                            drtenNm = bzGetAgInfoBean.getKanjiDairitenNm();

                            break;
                        }
                    }

                    if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {

                        kyknmkn = mosKihon.getHhknnmkn();
                    }
                    else if (C_KykKbn.KEIHI_BETU.eq(mosKihon.getKykkbn())) {

                        kyknmkn = mosKihon.getKyknmkn();
                    }

                    if (mosKihon.getMosymd() != null) {

                        mosYmdSeireki = DateFormatUtil.dateDOTNoEx(mosKihon.getMosymd());
                    }

                }
            }

            pageNo++;

            if (knjyYmd != null) {

                knjyYmdSeireki = DateFormatUtil.dateDOTNoEx(knjyYmd);
            }

            BizDate nyknRnrkhyouYmd = setNyknRnrkhyouYmd.exec(
                nyuukinJyouhouHuittiWk.getHrkmnykndatarenmotoKbn(), nyuukinJyouhouHuittiWk.getNyksyoriymd());

            if (nyknRnrkhyouYmd != null) {
                nyknRnrkhyouYmdSeireki = DateFormatUtil.dateDOTNoEx(nyknRnrkhyouYmd);
            }

            if (!C_NyuukinHuittiriyuuKbn.DOUITUMOSNO.eq(nyuukinJyouhouHuittiWk.getNyuukinhuittiriyuukbn())) {

                if (C_TaisyouKbn.TAISYOU.eq(nyuukinJyouhouHuittiWk.getOyadrtensyoritarget())) {

                    if (nyuukinJyouhouHuittiWk.getOyadrtencd().equals(mosOyadrtencd)) {

                        phaneiOyadytenCd = mosOyadrtencd;
                        phaneiOyadytennm = oyaDrtenNm;
                    }
                }
                else {

                    phaneiOyadytenCd = mosOyadrtencd;
                    phaneiOyadytennm = oyaDrtenNm;
                }

                if (nyuukinJyouhouHuittiWk.getHrkmirninnm().equals(kyknmkn)) {

                    phaneiKyknmkn = kyknmkn;
                }

                if (!C_NyuukinHuittiriyuuKbn.MOSNO.eq(nyuukinJyouhouHuittiWk.getNyuukinhuittiriyuukbn())
                    && !C_NyuukinHuittiriyuuKbn.MOSNOHUKUSUU.eq(nyuukinJyouhouHuittiWk
                        .getNyuukinhuittiriyuukbn())) {

                    phaneiMosno = mosno;
                }
            }

            if (nyuukinJyouhouHuittiWk.getHrkmnykndatarenmotoKbn() == null) {
                hrkmnykndatarenmotoKbn = C_HrkmnykndatarenmotoKbn.NYKNMEISAI;
            }
            else {
                hrkmnykndatarenmotoKbn = nyuukinJyouhouHuittiWk.getHrkmnykndatarenmotoKbn();
            }

            if (C_Tuukasyu.JPY.eq(nyuukinJyouhouHuittiWk.getRstuukasyu())) {
                hrkmnyknData = sinkeiyakuDomManager.getHrkmNyknData(C_DensysKbn.SKEI,
                    nyuukinJyouhouHuittiWk.getNyksyoriymd(), nyuukinJyouhouHuittiWk.getItirenno());
                siteituuka = hrkmnyknData.getSiteituuka();
            }
            else {
                gaikahrkmnyknData = sinkeiyakuDomManager.getGaikaHrkmNyknData(C_DensysKbn.SKEI,
                    nyuukinJyouhouHuittiWk.getNyksyoriymd(), nyuukinJyouhouHuittiWk.getItirenno());
                siteituuka = gaikahrkmnyknData.getSiteituuka();
            }

            if (C_HrkmnykndatarenmotoKbn.IKKATUTORIKOMI.eq(nyuukinJyouhouHuittiWk.getHrkmnykndatarenmotoKbn())) {
                if (nyuukinJyouhouHuittiWk.getNyksyoriymd() != null) {
                    meisaitrkmymd = MEISAITORIKOMIBI_MAE + DateFormatUtil.dateDOTNoEx(nyuukinJyouhouHuittiWk.getNyksyoriymd()) + MEISAITORIKOMIBI_ATO;
                }
                else{
                }
            }
            else {
                meisaitrkmymd = "";
            }

            skNyknjyhHuittiKakuninBean.setIrAtesaki(pKanjiSosikinm);
            skNyknjyhHuittiKakuninBean.setIrTyouhyousakuseiymd(tyouhyouYmd);
            skNyknjyhHuittiKakuninBean.setIrPageno(pageNo);
            skNyknjyhHuittiKakuninBean.setIrHrkmnykndatarenmotoKbn(hrkmnykndatarenmotoKbn);
            skNyknjyhHuittiKakuninBean.setIrKouzano(nyuukinJyouhouHuittiWk.getKouzano());
            skNyknjyhHuittiKakuninBean.setIrHrkmirninnm(nyuukinJyouhouHuittiWk.getHrkmirninnm140());
            skNyknjyhHuittiKakuninBean.setIrHrkmirnincd(nyuukinJyouhouHuittiWk.getHrkmirnincd());
            skNyknjyhHuittiKakuninBean.setIrNyknkkngk(nyuukinJyouhouHuittiWk.getTrhkkgk());
            skNyknjyhHuittiKakuninBean.setIrSimukebanknm(nyuukinJyouhouHuittiWk.getSimukebanknm());
            skNyknjyhHuittiKakuninBean.setIrSimuketennm(nyuukinJyouhouHuittiWk.getSimuketennm());
            skNyknjyhHuittiKakuninBean.setIrMosymd(mosYmdSeireki);
            skNyknjyhHuittiKakuninBean.setIrMosno(mosno);
            skNyknjyhHuittiKakuninBean.setIrKyknmkn(kyknmkn);
            skNyknjyhHuittiKakuninBean.setIrMosfstpkei(mosfstpkei);
            skNyknjyhHuittiKakuninBean.setIrSeikeijizenkizennou(seikeijiZenkiZennou);
            skNyknjyhHuittiKakuninBean.setIrNyuukinjyoukyou(nyuukinjyoutaiKbn);
            skNyknjyhHuittiKakuninBean.setIrOyadrtencd(mosOyadrtencd);
            skNyknjyhHuittiKakuninBean.setIrOyadrtennm(oyaDrtenNm);
            skNyknjyhHuittiKakuninBean.setIrDrtennmkj(drtenNm);
            skNyknjyhHuittiKakuninBean.setIrNyuukinhuittiriyuu(
                nyuukinJyouhouHuittiWk.getNyuukinhuittiriyuukbn().getContent());
            skNyknjyhHuittiKakuninBean.setIrPhaneioyadytencd(phaneiOyadytenCd);
            skNyknjyhHuittiKakuninBean.setIrPhaneioyadytennm(phaneiOyadytennm);
            skNyknjyhHuittiKakuninBean.setIrKnjyymd(knjyYmdSeireki);
            skNyknjyhHuittiKakuninBean.setIrPhaneimosno(phaneiMosno);
            skNyknjyhHuittiKakuninBean.setIrPhaneikyknmkn(phaneiKyknmkn);
            skNyknjyhHuittiKakuninBean.setIrJigyouhicd(pJigyouhiCd);
            skNyknjyhHuittiKakuninBean.setIrNyknrnrkhyouymd(nyknRnrkhyouYmdSeireki);
            skNyknjyhHuittiKakuninBean.setIrSiteituuka(siteituuka);
            skNyknjyhHuittiKakuninBean.setIrMeisaitrkmymd(meisaitrkmymd);
            skNyknjyhHuittiKakuninBean.setIrAisyoumei(aisyoumei);
            skNyknjyhHuittiKakuninBean.setIrSyoruicd(pSyoruiCdKbn);

            ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                kinou.getSubSystemId(),
                kinou.getCategoryId(),
                kinou.getKinouId(),
                pSyoruiCdKbn);

            reportServicesBean.setSyoriYmd(syoriYmd);
            reportServicesBean.setKensakuKeys(new String[] {oyaDrtenCd, String.valueOf(knjyYmd), nykMosno});

            reportServicesBean.addParamObjects(pSyoruiCdKbn, skNyknjyhHuittiKakuninBean);

            createReport.execNoCommit(reportServicesBean);

            syoriKensuu++;
        }
    }
}
