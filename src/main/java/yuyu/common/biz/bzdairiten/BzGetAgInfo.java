package yuyu.common.biz.bzdairiten;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.detacher.BM_DairitenDetacher;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_Diritenbunruicd;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_DrtenChannelSyurui;
import yuyu.def.classification.C_MdhnSchemeDrtenHyouji;
import yuyu.def.db.entity.BM_Dairiten;

/**
 * 業務共通 代理店 代理店情報取得（代理店コード指定）クラス
 */
public class BzGetAgInfo {

    private List<BzGetAgInfoBean> bzGetAgInfoBeanList;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private static Logger logger;

    public BzGetAgInfo() {
        super();
    }

    public List<BzGetAgInfoBean> exec(String pDrtenCd) {

        logger.debug("▽ 代理店情報取得（代理店コード指定） 開始");
        logger.debug("｜ ▽ 入力パラメータ");
        logger.debug("｜ ｜ 代理店コード＝                  " + pDrtenCd);
        logger.debug("｜ △ ");

        bzGetAgInfoBeanList = new ArrayList<>();

        if (BizUtil.isBlank(pDrtenCd)) {

            logger.debug("△ 代理店情報取得（代理店コード指定） 終了");

            return bzGetAgInfoBeanList;
        }

        BM_Dairiten siteikoDairiten = BM_DairitenDetacher.detachDairitentouched(bizDomManager.getDairiten(pDrtenCd));

        if (siteikoDairiten == null) {

            logger.debug("｜ 指定した代理店コードの指定子代理店情報が存在しません。");
            logger.debug("△ 代理店情報取得（代理店コード指定） 終了");

            return bzGetAgInfoBeanList;
        }

        editOutInfo(C_DiritenjyouhouKbn.SHITEIKO, siteikoDairiten);

        BM_Dairiten siteioyaDairiten = BM_DairitenDetacher.detachDairitentouched(bizDomManager
            .getDairiten(siteikoDairiten.getOyadrtencd()));

        if (siteioyaDairiten == null) {

            bzGetAgInfoBeanList.clear();

            logger.debug("｜ 指定した代理店コードの指定親代理店情報が存在しません。");
            logger.debug("△ 代理店情報取得（代理店コード指定） 終了");

            return bzGetAgInfoBeanList;
        }

        editOutInfo(C_DiritenjyouhouKbn.SHITEIOYA, siteioyaDairiten);

        if (BizUtil.isBlank(siteikoDairiten.getKeisyousakidrtencd())) {

            editOutInfo(C_DiritenjyouhouKbn.KEISYOUKO, siteikoDairiten);

            editOutInfo(C_DiritenjyouhouKbn.KEISYOUOYA, siteioyaDairiten);

            logger.debug("｜ ▽ 戻り値");
            logger.debug("｜ ｜ （指定子代理店）代理店コード＝  " + bzGetAgInfoBeanList.get(0).getDrtenCd());
            logger.debug("｜ ｜ （指定親代理店）代理店コード＝  " + bzGetAgInfoBeanList.get(1).getDrtenCd());
            logger.debug("｜ ｜ （継承先子代理店）代理店コード＝" + bzGetAgInfoBeanList.get(2).getDrtenCd());
            logger.debug("｜ ｜ （継承先親代理店）代理店コード＝" + bzGetAgInfoBeanList.get(3).getDrtenCd());
            logger.debug("｜ △ ");
            logger.debug("△ 代理店情報取得（代理店コード指定） 終了");

            return bzGetAgInfoBeanList;
        }

        BM_Dairiten keisyousakikoDairiten = BM_DairitenDetacher.detachDairitentouched(bizDomManager
            .getDairiten(siteikoDairiten.getKeisyousakidrtencd()));

        if (keisyousakikoDairiten == null) {

            bzGetAgInfoBeanList.clear();

            logger.debug("｜ 指定した代理店コードの継承先子代理店情報が存在しません。");
            logger.debug("△ 代理店情報取得（代理店コード指定） 終了");

            return bzGetAgInfoBeanList;
        }

        editOutInfo(C_DiritenjyouhouKbn.KEISYOUKO, keisyousakikoDairiten);

        BM_Dairiten keisyousakioyaDairiten = BM_DairitenDetacher.detachDairitentouched(bizDomManager
            .getDairiten(keisyousakikoDairiten.getOyadrtencd()));

        if (keisyousakioyaDairiten == null) {

            bzGetAgInfoBeanList.clear();

            logger.debug("｜ 指定した代理店コードの継承先親代理店情報が存在しません。");
            logger.debug("△ 代理店情報取得（代理店コード指定） 終了");

            return bzGetAgInfoBeanList;
        }

        editOutInfo(C_DiritenjyouhouKbn.KEISYOUOYA, keisyousakioyaDairiten);

        logger.debug("｜ ▽ 戻り値");
        logger.debug("｜ ｜ （指定子代理店）代理店コード＝  " + bzGetAgInfoBeanList.get(0).getDrtenCd());
        logger.debug("｜ ｜ （指定親代理店）代理店コード＝  " + bzGetAgInfoBeanList.get(1).getDrtenCd());
        logger.debug("｜ ｜ （継承先子代理店）代理店コード＝" + bzGetAgInfoBeanList.get(2).getDrtenCd());
        logger.debug("｜ ｜ （継承先親代理店）代理店コード＝" + bzGetAgInfoBeanList.get(3).getDrtenCd());
        logger.debug("｜ △ ");
        logger.debug("△ 代理店情報取得（代理店コード指定） 終了");

        return bzGetAgInfoBeanList;
    }

    private void editOutInfo(C_DiritenjyouhouKbn pDiritenjyouhouKbn, BM_Dairiten pDairiten) {

        BzGetAgInfoBean bzGetAgInfoBean = SWAKInjector.getInstance(BzGetAgInfoBean.class);

        BzGetAgHoujinsyougou bzGetAgHoujinsyougou = SWAKInjector.getInstance(BzGetAgHoujinsyougou.class);

        List<TesuuryouInfoBean> tesuuryouInfoBeanLst = new ArrayList<>();

        bzGetAgInfoBean.setDiritenJyouhouKbn(pDiritenjyouhouKbn);

        bzGetAgInfoBean.setDrtenCd(pDairiten.getDrtencd());

        bzGetAgInfoBean.setDrtenNm(pDairiten.getDrtennm());

        bzGetAgInfoBean.setKanjiDairitenNm(pDairiten.getKanjidairitennm());

        bzGetAgInfoBean.setItakukeiyakuYmd(pDairiten.getItakukeiyakuymd());

        bzGetAgInfoBean.setItakukeiyakuKaiyakuYmd(pDairiten.getItakukeiyakukaiyakuymd());

        bzGetAgInfoBean.setDairitenTourokuYmd(pDairiten.getDairitentourokuymd());

        bzGetAgInfoBean.setDaisinHidaisinKbn(pDairiten.getDaisinhidaisinkbn());

        bzGetAgInfoBean.setDrtKanrisosikiCd1(pDairiten.getDrtkanrisosikicd1());

        bzGetAgInfoBean.setDrtKanrisosikiCd2(pDairiten.getDrtkanrisosikicd2());

        bzGetAgInfoBean.setDrtKanrisosikiCd3(pDairiten.getDrtkanrisosikicd3());

        bzGetAgInfoBean.setKeisyousakiDrtenCd(pDairiten.getKeisyousakidrtencd());

        bzGetAgInfoBean.setKsymtDrtenCd(pDairiten.getKsymtdrtencd());

        bzGetAgInfoBean.setDairitenTelNo(pDairiten.getDairitentelno());

        bzGetAgInfoBean.setDairitenFaxNo(pDairiten.getDairitenfaxno());

        bzGetAgInfoBean.setOyadrtenCd(pDairiten.getOyadrtencd());

        bzGetAgInfoBean.setDrtentrkno(pDairiten.getDrtentrkno());

        bzGetAgInfoBean.setDairitenKouryokuKaisiYmd(pDairiten.getDairitenkouryokukaisiymd());

        bzGetAgInfoBean.setDairitenKouryokuSyuuryouYmd(pDairiten.getDairitenkouryokusyuuryouymd());

        bzGetAgInfoBean.setKinyuuCd(pDairiten.getKinyuucd());

        bzGetAgInfoBean.setKinyuuSitenCd(pDairiten.getKinyuusitencd());

        bzGetAgInfoBean.setDrtenJimCd(pDairiten.getDrtenjimcd());

        bzGetAgInfoBean.setDaiBosyuuCd(pDairiten.getDaibosyuucd());

        bzGetAgInfoBean.setMdhnSchemeDrtenHyouji(pDairiten.getMdhnschemedrtenhyouji());

        bzGetAgInfoBean.setTykatukaiyouDrtenHyouji(pDairiten.getTykatukaiyoudrtenhyouji());

        bzGetAgInfoBean.setTkrtkKinyuuknHyouji(pDairiten.getTkrtkkinyuuknhyouji());

        bzGetAgInfoBean.setKydsskKinyuuknHyouji(pDairiten.getKydsskkinyuuknhyouji());

        bzGetAgInfoBean.setKydBosyuuDairitenHyouji(pDairiten.getKydbosyuudairitenhyouji());

        bzGetAgInfoBean.setYuuseijimusyoCd(pDairiten.getYuuseijimusyocd());

        bzGetAgInfoBean.setToukatuDairitenCd(pDairiten.getToukatudairitencd());

        TesuuryouInfoBean tesuuryouInfoBean1 = SWAKInjector.getInstance(TesuuryouInfoBean.class);
        tesuuryouInfoBean1.setDrtenSyouhncdKami3(pDairiten.getDrtensyouhncdkami3x1());
        tesuuryouInfoBean1.setTsryshrkbnTougetu(pDairiten.getTsryshrkbntougetux1());
        tesuuryouInfoBean1.setTsryshrkbnYokugetu(pDairiten.getTsryshrkbnyokugetux1());
        tesuuryouInfoBean1.setBntnptnKbn(pDairiten.getBntnptnkbnx1());
        tesuuryouInfoBeanLst.add(tesuuryouInfoBean1);

        TesuuryouInfoBean tesuuryouInfoBean2 = SWAKInjector.getInstance(TesuuryouInfoBean.class);
        tesuuryouInfoBean2.setDrtenSyouhncdKami3(pDairiten.getDrtensyouhncdkami3x2());
        tesuuryouInfoBean2.setTsryshrkbnTougetu(pDairiten.getTsryshrkbntougetux2());
        tesuuryouInfoBean2.setTsryshrkbnYokugetu(pDairiten.getTsryshrkbnyokugetux2());
        tesuuryouInfoBean2.setBntnptnKbn(pDairiten.getBntnptnkbnx2());
        tesuuryouInfoBeanLst.add(tesuuryouInfoBean2);

        TesuuryouInfoBean tesuuryouInfoBean3 = SWAKInjector.getInstance(TesuuryouInfoBean.class);
        tesuuryouInfoBean3.setDrtenSyouhncdKami3(pDairiten.getDrtensyouhncdkami3x3());
        tesuuryouInfoBean3.setTsryshrkbnTougetu(pDairiten.getTsryshrkbntougetux3());
        tesuuryouInfoBean3.setTsryshrkbnYokugetu(pDairiten.getTsryshrkbnyokugetux3());
        tesuuryouInfoBean3.setBntnptnKbn(pDairiten.getBntnptnkbnx3());
        tesuuryouInfoBeanLst.add(tesuuryouInfoBean3);

        TesuuryouInfoBean tesuuryouInfoBean4 = SWAKInjector.getInstance(TesuuryouInfoBean.class);
        tesuuryouInfoBean4.setDrtenSyouhncdKami3(pDairiten.getDrtensyouhncdkami3x4());
        tesuuryouInfoBean4.setTsryshrkbnTougetu(pDairiten.getTsryshrkbntougetux4());
        tesuuryouInfoBean4.setTsryshrkbnYokugetu(pDairiten.getTsryshrkbnyokugetux4());
        tesuuryouInfoBean4.setBntnptnKbn(pDairiten.getBntnptnkbnx4());
        tesuuryouInfoBeanLst.add(tesuuryouInfoBean4);

        TesuuryouInfoBean tesuuryouInfoBean5 = SWAKInjector.getInstance(TesuuryouInfoBean.class);
        tesuuryouInfoBean5.setDrtenSyouhncdKami3(pDairiten.getDrtensyouhncdkami3x5());
        tesuuryouInfoBean5.setTsryshrkbnTougetu(pDairiten.getTsryshrkbntougetux5());
        tesuuryouInfoBean5.setTsryshrkbnYokugetu(pDairiten.getTsryshrkbnyokugetux5());
        tesuuryouInfoBean5.setBntnptnKbn(pDairiten.getBntnptnkbnx5());
        tesuuryouInfoBeanLst.add(tesuuryouInfoBean5);

        TesuuryouInfoBean tesuuryouInfoBean6 = SWAKInjector.getInstance(TesuuryouInfoBean.class);
        tesuuryouInfoBean6.setDrtenSyouhncdKami3(pDairiten.getDrtensyouhncdkami3x6());
        tesuuryouInfoBean6.setTsryshrkbnTougetu(pDairiten.getTsryshrkbntougetux6());
        tesuuryouInfoBean6.setTsryshrkbnYokugetu(pDairiten.getTsryshrkbnyokugetux6());
        tesuuryouInfoBean6.setBntnptnKbn(pDairiten.getBntnptnkbnx6());
        tesuuryouInfoBeanLst.add(tesuuryouInfoBean6);

        TesuuryouInfoBean tesuuryouInfoBean7 = SWAKInjector.getInstance(TesuuryouInfoBean.class);
        tesuuryouInfoBean7.setDrtenSyouhncdKami3(pDairiten.getDrtensyouhncdkami3x7());
        tesuuryouInfoBean7.setTsryshrkbnTougetu(pDairiten.getTsryshrkbntougetux7());
        tesuuryouInfoBean7.setTsryshrkbnYokugetu(pDairiten.getTsryshrkbnyokugetux7());
        tesuuryouInfoBean7.setBntnptnKbn(pDairiten.getBntnptnkbnx7());
        tesuuryouInfoBeanLst.add(tesuuryouInfoBean7);

        TesuuryouInfoBean tesuuryouInfoBean8 = SWAKInjector.getInstance(TesuuryouInfoBean.class);
        tesuuryouInfoBean8.setDrtenSyouhncdKami3(pDairiten.getDrtensyouhncdkami3x8());
        tesuuryouInfoBean8.setTsryshrkbnTougetu(pDairiten.getTsryshrkbntougetux8());
        tesuuryouInfoBean8.setTsryshrkbnYokugetu(pDairiten.getTsryshrkbnyokugetux8());
        tesuuryouInfoBean8.setBntnptnKbn(pDairiten.getBntnptnkbnx8());
        tesuuryouInfoBeanLst.add(tesuuryouInfoBean8);

        TesuuryouInfoBean tesuuryouInfoBean9 = SWAKInjector.getInstance(TesuuryouInfoBean.class);
        tesuuryouInfoBean9.setDrtenSyouhncdKami3(pDairiten.getDrtensyouhncdkami3x9());
        tesuuryouInfoBean9.setTsryshrkbnTougetu(pDairiten.getTsryshrkbntougetux9());
        tesuuryouInfoBean9.setTsryshrkbnYokugetu(pDairiten.getTsryshrkbnyokugetux9());
        tesuuryouInfoBean9.setBntnptnKbn(pDairiten.getBntnptnkbnx9());
        tesuuryouInfoBeanLst.add(tesuuryouInfoBean9);

        TesuuryouInfoBean tesuuryouInfoBean10 = SWAKInjector.getInstance(TesuuryouInfoBean.class);
        tesuuryouInfoBean10.setDrtenSyouhncdKami3(pDairiten.getDrtensyouhncdkami3x10());
        tesuuryouInfoBean10.setTsryshrkbnTougetu(pDairiten.getTsryshrkbntougetux10());
        tesuuryouInfoBean10.setTsryshrkbnYokugetu(pDairiten.getTsryshrkbnyokugetux10());
        tesuuryouInfoBean10.setBntnptnKbn(pDairiten.getBntnptnkbnx10());
        tesuuryouInfoBeanLst.add(tesuuryouInfoBean10);

        TesuuryouInfoBean tesuuryouInfoBean11 = SWAKInjector.getInstance(TesuuryouInfoBean.class);
        tesuuryouInfoBean11.setDrtenSyouhncdKami3(pDairiten.getDrtensyouhncdkami3x11());
        tesuuryouInfoBean11.setTsryshrkbnTougetu(pDairiten.getTsryshrkbntougetux11());
        tesuuryouInfoBean11.setTsryshrkbnYokugetu(pDairiten.getTsryshrkbnyokugetux11());
        tesuuryouInfoBean11.setBntnptnKbn(pDairiten.getBntnptnkbnx11());
        tesuuryouInfoBeanLst.add(tesuuryouInfoBean11);

        TesuuryouInfoBean tesuuryouInfoBean12 = SWAKInjector.getInstance(TesuuryouInfoBean.class);
        tesuuryouInfoBean12.setDrtenSyouhncdKami3(pDairiten.getDrtensyouhncdkami3x12());
        tesuuryouInfoBean12.setTsryshrkbnTougetu(pDairiten.getTsryshrkbntougetux12());
        tesuuryouInfoBean12.setTsryshrkbnYokugetu(pDairiten.getTsryshrkbnyokugetux12());
        tesuuryouInfoBean12.setBntnptnKbn(pDairiten.getBntnptnkbnx12());
        tesuuryouInfoBeanLst.add(tesuuryouInfoBean12);

        TesuuryouInfoBean tesuuryouInfoBean13 = SWAKInjector.getInstance(TesuuryouInfoBean.class);
        tesuuryouInfoBean13.setDrtenSyouhncdKami3(pDairiten.getDrtensyouhncdkami3x13());
        tesuuryouInfoBean13.setTsryshrkbnTougetu(pDairiten.getTsryshrkbntougetux13());
        tesuuryouInfoBean13.setTsryshrkbnYokugetu(pDairiten.getTsryshrkbnyokugetux13());
        tesuuryouInfoBean13.setBntnptnKbn(pDairiten.getBntnptnkbnx13());
        tesuuryouInfoBeanLst.add(tesuuryouInfoBean13);

        TesuuryouInfoBean tesuuryouInfoBean14 = SWAKInjector.getInstance(TesuuryouInfoBean.class);
        tesuuryouInfoBean14.setDrtenSyouhncdKami3(pDairiten.getDrtensyouhncdkami3x14());
        tesuuryouInfoBean14.setTsryshrkbnTougetu(pDairiten.getTsryshrkbntougetux14());
        tesuuryouInfoBean14.setTsryshrkbnYokugetu(pDairiten.getTsryshrkbnyokugetux14());
        tesuuryouInfoBean14.setBntnptnKbn(pDairiten.getBntnptnkbnx14());
        tesuuryouInfoBeanLst.add(tesuuryouInfoBean14);

        TesuuryouInfoBean tesuuryouInfoBean15 = SWAKInjector.getInstance(TesuuryouInfoBean.class);
        tesuuryouInfoBean15.setDrtenSyouhncdKami3(pDairiten.getDrtensyouhncdkami3x15());
        tesuuryouInfoBean15.setTsryshrkbnTougetu(pDairiten.getTsryshrkbntougetux15());
        tesuuryouInfoBean15.setTsryshrkbnYokugetu(pDairiten.getTsryshrkbnyokugetux15());
        tesuuryouInfoBean15.setBntnptnKbn(pDairiten.getBntnptnkbnx15());
        tesuuryouInfoBeanLst.add(tesuuryouInfoBean15);

        bzGetAgInfoBean.setTesuuryouInfoBeanLst(tesuuryouInfoBeanLst);

        bzGetAgInfoBean.setHnsituHykrankTougetu(Integer.parseInt(pDairiten.getHnsituhykranktougetu().toString()));

        bzGetAgInfoBean.setHnsituHykrankYokugetu(Integer.parseInt(pDairiten.getHnsituhykrankyokugetu().toString()));

        bzGetAgInfoBean.setKanjiHoujinSyougou(bzGetAgHoujinsyougou.exec(bzGetAgInfoBean.getOyadrtenCd()));

        bzGetAgInfoBean.setDiritenBunruiCd(C_Diritenbunruicd.valueOf(bzGetAgInfoBean.getDrtenCd().substring(0, 2)));

        if (YuyuBizConfig.getInstance().getSmbcOyadrtencd().equals(bzGetAgInfoBean.getOyadrtenCd())) {

            bzGetAgInfoBean.setChannelCd(C_Channelcd.SMBC);
        }
        else if (YuyuBizConfig.getInstance().getMizuhoOyadrtencd().equals(bzGetAgInfoBean.getOyadrtenCd())) {

            bzGetAgInfoBean.setChannelCd(C_Channelcd.MIZUHO);
        }
        else if (YuyuBizConfig.getInstance().getSmtbOyadrtencd().equals(bzGetAgInfoBean.getOyadrtenCd())) {

            bzGetAgInfoBean.setChannelCd(C_Channelcd.SMTB);
        }
        else if (C_Diritenbunruicd.GINSINKIN.eq(bzGetAgInfoBean.getDiritenBunruiCd())) {

            bzGetAgInfoBean.setChannelCd(C_Channelcd.SINKIN);
        }
        else if (C_Diritenbunruicd.GINTOGIN.eq(bzGetAgInfoBean.getDiritenBunruiCd())
            || C_Diritenbunruicd.GIN1CHIGIN.eq(bzGetAgInfoBean.getDiritenBunruiCd())
            || C_Diritenbunruicd.GIN2CHIGIN.eq(bzGetAgInfoBean.getDiritenBunruiCd())
            || C_Diritenbunruicd.GINCYOUSIN.eq(bzGetAgInfoBean.getDiritenBunruiCd())
            || C_Diritenbunruicd.GINSINKUMI.eq(bzGetAgInfoBean.getDiritenBunruiCd())
            || C_Diritenbunruicd.GINDIRECT.eq(bzGetAgInfoBean.getDiritenBunruiCd())) {

            bzGetAgInfoBean.setChannelCd(C_Channelcd.TIGIN);
        }
        else if (C_Diritenbunruicd.YUUSEIKANPO.eq(bzGetAgInfoBean.getDiritenBunruiCd())) {

            bzGetAgInfoBean.setChannelCd(C_Channelcd.YUUSEIKANPO);
        }
        else if (C_Diritenbunruicd.YUUSEIYUUCYO.eq(bzGetAgInfoBean.getDiritenBunruiCd())) {

            bzGetAgInfoBean.setChannelCd(C_Channelcd.YUUSEIGINKOU);
        }
        else if (C_Diritenbunruicd.YUUSEIYUUBIN.eq(bzGetAgInfoBean.getDiritenBunruiCd())) {

            bzGetAgInfoBean.setChannelCd(C_Channelcd.YUUSEIKAISYA);
        }
        else if (C_Diritenbunruicd.YUUSEIKANI.eq(bzGetAgInfoBean.getDiritenBunruiCd())) {

            bzGetAgInfoBean.setChannelCd(C_Channelcd.YUUSEIKANI);
        }
        else if (C_Diritenbunruicd.SYOUKEN.eq(bzGetAgInfoBean.getDiritenBunruiCd())) {

            bzGetAgInfoBean.setChannelCd(C_Channelcd.SONOTAMADOHAN);
        }
        else if (C_MdhnSchemeDrtenHyouji.MDHNSCHEME.eq(bzGetAgInfoBean.getMdhnSchemeDrtenHyouji())) {

            bzGetAgInfoBean.setChannelCd(C_Channelcd.SHOP);
        }
        else {

            bzGetAgInfoBean.setChannelCd(C_Channelcd.SONOTAMADOHAN);
        }

        if (C_Diritenbunruicd.GINTOGIN.eq(bzGetAgInfoBean.getDiritenBunruiCd())
            || C_Diritenbunruicd.GIN1CHIGIN.eq(bzGetAgInfoBean.getDiritenBunruiCd())
            || C_Diritenbunruicd.GIN2CHIGIN.eq(bzGetAgInfoBean.getDiritenBunruiCd())
            || C_Diritenbunruicd.GINSINKIN.eq(bzGetAgInfoBean.getDiritenBunruiCd())
            || C_Diritenbunruicd.GINCYOUSIN.eq(bzGetAgInfoBean.getDiritenBunruiCd())
            || C_Diritenbunruicd.GINSINKUMI.eq(bzGetAgInfoBean.getDiritenBunruiCd())
            || C_Diritenbunruicd.GINDIRECT.eq(bzGetAgInfoBean.getDiritenBunruiCd())) {

            bzGetAgInfoBean.setDrtenChannelSyurui(C_DrtenChannelSyurui.GINHONTAIMADO);
        }
        else if (C_Diritenbunruicd.GINDAITOGIN.eq(bzGetAgInfoBean.getDiritenBunruiCd())
            || C_Diritenbunruicd.GINDAI1CHIGIN.eq(bzGetAgInfoBean.getDiritenBunruiCd())
            || C_Diritenbunruicd.GINDAI2CHIGIN.eq(bzGetAgInfoBean.getDiritenBunruiCd())
            || C_Diritenbunruicd.GINDAISINKIN.eq(bzGetAgInfoBean.getDiritenBunruiCd())
            || C_Diritenbunruicd.GINDAIETC.eq(bzGetAgInfoBean.getDiritenBunruiCd())
            || C_Diritenbunruicd.GINDAISINKUMI.eq(bzGetAgInfoBean.getDiritenBunruiCd())) {

            bzGetAgInfoBean.setDrtenChannelSyurui(C_DrtenChannelSyurui.GINKOUKEIDAI);
        }
        else if (C_Diritenbunruicd.SYOUKEN.eq(bzGetAgInfoBean.getDiritenBunruiCd())) {

            bzGetAgInfoBean.setDrtenChannelSyurui(C_DrtenChannelSyurui.SYOUKENGAISYA);
        }
        else if (C_Diritenbunruicd.ZEIRIKOJIN.eq(bzGetAgInfoBean.getDiritenBunruiCd())
            || C_Diritenbunruicd.ZEIRIHOUJIN.eq(bzGetAgInfoBean.getDiritenBunruiCd())) {

            bzGetAgInfoBean.setDrtenChannelSyurui(C_DrtenChannelSyurui.ZEIRISI);
        }
        else if (C_Diritenbunruicd.SENDAI.eq(bzGetAgInfoBean.getDiritenBunruiCd())) {

            bzGetAgInfoBean.setDrtenChannelSyurui(C_DrtenChannelSyurui.SENGYOUDAI);
        }
        else if (C_Diritenbunruicd.KIGYODAI.eq(bzGetAgInfoBean.getDiritenBunruiCd())) {

            bzGetAgInfoBean.setDrtenChannelSyurui(C_DrtenChannelSyurui.KIGYOUDAI);
        }
        else if (C_Diritenbunruicd.YUUSEIKANPO.eq(bzGetAgInfoBean.getDiritenBunruiCd())
            || C_Diritenbunruicd.YUUSEIYUUCYO.eq(bzGetAgInfoBean.getDiritenBunruiCd())
            || C_Diritenbunruicd.YUUSEIYUUBIN.eq(bzGetAgInfoBean.getDiritenBunruiCd())
            || C_Diritenbunruicd.YUUSEIKANI.eq(bzGetAgInfoBean.getDiritenBunruiCd())) {

            bzGetAgInfoBean.setDrtenChannelSyurui(C_DrtenChannelSyurui.YUUSEI);
        }
        else if (C_Diritenbunruicd.BROKER.eq(bzGetAgInfoBean.getDiritenBunruiCd())) {

            bzGetAgInfoBean.setDrtenChannelSyurui(C_DrtenChannelSyurui.BROKER);
        }

        bzGetAgInfoBeanList.add(bzGetAgInfoBean);
    }
}
