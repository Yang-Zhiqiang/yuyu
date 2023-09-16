package yuyu.def.db.meta;

/**
 * ＤＳ取引サービス管理テーブル のエンティティメタデータクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class QMT_DsTorihikiServiceKanri extends GenQMT_DsTorihikiServiceKanri {

    public QMT_DsTorihikiServiceKanri() {
    }

    public QMT_DsTorihikiServiceKanri(String pAlias) {
        super(pAlias);
    }

    public String MT_DsTorihikiyouAnsyono(){
        return this.getAlias() + ".dsTorihikiyouAnsyonos";
    }

}
