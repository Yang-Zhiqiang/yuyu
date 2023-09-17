package yuyu.def.biz.file.csv;

import jp.co.slcs.swak.file.description.text.csv.annotations.Head;

/**
 * （共通）統計アクセスログ（データレコード）レイアウトファイル データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@Head(strictQuotes = true, labelless = false, newlineCode = "\r\n", encoding = "UTF-8", separator = ',')
public class BzToukeiAccessLogDataRecordLayoutFile extends GenBzToukeiAccessLogDataRecordLayoutFile {

    private static final long serialVersionUID = 1L;

    public BzToukeiAccessLogDataRecordLayoutFile() {
    }

}
