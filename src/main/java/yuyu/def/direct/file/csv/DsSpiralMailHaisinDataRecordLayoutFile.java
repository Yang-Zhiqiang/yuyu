package yuyu.def.direct.file.csv;

import jp.co.slcs.swak.file.description.text.csv.annotations.Head;

/**
 * （ダイレクト）ＳＰＩＲＡＬメール配信ファイル（データレコード）レイアウトファイル データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@Head(strictQuotes = false, labelless = true, newlineCode = "\r\n", encoding = "Shift_jis", separator = '\t')
public class DsSpiralMailHaisinDataRecordLayoutFile extends GenDsSpiralMailHaisinDataRecordLayoutFile {

    private static final long serialVersionUID = 1L;

    public DsSpiralMailHaisinDataRecordLayoutFile() {
    }

}
