package yuyu.def.db.meta;

/**
 * ＤＳ顧客契約テーブル のエンティティメタデータクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class QMT_DsKokyakuKeiyaku extends GenQMT_DsKokyakuKeiyaku {

    public QMT_DsKokyakuKeiyaku() {
    }

    public QMT_DsKokyakuKeiyaku(String pAlias) {
        super(pAlias);
    }

    public String MT_DsTorihikiServiceKanri(){
        return this.getAlias() + ".dsTorihikiServiceKanris";
    }
}
