package yuyu.def.db.meta;

/**
 * 契約保全手続履歴テーブル のエンティティメタデータクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class QIT_KhTtdkRireki extends GenQIT_KhTtdkRireki {

    public QIT_KhTtdkRireki() {
    }

    public QIT_KhTtdkRireki(String pAlias) {
        super(pAlias);
    }

    public String AS_Kinou(){
        return this.getAlias() + ".kinou";
    }

    public String AM_User(){
        return this.getAlias() + ".user";
    }

}
