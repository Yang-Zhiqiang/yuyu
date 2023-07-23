package yuyu.infr.auth;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import jp.co.slcs.swak.auth.Authenticator;
import jp.co.slcs.swak.auth.Credentials;
import jp.co.slcs.swak.auth.Identity;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.inject.annotation.ThreadScoped;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.web.auth.UserSessionManager;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.RayTmSosikiUtil;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_KyokaKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.dao.AS_KinouDao;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_KinouMode;
import yuyu.def.db.entity.AT_KinouKengen;
import yuyu.def.db.entity.AT_SosikiRole;
import yuyu.def.db.entity.AT_UserRole;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * ゆうゆう生保標準の認証基盤クラスです。
 */
@ThreadScoped
public class YuyuAuthenticator implements Authenticator {

    @Inject
    private Credentials credentials;

    @Inject
    private Identity identity;

    @Inject
    private AuthenticatedSubSystems subSystemParam;

    @Inject
    private BaseDomManager man;

    @Inject
    private AM_User user;

    @Inject
    private YuyuAuthMode mode;

    @Inject
    private AS_KinouDao  kinouDao;

    @Override
    public final boolean authenticate() {

        AuthCheckParam param = getAuthParam();

        if (param != null &&
            param.getUserId().equals(credentials.getUsername())) {
            return true;
        }
        return false;
    }

    @Override
    public final void postAuthenticate() {
        RayCreator.recreate(SWAKInjector.getInstance(RayHttpHeaderHolder.class).getRayHeaderBean());

        LoggerFactory.getLogger(this.getClass()).debug("◇ LoginMode:" + mode.getAuthMode());

        final Set<String>   kinouIdSet = Sets.newHashSet();

        final Set<SubSystem> subSystemSet = Sets.newHashSet();

        final Set<String>   kinouIdSet4User = Sets.newHashSet();

        final Set<SubSystem> subSystemSet4User = Sets.newHashSet();

        final Set<String>   kinouIdSet4Sosiki = Sets.newHashSet();

        final Set<SubSystem> subSystemSet4Sosiki = Sets.newHashSet();

        addHasAuthFunctions(kinouIdSet4User, subSystemSet4User, getAuthRoles4User());

        addHasAuthFunctions(kinouIdSet4Sosiki, subSystemSet4Sosiki, getAuthRoles4Sosiki());

        userAndSosikiAuth(kinouIdSet,subSystemSet, kinouIdSet4User, subSystemSet4User, kinouIdSet4Sosiki, subSystemSet4Sosiki);

        addOpenFunctions(kinouIdSet, subSystemSet);

        for(String s : kinouIdSet) {
            identity.addRole(s);
        }

        for(SubSystem s : subSystemSet){
            subSystemParam.addSubSystem(s);
        }

        credentials.putInfo(UserSessionManager.DPCT_LOGIN_INFOKEY, isDuplicateLoginCheckMode());
    }

    private void userAndSosikiAuth(Set<String> kinouIdSet, Set<SubSystem> subSystemSet,
        Set<String> kinouIdSet4User, Set<SubSystem> subSystemSet4User,
        Set<String> kinouIdSet4Sosiki, Set<SubSystem> subSystemSet4Sosiki) {

        for(String kinouId4User : kinouIdSet4User){
            if(kinouIdSet4Sosiki.contains(kinouId4User)){
                kinouIdSet.add(kinouId4User);
            }
        }

        for(SubSystem subsystemId4User : subSystemSet4User){
            if(subSystemSet4Sosiki.contains(subsystemId4User)){
                subSystemSet.add(subsystemId4User);
            }
        }

    }

    protected AuthCheckParam getAuthParam(){

        user = man.getUser(credentials.getUsername());

        if (user == null || user.getLoginKyokaKbn().eq(C_KyokaKbn.NONE)) {
            return null;
        }

        return new AuthCheckParam(user.getUserId(), user.getPassword());
    }

    protected List<AuthRoleParam> getAuthRoles4User(){

        if(user == null) {
            return null;
        }

        BaseUserInfo userInfo = SWAKInjector.getInstance(BaseUserInfo.class);

        List<AT_UserRole> userRoleList = man.getUser(userInfo.getUserId()).getUserRoles();

        List<AuthRoleParam> roles4User = Lists.newArrayList();
        for(AT_UserRole userRole : userRoleList) {
            roles4User.add(userRole.getRole());
        }

        return roles4User;
    }

    protected List<AuthRoleParam> getAuthRoles4Sosiki(){

        BaseUserInfo userInfo = SWAKInjector.getInstance(BaseUserInfo.class);

        List<AT_SosikiRole> sosikiRoleList = man.getSosikiRolesByTanmatusettisosikicd(RayTmSosikiUtil.getTmSosikiCd(userInfo.getTmSosikiCd()));

        List<AuthRoleParam> roles4Sosiki = Lists.newArrayList();
        for(AT_SosikiRole sosikiRole : sosikiRoleList) {
            roles4Sosiki.add(sosikiRole.getRole());
        }

        return roles4Sosiki;

    }


    protected void addHasAuthFunctions(Set<String> pKinouIdSet, Set<SubSystem> pSubSystemSet, List<AuthRoleParam> pRoles){

        if(pKinouIdSet == null || pSubSystemSet == null || pRoles == null) {
            return;
        }

        for(AuthRoleParam role : pRoles){

            if (role != null) {

                kinouDao.selectAll();

                List<AT_KinouKengen> kengens = role.getKinouKengens();

                for(AT_KinouKengen kengen : kengens){

                    C_KinouKbn kinouKbn = kengen.getKinouMode().getKinou().getKinouKbn();
                    C_YouhiKbn youhi =  kengen.getKinouMode().getKinou().getKidouKengenHanteiYouhiKbn();

                    if(youhi.eq(C_YouhiKbn.YOU)
                        && (C_KinouKbn.ONLINE.eq(kinouKbn) || C_KinouKbn.ONLINEBATCH.eq(kinouKbn)) ){
                        pKinouIdSet.add(kengen.getKinouId());
                        pKinouIdSet.add(kengen.getKinouId() + "." + kengen.getKinouModeId());
                        pSubSystemSet.add(kengen.getKinouMode().getKinou().getSubSystem());
                    }

                }
            }
        }
    }

    protected void addOpenFunctions(Set<String> pKinouIdSet, Set<SubSystem> pSubSystemSet){

        if(pKinouIdSet == null) {
            return;
        }

        for (AS_KinouMode kinouMode :
            Iterables.concat(
                Iterables.transform(
                    Iterables.filter(
                        man.getAllKinous(),
                        new Predicate<AS_Kinou>() {
                            @Override
                            public boolean apply(AS_Kinou pKinou) {
                                return pKinou.getKidouKengenHanteiYouhiKbn().eq(C_YouhiKbn.HUYOU)
                                    && (pKinou.getKinouKbn().eq(C_KinouKbn.ONLINE) || pKinou.getKinouKbn().eq(C_KinouKbn.ONLINEBATCH));
                            }
                        }
                        ),
                        new Function<AS_Kinou, Set<AS_KinouMode>>() {
                        @Override
                        public Set<AS_KinouMode> apply(AS_Kinou pKinou) {
                            return pKinou.getKinouModes();
                        }
                    }
                    )
                )
            )
        {
            pKinouIdSet.add(kinouMode.getKinouId());
            pKinouIdSet.add(kinouMode.getKinouId() + "." + kinouMode.getKinouModeId());
            pSubSystemSet.add(kinouMode.getKinou().getSubSystem());
        }
    }

    protected boolean isDuplicateLoginCheckMode(){
        return false;
    }
}
