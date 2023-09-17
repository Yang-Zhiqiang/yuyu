package yuyu.def.biz.file.csv;

import jp.co.slcs.swak.file.description.text.csv.annotations.Head;
import yuyu.def.YuyuStandardCharsets;

/**
 * （共通）外貨建保険明細ＣＳＶＦファイル データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@Head(strictQuotes = true, labelless = false, newlineCode = "\r\n", encoding = YuyuStandardCharsets.WINDOWS_31J_STRING)
public class BzGaikaHokenMeisaiCsvfFile extends GenBzGaikaHokenMeisaiCsvfFile {

    private static final long serialVersionUID = 1L;

    public BzGaikaHokenMeisaiCsvfFile() {
    }

}
