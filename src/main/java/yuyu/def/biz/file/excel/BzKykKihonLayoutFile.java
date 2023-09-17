package yuyu.def.biz.file.excel;

import jp.co.slcs.swak.file.description.excel.annotations.Head;

/**
 * （共通）契約基本テーブルレイアウトファイル データレイアウトのBeanクラスです。import jp.co.slcs.swak.file.description.excel.annotations.Head;
しないよう注意して下さい。
 */
@Head(sheet = "IT_KykKihon", labelbgcolor = "GREY_25_PERCENT")
public class BzKykKihonLayoutFile extends GenBzKykKihonLayoutFile {

    private static final long serialVersionUID = 1L;

    public BzKykKihonLayoutFile() {
    }

}
