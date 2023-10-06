package yuyu.batch.biz.sysbatch.bzdeleteprocessandjbpmrecord;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
/**
 * 工程履歴・ＪＢＰＭデータ削除バッチパラメータBEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@BatchScoped
public class BzDeleteProcessAndJBPMRecordBatchParam extends GenBzDeleteProcessAndJBPMRecordBatchParam {

    private static final long serialVersionUID = 1L;

    private String skjtsjygnkensuu;

    public BzDeleteProcessAndJBPMRecordBatchParam() {
    }

    public String getSkjtsjygnkensuu() {
        return skjtsjygnkensuu;
    }

    public void setSkjtsjygnkensuu(String pSkjtsjygnkensuu) {
        skjtsjygnkensuu = pSkjtsjygnkensuu;
    }

}
