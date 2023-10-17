package yuyu.def.base.manager;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HolidayPtn;
import yuyu.def.db.entity.AT_HolidayGroup;
import yuyu.def.db.entity.AT_HolidayYoyaku;
import yuyu.testinfr.AbstractTest;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * BaseDomManagerクラスの、<br />
 * getHolidayYoyakusByHolidayGroupCd() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BaseDomManagerTest_getHolidayYoyakusByHolidayGroupCd extends AbstractTest {

    @Inject
    BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pHolidayGroupCd1 = "HGC0000001";
        String pHolidayGroupCd2 = "HGC0000002";
        String pHolidayGroupCd3 = "HGC0000003";

        AT_HolidayGroup aT_HolidayGroup1 = baseDomManager.getHolidayGroup(pHolidayGroupCd1);
        if ( null == aT_HolidayGroup1 ) {

            aT_HolidayGroup1 = new AT_HolidayGroup();
            aT_HolidayGroup1.setHolidayGroupCd(pHolidayGroupCd1);

            baseDomManager.insert(aT_HolidayGroup1);
        }

        AT_HolidayGroup aT_HolidayGroup2 = baseDomManager.getHolidayGroup(pHolidayGroupCd2);
        if ( null == aT_HolidayGroup2 ) {

            aT_HolidayGroup2 = new AT_HolidayGroup();
            aT_HolidayGroup2.setHolidayGroupCd(pHolidayGroupCd2);

            baseDomManager.insert(aT_HolidayGroup2);
        }

        AT_HolidayGroup aT_HolidayGroup3 = baseDomManager.getHolidayGroup(pHolidayGroupCd3);
        if ( null == aT_HolidayGroup3 ) {

            aT_HolidayGroup3 = new AT_HolidayGroup();
            aT_HolidayGroup3.setHolidayGroupCd(pHolidayGroupCd3);

            baseDomManager.insert(aT_HolidayGroup3);
        }

        String pHolidayCd1 = "HC00000001";
        String pHolidayCd2 = "HC00000002";
        String pHolidayCd3 = "HC00000003";
        String pHolidayCd4 = "HC00000004";
        String pHolidayCd5 = "HC00000005";
        String pHolidayCd6 = "HC00000006";
        String pHolidayCd7 = "HC00000007";
        String pHolidayCd8 = "HC00000008";
        String pHolidayCd9 = "HC00000009";
        String pHolidayCd10 = "HC00000010";
        String pHolidayCd11 = "HC00000011";
        String pHolidayCd12 = "HC00000012";
        BizDate pTekiyouYmdFrom1 = BizDate.valueOf("20150309");
        BizDate pTekiyouYmdFrom2 = BizDate.valueOf("20150409");
        BizDate pTekiyouYmdFrom3 = BizDate.valueOf("20150509");
        BizDate pTekiyouYmdFrom4 = BizDate.valueOf("20150609");
        BizDate pTekiyouYmdFrom5 = BizDate.valueOf("20150301");
        BizDate pTekiyouYmdFrom6 = BizDate.valueOf("20150401");
        BizDate pTekiyouYmdFrom7 = BizDate.valueOf("20150501");
        BizDate pTekiyouYmdFrom8 = BizDate.valueOf("20150301");
        BizDate pTekiyouYmdFrom9 = BizDate.valueOf("20150701");
        BizDate pTekiyouYmdFrom10 = BizDate.valueOf("20150401");
        BizDate pTekiyouYmdFrom11 = BizDate.valueOf("20150701");
        BizDate pTekiyouYmdFrom12 = BizDate.valueOf("20150701");
        BizDate pTekiyouYmdTo1 = BizDate.valueOf("20150309");
        BizDate pTekiyouYmdTo2 = BizDate.valueOf("20150409");
        BizDate pTekiyouYmdTo3 = BizDate.valueOf("20150509");
        BizDate pTekiyouYmdTo4 = BizDate.valueOf("20150609");
        BizDate pTekiyouYmdTo5 = BizDate.valueOf("20150409");
        BizDate pTekiyouYmdTo6 = BizDate.valueOf("20150509");
        BizDate pTekiyouYmdTo7 = BizDate.valueOf("20150709");
        BizDate pTekiyouYmdTo8 = BizDate.valueOf("20150709");
        BizDate pTekiyouYmdTo9 = BizDate.valueOf("20150509");
        BizDate pTekiyouYmdTo10 = BizDate.valueOf("20150509");
        BizDate pTekiyouYmdTo11 = BizDate.valueOf("20150709");
        BizDate pTekiyouYmdTo12 = BizDate.valueOf("20150709");
        C_HolidayPtn pHolidayPattern1 = C_HolidayPtn.SPECIFIC_DAY;
        C_HolidayPtn pHolidayPattern2 = C_HolidayPtn.NATIONAL_HOLIDAY;
        C_HolidayPtn pHolidayPattern3 = C_HolidayPtn.EVERY_WEEK;
        C_HolidayPtn pHolidayPattern4 = C_HolidayPtn.EQUINOX;
        C_HolidayPtn pHolidayPattern5 = C_HolidayPtn.EQUINOX;
        C_HolidayPtn pHolidayPattern6 = C_HolidayPtn.EQUINOX;
        C_HolidayPtn pHolidayPattern7 = C_HolidayPtn.EVERY_WEEK;
        C_HolidayPtn pHolidayPattern8 = C_HolidayPtn.EVERY_WEEK;
        C_HolidayPtn pHolidayPattern9 = C_HolidayPtn.NATIONAL_HOLIDAY;
        C_HolidayPtn pHolidayPattern10 = C_HolidayPtn.NATIONAL_HOLIDAY;
        C_HolidayPtn pHolidayPattern11 = C_HolidayPtn.SPECIFIC_DAY;
        C_HolidayPtn pHolidayPattern12 = C_HolidayPtn.SPECIFIC_DAY;
        String pHolidayPatternNm1 = "パターン名１";
        String pHolidayPatternNm2 = "パターン名２";
        String pHolidayPatternNm3 = "パターン名３";
        String pHolidayPatternNm4 = "パターン名４";
        String pHolidayPatternNm5 = "パターン名５";
        String pHolidayPatternNm6 = "パターン名５";
        String pHolidayPatternNm7 = "パターン名６";
        String pHolidayPatternNm8 = "パターン名６";
        String pHolidayPatternNm9 = "パターン名７";
        String pHolidayPatternNm10 = "パターン名７";
        String pHolidayPatternNm11 = "パターン名８";
        String pHolidayPatternNm12 = "パターン名５";

        AT_HolidayYoyaku aT_HolidayYoyaku1 = aT_HolidayGroup1.getHolidayYoyaku(pHolidayCd1);
        if ( null == aT_HolidayYoyaku1 ) {

            aT_HolidayYoyaku1 = aT_HolidayGroup1.createHolidayYoyaku();
            aT_HolidayYoyaku1.setHolidayCd(pHolidayCd1);
            aT_HolidayYoyaku1.setTekiyouYmdFrom(pTekiyouYmdFrom1);
            aT_HolidayYoyaku1.setTekiyouYmdTo(pTekiyouYmdTo1);
            aT_HolidayYoyaku1.setHolidayPattern(pHolidayPattern1);
            aT_HolidayYoyaku1.setHolidayPatternNm(pHolidayPatternNm1);

        }

        baseDomManager.update(aT_HolidayGroup1);

        AT_HolidayYoyaku aT_HolidayYoyaku2 = aT_HolidayGroup2.getHolidayYoyaku(pHolidayCd2);
        if ( null == aT_HolidayYoyaku2 ) {

            aT_HolidayYoyaku2 = aT_HolidayGroup2.createHolidayYoyaku();
            aT_HolidayYoyaku2.setHolidayCd(pHolidayCd2);
            aT_HolidayYoyaku2.setTekiyouYmdFrom(pTekiyouYmdFrom2);
            aT_HolidayYoyaku2.setTekiyouYmdTo(pTekiyouYmdTo2);
            aT_HolidayYoyaku2.setHolidayPattern(pHolidayPattern2);
            aT_HolidayYoyaku2.setHolidayPatternNm(pHolidayPatternNm2);

        }

        AT_HolidayYoyaku aT_HolidayYoyaku3 = aT_HolidayGroup2.getHolidayYoyaku(pHolidayCd3);
        if ( null == aT_HolidayYoyaku3 ) {

            aT_HolidayYoyaku3 = aT_HolidayGroup2.createHolidayYoyaku();
            aT_HolidayYoyaku3.setHolidayCd(pHolidayCd3);
            aT_HolidayYoyaku3.setTekiyouYmdFrom(pTekiyouYmdFrom3);
            aT_HolidayYoyaku3.setTekiyouYmdTo(pTekiyouYmdTo3);
            aT_HolidayYoyaku3.setHolidayPattern(pHolidayPattern3);
            aT_HolidayYoyaku3.setHolidayPatternNm(pHolidayPatternNm3);

        }

        AT_HolidayYoyaku aT_HolidayYoyaku4 = aT_HolidayGroup2.getHolidayYoyaku(pHolidayCd4);
        if ( null == aT_HolidayYoyaku4 ) {

            aT_HolidayYoyaku4 = aT_HolidayGroup2.createHolidayYoyaku();
            aT_HolidayYoyaku4.setHolidayCd(pHolidayCd4);
            aT_HolidayYoyaku4.setTekiyouYmdFrom(pTekiyouYmdFrom4);
            aT_HolidayYoyaku4.setTekiyouYmdTo(pTekiyouYmdTo4);
            aT_HolidayYoyaku4.setHolidayPattern(pHolidayPattern4);
            aT_HolidayYoyaku4.setHolidayPatternNm(pHolidayPatternNm4);

        }

        baseDomManager.update(aT_HolidayGroup2);

        AT_HolidayYoyaku aT_HolidayYoyaku5 = aT_HolidayGroup3.getHolidayYoyaku(pHolidayCd5);
        if ( null == aT_HolidayYoyaku5 ) {

            aT_HolidayYoyaku5 = aT_HolidayGroup3.createHolidayYoyaku();
            aT_HolidayYoyaku5.setHolidayCd(pHolidayCd5);
            aT_HolidayYoyaku5.setTekiyouYmdFrom(pTekiyouYmdFrom5);
            aT_HolidayYoyaku5.setTekiyouYmdTo(pTekiyouYmdTo5);
            aT_HolidayYoyaku5.setHolidayPattern(pHolidayPattern5);
            aT_HolidayYoyaku5.setHolidayPatternNm(pHolidayPatternNm5);

        }

        AT_HolidayYoyaku aT_HolidayYoyaku6 = aT_HolidayGroup3.getHolidayYoyaku(pHolidayCd6);
        if ( null == aT_HolidayYoyaku6 ) {

            aT_HolidayYoyaku6 = aT_HolidayGroup3.createHolidayYoyaku();
            aT_HolidayYoyaku6.setHolidayCd(pHolidayCd6);
            aT_HolidayYoyaku6.setTekiyouYmdFrom(pTekiyouYmdFrom6);
            aT_HolidayYoyaku6.setTekiyouYmdTo(pTekiyouYmdTo6);
            aT_HolidayYoyaku6.setHolidayPattern(pHolidayPattern6);
            aT_HolidayYoyaku6.setHolidayPatternNm(pHolidayPatternNm6);

        }

        AT_HolidayYoyaku aT_HolidayYoyaku7 = aT_HolidayGroup3.getHolidayYoyaku(pHolidayCd7);
        if ( null == aT_HolidayYoyaku7 ) {

            aT_HolidayYoyaku7 = aT_HolidayGroup3.createHolidayYoyaku();
            aT_HolidayYoyaku7.setHolidayCd(pHolidayCd7);
            aT_HolidayYoyaku7.setTekiyouYmdFrom(pTekiyouYmdFrom7);
            aT_HolidayYoyaku7.setTekiyouYmdTo(pTekiyouYmdTo7);
            aT_HolidayYoyaku7.setHolidayPattern(pHolidayPattern7);
            aT_HolidayYoyaku7.setHolidayPatternNm(pHolidayPatternNm7);

        }

        AT_HolidayYoyaku aT_HolidayYoyaku8 = aT_HolidayGroup3.getHolidayYoyaku(pHolidayCd8);
        if ( null == aT_HolidayYoyaku8 ) {

            aT_HolidayYoyaku8 = aT_HolidayGroup3.createHolidayYoyaku();
            aT_HolidayYoyaku8.setHolidayCd(pHolidayCd8);
            aT_HolidayYoyaku8.setTekiyouYmdFrom(pTekiyouYmdFrom8);
            aT_HolidayYoyaku8.setTekiyouYmdTo(pTekiyouYmdTo8);
            aT_HolidayYoyaku8.setHolidayPattern(pHolidayPattern8);
            aT_HolidayYoyaku8.setHolidayPatternNm(pHolidayPatternNm8);

        }

        AT_HolidayYoyaku aT_HolidayYoyaku9 = aT_HolidayGroup3.getHolidayYoyaku(pHolidayCd9);
        if ( null == aT_HolidayYoyaku9 ) {

            aT_HolidayYoyaku9 = aT_HolidayGroup3.createHolidayYoyaku();
            aT_HolidayYoyaku9.setHolidayCd(pHolidayCd9);
            aT_HolidayYoyaku9.setTekiyouYmdFrom(pTekiyouYmdFrom9);
            aT_HolidayYoyaku9.setTekiyouYmdTo(pTekiyouYmdTo9);
            aT_HolidayYoyaku9.setHolidayPattern(pHolidayPattern9);
            aT_HolidayYoyaku9.setHolidayPatternNm(pHolidayPatternNm9);

        }

        AT_HolidayYoyaku aT_HolidayYoyaku10 = aT_HolidayGroup3.getHolidayYoyaku(pHolidayCd10);
        if ( null == aT_HolidayYoyaku10 ) {

            aT_HolidayYoyaku10 = aT_HolidayGroup3.createHolidayYoyaku();
            aT_HolidayYoyaku10.setHolidayCd(pHolidayCd10);
            aT_HolidayYoyaku10.setTekiyouYmdFrom(pTekiyouYmdFrom10);
            aT_HolidayYoyaku10.setTekiyouYmdTo(pTekiyouYmdTo10);
            aT_HolidayYoyaku10.setHolidayPattern(pHolidayPattern10);
            aT_HolidayYoyaku10.setHolidayPatternNm(pHolidayPatternNm10);

        }

        AT_HolidayYoyaku aT_HolidayYoyaku11 = aT_HolidayGroup3.getHolidayYoyaku(pHolidayCd11);
        if ( null == aT_HolidayYoyaku11 ) {

            aT_HolidayYoyaku11 = aT_HolidayGroup3.createHolidayYoyaku();
            aT_HolidayYoyaku11.setHolidayCd(pHolidayCd11);
            aT_HolidayYoyaku11.setTekiyouYmdFrom(pTekiyouYmdFrom11);
            aT_HolidayYoyaku11.setTekiyouYmdTo(pTekiyouYmdTo11);
            aT_HolidayYoyaku11.setHolidayPattern(pHolidayPattern11);
            aT_HolidayYoyaku11.setHolidayPatternNm(pHolidayPatternNm11);

        }

        AT_HolidayYoyaku aT_HolidayYoyaku12 = aT_HolidayGroup3.getHolidayYoyaku(pHolidayCd12);
        if ( null == aT_HolidayYoyaku12 ) {

            aT_HolidayYoyaku12 = aT_HolidayGroup3.createHolidayYoyaku();
            aT_HolidayYoyaku12.setHolidayCd(pHolidayCd12);
            aT_HolidayYoyaku12.setTekiyouYmdFrom(pTekiyouYmdFrom12);
            aT_HolidayYoyaku12.setTekiyouYmdTo(pTekiyouYmdTo12);
            aT_HolidayYoyaku12.setHolidayPattern(pHolidayPattern12);
            aT_HolidayYoyaku12.setHolidayPatternNm(pHolidayPatternNm12);

        }

        baseDomManager.update(aT_HolidayGroup3);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pHolidayGroupCd1 = "HGC0000001";
        String pHolidayGroupCd2 = "HGC0000002";
        String pHolidayGroupCd3 = "HGC0000003";

        AT_HolidayGroup aT_HolidayGroup1 = baseDomManager.getHolidayGroup(pHolidayGroupCd1);
        if ( null != aT_HolidayGroup1 ) {

            aT_HolidayGroup1.getHolidayYoyakus().removeAll(aT_HolidayGroup1.getHolidayYoyakus());

            baseDomManager.update(aT_HolidayGroup1);
            baseDomManager.delete(aT_HolidayGroup1);
        }

        AT_HolidayGroup aT_HolidayGroup2 = baseDomManager.getHolidayGroup(pHolidayGroupCd2);
        if ( null != aT_HolidayGroup2 ) {

            aT_HolidayGroup2.getHolidayYoyakus().removeAll(aT_HolidayGroup2.getHolidayYoyakus());

            baseDomManager.update(aT_HolidayGroup2);
            baseDomManager.delete(aT_HolidayGroup2);
        }

        AT_HolidayGroup aT_HolidayGroup3 = baseDomManager.getHolidayGroup(pHolidayGroupCd3);
        if ( null != aT_HolidayGroup3 ) {

            aT_HolidayGroup3.getHolidayYoyakus().removeAll(aT_HolidayGroup3.getHolidayYoyakus());

            baseDomManager.update(aT_HolidayGroup3);
            baseDomManager.delete(aT_HolidayGroup3);
        }
    }

    @Test
    public void test001(){
        String pHolidayGroupCd = "HGC0000099";
        List<AT_HolidayYoyaku> aT_HolidayYoyakuList = baseDomManager.getHolidayYoyakusByHolidayGroupCd(pHolidayGroupCd);

        assertEquals(0, aT_HolidayYoyakuList.size());

    }

    @Test
    public void test002(){
        String pHolidayGroupCd = "HGC0000001";
        List<AT_HolidayYoyaku> aT_HolidayYoyakuList = baseDomManager.getHolidayYoyakusByHolidayGroupCd(pHolidayGroupCd);

        assertEquals(1, aT_HolidayYoyakuList.size());

    }

    @Test
    public void test003(){
        String pHolidayGroupCd = "HGC0000002";
        List<AT_HolidayYoyaku> aT_HolidayYoyakuList = baseDomManager.getHolidayYoyakusByHolidayGroupCd(pHolidayGroupCd);

        assertEquals(3, aT_HolidayYoyakuList.size());

    }

    @Test
    public void test004(){
        String pHolidayGroupCd = "";
        List<AT_HolidayYoyaku> aT_HolidayYoyakuList = baseDomManager.getHolidayYoyakusByHolidayGroupCd(pHolidayGroupCd);

        assertEquals(0, aT_HolidayYoyakuList.size());

    }

    @Test
    public void test005(){
        String pHolidayGroupCd = null;

        List<AT_HolidayYoyaku> aT_HolidayYoyakuList = baseDomManager.getHolidayYoyakusByHolidayGroupCd(pHolidayGroupCd);

        List<AT_HolidayYoyaku> resultaT_HolidayYoyakuList = ImmutableList.copyOf(Iterables.filter(aT_HolidayYoyakuList, new Predicate<AT_HolidayYoyaku>() {

            @Override
            public boolean apply(AT_HolidayYoyaku paT_HolidayYoyakuEntity) {

                List<String> pHolidayGroupCdList = new ArrayList<String>();
                pHolidayGroupCdList.add("HGC0000001");
                pHolidayGroupCdList.add("HGC0000002");
                pHolidayGroupCdList.add("HGC0000003");

                for (String holidayGroupCd : pHolidayGroupCdList) {
                    if (holidayGroupCd.equals(paT_HolidayYoyakuEntity.getHolidayGroupCd())) {
                        return true;
                    }
                }

                return false;
            }

        }));

        long count = resultaT_HolidayYoyakuList.size();

        assertEquals(12, count);

    }

    @Test
    public void test006(){
        String pHolidayGroupCd = "HGC0000003";
        List<AT_HolidayYoyaku> aT_HolidayYoyakuList = baseDomManager.getHolidayYoyakusByHolidayGroupCd(pHolidayGroupCd);

        BizDate pTekiyouYmdFrom1 = BizDate.valueOf("20150301");
        BizDate pTekiyouYmdFrom2 = BizDate.valueOf("20150401");
        BizDate pTekiyouYmdFrom3 = BizDate.valueOf("20150501");
        BizDate pTekiyouYmdFrom4 = BizDate.valueOf("20150301");
        BizDate pTekiyouYmdFrom5 = BizDate.valueOf("20150701");
        BizDate pTekiyouYmdFrom6 = BizDate.valueOf("20150401");
        BizDate pTekiyouYmdFrom7 = BizDate.valueOf("20150701");
        BizDate pTekiyouYmdFrom8 = BizDate.valueOf("20150701");
        BizDate pTekiyouYmdTo1 = BizDate.valueOf("20150409");
        BizDate pTekiyouYmdTo2 = BizDate.valueOf("20150509");
        BizDate pTekiyouYmdTo3 = BizDate.valueOf("20150709");
        BizDate pTekiyouYmdTo4 = BizDate.valueOf("20150709");
        BizDate pTekiyouYmdTo5 = BizDate.valueOf("20150509");
        BizDate pTekiyouYmdTo6 = BizDate.valueOf("20150509");
        BizDate pTekiyouYmdTo7 = BizDate.valueOf("20150709");
        BizDate pTekiyouYmdTo8 = BizDate.valueOf("20150709");
        C_HolidayPtn pHolidayPattern1 = C_HolidayPtn.EQUINOX;
        C_HolidayPtn pHolidayPattern2 = C_HolidayPtn.EQUINOX;
        C_HolidayPtn pHolidayPattern3 = C_HolidayPtn.EVERY_WEEK;
        C_HolidayPtn pHolidayPattern4 = C_HolidayPtn.EVERY_WEEK;
        C_HolidayPtn pHolidayPattern5 = C_HolidayPtn.NATIONAL_HOLIDAY;
        C_HolidayPtn pHolidayPattern6 = C_HolidayPtn.NATIONAL_HOLIDAY;
        C_HolidayPtn pHolidayPattern7 = C_HolidayPtn.SPECIFIC_DAY;
        C_HolidayPtn pHolidayPattern8 = C_HolidayPtn.SPECIFIC_DAY;
        String pHolidayPatternNm1 = "パターン名５";
        String pHolidayPatternNm2 = "パターン名５";
        String pHolidayPatternNm3 = "パターン名６";
        String pHolidayPatternNm4 = "パターン名６";
        String pHolidayPatternNm5 = "パターン名７";
        String pHolidayPatternNm6 = "パターン名７";
        String pHolidayPatternNm7 = "パターン名８";
        String pHolidayPatternNm8 = "パターン名５";

        assertEquals(pHolidayPattern1, aT_HolidayYoyakuList.get(0).getHolidayPattern());
        assertEquals(pTekiyouYmdTo1, aT_HolidayYoyakuList.get(0).getTekiyouYmdTo());
        assertEquals(pTekiyouYmdFrom1, aT_HolidayYoyakuList.get(0).getTekiyouYmdFrom());
        assertEquals(pHolidayPatternNm1, aT_HolidayYoyakuList.get(0).getHolidayPatternNm());

        assertEquals(pHolidayPattern2, aT_HolidayYoyakuList.get(1).getHolidayPattern());
        assertEquals(pTekiyouYmdTo2, aT_HolidayYoyakuList.get(1).getTekiyouYmdTo());
        assertEquals(pTekiyouYmdFrom2, aT_HolidayYoyakuList.get(1).getTekiyouYmdFrom());
        assertEquals(pHolidayPatternNm2, aT_HolidayYoyakuList.get(1).getHolidayPatternNm());

        assertEquals(pHolidayPattern3, aT_HolidayYoyakuList.get(2).getHolidayPattern());
        assertEquals(pTekiyouYmdTo3, aT_HolidayYoyakuList.get(2).getTekiyouYmdTo());
        assertEquals(pTekiyouYmdFrom4, aT_HolidayYoyakuList.get(2).getTekiyouYmdFrom());
        assertEquals(pHolidayPatternNm3, aT_HolidayYoyakuList.get(2).getHolidayPatternNm());

        assertEquals(pHolidayPattern4, aT_HolidayYoyakuList.get(3).getHolidayPattern());
        assertEquals(pTekiyouYmdTo4, aT_HolidayYoyakuList.get(3).getTekiyouYmdTo());
        assertEquals(pTekiyouYmdFrom3, aT_HolidayYoyakuList.get(3).getTekiyouYmdFrom());
        assertEquals(pHolidayPatternNm4, aT_HolidayYoyakuList.get(3).getHolidayPatternNm());

        assertEquals(pHolidayPattern5, aT_HolidayYoyakuList.get(4).getHolidayPattern());
        assertEquals(pTekiyouYmdTo5, aT_HolidayYoyakuList.get(4).getTekiyouYmdTo());
        assertEquals(pTekiyouYmdFrom6, aT_HolidayYoyakuList.get(4).getTekiyouYmdFrom());
        assertEquals(pHolidayPatternNm5, aT_HolidayYoyakuList.get(4).getHolidayPatternNm());

        assertEquals(pHolidayPattern6, aT_HolidayYoyakuList.get(5).getHolidayPattern());
        assertEquals(pTekiyouYmdTo6, aT_HolidayYoyakuList.get(5).getTekiyouYmdTo());
        assertEquals(pTekiyouYmdFrom5, aT_HolidayYoyakuList.get(5).getTekiyouYmdFrom());
        assertEquals(pHolidayPatternNm6, aT_HolidayYoyakuList.get(5).getHolidayPatternNm());

        assertEquals(pHolidayPattern7, aT_HolidayYoyakuList.get(6).getHolidayPattern());
        assertEquals(pTekiyouYmdTo7, aT_HolidayYoyakuList.get(6).getTekiyouYmdTo());
        assertEquals(pTekiyouYmdFrom7, aT_HolidayYoyakuList.get(6).getTekiyouYmdFrom());
        assertEquals(pHolidayPatternNm8, aT_HolidayYoyakuList.get(6).getHolidayPatternNm());

        assertEquals(pHolidayPattern8, aT_HolidayYoyakuList.get(7).getHolidayPattern());
        assertEquals(pTekiyouYmdTo8, aT_HolidayYoyakuList.get(7).getTekiyouYmdTo());
        assertEquals(pTekiyouYmdFrom8, aT_HolidayYoyakuList.get(7).getTekiyouYmdFrom());
        assertEquals(pHolidayPatternNm7, aT_HolidayYoyakuList.get(7).getHolidayPatternNm());

    }
}
