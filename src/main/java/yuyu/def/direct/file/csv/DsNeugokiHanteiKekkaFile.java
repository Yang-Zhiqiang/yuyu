package yuyu.def.direct.file.csv;

import jp.co.slcs.swak.file.description.text.csv.annotations.Head;
import yuyu.def.YuyuStandardCharsets;

/**
 * （ダイレクト）値動き判定結果ファイル データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@Head(strictQuotes = false, labelless = false, newlineCode = "\r\n", encoding = YuyuStandardCharsets.WINDOWS_31J_STRING, separator = ',')
public class DsNeugokiHanteiKekkaFile extends GenDsNeugokiHanteiKekkaFile {

    private static final long serialVersionUID = 1L;

    public DsNeugokiHanteiKekkaFile() {
    }

}
