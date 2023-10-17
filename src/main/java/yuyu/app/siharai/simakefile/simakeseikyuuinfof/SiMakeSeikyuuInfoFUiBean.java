package yuyu.app.siharai.simakefile.simakeseikyuuinfof;

import java.util.List;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.def.db.entity.JV_SeikyuuInfo;

/**
 * 請求情報ファイル作成 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SiMakeSeikyuuInfoFUiBean extends GenSiMakeSeikyuuInfoFUiBean {

    private static final long serialVersionUID = 1L;

    private List<JV_SeikyuuInfo> seikyuuinfoList;

    public SiMakeSeikyuuInfoFUiBean() {
    }

    public List<JV_SeikyuuInfo> getSeikyuuInfoList() {
        return seikyuuinfoList;
    }

    public void setSeikyuuInfoList(List<JV_SeikyuuInfo> pSeikyuuInfoList) {
        seikyuuinfoList = pSeikyuuInfoList;
    }

}
