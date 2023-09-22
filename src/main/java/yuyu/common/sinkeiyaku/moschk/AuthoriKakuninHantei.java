package yuyu.common.sinkeiyaku.moschk;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

import org.slf4j.Logger;

import yuyu.def.classification.C_AuthorijkKbn;
import yuyu.def.classification.C_CardinfohnkKbn;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 新契約 申込内容チェック オーソリ確認判定
 */
public class AuthoriKakuninHantei {

    private static final int AUTHORITAISYOKBN_TAISYO    = 1;
    private static final int AUTHORITAISYOKBN_TAISYOGAI = 2;

    @Inject
    private static Logger logger;

    public AuthoriKakuninHantei() {
        super();
    }

    public void exec(MosnaiCheckParam pMp) {

        HT_SyoriCTL       syoriCtl;
        C_UmuKbn          mosNrkUmu;
        C_UmuKbn          creditNrkUmu;
        C_KahiKbn         syoriAuthoriSousinKhKbn;
        C_AuthorijkKbn    syoriAuthoriJkKbn;
        C_CardinfohnkKbn  cardInfoHnkKbn;
        BizDate           syoriFstAuthoriKanryoYmd;
        BizDate           kbtAuthoriTrkymd;
        HT_MosKihon       mosKihon;
        BizCurrency       fstPHrkGk;
        BizCurrency       mosFstPKei;
        C_FstphrkkeiroKbn fstPHrkKeiro;
        C_UmuKbn          creditCardInfoTblChkErrUmu;
        int               authoriTaisyoKbn;
        C_KahiKbn         authoriSousinKhKbn;
        C_AuthorijkKbn    authoriJkKbn;
        BizCurrency       authoriGk;
        BizDate           fstAuthoriKanryoYmd;

        if (logger.isDebugEnabled()) {
            logger.debug("▽ オーソリ確認判定 開始");
        }

        syoriCtl = pMp.getDataSyoriControl();
        mosNrkUmu = syoriCtl.getMosnrkumu();

        // TODO テーブル物理削除と処理コントロール論理削除項目対応
        //        creditNrkUmu = syoriCtl.getCreditnrkumu();
        //        syoriAuthoriSousinKhKbn = syoriCtl.getAuthorisousinkhkbn();
        //        syoriAuthoriJkKbn = syoriCtl.getAuthorijkkbn();
        //        cardInfoHnkKbn = syoriCtl.getCardinfohnkkbn();
        //        syoriFstAuthoriKanryoYmd = syoriCtl.getFstauthorikanryoymd();
        //        kbtAuthoriTrkymd = syoriCtl.getKbtauthoritrkymd();

        mosKihon = syoriCtl.getMosKihon();
        fstPHrkGk = mosKihon.getFstphrkgk();
        mosFstPKei = mosKihon.getMosfstpkei();
        fstPHrkKeiro = mosKihon.getFstphrkkeirokbn();

        creditCardInfoTblChkErrUmu = pMp.getCreditCardInfoTblChkErrUmu();

        // TODO テーブル物理削除と処理コントロール論理削除項目対応
        //        authoriSousinKhKbn = syoriAuthoriSousinKhKbn;
        //        authoriJkKbn = syoriAuthoriJkKbn;
        //        fstAuthoriKanryoYmd  = syoriFstAuthoriKanryoYmd;

        if (C_UmuKbn.ARI.eq(mosNrkUmu) &&
            C_FstphrkkeiroKbn.CREDIT.eq(fstPHrkKeiro)) {

            authoriTaisyoKbn = AUTHORITAISYOKBN_TAISYO;
        }
        else {
            authoriTaisyoKbn = AUTHORITAISYOKBN_TAISYOGAI;
        }

        // TODO テーブル物理削除と処理コントロール論理削除項目対応
        //        if ((C_UmuKbn.ARI.eq(mosNrkUmu)) &&
        //            (fstPHrkGk.compareTo(BizCurrency.valueOf(0)) > 0) &&
        //            (C_FstphrkkeiroKbn.CREDIT.eq(fstPHrkKeiro)) &&
        //            (C_UmuKbn.ARI.eq(creditNrkUmu)) &&
        //            (C_UmuKbn.NONE.eq(creditCardInfoTblChkErrUmu))) {
        //
        //            authoriSousinKhKbn = C_KahiKbn.KA;
        //        }
        //        else {
        //            authoriSousinKhKbn = C_KahiKbn.HUKA;
        //        }
        //
        //        if (AUTHORITAISYOKBN_TAISYO == authoriTaisyoKbn ) {
        //
        //            if (C_AuthorijkKbn.HUYOU.eq(syoriAuthoriJkKbn)) {
        //                authoriJkKbn = C_AuthorijkKbn.IRAIMATI;
        //            }
        //            else if (C_AuthorijkKbn.OK.eq(syoriAuthoriJkKbn)) {
        //
        //                if (C_CardinfohnkKbn.HNKARI.eq(cardInfoHnkKbn)) {
        //                    authoriJkKbn = C_AuthorijkKbn.IRAIMATI;
        //                }
        //                else if (C_CardinfohnkKbn.HNKNONE.eq(cardInfoHnkKbn)) {
        //                    authoriGk = BizCurrency.valueOf(0);
        //
        //                    authoriGk = syoriCtl.getAuthoriRirekiSumAuthorigkByAuthorikanryoymd(
        //                        syoriFstAuthoriKanryoYmd,
        //                        C_AuthorijkKbn.OK,
        //                        C_SaiauthoriKbn.NOSAIAUTHORI,
        //                        C_SaiauthoriKbn.AFTSAIAUTHORI).get(BizCurrencyTypes.YEN);
        //
        //                    if (authoriGk.compareTo(mosFstPKei) < 0) {
        //                        authoriJkKbn = C_AuthorijkKbn.IRAIMATI;
        //                    }
        //                }
        //            }
        //            else if (C_AuthorijkKbn.NG.eq(syoriAuthoriJkKbn)){
        //
        //                if (C_CardinfohnkKbn.HNKARI.eq(cardInfoHnkKbn)) {
        //                    authoriJkKbn = C_AuthorijkKbn.IRAIMATI;
        //                }
        //            }
        //        }
        //        else if (AUTHORITAISYOKBN_TAISYOGAI == authoriTaisyoKbn) {
        //
        //            if ((C_AuthorijkKbn.HUYOU.eq(syoriAuthoriJkKbn)) ||
        //                (C_AuthorijkKbn.IRAIMATI.eq(syoriAuthoriJkKbn)) ||
        //                (C_AuthorijkKbn.NG.eq(syoriAuthoriJkKbn)) ||
        //                ((C_AuthorijkKbn.OK.eq(syoriAuthoriJkKbn)) &&
        //                    (kbtAuthoriTrkymd == null))) {
        //
        //                authoriJkKbn = C_AuthorijkKbn.HUYOU;
        //                fstAuthoriKanryoYmd = null;
        //            }
        //        }
        //
        //        syoriCtl.setAuthorisousinkhkbn(authoriSousinKhKbn);
        //        syoriCtl.setAuthorijkkbn(authoriJkKbn);
        //        syoriCtl.setFstauthorikanryoymd(fstAuthoriKanryoYmd);

        pMp.setDataSyoriControl(syoriCtl);

        if (logger.isDebugEnabled()) {
            logger.debug("△ オーソリ確認判定 終了");
        }
    }
}