package yuyu.def.siharai.file.fixedlength;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Head;
import yuyu.def.YuyuStandardCharsets;

/**
 * （支払）書類イメージ情報ファイル（明細レコード）レイアウトファイル データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@Head(newlineCode="\n" ,encoding=YuyuStandardCharsets.WINDOWS_31J_STRING)
public class SiSyrImageInfoMeisaiLayoutFile extends GenSiSyrImageInfoMeisaiLayoutFile {

    private static final long serialVersionUID = 1L;

    public SiSyrImageInfoMeisaiLayoutFile() {
    }

}
