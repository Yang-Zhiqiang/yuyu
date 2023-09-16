package yuyu.def.db.meta;

/**
 * ユーザーロールテーブル のエンティティメタデータクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class QAT_UserRole extends GenQAT_UserRole {

    public QAT_UserRole() {
    }

    public QAT_UserRole(String pAlias) {
        super(pAlias);
    }

    public String AM_Role() {
        return this.getAlias() + ".role";
    }
}
