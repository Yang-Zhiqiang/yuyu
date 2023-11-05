package yuyu.def.direct.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBUpdatableResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_DsKanyuuKeiroKbn;
import yuyu.def.classification.C_DsKrHnnKakCdSetKbn;
import yuyu.def.classification.C_DsKrHnnKakCdTtYhKbn;
import yuyu.def.db.entity.MT_DsHonninKakuninCd;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * DirectDomManagerクラスの、<br />
 * getDsKokyakuKanrisByDskrhnnkakcdttyhkbn() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class DirectDomManagerTest_getDsKokyakuKanrisByDskrhnnkakcdttyhkbnDskrhnnkakcdttshjyhsymd {

    @Inject
    DirectDomManager directDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestData();

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        try (ExDBUpdatableResults<MT_DsKokyakuKanri> exDBUpdatableResults = directDomManager.
            getDsKokyakuKanrisByDskrhnnkakcdttyhkbnDskrhnnkakcdttshjyhsymd(C_DsKrHnnKakCdTtYhKbn.BLNK,BizDate.valueOf(20170426))) {

            Assert.assertFalse(exDBUpdatableResults.iterator().hasNext());
        }

        insertSubData();
    }

    @Transactional
    public static void insertSubData() {
        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        MT_DsKokyakuKanri dsKokyakuKanri1 = new MT_DsKokyakuKanri("1000000016");

        dsKokyakuKanri1.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.SINKEIYAKUDOUJI);

        MT_DsHonninKakuninCd dsHonninKakuninCd1 = dsKokyakuKanri1.createDsHonninKakuninCd();
        dsHonninKakuninCd1.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SINKI);
        dsHonninKakuninCd1.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20170427));
        dsHonninKakuninCd1.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.BLNK);
        directDomManager.insert(dsKokyakuKanri1);
    }


    @Transactional
    public static void insertSubData2() {
        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        MT_DsKokyakuKanri dsKokyakuKanri13 = new MT_DsKokyakuKanri("1000000133");

        dsKokyakuKanri13.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.SINKEIYAKUDOUJI);

        MT_DsHonninKakuninCd dsHonninKakuninCd13 = dsKokyakuKanri13.createDsHonninKakuninCd();

        dsHonninKakuninCd13.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SINKI);

        dsHonninKakuninCd13.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20170424));

        dsHonninKakuninCd13.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.YOU);

        directDomManager.insert(dsKokyakuKanri13);
    }

    @Transactional
    public static void insertSubData3() {
        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        MT_DsKokyakuKanri dsKokyakuKanri1 = new MT_DsKokyakuKanri("1000000016");
        MT_DsKokyakuKanri dsKokyakuKanri2 = new MT_DsKokyakuKanri("1000000029");
        MT_DsKokyakuKanri dsKokyakuKanri3 = new MT_DsKokyakuKanri("1000000032");
        MT_DsKokyakuKanri dsKokyakuKanri4 = new MT_DsKokyakuKanri("1000000045");
        MT_DsKokyakuKanri dsKokyakuKanri5 = new MT_DsKokyakuKanri("1000000058");
        MT_DsKokyakuKanri dsKokyakuKanri6 = new MT_DsKokyakuKanri("1000000061");
        MT_DsKokyakuKanri dsKokyakuKanri7 = new MT_DsKokyakuKanri("1000000074");
        MT_DsKokyakuKanri dsKokyakuKanri8 = new MT_DsKokyakuKanri("1000000087");
        MT_DsKokyakuKanri dsKokyakuKanri9 = new MT_DsKokyakuKanri("1000000090");
        MT_DsKokyakuKanri dsKokyakuKanri10 = new MT_DsKokyakuKanri("1000000104");
        MT_DsKokyakuKanri dsKokyakuKanri11 = new MT_DsKokyakuKanri("1000000117");
        MT_DsKokyakuKanri dsKokyakuKanri12 = new MT_DsKokyakuKanri("1000000120");
        MT_DsKokyakuKanri dsKokyakuKanri13 = new MT_DsKokyakuKanri("1000000133");
        MT_DsKokyakuKanri dsKokyakuKanri14 = new MT_DsKokyakuKanri("1000000146");
        MT_DsKokyakuKanri dsKokyakuKanri15 = new MT_DsKokyakuKanri("1000000159");
        MT_DsKokyakuKanri dsKokyakuKanri16 = new MT_DsKokyakuKanri("1000000162");
        MT_DsKokyakuKanri dsKokyakuKanri17 = new MT_DsKokyakuKanri("1000000175");
        MT_DsKokyakuKanri dsKokyakuKanri18 = new MT_DsKokyakuKanri("1000000188");
        MT_DsKokyakuKanri dsKokyakuKanri19 = new MT_DsKokyakuKanri("1000000191");
        MT_DsKokyakuKanri dsKokyakuKanri20 = new MT_DsKokyakuKanri("1000000205");
        MT_DsKokyakuKanri dsKokyakuKanri21 = new MT_DsKokyakuKanri("1000000218");
        MT_DsKokyakuKanri dsKokyakuKanri22 = new MT_DsKokyakuKanri("1000000221");
        MT_DsKokyakuKanri dsKokyakuKanri23 = new MT_DsKokyakuKanri("1000000234");
        MT_DsKokyakuKanri dsKokyakuKanri24 = new MT_DsKokyakuKanri("1000000247");
        MT_DsKokyakuKanri dsKokyakuKanri25 = new MT_DsKokyakuKanri("1000000250");
        MT_DsKokyakuKanri dsKokyakuKanri26 = new MT_DsKokyakuKanri("1000000263");
        MT_DsKokyakuKanri dsKokyakuKanri27 = new MT_DsKokyakuKanri("1000000276");
        MT_DsKokyakuKanri dsKokyakuKanri28 = new MT_DsKokyakuKanri("1000000289");
        MT_DsKokyakuKanri dsKokyakuKanri29 = new MT_DsKokyakuKanri("1000000292");
        MT_DsKokyakuKanri dsKokyakuKanri30 = new MT_DsKokyakuKanri("1000000306");
        MT_DsKokyakuKanri dsKokyakuKanri31 = new MT_DsKokyakuKanri("1000000319");

        dsKokyakuKanri1.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.SINKEIYAKUDOUJI);
        dsKokyakuKanri2.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.SINKEIYAKUDOUJI);
        dsKokyakuKanri3.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.TYUUTOKANYUU);
        dsKokyakuKanri4.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.BLNK);
        dsKokyakuKanri5.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.SINKEIYAKUDOUJI);
        dsKokyakuKanri6.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.SINKEIYAKUDOUJI);
        dsKokyakuKanri7.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.TYUUTOKANYUU);
        dsKokyakuKanri8.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.BLNK);
        dsKokyakuKanri9.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.SINKEIYAKUDOUJI);
        dsKokyakuKanri10.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.SINKEIYAKUDOUJI);
        dsKokyakuKanri11.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.TYUUTOKANYUU);
        dsKokyakuKanri12.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.BLNK);
        dsKokyakuKanri13.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.SINKEIYAKUDOUJI);
        dsKokyakuKanri14.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.SINKEIYAKUDOUJI);
        dsKokyakuKanri15.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.SINKEIYAKUDOUJI);
        dsKokyakuKanri16.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.SINKEIYAKUDOUJI);
        dsKokyakuKanri17.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.TYUUTOKANYUU);
        dsKokyakuKanri18.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.TYUUTOKANYUU);
        dsKokyakuKanri19.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.BLNK);
        dsKokyakuKanri20.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.SINKEIYAKUDOUJI);
        dsKokyakuKanri21.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.SINKEIYAKUDOUJI);
        dsKokyakuKanri22.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.SINKEIYAKUDOUJI);
        dsKokyakuKanri23.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.TYUUTOKANYUU);
        dsKokyakuKanri24.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.TYUUTOKANYUU);
        dsKokyakuKanri25.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.BLNK);
        dsKokyakuKanri26.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.SINKEIYAKUDOUJI);
        dsKokyakuKanri27.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.SINKEIYAKUDOUJI);
        dsKokyakuKanri28.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.SINKEIYAKUDOUJI);
        dsKokyakuKanri29.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.TYUUTOKANYUU);
        dsKokyakuKanri30.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.TYUUTOKANYUU);
        dsKokyakuKanri31.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.BLNK);

        MT_DsHonninKakuninCd dsHonninKakuninCd1 = dsKokyakuKanri1.createDsHonninKakuninCd();
        MT_DsHonninKakuninCd dsHonninKakuninCd2 = dsKokyakuKanri2.createDsHonninKakuninCd();
        MT_DsHonninKakuninCd dsHonninKakuninCd3 = dsKokyakuKanri3.createDsHonninKakuninCd();
        MT_DsHonninKakuninCd dsHonninKakuninCd4 = dsKokyakuKanri4.createDsHonninKakuninCd();
        MT_DsHonninKakuninCd dsHonninKakuninCd5 = dsKokyakuKanri5.createDsHonninKakuninCd();
        MT_DsHonninKakuninCd dsHonninKakuninCd6 = dsKokyakuKanri6.createDsHonninKakuninCd();
        MT_DsHonninKakuninCd dsHonninKakuninCd7 = dsKokyakuKanri7.createDsHonninKakuninCd();
        MT_DsHonninKakuninCd dsHonninKakuninCd8 = dsKokyakuKanri8.createDsHonninKakuninCd();
        MT_DsHonninKakuninCd dsHonninKakuninCd9 = dsKokyakuKanri9.createDsHonninKakuninCd();
        MT_DsHonninKakuninCd dsHonninKakuninCd10 = dsKokyakuKanri10.createDsHonninKakuninCd();
        MT_DsHonninKakuninCd dsHonninKakuninCd11 = dsKokyakuKanri11.createDsHonninKakuninCd();
        MT_DsHonninKakuninCd dsHonninKakuninCd12 = dsKokyakuKanri12.createDsHonninKakuninCd();
        MT_DsHonninKakuninCd dsHonninKakuninCd13 = dsKokyakuKanri13.createDsHonninKakuninCd();
        MT_DsHonninKakuninCd dsHonninKakuninCd14 = dsKokyakuKanri14.createDsHonninKakuninCd();
        MT_DsHonninKakuninCd dsHonninKakuninCd15 = dsKokyakuKanri15.createDsHonninKakuninCd();
        MT_DsHonninKakuninCd dsHonninKakuninCd16 = dsKokyakuKanri16.createDsHonninKakuninCd();
        MT_DsHonninKakuninCd dsHonninKakuninCd17 = dsKokyakuKanri17.createDsHonninKakuninCd();
        MT_DsHonninKakuninCd dsHonninKakuninCd18 = dsKokyakuKanri18.createDsHonninKakuninCd();
        MT_DsHonninKakuninCd dsHonninKakuninCd19 = dsKokyakuKanri19.createDsHonninKakuninCd();
        MT_DsHonninKakuninCd dsHonninKakuninCd20 = dsKokyakuKanri20.createDsHonninKakuninCd();
        MT_DsHonninKakuninCd dsHonninKakuninCd21 = dsKokyakuKanri21.createDsHonninKakuninCd();
        MT_DsHonninKakuninCd dsHonninKakuninCd22 = dsKokyakuKanri22.createDsHonninKakuninCd();
        MT_DsHonninKakuninCd dsHonninKakuninCd23 = dsKokyakuKanri23.createDsHonninKakuninCd();
        MT_DsHonninKakuninCd dsHonninKakuninCd24 = dsKokyakuKanri24.createDsHonninKakuninCd();
        MT_DsHonninKakuninCd dsHonninKakuninCd25 = dsKokyakuKanri25.createDsHonninKakuninCd();
        MT_DsHonninKakuninCd dsHonninKakuninCd26 = dsKokyakuKanri26.createDsHonninKakuninCd();
        MT_DsHonninKakuninCd dsHonninKakuninCd27 = dsKokyakuKanri27.createDsHonninKakuninCd();
        MT_DsHonninKakuninCd dsHonninKakuninCd28 = dsKokyakuKanri28.createDsHonninKakuninCd();
        MT_DsHonninKakuninCd dsHonninKakuninCd29 = dsKokyakuKanri29.createDsHonninKakuninCd();
        MT_DsHonninKakuninCd dsHonninKakuninCd30 = dsKokyakuKanri30.createDsHonninKakuninCd();
        MT_DsHonninKakuninCd dsHonninKakuninCd31 = dsKokyakuKanri31.createDsHonninKakuninCd();

        dsHonninKakuninCd1.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SINKI);
        dsHonninKakuninCd2.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.BLANK);
        dsHonninKakuninCd3.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.BLANK);
        dsHonninKakuninCd4.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SINKI);
        dsHonninKakuninCd5.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SINKI);
        dsHonninKakuninCd6.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.BLANK);
        dsHonninKakuninCd7.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.BLANK);
        dsHonninKakuninCd8.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SINKI);
        dsHonninKakuninCd9.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SINKI);
        dsHonninKakuninCd10.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.BLANK);
        dsHonninKakuninCd11.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.BLANK);
        dsHonninKakuninCd12.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SINKI);
        dsHonninKakuninCd13.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SINKI);
        dsHonninKakuninCd14.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SINKI);
        dsHonninKakuninCd15.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SINKI);
        dsHonninKakuninCd16.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SAIHAKKOU);
        dsHonninKakuninCd17.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SINKI);
        dsHonninKakuninCd18.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SAIHAKKOU);
        dsHonninKakuninCd19.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SAIHAKKOU);
        dsHonninKakuninCd20.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SINKI);
        dsHonninKakuninCd21.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SINKI);
        dsHonninKakuninCd22.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SAIHAKKOU);
        dsHonninKakuninCd23.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SINKI);
        dsHonninKakuninCd24.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SAIHAKKOU);
        dsHonninKakuninCd25.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SAIHAKKOU);
        dsHonninKakuninCd26.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SINKI);
        dsHonninKakuninCd27.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SINKI);
        dsHonninKakuninCd28.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SAIHAKKOU);
        dsHonninKakuninCd29.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SINKI);
        dsHonninKakuninCd30.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SAIHAKKOU);
        dsHonninKakuninCd31.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SAIHAKKOU);

        dsHonninKakuninCd1.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20170427));
        dsHonninKakuninCd2.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20170425));
        dsHonninKakuninCd3.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20170425));
        dsHonninKakuninCd4.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20170425));
        dsHonninKakuninCd5.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20170427));
        dsHonninKakuninCd6.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20170425));
        dsHonninKakuninCd7.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20170425));
        dsHonninKakuninCd8.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20170425));
        dsHonninKakuninCd9.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20170427));
        dsHonninKakuninCd10.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20170425));
        dsHonninKakuninCd11.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20170425));
        dsHonninKakuninCd12.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20170425));
        dsHonninKakuninCd13.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20170424));
        dsHonninKakuninCd14.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20170425));
        dsHonninKakuninCd15.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20170426));
        dsHonninKakuninCd16.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20170427));
        dsHonninKakuninCd17.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20170427));
        dsHonninKakuninCd18.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20170427));
        dsHonninKakuninCd19.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20170427));
        dsHonninKakuninCd20.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20170425));
        dsHonninKakuninCd21.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20170426));
        dsHonninKakuninCd22.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20170427));
        dsHonninKakuninCd23.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20170427));
        dsHonninKakuninCd24.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20170427));
        dsHonninKakuninCd25.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20170427));
        dsHonninKakuninCd26.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20170425));
        dsHonninKakuninCd27.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20170426));
        dsHonninKakuninCd28.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20170427));
        dsHonninKakuninCd29.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20170427));
        dsHonninKakuninCd30.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20170427));
        dsHonninKakuninCd31.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20170427));

        dsHonninKakuninCd1.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.BLNK);
        dsHonninKakuninCd2.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.BLNK);
        dsHonninKakuninCd3.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.BLNK);
        dsHonninKakuninCd4.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.BLNK);
        dsHonninKakuninCd5.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.YOU);
        dsHonninKakuninCd6.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.YOU);
        dsHonninKakuninCd7.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.YOU);
        dsHonninKakuninCd8.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.YOU);
        dsHonninKakuninCd9.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.TYUUDAN);
        dsHonninKakuninCd10.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.TYUUDAN);
        dsHonninKakuninCd11.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.TYUUDAN);
        dsHonninKakuninCd12.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.TYUUDAN);
        dsHonninKakuninCd13.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.YOU);
        dsHonninKakuninCd14.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.BLNK);
        dsHonninKakuninCd15.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.BLNK);
        dsHonninKakuninCd16.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.BLNK);
        dsHonninKakuninCd17.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.BLNK);
        dsHonninKakuninCd18.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.BLNK);
        dsHonninKakuninCd19.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.BLNK);
        dsHonninKakuninCd20.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.YOU);
        dsHonninKakuninCd21.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.YOU);
        dsHonninKakuninCd22.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.YOU);
        dsHonninKakuninCd23.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.YOU);
        dsHonninKakuninCd24.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.YOU);
        dsHonninKakuninCd25.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.YOU);
        dsHonninKakuninCd26.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.TYUUDAN);
        dsHonninKakuninCd27.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.TYUUDAN);
        dsHonninKakuninCd28.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.TYUUDAN);
        dsHonninKakuninCd29.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.TYUUDAN);
        dsHonninKakuninCd30.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.TYUUDAN);
        dsHonninKakuninCd31.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.TYUUDAN);

        directDomManager.insert(dsKokyakuKanri1);
        directDomManager.insert(dsKokyakuKanri2);
        directDomManager.insert(dsKokyakuKanri3);
        directDomManager.insert(dsKokyakuKanri4);
        directDomManager.insert(dsKokyakuKanri5);
        directDomManager.insert(dsKokyakuKanri6);
        directDomManager.insert(dsKokyakuKanri7);
        directDomManager.insert(dsKokyakuKanri8);
        directDomManager.insert(dsKokyakuKanri9);
        directDomManager.insert(dsKokyakuKanri10);
        directDomManager.insert(dsKokyakuKanri11);
        directDomManager.insert(dsKokyakuKanri12);
        directDomManager.insert(dsKokyakuKanri13);
        directDomManager.insert(dsKokyakuKanri14);
        directDomManager.insert(dsKokyakuKanri15);
        directDomManager.insert(dsKokyakuKanri16);
        directDomManager.insert(dsKokyakuKanri17);
        directDomManager.insert(dsKokyakuKanri18);
        directDomManager.insert(dsKokyakuKanri19);
        directDomManager.insert(dsKokyakuKanri20);
        directDomManager.insert(dsKokyakuKanri21);
        directDomManager.insert(dsKokyakuKanri22);
        directDomManager.insert(dsKokyakuKanri23);
        directDomManager.insert(dsKokyakuKanri24);
        directDomManager.insert(dsKokyakuKanri25);
        directDomManager.insert(dsKokyakuKanri26);
        directDomManager.insert(dsKokyakuKanri27);
        directDomManager.insert(dsKokyakuKanri28);
        directDomManager.insert(dsKokyakuKanri29);
        directDomManager.insert(dsKokyakuKanri30);
        directDomManager.insert(dsKokyakuKanri31);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());

    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        try (ExDBUpdatableResults<MT_DsKokyakuKanri> exDBUpdatableResults = directDomManager.
            getDsKokyakuKanrisByDskrhnnkakcdttyhkbnDskrhnnkakcdttshjyhsymd(C_DsKrHnnKakCdTtYhKbn.BLNK,BizDate.valueOf(20170424))) {

            Assert.assertFalse(exDBUpdatableResults.iterator().hasNext());
        }

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        deleteTestData();

        insertSubData2();

        try (ExDBUpdatableResults<MT_DsKokyakuKanri> exDBUpdatableResults = directDomManager.
            getDsKokyakuKanrisByDskrhnnkakcdttyhkbnDskrhnnkakcdttshjyhsymd(C_DsKrHnnKakCdTtYhKbn.YOU,BizDate.valueOf(20170424))){

            int iCount = 0;
            Iterator<MT_DsKokyakuKanri> iter = exDBUpdatableResults.iterator();
            MT_DsKokyakuKanri mT_DsKokyakuKanri = null;
            while (iter.hasNext()) {

                mT_DsKokyakuKanri = iter.next();
                iCount++;

                if (1 == iCount) {

                    Assert.assertEquals("1000000133", mT_DsKokyakuKanri.getDskokno());
                }
            }
            Assert.assertEquals(1, iCount);
        }

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        deleteTestData();

        insertSubData3();

        try (ExDBUpdatableResults<MT_DsKokyakuKanri> exDBUpdatableResults = directDomManager.
            getDsKokyakuKanrisByDskrhnnkakcdttyhkbnDskrhnnkakcdttshjyhsymd(C_DsKrHnnKakCdTtYhKbn.BLNK,BizDate.valueOf(20170426))) {

            HashMap<String,String> datamap = new HashMap<String,String>();
            datamap.put($("1000000146"), "1");
            datamap.put($("1000000159"), "2");
            datamap.put($("1000000162"), "3");
            datamap.put($("1000000175"), "4");
            datamap.put($("1000000188"), "5");
            datamap.put($("1000000191"), "6");

            Iterator<MT_DsKokyakuKanri> iter = exDBUpdatableResults.iterator();
            MT_DsKokyakuKanri mT_DsKokyakuKanri = null;
            while (iter.hasNext()) {

                mT_DsKokyakuKanri = iter.next();
                datamap.remove($(mT_DsKokyakuKanri.getDskokno()));
            }
            Assert.assertTrue(datamap.isEmpty());
        }
        try (ExDBUpdatableResults<MT_DsKokyakuKanri> exDBUpdatableResults = directDomManager.
            getDsKokyakuKanrisByDskrhnnkakcdttyhkbnDskrhnnkakcdttshjyhsymd(C_DsKrHnnKakCdTtYhKbn.YOU,BizDate.valueOf(20170426))) {

            HashMap<String,String> datamap = new HashMap<String,String>();
            datamap.put($("1000000205"), "1");
            datamap.put($("1000000218"), "2");
            datamap.put($("1000000221"), "3");
            datamap.put($("1000000234"), "4");
            datamap.put($("1000000247"), "5");
            datamap.put($("1000000250"), "6");

            Iterator<MT_DsKokyakuKanri> iter = exDBUpdatableResults.iterator();
            MT_DsKokyakuKanri mT_DsKokyakuKanri = null;
            while (iter.hasNext()) {

                mT_DsKokyakuKanri = iter.next();
                datamap.remove($(mT_DsKokyakuKanri.getDskokno()));
            }
            Assert.assertTrue(datamap.isEmpty());
        }
        try (ExDBUpdatableResults<MT_DsKokyakuKanri> exDBUpdatableResults = directDomManager.
            getDsKokyakuKanrisByDskrhnnkakcdttyhkbnDskrhnnkakcdttshjyhsymd(C_DsKrHnnKakCdTtYhKbn.TYUUDAN,BizDate.valueOf(20170426))) {

            HashMap<String,String> datamap = new HashMap<String,String>();
            datamap.put($("1000000263"), "1");
            datamap.put($("1000000276"), "2");
            datamap.put($("1000000289"), "3");
            datamap.put($("1000000292"), "4");
            datamap.put($("1000000306"), "5");
            datamap.put($("1000000319"), "6");

            Iterator<MT_DsKokyakuKanri> iter = exDBUpdatableResults.iterator();
            MT_DsKokyakuKanri mT_DsKokyakuKanri = null;
            while (iter.hasNext()) {

                mT_DsKokyakuKanri = iter.next();
                datamap.remove($(mT_DsKokyakuKanri.getDskokno()));
            }
            Assert.assertTrue(datamap.isEmpty());
        }
    }
}
