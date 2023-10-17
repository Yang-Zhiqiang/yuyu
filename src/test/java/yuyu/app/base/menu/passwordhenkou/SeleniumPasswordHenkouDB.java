package yuyu.app.base.menu.passwordhenkou;

import static yuyu.app.base.menu.passwordhenkou.SeleniumPasswordHenkouConstants.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AM_User;

public class SeleniumPasswordHenkouDB {

    @Inject
    private BaseDomManager baseDomManager;

    @Transactional
    public void modifiedTestB0003_01(){

        AM_User user = baseDomManager.getUser(ALREADYUSERID);
        if ( null != user ) {

            user.setPassword(EXISTINGPASSWORD);

            baseDomManager.update(user);
        }
    }

    @Transactional
    public void modifiedTestB0006_01(){

        AM_User user = baseDomManager.getUser(ALREADYUSERID);
        if ( null != user ) {

            user.setPassword(EXISTINGPASSWORD);

            baseDomManager.update(user);
        }
    }

    @Transactional
    public void modifiedTestB0007_01(){

        AM_User user = baseDomManager.getUser(ALREADYUSERID);
        if ( null != user ) {

            user.setPassword(EXISTINGPASSWORD);

            baseDomManager.update(user);
        }
    }
}
