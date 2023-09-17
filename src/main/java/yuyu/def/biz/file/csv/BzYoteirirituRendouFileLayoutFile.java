package yuyu.def.biz.file.csv;

import jp.co.slcs.swak.file.description.text.csv.annotations.Head;

/**
 * （共通）予定利率連動ファイルレイアウトファイル データレイアウトのBeanクラスです。<br />
 *import jp.co.slcs.swak.file.description.text.csv.annotations.Head;

 */
@Head(strictQuotes = false, labelless = true, newlineCode = "\r\n", encoding = "Shift-JIS")
public class BzYoteirirituRendouFileLayoutFile extends GenBzYoteirirituRendouFileLayoutFile {

    private static final long serialVersionUID = 1L;

    public BzYoteirirituRendouFileLayoutFile() {
    }

}
