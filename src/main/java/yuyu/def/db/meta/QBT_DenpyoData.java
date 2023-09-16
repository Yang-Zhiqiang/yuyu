package yuyu.def.db.meta;

/**
 * 経理伝票データテーブル のエンティティメタデータクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class QBT_DenpyoData extends GenQBT_DenpyoData {

    public QBT_DenpyoData() {
    }

    public QBT_DenpyoData(String pAlias) {
        super(pAlias);
    }

    public String IT_NyuukinKakusyouData(){
        return this.getAlias() + ".nyuukinKakusyouData";
    }

}
