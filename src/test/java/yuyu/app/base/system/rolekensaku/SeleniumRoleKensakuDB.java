package yuyu.app.base.system.rolekensaku;

import static yuyu.app.base.system.rolekensaku.SeleniumRoleKensakuConstants.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AM_Role;

public class SeleniumRoleKensakuDB {

    @Inject
    private BaseDomManager baseDomManager;

    @Transactional
    public void createTestB0005_01(){

        AM_Role role = null;
        for(int idx = 1; idx <= 350; idx++ ){

            role = baseDomManager.getRole(ALREADYROLECD + idx);
            if ( null == role ) {

                role = new AM_Role();
                role.setRoleCd(ALREADYROLECD + idx);
                role.setRoleNm(ALREADYROLENM);
                role.setRoleSetumei(ALREADYROLESETUMEI + idx);
                role.setSysSiyouKbn(ALREADYSYSSIYOUKBN);

                baseDomManager.insert(role);
            }
        }
    }

    @Transactional
    public void deleteTestB0005_01(){

        AM_Role role = null;
        for(int idx = 1; idx <= 350; idx++ ){

            role = baseDomManager.getRole(ALREADYROLECD + idx);
            if ( null != role ) {

                baseDomManager.delete(role);
            }
        }
    }

    @Transactional
    public void createTestB0006_01(){

        AM_Role role = null;
        for(int idx = 1; idx <= 350; idx++ ){

            role = baseDomManager.getRole(ALREADYROLECD + idx);
            if ( null == role ) {

                role = new AM_Role();
                role.setRoleCd(ALREADYROLECD + idx);
                role.setRoleNm(ALREADYROLENM);
                role.setRoleSetumei(ALREADYROLESETUMEI + idx);
                role.setSysSiyouKbn(ALREADYSYSSIYOUKBN);

                baseDomManager.insert(role);
            }
        }
    }

    @Transactional
    public void deleteTestB0006_01(){

        AM_Role role = null;
        for(int idx = 1; idx <= 350; idx++ ){

            role = baseDomManager.getRole(ALREADYROLECD + idx);
            if ( null != role ) {

                baseDomManager.delete(role);
            }
        }
    }

    @Transactional
    public void createTestB0007_01(){

        AM_Role role = null;
        for(int idx = 1; idx <= 350; idx++ ){

            role = baseDomManager.getRole(ALREADYROLECD + idx);
            if ( null == role ) {

                role = new AM_Role();
                role.setRoleCd(ALREADYROLECD + idx);
                role.setRoleNm(ALREADYROLENM);
                role.setRoleSetumei(ALREADYROLESETUMEI + idx);
                role.setSysSiyouKbn(ALREADYSYSSIYOUKBN);

                baseDomManager.insert(role);
            }
        }
    }

    @Transactional
    public void deleteTestB0007_01(){

        AM_Role role = null;
        for(int idx = 1; idx <= 350; idx++ ){

            role = baseDomManager.getRole(ALREADYROLECD + idx);
            if ( null != role ) {

                baseDomManager.delete(role);
            }
        }
    }

    @Transactional
    public void createTestB0008_01(){

        AM_Role role = null;
        for(int idx = 1; idx <= 350; idx++ ){

            role = baseDomManager.getRole(ALREADYROLECD + idx);
            if ( null == role ) {

                role = new AM_Role();
                role.setRoleCd(ALREADYROLECD + idx);
                role.setRoleNm(ALREADYROLENM);
                role.setRoleSetumei(ALREADYROLESETUMEI + idx);
                role.setSysSiyouKbn(ALREADYSYSSIYOUKBN);

                baseDomManager.insert(role);
            }
        }
    }

    @Transactional
    public void deleteTestB0008_01(){

        AM_Role role = null;
        for(int idx = 1; idx <= 350; idx++ ){

            role = baseDomManager.getRole(ALREADYROLECD + idx);
            if ( null != role ) {

                baseDomManager.delete(role);
            }
        }
    }

    @Transactional
    public void createTestB0009_01(){

        AM_Role role = null;
        for(int idx = 1; idx <= 350; idx++ ){

            role = baseDomManager.getRole(ALREADYROLECD + idx);
            if ( null == role ) {

                role = new AM_Role();
                role.setRoleCd(ALREADYROLECD + idx);
                role.setRoleNm(ALREADYROLENM);
                role.setRoleSetumei(ALREADYROLESETUMEI + idx);
                role.setSysSiyouKbn(ALREADYSYSSIYOUKBN);

                baseDomManager.insert(role);
            }
        }
    }

    @Transactional
    public void deleteTestB0009_01(){

        AM_Role role = null;
        for(int idx = 1; idx <= 350; idx++ ){

            role = baseDomManager.getRole(ALREADYROLECD + idx);
            if ( null != role ) {

                baseDomManager.delete(role);
            }
        }
    }

    @Transactional
    public void createTestB0011_01(){

        AM_Role role = null;
        for(int idx = 1; idx <= 350; idx++ ){

            role = baseDomManager.getRole(ALREADYROLECD + idx);
            if ( null == role ) {

                role = new AM_Role();
                role.setRoleCd(ALREADYROLECD + idx);
                role.setRoleNm(ALREADYROLENM);
                role.setRoleSetumei(ALREADYROLESETUMEI + idx);
                role.setSysSiyouKbn(ALREADYSYSSIYOUKBN);

                baseDomManager.insert(role);
            }
        }
    }

    @Transactional
    public void deleteTestB0011_01(){

        AM_Role role = null;
        for(int idx = 1; idx <= 350; idx++ ){

            role = baseDomManager.getRole(ALREADYROLECD + idx);
            if ( null != role ) {

                baseDomManager.delete(role);
            }
        }
    }

}
