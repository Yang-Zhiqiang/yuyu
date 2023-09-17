package yuyu.def.biz.file.excel;

import jp.co.slcs.swak.file.description.excel.annotations.Head;

/**
 * （共通）ＡＥＯＩ情報テーブルレイアウトファイル データレイアウトのBeanクラスでimport jp.co.slcs.swak.file.description.excel.annotations.Head;
書きしないよう注意して下さい。
 */
@Head(sheet = "IT_AeoiInfo", labelbgcolor = "GREY_25_PERCENT")
public class BzAeoiInfoLayoutFile extends GenBzAeoiInfoLayoutFile {

    private static final long serialVersionUID = 1L;

    public BzAeoiInfoLayoutFile() {
    }

}
