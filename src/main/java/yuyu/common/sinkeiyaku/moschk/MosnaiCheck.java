package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizEntityUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_IkkatuyouptknKbn;
import yuyu.def.classification.C_ImusateijyouKbn;
import yuyu.def.classification.C_JimusrhKbn;
import yuyu.def.classification.C_KakoymdkyytknKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KetteiyouhiKbn;
import yuyu.def.classification.C_KnkysateijyouKbn;
import yuyu.def.classification.C_KouzokujkKbn;
import yuyu.def.classification.C_KykkakjkKbn;
import yuyu.def.classification.C_KzmeigitknKbn;
import yuyu.def.classification.C_MassitknKbn;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_NenkkntknKbn;
import yuyu.def.classification.C_NenreiuptknKbn;
import yuyu.def.classification.C_SaiteiptknKbn;
import yuyu.def.classification.C_SentakuinfotknKbn;
import yuyu.def.classification.C_SignalkaihiKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SonotaTokuninKbn;
import yuyu.def.classification.C_SpKeisanKahiKbn;
import yuyu.def.classification.C_SpgndtknKbn;
import yuyu.def.classification.C_SyorisimetknKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyssrhKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_TsngndtknKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YoteiriritutknKbn;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_Tokunin;

/**
 * 新契約 申込内容チェック 申込内容チェック
 */
public class MosnaiCheck {

    @Inject
    private static Logger logger;

    @Inject
    private JidouSetSyokika jidouSetSyokika;

    @Inject
    private Nayose nayose;

    @Inject
    private SetKisoKoumoku setKisoKoumoku;

    @Inject
    private CheckTblMosKihon checkTblMosKihon;

    @Inject
    private CheckTblMosSyouhin checkTblMosSyouhin;

    @Inject
    private CheckTblUketorinin checkTblUketorinin;

    @Inject
    private CheckTblMosDairiten checkTblMosDairiten;

    @Inject
    private CheckSentakujyouhou checkSentakujyouhou;

    //    @Inject
    //    private CheckSekininKaisikiTk checkSekininKaisikiTk;

    @Inject
    private CheckFatca checkFatca;

    @Inject
    private CheckTblKouzaJyouhou checkTblKouzaJyouhou;

    @Inject
    private CheckTblCreditCardInfo checkTblCreditCardInfo;

    @Inject
    private CheckTblKokutisyo checkTblKokutisyo;

    //    @Inject
    //    private CheckTblHoujyou checkTblHoujyou;

    @Inject
    private SetSP setSp;

    @Inject
    private CheckSP checkSp;

    @Inject
    private CheckSkTuusan checkSkTuusan;

    @Inject
    private HanteiKykKakunin hanteiKykKakunin;

    @Inject
    private HanteiLINC hanteiLinc;

    @Inject
    private HanteiLINCjyusinkekka hanteiLincjyusinkekka;

    @Inject
    private SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei;

    @Inject
    private Kettei kettei;

    //    @Inject
    //    private AuthoriKakuninHantei authoriKakuninHantei;

    @Inject
    private CheckNyuukin checkNyuukin;

    @Inject
    private CheckHubiKanri checkHubiKanri;

    @Inject
    private CheckSeirituHoryuu checkSeirituHoryuu;

    @Inject
    private SetSateijt setSateijt;

    @Inject
    private Seiritu seiritu;

    //    @Inject
    //    private HanteiSaiho hanteiSaiho;

    //    @Inject
    //    private CheckAuthoriJk checkAuthoriJk;

    @Inject
    private EditPrintFile editPrintFile;

    @Inject
    private HanteiHituyouSyorui hanteiHituyouSyorui;

    @Inject
    private  SetHubiMsg setHubiMsg;

    @Inject
    private CheckYakkanJyuryouHouhou checkYakkanJyuryouHouhou;

    public MosnaiCheck() {
        super();

    }

    public void exec(MosnaiCheckParam pMp) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 申込内容チェック 開始");
        }

        jidouSetSyokika.exec(pMp);

        if (C_UmuKbn.ARI.eq(pMp.getDataSyoriControl().getMosnrkumu())) {
            setKisoKoumoku.exec(pMp);
            if (C_KouzokujkKbn.NONE.eq(pMp.getKouzokuSyoriJikkouKbn())) {

                if (logger.isDebugEnabled()) {
                    logger.debug("△ 申込内容チェック 終了");
                }

                return;
            }
        }

        if (C_UmuKbn.ARI.eq(pMp.getDataSyoriControl().getMosnrkumu())) {
            checkTblMosDairiten.exec(pMp);
        }

        if (C_UmuKbn.ARI.eq(pMp.getDataSyoriControl().getMosnrkumu())) {
            nayose.exec(pMp);
        }

        if (C_UmuKbn.ARI.eq(pMp.getDataSyoriControl().getMosnrkumu())) {
            checkTblMosKihon.exec(pMp);
        }

        if (C_UmuKbn.ARI.eq(pMp.getDataSyoriControl().getMosnrkumu())) {
            checkTblMosSyouhin.exec(pMp);
        }

        if (C_UmuKbn.ARI.eq(pMp.getDataSyoriControl().getMosnrkumu())) {
            checkTblUketorinin.exec(pMp);
        }

        if (C_UmuKbn.ARI.eq(pMp.getDataSyoriControl().getMosnrkumu())) {
            checkSentakujyouhou.exec(pMp);
        }

        //        if (C_UmuKbn.ARI.eq(pMp.getDataSyoriControl().getMosnrkumu())) {
        //            checkSekininKaisikiTk.exec(pMp);
        //        }

        if (C_UmuKbn.ARI.eq(pMp.getDataSyoriControl().getMosnrkumu())) {
            checkYakkanJyuryouHouhou.exec(pMp);
        }

        if (C_UmuKbn.ARI.eq(pMp.getDataSyoriControl().getMosnrkumu())) {
            checkFatca.exec(pMp);
        }

        if (C_UmuKbn.ARI.eq(pMp.getDataSyoriControl().getMosnrkumu())) {
            checkTblKouzaJyouhou.exec(pMp);
        }

        if (C_UmuKbn.ARI.eq(pMp.getDataSyoriControl().getMosnrkumu())) {
            checkTblCreditCardInfo.exec(pMp);
        }

        if (C_UmuKbn.ARI.eq(pMp.getDataSyoriControl().getNyknnrkumu())) {

            CheckTblNyuukinHenkin checkTblNyuukinHenkin = SWAKInjector.getInstance(CheckTblNyuukinHenkin.class);

            checkTblNyuukinHenkin.exec(pMp);
        }

        if (C_UmuKbn.ARI.eq(pMp.getDataSyoriControl().getKktnrkumu())) {
            checkTblKokutisyo.exec(pMp);
        }

        //        if (C_UmuKbn.ARI.eq(pMp.getDataSyoriControl().getHjynrkumu())) {
        //            checkTblHoujyou.exec(pMp);
        //        }

        if (C_UmuKbn.ARI.eq(pMp.getDataSyoriControl().getMosnrkumu())) {
            if (C_UmuKbn.NONE.eq(pMp.getDataSyoriControl().getKthhbkbn())
                || (C_UmuKbn.ARI.eq(pMp.getDataSyoriControl().getKthhbkbn())
                    && !C_SpKeisanKahiKbn.SPKEISANHUKA.equals(pMp.getKthjiSpKeisanKahiKbn()))) {
                setSp.exec(pMp);
            }
            else {
                if (C_SysKbn.SKEI.eq(pMp.getSysKbn())) {
                    String msg = MessageId.WHC1014 + " " + MessageUtil.getMessage(MessageId.WHC1014);

                    setHubiMsg.exec(C_KetsrhkosKbn.WARNING, msg, pMp, C_TknKbn.NONE, C_MsgKbn.WARNING);
                }
            }
        }

        if (C_UmuKbn.ARI.eq(pMp.getDataSyoriControl().getMosnrkumu())
            && (C_UmuKbn.NONE.eq(pMp.getDataSyoriControl().getKthhbkbn())
                || (C_UmuKbn.ARI.eq(pMp.getDataSyoriControl().getKthhbkbn())
                    && !C_SpKeisanKahiKbn.SPKEISANHUKA.equals(pMp.getKthjiSpKeisanKahiKbn())))) {
            checkSp.exec(pMp);
        }

        if (C_UmuKbn.ARI.eq(pMp.getDataSyoriControl().getMosnrkumu())
            && (C_UmuKbn.NONE.eq(pMp.getDataSyoriControl().getKthhbkbn())
                ||(C_UmuKbn.ARI.eq(pMp.getDataSyoriControl().getKthhbkbn())
                    && !C_SpKeisanKahiKbn.SPKEISANHUKA.equals(pMp.getKthjiSpKeisanKahiKbn())))) {
            checkSkTuusan.exec(pMp);
        }

        if (C_UmuKbn.ARI.eq(pMp.getDataSyoriControl().getMosnrkumu()) &&
            (C_KykkakjkKbn.NONE.eq(pMp.getDataSyoriControl().getKykkakjkkbn()) ||
                C_KykkakjkKbn.KETMAE_KAKUNIN_TAISY.eq(pMp.getDataSyoriControl().getKykkakjkkbn())) &&
                C_UmuKbn.NONE.eq(pMp.getDataSyoriControl().getKthhbkbn())) {
            hanteiKykKakunin.exec(pMp);
        }

        if (C_UmuKbn.ARI.eq(pMp.getDataSyoriControl().getMosnrkumu())) {
            hanteiLinc.exec(pMp);
        }

        if (C_UmuKbn.ARI.eq(pMp.getDataSyoriControl().getMosnrkumu())) {
            hanteiLincjyusinkekka.exec(pMp);
        }

        if (C_UmuKbn.ARI.eq(pMp.getDataSyoriControl().getMosnrkumu())) {
            sateiKetteiJissiRuleHantei.exec(pMp);
        }


        if (C_UmuKbn.ARI.eq(pMp.getDataSyoriControl().getMosnrkumu()) &&
            isExecKetteiSatei(pMp) &&
            (!C_MostenkenjyouKbn.TENKENMATI_1.eq(pMp.getDataSyoriControl().getMostenkenjoukbn()) &&
                !C_MostenkenjyouKbn.TENKENMATI_2.eq(pMp.getDataSyoriControl().getMostenkenjoukbn()) &&
                !C_MostenkenjyouKbn.TENKENMATI_HUBI.eq(pMp.getDataSyoriControl().getMostenkenjoukbn())) &&
                (!C_KnkysateijyouKbn.SATEIMATI_1.eq(pMp.getDataSyoriControl().getKnkysateijyoukbn()) &&
                    !C_KnkysateijyouKbn.SATEIMATI_2A.eq(pMp.getDataSyoriControl().getKnkysateijyoukbn()) &&
                    !C_KnkysateijyouKbn.SATEIMATI_2B.eq(pMp.getDataSyoriControl().getKnkysateijyoukbn())) &&
                    (!C_ImusateijyouKbn.SATEIMATI_KANI_UW.eq(pMp.getDataSyoriControl().getImusateijyoukbn()) &&
                        !C_ImusateijyouKbn.SATEIMATI_KANI_MD.eq(pMp.getDataSyoriControl().getImusateijyoukbn())) &&
                        (!C_KykkakjkKbn.KETMAE_KAKUNIN.eq(pMp.getDataSyoriControl().getKykkakjkkbn()) &&
                            !C_KykkakjkKbn.KETHORYU_KAKUNIN.eq(pMp.getDataSyoriControl().getKykkakjkkbn())) &&
                            C_UmuKbn.NONE.eq(pMp.getDataSyoriControl().getKthhbkbn()) &&
                            C_KetteiyouhiKbn.YOU.eq(pMp.getKetteiYouhiKbn())) {
            kettei.exec(pMp);
        }

        //        if (C_UmuKbn.ARI.eq(pMp.getDataSyoriControl().getMosnrkumu())) {
        //            authoriKakuninHantei.exec(pMp);
        //        }

        HT_MosKihon mosKihon = pMp.getDataSyoriControl().getMosKihon();

        if (C_UmuKbn.ARI.eq(pMp.getDataSyoriControl().getMosnrkumu())
            && (C_UmuKbn.ARI.eq(pMp.getDataSyoriControl().getNyknnrkumu())
                || (mosKihon != null && C_FstphrkkeiroKbn.CREDIT.eq(mosKihon.getFstphrkkeirokbn())))
                && (C_UmuKbn.NONE.eq(pMp.getDataSyoriControl().getKthhbkbn())
                    || (C_UmuKbn.ARI.eq(pMp.getDataSyoriControl().getKthhbkbn())
                        && !C_SpKeisanKahiKbn.SPKEISANHUKA.equals(pMp.getKthjiSpKeisanKahiKbn())))) {
            checkNyuukin.exec(pMp);
        }

        checkHubiKanri.exec(pMp);

        hanteiHituyouSyorui.exec(pMp);

        if (C_UmuKbn.ARI.eq(pMp.getDataSyoriControl().getMosnrkumu())) {
            checkSeirituHoryuu.exec(pMp);
        }


        if (C_UmuKbn.ARI.eq(pMp.getDataSyoriControl().getMosnrkumu()) &&
            isExecKetteiSatei(pMp) &&
            (!C_MostenkenjyouKbn.TENKENMATI_1.eq(pMp.getDataSyoriControl().getMostenkenjoukbn()) &&
                !C_MostenkenjyouKbn.TENKENMATI_2.eq(pMp.getDataSyoriControl().getMostenkenjoukbn()) &&
                !C_MostenkenjyouKbn.TENKENMATI_HUBI.eq(pMp.getDataSyoriControl().getMostenkenjoukbn())) &&
                (!C_KnkysateijyouKbn.SATEIMATI_1.eq(pMp.getDataSyoriControl().getKnkysateijyoukbn()) &&
                    !C_KnkysateijyouKbn.SATEIMATI_2A.eq(pMp.getDataSyoriControl().getKnkysateijyoukbn()) &&
                    !C_KnkysateijyouKbn.SATEIMATI_2B.eq(pMp.getDataSyoriControl().getKnkysateijyoukbn())) &&
                    (!C_ImusateijyouKbn.SATEIMATI_KANI_UW.eq(pMp.getDataSyoriControl().getImusateijyoukbn()) &&
                        !C_ImusateijyouKbn.SATEIMATI_KANI_MD.eq(pMp.getDataSyoriControl().getImusateijyoukbn())) &&
                        (!C_KykkakjkKbn.KETMAE_KAKUNIN.eq(pMp.getDataSyoriControl().getKykkakjkkbn()) &&
                            !C_KykkakjkKbn.KETHORYU_KAKUNIN.eq(pMp.getDataSyoriControl().getKykkakjkkbn())) &&
                            C_UmuKbn.NONE.eq(pMp.getDataSyoriControl().getKthhbkbn())) {
            setSateijt.exec(pMp);
        }

        if (C_KetteiKbn.KETTEI_SUMI.eq(pMp.getDataSyoriControl().getKetteikbn()) &&
            C_UmuKbn.NONE.eq(pMp.getDataSyoriControl().getSrhhbkbn()) &&
            C_JimusrhKbn.NONE.eq(pMp.getDataSyoriControl().getJimusrhkbn()) &&
            C_SyssrhKbn.NONE.eq(pMp.getDataSyoriControl().getSyssrhkbn())) {
            seiritu.exec(pMp);
        }

        //        if (C_SeirituKbn.SEIRITU.eq(pMp.getDataSyoriControl().getSeiritukbn())) {
        //            hanteiSaiho.exec(pMp);
        //        }

        //        if (C_UmuKbn.ARI.eq(pMp.getDataSyoriControl().getMosnrkumu())) {
        //            checkAuthoriJk.exec(pMp);
        //        }

        editPrintFile.exec(pMp);

        pMp.getDataSyoriControl().setGyoumuKousinTime(pMp.getKosTime());

        pMp.getDataSyoriControl().setGyoumuKousinsyaId(pMp.getKosID());

        if (mosKihon != null) {

            mosKihon.setGyoumuKousinTime(pMp.getKosTime());

            mosKihon.setGyoumuKousinsyaId(pMp.getKosID());
        }

        if (pMp.getListHubiMsg() != null && pMp.getListHubiMsg().size() > 0) {

            List<HT_HubiMsg> listHubiMsg = pMp.getDataSyoriControl().getHubiMsgs();

            BizEntityUtil.exchange(listHubiMsg, pMp.getListHubiMsg());
        }
        else {

            List<HT_HubiMsg> listHubiMsg = pMp.getDataSyoriControl().getHubiMsgs();

            if (listHubiMsg != null && listHubiMsg.size() > 0) {

                listHubiMsg.clear();
            }
        }

        HT_Tokunin tokunin = pMp.getDataSyoriControl().getTokunin();

        if (tokunin != null) {

            if (C_SpgndtknKbn.NONE.eq(tokunin.getSpgndtknkbn()) && C_KakoymdkyytknKbn.NONE.eq(tokunin.getKakoymdkyytknkbn())
                && C_NenkkntknKbn.NONE.eq(tokunin.getNenkkntknkbn()) && C_SaiteiptknKbn.NONE.eq(tokunin.getSaiteiptknkbn())
                && C_TsngndtknKbn.NONE.eq(tokunin.getTsngndtknkbn()) && C_YoteiriritutknKbn.NONE.eq(tokunin.getYoteiriritutknkbn())
                && C_SentakuinfotknKbn.NONE.eq(tokunin.getSentakuinfotknkbn()) && C_NenreiuptknKbn.NONE.eq(tokunin.getNenreiuptknkbn())
                && C_SyorisimetknKbn.NONE.eq(tokunin.getSyorisimetknkbn()) && C_IkkatuyouptknKbn.NONE.eq(tokunin.getIkkatuyouptknkbn())
                && C_KzmeigitknKbn.NONE.eq(tokunin.getKzmeigitknkbn()) && C_SignalkaihiKbn.NONE.eq(tokunin.getSignalkaihikbn())
                && C_MassitknKbn.NONE.eq(tokunin.getMassitknkbn()) && C_SonotaTokuninKbn.NONE.eq(tokunin.getSonotatknkbn())) {

                pMp.getDataSyoriControl().setTokunin(null);
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 申込内容チェック 終了");
        }
    }

    private boolean isExecKetteiSatei(MosnaiCheckParam pMp) {

        boolean retValue = true;

        HT_MosKihon mosKihon = pMp.getDataSyoriControl().getMosKihon();

        if (mosKihon == null) {
            retValue = false;
        }
        else {
            if ((C_SntkhouKbn.NONE.eq(mosKihon.getSntkhoukbn()))
                || (C_SntkhouKbn.SYOKUGYOU.eq(mosKihon.getSntkhoukbn()))) {
                retValue = true;
            }
            else if (C_SntkhouKbn.HJY.eq(mosKihon.getSntkhoukbn())) {
                if (C_UmuKbn.ARI.eq(pMp.getDataSyoriControl().getHjynrkumu())) {
                    retValue = true;
                }
                else {
                    retValue = false;
                }
            }
            else if (C_SntkhouKbn.KKT.eq(mosKihon.getSntkhoukbn())) {
                if (C_UmuKbn.ARI.eq(pMp.getDataSyoriControl().getKktnrkumu())) {
                    retValue = true;
                }
                else {
                    retValue = false;
                }
            }
            else {
                retValue = false;
            }
        }
        return retValue;
    }
}