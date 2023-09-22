package yuyu.common.sinkeiyaku.skcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.base.format.DefaultDateFormatter;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoKekkaBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzdairiten.BzGetBsInfo;
import yuyu.common.biz.bzdairiten.BzGetBsInfoBean;
import yuyu.common.biz.report.ViewReport;
import yuyu.def.biz.bean.report.BzDairitenAtesakiBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.HM_SkDairitenKobetuJyouhou;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 新契約 新契約共通 代理店宛先編集
 */
public class EditDairitenAtesaki {

    @Inject
    private static Logger logger;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    public EditDairitenAtesaki() {
        super();
    }

    public  BzDairitenAtesakiBean exec(EditDairitenAtesakiBean pEditDairitenAtesakiBean) {

        logger.debug("▽ 代理店宛先編集 開始");

        C_SyoruiCdKbn syoruiCdKbn = pEditDairitenAtesakiBean.getSyoruiCdKbn();
        HT_MosDairiten mosDairiten = pEditDairitenAtesakiBean.getMosDairiten();
        BizDate hassouYmd = pEditDairitenAtesakiBean.getHassouYmd();
        C_SeirituKbn seirituKbn = pEditDairitenAtesakiBean.getSeirituKbn();
        C_Ketkekkacd ketkekkaCd = pEditDairitenAtesakiBean.getKetkekkaCd();

        String tratkiagCd = "";
        C_SkeijimuKbn skeiJimuKbn = pEditDairitenAtesakiBean.getSkeijimuKbn();

        BzGetSosikiMadogutiInfo bzGetSosikiMadogutiInfo = SWAKInjector.getInstance(BzGetSosikiMadogutiInfo.class);
        BzGetSosikiMadogutiInfoKekkaBean bzGetSosikiMadogutiInfoKekkaBean = bzGetSosikiMadogutiInfo.exec(
            YuyuSinkeiyakuConfig.getInstance().getDairitenkyksosikicd());

        BzGetAgInfoBean bzGetAgInfoBean = null;
        BzGetBsInfoBean bzGetBsInfoBean = null;
        HM_SkDairitenKobetuJyouhou skDairitenKobetuJyouhou = null;

        if (mosDairiten != null) {

            tratkiagCd = mosDairiten.getTratkiagcd();

            skDairitenKobetuJyouhou = sinkeiyakuDomManager.getSkDairitenKobetuJyouhou(mosDairiten.getOyadrtencd());

            if (!C_SyoruiCdKbn.SK_TTDKKR_DAIRITEN.eq(syoruiCdKbn)) {

                BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

                List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(tratkiagCd);

                for (BzGetAgInfoBean bzGetAgInfoBeanTel : bzGetAgInfoBeanList) {
                    if (C_DiritenjyouhouKbn.KEISYOUKO.eq(bzGetAgInfoBeanTel.getDiritenJyouhouKbn())) {
                        bzGetAgInfoBean = bzGetAgInfoBeanTel;
                        break;
                    }
                }
            }

            BzGetBsInfo bzGetBsInfo = SWAKInjector.getInstance(BzGetBsInfo.class);
            bzGetBsInfoBean = bzGetBsInfo.exec(mosDairiten.getBosyuucd());
        }

        GetSkChannelInfo getSkChannelInfo = SWAKInjector.getInstance(GetSkChannelInfo.class);

        if ((skeiJimuKbn == null || C_SkeijimuKbn.BLNK.eq(skeiJimuKbn)) ||
            (!BizUtil.isBlank(tratkiagCd))) {

            getSkChannelInfo.exec(null, tratkiagCd);
        }

        if (skeiJimuKbn == null || C_SkeijimuKbn.BLNK.eq(skeiJimuKbn)) {

            skeiJimuKbn = getSkChannelInfo.getSkeiJimuKbn();
        }

        String irTratkitantounmkj = "";
        String irDrtenutdskknnm1 = "";
        String irDrtenutdskknnm2 = "";
        String irDrtennmkj = "";
        String irToiawasefaxmidasi = "";
        String irToiawasefaxno = "";
        String irToiawasetantounm = "";
        String irTyouhyousakuseiymd = "";
        String irDrtenhassouymd = "";
        String irToiawasetelno = "";

        if (C_SyoruiCdKbn.SK_TTDKKR_DAIRITEN.eq(syoruiCdKbn)) {

            if (C_SkeijimuKbn.SHOP.eq(skeiJimuKbn)) {
                if (bzGetBsInfoBean != null) {
                    irTratkitantounmkj = ViewReport.editSama(bzGetBsInfoBean.getKanjiBosyuuninNm());
                }
            }
            else {
                irTratkitantounmkj = "（保険窓販ご担当者様）";
            }

            if (skDairitenKobetuJyouhou != null) {
                if (!BizUtil.isBlank(skDairitenKobetuJyouhou.getUtdskknnm1kj())) {
                    if(BizUtil.isBlank(skDairitenKobetuJyouhou.getUtdskknnm2kj())) {
                        irDrtenutdskknnm2 = skDairitenKobetuJyouhou.getUtdskknnm1kj();
                    }
                    else {
                        irDrtenutdskknnm1 = skDairitenKobetuJyouhou.getUtdskknnm1kj();
                        irDrtenutdskknnm2 = "（" + skDairitenKobetuJyouhou.getUtdskknnm2kj() + "）";
                    }
                }
                else {
                    if(!BizUtil.isBlank(skDairitenKobetuJyouhou.getUtdskknnm2kj())) {
                        irDrtenutdskknnm2 = "（" + skDairitenKobetuJyouhou.getUtdskknnm2kj() + "）";
                    }
                }
            }

            if (C_SkeijimuKbn.TIGINSINKIN.eq(skeiJimuKbn) && !BizUtil.isBlank(tratkiagCd)) {

                irToiawasefaxmidasi = "FAX";
                irToiawasefaxno = getSkChannelInfo.getSapodefaxno();
            }

            if (!BizUtil.isBlank(tratkiagCd)) {

                irToiawasetelno = getSkChannelInfo.getSapodetelno();
            }

            if (C_SeirituKbn.HUSEIRITU.eq(seirituKbn) && C_Ketkekkacd.MIAWASE.eq(ketkekkaCd)) {
                irToiawasetantounm = "新契約チーム";
            }

            irTyouhyousakuseiymd = DateFormatUtil.dateKANJI(hassouYmd);
        }
        else if (C_SyoruiCdKbn.SK_KYKHUSEIRITU.eq(syoruiCdKbn) ||
            C_SyoruiCdKbn.SK_YOTEIRIRITUHENKOURENRAKUHYOU.eq(syoruiCdKbn) ||
            C_SyoruiCdKbn.SK_TRKSSEIKYU_SOUHU.eq(syoruiCdKbn) ||
            C_SyoruiCdKbn.SK_HENKINIRAISYO_SOUHU.eq(syoruiCdKbn)) {

            if (bzGetBsInfoBean != null) {
                irTratkitantounmkj = bzGetBsInfoBean.getKanjiBosyuuninNm();
            }

            if (skDairitenKobetuJyouhou != null) {
                irDrtenutdskknnm1 = skDairitenKobetuJyouhou.getUtdskknnm1kj();
            }

            if (C_SyoruiCdKbn.SK_KYKHUSEIRITU.eq(syoruiCdKbn)) {
                if (mosDairiten != null) {
                    if ("5200002".equals(mosDairiten.getOyadrtencd())) {
                        irDrtenutdskknnm2 = "（リテール業務センター）";
                    }
                    else {
                        if (skDairitenKobetuJyouhou != null) {
                            if(!BizUtil.isBlank(skDairitenKobetuJyouhou.getUtdskknnm2kj())) {
                                irDrtenutdskknnm2 = "（" + skDairitenKobetuJyouhou.getUtdskknnm2kj() + "）";
                            }
                        }
                    }
                }
            }
            else {
                if (skDairitenKobetuJyouhou != null) {
                    if(!BizUtil.isBlank(skDairitenKobetuJyouhou.getUtdskknnm2kj())) {
                        irDrtenutdskknnm2 = "（" + skDairitenKobetuJyouhou.getUtdskknnm2kj() + "）";
                    }
                }
            }

            if (bzGetAgInfoBean != null) {
                irDrtennmkj = bzGetAgInfoBean.getKanjiDairitenNm();
            }

            if (!C_SkeijimuKbn.SHOP.eq(skeiJimuKbn) && !BizUtil.isBlank(tratkiagCd)) {

                irToiawasefaxmidasi = "FAX：";
                irToiawasefaxno = getSkChannelInfo.getSapodefaxno();
            }

            if (!BizUtil.isBlank(tratkiagCd)) {

                irToiawasetelno = getSkChannelInfo.getSapodetelno();
            }

            irDrtenhassouymd = DefaultDateFormatter.formatMDKanji(hassouYmd);
        }

        BzDairitenAtesakiBean bzDairitenAtesakiBean = new BzDairitenAtesakiBean();

        bzDairitenAtesakiBean.setIrTratkitantounmkj(irTratkitantounmkj);
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1(irDrtenutdskknnm1);
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2(irDrtenutdskknnm2);
        bzDairitenAtesakiBean.setIrDrtennmkj(irDrtennmkj);
        bzDairitenAtesakiBean.setIrSkeijimukbn(skeiJimuKbn);
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi(irToiawasefaxmidasi);
        bzDairitenAtesakiBean.setIrToiawasefaxno(irToiawasefaxno);
        bzDairitenAtesakiBean.setIrToiawasetelno(irToiawasetelno);
        bzDairitenAtesakiBean.setIrToiawasesosiki(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikinm());
        bzDairitenAtesakiBean.setIrToiawasetantounm(irToiawasetantounm);
        bzDairitenAtesakiBean.setIrHknkisynm(YuyuBizConfig.getInstance().getHokenKaisyaNmKanji());
        bzDairitenAtesakiBean.setIrTyouhyousakuseiymd(irTyouhyousakuseiymd);
        bzDairitenAtesakiBean.setIrDrtenhassouymd(irDrtenhassouymd);

        logger.debug("△ 代理店宛先編集 終了");

        return bzDairitenAtesakiBean;
    }
}