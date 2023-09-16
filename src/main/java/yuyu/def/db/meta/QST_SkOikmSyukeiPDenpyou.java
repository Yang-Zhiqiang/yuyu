package yuyu.def.db.meta;

/**
 * 新契約追込保険料伝票データテーブル のエンティティメタデータクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class QST_SkOikmSyukeiPDenpyou extends GenQST_SkOikmSyukeiPDenpyou {

    public QST_SkOikmSyukeiPDenpyou() {
    }

    public QST_SkOikmSyukeiPDenpyou(String pAlias) {
        super(pAlias);
    }

    public String BM_KanjyouKamoku(){
        return this.getAlias() + ".kanjyouKamoku";
    }
    public String BM_Segment(){
        return this.getAlias() + ".segment";
    }

}
