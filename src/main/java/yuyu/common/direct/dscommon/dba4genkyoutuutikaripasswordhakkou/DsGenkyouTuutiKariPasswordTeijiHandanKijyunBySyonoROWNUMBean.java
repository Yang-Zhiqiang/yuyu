package yuyu.common.direct.dscommon.dba4genkyoutuutikaripasswordhakkou;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_DsKokyakuJtKbn;
import yuyu.def.classification.C_DsKrHnnKakCdSetKbn;
import yuyu.def.classification.C_DsTeisiRiyuuKbn;
import yuyu.def.classification.C_MukouHyj;

/**
 * ＤＳ現況通知用仮パスワード提示判断基準Beanクラスです。<br />
 */
@AllArgsConstructor
public class DsGenkyouTuutiKariPasswordTeijiHandanKijyunBySyonoROWNUMBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String dskrhnnkakcd;

    @Getter @Setter
    private String zenkaidskrhnnkakcd;

    @Getter @Setter
    private BizDate dskrhnnkakcdyuukouymd;

    @Getter @Setter
    private C_MukouHyj dskykmukouhyj;

    @Getter @Setter
    private C_DsKokyakuJtKbn dskokyakujtkbn;

    @Getter @Setter
    private C_DsTeisiRiyuuKbn dsteisiriyuukbn;

    @Getter @Setter
    private String dskokno;

    @Getter @Setter
    private C_DsKrHnnKakCdSetKbn dskrhnnkakcdsetkbn;

    @Getter @Setter
    private BizDate dskokyakuseiymd;

    @Getter @Setter
    private String tsintelno;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}