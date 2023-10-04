package yuyu.batch.hozen.khinterf.khyuukouseikekkaftrkm.dba;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 インターフェイス 有効性確認結果データBean<br />
 */
@AllArgsConstructor
public class YuukouKakKekkaDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String ztrcreditkessaiyouno;

    @Getter @Setter
    private String ztrcardno;

    @Getter @Setter
    private String ztrcardyuukoukigen;

    @Getter @Setter
    private String ztryuukouhanteikekka;

    @Getter @Setter
    private String  ztrcreditkigyoucd;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
