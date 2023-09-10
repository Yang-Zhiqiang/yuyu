package yuyu.def.sinkeiyaku.file.csv;

import jp.co.slcs.swak.file.description.text.csv.annotations.Head;
import yuyu.def.YuyuStandardCharsets;

/**
 * （新契約）ＮＩＴペーパーレス不備ＣＳＶファイル データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@Head(newlineCode = "\r\n", encoding = YuyuStandardCharsets.SHIFT_JIS_STRING, strictQuotes = true, labelless = true)
public class SkNitPplessHubiCsvFile extends GenSkNitPplessHubiCsvFile {

    private static final long serialVersionUID = 1L;

    public SkNitPplessHubiCsvFile() {
    }

}
