package yuyu.infr.auth;

import java.util.List;

import javax.persistence.Transient;

import yuyu.def.db.entity.AT_KinouKengen;

/**
 * ロール認証チェックを行う為のエンティティのインターフェースです。
 */
public interface AuthRoleParam {

    @Transient
    public abstract List<AT_KinouKengen> getKinouKengens();

}
