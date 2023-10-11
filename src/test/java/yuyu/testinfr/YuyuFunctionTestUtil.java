package yuyu.testinfr;

import static jp.co.slcs.swak.auth.Identity.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.security.acl.Group;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jp.co.slcs.swak.auth.Identity;
import jp.co.slcs.swak.auth.Role;
import jp.co.slcs.swak.auth.RoleGroup;
import jp.co.slcs.swak.auth.SwakPrincipal;
import jp.co.slcs.swak.core.classification.Classification;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateMD;
import jp.co.slcs.swak.date.BizDateSpan;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCalcable;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.base.BaseUserInfo;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_KinouMode;
import yuyu.def.db.entity.AT_KinouKengen;
import yuyu.def.db.entity.AT_UserRole;
import yuyu.infr.auth.AuthRoleParam;
import yuyu.infr.auth.AuthenticatedSubSystems;
import yuyu.infr.auth.SubSystem;
import yuyu.testinfr.inject.MockUtil;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class YuyuFunctionTestUtil {

    @SuppressWarnings("deprecation")
    public static void changeCurrentUser(BaseUserInfo pInfo, AM_User pUser) {

        MockUtil.forceSet(pInfo, "user", pUser);

        setSubject(pUser);

        setRoles(pUser);
    }

    private static void setSubject(AM_User pUser) {
        Identity identity = SWAKInjector.getInstance(Identity.class);

        Set<String> roles = new HashSet<String>();

        identity.getSubject().getPrincipals().add(new SwakPrincipal(pUser.getUserId()));

        Group roleGroup = null;

        for (Group g : identity.getSubject().getPrincipals(Group.class)) {
            if (ROLES_GROUP.equalsIgnoreCase(g.getName())) {
                roleGroup = g;
                break;
            }
        }

        if (roleGroup == null) {
            roleGroup = new RoleGroup(ROLES_GROUP);
        }

        for (String role : roles) {
            roleGroup.addMember(new SwakPrincipal(role));
        }

        identity.getSubject().getPrincipals().add(roleGroup);

    }

    private static void setRoles(AM_User pUser) {
        AuthenticatedSubSystems subSystemParam = SWAKInjector.getInstance(AuthenticatedSubSystems.class);

        //        LoggerFactory.getLogger(this.getClass()).debug("◇ LoginMode:" + mode.getAuthMode());

        final Set<String> kinouIdSet = Sets.newHashSet();

        final Set<SubSystem> subSystemSet = Sets.newHashSet();

        addHasAuthFunctions(kinouIdSet, subSystemSet, getAuthRoles(pUser));

        addOpenFunctions(kinouIdSet, subSystemSet);

        for (String s : kinouIdSet) {
            addRole(s);
        }

        for (SubSystem s : subSystemSet) {
            subSystemParam.addSubSystem(s);
        }
    }

    private static boolean addRole(String pRole) {
        Identity identity = SWAKInjector.getInstance(Identity.class);

        if (pRole == null || "".equals(pRole)) {
            return false;
        }

        for (Group sg : identity.getSubject().getPrincipals(Group.class)) {
            if (ROLES_GROUP.equals(sg.getName())) {
                return sg.addMember(new Role(pRole));
            }
        }

        RoleGroup roleGroup = new RoleGroup(ROLES_GROUP);
        roleGroup.addMember(new Role(pRole));
        identity.getSubject().getPrincipals().add(roleGroup);
        return true;
    }

    private static List<AuthRoleParam> getAuthRoles(AM_User pUser) {

        if (pUser == null) {
            return null;
        }

        List<AuthRoleParam> authRoleParams = Lists.newArrayList();
        for (AT_UserRole uRole : pUser.getUserRoles()) {
            authRoleParams.add(uRole.getRole());
        }

        return authRoleParams;
    }

    private static void addHasAuthFunctions(Set<String> pKinouIdSet, Set<SubSystem> pSubSystemSet, List<AuthRoleParam> pRoles) {

        if (pKinouIdSet == null || pRoles == null) {
            return;
        }

        for (AuthRoleParam role : pRoles) {

            if (role != null) {

                List<AT_KinouKengen> kengens = role.getKinouKengens();

                for (AT_KinouKengen kengen : kengens) {

                    pKinouIdSet.add(kengen.getKinouId());
                    pKinouIdSet.add(kengen.getKinouId() + "." + kengen.getKinouModeId());
                    pSubSystemSet.add(kengen.getKinouMode().getKinou().getSubSystem());
                }
            }
        }
    }

    private static void addOpenFunctions(Set<String> pKinouIdSet, Set<SubSystem> pSubSystemSet) {

        BaseDomManager domManager = SWAKInjector.getInstance(BaseDomManager.class);

        if (pKinouIdSet == null) {
            return;
        }

        for (AS_KinouMode kinouMode : Iterables.concat(
                Iterables.transform(
                        Iterables.filter(
                                domManager.getAllKinous(),
                                new Predicate<AS_Kinou>() {
                                    @Override
                                    public boolean apply(AS_Kinou pKinou) {
                                        return pKinou.getKidouKengenHanteiYouhiKbn().eq(C_YouhiKbn.HUYOU);
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
                ))
        {
            pKinouIdSet.add(kinouMode.getKinouId());
            pKinouIdSet.add(kinouMode.getKinouId() + "." + kinouMode.getKinouModeId());
            pSubSystemSet.add(kinouMode.getKinou().getSubSystem());
        }
    }

    public static void exStringEquals(String pTarget, String pMean, String pItemName) {

        if (pTarget == null && pMean == null) {
            return;
        }
        else if (pTarget == null || pMean == null) {
            fail("【" + pItemName + "】[値の一方のみがNULL] 検証値：" + pTarget + " 期待値：" + pMean);
        }
        else if (!pTarget.equals(pMean)) {
            fail("【" + pItemName + "】[期待値違反] 検証値：" + pTarget + " 期待値：" + pMean);
        }
        assertEquals(pMean, pTarget);
    }

    public static void exBigDecimalEquals(BigDecimal pTarget, BigDecimal pMean, String pItemName) {

        if (pTarget == null && pMean == null) {
            return;
        }
        else if (pTarget == null || pMean == null) {
            fail("【" + pItemName + "】[値の一方のみがNULL] 検証値：" + pTarget + " 期待値：" + pMean);
        }
        //        else if (! pTarget.equals(pMean)) { // ← このコードは誤り。equals の場合、"0" と "0.0" の比較は「false」になる
        //            fail("【" + pItemName + "】[期待値違反] 検証値："+pTarget+" 期待値："+pMean);
        //        }
        else if (pTarget.compareTo(pMean) != 0) { // compareTo の場合、 "0" と "0.0" は「数学的に等価」と見なされ、ちゃんと 0 が返る
            fail("【" + pItemName + "】[期待値違反] 検証値：" + pTarget + " 期待値：" + pMean);
        }
    }

    public static void exBizCalcbleEquals(BizCalcable<?, ?> pTarget, BizCalcable<?, ?> pMean, String pItemName) {

        if (pTarget == null && pMean == null) {
            return;
        }
        else if (pTarget == null || pMean == null) {
            fail("【" + pItemName + "】[値の一方のみがNULL] 検証値：" + pTarget + " 期待値：" + pMean);
        }
        else if (!pTarget.equals(pMean)) {

            String target = pTarget instanceof BizCurrency ? ((BizCurrency) pTarget).toFormatStringWithUnit() : pTarget.toString();
            String mean = pMean instanceof BizCurrency ? ((BizCurrency) pMean).toFormatStringWithUnit() : pMean.toString();

            fail("【" + pItemName + "】[期待値違反] 検証値：" + target + " 期待値：" + mean);
        }
    }

    public static <C extends Classification<C>> void exClassificationEquals(Classification<C> pTarget, Classification<C> pMean, String pItemName) {

        String msgTarget = pTarget == null ? "NULL" : pTarget.getContent() + "(" + pTarget.getValue() + ")";
        String msgMean = pMean == null ? "NULL" : pMean.getContent() + "(" + pMean.getValue() + ")";

        if (pTarget == null && pMean == null) {
            return;
        }
        else if (pTarget == null || pMean == null) {
            fail("【" + pItemName + "】[値の一方のみがNULL] 検証値：" + msgTarget + " 期待値：" + msgMean);
        }
        else if (!pTarget.equals(pMean)) {
            fail("【" + pItemName + "】[期待値違反] 検証値：" + msgTarget + " 期待値：" + msgMean);
        }
        assertEquals(pMean, pTarget);
    }

    public static void exNumericEquals(double pTarget, double pMean, String pItemName) {

        if (pTarget != pMean) {
            fail("【" + pItemName + "】[期待値違反] 検証値：" + pTarget + " 期待値：" + pMean);
        }
    }

    @SuppressWarnings("rawtypes")
    public static void exEnumEquals(Enum pTarget, Enum pMean, String pItemName) {

        if (pTarget == null && pMean == null) {
            return;
        }
        else if (pTarget == null || pMean == null) {
            fail("【" + pItemName + "】[値の一方のみがNULL] 検証値：" + pTarget + " 期待値：" + pMean);
        }
        else if (!pTarget.equals(pMean)) {
            fail("【" + pItemName + "】[期待値違反] 検証値：" + pTarget + " 期待値：" + pMean);
        }
    }

    public static void exDateEquals(BizDate pTarget, BizDate pMean, String pItemName) {

        if (pTarget == null && pMean == null) {
            return;
        }
        else if (pTarget == null || pMean == null) {
            fail("【" + pItemName + "】[値の一方のみがNULL] 検証値：" + pTarget + " 期待値：" + pMean);
        }
        else if (!pTarget.equals(pMean)) {
            fail("【" + pItemName + "】[期待値違反] 検証値：" + pTarget + " 期待値：" + pMean);
        }
    }

    public static void exDateYEquals(BizDateY pTarget, BizDateY pMean, String pItemName) {

        if (pTarget == null && pMean == null) {
            return;
        }
        else if (pTarget == null || pMean == null) {
            fail("【" + pItemName + "】[値の一方のみがNULL] 検証値：" + pTarget + " 期待値：" + pMean);
        }
        else if (!pTarget.equals(pMean)) {
            fail("【" + pItemName + "】[期待値違反] 検証値：" + pTarget + " 期待値：" + pMean);
        }
    }

    public static void exDateYMEquals(BizDateYM pTarget, BizDateYM pMean, String pItemName) {

        if (pTarget == null && pMean == null) {
            return;
        }
        else if (pTarget == null || pMean == null) {
            fail("【" + pItemName + "】[値の一方のみがNULL] 検証値：" + pTarget + " 期待値：" + pMean);
        }
        else if (!pTarget.equals(pMean)) {
            fail("【" + pItemName + "】[期待値違反] 検証値：" + pTarget + " 期待値：" + pMean);
        }
    }

    public static void exDateMDEquals(BizDateMD pTarget, BizDateMD pMean, String pItemName) {

        if (pTarget == null && pMean == null) {
            return;
        }
        else if (pTarget == null || pMean == null) {
            fail("【" + pItemName + "】[値の一方のみがNULL] 検証値：" + pTarget + " 期待値：" + pMean);
        }
        else if (!pTarget.equals(pMean)) {
            fail("【" + pItemName + "】[期待値違反] 検証値：" + pTarget + " 期待値：" + pMean);
        }
    }

    public static void exDateSpanEquals(BizDateSpan pTarget, BizDateSpan pMean, String pItemName) {

        if (pTarget == null && pMean == null) {
            return;
        }
        else if (pTarget == null || pMean == null) {
            fail("【" + pItemName + "】[値の一方のみがNULL] 検証値：" + pTarget + " 期待値：" + pMean);
        }
        else if (!pTarget.equals(pMean)) {
            fail("【" + pItemName + "】[期待値違反] 検証値：" + pTarget + " 期待値：" + pMean);
        }
    }

    public static void exBooleanEquals(boolean pTarget, boolean pMean, String pItemName) {

        if (pTarget != pMean) {
            fail("【" + pItemName + "】[期待値違反] 検証値：" + pTarget + " 期待値：" + pMean);
        }
    }

    public static <V> void exListEquals(List<V> pTarget, List<V> pMean, String pItemName) {
        if (pTarget == null && pMean == null) {
            return;
        }
        else if (pTarget == null || pMean == null) {
            fail("【" + pItemName + "】[値の一方のみがNULL] 検証値：" + pTarget + " 期待値：" + pMean);
        }
        else if (pTarget.size() != pMean.size()) {
            fail("【" + pItemName + "】[期待値違反（サイズ）] 検証値：" + pTarget.size() + " 期待値：" + pMean.size());
        } else {
            for (int i = 0; i < pTarget.size(); i++) {
                V val1 = pTarget.get(i);
                V val2 = pMean.get(i);
                if (!val1.equals(val2)) {
                    fail("【" + pItemName + "】[期待値違反（中身）] 検証値：" + val1 + " 期待値：" + val2);
                }
            }
        }
    }

    //    public static void main(String[] args){
    //    }
}
