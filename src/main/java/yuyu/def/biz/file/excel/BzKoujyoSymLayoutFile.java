package yuyu.def.biz.file.excel;

import jp.co.slcs.swak.file.description.excel.annotations.Head;

/**
 * （共通）控除証明書テーブルレイアウトファイル データレイアウトのBeanクラスです。import jp.co.slcs.swak.file.description.excel.annotations.Head;
しないよう注意して下さい。
 */
@Head(sheet = "IT_KoujyoSym", labelbgcolor = "GREY_25_PERCENT")
public class BzKoujyoSymLayoutFile extends GenBzKoujyoSymLayoutFile {

    private static final long serialVersionUID = 1L;

    public BzKoujyoSymLayoutFile() {
    }

}
