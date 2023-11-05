package yuyu.def.db.entity;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_BAK_AnsyuKihon;
import yuyu.def.db.entity.IT_BAK_KykKihon;
import yuyu.def.db.entity.IT_HurikomiIraiTuuti;
import yuyu.def.db.entity.IT_KijituTouraiAnnai;
import yuyu.def.db.entity.IT_KoujyoSymSougou;
import yuyu.def.db.entity.IT_KouzahuriMinyuTuuti;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_MinyuList;
import yuyu.def.db.entity.IT_MukouTuuti;
import yuyu.def.db.entity.IT_SikkouTuuti;
import yuyu.def.db.entity.IT_SinkokuyokokuTuuti;
import yuyu.def.db.entity.IT_SougouTuuti;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全<br />
 * 障害 #136786「契約基本テーブル取得のSelectが何度も実行される」対応のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HozenRootEntitySelectOneTest {

    @Inject
    HozenDomManager hozenDomManager;


    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_AnsyuKihon ansyuKihon1 = new IT_AnsyuKihon("10000000010");
        hozenDomManager.insert(ansyuKihon1);

        IT_BAK_AnsyuKihon bakansyuKihon1 = new IT_BAK_AnsyuKihon("10000000010","SNK0002");
        hozenDomManager.insert(bakansyuKihon1);

        IT_BAK_KykKihon bakkykKihon1 = new IT_BAK_KykKihon("10000000010","SNK0002");
        hozenDomManager.insert(bakkykKihon1);

        IT_HurikomiIraiTuuti hurikomiIraiTuuti1 = new IT_HurikomiIraiTuuti("10000000010",BizDate.valueOf(20161207));
        hozenDomManager.insert(hurikomiIraiTuuti1);

        IT_KijituTouraiAnnai kijituTouraiAnnai1 = new IT_KijituTouraiAnnai("10000000010",BizDate.valueOf(20161207));
        hozenDomManager.insert(kijituTouraiAnnai1);

        IT_KoujyoSymSougou koujyoSymSougou1 = new IT_KoujyoSymSougou("10000000010","2017",BizDate.valueOf(20161207),1);
        hozenDomManager.insert(koujyoSymSougou1);

        IT_KouzahuriMinyuTuuti kouzahuriMinyuTuuti1 = new IT_KouzahuriMinyuTuuti("10000000010",BizDate.valueOf(20161207));
        hozenDomManager.insert(kouzahuriMinyuTuuti1);

        IT_KykKihon kykKihon1 = new IT_KykKihon("10000000010");
        hozenDomManager.insert(kykKihon1);

        IT_MinyuList minyuList1 = new IT_MinyuList("10000000010",BizDate.valueOf(20161207));
        hozenDomManager.insert(minyuList1);

        IT_MukouTuuti mukouTuuti1 = new IT_MukouTuuti("10000000010",BizDate.valueOf(20161207));
        hozenDomManager.insert(mukouTuuti1);

        IT_SikkouTuuti sikkouTuuti1 = new IT_SikkouTuuti("10000000010",BizDate.valueOf(20161207));
        hozenDomManager.insert(sikkouTuuti1);

        IT_SinkokuyokokuTuuti sinkokuyokokuTuuti1 = new IT_SinkokuyokokuTuuti("10000000010","2017",BizDate.valueOf(20161207),1);
        hozenDomManager.insert(sinkokuyokokuTuuti1);

        IT_SougouTuuti sougouTuuti1 = new IT_SougouTuuti("10000000010",BizDate.valueOf(20161207));
        hozenDomManager.insert(sougouTuuti1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllAnsyuKihon());
        hozenDomManager.delete(hozenDomManager.getAllBAKAnsyuKihon());
        hozenDomManager.delete(hozenDomManager.getAllBAKKykKihon());
        hozenDomManager.delete(hozenDomManager.getAllHurikomiIraiTuuti());
        hozenDomManager.delete(hozenDomManager.getAllKijituTouraiAnnai());
        hozenDomManager.delete(hozenDomManager.getAllKoujyoSymSougou());
        hozenDomManager.delete(hozenDomManager.getAllKouzahuriMinyuTuuti());
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        hozenDomManager.delete(hozenDomManager.getAllMinyuList());
        hozenDomManager.delete(hozenDomManager.getAllMukouTuuti());
        hozenDomManager.delete(hozenDomManager.getAllSikkouTuuti());
        hozenDomManager.delete(hozenDomManager.getAllSinkokuyokokuTuuti());
        hozenDomManager.delete(hozenDomManager.getAllSougouTuuti());

    }

    @Test
    @TestOrder(11)
    public void Result1() {

        System.out.println("■■■■■■次の■までログにはsql文が出ることを確認する");
        IT_AnsyuKihon ansyuKihonResult1 = hozenDomManager.getAnsyuKihon("10000000010");
        System.out.println("■■■■■■");

        System.out.println("■■■■■■次の■までログにはsql文が出ないことを確認する");
        IT_AnsyuKihon ansyuKihonResult2 = hozenDomManager.getAnsyuKihon("10000000010");
        System.out.println("■■■■■■");

        System.out.println("■■■■■■次の■までログにはsql文が出ないことを確認する");
        IT_AnsyuKihon ansyuKihonResult3 = hozenDomManager.getAnsyuKihon("10000000010");
        System.out.println("■■■■■■");

    }

    @Test
    @TestOrder(12)
    public void Result2() {

        System.out.println("■■■■■■次の■までログにはsql文が出ることを確認する");
        IT_BAK_AnsyuKihon basansyuKihonResult1 = hozenDomManager.getBAKAnsyuKihon("10000000010","SNK0002");
        System.out.println("■■■■■■");

        System.out.println("■■■■■■次の■までログにはsql文が出ないことを確認する");
        IT_BAK_AnsyuKihon basansyuKihonResult2 = hozenDomManager.getBAKAnsyuKihon("10000000010","SNK0002");
        System.out.println("■■■■■■");

        System.out.println("■■■■■■次の■までログにはsql文が出ないことを確認する");
        IT_BAK_AnsyuKihon basansyuKihonResult3 = hozenDomManager.getBAKAnsyuKihon("10000000010","SNK0002");
        System.out.println("■■■■■■");

    }

    @Test
    @TestOrder(13)
    public void Result3() {

        System.out.println("■■■■■■次の■までログにはsql文が出ることを確認する");
        IT_BAK_KykKihon bakkykKihonResult1 = hozenDomManager.getBAKKykKihon("10000000010","SNK0002");
        System.out.println("■■■■■■");

        System.out.println("■■■■■■次の■までログにはsql文が出ないことを確認する");
        IT_BAK_KykKihon bakkykKihonResult2 = hozenDomManager.getBAKKykKihon("10000000010","SNK0002");
        System.out.println("■■■■■■");

        System.out.println("■■■■■■次の■までログにはsql文が出ないことを確認する");
        IT_BAK_KykKihon bakkykKihonResult3 = hozenDomManager.getBAKKykKihon("10000000010","SNK0002");
        System.out.println("■■■■■■");

    }

    @Test
    @TestOrder(14)
    public void Result4() {

        System.out.println("■■■■■■次の■までログにはsql文が出ることを確認する");
        IT_HurikomiIraiTuuti hurikomiIraiTuutiResult1 = hozenDomManager.getHurikomiIraiTuuti("10000000010",BizDate.valueOf(20161207));
        System.out.println("■■■■■■");

        System.out.println("■■■■■■次の■までログにはsql文が出ないことを確認する");
        IT_HurikomiIraiTuuti hurikomiIraiTuutiResult2 = hozenDomManager.getHurikomiIraiTuuti("10000000010",BizDate.valueOf(20161207));
        System.out.println("■■■■■■");

        System.out.println("■■■■■■次の■までログにはsql文が出ないことを確認する");
        IT_HurikomiIraiTuuti hurikomiIraiTuutiResult3 = hozenDomManager.getHurikomiIraiTuuti("10000000010",BizDate.valueOf(20161207));
        System.out.println("■■■■■■");

    }


    @Test
    @TestOrder(15)
    public void Result5() {

        System.out.println("■■■■■■次の■までログにはsql文が出ることを確認する");
        IT_KijituTouraiAnnai kijituTouraiAnnaiResult1 = hozenDomManager.getKijituTouraiAnnai("10000000010",BizDate.valueOf(20161207));
        System.out.println("■■■■■■");

        System.out.println("■■■■■■次の■までログにはsql文が出ることを確認する");
        IT_KijituTouraiAnnai kijituTouraiAnnaiResult2 = hozenDomManager.getKijituTouraiAnnai("10000000010",BizDate.valueOf(20161207));
        System.out.println("■■■■■■");

        System.out.println("■■■■■■次の■までログにはsql文が出ないことを確認する");
        IT_KijituTouraiAnnai kijituTouraiAnnaiResult3 = hozenDomManager.getKijituTouraiAnnai("10000000010",BizDate.valueOf(20161207));
        System.out.println("■■■■■■");

    }



    @Test
    @TestOrder(16)
    public void Result6() {

        System.out.println("■■■■■■次の■までログにはsql文が出ることを確認する");
        IT_KoujyoSymSougou koujyoSymSougouResult1 = hozenDomManager.getKoujyoSymSougou("10000000010","2017",BizDate.valueOf(20161207),1);
        System.out.println("■■■■■■");

        System.out.println("■■■■■■次の■までログにはsql文が出ないことを確認する");
        IT_KoujyoSymSougou koujyoSymSougouResult2 = hozenDomManager.getKoujyoSymSougou("10000000010","2017",BizDate.valueOf(20161207),1);
        System.out.println("■■■■■■");

        System.out.println("■■■■■■次の■までログにはsql文が出ないことを確認する");
        IT_KoujyoSymSougou koujyoSymSougouResult3 = hozenDomManager.getKoujyoSymSougou("10000000010","2017",BizDate.valueOf(20161207),1);
        System.out.println("■■■■■■");

    }



    @Test
    @TestOrder(17)
    public void Result7() {

        System.out.println("■■■■■■次の■までログにはsql文が出ることを確認する");
        IT_KouzahuriMinyuTuuti kouzahuriMinyuTuutiResult1 = hozenDomManager.getKouzahuriMinyuTuuti("10000000010",BizDate.valueOf(20161207));
        System.out.println("■■■■■■");

        System.out.println("■■■■■■次の■までログにはsql文が出ないことを確認する");
        IT_KouzahuriMinyuTuuti kouzahuriMinyuTuutiResult2 = hozenDomManager.getKouzahuriMinyuTuuti("10000000010",BizDate.valueOf(20161207));
        System.out.println("■■■■■■");

        System.out.println("■■■■■■次の■までログにはsql文が出ないことを確認する");
        IT_KouzahuriMinyuTuuti kouzahuriMinyuTuutiResult3 = hozenDomManager.getKouzahuriMinyuTuuti("10000000010",BizDate.valueOf(20161207));
        System.out.println("■■■■■■");

    }



    @Test
    @TestOrder(18)
    public void Result8() {

        System.out.println("■■■■■■次の■までログにはsql文が出ることを確認する");
        IT_KykKihon kykKihonResult1 = hozenDomManager.getKykKihon("10000000010");
        System.out.println("■■■■■■");

        System.out.println("■■■■■■次の■までログにはsql文が出ないことを確認する");
        IT_KykKihon kykKihonResult2 = hozenDomManager.getKykKihon("10000000010");
        System.out.println("■■■■■■");

        System.out.println("■■■■■■次の■までログにはsql文が出ないことを確認する");
        IT_KykKihon kykKihonResult3 = hozenDomManager.getKykKihon("10000000010");
        System.out.println("■■■■■■");

    }


    @Test
    @TestOrder(19)
    public void Result9() {

        System.out.println("■■■■■■次の■までログにはsql文が出ることを確認する");
        IT_MinyuList minyuLisResult1 = hozenDomManager.getMinyuList("10000000010",BizDate.valueOf(20161207));
        System.out.println("■■■■■■");

        System.out.println("■■■■■■次の■までログにはsql文が出ないことを確認する");
        IT_MinyuList minyuLisResult2 = hozenDomManager.getMinyuList("10000000010",BizDate.valueOf(20161207));
        System.out.println("■■■■■■");

        System.out.println("■■■■■■次の■までログにはsql文が出ないことを確認する");
        IT_MinyuList minyuLisResult3 = hozenDomManager.getMinyuList("10000000010",BizDate.valueOf(20161207));
        System.out.println("■■■■■■");

    }


    @Test
    @TestOrder(20)
    public void Result10() {

        System.out.println("■■■■■■次の■までログにはsql文が出ることを確認する");
        IT_MukouTuuti mukouTuutiResult1 = hozenDomManager.getMukouTuuti("10000000010",BizDate.valueOf(20161207));
        System.out.println("■■■■■■");

        System.out.println("■■■■■■次の■までログにはsql文が出ないことを確認する");
        IT_MukouTuuti mukouTuutiResult2 = hozenDomManager.getMukouTuuti("10000000010",BizDate.valueOf(20161207));
        System.out.println("■■■■■■");

        System.out.println("■■■■■■次の■までログにはsql文が出ないことを確認する");
        IT_MukouTuuti mukouTuutiResult3 = hozenDomManager.getMukouTuuti("10000000010",BizDate.valueOf(20161207));
        System.out.println("■■■■■■");

    }


    @Test
    @TestOrder(21)
    public void Result11() {

        System.out.println("■■■■■■次の■までログにはsql文が出ることを確認する");
        IT_SikkouTuuti sikkouTuutiResult1 = hozenDomManager.getSikkouTuuti("10000000010",BizDate.valueOf(20161207));
        System.out.println("■■■■■■");

        System.out.println("■■■■■■次の■までログにはsql文が出ないことを確認する");
        IT_SikkouTuuti sikkouTuutiResult2 = hozenDomManager.getSikkouTuuti("10000000010",BizDate.valueOf(20161207));
        System.out.println("■■■■■■");

        System.out.println("■■■■■■次の■までログにはsql文が出ないことを確認する");
        IT_SikkouTuuti sikkouTuutiResult3 = hozenDomManager.getSikkouTuuti("10000000010",BizDate.valueOf(20161207));
        System.out.println("■■■■■■");

    }

    @Test
    @TestOrder(22)
    public void Result12() {

        System.out.println("■■■■■■次の■までログにはsql文が出ることを確認する");
        IT_SinkokuyokokuTuuti sinkokuyokokuTuutiResult1 = hozenDomManager.getSinkokuyokokuTuuti("10000000010","2017",BizDate.valueOf(20161207),1);
        System.out.println("■■■■■■");

        System.out.println("■■■■■■次の■までログにはsql文が出ないことを確認する");
        IT_SinkokuyokokuTuuti sinkokuyokokuTuutiResult2 = hozenDomManager.getSinkokuyokokuTuuti("10000000010","2017",BizDate.valueOf(20161207),1);
        System.out.println("■■■■■■");

        System.out.println("■■■■■■次の■までログにはsql文が出ないことを確認する");
        IT_SinkokuyokokuTuuti sinkokuyokokuTuutiResult3 = hozenDomManager.getSinkokuyokokuTuuti("10000000010","2017",BizDate.valueOf(20161207),1);
        System.out.println("■■■■■■");
    }

    @Test
    @TestOrder(23)
    public void Result13() {

        System.out.println("■■■■■■次の■までログにはsql文が出ることを確認する");
        IT_SougouTuuti sougouTuutiResult1 = hozenDomManager.getSougouTuuti("10000000010",BizDate.valueOf(20161207));
        System.out.println("■■■■■■");

        System.out.println("■■■■■■次の■までログにはsql文が出ないことを確認する");
        IT_SougouTuuti sougouTuutiResult2 = hozenDomManager.getSougouTuuti("10000000010",BizDate.valueOf(20161207));
        System.out.println("■■■■■■");

        System.out.println("■■■■■■次の■までログにはsql文が出ないことを確認する");
        IT_SougouTuuti sougouTuutiResult3 = hozenDomManager.getSougouTuuti("10000000010",BizDate.valueOf(20161207));
        System.out.println("■■■■■■");
    }


}

