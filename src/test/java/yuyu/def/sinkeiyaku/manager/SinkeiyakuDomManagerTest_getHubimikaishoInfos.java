package yuyu.def.sinkeiyaku.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.result.bean.HubimikaishoInfosBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getHubimikaishoInfos() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getHubimikaishoInfos {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        ExDBResults<HubimikaishoInfosBean> beans = sinkeiyakuDomManager.
            getHubimikaishoInfos();

        int iCount = 0;
        for (HubimikaishoInfosBean fKSKbean : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");
        syoriCTL1.setMosnrkymd(BizDate.valueOf(20160211));
        syoriCTL1.setKetteikbn(C_KetteiKbn.NONE);
        syoriCTL1.setSeiritukbn(C_SeirituKbn.NONE);

        HT_MosKihon mosKihon1 = syoriCTL1.createMosKihon();
        mosKihon1.setKykkbn(C_KykKbn.BLNK);
        mosKihon1.setHknsyuruino(C_HknsyuruiNo.BLNK);
        mosKihon1.setHrktuukasyu(C_Tuukasyu.AUD);
        mosKihon1.setMosfstpkei(BizCurrency.valueOf(100));
        mosKihon1.setHhknnmkj("王");
        mosKihon1.setKyknmkj("浩");

        HT_MosDairiten mosDairiten1 = syoriCTL1.createMosDairiten();
        mosDairiten1.setRenno(1);
        mosDairiten1.setTratkiagcd("10001");
        mosDairiten1.setOyadrtencd("100001");

        HT_MosDairiten mosDairiten5 = syoriCTL1.createMosDairiten();
        mosDairiten5.setRenno(2);
        mosDairiten5.setTratkiagcd("10002");
        mosDairiten5.setOyadrtencd("100002");

        HT_SkHubi skHubi1 = syoriCTL1.createSkHubi();
        skHubi1.setHubisikibetukey("201520161001");
        skHubi1.setUtdskknnm1kj("新契約");

        HT_SkHubiDetail skHubiDetail1 = skHubi1.createSkHubiDetail();
        skHubiDetail1.setRenno3keta(111);
        skHubiDetail1.setHasinymd(BizDate.valueOf(20160215));

        HT_SkHubiDetail skHubiDetail2 = skHubi1.createSkHubiDetail();
        skHubiDetail2.setRenno3keta(114);
        skHubiDetail2.setHasinymd(BizDate.valueOf(20160215));

        HT_SkHubiDetail skHubiDetail3 = skHubi1.createSkHubiDetail();
        skHubiDetail3.setRenno3keta(115);
        skHubiDetail3.setHasinymd(BizDate.valueOf(20160215));

        HT_SkHubiDetail skHubiDetail6 = skHubi1.createSkHubiDetail();
        skHubiDetail6.setRenno3keta(112);
        skHubiDetail6.setHasinymd(BizDate.valueOf(20160215));
        skHubiDetail6.setKaisyouymd(BizDate.valueOf(20160215));

        HT_SkHubiDetail skHubiDetail7 = skHubi1.createSkHubiDetail();
        skHubiDetail7.setRenno3keta(113);

        HT_SkHubi skHubi3 = syoriCTL1.createSkHubi();
        skHubi3.setHubisikibetukey("201520161004");
        skHubi3.setUtdskknnm1kj("新契約");

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");
        syoriCTL2.setMosnrkymd(BizDate.valueOf(20160211));
        syoriCTL2.setKetteikbn(C_KetteiKbn.NONE);
        syoriCTL2.setSeiritukbn(C_SeirituKbn.NONE);

        HT_MosKihon mosKihon2 = syoriCTL2.createMosKihon();
        mosKihon2.setKykkbn(C_KykKbn.BLNK);
        mosKihon2.setHknsyuruino(C_HknsyuruiNo.BLNK);
        mosKihon2.setHrktuukasyu(C_Tuukasyu.AUD);
        mosKihon2.setMosfstpkei(BizCurrency.valueOf(100));
        mosKihon2.setHhknnmkj("王");
        mosKihon2.setKyknmkj("浩");

        HT_MosDairiten mosDairiten2 = syoriCTL2.createMosDairiten();
        mosDairiten2.setRenno(1);
        mosDairiten2.setTratkiagcd("10001");
        mosDairiten2.setOyadrtencd("100001");

        HT_SkHubi skHubi2 = syoriCTL2.createSkHubi();
        skHubi2.setHubisikibetukey("201520161001");
        skHubi2.setUtdskknnm1kj("新契約");

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");
        syoriCTL3.setMosnrkymd(BizDate.valueOf(20160211));
        syoriCTL3.setKetteikbn(C_KetteiKbn.NONE);
        syoriCTL3.setSeiritukbn(C_SeirituKbn.HUSEIRITU);

        HT_MosKihon mosKihon3 = syoriCTL3.createMosKihon();
        mosKihon3.setKykkbn(C_KykKbn.BLNK);
        mosKihon3.setHknsyuruino(C_HknsyuruiNo.BLNK);
        mosKihon3.setHrktuukasyu(C_Tuukasyu.AUD);
        mosKihon3.setMosfstpkei(BizCurrency.valueOf(100));
        mosKihon3.setHhknnmkj("王");
        mosKihon3.setKyknmkj("浩");

        HT_MosDairiten mosDairiten3 = syoriCTL3.createMosDairiten();
        mosDairiten3.setRenno(1);
        mosDairiten3.setTratkiagcd("10001");
        mosDairiten3.setOyadrtencd("100001");

        HT_SkHubi skHubi4 = syoriCTL3.createSkHubi();
        skHubi4.setHubisikibetukey("201520161001");
        skHubi4.setUtdskknnm1kj("新契約");

        HT_SkHubiDetail skHubiDetail8 = skHubi4.createSkHubiDetail();
        skHubiDetail8.setRenno3keta(111);
        skHubiDetail8.setHasinymd(BizDate.valueOf(20160215));

        sinkeiyakuDomManager.insert(syoriCTL3);

        HT_SyoriCTL syoriCTL4 = new HT_SyoriCTL("791112253");
        syoriCTL4.setMosnrkymd(BizDate.valueOf(20160211));
        syoriCTL4.setKetteikbn(C_KetteiKbn.NONE);
        syoriCTL4.setSeiritukbn(C_SeirituKbn.NONE);

        HT_MosDairiten mosDairiten4 = syoriCTL4.createMosDairiten();
        mosDairiten4.setRenno(1);
        mosDairiten4.setTratkiagcd("10001");
        mosDairiten4.setOyadrtencd("100001");

        HT_SkHubi skHubi5 = syoriCTL4.createSkHubi();
        skHubi5.setHubisikibetukey("201520161001");
        skHubi5.setUtdskknnm1kj("新契約");

        HT_SkHubiDetail skHubiDetail9 = skHubi5.createSkHubiDetail();
        skHubiDetail9.setRenno3keta(111);
        skHubiDetail9.setHasinymd(BizDate.valueOf(20160215));

        sinkeiyakuDomManager.insert(syoriCTL4);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal20() {


        ExDBResults<HubimikaishoInfosBean> beans = sinkeiyakuDomManager.
            getHubimikaishoInfos();

        int iCount = 0;
        for (HubimikaishoInfosBean fKSKbean : beans) {
            iCount++;

            if (1 == iCount) {

                Assert.assertEquals("791112220", fKSKbean.getMosnoSkHubi());
                Assert.assertEquals("201520161001", fKSKbean.getHubisikibetukey());
                Assert.assertEquals("新契約", fKSKbean.getUtdskknnm1kj());
                Assert.assertEquals("791112220", fKSKbean.getMosnoSyoriCTL());
                Assert.assertEquals(C_KetteiKbn.NONE, fKSKbean.getKetteikbn());
                Assert.assertEquals(BizDate.valueOf(20160211), fKSKbean.getMosnrkymd());
                Assert.assertEquals(C_KykKbn.BLNK, fKSKbean.getKykkbn());
                Assert.assertEquals("王", fKSKbean.getHhknnmkj());
                Assert.assertEquals("浩", fKSKbean.getKyknmkj());
                Assert.assertEquals(C_HknsyuruiNo.BLNK, fKSKbean.getHknsyuruino());
                Assert.assertEquals(BizCurrency.valueOf(100), fKSKbean.getMosfstpkei());
                Assert.assertEquals(C_Tuukasyu.AUD, fKSKbean.getHrktuukasyu());
                Assert.assertEquals("100001", fKSKbean.getOyadrtencd());
                Assert.assertEquals("10001", fKSKbean.getTratkiagcd());
            }
        }

        Assert.assertEquals(1, iCount);

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal30() {
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");
        syoriCTL1.setMosnrkymd(BizDate.valueOf(20160211));
        syoriCTL1.setKetteikbn(C_KetteiKbn.NONE);
        syoriCTL1.setSeiritukbn(C_SeirituKbn.NONE);

        HT_MosKihon mosKihon1 = syoriCTL1.createMosKihon();
        mosKihon1.setKykkbn(C_KykKbn.BLNK);
        mosKihon1.setHknsyuruino(C_HknsyuruiNo.BLNK);
        mosKihon1.setHrktuukasyu(C_Tuukasyu.AUD);
        mosKihon1.setMosfstpkei(BizCurrency.valueOf(100));
        mosKihon1.setHhknnmkj("王");
        mosKihon1.setKyknmkj("浩");

        HT_MosDairiten mosDairiten1 = syoriCTL1.createMosDairiten();
        mosDairiten1.setRenno(1);
        mosDairiten1.setTratkiagcd("10001");
        mosDairiten1.setOyadrtencd("100001");

        HT_SkHubi skHubi1 = syoriCTL1.createSkHubi();
        skHubi1.setHubisikibetukey("201520161001");
        skHubi1.setUtdskknnm1kj("契約保全");

        HT_SkHubiDetail skHubiDetail1 = skHubi1.createSkHubiDetail();
        skHubiDetail1.setRenno3keta(111);
        skHubiDetail1.setHasinymd(BizDate.valueOf(20160220));

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");
        syoriCTL2.setMosnrkymd(BizDate.valueOf(20160211));
        syoriCTL2.setKetteikbn(C_KetteiKbn.NONE);
        syoriCTL2.setSeiritukbn(C_SeirituKbn.SEIRITU);

        HT_MosKihon mosKihon2 = syoriCTL2.createMosKihon();
        mosKihon2.setKykkbn(C_KykKbn.BLNK);
        mosKihon2.setHknsyuruino(C_HknsyuruiNo.BLNK);
        mosKihon2.setHrktuukasyu(C_Tuukasyu.AUD);
        mosKihon2.setMosfstpkei(BizCurrency.valueOf(100));
        mosKihon2.setHhknnmkj("王");
        mosKihon2.setKyknmkj("浩");

        HT_MosDairiten mosDairiten2 = syoriCTL2.createMosDairiten();
        mosDairiten2.setRenno(1);
        mosDairiten2.setTratkiagcd("10001");
        mosDairiten2.setOyadrtencd("100003");

        HT_SkHubi skHubi2 = syoriCTL2.createSkHubi();
        skHubi2.setHubisikibetukey("201520161001");
        skHubi2.setUtdskknnm1kj("契約保全");

        HT_SkHubiDetail skHubiDetail2 = skHubi2.createSkHubiDetail();
        skHubiDetail2.setRenno3keta(111);
        skHubiDetail2.setHasinymd(BizDate.valueOf(20160220));

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");
        syoriCTL3.setMosnrkymd(BizDate.valueOf(20160211));
        syoriCTL3.setKetteikbn(C_KetteiKbn.NONE);
        syoriCTL3.setSeiritukbn(C_SeirituKbn.ITIPMATI);

        HT_MosKihon mosKihon3 = syoriCTL3.createMosKihon();
        mosKihon3.setKykkbn(C_KykKbn.BLNK);
        mosKihon3.setHknsyuruino(C_HknsyuruiNo.BLNK);
        mosKihon3.setHrktuukasyu(C_Tuukasyu.AUD);
        mosKihon3.setMosfstpkei(BizCurrency.valueOf(100));
        mosKihon3.setHhknnmkj("王");
        mosKihon3.setKyknmkj("浩");

        HT_MosDairiten mosDairiten3 = syoriCTL3.createMosDairiten();
        mosDairiten3.setRenno(1);
        mosDairiten3.setTratkiagcd("10001");
        mosDairiten3.setOyadrtencd("100002");

        HT_SkHubi skHubi3 = syoriCTL3.createSkHubi();
        skHubi3.setHubisikibetukey("201520161001");
        skHubi3.setUtdskknnm1kj("契約保全");

        HT_SkHubiDetail skHubiDetail3 = skHubi3.createSkHubiDetail();
        skHubiDetail3.setRenno3keta(111);
        skHubiDetail3.setHasinymd(BizDate.valueOf(20160220));

        sinkeiyakuDomManager.insert(syoriCTL3);

        HT_SyoriCTL syoriCTL4 = new HT_SyoriCTL("791112253");
        syoriCTL4.setMosnrkymd(BizDate.valueOf(20160220));
        syoriCTL4.setKetteikbn(C_KetteiKbn.NONE);
        syoriCTL4.setSeiritukbn(C_SeirituKbn.NONE);

        HT_MosKihon mosKihon4 = syoriCTL4.createMosKihon();
        mosKihon4.setKykkbn(C_KykKbn.BLNK);
        mosKihon4.setHknsyuruino(C_HknsyuruiNo.BLNK);
        mosKihon4.setHrktuukasyu(C_Tuukasyu.AUD);
        mosKihon4.setMosfstpkei(BizCurrency.valueOf(100));
        mosKihon4.setHhknnmkj("王");
        mosKihon4.setKyknmkj("浩");

        HT_MosDairiten mosDairiten4 = syoriCTL4.createMosDairiten();
        mosDairiten4.setRenno(1);
        mosDairiten4.setTratkiagcd("10001");
        mosDairiten4.setOyadrtencd("100003");

        HT_SkHubi skHubi4 = syoriCTL4.createSkHubi();
        skHubi4.setHubisikibetukey("201520161001");
        skHubi4.setUtdskknnm1kj("契約保全");

        HT_SkHubiDetail skHubiDetail4 = skHubi4.createSkHubiDetail();
        skHubiDetail4.setRenno3keta(111);
        skHubiDetail4.setHasinymd(BizDate.valueOf(20160220));

        sinkeiyakuDomManager.insert(syoriCTL4);

        HT_SyoriCTL syoriCTL5 = new HT_SyoriCTL("791112261");
        syoriCTL5.setMosnrkymd(BizDate.valueOf(20160215));
        syoriCTL5.setKetteikbn(C_KetteiKbn.NONE);
        syoriCTL5.setSeiritukbn(C_SeirituKbn.SEIRITU);

        HT_MosKihon mosKihon5 = syoriCTL5.createMosKihon();
        mosKihon5.setKykkbn(C_KykKbn.BLNK);
        mosKihon5.setHknsyuruino(C_HknsyuruiNo.BLNK);
        mosKihon5.setHrktuukasyu(C_Tuukasyu.AUD);
        mosKihon5.setMosfstpkei(BizCurrency.valueOf(100));
        mosKihon5.setHhknnmkj("王");
        mosKihon5.setKyknmkj("浩");

        HT_MosDairiten mosDairiten5 = syoriCTL5.createMosDairiten();
        mosDairiten5.setRenno(1);
        mosDairiten5.setTratkiagcd("10001");
        mosDairiten5.setOyadrtencd("100003");

        HT_SkHubi skHubi5 = syoriCTL5.createSkHubi();
        skHubi5.setHubisikibetukey("201520161001");
        skHubi5.setUtdskknnm1kj("契約保全");

        HT_SkHubiDetail skHubiDetail5 = skHubi5.createSkHubiDetail();
        skHubiDetail5.setRenno3keta(111);
        skHubiDetail5.setHasinymd(BizDate.valueOf(20160220));

        sinkeiyakuDomManager.insert(syoriCTL5);

        HT_SyoriCTL syoriCTL6 = new HT_SyoriCTL("791112287");
        syoriCTL6.setMosnrkymd(BizDate.valueOf(20160220));
        syoriCTL6.setKetteikbn(C_KetteiKbn.NONE);
        syoriCTL6.setSeiritukbn(C_SeirituKbn.ITIPMATI);

        HT_MosKihon mosKihon6 = syoriCTL6.createMosKihon();
        mosKihon6.setKykkbn(C_KykKbn.BLNK);
        mosKihon6.setHknsyuruino(C_HknsyuruiNo.BLNK);
        mosKihon6.setHrktuukasyu(C_Tuukasyu.AUD);
        mosKihon6.setMosfstpkei(BizCurrency.valueOf(100));
        mosKihon6.setHhknnmkj("王");
        mosKihon6.setKyknmkj("浩");

        HT_SkHubi skHubi6 = syoriCTL6.createSkHubi();
        skHubi6.setHubisikibetukey("201520161001");
        skHubi6.setUtdskknnm1kj("契約保全");

        HT_SkHubiDetail skHubiDetail6 = skHubi6.createSkHubiDetail();
        skHubiDetail6.setRenno3keta(111);
        skHubiDetail6.setHasinymd(BizDate.valueOf(20160220));

        sinkeiyakuDomManager.insert(syoriCTL6);

        HT_SyoriCTL syoriCTL7 = new HT_SyoriCTL("791112279");
        syoriCTL7.setMosnrkymd(BizDate.valueOf(20160220));
        syoriCTL7.setKetteikbn(C_KetteiKbn.NONE);
        syoriCTL7.setSeiritukbn(C_SeirituKbn.NONE);

        HT_MosKihon mosKihon7 = syoriCTL7.createMosKihon();
        mosKihon7.setKykkbn(C_KykKbn.BLNK);
        mosKihon7.setHknsyuruino(C_HknsyuruiNo.BLNK);
        mosKihon7.setHrktuukasyu(C_Tuukasyu.AUD);
        mosKihon7.setMosfstpkei(BizCurrency.valueOf(100));
        mosKihon7.setHhknnmkj("王");
        mosKihon7.setKyknmkj("浩");

        HT_MosDairiten mosDairiten6 = syoriCTL7.createMosDairiten();
        mosDairiten6.setRenno(1);
        mosDairiten6.setTratkiagcd("10001");
        mosDairiten6.setOyadrtencd("100003");

        HT_SkHubi skHubi7 = syoriCTL7.createSkHubi();
        skHubi7.setHubisikibetukey("201520161001");
        skHubi7.setUtdskknnm1kj("契約保全");

        HT_SkHubiDetail skHubiDetail7 = skHubi7.createSkHubiDetail();
        skHubiDetail7.setRenno3keta(111);
        skHubiDetail7.setHasinymd(BizDate.valueOf(20160220));

        sinkeiyakuDomManager.insert(syoriCTL7);
    }

    @Test
    @TestOrder(31)
    @Transactional
    public void normal31() {

        ExDBResults<HubimikaishoInfosBean> beans = sinkeiyakuDomManager.
            getHubimikaishoInfos();

        int iCount = 0;
        for (HubimikaishoInfosBean fKSKbean : beans) {
            iCount++;

            if (1 == iCount) {

                Assert.assertEquals("791112220", fKSKbean.getMosnoSkHubi());
                Assert.assertEquals("201520161001", fKSKbean.getHubisikibetukey());
                Assert.assertEquals("契約保全", fKSKbean.getUtdskknnm1kj());
                Assert.assertEquals("791112220", fKSKbean.getMosnoSyoriCTL());
                Assert.assertEquals(C_KetteiKbn.NONE, fKSKbean.getKetteikbn());
                Assert.assertEquals(BizDate.valueOf(20160211), fKSKbean.getMosnrkymd());
                Assert.assertEquals(C_KykKbn.BLNK, fKSKbean.getKykkbn());
                Assert.assertEquals("王", fKSKbean.getHhknnmkj());
                Assert.assertEquals("浩", fKSKbean.getKyknmkj());
                Assert.assertEquals(C_HknsyuruiNo.BLNK, fKSKbean.getHknsyuruino());
                Assert.assertEquals(BizCurrency.valueOf(100), fKSKbean.getMosfstpkei());
                Assert.assertEquals(C_Tuukasyu.AUD, fKSKbean.getHrktuukasyu());
                Assert.assertEquals("100001", fKSKbean.getOyadrtencd());
                Assert.assertEquals("10001", fKSKbean.getTratkiagcd());

            }

            if (2 == iCount) {

                Assert.assertEquals("791112246", fKSKbean.getMosnoSkHubi());
                Assert.assertEquals("201520161001", fKSKbean.getHubisikibetukey());
                Assert.assertEquals("契約保全", fKSKbean.getUtdskknnm1kj());
                Assert.assertEquals("791112246", fKSKbean.getMosnoSyoriCTL());
                Assert.assertEquals(C_KetteiKbn.NONE, fKSKbean.getKetteikbn());
                Assert.assertEquals(BizDate.valueOf(20160211), fKSKbean.getMosnrkymd());
                Assert.assertEquals(C_KykKbn.BLNK, fKSKbean.getKykkbn());
                Assert.assertEquals("王", fKSKbean.getHhknnmkj());
                Assert.assertEquals("浩", fKSKbean.getKyknmkj());
                Assert.assertEquals(C_HknsyuruiNo.BLNK, fKSKbean.getHknsyuruino());
                Assert.assertEquals(BizCurrency.valueOf(100), fKSKbean.getMosfstpkei());
                Assert.assertEquals(C_Tuukasyu.AUD, fKSKbean.getHrktuukasyu());
                Assert.assertEquals("100002", fKSKbean.getOyadrtencd());
                Assert.assertEquals("10001", fKSKbean.getTratkiagcd());
            }

            if (3 == iCount) {

                Assert.assertEquals("791112238", fKSKbean.getMosnoSkHubi());
                Assert.assertEquals("201520161001", fKSKbean.getHubisikibetukey());
                Assert.assertEquals("契約保全", fKSKbean.getUtdskknnm1kj());
                Assert.assertEquals("791112238", fKSKbean.getMosnoSyoriCTL());
                Assert.assertEquals(C_KetteiKbn.NONE, fKSKbean.getKetteikbn());
                Assert.assertEquals(BizDate.valueOf(20160211), fKSKbean.getMosnrkymd());
                Assert.assertEquals(C_KykKbn.BLNK, fKSKbean.getKykkbn());
                Assert.assertEquals("王", fKSKbean.getHhknnmkj());
                Assert.assertEquals("浩", fKSKbean.getKyknmkj());
                Assert.assertEquals(C_HknsyuruiNo.BLNK, fKSKbean.getHknsyuruino());
                Assert.assertEquals(BizCurrency.valueOf(100), fKSKbean.getMosfstpkei());
                Assert.assertEquals(C_Tuukasyu.AUD, fKSKbean.getHrktuukasyu());
                Assert.assertEquals("100003", fKSKbean.getOyadrtencd());
                Assert.assertEquals("10001", fKSKbean.getTratkiagcd());
            }
            if (4 == iCount) {

                Assert.assertEquals("791112261", fKSKbean.getMosnoSkHubi());
                Assert.assertEquals("201520161001", fKSKbean.getHubisikibetukey());
                Assert.assertEquals("契約保全", fKSKbean.getUtdskknnm1kj());
                Assert.assertEquals("791112261", fKSKbean.getMosnoSyoriCTL());
                Assert.assertEquals(C_KetteiKbn.NONE, fKSKbean.getKetteikbn());
                Assert.assertEquals(BizDate.valueOf(20160215), fKSKbean.getMosnrkymd());
                Assert.assertEquals(C_KykKbn.BLNK, fKSKbean.getKykkbn());
                Assert.assertEquals("王", fKSKbean.getHhknnmkj());
                Assert.assertEquals("浩", fKSKbean.getKyknmkj());
                Assert.assertEquals(C_HknsyuruiNo.BLNK, fKSKbean.getHknsyuruino());
                Assert.assertEquals(BizCurrency.valueOf(100), fKSKbean.getMosfstpkei());
                Assert.assertEquals(C_Tuukasyu.AUD, fKSKbean.getHrktuukasyu());
                Assert.assertEquals("100003", fKSKbean.getOyadrtencd());
                Assert.assertEquals("10001", fKSKbean.getTratkiagcd());
            }

            if (5 == iCount) {

                Assert.assertEquals("791112253", fKSKbean.getMosnoSkHubi());
                Assert.assertEquals("201520161001", fKSKbean.getHubisikibetukey());
                Assert.assertEquals("契約保全", fKSKbean.getUtdskknnm1kj());
                Assert.assertEquals("791112253", fKSKbean.getMosnoSyoriCTL());
                Assert.assertEquals(C_KetteiKbn.NONE, fKSKbean.getKetteikbn());
                Assert.assertEquals(BizDate.valueOf(20160220), fKSKbean.getMosnrkymd());
                Assert.assertEquals(C_KykKbn.BLNK, fKSKbean.getKykkbn());
                Assert.assertEquals("王", fKSKbean.getHhknnmkj());
                Assert.assertEquals("浩", fKSKbean.getKyknmkj());
                Assert.assertEquals(C_HknsyuruiNo.BLNK, fKSKbean.getHknsyuruino());
                Assert.assertEquals(BizCurrency.valueOf(100), fKSKbean.getMosfstpkei());
                Assert.assertEquals(C_Tuukasyu.AUD, fKSKbean.getHrktuukasyu());
                Assert.assertEquals("100003", fKSKbean.getOyadrtencd());
                Assert.assertEquals("10001", fKSKbean.getTratkiagcd());
            }
            if (6 == iCount) {

                Assert.assertEquals("791112279", fKSKbean.getMosnoSkHubi());
                Assert.assertEquals("201520161001", fKSKbean.getHubisikibetukey());
                Assert.assertEquals("契約保全", fKSKbean.getUtdskknnm1kj());
                Assert.assertEquals("791112279", fKSKbean.getMosnoSyoriCTL());
                Assert.assertEquals(C_KetteiKbn.NONE, fKSKbean.getKetteikbn());
                Assert.assertEquals(BizDate.valueOf(20160220), fKSKbean.getMosnrkymd());
                Assert.assertEquals(C_KykKbn.BLNK, fKSKbean.getKykkbn());
                Assert.assertEquals("王", fKSKbean.getHhknnmkj());
                Assert.assertEquals("浩", fKSKbean.getKyknmkj());
                Assert.assertEquals(C_HknsyuruiNo.BLNK, fKSKbean.getHknsyuruino());
                Assert.assertEquals(BizCurrency.valueOf(100), fKSKbean.getMosfstpkei());
                Assert.assertEquals(C_Tuukasyu.AUD, fKSKbean.getHrktuukasyu());
                Assert.assertEquals("100003", fKSKbean.getOyadrtencd());
                Assert.assertEquals("10001", fKSKbean.getTratkiagcd());

            }

            if (7 == iCount) {

                Assert.assertEquals("791112287", fKSKbean.getMosnoSkHubi());
                Assert.assertEquals("201520161001", fKSKbean.getHubisikibetukey());
                Assert.assertEquals("契約保全", fKSKbean.getUtdskknnm1kj());
                Assert.assertEquals("791112287", fKSKbean.getMosnoSyoriCTL());
                Assert.assertEquals(C_KetteiKbn.NONE, fKSKbean.getKetteikbn());
                Assert.assertEquals(BizDate.valueOf(20160220), fKSKbean.getMosnrkymd());
                Assert.assertEquals(C_KykKbn.BLNK, fKSKbean.getKykkbn());
                Assert.assertEquals("王", fKSKbean.getHhknnmkj());
                Assert.assertEquals("浩", fKSKbean.getKyknmkj());
                Assert.assertEquals(C_HknsyuruiNo.BLNK, fKSKbean.getHknsyuruino());
                Assert.assertEquals(BizCurrency.valueOf(100), fKSKbean.getMosfstpkei());
                Assert.assertEquals(C_Tuukasyu.AUD, fKSKbean.getHrktuukasyu());
                Assert.assertEquals(null, fKSKbean.getOyadrtencd());
                Assert.assertEquals(null, fKSKbean.getTratkiagcd());
            }
        }
        Assert.assertEquals(7, iCount);

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void normal40() {
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");
        syoriCTL1.setKetteikbn(C_KetteiKbn.valueOf("0"));
        syoriCTL1.setSeiritukbn(C_SeirituKbn.valueOf("3"));

        HT_MosKihon mosKihon1 = syoriCTL1.createMosKihon();
        mosKihon1.setKykkbn(C_KykKbn.valueOf("0"));
        mosKihon1.setHknsyuruino(C_HknsyuruiNo.valueOf("000"));
        mosKihon1.setHrktuukasyu(C_Tuukasyu.valueOf("AUD"));
        mosKihon1.setMosfstpkei(BizCurrency.valueOf(100));
        mosKihon1.setHhknnmkj("王");
        mosKihon1.setKyknmkj("浩");

        HT_MosDairiten mosDairiten1 = syoriCTL1.createMosDairiten();
        mosDairiten1.setRenno(2);
        mosDairiten1.setTratkiagcd("10001");
        mosDairiten1.setOyadrtencd("100001");

        HT_SkHubi skHubi1 = syoriCTL1.createSkHubi();
        skHubi1.setHubisikibetukey("201520161001");
        skHubi1.setUtdskknnm1kj("新契約");

        HT_SkHubiDetail skHubiDetail1 = skHubi1.createSkHubiDetail();
        skHubiDetail1.setRenno3keta(111);
        skHubiDetail1.setKaisyouymd(BizDate.valueOf(20160215));

        sinkeiyakuDomManager.insert(syoriCTL1);
    }

    @Test
    @TestOrder(41)
    public void noResult1() {
        ExDBResults<HubimikaishoInfosBean> beans = sinkeiyakuDomManager.
            getHubimikaishoInfos();

        int iCount = 0;
        for (HubimikaishoInfosBean fKSKbean : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);
    }
}

