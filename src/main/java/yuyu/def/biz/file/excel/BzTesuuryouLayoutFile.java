package yuyu.def.biz.file.excel;

import jp.co.slcs.swak.file.description.excel.annotations.Head;

/**
 * （共通）手数料情報テーブルレイアウトファイル データレイアウトのBeanクラスです。import jp.co.slcs.swak.file.description.excel.annotations.Head;
しないよう注意して下さい。
 */
@Head(sheet = "IT_Tesuuryou", labelbgcolor = "GREY_25_PERCENT")
public class BzTesuuryouLayoutFile extends GenBzTesuuryouLayoutFile {

    private static final long serialVersionUID = 1L;

    public BzTesuuryouLayoutFile() {
    }

}
