package yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshijynbrshr.dba;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 業務共通 経理･会計 減額開始年月前後保険料抽出BEAN
 */
@AllArgsConstructor
public class GengkKaisiYmZengoPTysytBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String bfrNaiyou;

    @Getter @Setter
    private String newNaiyou;

    @Getter @Setter
    private BizDateYM tmttknTaisyouYm;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}