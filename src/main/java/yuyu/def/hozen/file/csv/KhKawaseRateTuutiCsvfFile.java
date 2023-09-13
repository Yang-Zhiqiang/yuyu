package yuyu.def.hozen.file.csv;

import jp.co.slcs.swak.file.description.text.csv.annotations.Head;
import yuyu.def.YuyuStandardCharsets;

/**
 * （保全）為替レート通知ＣＳＶＦファイル データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@Head(strictQuotes = false, labelless = false, newlineCode = "\r\n", separator = ',', encoding = YuyuStandardCharsets.WINDOWS_31J_STRING)
public class KhKawaseRateTuutiCsvfFile extends GenKhKawaseRateTuutiCsvfFile {

    private static final long serialVersionUID = 1L;

    public KhKawaseRateTuutiCsvfFile() {
    }

}
