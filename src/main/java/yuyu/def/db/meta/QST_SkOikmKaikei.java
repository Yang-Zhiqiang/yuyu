package yuyu.def.db.meta;

/**
 * 新契約追込会計取引データテーブル のエンティティメタデータクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class QST_SkOikmKaikei extends GenQST_SkOikmKaikei {

    public QST_SkOikmKaikei() {
    }

    public QST_SkOikmKaikei(String pAlias) {
        super(pAlias);
    }

    public String BM_KanjyouKamoku(){
        return this.getAlias() + ".kanjyouKamoku";
    }
}
