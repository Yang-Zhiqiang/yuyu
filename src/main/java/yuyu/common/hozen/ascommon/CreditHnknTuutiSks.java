package yuyu.common.hozen.ascommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoKekkaBean;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_ShrriyuuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_CreditHnknTuuti;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_SyuunouHenknRireki;

/**
 * 契約保全 案内収納共通 クレカ返金通知作成
 */
public class CreditHnknTuutiSks {

    private IT_CreditHnknTuuti creditHnknTuuti;

    private IT_SyuunouHenknRireki syuunouHenknRireki;

    @Inject
    private static Logger logger;

    public CreditHnknTuutiSks() {
        super();
    }

    public IT_CreditHnknTuuti getCreditHnknTuuti() {
        return creditHnknTuuti;
    }

    public IT_SyuunouHenknRireki getSyuunouHenknRireki() {
        return syuunouHenknRireki;
    }

    public void exec(KhozenCommonParam pKhozenCommonParam, CreditHnknTuutiSksParam pCreditHnknTuutiSksParam) {

        logger.debug("▽ クレカ返金通知作成 開始");

        syuunouHenknRireki = null;

        creditHnknTuuti = null;

        IT_KykKihon kykKihon = pCreditHnknTuutiSksParam.getKykKihon();

        IT_KykSya kykSya = kykKihon.getKykSya();

        String tsinyno = kykSya.getTsinyno();

        String tsinadr1kj = kykSya.getTsinadr1kj();

        String tsinadr2kj = kykSya.getTsinadr2kj();

        String tsinadr3kj = kykSya.getTsinadr3kj();

        String kyknmkj = kykSya.getKyknmkj();

        String ccSosikiCd = YuyuBizConfig.getInstance().getCallcentersosikicd();

        BzGetSosikiMadogutiInfo bzGetSosikiMadogutiInfo = SWAKInjector.getInstance(BzGetSosikiMadogutiInfo.class);

        BzGetSosikiMadogutiInfoKekkaBean bzGetSosikiMadogutiInfoKekkaBean = bzGetSosikiMadogutiInfo.exec(ccSosikiCd);

        C_ShrriyuuKbn shrriyuukbn = C_ShrriyuuKbn.BLNK;

        String sSysDateTime = BizDate.getSysDateTimeMilli();

        if (!C_ShrriyuuKbn.BLNK.eq(pCreditHnknTuutiSksParam.getShrriyuukbn())) {

            shrriyuukbn = pCreditHnknTuutiSksParam.getShrriyuukbn();
        }
        else {

            if (C_KrkriyuuKbn.SYOUMETUGONYKN.eq(pCreditHnknTuutiSksParam.getKrkriyuukbn()) ||
                C_KrkriyuuKbn.KYUUSOKUTYUUNYKN.eq(pCreditHnknTuutiSksParam.getKrkriyuukbn()) ||
                C_KrkriyuuKbn.HENKINHITUYOU.eq(pCreditHnknTuutiSksParam.getKrkriyuukbn())) {

                shrriyuukbn = C_ShrriyuuKbn.HARAIKOMIHUYOU;
            }
            else if (C_KrkriyuuKbn.ZYUTOUTUKISOUI.eq(pCreditHnknTuutiSksParam.getKrkriyuukbn())) {

                shrriyuukbn = C_ShrriyuuKbn.NIZYUNYKN;
            }
            else if (C_KrkriyuuKbn.KAZYOUNYKN.eq(pCreditHnknTuutiSksParam.getKrkriyuukbn())) {

                shrriyuukbn = C_ShrriyuuKbn.KAZYOUNYKN;
            }
            else {

                shrriyuukbn = C_ShrriyuuKbn.HARAIKOMIHUYOU;
            }
        }

        creditHnknTuuti = kykKihon.createCreditHnknTuuti();

        creditHnknTuuti.setDenrenno(pCreditHnknTuutiSksParam.getDenrenno());

        creditHnknTuuti.setEdano(pCreditHnknTuutiSksParam.getEdano());

        creditHnknTuuti.setTyouhyouymd(pCreditHnknTuutiSksParam.getTyouhyouymd());

        creditHnknTuuti.setHenkousikibetukey(pCreditHnknTuutiSksParam.getHenkousikibetukey());

        creditHnknTuuti.setHassoukbn(pCreditHnknTuutiSksParam.getHassoukbn());

        creditHnknTuuti.setShskyno(tsinyno);

        creditHnknTuuti.setShsadr1kj(tsinadr1kj);

        creditHnknTuuti.setShsadr2kj(tsinadr2kj);

        creditHnknTuuti.setShsadr3kj(tsinadr3kj);

        creditHnknTuuti.setShsnmkj(kyknmkj);

        creditHnknTuuti.setToiawasesosikinmkj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikinm());

        creditHnknTuuti.setToiawaseyno(bzGetSosikiMadogutiInfoKekkaBean.getPostalCd());

        creditHnknTuuti.setToiawaseadr1kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1());

        creditHnknTuuti.setToiawaseadr2kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2());

        creditHnknTuuti.setToiawaseadr3kj(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr3());

        creditHnknTuuti.setToiawasetelno(bzGetSosikiMadogutiInfoKekkaBean.getTelno());

        creditHnknTuuti.setToiawaseteluktkkanou1(YuyuBizConfig.getInstance().getUketimecallcenter1());

        creditHnknTuuti.setToiawaseteluktkkanou2(YuyuBizConfig.getInstance().getUketimecallcenter2());

        creditHnknTuuti.setShrriyuukbn(pCreditHnknTuutiSksParam.getShrriyuukbn());

        creditHnknTuuti.setUriageseikyuuymd(pCreditHnknTuutiSksParam.getUriageseikyuuymd());

        creditHnknTuuti.setHnkngk(pCreditHnknTuutiSksParam.getHnkngk());

        creditHnknTuuti.setKrkriyuukbn(pCreditHnknTuutiSksParam.getKrkriyuukbn());

        creditHnknTuuti.setUriageymd(pCreditHnknTuutiSksParam.getUriageymd());

        creditHnknTuuti.setUriagegk(pCreditHnknTuutiSksParam.getUriagegk());

        creditHnknTuuti.setJyuutouym(pCreditHnknTuutiSksParam.getJyuutouym());

        creditHnknTuuti.setJyutoukaisuuy(pCreditHnknTuutiSksParam.getJyutoukaisuuy());

        creditHnknTuuti.setJyutoukaisuum(pCreditHnknTuutiSksParam.getJyutoukaisuum());

        if (pCreditHnknTuutiSksParam.getUriageymd() != null) {

            creditHnknTuuti.setHnkntaisyouinjiflg(C_UmuKbn.ARI);
        }
        else {

            creditHnknTuuti.setHnkntaisyouinjiflg(C_UmuKbn.NONE);
        }

        creditHnknTuuti.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());

        creditHnknTuuti.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());

        creditHnknTuuti.setGyoumuKousinTime(sSysDateTime);

        BizPropertyInitializer.initialize(creditHnknTuuti);

        IT_AnsyuKihon ansyuKihon = pCreditHnknTuutiSksParam.getAnsyuKihon();

        syuunouHenknRireki = ansyuKihon.createSyuunouHenknRireki();

        syuunouHenknRireki.setDenrenno(pCreditHnknTuutiSksParam.getDenrenno());

        syuunouHenknRireki.setEdano(pCreditHnknTuutiSksParam.getEdano());

        syuunouHenknRireki.setDenkihyouymd(pCreditHnknTuutiSksParam.getDenymd());

        syuunouHenknRireki.setShrymd(pCreditHnknTuutiSksParam.getUriageseikyuuymd());

        syuunouHenknRireki.setKanjyoukmkcd(pCreditHnknTuutiSksParam.getKanjyoukmkcd());

        syuunouHenknRireki.setHnkngk(pCreditHnknTuutiSksParam.getHnkngk());

        syuunouHenknRireki.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());

        syuunouHenknRireki.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());

        syuunouHenknRireki.setGyoumuKousinTime(sSysDateTime);

        syuunouHenknRireki.setShrriyuukbn(shrriyuukbn);

        syuunouHenknRireki.setCreditkessaiyouno(pCreditHnknTuutiSksParam.getCreditkessaiyouno());

        BizPropertyInitializer.initialize(syuunouHenknRireki);

        logger.debug("△ クレカ返金通知作成 終了");
    }
}
