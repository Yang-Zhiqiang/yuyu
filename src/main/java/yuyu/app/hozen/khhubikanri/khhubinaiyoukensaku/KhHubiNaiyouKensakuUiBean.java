package yuyu.app.hozen.khhubikanri.khhubinaiyoukensaku;

import java.util.List;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.def.db.entity.IM_KhHubiNaiyou;

/**
 * 契約保全不備内容検索 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class KhHubiNaiyouKensakuUiBean extends GenKhHubiNaiyouKensakuUiBean {

    private static final long serialVersionUID = 1L;

    private List<IM_KhHubiNaiyou> khHubiNaiyouList;

    public KhHubiNaiyouKensakuUiBean() {

        UserDefsList udList = new UserDefsList();

        super.setJimuttdknmOptionBeanList(udList);
    }

    public List<IM_KhHubiNaiyou> getKhHubiNaiyouList() {
        return khHubiNaiyouList;
    }

    public void setKhHubiNaiyouList(List<IM_KhHubiNaiyou> pKhHubiNaiyouList) {
        this.khHubiNaiyouList = pKhHubiNaiyouList;
    }
}
