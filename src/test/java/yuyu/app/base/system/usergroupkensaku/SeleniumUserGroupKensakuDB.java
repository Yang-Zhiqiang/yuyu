package yuyu.app.base.system.usergroupkensaku;

import static yuyu.app.base.system.usergroupkensaku.SeleniumUserGroupKensakuConstants.*;

import java.util.Arrays;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AM_UserGroup;

public class SeleniumUserGroupKensakuDB {

    @Inject
    private BaseDomManager baseDomManager;

    @Transactional
    public void createTestA0002_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 9; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(A_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null == userGroup ) {

                userGroup = new AM_UserGroup();
                userGroup.setUserGroupCd(A_ALREADYUSERGROUPCD + userGroupCdNo);
                userGroup.setUserGroupNm(A_ALREADYUSERGROUPNM + ConvertUtil.toZenNumeric(userGroupCdNo));
                userGroup.setUserGroupSetumei(A_ALREADYUSERGROUPSETUMEI + ConvertUtil.toZenNumeric(userGroupCdNo));

                baseDomManager.insert(userGroup);
            }
        }
    }

    @Transactional
    public void deleteTestA0002_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 9; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(A_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null != userGroup ) {

                baseDomManager.delete(userGroup);
            }
        }
    }

    @Transactional
    public void createTestA0004_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 10; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(A_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null == userGroup ) {

                userGroup = new AM_UserGroup();
                userGroup.setUserGroupCd(A_ALREADYUSERGROUPCD + userGroupCdNo);
                userGroup.setUserGroupNm(A_ALREADYUSERGROUPNM + ConvertUtil.toZenNumeric(userGroupCdNo));
                userGroup.setUserGroupSetumei(A_ALREADYUSERGROUPSETUMEI + ConvertUtil.toZenNumeric(userGroupCdNo));

                baseDomManager.insert(userGroup);
            }
        }
    }

    @Transactional
    public void deleteTestA0004_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 10; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(A_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null != userGroup ) {

                baseDomManager.delete(userGroup);
            }
        }
    }

    @Transactional
    public void createTestA0005_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 11; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(A_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null == userGroup ) {

                userGroup = new AM_UserGroup();
                userGroup.setUserGroupCd(A_ALREADYUSERGROUPCD + userGroupCdNo);
                userGroup.setUserGroupNm(A_ALREADYUSERGROUPNM + ConvertUtil.toZenNumeric(userGroupCdNo));
                userGroup.setUserGroupSetumei(A_ALREADYUSERGROUPSETUMEI + ConvertUtil.toZenNumeric(userGroupCdNo));

                baseDomManager.insert(userGroup);
            }
        }
    }

    @Transactional
    public void deleteTestA0005_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 11; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(A_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null != userGroup ) {

                baseDomManager.delete(userGroup);
            }
        }
    }

    @Transactional
    public void createTestB0003_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 350; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(B_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null == userGroup ) {

                userGroup = new AM_UserGroup();
                userGroup.setUserGroupCd(B_ALREADYUSERGROUPCD + userGroupCdNo);
                userGroup.setUserGroupNm(B_ALREADYUSERGROUPNM + ConvertUtil.toZenNumeric(userGroupCdNo));
                userGroup.setUserGroupSetumei(B_ALREADYUSERGROUPSETUMEI + ConvertUtil.toZenNumeric(userGroupCdNo));

                baseDomManager.insert(userGroup);
            }
        }
    }

    @Transactional
    public void deleteTestB0003_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 350; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(B_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null != userGroup ) {

                baseDomManager.delete(userGroup);
            }
        }
    }

    @Transactional
    public void createTestB0005_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 350; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(B_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null == userGroup ) {

                userGroup = new AM_UserGroup();
                userGroup.setUserGroupCd(B_ALREADYUSERGROUPCD + userGroupCdNo);
                userGroup.setUserGroupNm(B_ALREADYUSERGROUPNM + ConvertUtil.toZenNumeric(userGroupCdNo));
                userGroup.setUserGroupSetumei(B_ALREADYUSERGROUPSETUMEI + ConvertUtil.toZenNumeric(userGroupCdNo));

                baseDomManager.insert(userGroup);
            }
        }
    }

    @Transactional
    public void deleteTestB0005_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 350; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(B_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null != userGroup ) {

                baseDomManager.delete(userGroup);
            }
        }
    }

    @Transactional
    public void createTestB0006_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 350; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(B_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null == userGroup ) {

                userGroup = new AM_UserGroup();
                userGroup.setUserGroupCd(B_ALREADYUSERGROUPCD + userGroupCdNo);
                userGroup.setUserGroupNm(B_ALREADYUSERGROUPNM + ConvertUtil.toZenNumeric(userGroupCdNo));
                userGroup.setUserGroupSetumei(B_ALREADYUSERGROUPSETUMEI + ConvertUtil.toZenNumeric(userGroupCdNo));

                baseDomManager.insert(userGroup);
            }
        }
    }

    @Transactional
    public void deleteTestB0006_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 350; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(B_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null != userGroup ) {

                baseDomManager.delete(userGroup);
            }
        }
    }

    @Transactional
    public void createTestB0007_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 350; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(B_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null == userGroup ) {

                userGroup = new AM_UserGroup();
                userGroup.setUserGroupCd(B_ALREADYUSERGROUPCD + userGroupCdNo);
                userGroup.setUserGroupNm(B_ALREADYUSERGROUPNM + ConvertUtil.toZenNumeric(userGroupCdNo));
                userGroup.setUserGroupSetumei(B_ALREADYUSERGROUPSETUMEI + ConvertUtil.toZenNumeric(userGroupCdNo));

                baseDomManager.insert(userGroup);
            }
        }
    }

    @Transactional
    public void deleteTestB0007_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 350; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);
            userGroup = baseDomManager.getUserGroup(B_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null != userGroup ) {

                baseDomManager.delete(userGroup);
            }
        }
    }

    @Transactional
    public void createTestB0008_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 350; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(B_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null == userGroup ) {

                userGroup = new AM_UserGroup();
                userGroup.setUserGroupCd(B_ALREADYUSERGROUPCD + userGroupCdNo);
                userGroup.setUserGroupNm(B_ALREADYUSERGROUPNM + ConvertUtil.toZenNumeric(userGroupCdNo));
                userGroup.setUserGroupSetumei(B_ALREADYUSERGROUPSETUMEI + ConvertUtil.toZenNumeric(userGroupCdNo));

                baseDomManager.insert(userGroup);
            }
        }
    }

    @Transactional
    public void deleteTestB0008_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 350; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(B_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null != userGroup ) {

                baseDomManager.delete(userGroup);
            }
        }
    }

    @Transactional
    public void createTestB0009_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 350; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(B_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null == userGroup ) {

                userGroup = new AM_UserGroup();
                userGroup.setUserGroupCd(B_ALREADYUSERGROUPCD + userGroupCdNo);
                userGroup.setUserGroupNm(B_ALREADYUSERGROUPNM + ConvertUtil.toZenNumeric(userGroupCdNo));
                userGroup.setUserGroupSetumei(B_ALREADYUSERGROUPSETUMEI + ConvertUtil.toZenNumeric(userGroupCdNo));

                baseDomManager.insert(userGroup);
            }
        }
    }

    @Transactional
    public void deleteTestB0009_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 350; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(B_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null != userGroup ) {

                baseDomManager.delete(userGroup);
            }
        }
    }

    @Transactional
    public void createTestB0010_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 350; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(B_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null == userGroup ) {

                userGroup = new AM_UserGroup();
                userGroup.setUserGroupCd(B_ALREADYUSERGROUPCD + userGroupCdNo);
                userGroup.setUserGroupNm(B_ALREADYUSERGROUPNM + ConvertUtil.toZenNumeric(userGroupCdNo));
                userGroup.setUserGroupSetumei(B_ALREADYUSERGROUPSETUMEI + ConvertUtil.toZenNumeric(userGroupCdNo));

                baseDomManager.insert(userGroup);
            }
        }
    }

    @Transactional
    public void deleteTestB0010_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 350; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(B_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null != userGroup ) {

                baseDomManager.delete(userGroup);
            }
        }
    }

    @Transactional
    public void createTestB0011_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 350; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(B_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null == userGroup ) {

                userGroup = new AM_UserGroup();
                userGroup.setUserGroupCd(B_ALREADYUSERGROUPCD + userGroupCdNo);
                userGroup.setUserGroupNm(B_ALREADYUSERGROUPNM + ConvertUtil.toZenNumeric(userGroupCdNo));
                userGroup.setUserGroupSetumei(B_ALREADYUSERGROUPSETUMEI + ConvertUtil.toZenNumeric(userGroupCdNo));

                baseDomManager.insert(userGroup);
            }
        }
    }

    @Transactional
    public void deleteTestB0011_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 350; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(B_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null != userGroup ) {

                baseDomManager.delete(userGroup);
            }
        }
    }

    @Transactional
    public void createTestC0002_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 350; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(C_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null == userGroup ) {

                userGroup = new AM_UserGroup();
                userGroup.setUserGroupCd(C_ALREADYUSERGROUPCD + userGroupCdNo);
                userGroup.setUserGroupNm(C_ALREADYUSERGROUPNM + ConvertUtil.toZenNumeric(userGroupCdNo));
                userGroup.setUserGroupSetumei(C_ALREADYUSERGROUPSETUMEI + ConvertUtil.toZenNumeric(userGroupCdNo));

                baseDomManager.insert(userGroup);
            }
        }
    }

    @Transactional
    public void deleteTestC0002_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 350; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(C_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null != userGroup ) {

                baseDomManager.delete(userGroup);
            }
        }
    }

    @Transactional
    public void createTestC0003_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 350; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(C_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null == userGroup ) {

                userGroup = new AM_UserGroup();
                userGroup.setUserGroupCd(C_ALREADYUSERGROUPCD + userGroupCdNo);
                userGroup.setUserGroupNm(C_ALREADYUSERGROUPNM + ConvertUtil.toZenNumeric(userGroupCdNo));
                userGroup.setUserGroupSetumei(C_ALREADYUSERGROUPSETUMEI + ConvertUtil.toZenNumeric(userGroupCdNo));

                baseDomManager.insert(userGroup);
            }
        }
    }

    @Transactional
    public void deleteTestC0003_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 350; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(C_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null != userGroup ) {

                baseDomManager.delete(userGroup);
            }
        }
    }

    @Transactional
    public void createTestC0005_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 350; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(C_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null == userGroup ) {

                userGroup = new AM_UserGroup();
                userGroup.setUserGroupCd(C_ALREADYUSERGROUPCD + userGroupCdNo);
                userGroup.setUserGroupNm(C_ALREADYUSERGROUPNM + ConvertUtil.toZenNumeric(userGroupCdNo));
                userGroup.setUserGroupSetumei(C_ALREADYUSERGROUPSETUMEI + ConvertUtil.toZenNumeric(userGroupCdNo));

                baseDomManager.insert(userGroup);
            }
        }
    }

    @Transactional
    public void deleteTestC0005_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 350; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(C_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null != userGroup ) {

                baseDomManager.delete(userGroup);
            }
        }
    }

    @Transactional
    public void createTestC0006_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 350; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(C_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null == userGroup ) {

                userGroup = new AM_UserGroup();
                userGroup.setUserGroupCd(C_ALREADYUSERGROUPCD + userGroupCdNo);
                userGroup.setUserGroupNm(C_ALREADYUSERGROUPNM + ConvertUtil.toZenNumeric(userGroupCdNo));
                userGroup.setUserGroupSetumei(C_ALREADYUSERGROUPSETUMEI + ConvertUtil.toZenNumeric(userGroupCdNo));

                baseDomManager.insert(userGroup);
            }
        }
    }

    @Transactional
    public void deleteTestC0006_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 350; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(C_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null != userGroup ) {

                baseDomManager.delete(userGroup);
            }
        }
    }

    @Transactional
    public void createTestC0007_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 350; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(C_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null == userGroup ) {

                userGroup = new AM_UserGroup();
                userGroup.setUserGroupCd(C_ALREADYUSERGROUPCD + userGroupCdNo);
                userGroup.setUserGroupNm(C_ALREADYUSERGROUPNM + ConvertUtil.toZenNumeric(userGroupCdNo));
                userGroup.setUserGroupSetumei(C_ALREADYUSERGROUPSETUMEI + ConvertUtil.toZenNumeric(userGroupCdNo));

                baseDomManager.insert(userGroup);
            }
        }
    }

    @Transactional
    public void deleteTestC0007_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 350; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);
            userGroup = baseDomManager.getUserGroup(C_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null != userGroup ) {

                baseDomManager.delete(userGroup);
            }
        }
    }

    @Transactional
    public void createTestC0008_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 350; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(C_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null == userGroup ) {

                userGroup = new AM_UserGroup();
                userGroup.setUserGroupCd(C_ALREADYUSERGROUPCD + userGroupCdNo);
                userGroup.setUserGroupNm(C_ALREADYUSERGROUPNM + ConvertUtil.toZenNumeric(userGroupCdNo));
                userGroup.setUserGroupSetumei(C_ALREADYUSERGROUPSETUMEI + ConvertUtil.toZenNumeric(userGroupCdNo));

                baseDomManager.insert(userGroup);
            }
        }
    }

    @Transactional
    public void deleteTestC0008_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 350; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(C_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null != userGroup ) {

                baseDomManager.delete(userGroup);
            }
        }
    }

    @Transactional
    public void createTestC0009_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 350; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(C_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null == userGroup ) {

                userGroup = new AM_UserGroup();
                userGroup.setUserGroupCd(C_ALREADYUSERGROUPCD + userGroupCdNo);
                userGroup.setUserGroupNm(C_ALREADYUSERGROUPNM + ConvertUtil.toZenNumeric(userGroupCdNo));
                userGroup.setUserGroupSetumei(C_ALREADYUSERGROUPSETUMEI + ConvertUtil.toZenNumeric(userGroupCdNo));

                baseDomManager.insert(userGroup);
            }
        }
    }

    @Transactional
    public void deleteTestC0009_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 350; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(C_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null != userGroup ) {

                baseDomManager.delete(userGroup);
            }
        }
    }

    @Transactional
    public void createTestC0010_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 9; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(C_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null == userGroup ) {

                userGroup = new AM_UserGroup();
                userGroup.setUserGroupCd(C_ALREADYUSERGROUPCD + userGroupCdNo);
                userGroup.setUserGroupNm(C_ALREADYUSERGROUPNM + ConvertUtil.toZenNumeric(userGroupCdNo));
                userGroup.setUserGroupSetumei(C_ALREADYUSERGROUPSETUMEI + ConvertUtil.toZenNumeric(userGroupCdNo));

                baseDomManager.insert(userGroup);
            }
        }
    }

    @Transactional
    public void deleteTestC0010_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 9; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(C_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null != userGroup ) {

                baseDomManager.delete(userGroup);
            }
        }
    }

    @Transactional
    public void createTestC0011_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 9; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(C_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null == userGroup ) {

                userGroup = new AM_UserGroup();
                userGroup.setUserGroupCd(C_ALREADYUSERGROUPCD + userGroupCdNo);
                userGroup.setUserGroupNm(C_ALREADYUSERGROUPNM + ConvertUtil.toZenNumeric(userGroupCdNo));
                userGroup.setUserGroupSetumei(C_ALREADYUSERGROUPSETUMEI + ConvertUtil.toZenNumeric(userGroupCdNo));

                baseDomManager.insert(userGroup);
            }
        }
    }

    @Transactional
    public void deleteTestC0011_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 9; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(C_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null != userGroup ) {

                baseDomManager.delete(userGroup);
            }
        }
    }

    @Transactional
    public void createTestE0002_01(){

        AM_UserGroup userGroup = null;
        userGroup = baseDomManager.getUserGroup(E_USERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(E_USERGROUPCD);
            userGroup.setUserGroupNm(E_USERGROUPNM);
            userGroup.setUserGroupSetumei(E_ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestE0002_01(){

        AM_UserGroup userGroup = null;

        userGroup = baseDomManager.getUserGroup(E_USERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestF0001_01(){

        AM_UserGroup userGroup = null;

        userGroup = baseDomManager.getUserGroup(F_USERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(F_USERGROUPCD);
            userGroup.setUserGroupNm(F_USERGROUPNM);
            userGroup.setUserGroupSetumei(F_USERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestF0001_01(){

        AM_UserGroup userGroup = null;


        userGroup = baseDomManager.getUserGroup(F_USERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestF0002_01(){

        AM_UserGroup userGroup = null;

        userGroup = baseDomManager.getUserGroup(F_USERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(F_USERGROUPCD);
            userGroup.setUserGroupNm(F_USERGROUPNM);
            userGroup.setUserGroupSetumei(F_USERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestF0002_01(){

        AM_UserGroup userGroup = null;


        userGroup = baseDomManager.getUserGroup(F_USERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestF0003_01(){

        AM_UserGroup userGroup = null;

        userGroup = baseDomManager.getUserGroup(F_USERGROUPCD002);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(F_USERGROUPCD002);
            userGroup.setUserGroupNm(F_USERGROUPNM);
            userGroup.setUserGroupSetumei(F_USERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestF0003_01(){

        AM_UserGroup userGroup = null;


        userGroup = baseDomManager.getUserGroup(F_USERGROUPCD002);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestF0006_01(){

        AM_UserGroup userGroup = null;

        userGroup = baseDomManager.getUserGroup(F_USERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(F_USERGROUPCD);
            userGroup.setUserGroupNm(F_USERGROUPNM);
            userGroup.setUserGroupSetumei(F_USERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestF0006_01(){

        AM_UserGroup userGroup = null;


        userGroup = baseDomManager.getUserGroup(F_USERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestF0007_01(){

        AM_UserGroup userGroup = null;

        userGroup = baseDomManager.getUserGroup(F_USERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(F_USERGROUPCD);
            userGroup.setUserGroupNm(F_USERGROUPNM002);
            userGroup.setUserGroupSetumei(F_USERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestF0007_01(){

        AM_UserGroup userGroup = null;

        userGroup = baseDomManager.getUserGroup(F_USERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestH0002_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 500; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(H_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null == userGroup ) {

                userGroup = new AM_UserGroup();
                userGroup.setUserGroupCd(H_ALREADYUSERGROUPCD + userGroupCdNo);
                userGroup.setUserGroupNm(H_ALREADYUSERGROUPNM + ConvertUtil.toZenNumeric(userGroupCdNo));
                userGroup.setUserGroupSetumei(H_ALREADYUSERGROUPSETUMEI + ConvertUtil.toZenNumeric(userGroupCdNo));

                baseDomManager.insert(userGroup);
            }
        }
    }

    @Transactional
    public void deleteTestH0002_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 500; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(H_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null != userGroup ) {

                baseDomManager.delete(userGroup);
            }
        }
    }

    @Transactional
    public void createTestL0001_01(){

        AM_UserGroup userGroup = null;

        userGroup = baseDomManager.getUserGroup(L_ALREADYUSERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(L_ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(L_ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(L_ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestL0001_01(){

        AM_UserGroup userGroup = null;

        userGroup = baseDomManager.getUserGroup(L_ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestL0002_01(){

        AM_UserGroup userGroup = null;

        userGroup = baseDomManager.getUserGroup(L_ALREADYUSERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(L_ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(L_ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(L_ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestL0002_01(){

        AM_UserGroup userGroup = null;

        userGroup = baseDomManager.getUserGroup(L_ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestO0002_01(){

        AM_UserGroup userGroup = null;

        userGroup = baseDomManager.getUserGroup(O_ALREADYUSERGROUPCD);
        if ( null == userGroup ) {

            userGroup = new AM_UserGroup();
            userGroup.setUserGroupCd(O_ALREADYUSERGROUPCD);
            userGroup.setUserGroupNm(O_ALREADYUSERGROUPNM);
            userGroup.setUserGroupSetumei(O_ALREADYUSERGROUPSETUMEI);

            baseDomManager.insert(userGroup);
        }
    }

    @Transactional
    public void deleteTestO0002_01(){

        AM_UserGroup userGroup = null;

        userGroup = baseDomManager.getUserGroup(O_ALREADYUSERGROUPCD);
        if ( null != userGroup ) {

            baseDomManager.delete(userGroup);
        }
    }

    @Transactional
    public void createTestO0003_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 498; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(O_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null == userGroup ) {

                userGroup = new AM_UserGroup();
                userGroup.setUserGroupCd(O_ALREADYUSERGROUPCD + userGroupCdNo);
                userGroup.setUserGroupNm(O_ALREADYUSERGROUPNM + ConvertUtil.toZenNumeric(userGroupCdNo));
                userGroup.setUserGroupSetumei(O_ALREADYUSERGROUPSETUMEI + ConvertUtil.toZenNumeric(userGroupCdNo));

                baseDomManager.insert(userGroup);
            }
        }
    }

    @Transactional
    public void deleteTestO0003_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 498; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(O_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null != userGroup ) {

                baseDomManager.delete(userGroup);
            }
        }
    }

    @Transactional
    public void createTestO0004_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 499; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(O_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null == userGroup ) {

                userGroup = new AM_UserGroup();
                userGroup.setUserGroupCd(O_ALREADYUSERGROUPCD + userGroupCdNo);
                userGroup.setUserGroupNm(O_ALREADYUSERGROUPNM + ConvertUtil.toZenNumeric(userGroupCdNo));
                userGroup.setUserGroupSetumei(O_ALREADYUSERGROUPSETUMEI + ConvertUtil.toZenNumeric(userGroupCdNo));

                baseDomManager.insert(userGroup);
            }
        }
    }

    @Transactional
    public void deleteTestO0004_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 499; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(O_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null != userGroup ) {

                baseDomManager.delete(userGroup);
            }
        }
    }

    @Transactional
    public void createTestO0005_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 500; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(O_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null == userGroup ) {

                userGroup = new AM_UserGroup();
                userGroup.setUserGroupCd(O_ALREADYUSERGROUPCD + userGroupCdNo);
                userGroup.setUserGroupNm(O_ALREADYUSERGROUPNM + ConvertUtil.toZenNumeric(userGroupCdNo));
                userGroup.setUserGroupSetumei(O_ALREADYUSERGROUPSETUMEI + ConvertUtil.toZenNumeric(userGroupCdNo));

                baseDomManager.insert(userGroup);
            }
        }
    }

    @Transactional
    public void deleteTestO0005_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 500; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(O_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null != userGroup ) {

                baseDomManager.delete(userGroup);
            }
        }
    }

    @Transactional
    public void createTestO0006_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 35; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(O_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null == userGroup ) {

                userGroup = new AM_UserGroup();
                userGroup.setUserGroupCd(O_ALREADYUSERGROUPCD + userGroupCdNo);
                userGroup.setUserGroupNm(O_ALREADYUSERGROUPNM + ConvertUtil.toZenNumeric(userGroupCdNo));
                userGroup.setUserGroupSetumei(O_ALREADYUSERGROUPSETUMEI + ConvertUtil.toZenNumeric(userGroupCdNo));

                baseDomManager.insert(userGroup);
            }
        }
    }

    @Transactional
    public void deleteTestO0006_01(){

        AM_UserGroup userGroup = null;
        for(int idx = 1; idx <= 35; idx++ ){

            String userGroupCdNo = zeroPadding(String.valueOf(idx), 3);

            userGroup = baseDomManager.getUserGroup(O_ALREADYUSERGROUPCD + userGroupCdNo);
            if ( null != userGroup ) {

                baseDomManager.delete(userGroup);
            }
        }
    }

    private String zeroPadding(String str, int length) {
        if (str.length() >= length) {
            return str;
        }
        char[] cs = new char[length - str.length()];
        Arrays.fill(cs, '0');
        return new String(cs) + str;
    }
}
