package yuyu.app.base.system.userkensaku;

import static yuyu.app.base.system.userkensaku.SeleniumUserKensakuConstants.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_SpecialUserKbn;
import yuyu.def.db.entity.AM_User;

public class SeleniumUserKensakuDB {

    private static final C_SpecialUserKbn ALREADYSPECIALUSERKBN = null;

    @Inject
    private BaseDomManager baseDomManager;

    @Transactional
    public void createTestB0005_01(){

        AM_User user = null;
        for(int idx = 1; idx <= 350; idx++ ){

            user = baseDomManager.getUser(ALREADYUSERID + idx);
            if ( null == user ) {

                user = new AM_User();
                user.setUserId(ALREADYUSERID + idx);
                user.setUserNm(ALREADYUSERNM);
                user.setSpecialUserKbn(ALREADYSPECIALUSERKBN);
                user.setPassword(ALREADYPASSWORD);
                user.setPasswordSetteiYmd(ALREADYPASSWORDSETEIYMD);
                user.setPasswordYuukouKikanKbn(ALREADYPASSWORDYUUKOUKIKANKBN);
                user.setPasswordHenkouKyokaKbn(ALREADYPASSWORDKYOKAKBN);
                user.setPasswordHenkouYoukyuuKbn(ALREADYYOUKYUUKBN);
                user.setLoginKyokaKbn(ALREADYLOGINKYOKAKBN);

                baseDomManager.insert(user);
            }
        }
    }

    @Transactional
    public void deleteTestB0005_01(){

        AM_User user = null;
        for(int idx = 1; idx <= 350; idx++ ){

            user = baseDomManager.getUser(ALREADYUSERID + idx);
            if ( null != user ) {

                baseDomManager.delete(user);
            }
        }
    }

    @Transactional
    public void createTestB0006_01(){

        AM_User user = null;
        for(int idx = 1; idx <= 350; idx++ ){

            user = baseDomManager.getUser(ALREADYUSERID + idx);
            if ( null == user ) {

                user = new AM_User();
                user.setUserId(ALREADYUSERID + idx);
                user.setUserNm(ALREADYUSERNM);
                user.setSpecialUserKbn(ALREADYSPECIALUSERKBN);
                user.setPassword(ALREADYPASSWORD);
                user.setPasswordSetteiYmd(ALREADYPASSWORDSETEIYMD);
                user.setPasswordYuukouKikanKbn(ALREADYPASSWORDYUUKOUKIKANKBN);
                user.setPasswordHenkouKyokaKbn(ALREADYPASSWORDKYOKAKBN);
                user.setPasswordHenkouYoukyuuKbn(ALREADYYOUKYUUKBN);
                user.setLoginKyokaKbn(ALREADYLOGINKYOKAKBN);

                baseDomManager.insert(user);
            }
        }
    }

    @Transactional
    public void deleteTestB0006_01(){

        AM_User user = null;
        for(int idx = 1; idx <= 350; idx++ ){

            user = baseDomManager.getUser(ALREADYUSERID + idx);
            if ( null != user ) {

                baseDomManager.delete(user);
            }
        }
    }

    @Transactional
    public void createTestB0007_01(){

        AM_User user = null;
        for(int idx = 1; idx <= 350; idx++ ){

            user = baseDomManager.getUser(ALREADYUSERID + idx);
            if ( null == user ) {

                user = new AM_User();
                user.setUserId(ALREADYUSERID + idx);
                user.setUserNm(ALREADYUSERNM);
                user.setSpecialUserKbn(ALREADYSPECIALUSERKBN);
                user.setPassword(ALREADYPASSWORD);
                user.setPasswordSetteiYmd(ALREADYPASSWORDSETEIYMD);
                user.setPasswordYuukouKikanKbn(ALREADYPASSWORDYUUKOUKIKANKBN);
                user.setPasswordHenkouKyokaKbn(ALREADYPASSWORDKYOKAKBN);
                user.setPasswordHenkouYoukyuuKbn(ALREADYYOUKYUUKBN);
                user.setLoginKyokaKbn(ALREADYLOGINKYOKAKBN);

                baseDomManager.insert(user);
            }
        }
    }

    @Transactional
    public void deleteTestB0007_01(){

        AM_User user = null;
        for(int idx = 1; idx <= 350; idx++ ){

            user = baseDomManager.getUser(ALREADYUSERID + idx);
            if ( null != user ) {

                baseDomManager.delete(user);
            }
        }
    }

    @Transactional
    public void createTestB0008_01(){

        AM_User user = null;
        for(int idx = 1; idx <= 350; idx++ ){

            user = baseDomManager.getUser(ALREADYUSERID + idx);
            if ( null == user ) {

                user = new AM_User();
                user.setUserId(ALREADYUSERID + idx);
                user.setUserNm(ALREADYUSERNM);
                user.setSpecialUserKbn(ALREADYSPECIALUSERKBN);
                user.setPassword(ALREADYPASSWORD);
                user.setPasswordSetteiYmd(ALREADYPASSWORDSETEIYMD);
                user.setPasswordYuukouKikanKbn(ALREADYPASSWORDYUUKOUKIKANKBN);
                user.setPasswordHenkouKyokaKbn(ALREADYPASSWORDKYOKAKBN);
                user.setPasswordHenkouYoukyuuKbn(ALREADYYOUKYUUKBN);
                user.setLoginKyokaKbn(ALREADYLOGINKYOKAKBN);

                baseDomManager.insert(user);
            }
        }
    }

    @Transactional
    public void deleteTestB0008_01(){

        AM_User user = null;
        for(int idx = 1; idx <= 350; idx++ ){

            user = baseDomManager.getUser(ALREADYUSERID + idx);
            if ( null != user ) {

                baseDomManager.delete(user);
            }
        }
    }

    @Transactional
    public void createTestB0009_01(){

        AM_User user = null;
        for(int idx = 1; idx <= 350; idx++ ){

            user = baseDomManager.getUser(ALREADYUSERID + idx);
            if ( null == user ) {

                user = new AM_User();
                user.setUserId(ALREADYUSERID + idx);
                user.setUserNm(ALREADYUSERNM);
                user.setSpecialUserKbn(ALREADYSPECIALUSERKBN);
                user.setPassword(ALREADYPASSWORD);
                user.setPasswordSetteiYmd(ALREADYPASSWORDSETEIYMD);
                user.setPasswordYuukouKikanKbn(ALREADYPASSWORDYUUKOUKIKANKBN);
                user.setPasswordHenkouKyokaKbn(ALREADYPASSWORDKYOKAKBN);
                user.setPasswordHenkouYoukyuuKbn(ALREADYYOUKYUUKBN);
                user.setLoginKyokaKbn(ALREADYLOGINKYOKAKBN);

                baseDomManager.insert(user);
            }
        }
    }

    @Transactional
    public void deleteTestB0009_01(){

        AM_User user = null;
        for(int idx = 1; idx <= 350; idx++ ){

            user = baseDomManager.getUser(ALREADYUSERID + idx);
            if ( null != user ) {

                baseDomManager.delete(user);
            }
        }
    }

    @Transactional
    public void createTestB0011_01(){

        AM_User user = null;
        for(int idx = 1; idx <= 350; idx++ ){

            user = baseDomManager.getUser(ALREADYUSERID + idx);
            if ( null == user ) {

                user = new AM_User();
                user.setUserId(ALREADYUSERID + idx);
                user.setUserNm(ALREADYUSERNM);
                user.setSpecialUserKbn(ALREADYSPECIALUSERKBN);
                user.setPassword(ALREADYPASSWORD);
                user.setPasswordSetteiYmd(ALREADYPASSWORDSETEIYMD);
                user.setPasswordYuukouKikanKbn(ALREADYPASSWORDYUUKOUKIKANKBN);
                user.setPasswordHenkouKyokaKbn(ALREADYPASSWORDKYOKAKBN);
                user.setPasswordHenkouYoukyuuKbn(ALREADYYOUKYUUKBN);
                user.setLoginKyokaKbn(ALREADYLOGINKYOKAKBN);

                baseDomManager.insert(user);
            }
        }
    }

    @Transactional
    public void deleteTestB0011_01(){

        AM_User user = null;
        for(int idx = 1; idx <= 350; idx++ ){

            user = baseDomManager.getUser(ALREADYUSERID + idx);
            if ( null != user ) {

                baseDomManager.delete(user);
            }
        }
    }
}
