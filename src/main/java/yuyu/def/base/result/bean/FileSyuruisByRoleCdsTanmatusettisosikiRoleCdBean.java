package yuyu.def.base.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_FileSyuruiCdKbn;

/**
 * ファイル種類基幹テーブルエンティティBeanクラスです。<br />
 */
@AllArgsConstructor
public class FileSyuruisByRoleCdsTanmatusettisosikiRoleCdBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private C_FileSyuruiCdKbn fileSyuruiCd;

    @Getter @Setter
    private String fileSyuruiNm;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
