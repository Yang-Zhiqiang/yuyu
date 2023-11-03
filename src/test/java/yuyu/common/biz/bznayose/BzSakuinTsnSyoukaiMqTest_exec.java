package yuyu.common.biz.bznayose;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.configuration.CoreConfig;
import jp.co.slcs.swak.core.configuration.ProductMode;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_GaitouKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_KankeisyaKbn;
import yuyu.def.classification.C_KykJyoutaiKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_MQSyoukaiErrorKbn;
import yuyu.def.classification.C_Mfrenflg;
import yuyu.def.classification.C_MosHukaKbn;
import yuyu.def.classification.C_MossyoumetuKbn;
import yuyu.def.classification.C_MrsignalhanteigyoumuKbn;
import yuyu.def.classification.C_NayoseJissiKekkaKbn;
import yuyu.def.classification.C_NayoseJyoutaiKbn;
import yuyu.def.classification.C_NkKankeisyaKbn;
import yuyu.def.classification.C_NkSyoumetuCd;
import yuyu.def.classification.C_PalSyoukaiJissiumuKbn;
import yuyu.def.classification.C_SakuintaisyoukykKbn;
import yuyu.def.classification.C_SakuintsnSyoukaiKbn;
import yuyu.def.classification.C_SakuintsnTaisyouKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SntkinfoKbn;
import yuyu.def.classification.C_SounenfKykJyoutaiKbn;
import yuyu.def.classification.C_SueokiJyoutaiKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.infrext.mq.MqApiCaller;
import yuyu.infrext.mq.MqApiCallerStubForSinkeiyaku;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * PALあて索引通算照会（MQ）クラスのメソッド {@link BzSakuinTsnSyoukaiMq#exec(BzSakuinTsnSyoukaiYokenBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzSakuinTsnSyoukaiMqTest_exec {

    @Inject
    BizDomManager bizDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_PALあて索引通算照会（MQ）";

    private final static String sheetName = "INデータ";

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(MqApiCaller.class).to(MqApiCallerStubForSinkeiyaku.class);
            }
        });
    }

    @AfterClass
    public static void testClear() {
        MqApiCallerStubForSinkeiyaku.caller = null;
    }

    @BeforeClass
    public static void testInit() {
        MqApiCallerStubForSinkeiyaku.caller = BzSakuinTsnSyoukaiMqTest_exec.class;
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllMqBatchSosiki());
    }

    public void editYokenDate(BzSakuinTsnSyoukaiYokenBean pBzSakuinTsnSyoukaiYokenBean) {


        pBzSakuinTsnSyoukaiYokenBean.setSkintsnsyoukaikbn(C_SakuintsnSyoukaiKbn.KYKKEYSYOUKAI);

        pBzSakuinTsnSyoukaiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        pBzSakuinTsnSyoukaiYokenBean.setHuho2kykno("11807111129");

        pBzSakuinTsnSyoukaiYokenBean.setSkintsntaisyoukbn(C_SakuintsnTaisyouKbn.KYK);

        pBzSakuinTsnSyoukaiYokenBean.setTaisyounmkn("タイショウシャ");

        pBzSakuinTsnSyoukaiYokenBean.setTaisyounmkj("対象者");
        pBzSakuinTsnSyoukaiYokenBean.setTaisyouseiymd(BizDate.valueOf("19900311"));
        pBzSakuinTsnSyoukaiYokenBean.setTaisyouyno("4354008");
        pBzSakuinTsnSyoukaiYokenBean.setHhknyno("4354112");

        pBzSakuinTsnSyoukaiYokenBean.setHhknsykgycd("001");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkn1("カンケイイチ");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkj1("関係者一");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkn2("カンケイニ");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkj2("関係者二");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkn3("カンケイサン");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkj3("関係者三");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkn4("カンケイヨ");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkj4("関係者四");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkn5("カンケイゴ");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkj5("関係者五");

        pBzSakuinTsnSyoukaiYokenBean.setKanrisosikicd1("KrCd01");

        pBzSakuinTsnSyoukaiYokenBean.setKanrisosikicd2("KrCd02");
        pBzSakuinTsnSyoukaiYokenBean.setTsintelno("1560824187");
        pBzSakuinTsnSyoukaiYokenBean.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        pBzSakuinTsnSyoukaiYokenBean.setBankcd("7998");
        pBzSakuinTsnSyoukaiYokenBean.setShitencd("122");

        pBzSakuinTsnSyoukaiYokenBean.setYokinkbn(C_YokinKbn.HUTUU);
        pBzSakuinTsnSyoukaiYokenBean.setKouzano("1159234");

        pBzSakuinTsnSyoukaiYokenBean.setSkininfosyoukaiyhkbn(C_YouhiKbn.YOU);

        pBzSakuinTsnSyoukaiYokenBean.setSkintaisyoukykkbn(C_SakuintaisyoukykKbn.TAISYOU_KYK);

        pBzSakuinTsnSyoukaiYokenBean.setSkintsghuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        pBzSakuinTsnSyoukaiYokenBean.setSkintsghuho2kykno("10000000003");
        pBzSakuinTsnSyoukaiYokenBean.setSkinkijyunymd(BizDate.valueOf("19961014"));

        pBzSakuinTsnSyoukaiYokenBean.setMrsignalsyoukaiyhkbn(C_YouhiKbn.YOU);

        pBzSakuinTsnSyoukaiYokenBean.setMrsignalhanteigyoumukbn(C_MrsignalhanteigyoumuKbn.MOS_SAKUSEI);

        pBzSakuinTsnSyoukaiYokenBean.setTsngksyoukaiyhkbn(C_YouhiKbn.YOU);

        pBzSakuinTsnSyoukaiYokenBean.setTsntsghuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        pBzSakuinTsnSyoukaiYokenBean.setTsntsghuho2kykno("11807111130");
        pBzSakuinTsnSyoukaiYokenBean.setTsnkijyunymd(BizDate.valueOf("19880526"));

        pBzSakuinTsnSyoukaiYokenBean.setKykdrtentsnsssyoukaiyhkbn(C_YouhiKbn.YOU);

        pBzSakuinTsnSyoukaiYokenBean.setDrtentsntsghuho2kyknokbn(C_Huho2kyknoKbn.MOSNO);
        pBzSakuinTsnSyoukaiYokenBean.setDrtentsntsghuho2kykno("17808000020");
        pBzSakuinTsnSyoukaiYokenBean.setKykdrtentsnkijyunymd(BizDate.valueOf("19881112"));

        pBzSakuinTsnSyoukaiYokenBean.setDairitencd1("DrCd01");

        pBzSakuinTsnSyoukaiYokenBean.setDairitencd2("DrCd02");

        pBzSakuinTsnSyoukaiYokenBean.setMossakuseikahisyoukaiyhkbn(C_YouhiKbn.YOU);

        pBzSakuinTsnSyoukaiYokenBean.setHndketyhsyoukaiyhkbn(C_YouhiKbn.YOU);
    }

    public void editYokenDateb1(BzSakuinTsnSyoukaiYokenBean pBzSakuinTsnSyoukaiYokenBean) {


        pBzSakuinTsnSyoukaiYokenBean.setSkintsnsyoukaikbn(C_SakuintsnSyoukaiKbn.KYKKEYSYOUKAI);

        pBzSakuinTsnSyoukaiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        pBzSakuinTsnSyoukaiYokenBean.setHuho2kykno("11807111129");

        pBzSakuinTsnSyoukaiYokenBean.setSkintsntaisyoukbn(C_SakuintsnTaisyouKbn.KYK);

        pBzSakuinTsnSyoukaiYokenBean.setTaisyounmkn("タイショウシャ");

        pBzSakuinTsnSyoukaiYokenBean.setTaisyounmkj("対象者");
        pBzSakuinTsnSyoukaiYokenBean.setTaisyouseiymd(BizDate.valueOf("19900311"));
        pBzSakuinTsnSyoukaiYokenBean.setTaisyouyno("4354008");
        pBzSakuinTsnSyoukaiYokenBean.setHhknyno("4354112");

        pBzSakuinTsnSyoukaiYokenBean.setHhknsykgycd("001");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkn1("カンケイイチ");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkj1("関係者一");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkn2("カンケイニ");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkj2("関係者二");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkn3("カンケイサン");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkj3("関係者三");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkn4("カンケイヨ");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkj4("関係者四");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkn5("カンケイゴ");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkj5("関係者五");

        pBzSakuinTsnSyoukaiYokenBean.setKanrisosikicd1("KrCd01");

        pBzSakuinTsnSyoukaiYokenBean.setKanrisosikicd2("KrCd02");
        pBzSakuinTsnSyoukaiYokenBean.setTsintelno("1560824187");
        pBzSakuinTsnSyoukaiYokenBean.setHrkkeiro(C_Hrkkeiro.SYUUDAN);
        pBzSakuinTsnSyoukaiYokenBean.setBankcd("");
        pBzSakuinTsnSyoukaiYokenBean.setShitencd("12");

        pBzSakuinTsnSyoukaiYokenBean.setYokinkbn(C_YokinKbn.HUTUU);
        pBzSakuinTsnSyoukaiYokenBean.setKouzano("11592345");

        pBzSakuinTsnSyoukaiYokenBean.setSkininfosyoukaiyhkbn(C_YouhiKbn.YOU);

        pBzSakuinTsnSyoukaiYokenBean.setSkintaisyoukykkbn(C_SakuintaisyoukykKbn.TAISYOU_KYK);

        pBzSakuinTsnSyoukaiYokenBean.setSkintsghuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        pBzSakuinTsnSyoukaiYokenBean.setSkintsghuho2kykno("10000000003");
        pBzSakuinTsnSyoukaiYokenBean.setSkinkijyunymd(BizDate.valueOf("19961014"));

        pBzSakuinTsnSyoukaiYokenBean.setMrsignalsyoukaiyhkbn(C_YouhiKbn.YOU);

        pBzSakuinTsnSyoukaiYokenBean.setMrsignalhanteigyoumukbn(C_MrsignalhanteigyoumuKbn.MOS_SAKUSEI);

        pBzSakuinTsnSyoukaiYokenBean.setTsngksyoukaiyhkbn(C_YouhiKbn.YOU);

        pBzSakuinTsnSyoukaiYokenBean.setTsntsghuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        pBzSakuinTsnSyoukaiYokenBean.setTsntsghuho2kykno("11807111130");
        pBzSakuinTsnSyoukaiYokenBean.setTsnkijyunymd(BizDate.valueOf("19880526"));

        pBzSakuinTsnSyoukaiYokenBean.setKykdrtentsnsssyoukaiyhkbn(C_YouhiKbn.YOU);

        pBzSakuinTsnSyoukaiYokenBean.setDrtentsntsghuho2kyknokbn(C_Huho2kyknoKbn.MOSNO);
        pBzSakuinTsnSyoukaiYokenBean.setDrtentsntsghuho2kykno("17808000020");
        pBzSakuinTsnSyoukaiYokenBean.setKykdrtentsnkijyunymd(BizDate.valueOf("19881112"));

        pBzSakuinTsnSyoukaiYokenBean.setDairitencd1("DrCd01");

        pBzSakuinTsnSyoukaiYokenBean.setDairitencd2("DrCd02");

        pBzSakuinTsnSyoukaiYokenBean.setMossakuseikahisyoukaiyhkbn(C_YouhiKbn.YOU);

        pBzSakuinTsnSyoukaiYokenBean.setHndketyhsyoukaiyhkbn(C_YouhiKbn.YOU);
    }

    public void editYokenDateb2(BzSakuinTsnSyoukaiYokenBean pBzSakuinTsnSyoukaiYokenBean) {


        pBzSakuinTsnSyoukaiYokenBean.setSkintsnsyoukaikbn(C_SakuintsnSyoukaiKbn.KYKKEYSYOUKAI);

        pBzSakuinTsnSyoukaiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        pBzSakuinTsnSyoukaiYokenBean.setHuho2kykno("11807111129");

        pBzSakuinTsnSyoukaiYokenBean.setSkintsntaisyoukbn(C_SakuintsnTaisyouKbn.KYK);

        pBzSakuinTsnSyoukaiYokenBean.setTaisyounmkn("タイショウシャ");

        pBzSakuinTsnSyoukaiYokenBean.setTaisyounmkj("対象者");
        pBzSakuinTsnSyoukaiYokenBean.setTaisyouseiymd(BizDate.valueOf("19900311"));
        pBzSakuinTsnSyoukaiYokenBean.setTaisyouyno("4354008");
        pBzSakuinTsnSyoukaiYokenBean.setHhknyno("4354112");

        pBzSakuinTsnSyoukaiYokenBean.setHhknsykgycd("001");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkn1("カンケイイチ");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkj1("関係者一");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkn2("カンケイニ");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkj2("関係者二");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkn3("カンケイサン");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkj3("関係者三");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkn4("カンケイヨ");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkj4("関係者四");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkn5("カンケイゴ");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkj5("関係者五");

        pBzSakuinTsnSyoukaiYokenBean.setKanrisosikicd1("KrCd01");

        pBzSakuinTsnSyoukaiYokenBean.setKanrisosikicd2("KrCd02");
        pBzSakuinTsnSyoukaiYokenBean.setTsintelno("1560824187");
        pBzSakuinTsnSyoukaiYokenBean.setHrkkeiro(C_Hrkkeiro.CREDIT);
        pBzSakuinTsnSyoukaiYokenBean.setBankcd("7998");
        pBzSakuinTsnSyoukaiYokenBean.setShitencd("122");

        pBzSakuinTsnSyoukaiYokenBean.setYokinkbn(C_YokinKbn.HUTUU);
        pBzSakuinTsnSyoukaiYokenBean.setKouzano("115923");

        pBzSakuinTsnSyoukaiYokenBean.setSkininfosyoukaiyhkbn(C_YouhiKbn.YOU);

        pBzSakuinTsnSyoukaiYokenBean.setSkintaisyoukykkbn(C_SakuintaisyoukykKbn.TAISYOU_KYK);

        pBzSakuinTsnSyoukaiYokenBean.setSkintsghuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        pBzSakuinTsnSyoukaiYokenBean.setSkintsghuho2kykno("10000000003");
        pBzSakuinTsnSyoukaiYokenBean.setSkinkijyunymd(BizDate.valueOf("19961014"));

        pBzSakuinTsnSyoukaiYokenBean.setMrsignalsyoukaiyhkbn(C_YouhiKbn.YOU);

        pBzSakuinTsnSyoukaiYokenBean.setMrsignalhanteigyoumukbn(C_MrsignalhanteigyoumuKbn.MOS_SAKUSEI);

        pBzSakuinTsnSyoukaiYokenBean.setTsngksyoukaiyhkbn(C_YouhiKbn.YOU);

        pBzSakuinTsnSyoukaiYokenBean.setTsntsghuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        pBzSakuinTsnSyoukaiYokenBean.setTsntsghuho2kykno("11807111130");
        pBzSakuinTsnSyoukaiYokenBean.setTsnkijyunymd(BizDate.valueOf("19880526"));

        pBzSakuinTsnSyoukaiYokenBean.setKykdrtentsnsssyoukaiyhkbn(C_YouhiKbn.YOU);

        pBzSakuinTsnSyoukaiYokenBean.setDrtentsntsghuho2kyknokbn(C_Huho2kyknoKbn.MOSNO);
        pBzSakuinTsnSyoukaiYokenBean.setDrtentsntsghuho2kykno("17808000020");
        pBzSakuinTsnSyoukaiYokenBean.setKykdrtentsnkijyunymd(BizDate.valueOf("19881112"));

        pBzSakuinTsnSyoukaiYokenBean.setDairitencd1("DrCd01");

        pBzSakuinTsnSyoukaiYokenBean.setDairitencd2("DrCd02");

        pBzSakuinTsnSyoukaiYokenBean.setMossakuseikahisyoukaiyhkbn(C_YouhiKbn.YOU);

        pBzSakuinTsnSyoukaiYokenBean.setHndketyhsyoukaiyhkbn(C_YouhiKbn.YOU);
    }

    public void editYokenDateb3(BzSakuinTsnSyoukaiYokenBean pBzSakuinTsnSyoukaiYokenBean) {


        pBzSakuinTsnSyoukaiYokenBean.setSkintsnsyoukaikbn(C_SakuintsnSyoukaiKbn.KYKKEYSYOUKAI);

        pBzSakuinTsnSyoukaiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        pBzSakuinTsnSyoukaiYokenBean.setHuho2kykno("11807111129");

        pBzSakuinTsnSyoukaiYokenBean.setSkintsntaisyoukbn(C_SakuintsnTaisyouKbn.KYK);

        pBzSakuinTsnSyoukaiYokenBean.setTaisyounmkn("タイショウシャ");

        pBzSakuinTsnSyoukaiYokenBean.setTaisyounmkj("対象者");
        pBzSakuinTsnSyoukaiYokenBean.setTaisyouseiymd(BizDate.valueOf("19900311"));
        pBzSakuinTsnSyoukaiYokenBean.setTaisyouyno("4354008");
        pBzSakuinTsnSyoukaiYokenBean.setHhknyno("4354112");

        pBzSakuinTsnSyoukaiYokenBean.setHhknsykgycd("001");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkn1("カンケイイチ");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkj1("関係者一");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkn2("カンケイニ");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkj2("関係者二");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkn3("カンケイサン");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkj3("関係者三");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkn4("カンケイヨ");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkj4("関係者四");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkn5("カンケイゴ");

        pBzSakuinTsnSyoukaiYokenBean.setKankeinmkj5("関係者五");

        pBzSakuinTsnSyoukaiYokenBean.setKanrisosikicd1("KrCd01");

        pBzSakuinTsnSyoukaiYokenBean.setKanrisosikicd2("KrCd02");
        pBzSakuinTsnSyoukaiYokenBean.setTsintelno("1560824187");
        pBzSakuinTsnSyoukaiYokenBean.setHrkkeiro(C_Hrkkeiro.CREDIT);
        pBzSakuinTsnSyoukaiYokenBean.setBankcd("799");
        pBzSakuinTsnSyoukaiYokenBean.setShitencd("");

        pBzSakuinTsnSyoukaiYokenBean.setYokinkbn(C_YokinKbn.HUTUU);
        pBzSakuinTsnSyoukaiYokenBean.setKouzano("");

        pBzSakuinTsnSyoukaiYokenBean.setSkininfosyoukaiyhkbn(C_YouhiKbn.YOU);

        pBzSakuinTsnSyoukaiYokenBean.setSkintaisyoukykkbn(C_SakuintaisyoukykKbn.TAISYOU_KYK);

        pBzSakuinTsnSyoukaiYokenBean.setSkintsghuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        pBzSakuinTsnSyoukaiYokenBean.setSkintsghuho2kykno("10000000003");
        pBzSakuinTsnSyoukaiYokenBean.setSkinkijyunymd(BizDate.valueOf("19961014"));

        pBzSakuinTsnSyoukaiYokenBean.setMrsignalsyoukaiyhkbn(C_YouhiKbn.YOU);

        pBzSakuinTsnSyoukaiYokenBean.setMrsignalhanteigyoumukbn(C_MrsignalhanteigyoumuKbn.MOS_SAKUSEI);

        pBzSakuinTsnSyoukaiYokenBean.setTsngksyoukaiyhkbn(C_YouhiKbn.YOU);

        pBzSakuinTsnSyoukaiYokenBean.setTsntsghuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        pBzSakuinTsnSyoukaiYokenBean.setTsntsghuho2kykno("11807111130");
        pBzSakuinTsnSyoukaiYokenBean.setTsnkijyunymd(BizDate.valueOf("19880526"));

        pBzSakuinTsnSyoukaiYokenBean.setKykdrtentsnsssyoukaiyhkbn(C_YouhiKbn.YOU);

        pBzSakuinTsnSyoukaiYokenBean.setDrtentsntsghuho2kyknokbn(C_Huho2kyknoKbn.MOSNO);
        pBzSakuinTsnSyoukaiYokenBean.setDrtentsntsghuho2kykno("17808000020");
        pBzSakuinTsnSyoukaiYokenBean.setKykdrtentsnkijyunymd(BizDate.valueOf("19881112"));

        pBzSakuinTsnSyoukaiYokenBean.setDairitencd1("DrCd01");

        pBzSakuinTsnSyoukaiYokenBean.setDairitencd2("DrCd02");

        pBzSakuinTsnSyoukaiYokenBean.setMossakuseikahisyoukaiyhkbn(C_YouhiKbn.YOU);

        pBzSakuinTsnSyoukaiYokenBean.setHndketyhsyoukaiyhkbn(C_YouhiKbn.YOU);
    }

    public void editDataToNull(BzSakuinTsnSyoukaiYokenBean pBzSakuinTsnSyoukaiYokenBean) {


        pBzSakuinTsnSyoukaiYokenBean.setSkintsnsyoukaikbn(null);

        pBzSakuinTsnSyoukaiYokenBean.setHuho2kyknokbn(null);

        pBzSakuinTsnSyoukaiYokenBean.setSkintsntaisyoukbn(null);

        pBzSakuinTsnSyoukaiYokenBean.setHrkkeiro(null);

        pBzSakuinTsnSyoukaiYokenBean.setYokinkbn(null);

        pBzSakuinTsnSyoukaiYokenBean.setSkininfosyoukaiyhkbn(null);

        pBzSakuinTsnSyoukaiYokenBean.setSkintaisyoukykkbn(null);

        pBzSakuinTsnSyoukaiYokenBean.setSkintsghuho2kyknokbn(null);

        pBzSakuinTsnSyoukaiYokenBean.setMrsignalsyoukaiyhkbn(null);

        pBzSakuinTsnSyoukaiYokenBean.setTsngksyoukaiyhkbn(null);

        pBzSakuinTsnSyoukaiYokenBean.setTsntsghuho2kyknokbn(null);

        pBzSakuinTsnSyoukaiYokenBean.setKykdrtentsnsssyoukaiyhkbn(null);

        pBzSakuinTsnSyoukaiYokenBean.setMossakuseikahisyoukaiyhkbn(null);

        pBzSakuinTsnSyoukaiYokenBean.setHndketyhsyoukaiyhkbn(null);


        pBzSakuinTsnSyoukaiYokenBean.setMrsignalhanteigyoumukbn(null);

        pBzSakuinTsnSyoukaiYokenBean.setDrtentsntsghuho2kyknokbn(null);
    }

    public void editDataToDefault(BzSakuinTsnSyoukaiYokenBean pBzSakuinTsnSyoukaiYokenBean) {


        pBzSakuinTsnSyoukaiYokenBean.setSkintsnsyoukaikbn(C_SakuintsnSyoukaiKbn.BLNK);

        pBzSakuinTsnSyoukaiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.BLNK);

        pBzSakuinTsnSyoukaiYokenBean.setSkintsntaisyoukbn(C_SakuintsnTaisyouKbn.BLNK);

        pBzSakuinTsnSyoukaiYokenBean.setSkininfosyoukaiyhkbn(C_YouhiKbn.HUYOU);

        pBzSakuinTsnSyoukaiYokenBean.setSkintaisyoukykkbn(C_SakuintaisyoukykKbn.BLNK);

        pBzSakuinTsnSyoukaiYokenBean.setSkintsghuho2kyknokbn(C_Huho2kyknoKbn.BLNK);

        pBzSakuinTsnSyoukaiYokenBean.setMrsignalsyoukaiyhkbn(C_YouhiKbn.HUYOU);

        pBzSakuinTsnSyoukaiYokenBean.setTsngksyoukaiyhkbn(C_YouhiKbn.HUYOU);

        pBzSakuinTsnSyoukaiYokenBean.setTsntsghuho2kyknokbn(C_Huho2kyknoKbn.BLNK);

        pBzSakuinTsnSyoukaiYokenBean.setKykdrtentsnsssyoukaiyhkbn(C_YouhiKbn.HUYOU);

        pBzSakuinTsnSyoukaiYokenBean.setMossakuseikahisyoukaiyhkbn(C_YouhiKbn.HUYOU);

        pBzSakuinTsnSyoukaiYokenBean.setHndketyhsyoukaiyhkbn(C_YouhiKbn.HUYOU);


        pBzSakuinTsnSyoukaiYokenBean.setMrsignalhanteigyoumukbn(C_MrsignalhanteigyoumuKbn.BLNK);

        pBzSakuinTsnSyoukaiYokenBean.setDrtentsntsghuho2kyknokbn(C_Huho2kyknoKbn.BLNK);
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = null;

        BzSakuinTsnSyoukaiMq bzSakuinTsnSyoukaiMq = SWAKInjector.getInstance(BzSakuinTsnSyoukaiMq.class);
        BzSakuinTsnSyoukaiKekkaBean bzSakuinTsnSyoukaiKekkaBean =
            bzSakuinTsnSyoukaiMq.exec(bzSakuinTsnSyoukaiYokenBean);

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getMqsyorikekkakbn(),
            C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getPalsyoukaijissiumukbn(),
            C_PalSyoukaiJissiumuKbn.NONE, "ＰＡＬあて照会実施有無区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();


        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN2;

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean =
            SWAKInjector.getInstance(BzSakuinTsnSyoukaiYokenBean.class);


        CoreConfig.getInstance().setProductMode(ProductMode.WEB);


        editYokenDate(bzSakuinTsnSyoukaiYokenBean);

        editDataToNull(bzSakuinTsnSyoukaiYokenBean);


        BzSakuinTsnSyoukaiMq bzSakuinTsnSyoukaiMq = SWAKInjector.getInstance(BzSakuinTsnSyoukaiMq.class);
        BzSakuinTsnSyoukaiKekkaBean bzSakuinTsnSyoukaiKekkaBean =
            bzSakuinTsnSyoukaiMq.exec(bzSakuinTsnSyoukaiYokenBean);


        exStringEquals((String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 0),
            null, "処理コード");
        String bzSakuinTsnSyoukai = (String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 1);

        exStringEquals(bzSakuinTsnSyoukai.substring(0, 4), "    ", "処理コード");
        exStringEquals(bzSakuinTsnSyoukai.substring(4, 5), ".", "区切符号");

        exStringEquals(bzSakuinTsnSyoukai.substring(5, 6), " ", "索引通算照会区分");

        exStringEquals(bzSakuinTsnSyoukai.substring(6, 7), " ", "普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukai.substring(7, 18), "11807111129", "普保Ⅱ契約番号");

        exStringEquals(bzSakuinTsnSyoukai.substring(18, 19), " ", "対象者区分");
        exStringEquals(bzSakuinTsnSyoukai.substring(19, 37), "ﾀｲｼｮｳｼｬ           ", "対象者姓名");
        exStringEquals(bzSakuinTsnSyoukai.substring(37, 52), "対象者　　　　　　　　　　　　", "対象者漢字姓名");
        exStringEquals(bzSakuinTsnSyoukai.substring(52, 60), "19900311", "対象者生年月日");
        exStringEquals(bzSakuinTsnSyoukai.substring(60, 67), "4354008", "対象者郵便番号");
        exStringEquals(bzSakuinTsnSyoukai.substring(67, 74), "4354112", "被保険者新郵便番号");

        exStringEquals(bzSakuinTsnSyoukai.substring(74, 77), "001", "被保険者職業コード");

        exStringEquals(bzSakuinTsnSyoukai.substring(77, 95), "ｶﾝｹｲｲﾁ            ", "関係者名１");

        exStringEquals(bzSakuinTsnSyoukai.substring(95, 110), "関係者一　　　　　　　　　　　", "漢字関係者名１");

        exStringEquals(bzSakuinTsnSyoukai.substring(110, 128), "ｶﾝｹｲﾆ             ", "関係者名２");

        exStringEquals(bzSakuinTsnSyoukai.substring(128, 143), "関係者二　　　　　　　　　　　", "漢字関係者名２");

        exStringEquals(bzSakuinTsnSyoukai.substring(143, 161), "ｶﾝｹｲｻﾝ            ", "関係者名３");

        exStringEquals(bzSakuinTsnSyoukai.substring(161, 176), "関係者三　　　　　　　　　　　", "漢字関係者名３");

        exStringEquals(bzSakuinTsnSyoukai.substring(176, 194), "ｶﾝｹｲﾖ             ", "関係者名４");

        exStringEquals(bzSakuinTsnSyoukai.substring(194, 209), "関係者四　　　　　　　　　　　", "漢字関係者名４");

        exStringEquals(bzSakuinTsnSyoukai.substring(209, 227), "ｶﾝｹｲｺﾞ            ", "関係者名５");

        exStringEquals(bzSakuinTsnSyoukai.substring(227, 242), "関係者五　　　　　　　　　　　", "漢字関係者名５");

        exStringEquals(bzSakuinTsnSyoukai.substring(242, 249), "KrCd01 ", "Ａ扱者組織コード");

        exStringEquals(bzSakuinTsnSyoukai.substring(249, 256), "KrCd02 ", "Ｂ扱者組織コード");
        exStringEquals(bzSakuinTsnSyoukai.substring(256, 270), "1560824187    ", "通信先電話番号");
        exStringEquals(bzSakuinTsnSyoukai.substring(270, 271), " ", "払込経路");
        exStringEquals(bzSakuinTsnSyoukai.substring(271, 275), "7998", "銀行番号");
        exStringEquals(bzSakuinTsnSyoukai.substring(275, 278), "122", "支店番号");

        exStringEquals(bzSakuinTsnSyoukai.substring(278, 279), " ", "預金種目区分");
        exStringEquals(bzSakuinTsnSyoukai.substring(279, 286), "1159234", "口座番号");
        exStringEquals(bzSakuinTsnSyoukai.substring(286, 287), " ", "索引情報照会表示");

        exStringEquals(bzSakuinTsnSyoukai.substring(287, 288), " ", "索引対象契約区分");

        exStringEquals(bzSakuinTsnSyoukai.substring(288, 289), " ", "索引対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukai.substring(289, 300), "10000000003", "索引対象外普保Ⅱ契約番号");
        exStringEquals(bzSakuinTsnSyoukai.substring(300, 308), "19961014", "索引基準年月日");
        exStringEquals(bzSakuinTsnSyoukai.substring(308, 309), " ", "ＭＲシグナル照会表示");

        exStringEquals(bzSakuinTsnSyoukai.substring(309, 310), " ", "ＭＲシグナル判定業務区分");
        exStringEquals(bzSakuinTsnSyoukai.substring(310, 311), " ", "通算金額照会表示");

        exStringEquals(bzSakuinTsnSyoukai.substring(311, 312), " ", "通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukai.substring(312, 323), "11807111130", "通算対象外普保Ⅱ契約番号");
        exStringEquals(bzSakuinTsnSyoukai.substring(323, 331), "19880526", "通算基準年月日");
        exStringEquals(bzSakuinTsnSyoukai.substring(331, 332), " ", "契約者同一代理店通算Ｓ照会表示");

        exStringEquals(bzSakuinTsnSyoukai.substring(332, 333), " ", "代理店通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukai.substring(333, 344), "17808000020", "代理店通算対象外普保Ⅱ契約番号");
        exStringEquals(bzSakuinTsnSyoukai.substring(344, 352), "19881112", "契約者同一代理店通算基準年月日");

        exStringEquals(bzSakuinTsnSyoukai.substring(352, 359), "DrCd01 ", "Ａ扱者代理店コード");

        exStringEquals(bzSakuinTsnSyoukai.substring(359, 366), "DrCd02 ", "Ｂ扱者代理店コード");
        exStringEquals(bzSakuinTsnSyoukai.substring(366, 367), " ", "申込書作成可否照会表示");
        exStringEquals(bzSakuinTsnSyoukai.substring(367), " ", "ハンド決定要否照会表示");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getMqsyorikekkakbn(),
            C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getPalsyoukaijissiumukbn(),
            C_PalSyoukaiJissiumuKbn.ARI, "ＰＡＬあて照会実施有無区分");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getAcserrcd(),
            "5434", "ＡＣＳ基盤エラーコード");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {


        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN3;

        bizDomManager.delete(bizDomManager.getAllMqBatchSosiki());
        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = SWAKInjector
            .getInstance(BzSakuinTsnSyoukaiYokenBean.class);


        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);


        editYokenDate(bzSakuinTsnSyoukaiYokenBean);

        editDataToDefault(bzSakuinTsnSyoukaiYokenBean);

        BzSakuinTsnSyoukaiMq bzSakuinTsnSyoukaiMq = SWAKInjector.getInstance(BzSakuinTsnSyoukaiMq.class);
        BzSakuinTsnSyoukaiKekkaBean bzSakuinTsnSyoukaiKekkaBean =
            bzSakuinTsnSyoukaiMq.exec(bzSakuinTsnSyoukaiYokenBean);

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getMqsyorikekkakbn(),
            C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getPalsyoukaijissiumukbn(),
            C_PalSyoukaiJissiumuKbn.NONE, "ＰＡＬあて照会実施有無区分");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();


        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN4;

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = SWAKInjector
            .getInstance(BzSakuinTsnSyoukaiYokenBean.class);


        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);


        editYokenDateb1(bzSakuinTsnSyoukaiYokenBean);

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzSakuinTsnSyoukaiMqTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }

        BzSakuinTsnSyoukaiMq bzSakuinTsnSyoukaiMq = SWAKInjector.getInstance(BzSakuinTsnSyoukaiMq.class);
        BzSakuinTsnSyoukaiKekkaBean bzSakuinTsnSyoukaiKekkaBean =
            bzSakuinTsnSyoukaiMq.exec(bzSakuinTsnSyoukaiYokenBean);


        exStringEquals((String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 0), "PAR1",
            "処理コード");

        exStringEquals((String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 2), "sscd001",
            "組織コード");
        exStringEquals((String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 3),
            "                    ", "オペレータID");
        String bzSakuinTsnSyoukai = (String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 1);

        exStringEquals(bzSakuinTsnSyoukai.substring(0, 4), "PAR1", "処理コード");
        exStringEquals(bzSakuinTsnSyoukai.substring(4, 5), ".", "区切符号");

        exStringEquals(bzSakuinTsnSyoukai.substring(5, 6), "1", "索引通算照会区分");

        exStringEquals(bzSakuinTsnSyoukai.substring(6, 7), "2", "普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukai.substring(7, 18), "11807111129", "普保Ⅱ契約番号");

        exStringEquals(bzSakuinTsnSyoukai.substring(18, 19), "1", "対象者区分");
        exStringEquals(bzSakuinTsnSyoukai.substring(19, 37), "ﾀｲｼｮｳｼｬ           ", "対象者姓名");
        exStringEquals(bzSakuinTsnSyoukai.substring(37, 52), "対象者　　　　　　　　　　　　", "対象者漢字姓名");
        exStringEquals(bzSakuinTsnSyoukai.substring(52, 60), "19900311", "対象者生年月日");
        exStringEquals(bzSakuinTsnSyoukai.substring(60, 67), "4354008", "対象者郵便番号");
        exStringEquals(bzSakuinTsnSyoukai.substring(67, 74), "4354112", "被保険者新郵便番号");

        exStringEquals(bzSakuinTsnSyoukai.substring(74, 77), "001", "被保険者職業コード");

        exStringEquals(bzSakuinTsnSyoukai.substring(77, 95), "ｶﾝｹｲｲﾁ            ", "関係者名１");

        exStringEquals(bzSakuinTsnSyoukai.substring(95, 110), "関係者一　　　　　　　　　　　", "漢字関係者名１");

        exStringEquals(bzSakuinTsnSyoukai.substring(110, 128), "ｶﾝｹｲﾆ             ", "関係者名２");

        exStringEquals(bzSakuinTsnSyoukai.substring(128, 143), "関係者二　　　　　　　　　　　", "漢字関係者名２");

        exStringEquals(bzSakuinTsnSyoukai.substring(143, 161), "ｶﾝｹｲｻﾝ            ", "関係者名３");

        exStringEquals(bzSakuinTsnSyoukai.substring(161, 176), "関係者三　　　　　　　　　　　", "漢字関係者名３");

        exStringEquals(bzSakuinTsnSyoukai.substring(176, 194), "ｶﾝｹｲﾖ             ", "関係者名４");

        exStringEquals(bzSakuinTsnSyoukai.substring(194, 209), "関係者四　　　　　　　　　　　", "漢字関係者名４");

        exStringEquals(bzSakuinTsnSyoukai.substring(209, 227), "ｶﾝｹｲｺﾞ            ", "関係者名５");

        exStringEquals(bzSakuinTsnSyoukai.substring(227, 242), "関係者五　　　　　　　　　　　", "漢字関係者名５");

        exStringEquals(bzSakuinTsnSyoukai.substring(242, 249), "KrCd01 ", "Ａ扱者組織コード");

        exStringEquals(bzSakuinTsnSyoukai.substring(249, 256), "KrCd02 ", "Ｂ扱者組織コード");
        exStringEquals(bzSakuinTsnSyoukai.substring(256, 270), "1560824187    ", "通信先電話番号");
        exStringEquals(bzSakuinTsnSyoukai.substring(270, 271), "6", "払込経路");
        exStringEquals(bzSakuinTsnSyoukai.substring(271, 275), "    ", "銀行番号");
        exStringEquals(bzSakuinTsnSyoukai.substring(275, 278), "012", "支店番号");

        exStringEquals(bzSakuinTsnSyoukai.substring(278, 279), "1", "預金種目区分");
        exStringEquals(bzSakuinTsnSyoukai.substring(279, 286), "1159234", "口座番号");
        exStringEquals(bzSakuinTsnSyoukai.substring(286, 287), "1", "索引情報照会表示");

        exStringEquals(bzSakuinTsnSyoukai.substring(287, 288), "1", "索引対象契約区分");

        exStringEquals(bzSakuinTsnSyoukai.substring(288, 289), "2", "索引対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukai.substring(289, 300), "10000000003", "索引対象外普保Ⅱ契約番号");
        exStringEquals(bzSakuinTsnSyoukai.substring(300, 308), "19961014", "索引基準年月日");
        exStringEquals(bzSakuinTsnSyoukai.substring(308, 309), "1", "ＭＲシグナル照会表示");

        exStringEquals(bzSakuinTsnSyoukai.substring(309, 310), "1", "ＭＲシグナル判定業務区分");
        exStringEquals(bzSakuinTsnSyoukai.substring(310, 311), "1", "通算金額照会表示");

        exStringEquals(bzSakuinTsnSyoukai.substring(311, 312), "2", "通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukai.substring(312, 323), "11807111130", "通算対象外普保Ⅱ契約番号");
        exStringEquals(bzSakuinTsnSyoukai.substring(323, 331), "19880526", "通算基準年月日");
        exStringEquals(bzSakuinTsnSyoukai.substring(331, 332), "1", "契約者同一代理店通算Ｓ照会表示");

        exStringEquals(bzSakuinTsnSyoukai.substring(332, 333), "1", "代理店通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukai.substring(333, 344), "17808000020", "代理店通算対象外普保Ⅱ契約番号");
        exStringEquals(bzSakuinTsnSyoukai.substring(344, 352), "19881112", "契約者同一代理店通算基準年月日");

        exStringEquals(bzSakuinTsnSyoukai.substring(352, 359), "DrCd01 ", "Ａ扱者代理店コード");

        exStringEquals(bzSakuinTsnSyoukai.substring(359, 366), "DrCd02 ", "Ｂ扱者代理店コード");
        exStringEquals(bzSakuinTsnSyoukai.substring(366, 367), "1", "申込書作成可否照会表示");
        exStringEquals(bzSakuinTsnSyoukai.substring(367), "1", "ハンド決定要否照会表示");


        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getMqsyorikekkakbn(),
            C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getPalsyoukaijissiumukbn(),
            C_PalSyoukaiJissiumuKbn.ARI, "ＰＡＬあて照会実施有無区分");

        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getAcserrcd(), "0000", "ＡＣＳ基盤エラーコード");


        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSakuininfosyoukaierrkbn(),
            C_MQSyoukaiErrorKbn.SYOUKAIERROR, "索引情報照会エラー区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getMrsyoukaierrkbn(),
            C_MQSyoukaiErrorKbn.SYOUKAIOK, "ＭＲ照会エラー区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSignalsyoukaierrkbn(),
            C_MQSyoukaiErrorKbn.BLNK, "シグナル照会エラー区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSinsntkhnsysyoukaierrkbn(),
            C_MQSyoukaiErrorKbn.SYOUKAIERROR, "新選択情報反社照会エラー区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getTsngksyoukaierrkbn(),
            C_MQSyoukaiErrorKbn.SYOUKAIERROR, "通算金額照会エラー区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getKykdrtentsnssyoukaierrkbn(),
            C_MQSyoukaiErrorKbn.SYOUKAIERROR, "契約者同一代理店通算Ｓ照会エラー区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getKykdrtentsnssyoukaierrkbn(),
            C_MQSyoukaiErrorKbn.SYOUKAIERROR, "契約者同一代理店通算Ｓ照会エラー区分");
        bzSakuinTsnSyoukaiKekkaBean.getMossakuseikahisyoukaierrkbn();

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getHndketyhsyoukaierrkbn(),
            C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ハンド決定要否照会エラー区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getNysjissikekkakbn(),
            C_NayoseJissiKekkaKbn.DOUITUARI, "名寄せ実施結果区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getNysjyoutaikbn(),
            C_NayoseJyoutaiKbn.NAYOSEHUMEI, "名寄せ状態区分");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getSakuinnmno(), "1234567890", "索引名番号");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getKykmfkensuu(), 10, "契約ＭＦ個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getMosfkensuu(), 10, "申込Ｆ個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getSntkfkensuu(), 10, "選択情報Ｆ個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getSueokifkensuu(), 10, "据置Ｆ個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getNkfkensuu(), 10, "年金Ｆ個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getKhkensuu(), 10, "契約保全個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getSkkensuu(), 10, "新契約個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getNkkensuu(), 10, "年金支払個別項目設定件数");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getKykmfkensuutyoukaumu(),
            C_BlnktkumuKbn.ARI, "契約ＭＦ件数超過有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getMosfkensuutyoukaumu(),
            C_BlnktkumuKbn.ARI, "申込Ｆ件数超過有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSntkfkensuutyoukaumu(),
            C_BlnktkumuKbn.ARI, "選択情報Ｆ件数超過有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSueokifkensuutyoukaumu(),
            C_BlnktkumuKbn.ARI, "据置Ｆ件数超過有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getNkfkensuutyoukaumu(),
            C_BlnktkumuKbn.ARI, "年金Ｆ件数超過有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getKhkensuutyoukaumu(),
            C_BlnktkumuKbn.ARI, "契約保全件数超過有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSkkensuutyoukaumu(),
            C_BlnktkumuKbn.ARI, "新契約件数超過有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getNkkensuutyoukaumu(),
            C_BlnktkumuKbn.ARI, "年金支払件数超過有無区分");


        List<BzKeiyakuMfSakuinKekkaBean> kykMfSakuinKekkaBeanLst = bzSakuinTsnSyoukaiKekkaBean
            .getBzkeiyakumfsakuinkekkabeanlist();

        exNumericEquals(kykMfSakuinKekkaBeanLst.size(), 10, "契約ＭＦ索引結果Beanリストのサイズ");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(0).getKykmfsyono(), "11807111129", "（契約ＭＦ）証券番号");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(0).getKykmfkykkankeisyakbn(),
            C_KankeisyaKbn.KYK, "（契約ＭＦ）契約関係者区分");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(0).getKykmfkykmfkojinkbn(),
            "01", "（契約ＭＦ）契約ＭＦ個人区分");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(0).getKykmfkykjyoutaikbn(),
            C_KykJyoutaiKbn.SIKKOU, "（契約ＭＦ）契約状態区分");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(0).getKykmfkykymd(), BizDate.valueOf("19900311"), "（契約ＭＦ）契約日");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(0).getKykmfsyoumetucd(), "Sm00", "（契約ＭＦ）消滅コード");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(0).getKykmfsyoumetuymd(), BizDate.valueOf("19901004"), "（契約ＭＦ）消滅日");

        exDateYMEquals(kykMfSakuinKekkaBeanLst.get(0).getKykmfbosyuuym(), BizDateYM.valueOf("200010"), "（契約ＭＦ）募集年月");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(0).getKykmftaisyouseiymd(), BizDate.valueOf("19901024"),
            "（契約ＭＦ）対象者生年月日");


        exStringEquals(kykMfSakuinKekkaBeanLst.get(1).getKykmfsyono(), "11807111129", "（契約ＭＦ）証券番号");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(1).getKykmfkykkankeisyakbn(),
            C_KankeisyaKbn.KYK, "（契約ＭＦ）契約関係者区分");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(1).getKykmfkykmfkojinkbn(),
            "01", "（契約ＭＦ）契約ＭＦ個人区分");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(1).getKykmfkykjyoutaikbn(),
            C_KykJyoutaiKbn.SIKKOU, "（契約ＭＦ）契約状態区分");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(1).getKykmfkykymd(), BizDate.valueOf("19910311"), "（契約ＭＦ）契約日");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(1).getKykmfsyoumetucd(), "Sm01", "（契約ＭＦ）消滅コード");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(1).getKykmfsyoumetuymd(), BizDate.valueOf("19911004"), "（契約ＭＦ）消滅日");

        exDateYMEquals(kykMfSakuinKekkaBeanLst.get(1).getKykmfbosyuuym(), BizDateYM.valueOf("200110"), "（契約ＭＦ）募集年月");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(1).getKykmftaisyouseiymd(), BizDate.valueOf("19911024"),
            "（契約ＭＦ）対象者生年月日");


        exStringEquals(kykMfSakuinKekkaBeanLst.get(2).getKykmfsyono(), "11807111129", "（契約ＭＦ）証券番号");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(2).getKykmfkykkankeisyakbn(),
            C_KankeisyaKbn.KYK, "（契約ＭＦ）契約関係者区分");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(2).getKykmfkykmfkojinkbn(),
            "01", "（契約ＭＦ）契約ＭＦ個人区分");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(2).getKykmfkykjyoutaikbn(),
            C_KykJyoutaiKbn.SIKKOU, "（契約ＭＦ）契約状態区分");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(2).getKykmfkykymd(), BizDate.valueOf("19920311"), "（契約ＭＦ）契約日");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(2).getKykmfsyoumetucd(), "Sm02", "（契約ＭＦ）消滅コード");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(2).getKykmfsyoumetuymd(), BizDate.valueOf("19921004"), "（契約ＭＦ）消滅日");

        exDateYMEquals(kykMfSakuinKekkaBeanLst.get(2).getKykmfbosyuuym(), BizDateYM.valueOf("200210"), "（契約ＭＦ）募集年月");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(2).getKykmftaisyouseiymd(), BizDate.valueOf("19921024"),
            "（契約ＭＦ）対象者生年月日");


        exStringEquals(kykMfSakuinKekkaBeanLst.get(3).getKykmfsyono(), "11807111129", "（契約ＭＦ）証券番号");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(3).getKykmfkykkankeisyakbn(),
            C_KankeisyaKbn.KYK, "（契約ＭＦ）契約関係者区分");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(3).getKykmfkykmfkojinkbn(),
            "01", "（契約ＭＦ）契約ＭＦ個人区分");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(3).getKykmfkykjyoutaikbn(),
            C_KykJyoutaiKbn.SIKKOU, "（契約ＭＦ）契約状態区分");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(3).getKykmfkykymd(), BizDate.valueOf("19930311"), "（契約ＭＦ）契約日");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(3).getKykmfsyoumetucd(), "Sm03", "（契約ＭＦ）消滅コード");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(3).getKykmfsyoumetuymd(), BizDate.valueOf("19931004"), "（契約ＭＦ）消滅日");

        exDateYMEquals(kykMfSakuinKekkaBeanLst.get(3).getKykmfbosyuuym(), BizDateYM.valueOf("200310"), "（契約ＭＦ）募集年月");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(3).getKykmftaisyouseiymd(), BizDate.valueOf("19931024"),
            "（契約ＭＦ）対象者生年月日");


        exStringEquals(kykMfSakuinKekkaBeanLst.get(4).getKykmfsyono(), "11807111129", "（契約ＭＦ）証券番号");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(4).getKykmfkykkankeisyakbn(),
            C_KankeisyaKbn.KYK, "（契約ＭＦ）契約関係者区分");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(4).getKykmfkykmfkojinkbn(),
            "01", "（契約ＭＦ）契約ＭＦ個人区分");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(4).getKykmfkykjyoutaikbn(),
            C_KykJyoutaiKbn.SIKKOU, "（契約ＭＦ）契約状態区分");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(4).getKykmfkykymd(), BizDate.valueOf("19940311"), "（契約ＭＦ）契約日");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(4).getKykmfsyoumetucd(), "Sm04", "（契約ＭＦ）消滅コード");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(4).getKykmfsyoumetuymd(), BizDate.valueOf("19941004"), "（契約ＭＦ）消滅日");

        exDateYMEquals(kykMfSakuinKekkaBeanLst.get(4).getKykmfbosyuuym(), BizDateYM.valueOf("200410"), "（契約ＭＦ）募集年月");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(4).getKykmftaisyouseiymd(), BizDate.valueOf("19941024"),
            "（契約ＭＦ）対象者生年月日");


        exStringEquals(kykMfSakuinKekkaBeanLst.get(5).getKykmfsyono(), "11807111129", "（契約ＭＦ）証券番号");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(5).getKykmfkykkankeisyakbn(),
            C_KankeisyaKbn.KYK, "（契約ＭＦ）契約関係者区分");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(5).getKykmfkykmfkojinkbn(),
            "01", "（契約ＭＦ）契約ＭＦ個人区分");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(5).getKykmfkykjyoutaikbn(),
            C_KykJyoutaiKbn.SIKKOU, "（契約ＭＦ）契約状態区分");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(5).getKykmfkykymd(), BizDate.valueOf("19950311"), "（契約ＭＦ）契約日");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(5).getKykmfsyoumetucd(), "Sm05", "（契約ＭＦ）消滅コード");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(5).getKykmfsyoumetuymd(), BizDate.valueOf("19951004"), "（契約ＭＦ）消滅日");

        exDateYMEquals(kykMfSakuinKekkaBeanLst.get(5).getKykmfbosyuuym(), BizDateYM.valueOf("200510"), "（契約ＭＦ）募集年月");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(5).getKykmftaisyouseiymd(), BizDate.valueOf("19951024"),
            "（契約ＭＦ）対象者生年月日");


        exStringEquals(kykMfSakuinKekkaBeanLst.get(6).getKykmfsyono(), "11807111129", "（契約ＭＦ）証券番号");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(6).getKykmfkykkankeisyakbn(),
            C_KankeisyaKbn.KYK, "（契約ＭＦ）契約関係者区分");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(6).getKykmfkykmfkojinkbn(),
            "01", "（契約ＭＦ）契約ＭＦ個人区分");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(6).getKykmfkykjyoutaikbn(),
            C_KykJyoutaiKbn.SIKKOU, "（契約ＭＦ）契約状態区分");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(6).getKykmfkykymd(), BizDate.valueOf("19960311"), "（契約ＭＦ）契約日");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(6).getKykmfsyoumetucd(), "Sm06", "（契約ＭＦ）消滅コード");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(6).getKykmfsyoumetuymd(), BizDate.valueOf("19961004"), "（契約ＭＦ）消滅日");

        exDateYMEquals(kykMfSakuinKekkaBeanLst.get(6).getKykmfbosyuuym(), BizDateYM.valueOf("200610"), "（契約ＭＦ）募集年月");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(6).getKykmftaisyouseiymd(), BizDate.valueOf("19961024"),
            "（契約ＭＦ）対象者生年月日");


        exStringEquals(kykMfSakuinKekkaBeanLst.get(7).getKykmfsyono(), "11807111129", "（契約ＭＦ）証券番号");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(7).getKykmfkykkankeisyakbn(),
            C_KankeisyaKbn.KYK, "（契約ＭＦ）契約関係者区分");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(7).getKykmfkykmfkojinkbn(),
            "01", "（契約ＭＦ）契約ＭＦ個人区分");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(7).getKykmfkykjyoutaikbn(),
            C_KykJyoutaiKbn.SIKKOU, "（契約ＭＦ）契約状態区分");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(7).getKykmfkykymd(), BizDate.valueOf("19970311"), "（契約ＭＦ）契約日");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(7).getKykmfsyoumetucd(), "Sm07", "（契約ＭＦ）消滅コード");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(7).getKykmfsyoumetuymd(), BizDate.valueOf("19971004"), "（契約ＭＦ）消滅日");

        exDateYMEquals(kykMfSakuinKekkaBeanLst.get(7).getKykmfbosyuuym(), BizDateYM.valueOf("200710"), "（契約ＭＦ）募集年月");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(7).getKykmftaisyouseiymd(), BizDate.valueOf("19971024"),
            "（契約ＭＦ）対象者生年月日");


        exStringEquals(kykMfSakuinKekkaBeanLst.get(8).getKykmfsyono(), "11807111129", "（契約ＭＦ）証券番号");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(8).getKykmfkykkankeisyakbn(),
            C_KankeisyaKbn.KYK, "（契約ＭＦ）契約関係者区分");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(8).getKykmfkykmfkojinkbn(),
            "01", "（契約ＭＦ）契約ＭＦ個人区分");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(8).getKykmfkykjyoutaikbn(),
            C_KykJyoutaiKbn.SIKKOU, "（契約ＭＦ）契約状態区分");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(8).getKykmfkykymd(), BizDate.valueOf("19980311"), "（契約ＭＦ）契約日");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(8).getKykmfsyoumetucd(), "Sm08", "（契約ＭＦ）消滅コード");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(8).getKykmfsyoumetuymd(), BizDate.valueOf("19981004"), "（契約ＭＦ）消滅日");

        exDateYMEquals(kykMfSakuinKekkaBeanLst.get(8).getKykmfbosyuuym(), BizDateYM.valueOf("200810"), "（契約ＭＦ）募集年月");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(8).getKykmftaisyouseiymd(), BizDate.valueOf("19981024"),
            "（契約ＭＦ）対象者生年月日");


        exStringEquals(kykMfSakuinKekkaBeanLst.get(9).getKykmfsyono(), "11807111129", "（契約ＭＦ）証券番号");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(9).getKykmfkykkankeisyakbn(),
            C_KankeisyaKbn.KYK, "（契約ＭＦ）契約関係者区分");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(9).getKykmfkykmfkojinkbn(),
            "01", "（契約ＭＦ）契約ＭＦ個人区分");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(9).getKykmfkykjyoutaikbn(),
            C_KykJyoutaiKbn.SIKKOU, "（契約ＭＦ）契約状態区分");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(9).getKykmfkykymd(), BizDate.valueOf("19990311"), "（契約ＭＦ）契約日");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(9).getKykmfsyoumetucd(), "Sm09", "（契約ＭＦ）消滅コード");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(9).getKykmfsyoumetuymd(), BizDate.valueOf("19991004"), "（契約ＭＦ）消滅日");

        exDateYMEquals(kykMfSakuinKekkaBeanLst.get(9).getKykmfbosyuuym(), BizDateYM.valueOf("200910"), "（契約ＭＦ）募集年月");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(9).getKykmftaisyouseiymd(), BizDate.valueOf("19991024"),
            "（契約ＭＦ）対象者生年月日");


        List<BzMousikomiFSakuinKekkaBean> mousikomiFSakuinKekkaLst =
            bzSakuinTsnSyoukaiKekkaBean.getBzmousikomifsakuinkekkabeanlist();

        exNumericEquals(mousikomiFSakuinKekkaLst.size(), 10, "申込Ｆ索引結果Beanリストのサイズ");

        exStringEquals(mousikomiFSakuinKekkaLst.get(0).getMosfmosno(), "791112220", "（申込Ｆ）申込番号");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(0).getMosfmoskankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（申込Ｆ）申込関係者区分");

        exStringEquals(mousikomiFSakuinKekkaLst.get(0).getMosfmofkojinkbn(),
            "01", "（申込Ｆ）申込Ｆ個人区分");
        exClassificationEquals(mousikomiFSakuinKekkaLst.get(0).getMosfmfrenflg(),
            C_Mfrenflg.SUMI, "（申込Ｆ）ＭＦ連動済フラグ");
        exDateEquals(mousikomiFSakuinKekkaLst.get(0).getMosfmosymd(), BizDate.valueOf("19901112"), "（申込Ｆ）申込日");
        exDateEquals(mousikomiFSakuinKekkaLst.get(0).getMosfkykymd(), BizDate.valueOf("19901201"), "（申込Ｆ）契約日");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(0).getMosfmossyoumetukbn(),
            C_MossyoumetuKbn.SEIRITU, "（申込Ｆ）申込消滅区分");
        exDateEquals(mousikomiFSakuinKekkaLst.get(0).getMosfmossyoumetukktiymd(), BizDate.valueOf("19900105"),
            "（申込Ｆ）申込消滅確定日");

        exDateYMEquals(mousikomiFSakuinKekkaLst.get(0).getMosfbosyuuym(), BizDateYM.valueOf("199003"), "（申込Ｆ）募集年月");
        exDateEquals(mousikomiFSakuinKekkaLst.get(0).getMosftaisyouseiymd(), BizDate.valueOf("19801206"),
            "（申込Ｆ）対象者生年月日");


        exStringEquals(mousikomiFSakuinKekkaLst.get(1).getMosfmosno(), "791112220", "（申込Ｆ）申込番号");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(1).getMosfmoskankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（申込Ｆ）申込関係者区分");

        exStringEquals(mousikomiFSakuinKekkaLst.get(1).getMosfmofkojinkbn(),
            "01", "（申込Ｆ）申込Ｆ個人区分");
        exClassificationEquals(mousikomiFSakuinKekkaLst.get(1).getMosfmfrenflg(),
            C_Mfrenflg.SUMI, "（申込Ｆ）ＭＦ連動済フラグ");
        exDateEquals(mousikomiFSakuinKekkaLst.get(1).getMosfmosymd(), BizDate.valueOf("19911112"), "（申込Ｆ）申込日");
        exDateEquals(mousikomiFSakuinKekkaLst.get(1).getMosfkykymd(), BizDate.valueOf("19911201"), "（申込Ｆ）契約日");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(1).getMosfmossyoumetukbn(),
            C_MossyoumetuKbn.SEIRITU, "（申込Ｆ）申込消滅区分");
        exDateEquals(mousikomiFSakuinKekkaLst.get(1).getMosfmossyoumetukktiymd(), BizDate.valueOf("19910105"),
            "（申込Ｆ）申込消滅確定日");

        exDateYMEquals(mousikomiFSakuinKekkaLst.get(1).getMosfbosyuuym(), BizDateYM.valueOf("199103"), "（申込Ｆ）募集年月");
        exDateEquals(mousikomiFSakuinKekkaLst.get(1).getMosftaisyouseiymd(), BizDate.valueOf("19811206"),
            "（申込Ｆ）対象者生年月日");


        exStringEquals(mousikomiFSakuinKekkaLst.get(2).getMosfmosno(), "791112220", "（申込Ｆ）申込番号");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(2).getMosfmoskankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（申込Ｆ）申込関係者区分");

        exStringEquals(mousikomiFSakuinKekkaLst.get(2).getMosfmofkojinkbn(), "01", "（申込Ｆ）申込Ｆ個人区分");
        exClassificationEquals(mousikomiFSakuinKekkaLst.get(2).getMosfmfrenflg(),
            C_Mfrenflg.SUMI, "（申込Ｆ）ＭＦ連動済フラグ");
        exDateEquals(mousikomiFSakuinKekkaLst.get(2).getMosfmosymd(), BizDate.valueOf("19921112"), "（申込Ｆ）申込日");
        exDateEquals(mousikomiFSakuinKekkaLst.get(2).getMosfkykymd(), BizDate.valueOf("19921201"), "（申込Ｆ）契約日");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(2).getMosfmossyoumetukbn(),
            C_MossyoumetuKbn.SEIRITU, "（申込Ｆ）申込消滅区分");
        exDateEquals(mousikomiFSakuinKekkaLst.get(2).getMosfmossyoumetukktiymd(), BizDate.valueOf("19920105"),
            "（申込Ｆ）申込消滅確定日");

        exDateYMEquals(mousikomiFSakuinKekkaLst.get(2).getMosfbosyuuym(), BizDateYM.valueOf("199203"), "（申込Ｆ）募集年月");
        exDateEquals(mousikomiFSakuinKekkaLst.get(2).getMosftaisyouseiymd(), BizDate.valueOf("19821206"),
            "（申込Ｆ）対象者生年月日");


        exStringEquals(mousikomiFSakuinKekkaLst.get(3).getMosfmosno(), "791112220", "（申込Ｆ）申込番号");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(3).getMosfmoskankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（申込Ｆ）申込関係者区分");

        exStringEquals(mousikomiFSakuinKekkaLst.get(3).getMosfmofkojinkbn(), "01", "（申込Ｆ）申込Ｆ個人区分");
        exClassificationEquals(mousikomiFSakuinKekkaLst.get(3).getMosfmfrenflg(),
            C_Mfrenflg.SUMI, "（申込Ｆ）ＭＦ連動済フラグ");
        exDateEquals(mousikomiFSakuinKekkaLst.get(3).getMosfmosymd(), BizDate.valueOf("19931112"), "（申込Ｆ）申込日");
        exDateEquals(mousikomiFSakuinKekkaLst.get(3).getMosfkykymd(), BizDate.valueOf("19931201"), "（申込Ｆ）契約日");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(3).getMosfmossyoumetukbn(),
            C_MossyoumetuKbn.SEIRITU, "（申込Ｆ）申込消滅区分");
        exDateEquals(mousikomiFSakuinKekkaLst.get(3).getMosfmossyoumetukktiymd(), BizDate.valueOf("19930105"),
            "（申込Ｆ）申込消滅確定日");

        exDateYMEquals(mousikomiFSakuinKekkaLst.get(3).getMosfbosyuuym(), BizDateYM.valueOf("199303"), "（申込Ｆ）募集年月");
        exDateEquals(mousikomiFSakuinKekkaLst.get(3).getMosftaisyouseiymd(), BizDate.valueOf("19831206"),
            "（申込Ｆ）対象者生年月日");

        exStringEquals(mousikomiFSakuinKekkaLst.get(4).getMosfmosno(), "791112220", "（申込Ｆ）申込番号");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(4).getMosfmoskankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（申込Ｆ）申込関係者区分");

        exStringEquals(mousikomiFSakuinKekkaLst.get(4).getMosfmofkojinkbn(), "01", "（申込Ｆ）申込Ｆ個人区分");
        exClassificationEquals(mousikomiFSakuinKekkaLst.get(4).getMosfmfrenflg(),
            C_Mfrenflg.SUMI, "（申込Ｆ）ＭＦ連動済フラグ");
        exDateEquals(mousikomiFSakuinKekkaLst.get(4).getMosfmosymd(), BizDate.valueOf("19941112"), "（申込Ｆ）申込日");
        exDateEquals(mousikomiFSakuinKekkaLst.get(4).getMosfkykymd(), BizDate.valueOf("19941201"), "（申込Ｆ）契約日");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(4).getMosfmossyoumetukbn(),
            C_MossyoumetuKbn.SEIRITU, "（申込Ｆ）申込消滅区分");
        exDateEquals(mousikomiFSakuinKekkaLst.get(4).getMosfmossyoumetukktiymd(), BizDate.valueOf("19940105"),
            "（申込Ｆ）申込消滅確定日");

        exDateYMEquals(mousikomiFSakuinKekkaLst.get(4).getMosfbosyuuym(), BizDateYM.valueOf("199403"), "（申込Ｆ）募集年月");
        exDateEquals(mousikomiFSakuinKekkaLst.get(4).getMosftaisyouseiymd(), BizDate.valueOf("19841206"),
            "（申込Ｆ）対象者生年月日");


        exStringEquals(mousikomiFSakuinKekkaLst.get(5).getMosfmosno(), "791112220", "（申込Ｆ）申込番号");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(5).getMosfmoskankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（申込Ｆ）申込関係者区分");

        exStringEquals(mousikomiFSakuinKekkaLst.get(5).getMosfmofkojinkbn(), "01", "（申込Ｆ）申込Ｆ個人区分");
        exClassificationEquals(mousikomiFSakuinKekkaLst.get(5).getMosfmfrenflg(),
            C_Mfrenflg.SUMI, "（申込Ｆ）ＭＦ連動済フラグ");
        exDateEquals(mousikomiFSakuinKekkaLst.get(5).getMosfmosymd(), BizDate.valueOf("19951112"), "（申込Ｆ）申込日");
        exDateEquals(mousikomiFSakuinKekkaLst.get(5).getMosfkykymd(), BizDate.valueOf("19951201"), "（申込Ｆ）契約日");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(5).getMosfmossyoumetukbn(),
            C_MossyoumetuKbn.SEIRITU, "（申込Ｆ）申込消滅区分");
        exDateEquals(mousikomiFSakuinKekkaLst.get(5).getMosfmossyoumetukktiymd(), BizDate.valueOf("19950105"),
            "（申込Ｆ）申込消滅確定日");

        exDateYMEquals(mousikomiFSakuinKekkaLst.get(5).getMosfbosyuuym(), BizDateYM.valueOf("199503"), "（申込Ｆ）募集年月");
        exDateEquals(mousikomiFSakuinKekkaLst.get(5).getMosftaisyouseiymd(), BizDate.valueOf("19851206"),
            "（申込Ｆ）対象者生年月日");


        exStringEquals(mousikomiFSakuinKekkaLst.get(6).getMosfmosno(), "791112220", "（申込Ｆ）申込番号");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(6).getMosfmoskankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（申込Ｆ）申込関係者区分");

        exStringEquals(mousikomiFSakuinKekkaLst.get(6).getMosfmofkojinkbn(), "01", "（申込Ｆ）申込Ｆ個人区分");
        exClassificationEquals(mousikomiFSakuinKekkaLst.get(6).getMosfmfrenflg(),
            C_Mfrenflg.SUMI, "（申込Ｆ）ＭＦ連動済フラグ");
        exDateEquals(mousikomiFSakuinKekkaLst.get(6).getMosfmosymd(), BizDate.valueOf("19961112"), "（申込Ｆ）申込日");
        exDateEquals(mousikomiFSakuinKekkaLst.get(6).getMosfkykymd(), BizDate.valueOf("19961201"), "（申込Ｆ）契約日");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(6).getMosfmossyoumetukbn(),
            C_MossyoumetuKbn.SEIRITU, "（申込Ｆ）申込消滅区分");
        exDateEquals(mousikomiFSakuinKekkaLst.get(6).getMosfmossyoumetukktiymd(), BizDate.valueOf("19960105"),
            "（申込Ｆ）申込消滅確定日");

        exDateYMEquals(mousikomiFSakuinKekkaLst.get(6).getMosfbosyuuym(), BizDateYM.valueOf("199603"), "（申込Ｆ）募集年月");
        exDateEquals(mousikomiFSakuinKekkaLst.get(6).getMosftaisyouseiymd(), BizDate.valueOf("19861206"),
            "（申込Ｆ）対象者生年月日");


        exStringEquals(mousikomiFSakuinKekkaLst.get(7).getMosfmosno(), "791112220", "（申込Ｆ）申込番号");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(7).getMosfmoskankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（申込Ｆ）申込関係者区分");

        exStringEquals(mousikomiFSakuinKekkaLst.get(7).getMosfmofkojinkbn(),
            "01", "（申込Ｆ）申込Ｆ個人区分");
        exClassificationEquals(mousikomiFSakuinKekkaLst.get(7).getMosfmfrenflg(),
            C_Mfrenflg.SUMI, "（申込Ｆ）ＭＦ連動済フラグ");
        exDateEquals(mousikomiFSakuinKekkaLst.get(7).getMosfmosymd(), BizDate.valueOf("19971112"), "（申込Ｆ）申込日");
        exDateEquals(mousikomiFSakuinKekkaLst.get(7).getMosfkykymd(), BizDate.valueOf("19971201"), "（申込Ｆ）契約日");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(7).getMosfmossyoumetukbn(),
            C_MossyoumetuKbn.SEIRITU, "（申込Ｆ）申込消滅区分");
        exDateEquals(mousikomiFSakuinKekkaLst.get(7).getMosfmossyoumetukktiymd(), BizDate.valueOf("19970105"),
            "（申込Ｆ）申込消滅確定日");

        exDateYMEquals(mousikomiFSakuinKekkaLst.get(7).getMosfbosyuuym(), BizDateYM.valueOf("199703"), "（申込Ｆ）募集年月");
        exDateEquals(mousikomiFSakuinKekkaLst.get(7).getMosftaisyouseiymd(), BizDate.valueOf("19871206"),
            "（申込Ｆ）対象者生年月日");

        exStringEquals(mousikomiFSakuinKekkaLst.get(8).getMosfmosno(), "791112220", "（申込Ｆ）申込番号");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(8).getMosfmoskankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（申込Ｆ）申込関係者区分");

        exStringEquals(mousikomiFSakuinKekkaLst.get(8).getMosfmofkojinkbn(),
            "01", "（申込Ｆ）申込Ｆ個人区分");
        exClassificationEquals(mousikomiFSakuinKekkaLst.get(8).getMosfmfrenflg(),
            C_Mfrenflg.SUMI, "（申込Ｆ）ＭＦ連動済フラグ");
        exDateEquals(mousikomiFSakuinKekkaLst.get(8).getMosfmosymd(), BizDate.valueOf("19981112"), "（申込Ｆ）申込日");
        exDateEquals(mousikomiFSakuinKekkaLst.get(8).getMosfkykymd(), BizDate.valueOf("19981201"), "（申込Ｆ）契約日");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(8).getMosfmossyoumetukbn(),
            C_MossyoumetuKbn.SEIRITU, "（申込Ｆ）申込消滅区分");
        exDateEquals(mousikomiFSakuinKekkaLst.get(8).getMosfmossyoumetukktiymd(), BizDate.valueOf("19980105"),
            "（申込Ｆ）申込消滅確定日");

        exDateYMEquals(mousikomiFSakuinKekkaLst.get(8).getMosfbosyuuym(), BizDateYM.valueOf("199803"), "（申込Ｆ）募集年月");
        exDateEquals(mousikomiFSakuinKekkaLst.get(8).getMosftaisyouseiymd(), BizDate.valueOf("19881206"),
            "（申込Ｆ）対象者生年月日");

        exStringEquals(mousikomiFSakuinKekkaLst.get(9).getMosfmosno(), "791112220", "（申込Ｆ）申込番号");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(9).getMosfmoskankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（申込Ｆ）申込関係者区分");

        exStringEquals(mousikomiFSakuinKekkaLst.get(9).getMosfmofkojinkbn(),
            "01", "（申込Ｆ）申込Ｆ個人区分");
        exClassificationEquals(mousikomiFSakuinKekkaLst.get(9).getMosfmfrenflg(),
            C_Mfrenflg.SUMI, "（申込Ｆ）ＭＦ連動済フラグ");
        exDateEquals(mousikomiFSakuinKekkaLst.get(9).getMosfmosymd(), BizDate.valueOf("19991112"), "（申込Ｆ）申込日");
        exDateEquals(mousikomiFSakuinKekkaLst.get(9).getMosfkykymd(), BizDate.valueOf("19991201"), "（申込Ｆ）契約日");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(9).getMosfmossyoumetukbn(),
            C_MossyoumetuKbn.SEIRITU, "（申込Ｆ）申込消滅区分");
        exDateEquals(mousikomiFSakuinKekkaLst.get(9).getMosfmossyoumetukktiymd(), BizDate.valueOf("19990105"),
            "（申込Ｆ）申込消滅確定日");

        exDateYMEquals(mousikomiFSakuinKekkaLst.get(9).getMosfbosyuuym(), BizDateYM.valueOf("199903"), "（申込Ｆ）募集年月");
        exDateEquals(mousikomiFSakuinKekkaLst.get(9).getMosftaisyouseiymd(), BizDate.valueOf("19891206"),
            "（申込Ｆ）対象者生年月日");

        List<BzSentakuInfoFSakuinKekkaBean> sntInfoSakuinLst = bzSakuinTsnSyoukaiKekkaBean
            .getBzsentakuinfofsakuinkekkabeanlist();

        exNumericEquals(sntInfoSakuinLst.size(), 10, "選択情報Ｆ索引結果Beanリストのサイズ");
        exStringEquals(sntInfoSakuinLst.get(0).getSntkinfono(), "10000000003", "選択情報番号");

        exClassificationEquals(sntInfoSakuinLst.get(0).getSntkinfokankeisyakbn(), C_KankeisyaKbn.HHKN_KYKBETU,
            "選択情報関係者区分");

        exStringEquals(sntInfoSakuinLst.get(0).getSntkinfofkojinkbn(), "02", "選択情報Ｆ個人区分");

        exClassificationEquals(sntInfoSakuinLst.get(0).getSntkinfokbn(), C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sntInfoSakuinLst.get(0).getSntkinfosakuseiymd(), BizDate.valueOf("20010310"), "選択情報作成日");

        exClassificationEquals(sntInfoSakuinLst.get(0).getMrumukbn(), C_BlnktkumuKbn.ARI, "ＭＲ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(0).getDecumukbn(), C_BlnktkumuKbn.ARI, "ＤＥＣ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(0).getInfokoukanumukbn(), C_BlnktkumuKbn.ARI, "情報交換有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(0).getNyuuinkyhkshrumukbn(), C_BlnktkumuKbn.ARI, "入院給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(0).getSyujyutukyhkshrumukbn(), C_BlnktkumuKbn.ARI, "手術給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(0).getSyougaikyhkshrumukbn(), C_BlnktkumuKbn.ARI, "障害給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(0).getKoudosyougaiumukbn(), C_BlnktkumuKbn.ARI, "高度障害有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(0).getPmenumukbn(), C_BlnktkumuKbn.ARI, "Ｐ免有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(0).getTorikaijoumukbn(), C_BlnktkumuKbn.ARI, "取消解除有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(0).getSoukikeakyhkshrumukbn(), C_BlnktkumuKbn.ARI, "早期ケア給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(0).getSonotakyhkshrumukbn(), C_BlnktkumuKbn.ARI, "その他給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(0).getKghsjjtkyhkshrumukbn(), C_BlnktkumuKbn.ARI, "介護保障充実給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(0).getHuho2mrumukbn(), C_BlnktkumuKbn.ARI, "普保ⅡＭＲ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(0).getHuho2decumukbn(), C_BlnktkumuKbn.ARI, "普保ⅡＤＥＣ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(0).getHuho2kdumukbn(), C_BlnktkumuKbn.ARI, "普保Ⅱ高度障害有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(0).getHuho2torikaijoumukbn(), C_BlnktkumuKbn.ARI, "普保Ⅱ取消解除有無区分");

        exStringEquals(sntInfoSakuinLst.get(1).getSntkinfono(), "10000000003", "選択情報番号");

        exClassificationEquals(sntInfoSakuinLst.get(1).getSntkinfokankeisyakbn(), C_KankeisyaKbn.HHKN_KYKBETU,
            "選択情報関係者区分");

        exStringEquals(sntInfoSakuinLst.get(1).getSntkinfofkojinkbn(), "02", "選択情報Ｆ個人区分");

        exClassificationEquals(sntInfoSakuinLst.get(1).getSntkinfokbn(), C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sntInfoSakuinLst.get(1).getSntkinfosakuseiymd(), BizDate.valueOf("20010311"), "選択情報作成日");

        exClassificationEquals(sntInfoSakuinLst.get(1).getMrumukbn(), C_BlnktkumuKbn.ARI, "ＭＲ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(1).getDecumukbn(), C_BlnktkumuKbn.ARI, "ＤＥＣ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(1).getInfokoukanumukbn(), C_BlnktkumuKbn.ARI, "情報交換有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(1).getNyuuinkyhkshrumukbn(), C_BlnktkumuKbn.ARI, "入院給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(1).getSyujyutukyhkshrumukbn(), C_BlnktkumuKbn.ARI, "手術給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(1).getSyougaikyhkshrumukbn(), C_BlnktkumuKbn.ARI, "障害給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(1).getKoudosyougaiumukbn(), C_BlnktkumuKbn.ARI, "高度障害有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(1).getPmenumukbn(), C_BlnktkumuKbn.ARI, "Ｐ免有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(1).getTorikaijoumukbn(), C_BlnktkumuKbn.ARI, "取消解除有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(1).getSoukikeakyhkshrumukbn(), C_BlnktkumuKbn.ARI, "早期ケア給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(1).getSonotakyhkshrumukbn(), C_BlnktkumuKbn.ARI, "その他給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(1).getKghsjjtkyhkshrumukbn(), C_BlnktkumuKbn.ARI, "介護保障充実給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(1).getHuho2mrumukbn(), C_BlnktkumuKbn.ARI, "普保ⅡＭＲ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(1).getHuho2decumukbn(), C_BlnktkumuKbn.ARI, "普保ⅡＤＥＣ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(1).getHuho2kdumukbn(), C_BlnktkumuKbn.ARI, "普保Ⅱ高度障害有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(1).getHuho2torikaijoumukbn(), C_BlnktkumuKbn.ARI, "普保Ⅱ取消解除有無区分");

        exStringEquals(sntInfoSakuinLst.get(2).getSntkinfono(), "10000000003", "選択情報番号");

        exClassificationEquals(sntInfoSakuinLst.get(2).getSntkinfokankeisyakbn(), C_KankeisyaKbn.HHKN_KYKBETU,
            "選択情報関係者区分");

        exStringEquals(sntInfoSakuinLst.get(2).getSntkinfofkojinkbn(), "02", "選択情報Ｆ個人区分");

        exClassificationEquals(sntInfoSakuinLst.get(2).getSntkinfokbn(), C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sntInfoSakuinLst.get(2).getSntkinfosakuseiymd(), BizDate.valueOf("20010312"), "選択情報作成日");

        exClassificationEquals(sntInfoSakuinLst.get(2).getMrumukbn(), C_BlnktkumuKbn.ARI, "ＭＲ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(2).getDecumukbn(), C_BlnktkumuKbn.ARI, "ＤＥＣ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(2).getInfokoukanumukbn(), C_BlnktkumuKbn.ARI, "情報交換有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(2).getNyuuinkyhkshrumukbn(), C_BlnktkumuKbn.ARI, "入院給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(2).getSyujyutukyhkshrumukbn(), C_BlnktkumuKbn.ARI, "手術給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(2).getSyougaikyhkshrumukbn(), C_BlnktkumuKbn.ARI, "障害給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(2).getKoudosyougaiumukbn(), C_BlnktkumuKbn.ARI, "高度障害有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(2).getPmenumukbn(), C_BlnktkumuKbn.ARI, "Ｐ免有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(2).getTorikaijoumukbn(), C_BlnktkumuKbn.ARI, "取消解除有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(2).getSoukikeakyhkshrumukbn(), C_BlnktkumuKbn.ARI, "早期ケア給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(2).getSonotakyhkshrumukbn(), C_BlnktkumuKbn.ARI, "その他給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(2).getKghsjjtkyhkshrumukbn(), C_BlnktkumuKbn.ARI, "介護保障充実給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(2).getHuho2mrumukbn(), C_BlnktkumuKbn.ARI, "普保ⅡＭＲ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(2).getHuho2decumukbn(), C_BlnktkumuKbn.ARI, "普保ⅡＤＥＣ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(2).getHuho2kdumukbn(), C_BlnktkumuKbn.ARI, "普保Ⅱ高度障害有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(2).getHuho2torikaijoumukbn(), C_BlnktkumuKbn.ARI, "普保Ⅱ取消解除有無区分");

        exStringEquals(sntInfoSakuinLst.get(3).getSntkinfono(), "10000000003", "選択情報番号");

        exClassificationEquals(sntInfoSakuinLst.get(3).getSntkinfokankeisyakbn(), C_KankeisyaKbn.HHKN_KYKBETU,
            "選択情報関係者区分");

        exStringEquals(sntInfoSakuinLst.get(3).getSntkinfofkojinkbn(), "02", "選択情報Ｆ個人区分");

        exClassificationEquals(sntInfoSakuinLst.get(3).getSntkinfokbn(), C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sntInfoSakuinLst.get(3).getSntkinfosakuseiymd(), BizDate.valueOf("20010313"), "選択情報作成日");

        exClassificationEquals(sntInfoSakuinLst.get(3).getMrumukbn(), C_BlnktkumuKbn.ARI, "ＭＲ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(3).getDecumukbn(), C_BlnktkumuKbn.ARI, "ＤＥＣ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(3).getInfokoukanumukbn(), C_BlnktkumuKbn.ARI, "情報交換有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(3).getNyuuinkyhkshrumukbn(), C_BlnktkumuKbn.ARI, "入院給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(3).getSyujyutukyhkshrumukbn(), C_BlnktkumuKbn.ARI, "手術給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(3).getSyougaikyhkshrumukbn(), C_BlnktkumuKbn.ARI, "障害給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(3).getKoudosyougaiumukbn(), C_BlnktkumuKbn.ARI, "高度障害有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(3).getPmenumukbn(), C_BlnktkumuKbn.ARI, "Ｐ免有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(3).getTorikaijoumukbn(), C_BlnktkumuKbn.ARI, "取消解除有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(3).getSoukikeakyhkshrumukbn(), C_BlnktkumuKbn.ARI, "早期ケア給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(3).getSonotakyhkshrumukbn(), C_BlnktkumuKbn.ARI, "その他給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(3).getKghsjjtkyhkshrumukbn(), C_BlnktkumuKbn.ARI, "介護保障充実給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(3).getHuho2mrumukbn(), C_BlnktkumuKbn.ARI, "普保ⅡＭＲ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(3).getHuho2decumukbn(), C_BlnktkumuKbn.ARI, "普保ⅡＤＥＣ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(3).getHuho2kdumukbn(), C_BlnktkumuKbn.ARI, "普保Ⅱ高度障害有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(3).getHuho2torikaijoumukbn(), C_BlnktkumuKbn.ARI, "普保Ⅱ取消解除有無区分");

        exStringEquals(sntInfoSakuinLst.get(4).getSntkinfono(), "10000000003", "選択情報番号");

        exClassificationEquals(sntInfoSakuinLst.get(4).getSntkinfokankeisyakbn(), C_KankeisyaKbn.HHKN_KYKBETU,
            "選択情報関係者区分");

        exStringEquals(sntInfoSakuinLst.get(4).getSntkinfofkojinkbn(), "02", "選択情報Ｆ個人区分");

        exClassificationEquals(sntInfoSakuinLst.get(4).getSntkinfokbn(), C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sntInfoSakuinLst.get(4).getSntkinfosakuseiymd(), BizDate.valueOf("20010314"), "選択情報作成日");

        exClassificationEquals(sntInfoSakuinLst.get(4).getMrumukbn(), C_BlnktkumuKbn.ARI, "ＭＲ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(4).getDecumukbn(), C_BlnktkumuKbn.ARI, "ＤＥＣ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(4).getInfokoukanumukbn(), C_BlnktkumuKbn.ARI, "情報交換有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(4).getNyuuinkyhkshrumukbn(), C_BlnktkumuKbn.ARI, "入院給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(4).getSyujyutukyhkshrumukbn(), C_BlnktkumuKbn.ARI, "手術給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(4).getSyougaikyhkshrumukbn(), C_BlnktkumuKbn.ARI, "障害給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(4).getKoudosyougaiumukbn(), C_BlnktkumuKbn.ARI, "高度障害有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(4).getPmenumukbn(), C_BlnktkumuKbn.ARI, "Ｐ免有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(4).getTorikaijoumukbn(), C_BlnktkumuKbn.ARI, "取消解除有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(4).getSoukikeakyhkshrumukbn(), C_BlnktkumuKbn.ARI, "早期ケア給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(4).getSonotakyhkshrumukbn(), C_BlnktkumuKbn.ARI, "その他給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(4).getKghsjjtkyhkshrumukbn(), C_BlnktkumuKbn.ARI, "介護保障充実給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(4).getHuho2mrumukbn(), C_BlnktkumuKbn.ARI, "普保ⅡＭＲ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(4).getHuho2decumukbn(), C_BlnktkumuKbn.ARI, "普保ⅡＤＥＣ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(4).getHuho2kdumukbn(), C_BlnktkumuKbn.ARI, "普保Ⅱ高度障害有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(4).getHuho2torikaijoumukbn(), C_BlnktkumuKbn.ARI, "普保Ⅱ取消解除有無区分");

        exStringEquals(sntInfoSakuinLst.get(5).getSntkinfono(), "10000000003", "選択情報番号");

        exClassificationEquals(sntInfoSakuinLst.get(5).getSntkinfokankeisyakbn(), C_KankeisyaKbn.HHKN_KYKBETU,
            "選択情報関係者区分");

        exStringEquals(sntInfoSakuinLst.get(5).getSntkinfofkojinkbn(), "02", "選択情報Ｆ個人区分");

        exClassificationEquals(sntInfoSakuinLst.get(5).getSntkinfokbn(), C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sntInfoSakuinLst.get(5).getSntkinfosakuseiymd(), BizDate.valueOf("20010315"), "選択情報作成日");

        exClassificationEquals(sntInfoSakuinLst.get(5).getMrumukbn(), C_BlnktkumuKbn.ARI, "ＭＲ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(5).getDecumukbn(), C_BlnktkumuKbn.ARI, "ＤＥＣ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(5).getInfokoukanumukbn(), C_BlnktkumuKbn.ARI, "情報交換有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(5).getNyuuinkyhkshrumukbn(), C_BlnktkumuKbn.ARI, "入院給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(5).getSyujyutukyhkshrumukbn(), C_BlnktkumuKbn.ARI, "手術給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(5).getSyougaikyhkshrumukbn(), C_BlnktkumuKbn.ARI, "障害給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(5).getKoudosyougaiumukbn(), C_BlnktkumuKbn.ARI, "高度障害有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(5).getPmenumukbn(), C_BlnktkumuKbn.ARI, "Ｐ免有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(5).getTorikaijoumukbn(), C_BlnktkumuKbn.ARI, "取消解除有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(5).getSoukikeakyhkshrumukbn(), C_BlnktkumuKbn.ARI, "早期ケア給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(5).getSonotakyhkshrumukbn(), C_BlnktkumuKbn.ARI, "その他給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(5).getKghsjjtkyhkshrumukbn(), C_BlnktkumuKbn.ARI, "介護保障充実給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(5).getHuho2mrumukbn(), C_BlnktkumuKbn.ARI, "普保ⅡＭＲ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(5).getHuho2decumukbn(), C_BlnktkumuKbn.ARI, "普保ⅡＤＥＣ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(5).getHuho2kdumukbn(), C_BlnktkumuKbn.ARI, "普保Ⅱ高度障害有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(5).getHuho2torikaijoumukbn(), C_BlnktkumuKbn.ARI, "普保Ⅱ取消解除有無区分");

        exStringEquals(sntInfoSakuinLst.get(6).getSntkinfono(), "10000000003", "選択情報番号");

        exClassificationEquals(sntInfoSakuinLst.get(6).getSntkinfokankeisyakbn(), C_KankeisyaKbn.HHKN_KYKBETU,
            "選択情報関係者区分");

        exStringEquals(sntInfoSakuinLst.get(6).getSntkinfofkojinkbn(), "02", "選択情報Ｆ個人区分");

        exClassificationEquals(sntInfoSakuinLst.get(6).getSntkinfokbn(), C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sntInfoSakuinLst.get(6).getSntkinfosakuseiymd(), BizDate.valueOf("20010316"), "選択情報作成日");

        exClassificationEquals(sntInfoSakuinLst.get(6).getMrumukbn(), C_BlnktkumuKbn.ARI, "ＭＲ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(6).getDecumukbn(), C_BlnktkumuKbn.ARI, "ＤＥＣ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(6).getInfokoukanumukbn(), C_BlnktkumuKbn.ARI, "情報交換有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(6).getNyuuinkyhkshrumukbn(), C_BlnktkumuKbn.ARI, "入院給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(6).getSyujyutukyhkshrumukbn(), C_BlnktkumuKbn.ARI, "手術給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(6).getSyougaikyhkshrumukbn(), C_BlnktkumuKbn.ARI, "障害給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(6).getKoudosyougaiumukbn(), C_BlnktkumuKbn.ARI, "高度障害有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(6).getPmenumukbn(), C_BlnktkumuKbn.ARI, "Ｐ免有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(6).getTorikaijoumukbn(), C_BlnktkumuKbn.ARI, "取消解除有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(6).getSoukikeakyhkshrumukbn(), C_BlnktkumuKbn.ARI, "早期ケア給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(6).getSonotakyhkshrumukbn(), C_BlnktkumuKbn.ARI, "その他給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(6).getKghsjjtkyhkshrumukbn(), C_BlnktkumuKbn.ARI, "介護保障充実給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(6).getHuho2mrumukbn(), C_BlnktkumuKbn.ARI, "普保ⅡＭＲ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(6).getHuho2decumukbn(), C_BlnktkumuKbn.ARI, "普保ⅡＤＥＣ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(6).getHuho2kdumukbn(), C_BlnktkumuKbn.ARI, "普保Ⅱ高度障害有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(6).getHuho2torikaijoumukbn(), C_BlnktkumuKbn.ARI, "普保Ⅱ取消解除有無区分");

        exStringEquals(sntInfoSakuinLst.get(7).getSntkinfono(), "10000000003", "選択情報番号");

        exClassificationEquals(sntInfoSakuinLst.get(7).getSntkinfokankeisyakbn(), C_KankeisyaKbn.HHKN_KYKBETU,
            "選択情報関係者区分");

        exStringEquals(sntInfoSakuinLst.get(7).getSntkinfofkojinkbn(), "02", "選択情報Ｆ個人区分");

        exClassificationEquals(sntInfoSakuinLst.get(7).getSntkinfokbn(), C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sntInfoSakuinLst.get(7).getSntkinfosakuseiymd(), BizDate.valueOf("20010317"), "選択情報作成日");

        exClassificationEquals(sntInfoSakuinLst.get(7).getMrumukbn(), C_BlnktkumuKbn.ARI, "ＭＲ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(7).getDecumukbn(), C_BlnktkumuKbn.ARI, "ＤＥＣ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(7).getInfokoukanumukbn(), C_BlnktkumuKbn.ARI, "情報交換有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(7).getNyuuinkyhkshrumukbn(), C_BlnktkumuKbn.ARI, "入院給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(7).getSyujyutukyhkshrumukbn(), C_BlnktkumuKbn.ARI, "手術給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(7).getSyougaikyhkshrumukbn(), C_BlnktkumuKbn.ARI, "障害給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(7).getKoudosyougaiumukbn(), C_BlnktkumuKbn.ARI, "高度障害有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(7).getPmenumukbn(), C_BlnktkumuKbn.ARI, "Ｐ免有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(7).getTorikaijoumukbn(), C_BlnktkumuKbn.ARI, "取消解除有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(7).getSoukikeakyhkshrumukbn(), C_BlnktkumuKbn.ARI, "早期ケア給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(7).getSonotakyhkshrumukbn(), C_BlnktkumuKbn.ARI, "その他給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(7).getKghsjjtkyhkshrumukbn(), C_BlnktkumuKbn.ARI, "介護保障充実給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(7).getHuho2mrumukbn(), C_BlnktkumuKbn.ARI, "普保ⅡＭＲ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(7).getHuho2decumukbn(), C_BlnktkumuKbn.ARI, "普保ⅡＤＥＣ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(7).getHuho2kdumukbn(), C_BlnktkumuKbn.ARI, "普保Ⅱ高度障害有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(7).getHuho2torikaijoumukbn(), C_BlnktkumuKbn.ARI, "普保Ⅱ取消解除有無区分");

        exStringEquals(sntInfoSakuinLst.get(8).getSntkinfono(), "10000000003", "選択情報番号");

        exClassificationEquals(sntInfoSakuinLst.get(8).getSntkinfokankeisyakbn(), C_KankeisyaKbn.HHKN_KYKBETU,
            "選択情報関係者区分");

        exStringEquals(sntInfoSakuinLst.get(8).getSntkinfofkojinkbn(), "02", "選択情報Ｆ個人区分");

        exClassificationEquals(sntInfoSakuinLst.get(8).getSntkinfokbn(), C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sntInfoSakuinLst.get(8).getSntkinfosakuseiymd(), BizDate.valueOf("20010318"), "選択情報作成日");

        exClassificationEquals(sntInfoSakuinLst.get(8).getMrumukbn(), C_BlnktkumuKbn.ARI, "ＭＲ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(8).getDecumukbn(), C_BlnktkumuKbn.ARI, "ＤＥＣ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(8).getInfokoukanumukbn(), C_BlnktkumuKbn.ARI, "情報交換有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(8).getNyuuinkyhkshrumukbn(), C_BlnktkumuKbn.ARI, "入院給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(8).getSyujyutukyhkshrumukbn(), C_BlnktkumuKbn.ARI, "手術給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(8).getSyougaikyhkshrumukbn(), C_BlnktkumuKbn.ARI, "障害給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(8).getKoudosyougaiumukbn(), C_BlnktkumuKbn.ARI, "高度障害有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(8).getPmenumukbn(), C_BlnktkumuKbn.ARI, "Ｐ免有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(8).getTorikaijoumukbn(), C_BlnktkumuKbn.ARI, "取消解除有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(8).getSoukikeakyhkshrumukbn(), C_BlnktkumuKbn.ARI, "早期ケア給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(8).getSonotakyhkshrumukbn(), C_BlnktkumuKbn.ARI, "その他給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(8).getKghsjjtkyhkshrumukbn(), C_BlnktkumuKbn.ARI, "介護保障充実給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(8).getHuho2mrumukbn(), C_BlnktkumuKbn.ARI, "普保ⅡＭＲ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(8).getHuho2decumukbn(), C_BlnktkumuKbn.ARI, "普保ⅡＤＥＣ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(8).getHuho2kdumukbn(), C_BlnktkumuKbn.ARI, "普保Ⅱ高度障害有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(8).getHuho2torikaijoumukbn(), C_BlnktkumuKbn.ARI, "普保Ⅱ取消解除有無区分");

        exStringEquals(sntInfoSakuinLst.get(9).getSntkinfono(), "10000000003", "選択情報番号");

        exClassificationEquals(sntInfoSakuinLst.get(9).getSntkinfokankeisyakbn(), C_KankeisyaKbn.HHKN_KYKBETU,
            "選択情報関係者区分");

        exStringEquals(sntInfoSakuinLst.get(9).getSntkinfofkojinkbn(), "02", "選択情報Ｆ個人区分");

        exClassificationEquals(sntInfoSakuinLst.get(9).getSntkinfokbn(), C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sntInfoSakuinLst.get(9).getSntkinfosakuseiymd(), BizDate.valueOf("20010319"), "選択情報作成日");

        exClassificationEquals(sntInfoSakuinLst.get(9).getMrumukbn(), C_BlnktkumuKbn.ARI, "ＭＲ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(9).getDecumukbn(), C_BlnktkumuKbn.ARI, "ＤＥＣ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(9).getInfokoukanumukbn(), C_BlnktkumuKbn.ARI, "情報交換有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(9).getNyuuinkyhkshrumukbn(), C_BlnktkumuKbn.ARI, "入院給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(9).getSyujyutukyhkshrumukbn(), C_BlnktkumuKbn.ARI, "手術給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(9).getSyougaikyhkshrumukbn(), C_BlnktkumuKbn.ARI, "障害給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(9).getKoudosyougaiumukbn(), C_BlnktkumuKbn.ARI, "高度障害有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(9).getPmenumukbn(), C_BlnktkumuKbn.ARI, "Ｐ免有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(9).getTorikaijoumukbn(), C_BlnktkumuKbn.ARI, "取消解除有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(9).getSoukikeakyhkshrumukbn(), C_BlnktkumuKbn.ARI, "早期ケア給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(9).getSonotakyhkshrumukbn(), C_BlnktkumuKbn.ARI, "その他給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(9).getKghsjjtkyhkshrumukbn(), C_BlnktkumuKbn.ARI, "介護保障充実給付金支払有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(9).getHuho2mrumukbn(), C_BlnktkumuKbn.ARI, "普保ⅡＭＲ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(9).getHuho2decumukbn(), C_BlnktkumuKbn.ARI, "普保ⅡＤＥＣ有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(9).getHuho2kdumukbn(), C_BlnktkumuKbn.ARI, "普保Ⅱ高度障害有無区分");

        exClassificationEquals(sntInfoSakuinLst.get(9).getHuho2torikaijoumukbn(), C_BlnktkumuKbn.ARI, "普保Ⅱ取消解除有無区分");


        List<BzHokenkinSueokiFSakuinKekkaBean> hokenkinSueokFLst = bzSakuinTsnSyoukaiKekkaBean
            .getBzhokenkinsueokifsakuinkekkabeanlist();
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getBzhokenkinsueokifsakuinkekkabeanlist().size(), 10,
            "保険金据置Ｆ索引結果Beanリストのサイズ");

        exStringEquals(hokenkinSueokFLst.get(0).getSueokifsysyno(), "11807111174", "（据置Ｆ）証書番号");

        exClassificationEquals(hokenkinSueokFLst.get(0).getSueokifhknkinkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（据置Ｆ）保険金据置関係者区分");

        exStringEquals(hokenkinSueokFLst.get(0).getSueokifhknkinkojinkbn(),
            "01", "（据置Ｆ）保険金据置Ｆ個人区分");

        exClassificationEquals(hokenkinSueokFLst.get(0).getSueokifsueokijtkbn(),
            C_SueokiJyoutaiKbn.MANRYOU, "（据置Ｆ）据置状態区分");
        exDateEquals(hokenkinSueokFLst.get(0).getSueokifsueokikaisiymd(), BizDate.valueOf("20000327"), "（申込Ｆ）据置開始日");
        exNumericEquals(hokenkinSueokFLst.get(0).getSueokifsueokikkn(), 12, "（据置Ｆ）据置期間");
        exDateEquals(hokenkinSueokFLst.get(0).getSueokifuktseiymd(), BizDate.valueOf("19900127"), "（申込Ｆ）受取人生年月日");

        exStringEquals(hokenkinSueokFLst.get(1).getSueokifsysyno(), "11807111174", "（据置Ｆ）証書番号");

        exClassificationEquals(hokenkinSueokFLst.get(1).getSueokifhknkinkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（据置Ｆ）保険金据置関係者区分");

        exStringEquals(hokenkinSueokFLst.get(1).getSueokifhknkinkojinkbn(),
            "01", "（据置Ｆ）保険金据置Ｆ個人区分");

        exClassificationEquals(hokenkinSueokFLst.get(1).getSueokifsueokijtkbn(),
            C_SueokiJyoutaiKbn.MANRYOU, "（据置Ｆ）据置状態区分");
        exDateEquals(hokenkinSueokFLst.get(1).getSueokifsueokikaisiymd(), BizDate.valueOf("20010327"), "（申込Ｆ）据置開始日");
        exNumericEquals(hokenkinSueokFLst.get(1).getSueokifsueokikkn(), 12, "（据置Ｆ）据置期間");
        exDateEquals(hokenkinSueokFLst.get(1).getSueokifuktseiymd(), BizDate.valueOf("19910127"), "（申込Ｆ）受取人生年月日");

        exStringEquals(hokenkinSueokFLst.get(2).getSueokifsysyno(), "11807111174", "（据置Ｆ）証書番号");

        exClassificationEquals(hokenkinSueokFLst.get(2).getSueokifhknkinkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（据置Ｆ）保険金据置関係者区分");

        exStringEquals(hokenkinSueokFLst.get(2).getSueokifhknkinkojinkbn(),
            "01", "（据置Ｆ）保険金据置Ｆ個人区分");

        exClassificationEquals(hokenkinSueokFLst.get(2).getSueokifsueokijtkbn(),
            C_SueokiJyoutaiKbn.MANRYOU, "（据置Ｆ）据置状態区分");
        exDateEquals(hokenkinSueokFLst.get(2).getSueokifsueokikaisiymd(), BizDate.valueOf("20020327"), "（申込Ｆ）据置開始日");
        exNumericEquals(hokenkinSueokFLst.get(2).getSueokifsueokikkn(), 12, "（据置Ｆ）据置期間");
        exDateEquals(hokenkinSueokFLst.get(2).getSueokifuktseiymd(), BizDate.valueOf("19920127"), "（申込Ｆ）受取人生年月日");

        exStringEquals(hokenkinSueokFLst.get(3).getSueokifsysyno(), "11807111174", "（据置Ｆ）証書番号");

        exClassificationEquals(hokenkinSueokFLst.get(3).getSueokifhknkinkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（据置Ｆ）保険金据置関係者区分");

        exStringEquals(hokenkinSueokFLst.get(3).getSueokifhknkinkojinkbn(),
            "01", "（据置Ｆ）保険金据置Ｆ個人区分");

        exClassificationEquals(hokenkinSueokFLst.get(3).getSueokifsueokijtkbn(),
            C_SueokiJyoutaiKbn.MANRYOU, "（据置Ｆ）据置状態区分");
        exDateEquals(hokenkinSueokFLst.get(3).getSueokifsueokikaisiymd(), BizDate.valueOf("20030327"), "（申込Ｆ）据置開始日");
        exNumericEquals(hokenkinSueokFLst.get(3).getSueokifsueokikkn(), 12, "（据置Ｆ）据置期間");
        exDateEquals(hokenkinSueokFLst.get(3).getSueokifuktseiymd(), BizDate.valueOf("19930127"), "（申込Ｆ）受取人生年月日");

        exStringEquals(hokenkinSueokFLst.get(4).getSueokifsysyno(), "11807111174", "（据置Ｆ）証書番号");

        exClassificationEquals(hokenkinSueokFLst.get(4).getSueokifhknkinkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（据置Ｆ）保険金据置関係者区分");

        exStringEquals(hokenkinSueokFLst.get(4).getSueokifhknkinkojinkbn(),
            "01", "（据置Ｆ）保険金据置Ｆ個人区分");

        exClassificationEquals(hokenkinSueokFLst.get(4).getSueokifsueokijtkbn(),
            C_SueokiJyoutaiKbn.MANRYOU, "（据置Ｆ）据置状態区分");
        exDateEquals(hokenkinSueokFLst.get(4).getSueokifsueokikaisiymd(), BizDate.valueOf("20040327"), "（申込Ｆ）据置開始日");
        exNumericEquals(hokenkinSueokFLst.get(4).getSueokifsueokikkn(), 12, "（据置Ｆ）据置期間");
        exDateEquals(hokenkinSueokFLst.get(4).getSueokifuktseiymd(), BizDate.valueOf("19940127"), "（申込Ｆ）受取人生年月日");

        exStringEquals(hokenkinSueokFLst.get(5).getSueokifsysyno(), "11807111174", "（据置Ｆ）証書番号");

        exClassificationEquals(hokenkinSueokFLst.get(5).getSueokifhknkinkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（据置Ｆ）保険金据置関係者区分");

        exStringEquals(hokenkinSueokFLst.get(5).getSueokifhknkinkojinkbn(),
            "01", "（据置Ｆ）保険金据置Ｆ個人区分");

        exClassificationEquals(hokenkinSueokFLst.get(5).getSueokifsueokijtkbn(),
            C_SueokiJyoutaiKbn.MANRYOU, "（据置Ｆ）据置状態区分");
        exDateEquals(hokenkinSueokFLst.get(5).getSueokifsueokikaisiymd(), BizDate.valueOf("20050327"), "（申込Ｆ）据置開始日");
        exNumericEquals(hokenkinSueokFLst.get(5).getSueokifsueokikkn(), 12, "（据置Ｆ）据置期間");
        exDateEquals(hokenkinSueokFLst.get(5).getSueokifuktseiymd(), BizDate.valueOf("19950127"), "（申込Ｆ）受取人生年月日");

        exStringEquals(hokenkinSueokFLst.get(6).getSueokifsysyno(), "11807111174", "（据置Ｆ）証書番号");

        exClassificationEquals(hokenkinSueokFLst.get(6).getSueokifhknkinkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（据置Ｆ）保険金据置関係者区分");

        exStringEquals(hokenkinSueokFLst.get(6).getSueokifhknkinkojinkbn(),
            "01", "（据置Ｆ）保険金据置Ｆ個人区分");

        exClassificationEquals(hokenkinSueokFLst.get(6).getSueokifsueokijtkbn(),
            C_SueokiJyoutaiKbn.MANRYOU, "（据置Ｆ）据置状態区分");
        exDateEquals(hokenkinSueokFLst.get(6).getSueokifsueokikaisiymd(), BizDate.valueOf("20060327"), "（申込Ｆ）据置開始日");
        exNumericEquals(hokenkinSueokFLst.get(6).getSueokifsueokikkn(), 12, "（据置Ｆ）据置期間");
        exDateEquals(hokenkinSueokFLst.get(6).getSueokifuktseiymd(), BizDate.valueOf("19960127"), "（申込Ｆ）受取人生年月日");

        exStringEquals(hokenkinSueokFLst.get(7).getSueokifsysyno(), "11807111174", "（据置Ｆ）証書番号");

        exClassificationEquals(hokenkinSueokFLst.get(7).getSueokifhknkinkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（据置Ｆ）保険金据置関係者区分");

        exStringEquals(hokenkinSueokFLst.get(7).getSueokifhknkinkojinkbn(),
            "01", "（据置Ｆ）保険金据置Ｆ個人区分");

        exClassificationEquals(hokenkinSueokFLst.get(7).getSueokifsueokijtkbn(),
            C_SueokiJyoutaiKbn.MANRYOU, "（据置Ｆ）据置状態区分");
        exDateEquals(hokenkinSueokFLst.get(7).getSueokifsueokikaisiymd(), BizDate.valueOf("20070327"), "（申込Ｆ）据置開始日");
        exNumericEquals(hokenkinSueokFLst.get(7).getSueokifsueokikkn(), 12, "（据置Ｆ）据置期間");
        exDateEquals(hokenkinSueokFLst.get(7).getSueokifuktseiymd(), BizDate.valueOf("19970127"), "（申込Ｆ）受取人生年月日");

        exStringEquals(hokenkinSueokFLst.get(8).getSueokifsysyno(), "11807111174", "（据置Ｆ）証書番号");

        exClassificationEquals(hokenkinSueokFLst.get(8).getSueokifhknkinkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（据置Ｆ）保険金据置関係者区分");

        exStringEquals(hokenkinSueokFLst.get(8).getSueokifhknkinkojinkbn(),
            "01", "（据置Ｆ）保険金据置Ｆ個人区分");

        exClassificationEquals(hokenkinSueokFLst.get(8).getSueokifsueokijtkbn(),
            C_SueokiJyoutaiKbn.MANRYOU, "（据置Ｆ）据置状態区分");
        exDateEquals(hokenkinSueokFLst.get(8).getSueokifsueokikaisiymd(), BizDate.valueOf("20080327"), "（申込Ｆ）据置開始日");
        exNumericEquals(hokenkinSueokFLst.get(8).getSueokifsueokikkn(), 12, "（据置Ｆ）据置期間");
        exDateEquals(hokenkinSueokFLst.get(8).getSueokifuktseiymd(), BizDate.valueOf("19980127"), "（申込Ｆ）受取人生年月日");

        exStringEquals(hokenkinSueokFLst.get(9).getSueokifsysyno(), "11807111174", "（据置Ｆ）証書番号");

        exClassificationEquals(hokenkinSueokFLst.get(9).getSueokifhknkinkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（据置Ｆ）保険金据置関係者区分");

        exStringEquals(hokenkinSueokFLst.get(9).getSueokifhknkinkojinkbn(),
            "01", "（据置Ｆ）保険金据置Ｆ個人区分");

        exClassificationEquals(hokenkinSueokFLst.get(9).getSueokifsueokijtkbn(),
            C_SueokiJyoutaiKbn.MANRYOU, "（据置Ｆ）据置状態区分");
        exDateEquals(hokenkinSueokFLst.get(9).getSueokifsueokikaisiymd(), BizDate.valueOf("20090327"), "（申込Ｆ）据置開始日");
        exNumericEquals(hokenkinSueokFLst.get(9).getSueokifsueokikkn(), 12, "（据置Ｆ）据置期間");
        exDateEquals(hokenkinSueokFLst.get(9).getSueokifuktseiymd(), BizDate.valueOf("19990127"), "（申込Ｆ）受取人生年月日");


        List<BzSougouNenkinSiharaiFSakuinKekkaBean> sougouNkShrFSakuinLst = bzSakuinTsnSyoukaiKekkaBean
            .getBzsougounenkinsiharaifsakuinkekkabeanlist();

        exNumericEquals(sougouNkShrFSakuinLst.size(), 10, "総合年金支払Ｆ索引結果Beanリストのサイズ");
        exStringEquals(sougouNkShrFSakuinLst.get(0).getSounenfnksysyno(), "11807111211", "（総年Ｆ）年金証書番号");

        exClassificationEquals(sougouNkShrFSakuinLst.get(0).getSounenfnkkankeisyakbn(),
            C_NkKankeisyaKbn.NKUKT, "（総年Ｆ）年金支払関係者区分");

        exStringEquals(sougouNkShrFSakuinLst.get(0).getSounenfsougounkfkojinkbn(),
            "04", "（総年Ｆ）総合年金支払Ｆ個人区分");

        exClassificationEquals(sougouNkShrFSakuinLst.get(0).getSounenfkykjyoutaikbn(),
            C_SounenfKykJyoutaiKbn.SYOUMETU_SIBOU, "（総年Ｆ）契約状態区分");
        exDateEquals(sougouNkShrFSakuinLst.get(0).getSounenfsyokainkshrymd(), BizDate.valueOf("20021220"),
            "（総年Ｆ）初回年金支払日");
        exDateEquals(sougouNkShrFSakuinLst.get(0).getSounenfkykymd(), BizDate.valueOf("20021120"), "（総年Ｆ）契約日");

        exStringEquals(sougouNkShrFSakuinLst.get(0).getSounenfnksyoumetucd(),
            "11", "（総年Ｆ）年金消滅コード");
        exDateEquals(sougouNkShrFSakuinLst.get(0).getSounenfsyoumetuymd(), BizDate.valueOf("20010410"), "（総年Ｆ）消滅日");
        exDateEquals(sougouNkShrFSakuinLst.get(0).getSounenftaisyouseiymd(), BizDate.valueOf("19940610"), "（総年Ｆ）対象生年月日");

        exStringEquals(sougouNkShrFSakuinLst.get(1).getSounenfnksysyno(), "11807111211", "（総年Ｆ）年金証書番号");

        exClassificationEquals(sougouNkShrFSakuinLst.get(1).getSounenfnkkankeisyakbn(),
            C_NkKankeisyaKbn.NKUKT, "（総年Ｆ）年金支払関係者区分");

        exStringEquals(sougouNkShrFSakuinLst.get(1).getSounenfsougounkfkojinkbn(),
            "04", "（総年Ｆ）総合年金支払Ｆ個人区分");

        exClassificationEquals(sougouNkShrFSakuinLst.get(1).getSounenfkykjyoutaikbn(),
            C_SounenfKykJyoutaiKbn.SYOUMETU_SIBOU, "（総年Ｆ）契約状態区分");
        exDateEquals(sougouNkShrFSakuinLst.get(1).getSounenfsyokainkshrymd(), BizDate.valueOf("20021221"),
            "（総年Ｆ）初回年金支払日");
        exDateEquals(sougouNkShrFSakuinLst.get(1).getSounenfkykymd(), BizDate.valueOf("20021121"), "（総年Ｆ）契約日");

        exStringEquals(sougouNkShrFSakuinLst.get(1).getSounenfnksyoumetucd(),
            "11", "（総年Ｆ）年金消滅コード");
        exDateEquals(sougouNkShrFSakuinLst.get(1).getSounenfsyoumetuymd(), BizDate.valueOf("20010411"), "（総年Ｆ）消滅日");
        exDateEquals(sougouNkShrFSakuinLst.get(1).getSounenftaisyouseiymd(), BizDate.valueOf("19940611"), "（総年Ｆ）対象生年月日");

        exStringEquals(sougouNkShrFSakuinLst.get(2).getSounenfnksysyno(), "11807111211", "（総年Ｆ）年金証書番号");

        exClassificationEquals(sougouNkShrFSakuinLst.get(2).getSounenfnkkankeisyakbn(),
            C_NkKankeisyaKbn.NKUKT, "（総年Ｆ）年金支払関係者区分");

        exStringEquals(sougouNkShrFSakuinLst.get(2).getSounenfsougounkfkojinkbn(),
            "04", "（総年Ｆ）総合年金支払Ｆ個人区分");

        exClassificationEquals(sougouNkShrFSakuinLst.get(2).getSounenfkykjyoutaikbn(),
            C_SounenfKykJyoutaiKbn.SYOUMETU_SIBOU, "（総年Ｆ）契約状態区分");
        exDateEquals(sougouNkShrFSakuinLst.get(2).getSounenfsyokainkshrymd(), BizDate.valueOf("20021222"),
            "（総年Ｆ）初回年金支払日");
        exDateEquals(sougouNkShrFSakuinLst.get(2).getSounenfkykymd(), BizDate.valueOf("20021122"), "（総年Ｆ）契約日");

        exStringEquals(sougouNkShrFSakuinLst.get(2).getSounenfnksyoumetucd(),
            "11", "（総年Ｆ）年金消滅コード");
        exDateEquals(sougouNkShrFSakuinLst.get(2).getSounenfsyoumetuymd(), BizDate.valueOf("20010412"), "（総年Ｆ）消滅日");
        exDateEquals(sougouNkShrFSakuinLst.get(2).getSounenftaisyouseiymd(), BizDate.valueOf("19940612"), "（総年Ｆ）対象生年月日");

        exStringEquals(sougouNkShrFSakuinLst.get(3).getSounenfnksysyno(), "11807111211", "（総年Ｆ）年金証書番号");

        exClassificationEquals(sougouNkShrFSakuinLst.get(3).getSounenfnkkankeisyakbn(),
            C_NkKankeisyaKbn.NKUKT, "（総年Ｆ）年金支払関係者区分");

        exStringEquals(sougouNkShrFSakuinLst.get(3).getSounenfsougounkfkojinkbn(),
            "04", "（総年Ｆ）総合年金支払Ｆ個人区分");

        exClassificationEquals(sougouNkShrFSakuinLst.get(3).getSounenfkykjyoutaikbn(),
            C_SounenfKykJyoutaiKbn.SYOUMETU_SIBOU, "（総年Ｆ）契約状態区分");
        exDateEquals(sougouNkShrFSakuinLst.get(3).getSounenfsyokainkshrymd(), BizDate.valueOf("20021223"),
            "（総年Ｆ）初回年金支払日");
        exDateEquals(sougouNkShrFSakuinLst.get(3).getSounenfkykymd(), BizDate.valueOf("20021123"), "（総年Ｆ）契約日");

        exStringEquals(sougouNkShrFSakuinLst.get(3).getSounenfnksyoumetucd(),
            "11", "（総年Ｆ）年金消滅コード");
        exDateEquals(sougouNkShrFSakuinLst.get(3).getSounenfsyoumetuymd(), BizDate.valueOf("20010413"), "（総年Ｆ）消滅日");
        exDateEquals(sougouNkShrFSakuinLst.get(3).getSounenftaisyouseiymd(), BizDate.valueOf("19940613"), "（総年Ｆ）対象生年月日");

        exStringEquals(sougouNkShrFSakuinLst.get(4).getSounenfnksysyno(), "11807111211", "（総年Ｆ）年金証書番号");

        exClassificationEquals(sougouNkShrFSakuinLst.get(4).getSounenfnkkankeisyakbn(),
            C_NkKankeisyaKbn.NKUKT, "（総年Ｆ）年金支払関係者区分");

        exStringEquals(sougouNkShrFSakuinLst.get(4).getSounenfsougounkfkojinkbn(),
            "04", "（総年Ｆ）総合年金支払Ｆ個人区分");

        exClassificationEquals(sougouNkShrFSakuinLst.get(4).getSounenfkykjyoutaikbn(),
            C_SounenfKykJyoutaiKbn.SYOUMETU_SIBOU, "（総年Ｆ）契約状態区分");
        exDateEquals(sougouNkShrFSakuinLst.get(4).getSounenfsyokainkshrymd(), BizDate.valueOf("20021224"),
            "（総年Ｆ）初回年金支払日");
        exDateEquals(sougouNkShrFSakuinLst.get(4).getSounenfkykymd(), BizDate.valueOf("20021124"), "（総年Ｆ）契約日");

        exStringEquals(sougouNkShrFSakuinLst.get(4).getSounenfnksyoumetucd(),
            "11", "（総年Ｆ）年金消滅コード");
        exDateEquals(sougouNkShrFSakuinLst.get(4).getSounenfsyoumetuymd(), BizDate.valueOf("20010414"), "（総年Ｆ）消滅日");
        exDateEquals(sougouNkShrFSakuinLst.get(4).getSounenftaisyouseiymd(), BizDate.valueOf("19940614"), "（総年Ｆ）対象生年月日");

        exStringEquals(sougouNkShrFSakuinLst.get(5).getSounenfnksysyno(), "11807111211", "（総年Ｆ）年金証書番号");

        exClassificationEquals(sougouNkShrFSakuinLst.get(5).getSounenfnkkankeisyakbn(),
            C_NkKankeisyaKbn.NKUKT, "（総年Ｆ）年金支払関係者区分");

        exStringEquals(sougouNkShrFSakuinLst.get(5).getSounenfsougounkfkojinkbn(),
            "04", "（総年Ｆ）総合年金支払Ｆ個人区分");

        exClassificationEquals(sougouNkShrFSakuinLst.get(5).getSounenfkykjyoutaikbn(),
            C_SounenfKykJyoutaiKbn.SYOUMETU_SIBOU, "（総年Ｆ）契約状態区分");
        exDateEquals(sougouNkShrFSakuinLst.get(5).getSounenfsyokainkshrymd(), BizDate.valueOf("20021225"),
            "（総年Ｆ）初回年金支払日");
        exDateEquals(sougouNkShrFSakuinLst.get(5).getSounenfkykymd(), BizDate.valueOf("20021125"), "（総年Ｆ）契約日");

        exStringEquals(sougouNkShrFSakuinLst.get(5).getSounenfnksyoumetucd(),
            "11", "（総年Ｆ）年金消滅コード");
        exDateEquals(sougouNkShrFSakuinLst.get(5).getSounenfsyoumetuymd(), BizDate.valueOf("20010415"), "（総年Ｆ）消滅日");
        exDateEquals(sougouNkShrFSakuinLst.get(5).getSounenftaisyouseiymd(), BizDate.valueOf("19940615"), "（総年Ｆ）対象生年月日");

        exStringEquals(sougouNkShrFSakuinLst.get(6).getSounenfnksysyno(), "11807111211", "（総年Ｆ）年金証書番号");

        exClassificationEquals(sougouNkShrFSakuinLst.get(6).getSounenfnkkankeisyakbn(),
            C_NkKankeisyaKbn.NKUKT, "（総年Ｆ）年金支払関係者区分");

        exStringEquals(sougouNkShrFSakuinLst.get(6).getSounenfsougounkfkojinkbn(),
            "04", "（総年Ｆ）総合年金支払Ｆ個人区分");

        exClassificationEquals(sougouNkShrFSakuinLst.get(6).getSounenfkykjyoutaikbn(),
            C_SounenfKykJyoutaiKbn.SYOUMETU_SIBOU, "（総年Ｆ）契約状態区分");
        exDateEquals(sougouNkShrFSakuinLst.get(6).getSounenfsyokainkshrymd(), BizDate.valueOf("20021226"),
            "（総年Ｆ）初回年金支払日");
        exDateEquals(sougouNkShrFSakuinLst.get(6).getSounenfkykymd(), BizDate.valueOf("20021126"), "（総年Ｆ）契約日");

        exStringEquals(sougouNkShrFSakuinLst.get(6).getSounenfnksyoumetucd(),
            "11", "（総年Ｆ）年金消滅コード");
        exDateEquals(sougouNkShrFSakuinLst.get(6).getSounenfsyoumetuymd(), BizDate.valueOf("20010416"), "（総年Ｆ）消滅日");
        exDateEquals(sougouNkShrFSakuinLst.get(6).getSounenftaisyouseiymd(), BizDate.valueOf("19940616"), "（総年Ｆ）対象生年月日");

        exStringEquals(sougouNkShrFSakuinLst.get(7).getSounenfnksysyno(), "11807111211", "（総年Ｆ）年金証書番号");

        exClassificationEquals(sougouNkShrFSakuinLst.get(7).getSounenfnkkankeisyakbn(),
            C_NkKankeisyaKbn.NKUKT, "（総年Ｆ）年金支払関係者区分");

        exStringEquals(sougouNkShrFSakuinLst.get(7).getSounenfsougounkfkojinkbn(),
            "04", "（総年Ｆ）総合年金支払Ｆ個人区分");

        exClassificationEquals(sougouNkShrFSakuinLst.get(7).getSounenfkykjyoutaikbn(),
            C_SounenfKykJyoutaiKbn.SYOUMETU_SIBOU, "（総年Ｆ）契約状態区分");
        exDateEquals(sougouNkShrFSakuinLst.get(7).getSounenfsyokainkshrymd(), BizDate.valueOf("20021227"),
            "（総年Ｆ）初回年金支払日");
        exDateEquals(sougouNkShrFSakuinLst.get(7).getSounenfkykymd(), BizDate.valueOf("20021127"), "（総年Ｆ）契約日");

        exStringEquals(sougouNkShrFSakuinLst.get(7).getSounenfnksyoumetucd(),
            "11", "（総年Ｆ）年金消滅コード");
        exDateEquals(sougouNkShrFSakuinLst.get(7).getSounenfsyoumetuymd(), BizDate.valueOf("20010417"), "（総年Ｆ）消滅日");
        exDateEquals(sougouNkShrFSakuinLst.get(7).getSounenftaisyouseiymd(), BizDate.valueOf("19940617"), "（総年Ｆ）対象生年月日");

        exStringEquals(sougouNkShrFSakuinLst.get(8).getSounenfnksysyno(), "11807111211", "（総年Ｆ）年金証書番号");

        exClassificationEquals(sougouNkShrFSakuinLst.get(8).getSounenfnkkankeisyakbn(),
            C_NkKankeisyaKbn.NKUKT, "（総年Ｆ）年金支払関係者区分");

        exStringEquals(sougouNkShrFSakuinLst.get(8).getSounenfsougounkfkojinkbn(),
            "04", "（総年Ｆ）総合年金支払Ｆ個人区分");

        exClassificationEquals(sougouNkShrFSakuinLst.get(8).getSounenfkykjyoutaikbn(),
            C_SounenfKykJyoutaiKbn.SYOUMETU_SIBOU, "（総年Ｆ）契約状態区分");
        exDateEquals(sougouNkShrFSakuinLst.get(8).getSounenfsyokainkshrymd(), BizDate.valueOf("20021228"),
            "（総年Ｆ）初回年金支払日");
        exDateEquals(sougouNkShrFSakuinLst.get(8).getSounenfkykymd(), BizDate.valueOf("20021128"), "（総年Ｆ）契約日");

        exStringEquals(sougouNkShrFSakuinLst.get(8).getSounenfnksyoumetucd(),
            "11", "（総年Ｆ）年金消滅コード");
        exDateEquals(sougouNkShrFSakuinLst.get(8).getSounenfsyoumetuymd(), BizDate.valueOf("20010418"), "（総年Ｆ）消滅日");
        exDateEquals(sougouNkShrFSakuinLst.get(8).getSounenftaisyouseiymd(), BizDate.valueOf("19940618"), "（総年Ｆ）対象生年月日");

        exStringEquals(sougouNkShrFSakuinLst.get(9).getSounenfnksysyno(), "11807111211", "（総年Ｆ）年金証書番号");

        exClassificationEquals(sougouNkShrFSakuinLst.get(9).getSounenfnkkankeisyakbn(),
            C_NkKankeisyaKbn.NKUKT, "（総年Ｆ）年金支払関係者区分");

        exStringEquals(sougouNkShrFSakuinLst.get(9).getSounenfsougounkfkojinkbn(),
            "04", "（総年Ｆ）総合年金支払Ｆ個人区分");

        exClassificationEquals(sougouNkShrFSakuinLst.get(9).getSounenfkykjyoutaikbn(),
            C_SounenfKykJyoutaiKbn.SYOUMETU_SIBOU, "（総年Ｆ）契約状態区分");
        exDateEquals(sougouNkShrFSakuinLst.get(9).getSounenfsyokainkshrymd(), BizDate.valueOf("20021229"),
            "（総年Ｆ）初回年金支払日");
        exDateEquals(sougouNkShrFSakuinLst.get(9).getSounenfkykymd(), BizDate.valueOf("20021129"), "（総年Ｆ）契約日");

        exStringEquals(sougouNkShrFSakuinLst.get(9).getSounenfnksyoumetucd(),
            "11", "（総年Ｆ）年金消滅コード");
        exDateEquals(sougouNkShrFSakuinLst.get(9).getSounenfsyoumetuymd(), BizDate.valueOf("20010419"), "（総年Ｆ）消滅日");
        exDateEquals(sougouNkShrFSakuinLst.get(9).getSounenftaisyouseiymd(), BizDate.valueOf("19940619"), "（総年Ｆ）対象生年月日");


        List<BzKeiyakuHozenSakuinKekkaBean> kykhSakuinLst = bzSakuinTsnSyoukaiKekkaBean
            .getBzkeiyakuhozensakuinkekkabeanlist();

        exNumericEquals(kykhSakuinLst.size(), 10, "契約保全索引結果Beanリストのサイズ");

        exStringEquals(kykhSakuinLst.get(0).getKhsyono(), "11807111163", "（契約保全）証券番号");

        exClassificationEquals(kykhSakuinLst.get(0).getKhkykkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（契約保全）契約関係者区分");

        exStringEquals(kykhSakuinLst.get(0).getKhkykfkojinkbn(),
            "05", "（契約保全）契約Ｆ個人区分");

        exClassificationEquals(kykhSakuinLst.get(0).getKhyuukousyoumetukbn(),
            C_YuukousyoumetuKbn.SYOUMETU, "（契約保全）有効消滅区分");

        exClassificationEquals(kykhSakuinLst.get(0).getKhkykjyoutai(),
            C_Kykjyoutai.ITIJIBARAI, "（契約保全）契約状態");
        exDateEquals(kykhSakuinLst.get(0).getKhkykymd(), BizDate.valueOf("20031010"), "（契約保全）契約日");
        exClassificationEquals(kykhSakuinLst.get(0).getKhsyoumetujiyuu(),
            C_Syoumetujiyuu.CLGOFF, "（契約保全）消滅事由");
        exDateEquals(kykhSakuinLst.get(0).getKhsyoumetuymd(), BizDate.valueOf("20000401"), "（契約保全）消滅日");

        exStringEquals(kykhSakuinLst.get(0).getKhsyouhncd(), "kh", "（契約保全）商品コード");

        exDateYMEquals(kykhSakuinLst.get(0).getKhbosyuuym(), BizDateYM.valueOf("199008"), "（契約保全）募集年月");
        exDateEquals(kykhSakuinLst.get(0).getKhtaisyouseiymd(), BizDate.valueOf("19890510"), "（契約保全）対象者年月日");
        exNumericEquals(kykhSakuinLst.get(0).getKhsyouhnsdno(), 10, "（契約保全）商品世代番号");

        exStringEquals(kykhSakuinLst.get(1).getKhsyono(), "11807111163", "（契約保全）証券番号");

        exClassificationEquals(kykhSakuinLst.get(1).getKhkykkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（契約保全）契約関係者区分");

        exStringEquals(kykhSakuinLst.get(1).getKhkykfkojinkbn(),
            "05", "（契約保全）契約Ｆ個人区分");

        exClassificationEquals(kykhSakuinLst.get(1).getKhyuukousyoumetukbn(),
            C_YuukousyoumetuKbn.SYOUMETU, "（契約保全）有効消滅区分");

        exClassificationEquals(kykhSakuinLst.get(1).getKhkykjyoutai(),
            C_Kykjyoutai.ITIJIBARAI, "（契約保全）契約状態");
        exDateEquals(kykhSakuinLst.get(1).getKhkykymd(), BizDate.valueOf("20031011"), "（契約保全）契約日");
        exClassificationEquals(kykhSakuinLst.get(1).getKhsyoumetujiyuu(),
            C_Syoumetujiyuu.CLGOFF, "（契約保全）消滅事由");
        exDateEquals(kykhSakuinLst.get(1).getKhsyoumetuymd(), BizDate.valueOf("20010401"), "（契約保全）消滅日");

        exStringEquals(kykhSakuinLst.get(1).getKhsyouhncd(), "kh", "（契約保全）商品コード");

        exDateYMEquals(kykhSakuinLst.get(1).getKhbosyuuym(), BizDateYM.valueOf("199108"), "（契約保全）募集年月");
        exDateEquals(kykhSakuinLst.get(1).getKhtaisyouseiymd(), BizDate.valueOf("19890511"), "（契約保全）対象者年月日");
        exNumericEquals(kykhSakuinLst.get(1).getKhsyouhnsdno(), 11, "（契約保全）商品世代番号");

        exStringEquals(kykhSakuinLst.get(2).getKhsyono(), "11807111163", "（契約保全）証券番号");

        exClassificationEquals(kykhSakuinLst.get(2).getKhkykkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（契約保全）契約関係者区分");

        exStringEquals(kykhSakuinLst.get(2).getKhkykfkojinkbn(),
            "05", "（契約保全）契約Ｆ個人区分");

        exClassificationEquals(kykhSakuinLst.get(2).getKhyuukousyoumetukbn(),
            C_YuukousyoumetuKbn.SYOUMETU, "（契約保全）有効消滅区分");

        exClassificationEquals(kykhSakuinLst.get(2).getKhkykjyoutai(),
            C_Kykjyoutai.ITIJIBARAI, "（契約保全）契約状態");

        exDateEquals(kykhSakuinLst.get(2).getKhkykymd(), BizDate.valueOf("20031012"), "（契約保全）契約日");
        exClassificationEquals(kykhSakuinLst.get(2).getKhsyoumetujiyuu(),
            C_Syoumetujiyuu.CLGOFF, "（契約保全）消滅事由");
        exDateEquals(kykhSakuinLst.get(2).getKhsyoumetuymd(), BizDate.valueOf("20020401"), "（契約保全）消滅日");

        exStringEquals(kykhSakuinLst.get(2).getKhsyouhncd(), "kh", "（契約保全）商品コード");

        exDateYMEquals(kykhSakuinLst.get(2).getKhbosyuuym(), BizDateYM.valueOf("199208"), "（契約保全）募集年月");
        exDateEquals(kykhSakuinLst.get(2).getKhtaisyouseiymd(), BizDate.valueOf("19890512"), "（契約保全）対象者年月日");
        exNumericEquals(kykhSakuinLst.get(2).getKhsyouhnsdno(), 12, "（契約保全）商品世代番号");

        exStringEquals(kykhSakuinLst.get(3).getKhsyono(), "11807111163", "（契約保全）証券番号");

        exClassificationEquals(kykhSakuinLst.get(3).getKhkykkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（契約保全）契約関係者区分");

        exStringEquals(kykhSakuinLst.get(3).getKhkykfkojinkbn(),
            "05", "（契約保全）契約Ｆ個人区分");

        exClassificationEquals(kykhSakuinLst.get(3).getKhyuukousyoumetukbn(),
            C_YuukousyoumetuKbn.SYOUMETU, "（契約保全）有効消滅区分");

        exClassificationEquals(kykhSakuinLst.get(3).getKhkykjyoutai(),
            C_Kykjyoutai.ITIJIBARAI, "（契約保全）契約状態");
        exDateEquals(kykhSakuinLst.get(3).getKhkykymd(), BizDate.valueOf("20031013"), "（契約保全）契約日");
        exClassificationEquals(kykhSakuinLst.get(3).getKhsyoumetujiyuu(),
            C_Syoumetujiyuu.CLGOFF, "（契約保全）消滅事由");
        exDateEquals(kykhSakuinLst.get(3).getKhsyoumetuymd(), BizDate.valueOf("20030401"), "（契約保全）消滅日");

        exStringEquals(kykhSakuinLst.get(3).getKhsyouhncd(), "kh", "（契約保全）商品コード");

        exDateYMEquals(kykhSakuinLst.get(3).getKhbosyuuym(), BizDateYM.valueOf("199308"), "（契約保全）募集年月");
        exDateEquals(kykhSakuinLst.get(3).getKhtaisyouseiymd(), BizDate.valueOf("19890513"), "（契約保全）対象者年月日");
        exNumericEquals(kykhSakuinLst.get(3).getKhsyouhnsdno(), 13, "（契約保全）商品世代番号");

        exStringEquals(kykhSakuinLst.get(4).getKhsyono(), "11807111163", "（契約保全）証券番号");

        exClassificationEquals(kykhSakuinLst.get(4).getKhkykkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（契約保全）契約関係者区分");

        exStringEquals(kykhSakuinLst.get(4).getKhkykfkojinkbn(),
            "05", "（契約保全）契約Ｆ個人区分");

        exClassificationEquals(kykhSakuinLst.get(4).getKhyuukousyoumetukbn(),
            C_YuukousyoumetuKbn.SYOUMETU, "（契約保全）有効消滅区分");

        exClassificationEquals(kykhSakuinLst.get(4).getKhkykjyoutai(),
            C_Kykjyoutai.ITIJIBARAI, "（契約保全）契約状態");
        exDateEquals(kykhSakuinLst.get(4).getKhkykymd(), BizDate.valueOf("20031014"), "（契約保全）契約日");
        exClassificationEquals(kykhSakuinLst.get(4).getKhsyoumetujiyuu(),
            C_Syoumetujiyuu.CLGOFF, "（契約保全）消滅事由");
        exDateEquals(kykhSakuinLst.get(4).getKhsyoumetuymd(), BizDate.valueOf("20040401"), "（契約保全）消滅日");

        exStringEquals(kykhSakuinLst.get(4).getKhsyouhncd(), "kh", "（契約保全）商品コード");

        exDateYMEquals(kykhSakuinLst.get(4).getKhbosyuuym(), BizDateYM.valueOf("199408"), "（契約保全）募集年月");
        exDateEquals(kykhSakuinLst.get(4).getKhtaisyouseiymd(), BizDate.valueOf("19890514"), "（契約保全）対象者年月日");
        exNumericEquals(kykhSakuinLst.get(4).getKhsyouhnsdno(), 14, "（契約保全）商品世代番号");

        exStringEquals(kykhSakuinLst.get(5).getKhsyono(), "11807111163", "（契約保全）証券番号");

        exClassificationEquals(kykhSakuinLst.get(5).getKhkykkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（契約保全）契約関係者区分");

        exStringEquals(kykhSakuinLst.get(5).getKhkykfkojinkbn(),
            "05", "（契約保全）契約Ｆ個人区分");

        exClassificationEquals(kykhSakuinLst.get(5).getKhyuukousyoumetukbn(),
            C_YuukousyoumetuKbn.SYOUMETU, "（契約保全）有効消滅区分");

        exClassificationEquals(kykhSakuinLst.get(5).getKhkykjyoutai(),
            C_Kykjyoutai.ITIJIBARAI, "（契約保全）契約状態");
        exDateEquals(kykhSakuinLst.get(5).getKhkykymd(), BizDate.valueOf("20031015"), "（契約保全）契約日");
        exClassificationEquals(kykhSakuinLst.get(5).getKhsyoumetujiyuu(),
            C_Syoumetujiyuu.CLGOFF, "（契約保全）消滅事由");
        exDateEquals(kykhSakuinLst.get(5).getKhsyoumetuymd(), BizDate.valueOf("20050401"), "（契約保全）消滅日");

        exStringEquals(kykhSakuinLst.get(5).getKhsyouhncd(), "kh", "（契約保全）商品コード");

        exDateYMEquals(kykhSakuinLst.get(5).getKhbosyuuym(), BizDateYM.valueOf("199508"), "（契約保全）募集年月");
        exDateEquals(kykhSakuinLst.get(5).getKhtaisyouseiymd(), BizDate.valueOf("19890515"), "（契約保全）対象者年月日");
        exNumericEquals(kykhSakuinLst.get(5).getKhsyouhnsdno(), 15, "（契約保全）商品世代番号");

        exStringEquals(kykhSakuinLst.get(6).getKhsyono(), "11807111163", "（契約保全）証券番号");

        exClassificationEquals(kykhSakuinLst.get(6).getKhkykkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（契約保全）契約関係者区分");

        exStringEquals(kykhSakuinLst.get(6).getKhkykfkojinkbn(),
            "05", "（契約保全）契約Ｆ個人区分");

        exClassificationEquals(kykhSakuinLst.get(6).getKhyuukousyoumetukbn(),
            C_YuukousyoumetuKbn.SYOUMETU, "（契約保全）有効消滅区分");

        exClassificationEquals(kykhSakuinLst.get(6).getKhkykjyoutai(),
            C_Kykjyoutai.ITIJIBARAI, "（契約保全）契約状態");
        exDateEquals(kykhSakuinLst.get(6).getKhkykymd(), BizDate.valueOf("20031016"), "（契約保全）契約日");
        exClassificationEquals(kykhSakuinLst.get(6).getKhsyoumetujiyuu(),
            C_Syoumetujiyuu.CLGOFF, "（契約保全）消滅事由");
        exDateEquals(kykhSakuinLst.get(6).getKhsyoumetuymd(), BizDate.valueOf("20060401"), "（契約保全）消滅日");

        exStringEquals(kykhSakuinLst.get(6).getKhsyouhncd(), "kh", "（契約保全）商品コード");

        exDateYMEquals(kykhSakuinLst.get(6).getKhbosyuuym(), BizDateYM.valueOf("199608"), "（契約保全）募集年月");
        exDateEquals(kykhSakuinLst.get(6).getKhtaisyouseiymd(), BizDate.valueOf("19890516"), "（契約保全）対象者年月日");
        exNumericEquals(kykhSakuinLst.get(6).getKhsyouhnsdno(), 16, "（契約保全）商品世代番号");

        exStringEquals(kykhSakuinLst.get(7).getKhsyono(), "11807111163", "（契約保全）証券番号");

        exClassificationEquals(kykhSakuinLst.get(7).getKhkykkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（契約保全）契約関係者区分");

        exStringEquals(kykhSakuinLst.get(7).getKhkykfkojinkbn(),
            "05", "（契約保全）契約Ｆ個人区分");

        exClassificationEquals(kykhSakuinLst.get(7).getKhyuukousyoumetukbn(),
            C_YuukousyoumetuKbn.SYOUMETU, "（契約保全）有効消滅区分");

        exClassificationEquals(kykhSakuinLst.get(7).getKhkykjyoutai(),
            C_Kykjyoutai.ITIJIBARAI, "（契約保全）契約状態");
        exDateEquals(kykhSakuinLst.get(7).getKhkykymd(), BizDate.valueOf("20031017"), "（契約保全）契約日");
        exClassificationEquals(kykhSakuinLst.get(7).getKhsyoumetujiyuu(),
            C_Syoumetujiyuu.CLGOFF, "（契約保全）消滅事由");
        exDateEquals(kykhSakuinLst.get(7).getKhsyoumetuymd(), BizDate.valueOf("20070401"), "（契約保全）消滅日");

        exStringEquals(kykhSakuinLst.get(7).getKhsyouhncd(), "kh", "（契約保全）商品コード");

        exDateYMEquals(kykhSakuinLst.get(7).getKhbosyuuym(), BizDateYM.valueOf("199708"), "（契約保全）募集年月");
        exDateEquals(kykhSakuinLst.get(7).getKhtaisyouseiymd(), BizDate.valueOf("19890517"), "（契約保全）対象者年月日");
        exNumericEquals(kykhSakuinLst.get(7).getKhsyouhnsdno(), 17, "（契約保全）商品世代番号");

        exStringEquals(kykhSakuinLst.get(8).getKhsyono(), "11807111163", "（契約保全）証券番号");

        exClassificationEquals(kykhSakuinLst.get(8).getKhkykkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（契約保全）契約関係者区分");

        exStringEquals(kykhSakuinLst.get(8).getKhkykfkojinkbn(),
            "05", "（契約保全）契約Ｆ個人区分");

        exClassificationEquals(kykhSakuinLst.get(8).getKhyuukousyoumetukbn(),
            C_YuukousyoumetuKbn.SYOUMETU, "（契約保全）有効消滅区分");

        exClassificationEquals(kykhSakuinLst.get(8).getKhkykjyoutai(),
            C_Kykjyoutai.ITIJIBARAI, "（契約保全）契約状態");
        exDateEquals(kykhSakuinLst.get(8).getKhkykymd(), BizDate.valueOf("20031018"), "（契約保全）契約日");
        exClassificationEquals(kykhSakuinLst.get(8).getKhsyoumetujiyuu(), C_Syoumetujiyuu.CLGOFF, "（契約保全）消滅事由");
        exDateEquals(kykhSakuinLst.get(8).getKhsyoumetuymd(), BizDate.valueOf("20080401"), "（契約保全）消滅日");

        exStringEquals(kykhSakuinLst.get(8).getKhsyouhncd(), "kh", "（契約保全）商品コード");

        exDateYMEquals(kykhSakuinLst.get(8).getKhbosyuuym(), BizDateYM.valueOf("199808"), "（契約保全）募集年月");
        exDateEquals(kykhSakuinLst.get(8).getKhtaisyouseiymd(), BizDate.valueOf("19890518"), "（契約保全）対象者年月日");
        exNumericEquals(kykhSakuinLst.get(8).getKhsyouhnsdno(), 18, "（契約保全）商品世代番号");

        exStringEquals(kykhSakuinLst.get(9).getKhsyono(), "11807111163", "（契約保全）証券番号");

        exClassificationEquals(kykhSakuinLst.get(9).getKhkykkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（契約保全）契約関係者区分");

        exStringEquals(kykhSakuinLst.get(9).getKhkykfkojinkbn(),
            "05", "（契約保全）契約Ｆ個人区分");

        exClassificationEquals(kykhSakuinLst.get(9).getKhyuukousyoumetukbn(),
            C_YuukousyoumetuKbn.SYOUMETU, "（契約保全）有効消滅区分");

        exClassificationEquals(kykhSakuinLst.get(9).getKhkykjyoutai(),
            C_Kykjyoutai.ITIJIBARAI, "（契約保全）契約状態");
        exDateEquals(kykhSakuinLst.get(9).getKhkykymd(), BizDate.valueOf("20031019"), "（契約保全）契約日");
        exClassificationEquals(kykhSakuinLst.get(9).getKhsyoumetujiyuu(),
            C_Syoumetujiyuu.CLGOFF, "（契約保全）消滅事由");
        exDateEquals(kykhSakuinLst.get(9).getKhsyoumetuymd(), BizDate.valueOf("20090401"), "（契約保全）消滅日");

        exStringEquals(kykhSakuinLst.get(9).getKhsyouhncd(), "kh", "（契約保全）商品コード");

        exDateYMEquals(kykhSakuinLst.get(9).getKhbosyuuym(), BizDateYM.valueOf("199908"), "（契約保全）募集年月");
        exDateEquals(kykhSakuinLst.get(9).getKhtaisyouseiymd(), BizDate.valueOf("19890519"), "（契約保全）対象者年月日");
        exNumericEquals(kykhSakuinLst.get(9).getKhsyouhnsdno(), 19, "（契約保全）商品世代番号");


        List<BzSinkeiyakuSakuinKekkaBean> skSakuinLst = bzSakuinTsnSyoukaiKekkaBean
            .getBzsinkeiyakusakuinkekkabeanlist();

        exNumericEquals(skSakuinLst.size(), 10, "新契約索引結果Beanリストのサイズ");
        exStringEquals(skSakuinLst.get(0).getSkmosno(), "791112402", "（新契約）申込番号");

        exClassificationEquals(skSakuinLst.get(0).getSkmoskankeisyakbn(),
            C_KankeisyaKbn.KYK, "（新契約）申込関係者区分");

        exStringEquals(skSakuinLst.get(0).getSkmosfkojinkbn(), "03", "（新契約）申込Ｆ個人区分");
        exClassificationEquals(skSakuinLst.get(0).getSkmfrenflg(),
            C_Mfrenflg.SUMI, "（新契約）ＭＦ連動済フラグ");
        exDateEquals(skSakuinLst.get(0).getSkmosymd(), BizDate.valueOf("19900509"), "（新契約）申込日");

        exDateEquals(skSakuinLst.get(0).getSkkykymd(), BizDate.valueOf("19900619"), "（新契約）契約日");

        exClassificationEquals(skSakuinLst.get(0).getSkseiritukbn(),
            C_SeirituKbn.SEIRITU, "（新契約）成立区分");
        exDateEquals(skSakuinLst.get(0).getSksrsyoriymd(), BizDate.valueOf("19971010"), "（新契約）成立処理日");

        exStringEquals(skSakuinLst.get(0).getSksyouhncd(), "sk", "（新契約）商品コード");

        assertNull("（新契約）募集年月", skSakuinLst.get(0).getSkbosyuuym());

        exClassificationEquals(skSakuinLst.get(0).getSktaisyounayosejtkbn(),
            C_NayoseJyoutaiKbn.NAYOSEHUMEI, "（新契約）対象者名寄せ状態区分");
        exStringEquals(skSakuinLst.get(0).getSktaisyousakuinnmno(), "", "（新契約）対象者索引名番号");
        assertNull("（新契約）対象者生年月日", skSakuinLst.get(0).getSktaisyouseiymd());
        exNumericEquals(skSakuinLst.get(0).getSksyouhnsdno(), 20, "（新契約）商品世代番号");

        exStringEquals(skSakuinLst.get(1).getSkmosno(), "791112402", "（新契約）申込番号");

        exClassificationEquals(skSakuinLst.get(1).getSkmoskankeisyakbn(),
            C_KankeisyaKbn.KYK, "（新契約）申込関係者区分");

        exStringEquals(skSakuinLst.get(1).getSkmosfkojinkbn(), "03", "（新契約）申込Ｆ個人区分");
        exClassificationEquals(skSakuinLst.get(1).getSkmfrenflg(),
            C_Mfrenflg.SUMI, "（新契約）ＭＦ連動済フラグ");
        exDateEquals(skSakuinLst.get(1).getSkmosymd(), BizDate.valueOf("19910509"), "（新契約）申込日");
        exDateEquals(skSakuinLst.get(1).getSkkykymd(), BizDate.valueOf("19910619"), "（新契約）契約日");

        exClassificationEquals(skSakuinLst.get(1).getSkseiritukbn(),
            C_SeirituKbn.SEIRITU, "（新契約）成立区分");
        exDateEquals(skSakuinLst.get(1).getSksrsyoriymd(), BizDate.valueOf("19971011"), "（新契約）成立処理日");

        exStringEquals(skSakuinLst.get(1).getSksyouhncd(), "sk", "（新契約）商品コード");

        assertNull("（新契約）募集年月", skSakuinLst.get(0).getSkbosyuuym());

        exClassificationEquals(skSakuinLst.get(1).getSktaisyounayosejtkbn(),
            C_NayoseJyoutaiKbn.NAYOSEHUMEI, "（新契約）対象者名寄せ状態区分");
        exStringEquals(skSakuinLst.get(1).getSktaisyousakuinnmno(), "", "（新契約）対象者索引名番号");
        assertNull("（新契約）対象者生年月日", skSakuinLst.get(1).getSktaisyouseiymd());
        exNumericEquals(skSakuinLst.get(1).getSksyouhnsdno(), 21, "（新契約）商品世代番号");

        exStringEquals(skSakuinLst.get(2).getSkmosno(), "791112402", "（新契約）申込番号");

        exClassificationEquals(skSakuinLst.get(2).getSkmoskankeisyakbn(),
            C_KankeisyaKbn.KYK, "（新契約）申込関係者区分");

        exStringEquals(skSakuinLst.get(2).getSkmosfkojinkbn(), "03", "（新契約）申込Ｆ個人区分");
        exClassificationEquals(skSakuinLst.get(2).getSkmfrenflg(),
            C_Mfrenflg.SUMI, "（新契約）ＭＦ連動済フラグ");
        exDateEquals(skSakuinLst.get(2).getSkmosymd(), BizDate.valueOf("19920509"), "（新契約）申込日");
        exDateEquals(skSakuinLst.get(2).getSkkykymd(), BizDate.valueOf("19920619"), "（新契約）契約日");

        exClassificationEquals(skSakuinLst.get(2).getSkseiritukbn(),
            C_SeirituKbn.SEIRITU, "（新契約）成立区分");
        exDateEquals(skSakuinLst.get(2).getSksrsyoriymd(), BizDate.valueOf("19971012"), "（新契約）成立処理日");

        exStringEquals(skSakuinLst.get(2).getSksyouhncd(), "sk", "（新契約）商品コード");

        assertNull("（新契約）募集年月", skSakuinLst.get(0).getSkbosyuuym());

        exClassificationEquals(skSakuinLst.get(2).getSktaisyounayosejtkbn(),
            C_NayoseJyoutaiKbn.NAYOSEHUMEI, "（新契約）対象者名寄せ状態区分");
        exStringEquals(skSakuinLst.get(2).getSktaisyousakuinnmno(), "", "（新契約）対象者索引名番号");
        assertNull("（新契約）対象者生年月日", skSakuinLst.get(2).getSktaisyouseiymd());
        exNumericEquals(skSakuinLst.get(2).getSksyouhnsdno(), 22, "（新契約）商品世代番号");

        exStringEquals(skSakuinLst.get(3).getSkmosno(), "791112402", "（新契約）申込番号");

        exClassificationEquals(skSakuinLst.get(3).getSkmoskankeisyakbn(),
            C_KankeisyaKbn.KYK, "（新契約）申込関係者区分");

        exStringEquals(skSakuinLst.get(3).getSkmosfkojinkbn(), "03", "（新契約）申込Ｆ個人区分");
        exClassificationEquals(skSakuinLst.get(3).getSkmfrenflg(),
            C_Mfrenflg.SUMI, "（新契約）ＭＦ連動済フラグ");
        exDateEquals(skSakuinLst.get(3).getSkmosymd(), BizDate.valueOf("19930509"), "（新契約）申込日");
        exDateEquals(skSakuinLst.get(3).getSkkykymd(), BizDate.valueOf("19930619"), "（新契約）契約日");

        exClassificationEquals(skSakuinLst.get(3).getSkseiritukbn(),
            C_SeirituKbn.SEIRITU, "（新契約）成立区分");
        exDateEquals(skSakuinLst.get(3).getSksrsyoriymd(), BizDate.valueOf("19971013"), "（新契約）成立処理日");

        exStringEquals(skSakuinLst.get(3).getSksyouhncd(), "sk", "（新契約）商品コード");

        assertNull("（新契約）募集年月", skSakuinLst.get(0).getSkbosyuuym());

        exClassificationEquals(skSakuinLst.get(3).getSktaisyounayosejtkbn(),
            C_NayoseJyoutaiKbn.NAYOSEHUMEI, "（新契約）対象者名寄せ状態区分");
        exStringEquals(skSakuinLst.get(3).getSktaisyousakuinnmno(), "", "（新契約）対象者索引名番号");
        assertNull("（新契約）対象者生年月日", skSakuinLst.get(3).getSktaisyouseiymd());
        exNumericEquals(skSakuinLst.get(3).getSksyouhnsdno(), 23, "（新契約）商品世代番号");

        exStringEquals(skSakuinLst.get(4).getSkmosno(), "791112402", "（新契約）申込番号");

        exClassificationEquals(skSakuinLst.get(4).getSkmoskankeisyakbn(),
            C_KankeisyaKbn.KYK, "（新契約）申込関係者区分");

        exStringEquals(skSakuinLst.get(4).getSkmosfkojinkbn(), "03", "（新契約）申込Ｆ個人区分");
        exClassificationEquals(skSakuinLst.get(4).getSkmfrenflg(),
            C_Mfrenflg.SUMI, "（新契約）ＭＦ連動済フラグ");
        exDateEquals(skSakuinLst.get(4).getSkmosymd(), BizDate.valueOf("19940509"), "（新契約）申込日");
        exDateEquals(skSakuinLst.get(4).getSkkykymd(), BizDate.valueOf("19940619"), "（新契約）契約日");

        exClassificationEquals(skSakuinLst.get(4).getSkseiritukbn(),
            C_SeirituKbn.SEIRITU, "（新契約）成立区分");
        exDateEquals(skSakuinLst.get(4).getSksrsyoriymd(), BizDate.valueOf("19971014"), "（新契約）成立処理日");

        exStringEquals(skSakuinLst.get(4).getSksyouhncd(), "sk", "（新契約）商品コード");

        assertNull("（新契約）募集年月", skSakuinLst.get(0).getSkbosyuuym());

        exClassificationEquals(skSakuinLst.get(4).getSktaisyounayosejtkbn(),
            C_NayoseJyoutaiKbn.NAYOSEHUMEI, "（新契約）対象者名寄せ状態区分");
        exStringEquals(skSakuinLst.get(4).getSktaisyousakuinnmno(), "", "（新契約）対象者索引名番号");
        assertNull("（新契約）対象者生年月日", skSakuinLst.get(4).getSktaisyouseiymd());
        exNumericEquals(skSakuinLst.get(4).getSksyouhnsdno(), 24, "（新契約）商品世代番号");

        exStringEquals(skSakuinLst.get(5).getSkmosno(), "791112402", "（新契約）申込番号");

        exClassificationEquals(skSakuinLst.get(5).getSkmoskankeisyakbn(),
            C_KankeisyaKbn.KYK, "（新契約）申込関係者区分");

        exStringEquals(skSakuinLst.get(5).getSkmosfkojinkbn(), "03", "（新契約）申込Ｆ個人区分");
        exClassificationEquals(skSakuinLst.get(5).getSkmfrenflg(),
            C_Mfrenflg.SUMI, "（新契約）ＭＦ連動済フラグ");
        exDateEquals(skSakuinLst.get(5).getSkmosymd(), BizDate.valueOf("19950509"), "（新契約）申込日");
        exDateEquals(skSakuinLst.get(5).getSkkykymd(), BizDate.valueOf("19950619"), "（新契約）契約日");

        exClassificationEquals(skSakuinLst.get(5).getSkseiritukbn(),
            C_SeirituKbn.SEIRITU, "（新契約）成立区分");
        exDateEquals(skSakuinLst.get(5).getSksrsyoriymd(), BizDate.valueOf("19971015"), "（新契約）成立処理日");

        exStringEquals(skSakuinLst.get(5).getSksyouhncd(), "sk", "（新契約）商品コード");

        assertNull("（新契約）募集年月", skSakuinLst.get(0).getSkbosyuuym());

        exClassificationEquals(skSakuinLst.get(5).getSktaisyounayosejtkbn(),
            C_NayoseJyoutaiKbn.NAYOSEHUMEI, "（新契約）対象者名寄せ状態区分");
        exStringEquals(skSakuinLst.get(5).getSktaisyousakuinnmno(), "", "（新契約）対象者索引名番号");
        assertNull("（新契約）対象者生年月日", skSakuinLst.get(5).getSktaisyouseiymd());
        exNumericEquals(skSakuinLst.get(5).getSksyouhnsdno(), 25, "（新契約）商品世代番号");

        exStringEquals(skSakuinLst.get(6).getSkmosno(), "791112402", "（新契約）申込番号");

        exClassificationEquals(skSakuinLst.get(6).getSkmoskankeisyakbn(),
            C_KankeisyaKbn.KYK, "（新契約）申込関係者区分");

        exStringEquals(skSakuinLst.get(6).getSkmosfkojinkbn(), "03", "（新契約）申込Ｆ個人区分");
        exClassificationEquals(skSakuinLst.get(6).getSkmfrenflg(),
            C_Mfrenflg.SUMI, "（新契約）ＭＦ連動済フラグ");
        exDateEquals(skSakuinLst.get(6).getSkmosymd(), BizDate.valueOf("19960509"), "（新契約）申込日");
        exDateEquals(skSakuinLst.get(6).getSkkykymd(), BizDate.valueOf("19960619"), "（新契約）契約日");

        exClassificationEquals(skSakuinLst.get(6).getSkseiritukbn(),
            C_SeirituKbn.SEIRITU, "（新契約）成立区分");
        exDateEquals(skSakuinLst.get(6).getSksrsyoriymd(), BizDate.valueOf("19971016"), "（新契約）成立処理日");

        exStringEquals(skSakuinLst.get(6).getSksyouhncd(), "sk", "（新契約）商品コード");

        assertNull("（新契約）募集年月", skSakuinLst.get(0).getSkbosyuuym());

        exClassificationEquals(skSakuinLst.get(6).getSktaisyounayosejtkbn(),
            C_NayoseJyoutaiKbn.NAYOSEHUMEI, "（新契約）対象者名寄せ状態区分");
        exStringEquals(skSakuinLst.get(6).getSktaisyousakuinnmno(), "", "（新契約）対象者索引名番号");
        assertNull("（新契約）対象者生年月日", skSakuinLst.get(6).getSktaisyouseiymd());
        exNumericEquals(skSakuinLst.get(6).getSksyouhnsdno(), 26, "（新契約）商品世代番号");

        exStringEquals(skSakuinLst.get(7).getSkmosno(), "791112402", "（新契約）申込番号");

        exClassificationEquals(skSakuinLst.get(7).getSkmoskankeisyakbn(),
            C_KankeisyaKbn.KYK, "（新契約）申込関係者区分");

        exStringEquals(skSakuinLst.get(7).getSkmosfkojinkbn(), "03", "（新契約）申込Ｆ個人区分");
        exClassificationEquals(skSakuinLst.get(7).getSkmfrenflg(),
            C_Mfrenflg.SUMI, "（新契約）ＭＦ連動済フラグ");
        exDateEquals(skSakuinLst.get(7).getSkmosymd(), BizDate.valueOf("19970509"), "（新契約）申込日");
        exDateEquals(skSakuinLst.get(7).getSkkykymd(), BizDate.valueOf("19970619"), "（新契約）契約日");

        exClassificationEquals(skSakuinLst.get(7).getSkseiritukbn(),
            C_SeirituKbn.SEIRITU, "（新契約）成立区分");
        exDateEquals(skSakuinLst.get(7).getSksrsyoriymd(), BizDate.valueOf("19971017"), "（新契約）成立処理日");

        exStringEquals(skSakuinLst.get(7).getSksyouhncd(), "sk", "（新契約）商品コード");

        assertNull("（新契約）募集年月", skSakuinLst.get(0).getSkbosyuuym());

        exClassificationEquals(skSakuinLst.get(7).getSktaisyounayosejtkbn(),
            C_NayoseJyoutaiKbn.NAYOSEHUMEI, "（新契約）対象者名寄せ状態区分");
        exStringEquals(skSakuinLst.get(7).getSktaisyousakuinnmno(), "", "（新契約）対象者索引名番号");
        assertNull("（新契約）対象者生年月日", skSakuinLst.get(7).getSktaisyouseiymd());
        exNumericEquals(skSakuinLst.get(7).getSksyouhnsdno(), 27, "（新契約）商品世代番号");

        exStringEquals(skSakuinLst.get(8).getSkmosno(), "791112402", "（新契約）申込番号");

        exClassificationEquals(skSakuinLst.get(8).getSkmoskankeisyakbn(),
            C_KankeisyaKbn.KYK, "（新契約）申込関係者区分");

        exStringEquals(skSakuinLst.get(8).getSkmosfkojinkbn(), "03", "（新契約）申込Ｆ個人区分");
        exClassificationEquals(skSakuinLst.get(8).getSkmfrenflg(),
            C_Mfrenflg.SUMI, "（新契約）ＭＦ連動済フラグ");
        exDateEquals(skSakuinLst.get(8).getSkmosymd(), BizDate.valueOf("19980509"), "（新契約）申込日");
        exDateEquals(skSakuinLst.get(8).getSkkykymd(), BizDate.valueOf("19980619"), "（新契約）契約日");

        exClassificationEquals(skSakuinLst.get(8).getSkseiritukbn(),
            C_SeirituKbn.SEIRITU, "（新契約）成立区分");
        exDateEquals(skSakuinLst.get(8).getSksrsyoriymd(), BizDate.valueOf("19971018"), "（新契約）成立処理日");

        exStringEquals(skSakuinLst.get(8).getSksyouhncd(), "sk", "（新契約）商品コード");

        assertNull("（新契約）募集年月", skSakuinLst.get(0).getSkbosyuuym());

        exClassificationEquals(skSakuinLst.get(8).getSktaisyounayosejtkbn(),
            C_NayoseJyoutaiKbn.NAYOSEHUMEI, "（新契約）対象者名寄せ状態区分");
        exStringEquals(skSakuinLst.get(8).getSktaisyousakuinnmno(), "", "（新契約）対象者索引名番号");
        assertNull("（新契約）対象者生年月日", skSakuinLst.get(8).getSktaisyouseiymd());
        exNumericEquals(skSakuinLst.get(8).getSksyouhnsdno(), 28, "（新契約）商品世代番号");

        exStringEquals(skSakuinLst.get(9).getSkmosno(), "791112402", "（新契約）申込番号");

        exClassificationEquals(skSakuinLst.get(9).getSkmoskankeisyakbn(),
            C_KankeisyaKbn.KYK, "（新契約）申込関係者区分");

        exStringEquals(skSakuinLst.get(9).getSkmosfkojinkbn(), "03", "（新契約）申込Ｆ個人区分");
        exClassificationEquals(skSakuinLst.get(9).getSkmfrenflg(),
            C_Mfrenflg.SUMI, "（新契約）ＭＦ連動済フラグ");
        exDateEquals(skSakuinLst.get(9).getSkmosymd(), BizDate.valueOf("19990509"), "（新契約）申込日");
        exDateEquals(skSakuinLst.get(9).getSkkykymd(), BizDate.valueOf("19990619"), "（新契約）契約日");

        exClassificationEquals(skSakuinLst.get(9).getSkseiritukbn(),
            C_SeirituKbn.SEIRITU, "（新契約）成立区分");
        exDateEquals(skSakuinLst.get(9).getSksrsyoriymd(), BizDate.valueOf("19971019"), "（新契約）成立処理日");

        exStringEquals(skSakuinLst.get(9).getSksyouhncd(), "sk", "（新契約）商品コード");

        assertNull("（新契約）募集年月", skSakuinLst.get(0).getSkbosyuuym());

        exClassificationEquals(skSakuinLst.get(9).getSktaisyounayosejtkbn(),
            C_NayoseJyoutaiKbn.NAYOSEHUMEI, "（新契約）対象者名寄せ状態区分");
        exStringEquals(skSakuinLst.get(9).getSktaisyousakuinnmno(), "", "（新契約）対象者索引名番号");
        assertNull("（新契約）対象者生年月日", skSakuinLst.get(9).getSktaisyouseiymd());
        exNumericEquals(skSakuinLst.get(9).getSksyouhnsdno(), 29, "（新契約）商品世代番号");


        List<BzNenkinSiharaiSakuinKekkaBean> nkShrSakuinLst = bzSakuinTsnSyoukaiKekkaBean
            .getBznenkinsiharaisakuinkekkabeanlist();


        exNumericEquals(nkShrSakuinLst.size(), 10, "年金支払索引結果Beanリストのサイズ");
        exStringEquals(nkShrSakuinLst.get(0).getNknksysyno(), "11807111222", "（年金支払）年金証書番号");

        exClassificationEquals(nkShrSakuinLst.get(0).getNknkkankeisyakbn(),
            C_NkKankeisyaKbn.HHKN_NKUKTBETU, "（年金支払）年金支払関係者区分");

        exStringEquals(nkShrSakuinLst.get(0).getNknkkojinkbn(), "05", "（年金支払）年金支払個人区分");
        exDateEquals(nkShrSakuinLst.get(0).getNkkykymd(), BizDate.valueOf("20000402"), "（年金支払）契約日");
        exDateEquals(nkShrSakuinLst.get(0).getNknkshrstartymd(), BizDate.valueOf("20000409"), "（年金支払）年金支払開始日");

        exClassificationEquals(nkShrSakuinLst.get(0).getNknksyoumetucd(), C_NkSyoumetuCd.SIBOU, "（年金支払）年金消滅コード");
        exDateEquals(nkShrSakuinLst.get(0).getNksyoumetuymd(), BizDate.valueOf("20050510"), "（年金支払）消滅日");

        exStringEquals(nkShrSakuinLst.get(0).getNksyouhncd(), "nk", "（年金支払）商品コード");

        exStringEquals(nkShrSakuinLst.get(0).getNknenkinsyu(), "01", "（年金支払）年金種類");
        exDateEquals(nkShrSakuinLst.get(0).getNktaisyouseiymd(), BizDate.valueOf("19780410"), "（年金支払）対象者生年月日");
        exNumericEquals(nkShrSakuinLst.get(0).getNksyouhnsdno(), 30, "（年金支払）商品世代番号");

        exStringEquals(nkShrSakuinLst.get(1).getNknksysyno(), "11807111222", "（年金支払）年金証書番号");

        exClassificationEquals(nkShrSakuinLst.get(1).getNknkkankeisyakbn(),
            C_NkKankeisyaKbn.HHKN_NKUKTBETU, "（年金支払）年金支払関係者区分");

        exStringEquals(nkShrSakuinLst.get(1).getNknkkojinkbn(), "05", "（年金支払）年金支払個人区分");
        exDateEquals(nkShrSakuinLst.get(1).getNkkykymd(), BizDate.valueOf("20010402"), "（年金支払）契約日");
        exDateEquals(nkShrSakuinLst.get(1).getNknkshrstartymd(), BizDate.valueOf("20010409"), "（年金支払）年金支払開始日");

        exClassificationEquals(nkShrSakuinLst.get(1).getNknksyoumetucd(), C_NkSyoumetuCd.SIBOU, "（年金支払）年金消滅コード");
        exDateEquals(nkShrSakuinLst.get(1).getNksyoumetuymd(), BizDate.valueOf("20050511"), "（年金支払）消滅日");

        exStringEquals(nkShrSakuinLst.get(1).getNksyouhncd(), "nk", "（年金支払）商品コード");

        exStringEquals(nkShrSakuinLst.get(1).getNknenkinsyu(), "01", "（年金支払）年金種類");
        exDateEquals(nkShrSakuinLst.get(1).getNktaisyouseiymd(), BizDate.valueOf("19780411"), "（年金支払）対象者生年月日");
        exNumericEquals(nkShrSakuinLst.get(1).getNksyouhnsdno(), 31, "（年金支払）商品世代番号");

        exStringEquals(nkShrSakuinLst.get(2).getNknksysyno(), "11807111222", "（年金支払）年金証書番号");

        exClassificationEquals(nkShrSakuinLst.get(2).getNknkkankeisyakbn(),
            C_NkKankeisyaKbn.HHKN_NKUKTBETU, "（年金支払）年金支払関係者区分");

        exStringEquals(nkShrSakuinLst.get(2).getNknkkojinkbn(), "05", "（年金支払）年金支払個人区分");
        exDateEquals(nkShrSakuinLst.get(2).getNkkykymd(), BizDate.valueOf("20020402"), "（年金支払）契約日");
        exDateEquals(nkShrSakuinLst.get(2).getNknkshrstartymd(), BizDate.valueOf("20020409"), "（年金支払）年金支払開始日");

        exClassificationEquals(nkShrSakuinLst.get(2).getNknksyoumetucd(), C_NkSyoumetuCd.SIBOU, "（年金支払）年金消滅コード");
        exDateEquals(nkShrSakuinLst.get(2).getNksyoumetuymd(), BizDate.valueOf("20050512"), "（年金支払）消滅日");

        exStringEquals(nkShrSakuinLst.get(2).getNksyouhncd(), "nk", "（年金支払）商品コード");

        exStringEquals(nkShrSakuinLst.get(2).getNknenkinsyu(), "01", "（年金支払）年金種類");
        exDateEquals(nkShrSakuinLst.get(2).getNktaisyouseiymd(), BizDate.valueOf("19780412"), "（年金支払）対象者生年月日");
        exNumericEquals(nkShrSakuinLst.get(2).getNksyouhnsdno(), 32, "（年金支払）商品世代番号");

        exStringEquals(nkShrSakuinLst.get(3).getNknksysyno(), "11807111222", "（年金支払）年金証書番号");

        exClassificationEquals(nkShrSakuinLst.get(3).getNknkkankeisyakbn(),
            C_NkKankeisyaKbn.HHKN_NKUKTBETU, "（年金支払）年金支払関係者区分");

        exStringEquals(nkShrSakuinLst.get(3).getNknkkojinkbn(), "05", "（年金支払）年金支払個人区分");
        exDateEquals(nkShrSakuinLst.get(3).getNkkykymd(), BizDate.valueOf("20030402"), "（年金支払）契約日");
        exDateEquals(nkShrSakuinLst.get(3).getNknkshrstartymd(), BizDate.valueOf("20030409"), "（年金支払）年金支払開始日");

        exClassificationEquals(nkShrSakuinLst.get(3).getNknksyoumetucd(), C_NkSyoumetuCd.SIBOU, "（年金支払）年金消滅コード");
        exDateEquals(nkShrSakuinLst.get(3).getNksyoumetuymd(), BizDate.valueOf("20050513"), "（年金支払）消滅日");

        exStringEquals(nkShrSakuinLst.get(3).getNksyouhncd(), "nk", "（年金支払）商品コード");

        exStringEquals(nkShrSakuinLst.get(3).getNknenkinsyu(), "01", "（年金支払）年金種類");
        exDateEquals(nkShrSakuinLst.get(3).getNktaisyouseiymd(), BizDate.valueOf("19780413"), "（年金支払）対象者生年月日");
        exNumericEquals(nkShrSakuinLst.get(3).getNksyouhnsdno(), 33, "（年金支払）商品世代番号");

        exStringEquals(nkShrSakuinLst.get(4).getNknksysyno(), "11807111222", "（年金支払）年金証書番号");

        exClassificationEquals(nkShrSakuinLst.get(4).getNknkkankeisyakbn(),
            C_NkKankeisyaKbn.HHKN_NKUKTBETU, "（年金支払）年金支払関係者区分");

        exStringEquals(nkShrSakuinLst.get(4).getNknkkojinkbn(), "05", "（年金支払）年金支払個人区分");
        exDateEquals(nkShrSakuinLst.get(4).getNkkykymd(), BizDate.valueOf("20040402"), "（年金支払）契約日");
        exDateEquals(nkShrSakuinLst.get(4).getNknkshrstartymd(), BizDate.valueOf("20040409"), "（年金支払）年金支払開始日");

        exClassificationEquals(nkShrSakuinLst.get(4).getNknksyoumetucd(), C_NkSyoumetuCd.SIBOU, "（年金支払）年金消滅コード");
        exDateEquals(nkShrSakuinLst.get(4).getNksyoumetuymd(), BizDate.valueOf("20050514"), "（年金支払）消滅日");

        exStringEquals(nkShrSakuinLst.get(4).getNksyouhncd(), "nk", "（年金支払）商品コード");

        exStringEquals(nkShrSakuinLst.get(4).getNknenkinsyu(), "01", "（年金支払）年金種類");
        exDateEquals(nkShrSakuinLst.get(4).getNktaisyouseiymd(), BizDate.valueOf("19780414"), "（年金支払）対象者生年月日");
        exNumericEquals(nkShrSakuinLst.get(4).getNksyouhnsdno(), 34, "（年金支払）商品世代番号");

        exStringEquals(nkShrSakuinLst.get(5).getNknksysyno(), "11807111222", "（年金支払）年金証書番号");

        exClassificationEquals(nkShrSakuinLst.get(5).getNknkkankeisyakbn(),
            C_NkKankeisyaKbn.HHKN_NKUKTBETU, "（年金支払）年金支払関係者区分");

        exStringEquals(nkShrSakuinLst.get(5).getNknkkojinkbn(), "05", "（年金支払）年金支払個人区分");
        exDateEquals(nkShrSakuinLst.get(5).getNkkykymd(), BizDate.valueOf("20050402"), "（年金支払）契約日");
        exDateEquals(nkShrSakuinLst.get(5).getNknkshrstartymd(), BizDate.valueOf("20050409"), "（年金支払）年金支払開始日");

        exClassificationEquals(nkShrSakuinLst.get(5).getNknksyoumetucd(), C_NkSyoumetuCd.SIBOU, "（年金支払）年金消滅コード");
        exDateEquals(nkShrSakuinLst.get(5).getNksyoumetuymd(), BizDate.valueOf("20050515"), "（年金支払）消滅日");

        exStringEquals(nkShrSakuinLst.get(5).getNksyouhncd(), "nk", "（年金支払）商品コード");

        exStringEquals(nkShrSakuinLst.get(5).getNknenkinsyu(), "01", "（年金支払）年金種類");
        exDateEquals(nkShrSakuinLst.get(5).getNktaisyouseiymd(), BizDate.valueOf("19780415"), "（年金支払）対象者生年月日");
        exNumericEquals(nkShrSakuinLst.get(5).getNksyouhnsdno(), 35, "（年金支払）商品世代番号");

        exStringEquals(nkShrSakuinLst.get(6).getNknksysyno(), "11807111222", "（年金支払）年金証書番号");

        exClassificationEquals(nkShrSakuinLst.get(6).getNknkkankeisyakbn(),
            C_NkKankeisyaKbn.HHKN_NKUKTBETU, "（年金支払）年金支払関係者区分");

        exStringEquals(nkShrSakuinLst.get(6).getNknkkojinkbn(), "05", "（年金支払）年金支払個人区分");
        exDateEquals(nkShrSakuinLst.get(6).getNkkykymd(), BizDate.valueOf("20060402"), "（年金支払）契約日");
        exDateEquals(nkShrSakuinLst.get(6).getNknkshrstartymd(), BizDate.valueOf("20060409"), "（年金支払）年金支払開始日");

        exClassificationEquals(nkShrSakuinLst.get(6).getNknksyoumetucd(), C_NkSyoumetuCd.SIBOU, "（年金支払）年金消滅コード");
        exDateEquals(nkShrSakuinLst.get(6).getNksyoumetuymd(), BizDate.valueOf("20050516"), "（年金支払）消滅日");

        exStringEquals(nkShrSakuinLst.get(6).getNksyouhncd(), "nk", "（年金支払）商品コード");

        exStringEquals(nkShrSakuinLst.get(6).getNknenkinsyu(), "01", "（年金支払）年金種類");
        exDateEquals(nkShrSakuinLst.get(6).getNktaisyouseiymd(), BizDate.valueOf("19780416"), "（年金支払）対象者生年月日");
        exNumericEquals(nkShrSakuinLst.get(6).getNksyouhnsdno(), 36, "（年金支払）商品世代番号");

        exStringEquals(nkShrSakuinLst.get(7).getNknksysyno(), "11807111222", "（年金支払）年金証書番号");

        exClassificationEquals(nkShrSakuinLst.get(7).getNknkkankeisyakbn(),
            C_NkKankeisyaKbn.HHKN_NKUKTBETU, "（年金支払）年金支払関係者区分");

        exStringEquals(nkShrSakuinLst.get(7).getNknkkojinkbn(), "05", "（年金支払）年金支払個人区分");
        exDateEquals(nkShrSakuinLst.get(7).getNkkykymd(), BizDate.valueOf("20070402"), "（年金支払）契約日");
        exDateEquals(nkShrSakuinLst.get(7).getNknkshrstartymd(), BizDate.valueOf("20070409"), "（年金支払）年金支払開始日");

        exClassificationEquals(nkShrSakuinLst.get(7).getNknksyoumetucd(), C_NkSyoumetuCd.SIBOU, "（年金支払）年金消滅コード");
        exDateEquals(nkShrSakuinLst.get(7).getNksyoumetuymd(), BizDate.valueOf("20050517"), "（年金支払）消滅日");

        exStringEquals(nkShrSakuinLst.get(7).getNksyouhncd(), "nk", "（年金支払）商品コード");

        exStringEquals(nkShrSakuinLst.get(7).getNknenkinsyu(), "01", "（年金支払）年金種類");
        exDateEquals(nkShrSakuinLst.get(7).getNktaisyouseiymd(), BizDate.valueOf("19780417"), "（年金支払）対象者生年月日");
        exNumericEquals(nkShrSakuinLst.get(7).getNksyouhnsdno(), 37, "（年金支払）商品世代番号");

        exStringEquals(nkShrSakuinLst.get(8).getNknksysyno(), "11807111222", "（年金支払）年金証書番号");

        exClassificationEquals(nkShrSakuinLst.get(8).getNknkkankeisyakbn(),
            C_NkKankeisyaKbn.HHKN_NKUKTBETU, "（年金支払）年金支払関係者区分");

        exStringEquals(nkShrSakuinLst.get(8).getNknkkojinkbn(), "05", "（年金支払）年金支払個人区分");
        exDateEquals(nkShrSakuinLst.get(8).getNkkykymd(), BizDate.valueOf("20080402"), "（年金支払）契約日");
        exDateEquals(nkShrSakuinLst.get(8).getNknkshrstartymd(), BizDate.valueOf("20080409"), "（年金支払）年金支払開始日");

        exClassificationEquals(nkShrSakuinLst.get(8).getNknksyoumetucd(), C_NkSyoumetuCd.SIBOU, "（年金支払）年金消滅コード");
        exDateEquals(nkShrSakuinLst.get(8).getNksyoumetuymd(), BizDate.valueOf("20050518"), "（年金支払）消滅日");

        exStringEquals(nkShrSakuinLst.get(8).getNksyouhncd(), "nk", "（年金支払）商品コード");

        exStringEquals(nkShrSakuinLst.get(8).getNknenkinsyu(), "01", "（年金支払）年金種類");
        exDateEquals(nkShrSakuinLst.get(8).getNktaisyouseiymd(), BizDate.valueOf("19780418"), "（年金支払）対象者生年月日");
        exNumericEquals(nkShrSakuinLst.get(8).getNksyouhnsdno(), 38, "（年金支払）商品世代番号");

        exStringEquals(nkShrSakuinLst.get(9).getNknksysyno(), "11807111222", "（年金支払）年金証書番号");

        exClassificationEquals(nkShrSakuinLst.get(9).getNknkkankeisyakbn(),
            C_NkKankeisyaKbn.HHKN_NKUKTBETU, "（年金支払）年金支払関係者区分");

        exStringEquals(nkShrSakuinLst.get(9).getNknkkojinkbn(), "05", "（年金支払）年金支払個人区分");
        exDateEquals(nkShrSakuinLst.get(9).getNkkykymd(), BizDate.valueOf("20090402"), "（年金支払）契約日");
        exDateEquals(nkShrSakuinLst.get(9).getNknkshrstartymd(), BizDate.valueOf("20090409"), "（年金支払）年金支払開始日");

        exClassificationEquals(nkShrSakuinLst.get(9).getNknksyoumetucd(), C_NkSyoumetuCd.SIBOU, "（年金支払）年金消滅コード");
        exDateEquals(nkShrSakuinLst.get(9).getNksyoumetuymd(), BizDate.valueOf("20050519"), "（年金支払）消滅日");

        exStringEquals(nkShrSakuinLst.get(9).getNksyouhncd(), "nk", "（年金支払）商品コード");

        exStringEquals(nkShrSakuinLst.get(9).getNknenkinsyu(), "01", "（年金支払）年金種類");
        exDateEquals(nkShrSakuinLst.get(9).getNktaisyouseiymd(), BizDate.valueOf("19780419"), "（年金支払）対象者生年月日");
        exNumericEquals(nkShrSakuinLst.get(9).getNksyouhnsdno(), 39, "（年金支払）商品世代番号");


        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSntkinfomrumukbn(),
            C_BlnktkumuKbn.ARI, "選択情報ＭＲ有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSntkinfohnsyumukbn(),
            C_BlnktkumuKbn.ARI, "選択情報反社有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSignalinfoumukbn(),
            C_BlnktkumuKbn.ARI, "シグナル情報有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSignalinfohnsyumukbn(),
            C_BlnktkumuKbn.ARI, "シグナル情報反社有無区分");


        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getGaikokupepsumukbn(),
            C_BlnktkumuKbn.ARI, "外国ＰＥＰｓ有無区分");


        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSinsntkhnsyumukbn(),
            C_BlnktkumuKbn.ARI, "新選択情報反社有無区分");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnsibous().toString(), "12345678901", "通算総死亡Ｓ");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnninenmikeikas().toString(), "12345678902", "通算２年未経過総死亡Ｓ");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnninenkeikas().toString(), "12345678903", "通算２年経過総死亡Ｓ");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnketsibous().toString(), "12345678904", "通算決定総死亡Ｓ");

        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnketsibous2().toString(), "12345678905", "通算決定総死亡Ｓ２");

        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnsoukktjituhsgk().toString(), "12345678906", "通算総告知書実保障額");

        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnkktjituhsgk1().toString(), "12345678907", "通算告知書実保障額１");

        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnkktjituhsgk2().toString(), "12345678908", "通算告知書実保障額２");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnkktitijibrsysnjs().toString(), "12345678909", "通算告知書一時払終身等除Ｓ");

        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnnkgns().toString(), "12345678900", "通算年金原資");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnmsnynenbtsousbus().toString(), "22345678900", "通算未成年用年齢別総死亡Ｓ");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnnenbtitijibrssbs().toString(), "32345678900", "通算年齢別一時払総死亡Ｓ");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnitijibrsysnp().toString(), "32345678901", "通算一時払終身");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnninenmikeikahtnkns().toString(), "32345678902", "通算２年未経過被転換死亡Ｓ");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnninenkeikadfp().toString(), "32345678903", "通算２年経過ＤＦＰ");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnsntktuukahijynsysns().toString(), "12345678901", "通算選択通貨建平準払終身Ｓ");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnkaigomehrtkumukbn(),
            C_UmuKbn.ARI, "通算介護前払特約有無区分");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getKykdrtentsns().toString(), "42345678900", "契約者同一代理店通算Ｓ");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSibouriskmoshukakbn(),
            C_MosHukaKbn.HUKA, "死亡リスク申込不可区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getKktsibouriskmoshukakbn(),
            C_MosHukaKbn.KA, "告知扱死亡リスク申込不可区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getItineninaienkigaitoukbn(),
            C_GaitouKbn.GAITOU, "１年以内延期該当区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getItekisntkhndktyhkbn(),
            C_YouhiblnkKbn.HUYOU, "医的選択情報ハンド決定要否区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getTtdktyuuiknkhndktyhkbn(),
            C_YouhiblnkKbn.YOU, "手続注意環境ハンド決定要否区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getUktttdktyuuiknkhndktyhkbn(),
            C_YouhiblnkKbn.YOU, "受取人用手続注意環境ハンド決定要否区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getKyhkinuktkariitkhndktyhkbn(),
            C_YouhiblnkKbn.BLNK, "給付金受付有医的ハンド決定要否区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getDoujimositekihndktyhkbn(),
            C_YouhiblnkKbn.YOU, "同時申込医的ハンド決定要否区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getDoujimosknkhndktyhkbn(),
            C_YouhiblnkKbn.YOU, "同時申込環境ハンド決定要否区分");

    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {


        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN5;

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = SWAKInjector
            .getInstance(BzSakuinTsnSyoukaiYokenBean.class);


        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);


        editYokenDate(bzSakuinTsnSyoukaiYokenBean);


        BzSakuinTsnSyoukaiMq bzSakuinTsnSyoukaiMq = SWAKInjector.getInstance(BzSakuinTsnSyoukaiMq.class);
        BzSakuinTsnSyoukaiKekkaBean bzSakuinTsnSyoukaiKekkaBean =
            bzSakuinTsnSyoukaiMq.exec(bzSakuinTsnSyoukaiYokenBean);


        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getMqsyorikekkakbn(),
            C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getPalsyoukaijissiumukbn(),
            C_PalSyoukaiJissiumuKbn.ARI, "ＰＡＬあて照会実施有無区分");

        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getAcserrcd(), "0000", "ＡＣＳ基盤エラーコード");


        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSakuininfosyoukaierrkbn(),
            C_MQSyoukaiErrorKbn.SYOUKAIERROR, "索引情報照会エラー区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getMrsyoukaierrkbn(),
            C_MQSyoukaiErrorKbn.SYOUKAIOK, "ＭＲ照会エラー区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSignalsyoukaierrkbn(),
            C_MQSyoukaiErrorKbn.BLNK, "シグナル照会エラー区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSinsntkhnsysyoukaierrkbn(),
            C_MQSyoukaiErrorKbn.SYOUKAIERROR, "新選択情報反社照会エラー区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getNysjyoutaikbn(),
            C_NayoseJyoutaiKbn.NAYOSEHUMEI, "名寄せ状態区分");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getSakuinnmno(), "1234567890", "索引名番号");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getTsngksyoukaierrkbn(),
            C_MQSyoukaiErrorKbn.SYOUKAIERROR, "通算金額照会エラー区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getKykdrtentsnssyoukaierrkbn(),
            C_MQSyoukaiErrorKbn.SYOUKAIERROR, "契約者同一代理店通算Ｓ照会エラー区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getMossakuseikahisyoukaierrkbn(),
            C_MQSyoukaiErrorKbn.SYOUKAIERROR, "申込書作成可否照会エラー区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getHndketyhsyoukaierrkbn(),
            C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ハンド決定要否照会エラー区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getNysjissikekkakbn(),
            C_NayoseJissiKekkaKbn.DOUITUARI, "名寄せ実施結果区分");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getKykmfkensuu(), 10, "契約ＭＦ個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getMosfkensuu(), 10, "申込Ｆ個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getSntkfkensuu(), 10, "選択情報Ｆ個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getSueokifkensuu(), 10, "据置Ｆ個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getNkfkensuu(), 10, "年金Ｆ個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getKhkensuu(), 10, "契約保全個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getSkkensuu(), 10, "新契約個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getNkkensuu(), 10, "年金支払個別項目設定件数");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getKykmfkensuutyoukaumu(),
            C_BlnktkumuKbn.ARI, "契約ＭＦ件数超過有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getMosfkensuutyoukaumu(),
            C_BlnktkumuKbn.BLNK, "申込Ｆ件数超過有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSntkfkensuutyoukaumu(),
            C_BlnktkumuKbn.NONE, "選択情報Ｆ件数超過有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSueokifkensuutyoukaumu(),
            C_BlnktkumuKbn.ARI, "据置Ｆ件数超過有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getNkfkensuutyoukaumu(),
            C_BlnktkumuKbn.ARI, "年金Ｆ件数超過有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getKhkensuutyoukaumu(),
            C_BlnktkumuKbn.ARI, "契約保全件数超過有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSkkensuutyoukaumu(),
            C_BlnktkumuKbn.ARI, "新契約件数超過有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getNkkensuutyoukaumu(),
            C_BlnktkumuKbn.ARI, "年金支払件数超過有無区分");


        List<BzKeiyakuMfSakuinKekkaBean> kykMfSakuinKekkaBeanLst = bzSakuinTsnSyoukaiKekkaBean
            .getBzkeiyakumfsakuinkekkabeanlist();
        exNumericEquals(kykMfSakuinKekkaBeanLst.size(), 10, "契約ＭＦ索引結果Beanリストのサイズ");


        exStringEquals(kykMfSakuinKekkaBeanLst.get(0).getKykmfsyono(), "11807111129", "（契約ＭＦ）証券番号");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(0).getKykmfkykkankeisyakbn(),
            C_KankeisyaKbn.KYK, "（契約ＭＦ）契約関係者区分");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(0).getKykmfkykmfkojinkbn(),
            "01", "（契約ＭＦ）契約ＭＦ個人区分");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(0).getKykmfkykjyoutaikbn(),
            C_KykJyoutaiKbn.SIKKOU, "（契約ＭＦ）契約状態区分");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(0).getKykmfkykymd(), BizDate.valueOf("19900311"), "（契約ＭＦ）契約日");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(0).getKykmfsyoumetucd(), "Sm00", "（契約ＭＦ）消滅コード");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(0).getKykmfsyoumetuymd(), BizDate.valueOf("19901004"), "（契約ＭＦ）消滅日");

        exDateYMEquals(kykMfSakuinKekkaBeanLst.get(0).getKykmfbosyuuym(), BizDateYM.valueOf("200010"), "（契約ＭＦ）募集年月");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(0).getKykmftaisyouseiymd(), BizDate.valueOf("19901024"),
            "（契約ＭＦ）対象者生年月日");


        exStringEquals(kykMfSakuinKekkaBeanLst.get(1).getKykmfsyono(), "11807111129", "（契約ＭＦ）証券番号");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(1).getKykmfkykkankeisyakbn(),
            C_KankeisyaKbn.KYK, "（契約ＭＦ）契約関係者区分");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(1).getKykmfkykmfkojinkbn(),
            "01", "（契約ＭＦ）契約ＭＦ個人区分");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(1).getKykmfkykjyoutaikbn(),
            C_KykJyoutaiKbn.SIKKOU, "（契約ＭＦ）契約状態区分");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(1).getKykmfkykymd(), BizDate.valueOf("19910311"), "（契約ＭＦ）契約日");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(1).getKykmfsyoumetucd(), "Sm01", "（契約ＭＦ）消滅コード");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(1).getKykmfsyoumetuymd(), BizDate.valueOf("19911004"), "（契約ＭＦ）消滅日");

        exDateYMEquals(kykMfSakuinKekkaBeanLst.get(1).getKykmfbosyuuym(), BizDateYM.valueOf("200110"), "（契約ＭＦ）募集年月");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(1).getKykmftaisyouseiymd(), BizDate.valueOf("19911024"),
            "（契約ＭＦ）対象者生年月日");


        exStringEquals(kykMfSakuinKekkaBeanLst.get(2).getKykmfsyono(), "11807111129", "（契約ＭＦ）証券番号");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(2).getKykmfkykkankeisyakbn(),
            C_KankeisyaKbn.KYK, "（契約ＭＦ）契約関係者区分");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(2).getKykmfkykmfkojinkbn(),
            "01", "（契約ＭＦ）契約ＭＦ個人区分");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(2).getKykmfkykjyoutaikbn(),
            C_KykJyoutaiKbn.SIKKOU, "（契約ＭＦ）契約状態区分");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(2).getKykmfkykymd(), BizDate.valueOf("19920311"), "（契約ＭＦ）契約日");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(2).getKykmfsyoumetucd(), "Sm02", "（契約ＭＦ）消滅コード");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(2).getKykmfsyoumetuymd(), BizDate.valueOf("19921004"), "（契約ＭＦ）消滅日");

        exDateYMEquals(kykMfSakuinKekkaBeanLst.get(2).getKykmfbosyuuym(), BizDateYM.valueOf("200210"), "（契約ＭＦ）募集年月");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(2).getKykmftaisyouseiymd(), BizDate.valueOf("19921024"),
            "（契約ＭＦ）対象者生年月日");


        exStringEquals(kykMfSakuinKekkaBeanLst.get(3).getKykmfsyono(), "11807111129", "（契約ＭＦ）証券番号");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(3).getKykmfkykkankeisyakbn(),
            C_KankeisyaKbn.KYK, "（契約ＭＦ）契約関係者区分");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(3).getKykmfkykmfkojinkbn(),
            "01", "（契約ＭＦ）契約ＭＦ個人区分");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(3).getKykmfkykjyoutaikbn(),
            C_KykJyoutaiKbn.SIKKOU, "（契約ＭＦ）契約状態区分");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(3).getKykmfkykymd(), BizDate.valueOf("19930311"), "（契約ＭＦ）契約日");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(3).getKykmfsyoumetucd(), "Sm03", "（契約ＭＦ）消滅コード");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(3).getKykmfsyoumetuymd(), BizDate.valueOf("19931004"), "（契約ＭＦ）消滅日");

        exDateYMEquals(kykMfSakuinKekkaBeanLst.get(3).getKykmfbosyuuym(), BizDateYM.valueOf("200310"), "（契約ＭＦ）募集年月");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(3).getKykmftaisyouseiymd(), BizDate.valueOf("19931024"),
            "（契約ＭＦ）対象者生年月日");


        exStringEquals(kykMfSakuinKekkaBeanLst.get(4).getKykmfsyono(), "11807111129", "（契約ＭＦ）証券番号");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(4).getKykmfkykkankeisyakbn(),
            C_KankeisyaKbn.KYK, "（契約ＭＦ）契約関係者区分");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(4).getKykmfkykmfkojinkbn(),
            "01", "（契約ＭＦ）契約ＭＦ個人区分");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(4).getKykmfkykjyoutaikbn(),
            C_KykJyoutaiKbn.SIKKOU, "（契約ＭＦ）契約状態区分");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(4).getKykmfkykymd(), BizDate.valueOf("19940311"), "（契約ＭＦ）契約日");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(4).getKykmfsyoumetucd(), "Sm04", "（契約ＭＦ）消滅コード");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(4).getKykmfsyoumetuymd(), BizDate.valueOf("19941004"), "（契約ＭＦ）消滅日");

        exDateYMEquals(kykMfSakuinKekkaBeanLst.get(4).getKykmfbosyuuym(), BizDateYM.valueOf("200410"), "（契約ＭＦ）募集年月");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(4).getKykmftaisyouseiymd(), BizDate.valueOf("19941024"),
            "（契約ＭＦ）対象者生年月日");


        exStringEquals(kykMfSakuinKekkaBeanLst.get(5).getKykmfsyono(), "11807111129", "（契約ＭＦ）証券番号");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(5).getKykmfkykkankeisyakbn(),
            C_KankeisyaKbn.KYK, "（契約ＭＦ）契約関係者区分");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(5).getKykmfkykmfkojinkbn(),
            "01", "（契約ＭＦ）契約ＭＦ個人区分");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(5).getKykmfkykjyoutaikbn(),
            C_KykJyoutaiKbn.SIKKOU, "（契約ＭＦ）契約状態区分");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(5).getKykmfkykymd(), BizDate.valueOf("19950311"), "（契約ＭＦ）契約日");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(5).getKykmfsyoumetucd(), "Sm05", "（契約ＭＦ）消滅コード");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(5).getKykmfsyoumetuymd(), BizDate.valueOf("19951004"), "（契約ＭＦ）消滅日");

        exDateYMEquals(kykMfSakuinKekkaBeanLst.get(5).getKykmfbosyuuym(), BizDateYM.valueOf("200510"), "（契約ＭＦ）募集年月");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(5).getKykmftaisyouseiymd(), BizDate.valueOf("19951024"),
            "（契約ＭＦ）対象者生年月日");


        exStringEquals(kykMfSakuinKekkaBeanLst.get(6).getKykmfsyono(), "11807111129", "（契約ＭＦ）証券番号");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(6).getKykmfkykkankeisyakbn(),
            C_KankeisyaKbn.KYK, "（契約ＭＦ）契約関係者区分");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(6).getKykmfkykmfkojinkbn(),
            "01", "（契約ＭＦ）契約ＭＦ個人区分");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(6).getKykmfkykjyoutaikbn(),
            C_KykJyoutaiKbn.SIKKOU, "（契約ＭＦ）契約状態区分");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(6).getKykmfkykymd(), BizDate.valueOf("19960311"), "（契約ＭＦ）契約日");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(6).getKykmfsyoumetucd(), "Sm06", "（契約ＭＦ）消滅コード");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(6).getKykmfsyoumetuymd(), BizDate.valueOf("19961004"), "（契約ＭＦ）消滅日");

        exDateYMEquals(kykMfSakuinKekkaBeanLst.get(6).getKykmfbosyuuym(), BizDateYM.valueOf("200610"), "（契約ＭＦ）募集年月");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(6).getKykmftaisyouseiymd(), BizDate.valueOf("19961024"),
            "（契約ＭＦ）対象者生年月日");


        exStringEquals(kykMfSakuinKekkaBeanLst.get(7).getKykmfsyono(), "11807111129", "（契約ＭＦ）証券番号");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(7).getKykmfkykkankeisyakbn(),
            C_KankeisyaKbn.KYK, "（契約ＭＦ）契約関係者区分");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(7).getKykmfkykmfkojinkbn(),
            "01", "（契約ＭＦ）契約ＭＦ個人区分");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(7).getKykmfkykjyoutaikbn(),
            C_KykJyoutaiKbn.SIKKOU, "（契約ＭＦ）契約状態区分");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(7).getKykmfkykymd(), BizDate.valueOf("19970311"), "（契約ＭＦ）契約日");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(7).getKykmfsyoumetucd(), "Sm07", "（契約ＭＦ）消滅コード");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(7).getKykmfsyoumetuymd(), BizDate.valueOf("19971004"), "（契約ＭＦ）消滅日");

        exDateYMEquals(kykMfSakuinKekkaBeanLst.get(7).getKykmfbosyuuym(), BizDateYM.valueOf("200710"), "（契約ＭＦ）募集年月");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(7).getKykmftaisyouseiymd(), BizDate.valueOf("19971024"),
            "（契約ＭＦ）対象者生年月日");


        exStringEquals(kykMfSakuinKekkaBeanLst.get(8).getKykmfsyono(), "11807111129", "（契約ＭＦ）証券番号");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(8).getKykmfkykkankeisyakbn(),
            C_KankeisyaKbn.KYK, "（契約ＭＦ）契約関係者区分");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(8).getKykmfkykmfkojinkbn(),
            "01", "（契約ＭＦ）契約ＭＦ個人区分");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(8).getKykmfkykjyoutaikbn(),
            C_KykJyoutaiKbn.SIKKOU, "（契約ＭＦ）契約状態区分");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(8).getKykmfkykymd(), BizDate.valueOf("19980311"), "（契約ＭＦ）契約日");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(8).getKykmfsyoumetucd(), "Sm08", "（契約ＭＦ）消滅コード");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(8).getKykmfsyoumetuymd(), BizDate.valueOf("19981004"), "（契約ＭＦ）消滅日");

        exDateYMEquals(kykMfSakuinKekkaBeanLst.get(8).getKykmfbosyuuym(), BizDateYM.valueOf("200810"), "（契約ＭＦ）募集年月");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(8).getKykmftaisyouseiymd(), BizDate.valueOf("19981024"),
            "（契約ＭＦ）対象者生年月日");


        exStringEquals(kykMfSakuinKekkaBeanLst.get(9).getKykmfsyono(), "11807111129", "（契約ＭＦ）証券番号");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(9).getKykmfkykkankeisyakbn(),
            C_KankeisyaKbn.KYK, "（契約ＭＦ）契約関係者区分");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(9).getKykmfkykmfkojinkbn(),
            "01", "（契約ＭＦ）契約ＭＦ個人区分");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(9).getKykmfkykjyoutaikbn(),
            C_KykJyoutaiKbn.SIKKOU, "（契約ＭＦ）契約状態区分");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(9).getKykmfkykymd(), BizDate.valueOf("19990311"), "（契約ＭＦ）契約日");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(9).getKykmfsyoumetucd(), "Sm09", "（契約ＭＦ）消滅コード");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(9).getKykmfsyoumetuymd(), BizDate.valueOf("19991004"), "（契約ＭＦ）消滅日");

        exDateYMEquals(kykMfSakuinKekkaBeanLst.get(9).getKykmfbosyuuym(), BizDateYM.valueOf("200910"), "（契約ＭＦ）募集年月");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(9).getKykmftaisyouseiymd(), BizDate.valueOf("19991024"),
            "（契約ＭＦ）対象者生年月日");


        List<BzMousikomiFSakuinKekkaBean> mousikomiFSakuinKekkaLst =
            bzSakuinTsnSyoukaiKekkaBean.getBzmousikomifsakuinkekkabeanlist();
        exNumericEquals(mousikomiFSakuinKekkaLst.size(), 10, "申込Ｆ索引結果Beanリストのサイズ");


        exStringEquals(mousikomiFSakuinKekkaLst.get(0).getMosfmosno(),
            "791112220", "（申込Ｆ）申込番号");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(0).getMosfmoskankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（申込Ｆ）申込関係者区分");

        exStringEquals(mousikomiFSakuinKekkaLst.get(0).getMosfmofkojinkbn(),
            "01", "（申込Ｆ）申込Ｆ個人区分");
        exClassificationEquals(mousikomiFSakuinKekkaLst.get(0).getMosfmfrenflg(),
            C_Mfrenflg.SUMI, "（申込Ｆ）ＭＦ連動済フラグ");
        exDateEquals(mousikomiFSakuinKekkaLst.get(0).getMosfmosymd(), BizDate.valueOf("19901112"), "（申込Ｆ）申込日");
        exDateEquals(mousikomiFSakuinKekkaLst.get(0).getMosfkykymd(), BizDate.valueOf("19901201"), "（申込Ｆ）契約日");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(0).getMosfmossyoumetukbn(),
            C_MossyoumetuKbn.SEIRITU, "（申込Ｆ）申込消滅区分");
        exDateEquals(mousikomiFSakuinKekkaLst.get(0).getMosfmossyoumetukktiymd(), BizDate.valueOf("19900105"),
            "（申込Ｆ）申込消滅確定日");

        exDateYMEquals(mousikomiFSakuinKekkaLst.get(0).getMosfbosyuuym(), BizDateYM.valueOf("199003"), "（申込Ｆ）募集年月");
        exDateEquals(mousikomiFSakuinKekkaLst.get(0).getMosftaisyouseiymd(), BizDate.valueOf("19801206"),
            "（申込Ｆ）対象者生年月日");


        exStringEquals(mousikomiFSakuinKekkaLst.get(1).getMosfmosno(),
            "791112220", "（申込Ｆ）申込番号");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(1).getMosfmoskankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（申込Ｆ）申込関係者区分");

        exStringEquals(mousikomiFSakuinKekkaLst.get(1).getMosfmofkojinkbn(),
            "01", "（申込Ｆ）申込Ｆ個人区分");
        exClassificationEquals(mousikomiFSakuinKekkaLst.get(1).getMosfmfrenflg(),
            C_Mfrenflg.SUMI, "（申込Ｆ）ＭＦ連動済フラグ");
        exDateEquals(mousikomiFSakuinKekkaLst.get(1).getMosfmosymd(), BizDate.valueOf("19911112"), "（申込Ｆ）申込日");
        exDateEquals(mousikomiFSakuinKekkaLst.get(1).getMosfkykymd(), BizDate.valueOf("19911201"), "（申込Ｆ）契約日");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(1).getMosfmossyoumetukbn(),
            C_MossyoumetuKbn.SEIRITU, "（申込Ｆ）申込消滅区分");
        exDateEquals(mousikomiFSakuinKekkaLst.get(1).getMosfmossyoumetukktiymd(), BizDate.valueOf("19910105"),
            "（申込Ｆ）申込消滅確定日");

        exDateYMEquals(mousikomiFSakuinKekkaLst.get(1).getMosfbosyuuym(), BizDateYM.valueOf("199103"), "（申込Ｆ）募集年月");
        exDateEquals(mousikomiFSakuinKekkaLst.get(1).getMosftaisyouseiymd(), BizDate.valueOf("19811206"),
            "（申込Ｆ）対象者生年月日");


        exStringEquals(mousikomiFSakuinKekkaLst.get(2).getMosfmosno(),
            "791112220", "（申込Ｆ）申込番号");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(2).getMosfmoskankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（申込Ｆ）申込関係者区分");

        exStringEquals(mousikomiFSakuinKekkaLst.get(2).getMosfmofkojinkbn(),
            "01", "（申込Ｆ）申込Ｆ個人区分");
        exClassificationEquals(mousikomiFSakuinKekkaLst.get(2).getMosfmfrenflg(),
            C_Mfrenflg.SUMI, "（申込Ｆ）ＭＦ連動済フラグ");
        exDateEquals(mousikomiFSakuinKekkaLst.get(2).getMosfmosymd(), BizDate.valueOf("19921112"), "（申込Ｆ）申込日");
        exDateEquals(mousikomiFSakuinKekkaLst.get(2).getMosfkykymd(), BizDate.valueOf("19921201"), "（申込Ｆ）契約日");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(2).getMosfmossyoumetukbn(),
            C_MossyoumetuKbn.SEIRITU, "（申込Ｆ）申込消滅区分");
        exDateEquals(mousikomiFSakuinKekkaLst.get(2).getMosfmossyoumetukktiymd(), BizDate.valueOf("19920105"),
            "（申込Ｆ）申込消滅確定日");

        exDateYMEquals(mousikomiFSakuinKekkaLst.get(2).getMosfbosyuuym(), BizDateYM.valueOf("199203"), "（申込Ｆ）募集年月");
        exDateEquals(mousikomiFSakuinKekkaLst.get(2).getMosftaisyouseiymd(), BizDate.valueOf("19821206"),
            "（申込Ｆ）対象者生年月日");


        exStringEquals(mousikomiFSakuinKekkaLst.get(3).getMosfmosno(),
            "791112220", "（申込Ｆ）申込番号");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(3).getMosfmoskankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（申込Ｆ）申込関係者区分");

        exStringEquals(mousikomiFSakuinKekkaLst.get(3).getMosfmofkojinkbn(),
            "01", "（申込Ｆ）申込Ｆ個人区分");
        exClassificationEquals(mousikomiFSakuinKekkaLst.get(3).getMosfmfrenflg(),
            C_Mfrenflg.SUMI, "（申込Ｆ）ＭＦ連動済フラグ");
        exDateEquals(mousikomiFSakuinKekkaLst.get(3).getMosfmosymd(), BizDate.valueOf("19931112"), "（申込Ｆ）申込日");
        exDateEquals(mousikomiFSakuinKekkaLst.get(3).getMosfkykymd(), BizDate.valueOf("19931201"), "（申込Ｆ）契約日");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(3).getMosfmossyoumetukbn(),
            C_MossyoumetuKbn.SEIRITU, "（申込Ｆ）申込消滅区分");
        exDateEquals(mousikomiFSakuinKekkaLst.get(3).getMosfmossyoumetukktiymd(), BizDate.valueOf("19930105"),
            "（申込Ｆ）申込消滅確定日");

        exDateYMEquals(mousikomiFSakuinKekkaLst.get(3).getMosfbosyuuym(), BizDateYM.valueOf("199303"), "（申込Ｆ）募集年月");
        exDateEquals(mousikomiFSakuinKekkaLst.get(3).getMosftaisyouseiymd(), BizDate.valueOf("19831206"),
            "（申込Ｆ）対象者生年月日");

        exStringEquals(mousikomiFSakuinKekkaLst.get(4).getMosfmosno(),
            "791112220", "（申込Ｆ）申込番号");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(4).getMosfmoskankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（申込Ｆ）申込関係者区分");

        exStringEquals(mousikomiFSakuinKekkaLst.get(4).getMosfmofkojinkbn(),
            "01", "（申込Ｆ）申込Ｆ個人区分");
        exClassificationEquals(mousikomiFSakuinKekkaLst.get(4).getMosfmfrenflg(),
            C_Mfrenflg.SUMI, "（申込Ｆ）ＭＦ連動済フラグ");
        exDateEquals(mousikomiFSakuinKekkaLst.get(4).getMosfmosymd(), BizDate.valueOf("19941112"), "（申込Ｆ）申込日");
        exDateEquals(mousikomiFSakuinKekkaLst.get(4).getMosfkykymd(), BizDate.valueOf("19941201"), "（申込Ｆ）契約日");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(4).getMosfmossyoumetukbn(),
            C_MossyoumetuKbn.SEIRITU, "（申込Ｆ）申込消滅区分");
        exDateEquals(mousikomiFSakuinKekkaLst.get(4).getMosfmossyoumetukktiymd(), BizDate.valueOf("19940105"),
            "（申込Ｆ）申込消滅確定日");

        exDateYMEquals(mousikomiFSakuinKekkaLst.get(4).getMosfbosyuuym(), BizDateYM.valueOf("199403"), "（申込Ｆ）募集年月");
        exDateEquals(mousikomiFSakuinKekkaLst.get(4).getMosftaisyouseiymd(), BizDate.valueOf("19841206"),
            "（申込Ｆ）対象者生年月日");


        exStringEquals(mousikomiFSakuinKekkaLst.get(5).getMosfmosno(),
            "791112220", "（申込Ｆ）申込番号");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(5).getMosfmoskankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（申込Ｆ）申込関係者区分");

        exStringEquals(mousikomiFSakuinKekkaLst.get(5).getMosfmofkojinkbn(),
            "01", "（申込Ｆ）申込Ｆ個人区分");
        exClassificationEquals(mousikomiFSakuinKekkaLst.get(5).getMosfmfrenflg(),
            C_Mfrenflg.SUMI, "（申込Ｆ）ＭＦ連動済フラグ");
        exDateEquals(mousikomiFSakuinKekkaLst.get(5).getMosfmosymd(), BizDate.valueOf("19951112"), "（申込Ｆ）申込日");
        exDateEquals(mousikomiFSakuinKekkaLst.get(5).getMosfkykymd(), BizDate.valueOf("19951201"), "（申込Ｆ）契約日");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(5).getMosfmossyoumetukbn(),
            C_MossyoumetuKbn.SEIRITU, "（申込Ｆ）申込消滅区分");
        exDateEquals(mousikomiFSakuinKekkaLst.get(5).getMosfmossyoumetukktiymd(), BizDate.valueOf("19950105"),
            "（申込Ｆ）申込消滅確定日");

        exDateYMEquals(mousikomiFSakuinKekkaLst.get(5).getMosfbosyuuym(), BizDateYM.valueOf("199503"), "（申込Ｆ）募集年月");
        exDateEquals(mousikomiFSakuinKekkaLst.get(5).getMosftaisyouseiymd(), BizDate.valueOf("19851206"),
            "（申込Ｆ）対象者生年月日");


        exStringEquals(mousikomiFSakuinKekkaLst.get(6).getMosfmosno(),
            "791112220", "（申込Ｆ）申込番号");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(6).getMosfmoskankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（申込Ｆ）申込関係者区分");

        exStringEquals(mousikomiFSakuinKekkaLst.get(6).getMosfmofkojinkbn(),
            "01", "（申込Ｆ）申込Ｆ個人区分");
        exClassificationEquals(mousikomiFSakuinKekkaLst.get(6).getMosfmfrenflg(),
            C_Mfrenflg.SUMI, "（申込Ｆ）ＭＦ連動済フラグ");
        exDateEquals(mousikomiFSakuinKekkaLst.get(6).getMosfmosymd(), BizDate.valueOf("19961112"), "（申込Ｆ）申込日");
        exDateEquals(mousikomiFSakuinKekkaLst.get(6).getMosfkykymd(), BizDate.valueOf("19961201"), "（申込Ｆ）契約日");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(6).getMosfmossyoumetukbn(),
            C_MossyoumetuKbn.SEIRITU, "（申込Ｆ）申込消滅区分");
        exDateEquals(mousikomiFSakuinKekkaLst.get(6).getMosfmossyoumetukktiymd(), BizDate.valueOf("19960105"),
            "（申込Ｆ）申込消滅確定日");

        exDateYMEquals(mousikomiFSakuinKekkaLst.get(6).getMosfbosyuuym(), BizDateYM.valueOf("199603"), "（申込Ｆ）募集年月");
        exDateEquals(mousikomiFSakuinKekkaLst.get(6).getMosftaisyouseiymd(), BizDate.valueOf("19861206"),
            "（申込Ｆ）対象者生年月日");


        exStringEquals(mousikomiFSakuinKekkaLst.get(7).getMosfmosno(),
            "791112220", "（申込Ｆ）申込番号");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(7).getMosfmoskankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（申込Ｆ）申込関係者区分");

        exStringEquals(mousikomiFSakuinKekkaLst.get(7).getMosfmofkojinkbn(),
            "01", "（申込Ｆ）申込Ｆ個人区分");
        exClassificationEquals(mousikomiFSakuinKekkaLst.get(7).getMosfmfrenflg(),
            C_Mfrenflg.SUMI, "（申込Ｆ）ＭＦ連動済フラグ");
        exDateEquals(mousikomiFSakuinKekkaLst.get(7).getMosfmosymd(), BizDate.valueOf("19971112"), "（申込Ｆ）申込日");
        exDateEquals(mousikomiFSakuinKekkaLst.get(7).getMosfkykymd(), BizDate.valueOf("19971201"), "（申込Ｆ）契約日");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(7).getMosfmossyoumetukbn(),
            C_MossyoumetuKbn.SEIRITU, "（申込Ｆ）申込消滅区分");
        exDateEquals(mousikomiFSakuinKekkaLst.get(7).getMosfmossyoumetukktiymd(), BizDate.valueOf("19970105"),
            "（申込Ｆ）申込消滅確定日");

        exDateYMEquals(mousikomiFSakuinKekkaLst.get(7).getMosfbosyuuym(), BizDateYM.valueOf("199703"), "（申込Ｆ）募集年月");
        exDateEquals(mousikomiFSakuinKekkaLst.get(7).getMosftaisyouseiymd(), BizDate.valueOf("19871206"),
            "（申込Ｆ）対象者生年月日");

        exStringEquals(mousikomiFSakuinKekkaLst.get(8).getMosfmosno(),
            "791112220", "（申込Ｆ）申込番号");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(8).getMosfmoskankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（申込Ｆ）申込関係者区分");

        exStringEquals(mousikomiFSakuinKekkaLst.get(8).getMosfmofkojinkbn(),
            "01", "（申込Ｆ）申込Ｆ個人区分");
        exClassificationEquals(mousikomiFSakuinKekkaLst.get(8).getMosfmfrenflg(),
            C_Mfrenflg.SUMI, "（申込Ｆ）ＭＦ連動済フラグ");
        exDateEquals(mousikomiFSakuinKekkaLst.get(8).getMosfmosymd(), BizDate.valueOf("19981112"), "（申込Ｆ）申込日");
        exDateEquals(mousikomiFSakuinKekkaLst.get(8).getMosfkykymd(), BizDate.valueOf("19981201"), "（申込Ｆ）契約日");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(8).getMosfmossyoumetukbn(),
            C_MossyoumetuKbn.SEIRITU, "（申込Ｆ）申込消滅区分");
        exDateEquals(mousikomiFSakuinKekkaLst.get(8).getMosfmossyoumetukktiymd(), BizDate.valueOf("19980105"),
            "（申込Ｆ）申込消滅確定日");

        exDateYMEquals(mousikomiFSakuinKekkaLst.get(8).getMosfbosyuuym(), BizDateYM.valueOf("199803"), "（申込Ｆ）募集年月");
        exDateEquals(mousikomiFSakuinKekkaLst.get(8).getMosftaisyouseiymd(), BizDate.valueOf("19881206"),
            "（申込Ｆ）対象者生年月日");

        exStringEquals(mousikomiFSakuinKekkaLst.get(9).getMosfmosno(),
            "791112220", "（申込Ｆ）申込番号");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(9).getMosfmoskankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（申込Ｆ）申込関係者区分");

        exStringEquals(mousikomiFSakuinKekkaLst.get(9).getMosfmofkojinkbn(),
            "01", "（申込Ｆ）申込Ｆ個人区分");
        exClassificationEquals(mousikomiFSakuinKekkaLst.get(9).getMosfmfrenflg(),
            C_Mfrenflg.SUMI, "（申込Ｆ）ＭＦ連動済フラグ");
        exDateEquals(mousikomiFSakuinKekkaLst.get(9).getMosfmosymd(), BizDate.valueOf("19991112"), "（申込Ｆ）申込日");
        exDateEquals(mousikomiFSakuinKekkaLst.get(9).getMosfkykymd(), BizDate.valueOf("19991201"), "（申込Ｆ）契約日");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(9).getMosfmossyoumetukbn(),
            C_MossyoumetuKbn.SEIRITU, "（申込Ｆ）申込消滅区分");
        exDateEquals(mousikomiFSakuinKekkaLst.get(9).getMosfmossyoumetukktiymd(), BizDate.valueOf("19990105"),
            "（申込Ｆ）申込消滅確定日");

        exDateYMEquals(mousikomiFSakuinKekkaLst.get(9).getMosfbosyuuym(), BizDateYM.valueOf("199903"), "（申込Ｆ）募集年月");
        exDateEquals(mousikomiFSakuinKekkaLst.get(9).getMosftaisyouseiymd(), BizDate.valueOf("19891206"),
            "（申込Ｆ）対象者生年月日");


        List<BzSentakuInfoFSakuinKekkaBean> sakuinTsnSyoukaiKekkaLst =
            bzSakuinTsnSyoukaiKekkaBean.getBzsentakuinfofsakuinkekkabeanlist();
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getBzsentakuinfofsakuinkekkabeanlist().size(), 10,
            "選択情報Ｆ索引結果Beanリストのサイズ");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(0).getSntkinfono(),
            "10000000003", "選択情報番号");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getSntkinfokankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "選択情報関係者区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(0).getSntkinfofkojinkbn(),
            "02", "選択情報Ｆ個人区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getSntkinfokbn(),
            C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sakuinTsnSyoukaiKekkaLst.get(0).getSntkinfosakuseiymd(), BizDate.valueOf("20010310"), "選択情報作成日");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getMrumukbn(),
            C_BlnktkumuKbn.ARI, "ＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getDecumukbn(),
            C_BlnktkumuKbn.ARI, "ＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getInfokoukanumukbn(),
            C_BlnktkumuKbn.ARI, "情報交換有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getNyuuinkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "入院給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getSyujyutukyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "手術給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getSyougaikyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "障害給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getKoudosyougaiumukbn(),
            C_BlnktkumuKbn.ARI, "高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getPmenumukbn(),
            C_BlnktkumuKbn.ARI, "Ｐ免有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getTorikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "取消解除有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getSoukikeakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "早期ケア給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getSonotakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "その他給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getKghsjjtkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "介護保障充実給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getHuho2mrumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getHuho2decumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getHuho2kdumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getHuho2torikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ取消解除有無区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(1).getSntkinfono(),
            "10000000003", "選択情報番号");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getSntkinfokankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "選択情報関係者区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(1).getSntkinfofkojinkbn(),
            "02", "選択情報Ｆ個人区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getSntkinfokbn(),
            C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sakuinTsnSyoukaiKekkaLst.get(1).getSntkinfosakuseiymd(), BizDate.valueOf("20010311"), "選択情報作成日");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getMrumukbn(),
            C_BlnktkumuKbn.ARI, "ＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getDecumukbn(),
            C_BlnktkumuKbn.ARI, "ＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getInfokoukanumukbn(),
            C_BlnktkumuKbn.ARI, "情報交換有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getNyuuinkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "入院給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getSyujyutukyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "手術給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getSyougaikyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "障害給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getKoudosyougaiumukbn(),
            C_BlnktkumuKbn.ARI, "高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getPmenumukbn(),
            C_BlnktkumuKbn.ARI, "Ｐ免有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getTorikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "取消解除有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getSoukikeakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "早期ケア給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getSonotakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "その他給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getKghsjjtkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "介護保障充実給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getHuho2mrumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getHuho2decumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getHuho2kdumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getHuho2torikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ取消解除有無区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(2).getSntkinfono(),
            "10000000003", "選択情報番号");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getSntkinfokankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "選択情報関係者区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(2).getSntkinfofkojinkbn(),
            "02", "選択情報Ｆ個人区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getSntkinfokbn(),
            C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sakuinTsnSyoukaiKekkaLst.get(2).getSntkinfosakuseiymd(), BizDate.valueOf("20010312"), "選択情報作成日");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getMrumukbn(),
            C_BlnktkumuKbn.ARI, "ＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getDecumukbn(),
            C_BlnktkumuKbn.ARI, "ＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getInfokoukanumukbn(),
            C_BlnktkumuKbn.ARI, "情報交換有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getNyuuinkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "入院給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getSyujyutukyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "手術給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getSyougaikyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "障害給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getKoudosyougaiumukbn(),
            C_BlnktkumuKbn.ARI, "高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getPmenumukbn(),
            C_BlnktkumuKbn.ARI, "Ｐ免有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getTorikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "取消解除有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getSoukikeakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "早期ケア給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getSonotakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "その他給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getKghsjjtkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "介護保障充実給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getHuho2mrumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getHuho2decumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getHuho2kdumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getHuho2torikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ取消解除有無区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(3).getSntkinfono(),
            "10000000003", "選択情報番号");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getSntkinfokankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "選択情報関係者区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(3).getSntkinfofkojinkbn(),
            "02", "選択情報Ｆ個人区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getSntkinfokbn(),
            C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sakuinTsnSyoukaiKekkaLst.get(3).getSntkinfosakuseiymd(), BizDate.valueOf("20010313"), "選択情報作成日");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getMrumukbn(),
            C_BlnktkumuKbn.ARI, "ＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getDecumukbn(),
            C_BlnktkumuKbn.ARI, "ＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getInfokoukanumukbn(),
            C_BlnktkumuKbn.ARI, "情報交換有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getNyuuinkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "入院給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getSyujyutukyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "手術給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getSyougaikyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "障害給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getKoudosyougaiumukbn(),
            C_BlnktkumuKbn.ARI, "高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getPmenumukbn(),
            C_BlnktkumuKbn.ARI, "Ｐ免有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getTorikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "取消解除有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getSoukikeakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "早期ケア給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getSonotakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "その他給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getKghsjjtkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "介護保障充実給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getHuho2mrumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getHuho2decumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getHuho2kdumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getHuho2torikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ取消解除有無区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(4).getSntkinfono(),
            "10000000003", "選択情報番号");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getSntkinfokankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "選択情報関係者区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(4).getSntkinfofkojinkbn(),
            "02", "選択情報Ｆ個人区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getSntkinfokbn(),
            C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sakuinTsnSyoukaiKekkaLst.get(4).getSntkinfosakuseiymd(), BizDate.valueOf("20010314"), "選択情報作成日");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getMrumukbn(),
            C_BlnktkumuKbn.ARI, "ＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getDecumukbn(),
            C_BlnktkumuKbn.ARI, "ＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getInfokoukanumukbn(),
            C_BlnktkumuKbn.ARI, "情報交換有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getNyuuinkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "入院給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getSyujyutukyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "手術給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getSyougaikyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "障害給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getKoudosyougaiumukbn(),
            C_BlnktkumuKbn.ARI, "高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getPmenumukbn(),
            C_BlnktkumuKbn.ARI, "Ｐ免有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getTorikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "取消解除有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getSoukikeakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "早期ケア給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getSonotakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "その他給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getKghsjjtkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "介護保障充実給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getHuho2mrumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getHuho2decumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getHuho2kdumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getHuho2torikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ取消解除有無区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(5).getSntkinfono(),
            "10000000003", "選択情報番号");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getSntkinfokankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "選択情報関係者区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(5).getSntkinfofkojinkbn(),
            "02", "選択情報Ｆ個人区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getSntkinfokbn(),
            C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sakuinTsnSyoukaiKekkaLst.get(5).getSntkinfosakuseiymd(), BizDate.valueOf("20010315"), "選択情報作成日");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getMrumukbn(),
            C_BlnktkumuKbn.ARI, "ＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getDecumukbn(),
            C_BlnktkumuKbn.ARI, "ＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getInfokoukanumukbn(),
            C_BlnktkumuKbn.ARI, "情報交換有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getNyuuinkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "入院給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getSyujyutukyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "手術給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getSyougaikyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "障害給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getKoudosyougaiumukbn(),
            C_BlnktkumuKbn.ARI, "高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getPmenumukbn(),
            C_BlnktkumuKbn.ARI, "Ｐ免有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getTorikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "取消解除有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getSoukikeakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "早期ケア給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getSonotakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "その他給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getKghsjjtkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "介護保障充実給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getHuho2mrumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getHuho2decumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getHuho2kdumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getHuho2torikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ取消解除有無区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(6).getSntkinfono(),
            "10000000003", "選択情報番号");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getSntkinfokankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "選択情報関係者区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(6).getSntkinfofkojinkbn(),
            "02", "選択情報Ｆ個人区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getSntkinfokbn(),
            C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sakuinTsnSyoukaiKekkaLst.get(6).getSntkinfosakuseiymd(), BizDate.valueOf("20010316"), "選択情報作成日");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getMrumukbn(),
            C_BlnktkumuKbn.ARI, "ＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getDecumukbn(),
            C_BlnktkumuKbn.ARI, "ＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getInfokoukanumukbn(),
            C_BlnktkumuKbn.ARI, "情報交換有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getNyuuinkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "入院給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getSyujyutukyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "手術給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getSyougaikyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "障害給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getKoudosyougaiumukbn(),
            C_BlnktkumuKbn.ARI, "高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getPmenumukbn(),
            C_BlnktkumuKbn.ARI, "Ｐ免有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getTorikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "取消解除有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getSoukikeakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "早期ケア給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getSonotakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "その他給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getKghsjjtkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "介護保障充実給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getHuho2mrumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getHuho2decumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getHuho2kdumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getHuho2torikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ取消解除有無区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(7).getSntkinfono(),
            "10000000003", "選択情報番号");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getSntkinfokankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "選択情報関係者区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(7).getSntkinfofkojinkbn(),
            "02", "選択情報Ｆ個人区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getSntkinfokbn(),
            C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sakuinTsnSyoukaiKekkaLst.get(7).getSntkinfosakuseiymd(), BizDate.valueOf("20010317"), "選択情報作成日");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getMrumukbn(),
            C_BlnktkumuKbn.ARI, "ＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getDecumukbn(),
            C_BlnktkumuKbn.ARI, "ＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getInfokoukanumukbn(),
            C_BlnktkumuKbn.ARI, "情報交換有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getNyuuinkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "入院給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getSyujyutukyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "手術給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getSyougaikyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "障害給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getKoudosyougaiumukbn(),
            C_BlnktkumuKbn.ARI, "高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getPmenumukbn(),
            C_BlnktkumuKbn.ARI, "Ｐ免有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getTorikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "取消解除有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getSoukikeakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "早期ケア給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getSonotakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "その他給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getKghsjjtkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "介護保障充実給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getHuho2mrumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getHuho2decumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getHuho2kdumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getHuho2torikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ取消解除有無区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(8).getSntkinfono(),
            "10000000003", "選択情報番号");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getSntkinfokankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "選択情報関係者区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(8).getSntkinfofkojinkbn(),
            "02", "選択情報Ｆ個人区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getSntkinfokbn(),
            C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sakuinTsnSyoukaiKekkaLst.get(8).getSntkinfosakuseiymd(), BizDate.valueOf("20010318"), "選択情報作成日");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getMrumukbn(),
            C_BlnktkumuKbn.ARI, "ＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getDecumukbn(),
            C_BlnktkumuKbn.ARI, "ＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getInfokoukanumukbn(),
            C_BlnktkumuKbn.ARI, "情報交換有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getNyuuinkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "入院給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getSyujyutukyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "手術給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getSyougaikyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "障害給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getKoudosyougaiumukbn(),
            C_BlnktkumuKbn.ARI, "高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getPmenumukbn(),
            C_BlnktkumuKbn.ARI, "Ｐ免有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getTorikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "取消解除有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getSoukikeakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "早期ケア給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getSonotakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "その他給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getKghsjjtkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "介護保障充実給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getHuho2mrumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getHuho2decumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getHuho2kdumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getHuho2torikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ取消解除有無区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(9).getSntkinfono(),
            "10000000003", "選択情報番号");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getSntkinfokankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "選択情報関係者区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(9).getSntkinfofkojinkbn(),
            "02", "選択情報Ｆ個人区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getSntkinfokbn(),
            C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sakuinTsnSyoukaiKekkaLst.get(9).getSntkinfosakuseiymd(), BizDate.valueOf("20010319"), "選択情報作成日");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getMrumukbn(),
            C_BlnktkumuKbn.ARI, "ＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getDecumukbn(),
            C_BlnktkumuKbn.ARI, "ＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getInfokoukanumukbn(),
            C_BlnktkumuKbn.ARI, "情報交換有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getNyuuinkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "入院給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getSyujyutukyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "手術給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getSyougaikyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "障害給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getKoudosyougaiumukbn(),
            C_BlnktkumuKbn.ARI, "高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getPmenumukbn(),
            C_BlnktkumuKbn.ARI, "Ｐ免有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getTorikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "取消解除有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getSoukikeakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "早期ケア給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getSonotakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "その他給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getKghsjjtkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "介護保障充実給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getHuho2mrumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getHuho2decumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getHuho2kdumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getHuho2torikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ取消解除有無区分");


        List<BzHokenkinSueokiFSakuinKekkaBean> hokenkinSueokFLst = bzSakuinTsnSyoukaiKekkaBean
            .getBzhokenkinsueokifsakuinkekkabeanlist();
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getBzhokenkinsueokifsakuinkekkabeanlist().size(), 10,
            "保険金据置Ｆ索引結果Beanリストのサイズ");

        exStringEquals(hokenkinSueokFLst.get(0).getSueokifsysyno(), "11807111174", "（据置Ｆ）証書番号");

        exClassificationEquals(hokenkinSueokFLst.get(0).getSueokifhknkinkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（据置Ｆ）保険金据置関係者区分");

        exStringEquals(hokenkinSueokFLst.get(0).getSueokifhknkinkojinkbn(),
            "01", "（据置Ｆ）保険金据置Ｆ個人区分");

        exClassificationEquals(hokenkinSueokFLst.get(0).getSueokifsueokijtkbn(),
            C_SueokiJyoutaiKbn.MANRYOU, "（据置Ｆ）据置状態区分");
        exDateEquals(hokenkinSueokFLst.get(0).getSueokifsueokikaisiymd(), BizDate.valueOf("20000327"), "（据置Ｆ）据置開始日");
        exNumericEquals(hokenkinSueokFLst.get(0).getSueokifsueokikkn(), 12, "（据置Ｆ）据置期間");
        exDateEquals(hokenkinSueokFLst.get(0).getSueokifuktseiymd(), BizDate.valueOf("19900127"), "（据置Ｆ）受取人生年月日");

        exStringEquals(hokenkinSueokFLst.get(1).getSueokifsysyno(), "11807111174", "（据置Ｆ）証書番号");

        exClassificationEquals(hokenkinSueokFLst.get(1).getSueokifhknkinkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（据置Ｆ）保険金据置関係者区分");

        exStringEquals(hokenkinSueokFLst.get(1).getSueokifhknkinkojinkbn(),
            "01", "（据置Ｆ）保険金据置Ｆ個人区分");

        exClassificationEquals(hokenkinSueokFLst.get(1).getSueokifsueokijtkbn(),
            C_SueokiJyoutaiKbn.MANRYOU, "（据置Ｆ）据置状態区分");
        exDateEquals(hokenkinSueokFLst.get(1).getSueokifsueokikaisiymd(), BizDate.valueOf("20010327"), "（据置Ｆ）据置開始日");
        exNumericEquals(hokenkinSueokFLst.get(1).getSueokifsueokikkn(), 12, "（据置Ｆ）据置期間");
        exDateEquals(hokenkinSueokFLst.get(1).getSueokifuktseiymd(), BizDate.valueOf("19910127"), "（据置Ｆ）受取人生年月日");

        exStringEquals(hokenkinSueokFLst.get(2).getSueokifsysyno(), "11807111174", "（据置Ｆ）証書番号");

        exClassificationEquals(hokenkinSueokFLst.get(2).getSueokifhknkinkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（据置Ｆ）保険金据置関係者区分");

        exStringEquals(hokenkinSueokFLst.get(2).getSueokifhknkinkojinkbn(),
            "01", "（据置Ｆ）保険金据置Ｆ個人区分");

        exClassificationEquals(hokenkinSueokFLst.get(2).getSueokifsueokijtkbn(),
            C_SueokiJyoutaiKbn.MANRYOU, "（据置Ｆ）据置状態区分");
        exDateEquals(hokenkinSueokFLst.get(2).getSueokifsueokikaisiymd(), BizDate.valueOf("20020327"), "（据置Ｆ）据置開始日");
        exNumericEquals(hokenkinSueokFLst.get(2).getSueokifsueokikkn(), 12, "（据置Ｆ）据置期間");
        exDateEquals(hokenkinSueokFLst.get(2).getSueokifuktseiymd(), BizDate.valueOf("19920127"), "（据置Ｆ）受取人生年月日");

        exStringEquals(hokenkinSueokFLst.get(3).getSueokifsysyno(), "11807111174", "（据置Ｆ）証書番号");

        exClassificationEquals(hokenkinSueokFLst.get(3).getSueokifhknkinkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（据置Ｆ）保険金据置関係者区分");

        exStringEquals(hokenkinSueokFLst.get(3).getSueokifhknkinkojinkbn(),
            "01", "（据置Ｆ）保険金据置Ｆ個人区分");

        exClassificationEquals(hokenkinSueokFLst.get(3).getSueokifsueokijtkbn(),
            C_SueokiJyoutaiKbn.MANRYOU, "（据置Ｆ）据置状態区分");
        exDateEquals(hokenkinSueokFLst.get(3).getSueokifsueokikaisiymd(), BizDate.valueOf("20030327"), "（据置Ｆ）据置開始日");
        exNumericEquals(hokenkinSueokFLst.get(3).getSueokifsueokikkn(), 12, "（据置Ｆ）据置期間");
        exDateEquals(hokenkinSueokFLst.get(3).getSueokifuktseiymd(), BizDate.valueOf("19930127"), "（据置Ｆ）受取人生年月日");

        exStringEquals(hokenkinSueokFLst.get(4).getSueokifsysyno(), "11807111174", "（据置Ｆ）証書番号");

        exClassificationEquals(hokenkinSueokFLst.get(4).getSueokifhknkinkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（据置Ｆ）保険金据置関係者区分");

        exStringEquals(hokenkinSueokFLst.get(4).getSueokifhknkinkojinkbn(),
            "01", "（据置Ｆ）保険金据置Ｆ個人区分");

        exClassificationEquals(hokenkinSueokFLst.get(4).getSueokifsueokijtkbn(),
            C_SueokiJyoutaiKbn.MANRYOU, "（据置Ｆ）据置状態区分");
        exDateEquals(hokenkinSueokFLst.get(4).getSueokifsueokikaisiymd(), BizDate.valueOf("20040327"), "（据置Ｆ）据置開始日");
        exNumericEquals(hokenkinSueokFLst.get(4).getSueokifsueokikkn(), 12, "（据置Ｆ）据置期間");
        exDateEquals(hokenkinSueokFLst.get(4).getSueokifuktseiymd(), BizDate.valueOf("19940127"), "（据置Ｆ）受取人生年月日");

        exStringEquals(hokenkinSueokFLst.get(5).getSueokifsysyno(), "11807111174", "（据置Ｆ）証書番号");

        exClassificationEquals(hokenkinSueokFLst.get(5).getSueokifhknkinkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（据置Ｆ）保険金据置関係者区分");

        exStringEquals(hokenkinSueokFLst.get(5).getSueokifhknkinkojinkbn(),
            "01", "（据置Ｆ）保険金据置Ｆ個人区分");

        exClassificationEquals(hokenkinSueokFLst.get(5).getSueokifsueokijtkbn(),
            C_SueokiJyoutaiKbn.MANRYOU, "（据置Ｆ）据置状態区分");
        exDateEquals(hokenkinSueokFLst.get(5).getSueokifsueokikaisiymd(), BizDate.valueOf("20050327"), "（据置Ｆ）据置開始日");
        exNumericEquals(hokenkinSueokFLst.get(5).getSueokifsueokikkn(), 12, "（据置Ｆ）据置期間");
        exDateEquals(hokenkinSueokFLst.get(5).getSueokifuktseiymd(), BizDate.valueOf("19950127"), "（据置Ｆ）受取人生年月日");

        exStringEquals(hokenkinSueokFLst.get(6).getSueokifsysyno(), "11807111174", "（据置Ｆ）証書番号");

        exClassificationEquals(hokenkinSueokFLst.get(6).getSueokifhknkinkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（据置Ｆ）保険金据置関係者区分");

        exStringEquals(hokenkinSueokFLst.get(6).getSueokifhknkinkojinkbn(),
            "01", "（据置Ｆ）保険金据置Ｆ個人区分");

        exClassificationEquals(hokenkinSueokFLst.get(6).getSueokifsueokijtkbn(),
            C_SueokiJyoutaiKbn.MANRYOU, "（据置Ｆ）据置状態区分");
        exDateEquals(hokenkinSueokFLst.get(6).getSueokifsueokikaisiymd(), BizDate.valueOf("20060327"), "（据置Ｆ）据置開始日");
        exNumericEquals(hokenkinSueokFLst.get(6).getSueokifsueokikkn(), 12, "（据置Ｆ）据置期間");
        exDateEquals(hokenkinSueokFLst.get(6).getSueokifuktseiymd(), BizDate.valueOf("19960127"), "（据置Ｆ）受取人生年月日");

        exStringEquals(hokenkinSueokFLst.get(7).getSueokifsysyno(), "11807111174", "（据置Ｆ）証書番号");

        exClassificationEquals(hokenkinSueokFLst.get(7).getSueokifhknkinkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（据置Ｆ）保険金据置関係者区分");

        exStringEquals(hokenkinSueokFLst.get(7).getSueokifhknkinkojinkbn(),
            "01", "（据置Ｆ）保険金据置Ｆ個人区分");

        exClassificationEquals(hokenkinSueokFLst.get(7).getSueokifsueokijtkbn(),
            C_SueokiJyoutaiKbn.MANRYOU, "（据置Ｆ）据置状態区分");
        exDateEquals(hokenkinSueokFLst.get(7).getSueokifsueokikaisiymd(), BizDate.valueOf("20070327"), "（据置Ｆ）据置開始日");
        exNumericEquals(hokenkinSueokFLst.get(7).getSueokifsueokikkn(), 12, "（据置Ｆ）据置期間");
        exDateEquals(hokenkinSueokFLst.get(7).getSueokifuktseiymd(), BizDate.valueOf("19970127"), "（据置Ｆ）受取人生年月日");

        exStringEquals(hokenkinSueokFLst.get(8).getSueokifsysyno(), "11807111174", "（据置Ｆ）証書番号");

        exClassificationEquals(hokenkinSueokFLst.get(8).getSueokifhknkinkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（据置Ｆ）保険金据置関係者区分");

        exStringEquals(hokenkinSueokFLst.get(8).getSueokifhknkinkojinkbn(),
            "01", "（据置Ｆ）保険金据置Ｆ個人区分");

        exClassificationEquals(hokenkinSueokFLst.get(8).getSueokifsueokijtkbn(),
            C_SueokiJyoutaiKbn.MANRYOU, "（据置Ｆ）据置状態区分");
        exDateEquals(hokenkinSueokFLst.get(8).getSueokifsueokikaisiymd(), BizDate.valueOf("20080327"), "（据置Ｆ）据置開始日");
        exNumericEquals(hokenkinSueokFLst.get(8).getSueokifsueokikkn(), 12, "（据置Ｆ）据置期間");
        exDateEquals(hokenkinSueokFLst.get(8).getSueokifuktseiymd(), BizDate.valueOf("19980127"), "（据置Ｆ）受取人生年月日");

        exStringEquals(hokenkinSueokFLst.get(9).getSueokifsysyno(), "11807111174", "（据置Ｆ）証書番号");

        exClassificationEquals(hokenkinSueokFLst.get(9).getSueokifhknkinkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（据置Ｆ）保険金据置関係者区分");

        exStringEquals(hokenkinSueokFLst.get(9).getSueokifhknkinkojinkbn(),
            "01", "（据置Ｆ）保険金据置Ｆ個人区分");

        exClassificationEquals(hokenkinSueokFLst.get(9).getSueokifsueokijtkbn(),
            C_SueokiJyoutaiKbn.MANRYOU, "（据置Ｆ）据置状態区分");
        exDateEquals(hokenkinSueokFLst.get(9).getSueokifsueokikaisiymd(), BizDate.valueOf("20090327"), "（据置Ｆ）据置開始日");
        exNumericEquals(hokenkinSueokFLst.get(9).getSueokifsueokikkn(), 12, "（据置Ｆ）据置期間");
        exDateEquals(hokenkinSueokFLst.get(9).getSueokifuktseiymd(), BizDate.valueOf("19990127"), "（据置Ｆ）受取人生年月日");


        List<BzSougouNenkinSiharaiFSakuinKekkaBean> sougouNenkinSiharaiFSakuinKekkaLst =
            bzSakuinTsnSyoukaiKekkaBean.getBzsougounenkinsiharaifsakuinkekkabeanlist();
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getBzsougounenkinsiharaifsakuinkekkabeanlist().size(),
            10, "総合年金支払Ｆ索引結果Beanリストのサイズ");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(0).getSounenfnksysyno(), "11807111211", "（総年Ｆ）年金証書番号");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(0).getSounenfnkkankeisyakbn(),
            C_NkKankeisyaKbn.NKUKT, "（総年Ｆ）年金支払関係者区分");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(0).getSounenfsougounkfkojinkbn(), "04",
            "（総年Ｆ）総合年金支払Ｆ個人区分");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(0).getSounenfkykjyoutaikbn(),
            C_SounenfKykJyoutaiKbn.SYOUMETU_SIBOU, "（総年Ｆ）契約状態区分");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(0).getSounenfsyokainkshrymd(),
            BizDate.valueOf("20021220"), "（総年Ｆ）初回年金支払日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(0).getSounenfkykymd(),
            BizDate.valueOf("20021120"), "（総年Ｆ）契約日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(0).getSounenfnksyoumetucd(),
            "11", "（総年Ｆ）年金消滅コード");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(0).getSounenfsyoumetuymd(),
            BizDate.valueOf("20010410"), "（総年Ｆ）消滅日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(0).getSounenftaisyouseiymd(),
            BizDate.valueOf("19940610"), "（総年Ｆ）対象者生年月日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(1).getSounenfnksysyno(), "11807111211", "（総年Ｆ）年金証書番号");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(1).getSounenfnkkankeisyakbn(),
            C_NkKankeisyaKbn.NKUKT, "（総年Ｆ）年金支払関係者区分");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(1).getSounenfsougounkfkojinkbn(), "04",
            "（総年Ｆ）総合年金支払Ｆ個人区分");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(1).getSounenfkykjyoutaikbn(),
            C_SounenfKykJyoutaiKbn.SYOUMETU_SIBOU, "（総年Ｆ）契約状態区分");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(1).getSounenfsyokainkshrymd(),
            BizDate.valueOf("20021221"), "（総年Ｆ）初回年金支払日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(1).getSounenfkykymd(),
            BizDate.valueOf("20021121"), "（総年Ｆ）契約日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(1).getSounenfnksyoumetucd(),
            "11", "（総年Ｆ）年金消滅コード");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(1).getSounenfsyoumetuymd(),
            BizDate.valueOf("20010411"), "（総年Ｆ）消滅日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(1).getSounenftaisyouseiymd(),
            BizDate.valueOf("19940611"), "（総年Ｆ）対象者生年月日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(2).getSounenfnksysyno(), "11807111211", "（総年Ｆ）年金証書番号");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(2).getSounenfnkkankeisyakbn(),
            C_NkKankeisyaKbn.NKUKT, "（総年Ｆ）年金支払関係者区分");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(2).getSounenfsougounkfkojinkbn(), "04",
            "（総年Ｆ）総合年金支払Ｆ個人区分");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(2).getSounenfkykjyoutaikbn(),
            C_SounenfKykJyoutaiKbn.SYOUMETU_SIBOU, "（総年Ｆ）契約状態区分");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(2).getSounenfsyokainkshrymd(),
            BizDate.valueOf("20021222"), "（総年Ｆ）初回年金支払日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(2).getSounenfkykymd(),
            BizDate.valueOf("20021122"), "（総年Ｆ）契約日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(2).getSounenfnksyoumetucd(),
            "11", "（総年Ｆ）年金消滅コード");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(2).getSounenfsyoumetuymd(),
            BizDate.valueOf("20010412"), "（総年Ｆ）消滅日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(2).getSounenftaisyouseiymd(),
            BizDate.valueOf("19940612"), "（総年Ｆ）対象者生年月日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(3).getSounenfnksysyno(), "11807111211", "（総年Ｆ）年金証書番号");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(3).getSounenfnkkankeisyakbn(),
            C_NkKankeisyaKbn.NKUKT, "（総年Ｆ）年金支払関係者区分");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(3).getSounenfsougounkfkojinkbn(), "04",
            "（総年Ｆ）総合年金支払Ｆ個人区分");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(3).getSounenfkykjyoutaikbn(),
            C_SounenfKykJyoutaiKbn.SYOUMETU_SIBOU, "（総年Ｆ）契約状態区分");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(3).getSounenfsyokainkshrymd(),
            BizDate.valueOf("20021223"), "（総年Ｆ）初回年金支払日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(3).getSounenfkykymd(),
            BizDate.valueOf("20021123"), "（総年Ｆ）契約日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(3).getSounenfnksyoumetucd(),
            "11", "（総年Ｆ）年金消滅コード");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(3).getSounenfsyoumetuymd(),
            BizDate.valueOf("20010413"), "（総年Ｆ）消滅日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(3).getSounenftaisyouseiymd(),
            BizDate.valueOf("19940613"), "（総年Ｆ）対象者生年月日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(4).getSounenfnksysyno(), "11807111211", "（総年Ｆ）年金証書番号");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(4).getSounenfnkkankeisyakbn(),
            C_NkKankeisyaKbn.NKUKT, "（総年Ｆ）年金支払関係者区分");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(4).getSounenfsougounkfkojinkbn(), "04",
            "（総年Ｆ）総合年金支払Ｆ個人区分");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(4).getSounenfkykjyoutaikbn(),
            C_SounenfKykJyoutaiKbn.SYOUMETU_SIBOU, "（総年Ｆ）契約状態区分");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(4).getSounenfsyokainkshrymd(),
            BizDate.valueOf("20021224"), "（総年Ｆ）初回年金支払日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(4).getSounenfkykymd(),
            BizDate.valueOf("20021124"), "（総年Ｆ）契約日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(4).getSounenfnksyoumetucd(),
            "11", "（総年Ｆ）年金消滅コード");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(4).getSounenfsyoumetuymd(),
            BizDate.valueOf("20010414"), "（総年Ｆ）消滅日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(4).getSounenftaisyouseiymd(),
            BizDate.valueOf("19940614"), "（総年Ｆ）対象者生年月日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(5).getSounenfnksysyno(), "11807111211", "（総年Ｆ）年金証書番号");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(5).getSounenfnkkankeisyakbn(),
            C_NkKankeisyaKbn.NKUKT, "（総年Ｆ）年金支払関係者区分");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(5).getSounenfsougounkfkojinkbn(), "04",
            "（総年Ｆ）総合年金支払Ｆ個人区分");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(5).getSounenfkykjyoutaikbn(),
            C_SounenfKykJyoutaiKbn.SYOUMETU_SIBOU, "（総年Ｆ）契約状態区分");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(5).getSounenfsyokainkshrymd(),
            BizDate.valueOf("20021225"), "（総年Ｆ）初回年金支払日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(5).getSounenfkykymd(),
            BizDate.valueOf("20021125"), "（総年Ｆ）契約日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(5).getSounenfnksyoumetucd(),
            "11", "（総年Ｆ）年金消滅コード");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(5).getSounenfsyoumetuymd(),
            BizDate.valueOf("20010415"), "（総年Ｆ）消滅日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(5).getSounenftaisyouseiymd(),
            BizDate.valueOf("19940615"), "（総年Ｆ）対象者生年月日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(6).getSounenfnksysyno(), "11807111211", "（総年Ｆ）年金証書番号");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(6).getSounenfnkkankeisyakbn(),
            C_NkKankeisyaKbn.NKUKT, "（総年Ｆ）年金支払関係者区分");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(6).getSounenfsougounkfkojinkbn(), "04",
            "（総年Ｆ）総合年金支払Ｆ個人区分");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(6).getSounenfkykjyoutaikbn(),
            C_SounenfKykJyoutaiKbn.SYOUMETU_SIBOU, "（総年Ｆ）契約状態区分");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(6).getSounenfsyokainkshrymd(),
            BizDate.valueOf("20021226"), "（総年Ｆ）初回年金支払日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(6).getSounenfkykymd(),
            BizDate.valueOf("20021126"), "（総年Ｆ）契約日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(6).getSounenfnksyoumetucd(),
            "11", "（総年Ｆ）年金消滅コード");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(6).getSounenfsyoumetuymd(),
            BizDate.valueOf("20010416"), "（総年Ｆ）消滅日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(6).getSounenftaisyouseiymd(),
            BizDate.valueOf("19940616"), "（総年Ｆ）対象者生年月日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(7).getSounenfnksysyno(), "11807111211", "（総年Ｆ）年金証書番号");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(7).getSounenfnkkankeisyakbn(),
            C_NkKankeisyaKbn.NKUKT, "（総年Ｆ）年金支払関係者区分");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(7).getSounenfsougounkfkojinkbn(), "04",
            "（総年Ｆ）総合年金支払Ｆ個人区分");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(7).getSounenfkykjyoutaikbn(),
            C_SounenfKykJyoutaiKbn.SYOUMETU_SIBOU, "（総年Ｆ）契約状態区分");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(7).getSounenfsyokainkshrymd(),
            BizDate.valueOf("20021227"), "（総年Ｆ）初回年金支払日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(7).getSounenfkykymd(),
            BizDate.valueOf("20021127"), "（総年Ｆ）契約日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(7).getSounenfnksyoumetucd(),
            "11", "（総年Ｆ）年金消滅コード");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(7).getSounenfsyoumetuymd(),
            BizDate.valueOf("20010417"), "（総年Ｆ）消滅日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(7).getSounenftaisyouseiymd(),
            BizDate.valueOf("19940617"), "（総年Ｆ）対象者生年月日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(8).getSounenfnksysyno(), "11807111211", "（総年Ｆ）年金証書番号");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(8).getSounenfnkkankeisyakbn(),
            C_NkKankeisyaKbn.NKUKT, "（総年Ｆ）年金支払関係者区分");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(8).getSounenfsougounkfkojinkbn(), "04",
            "（総年Ｆ）総合年金支払Ｆ個人区分");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(8).getSounenfkykjyoutaikbn(),
            C_SounenfKykJyoutaiKbn.SYOUMETU_SIBOU, "（総年Ｆ）契約状態区分");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(8).getSounenfsyokainkshrymd(),
            BizDate.valueOf("20021228"), "（総年Ｆ）初回年金支払日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(8).getSounenfkykymd(),
            BizDate.valueOf("20021128"), "（総年Ｆ）契約日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(8).getSounenfnksyoumetucd(),
            "11", "（総年Ｆ）年金消滅コード");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(8).getSounenfsyoumetuymd(),
            BizDate.valueOf("20010418"), "（総年Ｆ）消滅日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(8).getSounenftaisyouseiymd(),
            BizDate.valueOf("19940618"), "（総年Ｆ）対象者生年月日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(9).getSounenfnksysyno(), "11807111211", "（総年Ｆ）年金証書番号");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(9).getSounenfnkkankeisyakbn(),
            C_NkKankeisyaKbn.NKUKT, "（総年Ｆ）年金支払関係者区分");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(9).getSounenfsougounkfkojinkbn(), "04",
            "（総年Ｆ）総合年金支払Ｆ個人区分");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(9).getSounenfkykjyoutaikbn(),
            C_SounenfKykJyoutaiKbn.SYOUMETU_SIBOU, "（総年Ｆ）契約状態区分");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(9).getSounenfsyokainkshrymd(),
            BizDate.valueOf("20021229"), "（総年Ｆ）初回年金支払日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(9).getSounenfkykymd(),
            BizDate.valueOf("20021129"), "（総年Ｆ）契約日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(9).getSounenfnksyoumetucd(),
            "11", "（総年Ｆ）年金消滅コード");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(9).getSounenfsyoumetuymd(),
            BizDate.valueOf("20010419"), "（総年Ｆ）消滅日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(9).getSounenftaisyouseiymd(),
            BizDate.valueOf("19940619"), "（総年Ｆ）対象者生年月日");


        List<BzKeiyakuHozenSakuinKekkaBean> keiyakuHozenSakuinKekkaLst =
            bzSakuinTsnSyoukaiKekkaBean.getBzkeiyakuhozensakuinkekkabeanlist();
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getBzkeiyakuhozensakuinkekkabeanlist().size(),
            10, "契約保全索引結果Beanリストのサイズ");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(0).getKhsyono(), "11807111163", "（契約保全）証券番号");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(0).getKhkykkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（契約保全）契約関係者区分");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(0).getKhkykfkojinkbn(),
            "05", "（契約保全）契約Ｆ個人区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(0).getKhyuukousyoumetukbn(),
            C_YuukousyoumetuKbn.SYOUMETU, "（契約保全）有効消滅区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(0).getKhkykjyoutai(),
            C_Kykjyoutai.ITIJIBARAI, "（契約保全）契約状態");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(0).getKhkykymd(),
            BizDate.valueOf("20031010"), "（契約保全）契約日");
        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(0).getKhsyoumetujiyuu(),
            C_Syoumetujiyuu.CLGOFF, "（契約保全）消滅事由");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(0).getKhsyoumetuymd(),
            BizDate.valueOf("20000401"), "（契約保全）消滅日");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(0).getKhsyouhncd(),
            "kh", "（契約保全）商品コード");

        exDateYMEquals(keiyakuHozenSakuinKekkaLst.get(0).getKhbosyuuym(),
            BizDateYM.valueOf("199008"), "（契約保全）募集年月");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(0).getKhtaisyouseiymd(),
            BizDate.valueOf("19890510"), "（契約保全）対象者生年月日");
        exNumericEquals(keiyakuHozenSakuinKekkaLst.get(0).getKhsyouhnsdno(), 10, "（契約保全）商品世代番号");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(1).getKhsyono(), "11807111163", "（契約保全）証券番号");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(1).getKhkykkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（契約保全）契約関係者区分");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(1).getKhkykfkojinkbn(),
            "05", "（契約保全）契約Ｆ個人区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(1).getKhyuukousyoumetukbn(),
            C_YuukousyoumetuKbn.SYOUMETU, "（契約保全）有効消滅区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(1).getKhkykjyoutai(),
            C_Kykjyoutai.ITIJIBARAI, "（契約保全）契約状態");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(1).getKhkykymd(),
            BizDate.valueOf("20031011"), "（契約保全）契約日");
        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(1).getKhsyoumetujiyuu(),
            C_Syoumetujiyuu.CLGOFF, "（契約保全）消滅事由");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(1).getKhsyoumetuymd(),
            BizDate.valueOf("20010401"), "（契約保全）消滅日");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(1).getKhsyouhncd(),
            "kh", "（契約保全）商品コード");

        exDateYMEquals(keiyakuHozenSakuinKekkaLst.get(1).getKhbosyuuym(),
            BizDateYM.valueOf("199108"), "（契約保全）募集年月");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(1).getKhtaisyouseiymd(),
            BizDate.valueOf("19890511"), "（契約保全）対象者生年月日");
        exNumericEquals(keiyakuHozenSakuinKekkaLst.get(1).getKhsyouhnsdno(), 11, "（契約保全）商品世代番号");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(2).getKhsyono(), "11807111163", "（契約保全）証券番号");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(2).getKhkykkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（契約保全）契約関係者区分");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(2).getKhkykfkojinkbn(),
            "05", "（契約保全）契約Ｆ個人区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(2).getKhyuukousyoumetukbn(),
            C_YuukousyoumetuKbn.SYOUMETU, "（契約保全）有効消滅区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(2).getKhkykjyoutai(),
            C_Kykjyoutai.ITIJIBARAI, "（契約保全）契約状態");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(2).getKhkykymd(),
            BizDate.valueOf("20031012"), "（契約保全）契約日");
        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(2).getKhsyoumetujiyuu(),
            C_Syoumetujiyuu.CLGOFF, "（契約保全）消滅事由");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(2).getKhsyoumetuymd(),
            BizDate.valueOf("20020401"), "（契約保全）消滅日");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(2).getKhsyouhncd(),
            "kh", "（契約保全）商品コード");

        exDateYMEquals(keiyakuHozenSakuinKekkaLst.get(2).getKhbosyuuym(),
            BizDateYM.valueOf("199208"), "（契約保全）募集年月");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(2).getKhtaisyouseiymd(),
            BizDate.valueOf("19890512"), "（契約保全）対象者生年月日");
        exNumericEquals(keiyakuHozenSakuinKekkaLst.get(2).getKhsyouhnsdno(), 12, "（契約保全）商品世代番号");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(3).getKhsyono(), "11807111163", "（契約保全）証券番号");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(3).getKhkykkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（契約保全）契約関係者区分");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(3).getKhkykfkojinkbn(),
            "05", "（契約保全）契約Ｆ個人区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(3).getKhyuukousyoumetukbn(),
            C_YuukousyoumetuKbn.SYOUMETU, "（契約保全）有効消滅区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(3).getKhkykjyoutai(),
            C_Kykjyoutai.ITIJIBARAI, "（契約保全）契約状態");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(3).getKhkykymd(),
            BizDate.valueOf("20031013"), "（契約保全）契約日");
        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(3).getKhsyoumetujiyuu(),
            C_Syoumetujiyuu.CLGOFF, "（契約保全）消滅事由");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(3).getKhsyoumetuymd(),
            BizDate.valueOf("20030401"), "（契約保全）消滅日");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(3).getKhsyouhncd(),
            "kh", "（契約保全）商品コード");

        exDateYMEquals(keiyakuHozenSakuinKekkaLst.get(3).getKhbosyuuym(),
            BizDateYM.valueOf("199308"), "（契約保全）募集年月");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(3).getKhtaisyouseiymd(),
            BizDate.valueOf("19890513"), "（契約保全）対象者生年月日");
        exNumericEquals(keiyakuHozenSakuinKekkaLst.get(3).getKhsyouhnsdno(), 13, "（契約保全）商品世代番号");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(4).getKhsyono(), "11807111163", "（契約保全）証券番号");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(4).getKhkykkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（契約保全）契約関係者区分");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(4).getKhkykfkojinkbn(),
            "05", "（契約保全）契約Ｆ個人区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(4).getKhyuukousyoumetukbn(),
            C_YuukousyoumetuKbn.SYOUMETU, "（契約保全）有効消滅区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(4).getKhkykjyoutai(),
            C_Kykjyoutai.ITIJIBARAI, "（契約保全）契約状態");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(4).getKhkykymd(),
            BizDate.valueOf("20031014"), "（契約保全）契約日");
        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(4).getKhsyoumetujiyuu(),
            C_Syoumetujiyuu.CLGOFF, "（契約保全）消滅事由");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(4).getKhsyoumetuymd(),
            BizDate.valueOf("20040401"), "（契約保全）消滅日");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(4).getKhsyouhncd(),
            "kh", "（契約保全）商品コード");

        exDateYMEquals(keiyakuHozenSakuinKekkaLst.get(4).getKhbosyuuym(),
            BizDateYM.valueOf("199408"), "（契約保全）募集年月");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(4).getKhtaisyouseiymd(),
            BizDate.valueOf("19890514"), "（契約保全）対象者生年月日");
        exNumericEquals(keiyakuHozenSakuinKekkaLst.get(4).getKhsyouhnsdno(), 14, "（契約保全）商品世代番号");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(5).getKhsyono(), "11807111163", "（契約保全）証券番号");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(5).getKhkykkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（契約保全）契約関係者区分");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(5).getKhkykfkojinkbn(),
            "05", "（契約保全）契約Ｆ個人区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(5).getKhyuukousyoumetukbn(),
            C_YuukousyoumetuKbn.SYOUMETU, "（契約保全）有効消滅区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(5).getKhkykjyoutai(),
            C_Kykjyoutai.ITIJIBARAI, "（契約保全）契約状態");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(5).getKhkykymd(),
            BizDate.valueOf("20031015"), "（契約保全）契約日");
        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(5).getKhsyoumetujiyuu(),
            C_Syoumetujiyuu.CLGOFF, "（契約保全）消滅事由");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(5).getKhsyoumetuymd(),
            BizDate.valueOf("20050401"), "（契約保全）消滅日");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(5).getKhsyouhncd(),
            "kh", "（契約保全）商品コード");

        exDateYMEquals(keiyakuHozenSakuinKekkaLst.get(5).getKhbosyuuym(),
            BizDateYM.valueOf("199508"), "（契約保全）募集年月");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(5).getKhtaisyouseiymd(),
            BizDate.valueOf("19890515"), "（契約保全）対象者生年月日");
        exNumericEquals(keiyakuHozenSakuinKekkaLst.get(5).getKhsyouhnsdno(), 15, "（契約保全）商品世代番号");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(6).getKhsyono(), "11807111163", "（契約保全）証券番号");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(6).getKhkykkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（契約保全）契約関係者区分");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(6).getKhkykfkojinkbn(),
            "05", "（契約保全）契約Ｆ個人区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(6).getKhyuukousyoumetukbn(),
            C_YuukousyoumetuKbn.SYOUMETU, "（契約保全）有効消滅区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(6).getKhkykjyoutai(),
            C_Kykjyoutai.ITIJIBARAI, "（契約保全）契約状態");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(6).getKhkykymd(),
            BizDate.valueOf("20031016"), "（契約保全）契約日");
        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(6).getKhsyoumetujiyuu(),
            C_Syoumetujiyuu.CLGOFF, "（契約保全）消滅事由");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(6).getKhsyoumetuymd(),
            BizDate.valueOf("20060401"), "（契約保全）消滅日");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(6).getKhsyouhncd(),
            "kh", "（契約保全）商品コード");

        exDateYMEquals(keiyakuHozenSakuinKekkaLst.get(6).getKhbosyuuym(),
            BizDateYM.valueOf("199608"), "（契約保全）募集年月");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(6).getKhtaisyouseiymd(),
            BizDate.valueOf("19890516"), "（契約保全）対象者生年月日");
        exNumericEquals(keiyakuHozenSakuinKekkaLst.get(6).getKhsyouhnsdno(), 16, "（契約保全）商品世代番号");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(7).getKhsyono(), "11807111163", "（契約保全）証券番号");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(7).getKhkykkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（契約保全）契約関係者区分");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(7).getKhkykfkojinkbn(),
            "05", "（契約保全）契約Ｆ個人区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(7).getKhyuukousyoumetukbn(),
            C_YuukousyoumetuKbn.SYOUMETU, "（契約保全）有効消滅区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(7).getKhkykjyoutai(),
            C_Kykjyoutai.ITIJIBARAI, "（契約保全）契約状態");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(7).getKhkykymd(),
            BizDate.valueOf("20031017"), "（契約保全）契約日");
        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(7).getKhsyoumetujiyuu(),
            C_Syoumetujiyuu.CLGOFF, "（契約保全）消滅事由");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(7).getKhsyoumetuymd(),
            BizDate.valueOf("20070401"), "（契約保全）消滅日");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(7).getKhsyouhncd(),
            "kh", "（契約保全）商品コード");

        exDateYMEquals(keiyakuHozenSakuinKekkaLst.get(7).getKhbosyuuym(),
            BizDateYM.valueOf("199708"), "（契約保全）募集年月");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(7).getKhtaisyouseiymd(),
            BizDate.valueOf("19890517"), "（契約保全）対象者生年月日");
        exNumericEquals(keiyakuHozenSakuinKekkaLst.get(7).getKhsyouhnsdno(), 17, "（契約保全）商品世代番号");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(8).getKhsyono(), "11807111163", "（契約保全）証券番号");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(8).getKhkykkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（契約保全）契約関係者区分");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(8).getKhkykfkojinkbn(),
            "05", "（契約保全）契約Ｆ個人区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(8).getKhyuukousyoumetukbn(),
            C_YuukousyoumetuKbn.SYOUMETU, "（契約保全）有効消滅区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(8).getKhkykjyoutai(),
            C_Kykjyoutai.ITIJIBARAI, "（契約保全）契約状態");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(8).getKhkykymd(),
            BizDate.valueOf("20031018"), "（契約保全）契約日");
        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(8).getKhsyoumetujiyuu(),
            C_Syoumetujiyuu.CLGOFF, "（契約保全）消滅事由");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(8).getKhsyoumetuymd(),
            BizDate.valueOf("20080401"), "（契約保全）消滅日");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(8).getKhsyouhncd(),
            "kh", "（契約保全）商品コード");

        exDateYMEquals(keiyakuHozenSakuinKekkaLst.get(8).getKhbosyuuym(),
            BizDateYM.valueOf("199808"), "（契約保全）募集年月");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(8).getKhtaisyouseiymd(),
            BizDate.valueOf("19890518"), "（契約保全）対象者生年月日");
        exNumericEquals(keiyakuHozenSakuinKekkaLst.get(8).getKhsyouhnsdno(), 18, "（契約保全）商品世代番号");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(9).getKhsyono(), "11807111163", "（契約保全）証券番号");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(9).getKhkykkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（契約保全）契約関係者区分");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(9).getKhkykfkojinkbn(),
            "05", "（契約保全）契約Ｆ個人区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(9).getKhyuukousyoumetukbn(),
            C_YuukousyoumetuKbn.SYOUMETU, "（契約保全）有効消滅区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(9).getKhkykjyoutai(),
            C_Kykjyoutai.ITIJIBARAI, "（契約保全）契約状態");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(9).getKhkykymd(),
            BizDate.valueOf("20031019"), "（契約保全）契約日");
        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(9).getKhsyoumetujiyuu(),
            C_Syoumetujiyuu.CLGOFF, "（契約保全）消滅事由");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(9).getKhsyoumetuymd(),
            BizDate.valueOf("20090401"), "（契約保全）消滅日");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(9).getKhsyouhncd(),
            "kh", "（契約保全）商品コード");

        exDateYMEquals(keiyakuHozenSakuinKekkaLst.get(9).getKhbosyuuym(),
            BizDateYM.valueOf("199908"), "（契約保全）募集年月");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(9).getKhtaisyouseiymd(),
            BizDate.valueOf("19890519"), "（契約保全）対象者生年月日");
        exNumericEquals(keiyakuHozenSakuinKekkaLst.get(9).getKhsyouhnsdno(), 19, "（契約保全）商品世代番号");


        List<BzSinkeiyakuSakuinKekkaBean> sinkeiyakuSakuinKekkaLst =
            bzSakuinTsnSyoukaiKekkaBean.getBzsinkeiyakusakuinkekkabeanlist();
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getBzsinkeiyakusakuinkekkabeanlist().size(),
            10, "新契約索引結果Beanリストのサイズ");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(0).getSkmosno(), "791112402", "（新契約）申込番号");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(0).getSkmoskankeisyakbn(),
            C_KankeisyaKbn.KYK, "（新契約）申込関係者区分");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(0).getSkmosfkojinkbn(), "03", "（新契約）申込Ｆ個人区分");
        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(0).getSkmfrenflg(),
            C_Mfrenflg.SUMI, "（新契約）ＭＦ連動済フラグ");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(0).getSkmosymd(),
            BizDate.valueOf("19900509"), "（新契約）申込日");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(0).getSkkykymd(),
            BizDate.valueOf("19970610"), "（新契約）契約日");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(0).getSkseiritukbn(),
            C_SeirituKbn.SEIRITU, "（新契約）成立区分");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(0).getSksrsyoriymd(),
            BizDate.valueOf("19971010"), "（新契約）成立処理日");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(0).getSksyouhncd(), "sk", "（新契約）商品コード");

        exDateYMEquals(sinkeiyakuSakuinKekkaLst.get(0).getSkbosyuuym(),
            BizDateYM.valueOf("199009"), "（新契約）募集年月");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(0).getSktaisyounayosejtkbn(),
            C_NayoseJyoutaiKbn.NAYOSEHUMEI, "（新契約）対象者名寄せ状態区分");
        exStringEquals(sinkeiyakuSakuinKekkaLst.get(0).getSktaisyousakuinnmno(), "0000000030", "（新契約）対象者索引名番号");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(0).getSktaisyouseiymd(),
            BizDate.valueOf("19881110"), "（新契約）対象者生年月日");
        exNumericEquals(sinkeiyakuSakuinKekkaLst.get(0).getSksyouhnsdno(), 20, "（新契約）商品世代番号");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(1).getSkmosno(), "791112402", "（新契約）申込番号");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(1).getSkmoskankeisyakbn(),
            C_KankeisyaKbn.KYK, "（新契約）申込関係者区分");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(1).getSkmosfkojinkbn(), "03", "（新契約）申込Ｆ個人区分");
        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(1).getSkmfrenflg(),
            C_Mfrenflg.SUMI, "（新契約）ＭＦ連動済フラグ");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(1).getSkmosymd(),
            BizDate.valueOf("19910509"), "（新契約）申込日");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(1).getSkkykymd(),
            BizDate.valueOf("19970611"), "（新契約）契約日");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(1).getSkseiritukbn(),
            C_SeirituKbn.SEIRITU, "（新契約）成立区分");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(1).getSksrsyoriymd(),
            BizDate.valueOf("19971011"), "（新契約）成立処理日");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(1).getSksyouhncd(), "sk", "（新契約）商品コード");

        exDateYMEquals(sinkeiyakuSakuinKekkaLst.get(1).getSkbosyuuym(),
            BizDateYM.valueOf("199109"), "（新契約）募集年月");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(1).getSktaisyounayosejtkbn(),
            C_NayoseJyoutaiKbn.NAYOSEHUMEI, "（新契約）対象者名寄せ状態区分");
        exStringEquals(sinkeiyakuSakuinKekkaLst.get(1).getSktaisyousakuinnmno(), "0000000031", "（新契約）対象者索引名番号");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(1).getSktaisyouseiymd(),
            BizDate.valueOf("19881111"), "（新契約）対象者生年月日");
        exNumericEquals(sinkeiyakuSakuinKekkaLst.get(1).getSksyouhnsdno(), 21, "（新契約）商品世代番号");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(2).getSkmosno(), "791112402", "（新契約）申込番号");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(2).getSkmoskankeisyakbn(),
            C_KankeisyaKbn.KYK, "（新契約）申込関係者区分");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(2).getSkmosfkojinkbn(), "03", "（新契約）申込Ｆ個人区分");
        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(2).getSkmfrenflg(),
            C_Mfrenflg.SUMI, "（新契約）ＭＦ連動済フラグ");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(2).getSkmosymd(),
            BizDate.valueOf("19920509"), "（新契約）申込日");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(2).getSkkykymd(),
            BizDate.valueOf("19970612"), "（新契約）契約日");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(2).getSkseiritukbn(),
            C_SeirituKbn.SEIRITU, "（新契約）成立区分");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(2).getSksrsyoriymd(),
            BizDate.valueOf("19971012"), "（新契約）成立処理日");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(2).getSksyouhncd(), "sk", "（新契約）商品コード");

        exDateYMEquals(sinkeiyakuSakuinKekkaLst.get(2).getSkbosyuuym(),
            BizDateYM.valueOf("199209"), "（新契約）募集年月");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(2).getSktaisyounayosejtkbn(),
            C_NayoseJyoutaiKbn.NAYOSEHUMEI, "（新契約）対象者名寄せ状態区分");
        exStringEquals(sinkeiyakuSakuinKekkaLst.get(2).getSktaisyousakuinnmno(), "0000000032", "（新契約）対象者索引名番号");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(2).getSktaisyouseiymd(),
            BizDate.valueOf("19881112"), "（新契約）対象者生年月日");
        exNumericEquals(sinkeiyakuSakuinKekkaLst.get(2).getSksyouhnsdno(), 22, "（新契約）商品世代番号");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(3).getSkmosno(), "791112402", "（新契約）申込番号");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(3).getSkmoskankeisyakbn(),
            C_KankeisyaKbn.KYK, "（新契約）申込関係者区分");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(3).getSkmosfkojinkbn(), "03", "（新契約）申込Ｆ個人区分");
        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(3).getSkmfrenflg(),
            C_Mfrenflg.SUMI, "（新契約）ＭＦ連動済フラグ");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(3).getSkmosymd(),
            BizDate.valueOf("19930509"), "（新契約）申込日");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(3).getSkkykymd(),
            BizDate.valueOf("19970613"), "（新契約）契約日");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(3).getSkseiritukbn(),
            C_SeirituKbn.SEIRITU, "（新契約）成立区分");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(3).getSksrsyoriymd(),
            BizDate.valueOf("19971013"), "（新契約）成立処理日");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(3).getSksyouhncd(), "sk", "（新契約）商品コード");

        exDateYMEquals(sinkeiyakuSakuinKekkaLst.get(3).getSkbosyuuym(),
            BizDateYM.valueOf("199309"), "（新契約）募集年月");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(3).getSktaisyounayosejtkbn(),
            C_NayoseJyoutaiKbn.NAYOSEHUMEI, "（新契約）対象者名寄せ状態区分");
        exStringEquals(sinkeiyakuSakuinKekkaLst.get(3).getSktaisyousakuinnmno(), "0000000033", "（新契約）対象者索引名番号");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(3).getSktaisyouseiymd(),
            BizDate.valueOf("19881113"), "（新契約）対象者生年月日");
        exNumericEquals(sinkeiyakuSakuinKekkaLst.get(3).getSksyouhnsdno(), 23, "（新契約）商品世代番号");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(4).getSkmosno(), "791112402", "（新契約）申込番号");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(4).getSkmoskankeisyakbn(),
            C_KankeisyaKbn.KYK, "（新契約）申込関係者区分");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(4).getSkmosfkojinkbn(), "03", "（新契約）申込Ｆ個人区分");
        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(4).getSkmfrenflg(),
            C_Mfrenflg.SUMI, "（新契約）ＭＦ連動済フラグ");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(4).getSkmosymd(),
            BizDate.valueOf("19940509"), "（新契約）申込日");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(4).getSkkykymd(),
            BizDate.valueOf("19970614"), "（新契約）契約日");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(4).getSkseiritukbn(),
            C_SeirituKbn.SEIRITU, "（新契約）成立区分");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(4).getSksrsyoriymd(),
            BizDate.valueOf("19971014"), "（新契約）成立処理日");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(4).getSksyouhncd(), "sk", "（新契約）商品コード");

        exDateYMEquals(sinkeiyakuSakuinKekkaLst.get(4).getSkbosyuuym(),
            BizDateYM.valueOf("199409"), "（新契約）募集年月");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(4).getSktaisyounayosejtkbn(),
            C_NayoseJyoutaiKbn.NAYOSEHUMEI, "（新契約）対象者名寄せ状態区分");
        exStringEquals(sinkeiyakuSakuinKekkaLst.get(4).getSktaisyousakuinnmno(), "0000000034", "（新契約）対象者索引名番号");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(4).getSktaisyouseiymd(),
            BizDate.valueOf("19881114"), "（新契約）対象者生年月日");
        exNumericEquals(sinkeiyakuSakuinKekkaLst.get(4).getSksyouhnsdno(), 24, "（新契約）商品世代番号");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(5).getSkmosno(), "791112402", "（新契約）申込番号");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(5).getSkmoskankeisyakbn(),
            C_KankeisyaKbn.KYK, "（新契約）申込関係者区分");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(5).getSkmosfkojinkbn(), "03", "（新契約）申込Ｆ個人区分");
        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(5).getSkmfrenflg(),
            C_Mfrenflg.SUMI, "（新契約）ＭＦ連動済フラグ");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(5).getSkmosymd(),
            BizDate.valueOf("19950509"), "（新契約）申込日");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(5).getSkkykymd(),
            BizDate.valueOf("19970615"), "（新契約）契約日");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(5).getSkseiritukbn(),
            C_SeirituKbn.SEIRITU, "（新契約）成立区分");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(5).getSksrsyoriymd(),
            BizDate.valueOf("19971015"), "（新契約）成立処理日");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(5).getSksyouhncd(), "sk", "（新契約）商品コード");

        exDateYMEquals(sinkeiyakuSakuinKekkaLst.get(5).getSkbosyuuym(),
            BizDateYM.valueOf("199509"), "（新契約）募集年月");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(5).getSktaisyounayosejtkbn(),
            C_NayoseJyoutaiKbn.NAYOSEHUMEI, "（新契約）対象者名寄せ状態区分");
        exStringEquals(sinkeiyakuSakuinKekkaLst.get(5).getSktaisyousakuinnmno(), "0000000035", "（新契約）対象者索引名番号");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(5).getSktaisyouseiymd(),
            BizDate.valueOf("19881115"), "（新契約）対象者生年月日");
        exNumericEquals(sinkeiyakuSakuinKekkaLst.get(5).getSksyouhnsdno(), 25, "（新契約）商品世代番号");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(6).getSkmosno(), "791112402", "（新契約）申込番号");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(6).getSkmoskankeisyakbn(),
            C_KankeisyaKbn.KYK, "（新契約）申込関係者区分");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(6).getSkmosfkojinkbn(), "03", "（新契約）申込Ｆ個人区分");
        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(6).getSkmfrenflg(),
            C_Mfrenflg.SUMI, "（新契約）ＭＦ連動済フラグ");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(6).getSkmosymd(),
            BizDate.valueOf("19960509"), "（新契約）申込日");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(6).getSkkykymd(),
            BizDate.valueOf("19970616"), "（新契約）契約日");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(6).getSkseiritukbn(),
            C_SeirituKbn.SEIRITU, "（新契約）成立区分");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(6).getSksrsyoriymd(),
            BizDate.valueOf("19971016"), "（新契約）成立処理日");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(6).getSksyouhncd(), "sk", "（新契約）商品コード");

        exDateYMEquals(sinkeiyakuSakuinKekkaLst.get(6).getSkbosyuuym(),
            BizDateYM.valueOf("199609"), "（新契約）募集年月");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(6).getSktaisyounayosejtkbn(),
            C_NayoseJyoutaiKbn.NAYOSEHUMEI, "（新契約）対象者名寄せ状態区分");
        exStringEquals(sinkeiyakuSakuinKekkaLst.get(6).getSktaisyousakuinnmno(), "0000000036", "（新契約）対象者索引名番号");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(6).getSktaisyouseiymd(),
            BizDate.valueOf("19881116"), "（新契約）対象者生年月日");
        exNumericEquals(sinkeiyakuSakuinKekkaLst.get(6).getSksyouhnsdno(), 26, "（新契約）商品世代番号");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(7).getSkmosno(), "791112402", "（新契約）申込番号");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(7).getSkmoskankeisyakbn(),
            C_KankeisyaKbn.KYK, "（新契約）申込関係者区分");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(7).getSkmosfkojinkbn(), "03", "（新契約）申込Ｆ個人区分");
        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(7).getSkmfrenflg(),
            C_Mfrenflg.SUMI, "（新契約）ＭＦ連動済フラグ");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(7).getSkmosymd(),
            BizDate.valueOf("19970509"), "（新契約）申込日");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(7).getSkkykymd(),
            BizDate.valueOf("19970617"), "（新契約）契約日");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(7).getSkseiritukbn(),
            C_SeirituKbn.SEIRITU, "（新契約）成立区分");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(7).getSksrsyoriymd(),
            BizDate.valueOf("19971017"), "（新契約）成立処理日");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(7).getSksyouhncd(), "sk", "（新契約）商品コード");

        exDateYMEquals(sinkeiyakuSakuinKekkaLst.get(7).getSkbosyuuym(),
            BizDateYM.valueOf("199709"), "（新契約）募集年月");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(7).getSktaisyounayosejtkbn(),
            C_NayoseJyoutaiKbn.NAYOSEHUMEI, "（新契約）対象者名寄せ状態区分");
        exStringEquals(sinkeiyakuSakuinKekkaLst.get(7).getSktaisyousakuinnmno(), "0000000037", "（新契約）対象者索引名番号");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(7).getSktaisyouseiymd(),
            BizDate.valueOf("19881117"), "（新契約）対象者生年月日");
        exNumericEquals(sinkeiyakuSakuinKekkaLst.get(7).getSksyouhnsdno(), 27, "（新契約）商品世代番号");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(8).getSkmosno(), "791112402", "（新契約）申込番号");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(8).getSkmoskankeisyakbn(),
            C_KankeisyaKbn.KYK, "（新契約）申込関係者区分");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(8).getSkmosfkojinkbn(), "03", "（新契約）申込Ｆ個人区分");
        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(8).getSkmfrenflg(),
            C_Mfrenflg.SUMI, "（新契約）ＭＦ連動済フラグ");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(8).getSkmosymd(),
            BizDate.valueOf("19980509"), "（新契約）申込日");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(8).getSkkykymd(),
            BizDate.valueOf("19970618"), "（新契約）契約日");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(8).getSkseiritukbn(),
            C_SeirituKbn.SEIRITU, "（新契約）成立区分");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(8).getSksrsyoriymd(),
            BizDate.valueOf("19971018"), "（新契約）成立処理日");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(8).getSksyouhncd(), "sk", "（新契約）商品コード");

        exDateYMEquals(sinkeiyakuSakuinKekkaLst.get(8).getSkbosyuuym(),
            BizDateYM.valueOf("199809"), "（新契約）募集年月");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(8).getSktaisyounayosejtkbn(),
            C_NayoseJyoutaiKbn.NAYOSEHUMEI, "（新契約）対象者名寄せ状態区分");
        exStringEquals(sinkeiyakuSakuinKekkaLst.get(8).getSktaisyousakuinnmno(), "0000000038", "（新契約）対象者索引名番号");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(8).getSktaisyouseiymd(),
            BizDate.valueOf("19881118"), "（新契約）対象者生年月日");
        exNumericEquals(sinkeiyakuSakuinKekkaLst.get(8).getSksyouhnsdno(), 28, "（新契約）商品世代番号");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(9).getSkmosno(), "791112402", "（新契約）申込番号");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(9).getSkmoskankeisyakbn(),
            C_KankeisyaKbn.KYK, "（新契約）申込関係者区分");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(9).getSkmosfkojinkbn(), "03", "（新契約）申込Ｆ個人区分");
        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(9).getSkmfrenflg(),
            C_Mfrenflg.SUMI, "（新契約）ＭＦ連動済フラグ");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(9).getSkmosymd(),
            BizDate.valueOf("19990509"), "（新契約）申込日");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(9).getSkkykymd(),
            BizDate.valueOf("19970619"), "（新契約）契約日");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(9).getSkseiritukbn(),
            C_SeirituKbn.SEIRITU, "（新契約）成立区分");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(9).getSksrsyoriymd(),
            BizDate.valueOf("19971019"), "（新契約）成立処理日");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(9).getSksyouhncd(), "sk", "（新契約）商品コード");

        exDateYMEquals(sinkeiyakuSakuinKekkaLst.get(9).getSkbosyuuym(),
            BizDateYM.valueOf("199909"), "（新契約）募集年月");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(9).getSktaisyounayosejtkbn(),
            C_NayoseJyoutaiKbn.NAYOSEHUMEI, "（新契約）対象者名寄せ状態区分");
        exStringEquals(sinkeiyakuSakuinKekkaLst.get(9).getSktaisyousakuinnmno(), "0000000039", "（新契約）対象者索引名番号");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(9).getSktaisyouseiymd(),
            BizDate.valueOf("19881119"), "（新契約）対象者生年月日");
        exNumericEquals(sinkeiyakuSakuinKekkaLst.get(9).getSksyouhnsdno(), 29, "（新契約）商品世代番号");


        List<BzNenkinSiharaiSakuinKekkaBean> nenkinSiharaiSakuinKekkaLst =
            bzSakuinTsnSyoukaiKekkaBean.getBznenkinsiharaisakuinkekkabeanlist();
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getBznenkinsiharaisakuinkekkabeanlist().size(),
            10, "年金支払索引結果Beanリストのサイズ");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(0).getNknksysyno(), "11807111222", "（年金支払）年金証書番号");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(0).getNknkkankeisyakbn(),
            C_NkKankeisyaKbn.HHKN_NKUKTBETU, "（年金支払）年金支払関係者区分");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(0).getNknkkojinkbn(), "05", "（年金支払）年金支払個人区分");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(0).getNkkykymd(),
            BizDate.valueOf("20000402"), "（年金支払）契約日");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(0).getNknkshrstartymd(),
            BizDate.valueOf("20000409"), "（年金支払）年金支払開始日");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(0).getNknksyoumetucd(),
            C_NkSyoumetuCd.SIBOU, "（年金支払）年金消滅コード");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(0).getNksyoumetuymd(),
            BizDate.valueOf("20050510"), "（年金支払）消滅日");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(0).getNksyouhncd(), "nk", "（年金支払）商品コード");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(0).getNknenkinsyu(), "01", "（年金支払）年金種類");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(0).getNktaisyouseiymd(),
            BizDate.valueOf("19780410"), "（年金支払）対象者生年月日");
        exNumericEquals(nenkinSiharaiSakuinKekkaLst.get(0).getNksyouhnsdno(), 30, "（年金支払）商品世代番号");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(1).getNknksysyno(), "11807111222", "（年金支払）年金証書番号");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(1).getNknkkankeisyakbn(),
            C_NkKankeisyaKbn.HHKN_NKUKTBETU, "（年金支払）年金支払関係者区分");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(1).getNknkkojinkbn(), "05", "（年金支払）年金支払個人区分");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(1).getNkkykymd(),
            BizDate.valueOf("20010402"), "（年金支払）契約日");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(1).getNknkshrstartymd(),
            BizDate.valueOf("20010409"), "（年金支払）年金支払開始日");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(1).getNknksyoumetucd(),
            C_NkSyoumetuCd.SIBOU, "（年金支払）年金消滅コード");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(1).getNksyoumetuymd(),
            BizDate.valueOf("20050511"), "（年金支払）消滅日");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(1).getNksyouhncd(), "nk", "（年金支払）商品コード");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(1).getNknenkinsyu(), "01", "（年金支払）年金種類");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(1).getNktaisyouseiymd(),
            BizDate.valueOf("19780411"), "（年金支払）対象者生年月日");
        exNumericEquals(nenkinSiharaiSakuinKekkaLst.get(1).getNksyouhnsdno(), 31, "（年金支払）商品世代番号");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(2).getNknksysyno(), "11807111222", "（年金支払）年金証書番号");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(2).getNknkkankeisyakbn(),
            C_NkKankeisyaKbn.HHKN_NKUKTBETU, "（年金支払）年金支払関係者区分");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(2).getNknkkojinkbn(), "05", "（年金支払）年金支払個人区分");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(2).getNkkykymd(),
            BizDate.valueOf("20020402"), "（年金支払）契約日");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(2).getNknkshrstartymd(),
            BizDate.valueOf("20020409"), "（年金支払）年金支払開始日");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(2).getNknksyoumetucd(),
            C_NkSyoumetuCd.SIBOU, "（年金支払）年金消滅コード");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(2).getNksyoumetuymd(),
            BizDate.valueOf("20050512"), "（年金支払）消滅日");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(2).getNksyouhncd(), "nk", "（年金支払）商品コード");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(2).getNknenkinsyu(), "01", "（年金支払）年金種類");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(2).getNktaisyouseiymd(),
            BizDate.valueOf("19780412"), "（年金支払）対象者生年月日");
        exNumericEquals(nenkinSiharaiSakuinKekkaLst.get(2).getNksyouhnsdno(), 32, "（年金支払）商品世代番号");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(3).getNknksysyno(), "11807111222", "（年金支払）年金証書番号");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(3).getNknkkankeisyakbn(),
            C_NkKankeisyaKbn.HHKN_NKUKTBETU, "（年金支払）年金支払関係者区分");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(3).getNknkkojinkbn(), "05", "（年金支払）年金支払個人区分");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(3).getNkkykymd(),
            BizDate.valueOf("20030402"), "（年金支払）契約日");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(3).getNknkshrstartymd(),
            BizDate.valueOf("20030409"), "（年金支払）年金支払開始日");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(3).getNknksyoumetucd(),
            C_NkSyoumetuCd.SIBOU, "（年金支払）年金消滅コード");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(3).getNksyoumetuymd(),
            BizDate.valueOf("20050513"), "（年金支払）消滅日");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(3).getNksyouhncd(), "nk", "（年金支払）商品コード");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(3).getNknenkinsyu(), "01", "（年金支払）年金種類");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(3).getNktaisyouseiymd(),
            BizDate.valueOf("19780413"), "（年金支払）対象者生年月日");
        exNumericEquals(nenkinSiharaiSakuinKekkaLst.get(3).getNksyouhnsdno(), 33, "（年金支払）商品世代番号");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(4).getNknksysyno(), "11807111222", "（年金支払）年金証書番号");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(4).getNknkkankeisyakbn(),
            C_NkKankeisyaKbn.HHKN_NKUKTBETU, "（年金支払）年金支払関係者区分");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(4).getNknkkojinkbn(), "05", "（年金支払）年金支払個人区分");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(4).getNkkykymd(),
            BizDate.valueOf("20040402"), "（年金支払）契約日");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(4).getNknkshrstartymd(),
            BizDate.valueOf("20040409"), "（年金支払）年金支払開始日");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(4).getNknksyoumetucd(),
            C_NkSyoumetuCd.SIBOU, "（年金支払）年金消滅コード");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(4).getNksyoumetuymd(),
            BizDate.valueOf("20050514"), "（年金支払）消滅日");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(4).getNksyouhncd(), "nk", "（年金支払）商品コード");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(4).getNknenkinsyu(), "01", "（年金支払）年金種類");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(4).getNktaisyouseiymd(),
            BizDate.valueOf("19780414"), "（年金支払）対象者生年月日");
        exNumericEquals(nenkinSiharaiSakuinKekkaLst.get(4).getNksyouhnsdno(), 34, "（年金支払）商品世代番号");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(5).getNknksysyno(), "11807111222", "（年金支払）年金証書番号");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(5).getNknkkankeisyakbn(),
            C_NkKankeisyaKbn.HHKN_NKUKTBETU, "（年金支払）年金支払関係者区分");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(5).getNknkkojinkbn(), "05", "（年金支払）年金支払個人区分");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(5).getNkkykymd(),
            BizDate.valueOf("20050402"), "（年金支払）契約日");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(5).getNknkshrstartymd(),
            BizDate.valueOf("20050409"), "（年金支払）年金支払開始日");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(5).getNknksyoumetucd(),
            C_NkSyoumetuCd.SIBOU, "（年金支払）年金消滅コード");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(5).getNksyoumetuymd(),
            BizDate.valueOf("20050515"), "（年金支払）消滅日");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(5).getNksyouhncd(), "nk", "（年金支払）商品コード");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(5).getNknenkinsyu(), "01", "（年金支払）年金種類");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(5).getNktaisyouseiymd(),
            BizDate.valueOf("19780415"), "（年金支払）対象者生年月日");
        exNumericEquals(nenkinSiharaiSakuinKekkaLst.get(5).getNksyouhnsdno(), 35, "（年金支払）商品世代番号");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(6).getNknksysyno(), "11807111222", "（年金支払）年金証書番号");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(6).getNknkkankeisyakbn(),
            C_NkKankeisyaKbn.HHKN_NKUKTBETU, "（年金支払）年金支払関係者区分");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(6).getNknkkojinkbn(), "05", "（年金支払）年金支払個人区分");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(6).getNkkykymd(),
            BizDate.valueOf("20060402"), "（年金支払）契約日");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(6).getNknkshrstartymd(),
            BizDate.valueOf("20060409"), "（年金支払）年金支払開始日");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(6).getNknksyoumetucd(),
            C_NkSyoumetuCd.SIBOU, "（年金支払）年金消滅コード");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(6).getNksyoumetuymd(),
            BizDate.valueOf("20050516"), "（年金支払）消滅日");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(6).getNksyouhncd(), "nk", "（年金支払）商品コード");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(6).getNknenkinsyu(), "01", "（年金支払）年金種類");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(6).getNktaisyouseiymd(),
            BizDate.valueOf("19780416"), "（年金支払）対象者生年月日");
        exNumericEquals(nenkinSiharaiSakuinKekkaLst.get(6).getNksyouhnsdno(), 36, "（年金支払）商品世代番号");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(7).getNknksysyno(), "11807111222", "（年金支払）年金証書番号");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(7).getNknkkankeisyakbn(),
            C_NkKankeisyaKbn.HHKN_NKUKTBETU, "（年金支払）年金支払関係者区分");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(7).getNknkkojinkbn(), "05", "（年金支払）年金支払個人区分");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(7).getNkkykymd(),
            BizDate.valueOf("20070402"), "（年金支払）契約日");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(7).getNknkshrstartymd(),
            BizDate.valueOf("20070409"), "（年金支払）年金支払開始日");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(7).getNknksyoumetucd(),
            C_NkSyoumetuCd.SIBOU, "（年金支払）年金消滅コード");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(7).getNksyoumetuymd(),
            BizDate.valueOf("20050517"), "（年金支払）消滅日");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(7).getNksyouhncd(), "nk", "（年金支払）商品コード");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(7).getNknenkinsyu(), "01", "（年金支払）年金種類");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(7).getNktaisyouseiymd(),
            BizDate.valueOf("19780417"), "（年金支払）対象者生年月日");
        exNumericEquals(nenkinSiharaiSakuinKekkaLst.get(7).getNksyouhnsdno(), 37, "（年金支払）商品世代番号");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(8).getNknksysyno(), "11807111222", "（年金支払）年金証書番号");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(8).getNknkkankeisyakbn(),
            C_NkKankeisyaKbn.HHKN_NKUKTBETU, "（年金支払）年金支払関係者区分");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(8).getNknkkojinkbn(), "05", "（年金支払）年金支払個人区分");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(8).getNkkykymd(),
            BizDate.valueOf("20080402"), "（年金支払）契約日");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(8).getNknkshrstartymd(),
            BizDate.valueOf("20080409"), "（年金支払）年金支払開始日");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(8).getNknksyoumetucd(),
            C_NkSyoumetuCd.SIBOU, "（年金支払）年金消滅コード");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(8).getNksyoumetuymd(),
            BizDate.valueOf("20050518"), "（年金支払）消滅日");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(8).getNksyouhncd(), "nk", "（年金支払）商品コード");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(8).getNknenkinsyu(), "01", "（年金支払）年金種類");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(8).getNktaisyouseiymd(),
            BizDate.valueOf("19780418"), "（年金支払）対象者生年月日");
        exNumericEquals(nenkinSiharaiSakuinKekkaLst.get(8).getNksyouhnsdno(), 38, "（年金支払）商品世代番号");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(9).getNknksysyno(), "11807111222", "（年金支払）年金証書番号");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(9).getNknkkankeisyakbn(),
            C_NkKankeisyaKbn.HHKN_NKUKTBETU, "（年金支払）年金支払関係者区分");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(9).getNknkkojinkbn(), "05", "（年金支払）年金支払個人区分");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(9).getNkkykymd(),
            BizDate.valueOf("20090402"), "（年金支払）契約日");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(9).getNknkshrstartymd(),
            BizDate.valueOf("20090409"), "（年金支払）年金支払開始日");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(9).getNknksyoumetucd(),
            C_NkSyoumetuCd.SIBOU, "（年金支払）年金消滅コード");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(9).getNksyoumetuymd(),
            BizDate.valueOf("20050519"), "（年金支払）消滅日");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(9).getNksyouhncd(), "nk", "（年金支払）商品コード");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(9).getNknenkinsyu(), "01", "（年金支払）年金種類");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(9).getNktaisyouseiymd(),
            BizDate.valueOf("19780419"), "（年金支払）対象者生年月日");
        exNumericEquals(nenkinSiharaiSakuinKekkaLst.get(9).getNksyouhnsdno(), 39, "（年金支払）商品世代番号");


        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSntkinfomrumukbn(),
            C_BlnktkumuKbn.ARI, "選択情報ＭＲ有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSntkinfohnsyumukbn(),
            C_BlnktkumuKbn.ARI, "選択情報反社有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSignalinfoumukbn(),
            C_BlnktkumuKbn.ARI, "シグナル情報有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSignalinfohnsyumukbn(),
            C_BlnktkumuKbn.ARI, "シグナル情報反社有無区分");


        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getGaikokupepsumukbn(),
            C_BlnktkumuKbn.ARI, "外国ＰＥＰｓ有無区分");


        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSinsntkhnsyumukbn(),
            C_BlnktkumuKbn.NONE, "新選択情報反社有無区分");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnsibous().toString(), "12345678901", "通算総死亡Ｓ");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnninenmikeikas().toString(), "12345678902", "通算２年未経過総死亡Ｓ");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnninenkeikas().toString(), "12345678903", "通算２年経過総死亡Ｓ");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnketsibous().toString(), "12345678904", "通算決定総死亡Ｓ");

        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnketsibous2().toString(), "12345678905", "通算決定総死亡Ｓ２");

        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnsoukktjituhsgk().toString(), "12345678906", "通算総告知書実保障額");

        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnkktjituhsgk1().toString(), "12345678907", "通算告知書実保障額１");

        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnkktjituhsgk2().toString(), "12345678908", "通算告知書実保障額２");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnkktitijibrsysnjs().toString(), "12345678909", "通算告知書一時払終身等除Ｓ");

        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnnkgns().toString(), "12345678900", "通算年金原資");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnmsnynenbtsousbus().toString(), "22345678900", "通算未成年用年齢別総死亡Ｓ");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnnenbtitijibrssbs().toString(), "32345678900", "通算年齢別一時払総死亡Ｓ");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnitijibrsysnp().toString(), "32345678901", "通算一時払終身Ｐ");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnninenmikeikahtnkns().toString(), "32345678902", "通算２年未経過被転換死亡Ｓ");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnninenkeikadfp().toString(), "32345678903", "通算２年経過ＤＦＰ");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnsntktuukahijynsysns().toString(), "12345678901", "通算選択通貨建平準払終身Ｓ");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnkaigomehrtkumukbn(),
            C_UmuKbn.NONE, "通算介護前払特約有無区分");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getKykdrtentsns().toString(), "42345678900", "契約者同一代理店通算Ｓ");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSibouriskmoshukakbn(),
            C_MosHukaKbn.HUKA, "死亡リスク申込不可区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getKktsibouriskmoshukakbn(),
            C_MosHukaKbn.BLNK, "告知扱死亡リスク申込不可区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getItineninaienkigaitoukbn(),
            C_GaitouKbn.BLNK, "１年以内延期該当区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getItekisntkhndktyhkbn(),
            C_YouhiblnkKbn.YOU, "医的選択情報ハンド決定要否区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getTtdktyuuiknkhndktyhkbn(),
            C_YouhiblnkKbn.YOU, "手続注意環境ハンド決定要否区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getUktttdktyuuiknkhndktyhkbn(),
            C_YouhiblnkKbn.HUYOU, "受取人用手続注意環境ハンド決定要否区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getKyhkinuktkariitkhndktyhkbn(),
            C_YouhiblnkKbn.YOU, "給付金受付有医的ハンド決定要否区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getDoujimositekihndktyhkbn(),
            C_YouhiblnkKbn.YOU, "同時申込医的ハンド決定要否区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getDoujimosknkhndktyhkbn(),
            C_YouhiblnkKbn.YOU, "同時申込環境ハンド決定要否区分");

    }
    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {


        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN6;

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = SWAKInjector
            .getInstance(BzSakuinTsnSyoukaiYokenBean.class);


        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);


        editYokenDate(bzSakuinTsnSyoukaiYokenBean);

        BzSakuinTsnSyoukaiMq bzSakuinTsnSyoukaiMq = SWAKInjector.getInstance(BzSakuinTsnSyoukaiMq.class);
        BzSakuinTsnSyoukaiKekkaBean bzSakuinTsnSyoukaiKekkaBean =
            bzSakuinTsnSyoukaiMq.exec(bzSakuinTsnSyoukaiYokenBean);

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getMqsyorikekkakbn(),
            C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getPalsyoukaijissiumukbn(),
            C_PalSyoukaiJissiumuKbn.ARI, "ＰＡＬあて照会実施有無区分");

        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getAcserrcd(),
            "0000", "ＡＣＳ基盤エラーコード");


        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSakuininfosyoukaierrkbn(),
            C_MQSyoukaiErrorKbn.SYOUKAIERROR, "索引情報照会エラー区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getMrsyoukaierrkbn(),
            C_MQSyoukaiErrorKbn.SYOUKAIOK, "ＭＲ照会エラー区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSignalsyoukaierrkbn(),
            C_MQSyoukaiErrorKbn.BLNK, "シグナル照会エラー区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSinsntkhnsysyoukaierrkbn(),
            C_MQSyoukaiErrorKbn.SYOUKAIERROR, "新選択情報反社照会エラー区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getTsngksyoukaierrkbn(),
            C_MQSyoukaiErrorKbn.SYOUKAIERROR, "通算金額照会エラー区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getKykdrtentsnssyoukaierrkbn(),
            C_MQSyoukaiErrorKbn.SYOUKAIERROR, "契約者同一代理店通算Ｓ照会エラー区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getMossakuseikahisyoukaierrkbn(),
            C_MQSyoukaiErrorKbn.SYOUKAIERROR, "申込書作成可否照会エラー区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getHndketyhsyoukaierrkbn(),
            C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ハンド決定要否照会エラー区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getNysjissikekkakbn(),
            C_NayoseJissiKekkaKbn.DOUITUARI, "名寄せ実施結果区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getNysjyoutaikbn(),
            C_NayoseJyoutaiKbn.NAYOSEHUMEI, "名寄せ状態区分");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getSakuinnmno(), "1234567890", "契約ＭＦ個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getKykmfkensuu(), 10, "契約ＭＦ個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getMosfkensuu(), 10, "申込Ｆ個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getSntkfkensuu(), 10, "選択情報Ｆ個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getSueokifkensuu(), 10, "据置Ｆ個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getNkfkensuu(), 10, "年金Ｆ個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getKhkensuu(), 10, "契約保全個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getSkkensuu(), 10, "新契約個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getNkkensuu(), 10, "年金支払個別項目設定件数");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getKykmfkensuutyoukaumu(),
            C_BlnktkumuKbn.ARI, "契約ＭＦ件数超過有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getMosfkensuutyoukaumu(),
            C_BlnktkumuKbn.BLNK, "申込Ｆ件数超過有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSntkfkensuutyoukaumu(),
            C_BlnktkumuKbn.NONE, "選択情報Ｆ件数超過有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSueokifkensuutyoukaumu(),
            C_BlnktkumuKbn.ARI, "据置Ｆ件数超過有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getNkfkensuutyoukaumu(),
            C_BlnktkumuKbn.ARI, "年金Ｆ件数超過有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getKhkensuutyoukaumu(),
            C_BlnktkumuKbn.ARI, "契約保全件数超過有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSkkensuutyoukaumu(),
            C_BlnktkumuKbn.ARI, "新契約件数超過有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getNkkensuutyoukaumu(),
            C_BlnktkumuKbn.ARI, "年金支払件数超過有無区分");


        List<BzKeiyakuMfSakuinKekkaBean> kykMfSakuinKekkaBeanLst = bzSakuinTsnSyoukaiKekkaBean
            .getBzkeiyakumfsakuinkekkabeanlist();
        exNumericEquals(kykMfSakuinKekkaBeanLst.size(), 10, "契約ＭＦ索引結果Beanリストのサイズ");


        exStringEquals(kykMfSakuinKekkaBeanLst.get(0).getKykmfsyono(), "11807111129", "（契約ＭＦ）証券番号");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(0).getKykmfkykkankeisyakbn(),
            C_KankeisyaKbn.KYK, "（契約ＭＦ）契約関係者区分");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(0).getKykmfkykmfkojinkbn(),
            "01", "（契約ＭＦ）契約ＭＦ個人区分");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(0).getKykmfkykjyoutaikbn(),
            C_KykJyoutaiKbn.SIKKOU, "（契約ＭＦ）契約状態区分");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(0).getKykmfkykymd(), BizDate.valueOf("19900311"), "（契約ＭＦ）契約日");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(0).getKykmfsyoumetucd(), "Sm00", "（契約ＭＦ）消滅コード");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(0).getKykmfsyoumetuymd(), BizDate.valueOf("19901004"), "（契約ＭＦ）消滅日");

        exDateYMEquals(kykMfSakuinKekkaBeanLst.get(0).getKykmfbosyuuym(), BizDateYM.valueOf("200010"), "（契約ＭＦ）募集年月");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(0).getKykmftaisyouseiymd(), BizDate.valueOf("19901024"),
            "（契約ＭＦ）対象者生年月日");


        exStringEquals(kykMfSakuinKekkaBeanLst.get(1).getKykmfsyono(), "11807111129", "（契約ＭＦ）証券番号");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(1).getKykmfkykkankeisyakbn(),
            C_KankeisyaKbn.KYK, "（契約ＭＦ）契約関係者区分");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(1).getKykmfkykmfkojinkbn(),
            "01", "（契約ＭＦ）契約ＭＦ個人区分");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(1).getKykmfkykjyoutaikbn(),
            C_KykJyoutaiKbn.SIKKOU, "（契約ＭＦ）契約状態区分");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(1).getKykmfkykymd(), BizDate.valueOf("19910311"), "（契約ＭＦ）契約日");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(1).getKykmfsyoumetucd(), "Sm01", "（契約ＭＦ）消滅コード");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(1).getKykmfsyoumetuymd(), BizDate.valueOf("19911004"), "（契約ＭＦ）消滅日");

        exDateYMEquals(kykMfSakuinKekkaBeanLst.get(1).getKykmfbosyuuym(), BizDateYM.valueOf("200110"), "（契約ＭＦ）募集年月");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(1).getKykmftaisyouseiymd(), BizDate.valueOf("19911024"),
            "（契約ＭＦ）対象者生年月日");


        exStringEquals(kykMfSakuinKekkaBeanLst.get(2).getKykmfsyono(), "11807111129", "（契約ＭＦ）証券番号");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(2).getKykmfkykkankeisyakbn(),
            C_KankeisyaKbn.KYK, "（契約ＭＦ）契約関係者区分");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(2).getKykmfkykmfkojinkbn(),
            "01", "（契約ＭＦ）契約ＭＦ個人区分");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(2).getKykmfkykjyoutaikbn(),
            C_KykJyoutaiKbn.SIKKOU, "（契約ＭＦ）契約状態区分");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(2).getKykmfkykymd(), BizDate.valueOf("19920311"), "（契約ＭＦ）契約日");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(2).getKykmfsyoumetucd(), "Sm02", "（契約ＭＦ）消滅コード");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(2).getKykmfsyoumetuymd(), BizDate.valueOf("19921004"), "（契約ＭＦ）消滅日");

        exDateYMEquals(kykMfSakuinKekkaBeanLst.get(2).getKykmfbosyuuym(), BizDateYM.valueOf("200210"), "（契約ＭＦ）募集年月");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(2).getKykmftaisyouseiymd(), BizDate.valueOf("19921024"),
            "（契約ＭＦ）対象者生年月日");


        exStringEquals(kykMfSakuinKekkaBeanLst.get(3).getKykmfsyono(), "11807111129", "（契約ＭＦ）証券番号");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(3).getKykmfkykkankeisyakbn(),
            C_KankeisyaKbn.KYK, "（契約ＭＦ）契約関係者区分");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(3).getKykmfkykmfkojinkbn(),
            "01", "（契約ＭＦ）契約ＭＦ個人区分");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(3).getKykmfkykjyoutaikbn(),
            C_KykJyoutaiKbn.SIKKOU, "（契約ＭＦ）契約状態区分");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(3).getKykmfkykymd(), BizDate.valueOf("19930311"), "（契約ＭＦ）契約日");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(3).getKykmfsyoumetucd(), "Sm03", "（契約ＭＦ）消滅コード");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(3).getKykmfsyoumetuymd(), BizDate.valueOf("19931004"), "（契約ＭＦ）消滅日");

        exDateYMEquals(kykMfSakuinKekkaBeanLst.get(3).getKykmfbosyuuym(), BizDateYM.valueOf("200310"), "（契約ＭＦ）募集年月");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(3).getKykmftaisyouseiymd(), BizDate.valueOf("19931024"),
            "（契約ＭＦ）対象者生年月日");


        exStringEquals(kykMfSakuinKekkaBeanLst.get(4).getKykmfsyono(), "11807111129", "（契約ＭＦ）証券番号");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(4).getKykmfkykkankeisyakbn(),
            C_KankeisyaKbn.KYK, "（契約ＭＦ）契約関係者区分");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(4).getKykmfkykmfkojinkbn(),
            "01", "（契約ＭＦ）契約ＭＦ個人区分");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(4).getKykmfkykjyoutaikbn(),
            C_KykJyoutaiKbn.SIKKOU, "（契約ＭＦ）契約状態区分");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(4).getKykmfkykymd(), BizDate.valueOf("19940311"), "（契約ＭＦ）契約日");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(4).getKykmfsyoumetucd(), "Sm04", "（契約ＭＦ）消滅コード");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(4).getKykmfsyoumetuymd(), BizDate.valueOf("19941004"), "（契約ＭＦ）消滅日");

        exDateYMEquals(kykMfSakuinKekkaBeanLst.get(4).getKykmfbosyuuym(), BizDateYM.valueOf("200410"), "（契約ＭＦ）募集年月");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(4).getKykmftaisyouseiymd(), BizDate.valueOf("19941024"),
            "（契約ＭＦ）対象者生年月日");


        exStringEquals(kykMfSakuinKekkaBeanLst.get(5).getKykmfsyono(), "11807111129", "（契約ＭＦ）証券番号");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(5).getKykmfkykkankeisyakbn(),
            C_KankeisyaKbn.KYK, "（契約ＭＦ）契約関係者区分");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(5).getKykmfkykmfkojinkbn(),
            "01", "（契約ＭＦ）契約ＭＦ個人区分");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(5).getKykmfkykjyoutaikbn(),
            C_KykJyoutaiKbn.SIKKOU, "（契約ＭＦ）契約状態区分");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(5).getKykmfkykymd(), BizDate.valueOf("19950311"), "（契約ＭＦ）契約日");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(5).getKykmfsyoumetucd(), "Sm05", "（契約ＭＦ）消滅コード");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(5).getKykmfsyoumetuymd(), BizDate.valueOf("19951004"), "（契約ＭＦ）消滅日");

        exDateYMEquals(kykMfSakuinKekkaBeanLst.get(5).getKykmfbosyuuym(), BizDateYM.valueOf("200510"), "（契約ＭＦ）募集年月");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(5).getKykmftaisyouseiymd(), BizDate.valueOf("19951024"),
            "（契約ＭＦ）対象者生年月日");


        exStringEquals(kykMfSakuinKekkaBeanLst.get(6).getKykmfsyono(), "11807111129", "（契約ＭＦ）証券番号");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(6).getKykmfkykkankeisyakbn(),
            C_KankeisyaKbn.KYK, "（契約ＭＦ）契約関係者区分");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(6).getKykmfkykmfkojinkbn(),
            "01", "（契約ＭＦ）契約ＭＦ個人区分");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(6).getKykmfkykjyoutaikbn(),
            C_KykJyoutaiKbn.SIKKOU, "（契約ＭＦ）契約状態区分");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(6).getKykmfkykymd(), BizDate.valueOf("19960311"), "（契約ＭＦ）契約日");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(6).getKykmfsyoumetucd(), "Sm06", "（契約ＭＦ）消滅コード");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(6).getKykmfsyoumetuymd(), BizDate.valueOf("19961004"), "（契約ＭＦ）消滅日");

        exDateYMEquals(kykMfSakuinKekkaBeanLst.get(6).getKykmfbosyuuym(), BizDateYM.valueOf("200610"), "（契約ＭＦ）募集年月");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(6).getKykmftaisyouseiymd(), BizDate.valueOf("19961024"),
            "（契約ＭＦ）対象者生年月日");


        exStringEquals(kykMfSakuinKekkaBeanLst.get(7).getKykmfsyono(), "11807111129", "（契約ＭＦ）証券番号");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(7).getKykmfkykkankeisyakbn(),
            C_KankeisyaKbn.KYK, "（契約ＭＦ）契約関係者区分");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(7).getKykmfkykmfkojinkbn(),
            "01", "（契約ＭＦ）契約ＭＦ個人区分");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(7).getKykmfkykjyoutaikbn(),
            C_KykJyoutaiKbn.SIKKOU, "（契約ＭＦ）契約状態区分");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(7).getKykmfkykymd(), BizDate.valueOf("19970311"), "（契約ＭＦ）契約日");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(7).getKykmfsyoumetucd(), "Sm07", "（契約ＭＦ）消滅コード");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(7).getKykmfsyoumetuymd(), BizDate.valueOf("19971004"), "（契約ＭＦ）消滅日");

        exDateYMEquals(kykMfSakuinKekkaBeanLst.get(7).getKykmfbosyuuym(), BizDateYM.valueOf("200710"), "（契約ＭＦ）募集年月");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(7).getKykmftaisyouseiymd(), BizDate.valueOf("19971024"),
            "（契約ＭＦ）対象者生年月日");


        exStringEquals(kykMfSakuinKekkaBeanLst.get(8).getKykmfsyono(), "11807111129", "（契約ＭＦ）証券番号");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(8).getKykmfkykkankeisyakbn(),
            C_KankeisyaKbn.KYK, "（契約ＭＦ）契約関係者区分");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(8).getKykmfkykmfkojinkbn(),
            "01", "（契約ＭＦ）契約ＭＦ個人区分");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(8).getKykmfkykjyoutaikbn(),
            C_KykJyoutaiKbn.SIKKOU, "（契約ＭＦ）契約状態区分");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(8).getKykmfkykymd(), BizDate.valueOf("19980311"), "（契約ＭＦ）契約日");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(8).getKykmfsyoumetucd(), "Sm08", "（契約ＭＦ）消滅コード");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(8).getKykmfsyoumetuymd(), BizDate.valueOf("19981004"), "（契約ＭＦ）消滅日");

        exDateYMEquals(kykMfSakuinKekkaBeanLst.get(8).getKykmfbosyuuym(), BizDateYM.valueOf("200810"), "（契約ＭＦ）募集年月");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(8).getKykmftaisyouseiymd(), BizDate.valueOf("19981024"),
            "（契約ＭＦ）対象者生年月日");


        exStringEquals(kykMfSakuinKekkaBeanLst.get(9).getKykmfsyono(), "11807111129", "（契約ＭＦ）証券番号");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(9).getKykmfkykkankeisyakbn(),
            C_KankeisyaKbn.KYK, "（契約ＭＦ）契約関係者区分");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(9).getKykmfkykmfkojinkbn(),
            "01", "（契約ＭＦ）契約ＭＦ個人区分");

        exClassificationEquals(kykMfSakuinKekkaBeanLst.get(9).getKykmfkykjyoutaikbn(),
            C_KykJyoutaiKbn.SIKKOU, "（契約ＭＦ）契約状態区分");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(9).getKykmfkykymd(), BizDate.valueOf("19990311"), "（契約ＭＦ）契約日");

        exStringEquals(kykMfSakuinKekkaBeanLst.get(9).getKykmfsyoumetucd(), "Sm09", "（契約ＭＦ）消滅コード");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(9).getKykmfsyoumetuymd(), BizDate.valueOf("19991004"), "（契約ＭＦ）消滅日");

        exDateYMEquals(kykMfSakuinKekkaBeanLst.get(9).getKykmfbosyuuym(), BizDateYM.valueOf("200910"), "（契約ＭＦ）募集年月");
        exDateEquals(kykMfSakuinKekkaBeanLst.get(9).getKykmftaisyouseiymd(), BizDate.valueOf("19991024"),
            "（契約ＭＦ）対象者生年月日");


        List<BzMousikomiFSakuinKekkaBean> mousikomiFSakuinKekkaLst =
            bzSakuinTsnSyoukaiKekkaBean.getBzmousikomifsakuinkekkabeanlist();
        exNumericEquals(mousikomiFSakuinKekkaLst.size(), 10, "申込Ｆ索引結果Beanリストのサイズ");


        exStringEquals(mousikomiFSakuinKekkaLst.get(0).getMosfmosno(),
            "791112220", "（申込Ｆ）申込番号");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(0).getMosfmoskankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（申込Ｆ）申込関係者区分");

        exStringEquals(mousikomiFSakuinKekkaLst.get(0).getMosfmofkojinkbn(),
            "01", "（申込Ｆ）申込Ｆ個人区分");
        exClassificationEquals(mousikomiFSakuinKekkaLst.get(0).getMosfmfrenflg(),
            C_Mfrenflg.SUMI, "（申込Ｆ）ＭＦ連動済フラグ");
        exDateEquals(mousikomiFSakuinKekkaLst.get(0).getMosfmosymd(), BizDate.valueOf("19901112"), "（申込Ｆ）申込日");
        exDateEquals(mousikomiFSakuinKekkaLst.get(0).getMosfkykymd(), BizDate.valueOf("19901201"), "（申込Ｆ）契約日");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(0).getMosfmossyoumetukbn(),
            C_MossyoumetuKbn.SEIRITU, "（申込Ｆ）申込消滅区分");
        exDateEquals(mousikomiFSakuinKekkaLst.get(0).getMosfmossyoumetukktiymd(), BizDate.valueOf("19900105"),
            "（申込Ｆ）申込消滅確定日");

        exDateYMEquals(mousikomiFSakuinKekkaLst.get(0).getMosfbosyuuym(), BizDateYM.valueOf("199003"), "（申込Ｆ）募集年月");
        exDateEquals(mousikomiFSakuinKekkaLst.get(0).getMosftaisyouseiymd(), BizDate.valueOf("19801206"),
            "（申込Ｆ）対象者生年月日");


        exStringEquals(mousikomiFSakuinKekkaLst.get(1).getMosfmosno(),
            "791112220", "（申込Ｆ）申込番号");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(1).getMosfmoskankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（申込Ｆ）申込関係者区分");

        exStringEquals(mousikomiFSakuinKekkaLst.get(1).getMosfmofkojinkbn(),
            "01", "（申込Ｆ）申込Ｆ個人区分");
        exClassificationEquals(mousikomiFSakuinKekkaLst.get(1).getMosfmfrenflg(),
            C_Mfrenflg.SUMI, "（申込Ｆ）ＭＦ連動済フラグ");
        exDateEquals(mousikomiFSakuinKekkaLst.get(1).getMosfmosymd(), BizDate.valueOf("19911112"), "（申込Ｆ）申込日");
        exDateEquals(mousikomiFSakuinKekkaLst.get(1).getMosfkykymd(), BizDate.valueOf("19911201"), "（申込Ｆ）契約日");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(1).getMosfmossyoumetukbn(),
            C_MossyoumetuKbn.SEIRITU, "（申込Ｆ）申込消滅区分");
        exDateEquals(mousikomiFSakuinKekkaLst.get(1).getMosfmossyoumetukktiymd(), BizDate.valueOf("19910105"),
            "（申込Ｆ）申込消滅確定日");

        exDateYMEquals(mousikomiFSakuinKekkaLst.get(1).getMosfbosyuuym(), BizDateYM.valueOf("199103"), "（申込Ｆ）募集年月");
        exDateEquals(mousikomiFSakuinKekkaLst.get(1).getMosftaisyouseiymd(), BizDate.valueOf("19811206"),
            "（申込Ｆ）対象者生年月日");


        exStringEquals(mousikomiFSakuinKekkaLst.get(2).getMosfmosno(),
            "791112220", "（申込Ｆ）申込番号");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(2).getMosfmoskankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（申込Ｆ）申込関係者区分");

        exStringEquals(mousikomiFSakuinKekkaLst.get(2).getMosfmofkojinkbn(),
            "01", "（申込Ｆ）申込Ｆ個人区分");
        exClassificationEquals(mousikomiFSakuinKekkaLst.get(2).getMosfmfrenflg(),
            C_Mfrenflg.SUMI, "（申込Ｆ）ＭＦ連動済フラグ");
        exDateEquals(mousikomiFSakuinKekkaLst.get(2).getMosfmosymd(), BizDate.valueOf("19921112"), "（申込Ｆ）申込日");
        exDateEquals(mousikomiFSakuinKekkaLst.get(2).getMosfkykymd(), BizDate.valueOf("19921201"), "（申込Ｆ）契約日");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(2).getMosfmossyoumetukbn(),
            C_MossyoumetuKbn.SEIRITU, "（申込Ｆ）申込消滅区分");
        exDateEquals(mousikomiFSakuinKekkaLst.get(2).getMosfmossyoumetukktiymd(), BizDate.valueOf("19920105"),
            "（申込Ｆ）申込消滅確定日");

        exDateYMEquals(mousikomiFSakuinKekkaLst.get(2).getMosfbosyuuym(), BizDateYM.valueOf("199203"), "（申込Ｆ）募集年月");
        exDateEquals(mousikomiFSakuinKekkaLst.get(2).getMosftaisyouseiymd(), BizDate.valueOf("19821206"),
            "（申込Ｆ）対象者生年月日");


        exStringEquals(mousikomiFSakuinKekkaLst.get(3).getMosfmosno(),
            "791112220", "（申込Ｆ）申込番号");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(3).getMosfmoskankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（申込Ｆ）申込関係者区分");

        exStringEquals(mousikomiFSakuinKekkaLst.get(3).getMosfmofkojinkbn(),
            "01", "（申込Ｆ）申込Ｆ個人区分");
        exClassificationEquals(mousikomiFSakuinKekkaLst.get(3).getMosfmfrenflg(),
            C_Mfrenflg.SUMI, "（申込Ｆ）ＭＦ連動済フラグ");
        exDateEquals(mousikomiFSakuinKekkaLst.get(3).getMosfmosymd(), BizDate.valueOf("19931112"), "（申込Ｆ）申込日");
        exDateEquals(mousikomiFSakuinKekkaLst.get(3).getMosfkykymd(), BizDate.valueOf("19931201"), "（申込Ｆ）契約日");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(3).getMosfmossyoumetukbn(),
            C_MossyoumetuKbn.SEIRITU, "（申込Ｆ）申込消滅区分");
        exDateEquals(mousikomiFSakuinKekkaLst.get(3).getMosfmossyoumetukktiymd(), BizDate.valueOf("19930105"),
            "（申込Ｆ）申込消滅確定日");

        exDateYMEquals(mousikomiFSakuinKekkaLst.get(3).getMosfbosyuuym(), BizDateYM.valueOf("199303"), "（申込Ｆ）募集年月");
        exDateEquals(mousikomiFSakuinKekkaLst.get(3).getMosftaisyouseiymd(), BizDate.valueOf("19831206"),
            "（申込Ｆ）対象者生年月日");

        exStringEquals(mousikomiFSakuinKekkaLst.get(4).getMosfmosno(),
            "791112220", "（申込Ｆ）申込番号");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(4).getMosfmoskankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（申込Ｆ）申込関係者区分");

        exStringEquals(mousikomiFSakuinKekkaLst.get(4).getMosfmofkojinkbn(),
            "01", "（申込Ｆ）申込Ｆ個人区分");
        exClassificationEquals(mousikomiFSakuinKekkaLst.get(4).getMosfmfrenflg(),
            C_Mfrenflg.SUMI, "（申込Ｆ）ＭＦ連動済フラグ");
        exDateEquals(mousikomiFSakuinKekkaLst.get(4).getMosfmosymd(), BizDate.valueOf("19941112"), "（申込Ｆ）申込日");
        exDateEquals(mousikomiFSakuinKekkaLst.get(4).getMosfkykymd(), BizDate.valueOf("19941201"), "（申込Ｆ）契約日");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(4).getMosfmossyoumetukbn(),
            C_MossyoumetuKbn.SEIRITU, "（申込Ｆ）申込消滅区分");
        exDateEquals(mousikomiFSakuinKekkaLst.get(4).getMosfmossyoumetukktiymd(), BizDate.valueOf("19940105"),
            "（申込Ｆ）申込消滅確定日");

        exDateYMEquals(mousikomiFSakuinKekkaLst.get(4).getMosfbosyuuym(), BizDateYM.valueOf("199403"), "（申込Ｆ）募集年月");
        exDateEquals(mousikomiFSakuinKekkaLst.get(4).getMosftaisyouseiymd(), BizDate.valueOf("19841206"),
            "（申込Ｆ）対象者生年月日");


        exStringEquals(mousikomiFSakuinKekkaLst.get(5).getMosfmosno(),
            "791112220", "（申込Ｆ）申込番号");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(5).getMosfmoskankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（申込Ｆ）申込関係者区分");

        exStringEquals(mousikomiFSakuinKekkaLst.get(5).getMosfmofkojinkbn(),
            "01", "（申込Ｆ）申込Ｆ個人区分");
        exClassificationEquals(mousikomiFSakuinKekkaLst.get(5).getMosfmfrenflg(),
            C_Mfrenflg.SUMI, "（申込Ｆ）ＭＦ連動済フラグ");
        exDateEquals(mousikomiFSakuinKekkaLst.get(5).getMosfmosymd(), BizDate.valueOf("19951112"), "（申込Ｆ）申込日");
        exDateEquals(mousikomiFSakuinKekkaLst.get(5).getMosfkykymd(), BizDate.valueOf("19951201"), "（申込Ｆ）契約日");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(5).getMosfmossyoumetukbn(),
            C_MossyoumetuKbn.SEIRITU, "（申込Ｆ）申込消滅区分");
        exDateEquals(mousikomiFSakuinKekkaLst.get(5).getMosfmossyoumetukktiymd(), BizDate.valueOf("19950105"),
            "（申込Ｆ）申込消滅確定日");

        exDateYMEquals(mousikomiFSakuinKekkaLst.get(5).getMosfbosyuuym(), BizDateYM.valueOf("199503"), "（申込Ｆ）募集年月");
        exDateEquals(mousikomiFSakuinKekkaLst.get(5).getMosftaisyouseiymd(), BizDate.valueOf("19851206"),
            "（申込Ｆ）対象者生年月日");


        exStringEquals(mousikomiFSakuinKekkaLst.get(6).getMosfmosno(),
            "791112220", "（申込Ｆ）申込番号");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(6).getMosfmoskankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（申込Ｆ）申込関係者区分");

        exStringEquals(mousikomiFSakuinKekkaLst.get(6).getMosfmofkojinkbn(),
            "01", "（申込Ｆ）申込Ｆ個人区分");
        exClassificationEquals(mousikomiFSakuinKekkaLst.get(6).getMosfmfrenflg(),
            C_Mfrenflg.SUMI, "（申込Ｆ）ＭＦ連動済フラグ");
        exDateEquals(mousikomiFSakuinKekkaLst.get(6).getMosfmosymd(), BizDate.valueOf("19961112"), "（申込Ｆ）申込日");
        exDateEquals(mousikomiFSakuinKekkaLst.get(6).getMosfkykymd(), BizDate.valueOf("19961201"), "（申込Ｆ）契約日");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(6).getMosfmossyoumetukbn(),
            C_MossyoumetuKbn.SEIRITU, "（申込Ｆ）申込消滅区分");
        exDateEquals(mousikomiFSakuinKekkaLst.get(6).getMosfmossyoumetukktiymd(), BizDate.valueOf("19960105"),
            "（申込Ｆ）申込消滅確定日");

        exDateYMEquals(mousikomiFSakuinKekkaLst.get(6).getMosfbosyuuym(), BizDateYM.valueOf("199603"), "（申込Ｆ）募集年月");
        exDateEquals(mousikomiFSakuinKekkaLst.get(6).getMosftaisyouseiymd(), BizDate.valueOf("19861206"),
            "（申込Ｆ）対象者生年月日");


        exStringEquals(mousikomiFSakuinKekkaLst.get(7).getMosfmosno(),
            "791112220", "（申込Ｆ）申込番号");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(7).getMosfmoskankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（申込Ｆ）申込関係者区分");

        exStringEquals(mousikomiFSakuinKekkaLst.get(7).getMosfmofkojinkbn(),
            "01", "（申込Ｆ）申込Ｆ個人区分");
        exClassificationEquals(mousikomiFSakuinKekkaLst.get(7).getMosfmfrenflg(),
            C_Mfrenflg.SUMI, "（申込Ｆ）ＭＦ連動済フラグ");
        exDateEquals(mousikomiFSakuinKekkaLst.get(7).getMosfmosymd(), BizDate.valueOf("19971112"), "（申込Ｆ）申込日");
        exDateEquals(mousikomiFSakuinKekkaLst.get(7).getMosfkykymd(), BizDate.valueOf("19971201"), "（申込Ｆ）契約日");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(7).getMosfmossyoumetukbn(),
            C_MossyoumetuKbn.SEIRITU, "（申込Ｆ）申込消滅区分");
        exDateEquals(mousikomiFSakuinKekkaLst.get(7).getMosfmossyoumetukktiymd(), BizDate.valueOf("19970105"),
            "（申込Ｆ）申込消滅確定日");

        exDateYMEquals(mousikomiFSakuinKekkaLst.get(7).getMosfbosyuuym(), BizDateYM.valueOf("199703"), "（申込Ｆ）募集年月");
        exDateEquals(mousikomiFSakuinKekkaLst.get(7).getMosftaisyouseiymd(), BizDate.valueOf("19871206"),
            "（申込Ｆ）対象者生年月日");

        exStringEquals(mousikomiFSakuinKekkaLst.get(8).getMosfmosno(),
            "791112220", "（申込Ｆ）申込番号");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(8).getMosfmoskankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（申込Ｆ）申込関係者区分");

        exStringEquals(mousikomiFSakuinKekkaLst.get(8).getMosfmofkojinkbn(),
            "01", "（申込Ｆ）申込Ｆ個人区分");
        exClassificationEquals(mousikomiFSakuinKekkaLst.get(8).getMosfmfrenflg(),
            C_Mfrenflg.SUMI, "（申込Ｆ）ＭＦ連動済フラグ");
        exDateEquals(mousikomiFSakuinKekkaLst.get(8).getMosfmosymd(), BizDate.valueOf("19981112"), "（申込Ｆ）申込日");
        exDateEquals(mousikomiFSakuinKekkaLst.get(8).getMosfkykymd(), BizDate.valueOf("19981201"), "（申込Ｆ）契約日");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(8).getMosfmossyoumetukbn(),
            C_MossyoumetuKbn.SEIRITU, "（申込Ｆ）申込消滅区分");
        exDateEquals(mousikomiFSakuinKekkaLst.get(8).getMosfmossyoumetukktiymd(), BizDate.valueOf("19980105"),
            "（申込Ｆ）申込消滅確定日");

        exDateYMEquals(mousikomiFSakuinKekkaLst.get(8).getMosfbosyuuym(), BizDateYM.valueOf("199803"), "（申込Ｆ）募集年月");
        exDateEquals(mousikomiFSakuinKekkaLst.get(8).getMosftaisyouseiymd(), BizDate.valueOf("19881206"),
            "（申込Ｆ）対象者生年月日");

        exStringEquals(mousikomiFSakuinKekkaLst.get(9).getMosfmosno(),
            "791112220", "（申込Ｆ）申込番号");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(9).getMosfmoskankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（申込Ｆ）申込関係者区分");

        exStringEquals(mousikomiFSakuinKekkaLst.get(9).getMosfmofkojinkbn(),
            "01", "（申込Ｆ）申込Ｆ個人区分");
        exClassificationEquals(mousikomiFSakuinKekkaLst.get(9).getMosfmfrenflg(),
            C_Mfrenflg.SUMI, "（申込Ｆ）ＭＦ連動済フラグ");
        exDateEquals(mousikomiFSakuinKekkaLst.get(9).getMosfmosymd(), BizDate.valueOf("19991112"), "（申込Ｆ）申込日");
        exDateEquals(mousikomiFSakuinKekkaLst.get(9).getMosfkykymd(), BizDate.valueOf("19991201"), "（申込Ｆ）契約日");

        exClassificationEquals(mousikomiFSakuinKekkaLst.get(9).getMosfmossyoumetukbn(),
            C_MossyoumetuKbn.SEIRITU, "（申込Ｆ）申込消滅区分");
        exDateEquals(mousikomiFSakuinKekkaLst.get(9).getMosfmossyoumetukktiymd(), BizDate.valueOf("19990105"),
            "（申込Ｆ）申込消滅確定日");

        exDateYMEquals(mousikomiFSakuinKekkaLst.get(9).getMosfbosyuuym(), BizDateYM.valueOf("199903"), "（申込Ｆ）募集年月");
        exDateEquals(mousikomiFSakuinKekkaLst.get(9).getMosftaisyouseiymd(), BizDate.valueOf("19891206"),
            "（申込Ｆ）対象者生年月日");


        List<BzSentakuInfoFSakuinKekkaBean> sakuinTsnSyoukaiKekkaLst =
            bzSakuinTsnSyoukaiKekkaBean.getBzsentakuinfofsakuinkekkabeanlist();
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getBzsentakuinfofsakuinkekkabeanlist().size(), 10,
            "選択情報Ｆ索引結果Beanリストのサイズ");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(0).getSntkinfono(),
            "10000000003", "選択情報番号");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getSntkinfokankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "選択情報関係者区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(0).getSntkinfofkojinkbn(),
            "02", "選択情報Ｆ個人区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getSntkinfokbn(),
            C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sakuinTsnSyoukaiKekkaLst.get(0).getSntkinfosakuseiymd(), BizDate.valueOf("20010310"), "選択情報作成日");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getMrumukbn(),
            C_BlnktkumuKbn.ARI, "ＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getDecumukbn(),
            C_BlnktkumuKbn.ARI, "ＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getInfokoukanumukbn(),
            C_BlnktkumuKbn.ARI, "情報交換有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getNyuuinkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "入院給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getSyujyutukyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "手術給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getSyougaikyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "障害給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getKoudosyougaiumukbn(),
            C_BlnktkumuKbn.ARI, "高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getPmenumukbn(),
            C_BlnktkumuKbn.ARI, "Ｐ免有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getTorikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "取消解除有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getSoukikeakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "早期ケア給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getSonotakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "その他給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getKghsjjtkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "介護保障充実給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getHuho2mrumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getHuho2decumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getHuho2kdumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(0).getHuho2torikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ取消解除有無区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(1).getSntkinfono(),
            "10000000003", "選択情報番号");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getSntkinfokankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "選択情報関係者区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(1).getSntkinfofkojinkbn(),
            "02", "選択情報Ｆ個人区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getSntkinfokbn(),
            C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sakuinTsnSyoukaiKekkaLst.get(1).getSntkinfosakuseiymd(), BizDate.valueOf("20010311"), "選択情報作成日");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getMrumukbn(),
            C_BlnktkumuKbn.ARI, "ＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getDecumukbn(),
            C_BlnktkumuKbn.ARI, "ＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getInfokoukanumukbn(),
            C_BlnktkumuKbn.ARI, "情報交換有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getNyuuinkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "入院給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getSyujyutukyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "手術給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getSyougaikyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "障害給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getKoudosyougaiumukbn(),
            C_BlnktkumuKbn.ARI, "高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getPmenumukbn(),
            C_BlnktkumuKbn.ARI, "Ｐ免有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getTorikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "取消解除有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getSoukikeakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "早期ケア給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getSonotakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "その他給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getKghsjjtkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "介護保障充実給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getHuho2mrumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getHuho2decumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getHuho2kdumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(1).getHuho2torikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ取消解除有無区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(2).getSntkinfono(),
            "10000000003", "選択情報番号");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getSntkinfokankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "選択情報関係者区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(2).getSntkinfofkojinkbn(),
            "02", "選択情報Ｆ個人区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getSntkinfokbn(),
            C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sakuinTsnSyoukaiKekkaLst.get(2).getSntkinfosakuseiymd(), BizDate.valueOf("20010312"), "選択情報作成日");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getMrumukbn(),
            C_BlnktkumuKbn.ARI, "ＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getDecumukbn(),
            C_BlnktkumuKbn.ARI, "ＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getInfokoukanumukbn(),
            C_BlnktkumuKbn.ARI, "情報交換有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getNyuuinkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "入院給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getSyujyutukyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "手術給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getSyougaikyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "障害給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getKoudosyougaiumukbn(),
            C_BlnktkumuKbn.ARI, "高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getPmenumukbn(),
            C_BlnktkumuKbn.ARI, "Ｐ免有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getTorikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "取消解除有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getSoukikeakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "早期ケア給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getSonotakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "その他給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getKghsjjtkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "介護保障充実給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getHuho2mrumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getHuho2decumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getHuho2kdumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(2).getHuho2torikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ取消解除有無区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(3).getSntkinfono(),
            "10000000003", "選択情報番号");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getSntkinfokankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "選択情報関係者区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(3).getSntkinfofkojinkbn(),
            "02", "選択情報Ｆ個人区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getSntkinfokbn(),
            C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sakuinTsnSyoukaiKekkaLst.get(3).getSntkinfosakuseiymd(), BizDate.valueOf("20010313"), "選択情報作成日");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getMrumukbn(),
            C_BlnktkumuKbn.ARI, "ＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getDecumukbn(),
            C_BlnktkumuKbn.ARI, "ＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getInfokoukanumukbn(),
            C_BlnktkumuKbn.ARI, "情報交換有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getNyuuinkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "入院給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getSyujyutukyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "手術給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getSyougaikyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "障害給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getKoudosyougaiumukbn(),
            C_BlnktkumuKbn.ARI, "高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getPmenumukbn(),
            C_BlnktkumuKbn.ARI, "Ｐ免有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getTorikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "取消解除有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getSoukikeakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "早期ケア給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getSonotakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "その他給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getKghsjjtkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "介護保障充実給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getHuho2mrumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getHuho2decumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getHuho2kdumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(3).getHuho2torikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ取消解除有無区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(4).getSntkinfono(),
            "10000000003", "選択情報番号");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getSntkinfokankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "選択情報関係者区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(4).getSntkinfofkojinkbn(),
            "02", "選択情報Ｆ個人区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getSntkinfokbn(),
            C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sakuinTsnSyoukaiKekkaLst.get(4).getSntkinfosakuseiymd(), BizDate.valueOf("20010314"), "選択情報作成日");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getMrumukbn(),
            C_BlnktkumuKbn.ARI, "ＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getDecumukbn(),
            C_BlnktkumuKbn.ARI, "ＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getInfokoukanumukbn(),
            C_BlnktkumuKbn.ARI, "情報交換有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getNyuuinkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "入院給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getSyujyutukyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "手術給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getSyougaikyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "障害給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getKoudosyougaiumukbn(),
            C_BlnktkumuKbn.ARI, "高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getPmenumukbn(),
            C_BlnktkumuKbn.ARI, "Ｐ免有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getTorikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "取消解除有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getSoukikeakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "早期ケア給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getSonotakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "その他給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getKghsjjtkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "介護保障充実給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getHuho2mrumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getHuho2decumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getHuho2kdumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(4).getHuho2torikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ取消解除有無区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(5).getSntkinfono(),
            "10000000003", "選択情報番号");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getSntkinfokankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "選択情報関係者区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(5).getSntkinfofkojinkbn(),
            "02", "選択情報Ｆ個人区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getSntkinfokbn(),
            C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sakuinTsnSyoukaiKekkaLst.get(5).getSntkinfosakuseiymd(), BizDate.valueOf("20010315"), "選択情報作成日");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getMrumukbn(),
            C_BlnktkumuKbn.ARI, "ＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getDecumukbn(),
            C_BlnktkumuKbn.ARI, "ＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getInfokoukanumukbn(),
            C_BlnktkumuKbn.ARI, "情報交換有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getNyuuinkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "入院給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getSyujyutukyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "手術給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getSyougaikyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "障害給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getKoudosyougaiumukbn(),
            C_BlnktkumuKbn.ARI, "高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getPmenumukbn(),
            C_BlnktkumuKbn.ARI, "Ｐ免有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getTorikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "取消解除有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getSoukikeakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "早期ケア給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getSonotakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "その他給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getKghsjjtkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "介護保障充実給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getHuho2mrumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getHuho2decumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getHuho2kdumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(5).getHuho2torikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ取消解除有無区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(6).getSntkinfono(),
            "10000000003", "選択情報番号");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getSntkinfokankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "選択情報関係者区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(6).getSntkinfofkojinkbn(),
            "02", "選択情報Ｆ個人区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getSntkinfokbn(),
            C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sakuinTsnSyoukaiKekkaLst.get(6).getSntkinfosakuseiymd(), BizDate.valueOf("20010316"), "選択情報作成日");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getMrumukbn(),
            C_BlnktkumuKbn.ARI, "ＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getDecumukbn(),
            C_BlnktkumuKbn.ARI, "ＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getInfokoukanumukbn(),
            C_BlnktkumuKbn.ARI, "情報交換有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getNyuuinkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "入院給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getSyujyutukyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "手術給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getSyougaikyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "障害給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getKoudosyougaiumukbn(),
            C_BlnktkumuKbn.ARI, "高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getPmenumukbn(),
            C_BlnktkumuKbn.ARI, "Ｐ免有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getTorikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "取消解除有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getSoukikeakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "早期ケア給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getSonotakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "その他給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getKghsjjtkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "介護保障充実給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getHuho2mrumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getHuho2decumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getHuho2kdumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(6).getHuho2torikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ取消解除有無区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(7).getSntkinfono(),
            "10000000003", "選択情報番号");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getSntkinfokankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "選択情報関係者区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(7).getSntkinfofkojinkbn(),
            "02", "選択情報Ｆ個人区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getSntkinfokbn(),
            C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sakuinTsnSyoukaiKekkaLst.get(7).getSntkinfosakuseiymd(), BizDate.valueOf("20010317"), "選択情報作成日");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getMrumukbn(),
            C_BlnktkumuKbn.ARI, "ＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getDecumukbn(),
            C_BlnktkumuKbn.ARI, "ＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getInfokoukanumukbn(),
            C_BlnktkumuKbn.ARI, "情報交換有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getNyuuinkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "入院給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getSyujyutukyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "手術給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getSyougaikyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "障害給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getKoudosyougaiumukbn(),
            C_BlnktkumuKbn.ARI, "高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getPmenumukbn(),
            C_BlnktkumuKbn.ARI, "Ｐ免有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getTorikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "取消解除有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getSoukikeakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "早期ケア給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getSonotakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "その他給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getKghsjjtkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "介護保障充実給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getHuho2mrumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getHuho2decumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getHuho2kdumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(7).getHuho2torikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ取消解除有無区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(8).getSntkinfono(),
            "10000000003", "選択情報番号");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getSntkinfokankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "選択情報関係者区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(8).getSntkinfofkojinkbn(),
            "02", "選択情報Ｆ個人区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getSntkinfokbn(),
            C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sakuinTsnSyoukaiKekkaLst.get(8).getSntkinfosakuseiymd(), BizDate.valueOf("20010318"), "選択情報作成日");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getMrumukbn(),
            C_BlnktkumuKbn.ARI, "ＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getDecumukbn(),
            C_BlnktkumuKbn.ARI, "ＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getInfokoukanumukbn(),
            C_BlnktkumuKbn.ARI, "情報交換有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getNyuuinkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "入院給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getSyujyutukyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "手術給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getSyougaikyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "障害給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getKoudosyougaiumukbn(),
            C_BlnktkumuKbn.ARI, "高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getPmenumukbn(),
            C_BlnktkumuKbn.ARI, "Ｐ免有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getTorikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "取消解除有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getSoukikeakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "早期ケア給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getSonotakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "その他給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getKghsjjtkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "介護保障充実給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getHuho2mrumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getHuho2decumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getHuho2kdumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(8).getHuho2torikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ取消解除有無区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(9).getSntkinfono(),
            "10000000003", "選択情報番号");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getSntkinfokankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "選択情報関係者区分");

        exStringEquals(sakuinTsnSyoukaiKekkaLst.get(9).getSntkinfofkojinkbn(),
            "02", "選択情報Ｆ個人区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getSntkinfokbn(),
            C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sakuinTsnSyoukaiKekkaLst.get(9).getSntkinfosakuseiymd(), BizDate.valueOf("20010319"), "選択情報作成日");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getMrumukbn(),
            C_BlnktkumuKbn.ARI, "ＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getDecumukbn(),
            C_BlnktkumuKbn.ARI, "ＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getInfokoukanumukbn(),
            C_BlnktkumuKbn.ARI, "情報交換有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getNyuuinkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "入院給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getSyujyutukyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "手術給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getSyougaikyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "障害給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getKoudosyougaiumukbn(),
            C_BlnktkumuKbn.ARI, "高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getPmenumukbn(),
            C_BlnktkumuKbn.ARI, "Ｐ免有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getTorikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "取消解除有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getSoukikeakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "早期ケア給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getSonotakyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "その他給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getKghsjjtkyhkshrumukbn(),
            C_BlnktkumuKbn.ARI, "介護保障充実給付金支払有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getHuho2mrumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＭＲ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getHuho2decumukbn(),
            C_BlnktkumuKbn.ARI, "普保ⅡＤＥＣ有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getHuho2kdumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ高度障害有無区分");

        exClassificationEquals(sakuinTsnSyoukaiKekkaLst.get(9).getHuho2torikaijoumukbn(),
            C_BlnktkumuKbn.ARI, "普保Ⅱ取消解除有無区分");


        List<BzHokenkinSueokiFSakuinKekkaBean> hokenkinSueokFLst = bzSakuinTsnSyoukaiKekkaBean
            .getBzhokenkinsueokifsakuinkekkabeanlist();
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getBzhokenkinsueokifsakuinkekkabeanlist().size(), 10,
            "保険金据置Ｆ索引結果Beanリストのサイズ");

        exStringEquals(hokenkinSueokFLst.get(0).getSueokifsysyno(), "11807111174", "（据置Ｆ）証書番号");

        exClassificationEquals(hokenkinSueokFLst.get(0).getSueokifhknkinkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（据置Ｆ）保険金据置関係者区分");

        exStringEquals(hokenkinSueokFLst.get(0).getSueokifhknkinkojinkbn(),
            "01", "（据置Ｆ）保険金据置Ｆ個人区分");

        exClassificationEquals(hokenkinSueokFLst.get(0).getSueokifsueokijtkbn(),
            C_SueokiJyoutaiKbn.MANRYOU, "（据置Ｆ）据置状態区分");
        exDateEquals(hokenkinSueokFLst.get(0).getSueokifsueokikaisiymd(), BizDate.valueOf("20000327"), "（据置Ｆ）据置開始日");
        exNumericEquals(hokenkinSueokFLst.get(0).getSueokifsueokikkn(), 12, "（据置Ｆ）据置期間");
        exDateEquals(hokenkinSueokFLst.get(0).getSueokifuktseiymd(), BizDate.valueOf("19900127"), "（据置Ｆ）受取人生年月日");

        exStringEquals(hokenkinSueokFLst.get(1).getSueokifsysyno(), "11807111174", "（据置Ｆ）証書番号");

        exClassificationEquals(hokenkinSueokFLst.get(1).getSueokifhknkinkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（据置Ｆ）保険金据置関係者区分");

        exStringEquals(hokenkinSueokFLst.get(1).getSueokifhknkinkojinkbn(),
            "01", "（据置Ｆ）保険金据置Ｆ個人区分");

        exClassificationEquals(hokenkinSueokFLst.get(1).getSueokifsueokijtkbn(),
            C_SueokiJyoutaiKbn.MANRYOU, "（据置Ｆ）据置状態区分");
        exDateEquals(hokenkinSueokFLst.get(1).getSueokifsueokikaisiymd(), BizDate.valueOf("20010327"), "（据置Ｆ）据置開始日");
        exNumericEquals(hokenkinSueokFLst.get(1).getSueokifsueokikkn(), 12, "（据置Ｆ）据置期間");
        exDateEquals(hokenkinSueokFLst.get(1).getSueokifuktseiymd(), BizDate.valueOf("19910127"), "（据置Ｆ）受取人生年月日");

        exStringEquals(hokenkinSueokFLst.get(2).getSueokifsysyno(), "11807111174", "（据置Ｆ）証書番号");

        exClassificationEquals(hokenkinSueokFLst.get(2).getSueokifhknkinkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（据置Ｆ）保険金据置関係者区分");

        exStringEquals(hokenkinSueokFLst.get(2).getSueokifhknkinkojinkbn(),
            "01", "（据置Ｆ）保険金据置Ｆ個人区分");

        exClassificationEquals(hokenkinSueokFLst.get(2).getSueokifsueokijtkbn(),
            C_SueokiJyoutaiKbn.MANRYOU, "（据置Ｆ）据置状態区分");
        exDateEquals(hokenkinSueokFLst.get(2).getSueokifsueokikaisiymd(), BizDate.valueOf("20020327"), "（据置Ｆ）据置開始日");
        exNumericEquals(hokenkinSueokFLst.get(2).getSueokifsueokikkn(), 12, "（据置Ｆ）据置期間");
        exDateEquals(hokenkinSueokFLst.get(2).getSueokifuktseiymd(), BizDate.valueOf("19920127"), "（据置Ｆ）受取人生年月日");

        exStringEquals(hokenkinSueokFLst.get(3).getSueokifsysyno(), "11807111174", "（据置Ｆ）証書番号");

        exClassificationEquals(hokenkinSueokFLst.get(3).getSueokifhknkinkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（据置Ｆ）保険金据置関係者区分");

        exStringEquals(hokenkinSueokFLst.get(3).getSueokifhknkinkojinkbn(),
            "01", "（据置Ｆ）保険金据置Ｆ個人区分");

        exClassificationEquals(hokenkinSueokFLst.get(3).getSueokifsueokijtkbn(),
            C_SueokiJyoutaiKbn.MANRYOU, "（据置Ｆ）据置状態区分");
        exDateEquals(hokenkinSueokFLst.get(3).getSueokifsueokikaisiymd(), BizDate.valueOf("20030327"), "（据置Ｆ）据置開始日");
        exNumericEquals(hokenkinSueokFLst.get(3).getSueokifsueokikkn(), 12, "（据置Ｆ）据置期間");
        exDateEquals(hokenkinSueokFLst.get(3).getSueokifuktseiymd(), BizDate.valueOf("19930127"), "（据置Ｆ）受取人生年月日");

        exStringEquals(hokenkinSueokFLst.get(4).getSueokifsysyno(), "11807111174", "（据置Ｆ）証書番号");

        exClassificationEquals(hokenkinSueokFLst.get(4).getSueokifhknkinkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（据置Ｆ）保険金据置関係者区分");

        exStringEquals(hokenkinSueokFLst.get(4).getSueokifhknkinkojinkbn(),
            "01", "（据置Ｆ）保険金据置Ｆ個人区分");

        exClassificationEquals(hokenkinSueokFLst.get(4).getSueokifsueokijtkbn(),
            C_SueokiJyoutaiKbn.MANRYOU, "（据置Ｆ）据置状態区分");
        exDateEquals(hokenkinSueokFLst.get(4).getSueokifsueokikaisiymd(), BizDate.valueOf("20040327"), "（据置Ｆ）据置開始日");
        exNumericEquals(hokenkinSueokFLst.get(4).getSueokifsueokikkn(), 12, "（据置Ｆ）据置期間");
        exDateEquals(hokenkinSueokFLst.get(4).getSueokifuktseiymd(), BizDate.valueOf("19940127"), "（据置Ｆ）受取人生年月日");

        exStringEquals(hokenkinSueokFLst.get(5).getSueokifsysyno(), "11807111174", "（据置Ｆ）証書番号");

        exClassificationEquals(hokenkinSueokFLst.get(5).getSueokifhknkinkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（据置Ｆ）保険金据置関係者区分");

        exStringEquals(hokenkinSueokFLst.get(5).getSueokifhknkinkojinkbn(),
            "01", "（据置Ｆ）保険金据置Ｆ個人区分");

        exClassificationEquals(hokenkinSueokFLst.get(5).getSueokifsueokijtkbn(),
            C_SueokiJyoutaiKbn.MANRYOU, "（据置Ｆ）据置状態区分");
        exDateEquals(hokenkinSueokFLst.get(5).getSueokifsueokikaisiymd(), BizDate.valueOf("20050327"), "（据置Ｆ）据置開始日");
        exNumericEquals(hokenkinSueokFLst.get(5).getSueokifsueokikkn(), 12, "（据置Ｆ）据置期間");
        exDateEquals(hokenkinSueokFLst.get(5).getSueokifuktseiymd(), BizDate.valueOf("19950127"), "（据置Ｆ）受取人生年月日");

        exStringEquals(hokenkinSueokFLst.get(6).getSueokifsysyno(), "11807111174", "（据置Ｆ）証書番号");

        exClassificationEquals(hokenkinSueokFLst.get(6).getSueokifhknkinkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（据置Ｆ）保険金据置関係者区分");

        exStringEquals(hokenkinSueokFLst.get(6).getSueokifhknkinkojinkbn(),
            "01", "（据置Ｆ）保険金据置Ｆ個人区分");

        exClassificationEquals(hokenkinSueokFLst.get(6).getSueokifsueokijtkbn(),
            C_SueokiJyoutaiKbn.MANRYOU, "（据置Ｆ）据置状態区分");
        exDateEquals(hokenkinSueokFLst.get(6).getSueokifsueokikaisiymd(), BizDate.valueOf("20060327"), "（据置Ｆ）据置開始日");
        exNumericEquals(hokenkinSueokFLst.get(6).getSueokifsueokikkn(), 12, "（据置Ｆ）据置期間");
        exDateEquals(hokenkinSueokFLst.get(6).getSueokifuktseiymd(), BizDate.valueOf("19960127"), "（据置Ｆ）受取人生年月日");

        exStringEquals(hokenkinSueokFLst.get(7).getSueokifsysyno(), "11807111174", "（据置Ｆ）証書番号");

        exClassificationEquals(hokenkinSueokFLst.get(7).getSueokifhknkinkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（据置Ｆ）保険金据置関係者区分");

        exStringEquals(hokenkinSueokFLst.get(7).getSueokifhknkinkojinkbn(),
            "01", "（据置Ｆ）保険金据置Ｆ個人区分");

        exClassificationEquals(hokenkinSueokFLst.get(7).getSueokifsueokijtkbn(),
            C_SueokiJyoutaiKbn.MANRYOU, "（据置Ｆ）据置状態区分");
        exDateEquals(hokenkinSueokFLst.get(7).getSueokifsueokikaisiymd(), BizDate.valueOf("20070327"), "（据置Ｆ）据置開始日");
        exNumericEquals(hokenkinSueokFLst.get(7).getSueokifsueokikkn(), 12, "（据置Ｆ）据置期間");
        exDateEquals(hokenkinSueokFLst.get(7).getSueokifuktseiymd(), BizDate.valueOf("19970127"), "（据置Ｆ）受取人生年月日");

        exStringEquals(hokenkinSueokFLst.get(8).getSueokifsysyno(), "11807111174", "（据置Ｆ）証書番号");

        exClassificationEquals(hokenkinSueokFLst.get(8).getSueokifhknkinkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（据置Ｆ）保険金据置関係者区分");

        exStringEquals(hokenkinSueokFLst.get(8).getSueokifhknkinkojinkbn(),
            "01", "（据置Ｆ）保険金据置Ｆ個人区分");

        exClassificationEquals(hokenkinSueokFLst.get(8).getSueokifsueokijtkbn(),
            C_SueokiJyoutaiKbn.MANRYOU, "（据置Ｆ）据置状態区分");
        exDateEquals(hokenkinSueokFLst.get(8).getSueokifsueokikaisiymd(), BizDate.valueOf("20080327"), "（据置Ｆ）据置開始日");
        exNumericEquals(hokenkinSueokFLst.get(8).getSueokifsueokikkn(), 12, "（据置Ｆ）据置期間");
        exDateEquals(hokenkinSueokFLst.get(8).getSueokifuktseiymd(), BizDate.valueOf("19980127"), "（据置Ｆ）受取人生年月日");

        exStringEquals(hokenkinSueokFLst.get(9).getSueokifsysyno(), "11807111174", "（据置Ｆ）証書番号");

        exClassificationEquals(hokenkinSueokFLst.get(9).getSueokifhknkinkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（据置Ｆ）保険金据置関係者区分");

        exStringEquals(hokenkinSueokFLst.get(9).getSueokifhknkinkojinkbn(),
            "01", "（据置Ｆ）保険金据置Ｆ個人区分");

        exClassificationEquals(hokenkinSueokFLst.get(9).getSueokifsueokijtkbn(),
            C_SueokiJyoutaiKbn.MANRYOU, "（据置Ｆ）据置状態区分");
        exDateEquals(hokenkinSueokFLst.get(9).getSueokifsueokikaisiymd(), BizDate.valueOf("20090327"), "（据置Ｆ）据置開始日");
        exNumericEquals(hokenkinSueokFLst.get(9).getSueokifsueokikkn(), 12, "（据置Ｆ）据置期間");
        exDateEquals(hokenkinSueokFLst.get(9).getSueokifuktseiymd(), BizDate.valueOf("19990127"), "（据置Ｆ）受取人生年月日");


        List<BzSougouNenkinSiharaiFSakuinKekkaBean> sougouNenkinSiharaiFSakuinKekkaLst =
            bzSakuinTsnSyoukaiKekkaBean.getBzsougounenkinsiharaifsakuinkekkabeanlist();
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getBzsougounenkinsiharaifsakuinkekkabeanlist().size(),
            10, "総合年金支払Ｆ索引結果Beanリストのサイズ");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(0).getSounenfnksysyno(), "11807111211", "（総年Ｆ）年金証書番号");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(0).getSounenfnkkankeisyakbn(),
            C_NkKankeisyaKbn.NKUKT, "（総年Ｆ）年金支払関係者区分");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(0).getSounenfsougounkfkojinkbn(), "04",
            "（総年Ｆ）総合年金支払Ｆ個人区分");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(0).getSounenfkykjyoutaikbn(),
            C_SounenfKykJyoutaiKbn.SYOUMETU_SIBOU, "（総年Ｆ）契約状態区分");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(0).getSounenfsyokainkshrymd(),
            BizDate.valueOf("20021220"), "（総年Ｆ）初回年金支払日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(0).getSounenfkykymd(),
            BizDate.valueOf("20021120"), "（総年Ｆ）契約日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(0).getSounenfnksyoumetucd(),
            "11", "（総年Ｆ）年金消滅コード");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(0).getSounenfsyoumetuymd(),
            BizDate.valueOf("20010410"), "（総年Ｆ）消滅日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(0).getSounenftaisyouseiymd(),
            BizDate.valueOf("19940610"), "（総年Ｆ）対象者生年月日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(1).getSounenfnksysyno(), "11807111211", "（総年Ｆ）年金証書番号");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(1).getSounenfnkkankeisyakbn(),
            C_NkKankeisyaKbn.NKUKT, "（総年Ｆ）年金支払関係者区分");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(1).getSounenfsougounkfkojinkbn(), "04",
            "（総年Ｆ）総合年金支払Ｆ個人区分");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(1).getSounenfkykjyoutaikbn(),
            C_SounenfKykJyoutaiKbn.SYOUMETU_SIBOU, "（総年Ｆ）契約状態区分");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(1).getSounenfsyokainkshrymd(),
            BizDate.valueOf("20021221"), "（総年Ｆ）初回年金支払日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(1).getSounenfkykymd(),
            BizDate.valueOf("20021121"), "（総年Ｆ）契約日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(1).getSounenfnksyoumetucd(),
            "11", "（総年Ｆ）年金消滅コード");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(1).getSounenfsyoumetuymd(),
            BizDate.valueOf("20010411"), "（総年Ｆ）消滅日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(1).getSounenftaisyouseiymd(),
            BizDate.valueOf("19940611"), "（総年Ｆ）対象者生年月日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(2).getSounenfnksysyno(), "11807111211", "（総年Ｆ）年金証書番号");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(2).getSounenfnkkankeisyakbn(),
            C_NkKankeisyaKbn.NKUKT, "（総年Ｆ）年金支払関係者区分");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(2).getSounenfsougounkfkojinkbn(), "04",
            "（総年Ｆ）総合年金支払Ｆ個人区分");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(2).getSounenfkykjyoutaikbn(),
            C_SounenfKykJyoutaiKbn.SYOUMETU_SIBOU, "（総年Ｆ）契約状態区分");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(2).getSounenfsyokainkshrymd(),
            BizDate.valueOf("20021222"), "（総年Ｆ）初回年金支払日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(2).getSounenfkykymd(),
            BizDate.valueOf("20021122"), "（総年Ｆ）契約日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(2).getSounenfnksyoumetucd(),
            "11", "（総年Ｆ）年金消滅コード");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(2).getSounenfsyoumetuymd(),
            BizDate.valueOf("20010412"), "（総年Ｆ）消滅日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(2).getSounenftaisyouseiymd(),
            BizDate.valueOf("19940612"), "（総年Ｆ）対象者生年月日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(3).getSounenfnksysyno(), "11807111211", "（総年Ｆ）年金証書番号");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(3).getSounenfnkkankeisyakbn(),
            C_NkKankeisyaKbn.NKUKT, "（総年Ｆ）年金支払関係者区分");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(3).getSounenfsougounkfkojinkbn(), "04",
            "（総年Ｆ）総合年金支払Ｆ個人区分");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(3).getSounenfkykjyoutaikbn(),
            C_SounenfKykJyoutaiKbn.SYOUMETU_SIBOU, "（総年Ｆ）契約状態区分");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(3).getSounenfsyokainkshrymd(),
            BizDate.valueOf("20021223"), "（総年Ｆ）初回年金支払日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(3).getSounenfkykymd(),
            BizDate.valueOf("20021123"), "（総年Ｆ）契約日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(3).getSounenfnksyoumetucd(),
            "11", "（総年Ｆ）年金消滅コード");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(3).getSounenfsyoumetuymd(),
            BizDate.valueOf("20010413"), "（総年Ｆ）消滅日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(3).getSounenftaisyouseiymd(),
            BizDate.valueOf("19940613"), "（総年Ｆ）対象者生年月日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(4).getSounenfnksysyno(), "11807111211", "（総年Ｆ）年金証書番号");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(4).getSounenfnkkankeisyakbn(),
            C_NkKankeisyaKbn.NKUKT, "（総年Ｆ）年金支払関係者区分");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(4).getSounenfsougounkfkojinkbn(), "04",
            "（総年Ｆ）総合年金支払Ｆ個人区分");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(4).getSounenfkykjyoutaikbn(),
            C_SounenfKykJyoutaiKbn.SYOUMETU_SIBOU, "（総年Ｆ）契約状態区分");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(4).getSounenfsyokainkshrymd(),
            BizDate.valueOf("20021224"), "（総年Ｆ）初回年金支払日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(4).getSounenfkykymd(),
            BizDate.valueOf("20021124"), "（総年Ｆ）契約日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(4).getSounenfnksyoumetucd(),
            "11", "（総年Ｆ）年金消滅コード");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(4).getSounenfsyoumetuymd(),
            BizDate.valueOf("20010414"), "（総年Ｆ）消滅日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(4).getSounenftaisyouseiymd(),
            BizDate.valueOf("19940614"), "（総年Ｆ）対象者生年月日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(5).getSounenfnksysyno(), "11807111211", "（総年Ｆ）年金証書番号");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(5).getSounenfnkkankeisyakbn(),
            C_NkKankeisyaKbn.NKUKT, "（総年Ｆ）年金支払関係者区分");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(5).getSounenfsougounkfkojinkbn(), "04",
            "（総年Ｆ）総合年金支払Ｆ個人区分");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(5).getSounenfkykjyoutaikbn(),
            C_SounenfKykJyoutaiKbn.SYOUMETU_SIBOU, "（総年Ｆ）契約状態区分");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(5).getSounenfsyokainkshrymd(),
            BizDate.valueOf("20021225"), "（総年Ｆ）初回年金支払日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(5).getSounenfkykymd(),
            BizDate.valueOf("20021125"), "（総年Ｆ）契約日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(5).getSounenfnksyoumetucd(),
            "11", "（総年Ｆ）年金消滅コード");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(5).getSounenfsyoumetuymd(),
            BizDate.valueOf("20010415"), "（総年Ｆ）消滅日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(5).getSounenftaisyouseiymd(),
            BizDate.valueOf("19940615"), "（総年Ｆ）対象者生年月日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(6).getSounenfnksysyno(), "11807111211", "（総年Ｆ）年金証書番号");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(6).getSounenfnkkankeisyakbn(),
            C_NkKankeisyaKbn.NKUKT, "（総年Ｆ）年金支払関係者区分");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(6).getSounenfsougounkfkojinkbn(), "04",
            "（総年Ｆ）総合年金支払Ｆ個人区分");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(6).getSounenfkykjyoutaikbn(),
            C_SounenfKykJyoutaiKbn.SYOUMETU_SIBOU, "（総年Ｆ）契約状態区分");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(6).getSounenfsyokainkshrymd(),
            BizDate.valueOf("20021226"), "（総年Ｆ）初回年金支払日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(6).getSounenfkykymd(),
            BizDate.valueOf("20021126"), "（総年Ｆ）契約日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(6).getSounenfnksyoumetucd(),
            "11", "（総年Ｆ）年金消滅コード");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(6).getSounenfsyoumetuymd(),
            BizDate.valueOf("20010416"), "（総年Ｆ）消滅日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(6).getSounenftaisyouseiymd(),
            BizDate.valueOf("19940616"), "（総年Ｆ）対象者生年月日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(7).getSounenfnksysyno(), "11807111211", "（総年Ｆ）年金証書番号");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(7).getSounenfnkkankeisyakbn(),
            C_NkKankeisyaKbn.NKUKT, "（総年Ｆ）年金支払関係者区分");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(7).getSounenfsougounkfkojinkbn(), "04",
            "（総年Ｆ）総合年金支払Ｆ個人区分");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(7).getSounenfkykjyoutaikbn(),
            C_SounenfKykJyoutaiKbn.SYOUMETU_SIBOU, "（総年Ｆ）契約状態区分");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(7).getSounenfsyokainkshrymd(),
            BizDate.valueOf("20021227"), "（総年Ｆ）初回年金支払日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(7).getSounenfkykymd(),
            BizDate.valueOf("20021127"), "（総年Ｆ）契約日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(7).getSounenfnksyoumetucd(),
            "11", "（総年Ｆ）年金消滅コード");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(7).getSounenfsyoumetuymd(),
            BizDate.valueOf("20010417"), "（総年Ｆ）消滅日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(7).getSounenftaisyouseiymd(),
            BizDate.valueOf("19940617"), "（総年Ｆ）対象者生年月日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(8).getSounenfnksysyno(), "11807111211", "（総年Ｆ）年金証書番号");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(8).getSounenfnkkankeisyakbn(),
            C_NkKankeisyaKbn.NKUKT, "（総年Ｆ）年金支払関係者区分");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(8).getSounenfsougounkfkojinkbn(), "04",
            "（総年Ｆ）総合年金支払Ｆ個人区分");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(8).getSounenfkykjyoutaikbn(),
            C_SounenfKykJyoutaiKbn.SYOUMETU_SIBOU, "（総年Ｆ）契約状態区分");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(8).getSounenfsyokainkshrymd(),
            BizDate.valueOf("20021228"), "（総年Ｆ）初回年金支払日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(8).getSounenfkykymd(),
            BizDate.valueOf("20021128"), "（総年Ｆ）契約日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(8).getSounenfnksyoumetucd(),
            "11", "（総年Ｆ）年金消滅コード");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(8).getSounenfsyoumetuymd(),
            BizDate.valueOf("20010418"), "（総年Ｆ）消滅日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(8).getSounenftaisyouseiymd(),
            BizDate.valueOf("19940618"), "（総年Ｆ）対象者生年月日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(9).getSounenfnksysyno(), "11807111211", "（総年Ｆ）年金証書番号");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(9).getSounenfnkkankeisyakbn(),
            C_NkKankeisyaKbn.NKUKT, "（総年Ｆ）年金支払関係者区分");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(9).getSounenfsougounkfkojinkbn(), "04",
            "（総年Ｆ）総合年金支払Ｆ個人区分");

        exClassificationEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(9).getSounenfkykjyoutaikbn(),
            C_SounenfKykJyoutaiKbn.SYOUMETU_SIBOU, "（総年Ｆ）契約状態区分");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(9).getSounenfsyokainkshrymd(),
            BizDate.valueOf("20021229"), "（総年Ｆ）初回年金支払日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(9).getSounenfkykymd(),
            BizDate.valueOf("20021129"), "（総年Ｆ）契約日");

        exStringEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(9).getSounenfnksyoumetucd(),
            "11", "（総年Ｆ）年金消滅コード");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(9).getSounenfsyoumetuymd(),
            BizDate.valueOf("20010419"), "（総年Ｆ）消滅日");
        exDateEquals(sougouNenkinSiharaiFSakuinKekkaLst.get(9).getSounenftaisyouseiymd(),
            BizDate.valueOf("19940619"), "（総年Ｆ）対象者生年月日");


        List<BzKeiyakuHozenSakuinKekkaBean> keiyakuHozenSakuinKekkaLst =
            bzSakuinTsnSyoukaiKekkaBean.getBzkeiyakuhozensakuinkekkabeanlist();
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getBzkeiyakuhozensakuinkekkabeanlist().size(),
            10, "契約保全索引結果Beanリストのサイズ");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(0).getKhsyono(), "11807111163", "（契約保全）証券番号");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(0).getKhkykkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（契約保全）契約関係者区分");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(0).getKhkykfkojinkbn(),
            "05", "（契約保全）契約Ｆ個人区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(0).getKhyuukousyoumetukbn(),
            C_YuukousyoumetuKbn.SYOUMETU, "（契約保全）有効消滅区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(0).getKhkykjyoutai(),
            C_Kykjyoutai.ITIJIBARAI, "（契約保全）契約状態");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(0).getKhkykymd(),
            BizDate.valueOf("20031010"), "（契約保全）契約日");
        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(0).getKhsyoumetujiyuu(),
            C_Syoumetujiyuu.CLGOFF, "（契約保全）消滅事由");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(0).getKhsyoumetuymd(),
            BizDate.valueOf("20000401"), "（契約保全）消滅日");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(0).getKhsyouhncd(),
            "kh", "（契約保全）商品コード");

        exDateYMEquals(keiyakuHozenSakuinKekkaLst.get(0).getKhbosyuuym(),
            BizDateYM.valueOf("199008"), "（契約保全）募集年月");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(0).getKhtaisyouseiymd(),
            BizDate.valueOf("19890510"), "（契約保全）対象者生年月日");
        exNumericEquals(keiyakuHozenSakuinKekkaLst.get(0).getKhsyouhnsdno(), 10, "（契約保全）商品世代番号");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(1).getKhsyono(), "11807111163", "（契約保全）証券番号");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(1).getKhkykkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（契約保全）契約関係者区分");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(1).getKhkykfkojinkbn(),
            "05", "（契約保全）契約Ｆ個人区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(1).getKhyuukousyoumetukbn(),
            C_YuukousyoumetuKbn.SYOUMETU, "（契約保全）有効消滅区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(1).getKhkykjyoutai(),
            C_Kykjyoutai.ITIJIBARAI, "（契約保全）契約状態");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(1).getKhkykymd(),
            BizDate.valueOf("20031011"), "（契約保全）契約日");
        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(1).getKhsyoumetujiyuu(),
            C_Syoumetujiyuu.CLGOFF, "（契約保全）消滅事由");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(1).getKhsyoumetuymd(),
            BizDate.valueOf("20010401"), "（契約保全）消滅日");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(1).getKhsyouhncd(),
            "kh", "（契約保全）商品コード");

        exDateYMEquals(keiyakuHozenSakuinKekkaLst.get(1).getKhbosyuuym(),
            BizDateYM.valueOf("199108"), "（契約保全）募集年月");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(1).getKhtaisyouseiymd(),
            BizDate.valueOf("19890511"), "（契約保全）対象者生年月日");
        exNumericEquals(keiyakuHozenSakuinKekkaLst.get(1).getKhsyouhnsdno(), 11, "（契約保全）商品世代番号");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(2).getKhsyono(), "11807111163", "（契約保全）証券番号");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(2).getKhkykkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（契約保全）契約関係者区分");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(2).getKhkykfkojinkbn(),
            "05", "（契約保全）契約Ｆ個人区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(2).getKhyuukousyoumetukbn(),
            C_YuukousyoumetuKbn.SYOUMETU, "（契約保全）有効消滅区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(2).getKhkykjyoutai(),
            C_Kykjyoutai.ITIJIBARAI, "（契約保全）契約状態");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(2).getKhkykymd(),
            BizDate.valueOf("20031012"), "（契約保全）契約日");
        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(2).getKhsyoumetujiyuu(),
            C_Syoumetujiyuu.CLGOFF, "（契約保全）消滅事由");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(2).getKhsyoumetuymd(),
            BizDate.valueOf("20020401"), "（契約保全）消滅日");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(2).getKhsyouhncd(),
            "kh", "（契約保全）商品コード");

        exDateYMEquals(keiyakuHozenSakuinKekkaLst.get(2).getKhbosyuuym(),
            BizDateYM.valueOf("199208"), "（契約保全）募集年月");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(2).getKhtaisyouseiymd(),
            BizDate.valueOf("19890512"), "（契約保全）対象者生年月日");
        exNumericEquals(keiyakuHozenSakuinKekkaLst.get(2).getKhsyouhnsdno(), 12, "（契約保全）商品世代番号");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(3).getKhsyono(), "11807111163", "（契約保全）証券番号");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(3).getKhkykkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（契約保全）契約関係者区分");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(3).getKhkykfkojinkbn(),
            "05", "（契約保全）契約Ｆ個人区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(3).getKhyuukousyoumetukbn(),
            C_YuukousyoumetuKbn.SYOUMETU, "（契約保全）有効消滅区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(3).getKhkykjyoutai(),
            C_Kykjyoutai.ITIJIBARAI, "（契約保全）契約状態");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(3).getKhkykymd(),
            BizDate.valueOf("20031013"), "（契約保全）契約日");
        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(3).getKhsyoumetujiyuu(),
            C_Syoumetujiyuu.CLGOFF, "（契約保全）消滅事由");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(3).getKhsyoumetuymd(),
            BizDate.valueOf("20030401"), "（契約保全）消滅日");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(3).getKhsyouhncd(),
            "kh", "（契約保全）商品コード");

        exDateYMEquals(keiyakuHozenSakuinKekkaLst.get(3).getKhbosyuuym(),
            BizDateYM.valueOf("199308"), "（契約保全）募集年月");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(3).getKhtaisyouseiymd(),
            BizDate.valueOf("19890513"), "（契約保全）対象者生年月日");
        exNumericEquals(keiyakuHozenSakuinKekkaLst.get(3).getKhsyouhnsdno(), 13, "（契約保全）商品世代番号");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(4).getKhsyono(), "11807111163", "（契約保全）証券番号");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(4).getKhkykkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（契約保全）契約関係者区分");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(4).getKhkykfkojinkbn(),
            "05", "（契約保全）契約Ｆ個人区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(4).getKhyuukousyoumetukbn(),
            C_YuukousyoumetuKbn.SYOUMETU, "（契約保全）有効消滅区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(4).getKhkykjyoutai(),
            C_Kykjyoutai.ITIJIBARAI, "（契約保全）契約状態");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(4).getKhkykymd(),
            BizDate.valueOf("20031014"), "（契約保全）契約日");
        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(4).getKhsyoumetujiyuu(),
            C_Syoumetujiyuu.CLGOFF, "（契約保全）消滅事由");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(4).getKhsyoumetuymd(),
            BizDate.valueOf("20040401"), "（契約保全）消滅日");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(4).getKhsyouhncd(),
            "kh", "（契約保全）商品コード");

        exDateYMEquals(keiyakuHozenSakuinKekkaLst.get(4).getKhbosyuuym(),
            BizDateYM.valueOf("199408"), "（契約保全）募集年月");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(4).getKhtaisyouseiymd(),
            BizDate.valueOf("19890514"), "（契約保全）対象者生年月日");
        exNumericEquals(keiyakuHozenSakuinKekkaLst.get(4).getKhsyouhnsdno(), 14, "（契約保全）商品世代番号");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(5).getKhsyono(), "11807111163", "（契約保全）証券番号");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(5).getKhkykkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（契約保全）契約関係者区分");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(5).getKhkykfkojinkbn(),
            "05", "（契約保全）契約Ｆ個人区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(5).getKhyuukousyoumetukbn(),
            C_YuukousyoumetuKbn.SYOUMETU, "（契約保全）有効消滅区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(5).getKhkykjyoutai(),
            C_Kykjyoutai.ITIJIBARAI, "（契約保全）契約状態");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(5).getKhkykymd(),
            BizDate.valueOf("20031015"), "（契約保全）契約日");
        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(5).getKhsyoumetujiyuu(),
            C_Syoumetujiyuu.CLGOFF, "（契約保全）消滅事由");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(5).getKhsyoumetuymd(),
            BizDate.valueOf("20050401"), "（契約保全）消滅日");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(5).getKhsyouhncd(),
            "kh", "（契約保全）商品コード");

        exDateYMEquals(keiyakuHozenSakuinKekkaLst.get(5).getKhbosyuuym(),
            BizDateYM.valueOf("199508"), "（契約保全）募集年月");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(5).getKhtaisyouseiymd(),
            BizDate.valueOf("19890515"), "（契約保全）対象者生年月日");
        exNumericEquals(keiyakuHozenSakuinKekkaLst.get(5).getKhsyouhnsdno(), 15, "（契約保全）商品世代番号");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(6).getKhsyono(), "11807111163", "（契約保全）証券番号");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(6).getKhkykkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（契約保全）契約関係者区分");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(6).getKhkykfkojinkbn(),
            "05", "（契約保全）契約Ｆ個人区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(6).getKhyuukousyoumetukbn(),
            C_YuukousyoumetuKbn.SYOUMETU, "（契約保全）有効消滅区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(6).getKhkykjyoutai(),
            C_Kykjyoutai.ITIJIBARAI, "（契約保全）契約状態");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(6).getKhkykymd(),
            BizDate.valueOf("20031016"), "（契約保全）契約日");
        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(6).getKhsyoumetujiyuu(),
            C_Syoumetujiyuu.CLGOFF, "（契約保全）消滅事由");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(6).getKhsyoumetuymd(),
            BizDate.valueOf("20060401"), "（契約保全）消滅日");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(6).getKhsyouhncd(),
            "kh", "（契約保全）商品コード");

        exDateYMEquals(keiyakuHozenSakuinKekkaLst.get(6).getKhbosyuuym(),
            BizDateYM.valueOf("199608"), "（契約保全）募集年月");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(6).getKhtaisyouseiymd(),
            BizDate.valueOf("19890516"), "（契約保全）対象者生年月日");
        exNumericEquals(keiyakuHozenSakuinKekkaLst.get(6).getKhsyouhnsdno(), 16, "（契約保全）商品世代番号");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(7).getKhsyono(), "11807111163", "（契約保全）証券番号");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(7).getKhkykkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（契約保全）契約関係者区分");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(7).getKhkykfkojinkbn(),
            "05", "（契約保全）契約Ｆ個人区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(7).getKhyuukousyoumetukbn(),
            C_YuukousyoumetuKbn.SYOUMETU, "（契約保全）有効消滅区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(7).getKhkykjyoutai(),
            C_Kykjyoutai.ITIJIBARAI, "（契約保全）契約状態");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(7).getKhkykymd(),
            BizDate.valueOf("20031017"), "（契約保全）契約日");
        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(7).getKhsyoumetujiyuu(),
            C_Syoumetujiyuu.CLGOFF, "（契約保全）消滅事由");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(7).getKhsyoumetuymd(),
            BizDate.valueOf("20070401"), "（契約保全）消滅日");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(7).getKhsyouhncd(),
            "kh", "（契約保全）商品コード");

        exDateYMEquals(keiyakuHozenSakuinKekkaLst.get(7).getKhbosyuuym(),
            BizDateYM.valueOf("199708"), "（契約保全）募集年月");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(7).getKhtaisyouseiymd(),
            BizDate.valueOf("19890517"), "（契約保全）対象者生年月日");
        exNumericEquals(keiyakuHozenSakuinKekkaLst.get(7).getKhsyouhnsdno(), 17, "（契約保全）商品世代番号");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(8).getKhsyono(), "11807111163", "（契約保全）証券番号");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(8).getKhkykkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（契約保全）契約関係者区分");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(8).getKhkykfkojinkbn(),
            "05", "（契約保全）契約Ｆ個人区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(8).getKhyuukousyoumetukbn(),
            C_YuukousyoumetuKbn.SYOUMETU, "（契約保全）有効消滅区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(8).getKhkykjyoutai(),
            C_Kykjyoutai.ITIJIBARAI, "（契約保全）契約状態");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(8).getKhkykymd(),
            BizDate.valueOf("20031018"), "（契約保全）契約日");
        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(8).getKhsyoumetujiyuu(),
            C_Syoumetujiyuu.CLGOFF, "（契約保全）消滅事由");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(8).getKhsyoumetuymd(),
            BizDate.valueOf("20080401"), "（契約保全）消滅日");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(8).getKhsyouhncd(),
            "kh", "（契約保全）商品コード");

        exDateYMEquals(keiyakuHozenSakuinKekkaLst.get(8).getKhbosyuuym(),
            BizDateYM.valueOf("199808"), "（契約保全）募集年月");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(8).getKhtaisyouseiymd(),
            BizDate.valueOf("19890518"), "（契約保全）対象者生年月日");
        exNumericEquals(keiyakuHozenSakuinKekkaLst.get(8).getKhsyouhnsdno(), 18, "（契約保全）商品世代番号");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(9).getKhsyono(), "11807111163", "（契約保全）証券番号");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(9).getKhkykkankeisyakbn(),
            C_KankeisyaKbn.HHKN_KYKBETU, "（契約保全）契約関係者区分");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(9).getKhkykfkojinkbn(),
            "05", "（契約保全）契約Ｆ個人区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(9).getKhyuukousyoumetukbn(),
            C_YuukousyoumetuKbn.SYOUMETU, "（契約保全）有効消滅区分");

        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(9).getKhkykjyoutai(),
            C_Kykjyoutai.ITIJIBARAI, "（契約保全）契約状態");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(9).getKhkykymd(),
            BizDate.valueOf("20031019"), "（契約保全）契約日");
        exClassificationEquals(keiyakuHozenSakuinKekkaLst.get(9).getKhsyoumetujiyuu(),
            C_Syoumetujiyuu.CLGOFF, "（契約保全）消滅事由");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(9).getKhsyoumetuymd(),
            BizDate.valueOf("20090401"), "（契約保全）消滅日");

        exStringEquals(keiyakuHozenSakuinKekkaLst.get(9).getKhsyouhncd(),
            "kh", "（契約保全）商品コード");

        exDateYMEquals(keiyakuHozenSakuinKekkaLst.get(9).getKhbosyuuym(),
            BizDateYM.valueOf("199908"), "（契約保全）募集年月");
        exDateEquals(keiyakuHozenSakuinKekkaLst.get(9).getKhtaisyouseiymd(),
            BizDate.valueOf("19890519"), "（契約保全）対象者生年月日");
        exNumericEquals(keiyakuHozenSakuinKekkaLst.get(9).getKhsyouhnsdno(), 19, "（契約保全）商品世代番号");


        List<BzSinkeiyakuSakuinKekkaBean> sinkeiyakuSakuinKekkaLst =
            bzSakuinTsnSyoukaiKekkaBean.getBzsinkeiyakusakuinkekkabeanlist();
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getBzsinkeiyakusakuinkekkabeanlist().size(),
            10, "新契約索引結果Beanリストのサイズ");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(0).getSkmosno(), "791112402", "（新契約）申込番号");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(0).getSkmoskankeisyakbn(),
            C_KankeisyaKbn.KYK, "（新契約）申込関係者区分");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(0).getSkmosfkojinkbn(), "03", "（新契約）申込Ｆ個人区分");
        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(0).getSkmfrenflg(),
            C_Mfrenflg.SUMI, "（新契約）ＭＦ連動済フラグ");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(0).getSkmosymd(),
            BizDate.valueOf("19900509"), "（新契約）申込日");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(0).getSkkykymd(),
            BizDate.valueOf("19970610"), "（新契約）契約日");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(0).getSkseiritukbn(),
            C_SeirituKbn.SEIRITU, "（新契約）成立区分");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(0).getSksrsyoriymd(),
            BizDate.valueOf("19971010"), "（新契約）成立処理日");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(0).getSksyouhncd(), "sk", "（新契約）商品コード");

        exDateYMEquals(sinkeiyakuSakuinKekkaLst.get(0).getSkbosyuuym(),
            BizDateYM.valueOf("199009"), "（新契約）募集年月");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(0).getSktaisyounayosejtkbn(),
            C_NayoseJyoutaiKbn.NAYOSEHUMEI, "（新契約）対象者名寄せ状態区分");
        exStringEquals(sinkeiyakuSakuinKekkaLst.get(0).getSktaisyousakuinnmno(), "0000000030", "（新契約）対象者索引名番号");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(0).getSktaisyouseiymd(),
            BizDate.valueOf("19881110"), "（新契約）対象者生年月日");
        exNumericEquals(sinkeiyakuSakuinKekkaLst.get(0).getSksyouhnsdno(), 20, "（新契約）商品世代番号");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(1).getSkmosno(), "791112402", "（新契約）申込番号");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(1).getSkmoskankeisyakbn(),
            C_KankeisyaKbn.KYK, "（新契約）申込関係者区分");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(1).getSkmosfkojinkbn(), "03", "（新契約）申込Ｆ個人区分");
        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(1).getSkmfrenflg(),
            C_Mfrenflg.SUMI, "（新契約）ＭＦ連動済フラグ");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(1).getSkmosymd(),
            BizDate.valueOf("19910509"), "（新契約）申込日");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(1).getSkkykymd(),
            BizDate.valueOf("19970611"), "（新契約）契約日");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(1).getSkseiritukbn(),
            C_SeirituKbn.SEIRITU, "（新契約）成立区分");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(1).getSksrsyoriymd(),
            BizDate.valueOf("19971011"), "（新契約）成立処理日");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(1).getSksyouhncd(), "sk", "（新契約）商品コード");

        exDateYMEquals(sinkeiyakuSakuinKekkaLst.get(1).getSkbosyuuym(),
            BizDateYM.valueOf("199109"), "（新契約）募集年月");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(1).getSktaisyounayosejtkbn(),
            C_NayoseJyoutaiKbn.NAYOSEHUMEI, "（新契約）対象者名寄せ状態区分");
        exStringEquals(sinkeiyakuSakuinKekkaLst.get(1).getSktaisyousakuinnmno(), "0000000031", "（新契約）対象者索引名番号");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(1).getSktaisyouseiymd(),
            BizDate.valueOf("19881111"), "（新契約）対象者生年月日");
        exNumericEquals(sinkeiyakuSakuinKekkaLst.get(1).getSksyouhnsdno(), 21, "（新契約）商品世代番号");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(2).getSkmosno(), "791112402", "（新契約）申込番号");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(2).getSkmoskankeisyakbn(),
            C_KankeisyaKbn.KYK, "（新契約）申込関係者区分");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(2).getSkmosfkojinkbn(), "03", "（新契約）申込Ｆ個人区分");
        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(2).getSkmfrenflg(),
            C_Mfrenflg.SUMI, "（新契約）ＭＦ連動済フラグ");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(2).getSkmosymd(),
            BizDate.valueOf("19920509"), "（新契約）申込日");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(2).getSkkykymd(),
            BizDate.valueOf("19970612"), "（新契約）契約日");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(2).getSkseiritukbn(),
            C_SeirituKbn.SEIRITU, "（新契約）成立区分");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(2).getSksrsyoriymd(),
            BizDate.valueOf("19971012"), "（新契約）成立処理日");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(2).getSksyouhncd(), "sk", "（新契約）商品コード");

        exDateYMEquals(sinkeiyakuSakuinKekkaLst.get(2).getSkbosyuuym(),
            BizDateYM.valueOf("199209"), "（新契約）募集年月");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(2).getSktaisyounayosejtkbn(),
            C_NayoseJyoutaiKbn.NAYOSEHUMEI, "（新契約）対象者名寄せ状態区分");
        exStringEquals(sinkeiyakuSakuinKekkaLst.get(2).getSktaisyousakuinnmno(), "0000000032", "（新契約）対象者索引名番号");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(2).getSktaisyouseiymd(),
            BizDate.valueOf("19881112"), "（新契約）対象者生年月日");
        exNumericEquals(sinkeiyakuSakuinKekkaLst.get(2).getSksyouhnsdno(), 22, "（新契約）商品世代番号");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(3).getSkmosno(), "791112402", "（新契約）申込番号");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(3).getSkmoskankeisyakbn(),
            C_KankeisyaKbn.KYK, "（新契約）申込関係者区分");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(3).getSkmosfkojinkbn(), "03", "（新契約）申込Ｆ個人区分");
        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(3).getSkmfrenflg(),
            C_Mfrenflg.SUMI, "（新契約）ＭＦ連動済フラグ");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(3).getSkmosymd(),
            BizDate.valueOf("19930509"), "（新契約）申込日");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(3).getSkkykymd(),
            BizDate.valueOf("19970613"), "（新契約）契約日");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(3).getSkseiritukbn(),
            C_SeirituKbn.SEIRITU, "（新契約）成立区分");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(3).getSksrsyoriymd(),
            BizDate.valueOf("19971013"), "（新契約）成立処理日");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(3).getSksyouhncd(), "sk", "（新契約）商品コード");

        exDateYMEquals(sinkeiyakuSakuinKekkaLst.get(3).getSkbosyuuym(),
            BizDateYM.valueOf("199309"), "（新契約）募集年月");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(3).getSktaisyounayosejtkbn(),
            C_NayoseJyoutaiKbn.NAYOSEHUMEI, "（新契約）対象者名寄せ状態区分");
        exStringEquals(sinkeiyakuSakuinKekkaLst.get(3).getSktaisyousakuinnmno(), "0000000033", "（新契約）対象者索引名番号");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(3).getSktaisyouseiymd(),
            BizDate.valueOf("19881113"), "（新契約）対象者生年月日");
        exNumericEquals(sinkeiyakuSakuinKekkaLst.get(3).getSksyouhnsdno(), 23, "（新契約）商品世代番号");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(4).getSkmosno(), "791112402", "（新契約）申込番号");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(4).getSkmoskankeisyakbn(),
            C_KankeisyaKbn.KYK, "（新契約）申込関係者区分");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(4).getSkmosfkojinkbn(), "03", "（新契約）申込Ｆ個人区分");
        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(4).getSkmfrenflg(),
            C_Mfrenflg.SUMI, "（新契約）ＭＦ連動済フラグ");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(4).getSkmosymd(),
            BizDate.valueOf("19940509"), "（新契約）申込日");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(4).getSkkykymd(),
            BizDate.valueOf("19970614"), "（新契約）契約日");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(4).getSkseiritukbn(),
            C_SeirituKbn.SEIRITU, "（新契約）成立区分");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(4).getSksrsyoriymd(),
            BizDate.valueOf("19971014"), "（新契約）成立処理日");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(4).getSksyouhncd(), "sk", "（新契約）商品コード");

        exDateYMEquals(sinkeiyakuSakuinKekkaLst.get(4).getSkbosyuuym(),
            BizDateYM.valueOf("199409"), "（新契約）募集年月");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(4).getSktaisyounayosejtkbn(),
            C_NayoseJyoutaiKbn.NAYOSEHUMEI, "（新契約）対象者名寄せ状態区分");
        exStringEquals(sinkeiyakuSakuinKekkaLst.get(4).getSktaisyousakuinnmno(), "0000000034", "（新契約）対象者索引名番号");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(4).getSktaisyouseiymd(),
            BizDate.valueOf("19881114"), "（新契約）対象者生年月日");
        exNumericEquals(sinkeiyakuSakuinKekkaLst.get(4).getSksyouhnsdno(), 24, "（新契約）商品世代番号");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(5).getSkmosno(), "791112402", "（新契約）申込番号");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(5).getSkmoskankeisyakbn(),
            C_KankeisyaKbn.KYK, "（新契約）申込関係者区分");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(5).getSkmosfkojinkbn(), "03", "（新契約）申込Ｆ個人区分");
        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(5).getSkmfrenflg(),
            C_Mfrenflg.SUMI, "（新契約）ＭＦ連動済フラグ");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(5).getSkmosymd(),
            BizDate.valueOf("19950509"), "（新契約）申込日");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(5).getSkkykymd(),
            BizDate.valueOf("19970615"), "（新契約）契約日");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(5).getSkseiritukbn(),
            C_SeirituKbn.SEIRITU, "（新契約）成立区分");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(5).getSksrsyoriymd(),
            BizDate.valueOf("19971015"), "（新契約）成立処理日");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(5).getSksyouhncd(), "sk", "（新契約）商品コード");

        exDateYMEquals(sinkeiyakuSakuinKekkaLst.get(5).getSkbosyuuym(),
            BizDateYM.valueOf("199509"), "（新契約）募集年月");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(5).getSktaisyounayosejtkbn(),
            C_NayoseJyoutaiKbn.NAYOSEHUMEI, "（新契約）対象者名寄せ状態区分");
        exStringEquals(sinkeiyakuSakuinKekkaLst.get(5).getSktaisyousakuinnmno(), "0000000035", "（新契約）対象者索引名番号");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(5).getSktaisyouseiymd(),
            BizDate.valueOf("19881115"), "（新契約）対象者生年月日");
        exNumericEquals(sinkeiyakuSakuinKekkaLst.get(5).getSksyouhnsdno(), 25, "（新契約）商品世代番号");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(6).getSkmosno(), "791112402", "（新契約）申込番号");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(6).getSkmoskankeisyakbn(),
            C_KankeisyaKbn.KYK, "（新契約）申込関係者区分");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(6).getSkmosfkojinkbn(), "03", "（新契約）申込Ｆ個人区分");
        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(6).getSkmfrenflg(),
            C_Mfrenflg.SUMI, "（新契約）ＭＦ連動済フラグ");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(6).getSkmosymd(),
            BizDate.valueOf("19960509"), "（新契約）申込日");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(6).getSkkykymd(),
            BizDate.valueOf("19970616"), "（新契約）契約日");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(6).getSkseiritukbn(),
            C_SeirituKbn.SEIRITU, "（新契約）成立区分");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(6).getSksrsyoriymd(),
            BizDate.valueOf("19971016"), "（新契約）成立処理日");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(6).getSksyouhncd(), "sk", "（新契約）商品コード");

        exDateYMEquals(sinkeiyakuSakuinKekkaLst.get(6).getSkbosyuuym(),
            BizDateYM.valueOf("199609"), "（新契約）募集年月");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(6).getSktaisyounayosejtkbn(),
            C_NayoseJyoutaiKbn.NAYOSEHUMEI, "（新契約）対象者名寄せ状態区分");
        exStringEquals(sinkeiyakuSakuinKekkaLst.get(6).getSktaisyousakuinnmno(), "0000000036", "（新契約）対象者索引名番号");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(6).getSktaisyouseiymd(),
            BizDate.valueOf("19881116"), "（新契約）対象者生年月日");
        exNumericEquals(sinkeiyakuSakuinKekkaLst.get(6).getSksyouhnsdno(), 26, "（新契約）商品世代番号");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(7).getSkmosno(), "791112402", "（新契約）申込番号");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(7).getSkmoskankeisyakbn(),
            C_KankeisyaKbn.KYK, "（新契約）申込関係者区分");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(7).getSkmosfkojinkbn(), "03", "（新契約）申込Ｆ個人区分");
        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(7).getSkmfrenflg(),
            C_Mfrenflg.SUMI, "（新契約）ＭＦ連動済フラグ");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(7).getSkmosymd(),
            BizDate.valueOf("19970509"), "（新契約）申込日");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(7).getSkkykymd(),
            BizDate.valueOf("19970617"), "（新契約）契約日");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(7).getSkseiritukbn(),
            C_SeirituKbn.SEIRITU, "（新契約）成立区分");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(7).getSksrsyoriymd(),
            BizDate.valueOf("19971017"), "（新契約）成立処理日");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(7).getSksyouhncd(), "sk", "（新契約）商品コード");

        exDateYMEquals(sinkeiyakuSakuinKekkaLst.get(7).getSkbosyuuym(),
            BizDateYM.valueOf("199709"), "（新契約）募集年月");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(7).getSktaisyounayosejtkbn(),
            C_NayoseJyoutaiKbn.NAYOSEHUMEI, "（新契約）対象者名寄せ状態区分");
        exStringEquals(sinkeiyakuSakuinKekkaLst.get(7).getSktaisyousakuinnmno(), "0000000037", "（新契約）対象者索引名番号");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(7).getSktaisyouseiymd(),
            BizDate.valueOf("19881117"), "（新契約）対象者生年月日");
        exNumericEquals(sinkeiyakuSakuinKekkaLst.get(7).getSksyouhnsdno(), 27, "（新契約）商品世代番号");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(8).getSkmosno(), "791112402", "（新契約）申込番号");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(8).getSkmoskankeisyakbn(),
            C_KankeisyaKbn.KYK, "（新契約）申込関係者区分");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(8).getSkmosfkojinkbn(), "03", "（新契約）申込Ｆ個人区分");
        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(8).getSkmfrenflg(),
            C_Mfrenflg.SUMI, "（新契約）ＭＦ連動済フラグ");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(8).getSkmosymd(),
            BizDate.valueOf("19980509"), "（新契約）申込日");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(8).getSkkykymd(),
            BizDate.valueOf("19970618"), "（新契約）契約日");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(8).getSkseiritukbn(),
            C_SeirituKbn.SEIRITU, "（新契約）成立区分");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(8).getSksrsyoriymd(),
            BizDate.valueOf("19971018"), "（新契約）成立処理日");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(8).getSksyouhncd(), "sk", "（新契約）商品コード");

        exDateYMEquals(sinkeiyakuSakuinKekkaLst.get(8).getSkbosyuuym(),
            BizDateYM.valueOf("199809"), "（新契約）募集年月");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(8).getSktaisyounayosejtkbn(),
            C_NayoseJyoutaiKbn.NAYOSEHUMEI, "（新契約）対象者名寄せ状態区分");
        exStringEquals(sinkeiyakuSakuinKekkaLst.get(8).getSktaisyousakuinnmno(), "0000000038", "（新契約）対象者索引名番号");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(8).getSktaisyouseiymd(),
            BizDate.valueOf("19881118"), "（新契約）対象者生年月日");
        exNumericEquals(sinkeiyakuSakuinKekkaLst.get(8).getSksyouhnsdno(), 28, "（新契約）商品世代番号");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(9).getSkmosno(), "791112402", "（新契約）申込番号");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(9).getSkmoskankeisyakbn(),
            C_KankeisyaKbn.KYK, "（新契約）申込関係者区分");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(9).getSkmosfkojinkbn(), "03", "（新契約）申込Ｆ個人区分");
        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(9).getSkmfrenflg(),
            C_Mfrenflg.SUMI, "（新契約）ＭＦ連動済フラグ");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(9).getSkmosymd(),
            BizDate.valueOf("19990509"), "（新契約）申込日");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(9).getSkkykymd(),
            BizDate.valueOf("19970619"), "（新契約）契約日");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(9).getSkseiritukbn(),
            C_SeirituKbn.SEIRITU, "（新契約）成立区分");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(9).getSksrsyoriymd(),
            BizDate.valueOf("19971019"), "（新契約）成立処理日");

        exStringEquals(sinkeiyakuSakuinKekkaLst.get(9).getSksyouhncd(), "sk", "（新契約）商品コード");

        exDateYMEquals(sinkeiyakuSakuinKekkaLst.get(9).getSkbosyuuym(),
            BizDateYM.valueOf("199909"), "（新契約）募集年月");

        exClassificationEquals(sinkeiyakuSakuinKekkaLst.get(9).getSktaisyounayosejtkbn(),
            C_NayoseJyoutaiKbn.NAYOSEHUMEI, "（新契約）対象者名寄せ状態区分");
        exStringEquals(sinkeiyakuSakuinKekkaLst.get(9).getSktaisyousakuinnmno(), "0000000039", "（新契約）対象者索引名番号");
        exDateEquals(sinkeiyakuSakuinKekkaLst.get(9).getSktaisyouseiymd(),
            BizDate.valueOf("19881119"), "（新契約）対象者生年月日");
        exNumericEquals(sinkeiyakuSakuinKekkaLst.get(9).getSksyouhnsdno(), 29, "（新契約）商品世代番号");


        List<BzNenkinSiharaiSakuinKekkaBean> nenkinSiharaiSakuinKekkaLst =
            bzSakuinTsnSyoukaiKekkaBean.getBznenkinsiharaisakuinkekkabeanlist();
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getBznenkinsiharaisakuinkekkabeanlist().size(),
            10, "年金支払索引結果Beanリストのサイズ");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(0).getNknksysyno(), "11807111222", "（年金支払）年金証書番号");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(0).getNknkkankeisyakbn(),
            C_NkKankeisyaKbn.HHKN_NKUKTBETU, "（年金支払）年金支払関係者区分");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(0).getNknkkojinkbn(), "05", "（年金支払）年金支払個人区分");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(0).getNkkykymd(),
            BizDate.valueOf("20000402"), "（年金支払）契約日");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(0).getNknkshrstartymd(),
            BizDate.valueOf("20000409"), "（年金支払）年金支払開始日");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(0).getNknksyoumetucd(),
            C_NkSyoumetuCd.SIBOU, "（年金支払）年金消滅コード");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(0).getNksyoumetuymd(),
            BizDate.valueOf("20050510"), "（年金支払）消滅日");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(0).getNksyouhncd(), "nk", "（年金支払）商品コード");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(0).getNknenkinsyu(), "01", "（年金支払）年金種類");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(0).getNktaisyouseiymd(),
            BizDate.valueOf("19780410"), "（年金支払）対象者生年月日");
        exNumericEquals(nenkinSiharaiSakuinKekkaLst.get(0).getNksyouhnsdno(), 30, "（年金支払）商品世代番号");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(1).getNknksysyno(), "11807111222", "（年金支払）年金証書番号");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(1).getNknkkankeisyakbn(),
            C_NkKankeisyaKbn.HHKN_NKUKTBETU, "（年金支払）年金支払関係者区分");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(1).getNknkkojinkbn(), "05", "（年金支払）年金支払個人区分");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(1).getNkkykymd(),
            BizDate.valueOf("20010402"), "（年金支払）契約日");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(1).getNknkshrstartymd(),
            BizDate.valueOf("20010409"), "（年金支払）年金支払開始日");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(1).getNknksyoumetucd(),
            C_NkSyoumetuCd.SIBOU, "（年金支払）年金消滅コード");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(1).getNksyoumetuymd(),
            BizDate.valueOf("20050511"), "（年金支払）消滅日");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(1).getNksyouhncd(), "nk", "（年金支払）商品コード");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(1).getNknenkinsyu(), "01", "（年金支払）年金種類");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(1).getNktaisyouseiymd(),
            BizDate.valueOf("19780411"), "（年金支払）対象者生年月日");
        exNumericEquals(nenkinSiharaiSakuinKekkaLst.get(1).getNksyouhnsdno(), 31, "（年金支払）商品世代番号");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(2).getNknksysyno(), "11807111222", "（年金支払）年金証書番号");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(2).getNknkkankeisyakbn(),
            C_NkKankeisyaKbn.HHKN_NKUKTBETU, "（年金支払）年金支払関係者区分");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(2).getNknkkojinkbn(), "05", "（年金支払）年金支払個人区分");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(2).getNkkykymd(),
            BizDate.valueOf("20020402"), "（年金支払）契約日");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(2).getNknkshrstartymd(),
            BizDate.valueOf("20020409"), "（年金支払）年金支払開始日");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(2).getNknksyoumetucd(),
            C_NkSyoumetuCd.SIBOU, "（年金支払）年金消滅コード");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(2).getNksyoumetuymd(),
            BizDate.valueOf("20050512"), "（年金支払）消滅日");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(2).getNksyouhncd(), "nk", "（年金支払）商品コード");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(2).getNknenkinsyu(), "01", "（年金支払）年金種類");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(2).getNktaisyouseiymd(),
            BizDate.valueOf("19780412"), "（年金支払）対象者生年月日");
        exNumericEquals(nenkinSiharaiSakuinKekkaLst.get(2).getNksyouhnsdno(), 32, "（年金支払）商品世代番号");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(3).getNknksysyno(), "11807111222", "（年金支払）年金証書番号");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(3).getNknkkankeisyakbn(),
            C_NkKankeisyaKbn.HHKN_NKUKTBETU, "（年金支払）年金支払関係者区分");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(3).getNknkkojinkbn(), "05", "（年金支払）年金支払個人区分");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(3).getNkkykymd(),
            BizDate.valueOf("20030402"), "（年金支払）契約日");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(3).getNknkshrstartymd(),
            BizDate.valueOf("20030409"), "（年金支払）年金支払開始日");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(3).getNknksyoumetucd(),
            C_NkSyoumetuCd.SIBOU, "（年金支払）年金消滅コード");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(3).getNksyoumetuymd(),
            BizDate.valueOf("20050513"), "（年金支払）消滅日");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(3).getNksyouhncd(), "nk", "（年金支払）商品コード");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(3).getNknenkinsyu(), "01", "（年金支払）年金種類");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(3).getNktaisyouseiymd(),
            BizDate.valueOf("19780413"), "（年金支払）対象者生年月日");
        exNumericEquals(nenkinSiharaiSakuinKekkaLst.get(3).getNksyouhnsdno(), 33, "（年金支払）商品世代番号");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(4).getNknksysyno(), "11807111222", "（年金支払）年金証書番号");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(4).getNknkkankeisyakbn(),
            C_NkKankeisyaKbn.HHKN_NKUKTBETU, "（年金支払）年金支払関係者区分");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(4).getNknkkojinkbn(), "05", "（年金支払）年金支払個人区分");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(4).getNkkykymd(),
            BizDate.valueOf("20040402"), "（年金支払）契約日");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(4).getNknkshrstartymd(),
            BizDate.valueOf("20040409"), "（年金支払）年金支払開始日");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(4).getNknksyoumetucd(),
            C_NkSyoumetuCd.SIBOU, "（年金支払）年金消滅コード");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(4).getNksyoumetuymd(),
            BizDate.valueOf("20050514"), "（年金支払）消滅日");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(4).getNksyouhncd(), "nk", "（年金支払）商品コード");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(4).getNknenkinsyu(), "01", "（年金支払）年金種類");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(4).getNktaisyouseiymd(),
            BizDate.valueOf("19780414"), "（年金支払）対象者生年月日");
        exNumericEquals(nenkinSiharaiSakuinKekkaLst.get(4).getNksyouhnsdno(), 34, "（年金支払）商品世代番号");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(5).getNknksysyno(), "11807111222", "（年金支払）年金証書番号");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(5).getNknkkankeisyakbn(),
            C_NkKankeisyaKbn.HHKN_NKUKTBETU, "（年金支払）年金支払関係者区分");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(5).getNknkkojinkbn(), "05", "（年金支払）年金支払個人区分");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(5).getNkkykymd(),
            BizDate.valueOf("20050402"), "（年金支払）契約日");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(5).getNknkshrstartymd(),
            BizDate.valueOf("20050409"), "（年金支払）年金支払開始日");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(5).getNknksyoumetucd(),
            C_NkSyoumetuCd.SIBOU, "（年金支払）年金消滅コード");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(5).getNksyoumetuymd(),
            BizDate.valueOf("20050515"), "（年金支払）消滅日");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(5).getNksyouhncd(), "nk", "（年金支払）商品コード");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(5).getNknenkinsyu(), "01", "（年金支払）年金種類");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(5).getNktaisyouseiymd(),
            BizDate.valueOf("19780415"), "（年金支払）対象者生年月日");
        exNumericEquals(nenkinSiharaiSakuinKekkaLst.get(5).getNksyouhnsdno(), 35, "（年金支払）商品世代番号");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(6).getNknksysyno(), "11807111222", "（年金支払）年金証書番号");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(6).getNknkkankeisyakbn(),
            C_NkKankeisyaKbn.HHKN_NKUKTBETU, "（年金支払）年金支払関係者区分");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(6).getNknkkojinkbn(), "05", "（年金支払）年金支払個人区分");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(6).getNkkykymd(),
            BizDate.valueOf("20060402"), "（年金支払）契約日");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(6).getNknkshrstartymd(),
            BizDate.valueOf("20060409"), "（年金支払）年金支払開始日");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(6).getNknksyoumetucd(),
            C_NkSyoumetuCd.SIBOU, "（年金支払）年金消滅コード");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(6).getNksyoumetuymd(),
            BizDate.valueOf("20050516"), "（年金支払）消滅日");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(6).getNksyouhncd(), "nk", "（年金支払）商品コード");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(6).getNknenkinsyu(), "01", "（年金支払）年金種類");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(6).getNktaisyouseiymd(),
            BizDate.valueOf("19780416"), "（年金支払）対象者生年月日");
        exNumericEquals(nenkinSiharaiSakuinKekkaLst.get(6).getNksyouhnsdno(), 36, "（年金支払）商品世代番号");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(7).getNknksysyno(), "11807111222", "（年金支払）年金証書番号");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(7).getNknkkankeisyakbn(),
            C_NkKankeisyaKbn.HHKN_NKUKTBETU, "（年金支払）年金支払関係者区分");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(7).getNknkkojinkbn(), "05", "（年金支払）年金支払個人区分");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(7).getNkkykymd(),
            BizDate.valueOf("20070402"), "（年金支払）契約日");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(7).getNknkshrstartymd(),
            BizDate.valueOf("20070409"), "（年金支払）年金支払開始日");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(7).getNknksyoumetucd(),
            C_NkSyoumetuCd.SIBOU, "（年金支払）年金消滅コード");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(7).getNksyoumetuymd(),
            BizDate.valueOf("20050517"), "（年金支払）消滅日");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(7).getNksyouhncd(), "nk", "（年金支払）商品コード");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(7).getNknenkinsyu(), "01", "（年金支払）年金種類");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(7).getNktaisyouseiymd(),
            BizDate.valueOf("19780417"), "（年金支払）対象者生年月日");
        exNumericEquals(nenkinSiharaiSakuinKekkaLst.get(7).getNksyouhnsdno(), 37, "（年金支払）商品世代番号");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(8).getNknksysyno(), "11807111222", "（年金支払）年金証書番号");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(8).getNknkkankeisyakbn(),
            C_NkKankeisyaKbn.HHKN_NKUKTBETU, "（年金支払）年金支払関係者区分");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(8).getNknkkojinkbn(), "05", "（年金支払）年金支払個人区分");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(8).getNkkykymd(),
            BizDate.valueOf("20080402"), "（年金支払）契約日");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(8).getNknkshrstartymd(),
            BizDate.valueOf("20080409"), "（年金支払）年金支払開始日");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(8).getNknksyoumetucd(),
            C_NkSyoumetuCd.SIBOU, "（年金支払）年金消滅コード");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(8).getNksyoumetuymd(),
            BizDate.valueOf("20050518"), "（年金支払）消滅日");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(8).getNksyouhncd(), "nk", "（年金支払）商品コード");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(8).getNknenkinsyu(), "01", "（年金支払）年金種類");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(8).getNktaisyouseiymd(),
            BizDate.valueOf("19780418"), "（年金支払）対象者生年月日");
        exNumericEquals(nenkinSiharaiSakuinKekkaLst.get(8).getNksyouhnsdno(), 38, "（年金支払）商品世代番号");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(9).getNknksysyno(), "11807111222", "（年金支払）年金証書番号");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(9).getNknkkankeisyakbn(),
            C_NkKankeisyaKbn.HHKN_NKUKTBETU, "（年金支払）年金支払関係者区分");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(9).getNknkkojinkbn(), "05", "（年金支払）年金支払個人区分");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(9).getNkkykymd(),
            BizDate.valueOf("20090402"), "（年金支払）契約日");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(9).getNknkshrstartymd(),
            BizDate.valueOf("20090409"), "（年金支払）年金支払開始日");

        exClassificationEquals(nenkinSiharaiSakuinKekkaLst.get(9).getNknksyoumetucd(),
            C_NkSyoumetuCd.SIBOU, "（年金支払）年金消滅コード");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(9).getNksyoumetuymd(),
            BizDate.valueOf("20050519"), "（年金支払）消滅日");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(9).getNksyouhncd(), "nk", "（年金支払）商品コード");

        exStringEquals(nenkinSiharaiSakuinKekkaLst.get(9).getNknenkinsyu(), "01", "（年金支払）年金種類");
        exDateEquals(nenkinSiharaiSakuinKekkaLst.get(9).getNktaisyouseiymd(),
            BizDate.valueOf("19780419"), "（年金支払）対象者生年月日");
        exNumericEquals(nenkinSiharaiSakuinKekkaLst.get(9).getNksyouhnsdno(), 39, "（年金支払）商品世代番号");


        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSntkinfomrumukbn(),
            C_BlnktkumuKbn.ARI, "選択情報ＭＲ有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSntkinfohnsyumukbn(),
            C_BlnktkumuKbn.ARI, "選択情報反社有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSignalinfoumukbn(),
            C_BlnktkumuKbn.ARI, "シグナル情報有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSignalinfohnsyumukbn(),
            C_BlnktkumuKbn.ARI, "シグナル情報反社有無区分");


        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getGaikokupepsumukbn(),
            C_BlnktkumuKbn.ARI, "外国ＰＥＰｓ有無区分");


        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSinsntkhnsyumukbn(),
            C_BlnktkumuKbn.BLNK, "新選択情報反社有無区分");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnsibous().toString(), "12345678901", "通算総死亡Ｓ");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnninenmikeikas().toString(), "12345678902", "通算２年未経過総死亡Ｓ");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnninenkeikas().toString(), "12345678903", "通算２年経過総死亡Ｓ");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnketsibous().toString(), "12345678904", "通算決定総死亡Ｓ");

        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnketsibous2().toString(), "12345678905", "通算決定総死亡Ｓ２");

        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnsoukktjituhsgk().toString(), "12345678906", "通算総告知書実保障額");

        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnkktjituhsgk1().toString(), "12345678907", "通算告知書実保障額１");

        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnkktjituhsgk2().toString(), "12345678908", "通算告知書実保障額２");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnkktitijibrsysnjs().toString(), "12345678909", "通算告知書一時払終身等除Ｓ");

        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnnkgns().toString(), "12345678900", "通算年金原資");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnmsnynenbtsousbus().toString(), "22345678900", "通算未成年用年齢別総死亡Ｓ");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnnenbtitijibrssbs().toString(), "32345678900", "通算年齢別一時払総死亡Ｓ");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnitijibrsysnp().toString(), "32345678901", "通算一時払終身Ｐ");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnninenmikeikahtnkns().toString(), "32345678902", "通算２年未経過被転換死亡Ｓ");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnninenkeikadfp().toString(), "32345678903", "通算２年経過ＤＦＰ");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnsntktuukahijynsysns().toString(), "12345678901", "通算選択通貨建平準払終身Ｓ");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnkaigomehrtkumukbn(),
            C_UmuKbn.ARI, "通算介護前払特約有無区分");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getKykdrtentsns().toString(), "42345678900", "契約者同一代理店通算Ｓ");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSibouriskmoshukakbn(),
            C_MosHukaKbn.KA, "死亡リスク申込不可区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getKktsibouriskmoshukakbn(),
            C_MosHukaKbn.BLNK, "告知扱死亡リスク申込不可区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getItineninaienkigaitoukbn(),
            C_GaitouKbn.HIGAITOU, "１年以内延期該当区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getItekisntkhndktyhkbn(),
            C_YouhiblnkKbn.YOU, "医的選択情報ハンド決定要否区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getTtdktyuuiknkhndktyhkbn(),
            C_YouhiblnkKbn.YOU, "手続注意環境ハンド決定要否区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getUktttdktyuuiknkhndktyhkbn(),
            C_YouhiblnkKbn.YOU, "受取人用手続注意環境ハンド決定要否区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getKyhkinuktkariitkhndktyhkbn(),
            C_YouhiblnkKbn.YOU, "給付金受付有医的ハンド決定要否区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getDoujimositekihndktyhkbn(),
            C_YouhiblnkKbn.YOU, "同時申込医的ハンド決定要否区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getDoujimosknkhndktyhkbn(),
            C_YouhiblnkKbn.YOU, "同時申込環境ハンド決定要否区分");

    }

    @Test
    @TestOrder(60)
    public void testExec_B1() {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = "error1";

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = SWAKInjector
            .getInstance(BzSakuinTsnSyoukaiYokenBean.class);


        editYokenDate(bzSakuinTsnSyoukaiYokenBean);


        CoreConfig.getInstance().setProductMode(ProductMode.WEB);


        BzSakuinTsnSyoukaiMq bzSakuinTsnSyoukaiMq = SWAKInjector.getInstance(BzSakuinTsnSyoukaiMq.class);
        BzSakuinTsnSyoukaiKekkaBean bzSakuinTsnSyoukaiKekkaBean =
            bzSakuinTsnSyoukaiMq.exec(bzSakuinTsnSyoukaiYokenBean);

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getMqsyorikekkakbn(),
            C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getPalsyoukaijissiumukbn(),
            C_PalSyoukaiJissiumuKbn.NONE, "ＰＡＬあて照会実施有無区分");

    }

    @Test
    @TestOrder(70)
    public void testExec_B2() {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = "error2";

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = SWAKInjector
            .getInstance(BzSakuinTsnSyoukaiYokenBean.class);


        editYokenDate(bzSakuinTsnSyoukaiYokenBean);


        CoreConfig.getInstance().setProductMode(ProductMode.WEB);


        BzSakuinTsnSyoukaiMq bzSakuinTsnSyoukaiMq = SWAKInjector.getInstance(BzSakuinTsnSyoukaiMq.class);
        BzSakuinTsnSyoukaiKekkaBean bzSakuinTsnSyoukaiKekkaBean =
            bzSakuinTsnSyoukaiMq.exec(bzSakuinTsnSyoukaiYokenBean);

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getMqsyorikekkakbn(),
            C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getPalsyoukaijissiumukbn(),
            C_PalSyoukaiJissiumuKbn.ARI, "ＰＡＬあて照会実施有無区分");
    }

    @Test
    @TestOrder(80)
    public void testExec_B3() {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = "error3";

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = SWAKInjector
            .getInstance(BzSakuinTsnSyoukaiYokenBean.class);


        editYokenDate(bzSakuinTsnSyoukaiYokenBean);


        CoreConfig.getInstance().setProductMode(ProductMode.WEB);


        BzSakuinTsnSyoukaiMq bzSakuinTsnSyoukaiMq = SWAKInjector.getInstance(BzSakuinTsnSyoukaiMq.class);
        BzSakuinTsnSyoukaiKekkaBean bzSakuinTsnSyoukaiKekkaBean =
            bzSakuinTsnSyoukaiMq.exec(bzSakuinTsnSyoukaiYokenBean);

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getMqsyorikekkakbn(),
            C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getPalsyoukaijissiumukbn(),
            C_PalSyoukaiJissiumuKbn.NONE, "ＰＡＬあて照会実施有無区分");
    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_A7() {


        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN7;

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = SWAKInjector
            .getInstance(BzSakuinTsnSyoukaiYokenBean.class);


        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);


        editYokenDate(bzSakuinTsnSyoukaiYokenBean);


        BzSakuinTsnSyoukaiMq bzSakuinTsnSyoukaiMq = SWAKInjector.getInstance(BzSakuinTsnSyoukaiMq.class);
        BzSakuinTsnSyoukaiKekkaBean bzSakuinTsnSyoukaiKekkaBean =
            bzSakuinTsnSyoukaiMq.exec(bzSakuinTsnSyoukaiYokenBean);

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getMqsyorikekkakbn(),
            C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getPalsyoukaijissiumukbn(),
            C_PalSyoukaiJissiumuKbn.ARI, "ＰＡＬあて照会実施有無区分");

        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getAcserrcd(), "0000", "ＡＣＳ基盤エラーコード");


        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSakuininfosyoukaierrkbn(),
            C_MQSyoukaiErrorKbn.BLNK, "索引情報照会エラー区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getMrsyoukaierrkbn(),
            C_MQSyoukaiErrorKbn.BLNK, "ＭＲ照会エラー区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSignalsyoukaierrkbn(),
            C_MQSyoukaiErrorKbn.BLNK, "シグナル照会エラー区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSinsntkhnsysyoukaierrkbn(),
            C_MQSyoukaiErrorKbn.BLNK, "新選択情報反社照会エラー区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getTsngksyoukaierrkbn(),
            C_MQSyoukaiErrorKbn.BLNK, "通算金額照会エラー区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getKykdrtentsnssyoukaierrkbn(),
            C_MQSyoukaiErrorKbn.BLNK, "契約者同一代理店通算Ｓ照会エラー区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getKykdrtentsnssyoukaierrkbn(),
            C_MQSyoukaiErrorKbn.BLNK, "契約者同一代理店通算Ｓ照会エラー区分");
        bzSakuinTsnSyoukaiKekkaBean.getMossakuseikahisyoukaierrkbn();

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getHndketyhsyoukaierrkbn(),
            C_MQSyoukaiErrorKbn.BLNK, "ハンド決定要否照会エラー区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getNysjissikekkakbn(),
            C_NayoseJissiKekkaKbn.BLNK, "名寄せ実施結果区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getNysjyoutaikbn(),
            C_NayoseJyoutaiKbn.BLNK, "名寄せ状態区分");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getSakuinnmno(), "", "索引名番号");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getKykmfkensuu(), 10, "契約ＭＦ個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getMosfkensuu(), 10, "申込Ｆ個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getSntkfkensuu(), 10, "選択情報Ｆ個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getSueokifkensuu(), 10, "据置Ｆ個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getNkfkensuu(), 10, "年金Ｆ個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getKhkensuu(), 10, "契約保全個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getSkkensuu(), 10, "新契約個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getNkkensuu(), 10, "年金支払個別項目設定件数");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getKykmfkensuutyoukaumu(),
            C_BlnktkumuKbn.BLNK, "契約ＭＦ件数超過有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getMosfkensuutyoukaumu(),
            C_BlnktkumuKbn.BLNK, "申込Ｆ件数超過有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSntkfkensuutyoukaumu(),
            C_BlnktkumuKbn.BLNK, "選択情報Ｆ件数超過有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSueokifkensuutyoukaumu(),
            C_BlnktkumuKbn.BLNK, "据置Ｆ件数超過有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getNkfkensuutyoukaumu(),
            C_BlnktkumuKbn.BLNK, "年金Ｆ件数超過有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getKhkensuutyoukaumu(),
            C_BlnktkumuKbn.BLNK, "契約保全件数超過有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSkkensuutyoukaumu(),
            C_BlnktkumuKbn.BLNK, "新契約件数超過有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getNkkensuutyoukaumu(),
            C_BlnktkumuKbn.BLNK, "年金支払件数超過有無区分");


        List<BzKeiyakuMfSakuinKekkaBean> kykMfSakuinKekkaBeanLst = bzSakuinTsnSyoukaiKekkaBean
            .getBzkeiyakumfsakuinkekkabeanlist();

        exNumericEquals(kykMfSakuinKekkaBeanLst.size(), 10, "契約ＭＦ索引結果Beanリストのサイズ");

        for (int i = 0; kykMfSakuinKekkaBeanLst.size() < 10; i++) {
            exStringEquals(kykMfSakuinKekkaBeanLst.get(i).getKykmfsyono(), "11807111129", "（契約ＭＦ）証券番号");

            exClassificationEquals(kykMfSakuinKekkaBeanLst.get(i).getKykmfkykkankeisyakbn(),
                C_KankeisyaKbn.BLNK, "（契約ＭＦ）契約関係者区分");

            exStringEquals(kykMfSakuinKekkaBeanLst.get(i).getKykmfkykmfkojinkbn(), "", "（契約ＭＦ）契約ＭＦ個人区分");

            exClassificationEquals(kykMfSakuinKekkaBeanLst.get(i).getKykmfkykjyoutaikbn(),
                C_KykJyoutaiKbn.BLNK, "（契約ＭＦ）契約状態区分");
            exDateEquals(kykMfSakuinKekkaBeanLst.get(i).getKykmfkykymd(), null, "（契約ＭＦ）契約日");

            exStringEquals(kykMfSakuinKekkaBeanLst.get(i).getKykmfsyoumetucd(), "", "（契約ＭＦ）消滅コード");
            exDateEquals(kykMfSakuinKekkaBeanLst.get(i).getKykmfsyoumetuymd(), null, "（契約ＭＦ）消滅日");

            exDateYMEquals(kykMfSakuinKekkaBeanLst.get(i).getKykmfbosyuuym(), null, "（契約ＭＦ）募集年月");
            exDateEquals(kykMfSakuinKekkaBeanLst.get(i).getKykmftaisyouseiymd(), null, "（契約ＭＦ）対象者生年月日");
        }


        List<BzMousikomiFSakuinKekkaBean> mousikomiFSakuinKekkaLst =
            bzSakuinTsnSyoukaiKekkaBean.getBzmousikomifsakuinkekkabeanlist();

        exNumericEquals(mousikomiFSakuinKekkaLst.size(), 10, "申込Ｆ索引結果Beanリストのサイズ");

        for (int i = 0; mousikomiFSakuinKekkaLst.size() < 10; i++) {
            exStringEquals(mousikomiFSakuinKekkaLst.get(i).getMosfmosno(), "791112220", "（申込Ｆ）申込番号");

            exClassificationEquals(mousikomiFSakuinKekkaLst.get(i).getMosfmoskankeisyakbn(),
                C_KankeisyaKbn.BLNK, "（申込Ｆ）申込関係者区分");

            exStringEquals(mousikomiFSakuinKekkaLst.get(i).getMosfmofkojinkbn(), "", "（申込Ｆ）申込Ｆ個人区分");
            exClassificationEquals(mousikomiFSakuinKekkaLst.get(i).getMosfmfrenflg(),
                C_Mfrenflg.NONE, "（申込Ｆ）ＭＦ連動済フラグ");
            exDateEquals(mousikomiFSakuinKekkaLst.get(i).getMosfmosymd(), null, "（申込Ｆ）申込日");
            exDateEquals(mousikomiFSakuinKekkaLst.get(i).getMosfkykymd(), null, "（申込Ｆ）契約日");

            exClassificationEquals(mousikomiFSakuinKekkaLst.get(i).getMosfmossyoumetukbn(),
                C_MossyoumetuKbn.BLNK, "（申込Ｆ）申込消滅区分");
            exDateEquals(mousikomiFSakuinKekkaLst.get(i).getMosfmossyoumetukktiymd(), null, "（申込Ｆ）申込消滅確定日");

            exDateYMEquals(mousikomiFSakuinKekkaLst.get(i).getMosfbosyuuym(), null, "（申込Ｆ）募集年月");
            exDateEquals(mousikomiFSakuinKekkaLst.get(i).getMosftaisyouseiymd(), null, "（申込Ｆ）対象者生年月日");
        }

        List<BzSentakuInfoFSakuinKekkaBean> sntInfoSakuinLst = bzSakuinTsnSyoukaiKekkaBean
            .getBzsentakuinfofsakuinkekkabeanlist();

        exNumericEquals(sntInfoSakuinLst.size(), 10, "選択情報Ｆ索引結果Beanリストのサイズ");

        for (int i = 0; sntInfoSakuinLst.size() < 10; i++) {
            exStringEquals(sntInfoSakuinLst.get(i).getSntkinfono(), "10000000003", "選択情報番号");

            exClassificationEquals(sntInfoSakuinLst.get(i).getSntkinfokankeisyakbn(), C_KankeisyaKbn.BLNK,
                "選択情報関係者区分");

            exStringEquals(sntInfoSakuinLst.get(i).getSntkinfofkojinkbn(), "", "選択情報Ｆ個人区分");

            exClassificationEquals(sntInfoSakuinLst.get(i).getSntkinfokbn(), C_SntkinfoKbn.BLNK, "選択情報区分");
            exDateEquals(sntInfoSakuinLst.get(i).getSntkinfosakuseiymd(), null, "選択情報作成日");

            exClassificationEquals(sntInfoSakuinLst.get(i).getMrumukbn(), C_BlnktkumuKbn.BLNK, "ＭＲ有無区分");

            exClassificationEquals(sntInfoSakuinLst.get(i).getDecumukbn(), C_BlnktkumuKbn.BLNK, "ＤＥＣ有無区分");

            exClassificationEquals(sntInfoSakuinLst.get(i).getInfokoukanumukbn(), C_BlnktkumuKbn.BLNK, "情報交換有無区分");

            exClassificationEquals(sntInfoSakuinLst.get(i).getNyuuinkyhkshrumukbn(), C_BlnktkumuKbn.BLNK, "入院給付金支払有無区分");

            exClassificationEquals(sntInfoSakuinLst.get(i).getSyujyutukyhkshrumukbn(), C_BlnktkumuKbn.BLNK,
                "手術給付金支払有無区分");

            exClassificationEquals(sntInfoSakuinLst.get(i).getSyougaikyhkshrumukbn(), C_BlnktkumuKbn.BLNK,
                "障害給付金支払有無区分");

            exClassificationEquals(sntInfoSakuinLst.get(i).getKoudosyougaiumukbn(), C_BlnktkumuKbn.BLNK, "高度障害有無区分");

            exClassificationEquals(sntInfoSakuinLst.get(i).getPmenumukbn(), C_BlnktkumuKbn.BLNK, "Ｐ免有無区分");

            exClassificationEquals(sntInfoSakuinLst.get(i).getTorikaijoumukbn(), C_BlnktkumuKbn.BLNK, "取消解除有無区分");

            exClassificationEquals(sntInfoSakuinLst.get(i).getSoukikeakyhkshrumukbn(), C_BlnktkumuKbn.BLNK,
                "早期ケア給付金支払有無区分");

            exClassificationEquals(sntInfoSakuinLst.get(i).getSonotakyhkshrumukbn(), C_BlnktkumuKbn.BLNK,
                "その他給付金支払有無区分");

            exClassificationEquals(sntInfoSakuinLst.get(i).getKghsjjtkyhkshrumukbn(), C_BlnktkumuKbn.BLNK,
                "介護保障充実給付金支払有無区分");

            exClassificationEquals(sntInfoSakuinLst.get(i).getHuho2mrumukbn(), C_BlnktkumuKbn.BLNK, "普保ⅡＭＲ有無区分");

            exClassificationEquals(sntInfoSakuinLst.get(i).getHuho2decumukbn(), C_BlnktkumuKbn.BLNK, "普保ⅡＤＥＣ有無区分");

            exClassificationEquals(sntInfoSakuinLst.get(i).getHuho2kdumukbn(), C_BlnktkumuKbn.BLNK, "普保Ⅱ高度障害有無区分");

            exClassificationEquals(sntInfoSakuinLst.get(i).getHuho2torikaijoumukbn(), C_BlnktkumuKbn.BLNK,
                "普保Ⅱ取消解除有無区分");
        }


        List<BzHokenkinSueokiFSakuinKekkaBean> hokenkinSueokFLst = bzSakuinTsnSyoukaiKekkaBean
            .getBzhokenkinsueokifsakuinkekkabeanlist();
        exNumericEquals(hokenkinSueokFLst.size(), 10, "保険金据置Ｆ索引結果Beanリストのサイズ");

        for (int i = 0; hokenkinSueokFLst.size() < 10; i++) {
            exStringEquals(hokenkinSueokFLst.get(i).getSueokifsysyno(), "11807111174", "（据置Ｆ）証書番号");

            exClassificationEquals(hokenkinSueokFLst.get(i).getSueokifhknkinkankeisyakbn(),
                C_KankeisyaKbn.BLNK, "（据置Ｆ）保険金据置関係者区分");

            exStringEquals(hokenkinSueokFLst.get(i).getSueokifhknkinkojinkbn(), "", "（据置Ｆ）保険金据置Ｆ個人区分");

            exClassificationEquals(hokenkinSueokFLst.get(i).getSueokifsueokijtkbn(),
                C_SueokiJyoutaiKbn.BLNK, "（据置Ｆ）据置状態区分");
            exDateEquals(hokenkinSueokFLst.get(i).getSueokifsueokikaisiymd(), null, "（申込Ｆ）据置開始日");
            exNumericEquals(hokenkinSueokFLst.get(i).getSueokifsueokikkn(), 0, "（据置Ｆ）据置期間");
            exDateEquals(hokenkinSueokFLst.get(i).getSueokifuktseiymd(), null, "（申込Ｆ）受取人生年月日");
        }


        List<BzSougouNenkinSiharaiFSakuinKekkaBean> sougouNkShrFSakuinLst = bzSakuinTsnSyoukaiKekkaBean
            .getBzsougounenkinsiharaifsakuinkekkabeanlist();

        exNumericEquals(sougouNkShrFSakuinLst.size(), 10, "総合年金支払Ｆ索引結果Beanリストのサイズ");

        for (int i = 0; sougouNkShrFSakuinLst.size() < 10; i++) {
            exStringEquals(sougouNkShrFSakuinLst.get(i).getSounenfnksysyno(), "11807111211", "（総年Ｆ）年金証書番号");

            exClassificationEquals(sougouNkShrFSakuinLst.get(i).getSounenfnkkankeisyakbn(),
                C_NkKankeisyaKbn.BLNK, "（総年Ｆ）年金支払関係者区分");

            exStringEquals(sougouNkShrFSakuinLst.get(i).getSounenfsougounkfkojinkbn(),
                "", "（総年Ｆ）総合年金支払Ｆ個人区分");

            exClassificationEquals(sougouNkShrFSakuinLst.get(i).getSounenfkykjyoutaikbn(),
                C_SounenfKykJyoutaiKbn.BLNK, "（総年Ｆ）契約状態区分");
            exDateEquals(sougouNkShrFSakuinLst.get(i).getSounenfsyokainkshrymd(), null, "（総年Ｆ）初回年金支払日");
            exDateEquals(sougouNkShrFSakuinLst.get(i).getSounenfkykymd(), null, "（総年Ｆ）契約日");

            exStringEquals(sougouNkShrFSakuinLst.get(i).getSounenfnksyoumetucd(), "", "（総年Ｆ）年金消滅コード");
            exDateEquals(sougouNkShrFSakuinLst.get(i).getSounenfsyoumetuymd(), null, "（総年Ｆ）消滅日");
            exDateEquals(sougouNkShrFSakuinLst.get(i).getSounenftaisyouseiymd(), null, "（総年Ｆ）対象生年月日");
        }


        List<BzKeiyakuHozenSakuinKekkaBean> kykhSakuinLst = bzSakuinTsnSyoukaiKekkaBean
            .getBzkeiyakuhozensakuinkekkabeanlist();

        exNumericEquals(kykhSakuinLst.size(), 10, "契約保全索引結果Beanリストのサイズ");

        for (int i = 0; kykhSakuinLst.size() < 10; i++) {
            exStringEquals(kykhSakuinLst.get(i).getKhsyono(), "11807111163", "（契約保全）証券番号");

            exClassificationEquals(kykhSakuinLst.get(i).getKhkykkankeisyakbn(),
                C_KankeisyaKbn.BLNK, "（契約保全）契約関係者区分");

            exStringEquals(kykhSakuinLst.get(i).getKhkykfkojinkbn(), "", "（契約保全）契約Ｆ個人区分");

            exClassificationEquals(kykhSakuinLst.get(i).getKhyuukousyoumetukbn(),
                C_YuukousyoumetuKbn.BLNK, "（契約保全）有効消滅区分");

            exClassificationEquals(kykhSakuinLst.get(i).getKhkykjyoutai(),
                C_Kykjyoutai.BLNK, "（契約保全）契約状態");
            exDateEquals(kykhSakuinLst.get(i).getKhkykymd(), null, "（契約保全）契約日");
            exClassificationEquals(kykhSakuinLst.get(i).getKhsyoumetujiyuu(),
                C_Syoumetujiyuu.BLNK, "（契約保全）消滅事由");
            exDateEquals(kykhSakuinLst.get(i).getKhsyoumetuymd(), null, "（契約保全）消滅日");

            exStringEquals(kykhSakuinLst.get(i).getKhsyouhncd(), "", "（契約保全）商品コード");

            exDateYMEquals(kykhSakuinLst.get(i).getKhbosyuuym(), null, "（契約保全）募集年月");
            exDateEquals(kykhSakuinLst.get(i).getKhtaisyouseiymd(), null, "（契約保全）対象者年月日");
            exNumericEquals(kykhSakuinLst.get(0).getKhsyouhnsdno(), 0, "（契約保全）商品世代番号");
        }


        List<BzSinkeiyakuSakuinKekkaBean> skSakuinLst = bzSakuinTsnSyoukaiKekkaBean
            .getBzsinkeiyakusakuinkekkabeanlist();

        exNumericEquals(skSakuinLst.size(), 10, "新契約索引結果Beanリストのサイズ");

        for (int i = 0; skSakuinLst.size() < 10; i++) {
            exStringEquals(skSakuinLst.get(i).getSkmosno(), "791112402", "（新契約）申込番号");

            exClassificationEquals(skSakuinLst.get(i).getSkmoskankeisyakbn(),
                C_KankeisyaKbn.BLNK, "（新契約）申込関係者区分");

            exStringEquals(skSakuinLst.get(i).getSkmosfkojinkbn(), "", "（新契約）申込Ｆ個人区分");
            exClassificationEquals(skSakuinLst.get(i).getSkmfrenflg(),
                C_Mfrenflg.NONE, "（新契約）ＭＦ連動済フラグ");
            exDateEquals(skSakuinLst.get(i).getSkmosymd(), null, "（新契約）申込日");

            exDateEquals(skSakuinLst.get(i).getSkkykymd(), null, "（新契約）契約日");

            exClassificationEquals(skSakuinLst.get(i).getSkseiritukbn(),
                C_SeirituKbn.BLNK, "（新契約）成立区分");
            exDateEquals(skSakuinLst.get(i).getSksrsyoriymd(), null, "（新契約）成立処理日");

            exStringEquals(skSakuinLst.get(i).getSksyouhncd(), "", "（新契約）商品コード");

            assertNull("（新契約）募集年月", skSakuinLst.get(i).getSkbosyuuym());

            exClassificationEquals(skSakuinLst.get(i).getSktaisyounayosejtkbn(),
                C_NayoseJyoutaiKbn.BLNK, "（新契約）対象者名寄せ状態区分");
            exStringEquals(skSakuinLst.get(i).getSktaisyousakuinnmno(), "", "（新契約）対象者索引名番号");
            assertNull("（新契約）対象者生年月日", skSakuinLst.get(i).getSktaisyouseiymd());
            exNumericEquals(skSakuinLst.get(0).getSksyouhnsdno(), 0, "（新契約）商品世代番号");
        }


        List<BzNenkinSiharaiSakuinKekkaBean> nkShrSakuinLst = bzSakuinTsnSyoukaiKekkaBean
            .getBznenkinsiharaisakuinkekkabeanlist();


        exNumericEquals(nkShrSakuinLst.size(), 10, "年金支払索引結果Beanリストのサイズ");

        for (int i = 0; nkShrSakuinLst.size() < 10; i++) {
            exStringEquals(nkShrSakuinLst.get(i).getNknksysyno(), "11807111222", "（年金支払）年金証書番号");

            exClassificationEquals(nkShrSakuinLst.get(i).getNknkkankeisyakbn(),
                C_NkKankeisyaKbn.BLNK, "（年金支払）年金支払関係者区分");

            exStringEquals(nkShrSakuinLst.get(i).getNknkkojinkbn(), "", "（年金支払）年金支払個人区分");
            exDateEquals(nkShrSakuinLst.get(i).getNkkykymd(), null, "（年金支払）契約日");
            exDateEquals(nkShrSakuinLst.get(i).getNknkshrstartymd(), null, "（年金支払）年金支払開始日");

            exClassificationEquals(nkShrSakuinLst.get(i).getNknksyoumetucd(), C_NkSyoumetuCd.BLNK, "（年金支払）年金消滅コード");
            exDateEquals(nkShrSakuinLst.get(i).getNksyoumetuymd(), null, "（年金支払）消滅日");

            exStringEquals(nkShrSakuinLst.get(i).getNksyouhncd(), "", "（年金支払）商品コード");

            exStringEquals(nkShrSakuinLst.get(i).getNknenkinsyu(), "", "（年金支払）年金種類");
            exDateEquals(nkShrSakuinLst.get(i).getNktaisyouseiymd(), null, "（年金支払）対象者生年月日");
            exNumericEquals(nkShrSakuinLst.get(i).getNksyouhnsdno(), 0, "（年金支払）商品世代番号");
        }


        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSntkinfomrumukbn(),
            C_BlnktkumuKbn.BLNK, "選択情報ＭＲ有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSntkinfohnsyumukbn(),
            C_BlnktkumuKbn.BLNK, "選択情報反社有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSignalinfoumukbn(),
            C_BlnktkumuKbn.BLNK, "シグナル情報有無区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSignalinfohnsyumukbn(),
            C_BlnktkumuKbn.BLNK, "シグナル情報反社有無区分");


        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getGaikokupepsumukbn(),
            C_BlnktkumuKbn.BLNK, "外国ＰＥＰｓ有無区分");


        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSinsntkhnsyumukbn(),
            C_BlnktkumuKbn.BLNK, "新選択情報反社有無区分");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnsibous().toString(), "0", "通算総死亡Ｓ");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnninenmikeikas().toString(), "0", "通算２年未経過総死亡Ｓ");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnninenkeikas().toString(), "0", "通算２年経過総死亡Ｓ");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnketsibous().toString(), "0", "通算決定総死亡Ｓ");

        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnketsibous2().toString(), "0", "通算決定総死亡Ｓ２");

        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnsoukktjituhsgk().toString(), "0", "通算総告知書実保障額");

        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnkktjituhsgk1().toString(), "0", "通算告知書実保障額１");

        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnkktjituhsgk2().toString(), "0", "通算告知書実保障額２");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnkktitijibrsysnjs().toString(), "0", "通算告知書一時払終身等除Ｓ");

        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnnkgns().toString(), "0", "通算年金原資");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnmsnynenbtsousbus().toString(), "0", "通算未成年用年齢別総死亡Ｓ");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnnenbtitijibrssbs().toString(), "0", "通算年齢別一時払総死亡Ｓ");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnitijibrsysnp().toString(), "0", "通算一時払終身Ｐ");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnninenkeikas().toString(), "0", "通算２年未経過被転換死亡Ｓ");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnninenkeikadfp().toString(), "0", "通算２年経過ＤＦＰ");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnsntktuukahijynsysns().toString(), "0", "通算選択通貨建平準払終身Ｓ");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getTsnkaigomehrtkumukbn(), C_UmuKbn.NONE, "通算介護前払特約有無区分");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getKykdrtentsns().toString(), "0", "契約者同一代理店通算Ｓ");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSibouriskmoshukakbn(),
            C_MosHukaKbn.BLNK, "死亡リスク申込不可区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getKktsibouriskmoshukakbn(),
            C_MosHukaKbn.BLNK, "告知扱死亡リスク申込不可区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getItineninaienkigaitoukbn(),
            C_GaitouKbn.BLNK, "１年以内延期該当区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getItekisntkhndktyhkbn(),
            C_YouhiblnkKbn.BLNK, "医的選択情報ハンド決定要否区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getTtdktyuuiknkhndktyhkbn(),
            C_YouhiblnkKbn.BLNK, "手続注意環境ハンド決定要否区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getUktttdktyuuiknkhndktyhkbn(),
            C_YouhiblnkKbn.BLNK, "受取人用手続注意環境ハンド決定要否区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getKyhkinuktkariitkhndktyhkbn(),
            C_YouhiblnkKbn.BLNK, "給付金受付有医的ハンド決定要否区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getDoujimositekihndktyhkbn(),
            C_YouhiblnkKbn.BLNK, "同時申込医的ハンド決定要否区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getDoujimosknkhndktyhkbn(),
            C_YouhiblnkKbn.BLNK, "同時申込環境ハンド決定要否区分");

    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testExec_A8() {


        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN8;

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = SWAKInjector
            .getInstance(BzSakuinTsnSyoukaiYokenBean.class);


        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);


        editYokenDate(bzSakuinTsnSyoukaiYokenBean);

        BzSakuinTsnSyoukaiMq bzSakuinTsnSyoukaiMq = SWAKInjector.getInstance(BzSakuinTsnSyoukaiMq.class);
        BzSakuinTsnSyoukaiKekkaBean bzSakuinTsnSyoukaiKekkaBean =
            bzSakuinTsnSyoukaiMq.exec(bzSakuinTsnSyoukaiYokenBean);

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getMqsyorikekkakbn(),
            C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getPalsyoukaijissiumukbn(),
            C_PalSyoukaiJissiumuKbn.ARI, "ＰＡＬあて照会実施有無区分");

        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getAcserrcd(), "0000", "ＡＣＳ基盤エラーコード");

        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getKykmfkensuu(), 0, "契約ＭＦ個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getMosfkensuu(), 0, "申込Ｆ個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getSntkfkensuu(), 0, "選択情報Ｆ個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getSueokifkensuu(), 0, "据置Ｆ個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getNkfkensuu(), 0, "年金Ｆ個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getKhkensuu(), 0, "契約保全個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getSkkensuu(), 0, "新契約個別項目設定件数");
        exNumericEquals(bzSakuinTsnSyoukaiKekkaBean.getNkkensuu(), 0, "年金支払個別項目設定件数");

    }

    @Test
    @TestOrder(110)
    public void testExec_A9() {

        MockObjectManager.initialize();


        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN2;

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean =
            SWAKInjector.getInstance(BzSakuinTsnSyoukaiYokenBean.class);


        CoreConfig.getInstance().setProductMode(ProductMode.WEB);


        editYokenDateb2(bzSakuinTsnSyoukaiYokenBean);

        editDataToNull(bzSakuinTsnSyoukaiYokenBean);


        BzSakuinTsnSyoukaiMq bzSakuinTsnSyoukaiMq = SWAKInjector.getInstance(BzSakuinTsnSyoukaiMq.class);
        BzSakuinTsnSyoukaiKekkaBean bzSakuinTsnSyoukaiKekkaBean =
            bzSakuinTsnSyoukaiMq.exec(bzSakuinTsnSyoukaiYokenBean);


        exStringEquals((String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 0),
            null, "処理コード");
        String bzSakuinTsnSyoukai = (String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 1);

        exStringEquals(bzSakuinTsnSyoukai.substring(0, 4), "    ", "処理コード");
        exStringEquals(bzSakuinTsnSyoukai.substring(4, 5), ".", "区切符号");

        exStringEquals(bzSakuinTsnSyoukai.substring(5, 6), " ", "索引通算照会区分");

        exStringEquals(bzSakuinTsnSyoukai.substring(6, 7), " ", "普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukai.substring(7, 18), "11807111129", "普保Ⅱ契約番号");

        exStringEquals(bzSakuinTsnSyoukai.substring(18, 19), " ", "対象者区分");
        exStringEquals(bzSakuinTsnSyoukai.substring(19, 37), "ﾀｲｼｮｳｼｬ           ", "対象者姓名");
        exStringEquals(bzSakuinTsnSyoukai.substring(37, 52), "対象者　　　　　　　　　　　　", "対象者漢字姓名");
        exStringEquals(bzSakuinTsnSyoukai.substring(52, 60), "19900311", "対象者生年月日");
        exStringEquals(bzSakuinTsnSyoukai.substring(60, 67), "4354008", "対象者郵便番号");
        exStringEquals(bzSakuinTsnSyoukai.substring(67, 74), "4354112", "被保険者新郵便番号");

        exStringEquals(bzSakuinTsnSyoukai.substring(74, 77), "001", "被保険者職業コード");

        exStringEquals(bzSakuinTsnSyoukai.substring(77, 95), "ｶﾝｹｲｲﾁ            ", "関係者名１");

        exStringEquals(bzSakuinTsnSyoukai.substring(95, 110), "関係者一　　　　　　　　　　　", "漢字関係者名１");

        exStringEquals(bzSakuinTsnSyoukai.substring(110, 128), "ｶﾝｹｲﾆ             ", "関係者名２");

        exStringEquals(bzSakuinTsnSyoukai.substring(128, 143), "関係者二　　　　　　　　　　　", "漢字関係者名２");

        exStringEquals(bzSakuinTsnSyoukai.substring(143, 161), "ｶﾝｹｲｻﾝ            ", "関係者名３");

        exStringEquals(bzSakuinTsnSyoukai.substring(161, 176), "関係者三　　　　　　　　　　　", "漢字関係者名３");

        exStringEquals(bzSakuinTsnSyoukai.substring(176, 194), "ｶﾝｹｲﾖ             ", "関係者名４");

        exStringEquals(bzSakuinTsnSyoukai.substring(194, 209), "関係者四　　　　　　　　　　　", "漢字関係者名４");

        exStringEquals(bzSakuinTsnSyoukai.substring(209, 227), "ｶﾝｹｲｺﾞ            ", "関係者名５");

        exStringEquals(bzSakuinTsnSyoukai.substring(227, 242), "関係者五　　　　　　　　　　　", "漢字関係者名５");

        exStringEquals(bzSakuinTsnSyoukai.substring(242, 249), "KrCd01 ", "Ａ扱者組織コード");

        exStringEquals(bzSakuinTsnSyoukai.substring(249, 256), "KrCd02 ", "Ｂ扱者組織コード");
        exStringEquals(bzSakuinTsnSyoukai.substring(256, 270), "1560824187    ", "通信先電話番号");
        exStringEquals(bzSakuinTsnSyoukai.substring(270, 271), " ", "払込経路");
        exStringEquals(bzSakuinTsnSyoukai.substring(271, 275), "7998", "銀行番号");
        exStringEquals(bzSakuinTsnSyoukai.substring(275, 278), "122", "支店番号");

        exStringEquals(bzSakuinTsnSyoukai.substring(278, 279), " ", "預金種目区分");
        exStringEquals(bzSakuinTsnSyoukai.substring(279, 286), "0115923", "口座番号");
        exStringEquals(bzSakuinTsnSyoukai.substring(286, 287), " ", "索引情報照会表示");

        exStringEquals(bzSakuinTsnSyoukai.substring(287, 288), " ", "索引対象契約区分");

        exStringEquals(bzSakuinTsnSyoukai.substring(288, 289), " ", "索引対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukai.substring(289, 300), "10000000003", "索引対象外普保Ⅱ契約番号");
        exStringEquals(bzSakuinTsnSyoukai.substring(300, 308), "19961014", "索引基準年月日");
        exStringEquals(bzSakuinTsnSyoukai.substring(308, 309), " ", "ＭＲシグナル照会表示");

        exStringEquals(bzSakuinTsnSyoukai.substring(309, 310), " ", "ＭＲシグナル判定業務区分");
        exStringEquals(bzSakuinTsnSyoukai.substring(310, 311), " ", "通算金額照会表示");

        exStringEquals(bzSakuinTsnSyoukai.substring(311, 312), " ", "通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukai.substring(312, 323), "11807111130", "通算対象外普保Ⅱ契約番号");
        exStringEquals(bzSakuinTsnSyoukai.substring(323, 331), "19880526", "通算基準年月日");
        exStringEquals(bzSakuinTsnSyoukai.substring(331, 332), " ", "契約者同一代理店通算Ｓ照会表示");

        exStringEquals(bzSakuinTsnSyoukai.substring(332, 333), " ", "代理店通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukai.substring(333, 344), "17808000020", "代理店通算対象外普保Ⅱ契約番号");
        exStringEquals(bzSakuinTsnSyoukai.substring(344, 352), "19881112", "契約者同一代理店通算基準年月日");

        exStringEquals(bzSakuinTsnSyoukai.substring(352, 359), "DrCd01 ", "Ａ扱者代理店コード");

        exStringEquals(bzSakuinTsnSyoukai.substring(359, 366), "DrCd02 ", "Ｂ扱者代理店コード");
        exStringEquals(bzSakuinTsnSyoukai.substring(366, 367), " ", "申込書作成可否照会表示");
        exStringEquals(bzSakuinTsnSyoukai.substring(367), " ", "ハンド決定要否照会表示");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getMqsyorikekkakbn(),
            C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getPalsyoukaijissiumukbn(),
            C_PalSyoukaiJissiumuKbn.ARI, "ＰＡＬあて照会実施有無区分");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getAcserrcd(),
            "5434", "ＡＣＳ基盤エラーコード");
    }

    @Test
    @TestOrder(120)
    public void testExec_A10() {

        MockObjectManager.initialize();


        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN2;

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean =
            SWAKInjector.getInstance(BzSakuinTsnSyoukaiYokenBean.class);


        CoreConfig.getInstance().setProductMode(ProductMode.WEB);


        editYokenDateb3(bzSakuinTsnSyoukaiYokenBean);

        editDataToNull(bzSakuinTsnSyoukaiYokenBean);


        BzSakuinTsnSyoukaiMq bzSakuinTsnSyoukaiMq = SWAKInjector.getInstance(BzSakuinTsnSyoukaiMq.class);
        BzSakuinTsnSyoukaiKekkaBean bzSakuinTsnSyoukaiKekkaBean =
            bzSakuinTsnSyoukaiMq.exec(bzSakuinTsnSyoukaiYokenBean);


        exStringEquals((String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 0),
            null, "処理コード");
        String bzSakuinTsnSyoukai = (String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 1);

        exStringEquals(bzSakuinTsnSyoukai.substring(0, 4), "    ", "処理コード");
        exStringEquals(bzSakuinTsnSyoukai.substring(4, 5), ".", "区切符号");

        exStringEquals(bzSakuinTsnSyoukai.substring(5, 6), " ", "索引通算照会区分");

        exStringEquals(bzSakuinTsnSyoukai.substring(6, 7), " ", "普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukai.substring(7, 18), "11807111129", "普保Ⅱ契約番号");

        exStringEquals(bzSakuinTsnSyoukai.substring(18, 19), " ", "対象者区分");
        exStringEquals(bzSakuinTsnSyoukai.substring(19, 37), "ﾀｲｼｮｳｼｬ           ", "対象者姓名");
        exStringEquals(bzSakuinTsnSyoukai.substring(37, 52), "対象者　　　　　　　　　　　　", "対象者漢字姓名");
        exStringEquals(bzSakuinTsnSyoukai.substring(52, 60), "19900311", "対象者生年月日");
        exStringEquals(bzSakuinTsnSyoukai.substring(60, 67), "4354008", "対象者郵便番号");
        exStringEquals(bzSakuinTsnSyoukai.substring(67, 74), "4354112", "被保険者新郵便番号");

        exStringEquals(bzSakuinTsnSyoukai.substring(74, 77), "001", "被保険者職業コード");

        exStringEquals(bzSakuinTsnSyoukai.substring(77, 95), "ｶﾝｹｲｲﾁ            ", "関係者名１");

        exStringEquals(bzSakuinTsnSyoukai.substring(95, 110), "関係者一　　　　　　　　　　　", "漢字関係者名１");

        exStringEquals(bzSakuinTsnSyoukai.substring(110, 128), "ｶﾝｹｲﾆ             ", "関係者名２");

        exStringEquals(bzSakuinTsnSyoukai.substring(128, 143), "関係者二　　　　　　　　　　　", "漢字関係者名２");

        exStringEquals(bzSakuinTsnSyoukai.substring(143, 161), "ｶﾝｹｲｻﾝ            ", "関係者名３");

        exStringEquals(bzSakuinTsnSyoukai.substring(161, 176), "関係者三　　　　　　　　　　　", "漢字関係者名３");

        exStringEquals(bzSakuinTsnSyoukai.substring(176, 194), "ｶﾝｹｲﾖ             ", "関係者名４");

        exStringEquals(bzSakuinTsnSyoukai.substring(194, 209), "関係者四　　　　　　　　　　　", "漢字関係者名４");

        exStringEquals(bzSakuinTsnSyoukai.substring(209, 227), "ｶﾝｹｲｺﾞ            ", "関係者名５");

        exStringEquals(bzSakuinTsnSyoukai.substring(227, 242), "関係者五　　　　　　　　　　　", "漢字関係者名５");

        exStringEquals(bzSakuinTsnSyoukai.substring(242, 249), "KrCd01 ", "Ａ扱者組織コード");

        exStringEquals(bzSakuinTsnSyoukai.substring(249, 256), "KrCd02 ", "Ｂ扱者組織コード");
        exStringEquals(bzSakuinTsnSyoukai.substring(256, 270), "1560824187    ", "通信先電話番号");
        exStringEquals(bzSakuinTsnSyoukai.substring(270, 271), " ", "払込経路");
        exStringEquals(bzSakuinTsnSyoukai.substring(271, 275), "0799", "銀行番号");
        exStringEquals(bzSakuinTsnSyoukai.substring(275, 278), "   ", "支店番号");

        exStringEquals(bzSakuinTsnSyoukai.substring(278, 279), " ", "預金種目区分");
        exStringEquals(bzSakuinTsnSyoukai.substring(279, 286), "       ", "口座番号");
        exStringEquals(bzSakuinTsnSyoukai.substring(286, 287), " ", "索引情報照会表示");

        exStringEquals(bzSakuinTsnSyoukai.substring(287, 288), " ", "索引対象契約区分");

        exStringEquals(bzSakuinTsnSyoukai.substring(288, 289), " ", "索引対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukai.substring(289, 300), "10000000003", "索引対象外普保Ⅱ契約番号");
        exStringEquals(bzSakuinTsnSyoukai.substring(300, 308), "19961014", "索引基準年月日");
        exStringEquals(bzSakuinTsnSyoukai.substring(308, 309), " ", "ＭＲシグナル照会表示");

        exStringEquals(bzSakuinTsnSyoukai.substring(309, 310), " ", "ＭＲシグナル判定業務区分");
        exStringEquals(bzSakuinTsnSyoukai.substring(310, 311), " ", "通算金額照会表示");

        exStringEquals(bzSakuinTsnSyoukai.substring(311, 312), " ", "通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukai.substring(312, 323), "11807111130", "通算対象外普保Ⅱ契約番号");
        exStringEquals(bzSakuinTsnSyoukai.substring(323, 331), "19880526", "通算基準年月日");
        exStringEquals(bzSakuinTsnSyoukai.substring(331, 332), " ", "契約者同一代理店通算Ｓ照会表示");

        exStringEquals(bzSakuinTsnSyoukai.substring(332, 333), " ", "代理店通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukai.substring(333, 344), "17808000020", "代理店通算対象外普保Ⅱ契約番号");
        exStringEquals(bzSakuinTsnSyoukai.substring(344, 352), "19881112", "契約者同一代理店通算基準年月日");

        exStringEquals(bzSakuinTsnSyoukai.substring(352, 359), "DrCd01 ", "Ａ扱者代理店コード");

        exStringEquals(bzSakuinTsnSyoukai.substring(359, 366), "DrCd02 ", "Ｂ扱者代理店コード");
        exStringEquals(bzSakuinTsnSyoukai.substring(366, 367), " ", "申込書作成可否照会表示");
        exStringEquals(bzSakuinTsnSyoukai.substring(367), " ", "ハンド決定要否照会表示");

        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getMqsyorikekkakbn(),
            C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getPalsyoukaijissiumukbn(),
            C_PalSyoukaiJissiumuKbn.ARI, "ＰＡＬあて照会実施有無区分");
        exStringEquals(bzSakuinTsnSyoukaiKekkaBean.getAcserrcd(),
            "5434", "ＡＣＳ基盤エラーコード");
    }
}
