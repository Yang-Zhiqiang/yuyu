package yuyu.def.db.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.security.SecurityPolicy;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_RirekiSyuruiKbn;
import yuyu.def.db.id.PKAM_User;
import yuyu.def.db.mapping.GenAM_User;
import yuyu.def.db.meta.GenQAM_User;
import yuyu.def.db.meta.QAM_User;

import com.google.common.collect.Lists;

/**
 * ユーザーマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAM_User} の JavaDoc を参照してください。
 * @see     GenAM_User
 * @see     PKAM_User
 * @see     QAM_User
 * @see     GenQAM_User
 */
@Entity
public class AM_User extends GenAM_User {

    private static final long serialVersionUID = 1L;

    public AM_User() {
    }

    public AM_User(String pUserId) {
        super(pUserId);
    }


    private List<AT_UserRole> aT_UserRoles = Lists.newLinkedList();

    public AT_UserRole createUserRole() {
        AT_UserRole aT_UserRole = new AT_UserRole();
        aT_UserRole.setUser(this);
        aT_UserRole.setUserId(this.getUserId());
        getUserRoles().add(aT_UserRole);
        return aT_UserRole;
    }

    @OneToMany(
        fetch         = FetchType.EAGER,
        cascade       = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH },
        orphanRemoval = true
        )
    @JoinColumn(name=AT_UserRole.USERID, referencedColumnName=AM_User.USERID, insertable=false, updatable=false)
    public List<AT_UserRole> getUserRoles(){
        return aT_UserRoles;
    }

    protected void setUserRoles(List<AT_UserRole> pUserRoles){
        aT_UserRoles = pUserRoles;
    }

    private AT_UserSettei aT_UserSettei;

    public AT_UserSettei createUserSettei() {
        if (getUserSettei() != null) {
            throw new IllegalStateException("UserSettei is already exists.");
        }
        aT_UserSettei = new AT_UserSettei(this);
        return aT_UserSettei;
    }

    @OneToOne(
        mappedBy      = "user",
        cascade       = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH },
        orphanRemoval = true
        )
    public AT_UserSettei getUserSettei() {
        return aT_UserSettei;
    }

    public void setUserSettei(AT_UserSettei pUserSettei) {
        aT_UserSettei = pUserSettei;
    }

    public void removeUserSettei() {
        if (getUserSettei() == null) {
            return;
        }
        setUserSettei(null);
    }

    //    private List<AT_UserHenkouRireki> aT_UserHenkouRirekis = Lists.newLinkedList();
    //
    ////    @OneToMany(
    ////        targetEntity = AT_UserHenkouRireki.class,
    ////        fetch = FetchType.LAZY,
    ////        cascade = {CascadeType.PERSIST, CascadeType.DETACH},
    ////        orphanRemoval = true,
    ////        mappedBy = "user"
    ////    )
    //    @OneToMany(
    //        mappedBy="user",
    ////      cascade ={ CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }
    //        cascade ={ CascadeType.DETACH, CascadeType.PERSIST }
    //    )
    //    public List<AT_UserHenkouRireki> getUserHenkouRirekis() {
    //        return aT_UserHenkouRirekis;
    //    }
    //
    //    protected void setUserHenkouRirekis(List<AT_UserHenkouRireki> pUserHenkouRirekis) {
    //        aT_UserHenkouRirekis = readyChildEntityList(pUserHenkouRirekis);
    //    }
    //
    // ↑ 2014/03/20 T.Hoshino AM_User の AT_UserHenkouRireki に対するリレーション定義は削除
    //
    // 理由説明)
    //   ユーザー変更履歴 は「ユーザーアカウントドメインに属するデータ(ユーザーの属性情報)『ではなく』、
    //   システムログ (AT_AccessLog なんかと似たような立ち位置の『監査ログ』データ)」であり、
    //   「いつ誰が誰のアカウント情報をどのように書き換えたか、システムとして痕跡を残す」といった
    //   セキュリティー的意味合いの強いデータである。要するに「ユーザー変更履歴 ＝ ユーザー変更ログ」である。
    //   このデータは通常の業務運用時に参照されることはなく、「不正アクセスが行われた」のような非常時に、
    //   システム管理者が過去のシステム運用履歴を調査するとき参照するものなので、
    //   AM_User の子データとして業務から使われることは無い。というか「使うべきでない」。
    //   またユーザーアカウント削除の際もユーザー変更履歴は(システム監査ログなので)削除してはならない
    //   (むしろ「ユーザーが削除されたという履歴」が「追加」される)。
    //   ユーザー変更履歴は「過去、こう言うユーザーがこんな設定で実在していた」という事実の記録なので、
    //   「システム(またはシステム管理者)が不要と判断」するまで勝手に削除してはならない。
    //
    //   以上から、 AM_User ←→ AT_UserHenkouRireki 間にリレーションを定義してはならない。
    //
    //   また「ユーザー変更履歴」は業務本来の目的とは違う「横断的関心事」であるため、
    //   業務アプリケーションプログラマが意識せずともシステムが自動で追加しなければならない。
    //   そのためのコードが # addUserHenkouRireki() である。

    private List<AT_PasswordRireki> aT_PasswordRirekis = Lists.newLinkedList();

    @OneToMany(
        fetch         = FetchType.LAZY,
        cascade       = { CascadeType.REFRESH, CascadeType.DETACH },
        orphanRemoval = true
        )
    @JoinColumn(name=AT_PasswordRireki.USERID, referencedColumnName=AM_User.USERID, insertable=false, updatable=false)
    public List<AT_PasswordRireki> getPasswordRirekis() {
        return aT_PasswordRirekis;
    }

    protected void setPasswordRirekis(List<AT_PasswordRireki> pPasswordRirekis) {
        aT_PasswordRirekis = pPasswordRirekis;
    }

    private List<AT_MyMenu> aT_MyMenus = Lists.newLinkedList();

    public AT_MyMenu createMyMenu(){
        AT_MyMenu aT_MyMenu = new AT_MyMenu();
        aT_MyMenu.setUserId(this.getUserId());
        aT_MyMenu.setUser(this);
        getMyMenus().add(aT_MyMenu);
        return aT_MyMenu;
    }

    @OneToMany(
        cascade       = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH },
        orphanRemoval = true
        )
    @JoinColumn(name=AT_MyMenu.USERID, referencedColumnName=AM_User.USERID, insertable=false, updatable=false)
    public List<AT_MyMenu> getMyMenus() {
        return aT_MyMenus;
    }

    protected void setMyMenus(List<AT_MyMenu> pMyMenus) {
        aT_MyMenus = pMyMenus;
    }

    @Transient
    private List<String> setPasswords = new ArrayList<>(2);

    @Override
    public void setPassword(String password) {
        setPasswords.add(password);
        super.setPassword(password);
    }

    @Transient
    private boolean isPasswordChanged() {
        return setPasswords.size() > 1;
    }

    @PrePersist
    private void preInsert() {
        encPassword();
        addUserHenkouRireki(C_RirekiSyuruiKbn.NEW);
    }

    @PreUpdate
    private void updateRirekis() {
        if (isPasswordChanged()) {
            encPassword();

            AT_PasswordRireki passwordRireki = new AT_PasswordRireki();
            passwordRireki.setUser(this);
            passwordRireki.setUniqueId(generateUniqueKey());
            passwordRireki.setUserId(this.getUserId());
            passwordRireki.setPassword(setPasswords.isEmpty() ? null : setPasswords.get(0));
            getPasswordRirekis().add(passwordRireki);
            SWAKInjector.getInstance(BaseDomManager.class).insert(passwordRireki);
            setPasswords.clear();
            setPasswords.add(getPassword());
        }
        addUserHenkouRireki(C_RirekiSyuruiKbn.EDIT);
    }

    @PreRemove
    private void preDelete() {
        addUserHenkouRireki(C_RirekiSyuruiKbn.DELETE);
    }

    private void encPassword(){
        super.setPassword(
            SWAKInjector.getInstance(SecurityPolicy.class).encryptPassword(
                getUserId(),
                getPassword()
                )
            );
    }

    private void addUserHenkouRireki(C_RirekiSyuruiKbn pRirekiSyuruiKbn) {
        AT_UserHenkouRireki userHenkouRireki = new AT_UserHenkouRireki(generateUniqueKey());
        userHenkouRireki.setRirekiSyuruiKbn(pRirekiSyuruiKbn);
        BeanUtil.copyProperties(userHenkouRireki, this);
        SWAKInjector.getInstance(BaseDomManager.class).insert(userHenkouRireki);
    }

    private static String generateUniqueKey() {
        return SWAKInjector.getInstance(UniqueKeyGenerator.class).generateUniqueKey();
    }

    private AM_UserGroup userGroup;

    @LazyToOne(LazyToOneOption.FALSE)
    @ManyToOne(optional=true)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = AM_User.USERGROUPCD, referencedColumnName = AM_UserGroup.USERGROUPCD, insertable=false, updatable=false)
    public AM_UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(AM_UserGroup pUserGroup) {
        this.userGroup = pUserGroup;
    }

    public AT_MyMenu getMyMenuByKinouId(String pKinouId){
        for ( AT_MyMenu mymenu : getMyMenus() ){
            if ( mymenu.getKinouId().equals(pKinouId) ){
                return mymenu;
            }
        }
        return null;
    }

    public AT_UserRole getUserRole(String pRoleCd){
        for ( AT_UserRole role : getUserRoles() ){
            if ( role.getRoleCd().equals(pRoleCd) ){
                return role;
            }
        }
        return null;
    }
}
