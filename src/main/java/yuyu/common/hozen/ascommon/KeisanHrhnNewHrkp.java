package yuyu.common.hozen.ascommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;

import org.slf4j.Logger;

import yuyu.common.hozen.khcommon.KeisanIkkatuPGk;
import yuyu.common.hozen.khcommon.KeisanIkkatuPGkBean;
import yuyu.common.hozen.khcommon.KeisanSP;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 契約保全共通 払変新払込Ｐ計算
 */
public class KeisanHrhnNewHrkp {

    private BizCurrency newHrkp;

    private BizCurrency syuP;

    private List<BizCurrency> tkPList;

    private List<String> tkSyouhnCdList;

    private List<Integer> tkSyouhnSdnoList;

    private List<Integer> tkKykSyouhnRennoList;

    private BizCurrency iktwaribikikgk;

    private C_Sdpd sdpd;

    @Inject
    private static Logger logger;

    @Inject
    private HozenDomManager hozenDomManager;

    public KeisanHrhnNewHrkp() {
        super();
    }

    public BizCurrency getNewHrkp() {
        return newHrkp;
    }

    public BizCurrency getSyuP() {
        return syuP;
    }

    public List<BizCurrency> getTkPList() {
        return tkPList;
    }

    public List<String> getTkSyouhnCdList() {
        return tkSyouhnCdList;
    }

    public List<Integer> getTkSyouhnSdnoList() {
        return tkSyouhnSdnoList;
    }

    public List<Integer> getTkKykSyouhnRennoList() {
        return tkKykSyouhnRennoList;
    }

    public BizCurrency getIktwaribikikgk() {
        return iktwaribikikgk;
    }

    public C_Sdpd getSdpd() {
        return sdpd;
    }

    public C_ErrorKbn exec(IT_KykSyouhn pSyuKykSyouhn,
        List<IT_KykSyouhn> pTkKykSyouhnList,
        C_Hrkkaisuu pOldHrkkaisuu,
        C_Hrkkaisuu pNewHrkkaisuu,
        C_Hrkkeiro pNewHrkkeiro) {

        logger.debug("▽ 払変新払込Ｐ計算（払込回数指定） 開始");

        BizCurrency newHrkpWk = BizCurrency.valueOf(0);
        BizCurrency syupWk = BizCurrency.valueOf(0);
        List<BizCurrency> tkPListWk = new ArrayList<>();
        List<String> tkSyouhnCdListWk = new ArrayList<>();
        List<Integer> tkSyouhnSdnoListWk = new ArrayList<>();
        List<Integer> tkKykSyouhnRennoListWk = new ArrayList<>();
        KeisanSP keisanSP = SWAKInjector.getInstance(KeisanSP.class);
        C_ErrorKbn kekkaKbn = C_ErrorKbn.ERROR;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyuKykSyouhn.getSyono());

        C_Sdpd sdpdKbn = kykKihon.getSdpdkbn();

        if (C_Sdpd.PD.eq(sdpdKbn) && !pOldHrkkaisuu.eq(pNewHrkkaisuu)) {

            sdpdKbn = C_Sdpd.SD;
        }

        kekkaKbn = keisanSP.exec(pSyuKykSyouhn.getSyouhncd(),
            pSyuKykSyouhn.getRyouritusdno(),
            pSyuKykSyouhn.getYoteiriritu(),
            pNewHrkkaisuu,
            pSyuKykSyouhn.getHhknnen(),
            pSyuKykSyouhn.getHhknsei(),
            pSyuKykSyouhn.getHknkknsmnkbn(),
            pSyuKykSyouhn.getHknkkn(),
            pSyuKykSyouhn.getHrkkkn(),
            sdpdKbn,
            pSyuKykSyouhn.getKihons(),
            pSyuKykSyouhn.getHokenryou(),
            pSyuKykSyouhn.getKyktuukasyu(),
            pSyuKykSyouhn.getKykjyoutai(),
            pSyuKykSyouhn.getDai1hknkkn(),
            pNewHrkkeiro);

        if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {
            logger.debug("△ 払変新払込Ｐ計算（払込回数指定） 終了");

            return C_ErrorKbn.ERROR;
        }

        syupWk = keisanSP.getP();

        newHrkpWk = syupWk;

        for (IT_KykSyouhn tkKykSyouhn : pTkKykSyouhnList) {

            kekkaKbn = keisanSP.exec(tkKykSyouhn.getSyouhncd(),
                tkKykSyouhn.getRyouritusdno(),
                tkKykSyouhn.getYoteiriritu(),
                pNewHrkkaisuu,
                tkKykSyouhn.getHhknnen(),
                tkKykSyouhn.getHhknsei(),
                tkKykSyouhn.getHknkknsmnkbn(),
                tkKykSyouhn.getHknkkn(),
                tkKykSyouhn.getHrkkkn(),
                C_Sdpd.SD,
                tkKykSyouhn.getKihons(),
                tkKykSyouhn.getHokenryou(),
                tkKykSyouhn.getKyktuukasyu(),
                pSyuKykSyouhn.getKykjyoutai(),
                pSyuKykSyouhn.getDai1hknkkn(),
                pNewHrkkeiro);

            if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {
                logger.debug("△ 払変新払込Ｐ計算（払込回数指定） 終了");

                return C_ErrorKbn.ERROR;
            }

            tkPListWk.add(keisanSP.getP());
            tkSyouhnCdListWk.add(tkKykSyouhn.getSyouhncd());
            tkSyouhnSdnoListWk.add(tkKykSyouhn.getSyouhnsdno());
            tkKykSyouhnRennoListWk.add(tkKykSyouhn.getKyksyouhnrenno());

            newHrkpWk = newHrkpWk.add(keisanSP.getP());
        }

        newHrkp = newHrkpWk;
        syuP = syupWk;
        tkPList = tkPListWk;
        tkSyouhnCdList = tkSyouhnCdListWk;
        tkSyouhnSdnoList = tkSyouhnSdnoListWk;
        tkKykSyouhnRennoList = tkKykSyouhnRennoListWk;
        sdpd = sdpdKbn;

        logger.debug("△ 払変新払込Ｐ計算（払込回数指定） 終了");

        return C_ErrorKbn.OK;
    }

    public C_ErrorKbn exec(IT_KykKihon pKykKihon, C_TkiktbrisyuruiKbn pHenkoatoTkiktbrisyuruiKbn) {

        logger.debug("▽ 払変新払込Ｐ計算（定期一括払種類区分指定） 開始");

        BizCurrency newHrkpWk = BizCurrency.valueOf(0);
        BizCurrency syupWk = BizCurrency.valueOf(0);
        List<BizCurrency> tkPListWk = new ArrayList<>();
        List<String> tkSyouhnCdListWk = new ArrayList<>();
        List<Integer> tkSyouhnSdnoListWk = new ArrayList<>();
        List<Integer> tkKykSyouhnRennoListWk = new ArrayList<>();
        BizCurrency iktwaribikikgkWk = BizCurrency.valueOf(0);

        IT_KykSyouhn syuKykSyouhn = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);
        List<IT_KykSyouhn> tkKykSyouhnList = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        C_ErrorKbn kekkaKbn = C_ErrorKbn.ERROR;

        if (C_TkiktbrisyuruiKbn.NONE.eq(pHenkoatoTkiktbrisyuruiKbn)) {

            syupWk = syuKykSyouhn.getHokenryou();
            newHrkpWk = syuKykSyouhn.getHokenryou();

            for (IT_KykSyouhn tkKykSyouhn : tkKykSyouhnList) {
                tkPListWk.add(tkKykSyouhn.getHokenryou());
                tkSyouhnCdListWk.add(tkKykSyouhn.getSyouhncd());
                tkSyouhnSdnoListWk.add(tkKykSyouhn.getSyouhnsdno());
                tkKykSyouhnRennoListWk.add(tkKykSyouhn.getKyksyouhnrenno());
                newHrkpWk = newHrkpWk.add(tkKykSyouhn.getHokenryou());
            }
        }
        else {

            KeisanIkkatuPGkBean keisanIkkatuPGkBean = new KeisanIkkatuPGkBean();
            keisanIkkatuPGkBean.setSyouhnCd(syuKykSyouhn.getSyouhncd());
            keisanIkkatuPGkBean.setSyouhnsdNo(syuKykSyouhn.getSyouhnsdno());
            keisanIkkatuPGkBean.setRyouritusdNo(syuKykSyouhn.getRyouritusdno());
            keisanIkkatuPGkBean.setHokenryou(syuKykSyouhn.getHokenryou());
            keisanIkkatuPGkBean.setKeikamon(Integer.valueOf(pHenkoatoTkiktbrisyuruiKbn.getValue()));
            keisanIkkatuPGkBean.setHrkkaisuu(pKykKihon.getHrkkaisuu());
            keisanIkkatuPGkBean.setTkiktbrisyuruiKbn(pHenkoatoTkiktbrisyuruiKbn);

            KeisanIkkatuPGk keisanIkkatuPGk = SWAKInjector.getInstance(KeisanIkkatuPGk.class);
            kekkaKbn = keisanIkkatuPGk.exec(keisanIkkatuPGkBean, false);
            if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {
                logger.debug("△ 払変新払込Ｐ計算（定期一括払種類区分指定） 終了");

                return C_ErrorKbn.ERROR;
            }
            syupWk = keisanIkkatuPGk.getIkkatuP();
            newHrkpWk = keisanIkkatuPGk.getIkkatuP();
            iktwaribikikgkWk = keisanIkkatuPGk.getIktwaribikikgk();

            for (IT_KykSyouhn tkKykSyouhn : tkKykSyouhnList) {

                KeisanIkkatuPGkBean tkkeisanIkkatuPGkBean = new KeisanIkkatuPGkBean();
                tkkeisanIkkatuPGkBean.setSyouhnCd(tkKykSyouhn.getSyouhncd());
                tkkeisanIkkatuPGkBean.setSyouhnsdNo(tkKykSyouhn.getSyouhnsdno());
                tkkeisanIkkatuPGkBean.setRyouritusdNo(tkKykSyouhn.getRyouritusdno());
                tkkeisanIkkatuPGkBean.setHokenryou(tkKykSyouhn.getHokenryou());
                tkkeisanIkkatuPGkBean.setKeikamon(Integer.valueOf(pHenkoatoTkiktbrisyuruiKbn.getValue()));
                tkkeisanIkkatuPGkBean.setHrkkaisuu(pKykKihon.getHrkkaisuu());
                tkkeisanIkkatuPGkBean.setTkiktbrisyuruiKbn(pHenkoatoTkiktbrisyuruiKbn);

                KeisanIkkatuPGk tkkeisanIkkatuPGk = SWAKInjector.getInstance(KeisanIkkatuPGk.class);
                kekkaKbn = tkkeisanIkkatuPGk.exec(tkkeisanIkkatuPGkBean, false);
                if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {
                    logger.debug("△ 払変新払込Ｐ計算（定期一括払種類区分指定） 終了");

                    return C_ErrorKbn.ERROR;
                }
                tkPListWk.add(tkkeisanIkkatuPGk.getIkkatuP());
                tkSyouhnCdListWk.add(tkKykSyouhn.getSyouhncd());
                tkSyouhnSdnoListWk.add(tkKykSyouhn.getSyouhnsdno());
                tkKykSyouhnRennoListWk.add(tkKykSyouhn.getKyksyouhnrenno());
                newHrkpWk = newHrkpWk.add(tkkeisanIkkatuPGk.getIkkatuP());
                iktwaribikikgkWk = iktwaribikikgkWk.add(tkkeisanIkkatuPGk.getIktwaribikikgk());
            }
        }
        newHrkp = newHrkpWk;
        syuP = syupWk;
        tkPList = tkPListWk;
        tkSyouhnCdList = tkSyouhnCdListWk;
        tkSyouhnSdnoList = tkSyouhnSdnoListWk;
        tkKykSyouhnRennoList = tkKykSyouhnRennoListWk;
        iktwaribikikgk = iktwaribikikgkWk;
        sdpd = pKykKihon.getSdpdkbn();

        logger.debug("△ 払変新払込Ｐ計算（定期一括払種類区分指定） 終了");

        return C_ErrorKbn.OK;
    }
}
