package yuyu.app.base.system.usergrouptouroku;

import static yuyu.app.base.system.usergrouptouroku.SeleniumUserGroupTourokuConstants.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AM_UserGroup;

public class SeleniumUserGroupTourokuDB {

    @Inject
    private BaseDomManager baseDomManager;

    @Transactional
    public void createTestB0005_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {
            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestB0005_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestB0006_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {
            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestB0006_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestB0008_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {
            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestB0008_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestB0018_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {
            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestB0018_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestB0019_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {
            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestB0019_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestB0020_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {
            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestB0020_01(){

        baseDomManager.clear();
        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestB0022_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {
            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestB0022_01(){

        baseDomManager.clear();
        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestB0023_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {
            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestB0023_01(){

        baseDomManager.clear();
        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestB0024_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {
            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestB0024_01(){

        baseDomManager.clear();
        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void deleteTestL0001_01(){

        baseDomManager.clear();
        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void deleteTestL0002_01(){

        baseDomManager.clear();
        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void deleteTestL0003_01(){

        baseDomManager.clear();
        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void deleteTestL0004_01(){

        baseDomManager.clear();
        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void deleteTestL0005_01(){

        baseDomManager.clear();
        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void deleteTestL0006_01(){

        baseDomManager.clear();
        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void deleteTestL0007_01(){

        baseDomManager.clear();
        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestL0008_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestL0008_01(){

        baseDomManager.clear();
        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestL0009_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestL0009_01(){

        baseDomManager.clear();
        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestL0010_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestL0010_01(){

        baseDomManager.clear();
        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestL0011_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestL0011_01(){

        baseDomManager.clear();
        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestL0012_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestL0012_01(){

        baseDomManager.clear();
        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestL0013_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestL0013_01(){

        baseDomManager.clear();
        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestL0014_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestL0014_01(){

        baseDomManager.clear();
        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestL0015_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestL0015_01(){

        baseDomManager.clear();
        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestL0016_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestL0016_01(){

        baseDomManager.clear();
        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void deleteTestL0017_01(){

        baseDomManager.clear();
        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestL0018_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestL0018_01(){

        baseDomManager.clear();
        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestL0019_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void createTestL0020_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void createTestL0021_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void createTestL0022_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void createTestL0023_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void createTestL0024_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void createTestL0025_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void createTestL0026_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void createTestL0027_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void createTestL0029_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void createTestL0030_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestL0030_01(){

        baseDomManager.clear();
        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestL0031_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestL0031_01(){

        baseDomManager.clear();
        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestL0032_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestL0032_01(){

        baseDomManager.clear();
        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestL0033_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestL0033_01(){

        baseDomManager.clear();
        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestL0034_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestL0034_01(){

        baseDomManager.clear();
        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestL0035_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestL0035_01(){

        baseDomManager.clear();
        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestL0036_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestL0036_01(){

        baseDomManager.clear();
        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestL0037_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestL0037_01(){

        baseDomManager.clear();
        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestL0038_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestL0038_01(){

        baseDomManager.clear();
        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void deleteTestL0039_01(){

        baseDomManager.clear();
        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestL0040_01(){

        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestL0040_01(){

        baseDomManager.clear();
        AM_UserGroup userGroup = baseDomManager.getUserGroup(ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }
}
