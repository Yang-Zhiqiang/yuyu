package yuyu.def.db.meta;

/**
 * 外貨ＦＢ送金データテーブル のエンティティメタデータクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class QBT_GkFBSoukinData extends GenQBT_GkFBSoukinData {

    public QBT_GkFBSoukinData() {
    }

    public QBT_GkFBSoukinData(String pAlias) {
        super(pAlias);
    }

    public String BM_FBSoukinListKanri() {
        return this.getAlias() + ".FBSoukinListKanri";
    }

}
