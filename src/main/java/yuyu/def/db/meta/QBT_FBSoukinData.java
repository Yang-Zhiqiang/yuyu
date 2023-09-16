package yuyu.def.db.meta;

/**
 * ＦＢ送金データテーブル のエンティティメタデータクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class QBT_FBSoukinData extends GenQBT_FBSoukinData {

    public QBT_FBSoukinData() {
    }

    public QBT_FBSoukinData(String pAlias) {
        super(pAlias);
    }

    public String BM_FBSoukinListKanri() {
        return this.getAlias() + ".FBSoukinListKanri";
    }

}
