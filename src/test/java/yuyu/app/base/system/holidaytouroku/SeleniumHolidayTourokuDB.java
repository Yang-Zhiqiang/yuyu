package yuyu.app.base.system.holidaytouroku;

import static yuyu.app.base.system.holidaytouroku.SeleniumHolidayTourokuConstants.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.date.BizDateConfig;
import jp.co.slcs.swak.date.SeirekiWarekiKbn;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AT_HolidayGroup;
import yuyu.def.db.entity.AT_HolidayYoyaku;

public class SeleniumHolidayTourokuDB {

    @Inject
    private BaseDomManager baseDomManager;

    @Transactional
    public void createTestB0003_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestB0003_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestB0005_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestB0005_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestB0006_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestB0006_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestB0007_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void createTestB0007_02(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if( null != holidayGroup ) {

            AT_HolidayYoyaku holidayYoyaku = holidayGroup.getHolidayYoyaku(NEWHOLIDAYCD);
            if ( null == holidayYoyaku ) {
                holidayYoyaku = holidayGroup.createHolidayYoyaku();
                holidayYoyaku.setHolidayCd(NEWHOLIDAYCD);
                holidayYoyaku.setLegalHolidayKbn(ALREADYHOLIDAYLEGALHOLIDAYKBN);
                holidayYoyaku.setTekiyouYmdFrom(ALREADYTEKIYOUYMDFROM);
                holidayYoyaku.setTekiyouYmdTo(ALREADYTEKIYOUYMDTO);
                holidayYoyaku.setHolidayPattern(ALREADYHOLIDAYPATTERN);
                holidayYoyaku.setHolidayPatternParam(ALREADYHOLIDAYPATTERNPARAMNM);
                holidayYoyaku.setHolidayPatternNm(ALREADYHOLIDAYPATTERNNM);
                holidayYoyaku.setHolidayPatternDescription(ALREADYHOLIDAYPATTERNBIKOU);

                baseDomManager.update(holidayGroup);
            }

        }
    }

    @Transactional
    public void deleteTestB0007_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {
            holidayGroup.getHolidayYoyakus().removeAll(holidayGroup.getHolidayYoyakus());

            baseDomManager.update(holidayGroup);
            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestB0008_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void createTestB0008_02(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if( null != holidayGroup ) {

            AT_HolidayYoyaku holidayYoyaku = holidayGroup.getHolidayYoyaku(NEWHOLIDAYCD);
            if ( null == holidayYoyaku ) {
                holidayYoyaku = holidayGroup.createHolidayYoyaku();
                holidayYoyaku.setHolidayCd(NEWHOLIDAYCD);
                holidayYoyaku.setLegalHolidayKbn(ALREADYHOLIDAYLEGALHOLIDAYKBN);
                holidayYoyaku.setTekiyouYmdFrom(ALREADYTEKIYOUYMDFROM);
                holidayYoyaku.setTekiyouYmdTo(ALREADYTEKIYOUYMDTO);
                holidayYoyaku.setHolidayPattern(ALREADYHOLIDAYPATTERN);
                holidayYoyaku.setHolidayPatternParam(ALREADYHOLIDAYPATTERNPARAMNM);
                holidayYoyaku.setHolidayPatternNm(ALREADYHOLIDAYPATTERNNM);
                holidayYoyaku.setHolidayPatternDescription(ALREADYHOLIDAYPATTERNBIKOU);

                baseDomManager.update(holidayGroup);
            }

        }
    }

    @Transactional
    public void deleteTestB0008_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {
            holidayGroup.getHolidayYoyakus().removeAll(holidayGroup.getHolidayYoyakus());

            baseDomManager.update(holidayGroup);
            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestB0009_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void createTestB0009_02(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if( null != holidayGroup ) {

            AT_HolidayYoyaku holidayYoyaku = holidayGroup.getHolidayYoyaku(NEWHOLIDAYCD);
            if ( null == holidayYoyaku ) {
                holidayYoyaku = holidayGroup.createHolidayYoyaku();
                holidayYoyaku.setHolidayCd(NEWHOLIDAYCD);
                holidayYoyaku.setLegalHolidayKbn(ALREADYHOLIDAYLEGALHOLIDAYKBN);
                holidayYoyaku.setTekiyouYmdFrom(ALREADYTEKIYOUYMDFROM);
                holidayYoyaku.setTekiyouYmdTo(ALREADYTEKIYOUYMDTO);
                holidayYoyaku.setHolidayPattern(ALREADYHOLIDAYPATTERN);
                holidayYoyaku.setHolidayPatternParam(ALREADYHOLIDAYPATTERNPARAMNM);
                holidayYoyaku.setHolidayPatternNm(ALREADYHOLIDAYPATTERNNM);
                holidayYoyaku.setHolidayPatternDescription(ALREADYHOLIDAYPATTERNBIKOU);

                baseDomManager.update(holidayGroup);
            }

        }
    }

    @Transactional
    public void deleteTestB0009_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {
            holidayGroup.getHolidayYoyakus().removeAll(holidayGroup.getHolidayYoyakus());

            baseDomManager.update(holidayGroup);
            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestB0010_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestB0010_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestB0011_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestB0011_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestB0012_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestB0012_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestB0013_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestB0013_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestB0014_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestB0014_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestB0015_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestB0015_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestB0016_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestB0016_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestB0017_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestB0017_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestB0018_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestB0018_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestB0019_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void createTestB0019_02(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if( null != holidayGroup ) {

            AT_HolidayYoyaku holidayYoyaku = holidayGroup.getHolidayYoyaku(NEWHOLIDAYCD);
            if ( null == holidayYoyaku ) {
                holidayYoyaku = holidayGroup.createHolidayYoyaku();
                holidayYoyaku.setHolidayCd(NEWHOLIDAYCD);
                holidayYoyaku.setLegalHolidayKbn(ALREADYHOLIDAYLEGALHOLIDAYKBN);
                holidayYoyaku.setTekiyouYmdFrom(ALREADYTEKIYOUYMDFROM);
                holidayYoyaku.setTekiyouYmdTo(ALREADYTEKIYOUYMDTO);
                holidayYoyaku.setHolidayPattern(ALREADYHOLIDAYPATTERN);
                holidayYoyaku.setHolidayPatternParam(ALREADYHOLIDAYPATTERNPARAMNM);
                holidayYoyaku.setHolidayPatternNm(ALREADYHOLIDAYPATTERNNM);
                holidayYoyaku.setHolidayPatternDescription(ALREADYHOLIDAYPATTERNBIKOU);

                baseDomManager.update(holidayGroup);
            }

        }
    }

    @Transactional
    public void deleteTestB0019_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {
            holidayGroup.getHolidayYoyakus().removeAll(holidayGroup.getHolidayYoyakus());

            baseDomManager.update(holidayGroup);
            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestB0020_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestB0020_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestB0021_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void createTestB0021_02(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if( null != holidayGroup ) {

            AT_HolidayYoyaku holidayYoyaku = holidayGroup.getHolidayYoyaku(NEWHOLIDAYCD);
            if ( null == holidayYoyaku ) {
                holidayYoyaku = holidayGroup.createHolidayYoyaku();
                holidayYoyaku.setHolidayCd(NEWHOLIDAYCD);
                holidayYoyaku.setLegalHolidayKbn(ALREADYHOLIDAYLEGALHOLIDAYKBN);
                holidayYoyaku.setTekiyouYmdFrom(ALREADYTEKIYOUYMDFROM);
                holidayYoyaku.setTekiyouYmdTo(ALREADYTEKIYOUYMDTO);
                holidayYoyaku.setHolidayPattern(ALREADYHOLIDAYPATTERN);
                holidayYoyaku.setHolidayPatternParam(ALREADYHOLIDAYPATTERNPARAMNM);
                holidayYoyaku.setHolidayPatternNm(ALREADYHOLIDAYPATTERNNM);
                holidayYoyaku.setHolidayPatternDescription(ALREADYHOLIDAYPATTERNBIKOU);

                baseDomManager.update(holidayGroup);
            }

        }
    }

    @Transactional
    public void deleteTestB0021_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {
            holidayGroup.getHolidayYoyakus().removeAll(holidayGroup.getHolidayYoyakus());

            baseDomManager.update(holidayGroup);
            baseDomManager.delete(holidayGroup);
        }
    }
    @Transactional
    public void createTestB0022_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void createTestB0022_02(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if( null != holidayGroup ) {

            AT_HolidayYoyaku holidayYoyaku = holidayGroup.getHolidayYoyaku(NEWHOLIDAYCD);
            if ( null == holidayYoyaku ) {
                holidayYoyaku = holidayGroup.createHolidayYoyaku();
                holidayYoyaku.setHolidayCd(NEWHOLIDAYCD);
                holidayYoyaku.setLegalHolidayKbn(ALREADYHOLIDAYLEGALHOLIDAYKBN);
                holidayYoyaku.setTekiyouYmdFrom(ALREADYTEKIYOUYMDFROM);
                holidayYoyaku.setTekiyouYmdTo(ALREADYTEKIYOUYMDTO);
                holidayYoyaku.setHolidayPattern(ALREADYHOLIDAYPATTERN);
                holidayYoyaku.setHolidayPatternParam(ALREADYHOLIDAYPATTERNPARAMNM);
                holidayYoyaku.setHolidayPatternNm(ALREADYHOLIDAYPATTERNNM);
                holidayYoyaku.setHolidayPatternDescription(ALREADYHOLIDAYPATTERNBIKOU);

                baseDomManager.update(holidayGroup);
            }

        }
    }

    @Transactional
    public void deleteTestB0022_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {
            holidayGroup.getHolidayYoyakus().removeAll(holidayGroup.getHolidayYoyakus());

            baseDomManager.update(holidayGroup);
            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestB0023_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void createTestB0023_02(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if( null != holidayGroup ) {

            AT_HolidayYoyaku holidayYoyaku = holidayGroup.getHolidayYoyaku(NEWHOLIDAYCD);
            if ( null == holidayYoyaku ) {
                holidayYoyaku = holidayGroup.createHolidayYoyaku();
                holidayYoyaku.setHolidayCd(NEWHOLIDAYCD);
                holidayYoyaku.setLegalHolidayKbn(ALREADYHOLIDAYLEGALHOLIDAYKBN);
                holidayYoyaku.setTekiyouYmdFrom(ALREADYTEKIYOUYMDFROM);
                holidayYoyaku.setTekiyouYmdTo(ALREADYTEKIYOUYMDTO);
                holidayYoyaku.setHolidayPattern(ALREADYHOLIDAYPATTERN);
                holidayYoyaku.setHolidayPatternParam(ALREADYHOLIDAYPATTERNPARAMNM);
                holidayYoyaku.setHolidayPatternNm(ALREADYHOLIDAYPATTERNNM);
                holidayYoyaku.setHolidayPatternDescription(ALREADYHOLIDAYPATTERNBIKOU);

                baseDomManager.update(holidayGroup);
            }

        }
    }

    @Transactional
    public void deleteTestB0023_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {
            holidayGroup.getHolidayYoyakus().removeAll(holidayGroup.getHolidayYoyakus());

            baseDomManager.update(holidayGroup);
            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0001_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0001_02(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if( null != holidayGroup ) {

            AT_HolidayYoyaku holidayYoyaku = holidayGroup.getHolidayYoyaku(NEWHOLIDAYCD);
            if ( null == holidayYoyaku ) {
                holidayYoyaku = holidayGroup.createHolidayYoyaku();
                holidayYoyaku.setHolidayCd(NEWHOLIDAYCD);
                holidayYoyaku.setLegalHolidayKbn(ALREADYHOLIDAYLEGALHOLIDAYKBN);
                holidayYoyaku.setTekiyouYmdFrom(ALREADYTEKIYOUYMDFROM);
                holidayYoyaku.setTekiyouYmdTo(ALREADYTEKIYOUYMDTO);
                holidayYoyaku.setHolidayPattern(ALREADYHOLIDAYPATTERN);
                holidayYoyaku.setHolidayPatternParam(ALREADYHOLIDAYPATTERNPARAMNM);
                holidayYoyaku.setHolidayPatternNm(ALREADYHOLIDAYPATTERNNM);
                holidayYoyaku.setHolidayPatternDescription(ALREADYHOLIDAYPATTERNBIKOU);

                baseDomManager.update(holidayGroup);
            }
        }
    }

    @Transactional
    public void deleteTestL0001_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {
            holidayGroup.getHolidayYoyakus().removeAll(holidayGroup.getHolidayYoyakus());

            baseDomManager.update(holidayGroup);
            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0002_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0002_02(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if( null != holidayGroup ) {

            AT_HolidayYoyaku holidayYoyaku = holidayGroup.getHolidayYoyaku(NEWHOLIDAYCD);
            if ( null == holidayYoyaku ) {
                holidayYoyaku = holidayGroup.createHolidayYoyaku();
                holidayYoyaku.setHolidayCd(NEWHOLIDAYCD);
                holidayYoyaku.setLegalHolidayKbn(ALREADYHOLIDAYLEGALHOLIDAYKBN);
                holidayYoyaku.setTekiyouYmdFrom(ALREADYTEKIYOUYMDFROM);
                holidayYoyaku.setTekiyouYmdTo(ALREADYTEKIYOUYMDTO);
                holidayYoyaku.setHolidayPattern(ALREADYHOLIDAYPATTERN);
                holidayYoyaku.setHolidayPatternParam(ALREADYHOLIDAYPATTERNPARAMNM);
                holidayYoyaku.setHolidayPatternNm(ALREADYHOLIDAYPATTERNNM);
                holidayYoyaku.setHolidayPatternDescription(ALREADYHOLIDAYPATTERNBIKOU);

                baseDomManager.update(holidayGroup);
            }
        }
    }

    @Transactional
    public void deleteTestL0002_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {
            holidayGroup.getHolidayYoyakus().removeAll(holidayGroup.getHolidayYoyakus());

            baseDomManager.update(holidayGroup);
            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0003_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0003_02(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if( null != holidayGroup ) {

            AT_HolidayYoyaku holidayYoyaku = holidayGroup.getHolidayYoyaku(NEWHOLIDAYCD);
            if ( null == holidayYoyaku ) {
                holidayYoyaku = holidayGroup.createHolidayYoyaku();
                holidayYoyaku.setHolidayCd(NEWHOLIDAYCD);
                holidayYoyaku.setLegalHolidayKbn(ALREADYHOLIDAYLEGALHOLIDAYKBN);
                holidayYoyaku.setTekiyouYmdFrom(ALREADYTEKIYOUYMDFROM);
                holidayYoyaku.setTekiyouYmdTo(ALREADYTEKIYOUYMDTO);
                holidayYoyaku.setHolidayPattern(ALREADYHOLIDAYPATTERN);
                holidayYoyaku.setHolidayPatternParam(ALREADYHOLIDAYPATTERNPARAMNM);
                holidayYoyaku.setHolidayPatternNm(ALREADYHOLIDAYPATTERNNM);
                holidayYoyaku.setHolidayPatternDescription(ALREADYHOLIDAYPATTERNBIKOU);

                baseDomManager.update(holidayGroup);
            }
        }
    }

    @Transactional
    public void deleteTestL0003_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {
            holidayGroup.getHolidayYoyakus().removeAll(holidayGroup.getHolidayYoyakus());

            baseDomManager.update(holidayGroup);
            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0004_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0004_02(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if( null != holidayGroup ) {

            AT_HolidayYoyaku holidayYoyaku = holidayGroup.getHolidayYoyaku(NEWHOLIDAYCD);
            if ( null == holidayYoyaku ) {
                holidayYoyaku = holidayGroup.createHolidayYoyaku();
                holidayYoyaku.setHolidayCd(NEWHOLIDAYCD);
                holidayYoyaku.setLegalHolidayKbn(ALREADYHOLIDAYLEGALHOLIDAYKBN);
                holidayYoyaku.setTekiyouYmdFrom(ALREADYTEKIYOUYMDFROM);
                holidayYoyaku.setTekiyouYmdTo(ALREADYTEKIYOUYMDTO);
                holidayYoyaku.setHolidayPattern(ALREADYHOLIDAYPATTERN);
                holidayYoyaku.setHolidayPatternParam(ALREADYHOLIDAYPATTERNPARAMNM);
                holidayYoyaku.setHolidayPatternNm(ALREADYHOLIDAYPATTERNNM);
                holidayYoyaku.setHolidayPatternDescription(ALREADYHOLIDAYPATTERNBIKOU);

                baseDomManager.update(holidayGroup);
            }
        }
    }

    @Transactional
    public void deleteTestL0004_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {
            holidayGroup.getHolidayYoyakus().removeAll(holidayGroup.getHolidayYoyakus());

            baseDomManager.update(holidayGroup);
            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0005_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0005_02(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if( null != holidayGroup ) {

            AT_HolidayYoyaku holidayYoyaku = holidayGroup.getHolidayYoyaku(NEWHOLIDAYCD);
            if ( null == holidayYoyaku ) {
                holidayYoyaku = holidayGroup.createHolidayYoyaku();
                holidayYoyaku.setHolidayCd(NEWHOLIDAYCD);
                holidayYoyaku.setLegalHolidayKbn(ALREADYHOLIDAYLEGALHOLIDAYKBN);
                holidayYoyaku.setTekiyouYmdFrom(ALREADYTEKIYOUYMDFROM);
                holidayYoyaku.setTekiyouYmdTo(ALREADYTEKIYOUYMDTO);
                holidayYoyaku.setHolidayPattern(ALREADYHOLIDAYPATTERN);
                holidayYoyaku.setHolidayPatternParam(ALREADYHOLIDAYPATTERNPARAMNM);
                holidayYoyaku.setHolidayPatternNm(ALREADYHOLIDAYPATTERNNM);
                holidayYoyaku.setHolidayPatternDescription(ALREADYHOLIDAYPATTERNBIKOU);

                baseDomManager.update(holidayGroup);
            }
        }
    }

    @Transactional
    public void deleteTestL0005_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {
            holidayGroup.getHolidayYoyakus().removeAll(holidayGroup.getHolidayYoyakus());

            baseDomManager.update(holidayGroup);
            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0006_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0006_02(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if( null != holidayGroup ) {

            AT_HolidayYoyaku holidayYoyaku = holidayGroup.getHolidayYoyaku(NEWHOLIDAYCD);
            if ( null == holidayYoyaku ) {
                holidayYoyaku = holidayGroup.createHolidayYoyaku();
                holidayYoyaku.setHolidayCd(NEWHOLIDAYCD);
                holidayYoyaku.setLegalHolidayKbn(ALREADYHOLIDAYLEGALHOLIDAYKBN);
                holidayYoyaku.setTekiyouYmdFrom(ALREADYTEKIYOUYMDFROM);
                holidayYoyaku.setTekiyouYmdTo(ALREADYTEKIYOUYMDTO);
                holidayYoyaku.setHolidayPattern(ALREADYHOLIDAYPATTERN);
                holidayYoyaku.setHolidayPatternParam(ALREADYHOLIDAYPATTERNPARAMNM);
                holidayYoyaku.setHolidayPatternNm(ALREADYHOLIDAYPATTERNNM);
                holidayYoyaku.setHolidayPatternDescription(ALREADYHOLIDAYPATTERNBIKOU);

                baseDomManager.update(holidayGroup);
            }
        }
    }

    @Transactional
    public void deleteTestL0006_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {
            holidayGroup.getHolidayYoyakus().removeAll(holidayGroup.getHolidayYoyakus());

            baseDomManager.update(holidayGroup);
            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0007_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0007_02(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if( null != holidayGroup ) {

            AT_HolidayYoyaku holidayYoyaku = holidayGroup.getHolidayYoyaku(NEWHOLIDAYCD);
            if ( null == holidayYoyaku ) {
                holidayYoyaku = holidayGroup.createHolidayYoyaku();
                holidayYoyaku.setHolidayCd(NEWHOLIDAYCD);
                holidayYoyaku.setLegalHolidayKbn(ALREADYHOLIDAYLEGALHOLIDAYKBN);
                holidayYoyaku.setTekiyouYmdFrom(ALREADYTEKIYOUYMDFROM);
                holidayYoyaku.setTekiyouYmdTo(ALREADYTEKIYOUYMDTO);
                holidayYoyaku.setHolidayPattern(ALREADYHOLIDAYPATTERN);
                holidayYoyaku.setHolidayPatternParam(ALREADYHOLIDAYPATTERNPARAMNM);
                holidayYoyaku.setHolidayPatternNm(ALREADYHOLIDAYPATTERNNM);
                holidayYoyaku.setHolidayPatternDescription(ALREADYHOLIDAYPATTERNBIKOU);

                baseDomManager.update(holidayGroup);
            }
        }
    }

    @Transactional
    public void deleteTestL0007_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {
            holidayGroup.getHolidayYoyakus().removeAll(holidayGroup.getHolidayYoyakus());

            baseDomManager.update(holidayGroup);
            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0008_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0008_02(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if( null != holidayGroup ) {

            AT_HolidayYoyaku holidayYoyaku = holidayGroup.getHolidayYoyaku(NEWHOLIDAYCD);
            if ( null == holidayYoyaku ) {
                holidayYoyaku = holidayGroup.createHolidayYoyaku();
                holidayYoyaku.setHolidayCd(NEWHOLIDAYCD);
                holidayYoyaku.setLegalHolidayKbn(ALREADYHOLIDAYLEGALHOLIDAYKBN);
                holidayYoyaku.setTekiyouYmdFrom(ALREADYTEKIYOUYMDFROM);
                holidayYoyaku.setTekiyouYmdTo(ALREADYTEKIYOUYMDTO);
                holidayYoyaku.setHolidayPattern(ALREADYHOLIDAYPATTERN);
                holidayYoyaku.setHolidayPatternParam(ALREADYHOLIDAYPATTERNPARAMNM);
                holidayYoyaku.setHolidayPatternNm(ALREADYHOLIDAYPATTERNNM);
                holidayYoyaku.setHolidayPatternDescription(ALREADYHOLIDAYPATTERNBIKOU);

                baseDomManager.update(holidayGroup);
            }
        }
    }

    @Transactional
    public void deleteTestL0008_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {
            holidayGroup.getHolidayYoyakus().removeAll(holidayGroup.getHolidayYoyakus());

            baseDomManager.update(holidayGroup);
            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0009_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0009_02(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if( null != holidayGroup ) {

            AT_HolidayYoyaku holidayYoyaku = holidayGroup.getHolidayYoyaku(NEWHOLIDAYCD);
            if ( null == holidayYoyaku ) {
                holidayYoyaku = holidayGroup.createHolidayYoyaku();
                holidayYoyaku.setHolidayCd(NEWHOLIDAYCD);
                holidayYoyaku.setLegalHolidayKbn(ALREADYHOLIDAYLEGALHOLIDAYKBN);
                holidayYoyaku.setTekiyouYmdFrom(ALREADYTEKIYOUYMDFROM);
                holidayYoyaku.setTekiyouYmdTo(ALREADYTEKIYOUYMDTO);
                holidayYoyaku.setHolidayPattern(ALREADYHOLIDAYPATTERN);
                holidayYoyaku.setHolidayPatternParam(ALREADYHOLIDAYPATTERNPARAMNM);
                holidayYoyaku.setHolidayPatternNm(ALREADYHOLIDAYPATTERNNM);
                holidayYoyaku.setHolidayPatternDescription(ALREADYHOLIDAYPATTERNBIKOU);

                baseDomManager.update(holidayGroup);
            }
        }
    }

    @Transactional
    public void deleteTestL0009_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {
            holidayGroup.getHolidayYoyakus().removeAll(holidayGroup.getHolidayYoyakus());

            baseDomManager.update(holidayGroup);
            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0010_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestL0010_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {
            holidayGroup.getHolidayYoyakus().removeAll(holidayGroup.getHolidayYoyakus());

            baseDomManager.update(holidayGroup);
            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0011_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0011_02(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if( null != holidayGroup ) {

            AT_HolidayYoyaku holidayYoyaku = holidayGroup.getHolidayYoyaku(NEWHOLIDAYCD);
            if ( null == holidayYoyaku ) {
                holidayYoyaku = holidayGroup.createHolidayYoyaku();
                holidayYoyaku.setHolidayCd(NEWHOLIDAYCD);
                holidayYoyaku.setLegalHolidayKbn(ALREADYHOLIDAYLEGALHOLIDAYKBN);
                holidayYoyaku.setTekiyouYmdFrom(ALREADYTEKIYOUYMDFROM);
                holidayYoyaku.setTekiyouYmdTo(ALREADYTEKIYOUYMDTO);
                holidayYoyaku.setHolidayPattern(ALREADYHOLIDAYPATTERN);
                holidayYoyaku.setHolidayPatternParam(ALREADYHOLIDAYPATTERNPARAMNM);
                holidayYoyaku.setHolidayPatternNm(ALREADYHOLIDAYPATTERNNM);
                holidayYoyaku.setHolidayPatternDescription(ALREADYHOLIDAYPATTERNBIKOU);

                baseDomManager.update(holidayGroup);
            }
        }
    }

    @Transactional
    public void deleteTestL0011_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {
            holidayGroup.getHolidayYoyakus().removeAll(holidayGroup.getHolidayYoyakus());

            baseDomManager.update(holidayGroup);
            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0012_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0012_02(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if( null != holidayGroup ) {

            AT_HolidayYoyaku holidayYoyaku = holidayGroup.getHolidayYoyaku(NEWHOLIDAYCD);
            if ( null == holidayYoyaku ) {
                holidayYoyaku = holidayGroup.createHolidayYoyaku();
                holidayYoyaku.setHolidayCd(NEWHOLIDAYCD);
                holidayYoyaku.setLegalHolidayKbn(ALREADYHOLIDAYLEGALHOLIDAYKBN);
                holidayYoyaku.setTekiyouYmdFrom(ALREADYTEKIYOUYMDFROM);
                holidayYoyaku.setTekiyouYmdTo(ALREADYTEKIYOUYMDTO);
                holidayYoyaku.setHolidayPattern(ALREADYHOLIDAYPATTERN);
                holidayYoyaku.setHolidayPatternParam(ALREADYHOLIDAYPATTERNPARAMNM);
                holidayYoyaku.setHolidayPatternNm(ALREADYHOLIDAYPATTERNNM);
                holidayYoyaku.setHolidayPatternDescription(ALREADYHOLIDAYPATTERNBIKOU);

                baseDomManager.update(holidayGroup);
            }
        }
    }

    @Transactional
    public void createTestL0013_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0013_02(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if( null != holidayGroup ) {

            AT_HolidayYoyaku holidayYoyaku = holidayGroup.getHolidayYoyaku(NEWHOLIDAYCD);
            if ( null == holidayYoyaku ) {
                holidayYoyaku = holidayGroup.createHolidayYoyaku();
                holidayYoyaku.setHolidayCd(NEWHOLIDAYCD);
                holidayYoyaku.setLegalHolidayKbn(ALREADYHOLIDAYLEGALHOLIDAYKBN);
                holidayYoyaku.setTekiyouYmdFrom(ALREADYTEKIYOUYMDFROM);
                holidayYoyaku.setTekiyouYmdTo(ALREADYTEKIYOUYMDTO);
                holidayYoyaku.setHolidayPattern(ALREADYHOLIDAYPATTERN);
                holidayYoyaku.setHolidayPatternParam(ALREADYHOLIDAYPATTERNPARAMNM);
                holidayYoyaku.setHolidayPatternNm(ALREADYHOLIDAYPATTERNNM);
                holidayYoyaku.setHolidayPatternDescription(ALREADYHOLIDAYPATTERNBIKOU);

                baseDomManager.update(holidayGroup);
            }
        }
    }

    @Transactional
    public void createTestL0014_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0014_02(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if( null != holidayGroup ) {

            AT_HolidayYoyaku holidayYoyaku = holidayGroup.getHolidayYoyaku(NEWHOLIDAYCD);
            if ( null == holidayYoyaku ) {
                holidayYoyaku = holidayGroup.createHolidayYoyaku();
                holidayYoyaku.setHolidayCd(NEWHOLIDAYCD);
                holidayYoyaku.setLegalHolidayKbn(ALREADYHOLIDAYLEGALHOLIDAYKBN);
                holidayYoyaku.setTekiyouYmdFrom(ALREADYTEKIYOUYMDFROM);
                holidayYoyaku.setTekiyouYmdTo(ALREADYTEKIYOUYMDTO);
                holidayYoyaku.setHolidayPattern(ALREADYHOLIDAYPATTERN);
                holidayYoyaku.setHolidayPatternParam(ALREADYHOLIDAYPATTERNPARAMNM);
                holidayYoyaku.setHolidayPatternNm(ALREADYHOLIDAYPATTERNNM);
                holidayYoyaku.setHolidayPatternDescription(ALREADYHOLIDAYPATTERNBIKOU);

                baseDomManager.update(holidayGroup);
            }
        }
    }

    @Transactional
    public void createTestL0015_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0015_02(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if( null != holidayGroup ) {

            AT_HolidayYoyaku holidayYoyaku = holidayGroup.getHolidayYoyaku(NEWHOLIDAYCD);
            if ( null == holidayYoyaku ) {
                holidayYoyaku = holidayGroup.createHolidayYoyaku();
                holidayYoyaku.setHolidayCd(NEWHOLIDAYCD);
                holidayYoyaku.setLegalHolidayKbn(ALREADYHOLIDAYLEGALHOLIDAYKBN);
                holidayYoyaku.setTekiyouYmdFrom(ALREADYTEKIYOUYMDFROM);
                holidayYoyaku.setTekiyouYmdTo(ALREADYTEKIYOUYMDTO);
                holidayYoyaku.setHolidayPattern(ALREADYHOLIDAYPATTERN);
                holidayYoyaku.setHolidayPatternParam(ALREADYHOLIDAYPATTERNPARAMNM);
                holidayYoyaku.setHolidayPatternNm(ALREADYHOLIDAYPATTERNNM);
                holidayYoyaku.setHolidayPatternDescription(ALREADYHOLIDAYPATTERNBIKOU);

                baseDomManager.update(holidayGroup);
            }
        }
    }

    @Transactional
    public void createTestL0016_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0016_02(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if( null != holidayGroup ) {

            AT_HolidayYoyaku holidayYoyaku = holidayGroup.getHolidayYoyaku(NEWHOLIDAYCD);
            if ( null == holidayYoyaku ) {
                holidayYoyaku = holidayGroup.createHolidayYoyaku();
                holidayYoyaku.setHolidayCd(NEWHOLIDAYCD);
                holidayYoyaku.setLegalHolidayKbn(ALREADYHOLIDAYLEGALHOLIDAYKBN);
                holidayYoyaku.setTekiyouYmdFrom(ALREADYTEKIYOUYMDFROM);
                holidayYoyaku.setTekiyouYmdTo(ALREADYTEKIYOUYMDTO);
                holidayYoyaku.setHolidayPattern(ALREADYHOLIDAYPATTERN);
                holidayYoyaku.setHolidayPatternParam(ALREADYHOLIDAYPATTERNPARAMNM);
                holidayYoyaku.setHolidayPatternNm(ALREADYHOLIDAYPATTERNNM);
                holidayYoyaku.setHolidayPatternDescription(ALREADYHOLIDAYPATTERNBIKOU);

                baseDomManager.update(holidayGroup);
            }
        }
    }

    @Transactional
    public void createTestL0017_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0017_02(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if( null != holidayGroup ) {

            AT_HolidayYoyaku holidayYoyaku = holidayGroup.getHolidayYoyaku(NEWHOLIDAYCD);
            if ( null == holidayYoyaku ) {
                holidayYoyaku = holidayGroup.createHolidayYoyaku();
                holidayYoyaku.setHolidayCd(NEWHOLIDAYCD);
                holidayYoyaku.setLegalHolidayKbn(ALREADYHOLIDAYLEGALHOLIDAYKBN);
                holidayYoyaku.setTekiyouYmdFrom(ALREADYTEKIYOUYMDFROM);
                holidayYoyaku.setTekiyouYmdTo(ALREADYTEKIYOUYMDTO);
                holidayYoyaku.setHolidayPattern(ALREADYHOLIDAYPATTERN);
                holidayYoyaku.setHolidayPatternParam(ALREADYHOLIDAYPATTERNPARAMNM);
                holidayYoyaku.setHolidayPatternNm(ALREADYHOLIDAYPATTERNNM);
                holidayYoyaku.setHolidayPatternDescription(ALREADYHOLIDAYPATTERNBIKOU);

                baseDomManager.update(holidayGroup);
            }
        }
    }

    @Transactional
    public void createTestL0018_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0018_02(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if( null != holidayGroup ) {

            AT_HolidayYoyaku holidayYoyaku = holidayGroup.getHolidayYoyaku(NEWHOLIDAYCD);
            if ( null == holidayYoyaku ) {
                holidayYoyaku = holidayGroup.createHolidayYoyaku();
                holidayYoyaku.setHolidayCd(NEWHOLIDAYCD);
                holidayYoyaku.setLegalHolidayKbn(ALREADYHOLIDAYLEGALHOLIDAYKBN);
                holidayYoyaku.setTekiyouYmdFrom(ALREADYTEKIYOUYMDFROM);
                holidayYoyaku.setTekiyouYmdTo(ALREADYTEKIYOUYMDTO);
                holidayYoyaku.setHolidayPattern(ALREADYHOLIDAYPATTERN);
                holidayYoyaku.setHolidayPatternParam(ALREADYHOLIDAYPATTERNPARAMNM);
                holidayYoyaku.setHolidayPatternNm(ALREADYHOLIDAYPATTERNNM);
                holidayYoyaku.setHolidayPatternDescription(ALREADYHOLIDAYPATTERNBIKOU);

                baseDomManager.update(holidayGroup);
            }
        }
    }

    @Transactional
    public void createTestL0019_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0019_02(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if( null != holidayGroup ) {

            AT_HolidayYoyaku holidayYoyaku = holidayGroup.getHolidayYoyaku(NEWHOLIDAYCD);
            if ( null == holidayYoyaku ) {
                holidayYoyaku = holidayGroup.createHolidayYoyaku();
                holidayYoyaku.setHolidayCd(NEWHOLIDAYCD);
                holidayYoyaku.setLegalHolidayKbn(ALREADYHOLIDAYLEGALHOLIDAYKBN);
                holidayYoyaku.setTekiyouYmdFrom(ALREADYTEKIYOUYMDFROM);
                holidayYoyaku.setTekiyouYmdTo(ALREADYTEKIYOUYMDTO);
                holidayYoyaku.setHolidayPattern(ALREADYHOLIDAYPATTERN);
                holidayYoyaku.setHolidayPatternParam(ALREADYHOLIDAYPATTERNPARAMNM);
                holidayYoyaku.setHolidayPatternNm(ALREADYHOLIDAYPATTERNNM);
                holidayYoyaku.setHolidayPatternDescription(ALREADYHOLIDAYPATTERNBIKOU);

                baseDomManager.update(holidayGroup);
            }
        }
    }

    @Transactional
    public void createTestL0020_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0020_02(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if( null != holidayGroup ) {

            AT_HolidayYoyaku holidayYoyaku = holidayGroup.getHolidayYoyaku(NEWHOLIDAYCD);
            if ( null == holidayYoyaku ) {
                holidayYoyaku = holidayGroup.createHolidayYoyaku();
                holidayYoyaku.setHolidayCd(NEWHOLIDAYCD);
                holidayYoyaku.setLegalHolidayKbn(ALREADYHOLIDAYLEGALHOLIDAYKBN);
                holidayYoyaku.setTekiyouYmdFrom(ALREADYTEKIYOUYMDFROM);
                holidayYoyaku.setTekiyouYmdTo(ALREADYTEKIYOUYMDTO);
                holidayYoyaku.setHolidayPattern(ALREADYHOLIDAYPATTERN);
                holidayYoyaku.setHolidayPatternParam(ALREADYHOLIDAYPATTERNPARAMNM);
                holidayYoyaku.setHolidayPatternNm(ALREADYHOLIDAYPATTERNNM);
                holidayYoyaku.setHolidayPatternDescription(ALREADYHOLIDAYPATTERNBIKOU);

                baseDomManager.update(holidayGroup);
            }
        }
    }

    @Transactional
    public void createTestL0021_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0022_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALREADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0022_02(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if( null != holidayGroup ) {

            AT_HolidayYoyaku holidayYoyaku = holidayGroup.getHolidayYoyaku(NEWHOLIDAYCD);
            if ( null == holidayYoyaku ) {
                holidayYoyaku = holidayGroup.createHolidayYoyaku();
                holidayYoyaku.setHolidayCd(NEWHOLIDAYCD);
                holidayYoyaku.setLegalHolidayKbn(ALREADYHOLIDAYLEGALHOLIDAYKBN);
                holidayYoyaku.setTekiyouYmdFrom(ALREADYTEKIYOUYMDFROM);
                holidayYoyaku.setTekiyouYmdTo(ALREADYTEKIYOUYMDTO);
                holidayYoyaku.setHolidayPattern(ALREADYHOLIDAYPATTERN);
                holidayYoyaku.setHolidayPatternParam(ALREADYHOLIDAYPATTERNPARAMNM);
                holidayYoyaku.setHolidayPatternNm(ALREADYHOLIDAYPATTERNNM);
                holidayYoyaku.setHolidayPatternDescription(ALREADYHOLIDAYPATTERNBIKOU);

                baseDomManager.update(holidayGroup);
            }
        }
    }

    public String getSeirekiWareki(){

        SeirekiWarekiKbn kbn = BizDateConfig.getInstance().getSeirekiWarekiKbn();

        String sSeirekiWareki = "";
        switch (kbn) {
            case SEIREKI:
                sSeirekiWareki = "19910529";
                break;
            case WAREKI_KANJI:
            case WAREKI_SYMBOL:
                sSeirekiWareki = "030529";
                break;
            case WAREKI_INPUT:
                sSeirekiWareki = "H030529";
                break;
            default:
                throw new RuntimeException("西暦和暦区分が不正です。 設定値 = " + kbn);
        }

        return sSeirekiWareki;
    }
}
