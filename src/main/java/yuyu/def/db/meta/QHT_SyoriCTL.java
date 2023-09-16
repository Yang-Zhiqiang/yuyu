package yuyu.def.db.meta;

/**
 * 処理コントロールテーブル のエンティティメタデータクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class QHT_SyoriCTL extends GenQHT_SyoriCTL {

    public QHT_SyoriCTL() {
    }

    public QHT_SyoriCTL(String pAlias) {
        super(pAlias);
    }

    public String HT_MosDairiten(){
        return this.getAlias() + ".mosDairitens";
    }
}
