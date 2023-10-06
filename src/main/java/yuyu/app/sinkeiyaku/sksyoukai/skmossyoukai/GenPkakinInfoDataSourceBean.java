package yuyu.app.sinkeiyaku.sksyoukai.skmossyoukai;

import java.io.Serializable;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_HenkinriyuuKbn;

/**
 * 申込状況照会 - ●Ｐ過金情報 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenPkakinInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizCurrency disppkakingk;

    public BizCurrency getDisppkakingk() {
        return disppkakingk;
    }

    public void setDisppkakingk(BizCurrency pDisppkakingk) {
        disppkakingk = pDisppkakingk;
    }


    private BizCurrency disppkakindengkyen;

    public BizCurrency getDisppkakindengkyen() {
        return disppkakindengkyen;
    }

    public void setDisppkakindengkyen(BizCurrency pDisppkakindengkyen) {
        disppkakindengkyen = pDisppkakindengkyen;
    }


    private BizDate disppkakinsyoriymd;

    public BizDate getDisppkakinsyoriymd() {
        return disppkakinsyoriymd;
    }

    public void setDisppkakinsyoriymd(BizDate pDisppkakinsyoriymd) {
        disppkakinsyoriymd = pDisppkakinsyoriymd;
    }


    private C_HenkinriyuuKbn disppkakinhnknriyuu;

    public C_HenkinriyuuKbn getDisppkakinhnknriyuu() {
        return disppkakinhnknriyuu;
    }

    public void setDisppkakinhnknriyuu(C_HenkinriyuuKbn pDisppkakinhnknriyuu) {
        disppkakinhnknriyuu = pDisppkakinhnknriyuu;
    }

}
