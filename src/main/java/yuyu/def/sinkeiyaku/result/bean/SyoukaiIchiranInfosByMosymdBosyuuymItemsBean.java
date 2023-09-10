package yuyu.def.sinkeiyaku.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 照会一覧情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class SyoukaiIchiranInfosByMosymdBosyuuymItemsBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String mosno;

    @Getter @Setter
    private C_KykKbn kykkbn;

    @Getter @Setter
    private String kyknmkn;

    @Getter @Setter
    private String kyknmkj;

    @Getter @Setter
    private String hhknnmkn;

    @Getter @Setter
    private String hhknnmkj;

    @Getter @Setter
    private BizDate kykseiymd;

    @Getter @Setter
    private BizDate hhknseiymd;

    @Getter @Setter
    private C_HknsyuruiNo hknsyuruino;

    @Getter @Setter
    private C_UmuKbn kktnrkumu;

    @Getter @Setter
    private C_UmuKbn nyknnrkumu;

    @Getter @Setter
    private C_UmuKbn kthhbkbn;

    @Getter @Setter
    private C_UmuKbn srhhbkbn;

    @Getter @Setter
    private C_UmuKbn khnhbkbn;

    @Getter @Setter
    private C_KetteiKbn ketteikbn;

    @Getter @Setter
    private C_SeirituKbn seiritukbn;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
