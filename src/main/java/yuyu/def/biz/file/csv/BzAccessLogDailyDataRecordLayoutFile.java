package yuyu.def.biz.file.csv;

import jp.co.slcs.swak.file.description.text.csv.annotations.Head;
/**
 * （共通）アクセスログ（日次）（データレコード）レイアウトファイル データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@Head(strictQuotes = true, labelless = false, newlineCode = "\r\n", encoding = "UTF-8", separator = ',')
public class BzAccessLogDailyDataRecordLayoutFile extends GenBzAccessLogDailyDataRecordLayoutFile {

    private static final long serialVersionUID = 1L;

    public BzAccessLogDailyDataRecordLayoutFile() {
    }

}
