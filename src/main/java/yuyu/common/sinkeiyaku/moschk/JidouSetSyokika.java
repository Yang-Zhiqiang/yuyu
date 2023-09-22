package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_IkkatuyouptknKbn;
import yuyu.def.classification.C_NyuukinjyoutaiKbn;
import yuyu.def.classification.C_PWaribikitekiyouKbn;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Tokunin;

/**
 * 新契約 申込内容チェック 自動設定項目初期化
 */
public class JidouSetSyokika {

    @Inject
    private static Logger logger;

    public JidouSetSyokika() {
        super();
    }

    public void exec(MosnaiCheckParam pMP) {
        if (logger.isDebugEnabled()) {
            logger.debug("▽ 自動設定項目初期化 開始");
        }

        HT_SyoriCTL syoriControl = pMP.getDataSyoriControl();
        syoriControl.setKthhbkbn(C_UmuKbn.NONE);
        syoriControl.setSrhhbkbn(C_UmuKbn.NONE);
        syoriControl.setNyuukinjoutaikbn(C_NyuukinjyoutaiKbn.SONOTA_MINYUUKIN);
        syoriControl.setKktymd(null);
        syoriControl.setRyosyuymd(null);
        syoriControl.setNyknkwsrate(BizNumber.valueOf(0));
        syoriControl.setNyknkwsratekijyunymd(null);
        syoriControl.setDoujimosumu(C_UmuKbn.NONE);
        syoriControl.setPaldoujimosumu(C_UmuKbn.NONE);
        syoriControl.setRaydoujimosumu(C_UmuKbn.NONE);
        syoriControl.setGyoumuKousinsyaId(pMP.getKosID());
        syoriControl.setGyoumuKousinTime(pMP.getKosTime());
        CurrencyType kykTuukaType = null;
        CurrencyType hrkTuukaType = null;

        HT_MosKihon mosKihon = syoriControl.getMosKihon();

        if (mosKihon != null) {

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
            kykTuukaType = henkanTuuka.henkanTuukaKbnToType(mosKihon.getKyktuukasyu());
            hrkTuukaType = henkanTuuka.henkanTuukaKbnToType(mosKihon.getHrktuukasyu());
            pMP.setBeforeCheckIkkatuyoupkaisuu(mosKihon.getIkkatuyoupkaisuu());
            if(C_SysKbn.SKEI.eq(pMP.getSysKbn())){
                mosKihon.setKykymd(null);
            }
            mosKihon.setSknnkaisiymd(null);
            mosKihon.setBosyuuym(null);
            mosKihon.setSeisekiym(null);
            mosKihon.setSkeikeijyouym(null);
            mosKihon.setHhknnen(0);
            mosKihon.setKyknen(0);
            mosKihon.setHeijyunp(BizCurrency.valueOf(0, hrkTuukaType));
            mosKihon.setHeijyunpryoumasinasi(BizCurrency.valueOf(0, hrkTuukaType));
            mosKihon.setHrktuukaheijyunp(BizCurrency.valueOf(0, hrkTuukaType));
            mosKihon.setIkkatup(BizCurrency.valueOf(0, hrkTuukaType));
            if(C_BlnktkumuKbn.ARI.eq(mosKihon.getZenkizennouumu())){
                mosKihon.setZnnkai(0);
            }
            mosKihon.setZennoup(BizCurrency.valueOf(0, hrkTuukaType));
            mosKihon.setZennoujyuutoup(BizCurrency.valueOf(0, hrkTuukaType));
            mosKihon.setSeitoufstpkei(BizCurrency.valueOf(0, kykTuukaType));
            mosKihon.setFstphrkgk(BizCurrency.valueOf(0, hrkTuukaType));
            mosKihon.setHrktuukafstphrkgk(BizCurrency.valueOf(0, hrkTuukaType));
            mosKihon.setHyouteip(BizCurrency.valueOf(0, kykTuukaType));
            mosKihon.setPharaikomisougaku(BizCurrency.valueOf(0, hrkTuukaType));
            mosKihon.setSkjpjyuutoukaisuu(Integer.valueOf(0));
            mosKihon.setIkkatuyoupumukbn(C_UmuKbn.NONE);
            mosKihon.setIkkatuyoupkaisuu(Integer.valueOf(0));
            mosKihon.setIkkatuyoupgkkeizokup(BizCurrency.valueOf(0, hrkTuukaType));
            mosKihon.setPwaribikitekiyoukbn(C_PWaribikitekiyouKbn.NONE);
            mosKihon.setSisuukbn(C_Sisuukbn.BLNK);
            mosKihon.setKeizokuptkykwsratekjymd(null);
            mosKihon.setKeizokuptkykwsrate(BizNumber.valueOf(0));
        }


        List<HT_MosSyouhn> mosSyouhnLst = syoriControl.getMosSyouhns();

        for (HT_MosSyouhn mosSyouhn : mosSyouhnLst) {
            mosSyouhn.setSyouhnsdno(0);
            mosSyouhn.setRyouritusdno(String.valueOf(0));
            mosSyouhn.setYoteiriritu(BizNumber.valueOf(0));
            mosSyouhn.setTumitateriritu(BizNumber.valueOf(0));
            mosSyouhn.setTmttknzoukaritujygn(BizNumber.valueOf(0));
            mosSyouhn.setSetteibairitu(BizNumber.valueOf(0));
            mosSyouhn.setRendouritu(BizNumber.valueOf(0));
            mosSyouhn.setLoadinghnkgtumitateriritu(BizNumber.valueOf(0));
            mosSyouhn.setGyoumuKousinsyaId(pMP.getKosID());
            mosSyouhn.setGyoumuKousinTime(pMP.getKosTime());

            if (mosKihon != null) {
                mosSyouhn.setSeitoukihons(BizCurrency.valueOf(0, kykTuukaType));
                mosSyouhn.setSyutkp(BizCurrency.valueOf(0, kykTuukaType));
                mosSyouhn.setTkjyp(BizCurrency.valueOf(0, kykTuukaType));
                mosSyouhn.setTeikisiharaikin(BizCurrency.valueOf(0, kykTuukaType));

                if (C_SyutkKbn.SYU.eq(mosSyouhn.getSyutkkbn()) &&
                    (C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_YENDT.eq(mosKihon.getHknsyuruino()) ||
                        C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT.eq(mosKihon.getHknsyuruino()))) {

                    int hrkkkn = 0;
                    mosSyouhn.setHrkkkn(hrkkkn);
                }

            }
            else {
                mosSyouhn.setSeitoukihons(BizCurrency.valueOf(0));
                mosSyouhn.setSyutkp(BizCurrency.valueOf(0));
                mosSyouhn.setTkjyp(BizCurrency.valueOf(0));
                mosSyouhn.setTeikisiharaikin(BizCurrency.valueOf(0));
            }

        }

        List<HT_MosDairiten> mosDairitenLst = syoriControl.getMosDairitens();
        for (HT_MosDairiten mosDairiten : mosDairitenLst) {

            mosDairiten.setTratkiagcd("");
            mosDairiten.setOyadrtencd("");
            mosDairiten.setBosyuucd("");
            mosDairiten.setDaibosyuucd("");
            mosDairiten.setDrtenkanrisosikicd("");
            mosDairiten.setGyoumuKousinsyaId(pMP.getKosID());
            mosDairiten.setGyoumuKousinTime(pMP.getKosTime());
        }

        HT_Tokunin tokunin = syoriControl.getTokunin();
        if (tokunin != null) {

            pMP.setBeforeCheckIkkatuyouptknKbn(tokunin.getIkkatuyouptknkbn());
            tokunin.setIkkatuyouptknkbn(C_IkkatuyouptknKbn.NONE);
            tokunin.setGyoumuKousinsyaId(pMP.getKosID());
            tokunin.setGyoumuKousinTime(pMP.getKosTime());
        }
        else {

            pMP.setBeforeCheckIkkatuyouptknKbn(C_IkkatuyouptknKbn.NONE);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 自動設定項目初期化 終了");
        }
    }
}