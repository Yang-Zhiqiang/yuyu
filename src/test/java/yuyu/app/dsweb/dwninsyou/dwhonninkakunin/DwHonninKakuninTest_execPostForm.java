package yuyu.app.dsweb.dwninsyou.dwhonninkakunin;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_BaitaiKbn;
import yuyu.def.classification.C_DsKokyakuJtKbn;
import yuyu.def.classification.C_DsSyoriKbn;
import yuyu.def.classification.C_DsTeisiRiyuuKbn;
import yuyu.def.classification.C_HnkSyuruiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.MT_BAK_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsHenkouRireki;
import yuyu.def.db.entity.MT_DsHonninKakuninCd;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.entity.MT_DsLoginKanri;
import yuyu.def.db.entity.MT_DsTtdkRireki;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 本人確認処理のメイン処理{@link DwHonninKakuninImpl#execPostForm(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings("unchecked")
public class DwHonninKakuninTest_execPostForm extends AbstractTest{

    @Inject
    private DwHonninKakuninImpl dwHonninKakuninImpl;

    @Inject
    private DirectDomManager directDomManager;

    @Before
    public void beforeTest() {
        changeSystemDate(BizDate.valueOf("20160510"));
    }


    private BizDate sysDate;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111129");
        IT_KykKihon kykKihon2 = hozenDomManager.getKykKihon("11807111130");
        IT_KykKihon kykKihon3 = hozenDomManager.getKykKihon("11807111141");
        IT_KykKihon kykKihon4 = hozenDomManager.getKykKihon("11807111152");
        IT_KykKihon kykKihon5 = hozenDomManager.getKykKihon("11807111163");
        IT_KykKihon kykKihon6 = hozenDomManager.getKykKihon("11807111174");
        IT_KykKihon kykKihon7 = hozenDomManager.getKykKihon("11807111185");
        IT_KykKihon kykKihon8 = hozenDomManager.getKykKihon("11807111196");
        IT_KykKihon kykKihon9 = hozenDomManager.getKykKihon("11807111200");
        IT_KykKihon kykKihon10 = hozenDomManager.getKykKihon("11807111222");
        IT_KykKihon kykKihon11 = hozenDomManager.getKykKihon("11807111244");
        IT_KykKihon kykKihon12 = hozenDomManager.getKykKihon("11807111255");
        IT_KykKihon kykKihon13 = hozenDomManager.getKykKihon("11807111266");
        IT_KykKihon kykKihon14 = hozenDomManager.getKykKihon("11807111277");
        IT_KykKihon kykKihon15 = hozenDomManager.getKykKihon("17806000013");

        if (kykKihon1 == null) {

            kykKihon1 = new IT_KykKihon("11807111129");
            kykKihon1.setSyono("11807111129");
            kykKihon1.setKbnkey("02");
            kykKihon1.setVersion(1);

            IT_KykSya kykSya = kykKihon1.createKykSya();
            kykSya.setSyono("11807111129");
            kykSya.setKbnkey("02");
            kykSya.setKyknmkn("カタ　ナ");
            kykSya.setKykseiymd(BizDate.valueOf("19880414"));
            kykSya.setTsintelno("03-7856-3383");
            kykSya.setVersion(1);

            hozenDomManager.insert(kykKihon1);
        }

        if (kykKihon2 == null) {

            kykKihon2 = new IT_KykKihon("11807111130");
            kykKihon2.setSyono("11807111130");
            kykKihon2.setKbnkey("03");
            kykKihon2.setVersion(1);

            IT_KykSya kykSya = kykKihon2.createKykSya();
            kykSya.setSyono("11807111130");
            kykSya.setKbnkey("03");
            kykSya.setKyknmkn("サク　ラ");
            kykSya.setKykseiymd(BizDate.valueOf("19880406"));
            kykSya.setTsintelno("03-7856-3383");
            kykSya.setVersion(1);

            hozenDomManager.insert(kykKihon2);
        }

        if (kykKihon3 == null) {

            kykKihon3 = new IT_KykKihon("11807111141");
            kykKihon3.setSyono("11807111141");
            kykKihon3.setKbnkey("04");
            kykKihon3.setVersion(1);

            IT_KykSya kykSya = kykKihon3.createKykSya();
            kykSya.setSyono("11807111141");
            kykSya.setKbnkey("04");
            kykSya.setKyknmkn("サクラ　");
            kykSya.setKykseiymd(BizDate.valueOf("19880414"));
            kykSya.setTsintelno("03-7856-3381");
            kykSya.setVersion(1);

            hozenDomManager.insert(kykKihon3);
        }

        if (kykKihon4 == null) {

            kykKihon4 = new IT_KykKihon("11807111152");
            kykKihon4.setSyono("11807111152");
            kykKihon4.setKbnkey("05");
            kykKihon4.setVersion(1);

            IT_KykSya kykSya = kykKihon4.createKykSya();
            kykSya.setSyono("11807111152");
            kykSya.setKbnkey("05");
            kykSya.setKyknmkn("サクラ　");
            kykSya.setKykseiymd(BizDate.valueOf("19900406"));
            kykSya.setTsintelno("03-7856-3383");
            kykSya.setVersion(1);

            hozenDomManager.insert(kykKihon4);
        }

        if (kykKihon5 == null) {

            kykKihon5 = new IT_KykKihon("11807111163");
            kykKihon5.setSyono("11807111163");
            kykKihon5.setKbnkey("06");
            kykKihon5.setVersion(1);

            IT_KykSya kykSya = kykKihon5.createKykSya();
            kykSya.setSyono("11807111163");
            kykSya.setKbnkey("06");
            kykSya.setKyknmkn("　サクラ");
            kykSya.setKykseiymd(BizDate.valueOf("19900406"));
            kykSya.setTsintelno("03-7856-3381");
            kykSya.setVersion(1);

            hozenDomManager.insert(kykKihon5);
        }

        if (kykKihon6 == null) {

            kykKihon6 = new IT_KykKihon("11807111174");
            kykKihon6.setSyono("11807111174");
            kykKihon6.setKbnkey("07");
            kykKihon6.setVersion(1);

            IT_KykSya kykSya = kykKihon6.createKykSya();
            kykSya.setSyono("11807111174");
            kykSya.setKbnkey("07");
            kykSya.setKyknmkn("　カナタ");
            kykSya.setKykseiymd(BizDate.valueOf("19900406"));
            kykSya.setTsintelno("03-7856-3381");
            kykSya.setVersion(1);

            hozenDomManager.insert(kykKihon6);
        }

        if (kykKihon7 == null) {

            kykKihon7 = new IT_KykKihon("11807111185");
            kykKihon7.setSyono("11807111185");
            kykKihon7.setKbnkey("08");
            kykKihon7.setVersion(1);

            IT_KykSya kykSya = kykKihon7.createKykSya();
            kykSya.setSyono("11807111185");
            kykSya.setKbnkey("08");
            kykSya.setKyknmkn("サ　ク　ラ");
            kykSya.setKykseiymd(BizDate.valueOf("19900406"));
            kykSya.setTsintelno("03-7856-3381");
            kykSya.setVersion(1);

            hozenDomManager.insert(kykKihon7);
        }

        if (kykKihon8 == null) {

            kykKihon8 = new IT_KykKihon("11807111196");
            kykKihon8.setSyono("11807111196");
            kykKihon8.setKbnkey("09");
            kykKihon8.setVersion(1);

            IT_KykSya kykSya = kykKihon8.createKykSya();
            kykSya.setSyono("11807111196");
            kykSya.setKbnkey("09");
            kykSya.setKyknmkn("カナタ");
            kykSya.setKykseiymd(BizDate.valueOf("19900406"));
            kykSya.setTsintelno("03-7856-3382");
            kykSya.setVersion(1);

            hozenDomManager.insert(kykKihon8);
        }

        if (kykKihon9 == null) {

            kykKihon9 = new IT_KykKihon("11807111200");
            kykKihon9.setSyono("11807111200");
            kykKihon9.setKbnkey("00");
            kykKihon9.setVersion(1);

            IT_KykSya kykSya = kykKihon9.createKykSya();
            kykSya.setSyono("11807111200");
            kykSya.setKbnkey("00");
            kykSya.setKyknmkn("カナタ");
            kykSya.setKykseiymd(BizDate.valueOf("19900406"));
            kykSya.setTsintelno("03-7856-3382");
            kykSya.setVersion(1);

            hozenDomManager.insert(kykKihon9);
        }
        if (kykKihon10 == null) {

            kykKihon10 = new IT_KykKihon("11807111222");
            kykKihon10.setSyono("11807111222");
            kykKihon10.setKbnkey("02");
            kykKihon10.setVersion(1);

            hozenDomManager.insert(kykKihon10);
        }
        if (kykKihon11 == null) {

            kykKihon11 = new IT_KykKihon("11807111244");
            kykKihon11.setSyono("11807111244");
            kykKihon11.setKbnkey("04");
            kykKihon11.setVersion(1);

            IT_KykSya kykSya = kykKihon11.createKykSya();
            kykSya.setSyono("11807111244");
            kykSya.setKbnkey("04");
            kykSya.setKyknmkn("カナタ");
            kykSya.setKykseiymd(BizDate.valueOf("19880414"));
            kykSya.setTsintelno("03-7856-3383");
            kykSya.setVersion(1);

            hozenDomManager.insert(kykKihon11);
        }

        if (kykKihon12 == null) {

            kykKihon12 = new IT_KykKihon("11807111255");
            kykKihon12.setSyono("11807111255");
            kykKihon12.setKbnkey("05");
            kykKihon12.setVersion(1);

            IT_KykSya kykSya = kykKihon12.createKykSya();
            kykSya.setSyono("11807111255");
            kykSya.setKbnkey("05");
            kykSya.setKyknmkn("サ　ク　ラ");
            kykSya.setKykseiymd(BizDate.valueOf("19900406"));
            kykSya.setTsintelno("03-7856-3381");
            kykSya.setVersion(1);

            hozenDomManager.insert(kykKihon12);
        }

        if (kykKihon13 == null) {

            kykKihon13 = new IT_KykKihon("11807111266");
            kykKihon13.setSyono("11807111266");
            kykKihon13.setKbnkey("06");
            kykKihon13.setVersion(1);

            IT_KykSya kykSya = kykKihon13.createKykSya();
            kykSya.setSyono("11807111266");
            kykSya.setKbnkey("06");
            kykSya.setKyknmkn("サ　ク　ラ");
            kykSya.setKykseiymd(BizDate.valueOf("19900406"));
            kykSya.setTsintelno("03-7856-3381");
            kykSya.setVersion(1);

            hozenDomManager.insert(kykKihon13);
        }

        if (kykKihon14 == null) {

            kykKihon14 = new IT_KykKihon("11807111277");
            kykKihon14.setSyono("11807111277");
            kykKihon14.setKbnkey("07");
            kykKihon14.setVersion(1);

            IT_KykSya kykSya = kykKihon14.createKykSya();
            kykSya.setSyono("11807111277");
            kykSya.setKbnkey("07");
            kykSya.setKyknmkn("サ　ク　ラ");
            kykSya.setKykseiymd(BizDate.valueOf("19900406"));
            kykSya.setTsintelno("03-7856-3381");
            kykSya.setVersion(1);

            hozenDomManager.insert(kykKihon14);
        }

        if (kykKihon15 == null) {

            kykKihon15 = new IT_KykKihon("17806000013");
            kykKihon15.setSyono("17806000013");
            kykKihon15.setKbnkey("01");
            kykKihon15.setVersion(1);

            IT_KykSya kykSya = kykKihon15.createKykSya();
            kykSya.setSyono("17806000013");
            kykSya.setKbnkey("01");
            kykSya.setKyknmkn("オアイウエ　オヤユヨツ");
            kykSya.setKykseiymd(BizDate.valueOf("19900406"));
            kykSya.setTsintelno("03-7856-3381");
            kykSya.setVersion(1);

            hozenDomManager.insert(kykKihon15);
        }

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        MT_DsKokyakuKanri dsKokyakuKanri1 = new MT_DsKokyakuKanri("0010020034");
        dsKokyakuKanri1.setDskokno("0010020034");
        dsKokyakuKanri1.setVersion(1);
        MT_DsLoginKanri dsLoginKanri1 = dsKokyakuKanri1.createDsLoginKanri();
        dsLoginKanri1.setDskokno("0010020034");
        dsLoginKanri1.setDskokyakunmerrorkaisuu(3);
        dsLoginKanri1.setDskokyakuseiymderrorkaisuu(2);
        dsLoginKanri1.setDskokyakutelnoerrorkaisuu(2);
        dsLoginKanri1.setVersion(1);
        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku1 =dsKokyakuKanri1.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku1.setDskokno("0010020034");
        dsKokyakuKeiyaku1.setSyono("11807111129");
        dsKokyakuKeiyaku1.setVersion(1);
        MT_DsHonninKakuninCd dsHonninKakuninCd1 =dsKokyakuKanri1.createDsHonninKakuninCd();
        dsHonninKakuninCd1.setDskokno("0010020034");
        dsHonninKakuninCd1.setVersion(1);
        directDomManager.insert(dsKokyakuKanri1);

        MT_DsKokyakuKanri dsKokyakuKanri2 = new MT_DsKokyakuKanri("0010020035");
        dsKokyakuKanri2.setDskokno("0010020035");
        dsKokyakuKanri2.setVersion(1);
        MT_DsLoginKanri dsLoginKanri2 = dsKokyakuKanri2.createDsLoginKanri();
        dsLoginKanri2.setDskokno("0010020035");
        dsLoginKanri2.setDskokyakunmerrorkaisuu(4);
        dsLoginKanri2.setDskokyakuseiymderrorkaisuu(2);
        dsLoginKanri2.setDskokyakutelnoerrorkaisuu(2);
        dsLoginKanri2.setVersion(1);
        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku2 =dsKokyakuKanri2.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku2.setDskokno("0010020035");
        dsKokyakuKeiyaku2.setSyono("11807111130");
        dsKokyakuKeiyaku2.setVersion(1);
        MT_DsHonninKakuninCd dsHonninKakuninCd2 =dsKokyakuKanri2.createDsHonninKakuninCd();
        dsHonninKakuninCd2.setDskokno("0010020035");
        dsHonninKakuninCd2.setVersion(1);
        directDomManager.insert(dsKokyakuKanri2);

        MT_DsKokyakuKanri dsKokyakuKanri3 = new MT_DsKokyakuKanri("0010020036");
        dsKokyakuKanri3.setDskokno("0010020036");
        dsKokyakuKanri3.setVersion(1);
        MT_DsLoginKanri dsLoginKanri3 = dsKokyakuKanri3.createDsLoginKanri();
        dsLoginKanri3.setDskokno("0010020036");
        dsLoginKanri3.setDskokyakunmerrorkaisuu(2);
        dsLoginKanri3.setDskokyakuseiymderrorkaisuu(3);
        dsLoginKanri3.setDskokyakutelnoerrorkaisuu(2);
        dsLoginKanri3.setVersion(1);
        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku3 =dsKokyakuKanri3.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku3.setDskokno("0010020036");
        dsKokyakuKeiyaku3.setSyono("11807111141");
        dsKokyakuKeiyaku3.setVersion(1);
        MT_DsHonninKakuninCd dsHonninKakuninCd3 =dsKokyakuKanri3.createDsHonninKakuninCd();
        dsHonninKakuninCd3.setDskokno("0010020036");
        dsHonninKakuninCd3.setVersion(1);
        directDomManager.insert(dsKokyakuKanri3);

        MT_DsKokyakuKanri dsKokyakuKanri4 = new MT_DsKokyakuKanri("0010020037");
        dsKokyakuKanri4.setDskokno("0010020037");
        dsKokyakuKanri4.setVersion(1);
        MT_DsLoginKanri dsLoginKanri4 = dsKokyakuKanri4.createDsLoginKanri();
        dsLoginKanri4.setDskokno("0010020037");
        dsLoginKanri4.setDskokyakunmerrorkaisuu(2);
        dsLoginKanri4.setDskokyakuseiymderrorkaisuu(4);
        dsLoginKanri4.setDskokyakutelnoerrorkaisuu(2);
        dsLoginKanri4.setVersion(1);
        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku4 =dsKokyakuKanri4.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku4.setDskokno("0010020037");
        dsKokyakuKeiyaku4.setSyono("11807111163");
        dsKokyakuKeiyaku4.setVersion(1);
        MT_DsHonninKakuninCd dsHonninKakuninCd4 =dsKokyakuKanri4.createDsHonninKakuninCd();
        dsHonninKakuninCd4.setDskokno("0010020037");
        dsHonninKakuninCd4.setVersion(1);
        directDomManager.insert(dsKokyakuKanri4);

        MT_DsKokyakuKanri dsKokyakuKanri5 = new MT_DsKokyakuKanri("0010020038");
        dsKokyakuKanri5.setDskokno("0010020038");
        dsKokyakuKanri5.setVersion(1);
        MT_DsLoginKanri dsLoginKanri5 = dsKokyakuKanri5.createDsLoginKanri();
        dsLoginKanri5.setDskokno("0010020038");
        dsLoginKanri5.setDskokyakunmerrorkaisuu(2);
        dsLoginKanri5.setDskokyakuseiymderrorkaisuu(2);
        dsLoginKanri5.setDskokyakutelnoerrorkaisuu(4);
        dsLoginKanri5.setVersion(1);
        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku5 =dsKokyakuKanri5.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku5.setDskokno("0010020038");
        dsKokyakuKeiyaku5.setSyono("11807111174");
        dsKokyakuKeiyaku5.setVersion(1);
        MT_DsHonninKakuninCd dsHonninKakuninCd5 =dsKokyakuKanri5.createDsHonninKakuninCd();
        dsHonninKakuninCd5.setDskokno("0010020038");
        dsHonninKakuninCd5.setVersion(1);
        directDomManager.insert(dsKokyakuKanri5);

        MT_DsKokyakuKanri dsKokyakuKanri6 = new MT_DsKokyakuKanri("0010020039");
        dsKokyakuKanri6.setDskokno("0010020039");
        dsKokyakuKanri6.setVersion(1);
        MT_DsLoginKanri dsLoginKanri6 = dsKokyakuKanri6.createDsLoginKanri();
        dsLoginKanri6.setDskokno("0010020039");
        dsLoginKanri6.setDskokyakunmerrorkaisuu(2);
        dsLoginKanri6.setDskokyakuseiymderrorkaisuu(2);
        dsLoginKanri6.setDskokyakutelnoerrorkaisuu(3);
        dsLoginKanri6.setVersion(1);
        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku6 =dsKokyakuKanri6.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku6.setDskokno("0010020039");
        dsKokyakuKeiyaku6.setSyono("11807111185");
        dsKokyakuKeiyaku6.setVersion(1);
        MT_DsHonninKakuninCd dsHonninKakuninCd6 =dsKokyakuKanri6.createDsHonninKakuninCd();
        dsHonninKakuninCd6.setDskokno("0010020039");
        dsHonninKakuninCd6.setVersion(1);
        directDomManager.insert(dsKokyakuKanri6);

        MT_DsKokyakuKanri dsKokyakuKanri7 = new MT_DsKokyakuKanri("0010020040");
        dsKokyakuKanri7.setDskokno("0010020040");
        dsKokyakuKanri7.setVersion(1);
        MT_DsLoginKanri dsLoginKanri7 = dsKokyakuKanri7.createDsLoginKanri();
        dsLoginKanri7.setDskokno("0010020040");
        dsLoginKanri7.setDskokyakunmerrorkaisuu(2);
        dsLoginKanri7.setDskokyakuseiymderrorkaisuu(2);
        dsLoginKanri7.setDskokyakutelnoerrorkaisuu(2);
        dsLoginKanri7.setVersion(1);
        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku7 =dsKokyakuKanri7.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku7.setDskokno("0010020040");
        dsKokyakuKeiyaku7.setSyono("11807111196");
        dsKokyakuKeiyaku7.setVersion(1);
        MT_DsHonninKakuninCd dsHonninKakuninCd7 =dsKokyakuKanri7.createDsHonninKakuninCd();
        dsHonninKakuninCd7.setDskokno("0010020040");
        dsHonninKakuninCd7.setVersion(1);
        directDomManager.insert(dsKokyakuKanri7);

        MT_DsKokyakuKanri dsKokyakuKanri8 = new MT_DsKokyakuKanri("0010020041");
        dsKokyakuKanri8.setDskokno("0010020041");
        dsKokyakuKanri8.setVersion(1);
        MT_DsLoginKanri dsLoginKanri8 = dsKokyakuKanri8.createDsLoginKanri();
        dsLoginKanri8.setDskokno("0010020041");
        dsLoginKanri8.setSyokailoginymd(BizDate.valueOf("20160102"));
        dsLoginKanri8.setSaisinloginymd(BizDate.valueOf("20160620"));
        dsLoginKanri8.setDskokyakunmerrorkaisuu(2);
        dsLoginKanri8.setDskokyakuseiymderrorkaisuu(2);
        dsLoginKanri8.setDskokyakutelnoerrorkaisuu(2);
        dsLoginKanri8.setSaisinlogintime("103034");
        dsLoginKanri8.setVersion(1);
        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku8 =dsKokyakuKanri8.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku8.setDskokno("0010020041");
        dsKokyakuKeiyaku8.setSyono("11807111200");
        dsKokyakuKeiyaku8.setVersion(1);
        MT_DsHonninKakuninCd dsHonninKakuninCd8 =dsKokyakuKanri8.createDsHonninKakuninCd();
        dsHonninKakuninCd8.setDskokno("0010020041");
        dsHonninKakuninCd8.setVersion(1);
        directDomManager.insert(dsKokyakuKanri8);

        MT_DsKokyakuKanri dsKokyakuKanri9 = new MT_DsKokyakuKanri("0010020042");
        dsKokyakuKanri9.setDskokno("0010020042");
        dsKokyakuKanri9.setVersion(1);
        MT_DsLoginKanri dsLoginKanri9 = dsKokyakuKanri9.createDsLoginKanri();
        dsLoginKanri9.setDskokno("0010020042");
        dsLoginKanri9.setSaisinloginymd(BizDate.valueOf("20160620"));
        dsLoginKanri9.setSaisinlogintime("103034");
        dsLoginKanri9.setDskokyakunmerrorkaisuu(2);
        dsLoginKanri9.setDskokyakuseiymderrorkaisuu(2);
        dsLoginKanri9.setDskokyakutelnoerrorkaisuu(2);
        dsLoginKanri9.setVersion(1);
        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku9 =dsKokyakuKanri9.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku9.setDskokno("0010020042");
        dsKokyakuKeiyaku9.setSyono("11807111222");
        dsKokyakuKeiyaku9.setVersion(1);
        MT_DsHonninKakuninCd dsHonninKakuninCd9 =dsKokyakuKanri9.createDsHonninKakuninCd();
        dsHonninKakuninCd9.setDskokno("0010020042");
        dsHonninKakuninCd9.setVersion(1);
        directDomManager.insert(dsKokyakuKanri9);

        MT_DsKokyakuKanri dsKokyakuKanri10 = new MT_DsKokyakuKanri("0010020051");
        dsKokyakuKanri10.setDskokno("0010020051");
        dsKokyakuKanri10.setVersion(1);
        MT_DsLoginKanri dsLoginKanri10 = dsKokyakuKanri10.createDsLoginKanri();
        dsLoginKanri10.setDskokno("0010020051");
        dsLoginKanri10.setDskokyakunmerrorkaisuu(9);
        dsLoginKanri10.setDskokyakuseiymderrorkaisuu(10);
        dsLoginKanri10.setDskokyakutelnoerrorkaisuu(11);
        dsLoginKanri10.setVersion(1);
        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku10 =dsKokyakuKanri10.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku10.setDskokno("0010020051");
        dsKokyakuKeiyaku10.setSyono("11807111244");
        dsKokyakuKeiyaku10.setVersion(1);
        MT_DsHonninKakuninCd dsHonninKakuninCd10 =dsKokyakuKanri10.createDsHonninKakuninCd();
        dsHonninKakuninCd10.setDskokno("0010020051");
        dsHonninKakuninCd10.setVersion(1);
        directDomManager.insert(dsKokyakuKanri10);

        MT_DsKokyakuKanri dsKokyakuKanri11 = new MT_DsKokyakuKanri("0010020052");
        dsKokyakuKanri11.setDskokno("0010020052");
        dsKokyakuKanri11.setVersion(1);
        directDomManager.insert(dsKokyakuKanri11);


        MT_DsKokyakuKanri dsKokyakuKanri12 = new MT_DsKokyakuKanri("0010020053");
        dsKokyakuKanri12.setDskokno("0010020053");
        dsKokyakuKanri12.setVersion(1);
        MT_DsLoginKanri dsLoginKanri12 = dsKokyakuKanri12.createDsLoginKanri();
        dsLoginKanri12.setDskokno("0010020053");
        dsLoginKanri12.setDskokyakunmerrorkaisuu(1);
        dsLoginKanri12.setDskokyakuseiymderrorkaisuu(2);
        dsLoginKanri12.setDskokyakutelnoerrorkaisuu(3);
        dsLoginKanri12.setVersion(1);
        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku12 =dsKokyakuKanri12.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku12.setDskokno("0010020053");
        dsKokyakuKeiyaku12.setSyono("11807111255");
        dsKokyakuKeiyaku12.setVersion(1);
        MT_DsHonninKakuninCd dsHonninKakuninCd12 =dsKokyakuKanri12.createDsHonninKakuninCd();
        dsHonninKakuninCd12.setDskokno("0010020053");
        dsHonninKakuninCd12.setVersion(1);
        directDomManager.insert(dsKokyakuKanri12);

        MT_DsKokyakuKanri dsKokyakuKanri13 = new MT_DsKokyakuKanri("0010020054");
        dsKokyakuKanri13.setDskokno("0010020054");
        dsKokyakuKanri13.setVersion(1);
        MT_DsLoginKanri dsLoginKanri13 = dsKokyakuKanri13.createDsLoginKanri();
        dsLoginKanri13.setDskokno("0010020054");
        dsLoginKanri13.setDskokyakunmerrorkaisuu(1);
        dsLoginKanri13.setDskokyakuseiymderrorkaisuu(2);
        dsLoginKanri13.setDskokyakutelnoerrorkaisuu(3);
        dsLoginKanri13.setVersion(1);
        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku13 =dsKokyakuKanri13.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku13.setDskokno("0010020054");
        dsKokyakuKeiyaku13.setSyono("11807111266");
        dsKokyakuKeiyaku13.setVersion(1);
        MT_DsHonninKakuninCd dsHonninKakuninCd13 =dsKokyakuKanri13.createDsHonninKakuninCd();
        dsHonninKakuninCd13.setDskokno("0010020054");
        dsHonninKakuninCd13.setVersion(1);
        directDomManager.insert(dsKokyakuKanri13);

        MT_DsKokyakuKanri dsKokyakuKanri14 = new MT_DsKokyakuKanri("0010020055");
        dsKokyakuKanri14.setDskokno("0010020055");
        dsKokyakuKanri14.setVersion(1);
        MT_DsLoginKanri dsLoginKanri14 = dsKokyakuKanri14.createDsLoginKanri();
        dsLoginKanri14.setDskokno("0010020055");
        dsLoginKanri14.setDskokyakunmerrorkaisuu(3);
        dsLoginKanri14.setDskokyakuseiymderrorkaisuu(2);
        dsLoginKanri14.setDskokyakutelnoerrorkaisuu(1);
        dsLoginKanri14.setVersion(1);
        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku14 =dsKokyakuKanri14.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku14.setDskokno("0010020055");
        dsKokyakuKeiyaku14.setSyono("11807111277");
        dsKokyakuKeiyaku14.setVersion(1);
        MT_DsHonninKakuninCd dsHonninKakuninCd14 =dsKokyakuKanri14.createDsHonninKakuninCd();
        dsHonninKakuninCd14.setDskokno("0010020055");
        dsHonninKakuninCd14.setVersion(1);
        directDomManager.insert(dsKokyakuKanri14);

        MT_DsKokyakuKanri dsKokyakuKanri15 = new MT_DsKokyakuKanri("1000000016");
        dsKokyakuKanri15.setDskokno("1000000016");
        dsKokyakuKanri15.setVersion(1);
        MT_DsLoginKanri dsLoginKanri15 = dsKokyakuKanri15.createDsLoginKanri();
        dsLoginKanri15.setDskokno("1000000016");
        dsLoginKanri15.setDskokyakunmerrorkaisuu(3);
        dsLoginKanri15.setDskokyakuseiymderrorkaisuu(2);
        dsLoginKanri15.setDskokyakutelnoerrorkaisuu(1);
        dsLoginKanri15.setVersion(1);
        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku15 =dsKokyakuKanri15.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku15.setDskokno("1000000016");
        dsKokyakuKeiyaku15.setSyono("17806000013");
        dsKokyakuKeiyaku15.setVersion(1);
        MT_DsHonninKakuninCd dsHonninKakuninCd15 =dsKokyakuKanri15.createDsHonninKakuninCd();
        dsHonninKakuninCd15.setDskokno("1000000016");
        dsHonninKakuninCd15.setVersion(1);
        directDomManager.insert(dsKokyakuKanri15);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        HozenDomManager hozonDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());
        directDomManager.delete(directDomManager.getAllBAKDsKokyakuKanri());
        hozonDomManager.delete(hozonDomManager.getAllKykKihon());
        baseDomManager.getSequence("17").getSequenceValues().clear();
        baseDomManager.update(baseDomManager.getSequence("17"));
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10000000001', 'iwsDskokno':'0010020034',"
            + " 'iwsNmkn':'アカサ', 'iwsSeiymd':'19880414', 'iwsTelnosimo4':'3383'}");

        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwhonninkakunin.DwHonninKakunin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwHonninKakuninImpl.execPostForm(pMap);

        exStringEquals(wsBzWebserviceResParamBean.getGyoumuData(),
            "{\"iwsDsmsgcd\":\"002100\",\"iwsSaisinlogintime\":null,\"iwsSaisinloginymd\":null}", "業務データ");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'11807111129', 'iwsDskokno':'0010020034',"
            + " 'iwsNmkn':'アカサ', 'iwsSeiymd':'19880413', 'iwsTelnosimo4':'3382'}");

        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwhonninkakunin.DwHonninKakunin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwHonninKakuninImpl.execPostForm(pMap);

        exStringEquals(wsBzWebserviceResParamBean.getGyoumuData(),
            "{\"iwsDsmsgcd\":\"002001\",\"iwsSaisinlogintime\":\"\",\"iwsSaisinloginymd\":\"\"}", "業務データ");

        MT_DsKokyakuKanri dsKoKyakuKanri = directDomManager.getDsKokyakuKanri("0010020034");
        exStringEquals(dsKoKyakuKanri.getDskokno(), "0010020034", "ＤＳ顧客番号");
        exClassificationEquals(dsKoKyakuKanri.getDskokyakujtkbn(), C_DsKokyakuJtKbn.ITIJI_TEISI, "ＤＳ顧客状態区分");
        exClassificationEquals(dsKoKyakuKanri.getDsteisiriyuukbn(), C_DsTeisiRiyuuKbn.LOCK_OUT, "ＤＳ停止理由区分");
        exDateEquals(dsKoKyakuKanri.getDskokyakumukouymd(), BizDate.getSysDate(), "ＤＳ顧客無効年月日");
        exStringEquals(dsKoKyakuKanri.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");
        exStringEquals(dsKoKyakuKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsLoginKanri dsLoginKanri = dsKoKyakuKanri.getDsLoginKanri();

        exStringEquals(dsLoginKanri.getDskokno(), "0010020034", "ＤＳ顧客番号");
        assertNull("初回ログイン年月日", dsLoginKanri.getSyokailoginymd());
        assertNull("初回ログイン時刻", dsLoginKanri.getSyokailogintime());
        assertNull("初回ログイン媒体区分", dsLoginKanri.getSyokailoginbaitaikbn());
        assertNull("最新ログイン年月日", dsLoginKanri.getSaisinloginymd());
        assertNull("最新ログイン時刻", dsLoginKanri.getSaisinlogintime());
        assertNull("最新ログイン媒体区分", dsLoginKanri.getSaisinloginbaitaikbn());
        assertNull("ＤＳ本人確認コードエラー回数", dsLoginKanri.getDshnnkakcderrorkaisuu());
        exNumericEquals(dsLoginKanri.getDskokyakunmerrorkaisuu(), 4, "ＤＳ顧客名エラー回数");
        exNumericEquals(dsLoginKanri.getDskokyakuseiymderrorkaisuu(), 3, "ＤＳ顧客生年月日エラー回数");
        exNumericEquals(dsLoginKanri.getDskokyakutelnoerrorkaisuu(), 3, "ＤＳ顧客電話番号エラー回数");
        exStringEquals(dsLoginKanri.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");
        exStringEquals(dsLoginKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'11807111130', 'iwsDskokno':'0010020035',"
            + " 'iwsNmkn':'ハナタ', 'iwsSeiymd':'19880414', 'iwsTelnosimo4':'3381'}");

        sysDate     = BizDate.getSysDate();

        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwhonninkakunin.DwHonninKakunin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwHonninKakuninImpl.execPostForm(pMap);

        exStringEquals(wsBzWebserviceResParamBean.getGyoumuData(),
            "{\"iwsDsmsgcd\":\"002001\",\"iwsSaisinlogintime\":\"\",\"iwsSaisinloginymd\":\"\"}", "業務データ");

        MT_DsKokyakuKanri dsKoKyakuKanri = directDomManager.getDsKokyakuKanri("0010020035");
        exStringEquals(dsKoKyakuKanri.getDskokno(), "0010020035", "ＤＳ顧客番号");
        exClassificationEquals(dsKoKyakuKanri.getDskokyakujtkbn(), C_DsKokyakuJtKbn.ITIJI_TEISI, "ＤＳ顧客状態区分");
        exClassificationEquals(dsKoKyakuKanri.getDsteisiriyuukbn(), C_DsTeisiRiyuuKbn.LOCK_OUT, "ＤＳ停止理由区分");
        exDateEquals(dsKoKyakuKanri.getDskokyakumukouymd(), BizDate.getSysDate(), "ＤＳ顧客無効年月日");
        exStringEquals(dsKoKyakuKanri.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");
        exStringEquals(dsKoKyakuKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsLoginKanri dsLoginKanri = dsKoKyakuKanri.getDsLoginKanri();

        exStringEquals(dsLoginKanri.getDskokno(), "0010020035", "ＤＳ顧客番号");
        assertNull("初回ログイン年月日", dsLoginKanri.getSyokailoginymd());
        assertNull("初回ログイン時刻", dsLoginKanri.getSyokailogintime());
        assertNull("初回ログイン媒体区分", dsLoginKanri.getSyokailoginbaitaikbn());
        assertNull("最新ログイン年月日", dsLoginKanri.getSaisinloginymd());
        assertNull("最新ログイン時刻", dsLoginKanri.getSaisinlogintime());
        assertNull("最新ログイン媒体区分", dsLoginKanri.getSaisinloginbaitaikbn());
        assertNull("ＤＳ本人確認コードエラー回数", dsLoginKanri.getDshnnkakcderrorkaisuu());
        exNumericEquals(dsLoginKanri.getDskokyakunmerrorkaisuu(), 5, "ＤＳ顧客名エラー回数");
        exNumericEquals(dsLoginKanri.getDskokyakuseiymderrorkaisuu(), 3, "ＤＳ顧客生年月日エラー回数");
        exNumericEquals(dsLoginKanri.getDskokyakutelnoerrorkaisuu(), 3, "ＤＳ顧客電話番号エラー回数");
        exStringEquals(dsLoginKanri.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");
        exStringEquals(dsLoginKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");


        List<MT_DsTtdkRireki> dsTtdkRirekiLst = dsKoKyakuKanri.getDsTtdkRirekis();

        MT_DsTtdkRireki dsTtdkRireki1 = dsTtdkRirekiLst.get(0);

        exStringEquals(dsTtdkRireki1.getDskokno(), "0010020035", "ＤＳ顧客番号");

        exStringEquals(dsTtdkRireki1.getHenkousikibetukey(), "000000000000000002", "変更識別キー");

        exDateEquals(dsTtdkRireki1.getSyoriYmd(), sysDate, "処理年月日");

        exClassificationEquals(dsTtdkRireki1.getDssyorikbn(), C_DsSyoriKbn.HONNIN_KAKUNIN_SIPPAI, "ＤＳ処理区分");

        exClassificationEquals(dsTtdkRireki1.getHenkourrkumu(), C_UmuKbn.ARI, "変更履歴有無");

        exStringEquals(dsTtdkRireki1.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");

        exStringEquals(dsTtdkRireki1.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        List<MT_DsHenkouRireki> dsHenkouRirekiLst = dsTtdkRirekiLst.get(0).getDsHenkouRirekis();

        MT_DsHenkouRireki dsHenkouRireki0 = dsHenkouRirekiLst.get(0);

        exStringEquals(dsHenkouRireki0.getDskokno(), "0010020035", "ＤＳ顧客番号");

        exStringEquals(dsHenkouRireki0.getHenkousikibetukey(), "000000000000000002", "変更識別キー");

        exNumericEquals(dsHenkouRireki0.getRenno(), 1, "連番");

        exStringEquals(dsHenkouRireki0.getTablenm(), "ＤＳ顧客管理テーブル", "テーブル名称");

        exStringEquals(dsHenkouRireki0.getTableid(), "MT_DsKokyakuKanri", "テーブルＩＤ");

        exClassificationEquals(dsHenkouRireki0.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU , "変更種類区分");

        exStringEquals(dsHenkouRireki0.getHanbetukoumokunm(), "ＤＳ顧客管理情報", "判別項目名");

        exStringEquals(dsHenkouRireki0.getHenkoukoumokuid(), "dskokyakujtkbn", "変更項目ID");

        exStringEquals(dsHenkouRireki0.getHenkoukoumokunm(), "ＤＳ顧客状態区分", "変更項目名");

        exStringEquals(dsHenkouRireki0.getBfrnaiyouoriginal(),"", "変更前内容原本");

        exStringEquals(dsHenkouRireki0.getBfrnaiyou(), "", "変更前内容");

        exStringEquals(dsHenkouRireki0.getNewnaiyouoriginal(), "2", "変更後内容原本");

        exStringEquals(dsHenkouRireki0.getNewnaiyou(), "一時停止", "変更後内容");

        exStringEquals(dsHenkouRireki0.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");

        exStringEquals(dsHenkouRireki0.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki1 = dsHenkouRirekiLst.get(1);

        exStringEquals(dsHenkouRireki1.getDskokno(), "0010020035", "ＤＳ顧客番号");

        exStringEquals(dsHenkouRireki1.getHenkousikibetukey(), "000000000000000002", "変更識別キー");

        exNumericEquals(dsHenkouRireki1.getRenno(), 2, "連番");

        exStringEquals(dsHenkouRireki1.getTablenm(), "ＤＳ顧客管理テーブル", "テーブル名称");

        exStringEquals(dsHenkouRireki1.getTableid(), "MT_DsKokyakuKanri", "テーブルＩＤ");

        exClassificationEquals(dsHenkouRireki1.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU , "変更種類区分");

        exStringEquals(dsHenkouRireki1.getHanbetukoumokunm(), "ＤＳ顧客管理情報", "判別項目名");

        exStringEquals(dsHenkouRireki1.getHenkoukoumokuid(), "dsteisiriyuukbn", "変更項目ID");

        exStringEquals(dsHenkouRireki1.getHenkoukoumokunm(), "ＤＳ停止理由区分", "変更項目名");

        exStringEquals(dsHenkouRireki1.getBfrnaiyouoriginal(),"", "変更前内容原本");

        exStringEquals(dsHenkouRireki1.getBfrnaiyou(), "", "変更前内容");

        exStringEquals(dsHenkouRireki1.getNewnaiyouoriginal(), "1", "変更後内容原本");

        exStringEquals(dsHenkouRireki1.getNewnaiyou(), "ロックアウト", "変更後内容");

        exStringEquals(dsHenkouRireki1.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");

        exStringEquals(dsHenkouRireki1.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki2 = dsHenkouRirekiLst.get(2);

        exStringEquals(dsHenkouRireki2.getDskokno(), "0010020035", "ＤＳ顧客番号");

        exStringEquals(dsHenkouRireki2.getHenkousikibetukey(), "000000000000000002", "変更識別キー");

        exNumericEquals(dsHenkouRireki2.getRenno(), 3, "連番");

        exStringEquals(dsHenkouRireki2.getTablenm(), "ＤＳ顧客管理テーブル", "テーブル名称");

        exStringEquals(dsHenkouRireki2.getTableid(), "MT_DsKokyakuKanri", "テーブルＩＤ");

        exClassificationEquals(dsHenkouRireki2.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU , "変更種類区分");

        exStringEquals(dsHenkouRireki2.getHanbetukoumokunm(), "ＤＳ顧客管理情報", "判別項目名");

        exStringEquals(dsHenkouRireki2.getHenkoukoumokuid(), "dskokyakumukouymd", "変更項目ID");

        exStringEquals(dsHenkouRireki2.getHenkoukoumokunm(), "ＤＳ顧客無効年月日", "変更項目名");

        exStringEquals(dsHenkouRireki2.getBfrnaiyouoriginal(),"", "変更前内容原本");

        exStringEquals(dsHenkouRireki2.getBfrnaiyou(), "", "変更前内容");

        exStringEquals(dsHenkouRireki2.getNewnaiyouoriginal(), "20160510", "変更後内容原本");

        exStringEquals(dsHenkouRireki2.getNewnaiyou(), "20160510", "変更後内容");

        exStringEquals(dsHenkouRireki2.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");

        exStringEquals(dsHenkouRireki2.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki3 = dsHenkouRirekiLst.get(3);

        exStringEquals(dsHenkouRireki3.getDskokno(), "0010020035", "ＤＳ顧客番号");

        exStringEquals(dsHenkouRireki3.getHenkousikibetukey(), "000000000000000002", "変更識別キー");

        exNumericEquals(dsHenkouRireki3.getRenno(), 4, "連番");

        exStringEquals(dsHenkouRireki3.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");

        exStringEquals(dsHenkouRireki3.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");

        exClassificationEquals(dsHenkouRireki3.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU , "変更種類区分");

        exStringEquals(dsHenkouRireki3.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");

        exStringEquals(dsHenkouRireki3.getHenkoukoumokuid(), "dskokyakunmerrorkaisuu", "変更項目ID");

        exStringEquals(dsHenkouRireki3.getHenkoukoumokunm(), "ＤＳ顧客名エラー回数", "変更項目名");

        exStringEquals(dsHenkouRireki3.getBfrnaiyouoriginal(),"4", "変更前内容原本");

        exStringEquals(dsHenkouRireki3.getBfrnaiyou(), "4", "変更前内容");

        exStringEquals(dsHenkouRireki3.getNewnaiyouoriginal(), "5", "変更後内容原本");

        exStringEquals(dsHenkouRireki3.getNewnaiyou(), "5", "変更後内容");

        exStringEquals(dsHenkouRireki3.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");

        exStringEquals(dsHenkouRireki3.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki4 = dsHenkouRirekiLst.get(4);

        exStringEquals(dsHenkouRireki4.getDskokno(), "0010020035", "ＤＳ顧客番号");

        exStringEquals(dsHenkouRireki4.getHenkousikibetukey(), "000000000000000002", "変更識別キー");

        exNumericEquals(dsHenkouRireki4.getRenno(), 5, "連番");

        exStringEquals(dsHenkouRireki4.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");

        exStringEquals(dsHenkouRireki4.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");

        exClassificationEquals(dsHenkouRireki4.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU , "変更種類区分");

        exStringEquals(dsHenkouRireki4.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");

        exStringEquals(dsHenkouRireki4.getHenkoukoumokuid(), "dskokyakuseiymderrorkaisuu", "変更項目ID");

        exStringEquals(dsHenkouRireki4.getHenkoukoumokunm(), "ＤＳ顧客生年月日エラー回数", "変更項目名");

        exStringEquals(dsHenkouRireki4.getBfrnaiyouoriginal(),"2", "変更前内容原本");

        exStringEquals(dsHenkouRireki4.getBfrnaiyou(), "2", "変更前内容");

        exStringEquals(dsHenkouRireki4.getNewnaiyouoriginal(), "3", "変更後内容原本");

        exStringEquals(dsHenkouRireki4.getNewnaiyou(), "3", "変更後内容");

        exStringEquals(dsHenkouRireki4.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");

        exStringEquals(dsHenkouRireki4.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki5 = dsHenkouRirekiLst.get(5);

        exStringEquals(dsHenkouRireki5.getDskokno(), "0010020035", "ＤＳ顧客番号");

        exStringEquals(dsHenkouRireki5.getHenkousikibetukey(), "000000000000000002", "変更識別キー");

        exNumericEquals(dsHenkouRireki5.getRenno(), 6, "連番");

        exStringEquals(dsHenkouRireki5.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");

        exStringEquals(dsHenkouRireki5.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");

        exClassificationEquals(dsHenkouRireki5.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU , "変更種類区分");

        exStringEquals(dsHenkouRireki5.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");

        exStringEquals(dsHenkouRireki5.getHenkoukoumokuid(), "dskokyakutelnoerrorkaisuu", "変更項目ID");

        exStringEquals(dsHenkouRireki5.getHenkoukoumokunm(), "ＤＳ顧客電話番号エラー回数", "変更項目名");

        exStringEquals(dsHenkouRireki5.getBfrnaiyouoriginal(),"2", "変更前内容原本");

        exStringEquals(dsHenkouRireki5.getBfrnaiyou(), "2", "変更前内容");

        exStringEquals(dsHenkouRireki5.getNewnaiyouoriginal(), "3", "変更後内容原本");

        exStringEquals(dsHenkouRireki5.getNewnaiyou(), "3", "変更後内容");

        exStringEquals(dsHenkouRireki5.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");

        exStringEquals(dsHenkouRireki5.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_BAK_DsKokyakuKanri dsKokyakuKanriBak = directDomManager.getBAKDsKokyakuKanri("0010020035","000000000000000002");

        boolean dsKokyakuKanriBakHikaku = dsKokyakuKanriBak == null;
        exBooleanEquals(dsKokyakuKanriBakHikaku,false, "ＤＳ顧客管理バックアップテーブル比較結果");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'11807111141', 'iwsDskokno':'0010020036',"
            + " 'iwsNmkn':'ハナタ', 'iwsSeiymd':'19880406', 'iwsTelnosimo4':'3383'}");

        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwhonninkakunin.DwHonninKakunin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwHonninKakuninImpl.execPostForm(pMap);

        exStringEquals(wsBzWebserviceResParamBean.getGyoumuData(),
            "{\"iwsDsmsgcd\":\"002001\",\"iwsSaisinlogintime\":\"\",\"iwsSaisinloginymd\":\"\"}", "業務データ");

        MT_DsKokyakuKanri dsKoKyakuKanri = directDomManager.getDsKokyakuKanri("0010020036");
        exStringEquals(dsKoKyakuKanri.getDskokno(), "0010020036", "ＤＳ顧客番号");
        exClassificationEquals(dsKoKyakuKanri.getDskokyakujtkbn(), C_DsKokyakuJtKbn.ITIJI_TEISI, "ＤＳ顧客状態区分");
        exClassificationEquals(dsKoKyakuKanri.getDsteisiriyuukbn(), C_DsTeisiRiyuuKbn.LOCK_OUT, "ＤＳ停止理由区分");
        exDateEquals(dsKoKyakuKanri.getDskokyakumukouymd(), BizDate.getSysDate(), "ＤＳ顧客無効年月日");
        exStringEquals(dsKoKyakuKanri.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");
        exStringEquals(dsKoKyakuKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsLoginKanri dsLoginKanri = dsKoKyakuKanri.getDsLoginKanri();

        exStringEquals(dsLoginKanri.getDskokno(), "0010020036", "ＤＳ顧客番号");
        assertNull("初回ログイン年月日", dsLoginKanri.getSyokailoginymd());
        assertNull("初回ログイン時刻", dsLoginKanri.getSyokailogintime());
        assertNull("初回ログイン媒体区分", dsLoginKanri.getSyokailoginbaitaikbn());
        assertNull("最新ログイン年月日", dsLoginKanri.getSaisinloginymd());
        assertNull("最新ログイン時刻", dsLoginKanri.getSaisinlogintime());
        assertNull("最新ログイン媒体区分", dsLoginKanri.getSaisinloginbaitaikbn());
        assertNull("ＤＳ本人確認コードエラー回数", dsLoginKanri.getDshnnkakcderrorkaisuu());
        exNumericEquals(dsLoginKanri.getDskokyakunmerrorkaisuu(), 3, "ＤＳ顧客名エラー回数");
        exNumericEquals(dsLoginKanri.getDskokyakuseiymderrorkaisuu(), 4, "ＤＳ顧客生年月日エラー回数");
        exNumericEquals(dsLoginKanri.getDskokyakutelnoerrorkaisuu(), 3, "ＤＳ顧客電話番号エラー回数");
        exStringEquals(dsLoginKanri.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");
        exStringEquals(dsLoginKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'11807111152', 'iwsDskokno':'0010020037',"
            + " 'iwsNmkn':'ハナタ', 'iwsSeiymd':'19880414', 'iwsTelnosimo4':'3382'}");

        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwhonninkakunin.DwHonninKakunin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwHonninKakuninImpl.execPostForm(pMap);

        exStringEquals(wsBzWebserviceResParamBean.getGyoumuData(),
            "{\"iwsDsmsgcd\":\"002001\",\"iwsSaisinlogintime\":\"\",\"iwsSaisinloginymd\":\"\"}", "業務データ");

        MT_DsKokyakuKanri dsKoKyakuKanri = directDomManager.getDsKokyakuKanri("0010020037");
        exStringEquals(dsKoKyakuKanri.getDskokno(), "0010020037", "ＤＳ顧客番号");
        exClassificationEquals(dsKoKyakuKanri.getDskokyakujtkbn(), C_DsKokyakuJtKbn.ITIJI_TEISI, "ＤＳ顧客状態区分");
        exClassificationEquals(dsKoKyakuKanri.getDsteisiriyuukbn(), C_DsTeisiRiyuuKbn.LOCK_OUT, "ＤＳ停止理由区分");
        exDateEquals(dsKoKyakuKanri.getDskokyakumukouymd(), BizDate.getSysDate(), "ＤＳ顧客無効年月日");
        exStringEquals(dsKoKyakuKanri.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");
        exStringEquals(dsKoKyakuKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsLoginKanri dsLoginKanri = dsKoKyakuKanri.getDsLoginKanri();

        exStringEquals(dsLoginKanri.getDskokno(), "0010020037", "ＤＳ顧客番号");
        assertNull("初回ログイン年月日", dsLoginKanri.getSyokailoginymd());
        assertNull("初回ログイン時刻", dsLoginKanri.getSyokailogintime());
        assertNull("初回ログイン媒体区分", dsLoginKanri.getSyokailoginbaitaikbn());
        assertNull("最新ログイン年月日", dsLoginKanri.getSaisinloginymd());
        assertNull("最新ログイン時刻", dsLoginKanri.getSaisinlogintime());
        assertNull("最新ログイン媒体区分", dsLoginKanri.getSaisinloginbaitaikbn());
        assertNull("ＤＳ本人確認コードエラー回数", dsLoginKanri.getDshnnkakcderrorkaisuu());
        exNumericEquals(dsLoginKanri.getDskokyakunmerrorkaisuu(), 3, "ＤＳ顧客名エラー回数");
        exNumericEquals(dsLoginKanri.getDskokyakuseiymderrorkaisuu(), 5, "ＤＳ顧客生年月日エラー回数");
        exNumericEquals(dsLoginKanri.getDskokyakutelnoerrorkaisuu(), 3, "ＤＳ顧客電話番号エラー回数");
        exStringEquals(dsLoginKanri.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");
        exStringEquals(dsLoginKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");


    }

    @Test
    @TestOrder(60)
    public void testExec_A6() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'11807111163', 'iwsDskokno':'0010020038',"
            + " 'iwsNmkn':'ハナタ', 'iwsSeiymd':'19900416', 'iwsTelnosimo4':'3383'}");

        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwhonninkakunin.DwHonninKakunin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwHonninKakuninImpl.execPostForm(pMap);

        exStringEquals(wsBzWebserviceResParamBean.getGyoumuData(),
            "{\"iwsDsmsgcd\":\"002001\",\"iwsSaisinlogintime\":\"\",\"iwsSaisinloginymd\":\"\"}", "業務データ");

        MT_DsKokyakuKanri dsKoKyakuKanri = directDomManager.getDsKokyakuKanri("0010020038");
        exStringEquals(dsKoKyakuKanri.getDskokno(), "0010020038", "ＤＳ顧客番号");
        exClassificationEquals(dsKoKyakuKanri.getDskokyakujtkbn(), C_DsKokyakuJtKbn.ITIJI_TEISI, "ＤＳ顧客状態区分");
        exClassificationEquals(dsKoKyakuKanri.getDsteisiriyuukbn(), C_DsTeisiRiyuuKbn.LOCK_OUT, "ＤＳ停止理由区分");
        exDateEquals(dsKoKyakuKanri.getDskokyakumukouymd(), BizDate.getSysDate(), "ＤＳ顧客無効年月日");
        exStringEquals(dsKoKyakuKanri.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");
        exStringEquals(dsKoKyakuKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsLoginKanri dsLoginKanri = dsKoKyakuKanri.getDsLoginKanri();

        exStringEquals(dsLoginKanri.getDskokno(), "0010020038", "ＤＳ顧客番号");
        assertNull("初回ログイン年月日", dsLoginKanri.getSyokailoginymd());
        assertNull("初回ログイン時刻", dsLoginKanri.getSyokailogintime());
        assertNull("初回ログイン媒体区分", dsLoginKanri.getSyokailoginbaitaikbn());
        assertNull("最新ログイン年月日", dsLoginKanri.getSaisinloginymd());
        assertNull("最新ログイン時刻", dsLoginKanri.getSaisinlogintime());
        assertNull("最新ログイン媒体区分", dsLoginKanri.getSaisinloginbaitaikbn());
        assertNull("ＤＳ本人確認コードエラー回数", dsLoginKanri.getDshnnkakcderrorkaisuu());
        exNumericEquals(dsLoginKanri.getDskokyakunmerrorkaisuu(), 3, "ＤＳ顧客名エラー回数");
        exNumericEquals(dsLoginKanri.getDskokyakuseiymderrorkaisuu(), 3, "ＤＳ顧客生年月日エラー回数");
        exNumericEquals(dsLoginKanri.getDskokyakutelnoerrorkaisuu(), 5, "ＤＳ顧客電話番号エラー回数");
        exStringEquals(dsLoginKanri.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");
        exStringEquals(dsLoginKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'11807111174', 'iwsDskokno':'0010020039',"
            + " 'iwsNmkn':'サクラ', 'iwsSeiymd':'19900416', 'iwsTelnosimo4':'3383'}");

        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwhonninkakunin.DwHonninKakunin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwHonninKakuninImpl.execPostForm(pMap);

        exStringEquals(wsBzWebserviceResParamBean.getGyoumuData(),
            "{\"iwsDsmsgcd\":\"002001\",\"iwsSaisinlogintime\":\"\",\"iwsSaisinloginymd\":\"\"}", "業務データ");

        MT_DsKokyakuKanri dsKoKyakuKanri = directDomManager.getDsKokyakuKanri("0010020039");
        exStringEquals(dsKoKyakuKanri.getDskokno(), "0010020039", "ＤＳ顧客番号");
        exClassificationEquals(dsKoKyakuKanri.getDskokyakujtkbn(), C_DsKokyakuJtKbn.ITIJI_TEISI, "ＤＳ顧客状態区分");
        exClassificationEquals(dsKoKyakuKanri.getDsteisiriyuukbn(), C_DsTeisiRiyuuKbn.LOCK_OUT, "ＤＳ停止理由区分");
        exDateEquals(dsKoKyakuKanri.getDskokyakumukouymd(), BizDate.getSysDate(), "ＤＳ顧客無効年月日");
        exStringEquals(dsKoKyakuKanri.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");
        exStringEquals(dsKoKyakuKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsLoginKanri dsLoginKanri = dsKoKyakuKanri.getDsLoginKanri();

        exStringEquals(dsLoginKanri.getDskokno(), "0010020039", "ＤＳ顧客番号");
        assertNull("初回ログイン年月日", dsLoginKanri.getSyokailoginymd());
        assertNull("初回ログイン時刻", dsLoginKanri.getSyokailogintime());
        assertNull("初回ログイン媒体区分", dsLoginKanri.getSyokailoginbaitaikbn());
        assertNull("最新ログイン年月日", dsLoginKanri.getSaisinloginymd());
        assertNull("最新ログイン時刻", dsLoginKanri.getSaisinlogintime());
        assertNull("最新ログイン媒体区分", dsLoginKanri.getSaisinloginbaitaikbn());
        assertNull("ＤＳ本人確認コードエラー回数", dsLoginKanri.getDshnnkakcderrorkaisuu());
        exNumericEquals(dsLoginKanri.getDskokyakunmerrorkaisuu(), 3, "ＤＳ顧客名エラー回数");
        exNumericEquals(dsLoginKanri.getDskokyakuseiymderrorkaisuu(), 3, "ＤＳ顧客生年月日エラー回数");
        exNumericEquals(dsLoginKanri.getDskokyakutelnoerrorkaisuu(), 4, "ＤＳ顧客電話番号エラー回数");
        exStringEquals(dsLoginKanri.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");
        exStringEquals(dsLoginKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'11807111185', 'iwsDskokno':'0010020040',"
            + " 'iwsNmkn':'カナタ', 'iwsSeiymd':'19900506', 'iwsTelnosimo4':'3383'}");

        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwhonninkakunin.DwHonninKakunin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwHonninKakuninImpl.execPostForm(pMap);

        exStringEquals(wsBzWebserviceResParamBean.getGyoumuData(),
            "{\"iwsDsmsgcd\":\"002002\",\"iwsSaisinlogintime\":\"\",\"iwsSaisinloginymd\":\"\"}", "業務データ");

        MT_DsKokyakuKanri dsKoKyakuKanri = directDomManager.getDsKokyakuKanri("0010020040");
        exStringEquals(dsKoKyakuKanri.getDskokno(), "0010020040", "ＤＳ顧客番号");
        assertNull("ＤＳ顧客状態区分", dsKoKyakuKanri.getDskokyakujtkbn());
        assertNull("ＤＳ停止理由区分", dsKoKyakuKanri.getDsteisiriyuukbn());
        assertNull("ＤＳ顧客無効年月日", dsKoKyakuKanri.getDskokyakumukouymd());
        assertNull("業務用更新機能ＩＤ", dsKoKyakuKanri.getGyoumuKousinKinou());
        assertNull("業務用更新者ＩＤ", dsKoKyakuKanri.getGyoumuKousinsyaId());

        MT_DsLoginKanri dsLoginKanri = dsKoKyakuKanri.getDsLoginKanri();

        exStringEquals(dsLoginKanri.getDskokno(), "0010020040", "ＤＳ顧客番号");
        assertNull("初回ログイン年月日", dsLoginKanri.getSyokailoginymd());
        assertNull("初回ログイン時刻", dsLoginKanri.getSyokailogintime());
        assertNull("初回ログイン媒体区分", dsLoginKanri.getSyokailoginbaitaikbn());
        assertNull("最新ログイン年月日", dsLoginKanri.getSaisinloginymd());
        assertNull("最新ログイン時刻", dsLoginKanri.getSaisinlogintime());
        assertNull("最新ログイン媒体区分", dsLoginKanri.getSaisinloginbaitaikbn());
        assertNull("ＤＳ本人確認コードエラー回数", dsLoginKanri.getDshnnkakcderrorkaisuu());
        exNumericEquals(dsLoginKanri.getDskokyakunmerrorkaisuu(), 3, "ＤＳ顧客名エラー回数");
        exNumericEquals(dsLoginKanri.getDskokyakuseiymderrorkaisuu(), 3, "ＤＳ顧客生年月日エラー回数");
        exNumericEquals(dsLoginKanri.getDskokyakutelnoerrorkaisuu(), 3, "ＤＳ顧客電話番号エラー回数");
        exStringEquals(dsLoginKanri.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");
        exStringEquals(dsLoginKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'11807111196', 'iwsDskokno':'0010020041',"
            + " 'iwsNmkn':'カナタ', 'iwsSeiymd':'19900406', 'iwsTelnosimo4':'3382'}");

        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwhonninkakunin.DwHonninKakunin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwHonninKakuninImpl.execPostForm(pMap);

        exStringEquals(wsBzWebserviceResParamBean.getGyoumuData(),
            "{\"iwsDsmsgcd\":\"002003\",\"iwsSaisinlogintime\":\"103034\",\"iwsSaisinloginymd\":\"20160620\"}", "業務データ");

        MT_DsKokyakuKanri dsKoKyakuKanri = directDomManager.getDsKokyakuKanri("0010020041");
        exStringEquals(dsKoKyakuKanri.getDskokno(), "0010020041", "ＤＳ顧客番号");
        assertNull("ＤＳ顧客状態区分", dsKoKyakuKanri.getDskokyakujtkbn());
        assertNull("ＤＳ停止理由区分", dsKoKyakuKanri.getDsteisiriyuukbn());
        assertNull("ＤＳ顧客無効年月日", dsKoKyakuKanri.getDskokyakumukouymd());
        assertNull("業務用更新機能ＩＤ", dsKoKyakuKanri.getGyoumuKousinKinou());
        assertNull("業務用更新者ＩＤ", dsKoKyakuKanri.getGyoumuKousinsyaId());

        MT_DsLoginKanri dsLoginKanri = dsKoKyakuKanri.getDsLoginKanri();

        exStringEquals(dsLoginKanri.getDskokno(), "0010020041", "ＤＳ顧客番号");
        exDateEquals(dsLoginKanri.getSyokailoginymd(), BizDate.valueOf("20160102"), "初回ログイン年月日");
        assertNull("初回ログイン時刻", dsLoginKanri.getSyokailogintime());
        assertNull("初回ログイン媒体区分", dsLoginKanri.getSyokailoginbaitaikbn());
        exDateEquals(dsLoginKanri.getSaisinloginymd(), BizDate.getSysDate(), "最新ログイン年月日");
        exClassificationEquals(dsLoginKanri.getSaisinloginbaitaikbn(), C_BaitaiKbn.PC, "最新ログイン媒体区分");
        exNumericEquals(dsLoginKanri.getDshnnkakcderrorkaisuu(), 0, "ＤＳ本人確認コードエラー回数");
        exNumericEquals(dsLoginKanri.getDskokyakunmerrorkaisuu(), 0, "ＤＳ顧客名エラー回数");
        exNumericEquals(dsLoginKanri.getDskokyakuseiymderrorkaisuu(), 0, "ＤＳ顧客生年月日エラー回数");
        exNumericEquals(dsLoginKanri.getDskokyakutelnoerrorkaisuu(), 0, "ＤＳ顧客電話番号エラー回数");
        exStringEquals(dsLoginKanri.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");
        exStringEquals(dsLoginKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'11807111200', 'iwsDskokno':'0010020042',"
            + " 'iwsNmkn':'カナタ', 'iwsSeiymd':'19900406', 'iwsTelnosimo4':'3382'}");

        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwhonninkakunin.DwHonninKakunin/execPostForm");

        sysDate     = BizDate.getSysDate();

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwHonninKakuninImpl.execPostForm(pMap);

        exStringEquals(wsBzWebserviceResParamBean.getGyoumuData(),
            "{\"iwsDsmsgcd\":\"002003\",\"iwsSaisinlogintime\":\"\",\"iwsSaisinloginymd\":\"\"}", "業務データ");

        MT_DsKokyakuKanri dsKoKyakuKanri = directDomManager.getDsKokyakuKanri("0010020042");
        exStringEquals(dsKoKyakuKanri.getDskokno(), "0010020042", "ＤＳ顧客番号");
        assertNull("ＤＳ顧客状態区分", dsKoKyakuKanri.getDskokyakujtkbn());
        assertNull("ＤＳ停止理由区分", dsKoKyakuKanri.getDsteisiriyuukbn());
        assertNull("ＤＳ顧客無効年月日", dsKoKyakuKanri.getDskokyakumukouymd());
        assertNull("業務用更新機能ＩＤ", dsKoKyakuKanri.getGyoumuKousinKinou());
        assertNull("業務用更新者ＩＤ", dsKoKyakuKanri.getGyoumuKousinsyaId());

        MT_DsLoginKanri dsLoginKanri = dsKoKyakuKanri.getDsLoginKanri();

        exStringEquals(dsLoginKanri.getDskokno(), "0010020042", "ＤＳ顧客番号");
        exDateEquals(dsLoginKanri.getSyokailoginymd(), BizDate.getSysDate(), "初回ログイン年月日");
        exClassificationEquals(dsLoginKanri.getSyokailoginbaitaikbn(), C_BaitaiKbn.PC, "初回ログイン媒体区分");
        exDateEquals(dsLoginKanri.getSaisinloginymd(), BizDate.getSysDate(), "最新ログイン年月日");
        exClassificationEquals(dsLoginKanri.getSaisinloginbaitaikbn(), C_BaitaiKbn.PC, "最新ログイン媒体区分");
        exNumericEquals(dsLoginKanri.getDshnnkakcderrorkaisuu(), 0, "ＤＳ本人確認コードエラー回数");
        exNumericEquals(dsLoginKanri.getDskokyakunmerrorkaisuu(), 0, "ＤＳ顧客名エラー回数");
        exNumericEquals(dsLoginKanri.getDskokyakuseiymderrorkaisuu(), 0, "ＤＳ顧客生年月日エラー回数");
        exNumericEquals(dsLoginKanri.getDskokyakutelnoerrorkaisuu(), 0, "ＤＳ顧客電話番号エラー回数");
        exStringEquals(dsLoginKanri.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");
        exStringEquals(dsLoginKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");


        List<MT_DsTtdkRireki> dsTtdkRirekiLst = dsKoKyakuKanri.getDsTtdkRirekis();

        MT_DsTtdkRireki dsTtdkRireki1 = dsTtdkRirekiLst.get(0);

        exStringEquals(dsTtdkRireki1.getDskokno(), "0010020042", "ＤＳ顧客番号");

        exStringEquals(dsTtdkRireki1.getHenkousikibetukey(), "000000000000000009", "変更識別キー");

        exDateEquals(dsTtdkRireki1.getSyoriYmd(), sysDate, "処理年月日");

        exClassificationEquals(dsTtdkRireki1.getDssyorikbn(), C_DsSyoriKbn.HONNIN_KAKUNIN_SEIKOU, "ＤＳ処理区分");

        exClassificationEquals(dsTtdkRireki1.getHenkourrkumu(), C_UmuKbn.ARI, "変更履歴有無");

        exStringEquals(dsTtdkRireki1.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");

        exStringEquals(dsTtdkRireki1.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        List<MT_DsHenkouRireki> dsHenkouRirekiLst = dsTtdkRirekiLst.get(0).getDsHenkouRirekis();

        MT_DsHenkouRireki dsHenkouRireki0 = dsHenkouRirekiLst.get(0);

        exStringEquals(dsHenkouRireki0.getDskokno(), "0010020042", "ＤＳ顧客番号");

        exStringEquals(dsHenkouRireki0.getHenkousikibetukey(), "000000000000000009", "変更識別キー");

        exNumericEquals(dsHenkouRireki0.getRenno(), 1, "連番");

        exStringEquals(dsHenkouRireki0.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");

        exStringEquals(dsHenkouRireki0.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");

        exClassificationEquals(dsHenkouRireki0.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU , "変更種類区分");

        exStringEquals(dsHenkouRireki0.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");

        exStringEquals(dsHenkouRireki0.getHenkoukoumokuid(), "syokailoginymd", "変更項目ID");

        exStringEquals(dsHenkouRireki0.getHenkoukoumokunm(), "初回ログイン年月日", "変更項目名");

        exStringEquals(dsHenkouRireki0.getBfrnaiyouoriginal(),"", "変更前内容原本");

        exStringEquals(dsHenkouRireki0.getBfrnaiyou(), "", "変更前内容");

        exStringEquals(dsHenkouRireki0.getNewnaiyouoriginal(), "20160510", "変更後内容原本");

        exStringEquals(dsHenkouRireki0.getNewnaiyou(), "20160510", "変更後内容");

        exStringEquals(dsHenkouRireki0.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");

        exStringEquals(dsHenkouRireki0.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki1 = dsHenkouRirekiLst.get(1);

        exStringEquals(dsHenkouRireki1.getDskokno(), "0010020042", "ＤＳ顧客番号");

        exStringEquals(dsHenkouRireki1.getHenkousikibetukey(), "000000000000000009", "変更識別キー");

        exNumericEquals(dsHenkouRireki1.getRenno(), 2, "連番");

        exStringEquals(dsHenkouRireki1.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");

        exStringEquals(dsHenkouRireki1.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");

        exClassificationEquals(dsHenkouRireki1.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU , "変更種類区分");

        exStringEquals(dsHenkouRireki1.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");

        exStringEquals(dsHenkouRireki1.getHenkoukoumokuid(), "syokailogintime", "変更項目ID");

        exStringEquals(dsHenkouRireki1.getHenkoukoumokunm(), "初回ログイン時刻", "変更項目名");

        exStringEquals(dsHenkouRireki1.getBfrnaiyouoriginal(),"", "変更前内容原本");

        exStringEquals(dsHenkouRireki1.getBfrnaiyou(), "", "変更前内容");

        exStringEquals(dsHenkouRireki1.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");

        exStringEquals(dsHenkouRireki1.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki2 = dsHenkouRirekiLst.get(2);

        exStringEquals(dsHenkouRireki2.getDskokno(), "0010020042", "ＤＳ顧客番号");

        exStringEquals(dsHenkouRireki2.getHenkousikibetukey(), "000000000000000009", "変更識別キー");

        exNumericEquals(dsHenkouRireki2.getRenno(), 3, "連番");

        exStringEquals(dsHenkouRireki2.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");

        exStringEquals(dsHenkouRireki2.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");

        exClassificationEquals(dsHenkouRireki2.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU , "変更種類区分");

        exStringEquals(dsHenkouRireki2.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");

        exStringEquals(dsHenkouRireki2.getHenkoukoumokuid(), "syokailoginbaitaikbn", "変更項目ID");

        exStringEquals(dsHenkouRireki2.getHenkoukoumokunm(), "初回ログイン媒体区分", "変更項目名");

        exStringEquals(dsHenkouRireki2.getBfrnaiyouoriginal(),"", "変更前内容原本");

        exStringEquals(dsHenkouRireki2.getBfrnaiyou(), "", "変更前内容");

        exStringEquals(dsHenkouRireki2.getNewnaiyouoriginal(), "1", "変更後内容原本");

        exStringEquals(dsHenkouRireki2.getNewnaiyou(), "ＰＣ", "変更後内容");

        exStringEquals(dsHenkouRireki2.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");

        exStringEquals(dsHenkouRireki2.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki3 = dsHenkouRirekiLst.get(3);

        exStringEquals(dsHenkouRireki3.getDskokno(), "0010020042", "ＤＳ顧客番号");

        exStringEquals(dsHenkouRireki3.getHenkousikibetukey(), "000000000000000009", "変更識別キー");

        exNumericEquals(dsHenkouRireki3.getRenno(), 4, "連番");

        exStringEquals(dsHenkouRireki3.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");

        exStringEquals(dsHenkouRireki3.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");

        exClassificationEquals(dsHenkouRireki3.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU , "変更種類区分");

        exStringEquals(dsHenkouRireki3.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");

        exStringEquals(dsHenkouRireki3.getHenkoukoumokuid(), "saisinloginymd", "変更項目ID");

        exStringEquals(dsHenkouRireki3.getHenkoukoumokunm(), "最新ログイン年月日", "変更項目名");

        exStringEquals(dsHenkouRireki3.getBfrnaiyouoriginal(),"20160620", "変更前内容原本");

        exStringEquals(dsHenkouRireki3.getBfrnaiyou(), "20160620", "変更前内容");

        exStringEquals(dsHenkouRireki3.getNewnaiyouoriginal(), "20160510", "変更後内容原本");

        exStringEquals(dsHenkouRireki3.getNewnaiyou(), "20160510", "変更後内容");

        exStringEquals(dsHenkouRireki3.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");

        exStringEquals(dsHenkouRireki3.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki4 = dsHenkouRirekiLst.get(4);

        exStringEquals(dsHenkouRireki4.getDskokno(), "0010020042", "ＤＳ顧客番号");

        exStringEquals(dsHenkouRireki4.getHenkousikibetukey(), "000000000000000009", "変更識別キー");

        exNumericEquals(dsHenkouRireki4.getRenno(), 5, "連番");

        exStringEquals(dsHenkouRireki4.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");

        exStringEquals(dsHenkouRireki4.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");

        exClassificationEquals(dsHenkouRireki4.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU , "変更種類区分");

        exStringEquals(dsHenkouRireki4.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");

        exStringEquals(dsHenkouRireki4.getHenkoukoumokuid(), "saisinlogintime", "変更項目ID");

        exStringEquals(dsHenkouRireki4.getHenkoukoumokunm(), "最新ログイン時刻", "変更項目名");

        exStringEquals(dsHenkouRireki4.getBfrnaiyouoriginal(),"103034", "変更前内容原本");

        exStringEquals(dsHenkouRireki4.getBfrnaiyou(), "103034", "変更前内容");

        exStringEquals(dsHenkouRireki4.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");

        exStringEquals(dsHenkouRireki4.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki5 = dsHenkouRirekiLst.get(5);

        exStringEquals(dsHenkouRireki5.getDskokno(), "0010020042", "ＤＳ顧客番号");

        exStringEquals(dsHenkouRireki5.getHenkousikibetukey(), "000000000000000009", "変更識別キー");

        exNumericEquals(dsHenkouRireki5.getRenno(), 6, "連番");

        exStringEquals(dsHenkouRireki5.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");

        exStringEquals(dsHenkouRireki5.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");

        exClassificationEquals(dsHenkouRireki5.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU , "変更種類区分");

        exStringEquals(dsHenkouRireki5.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");

        exStringEquals(dsHenkouRireki5.getHenkoukoumokuid(), "saisinloginbaitaikbn", "変更項目ID");

        exStringEquals(dsHenkouRireki5.getHenkoukoumokunm(), "最新ログイン媒体区分", "変更項目名");

        exStringEquals(dsHenkouRireki5.getBfrnaiyouoriginal(),"", "変更前内容原本");

        exStringEquals(dsHenkouRireki5.getBfrnaiyou(), "", "変更前内容");

        exStringEquals(dsHenkouRireki5.getNewnaiyouoriginal(), "1", "変更後内容原本");

        exStringEquals(dsHenkouRireki5.getNewnaiyou(), "ＰＣ", "変更後内容");

        exStringEquals(dsHenkouRireki5.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");

        exStringEquals(dsHenkouRireki5.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki6 = dsHenkouRirekiLst.get(6);

        exStringEquals(dsHenkouRireki6.getDskokno(), "0010020042", "ＤＳ顧客番号");

        exStringEquals(dsHenkouRireki6.getHenkousikibetukey(), "000000000000000009", "変更識別キー");

        exNumericEquals(dsHenkouRireki6.getRenno(), 7, "連番");

        exStringEquals(dsHenkouRireki6.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");

        exStringEquals(dsHenkouRireki6.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");

        exClassificationEquals(dsHenkouRireki6.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU , "変更種類区分");

        exStringEquals(dsHenkouRireki6.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");

        exStringEquals(dsHenkouRireki6.getHenkoukoumokuid(), "dshnnkakcderrorkaisuu", "変更項目ID");

        exStringEquals(dsHenkouRireki6.getHenkoukoumokunm(), "ＤＳ本人確認コードエラー回数", "変更項目名");

        exStringEquals(dsHenkouRireki6.getBfrnaiyouoriginal(),"", "変更前内容原本");

        exStringEquals(dsHenkouRireki6.getBfrnaiyou(), "", "変更前内容");

        exStringEquals(dsHenkouRireki6.getNewnaiyouoriginal(), "0", "変更後内容原本");

        exStringEquals(dsHenkouRireki6.getNewnaiyou(), "0", "変更後内容");

        exStringEquals(dsHenkouRireki6.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");

        exStringEquals(dsHenkouRireki6.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki7 = dsHenkouRirekiLst.get(7);

        exStringEquals(dsHenkouRireki7.getDskokno(), "0010020042", "ＤＳ顧客番号");

        exStringEquals(dsHenkouRireki7.getHenkousikibetukey(), "000000000000000009", "変更識別キー");

        exNumericEquals(dsHenkouRireki7.getRenno(), 8, "連番");

        exStringEquals(dsHenkouRireki7.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");

        exStringEquals(dsHenkouRireki7.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");

        exClassificationEquals(dsHenkouRireki7.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU , "変更種類区分");

        exStringEquals(dsHenkouRireki7.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");

        exStringEquals(dsHenkouRireki7.getHenkoukoumokuid(), "dskokyakunmerrorkaisuu", "変更項目ID");

        exStringEquals(dsHenkouRireki7.getHenkoukoumokunm(), "ＤＳ顧客名エラー回数", "変更項目名");

        exStringEquals(dsHenkouRireki7.getBfrnaiyouoriginal(),"2", "変更前内容原本");

        exStringEquals(dsHenkouRireki7.getBfrnaiyou(), "2", "変更前内容");

        exStringEquals(dsHenkouRireki7.getNewnaiyouoriginal(), "0", "変更後内容原本");

        exStringEquals(dsHenkouRireki7.getNewnaiyou(), "0", "変更後内容");

        exStringEquals(dsHenkouRireki7.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");

        exStringEquals(dsHenkouRireki7.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki8 = dsHenkouRirekiLst.get(8);

        exStringEquals(dsHenkouRireki8.getDskokno(), "0010020042", "ＤＳ顧客番号");

        exStringEquals(dsHenkouRireki8.getHenkousikibetukey(), "000000000000000009", "変更識別キー");

        exNumericEquals(dsHenkouRireki8.getRenno(), 9, "連番");

        exStringEquals(dsHenkouRireki8.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");

        exStringEquals(dsHenkouRireki8.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");

        exClassificationEquals(dsHenkouRireki8.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU , "変更種類区分");

        exStringEquals(dsHenkouRireki8.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");

        exStringEquals(dsHenkouRireki8.getHenkoukoumokuid(), "dskokyakuseiymderrorkaisuu", "変更項目ID");

        exStringEquals(dsHenkouRireki8.getHenkoukoumokunm(), "ＤＳ顧客生年月日エラー回数", "変更項目名");

        exStringEquals(dsHenkouRireki8.getBfrnaiyouoriginal(),"2", "変更前内容原本");

        exStringEquals(dsHenkouRireki8.getBfrnaiyou(), "2", "変更前内容");

        exStringEquals(dsHenkouRireki8.getNewnaiyouoriginal(), "0", "変更後内容原本");

        exStringEquals(dsHenkouRireki8.getNewnaiyou(), "0", "変更後内容");

        exStringEquals(dsHenkouRireki8.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");

        exStringEquals(dsHenkouRireki8.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki9 = dsHenkouRirekiLst.get(9);

        exStringEquals(dsHenkouRireki9.getDskokno(), "0010020042", "ＤＳ顧客番号");

        exStringEquals(dsHenkouRireki9.getHenkousikibetukey(), "000000000000000009", "変更識別キー");

        exNumericEquals(dsHenkouRireki9.getRenno(), 10, "連番");

        exStringEquals(dsHenkouRireki9.getTablenm(), "ＤＳログイン管理テーブル", "テーブル名称");

        exStringEquals(dsHenkouRireki9.getTableid(), "MT_DsLoginKanri", "テーブルＩＤ");

        exClassificationEquals(dsHenkouRireki9.getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU , "変更種類区分");

        exStringEquals(dsHenkouRireki9.getHanbetukoumokunm(), "ＤＳログイン管理情報", "判別項目名");

        exStringEquals(dsHenkouRireki9.getHenkoukoumokuid(), "dskokyakutelnoerrorkaisuu", "変更項目ID");

        exStringEquals(dsHenkouRireki9.getHenkoukoumokunm(), "ＤＳ顧客電話番号エラー回数", "変更項目名");

        exStringEquals(dsHenkouRireki9.getBfrnaiyouoriginal(),"2", "変更前内容原本");

        exStringEquals(dsHenkouRireki9.getBfrnaiyou(), "2", "変更前内容");

        exStringEquals(dsHenkouRireki9.getNewnaiyouoriginal(), "0", "変更後内容原本");

        exStringEquals(dsHenkouRireki9.getNewnaiyou(), "0", "変更後内容");

        exStringEquals(dsHenkouRireki9.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");

        exStringEquals(dsHenkouRireki9.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_BAK_DsKokyakuKanri dsKokyakuKanriBak = directDomManager.getBAKDsKokyakuKanri("0010020042","000000000000000009");

        boolean dsKokyakuKanriBakHikaku = dsKokyakuKanriBak == null;
        exBooleanEquals(dsKokyakuKanriBakHikaku,false, "ＤＳ顧客管理バックアップテーブル比較結果");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'11807111118', 'iwsDskokno':'0010020042',"
            + " 'iwsNmkn':'カナタ', 'iwsSeiymd':'19900406', 'iwsTelnosimo4':'3382'}");

        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwhonninkakunin.DwHonninKakunin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwHonninKakuninImpl.execPostForm(pMap);

        exStringEquals(wsBzWebserviceResParamBean.getGyoumuData(),
            "{\"iwsDsmsgcd\":\"002204\",\"iwsSaisinlogintime\":null,\"iwsSaisinloginymd\":null}", "業務データ");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'11807111200', 'iwsDskokno':'0010020033',"
            + " 'iwsNmkn':'カナタ', 'iwsSeiymd':'19900406', 'iwsTelnosimo4':'3382'}");

        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwhonninkakunin.DwHonninKakunin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwHonninKakuninImpl.execPostForm(pMap);

        exStringEquals(wsBzWebserviceResParamBean.getGyoumuData(),
            "{\"iwsDsmsgcd\":\"002203\",\"iwsSaisinlogintime\":null,\"iwsSaisinloginymd\":null}", "業務データ");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'11807111222', 'iwsDskokno':'0010020034',"
            + " 'iwsNmkn':'カナタ', 'iwsSeiymd':'19900406', 'iwsTelnosimo4':'3382'}");

        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwhonninkakunin.DwHonninKakunin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwHonninKakuninImpl.execPostForm(pMap);

        exStringEquals(wsBzWebserviceResParamBean.getGyoumuData(),
            "{\"iwsDsmsgcd\":\"002201\",\"iwsSaisinlogintime\":null,\"iwsSaisinloginymd\":null}", "業務データ");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'11807111244', 'iwsDskokno':'0010020051',"
            + " 'iwsNmkn':'カタナ', 'iwsSeiymd':'19880413', 'iwsTelnosimo4':'3382'}");

        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwhonninkakunin.DwHonninKakunin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwHonninKakuninImpl.execPostForm(pMap);

        exStringEquals(wsBzWebserviceResParamBean.getGyoumuData(),
            "{\"iwsDsmsgcd\":\"002001\",\"iwsSaisinlogintime\":\"\",\"iwsSaisinloginymd\":\"\"}", "業務データ");

        MT_DsKokyakuKanri dsKoKyakuKanri = directDomManager.getDsKokyakuKanri("0010020051");
        exStringEquals(dsKoKyakuKanri.getDskokno(), "0010020051", "ＤＳ顧客番号");
        exClassificationEquals(dsKoKyakuKanri.getDskokyakujtkbn(), C_DsKokyakuJtKbn.ITIJI_TEISI, "ＤＳ顧客状態区分");
        exClassificationEquals(dsKoKyakuKanri.getDsteisiriyuukbn(), C_DsTeisiRiyuuKbn.LOCK_OUT, "ＤＳ停止理由区分");
        exDateEquals(dsKoKyakuKanri.getDskokyakumukouymd(), BizDate.getSysDate(), "ＤＳ顧客無効年月日");
        exStringEquals(dsKoKyakuKanri.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");
        exStringEquals(dsKoKyakuKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsLoginKanri dsLoginKanri = dsKoKyakuKanri.getDsLoginKanri();

        exStringEquals(dsLoginKanri.getDskokno(), "0010020051", "ＤＳ顧客番号");
        assertNull("初回ログイン年月日", dsLoginKanri.getSyokailoginymd());
        assertNull("初回ログイン時刻", dsLoginKanri.getSyokailogintime());
        assertNull("初回ログイン媒体区分", dsLoginKanri.getSyokailoginbaitaikbn());
        assertNull("最新ログイン年月日", dsLoginKanri.getSaisinloginymd());
        assertNull("最新ログイン時刻", dsLoginKanri.getSaisinlogintime());
        assertNull("最新ログイン媒体区分", dsLoginKanri.getSaisinloginbaitaikbn());
        assertNull("ＤＳ本人確認コードエラー回数", dsLoginKanri.getDshnnkakcderrorkaisuu());
        exNumericEquals(dsLoginKanri.getDskokyakunmerrorkaisuu(), 10, "ＤＳ顧客名エラー回数");
        exNumericEquals(dsLoginKanri.getDskokyakuseiymderrorkaisuu(), 11, "ＤＳ顧客生年月日エラー回数");
        exNumericEquals(dsLoginKanri.getDskokyakutelnoerrorkaisuu(), 12, "ＤＳ顧客電話番号エラー回数");
        exStringEquals(dsLoginKanri.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");
        exStringEquals(dsLoginKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'11807111129', 'iwsDskokno':'0010020052',"
            + " 'iwsNmkn':'アカサ', 'iwsSeiymd':'19880414', 'iwsTelnosimo4':'3383'}");

        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwhonninkakunin.DwHonninKakunin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwHonninKakuninImpl.execPostForm(pMap);

        exStringEquals(wsBzWebserviceResParamBean.getGyoumuData(),
            "{\"iwsDsmsgcd\":\"002202\",\"iwsSaisinlogintime\":null,\"iwsSaisinloginymd\":null}", "業務データ");
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'11807111255', 'iwsDskokno':'0010020053',"
            + " 'iwsNmkn':'カナタ', 'iwsSeiymd':'19900406', 'iwsTelnosimo4':'3381'}");

        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwhonninkakunin.DwHonninKakunin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwHonninKakuninImpl.execPostForm(pMap);

        exStringEquals(wsBzWebserviceResParamBean.getGyoumuData(),
            "{\"iwsDsmsgcd\":\"002002\",\"iwsSaisinlogintime\":\"\",\"iwsSaisinloginymd\":\"\"}", "業務データ");

        MT_DsKokyakuKanri dsKoKyakuKanri = directDomManager.getDsKokyakuKanri("0010020053");
        exStringEquals(dsKoKyakuKanri.getDskokno(), "0010020053", "ＤＳ顧客番号");
        assertNull("ＤＳ顧客状態区分", dsKoKyakuKanri.getDskokyakujtkbn());
        assertNull("ＤＳ停止理由区分", dsKoKyakuKanri.getDsteisiriyuukbn());
        assertNull("ＤＳ顧客無効年月日", dsKoKyakuKanri.getDskokyakumukouymd());
        assertNull("業務用更新機能ＩＤ", dsKoKyakuKanri.getGyoumuKousinKinou());
        assertNull("業務用更新者ＩＤ", dsKoKyakuKanri.getGyoumuKousinsyaId());

        MT_DsLoginKanri dsLoginKanri = dsKoKyakuKanri.getDsLoginKanri();

        exStringEquals(dsLoginKanri.getDskokno(), "0010020053", "ＤＳ顧客番号");
        assertNull("初回ログイン年月日", dsLoginKanri.getSyokailoginymd());
        assertNull("初回ログイン時刻", dsLoginKanri.getSyokailogintime());
        assertNull("初回ログイン媒体区分", dsLoginKanri.getSyokailoginbaitaikbn());
        assertNull("最新ログイン年月日", dsLoginKanri.getSaisinloginymd());
        assertNull("最新ログイン時刻", dsLoginKanri.getSaisinlogintime());
        assertNull("最新ログイン媒体区分", dsLoginKanri.getSaisinloginbaitaikbn());
        assertNull("ＤＳ本人確認コードエラー回数", dsLoginKanri.getDshnnkakcderrorkaisuu());
        exNumericEquals(dsLoginKanri.getDskokyakunmerrorkaisuu(), 2, "ＤＳ顧客名エラー回数");
        exNumericEquals(dsLoginKanri.getDskokyakuseiymderrorkaisuu(), 2, "ＤＳ顧客生年月日エラー回数");
        exNumericEquals(dsLoginKanri.getDskokyakutelnoerrorkaisuu(), 3, "ＤＳ顧客電話番号エラー回数");
        exStringEquals(dsLoginKanri.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");
        exStringEquals(dsLoginKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(170)
    public void testExec_A17() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'11807111266', 'iwsDskokno':'0010020054',"
            + " 'iwsNmkn':'サクラ', 'iwsSeiymd':'19900506', 'iwsTelnosimo4':'3381'}");

        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwhonninkakunin.DwHonninKakunin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwHonninKakuninImpl.execPostForm(pMap);

        exStringEquals(wsBzWebserviceResParamBean.getGyoumuData(),
            "{\"iwsDsmsgcd\":\"002002\",\"iwsSaisinlogintime\":\"\",\"iwsSaisinloginymd\":\"\"}", "業務データ");

        MT_DsKokyakuKanri dsKoKyakuKanri = directDomManager.getDsKokyakuKanri("0010020054");
        exStringEquals(dsKoKyakuKanri.getDskokno(), "0010020054", "ＤＳ顧客番号");
        assertNull("ＤＳ顧客状態区分", dsKoKyakuKanri.getDskokyakujtkbn());
        assertNull("ＤＳ停止理由区分", dsKoKyakuKanri.getDsteisiriyuukbn());
        assertNull("ＤＳ顧客無効年月日", dsKoKyakuKanri.getDskokyakumukouymd());
        assertNull("業務用更新機能ＩＤ", dsKoKyakuKanri.getGyoumuKousinKinou());
        assertNull("業務用更新者ＩＤ", dsKoKyakuKanri.getGyoumuKousinsyaId());

        MT_DsLoginKanri dsLoginKanri = dsKoKyakuKanri.getDsLoginKanri();

        exStringEquals(dsLoginKanri.getDskokno(), "0010020054", "ＤＳ顧客番号");
        assertNull("初回ログイン年月日", dsLoginKanri.getSyokailoginymd());
        assertNull("初回ログイン時刻", dsLoginKanri.getSyokailogintime());
        assertNull("初回ログイン媒体区分", dsLoginKanri.getSyokailoginbaitaikbn());
        assertNull("最新ログイン年月日", dsLoginKanri.getSaisinloginymd());
        assertNull("最新ログイン時刻", dsLoginKanri.getSaisinlogintime());
        assertNull("最新ログイン媒体区分", dsLoginKanri.getSaisinloginbaitaikbn());
        assertNull("ＤＳ本人確認コードエラー回数", dsLoginKanri.getDshnnkakcderrorkaisuu());
        exNumericEquals(dsLoginKanri.getDskokyakunmerrorkaisuu(), 1, "ＤＳ顧客名エラー回数");
        exNumericEquals(dsLoginKanri.getDskokyakuseiymderrorkaisuu(), 3, "ＤＳ顧客生年月日エラー回数");
        exNumericEquals(dsLoginKanri.getDskokyakutelnoerrorkaisuu(), 3, "ＤＳ顧客電話番号エラー回数");
        exStringEquals(dsLoginKanri.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");
        exStringEquals(dsLoginKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(180)
    public void testExec_A18() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'11807111277', 'iwsDskokno':'0010020055',"
            + " 'iwsNmkn':'サクラ', 'iwsSeiymd':'19900406', 'iwsTelnosimo4':'3383'}");

        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwhonninkakunin.DwHonninKakunin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwHonninKakuninImpl.execPostForm(pMap);

        exStringEquals(wsBzWebserviceResParamBean.getGyoumuData(),
            "{\"iwsDsmsgcd\":\"002002\",\"iwsSaisinlogintime\":\"\",\"iwsSaisinloginymd\":\"\"}", "業務データ");

        MT_DsKokyakuKanri dsKoKyakuKanri = directDomManager.getDsKokyakuKanri("0010020055");
        exStringEquals(dsKoKyakuKanri.getDskokno(), "0010020055", "ＤＳ顧客番号");
        assertNull("ＤＳ顧客状態区分", dsKoKyakuKanri.getDskokyakujtkbn());
        assertNull("ＤＳ停止理由区分", dsKoKyakuKanri.getDsteisiriyuukbn());
        assertNull("ＤＳ顧客無効年月日", dsKoKyakuKanri.getDskokyakumukouymd());
        assertNull("業務用更新機能ＩＤ", dsKoKyakuKanri.getGyoumuKousinKinou());
        assertNull("業務用更新者ＩＤ", dsKoKyakuKanri.getGyoumuKousinsyaId());

        MT_DsLoginKanri dsLoginKanri = dsKoKyakuKanri.getDsLoginKanri();

        exStringEquals(dsLoginKanri.getDskokno(), "0010020055", "ＤＳ顧客番号");
        assertNull("初回ログイン年月日", dsLoginKanri.getSyokailoginymd());
        assertNull("初回ログイン時刻", dsLoginKanri.getSyokailogintime());
        assertNull("初回ログイン媒体区分", dsLoginKanri.getSyokailoginbaitaikbn());
        assertNull("最新ログイン年月日", dsLoginKanri.getSaisinloginymd());
        assertNull("最新ログイン時刻", dsLoginKanri.getSaisinlogintime());
        assertNull("最新ログイン媒体区分", dsLoginKanri.getSaisinloginbaitaikbn());
        assertNull("ＤＳ本人確認コードエラー回数", dsLoginKanri.getDshnnkakcderrorkaisuu());
        exNumericEquals(dsLoginKanri.getDskokyakunmerrorkaisuu(), 3, "ＤＳ顧客名エラー回数");
        exNumericEquals(dsLoginKanri.getDskokyakuseiymderrorkaisuu(), 2, "ＤＳ顧客生年月日エラー回数");
        exNumericEquals(dsLoginKanri.getDskokyakutelnoerrorkaisuu(), 2, "ＤＳ顧客電話番号エラー回数");
        exStringEquals(dsLoginKanri.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");
        exStringEquals(dsLoginKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(185)
    public void testExec_A19() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'17806000013', 'iwsDskokno':'1000000016',"
            + " 'iwsNmkn':'ヲァィゥェォャュョッ', 'iwsSeiymd':19900406, 'iwsTelnosimo4':'3381'}");

        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwhonninkakunin.DwHonninKakunin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwHonninKakuninImpl.execPostForm(pMap);

        exStringEquals(wsBzWebserviceResParamBean.getGyoumuData(),
            "{\"iwsDsmsgcd\":\"002003\",\"iwsSaisinlogintime\":\"\",\"iwsSaisinloginymd\":\"\"}", "業務データ");

        MT_DsKokyakuKanri dsKoKyakuKanri = directDomManager.getDsKokyakuKanri("1000000016");
        exStringEquals(dsKoKyakuKanri.getDskokno(), "1000000016", "ＤＳ顧客番号");
        assertNull("ＤＳ顧客状態区分", dsKoKyakuKanri.getDskokyakujtkbn());
        assertNull("ＤＳ停止理由区分", dsKoKyakuKanri.getDsteisiriyuukbn());
        assertNull("ＤＳ顧客無効年月日", dsKoKyakuKanri.getDskokyakumukouymd());
        assertNull("業務用更新機能ＩＤ", dsKoKyakuKanri.getGyoumuKousinKinou());
        assertNull("業務用更新者ＩＤ", dsKoKyakuKanri.getGyoumuKousinsyaId());

        MT_DsLoginKanri dsLoginKanri = dsKoKyakuKanri.getDsLoginKanri();
        exStringEquals(dsLoginKanri.getDskokno(), "1000000016", "ＤＳ顧客番号");
        exDateEquals(dsLoginKanri.getSyokailoginymd(), BizDate.getSysDate(), "初回ログイン年月日");
        exClassificationEquals(dsLoginKanri.getSyokailoginbaitaikbn(), C_BaitaiKbn.PC, "初回ログイン媒体区分");
        exDateEquals(dsLoginKanri.getSaisinloginymd(), BizDate.getSysDate(), "最新ログイン年月日");
        exClassificationEquals(dsLoginKanri.getSaisinloginbaitaikbn(), C_BaitaiKbn.PC, "最新ログイン媒体区分");
        exNumericEquals(dsLoginKanri.getDshnnkakcderrorkaisuu(), 0, "ＤＳ本人確認コードエラー回数");
        exNumericEquals(dsLoginKanri.getDskokyakunmerrorkaisuu(), 0, "ＤＳ顧客名エラー回数");
        exNumericEquals(dsLoginKanri.getDskokyakuseiymderrorkaisuu(), 0, "ＤＳ顧客生年月日エラー回数");
        exNumericEquals(dsLoginKanri.getDskokyakutelnoerrorkaisuu(), 0, "ＤＳ顧客電話番号エラー回数");
        exStringEquals(dsLoginKanri.getGyoumuKousinKinou(), "dwhonninkakunin", "業務用更新機能ＩＤ");
        exStringEquals(dsLoginKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(190)
    public void testExec_B1() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'', 'iwsDskokno':'0010020052',"
            + " 'iwsNmkn':'アカサ', 'iwsSeiymd':'19880414', 'iwsTelnosimo4':'3383'}");

        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwhonninkakunin.DwHonninKakunin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwHonninKakuninImpl.execPostForm(pMap);

        exStringEquals(wsBzWebserviceResParamBean.getGyoumuData(),
            "{\"iwsDsmsgcd\":\"002100\",\"iwsSaisinlogintime\":null,\"iwsSaisinloginymd\":null}", "業務データ");
    }

    @Test
    @TestOrder(190)
    public void testExec_B2() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'11807111129', 'iwsDskokno':'',"
            + " 'iwsNmkn':'アカサ', 'iwsSeiymd':'19880414', 'iwsTelnosimo4':'3383'}");

        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwhonninkakunin.DwHonninKakunin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwHonninKakuninImpl.execPostForm(pMap);

        exStringEquals(wsBzWebserviceResParamBean.getGyoumuData(),
            "{\"iwsDsmsgcd\":\"002100\",\"iwsSaisinlogintime\":null,\"iwsSaisinloginymd\":null}", "業務データ");
    }

    @Test
    @TestOrder(200)
    public void testExec_B3() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'11807111129', 'iwsDskokno':'0010020034',"
            + " 'iwsNmkn':'', 'iwsSeiymd':'19880414', 'iwsTelnosimo4':'3383'}");

        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwhonninkakunin.DwHonninKakunin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwHonninKakuninImpl.execPostForm(pMap);

        exStringEquals(wsBzWebserviceResParamBean.getGyoumuData(),
            "{\"iwsDsmsgcd\":\"002100\",\"iwsSaisinlogintime\":null,\"iwsSaisinloginymd\":null}", "業務データ");
    }

    @Test
    @TestOrder(210)
    public void testExec_B4() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'11807111129', 'iwsDskokno':'0010020034',"
            + " 'iwsNmkn':'アカサ', 'iwsSeiymd':'', 'iwsTelnosimo4':'3383'}");

        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwhonninkakunin.DwHonninKakunin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwHonninKakuninImpl.execPostForm(pMap);

        exStringEquals(wsBzWebserviceResParamBean.getGyoumuData(),
            "{\"iwsDsmsgcd\":\"002100\",\"iwsSaisinlogintime\":null,\"iwsSaisinloginymd\":null}", "業務データ");
    }

    @Test
    @TestOrder(220)
    public void testExec_B5() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'11807111129', 'iwsDskokno':'0010020034',"
            + " 'iwsNmkn':'アカサ', 'iwsSeiymd':'19880414', 'iwsTelnosimo4':''}");

        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwhonninkakunin.DwHonninKakunin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwHonninKakuninImpl.execPostForm(pMap);

        exStringEquals(wsBzWebserviceResParamBean.getGyoumuData(),
            "{\"iwsDsmsgcd\":\"002100\",\"iwsSaisinlogintime\":null,\"iwsSaisinloginymd\":null}", "業務データ");
    }
}
