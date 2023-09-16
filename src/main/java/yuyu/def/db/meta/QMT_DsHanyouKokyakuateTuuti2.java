package yuyu.def.db.meta;

/**
 * ＤＳ汎用顧客宛通知２テーブル のエンティティメタデータクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class QMT_DsHanyouKokyakuateTuuti2 extends GenQMT_DsHanyouKokyakuateTuuti2 {

    public QMT_DsHanyouKokyakuateTuuti2() {
    }

    public QMT_DsHanyouKokyakuateTuuti2(String pAlias) {
        super(pAlias);
    }

    public String MT_DsHanyouKokTuutiError(){
        return this.getAlias() + ".dsHanyouKokTuutiErrors";
    }
}
