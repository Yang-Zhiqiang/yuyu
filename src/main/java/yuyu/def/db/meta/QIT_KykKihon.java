package yuyu.def.db.meta;

/**
 * 契約基本テーブル のエンティティメタデータクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class QIT_KykKihon extends GenQIT_KykKihon {

    public QIT_KykKihon() {
    }

    public QIT_KykKihon(String pAlias) {
        super(pAlias);
    }

    public String IT_KhTtdkTyuui() {
        return this.getAlias() + ".khTtdkTyuuis";
    }

}
