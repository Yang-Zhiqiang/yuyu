package yuyu.def.db.meta;

/**
 * ＤＳ送金用口座テーブル のエンティティメタデータクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class QMT_DsSoukinyouKouza extends GenQMT_DsSoukinyouKouza {

    public QMT_DsSoukinyouKouza() {
    }

    public QMT_DsSoukinyouKouza(String pAlias) {
        super(pAlias);
    }

    public String BM_Ginkou() {
        return this.getAlias() + ".ginkou";
    }

}
