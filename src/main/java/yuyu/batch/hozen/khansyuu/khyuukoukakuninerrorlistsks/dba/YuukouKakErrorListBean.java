package yuyu.batch.hozen.khansyuu.khyuukoukakuninerrorlistsks.dba;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Yuukoukakkekka;

/**
 * 有効確認エラーリスト作成Beanクラスです。<br />
 */
@AllArgsConstructor
public class YuukouKakErrorListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private String creditkessaiyouno;

    @Getter @Setter
    private BizDateYM credityuukoukakym;

    @Getter @Setter
    private C_Yuukoukakkekka credityuukoukakkekka;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
