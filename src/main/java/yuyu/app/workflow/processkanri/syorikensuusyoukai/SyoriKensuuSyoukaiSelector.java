package yuyu.app.workflow.processkanri.syorikensuusyoukai;

/**
 * 処理件数照会 JavaScript(jQuery)用の 画面項目Selector 定数定義クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class SyoriKensuuSyoukaiSelector extends GenSyoriKensuuSyoukaiSelector {

    public static final String SYOUSAILINK = "'#syousaiLink'";

    public static final String SYOUSAILINKTASK = "'#syousaiLinkTask'";

    public static final String KANRYOKENSUU_TASKUSERINFO3_UNIT(int index) {
        return "'#taskuserInfo3\\\\[" + index + "\\\\]\\\\.kanryoKensuuUnit'";
    }


}
