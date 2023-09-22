package yuyu.common.sinkeiyaku.moschk;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.hozen.khcommon.KeisanIkkatuNyuukinGkBean;
import yuyu.common.hozen.khcommon.KeisanIkkatuNyuukinGkSyouhnBean;
import yuyu.common.hozen.khcommon.KeisanTukiIkkatuNyuukinGk;
import yuyu.common.hozen.khcommon.SetCreditUriageSeikyuubi;
import yuyu.common.hozen.khcommon.SetHurikaebi;
import yuyu.common.sinkeiyaku.skcommon.GetRsgakukei;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_IkkatuyouptknKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_NyknsyubetuKbn;
import yuyu.def.classification.C_NyuukinjyoutaiKbn;
import yuyu.def.classification.C_PtratkituukasiteiKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SknnkaisikitkhukaKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_ZenhnknKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Tokunin;

/**
 * 新契約 申込内容チェック 入金チェック
 */
public class CheckNyuukin {

    private static final int KBN_NYKN_NONE = 0;

    private static final int KBN_ARI = 1;

    private static final int KBN_NONE = 2;

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    @Inject
    private BizDomManager bizDomManager;

    public CheckNyuukin() {
        super();
    }

    public void exec(MosnaiCheckParam pMp) {
        if (logger.isDebugEnabled()) {
            logger.debug("▽ 入金チェック 開始");
        }

        HT_SyoriCTL syoriCtl = pMp.getDataSyoriControl();
        HT_MosKihon mosKihon = syoriCtl.getMosKihon();
        C_UmuKbn nyuukinUmu = syoriCtl.getNyknnrkumu();
        C_SeirituKbn seirituKbn = syoriCtl.getSeiritukbn();
        C_SknnkaisikitkhukaKbn sknnKaisikiTkHukaKbn = mosKihon.getSknnkaisikitkhukakbn();
        C_Tuukasyu hrkTuukaSyu = mosKihon.getHrktuukasyu();
        C_Tuukasyu rsTuukaSyu = C_Tuukasyu.BLNK;
        BizCurrency realRyousyuuGaku = BizCurrency.valueOf(0);
        int nyuuKinFlg = KBN_NYKN_NONE;
        BizCurrency fstPHrkGk = mosKihon.getFstphrkgk();
        BizCurrency hrkTuukaHeijyunP = BizCurrency.valueOf(0);
        BizCurrency hrkTuukaFstPHrkGk = BizCurrency.valueOf(0);
        HT_Tokunin tokunin = syoriCtl.getTokunin();
        C_IkkatuyouptknKbn beforeCheckIkkatuyouptknKbn = pMp.getBeforeCheckIkkatuyouptknKbn();
        Integer beforeCheckIkkatuyoupkaisuu = pMp.getBeforeCheckIkkatuyoupkaisuu();
        BizDate syoriymd = pMp.getSysDate();
        BizDate kykymd = mosKihon.getKykymd();
        C_Hrkkeiro hrkkeiro = mosKihon.getHrkkeiro();
        C_Hrkkaisuu hrkkaisuu = mosKihon.getHrkkaisuu();
        BizCurrency hituyouikkayouPkakunou = BizCurrency.valueOf(0);
        BizCurrency kahusokuKinngakuKakunou = BizCurrency.valueOf(0);
        C_UmuKbn syokaiPkahusokuCheckFlg = C_UmuKbn.ARI;
        C_IkkatuyouptknKbn ikkatuyouptknKbnNew = C_IkkatuyouptknKbn.NONE;
        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = mosKihon.getIkkatubaraikaisuu();
        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);
        BizDate annnaiTysytymdFirst = null;
        BizDate annnaiTysytymdSyoriymd = null;
        BizDateYM annnaiTysytymdFirstYm = null;
        BizDateYM annnaiTysytymdSyoriymdYm = null;

        List<HT_MosSyouhn> mosSyouhnLst = syoriCtl.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (mosSyouhnLst.size() != 1) {
            throw new CommonBizAppException("主契約申込商品件数異常 申込番号：" + syoriCtl.getMosno());
        }

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(
            mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());

        if (C_PtratkituukasiteiKbn.SITEITUUKA.eq(syouhnZokusei.getPtratkituukasiteikbn()) &&
            !C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu()) &&
            C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {

            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
            hrkTuukaHeijyunP = keisanGaikakanzan.exec(mosKihon.getHrktuukasyu(), mosKihon.getHeijyunp(),
                syoriCtl.getNyknkwsrate(), C_HasuusyoriKbn.SUTE);

            if (C_UmuKbn.ARI.eq(mosKihon.getZennoumousideumu())) {
                BizCurrency kanzanGaku = keisanGaikakanzan.exec(mosKihon.getHrktuukasyu(), mosKihon.getZennoup(),
                    syoriCtl.getNyknkwsrate(), C_HasuusyoriKbn.SUTE);

                fstPHrkGk = hrkTuukaHeijyunP.add(kanzanGaku);
                hrkTuukaFstPHrkGk = hrkTuukaHeijyunP.add(kanzanGaku);
            }
            else {
                BizCurrency kanzanGaku = keisanGaikakanzan.exec(mosKihon.getHrktuukasyu(), fstPHrkGk,
                    syoriCtl.getNyknkwsrate(), C_HasuusyoriKbn.SUTE);

                fstPHrkGk = kanzanGaku;
                hrkTuukaFstPHrkGk = kanzanGaku;
            }
        }
        else {
            hrkTuukaHeijyunP = mosKihon.getHeijyunp();
            hrkTuukaFstPHrkGk = fstPHrkGk;
        }

        mosKihon.setHrktuukaheijyunp(hrkTuukaHeijyunP);
        mosKihon.setHrktuukafstphrkgk(hrkTuukaFstPHrkGk);

        if (C_SysKbn.ESHIEN.eq(pMp.getSysKbn())) {
            return;
        }

        GetRsgakukei getRsgakukei = SWAKInjector.getInstance(GetRsgakukei.class);
        getRsgakukei.getPkakinsumiRsgaku(syoriCtl);

        realRyousyuuGaku = getRsgakukei.getRsgakukei();

        rsTuukaSyu = getRsgakukei.getTuukasyu();

        List<HT_Nyuukin> nyuukinLst = syoriCtl.getNyuukinsByZenhnknkbnNe(C_ZenhnknKbn.SUMI);

        if (nyuukinLst != null && nyuukinLst.size() > 0) {

            for (HT_Nyuukin nyuukin : nyuukinLst) {

                C_NyknsyubetuKbn nyknSyubetuKbn = nyuukin.getNyknsyubetu();

                if (C_NyknsyubetuKbn.KOUHURI.eq(nyknSyubetuKbn)) {
                    nyuuKinFlg = KBN_ARI ;
                    break;
                }

                nyuuKinFlg = KBN_NONE ;
            }
        }

        C_FstphrkkeiroKbn fstPHrkKeiro = mosKihon.getFstphrkkeirokbn();

        if (!C_SknnkaisikitkhukaKbn.HUKA.eq(sknnKaisikiTkHukaKbn) &&
            (C_SeirituKbn.NONE.eq(seirituKbn)
                || C_SeirituKbn.ITIPMATI.eq(seirituKbn))) {

            if (C_FstphrkkeiroKbn.KOUHURI.eq(fstPHrkKeiro)) {
                if(nyuuKinFlg == KBN_NONE){
                    setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                        new StringBuffer(MessageId.EHC0080).append(" ").append(
                            MessageUtil.getMessage(MessageId.EHC0080)).toString(), pMp);
                    if (logger.isDebugEnabled()) {
                        logger.debug("△ 入金チェック 終了");
                    }
                    return;
                }
            }
        }

        if (BizCurrency.valueOf(0, realRyousyuuGaku.getType()).compareTo(realRyousyuuGaku) < 0 &&
            !C_SknnkaisikitkhukaKbn.HUKA.eq(sknnKaisikiTkHukaKbn) &&
            C_SeirituKbn.NONE.eq(seirituKbn) &&
            C_FstphrkkeiroKbn.CREDIT.eq(fstPHrkKeiro)) {
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                new StringBuffer(MessageId.EHC0101).append(" ").append(
                    MessageUtil.getMessage(MessageId.EHC0101)).toString(), pMp);
            if (logger.isDebugEnabled()) {
                logger.debug("△ 入金チェック 終了");
            }
            return;
        }


        if (!BizUtil.isZero(realRyousyuuGaku) && !hrkTuukaSyu.eq(rsTuukaSyu)) {
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                new StringBuffer(MessageId.EHC1007).append(" ").append(
                    MessageUtil.getMessage(MessageId.EHC1007,
                        hrkTuukaSyu.getContent(),
                        rsTuukaSyu.getContent())).toString(), pMp);
            if (logger.isDebugEnabled()) {
                logger.debug("△ 入金チェック 終了");
            }
            return;
        }

        if (C_Hrkkaisuu.TUKI.eq(hrkkaisuu) &&
            (C_Hrkkeiro.KOUHURI.eq(hrkkeiro) || C_Hrkkeiro.CREDIT.eq(hrkkeiro)) &&
            C_IkkatubaraiKaisuuKbn.BLNK.eq(ikkatubaraikaisuu)) {
            BizDate kykymdnoNextMymd = kykymd.getNextMonth();

            kykymdnoNextMymd = kykymdnoNextMymd.getRekijyou();

            BizDateYM kykymdym = kykymd.getBizDateYM();

            if (C_Hrkkeiro.KOUHURI.eq(hrkkeiro)) {
                SetHurikaebi setHurikaebi = SWAKInjector.getInstance(SetHurikaebi.class);

                setHurikaebi.exec(kykymdnoNextMymd);

                annnaiTysytymdFirst = setHurikaebi.getTyokugoAnnaibi();

                annnaiTysytymdFirstYm = annnaiTysytymdFirst.getBizDateYM();


                setHurikaebi.exec(syoriymd);

                annnaiTysytymdSyoriymd = setHurikaebi.getTyokugoAnnaibi();

                annnaiTysytymdSyoriymdYm = annnaiTysytymdSyoriymd.getBizDateYM();
            }
            else {
                SetCreditUriageSeikyuubi setCreditUriageSeikyuubi =
                    SWAKInjector.getInstance(SetCreditUriageSeikyuubi.class);

                setCreditUriageSeikyuubi.exec(kykymdnoNextMymd);

                annnaiTysytymdFirst = setCreditUriageSeikyuubi.getJikaiUrsktysytbi();

                annnaiTysytymdFirstYm = annnaiTysytymdFirst.getBizDateYM();

                setCreditUriageSeikyuubi.exec(syoriymd);

                annnaiTysytymdSyoriymd = setCreditUriageSeikyuubi.getJikaiUrsktysytbi();

                annnaiTysytymdSyoriymdYm = annnaiTysytymdSyoriymd.getBizDateYM();
            }

            if (BizDateUtil.compareYm(kykymdym, syoriymd.getBizDateYM()) == BizDateUtil.COMPARE_LESSER ) {

                String ikkatuyouPWarningMsgId = "";

                if (C_Hrkkeiro.KOUHURI.eq(hrkkeiro) &&
                    BizCurrency.valueOf(0, realRyousyuuGaku.getType()).compareTo(realRyousyuuGaku) < 0) {
                    ikkatuyouPWarningMsgId = MessageId.WHC1019;
                }
                else if (C_Hrkkeiro.CREDIT.eq(hrkkeiro) &&
                    (C_FstphrkkeiroKbn.CREDIT.eq(fstPHrkKeiro) ||
                        (!C_FstphrkkeiroKbn.CREDIT.eq(fstPHrkKeiro) &&
                            BizCurrency.valueOf(0, realRyousyuuGaku.getType()).compareTo(realRyousyuuGaku) < 0))) {
                    ikkatuyouPWarningMsgId = MessageId.WHC1021;
                }

                if (!BizUtil.isBlank(ikkatuyouPWarningMsgId)) {

                    setHubiMsg.exec(C_KetsrhkosKbn.WARNING,
                        new StringBuffer(ikkatuyouPWarningMsgId).append(" ").append(
                            MessageUtil.getMessage(ikkatuyouPWarningMsgId,
                                DateFormatUtil.dateKANJISeireki(annnaiTysytymdFirst))).toString(), pMp);
                }
            }

            if (BizDateUtil.compareYm(annnaiTysytymdFirstYm, annnaiTysytymdSyoriymdYm) == BizDateUtil.COMPARE_LESSER &&
                (C_FstphrkkeiroKbn.CREDIT.eq(fstPHrkKeiro) || (!C_FstphrkkeiroKbn.CREDIT.eq(fstPHrkKeiro) &&
                    BizCurrency.valueOf(0, realRyousyuuGaku.getType()).compareTo(realRyousyuuGaku) < 0))) {
                int ikkatuyouPkaisuuKakunouNew = BizDateUtil.calcDifferenceMonths(annnaiTysytymdSyoriymdYm, kykymdym);

                if (1 < ikkatuyouPkaisuuKakunouNew) {
                    mosKihon.setIkkatuyoupumukbn(C_UmuKbn.ARI);

                    mosKihon.setIkkatuyoupkaisuu(ikkatuyouPkaisuuKakunouNew);

                    if (beforeCheckIkkatuyoupkaisuu != ikkatuyouPkaisuuKakunouNew) {
                        ikkatuyouptknKbnNew = C_IkkatuyouptknKbn.NONE;
                    }
                    else {
                        ikkatuyouptknKbnNew = beforeCheckIkkatuyouptknKbn;
                    }
                    if (C_IkkatuyouptknKbn.NONE.eq(ikkatuyouptknKbnNew)) {
                        setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                            new StringBuffer(MessageId.EHC1082).append(" ").append(
                                MessageUtil.getMessage(MessageId.EHC1082, "",
                                    DateFormatUtil.dateKANJISeireki(kykymd),
                                    DateFormatUtil.dateKANJISeireki(syoriymd))).toString(),
                                    pMp, C_TknKbn.KANOU);

                        syoriCtl.setNyuukinjoutaikbn(C_NyuukinjyoutaiKbn.MARUSIIKKATUYOU);

                        syokaiPkahusokuCheckFlg = C_UmuKbn.NONE;
                    }
                    else if (C_IkkatuyouptknKbn.SYOURYAKU.eq(ikkatuyouptknKbnNew)) {
                        setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                            new StringBuffer(MessageId.EHC1082).append(" ").append(
                                MessageUtil.getMessage(MessageId.EHC1082,
                                    "(" + ikkatuyouptknKbnNew.getContent() + ")",
                                    DateFormatUtil.dateKANJISeireki(kykymd),
                                    DateFormatUtil.dateKANJISeireki(syoriymd))).toString(),
                                    pMp, C_TknKbn.SUMI);
                    }
                    else if (C_IkkatuyouptknKbn.HEITYOU.eq(ikkatuyouptknKbnNew)) {
                        setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                            new StringBuffer(MessageId.EHC1082).append(" ").append(
                                MessageUtil.getMessage(MessageId.EHC1082,
                                    "(" + ikkatuyouptknKbnNew.getContent() + ")",
                                    DateFormatUtil.dateKANJISeireki(kykymd),
                                    DateFormatUtil.dateKANJISeireki(syoriymd))).toString(),
                                    pMp, C_TknKbn.SUMI);

                        if (C_FstphrkkeiroKbn.CREDIT.eq(fstPHrkKeiro)) {
                            syoriCtl.setNyuukinjoutaikbn(C_NyuukinjyoutaiKbn.RYOUSYUUGAKUSEITOU);
                            mosKihon.setSkjpjyuutoukaisuu(ikkatuyouPkaisuuKakunouNew);
                            syokaiPkahusokuCheckFlg = C_UmuKbn.NONE;
                        }
                        else {

                            KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean =
                                new KeisanIkkatuNyuukinGkSyouhnBean();
                            List<KeisanIkkatuNyuukinGkSyouhnBean> keisanIkkatuNyuukinGkSyouhnBeanLst =
                                new ArrayList<KeisanIkkatuNyuukinGkSyouhnBean>();
                            KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();

                            keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd(mosSyouhn.getSyouhncd());
                            keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(mosSyouhn.getSyouhnsdno());
                            keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo(mosSyouhn.getRyouritusdno());
                            keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(mosSyouhn.getYoteiriritu());
                            keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(mosKihon.getHeijyunp());
                            keisanIkkatuNyuukinGkSyouhnBeanLst.add(keisanIkkatuNyuukinGkSyouhnBean);

                            keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(
                                keisanIkkatuNyuukinGkSyouhnBeanLst);
                            keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.BLNK);
                            keisanIkkatuNyuukinGkBean.setRstuukasyu(mosKihon.getHrktuukasyu());
                            keisanIkkatuNyuukinGkBean.setJyutoustartYm(annnaiTysytymdFirstYm);

                            if (C_PtratkituukasiteiKbn.SITEITUUKA.eq(syouhnZokusei.getPtratkituukasiteikbn()) &&
                                !C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu()) &&
                                C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {

                                keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(ikkatuyouPkaisuuKakunouNew - 1);
                                keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
                                if (C_Hrkkeiro.KOUHURI.eq(hrkkeiro)) {
                                    keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.KZHRK);
                                }
                                else {
                                    keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.CREDIT);
                                }
                                keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(syoriymd);
                            }
                            else {
                                keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(ikkatuyouPkaisuuKakunouNew);
                                keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.SYOKAIP);
                                keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.SKEI);
                                keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(syoriCtl.getRyosyuymd());
                            }

                            C_ErrorKbn errorKbn = keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean, true);
                            if (C_ErrorKbn.OK.eq(errorKbn)) {

                                if (C_PtratkituukasiteiKbn.SITEITUUKA.eq(syouhnZokusei.getPtratkituukasiteikbn()) &&
                                    !C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu()) &&
                                    C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {

                                    hituyouikkayouPkakunou = hrkTuukaHeijyunP.add(
                                        keisanTukiIkkatuNyuukinGk.getIktnyknkgk());

                                    mosKihon.setIkkatuyoupgkkeizokup(keisanTukiIkkatuNyuukinGk.getIktnyknkgk());
                                    mosKihon.setKeizokuptkykwsratekjymd(
                                        keisanTukiIkkatuNyuukinGk.getRyosyuKwsRateKjYmd());
                                    mosKihon.setKeizokuptkykwsrate(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRate());
                                }
                                else {
                                    hituyouikkayouPkakunou = keisanTukiIkkatuNyuukinGk.getIktnyknkgk();
                                }
                            }
                            else {
                                throw new CommonBizAppException("月払一括入金額計算異常 申込番号：" +
                                    syoriCtl.getMosno());
                            }

                            if (hituyouikkayouPkakunou.compareTo(realRyousyuuGaku) == 0) {
                                mosKihon.setSkjpjyuutoukaisuu(ikkatuyouPkaisuuKakunouNew);

                                syokaiPkahusokuCheckFlg = C_UmuKbn.NONE;

                                syoriCtl.setNyuukinjoutaikbn(C_NyuukinjyoutaiKbn.RYOUSYUUGAKUSEITOU);
                            }
                            else if (realRyousyuuGaku.compareTo(hituyouikkayouPkakunou) < 0) {
                                kahusokuKinngakuKakunou = hituyouikkayouPkakunou.subtract(realRyousyuuGaku);

                                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                                    new StringBuffer(MessageId.EHC0057).append(" ").append(
                                        MessageUtil.getMessage(MessageId.EHC0057,
                                            ViewReport.editCommaTuukaNoSpace(kahusokuKinngakuKakunou,
                                                BizUtil.ZERO_FILL))).toString(), pMp);

                                syokaiPkahusokuCheckFlg = C_UmuKbn.NONE;

                                syoriCtl.setNyuukinjoutaikbn(C_NyuukinjyoutaiKbn.MARUSIIKKATUYOU);
                            }
                            else {
                                kahusokuKinngakuKakunou = realRyousyuuGaku.subtract(hituyouikkayouPkakunou);

                                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                                    new StringBuffer(MessageId.EHC0058).append(" ").append(
                                        MessageUtil.getMessage(MessageId.EHC0058,
                                            ViewReport.editCommaTuukaNoSpace(kahusokuKinngakuKakunou,
                                                BizUtil.ZERO_FILL))).toString(), pMp);

                                syokaiPkahusokuCheckFlg = C_UmuKbn.NONE;

                                syoriCtl.setNyuukinjoutaikbn(C_NyuukinjyoutaiKbn.SEIRITUHORYUU_KAKIN);
                            }
                        }
                    }
                }
            }
        }
        if (tokunin != null) {
            tokunin.setIkkatuyouptknkbn(ikkatuyouptknKbnNew);
        }

        if (C_UmuKbn.ARI.eq(syokaiPkahusokuCheckFlg)) {
            if (C_FstphrkkeiroKbn.CREDIT.eq(fstPHrkKeiro)) {
                syoriCtl.setNyuukinjoutaikbn(C_NyuukinjyoutaiKbn.RYOUSYUUGAKUSEITOU);
                mosKihon.setSkjpjyuutoukaisuu(1);
            }
            else {

                if (BizUtil.isZero(realRyousyuuGaku)) {
                    realRyousyuuGaku = BizCurrency.valueOf(0, fstPHrkGk.getType());
                }

                if (fstPHrkGk.compareTo(realRyousyuuGaku) > 0) {
                    syoriCtl.setNyuukinjoutaikbn(C_NyuukinjyoutaiKbn.SEIRITUHORYUU_HUSOKUKIN);

                    if (!C_SknnkaisikitkhukaKbn.HUKA.eq(sknnKaisikiTkHukaKbn)) {
                        setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                            new StringBuffer(MessageId.EHC0057).append(" ").append(
                                MessageUtil.getMessage(MessageId.EHC0057,
                                    ViewReport.editCommaTuukaNoSpace(fstPHrkGk.subtract(realRyousyuuGaku),
                                        BizUtil.ZERO_FILL))).toString(), pMp);
                    }
                    else {
                        setHubiMsg.exec(C_KetsrhkosKbn.WARNING,
                            new StringBuffer(MessageId.WHC0098).append(" ").append(
                                MessageUtil.getMessage(MessageId.WHC0098,
                                    ViewReport.editCommaTuukaNoSpace(fstPHrkGk.subtract(realRyousyuuGaku),
                                        BizUtil.ZERO_FILL))).toString(),
                                        pMp, C_TknKbn.NONE, C_MsgKbn.WARNING);
                    }
                }
                else if (realRyousyuuGaku.compareTo(fstPHrkGk) > 0) {
                    syoriCtl.setNyuukinjoutaikbn(C_NyuukinjyoutaiKbn.SEIRITUHORYUU_KAKIN);

                    if (!C_SknnkaisikitkhukaKbn.HUKA.eq(sknnKaisikiTkHukaKbn)) {
                        setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                            new StringBuffer(MessageId.EHC0058).append(" ").append(
                                MessageUtil.getMessage(MessageId.EHC0058,
                                    ViewReport.editCommaTuukaNoSpace(realRyousyuuGaku.subtract(fstPHrkGk),
                                        BizUtil.ZERO_FILL))).toString(), pMp);
                    }
                    else {
                        setHubiMsg.exec(C_KetsrhkosKbn.WARNING,
                            new StringBuffer(MessageId.WHC0099).append(" ").append(
                                MessageUtil.getMessage(MessageId.WHC0099,
                                    ViewReport.editCommaTuukaNoSpace(realRyousyuuGaku.subtract(fstPHrkGk),
                                        BizUtil.ZERO_FILL))).toString(),
                                        pMp, C_TknKbn.NONE, C_MsgKbn.WARNING);
                    }
                }
                else {
                    syoriCtl.setNyuukinjoutaikbn(C_NyuukinjyoutaiKbn.RYOUSYUUGAKUSEITOU);

                    mosKihon.setSkjpjyuutoukaisuu(1);
                }
            }
        }
        if (C_SeirituKbn.NONE.eq(seirituKbn)
            || C_SeirituKbn.ITIPMATI.eq(seirituKbn)) {

            BizDate rsYmd = syoriCtl.getRyosyuymd();
            if (rsYmd != null) {

                BizDate itipRsYmd = mosKihon.getItiprsymd();

                if (C_FstphrkkeiroKbn.KOUHURI.eq(fstPHrkKeiro)
                    && nyuuKinFlg == KBN_ARI
                    && rsYmd.compareTo(itipRsYmd) != 0) {

                    setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                        new StringBuffer(MessageId.EHC0079).append(" ").append(
                            MessageUtil.getMessage(MessageId.EHC0079, DateFormatUtil.dateDOT(rsYmd.toString()),
                                DateFormatUtil.dateDOT(itipRsYmd.toString()))).toString(), pMp);
                }
            }

        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 入金チェック 終了");
        }
    }
}