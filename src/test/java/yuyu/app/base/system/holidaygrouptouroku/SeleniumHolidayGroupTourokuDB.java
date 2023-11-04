package yuyu.app.base.system.holidaygrouptouroku;

import static yuyu.app.base.system.holidaygrouptouroku.SeleniumHolidayGroupTourokuConstants.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AT_HolidayGroup;
import yuyu.def.db.entity.AT_KadouTimeGroup;

public class SeleniumHolidayGroupTourokuDB {

    @Inject
    private BaseDomManager baseDomManager;

    @Transactional
    public void createTestB0004_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestB0004_01(){

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
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

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
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

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
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestB0007_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

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
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestB0008_01(){

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
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestB0017_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {
            holidayGroup.setKousinsyaId("JUnit");

            baseDomManager.update(holidayGroup);
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
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void createTestB0018_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
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
    public void deleteTestB0018_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            baseDomManager.delete(kadouTimeGroup);
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
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

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
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestB0021_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

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
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestB0023_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestB0024_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestB0024_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestB0025_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {
            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestB0025_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestL0001_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(NEWHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestL0002_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(NEWHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestL0003_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(NEWHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestL0004_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(NEWHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestL0005_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(NEWHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

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
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestL0006_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

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
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestL0007_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

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
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestL0008_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

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
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestL0009_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

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
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestL0010_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

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
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestL0011_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

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
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestL0012_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
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
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestL0013_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
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
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestL0014_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestL0015_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
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
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestL0016_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
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
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
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
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
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
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
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
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
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
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

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
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0023_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {

            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0024_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {

            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0025_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {

            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0027_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {

            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0028_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {

            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestL0028_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0029_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {

            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestL0029_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0030_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {

            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestL0030_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0031_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {

            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestL0031_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0032_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {

            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestL0032_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0033_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {

            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestL0033_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0034_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {

            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestL0034_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0035_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {

            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestL0035_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0036_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {

            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestL0036_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestL0037_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
        }
    }

    @Transactional
    public void createTestL0038_01(){

        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null == holidayGroup ) {

            holidayGroup = new AT_HolidayGroup();
            holidayGroup.setHolidayGroupCd(ALREADYHOLIDAYGROUPCD);
            holidayGroup.setHolidayGroupNm(ALREADYHOLIDAYGROUPNM);
            holidayGroup.setHolidayGroupDescription(ALREADYHOLIDAYGROUPBIKOU);
            holidayGroup.setSysSiyouKbn(ALERADYHOLIDAYGROUPSYSSIYOUKBN);

            baseDomManager.insert(holidayGroup);
        }
    }

    @Transactional
    public void deleteTestL0038_01(){

        baseDomManager.clear();
        AT_HolidayGroup holidayGroup = baseDomManager.getHolidayGroup(ALREADYHOLIDAYGROUPCD);
        if ( null != holidayGroup ) {

            baseDomManager.delete(holidayGroup);
        }
    }
}
