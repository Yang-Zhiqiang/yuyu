package yuyu.def.hozen.file.csv;

import jp.co.slcs.swak.file.description.text.csv.annotations.Head;
import yuyu.def.YuyuStandardCharsets;

/**
 * （保全）早期解約データファイル（レイアウト） データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@Head(strictQuotes = false, labelless = true, newlineCode = "\r\n", encoding = YuyuStandardCharsets.WINDOWS_31J_STRING)
public class KhSoukiKaiyakuDataLayoutFile extends GenKhSoukiKaiyakuDataLayoutFile {

    private static final long serialVersionUID = 1L;

    public KhSoukiKaiyakuDataLayoutFile() {
    }

}
