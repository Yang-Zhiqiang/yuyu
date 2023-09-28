package yuyu.common.biz.kaikei.dba4bzsikinidouhanteiinfosyutoku;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_GkhnkzidourtKbn;
import yuyu.def.classification.C_HijynnykzndkkouzaKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_UmuKbn;

/**
 * 業務共通 経理・会計 資金移動判定情報取得Beanクラス
 */
@AllArgsConstructor
public class SikinIdouHanteiInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private C_Segcd segCd;

    @Getter
    @Setter
    private C_HijynnykzndkkouzaKbn hijynnykZndkkouzaKbn;

    @Getter
    @Setter
    private C_GkhnkzidourtKbn fstpGkhnkzidouRt;

    @Getter
    @Setter
    private C_GkhnkzidourtKbn zenkiZennouGkhnkzidouRt;

    @Getter
    @Setter
    private C_GkhnkzidourtKbn keizokupGkhnkzidouRt;

    @Getter
    @Setter
    private C_UmuKbn seiymdSeitstuityouhnknUmu;

    @Getter
    @Setter
    private C_UmuKbn zeiseiTekikakuUmu;

    @Getter
    @Setter
    private C_UmuKbn itijibrUmu;

    @Getter
    @Setter
    private C_UmuKbn sbHkuktUmu;

    @Getter
    @Setter
    private C_UmuKbn sbKyuuhukinuktUmu;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
