package yuyu.common.hozen.khcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.hozen.khcommon.dba4keisanhrrtksnhrkpgkgk.KeisanHrrtksnHrkPGkgkDao;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 契約保全共通 返戻率計算用払込保険料合計額計算
 */
public class KeisanHrrtksnHrkPGkgk {

    private boolean keisanKahi;

    private BizCurrency kihrkmP;

    private BizCurrency hrkmPSgkHknkkn;

    @Inject
    private static Logger logger;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private KeisanHrrtksnHrkPGkgkDao keisanHrrtksnHrkPGkgkDao;

    public KeisanHrrtksnHrkPGkgk() {
        super();
    }


    public C_ErrorKbn exec(String pSyoNo) {

        logger.debug("▽ 返戻率計算用払込保険料合計額計算 開始");


        C_ErrorKbn kekkaKbn = C_ErrorKbn.ERROR;
        keisanKahi = false;
        kihrkmP = null;
        hrkmPSgkHknkkn = null;
        BizCurrency krkgkIgaiKihrkP = null;
        BizCurrency krkgkGk = null;
        BizCurrency syouraiHrkP = null;
        BizCurrency hrkP = null;
        boolean noZeitekiFlag = false;


        if (BizUtil.isBlank(pSyoNo)){

            logger.debug("返戻率計算用払込保険料合計額計算　入力チェックエラー");
            logger.debug("△ 返戻率計算用払込保険料合計額計算 終了");

            return kekkaKbn;

        }


        List<C_UmuKbn> zeitekiAzukarikinKjUmuList = keisanHrrtksnHrkPGkgkDao.getShrRirekiBySyono(pSyoNo);


        noZeitekiFlag = zeitekiAzukarikinKjUmuList.contains(C_UmuKbn.NONE);


        if (noZeitekiFlag && zeitekiAzukarikinKjUmuList.contains(C_UmuKbn.ARI)) {

            kekkaKbn = C_ErrorKbn.OK;

            logger.debug("返戻率計算用払込保険料合計額計算　計算不可");
            logger.debug("△ 返戻率計算用払込保険料合計額計算 終了");


            return kekkaKbn;

        }


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyoNo);

        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        if ((!C_Kykjyoutai.ZENNOU.eq(kykSyouhn.getKykjyoutai()))
            && C_TkiktbrisyuruiKbn.BLNK.eq(kykKihon.getTikiktbrisyuruikbn())) {

            logger.debug("返戻率計算用払込保険料合計額計算　契約情報チェックエラー");
            logger.debug("△ 返戻率計算用払込保険料合計額計算 終了");

            return kekkaKbn;

        }

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(pSyoNo);


        if (!C_Kykjyoutai.ZENNOU.eq(kykSyouhn.getKykjyoutai())) {
            KeisanIkkatuPGk keisanIkkatuPGk = SWAKInjector.getInstance(KeisanIkkatuPGk.class);
            KeisanIkkatuPGkBean keisanIkkatuPGkBean = SWAKInjector.getInstance(KeisanIkkatuPGkBean.class);

            keisanIkkatuPGkBean.setSyouhnCd(kykSyouhn.getSyouhncd());
            keisanIkkatuPGkBean.setSyouhnsdNo(kykSyouhn.getSyouhnsdno());
            keisanIkkatuPGkBean.setRyouritusdNo(kykSyouhn.getRyouritusdno());
            keisanIkkatuPGkBean.setHokenryou(kykSyouhn.getHokenryou());
            keisanIkkatuPGkBean.setKeikamon(Integer.parseInt(kykKihon.getTikiktbrisyuruikbn().getValue()));
            keisanIkkatuPGkBean.setHrkkaisuu(kykKihon.getHrkkaisuu());
            keisanIkkatuPGkBean.setTkiktbrisyuruiKbn(kykKihon.getTikiktbrisyuruikbn());

            if (C_ErrorKbn.OK.eq(keisanIkkatuPGk.exec(keisanIkkatuPGkBean, false))) {

                hrkP = keisanIkkatuPGk.getIkkatuP();

            }

            else {

                logger.debug("返戻率計算用払込保険料合計額計算　一括払Ｐ計算エラー");
                logger.debug("△ 返戻率計算用払込保険料合計額計算 終了");

                return kekkaKbn;

            }
        }

        krkgkIgaiKihrkP = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        if (noZeitekiFlag) {

            if (C_Kykjyoutai.ZENNOU.eq(kykSyouhn.getKykjyoutai())) {

                IT_Zennou zennou = keisanHrrtksnHrkPGkgkDao.getZennouBySyono(pSyoNo);

                if(zennou == null){

                    logger.debug("返戻率計算用払込保険料合計額計算　前納情報チェックエラー");
                    logger.debug("△ 返戻率計算用払込保険料合計額計算 終了");

                    return kekkaKbn;

                }

                krkgkIgaiKihrkP = zennou.getZennounyuukinkgk().add(zennou.getZennoujihrkp());

            }

            else {

                BizDateYM kikanYmFrom = kykSyouhn.getKykymd().getBizDateYM();
                BizDateYM kikanYmTo = ansyuKihon.getJkipjytym();
                C_TkiktbrisyuruiKbn tkiktbrisyuruiKbn = kykKihon.getTikiktbrisyuruikbn();

                krkgkIgaiKihrkP = calcKikanHrkmP(kikanYmFrom, kikanYmTo, tkiktbrisyuruiKbn, hrkP);

            }

        }

        else {

            KeisanKihrkP keisanKihrkP = SWAKInjector.getInstance(KeisanKihrkP.class);

            C_Tuukasyu kykTuukasyu = kykSyouhn.getKyktuukasyu();

            if (C_ErrorKbn.OK.eq(keisanKihrkP.exec(pSyoNo, kykTuukasyu))) {

                krkgkIgaiKihrkP = keisanKihrkP.getYenKihrkP();


            }

            else {

                logger.debug("返戻率計算用払込保険料合計額計算　既払込Ｐ（仮受金以外）計算エラー");
                logger.debug("△ 返戻率計算用払込保険料合計額計算 終了");

                return kekkaKbn;

            }
        }


        krkgkGk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        List<IT_Kariukekin> kariukekinList = hozenDomManager.getKariukekinsBySyono(pSyoNo);

        for (int i = 0; i < kariukekinList.size(); i++) {

            krkgkGk = krkgkGk.add(kariukekinList.get(i).getKrkgk());

        }


        syouraiHrkP = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        if (!C_Kykjyoutai.ZENNOU.eq(kykSyouhn.getKykjyoutai())) {

            BizDateYM kikanYmFrom = ansyuKihon.getJkipjytym();
            BizDateYM kikanYmTo = kykSyouhn.getHaraimanymd().getBizDateYM();
            C_TkiktbrisyuruiKbn tkiktbrisyuruiKbn = kykKihon.getTikiktbrisyuruikbn();

            syouraiHrkP = calcKikanHrkmP(kikanYmFrom, kikanYmTo, tkiktbrisyuruiKbn, hrkP);

        }


        kihrkmP = krkgkIgaiKihrkP.add(krkgkGk);

        hrkmPSgkHknkkn = krkgkIgaiKihrkP.add(syouraiHrkP);



        kekkaKbn = C_ErrorKbn.OK;

        keisanKahi = true;

        logger.debug("△ 返戻率計算用払込保険料合計額計算 終了");

        return kekkaKbn;

    }


    public boolean getKeisanKahi() {
        return keisanKahi;
    }

    public BizCurrency getKihrkmP() {
        return kihrkmP;
    }

    public BizCurrency getHrkmPSgkHknkkn() {
        return hrkmPSgkHknkkn;
    }

    private BizCurrency calcKikanHrkmP(BizDateYM pKikanYmFrom, BizDateYM pKikanYmTo,
        C_TkiktbrisyuruiKbn pTkiktbrisyuruiKbn, BizCurrency pHrkmP) {
        int jyutouM = BizDateUtil.calcDifferenceMonths(pKikanYmFrom, pKikanYmTo);

        int jyutouKaisuu = jyutouM / Integer.parseInt(pTkiktbrisyuruiKbn.getValue());

        BizCurrency kikanHrkmP = BizCurrency.valueOf(jyutouKaisuu).multiplyCurrency(pHrkmP);

        return kikanHrkmP;
    }

}