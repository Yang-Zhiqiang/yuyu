package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKAT_UserHenkouRireki;
import yuyu.def.db.mapping.GenAT_UserHenkouRireki;
import yuyu.def.db.meta.GenQAT_UserHenkouRireki;
import yuyu.def.db.meta.QAT_UserHenkouRireki;

/**
 * ユーザー変更履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_UserHenkouRireki} の JavaDoc を参照してください。
 * @see     GenAT_UserHenkouRireki
 * @see     PKAT_UserHenkouRireki
 * @see     QAT_UserHenkouRireki
 * @see     GenQAT_UserHenkouRireki
 */
@Entity
public class AT_UserHenkouRireki extends GenAT_UserHenkouRireki {

    private static final long serialVersionUID = 1L;

    public AT_UserHenkouRireki() {
    }

    public AT_UserHenkouRireki(String pUniqueId) {
        super(pUniqueId);
    }

    ////    @ManyToOne(targetEntity = AM_User.class)
    ////    @JoinColumn(name = AT_UserHenkouRireki.USERID, referencedColumnName = AM_User.USERID, insertable = false, updatable = false)
    //    private AM_User aM_User;
    //
    //    @ManyToOne
    //    @JoinColumn(name=AT_UserHenkouRireki.USERID, insertable=false, updatable=false)
    //    public AM_User getUser() {
    //        return aM_User;
    //    }
    //
    //    void setUser(AM_User pAM_User) {
    //        aM_User = pAM_User;
    //    }

}
