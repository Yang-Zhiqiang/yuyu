package yuyu.common.siharai.siedittyouhyou;

import java.io.Serializable;
import java.util.List;

import yuyu.def.db.entity.JM_SiTyouhyoumsg;

/**
 * 保険金給付金支払 保険金給付金支払帳票編集 提出書類一覧Bean
 */
public class TeisyutusyoruiItiranBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<JM_SiTyouhyoumsg> teisyutuShorui;

    private List<JM_SiTyouhyoumsg> chuuiJiko;

    public List<JM_SiTyouhyoumsg> getTeisyutuShorui() {
        return teisyutuShorui;
    }

    public void setTeisyutuShorui(List<JM_SiTyouhyoumsg> pTeisyutuShorui) {
        this.teisyutuShorui = pTeisyutuShorui;
    }

    public List<JM_SiTyouhyoumsg> getChuuiJiko() {
        return chuuiJiko;
    }

    public void setChuuiJiko(List<JM_SiTyouhyoumsg> pChuuiJiko) {
        this.chuuiJiko = pChuuiJiko;
    }
}
