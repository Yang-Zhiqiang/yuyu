package yuyu.def.db.meta;

/**
 * ユーザーマスタ のエンティティメタデータクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class QAM_User extends GenQAM_User {

    public QAM_User() {
    }

    public QAM_User(String pAlias) {
        super(pAlias);
    }

    public String AT_UserRole() {
        return this.getAlias() + ".userRoles";
    }

}
